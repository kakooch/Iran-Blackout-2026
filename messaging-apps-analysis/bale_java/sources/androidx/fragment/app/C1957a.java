package androidx.fragment.app;

import android.gov.nist.core.Separators;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import androidx.lifecycle.j;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1957a extends x implements FragmentManager.o {
    final FragmentManager t;
    boolean u;
    int v;
    boolean w;

    C1957a(FragmentManager fragmentManager) {
        super(fragmentManager.B0(), fragmentManager.D0() != null ? fragmentManager.D0().k().getClassLoader() : null);
        this.v = -1;
        this.w = false;
        this.t = fragmentManager;
    }

    int A(boolean z, boolean z2) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C("FragmentManager"));
            B("  ", printWriter);
            printWriter.close();
        }
        this.u = true;
        if (this.i) {
            this.v = this.t.p();
        } else {
            this.v = -1;
        }
        if (z2) {
            this.t.f0(this, z);
        }
        return this.v;
    }

    public void B(String str, PrintWriter printWriter) {
        C(str, printWriter, true);
    }

    public void C(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.u);
            if (this.h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.h));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (this.c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            x.a aVar = (x.a) this.c.get(i);
            switch (aVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(Separators.SP);
            printWriter.println(aVar.b);
            if (z) {
                if (aVar.d != 0 || aVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.e));
                }
                if (aVar.f != 0 || aVar.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.g));
                }
            }
        }
    }

    void D() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            x.a aVar = (x.a) this.c.get(i);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.o = this.w;
                fragment.g8(false);
                fragment.f8(this.h);
                fragment.j8(this.p, this.q);
            }
            switch (aVar.a) {
                case 1:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, false);
                    this.t.l(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.u1(fragment);
                    break;
                case 4:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.N0(fragment);
                    break;
                case 5:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, false);
                    this.t.L1(fragment);
                    break;
                case 6:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.D(fragment);
                    break;
                case 7:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, false);
                    this.t.r(fragment);
                    break;
                case 8:
                    this.t.J1(fragment);
                    break;
                case 9:
                    this.t.J1(null);
                    break;
                case 10:
                    this.t.I1(fragment, aVar.i);
                    break;
            }
        }
    }

    void E() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            x.a aVar = (x.a) this.c.get(size);
            Fragment fragment = aVar.b;
            if (fragment != null) {
                fragment.o = this.w;
                fragment.g8(true);
                fragment.f8(FragmentManager.B1(this.h));
                fragment.j8(this.q, this.p);
            }
            switch (aVar.a) {
                case 1:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, true);
                    this.t.u1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.a);
                case 3:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.l(fragment);
                    break;
                case 4:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.L1(fragment);
                    break;
                case 5:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, true);
                    this.t.N0(fragment);
                    break;
                case 6:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.r(fragment);
                    break;
                case 7:
                    fragment.Z7(aVar.d, aVar.e, aVar.f, aVar.g);
                    this.t.F1(fragment, true);
                    this.t.D(fragment);
                    break;
                case 8:
                    this.t.J1(null);
                    break;
                case 9:
                    this.t.J1(fragment);
                    break;
                case 10:
                    this.t.I1(fragment, aVar.h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment F(java.util.ArrayList r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList r5 = r0.c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList r5 = r0.c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.x$a r5 = (androidx.fragment.app.x.a) r5
            int r6 = r5.a
            r7 = 1
            if (r6 == r7) goto Lb6
            r8 = 2
            r9 = 0
            r10 = 3
            r11 = 9
            if (r6 == r8) goto L5a
            if (r6 == r10) goto L43
            r8 = 6
            if (r6 == r8) goto L43
            r8 = 7
            if (r6 == r8) goto Lb6
            r8 = 8
            if (r6 == r8) goto L31
            goto Lbb
        L31:
            java.util.ArrayList r6 = r0.c
            androidx.fragment.app.x$a r8 = new androidx.fragment.app.x$a
            r8.<init>(r11, r3, r7)
            r6.add(r4, r8)
            r5.c = r7
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.b
            if (r5 != r3) goto Lbb
            java.util.ArrayList r3 = r0.c
            androidx.fragment.app.x$a r6 = new androidx.fragment.app.x$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r9
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.b
            int r8 = r6.A
            int r12 = r17.size()
            int r12 = r12 - r7
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.A
            if (r15 != r8) goto La1
            if (r14 != r6) goto L74
            r13 = r7
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList r3 = r0.c
            androidx.fragment.app.x$a r15 = new androidx.fragment.app.x$a
            r15.<init>(r11, r14, r7)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r9
        L83:
            androidx.fragment.app.x$a r15 = new androidx.fragment.app.x$a
            r15.<init>(r10, r14, r7)
            int r2 = r5.d
            r15.d = r2
            int r2 = r5.f
            r15.f = r2
            int r2 = r5.e
            r15.e = r2
            int r2 = r5.g
            r15.g = r2
            java.util.ArrayList r2 = r0.c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r7
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList r2 = r0.c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.a = r7
            r5.c = r7
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r7
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C1957a.F(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String G() {
        return this.k;
    }

    public void H() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                ((Runnable) this.s.get(i)).run();
            }
            this.s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment I(java.util.ArrayList r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList r2 = r5.c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.x$a r2 = (androidx.fragment.app.x.a) r2
            int r3 = r2.a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.j$b r3 = r2.h
            r2.i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C1957a.I(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.o
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.t.k(this);
        return true;
    }

    @Override // androidx.fragment.app.x
    public int h() {
        return A(false, true);
    }

    @Override // androidx.fragment.app.x
    public int i() {
        return A(true, true);
    }

    @Override // androidx.fragment.app.x
    public void j() {
        l();
        this.t.i0(this, false);
    }

    @Override // androidx.fragment.app.x
    public void k() {
        l();
        this.t.i0(this, true);
    }

    @Override // androidx.fragment.app.x
    void m(int i, Fragment fragment, String str, int i2) {
        super.m(i, fragment, str, i2);
        fragment.v = this.t;
    }

    @Override // androidx.fragment.app.x
    public x n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.v;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.x
    public boolean o() {
        return this.c.isEmpty();
    }

    @Override // androidx.fragment.app.x
    public x p(Fragment fragment) {
        FragmentManager fragmentManager = fragment.v;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.p(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(Separators.SP);
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.x
    public x u(Fragment fragment, j.b bVar) {
        if (fragment.v != this.t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.t);
        }
        if (bVar == j.b.INITIALIZED && fragment.a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + " after the Fragment has been created");
        }
        if (bVar != j.b.DESTROYED) {
            return super.u(fragment, bVar);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + bVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.x
    public x x(Fragment fragment) {
        FragmentManager fragmentManager = fragment.v;
        if (fragmentManager == null || fragmentManager == this.t) {
            return super.x(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    void y(int i) {
        if (this.i) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                x.a aVar = (x.a) this.c.get(i2);
                Fragment fragment = aVar.b;
                if (fragment != null) {
                    fragment.u += i;
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.b + " to " + aVar.b.u);
                    }
                }
            }
        }
    }

    void z() {
        int size = this.c.size() - 1;
        while (size >= 0) {
            x.a aVar = (x.a) this.c.get(size);
            if (aVar.c) {
                if (aVar.a == 8) {
                    aVar.c = false;
                    this.c.remove(size - 1);
                    size--;
                } else {
                    int i = aVar.b.A;
                    aVar.a = 2;
                    aVar.c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        x.a aVar2 = (x.a) this.c.get(i2);
                        if (aVar2.c && aVar2.b.A == i) {
                            this.c.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }
}
