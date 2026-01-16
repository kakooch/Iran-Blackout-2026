package ir.nasim;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.wN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23118wN7 {
    private static final AbstractC4099Dr3 a(AbstractC4099Dr3 abstractC4099Dr3) {
        return (AbstractC4099Dr3) AbstractC17021mG0.a(abstractC4099Dr3).d();
    }

    private static final String b(InterfaceC13882gy7 interfaceC13882gy7) {
        StringBuilder sb = new StringBuilder();
        c(AbstractC13042fc3.q("type: ", interfaceC13882gy7), sb);
        c(AbstractC13042fc3.q("hashCode: ", Integer.valueOf(interfaceC13882gy7.hashCode())), sb);
        c(AbstractC13042fc3.q("javaClass: ", interfaceC13882gy7.getClass().getCanonicalName()), sb);
        for (InterfaceC12795fB1 interfaceC12795fB1D = interfaceC13882gy7.d(); interfaceC12795fB1D != null; interfaceC12795fB1D = interfaceC12795fB1D.b()) {
            c(AbstractC13042fc3.q("fqName: ", FI1.g.r(interfaceC12795fB1D)), sb);
            c(AbstractC13042fc3.q("javaClass: ", interfaceC12795fB1D.getClass().getCanonicalName()), sb);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(sb, "$this_anonymous");
        sb.append(str);
        AbstractC13042fc3.h(sb, "append(value)");
        sb.append('\n');
        AbstractC13042fc3.h(sb, "append('\\n')");
        return sb;
    }

    public static final AbstractC4099Dr3 d(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, InterfaceC12064dy7 interfaceC12064dy7) {
        AbstractC13042fc3.i(abstractC4099Dr3, "subtype");
        AbstractC13042fc3.i(abstractC4099Dr32, "supertype");
        AbstractC13042fc3.i(interfaceC12064dy7, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new F07(abstractC4099Dr3, null));
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr32.K0();
        while (!arrayDeque.isEmpty()) {
            F07 f07 = (F07) arrayDeque.poll();
            AbstractC4099Dr3 abstractC4099Dr3B = f07.b();
            InterfaceC13882gy7 interfaceC13882gy7K02 = abstractC4099Dr3B.K0();
            if (interfaceC12064dy7.a(interfaceC13882gy7K02, interfaceC13882gy7K0)) {
                boolean zL0 = abstractC4099Dr3B.L0();
                for (F07 f07A = f07.a(); f07A != null; f07A = f07A.a()) {
                    AbstractC4099Dr3 abstractC4099Dr3B2 = f07A.b();
                    List listJ0 = abstractC4099Dr3B2.J0();
                    if ((listJ0 instanceof Collection) && listJ0.isEmpty()) {
                        abstractC4099Dr3B = AbstractC15082iy7.c.a(abstractC4099Dr3B2).c().n(abstractC4099Dr3B, KQ7.INVARIANT);
                        AbstractC13042fc3.h(abstractC4099Dr3B, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    } else {
                        Iterator it = listJ0.iterator();
                        while (it.hasNext()) {
                            KQ7 kq7C = ((InterfaceC3932Cy7) it.next()).c();
                            KQ7 kq7 = KQ7.INVARIANT;
                            if (kq7C != kq7) {
                                AbstractC4099Dr3 abstractC4099Dr3N = AbstractC18794pG0.f(AbstractC15082iy7.c.a(abstractC4099Dr3B2), false, 1, null).c().n(abstractC4099Dr3B, kq7);
                                AbstractC13042fc3.h(abstractC4099Dr3N, "TypeConstructorSubstitution.create(currentType)\n                            .wrapWithCapturingSubstitution().buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)");
                                abstractC4099Dr3B = a(abstractC4099Dr3N);
                                break;
                            }
                        }
                        abstractC4099Dr3B = AbstractC15082iy7.c.a(abstractC4099Dr3B2).c().n(abstractC4099Dr3B, KQ7.INVARIANT);
                        AbstractC13042fc3.h(abstractC4099Dr3B, "{\n                    TypeConstructorSubstitution.create(currentType)\n                            .buildSubstitutor()\n                            .safeSubstitute(substituted, Variance.INVARIANT)\n                }");
                    }
                    zL0 = zL0 || abstractC4099Dr3B2.L0();
                }
                InterfaceC13882gy7 interfaceC13882gy7K03 = abstractC4099Dr3B.K0();
                if (interfaceC12064dy7.a(interfaceC13882gy7K03, interfaceC13882gy7K0)) {
                    return AbstractC7497Ry7.p(abstractC4099Dr3B, zL0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(interfaceC13882gy7K03) + ", \n\nsupertype: " + b(interfaceC13882gy7K0) + " \n" + interfaceC12064dy7.a(interfaceC13882gy7K03, interfaceC13882gy7K0));
            }
            for (AbstractC4099Dr3 abstractC4099Dr33 : interfaceC13882gy7K02.b()) {
                AbstractC13042fc3.h(abstractC4099Dr33, "immediateSupertype");
                arrayDeque.add(new F07(abstractC4099Dr33, f07));
            }
        }
        return null;
    }
}
