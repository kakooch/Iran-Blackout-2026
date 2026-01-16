package com.google.protobuf;

import com.google.protobuf.B;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2382f extends AbstractC2379c implements B.a, RandomAccess, Z {
    private static final C2382f d;
    private boolean[] b;
    private int c;

    static {
        C2382f c2382f = new C2382f(new boolean[0], 0);
        d = c2382f;
        c2382f.s();
    }

    C2382f() {
        this(new boolean[10], 0);
    }

    private void j(int i, boolean z) {
        int i2;
        f();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(x(i));
        }
        boolean[] zArr = this.b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.b, i, zArr2, i + 1, this.c - i);
            this.b = zArr2;
        }
        this.b[i] = z;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public static C2382f r() {
        return d;
    }

    private void t(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(x(i));
        }
    }

    private String x(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i) {
        f();
        t(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        if (i < this.c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i, Boolean bool) {
        return Boolean.valueOf(C(i, bool.booleanValue()));
    }

    public boolean C(int i, boolean z) {
        f();
        t(i);
        boolean[] zArr = this.b;
        boolean z2 = zArr[i];
        zArr[i] = z;
        return z2;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        f();
        B.a(collection);
        if (!(collection instanceof C2382f)) {
            return super.addAll(collection);
        }
        C2382f c2382f = (C2382f) collection;
        int i = c2382f.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.b;
        if (i3 > zArr.length) {
            this.b = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(c2382f.b, 0, this.b, this.c, c2382f.c);
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
        if (!(obj instanceof C2382f)) {
            return super.equals(obj);
        }
        C2382f c2382f = (C2382f) obj;
        if (this.c != c2382f.c) {
            return false;
        }
        boolean[] zArr = c2382f.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, Boolean bool) {
        j(i, bool.booleanValue());
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i = 0; i < this.c; i++) {
            iC = (iC * 31) + B.c(this.b[i]);
        }
        return iC;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        o(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == zBooleanValue) {
                return i;
            }
        }
        return -1;
    }

    public void o(boolean z) {
        f();
        int i = this.c;
        boolean[] zArr = this.b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.b = zArr2;
        }
        boolean[] zArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        f();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.b;
        System.arraycopy(zArr, i2, zArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i) {
        return Boolean.valueOf(w(i));
    }

    public boolean w(int i) {
        t(i);
        return this.b[i];
    }

    private C2382f(boolean[] zArr, int i) {
        this.b = zArr;
        this.c = i;
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    public B.a b(int i) {
        if (i >= this.c) {
            return new C2382f(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
