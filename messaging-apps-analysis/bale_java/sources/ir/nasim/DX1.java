package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public interface DX1 {

    public static final class a implements DX1 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -845393349;
        }

        public String toString() {
            return "CancelDownload";
        }
    }

    public static final class b implements DX1 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1135617709;
        }

        public String toString() {
            return "FileBanned";
        }
    }

    public static final class c implements DX1 {
        private final float a;

        public c(float f) {
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
            return "Partial(progress=" + this.a + Separators.RPAREN;
        }
    }

    public static final class d implements DX1 {
        private final Throwable a;

        public d(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Unknown(throwable=" + this.a + Separators.RPAREN;
        }

        public /* synthetic */ d(Throwable th, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : th);
        }
    }
}
