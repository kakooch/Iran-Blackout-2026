package ir.nasim;

import ai.bale.proto.AppzarStruct$DirectLinkMiniAppParams;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.T68;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class Z48 implements InterfaceC14123hO3 {
    private final C7285Rb2 a;

    public Z48(C7285Rb2 c7285Rb2) {
        AbstractC13042fc3.i(c7285Rb2, "exPeerToStructExPeerMapper");
        this.a = c7285Rb2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppzarStruct$DirectLinkMiniAppParams a(T68.a aVar) {
        AbstractC13042fc3.i(aVar, "input");
        AppzarStruct$DirectLinkMiniAppParams.a aVarB = AppzarStruct$DirectLinkMiniAppParams.newBuilder().B(aVar.e());
        String strF = aVar.f();
        if (strF != null) {
            if (AbstractC20762sZ6.n0(strF)) {
                strF = null;
            }
            if (strF != null) {
                aVarB.C(StringValue.of(strF));
            }
        }
        ExPeer exPeerD = aVar.d();
        if (exPeerD != null) {
            aVarB.A(this.a.a(exPeerD));
        }
        GeneratedMessageLite generatedMessageLiteA = aVarB.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (AppzarStruct$DirectLinkMiniAppParams) generatedMessageLiteA;
    }
}
