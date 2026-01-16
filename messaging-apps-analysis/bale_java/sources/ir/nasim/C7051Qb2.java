package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.Qb2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7051Qb2 implements InterfaceC14123hO3 {
    private final C7519Sb2 a;

    public C7051Qb2(C7519Sb2 c7519Sb2) {
        AbstractC13042fc3.i(c7519Sb2, "exPeerTypeMapper");
        this.a = c7519Sb2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeersStruct$ExPeer a(ExPeer exPeer) {
        AbstractC13042fc3.i(exPeer, "input");
        PeersStruct$ExPeer.a aVarB = PeersStruct$ExPeer.newBuilder().B(exPeer.getPeerId());
        C7519Sb2 c7519Sb2 = this.a;
        ExPeerType exPeerType = exPeer.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        GeneratedMessageLite generatedMessageLiteA = aVarB.C(c7519Sb2.a(exPeerType)).A(0L).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (PeersStruct$ExPeer) generatedMessageLiteA;
    }
}
