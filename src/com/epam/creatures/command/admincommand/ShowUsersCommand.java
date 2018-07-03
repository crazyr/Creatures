package com.epam.creatures.command.admincommand;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class ShowUsersCommand extends AbstractCommand {
    public ShowUsersCommand(CommandService service) {
        super(service);
    }

    public ShowUsersCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) throws ServletException, IOException {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.setAttribute(AttributeConstant.USER_LIST_ATTRIBUTE,attributeMap.get(AttributeConstant.USER_LIST_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}
