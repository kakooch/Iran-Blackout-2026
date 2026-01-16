package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.ChatActivityEnterView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.MessageEnterTransitionContainer;

/* loaded from: classes3.dex */
public class VoiceMessageEnterTransition implements MessageEnterTransitionContainer.Transition {
    private final ValueAnimator animator;
    final Paint circlePaint = new Paint(1);
    MessageEnterTransitionContainer container;
    float fromRadius;
    private final Matrix gradientMatrix;
    private final Paint gradientPaint;
    private final LinearGradient gradientShader;
    float lastToCx;
    float lastToCy;
    private final RecyclerListView listView;
    private final int messageId;
    private final ChatMessageCell messageView;
    float progress;
    private final ChatActivityEnterView.RecordCircle recordCircle;
    private final Theme.ResourcesProvider resourcesProvider;

    public VoiceMessageEnterTransition(final ChatMessageCell messageView, ChatActivityEnterView chatActivityEnterView, RecyclerListView listView, final MessageEnterTransitionContainer container, Theme.ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.messageView = messageView;
        this.container = container;
        this.listView = listView;
        this.fromRadius = chatActivityEnterView.getRecordCicle().drawingCircleRadius;
        messageView.setEnterTransitionInProgress(true);
        ChatActivityEnterView.RecordCircle recordCicle = chatActivityEnterView.getRecordCicle();
        this.recordCircle = recordCicle;
        recordCicle.voiceEnterTransitionInProgress = true;
        recordCicle.skipDraw = true;
        this.gradientMatrix = new Matrix();
        Paint paint = new Paint(1);
        this.gradientPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearGradient linearGradient = new LinearGradient(0.0f, AndroidUtilities.dp(12.0f), 0.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        paint.setShader(linearGradient);
        this.messageId = messageView.getMessageObject().stableId;
        container.addTransition(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$VoiceMessageEnterTransition$7DKX3NC1HkcYHquiUkbPwaNu4bs
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0$VoiceMessageEnterTransition(container, valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.setDuration(220L);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.VoiceMessageEnterTransition.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                messageView.setEnterTransitionInProgress(false);
                container.removeTransition(VoiceMessageEnterTransition.this);
                VoiceMessageEnterTransition.this.recordCircle.skipDraw = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$VoiceMessageEnterTransition(MessageEnterTransitionContainer messageEnterTransitionContainer, ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        messageEnterTransitionContainer.invalidate();
    }

    public void start() {
        this.animator.start();
    }

    @Override // ir.eitaa.ui.MessageEnterTransitionContainer.Transition
    public void onDraw(Canvas canvas) {
        float fCenterY;
        float fCenterX;
        float f;
        float f2;
        int measuredHeight;
        float f3 = this.progress;
        float f4 = f3 > 0.6f ? 1.0f : f3 / 0.6f;
        ChatActivityEnterView.RecordCircle recordCircle = this.recordCircle;
        float x = (recordCircle.drawingCx + recordCircle.getX()) - this.container.getX();
        ChatActivityEnterView.RecordCircle recordCircle2 = this.recordCircle;
        float y = (recordCircle2.drawingCy + recordCircle2.getY()) - this.container.getY();
        if (this.messageView.getMessageObject().stableId != this.messageId) {
            fCenterX = this.lastToCx;
            fCenterY = this.lastToCy;
        } else {
            fCenterY = ((this.messageView.getRadialProgress().getProgressRect().centerY() + this.messageView.getY()) + this.listView.getY()) - this.container.getY();
            fCenterX = ((this.messageView.getRadialProgress().getProgressRect().centerX() + this.messageView.getX()) + this.listView.getX()) - this.container.getX();
        }
        this.lastToCx = fCenterX;
        this.lastToCy = fCenterY;
        float interpolation = CubicBezierInterpolator.DEFAULT.getInterpolation(f3);
        float interpolation2 = CubicBezierInterpolator.EASE_OUT_QUINT.getInterpolation(f3);
        float f5 = ((1.0f - interpolation2) * x) + (fCenterX * interpolation2);
        float f6 = 1.0f - interpolation;
        float f7 = (y * f6) + (fCenterY * interpolation);
        float fHeight = this.messageView.getRadialProgress().getProgressRect().height() / 2.0f;
        float f8 = (this.fromRadius * f6) + (fHeight * interpolation);
        float y2 = (this.listView.getY() - this.container.getY()) + this.listView.getMeasuredHeight();
        if (this.container.getMeasuredHeight() > 0) {
            f = f8;
            f2 = f7;
            canvas.saveLayerAlpha(0.0f, this.container.getMeasuredHeight() - AndroidUtilities.dp(400.0f), this.container.getMeasuredWidth(), this.container.getMeasuredHeight(), 255, 31);
            measuredHeight = (int) ((this.container.getMeasuredHeight() * f6) + (y2 * interpolation));
        } else {
            f = f8;
            f2 = f7;
            canvas.save();
            measuredHeight = 0;
        }
        this.circlePaint.setColor(ColorUtils.blendARGB(getThemedColor("chat_messagePanelVoiceBackground"), getThemedColor(this.messageView.getRadialProgress().getCircleColorKey()), interpolation));
        float f9 = f2;
        this.recordCircle.drawWaves(canvas, f5, f9, 1.0f - f4);
        float f10 = f;
        canvas.drawCircle(f5, f9, f10, this.circlePaint);
        canvas.save();
        float f11 = f10 / fHeight;
        canvas.scale(f11, f11, f5, f9);
        canvas.translate(f5 - this.messageView.getRadialProgress().getProgressRect().centerX(), f9 - this.messageView.getRadialProgress().getProgressRect().centerY());
        this.messageView.getRadialProgress().setOverrideAlpha(interpolation);
        this.messageView.getRadialProgress().setDrawBackground(false);
        this.messageView.getRadialProgress().draw(canvas);
        this.messageView.getRadialProgress().setDrawBackground(true);
        this.messageView.getRadialProgress().setOverrideAlpha(1.0f);
        canvas.restore();
        if (this.container.getMeasuredHeight() > 0) {
            float f12 = measuredHeight;
            this.gradientMatrix.setTranslate(0.0f, f12);
            this.gradientShader.setLocalMatrix(this.gradientMatrix);
            canvas.drawRect(0.0f, f12, this.container.getMeasuredWidth(), this.container.getMeasuredHeight(), this.gradientPaint);
        }
        canvas.restore();
        this.recordCircle.drawIcon(canvas, (int) x, (int) y, 1.0f - f3);
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
