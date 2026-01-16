package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C14330hk2;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.jT7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15372jT7 extends AbstractC10505bj2 {
    public static final b T0 = new b(null);
    public static final int U0 = 8;
    private final int G0;
    private final InterfaceC14123hO3 H0;
    private final int I0;
    private final int J0;
    private final InterfaceC9173Yu3 K0;
    private final C5211Ij2 L0;
    private final View M0;
    private XV4 N0;
    public AbstractC15520jj2.h O0;
    private z0.d P0;
    private boolean Q0;
    private boolean R0;
    private boolean S0;

    /* renamed from: ir.nasim.jT7$a */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AbstractC13042fc3.i(animator, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "p0");
            LottieAnimationView lottieAnimationView = C15372jT7.this.h4().f;
            AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
            lottieAnimationView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AbstractC13042fc3.i(animator, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC13042fc3.i(animator, "p0");
        }
    }

    /* renamed from: ir.nasim.jT7$b */
    public static final class b {
        private b() {
        }

        public final C15372jT7 a(ViewGroup viewGroup, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11268cj2 c11268cj2C = C11268cj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11268cj2C, "inflate(...)");
            return new C15372jT7(c11268cj2C, i, interfaceC14123hO3, interfaceC13138fj2);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jT7$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C14330hk2.EnumC14332b.values().length];
            try {
                iArr[C14330hk2.EnumC14332b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C14330hk2.EnumC14332b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15372jT7(final C11268cj2 c11268cj2, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11268cj2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11268cj2, "binding");
        AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.G0 = i;
        this.H0 = interfaceC14123hO3;
        this.I0 = AbstractC8943Xx1.c(540);
        this.J0 = AbstractC8943Xx1.c(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        this.K0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.eT7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15372jT7.j4(c11268cj2);
            }
        });
        ViewStub viewStub = c11268cj2.g;
        viewStub.setLayoutResource(HC5.feed_video_holder);
        viewStub.setInflatedId(viewStub.getId());
        C5211Ij2 c5211Ij2A = C5211Ij2.a(viewStub.inflate());
        this.L0 = c5211Ij2A;
        this.M0 = c5211Ij2A.n;
        c5211Ij2A.f.i(new a());
    }

    private final void H4() {
        this.L0.k.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15372jT7.I4(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I4(C15372jT7 c15372jT7, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        c15372jT7.s1().q();
    }

    private final void M4(boolean z) {
        this.L0.n.setKeepScreenOn(z);
    }

    private final void S4(boolean z) {
        TextureView textureView = this.L0.n;
        AbstractC13042fc3.h(textureView, "videoSurfaceView");
        textureView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V3(C15372jT7 c15372jT7, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c15372jT7.b3(c4743Gj2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W3(C15372jT7 c15372jT7, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c15372jT7.Y2(new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null), c4743Gj2.e());
        return C19938rB7.a;
    }

    private final float X3(int i, int i2, int i3, int i4) {
        return Math.min(i / i2, i3 / i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z4(C15372jT7 c15372jT7, View view) {
        String name;
        AbstractC13042fc3.i(c15372jT7, "this$0");
        if (c15372jT7.getClass().isAnonymousClass()) {
            name = C15372jT7.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C15372jT7.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.g(name, "retry tapped", new Object[0]);
        c15372jT7.s1().g(c15372jT7.c4(), c15372jT7);
    }

    private final void a5(boolean z) {
        View view = this.L0.b;
        AbstractC13042fc3.h(view, "feedDim");
        view.setVisibility(z ? 0 : 8);
    }

    private final void b4(AbstractC15520jj2.h hVar) {
        int iG = hVar.g();
        int iE = hVar.e();
        int i = this.G0;
        float fX3 = X3(i, iG, this.I0, iE);
        int i2 = (int) (iG * fX3);
        if (i2 >= i) {
            i = i2;
        }
        int i3 = (int) (fX3 * iE);
        int i4 = this.J0;
        if (i3 < i4) {
            i3 = i4;
        }
        this.N0 = new XV4(Integer.valueOf(i), Integer.valueOf(i3));
    }

    private final VI2 d4() {
        return (VI2) this.K0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VI2 j4(C11268cj2 c11268cj2) {
        AbstractC13042fc3.i(c11268cj2, "$binding");
        return OI2.c(c11268cj2.getRoot());
    }

    private final TextView k4() {
        TextView textView = this.L0.m;
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(AbstractC4043Dl1.f(l1().getRoot().getContext(), AbstractC18163oB5.ic_feed_play), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setBackground(AbstractC4043Dl1.f(l1().getRoot().getContext(), AbstractC18163oB5.rectangle_bubble_secondary_color));
        AbstractC13042fc3.h(textView, "with(...)");
        return textView;
    }

    private final void l4() {
        this.L0.m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15372jT7.n4(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n4(C15372jT7 c15372jT7, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        c15372jT7.b5(false);
        c15372jT7.T4(false);
        C4743Gj2 c4743Gj2F3 = c15372jT7.f3();
        if (c4743Gj2F3 != null) {
            c15372jT7.s1().C(new C8755Xe4(c4743Gj2F3.f().I0().getPeerId(), c4743Gj2F3.e().e(), c4743Gj2F3.e().m(), 0, 8, null));
        }
    }

    private final void o4() {
        this.L0.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15372jT7.r4(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r4(C15372jT7 c15372jT7, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        c15372jT7.b5(false);
        c15372jT7.T4(false);
        C4743Gj2 c4743Gj2F3 = c15372jT7.f3();
        if (c4743Gj2F3 != null) {
            c15372jT7.s1().C(new C8755Xe4(c4743Gj2F3.f().I0().getPeerId(), c4743Gj2F3.e().e(), c4743Gj2F3.e().m(), 0, 8, null));
        }
    }

    private final void u4() {
        this.L0.l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15372jT7.v4(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v4(C15372jT7 c15372jT7, View view) {
        AbstractC13042fc3.i(c15372jT7, "this$0");
        C4743Gj2 c4743Gj2F3 = c15372jT7.f3();
        if (c4743Gj2F3 != null) {
            c15372jT7.s1().v(new C8755Xe4(c4743Gj2F3.f().I0().getPeerId(), c4743Gj2F3.e().e(), c4743Gj2F3.e().m(), 0, 8, null), c4743Gj2F3.e());
        }
    }

    private final void x4(byte[] bArr) {
        C20107rU5 c20107rU5;
        c5(true);
        XV4 xv4 = null;
        if (C8386Vt0.y6()) {
            C20107rU5 c20107rU52 = new C20107rU5();
            XV4 xv42 = this.N0;
            if (xv42 == null) {
                AbstractC13042fc3.y("finalMeasure");
                xv42 = null;
            }
            int iIntValue = ((Number) xv42.e()).intValue();
            XV4 xv43 = this.N0;
            if (xv43 == null) {
                AbstractC13042fc3.y("finalMeasure");
            } else {
                xv4 = xv43;
            }
            C20107rU5 c20107rU53 = (C20107rU5) c20107rU52.c0(iIntValue, ((Number) xv4.f()).intValue());
            ColorDrawable colorDrawableA = AbstractC14228ha0.a(bArr);
            if (colorDrawableA == null) {
                colorDrawableA = u1();
            }
            AbstractC6302Na0 abstractC6302Na0F0 = c20107rU53.f0(colorDrawableA);
            AbstractC13042fc3.f(abstractC6302Na0F0);
            c20107rU5 = (C20107rU5) abstractC6302Na0F0;
        } else {
            C20107rU5 c20107rU54 = new C20107rU5();
            XV4 xv44 = this.N0;
            if (xv44 == null) {
                AbstractC13042fc3.y("finalMeasure");
                xv44 = null;
            }
            int iIntValue2 = ((Number) xv44.e()).intValue();
            XV4 xv45 = this.N0;
            if (xv45 == null) {
                AbstractC13042fc3.y("finalMeasure");
            } else {
                xv4 = xv45;
            }
            C20107rU5 c20107rU55 = (C20107rU5) ((C20107rU5) ((C20107rU5) c20107rU54.c0(iIntValue2, ((Number) xv4.f()).intValue())).d()).y0(new C5191Ih0(10, 3), new LH0());
            ColorDrawable colorDrawableA2 = AbstractC14228ha0.a(bArr);
            if (colorDrawableA2 == null) {
                colorDrawableA2 = u1();
            }
            AbstractC6302Na0 abstractC6302Na0F02 = c20107rU55.f0(colorDrawableA2);
            AbstractC13042fc3.f(abstractC6302Na0F02);
            c20107rU5 = (C20107rU5) abstractC6302Na0F02;
        }
        d4().z(bArr).b(c20107rU5).i1(H02.k()).n0(new C22456vG4(Long.valueOf(c4().d().getFileId()))).Q0(this.L0.j);
    }

    private final void y4(AbstractC15520jj2.h hVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.L0.i;
        AbstractC13042fc3.h(aspectRatioFrameLayout, "feedVideoContainer");
        ViewGroup.LayoutParams layoutParams = aspectRatioFrameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = 0;
        layoutParams.height = 0;
        aspectRatioFrameLayout.setLayoutParams(layoutParams);
        l1().getRoot().measure(0, 0);
        b4(hVar);
        AspectRatioFrameLayout aspectRatioFrameLayout2 = this.L0.i;
        AbstractC13042fc3.h(aspectRatioFrameLayout2, "feedVideoContainer");
        ViewGroup.LayoutParams layoutParams2 = aspectRatioFrameLayout2.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        XV4 xv4 = this.N0;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv4 = null;
        }
        layoutParams2.width = ((Number) xv4.e()).intValue();
        XV4 xv43 = this.N0;
        if (xv43 == null) {
            AbstractC13042fc3.y("finalMeasure");
        } else {
            xv42 = xv43;
        }
        layoutParams2.height = ((Number) xv42.f()).intValue();
        aspectRatioFrameLayout2.setLayoutParams(layoutParams2);
    }

    public void A4() {
        M4(false);
        T4(false);
        Q4(false);
        b5(true);
        W4(true);
    }

    public void B4() {
        M4(true);
        S4(true);
        T4(true);
        b5(true);
        W4(false);
        Q4(false);
    }

    public void C4() {
        M4(false);
        S4(true);
        T4(false);
        b5(false);
        W4(false);
        Q4(true);
    }

    public void D4(boolean z) {
        M4(z);
        S4(true);
        c5(false);
        b5(false);
        T4(false);
        W4(false);
        Q4(false);
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void E2(AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        super.E2(abstractC15520jj2);
        AbstractC15520jj2.h hVar = (AbstractC15520jj2.h) abstractC15520jj2;
        F4(hVar);
        this.a.setTag(this);
        TextureView textureView = this.L0.n;
        AbstractC13042fc3.h(textureView, "videoSurfaceView");
        textureView.setVisibility(8);
        H4();
        y4(hVar);
        x4(hVar.f());
        c5(true);
        TextureView textureView2 = this.L0.n;
        AbstractC13042fc3.h(textureView2, "videoSurfaceView");
        textureView2.setVisibility(8);
        S4(false);
        CircleProgressBar circleProgressBar = this.L0.e;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context2, AbstractC13999hA5.colorOnPrimary), 40));
        Drawable background = this.L0.g.getBackground();
        Context context3 = this.a.getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        background.setColorFilter(new PorterDuffColorFilter(OY0.b(context3, AbstractC13999hA5.colorOnPrimary), PorterDuff.Mode.MULTIPLY));
        s1().p(c4());
        final C4743Gj2 c4743Gj2F3 = f3();
        if (c4743Gj2F3 != null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = this.L0.i;
            AbstractC13042fc3.h(aspectRatioFrameLayout, "feedVideoContainer");
            AbstractC10505bj2.v3(this, aspectRatioFrameLayout, 0L, 0.0f, new UA2() { // from class: ir.nasim.gT7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C15372jT7.V3(this.a, c4743Gj2F3, (View) obj);
                }
            }, new UA2() { // from class: ir.nasim.hT7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C15372jT7.W3(this.a, c4743Gj2F3, (View) obj);
                }
            }, 3, null);
        }
    }

    public final void E4() {
        M4(false);
        S4(false);
        c5(true);
        b5(true);
        T4(true);
        W4(false);
    }

    public final void F4(AbstractC15520jj2.h hVar) {
        AbstractC13042fc3.i(hVar, "<set-?>");
        this.O0 = hVar;
    }

    public final void O4(InterfaceC2037k interfaceC2037k) {
        AbstractC13042fc3.i(interfaceC2037k, "exoPlayer");
        interfaceC2037k.R(this.L0.n);
    }

    public final void Q4(boolean z) {
        LinearLayout linearLayout = this.L0.d;
        AbstractC13042fc3.h(linearLayout, "feedPlayAgainContainerVideo");
        linearLayout.setVisibility(z ? 0 : 8);
        if (!C8386Vt0.A6()) {
            k4();
            o4();
        } else {
            a5(z);
            u4();
            l4();
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        return (AbstractC17457n0) this.H0.a(c4());
    }

    public final void T4(boolean z) {
        CircleProgressBar circleProgressBar = this.L0.e;
        AbstractC13042fc3.h(circleProgressBar, "feedProgressVideo");
        circleProgressBar.setVisibility(z ? 0 : 8);
    }

    public final void U3(C14330hk2.EnumC14332b enumC14332b) {
        int i;
        AbstractC13042fc3.i(enumC14332b, "volumeState");
        int i2 = c.a[enumC14332b.ordinal()];
        if (i2 == 1) {
            i = AbstractC18163oB5.ic_feed_mute;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = AbstractC18163oB5.ic_feed_unmute;
        }
        this.L0.k.setImageDrawable(AbstractC9594aE.b(this.a.getContext(), i));
    }

    public final void W4(boolean z) {
        ImageView imageView = this.L0.h;
        AbstractC13042fc3.h(imageView, "feedStateVideoIv");
        imageView.setVisibility(z ? 0 : 8);
        this.L0.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dT7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15372jT7.Z4(this.a, view);
            }
        });
    }

    @Override // ir.nasim.AbstractC10505bj2, ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        this.a.setTag(null);
        this.Q0 = false;
        QI2 qi2 = QI2.a;
        ImageView imageView = this.L0.j;
        AbstractC13042fc3.h(imageView, "feedVideoThumbnail");
        qi2.a(imageView);
        this.L0.j.setImageDrawable(null);
        this.P0 = null;
        this.R0 = false;
        this.S0 = false;
        Log.i("player_pool", "unbind: " + K());
    }

    public final void b5(boolean z) {
        FrameLayout frameLayout = this.L0.g;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerVideo");
        frameLayout.setVisibility(z ? 0 : 8);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void c1() {
        LottieAnimationView lottieAnimationView = this.L0.f;
        AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
        lottieAnimationView.setVisibility(0);
        this.L0.f.x();
    }

    public final AbstractC15520jj2.h c4() {
        AbstractC15520jj2.h hVar = this.O0;
        if (hVar != null) {
            return hVar;
        }
        AbstractC13042fc3.y("feedVideoMessage");
        return null;
    }

    public final void c5(boolean z) {
        ImageView imageView = this.L0.j;
        AbstractC13042fc3.h(imageView, "feedVideoThumbnail");
        imageView.setVisibility(z ? 0 : 8);
    }

    public final View g4() {
        return this.M0;
    }

    public final C5211Ij2 h4() {
        return this.L0;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        return c4().c().length() > 0;
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void t3(AbstractC15520jj2 abstractC15520jj2) {
        C12800fB6 c12800fB6H3;
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        CharSequence charSequenceE = p1().e(((AbstractC15520jj2.d) abstractC15520jj2).c());
        if (charSequenceE == null || (c12800fB6H3 = h3()) == null) {
            return;
        }
        TextView textView = l1().d;
        AbstractC13042fc3.h(textView, "feedCaption");
        c12800fB6H3.t(textView, charSequenceE, false);
    }

    public final boolean w4() {
        TextureView textureView = this.L0.n;
        AbstractC13042fc3.h(textureView, "videoSurfaceView");
        return textureView.getVisibility() == 0;
    }
}
