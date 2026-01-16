package ir.appp.rghapp.components.sshCrop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SSHCropView extends FrameLayout implements SSHCropGestureDetector.SSHCropGestureListener {
    private boolean animating;
    private final SSHCropAreaView areaView;
    private final View backView;
    private Bitmap bitmap;
    private float bottomPadding;
    private final SSHCropGestureDetector detector;
    private boolean freeform;
    private final ImageView imageView;
    private final RectF initialAreaRect;
    private CropViewListener listener;
    private final Matrix presentationMatrix;
    private float rotationStartScale;
    private SSHCropState state;
    private final Matrix tempMatrix;
    private final CropRectangle tempRect;

    public interface CropViewListener {
        void onAspectLock(boolean z);

        void onChange(boolean z);
    }

    @Override // ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector.SSHCropGestureListener
    public void onFling(float f, float f2, float f3, float f4) {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void onRotationEnded() {
    }

    public SSHCropView(Context context) {
        super(context);
        new RectF();
        this.initialAreaRect = new RectF();
        this.presentationMatrix = new Matrix();
        this.tempRect = new CropRectangle(this);
        this.tempMatrix = new Matrix();
        this.animating = false;
        View view = new View(context);
        this.backView = view;
        view.setBackgroundColor(-16777216);
        view.setVisibility(4);
        addView(view);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setDrawingCacheEnabled(true);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        addView(imageView);
        SSHCropGestureDetector sSHCropGestureDetector = new SSHCropGestureDetector(context);
        this.detector = sSHCropGestureDetector;
        sSHCropGestureDetector.setOnGestureListener(this);
        SSHCropAreaView sSHCropAreaView = new SSHCropAreaView(context);
        this.areaView = sSHCropAreaView;
        addView(sSHCropAreaView);
    }

    public SSHCropState getCropState() {
        return this.state;
    }

    public void setListener(CropViewListener cropViewListener) {
        this.listener = cropViewListener;
    }

    public void setBottomPadding(float f) {
        this.bottomPadding = f;
        this.areaView.setBottomPadding(f);
    }

    public void setBitmap(Bitmap bitmap, SSHCropState sSHCropState, boolean z) {
        this.bitmap = bitmap;
        this.freeform = z;
        this.state = new SSHCropState(sSHCropState);
        this.backView.setVisibility(4);
        this.imageView.setVisibility(4);
        if (z) {
            this.areaView.setDimVisibility(false);
        }
        this.imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SSHCropView.this.reset(false);
                SSHCropView.this.imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });
        this.imageView.setImageBitmap(this.bitmap);
    }

    public void willShow() {
        this.areaView.setFrameVisibility(true);
        this.areaView.setDimVisibility(true);
        this.areaView.invalidate();
    }

    public void show() {
        this.backView.setVisibility(0);
        this.imageView.setVisibility(0);
        this.areaView.setDimVisibility(true);
        this.areaView.setFrameVisibility(true);
        this.areaView.invalidate();
    }

    public void hide() {
        this.backView.setVisibility(4);
        this.imageView.setVisibility(4);
        this.areaView.setDimVisibility(false);
        this.areaView.setFrameVisibility(false);
        this.areaView.invalidate();
    }

    public void reset(boolean z) {
        this.areaView.resetAnimator();
        this.areaView.setBitmap(this.bitmap, this.state.getBaseRotation() % 180.0f != 0.0f, this.freeform);
        this.areaView.setLockedAspectRatio(this.freeform ? 0.0f : 1.0f);
        SSHCropState sSHCropState = this.state;
        if (sSHCropState.minimumScale == 0.0f || z) {
            sSHCropState.reset(this.areaView, sSHCropState.scale, 0.0f, sSHCropState.orientation, this.freeform);
        }
        resetRotationStartScale();
        this.areaView.getCropRect(this.initialAreaRect);
        updateMatrix();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(true);
            this.listener.onAspectLock(false);
        }
    }

    public void updateMatrix() {
        this.presentationMatrix.reset();
        this.presentationMatrix.postTranslate((-this.state.getWidth()) / 2.0f, (-this.state.getHeight()) / 2.0f);
        this.presentationMatrix.postRotate(this.state.getOrientation());
        this.state.getConcatMatrix(this.presentationMatrix);
        this.presentationMatrix.postTranslate(this.areaView.getCropCenterX(), this.areaView.getCropCenterY());
        this.imageView.setImageMatrix(this.presentationMatrix);
    }

    private float fitScale(RectF rectF, float f, float f2) {
        float fWidth = rectF.width() * f2;
        float fHeight = rectF.height() * f2;
        float fWidth2 = (rectF.width() - fWidth) / 2.0f;
        float fHeight2 = (rectF.height() - fHeight) / 2.0f;
        float f3 = rectF.left;
        float f4 = rectF.top;
        rectF.set(f3 + fWidth2, f4 + fHeight2, f3 + fWidth2 + fWidth, f4 + fHeight2 + fHeight);
        return f * f2;
    }

    private void fitTranslation(RectF rectF, RectF rectF2, PointF pointF, float f) {
        float f2 = rectF2.left;
        float f3 = rectF2.top;
        float f4 = rectF2.right;
        float f5 = rectF2.bottom;
        float f6 = rectF.left;
        if (f6 > f2) {
            f4 += f6 - f2;
            f2 = f6;
        }
        float f7 = rectF.top;
        if (f7 > f3) {
            f5 += f7 - f3;
            f3 = f7;
        }
        float f8 = rectF.right;
        if (f8 < f4) {
            f2 += f8 - f4;
        }
        float f9 = rectF.bottom;
        if (f9 < f5) {
            f3 += f9 - f5;
        }
        float fCenterX = rectF2.centerX() - (f2 + (rectF2.width() / 2.0f));
        float fCenterY = rectF2.centerY() - (f3 + (rectF2.height() / 2.0f));
        double d = f;
        Double.isNaN(d);
        double d2 = 1.5707963267948966d - d;
        double dSin = Math.sin(d2);
        double d3 = fCenterX;
        Double.isNaN(d3);
        float f10 = (float) (dSin * d3);
        double dCos = Math.cos(d2);
        Double.isNaN(d3);
        float f11 = (float) (dCos * d3);
        Double.isNaN(d);
        double d4 = d + 1.5707963267948966d;
        double dCos2 = Math.cos(d4);
        double d5 = fCenterY;
        Double.isNaN(d5);
        double dSin2 = Math.sin(d4);
        Double.isNaN(d5);
        pointF.set(pointF.x + f10 + ((float) (dCos2 * d5)), pointF.y + f11 + ((float) (dSin2 * d5)));
    }

    public RectF calculateBoundingBox(float f, float f2, float f3) {
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        Matrix matrix = new Matrix();
        matrix.postRotate(f3, f / 2.0f, f2 / 2.0f);
        matrix.mapRect(rectF);
        return rectF;
    }

    public float scaleWidthToMaxSize(RectF rectF, RectF rectF2) {
        float fWidth = rectF2.width();
        return ((float) Math.floor((double) ((rectF.height() * fWidth) / rectF.width()))) > rectF2.height() ? (float) Math.floor((rectF2.height() * rectF.width()) / rectF.height()) : fWidth;
    }

    private void fitContentInBounds(boolean z, boolean z2, boolean z3) {
        fitContentInBounds(z, z2, z3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitContentInBounds(final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        float fFitScale;
        float cropWidth = this.areaView.getCropWidth();
        float cropHeight = this.areaView.getCropHeight();
        float orientedWidth = this.state.getOrientedWidth();
        float orientedHeight = this.state.getOrientedHeight();
        float rotation = this.state.getRotation();
        float radians = (float) Math.toRadians(rotation);
        RectF rectFCalculateBoundingBox = calculateBoundingBox(cropWidth, cropHeight, rotation);
        RectF rectF = new RectF(0.0f, 0.0f, orientedWidth, orientedHeight);
        float scale = this.state.getScale();
        this.tempRect.setRect(rectF);
        Matrix matrix = this.state.getMatrix();
        matrix.preTranslate(((cropWidth - orientedWidth) / 2.0f) / scale, ((cropHeight - orientedHeight) / 2.0f) / scale);
        this.tempMatrix.reset();
        this.tempMatrix.setTranslate(rectF.centerX(), rectF.centerY());
        Matrix matrix2 = this.tempMatrix;
        matrix2.setConcat(matrix2, matrix);
        this.tempMatrix.preTranslate(-rectF.centerX(), -rectF.centerY());
        this.tempRect.applyMatrix(this.tempMatrix);
        this.tempMatrix.reset();
        this.tempMatrix.preRotate(-rotation, orientedWidth / 2.0f, orientedHeight / 2.0f);
        this.tempRect.applyMatrix(this.tempMatrix);
        this.tempRect.getRect(rectF);
        PointF pointF = new PointF(this.state.getX(), this.state.getY());
        if (!rectF.contains(rectFCalculateBoundingBox)) {
            fFitScale = (!z || (rectFCalculateBoundingBox.width() <= rectF.width() && rectFCalculateBoundingBox.height() <= rectF.height())) ? scale : fitScale(rectF, scale, rectFCalculateBoundingBox.width() / scaleWidthToMaxSize(rectFCalculateBoundingBox, rectF));
            fitTranslation(rectF, rectFCalculateBoundingBox, pointF, radians);
        } else if (!z2 || this.rotationStartScale <= 0.0f) {
            fFitScale = scale;
        } else {
            float fWidth = rectFCalculateBoundingBox.width() / scaleWidthToMaxSize(rectFCalculateBoundingBox, rectF);
            if (this.state.getScale() * fWidth < this.rotationStartScale) {
                fWidth = 1.0f;
            }
            fFitScale = fitScale(rectF, scale, fWidth);
            fitTranslation(rectF, rectFCalculateBoundingBox, pointF, radians);
        }
        final float x = pointF.x - this.state.getX();
        final float y = pointF.y - this.state.getY();
        if (!z3) {
            this.state.translate(x, y);
            this.state.scale(fFitScale / scale, 0.0f, 0.0f);
            updateMatrix();
            return;
        }
        final float f = fFitScale / scale;
        if (Math.abs(f - 1.0f) >= 1.0E-5f || Math.abs(x) >= 1.0E-5f || Math.abs(y) >= 1.0E-5f) {
            this.animating = true;
            final float[] fArr = {1.0f, 0.0f, 0.0f};
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f2 = x * fFloatValue;
                    float[] fArr2 = fArr;
                    float f3 = f2 - fArr2[1];
                    fArr2[1] = fArr2[1] + f3;
                    float f4 = (y * fFloatValue) - fArr2[2];
                    fArr2[2] = fArr2[2] + f4;
                    SSHCropState sSHCropState = SSHCropView.this.state;
                    float[] fArr3 = fArr;
                    sSHCropState.translate(f3 * fArr3[0], f4 * fArr3[0]);
                    float f5 = ((f - 1.0f) * fFloatValue) + 1.0f;
                    float[] fArr4 = fArr;
                    float f6 = f5 / fArr4[0];
                    fArr4[0] = fArr4[0] * f6;
                    SSHCropView.this.state.scale(f6, 0.0f, 0.0f);
                    SSHCropView.this.updateMatrix();
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SSHCropView.this.animating = false;
                    if (z4) {
                        return;
                    }
                    SSHCropView.this.fitContentInBounds(z, z2, z3, true);
                }
            });
            valueAnimatorOfFloat.setInterpolator(this.areaView.getInterpolator());
            valueAnimatorOfFloat.setDuration(z4 ? 100L : 200L);
            valueAnimatorOfFloat.start();
        }
    }

    public void rotate90Degrees() {
        boolean z;
        this.areaView.resetAnimator();
        resetRotationStartScale();
        float orientation = ((this.state.getOrientation() - this.state.getBaseRotation()) - 90.0f) % 360.0f;
        float orientation2 = (this.state.getOrientation() - this.state.getBaseRotation()) - 90.0f;
        boolean z2 = this.freeform;
        if (z2 && this.areaView.getLockAspectRatio() > 0.0f) {
            SSHCropAreaView sSHCropAreaView = this.areaView;
            sSHCropAreaView.setLockedAspectRatio(1.0f / sSHCropAreaView.getLockAspectRatio());
            SSHCropAreaView sSHCropAreaView2 = this.areaView;
            sSHCropAreaView2.setActualRect(sSHCropAreaView2.getLockAspectRatio());
            z = false;
        } else {
            this.areaView.setBitmap(this.bitmap, (this.state.getBaseRotation() + orientation) % 180.0f != 0.0f, this.freeform);
            z = z2;
        }
        SSHCropState sSHCropState = this.state;
        sSHCropState.rotate(-sSHCropState.rotation, 0.0f, 0.0f);
        SSHCropState sSHCropState2 = this.state;
        sSHCropState2.reset(this.areaView, 1.0f, sSHCropState2.scale, orientation2, z);
        updateMatrix();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(orientation == 0.0f && this.areaView.getLockAspectRatio() == 0.0f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.animating || this.areaView.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            onScrollChangeBegan();
        } else if (action == 1 || action == 3) {
            onScrollChangeEnded();
        }
        try {
            return this.detector.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector.SSHCropGestureListener
    public void onDrag(float f, float f2) {
        if (this.animating) {
            return;
        }
        this.state.translate(f, f2);
        updateMatrix();
    }

    public void onScrollChangeBegan() {
        if (this.animating) {
            return;
        }
        resetRotationStartScale();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(false);
        }
    }

    public void onScrollChangeEnded() {
        fitContentInBounds(true, false, true);
    }

    @Override // ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector.SSHCropGestureListener
    public void onScale(float f, float f2, float f3) {
        if (this.animating) {
            return;
        }
        if (this.state.getScale() * f > 30.0f) {
            f = 30.0f / this.state.getScale();
        }
        this.state.scale(f, ((f2 - (this.imageView.getWidth() / 2)) / this.areaView.getCropWidth()) * this.state.getOrientedWidth(), ((f3 - (((this.imageView.getHeight() - this.bottomPadding) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) / 2.0f)) / this.areaView.getCropHeight()) * this.state.getOrientedHeight());
        updateMatrix();
    }

    public void onRotationBegan() {
        if (this.rotationStartScale < 1.0E-5f) {
            this.rotationStartScale = this.state.getScale();
        }
    }

    private void resetRotationStartScale() {
        this.rotationStartScale = 0.0f;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.state.rotate(f - this.state.getRotation(), 0.0f, 0.0f);
        fitContentInBounds(true, true, false);
    }

    public Bitmap getResult() {
        if (!this.state.hasChanges() && this.state.getBaseRotation() < 1.0E-5f && this.freeform) {
            return this.bitmap;
        }
        this.areaView.getCropRect(new RectF());
        int iCeil = (int) Math.ceil(scaleWidthToMaxSize(r0, new RectF(0.0f, 0.0f, 1280.0f, 1280.0f)));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, (int) Math.ceil(r1 / this.areaView.getAspectRatio()), Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        matrix.postTranslate((-this.state.getWidth()) / 2.0f, (-this.state.getHeight()) / 2.0f);
        matrix.postRotate(this.state.getOrientation());
        this.state.getConcatMatrix(matrix);
        float cropWidth = iCeil / this.areaView.getCropWidth();
        matrix.postScale(cropWidth, cropWidth);
        matrix.postTranslate(iCeil / 2, r2 / 2);
        new Canvas(bitmapCreateBitmap).drawBitmap(this.bitmap, matrix, new Paint(2));
        return bitmapCreateBitmap;
    }

    public float getCropLeft() {
        return this.areaView.getCropLeft();
    }

    public float getCropTop() {
        return this.areaView.getCropTop();
    }

    public float getCropWidth() {
        return this.areaView.getCropWidth();
    }

    public float getCropHeight() {
        return this.areaView.getCropHeight();
    }

    public static class SSHCropState {
        public float baseRotation;
        public float height;
        public Matrix matrix;
        public float minimumScale;
        public float orientation;
        public float rotation;
        public float scale;
        public float width;
        public float x;
        public float y;

        public SSHCropState(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.x = 0.0f;
            this.y = 0.0f;
            this.scale = 1.0f;
            this.baseRotation = i3;
            this.rotation = 0.0f;
            this.matrix = new Matrix();
        }

        public SSHCropState(SSHCropState sSHCropState) {
            this.width = sSHCropState.width;
            this.height = sSHCropState.height;
            this.x = sSHCropState.x;
            this.y = sSHCropState.y;
            this.minimumScale = sSHCropState.minimumScale;
            this.orientation = sSHCropState.orientation;
            this.scale = sSHCropState.scale;
            this.baseRotation = sSHCropState.baseRotation;
            this.rotation = sSHCropState.rotation;
            this.matrix = new Matrix(sSHCropState.matrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasChanges() {
            return Math.abs(this.x) > 1.0E-5f || Math.abs(this.y) > 1.0E-5f || Math.abs(this.scale - this.minimumScale) > 1.0E-5f || Math.abs(this.rotation) > 1.0E-5f || Math.abs(this.orientation) > 1.0E-5f;
        }

        public float getWidth() {
            return this.width;
        }

        public float getHeight() {
            return this.height;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getOrientedWidth() {
            return (this.orientation + this.baseRotation) % 180.0f != 0.0f ? this.height : this.width;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getOrientedHeight() {
            return (this.orientation + this.baseRotation) % 180.0f != 0.0f ? this.width : this.height;
        }

        public void translate(float f, float f2) {
            this.x += f;
            this.y += f2;
            this.matrix.postTranslate(f, f2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getX() {
            return this.x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getY() {
            return this.y;
        }

        public void scale(float f, float f2, float f3) {
            this.scale *= f;
            this.matrix.postScale(f, f, f2, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getScale() {
            return this.scale;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void rotate(float f, float f2, float f3) {
            this.rotation += f;
            this.matrix.postRotate(f, f2, f3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRotation() {
            return this.rotation;
        }

        public float getOrientation() {
            return this.orientation + this.baseRotation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBaseRotation() {
            return this.baseRotation;
        }

        public void reset() {
            this.x = 0.0f;
            this.y = 0.0f;
            this.scale = 1.0f;
            this.rotation = 0.0f;
            this.matrix = new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset(SSHCropAreaView sSHCropAreaView, float f, float f2, float f3, boolean z) {
            this.matrix.reset();
            float f4 = f3 % 360.0f;
            this.orientation = f4;
            float f5 = this.baseRotation;
            float f6 = (f4 + f5) % 180.0f != 0.0f ? this.height : this.width;
            float f7 = (f4 + f5) % 180.0f != 0.0f ? this.width : this.height;
            if (f3 == -90.0f || f3 == -270.0f) {
                float f8 = this.x;
                this.x = this.y;
                this.y = f8;
            } else if (f3 == -180.0f || f3 == -360.0f) {
                float f9 = -this.x;
                this.x = -this.y;
                this.y = f9;
            }
            if (z) {
                this.minimumScale = sSHCropAreaView.getCropWidth() / f6;
            } else {
                this.minimumScale = Math.max(sSHCropAreaView.getCropWidth() / f6, sSHCropAreaView.getCropHeight() / f7);
            }
            if (f2 == 0.0f) {
                float f10 = this.minimumScale;
                this.scale = f10;
                this.scale = f10 * f;
            } else {
                this.scale = f2;
            }
            Matrix matrix = this.matrix;
            float f11 = this.scale;
            matrix.postScale(f11, f11);
            this.matrix.postTranslate(this.x, this.y);
        }

        public void reset(RectF rectF, float f, float f2, boolean z) {
            this.matrix.reset();
            float f3 = f2 % 360.0f;
            this.orientation = f3;
            float f4 = this.baseRotation;
            float f5 = (f3 + f4) % 180.0f != 0.0f ? this.height : this.width;
            float f6 = (f3 + f4) % 180.0f != 0.0f ? this.width : this.height;
            if (f2 == -90.0f || f2 == -270.0f) {
                float f7 = this.x;
                this.x = this.y;
                this.y = f7;
            } else if (f2 == -180.0f || f2 == -360.0f) {
                float f8 = -this.x;
                this.x = -this.y;
                this.y = f8;
            }
            if (z) {
                this.minimumScale = rectF.width() / f5;
            } else {
                this.minimumScale = Math.max(rectF.width() / f5, rectF.height() / f6);
            }
            float f9 = this.minimumScale;
            this.scale = f9;
            float f10 = f9 * f;
            this.scale = f10;
            this.matrix.postScale(f10, f10);
            this.matrix.postTranslate(this.x, this.y);
        }

        public void getConcatMatrix(Matrix matrix) {
            matrix.postConcat(this.matrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Matrix getMatrix() {
            Matrix matrix = new Matrix();
            matrix.set(this.matrix);
            return matrix;
        }
    }

    private class CropRectangle {
        float[] coords = new float[8];

        CropRectangle(SSHCropView sSHCropView) {
        }

        void setRect(RectF rectF) {
            float[] fArr = this.coords;
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

        void applyMatrix(Matrix matrix) {
            matrix.mapPoints(this.coords);
        }

        void getRect(RectF rectF) {
            float[] fArr = this.coords;
            rectF.set(fArr[0], fArr[1], fArr[2], fArr[7]);
        }
    }
}
