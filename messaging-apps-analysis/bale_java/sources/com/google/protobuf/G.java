package com.google.protobuf;

import com.google.protobuf.B;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
final class G extends AbstractC2379c implements B.i, RandomAccess, Z {
    private static final G d;
    private long[] b;
    private int c;

    static {
        G g = new G(new long[0], 0);
        d = g;
        g.s();
    }

    G() {
        this(new long[10], 0);
    }

    private void j(int i, long j) {
        int i2;
        f();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(v(i));
        }
        long[] jArr = this.b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.b, i, jArr2, i + 1, this.c - i);
            this.b = jArr2;
        }
        this.b[i] = j;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public static G o() {
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

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        f();
        B.a(collection);
        if (!(collection instanceof G)) {
            return super.addAll(collection);
        }
        G g = (G) collection;
        int i = g.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.b;
        if (i3 > jArr.length) {
            this.b = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(g.b, 0, this.b, this.c, g.c);
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
        if (!(obj instanceof G)) {
            return super.equals(obj);
        }
        G g = (G) obj;
        if (this.c != g.c) {
            return false;
        }
        long[] jArr = g.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.B.i
    public long getLong(int i) {
        r(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, Long l) {
        j(i, l.longValue());
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i = 0; i < this.c; i++) {
            iF = (iF * 31) + B.f(this.b[i]);
        }
        return iF;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l) {
        l1(l.longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == jLongValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.B.i
    public void l1(long j) {
        f();
        int i = this.c;
        long[] jArr = this.b;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.b = jArr2;
        }
        long[] jArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        f();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.b;
        System.arraycopy(jArr, i2, jArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Long get(int i) {
        return Long.valueOf(getLong(i));
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Long remove(int i) {
        f();
        r(i);
        long[] jArr = this.b;
        long j = jArr[i];
        if (i < this.c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Long set(int i, Long l) {
        return Long.valueOf(z1(i, l.longValue()));
    }

    @Override // com.google.protobuf.B.i
    public long z1(int i, long j) {
        f();
        r(i);
        long[] jArr = this.b;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    private G(long[] jArr, int i) {
        this.b = jArr;
        this.c = i;
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    public B.i b(int i) {
        if (i >= this.c) {
            return new G(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
