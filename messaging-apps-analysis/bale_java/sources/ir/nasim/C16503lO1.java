package ir.nasim;

import androidx.fragment.app.Fragment;
import ir.nasim.features.root.AbstractC13089g;

/* renamed from: ir.nasim.lO1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16503lO1 implements InterfaceC23422wt4 {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC23422wt4
    public void a(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        if (fragment instanceof XO1) {
            ((XO1) fragment).q5();
        }
    }

    @Override // ir.nasim.InterfaceC23422wt4
    public Fragment b(Boolean bool) {
        return BB4.INSTANCE.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC23422wt4
    public void c(Fragment fragment, AbstractC13089g.b bVar) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(bVar, "mode");
        if (fragment instanceof XO1) {
            ((XO1) fragment).J1(bVar);
        }
    }
}
