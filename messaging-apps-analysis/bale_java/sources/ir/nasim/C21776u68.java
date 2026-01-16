package ir.nasim;

import ai.bale.proto.AppzarStruct$KeyboardButtonMiniAppParams;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.T68;

/* renamed from: ir.nasim.u68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21776u68 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppzarStruct$KeyboardButtonMiniAppParams a(T68.d dVar) {
        AbstractC13042fc3.i(dVar, "input");
        GeneratedMessageLite generatedMessageLiteA = AppzarStruct$KeyboardButtonMiniAppParams.newBuilder().A(dVar.d()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (AppzarStruct$KeyboardButtonMiniAppParams) generatedMessageLiteA;
    }
}
