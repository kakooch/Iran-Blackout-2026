package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageReceived;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class VE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public VE7(U25 u25) {
        AbstractC13042fc3.i(u25, "mapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UE7 a(MessagingOuterClass$UpdateMessageReceived messagingOuterClass$UpdateMessageReceived) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageReceived, "proto");
        if (!messagingOuterClass$UpdateMessageReceived.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageReceived.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new UE7(u25.a(peer), messagingOuterClass$UpdateMessageReceived.getStartDate(), messagingOuterClass$UpdateMessageReceived.getReceivedDate());
    }
}
