package ir.nasim;

import ir.nasim.C12637ew7;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.a55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C9514a55 extends AbstractC13903h1 implements Map, InterfaceC17915nm3 {
    public static final a d = new a(null);
    public static final int e = 8;
    private static final C9514a55 f = new C9514a55(C12637ew7.e.a(), 0);
    private final C12637ew7 b;
    private final int c;

    /* renamed from: ir.nasim.a55$a */
    public static final class a {
        private a() {
        }

        public final C9514a55 a() {
            C9514a55 c9514a55 = C9514a55.f;
            AbstractC13042fc3.g(c9514a55, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return c9514a55;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C9514a55(C12637ew7 c12637ew7, int i) {
        this.b = c12637ew7;
        this.c = i;
    }

    private final InterfaceC15137j43 l() {
        return new C15740k55(this);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.b.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // ir.nasim.AbstractC13903h1
    public final Set e() {
        return l();
    }

    @Override // ir.nasim.AbstractC13903h1
    public int g() {
        return this.c;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.b.o(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // ir.nasim.AbstractC13903h1
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public InterfaceC15137j43 f() {
        return new C16922m55(this);
    }

    public final C12637ew7 o() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC13903h1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public InterfaceC9502a43 h() {
        return new C18104o55(this);
    }

    public C9514a55 q(Object obj, Object obj2) {
        C12637ew7.b bVarP = this.b.P(obj != null ? obj.hashCode() : 0, obj, obj2, 0);
        return bVarP == null ? this : new C9514a55(bVarP.a(), size() + bVarP.b());
    }

    public C9514a55 s(Object obj) {
        C12637ew7 c12637ew7Q = this.b.Q(obj != null ? obj.hashCode() : 0, obj, 0);
        return this.b == c12637ew7Q ? this : c12637ew7Q == null ? d.a() : new C9514a55(c12637ew7Q, size() - 1);
    }
}
