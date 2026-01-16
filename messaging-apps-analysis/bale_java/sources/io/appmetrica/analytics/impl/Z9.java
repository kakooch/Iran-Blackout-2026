package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class Z9 implements ProtobufConverter {
    public final Ed a;

    public Z9() {
        this(new Rk());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2859sl fromModel(C2938w4 c2938w4) {
        C2859sl c2859sl = new C2859sl();
        c2859sl.b = c2938w4.b;
        c2859sl.a = c2938w4.a;
        c2859sl.c = c2938w4.c;
        c2859sl.d = c2938w4.d;
        c2859sl.e = c2938w4.e;
        c2859sl.f = this.a.a(c2938w4.f);
        return c2859sl;
    }

    public Z9(Rk rk) {
        this.a = rk;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2938w4 toModel(C2859sl c2859sl) {
        C2890u4 c2890u4 = new C2890u4();
        c2890u4.d = c2859sl.d;
        c2890u4.c = c2859sl.c;
        c2890u4.b = c2859sl.b;
        c2890u4.a = c2859sl.a;
        c2890u4.e = c2859sl.e;
        c2890u4.f = this.a.a(c2859sl.f);
        return new C2938w4(c2890u4);
    }
}
