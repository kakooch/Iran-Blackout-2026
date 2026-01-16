package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.c07, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC10676c07 {

    /* renamed from: ir.nasim.c07$a */
    public static final class a implements InterfaceC10676c07 {
        public static final a a = new a();

        private a() {
        }
    }

    /* renamed from: ir.nasim.c07$b */
    public static final class b implements InterfaceC10676c07 {
        public static final b a = new b();

        private b() {
        }
    }

    /* renamed from: ir.nasim.c07$c */
    public static final class c implements InterfaceC10676c07 {
        public static final c a = new c();

        private c() {
        }
    }

    /* renamed from: ir.nasim.c07$d */
    public static final class d implements InterfaceC10676c07 {
        private final boolean a;

        public d(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.a == ((d) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "SubmitRateOnBazar(isShowFeedbackAgainEnabled=" + this.a + Separators.RPAREN;
        }
    }
}
