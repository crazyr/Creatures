package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;

import java.util.Map;

/**
 * The type To change creature image page service.
 */
public class ToChangeCreatureImagePageService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_CHANGE_CREATURE_IMAGE_PAGE));
    }
}
