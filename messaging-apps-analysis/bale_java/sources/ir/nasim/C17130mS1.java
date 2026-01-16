package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.mS1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17130mS1 extends AbstractC4177Ea0 {
    private final InterfaceC17721nS1 f;
    private final SettingsModule g;
    private final PE h;

    /* renamed from: ir.nasim.mS1$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11273cj7.values().length];
            try {
                iArr[EnumC11273cj7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC11273cj7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC11273cj7.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC11273cj7.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC11273cj7.c.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC11273cj7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17130mS1(InterfaceC17721nS1 interfaceC17721nS1) {
        super(interfaceC17721nS1);
        AbstractC13042fc3.i(interfaceC17721nS1, "mvpView");
        this.f = interfaceC17721nS1;
        C5721Ko c5721Ko = C5721Ko.a;
        this.g = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.h = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).M0();
        z();
        d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(C17130mS1 c17130mS1, boolean z, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.h2(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(C17130mS1 c17130mS1, EnumC19739qr4 enumC19739qr4, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.u2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(C17130mS1 c17130mS1, Boolean bool, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.K4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(C17130mS1 c17130mS1, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.y2(num, EnumC11273cj7.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(C17130mS1 c17130mS1, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.y2(num, EnumC11273cj7.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(C17130mS1 c17130mS1, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.y2(num, EnumC11273cj7.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(C17130mS1 c17130mS1, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.y2(num, EnumC11273cj7.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(C17130mS1 c17130mS1, Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c17130mS1, "this$0");
        c17130mS1.f.y2(num, EnumC11273cj7.f);
    }

    private final void z() {
        try {
            AbstractC5969Lp4.d().k2(OP1.ALL);
            if (this.g.x5()) {
                AbstractC5969Lp4.d().k2(OP1.CHANNEL);
            }
            if (this.g.y5()) {
                AbstractC5969Lp4.d().k2(OP1.GROUP);
            }
            if (this.g.z5()) {
                AbstractC5969Lp4.d().k2(OP1.PRIVATE);
            }
            if (this.g.w5()) {
                AbstractC5969Lp4.d().k2(OP1.BOT);
            }
        } catch (Exception unused) {
        }
    }

    public final void A() {
        e();
    }

    public final Integer n(EnumC11273cj7 enumC11273cj7) {
        int i = enumC11273cj7 == null ? -1 : a.a[enumC11273cj7.ordinal()];
        if (i == 2) {
            return (Integer) this.h.E().d().b();
        }
        if (i == 3) {
            return (Integer) this.h.E().c().b();
        }
        if (i == 4) {
            return (Integer) this.h.E().e().b();
        }
        if (i == 5) {
            return (Integer) this.h.E().i().b();
        }
        if (i != 6) {
            return 0;
        }
        return (Integer) this.h.E().b().b();
    }

    public final List o() {
        ArrayList arrayList = new ArrayList();
        if (p(EnumC11273cj7.a)) {
            arrayList.add(C12039dw0.a);
        }
        arrayList.add(C17320mm.a);
        if (p(EnumC11273cj7.c)) {
            arrayList.add(C5286Ir5.a);
        }
        if (p(EnumC11273cj7.d)) {
            arrayList.add(C18230oJ0.a);
        }
        if (p(EnumC11273cj7.e)) {
            arrayList.add(C15295jL2.a);
        }
        if (p(EnumC11273cj7.f)) {
            arrayList.add(C16099ki0.a);
        }
        return arrayList;
    }

    public final boolean p(EnumC11273cj7 enumC11273cj7) {
        switch (enumC11273cj7 == null ? -1 : a.a[enumC11273cj7.ordinal()]) {
            case 1:
                return AbstractC5969Lp4.d().r0();
            case 2:
                return this.g.v5();
            case 3:
                return this.g.x5();
            case 4:
                return this.g.y5();
            case 5:
                return this.g.z5();
            case 6:
                return this.g.w5();
            default:
                return false;
        }
    }

    public void q() {
        C8512Wh0 c8512Wh0F = this.h.E().f();
        AbstractC13042fc3.h(c8512Wh0F, "getIsConnecting(...)");
        a(c8512Wh0F, new InterfaceC14756iQ7() { // from class: ir.nasim.eS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.r(this.a, ((Boolean) obj).booleanValue(), abstractC13554gQ7);
            }
        });
        C19482qQ7 c19482qQ7H = this.h.E().h();
        AbstractC13042fc3.h(c19482qQ7H, "getNetworkState(...)");
        a(c19482qQ7H, new InterfaceC14756iQ7() { // from class: ir.nasim.fS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.s(this.a, (EnumC19739qr4) obj, abstractC13554gQ7);
            }
        });
        C8512Wh0 c8512Wh0G = this.h.E().g();
        AbstractC13042fc3.h(c8512Wh0G, "getIsSyncing(...)");
        a(c8512Wh0G, new InterfaceC14756iQ7() { // from class: ir.nasim.gS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.t(this.a, (Boolean) obj, abstractC13554gQ7);
            }
        });
        C6305Na3 c6305Na3D = this.h.E().d();
        AbstractC13042fc3.h(c6305Na3D, "getGlobalCounter(...)");
        a(c6305Na3D, new InterfaceC14756iQ7() { // from class: ir.nasim.hS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.u(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
        C6305Na3 c6305Na3C = this.h.E().c();
        AbstractC13042fc3.h(c6305Na3C, "getChannelCounter(...)");
        a(c6305Na3C, new InterfaceC14756iQ7() { // from class: ir.nasim.iS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.v(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
        C6305Na3 c6305Na3E = this.h.E().e();
        AbstractC13042fc3.h(c6305Na3E, "getGroupCounter(...)");
        a(c6305Na3E, new InterfaceC14756iQ7() { // from class: ir.nasim.jS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.w(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
        C6305Na3 c6305Na3I = this.h.E().i();
        AbstractC13042fc3.h(c6305Na3I, "getPrivateCounter(...)");
        a(c6305Na3I, new InterfaceC14756iQ7() { // from class: ir.nasim.kS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.x(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
        C6305Na3 c6305Na3B = this.h.E().b();
        AbstractC13042fc3.h(c6305Na3B, "getBotCounter(...)");
        a(c6305Na3B, new InterfaceC14756iQ7() { // from class: ir.nasim.lS1
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                C17130mS1.y(this.a, (Integer) obj, abstractC13554gQ7);
            }
        });
    }
}
