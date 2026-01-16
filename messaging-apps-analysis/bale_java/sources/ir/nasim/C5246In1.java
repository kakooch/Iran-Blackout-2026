package ir.nasim;

/* renamed from: ir.nasim.In1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5246In1 extends AbstractC14869id0 {
    public static InterfaceC20073rQ7 p = new InterfaceC20073rQ7() { // from class: ir.nasim.Hn1
        @Override // ir.nasim.InterfaceC20073rQ7
        public final AbstractC14869id0 a(Object obj) {
            return new C5246In1((C4778Gn1) obj);
        }
    };
    private C8512Wh0 a;
    private C8512Wh0 b;
    private C19482qQ7 c;
    private C19482qQ7 d;
    private C19482qQ7 e;
    private C19482qQ7 f;
    private C19482qQ7 g;
    private C19482qQ7 k;
    private C19482qQ7 l;
    private C19482qQ7 m;
    private C19482qQ7 n;
    private C19482qQ7 o;
    private C19482qQ7 i = new C19482qQ7("chat.bank_login_title", null);
    private C19482qQ7 j = new C19482qQ7("chat.bank_login_service_key", null);
    private C19482qQ7 h = new C19482qQ7("chat.unread_count_changes", 0);

    public C5246In1(C4778Gn1 c4778Gn1) {
        this.a = new C8512Wh0("chat.is_loaded." + c4778Gn1.b0(), Boolean.valueOf(c4778Gn1.i0()));
        this.b = new C8512Wh0("chat.is_empty." + c4778Gn1.b0(), Boolean.valueOf(c4778Gn1.h0()));
        this.c = new C19482qQ7("chat.own_read_date" + c4778Gn1.b0(), Long.valueOf(c4778Gn1.R()));
        this.d = new C19482qQ7("chat.read_date" + c4778Gn1.b0(), Long.valueOf(c4778Gn1.Y()));
        this.e = new C19482qQ7("chat.receive_date" + c4778Gn1.b0(), Long.valueOf(c4778Gn1.a0()));
        this.f = new C19482qQ7("chat.max_in-date" + c4778Gn1.b0(), Long.valueOf(c4778Gn1.Q()));
        this.g = new C19482qQ7("chat.unread_count" + c4778Gn1.b0(), Integer.valueOf(c4778Gn1.c0()));
        this.k = new C19482qQ7("chat.bot_access_title" + c4778Gn1.b0(), null);
        this.l = new C19482qQ7("chat.bot_last_reply_keyboard", c4778Gn1.S());
        this.m = new C19482qQ7("chat.my.mentions", c4778Gn1.X());
        this.n = new C19482qQ7("chat.unread.mentions", c4778Gn1.d0());
        this.o = new C19482qQ7("chat.unread.reactions", c4778Gn1.e0());
    }

    public C19482qQ7 c() {
        return this.j;
    }

    public C19482qQ7 d() {
        return this.k;
    }

    public C8512Wh0 e() {
        return this.b;
    }

    public C8512Wh0 f() {
        return this.a;
    }

    public C19482qQ7 g() {
        return this.f;
    }

    public C19482qQ7 h() {
        return this.c;
    }

    public C19482qQ7 i() {
        return this.l;
    }

    public C19482qQ7 j() {
        return this.d;
    }

    public C19482qQ7 k() {
        return this.e;
    }

    public C19482qQ7 l() {
        return this.n;
    }

    public C19482qQ7 m() {
        return this.o;
    }

    public C19482qQ7 n() {
        return this.g;
    }

    public C19482qQ7 o() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC14869id0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(C4778Gn1 c4778Gn1) {
        this.a.i(Boolean.valueOf(c4778Gn1.i0()));
        this.b.i(Boolean.valueOf(c4778Gn1.h0()));
        this.c.i(Long.valueOf(c4778Gn1.R()));
        this.d.i(Long.valueOf(c4778Gn1.Y()));
        this.e.i(Long.valueOf(c4778Gn1.a0()));
        this.f.i(Long.valueOf(c4778Gn1.Q()));
        this.g.i(Integer.valueOf(c4778Gn1.c0()));
        this.i.i(c4778Gn1.O());
        this.j.i(c4778Gn1.N());
        this.k.i(c4778Gn1.P());
        this.l.i(c4778Gn1.S());
        this.m.i(c4778Gn1.X());
        this.n.i(c4778Gn1.d0());
        this.o.i(c4778Gn1.e0());
    }
}
