package com.epam.creatures.service.admin;

import com.epam.creatures.action.UserListSorter;
import com.epam.creatures.constant.*;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;
import com.epam.creatures.service.ShowCreaturesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * The type Show users service.
 */
public class ShowUsersService implements ProjectService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserDao userDAO = new UserDao();
        RouterFactory routerFactory = new RouterFactory();
        UserListSorter userListSorter = new UserListSorter();
        parameterMap.putIfAbsent(ParameterConstant.SORT_USER_PARAMETER, UserListSorter.UserSortType.BY_LOGIN.toString());
        UserListSorter.UserSortType sortType = UserListSorter.UserSortType.valueOf(parameterMap.get(ParameterConstant.SORT_USER_PARAMETER));

        try {
            List<User> userList = userDAO.findAll();
            userList.forEach(user -> {

                if(user.getAvatar()!=null){
                    user.setEncodedAvatar(Base64.getEncoder().encodeToString(user.getAvatar()));
                }
            });
            userListSorter.sortUserList(userList,sortType);
            attributeMap.put(AttributeConstant.USER_LIST_ATTRIBUTE,userList);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,PagePath.USERS_FOR_ADMIN_PAGE));
        } catch (DaoException e) {
            LOGGER.error("Can not show all users.",e);
        }
    }
}
