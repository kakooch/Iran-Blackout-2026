package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.BotCommandObject;
import ir.aaap.messengercore.model.api.BotInfoFromServer;
import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BotInfo {
    public String bot_guid;
    public ArrayList<BotCommandObject> commands;
    public String description;
    public long insertedToDbTime;
    public String share_url;
    public String start_message;
    public String username;
    public WarningObject warning_info;

    public static BotInfo createFromServerObject(BotInfoFromServer botInfoFromServer) {
        BotInfo botInfo = new BotInfo();
        botInfo.bot_guid = botInfoFromServer.bot_guid;
        botInfo.description = botInfoFromServer.description;
        botInfo.username = botInfoFromServer.username;
        botInfo.start_message = botInfoFromServer.start_message;
        botInfo.warning_info = botInfoFromServer.warning_info;
        botInfo.share_url = botInfoFromServer.share_url;
        botInfo.commands = botInfoFromServer.commands;
        return botInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BotInfo)) {
            return false;
        }
        BotInfo botInfo = (BotInfo) obj;
        return this.insertedToDbTime == botInfo.insertedToDbTime && Objects.equals(this.bot_guid, botInfo.bot_guid) && Objects.equals(this.description, botInfo.description) && Objects.equals(this.username, botInfo.username) && Objects.equals(this.start_message, botInfo.start_message) && Objects.equals(this.warning_info, botInfo.warning_info) && Objects.equals(this.share_url, botInfo.share_url) && Objects.equalsArray(this.commands, botInfo.commands);
    }
}
