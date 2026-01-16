package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aez extends HandlerThread implements Handler.Callback {
    private ado a;
    private Handler b;
    private Error c;
    private RuntimeException d;
    private afa e;

    public aez() {
        super("ExoPlayer:DummySurface");
    }

    public final afa a(int i) {
        boolean z;
        start();
        this.b = new Handler(getLooper(), this);
        this.a = new ado(this.b);
        synchronized (this) {
            z = false;
            this.b.obtainMessage(1, i, 0).sendToTarget();
            while (this.e == null && this.d == null && this.c == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.d;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.c;
        if (error != null) {
            throw error;
        }
        afa afaVar = this.e;
        ary.t(afaVar);
        return afaVar;
    }

    public final void b() {
        ary.t(this.b);
        this.b.sendEmptyMessage(2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    ary.t(this.a);
                    this.a.b();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                int i2 = message.arg1;
                ary.t(this.a);
                this.a.a(i2);
                this.e = new afa(this, this.a.c());
                synchronized (this) {
                    notify();
                }
            } catch (Error e) {
                adu.b("DummySurface", "Failed to initialize dummy surface", e);
                this.c = e;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e2) {
                adu.b("DummySurface", "Failed to initialize dummy surface", e2);
                this.d = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
