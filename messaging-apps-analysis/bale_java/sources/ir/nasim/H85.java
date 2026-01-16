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
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* loaded from: classes6.dex */
public final class H85 extends AbstractC10505bj2 {
    public static final b O0 = new b(null);
    public static final int P0 = 8;
    private final C14970in2 G0;
    private final int H0;
    private final InterfaceC14123hO3 I0;
    private final int J0;
    private final int K0;
    private final C20857sj2 L0;
    private XV4 M0;
    private AbstractC15520jj2.e N0;

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
            LottieAnimationView lottieAnimationView = H85.this.L0.e;
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

    public static final class b {
        private b() {
        }

        public final H85 a(ViewGroup viewGroup, C14970in2 c14970in2, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(c14970in2, "filesModule");
            AbstractC13042fc3.i(interfaceC14123hO3, "mediaMessageToAbsContentMapper");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11268cj2 c11268cj2C = C11268cj2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11268cj2C, "inflate(...)");
            return new H85(c11268cj2C, c14970in2, i, interfaceC14123hO3, interfaceC13138fj2);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H85(C11268cj2 c11268cj2, C14970in2 c14970in2, int i, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC13138fj2 interfaceC13138fj2) {
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
        viewStub.setLayoutResource(HC5.feed_photo_holder);
        viewStub.setInflatedId(viewStub.getId());
        C20857sj2 c20857sj2A = C20857sj2.a(viewStub.inflate());
        this.L0 = c20857sj2A;
        c20857sj2A.e.i(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U3(H85 h85, AbstractC15520jj2 abstractC15520jj2, View view) {
        AbstractC13042fc3.i(h85, "this$0");
        AbstractC13042fc3.i(abstractC15520jj2, "$feedMessage");
        h85.g4((AbstractC15520jj2.e) abstractC15520jj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V3(H85 h85, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(h85, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        h85.b3(c4743Gj2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W3(H85 h85, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(h85, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(view, "it");
        h85.Y2(new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null), c4743Gj2.e());
        return C19938rB7.a;
    }

    private final float X3(int i, int i2, int i3, int i4) {
        return Math.min(i / i2, i3 / i4);
    }

    private final XV4 b4(AbstractC15520jj2.e eVar) {
        int iG = eVar.g();
        int iE = eVar.e();
        int i = this.H0;
        float fX3 = X3(i, iG, this.J0, iE);
        int i2 = (int) (iG * fX3);
        if (i2 >= i) {
            i = i2;
        }
        int i3 = (int) (fX3 * iE);
        int i4 = this.K0;
        if (i3 < i4) {
            i3 = i4;
        }
        return new XV4(Integer.valueOf(i), Integer.valueOf(i3));
    }

    private final void c4(ImageViewCrossFade imageViewCrossFade) {
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
    }

    private final void d4(InterfaceC3346Am2 interfaceC3346Am2, AbstractC15520jj2.e eVar) {
        InterfaceC13138fj2 interfaceC13138fj2S1 = s1();
        long jF = interfaceC3346Am2.f();
        String strO = C6906Pm2.o(interfaceC3346Am2.getDescriptor());
        if (strO == null) {
            strO = "image/jpeg";
        }
        interfaceC13138fj2S1.b(jF, strO, eVar.d().getFileId(), eVar.d().getAccessHash());
    }

    private final void g4(final AbstractC15520jj2.e eVar) {
        final C20857sj2 c20857sj2 = this.L0;
        s1().r(eVar.d(), K(), new UA2() { // from class: ir.nasim.D85
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return H85.h4(c20857sj2, ((Float) obj).floatValue());
            }
        }, new InterfaceC14603iB2() { // from class: ir.nasim.E85
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return H85.j4(this.a, eVar, c20857sj2, (InterfaceC3346Am2) obj, ((Integer) obj2).intValue());
            }
        }, new UA2() { // from class: ir.nasim.F85
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return H85.k4(c20857sj2, (DX1) obj);
            }
        });
        c20857sj2.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.G85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                H85.l4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h4(C20857sj2 c20857sj2, float f) {
        AbstractC13042fc3.i(c20857sj2, "$this_with");
        FrameLayout frameLayout = c20857sj2.f;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
        frameLayout.setVisibility(0);
        ImageView imageView = c20857sj2.g;
        AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
        imageView.setVisibility(8);
        CircleProgressBar circleProgressBar = c20857sj2.d;
        AbstractC13042fc3.f(circleProgressBar);
        circleProgressBar.setVisibility(0);
        circleProgressBar.setValue((int) (f * 100));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j4(H85 h85, AbstractC15520jj2.e eVar, C20857sj2 c20857sj2, InterfaceC3346Am2 interfaceC3346Am2, int i) {
        AbstractC13042fc3.i(h85, "this$0");
        AbstractC13042fc3.i(eVar, "$feedMessage");
        AbstractC13042fc3.i(c20857sj2, "$this_with");
        AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
        if (i != h85.K()) {
            return C19938rB7.a;
        }
        h85.d4(interfaceC3346Am2, eVar);
        FrameLayout frameLayout = c20857sj2.f;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
        frameLayout.setVisibility(8);
        ImageView imageView = c20857sj2.g;
        AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
        imageView.setVisibility(8);
        CircleProgressBar circleProgressBar = c20857sj2.d;
        AbstractC13042fc3.h(circleProgressBar, "feedProgressPhoto");
        circleProgressBar.setVisibility(8);
        ImageViewCrossFade imageViewCrossFade = c20857sj2.c;
        String descriptor = interfaceC3346Am2.getDescriptor();
        C20107rU5 c20107rU5 = new C20107rU5();
        XV4 xv4 = h85.M0;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv4 = null;
        }
        int iIntValue = ((Number) xv4.e()).intValue();
        XV4 xv43 = h85.M0;
        if (xv43 == null) {
            AbstractC13042fc3.y("finalMeasure");
        } else {
            xv42 = xv43;
        }
        AbstractC6302Na0 abstractC6302Na0U0 = ((C20107rU5) c20107rU5.c0(iIntValue, ((Number) xv42.f()).intValue())).u0(new LH0());
        AbstractC13042fc3.h(abstractC6302Na0U0, "transform(...)");
        imageViewCrossFade.m(descriptor, (C20107rU5) abstractC6302Na0U0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k4(C20857sj2 c20857sj2, DX1 dx1) {
        AbstractC13042fc3.i(c20857sj2, "$this_with");
        FrameLayout frameLayout = c20857sj2.f;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerPhoto");
        frameLayout.setVisibility(0);
        ImageView imageView = c20857sj2.g;
        AbstractC13042fc3.h(imageView, "feedStatePhotoIv");
        imageView.setVisibility(0);
        CircleProgressBar circleProgressBar = c20857sj2.d;
        AbstractC13042fc3.h(circleProgressBar, "feedProgressPhoto");
        circleProgressBar.setVisibility(8);
        c20857sj2.g.setImageResource(AbstractC18163oB5.ic_feed_retry);
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC10505bj2
    public void E2(final AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        super.E2(abstractC15520jj2);
        AbstractC15520jj2.e eVar = (AbstractC15520jj2.e) abstractC15520jj2;
        this.N0 = eVar;
        ImageViewCrossFade imageViewCrossFade = this.L0.c;
        AbstractC13042fc3.h(imageViewCrossFade, "feedPhotoIv");
        ViewGroup.LayoutParams layoutParams = imageViewCrossFade.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = 0;
        layoutParams.height = 0;
        imageViewCrossFade.setLayoutParams(layoutParams);
        l1().getRoot().measure(0, 0);
        this.M0 = b4(eVar);
        ImageViewCrossFade imageViewCrossFade2 = this.L0.c;
        AbstractC13042fc3.h(imageViewCrossFade2, "feedPhotoIv");
        ViewGroup.LayoutParams layoutParams2 = imageViewCrossFade2.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        XV4 xv4 = this.M0;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv4 = null;
        }
        layoutParams2.width = ((Number) xv4.e()).intValue();
        XV4 xv43 = this.M0;
        if (xv43 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv43 = null;
        }
        layoutParams2.height = ((Number) xv43.f()).intValue();
        imageViewCrossFade2.setLayoutParams(layoutParams2);
        Drawable background = this.L0.f.getBackground();
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        background.setColorFilter(new PorterDuffColorFilter(OY0.b(context, AbstractC13999hA5.colorOnPrimary), PorterDuff.Mode.MULTIPLY));
        CircleProgressBar circleProgressBar = this.L0.d;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context2, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context3 = this.a.getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context3, AbstractC13999hA5.colorOnPrimary), 40));
        ImageViewCrossFade imageViewCrossFade3 = this.L0.c;
        AbstractC13042fc3.h(imageViewCrossFade3, "feedPhotoIv");
        c4(imageViewCrossFade3);
        C20107rU5 c20107rU5 = new C20107rU5();
        XV4 xv44 = this.M0;
        if (xv44 == null) {
            AbstractC13042fc3.y("finalMeasure");
            xv44 = null;
        }
        int iIntValue = ((Number) xv44.e()).intValue();
        XV4 xv45 = this.M0;
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
        this.L0.c.o(eVar.f(), (C20107rU5) abstractC6302Na0F0);
        g4(eVar);
        this.L0.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.A85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                H85.U3(this.a, abstractC15520jj2, view);
            }
        });
        final C4743Gj2 c4743Gj2F3 = f3();
        if (c4743Gj2F3 != null) {
            ImageViewCrossFade imageViewCrossFade4 = this.L0.c;
            AbstractC13042fc3.h(imageViewCrossFade4, "feedPhotoIv");
            AbstractC10505bj2.v3(this, imageViewCrossFade4, 0L, 0.0f, new UA2() { // from class: ir.nasim.B85
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return H85.V3(this.a, c4743Gj2F3, (View) obj);
                }
            }, new UA2() { // from class: ir.nasim.C85
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return H85.W3(this.a, c4743Gj2F3, (View) obj);
                }
            }, 3, null);
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        InterfaceC14123hO3 interfaceC14123hO3 = this.I0;
        AbstractC15520jj2.e eVar = this.N0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        return (AbstractC17457n0) interfaceC14123hO3.a(eVar);
    }

    @Override // ir.nasim.AbstractC10505bj2, ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        ImageViewCrossFade imageViewCrossFade = this.L0.c;
        AbstractC13042fc3.h(imageViewCrossFade, "feedPhotoIv");
        c4(imageViewCrossFade);
        C14970in2 c14970in2 = this.G0;
        AbstractC15520jj2.e eVar = this.N0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        c14970in2.H(eVar.d().getFileId());
        s1().l(K());
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void c1() {
        LottieAnimationView lottieAnimationView = this.L0.e;
        AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
        lottieAnimationView.setVisibility(0);
        this.L0.e.x();
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.e eVar = this.N0;
        if (eVar == null) {
            AbstractC13042fc3.y("feedPhotoMessage");
            eVar = null;
        }
        return !(eVar.c().length() == 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l4(View view) {
    }
}
