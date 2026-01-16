package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class I4 implements InterfaceC2992ya, Pk, Aa {
    public final Context a;
    public final W4 b;
    public final Bl c;
    public final Rg d;
    public final S e;
    public final P4 f;
    public final C2598hm g;
    public ArrayList h;
    public final X4 i;
    public final Af j;
    public final C2604i4 k;
    public final Ff l;
    public final Object m;

    public I4(Context context, Gk gk, W4 w4, A4 a4, Af af) {
        this(context, gk, w4, a4, new Rg(a4.b), af, new X4(), new K4(), new S(new Q(), new N(), new L(), C2586ha.h().u().a(), "ServicePublic"), new Ff());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final void a(C3010z4 c3010z4) {
        Rg rg = this.d;
        rg.a = rg.a.mergeFrom(c3010z4);
    }

    public final synchronized void b(F4 f4) {
        this.i.a.remove(f4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.COMMUTATION;
    }

    public final C3010z4 d() {
        return this.d.a;
    }

    public final Af e() {
        return this.j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final Context getContext() {
        return this.a;
    }

    public I4(Context context, Gk gk, W4 w4, A4 a4, Rg rg, Af af, X4 x4, K4 k4, S s, Ff ff) {
        this.h = new ArrayList();
        this.m = new Object();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = w4;
        this.d = rg;
        this.i = x4;
        this.f = K4.a(this);
        Bl blA = gk.a(applicationContext, w4, a4.a);
        this.c = blA;
        this.e = s;
        s.a(applicationContext, blA.e());
        this.k = AbstractC2627j4.a(blA, s, applicationContext);
        this.g = k4.a(this, blA);
        this.j = af;
        this.l = ff;
        gk.a(w4, this);
    }

    public final synchronized void a(F4 f4) {
        this.i.a.add(f4);
        ResultReceiverC2988y6.a(f4.c, this.k.a(Gl.a(this.c.e().l)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2992ya
    public final W4 b() {
        return this.b;
    }

    public final void a(Q5 q5, F4 f4) {
        P4 p4 = this.f;
        p4.getClass();
        p4.a(q5, new O4(f4));
    }

    @Override // io.appmetrica.analytics.impl.Pk
    public final void a(C2549fl c2549fl) {
        this.e.c = c2549fl;
        synchronized (this.m) {
            try {
                Iterator it = this.i.a.iterator();
                while (it.hasNext()) {
                    F4 f4 = (F4) it.next();
                    ResultReceiverC2988y6.a(f4.c, this.k.a(Gl.a(c2549fl.l)));
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = this.h.iterator();
                while (it2.hasNext()) {
                    Ra ra = (Ra) it2.next();
                    if (AbstractC2450bl.a(c2549fl, ra.b, ra.c, new Pa())) {
                        ResultReceiverC2988y6.a(ra.a, this.k.a(ra.c));
                    } else {
                        arrayList.add(ra);
                    }
                }
                this.h = new ArrayList(arrayList);
                if (!arrayList.isEmpty()) {
                    this.g.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Pk
    public final void a(Ik ik, C2549fl c2549fl) {
        synchronized (this.m) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    Ra ra = (Ra) it.next();
                    ResultReceiverC2988y6.a(ra.a, ik, this.k.a(ra.c));
                }
                this.h.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Ra ra) {
        ResultReceiver resultReceiver;
        HashMap map;
        List<String> list;
        HashMap map2 = new HashMap();
        if (ra != null) {
            list = ra.b;
            resultReceiver = ra.a;
            map = ra.c;
        } else {
            resultReceiver = null;
            map = map2;
            list = null;
        }
        boolean zA = this.c.a(list, map);
        if (!zA) {
            ResultReceiverC2988y6.a(resultReceiver, this.k.a(map));
        }
        if (!this.c.g()) {
            if (zA) {
                ResultReceiverC2988y6.a(resultReceiver, this.k.a(map));
                return;
            }
            return;
        }
        synchronized (this.m) {
            if (zA && ra != null) {
                try {
                    this.h.add(ra);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.g.b();
    }

    public final void a(ResultReceiver resultReceiver) {
        this.l.a(new H4(resultReceiver));
    }

    public final C2604i4 a() {
        return this.k;
    }

    @Override // io.appmetrica.analytics.impl.Aa
    public final void a(A4 a4) {
        this.c.a(a4.a);
        a(a4.b);
    }
}
