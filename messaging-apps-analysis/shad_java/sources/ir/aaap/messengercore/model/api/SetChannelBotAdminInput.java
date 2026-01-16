package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.api.SetGroupAdminInput;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SetChannelBotAdminInput {
    public ArrayList<Chat.EnumSetChannelAdminAccess> access_list;
    public SetGroupAdminInput.AdminActionEnum action;
    public String bot_guid;
    public String channel_guid;
}
