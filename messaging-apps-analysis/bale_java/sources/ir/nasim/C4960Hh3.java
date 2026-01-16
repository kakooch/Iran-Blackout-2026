package ir.nasim;

import ir.nasim.PJ6;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Map;

/* renamed from: ir.nasim.Hh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4960Hh3 {
    public static final C4960Hh3 a = new C4960Hh3();
    private static final C6432No4 b;
    private static final C6432No4 c;
    private static final C6432No4 d;
    private static final Map e;
    private static final Map f;

    static {
        C6432No4 c6432No4P = C6432No4.p(DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.h(c6432No4P, "identifier(\"message\")");
        b = c6432No4P;
        C6432No4 c6432No4P2 = C6432No4.p("allowedTargets");
        AbstractC13042fc3.h(c6432No4P2, "identifier(\"allowedTargets\")");
        c = c6432No4P2;
        C6432No4 c6432No4P3 = C6432No4.p("value");
        AbstractC13042fc3.h(c6432No4P3, "identifier(\"value\")");
        d = c6432No4P3;
        C9424Zw2 c9424Zw2 = PJ6.a.F;
        C9424Zw2 c9424Zw22 = AbstractC24521yl3.d;
        XV4 xv4A = AbstractC4616Fw7.a(c9424Zw2, c9424Zw22);
        C9424Zw2 c9424Zw23 = PJ6.a.I;
        C9424Zw2 c9424Zw24 = AbstractC24521yl3.e;
        XV4 xv4A2 = AbstractC4616Fw7.a(c9424Zw23, c9424Zw24);
        C9424Zw2 c9424Zw25 = PJ6.a.J;
        C9424Zw2 c9424Zw26 = AbstractC24521yl3.h;
        XV4 xv4A3 = AbstractC4616Fw7.a(c9424Zw25, c9424Zw26);
        C9424Zw2 c9424Zw27 = PJ6.a.K;
        C9424Zw2 c9424Zw28 = AbstractC24521yl3.g;
        e = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a(c9424Zw27, c9424Zw28));
        f = AbstractC20051rO3.n(AbstractC4616Fw7.a(c9424Zw22, c9424Zw2), AbstractC4616Fw7.a(c9424Zw24, c9424Zw23), AbstractC4616Fw7.a(AbstractC24521yl3.f, PJ6.a.y), AbstractC4616Fw7.a(c9424Zw26, c9424Zw25), AbstractC4616Fw7.a(c9424Zw28, c9424Zw27));
    }

    private C4960Hh3() {
    }

    public static /* synthetic */ InterfaceC21651tu f(C4960Hh3 c4960Hh3, InterfaceC4009Dh3 interfaceC4009Dh3, C9182Yv3 c9182Yv3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return c4960Hh3.e(interfaceC4009Dh3, c9182Yv3, z);
    }

    public final InterfaceC21651tu a(C9424Zw2 c9424Zw2, InterfaceC5194Ih3 interfaceC5194Ih3, C9182Yv3 c9182Yv3) {
        InterfaceC4009Dh3 interfaceC4009Dh3Z;
        AbstractC13042fc3.i(c9424Zw2, "kotlinName");
        AbstractC13042fc3.i(interfaceC5194Ih3, "annotationOwner");
        AbstractC13042fc3.i(c9182Yv3, "c");
        if (AbstractC13042fc3.d(c9424Zw2, PJ6.a.y)) {
            C9424Zw2 c9424Zw22 = AbstractC24521yl3.f;
            AbstractC13042fc3.h(c9424Zw22, "DEPRECATED_ANNOTATION");
            InterfaceC4009Dh3 interfaceC4009Dh3Z2 = interfaceC5194Ih3.z(c9424Zw22);
            if (interfaceC4009Dh3Z2 != null || interfaceC5194Ih3.E()) {
                return new C11259ci3(interfaceC4009Dh3Z2, c9182Yv3);
            }
        }
        C9424Zw2 c9424Zw23 = (C9424Zw2) e.get(c9424Zw2);
        if (c9424Zw23 == null || (interfaceC4009Dh3Z = interfaceC5194Ih3.z(c9424Zw23)) == null) {
            return null;
        }
        return f(this, interfaceC4009Dh3Z, c9182Yv3, false, 4, null);
    }

    public final C6432No4 b() {
        return b;
    }

    public final C6432No4 c() {
        return d;
    }

    public final C6432No4 d() {
        return c;
    }

    public final InterfaceC21651tu e(InterfaceC4009Dh3 interfaceC4009Dh3, C9182Yv3 c9182Yv3, boolean z) {
        AbstractC13042fc3.i(interfaceC4009Dh3, "annotation");
        AbstractC13042fc3.i(c9182Yv3, "c");
        C24948zU0 c24948zU0F = interfaceC4009Dh3.f();
        if (AbstractC13042fc3.d(c24948zU0F, C24948zU0.m(AbstractC24521yl3.d))) {
            return new C4969Hi3(interfaceC4009Dh3, c9182Yv3);
        }
        if (AbstractC13042fc3.d(c24948zU0F, C24948zU0.m(AbstractC24521yl3.e))) {
            return new C4252Ei3(interfaceC4009Dh3, c9182Yv3);
        }
        if (AbstractC13042fc3.d(c24948zU0F, C24948zU0.m(AbstractC24521yl3.h))) {
            return new C4726Gh3(c9182Yv3, interfaceC4009Dh3, PJ6.a.J);
        }
        if (AbstractC13042fc3.d(c24948zU0F, C24948zU0.m(AbstractC24521yl3.g))) {
            return new C4726Gh3(c9182Yv3, interfaceC4009Dh3, PJ6.a.K);
        }
        if (AbstractC13042fc3.d(c24948zU0F, C24948zU0.m(AbstractC24521yl3.f))) {
            return null;
        }
        return new C7232Qv3(c9182Yv3, interfaceC4009Dh3, z);
    }
}
