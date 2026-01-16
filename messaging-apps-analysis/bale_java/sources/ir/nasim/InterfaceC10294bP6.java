package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.bP6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC10294bP6 {

    /* renamed from: ir.nasim.bP6$a */
    public static final class a implements InterfaceC10294bP6 {
        private final int a;
        private final Integer d;
        private final String b = "click";
        private final int c = 4;
        private final String e = "";

        public a(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.d;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "AfkarClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$b */
    public static final class b implements InterfaceC10294bP6 {
        private final int a;
        private final Integer d;
        private final String b = "send";
        private final int c = 4;
        private final String e = "";

        public b(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.d;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "AfkarSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$c */
    public static final class c implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final Integer e;

        public c(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 4;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.e;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "AfkarSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$d */
    public static final class d implements InterfaceC10294bP6 {
        private final int a;
        private final Void c;
        private final String b = "click";
        private final int d = 1;
        private final String e = "";

        public d(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public /* bridge */ /* synthetic */ Integer b() {
            return (Integer) k();
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public Void k() {
            return this.c;
        }

        public String toString() {
            return "CameraClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$e */
    public static final class e implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "click";
        private final int c = 1;
        private final int d = 1;
        private final String e = "";

        public e(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.a == ((e) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "CameraPhotoClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$f */
    public static final class f implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "send";
        private final int c = 1;
        private final int d = 1;
        private final String e = "";

        public f(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.a == ((f) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "CameraPhotoSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$g */
    public static final class g implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final int e;

        public g(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 1;
            this.e = 1;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && AbstractC13042fc3.d(this.b, gVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.e);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "CameraPhotoSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$h */
    public static final class h implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "click";
        private final int c = 2;
        private final int d = 1;
        private final String e = "";

        public h(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && this.a == ((h) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "CameraVideoClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$i */
    public static final class i implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "send";
        private final int c = 2;
        private final int d = 1;
        private final String e = "";

        public i(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && this.a == ((i) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "CameraVideoSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$j */
    public static final class j implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final int e;

        public j(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 2;
            this.e = 1;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return this.a == jVar.a && AbstractC13042fc3.d(this.b, jVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.e);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "CameraVideoSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$k */
    public static final class k implements InterfaceC10294bP6 {
        private final int a;
        private final Integer c;
        private final String b = "click";
        private final int d = 2;
        private final String e = "";

        public k(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && this.a == ((k) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "GalleryClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$l */
    public static final class l implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "send";
        private final int c = 1;
        private final int d = 2;
        private final String e = "";

        public l(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && this.a == ((l) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "GalleryPhotoSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$m */
    public static final class m implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final int e;

        public m(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 1;
            this.e = 2;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return this.a == mVar.a && AbstractC13042fc3.d(this.b, mVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.e);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "GalleryPhotoSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$n */
    public static final class n implements InterfaceC10294bP6 {
        private final int a;
        private final String b = "send";
        private final int c = 2;
        private final int d = 2;
        private final String e = "";

        public n(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.a == ((n) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.d);
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "GalleryVideoSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$o */
    public static final class o implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final int e;

        public o(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 2;
            this.e = 2;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return this.a == oVar.a && AbstractC13042fc3.d(this.b, oVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return Integer.valueOf(this.e);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "GalleryVideoSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$p */
    public static final class p implements InterfaceC10294bP6 {
        private final int a;
        private final Void b;
        private final Void c;
        private final Void d;
        private final String e = "";

        public p(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public /* bridge */ /* synthetic */ Integer b() {
            return (Integer) m();
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public /* bridge */ /* synthetic */ String c() {
            return (String) l();
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.a == ((p) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public /* bridge */ /* synthetic */ Integer h() {
            return (Integer) k();
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public Void k() {
            return this.d;
        }

        public Void l() {
            return this.b;
        }

        public Void m() {
            return this.c;
        }

        public String toString() {
            return "OpenFromSource(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$q */
    public static final class q implements InterfaceC10294bP6 {
        private final int a;
        private final Integer d;
        private final String b = "click";
        private final int c = 3;
        private final String e = "";

        public q(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && this.a == ((q) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.d;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "TextClick(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$r */
    public static final class r implements InterfaceC10294bP6 {
        private final int a;
        private final Integer d;
        private final String b = "send";
        private final int c = 3;
        private final String e = "";

        public r(int i) {
            this.a = i;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.e;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.c);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.a == ((r) obj).a;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.d;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "TextSend(actionType=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bP6$s */
    public static final class s implements InterfaceC10294bP6 {
        private final int a;
        private final String b;
        private final String c;
        private final int d;
        private final Integer e;

        public s(int i, String str) {
            AbstractC13042fc3.i(str, "storyId");
            this.a = i;
            this.b = str;
            this.c = "send";
            this.d = 3;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer b() {
            return Integer.valueOf(this.d);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public String c() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof s)) {
                return false;
            }
            s sVar = (s) obj;
            return this.a == sVar.a && AbstractC13042fc3.d(this.b, sVar.b);
        }

        @Override // ir.nasim.InterfaceC10294bP6
        public Integer h() {
            return this.e;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "TextSent(actionType=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
        }
    }

    String a();

    Integer b();

    String c();

    default boolean d() {
        Integer numB = b();
        return numB != null && numB.intValue() == 2;
    }

    int e();

    default boolean f() {
        Integer numB = b();
        return numB != null && numB.intValue() == 1;
    }

    default boolean g() {
        Integer numB = b();
        return numB != null && numB.intValue() == 3;
    }

    Integer h();

    default boolean i() {
        Integer numH = h();
        return numH != null && numH.intValue() == 1;
    }

    default boolean j() {
        Integer numH = h();
        return numH != null && numH.intValue() == 2;
    }
}
