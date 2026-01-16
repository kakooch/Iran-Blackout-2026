package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class GroupInfoFromServer {
    public AvatarFileInline avatar_thumbnail;
    public ChatHistoryForNewMembers chat_history_for_new_members;
    public ChatReactionSetting chat_reaction_setting;
    public long count_members;
    public String description;
    public boolean event_messages;
    public String group_guid;
    public String group_title;
    public boolean is_deleted;
    public boolean is_verified;
    public int slow_mode;
    public long updated_time;
    public WarningObject warning_info;

    public enum ChatHistoryForNewMembers {
        Visible,
        Hidden
    }
}
