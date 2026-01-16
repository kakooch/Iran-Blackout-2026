package ir.nasim;

import ai.bale.proto.UsersOuterClass$UpdateUserBotCommandsChanged;
import ai.bale.proto.UsersStruct$BotCommand;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class TF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SF7 a(UsersOuterClass$UpdateUserBotCommandsChanged usersOuterClass$UpdateUserBotCommandsChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserBotCommandsChanged, "input");
        int uid = usersOuterClass$UpdateUserBotCommandsChanged.getUid();
        List<UsersStruct$BotCommand> commandsList = usersOuterClass$UpdateUserBotCommandsChanged.getCommandsList();
        AbstractC13042fc3.h(commandsList, "getCommandsList(...)");
        List<UsersStruct$BotCommand> list = commandsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (UsersStruct$BotCommand usersStruct$BotCommand : list) {
            String slashCommand = usersStruct$BotCommand.getSlashCommand();
            AbstractC13042fc3.h(slashCommand, "getSlashCommand(...)");
            String description = usersStruct$BotCommand.getDescription();
            AbstractC13042fc3.h(description, "getDescription(...)");
            arrayList.add(new C24488yi0(slashCommand, description, usersStruct$BotCommand.hasLocKey() ? usersStruct$BotCommand.getLocKey().getValue() : null));
        }
        return new SF7(uid, arrayList);
    }
}
