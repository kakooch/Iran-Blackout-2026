package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public interface SY1 {

    public static final class a implements SY1 {
        private final InterfaceC9905al2 a;

        public a(InterfaceC9905al2 interfaceC9905al2) {
            AbstractC13042fc3.i(interfaceC9905al2, "fileContent");
            this.a = interfaceC9905al2;
        }

        public final InterfaceC9905al2 a() {
            return this.a;
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
            return "Downloaded(fileContent=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements SY1 {
        private final float a;

        public b(float f) {
            this.a = f;
        }

        public final float a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Float.compare(this.a, ((b) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "Downloading(progress=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c implements SY1 {
        private final EX1 a;

        public c(EX1 ex1) {
            this.a = ex1;
        }

        public final EX1 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            EX1 ex1 = this.a;
            if (ex1 == null) {
                return 0;
            }
            return ex1.hashCode();
        }

        public String toString() {
            return "NotDownloaded(cause=" + this.a + Separators.RPAREN;
        }
    }
}
