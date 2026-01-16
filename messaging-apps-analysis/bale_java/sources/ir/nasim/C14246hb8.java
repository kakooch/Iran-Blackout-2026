package ir.nasim;

/* renamed from: ir.nasim.hb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14246hb8 implements InterfaceC13655gb8 {
    private final D26 a;
    private final AbstractC21126t92 b;
    private final AbstractC11429cz6 c;
    private final AbstractC11429cz6 d;

    /* renamed from: ir.nasim.hb8$a */
    class a extends AbstractC21126t92 {
        a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // ir.nasim.AbstractC21126t92
        public /* bridge */ /* synthetic */ void i(InterfaceC15121j27 interfaceC15121j27, Object obj) {
            AbstractC18350oW3.a(obj);
            n(interfaceC15121j27, null);
        }

        public void n(InterfaceC15121j27 interfaceC15121j27, AbstractC13037fb8 abstractC13037fb8) {
            throw null;
        }
    }

    /* renamed from: ir.nasim.hb8$b */
    class b extends AbstractC11429cz6 {
        b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* renamed from: ir.nasim.hb8$c */
    class c extends AbstractC11429cz6 {
        c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM WorkProgress";
        }
    }

    public C14246hb8(D26 d26) {
        this.a = d26;
        this.b = new a(d26);
        this.c = new b(d26);
        this.d = new c(d26);
    }

    @Override // ir.nasim.InterfaceC13655gb8
    public void a(String str) {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.c.b();
        if (str == null) {
            interfaceC15121j27B.y1(1);
        } else {
            interfaceC15121j27B.U0(1, str);
        }
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.c.h(interfaceC15121j27B);
        }
    }

    @Override // ir.nasim.InterfaceC13655gb8
    public void b() {
        this.a.d();
        InterfaceC15121j27 interfaceC15121j27B = this.d.b();
        this.a.e();
        try {
            interfaceC15121j27B.V();
            this.a.F();
        } finally {
            this.a.j();
            this.d.h(interfaceC15121j27B);
        }
    }
}
