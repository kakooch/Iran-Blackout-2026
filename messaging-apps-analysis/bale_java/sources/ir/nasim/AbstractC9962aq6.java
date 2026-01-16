package ir.nasim;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.aq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9962aq6 extends AbstractC9365Zp6 {

    /* renamed from: ir.nasim.aq6$a */
    public static final class a implements InterfaceC23384wp6 {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.aq6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(InterfaceC23384wp6 interfaceC23384wp6) {
            AbstractC13042fc3.i(interfaceC23384wp6, "it");
            return interfaceC23384wp6.iterator();
        }
    }

    /* renamed from: ir.nasim.aq6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SA2 sa2) {
            super(1);
            this.e = sa2;
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            AbstractC13042fc3.i(obj, "it");
            return this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.aq6$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Object obj) {
            super(0);
            this.e = obj;
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            return this.e;
        }
    }

    public static InterfaceC23384wp6 c(Iterator it) {
        AbstractC13042fc3.i(it, "<this>");
        return d(new a(it));
    }

    public static InterfaceC23384wp6 d(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return interfaceC23384wp6 instanceof C8009Ud1 ? interfaceC23384wp6 : new C8009Ud1(interfaceC23384wp6);
    }

    public static InterfaceC23384wp6 e() {
        return F72.a;
    }

    public static final InterfaceC23384wp6 f(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return g(interfaceC23384wp6, b.e);
    }

    private static final InterfaceC23384wp6 g(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        return interfaceC23384wp6 instanceof C20391rv7 ? ((C20391rv7) interfaceC23384wp6).e(ua2) : new C5967Lp2(interfaceC23384wp6, c.e, ua2);
    }

    public static InterfaceC23384wp6 h(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "nextFunction");
        return d(new PE2(sa2, new d(sa2)));
    }

    public static InterfaceC23384wp6 i(SA2 sa2, UA2 ua2) {
        AbstractC13042fc3.i(sa2, "seedFunction");
        AbstractC13042fc3.i(ua2, "nextFunction");
        return new PE2(sa2, ua2);
    }

    public static InterfaceC23384wp6 j(Object obj, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "nextFunction");
        return obj == null ? F72.a : new PE2(new e(obj), ua2);
    }

    public static InterfaceC23384wp6 k(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return AbstractC10242bK.P(objArr);
    }

    /* renamed from: ir.nasim.aq6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
