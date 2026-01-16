package ir.nasim;

import android.util.Log;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C16651le1;
import ir.nasim.C20795sd0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.jW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15395jW3 implements C20795sd0.b, InterfaceC18822pJ1 {
    private String a = "";
    private final C17242me1 b;
    private final Map c;
    private final Map d;
    private final Map e;
    protected WH1 f;
    protected InterfaceC12377eW3 g;
    private final InterfaceC9173Yu3 h;
    private final int[] i;
    private final int[] j;
    private float k;
    private int l;
    private int m;
    private ArrayList n;

    /* renamed from: ir.nasim.jW3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C16651le1.b.values().length];
            iArr[C16651le1.b.FIXED.ordinal()] = 1;
            iArr[C16651le1.b.WRAP_CONTENT.ordinal()] = 2;
            iArr[C16651le1.b.MATCH_CONSTRAINT.ordinal()] = 3;
            iArr[C16651le1.b.MATCH_PARENT.ordinal()] = 4;
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.jW3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C13992h98 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C13992h98 c13992h98) {
            super(1);
            this.e = c13992h98;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(cVar, "$this$null");
            if (!Float.isNaN(this.e.f) || !Float.isNaN(this.e.g)) {
                cVar.C0(AbstractC13854gv7.a(Float.isNaN(this.e.f) ? 0.5f : this.e.f, Float.isNaN(this.e.g) ? 0.5f : this.e.g));
            }
            if (!Float.isNaN(this.e.h)) {
                cVar.j(this.e.h);
            }
            if (!Float.isNaN(this.e.i)) {
                cVar.k(this.e.i);
            }
            if (!Float.isNaN(this.e.j)) {
                cVar.l(this.e.j);
            }
            if (!Float.isNaN(this.e.k)) {
                cVar.n(this.e.k);
            }
            if (!Float.isNaN(this.e.l)) {
                cVar.e(this.e.l);
            }
            if (!Float.isNaN(this.e.m)) {
                cVar.B(this.e.m);
            }
            if (!Float.isNaN(this.e.n) || !Float.isNaN(this.e.o)) {
                cVar.g(Float.isNaN(this.e.n) ? 1.0f : this.e.n);
                cVar.m(Float.isNaN(this.e.o) ? 1.0f : this.e.o);
            }
            if (Float.isNaN(this.e.p)) {
                return;
            }
            cVar.c(this.e.p);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.jW3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TK6 invoke() {
            return new TK6(C15395jW3.this.f());
        }
    }

    public C15395jW3() {
        C17242me1 c17242me1 = new C17242me1(0, 0);
        c17242me1.U1(this);
        C19938rB7 c19938rB7 = C19938rB7.a;
        this.b = c17242me1;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.h = AbstractC13269fw3.b(EnumC4870Gx3.c, new c());
        this.i = new int[2];
        this.j = new int[2];
        this.k = Float.NaN;
        this.n = new ArrayList();
    }

    private final void e(Integer[] numArr, C20795sd0.a aVar) {
        numArr[0] = Integer.valueOf(aVar.e);
        numArr[1] = Integer.valueOf(aVar.f);
        numArr[2] = Integer.valueOf(aVar.g);
    }

    private final boolean j(C16651le1.b bVar, int i, int i2, int i3, boolean z, boolean z2, int i4, int[] iArr) {
        int i5 = a.a[bVar.ordinal()];
        if (i5 == 1) {
            iArr[0] = i;
            iArr[1] = i;
        } else {
            if (i5 == 2) {
                iArr[0] = 0;
                iArr[1] = i4;
                return true;
            }
            if (i5 == 3) {
                if (AbstractC9834ae1.a) {
                    Log.d("CCL", AbstractC13042fc3.q("Measure strategy ", Integer.valueOf(i3)));
                    Log.d("CCL", AbstractC13042fc3.q("DW ", Integer.valueOf(i2)));
                    Log.d("CCL", AbstractC13042fc3.q("ODR ", Boolean.valueOf(z)));
                    Log.d("CCL", AbstractC13042fc3.q("IRH ", Boolean.valueOf(z2)));
                }
                boolean z3 = z2 || ((i3 == C20795sd0.a.l || i3 == C20795sd0.a.m) && (i3 == C20795sd0.a.m || i2 != 1 || z));
                if (AbstractC9834ae1.a) {
                    Log.d("CCL", AbstractC13042fc3.q("UD ", Boolean.valueOf(z3)));
                }
                iArr[0] = z3 ? i : 0;
                if (!z3) {
                    i = i4;
                }
                iArr[1] = i;
                if (!z3) {
                    return true;
                }
            } else {
                if (i5 != 4) {
                    throw new IllegalStateException((bVar + " is not supported").toString());
                }
                iArr[0] = i4;
                iArr[1] = i4;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010a  */
    @Override // ir.nasim.C20795sd0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(ir.nasim.C16651le1 r20, ir.nasim.C20795sd0.a r21) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15395jW3.b(ir.nasim.le1, ir.nasim.sd0$a):void");
    }

    protected final void c(long j) {
        this.b.j1(C17833ne1.l(j));
        this.b.K0(C17833ne1.k(j));
        this.k = Float.NaN;
        this.l = this.b.X();
        this.m = this.b.z();
    }

    public void d() {
        C16651le1 c16651le1;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + this.b.X() + " ,");
        sb.append("  bottom:  " + this.b.z() + " ,");
        sb.append(" } }");
        Iterator it = this.b.q1().iterator();
        while (it.hasNext()) {
            C16651le1 c16651le12 = (C16651le1) it.next();
            Object objU = c16651le12.u();
            if (objU instanceof ZV3) {
                C13992h98 c13992h98 = null;
                if (c16651le12.o == null) {
                    ZV3 zv3 = (ZV3) objU;
                    Object objA = androidx.compose.ui.layout.a.a(zv3);
                    if (objA == null) {
                        objA = AbstractC11839de1.a(zv3);
                    }
                    c16651le12.o = objA == null ? null : objA.toString();
                }
                C13992h98 c13992h982 = (C13992h98) this.e.get(objU);
                if (c13992h982 != null && (c16651le1 = c13992h982.a) != null) {
                    c13992h98 = c16651le1.n;
                }
                if (c13992h98 != null) {
                    sb.append(' ' + ((Object) c16651le12.o) + ": {");
                    sb.append(" interpolated : ");
                    c13992h98.d(sb, true);
                    sb.append("}, ");
                }
            } else if (c16651le12 instanceof NS2) {
                sb.append(' ' + ((Object) c16651le12.o) + ": {");
                NS2 ns2 = (NS2) c16651le12;
                if (ns2.r1() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + ns2.Y() + ", top: " + ns2.Z() + ", right: " + (ns2.Y() + ns2.X()) + ", bottom: " + (ns2.Z() + ns2.z()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String string = sb.toString();
        AbstractC13042fc3.h(string, "json.toString()");
        this.a = string;
    }

    protected final WH1 f() {
        WH1 wh1 = this.f;
        if (wh1 != null) {
            return wh1;
        }
        AbstractC13042fc3.y("density");
        throw null;
    }

    protected final Map g() {
        return this.e;
    }

    protected final Map h() {
        return this.c;
    }

    protected final TK6 i() {
        return (TK6) this.h.getValue();
    }

    public final void k(AbstractC21430te5.a aVar, List list) {
        AbstractC13042fc3.i(aVar, "<this>");
        AbstractC13042fc3.i(list, "measurables");
        if (this.e.isEmpty()) {
            Iterator it = this.b.q1().iterator();
            while (it.hasNext()) {
                C16651le1 c16651le1 = (C16651le1) it.next();
                Object objU = c16651le1.u();
                if (objU instanceof ZV3) {
                    this.e.put(objU, new C13992h98(c16651le1.n.h()));
                }
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ZV3 zv3 = (ZV3) list.get(i);
                C13992h98 c13992h98 = (C13992h98) g().get(zv3);
                if (c13992h98 == null) {
                    return;
                }
                if (c13992h98.c()) {
                    C13992h98 c13992h982 = (C13992h98) g().get(zv3);
                    AbstractC13042fc3.f(c13992h982);
                    int i3 = c13992h982.b;
                    C13992h98 c13992h983 = (C13992h98) g().get(zv3);
                    AbstractC13042fc3.f(c13992h983);
                    int i4 = c13992h983.c;
                    AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) h().get(zv3);
                    if (abstractC21430te5 != null) {
                        AbstractC21430te5.a.j(aVar, abstractC21430te5, AbstractC22635va3.a(i3, i4), 0.0f, 2, null);
                    }
                } else {
                    b bVar = new b(c13992h98);
                    C13992h98 c13992h984 = (C13992h98) g().get(zv3);
                    AbstractC13042fc3.f(c13992h984);
                    int i5 = c13992h984.b;
                    C13992h98 c13992h985 = (C13992h98) g().get(zv3);
                    AbstractC13042fc3.f(c13992h985);
                    int i6 = c13992h985.c;
                    float f = Float.isNaN(c13992h98.m) ? 0.0f : c13992h98.m;
                    AbstractC21430te5 abstractC21430te52 = (AbstractC21430te5) h().get(zv3);
                    if (abstractC21430te52 != null) {
                        aVar.u(abstractC21430te52, i5, i6, f, bVar);
                    }
                }
                if (i2 > size) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        if (EnumC17404mu3.BOUNDS == null) {
            d();
        }
    }

    public final long l(long j, EnumC12613eu3 enumC12613eu3, InterfaceC13678ge1 interfaceC13678ge1, List list, int i, InterfaceC12377eW3 interfaceC12377eW3) {
        String string;
        AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
        AbstractC13042fc3.i(interfaceC13678ge1, "constraintSet");
        AbstractC13042fc3.i(list, "measurables");
        AbstractC13042fc3.i(interfaceC12377eW3, "measureScope");
        n(interfaceC12377eW3);
        o(interfaceC12377eW3);
        i().o(C17833ne1.j(j) ? ET1.a(C17833ne1.l(j)) : ET1.d().k(C17833ne1.n(j)));
        i().g(C17833ne1.i(j) ? ET1.a(C17833ne1.k(j)) : ET1.d().k(C17833ne1.m(j)));
        i().t(j);
        i().s(enumC12613eu3);
        m();
        if (interfaceC13678ge1.a(list)) {
            i().k();
            interfaceC13678ge1.c(i(), list);
            AbstractC9834ae1.d(i(), list);
            i().a(this.b);
        } else {
            AbstractC9834ae1.d(i(), list);
        }
        c(j);
        this.b.Z1();
        if (AbstractC9834ae1.a) {
            this.b.B0("ConstraintLayout");
            ArrayList<C16651le1> arrayListQ1 = this.b.q1();
            AbstractC13042fc3.h(arrayListQ1, "root.children");
            for (C16651le1 c16651le1 : arrayListQ1) {
                Object objU = c16651le1.u();
                ZV3 zv3 = objU instanceof ZV3 ? (ZV3) objU : null;
                Object objA = zv3 == null ? null : androidx.compose.ui.layout.a.a(zv3);
                String str = "NOTAG";
                if (objA != null && (string = objA.toString()) != null) {
                    str = string;
                }
                c16651le1.B0(str);
            }
            Log.d("CCL", AbstractC13042fc3.q("ConstraintLayout is asked to measure with ", C17833ne1.q(j)));
            Log.d("CCL", AbstractC9834ae1.h(this.b));
            Iterator it = this.b.q1().iterator();
            while (it.hasNext()) {
                C16651le1 c16651le12 = (C16651le1) it.next();
                AbstractC13042fc3.h(c16651le12, "child");
                Log.d("CCL", AbstractC9834ae1.h(c16651le12));
            }
        }
        this.b.V1(i);
        C17242me1 c17242me1 = this.b;
        c17242me1.Q1(c17242me1.I1(), 0, 0, 0, 0, 0, 0, 0, 0);
        Iterator it2 = this.b.q1().iterator();
        while (it2.hasNext()) {
            C16651le1 c16651le13 = (C16651le1) it2.next();
            Object objU2 = c16651le13.u();
            if (objU2 instanceof ZV3) {
                AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) this.c.get(objU2);
                Integer numValueOf = abstractC21430te5 == null ? null : Integer.valueOf(abstractC21430te5.P0());
                Integer numValueOf2 = abstractC21430te5 == null ? null : Integer.valueOf(abstractC21430te5.A0());
                int iX = c16651le13.X();
                if (numValueOf != null && iX == numValueOf.intValue()) {
                    int iZ = c16651le13.z();
                    if (numValueOf2 != null && iZ == numValueOf2.intValue()) {
                    }
                }
                if (AbstractC9834ae1.a) {
                    Log.d("CCL", "Final measurement for " + androidx.compose.ui.layout.a.a((ZV3) objU2) + " to confirm size " + c16651le13.X() + ' ' + c16651le13.z());
                }
                h().put(objU2, ((ZV3) objU2).l0(C17833ne1.b.c(c16651le13.X(), c16651le13.z())));
            }
        }
        if (AbstractC9834ae1.a) {
            Log.d("CCL", "ConstraintLayout is at the end " + this.b.X() + ' ' + this.b.z());
        }
        return AbstractC4663Ga3.a(this.b.X(), this.b.z());
    }

    public final void m() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }

    protected final void n(WH1 wh1) {
        AbstractC13042fc3.i(wh1, "<set-?>");
        this.f = wh1;
    }

    protected final void o(InterfaceC12377eW3 interfaceC12377eW3) {
        AbstractC13042fc3.i(interfaceC12377eW3, "<set-?>");
        this.g = interfaceC12377eW3;
    }

    @Override // ir.nasim.C20795sd0.b
    public void a() {
    }
}
