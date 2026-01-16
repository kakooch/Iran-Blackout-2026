package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ef4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC12464ef4 {

    /* renamed from: ir.nasim.ef4$a */
    public static final class a implements InterfaceC12464ef4 {
        private final InterfaceC22299v01 a;

        public a(InterfaceC22299v01 interfaceC22299v01) {
            AbstractC13042fc3.i(interfaceC22299v01, "originalExecuteDeferred");
            this.a = interfaceC22299v01;
        }

        public final InterfaceC22299v01 a() {
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
            return "ApplyPendingAndFinalize(originalExecuteDeferred=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ef4$b */
    public static final class b implements InterfaceC12464ef4 {
        private final C10405bZ1 a;

        public b(C10405bZ1 c10405bZ1) {
            AbstractC13042fc3.i(c10405bZ1, "item");
            this.a = c10405bZ1;
        }

        public final C10405bZ1 a() {
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
            return "EnqueueAdd(item=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ef4$c */
    public static final class c implements InterfaceC12464ef4 {
        private final long a;

        public c(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.a == ((c) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "EnqueueDelete(fileId=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ef4$d */
    public static final class d implements InterfaceC12464ef4 {
        private final InterfaceC22299v01 a;

        public d(InterfaceC22299v01 interfaceC22299v01) {
            AbstractC13042fc3.i(interfaceC22299v01, "resultDeferred");
            this.a = interfaceC22299v01;
        }

        public final InterfaceC22299v01 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ExecuteMigration(resultDeferred=" + this.a + Separators.RPAREN;
        }
    }
}
