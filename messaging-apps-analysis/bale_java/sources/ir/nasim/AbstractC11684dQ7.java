package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dQ7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC11684dQ7 {

    /* renamed from: ir.nasim.dQ7$a */
    public static final class a extends AbstractC11684dQ7 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, "messageError");
            this.a = str;
        }

        public final String a() {
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
            return "BackendError(messageError=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.dQ7$b */
    public static abstract class b extends AbstractC11684dQ7 {
        private final int a;

        /* renamed from: ir.nasim.dQ7$b$a */
        public static final class a extends b {
            public static final a b = new a();

            private a() {
                super(AbstractC12217eE5.field_error_invalid_format, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 1664855294;
            }

            public String toString() {
                return "InvalidFormat";
            }
        }

        /* renamed from: ir.nasim.dQ7$b$b, reason: collision with other inner class name */
        public static final class C1008b extends b {
            private final long b;

            public C1008b(long j) {
                super(AbstractC12217eE5.field_error_max_date, null);
                this.b = j;
            }

            public final long a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1008b) && this.b == ((C1008b) obj).b;
            }

            public int hashCode() {
                return Long.hashCode(this.b);
            }

            public String toString() {
                return "MaxDate(date=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.dQ7$b$c */
        public static final class c extends b {
            private final int b;

            public c(int i) {
                super(AbstractC12217eE5.field_error_max_length, null);
                this.b = i;
            }

            public final int a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && this.b == ((c) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "MaxLength(max=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.dQ7$b$d */
        public static final class d extends b {
            private final int b;

            public d(int i) {
                super(AbstractC12217eE5.field_error_max_value, null);
                this.b = i;
            }

            public final int a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && this.b == ((d) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "MaxValue(max=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.dQ7$b$e */
        public static final class e extends b {
            private final long b;

            public e(long j) {
                super(AbstractC12217eE5.field_error_min_date, null);
                this.b = j;
            }

            public final long a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && this.b == ((e) obj).b;
            }

            public int hashCode() {
                return Long.hashCode(this.b);
            }

            public String toString() {
                return "MinDate(date=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.dQ7$b$f */
        public static final class f extends b {
            private final int b;

            public f(int i) {
                super(AbstractC12217eE5.field_error_min_length, null);
                this.b = i;
            }

            public final int a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && this.b == ((f) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "MinLength(min=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.dQ7$b$g */
        public static final class g extends b {
            private final int b;

            public g(int i) {
                super(AbstractC12217eE5.field_error_min_value, null);
                this.b = i;
            }

            public final int a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && this.b == ((g) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "MinValue(min=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ b(int i, ED1 ed1) {
            this(i);
        }

        private b(int i) {
            super(null);
            this.a = i;
        }
    }

    private AbstractC11684dQ7() {
    }

    public /* synthetic */ AbstractC11684dQ7(ED1 ed1) {
        this();
    }
}
