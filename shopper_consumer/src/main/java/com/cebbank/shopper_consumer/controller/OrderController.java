package com.cebbank.shopper_consumer.controller;

import com.cebbank.common.pojo.Order;
import com.cebbank.common.pojo.OrderStatus;
import com.cebbank.common.pojo.UserAddr;
import com.cebbank.common.pojo.ProductDetail;
import com.cebbank.common.pojo.UserShoppingCart;
import com.cebbank.shopper_consumer.service.MqService;
import com.cebbank.shopper_consumer.service.OrderService;
import com.cebbank.shopper_consumer.service.UserAddrService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yanzhishuo
 * @create 2020-11-16-15:13
 */
@Controller
public class OrderController {
    @Autowired
    private UserAddrService userAddrService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MqService mqService;

    @RequestMapping(value = {"/userorder/success"})
    public String pay(){
        //支付操作,未完成

        return "success";
    }
    @RequestMapping("/userorder")
    public String queryAllOrder(Model model){
        return "orders";
    }


    @ResponseBody
    @RequestMapping("/userorder/order/list")
    public void orderList(HttpServletResponse resp) throws IOException {
        List<Map<String,Object>> orders = orderService.findOrdersByUserLoginId(1);
        System.out.println("显示用户订单界面");
        System.out.println(orders);

        resp.setContentType("application/json;charset=utf-8");
        Gson gson = new Gson();
        String s = gson.toJson(orders);
        PrintWriter out = resp.getWriter();
        System.out.println(s);
        out.println(s);
        out.close();
    }

    @ResponseBody
    @RequestMapping("/userorder/order/dilvery")
    public void dilveryOrders(HttpServletRequest request,HttpServletResponse resp ) throws IOException {
        Integer orderId=Integer.parseInt(request.getParameter("orderId"));
        Integer orderStatus=Integer.parseInt(request.getParameter("orderstatus"));
        orderService.modifyOrderstatusByOrderId(orderId, orderStatus);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();
        String date0 =sdf.format(date);
        Order order = new Order();
        order.setOrderUpdateTime(date0);
        order.setOrderStatus(orderStatus);
        List<Map<String, Object>> ordersByUserLoginId = orderService.findOrdersByUserLoginId(1);
        resp.setContentType("application/json;charset=utf-8");
        Gson gson = new Gson();
        String s = gson.toJson(ordersByUserLoginId);
        PrintWriter out = resp.getWriter();
        out.println(s);
        out.close();
    }

    //lsf部分
    /**
     *功能：确认订单
     * 显示地址并进行选择 ，同时显示购物车中选中的购物项数据，计算总价
     * */
    @RequestMapping("/cart/confirmorder")
    public String confirmOrder(Model model)
    {
        //根据token拿到当前登录用户的id
        Integer userLoginId=1;
        //查询登录用户的所有收货地址
        List<UserAddr> userAddrList=userAddrService.queryUserAddrs(userLoginId);
        model.addAttribute("userAddrList",userAddrList);

        //购物车id集合(从琦子前端传来)
        List<Integer> cartIds=new ArrayList<>();
        cartIds.add(1);
        cartIds.add(2);

        //查询购物车
        List<UserShoppingCart> cartList=orderService.getSelectedCarts(userLoginId,cartIds);

        //当前价格总计
        double sum=0;
        for(int i=0;i<cartList.size();i++)
        {
            ProductDetail productDetail=cartList.get(i).getProductDetail();
            if(productDetail!=null){
                sum+=cartList.get(i).getUserShoppingCartProductNum()*productDetail.getProductDetailPrice();
            }
        }
        model.addAttribute("money",sum);
        model.addAttribute("cartList",cartList);
        model.addAttribute("cartIds",cartIds);
        return "/order/confirmOrder";
    }

    /**
     *功能：下单
     * 将选中的购物项生成订单，并进行支付
     * */
    @RequestMapping("/cart/placeOrder")
    public String placeOrder(Double money, String cartIds,String userAddrId, Model model){
        //根据token拿到当前登录用户的id
        System.out.println("用户地址id"+userAddrId);
        Integer userLoginId=1;
        if (cartIds.length()>=3)
        {
            List<Integer> cartIdsList=new ArrayList<>();
            String[] ids=cartIds.substring(1,cartIds.length()-1).split(",");
            for (int i=0;i<ids.length;i++)
            {
                cartIdsList.add(Integer.parseInt(ids[i].trim()));
            }
            //创建订单
            OrderStatus orderStatus=orderService.createOrder(userLoginId,Integer.parseInt(userAddrId),cartIdsList);
            if (orderStatus==OrderStatus.UnderStock)
            {
                model.addAttribute("msg","商品库存不足！");
                return "/order/error";
            }else if (orderStatus==OrderStatus.Fail)
            {
                model.addAttribute("msg","下单失败！");
                return "/order/error";
            }
            model.addAttribute("money",money);
        }
        //通知商家有人下单
        mqService.notifySellerOrder("有人提交订单了！");
        return "/order/pay";
    }
}
