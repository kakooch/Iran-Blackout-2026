package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC22767vn5;
import ir.nasim.C14345hl5;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017²\u0006\u000e\u0010\u0014\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u00020\u00158\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/hl5;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/Nn5;", "h1", "Lir/nasim/Yu3;", "T9", "()Lir/nasim/Nn5;", "viewModel", "", "dialogState", "Lir/nasim/fl5;", "state", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.hl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14345hl5 extends AbstractC24383yX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6424Nn5.class), new b(this), new c(null, this), new d(this));

    /* renamed from: ir.nasim.hl5$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.hl5$a$a, reason: collision with other inner class name */
        static final class C1279a implements InterfaceC14603iB2 {
            final /* synthetic */ C14345hl5 a;

            /* renamed from: ir.nasim.hl5$a$a$a, reason: collision with other inner class name */
            static final class C1280a implements InterfaceC14603iB2 {
                final /* synthetic */ C14345hl5 a;

                C1280a(C14345hl5 c14345hl5) {
                    this.a = c14345hl5;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C14345hl5 c14345hl5) {
                    AbstractC13042fc3.i(c14345hl5, "this$0");
                    c14345hl5.Q7().z2().l();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String strC = UY6.c(QD5.base_premium_feat_title, interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(1441937188);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C14345hl5 c14345hl5 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.gl5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C14345hl5.a.C1279a.C1280a.c(c14345hl5);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC21639ts7.i(strC, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.hl5$a$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ C14345hl5 a;

                /* renamed from: ir.nasim.hl5$a$a$b$a, reason: collision with other inner class name */
                static final class C1281a implements SA2 {
                    final /* synthetic */ InterfaceC9102Ym4 a;

                    C1281a(InterfaceC9102Ym4 interfaceC9102Ym4) {
                        this.a = interfaceC9102Ym4;
                    }

                    public final void a() {
                        b.p(this.a, true);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.hl5$a$a$b$b, reason: collision with other inner class name */
                public static final class C1282b extends AbstractC8614Ws3 implements UA2 {
                    public static final C1282b e = new C1282b();

                    public C1282b() {
                        super(1);
                    }

                    @Override // ir.nasim.UA2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Void invoke(Object obj) {
                        return null;
                    }
                }

                /* renamed from: ir.nasim.hl5$a$a$b$c */
                public static final class c extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ UA2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public c(UA2 ua2, List list) {
                        super(1);
                        this.e = ua2;
                        this.f = list;
                    }

                    public final Object a(int i) {
                        return this.e.invoke(this.f.get(i));
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.hl5$a$a$b$d */
                public static final class d extends AbstractC8614Ws3 implements UA2 {
                    final /* synthetic */ UA2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public d(UA2 ua2, List list) {
                        super(1);
                        this.e = ua2;
                        this.f = list;
                    }

                    public final Object a(int i) {
                        return this.e.invoke(this.f.get(i));
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return a(((Number) obj).intValue());
                    }
                }

                /* renamed from: ir.nasim.hl5$a$a$b$e */
                public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                    final /* synthetic */ List e;
                    final /* synthetic */ InterfaceC9102Ym4 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public e(List list, InterfaceC9102Ym4 interfaceC9102Ym4) {
                        super(4);
                        this.e = list;
                        this.f = interfaceC9102Ym4;
                    }

                    public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                        int i3;
                        if ((i2 & 6) == 0) {
                            i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
                        } else {
                            i3 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                        }
                        if (!interfaceC22053ub1.o((i3 & 147) != 146, 1 & i3)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        C4950Hg2 c4950Hg2 = (C4950Hg2) this.e.get(i);
                        interfaceC22053ub1.W(1686291555);
                        e.a aVar = androidx.compose.ui.e.a;
                        InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                        InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar2.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                        C9784aZ0 c9784aZ0 = C9784aZ0.a;
                        interfaceC22053ub1.W(385113336);
                        boolean zV = interfaceC22053ub1.V(this.f);
                        Object objB = interfaceC22053ub1.B();
                        if (zV || objB == InterfaceC22053ub1.a.a()) {
                            objB = new C1281a(this.f);
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC23933xl5.e(c4950Hg2, (SA2) objB, interfaceC22053ub1, 0);
                        MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
                        interfaceC22053ub1.u();
                        interfaceC22053ub1.Q();
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC16978mB2
                    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                        a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                        return C19938rB7.a;
                    }
                }

                b(C14345hl5 c14345hl5) {
                    this.a = c14345hl5;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final InterfaceC9102Ym4 i() {
                    return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
                /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
                /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
                public static final C19938rB7 k(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC15069ix3 interfaceC15069ix3) {
                    ?? M;
                    List listA;
                    AbstractC13042fc3.i(interfaceC9664aL6, "$state$delegate");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
                    AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                    AbstractC22767vn5 abstractC22767vn5D = v(interfaceC9664aL6).d();
                    AbstractC22767vn5.d dVar = abstractC22767vn5D instanceof AbstractC22767vn5.d ? (AbstractC22767vn5.d) abstractC22767vn5D : null;
                    if (dVar == null || (listA = dVar.a()) == null) {
                        M = AbstractC10360bX0.m();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = listA.iterator();
                        while (it.hasNext()) {
                            AbstractC13610gX0.D(arrayList, ((C6167Ml5) it.next()).e());
                        }
                        HashSet hashSet = new HashSet();
                        M = new ArrayList();
                        for (Object obj : arrayList) {
                            if (hashSet.add(Long.valueOf(((C4950Hg2) obj).e()))) {
                                M.add(obj);
                            }
                        }
                    }
                    interfaceC15069ix3.a(M.size(), new c(new UA2() { // from class: ir.nasim.ll5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return C14345hl5.a.C1279a.b.n((C4950Hg2) obj2);
                        }
                    }, M), new d(C1282b.e, M), AbstractC19242q11.c(-632812321, true, new e(M, interfaceC9102Ym4)));
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Object n(C4950Hg2 c4950Hg2) {
                    AbstractC13042fc3.i(c4950Hg2, "it");
                    return Long.valueOf(c4950Hg2.e());
                }

                private static final boolean o(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void p(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
                    interfaceC9102Ym4.setValue(Boolean.valueOf(z));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 t(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
                    p(interfaceC9102Ym4, false);
                    return C19938rB7.a;
                }

                private static final C13161fl5 v(InterfaceC9664aL6 interfaceC9664aL6) {
                    return (C13161fl5) interfaceC9664aL6.getValue();
                }

                public final void h(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    int i2;
                    AbstractC13042fc3.i(ts4, "paddingValues");
                    if ((i & 6) == 0) {
                        i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
                    C14345hl5 c14345hl5 = this.a;
                    InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                    InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar2.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    C9784aZ0 c9784aZ0 = C9784aZ0.a;
                    Object[] objArr = new Object[0];
                    interfaceC22053ub1.W(1876569755);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
                    if (objB == aVar3.a()) {
                        objB = new SA2() { // from class: ir.nasim.il5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C14345hl5.a.C1279a.b.i();
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
                    interfaceC22053ub1.W(1876573537);
                    if (o(interfaceC9102Ym4)) {
                        interfaceC22053ub1.W(1876577533);
                        boolean zV = interfaceC22053ub1.V(interfaceC9102Ym4);
                        Object objB2 = interfaceC22053ub1.B();
                        if (zV || objB2 == aVar3.a()) {
                            objB2 = new SA2() { // from class: ir.nasim.jl5
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C14345hl5.a.C1279a.b.t(interfaceC9102Ym4);
                                }
                            };
                            interfaceC22053ub1.s(objB2);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC7851Tl5.c((SA2) objB2, interfaceC22053ub1, 0);
                    }
                    interfaceC22053ub1.Q();
                    final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(c14345hl5.T9().b1(), null, null, null, interfaceC22053ub1, 0, 7);
                    AbstractC5232Il5.c(UY6.c(QD5.base_premium_feat_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                    androidx.compose.ui.e eVarB = ZY0.b(c9784aZ0, aVar, 1.0f, false, 2, null);
                    interfaceC22053ub1.W(1876588527);
                    boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.V(interfaceC9102Ym4);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zV2 || objB3 == aVar3.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.kl5
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C14345hl5.a.C1279a.b.k(interfaceC9664aL6C, interfaceC9102Ym4, (InterfaceC15069ix3) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC12623ev3.b(eVarB, null, null, false, null, null, null, false, null, (UA2) objB3, interfaceC22053ub1, 0, 510);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    h((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C1279a(C14345hl5 c14345hl5) {
                this.a = c14345hl5;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(1139822308, true, new C1280a(this.a), interfaceC22053ub1, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, null, AbstractC19242q11.e(-2105423239, true, new b(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 805306422, 444);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1374175016, true, new C1279a(C14345hl5.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hl5$b */
    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.hl5$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.hl5$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6424Nn5 T9() {
        return (C6424Nn5) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        T9().d1();
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-335484733, true, new a()));
        return composeView;
    }
}
