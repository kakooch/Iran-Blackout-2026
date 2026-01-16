package ir.nasim.features.conversation.placeholder;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.foundation.layout.q;
import androidx.compose.foundation.layout.t;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC17932no0;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC24667z03;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC6302Na0;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC9105Ym7;
import ir.nasim.C16731lm1;
import ir.nasim.C17484n26;
import ir.nasim.C17784nZ1;
import ir.nasim.C18666p26;
import ir.nasim.C19938rB7;
import ir.nasim.C20107rU5;
import ir.nasim.C22078ud6;
import ir.nasim.C24254yJ;
import ir.nasim.C24381yX0;
import ir.nasim.C5161Id6;
import ir.nasim.C6011Lu2;
import ir.nasim.C6399Nk7;
import ir.nasim.C6634Oi0;
import ir.nasim.C7252Qx5;
import ir.nasim.C8386Vt0;
import ir.nasim.C8610Ws;
import ir.nasim.C9784aZ0;
import ir.nasim.DG7;
import ir.nasim.FV0;
import ir.nasim.FV4;
import ir.nasim.G10;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.M10;
import ir.nasim.N46;
import ir.nasim.OY0;
import ir.nasim.P46;
import ir.nasim.QJ5;
import ir.nasim.R62;
import ir.nasim.SA2;
import ir.nasim.UY6;
import ir.nasim.XY0;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.placeholder.ChatBotIntroView;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00102\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b/\u00100\u0012\u0004\b1\u0010\b¨\u00064"}, d2 = {"Lir/nasim/features/conversation/placeholder/ChatBotIntroView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lir/nasim/rB7;", "i", "()V", "l", "j", "h", "k", "", "downloadUpdateLink", "c", "(Ljava/lang/String;Lir/nasim/ub1;I)V", "Landroid/text/Spannable;", ParameterNames.TEXT, "setText", "(Landroid/text/Spannable;)V", "Lir/nasim/Oi0$a;", "media", "setMedia", "(Lir/nasim/Oi0$a;)V", "", "isCenter", "m", "(Z)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "textView", "Lir/nasim/designsystem/ImageViewCrossFade;", "b", "Lir/nasim/designsystem/ImageViewCrossFade;", "mediaImageView", "Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/ComposeView;", "unsupportedMedia", "Lir/nasim/lm1;", "d", "Lir/nasim/Yu3;", "getContextThemeWrapper", "()Lir/nasim/lm1;", "contextThemeWrapper", "Lir/nasim/p26;", "e", "Lir/nasim/p26;", "getNoRippleConfiguration$annotations", "noRippleConfiguration", "f", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ChatBotIntroView extends LinearLayout {
    public static final int g = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final TextView textView;

    /* renamed from: b, reason: from kotlin metadata */
    private final ImageViewCrossFade mediaImageView;

    /* renamed from: c, reason: from kotlin metadata */
    private final ComposeView unsupportedMedia;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contextThemeWrapper;

    /* renamed from: e, reason: from kotlin metadata */
    private final C18666p26 noRippleConfiguration;

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ String b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ChatBotIntroView a;
            final /* synthetic */ String b;

            a(ChatBotIntroView chatBotIntroView, String str) {
                this.a = chatBotIntroView;
                this.b = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(ChatBotIntroView chatBotIntroView, String str) {
                AbstractC13042fc3.i(chatBotIntroView, "this$0");
                AbstractC13042fc3.i(str, "$downloadUpdateLink");
                chatBotIntroView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e eVarH = t.h(e.a, 0.0f, 1, null);
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                String strC = UY6.c(AbstractC12217eE5.chat_bot_intro_media_unsupported_button, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(56914278);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
                final ChatBotIntroView chatBotIntroView = this.a;
                final String str = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.conversation.placeholder.a
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return ChatBotIntroView.b.a.c(chatBotIntroView, str);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.Q((SA2) objB, c1454b, strC, eVarH, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 3) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 16);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(String str) {
            this.b = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = e.a;
            e eVarA = FV0.a(t.i(t.y(aVar, C17784nZ1.q(278.0f)), C17784nZ1.q(156.0f)), N46.d(C17784nZ1.q(8.0f)));
            G10 g10 = G10.a;
            int i2 = G10.b;
            e eVarL = q.l(androidx.compose.foundation.b.d(eVarA, g10.a(interfaceC22053ub1, i2).y(), null, 2, null), C17784nZ1.q(12.0f), C17784nZ1.q(8.0f), C17784nZ1.q(12.0f), C17784nZ1.q(12.0f));
            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(12.0f));
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            ChatBotIntroView chatBotIntroView = ChatBotIntroView.this;
            String str = this.b;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarL);
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
            AbstractC24667z03.b(FV4.c(KB5.danger, interfaceC22053ub1, 0), null, t.t(aVar, C17784nZ1.q(32.0f)), g10.a(interfaceC22053ub1, i2).s(), interfaceC22053ub1, 432, 0);
            AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.chat_bot_intro_media_unsupported_title, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i2).s(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 0, 0, 65018);
            AbstractC11024cc1.a(androidx.compose.material3.a.a().d(chatBotIntroView.noRippleConfiguration), AbstractC19242q11.e(-267022403, true, new a(chatBotIntroView, str), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C6634Oi0.a b;

        c(C6634Oi0.a aVar) {
            this.b = aVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                ChatBotIntroView.this.c(((C6634Oi0.a.d) this.b).a(), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBotIntroView(final Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.textView = new TextView(context);
        this.mediaImageView = new ImageViewCrossFade(context, null);
        this.unsupportedMedia = new ComposeView(context, null, 0, 4, null);
        this.contextThemeWrapper = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jL0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ChatBotIntroView.g(context);
            }
        });
        i();
        h();
        k();
        j();
        this.noRippleConfiguration = new C18666p26(C24381yX0.b.h(), new C17484n26(0.0f, 0.0f, 0.0f, 0.0f), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(747818702);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-578942157, true, new b(str), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.kL0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return ChatBotIntroView.d(this.a, str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(ChatBotIntroView chatBotIntroView, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(chatBotIntroView, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$downloadUpdateLink");
        chatBotIntroView.c(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16731lm1 g(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new C16731lm1(context, AbstractC23035wE5.Theme_Bale_Base);
    }

    private final C16731lm1 getContextThemeWrapper() {
        return (C16731lm1) this.contextThemeWrapper.getValue();
    }

    private static /* synthetic */ void getNoRippleConfiguration$annotations() {
    }

    private final void h() {
        ImageViewCrossFade imageViewCrossFade = this.mediaImageView;
        imageViewCrossFade.setVisibility(8);
        imageViewCrossFade.setClipToPadding(true);
        imageViewCrossFade.setCornerRadius((int) ((8 * AbstractC3742Cd6.c()) + 0.5d));
        LinearLayout.LayoutParams layoutParamsM = AbstractC13840gu3.m(278, 156, 17);
        AbstractC13042fc3.f(layoutParamsM);
        int iC = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);
        layoutParamsM.setMargins(iC, iC, iC, iC);
        C19938rB7 c19938rB7 = C19938rB7.a;
        addView(imageViewCrossFade, layoutParamsM);
    }

    private final void i() {
        setVisibility(8);
        FrameLayout.LayoutParams layoutParamsD = AbstractC13840gu3.d(-2, -2, 17);
        double d = 12;
        layoutParamsD.bottomMargin = (int) ((AbstractC3742Cd6.c() * d) + 0.5d);
        layoutParamsD.topMargin = (int) ((d * AbstractC3742Cd6.c()) + 0.5d);
        setLayoutParams(layoutParamsD);
        setGravity(17);
        setOrientation(1);
        setForegroundGravity(17);
        setElevation((int) ((1 * AbstractC3742Cd6.c()) + 0.5d));
        l();
    }

    private final void j() {
        TextView textView = this.textView;
        textView.setVisibility(8);
        AbstractC15575jo7.p(textView, AbstractC23035wE5.TextAppearance_Bale_BodyMedium_2_14_Regular);
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(OY0.b(getContextThemeWrapper(), AbstractC21139tA5.n500));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setClickable(true);
        textView.setLinksClickable(true);
        double d = 16;
        double d2 = 8;
        textView.setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d));
        textView.setMaxHeight((int) ((SIPTransactionStack.BASE_TIMER_INTERVAL * AbstractC3742Cd6.c()) + 0.5d));
        addView(textView, AbstractC13840gu3.m(278, -2, C8386Vt0.L4() ? 8388611 : 17));
    }

    private final void k() {
        ComposeView composeView = this.unsupportedMedia;
        composeView.setVisibility(8);
        this.unsupportedMedia.setViewCompositionStrategy(v.d.b);
        composeView.setClipToPadding(true);
        LinearLayout.LayoutParams layoutParamsM = AbstractC13840gu3.m(278, 156, 17);
        AbstractC13042fc3.f(layoutParamsM);
        int iC = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);
        layoutParamsM.setMargins(iC, iC, iC, iC);
        C19938rB7 c19938rB7 = C19938rB7.a;
        addView(composeView, layoutParamsM);
    }

    private final void l() {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = C22078ud6.a(10.0f);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setAntiAlias(true);
        AbstractC21710u02.h(shapeDrawable, OY0.b(new C16731lm1(getContext(), AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming), AbstractC21139tA5.bubble_primary));
        setLayerType(1, shapeDrawable.getPaint());
        setBackground(shapeDrawable);
    }

    public final void m(boolean isCenter) {
        ViewParent parent = getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = isCenter ? -1 : -2;
        frameLayout.setLayoutParams(layoutParams);
    }

    public final void setMedia(C6634Oi0.a media) {
        if (media instanceof C6634Oi0.a.c) {
            this.unsupportedMedia.setVisibility(8);
            this.mediaImageView.setVisibility(0);
            AbstractC6302Na0 abstractC6302Na0U0 = ((C20107rU5) ((C20107rU5) new C20107rU5().c0(C22078ud6.a(278.0f), C22078ud6.a(156.0f))).d()).u0(new P46((int) ((8 * AbstractC3742Cd6.c()) + 0.5d)));
            AbstractC13042fc3.h(abstractC6302Na0U0, "transform(...)");
            this.mediaImageView.o(((C6634Oi0.a.c) media).a(), (C20107rU5) abstractC6302Na0U0);
            return;
        }
        if (media instanceof C6634Oi0.a.b) {
            this.unsupportedMedia.setVisibility(8);
            this.mediaImageView.setVisibility(0);
            AbstractC6302Na0 abstractC6302Na0U02 = ((C20107rU5) ((C20107rU5) new C20107rU5().c0(C22078ud6.a(278.0f), C22078ud6.a(156.0f))).d()).u0(new P46((int) ((8 * AbstractC3742Cd6.c()) + 0.5d)));
            AbstractC13042fc3.h(abstractC6302Na0U02, "transform(...)");
            this.mediaImageView.m(((C6634Oi0.a.b) media).a(), (C20107rU5) abstractC6302Na0U02);
            return;
        }
        if (media instanceof C6634Oi0.a.C0559a) {
            this.unsupportedMedia.setVisibility(8);
            this.mediaImageView.setVisibility(0);
            this.mediaImageView.j(new C8610Ws(new File(((C6634Oi0.a.C0559a) media).a()), false, 278, 156), true);
            return;
        }
        if (media instanceof C6634Oi0.a.d) {
            this.mediaImageView.setVisibility(8);
            this.unsupportedMedia.setVisibility(0);
            this.unsupportedMedia.setContent(AbstractC19242q11.c(-478850725, true, new c(media)));
        } else {
            if (media != null) {
                throw new NoWhenBranchMatchedException();
            }
            this.mediaImageView.setVisibility(8);
            this.unsupportedMedia.setVisibility(8);
        }
    }

    public final void setText(Spannable text) {
        TextView textView = this.textView;
        if (text == null || AbstractC20762sZ6.n0(text)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(R62.W(text, this.textView.getPaint().getFontMetricsInt(), C5161Id6.e(14.0f), false, null, null, 48, null));
        }
    }
}
