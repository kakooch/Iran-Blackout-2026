package ir.nasim;

import ir.nasim.C11663dO4;
import ir.nasim.InterfaceC8487We2;
import java.util.List;

/* loaded from: classes8.dex */
public final class V92 implements InterfaceC8487We2 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C11663dO4.i.a.values().length];
            iArr[C11663dO4.i.a.OVERRIDABLE.ordinal()] = 1;
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC24919zQ7 interfaceC24919zQ7) {
            return interfaceC24919zQ7.getType();
        }
    }

    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.b a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "superDescriptor");
        AbstractC13042fc3.i(interfaceC14592iA02, "subDescriptor");
        if (interfaceC14592iA02 instanceof C20848si3) {
            C20848si3 c20848si3 = (C20848si3) interfaceC14592iA02;
            AbstractC13042fc3.h(c20848si3.getTypeParameters(), "subDescriptor.typeParameters");
            if (!(!r0.isEmpty())) {
                C11663dO4.i iVarZ = C11663dO4.z(interfaceC14592iA0, interfaceC14592iA02);
                if ((iVarZ == null ? null : iVarZ.c()) != null) {
                    return InterfaceC8487We2.b.UNKNOWN;
                }
                List listH = c20848si3.h();
                AbstractC13042fc3.h(listH, "subDescriptor.valueParameters");
                InterfaceC23384wp6 interfaceC23384wp6C = AbstractC11342cq6.C(AbstractC15401jX0.g0(listH), b.e);
                AbstractC4099Dr3 returnType = c20848si3.getReturnType();
                AbstractC13042fc3.f(returnType);
                InterfaceC23384wp6 interfaceC23384wp6G = AbstractC11342cq6.G(interfaceC23384wp6C, returnType);
                ZI5 zi5Q = c20848si3.Q();
                for (AbstractC4099Dr3 abstractC4099Dr3 : AbstractC11342cq6.F(interfaceC23384wp6G, AbstractC10360bX0.q(zi5Q != null ? zi5Q.getType() : null))) {
                    if ((!abstractC4099Dr3.J0().isEmpty()) && !(abstractC4099Dr3.N0() instanceof FG5)) {
                        return InterfaceC8487We2.b.UNKNOWN;
                    }
                }
                InterfaceC14592iA0 interfaceC14592iA03 = (InterfaceC14592iA0) interfaceC14592iA0.c(DG5.c.c());
                if (interfaceC14592iA03 == null) {
                    return InterfaceC8487We2.b.UNKNOWN;
                }
                if (interfaceC14592iA03 instanceof JC6) {
                    JC6 jc6 = (JC6) interfaceC14592iA03;
                    AbstractC13042fc3.h(jc6.getTypeParameters(), "erasedSuper.typeParameters");
                    if (!r0.isEmpty()) {
                        interfaceC14592iA03 = (JC6) jc6.t().p(AbstractC10360bX0.m()).a();
                        AbstractC13042fc3.f(interfaceC14592iA03);
                    }
                }
                C11663dO4.i.a aVarC = C11663dO4.d.I(interfaceC14592iA03, interfaceC14592iA02, false).c();
                AbstractC13042fc3.h(aVarC, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
                return a.a[aVarC.ordinal()] == 1 ? InterfaceC8487We2.b.OVERRIDABLE : InterfaceC8487We2.b.UNKNOWN;
            }
        }
        return InterfaceC8487We2.b.UNKNOWN;
    }

    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.a b() {
        return InterfaceC8487We2.a.SUCCESS_ONLY;
    }
}
