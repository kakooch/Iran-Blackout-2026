package ir.nasim;

/* renamed from: ir.nasim.p15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18655p15 {
    private final boolean a;
    private final boolean b;

    /* renamed from: ir.nasim.p15$a */
    public static final class a extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private final boolean g;
        private final float h;
        private final float i;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            boolean z3 = false;
            super(z3, z3, 3, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = z;
            this.g = z2;
            this.h = f4;
            this.i = f5;
        }

        public final float c() {
            return this.h;
        }

        public final float d() {
            return this.i;
        }

        public final float e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.c, aVar.c) == 0 && Float.compare(this.d, aVar.d) == 0 && Float.compare(this.e, aVar.e) == 0 && this.f == aVar.f && this.g == aVar.g && Float.compare(this.h, aVar.h) == 0 && Float.compare(this.i, aVar.i) == 0;
        }

        public final float f() {
            return this.e;
        }

        public final float g() {
            return this.d;
        }

        public final boolean h() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i);
        }

        public final boolean i() {
            return this.g;
        }

        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.c + ", verticalEllipseRadius=" + this.d + ", theta=" + this.e + ", isMoreThanHalf=" + this.f + ", isPositiveArc=" + this.g + ", arcStartX=" + this.h + ", arcStartY=" + this.i + ')';
        }
    }

    /* renamed from: ir.nasim.p15$b */
    public static final class b extends AbstractC18655p15 {
        public static final b c = new b();

        /* JADX WARN: Illegal instructions before constructor call */
        private b() {
            boolean z = false;
            super(z, z, 3, null);
        }
    }

    /* renamed from: ir.nasim.p15$c */
    public static final class c extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;
        private final float g;
        private final float h;

        public c(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
            this.g = f5;
            this.h = f6;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.c, cVar.c) == 0 && Float.compare(this.d, cVar.d) == 0 && Float.compare(this.e, cVar.e) == 0 && Float.compare(this.f, cVar.f) == 0 && Float.compare(this.g, cVar.g) == 0 && Float.compare(this.h, cVar.h) == 0;
        }

        public final float f() {
            return this.d;
        }

        public final float g() {
            return this.f;
        }

        public final float h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h);
        }

        public String toString() {
            return "CurveTo(x1=" + this.c + ", y1=" + this.d + ", x2=" + this.e + ", y2=" + this.f + ", x3=" + this.g + ", y3=" + this.h + ')';
        }
    }

    /* renamed from: ir.nasim.p15$d */
    public static final class d extends AbstractC18655p15 {
        private final float c;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Float.compare(this.c, ((d) obj).c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.c);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.c + ')';
        }
    }

    /* renamed from: ir.nasim.p15$e */
    public static final class e extends AbstractC18655p15 {
        private final float c;
        private final float d;

        /* JADX WARN: Illegal instructions before constructor call */
        public e(float f, float f2) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Float.compare(this.c, eVar.c) == 0 && Float.compare(this.d, eVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "LineTo(x=" + this.c + ", y=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$f */
    public static final class f extends AbstractC18655p15 {
        private final float c;
        private final float d;

        /* JADX WARN: Illegal instructions before constructor call */
        public f(float f, float f2) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Float.compare(this.c, fVar.c) == 0 && Float.compare(this.d, fVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "MoveTo(x=" + this.c + ", y=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$g */
    public static final class g extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;

        public g(float f, float f2, float f3, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Float.compare(this.c, gVar.c) == 0 && Float.compare(this.d, gVar.d) == 0 && Float.compare(this.e, gVar.e) == 0 && Float.compare(this.f, gVar.f) == 0;
        }

        public final float f() {
            return this.f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
        }

        public String toString() {
            return "QuadTo(x1=" + this.c + ", y1=" + this.d + ", x2=" + this.e + ", y2=" + this.f + ')';
        }
    }

    /* renamed from: ir.nasim.p15$h */
    public static final class h extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;

        public h(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Float.compare(this.c, hVar.c) == 0 && Float.compare(this.d, hVar.d) == 0 && Float.compare(this.e, hVar.e) == 0 && Float.compare(this.f, hVar.f) == 0;
        }

        public final float f() {
            return this.f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.c + ", y1=" + this.d + ", x2=" + this.e + ", y2=" + this.f + ')';
        }
    }

    /* renamed from: ir.nasim.p15$i */
    public static final class i extends AbstractC18655p15 {
        private final float c;
        private final float d;

        public i(float f, float f2) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Float.compare(this.c, iVar.c) == 0 && Float.compare(this.d, iVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "ReflectiveQuadTo(x=" + this.c + ", y=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$j */
    public static final class j extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final boolean f;
        private final boolean g;
        private final float h;
        private final float i;

        /* JADX WARN: Illegal instructions before constructor call */
        public j(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            boolean z3 = false;
            super(z3, z3, 3, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = z;
            this.g = z2;
            this.h = f4;
            this.i = f5;
        }

        public final float c() {
            return this.h;
        }

        public final float d() {
            return this.i;
        }

        public final float e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Float.compare(this.c, jVar.c) == 0 && Float.compare(this.d, jVar.d) == 0 && Float.compare(this.e, jVar.e) == 0 && this.f == jVar.f && this.g == jVar.g && Float.compare(this.h, jVar.h) == 0 && Float.compare(this.i, jVar.i) == 0;
        }

        public final float f() {
            return this.e;
        }

        public final float g() {
            return this.d;
        }

        public final boolean h() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i);
        }

        public final boolean i() {
            return this.g;
        }

        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.c + ", verticalEllipseRadius=" + this.d + ", theta=" + this.e + ", isMoreThanHalf=" + this.f + ", isPositiveArc=" + this.g + ", arcStartDx=" + this.h + ", arcStartDy=" + this.i + ')';
        }
    }

    /* renamed from: ir.nasim.p15$k */
    public static final class k extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;
        private final float g;
        private final float h;

        public k(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
            this.g = f5;
            this.h = f6;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return Float.compare(this.c, kVar.c) == 0 && Float.compare(this.d, kVar.d) == 0 && Float.compare(this.e, kVar.e) == 0 && Float.compare(this.f, kVar.f) == 0 && Float.compare(this.g, kVar.g) == 0 && Float.compare(this.h, kVar.h) == 0;
        }

        public final float f() {
            return this.d;
        }

        public final float g() {
            return this.f;
        }

        public final float h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.c + ", dy1=" + this.d + ", dx2=" + this.e + ", dy2=" + this.f + ", dx3=" + this.g + ", dy3=" + this.h + ')';
        }
    }

    /* renamed from: ir.nasim.p15$l */
    public static final class l extends AbstractC18655p15 {
        private final float c;

        /* JADX WARN: Illegal instructions before constructor call */
        public l(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Float.compare(this.c, ((l) obj).c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.c);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.c + ')';
        }
    }

    /* renamed from: ir.nasim.p15$m */
    public static final class m extends AbstractC18655p15 {
        private final float c;
        private final float d;

        /* JADX WARN: Illegal instructions before constructor call */
        public m(float f, float f2) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return Float.compare(this.c, mVar.c) == 0 && Float.compare(this.d, mVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.c + ", dy=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$n */
    public static final class n extends AbstractC18655p15 {
        private final float c;
        private final float d;

        /* JADX WARN: Illegal instructions before constructor call */
        public n(float f, float f2) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return Float.compare(this.c, nVar.c) == 0 && Float.compare(this.d, nVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "RelativeMoveTo(dx=" + this.c + ", dy=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$o */
    public static final class o extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;

        public o(float f, float f2, float f3, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return Float.compare(this.c, oVar.c) == 0 && Float.compare(this.d, oVar.d) == 0 && Float.compare(this.e, oVar.e) == 0 && Float.compare(this.f, oVar.f) == 0;
        }

        public final float f() {
            return this.f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
        }

        public String toString() {
            return "RelativeQuadTo(dx1=" + this.c + ", dy1=" + this.d + ", dx2=" + this.e + ", dy2=" + this.f + ')';
        }
    }

    /* renamed from: ir.nasim.p15$p */
    public static final class p extends AbstractC18655p15 {
        private final float c;
        private final float d;
        private final float e;
        private final float f;

        public p(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.e;
        }

        public final float e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return Float.compare(this.c, pVar.c) == 0 && Float.compare(this.d, pVar.d) == 0 && Float.compare(this.e, pVar.e) == 0 && Float.compare(this.f, pVar.f) == 0;
        }

        public final float f() {
            return this.f;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.c) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Float.hashCode(this.f);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.c + ", dy1=" + this.d + ", dx2=" + this.e + ", dy2=" + this.f + ')';
        }
    }

    /* renamed from: ir.nasim.p15$q */
    public static final class q extends AbstractC18655p15 {
        private final float c;
        private final float d;

        public q(float f, float f2) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.c = f;
            this.d = f2;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            return Float.compare(this.c, qVar.c) == 0 && Float.compare(this.d, qVar.d) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.c) * 31) + Float.hashCode(this.d);
        }

        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.c + ", dy=" + this.d + ')';
        }
    }

    /* renamed from: ir.nasim.p15$r */
    public static final class r extends AbstractC18655p15 {
        private final float c;

        /* JADX WARN: Illegal instructions before constructor call */
        public r(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && Float.compare(this.c, ((r) obj).c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.c);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.c + ')';
        }
    }

    /* renamed from: ir.nasim.p15$s */
    public static final class s extends AbstractC18655p15 {
        private final float c;

        /* JADX WARN: Illegal instructions before constructor call */
        public s(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.c = f;
        }

        public final float c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && Float.compare(this.c, ((s) obj).c) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.c);
        }

        public String toString() {
            return "VerticalTo(y=" + this.c + ')';
        }
    }

    public /* synthetic */ AbstractC18655p15(boolean z, boolean z2, ED1 ed1) {
        this(z, z2);
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    private AbstractC18655p15(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public /* synthetic */ AbstractC18655p15(boolean z, boolean z2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, null);
    }
}
