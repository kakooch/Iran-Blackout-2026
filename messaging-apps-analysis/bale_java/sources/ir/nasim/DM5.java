package ir.nasim;

import java.util.Objects;

/* loaded from: classes3.dex */
class DM5 extends AbstractC12710f43 {
    static final AbstractC12710f43 e = new DM5(new Object[0], 0);
    final transient Object[] c;
    private final transient int d;

    DM5(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // ir.nasim.Z33
    int C() {
        return 0;
    }

    @Override // ir.nasim.Z33
    boolean D() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i) {
        AbstractC4029Dj5.h(i, this.d);
        Object obj = this.c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // ir.nasim.AbstractC12710f43, ir.nasim.Z33
    int j(Object[] objArr, int i) {
        System.arraycopy(this.c, 0, objArr, i, this.d);
        return i + this.d;
    }

    @Override // ir.nasim.Z33
    Object[] r() {
        return this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.d;
    }

    @Override // ir.nasim.Z33
    int w() {
        return this.d;
    }
}
