package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.G;
import ir.nasim.C14819iX7;
import ir.nasim.VW7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class t extends VW7 {
    private static final G.c i = new a();
    private final boolean e;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    class a implements G.c {
        a() {
        }

        @Override // androidx.lifecycle.G.c
        public VW7 b(Class cls) {
            return new t(true);
        }
    }

    t(boolean z) {
        this.e = z;
    }

    private void T0(String str, boolean z) {
        t tVar = (t) this.c.get(str);
        if (tVar != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(tVar.c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    tVar.S0((String) it.next(), true);
                }
            }
            tVar.L0();
            this.c.remove(str);
        }
        C14819iX7 c14819iX7 = (C14819iX7) this.d.get(str);
        if (c14819iX7 != null) {
            c14819iX7.a();
            this.d.remove(str);
        }
    }

    static t W0(C14819iX7 c14819iX7) {
        return (t) new androidx.lifecycle.G(c14819iX7, i).b(t.class);
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    void P0(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.containsKey(fragment.f)) {
                return;
            }
            this.b.put(fragment.f, fragment);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void R0(Fragment fragment, boolean z) {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        T0(fragment.f, z);
    }

    void S0(String str, boolean z) {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        T0(str, z);
    }

    Fragment U0(String str) {
        return (Fragment) this.b.get(str);
    }

    t V0(Fragment fragment) {
        t tVar = (t) this.c.get(fragment.f);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(this.e);
        this.c.put(fragment.f, tVar2);
        return tVar2;
    }

    Collection X0() {
        return new ArrayList(this.b.values());
    }

    C14819iX7 Y0(Fragment fragment) {
        C14819iX7 c14819iX7 = (C14819iX7) this.d.get(fragment.f);
        if (c14819iX7 != null) {
            return c14819iX7;
        }
        C14819iX7 c14819iX72 = new C14819iX7();
        this.d.put(fragment.f, c14819iX72);
        return c14819iX72;
    }

    boolean Z0() {
        return this.f;
    }

    void a1(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.remove(fragment.f) == null || !FragmentManager.Q0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void b1(boolean z) {
        this.h = z;
    }

    boolean c1(Fragment fragment) {
        if (this.b.containsKey(fragment.f)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.b.equals(tVar.b) && this.c.equals(tVar.c) && this.d.equals(tVar.d);
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
