package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.qI6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C19409qI6 implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ int[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public C19409qI6() {
        this(0, 1, null);
    }

    public void b(int i, Object obj) {
        int i2 = this.d;
        if (i2 != 0 && i <= this.b[i2 - 1]) {
            l(i, obj);
            return;
        }
        if (this.a && i2 >= this.b.length) {
            AbstractC20000rI6.d(this);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int iE = AbstractC13738gk1.e(i3 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.b, iE);
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iE);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        this.b[i3] = i;
        this.c[i3] = obj;
        this.d = i3 + 1;
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
    public C19409qI6 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC13042fc3.g(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        C19409qI6 c19409qI6 = (C19409qI6) objClone;
        c19409qI6.b = (int[]) this.b.clone();
        c19409qI6.c = (Object[]) this.c.clone();
        return c19409qI6;
    }

    public boolean e(int i) {
        return h(i) >= 0;
    }

    public Object f(int i) {
        return AbstractC20000rI6.c(this, i);
    }

    public int h(int i) {
        if (this.a) {
            AbstractC20000rI6.d(this);
        }
        return AbstractC13738gk1.a(this.b, this.d, i);
    }

    public int i(Object obj) {
        if (this.a) {
            AbstractC20000rI6.d(this);
        }
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.c[i2] == obj) {
                return i2;
            }
        }
        return -1;
    }

    public int k(int i) {
        if (this.a) {
            AbstractC20000rI6.d(this);
        }
        return this.b[i];
    }

    public void l(int i, Object obj) {
        int iA = AbstractC13738gk1.a(this.b, this.d, i);
        if (iA >= 0) {
            this.c[iA] = obj;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.d && this.c[i2] == AbstractC20000rI6.a) {
            this.b[i2] = i;
            this.c[i2] = obj;
            return;
        }
        if (this.a && this.d >= this.b.length) {
            AbstractC20000rI6.d(this);
            i2 = ~AbstractC13738gk1.a(this.b, this.d, i);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int iE = AbstractC13738gk1.e(i3 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.b, iE);
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iE);
            AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
            this.c = objArrCopyOf;
        }
        int i4 = this.d;
        if (i4 - i2 != 0) {
            int[] iArr = this.b;
            int i5 = i2 + 1;
            AbstractC9648aK.j(iArr, iArr, i5, i2, i4);
            Object[] objArr = this.c;
            AbstractC9648aK.l(objArr, objArr, i5, i2, this.d);
        }
        this.b[i2] = i;
        this.c[i2] = obj;
        this.d++;
    }

    public void m(int i) {
        if (this.c[i] != AbstractC20000rI6.a) {
            this.c[i] = AbstractC20000rI6.a;
            this.a = true;
        }
    }

    public Object n(int i, Object obj) {
        int iH = h(i);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.c;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    public int o() {
        if (this.a) {
            AbstractC20000rI6.d(this);
        }
        return this.d;
    }

    public Object p(int i) {
        if (this.a) {
            AbstractC20000rI6.d(this);
        }
        Object[] objArr = this.c;
        if (i < objArr.length) {
            return objArr[i];
        }
        SW0 sw0 = SW0.a;
        throw new ArrayIndexOutOfBoundsException();
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
            if (objP != this) {
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

    public C19409qI6(int i) {
        if (i == 0) {
            this.b = AbstractC13738gk1.a;
            this.c = AbstractC13738gk1.c;
        } else {
            int iE = AbstractC13738gk1.e(i);
            this.b = new int[iE];
            this.c = new Object[iE];
        }
    }

    public /* synthetic */ C19409qI6(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
