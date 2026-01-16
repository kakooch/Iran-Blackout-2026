package ir.aaap.messengercore.model;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ObjectInfo {
    public BotInfo botInfo;
    public ChannelInfo channelInfo;
    public GroupInfo groupInfo;
    public long insertedToDbTime;
    public String objectGuid;
    public ChatType objectType;
    public ServiceInfo serviceInfo;
    public UserInfo userInfo;

    public static ObjectInfo createFromServiceInfo(ServiceInfo serviceInfo) {
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.objectGuid = serviceInfo.service_guid;
        objectInfo.serviceInfo = serviceInfo;
        objectInfo.objectType = ChatType.Service;
        objectInfo.insertedToDbTime = serviceInfo.insertedToDbTime;
        return objectInfo;
    }

    public static ObjectInfo createFromBotInfo(BotInfo botInfo) {
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.objectGuid = botInfo.bot_guid;
        objectInfo.botInfo = botInfo;
        objectInfo.objectType = ChatType.Bot;
        objectInfo.insertedToDbTime = botInfo.insertedToDbTime;
        return objectInfo;
    }

    public static ObjectInfo createFromGroupInfo(GroupInfo groupInfo) {
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.objectGuid = groupInfo.group_guid;
        objectInfo.groupInfo = groupInfo;
        objectInfo.objectType = ChatType.Group;
        objectInfo.insertedToDbTime = groupInfo.insertedToDbTime;
        return objectInfo;
    }

    public static ObjectInfo createFromChannelInfo(ChannelInfo channelInfo) {
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.objectGuid = channelInfo.channel_guid;
        objectInfo.channelInfo = channelInfo;
        objectInfo.objectType = ChatType.Channel;
        objectInfo.insertedToDbTime = channelInfo.insertedToDbTime;
        return objectInfo;
    }

    public static ObjectInfo createFromUserInfo(UserInfo userInfo) {
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.objectGuid = userInfo.user_guid;
        objectInfo.userInfo = userInfo;
        objectInfo.objectType = ChatType.User;
        objectInfo.insertedToDbTime = userInfo.insertedToDbTime;
        return objectInfo;
    }

    public static ArrayList<ObjectInfo> createFromUserInfoArray(ArrayList<UserInfo> arrayList) {
        ArrayList<ObjectInfo> arrayList2 = new ArrayList<>();
        Iterator<UserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(createFromUserInfo(it.next()));
        }
        return arrayList2;
    }

    public String getUserName() {
        BotInfo botInfo;
        ChannelInfo channelInfo;
        UserInfo userInfo;
        ChatType chatType = this.objectType;
        if (chatType == ChatType.User && (userInfo = this.userInfo) != null) {
            return userInfo.username;
        }
        if (chatType == ChatType.Channel && (channelInfo = this.channelInfo) != null) {
            return channelInfo.username;
        }
        if (chatType != ChatType.Bot || (botInfo = this.botInfo) == null) {
            return null;
        }
        return botInfo.username;
    }

    public OnlineTimeObject getOnlineTime() {
        UserInfo userInfo;
        if (this.objectType != ChatType.User || (userInfo = this.userInfo) == null) {
            return null;
        }
        return userInfo.online_time;
    }

    public long getCountMember() {
        ChannelInfo channelInfo;
        GroupInfo groupInfo;
        ChatType chatType = this.objectType;
        if (chatType == ChatType.Group && (groupInfo = this.groupInfo) != null) {
            return groupInfo.count_members;
        }
        if (chatType != ChatType.Channel || (channelInfo = this.channelInfo) == null) {
            return 0L;
        }
        return channelInfo.count_members;
    }
}
