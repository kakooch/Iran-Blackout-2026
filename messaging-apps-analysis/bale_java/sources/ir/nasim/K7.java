package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class K7 {

    public static final class a extends K7 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "e");
            this.a = th;
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
            return "Failure(e=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends K7 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1123709002;
        }

        public String toString() {
            return "Idle";
        }
    }

    public static final class c extends K7 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1527574042;
        }

        public String toString() {
            return "Loading";
        }
    }

    public static final class d extends K7 {
        private final List a;
        private final boolean b;
        private final Integer c;

        public /* synthetic */ d(List list, boolean z, Integer num, int i, ED1 ed1) {
            this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : num);
        }

        public static /* synthetic */ d b(d dVar, List list, boolean z, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dVar.a;
            }
            if ((i & 2) != 0) {
                z = dVar.b;
            }
            if ((i & 4) != 0) {
                num = dVar.c;
            }
            return dVar.a(list, z, num);
        }

        public final d a(List list, boolean z, Integer num) {
            AbstractC13042fc3.i(list, "groups");
            return new d(list, z, num);
        }

        public final List c() {
            return this.a;
        }

        public final boolean d() {
            return this.b;
        }

        public final Integer e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && this.b == dVar.b && AbstractC13042fc3.d(this.c, dVar.c);
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + Boolean.hashCode(this.b)) * 31;
            Integer num = this.c;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Success(groups=" + this.a + ", loading=" + this.b + ", snackbarMessage=" + this.c + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, boolean z, Integer num) {
            super(null);
            AbstractC13042fc3.i(list, "groups");
            this.a = list;
            this.b = z;
            this.c = num;
        }
    }

    private K7() {
    }

    public /* synthetic */ K7(ED1 ed1) {
        this();
    }
}
