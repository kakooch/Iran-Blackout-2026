package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.api.BotInfoFromServer;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ChatAbsObject {
    public AvatarFileInline avatar_thumbnail;
    public String first_name;
    public boolean is_deleted;
    public boolean is_verified;
    public String last_name;
    public String object_guid;
    public long timeStamp;
    public String title;
    public ChatType type;

    public void setTimeStampIfNotSet(long j) {
        if (this.timeStamp == 0) {
            this.timeStamp = j;
        }
    }

    public static ChatAbsObject createFromGuidAndType(String str, ChatType chatType, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = chatType;
        chatAbsObject.object_guid = str;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromServiceInfo(ServiceInfoFromServer serviceInfoFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = ChatType.Service;
        chatAbsObject.object_guid = serviceInfoFromServer.service_guid;
        chatAbsObject.title = serviceInfoFromServer.service_title;
        chatAbsObject.avatar_thumbnail = serviceInfoFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = serviceInfoFromServer.is_verified;
        chatAbsObject.is_deleted = serviceInfoFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromBotInfo(BotInfoFromServer botInfoFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = ChatType.Bot;
        chatAbsObject.object_guid = botInfoFromServer.bot_guid;
        chatAbsObject.title = botInfoFromServer.bot_title;
        chatAbsObject.avatar_thumbnail = botInfoFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = botInfoFromServer.is_verified;
        chatAbsObject.is_deleted = botInfoFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromGroupInfo(GroupInfoFromServer groupInfoFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = ChatType.Group;
        chatAbsObject.object_guid = groupInfoFromServer.group_guid;
        chatAbsObject.title = groupInfoFromServer.group_title;
        chatAbsObject.avatar_thumbnail = groupInfoFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = groupInfoFromServer.is_verified;
        chatAbsObject.is_deleted = groupInfoFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromChannelInfo(ChannelInfoFromServer channelInfoFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = ChatType.Channel;
        chatAbsObject.object_guid = channelInfoFromServer.channel_guid;
        chatAbsObject.title = channelInfoFromServer.channel_title;
        chatAbsObject.avatar_thumbnail = channelInfoFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = channelInfoFromServer.is_verified;
        chatAbsObject.is_deleted = channelInfoFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromUserInfo(UserInfoFromServer userInfoFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = ChatType.User;
        chatAbsObject.object_guid = userInfoFromServer.user_guid;
        chatAbsObject.first_name = userInfoFromServer.first_name;
        chatAbsObject.last_name = userInfoFromServer.last_name;
        chatAbsObject.avatar_thumbnail = userInfoFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = userInfoFromServer.is_verified;
        chatAbsObject.is_deleted = userInfoFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromInChatMember(InChatMemberFromServer inChatMemberFromServer, long j) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        chatAbsObject.type = inChatMemberFromServer.member_type;
        chatAbsObject.object_guid = inChatMemberFromServer.member_guid;
        chatAbsObject.first_name = inChatMemberFromServer.first_name;
        chatAbsObject.last_name = inChatMemberFromServer.last_name;
        chatAbsObject.avatar_thumbnail = inChatMemberFromServer.avatar_thumbnail;
        chatAbsObject.is_verified = inChatMemberFromServer.is_verified;
        chatAbsObject.is_deleted = inChatMemberFromServer.is_deleted;
        chatAbsObject.timeStamp = j;
        return chatAbsObject;
    }

    public static ChatAbsObject createFromInSearchObject(InSearchObject inSearchObject) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        if (inSearchObject == null) {
            return chatAbsObject;
        }
        chatAbsObject.object_guid = inSearchObject.object_guid;
        chatAbsObject.type = inSearchObject.type;
        chatAbsObject.title = inSearchObject.title;
        chatAbsObject.first_name = inSearchObject.first_name;
        chatAbsObject.last_name = inSearchObject.last_name;
        chatAbsObject.avatar_thumbnail = inSearchObject.avatar_thumbnail;
        chatAbsObject.is_verified = inSearchObject.is_verified;
        chatAbsObject.is_deleted = inSearchObject.is_deleted;
        chatAbsObject.timeStamp = inSearchObject.timeStamp;
        return chatAbsObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatAbsObject)) {
            return false;
        }
        ChatAbsObject chatAbsObject = (ChatAbsObject) obj;
        return this.is_verified == chatAbsObject.is_verified && this.is_deleted == chatAbsObject.is_deleted && Objects.equals(this.object_guid, chatAbsObject.object_guid) && Objects.equals(this.title, chatAbsObject.title) && Objects.equals(this.avatar_thumbnail, chatAbsObject.avatar_thumbnail) && this.type == chatAbsObject.type && Objects.equals(this.first_name, chatAbsObject.first_name) && Objects.equals(this.last_name, chatAbsObject.last_name) && Objects.equals(Long.valueOf(this.timeStamp), Long.valueOf(chatAbsObject.timeStamp)) && getClass().getDeclaredFields().length == 9;
    }

    public int hashCode() {
        return Objects.hash(this.object_guid, this.title, this.avatar_thumbnail, this.type, this.first_name, this.last_name, Boolean.valueOf(this.is_verified), Boolean.valueOf(this.is_deleted));
    }
}
