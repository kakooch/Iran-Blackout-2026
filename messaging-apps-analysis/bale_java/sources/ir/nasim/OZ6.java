package ir.nasim;

import ir.nasim.AbstractC11873dh5;

/* loaded from: classes2.dex */
public final class OZ6 extends AbstractC11760dZ2 {
    private final String s;

    public OZ6(InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, C20757sZ1 c20757sZ1) {
        super(interfaceC4953Hg5, z, c20757sZ1);
        this.s = "androidx.compose.ui.input.pointer.StylusHoverIcon";
    }

    @Override // ir.nasim.AbstractC11760dZ2
    public boolean F2(int i) {
        AbstractC11873dh5.a aVar = AbstractC11873dh5.a;
        return AbstractC11873dh5.g(i, aVar.c()) || AbstractC11873dh5.g(i, aVar.a());
    }

    @Override // ir.nasim.InterfaceC8645Wv7
    /* renamed from: L2, reason: merged with bridge method [inline-methods] */
    public String P() {
        return this.s;
    }

    @Override // ir.nasim.AbstractC11760dZ2
    public void x2(InterfaceC4953Hg5 interfaceC4953Hg5) {
        InterfaceC5655Kg5 interfaceC5655Kg5E2 = E2();
        if (interfaceC5655Kg5E2 != null) {
            interfaceC5655Kg5E2.c(interfaceC4953Hg5);
        }
    }
}
