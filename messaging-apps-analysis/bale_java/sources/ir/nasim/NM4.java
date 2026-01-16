package ir.nasim;

import ai.bale.proto.PeersStruct$OutExPeer;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class NM4 implements InterfaceC14123hO3 {
    private final FZ6 a;

    public NM4(FZ6 fz6) {
        AbstractC13042fc3.i(fz6, "mapper");
        this.a = fz6;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExPeer a(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        AbstractC13042fc3.i(peersStruct$OutExPeer, "proto");
        FZ6 fz6 = this.a;
        EnumC10088b35 type = peersStruct$OutExPeer.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        return new ExPeer(fz6.a(type), peersStruct$OutExPeer.getId());
    }
}
