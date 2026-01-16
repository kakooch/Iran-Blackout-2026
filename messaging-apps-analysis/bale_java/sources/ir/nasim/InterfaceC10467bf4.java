package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.bf4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC10467bf4 {

    /* renamed from: ir.nasim.bf4$a */
    public static final class a implements InterfaceC10467bf4 {
        private final List a;

        public a(List list) {
            AbstractC13042fc3.i(list, "items");
            this.a = list;
        }

        public final List a() {
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
            return "EnqueueAdd(items=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bf4$b */
    public static final class b implements InterfaceC10467bf4 {
        private final List a;

        public b(List list) {
            AbstractC13042fc3.i(list, "fileIds");
            this.a = list;
        }

        public final List a() {
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
            return "EnqueueDelete(fileIds=" + this.a + Separators.RPAREN;
        }
    }
}
