package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.impl.C2921vb;
import ir.nasim.AbstractC10360bX0;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.vb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2921vb implements InterfaceC2453c {
    public final C2516ec a;
    public final Oa b;
    public final C3028zm c = new C3028zm();

    public C2921vb(C2516ec c2516ec, Oa oa) {
        this.a = c2516ec;
        this.b = oa;
    }

    public static final void a(C2921vb c2921vb, T t, List list) {
        c2921vb.b.a(t);
        C2897ub c2897ub = c2921vb.a.i;
        Pattern pattern = C2897ub.a;
        c2897ub.getClass();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (pattern.matcher(((StackTraceElement) it.next()).getClassName()).find()) {
                c2921vb.a.c.a().a(t);
                break;
            }
        }
        C2897ub c2897ub2 = c2921vb.a.i;
        Pattern pattern2 = C2897ub.b;
        c2897ub2.getClass();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (pattern2.matcher(((StackTraceElement) it2.next()).getClassName()).find()) {
                c2921vb.a.d.a().a(t);
                return;
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2453c
    public final void onAppNotResponding() {
        StackTraceElement[] stackTrace;
        final List listM;
        C3028zm c3028zm = this.c;
        Thread threadA = ((C2956wm) c3028zm.a).a();
        try {
            stackTrace = threadA.getStackTrace();
        } catch (SecurityException unused) {
            stackTrace = null;
        }
        C2860sm c2860sm = (C2860sm) c3028zm.b.apply(threadA, stackTrace);
        final T t = new T(c2860sm, c3028zm.a(threadA, null), c3028zm.c.b());
        if (c2860sm == null || (listM = c2860sm.f) == null) {
            listM = AbstractC10360bX0.m();
        }
        ((C2871t9) C2747o4.g().c.a()).b.post(new Runnable() { // from class: ir.nasim.Ee8
            @Override // java.lang.Runnable
            public final void run() {
                C2921vb.a(this.a, t, listM);
            }
        });
    }
}
