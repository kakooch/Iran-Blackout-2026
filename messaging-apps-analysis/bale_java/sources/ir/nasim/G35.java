package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public interface G35 {

    public static final class a implements G35 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -348226448;
        }

        public String toString() {
            return "EmptyDialog";
        }
    }

    public static final class b implements G35 {
        private final int a;
        private final int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "FilledDialog(permissionDescriptionResId=" + this.a + ", permissionIconId=" + this.b + Separators.RPAREN;
        }
    }
}
