package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class InChatMemberFromServer {
    public AvatarFileInline avatar_thumbnail;
    public long count_common_groups;
    public String custom_title;
    public String first_name;
    public boolean is_deleted;
    public boolean is_verified;
    public JoinTypeEnum join_type;
    public String last_name;
    public long last_online;
    public String member_guid;
    public ChatType member_type;
    public OnlineTimeObject online_time;
    public ChatAbsObject promoted_by_absObject;
    public String promoted_by_object_guid;
    public String removed_by_object_guid;
    public ChatType removed_by_object_type;
    public String title;
    public String username;

    public enum JoinTypeEnum {
        Creator,
        Admin,
        Member,
        None
    }
}
