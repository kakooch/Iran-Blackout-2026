package com.google.protobuf;

import com.google.protobuf.B;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class A extends AbstractC2379c implements B.g, RandomAccess, Z {
    private static final A d;
    private int[] b;
    private int c;

    static {
        A a = new A(new int[0], 0);
        d = a;
        a.s();
    }

    A() {
        this(new int[10], 0);
    }

    private void j(int i, int i2) {
        int i3;
        f();
        if (i < 0 || i > (i3 = this.c)) {
            throw new IndexOutOfBoundsException(v(i));
        }
        int[] iArr = this.b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i + 1, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = i2;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public static A o() {
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

    @Override // com.google.protobuf.B.g
    public int U(int i, int i2) {
        f();
        r(i);
        int[] iArr = this.b;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        f();
        B.a(collection);
        if (!(collection instanceof A)) {
            return super.addAll(collection);
        }
        A a = (A) collection;
        int i = a.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.b;
        if (i3 > iArr.length) {
            this.b = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(a.b, 0, this.b, this.c, a.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.B.g
    public void b1(int i) {
        f();
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.b = iArr2;
        }
        int[] iArr3 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr3[i3] = i;
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
        if (!(obj instanceof A)) {
            return super.equals(obj);
        }
        A a = (A) obj;
        if (this.c != a.c) {
            return false;
        }
        int[] iArr = a.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.B.g
    public int getInt(int i) {
        r(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, Integer num) {
        j(i, num.intValue());
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        b1(num.intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == iIntValue) {
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
        int[] iArr = this.b;
        System.arraycopy(iArr, i2, iArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i) {
        f();
        r(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Integer set(int i, Integer num) {
        return Integer.valueOf(U(i, num.intValue()));
    }

    private A(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    public B.g b(int i) {
        if (i >= this.c) {
            return new A(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
