package ir.nasim;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: ir.nasim.zC6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C24792zC6 {
    private int[] a;
    private Object[] b;
    private int c;

    public C24792zC6() {
        this(0, 1, null);
    }

    private final int d(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int iA = AbstractC13738gk1.a(this.a, i2, i);
        if (iA < 0 || AbstractC13042fc3.d(obj, this.b[iA << 1])) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (AbstractC13042fc3.d(obj, this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (AbstractC13042fc3.d(obj, this.b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    private final int f() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int iA = AbstractC13738gk1.a(this.a, i, 0);
        if (iA < 0 || this.b[iA << 1] == null) {
            return iA;
        }
        int i2 = iA + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iA - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final int b(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (AbstractC13042fc3.d(obj, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public void c(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i * 2);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.b = objArrCopyOf;
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        if (this.c > 0) {
            this.a = AbstractC13738gk1.a;
            this.b = AbstractC13738gk1.c;
            this.c = 0;
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof C24792zC6) {
                if (size() != ((C24792zC6) obj).size()) {
                    return false;
                }
                C24792zC6 c24792zC6 = (C24792zC6) obj;
                int i = this.c;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objG = g(i2);
                    Object objK = k(i2);
                    Object obj2 = c24792zC6.get(objG);
                    if (objK == null) {
                        if (obj2 != null || !c24792zC6.containsKey(objG)) {
                            return false;
                        }
                    } else if (!AbstractC13042fc3.d(objK, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.c;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objG2 = g(i4);
                Object objK2 = k(i4);
                Object obj3 = ((Map) obj).get(objG2);
                if (objK2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objG2)) {
                        return false;
                    }
                } else if (!AbstractC13042fc3.d(objK2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object g(int i) {
        boolean z = false;
        if (i >= 0 && i < this.c) {
            z = true;
        }
        if (!z) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        return this.b[i << 1];
    }

    public Object get(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return this.b[(iE << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.b[(iE << 1) + 1] : obj2;
    }

    public void h(C24792zC6 c24792zC6) {
        AbstractC13042fc3.i(c24792zC6, "map");
        int i = c24792zC6.c;
        c(this.c + i);
        if (this.c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(c24792zC6.g(i2), c24792zC6.k(i2));
            }
        } else if (i > 0) {
            AbstractC9648aK.j(c24792zC6.a, this.a, 0, 0, i);
            AbstractC9648aK.l(c24792zC6.b, this.b, 0, 0, i << 1);
            this.c = i;
        }
    }

    public int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public Object i(int i) {
        if (!(i >= 0 && i < this.c)) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        Object[] objArr = this.b;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.c;
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i4) {
                    int i5 = i + 1;
                    AbstractC9648aK.j(iArr, iArr, i, i5, i3);
                    Object[] objArr2 = this.b;
                    AbstractC9648aK.l(objArr2, objArr2, i2, i5 << 1, i3 << 1);
                }
                Object[] objArr3 = this.b;
                int i6 = i4 << 1;
                objArr3[i6] = null;
                objArr3[i6 + 1] = null;
            } else {
                int i7 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
                AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
                this.a = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.b, i7 << 1);
                AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
                this.b = objArrCopyOf;
                if (i3 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    AbstractC9648aK.j(iArr, this.a, 0, 0, i);
                    AbstractC9648aK.l(objArr, this.b, 0, 0, i2);
                }
                if (i < i4) {
                    int i8 = i + 1;
                    AbstractC9648aK.j(iArr, this.a, i, i8, i3);
                    AbstractC9648aK.l(objArr, this.b, i2, i8 << 1, i3 << 1);
                }
            }
            if (i3 != this.c) {
                throw new ConcurrentModificationException();
            }
            this.c = i4;
        }
        return obj;
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public Object j(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.c) {
            z = true;
        }
        if (!z) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object k(int i) {
        boolean z = false;
        if (i >= 0 && i < this.c) {
            z = true;
        }
        if (!z) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        return this.b[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i = this.c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iD = obj != null ? d(obj, iHashCode) : f();
        if (iD >= 0) {
            int i2 = (iD << 1) + 1;
            Object[] objArr = this.b;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iD;
        int[] iArr = this.a;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i4 << 1);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.b = objArrCopyOf;
            if (i != this.c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.a;
            int i5 = i3 + 1;
            AbstractC9648aK.j(iArr2, iArr2, i5, i3, i);
            Object[] objArr2 = this.b;
            AbstractC9648aK.l(objArr2, objArr2, i5 << 1, i3 << 1, this.c << 1);
        }
        int i6 = this.c;
        if (i == i6) {
            int[] iArr3 = this.a;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.b;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.c = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE >= 0) {
            return j(iE, obj2);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objG = g(i2);
            if (objG != sb) {
                sb.append(objG);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objK = k(i2);
            if (objK != sb) {
                sb.append(objK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public C24792zC6(int i) {
        this.a = i == 0 ? AbstractC13738gk1.a : new int[i];
        this.b = i == 0 ? AbstractC13738gk1.c : new Object[i << 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0 || !AbstractC13042fc3.d(obj2, k(iE))) {
            return false;
        }
        i(iE);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0 || !AbstractC13042fc3.d(obj2, k(iE))) {
            return false;
        }
        j(iE, obj3);
        return true;
    }

    public /* synthetic */ C24792zC6(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public C24792zC6(C24792zC6 c24792zC6) {
        this(0, 1, null);
        if (c24792zC6 != null) {
            h(c24792zC6);
        }
    }
}
