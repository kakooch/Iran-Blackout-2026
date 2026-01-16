package ir.nasim;

import ai.bale.proto.MeetOuterClass$UpdateCallReactionSent;
import ai.bale.proto.PeersStruct$OutExPeer;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class NC7 implements InterfaceC14123hO3 {
    private final NM4 a;

    public NC7(NM4 nm4) {
        AbstractC13042fc3.i(nm4, "mapper");
        this.a = nm4;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MC7 a(MeetOuterClass$UpdateCallReactionSent meetOuterClass$UpdateCallReactionSent) {
        AbstractC13042fc3.i(meetOuterClass$UpdateCallReactionSent, "proto");
        NM4 nm4 = this.a;
        PeersStruct$OutExPeer sender = meetOuterClass$UpdateCallReactionSent.getSender();
        AbstractC13042fc3.h(sender, "getSender(...)");
        ExPeer exPeerA = nm4.a(sender);
        NM4 nm42 = this.a;
        PeersStruct$OutExPeer peer = meetOuterClass$UpdateCallReactionSent.getPeer();
        AbstractC13042fc3.h(peer, "getPeer(...)");
        ExPeer exPeerA2 = nm42.a(peer);
        String reaction = meetOuterClass$UpdateCallReactionSent.getReaction();
        AbstractC13042fc3.h(reaction, "getReaction(...)");
        return new MC7(exPeerA, exPeerA2, reaction);
    }
}
