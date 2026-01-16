package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fB3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC12797fB3 {

    /* renamed from: ir.nasim.fB3$a */
    public static final class a extends AbstractC12797fB3 {
        private final boolean a;

        public a(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.a);
        }

        public String toString() {
            return "Idle(needToShowToast=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.fB3$b */
    public static final class b extends AbstractC12797fB3 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 290413180;
        }

        public String toString() {
            return "LinkCopied";
        }
    }

    /* renamed from: ir.nasim.fB3$c */
    public static final class c extends AbstractC12797fB3 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1090370850;
        }

        public String toString() {
            return "TitleMaxLengthReached";
        }
    }

    private AbstractC12797fB3() {
    }

    public /* synthetic */ AbstractC12797fB3(ED1 ed1) {
        this();
    }
}
