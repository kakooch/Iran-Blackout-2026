package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class S extends AbstractC2341c implements RandomAccess {
    private static final S d;
    private Object[] b;
    private int c;

    static {
        S s = new S(new Object[0], 0);
        d = s;
        s.s();
    }

    private S(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    private static Object[] h(int i) {
        return new Object[i];
    }

    public static S i() {
        return d;
    }

    private void j(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(o(i));
        }
    }

    private String o(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
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

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        j(i);
        return this.b[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2360w.d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public S b(int i) {
        if (i >= this.c) {
            return new S(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.List
    public Object remove(int i) {
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
    public Object set(int i, Object obj) {
        f();
        j(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int i2;
        f();
        if (i >= 0 && i <= (i2 = this.c)) {
            Object[] objArr = this.b;
            if (i2 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
            } else {
                Object[] objArrH = h(((i2 * 3) / 2) + 1);
                System.arraycopy(this.b, 0, objArrH, 0, i);
                System.arraycopy(this.b, i, objArrH, i + 1, this.c - i);
                this.b = objArrH;
            }
            this.b[i] = obj;
            this.c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i));
    }
}
