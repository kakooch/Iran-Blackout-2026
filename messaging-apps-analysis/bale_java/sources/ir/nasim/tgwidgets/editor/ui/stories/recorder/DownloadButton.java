package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC14525i33;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC24188yB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C16556lU0;
import ir.nasim.C18981pa7;
import ir.nasim.C5713Kn0;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.IOException;

/* loaded from: classes7.dex */
public class DownloadButton extends ImageView {
    private int a;
    private FrameLayout b;
    private m.h c;
    private boolean d;
    private boolean e;
    private boolean f;
    private C16556lU0 g;
    private Utilities.b h;
    private PreparingVideoToast i;
    private l j;
    private a k;
    private Uri l;
    private boolean m;
    private boolean n;

    public static class PreparingVideoToast extends View {
        private Runnable A;
        private final Paint a;
        private final TextPaint b;
        private final TextPaint c;
        private final Paint d;
        private final Paint e;
        private final Paint f;
        private final C5713Kn0 g;
        private RLottieDrawable h;
        private final StaticLayout i;
        private final float j;
        private final float k;
        private StaticLayout l;
        private float m;
        private float n;
        private boolean o;
        private final C9151Ys p;
        private boolean q;
        private float r;
        private final C9151Ys s;
        private final C9151Ys t;
        private final RectF u;
        private final RectF v;
        private final RectF w;
        private final RectF x;
        private boolean y;
        private Runnable z;

        public PreparingVideoToast(Context context) {
            int i;
            float lineWidth;
            super(context);
            Paint paint = new Paint(1);
            this.a = paint;
            TextPaint textPaint = new TextPaint(1);
            this.b = textPaint;
            TextPaint textPaint2 = new TextPaint(1);
            this.c = textPaint2;
            Paint paint2 = new Paint(1);
            this.d = paint2;
            Paint paint3 = new Paint(1);
            this.e = paint3;
            Paint paint4 = new Paint(1);
            this.f = paint4;
            this.g = new C5713Kn0(this);
            this.o = false;
            this.p = new C9151Ys(0.0f, this, 0L, 350L, InterpolatorC12631ew1.h);
            this.q = true;
            this.r = 0.0f;
            this.s = new C9151Ys(this);
            this.t = new C9151Ys(this);
            this.u = new RectF();
            this.v = new RectF();
            this.w = new RectF();
            this.x = new RectF();
            paint.setColor(1509949440);
            textPaint.setColor(-1);
            textPaint2.setColor(-1);
            paint2.setColor(-869783512);
            paint3.setColor(-1);
            paint4.setColor(872415231);
            Paint.Style style = Paint.Style.STROKE;
            paint3.setStyle(style);
            Paint.Cap cap = Paint.Cap.ROUND;
            paint3.setStrokeCap(cap);
            paint3.setStrokeWidth(AbstractC21455b.F(4.0f));
            paint4.setStyle(style);
            paint4.setStrokeCap(cap);
            paint4.setStrokeWidth(AbstractC21455b.F(4.0f));
            textPaint.setTextSize(AbstractC21455b.F(14.0f));
            textPaint2.setTextSize(AbstractC21455b.H(14.66f));
            textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            textPaint2.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            StaticLayout staticLayout = new StaticLayout(FH3.E("PreparingVideo", TD5.tgwidget_PreparingVideo), textPaint, AbstractC21455b.h.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.i = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                i = 0;
                lineWidth = staticLayout.getLineWidth(0);
            } else {
                i = 0;
                lineWidth = 0.0f;
            }
            this.j = lineWidth;
            this.k = staticLayout.getLineCount() > 0 ? staticLayout.getLineLeft(i) : 0.0f;
            f();
        }

        private void b(Canvas canvas, float f) {
            float fC = this.t.c(this.r);
            float fCenterX = this.u.centerX();
            float F = this.u.top + AbstractC21455b.F(48.0f);
            float F2 = AbstractC21455b.F(25.0f);
            this.f.setAlpha((int) (51.0f * f));
            canvas.drawCircle(fCenterX, F, F2, this.f);
            RectF rectF = AbstractC21455b.x;
            rectF.set(fCenterX - F2, F - F2, fCenterX + F2, F2 + F);
            int i = (int) (f * 255.0f);
            this.e.setAlpha(i);
            this.e.setStrokeWidth(AbstractC21455b.F(4.0f));
            canvas.drawArc(rectF, -90.0f, fC * 360.0f, false, this.e);
            float fE = this.g.e(0.15f);
            canvas.save();
            canvas.scale(fE, fE, fCenterX, F);
            this.e.setStrokeWidth(AbstractC21455b.F(3.4f));
            canvas.drawLine(fCenterX - AbstractC21455b.F(7.0f), F - AbstractC21455b.F(7.0f), fCenterX + AbstractC21455b.F(7.0f), F + AbstractC21455b.F(7.0f), this.e);
            canvas.drawLine(fCenterX - AbstractC21455b.F(7.0f), F + AbstractC21455b.F(7.0f), fCenterX + AbstractC21455b.F(7.0f), F - AbstractC21455b.F(7.0f), this.e);
            canvas.restore();
            canvas.save();
            canvas.translate((this.u.left + AbstractC21455b.F(21.0f)) - this.k, (this.u.bottom - AbstractC21455b.F(18.0f)) - this.i.getHeight());
            this.b.setAlpha(i);
            this.i.draw(canvas);
            canvas.restore();
        }

        private void c(Canvas canvas, float f) {
            if (this.l != null) {
                canvas.save();
                canvas.translate((this.v.left + AbstractC21455b.F(15.0f)) - this.n, this.v.centerY() - (this.l.getHeight() / 2.0f));
                this.c.setAlpha((int) (f * 255.0f));
                this.l.draw(canvas);
                canvas.restore();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (getParent() instanceof ViewGroup) {
                ((ViewGroup) getParent()).removeView(this);
            }
        }

        public void d() {
            Runnable runnable = this.z;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
                this.z = null;
            }
            this.o = false;
            invalidate();
        }

        public void f() {
            this.o = true;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int saveCount = canvas.getSaveCount();
            float fC = this.p.c(this.o ? 1.0f : 0.0f);
            float fC2 = this.s.c(this.q ? 0.0f : 1.0f);
            float f = 1.0f - fC2;
            this.a.setAlpha((int) (90.0f * f * fC));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
            float fMax = Math.max(this.j, AbstractC21455b.F(54.0f)) + AbstractC21455b.F(42.0f);
            float F = AbstractC21455b.F(111.0f) + this.i.getHeight();
            this.u.set((getWidth() - fMax) / 2.0f, (getHeight() - F) / 2.0f, (getWidth() + fMax) / 2.0f, (getHeight() + F) / 2.0f);
            float F2 = AbstractC21455b.F(29.0f) + this.m;
            float F3 = AbstractC21455b.F(48.0f);
            this.v.set((getWidth() - F2) / 2.0f, (getHeight() - F3) / 2.0f, (getWidth() + F2) / 2.0f, (getHeight() + F3) / 2.0f);
            AbstractC21455b.W0(this.u, this.v, fC2, this.w);
            if (fC < 1.0f && this.q) {
                this.x.set(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, getHeight() / 2.0f);
                RectF rectF = this.x;
                RectF rectF2 = this.w;
                AbstractC21455b.W0(rectF, rectF2, fC, rectF2);
            }
            if (fC < 1.0f && !this.q) {
                canvas.scale(AbstractC21455b.T0(0.8f, 1.0f, fC), AbstractC21455b.T0(0.8f, 1.0f, fC), this.w.centerX(), this.w.centerY());
            }
            this.d.setAlpha((int) (204.0f * fC));
            canvas.drawRoundRect(this.w, AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f), this.d);
            canvas.save();
            canvas.clipRect(this.w);
            if (fC2 < 1.0f) {
                b(canvas, f * fC);
            }
            if (fC2 > 0.0f) {
                c(canvas, fC2 * fC);
            }
            canvas.restoreToCount(saveCount);
            if (fC > 0.0f || this.o || this.y) {
                return;
            }
            this.y = true;
            post(new Runnable() { // from class: ir.nasim.zX1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e();
                }
            });
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean zContains = this.w.contains(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (this.q || zContains)) {
                this.g.i(zContains);
                return true;
            }
            if (motionEvent.getAction() == 1) {
                if (this.g.g()) {
                    if (zContains) {
                        if (this.q) {
                            Runnable runnable = this.A;
                            if (runnable != null) {
                                runnable.run();
                            }
                        } else {
                            d();
                        }
                    }
                    this.g.i(false);
                    return true;
                }
            } else if (motionEvent.getAction() == 3) {
                this.g.i(false);
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        public void setDone(int i, CharSequence charSequence, int i2) {
            StaticLayout staticLayout = new StaticLayout(charSequence, this.c, AbstractC21455b.h.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.l = staticLayout;
            this.m = staticLayout.getLineCount() > 0 ? this.l.getLineWidth(0) : 0.0f;
            this.n = this.l.getLineCount() > 0 ? this.l.getLineLeft(0) : 0.0f;
            this.q = false;
            invalidate();
            Runnable runnable = this.z;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.nasim.yX1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d();
                }
            };
            this.z = runnable2;
            AbstractC21455b.n1(runnable2, i2);
        }

        public void setOnCancelListener(Runnable runnable) {
            this.A = runnable;
        }

        public void setProgress(float f) {
            this.r = f;
            invalidate();
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return drawable == this.h || super.verifyDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a implements E.d {
        final int a;
        final l b;
        final File c;
        private C10743c74 d;
        private final Runnable e;
        private final Utilities.b f;
        private final Runnable g;

        public a(int i, l lVar, File file, Runnable runnable, Utilities.b bVar, Runnable runnable2) {
            this.a = i;
            this.b = lVar;
            this.c = file;
            this.e = runnable;
            this.f = bVar;
            this.g = runnable2;
            c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(H h) {
            C10743c74 c10743c74 = this.d;
            if (c10743c74 == null) {
                return;
            }
            c10743c74.D = h;
            MediaController.Y().G0(this.d);
        }

        public void c() {
            if (this.d != null) {
                return;
            }
            E.k(this.a).e(this, E.O1);
            E.k(this.a).e(this, E.P1);
            E.k(this.a).e(this, E.Q1);
            C18981pa7 c18981pa7 = new C18981pa7();
            c18981pa7.b = 1;
            c18981pa7.M = this.c.getAbsolutePath();
            this.d = new C10743c74(this.a, c18981pa7, null, false, false);
            this.b.w(new Utilities.b() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.a
                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                public final void a(Object obj) {
                    this.a.b((H) obj);
                }
            });
        }

        public void d(boolean z) {
            if (this.d == null) {
                return;
            }
            E.k(this.a).u(this, E.O1);
            E.k(this.a).u(this, E.P1);
            E.k(this.a).u(this, E.Q1);
            if (z) {
                MediaController.Y().P(this.d);
            }
            this.d = null;
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.E.d
        public void t(int i, int i2, Object... objArr) {
            if (i == E.O1) {
                return;
            }
            if (i != E.P1) {
                if (i == E.Q1 && ((C10743c74) objArr[0]) == this.d) {
                    d(false);
                    try {
                        File file = this.c;
                        if (file != null) {
                            file.delete();
                        }
                    } catch (Exception unused) {
                    }
                    this.g.run();
                    return;
                }
                return;
            }
            if (((C10743c74) objArr[0]) == this.d) {
                ((Long) objArr[2]).longValue();
                long jLongValue = ((Long) objArr[3]).longValue();
                Float f = (Float) objArr[4];
                f.floatValue();
                Utilities.b bVar = this.f;
                if (bVar != null) {
                    bVar.a(f);
                }
                if (jLongValue > 0) {
                    this.e.run();
                    d(false);
                }
            }
        }
    }

    public DownloadButton(Context context, Utilities.b bVar, int i, FrameLayout frameLayout, m.h hVar) {
        super(context);
        this.m = true;
        this.n = true;
        this.h = bVar;
        this.a = i;
        this.b = frameLayout;
        this.c = hVar;
        setScaleType(ImageView.ScaleType.CENTER);
        AbstractC14525i33.c(this, ColorStateList.valueOf(-1));
        setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(553648127));
        setVisibility(8);
        setAlpha(0.0f);
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oX1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.k(view);
            }
        });
        this.g = new C16556lU0(AbstractC21455b.F(18.0f), AbstractC21455b.F(2.0f), -1);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f = false;
        a aVar = this.k;
        if (aVar != null) {
            aVar.d(true);
            this.k = null;
        }
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.d();
        }
        this.d = false;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Uri uri) {
        if (!this.d || this.j == null) {
            return;
        }
        this.i.setDone(AbstractC19363qD5.ic_save_to_gallery, FH3.E("VideoSavedHint", TD5.tgwidget_VideoSavedHint), 3500);
        this.d = false;
        x();
        this.l = uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(File file) {
        if (!this.d || this.j == null) {
            return;
        }
        MediaController.E0(file.getAbsolutePath(), getContext(), 1, null, null, new Utilities.b() { // from class: ir.nasim.vX1
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.m((Uri) obj);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Float f) {
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.setProgress(f.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (!this.d || this.j == null) {
            return;
        }
        this.i.setDone(AbstractC19363qD5.error, FH3.E("VideoConvertFail", TD5.tgwidget_VideoConvertFail), 3500);
        this.d = false;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Uri uri) {
        this.d = false;
        x();
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.d();
            this.i = null;
        }
        PreparingVideoToast preparingVideoToast2 = new PreparingVideoToast(getContext());
        this.i = preparingVideoToast2;
        preparingVideoToast2.setDone(AbstractC19363qD5.ic_save_to_gallery, FH3.E("PhotoSavedHint", TD5.tgwidget_PhotoSavedHint), 2500);
        this.b.addView(this.i);
        this.l = uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(File file) {
        MediaController.E0(file.getAbsolutePath(), getContext(), 0, null, null, new Utilities.b() { // from class: ir.nasim.xX1
            @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
            public final void a(Object obj) {
                this.a.q((Uri) obj);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final File file) throws IOException {
        this.j.j(file);
        if (!this.d || this.j == null) {
            return;
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.wX1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(file);
            }
        });
    }

    private void t() {
        int i = Build.VERSION.SDK_INT;
        if ((i <= 28 || AbstractC8814Xl0.e) && getContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            Activity activityK = AbstractC21455b.K(getContext());
            if (activityK != null) {
                activityK.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 113);
                return;
            }
            return;
        }
        if (this.d || this.j == null) {
            return;
        }
        if (this.l != null) {
            if (i >= 30) {
                getContext().getContentResolver().delete(this.l, null);
                this.l = null;
            } else if (i < 29) {
                try {
                    new File(this.l.toString()).delete();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                this.l = null;
            }
        }
        this.d = true;
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.d();
            this.i = null;
        }
        Utilities.b bVar = this.h;
        if (bVar != null) {
            this.f = true;
            bVar.a(new Runnable() { // from class: ir.nasim.pX1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u();
                }
            });
        }
        if (this.j.O()) {
            this.e = true;
            a aVar = this.k;
            if (aVar != null) {
                aVar.d(true);
                this.k = null;
            }
            PreparingVideoToast preparingVideoToast2 = new PreparingVideoToast(getContext());
            this.i = preparingVideoToast2;
            preparingVideoToast2.setOnCancelListener(new Runnable() { // from class: ir.nasim.qX1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            });
            this.b.addView(this.i);
        } else {
            this.e = false;
        }
        x();
        if (this.h == null) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f) {
            this.f = false;
            if (this.j.O()) {
                final File fileS = AbstractC21455b.S();
                this.k = new a(this.a, this.j, fileS, new Runnable() { // from class: ir.nasim.rX1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.n(fileS);
                    }
                }, new Utilities.b() { // from class: ir.nasim.sX1
                    @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                    public final void a(Object obj) {
                        this.a.o((Float) obj);
                    }
                }, new Runnable() { // from class: ir.nasim.tX1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p();
                    }
                });
            } else {
                final File fileR = AbstractC21455b.R(false, "png");
                if (fileR == null) {
                    this.i.setDone(AbstractC19363qD5.error, FH3.E("UnknownError", TD5.tgwidget_UnknownError), 3500);
                    this.d = false;
                    x();
                    return;
                }
                Utilities.g.i(new Runnable() { // from class: ir.nasim.uX1
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.a.s(fileR);
                    }
                });
            }
            x();
        }
    }

    private void x() {
        boolean z = this.m;
        boolean z2 = this.d;
        boolean z3 = false;
        if (z != (z2 && !this.e)) {
            boolean z4 = z2 && !this.e;
            this.m = z4;
            if (z4) {
                AbstractC21455b.H1(this, this.g);
            } else {
                AbstractC21455b.G1(this, AbstractC24188yB5.download);
            }
        }
        if (this.n != (this.d && this.e)) {
            clearAnimation();
            ViewPropertyAnimator viewPropertyAnimatorAnimate = animate();
            if (this.d && this.e) {
                z3 = true;
            }
            this.n = z3;
            viewPropertyAnimatorAnimate.alpha(z3 ? 0.4f : 1.0f).start();
        }
    }

    public void setEntry(l lVar) {
        this.l = null;
        this.j = lVar;
        a aVar = this.k;
        if (aVar != null) {
            aVar.d(true);
            this.k = null;
        }
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.d();
            this.i = null;
        }
        if (lVar == null) {
            this.d = false;
            x();
        }
    }

    public void v() {
        w(AbstractC19363qD5.error, FH3.E("VideoConvertFail", TD5.tgwidget_VideoConvertFail));
    }

    public void w(int i, CharSequence charSequence) {
        PreparingVideoToast preparingVideoToast = this.i;
        if (preparingVideoToast != null) {
            preparingVideoToast.d();
            this.i = null;
        }
        PreparingVideoToast preparingVideoToast2 = new PreparingVideoToast(getContext());
        this.i = preparingVideoToast2;
        preparingVideoToast2.setDone(i, charSequence, 3500);
        this.b.addView(this.i);
    }
}
