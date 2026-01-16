package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class ChannelInfoFromServer {
    public AvatarFileInline avatar_thumbnail;
    public String channel_guid;
    public String channel_title;
    public ChannelTypeEnum channel_type;
    public ChatReactionSetting chat_reaction_setting;
    public long count_members;
    public String description;
    public boolean is_deleted;
    public boolean is_verified;
    public String share_url;
    public boolean sign_messages;
    public long updated_time;
    public String username;
    public WarningObject warning_info;

    public enum ChannelTypeEnum {
        Public,
        Private
    }
}
