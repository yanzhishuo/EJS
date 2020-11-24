$(function () {
    $("#jqGrid").jqGrid({
        url: '/shopemp/products/list',
        datatype: "json",
        colModel: [
            {label: '编号', name: 'productDetailId', index: 'productDetailId', width: 60, key: true},
            {label: '商品名称', name: 'product.productName', index: 'product.productName', width: 100},
            {label: '商品简介', name: 'product.productDesc', index: 'product.productDesc', width: 120},
            {label: '商品属性', name: 'productPropertyValue', index: 'productPropertyValue', width: 120},
            {
                label: '商品图片',
                name: 'product.productImage',
                index: 'product.productImage',
                width: 80,
                formatter: coverImageFormatter(name)
            },
            {label: '库存', name: 'productDetailStock', index: 'productDetailStock', width: 60},
            {label: '售价', name: 'productDetailPrice', index: 'productDetailPrice', width: 60},
            {
                label: '商品状态',
                name: 'productDetailStatus',
                index: 'productDetailStatus',
                width: 80,
                formatter: productSellStatusFormatter
            },
            {label: '创建时间', name: 'productDetailCreateTime', index: 'productDetailCreateTime', width: 100}
        ],
        height: 580,
        rowNum: 10,
        rowList: [10, 15, 20],
        styleUI: 'Bootstrap',
        loadtext: '信息读取中...',
        rownumbers: false,
        rownumWidth: 20,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order",
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });

    $(window).resize(function () {
        $("#jqGrid").setGridWidth($(".card-body").width());
    });

    function productSellStatusFormatter(cellvalue) {
        //商品状态 1-待审核，2-上架，3-下架
        if (cellvalue == 1) {
            return "<button type=\"button\" class=\"btn btn-block btn-info btn-sm\" style=\"width: 80%;\">待审核</button>";
        }
        if (cellvalue == 2) {
            return "<button type=\"button\" class=\"btn btn-block btn-success btn-sm\" style=\"width: 80%;\">销售中</button>";
        }
        if (cellvalue == 3) {
            return "<button type=\"button\" class=\"btn btn-block btn-secondary btn-sm\" style=\"width: 80%;\">已下架</button>";
        }
    }

    function coverImageFormatter(cellvalue) {
        return "<img src='" + cellvalue + "' height=\"80\" width=\"80\" alt='商品主图'/>";
    }

});

/**
 * jqGrid重新加载
 */
function reload() {
    initFlatPickr();
    var page = $("#jqGrid").jqGrid('getGridParam', 'page');
    $("#jqGrid").jqGrid('setGridParam', {
        page: page
    }).trigger("reloadGrid");
}

/**
 * 添加商品
 */
function addProduct() {
    window.location.href = "/shopemp/product/add";
}

/**
 * 添加商品属性
 */
function addProductProperty() {
    window.location.href = "/shopemp/product/addproperty";
}


/**
 * 修改商品
 */
function editProduct() {
    var id = getSelectedRow();
    if (id == null) {
        return;
    }
    window.location.href = "/shopemp/product/edit/" + id;
}


/**
 * 上架
 */
function putUpGoods() {
    // var s = [[${session.user.shopEmpRoleName}]];
    var id = getSelectedRows();
    if (id == null) {
        return;
    }
    // swal({
    //     title: "确认弹框",
    //     text: "确认要执行上架操作吗?",
    //     icon: "warning",
    //     buttons: true,
    //     dangerMode: true,
    // }).then((flag) => {
    //         if (flag) {
    //             $.ajax({
    //                 type: "PUT",
    //                 url: "/admin/goods/status/0",
    //                 contentType: "application/json",
    //                 data: JSON.stringify(ids),
    //                 success: function (r) {
    //                     if (r.resultCode == 200) {
    //                         swal("上架成功", {
    //                             icon: "success",
    //                         });
    //                         $("#jqGrid").trigger("reloadGrid");
    //                     } else {
    //                         swal(r.message, {
    //                             icon: "error",
    //                         });
    //                     }
    //                 }
    //             });
    //         }
    //     }
    // )
    // ;
    window.location.href = "/shopemp/product/onsale/" + id;
}

/**
 * 下架
 */
function putDownGoods() {
    var id = getSelectedRows();
    if (id == null) {
        return;
    }
    // swal({
    //     title: "确认弹框",
    //     text: "确认要执行下架操作吗?",
    //     icon: "warning",
    //     buttons: true,
    //     dangerMode: true,
    // }).then((flag) => {
    //         if (flag) {
    //             $.ajax({
    //                 type: "PUT",
    //                 url: "/admin/goods/status/1",
    //                 contentType: "application/json",
    //                 data: JSON.stringify(ids),
    //                 success: function (r) {
    //                     if (r.resultCode == 200) {
    //                         swal("下架成功", {
    //                             icon: "success",
    //                         });
    //                         $("#jqGrid").trigger("reloadGrid");
    //                     } else {
    //                         swal(r.message, {
    //                             icon: "error",
    //                         });
    //                     }
    //                 }
    //             });
    //         }
    //     }
    // )
    // ;
    window.location.href = "/shopemp/product/offsale/" + id;
}