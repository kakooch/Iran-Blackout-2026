package ir.nasim;

import ir.nasim.C17847nf5;
import ir.nasim.C22179un7;
import ir.nasim.C4171Dz3;
import java.util.List;

/* renamed from: ir.nasim.Zb6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9239Zb6 {
    private static final InterfaceC8230Vb6 a = AbstractC8464Wb6.a(c.e, d.e);
    private static final InterfaceC8230Vb6 b = AbstractC8464Wb6.a(a.e, b.e);
    private static final InterfaceC8230Vb6 c = AbstractC8464Wb6.a(e.e, f.e);

    /* renamed from: ir.nasim.Zb6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final Object a(InterfaceC8730Xb6 interfaceC8730Xb6, int i) {
            return Integer.valueOf(i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC8730Xb6) obj, ((C4171Dz3) obj2).l());
        }
    }

    /* renamed from: ir.nasim.Zb6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4171Dz3 invoke(Object obj) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Int");
            return C4171Dz3.c(C4171Dz3.d(((Integer) obj).intValue()));
        }
    }

    /* renamed from: ir.nasim.Zb6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C17847nf5 c17847nf5) {
            return AbstractC10360bX0.g(AbstractC8984Yb6.y(Boolean.valueOf(c17847nf5.c())), AbstractC8984Yb6.y(C24136y62.d(c17847nf5.b())));
        }
    }

    /* renamed from: ir.nasim.Zb6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C17847nf5 invoke(Object obj) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Boolean bool = obj2 != null ? (Boolean) obj2 : null;
            AbstractC13042fc3.f(bool);
            boolean zBooleanValue = bool.booleanValue();
            Object obj3 = list.get(1);
            C24136y62 c24136y62 = obj3 != null ? (C24136y62) obj3 : null;
            AbstractC13042fc3.f(c24136y62);
            return new C17847nf5(c24136y62.j(), zBooleanValue, null);
        }
    }

    /* renamed from: ir.nasim.Zb6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C22179un7 c22179un7) {
            return AbstractC10360bX0.g(AbstractC8984Yb6.y(C22179un7.b.d(c22179un7.b())), AbstractC8984Yb6.y(Boolean.valueOf(c22179un7.c())));
        }
    }

    /* renamed from: ir.nasim.Zb6$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C22179un7 invoke(Object obj) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            C22179un7.b bVar = obj2 != null ? (C22179un7.b) obj2 : null;
            AbstractC13042fc3.f(bVar);
            int iJ = bVar.j();
            Object obj3 = list.get(1);
            Boolean bool = obj3 != null ? (Boolean) obj3 : null;
            AbstractC13042fc3.f(bool);
            return new C22179un7(iJ, bool.booleanValue(), null);
        }
    }

    public static final InterfaceC8230Vb6 a(C4171Dz3.a aVar) {
        return b;
    }

    public static final InterfaceC8230Vb6 b(C17847nf5.a aVar) {
        return a;
    }

    public static final InterfaceC8230Vb6 c(C22179un7.a aVar) {
        return c;
    }
}
