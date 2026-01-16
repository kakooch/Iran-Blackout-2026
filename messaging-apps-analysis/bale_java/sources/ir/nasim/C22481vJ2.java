package ir.nasim;

/* renamed from: ir.nasim.vJ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22481vJ2 {
    private final C8512Wh0 a;
    private final C19482qQ7 b;
    private final C8512Wh0 c;
    private final C6305Na3 d = new C6305Na3("app.counter", 0);
    private final C6305Na3 e;
    private final C6305Na3 f;
    private final C6305Na3 g;
    private final C6305Na3 h;

    public C22481vJ2(C9057Yh4 c9057Yh4) {
        Boolean bool = Boolean.FALSE;
        this.a = new C8512Wh0("app.connecting", bool);
        this.b = new C19482qQ7("app.network_state", EnumC19739qr4.NO_CONNECTION);
        this.c = new C8512Wh0("app.syncing", bool);
        this.e = new C6305Na3("app.channel_counter", 0);
        this.f = new C6305Na3("app.group_counter", 0);
        this.g = new C6305Na3("app.private_counter", 0);
        this.h = new C6305Na3("app.bot_counter", 0);
        c9057Yh4.a().h(new InterfaceC3817Cm0() { // from class: ir.nasim.uJ2
            @Override // ir.nasim.InterfaceC3817Cm0
            /* renamed from: g */
            public final void T(AbstractC18385oa2 abstractC18385oa2) {
                this.a.j(abstractC18385oa2);
            }
        }, "connecting_state_changed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(AbstractC18385oa2 abstractC18385oa2) {
        C15459jd1 c15459jd1 = (C15459jd1) abstractC18385oa2;
        this.a.i(Boolean.valueOf(c15459jd1.a));
        this.b.i(c15459jd1.b);
    }

    public C6305Na3 b() {
        return this.h;
    }

    public C6305Na3 c() {
        return this.e;
    }

    public C6305Na3 d() {
        return this.d;
    }

    public C6305Na3 e() {
        return this.f;
    }

    public C8512Wh0 f() {
        return this.a;
    }

    public C8512Wh0 g() {
        return this.c;
    }

    public C19482qQ7 h() {
        return this.b;
    }

    public C6305Na3 i() {
        return this.g;
    }

    public synchronized void k(int i) {
        this.h.i(Integer.valueOf(i));
    }

    public synchronized void l(int i) {
        this.e.i(Integer.valueOf(i));
    }

    public synchronized void m(int i) {
        this.d.i(Integer.valueOf(i));
    }

    public synchronized void n(int i) {
        this.f.i(Integer.valueOf(i));
    }

    public synchronized void o(int i) {
        this.g.i(Integer.valueOf(i));
    }
}
