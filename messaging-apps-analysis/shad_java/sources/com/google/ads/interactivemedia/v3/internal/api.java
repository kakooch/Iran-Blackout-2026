package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class api implements Runnable {
    private Context a;

    public api(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            this.a = context;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        synchronized (apj.class) {
            try {
                try {
                    try {
                        try {
                            if (apj.d == null) {
                                apj.d = new AdvertisingIdClient(this.a);
                            }
                            countDownLatch = apj.e;
                        } catch (GooglePlayServicesRepairableException unused) {
                            countDownLatch = apj.e;
                        }
                    } catch (GooglePlayServicesNotAvailableException unused2) {
                        apj.f = true;
                        countDownLatch = apj.e;
                    } catch (IOException unused3) {
                        countDownLatch = apj.e;
                    }
                    countDownLatch.countDown();
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable th2) {
                apj.e.countDown();
                throw th2;
            }
        }
    }
}
