package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.BB2;
import ir.nasim.InterfaceC15194jA0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class CB2 extends KC6 {
    public static final a G = new a(null);

    public static final class a {
        private a() {
        }

        private final InterfaceC24919zQ7 b(CB2 cb2, int i, InterfaceC22882vy7 interfaceC22882vy7) {
            String lowerCase;
            String strH = interfaceC22882vy7.getName().h();
            AbstractC13042fc3.h(strH, "typeParameter.name.asString()");
            if (AbstractC13042fc3.d(strH, TokenNames.T)) {
                lowerCase = "instance";
            } else if (AbstractC13042fc3.d(strH, TokenNames.E)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strH.toLowerCase();
                AbstractC13042fc3.h(lowerCase, "(this as java.lang.String).toLowerCase()");
            }
            InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
            C6432No4 c6432No4P = C6432No4.p(lowerCase);
            AbstractC13042fc3.h(c6432No4P, "identifier(name)");
            XC6 xc6P = interfaceC22882vy7.p();
            AbstractC13042fc3.h(xc6P, "typeParameter.defaultType");
            JH6 jh6 = JH6.a;
            AbstractC13042fc3.h(jh6, "NO_SOURCE");
            return new AQ7(cb2, null, i, interfaceC4356EuB, c6432No4P, xc6P, false, false, false, null, jh6);
        }

        public final CB2 a(C23595xB2 c23595xB2, boolean z) {
            AbstractC13042fc3.i(c23595xB2, "functionClass");
            List listQ = c23595xB2.q();
            CB2 cb2 = new CB2(c23595xB2, null, InterfaceC15194jA0.a.DECLARATION, z, null);
            ZI5 zi5H0 = c23595xB2.H0();
            List listM = AbstractC10360bX0.m();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listQ) {
                if (((InterfaceC22882vy7) obj).m() != KQ7.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<C14555i63> iterableU1 = AbstractC15401jX0.u1(arrayList);
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(iterableU1, 10));
            for (C14555i63 c14555i63 : iterableU1) {
                arrayList2.add(b(cb2, c14555i63.c(), (InterfaceC22882vy7) c14555i63.d()));
            }
            cb2.Q0(null, zi5H0, listM, arrayList2, ((InterfaceC22882vy7) AbstractC15401jX0.C0(listQ)).p(), EnumC11067cg4.ABSTRACT, QI1.e);
            cb2.Y0(true);
            return cb2;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ CB2(InterfaceC12795fB1 interfaceC12795fB1, CB2 cb2, InterfaceC15194jA0.a aVar, boolean z, ED1 ed1) {
        this(interfaceC12795fB1, cb2, aVar, z);
    }

    private final AB2 o1(List list) {
        C6432No4 c6432No4;
        int size = h().size() - list.size();
        boolean z = true;
        List listH = h();
        AbstractC13042fc3.h(listH, "valueParameters");
        List<InterfaceC24919zQ7> list2 = listH;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (InterfaceC24919zQ7 interfaceC24919zQ7 : list2) {
            C6432No4 name = interfaceC24919zQ7.getName();
            AbstractC13042fc3.h(name, "it.name");
            int index = interfaceC24919zQ7.getIndex();
            int i = index - size;
            if (i >= 0 && (c6432No4 = (C6432No4) list.get(i)) != null) {
                name = c6432No4;
            }
            arrayList.add(interfaceC24919zQ7.Z(this, name, index));
        }
        BB2.c cVarR0 = R0(C5585Jy7.b);
        List list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            z = false;
        } else {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((C6432No4) it.next()) == null) {
                    break;
                }
            }
            z = false;
        }
        BB2.c cVarK = cVarR0.G(z).c(arrayList).k(a());
        AbstractC13042fc3.h(cVarK, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        AB2 ab2L0 = super.L0(cVarK);
        AbstractC13042fc3.f(ab2L0);
        return ab2L0;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean C() {
        return false;
    }

    @Override // ir.nasim.KC6, ir.nasim.BB2
    protected BB2 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(jh6, "source");
        return new CB2(interfaceC12795fB1, (CB2) ab2, aVar, isSuspend());
    }

    @Override // ir.nasim.BB2
    protected AB2 L0(BB2.c cVar) {
        AbstractC13042fc3.i(cVar, "configuration");
        CB2 cb2 = (CB2) super.L0(cVar);
        if (cb2 == null) {
            return null;
        }
        List listH = cb2.h();
        AbstractC13042fc3.h(listH, "substituted.valueParameters");
        List list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return cb2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC4099Dr3 type = ((InterfaceC24919zQ7) it.next()).getType();
            AbstractC13042fc3.h(type, "it.type");
            if (FB2.c(type) != null) {
                List listH2 = cb2.h();
                AbstractC13042fc3.h(listH2, "substituted.valueParameters");
                List list2 = listH2;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    AbstractC4099Dr3 type2 = ((InterfaceC24919zQ7) it2.next()).getType();
                    AbstractC13042fc3.h(type2, "it.type");
                    arrayList.add(FB2.c(type2));
                }
                return cb2.o1(arrayList);
            }
        }
        return cb2;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return false;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean isInline() {
        return false;
    }

    private CB2(InterfaceC12795fB1 interfaceC12795fB1, CB2 cb2, InterfaceC15194jA0.a aVar, boolean z) {
        super(interfaceC12795fB1, cb2, InterfaceC4356Eu.W.b(), C21911uL4.h, aVar, JH6.a);
        e1(true);
        g1(z);
        X0(false);
    }
}
