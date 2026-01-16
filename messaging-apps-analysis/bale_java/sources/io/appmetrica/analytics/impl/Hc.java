package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;

/* loaded from: classes3.dex */
public final class Hc implements ModuleServiceLifecycleController {
    public final M1 a;

    public Hc(M1 m1) {
        this.a = m1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        M1 m1 = this.a;
        m1.b.put(new L1() { // from class: ir.nasim.FU2
            @Override // io.appmetrica.analytics.impl.L1
            public final void a(Intent intent) {
                io.appmetrica.analytics.impl.Hc.a(moduleServiceLifecycleObserver, intent);
            }
        }, new H1(m1));
        M1 m12 = this.a;
        m12.c.put(new L1() { // from class: ir.nasim.GU2
            @Override // io.appmetrica.analytics.impl.L1
            public final void a(Intent intent) {
                io.appmetrica.analytics.impl.Hc.b(moduleServiceLifecycleObserver, intent);
            }
        }, new J1(m12));
    }
}
