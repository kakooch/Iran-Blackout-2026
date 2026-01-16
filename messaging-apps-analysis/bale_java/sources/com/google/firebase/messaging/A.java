package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import ir.nasim.ThreadFactoryC8579Wo4;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class A implements Runnable {
    private final long a;
    private final PowerManager.WakeLock b;
    private final FirebaseMessaging c;
    ExecutorService d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC8579Wo4("firebase-iid-executor"));

    static class a extends BroadcastReceiver {
        private A a;

        public a(A a) {
            this.a = a;
        }

        public void a() {
            if (A.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            A a = this.a;
            if (a != null && a.d()) {
                if (A.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.a.c.l(this.a, 0L);
                this.a.b().unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    public A(FirebaseMessaging firebaseMessaging, long j) {
        this.c = firebaseMessaging;
        this.a = j;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    Context b() {
        return this.c.m();
    }

    boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean e() throws IOException {
        try {
            if (this.c.j() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e) {
            if (!C2376m.h(e.getMessage())) {
                if (e.getMessage() != null) {
                    throw e;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (w.b().e(b())) {
            this.b.acquire();
        }
        try {
            try {
                this.c.D(true);
            } catch (IOException e) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e.getMessage() + ". Won't retry the operation.");
                this.c.D(false);
                if (!w.b().e(b())) {
                    return;
                }
            }
            if (!this.c.v()) {
                this.c.D(false);
                if (w.b().e(b())) {
                    this.b.release();
                    return;
                }
                return;
            }
            if (w.b().d(b()) && !d()) {
                new a(this).a();
                if (w.b().e(b())) {
                    this.b.release();
                    return;
                }
                return;
            }
            if (e()) {
                this.c.D(false);
            } else {
                this.c.G(this.a);
            }
            if (!w.b().e(b())) {
                return;
            }
            this.b.release();
        } catch (Throwable th) {
            if (w.b().e(b())) {
                this.b.release();
            }
            throw th;
        }
    }
}
