package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.GroupCallModels;

/* loaded from: classes3.dex */
public class BanChannelMemberOutput {
    public ChannelInfoFromServer channel;
    public GroupCallModels.GroupVoiceChatParticipantUpdate group_voice_chat_participate_update;
    public GroupCallModels.GroupVoiceChatUpdate group_voice_chat_update;
    public long timestamp;
}
