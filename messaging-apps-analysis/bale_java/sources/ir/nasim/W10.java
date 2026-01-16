package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public abstract class W10 {

    public static final class a extends W10 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1126365634;
        }

        public String toString() {
            return "Finished";
        }
    }

    public static final class b extends W10 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -2101623783;
        }

        public String toString() {
            return "Initializing";
        }
    }

    public static final class c extends W10 {
        private final float a;

        public c(float f) {
            super(null);
            this.a = f;
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
            return "Loading(progress=" + this.a + Separators.RPAREN;
        }
    }

    private W10() {
    }

    public /* synthetic */ W10(ED1 ed1) {
        this();
    }
}
