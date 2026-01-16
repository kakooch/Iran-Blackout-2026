package ir.nasim;

import ai.bale.proto.PeersStruct$Peer;

/* renamed from: ir.nasim.zA, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24763zA implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C22993wA a(PeersStruct$Peer peersStruct$Peer) {
        AbstractC13042fc3.i(peersStruct$Peer, "input");
        return new C22993wA(CA.p(peersStruct$Peer.getType().getNumber()), peersStruct$Peer.getId());
    }
}
