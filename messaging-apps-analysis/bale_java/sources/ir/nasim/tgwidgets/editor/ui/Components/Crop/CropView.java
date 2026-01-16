package ir.nasim.tgwidgets.editor.ui.Components.Crop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C22697vg5;
import ir.nasim.C3417Au1;
import ir.nasim.C4278El2;
import ir.nasim.FH3;
import ir.nasim.G37;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView;
import ir.nasim.tgwidgets.editor.ui.Components.Crop.a;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.TextPaintView;
import ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay;
import ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class CropView extends FrameLayout implements CropAreaView.d, a.b {
    public CropAreaView a;
    private ImageView b;
    private Matrix c;
    private PaintingOverlay d;
    private VideoEditTextureView e;
    private C3417Au1 f;
    private RectF g;
    private RectF h;
    private float i;
    private boolean j;
    private d k;
    private Matrix l;
    private Bitmap m;
    private boolean n;
    private float o;
    private boolean p;
    private ir.nasim.tgwidgets.editor.ui.Components.Crop.a q;
    float[] r;
    private boolean s;
    private boolean t;
    private int u;
    public e v;
    private f w;
    RectF x;
    RectF y;

    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ MediaController.i a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        a(MediaController.i iVar, int i, int i2) {
            this.a = iVar;
            this.b = i;
            this.c = i2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            float f;
            float f2;
            int i;
            int i2;
            CropView.this.T();
            MediaController.i iVar = this.a;
            if (iVar != null) {
                float f3 = iVar.q;
                if (f3 > 1.0E-4f) {
                    CropView.this.a.setLockedAspectRatio(f3);
                    if (CropView.this.w != null) {
                        CropView.this.w.d(true);
                    }
                }
                CropView.this.setFreeform(this.a.p);
                float aspectRatio = CropView.this.a.getAspectRatio();
                int i3 = this.a.i;
                if (i3 == 90 || i3 == 270) {
                    aspectRatio = 1.0f / aspectRatio;
                    e eVar = CropView.this.v;
                    f = eVar.b;
                    f2 = eVar.a;
                    i = this.b;
                    i2 = this.c;
                } else {
                    e eVar2 = CropView.this.v;
                    f = eVar2.a;
                    f2 = eVar2.b;
                    i = this.c;
                    i2 = this.b;
                }
                boolean z = CropView.this.n;
                if (!CropView.this.n || CropView.this.a.getLockAspectRatio() <= 0.0f) {
                    CropView cropView = CropView.this;
                    cropView.a.setBitmap(cropView.getCurrentWidth(), CropView.this.getCurrentHeight(), (((float) i3) + CropView.this.v.u()) % 180.0f != 0.0f, CropView.this.n);
                } else {
                    CropAreaView cropAreaView = CropView.this.a;
                    cropAreaView.setLockedAspectRatio(1.0f / cropAreaView.getLockAspectRatio());
                    CropAreaView cropAreaView2 = CropView.this.a;
                    cropAreaView2.setActualRect(cropAreaView2.getLockAspectRatio());
                    z = false;
                }
                CropView cropView2 = CropView.this;
                cropView2.v.J(cropView2.a, i3, z);
                CropAreaView cropAreaView3 = CropView.this.a;
                MediaController.i iVar2 = this.a;
                cropAreaView3.setActualRect((aspectRatio * iVar2.e) / iVar2.f);
                e eVar3 = CropView.this.v;
                MediaController.i iVar3 = this.a;
                eVar3.j = iVar3.j;
                eVar3.K(iVar3.d, 0.0f, 0.0f);
                e eVar4 = CropView.this.v;
                MediaController.i iVar4 = this.a;
                float f4 = iVar4.a * i;
                float f5 = eVar4.f;
                eVar4.M(f4 * f5, iVar4.b * i2 * f5);
                float fMax = Math.max(CropView.this.a.getCropWidth() / f, CropView.this.a.getCropHeight() / f2);
                e eVar5 = CropView.this.v;
                eVar5.L(this.a.c * (fMax / eVar5.f), 0.0f, 0.0f);
                CropView.this.c0();
                if (CropView.this.w != null) {
                    CropView.this.w.c(false);
                }
            }
            CropView.this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                CropView.this.x(false, false, true);
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;

        c(boolean z, boolean z2, boolean z3, boolean z4) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = z4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CropView.this.p = false;
            if (this.a) {
                return;
            }
            CropView.this.y(this.b, this.c, this.d, true);
        }
    }

    private static class d {
        float[] a = new float[8];

        d() {
        }

        void a(Matrix matrix) {
            matrix.mapPoints(this.a);
        }

        void b(RectF rectF) {
            float[] fArr = this.a;
            rectF.set(fArr[0], fArr[1], fArr[2], fArr[7]);
        }

        void c(RectF rectF) {
            float[] fArr = this.a;
            float f = rectF.left;
            fArr[0] = f;
            float f2 = rectF.top;
            fArr[1] = f2;
            float f3 = rectF.right;
            fArr[2] = f3;
            fArr[3] = f2;
            fArr[4] = f3;
            float f4 = rectF.bottom;
            fArr[5] = f4;
            fArr[6] = f;
            fArr[7] = f4;
        }
    }

    public class e {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public boolean j;
        public Matrix k;

        /* JADX INFO: Access modifiers changed from: private */
        public float A() {
            return (this.h + this.g) % 180.0f != 0.0f ? this.a : this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float B() {
            return (this.h + this.g) % 180.0f != 0.0f ? this.b : this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float C() {
            return this.i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float D() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float E() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float F() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float G() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean H() {
            return Math.abs(this.c) > 1.0E-5f || Math.abs(this.d) > 1.0E-5f || Math.abs(this.e - this.f) > 1.0E-5f || Math.abs(this.i) > 1.0E-5f || Math.abs(this.h) > 1.0E-5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            this.j = !this.j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J(CropAreaView cropAreaView, float f, boolean z) {
            this.k.reset();
            this.c = 0.0f;
            this.d = 0.0f;
            this.i = 0.0f;
            this.h = f;
            O();
            float f2 = this.f;
            this.e = f2;
            this.k.postScale(f2, f2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K(float f, float f2, float f3) {
            this.i += f;
            this.k.postRotate(f, f2, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(float f, float f2, float f3) {
            this.e *= f;
            this.k.postScale(f, f, f2, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M(float f, float f2) {
            this.c += f;
            this.d += f2;
            this.k.postTranslate(f, f2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N(int i, int i2, int i3) {
            float f = i;
            this.e *= this.a / f;
            this.a = f;
            this.b = i2;
            O();
            this.k.getValues(CropView.this.r);
            this.k.reset();
            Matrix matrix = this.k;
            float f2 = this.e;
            matrix.postScale(f2, f2);
            Matrix matrix2 = this.k;
            float[] fArr = CropView.this.r;
            matrix2.postTranslate(fArr[2], fArr[5]);
            CropView.this.c0();
        }

        private void O() {
            float f = this.h;
            float f2 = this.g;
            float f3 = (f + f2) % 180.0f != 0.0f ? this.b : this.a;
            float f4 = (f + f2) % 180.0f != 0.0f ? this.a : this.b;
            if (CropView.this.n) {
                this.f = CropView.this.a.getCropWidth() / f3;
            } else {
                this.f = Math.max(CropView.this.a.getCropWidth() / f3, CropView.this.a.getCropHeight() / f4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float u() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(Matrix matrix) {
            matrix.postConcat(this.k);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float w() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Matrix x() {
            Matrix matrix = new Matrix();
            matrix.set(this.k);
            return matrix;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float y() {
            return this.h + this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int z() {
            return (int) this.h;
        }

        private e(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 1.0f;
            this.g = i3;
            this.i = 0.0f;
            this.k = new Matrix();
        }
    }

    public interface f {
        void a();

        void b();

        void c(boolean z);

        void d(boolean z);
    }

    public CropView(Context context) {
        super(context);
        this.r = new float[9];
        this.x = new RectF();
        this.y = new RectF(0.0f, 0.0f, 1280.0f, 1280.0f);
        this.j = false;
        this.g = new RectF();
        this.h = new RectF();
        this.c = new Matrix();
        this.k = new d();
        this.l = new Matrix();
        this.p = false;
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        addView(this.b);
        ir.nasim.tgwidgets.editor.ui.Components.Crop.a aVar = new ir.nasim.tgwidgets.editor.ui.Components.Crop.a(context);
        this.q = aVar;
        aVar.g(this);
        CropAreaView cropAreaView = new CropAreaView(context);
        this.a = cropAreaView;
        cropAreaView.setListener(this);
        addView(this.a);
    }

    private void A(RectF rectF, RectF rectF2, PointF pointF, float f2) {
        float f3 = rectF2.left;
        float f4 = rectF2.top;
        float f5 = rectF2.right;
        float f6 = rectF2.bottom;
        float f7 = rectF.left;
        if (f7 > f3) {
            f5 += f7 - f3;
            f3 = f7;
        }
        float f8 = rectF.top;
        if (f8 > f4) {
            f6 += f8 - f4;
            f4 = f8;
        }
        float f9 = rectF.right;
        if (f9 < f5) {
            f3 += f9 - f5;
        }
        float f10 = rectF.bottom;
        if (f10 < f6) {
            f4 += f10 - f6;
        }
        float fCenterX = rectF2.centerX() - (f3 + (rectF2.width() / 2.0f));
        float fCenterY = rectF2.centerY() - (f4 + (rectF2.height() / 2.0f));
        double d2 = f2;
        double d3 = 1.5707963267948966d - d2;
        double d4 = fCenterX;
        float fSin = (float) (Math.sin(d3) * d4);
        float fCos = (float) (Math.cos(d3) * d4);
        double d5 = d2 + 1.5707963267948966d;
        double d6 = fCenterY;
        pointF.set(pointF.x + fSin + ((float) (Math.cos(d5) * d6)), pointF.y + fCos + ((float) (Math.sin(d5) * d6)));
    }

    public static String B(String str) {
        File file = new File(C4278El2.B(4), AbstractC8662Wx6.i() + "_temp.jpg");
        try {
            AbstractC21455b.B(new File(str), file);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(float f2, float[] fArr, float f3, float f4, ValueAnimator valueAnimator) {
        float fFloatValue = ((f2 - 1.0f) * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + 1.0f;
        float f5 = fArr[0];
        float f6 = fFloatValue / f5;
        fArr[0] = f5 * f6;
        this.v.L(f6, f3, f4);
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(float f2, float[] fArr, float f3, float f4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f5 = fArr[1];
        float f6 = (f2 * fFloatValue) - f5;
        fArr[1] = f5 + f6;
        float f7 = fArr[2];
        float f8 = (f3 * fFloatValue) - f7;
        fArr[2] = f7 + f8;
        e eVar = this.v;
        float f9 = fArr[0];
        eVar.M(f6 * f9, f8 * f9);
        float f10 = fArr[0];
        float f11 = (((f4 - 1.0f) * fFloatValue) + 1.0f) / f10;
        fArr[0] = f10 * f11;
        this.v.L(f11, 0.0f, 0.0f);
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(RectF rectF, RectF rectF2, float f2, float f3, float f4, float f5, float f6, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        AbstractC21455b.W0(rectF, this.h, fFloatValue, rectF2);
        this.a.setActualRect(rectF2);
        e eVar = this.v;
        float f7 = 1.0f - fFloatValue;
        float f8 = eVar.c - (f2 * f7);
        float f9 = eVar.d - (f3 * f7);
        float f10 = eVar.i - (f4 * f7);
        float fT0 = AbstractC21455b.T0(f5, f6, fFloatValue);
        e eVar2 = this.v;
        float f11 = fT0 / eVar2.e;
        eVar2.M(-f8, -f9);
        this.v.L(f11, 0.0f, 0.0f);
        this.v.K(-f10, 0.0f, 0.0f);
        x(true, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(Integer[][] numArr, DialogInterface dialogInterface, int i) {
        this.s = false;
        if (i == 0) {
            setLockedAspectRatio((this.v.u() % 180.0f != 0.0f ? this.v.w() : this.v.E()) / (this.v.u() % 180.0f != 0.0f ? this.v.E() : this.v.w()));
            return;
        }
        if (i == 1) {
            setLockedAspectRatio(1.0f);
            return;
        }
        Integer[] numArr2 = numArr[i - 2];
        if (this.a.getAspectRatio() > 1.0f) {
            setLockedAspectRatio(numArr2[0].intValue() / numArr2[1].intValue());
        } else {
            setLockedAspectRatio(numArr2[1].intValue() / numArr2[0].intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(DialogInterface dialogInterface) {
        this.s = false;
    }

    private void V() {
        this.i = 0.0f;
    }

    private void a0() {
        int i;
        float f2;
        if (this.f == null || this.v == null) {
            return;
        }
        this.a.g(this.x);
        int iCeil = (int) Math.ceil(X(this.x, this.y));
        int iCeil2 = (int) Math.ceil(r2 / this.a.getAspectRatio());
        float cropWidth = iCeil / this.a.getCropWidth();
        this.v.k.getValues(this.r);
        e eVar = this.v;
        float f3 = eVar.f * cropWidth;
        int iZ = eVar.z();
        while (iZ < 0) {
            iZ += 360;
        }
        if (iZ == 90 || iZ == 270) {
            e eVar2 = this.v;
            i = (int) eVar2.b;
            f2 = eVar2.a;
        } else {
            e eVar3 = this.v;
            i = (int) eVar3.a;
            f2 = eVar3.b;
        }
        int i2 = (int) f2;
        double d2 = iCeil;
        float f4 = i;
        float fCeil = (float) (d2 / Math.ceil(f4 * f3));
        float f5 = i2;
        float fCeil2 = (float) (iCeil2 / Math.ceil(f3 * f5));
        if (fCeil > 1.0f || fCeil2 > 1.0f) {
            float fMax = Math.max(fCeil, fCeil2);
            fCeil /= fMax;
            fCeil2 /= fMax;
        }
        float f6 = fCeil2;
        float f7 = fCeil;
        RectF rectFH = this.a.h(f4 / f5);
        float fWidth = this.n ? rectFH.width() / f4 : Math.max(rectFH.width() / f4, rectFH.height() / f5);
        e eVar4 = this.v;
        float f8 = eVar4.e;
        float f9 = f8 / fWidth;
        float f10 = f8 / eVar4.f;
        float[] fArr = this.r;
        float f11 = (fArr[2] / f4) / f8;
        float f12 = (fArr[5] / f5) / f8;
        float f13 = eVar4.i;
        RectF targetRectToFill = this.a.getTargetRectToFill();
        float cropCenterX = this.a.getCropCenterX() - targetRectToFill.centerX();
        float cropCenterY = this.a.getCropCenterY() - targetRectToFill.centerY();
        C3417Au1 c3417Au1 = this.f;
        e eVar5 = this.v;
        boolean z = eVar5.j || eVar5.H() || this.v.u() >= 1.0E-5f;
        int iZ2 = this.v.z();
        e eVar6 = this.v;
        c3417Au1.p(z, f11, f12, f13, iZ2, f9, f10, eVar6.f / fWidth, f7, f6, cropCenterX, cropCenterY, eVar6.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentHeight() {
        VideoEditTextureView videoEditTextureView = this.e;
        if (videoEditTextureView != null) {
            return videoEditTextureView.getVideoHeight();
        }
        int i = this.u;
        return (i == 90 || i == 270) ? this.m.getWidth() : this.m.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentWidth() {
        VideoEditTextureView videoEditTextureView = this.e;
        if (videoEditTextureView != null) {
            return videoEditTextureView.getVideoWidth();
        }
        int i = this.u;
        return (i == 90 || i == 270) ? this.m.getHeight() : this.m.getWidth();
    }

    private void setLockedAspectRatio(float f2) {
        this.a.setLockedAspectRatio(f2);
        RectF rectF = new RectF();
        this.a.c(rectF, f2);
        v(rectF, true);
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(false);
            this.w.d(true);
        }
    }

    public static void u(Context context, String str, Bitmap bitmap, Canvas canvas, Bitmap bitmap2, Bitmap.CompressFormat compressFormat, Matrix matrix, int i, int i2, float f2, float f3, float f4, float f5, boolean z, ArrayList arrayList, boolean z2) {
        float f6 = f4;
        int i3 = 4;
        if (z2) {
            try {
                bitmap2.eraseColor(0);
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
                return;
            }
        }
        Bitmap bitmapDecodeFile = bitmap == null ? BitmapFactory.decodeFile(str) : bitmap;
        float fMax = Math.max(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight()) / Math.max(i, i2);
        Matrix matrix2 = new Matrix();
        matrix2.postTranslate((-bitmapDecodeFile.getWidth()) / 2, (-bitmapDecodeFile.getHeight()) / 2);
        if (z) {
            matrix2.postScale(-1.0f, 1.0f);
        }
        float f7 = 1.0f / fMax;
        matrix2.postScale(f7, f7);
        matrix2.postRotate(f6);
        matrix2.postConcat(matrix);
        matrix2.postScale(f5, f5);
        matrix2.postTranslate(bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
        canvas.drawBitmap(bitmapDecodeFile, matrix2, new Paint(2));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        bitmap2.compress(compressFormat, 87, fileOutputStream);
        fileOutputStream.close();
        if (arrayList != null && !arrayList.isEmpty()) {
            float width = f7 * f5 * f2 * (bitmapDecodeFile.getWidth() / bitmap2.getWidth());
            int size = arrayList.size();
            TextPaintView textPaintView = null;
            int i4 = 0;
            while (i4 < size) {
                H.b bVar = (H.b) arrayList.get(i4);
                float width2 = (bVar.c * bitmapDecodeFile.getWidth()) + ((bVar.n * bVar.q) / 2.0f);
                float height = (bVar.d * bitmapDecodeFile.getHeight()) + ((bVar.o * bVar.q) / 2.0f);
                float width3 = bVar.t * bitmapDecodeFile.getWidth();
                float height2 = bVar.u * bitmapDecodeFile.getHeight();
                float[] fArr = new float[i3];
                fArr[0] = width2;
                fArr[1] = height;
                fArr[2] = width3;
                fArr[3] = height2;
                matrix2.mapPoints(fArr);
                byte b2 = bVar.a;
                if (b2 == 0) {
                    int width4 = bitmap2.getWidth() / 2;
                    bVar.o = width4;
                    bVar.n = width4;
                } else {
                    if (b2 == 1) {
                        bVar.k = bitmap2.getWidth() / 9;
                        if (textPaintView == null) {
                            textPaintView = new TextPaintView(context, new C22697vg5(0.0f, 0.0f), bVar.k, "", new G37(-16777216, 0.85f, 0.1f), 0);
                            textPaintView.setMaxWidth(bitmap2.getWidth() - 20);
                        }
                        byte b3 = bVar.b;
                        textPaintView.setType((b3 & 1) != 0 ? 0 : (b3 & 4) != 0 ? 2 : 1);
                        textPaintView.setText(bVar.h);
                        textPaintView.measure(View.MeasureSpec.makeMeasureSpec(bitmap2.getWidth(), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(bitmap2.getHeight(), RecyclerView.UNDEFINED_DURATION));
                        bVar.n = textPaintView.getMeasuredWidth();
                        bVar.o = textPaintView.getMeasuredHeight();
                    }
                    float f8 = bVar.q * width;
                    bVar.q = f8;
                    bVar.c = (fArr[0] - ((bVar.n * f8) / 2.0f)) / bitmap2.getWidth();
                    bVar.d = (fArr[1] - ((bVar.o * bVar.q) / 2.0f)) / bitmap2.getHeight();
                    bVar.t = fArr[2] / bitmap2.getWidth();
                    bVar.u = fArr[3] / bitmap2.getHeight();
                    bVar.f = (bVar.n * bVar.q) / bitmap2.getWidth();
                    bVar.g = (bVar.o * bVar.q) / bitmap2.getHeight();
                    bVar.r = bVar.n / bitmap2.getWidth();
                    bVar.s = bVar.o / bitmap2.getHeight();
                    bVar.e = (float) (bVar.e - ((f3 + f6) * 0.017453292519943295d));
                    i4++;
                    f6 = f4;
                    i3 = 4;
                }
                float f82 = bVar.q * width;
                bVar.q = f82;
                bVar.c = (fArr[0] - ((bVar.n * f82) / 2.0f)) / bitmap2.getWidth();
                bVar.d = (fArr[1] - ((bVar.o * bVar.q) / 2.0f)) / bitmap2.getHeight();
                bVar.t = fArr[2] / bitmap2.getWidth();
                bVar.u = fArr[3] / bitmap2.getHeight();
                bVar.f = (bVar.n * bVar.q) / bitmap2.getWidth();
                bVar.g = (bVar.o * bVar.q) / bitmap2.getHeight();
                bVar.r = bVar.n / bitmap2.getWidth();
                bVar.s = bVar.o / bitmap2.getHeight();
                bVar.e = (float) (bVar.e - ((f3 + f6) * 0.017453292519943295d));
                i4++;
                f6 = f4;
                i3 = 4;
            }
        }
        bitmapDecodeFile.recycle();
    }

    private void v(RectF rectF, boolean z) {
        final float fD;
        boolean z2;
        final float[] fArr = {1.0f};
        float fMax = Math.max(rectF.width() / this.a.getCropWidth(), rectF.height() / this.a.getCropHeight());
        if (this.v.D() * fMax > 30.0f) {
            fD = 30.0f / this.v.D();
            z2 = true;
        } else {
            fD = fMax;
            z2 = false;
        }
        int i = this.j ? 0 : AbstractC21455b.d;
        final float fB = this.v.B() * ((rectF.centerX() - (this.b.getWidth() / 2)) / this.a.getCropWidth());
        final float fCenterY = ((rectF.centerY() - (((this.b.getHeight() - this.o) + i) / 2.0f)) / this.a.getCropHeight()) * this.v.A();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Bu1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.F(fD, fArr, fB, fCenterY, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new b(z2));
        this.a.f(rectF, valueAnimatorOfFloat, true);
        this.h.set(rectF);
    }

    private Activity w() {
        Context context = getContext();
        while (!(context instanceof Activity)) {
            context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            if (context == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2, boolean z3) {
        y(z, z2, z3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z, boolean z2, boolean z3, boolean z4) {
        float fZ;
        if (this.v == null) {
            return;
        }
        float cropWidth = this.a.getCropWidth();
        float cropHeight = this.a.getCropHeight();
        float fB = this.v.B();
        float fA = this.v.A();
        float fC = this.v.C();
        float radians = (float) Math.toRadians(fC);
        RectF rectFT = t(cropWidth, cropHeight, fC);
        RectF rectF = new RectF(0.0f, 0.0f, fB, fA);
        float fD = this.v.D();
        this.k.c(rectF);
        Matrix matrixX = this.v.x();
        matrixX.preTranslate(((cropWidth - fB) / 2.0f) / fD, ((cropHeight - fA) / 2.0f) / fD);
        this.l.reset();
        this.l.setTranslate(rectF.centerX(), rectF.centerY());
        Matrix matrix = this.l;
        matrix.setConcat(matrix, matrixX);
        this.l.preTranslate(-rectF.centerX(), -rectF.centerY());
        this.k.a(this.l);
        this.l.reset();
        this.l.preRotate(-fC, fB / 2.0f, fA / 2.0f);
        this.k.a(this.l);
        this.k.b(rectF);
        PointF pointF = new PointF(this.v.F(), this.v.G());
        if (!rectF.contains(rectFT)) {
            fZ = (!z || (rectFT.width() <= rectF.width() && rectFT.height() <= rectF.height())) ? fD : z(rectF, fD, rectFT.width() / X(rectFT, rectF));
            A(rectF, rectFT, pointF, radians);
        } else if (!z2 || this.i <= 0.0f) {
            fZ = fD;
        } else {
            float fWidth = rectFT.width() / X(rectFT, rectF);
            if (this.v.D() * fWidth < this.i) {
                fWidth = 1.0f;
            }
            fZ = z(rectF, fD, fWidth);
            A(rectF, rectFT, pointF, radians);
        }
        final float F = pointF.x - this.v.F();
        final float fG = pointF.y - this.v.G();
        if (!z3) {
            this.v.M(F, fG);
            this.v.L(fZ / fD, 0.0f, 0.0f);
            c0();
            return;
        }
        final float f2 = fZ / fD;
        if (Math.abs(f2 - 1.0f) >= 1.0E-5f || Math.abs(F) >= 1.0E-5f || Math.abs(fG) >= 1.0E-5f) {
            this.p = true;
            final float[] fArr = {1.0f, 0.0f, 0.0f};
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Cu1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.G(F, fArr, fG, f2, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new c(z4, z, z2, z3));
            valueAnimatorOfFloat.setInterpolator(this.a.getInterpolator());
            valueAnimatorOfFloat.setDuration(z4 ? 100L : 200L);
            valueAnimatorOfFloat.start();
        }
    }

    private float z(RectF rectF, float f2, float f3) {
        float fWidth = rectF.width() * f3;
        float fHeight = rectF.height() * f3;
        float fWidth2 = (rectF.width() - fWidth) / 2.0f;
        float fHeight2 = (rectF.height() - fHeight) / 2.0f;
        float f4 = rectF.left;
        float f5 = rectF.top;
        rectF.set(f4 + fWidth2, f5 + fHeight2, f4 + fWidth2 + fWidth, f5 + fHeight2 + fHeight);
        return f2 * f3;
    }

    public void C() {
        this.b.setVisibility(4);
        this.a.setDimVisibility(false);
        this.a.setFrameVisibility(false, false);
        this.a.invalidate();
    }

    public boolean D() {
        e eVar = this.v;
        if (eVar == null) {
            return false;
        }
        return eVar.j;
    }

    public boolean E() {
        return (this.q.e() || this.q.d() || this.a.i()) ? false : true;
    }

    public void K(MediaController.l lVar) {
        MediaController.i iVar;
        int i;
        int i2;
        float f2;
        if (this.v == null) {
            return;
        }
        this.a.g(this.x);
        int iCeil = (int) Math.ceil(X(this.x, this.y));
        int iCeil2 = (int) Math.ceil(r3 / this.a.getAspectRatio());
        float cropWidth = iCeil / this.a.getCropWidth();
        if (lVar.e != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            String strB = B(lVar.e);
            if (lVar.f != null) {
                new File(lVar.f).delete();
                lVar.f = null;
            }
            lVar.f = strB;
            ArrayList arrayList = lVar.j;
            if (arrayList == null || arrayList.isEmpty()) {
                lVar.k = null;
            } else {
                lVar.k = new ArrayList(lVar.j.size());
                int size = lVar.j.size();
                for (int i3 = 0; i3 < size; i3++) {
                    lVar.k.add(((H.b) lVar.j.get(i3)).a());
                }
            }
            Context context = getContext();
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            Matrix matrix = this.v.k;
            int currentWidth = getCurrentWidth();
            int currentHeight = getCurrentHeight();
            e eVar = this.v;
            u(context, strB, null, canvas, bitmapCreateBitmap, compressFormat, matrix, currentWidth, currentHeight, eVar.e, eVar.i, eVar.z(), cropWidth, false, lVar.k, false);
        }
        if (lVar.s == null) {
            lVar.s = new MediaController.i();
        }
        this.v.k.getValues(this.r);
        e eVar2 = this.v;
        float f3 = eVar2.f * cropWidth;
        lVar.s.i = eVar2.z();
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("set transformRotation = " + lVar.s.i);
        }
        while (true) {
            iVar = lVar.s;
            i = iVar.i;
            if (i >= 0) {
                break;
            } else {
                iVar.i = i + 360;
            }
        }
        if (i == 90 || i == 270) {
            e eVar3 = this.v;
            i2 = (int) eVar3.b;
            f2 = eVar3.a;
        } else {
            e eVar4 = this.v;
            i2 = (int) eVar4.a;
            f2 = eVar4.b;
        }
        int i4 = (int) f2;
        float f4 = i2;
        iVar.e = (float) (iCeil / Math.ceil(f4 * f3));
        float f5 = i4;
        lVar.s.f = (float) (iCeil2 / Math.ceil(f3 * f5));
        MediaController.i iVar2 = lVar.s;
        float f6 = iVar2.e;
        if (f6 > 1.0f || iVar2.f > 1.0f) {
            float fMax = Math.max(f6, iVar2.f);
            MediaController.i iVar3 = lVar.s;
            iVar3.e /= fMax;
            iVar3.f /= fMax;
        }
        lVar.s.c = this.v.e * Math.min(f4 / this.a.getCropWidth(), f5 / this.a.getCropHeight());
        MediaController.i iVar4 = lVar.s;
        float[] fArr = this.r;
        float f7 = fArr[2] / f4;
        e eVar5 = this.v;
        float f8 = eVar5.e;
        iVar4.a = f7 / f8;
        iVar4.b = (fArr[5] / f5) / f8;
        iVar4.d = eVar5.i;
        iVar4.k = f8;
        iVar4.j = eVar5.j;
        iVar4.l = cropWidth;
        iVar4.m = eVar5.k;
        iVar4.n = iCeil;
        iVar4.o = iCeil2;
        iVar4.p = this.n;
        iVar4.q = this.a.getLockAspectRatio();
        lVar.s.s = true;
    }

    public void L(boolean z) {
        float currentWidth;
        int currentHeight;
        e eVar = this.v;
        if (eVar == null) {
            return;
        }
        final float f2 = eVar.f;
        this.a.j();
        if (this.v.y() % 180.0f != 0.0f) {
            currentWidth = getCurrentHeight();
            currentHeight = getCurrentWidth();
        } else {
            currentWidth = getCurrentWidth();
            currentHeight = getCurrentHeight();
        }
        float f3 = currentWidth / currentHeight;
        if (!this.n) {
            f3 = 1.0f;
        }
        this.a.c(this.h, f3);
        this.a.setLockedAspectRatio(this.n ? 0.0f : 1.0f);
        V();
        if (!z) {
            this.a.setActualRect(this.h);
            e eVar2 = this.v;
            eVar2.M(-eVar2.c, -eVar2.d);
            e eVar3 = this.v;
            eVar3.L(eVar3.f / eVar3.e, 0.0f, 0.0f);
            e eVar4 = this.v;
            eVar4.K(-eVar4.i, 0.0f, 0.0f);
            c0();
            V();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final RectF rectF = new RectF();
        final RectF rectF2 = new RectF();
        this.a.g(rectF);
        e eVar5 = this.v;
        final float f4 = eVar5.c;
        final float f5 = eVar5.d;
        final float f6 = eVar5.e;
        final float f7 = eVar5.i;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Fu1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.H(rectF, rectF2, f4, f5, f7, f6, f2, valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(this.a.getInterpolator());
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.start();
    }

    public boolean M() {
        e eVar = this.v;
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        eVar.I();
        c0();
        if (this.w != null) {
            float fY = (this.v.y() - this.v.u()) % 360.0f;
            f fVar = this.w;
            if (!this.v.H() && fY == 0.0f && this.a.getLockAspectRatio() == 0.0f && !this.v.j) {
                z = true;
            }
            fVar.c(z);
        }
        return this.v.j;
    }

    public void N() {
        this.e = null;
        this.d = null;
        this.t = false;
    }

    public void O() {
        this.a.setGridType(CropAreaView.f.MINOR, false);
        if (this.i < 1.0E-5f) {
            this.i = this.v.D();
        }
    }

    public void P() {
        this.a.setGridType(CropAreaView.f.NONE, true);
    }

    public void Q() {
        if (this.p) {
            return;
        }
        this.a.setGridType(CropAreaView.f.MAJOR, true);
        V();
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(false);
        }
    }

    public void R() {
        this.a.setGridType(CropAreaView.f.NONE, true);
        x(true, false, true);
    }

    public void S() {
        this.t = true;
    }

    public void T() {
        U(false);
    }

    public void U(boolean z) {
        this.a.j();
        this.a.setBitmap(getCurrentWidth(), getCurrentHeight(), this.v.u() % 180.0f != 0.0f, this.n);
        this.a.setLockedAspectRatio(this.n ? 0.0f : 1.0f);
        this.v.J(this.a, 0.0f, this.n);
        this.v.j = false;
        this.a.g(this.h);
        d0(z);
        V();
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(true);
            this.w.d(false);
        }
    }

    public boolean W(float f2) {
        if (this.v == null) {
            return false;
        }
        this.a.j();
        V();
        float fY = ((this.v.y() - this.v.u()) + f2) % 360.0f;
        boolean z = this.n;
        if (!z || this.a.getLockAspectRatio() <= 0.0f) {
            this.a.setBitmap(getCurrentWidth(), getCurrentHeight(), (this.v.u() + fY) % 180.0f != 0.0f, this.n);
        } else {
            CropAreaView cropAreaView = this.a;
            cropAreaView.setLockedAspectRatio(1.0f / cropAreaView.getLockAspectRatio());
            CropAreaView cropAreaView2 = this.a;
            cropAreaView2.setActualRect(cropAreaView2.getLockAspectRatio());
            z = false;
        }
        this.v.J(this.a, fY, z);
        c0();
        x(true, false, false);
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(fY == 0.0f && this.a.getLockAspectRatio() == 0.0f && !this.v.j);
        }
        return this.v.z() != 0;
    }

    public float X(RectF rectF, RectF rectF2) {
        float fWidth = rectF2.width();
        return ((float) Math.floor((double) ((rectF.height() * fWidth) / rectF.width()))) > rectF2.height() ? (float) Math.floor((rectF2.height() * rectF.width()) / rectF.height()) : fWidth;
    }

    public void Y() {
        a0();
        this.a.setDimVisibility(true);
        this.a.setFrameVisibility(true, true);
        this.a.invalidate();
    }

    public void Z() {
        if (this.v == null || this.s) {
            return;
        }
        String[] strArr = new String[8];
        int i = 2;
        final Integer[][] numArr = {new Integer[]{3, 2}, new Integer[]{5, 3}, new Integer[]{4, 3}, new Integer[]{5, 4}, new Integer[]{7, 5}, new Integer[]{16, 9}};
        strArr[0] = FH3.E("CropOriginal", TD5.tgwidget_CropOriginal);
        strArr[1] = FH3.E("CropSquare", TD5.tgwidget_CropSquare);
        for (int i2 = 0; i2 < 6; i2++) {
            Integer[] numArr2 = numArr[i2];
            if (this.a.getAspectRatio() > 1.0f) {
                strArr[i] = String.format("%d:%d", numArr2[0], numArr2[1]);
            } else {
                strArr[i] = String.format("%d:%d", numArr2[1], numArr2[0]);
            }
            i++;
        }
        Activity activityW = w();
        if (activityW == null) {
            return;
        }
        AlertDialog alertDialogA = new AlertDialog.i(activityW).d(strArr, new DialogInterface.OnClickListener() { // from class: ir.nasim.Du1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.a.I(numArr, dialogInterface, i3);
            }
        }).a();
        alertDialogA.setCanceledOnTouchOutside(true);
        alertDialogA.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.nasim.Eu1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.a.J(dialogInterface);
            }
        });
        alertDialogA.show();
        this.s = true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.a.b
    public void a(float f2, float f3) {
        if (this.p) {
            return;
        }
        this.v.M(f2, f3);
        c0();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.a.b
    public void b() {
        f fVar = this.w;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void b0() {
        e eVar;
        float cropWidth = this.a.getCropWidth();
        if (cropWidth == 0.0f || (eVar = this.v) == null) {
            return;
        }
        this.a.c(this.h, eVar.E() / this.v.w());
        CropAreaView cropAreaView = this.a;
        cropAreaView.setActualRect(cropAreaView.getAspectRatio());
        this.a.g(this.g);
        this.v.L(this.a.getCropWidth() / cropWidth, 0.0f, 0.0f);
        c0();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.a.b
    public void c(float f2, float f3, float f4, float f5) {
    }

    public void c0() {
        d0(false);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.a.b
    public void d(float f2, float f3, float f4) {
        if (this.p) {
            return;
        }
        if (this.v.D() * f2 > 30.0f) {
            f2 = 30.0f / this.v.D();
        }
        this.v.L(f2, ((f3 - (this.b.getWidth() / 2)) / this.a.getCropWidth()) * this.v.B(), ((f4 - (((this.b.getHeight() - this.o) - (!this.j ? AbstractC21455b.d : 0)) / 2.0f)) / this.a.getCropHeight()) * this.v.A());
        c0();
    }

    public void d0(boolean z) {
        if (this.v == null) {
            return;
        }
        this.c.reset();
        if (this.v.u() == 90.0f || this.v.u() == 270.0f) {
            this.c.postTranslate((-this.v.w()) / 2.0f, (-this.v.E()) / 2.0f);
        } else {
            this.c.postTranslate((-this.v.E()) / 2.0f, (-this.v.w()) / 2.0f);
        }
        this.c.postRotate(this.v.z());
        this.v.v(this.c);
        this.c.postTranslate(this.a.getCropCenterX(), this.a.getCropCenterY());
        if (!this.n || this.t || z) {
            a0();
            this.w.a();
        }
        invalidate();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView.d
    public void e() {
        this.a.g(this.g);
        V();
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(false);
        }
    }

    public void e0() {
        this.a.setFrameVisibility(true, false);
        this.a.setDimVisibility(true);
        this.a.invalidate();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView.d
    public void f() {
        this.a.setGridType(CropAreaView.f.NONE, true);
        v(this.a.getTargetRectToFill(), false);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Crop.CropAreaView.d
    public void g() {
        this.a.setGridType(CropAreaView.f.MAJOR, false);
        float fCenterX = this.g.centerX() - this.a.getCropCenterX();
        float fCenterY = this.g.centerY() - this.a.getCropCenterY();
        e eVar = this.v;
        if (eVar != null) {
            eVar.M(fCenterX, fCenterY);
        }
        c0();
        this.a.g(this.g);
        x(true, false, false);
    }

    public RectF getActualRect() {
        this.a.g(this.x);
        return this.x;
    }

    public float getCropHeight() {
        return this.a.getCropHeight();
    }

    public float getCropLeft() {
        return this.a.getCropLeft();
    }

    public float getCropTop() {
        return this.a.getCropTop();
    }

    public float getCropWidth() {
        return this.a.getCropWidth();
    }

    public float getStateFullOrientation() {
        e eVar = this.v;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.h + eVar.g;
    }

    public boolean getStateMirror() {
        e eVar = this.v;
        return eVar != null && eVar.j;
    }

    public float getStateOrientation() {
        e eVar = this.v;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.h;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p || this.a.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            Q();
        } else if (action == 1 || action == 3) {
            R();
        }
        try {
            return this.q.f(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setAspectRatio(float f2) {
        this.a.setActualRect(f2);
    }

    public void setBitmap(Bitmap bitmap, int i, boolean z, boolean z2, PaintingOverlay paintingOverlay, C3417Au1 c3417Au1, VideoEditTextureView videoEditTextureView, MediaController.i iVar) {
        this.n = z;
        this.d = paintingOverlay;
        this.e = videoEditTextureView;
        this.f = c3417Au1;
        this.u = i;
        this.m = bitmap;
        this.a.setIsVideo(videoEditTextureView != null);
        if (bitmap == null && videoEditTextureView == null) {
            this.v = null;
            this.b.setImageDrawable(null);
            return;
        }
        int currentWidth = getCurrentWidth();
        int currentHeight = getCurrentHeight();
        e eVar = this.v;
        if (eVar == null || !z2) {
            this.v = new e(currentWidth, currentHeight, 0);
            this.a.getViewTreeObserver().addOnPreDrawListener(new a(iVar, currentHeight, currentWidth));
        } else {
            eVar.N(currentWidth, currentHeight, i);
        }
        this.b.setImageBitmap(videoEditTextureView == null ? this.m : null);
    }

    public void setBottomPadding(float f2) {
        this.o = f2;
        this.a.setBottomPadding(f2);
    }

    public void setFreeform(boolean z) {
        this.a.setFreeform(z);
        this.n = z;
    }

    public void setListener(f fVar) {
        this.w = fVar;
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.v.K(f2 - this.v.C(), 0.0f, 0.0f);
        x(true, true, false);
    }

    public void setSubtitle(String str) {
        this.a.setSubtitle(str);
    }

    public RectF t(float f2, float f3, float f4) {
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        Matrix matrix = new Matrix();
        matrix.postRotate(f4, f2 / 2.0f, f3 / 2.0f);
        matrix.mapRect(rectF);
        return rectF;
    }
}
