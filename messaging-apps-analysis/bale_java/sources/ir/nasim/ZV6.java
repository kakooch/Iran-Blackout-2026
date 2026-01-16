package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public interface ZV6 {

    public static final class a implements ZV6 {
        private final int a;
        private final WV6 b;
        private Integer c;
        private final YV6 d;
        private final XV6 e;
        private final String f;

        public a(int i, WV6 wv6, Integer num) {
            AbstractC13042fc3.i(wv6, "origin");
            this.a = i;
            this.b = wv6;
            this.c = num;
            this.d = YV6.b;
            this.f = "";
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.f;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.e;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.c = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
            Integer num = this.c;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Click(randomId=" + this.a + ", origin=" + this.b + ", index=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b implements ZV6 {
        private final ZV6 a;
        private final String b;
        private final XV6 c;
        private final YV6 d;
        private final WV6 e;
        private final int f;
        private Integer g;

        public b(ZV6 zv6, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = str;
            this.c = xv6;
            this.d = YV6.g;
            this.e = WV6.c;
            this.f = zv6.e();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.g = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.g;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.e;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Join(lastEvent=" + this.a + ", storyId=" + this.b + ", storyType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class c implements ZV6 {
        private final ZV6 a;
        private final String b;
        private final XV6 c;
        private final YV6 d;
        private final WV6 e;
        private final int f;
        private Integer g;

        public c(ZV6 zv6, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = str;
            this.c = xv6;
            this.d = YV6.c;
            this.e = zv6.getOrigin();
            this.f = zv6.e();
            this.g = zv6.getIndex();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.g = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && this.c == cVar.c;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.g;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.e;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Open(lastEvent=" + this.a + ", storyId=" + this.b + ", storyType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class d implements ZV6 {
        private final ZV6 a;
        private final String b;
        private final XV6 c;
        private final YV6 d;
        private final WV6 e;
        private final int f;
        private Integer g;

        public d(ZV6 zv6, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = str;
            this.c = xv6;
            this.d = YV6.h;
            this.e = zv6.getOrigin();
            this.f = zv6.e();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.g = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b) && this.c == dVar.c;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.g;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.e;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ProfileView(lastEvent=" + this.a + ", storyId=" + this.b + ", storyType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class e implements ZV6 {
        private final ZV6 a;
        private final String b;
        private final XV6 c;
        private final YV6 d;
        private final WV6 e;
        private final int f;
        private Integer g;

        public e(ZV6 zv6, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = str;
            this.c = xv6;
            this.d = YV6.e;
            this.e = zv6.getOrigin();
            this.f = zv6.e();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.g = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC13042fc3.d(this.a, eVar.a) && AbstractC13042fc3.d(this.b, eVar.b) && this.c == eVar.c;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.g;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.e;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Reaction(lastEvent=" + this.a + ", storyId=" + this.b + ", storyType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class f implements ZV6 {
        private final ZV6 a;
        private final String b;
        private final XV6 c;
        private final YV6 d;
        private final WV6 e;
        private final int f;
        private Integer g;

        public f(ZV6 zv6, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = str;
            this.c = xv6;
            this.d = YV6.f;
            this.e = zv6.getOrigin();
            this.f = zv6.e();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.b;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.g = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.a, fVar.a) && AbstractC13042fc3.d(this.b, fVar.b) && this.c == fVar.c;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.g;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.e;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Reply(lastEvent=" + this.a + ", storyId=" + this.b + ", storyType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class g implements ZV6 {
        private final ZV6 a;
        private final int b;
        private final String c;
        private final XV6 d;
        private final YV6 e;
        private final WV6 f;
        private final int g;
        private Integer h;

        public g(ZV6 zv6, int i, String str, XV6 xv6) {
            AbstractC13042fc3.i(zv6, "lastEvent");
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(xv6, "storyType");
            this.a = zv6;
            this.b = i;
            this.c = str;
            this.d = xv6;
            this.e = YV6.d;
            this.f = zv6.getOrigin();
            this.g = zv6.e();
            this.h = zv6.getIndex();
        }

        @Override // ir.nasim.ZV6
        public String a() {
            return this.c;
        }

        @Override // ir.nasim.ZV6
        public XV6 b() {
            return this.d;
        }

        @Override // ir.nasim.ZV6
        public YV6 c() {
            return this.e;
        }

        @Override // ir.nasim.ZV6
        public void d(Integer num) {
            this.h = num;
        }

        @Override // ir.nasim.ZV6
        public int e() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return AbstractC13042fc3.d(this.a, gVar.a) && this.b == gVar.b && AbstractC13042fc3.d(this.c, gVar.c) && this.d == gVar.d;
        }

        @Override // ir.nasim.ZV6
        public Integer getIndex() {
            return this.h;
        }

        @Override // ir.nasim.ZV6
        public WV6 getOrigin() {
            return this.f;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "View(lastEvent=" + this.a + ", fileSize=" + this.b + ", storyId=" + this.c + ", storyType=" + this.d + Separators.RPAREN;
        }
    }

    String a();

    XV6 b();

    YV6 c();

    void d(Integer num);

    int e();

    Integer getIndex();

    WV6 getOrigin();
}
