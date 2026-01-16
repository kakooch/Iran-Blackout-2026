package ir.nasim.core.modules.file.storage;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public interface d {

    public static final class a implements d {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "Low(availableStorageInMB=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements d {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "OK(availableStorageInMB=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c implements d {
        public static final c a = new c();
        private static final long b = -1;

        private c() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1094177360;
        }

        public String toString() {
            return "Unknown";
        }
    }
}
