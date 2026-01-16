package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24849zJ0;
import ir.nasim.C21753u45;
import ir.nasim.C24254yJ;
import ir.nasim.C5516Jr1;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.TC2;
import ir.nasim.W23;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.payment.view.fragment.y;
import ir.nasim.group.create.creategroup.ChannelIdError;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001VB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J¡\u0001\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000f2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u0019\u0010\u001aJE\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u001c\u0010\u001dJU\u0010#\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0003¢\u0006\u0004\b#\u0010$J=\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0004\b(\u0010)J5\u0010*\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0003¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J+\u00104\u001a\u0002032\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b4\u00105J!\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b7\u00108R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lir/nasim/Jr1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Ka", "Ma", "La", "Fa", "Lkotlin/Function0;", "onImagePickerClicked", "onRemovePickerClicked", "", "image", "name", "Lkotlin/Function1;", "onNameChange", "id", "", "isError", "", "errorMessage", "onIdChange", "Lir/nasim/OM2;", "onOptionChanged", "ha", "(Lir/nasim/SA2;Lir/nasim/SA2;Ljava/lang/String;Ljava/lang/String;Lir/nasim/UA2;Ljava/lang/String;ZLjava/lang/Throwable;Lir/nasim/UA2;Lir/nasim/UA2;Lir/nasim/ub1;III)V", "selectedOption", "oa", "(Ljava/lang/String;ZLjava/lang/Throwable;Ljava/lang/String;Lir/nasim/UA2;Lir/nasim/ub1;I)V", "", "radioOptions", "onOptionSelected", "Lir/nasim/Br2;", "localFocusManager", "xa", "(Ljava/util/List;Lir/nasim/UA2;Lir/nasim/UA2;Ljava/lang/String;Lir/nasim/Br2;Lir/nasim/ub1;I)V", "Landroidx/compose/ui/focus/m;", "focusRequester", "error", "qa", "(Landroidx/compose/ui/focus/m;Ljava/lang/String;Lir/nasim/UA2;Ljava/lang/Throwable;Lir/nasim/ub1;I)V", "ta", "(Ljava/lang/String;Lir/nasim/SA2;Lir/nasim/SA2;Lir/nasim/ub1;I)V", "Na", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/kD2;", "h1", "Lir/nasim/kD2;", "Ia", "()Lir/nasim/kD2;", "setGalleryNavigator", "(Lir/nasim/kD2;)V", "galleryNavigator", "Lir/nasim/Vi1;", "i1", "Lir/nasim/Vi1;", "Ha", "()Lir/nasim/Vi1;", "setContactsNavigator", "(Lir/nasim/Vi1;)V", "contactsNavigator", "Lir/nasim/Ux2;", "j1", "Lir/nasim/bW7;", "Ga", "()Lir/nasim/Ux2;", "binding", "Lir/nasim/Pr1;", "k1", "Lir/nasim/Yu3;", "Ja", "()Lir/nasim/Pr1;", "viewModel", "l1", "a", "group_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Jr1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5516Jr1 extends AbstractC17167mW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC15814kD2 galleryNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC8288Vi1 contactsNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(C5516Jr1.class, "binding", "getBinding()Lir/nasim/group/databinding/FragmentCreateGroupOrChannelBinding;", 0))};

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: ir.nasim.Jr1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C5516Jr1 a(ZN2 zn2) {
            AbstractC13042fc3.i(zn2, "type");
            C5516Jr1 c5516Jr1 = new C5516Jr1();
            c5516Jr1.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("groupTypeKey", zn2)));
            return c5516Jr1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Jr1$b */
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
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.Kr1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C5516Jr1.b.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Jr1$c */
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

    /* renamed from: ir.nasim.Jr1$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ boolean b;
        final /* synthetic */ Throwable c;
        final /* synthetic */ String d;
        final /* synthetic */ UA2 e;

        d(boolean z, Throwable th, String str, UA2 ua2) {
            this.b = z;
            this.c = th;
            this.d = str;
            this.e = ua2;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC14472hy4 dVar;
            int i3;
            String strA;
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            C5516Jr1 c5516Jr1 = C5516Jr1.this;
            boolean z = this.b;
            Throwable th = this.c;
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
            int i4 = G10.b;
            AbstractC9339Zm7.b(UY6.c(c5516Jr1.Ja().U0() == ZN2.GROUP ? HD5.create_group_id_hint_text : HD5.create_channel_id_hint_text, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1, i4).b().c()), g10.a(interfaceC22053ub1, i4).z(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 0, 0, 65016);
            interfaceC22053ub1.W(-2072371982);
            if (z) {
                Integer numValueOf = Integer.valueOf(AbstractC17572nB5.icon_danger_circle);
                if (th instanceof ChannelIdError.InvalidChannelInput) {
                    interfaceC22053ub1.W(181157490);
                    i2 = 0;
                    strA = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.create_channel_ID_invalid_input, interfaceC22053ub1, 0), c5516Jr1.Ja().U0());
                    interfaceC22053ub1.Q();
                } else {
                    i2 = 0;
                    if (th instanceof ChannelIdError.InvalidChannelNick) {
                        interfaceC22053ub1.W(181382271);
                        strA = UY6.c(AbstractC12217eE5.invalid_channel_ID_error, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else if (th instanceof ChannelIdError.ForbiddenNick) {
                        interfaceC22053ub1.W(181558847);
                        strA = UY6.c(AbstractC12217eE5.invalid_channel_ID_error, interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                    } else {
                        interfaceC22053ub1.W(181686970);
                        strA = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.create_channel_ID_error, interfaceC22053ub1, 0), c5516Jr1.Ja().U0());
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
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i4).b().c(), 0.0f, 2, null);
            ZN2 zn2U0 = c5516Jr1.Ja().U0();
            ZN2 zn2 = ZN2.CHANNEL;
            if (zn2U0 == zn2) {
                interfaceC22053ub1.W(-2072328423);
                i3 = HD5.create_channel_id_label;
            } else {
                interfaceC22053ub1.W(-2072326697);
                i3 = HD5.create_group_id_label;
            }
            String strC = UY6.c(i3, interfaceC22053ub1, i2);
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.H(str, ua2, strC, c5516Jr1.Ja().U0() == zn2 ? "Channel Id" : "Group Id", eVarK, false, abstractC14472hy4, true, 0, 0, null, "COMPOSE_NODE_NICK_TEXT_FIELD_TAG", interfaceC22053ub1, (AbstractC14472hy4.a << 18) | 12582912, 48, 1824);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Jr1$e */
    static final class e implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Jr1$e$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5516Jr1 a;

            /* renamed from: ir.nasim.Jr1$e$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0452a extends EB2 implements SA2 {
                C0452a(Object obj) {
                    super(0, obj, C5516Jr1.class, "attachAvatar", "attachAvatar()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C5516Jr1) this.receiver).Fa();
                }
            }

            /* renamed from: ir.nasim.Jr1$e$a$b */
            /* synthetic */ class b extends EB2 implements SA2 {
                b(Object obj) {
                    super(0, obj, C6950Pr1.class, "removePhoto", "removePhoto()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C6950Pr1) this.receiver).X0();
                }
            }

            /* renamed from: ir.nasim.Jr1$e$a$c */
            /* synthetic */ class c extends EB2 implements UA2 {
                c(Object obj) {
                    super(1, obj, C6950Pr1.class, "setName", "setName(Ljava/lang/String;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((String) obj);
                    return C19938rB7.a;
                }

                public final void y(String str) {
                    AbstractC13042fc3.i(str, "p0");
                    ((C6950Pr1) this.receiver).Z0(str);
                }
            }

            /* renamed from: ir.nasim.Jr1$e$a$d */
            /* synthetic */ class d extends EB2 implements UA2 {
                d(Object obj) {
                    super(1, obj, C6950Pr1.class, "setId", "setId(Ljava/lang/String;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IOException {
                    y((String) obj);
                    return C19938rB7.a;
                }

                public final void y(String str) throws IOException {
                    AbstractC13042fc3.i(str, "p0");
                    ((C6950Pr1) this.receiver).Y0(str);
                }
            }

            /* renamed from: ir.nasim.Jr1$e$a$e, reason: collision with other inner class name */
            /* synthetic */ class C0453e extends EB2 implements UA2 {
                C0453e(Object obj) {
                    super(1, obj, C6950Pr1.class, "setType", "setType(Lir/nasim/group/create/creategroupchannel/model/GroupRestriction;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((OM2) obj);
                    return C19938rB7.a;
                }

                public final void y(OM2 om2) {
                    AbstractC13042fc3.i(om2, "p0");
                    ((C6950Pr1) this.receiver).a1(om2);
                }
            }

            a(C5516Jr1 c5516Jr1) {
                this.a = c5516Jr1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.Ja().V0(), null, interfaceC22053ub1, 0, 1);
                C5516Jr1 c5516Jr1 = this.a;
                interfaceC22053ub1.W(-2007662676);
                boolean zD = interfaceC22053ub1.D(c5516Jr1);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0452a(c5516Jr1);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                interfaceC22053ub1.Q();
                C6950Pr1 c6950Pr1Ja = this.a.Ja();
                interfaceC22053ub1.W(-2007660748);
                boolean zD2 = interfaceC22053ub1.D(c6950Pr1Ja);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(c6950Pr1Ja);
                    interfaceC22053ub1.s(objB2);
                }
                InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB2;
                interfaceC22053ub1.Q();
                String strC = ((C4693Gd6) interfaceC9664aL6B.getValue()).c();
                String strF = ((C4693Gd6) interfaceC9664aL6B.getValue()).f();
                C6950Pr1 c6950Pr1Ja2 = this.a.Ja();
                interfaceC22053ub1.W(-2007655312);
                boolean zD3 = interfaceC22053ub1.D(c6950Pr1Ja2);
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new c(c6950Pr1Ja2);
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB3;
                interfaceC22053ub1.Q();
                String strD = ((C4693Gd6) interfaceC9664aL6B.getValue()).d();
                C6950Pr1 c6950Pr1Ja3 = this.a.Ja();
                interfaceC22053ub1.W(-2007652082);
                boolean zD4 = interfaceC22053ub1.D(c6950Pr1Ja3);
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new d(c6950Pr1Ja3);
                    interfaceC22053ub1.s(objB4);
                }
                InterfaceC16733lm3 interfaceC16733lm34 = (InterfaceC16733lm3) objB4;
                interfaceC22053ub1.Q();
                C6950Pr1 c6950Pr1Ja4 = this.a.Ja();
                interfaceC22053ub1.W(-2007650288);
                boolean zD5 = interfaceC22053ub1.D(c6950Pr1Ja4);
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new C0453e(c6950Pr1Ja4);
                    interfaceC22053ub1.s(objB5);
                }
                InterfaceC16733lm3 interfaceC16733lm35 = (InterfaceC16733lm3) objB5;
                interfaceC22053ub1.Q();
                boolean z = ((C4693Gd6) interfaceC9664aL6B.getValue()).e() instanceof AbstractC24849zJ0.a;
                AbstractC24849zJ0 abstractC24849zJ0E = ((C4693Gd6) interfaceC9664aL6B.getValue()).e();
                AbstractC24849zJ0.a aVar = abstractC24849zJ0E instanceof AbstractC24849zJ0.a ? (AbstractC24849zJ0.a) abstractC24849zJ0E : null;
                this.a.ha((SA2) interfaceC16733lm3, (SA2) interfaceC16733lm32, strC, strF, (UA2) interfaceC16733lm33, strD, z, aVar != null ? aVar.a() : null, (UA2) interfaceC16733lm34, (UA2) interfaceC16733lm35, interfaceC22053ub1, 0, 0, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        e() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-627373362, true, new a(C5516Jr1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Jr1$f */
    static final class f implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Jr1$f$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5516Jr1 a;

            a(C5516Jr1 c5516Jr1) {
                this.a = c5516Jr1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C5516Jr1 c5516Jr1) {
                AbstractC13042fc3.i(c5516Jr1, "this$0");
                InterfaceC8288Vi1 interfaceC8288Vi1Ha = c5516Jr1.Ha();
                String strF = ((C4693Gd6) c5516Jr1.Ja().V0().getValue()).f();
                OM2 om2G = ((C4693Gd6) c5516Jr1.Ja().V0().getValue()).g();
                OM2 om2 = OM2.c;
                C22042ua0 c22042ua0C = InterfaceC8288Vi1.c(interfaceC8288Vi1Ha, strF, null, (om2G != om2 || AbstractC13042fc3.d(((C4693Gd6) c5516Jr1.Ja().V0().getValue()).d(), "Group Id") || AbstractC13042fc3.d(((C4693Gd6) c5516Jr1.Ja().V0().getValue()).d(), "Channel Id")) ? null : ((C4693Gd6) c5516Jr1.Ja().V0().getValue()).d(), ((C4693Gd6) c5516Jr1.Ja().V0().getValue()).c(), c5516Jr1.Ja().U0(), ((C4693Gd6) c5516Jr1.Ja().V0().getValue()).g() == om2, EnumC6357Ng1.c, null, false, false, null, false, null, 8064, null);
                c5516Jr1.Ga().c.clearFocus();
                C22042ua0.A9(c5516Jr1, c22042ua0C, false, null, 6, null);
                return C19938rB7.a;
            }

            /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x014e  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void b(ir.nasim.InterfaceC22053ub1 r18, int r19) {
                /*
                    Method dump skipped, instructions count: 405
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5516Jr1.f.a.b(ir.nasim.ub1, int):void");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-971911693, true, new a(C5516Jr1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Jr1$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C8190Ux2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Jr1$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Jr1$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Jr1$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Jr1$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Jr1$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C5516Jr1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6950Pr1.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C5516Jr1 c5516Jr1, List list, UA2 ua2, UA2 ua22, String str, InterfaceC3630Br2 interfaceC3630Br2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c5516Jr1, "$tmp0_rcvr");
        AbstractC13042fc3.i(list, "$radioOptions");
        AbstractC13042fc3.i(ua2, "$onOptionSelected");
        AbstractC13042fc3.i(ua22, "$onOptionChanged");
        AbstractC13042fc3.i(str, "$selectedOption");
        AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
        c5516Jr1.xa(list, ua2, ua22, str, interfaceC3630Br2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa() {
        if (AbstractC4043Dl1.a(S7(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.Q0(C21753u45.a, this, 1122, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
            return;
        }
        y.Companion companion = ir.nasim.features.payment.view.fragment.y.INSTANCE;
        com.google.android.material.bottomsheet.b bVarB = InterfaceC15814kD2.b(Ia(), AbstractC5969Lp4.f(), Ja().U0() == ZN2.GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL, "StoryAdderFragment", new TC2.a(false, false, false, null, 15, null), false, 16, null);
        FragmentManager fragmentManagerV5 = V5();
        AbstractC13042fc3.h(fragmentManagerV5, "getParentFragmentManager(...)");
        companion.b(bVarB, fragmentManagerV5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8190Ux2 Ga() {
        Object objA = this.binding.a(this, m1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C8190Ux2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6950Pr1 Ja() {
        return (C6950Pr1) this.viewModel.getValue();
    }

    private final void Ka() {
        Object obj;
        Object next;
        BaleToolbar baleToolbar = Ga().e;
        AbstractC13042fc3.h(baleToolbar, "toolbar");
        Iterator it = AbstractC24379yW7.b(baleToolbar).iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((View) next) instanceof AppCompatTextView) {
                    break;
                }
            }
        }
        View view = (View) next;
        BaleToolbar baleToolbar2 = Ga().e;
        AbstractC13042fc3.h(baleToolbar2, "toolbar");
        Iterator it2 = AbstractC24379yW7.b(baleToolbar2).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((View) next2) instanceof AppCompatImageButton) {
                obj = next2;
                break;
            }
        }
        View view2 = (View) obj;
        ComposeView composeView = Ga().c;
        AbstractC13042fc3.h(composeView, "composeView");
        ComposeView composeView2 = Ga().d;
        AbstractC13042fc3.h(composeView2, "okButton");
        if (view != null && view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        if (view2 != null && view2.getId() == -1) {
            view2.setId(View.generateViewId());
        }
        if (composeView.getId() == -1) {
            composeView.setId(View.generateViewId());
        }
        if (composeView2.getId() == -1) {
            composeView2.setId(View.generateViewId());
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (view != null) {
                view.setScreenReaderFocusable(true);
            }
            if (view2 != null) {
                view2.setScreenReaderFocusable(true);
            }
        }
        if (view != null) {
            view.setAccessibilityTraversalAfter(-1);
        }
        if (view2 != null) {
            view2.setAccessibilityTraversalAfter(view != null ? view.getId() : -1);
        }
        composeView.setAccessibilityTraversalAfter(view2 != null ? view2.getId() : -1);
        composeView2.setAccessibilityTraversalAfter(composeView.getId());
    }

    private final void La() {
        Ga().c.setContent(AbstractC19242q11.c(-92840151, true, new e()));
    }

    private final void Ma() {
        Ga().d.setContent(AbstractC19242q11.c(1613395854, true, new f()));
    }

    private final void Na() {
        BaleToolbar baleToolbar = Ga().e;
        baleToolbar.setTitle(Ja().U0() == ZN2.GROUP ? HD5.create_group : HD5.create_channel);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ha(ir.nasim.SA2 r42, ir.nasim.SA2 r43, final java.lang.String r44, final java.lang.String r45, ir.nasim.UA2 r46, final java.lang.String r47, boolean r48, java.lang.Throwable r49, ir.nasim.UA2 r50, ir.nasim.UA2 r51, ir.nasim.InterfaceC22053ub1 r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5516Jr1.ha(ir.nasim.SA2, ir.nasim.SA2, java.lang.String, java.lang.String, ir.nasim.UA2, java.lang.String, boolean, java.lang.Throwable, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(OM2 om2) {
        AbstractC13042fc3.i(om2, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C5516Jr1 c5516Jr1, SA2 sa2, SA2 sa22, String str, String str2, UA2 ua2, String str3, boolean z, Throwable th, UA2 ua22, UA2 ua23, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(c5516Jr1, "$tmp9_rcvr");
        AbstractC13042fc3.i(str2, "$name");
        AbstractC13042fc3.i(str3, "$id");
        c5516Jr1.ha(sa2, sa22, str, str2, ua2, str3, z, th, ua22, ua23, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    private final void oa(final String str, final boolean z, final Throwable th, final String str2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(804247597);
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
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC22231ut.f(AbstractC13042fc3.d(str, Y8(OM2.c.j())) && (C8386Vt0.a.D9() || Ja().U0() == ZN2.CHANNEL), null, androidx.compose.animation.f.m(null, null, false, null, 15, null), androidx.compose.animation.f.y(null, null, false, null, 15, null), null, AbstractC19242q11.e(280827653, true, new d(z, th, str2, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 200064, 18);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Cr1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C5516Jr1.pa(this.a, str, z, th, str2, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(C5516Jr1 c5516Jr1, String str, boolean z, Throwable th, String str2, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c5516Jr1, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$selectedOption");
        AbstractC13042fc3.i(str2, "$id");
        AbstractC13042fc3.i(ua2, "$onIdChange");
        c5516Jr1.oa(str, z, th, str2, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void qa(final androidx.compose.ui.focus.m mVar, final String str, final UA2 ua2, final Throwable th, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        AbstractC14472hy4 dVar;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-228729746);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(mVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(th) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.n.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1J, G10.b).b().c(), 0.0f, 2, null), mVar);
            if (str.length() >= 128) {
                interfaceC22053ub1J.W(-437854044);
                dVar = new AbstractC14472hy4.a(Integer.valueOf(AbstractC17572nB5.danger), UY6.c(HD5.name_limit_error_create_group, interfaceC22053ub1J, 0), null, 4, null);
                interfaceC22053ub1J.Q();
            } else if (th instanceof ChannelIdError.UsingAppName) {
                interfaceC22053ub1J.W(-437611686);
                dVar = new AbstractC14472hy4.a(Integer.valueOf(AbstractC17572nB5.danger), AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.group_error_wrong_group_title, interfaceC22053ub1J, 0), Ja().U0()), null, 4, null);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-437370289);
                dVar = new AbstractC14472hy4.d(Integer.valueOf(KB5.icon_danger_circle), UY6.c(AbstractC12217eE5.name_can_fa_or_en, interfaceC22053ub1J, 0), 128);
                interfaceC22053ub1J.Q();
            }
            AbstractC14472hy4 abstractC14472hy4 = dVar;
            ZN2 zn2U0 = Ja().U0();
            ZN2 zn2 = ZN2.GROUP;
            String strY8 = Y8(zn2U0 == zn2 ? HD5.create_group_name_title : HD5.create_channel_name_title);
            String strY82 = Y8(Ja().U0() == zn2 ? HD5.create_group_name_hint2 : HD5.create_channel_name_hint);
            interfaceC22053ub1J.W(-2092310001);
            boolean z = (i3 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Ar1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C5516Jr1.ra(ua2, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC8426Vx4.e0(str, (UA2) objB, strY8, strY82, eVarA, null, false, false, null, null, abstractC14472hy4, null, null, true, 0, 0, null, null, false, false, "COMPOSE_NODE_NAME_TEXT_FIELD_TAG", false, interfaceC22053ub1J, (i3 >> 3) & 14, AbstractC14472hy4.a | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6, 3136480);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Br1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C5516Jr1.sa(this.a, mVar, str, ua2, th, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(UA2 ua2, String str) {
        AbstractC13042fc3.i(ua2, "$onNameChange");
        AbstractC13042fc3.i(str, "it");
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C5516Jr1 c5516Jr1, androidx.compose.ui.focus.m mVar, String str, UA2 ua2, Throwable th, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c5516Jr1, "$tmp4_rcvr");
        AbstractC13042fc3.i(mVar, "$focusRequester");
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(ua2, "$onNameChange");
        c5516Jr1.qa(mVar, str, ua2, th, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void ta(final String str, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        boolean z;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-663548665);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (str == null || AbstractC20762sZ6.n0(str)) {
                interfaceC22053ub1J.W(496781209);
                androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(64)), N46.g());
                interfaceC22053ub1J.W(847313727);
                z = (i3 & 896) == 256;
                Object objB = interfaceC22053ub1J.B();
                if (z || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Hr1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5516Jr1.va(sa22);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarA, false, null, null, (SA2) objB, 7, null);
                G10 g10 = G10.a;
                int i4 = G10.b;
                AbstractC24667z03.b(FV4.c(AbstractC17572nB5.ic_add_photo_story, interfaceC22053ub1J, 0), UY6.c(HD5.create_group_photo_picker_content_desc, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i4).C(), null, 2, null), g10.c(interfaceC22053ub1J, i4).b().e()), g10.a(interfaceC22053ub1J, i4).G(), interfaceC22053ub1J, 0, 0);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(496192767);
                androidx.compose.ui.e eVarA2 = FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(64)), N46.g());
                interfaceC22053ub1J.W(847294976);
                z = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB2 = interfaceC22053ub1J.B();
                if (z || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Gr1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5516Jr1.ua(sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                coil.compose.d.a(new W23.a((Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g())).d(str).a(), AbstractC5969Lp4.a(UY6.c(HD5.create_group_photo_picker_content_desc, interfaceC22053ub1J, 0), Ja().U0()), androidx.compose.foundation.e.f(eVarA2, false, null, null, (SA2) objB2, 7, null), null, null, null, InterfaceC13157fl1.a.a(), 0.0f, null, 0, false, null, interfaceC22053ub1J, 1572864, 0, 4024);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ir1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C5516Jr1.wa(this.a, str, sa2, sa22, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onRemovePickerClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onImagePickerClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa(C5516Jr1 c5516Jr1, String str, SA2 sa2, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c5516Jr1, "$tmp2_rcvr");
        AbstractC13042fc3.i(sa2, "$onRemovePickerClicked");
        AbstractC13042fc3.i(sa22, "$onImagePickerClicked");
        c5516Jr1.ta(str, sa2, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void xa(final List list, final UA2 ua2, final UA2 ua22, final String str, final InterfaceC3630Br2 interfaceC3630Br2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub12;
        String strY8;
        InterfaceC3630Br2 interfaceC3630Br22 = interfaceC3630Br2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(812138983);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC3630Br22) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 131072 : 65536;
        }
        if ((74899 & i3) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            G10 g10 = G10.a;
            int i6 = G10.b;
            int i7 = 1;
            Object obj = null;
            AbstractC9339Zm7.b(Y8(Ja().U0() == ZN2.GROUP ? HD5.create_group_type : HD5.create_channel_type), androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i6).y(), null, 2, null), g10.c(interfaceC22053ub1J, i6).b().c(), g10.c(interfaceC22053ub1J, i6).b().u()), g10.a(interfaceC22053ub1J, i6).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i6).o(), interfaceC22053ub1J, 0, 0, 65016);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final String str2 = (String) it.next();
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, i7, obj);
                interfaceC22053ub1J.W(1339414656);
                boolean zV = ((i3 & 896) == 256) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.V(str2) | interfaceC22053ub1J.D(this) | interfaceC22053ub1J.D(interfaceC3630Br22);
                Object objB = interfaceC22053ub1J.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    i4 = 2048;
                    i5 = i3;
                    interfaceC22053ub12 = interfaceC22053ub1J;
                    objB = new SA2() { // from class: ir.nasim.Dr1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5516Jr1.ya(ua2, str2, ua22, this, interfaceC3630Br2);
                        }
                    };
                    interfaceC22053ub12.s(objB);
                } else {
                    i5 = i3;
                    interfaceC22053ub12 = interfaceC22053ub1J;
                    i4 = 2048;
                }
                interfaceC22053ub12.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
                G10 g102 = G10.a;
                int i8 = G10.b;
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarF, g102.c(interfaceC22053ub12, i8).b().c(), g102.c(interfaceC22053ub12, i8).b().e());
                interfaceC22053ub12.W(1339432318);
                boolean zV2 = interfaceC22053ub12.V(str2) | ((i5 & 7168) == i4) | interfaceC22053ub12.D(this);
                Object objB2 = interfaceC22053ub12.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Er1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return C5516Jr1.za(str2, str, this, (InterfaceC11943do6) obj2);
                        }
                    };
                    interfaceC22053ub12.s(objB2);
                }
                interfaceC22053ub12.Q();
                androidx.compose.ui.e eVarA = AbstractC6919Pn6.a(eVarJ, (UA2) objB2);
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.e eVarG = c24254yJ.g();
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.l(), interfaceC22053ub12, 54);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub12.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub12, eVarA);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
                if (!(interfaceC22053ub12.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub12.G();
                if (interfaceC22053ub12.h()) {
                    interfaceC22053ub12.g(sa2A);
                } else {
                    interfaceC22053ub12.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub12);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                M66 m66 = M66.a;
                InterfaceC22053ub1 interfaceC22053ub13 = interfaceC22053ub12;
                QF5.a(AbstractC13042fc3.d(str2, str), null, AbstractC3248Ab3.b(aVar), false, OF5.a.b(g102.a(interfaceC22053ub12, i8).I(), g102.a(interfaceC22053ub12, i8).B(), 0L, 0L, interfaceC22053ub13, OF5.b << 12, 12), null, interfaceC22053ub13, 432, 40);
                ZH6.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g102.c(interfaceC22053ub13, i8).b().c(), 0.0f, 0.0f, 13, null), interfaceC22053ub13, 0);
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub13, 0);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub13, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub13.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub13, aVar);
                SA2 sa2A2 = aVar3.a();
                if (!(interfaceC22053ub13.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub13.G();
                if (interfaceC22053ub13.h()) {
                    interfaceC22053ub13.g(sa2A2);
                } else {
                    interfaceC22053ub13.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub13);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                long jF = g102.a(interfaceC22053ub13, i8).F();
                C6399Nk7.a aVar4 = C6399Nk7.b;
                AbstractC9339Zm7.b(str2, null, jF, 0L, null, null, null, 0L, null, C6399Nk7.h(aVar4.f()), 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub13, i8).b(), interfaceC22053ub13, 0, 0, 65018);
                ZH6.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g102.c(interfaceC22053ub13, i8).b().n(), 0.0f, 0.0f, 13, null), interfaceC22053ub13, 0);
                long jZ = g102.a(interfaceC22053ub13, i8).z();
                int iF = aVar4.f();
                interfaceC22053ub13.W(2067584299);
                if (Ja().U0() != ZN2.GROUP) {
                    strY8 = AbstractC13042fc3.d(str2, Y8(OM2.c.j())) ? Y8(HD5.create_channel_public_desc) : Y8(HD5.create_channel_private_desc);
                } else if (!AbstractC13042fc3.d(str2, Y8(OM2.c.j()))) {
                    strY8 = Y8(HD5.create_group_private_desc);
                } else if (C8386Vt0.a.D9()) {
                    interfaceC22053ub13.W(-329218322);
                    strY8 = UY6.c(AbstractC12217eE5.create_group_public_desc_new, interfaceC22053ub13, 0);
                    interfaceC22053ub13.Q();
                } else {
                    interfaceC22053ub13.W(-329074761);
                    strY8 = UY6.c(AbstractC12217eE5.create_group_public_desc, interfaceC22053ub13, 0);
                    interfaceC22053ub13.Q();
                }
                String str3 = strY8;
                interfaceC22053ub13.Q();
                AbstractC9339Zm7.b(str3, null, jZ, 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub13, i8).d(), interfaceC22053ub13, 0, 0, 65018);
                interfaceC22053ub13.u();
                interfaceC22053ub13.u();
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g102.a(interfaceC22053ub13, i8).A(), interfaceC22053ub13, 6, 2);
                interfaceC22053ub1J = interfaceC22053ub13;
                i3 = i5;
                interfaceC3630Br22 = interfaceC3630Br2;
                obj = null;
                i7 = 1;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fr1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return C5516Jr1.Aa(this.a, list, ua2, ua22, str, interfaceC3630Br2, i2, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(UA2 ua2, String str, UA2 ua22, C5516Jr1 c5516Jr1, InterfaceC3630Br2 interfaceC3630Br2) {
        AbstractC13042fc3.i(ua2, "$onOptionSelected");
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(ua22, "$onOptionChanged");
        AbstractC13042fc3.i(c5516Jr1, "this$0");
        AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
        ua2.invoke(str);
        OM2 om2 = OM2.c;
        if (!AbstractC13042fc3.d(str, c5516Jr1.Y8(om2.j()))) {
            om2 = OM2.b;
        }
        ua22.invoke(om2);
        InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(String str, String str2, C5516Jr1 c5516Jr1, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$text");
        AbstractC13042fc3.i(str2, "$selectedOption");
        AbstractC13042fc3.i(c5516Jr1, "this$0");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        boolean zD = AbstractC13042fc3.d(str, str2);
        boolean zD2 = AbstractC13042fc3.d(str, c5516Jr1.Y8(OM2.c.j()));
        AbstractC9939ao6.e0(interfaceC11943do6, c5516Jr1.Y8(zD ? HD5.selected : HD5.not_selected) + "RadioButton, " + str + ", " + (c5516Jr1.Ja().U0() == ZN2.GROUP ? zD2 ? C8386Vt0.a.D9() ? c5516Jr1.Y8(HD5.create_group_public_desc_new) : c5516Jr1.Y8(HD5.create_group_public_desc) : c5516Jr1.Y8(HD5.create_group_private_desc) : zD2 ? c5516Jr1.Y8(HD5.create_channel_public_desc) : c5516Jr1.Y8(HD5.create_channel_private_desc)));
        return C19938rB7.a;
    }

    public final InterfaceC8288Vi1 Ha() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.contactsNavigator;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactsNavigator");
        return null;
    }

    public final InterfaceC15814kD2 Ia() {
        InterfaceC15814kD2 interfaceC15814kD2 = this.galleryNavigator;
        if (interfaceC15814kD2 != null) {
            return interfaceC15814kD2;
        }
        AbstractC13042fc3.y("galleryNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C8190Ux2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Na();
        La();
        Ma();
        Ka();
    }
}
