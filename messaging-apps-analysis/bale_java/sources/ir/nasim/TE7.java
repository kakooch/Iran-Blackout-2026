package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateMessageRead;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class TE7 implements InterfaceC14123hO3 {
    private final U25 a;

    public TE7(U25 u25) {
        AbstractC13042fc3.i(u25, "mapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QE7 a(MessagingOuterClass$UpdateMessageRead messagingOuterClass$UpdateMessageRead) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateMessageRead, "proto");
        if (!messagingOuterClass$UpdateMessageRead.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateMessageRead.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new QE7(u25.a(peer), messagingOuterClass$UpdateMessageRead.getStartDate(), messagingOuterClass$UpdateMessageRead.getReadDate());
    }
}
