package ir.nasim;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.GeneratedMessageLite;

/* renamed from: ir.nasim.Ay, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3451Ay implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeersStruct$GroupOutPeer a(C25238zy c25238zy) {
        AbstractC13042fc3.i(c25238zy, "input");
        GeneratedMessageLite generatedMessageLiteA = PeersStruct$GroupOutPeer.newBuilder().B(c25238zy.q()).A(c25238zy.getAccessHash()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (PeersStruct$GroupOutPeer) generatedMessageLiteA;
    }
}
