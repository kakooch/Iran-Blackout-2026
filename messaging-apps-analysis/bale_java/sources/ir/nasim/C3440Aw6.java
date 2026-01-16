package ir.nasim;

/* renamed from: ir.nasim.Aw6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3440Aw6 extends AbstractC14282hf4 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3440Aw6(C9057Yh4 c9057Yh4) {
        super(98);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(C3440Aw6 c3440Aw6, String str, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c3440Aw6, "this$0");
        AbstractC13042fc3.i(str, "$token");
        c3440Aw6.b.P().F(C5735Kp4.w().j(), str);
    }

    @Override // ir.nasim.InterfaceC24449ye1
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void apply(C14505i18 c14505i18) {
        final String strE = this.b.c().e("push.google.token");
        if (strE == null) {
            return;
        }
        this.b.P().G(strE).m0(new InterfaceC24449ye1() { // from class: ir.nasim.zw6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C3440Aw6.o(this.a, strE, (C14505i18) obj);
            }
        });
    }
}
