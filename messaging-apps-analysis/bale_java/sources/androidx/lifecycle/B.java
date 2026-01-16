package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C6572Ob6;
import ir.nasim.C6811Pb6;
import ir.nasim.C7289Rb6;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.VW7;

/* loaded from: classes2.dex */
public abstract class B {
    public static final AbstractC20375ru1.b a = new b();
    public static final AbstractC20375ru1.b b = new c();
    public static final AbstractC20375ru1.b c = new a();

    public static final class a implements AbstractC20375ru1.b {
        a() {
        }
    }

    public static final class b implements AbstractC20375ru1.b {
        b() {
        }
    }

    public static final class c implements AbstractC20375ru1.b {
        c() {
        }
    }

    public static final class d implements G.c {
        d() {
        }

        @Override // androidx.lifecycle.G.c
        public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return new C6811Pb6();
        }
    }

    public static final y a(AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(abstractC20375ru1, "<this>");
        InterfaceC7760Tb6 interfaceC7760Tb6 = (InterfaceC7760Tb6) abstractC20375ru1.a(a);
        if (interfaceC7760Tb6 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        InterfaceC15408jX7 interfaceC15408jX7 = (InterfaceC15408jX7) abstractC20375ru1.a(b);
        if (interfaceC15408jX7 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) abstractC20375ru1.a(c);
        String str = (String) abstractC20375ru1.a(G.d.d);
        if (str != null) {
            return b(interfaceC7760Tb6, interfaceC15408jX7, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final y b(InterfaceC7760Tb6 interfaceC7760Tb6, InterfaceC15408jX7 interfaceC15408jX7, String str, Bundle bundle) {
        C6572Ob6 c6572Ob6D = d(interfaceC7760Tb6);
        C6811Pb6 c6811Pb6E = e(interfaceC15408jX7);
        y yVar = (y) c6811Pb6E.P0().get(str);
        if (yVar != null) {
            return yVar;
        }
        y yVarA = y.f.a(c6572Ob6D.a(str), bundle);
        c6811Pb6E.P0().put(str, yVarA);
        return yVarA;
    }

    public static final void c(InterfaceC7760Tb6 interfaceC7760Tb6) {
        AbstractC13042fc3.i(interfaceC7760Tb6, "<this>");
        j.b bVarB = interfaceC7760Tb6.getLifecycle().b();
        if (bVarB != j.b.INITIALIZED && bVarB != j.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (interfaceC7760Tb6.v1().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            C6572Ob6 c6572Ob6 = new C6572Ob6(interfaceC7760Tb6.v1(), (InterfaceC15408jX7) interfaceC7760Tb6);
            interfaceC7760Tb6.v1().h("androidx.lifecycle.internal.SavedStateHandlesProvider", c6572Ob6);
            interfaceC7760Tb6.getLifecycle().a(new z(c6572Ob6));
        }
    }

    public static final C6572Ob6 d(InterfaceC7760Tb6 interfaceC7760Tb6) {
        AbstractC13042fc3.i(interfaceC7760Tb6, "<this>");
        C7289Rb6.c cVarC = interfaceC7760Tb6.v1().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        C6572Ob6 c6572Ob6 = cVarC instanceof C6572Ob6 ? (C6572Ob6) cVarC : null;
        if (c6572Ob6 != null) {
            return c6572Ob6;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final C6811Pb6 e(InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(interfaceC15408jX7, "<this>");
        return (C6811Pb6) new G(interfaceC15408jX7, new d()).d("androidx.lifecycle.internal.SavedStateHandlesVM", C6811Pb6.class);
    }
}
