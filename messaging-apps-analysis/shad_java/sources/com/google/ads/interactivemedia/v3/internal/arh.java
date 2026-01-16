package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class arh<K, V> extends AbstractMap<K, V> implements Serializable, aqi {
    transient K[] a;
    transient V[] b;
    transient int c;
    transient int d;
    private transient int[] e;
    private transient int[] f;
    private transient int[] g;
    private transient int[] h;
    private transient int i;
    private transient int j;
    private transient int[] k;
    private transient int[] l;
    private transient Set<K> m;
    private transient Set<V> n;
    private transient Set<Map.Entry<K, V>> o;
    private transient aqi<V, K> p;

    private arh() {
        a(2);
    }

    private final void A(int i, int i2, int i3) {
        int i4;
        int i5;
        aqd.d(i != -1);
        y(i, i2);
        z(i, i3);
        v(this.k[i], this.l[i]);
        int i6 = this.c - 1;
        if (i6 != i) {
            int i7 = this.k[i6];
            int i8 = this.l[i6];
            v(i7, i);
            v(i, i8);
            K[] kArr = this.a;
            K k = kArr[i6];
            V[] vArr = this.b;
            V v = vArr[i6];
            kArr[i] = k;
            vArr[i] = v;
            int iU = u(ary.c(k));
            int[] iArr = this.e;
            int i9 = iArr[iU];
            if (i9 == i6) {
                iArr[iU] = i;
            } else {
                int i10 = this.g[i9];
                while (true) {
                    i4 = i9;
                    i9 = i10;
                    if (i9 == i6) {
                        break;
                    } else {
                        i10 = this.g[i9];
                    }
                }
                this.g[i4] = i;
            }
            int[] iArr2 = this.g;
            iArr2[i] = iArr2[i6];
            iArr2[i6] = -1;
            int iU2 = u(ary.c(v));
            int[] iArr3 = this.f;
            int i11 = iArr3[iU2];
            if (i11 == i6) {
                iArr3[iU2] = i;
            } else {
                int i12 = this.h[i11];
                while (true) {
                    i5 = i11;
                    i11 = i12;
                    if (i11 == i6) {
                        break;
                    } else {
                        i12 = this.h[i11];
                    }
                }
                this.h[i5] = i;
            }
            int[] iArr4 = this.h;
            iArr4[i] = iArr4[i6];
            iArr4[i6] = -1;
        }
        K[] kArr2 = this.a;
        int i13 = this.c - 1;
        kArr2[i13] = null;
        this.b[i13] = null;
        this.c = i13;
        this.d++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int i, K k) {
        aqd.d(i != -1);
        int iC = c(k, ary.c(k));
        int i2 = this.j;
        if (iC != -1) {
            String strValueOf = String.valueOf(k);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 28);
            sb.append("Key already present in map: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 == i) {
            i2 = this.k[i];
        } else if (i2 == this.c) {
            i2 = iC;
        }
        if (i == -2) {
            iC = this.l[-2];
        } else if (this.c != -2) {
            iC = -2;
        }
        v(this.k[i], this.l[i]);
        y(i, ary.c(this.a[i]));
        this.a[i] = k;
        w(i, ary.c(k));
        v(i2, i);
        v(i, iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i, V v) {
        aqd.d(i != -1);
        int iC = ary.c(v);
        if (e(v, iC) == -1) {
            z(i, ary.c(this.b[i]));
            this.b[i] = v;
            x(i, iC);
        } else {
            String strValueOf = String.valueOf(v);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
            sb.append("Value already present in map: ");
            sb.append(strValueOf);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static <K, V> arh<K, V> p() {
        return new arh<>();
    }

    private static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        a(16);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private static int[] s(int[] iArr, int i) {
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(iArrCopyOf, length, i, -1);
        return iArrCopyOf;
    }

    private final void t(int i) {
        int length = this.g.length;
        if (length < i) {
            int iA = ari.a(length, i);
            this.a = (K[]) Arrays.copyOf(this.a, iA);
            this.b = (V[]) Arrays.copyOf(this.b, iA);
            this.g = s(this.g, iA);
            this.h = s(this.h, iA);
            this.k = s(this.k, iA);
            this.l = s(this.l, iA);
        }
        if (this.e.length < i) {
            int iD = ary.d(i);
            this.e = r(iD);
            this.f = r(iD);
            for (int i2 = 0; i2 < this.c; i2++) {
                int iU = u(ary.c(this.a[i2]));
                int[] iArr = this.g;
                int[] iArr2 = this.e;
                iArr[i2] = iArr2[iU];
                iArr2[iU] = i2;
                int iU2 = u(ary.c(this.b[i2]));
                int[] iArr3 = this.h;
                int[] iArr4 = this.f;
                iArr3[i2] = iArr4[iU2];
                iArr4[iU2] = i2;
            }
        }
    }

    private final int u(int i) {
        return i & (this.e.length - 1);
    }

    private final void w(int i, int i2) {
        aqd.d(i != -1);
        int iU = u(i2);
        int[] iArr = this.g;
        int[] iArr2 = this.e;
        iArr[i] = iArr2[iU];
        iArr2[iU] = i;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.c);
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private final void x(int i, int i2) {
        aqd.d(i != -1);
        int iU = u(i2);
        int[] iArr = this.h;
        int[] iArr2 = this.f;
        iArr[i] = iArr2[iU];
        iArr2[iU] = i;
    }

    private final void y(int i, int i2) {
        aqd.d(i != -1);
        int iU = u(i2);
        int[] iArr = this.e;
        int i3 = iArr[iU];
        if (i3 == i) {
            int[] iArr2 = this.g;
            iArr[iU] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.g[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String strValueOf = String.valueOf(this.a[i]);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
                sb.append("Expected to find entry with key ");
                sb.append(strValueOf);
                throw new AssertionError(sb.toString());
            }
            if (i3 == i) {
                int[] iArr3 = this.g;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.g[i3];
        }
    }

    private final void z(int i, int i2) {
        aqd.d(i != -1);
        int iU = u(i2);
        int[] iArr = this.f;
        int i3 = iArr[iU];
        if (i3 == i) {
            int[] iArr2 = this.h;
            iArr[iU] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.h[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String strValueOf = String.valueOf(this.b[i]);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                sb.append("Expected to find entry with value ");
                sb.append(strValueOf);
                throw new AssertionError(sb.toString());
            }
            if (i3 == i) {
                int[] iArr3 = this.h;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
            i4 = this.h[i3];
        }
    }

    final void a(int i) {
        ary.n(i, "expectedSize");
        int iD = ary.d(i);
        this.c = 0;
        this.a = (K[]) new Object[i];
        this.b = (V[]) new Object[i];
        this.e = r(iD);
        this.f = r(iD);
        this.g = r(i);
        this.h = r(i);
        this.i = -2;
        this.j = -2;
        this.k = r(i);
        this.l = r(i);
    }

    final int b(Object obj) {
        return c(obj, ary.c(obj));
    }

    final int c(Object obj, int i) {
        return f(obj, i, this.e, this.g, this.a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, (Object) null);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1);
        Arrays.fill(this.g, 0, this.c, -1);
        Arrays.fill(this.h, 0, this.c, -1);
        Arrays.fill(this.k, 0, this.c, -1);
        Arrays.fill(this.l, 0, this.c, -1);
        this.c = 0;
        this.i = -2;
        this.j = -2;
        this.d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return d(obj) != -1;
    }

    final int d(Object obj) {
        return e(obj, ary.c(obj));
    }

    final int e(Object obj, int i) {
        return f(obj, i, this.f, this.h, this.b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.o;
        if (set != null) {
            return set;
        }
        ara araVar = new ara(this);
        this.o = araVar;
        return araVar;
    }

    final int f(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[u(i)];
        while (i2 != -1) {
            if (apz.b(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    final void g(int i, int i2) {
        A(i, i2, ary.c(this.b[i]));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        int iB = b(obj);
        if (iB == -1) {
            return null;
        }
        return this.b[iB];
    }

    final void h(int i, int i2) {
        A(i, ary.c(this.a[i]), i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final Set<V> values() {
        Set<V> set = this.n;
        if (set != null) {
            return set;
        }
        are areVar = new are(this);
        this.n = areVar;
        return areVar;
    }

    public final aqi<V, K> j() {
        aqi<V, K> aqiVar = this.p;
        if (aqiVar != null) {
            return aqiVar;
        }
        arb arbVar = new arb(this);
        this.p = arbVar;
        return arbVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.m;
        if (set != null) {
            return set;
        }
        ard ardVar = new ard(this);
        this.m = ardVar;
        return ardVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int iC = ary.c(k);
        int iC2 = c(k, iC);
        if (iC2 != -1) {
            V v2 = this.b[iC2];
            if (apz.b(v2, v)) {
                return v;
            }
            C(iC2, v);
            return v2;
        }
        int iC3 = ary.c(v);
        aqd.f(e(v, iC3) == -1, "Value already present: %s", v);
        t(this.c + 1);
        K[] kArr = this.a;
        int i = this.c;
        kArr[i] = k;
        this.b[i] = v;
        w(i, iC);
        x(this.c, iC3);
        v(this.j, this.c);
        v(this.c, -2);
        this.c++;
        this.d++;
        return null;
    }

    final K q(V v, K k) {
        int iC = ary.c(v);
        int iE = e(v, iC);
        if (iE != -1) {
            K k2 = this.a[iE];
            if (apz.b(k2, k)) {
                return k;
            }
            B(iE, k);
            return k2;
        }
        int i = this.j;
        int iC2 = ary.c(k);
        aqd.f(c(k, iC2) == -1, "Key already present: %s", k);
        t(this.c + 1);
        K[] kArr = this.a;
        int i2 = this.c;
        kArr[i2] = k;
        this.b[i2] = v;
        w(i2, iC2);
        x(this.c, iC);
        int i3 = i == -2 ? this.i : this.l[i];
        v(i, this.c);
        v(this.c, i3);
        this.c++;
        this.d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        int iC = ary.c(obj);
        int iC2 = c(obj, iC);
        if (iC2 == -1) {
            return null;
        }
        V v = this.b[iC2];
        g(iC2, iC);
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c;
    }

    private final void v(int i, int i2) {
        if (i == -2) {
            this.i = i2;
        } else {
            this.l[i] = i2;
        }
        if (i2 == -2) {
            this.j = i;
        } else {
            this.k[i2] = i;
        }
    }
}
