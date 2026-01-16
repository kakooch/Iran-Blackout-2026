package ir.nasim;

/* renamed from: ir.nasim.pI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C18818pI6 implements Cloneable {
    private static final Object e = new Object();
    private boolean a;
    private int[] b;
    private Object[] c;
    private int d;

    public C18818pI6() {
        this(10);
    }

    private void c() {
        int i = this.d;
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.d = i2;
    }

    public boolean b(int i) {
        return f(i) >= 0;
    }

    public Object d(int i) {
        return e(i, null);
    }

    public Object e(int i, Object obj) {
        Object obj2;
        int iA = AbstractC13147fk1.a(this.b, this.d, i);
        return (iA < 0 || (obj2 = this.c[iA]) == e) ? obj : obj2;
    }

    public int f(int i) {
        if (this.a) {
            c();
        }
        return AbstractC13147fk1.a(this.b, this.d, i);
    }

    public int h(int i) {
        if (this.a) {
            c();
        }
        return this.b[i];
    }

    public void i(int i, Object obj) {
        int iA = AbstractC13147fk1.a(this.b, this.d, i);
        if (iA >= 0) {
            this.c[iA] = obj;
            return;
        }
        int i2 = ~iA;
        int i3 = this.d;
        if (i2 < i3) {
            Object[] objArr = this.c;
            if (objArr[i2] == e) {
                this.b[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.a && i3 >= this.b.length) {
            c();
            i2 = ~AbstractC13147fk1.a(this.b, this.d, i);
        }
        int i4 = this.d;
        if (i4 >= this.b.length) {
            int iB = TJ.b(i4 + 1);
            int[] iArr = new int[iB];
            Object[] objArr2 = new Object[iB];
            int[] iArr2 = this.b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.b = iArr;
            this.c = objArr2;
        }
        int i5 = this.d;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.b;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.d - i2);
        }
        this.b[i2] = i;
        this.c[i2] = obj;
        this.d++;
    }

    public int k() {
        if (this.a) {
            c();
        }
        return this.d;
    }

    public Object l(int i) {
        if (this.a) {
            c();
        }
        return this.c[i];
    }

    public String toString() {
        if (k() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(h(i));
            sb.append('=');
            Object objL = l(i);
            if (objL != this) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C18818pI6(int i) {
        this.a = false;
        if (i == 0) {
            this.b = AbstractC13147fk1.b;
            this.c = AbstractC13147fk1.c;
        } else {
            int iB = TJ.b(i);
            this.b = new int[iB];
            this.c = new Object[iB];
        }
        this.d = 0;
    }
}
