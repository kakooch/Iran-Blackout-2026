package ir.nasim;

import ir.nasim.PJ6;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Cu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3888Cu {
    private static final C6432No4 a;
    private static final C6432No4 b;
    private static final C6432No4 c;
    private static final C6432No4 d;
    private static final C6432No4 e;

    /* renamed from: ir.nasim.Cu$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC19738qr3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC19738qr3 abstractC19738qr3) {
            super(1);
            this.e = abstractC19738qr3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            XC6 xc6L = interfaceC8507Wg4.n().l(KQ7.INVARIANT, this.e.V());
            AbstractC13042fc3.h(xc6L, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return xc6L;
        }
    }

    static {
        C6432No4 c6432No4P = C6432No4.p(DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.h(c6432No4P, "identifier(\"message\")");
        a = c6432No4P;
        C6432No4 c6432No4P2 = C6432No4.p("replaceWith");
        AbstractC13042fc3.h(c6432No4P2, "identifier(\"replaceWith\")");
        b = c6432No4P2;
        C6432No4 c6432No4P3 = C6432No4.p("level");
        AbstractC13042fc3.h(c6432No4P3, "identifier(\"level\")");
        c = c6432No4P3;
        C6432No4 c6432No4P4 = C6432No4.p("expression");
        AbstractC13042fc3.h(c6432No4P4, "identifier(\"expression\")");
        d = c6432No4P4;
        C6432No4 c6432No4P5 = C6432No4.p("imports");
        AbstractC13042fc3.h(c6432No4P5, "identifier(\"imports\")");
        e = c6432No4P5;
    }

    public static final InterfaceC21651tu a(AbstractC19738qr3 abstractC19738qr3, String str, String str2, String str3) {
        AbstractC13042fc3.i(abstractC19738qr3, "<this>");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(str2, "replaceWith");
        AbstractC13042fc3.i(str3, "level");
        C11296cm0 c11296cm0 = new C11296cm0(abstractC19738qr3, PJ6.a.B, AbstractC20051rO3.n(AbstractC4616Fw7.a(d, new C9790aZ6(str2)), AbstractC4616Fw7.a(e, new WJ(AbstractC10360bX0.m(), new a(abstractC19738qr3)))));
        C9424Zw2 c9424Zw2 = PJ6.a.y;
        XV4 xv4A = AbstractC4616Fw7.a(a, new C9790aZ6(str));
        XV4 xv4A2 = AbstractC4616Fw7.a(b, new C4122Du(c11296cm0));
        C6432No4 c6432No4 = c;
        C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.A);
        AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.deprecationLevel)");
        C6432No4 c6432No4P = C6432No4.p(str3);
        AbstractC13042fc3.h(c6432No4P, "identifier(level)");
        return new C11296cm0(abstractC19738qr3, c9424Zw2, AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a(c6432No4, new N92(c24948zU0M, c6432No4P))));
    }

    public static /* synthetic */ InterfaceC21651tu b(AbstractC19738qr3 abstractC19738qr3, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return a(abstractC19738qr3, str, str2, str3);
    }
}
