package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public interface E26 {

    public static final class a implements E26 {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
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
            return "YourVideoHaveBeenMuted(userId=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b implements E26 {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
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
            return "YourVoiceHaveBeenMuted(userId=" + this.a + Separators.RPAREN;
        }
    }
}
