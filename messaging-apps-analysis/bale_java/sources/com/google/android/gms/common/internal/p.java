package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes3.dex */
public abstract class p {
    private Object a;
    private boolean b = false;
    final /* synthetic */ b c;

    public p(b bVar, Object obj) {
        this.c = bVar;
        this.a = obj;
    }

    protected abstract void a(Object obj);

    protected abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.a;
                if (this.b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.c.r) {
            this.c.r.remove(this);
        }
    }
}
