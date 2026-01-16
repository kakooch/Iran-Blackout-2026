package ir.nasim;

import ai.bale.proto.AppzarStruct$MainMiniAppParams;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.T68;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.g68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13371g68 implements InterfaceC14123hO3 {
    private final C7285Rb2 a;

    public C13371g68(C7285Rb2 c7285Rb2) {
        AbstractC13042fc3.i(c7285Rb2, "exPeerToStructExPeerMapper");
        this.a = c7285Rb2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppzarStruct$MainMiniAppParams a(T68.b bVar) {
        AbstractC13042fc3.i(bVar, "input");
        AppzarStruct$MainMiniAppParams.a aVarNewBuilder = AppzarStruct$MainMiniAppParams.newBuilder();
        String strE = bVar.e();
        if (strE != null && !AbstractC20762sZ6.n0(strE)) {
            aVarNewBuilder.B((StringValue) StringValue.newBuilder().A(bVar.e()).a());
        }
        ExPeer exPeerD = bVar.d();
        if (exPeerD != null) {
            aVarNewBuilder.A(this.a.a(exPeerD));
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (AppzarStruct$MainMiniAppParams) generatedMessageLiteA;
    }
}
