package ir.nasim;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.Si0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7580Si0 implements InterfaceC7346Ri0 {
    public static final c d = new c(null);
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;

    /* renamed from: ir.nasim.Si0$a */
    public static final class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR REPLACE INTO `bot_items` (`id`,`description`,`section_id`) VALUES (?,?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        public /* bridge */ /* synthetic */ void i(InterfaceC15121j27 interfaceC15121j27, Object obj) {
            AbstractC18350oW3.a(obj);
            n(interfaceC15121j27, null);
        }

        protected void n(InterfaceC15121j27 interfaceC15121j27, AbstractC6868Pi0 abstractC6868Pi0) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(abstractC6868Pi0, "entity");
            throw null;
        }
    }

    /* renamed from: ir.nasim.Si0$b */
    public static final class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM bot_items";
        }
    }

    /* renamed from: ir.nasim.Si0$c */
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

    /* renamed from: ir.nasim.Si0$d */
    public static final class d implements Callable {
        d() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = C7580Si0.this.c.b();
            try {
                C7580Si0.this.a.e();
                try {
                    interfaceC15121j27B.V();
                    C7580Si0.this.a.F();
                } finally {
                    C7580Si0.this.a.j();
                }
            } finally {
                C7580Si0.this.c.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public C7580Si0(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
    }

    @Override // ir.nasim.InterfaceC7346Ri0
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.a, true, new d(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
