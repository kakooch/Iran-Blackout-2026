package io.appmetrica.analytics.impl;

import android.content.ContentValues;

/* loaded from: classes3.dex */
public final class G8 {
    public final String a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C2559g7 g;
    public final Ta h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final B8 o;
    public final X9 p;
    public final EnumC2585h9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    /* JADX WARN: Multi-variable type inference failed */
    public G8(ContentValues contentValues) {
        C2461c7 model = new C2486d7(null, 1, 0 == true ? 1 : 0).toModel(contentValues);
        this.a = model.a().j();
        this.b = model.a().p();
        this.c = model.c();
        this.d = model.b();
        this.e = model.a().k();
        this.f = model.d();
        this.g = model.a().i();
        this.h = model.e();
        this.i = model.a().d();
        this.j = model.a().f();
        this.k = model.a().o();
        this.l = model.a().c();
        this.m = model.a().b();
        this.n = model.a().m();
        B8 b8E = model.a().e();
        this.o = b8E == null ? B8.a(null) : b8E;
        X9 x9H = model.a().h();
        this.p = x9H == null ? X9.a(null) : x9H;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
