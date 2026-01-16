package ir.appp.rghapp.components.sshCrop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import ir.medu.shad.R;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHCropRotationWheel extends FrameLayout {
    protected float rotation;
    private SSHRotationWheelListener rotationListener;
    private final SSHPhotoEditAdjustDisplayView sshPhotoEditAdjustDisplayView;
    private final SSHPhotoEditAdjustSpinnerView sshPhotoEditAdjustSpinnerView;

    public interface SSHRotationWheelListener {
        void onChange(float f);

        void onEnd(float f);

        void onStart();
    }

    public SSHCropRotationWheel(Context context) {
        super(context);
        SSHPhotoEditAdjustDisplayView sSHPhotoEditAdjustDisplayView = new SSHPhotoEditAdjustDisplayView(context, R.drawable.ic_adjust_rotation, R.drawable.ic_close_circle, 0.0f);
        this.sshPhotoEditAdjustDisplayView = sSHPhotoEditAdjustDisplayView;
        sSHPhotoEditAdjustDisplayView.setOnResetListener(new SSHPhotoEditAdjustDisplayView.OnResetListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHPhotoEditAdjustDisplayView.OnResetListener
            public final void onResetClicked() {
                this.f$0.lambda$new$0();
            }
        });
        addView(sSHPhotoEditAdjustDisplayView, LayoutHelper.createFrame(-1, -1.0f, 49, 0.0f, 0.0f, 0.0f, 44.0f));
        SSHPhotoEditAdjustSpinnerView sSHPhotoEditAdjustSpinnerView = new SSHPhotoEditAdjustSpinnerView(context);
        this.sshPhotoEditAdjustSpinnerView = sSHPhotoEditAdjustSpinnerView;
        sSHPhotoEditAdjustSpinnerView.setOnRotationWheelListener(new SSHRotationWheelListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.1
            @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
            public void onStart() {
                if (SSHCropRotationWheel.this.rotationListener != null) {
                    SSHCropRotationWheel.this.rotationListener.onStart();
                }
            }

            @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
            public void onChange(float f) {
                SSHCropRotationWheel.this.sshPhotoEditAdjustDisplayView.setRotationProgress(f);
                if (SSHCropRotationWheel.this.rotationListener != null) {
                    SSHCropRotationWheel.this.rotationListener.onChange(f);
                }
            }

            @Override // ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHRotationWheelListener
            public void onEnd(float f) {
                if (SSHCropRotationWheel.this.rotationListener != null) {
                    SSHCropRotationWheel.this.rotationListener.onEnd(f);
                }
            }
        });
        addView(sSHPhotoEditAdjustSpinnerView, LayoutHelper.createFrame(-1, -1.0f, 83, 0.0f, 0.0f, 0.0f, 44.0f));
    }

    /* renamed from: reset, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0() {
        this.sshPhotoEditAdjustSpinnerView.resetRotation();
        setRotation(0.0f, false);
    }

    public void setListener(SSHRotationWheelListener sSHRotationWheelListener) {
        this.rotationListener = sSHRotationWheelListener;
    }

    public void setRotation(float f, boolean z) {
        this.rotation = f;
        this.sshPhotoEditAdjustSpinnerView.setRotationProgress(f);
        this.sshPhotoEditAdjustDisplayView.setRotationProgress(f);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    static class SSHPhotoEditAdjustDisplayView extends View {
        private float animationValue;
        private Runnable cancelAnimation;
        private final Drawable icon;
        private AnimatorSet imageMoveAnimation;
        private boolean isExpanded;
        private OnResetListener listener;
        private final Paint paint;
        private final Paint paint1;
        private final Drawable resetIcon;
        private float rotationProgress;
        private final TextPaint textPaint;

        public interface OnResetListener {
            void onResetClicked();
        }

        public SSHPhotoEditAdjustDisplayView(Context context, int i, int i2, float f) {
            super(context);
            this.isExpanded = false;
            this.icon = ResourcesCompat.getDrawable(context.getResources(), i, null);
            this.resetIcon = ResourcesCompat.getDrawable(context.getResources(), i2, null);
            Paint paint = new Paint(1);
            this.paint = paint;
            int i3 = Theme.key_rubinoGrayColor;
            paint.setColor(Theme.getColor(i3));
            Paint paint2 = new Paint(1);
            this.paint1 = paint2;
            paint2.setStrokeWidth(AndroidUtilities.dp(1.0f));
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(Theme.getColor(i3));
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(12.0f));
            setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel$SSHPhotoEditAdjustDisplayView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            OnResetListener onResetListener;
            if (this.rotationProgress == 0.0f || (onResetListener = this.listener) == null) {
                return;
            }
            onResetListener.onResetClicked();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) / 3, 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) / 2, 1073741824));
        }

        private void showAnimation(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.imageMoveAnimation = animatorSet;
            Animator[] animatorArr = new Animator[1];
            float[] fArr = new float[2];
            fArr[0] = z ? 0.0f : 1.0f;
            fArr[1] = z ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(this, "animationValue", fArr);
            animatorSet.playTogether(animatorArr);
            this.imageMoveAnimation.setDuration(250L);
            this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel.SSHPhotoEditAdjustDisplayView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SSHPhotoEditAdjustDisplayView.this.imageMoveAnimation = null;
                    SSHPhotoEditAdjustDisplayView.this.cancelAnimation = null;
                    SSHPhotoEditAdjustDisplayView.this.invalidate();
                }
            });
            this.imageMoveAnimation.start();
        }

        @Keep
        public float getAnimationValue() {
            return this.animationValue;
        }

        @Keep
        public void setAnimationValue(float f) {
            this.animationValue = f;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int iDp = AndroidUtilities.dp(20.0f);
            int iDp2 = AndroidUtilities.dp(16.0f);
            int iDp3 = AndroidUtilities.dp(14.0f);
            int iDp4 = AndroidUtilities.dp(10.0f);
            int iDp5 = AndroidUtilities.dp(4.0f);
            int measuredWidth = getMeasuredWidth() / 2;
            int measuredHeight = getMeasuredHeight() / 2;
            int color = Theme.getColor(isEnabled() ? Theme.key_rubinoBlackColor : Theme.key_rubinoGrayColor);
            this.paint.setColor(color);
            this.paint1.setColor(color);
            this.textPaint.setColor(color);
            this.icon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            this.resetIcon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            String str = String.format(Locale.US, "%.2f°", Float.valueOf(this.rotationProgress));
            Rect rect = new Rect();
            this.textPaint.getTextBounds(str, 0, str.length(), rect);
            int iWidth = rect.width();
            float fHeight = rect.height();
            int iDp6 = iWidth + iDp + iDp + AndroidUtilities.dp(8.0f);
            if (this.imageMoveAnimation == null) {
                if (this.rotationProgress == 0.0f && this.cancelAnimation == null && !this.isExpanded) {
                    this.icon.setBounds(measuredWidth - iDp2, measuredHeight - iDp2, measuredWidth + iDp2, measuredHeight + iDp2);
                    this.icon.draw(canvas);
                    return;
                }
                this.paint.setAlpha(255);
                this.paint1.setAlpha(255);
                this.textPaint.setAlpha(255);
                this.resetIcon.setAlpha(255);
                int i = measuredWidth - iDp5;
                int i2 = iWidth / 2;
                int i3 = measuredHeight - iDp4;
                int i4 = iDp4 + measuredHeight;
                this.icon.setBounds((i - iDp) - i2, i3, i - i2, i4);
                this.icon.draw(canvas);
                int i5 = measuredWidth + iDp5;
                this.resetIcon.setBounds(i5 + i2, i3, iDp + i5 + i2, i4);
                this.resetIcon.draw(canvas);
                canvas.drawText(str, measuredWidth - (iWidth / 2.0f), measuredHeight + (fHeight / 2.0f), this.textPaint);
                int i6 = iDp6 / 2;
                float f = iDp2;
                canvas.drawRoundRect(new RectF(i - i6, measuredHeight - iDp3, i5 + i6, measuredHeight + iDp3), f, f, this.paint1);
                return;
            }
            if (!this.isExpanded) {
                this.paint.setAlpha((int) (this.animationValue * 255.0f));
                this.paint1.setAlpha((int) (this.animationValue * 255.0f));
            } else {
                this.paint.setAlpha(255);
            }
            this.resetIcon.setAlpha((int) (this.animationValue * 255.0f));
            this.textPaint.setAlpha((int) (this.animationValue * 255.0f));
            float f2 = this.animationValue;
            float f3 = (iDp6 / 2.0f) * f2;
            float f4 = iDp5;
            float f5 = iWidth / 2.0f;
            float f6 = f4 + f5;
            float f7 = f6 * f2;
            float f8 = iDp;
            float f9 = f5 + f8 + f4;
            float f10 = iDp2;
            float f11 = ((f9 - f10) * f2) + f10;
            float f12 = (-(f2 * (f6 + f10))) + f10;
            float f13 = ((1.0f - f2) * (iDp2 - iDp4)) + iDp4;
            float f14 = measuredWidth;
            float f15 = measuredHeight;
            this.icon.setBounds((int) (f14 - f11), (int) (f15 - f13), (int) (f12 + f14), (int) (f15 + f13));
            this.icon.draw(canvas);
            float f16 = f14 + f7;
            this.resetIcon.setBounds((int) f16, measuredHeight - iDp4, (int) (f16 + f8), iDp4 + measuredHeight);
            this.resetIcon.draw(canvas);
            canvas.drawText(str, f14 - f5, f15 + (fHeight / 2.0f), this.textPaint);
            canvas.drawRoundRect(new RectF((measuredWidth - iDp5) - f3, measuredHeight - iDp3, measuredWidth + iDp5 + f3, measuredHeight + iDp3), f10, f10, this.paint1);
        }

        public void setRotationProgress(float f) {
            if (this.rotationProgress == 0.0f && f != 0.0f && this.cancelAnimation == null && this.imageMoveAnimation == null && !this.isExpanded) {
                this.rotationProgress = f;
                showAnimation(true);
                this.isExpanded = true;
                return;
            }
            if (f == 0.0f && this.cancelAnimation == null && this.imageMoveAnimation == null && this.isExpanded) {
                Runnable runnable = new Runnable() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropRotationWheel$SSHPhotoEditAdjustDisplayView$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setRotationProgress$1();
                    }
                };
                this.cancelAnimation = runnable;
                AndroidUtilities.runOnUIThread(runnable, 1000L);
                this.rotationProgress = f;
                invalidate();
                return;
            }
            Runnable runnable2 = this.cancelAnimation;
            if (runnable2 != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable2);
                this.cancelAnimation = null;
            }
            this.rotationProgress = f;
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setRotationProgress$1() {
            this.isExpanded = false;
            showAnimation(false);
        }

        public void setOnResetListener(OnResetListener onResetListener) {
            this.listener = onResetListener;
        }
    }

    class SSHPhotoEditAdjustSpinnerView extends View {
        private int bottom;
        private final int center;
        private final int gapWidth;
        private SSHRotationWheelListener listener;
        private final Paint paint;
        private final Paint paint1;
        private final Paint paint2;
        private final float start;
        private float startX;
        private int swipeX;
        private int top;

        public SSHPhotoEditAdjustSpinnerView(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.paint = paint;
            int i = Theme.key_rubinoGrayColor;
            paint.setColor(Theme.getColor(i));
            Paint paint2 = new Paint(1);
            this.paint1 = paint2;
            paint2.setColor(Theme.getColor(i));
            this.paint2 = new Paint(1);
            this.center = AndroidUtilities.displayMetrics.widthPixels / 2;
            this.gapWidth = AndroidUtilities.dp(20.0f);
            this.start = r3 - (r4 * 25);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) / 2, 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.top = getMeasuredHeight() / 4;
            int measuredHeight = getMeasuredHeight();
            int i = this.top;
            this.bottom = (measuredHeight - i) - (i / 4);
            float f = this.swipeX + this.start;
            canvas.drawCircle(getMeasuredWidth() / 2.0f, this.top / 2.0f, AndroidUtilities.dp(2.5f), this.paint1);
            for (int i2 = 0; i2 <= 50; i2++) {
                if (f < 0.0f) {
                    f += this.gapWidth;
                } else {
                    int i3 = this.center;
                    this.paint.setAlpha((int) ((((f > ((float) i3) ? i3 - (f - i3) : f) * 235.0f) / i3) + 20.0f));
                    int i4 = this.top;
                    canvas.drawRect(f - 1.0f, i4 + (i4 / 4.0f), f + 1.0f, this.bottom, this.paint);
                    f += this.gapWidth;
                    if (f > getMeasuredWidth()) {
                        break;
                    }
                }
            }
            this.paint2.setShader(new RadialGradient(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredHeight() * 3, 0, 451800557, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint2);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.startX = motionEvent.getX();
                SSHRotationWheelListener sSHRotationWheelListener = this.listener;
                if (sSHRotationWheelListener != null) {
                    sSHRotationWheelListener.onStart();
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                SSHRotationWheelListener sSHRotationWheelListener2 = this.listener;
                if (sSHRotationWheelListener2 != null) {
                    sSHRotationWheelListener2.onEnd(SSHCropRotationWheel.this.rotation);
                }
            } else if (motionEvent.getAction() == 2) {
                int x = (int) (this.swipeX + (motionEvent.getX() - this.startX));
                this.swipeX = x;
                float f = this.start;
                float f2 = x + f;
                int i = this.center;
                if (f2 > i) {
                    this.swipeX = (int) (i - f);
                }
                int i2 = this.swipeX;
                int i3 = this.gapWidth;
                if (i2 < (-(i3 * 25))) {
                    this.swipeX = -(i3 * 25);
                }
                this.startX = motionEvent.getX();
                float f3 = -(this.swipeX / this.gapWidth);
                SSHCropRotationWheel.this.rotation = f3;
                SSHRotationWheelListener sSHRotationWheelListener3 = this.listener;
                if (sSHRotationWheelListener3 != null) {
                    sSHRotationWheelListener3.onChange(f3);
                }
                invalidate();
            }
            return true;
        }

        public void resetRotation() {
            this.swipeX = 0;
            SSHCropRotationWheel.this.rotation = 0.0f;
            SSHRotationWheelListener sSHRotationWheelListener = this.listener;
            if (sSHRotationWheelListener != null) {
                sSHRotationWheelListener.onChange(0.0f);
            }
            invalidate();
        }

        public void setRotationProgress(float f) {
            this.swipeX = (int) (-(f * this.gapWidth));
        }

        public void setOnRotationWheelListener(SSHRotationWheelListener sSHRotationWheelListener) {
            this.listener = sSHRotationWheelListener;
        }
    }
}
