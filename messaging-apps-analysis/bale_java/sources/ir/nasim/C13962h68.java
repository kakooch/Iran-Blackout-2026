package ir.nasim;

import ai.bale.proto.AppzarStruct$MenuButtonMiniAppParams;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.T68;

/* renamed from: ir.nasim.h68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13962h68 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppzarStruct$MenuButtonMiniAppParams a(T68.c cVar) {
        AbstractC13042fc3.i(cVar, "input");
        AppzarStruct$MenuButtonMiniAppParams.a aVarNewBuilder = AppzarStruct$MenuButtonMiniAppParams.newBuilder();
        String strD = cVar.d();
        if (strD != null && !AbstractC20762sZ6.n0(strD)) {
            aVarNewBuilder.A((StringValue) StringValue.newBuilder().A(cVar.d()).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (AppzarStruct$MenuButtonMiniAppParams) generatedMessageLiteA;
    }
}
