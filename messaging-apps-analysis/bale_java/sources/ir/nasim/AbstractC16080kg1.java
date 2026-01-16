package ir.nasim;

/* renamed from: ir.nasim.kg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16080kg1 {

    /* renamed from: ir.nasim.kg1$a */
    public static final class a extends AbstractC16080kg1 {
        public static final a a = new a();
        private static final String b = "MyContact";
        private static final int c = AbstractC12217eE5.your_contact_title;

        private a() {
            super(null);
        }

        public String a() {
            return b;
        }

        public int b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1796110072;
        }

        public String toString() {
            return "MyContact";
        }
    }

    /* renamed from: ir.nasim.kg1$b */
    public static final class b extends AbstractC16080kg1 {
        public static final b a = new b();
        private static final String b = "OrganContact";
        private static final int c = AbstractC12217eE5.organization_title_desc;

        private b() {
            super(null);
        }

        public String a() {
            return b;
        }

        public int b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -337595365;
        }

        public String toString() {
            return "OrganContact";
        }
    }

    private AbstractC16080kg1() {
    }

    public /* synthetic */ AbstractC16080kg1(ED1 ed1) {
        this();
    }
}
