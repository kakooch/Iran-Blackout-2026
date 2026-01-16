package androidx.lifecycle;

import android.app.Application;
import android.gov.nist.javax.sip.stack.SIPServerTransaction;
import ir.nasim.AbstractC10592bs;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC4762Gl3;
import ir.nasim.C12390eX7;
import ir.nasim.C13617gX7;
import ir.nasim.C14819iX7;
import ir.nasim.C9092Yl3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11299cm3;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.VW7;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class G {
    public static final b b = new b(null);
    public static final AbstractC20375ru1.b c = C13617gX7.a.a;
    private final C12390eX7 a;

    public static final class b {
        private b() {
        }

        public static /* synthetic */ G c(b bVar, InterfaceC15408jX7 interfaceC15408jX7, c cVar, AbstractC20375ru1 abstractC20375ru1, int i, Object obj) {
            if ((i & 2) != 0) {
                cVar = C13617gX7.a.b(interfaceC15408jX7);
            }
            if ((i & 4) != 0) {
                abstractC20375ru1 = C13617gX7.a.a(interfaceC15408jX7);
            }
            return bVar.b(interfaceC15408jX7, cVar, abstractC20375ru1);
        }

        public final G a(C14819iX7 c14819iX7, c cVar, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(c14819iX7, "store");
            AbstractC13042fc3.i(cVar, "factory");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return new G(c14819iX7, cVar, abstractC20375ru1);
        }

        public final G b(InterfaceC15408jX7 interfaceC15408jX7, c cVar, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(interfaceC15408jX7, "owner");
            AbstractC13042fc3.i(cVar, "factory");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return new G(interfaceC15408jX7.d1(), cVar, abstractC20375ru1);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public interface c {
        public static final a a = a.a;

        public static final class a {
            static final /* synthetic */ a a = new a();

            private a() {
            }
        }

        default VW7 a(InterfaceC11299cm3 interfaceC11299cm3, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return c(AbstractC4762Gl3.b(interfaceC11299cm3), abstractC20375ru1);
        }

        default VW7 b(Class cls) {
            AbstractC13042fc3.i(cls, "modelClass");
            return C13617gX7.a.d();
        }

        default VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return b(cls);
        }
    }

    public static class d implements c {
        private static d c;
        public static final a b = new a(null);
        public static final AbstractC20375ru1.b d = C13617gX7.a.a;

        public static final class a {
            private a() {
            }

            public final d a() {
                if (d.c == null) {
                    d.c = new d();
                }
                d dVar = d.c;
                AbstractC13042fc3.f(dVar);
                return dVar;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        @Override // androidx.lifecycle.G.c
        public VW7 a(InterfaceC11299cm3 interfaceC11299cm3, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return c(AbstractC4762Gl3.b(interfaceC11299cm3), abstractC20375ru1);
        }

        @Override // androidx.lifecycle.G.c
        public VW7 b(Class cls) {
            AbstractC13042fc3.i(cls, "modelClass");
            return C9092Yl3.a.a(cls);
        }

        @Override // androidx.lifecycle.G.c
        public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            return b(cls);
        }
    }

    public static class e {
        public abstract void d(VW7 vw7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public G(C14819iX7 c14819iX7, c cVar) {
        this(c14819iX7, cVar, null, 4, null);
        AbstractC13042fc3.i(c14819iX7, "store");
        AbstractC13042fc3.i(cVar, "factory");
    }

    public final VW7 a(InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        return C12390eX7.b(this.a, interfaceC11299cm3, null, 2, null);
    }

    public VW7 b(Class cls) {
        AbstractC13042fc3.i(cls, "modelClass");
        return a(AbstractC4762Gl3.e(cls));
    }

    public final VW7 c(String str, InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        return this.a.a(interfaceC11299cm3, str);
    }

    public VW7 d(String str, Class cls) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(cls, "modelClass");
        return this.a.a(AbstractC4762Gl3.e(cls), str);
    }

    public static class a extends d {
        private static a g;
        private final Application e;
        public static final b f = new b(null);
        public static final AbstractC20375ru1.b h = new C0089a();

        /* renamed from: androidx.lifecycle.G$a$a, reason: collision with other inner class name */
        public static final class C0089a implements AbstractC20375ru1.b {
            C0089a() {
            }
        }

        public static final class b {
            private b() {
            }

            public final a a(Application application) {
                AbstractC13042fc3.i(application, SIPServerTransaction.CONTENT_TYPE_APPLICATION);
                if (a.g == null) {
                    a.g = new a(application);
                }
                a aVar = a.g;
                AbstractC13042fc3.f(aVar);
                return aVar;
            }

            public /* synthetic */ b(ED1 ed1) {
                this();
            }
        }

        private a(Application application, int i) {
            this.e = application;
        }

        private final VW7 h(Class cls, Application application) {
            if (!AbstractC10592bs.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            try {
                VW7 vw7 = (VW7) cls.getConstructor(Application.class).newInstance(application);
                AbstractC13042fc3.h(vw7, "{\n                try {\n…          }\n            }");
                return vw7;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }

        @Override // androidx.lifecycle.G.d, androidx.lifecycle.G.c
        public VW7 b(Class cls) {
            AbstractC13042fc3.i(cls, "modelClass");
            Application application = this.e;
            if (application != null) {
                return h(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.G.d, androidx.lifecycle.G.c
        public VW7 c(Class cls, AbstractC20375ru1 abstractC20375ru1) {
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(abstractC20375ru1, "extras");
            if (this.e != null) {
                return b(cls);
            }
            Application application = (Application) abstractC20375ru1.a(h);
            if (application != null) {
                return h(cls, application);
            }
            if (AbstractC10592bs.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.b(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            AbstractC13042fc3.i(application, SIPServerTransaction.CONTENT_TYPE_APPLICATION);
        }
    }

    private G(C12390eX7 c12390eX7) {
        this.a = c12390eX7;
    }

    public /* synthetic */ G(C14819iX7 c14819iX7, c cVar, AbstractC20375ru1 abstractC20375ru1, int i, ED1 ed1) {
        this(c14819iX7, cVar, (i & 4) != 0 ? AbstractC20375ru1.a.b : abstractC20375ru1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public G(C14819iX7 c14819iX7, c cVar, AbstractC20375ru1 abstractC20375ru1) {
        this(new C12390eX7(c14819iX7, cVar, abstractC20375ru1));
        AbstractC13042fc3.i(c14819iX7, "store");
        AbstractC13042fc3.i(cVar, "factory");
        AbstractC13042fc3.i(abstractC20375ru1, "defaultCreationExtras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public G(InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(interfaceC15408jX7, "owner");
        C14819iX7 c14819iX7D1 = interfaceC15408jX7.d1();
        C13617gX7 c13617gX7 = C13617gX7.a;
        this(c14819iX7D1, c13617gX7.b(interfaceC15408jX7), c13617gX7.a(interfaceC15408jX7));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public G(InterfaceC15408jX7 interfaceC15408jX7, c cVar) {
        this(interfaceC15408jX7.d1(), cVar, C13617gX7.a.a(interfaceC15408jX7));
        AbstractC13042fc3.i(interfaceC15408jX7, "owner");
        AbstractC13042fc3.i(cVar, "factory");
    }
}
