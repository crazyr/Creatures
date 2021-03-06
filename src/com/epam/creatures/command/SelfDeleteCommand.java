package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Self delete command.
 */
public class SelfDeleteCommand extends AbstractCommand {
    /**
     * Instantiates a new Self delete command.
     *
     * @param service the service
     */
    public SelfDeleteCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Self delete command.
     */
    public SelfDeleteCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.USER_ID_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ID_ATTRIBUTE)));
        parameterMap.put(ParameterConstant.ROLE_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE)));

        getService().process(parameterMap,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}
