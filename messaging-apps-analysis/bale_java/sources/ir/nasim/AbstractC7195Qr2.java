package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Qr2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7195Qr2 {

    /* renamed from: ir.nasim.Qr2$a */
    public static final class a extends AbstractC7195Qr2 {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "Answer(index=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Qr2$b */
    public static final class b extends AbstractC7195Qr2 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 360584507;
        }

        public String toString() {
            return "None";
        }
    }

    /* renamed from: ir.nasim.Qr2$c */
    public static final class c extends AbstractC7195Qr2 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1202460567;
        }

        public String toString() {
            return "Question";
        }
    }

    private AbstractC7195Qr2() {
    }

    public /* synthetic */ AbstractC7195Qr2(ED1 ed1) {
        this();
    }
}
