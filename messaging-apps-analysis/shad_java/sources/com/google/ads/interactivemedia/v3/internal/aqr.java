package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqr<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object d = new Object();
    transient int[] a;
    transient Object[] b;
    transient Object[] c;
    private transient Object e;
    private transient int f;
    private transient int g;
    private transient Set<K> h;
    private transient Set<Map.Entry<K, V>> i;
    private transient Collection<V> j;

    aqr() {
        b(3);
    }

    public static <K, V> aqr<K, V> a() {
        return new aqr<>();
    }

    static /* synthetic */ void p(aqr aqrVar) {
        aqrVar.g--;
    }

    private final void q(int i) {
        this.f = ary.j(this.f, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int r() {
        return (1 << (this.f & 31)) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid size: ");
            sb.append(i);
            throw new InvalidObjectException(sb.toString());
        }
        b(i);
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private final int s(int i, int i2, int i3, int i4) {
        Object objE = ary.e(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            ary.g(objE, i3 & i5, i4 + 1);
        }
        Object obj = this.e;
        int[] iArr = this.a;
        for (int i6 = 0; i6 <= i; i6++) {
            int iF = ary.f(obj, i6);
            while (iF != 0) {
                int i7 = iF - 1;
                int i8 = iArr[i7];
                int i9 = ary.i(i8, i) | i6;
                int i10 = i9 & i5;
                int iF2 = ary.f(objE, i10);
                ary.g(objE, i10, iF);
                iArr[i7] = ary.j(i9, iF2, i5);
                iF = i8 & i;
            }
        }
        this.e = objE;
        q(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t(Object obj) {
        if (c()) {
            return -1;
        }
        int iC = ary.c(obj);
        int iR = r();
        int iF = ary.f(this.e, iC & iR);
        if (iF == 0) {
            return -1;
        }
        int i = ary.i(iC, iR);
        do {
            int i2 = iF - 1;
            int i3 = this.a[i2];
            if (ary.i(i3, iR) == i && apz.b(obj, this.b[i2])) {
                return i2;
            }
            iF = i3 & iR;
        } while (iF != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(Object obj) {
        if (c()) {
            return d;
        }
        int iR = r();
        int iK = ary.k(obj, null, iR, this.e, this.a, this.b, null);
        if (iK == -1) {
            return d;
        }
        Object obj2 = this.c[iK];
        f(iK, iR);
        this.g--;
        e();
        return obj2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> itI = i();
        while (itI.hasNext()) {
            Map.Entry<K, V> next = itI.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    final void b(int i) {
        aqd.e(true, "Expected size must be >= 0");
        this.f = aqd.n(i, 1);
    }

    final boolean c() {
        return this.e == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (c()) {
            return;
        }
        e();
        Map<K, V> mapD = d();
        if (mapD != null) {
            this.f = aqd.n(size(), 3);
            mapD.clear();
            this.e = null;
            this.g = 0;
            return;
        }
        Arrays.fill(this.b, 0, this.g, (Object) null);
        Arrays.fill(this.c, 0, this.g, (Object) null);
        Object obj = this.e;
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(this.a, 0, this.g, 0);
        this.g = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map<K, V> mapD = d();
        return mapD != null ? mapD.containsKey(obj) : t(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map<K, V> mapD = d();
        if (mapD != null) {
            return mapD.containsValue(obj);
        }
        for (int i = 0; i < this.g; i++) {
            if (apz.b(obj, this.c[i])) {
                return true;
            }
        }
        return false;
    }

    final Map<K, V> d() {
        Object obj = this.e;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void e() {
        this.f += 32;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.i;
        if (set != null) {
            return set;
        }
        aqm aqmVar = new aqm(this);
        this.i = aqmVar;
        return aqmVar;
    }

    final void f(int i, int i2) {
        int size = size() - 1;
        if (i >= size) {
            this.b[i] = null;
            this.c[i] = null;
            this.a[i] = 0;
            return;
        }
        Object[] objArr = this.b;
        Object obj = objArr[size];
        objArr[i] = obj;
        Object[] objArr2 = this.c;
        objArr2[i] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        int[] iArr = this.a;
        iArr[i] = iArr[size];
        iArr[size] = 0;
        int iC = ary.c(obj) & i2;
        int iF = ary.f(this.e, iC);
        int i3 = size + 1;
        if (iF == i3) {
            ary.g(this.e, iC, i + 1);
            return;
        }
        while (true) {
            int i4 = iF - 1;
            int[] iArr2 = this.a;
            int i5 = iArr2[i4];
            int i6 = i5 & i2;
            if (i6 == i3) {
                iArr2[i4] = ary.j(i5, i + 1, i2);
                return;
            }
            iF = i6;
        }
    }

    final int g() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Map<K, V> mapD = d();
        if (mapD != null) {
            return mapD.get(obj);
        }
        int iT = t(obj);
        if (iT == -1) {
            return null;
        }
        return (V) this.c[iT];
    }

    final int h(int i) {
        int i2 = i + 1;
        if (i2 < this.g) {
            return i2;
        }
        return -1;
    }

    final Iterator<Map.Entry<K, V>> i() {
        Map<K, V> mapD = d();
        return mapD != null ? mapD.entrySet().iterator() : new aqk(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.h;
        if (set != null) {
            return set;
        }
        aqo aqoVar = new aqo(this);
        this.h = aqoVar;
        return aqoVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int iMin;
        if (c()) {
            aqd.g(c(), "Arrays already allocated");
            int i = this.f;
            int iMax = Math.max(4, ary.d(i + 1));
            this.e = ary.e(iMax);
            q(iMax - 1);
            this.a = new int[i];
            this.b = new Object[i];
            this.c = new Object[i];
        }
        Map<K, V> mapD = d();
        if (mapD != null) {
            return mapD.put(k, v);
        }
        int[] iArr = this.a;
        Object[] objArr = this.b;
        Object[] objArr2 = this.c;
        int i2 = this.g;
        int i3 = i2 + 1;
        int iC = ary.c(k);
        int iR = r();
        int i4 = iC & iR;
        int iF = ary.f(this.e, i4);
        if (iF != 0) {
            int i5 = ary.i(iC, iR);
            int i6 = 0;
            while (true) {
                int i7 = iF - 1;
                int i8 = iArr[i7];
                if (ary.i(i8, iR) == i5 && apz.b(k, objArr[i7])) {
                    V v2 = (V) objArr2[i7];
                    objArr2[i7] = v;
                    return v2;
                }
                int i9 = i8 & iR;
                i6++;
                if (i9 != 0) {
                    iF = i9;
                } else {
                    if (i6 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(r() + 1, 1.0f);
                        int iG = g();
                        while (iG >= 0) {
                            linkedHashMap.put(this.b[iG], this.c[iG]);
                            iG = h(iG);
                        }
                        this.e = linkedHashMap;
                        this.a = null;
                        this.b = null;
                        this.c = null;
                        e();
                        return (V) linkedHashMap.put(k, v);
                    }
                    if (i3 > iR) {
                        iR = s(iR, ary.h(iR), iC, i2);
                    } else {
                        iArr[i7] = ary.j(i8, i3, iR);
                    }
                }
            }
        } else if (i3 > iR) {
            iR = s(iR, ary.h(iR), iC, i2);
        } else {
            ary.g(this.e, i4, i3);
        }
        int length = this.a.length;
        if (i3 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.a = Arrays.copyOf(this.a, iMin);
            this.b = Arrays.copyOf(this.b, iMin);
            this.c = Arrays.copyOf(this.c, iMin);
        }
        this.a[i2] = ary.j(iC, 0, iR);
        this.b[i2] = k;
        this.c[i2] = v;
        this.g = i3;
        e();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        Map<K, V> mapD = d();
        if (mapD != null) {
            return mapD.remove(obj);
        }
        V v = (V) u(obj);
        if (v == d) {
            return null;
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> mapD = d();
        return mapD != null ? mapD.size() : this.g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.j;
        if (collection != null) {
            return collection;
        }
        aqq aqqVar = new aqq(this);
        this.j = aqqVar;
        return aqqVar;
    }
}
