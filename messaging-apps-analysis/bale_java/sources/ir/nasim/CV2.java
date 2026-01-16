package ir.nasim;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import java.io.Closeable;
import java.util.Map;

/* loaded from: classes3.dex */
public final class CV2 implements G.c {
    public static final AbstractC20375ru1.b e = new b();
    private final Map b;
    private final G.c c;
    private final G.c d;

    class a implements G.c {
        final /* synthetic */ XW7 b;

        a(XW7 xw7) {
            this.b = xw7;
        }

        private VW7 d(WW7 ww7, Class cls, AbstractC20375ru1 abstractC20375ru1) {
            InterfaceC7720Sx5 interfaceC7720Sx5 = (InterfaceC7720Sx5) ((d) D92.a(ww7, d.class)).a().get(cls);
            UA2 ua2 = (UA2) abstractC20375ru1.a(CV2.e);
            Object obj = ((d) D92.a(ww7, d.class)).b().get(cls);
            if (obj == null) {
                if (ua2 != null) {
                    throw new IllegalStateException("Found creation callback but class " + cls.getName() + " does not have an assisted factory specified in @HiltViewModel.");
                }
                if (interfaceC7720Sx5 != null) {
                    return (VW7) interfaceC7720Sx5.get();
                }
                throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + cls.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
            }
            if (interfaceC7720Sx5 != null) {
                throw new AssertionError("Found the @HiltViewModel-annotated class " + cls.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
            }
            if (ua2 != null) {
                return (VW7) ua2.invoke(obj);
            }
            throw new IllegalStateException("Found @HiltViewModel-annotated class " + cls.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
        }

        @Override // androidx.lifecycle.G.c
        public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) throws Exception {
            final C17474n16 c17474n16 = new C17474n16();
            VW7 vw7D = d(this.b.b(androidx.lifecycle.B.a(abstractC20375ru1)).c(c17474n16).a(), cls, abstractC20375ru1);
            vw7D.H0(new Closeable() { // from class: ir.nasim.BV2
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    c17474n16.a();
                }
            });
            return vw7D;
        }
    }

    class b implements AbstractC20375ru1.b {
        b() {
        }
    }

    interface c {
        Map d();

        XW7 u();
    }

    public interface d {
        Map a();

        Map b();
    }

    public CV2(Map map, G.c cVar, XW7 xw7) {
        this.b = map;
        this.c = cVar;
        this.d = new a(xw7);
    }

    public static G.c d(Activity activity, G.c cVar) {
        c cVar2 = (c) D92.a(activity, c.class);
        return new CV2(cVar2.d(), cVar, cVar2.u());
    }

    public static G.c e(Activity activity, InterfaceC7760Tb6 interfaceC7760Tb6, Bundle bundle, G.c cVar) {
        return d(activity, cVar);
    }

    @Override // androidx.lifecycle.G.c
    public VW7 b(Class cls) {
        return this.b.containsKey(cls) ? this.d.b(cls) : this.c.b(cls);
    }

    @Override // androidx.lifecycle.G.c
    public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
        return this.b.containsKey(cls) ? this.d.c(cls, abstractC20375ru1) : this.c.c(cls, abstractC20375ru1);
    }
}
