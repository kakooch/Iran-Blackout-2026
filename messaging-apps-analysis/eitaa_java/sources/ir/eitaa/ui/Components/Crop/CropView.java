package ir.eitaa.ui.Components.Crop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.BubbleActivity;
import ir.eitaa.ui.Components.Crop.CropAreaView;
import ir.eitaa.ui.Components.Crop.CropGestureDetector;
import ir.eitaa.ui.Components.Paint.Swatch;
import ir.eitaa.ui.Components.Paint.Views.TextPaintView;
import ir.eitaa.ui.Components.PaintingOverlay;
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.Components.VideoEditTextureView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CropView extends FrameLayout implements CropAreaView.AreaViewListener, CropGestureDetector.CropGestureListener {
    private boolean animating;
    private CropAreaView areaView;
    private Bitmap bitmap;
    private int bitmapRotation;
    private float bottomPadding;
    RectF cropRect;
    private CropTransform cropTransform;
    private CropGestureDetector detector;
    private boolean freeform;
    private boolean hasAspectRatioDialog;
    private ImageView imageView;
    private boolean inBubbleMode;
    private RectF initialAreaRect;
    private boolean isVisible;
    private CropViewListener listener;
    private Matrix overlayMatrix;
    private PaintingOverlay paintingOverlay;
    private RectF previousAreaRect;
    private float rotationStartScale;
    RectF sizeRect;
    private CropState state;
    private Matrix tempMatrix;
    private CropRectangle tempRect;
    float[] values;
    private VideoEditTextureView videoEditTextureView;

    public interface CropViewListener {
        void onAspectLock(boolean enabled);

        void onChange(boolean reset);

        void onTapUp();

        void onUpdate();
    }

    @Override // ir.eitaa.ui.Components.Crop.CropGestureDetector.CropGestureListener
    public void onFling(float startX, float startY, float velocityX, float velocityY) {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    private class CropState {
        private float baseRotation;
        private float height;
        private Matrix matrix;
        private float minimumScale;
        private boolean mirrored;
        private float orientation;
        private float rotation;
        private float scale;
        private float width;
        private float x;
        private float y;

        private CropState(int w, int h, int bRotation) {
            this.width = w;
            this.height = h;
            this.x = 0.0f;
            this.y = 0.0f;
            this.scale = 1.0f;
            this.baseRotation = bRotation;
            this.rotation = 0.0f;
            this.matrix = new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(int w, int h, int rotation) {
            float f = w;
            this.scale *= this.width / f;
            this.width = f;
            this.height = h;
            updateMinimumScale();
            this.matrix.getValues(CropView.this.values);
            this.matrix.reset();
            Matrix matrix = this.matrix;
            float f2 = this.scale;
            matrix.postScale(f2, f2);
            Matrix matrix2 = this.matrix;
            float[] fArr = CropView.this.values;
            matrix2.postTranslate(fArr[2], fArr[5]);
            CropView.this.updateMatrix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasChanges() {
            return Math.abs(this.x) > 1.0E-5f || Math.abs(this.y) > 1.0E-5f || Math.abs(this.scale - this.minimumScale) > 1.0E-5f || Math.abs(this.rotation) > 1.0E-5f || Math.abs(this.orientation) > 1.0E-5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getWidth() {
            return this.width;
        }

        /* JADX INFO: Access modifiers changed from: private */
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

        /* JADX INFO: Access modifiers changed from: private */
        public void translate(float x, float y) {
            this.x += x;
            this.y += y;
            this.matrix.postTranslate(x, y);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getX() {
            return this.x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getY() {
            return this.y;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void scale(float s, float pivotX, float pivotY) {
            this.scale *= s;
            this.matrix.postScale(s, s, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getScale() {
            return this.scale;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void rotate(float angle, float pivotX, float pivotY) {
            this.rotation += angle;
            this.matrix.postRotate(angle, pivotX, pivotY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRotation() {
            return this.rotation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getOrientation() {
            return this.orientation + this.baseRotation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getOrientationOnly() {
            return (int) this.orientation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBaseRotation() {
            return this.baseRotation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mirror() {
            this.mirrored = !this.mirrored;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset(CropAreaView areaView, float orient, boolean freeform) {
            this.matrix.reset();
            this.x = 0.0f;
            this.y = 0.0f;
            this.rotation = 0.0f;
            this.orientation = orient;
            updateMinimumScale();
            float f = this.minimumScale;
            this.scale = f;
            this.matrix.postScale(f, f);
        }

        private void updateMinimumScale() {
            float f = this.orientation;
            float f2 = this.baseRotation;
            float f3 = (f + f2) % 180.0f != 0.0f ? this.height : this.width;
            float f4 = (f + f2) % 180.0f != 0.0f ? this.width : this.height;
            if (CropView.this.freeform) {
                this.minimumScale = CropView.this.areaView.getCropWidth() / f3;
            } else {
                this.minimumScale = Math.max(CropView.this.areaView.getCropWidth() / f3, CropView.this.areaView.getCropHeight() / f4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getConcatMatrix(Matrix toMatrix) {
            toMatrix.postConcat(this.matrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Matrix getMatrix() {
            Matrix matrix = new Matrix();
            matrix.set(this.matrix);
            return matrix;
        }
    }

    public CropView(Context context) {
        super(context);
        this.values = new float[9];
        this.cropRect = new RectF();
        this.sizeRect = new RectF(0.0f, 0.0f, 1280.0f, 1280.0f);
        this.inBubbleMode = context instanceof BubbleActivity;
        this.previousAreaRect = new RectF();
        this.initialAreaRect = new RectF();
        this.overlayMatrix = new Matrix();
        this.tempRect = new CropRectangle();
        this.tempMatrix = new Matrix();
        this.animating = false;
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        addView(this.imageView);
        CropGestureDetector cropGestureDetector = new CropGestureDetector(context);
        this.detector = cropGestureDetector;
        cropGestureDetector.setOnGestureListener(this);
        CropAreaView cropAreaView = new CropAreaView(context);
        this.areaView = cropAreaView;
        cropAreaView.setListener(this);
        addView(this.areaView);
    }

    public boolean isReady() {
        return (this.detector.isScaling() || this.detector.isDragging() || this.areaView.isDragging()) ? false : true;
    }

    public void setListener(CropViewListener l) {
        this.listener = l;
    }

    public void setBottomPadding(float value) {
        this.bottomPadding = value;
        this.areaView.setBottomPadding(value);
    }

    public void setAspectRatio(float ratio) {
        this.areaView.setActualRect(ratio);
    }

    public void setBitmap(Bitmap b, int rotation, boolean fform, boolean same, PaintingOverlay overlay, CropTransform transform, VideoEditTextureView videoView, final MediaController.CropState restoreState) {
        this.freeform = fform;
        this.paintingOverlay = overlay;
        this.videoEditTextureView = videoView;
        this.cropTransform = transform;
        this.bitmapRotation = rotation;
        this.bitmap = b;
        this.areaView.setIsVideo(videoView != null);
        if (b == null && videoView == null) {
            this.state = null;
            this.imageView.setImageDrawable(null);
            return;
        }
        final int currentWidth = getCurrentWidth();
        final int currentHeight = getCurrentHeight();
        CropState cropState = this.state;
        if (cropState != null && same) {
            cropState.update(currentWidth, currentHeight, rotation);
        } else {
            this.state = new CropState(currentWidth, currentHeight, 0);
            this.areaView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.Crop.CropView.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    float f;
                    float f2;
                    int i;
                    int i2;
                    CropView.this.reset();
                    MediaController.CropState cropState2 = restoreState;
                    if (cropState2 != null) {
                        if (cropState2.lockedAspectRatio > 1.0E-4f) {
                            CropView.this.areaView.setLockedAspectRatio(restoreState.lockedAspectRatio);
                            if (CropView.this.listener != null) {
                                CropView.this.listener.onAspectLock(true);
                            }
                        }
                        CropView.this.setFreeform(restoreState.freeform);
                        float aspectRatio = CropView.this.areaView.getAspectRatio();
                        int i3 = restoreState.transformRotation;
                        if (i3 == 90 || i3 == 270) {
                            aspectRatio = 1.0f / aspectRatio;
                            f = CropView.this.state.height;
                            f2 = CropView.this.state.width;
                            i = currentHeight;
                            i2 = currentWidth;
                        } else {
                            f = CropView.this.state.width;
                            f2 = CropView.this.state.height;
                            i = currentWidth;
                            i2 = currentHeight;
                        }
                        int i4 = restoreState.transformRotation;
                        boolean z = CropView.this.freeform;
                        if (!CropView.this.freeform || CropView.this.areaView.getLockAspectRatio() <= 0.0f) {
                            CropView.this.areaView.setBitmap(CropView.this.getCurrentWidth(), CropView.this.getCurrentHeight(), (((float) i4) + CropView.this.state.getBaseRotation()) % 180.0f != 0.0f, CropView.this.freeform);
                        } else {
                            CropView.this.areaView.setLockedAspectRatio(1.0f / CropView.this.areaView.getLockAspectRatio());
                            CropView.this.areaView.setActualRect(CropView.this.areaView.getLockAspectRatio());
                            z = false;
                        }
                        CropView.this.state.reset(CropView.this.areaView, i4, z);
                        CropAreaView cropAreaView = CropView.this.areaView;
                        MediaController.CropState cropState3 = restoreState;
                        cropAreaView.setActualRect((aspectRatio * cropState3.cropPw) / cropState3.cropPh);
                        CropView.this.state.mirrored = restoreState.mirrored;
                        CropView.this.state.rotate(restoreState.cropRotate, 0.0f, 0.0f);
                        CropView.this.state.translate(restoreState.cropPx * i * CropView.this.state.minimumScale, restoreState.cropPy * i2 * CropView.this.state.minimumScale);
                        CropView.this.state.scale(restoreState.cropScale * (Math.max(CropView.this.areaView.getCropWidth() / f, CropView.this.areaView.getCropHeight() / f2) / CropView.this.state.minimumScale), 0.0f, 0.0f);
                        CropView.this.updateMatrix();
                        if (CropView.this.listener != null) {
                            CropView.this.listener.onChange(false);
                        }
                    }
                    CropView.this.areaView.getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                }
            });
        }
        this.imageView.setImageBitmap(videoView == null ? this.bitmap : null);
    }

    public void willShow() {
        this.areaView.setFrameVisibility(true, false);
        this.areaView.setDimVisibility(true);
        this.areaView.invalidate();
    }

    public void setFreeform(boolean fform) {
        this.areaView.setFreeform(fform);
        this.freeform = fform;
    }

    public void onShow() {
        this.isVisible = true;
    }

    public void onHide() {
        this.videoEditTextureView = null;
        this.paintingOverlay = null;
        this.isVisible = false;
    }

    public void show() {
        updateCropTransform();
        this.areaView.setDimVisibility(true);
        this.areaView.setFrameVisibility(true, true);
        this.areaView.invalidate();
    }

    public void hide() {
        this.imageView.setVisibility(4);
        this.areaView.setDimVisibility(false);
        this.areaView.setFrameVisibility(false, false);
        this.areaView.invalidate();
    }

    public void reset() {
        this.areaView.resetAnimator();
        this.areaView.setBitmap(getCurrentWidth(), getCurrentHeight(), this.state.getBaseRotation() % 180.0f != 0.0f, this.freeform);
        this.areaView.setLockedAspectRatio(this.freeform ? 0.0f : 1.0f);
        this.state.reset(this.areaView, 0.0f, this.freeform);
        this.state.mirrored = false;
        this.areaView.getCropRect(this.initialAreaRect);
        updateMatrix();
        resetRotationStartScale();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(true);
            this.listener.onAspectLock(false);
        }
    }

    public void updateMatrix() {
        this.overlayMatrix.reset();
        if (this.state.getBaseRotation() == 90.0f || this.state.getBaseRotation() == 270.0f) {
            this.overlayMatrix.postTranslate((-this.state.getHeight()) / 2.0f, (-this.state.getWidth()) / 2.0f);
        } else {
            this.overlayMatrix.postTranslate((-this.state.getWidth()) / 2.0f, (-this.state.getHeight()) / 2.0f);
        }
        this.overlayMatrix.postRotate(this.state.getOrientationOnly());
        this.state.getConcatMatrix(this.overlayMatrix);
        this.overlayMatrix.postTranslate(this.areaView.getCropCenterX(), this.areaView.getCropCenterY());
        if (!this.freeform || this.isVisible) {
            updateCropTransform();
            this.listener.onUpdate();
        }
        invalidate();
    }

    private void fillAreaView(RectF targetRect, boolean allowZoomOut) {
        final float scale;
        final boolean z;
        int i = 0;
        final float[] fArr = {1.0f};
        float fMax = Math.max(targetRect.width() / this.areaView.getCropWidth(), targetRect.height() / this.areaView.getCropHeight());
        if (this.state.getScale() * fMax > 30.0f) {
            scale = 30.0f / this.state.getScale();
            z = true;
        } else {
            scale = fMax;
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.inBubbleMode) {
            i = AndroidUtilities.statusBarHeight;
        }
        final float orientedWidth = this.state.getOrientedWidth() * ((targetRect.centerX() - (this.imageView.getWidth() / 2)) / this.areaView.getCropWidth());
        final float fCenterY = ((targetRect.centerY() - (((this.imageView.getHeight() - this.bottomPadding) + i) / 2.0f)) / this.areaView.getCropHeight()) * this.state.getOrientedHeight();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.Crop.-$$Lambda$CropView$JM3qe1qNQmy_lLIkSACYLckW-gc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$fillAreaView$0$CropView(scale, fArr, orientedWidth, fCenterY, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Crop.CropView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (z) {
                    CropView.this.fitContentInBounds(false, false, true);
                }
            }
        });
        this.areaView.fill(targetRect, valueAnimatorOfFloat, true);
        this.initialAreaRect.set(targetRect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fillAreaView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fillAreaView$0$CropView(float f, float[] fArr, float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = (((f - 1.0f) * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + 1.0f) / fArr[0];
        fArr[0] = fArr[0] * fFloatValue;
        this.state.scale(fFloatValue, f2, f3);
        updateMatrix();
    }

    private float fitScale(RectF contentRect, float scale, float ratio) {
        float fWidth = contentRect.width() * ratio;
        float fHeight = contentRect.height() * ratio;
        float fWidth2 = (contentRect.width() - fWidth) / 2.0f;
        float fHeight2 = (contentRect.height() - fHeight) / 2.0f;
        float f = contentRect.left;
        float f2 = contentRect.top;
        contentRect.set(f + fWidth2, f2 + fHeight2, f + fWidth2 + fWidth, f2 + fHeight2 + fHeight);
        return scale * ratio;
    }

    private void fitTranslation(RectF contentRect, RectF boundsRect, PointF translation, float radians) {
        float f = boundsRect.left;
        float f2 = boundsRect.top;
        float f3 = boundsRect.right;
        float f4 = boundsRect.bottom;
        float f5 = contentRect.left;
        if (f5 > f) {
            f3 += f5 - f;
            f = f5;
        }
        float f6 = contentRect.top;
        if (f6 > f2) {
            f4 += f6 - f2;
            f2 = f6;
        }
        float f7 = contentRect.right;
        if (f7 < f3) {
            f += f7 - f3;
        }
        float f8 = contentRect.bottom;
        if (f8 < f4) {
            f2 += f8 - f4;
        }
        float fCenterX = boundsRect.centerX() - (f + (boundsRect.width() / 2.0f));
        float fCenterY = boundsRect.centerY() - (f2 + (boundsRect.height() / 2.0f));
        double d = radians;
        Double.isNaN(d);
        double d2 = 1.5707963267948966d - d;
        double dSin = Math.sin(d2);
        double d3 = fCenterX;
        Double.isNaN(d3);
        float f9 = (float) (dSin * d3);
        double dCos = Math.cos(d2);
        Double.isNaN(d3);
        float f10 = (float) (dCos * d3);
        Double.isNaN(d);
        double d4 = d + 1.5707963267948966d;
        double dCos2 = Math.cos(d4);
        double d5 = fCenterY;
        Double.isNaN(d5);
        double dSin2 = Math.sin(d4);
        Double.isNaN(d5);
        translation.set(translation.x + f9 + ((float) (dCos2 * d5)), translation.y + f10 + ((float) (dSin2 * d5)));
    }

    public RectF calculateBoundingBox(float w, float h, float rotation) {
        RectF rectF = new RectF(0.0f, 0.0f, w, h);
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation, w / 2.0f, h / 2.0f);
        matrix.mapRect(rectF);
        return rectF;
    }

    public float scaleWidthToMaxSize(RectF sizeRect, RectF maxSizeRect) {
        float fWidth = maxSizeRect.width();
        return ((float) Math.floor((double) ((sizeRect.height() * fWidth) / sizeRect.width()))) > maxSizeRect.height() ? (float) Math.floor((maxSizeRect.height() * sizeRect.width()) / sizeRect.height()) : fWidth;
    }

    private static class CropRectangle {
        float[] coords = new float[8];

        CropRectangle() {
        }

        void setRect(RectF rect) {
            float[] fArr = this.coords;
            float f = rect.left;
            fArr[0] = f;
            float f2 = rect.top;
            fArr[1] = f2;
            float f3 = rect.right;
            fArr[2] = f3;
            fArr[3] = f2;
            fArr[4] = f3;
            float f4 = rect.bottom;
            fArr[5] = f4;
            fArr[6] = f;
            fArr[7] = f4;
        }

        void applyMatrix(Matrix m) {
            m.mapPoints(this.coords);
        }

        void getRect(RectF rect) {
            float[] fArr = this.coords;
            rect.set(fArr[0], fArr[1], fArr[2], fArr[7]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitContentInBounds(boolean allowScale, boolean maximize, boolean animated) {
        fitContentInBounds(allowScale, maximize, animated, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitContentInBounds(final boolean allowScale, final boolean maximize, final boolean animated, final boolean fast) {
        float fFitScale;
        if (this.state == null) {
            return;
        }
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
            fFitScale = (!allowScale || (rectFCalculateBoundingBox.width() <= rectF.width() && rectFCalculateBoundingBox.height() <= rectF.height())) ? scale : fitScale(rectF, scale, rectFCalculateBoundingBox.width() / scaleWidthToMaxSize(rectFCalculateBoundingBox, rectF));
            fitTranslation(rectF, rectFCalculateBoundingBox, pointF, radians);
        } else if (!maximize || this.rotationStartScale <= 0.0f) {
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
        if (!animated) {
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
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.Crop.-$$Lambda$CropView$yUbo46_z30Fgn71rc1zAXhtn5qA
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$fitContentInBounds$1$CropView(x, fArr, y, f, valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Crop.CropView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    CropView.this.animating = false;
                    if (fast) {
                        return;
                    }
                    CropView.this.fitContentInBounds(allowScale, maximize, animated, true);
                }
            });
            valueAnimatorOfFloat.setInterpolator(this.areaView.getInterpolator());
            valueAnimatorOfFloat.setDuration(fast ? 100L : 200L);
            valueAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fitContentInBounds$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fitContentInBounds$1$CropView(float f, float[] fArr, float f2, float f3, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f4 = (f * fFloatValue) - fArr[1];
        fArr[1] = fArr[1] + f4;
        float f5 = (f2 * fFloatValue) - fArr[2];
        fArr[2] = fArr[2] + f5;
        this.state.translate(f4 * fArr[0], f5 * fArr[0]);
        float f6 = (((f3 - 1.0f) * fFloatValue) + 1.0f) / fArr[0];
        fArr[0] = fArr[0] * f6;
        this.state.scale(f6, 0.0f, 0.0f);
        updateMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentWidth() {
        VideoEditTextureView videoEditTextureView = this.videoEditTextureView;
        if (videoEditTextureView != null) {
            return videoEditTextureView.getVideoWidth();
        }
        int i = this.bitmapRotation;
        return (i == 90 || i == 270) ? this.bitmap.getHeight() : this.bitmap.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentHeight() {
        VideoEditTextureView videoEditTextureView = this.videoEditTextureView;
        if (videoEditTextureView != null) {
            return videoEditTextureView.getVideoHeight();
        }
        int i = this.bitmapRotation;
        return (i == 90 || i == 270) ? this.bitmap.getWidth() : this.bitmap.getHeight();
    }

    public boolean mirror() {
        CropState cropState = this.state;
        boolean z = false;
        if (cropState == null) {
            return false;
        }
        cropState.mirror();
        updateMatrix();
        if (this.listener != null) {
            float orientation = (this.state.getOrientation() - this.state.getBaseRotation()) % 360.0f;
            CropViewListener cropViewListener = this.listener;
            if (!this.state.hasChanges() && orientation == 0.0f && this.areaView.getLockAspectRatio() == 0.0f && !this.state.mirrored) {
                z = true;
            }
            cropViewListener.onChange(z);
        }
        return this.state.mirrored;
    }

    public boolean rotate90Degrees() {
        if (this.state == null) {
            return false;
        }
        this.areaView.resetAnimator();
        resetRotationStartScale();
        float orientation = ((this.state.getOrientation() - this.state.getBaseRotation()) - 90.0f) % 360.0f;
        boolean z = this.freeform;
        if (z && this.areaView.getLockAspectRatio() > 0.0f) {
            CropAreaView cropAreaView = this.areaView;
            cropAreaView.setLockedAspectRatio(1.0f / cropAreaView.getLockAspectRatio());
            CropAreaView cropAreaView2 = this.areaView;
            cropAreaView2.setActualRect(cropAreaView2.getLockAspectRatio());
            z = false;
        } else {
            this.areaView.setBitmap(getCurrentWidth(), getCurrentHeight(), (this.state.getBaseRotation() + orientation) % 180.0f != 0.0f, this.freeform);
        }
        this.state.reset(this.areaView, orientation, z);
        updateMatrix();
        fitContentInBounds(true, false, false);
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(orientation == 0.0f && this.areaView.getLockAspectRatio() == 0.0f && !this.state.mirrored);
        }
        return this.state.getOrientationOnly() != 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.animating || this.areaView.onTouchEvent(event)) {
            return true;
        }
        int action = event.getAction();
        if (action == 0) {
            onScrollChangeBegan();
        } else if (action == 1 || action == 3) {
            onScrollChangeEnded();
        }
        try {
            return this.detector.onTouchEvent(event);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // ir.eitaa.ui.Components.Crop.CropAreaView.AreaViewListener
    public void onAreaChangeBegan() {
        this.areaView.getCropRect(this.previousAreaRect);
        resetRotationStartScale();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(false);
        }
    }

    @Override // ir.eitaa.ui.Components.Crop.CropAreaView.AreaViewListener
    public void onAreaChange() {
        this.areaView.setGridType(CropAreaView.GridType.MAJOR, false);
        float fCenterX = this.previousAreaRect.centerX() - this.areaView.getCropCenterX();
        float fCenterY = this.previousAreaRect.centerY() - this.areaView.getCropCenterY();
        CropState cropState = this.state;
        if (cropState != null) {
            cropState.translate(fCenterX, fCenterY);
        }
        updateMatrix();
        this.areaView.getCropRect(this.previousAreaRect);
        fitContentInBounds(true, false, false);
    }

    @Override // ir.eitaa.ui.Components.Crop.CropAreaView.AreaViewListener
    public void onAreaChangeEnded() {
        this.areaView.setGridType(CropAreaView.GridType.NONE, true);
        fillAreaView(this.areaView.getTargetRectToFill(), false);
    }

    @Override // ir.eitaa.ui.Components.Crop.CropGestureDetector.CropGestureListener
    public void onDrag(float dx, float dy) {
        if (this.animating) {
            return;
        }
        this.state.translate(dx, dy);
        updateMatrix();
    }

    @Override // ir.eitaa.ui.Components.Crop.CropGestureDetector.CropGestureListener
    public void onTapUp() {
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onTapUp();
        }
    }

    public void onScrollChangeBegan() {
        if (this.animating) {
            return;
        }
        this.areaView.setGridType(CropAreaView.GridType.MAJOR, true);
        resetRotationStartScale();
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(false);
        }
    }

    public void onScrollChangeEnded() {
        this.areaView.setGridType(CropAreaView.GridType.NONE, true);
        fitContentInBounds(true, false, true);
    }

    @Override // ir.eitaa.ui.Components.Crop.CropGestureDetector.CropGestureListener
    public void onScale(float scale, float x, float y) {
        if (this.animating) {
            return;
        }
        if (this.state.getScale() * scale > 30.0f) {
            scale = 30.0f / this.state.getScale();
        }
        this.state.scale(scale, ((x - (this.imageView.getWidth() / 2)) / this.areaView.getCropWidth()) * this.state.getOrientedWidth(), ((y - (((this.imageView.getHeight() - this.bottomPadding) - ((Build.VERSION.SDK_INT < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight)) / 2.0f)) / this.areaView.getCropHeight()) * this.state.getOrientedHeight());
        updateMatrix();
    }

    public void onRotationBegan() {
        this.areaView.setGridType(CropAreaView.GridType.MINOR, false);
        if (this.rotationStartScale < 1.0E-5f) {
            this.rotationStartScale = this.state.getScale();
        }
    }

    public void onRotationEnded() {
        this.areaView.setGridType(CropAreaView.GridType.NONE, true);
    }

    private void resetRotationStartScale() {
        this.rotationStartScale = 0.0f;
    }

    @Override // android.view.View
    public void setRotation(float angle) {
        this.state.rotate(angle - this.state.getRotation(), 0.0f, 0.0f);
        fitContentInBounds(true, true, false);
    }

    public static void editBitmap(Context context, String path, Bitmap b, Canvas canvas, Bitmap canvasBitmap, Bitmap.CompressFormat format, Matrix stateMatrix, int contentWidth, int contentHeight, float stateScale, float rotation, float orientationOnly, float scale, boolean mirror, ArrayList<VideoEditedInfo.MediaEntity> entities, boolean clear) {
        float f = orientationOnly;
        char c = 0;
        if (clear) {
            try {
                canvasBitmap.eraseColor(0);
            } catch (Throwable th) {
                FileLog.e(th);
                return;
            }
        }
        Bitmap bitmapDecodeFile = b == null ? BitmapFactory.decodeFile(path) : b;
        float fMax = Math.max(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight()) / Math.max(contentWidth, contentHeight);
        Matrix matrix = new Matrix();
        int i = 2;
        matrix.postTranslate((-bitmapDecodeFile.getWidth()) / 2, (-bitmapDecodeFile.getHeight()) / 2);
        if (mirror) {
            matrix.postScale(-1.0f, 1.0f);
        }
        float f2 = 1.0f / fMax;
        matrix.postScale(f2, f2);
        matrix.postRotate(f);
        matrix.postConcat(stateMatrix);
        matrix.postScale(scale, scale);
        matrix.postTranslate(canvasBitmap.getWidth() / 2, canvasBitmap.getHeight() / 2);
        canvas.drawBitmap(bitmapDecodeFile, matrix, new Paint(2));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        canvasBitmap.compress(format, 87, fileOutputStream);
        fileOutputStream.close();
        if (entities != null && !entities.isEmpty()) {
            float[] fArr = new float[4];
            float width = f2 * scale * stateScale * (bitmapDecodeFile.getWidth() / canvasBitmap.getWidth());
            TextPaintView textPaintView = null;
            int size = entities.size();
            int i2 = 0;
            while (i2 < size) {
                VideoEditedInfo.MediaEntity mediaEntity = entities.get(i2);
                fArr[c] = (mediaEntity.x * bitmapDecodeFile.getWidth()) + ((mediaEntity.viewWidth * mediaEntity.scale) / 2.0f);
                fArr[1] = (mediaEntity.y * bitmapDecodeFile.getHeight()) + ((mediaEntity.viewHeight * mediaEntity.scale) / 2.0f);
                fArr[i] = mediaEntity.textViewX * bitmapDecodeFile.getWidth();
                fArr[3] = mediaEntity.textViewY * bitmapDecodeFile.getHeight();
                matrix.mapPoints(fArr);
                byte b2 = mediaEntity.type;
                if (b2 == 0) {
                    int width2 = canvasBitmap.getWidth() / i;
                    mediaEntity.viewHeight = width2;
                    mediaEntity.viewWidth = width2;
                } else if (b2 == 1) {
                    mediaEntity.fontSize = canvasBitmap.getWidth() / 9;
                    if (textPaintView == null) {
                        textPaintView = new TextPaintView(context, new Point(0.0f, 0.0f), mediaEntity.fontSize, "", new Swatch(-16777216, 0.85f, 0.1f), 0);
                        textPaintView.setMaxWidth(canvasBitmap.getWidth() - 20);
                    }
                    byte b3 = mediaEntity.subType;
                    textPaintView.setType((b3 & 1) != 0 ? 0 : (b3 & 4) != 0 ? 2 : 1);
                    textPaintView.setText(mediaEntity.text);
                    textPaintView.measure(View.MeasureSpec.makeMeasureSpec(canvasBitmap.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(canvasBitmap.getHeight(), Integer.MIN_VALUE));
                    mediaEntity.viewWidth = textPaintView.getMeasuredWidth();
                    mediaEntity.viewHeight = textPaintView.getMeasuredHeight();
                }
                float f3 = mediaEntity.scale * width;
                mediaEntity.scale = f3;
                c = 0;
                mediaEntity.x = (fArr[0] - ((mediaEntity.viewWidth * f3) / 2.0f)) / canvasBitmap.getWidth();
                mediaEntity.y = (fArr[1] - ((mediaEntity.viewHeight * mediaEntity.scale) / 2.0f)) / canvasBitmap.getHeight();
                mediaEntity.textViewX = fArr[2] / canvasBitmap.getWidth();
                mediaEntity.textViewY = fArr[3] / canvasBitmap.getHeight();
                mediaEntity.width = (mediaEntity.viewWidth * mediaEntity.scale) / canvasBitmap.getWidth();
                mediaEntity.height = (mediaEntity.viewHeight * mediaEntity.scale) / canvasBitmap.getHeight();
                mediaEntity.textViewWidth = mediaEntity.viewWidth / canvasBitmap.getWidth();
                mediaEntity.textViewHeight = mediaEntity.viewHeight / canvasBitmap.getHeight();
                double d = mediaEntity.rotation;
                double d2 = rotation + f;
                Double.isNaN(d2);
                Double.isNaN(d);
                mediaEntity.rotation = (float) (d - (d2 * 0.017453292519943295d));
                i2++;
                f = orientationOnly;
                i = 2;
            }
        }
        bitmapDecodeFile.recycle();
    }

    private void updateCropTransform() {
        int i;
        float f;
        float fMax;
        if (this.cropTransform == null || this.state == null) {
            return;
        }
        this.areaView.getCropRect(this.cropRect);
        int iCeil = (int) Math.ceil(scaleWidthToMaxSize(this.cropRect, this.sizeRect));
        int iCeil2 = (int) Math.ceil(r2 / this.areaView.getAspectRatio());
        float cropWidth = iCeil / this.areaView.getCropWidth();
        this.state.matrix.getValues(this.values);
        float f2 = this.state.minimumScale * cropWidth;
        int orientationOnly = this.state.getOrientationOnly();
        while (orientationOnly < 0) {
            orientationOnly += 360;
        }
        if (orientationOnly == 90 || orientationOnly == 270) {
            i = (int) this.state.height;
            f = this.state.width;
        } else {
            i = (int) this.state.width;
            f = this.state.height;
        }
        double d = iCeil;
        float f3 = i;
        double dCeil = Math.ceil(f3 * f2);
        Double.isNaN(d);
        float f4 = (float) (d / dCeil);
        double d2 = iCeil2;
        float f5 = (int) f;
        double dCeil2 = Math.ceil(f2 * f5);
        Double.isNaN(d2);
        float f6 = (float) (d2 / dCeil2);
        if (f4 > 1.0f || f6 > 1.0f) {
            float fMax2 = Math.max(f4, f6);
            f4 /= fMax2;
            f6 /= fMax2;
        }
        float f7 = f4;
        float f8 = f6;
        RectF targetRectToFill = this.areaView.getTargetRectToFill(f3 / f5);
        if (this.freeform) {
            fMax = targetRectToFill.width() / f3;
        } else {
            fMax = Math.max(targetRectToFill.width() / f3, targetRectToFill.height() / f5);
        }
        float f9 = this.state.scale / fMax;
        float f10 = this.state.scale / this.state.minimumScale;
        float f11 = (this.values[2] / f3) / this.state.scale;
        float f12 = (this.values[5] / f5) / this.state.scale;
        float f13 = this.state.rotation;
        RectF targetRectToFill2 = this.areaView.getTargetRectToFill();
        this.cropTransform.setViewTransform(this.state.mirrored || this.state.hasChanges() || this.state.getBaseRotation() >= 1.0E-5f, f11, f12, f13, this.state.getOrientationOnly(), f9, f10, this.state.minimumScale / fMax, f7, f8, this.areaView.getCropCenterX() - targetRectToFill2.centerX(), this.areaView.getCropCenterY() - targetRectToFill2.centerY(), this.state.mirrored);
    }

    public static String getCopy(String path) {
        File file = new File(FileLoader.getDirectory(4), SharedConfig.getLastLocalId() + "_temp.jpg");
        try {
            AndroidUtilities.copyFile(new File(path), file);
        } catch (Exception e) {
            FileLog.e(e);
        }
        return file.getAbsolutePath();
    }

    public void makeCrop(MediaController.MediaEditState editState) {
        int i;
        int i2;
        float f;
        if (this.state == null) {
            return;
        }
        this.areaView.getCropRect(this.cropRect);
        int iCeil = (int) Math.ceil(scaleWidthToMaxSize(this.cropRect, this.sizeRect));
        int iCeil2 = (int) Math.ceil(r3 / this.areaView.getAspectRatio());
        float cropWidth = iCeil / this.areaView.getCropWidth();
        if (editState.paintPath != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            String copy = getCopy(editState.paintPath);
            if (editState.croppedPaintPath != null) {
                new File(editState.croppedPaintPath).delete();
                editState.croppedPaintPath = null;
            }
            editState.croppedPaintPath = copy;
            ArrayList<VideoEditedInfo.MediaEntity> arrayList = editState.mediaEntities;
            if (arrayList != null && !arrayList.isEmpty()) {
                editState.croppedMediaEntities = new ArrayList<>(editState.mediaEntities.size());
                int size = editState.mediaEntities.size();
                for (int i3 = 0; i3 < size; i3++) {
                    editState.croppedMediaEntities.add(editState.mediaEntities.get(i3).copy());
                }
            } else {
                editState.croppedMediaEntities = null;
            }
            editBitmap(getContext(), copy, null, canvas, bitmapCreateBitmap, Bitmap.CompressFormat.PNG, this.state.matrix, getCurrentWidth(), getCurrentHeight(), this.state.scale, this.state.rotation, this.state.getOrientationOnly(), cropWidth, false, editState.croppedMediaEntities, false);
        }
        if (editState.cropState == null) {
            editState.cropState = new MediaController.CropState();
        }
        this.state.matrix.getValues(this.values);
        float f2 = this.state.minimumScale * cropWidth;
        editState.cropState.transformRotation = this.state.getOrientationOnly();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("set transformRotation = " + editState.cropState.transformRotation);
        }
        while (true) {
            MediaController.CropState cropState = editState.cropState;
            i = cropState.transformRotation;
            if (i >= 0) {
                break;
            } else {
                cropState.transformRotation = i + 360;
            }
        }
        if (i == 90 || i == 270) {
            i2 = (int) this.state.height;
            f = this.state.width;
        } else {
            i2 = (int) this.state.width;
            f = this.state.height;
        }
        MediaController.CropState cropState2 = editState.cropState;
        double d = iCeil;
        float f3 = i2;
        double dCeil = Math.ceil(f3 * f2);
        Double.isNaN(d);
        cropState2.cropPw = (float) (d / dCeil);
        MediaController.CropState cropState3 = editState.cropState;
        double d2 = iCeil2;
        float f4 = (int) f;
        double dCeil2 = Math.ceil(f2 * f4);
        Double.isNaN(d2);
        cropState3.cropPh = (float) (d2 / dCeil2);
        MediaController.CropState cropState4 = editState.cropState;
        float f5 = cropState4.cropPw;
        if (f5 > 1.0f || cropState4.cropPh > 1.0f) {
            float fMax = Math.max(f5, cropState4.cropPh);
            MediaController.CropState cropState5 = editState.cropState;
            cropState5.cropPw /= fMax;
            cropState5.cropPh /= fMax;
        }
        editState.cropState.cropScale = this.state.scale * Math.min(f3 / this.areaView.getCropWidth(), f4 / this.areaView.getCropHeight());
        editState.cropState.cropPx = (this.values[2] / f3) / this.state.scale;
        editState.cropState.cropPy = (this.values[5] / f4) / this.state.scale;
        editState.cropState.cropRotate = this.state.rotation;
        editState.cropState.stateScale = this.state.scale;
        editState.cropState.mirrored = this.state.mirrored;
        MediaController.CropState cropState6 = editState.cropState;
        cropState6.scale = cropWidth;
        cropState6.matrix = this.state.matrix;
        MediaController.CropState cropState7 = editState.cropState;
        cropState7.width = iCeil;
        cropState7.height = iCeil2;
        cropState7.freeform = this.freeform;
        cropState7.lockedAspectRatio = this.areaView.getLockAspectRatio();
        editState.cropState.initied = true;
    }

    private void setLockedAspectRatio(float aspectRatio) {
        this.areaView.setLockedAspectRatio(aspectRatio);
        RectF rectF = new RectF();
        this.areaView.calculateRect(rectF, aspectRatio);
        fillAreaView(rectF, true);
        CropViewListener cropViewListener = this.listener;
        if (cropViewListener != null) {
            cropViewListener.onChange(false);
            this.listener.onAspectLock(true);
        }
    }

    public void showAspectRatioDialog() {
        if (this.state == null || this.hasAspectRatioDialog) {
            return;
        }
        this.hasAspectRatioDialog = true;
        String[] strArr = new String[8];
        final Integer[][] numArr = {new Integer[]{3, 2}, new Integer[]{5, 3}, new Integer[]{4, 3}, new Integer[]{5, 4}, new Integer[]{7, 5}, new Integer[]{16, 9}};
        strArr[0] = LocaleController.getString("CropOriginal", R.string.CropOriginal);
        strArr[1] = LocaleController.getString("CropSquare", R.string.CropSquare);
        int i = 2;
        for (int i2 = 0; i2 < 6; i2++) {
            Integer[] numArr2 = numArr[i2];
            if (this.areaView.getAspectRatio() > 1.0f) {
                strArr[i] = String.format("%d:%d", numArr2[0], numArr2[1]);
            } else {
                strArr[i] = String.format("%d:%d", numArr2[1], numArr2[0]);
            }
            i++;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.Crop.-$$Lambda$CropView$GkgDiylsorywjkmnGgaB-N7ZmsE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.lambda$showAspectRatioDialog$2$CropView(numArr, dialogInterface, i3);
            }
        }).create();
        alertDialogCreate.setCanceledOnTouchOutside(true);
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Components.Crop.-$$Lambda$CropView$wW3XvoHyz9pje0YEo6gvTb7Tiog
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$showAspectRatioDialog$3$CropView(dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAspectRatioDialog$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAspectRatioDialog$2$CropView(Integer[][] numArr, DialogInterface dialogInterface, int i) {
        this.hasAspectRatioDialog = false;
        if (i == 0) {
            setLockedAspectRatio((this.state.getBaseRotation() % 180.0f != 0.0f ? this.state.getHeight() : this.state.getWidth()) / (this.state.getBaseRotation() % 180.0f != 0.0f ? this.state.getWidth() : this.state.getHeight()));
            return;
        }
        if (i == 1) {
            setLockedAspectRatio(1.0f);
            return;
        }
        Integer[] numArr2 = numArr[i - 2];
        if (this.areaView.getAspectRatio() > 1.0f) {
            setLockedAspectRatio(numArr2[0].intValue() / numArr2[1].intValue());
        } else {
            setLockedAspectRatio(numArr2[1].intValue() / numArr2[0].intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAspectRatioDialog$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAspectRatioDialog$3$CropView(DialogInterface dialogInterface) {
        this.hasAspectRatioDialog = false;
    }

    public void updateLayout() {
        CropState cropState;
        float cropWidth = this.areaView.getCropWidth();
        if (cropWidth == 0.0f || (cropState = this.state) == null) {
            return;
        }
        this.areaView.calculateRect(this.initialAreaRect, cropState.getWidth() / this.state.getHeight());
        CropAreaView cropAreaView = this.areaView;
        cropAreaView.setActualRect(cropAreaView.getAspectRatio());
        this.areaView.getCropRect(this.previousAreaRect);
        this.state.scale(this.areaView.getCropWidth() / cropWidth, 0.0f, 0.0f);
        updateMatrix();
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

    public RectF getActualRect() {
        this.areaView.getCropRect(this.cropRect);
        return this.cropRect;
    }
}
