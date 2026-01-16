package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageSent;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class XE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public XE7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WE7 a(MessagingOuterClass$UpdateMessageSent messagingOuterClass$UpdateMessageSent) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageSent, "input");
        if (!messagingOuterClass$UpdateMessageSent.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageSent.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new WE7(u25.a(peer), messagingOuterClass$UpdateMessageSent.getRid(), messagingOuterClass$UpdateMessageSent.getDate(), messagingOuterClass$UpdateMessageSent.hasPreviousMessageId() ? C18732p92.a.D0(messagingOuterClass$UpdateMessageSent.getPreviousMessageId()) : null);
    }
}
