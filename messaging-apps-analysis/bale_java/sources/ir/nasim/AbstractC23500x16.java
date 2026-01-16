package ir.nasim;

import ir.nasim.InterfaceC15947kS0;

/* renamed from: ir.nasim.x16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23500x16 implements InterfaceC15947kS0 {
    private final String a;
    private final UA2 b;
    private final String c;

    /* renamed from: ir.nasim.x16$a */
    public static final class a extends AbstractC23500x16 {
        public static final a d = new a();

        /* renamed from: ir.nasim.x16$a$a, reason: collision with other inner class name */
        static final class C1770a extends AbstractC8614Ws3 implements UA2 {
            public static final C1770a e = new C1770a();

            C1770a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC4099Dr3 invoke(AbstractC19738qr3 abstractC19738qr3) {
                AbstractC13042fc3.i(abstractC19738qr3, "<this>");
                XC6 xc6N = abstractC19738qr3.n();
                AbstractC13042fc3.h(xc6N, "booleanType");
                return xc6N;
            }
        }

        private a() {
            super("Boolean", C1770a.e, null);
        }
    }

    /* renamed from: ir.nasim.x16$b */
    public static final class b extends AbstractC23500x16 {
        public static final b d = new b();

        /* renamed from: ir.nasim.x16$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC4099Dr3 invoke(AbstractC19738qr3 abstractC19738qr3) {
                AbstractC13042fc3.i(abstractC19738qr3, "<this>");
                XC6 xc6D = abstractC19738qr3.D();
                AbstractC13042fc3.h(xc6D, "intType");
                return xc6D;
            }
        }

        private b() {
            super("Int", a.e, null);
        }
    }

    /* renamed from: ir.nasim.x16$c */
    public static final class c extends AbstractC23500x16 {
        public static final c d = new c();

        /* renamed from: ir.nasim.x16$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC4099Dr3 invoke(AbstractC19738qr3 abstractC19738qr3) {
                AbstractC13042fc3.i(abstractC19738qr3, "<this>");
                XC6 xc6Y = abstractC19738qr3.Y();
                AbstractC13042fc3.h(xc6Y, "unitType");
                return xc6Y;
            }
        }

        private c() {
            super("Unit", a.e, null);
        }
    }

    public /* synthetic */ AbstractC23500x16(String str, UA2 ua2, ED1 ed1) {
        this(str, ua2);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public boolean a(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        return AbstractC13042fc3.d(ab2.getReturnType(), this.b.invoke(PI1.g(ab2)));
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String b(AB2 ab2) {
        return InterfaceC15947kS0.a.a(this, ab2);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String getDescription() {
        return this.c;
    }

    private AbstractC23500x16(String str, UA2 ua2) {
        this.a = str;
        this.b = ua2;
        this.c = AbstractC13042fc3.q("must return ", str);
    }
}
