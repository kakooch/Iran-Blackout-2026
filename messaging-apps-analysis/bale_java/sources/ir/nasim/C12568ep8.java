package ir.nasim;

import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzft;
import java.util.Arrays;

/* renamed from: ir.nasim.ep8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12568ep8 extends Zn8 implements Cloneable {
    public long b = 0;
    public long c = 0;
    private long d = 0;
    private String e = "";
    public int f = 0;
    private String g = "";
    private int h = 0;
    private boolean i = false;
    private AbstractC14388hp8[] j = AbstractC14388hp8.i();
    private byte[] k;
    private com.google.android.gms.internal.clearcut.x0 l;
    public byte[] m;
    private String n;
    private String o;
    private String p;
    public long q;
    public byte[] r;
    private String s;
    private int t;
    private int[] u;
    private long v;
    private com.google.android.gms.internal.clearcut.y0 w;
    public boolean x;

    public C12568ep8() {
        byte[] bArr = AbstractC22780vo8.h;
        this.k = bArr;
        this.l = null;
        this.m = bArr;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = 180000L;
        this.r = bArr;
        this.s = "";
        this.t = 0;
        this.u = AbstractC22780vo8.a;
        this.v = 0L;
        this.w = null;
        this.x = false;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final C12568ep8 clone() {
        try {
            C12568ep8 c12568ep8 = (C12568ep8) super.h();
            AbstractC14388hp8[] abstractC14388hp8Arr = this.j;
            if (abstractC14388hp8Arr != null && abstractC14388hp8Arr.length > 0) {
                c12568ep8.j = new AbstractC14388hp8[abstractC14388hp8Arr.length];
                int i = 0;
                while (true) {
                    AbstractC14388hp8[] abstractC14388hp8Arr2 = this.j;
                    if (i >= abstractC14388hp8Arr2.length) {
                        break;
                    }
                    AbstractC14388hp8 abstractC14388hp8 = abstractC14388hp8Arr2[i];
                    i++;
                }
            }
            com.google.android.gms.internal.clearcut.x0 x0Var = this.l;
            if (x0Var != null) {
                c12568ep8.l = x0Var;
            }
            int[] iArr = this.u;
            if (iArr != null && iArr.length > 0) {
                c12568ep8.u = (int[]) iArr.clone();
            }
            com.google.android.gms.internal.clearcut.y0 y0Var = this.w;
            if (y0Var != null) {
                c12568ep8.w = y0Var;
            }
            return c12568ep8;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // ir.nasim.Zn8, ir.nasim.AbstractC10561bo8
    public final void b(com.google.android.gms.internal.clearcut.w0 w0Var) throws zzft {
        long j = this.b;
        if (j != 0) {
            w0Var.r(1, j);
        }
        String str = this.e;
        if (str != null && !str.equals("")) {
            w0Var.b(2, this.e);
        }
        AbstractC14388hp8[] abstractC14388hp8Arr = this.j;
        int i = 0;
        if (abstractC14388hp8Arr != null && abstractC14388hp8Arr.length > 0) {
            int i2 = 0;
            while (true) {
                AbstractC14388hp8[] abstractC14388hp8Arr2 = this.j;
                if (i2 >= abstractC14388hp8Arr2.length) {
                    break;
                }
                AbstractC14388hp8 abstractC14388hp8 = abstractC14388hp8Arr2[i2];
                i2++;
            }
        }
        byte[] bArr = this.k;
        byte[] bArr2 = AbstractC22780vo8.h;
        if (!Arrays.equals(bArr, bArr2)) {
            w0Var.c(4, this.k);
        }
        if (!Arrays.equals(this.m, bArr2)) {
            w0Var.c(6, this.m);
        }
        String str2 = this.n;
        if (str2 != null && !str2.equals("")) {
            w0Var.b(8, this.n);
        }
        com.google.android.gms.internal.clearcut.x0 x0Var = this.l;
        if (x0Var != null) {
            w0Var.m(9, x0Var);
        }
        int i3 = this.f;
        if (i3 != 0) {
            w0Var.j(11, i3);
        }
        String str3 = this.o;
        if (str3 != null && !str3.equals("")) {
            w0Var.b(13, this.o);
        }
        String str4 = this.p;
        if (str4 != null && !str4.equals("")) {
            w0Var.b(14, this.p);
        }
        long j2 = this.q;
        if (j2 != 180000) {
            w0Var.h(15, 0);
            w0Var.t(com.google.android.gms.internal.clearcut.w0.s(j2));
        }
        long j3 = this.c;
        if (j3 != 0) {
            w0Var.r(17, j3);
        }
        if (!Arrays.equals(this.r, bArr2)) {
            w0Var.c(18, this.r);
        }
        int[] iArr = this.u;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.u;
                if (i >= iArr2.length) {
                    break;
                }
                w0Var.j(20, iArr2[i]);
                i++;
            }
        }
        com.google.android.gms.internal.clearcut.y0 y0Var = this.w;
        if (y0Var != null) {
            w0Var.m(23, y0Var);
        }
        String str5 = this.s;
        if (str5 != null && !str5.equals("")) {
            w0Var.b(24, this.s);
        }
        boolean z = this.x;
        if (z) {
            w0Var.i(25, z);
        }
        String str6 = this.g;
        if (str6 != null && !str6.equals("")) {
            w0Var.b(26, this.g);
        }
        super.b(w0Var);
    }

    @Override // ir.nasim.Zn8, ir.nasim.AbstractC10561bo8
    protected final int e() {
        int[] iArr;
        int iE = super.e();
        long j = this.b;
        if (j != 0) {
            iE += com.google.android.gms.internal.clearcut.w0.k(1, j);
        }
        String str = this.e;
        if (str != null && !str.equals("")) {
            iE += com.google.android.gms.internal.clearcut.w0.f(2, this.e);
        }
        AbstractC14388hp8[] abstractC14388hp8Arr = this.j;
        int i = 0;
        if (abstractC14388hp8Arr != null && abstractC14388hp8Arr.length > 0) {
            int i2 = 0;
            while (true) {
                AbstractC14388hp8[] abstractC14388hp8Arr2 = this.j;
                if (i2 >= abstractC14388hp8Arr2.length) {
                    break;
                }
                AbstractC14388hp8 abstractC14388hp8 = abstractC14388hp8Arr2[i2];
                i2++;
            }
        }
        byte[] bArr = this.k;
        byte[] bArr2 = AbstractC22780vo8.h;
        if (!Arrays.equals(bArr, bArr2)) {
            iE += com.google.android.gms.internal.clearcut.w0.g(4, this.k);
        }
        if (!Arrays.equals(this.m, bArr2)) {
            iE += com.google.android.gms.internal.clearcut.w0.g(6, this.m);
        }
        String str2 = this.n;
        if (str2 != null && !str2.equals("")) {
            iE += com.google.android.gms.internal.clearcut.w0.f(8, this.n);
        }
        com.google.android.gms.internal.clearcut.x0 x0Var = this.l;
        if (x0Var != null) {
            iE += zzbn.L(9, x0Var);
        }
        int i3 = this.f;
        if (i3 != 0) {
            iE += com.google.android.gms.internal.clearcut.w0.v(11) + com.google.android.gms.internal.clearcut.w0.w(i3);
        }
        String str3 = this.o;
        if (str3 != null && !str3.equals("")) {
            iE += com.google.android.gms.internal.clearcut.w0.f(13, this.o);
        }
        String str4 = this.p;
        if (str4 != null && !str4.equals("")) {
            iE += com.google.android.gms.internal.clearcut.w0.f(14, this.p);
        }
        long j2 = this.q;
        if (j2 != 180000) {
            iE += com.google.android.gms.internal.clearcut.w0.v(15) + com.google.android.gms.internal.clearcut.w0.u(com.google.android.gms.internal.clearcut.w0.s(j2));
        }
        long j3 = this.c;
        if (j3 != 0) {
            iE += com.google.android.gms.internal.clearcut.w0.k(17, j3);
        }
        if (!Arrays.equals(this.r, bArr2)) {
            iE += com.google.android.gms.internal.clearcut.w0.g(18, this.r);
        }
        int[] iArr2 = this.u;
        if (iArr2 != null && iArr2.length > 0) {
            int iW = 0;
            while (true) {
                iArr = this.u;
                if (i >= iArr.length) {
                    break;
                }
                iW += com.google.android.gms.internal.clearcut.w0.w(iArr[i]);
                i++;
            }
            iE = iE + iW + (iArr.length * 2);
        }
        com.google.android.gms.internal.clearcut.y0 y0Var = this.w;
        if (y0Var != null) {
            iE += zzbn.L(23, y0Var);
        }
        String str5 = this.s;
        if (str5 != null && !str5.equals("")) {
            iE += com.google.android.gms.internal.clearcut.w0.f(24, this.s);
        }
        if (this.x) {
            iE += com.google.android.gms.internal.clearcut.w0.v(25) + 1;
        }
        String str6 = this.g;
        return (str6 == null || str6.equals("")) ? iE : iE + com.google.android.gms.internal.clearcut.w0.f(26, this.g);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C12568ep8)) {
            return false;
        }
        C12568ep8 c12568ep8 = (C12568ep8) obj;
        if (this.b != c12568ep8.b || this.c != c12568ep8.c) {
            return false;
        }
        String str = this.e;
        if (str == null) {
            if (c12568ep8.e != null) {
                return false;
            }
        } else if (!str.equals(c12568ep8.e)) {
            return false;
        }
        if (this.f != c12568ep8.f) {
            return false;
        }
        String str2 = this.g;
        if (str2 == null) {
            if (c12568ep8.g != null) {
                return false;
            }
        } else if (!str2.equals(c12568ep8.g)) {
            return false;
        }
        if (!AbstractC9941ao8.b(this.j, c12568ep8.j) || !Arrays.equals(this.k, c12568ep8.k)) {
            return false;
        }
        com.google.android.gms.internal.clearcut.x0 x0Var = this.l;
        if (x0Var == null) {
            if (c12568ep8.l != null) {
                return false;
            }
        } else if (!x0Var.equals(c12568ep8.l)) {
            return false;
        }
        if (!Arrays.equals(this.m, c12568ep8.m)) {
            return false;
        }
        String str3 = this.n;
        if (str3 == null) {
            if (c12568ep8.n != null) {
                return false;
            }
        } else if (!str3.equals(c12568ep8.n)) {
            return false;
        }
        String str4 = this.o;
        if (str4 == null) {
            if (c12568ep8.o != null) {
                return false;
            }
        } else if (!str4.equals(c12568ep8.o)) {
            return false;
        }
        String str5 = this.p;
        if (str5 == null) {
            if (c12568ep8.p != null) {
                return false;
            }
        } else if (!str5.equals(c12568ep8.p)) {
            return false;
        }
        if (this.q != c12568ep8.q || !Arrays.equals(this.r, c12568ep8.r)) {
            return false;
        }
        String str6 = this.s;
        if (str6 == null) {
            if (c12568ep8.s != null) {
                return false;
            }
        } else if (!str6.equals(c12568ep8.s)) {
            return false;
        }
        if (!AbstractC9941ao8.a(this.u, c12568ep8.u)) {
            return false;
        }
        com.google.android.gms.internal.clearcut.y0 y0Var = this.w;
        if (y0Var == null) {
            if (c12568ep8.w != null) {
                return false;
            }
        } else if (!y0Var.equals(c12568ep8.w)) {
            return false;
        }
        return this.x == c12568ep8.x;
    }

    public final int hashCode() {
        int iHashCode = (C12568ep8.class.getName().hashCode() + 527) * 31;
        long j = this.b;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 961;
        String str = this.e;
        int iHashCode2 = (((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.f) * 31;
        String str2 = this.g;
        int iHashCode3 = ((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 961) + 1237) * 31) + AbstractC9941ao8.d(this.j)) * 31) + Arrays.hashCode(this.k);
        com.google.android.gms.internal.clearcut.x0 x0Var = this.l;
        int iHashCode4 = ((((iHashCode3 * 31) + (x0Var == null ? 0 : x0Var.hashCode())) * 31) + Arrays.hashCode(this.m)) * 31;
        String str3 = this.n;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.o;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 961;
        String str5 = this.p;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        long j3 = this.q;
        int iHashCode8 = (((iHashCode7 + ((int) (j3 ^ (j3 >>> 32)))) * 961) + Arrays.hashCode(this.r)) * 31;
        String str6 = this.s;
        int iHashCode9 = ((iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 961) + AbstractC9941ao8.c(this.u);
        com.google.android.gms.internal.clearcut.y0 y0Var = this.w;
        return ((((iHashCode9 * 961) + (y0Var != null ? y0Var.hashCode() : 0)) * 31) + (this.x ? 1231 : 1237)) * 31;
    }
}
