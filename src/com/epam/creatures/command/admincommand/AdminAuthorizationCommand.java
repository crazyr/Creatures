package com.epam.creatures.command.admincommand;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class AdminAuthorizationCommand extends AbstractCommand {
    public AdminAuthorizationCommand(CommandService service) {
        super(service);
    }

    public AdminAuthorizationCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) throws ServletException, IOException {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();
        parameterMap.put(ParameterConstant.LOGIN_PARAMETER, request.getParameter(ParameterConstant.LOGIN_PARAMETER));
        parameterMap.put(ParameterConstant.PASSWORD_PARAMETER, request.getParameter(ParameterConstant.PASSWORD_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.getSession().setAttribute(AttributeConstant.LOGIN_ATTRIBUTE,attributeMap.get(AttributeConstant.LOGIN_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.ROLE_ATTRIBUTE,attributeMap.get(AttributeConstant.ROLE_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.AVATAR_ATTRIBUTE,attributeMap.get(AttributeConstant.AVATAR_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.ID_ATTRIBUTE,attributeMap.get(AttributeConstant.ID_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}