package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Change user sort type command.
 */
public class ChangeUserSortTypeCommand extends AbstractCommand {
    /**
     * Instantiates a new Change user sort type command.
     *
     * @param service the service
     */
    public ChangeUserSortTypeCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Change user sort type command.
     */
    public ChangeUserSortTypeCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.getSession().setAttribute(AttributeConstant.SORT_USER_ATTRIBUTE,request.getParameter(ParameterConstant.SORT_USER_PARAMETER));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}
