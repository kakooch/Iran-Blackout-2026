package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Li7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5909Li7 {

    /* renamed from: ir.nasim.Li7$a */
    public static final class a extends AbstractC5909Li7 {
        private final String a;
        private final String b;
        private final String c;
        private final EnumC23191wW d;
        private final long e;
        private final InterfaceC4557Fq2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, EnumC23191wW enumC23191wW, long j, InterfaceC4557Fq2 interfaceC4557Fq2) {
            super(null);
            AbstractC13042fc3.i(str, "faName");
            AbstractC13042fc3.i(str2, "enName");
            AbstractC13042fc3.i(str3, "url");
            AbstractC13042fc3.i(enumC23191wW, "mediaFormat");
            AbstractC13042fc3.i(interfaceC4557Fq2, "content");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = enumC23191wW;
            this.e = j;
            this.f = interfaceC4557Fq2;
        }

        public final InterfaceC4557Fq2 a() {
            return this.f;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public final long d() {
            return this.e;
        }

        public final String e() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f);
        }

        public int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "Pack(faName=" + this.a + ", enName=" + this.b + ", url=" + this.c + ", mediaFormat=" + this.d + ", tabId=" + this.e + ", content=" + this.f + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Li7$b */
    public static final class b extends AbstractC5909Li7 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            AbstractC13042fc3.i(str, "strPackIdForDiff");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Shimmer(strPackIdForDiff=" + this.a + Separators.RPAREN;
        }
    }

    private AbstractC5909Li7() {
    }

    public /* synthetic */ AbstractC5909Li7(ED1 ed1) {
        this();
    }
}
