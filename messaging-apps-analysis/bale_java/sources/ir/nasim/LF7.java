package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;
import ai.bale.proto.PresenceOuterClass$UpdateTypingStop;
import ir.nasim.EnumC5360Iz7;

/* loaded from: classes5.dex */
public final class LF7 implements InterfaceC14123hO3 {
    private final U25 a;

    public LF7(U25 u25) {
        AbstractC13042fc3.i(u25, "peerStructToPeerMapper");
        this.a = u25;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public KF7 a(PresenceOuterClass$UpdateTypingStop presenceOuterClass$UpdateTypingStop) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateTypingStop, "input");
        if (!presenceOuterClass$UpdateTypingStop.hasPeer()) {
            return null;
        }
        U25 u25 = this.a;
        PeersStruct$Peer peer = presenceOuterClass$UpdateTypingStop.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        C11458d25 c11458d25A = u25.a(peer);
        int uid = presenceOuterClass$UpdateTypingStop.getUid();
        EnumC5360Iz7.a aVar = EnumC5360Iz7.a;
        EnumC5025Ho5 typingType = presenceOuterClass$UpdateTypingStop.getTypingType();
        AbstractC13042fc3.h(typingType, "getTypingType(...)");
        return new KF7(c11458d25A, uid, aVar.b(typingType));
    }
}
