package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.Qo7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7173Qo7 {
    public static final C14539i47 a = new C14539i47("NO_THREAD_ELEMENTS");
    private static final InterfaceC14603iB2 b = a.e;
    private static final InterfaceC14603iB2 c = b.e;
    private static final InterfaceC14603iB2 d = c.e;

    /* renamed from: ir.nasim.Qo7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, InterfaceC11938do1.b bVar) {
            if (!(bVar instanceof InterfaceC6695Oo7)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* renamed from: ir.nasim.Qo7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC6695Oo7 invoke(InterfaceC6695Oo7 interfaceC6695Oo7, InterfaceC11938do1.b bVar) {
            if (interfaceC6695Oo7 != null) {
                return interfaceC6695Oo7;
            }
            if (bVar instanceof InterfaceC6695Oo7) {
                return (InterfaceC6695Oo7) bVar;
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.Qo7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13794gp7 invoke(C13794gp7 c13794gp7, InterfaceC11938do1.b bVar) {
            if (bVar instanceof InterfaceC6695Oo7) {
                InterfaceC6695Oo7 interfaceC6695Oo7 = (InterfaceC6695Oo7) bVar;
                c13794gp7.a(interfaceC6695Oo7, interfaceC6695Oo7.s0(c13794gp7.a));
            }
            return c13794gp7;
        }
    }

    public static final void a(InterfaceC11938do1 interfaceC11938do1, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof C13794gp7) {
            ((C13794gp7) obj).b(interfaceC11938do1);
            return;
        }
        Object objF0 = interfaceC11938do1.f0(null, c);
        AbstractC13042fc3.g(objF0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((InterfaceC6695Oo7) objF0).d0(interfaceC11938do1, obj);
    }

    public static final Object b(InterfaceC11938do1 interfaceC11938do1) {
        Object objF0 = interfaceC11938do1.f0(0, b);
        AbstractC13042fc3.f(objF0);
        return objF0;
    }

    public static final Object c(InterfaceC11938do1 interfaceC11938do1, Object obj) {
        if (obj == null) {
            obj = b(interfaceC11938do1);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return interfaceC11938do1.f0(new C13794gp7(interfaceC11938do1, ((Number) obj).intValue()), d);
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((InterfaceC6695Oo7) obj).s0(interfaceC11938do1);
    }
}
