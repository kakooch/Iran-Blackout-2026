package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.ChatReactionSetting;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EditChannelInput {
    public String channel_guid;
    public ChannelInfoFromServer.ChannelTypeEnum channel_type;
    public ChatReactionSetting chat_reaction_setting;
    public String description;
    public boolean sign_messages;
    public String title;
    public ArrayList<String> updated_parameters;
}
