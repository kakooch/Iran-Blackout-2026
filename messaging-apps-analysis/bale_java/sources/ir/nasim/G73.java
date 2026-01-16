package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes5.dex */
public abstract class G73 {
    private d a;

    public static final class a extends G73 {
        private final long b;
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.b = j;
            this.c = str;
        }

        @Override // ir.nasim.G73
        public String b() {
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
            return this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (Long.hashCode(this.b) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AuthenticationButton(messageId=" + this.b + ", text=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends G73 {
        private final long b;
        private final String c;
        private final C6680On1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, String str, C6680On1 c6680On1) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(c6680On1, "copyText");
            this.b = j;
            this.c = str;
            this.d = c6680On1;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final C6680On1 d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "CopyTextButton(messageId=" + this.b + ", text=" + this.c + ", copyText=" + this.d + Separators.RPAREN;
        }
    }

    public static final class c extends G73 {
        private final long b;
        private final String c;
        private final String d;
        private final TO5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, String str, String str2, TO5 to5) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(str2, "id");
            AbstractC13042fc3.i(to5, "actionType");
            this.b = j;
            this.c = str;
            this.d = str2;
            this.e = to5;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final TO5 d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b == cVar.b && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "CustomAction(messageId=" + this.b + ", text=" + this.c + ", id=" + this.d + ", actionType=" + this.e + Separators.RPAREN;
        }
    }

    public interface d {
        void a();

        void b();
    }

    public static final class e extends G73 {
        private final long b;
        private final String c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final String d() {
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
            return this.b == eVar.b && AbstractC13042fc3.d(this.c, eVar.c) && AbstractC13042fc3.d(this.d, eVar.d);
        }

        public int hashCode() {
            int iHashCode = ((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31;
            String str = this.d;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "SendDataButton(messageId=" + this.b + ", text=" + this.c + ", callbackData=" + this.d + Separators.RPAREN;
        }
    }

    public static final class f extends G73 {
        private final long b;
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j, String str) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.b = j;
            this.c = str;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.b == fVar.b && AbstractC13042fc3.d(this.c, fVar.c);
        }

        public int hashCode() {
            return (Long.hashCode(this.b) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Unsupported(messageId=" + this.b + ", text=" + this.c + Separators.RPAREN;
        }
    }

    public static final class g extends G73 {
        private final long b;
        private final String c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j, String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(str2, "url");
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final String d() {
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
            return this.b == gVar.b && AbstractC13042fc3.d(this.c, gVar.c) && AbstractC13042fc3.d(this.d, gVar.d);
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "UrlButton(messageId=" + this.b + ", text=" + this.c + ", url=" + this.d + Separators.RPAREN;
        }
    }

    public static final class h extends G73 {
        private final long b;
        private final String c;
        private final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(long j, String str, boolean z) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            this.b = j;
            this.c = str;
            this.d = z;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final boolean d() {
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
            return this.b == hVar.b && AbstractC13042fc3.d(this.c, hVar.c) && this.d == hVar.d;
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "VoiceToText(messageId=" + this.b + ", text=" + this.c + ", isUsefully=" + this.d + Separators.RPAREN;
        }
    }

    public static final class i extends G73 {
        private final long b;
        private final String c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(long j, String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(str2, "webAppUrl");
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // ir.nasim.G73
        public String b() {
            return this.c;
        }

        public final String d() {
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
            return this.b == iVar.b && AbstractC13042fc3.d(this.c, iVar.c) && AbstractC13042fc3.d(this.d, iVar.d);
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "WebUrlButton(messageId=" + this.b + ", text=" + this.c + ", webAppUrl=" + this.d + Separators.RPAREN;
        }
    }

    private G73() {
    }

    public final d a() {
        return this.a;
    }

    public abstract String b();

    public final void c(d dVar) {
        this.a = dVar;
    }

    public /* synthetic */ G73(ED1 ed1) {
        this();
    }
}
