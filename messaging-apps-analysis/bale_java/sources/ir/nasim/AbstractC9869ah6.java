package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ah6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC9869ah6 {

    /* renamed from: ir.nasim.ah6$a */
    public static final class a extends AbstractC9869ah6 {
        private final byte a;

        public a(byte b) {
            super(null);
            this.a = b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Byte.hashCode(this.a);
        }

        public String toString() {
            return "Loading(progress=" + ((int) this.a) + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ah6$b */
    public static final class b extends AbstractC9869ah6 {
        private final List a;
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, List list2) {
            super(null);
            AbstractC13042fc3.i(list, "peers");
            AbstractC13042fc3.i(list2, "contents");
            this.a = list;
            this.b = list2;
        }

        public final List a() {
            return this.b;
        }

        public final List b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Success(peers=" + this.a + ", contents=" + this.b + Separators.RPAREN;
        }
    }

    private AbstractC9869ah6() {
    }

    public /* synthetic */ AbstractC9869ah6(ED1 ed1) {
        this();
    }
}
