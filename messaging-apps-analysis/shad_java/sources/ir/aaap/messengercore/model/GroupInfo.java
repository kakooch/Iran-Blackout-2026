package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class GroupInfo {
    public GroupInfoFromServer.ChatHistoryForNewMembers chat_history_for_new_members;
    public ChatReactionSetting chat_reaction_setting;
    public long count_members;
    public String description;
    public boolean event_messages;
    public String group_guid;
    public long insertedToDbTime;
    public int slow_mode;
    public WarningObject warning_info;

    public static GroupInfo createFromServerObject(GroupInfoFromServer groupInfoFromServer) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.group_guid = groupInfoFromServer.group_guid;
        groupInfo.count_members = groupInfoFromServer.count_members;
        groupInfo.warning_info = groupInfoFromServer.warning_info;
        groupInfo.slow_mode = groupInfoFromServer.slow_mode;
        groupInfo.description = groupInfoFromServer.description;
        groupInfo.chat_history_for_new_members = groupInfoFromServer.chat_history_for_new_members;
        groupInfo.event_messages = groupInfoFromServer.event_messages;
        groupInfo.chat_reaction_setting = groupInfoFromServer.chat_reaction_setting;
        return groupInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupInfo)) {
            return false;
        }
        GroupInfo groupInfo = (GroupInfo) obj;
        return this.count_members == groupInfo.count_members && this.insertedToDbTime == groupInfo.insertedToDbTime && this.slow_mode == groupInfo.slow_mode && this.event_messages == groupInfo.event_messages && Objects.equals(this.group_guid, groupInfo.group_guid) && Objects.equals(this.warning_info, groupInfo.warning_info) && Objects.equals(this.description, groupInfo.description) && this.chat_history_for_new_members == groupInfo.chat_history_for_new_members && getClass().getDeclaredFields().length == 8;
    }

    public int hashCode() {
        return Objects.hash(this.group_guid, Long.valueOf(this.count_members), Long.valueOf(this.insertedToDbTime), this.warning_info, Integer.valueOf(this.slow_mode), this.description, this.chat_history_for_new_members, Boolean.valueOf(this.event_messages));
    }
}
