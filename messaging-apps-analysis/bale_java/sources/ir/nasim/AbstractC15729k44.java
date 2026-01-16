package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.k44, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC15729k44 {

    /* renamed from: ir.nasim.k44$a */
    public static final class a extends AbstractC15729k44 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -203899700;
        }

        public String toString() {
            return "Commands";
        }
    }

    /* renamed from: ir.nasim.k44$b */
    public static final class b extends AbstractC15729k44 {
        private final String a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "url");
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "WebApp(title=" + this.a + ", url=" + this.b + Separators.RPAREN;
        }
    }

    private AbstractC15729k44() {
    }

    public /* synthetic */ AbstractC15729k44(ED1 ed1) {
        this();
    }
}
