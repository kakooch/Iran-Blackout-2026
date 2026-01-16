package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.bl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC10528bl5 {

    /* renamed from: ir.nasim.bl5$a */
    public static final class a extends AbstractC10528bl5 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -2010423670;
        }

        public String toString() {
            return "Hidden";
        }
    }

    /* renamed from: ir.nasim.bl5$b */
    public static final class b extends AbstractC10528bl5 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 120681717;
        }

        public String toString() {
            return "PremiumUpdateNeeded";
        }
    }

    /* renamed from: ir.nasim.bl5$c */
    public static final class c extends AbstractC10528bl5 {
        private final long a;

        public c(long j) {
            super(null);
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
            return "PurchasePackage(packageId=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bl5$d */
    public static final class d extends AbstractC10528bl5 {
        public static final d a = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return -445200694;
        }

        public String toString() {
            return "SelectPackage";
        }
    }

    private AbstractC10528bl5() {
    }

    public /* synthetic */ AbstractC10528bl5(ED1 ed1) {
        this();
    }
}
