package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Y9 {
    public static final Y9 d = new Y9();
    public final Tc a = new Tc();
    public final ServiceComponentsInitializer b = AbstractC2690lj.a();
    public boolean c = false;

    public final void a(Context context) {
        C2586ha.a(context);
        this.b.onCreate(context);
        this.a.getClass();
        Iterator it = C2586ha.C.s.a().iterator();
        while (it.hasNext()) {
            Object objLoadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor((String) it.next(), ModuleServiceEntryPoint.class);
            if (objLoadAndInstantiateClassWithDefaultConstructor != null) {
                C2586ha.C.m().a((ModuleServiceEntryPoint<Object>) objLoadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new C2929vj(C2586ha.h().A().b()).a(context);
        C2586ha.C.n().a();
    }

    public final void b(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this) {
            try {
                if (!this.c) {
                    a(context);
                    this.c = true;
                }
            } finally {
            }
        }
    }
}
