package ir.nasim;

import ai.bale.proto.PeersStruct$ExInfo;

/* renamed from: ir.nasim.Ux, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8187Ux implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C7714Sx a(PeersStruct$ExInfo peersStruct$ExInfo) {
        AbstractC13042fc3.i(peersStruct$ExInfo, "input");
        return new C7714Sx(EnumC9196Yx.p(peersStruct$ExInfo.getExPeerType().getNumber()), EnumC23583xA.p(peersStruct$ExInfo.getPeerIdentity().getNumber()), peersStruct$ExInfo.getPeerCategory().getValue());
    }
}
