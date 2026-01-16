package org.rbmain.ui;

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
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.Components.ChatActivityEnterView;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.MessageEnterTransitionContainer;

/* loaded from: classes4.dex */
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

    public VoiceMessageEnterTransition(final ChatMessageCell chatMessageCell, ChatActivityEnterView chatActivityEnterView, RecyclerListView recyclerListView, final MessageEnterTransitionContainer messageEnterTransitionContainer, Theme.ResourcesProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.messageView = chatMessageCell;
        this.container = messageEnterTransitionContainer;
        this.listView = recyclerListView;
        chatMessageCell.setEnterTransitionInProgress(true);
        ChatActivityEnterView.RecordCircle recordCircle = chatActivityEnterView.getRecordCircle();
        this.recordCircle = recordCircle;
        if (recordCircle != null) {
            this.fromRadius = recordCircle.drawingCircleRadius;
            recordCircle.voiceEnterTransitionInProgress = true;
            recordCircle.skipDraw = true;
        }
        this.gradientMatrix = new Matrix();
        Paint paint = new Paint(1);
        this.gradientPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearGradient linearGradient = new LinearGradient(0.0f, AndroidUtilities.dp(12.0f), 0.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        paint.setShader(linearGradient);
        this.messageId = chatMessageCell.getMessageObject().stableId;
        messageEnterTransitionContainer.addTransition(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.VoiceMessageEnterTransition$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0(messageEnterTransitionContainer, valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.setDuration(220L);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.VoiceMessageEnterTransition.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                chatMessageCell.setEnterTransitionInProgress(false);
                messageEnterTransitionContainer.removeTransition(VoiceMessageEnterTransition.this);
                if (VoiceMessageEnterTransition.this.recordCircle != null) {
                    VoiceMessageEnterTransition.this.recordCircle.skipDraw = false;
                }
            }
        });
        if (chatMessageCell.getSeekBarWaveform() != null) {
            chatMessageCell.getSeekBarWaveform().setSent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(MessageEnterTransitionContainer messageEnterTransitionContainer, ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        messageEnterTransitionContainer.invalidate();
    }

    public void start() {
        this.animator.start();
    }

    @Override // org.rbmain.ui.MessageEnterTransitionContainer.Transition
    public void onDraw(Canvas canvas) {
        float fCenterY;
        float fCenterX;
        float f = this.progress;
        float f2 = f > 0.6f ? 1.0f : f / 0.6f;
        ChatActivityEnterView.RecordCircle recordCircle = this.recordCircle;
        float x = recordCircle == null ? 0.0f : (recordCircle.drawingCx + recordCircle.getX()) - this.container.getX();
        ChatActivityEnterView.RecordCircle recordCircle2 = this.recordCircle;
        float y = recordCircle2 == null ? 0.0f : (recordCircle2.drawingCy + recordCircle2.getY()) - this.container.getY();
        if (this.messageView.getMessageObject().stableId != this.messageId) {
            fCenterX = this.lastToCx;
            fCenterY = this.lastToCy;
        } else {
            fCenterY = ((this.messageView.getRadialProgress().getProgressRect().centerY() + this.messageView.getY()) + this.listView.getY()) - this.container.getY();
            fCenterX = ((this.messageView.getRadialProgress().getProgressRect().centerX() + this.messageView.getX()) + this.listView.getX()) - this.container.getX();
        }
        this.lastToCx = fCenterX;
        this.lastToCy = fCenterY;
        float interpolation = CubicBezierInterpolator.DEFAULT.getInterpolation(f);
        float interpolation2 = CubicBezierInterpolator.EASE_OUT_QUINT.getInterpolation(f);
        float f3 = ((1.0f - interpolation2) * x) + (fCenterX * interpolation2);
        float f4 = 1.0f - interpolation;
        float f5 = (y * f4) + (fCenterY * interpolation);
        float fHeight = this.messageView.getRadialProgress().getProgressRect().height() / 2.0f;
        float f6 = (this.fromRadius * f4) + (fHeight * interpolation);
        int measuredHeight = this.container.getMeasuredHeight() > 0 ? (int) ((this.container.getMeasuredHeight() * f4) + (((this.listView.getY() - this.container.getY()) + this.listView.getMeasuredHeight()) * interpolation)) : 0;
        this.circlePaint.setColor(ColorUtils.blendARGB(getThemedColor(Theme.key_chat_messagePanelVoiceBackground), getThemedColor(this.messageView.getRadialProgress().getCircleColorKey()), interpolation));
        ChatActivityEnterView.RecordCircle recordCircle3 = this.recordCircle;
        if (recordCircle3 != null) {
            recordCircle3.drawWaves(canvas, f3, f5, 1.0f - f2);
        }
        canvas.drawCircle(f3, f5, f6, this.circlePaint);
        canvas.save();
        float f7 = f6 / fHeight;
        canvas.scale(f7, f7, f3, f5);
        canvas.translate(f3 - this.messageView.getRadialProgress().getProgressRect().centerX(), f5 - this.messageView.getRadialProgress().getProgressRect().centerY());
        this.messageView.getRadialProgress().setOverrideAlpha(interpolation);
        this.messageView.getRadialProgress().setDrawBackground(false);
        this.messageView.getRadialProgress().draw(canvas);
        this.messageView.getRadialProgress().setDrawBackground(true);
        this.messageView.getRadialProgress().setOverrideAlpha(1.0f);
        canvas.restore();
        if (this.container.getMeasuredHeight() > 0) {
            this.gradientMatrix.setTranslate(0.0f, measuredHeight);
            this.gradientShader.setLocalMatrix(this.gradientMatrix);
        }
        ChatActivityEnterView.RecordCircle recordCircle4 = this.recordCircle;
        if (recordCircle4 != null) {
            recordCircle4.drawIcon(canvas, (int) x, (int) y, 1.0f - f);
        }
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }
}
