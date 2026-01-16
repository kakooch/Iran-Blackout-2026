package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;

/* renamed from: io.appmetrica.analytics.impl.j6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2629j6 implements InterfaceC3016za {
    public final InterfaceC2606i6 a;
    public final ICrashTransformer b;
    public final G9 c;

    public AbstractC2629j6(InterfaceC2606i6 interfaceC2606i6, ICrashTransformer iCrashTransformer, G9 g9) {
        this.a = interfaceC2606i6;
        this.b = iCrashTransformer;
        this.c = g9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3016za
    public final void a(Throwable th, T t) {
        if (this.a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                ((Tg) this).d.a().a(Pm.a(th, t, null, (String) this.c.a.a(), (Boolean) this.c.b.a()));
            }
        }
    }

    public final InterfaceC2606i6 b() {
        return this.a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
