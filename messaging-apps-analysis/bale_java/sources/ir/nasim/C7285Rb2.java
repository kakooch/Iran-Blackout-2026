package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.Rb2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7285Rb2 implements InterfaceC14123hO3 {
    private final InterfaceC14123hO3 a;

    public C7285Rb2(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerTypeToStructExPeerTypeMapper");
        this.a = interfaceC14123hO3;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeersStruct$ExPeer a(ExPeer exPeer) {
        AbstractC13042fc3.i(exPeer, "input");
        PeersStruct$ExPeer.a aVarB = PeersStruct$ExPeer.newBuilder().B(exPeer.getPeerId());
        InterfaceC14123hO3 interfaceC14123hO3 = this.a;
        ExPeerType exPeerType = exPeer.getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        GeneratedMessageLite generatedMessageLiteA = aVarB.C((EnumC10088b35) interfaceC14123hO3.a(exPeerType)).A(0L).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (PeersStruct$ExPeer) generatedMessageLiteA;
    }
}
