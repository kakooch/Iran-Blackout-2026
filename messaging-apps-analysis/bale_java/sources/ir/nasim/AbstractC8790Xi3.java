package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Xi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8790Xi3 {
    private static final C9424Zw2 a = new C9424Zw2("java.lang.Class");

    /* renamed from: ir.nasim.Xi3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC22882vy7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC22882vy7 interfaceC22882vy7) {
            super(0);
            this.e = interfaceC22882vy7;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke() {
            XC6 xc6J = AbstractC14230ha2.j("Can't compute erased upper bound of type parameter `" + this.e + '`');
            AbstractC13042fc3.h(xc6J, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
            return xc6J;
        }
    }

    public static final AbstractC4099Dr3 b(InterfaceC22882vy7 interfaceC22882vy7, InterfaceC22882vy7 interfaceC22882vy72, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC22882vy7, "<this>");
        AbstractC13042fc3.i(sa2, "defaultValue");
        if (interfaceC22882vy7 == interfaceC22882vy72) {
            return (AbstractC4099Dr3) sa2.invoke();
        }
        List upperBounds = interfaceC22882vy7.getUpperBounds();
        AbstractC13042fc3.h(upperBounds, "upperBounds");
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) AbstractC15401jX0.q0(upperBounds);
        if (abstractC4099Dr3.K0().t() instanceof InterfaceC21331tU0) {
            AbstractC13042fc3.h(abstractC4099Dr3, "firstUpperBound");
            return AbstractC7731Sy7.m(abstractC4099Dr3);
        }
        if (interfaceC22882vy72 != null) {
            interfaceC22882vy7 = interfaceC22882vy72;
        }
        MU0 mu0D = abstractC4099Dr3.K0().t();
        if (mu0D == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        do {
            InterfaceC22882vy7 interfaceC22882vy73 = (InterfaceC22882vy7) mu0D;
            if (AbstractC13042fc3.d(interfaceC22882vy73, interfaceC22882vy7)) {
                return (AbstractC4099Dr3) sa2.invoke();
            }
            List upperBounds2 = interfaceC22882vy73.getUpperBounds();
            AbstractC13042fc3.h(upperBounds2, "current.upperBounds");
            AbstractC4099Dr3 abstractC4099Dr32 = (AbstractC4099Dr3) AbstractC15401jX0.q0(upperBounds2);
            if (abstractC4099Dr32.K0().t() instanceof InterfaceC21331tU0) {
                AbstractC13042fc3.h(abstractC4099Dr32, "nextUpperBound");
                return AbstractC7731Sy7.m(abstractC4099Dr32);
            }
            mu0D = abstractC4099Dr32.K0().t();
        } while (mu0D != null);
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
    }

    public static /* synthetic */ AbstractC4099Dr3 c(InterfaceC22882vy7 interfaceC22882vy7, InterfaceC22882vy7 interfaceC22882vy72, SA2 sa2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC22882vy72 = null;
        }
        if ((i & 2) != 0) {
            sa2 = new a(interfaceC22882vy7);
        }
        return b(interfaceC22882vy7, interfaceC22882vy72, sa2);
    }

    public static final InterfaceC3932Cy7 d(InterfaceC22882vy7 interfaceC22882vy7, C6637Oi3 c6637Oi3) {
        AbstractC13042fc3.i(interfaceC22882vy7, "typeParameter");
        AbstractC13042fc3.i(c6637Oi3, "attr");
        return c6637Oi3.d() == EnumC7263Qy7.SUPERTYPE ? new C4400Ey7(SJ6.a(interfaceC22882vy7)) : new RJ6(interfaceC22882vy7);
    }

    public static final C6637Oi3 e(EnumC7263Qy7 enumC7263Qy7, boolean z, InterfaceC22882vy7 interfaceC22882vy7) {
        AbstractC13042fc3.i(enumC7263Qy7, "<this>");
        return new C6637Oi3(enumC7263Qy7, null, z, interfaceC22882vy7, 2, null);
    }

    public static /* synthetic */ C6637Oi3 f(EnumC7263Qy7 enumC7263Qy7, boolean z, InterfaceC22882vy7 interfaceC22882vy7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            interfaceC22882vy7 = null;
        }
        return e(enumC7263Qy7, z, interfaceC22882vy7);
    }
}
