package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ShowCreaturesCommand extends AbstractCommand {

    public ShowCreaturesCommand(ProjectService service) {
        super(service);
    }

    public ShowCreaturesCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.ROLE_PARAMETER,request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE).toString());
        parameterMap.put(ParameterConstant.USER_ID_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ID_ATTRIBUTE)));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.CREATURE_LIST_ATTRIBUTE,attributeMap.get(AttributeConstant.CREATURE_LIST_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}
