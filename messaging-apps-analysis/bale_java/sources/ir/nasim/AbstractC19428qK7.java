package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qK7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19428qK7 {
    private final EnumC23487x03 a;
    private final Integer b;

    /* renamed from: ir.nasim.qK7$a */
    public static final class a extends AbstractC19428qK7 {
        public static final a c = new a();

        private a() {
            super(EnumC23487x03.g, Integer.valueOf(UD5.bot_icon_content_description), null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -80072683;
        }

        public String toString() {
            return "Bot";
        }
    }

    /* renamed from: ir.nasim.qK7$b */
    public static final class b extends AbstractC19428qK7 {
        public static final b c = new b();

        private b() {
            super(EnumC23487x03.f, Integer.valueOf(UD5.channel_icon_content_description), null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1679402927;
        }

        public String toString() {
            return "Channel";
        }
    }

    /* renamed from: ir.nasim.qK7$c */
    public static final class c extends AbstractC19428qK7 {
        public static final c c = new c();

        private c() {
            super(EnumC23487x03.e, Integer.valueOf(UD5.group_icon_content_description), null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 364268877;
        }

        public String toString() {
            return "Group";
        }
    }

    /* renamed from: ir.nasim.qK7$d */
    public static final class d extends AbstractC19428qK7 {
        public static final d c = new d();

        /* JADX WARN: Multi-variable type inference failed */
        private d() {
            super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 1562116305;
        }

        public String toString() {
            return "Private";
        }
    }

    /* renamed from: ir.nasim.qK7$e */
    public static final class e extends AbstractC19428qK7 {
        private final EnumC23487x03 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(EnumC23487x03 enumC23487x03) {
            super(enumC23487x03, null, 2, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(enumC23487x03, "iconKey");
            this.c = enumC23487x03;
        }

        @Override // ir.nasim.AbstractC19428qK7
        public EnumC23487x03 b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.c == ((e) obj).c;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "Puppet(iconKey=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.qK7$f */
    public static final class f extends AbstractC19428qK7 {
        public static final f c = new f();

        /* JADX WARN: Multi-variable type inference failed */
        private f() {
            super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return 1562220408;
        }

        public String toString() {
            return "UnKnown";
        }
    }

    public /* synthetic */ AbstractC19428qK7(EnumC23487x03 enumC23487x03, Integer num, ED1 ed1) {
        this(enumC23487x03, num);
    }

    public Integer a() {
        return this.b;
    }

    public EnumC23487x03 b() {
        return this.a;
    }

    private AbstractC19428qK7(EnumC23487x03 enumC23487x03, Integer num) {
        this.a = enumC23487x03;
        this.b = num;
    }

    public /* synthetic */ AbstractC19428qK7(EnumC23487x03 enumC23487x03, Integer num, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : enumC23487x03, (i & 2) != 0 ? null : num, null);
    }
}
