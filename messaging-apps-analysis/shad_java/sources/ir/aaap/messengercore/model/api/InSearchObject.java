package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.OnlineTimeObject;
import ir.aaap.messengercore.model.UserInfo;

/* loaded from: classes3.dex */
public class InSearchObject {
    public AvatarFileInline avatar_thumbnail;
    public long count_members;
    public String first_name;
    public boolean is_deleted;
    public boolean is_verified;
    public transient OnlineTimeObject lastOnline;
    public String last_name;
    public String object_guid;
    public transient String searchMatchName;
    public long timeStamp;
    public String title;
    public ChatType type;
    public String username;

    public static InSearchObject createFromUserInfoAndAbs(UserInfo userInfo, ChatAbsObject chatAbsObject) {
        if (userInfo != null) {
            return createFromAbs(chatAbsObject, userInfo.online_time, 0L);
        }
        return createFromAbs(chatAbsObject, null, 0L);
    }

    public static InSearchObject createFromObjectInfoAndAbs(ObjectInfo objectInfo, ChatAbsObject chatAbsObject) {
        if (objectInfo != null) {
            return createFromAbs(chatAbsObject, objectInfo.getOnlineTime(), objectInfo.getCountMember());
        }
        return createFromAbs(chatAbsObject, null, 0L);
    }

    public static InSearchObject createFromAbs(ChatAbsObject chatAbsObject, OnlineTimeObject onlineTimeObject, long j) {
        InSearchObject inSearchObject = new InSearchObject();
        if (chatAbsObject == null) {
            return inSearchObject;
        }
        inSearchObject.object_guid = chatAbsObject.object_guid;
        inSearchObject.type = chatAbsObject.type;
        inSearchObject.title = chatAbsObject.title;
        inSearchObject.first_name = chatAbsObject.first_name;
        inSearchObject.last_name = chatAbsObject.last_name;
        inSearchObject.avatar_thumbnail = chatAbsObject.avatar_thumbnail;
        inSearchObject.is_verified = chatAbsObject.is_verified;
        inSearchObject.is_deleted = chatAbsObject.is_deleted;
        inSearchObject.lastOnline = onlineTimeObject;
        inSearchObject.count_members = j;
        inSearchObject.timeStamp = chatAbsObject.timeStamp;
        return inSearchObject;
    }
}
