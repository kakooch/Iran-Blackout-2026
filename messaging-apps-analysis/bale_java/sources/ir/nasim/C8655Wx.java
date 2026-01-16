package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;

/* renamed from: ir.nasim.Wx, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8655Wx implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C8421Vx a(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "input");
        return new C8421Vx(EnumC9196Yx.p(peersStruct$ExPeer.getTypeValue()), peersStruct$ExPeer.getId(), peersStruct$ExPeer.getAccessHash());
    }
}
