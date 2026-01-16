package ir.nasim;

import ir.nasim.AbstractC12095e2;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.u1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21717u1 {
    public static final C21717u1 a = new C21717u1();

    private C21717u1() {
    }

    private final boolean c(AbstractC12095e2 abstractC12095e2, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        if (abstractC12095e2.B0(zc6)) {
            return true;
        }
        if (abstractC12095e2.U(zc6)) {
            return false;
        }
        if (abstractC12095e2.C0() && abstractC12095e2.B(zc6)) {
            return true;
        }
        return abstractC12095e2.l(abstractC12095e2.d(zc6), interfaceC14475hy7);
    }

    private final boolean e(AbstractC12095e2 abstractC12095e2, ZC6 zc6, ZC6 zc62) {
        if (C11452d2.b) {
            if (!abstractC12095e2.F(zc6) && !abstractC12095e2.h(abstractC12095e2.d(zc6))) {
                abstractC12095e2.v0(zc6);
            }
            if (!abstractC12095e2.F(zc62)) {
                abstractC12095e2.v0(zc62);
            }
        }
        if (abstractC12095e2.U(zc62) || abstractC12095e2.x0(zc6)) {
            return true;
        }
        if (((zc6 instanceof InterfaceC19385qG0) && abstractC12095e2.f0((InterfaceC19385qG0) zc6)) || a(abstractC12095e2, zc6, AbstractC12095e2.b.C1044b.a)) {
            return true;
        }
        if (abstractC12095e2.x0(zc62) || a(abstractC12095e2, zc62, AbstractC12095e2.b.d.a) || abstractC12095e2.w0(zc6)) {
            return false;
        }
        return b(abstractC12095e2, zc6, abstractC12095e2.d(zc62));
    }

    public final boolean a(AbstractC12095e2 abstractC12095e2, ZC6 zc6, AbstractC12095e2.b bVar) {
        AbstractC13042fc3.i(abstractC12095e2, "<this>");
        AbstractC13042fc3.i(zc6, "type");
        AbstractC13042fc3.i(bVar, "supertypesPolicy");
        if ((abstractC12095e2.w0(zc6) && !abstractC12095e2.U(zc6)) || abstractC12095e2.x0(zc6)) {
            return true;
        }
        abstractC12095e2.u0();
        ArrayDeque arrayDequeR0 = abstractC12095e2.r0();
        AbstractC13042fc3.f(arrayDequeR0);
        Set setS0 = abstractC12095e2.s0();
        AbstractC13042fc3.f(setS0);
        arrayDequeR0.push(zc6);
        while (!arrayDequeR0.isEmpty()) {
            if (setS0.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + zc6 + ". Supertypes = " + AbstractC15401jX0.A0(setS0, null, null, null, 0, null, null, 63, null)).toString());
            }
            ZC6 zc62 = (ZC6) arrayDequeR0.pop();
            AbstractC13042fc3.h(zc62, "current");
            if (setS0.add(zc62)) {
                AbstractC12095e2.b bVar2 = abstractC12095e2.U(zc62) ? AbstractC12095e2.b.c.a : bVar;
                if (!(!AbstractC13042fc3.d(bVar2, AbstractC12095e2.b.c.a))) {
                    bVar2 = null;
                }
                if (bVar2 == null) {
                    continue;
                } else {
                    Iterator it = abstractC12095e2.M(abstractC12095e2.d(zc62)).iterator();
                    while (it.hasNext()) {
                        ZC6 zc6A = bVar2.a(abstractC12095e2, (InterfaceC5050Hr3) it.next());
                        if ((abstractC12095e2.w0(zc6A) && !abstractC12095e2.U(zc6A)) || abstractC12095e2.x0(zc6A)) {
                            abstractC12095e2.m0();
                            return true;
                        }
                        arrayDequeR0.add(zc6A);
                    }
                }
            }
        }
        abstractC12095e2.m0();
        return false;
    }

    public final boolean b(AbstractC12095e2 abstractC12095e2, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        AbstractC13042fc3.i(abstractC12095e2, "<this>");
        AbstractC13042fc3.i(zc6, "start");
        AbstractC13042fc3.i(interfaceC14475hy7, "end");
        if (c(abstractC12095e2, zc6, interfaceC14475hy7)) {
            return true;
        }
        abstractC12095e2.u0();
        ArrayDeque arrayDequeR0 = abstractC12095e2.r0();
        AbstractC13042fc3.f(arrayDequeR0);
        Set setS0 = abstractC12095e2.s0();
        AbstractC13042fc3.f(setS0);
        arrayDequeR0.push(zc6);
        while (!arrayDequeR0.isEmpty()) {
            if (setS0.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + zc6 + ". Supertypes = " + AbstractC15401jX0.A0(setS0, null, null, null, 0, null, null, 63, null)).toString());
            }
            ZC6 zc62 = (ZC6) arrayDequeR0.pop();
            AbstractC13042fc3.h(zc62, "current");
            if (setS0.add(zc62)) {
                AbstractC12095e2.b bVar = abstractC12095e2.U(zc62) ? AbstractC12095e2.b.c.a : AbstractC12095e2.b.C1044b.a;
                if (!(!AbstractC13042fc3.d(bVar, AbstractC12095e2.b.c.a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator it = abstractC12095e2.M(abstractC12095e2.d(zc62)).iterator();
                    while (it.hasNext()) {
                        ZC6 zc6A = bVar.a(abstractC12095e2, (InterfaceC5050Hr3) it.next());
                        if (c(abstractC12095e2, zc6A, interfaceC14475hy7)) {
                            abstractC12095e2.m0();
                            return true;
                        }
                        arrayDequeR0.add(zc6A);
                    }
                }
            }
        }
        abstractC12095e2.m0();
        return false;
    }

    public final boolean d(AbstractC12095e2 abstractC12095e2, ZC6 zc6, ZC6 zc62) {
        AbstractC13042fc3.i(abstractC12095e2, "context");
        AbstractC13042fc3.i(zc6, "subType");
        AbstractC13042fc3.i(zc62, "superType");
        return e(abstractC12095e2, zc6, zc62);
    }
}
