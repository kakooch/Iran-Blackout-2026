package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.ad, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2417ad implements InterfaceC2427an, InterfaceC2625j2 {
    public final String a;
    public final int b;
    public final on c;
    public final R2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public AbstractC2417ad(int i, String str, on onVar, R2 r2) {
        this.b = i;
        this.a = str;
        this.c = onVar;
        this.d = r2;
    }

    public final C2452bn a() {
        C2452bn c2452bn = new C2452bn();
        c2452bn.b = this.b;
        c2452bn.a = this.a.getBytes();
        c2452bn.d = new C2502dn();
        c2452bn.c = new C2477cn();
        return c2452bn;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2427an
    public abstract /* synthetic */ void a(Zm zm);

    public final R2 b() {
        return this.d;
    }

    public final String c() {
        return this.a;
    }

    public final on d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        mn mnVarA = this.c.a(this.a);
        if (mnVarA.a) {
            return true;
        }
        this.e.warning("Attribute " + this.a + " of type " + ((String) Km.a.get(this.b)) + " is skipped because " + mnVarA.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
