package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class arx<E> extends arj<E> implements Set<E> {
    private transient arn<E> a;

    arx() {
    }

    public static <E> arx<E> h(E e) {
        return new aso(e);
    }

    static int i(int i) {
        double d;
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            aqd.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
            d = iHighestOneBit;
            Double.isNaN(d);
        } while (d * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static <E> arx<E> j(Collection<? extends E> collection) {
        if ((collection instanceof arx) && !(collection instanceof SortedSet)) {
            arx<E> arxVar = (arx) collection;
            if (!arxVar.f()) {
                return arxVar;
            }
        }
        Object[] array = collection.toArray();
        return n(array.length, array);
    }

    public static <E> arx<E> k(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? n(length, (Object[]) eArr.clone()) : h(eArr[0]) : asj.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public abstract asp<E> listIterator();

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    public arn<E> e() {
        arn<E> arnVar = this.a;
        if (arnVar != null) {
            return arnVar;
        }
        arn<E> arnVarM = m();
        this.a = arnVarM;
        return arnVarM;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof arx) && l() && ((arx) obj).l() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return asn.a(this);
    }

    boolean l() {
        return false;
    }

    arn<E> m() {
        return arn.n(toArray());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    Object writeReplace() {
        return new arw(toArray());
    }

    private static <E> arx<E> n(int i, Object... objArr) {
        if (i == 0) {
            return asj.a;
        }
        if (i == 1) {
            return h(objArr[0]);
        }
        int i2 = i(i);
        Object[] objArr2 = new Object[i2];
        int i3 = i2 - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = objArr[i6];
            asn.f(obj, i6);
            int iHashCode = obj.hashCode();
            int iB = ary.b(iHashCode);
            while (true) {
                int i7 = iB & i3;
                Object obj2 = objArr2[i7];
                if (obj2 == null) {
                    objArr[i5] = obj;
                    objArr2[i7] = obj;
                    i4 += iHashCode;
                    i5++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iB++;
            }
        }
        Arrays.fill(objArr, i5, i, (Object) null);
        if (i5 == 1) {
            return new aso(objArr[0], i4);
        }
        if (i(i5) < i2 / 2) {
            return n(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new asj(objArr, i4, objArr2, i3, i5);
    }
}
