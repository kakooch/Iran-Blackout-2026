package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.FocusTargetNode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25174zr2 {
    private final UA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private final C7620Sm4 e = AbstractC23254wc6.a();
    private final C7620Sm4 f = AbstractC23254wc6.a();
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    private final List i = new ArrayList();
    private final List j = new ArrayList();
    private boolean k;

    /* renamed from: ir.nasim.zr2$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        a(Object obj) {
            super(0, obj, C25174zr2.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C25174zr2) this.receiver).c();
        }
    }

    /* renamed from: ir.nasim.zr2$b */
    /* synthetic */ class b extends EB2 implements SA2 {
        b(Object obj) {
            super(0, obj, C25174zr2.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C25174zr2) this.receiver).c();
        }
    }

    public C25174zr2(UA2 ua2, SA2 sa2, SA2 sa22, SA2 sa23) {
        this.a = ua2;
        this.b = sa2;
        this.c = sa22;
        this.d = sa23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        if (C15439jb1.g) {
            e();
        } else {
            d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private final void d() {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        InterfaceC5517Jr2 interfaceC5517Jr2W;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = 0;
        if (!((InterfaceC5517Jr2) this.c.invoke()).j()) {
            List list = this.h;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((InterfaceC20937sr2) list.get(i5)).O(EnumC5751Kr2.d);
            }
            List list2 = this.g;
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) list2.get(i6);
                if (focusTargetNode.b2() && !focusTargetNode.L2()) {
                    focusTargetNode.I2(EnumC5751Kr2.d);
                }
            }
            this.g.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.b.invoke();
            return;
        }
        List list3 = this.i;
        int size3 = list3.size();
        int i7 = 0;
        while (true) {
            i = 1024;
            i2 = 16;
            i3 = 1;
            if (i7 >= size3) {
                break;
            }
            InterfaceC4815Gr2 interfaceC4815Gr2 = (InterfaceC4815Gr2) list3.get(i7);
            if (interfaceC4815Gr2.h().b2()) {
                int iA = AbstractC9572aB4.a(1024);
                e.c cVarH = interfaceC4815Gr2.h();
                C12544en4 c12544en4 = null;
                while (cVarH != null) {
                    if (cVarH instanceof FocusTargetNode) {
                        this.g.add((FocusTargetNode) cVarH);
                    } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                        int i8 = 0;
                        for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                            if ((cVarW2.W1() & iA) != 0) {
                                i8++;
                                if (i8 == 1) {
                                    cVarH = cVarW2;
                                } else {
                                    if (c12544en4 == null) {
                                        c12544en4 = new C12544en4(new e.c[16], 0);
                                    }
                                    if (cVarH != null) {
                                        c12544en4.d(cVarH);
                                        cVarH = null;
                                    }
                                    c12544en4.d(cVarW2);
                                }
                            }
                        }
                        if (i8 == 1) {
                        }
                    }
                    cVarH = KG1.h(c12544en4);
                }
                if (!interfaceC4815Gr2.h().b2()) {
                    M73.b("visitChildren called on an unattached node");
                }
                C12544en4 c12544en42 = new C12544en4(new e.c[16], 0);
                e.c cVarS1 = interfaceC4815Gr2.h().S1();
                if (cVarS1 == null) {
                    KG1.c(c12544en42, interfaceC4815Gr2.h(), false);
                } else {
                    c12544en42.d(cVarS1);
                }
                while (c12544en42.o() != 0) {
                    e.c cVarH2 = (e.c) c12544en42.w(c12544en42.o() - 1);
                    if ((cVarH2.R1() & iA) == 0) {
                        KG1.c(c12544en42, cVarH2, false);
                    } else {
                        while (true) {
                            if (cVarH2 == null) {
                                break;
                            }
                            if ((cVarH2.W1() & iA) != 0) {
                                C12544en4 c12544en43 = null;
                                while (cVarH2 != null) {
                                    if (cVarH2 instanceof FocusTargetNode) {
                                        this.g.add((FocusTargetNode) cVarH2);
                                    } else if ((cVarH2.W1() & iA) != 0 && (cVarH2 instanceof RG1)) {
                                        int i9 = 0;
                                        for (e.c cVarW22 = ((RG1) cVarH2).w2(); cVarW22 != null; cVarW22 = cVarW22.S1()) {
                                            if ((cVarW22.W1() & iA) != 0) {
                                                i9++;
                                                if (i9 == 1) {
                                                    cVarH2 = cVarW22;
                                                } else {
                                                    if (c12544en43 == null) {
                                                        c12544en43 = new C12544en4(new e.c[16], 0);
                                                    }
                                                    if (cVarH2 != null) {
                                                        c12544en43.d(cVarH2);
                                                        cVarH2 = null;
                                                    }
                                                    c12544en43.d(cVarW22);
                                                }
                                            }
                                        }
                                        if (i9 == 1) {
                                        }
                                    }
                                    cVarH2 = KG1.h(c12544en43);
                                }
                            } else {
                                cVarH2 = cVarH2.S1();
                            }
                        }
                    }
                }
            }
            i7++;
        }
        this.i.clear();
        List list4 = this.h;
        int size4 = list4.size();
        int i10 = 0;
        while (i10 < size4) {
            InterfaceC20937sr2 interfaceC20937sr2 = (InterfaceC20937sr2) list4.get(i10);
            if (interfaceC20937sr2.h().b2()) {
                int iA2 = AbstractC9572aB4.a(i);
                e.c cVarH3 = interfaceC20937sr2.h();
                int i11 = z5;
                int i12 = i3;
                FocusTargetNode focusTargetNode2 = null;
                C12544en4 c12544en44 = null;
                while (cVarH3 != null) {
                    if (cVarH3 instanceof FocusTargetNode) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) cVarH3;
                        if (focusTargetNode2 != null) {
                            i11 = i3;
                        }
                        if (this.g.contains(focusTargetNode3)) {
                            this.j.add(focusTargetNode3);
                            i12 = z5;
                        }
                        focusTargetNode2 = focusTargetNode3;
                    } else if ((cVarH3.W1() & iA2) != 0 && (cVarH3 instanceof RG1)) {
                        e.c cVarW23 = ((RG1) cVarH3).w2();
                        int i13 = z5;
                        while (cVarW23 != null) {
                            if ((cVarW23.W1() & iA2) != 0) {
                                i13++;
                                if (i13 == i3) {
                                    cVarH3 = cVarW23;
                                } else {
                                    if (c12544en44 == null) {
                                        c12544en44 = new C12544en4(new e.c[i2], z5);
                                    }
                                    if (cVarH3 != null) {
                                        c12544en44.d(cVarH3);
                                        cVarH3 = null;
                                    }
                                    c12544en44.d(cVarW23);
                                }
                            }
                            cVarW23 = cVarW23.S1();
                            i3 = 1;
                        }
                        int i14 = i3;
                        if (i13 == i14) {
                            i3 = i14;
                        }
                    }
                    cVarH3 = KG1.h(c12544en44);
                    i3 = 1;
                }
                if (!interfaceC20937sr2.h().b2()) {
                    M73.b("visitChildren called on an unattached node");
                }
                C12544en4 c12544en45 = new C12544en4(new e.c[i2], z5);
                e.c cVarS12 = interfaceC20937sr2.h().S1();
                if (cVarS12 == null) {
                    KG1.c(c12544en45, interfaceC20937sr2.h(), z5);
                } else {
                    c12544en45.d(cVarS12);
                }
                while (c12544en45.o() != 0) {
                    e.c cVarH4 = (e.c) c12544en45.w(c12544en45.o() - 1);
                    z5 = z5;
                    if ((cVarH4.R1() & iA2) == 0) {
                        KG1.c(c12544en45, cVarH4, z5);
                    } else {
                        while (cVarH4 != null) {
                            if ((cVarH4.W1() & iA2) != 0) {
                                C12544en4 c12544en46 = null;
                                z5 = z5;
                                while (cVarH4 != null) {
                                    if (cVarH4 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) cVarH4;
                                        if (focusTargetNode2 != null) {
                                            i11 = 1;
                                        }
                                        if (this.g.contains(focusTargetNode4)) {
                                            this.j.add(focusTargetNode4);
                                            i12 = z5 == true ? 1 : 0;
                                        }
                                        z2 = z5 == true ? 1 : 0;
                                        focusTargetNode2 = focusTargetNode4;
                                    } else if ((cVarH4.W1() & iA2) == 0 || !(cVarH4 instanceof RG1)) {
                                        z2 = z5 == true ? 1 : 0;
                                    } else {
                                        e.c cVarW24 = ((RG1) cVarH4).w2();
                                        int i15 = z5 == true ? 1 : 0;
                                        boolean z6 = z5;
                                        while (cVarW24 != null) {
                                            if ((cVarW24.W1() & iA2) != 0) {
                                                i15++;
                                                if (i15 == 1) {
                                                    cVarH4 = cVarW24;
                                                    z4 = false;
                                                } else {
                                                    if (c12544en46 == null) {
                                                        e.c[] cVarArr = new e.c[i2];
                                                        z4 = false;
                                                        c12544en46 = new C12544en4(cVarArr, 0);
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (cVarH4 != null) {
                                                        c12544en46.d(cVarH4);
                                                        cVarH4 = null;
                                                    }
                                                    c12544en46.d(cVarW24);
                                                }
                                            } else {
                                                z4 = z6;
                                            }
                                            cVarW24 = cVarW24.S1();
                                            z6 = z4;
                                            i2 = 16;
                                        }
                                        z3 = z6;
                                        z3 = z3;
                                        if (i15 != 1) {
                                            cVarH4 = KG1.h(c12544en46);
                                        }
                                        z5 = z3;
                                        i2 = 16;
                                    }
                                    z3 = z2;
                                    cVarH4 = KG1.h(c12544en46);
                                    z5 = z3;
                                    i2 = 16;
                                }
                                boolean z7 = z5 == true ? 1 : 0;
                                i2 = 16;
                            } else {
                                boolean z8 = z5 == true ? 1 : 0;
                                cVarH4 = cVarH4.S1();
                                z5 = z8 ? 1 : 0;
                                i2 = 16;
                            }
                        }
                    }
                    z5 = z5 ? 1 : 0;
                    i2 = 16;
                }
                z = z5 == true ? 1 : 0;
                i4 = 1;
                if (i12 != 0) {
                    if (i11 != 0) {
                        interfaceC5517Jr2W = AbstractC21624tr2.a(interfaceC20937sr2);
                    } else if (focusTargetNode2 == null || (interfaceC5517Jr2W = focusTargetNode2.W()) == null) {
                        interfaceC5517Jr2W = EnumC5751Kr2.d;
                    }
                    interfaceC20937sr2.O(interfaceC5517Jr2W);
                }
            } else {
                interfaceC20937sr2.O(EnumC5751Kr2.d);
                z = z5;
                i4 = i3;
            }
            i10++;
            i3 = i4;
            z5 = z;
            i = 1024;
            i2 = 16;
        }
        this.h.clear();
        List list5 = this.g;
        int size5 = list5.size();
        for (int i16 = z5; i16 < size5; i16++) {
            FocusTargetNode focusTargetNode5 = (FocusTargetNode) list5.get(i16);
            if (focusTargetNode5.b2()) {
                EnumC5751Kr2 enumC5751Kr2W = focusTargetNode5.W();
                focusTargetNode5.K2();
                if (enumC5751Kr2W != focusTargetNode5.W() || this.j.contains(focusTargetNode5)) {
                    focusTargetNode5.A2();
                }
            }
        }
        this.g.clear();
        this.j.clear();
        this.b.invoke();
        if (!this.i.isEmpty()) {
            M73.b("Unprocessed FocusProperties nodes");
        }
        if (!this.h.isEmpty()) {
            M73.b("Unprocessed FocusEvent nodes");
        }
        if (this.g.isEmpty()) {
            return;
        }
        M73.b("Unprocessed FocusTarget nodes");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void e() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C25174zr2.e():void");
    }

    private final void i(C7620Sm4 c7620Sm4, Object obj) {
        if (c7620Sm4.h(obj)) {
            l();
        }
    }

    private final void k(List list, Object obj) {
        if (list.add(obj) && this.g.size() + this.h.size() + this.i.size() == 1) {
            this.a.invoke(new a(this));
        }
    }

    private final void l() {
        if (this.k) {
            return;
        }
        this.a.invoke(new b(this));
        this.k = true;
    }

    public final boolean b() {
        return C15439jb1.g ? this.k : (this.g.isEmpty() ^ true) || (this.i.isEmpty() ^ true) || (this.h.isEmpty() ^ true);
    }

    public final void f(FocusTargetNode focusTargetNode) {
        if (C15439jb1.g) {
            i(this.e, focusTargetNode);
        } else {
            k(this.g, focusTargetNode);
        }
    }

    public final void g(InterfaceC20937sr2 interfaceC20937sr2) {
        if (C15439jb1.g) {
            i(this.f, interfaceC20937sr2);
        } else {
            k(this.h, interfaceC20937sr2);
        }
    }

    public final void h(InterfaceC4815Gr2 interfaceC4815Gr2) {
        k(this.i, interfaceC4815Gr2);
    }

    public final void j() {
        l();
    }
}
