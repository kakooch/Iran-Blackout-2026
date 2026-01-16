package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class M1 {
    public final C2633ja a = new C2633ja();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();

    public final void a(Intent intent, int i) {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                if (((K1) entry.getValue()).a(intent)) {
                    ((L1) entry.getKey()).a(intent);
                }
            }
        }
    }

    public final void e(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                C2633ja c2633ja = this.a;
                Integer numValueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) c2633ja.a.get(action);
                if (collection != null && collection.remove(numValueOf)) {
                    if (collection.isEmpty() && c2633ja.b) {
                        c2633ja.a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                if (((K1) entry.getValue()).a(intent)) {
                    ((L1) entry.getKey()).a(intent);
                }
            }
        }
    }

    public final void a(Intent intent, int i, int i2) {
    }

    public final void b(L1 l1) {
        this.b.put(l1, new H1(this));
    }

    public final void c(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                if (((K1) entry.getValue()).a(intent)) {
                    ((L1) entry.getKey()).a(intent);
                }
            }
        }
    }

    public static boolean b(Intent intent) {
        if ("io.appmetrica.analytics.IAppMetricaService".equals(intent.getAction())) {
            return !(a(intent) == Process.myPid());
        }
        return false;
    }

    public final void a(Configuration configuration) {
    }

    public final void a(L1 l1) {
        this.c.put(l1, new J1(this));
    }

    public final int a() {
        Collection collection = (Collection) this.a.a.get("io.appmetrica.analytics.IAppMetricaService");
        int i = 0;
        if (!hn.a(collection)) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() != Process.myPid()) {
                    i++;
                }
            }
        }
        return i;
    }

    public final void c(L1 l1) {
        this.b.put(l1, new I1(this));
    }

    public static int a(Intent intent) {
        Uri data = intent.getData();
        if (data != null && data.getPath().equals("/client")) {
            try {
                return Integer.parseInt(data.getQueryParameter("pid"));
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
