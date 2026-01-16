package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* loaded from: classes3.dex */
public final class l4 {
    private final H1 a;

    public l4(H1 h1) {
        this.a = h1;
    }

    final void a(String str, Bundle bundle) {
        String string;
        this.a.a().h();
        if (this.a.o()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.a.F().v.b(string);
        this.a.F().w.b(this.a.c().currentTimeMillis());
    }

    final void b() {
        this.a.a().h();
        if (d()) {
            if (e()) {
                this.a.F().v.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.a.I().u("auto", "_cmpx", bundle);
            } else {
                String strA = this.a.F().v.a();
                if (TextUtils.isEmpty(strA)) {
                    this.a.b().t().a("Cache still valid but referrer not found");
                } else {
                    long jA = ((this.a.F().w.a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strA);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jA);
                    Object obj = pair.first;
                    this.a.I().u(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.a.F().v.b(null);
            }
            this.a.F().w.b(0L);
        }
    }

    final void c() {
        if (d() && e()) {
            this.a.F().v.b(null);
        }
    }

    final boolean d() {
        return this.a.F().w.a() > 0;
    }

    final boolean e() {
        return d() && this.a.c().currentTimeMillis() - this.a.F().w.a() > this.a.z().r(null, S0.S);
    }
}
