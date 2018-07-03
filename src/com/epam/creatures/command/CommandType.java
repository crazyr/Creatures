package com.epam.creatures.command;


import com.epam.creatures.command.admincommand.*;
import com.epam.creatures.command.usercommand.UserAuthorizationCommand;
import com.epam.creatures.command.usercommand.UserRegistrationCommand;
import com.epam.creatures.service.*;
import com.epam.creatures.service.adminservice.*;
import com.epam.creatures.service.userservice.ToUserMainPageService;
import com.epam.creatures.service.userservice.UserAuthorizationService;
import com.epam.creatures.service.userservice.UserRegistrationService;

public enum CommandType {
    ADMIN_AUTHORIZATION_COMMAND(new AdminAuthorizationCommand(new AdminAuthorizationService())),

    CREATE_CREATURE_COMMAND(new CreateCreatureCommand(new CreateCreatureService())),

    CREATE_ADMIN_COMMAND(new CreateAdminCommand(new CreateAdminService())),

    SHOW_CREATURES_COMMAND(new ShowCreaturesCommand(new ShowCreaturesService())),

    SHOW_USERS_COMMAND(new ShowUsersCommand(new ShowUsersService())),

    USER_AUTHORIZATION_COMMAND(new UserAuthorizationCommand(new UserAuthorizationService())),

    USER_REGISTRATION_COMMAND(new UserRegistrationCommand(new UserRegistrationService())),

    TO_ADMIN_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminAuthorizationPageService())),

    TO_USER_AUTHORIZATION_PAGE_COMMAND(new ToAnyPageCommand(new ToUserAuthorizationPageService())),

    TO_USER_REGISTRATION_PAGE_COMMAND(new ToAnyPageCommand(new ToUserRegistrationPageService())),

    TO_START_PAGE_COMMAND(new ToAnyPageCommand(new ToStartPageService())),

    LOG_OUT_COMMAND(new LogOutCommand(new LogOutService())),

    TO_CREATE_CREATURE_PAGE_COMMAND(new ToAnyPageCommand(new ToCreateCreaturePageService())),

    TO_CREATE_ADMIN_PAGE_COMMAND(new ToAnyPageCommand(new ToCreateAdminPageService())),

    TO_ADMIN_MAIN_PAGE_COMMAND(new ToAnyPageCommand(new ToAdminMainPageService())),

    TO_USER_MAIN_PAGE_COMMAND(new ToAnyPageCommand(new ToUserMainPageService())),

    TO_UPDATE_CREATURE_PAGE_COMMAND(new ToUpdateCreaturePageCommand(new ToUpdateCreaturePageService())),

    DELETE_CREATURE_COMMAND(new DeleteCreatureCommand(new DeleteCreatureService())),

    UPDATE_CREATURE_COMMAND(new UpdateCreatureCommand(new UpdateCreatureService())),

    CHANGE_USER_BANNED_COMMAND(new ChangeUserBannedCommand(new ChangeUserBannedService())),


    ;

    private AbstractCommand command;

    CommandType(AbstractCommand command){
        this.command = command;
    }

    public AbstractCommand getCommand(){
        return command;
    }
}
