package ir.nasim;

import ir.nasim.C12637ew7;
import ir.nasim.Y45;

/* loaded from: classes.dex */
public final class X45 extends C9514a55 implements Y45 {
    public static final b g = new b(null);
    private static final X45 h;

    public static final class a extends AbstractC10724c55 implements Y45.a {
        private X45 g;

        public a(X45 x45) {
            super(x45);
            this.g = x45;
        }

        @Override // ir.nasim.AbstractC10724c55, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof AbstractC8979Yb1) {
                return p((AbstractC8979Yb1) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof InterfaceC18300oQ7) {
                return q((InterfaceC18300oQ7) obj);
            }
            return false;
        }

        @Override // ir.nasim.AbstractC10724c55, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof AbstractC8979Yb1) {
                return s((AbstractC8979Yb1) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof AbstractC8979Yb1) ? obj2 : t((AbstractC8979Yb1) obj, (InterfaceC18300oQ7) obj2);
        }

        @Override // ir.nasim.AbstractC10724c55
        /* renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public X45 f() {
            X45 x45;
            if (h() == this.g.o()) {
                x45 = this.g;
            } else {
                l(new C10537bm4());
                x45 = new X45(h(), size());
            }
            this.g = x45;
            return x45;
        }

        public /* bridge */ boolean p(AbstractC8979Yb1 abstractC8979Yb1) {
            return super.containsKey(abstractC8979Yb1);
        }

        public /* bridge */ boolean q(InterfaceC18300oQ7 interfaceC18300oQ7) {
            return super.containsValue(interfaceC18300oQ7);
        }

        @Override // ir.nasim.AbstractC10724c55, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof AbstractC8979Yb1) {
                return u((AbstractC8979Yb1) obj);
            }
            return null;
        }

        public /* bridge */ InterfaceC18300oQ7 s(AbstractC8979Yb1 abstractC8979Yb1) {
            return (InterfaceC18300oQ7) super.get(abstractC8979Yb1);
        }

        public /* bridge */ InterfaceC18300oQ7 t(AbstractC8979Yb1 abstractC8979Yb1, InterfaceC18300oQ7 interfaceC18300oQ7) {
            return (InterfaceC18300oQ7) super.getOrDefault(abstractC8979Yb1, interfaceC18300oQ7);
        }

        public /* bridge */ InterfaceC18300oQ7 u(AbstractC8979Yb1 abstractC8979Yb1) {
            return (InterfaceC18300oQ7) super.remove(abstractC8979Yb1);
        }
    }

    public static final class b {
        private b() {
        }

        public final X45 a() {
            return X45.h;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static {
        C12637ew7 c12637ew7A = C12637ew7.e.a();
        AbstractC13042fc3.g(c12637ew7A, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        h = new X45(c12637ew7A, 0);
    }

    public X45(C12637ew7 c12637ew7, int i) {
        super(c12637ew7, i);
    }

    public /* bridge */ InterfaceC18300oQ7 A(AbstractC8979Yb1 abstractC8979Yb1, InterfaceC18300oQ7 interfaceC18300oQ7) {
        return (InterfaceC18300oQ7) super.getOrDefault(abstractC8979Yb1, interfaceC18300oQ7);
    }

    @Override // ir.nasim.InterfaceC11819dc1
    public Object b(AbstractC8979Yb1 abstractC8979Yb1) {
        return AbstractC12431ec1.b(this, abstractC8979Yb1);
    }

    @Override // ir.nasim.C9514a55, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof AbstractC8979Yb1) {
            return v((AbstractC8979Yb1) obj);
        }
        return false;
    }

    @Override // ir.nasim.AbstractC13903h1, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof InterfaceC18300oQ7) {
            return x((InterfaceC18300oQ7) obj);
        }
        return false;
    }

    @Override // ir.nasim.C9514a55, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof AbstractC8979Yb1) {
            return y((AbstractC8979Yb1) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof AbstractC8979Yb1) ? obj2 : A((AbstractC8979Yb1) obj, (InterfaceC18300oQ7) obj2);
    }

    @Override // ir.nasim.Y45
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public a m() {
        return new a(this);
    }

    public /* bridge */ boolean v(AbstractC8979Yb1 abstractC8979Yb1) {
        return super.containsKey(abstractC8979Yb1);
    }

    @Override // ir.nasim.Y45
    public Y45 w(AbstractC8979Yb1 abstractC8979Yb1, InterfaceC18300oQ7 interfaceC18300oQ7) {
        C12637ew7.b bVarP = o().P(abstractC8979Yb1.hashCode(), abstractC8979Yb1, interfaceC18300oQ7, 0);
        return bVarP == null ? this : new X45(bVarP.a(), size() + bVarP.b());
    }

    public /* bridge */ boolean x(InterfaceC18300oQ7 interfaceC18300oQ7) {
        return super.containsValue(interfaceC18300oQ7);
    }

    public /* bridge */ InterfaceC18300oQ7 y(AbstractC8979Yb1 abstractC8979Yb1) {
        return (InterfaceC18300oQ7) super.get(abstractC8979Yb1);
    }
}
