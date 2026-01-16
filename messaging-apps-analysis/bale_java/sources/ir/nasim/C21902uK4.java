package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21902uK4;
import ir.nasim.IK4;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.JK4;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006*²\u0006\u0012\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/uK4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "V9", "", "peerId", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "peerType", "Lir/nasim/d25;", "U9", "(ILir/nasim/core/modules/profile/entity/ExPeerType;)Lir/nasim/d25;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "a", "()Z", "Lir/nasim/Ry2;", "h1", "Lir/nasim/Ry2;", "binding", "Lir/nasim/KK4;", "i1", "Lir/nasim/Yu3;", "W9", "()Lir/nasim/KK4;", "viewModel", "j1", "Lir/nasim/JK4;", "Lir/nasim/JK4$b;", "uiState", "onboarding_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.uK4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21902uK4 extends AbstractC17767nX2 {

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private C7492Ry2 binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.uK4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C21902uK4 a(OnboardingSpot onboardingSpot, int i) {
            AbstractC13042fc3.i(onboardingSpot, "onboardingSpot");
            C21902uK4 c21902uK4 = new C21902uK4();
            Bundle bundle = new Bundle();
            bundle.putParcelable("onboarding_spot", onboardingSpot);
            bundle.putInt("scenario_id", i);
            c21902uK4.a8(bundle);
            return c21902uK4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uK4$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.uK4$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.uK4$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C21902uK4 a;

            /* renamed from: ir.nasim.uK4$c$a$a, reason: collision with other inner class name */
            static final class C1631a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C21902uK4 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1631a(C21902uK4 c21902uK4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c21902uK4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1631a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.W9().Z0(IK4.c.a);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1631a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.uK4$c$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C21902uK4 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C21902uK4 c21902uK4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c21902uK4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.W9().Z0(IK4.f.a);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.uK4$c$a$c, reason: collision with other inner class name */
            static final class C1632c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C21902uK4 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1632c(C21902uK4 c21902uK4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c21902uK4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1632c(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.W9().Z0(IK4.f.a);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1632c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.uK4$c$a$d */
            static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C21902uK4 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(C21902uK4 c21902uK4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c21902uK4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.W9().Z0(IK4.f.a);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(C21902uK4 c21902uK4) {
                this.a = c21902uK4;
            }

            private static final JK4 n(InterfaceC9664aL6 interfaceC9664aL6) {
                return (JK4) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(C21902uK4 c21902uK4, OnboardingPeer.ContactsChannel contactsChannel) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                AbstractC13042fc3.i(contactsChannel, "it");
                c21902uK4.W9().Z0(new IK4.b(contactsChannel.getPeerData().getPeerId(), contactsChannel.getPeerData().getPeerType(), null, 4, null));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C21902uK4 c21902uK4) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                c21902uK4.a();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 t(C21902uK4 c21902uK4, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
                c21902uK4.W9().Z0(new IK4.b(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType(), null, 4, null));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 v(C21902uK4 c21902uK4, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
                C11458d25 c11458d25U9 = c21902uK4.U9(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType());
                C18987pb3.x1(C18987pb3.a, c11458d25U9, null, null, false, null, null, false, null, null, false, new EmptyStateOnboardingItemAction.Opened(emptyStateSuggestedPeer.getButtonText(), emptyStateSuggestedPeer.getDescription(), L72.b), 1022, null);
                c21902uK4.W9().Z0(new IK4.e(emptyStateSuggestedPeer.getPeerData().getPeerId()));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 w(C21902uK4 c21902uK4) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                c21902uK4.a();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 x(C21902uK4 c21902uK4, OnboardingPeer.SuggestedPeer suggestedPeer) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                AbstractC13042fc3.i(suggestedPeer, "it");
                c21902uK4.W9().Z0(new IK4.b(suggestedPeer.getPeerData().getPeerId(), suggestedPeer.getPeerData().getPeerType(), null, 4, null));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C21902uK4 c21902uK4) {
                AbstractC13042fc3.i(c21902uK4, "this$0");
                c21902uK4.a();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                k((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }

            public final void k(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.W9().Y0(), null, interfaceC22053ub1, 0, 1);
                C19938rB7 c19938rB7 = C19938rB7.a;
                interfaceC22053ub1.W(1674904415);
                boolean zD = interfaceC22053ub1.D(this.a);
                C21902uK4 c21902uK4 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1631a(c21902uK4, null);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                JK4.b bVarE = n(interfaceC9664aL6B).e();
                if (bVarE instanceof JK4.b.c) {
                    interfaceC22053ub1.W(382651182);
                    JK4 jk4 = new JK4(n(interfaceC9664aL6B).c(), bVarE, n(interfaceC9664aL6B).d());
                    interfaceC22053ub1.W(1674923262);
                    boolean zD2 = interfaceC22053ub1.D(this.a);
                    final C21902uK4 c21902uK42 = this.a;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.vK4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C21902uK4.c.a.w(c21902uK42);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa2 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1674928005);
                    boolean zD3 = interfaceC22053ub1.D(this.a);
                    final C21902uK4 c21902uK43 = this.a;
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.wK4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C21902uK4.c.a.x(c21902uK43, (OnboardingPeer.SuggestedPeer) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    Y07.i(jk4, new C25038zd6(sa2, (UA2) objB3, null, null, 12, null), interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(1674943232);
                    boolean zD4 = interfaceC22053ub1.D(this.a);
                    C21902uK4 c21902uK44 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new C1632c(c21902uK44, null);
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 6);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (bVarE instanceof JK4.b.a) {
                    interfaceC22053ub1.W(383816844);
                    JK4 jk42 = new JK4(n(interfaceC9664aL6B).c(), bVarE, n(interfaceC9664aL6B).d());
                    interfaceC22053ub1.W(1674960926);
                    boolean zD5 = interfaceC22053ub1.D(this.a);
                    final C21902uK4 c21902uK45 = this.a;
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new SA2() { // from class: ir.nasim.xK4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C21902uK4.c.a.y(c21902uK45);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    SA2 sa22 = (SA2) objB5;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1674965669);
                    boolean zD6 = interfaceC22053ub1.D(this.a);
                    final C21902uK4 c21902uK46 = this.a;
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new UA2() { // from class: ir.nasim.yK4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C21902uK4.c.a.o(c21902uK46, (OnboardingPeer.ContactsChannel) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC25073zh1.i(jk42, new C25038zd6(sa22, (UA2) objB6, null, null, 12, null), interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(1674980896);
                    boolean zD7 = interfaceC22053ub1.D(this.a);
                    C21902uK4 c21902uK47 = this.a;
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                        objB7 = new d(c21902uK47, null);
                        interfaceC22053ub1.s(objB7);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB7, interfaceC22053ub1, 6);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (bVarE instanceof JK4.b.C0444b) {
                    interfaceC22053ub1.W(384954637);
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
                    InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar.a();
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    interfaceC22053ub1.W(-465114980);
                    if (n(interfaceC9664aL6B).c() instanceof JK4.a.b) {
                        AbstractC14445hv5.e(null, 0.0f, 0.0f, 0L, 0L, interfaceC22053ub1, 0, 31);
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    return;
                }
                if (bVarE instanceof JK4.b.d) {
                    interfaceC22053ub1.W(385541529);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!(bVarE instanceof JK4.b.e)) {
                    interfaceC22053ub1.W(1674912145);
                    interfaceC22053ub1.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1.W(385690732);
                JK4 jk43 = new JK4(n(interfaceC9664aL6B).c(), bVarE, n(interfaceC9664aL6B).d());
                interfaceC22053ub1.W(1675019838);
                boolean zD8 = interfaceC22053ub1.D(this.a);
                final C21902uK4 c21902uK48 = this.a;
                Object objB8 = interfaceC22053ub1.B();
                if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.zK4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C21902uK4.c.a.p(c21902uK48);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                SA2 sa23 = (SA2) objB8;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1675024601);
                boolean zD9 = interfaceC22053ub1.D(this.a);
                final C21902uK4 c21902uK49 = this.a;
                Object objB9 = interfaceC22053ub1.B();
                if (zD9 || objB9 == InterfaceC22053ub1.a.a()) {
                    objB9 = new UA2() { // from class: ir.nasim.AK4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C21902uK4.c.a.t(c21902uK49, (OnboardingPeer.EmptyStateSuggestedPeer) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                UA2 ua2 = (UA2) objB9;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1675039788);
                boolean zD10 = interfaceC22053ub1.D(this.a);
                final C21902uK4 c21902uK410 = this.a;
                Object objB10 = interfaceC22053ub1.B();
                if (zD10 || objB10 == InterfaceC22053ub1.a.a()) {
                    objB10 = new UA2() { // from class: ir.nasim.BK4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C21902uK4.c.a.v(c21902uK410, (OnboardingPeer.EmptyStateSuggestedPeer) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB10);
                }
                interfaceC22053ub1.Q();
                AbstractC16293l17.o(jk43, new C25038zd6(sa23, ua2, (UA2) objB10, null, 8, null), interfaceC22053ub1, 0);
                interfaceC22053ub1.W(1675077056);
                boolean zD11 = interfaceC22053ub1.D(this.a);
                C21902uK4 c21902uK411 = this.a;
                Object objB11 = interfaceC22053ub1.B();
                if (zD11 || objB11 == InterfaceC22053ub1.a.a()) {
                    objB11 = new b(c21902uK411, null);
                    interfaceC22053ub1.s(objB11);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB11, interfaceC22053ub1, 6);
                interfaceC22053ub1.Q();
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1064920018, true, new a(C21902uK4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uK4$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.uK4$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.uK4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.uK4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.uK4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    public C21902uK4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(KK4.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C11458d25 U9(int peerId, ExPeerType peerType) {
        int i = peerType == null ? -1 : b.a[peerType.ordinal()];
        if (i == 1 || i == 2) {
            C11458d25 c11458d25E = C11458d25.E(peerId);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            return c11458d25E;
        }
        C11458d25 c11458d25Y = C11458d25.y(peerId);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        return c11458d25Y;
    }

    private final void V9() {
        if (u6()) {
            V5().s().p(this).h();
            V5().k1();
            Q7().B0().s().p(this).h();
            Q7().B0().k1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KK4 W9() {
        return (KK4) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C7492Ry2 c7492Ry2C = C7492Ry2.c(inflater, container, false);
        this.binding = c7492Ry2C;
        if (c7492Ry2C == null) {
            AbstractC13042fc3.y("binding");
            c7492Ry2C = null;
        }
        ComposeView root = c7492Ry2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        W9().Z0(IK4.a.a);
        V9();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        C7492Ry2 c7492Ry2 = this.binding;
        C7492Ry2 c7492Ry22 = null;
        if (c7492Ry2 == null) {
            AbstractC13042fc3.y("binding");
            c7492Ry2 = null;
        }
        c7492Ry2.getRoot().setViewCompositionStrategy(v.d.b);
        C7492Ry2 c7492Ry23 = this.binding;
        if (c7492Ry23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c7492Ry22 = c7492Ry23;
        }
        c7492Ry22.getRoot().setContent(AbstractC19242q11.c(1870665687, true, new c()));
    }
}
