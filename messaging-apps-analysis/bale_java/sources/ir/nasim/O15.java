package ir.nasim;

/* loaded from: classes6.dex */
public abstract class O15 {

    public static final class a extends O15 {
        private final String a;
        private final Long b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Long l) {
            super(null);
            AbstractC13042fc3.i(str, "path");
            this.a = str;
            this.b = l;
        }

        public final String a() {
            return this.a;
        }

        public final Long b() {
            return this.b;
        }
    }

    public static final class b extends O15 {
        private final Integer a;

        public b(Integer num) {
            super(null);
            this.a = num;
        }

        public final Integer a() {
            return this.a;
        }
    }

    private O15() {
    }

    public /* synthetic */ O15(ED1 ed1) {
        this();
    }
}
