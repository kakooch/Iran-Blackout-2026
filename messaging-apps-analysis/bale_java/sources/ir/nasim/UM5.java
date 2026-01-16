package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class UM5 implements XM5 {
    private final Set a;
    private final C12544en4 b;
    private C12544en4 c;
    private final C12544en4 d;
    private final C12544en4 e;
    private C7620Sm4 f;
    private C7386Rm4 g;
    private final List h;
    private final C16143km4 i;
    private final C16143km4 j;
    private ArrayList k;

    public UM5(Set set) {
        this.a = set;
        C12544en4 c12544en4 = new C12544en4(new ZM5[16], 0);
        this.b = c12544en4;
        this.c = c12544en4;
        this.d = new C12544en4(new Object[16], 0);
        this.e = new C12544en4(new SA2[16], 0);
        this.h = new ArrayList();
        this.i = new C16143km4(0, 1, null);
        this.j = new C16143km4(0, 1, null);
    }

    private final void i(C12544en4 c12544en4) {
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            YM5 ym5B = ((ZM5) objArr[i]).b();
            this.a.remove(ym5B);
            ym5B.b();
        }
    }

    private final void l(int i) {
        if (!this.h.isEmpty()) {
            int i2 = 0;
            int i3 = 0;
            List listS = null;
            C16143km4 c16143km4 = null;
            C16143km4 c16143km42 = null;
            while (true) {
                C16143km4 c16143km43 = this.j;
                if (i3 >= c16143km43.b) {
                    break;
                }
                if (i <= c16143km43.e(i3)) {
                    Object objRemove = this.h.remove(i3);
                    int iM = this.j.m(i3);
                    int iM2 = this.i.m(i3);
                    if (listS == null) {
                        listS = AbstractC10360bX0.s(objRemove);
                        c16143km42 = new C16143km4(0, 1, null);
                        c16143km42.j(iM);
                        c16143km4 = new C16143km4(0, 1, null);
                        c16143km4.j(iM2);
                    } else {
                        AbstractC13042fc3.g(c16143km4, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        AbstractC13042fc3.g(c16143km42, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        listS.add(objRemove);
                        c16143km42.j(iM);
                        c16143km4.j(iM2);
                    }
                } else {
                    i3++;
                }
            }
            if (listS != null) {
                AbstractC13042fc3.g(c16143km4, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                AbstractC13042fc3.g(c16143km42, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = listS.size() - 1;
                while (i2 < size) {
                    int i4 = i2 + 1;
                    int size2 = listS.size();
                    for (int i5 = i4; i5 < size2; i5++) {
                        int iE = c16143km42.e(i2);
                        int iE2 = c16143km42.e(i5);
                        if (iE < iE2 || (iE2 == iE && c16143km4.e(i2) < c16143km4.e(i5))) {
                            VM5.d(listS, i2, i5);
                            VM5.c(c16143km4, i2, i5);
                            VM5.c(c16143km42, i2, i5);
                        }
                    }
                    i2 = i4;
                }
                C12544en4 c12544en4 = this.d;
                c12544en4.h(c12544en4.o(), listS);
            }
        }
    }

    private final void m(Object obj, int i, int i2, int i3) {
        l(i);
        if (i3 < 0 || i3 >= i) {
            this.d.d(obj);
            return;
        }
        this.h.add(obj);
        this.i.j(i2);
        this.j.j(i3);
    }

    @Override // ir.nasim.XM5
    public void a(PJ5 pj5) {
        C7386Rm4 c7386Rm4 = this.g;
        if (c7386Rm4 != null) {
        }
    }

    @Override // ir.nasim.XM5
    public void b(PJ5 pj5) {
        C7386Rm4 c7386Rm4 = this.g;
        if (c7386Rm4 != null) {
        }
    }

    @Override // ir.nasim.XM5
    public void c(SA2 sa2) {
        this.e.d(sa2);
    }

    @Override // ir.nasim.XM5
    public void d(ZM5 zm5) {
        this.c.d(zm5);
    }

    @Override // ir.nasim.XM5
    public void e(InterfaceC11014cb1 interfaceC11014cb1, int i, int i2, int i3) {
        m(interfaceC11014cb1, i, i2, i3);
    }

    @Override // ir.nasim.XM5
    public void f(InterfaceC11014cb1 interfaceC11014cb1, int i, int i2, int i3) {
        C7620Sm4 c7620Sm4A = this.f;
        if (c7620Sm4A == null) {
            c7620Sm4A = AbstractC23254wc6.a();
            this.f = c7620Sm4A;
        }
        c7620Sm4A.x(interfaceC11014cb1);
        m(interfaceC11014cb1, i, i2, i3);
    }

    @Override // ir.nasim.XM5
    public void g(ZM5 zm5, int i, int i2, int i3) {
        m(zm5, i, i2, i3);
    }

    public final void h() {
        if (!this.a.isEmpty()) {
            Object objA = C17398mt7.a.a("Compose:abandons");
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    YM5 ym5 = (YM5) it.next();
                    it.remove();
                    ym5.d();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                C17398mt7.a.b(objA);
            } catch (Throwable th) {
                C17398mt7.a.b(objA);
                throw th;
            }
        }
    }

    public final void j() {
        Object objA;
        l(RecyclerView.UNDEFINED_DURATION);
        if (this.d.o() != 0) {
            objA = C17398mt7.a.a("Compose:onForgotten");
            try {
                C7620Sm4 c7620Sm4 = this.f;
                for (int iO = this.d.o() - 1; -1 < iO; iO--) {
                    Object obj = this.d.a[iO];
                    if (obj instanceof ZM5) {
                        YM5 ym5B = ((ZM5) obj).b();
                        this.a.remove(ym5B);
                        ym5B.e();
                    }
                    if (obj instanceof InterfaceC11014cb1) {
                        if (c7620Sm4 == null || !c7620Sm4.a(obj)) {
                            ((InterfaceC11014cb1) obj).i();
                        } else {
                            ((InterfaceC11014cb1) obj).q();
                        }
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.b.o() != 0) {
            C17398mt7 c17398mt7 = C17398mt7.a;
            objA = c17398mt7.a("Compose:onRemembered");
            try {
                i(this.b);
                C19938rB7 c19938rB72 = C19938rB7.a;
                c17398mt7.b(objA);
            } finally {
                C17398mt7.a.b(objA);
            }
        }
    }

    public final void k() {
        if (this.e.o() != 0) {
            Object objA = C17398mt7.a.a("Compose:sideeffects");
            try {
                C12544en4 c12544en4 = this.e;
                Object[] objArr = c12544en4.a;
                int iO = c12544en4.o();
                for (int i = 0; i < iO; i++) {
                    ((SA2) objArr[i]).invoke();
                }
                this.e.k();
                C19938rB7 c19938rB7 = C19938rB7.a;
                C17398mt7.a.b(objA);
            } catch (Throwable th) {
                C17398mt7.a.b(objA);
                throw th;
            }
        }
    }
}
