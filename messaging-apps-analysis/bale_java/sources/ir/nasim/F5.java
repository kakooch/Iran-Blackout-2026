package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.AbstractC22943w5;
import ir.nasim.E5;

/* loaded from: classes4.dex */
public interface F5 {

    public static final class a implements F5 {
        private final String a;
        private final SA2 b;
        private final AbstractC22943w5.c c;
        private final E5.c d;

        public a(String str, String str2, Drawable drawable, String str3, SA2 sa2) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(str2, "iconPath");
            AbstractC13042fc3.i(sa2, "action");
            this.a = str3;
            this.b = sa2;
            this.c = new AbstractC22943w5.c(str);
            this.d = new E5.c(str2, drawable);
        }

        @Override // ir.nasim.F5
        public String a() {
            return this.a;
        }

        @Override // ir.nasim.F5
        public SA2 c() {
            return this.b;
        }

        @Override // ir.nasim.F5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public E5.c getIcon() {
            return this.d;
        }

        @Override // ir.nasim.F5
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AbstractC22943w5.c getTitle() {
            return this.c;
        }
    }

    public static final class b implements F5 {
        private final String a;
        private final SA2 b;
        private final AbstractC22943w5.c c;
        private final E5.b d;

        public b(String str, int i, InterfaceC10258bL6 interfaceC10258bL6, String str2, SA2 sa2) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(sa2, "action");
            this.a = str2;
            this.b = sa2;
            this.c = new AbstractC22943w5.c(str);
            this.d = new E5.b(i, interfaceC10258bL6);
        }

        @Override // ir.nasim.F5
        public String a() {
            return this.a;
        }

        @Override // ir.nasim.F5
        public SA2 c() {
            return this.b;
        }

        @Override // ir.nasim.F5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public E5.b getIcon() {
            return this.d;
        }

        @Override // ir.nasim.F5
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AbstractC22943w5.c getTitle() {
            return this.c;
        }
    }

    public static abstract class c implements F5 {
        private final AbstractC22943w5.b a;
        private final E5.a b;

        public static final class a extends c {
            private final String c;
            private final SA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i, int i2, String str, SA2 sa2) {
                super(i, i2, null);
                AbstractC13042fc3.i(sa2, "action");
                this.c = str;
                this.d = sa2;
            }

            @Override // ir.nasim.F5
            public String a() {
                return this.c;
            }

            @Override // ir.nasim.F5
            public SA2 c() {
                return this.d;
            }
        }

        public static final class b extends c {
            private final String c;
            private final SA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i, int i2, String str, SA2 sa2) {
                super(i, i2, null);
                AbstractC13042fc3.i(sa2, "action");
                this.c = str;
                this.d = sa2;
            }

            @Override // ir.nasim.F5
            public String a() {
                return this.c;
            }

            @Override // ir.nasim.F5
            public SA2 c() {
                return this.d;
            }
        }

        /* renamed from: ir.nasim.F5$c$c, reason: collision with other inner class name */
        public static final class C0355c extends c {
            private final String c;
            private final SA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0355c(int i, int i2, String str, SA2 sa2) {
                super(i, i2, null);
                AbstractC13042fc3.i(sa2, "action");
                this.c = str;
                this.d = sa2;
            }

            @Override // ir.nasim.F5
            public String a() {
                return this.c;
            }

            @Override // ir.nasim.F5
            public SA2 c() {
                return this.d;
            }
        }

        public /* synthetic */ c(int i, int i2, ED1 ed1) {
            this(i, i2);
        }

        @Override // ir.nasim.F5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public E5.a getIcon() {
            return this.b;
        }

        @Override // ir.nasim.F5
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AbstractC22943w5.b getTitle() {
            return this.a;
        }

        private c(int i, int i2) {
            this.a = new AbstractC22943w5.b(i);
            this.b = new E5.a(i2);
        }
    }

    public static final class d implements F5 {
        private final String a;
        private final SA2 b;
        private final AbstractC22943w5.a c;
        private final E5.b d;

        public d(InterfaceC10258bL6 interfaceC10258bL6, int i, InterfaceC10258bL6 interfaceC10258bL62, String str, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC10258bL6, "count");
            AbstractC13042fc3.i(sa2, "action");
            this.a = str;
            this.b = sa2;
            this.c = new AbstractC22943w5.a(interfaceC10258bL6);
            this.d = new E5.b(i, interfaceC10258bL62);
        }

        @Override // ir.nasim.F5
        public String a() {
            return this.a;
        }

        @Override // ir.nasim.F5
        public SA2 c() {
            return this.b;
        }

        @Override // ir.nasim.F5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public E5.b getIcon() {
            return this.d;
        }

        @Override // ir.nasim.F5
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AbstractC22943w5.a getTitle() {
            return this.c;
        }
    }

    String a();

    default boolean b(F5 f5) {
        AbstractC13042fc3.i(f5, "other");
        return AbstractC13042fc3.d(f5.getTitle(), getTitle()) && AbstractC13042fc3.d(f5.a(), a()) && AbstractC13042fc3.d(f5.getIcon(), getIcon());
    }

    SA2 c();

    E5 getIcon();

    AbstractC22943w5 getTitle();
}
