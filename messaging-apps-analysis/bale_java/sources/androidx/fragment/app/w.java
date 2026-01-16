package androidx.fragment.app;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class w {
    private final ArrayList a = new ArrayList();
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private t d;

    w() {
    }

    void A(t tVar) {
        this.d = tVar;
    }

    Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.c.put(str, bundle) : (Bundle) this.c.remove(str);
    }

    void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.l = true;
    }

    void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    boolean c(String str) {
        return this.b.get(str) != null;
    }

    void d(int i) {
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                uVar.t(i);
            }
        }
    }

    void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (u uVar : this.b.values()) {
                printWriter.print(str);
                if (uVar != null) {
                    Fragment fragmentK = uVar.k();
                    printWriter.println(fragmentK);
                    fragmentK.w5(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    Fragment f(String str) {
        u uVar = (u) this.b.get(str);
        if (uVar != null) {
            return uVar.k();
        }
        return null;
    }

    Fragment g(int i) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.a.get(size);
            if (fragment != null && fragment.z == i) {
                return fragment;
            }
        }
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                Fragment fragmentK = uVar.k();
                if (fragmentK.z == i) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment h(String str) {
        if (str != null) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.a.get(size);
                if (fragment != null && str.equals(fragment.B)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                Fragment fragmentK = uVar.k();
                if (str.equals(fragmentK.B)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    Fragment i(String str) {
        Fragment fragmentY5;
        for (u uVar : this.b.values()) {
            if (uVar != null && (fragmentY5 = uVar.k().y5(str)) != null) {
                return fragmentY5;
            }
        }
        return null;
    }

    int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.A0;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.a.indexOf(fragment);
        for (int i = iIndexOf - 1; i >= 0; i--) {
            Fragment fragment2 = (Fragment) this.a.get(i);
            if (fragment2.A0 == viewGroup && (view2 = fragment2.B0) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.a.get(iIndexOf);
            if (fragment3.A0 == viewGroup && (view = fragment3.B0) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    List k() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    List l() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                arrayList.add(uVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    HashMap m() {
        return this.c;
    }

    u n(String str) {
        return (u) this.b.get(str);
    }

    List o() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    t p() {
        return this.d;
    }

    Bundle q(String str) {
        return (Bundle) this.c.get(str);
    }

    void r(u uVar) {
        Fragment fragmentK = uVar.k();
        if (c(fragmentK.f)) {
            return;
        }
        this.b.put(fragmentK.f, uVar);
        if (fragmentK.J) {
            if (fragmentK.H) {
                this.d.P0(fragmentK);
            } else {
                this.d.a1(fragmentK);
            }
            fragmentK.J = false;
        }
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    void s(u uVar) {
        Fragment fragmentK = uVar.k();
        if (fragmentK.H) {
            this.d.a1(fragmentK);
        }
        if (this.b.get(fragmentK.f) == uVar && ((u) this.b.put(fragmentK.f, null)) != null && FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    void t() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            u uVar = (u) this.b.get(((Fragment) it.next()).f);
            if (uVar != null) {
                uVar.m();
            }
        }
        for (u uVar2 : this.b.values()) {
            if (uVar2 != null) {
                uVar2.m();
                Fragment fragmentK = uVar2.k();
                if (fragmentK.m && !fragmentK.x6()) {
                    if (fragmentK.o && !this.c.containsKey(fragmentK.f)) {
                        B(fragmentK.f, uVar2.r());
                    }
                    s(uVar2);
                }
            }
        }
    }

    void u(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.l = false;
    }

    void v() {
        this.b.clear();
    }

    void w(List list) {
        this.a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + Separators.RPAREN);
                }
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    void x(HashMap map) {
        this.c.clear();
        this.c.putAll(map);
    }

    ArrayList y() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                Fragment fragmentK = uVar.k();
                B(fragmentK.f, uVar.r());
                arrayList.add(fragmentK.f);
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.b);
                }
            }
        }
        return arrayList;
    }

    ArrayList z() {
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.a.size());
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.f);
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.f + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
