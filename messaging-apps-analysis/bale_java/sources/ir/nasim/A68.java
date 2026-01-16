package ir.nasim;

import ai.bale.proto.AppzarStruct$MiniAppThemeParams;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;

/* loaded from: classes5.dex */
public final class A68 implements InterfaceC14123hO3 {
    private final StringValue b(String str) {
        return (StringValue) StringValue.newBuilder().A(str).a();
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AppzarStruct$MiniAppThemeParams a(C24732z68 c24732z68) {
        AbstractC13042fc3.i(c24732z68, "input");
        GeneratedMessageLite generatedMessageLiteA = AppzarStruct$MiniAppThemeParams.newBuilder().A(b(c24732z68.a())).B(b(c24732z68.b())).D(b(c24732z68.d())).E(b(c24732z68.e())).C(b(c24732z68.c())).F(b(c24732z68.f())).G(b(c24732z68.g())).H(b(c24732z68.h())).I(b(c24732z68.i())).J(b(c24732z68.j())).K(b(c24732z68.k())).L(b(c24732z68.l())).M(b(c24732z68.m())).N(b(c24732z68.n())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return (AppzarStruct$MiniAppThemeParams) generatedMessageLiteA;
    }
}
