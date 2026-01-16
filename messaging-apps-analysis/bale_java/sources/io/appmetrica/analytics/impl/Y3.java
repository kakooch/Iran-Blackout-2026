package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;

/* loaded from: classes3.dex */
public class Y3 {
    public final Oe a;
    public final CounterConfiguration b;

    public Y3(Oe oe, CounterConfiguration counterConfiguration) {
        this.a = oe;
        this.b = counterConfiguration;
    }

    public static Y3 a(Context context, Bundle bundle) {
        Oe oe;
        String str = Oe.c;
        if (bundle != null) {
            try {
                oe = (Oe) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
        } else {
            oe = null;
        }
        CounterConfiguration counterConfigurationFromBundle = CounterConfiguration.fromBundle(bundle);
        if (counterConfigurationFromBundle == null || oe == null || !context.getPackageName().equals(oe.a.getAsString("PROCESS_CFG_PACKAGE_NAME")) || oe.a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() != AppMetrica.getLibraryApiLevel()) {
            return null;
        }
        return new Y3(oe, counterConfigurationFromBundle);
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.a + ", mCounterConfiguration=" + this.b + '}';
    }

    public final Oe a() {
        return this.a;
    }
}
