package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public abstract class X03 {
    public static final int a = 0;

    public static final class a extends X03 {
        private final int b;
        private final String c;
        private final String d;
        private final EV4 e;
        private final boolean f;
        private final String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, String str2, EV4 ev4, boolean z, String str3) {
            super(null);
            AbstractC13042fc3.i(str, "description");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(ev4, "avatarPainter");
            AbstractC13042fc3.i(str3, "buttonText");
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = ev4;
            this.f = z;
            this.g = str3;
        }

        public final EV4 a() {
            return this.e;
        }

        public final String b() {
            return this.g;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.b;
        }

        public final String e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && this.f == aVar.f && AbstractC13042fc3.d(this.g, aVar.g);
        }

        public final boolean f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode();
        }

        public String toString() {
            return "ActionCardBanner(peerId=" + this.b + ", description=" + this.c + ", title=" + this.d + ", avatarPainter=" + this.e + ", isBlueTick=" + this.f + ", buttonText=" + this.g + Separators.RPAREN;
        }
    }

    public static final class b extends X03 {
        public static final b b = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -127957307;
        }

        public String toString() {
            return "ImageCard";
        }
    }

    public static final class c extends X03 {
        public static final c b = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -127848892;
        }

        public String toString() {
            return "ImageFull";
        }
    }

    public static final class d extends X03 {
        private final String b;
        private final String c;
        private final boolean d;
        private final boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, boolean z, boolean z2) {
            super(null);
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "description");
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = z2;
        }

        public final String a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return this.e;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c) && this.d == dVar.d && this.e == dVar.e;
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "ImageWithText(title=" + this.b + ", description=" + this.c + ", isRtl=" + this.d + ", isFill=" + this.e + Separators.RPAREN;
        }
    }

    private X03() {
    }

    public /* synthetic */ X03(ED1 ed1) {
        this();
    }
}
