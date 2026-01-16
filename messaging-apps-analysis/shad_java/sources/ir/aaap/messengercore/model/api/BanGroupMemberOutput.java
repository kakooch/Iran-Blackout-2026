package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.MessageUpdateObject;

/* loaded from: classes3.dex */
public class BanGroupMemberOutput {
    public ChatUpdateObject chat_update;
    public GroupInfoFromServer group;
    public GroupCallModels.GroupVoiceChatParticipantUpdate group_voice_chat_participate_update;
    public GroupCallModels.GroupVoiceChatUpdate group_voice_chat_update;
    public MessageUpdateObject message_update;
    public long timestamp;
}
