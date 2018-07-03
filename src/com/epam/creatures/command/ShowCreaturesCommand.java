package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class ShowCreaturesCommand extends AbstractCommand {

    public ShowCreaturesCommand(CommandService service) {
        super(service);
    }

    public ShowCreaturesCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) throws ServletException, IOException {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.ROLE_PARAMETER,request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE).toString());

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.CREATURE_LIST_ATTRIBUTE,attributeMap.get(AttributeConstant.CREATURE_LIST_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}
