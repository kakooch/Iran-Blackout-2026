package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public interface KA3 {

    public static final class a implements KA3 {
        private final String a;

        public a(String str) {
            AbstractC13042fc3.i(str, "link");
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
            return "Failed(link=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements KA3 {
        private final String a;
        private final EnumC4458Ff2 b;

        public b(String str, EnumC4458Ff2 enumC4458Ff2) {
            AbstractC13042fc3.i(str, "link");
            AbstractC13042fc3.i(enumC4458Ff2, "falakeData");
            this.a = str;
            this.b = enumC4458Ff2;
        }

        public final EnumC4458Ff2 a() {
            return this.b;
        }

        public String b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Succeed(link=" + this.a + ", falakeData=" + this.b + Separators.RPAREN;
        }
    }
}
