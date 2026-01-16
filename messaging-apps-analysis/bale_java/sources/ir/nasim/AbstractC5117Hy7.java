package ir.nasim;

/* renamed from: ir.nasim.Hy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5117Hy7 {
    public static final b a = new b(null);
    public static final AbstractC5117Hy7 b = new a();

    /* renamed from: ir.nasim.Hy7$a */
    public static final class a extends AbstractC5117Hy7 {
        a() {
        }

        @Override // ir.nasim.AbstractC5117Hy7
        public /* bridge */ /* synthetic */ InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
            return (InterfaceC3932Cy7) h(abstractC4099Dr3);
        }

        @Override // ir.nasim.AbstractC5117Hy7
        public boolean f() {
            return true;
        }

        public Void h(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* renamed from: ir.nasim.Hy7$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final C5585Jy7 c() {
        C5585Jy7 c5585Jy7G = C5585Jy7.g(this);
        AbstractC13042fc3.h(c5585Jy7G, "create(this)");
        return c5585Jy7G;
    }

    public InterfaceC4356Eu d(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        return interfaceC4356Eu;
    }

    public abstract InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3);

    public boolean f() {
        return false;
    }

    public AbstractC4099Dr3 g(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7) {
        AbstractC13042fc3.i(abstractC4099Dr3, "topLevelType");
        AbstractC13042fc3.i(kq7, "position");
        return abstractC4099Dr3;
    }
}
