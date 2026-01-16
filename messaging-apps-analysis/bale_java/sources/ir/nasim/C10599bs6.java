package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.bs6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10599bs6 implements InterfaceC9982as6 {
    public static final c d = new c(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;

    /* renamed from: ir.nasim.bs6$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `service_sections` (`id`,`title`,`badge`,`badge_type`) VALUES (?,?,?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        public /* bridge */ /* synthetic */ void i(InterfaceC15121j27 interfaceC15121j27, Object obj) {
            AbstractC18350oW3.a(obj);
            n(interfaceC15121j27, null);
        }

        protected void n(InterfaceC15121j27 interfaceC15121j27, AbstractC9383Zr6 abstractC9383Zr6) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(abstractC9383Zr6, "entity");
            throw null;
        }
    }

    /* renamed from: ir.nasim.bs6$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM service_sections";
        }
    }

    /* renamed from: ir.nasim.bs6$c */
    public static final class c {
        private c() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public C10599bs6(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
    }
}
