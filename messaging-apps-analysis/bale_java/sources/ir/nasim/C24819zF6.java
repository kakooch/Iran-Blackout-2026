package ir.nasim;

import androidx.fragment.app.Fragment;
import ir.nasim.features.smiles.panel.SmilesPanelView;

/* renamed from: ir.nasim.zF6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24819zF6 extends AbstractC21636ts4 {
    private final C11458d25 f;
    private CF6 g;
    private final boolean h;
    private SmilesPanelView i;

    /* renamed from: ir.nasim.zF6$a */
    public static final class a implements BF6 {
        a() {
        }

        @Override // ir.nasim.BF6
        public void a() {
            C24819zF6.this.h(false);
            C24819zF6 c24819zF6 = C24819zF6.this;
            c24819zF6.l(c24819zF6.d());
        }

        @Override // ir.nasim.BF6
        public void b(int i) {
            C24819zF6.this.h(true);
            C24819zF6 c24819zF6 = C24819zF6.this;
            c24819zF6.l(c24819zF6.d() + i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24819zF6(Fragment fragment, C11458d25 c11458d25, CF6 cf6, InterfaceC11950dp3 interfaceC11950dp3, InterfaceC10258bL6 interfaceC10258bL6, boolean z) {
        super(interfaceC11950dp3);
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(interfaceC11950dp3, "keyboardActions");
        AbstractC13042fc3.i(interfaceC10258bL6, "smilesPanelState");
        this.f = c11458d25;
        this.g = cf6;
        this.h = z;
        SmilesPanelView smilesPanelView = new SmilesPanelView(fragment, c11458d25, false, false, interfaceC10258bL6, z, 12, (ED1) null);
        smilesPanelView.setSmilesKeyboardListener(this.g);
        smilesPanelView.setSmilesActionListener(new a());
        this.i = smilesPanelView;
    }

    @Override // ir.nasim.AbstractC21636ts4
    public void a() {
        e().getOnClose().invoke();
        super.a();
    }

    @Override // ir.nasim.AbstractC21636ts4
    public boolean g() {
        return e().w();
    }

    @Override // ir.nasim.AbstractC21636ts4
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public SmilesPanelView e() {
        SmilesPanelView smilesPanelView = this.i;
        AbstractC13042fc3.f(smilesPanelView);
        return smilesPanelView;
    }

    public final void n() {
        SmilesPanelView smilesPanelView = this.i;
        if (smilesPanelView != null) {
            smilesPanelView.B();
        }
    }
}
