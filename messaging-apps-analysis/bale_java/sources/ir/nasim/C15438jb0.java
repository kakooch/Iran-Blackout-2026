package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C15438jb0;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.root.RootActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001KB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lir/nasim/jb0;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/content/Context;", "context", "Lir/nasim/rB7;", "Da", "(Landroid/content/Context;)V", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "Ca", "(Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;)V", "Lir/nasim/vb0;", "ha", "()Lir/nasim/vb0;", "i9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/Zi4;", "h1", "Lir/nasim/Zi4;", "Aa", "()Lir/nasim/Zi4;", "setMonitoringListItemProvider$settings_productionRelease", "(Lir/nasim/Zi4;)V", "monitoringListItemProvider", "Lir/nasim/aO2;", "i1", "Lir/nasim/aO2;", "za", "()Lir/nasim/aO2;", "setGroupTypeMakerNavigator", "(Lir/nasim/aO2;)V", "groupTypeMakerNavigator", "Lir/nasim/dQ0;", "j1", "Lir/nasim/dQ0;", "ya", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/TP;", "k1", "Lir/nasim/TP;", "xa", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "Lir/nasim/Mz;", "l1", "Lir/nasim/Mz;", "wa", "()Lir/nasim/Mz;", "setApiModule", "(Lir/nasim/Mz;)V", "apiModule", "Lir/nasim/Kc0;", "m1", "Lir/nasim/Yu3;", "Ba", "()Lir/nasim/Kc0;", "viewModel", "n1", "a", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.jb0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C15438jb0 extends RV2 {
    public static final int o1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC9300Zi4 monitoringListItemProvider;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC9687aO2 groupTypeMakerNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public TP authNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public C6287Mz apiModule;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.jb0$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C22642vb0 b;

        /* renamed from: ir.nasim.jb0$b$a */
        static final class a implements InterfaceC16978mB2 {
            final /* synthetic */ C15438jb0 a;
            final /* synthetic */ C22642vb0 b;

            /* renamed from: ir.nasim.jb0$b$a$a, reason: collision with other inner class name */
            static final class C1323a implements InterfaceC14603iB2 {
                final /* synthetic */ C15438jb0 a;
                final /* synthetic */ C22642vb0 b;

                /* renamed from: ir.nasim.jb0$b$a$a$a, reason: collision with other inner class name */
                static final class C1324a implements InterfaceC14603iB2 {
                    final /* synthetic */ C15438jb0 a;
                    final /* synthetic */ C22642vb0 b;

                    C1324a(C15438jb0 c15438jb0, C22642vb0 c22642vb0) {
                        this.a = c15438jb0;
                        this.b = c22642vb0;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 o(C15438jb0 c15438jb0, EnumC6196Mo7 enumC6196Mo7) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        AbstractC13042fc3.i(enumC6196Mo7, "newThemeMode");
                        c15438jb0.Ba().p1(enumC6196Mo7);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C17637nI7 p(C15438jb0 c15438jb0, int i) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        return c15438jb0.Ba().y1(i);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean t(C15438jb0 c15438jb0) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        return c15438jb0.Ba().l1();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 v(C15438jb0 c15438jb0, boolean z) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        c15438jb0.Ba().o1(z);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 w(C15438jb0 c15438jb0, int i) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        c15438jb0.Ba().N1(i);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 x(C15438jb0 c15438jb0) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        c15438jb0.Ba().P1();
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 y(C15438jb0 c15438jb0) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        c15438jb0.Ba().A1();
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 z(C15438jb0 c15438jb0) {
                        AbstractC13042fc3.i(c15438jb0, "this$0");
                        c15438jb0.Q7().onBackPressed();
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        n((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }

                    public final void n(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        InterfaceC9664aL6 interfaceC9664aL6X1 = this.a.Ba().x1();
                        C22642vb0 c22642vb0 = this.b;
                        interfaceC22053ub1.W(1295695267);
                        boolean zD = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb0 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new UA2() { // from class: ir.nasim.lb0
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C15438jb0.b.a.C1323a.C1324a.o(c15438jb0, (EnumC6196Mo7) obj);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        UA2 ua2 = (UA2) objB;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295700619);
                        boolean zD2 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb02 = this.a;
                        Object objB2 = interfaceC22053ub1.B();
                        if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new UA2() { // from class: ir.nasim.mb0
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C15438jb0.b.a.C1323a.C1324a.w(c15438jb02, ((Integer) obj).intValue());
                                }
                            };
                            interfaceC22053ub1.s(objB2);
                        }
                        UA2 ua22 = (UA2) objB2;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295703498);
                        boolean zD3 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb03 = this.a;
                        Object objB3 = interfaceC22053ub1.B();
                        if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                            objB3 = new SA2() { // from class: ir.nasim.nb0
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C15438jb0.b.a.C1323a.C1324a.x(c15438jb03);
                                }
                            };
                            interfaceC22053ub1.s(objB3);
                        }
                        SA2 sa2 = (SA2) objB3;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295692988);
                        boolean zD4 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb04 = this.a;
                        Object objB4 = interfaceC22053ub1.B();
                        if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                            objB4 = new SA2() { // from class: ir.nasim.ob0
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C15438jb0.b.a.C1323a.C1324a.y(c15438jb04);
                                }
                            };
                            interfaceC22053ub1.s(objB4);
                        }
                        SA2 sa22 = (SA2) objB4;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295706183);
                        boolean zD5 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb05 = this.a;
                        Object objB5 = interfaceC22053ub1.B();
                        if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                            objB5 = new SA2() { // from class: ir.nasim.pb0
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C15438jb0.b.a.C1323a.C1324a.z(c15438jb05);
                                }
                            };
                            interfaceC22053ub1.s(objB5);
                        }
                        SA2 sa23 = (SA2) objB5;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295710555);
                        boolean zD6 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb06 = this.a;
                        Object objB6 = interfaceC22053ub1.B();
                        if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                            objB6 = new UA2() { // from class: ir.nasim.qb0
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C15438jb0.b.a.C1323a.C1324a.p(c15438jb06, ((Integer) obj).intValue());
                                }
                            };
                            interfaceC22053ub1.s(objB6);
                        }
                        UA2 ua23 = (UA2) objB6;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295714284);
                        boolean zD7 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb07 = this.a;
                        Object objB7 = interfaceC22053ub1.B();
                        if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                            objB7 = new SA2() { // from class: ir.nasim.rb0
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return Boolean.valueOf(C15438jb0.b.a.C1323a.C1324a.t(c15438jb07));
                                }
                            };
                            interfaceC22053ub1.s(objB7);
                        }
                        SA2 sa24 = (SA2) objB7;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(1295718323);
                        boolean zD8 = interfaceC22053ub1.D(this.a);
                        final C15438jb0 c15438jb08 = this.a;
                        Object objB8 = interfaceC22053ub1.B();
                        if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                            objB8 = new UA2() { // from class: ir.nasim.sb0
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C15438jb0.b.a.C1323a.C1324a.v(c15438jb08, ((Boolean) obj).booleanValue());
                                }
                            };
                            interfaceC22053ub1.s(objB8);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC18994pc0.T(interfaceC9664aL6X1, c22642vb0, ua2, ua22, sa2, sa22, sa23, ua23, sa24, (UA2) objB8, interfaceC22053ub1, 0);
                    }
                }

                C1323a(C15438jb0 c15438jb0, C22642vb0 c22642vb0) {
                    this.a = c15438jb0;
                    this.b = c22642vb0;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC11024cc1.a(AbstractC11270cj4.c().d(this.a.Aa()), AbstractC19242q11.e(-464033135, true, new C1324a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C15438jb0 c15438jb0, C22642vb0 c22642vb0) {
                this.a = c15438jb0;
                this.b = c22642vb0;
            }

            public final void a(defpackage.p pVar, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(pVar, "$this$CircularReveal");
                if ((i & 48) == 0) {
                    i |= interfaceC22053ub1.a(z) ? 32 : 16;
                }
                if ((i & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    M10.f(z, AbstractC19242q11.e(1093416785, true, new C1323a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, ((i >> 3) & 14) | 48, 0);
                }
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                a((defpackage.p) obj, ((Boolean) obj2).booleanValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        b(C22642vb0 c22642vb0) {
            this.b = c22642vb0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C15438jb0 c15438jb0) {
            AbstractC13042fc3.i(c15438jb0, "this$0");
            FragmentActivity fragmentActivityQ7 = c15438jb0.Q7();
            RootActivity rootActivity = fragmentActivityQ7 instanceof RootActivity ? (RootActivity) fragmentActivityQ7 : null;
            if (rootActivity != null) {
                rootActivity.v5();
            }
            c15438jb0.Ba().m1(((C3254Ac0) c15438jb0.Ba().x1().getValue()).k());
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Boolean boolValueOf = Boolean.valueOf(((C3254Ac0) C15438jb0.this.Ba().x1().getValue()).k().q());
            C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(SIPTransactionStack.BASE_TIMER_INTERVAL, 0, null, 6, null);
            interfaceC22053ub1.W(1494041156);
            boolean zD = interfaceC22053ub1.D(C15438jb0.this);
            final C15438jb0 c15438jb0 = C15438jb0.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.kb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C15438jb0.b.c(c15438jb0);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            defpackage.m.d(boolValueOf, null, c7479Rw7L, (SA2) objB, AbstractC19242q11.e(-1911576404, true, new a(C15438jb0.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 24960, 2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.jb0$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.jb0$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.jb0$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.jb0$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.jb0$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C15438jb0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C5614Kc0.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5614Kc0 Ba() {
        return (C5614Kc0) this.viewModel.getValue();
    }

    private final void Ca(C11458d25 peer, ExPeerType exPeerType) {
        PP0.a.b(Long.valueOf(System.currentTimeMillis()));
        C22042ua0.A9(this, InterfaceC11677dQ0.b(ya(), peer, exPeerType, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217724, null), false, null, 6, null);
    }

    private final void Da(Context context) {
        n8(TP.b(xa(), null, context, null, 5, null));
    }

    private final C22642vb0 ha() {
        return new C22642vb0(new SA2() { // from class: ir.nasim.Va0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.ia(this.a);
            }
        }, new SA2() { // from class: ir.nasim.cb0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.oa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.db0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.pa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.eb0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.qa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.fb0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.sa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.gb0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.ta(this.a);
            }
        }, new SA2() { // from class: ir.nasim.hb0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.ua(this.a);
            }
        }, new SA2() { // from class: ir.nasim.ib0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.ja(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Wa0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15438jb0.ka(this.a);
            }
        }, new UA2() { // from class: ir.nasim.Xa0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15438jb0.la(this.a, ((Integer) obj).intValue());
            }
        }, new UA2() { // from class: ir.nasim.ab0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15438jb0.ma(this.a, (Fragment) obj);
            }
        }, new UA2() { // from class: ir.nasim.bb0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15438jb0.na(this.a, (InterfaceC13356g53) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        C22042ua0.A9(c15438jb0, new C22923w3(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        C22042ua0.A9(c15438jb0, new C3579Bl5(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        c15438jb0.Ba().E1();
        c15438jb0.wa().J();
        Context contextS7 = c15438jb0.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        c15438jb0.Da(contextS7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(C15438jb0 c15438jb0, int i) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        c15438jb0.Ba().F1(i);
        c15438jb0.Ba().R1(i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(C15438jb0 c15438jb0, Fragment fragment) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        AbstractC13042fc3.i(fragment, "fragment");
        C22042ua0.w9(c15438jb0, fragment, false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(C15438jb0 c15438jb0, InterfaceC13356g53 interfaceC13356g53) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        AbstractC13042fc3.i(interfaceC13356g53, "inAppUpdateUiAction");
        c15438jb0.Ba().z1(interfaceC13356g53);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        C22042ua0.A9(c15438jb0, new C15053iv6(), false, null, 6, null);
        c15438jb0.Ba().G1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        c15438jb0.Ca(c15438jb0.Ba().v1(), ExPeerType.PRIVATE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(final C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        c15438jb0.Ba().B1(new InterfaceC14603iB2() { // from class: ir.nasim.Ya0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C15438jb0.ra(this.a, (C11458d25) obj, (ExPeerType) obj2);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C15438jb0 c15438jb0, C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, "exPeer");
        c15438jb0.Ca(c11458d25, exPeerType);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        C22042ua0.A9(c15438jb0, c15438jb0.za().a(ZN2.GROUP), false, "GroupTypeMakerFragment", 2, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        C22042ua0.A9(c15438jb0, c15438jb0.za().a(ZN2.CHANNEL), false, "GroupTypeMakerFragment", 2, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(final C15438jb0 c15438jb0) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        c15438jb0.Ba().C1(new InterfaceC14603iB2() { // from class: ir.nasim.Za0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C15438jb0.va(this.a, (C11458d25) obj, (ExPeerType) obj2);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C15438jb0 c15438jb0, C11458d25 c11458d25, ExPeerType exPeerType) {
        AbstractC13042fc3.i(c15438jb0, "this$0");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, "exPeer");
        c15438jb0.Ca(c11458d25, exPeerType);
        return C19938rB7.a;
    }

    public final InterfaceC9300Zi4 Aa() {
        InterfaceC9300Zi4 interfaceC9300Zi4 = this.monitoringListItemProvider;
        if (interfaceC9300Zi4 != null) {
            return interfaceC9300Zi4;
        }
        AbstractC13042fc3.y("monitoringListItemProvider");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        C22642vb0 c22642vb0Ha = ha();
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(656394973, true, new b(c22642vb0Ha)));
        return composeView;
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        Ba().q1();
        super.i9();
    }

    public final C6287Mz wa() {
        C6287Mz c6287Mz = this.apiModule;
        if (c6287Mz != null) {
            return c6287Mz;
        }
        AbstractC13042fc3.y("apiModule");
        return null;
    }

    public final TP xa() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }

    public final InterfaceC11677dQ0 ya() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    public final InterfaceC9687aO2 za() {
        InterfaceC9687aO2 interfaceC9687aO2 = this.groupTypeMakerNavigator;
        if (interfaceC9687aO2 != null) {
            return interfaceC9687aO2;
        }
        AbstractC13042fc3.y("groupTypeMakerNavigator");
        return null;
    }
}
