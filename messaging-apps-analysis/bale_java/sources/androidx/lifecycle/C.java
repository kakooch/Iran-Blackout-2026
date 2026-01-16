package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10592bs;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7996Ub6;
import ir.nasim.C7289Rb6;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.VW7;
import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
public final class C extends G.e implements G.c {
    private Application b;
    private final G.c c;
    private Bundle d;
    private j e;
    private C7289Rb6 f;

    public C(Application application, InterfaceC7760Tb6 interfaceC7760Tb6, Bundle bundle) {
        AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
        this.f = interfaceC7760Tb6.v1();
        this.e = interfaceC7760Tb6.getLifecycle();
        this.d = bundle;
        this.b = application;
        this.c = application != null ? G.a.f.a(application) : new G.a();
    }

    @Override // androidx.lifecycle.G.c
    public VW7 b(Class cls) {
        AbstractC13042fc3.i(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return e(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.G.c
    public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(cls, "modelClass");
        AbstractC13042fc3.i(abstractC20375ru1, "extras");
        String str = (String) abstractC20375ru1.a(G.d.d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (abstractC20375ru1.a(B.a) == null || abstractC20375ru1.a(B.b) == null) {
            if (this.e != null) {
                return e(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) abstractC20375ru1.a(G.a.h);
        boolean zIsAssignableFrom = AbstractC10592bs.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? AbstractC7996Ub6.c(cls, AbstractC7996Ub6.b) : AbstractC7996Ub6.c(cls, AbstractC7996Ub6.a);
        return constructorC == null ? this.c.c(cls, abstractC20375ru1) : (!zIsAssignableFrom || application == null) ? AbstractC7996Ub6.d(cls, constructorC, B.a(abstractC20375ru1)) : AbstractC7996Ub6.d(cls, constructorC, application, B.a(abstractC20375ru1));
    }

    @Override // androidx.lifecycle.G.e
    public void d(VW7 vw7) {
        AbstractC13042fc3.i(vw7, "viewModel");
        if (this.e != null) {
            C7289Rb6 c7289Rb6 = this.f;
            AbstractC13042fc3.f(c7289Rb6);
            j jVar = this.e;
            AbstractC13042fc3.f(jVar);
            i.a(vw7, c7289Rb6, jVar);
        }
    }

    public final VW7 e(String str, Class cls) throws Exception {
        VW7 vw7D;
        Application application;
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(cls, "modelClass");
        j jVar = this.e;
        if (jVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC10592bs.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.b == null) ? AbstractC7996Ub6.c(cls, AbstractC7996Ub6.b) : AbstractC7996Ub6.c(cls, AbstractC7996Ub6.a);
        if (constructorC == null) {
            return this.b != null ? this.c.b(cls) : G.d.b.a().b(cls);
        }
        C7289Rb6 c7289Rb6 = this.f;
        AbstractC13042fc3.f(c7289Rb6);
        A aB = i.b(c7289Rb6, jVar, str, this.d);
        if (!zIsAssignableFrom || (application = this.b) == null) {
            vw7D = AbstractC7996Ub6.d(cls, constructorC, aB.b());
        } else {
            AbstractC13042fc3.f(application);
            vw7D = AbstractC7996Ub6.d(cls, constructorC, application, aB.b());
        }
        vw7D.I0("androidx.lifecycle.savedstate.vm.tag", aB);
        return vw7D;
    }
}
