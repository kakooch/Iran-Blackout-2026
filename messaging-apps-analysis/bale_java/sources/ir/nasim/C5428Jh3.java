package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Jh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5428Jh3 {
    public static final C5428Jh3 a = new C5428Jh3();
    private static final Map b = AbstractC20051rO3.n(AbstractC4616Fw7.a("PACKAGE", EnumSet.noneOf(EnumC3865Cr3.class)), AbstractC4616Fw7.a("TYPE", EnumSet.of(EnumC3865Cr3.CLASS, EnumC3865Cr3.FILE)), AbstractC4616Fw7.a("ANNOTATION_TYPE", EnumSet.of(EnumC3865Cr3.ANNOTATION_CLASS)), AbstractC4616Fw7.a("TYPE_PARAMETER", EnumSet.of(EnumC3865Cr3.TYPE_PARAMETER)), AbstractC4616Fw7.a("FIELD", EnumSet.of(EnumC3865Cr3.FIELD)), AbstractC4616Fw7.a("LOCAL_VARIABLE", EnumSet.of(EnumC3865Cr3.LOCAL_VARIABLE)), AbstractC4616Fw7.a("PARAMETER", EnumSet.of(EnumC3865Cr3.VALUE_PARAMETER)), AbstractC4616Fw7.a("CONSTRUCTOR", EnumSet.of(EnumC3865Cr3.CONSTRUCTOR)), AbstractC4616Fw7.a("METHOD", EnumSet.of(EnumC3865Cr3.FUNCTION, EnumC3865Cr3.PROPERTY_GETTER, EnumC3865Cr3.PROPERTY_SETTER)), AbstractC4616Fw7.a("TYPE_USE", EnumSet.of(EnumC3865Cr3.TYPE)));
    private static final Map c = AbstractC20051rO3.n(AbstractC4616Fw7.a("RUNTIME", EnumC3631Br3.RUNTIME), AbstractC4616Fw7.a("CLASS", EnumC3631Br3.BINARY), AbstractC4616Fw7.a("SOURCE", EnumC3631Br3.SOURCE));

    /* renamed from: ir.nasim.Jh3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            InterfaceC24919zQ7 interfaceC24919zQ7B = KI1.b(C4960Hh3.a.d(), interfaceC8507Wg4.n().o(PJ6.a.F));
            AbstractC4099Dr3 type = interfaceC24919zQ7B == null ? null : interfaceC24919zQ7B.getType();
            if (type != null) {
                return type;
            }
            XC6 xc6J = AbstractC14230ha2.j("Error: AnnotationTarget[]");
            AbstractC13042fc3.h(xc6J, "createErrorType(\"Error: AnnotationTarget[]\")");
            return xc6J;
        }
    }

    private C5428Jh3() {
    }

    public final AbstractC7068Qd1 a(InterfaceC4243Eh3 interfaceC4243Eh3) {
        InterfaceC14311hi3 interfaceC14311hi3 = interfaceC4243Eh3 instanceof InterfaceC14311hi3 ? (InterfaceC14311hi3) interfaceC4243Eh3 : null;
        if (interfaceC14311hi3 == null) {
            return null;
        }
        Map map = c;
        C6432No4 c6432No4E = interfaceC14311hi3.e();
        EnumC3631Br3 enumC3631Br3 = (EnumC3631Br3) map.get(c6432No4E == null ? null : c6432No4E.h());
        if (enumC3631Br3 == null) {
            return null;
        }
        C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.H);
        AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.annotationRetention)");
        C6432No4 c6432No4P = C6432No4.p(enumC3631Br3.name());
        AbstractC13042fc3.h(c6432No4P, "identifier(retention.name)");
        return new N92(c24948zU0M, c6432No4P);
    }

    public final Set b(String str) {
        EnumSet enumSet = (EnumSet) b.get(str);
        return enumSet == null ? AbstractC4597Fu6.d() : enumSet;
    }

    public final AbstractC7068Qd1 c(List list) {
        AbstractC13042fc3.i(list, "arguments");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof InterfaceC14311hi3) {
                arrayList.add(obj);
            }
        }
        ArrayList<EnumC3865Cr3> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C6432No4 c6432No4E = ((InterfaceC14311hi3) it.next()).e();
            AbstractC13610gX0.D(arrayList2, b(c6432No4E == null ? null : c6432No4E.h()));
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        for (EnumC3865Cr3 enumC3865Cr3 : arrayList2) {
            C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.G);
            AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.annotationTarget)");
            C6432No4 c6432No4P = C6432No4.p(enumC3865Cr3.name());
            AbstractC13042fc3.h(c6432No4P, "identifier(kotlinTarget.name)");
            arrayList3.add(new N92(c24948zU0M, c6432No4P));
        }
        return new WJ(arrayList3, a.e);
    }
}
