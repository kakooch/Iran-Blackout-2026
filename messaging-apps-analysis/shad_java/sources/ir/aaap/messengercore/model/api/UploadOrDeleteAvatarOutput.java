package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.MessageUpdateObject;
import ir.aaap.messengercore.model.UserInfoFromServer;

/* loaded from: classes3.dex */
public class UploadOrDeleteAvatarOutput {
    public ChannelInfoFromServer channel;
    public ChatUpdateObject chat_update;
    public GroupInfoFromServer group;
    public MessageUpdateObject message_update;
    public ChatType object_type;
    public long timestamp;
    public UserInfoFromServer user;
}
