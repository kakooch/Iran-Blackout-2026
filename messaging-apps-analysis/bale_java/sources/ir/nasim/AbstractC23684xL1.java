package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xL1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23684xL1 {
    public static final int a = 0;

    /* renamed from: ir.nasim.xL1$a */
    public static final class a extends AbstractC23684xL1 {
        private final Context b;

        public a(Context context) {
            super(null);
            this.b = context;
        }

        public final Context a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.b, ((a) obj).b);
        }

        public int hashCode() {
            Context context = this.b;
            if (context == null) {
                return 0;
            }
            return context.hashCode();
        }

        public String toString() {
            return "ClickAd(context=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.xL1$b */
    public static final class b extends AbstractC23684xL1 {
        public static final b b = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 1090122470;
        }

        public String toString() {
            return "ClickDialog";
        }
    }

    /* renamed from: ir.nasim.xL1$c */
    public static final class c extends AbstractC23684xL1 {
        public static final c b = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -79562922;
        }

        public String toString() {
            return "CloseDialog";
        }
    }

    /* renamed from: ir.nasim.xL1$d */
    public static final class d extends AbstractC23684xL1 {
        public static final d b = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 1118495901;
        }

        public String toString() {
            return "InitializeAd";
        }
    }

    /* renamed from: ir.nasim.xL1$e */
    public static final class e extends AbstractC23684xL1 {
        public static final e b = new e();

        private e() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 1892205042;
        }

        public String toString() {
            return "ViewAd";
        }
    }

    private AbstractC23684xL1() {
    }

    public /* synthetic */ AbstractC23684xL1(ED1 ed1) {
        this();
    }
}
