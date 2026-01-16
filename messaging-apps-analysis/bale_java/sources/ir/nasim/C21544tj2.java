package ir.nasim;

/* renamed from: ir.nasim.tj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21544tj2 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final InterfaceC3570Bk5 a;

    /* renamed from: ir.nasim.tj2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C21544tj2(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "feedProperties");
        this.a = interfaceC3570Bk5;
    }

    public final void a() {
        this.a.remove("FULL_SCREEN_LOAD_MORE_STATE_PREF_KEY");
    }

    public final void b() {
        this.a.remove("LOAD_MORE_STATE_PREF_KEY");
    }

    public final byte[] c() {
        return this.a.b("FULL_SCREEN_LOAD_MORE_STATE_PREF_KEY");
    }

    public final byte[] d() {
        return this.a.b("LOAD_MORE_STATE_PREF_KEY");
    }

    public final void e(byte[] bArr) {
        this.a.f("FULL_SCREEN_LOAD_MORE_STATE_PREF_KEY", bArr);
    }

    public final void f(byte[] bArr) {
        this.a.f("LOAD_MORE_STATE_PREF_KEY", bArr);
    }
}
