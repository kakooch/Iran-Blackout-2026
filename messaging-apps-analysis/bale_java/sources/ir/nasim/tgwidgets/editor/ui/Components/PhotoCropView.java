package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.C3417Au1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h;
import ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel;
import ir.nasim.tgwidgets.editor.ui.Components.Crop.CropView;

/* loaded from: classes7.dex */
public class PhotoCropView extends FrameLayout {
    private g a;
    public boolean b;
    public CropView c;
    public CropRotationWheel d;
    private boolean e;
    private ImageReceiver f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private AnimatorSet k;
    private AnimatorSet l;
    private float m;
    private Paint n;
    private final m.h o;
    public final Property p;
    public final Property q;

    class a extends AbstractC21469h.e {
        a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(PhotoCropView photoCropView) {
            return Float.valueOf(PhotoCropView.this.j);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(PhotoCropView photoCropView, float f) {
            PhotoCropView.this.j = f;
            photoCropView.invalidate();
        }
    }

    class b extends AbstractC21469h.e {
        b(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(PhotoCropView photoCropView) {
            return Float.valueOf(PhotoCropView.this.i);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(PhotoCropView photoCropView, float f) {
            PhotoCropView.this.i = f;
            photoCropView.invalidate();
        }
    }

    class c implements CropView.f {
        c() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropView.f
        public void a() {
            if (PhotoCropView.this.a != null) {
                PhotoCropView.this.a.a();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropView.f
        public void b() {
            if (PhotoCropView.this.a != null) {
                PhotoCropView.this.a.b();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropView.f
        public void c(boolean z) {
            PhotoCropView photoCropView = PhotoCropView.this;
            photoCropView.b = z;
            if (photoCropView.a != null) {
                PhotoCropView.this.a.c(z);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropView.f
        public void d(boolean z) {
            PhotoCropView.this.d.setAspectLock(z);
        }
    }

    class d implements CropRotationWheel.a {
        d() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public void a(float f) {
            PhotoCropView.this.c.setRotation(f);
            PhotoCropView photoCropView = PhotoCropView.this;
            photoCropView.b = false;
            if (photoCropView.a != null) {
                PhotoCropView.this.a.c(false);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public boolean d() {
            if (PhotoCropView.this.a != null) {
                return PhotoCropView.this.a.d();
            }
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public void e(float f) {
            PhotoCropView.this.c.P();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public void f() {
            PhotoCropView.this.c.O();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public boolean g() {
            if (PhotoCropView.this.a != null) {
                return PhotoCropView.this.a.g();
            }
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropRotationWheel.a
        public void h() {
            PhotoCropView.this.c.Z();
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoCropView.this.k = null;
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PhotoCropView.this.l = null;
        }
    }

    public interface g {
        void a();

        void b();

        void c(boolean z);

        boolean d();

        void e();

        int f();

        boolean g();
    }

    public PhotoCropView(Context context, m.h hVar) {
        super(context);
        this.b = true;
        this.h = true;
        this.j = 1.0f;
        this.m = 0.0f;
        this.n = new Paint(1);
        this.p = new a("thumbAnimationProgress");
        this.q = new b("thumbImageVisibleProgress");
        this.o = hVar;
        this.e = false;
        CropView cropView = new CropView(context);
        this.c = cropView;
        cropView.setListener(new c());
        this.c.setBottomPadding(AbstractC21455b.F(64.0f));
        addView(this.c);
        this.f = new ImageReceiver(this);
        CropRotationWheel cropRotationWheel = new CropRotationWheel(context);
        this.d = cropRotationWheel;
        cropRotationWheel.setListener(new d());
        addView(this.d, AbstractC13840gu3.c(-1, -2.0f, 81, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    private int i(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.o);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        CropView cropView;
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.g && view == (cropView = this.c)) {
            RectF actualRect = cropView.getActualRect();
            int iF = AbstractC21455b.F(32.0f);
            int iF2 = (this.a.f() - (iF / 2)) + AbstractC21455b.F(2.0f);
            int measuredHeight = getMeasuredHeight() - AbstractC21455b.F(156.0f);
            float f2 = actualRect.left;
            float f3 = this.j;
            float f4 = f2 + ((iF2 - f2) * f3);
            float f5 = actualRect.top;
            float f6 = f5 + ((measuredHeight - f5) * f3);
            float fWidth = actualRect.width() + ((iF - actualRect.width()) * this.j);
            this.f.k1((int) (fWidth / 2.0f));
            this.f.Y0(f4, f6, fWidth, fWidth);
            this.f.setAlpha(this.i);
            this.f.e(canvas);
            if (this.m > 0.0f) {
                this.n.setColor(-1);
                this.n.setAlpha((int) (this.m * 255.0f));
                canvas.drawCircle(actualRect.centerX(), actualRect.centerY(), actualRect.width() / 2.0f, this.n);
            }
            this.n.setColor(i(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4));
            this.n.setAlpha(Math.min(255, (int) (this.j * 255.0f * this.i)));
            canvas.drawCircle(iF2 + r1, measuredHeight + iF + AbstractC21455b.F(8.0f), AbstractC21455b.F(3.0f), this.n);
        }
        return zDrawChild;
    }

    public float getRectSizeX() {
        return this.c.getCropWidth();
    }

    public float getRectSizeY() {
        return this.c.getCropHeight();
    }

    public float getRectX() {
        return this.c.getCropLeft() - AbstractC21455b.F(14.0f);
    }

    public float getRectY() {
        return (this.c.getCropTop() - AbstractC21455b.F(14.0f)) - (!this.e ? AbstractC21455b.d : 0);
    }

    public Bitmap getVideoThumb() {
        if (this.g && this.h) {
            return this.f.l();
        }
        return null;
    }

    public void h() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.k = null;
            this.g = false;
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.c.invalidate();
    }

    public boolean j() {
        return this.c.E();
    }

    public void k(MediaController.l lVar) {
        this.c.K(lVar);
    }

    public boolean l() {
        return this.c.M();
    }

    public void m() {
        this.c.e0();
    }

    public void n() {
        this.c.Y();
    }

    public void o() {
        this.c.C();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.h || !this.g || !this.f.m0(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.a.e();
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.b0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.h || !this.g || !this.f.m0(motionEvent.getX(), motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.a.e();
        }
        return true;
    }

    public void p() {
        this.c.N();
    }

    public void q() {
        this.c.S();
    }

    public void r(boolean z) {
        this.d.j(true);
        this.c.U(z);
    }

    public boolean s(float f2) {
        CropRotationWheel cropRotationWheel = this.d;
        if (cropRotationWheel != null) {
            cropRotationWheel.j(false);
        }
        return this.c.W(f2);
    }

    public void setAspectRatio(float f2) {
        this.c.setAspectRatio(f2);
    }

    public void setBitmap(Bitmap bitmap, int i, boolean z, boolean z2, PaintingOverlay paintingOverlay, C3417Au1 c3417Au1, VideoEditTextureView videoEditTextureView, MediaController.i iVar) {
        requestLayout();
        this.g = false;
        this.f.W0(null);
        this.c.setBitmap(bitmap, i, z, z2, paintingOverlay, c3417Au1, videoEditTextureView, iVar);
        this.d.setFreeform(z);
        this.d.j(true);
        if (iVar != null) {
            this.d.setRotation(iVar.d, false);
            this.d.setRotated(iVar.i != 0);
            this.d.setMirrored(iVar.j);
        } else {
            this.d.setRotated(false);
            this.d.setMirrored(false);
        }
        this.d.setVisibility(z ? 0 : 4);
    }

    public void setDelegate(g gVar) {
        this.a = gVar;
    }

    public void setFreeform(boolean z) {
        this.c.setFreeform(z);
    }

    public void setSubtitle(String str) {
        this.c.setSubtitle(str);
    }

    public void setVideoThumb(Bitmap bitmap, int i) {
        this.g = bitmap != null;
        this.f.V0(bitmap);
        this.f.h1(i, false);
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.l;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.h = true;
        this.i = 1.0f;
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.k = animatorSet3;
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoCropView, Float>) this.p, 0.0f, 1.0f));
        this.k.setDuration(250L);
        this.k.setInterpolator(new OvershootInterpolator(1.01f));
        this.k.addListener(new e());
        this.k.start();
    }

    public void setVideoThumbFlashAlpha(float f2) {
        this.m = f2;
        invalidate();
    }

    public void setVideoThumbVisible(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.l = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<PhotoCropView, Float>) this.q, z ? 1.0f : 0.0f));
        this.l.setDuration(180L);
        this.l.addListener(new f());
        this.l.start();
    }
}
