package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC20563sD5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C12372eV7;
import ir.nasim.C16831lw1;
import ir.nasim.C18709p7;
import ir.nasim.DE5;
import ir.nasim.FB5;
import ir.nasim.InterfaceC22367v7;
import ir.nasim.InterfaceC9795aa2;
import ir.nasim.OA5;
import ir.nasim.VB5;
import ir.nasim.XC5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class StyledPlayerView extends FrameLayout implements InterfaceC22367v7 {
    private final a a;
    private final AspectRatioFrameLayout b;
    private final View c;
    private final View d;
    private final boolean e;
    private final ImageView f;
    private final SubtitleView g;
    private final View h;
    private final TextView i;
    private final StyledPlayerControlView j;
    private final FrameLayout k;
    private final FrameLayout l;
    private z0 m;
    private boolean n;
    private StyledPlayerControlView.m o;
    private boolean p;
    private Drawable q;
    private int r;
    private boolean s;
    private CharSequence t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;

    private final class a implements z0.d, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.m, StyledPlayerControlView.d {
        private final J0.b a = new J0.b();
        private Object b;

        public a() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void E0(int i) {
            StyledPlayerView.this.J();
            StyledPlayerView.this.M();
            StyledPlayerView.this.L();
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void R(z0.e eVar, z0.e eVar2, int i) {
            if (StyledPlayerView.this.y() && StyledPlayerView.this.w) {
                StyledPlayerView.this.w();
            }
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void S4(boolean z, int i) {
            StyledPlayerView.this.J();
            StyledPlayerView.this.L();
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void T2(K0 k0) {
            z0 z0Var = (z0) AbstractC20011rK.e(StyledPlayerView.this.m);
            J0 j0N = z0Var.K(17) ? z0Var.N() : J0.a;
            if (j0N.v()) {
                this.b = null;
            } else if (!z0Var.K(30) || z0Var.F().d()) {
                Object obj = this.b;
                if (obj != null) {
                    int iG = j0N.g(obj);
                    if (iG != -1) {
                        if (z0Var.r0() == j0N.k(iG, this.a).c) {
                            return;
                        }
                    }
                    this.b = null;
                }
            } else {
                this.b = j0N.l(z0Var.b0(), this.a, true).b;
            }
            StyledPlayerView.this.N(false);
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.m
        public void a(int i) {
            StyledPlayerView.this.K();
            StyledPlayerView.g(StyledPlayerView.this);
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.d
        public void e(boolean z) {
            StyledPlayerView.h(StyledPlayerView.this);
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void i(C16831lw1 c16831lw1) {
            if (StyledPlayerView.this.g != null) {
                StyledPlayerView.this.g.setCues(c16831lw1.a);
            }
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void l(C12372eV7 c12372eV7) {
            StyledPlayerView.this.I();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StyledPlayerView.this.H();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StyledPlayerView.q((TextureView) view, StyledPlayerView.this.y);
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void s() {
            if (StyledPlayerView.this.c != null) {
                StyledPlayerView.this.c.setVisibility(4);
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    private boolean B(z0 z0Var) {
        byte[] bArr;
        if (z0Var.K(18) && (bArr = z0Var.A0().j) != null) {
            return C(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
        }
        return false;
    }

    private boolean C(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                A(this.b, intrinsicWidth / intrinsicHeight);
                this.f.setImageDrawable(drawable);
                this.f.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void D(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    private boolean E() {
        z0 z0Var = this.m;
        if (z0Var == null) {
            return true;
        }
        int iP = z0Var.p();
        return this.v && !(this.m.K(17) && this.m.N().v()) && (iP == 1 || iP == 4 || !((z0) AbstractC20011rK.e(this.m)).X());
    }

    private void G(boolean z) {
        if (P()) {
            this.j.setShowTimeoutMs(z ? 0 : this.u);
            this.j.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (!P() || this.m == null) {
            return;
        }
        if (!this.j.f0()) {
            z(true);
        } else if (this.x) {
            this.j.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        z0 z0Var = this.m;
        C12372eV7 c12372eV7E0 = z0Var != null ? z0Var.e0() : C12372eV7.e;
        int i = c12372eV7E0.a;
        int i2 = c12372eV7E0.b;
        int i3 = c12372eV7E0.c;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * c12372eV7E0.d) / i2;
        View view = this.d;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.y != 0) {
                view.removeOnLayoutChangeListener(this.a);
            }
            this.y = i3;
            if (i3 != 0) {
                this.d.addOnLayoutChangeListener(this.a);
            }
            q((TextureView) this.d, this.y);
        }
        A(this.b, this.e ? 0.0f : f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void J() {
        /*
            r4 = this;
            android.view.View r0 = r4.h
            if (r0 == 0) goto L2b
            com.google.android.exoplayer2.z0 r0 = r4.m
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.p()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.r
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            com.google.android.exoplayer2.z0 r0 = r4.m
            boolean r0 = r0.X()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r0 = r4.h
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerView.J():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        StyledPlayerControlView styledPlayerControlView = this.j;
        if (styledPlayerControlView == null || !this.n) {
            setContentDescription(null);
        } else if (styledPlayerControlView.f0()) {
            setContentDescription(this.x ? getResources().getString(AbstractC20563sD5.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(AbstractC20563sD5.exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (y() && this.w) {
            w();
        } else {
            z(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        TextView textView = this.i;
        if (textView != null) {
            CharSequence charSequence = this.t;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.i.setVisibility(0);
            } else {
                z0 z0Var = this.m;
                if (z0Var != null) {
                    z0Var.a();
                }
                this.i.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z) {
        z0 z0Var = this.m;
        if (z0Var == null || !z0Var.K(30) || z0Var.F().d()) {
            if (this.s) {
                return;
            }
            v();
            r();
            return;
        }
        if (z && !this.s) {
            r();
        }
        if (z0Var.F().e(2)) {
            v();
            return;
        }
        r();
        if (O() && (B(z0Var) || C(this.q))) {
            return;
        }
        v();
    }

    private boolean O() {
        if (!this.p) {
            return false;
        }
        AbstractC20011rK.i(this.f);
        return true;
    }

    private boolean P() {
        if (!this.n) {
            return false;
        }
        AbstractC20011rK.i(this.j);
        return true;
    }

    static /* synthetic */ b g(StyledPlayerView styledPlayerView) {
        styledPlayerView.getClass();
        return null;
    }

    static /* synthetic */ c h(StyledPlayerView styledPlayerView) {
        styledPlayerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    private void r() {
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(AbstractC9683aN7.S(context, resources, FB5.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(OA5.exo_edit_mode_background_color));
    }

    private static void t(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(AbstractC9683aN7.S(context, resources, FB5.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(OA5.exo_edit_mode_background_color, null));
    }

    private void v() {
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f.setVisibility(4);
        }
    }

    private boolean x(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        z0 z0Var = this.m;
        return z0Var != null && z0Var.K(16) && this.m.k() && this.m.X();
    }

    private void z(boolean z) {
        if (!(y() && this.w) && P()) {
            boolean z2 = this.j.f0() && this.j.getShowTimeoutMs() <= 0;
            boolean zE = E();
            if (z || z2 || zE) {
                G(zE);
            }
        }
    }

    protected void A(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void F() {
        G(E());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        z0 z0Var = this.m;
        if (z0Var != null && z0Var.K(16) && this.m.k()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zX = x(keyEvent.getKeyCode());
        if (zX && P() && !this.j.f0()) {
            z(true);
            return true;
        }
        if (u(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            z(true);
            return true;
        }
        if (zX && P()) {
            z(true);
        }
        return false;
    }

    public List<C18709p7> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.l;
        if (frameLayout != null) {
            arrayList.add(new C18709p7(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.j;
        if (styledPlayerControlView != null) {
            arrayList.add(new C18709p7(styledPlayerControlView, 1));
        }
        return AbstractC12710f43.O(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) AbstractC20011rK.j(this.k, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.v;
    }

    public boolean getControllerHideOnTouch() {
        return this.x;
    }

    public int getControllerShowTimeoutMs() {
        return this.u;
    }

    public Drawable getDefaultArtwork() {
        return this.q;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.l;
    }

    public z0 getPlayer() {
        return this.m;
    }

    public int getResizeMode() {
        AbstractC20011rK.i(this.b);
        return this.b.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.g;
    }

    public boolean getUseArtwork() {
        return this.p;
    }

    public boolean getUseController() {
        return this.n;
    }

    public View getVideoSurfaceView() {
        return this.d;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!P() || this.m == null) {
            return false;
        }
        z(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        H();
        return super.performClick();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.b bVar) {
        AbstractC20011rK.i(this.b);
        this.b.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z) {
        this.v = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.w = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        AbstractC20011rK.i(this.j);
        this.x = z;
        K();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(StyledPlayerControlView.d dVar) {
        AbstractC20011rK.i(this.j);
        this.j.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        AbstractC20011rK.i(this.j);
        this.u = i;
        if (this.j.f0()) {
            F();
        }
    }

    public void setControllerVisibilityListener(b bVar) {
        if (bVar != null) {
            setControllerVisibilityListener((StyledPlayerControlView.m) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        AbstractC20011rK.g(this.i != null);
        this.t = charSequence;
        M();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.q != drawable) {
            this.q = drawable;
            N(false);
        }
    }

    public void setErrorMessageProvider(InterfaceC9795aa2 interfaceC9795aa2) {
        if (interfaceC9795aa2 != null) {
            M();
        }
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        AbstractC20011rK.i(this.j);
        this.j.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(c cVar) {
        AbstractC20011rK.i(this.j);
        this.j.setOnFullScreenModeChangedListener(this.a);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.s != z) {
            this.s = z;
            N(false);
        }
    }

    public void setPlayer(z0 z0Var) {
        AbstractC20011rK.g(Looper.myLooper() == Looper.getMainLooper());
        AbstractC20011rK.a(z0Var == null || z0Var.O() == Looper.getMainLooper());
        z0 z0Var2 = this.m;
        if (z0Var2 == z0Var) {
            return;
        }
        if (z0Var2 != null) {
            z0Var2.o(this.a);
            if (z0Var2.K(27)) {
                View view = this.d;
                if (view instanceof TextureView) {
                    z0Var2.d0((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    z0Var2.t0((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.g;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.m = z0Var;
        if (P()) {
            this.j.setPlayer(z0Var);
        }
        J();
        M();
        N(true);
        if (z0Var == null) {
            w();
            return;
        }
        if (z0Var.K(27)) {
            View view2 = this.d;
            if (view2 instanceof TextureView) {
                z0Var.R((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                z0Var.v((SurfaceView) view2);
            }
            I();
        }
        if (this.g != null && z0Var.K(28)) {
            this.g.setCues(z0Var.H().a);
        }
        z0Var.m0(this.a);
        z(false);
    }

    public void setRepeatToggleModes(int i) {
        AbstractC20011rK.i(this.j);
        this.j.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AbstractC20011rK.i(this.b);
        this.b.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.r != i) {
            this.r = i;
            J();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        AbstractC20011rK.i(this.j);
        this.j.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.c;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        AbstractC20011rK.g((z && this.f == null) ? false : true);
        if (this.p != z) {
            this.p = z;
            N(false);
        }
    }

    public void setUseController(boolean z) {
        boolean z2 = true;
        AbstractC20011rK.g((z && this.j == null) ? false : true);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.n == z) {
            return;
        }
        this.n = z;
        if (P()) {
            this.j.setPlayer(this.m);
        } else {
            StyledPlayerControlView styledPlayerControlView = this.j;
            if (styledPlayerControlView != null) {
                styledPlayerControlView.b0();
                this.j.setPlayer(null);
            }
        }
        K();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public boolean u(KeyEvent keyEvent) {
        return P() && this.j.U(keyEvent);
    }

    public void w() {
        StyledPlayerControlView styledPlayerControlView = this.j;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.b0();
        }
    }

    public StyledPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void setControllerVisibilityListener(StyledPlayerControlView.m mVar) {
        AbstractC20011rK.i(this.j);
        StyledPlayerControlView.m mVar2 = this.o;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.j.m0(mVar2);
        }
        this.o = mVar;
        if (mVar != null) {
            this.j.S(mVar);
            setControllerVisibilityListener((b) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyledPlayerView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        boolean z;
        int i3;
        int integer;
        boolean z2;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        boolean z7;
        int i7;
        boolean z8;
        super(context, attributeSet, i);
        a aVar = new a();
        this.a = aVar;
        if (isInEditMode()) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = false;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            ImageView imageView = new ImageView(context);
            if (AbstractC9683aN7.a >= 23) {
                t(context, getResources(), imageView);
            } else {
                s(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = XC5.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, DE5.StyledPlayerView, i, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(DE5.StyledPlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(DE5.StyledPlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(DE5.StyledPlayerView_player_layout_id, i8);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(DE5.StyledPlayerView_default_artwork, 0);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_use_controller, true);
                int i9 = typedArrayObtainStyledAttributes.getInt(DE5.StyledPlayerView_surface_type, 1);
                int i10 = typedArrayObtainStyledAttributes.getInt(DE5.StyledPlayerView_resize_mode, 0);
                int i11 = typedArrayObtainStyledAttributes.getInt(DE5.StyledPlayerView_show_timeout, 5000);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_hide_on_touch, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(DE5.StyledPlayerView_show_buffering, 0);
                this.s = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_keep_content_on_player_reset, this.s);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z3 = z11;
                z = z12;
                i3 = i10;
                z6 = z10;
                i6 = resourceId2;
                z5 = z9;
                i5 = color;
                z4 = zHasValue;
                i4 = i9;
                i8 = resourceId;
                i2 = i11;
                z2 = z13;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i2 = 5000;
            z = true;
            i3 = 0;
            integer = 0;
            z2 = true;
            z3 = true;
            i4 = 1;
            z4 = false;
            i5 = 0;
            z5 = true;
            i6 = 0;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(VB5.exo_content_frame);
        this.b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            D(aspectRatioFrameLayout, i3);
        }
        View viewFindViewById = findViewById(VB5.exo_shutter);
        this.c = viewFindViewById;
        if (viewFindViewById != null && z4) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.d = new TextureView(context);
            } else if (i4 == 3) {
                try {
                    int i12 = SphericalGLSurfaceView.m;
                    this.d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    z8 = true;
                    this.d.setLayoutParams(layoutParams);
                    this.d.setOnClickListener(aVar);
                    this.d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.d, 0);
                    z7 = z8;
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i4 != 4) {
                this.d = new SurfaceView(context);
            } else {
                try {
                    int i13 = VideoDecoderGLSurfaceView.b;
                    this.d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            z8 = false;
            this.d.setLayoutParams(layoutParams);
            this.d.setOnClickListener(aVar);
            this.d.setClickable(false);
            aspectRatioFrameLayout.addView(this.d, 0);
            z7 = z8;
        } else {
            this.d = null;
            z7 = false;
        }
        this.e = z7;
        this.k = (FrameLayout) findViewById(VB5.exo_ad_overlay);
        this.l = (FrameLayout) findViewById(VB5.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(VB5.exo_artwork);
        this.f = imageView2;
        this.p = z5 && imageView2 != null;
        if (i6 != 0) {
            this.q = AbstractC4043Dl1.f(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(VB5.exo_subtitles);
        this.g = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(VB5.exo_buffering);
        this.h = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.r = integer;
        TextView textView = (TextView) findViewById(VB5.exo_error_message);
        this.i = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(VB5.exo_controller);
        View viewFindViewById3 = findViewById(VB5.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.j = styledPlayerControlView;
            i7 = 0;
        } else if (viewFindViewById3 != null) {
            i7 = 0;
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.j = styledPlayerControlView2;
            styledPlayerControlView2.setId(VB5.exo_controller);
            styledPlayerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(styledPlayerControlView2, iIndexOfChild);
        } else {
            i7 = 0;
            this.j = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.j;
        this.u = styledPlayerControlView3 != null ? i2 : i7;
        this.x = z3;
        this.v = z;
        this.w = z2;
        this.n = (!z6 || styledPlayerControlView3 == null) ? i7 : 1;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.c0();
            this.j.S(aVar);
        }
        if (z6) {
            setClickable(true);
        }
        K();
    }
}
