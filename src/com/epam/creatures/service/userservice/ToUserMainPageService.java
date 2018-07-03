package com.epam.creatures.service.userservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class ToUserMainPageService implements CommandService {
    private RouterFactory routerFactory = new RouterFactory();
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.USER_MAIN_PAGE));
    }
}
