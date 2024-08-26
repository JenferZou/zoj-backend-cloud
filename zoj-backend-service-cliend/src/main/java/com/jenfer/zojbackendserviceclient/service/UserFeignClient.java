package com.jenfer.zojbackendserviceclient.service;

import com.jenfer.zojbackendcommon.common.ErrorCode;
import com.jenfer.zojbackendcommon.exception.BusinessException;
import com.jenfer.zojbackendmodel.entity.User;
import com.jenfer.zojbackendmodel.enums.UserRoleEnum;
import com.jenfer.zojbackendmodel.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static com.jenfer.zojbackendcommon.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 
 */
@FeignClient(name = "zoj-backend-user-service",path = "/api/user/inner")
public interface UserFeignClient {


    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    User getById(@RequestParam("userId") long userId);


    /**
     * 根据id获取用户列表
     * @param idList
     * @return
     */
    @GetMapping("/get/ids")
    List<User> listByIds(Collection<Long> idList);


    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    default User getLoginUser(HttpServletRequest request) {
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        // 可以考虑在这里做全局权限校验
        return currentUser;

    }




    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
   default boolean isAdmin(User user) {
       return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());

   }

   default UserVO getUserVo(User user){
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }






}
