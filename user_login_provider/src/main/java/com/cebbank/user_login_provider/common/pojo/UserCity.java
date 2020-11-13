package com.cebbank.user_login_provider.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *
 * @author ${lsf}
 * @since 2020-11-12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserCity {
    /**
     * 城市id
     */
    private Integer userCityId;
    /**
     * 城市名称
     */
    private String userCityName;
    /**
     * 父级城市id
     */
    private Integer userCityParentId;

//    private String userCityCreateTime;
//
//    private String userCityUpdateTime;

    /**
     * 1正常；0删除
     */
    private Integer userCityStatus;
}
