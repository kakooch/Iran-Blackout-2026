package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import ir.nasim.Xs8;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class d {
    private static final Object a = new Object();
    private static y b = null;
    static HandlerThread c = null;
    private static Executor d = null;
    private static boolean e = false;

    public static d a(Context context) {
        synchronized (a) {
            try {
                if (b == null) {
                    b = new y(context.getApplicationContext(), e ? b().getLooper() : context.getMainLooper(), d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public static HandlerThread b() {
        synchronized (a) {
            try {
                HandlerThread handlerThread = c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                c = handlerThread2;
                handlerThread2.start();
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract void c(Xs8 xs8, ServiceConnection serviceConnection, String str);

    public final void d(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        c(new Xs8(str, str2, 4225, z), serviceConnection, str3);
    }

    protected abstract boolean e(Xs8 xs8, ServiceConnection serviceConnection, String str, Executor executor);
}
