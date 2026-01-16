package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Tc {
    public static void a() {
        Iterator it = C2747o4.g().l.a().iterator();
        while (it.hasNext()) {
            Object objLoadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor((String) it.next(), ModuleClientEntryPoint.class);
            if (objLoadAndInstantiateClassWithDefaultConstructor != null) {
                C2747o4.g().i().a.add((ModuleClientEntryPoint) objLoadAndInstantiateClassWithDefaultConstructor);
            }
        }
    }
}
