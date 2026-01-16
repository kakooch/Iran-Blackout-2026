package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class Ib implements Fb, ToggleObserver {
    public final ArrayList a = new ArrayList();
    public final IHandlerExecutor b = C2586ha.h().u().c();
    public Gm c;
    public boolean d;

    public final void a(Toggle toggle) {
        Gm gm = new Gm(toggle);
        this.c = gm;
        gm.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        Gm gm = this.c;
        if (gm == null) {
            AbstractC13042fc3.y("togglesHolder");
            gm = null;
        }
        gm.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: ir.nasim.o03
            @Override // java.lang.Runnable
            public final void run() {
                io.appmetrica.analytics.impl.Ib.a(this.a, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: ir.nasim.p03
            @Override // java.lang.Runnable
            public final void run() {
                io.appmetrica.analytics.impl.Ib.a(this.a, locationControllerObserver, z);
            }
        });
    }

    public static final void a(Ib ib, LocationControllerObserver locationControllerObserver, boolean z) {
        ib.a.add(locationControllerObserver);
        if (z) {
            if (ib.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(Ib ib, boolean z) {
        if (ib.d != z) {
            ib.d = z;
            UA2 ua2 = z ? Gb.a : Hb.a;
            Iterator it = ib.a.iterator();
            while (it.hasNext()) {
                ua2.invoke((LocationControllerObserver) it.next());
            }
        }
    }

    public final void a(Object obj) {
        Gm gm = this.c;
        if (gm == null) {
            AbstractC13042fc3.y("togglesHolder");
            gm = null;
        }
        gm.b.a(obj);
    }

    public final void a(boolean z) {
        Gm gm = this.c;
        if (gm == null) {
            AbstractC13042fc3.y("togglesHolder");
            gm = null;
        }
        gm.a.a(z);
    }
}
