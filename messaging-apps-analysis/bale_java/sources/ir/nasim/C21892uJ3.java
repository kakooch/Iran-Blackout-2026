package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.uJ3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C21892uJ3 implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ long[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public C21892uJ3() {
        this(0, 1, null);
    }

    public void b(long j, Object obj) {
        int i = this.d;
        if (i != 0 && j <= this.b[i - 1]) {
            l(j, obj);
            return;
        }
        if (this.a) {
            long[] jArr = this.b;
            if (i >= jArr.length) {
                Object[] objArr = this.c;
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    Object obj2 = objArr[i3];
                    if (obj2 != AbstractC22482vJ3.a) {
                        if (i3 != i2) {
                            jArr[i2] = jArr[i3];
                            objArr[i2] = obj2;
                            objArr[i3] = null;
                        }
                        i2++;
                    }
                }
                this.a = false;
                this.d = i2;
            }
        }
        int i4 = this.d;
        if (i4 >= this.b.length) {
            int iF = AbstractC13738gk1.f(i4 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.b, iF);
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iF);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        this.b[i4] = j;
        this.c[i4] = obj;
        this.d = i4 + 1;
    }

    public void c() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.a = false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C21892uJ3 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC13042fc3.g(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        C21892uJ3 c21892uJ3 = (C21892uJ3) objClone;
        c21892uJ3.b = (long[]) this.b.clone();
        c21892uJ3.c = (Object[]) this.c.clone();
        return c21892uJ3;
    }

    public boolean e(long j) {
        return h(j) >= 0;
    }

    public Object f(long j) {
        int iB = AbstractC13738gk1.b(this.b, this.d, j);
        if (iB < 0 || this.c[iB] == AbstractC22482vJ3.a) {
            return null;
        }
        return this.c[iB];
    }

    public int h(long j) {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != AbstractC22482vJ3.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return AbstractC13738gk1.b(this.b, this.d, j);
    }

    public boolean i() {
        return o() == 0;
    }

    public long k(int i) {
        if (!(i >= 0 && i < this.d)) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        if (this.a) {
            int i2 = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != AbstractC22482vJ3.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.b[i];
    }

    public void l(long j, Object obj) {
        int iB = AbstractC13738gk1.b(this.b, this.d, j);
        if (iB >= 0) {
            this.c[iB] = obj;
            return;
        }
        int i = ~iB;
        if (i < this.d && this.c[i] == AbstractC22482vJ3.a) {
            this.b[i] = j;
            this.c[i] = obj;
            return;
        }
        if (this.a) {
            int i2 = this.d;
            long[] jArr = this.b;
            if (i2 >= jArr.length) {
                Object[] objArr = this.c;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj2 = objArr[i4];
                    if (obj2 != AbstractC22482vJ3.a) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr[i3] = obj2;
                            objArr[i4] = null;
                        }
                        i3++;
                    }
                }
                this.a = false;
                this.d = i3;
                i = ~AbstractC13738gk1.b(this.b, i3, j);
            }
        }
        int i5 = this.d;
        if (i5 >= this.b.length) {
            int iF = AbstractC13738gk1.f(i5 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.b, iF);
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iF);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        int i6 = this.d;
        if (i6 - i != 0) {
            long[] jArr2 = this.b;
            int i7 = i + 1;
            AbstractC9648aK.k(jArr2, jArr2, i7, i, i6);
            Object[] objArr2 = this.c;
            AbstractC9648aK.l(objArr2, objArr2, i7, i, this.d);
        }
        this.b[i] = j;
        this.c[i] = obj;
        this.d++;
    }

    public void m(long j) {
        int iB = AbstractC13738gk1.b(this.b, this.d, j);
        if (iB < 0 || this.c[iB] == AbstractC22482vJ3.a) {
            return;
        }
        this.c[iB] = AbstractC22482vJ3.a;
        this.a = true;
    }

    public void n(int i) {
        if (this.c[i] != AbstractC22482vJ3.a) {
            this.c[i] = AbstractC22482vJ3.a;
            this.a = true;
        }
    }

    public int o() {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != AbstractC22482vJ3.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return this.d;
    }

    public Object p(int i) {
        if (!(i >= 0 && i < this.d)) {
            AbstractC22970w76.a("Expected index to be within 0..size()-1, but was " + i);
        }
        if (this.a) {
            int i2 = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != AbstractC22482vJ3.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.c[i];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(k(i2));
            sb.append('=');
            Object objP = p(i2);
            if (objP != sb) {
                sb.append(objP);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public C21892uJ3(int i) {
        if (i == 0) {
            this.b = AbstractC13738gk1.b;
            this.c = AbstractC13738gk1.c;
        } else {
            int iF = AbstractC13738gk1.f(i);
            this.b = new long[iF];
            this.c = new Object[iF];
        }
    }

    public /* synthetic */ C21892uJ3(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
