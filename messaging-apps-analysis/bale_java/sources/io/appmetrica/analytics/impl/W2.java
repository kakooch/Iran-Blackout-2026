package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class W2 implements InterfaceC2905uj {
    public final ArrayList a;
    public Intent b;
    public final Context c;
    public final H5 d;

    public W2(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        H5 h5 = this.d;
        Context context = this.c;
        synchronized (h5) {
            if (h5.b) {
                try {
                    context.unregisterReceiver(h5.a);
                    h5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final synchronized void onCreate() {
        Intent intentA = a();
        this.b = intentA;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(intentA);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public W2(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = G5.a(new A2(new V2(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intentRegisterReceiver;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        H5 h5 = this.d;
        Context context = this.c;
        synchronized (h5) {
            try {
                intentRegisterReceiver = context.registerReceiver(h5.a, intentFilter);
                try {
                    h5.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intentRegisterReceiver = null;
            }
        }
        return intentRegisterReceiver;
    }
}
