package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.Xx, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8941Xx implements InterfaceC14123hO3 {
    private final FZ6 a;

    public C8941Xx(FZ6 fz6) {
        AbstractC13042fc3.i(fz6, "expeerTypeMapper");
        this.a = fz6;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExPeer a(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "input");
        FZ6 fz6 = this.a;
        EnumC10088b35 type = peersStruct$ExPeer.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        return new ExPeer(fz6.a(type), peersStruct$ExPeer.getId());
    }
}
