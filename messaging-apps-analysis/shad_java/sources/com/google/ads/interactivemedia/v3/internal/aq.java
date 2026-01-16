package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aq implements x {
    private static final aq a = new aq();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static Handler c = null;
    private static final Runnable j = new am();
    private static final Runnable k = new an();
    private int e;
    private long i;
    private final List<ap> d = new ArrayList();
    private final aj g = new aj();
    private final z f = new z();
    private final ak h = new ak(new at());

    aq() {
    }

    public static aq b() {
        return a;
    }

    static /* synthetic */ void g(aq aqVar) throws JSONException {
        aqVar.e = 0;
        aqVar.i = System.nanoTime();
        aqVar.g.d();
        long jNanoTime = System.nanoTime();
        y yVarA = aqVar.f.a();
        if (aqVar.g.b().size() > 0) {
            Iterator<String> it = aqVar.g.b().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject jSONObjectA = yVarA.a(null);
                View viewH = aqVar.g.h(next);
                y yVarB = aqVar.f.b();
                String strC = aqVar.g.c(next);
                if (strC != null) {
                    JSONObject jSONObjectA2 = yVarB.a(viewH);
                    ah.e(jSONObjectA2, next);
                    ah.f(jSONObjectA2, strC);
                    ah.h(jSONObjectA, jSONObjectA2);
                }
                ah.i(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                aqVar.h.b(jSONObjectA, hashSet, jNanoTime);
            }
        }
        if (aqVar.g.a().size() > 0) {
            JSONObject jSONObjectA3 = yVarA.a(null);
            aqVar.k(null, yVarA, jSONObjectA3, 1);
            ah.i(jSONObjectA3);
            aqVar.h.a(jSONObjectA3, aqVar.g.a(), jNanoTime);
        } else {
            aqVar.h.c();
        }
        aqVar.g.e();
        long jNanoTime2 = System.nanoTime() - aqVar.i;
        if (aqVar.d.size() > 0) {
            for (ap apVar : aqVar.d) {
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                apVar.b();
                if (apVar instanceof ao) {
                    ((ao) apVar).a();
                }
            }
        }
    }

    private final void k(View view, y yVar, JSONObject jSONObject, int i) {
        yVar.b(view, jSONObject, this, i == 1);
    }

    private static final void l() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(k);
            c = null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.x
    public final void a(View view, y yVar, JSONObject jSONObject) throws JSONException {
        int iJ;
        if (ek.c(view) != null || (iJ = this.g.j(view)) == 3) {
            return;
        }
        JSONObject jSONObjectA = yVar.a(view);
        ah.h(jSONObject, jSONObjectA);
        String strG = this.g.g(view);
        if (strG != null) {
            ah.e(jSONObjectA, strG);
            this.g.f();
        } else {
            ai aiVarI = this.g.i(view);
            if (aiVarI != null) {
                ah.g(jSONObjectA, aiVarI);
            }
            k(view, yVar, jSONObjectA, iJ);
        }
        this.e++;
    }

    public final void c() {
        if (c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            c = handler;
            handler.post(j);
            c.postDelayed(k, 200L);
        }
    }

    public final void d() {
        l();
        this.d.clear();
        b.post(new al(this));
    }

    public final void e() {
        l();
    }
}
