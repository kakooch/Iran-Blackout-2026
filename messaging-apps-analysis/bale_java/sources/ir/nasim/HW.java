package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public abstract class HW {

    public static final class a extends HW {
        private final String a;
        private final String b;
        private final String c;
        private final EnumC23191wW d;
        private final long e;
        private final long f;
        private final String g;
        private final InterfaceC4557Fq2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, EnumC23191wW enumC23191wW, long j, long j2, String str4, InterfaceC4557Fq2 interfaceC4557Fq2) {
            super(null);
            AbstractC13042fc3.i(str, "faName");
            AbstractC13042fc3.i(str2, "enName");
            AbstractC13042fc3.i(str3, "url");
            AbstractC13042fc3.i(enumC23191wW, "mediaFormat");
            AbstractC13042fc3.i(str4, "strPackIdForDiff");
            AbstractC13042fc3.i(interfaceC4557Fq2, "content");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = enumC23191wW;
            this.e = j;
            this.f = j2;
            this.g = str4;
            this.h = interfaceC4557Fq2;
        }

        @Override // ir.nasim.HW
        public long a() {
            return this.f;
        }

        @Override // ir.nasim.HW
        public String b() {
            return this.g;
        }

        public final long c() {
            return this.e;
        }

        public final InterfaceC4557Fq2 d() {
            return this.h;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && AbstractC13042fc3.d(this.g, aVar.g) && AbstractC13042fc3.d(this.h, aVar.h);
        }

        public final String f() {
            return this.a;
        }

        public final EnumC23191wW g() {
            return this.d;
        }

        public final String h() {
            return this.c;
        }

        public int hashCode() {
            return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }

        public String toString() {
            return "Badge(faName=" + this.a + ", enName=" + this.b + ", url=" + this.c + ", mediaFormat=" + this.d + ", badgeId=" + this.e + ", packId=" + this.f + ", strPackIdForDiff=" + this.g + ", content=" + this.h + Separators.RPAREN;
        }
    }

    public static final class b extends HW {
        private final String a;
        private final String b;
        private final long c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, long j, String str3) {
            super(null);
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "enTitle");
            AbstractC13042fc3.i(str3, "strPackIdForDiff");
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = str3;
        }

        @Override // ir.nasim.HW
        public long a() {
            return this.c;
        }

        @Override // ir.nasim.HW
        public String b() {
            return this.d;
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Header(title=" + this.a + ", enTitle=" + this.b + ", packId=" + this.c + ", strPackIdForDiff=" + this.d + Separators.RPAREN;
        }
    }

    public static abstract class c extends HW {

        public static final class a extends c {
            private final long a;
            private final String b;

            public /* synthetic */ a(long j, String str, int i, ED1 ed1) {
                this((i & 1) != 0 ? 0L : j, str);
            }

            @Override // ir.nasim.HW
            public long a() {
                return this.a;
            }

            @Override // ir.nasim.HW
            public String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b);
            }

            public int hashCode() {
                return (Long.hashCode(this.a) * 31) + this.b.hashCode();
            }

            public String toString() {
                return "Badge(packId=" + this.a + ", strPackIdForDiff=" + this.b + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, String str) {
                super(null);
                AbstractC13042fc3.i(str, "strPackIdForDiff");
                this.a = j;
                this.b = str;
            }
        }

        public static final class b extends c {
            private final long a;
            private final String b;

            public /* synthetic */ b(long j, String str, int i, ED1 ed1) {
                this((i & 1) != 0 ? 0L : j, str);
            }

            @Override // ir.nasim.HW
            public long a() {
                return this.a;
            }

            @Override // ir.nasim.HW
            public String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b);
            }

            public int hashCode() {
                return (Long.hashCode(this.a) * 31) + this.b.hashCode();
            }

            public String toString() {
                return "Header(packId=" + this.a + ", strPackIdForDiff=" + this.b + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, String str) {
                super(null);
                AbstractC13042fc3.i(str, "strPackIdForDiff");
                this.a = j;
                this.b = str;
            }
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }

        private c() {
            super(null);
        }
    }

    private HW() {
    }

    public abstract long a();

    public abstract String b();

    public /* synthetic */ HW(ED1 ed1) {
        this();
    }
}
