package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.C17623nH2;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import java.io.File;

/* renamed from: ir.nasim.nH2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17623nH2 extends AbstractC10505bj2 {
    public static final c R0 = new c(null);
    public static final int S0 = 8;
    private final C14970in2 G0;
    private final int H0;
    private final InterfaceC14123hO3 I0;
    private final int J0;
    private final int K0;
    private InterfaceC7857Tm2 L0;
    private InterfaceC8091Um2 M0;
    private final C4968Hi2 N0;
    private XV4 O0;
    private C8610Ws P0;
    private AbstractC15520jj2.c Q0;

    /* renamed from: ir.nasim.nH2$a */
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
            LottieAnimationView lottieAnimationView = C17623nH2.this.N0.e;
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

    /* renamed from: ir.nasim.nH2$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C17623nH2 c17623nH2, b bVar, View view) {
            AbstractC13042fc3.i(c17623nH2, "this$0");
            AbstractC13042fc3.i(bVar, "this$1");
            C14970in2 c14970in2 = c17623nH2.G0;
            AbstractC15520jj2.c cVar = c17623nH2.Q0;
            if (cVar == null) {
                AbstractC13042fc3.y("feedGifMessage");
                cVar = null;
            }
            c17623nH2.L0 = c14970in2.D(cVar.d(), true, bVar, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            FrameLayout frameLayout = C17623nH2.this.N0.f;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
            frameLayout.setVisibility(0);
            ImageView imageView = C17623nH2.this.N0.g;
            AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
            imageView.setVisibility(8);
            CircleProgressBar circleProgressBar = C17623nH2.this.N0.d;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressPhoto");
            circleProgressBar.setVisibility(0);
            C17623nH2.this.N0.d.setValue((int) f);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) throws InterruptedException {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            FrameLayout frameLayout = C17623nH2.this.N0.f;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
            frameLayout.setVisibility(8);
            ImageView imageView = C17623nH2.this.N0.g;
            AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
            imageView.setVisibility(8);
            CircleProgressBar circleProgressBar = C17623nH2.this.N0.d;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressPhoto");
            circleProgressBar.setVisibility(8);
            C17623nH2 c17623nH2 = C17623nH2.this;
            C8610Ws c8610Ws = new C8610Ws(new File(interfaceC3346Am2.getDescriptor()), false);
            C17623nH2.this.N0.c.j(c8610Ws, true);
            c17623nH2.P0 = c8610Ws;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void g(DX1 dx1) {
            FrameLayout frameLayout = C17623nH2.this.N0.f;
            AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
            frameLayout.setVisibility(0);
            ImageView imageView = C17623nH2.this.N0.g;
            AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
            imageView.setVisibility(0);
            CircleProgressBar circleProgressBar = C17623nH2.this.N0.d;
            AbstractC13042fc3.h(circleProgressBar, "feedProgressPhoto");
            circleProgressBar.setVisibility(8);
            C17623nH2.this.N0.g.setImageResource(AbstractC18163oB5.ic_feed_retry);
            ImageView imageView2 = C17623nH2.this.N0.g;
            final C17623nH2 c17623nH2 = C17623nH2.this;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oH2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C17623nH2.b.b(c17623nH2, this, view);
                }
            });
        }
    }

    /* renamed from: ir.nasim.nH2$c */
    public static final class c {
        private c() {
        }

        public final C17623nH2 a(ViewGroup viewGroup, C14970in2 c14970in2, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11268cj2 c11268cj2C = C11268cj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11268cj2C, "inflate(...)");
            return new C17623nH2(c11268cj2C, c14970in2, i, interfaceC14123hO3, interfaceC13138fj2);
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17623nH2(C11268cj2 c11268cj2, C14970in2 c14970in2, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11268cj2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11268cj2, "binding");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.G0 = c14970in2;
        this.H0 = i;
        this.I0 = interfaceC14123hO3;
        this.J0 = AbstractC8943Xx1.c(540);
        this.K0 = AbstractC8943Xx1.c(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        ViewStub viewStub = c11268cj2.g;
        viewStub.setLayoutResource(HC5.feed_gif_holder);
        viewStub.setInflatedId(viewStub.getId());
        C4968Hi2 c4968Hi2A = C4968Hi2.a(viewStub.inflate());
        this.N0 = c4968Hi2A;
        c4968Hi2A.e.i(new a());
        this.M0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T3(C17623nH2 c17623nH2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c17623nH2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c17623nH2.b3(c4743Gj2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U3(C17623nH2 c17623nH2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(c17623nH2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        c17623nH2.Y2(new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null), c4743Gj2.e());
        return C19938rB7.a;
    }

    private final float V3(int i, int i2, int i3, int i4) {
        return Math.min(i / i2, i3 / i4);
    }

    private final void W3(AbstractC15520jj2.e eVar) {
        int iG = eVar.g();
        int iE = eVar.e();
        int i = this.H0;
        float fV3 = V3(i, iG, this.J0, iE);
        int i2 = (int) (iG * fV3);
        if (i2 >= i) {
            i = i2;
        }
        int i3 = (int) (fV3 * iE);
        int i4 = this.K0;
        if (i3 < i4) {
            i3 = i4;
        }
        this.O0 = new XV4(Integer.valueOf(i), Integer.valueOf(i3));
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void E2(AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        super.E2(abstractC15520jj2);
        this.Q0 = (AbstractC15520jj2.c) abstractC15520jj2;
        ImageViewCrossFade imageViewCrossFade = this.N0.c;
        AbstractC13042fc3.h(imageViewCrossFade, "feedPhotoIv");
        ViewGroup.LayoutParams layoutParams = imageViewCrossFade.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = 0;
        layoutParams.height = 0;
        imageViewCrossFade.setLayoutParams(layoutParams);
        l1().getRoot().measure(0, 0);
        AbstractC15520jj2.e eVar = (AbstractC15520jj2.e) abstractC15520jj2;
        W3(eVar);
        ImageViewCrossFade imageViewCrossFade2 = this.N0.c;
        AbstractC13042fc3.h(imageViewCrossFade2, "feedPhotoIv");
        ViewGroup.LayoutParams layoutParams2 = imageViewCrossFade2.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        XV4 xv4 = this.O0;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv4 = null;
        }
        layoutParams2.width = ((Number) xv4.e()).intValue();
        XV4 xv43 = this.O0;
        if (xv43 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv43 = null;
        }
        layoutParams2.height = ((Number) xv43.f()).intValue();
        imageViewCrossFade2.setLayoutParams(layoutParams2);
        Drawable background = this.N0.f.getBackground();
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        background.setColorFilter(new PorterDuffColorFilter(OY0.b(context, AbstractC13999hA5.colorOnPrimary), PorterDuff.Mode.MULTIPLY));
        CircleProgressBar circleProgressBar = this.N0.d;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context2, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context3 = this.a.getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context3, AbstractC13999hA5.colorOnPrimary), 40));
        C20107rU5 c20107rU5 = new C20107rU5();
        XV4 xv44 = this.O0;
        if (xv44 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv44 = null;
        }
        int iIntValue = ((Number) xv44.e()).intValue();
        XV4 xv45 = this.O0;
        if (xv45 == null) {
            AbstractC13042fc3.y("finalMeasure");
        } else {
            xv42 = xv45;
        }
        C20107rU5 c20107rU52 = (C20107rU5) ((C20107rU5) c20107rU5.c0(iIntValue, ((Number) xv42.f()).intValue())).y0(new C5191Ih0(10, 3), new LH0());
        ColorDrawable colorDrawableA = AbstractC14228ha0.a(eVar.f());
        if (colorDrawableA == null) {
            colorDrawableA = u1();
        }
        AbstractC6302Na0 abstractC6302Na0F0 = c20107rU52.f0(colorDrawableA);
        AbstractC13042fc3.h(abstractC6302Na0F0, "placeholder(...)");
        this.N0.c.o(eVar.f(), (C20107rU5) abstractC6302Na0F0);
        this.L0 = this.G0.D(eVar.d(), true, this.M0, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        final C4743Gj2 c4743Gj2F3 = f3();
        if (c4743Gj2F3 != null) {
            ImageViewCrossFade imageViewCrossFade3 = this.N0.c;
            AbstractC13042fc3.h(imageViewCrossFade3, "feedPhotoIv");
            AbstractC10505bj2.v3(this, imageViewCrossFade3, 0L, 0.0f, new UA2() { // from class: ir.nasim.lH2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C17623nH2.T3(this.a, c4743Gj2F3, (View) obj);
                }
            }, new UA2() { // from class: ir.nasim.mH2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C17623nH2.U3(this.a, c4743Gj2F3, (View) obj);
                }
            }, 3, null);
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        InterfaceC14123hO3 interfaceC14123hO3 = this.I0;
        AbstractC15520jj2.c cVar = this.Q0;
        if (cVar == null) {
            AbstractC13042fc3.y("feedGifMessage");
            cVar = null;
        }
        return (AbstractC17457n0) interfaceC14123hO3.a(cVar);
    }

    @Override // ir.nasim.AbstractC10505bj2, ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        ImageViewCrossFade imageViewCrossFade = this.N0.c;
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.L0;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.L0 = null;
        C8610Ws c8610Ws = this.P0;
        if (c8610Ws != null) {
            AbstractC14228ha0.b(c8610Ws);
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void c1() {
        LottieAnimationView lottieAnimationView = this.N0.e;
        AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
        lottieAnimationView.setVisibility(0);
        this.N0.e.x();
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.c cVar = this.Q0;
        if (cVar == null) {
            AbstractC13042fc3.y("feedGifMessage");
            cVar = null;
        }
        return !(cVar.c().length() == 0);
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
}
