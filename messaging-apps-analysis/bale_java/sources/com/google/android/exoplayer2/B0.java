package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class B0 extends AbstractC2017a {
    private final int i;
    private final int j;
    private final int[] k;
    private final int[] l;
    private final J0[] m;
    private final Object[] n;
    private final HashMap o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(Collection collection, ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int iU = 0;
        int size = collection.size();
        this.k = new int[size];
        this.l = new int[size];
        this.m = new J0[size];
        this.n = new Object[size];
        this.o = new HashMap();
        Iterator it = collection.iterator();
        int iN = 0;
        int i = 0;
        while (it.hasNext()) {
            InterfaceC2030g0 interfaceC2030g0 = (InterfaceC2030g0) it.next();
            this.m[i] = interfaceC2030g0.b();
            this.l[i] = iU;
            this.k[i] = iN;
            iU += this.m[i].u();
            iN += this.m[i].n();
            this.n[i] = interfaceC2030g0.a();
            this.o.put(this.n[i], Integer.valueOf(i));
            i++;
        }
        this.i = iU;
        this.j = iN;
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected Object C(int i) {
        return this.n[i];
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected int E(int i) {
        return this.k[i];
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected int F(int i) {
        return this.l[i];
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected J0 I(int i) {
        return this.m[i];
    }

    List J() {
        return Arrays.asList(this.m);
    }

    @Override // com.google.android.exoplayer2.J0
    public int n() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.J0
    public int u() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected int x(Object obj) {
        Integer num = (Integer) this.o.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected int y(int i) {
        return AbstractC9683aN7.h(this.k, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractC2017a
    protected int z(int i) {
        return AbstractC9683aN7.h(this.l, i + 1, false, false);
    }
}
