package ir.nasim;

import ai.bale.proto.MessagingOuterClass$UpdateChatClear;
import ai.bale.proto.PeersStruct$Peer;

/* loaded from: classes5.dex */
public final class ZC7 implements InterfaceC14123hO3 {
    private final U25 a;

    public ZC7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public YC7 a(MessagingOuterClass$UpdateChatClear messagingOuterClass$UpdateChatClear) {
        AbstractC13042fc3.i(messagingOuterClass$UpdateChatClear, "proto");
        U25 u25 = this.a;
        PeersStruct$Peer peer = messagingOuterClass$UpdateChatClear.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        return new YC7(u25.a(peer));
    }
}
