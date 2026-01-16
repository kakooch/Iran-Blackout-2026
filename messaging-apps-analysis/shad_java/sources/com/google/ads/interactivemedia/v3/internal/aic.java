package com.google.ads.interactivemedia.v3.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aic<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> f = new ahv();
    final Comparator<? super K> a;
    aib<K, V> b;
    int c;
    int d;
    final aib<K, V> e;
    private ahx g;
    private ahz h;

    public aic() {
        Comparator<Comparable> comparator = f;
        this.c = 0;
        this.d = 0;
        this.e = new aib<>();
        this.a = comparator;
    }

    private final void f(aib<K, V> aibVar, aib<K, V> aibVar2) {
        aib<K, V> aibVar3 = aibVar.a;
        aibVar.a = null;
        if (aibVar2 != null) {
            aibVar2.a = aibVar3;
        }
        if (aibVar3 == null) {
            this.b = aibVar2;
        } else if (aibVar3.b == aibVar) {
            aibVar3.b = aibVar2;
        } else {
            aibVar3.c = aibVar2;
        }
    }

    private final void g(aib<K, V> aibVar, boolean z) {
        while (aibVar != null) {
            aib<K, V> aibVar2 = aibVar.b;
            aib<K, V> aibVar3 = aibVar.c;
            int i = aibVar2 != null ? aibVar2.h : 0;
            int i2 = aibVar3 != null ? aibVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                aib<K, V> aibVar4 = aibVar3.b;
                aib<K, V> aibVar5 = aibVar3.c;
                int i4 = (aibVar4 != null ? aibVar4.h : 0) - (aibVar5 != null ? aibVar5.h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    h(aibVar);
                } else {
                    i(aibVar3);
                    h(aibVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                aib<K, V> aibVar6 = aibVar2.b;
                aib<K, V> aibVar7 = aibVar2.c;
                int i5 = (aibVar6 != null ? aibVar6.h : 0) - (aibVar7 != null ? aibVar7.h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    i(aibVar);
                } else {
                    h(aibVar2);
                    i(aibVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                aibVar.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                aibVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            aibVar = aibVar.a;
        }
    }

    private final void h(aib<K, V> aibVar) {
        aib<K, V> aibVar2 = aibVar.b;
        aib<K, V> aibVar3 = aibVar.c;
        aib<K, V> aibVar4 = aibVar3.b;
        aib<K, V> aibVar5 = aibVar3.c;
        aibVar.c = aibVar4;
        if (aibVar4 != null) {
            aibVar4.a = aibVar;
        }
        f(aibVar, aibVar3);
        aibVar3.b = aibVar;
        aibVar.a = aibVar3;
        int iMax = Math.max(aibVar2 != null ? aibVar2.h : 0, aibVar4 != null ? aibVar4.h : 0) + 1;
        aibVar.h = iMax;
        aibVar3.h = Math.max(iMax, aibVar5 != null ? aibVar5.h : 0) + 1;
    }

    private final void i(aib<K, V> aibVar) {
        aib<K, V> aibVar2 = aibVar.b;
        aib<K, V> aibVar3 = aibVar.c;
        aib<K, V> aibVar4 = aibVar2.b;
        aib<K, V> aibVar5 = aibVar2.c;
        aibVar.b = aibVar5;
        if (aibVar5 != null) {
            aibVar5.a = aibVar;
        }
        f(aibVar, aibVar2);
        aibVar2.c = aibVar;
        aibVar.a = aibVar2;
        int iMax = Math.max(aibVar3 != null ? aibVar3.h : 0, aibVar5 != null ? aibVar5.h : 0) + 1;
        aibVar.h = iMax;
        aibVar2.h = Math.max(iMax, aibVar4 != null ? aibVar4.h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    final aib<K, V> a(K k, boolean z) {
        int iCompareTo;
        aib<K, V> aibVar;
        Comparator<? super K> comparator = this.a;
        aib<K, V> aibVar2 = this.b;
        if (aibVar2 != null) {
            Comparable comparable = comparator == f ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(aibVar2.f) : comparator.compare(k, aibVar2.f);
                if (iCompareTo == 0) {
                    return aibVar2;
                }
                aib<K, V> aibVar3 = iCompareTo < 0 ? aibVar2.b : aibVar2.c;
                if (aibVar3 == null) {
                    break;
                }
                aibVar2 = aibVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        aib<K, V> aibVar4 = this.e;
        if (aibVar2 != null) {
            aibVar = new aib<>(aibVar2, k, aibVar4, aibVar4.e);
            if (iCompareTo < 0) {
                aibVar2.b = aibVar;
            } else {
                aibVar2.c = aibVar;
            }
            g(aibVar2, true);
        } else {
            if (comparator == f && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            aibVar = new aib<>(null, k, aibVar4, aibVar4.e);
            this.b = aibVar;
        }
        this.c++;
        this.d++;
        return aibVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final aib<K, V> b(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    final aib<K, V> c(Map.Entry<?, ?> entry) {
        aib<K, V> aibVarB = b(entry.getKey());
        if (aibVarB == null) {
            return null;
        }
        V v = aibVarB.g;
        Object value = entry.getValue();
        if (v == value || (v != null && v.equals(value))) {
            return aibVarB;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        aib<K, V> aibVar = this.e;
        aibVar.e = aibVar;
        aibVar.d = aibVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return b(obj) != null;
    }

    final void d(aib<K, V> aibVar, boolean z) {
        aib<K, V> aibVar2;
        aib<K, V> aibVar3;
        int i;
        if (z) {
            aib<K, V> aibVar4 = aibVar.e;
            aibVar4.d = aibVar.d;
            aibVar.d.e = aibVar4;
        }
        aib<K, V> aibVar5 = aibVar.b;
        aib<K, V> aibVar6 = aibVar.c;
        aib<K, V> aibVar7 = aibVar.a;
        int i2 = 0;
        if (aibVar5 == null || aibVar6 == null) {
            if (aibVar5 != null) {
                f(aibVar, aibVar5);
                aibVar.b = null;
            } else if (aibVar6 != null) {
                f(aibVar, aibVar6);
                aibVar.c = null;
            } else {
                f(aibVar, null);
            }
            g(aibVar7, false);
            this.c--;
            this.d++;
            return;
        }
        if (aibVar5.h > aibVar6.h) {
            do {
                aibVar3 = aibVar5;
                aibVar5 = aibVar5.c;
            } while (aibVar5 != null);
        } else {
            do {
                aibVar2 = aibVar6;
                aibVar6 = aibVar6.b;
            } while (aibVar6 != null);
            aibVar3 = aibVar2;
        }
        d(aibVar3, false);
        aib<K, V> aibVar8 = aibVar.b;
        if (aibVar8 != null) {
            i = aibVar8.h;
            aibVar3.b = aibVar8;
            aibVar8.a = aibVar3;
            aibVar.b = null;
        } else {
            i = 0;
        }
        aib<K, V> aibVar9 = aibVar.c;
        if (aibVar9 != null) {
            i2 = aibVar9.h;
            aibVar3.c = aibVar9;
            aibVar9.a = aibVar3;
            aibVar.c = null;
        }
        aibVar3.h = Math.max(i, i2) + 1;
        f(aibVar, aibVar3);
    }

    final aib<K, V> e(Object obj) {
        aib<K, V> aibVarB = b(obj);
        if (aibVarB != null) {
            d(aibVarB, true);
        }
        return aibVarB;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        ahx ahxVar = this.g;
        if (ahxVar != null) {
            return ahxVar;
        }
        ahx ahxVar2 = new ahx(this);
        this.g = ahxVar2;
        return ahxVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        aib<K, V> aibVarB = b(obj);
        if (aibVarB != null) {
            return aibVarB.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        ahz ahzVar = this.h;
        if (ahzVar != null) {
            return ahzVar;
        }
        ahz ahzVar2 = new ahz(this);
        this.h = ahzVar2;
        return ahzVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        aib<K, V> aibVarE = e(obj);
        if (aibVarE != null) {
            return aibVarE.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        aib<K, V> aibVarA = a(k, true);
        V v2 = aibVarA.g;
        aibVarA.g = v;
        return v2;
    }
}
