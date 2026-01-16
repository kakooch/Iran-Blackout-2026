package com.google.protobuf;

import com.google.protobuf.B;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2400y extends AbstractC2379c implements B.f, RandomAccess, Z {
    private static final C2400y d;
    private float[] b;
    private int c;

    static {
        C2400y c2400y = new C2400y(new float[0], 0);
        d = c2400y;
        c2400y.s();
    }

    C2400y() {
        this(new float[10], 0);
    }

    private void j(int i, float f) {
        int i2;
        f();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(v(i));
        }
        float[] fArr = this.b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.b, i, fArr2, i + 1, this.c - i);
            this.b = fArr2;
        }
        this.b[i] = f;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    public static C2400y o() {
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

    @Override // com.google.protobuf.B.f
    public void M(float f) {
        f();
        int i = this.c;
        float[] fArr = this.b;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.b = fArr2;
        }
        float[] fArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        f();
        B.a(collection);
        if (!(collection instanceof C2400y)) {
            return super.addAll(collection);
        }
        C2400y c2400y = (C2400y) collection;
        int i = c2400y.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.b;
        if (i3 > fArr.length) {
            this.b = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c2400y.b, 0, this.b, this.c, c2400y.c);
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
        if (!(obj instanceof C2400y)) {
            return super.equals(obj);
        }
        C2400y c2400y = (C2400y) obj;
        if (this.c != c2400y.c) {
            return false;
        }
        float[] fArr = c2400y.b;
        for (int i = 0; i < this.c; i++) {
            if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.B.f
    public float getFloat(int i) {
        r(i);
        return this.b[i];
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, Float f) {
        j(i, f.floatValue());
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.c; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.b[i]);
        }
        return iFloatToIntBits;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f) {
        M(f.floatValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.b[i] == fFloatValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.B.f
    public float m0(int i, float f) {
        f();
        r(i);
        float[] fArr = this.b;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        f();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.b;
        System.arraycopy(fArr, i2, fArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Float get(int i) {
        return Float.valueOf(getFloat(i));
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Float remove(int i) {
        f();
        r(i);
        float[] fArr = this.b;
        float f = fArr[i];
        if (i < this.c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Float set(int i, Float f) {
        return Float.valueOf(m0(i, f.floatValue()));
    }

    private C2400y(float[] fArr, int i) {
        this.b = fArr;
        this.c = i;
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    public B.f b(int i) {
        if (i >= this.c) {
            return new C2400y(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }
}
