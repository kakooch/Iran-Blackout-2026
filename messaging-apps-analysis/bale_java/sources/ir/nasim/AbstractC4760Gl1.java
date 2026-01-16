package ir.nasim;

import ir.nasim.C25201zu;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Gl1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4760Gl1 {

    /* renamed from: ir.nasim.Gl1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9182Yv3 e;
        final /* synthetic */ DU0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9182Yv3 c9182Yv3, DU0 du0) {
            super(0);
            this.e = c9182Yv3;
            this.f = du0;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8290Vi3 invoke() {
            return AbstractC4760Gl1.g(this.e, this.f.getAnnotations());
        }
    }

    /* renamed from: ir.nasim.Gl1$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9182Yv3 e;
        final /* synthetic */ InterfaceC4356Eu f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C9182Yv3 c9182Yv3, InterfaceC4356Eu interfaceC4356Eu) {
            super(0);
            this.e = c9182Yv3;
            this.f = interfaceC4356Eu;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8290Vi3 invoke() {
            return AbstractC4760Gl1.g(this.e, this.f);
        }
    }

    private static final C9182Yv3 a(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7820Ti3 interfaceC7820Ti3, int i, InterfaceC9173Yu3 interfaceC9173Yu3) {
        C3784Ci3 c3784Ci3A = c9182Yv3.a();
        InterfaceC25246zy7 c12042dw3 = interfaceC7820Ti3 == null ? null : new C12042dw3(c9182Yv3, interfaceC12795fB1, interfaceC7820Ti3, i);
        if (c12042dw3 == null) {
            c12042dw3 = c9182Yv3.f();
        }
        return new C9182Yv3(c3784Ci3A, c12042dw3, interfaceC9173Yu3);
    }

    public static final C9182Yv3 b(C9182Yv3 c9182Yv3, InterfaceC25246zy7 interfaceC25246zy7) {
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(interfaceC25246zy7, "typeParameterResolver");
        return new C9182Yv3(c9182Yv3.a(), interfaceC25246zy7, c9182Yv3.c());
    }

    public static final C9182Yv3 c(C9182Yv3 c9182Yv3, DU0 du0, InterfaceC7820Ti3 interfaceC7820Ti3, int i) {
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(du0, "containingDeclaration");
        return a(c9182Yv3, du0, interfaceC7820Ti3, i, AbstractC13269fw3.b(EnumC4870Gx3.c, new a(c9182Yv3, du0)));
    }

    public static /* synthetic */ C9182Yv3 d(C9182Yv3 c9182Yv3, DU0 du0, InterfaceC7820Ti3 interfaceC7820Ti3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC7820Ti3 = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return c(c9182Yv3, du0, interfaceC7820Ti3, i);
    }

    public static final C9182Yv3 e(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7820Ti3 interfaceC7820Ti3, int i) {
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC7820Ti3, "typeParameterOwner");
        return a(c9182Yv3, interfaceC12795fB1, interfaceC7820Ti3, i, c9182Yv3.c());
    }

    public static /* synthetic */ C9182Yv3 f(C9182Yv3 c9182Yv3, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC7820Ti3 interfaceC7820Ti3, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return e(c9182Yv3, interfaceC12795fB1, interfaceC7820Ti3, i);
    }

    public static final C8290Vi3 g(C9182Yv3 c9182Yv3, InterfaceC4356Eu interfaceC4356Eu) {
        EnumMap enumMapB;
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(interfaceC4356Eu, "additionalAnnotations");
        if (c9182Yv3.a().h().a()) {
            return c9182Yv3.b();
        }
        ArrayList<C9876ai3> arrayList = new ArrayList();
        Iterator it = interfaceC4356Eu.iterator();
        while (it.hasNext()) {
            C9876ai3 c9876ai3I = i(c9182Yv3, (InterfaceC21651tu) it.next());
            if (c9876ai3I != null) {
                arrayList.add(c9876ai3I);
            }
        }
        if (arrayList.isEmpty()) {
            return c9182Yv3.b();
        }
        C8290Vi3 c8290Vi3B = c9182Yv3.b();
        EnumMap enumMap = null;
        if (c8290Vi3B != null && (enumMapB = c8290Vi3B.b()) != null) {
            enumMap = new EnumMap(enumMapB);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(EnumC23427wu.class);
        }
        boolean z = false;
        for (C9876ai3 c9876ai3 : arrayList) {
            Iterator it2 = c9876ai3.f().iterator();
            while (it2.hasNext()) {
                enumMap.put((EnumMap) it2.next(), (EnumC23427wu) c9876ai3);
                z = true;
            }
        }
        return !z ? c9182Yv3.b() : new C8290Vi3(enumMap);
    }

    public static final C9182Yv3 h(C9182Yv3 c9182Yv3, InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(interfaceC4356Eu, "additionalAnnotations");
        return interfaceC4356Eu.isEmpty() ? c9182Yv3 : new C9182Yv3(c9182Yv3.a(), c9182Yv3.f(), AbstractC13269fw3.b(EnumC4870Gx3.c, new b(c9182Yv3, interfaceC4356Eu)));
    }

    private static final C9876ai3 i(C9182Yv3 c9182Yv3, InterfaceC21651tu interfaceC21651tu) {
        C25201zu c25201zuA = c9182Yv3.a().a();
        C9876ai3 c9876ai3L = c25201zuA.l(interfaceC21651tu);
        if (c9876ai3L != null) {
            return c9876ai3L;
        }
        C25201zu.a aVarN = c25201zuA.n(interfaceC21651tu);
        if (aVarN == null) {
            return null;
        }
        InterfaceC21651tu interfaceC21651tuA = aVarN.a();
        List listB = aVarN.b();
        EnumC23724xP5 enumC23724xP5K = c25201zuA.k(interfaceC21651tu);
        if (enumC23724xP5K == null) {
            enumC23724xP5K = c25201zuA.j(interfaceC21651tuA);
        }
        if (enumC23724xP5K.j()) {
            return null;
        }
        C14645iF4 c14645iF4H = c9182Yv3.a().q().h(interfaceC21651tuA, c9182Yv3.a().p().b(), false);
        C14645iF4 c14645iF4B = c14645iF4H == null ? null : C14645iF4.b(c14645iF4H, null, enumC23724xP5K.p(), 1, null);
        if (c14645iF4B == null) {
            return null;
        }
        return new C9876ai3(c14645iF4B, listB, false, 4, null);
    }

    public static final C9182Yv3 j(C9182Yv3 c9182Yv3, C3784Ci3 c3784Ci3) {
        AbstractC13042fc3.i(c9182Yv3, "<this>");
        AbstractC13042fc3.i(c3784Ci3, "components");
        return new C9182Yv3(c3784Ci3, c9182Yv3.f(), c9182Yv3.c());
    }
}
