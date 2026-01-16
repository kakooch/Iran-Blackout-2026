package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: io.appmetrica.analytics.impl.zm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3028zm {
    public final InterfaceC3004ym a;
    public final BiFunction b;
    public final Sb c;

    public C3028zm() {
        this(new C2956wm(), new C2538fa(), C2747o4.g().j());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C2980xm());
        try {
            ((C2956wm) this.a).getClass();
            allStackTraces = Thread.getAllStackTraces();
        } catch (SecurityException unused) {
            allStackTraces = null;
        }
        if (allStackTraces != null) {
            treeMap.putAll(allStackTraces);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (thread3 != thread && thread3 != thread2) {
                arrayList.add((C2860sm) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C3028zm(C2956wm c2956wm, C2538fa c2538fa, Sb sb) {
        this.a = c2956wm;
        this.b = c2538fa;
        this.c = sb;
    }
}
