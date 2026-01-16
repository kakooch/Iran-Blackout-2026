package ir.nasim;

import ir.nasim.InterfaceC22753vm1;

/* renamed from: ir.nasim.do1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC11938do1 {

    /* renamed from: ir.nasim.do1$a */
    public static final class a {

        /* renamed from: ir.nasim.do1$a$a, reason: collision with other inner class name */
        static final class C1031a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final C1031a e = new C1031a();

            C1031a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC11938do1 invoke(InterfaceC11938do1 interfaceC11938do1, b bVar) {
                C11758dZ0 c11758dZ0;
                AbstractC13042fc3.i(interfaceC11938do1, "acc");
                AbstractC13042fc3.i(bVar, "element");
                InterfaceC11938do1 interfaceC11938do1L = interfaceC11938do1.l(bVar.getKey());
                C18712p72 c18712p72 = C18712p72.a;
                if (interfaceC11938do1L == c18712p72) {
                    return bVar;
                }
                InterfaceC22753vm1.b bVar2 = InterfaceC22753vm1.g0;
                InterfaceC22753vm1 interfaceC22753vm1 = (InterfaceC22753vm1) interfaceC11938do1L.a(bVar2);
                if (interfaceC22753vm1 == null) {
                    c11758dZ0 = new C11758dZ0(interfaceC11938do1L, bVar);
                } else {
                    InterfaceC11938do1 interfaceC11938do1L2 = interfaceC11938do1L.l(bVar2);
                    if (interfaceC11938do1L2 == c18712p72) {
                        return new C11758dZ0(bVar, interfaceC22753vm1);
                    }
                    c11758dZ0 = new C11758dZ0(new C11758dZ0(interfaceC11938do1L2, bVar), interfaceC22753vm1);
                }
                return c11758dZ0;
            }
        }

        public static InterfaceC11938do1 a(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12) {
            AbstractC13042fc3.i(interfaceC11938do12, "context");
            return interfaceC11938do12 == C18712p72.a ? interfaceC11938do1 : (InterfaceC11938do1) interfaceC11938do12.f0(interfaceC11938do1, C1031a.e);
        }
    }

    /* renamed from: ir.nasim.do1$b */
    public interface b extends InterfaceC11938do1 {

        /* renamed from: ir.nasim.do1$b$a */
        public static final class a {
            public static Object a(b bVar, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
                AbstractC13042fc3.i(interfaceC14603iB2, "operation");
                return interfaceC14603iB2.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                AbstractC13042fc3.i(cVar, "key");
                if (!AbstractC13042fc3.d(bVar.getKey(), cVar)) {
                    return null;
                }
                AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static InterfaceC11938do1 c(b bVar, c cVar) {
                AbstractC13042fc3.i(cVar, "key");
                return AbstractC13042fc3.d(bVar.getKey(), cVar) ? C18712p72.a : bVar;
            }

            public static InterfaceC11938do1 d(b bVar, InterfaceC11938do1 interfaceC11938do1) {
                AbstractC13042fc3.i(interfaceC11938do1, "context");
                return a.a(bVar, interfaceC11938do1);
            }
        }

        @Override // ir.nasim.InterfaceC11938do1
        b a(c cVar);

        c getKey();
    }

    /* renamed from: ir.nasim.do1$c */
    public interface c {
    }

    InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1);

    b a(c cVar);

    Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2);

    InterfaceC11938do1 l(c cVar);
}
