package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageReadByMe;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class SE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public SE7(U25 u25) {
        AbstractC13042fc3.i(u25, "mapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RE7 a(MessagingOuterClass$UpdateMessageReadByMe messagingOuterClass$UpdateMessageReadByMe) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageReadByMe, "proto");
        if (!messagingOuterClass$UpdateMessageReadByMe.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageReadByMe.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new RE7(u25.a(peer), messagingOuterClass$UpdateMessageReadByMe.getStartDate(), messagingOuterClass$UpdateMessageReadByMe.hasUnreadCounter() ? Integer.valueOf(messagingOuterClass$UpdateMessageReadByMe.getUnreadCounter().getValue()) : null, messagingOuterClass$UpdateMessageReadByMe.hasEndDate() ? Long.valueOf(messagingOuterClass$UpdateMessageReadByMe.getEndDate().getValue()) : null);
    }
}
