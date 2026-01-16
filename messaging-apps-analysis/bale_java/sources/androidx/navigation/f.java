package androidx.navigation;

import androidx.lifecycle.G;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C14819iX7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12574eq4;
import ir.nasim.VW7;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends VW7 implements InterfaceC12574eq4 {
    public static final b c = new b(null);
    private static final G.c d = new a();
    private final Map b = new LinkedHashMap();

    public static final class a implements G.c {
        a() {
        }

        @Override // androidx.lifecycle.G.c
        public VW7 b(Class cls) {
            AbstractC13042fc3.i(cls, "modelClass");
            return new f();
        }
    }

    public static final class b {
        private b() {
        }

        public final f a(C14819iX7 c14819iX7) {
            AbstractC13042fc3.i(c14819iX7, "viewModelStore");
            return (f) new G(c14819iX7, f.d, null, 4, null).b(f.class);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.InterfaceC12574eq4
    public C14819iX7 F(String str) {
        AbstractC13042fc3.i(str, "backStackEntryId");
        C14819iX7 c14819iX7 = (C14819iX7) this.b.get(str);
        if (c14819iX7 != null) {
            return c14819iX7;
        }
        C14819iX7 c14819iX72 = new C14819iX7();
        this.b.put(str, c14819iX72);
        return c14819iX72;
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            ((C14819iX7) it.next()).a();
        }
        this.b.clear();
    }

    public final void R0(String str) {
        AbstractC13042fc3.i(str, "backStackEntryId");
        C14819iX7 c14819iX7 = (C14819iX7) this.b.remove(str);
        if (c14819iX7 != null) {
            c14819iX7.a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }
}
