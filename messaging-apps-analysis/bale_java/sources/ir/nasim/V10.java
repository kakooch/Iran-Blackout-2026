package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class V10 {

    public static final class a extends V10 {
        private final String a;
        private final Map b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Map map) {
            super(null);
            AbstractC13042fc3.i(str, "url");
            AbstractC13042fc3.i(map, "additionalHttpHeaders");
            this.a = str;
            this.b = map;
        }

        public final Map a() {
            return this.b;
        }

        public final String b() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Url(url=" + this.a + ", additionalHttpHeaders=" + this.b + Separators.RPAREN;
        }
    }

    private V10() {
    }

    public /* synthetic */ V10(ED1 ed1) {
        this();
    }
}
