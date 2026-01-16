package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.RubinoCameraTypeItem;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class UI_rubinoCameraButtonCell {
    public View clickableArea;
    Context context;
    private float currentCircleLength;
    private float currentProgressTime;
    public CameraButtonCellFrameLayout frameLayout;
    ImageView imageViewCenter;
    private float initLength;
    private LinearInterpolator interpolator;
    private AccelerateInterpolator interpolatorSizeChange;
    private float maxArcLength;
    private Paint progressPaint;
    private float sizeChangeAmountDp;
    private float startAngle;
    private long startTime;
    private float targetLength;
    public View view;
    private RectF circleRect = new RectF();
    private float distanceArcLength = 360.0f;
    private boolean risingCircleLength = false;
    private boolean animating = false;
    private float arcTime = 5000.0f;
    private float changeSizeTime = 200.0f;
    private float paddingDp = 12.5f;
    int[] colors1 = {-3722, -42909, -49023};
    float[] positions1 = {0.0f, 0.3f, 1.0f};

    public View createView(Activity activity) {
        this.context = activity;
        CameraButtonCellFrameLayout cameraButtonCellFrameLayout = new CameraButtonCellFrameLayout(activity);
        this.frameLayout = cameraButtonCellFrameLayout;
        this.view = cameraButtonCellFrameLayout;
        ImageView imageView = new ImageView(activity);
        this.imageViewCenter = imageView;
        CameraButtonCellFrameLayout cameraButtonCellFrameLayout2 = this.frameLayout;
        float f = this.paddingDp;
        cameraButtonCellFrameLayout2.addView(imageView, LayoutHelper.createFrame(-1, -1.0f, 17, f * 2.0f, f * 2.0f, f * 2.0f, f * 2.0f));
        FrameLayout frameLayout = new FrameLayout(activity);
        this.clickableArea = frameLayout;
        CameraButtonCellFrameLayout cameraButtonCellFrameLayout3 = this.frameLayout;
        float f2 = this.paddingDp;
        cameraButtonCellFrameLayout3.addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f, 17, f2, f2, f2, f2));
        this.view.setTag(this);
        return this.view;
    }

    public void setProgressWithAnimation(int i, int i2) {
        this.frameLayout.setProgressWithAnimation(i, i2);
    }

    public void setIconByCameraTypeAndState(RubinoCameraTypeItem.RubinoCameraTypeEnum rubinoCameraTypeEnum, boolean z) {
        if (rubinoCameraTypeEnum == RubinoCameraTypeItem.RubinoCameraTypeEnum.handsFree) {
            this.imageViewCenter.setVisibility(0);
            if (z) {
                this.imageViewCenter.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_video_stop_icon));
                return;
            } else {
                this.imageViewCenter.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_video_shutter_icon));
                return;
            }
        }
        if (rubinoCameraTypeEnum == RubinoCameraTypeItem.RubinoCameraTypeEnum.live) {
            this.imageViewCenter.setVisibility(0);
            Drawable drawableMutate = this.context.getResources().getDrawable(R.drawable.rubino_capture_live).mutate();
            drawableMutate.setBounds(0, 0, AndroidUtilities.dp(100.0f), AndroidUtilities.dp(100.0f));
            this.imageViewCenter.setImageDrawable(drawableMutate);
            return;
        }
        this.imageViewCenter.setVisibility(8);
    }

    public void resetProgress(boolean z) {
        if (z) {
            this.frameLayout.setProgressWithAnimation(0, (int) this.changeSizeTime);
        } else {
            this.frameLayout.setProgress(0);
        }
    }

    private class CameraButtonCellFrameLayout extends FrameLayout {
        Paint paint;
        Paint paint2;

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }

        public CameraButtonCellFrameLayout(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.paint2 = new Paint(1);
            setWillNotDraw(false);
            this.paint.setColor(-1);
            this.paint2.setColor(-1);
            this.paint2.setStyle(Paint.Style.STROKE);
            this.paint2.setStrokeWidth(AndroidUtilities.dp(4.0f));
            UI_rubinoCameraButtonCell.this.interpolator = new LinearInterpolator();
            UI_rubinoCameraButtonCell.this.interpolatorSizeChange = new AccelerateInterpolator();
            UI_rubinoCameraButtonCell.this.progressPaint = new Paint(1);
            UI_rubinoCameraButtonCell.this.progressPaint.setStyle(Paint.Style.STROKE);
            UI_rubinoCameraButtonCell.this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
            UI_rubinoCameraButtonCell.this.progressPaint.setStrokeWidth(AndroidUtilities.dp(4.0f));
            UI_rubinoCameraButtonCell.this.progressPaint.setColor(-1);
            UI_rubinoCameraButtonCell.this.currentCircleLength = 0.0f;
            UI_rubinoCameraButtonCell.this.startAngle = 0.0f;
            UI_rubinoCameraButtonCell.this.maxArcLength = 180.0f;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                float measuredWidth = getMeasuredWidth() / 2;
                float measuredHeight = getMeasuredHeight() / 2;
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell = UI_rubinoCameraButtonCell.this;
                SweepGradient sweepGradient = new SweepGradient(measuredWidth, measuredHeight, uI_rubinoCameraButtonCell.colors1, uI_rubinoCameraButtonCell.positions1);
                Matrix matrix = new Matrix();
                matrix.setRotate(-95.0f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                sweepGradient.setLocalMatrix(matrix);
                UI_rubinoCameraButtonCell.this.progressPaint.setShader(sweepGradient);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp((UI_rubinoCameraButtonCell.this.paddingDp + 4.0f) + (UI_rubinoCameraButtonCell.this.sizeChangeAmountDp / 2.0f)), this.paint);
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(UI_rubinoCameraButtonCell.this.paddingDp - UI_rubinoCameraButtonCell.this.sizeChangeAmountDp), this.paint2);
            UI_rubinoCameraButtonCell.this.circleRect.set(AndroidUtilities.dp(UI_rubinoCameraButtonCell.this.paddingDp - UI_rubinoCameraButtonCell.this.sizeChangeAmountDp), AndroidUtilities.dp(UI_rubinoCameraButtonCell.this.paddingDp - UI_rubinoCameraButtonCell.this.sizeChangeAmountDp), getMeasuredHeight() - AndroidUtilities.dp(UI_rubinoCameraButtonCell.this.paddingDp - UI_rubinoCameraButtonCell.this.sizeChangeAmountDp), getMeasuredHeight() - AndroidUtilities.dp(UI_rubinoCameraButtonCell.this.paddingDp - UI_rubinoCameraButtonCell.this.sizeChangeAmountDp));
            canvas.save();
            canvas.rotate(UI_rubinoCameraButtonCell.this.startAngle, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
            canvas.drawArc(UI_rubinoCameraButtonCell.this.circleRect, UI_rubinoCameraButtonCell.this.startAngle > 0.0f ? -90.0f : (-90.0f) - UI_rubinoCameraButtonCell.this.startAngle, Math.min(UI_rubinoCameraButtonCell.this.currentCircleLength, UI_rubinoCameraButtonCell.this.maxArcLength), false, UI_rubinoCameraButtonCell.this.progressPaint);
            canvas.restore();
            if (UI_rubinoCameraButtonCell.this.animating) {
                updateAnimation();
            }
        }

        private void startProgressAnimation(float f) {
            UI_rubinoCameraButtonCell.this.startTime = System.currentTimeMillis();
            UI_rubinoCameraButtonCell.this.arcTime = f;
            updateAnimation();
        }

        public void setProgress(int i) {
            UI_rubinoCameraButtonCell.this.initLength = 0.0f;
            UI_rubinoCameraButtonCell.this.distanceArcLength = 360.0f;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            float f = (i * 360) / 100;
            UI_rubinoCameraButtonCell.this.currentCircleLength = f;
            UI_rubinoCameraButtonCell.this.targetLength = f;
            UI_rubinoCameraButtonCell.this.animating = false;
            UI_rubinoCameraButtonCell.this.sizeChangeAmountDp = 0.0f;
            invalidate();
        }

        public void setProgressWithAnimation(int i, int i2) {
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            try {
                UI_rubinoCameraButtonCell.this.targetLength = (i * 360) / 100;
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell.initLength = uI_rubinoCameraButtonCell.currentCircleLength;
                if (UI_rubinoCameraButtonCell.this.targetLength > UI_rubinoCameraButtonCell.this.currentCircleLength) {
                    UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell2 = UI_rubinoCameraButtonCell.this;
                    uI_rubinoCameraButtonCell2.distanceArcLength = uI_rubinoCameraButtonCell2.targetLength - UI_rubinoCameraButtonCell.this.currentCircleLength;
                    UI_rubinoCameraButtonCell.this.risingCircleLength = true;
                } else {
                    UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell3 = UI_rubinoCameraButtonCell.this;
                    uI_rubinoCameraButtonCell3.distanceArcLength = uI_rubinoCameraButtonCell3.currentCircleLength - UI_rubinoCameraButtonCell.this.targetLength;
                    UI_rubinoCameraButtonCell.this.risingCircleLength = false;
                }
                UI_rubinoCameraButtonCell.this.animating = true;
                startProgressAnimation(i2);
            } catch (Exception e) {
                MyLog.handleException(e);
            }
        }

        private void updateAnimation() {
            if (UI_rubinoCameraButtonCell.this.distanceArcLength < 0.0f) {
                UI_rubinoCameraButtonCell.this.distanceArcLength = 0.0f;
            }
            if (UI_rubinoCameraButtonCell.this.distanceArcLength > 1440.0f) {
                UI_rubinoCameraButtonCell.this.distanceArcLength = 1440.0f;
            }
            UI_rubinoCameraButtonCell.this.currentProgressTime = System.currentTimeMillis() - UI_rubinoCameraButtonCell.this.startTime;
            if (UI_rubinoCameraButtonCell.this.risingCircleLength) {
                if (UI_rubinoCameraButtonCell.this.currentProgressTime >= UI_rubinoCameraButtonCell.this.arcTime * 4.0f) {
                    UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell = UI_rubinoCameraButtonCell.this;
                    uI_rubinoCameraButtonCell.currentProgressTime = uI_rubinoCameraButtonCell.arcTime * 4.0f;
                }
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell2 = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell2.currentCircleLength = uI_rubinoCameraButtonCell2.initLength + (UI_rubinoCameraButtonCell.this.distanceArcLength * UI_rubinoCameraButtonCell.this.interpolator.getInterpolation(UI_rubinoCameraButtonCell.this.currentProgressTime / UI_rubinoCameraButtonCell.this.arcTime));
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell3 = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell3.sizeChangeAmountDp = (uI_rubinoCameraButtonCell3.paddingDp - 4.0f) * UI_rubinoCameraButtonCell.this.interpolatorSizeChange.getInterpolation(Math.min(1.0f, UI_rubinoCameraButtonCell.this.currentProgressTime / UI_rubinoCameraButtonCell.this.changeSizeTime));
            } else {
                if (UI_rubinoCameraButtonCell.this.currentProgressTime >= UI_rubinoCameraButtonCell.this.arcTime) {
                    UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell4 = UI_rubinoCameraButtonCell.this;
                    uI_rubinoCameraButtonCell4.currentProgressTime = uI_rubinoCameraButtonCell4.arcTime;
                }
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell5 = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell5.currentCircleLength = uI_rubinoCameraButtonCell5.initLength - (UI_rubinoCameraButtonCell.this.distanceArcLength * UI_rubinoCameraButtonCell.this.interpolator.getInterpolation(UI_rubinoCameraButtonCell.this.currentProgressTime / UI_rubinoCameraButtonCell.this.arcTime));
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell6 = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell6.sizeChangeAmountDp = (uI_rubinoCameraButtonCell6.paddingDp - 4.0f) - ((UI_rubinoCameraButtonCell.this.paddingDp - 4.0f) * UI_rubinoCameraButtonCell.this.interpolatorSizeChange.getInterpolation(Math.min(1.0f, UI_rubinoCameraButtonCell.this.currentProgressTime / UI_rubinoCameraButtonCell.this.changeSizeTime)));
            }
            UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell7 = UI_rubinoCameraButtonCell.this;
            uI_rubinoCameraButtonCell7.startAngle = uI_rubinoCameraButtonCell7.currentCircleLength - UI_rubinoCameraButtonCell.this.maxArcLength;
            if (UI_rubinoCameraButtonCell.this.currentProgressTime == UI_rubinoCameraButtonCell.this.arcTime * 4.0f) {
                UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell8 = UI_rubinoCameraButtonCell.this;
                uI_rubinoCameraButtonCell8.currentCircleLength = uI_rubinoCameraButtonCell8.targetLength;
                UI_rubinoCameraButtonCell.this.risingCircleLength = false;
                UI_rubinoCameraButtonCell.this.animating = false;
                UI_rubinoCameraButtonCell.this.currentProgressTime = 0.0f;
            }
            invalidate();
        }
    }
}
