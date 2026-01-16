package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.a53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9512a53 {

    /* renamed from: ir.nasim.a53$a */
    public static final class a extends AbstractC9512a53 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -746796609;
        }

        public String toString() {
            return "Available";
        }
    }

    /* renamed from: ir.nasim.a53$b */
    public static final class b extends AbstractC9512a53 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 728278878;
        }

        public String toString() {
            return "Disable";
        }
    }

    /* renamed from: ir.nasim.a53$c */
    public static final class c extends AbstractC9512a53 {
        private final float a;

        public c(float f) {
            super(null);
            this.a = f;
        }

        public final float a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Float.compare(this.a, ((c) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "Downloading(progress=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.a53$d */
    public static final class d extends AbstractC9512a53 {
        public static final d a = new d();

        private d() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 2142410503;
        }

        public String toString() {
            return "ReadyToInstall";
        }
    }

    private AbstractC9512a53() {
    }

    public /* synthetic */ AbstractC9512a53(ED1 ed1) {
        this();
    }
}
