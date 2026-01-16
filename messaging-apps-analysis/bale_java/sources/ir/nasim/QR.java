package ir.nasim;

import android.gov.nist.core.Separators;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public interface QR {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final QR a(QR qr, UA2 ua2) {
            AbstractC13042fc3.i(qr, "<this>");
            AbstractC13042fc3.i(ua2, "transform");
            if (qr instanceof c) {
                return new c(ua2.invoke(((c) qr).b()));
            }
            if (qr instanceof b) {
                return new b(((b) qr).b());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b implements QR {
        private final InterfaceC18892pR b;

        public b(InterfaceC18892pR interfaceC18892pR) {
            AbstractC13042fc3.i(interfaceC18892pR, "errors");
            this.b = interfaceC18892pR;
        }

        public final InterfaceC18892pR b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Failure(errors=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c implements QR {
        private final Object b;

        public c(Object obj) {
            this.b = obj;
        }

        public final Object b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.b, ((c) obj).b);
        }

        public int hashCode() {
            Object obj = this.b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.b + Separators.RPAREN;
        }
    }

    default Object a() {
        if (this instanceof b) {
            return null;
        }
        if (this instanceof c) {
            return ((c) this).b();
        }
        throw new NoWhenBranchMatchedException();
    }
}
