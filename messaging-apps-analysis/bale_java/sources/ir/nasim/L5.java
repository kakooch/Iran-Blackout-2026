package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public abstract class L5 {

    public static final class a extends L5 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    public static final class b extends L5 {
        private final float a;

        public b(float f) {
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
            return (obj instanceof b) && Float.compare(this.a, ((b) obj).a) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.a);
        }

        public String toString() {
            return "Loading(progress=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c extends L5 {
        private final Integer a;

        public c(Integer num) {
            super(null);
            this.a = num;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            Integer num = this.a;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "Success(message=" + this.a + Separators.RPAREN;
        }

        public /* synthetic */ c(Integer num, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : num);
        }
    }

    private L5() {
    }

    public /* synthetic */ L5(ED1 ed1) {
        this();
    }
}
