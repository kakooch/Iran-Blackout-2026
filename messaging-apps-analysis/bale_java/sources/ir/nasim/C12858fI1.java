package ir.nasim;

import ir.nasim.C16651le1;
import ir.nasim.C20795sd0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.fI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12858fI1 {
    private C17242me1 a;
    private C17242me1 d;
    private boolean b = true;
    private boolean c = true;
    private ArrayList e = new ArrayList();
    private ArrayList f = new ArrayList();
    private C20795sd0.b g = null;
    private C20795sd0.a h = new C20795sd0.a();
    ArrayList i = new ArrayList();

    public C12858fI1(C17242me1 c17242me1) {
        this.a = c17242me1;
        this.d = c17242me1;
    }

    private void a(C13476gI1 c13476gI1, int i, int i2, C13476gI1 c13476gI12, ArrayList arrayList, C15170j76 c15170j76) {
        AbstractC15192j98 abstractC15192j98 = c13476gI1.d;
        if (abstractC15192j98.c == null) {
            C17242me1 c17242me1 = this.a;
            if (abstractC15192j98 == c17242me1.e || abstractC15192j98 == c17242me1.f) {
                return;
            }
            if (c15170j76 == null) {
                c15170j76 = new C15170j76(abstractC15192j98, i2);
                arrayList.add(c15170j76);
            }
            abstractC15192j98.c = c15170j76;
            c15170j76.a(abstractC15192j98);
            for (InterfaceC10842cI1 interfaceC10842cI1 : abstractC15192j98.h.k) {
                if (interfaceC10842cI1 instanceof C13476gI1) {
                    a((C13476gI1) interfaceC10842cI1, i, 0, c13476gI12, arrayList, c15170j76);
                }
            }
            for (InterfaceC10842cI1 interfaceC10842cI12 : abstractC15192j98.i.k) {
                if (interfaceC10842cI12 instanceof C13476gI1) {
                    a((C13476gI1) interfaceC10842cI12, i, 1, c13476gI12, arrayList, c15170j76);
                }
            }
            if (i == 1 && (abstractC15192j98 instanceof C17727nS7)) {
                for (InterfaceC10842cI1 interfaceC10842cI13 : ((C17727nS7) abstractC15192j98).k.k) {
                    if (interfaceC10842cI13 instanceof C13476gI1) {
                        a((C13476gI1) interfaceC10842cI13, i, 2, c13476gI12, arrayList, c15170j76);
                    }
                }
            }
            for (C13476gI1 c13476gI13 : abstractC15192j98.h.l) {
                if (c13476gI13 == c13476gI12) {
                    c15170j76.b = true;
                }
                a(c13476gI13, i, 0, c13476gI12, arrayList, c15170j76);
            }
            for (C13476gI1 c13476gI14 : abstractC15192j98.i.l) {
                if (c13476gI14 == c13476gI12) {
                    c15170j76.b = true;
                }
                a(c13476gI14, i, 1, c13476gI12, arrayList, c15170j76);
            }
            if (i == 1 && (abstractC15192j98 instanceof C17727nS7)) {
                Iterator it = ((C17727nS7) abstractC15192j98).k.l.iterator();
                while (it.hasNext()) {
                    a((C13476gI1) it.next(), i, 2, c13476gI12, arrayList, c15170j76);
                }
            }
        }
    }

    private boolean b(C17242me1 c17242me1) {
        int iX;
        C16651le1.b bVar;
        int iZ;
        C16651le1.b bVar2;
        C16651le1.b bVar3;
        C16651le1.b bVar4;
        Iterator it = c17242me1.V0.iterator();
        while (it.hasNext()) {
            C16651le1 c16651le1 = (C16651le1) it.next();
            C16651le1.b[] bVarArr = c16651le1.b0;
            C16651le1.b bVar5 = bVarArr[0];
            C16651le1.b bVar6 = bVarArr[1];
            if (c16651le1.W() == 8) {
                c16651le1.a = true;
            } else {
                if (c16651le1.B < 1.0f && bVar5 == C16651le1.b.MATCH_CONSTRAINT) {
                    c16651le1.w = 2;
                }
                if (c16651le1.E < 1.0f && bVar6 == C16651le1.b.MATCH_CONSTRAINT) {
                    c16651le1.x = 2;
                }
                if (c16651le1.x() > 0.0f) {
                    C16651le1.b bVar7 = C16651le1.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == C16651le1.b.WRAP_CONTENT || bVar6 == C16651le1.b.FIXED)) {
                        c16651le1.w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == C16651le1.b.WRAP_CONTENT || bVar5 == C16651le1.b.FIXED)) {
                        c16651le1.x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (c16651le1.w == 0) {
                            c16651le1.w = 3;
                        }
                        if (c16651le1.x == 0) {
                            c16651le1.x = 3;
                        }
                    }
                }
                C16651le1.b bVar8 = C16651le1.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && c16651le1.w == 1 && (c16651le1.Q.f == null || c16651le1.S.f == null)) {
                    bVar5 = C16651le1.b.WRAP_CONTENT;
                }
                C16651le1.b bVar9 = bVar5;
                if (bVar6 == bVar8 && c16651le1.x == 1 && (c16651le1.R.f == null || c16651le1.T.f == null)) {
                    bVar6 = C16651le1.b.WRAP_CONTENT;
                }
                C16651le1.b bVar10 = bVar6;
                RY2 ry2 = c16651le1.e;
                ry2.d = bVar9;
                int i = c16651le1.w;
                ry2.a = i;
                C17727nS7 c17727nS7 = c16651le1.f;
                c17727nS7.d = bVar10;
                int i2 = c16651le1.x;
                c17727nS7.a = i2;
                C16651le1.b bVar11 = C16651le1.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == C16651le1.b.FIXED || bVar9 == C16651le1.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == C16651le1.b.FIXED || bVar10 == C16651le1.b.WRAP_CONTENT)) {
                    int iX2 = c16651le1.X();
                    if (bVar9 == bVar11) {
                        iX = (c17242me1.X() - c16651le1.Q.g) - c16651le1.S.g;
                        bVar = C16651le1.b.FIXED;
                    } else {
                        iX = iX2;
                        bVar = bVar9;
                    }
                    int iZ2 = c16651le1.z();
                    if (bVar10 == bVar11) {
                        iZ = (c17242me1.z() - c16651le1.R.g) - c16651le1.T.g;
                        bVar2 = C16651le1.b.FIXED;
                    } else {
                        iZ = iZ2;
                        bVar2 = bVar10;
                    }
                    l(c16651le1, bVar, iX, bVar2, iZ);
                    c16651le1.e.e.d(c16651le1.X());
                    c16651le1.f.e.d(c16651le1.z());
                    c16651le1.a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = C16651le1.b.WRAP_CONTENT) || bVar10 == C16651le1.b.FIXED)) {
                        if (i == 3) {
                            if (bVar10 == bVar4) {
                                l(c16651le1, bVar4, 0, bVar4, 0);
                            }
                            int iZ3 = c16651le1.z();
                            int i3 = (int) ((iZ3 * c16651le1.f0) + 0.5f);
                            C16651le1.b bVar12 = C16651le1.b.FIXED;
                            l(c16651le1, bVar12, i3, bVar12, iZ3);
                            c16651le1.e.e.d(c16651le1.X());
                            c16651le1.f.e.d(c16651le1.z());
                            c16651le1.a = true;
                        } else if (i == 1) {
                            l(c16651le1, bVar4, 0, bVar10, 0);
                            c16651le1.e.e.m = c16651le1.X();
                        } else if (i == 2) {
                            C16651le1.b bVar13 = c17242me1.b0[0];
                            C16651le1.b bVar14 = C16651le1.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                l(c16651le1, bVar14, (int) ((c16651le1.B * c17242me1.X()) + 0.5f), bVar10, c16651le1.z());
                                c16651le1.e.e.d(c16651le1.X());
                                c16651le1.f.e.d(c16651le1.z());
                                c16651le1.a = true;
                            }
                        } else {
                            C8243Vd1[] c8243Vd1Arr = c16651le1.Y;
                            if (c8243Vd1Arr[0].f == null || c8243Vd1Arr[1].f == null) {
                                l(c16651le1, bVar4, 0, bVar10, 0);
                                c16651le1.e.e.d(c16651le1.X());
                                c16651le1.f.e.d(c16651le1.z());
                                c16651le1.a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = C16651le1.b.WRAP_CONTENT) || bVar9 == C16651le1.b.FIXED)) {
                        if (i2 == 3) {
                            if (bVar9 == bVar3) {
                                l(c16651le1, bVar3, 0, bVar3, 0);
                            }
                            int iX3 = c16651le1.X();
                            float f = c16651le1.f0;
                            if (c16651le1.y() == -1) {
                                f = 1.0f / f;
                            }
                            C16651le1.b bVar15 = C16651le1.b.FIXED;
                            l(c16651le1, bVar15, iX3, bVar15, (int) ((iX3 * f) + 0.5f));
                            c16651le1.e.e.d(c16651le1.X());
                            c16651le1.f.e.d(c16651le1.z());
                            c16651le1.a = true;
                        } else if (i2 == 1) {
                            l(c16651le1, bVar9, 0, bVar3, 0);
                            c16651le1.f.e.m = c16651le1.z();
                        } else if (i2 == 2) {
                            C16651le1.b bVar16 = c17242me1.b0[1];
                            C16651le1.b bVar17 = C16651le1.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                l(c16651le1, bVar9, c16651le1.X(), bVar17, (int) ((c16651le1.E * c17242me1.z()) + 0.5f));
                                c16651le1.e.e.d(c16651le1.X());
                                c16651le1.f.e.d(c16651le1.z());
                                c16651le1.a = true;
                            }
                        } else {
                            C8243Vd1[] c8243Vd1Arr2 = c16651le1.Y;
                            if (c8243Vd1Arr2[2].f == null || c8243Vd1Arr2[3].f == null) {
                                l(c16651le1, bVar3, 0, bVar10, 0);
                                c16651le1.e.e.d(c16651le1.X());
                                c16651le1.f.e.d(c16651le1.z());
                                c16651le1.a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i == 1 || i2 == 1) {
                            C16651le1.b bVar18 = C16651le1.b.WRAP_CONTENT;
                            l(c16651le1, bVar18, 0, bVar18, 0);
                            c16651le1.e.e.m = c16651le1.X();
                            c16651le1.f.e.m = c16651le1.z();
                        } else if (i2 == 2 && i == 2) {
                            C16651le1.b[] bVarArr2 = c17242me1.b0;
                            C16651le1.b bVar19 = bVarArr2[0];
                            C16651le1.b bVar20 = C16651le1.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                l(c16651le1, bVar20, (int) ((c16651le1.B * c17242me1.X()) + 0.5f), bVar20, (int) ((c16651le1.E * c17242me1.z()) + 0.5f));
                                c16651le1.e.e.d(c16651le1.X());
                                c16651le1.f.e.d(c16651le1.z());
                                c16651le1.a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(C17242me1 c17242me1, int i) {
        int size = this.i.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jMax = Math.max(jMax, ((C15170j76) this.i.get(i2)).b(c17242me1, i));
        }
        return (int) jMax;
    }

    private void i(AbstractC15192j98 abstractC15192j98, int i, ArrayList arrayList) {
        for (InterfaceC10842cI1 interfaceC10842cI1 : abstractC15192j98.h.k) {
            if (interfaceC10842cI1 instanceof C13476gI1) {
                a((C13476gI1) interfaceC10842cI1, i, 0, abstractC15192j98.i, arrayList, null);
            } else if (interfaceC10842cI1 instanceof AbstractC15192j98) {
                a(((AbstractC15192j98) interfaceC10842cI1).h, i, 0, abstractC15192j98.i, arrayList, null);
            }
        }
        for (InterfaceC10842cI1 interfaceC10842cI12 : abstractC15192j98.i.k) {
            if (interfaceC10842cI12 instanceof C13476gI1) {
                a((C13476gI1) interfaceC10842cI12, i, 1, abstractC15192j98.h, arrayList, null);
            } else if (interfaceC10842cI12 instanceof AbstractC15192j98) {
                a(((AbstractC15192j98) interfaceC10842cI12).i, i, 1, abstractC15192j98.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (InterfaceC10842cI1 interfaceC10842cI13 : ((C17727nS7) abstractC15192j98).k.k) {
                if (interfaceC10842cI13 instanceof C13476gI1) {
                    a((C13476gI1) interfaceC10842cI13, i, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(C16651le1 c16651le1, C16651le1.b bVar, int i, C16651le1.b bVar2, int i2) {
        C20795sd0.a aVar = this.h;
        aVar.a = bVar;
        aVar.b = bVar2;
        aVar.c = i;
        aVar.d = i2;
        this.g.b(c16651le1, aVar);
        c16651le1.j1(this.h.e);
        c16651le1.K0(this.h.f);
        c16651le1.J0(this.h.h);
        c16651le1.z0(this.h.g);
    }

    public void c() {
        d(this.e);
        this.i.clear();
        C15170j76.h = 0;
        i(this.a.e, 0, this.i);
        i(this.a.f, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.d.e.f();
        this.d.f.f();
        arrayList.add(this.d.e);
        arrayList.add(this.d.f);
        Iterator it = this.d.V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            C16651le1 c16651le1 = (C16651le1) it.next();
            if (c16651le1 instanceof NS2) {
                arrayList.add(new OS2(c16651le1));
            } else {
                if (c16651le1.j0()) {
                    if (c16651le1.c == null) {
                        c16651le1.c = new C13475gI0(c16651le1, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c16651le1.c);
                } else {
                    arrayList.add(c16651le1.e);
                }
                if (c16651le1.l0()) {
                    if (c16651le1.d == null) {
                        c16651le1.d = new C13475gI0(c16651le1, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c16651le1.d);
                } else {
                    arrayList.add(c16651le1.f);
                }
                if (c16651le1 instanceof C18931pV2) {
                    arrayList.add(new C18340oV2(c16651le1));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((AbstractC15192j98) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) it3.next();
            if (abstractC15192j98.b != this.d) {
                abstractC15192j98.d();
            }
        }
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.b || this.c) {
            Iterator it = this.a.V0.iterator();
            while (it.hasNext()) {
                C16651le1 c16651le1 = (C16651le1) it.next();
                c16651le1.p();
                c16651le1.a = false;
                c16651le1.e.r();
                c16651le1.f.q();
            }
            this.a.p();
            C17242me1 c17242me1 = this.a;
            c17242me1.a = false;
            c17242me1.e.r();
            this.a.f.q();
            this.c = false;
        }
        if (b(this.d)) {
            return false;
        }
        this.a.l1(0);
        this.a.m1(0);
        C16651le1.b bVarW = this.a.w(0);
        C16651le1.b bVarW2 = this.a.w(1);
        if (this.b) {
            c();
        }
        int iY = this.a.Y();
        int iZ = this.a.Z();
        this.a.e.h.d(iY);
        this.a.f.h.d(iZ);
        m();
        C16651le1.b bVar = C16651le1.b.WRAP_CONTENT;
        if (bVarW == bVar || bVarW2 == bVar) {
            if (z4) {
                Iterator it2 = this.e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((AbstractC15192j98) it2.next()).m()) {
                        z4 = false;
                        break;
                    }
                }
            }
            if (z4 && bVarW == C16651le1.b.WRAP_CONTENT) {
                this.a.O0(C16651le1.b.FIXED);
                C17242me1 c17242me12 = this.a;
                c17242me12.j1(e(c17242me12, 0));
                C17242me1 c17242me13 = this.a;
                c17242me13.e.e.d(c17242me13.X());
            }
            if (z4 && bVarW2 == C16651le1.b.WRAP_CONTENT) {
                this.a.f1(C16651le1.b.FIXED);
                C17242me1 c17242me14 = this.a;
                c17242me14.K0(e(c17242me14, 1));
                C17242me1 c17242me15 = this.a;
                c17242me15.f.e.d(c17242me15.z());
            }
        }
        C17242me1 c17242me16 = this.a;
        C16651le1.b bVar2 = c17242me16.b0[0];
        C16651le1.b bVar3 = C16651le1.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == C16651le1.b.MATCH_PARENT) {
            int iX = c17242me16.X() + iY;
            this.a.e.i.d(iX);
            this.a.e.e.d(iX - iY);
            m();
            C17242me1 c17242me17 = this.a;
            C16651le1.b bVar4 = c17242me17.b0[1];
            if (bVar4 == bVar3 || bVar4 == C16651le1.b.MATCH_PARENT) {
                int iZ2 = c17242me17.z() + iZ;
                this.a.f.i.d(iZ2);
                this.a.f.e.d(iZ2 - iZ);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) it3.next();
            if (abstractC15192j98.b != this.a || abstractC15192j98.g) {
                abstractC15192j98.e();
            }
        }
        Iterator it4 = this.e.iterator();
        while (it4.hasNext()) {
            AbstractC15192j98 abstractC15192j982 = (AbstractC15192j98) it4.next();
            if (z2 || abstractC15192j982.b != this.a) {
                if (!abstractC15192j982.h.j || ((!abstractC15192j982.i.j && !(abstractC15192j982 instanceof OS2)) || (!abstractC15192j982.e.j && !(abstractC15192j982 instanceof C13475gI0) && !(abstractC15192j982 instanceof OS2)))) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.O0(bVarW);
        this.a.f1(bVarW2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.b) {
            Iterator it = this.a.V0.iterator();
            while (it.hasNext()) {
                C16651le1 c16651le1 = (C16651le1) it.next();
                c16651le1.p();
                c16651le1.a = false;
                RY2 ry2 = c16651le1.e;
                ry2.e.j = false;
                ry2.g = false;
                ry2.r();
                C17727nS7 c17727nS7 = c16651le1.f;
                c17727nS7.e.j = false;
                c17727nS7.g = false;
                c17727nS7.q();
            }
            this.a.p();
            C17242me1 c17242me1 = this.a;
            c17242me1.a = false;
            RY2 ry22 = c17242me1.e;
            ry22.e.j = false;
            ry22.g = false;
            ry22.r();
            C17727nS7 c17727nS72 = this.a.f;
            c17727nS72.e.j = false;
            c17727nS72.g = false;
            c17727nS72.q();
            c();
        }
        if (b(this.d)) {
            return false;
        }
        this.a.l1(0);
        this.a.m1(0);
        this.a.e.h.d(0);
        this.a.f.h.d(0);
        return true;
    }

    public boolean h(boolean z, int i) {
        boolean z2;
        C16651le1.b bVar;
        boolean z3 = true;
        boolean z4 = z & true;
        C16651le1.b bVarW = this.a.w(0);
        C16651le1.b bVarW2 = this.a.w(1);
        int iY = this.a.Y();
        int iZ = this.a.Z();
        if (z4 && (bVarW == (bVar = C16651le1.b.WRAP_CONTENT) || bVarW2 == bVar)) {
            Iterator it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC15192j98 abstractC15192j98 = (AbstractC15192j98) it.next();
                if (abstractC15192j98.f == i && !abstractC15192j98.m()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && bVarW == C16651le1.b.WRAP_CONTENT) {
                    this.a.O0(C16651le1.b.FIXED);
                    C17242me1 c17242me1 = this.a;
                    c17242me1.j1(e(c17242me1, 0));
                    C17242me1 c17242me12 = this.a;
                    c17242me12.e.e.d(c17242me12.X());
                }
            } else if (z4 && bVarW2 == C16651le1.b.WRAP_CONTENT) {
                this.a.f1(C16651le1.b.FIXED);
                C17242me1 c17242me13 = this.a;
                c17242me13.K0(e(c17242me13, 1));
                C17242me1 c17242me14 = this.a;
                c17242me14.f.e.d(c17242me14.z());
            }
        }
        if (i == 0) {
            C17242me1 c17242me15 = this.a;
            C16651le1.b bVar2 = c17242me15.b0[0];
            if (bVar2 == C16651le1.b.FIXED || bVar2 == C16651le1.b.MATCH_PARENT) {
                int iX = c17242me15.X() + iY;
                this.a.e.i.d(iX);
                this.a.e.e.d(iX - iY);
                z2 = true;
            }
            z2 = false;
        } else {
            C17242me1 c17242me16 = this.a;
            C16651le1.b bVar3 = c17242me16.b0[1];
            if (bVar3 == C16651le1.b.FIXED || bVar3 == C16651le1.b.MATCH_PARENT) {
                int iZ2 = c17242me16.z() + iZ;
                this.a.f.i.d(iZ2);
                this.a.f.e.d(iZ2 - iZ);
                z2 = true;
            }
            z2 = false;
        }
        m();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            AbstractC15192j98 abstractC15192j982 = (AbstractC15192j98) it2.next();
            if (abstractC15192j982.f == i && (abstractC15192j982.b != this.a || abstractC15192j982.g)) {
                abstractC15192j982.e();
            }
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            AbstractC15192j98 abstractC15192j983 = (AbstractC15192j98) it3.next();
            if (abstractC15192j983.f == i && (z2 || abstractC15192j983.b != this.a)) {
                if (!abstractC15192j983.h.j || !abstractC15192j983.i.j || (!(abstractC15192j983 instanceof C13475gI0) && !abstractC15192j983.e.j)) {
                    z3 = false;
                    break;
                }
            }
        }
        this.a.O0(bVarW);
        this.a.f1(bVarW2);
        return z3;
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void m() {
        GT1 gt1;
        Iterator it = this.a.V0.iterator();
        while (it.hasNext()) {
            C16651le1 c16651le1 = (C16651le1) it.next();
            if (!c16651le1.a) {
                C16651le1.b[] bVarArr = c16651le1.b0;
                boolean z = false;
                C16651le1.b bVar = bVarArr[0];
                C16651le1.b bVar2 = bVarArr[1];
                int i = c16651le1.w;
                int i2 = c16651le1.x;
                C16651le1.b bVar3 = C16651le1.b.WRAP_CONTENT;
                boolean z2 = bVar == bVar3 || (bVar == C16651le1.b.MATCH_CONSTRAINT && i == 1);
                if (bVar2 == bVar3 || (bVar2 == C16651le1.b.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                GT1 gt12 = c16651le1.e.e;
                boolean z3 = gt12.j;
                GT1 gt13 = c16651le1.f.e;
                boolean z4 = gt13.j;
                if (z3 && z4) {
                    C16651le1.b bVar4 = C16651le1.b.FIXED;
                    l(c16651le1, bVar4, gt12.g, bVar4, gt13.g);
                    c16651le1.a = true;
                } else if (z3 && z) {
                    l(c16651le1, C16651le1.b.FIXED, gt12.g, bVar3, gt13.g);
                    if (bVar2 == C16651le1.b.MATCH_CONSTRAINT) {
                        c16651le1.f.e.m = c16651le1.z();
                    } else {
                        c16651le1.f.e.d(c16651le1.z());
                        c16651le1.a = true;
                    }
                } else if (z4 && z2) {
                    l(c16651le1, bVar3, gt12.g, C16651le1.b.FIXED, gt13.g);
                    if (bVar == C16651le1.b.MATCH_CONSTRAINT) {
                        c16651le1.e.e.m = c16651le1.X();
                    } else {
                        c16651le1.e.e.d(c16651le1.X());
                        c16651le1.a = true;
                    }
                }
                if (c16651le1.a && (gt1 = c16651le1.f.l) != null) {
                    gt1.d(c16651le1.r());
                }
            }
        }
    }

    public void n(C20795sd0.b bVar) {
        this.g = bVar;
    }
}
