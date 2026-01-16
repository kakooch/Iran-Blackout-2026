package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.Pt3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6970Pt3 {
    private final List a;
    private final C23677xK3 b;
    private final String c;
    private final long d;
    private final a e;
    private final long f;
    private final String g;
    private final List h;
    private final C3636Bs i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final float o;
    private final float p;
    private final C23407ws q;
    private final C23997xs r;
    private final C17380ms s;
    private final List t;
    private final b u;
    private final boolean v;
    private final C4474Fh0 w;
    private final C18061o12 x;
    private final EnumC6469Nr3 y;

    /* renamed from: ir.nasim.Pt3$a */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* renamed from: ir.nasim.Pt3$b */
    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public C6970Pt3(List list, C23677xK3 c23677xK3, String str, long j, a aVar, long j2, String str2, List list2, C3636Bs c3636Bs, int i, int i2, int i3, float f, float f2, float f3, float f4, C23407ws c23407ws, C23997xs c23997xs, List list3, b bVar, C17380ms c17380ms, boolean z, C4474Fh0 c4474Fh0, C18061o12 c18061o12, EnumC6469Nr3 enumC6469Nr3) {
        this.a = list;
        this.b = c23677xK3;
        this.c = str;
        this.d = j;
        this.e = aVar;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = c3636Bs;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = c23407ws;
        this.r = c23997xs;
        this.t = list3;
        this.u = bVar;
        this.s = c17380ms;
        this.v = z;
        this.w = c4474Fh0;
        this.x = c18061o12;
        this.y = enumC6469Nr3;
    }

    public EnumC6469Nr3 a() {
        return this.y;
    }

    public C4474Fh0 b() {
        return this.w;
    }

    C23677xK3 c() {
        return this.b;
    }

    public C18061o12 d() {
        return this.x;
    }

    public long e() {
        return this.d;
    }

    List f() {
        return this.t;
    }

    public a g() {
        return this.e;
    }

    List h() {
        return this.h;
    }

    b i() {
        return this.u;
    }

    public String j() {
        return this.c;
    }

    long k() {
        return this.f;
    }

    float l() {
        return this.p;
    }

    float m() {
        return this.o;
    }

    public String n() {
        return this.g;
    }

    List o() {
        return this.a;
    }

    int p() {
        return this.l;
    }

    int q() {
        return this.k;
    }

    int r() {
        return this.j;
    }

    float s() {
        return this.n / this.b.e();
    }

    C23407ws t() {
        return this.q;
    }

    public String toString() {
        return z("");
    }

    C23997xs u() {
        return this.r;
    }

    C17380ms v() {
        return this.s;
    }

    float w() {
        return this.m;
    }

    C3636Bs x() {
        return this.i;
    }

    public boolean y() {
        return this.v;
    }

    public String z(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j());
        sb.append(Separators.RETURN);
        C6970Pt3 c6970Pt3U = this.b.u(k());
        if (c6970Pt3U != null) {
            sb.append("\t\tParents: ");
            sb.append(c6970Pt3U.j());
            C6970Pt3 c6970Pt3U2 = this.b.u(c6970Pt3U.k());
            while (c6970Pt3U2 != null) {
                sb.append("->");
                sb.append(c6970Pt3U2.j());
                c6970Pt3U2 = this.b.u(c6970Pt3U2.k());
            }
            sb.append(str);
            sb.append(Separators.RETURN);
        }
        if (!h().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(h().size());
            sb.append(Separators.RETURN);
        }
        if (r() != 0 && q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append(Separators.RETURN);
            }
        }
        return sb.toString();
    }
}
