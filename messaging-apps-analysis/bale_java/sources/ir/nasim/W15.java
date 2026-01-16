package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class W15 extends AbstractC4177Ea0 {
    private final X15 f;
    private C11458d25 g;
    private Long h;
    private Long i;
    private boolean j;
    private boolean k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W15(X15 x15) {
        super(x15);
        AbstractC13042fc3.i(x15, "mvpView");
        this.f = x15;
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(W15 w15, Context context, C12889fL5 c12889fL5, C17285mi4 c17285mi4) {
        AbstractC13042fc3.i(w15, "this$0");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c12889fL5, "$messageType");
        w15.k = true;
        w15.j = false;
        w15.f.R4();
        w15.f.setHint(AbstractC20153rZ6.M(c17285mi4.b() == EnumC16694li4.c ? context.getString(AbstractC12217eE5.bank_payment_list_hint_another_money_request) : c17285mi4.b() == EnumC16694li4.b ? context.getString(AbstractC12217eE5.bank_payment_list_hint_my_money_request) : "", "{0}", (String) c12889fL5.a, false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(W15 w15, Exception exc) {
        AbstractC13042fc3.i(w15, "this$0");
        w15.f.R4();
    }

    public final void h(final Context context, J44 j44, C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.f.t2(0);
        this.g = c11458d25;
        this.h = Long.valueOf(j);
        this.i = Long.valueOf(j2);
        final C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = "";
        if ((j44 != null ? j44.F() : null) instanceof C18626oy5) {
            c12889fL5.a = "درخواست پولی";
        }
        AbstractC5969Lp4.d().a0(c11458d25, Long.valueOf(j), Long.valueOf(j2)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.U15
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                W15.i(this.a, context, c12889fL5, (C17285mi4) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.V15
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                W15.j(this.a, (Exception) obj);
            }
        });
    }
}
