package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class m1 extends AbstractC2139p0 implements RandomAccess {
    private static final m1 d;
    private Object[] b;
    private int c;

    static {
        m1 m1Var = new m1(new Object[0], 0);
        d = m1Var;
        m1Var.c();
    }

    private m1(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    public static m1 h() {
        return d;
    }

    private final String i(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    private final void j(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(i(i));
        }
    }

    @Override // ir.nasim.InterfaceC20943sr8
    public final /* bridge */ /* synthetic */ InterfaceC20943sr8 K(int i) {
        if (i >= this.c) {
            return new m1(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        f();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        Object[] objArr = this.b;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.b, i, objArr2, i + 1, this.c - i);
            this.b = objArr2;
        }
        this.b[i] = obj;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        j(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        f();
        j(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        if (i < this.c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        f();
        j(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
