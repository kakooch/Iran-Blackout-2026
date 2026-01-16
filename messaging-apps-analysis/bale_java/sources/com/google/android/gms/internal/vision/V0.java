package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class V0 implements Iterator {
    private int a;
    private Iterator b;
    private final /* synthetic */ T0 c;

    private V0(T0 t0) {
        this.c = t0;
        this.a = t0.b.size();
    }

    private final Iterator a() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        return (i > 0 && i <= this.c.b.size()) || a().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List list = this.c.b;
        int i = this.a - 1;
        this.a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ V0(T0 t0, S0 s0) {
        this(t0);
    }
}
