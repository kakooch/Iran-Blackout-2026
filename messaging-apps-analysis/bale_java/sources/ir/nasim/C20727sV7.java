package ir.nasim;

import android.content.Context;
import android.graphics.Outline;
import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.C2035j;
import com.google.android.exoplayer2.ui.PlayerView;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C19835r13;
import ir.nasim.X2;
import ir.nasim.animation.view.transition.sharedelement.Corners;
import ir.nasim.core.modules.file.audio.audiofocus.c;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubblePlayerView;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.sV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20727sV7 extends C19835r13 implements WZ, ir.nasim.core.modules.file.audio.audiofocus.c {
    private final XZ A0;
    private final ConstraintLayout B0;
    private final PlayerView C0;
    private final ImageView D0;
    private final InterfaceC9173Yu3 E0;
    private final InterfaceC9173Yu3 F0;
    private View G0;
    private final c.a H0;
    private final C25112zl0 I0;

    /* renamed from: ir.nasim.sV7$a */
    public static final class a extends C19835r13.b {
        private final XZ c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, XZ xz, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(xz, "lifecycleOwner");
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.c = xz;
        }

        @Override // ir.nasim.C19835r13.b, ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C20727sV7(c15481jf3, z, this.c, c());
        }
    }

    /* renamed from: ir.nasim.sV7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.b.values().length];
            try {
                iArr[c.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.sV7$c */
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), AbstractC8943Xx1.c(10));
        }
    }

    /* renamed from: ir.nasim.sV7$d */
    public static final class d implements InterfaceC20718sU7 {
        d() {
        }

        @Override // ir.nasim.InterfaceC20718sU7
        public void a() {
            C20727sV7.this.C0.setPlayer(null);
            C20727sV7.this.G0 = null;
        }

        @Override // ir.nasim.InterfaceC20718sU7
        public void l(com.google.android.exoplayer2.E0 e0, float f) {
            AbstractC13042fc3.i(e0, "player");
            C20727sV7.this.C0.setPlayer(e0);
            C20727sV7 c20727sV7 = C20727sV7.this;
            c20727sV7.G0 = c20727sV7.C0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20727sV7(final C15481jf3 c15481jf3, boolean z, XZ xz, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(xz, "lifecycleOwner");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        this.A0 = xz;
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.B0 = constraintLayout;
        this.E0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20727sV7.v2(c15481jf3);
            }
        });
        this.F0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20727sV7.z2(c15481jf3);
            }
        });
        this.H0 = c.a.e;
        C9263Ze3 c9263Ze3J1 = J1();
        ViewGroup.LayoutParams layoutParams = c9263Ze3J1.c.getLayoutParams();
        c9263Ze3J1.getRoot().removeView(c9263Ze3J1.c);
        BubblePlayerView bubblePlayerViewW2 = w2();
        bubblePlayerViewW2.setOnPlayerClicked(new SA2() { // from class: ir.nasim.qV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20727sV7.A2(this.a);
            }
        });
        this.C0 = bubblePlayerViewW2;
        this.D0 = (ImageView) bubblePlayerViewW2.findViewById(VB5.exo_artwork);
        c9263Ze3J1.getRoot().addView(bubblePlayerViewW2, 0, layoutParams);
        Context context = c9263Ze3J1.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        int iB = OY0.b(context, AbstractC21139tA5.bubble_background_icon);
        C11411cx6 c11411cx6W = new C11411cx6().w(AbstractC8943Xx1.c(18));
        AbstractC13042fc3.h(c11411cx6W, "withCornerSize(...)");
        AppCompatImageView appCompatImageView = c9263Ze3J1.d;
        C10345bV3 c10345bV3 = new C10345bV3(c11411cx6W);
        c10345bV3.setTint(iB);
        appCompatImageView.setBackground(c10345bV3);
        this.I0 = new C25112zl0(bubblePlayerViewW2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A2(C20727sV7 c20727sV7) {
        AbstractC13042fc3.i(c20727sV7, "this$0");
        C22007uW1 c22007uW1H1 = c20727sV7.H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        if (c18927pU7 != null) {
            c18927pU7.g0();
        }
        return C19938rB7.a;
    }

    private final void B2(boolean z) {
        com.google.android.exoplayer2.E0 e0Z;
        if (!z) {
            ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(this);
            return;
        }
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        if (c18927pU7 != null && (e0Z = c18927pU7.Z()) != null) {
            C2035j c2035jS0 = e0Z.S0();
            AbstractC13042fc3.h(c2035jS0, "getDeviceInfo(...)");
            if (e0Z.T0() == c2035jS0.b) {
                x2().adjustStreamVolume(3, -1, 1);
            }
        }
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C2(C20727sV7 c20727sV7, boolean z) {
        AbstractC13042fc3.i(c20727sV7, "this$0");
        c20727sV7.D2(z);
        c20727sV7.B2(z);
        return C19938rB7.a;
    }

    private final void D2(boolean z) {
        J1().d.setContentDescription(x0().getRoot().getContext().getString(z ? AbstractC12217eE5.chat_unmute : AbstractC12217eE5.chat_mute));
        AppCompatImageView appCompatImageView = J1().d;
        X2.a aVar = X2.a.i;
        String string = z ? J1().d.getContext().getString(AbstractC12217eE5.chat_unmute) : J1().d.getContext().getString(AbstractC12217eE5.chat_unmute);
        AppCompatImageView appCompatImageView2 = J1().d;
        AbstractC13042fc3.h(appCompatImageView2, "imageViewVolumeState");
        AbstractC12990fW7.l0(appCompatImageView, aVar, string, new C21347tV7(appCompatImageView2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioManager v2(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        Object systemService = c15481jf3.getRoot().getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    private final BubblePlayerView w2() {
        C24518yl0 c24518yl0C = C24518yl0.c(LayoutInflater.from(x0().getRoot().getContext()), x0().getRoot(), false);
        AbstractC13042fc3.h(c24518yl0C, "inflate(...)");
        BubblePlayerView root = c24518yl0C.getRoot();
        root.setUseArtwork(true);
        root.setUseController(false);
        root.setControllerAutoShow(false);
        root.setControllerHideOnTouch(false);
        root.setKeepContentOnPlayerReset(true);
        root.setResizeMode(4);
        Context context = root.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        root.setShutterBackgroundColor(OY0.b(context, AbstractC21139tA5.bubble_third));
        root.setOutlineProvider(new c());
        root.setClipToOutline(true);
        AbstractC13042fc3.h(root, "apply(...)");
        return root;
    }

    private final AudioManager x2() {
        return (AudioManager) this.E0.getValue();
    }

    private final VI2 y2() {
        return (VI2) this.F0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VI2 z2(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        return OI2.c(c15481jf3.getRoot());
    }

    @Override // ir.nasim.C19835r13
    public AbstractC17168mW3 C1(AbstractC17757nW1.c cVar, XV4 xv4) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(xv4, "measuredSize");
        return new C17754nV7(y2(), this.C0, D1(), cVar.e(), xv4);
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.B0;
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7
    protected C25112zl0 E0() {
        return this.I0;
    }

    @Override // ir.nasim.C19835r13
    protected View M1() {
        return this.C0;
    }

    @Override // ir.nasim.C19835r13
    protected void U1(AbstractC17757nW1.c cVar, C22007uW1 c22007uW1) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c22007uW1, "documentBinder");
        super.U1(cVar, c22007uW1);
        if (c22007uW1 instanceof C18927pU7) {
            C18927pU7 c18927pU7 = (C18927pU7) c22007uW1;
            AppCompatImageView appCompatImageView = J1().d;
            AbstractC13042fc3.h(appCompatImageView, "imageViewVolumeState");
            c18927pU7.e0(new MV7(appCompatImageView, null, null, new UA2() { // from class: ir.nasim.rV7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C20727sV7.C2(this.a, ((Boolean) obj).booleanValue());
                }
            }, 6, null));
            c18927pU7.e0(new d());
        }
    }

    @Override // ir.nasim.C19835r13, ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        this.A0.V4(this);
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(this);
        super.a();
        PlayerView playerView = this.C0;
        playerView.setVisibility(8);
        AbstractC12990fW7.L0(playerView, null);
        AbstractC12990fW7.L0(this.D0, null);
    }

    @Override // ir.nasim.C19835r13, ir.nasim.InterfaceC20284rl0, ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        View view = this.G0;
        if (view != null) {
            return new C8948Xx6(view, new Corners(AbstractC8943Xx1.c(10)));
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void e() {
        PlayerView playerView = this.C0;
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        playerView.setPlayer(c18927pU7 != null ? c18927pU7.c0() : null);
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void f() {
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(this);
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            e0Z.g(0.0f);
            e0Z.h();
        }
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public c.a getContentType() {
        return this.H0;
    }

    @Override // ir.nasim.WZ
    public void k() {
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(this);
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            e0Z.h();
        }
    }

    @Override // ir.nasim.WZ
    public void m() {
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            e0Z.g(0.0f);
            e0Z.q();
        }
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public void p(c.b bVar) {
        float f;
        AbstractC13042fc3.i(bVar, "lossType");
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            int i = b.a[bVar.ordinal()];
            if (i == 1) {
                f = 0.0f;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 0.5f;
            }
            e0Z.g(f);
        }
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void u() {
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        if (c18927pU7 != null) {
            c18927pU7.f0();
        }
        this.C0.setPlayer(null);
    }

    @Override // ir.nasim.C19835r13
    protected void u1(XV4 xv4, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.A0.q4(this);
        ImageView imageView = this.D0;
        AbstractC12990fW7.L0(imageView, "thumb_" + c8967Xz7.h().i() + c8967Xz7.h().h());
        this.G0 = imageView;
        PlayerView playerView = this.C0;
        playerView.setContentDescription(playerView.getRootView().getContext().getString(AbstractC12217eE5.video_type_content_description));
        playerView.setVisibility(0);
        long jI = c8967Xz7.h().i();
        long jH = c8967Xz7.h().h();
        StringBuilder sb = new StringBuilder();
        sb.append(jI);
        sb.append(jH);
        AbstractC12990fW7.L0(playerView, sb.toString());
        super.u1(xv4, c8967Xz7);
    }

    @Override // ir.nasim.InterfaceC7879To6
    public void v() {
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            e0Z.q();
        }
    }

    @Override // ir.nasim.core.modules.file.audio.audiofocus.c
    public void x() {
        C22007uW1 c22007uW1H1 = H1();
        C18927pU7 c18927pU7 = c22007uW1H1 instanceof C18927pU7 ? (C18927pU7) c22007uW1H1 : null;
        com.google.android.exoplayer2.E0 e0Z = c18927pU7 != null ? c18927pU7.Z() : null;
        if (e0Z != null) {
            e0Z.g(1.0f);
        }
    }

    @Override // ir.nasim.C19835r13
    protected C22007uW1 y1(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(cVar, "document");
        Context context = x0().getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        long jI = c8967Xz7.h().i();
        long jH = c8967Xz7.h().h();
        StringBuilder sb = new StringBuilder();
        sb.append(jI);
        sb.append(jH);
        return new C18927pU7(context, cVar, c14970in2D, sb.toString(), new C12660ez3(this.A0), null, G0(), 32, null);
    }
}
