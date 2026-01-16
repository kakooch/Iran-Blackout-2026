package ir.nasim;

/* renamed from: ir.nasim.bG6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10213bG6 {
    private final int a;

    /* renamed from: ir.nasim.bG6$a */
    public static final class a extends AbstractC10213bG6 {
        public static final a b = new a();

        private a() {
            super(WD5.bot_review_result_fail, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1405082117;
        }

        public String toString() {
            return "BotReviewFailedSubmit";
        }
    }

    /* renamed from: ir.nasim.bG6$b */
    public static final class b extends AbstractC10213bG6 {
        public static final b b = new b();

        private b() {
            super(WD5.bot_review_result_ok, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 375115426;
        }

        public String toString() {
            return "BotReviewSuccessfulSubmit";
        }
    }

    /* renamed from: ir.nasim.bG6$c */
    public static final class c extends AbstractC10213bG6 {
        public static final c b = new c();

        private c() {
            super(WD5.specifications_mobile_to_create_shortcut, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 6715294;
        }

        public String toString() {
            return "SpecificationsMobileToCreateShortcut";
        }
    }

    public /* synthetic */ AbstractC10213bG6(int i, ED1 ed1) {
        this(i);
    }

    public final int a() {
        return this.a;
    }

    private AbstractC10213bG6(int i) {
        this.a = i;
    }
}
