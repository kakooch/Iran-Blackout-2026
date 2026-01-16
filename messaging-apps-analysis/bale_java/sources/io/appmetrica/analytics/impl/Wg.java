package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Wg extends Y3 {
    protected C2966x8 c;
    protected Ie d;
    public boolean e;
    public String f;

    public Wg(Oe oe, CounterConfiguration counterConfiguration) {
        this(oe, counterConfiguration, null);
    }

    public final void a(C2811qk c2811qk) {
        this.c = new C2966x8(c2811qk);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Oe oe = this.a;
        synchronized (oe) {
            bundle.putParcelable("PROCESS_CFG_OBJ", oe);
        }
        return bundle;
    }

    public final String d() {
        C2966x8 c2966x8 = this.c;
        if (c2966x8.a.isEmpty()) {
            return null;
        }
        return new JSONObject(c2966x8.a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Wg(Oe oe, CounterConfiguration counterConfiguration, String str) {
        super(oe, counterConfiguration);
        this.e = true;
        this.f = str;
    }
}
