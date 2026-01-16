package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class b0 extends AbstractC2379c implements RandomAccess {
    private static final b0 d;
    private Object[] b;
    private int c;

    static {
        b0 b0Var = new b0(new Object[0], 0);
        d = b0Var;
        b0Var.s();
    }

    private b0(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    private static Object[] h(int i) {
        return new Object[i];
    }

    public static b0 i() {
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

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
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

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b0 b(int i) {
        if (i >= this.c) {
            return new b0(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
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
