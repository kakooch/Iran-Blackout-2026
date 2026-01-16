package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import ir.nasim.AbstractC16632lc2;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC4616Fw7;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.appmetrica.analytics.impl.l4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2675l4 {
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    public I5 b;

    public final void a(ModuleClientEntryPoint<Object> moduleClientEntryPoint) {
        this.a.add(moduleClientEntryPoint);
    }

    public final void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                moduleClientEntryPoint.onActivated();
            } catch (Throwable th) {
                String identifier = moduleClientEntryPoint.getIdentifier();
                C2523ej c2523ej = Ei.a;
                Map mapG = AbstractC19460qO3.g(AbstractC4616Fw7.a(identifier, AbstractC19460qO3.g(AbstractC4616Fw7.a("onActivated", AbstractC16632lc2.b(th)))));
                c2523ej.getClass();
                c2523ej.a(new C2473cj("client_module_errors", mapG));
            }
        }
    }

    public final void a(I5 i5) {
        this.b = i5;
        HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ModuleClientEntryPoint moduleClientEntryPoint = (ModuleClientEntryPoint) it.next();
            try {
                moduleClientEntryPoint.initClientSide(i5);
            } catch (Throwable th) {
                String identifier = moduleClientEntryPoint.getIdentifier();
                C2523ej c2523ej = Ei.a;
                Map mapG = AbstractC19460qO3.g(AbstractC4616Fw7.a(identifier, AbstractC19460qO3.g(AbstractC4616Fw7.a("initClientSide", AbstractC16632lc2.b(th)))));
                c2523ej.getClass();
                c2523ej.a(new C2473cj("client_module_errors", mapG));
                hashSet.add(moduleClientEntryPoint);
            }
        }
        this.a.removeAll(hashSet);
    }

    public final ModuleAdRevenueProcessor a() {
        L5 l5;
        I5 i5 = this.b;
        if (i5 == null || (l5 = ((Z3) i5).a) == null) {
            return null;
        }
        return l5.b;
    }
}
