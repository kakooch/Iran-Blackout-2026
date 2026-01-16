package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class DX4 {

    public static final class a extends DX4 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1767704862;
        }

        public String toString() {
            return "Default";
        }
    }

    public static final class b extends DX4 {
        private final AbstractC11684dQ7 a;

        public b(AbstractC11684dQ7 abstractC11684dQ7) {
            super(null);
            this.a = abstractC11684dQ7;
        }

        public final AbstractC11684dQ7 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            AbstractC11684dQ7 abstractC11684dQ7 = this.a;
            if (abstractC11684dQ7 == null) {
                return 0;
            }
            return abstractC11684dQ7.hashCode();
        }

        public String toString() {
            return "Error(validationError=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c extends DX4 {
        public static final c a = new c();
        private static final int b = AbstractC12217eE5.simple_text_field_loading_message_state;

        private c() {
            super(null);
        }

        public final int a() {
            return b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 559551513;
        }

        public String toString() {
            return "Loading";
        }
    }

    private DX4() {
    }

    public /* synthetic */ DX4(ED1 ed1) {
        this();
    }
}
