package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.n4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2723n4 {
    public final Object a;
    public final C2628j5 b;
    public final HashMap c;
    public final C2633ja d;
    public final Context e;
    public final C2866t4 f;

    public C2723n4(Context context, C2628j5 c2628j5) {
        this(context, c2628j5, new C2866t4());
    }

    public final InterfaceC2795q4 a(C2508e4 c2508e4, A4 a4) {
        InterfaceC2795q4 interfaceC2795q4A;
        synchronized (this.a) {
            try {
                interfaceC2795q4A = (InterfaceC2795q4) this.c.get(c2508e4);
                if (interfaceC2795q4A == null) {
                    this.f.getClass();
                    interfaceC2795q4A = C2866t4.a(c2508e4).a(this.e, this.b, c2508e4, a4);
                    this.c.put(c2508e4, interfaceC2795q4A);
                    this.d.a(new C2699m4(c2508e4.b, c2508e4.c, c2508e4.d), c2508e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC2795q4A;
    }

    public C2723n4(Context context, C2628j5 c2628j5, C2866t4 c2866t4) {
        this.a = new Object();
        this.c = new HashMap();
        this.d = new C2633ja();
        this.e = context.getApplicationContext();
        this.b = c2628j5;
        this.f = c2866t4;
    }

    public final void a(int i, String str, String str2) {
        Integer numValueOf = Integer.valueOf(i);
        synchronized (this.a) {
            try {
                C2633ja c2633ja = this.d;
                Collection collection = (Collection) c2633ja.a.remove(new C2699m4(str, numValueOf, str2));
                if (!hn.a(collection)) {
                    collection.size();
                    ArrayList arrayList = new ArrayList(collection.size());
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        arrayList.add((InterfaceC2795q4) this.c.remove((C2508e4) it.next()));
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((InterfaceC2795q4) it2.next()).a();
                    }
                }
            } finally {
            }
        }
    }
}
