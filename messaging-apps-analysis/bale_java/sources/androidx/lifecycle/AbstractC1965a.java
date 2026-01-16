package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.G;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C7289Rb6;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.VW7;

/* renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1965a extends G.e implements G.c {
    private C7289Rb6 b;
    private j c;
    private Bundle d;

    public AbstractC1965a(InterfaceC7760Tb6 interfaceC7760Tb6, Bundle bundle) {
        AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
        this.b = interfaceC7760Tb6.v1();
        this.c = interfaceC7760Tb6.getLifecycle();
        this.d = bundle;
    }

    private final VW7 e(String str, Class cls) throws Exception {
        C7289Rb6 c7289Rb6 = this.b;
        AbstractC13042fc3.f(c7289Rb6);
        j jVar = this.c;
        AbstractC13042fc3.f(jVar);
        A aB = i.b(c7289Rb6, jVar, str, this.d);
        VW7 vw7F = f(str, cls, aB.b());
        vw7F.I0("androidx.lifecycle.savedstate.vm.tag", aB);
        return vw7F;
    }

    @Override // androidx.lifecycle.G.c
    public VW7 b(Class cls) {
        AbstractC13042fc3.i(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.c != null) {
            return e(canonicalName, cls);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.G.c
    public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(cls, "modelClass");
        AbstractC13042fc3.i(abstractC20375ru1, "extras");
        String str = (String) abstractC20375ru1.a(G.d.d);
        if (str != null) {
            return this.b != null ? e(str, cls) : f(str, cls, B.a(abstractC20375ru1));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.G.e
    public void d(VW7 vw7) {
        AbstractC13042fc3.i(vw7, "viewModel");
        C7289Rb6 c7289Rb6 = this.b;
        if (c7289Rb6 != null) {
            AbstractC13042fc3.f(c7289Rb6);
            j jVar = this.c;
            AbstractC13042fc3.f(jVar);
            i.a(vw7, c7289Rb6, jVar);
        }
    }

    protected abstract VW7 f(String str, Class cls, y yVar);
}
