package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateChatDelete;
import ai.bale.proto.PeersStruct$Peer;

/* renamed from: ir.nasim.bD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10187bD7 implements InterfaceC14123hO3 {
    private final U25 a;

    public C10187bD7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C9593aD7 a(MessagingOuterClass$UpdateChatDelete messagingOuterClass$UpdateChatDelete) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateChatDelete, "proto");
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateChatDelete.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new C9593aD7(u25.a(peer));
    }
}
