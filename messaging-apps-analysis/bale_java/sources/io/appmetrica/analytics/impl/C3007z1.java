package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* renamed from: io.appmetrica.analytics.impl.z1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3007z1 implements InterfaceC2744o1 {
    public final ICommonExecutor a;
    public final InterfaceC2744o1 b;
    public boolean c;

    public C3007z1(InterfaceC2744o1 interfaceC2744o1) {
        this(C2586ha.h().u().b(), interfaceC2744o1);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent, int i) {
        this.a.execute(new C2815r1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void b(Intent intent) {
        this.a.execute(new C2911v1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void c(Intent intent) {
        this.a.execute(new C2887u1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void onConfigurationChanged(Configuration configuration) {
        this.a.execute(new C2768p1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final synchronized void onCreate() {
        this.c = true;
        this.a.execute(new C2792q1(this));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void onDestroy() {
        this.a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void pauseUserSession(Bundle bundle) {
        this.a.execute(new C2983y1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void reportData(int i, Bundle bundle) {
        this.a.execute(new C2935w1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void resumeUserSession(Bundle bundle) {
        this.a.execute(new C2959x1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent, int i, int i2) {
        this.a.execute(new C2839s1(this, intent, i, i2));
    }

    public C3007z1(IHandlerExecutor iHandlerExecutor, InterfaceC2744o1 interfaceC2744o1) {
        this.c = false;
        this.a = iHandlerExecutor;
        this.b = interfaceC2744o1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(Intent intent) {
        this.a.execute(new C2863t1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2744o1
    public final void a(InterfaceC2720n1 interfaceC2720n1) {
        this.b.a(interfaceC2720n1);
    }
}
