package ir.nasim;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import ir.nasim.G73;
import ir.nasim.N15;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class P64 extends AbstractC19821r0 implements InterfaceC9437Zx6, InterfaceC7879To6 {
    public static final a A0 = new a(null);
    public static final int B0 = 8;
    private static int C0;
    private C8967Xz7 A;
    private boolean B;
    private boolean D;
    private boolean G;
    private final E64 H;
    private final GestureDetector J;
    private final InterfaceC9173Yu3 Y;
    private final AccessibilityManager Z;
    private final View w;
    private final InterfaceC20284rl0 x;
    private final InterfaceC22948w54 y;
    private final EnumC8893Xt7 z;
    private final AccessibilityManager.AccessibilityStateChangeListener z0;

    public static final class a {
        private a() {
        }

        public final P64 a(ViewGroup viewGroup, LayoutInflater layoutInflater, LayoutInflater layoutInflater2, JW7 jw7, InterfaceC22152ul0 interfaceC22152ul0, ExPeerType exPeerType, AbstractC23538x54 abstractC23538x54, EW7 ew7, EnumC8893Xt7 enumC8893Xt7, boolean z, boolean z2) {
            AbstractC13042fc3.i(viewGroup, "viewGroup");
            AbstractC13042fc3.i(layoutInflater, "incomingInflater");
            AbstractC13042fc3.i(layoutInflater2, "outgoingInflater");
            AbstractC13042fc3.i(jw7, "viewHolderType");
            AbstractC13042fc3.i(interfaceC22152ul0, "bubbleFactory");
            AbstractC13042fc3.i(exPeerType, "peerType");
            AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
            AbstractC13042fc3.i(ew7, "viewHolderClickListener");
            b(viewGroup.getWidth());
            if (jw7.f()) {
                return S53.K0.a(viewGroup, layoutInflater, interfaceC22152ul0, exPeerType == ExPeerType.GROUP, z2, abstractC23538x54.b(), jw7.a(), ew7, jw7.c(), jw7, enumC8893Xt7, z);
            }
            return XM4.G0.a(viewGroup, layoutInflater2, interfaceC22152ul0, abstractC23538x54.b(), ew7, enumC8893Xt7, jw7.a());
        }

        public final void b(int i) {
            P64.C0 = i;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC20875sl0 {
        final /* synthetic */ EW7 a;
        final /* synthetic */ P64 b;

        b(EW7 ew7, P64 p64) {
            this.a = ew7;
            this.b = p64;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected P64(View view, InterfaceC20284rl0 interfaceC20284rl0, InterfaceC22948w54 interfaceC22948w54, EnumC8893Xt7 enumC8893Xt7, EW7 ew7) {
        super(view);
        AbstractC13042fc3.i(view, "rootView");
        AbstractC13042fc3.i(interfaceC20284rl0, "bubble");
        AbstractC13042fc3.i(interfaceC22948w54, "messageClickListener");
        AbstractC13042fc3.i(ew7, "viewHolderClickListener");
        this.w = view;
        this.x = interfaceC20284rl0;
        this.y = interfaceC22948w54;
        this.z = enumC8893Xt7;
        E64 e64 = new E64();
        this.H = e64;
        this.J = new GestureDetector(view.getContext(), e64);
        this.Y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.I64
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return P64.o1(this.a);
            }
        });
        Object systemService = view.getContext().getSystemService("accessibility");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.Z = (AccessibilityManager) systemService;
        interfaceC20284rl0.t(a1(ew7));
        this.z0 = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: ir.nasim.J64
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                P64.Q0(this.a, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(P64 p64, boolean z) {
        AbstractC13042fc3.i(p64, "this$0");
        if (p64.Z.isTouchExplorationEnabled()) {
            DisplayMetrics displayMetrics = p64.a.getContext().getResources().getDisplayMetrics();
            AbstractC5770Kt3.a().set(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2);
        }
        p64.q1(p64.Z.isTouchExplorationEnabled());
    }

    private final void S0(ArrayList arrayList, boolean z, boolean z2, boolean z3) {
        if (z == this.B && z2 == this.D && z3 == this.G) {
            return;
        }
        arrayList.add(new N15.t(z, z2, z3));
    }

    private final boolean T0(Object obj) {
        C8304Vk c8304Vk = obj instanceof C8304Vk ? (C8304Vk) obj : null;
        if (c8304Vk == null) {
            return false;
        }
        List listA = c8304Vk.a();
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                if (!AbstractC13042fc3.d(((C14339hl) it.next()).e(), Boolean.TRUE)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean U0(C8967Xz7 c8967Xz7, C8967Xz7 c8967Xz72) {
        return c8967Xz7.h().i() == c8967Xz72.h().i() && c8967Xz7.h().h() == c8967Xz72.h().h();
    }

    private final void W0() {
        final View view = this.w;
        final C8967Xz7 c8967Xz7 = this.A;
        if (c8967Xz7 == null) {
            return;
        }
        this.H.c(new SA2() { // from class: ir.nasim.F64
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(P64.X0(this.a, c8967Xz7, view));
            }
        });
        this.H.e(new SA2() { // from class: ir.nasim.G64
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return P64.Y0(this.a, c8967Xz7);
            }
        });
        this.H.d(new SA2() { // from class: ir.nasim.H64
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(P64.Z0(this.a, view, c8967Xz7));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X0(P64 p64, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(p64, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "$this_with");
        InterfaceC20284rl0 interfaceC20284rl0 = p64.x;
        if (interfaceC20284rl0 instanceof O44) {
            ((O44) interfaceC20284rl0).j(c8967Xz7.c());
        }
        InterfaceC22948w54 interfaceC22948w54 = p64.y;
        View rootView = view.getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        interfaceC22948w54.e(rootView, c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y0(P64 p64, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(p64, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        p64.y.m(c8967Xz7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z0(P64 p64, View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(p64, "this$0");
        AbstractC13042fc3.i(view, "$this_with");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        InterfaceC22948w54 interfaceC22948w54 = p64.y;
        View rootView = view.getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        return InterfaceC22948w54.i(interfaceC22948w54, rootView, c8967Xz7, null, 4, null);
    }

    private final InterfaceC20875sl0 a1(EW7 ew7) {
        return new b(ew7, this);
    }

    private final void c1(ArrayList arrayList, C8304Vk c8304Vk, C8304Vk c8304Vk2) {
        if (c8304Vk2.a().size() != c8304Vk.a().size()) {
            arrayList.add(new N15.b(c8304Vk2, true));
            return;
        }
        List listA = c8304Vk2.a();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listA, 10));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C14339hl) it.next()).e());
        }
        List listA2 = c8304Vk.a();
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(listA2, 10));
        Iterator it2 = listA2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((C14339hl) it2.next()).e());
        }
        if (!AbstractC13042fc3.d(arrayList2, arrayList3)) {
            arrayList.add(new N15.c(c8304Vk2));
            return;
        }
        int size = c8304Vk2.a().size();
        for (int i = 0; i < size; i++) {
            if (!AbstractC13042fc3.d(((C14339hl) c8304Vk2.a().get(i)).c(), ((C14339hl) c8304Vk.a().get(i)).c()) || ((C14339hl) c8304Vk2.a().get(i)).d().j().L() != ((C14339hl) c8304Vk.a().get(i)).d().j().L()) {
                arrayList.add(new N15.b(c8304Vk2, false));
                return;
            }
        }
    }

    private final AV2 d1() {
        return (AV2) this.Y.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.ArrayList f1(ir.nasim.C8967Xz7 r8, ir.nasim.C8967Xz7 r9, ir.nasim.AbstractC23538x54 r10) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P64.f1(ir.nasim.Xz7, ir.nasim.Xz7, ir.nasim.x54):java.util.ArrayList");
    }

    private static final void g1(ArrayList arrayList, C9663aL5 c9663aL5, N15 n15) {
        c9663aL5.a = n15.a() || c9663aL5.a;
        arrayList.add(n15);
    }

    private final int i1() {
        return (int) (this.w.getResources().getDisplayMetrics().heightPixels * 0.55d);
    }

    private final void n1(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        boolean z6 = z || z2;
        if (!this.B && !this.D) {
            z5 = false;
        }
        this.B = z;
        this.D = z2;
        if (z5 != z6) {
            d1().h(z6, z3);
        }
        this.G = z4;
        C8967Xz7 c8967Xz7 = this.A;
        if (c8967Xz7 != null) {
            InterfaceC20284rl0 interfaceC20284rl0 = this.x;
            C20882sl7 c20882sl7 = interfaceC20284rl0 instanceof C20882sl7 ? (C20882sl7) interfaceC20284rl0 : null;
            if (c20882sl7 != null) {
                c20882sl7.S0(z4, c8967Xz7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AV2 o1(P64 p64) {
        AbstractC13042fc3.i(p64, "this$0");
        View view = p64.a;
        AbstractC13042fc3.h(view, "itemView");
        return new AV2(view, 0, 2, null);
    }

    private final View q1(boolean z) {
        View view = this.w;
        view.setOnClickListener(null);
        view.setOnLongClickListener(null);
        if (!z) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.K64
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return P64.s1(this.a, view2, motionEvent);
                }
            });
        } else if (this.x instanceof NM) {
            view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L64
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    P64.t1(this.a, view2);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.M64
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return P64.u1(this.a, view2);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N64
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    P64.x1(this.a, view2);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.O64
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return P64.r1(this.a, view2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1(P64 p64, View view) {
        AbstractC13042fc3.i(p64, "this$0");
        SA2 sa2B = p64.H.b();
        if (sa2B == null) {
            return false;
        }
        sa2B.invoke();
        C19938rB7 c19938rB7 = C19938rB7.a;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s1(P64 p64, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(p64, "this$0");
        AbstractC5770Kt3.b(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
        return p64.J.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(P64 p64, View view) {
        AbstractC13042fc3.i(p64, "this$0");
        ((NM) p64.x).X1().f.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u1(P64 p64, View view) {
        AbstractC13042fc3.i(p64, "this$0");
        SA2 sa2B = p64.H.b();
        if (sa2B == null) {
            return false;
        }
        sa2B.invoke();
        C19938rB7 c19938rB7 = C19938rB7.a;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(P64 p64, View view) {
        AbstractC13042fc3.i(p64, "this$0");
        SA2 sa2A = p64.H.a();
        if (sa2A != null) {
        }
    }

    protected void V0(C8967Xz7 c8967Xz7, Spannable spannable, boolean z, boolean z2, boolean z3, AbstractC23538x54 abstractC23538x54, boolean z4) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
        n1(z2, z3, false, z4);
        this.x.o(c8967Xz7, AbstractC4616Fw7.a(Integer.valueOf(j1(C0)), Integer.valueOf(i1())), this.z);
        this.Z.addAccessibilityStateChangeListener(this.z0);
        q1(this.Z.isTouchExplorationEnabled());
        this.x.w(this.w, c8967Xz7);
    }

    @Override // ir.nasim.AbstractC19821r0
    public void a() {
        this.A = null;
        this.x.a();
        this.B = false;
        this.D = false;
        this.G = false;
        this.H.f();
        d1().i();
        this.Z.removeAccessibilityStateChangeListener(this.z0);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        return this.x.b();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void e() {
        this.x.e();
    }

    public final C8967Xz7 e1() {
        return this.A;
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void f() {
        this.x.f();
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public List g() {
        return this.x.g();
    }

    public final void i() {
        this.x.i();
    }

    public abstract int j1(int i);

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return this.x.l();
    }

    public final boolean l1(C19672qk7 c19672qk7) {
        List listA;
        if (c19672qk7 == null || (listA = c19672qk7.a()) == null) {
            return false;
        }
        List list = listA;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List listA2 = ((C20281rk7) it.next()).a();
            if (!(listA2 instanceof Collection) || !listA2.isEmpty()) {
                Iterator it2 = listA2.iterator();
                while (it2.hasNext()) {
                    if (((G73) it2.next()) instanceof G73.h) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void n() {
        this.x.n();
    }

    public final void p1(C8967Xz7 c8967Xz7, Spannable spannable, boolean z, boolean z2, boolean z3, AbstractC23538x54 abstractC23538x54) {
        List listA;
        List listA2;
        List listA3;
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
        boolean z4 = z2 || T0(c8967Xz7.f());
        boolean z5 = C8386Vt0.a.L5() && z4;
        C8967Xz7 c8967Xz72 = this.A;
        if (c8967Xz72 == null) {
            this.A = c8967Xz7;
            V0(c8967Xz7, spannable, z, z4, z3, abstractC23538x54, z5);
            W0();
            return;
        }
        if (!U0(c8967Xz7, c8967Xz72)) {
            V0(c8967Xz7, spannable, z, z4, z3, abstractC23538x54, z5);
            this.A = c8967Xz7;
            W0();
            return;
        }
        ArrayList arrayListF1 = f1(c8967Xz7, c8967Xz72, abstractC23538x54);
        S0(arrayListF1, z4, z3, z5);
        if (!(arrayListF1 instanceof Collection) || !arrayListF1.isEmpty()) {
            Iterator it = arrayListF1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((N15) it.next()).a()) {
                    arrayListF1.add(new N15.g(c8967Xz7.e()));
                    break;
                }
            }
        }
        if (!(true ^ arrayListF1.isEmpty())) {
            if (AbstractC13042fc3.d(c8967Xz7.j(), c8967Xz72.j())) {
                return;
            }
            C19406qI3.j("MessageHolder", "onDataChanged: An unsupported payload in message holder", new Object[0]);
            V0(c8967Xz7, spannable, z, z4, z3, abstractC23538x54, z5);
            return;
        }
        Iterator it2 = arrayListF1.iterator();
        while (it2.hasNext()) {
            z((N15) it2.next());
        }
        this.A = c8967Xz7;
        W0();
        C19672qk7 c19672qk7S = c8967Xz7.s();
        Integer numValueOf = (c19672qk7S == null || (listA3 = c19672qk7S.a()) == null) ? null : Integer.valueOf(listA3.size());
        C19672qk7 c19672qk7S2 = c8967Xz72.s();
        if (AbstractC13042fc3.d(numValueOf, (c19672qk7S2 == null || (listA2 = c19672qk7S2.a()) == null) ? null : Integer.valueOf(listA2.size()))) {
            C19672qk7 c19672qk7S3 = c8967Xz7.s();
            if (c19672qk7S3 == null || (listA = c19672qk7S3.a()) == null) {
                return;
            }
            C19672qk7 c19672qk7S4 = c8967Xz72.s();
            if (listA.equals(c19672qk7S4 != null ? c19672qk7S4.a() : null)) {
                return;
            }
        }
        V0(c8967Xz7, spannable, z, z4, z3, abstractC23538x54, z5);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void u() {
        this.x.u();
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void v() {
        this.x.v();
    }

    protected void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (!(n15 instanceof N15.t)) {
            this.x.z(n15);
        } else {
            N15.t tVar = (N15.t) n15;
            n1(tVar.d(), tVar.c(), true, tVar.b());
        }
    }
}
