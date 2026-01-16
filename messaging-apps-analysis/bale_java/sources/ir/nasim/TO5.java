package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes4.dex */
public abstract class TO5 {

    public static final class a extends TO5 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "DoNotingAction(id=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends TO5 {
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, String str3, String str4, String str5) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(str3, "description");
            AbstractC13042fc3.i(str4, "positiveButton");
            AbstractC13042fc3.i(str5, "negativeButton");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        public final String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public final String c() {
            return this.e;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "OpenDialog(id=" + this.a + ", title=" + this.b + ", description=" + this.c + ", positiveButton=" + this.d + ", negativeButton=" + this.e + Separators.RPAREN;
        }
    }

    public static final class c extends TO5 {
        private final String a;
        private final String b;
        private final YO5 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, YO5 yo5) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            AbstractC13042fc3.i(str2, "url");
            AbstractC13042fc3.i(yo5, "openInAppType");
            this.a = str;
            this.b = str2;
            this.c = yo5;
        }

        public String a() {
            return this.a;
        }

        public final YO5 b() {
            return this.c;
        }

        public final String c() {
            return this.b;
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

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "OpenLink(id=" + this.a + ", url=" + this.b + ", openInAppType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class d extends TO5 {
        private final String a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            AbstractC13042fc3.i(str2, ParameterNames.TEXT);
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(id=" + this.a + ", text=" + this.b + Separators.RPAREN;
        }
    }

    private TO5() {
    }

    public /* synthetic */ TO5(ED1 ed1) {
        this();
    }
}
