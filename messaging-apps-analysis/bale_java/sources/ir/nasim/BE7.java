package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMentionReadByMe;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* loaded from: classes5.dex */
public final class BE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AE7 a(MessagingOuterClass$UpdateMentionReadByMe messagingOuterClass$UpdateMentionReadByMe) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMentionReadByMe, "input");
        if (messagingOuterClass$UpdateMentionReadByMe.hasMessageId()) {
            MessageIdentifier messageIdentifier = new MessageIdentifier(messagingOuterClass$UpdateMentionReadByMe.getMessageId().getRid(), messagingOuterClass$UpdateMentionReadByMe.getMessageId().getDate(), messagingOuterClass$UpdateMentionReadByMe.getMessageId().getSeq());
            if (messagingOuterClass$UpdateMentionReadByMe.hasPeer()) {
                return new AE7(messageIdentifier, new ExPeer(ExPeerType.fromValue(messagingOuterClass$UpdateMentionReadByMe.getPeer().getTypeValue()), messagingOuterClass$UpdateMentionReadByMe.getPeer().getId()));
            }
        }
        return null;
    }
}
