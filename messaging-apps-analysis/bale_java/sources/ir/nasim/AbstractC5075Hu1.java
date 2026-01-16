package ir.nasim;

import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.Hu1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5075Hu1 {
    public static final b a = new b(null);
    private static final AbstractC5075Hu1 b = a.e;
    private static final AbstractC5075Hu1 c = e.e;
    private static final AbstractC5075Hu1 d = c.e;

    /* renamed from: ir.nasim.Hu1$a */
    private static final class a extends AbstractC5075Hu1 {
        public static final a e = new a();

        private a() {
            super(null);
        }

        @Override // ir.nasim.AbstractC5075Hu1
        public int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2) {
            return i / 2;
        }
    }

    /* renamed from: ir.nasim.Hu1$b */
    public static final class b {
        private b() {
        }

        public final AbstractC5075Hu1 a(InterfaceC12529em.b bVar) {
            return new d(bVar);
        }

        public final AbstractC5075Hu1 b(InterfaceC12529em.c cVar) {
            return new f(cVar);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Hu1$c */
    private static final class c extends AbstractC5075Hu1 {
        public static final c e = new c();

        private c() {
            super(null);
        }

        @Override // ir.nasim.AbstractC5075Hu1
        public int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                return i;
            }
            return 0;
        }
    }

    /* renamed from: ir.nasim.Hu1$d */
    private static final class d extends AbstractC5075Hu1 {
        private final InterfaceC12529em.b e;

        public d(InterfaceC12529em.b bVar) {
            super(null);
            this.e = bVar;
        }

        @Override // ir.nasim.AbstractC5075Hu1
        public int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2) {
            return this.e.a(0, i, enumC12613eu3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.e, ((d) obj).e);
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.e + ')';
        }
    }

    /* renamed from: ir.nasim.Hu1$e */
    private static final class e extends AbstractC5075Hu1 {
        public static final e e = new e();

        private e() {
            super(null);
        }

        @Override // ir.nasim.AbstractC5075Hu1
        public int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2) {
            if (enumC12613eu3 == EnumC12613eu3.a) {
                return 0;
            }
            return i;
        }
    }

    /* renamed from: ir.nasim.Hu1$f */
    private static final class f extends AbstractC5075Hu1 {
        private final InterfaceC12529em.c e;

        public f(InterfaceC12529em.c cVar) {
            super(null);
            this.e = cVar;
        }

        @Override // ir.nasim.AbstractC5075Hu1
        public int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2) {
            return this.e.a(0, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && AbstractC13042fc3.d(this.e, ((f) obj).e);
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public String toString() {
            return "VerticalCrossAxisAlignment(vertical=" + this.e + ')';
        }
    }

    public /* synthetic */ AbstractC5075Hu1(ED1 ed1) {
        this();
    }

    public abstract int a(int i, EnumC12613eu3 enumC12613eu3, AbstractC21430te5 abstractC21430te5, int i2);

    public Integer b(AbstractC21430te5 abstractC21430te5) {
        return null;
    }

    public boolean c() {
        return false;
    }

    private AbstractC5075Hu1() {
    }
}
