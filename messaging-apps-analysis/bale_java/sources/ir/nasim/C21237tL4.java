package ir.nasim;

import ir.nasim.AbstractC22322v24;
import ir.nasim.AbstractC23500x16;
import ir.nasim.AbstractC23735xQ7;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tL4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21237tL4 extends AbstractC18058o1 {
    public static final C21237tL4 a = new C21237tL4();
    private static final List b;

    /* renamed from: ir.nasim.tL4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(AB2 ab2) {
            Boolean boolValueOf;
            AbstractC13042fc3.i(ab2, "<this>");
            List listH = ab2.h();
            AbstractC13042fc3.h(listH, "valueParameters");
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) AbstractC15401jX0.F0(listH);
            if (interfaceC24919zQ7 == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(!PI1.a(interfaceC24919zQ7) && interfaceC24919zQ7.u0() == null);
            }
            boolean zD = AbstractC13042fc3.d(boolValueOf, Boolean.TRUE);
            C21237tL4 c21237tL4 = C21237tL4.a;
            if (zD) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* renamed from: ir.nasim.tL4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        private static final boolean b(InterfaceC12795fB1 interfaceC12795fB1) {
            return (interfaceC12795fB1 instanceof InterfaceC21331tU0) && AbstractC19738qr3.Z((InterfaceC21331tU0) interfaceC12795fB1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(AB2 ab2) {
            boolean z;
            AbstractC13042fc3.i(ab2, "<this>");
            C21237tL4 c21237tL4 = C21237tL4.a;
            InterfaceC12795fB1 interfaceC12795fB1B = ab2.b();
            AbstractC13042fc3.h(interfaceC12795fB1B, "containingDeclaration");
            if (b(interfaceC12795fB1B)) {
                z = true;
                break;
            }
            Collection collectionD = ab2.d();
            AbstractC13042fc3.h(collectionD, "overriddenDescriptors");
            Collection collection = collectionD;
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    InterfaceC12795fB1 interfaceC12795fB1B2 = ((AB2) it.next()).b();
                    AbstractC13042fc3.h(interfaceC12795fB1B2, "it.containingDeclaration");
                    if (b(interfaceC12795fB1B2)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* renamed from: ir.nasim.tL4$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(AB2 ab2) {
            boolean zG;
            AbstractC13042fc3.i(ab2, "<this>");
            ZI5 zi5N = ab2.N();
            if (zi5N == null) {
                zi5N = ab2.Q();
            }
            C21237tL4 c21237tL4 = C21237tL4.a;
            boolean z = false;
            if (zi5N != null) {
                AbstractC4099Dr3 returnType = ab2.getReturnType();
                if (returnType == null) {
                    zG = false;
                } else {
                    AbstractC4099Dr3 type = zi5N.getType();
                    AbstractC13042fc3.h(type, "receiver.type");
                    zG = AbstractC7731Sy7.g(returnType, type);
                }
                if (zG) {
                    z = true;
                }
            }
            if (z) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        C6432No4 c6432No4 = C21911uL4.j;
        AbstractC22322v24.b bVar = AbstractC22322v24.b.b;
        AS0 as0 = new AS0(c6432No4, new InterfaceC15947kS0[]{bVar, new AbstractC23735xQ7.a(1)}, (UA2) null, 4, (ED1) null);
        AS0 as02 = new AS0(C21911uL4.k, new InterfaceC15947kS0[]{bVar, new AbstractC23735xQ7.a(2)}, a.e);
        C6432No4 c6432No42 = C21911uL4.b;
        CA4 ca4 = CA4.a;
        AbstractC23735xQ7.a aVar = new AbstractC23735xQ7.a(2);
        C4450Fe3 c4450Fe3 = C4450Fe3.a;
        AS0 as03 = new AS0(c6432No42, new InterfaceC15947kS0[]{bVar, ca4, aVar, c4450Fe3}, (UA2) null, 4, (ED1) null);
        AS0 as04 = new AS0(C21911uL4.c, new InterfaceC15947kS0[]{bVar, ca4, new AbstractC23735xQ7.a(3), c4450Fe3}, (UA2) null, 4, (ED1) null);
        AS0 as05 = new AS0(C21911uL4.d, new InterfaceC15947kS0[]{bVar, ca4, new AbstractC23735xQ7.b(2), c4450Fe3}, (UA2) null, 4, (ED1) null);
        AS0 as06 = new AS0(C21911uL4.h, new InterfaceC15947kS0[]{bVar}, (UA2) null, 4, (ED1) null);
        C6432No4 c6432No43 = C21911uL4.g;
        AbstractC23735xQ7.d dVar = AbstractC23735xQ7.d.b;
        AbstractC23500x16.a aVar2 = AbstractC23500x16.a.d;
        AS0 as07 = new AS0(c6432No43, new InterfaceC15947kS0[]{bVar, dVar, ca4, aVar2}, (UA2) null, 4, (ED1) null);
        C6432No4 c6432No44 = C21911uL4.i;
        AbstractC23735xQ7.c cVar = AbstractC23735xQ7.c.b;
        b = AbstractC10360bX0.p(as0, as02, as03, as04, as05, as06, as07, new AS0(c6432No44, new InterfaceC15947kS0[]{bVar, cVar}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.l, new InterfaceC15947kS0[]{bVar, cVar}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.m, new InterfaceC15947kS0[]{bVar, cVar, aVar2}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.C, new InterfaceC15947kS0[]{bVar, dVar, ca4}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.e, new InterfaceC15947kS0[]{AbstractC22322v24.a.b}, b.e), new AS0(C21911uL4.f, new InterfaceC15947kS0[]{bVar, AbstractC23500x16.b.d, dVar, ca4}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.L, new InterfaceC15947kS0[]{bVar, dVar, ca4}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.K, new InterfaceC15947kS0[]{bVar, cVar}, (UA2) null, 4, (ED1) null), new AS0(AbstractC10360bX0.p(C21911uL4.r, C21911uL4.s), new InterfaceC15947kS0[]{bVar}, c.e), new AS0(C21911uL4.M, new InterfaceC15947kS0[]{bVar, AbstractC23500x16.c.d, dVar, ca4}, (UA2) null, 4, (ED1) null), new AS0(C21911uL4.o, new InterfaceC15947kS0[]{bVar, cVar}, (UA2) null, 4, (ED1) null));
    }

    private C21237tL4() {
    }

    @Override // ir.nasim.AbstractC18058o1
    public List b() {
        return b;
    }
}
