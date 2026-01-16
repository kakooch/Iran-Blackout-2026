package com.google.protobuf;

import com.google.protobuf.B;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2392p extends AbstractC2379c implements B.b, RandomAccess, Z {
    private static final C2392p d;
    private double[] b;
    private int c;

    static {
        C2392p c2392p = new C2392p(new double[0], 0);
        d = c2392p;
        c2392p.s();
    }

    C2392p() {
        this(new double[10], 0);
    }

    private void j(int i, double d2) {
        int i2;
        f();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(v(i));
        }
        double[] dArr = this.b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.b, i, dArr2, i + 1, this.c - i);
            this.b = dArr2;
        }
        this.b[i] = d2;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public static C2392p o() {
        return d;
    }

    private void r(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(v(i));
        }
    }

    private String v(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    @Override // com.google.protobuf.B.b
    public double S0(int i, double d2) {
        f();
        r(i);
        double[] dArr = this.b;
        double d3 = dArr[i];
        dArr[i] = d2;
        return d3;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        f();
        B.a(collection);
        if (!(collection instanceof C2392p)) {
            return super.addAll(collection);
        }
        C2392p c2392p = (C2392p) collection;
        int i = c2392p.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.b;
        if (i3 > dArr.length) {
            this.b = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(c2392p.b, 0, this.b, this.c, c2392p.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2392p)) {
            return super.equals(obj);
        }
        C2392p c2392p = (C2392p) obj;
        if (this.c != c2392p.c) {
            return false;
        }
        double[] dArr = c2392p.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.B.b
    public double getDouble(int i) {
        r(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, Double d2) {
        j(i, d2.doubleValue());
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i = 0; i < this.c; i++) {
            iF = (iF * 31) + B.f(Double.doubleToLongBits(this.b[i]));
        }
        return iF;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d2) {
        s1(d2.doubleValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == dDoubleValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        f();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.B.b
    public void s1(double d2) {
        f();
        int i = this.c;
        double[] dArr = this.b;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.b = dArr2;
        }
        double[] dArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Double get(int i) {
        return Double.valueOf(getDouble(i));
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Double remove(int i) {
        f();
        r(i);
        double[] dArr = this.b;
        double d2 = dArr[i];
        if (i < this.c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Double set(int i, Double d2) {
        return Double.valueOf(S0(i, d2.doubleValue()));
    }

    private C2392p(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    public B.b b(int i) {
        if (i >= this.c) {
            return new C2392p(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
