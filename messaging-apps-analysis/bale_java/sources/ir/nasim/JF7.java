package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;
import ai.bale.proto.PresenceOuterClass$UpdateTyping;
import ir.nasim.EnumC5360Iz7;

/* loaded from: classes5.dex */
public final class JF7 implements InterfaceC14123hO3 {
    private final U25 a;

    public JF7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IF7 a(PresenceOuterClass$UpdateTyping presenceOuterClass$UpdateTyping) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateTyping, "input");
        if (!presenceOuterClass$UpdateTyping.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = presenceOuterClass$UpdateTyping.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        int uid = presenceOuterClass$UpdateTyping.getUid();
        EnumC5360Iz7.a aVar = EnumC5360Iz7.a;
        EnumC5025Ho5 typingType = presenceOuterClass$UpdateTyping.getTypingType();
        AbstractC13042fc3.h(typingType, "getTypingType(...)");
        return new IF7(c11458d25A, uid, aVar.b(typingType));
    }
}
