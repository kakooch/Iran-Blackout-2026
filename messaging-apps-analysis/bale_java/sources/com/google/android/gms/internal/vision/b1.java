package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class b1 implements Iterator {
    private int a;
    private boolean b;
    private Iterator c;
    private final /* synthetic */ T0 d;

    private b1(T0 t0) {
        this.d = t0;
        this.a = -1;
    }

    private final Iterator a() {
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a + 1 < this.d.b.size() || (!this.d.c.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        return i < this.d.b.size() ? (Map.Entry) this.d.b.get(this.a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        this.d.s();
        if (this.a >= this.d.b.size()) {
            a().remove();
            return;
        }
        T0 t0 = this.d;
        int i = this.a;
        this.a = i - 1;
        t0.l(i);
    }

    /* synthetic */ b1(T0 t0, S0 s0) {
        this(t0);
    }
}
