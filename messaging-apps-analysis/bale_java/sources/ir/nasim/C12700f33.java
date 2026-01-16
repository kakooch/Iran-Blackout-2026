package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.f33, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12700f33 {
    public static final b k;
    private static int l;
    private static final Object m;
    private final String a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final SQ7 f;
    private final long g;
    private final int h;
    private final boolean i;
    private final int j;

    /* renamed from: ir.nasim.f33$a */
    public static final class a {
        private final String a;
        private final float b;
        private final float c;
        private final float d;
        private final float e;
        private final long f;
        private final int g;
        private final boolean h;
        private final ArrayList i;
        private C1069a j;
        private boolean k;

        public /* synthetic */ a(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, ED1 ed1) {
            this(str, f, f2, f3, f4, j, i, z);
        }

        private final SQ7 e(C1069a c1069a) {
            return new SQ7(c1069a.c(), c1069a.f(), c1069a.d(), c1069a.e(), c1069a.g(), c1069a.h(), c1069a.i(), c1069a.j(), c1069a.b(), c1069a.a());
        }

        private final void h() {
            if (!this.k) {
                return;
            }
            M73.b("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
        }

        private final C1069a i() {
            return (C1069a) AbstractC13927h33.d(this.i);
        }

        public final a a(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list) {
            h();
            AbstractC13927h33.f(this.i, new C1069a(str, f, f2, f3, f4, f5, f6, f7, list, null, 512, null));
            return this;
        }

        public final a c(List list, int i, String str, AbstractC12520el0 abstractC12520el0, float f, AbstractC12520el0 abstractC12520el02, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7) {
            h();
            i().a().add(new WQ7(str, list, i, abstractC12520el0, f, abstractC12520el02, f2, f3, i2, i3, f4, f5, f6, f7, null));
            return this;
        }

        public final C12700f33 f() {
            h();
            while (this.i.size() > 1) {
                g();
            }
            C12700f33 c12700f33 = new C12700f33(this.a, this.b, this.c, this.d, this.e, e(this.j), this.f, this.g, this.h, 0, 512, null);
            this.k = true;
            return c12700f33;
        }

        public final a g() {
            h();
            i().a().add(e((C1069a) AbstractC13927h33.e(this.i)));
            return this;
        }

        private a(String str, float f, float f2, float f3, float f4, long j, int i, boolean z) {
            this.a = str;
            this.b = f;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = j;
            this.g = i;
            this.h = z;
            ArrayList arrayList = new ArrayList();
            this.i = arrayList;
            C1069a c1069a = new C1069a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 1023, null);
            this.j = c1069a;
            AbstractC13927h33.f(arrayList, c1069a);
        }

        /* renamed from: ir.nasim.f33$a$a, reason: collision with other inner class name */
        private static final class C1069a {
            private String a;
            private float b;
            private float c;
            private float d;
            private float e;
            private float f;
            private float g;
            private float h;
            private List i;
            private List j;

            public C1069a(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, List list2) {
                this.a = str;
                this.b = f;
                this.c = f2;
                this.d = f3;
                this.e = f4;
                this.f = f5;
                this.g = f6;
                this.h = f7;
                this.i = list;
                this.j = list2;
            }

            public final List a() {
                return this.j;
            }

            public final List b() {
                return this.i;
            }

            public final String c() {
                return this.a;
            }

            public final float d() {
                return this.c;
            }

            public final float e() {
                return this.d;
            }

            public final float f() {
                return this.b;
            }

            public final float g() {
                return this.e;
            }

            public final float h() {
                return this.f;
            }

            public final float i() {
                return this.g;
            }

            public final float j() {
                return this.h;
            }

            public /* synthetic */ C1069a(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, List list2, int i, ED1 ed1) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3, (i & 16) != 0 ? 1.0f : f4, (i & 32) == 0 ? f5 : 1.0f, (i & 64) != 0 ? 0.0f : f6, (i & 128) == 0 ? f7 : 0.0f, (i & 256) != 0 ? TQ7.d() : list, (i & 512) != 0 ? new ArrayList() : list2);
            }
        }

        public /* synthetic */ a(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? "" : str, f, f2, f3, f4, (i2 & 32) != 0 ? C24381yX0.b.i() : j, (i2 & 64) != 0 ? AbstractC7094Qg0.a.z() : i, (i2 & 128) != 0 ? false : z, null);
        }
    }

    /* renamed from: ir.nasim.f33$b */
    public static final class b {
        private b() {
        }

        public final int a() {
            int i;
            synchronized (C12700f33.m) {
                i = C12700f33.l;
                C12700f33.l = i + 1;
            }
            return i;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static {
        b bVar = new b(null);
        k = bVar;
        m = bVar;
    }

    public /* synthetic */ C12700f33(String str, float f, float f2, float f3, float f4, SQ7 sq7, long j, int i, boolean z, int i2, ED1 ed1) {
        this(str, f, f2, f3, f4, sq7, j, i, z, i2);
    }

    public final boolean d() {
        return this.i;
    }

    public final float e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12700f33)) {
            return false;
        }
        C12700f33 c12700f33 = (C12700f33) obj;
        return AbstractC13042fc3.d(this.a, c12700f33.a) && C17784nZ1.s(this.b, c12700f33.b) && C17784nZ1.s(this.c, c12700f33.c) && this.d == c12700f33.d && this.e == c12700f33.e && AbstractC13042fc3.d(this.f, c12700f33.f) && C24381yX0.q(this.g, c12700f33.g) && AbstractC7094Qg0.E(this.h, c12700f33.h) && this.i == c12700f33.i;
    }

    public final float f() {
        return this.b;
    }

    public final int g() {
        return this.j;
    }

    public final String h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + C24381yX0.w(this.g)) * 31) + AbstractC7094Qg0.F(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public final SQ7 i() {
        return this.f;
    }

    public final int j() {
        return this.h;
    }

    public final long k() {
        return this.g;
    }

    public final float l() {
        return this.e;
    }

    public final float m() {
        return this.d;
    }

    private C12700f33(String str, float f, float f2, float f3, float f4, SQ7 sq7, long j, int i, boolean z, int i2) {
        this.a = str;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = sq7;
        this.g = j;
        this.h = i;
        this.i = z;
        this.j = i2;
    }

    public /* synthetic */ C12700f33(String str, float f, float f2, float f3, float f4, SQ7 sq7, long j, int i, boolean z, int i2, int i3, ED1 ed1) {
        this(str, f, f2, f3, f4, sq7, j, i, z, (i3 & 512) != 0 ? k.a() : i2, null);
    }
}
