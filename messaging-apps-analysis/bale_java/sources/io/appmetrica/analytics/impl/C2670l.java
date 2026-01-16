package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2670l implements InterfaceC2718n {
    public final HashSet a = new HashSet();

    public C2670l(C2766p c2766p) {
        c2766p.a(this, new EnumC2694m[0]);
    }

    public final synchronized void a(InterfaceC2646k interfaceC2646k) {
        this.a.add(interfaceC2646k);
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C2785pi) ((InterfaceC2646k) it.next())).a(activity);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2718n
    public final void a(Activity activity, EnumC2694m enumC2694m) {
        C2747o4.g().c.a().execute(new RunnableC2622j(this, activity));
    }
}
