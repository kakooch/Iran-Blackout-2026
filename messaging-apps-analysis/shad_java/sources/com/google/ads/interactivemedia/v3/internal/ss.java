package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ss implements ty {
    private final ArrayList<tx> a = new ArrayList<>(1);
    private final HashSet<tx> b = new HashSet<>(1);
    private final ug c = new ug();
    private final je d = new je();
    private Looper e;
    private es f;

    protected void X() {
    }

    protected abstract void a(adh adhVar);

    protected void c() {
    }

    protected abstract void d();

    protected final void e(es esVar) {
        this.f = esVar;
        ArrayList<tx> arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).a(this, esVar);
        }
    }

    protected final ug f(tw twVar) {
        return this.c.a(0, twVar, 0L);
    }

    protected final ug g(tw twVar, long j) {
        return this.c.a(0, twVar, j);
    }

    protected final je h(tw twVar) {
        return this.d.a(0, twVar);
    }

    protected final je i(int i, tw twVar) {
        return this.d.a(i, twVar);
    }

    protected final boolean j() {
        return !this.b.isEmpty();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void k(Handler handler, uh uhVar) {
        ary.t(handler);
        ary.t(uhVar);
        this.c.b(handler, uhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void l(uh uhVar) {
        this.c.c(uhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void m(Handler handler, jf jfVar) {
        ary.t(handler);
        ary.t(jfVar);
        this.d.b(handler, jfVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void n(tx txVar, adh adhVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        boolean z = true;
        if (looper != null && looper != looperMyLooper) {
            z = false;
        }
        ary.o(z);
        es esVar = this.f;
        this.a.add(txVar);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.b.add(txVar);
            a(adhVar);
        } else if (esVar != null) {
            o(txVar);
            txVar.a(this, esVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void o(tx txVar) {
        ary.t(this.e);
        boolean zIsEmpty = this.b.isEmpty();
        this.b.add(txVar);
        if (zIsEmpty) {
            X();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void p(tx txVar) {
        boolean zIsEmpty = this.b.isEmpty();
        this.b.remove(txVar);
        if ((!zIsEmpty) && this.b.isEmpty()) {
            c();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void q(tx txVar) {
        this.a.remove(txVar);
        if (!this.a.isEmpty()) {
            p(txVar);
            return;
        }
        this.e = null;
        this.f = null;
        this.b.clear();
        d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public es r() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public boolean s() {
        return true;
    }

    protected final ug t(int i, tw twVar) {
        return this.c.a(i, twVar, 0L);
    }
}
