package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC8317Vl3;
import ir.nasim.PJ6;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Oe4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6597Oe4 {
    private static final void a(StringBuilder sb, AbstractC4099Dr3 abstractC4099Dr3) {
        sb.append(g(abstractC4099Dr3));
    }

    public static final String b(AB2 ab2, boolean z, boolean z2) {
        String strH;
        AbstractC13042fc3.i(ab2, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (ab2 instanceof InterfaceC21426te1) {
                strH = "<init>";
            } else {
                strH = ab2.getName().h();
                AbstractC13042fc3.h(strH, "name.asString()");
            }
            sb.append(strH);
        }
        sb.append(Separators.LPAREN);
        ZI5 zi5Q = ab2.Q();
        if (zi5Q != null) {
            AbstractC4099Dr3 type = zi5Q.getType();
            AbstractC13042fc3.h(type, "it.type");
            a(sb, type);
        }
        Iterator it = ab2.h().iterator();
        while (it.hasNext()) {
            AbstractC4099Dr3 type2 = ((InterfaceC24919zQ7) it.next()).getType();
            AbstractC13042fc3.h(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(Separators.RPAREN);
        if (z) {
            if (AbstractC22471vI1.c(ab2)) {
                sb.append(TokenNames.V);
            } else {
                AbstractC4099Dr3 returnType = ab2.getReturnType();
                AbstractC13042fc3.f(returnType);
                a(sb, returnType);
            }
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String c(AB2 ab2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return b(ab2, z, z2);
    }

    public static final String d(InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "<this>");
        C17582nC6 c17582nC6 = C17582nC6.a;
        if (OI1.E(interfaceC14592iA0)) {
            return null;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC14592iA0.b();
        InterfaceC21331tU0 interfaceC21331tU0 = interfaceC12795fB1B instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) interfaceC12795fB1B : null;
        if (interfaceC21331tU0 == null || interfaceC21331tU0.getName().q()) {
            return null;
        }
        InterfaceC14592iA0 interfaceC14592iA0A = interfaceC14592iA0.a();
        JC6 jc6 = interfaceC14592iA0A instanceof JC6 ? (JC6) interfaceC14592iA0A : null;
        if (jc6 == null) {
            return null;
        }
        return AbstractC6103Me4.a(c17582nC6, interfaceC21331tU0, c(jc6, false, false, 3, null));
    }

    public static final boolean e(InterfaceC14592iA0 interfaceC14592iA0) {
        AB2 ab2K;
        AbstractC13042fc3.i(interfaceC14592iA0, "f");
        if (!(interfaceC14592iA0 instanceof AB2)) {
            return false;
        }
        AB2 ab2 = (AB2) interfaceC14592iA0;
        if (!AbstractC13042fc3.d(ab2.getName().h(), "remove") || ab2.h().size() != 1 || AbstractC21886uI6.h((InterfaceC15194jA0) interfaceC14592iA0)) {
            return false;
        }
        List listH = ab2.a().h();
        AbstractC13042fc3.h(listH, "f.original.valueParameters");
        AbstractC4099Dr3 type = ((InterfaceC24919zQ7) AbstractC15401jX0.V0(listH)).getType();
        AbstractC13042fc3.h(type, "f.original.valueParameters.single().type");
        AbstractC8317Vl3 abstractC8317Vl3G = g(type);
        AbstractC8317Vl3.d dVar = abstractC8317Vl3G instanceof AbstractC8317Vl3.d ? (AbstractC8317Vl3.d) abstractC8317Vl3G : null;
        if ((dVar != null ? dVar.i() : null) != EnumC7376Rl3.INT || (ab2K = C17912nm0.k(ab2)) == null) {
            return false;
        }
        List listH2 = ab2K.a().h();
        AbstractC13042fc3.h(listH2, "overridden.original.valueParameters");
        AbstractC4099Dr3 type2 = ((InterfaceC24919zQ7) AbstractC15401jX0.V0(listH2)).getType();
        AbstractC13042fc3.h(type2, "overridden.original.valueParameters.single().type");
        AbstractC8317Vl3 abstractC8317Vl3G2 = g(type2);
        InterfaceC12795fB1 interfaceC12795fB1B = ab2K.b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "overridden.containingDeclaration");
        return AbstractC13042fc3.d(PI1.j(interfaceC12795fB1B), PJ6.a.X.j()) && (abstractC8317Vl3G2 instanceof AbstractC8317Vl3.c) && AbstractC13042fc3.d(((AbstractC8317Vl3.c) abstractC8317Vl3G2).i(), "java/lang/Object");
    }

    public static final String f(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
        C5203Ii3 c5203Ii3 = C5203Ii3.a;
        C10027ax2 c10027ax2J = PI1.i(interfaceC21331tU0).j();
        AbstractC13042fc3.h(c10027ax2J, "fqNameSafe.toUnsafe()");
        C24948zU0 c24948zU0O = c5203Ii3.o(c10027ax2J);
        if (c24948zU0O == null) {
            return AbstractC22471vI1.b(interfaceC21331tU0, null, 2, null);
        }
        String strF = C4996Hl3.b(c24948zU0O).f();
        AbstractC13042fc3.h(strF, "byClassId(it).internalName");
        return strF;
    }

    public static final AbstractC8317Vl3 g(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "<this>");
        return (AbstractC8317Vl3) AbstractC22471vI1.e(abstractC4099Dr3, C8817Xl3.a, C21696ty7.o, C21009sy7.a, null, null, 32, null);
    }
}
