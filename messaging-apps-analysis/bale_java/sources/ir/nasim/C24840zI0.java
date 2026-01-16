package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AJ0;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C24840zI0;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.sharedmedia.ui.state.ChangeNickErrorState;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00018B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJE\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b#\u0010$Jm\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00112\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006<²\u0006\u0017\u0010;\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b:098\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/zI0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ma", "Lir/nasim/qG6;", "snackBarState", "ka", "(Lir/nasim/qG6;)V", "", "selectedOption", "", "isError", "", "errorMessage", "id", "Lkotlin/Function1;", "onIdChange", "ea", "(Ljava/lang/String;ZLjava/lang/Throwable;Ljava/lang/String;Lir/nasim/UA2;Lir/nasim/ub1;I)V", "Lkotlin/Function0;", "onSnackBarStateShow", "la", "(Lir/nasim/SA2;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/W06;", "restriction", "onOptionChanged", "snackBarMessage", "Y9", "(Lir/nasim/W06;Ljava/lang/String;Lir/nasim/UA2;Lir/nasim/UA2;ZLjava/lang/Throwable;Ljava/lang/String;Lir/nasim/qG6;Lir/nasim/ub1;II)V", "Lir/nasim/KI0;", "h1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/KI0;", "viewModel", "Lir/nasim/Ex2;", "i1", "Lir/nasim/bW7;", "ha", "()Lir/nasim/Ex2;", "binding", "j1", "a", "", "Lkotlin/jvm/internal/EnhancedNullability;", "radioOptions", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.zI0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24840zI0 extends AbstractC9759aW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C24840zI0.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentChangeGroupRestrictionBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.zI0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C24840zI0 a(W06 w06, ZN2 zn2, int i, String str, String str2) {
            AbstractC13042fc3.i(w06, "restriction");
            AbstractC13042fc3.i(zn2, "type");
            AbstractC13042fc3.i(str, "name");
            C24840zI0 c24840zI0 = new C24840zI0();
            XV4 xv4A = AbstractC4616Fw7.a("RESTRICTION", w06);
            XV4 xv4A2 = AbstractC4616Fw7.a("GROUP_TYPE", zn2);
            XV4 xv4A3 = AbstractC4616Fw7.a("PEER_ID_ARG", Integer.valueOf(i));
            XV4 xv4A4 = AbstractC4616Fw7.a("NAME_OF_GROUP", str);
            if (!(true ^ (str2 == null || str2.length() == 0))) {
                str2 = null;
            }
            c24840zI0.a8(AbstractC23348wm0.b(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("DEFAULT_ID", str2)));
            return c24840zI0;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zI0$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC3630Br2 a;

        b(InterfaceC3630Br2 interfaceC3630Br2) {
            this.a = interfaceC3630Br2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
            AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
            InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.AI0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C24840zI0.b.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zI0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable c;
        final /* synthetic */ C9023Yd6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Throwable th, C9023Yd6 c9023Yd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = th;
            this.d = c9023Yd6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c != null) {
                    C9023Yd6 c9023Yd6 = this.d;
                    int iN = c9023Yd6.n();
                    this.b = 1;
                    if (C9023Yd6.l(c9023Yd6, iN, null, this, 2, null) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zI0$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
            AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
            interfaceC15254jG6.dismiss();
            return C19938rB7.a;
        }

        public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String str = this.a;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.a;
            interfaceC22053ub1.W(-590694674);
            boolean z = (i & 14) == 4;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.BI0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C24840zI0.d.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10984cY.c(str2, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zI0$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ Throwable b;
        final /* synthetic */ C24840zI0 c;
        final /* synthetic */ String d;
        final /* synthetic */ UA2 e;

        e(boolean z, Throwable th, C24840zI0 c24840zI0, String str, UA2 ua2) {
            this.a = z;
            this.b = th;
            this.c = c24840zI0;
            this.d = str;
            this.e = ua2;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC14472hy4 dVar;
            String strC;
            String strA;
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            boolean z = this.a;
            Throwable th = this.b;
            C24840zI0 c24840zI0 = this.c;
            String str = this.d;
            UA2 ua2 = this.e;
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
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.create_channel_id_hint_text, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1, i3).b().c()), g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).b(), interfaceC22053ub1, 0, 0, 65016);
            interfaceC22053ub1.W(-314137178);
            if (z) {
                Integer numValueOf = Integer.valueOf(KB5.icon_danger_circle);
                if (th instanceof ChangeNickErrorState.InvalidChannelInput) {
                    interfaceC22053ub1.W(-1148132761);
                    i2 = 0;
                    strA = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.create_channel_ID_invalid_input, interfaceC22053ub1, 0), c24840zI0.ia().e1());
                    interfaceC22053ub1.Q();
                } else {
                    i2 = 0;
                    if (th instanceof ChangeNickErrorState.InvalidChannelNick) {
                        interfaceC22053ub1.W(-1147893658);
                        strA = UY6.c(AbstractC12217eE5.invalid_channel_ID_error, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else if (th instanceof ChangeNickErrorState.ForbiddenNick) {
                        interfaceC22053ub1.W(-1147720058);
                        strA = UY6.c(AbstractC12217eE5.invalid_channel_ID_error, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(-1147600305);
                        strA = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.create_channel_ID_error, interfaceC22053ub1, 0), c24840zI0.ia().e1());
                        interfaceC22053ub1.Q();
                    }
                }
                dVar = new AbstractC14472hy4.a(numValueOf, strA, null, 4, null);
            } else {
                i2 = 0;
                dVar = new AbstractC14472hy4.d(null, null, null, 7, null);
            }
            AbstractC14472hy4 abstractC14472hy4 = dVar;
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null);
            ZN2 zn2E1 = c24840zI0.ia().e1();
            ZN2 zn2 = ZN2.CHANNEL;
            if (zn2E1 == zn2) {
                interfaceC22053ub1.W(-1146948809);
                strC = UY6.c(AbstractC12217eE5.create_channel_id_label, interfaceC22053ub1, i2);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1146845982);
                strC = UY6.c(AbstractC12217eE5.create_group_id_label, interfaceC22053ub1, i2);
                interfaceC22053ub1.Q();
            }
            AbstractC8426Vx4.H(str, ua2, strC, c24840zI0.ia().e1() == zn2 ? "Channel Id" : "Group Id", eVarK, false, abstractC14472hy4, true, 0, 0, null, null, interfaceC22053ub1, (AbstractC14472hy4.a << 18) | 12582912, 0, 3872);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zI0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C19391qG6 c19391qG6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19391qG6 c19391qG6 = this.c;
                this.b = 1;
                if (C19391qG6.f(c19391qG6, "", null, false, null, this, 14, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zI0$g */
    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 b;

        /* renamed from: ir.nasim.zI0$g$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C24840zI0 a;
            final /* synthetic */ C19391qG6 b;

            /* renamed from: ir.nasim.zI0$g$a$a, reason: collision with other inner class name */
            /* synthetic */ class C1807a extends EB2 implements UA2 {
                C1807a(Object obj) {
                    super(1, obj, KI0.class, "setId", "setId(Ljava/lang/String;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IOException {
                    y((String) obj);
                    return C19938rB7.a;
                }

                public final void y(String str) throws IOException {
                    AbstractC13042fc3.i(str, "p0");
                    ((KI0) this.receiver).m1(str);
                }
            }

            /* renamed from: ir.nasim.zI0$g$a$b */
            /* synthetic */ class b extends EB2 implements UA2 {
                b(Object obj) {
                    super(1, obj, KI0.class, "setType", "setType(Lir/nasim/core/modules/profile/entity/Restriction;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((W06) obj);
                    return C19938rB7.a;
                }

                public final void y(W06 w06) {
                    AbstractC13042fc3.i(w06, "p0");
                    ((KI0) this.receiver).o1(w06);
                }
            }

            a(C24840zI0 c24840zI0, C19391qG6 c19391qG6) {
                this.a = c24840zI0;
                this.b = c19391qG6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.ia().c1(), null, interfaceC22053ub1, 0, 1);
                String strE = ((MI0) interfaceC9664aL6B.getValue()).e();
                KI0 ki0Ia = this.a.ia();
                interfaceC22053ub1.W(1226264236);
                boolean zD = interfaceC22053ub1.D(ki0Ia);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1807a(ki0Ia);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                interfaceC22053ub1.Q();
                KI0 ki0Ia2 = this.a.ia();
                interfaceC22053ub1.W(1226266030);
                boolean zD2 = interfaceC22053ub1.D(ki0Ia2);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(ki0Ia2);
                    interfaceC22053ub1.s(objB2);
                }
                InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB2;
                interfaceC22053ub1.Q();
                boolean z = ((MI0) interfaceC9664aL6B.getValue()).c() instanceof AJ0.a;
                AJ0 aj0C = ((MI0) interfaceC9664aL6B.getValue()).c();
                AJ0.a aVar = aj0C instanceof AJ0.a ? (AJ0.a) aj0C : null;
                this.a.Y9(this.a.ia().g1(), strE, (UA2) interfaceC16733lm3, (UA2) interfaceC16733lm32, z, aVar != null ? aVar.a() : null, (String) AbstractC10222bH6.a(this.a.ia().h1(), null, null, interfaceC22053ub1, 48, 2).getValue(), this.b, interfaceC22053ub1, 0, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        g(C19391qG6 c19391qG6) {
            this.b = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-674499292, true, new a(C24840zI0.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zI0$h */
    static final class h implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.zI0$h$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C24840zI0 a;
            final /* synthetic */ SA2 b;

            a(C24840zI0 c24840zI0, SA2 sa2) {
                this.a = c24840zI0;
                this.b = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(SA2 sa2, final C24840zI0 c24840zI0, InterfaceC9664aL6 interfaceC9664aL6) {
                AbstractC13042fc3.i(sa2, "$onSnackBarStateShow");
                AbstractC13042fc3.i(c24840zI0, "this$0");
                AbstractC13042fc3.i(interfaceC9664aL6, "$state");
                sa2.invoke();
                if (c24840zI0.ia().d1() != null) {
                    W06 w06G1 = c24840zI0.ia().g1();
                    W06 w06 = W06.PUBLIC;
                    if (w06G1 == w06 && ((MI0) interfaceC9664aL6.getValue()).d() == w06 && AbstractC13042fc3.d(((MI0) interfaceC9664aL6.getValue()).e(), c24840zI0.ia().d1())) {
                        AbstractC18623oy2.c(c24840zI0, "CHANNEL_NICK_CHANGED", AbstractC23348wm0.b(AbstractC4616Fw7.a("EXTRA_NICK_CHANGED", Boolean.FALSE)));
                        c24840zI0.Q7().onBackPressed();
                        c24840zI0.ha().c.clearFocus();
                        return C19938rB7.a;
                    }
                }
                c24840zI0.ia().Z0(((MI0) interfaceC9664aL6.getValue()).d(), ((MI0) interfaceC9664aL6.getValue()).e(), new SA2() { // from class: ir.nasim.DI0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24840zI0.h.a.f(c24840zI0);
                    }
                });
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C24840zI0 c24840zI0) {
                AbstractC13042fc3.i(c24840zI0, "this$0");
                AbstractC18623oy2.c(c24840zI0, "CHANNEL_NICK_CHANGED", AbstractC23348wm0.b(AbstractC4616Fw7.a("EXTRA_NICK_CHANGED", Boolean.TRUE)));
                c24840zI0.Q7().onBackPressed();
                c24840zI0.ha().c.clearFocus();
                return C19938rB7.a;
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x0162  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0170  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void c(ir.nasim.InterfaceC22053ub1 r20, int r21) {
                /*
                    Method dump skipped, instructions count: 405
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24840zI0.h.a.c(ir.nasim.ub1, int):void");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        h(SA2 sa2) {
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1783917003, true, new a(C24840zI0.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zI0$i */
    public static final class i extends AbstractC8614Ws3 implements UA2 {
        public i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4386Ex2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.zI0$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.zI0$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.zI0$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.zI0$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.zI0$n */
    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C24840zI0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new k(new j(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(KI0.class), new l(interfaceC9173Yu3B), new m(null, interfaceC9173Yu3B), new n(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new i(), AbstractC20046rN7.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.f());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 aa(UA2 ua2, String str, UA2 ua22, C24840zI0 c24840zI0, InterfaceC3630Br2 interfaceC3630Br2) {
        AbstractC13042fc3.i(ua2, "$onOptionSelected");
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(ua22, "$onOptionChanged");
        AbstractC13042fc3.i(c24840zI0, "this$0");
        AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
        ua2.invoke(str);
        ua22.invoke(AbstractC13042fc3.d(str, c24840zI0.h6(AbstractC12217eE5.create_public_group)) ? W06.PUBLIC : W06.PRIVATE);
        InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(UA2 ua2, String str, UA2 ua22, C24840zI0 c24840zI0, InterfaceC3630Br2 interfaceC3630Br2) {
        AbstractC13042fc3.i(ua2, "$onOptionSelected");
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(ua22, "$onOptionChanged");
        AbstractC13042fc3.i(c24840zI0, "this$0");
        AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
        ua2.invoke(str);
        ua22.invoke(AbstractC13042fc3.d(str, c24840zI0.h6(AbstractC12217eE5.create_public_group)) ? W06.PUBLIC : W06.PRIVATE);
        InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(C24840zI0 c24840zI0, W06 w06, String str, UA2 ua2, UA2 ua22, boolean z, Throwable th, String str2, C19391qG6 c19391qG6, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c24840zI0, "$tmp4_rcvr");
        AbstractC13042fc3.i(w06, "$restriction");
        AbstractC13042fc3.i(str, "$id");
        AbstractC13042fc3.i(ua2, "$onIdChange");
        AbstractC13042fc3.i(ua22, "$onOptionChanged");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        c24840zI0.Y9(w06, str, ua2, ua22, z, th, str2, c19391qG6, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    private static final List da(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (List) interfaceC9102Ym4.getValue();
    }

    private final void ea(final String str, final boolean z, final Throwable th, final String str2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(100614333);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(th) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 131072 : 65536;
        }
        if ((i3 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC22231ut.f(AbstractC13042fc3.d(str, UY6.c(AbstractC12217eE5.create_public_group, interfaceC22053ub1J, 0)) && (C8386Vt0.a.D9() || ia().e1() == ZN2.CHANNEL), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(-279133467, true, new e(z, th, this, str2, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 200064, 18);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yI0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C24840zI0.fa(this.a, str, z, th, str2, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fa(C24840zI0 c24840zI0, String str, boolean z, Throwable th, String str2, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c24840zI0, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$selectedOption");
        AbstractC13042fc3.i(str2, "$id");
        AbstractC13042fc3.i(ua2, "$onIdChange");
        c24840zI0.ea(str, z, th, str2, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4386Ex2 ha() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4386Ex2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C24840zI0 c24840zI0, C19391qG6 c19391qG6) {
        AbstractC13042fc3.i(c24840zI0, "this$0");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        AbstractC10533bm0.d(AbstractC19224pz3.a(c24840zI0), null, null, new f(c19391qG6, null), 3, null);
        return C19938rB7.a;
    }

    private final void ka(C19391qG6 snackBarState) {
        ha().c.setContent(AbstractC19242q11.c(1314956287, true, new g(snackBarState)));
    }

    private final void la(SA2 onSnackBarStateShow) {
        ha().d.setContent(AbstractC19242q11.c(-1984477872, true, new h(onSnackBarStateShow)));
    }

    private final void ma() {
        BaleToolbar baleToolbar = ha().e;
        baleToolbar.setTitle(ia().e1() == ZN2.GROUP ? AbstractC12217eE5.features_sharedmedia_type_group : AbstractC12217eE5.features_sharedmedia_type_channel);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C4386Ex2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0813  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0887  */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y9(final ir.nasim.W06 r49, final java.lang.String r50, final ir.nasim.UA2 r51, final ir.nasim.UA2 r52, final boolean r53, final java.lang.Throwable r54, java.lang.String r55, final ir.nasim.C19391qG6 r56, ir.nasim.InterfaceC22053ub1 r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 2214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24840zI0.Y9(ir.nasim.W06, java.lang.String, ir.nasim.UA2, ir.nasim.UA2, boolean, java.lang.Throwable, java.lang.String, ir.nasim.qG6, ir.nasim.ub1, int, int):void");
    }

    public final KI0 ia() {
        return (KI0) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        final C19391qG6 c19391qG6 = new C19391qG6();
        ma();
        ka(c19391qG6);
        la(new SA2() { // from class: ir.nasim.tI0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24840zI0.ja(this.a, c19391qG6);
            }
        });
    }
}
