package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EditGroupInfoInput {
    public GroupInfoFromServer.ChatHistoryForNewMembers chat_history_for_new_members;
    public ChatReactionSetting chat_reaction_setting;
    public String description;
    public boolean event_messages;
    public String group_guid;
    public int slow_mode;
    public String title;
    public ArrayList<String> updated_parameters;
}
