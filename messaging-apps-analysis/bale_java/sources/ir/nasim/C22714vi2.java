package ir.nasim;

import android.animation.Animator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.GS7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import java.util.ArrayList;

/* renamed from: ir.nasim.vi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22714vi2 extends JA2 {
    public static final b U0 = new b(null);
    public static final int V0 = 8;
    private final C11258ci2 M0;
    private final VI2 N0;
    private final C23310wi2 O0;
    private final FrameLayout P0;
    private AbstractC15520jj2.h Q0;
    private final InterfaceC9173Yu3 R0;
    private com.google.android.exoplayer2.z0 S0;
    private z0.d T0;

    /* renamed from: ir.nasim.vi2$a */
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
            LottieAnimationView lottieAnimationView = C22714vi2.this.l1().p;
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

    /* renamed from: ir.nasim.vi2$b */
    public static final class b {
        private b() {
        }

        public final C22714vi2 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2, VI2 vi2, O98 o98) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            AbstractC13042fc3.i(vi2, "glideRequest");
            C11258ci2 c11258ci2C = C11258ci2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11258ci2C, "inflate(...)");
            return new C22714vi2(c11258ci2C, interfaceC13138fj2, o98, vi2);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vi2$c */
    public static final class c implements z0.d {
        c() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void S4(boolean z, int i) {
            super.S4(z, i);
            C22714vi2.this.w4(!z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22714vi2(C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2, O98 o98, VI2 vi2) {
        super(o98, c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        AbstractC13042fc3.i(vi2, "glideRequest");
        this.M0 = c11258ci2;
        this.N0 = vi2;
        this.R0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.si2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22714vi2.j4();
            }
        });
        ViewStub viewStub = l1().t;
        viewStub.setLayoutResource(HC5.feed_full_screen_video_holder);
        viewStub.setInflatedId(viewStub.getId());
        C23310wi2 c23310wi2A = C23310wi2.a(viewStub.inflate());
        this.O0 = c23310wi2A;
        this.P0 = c23310wi2A.h;
        l1().c.setVisibility(0);
        l1().p.i(new a());
    }

    private final void A4(boolean z) {
        ImageView imageView = this.O0.g;
        AbstractC13042fc3.h(imageView, "feedStateVideoIv");
        imageView.setVisibility(z ? 0 : 8);
        this.O0.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22714vi2.B4(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B4(C22714vi2 c22714vi2, View view) {
        AbstractC13042fc3.i(c22714vi2, "this$0");
        c22714vi2.b4();
    }

    private final void C4(boolean z) {
        FrameLayout frameLayout = this.O0.f;
        AbstractC13042fc3.h(frameLayout, "feedStateContainerVideo");
        frameLayout.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T3(C22714vi2 c22714vi2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c22714vi2, "this$0");
        C4485Fi2 c4485Fi2M3 = c22714vi2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2M3.onTouchEvent(motionEvent);
    }

    private final void U3() {
        com.google.android.exoplayer2.z0 z0Var;
        com.google.android.exoplayer2.z0 z0Var2;
        w4(false);
        z0.d dVar = this.T0;
        if (dVar != null && (z0Var2 = this.S0) != null) {
            z0Var2.o(dVar);
        }
        if (this.T0 == null && (z0Var = this.S0) != null) {
            c cVar = new c();
            this.T0 = cVar;
            z0Var.m0(cVar);
        }
    }

    private final C8031Uf5 W3() {
        return (C8031Uf5) this.R0.getValue();
    }

    private final void b4() {
        n4(C24480yh2.a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8031Uf5 j4() {
        return new C8031Uf5((int) ((24 * AbstractC3742Cd6.c()) + 0.5d), (int) ((16 * AbstractC3742Cd6.c()) + 0.5d), 300.0f);
    }

    private final void k4(boolean z) {
        this.O0.d.setKeepScreenOn(z);
    }

    private final void n4(com.google.android.exoplayer2.E0 e0) {
        l1().c.setPlayer(e0);
        this.S0 = e0;
    }

    private final void o4() {
        this.O0.c.setImageDrawable(W3());
        r1().g(new SA2() { // from class: ir.nasim.ti2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C22714vi2.r4(this.a));
            }
        });
        this.P0.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.ui2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C22714vi2.u4(this.a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r4(C22714vi2 c22714vi2) {
        AbstractC13042fc3.i(c22714vi2, "this$0");
        if (!c22714vi2.t3()) {
            return c22714vi2.s1().q();
        }
        TextView textView = c22714vi2.l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        c22714vi2.c3(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u4(C22714vi2 c22714vi2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c22714vi2, "this$0");
        C4485Fi2 c4485Fi2M3 = c22714vi2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2M3.onTouchEvent(motionEvent);
    }

    private final void v4(byte[] bArr) {
        ImageView imageView = this.O0.i;
        AbstractC13042fc3.h(imageView, "feedVideoThumbnail");
        imageView.setVisibility(0);
        C20107rU5 c20107rU5 = new C20107rU5();
        AbstractC15520jj2.h hVar = this.Q0;
        AbstractC15520jj2.h hVar2 = null;
        if (hVar == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar = null;
        }
        int iG = hVar.g();
        AbstractC15520jj2.h hVar3 = this.Q0;
        if (hVar3 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
        } else {
            hVar2 = hVar3;
        }
        AbstractC6302Na0 abstractC6302Na0Y0 = ((C20107rU5) c20107rU5.c0(iG, hVar2.e())).y0(new C5191Ih0(10, 3), new C13789gp2());
        AbstractC13042fc3.h(abstractC6302Na0Y0, "transform(...)");
        this.N0.z(bArr).b((C20107rU5) abstractC6302Na0Y0).Q0(this.O0.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w4(boolean z) {
        ImageView imageView = this.O0.c;
        AbstractC13042fc3.h(imageView, "feedPlayPause");
        AbstractC25084zi2.d(imageView, z, 0L, 2, null);
        CircleProgressBar circleProgressBar = this.O0.e;
        AbstractC13042fc3.h(circleProgressBar, "feedProgressVideo");
        circleProgressBar.setVisibility(z ^ true ? 0 : 8);
    }

    private final void x4(boolean z) {
        TextureView textureView = this.O0.d;
        if (z) {
            textureView.requestFocus();
        }
        AbstractC13042fc3.f(textureView);
        textureView.setVisibility(z ? 0 : 8);
        textureView.setAlpha(z ? 1.0f : 0.0f);
        ImageView imageView = this.O0.i;
        AbstractC13042fc3.h(imageView, "feedVideoThumbnail");
        imageView.setVisibility(z ^ true ? 0 : 8);
    }

    private final void y4(boolean z) {
        com.google.android.exoplayer2.z0 z0Var;
        CircleProgressBar circleProgressBar = this.O0.e;
        AbstractC13042fc3.h(circleProgressBar, "feedProgressVideo");
        boolean z2 = false;
        circleProgressBar.setVisibility(z ? 0 : 8);
        ImageView imageView = this.O0.c;
        AbstractC13042fc3.h(imageView, "feedPlayPause");
        if (!z && (z0Var = this.S0) != null && !z0Var.X()) {
            z2 = true;
        }
        AbstractC25084zi2.d(imageView, z2, 0L, 2, null);
    }

    public void S3(C5886Lg2 c5886Lg2, AbstractC15520jj2.h hVar) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(hVar, DialogEntity.COLUMN_MESSAGE);
        super.H2(c5886Lg2, hVar);
        this.Q0 = hVar;
        v3(c5886Lg2);
        V3();
        this.O0.b.setAspectRatio(hVar.g() / hVar.e());
        o4();
        TextView textView = l1().o;
        AbstractC13042fc3.h(textView, "feedPhotoText");
        f3(textView, c5886Lg2, hVar.c(), t1());
        com.google.android.exoplayer2.z0 z0Var = this.S0;
        if (z0Var != null) {
            z0Var.d0(this.O0.d);
        }
        CircleProgressBar circleProgressBar = this.O0.e;
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        circleProgressBar.setColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        circleProgressBar.setBgColor(c5495Jo7.y0(OY0.b(context2, AbstractC13999hA5.colorOnPrimary), 40));
        Drawable background = this.O0.f.getBackground();
        Context context3 = this.a.getContext();
        AbstractC13042fc3.h(context3, "getContext(...)");
        background.setColorFilter(new PorterDuffColorFilter(OY0.b(context3, AbstractC13999hA5.colorOnPrimary), PorterDuff.Mode.MULTIPLY));
        b4();
        com.google.android.exoplayer2.z0 z0Var2 = this.S0;
        if (z0Var2 == null || !z0Var2.i()) {
            v4(hVar.f());
            y4(true);
        } else {
            x4(true);
        }
        this.O0.h.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.ri2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C22714vi2.T3(this.a, view, motionEvent);
            }
        });
        U3();
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        GS7.a aVar = GS7.n;
        AbstractC15520jj2.h hVar = this.Q0;
        AbstractC15520jj2.h hVar2 = null;
        if (hVar == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar = null;
        }
        FileReference fileReferenceD = hVar.d();
        ArrayList arrayList = new ArrayList();
        AbstractC15520jj2.h hVar3 = this.Q0;
        if (hVar3 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar3 = null;
        }
        int iG = hVar3.g();
        AbstractC15520jj2.h hVar4 = this.Q0;
        if (hVar4 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar4 = null;
        }
        int iE = hVar4.e();
        AbstractC15520jj2.h hVar5 = this.Q0;
        if (hVar5 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar5 = null;
        }
        int iH = hVar5.h();
        AbstractC15520jj2.h hVar6 = this.Q0;
        if (hVar6 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar6 = null;
        }
        int iG2 = hVar6.g();
        AbstractC15520jj2.h hVar7 = this.Q0;
        if (hVar7 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar7 = null;
        }
        int iE2 = hVar7.e();
        AbstractC15520jj2.h hVar8 = this.Q0;
        if (hVar8 == null) {
            AbstractC13042fc3.y("feedVideoMessage");
        } else {
            hVar2 = hVar8;
        }
        return aVar.f(fileReferenceD, arrayList, iG, iE, iH, new C22694vg2(iG2, iE2, hVar2.f()));
    }

    public final void V3() {
        QI2 qi2 = QI2.a;
        ImageView imageView = this.O0.i;
        AbstractC13042fc3.h(imageView, "feedVideoThumbnail");
        qi2.a(imageView);
    }

    public final void X3() {
        ImageView imageView = this.O0.c;
        AbstractC13042fc3.h(imageView, "feedPlayPause");
        imageView.setVisibility(8);
    }

    @Override // ir.nasim.JA2, ir.nasim.AbstractC13019fa0
    public void a() {
        com.google.android.exoplayer2.z0 z0Var;
        super.a();
        this.a.setTag(null);
        com.google.android.exoplayer2.z0 z0Var2 = this.S0;
        if (z0Var2 != null) {
            z0Var2.d0(this.O0.d);
        }
        z0.d dVar = this.T0;
        if (dVar != null && (z0Var = this.S0) != null) {
            z0Var.o(dVar);
        }
        this.T0 = null;
        this.S0 = null;
        ImageView imageView = this.O0.i;
        this.N0.n(imageView);
        imageView.setImageDrawable(null);
    }

    public void c4() {
        k4(true);
        y4(true);
        C4(true);
        A4(false);
    }

    public void d4() {
        k4(false);
        y4(false);
        C4(false);
        A4(false);
    }

    public void g4(boolean z) {
        k4(z);
        x4(true);
        C4(false);
        y4(false);
        A4(false);
    }

    public final void h4() {
        InterfaceC13138fj2 interfaceC13138fj2S1 = s1();
        AbstractC15520jj2.h hVar = this.Q0;
        if (hVar == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar = null;
        }
        interfaceC13138fj2S1.g(hVar, this);
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: l3, reason: merged with bridge method [inline-methods] */
    public C11258ci2 l1() {
        return this.M0;
    }

    public final void l4(InterfaceC2037k interfaceC2037k) {
        AbstractC13042fc3.i(interfaceC2037k, "exoPlayer");
        interfaceC2037k.R(this.O0.d);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        AbstractC15520jj2.h hVar = this.Q0;
        if (hVar == null) {
            AbstractC13042fc3.y("feedVideoMessage");
            hVar = null;
        }
        return AbstractC20762sZ6.n0(hVar.c());
    }
}
