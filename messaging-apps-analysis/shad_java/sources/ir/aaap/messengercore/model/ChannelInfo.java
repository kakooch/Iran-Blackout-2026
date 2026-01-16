package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ChannelInfo {
    public String channel_guid;
    public ChannelInfoFromServer.ChannelTypeEnum channel_type;
    public ChatReactionSetting chat_reaction_setting;
    public long count_members;
    public String description;
    public long insertedToDbTime;
    public String share_url;
    public boolean sign_messages;
    public String username;
    public WarningObject warning_info;

    public static ChannelInfo createFromServerObject(ChannelInfoFromServer channelInfoFromServer) {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.channel_guid = channelInfoFromServer.channel_guid;
        channelInfo.count_members = channelInfoFromServer.count_members;
        channelInfo.description = channelInfoFromServer.description;
        channelInfo.username = channelInfoFromServer.username;
        channelInfo.insertedToDbTime = channelInfoFromServer.updated_time;
        channelInfo.share_url = channelInfoFromServer.share_url;
        channelInfo.warning_info = channelInfoFromServer.warning_info;
        channelInfo.sign_messages = channelInfoFromServer.sign_messages;
        channelInfo.channel_type = channelInfoFromServer.channel_type;
        channelInfo.chat_reaction_setting = channelInfoFromServer.chat_reaction_setting;
        return channelInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelInfo)) {
            return false;
        }
        ChannelInfo channelInfo = (ChannelInfo) obj;
        return this.count_members == channelInfo.count_members && this.insertedToDbTime == channelInfo.insertedToDbTime && this.sign_messages == channelInfo.sign_messages && Objects.equals(this.channel_guid, channelInfo.channel_guid) && Objects.equals(this.description, channelInfo.description) && Objects.equals(this.username, channelInfo.username) && Objects.equals(this.share_url, channelInfo.share_url) && Objects.equals(this.warning_info, channelInfo.warning_info) && this.channel_type == channelInfo.channel_type && getClass().getDeclaredFields().length == 9;
    }

    public int hashCode() {
        return Objects.hash(this.channel_guid, Long.valueOf(this.count_members), this.description, this.username, Long.valueOf(this.insertedToDbTime), this.share_url, this.warning_info, Boolean.valueOf(this.sign_messages), this.channel_type);
    }
}
