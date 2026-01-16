package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.CounterView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatPullingDownDrawable implements NotificationCenter.NotificationCenterDelegate {
    boolean animateCheck;
    public boolean animateSwipeToRelease;
    float bounceProgress;
    StaticLayout chatNameLayout;
    int chatNameWidth;
    float checkProgress;
    float circleRadius;
    private final int currentAccount;
    private final long currentDialog;
    public int dialogFilterId;
    public int dialogFolderId;
    boolean drawFolderBackground;
    boolean emptyStub;
    private final int filterId;
    private final int folderId;
    private final View fragmentView;
    long lastHapticTime;
    float lastProgress;
    public long lastShowingReleaseTime;
    int lastWidth;
    StaticLayout layout1;
    int layout1Width;
    StaticLayout layout2;
    int layout2Width;
    TLRPC$Chat nextChat;
    public long nextDialogId;
    Runnable onAnimationFinishRunnable;
    View parentView;
    float progressToBottomPannel;
    private final Theme.ResourcesProvider resourcesProvider;
    boolean showBottomPanel;
    AnimatorSet showReleaseAnimator;
    float swipeToReleaseProgress;
    Paint arrowPaint = new Paint(1);
    TextPaint textPaint = new TextPaint(1);
    TextPaint textPaint2 = new TextPaint(1);
    private Paint xRefPaint = new Paint(1);
    Path path = new Path();
    ImageReceiver imageReceiver = new ImageReceiver();
    CounterView.CounterDrawable counterDrawable = new CounterView.CounterDrawable(null, null);
    int[] params = new int[3];

    public ChatPullingDownDrawable(int currentAccount, View fragmentView, long currentDialog, int folderId, int filterId, Theme.ResourcesProvider resourcesProvider) {
        this.fragmentView = fragmentView;
        this.currentAccount = currentAccount;
        this.currentDialog = currentDialog;
        this.folderId = folderId;
        this.filterId = filterId;
        this.resourcesProvider = resourcesProvider;
        this.arrowPaint.setStrokeWidth(AndroidUtilities.dpf2(2.8f));
        this.arrowPaint.setStrokeCap(Paint.Cap.ROUND);
        CounterView.CounterDrawable counterDrawable = this.counterDrawable;
        counterDrawable.gravity = 3;
        counterDrawable.setType(1);
        CounterView.CounterDrawable counterDrawable2 = this.counterDrawable;
        counterDrawable2.addServiceGradient = true;
        counterDrawable2.circlePaint = getThemedPaint("paintChatActionBackground");
        CounterView.CounterDrawable counterDrawable3 = this.counterDrawable;
        TextPaint textPaint = this.textPaint;
        counterDrawable3.textPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textPaint2.setTextSize(AndroidUtilities.dp(14.0f));
        this.textPaint2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.xRefPaint.setColor(-16777216);
        this.xRefPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        updateDialog();
    }

    public void updateDialog() {
        TLRPC$Dialog nextUnreadDialog = getNextUnreadDialog(this.currentDialog, this.folderId, this.filterId, true, this.params);
        if (nextUnreadDialog != null) {
            this.nextDialogId = nextUnreadDialog.id;
            int[] iArr = this.params;
            this.drawFolderBackground = iArr[0] == 1;
            this.dialogFolderId = iArr[1];
            this.dialogFilterId = iArr[2];
            this.emptyStub = false;
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-nextUnreadDialog.id));
            this.nextChat = chat;
            if (chat == null) {
                MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(nextUnreadDialog.id));
            }
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setInfo(this.nextChat);
            this.imageReceiver.setImage(ImageLocation.getForChat(this.nextChat, 1), "50_50", avatarDrawable, null, UserConfig.getInstance(0).getCurrentUser(), 0);
            MessagesController.getInstance(this.currentAccount).ensureMessagesLoaded(nextUnreadDialog.id, 0, null);
            this.counterDrawable.setCount(nextUnreadDialog.unread_count, false);
            return;
        }
        this.nextChat = null;
        this.drawFolderBackground = false;
        this.emptyStub = true;
    }

    public void setWidth(int width) {
        String string;
        String string2;
        int i;
        if (width != this.lastWidth) {
            this.circleRadius = AndroidUtilities.dp(56.0f) / 2.0f;
            this.lastWidth = width;
            TLRPC$Chat tLRPC$Chat = this.nextChat;
            String string3 = tLRPC$Chat != null ? tLRPC$Chat.title : LocaleController.getString("SwipeToGoNextChannelEnd", R.string.SwipeToGoNextChannelEnd);
            int iMeasureText = (int) this.textPaint.measureText(string3);
            this.chatNameWidth = iMeasureText;
            this.chatNameWidth = Math.min(iMeasureText, this.lastWidth - AndroidUtilities.dp(60.0f));
            this.chatNameLayout = new StaticLayout(string3, this.textPaint, this.chatNameWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            boolean z = this.drawFolderBackground;
            if (z && (i = this.dialogFolderId) != this.folderId && i != 0) {
                string = LocaleController.getString("SwipeToGoNextArchive", R.string.SwipeToGoNextArchive);
                string2 = LocaleController.getString("ReleaseToGoNextArchive", R.string.ReleaseToGoNextArchive);
            } else if (z) {
                string = LocaleController.getString("SwipeToGoNextFolder", R.string.SwipeToGoNextFolder);
                string2 = LocaleController.getString("ReleaseToGoNextFolder", R.string.ReleaseToGoNextFolder);
            } else {
                string = LocaleController.getString("SwipeToGoNextChannel", R.string.SwipeToGoNextChannel);
                string2 = LocaleController.getString("ReleaseToGoNextChannel", R.string.ReleaseToGoNextChannel);
            }
            String str = string;
            int iMeasureText2 = (int) this.textPaint2.measureText(str);
            this.layout1Width = iMeasureText2;
            this.layout1Width = Math.min(iMeasureText2, this.lastWidth - AndroidUtilities.dp(30.0f));
            this.layout1 = new StaticLayout(str, this.textPaint2, this.layout1Width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            int iMeasureText3 = (int) this.textPaint2.measureText(string2);
            this.layout2Width = iMeasureText3;
            this.layout2Width = Math.min(iMeasureText3, this.lastWidth - AndroidUtilities.dp(30.0f));
            this.layout2 = new StaticLayout(string2, this.textPaint2, this.layout2Width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.imageReceiver.setImageCoords((this.lastWidth / 2.0f) - (AndroidUtilities.dp(40.0f) / 2.0f), (AndroidUtilities.dp(12.0f) + this.circleRadius) - (AndroidUtilities.dp(40.0f) / 2.0f), AndroidUtilities.dp(40.0f), AndroidUtilities.dp(40.0f));
            this.imageReceiver.setRoundRadius((int) (AndroidUtilities.dp(40.0f) / 2.0f));
            this.counterDrawable.setSize(AndroidUtilities.dp(28.0f), AndroidUtilities.dp(100.0f));
        }
    }

    public void draw(Canvas canvas, View parent, float progress, float alpha) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        this.parentView = parent;
        this.counterDrawable.setParent(parent);
        float fDp = AndroidUtilities.dp(110.0f) * progress;
        if (fDp < AndroidUtilities.dp(8.0f)) {
            return;
        }
        float f3 = progress < 0.2f ? 5.0f * progress * alpha : alpha;
        Theme.applyServiceShaderMatrix(this.lastWidth, parent.getMeasuredHeight(), 0.0f, parent.getMeasuredHeight() - fDp);
        this.textPaint.setColor(getThemedColor("chat_serviceText"));
        this.arrowPaint.setColor(getThemedColor("chat_serviceText"));
        this.textPaint2.setColor(getThemedColor("chat_messagePanelHint"));
        int alpha2 = getThemedPaint("paintChatActionBackground").getAlpha();
        int alpha3 = Theme.chat_actionBackgroundGradientDarkenPaint.getAlpha();
        int alpha4 = this.textPaint.getAlpha();
        int alpha5 = this.arrowPaint.getAlpha();
        Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha((int) (alpha3 * f3));
        int i4 = (int) (alpha2 * f3);
        getThemedPaint("paintChatActionBackground").setAlpha(i4);
        int i5 = (int) (alpha4 * f3);
        this.textPaint.setAlpha(i5);
        this.imageReceiver.setAlpha(f3);
        if ((progress < 1.0f || this.lastProgress >= 1.0f) && (progress >= 1.0f || this.lastProgress != 1.0f)) {
            i = alpha2;
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            i = alpha2;
            if (jCurrentTimeMillis - this.lastHapticTime > 100) {
                parent.performHapticFeedback(3, 2);
                this.lastHapticTime = jCurrentTimeMillis;
            }
            this.lastProgress = progress;
        }
        if (progress == 1.0f && !this.animateSwipeToRelease) {
            this.animateSwipeToRelease = true;
            this.animateCheck = true;
            showReleaseState(true, parent);
            this.lastShowingReleaseTime = System.currentTimeMillis();
        } else if (progress != 1.0f && this.animateSwipeToRelease) {
            this.animateSwipeToRelease = false;
            showReleaseState(false, parent);
        }
        float f4 = this.lastWidth / 2.0f;
        float f5 = this.bounceProgress * (-AndroidUtilities.dp(4.0f));
        if (this.emptyStub) {
            fDp -= f5;
        }
        float f6 = fDp / 2.0f;
        float fMax = Math.max(0.0f, Math.min(this.circleRadius, (f6 - (AndroidUtilities.dp(16.0f) * progress)) - AndroidUtilities.dp(4.0f)));
        float fMax2 = ((Math.max(0.0f, Math.min(this.circleRadius * progress, f6 - (AndroidUtilities.dp(8.0f) * progress))) * 2.0f) - AndroidUtilities.dp2(16.0f)) * (1.0f - this.swipeToReleaseProgress);
        float fDp2 = AndroidUtilities.dp(56.0f);
        float f7 = this.swipeToReleaseProgress;
        float f8 = fMax2 + (fDp2 * f7);
        if (f7 < 1.0f || this.emptyStub) {
            float f9 = -fDp;
            i2 = alpha4;
            i3 = alpha3;
            float fDp3 = ((-AndroidUtilities.dp(8.0f)) * (1.0f - this.swipeToReleaseProgress)) + ((AndroidUtilities.dp(56.0f) + f9) * this.swipeToReleaseProgress);
            RectF rectF = AndroidUtilities.rectTmp;
            rectF.set(f4 - fMax, f9, fMax + f4, fDp3);
            if (this.swipeToReleaseProgress > 0.0f && !this.emptyStub) {
                float fDp4 = AndroidUtilities.dp(16.0f) * this.swipeToReleaseProgress;
                rectF.inset(fDp4, fDp4);
            }
            drawBackground(canvas, rectF);
            float fDp5 = ((AndroidUtilities.dp(24.0f) + f9) + (AndroidUtilities.dp(8.0f) * (1.0f - progress))) - (AndroidUtilities.dp(36.0f) * this.swipeToReleaseProgress);
            canvas.save();
            f = fDp;
            rectF.inset(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
            canvas.clipRect(rectF);
            float f10 = this.swipeToReleaseProgress;
            if (f10 > 0.0f) {
                this.arrowPaint.setAlpha((int) ((1.0f - f10) * 255.0f));
            }
            drawArrow(canvas, f4, fDp5, AndroidUtilities.dp(24.0f) * progress);
            if (this.emptyStub) {
                float fDp22 = ((((-AndroidUtilities.dp(8.0f)) - (AndroidUtilities.dp2(8.0f) * progress)) - f8) * (1.0f - this.swipeToReleaseProgress)) + ((f9 - AndroidUtilities.dp(2.0f)) * this.swipeToReleaseProgress) + f5;
                this.arrowPaint.setAlpha(alpha5);
                canvas.save();
                canvas.scale(progress, progress, f4, AndroidUtilities.dp(28.0f) + fDp22);
                drawCheck(canvas, f4, fDp22 + AndroidUtilities.dp(28.0f));
                canvas.restore();
            }
            canvas.restore();
        } else {
            f = fDp;
            i3 = alpha3;
            i2 = alpha4;
        }
        if (this.chatNameLayout != null && this.swipeToReleaseProgress > 0.0f) {
            getThemedPaint("paintChatActionBackground").setAlpha(i4);
            this.textPaint.setAlpha(i5);
            float fDp6 = ((AndroidUtilities.dp(20.0f) * (1.0f - this.swipeToReleaseProgress)) - (AndroidUtilities.dp(36.0f) * this.swipeToReleaseProgress)) + f5;
            RectF rectF2 = AndroidUtilities.rectTmp;
            int i6 = this.lastWidth;
            int i7 = this.chatNameWidth;
            rectF2.set((i6 - i7) / 2.0f, fDp6, i6 - ((i6 - i7) / 2.0f), this.chatNameLayout.getHeight() + fDp6);
            rectF2.inset(-AndroidUtilities.dp(8.0f), -AndroidUtilities.dp(4.0f));
            canvas.drawRoundRect(rectF2, AndroidUtilities.dp(15.0f), AndroidUtilities.dp(15.0f), getThemedPaint("paintChatActionBackground"));
            if (hasGradientService()) {
                canvas.drawRoundRect(rectF2, AndroidUtilities.dp(15.0f), AndroidUtilities.dp(15.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
            canvas.save();
            canvas.translate((this.lastWidth - this.chatNameWidth) / 2.0f, fDp6);
            this.chatNameLayout.draw(canvas);
            canvas.restore();
        }
        if (this.emptyStub || f8 <= 0.0f) {
            f2 = 1.0f;
        } else {
            float fDp23 = ((((-AndroidUtilities.dp(8.0f)) - (AndroidUtilities.dp2(8.0f) * progress)) - f8) * (1.0f - this.swipeToReleaseProgress)) + (((-f) + AndroidUtilities.dp(4.0f)) * this.swipeToReleaseProgress) + f5;
            float f11 = f8 / 2.0f;
            this.imageReceiver.setRoundRadius((int) f11);
            this.imageReceiver.setImageCoords(f4 - f11, fDp23, f8, f8);
            if (this.swipeToReleaseProgress > 0.0f) {
                f2 = 1.0f;
                canvas.saveLayerAlpha(this.imageReceiver.getImageX(), this.imageReceiver.getImageY(), this.imageReceiver.getImageWidth() + this.imageReceiver.getImageX(), this.imageReceiver.getImageHeight() + this.imageReceiver.getImageY(), 255, 31);
                this.imageReceiver.draw(canvas);
                float f12 = this.swipeToReleaseProgress;
                canvas.scale(f12, f12, AndroidUtilities.dp(12.0f) + f4 + this.counterDrawable.getCenterX(), (fDp23 - AndroidUtilities.dp(6.0f)) + AndroidUtilities.dp(14.0f));
                canvas.translate(AndroidUtilities.dp(12.0f) + f4, fDp23 - AndroidUtilities.dp(6.0f));
                this.counterDrawable.updateBackgroundRect();
                this.counterDrawable.rectF.inset(-AndroidUtilities.dp(2.0f), -AndroidUtilities.dp(2.0f));
                RectF rectF3 = this.counterDrawable.rectF;
                canvas.drawRoundRect(rectF3, rectF3.height() / 2.0f, this.counterDrawable.rectF.height() / 2.0f, this.xRefPaint);
                canvas.restore();
                canvas.save();
                float f13 = this.swipeToReleaseProgress;
                canvas.scale(f13, f13, AndroidUtilities.dp(12.0f) + f4 + this.counterDrawable.getCenterX(), (fDp23 - AndroidUtilities.dp(6.0f)) + AndroidUtilities.dp(14.0f));
                canvas.translate(f4 + AndroidUtilities.dp(12.0f), fDp23 - AndroidUtilities.dp(6.0f));
                this.counterDrawable.draw(canvas);
                canvas.restore();
            } else {
                f2 = 1.0f;
                this.imageReceiver.draw(canvas);
            }
        }
        getThemedPaint("paintChatActionBackground").setAlpha(i);
        Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha(i3);
        this.textPaint.setAlpha(i2);
        this.arrowPaint.setAlpha(alpha5);
        this.imageReceiver.setAlpha(f2);
    }

    private void drawCheck(Canvas canvas, float cx, float cy) {
        if (this.animateCheck) {
            float f = this.checkProgress;
            if (f < 1.0f) {
                float f2 = f + 0.07272727f;
                this.checkProgress = f2;
                if (f2 > 1.0f) {
                    this.checkProgress = 1.0f;
                }
            }
            float f3 = this.checkProgress;
            float f4 = f3 > 0.5f ? 1.0f : f3 / 0.5f;
            float f5 = f3 < 0.5f ? 0.0f : (f3 - 0.5f) / 0.5f;
            canvas.save();
            canvas.clipRect(AndroidUtilities.rectTmp);
            canvas.translate(cx - AndroidUtilities.dp(24.0f), cy - AndroidUtilities.dp(24.0f));
            float fDp = AndroidUtilities.dp(16.0f);
            float fDp2 = AndroidUtilities.dp(26.0f);
            float fDp3 = AndroidUtilities.dp(22.0f);
            float fDp4 = AndroidUtilities.dp(32.0f);
            float fDp5 = AndroidUtilities.dp(32.0f);
            float fDp6 = AndroidUtilities.dp(20.0f);
            float f6 = 1.0f - f4;
            canvas.drawLine(fDp, fDp2, (fDp * f6) + (fDp3 * f4), (f6 * fDp2) + (f4 * fDp4), this.arrowPaint);
            if (f5 > 0.0f) {
                float f7 = 1.0f - f5;
                canvas.drawLine(fDp3, fDp4, (fDp3 * f7) + (fDp5 * f5), (f7 * fDp4) + (fDp6 * f5), this.arrowPaint);
            }
            canvas.restore();
        }
    }

    private void drawBackground(Canvas canvas, RectF rectTmp) {
        if (this.drawFolderBackground) {
            this.path.reset();
            float fWidth = rectTmp.width() * 0.2f;
            float fWidth2 = rectTmp.width() * 0.1f;
            float fWidth3 = rectTmp.width() * 0.03f;
            float f = fWidth2 / 2.0f;
            float fHeight = rectTmp.height() - fWidth2;
            this.path.moveTo(rectTmp.right, rectTmp.top + fWidth + fWidth2);
            float f2 = -fWidth;
            this.path.rQuadTo(0.0f, f2, f2, f2);
            float f3 = fWidth * 2.0f;
            float f4 = f * 2.0f;
            this.path.rLineTo((((-(rectTmp.width() - f3)) / 2.0f) + f4) - fWidth3, 0.0f);
            float f5 = -f;
            float f6 = f5 / 2.0f;
            float f7 = f5 * 2.0f;
            float f8 = (-fWidth2) / 2.0f;
            this.path.rQuadTo(f6, 0.0f, f7, f8);
            this.path.rQuadTo(f6, f8, f7, f8);
            this.path.rLineTo(((-(rectTmp.width() - f3)) / 2.0f) + f4 + fWidth3, 0.0f);
            this.path.rQuadTo(f2, 0.0f, f2, fWidth);
            this.path.rLineTo(0.0f, (fWidth2 + fHeight) - f3);
            this.path.rQuadTo(0.0f, fWidth, fWidth, fWidth);
            this.path.rLineTo(rectTmp.width() - f3, 0.0f);
            this.path.rQuadTo(fWidth, 0.0f, fWidth, f2);
            this.path.rLineTo(0.0f, -(fHeight - f3));
            this.path.close();
            canvas.drawPath(this.path, getThemedPaint("paintChatActionBackground"));
            if (hasGradientService()) {
                canvas.drawPath(this.path, Theme.chat_actionBackgroundGradientDarkenPaint);
                return;
            }
            return;
        }
        RectF rectF = AndroidUtilities.rectTmp;
        float f9 = this.circleRadius;
        canvas.drawRoundRect(rectF, f9, f9, getThemedPaint("paintChatActionBackground"));
        if (hasGradientService()) {
            float f10 = this.circleRadius;
            canvas.drawRoundRect(rectF, f10, f10, Theme.chat_actionBackgroundGradientDarkenPaint);
        }
    }

    private void showReleaseState(boolean show, final View parent) {
        AnimatorSet animatorSet = this.showReleaseAnimator;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.showReleaseAnimator.cancel();
        }
        if (show) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.swipeToReleaseProgress, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$wwimSEJBWQsza7sP74zvgrd1LTQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showReleaseState$0$ChatPullingDownDrawable(parent, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
            valueAnimatorOfFloat.setDuration(250L);
            this.bounceProgress = 0.0f;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$auj7Kx39Na4FsIsqDSUew1aZ4KQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showReleaseState$1$ChatPullingDownDrawable(parent, valueAnimator);
                }
            });
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_BOTH;
            valueAnimatorOfFloat2.setInterpolator(cubicBezierInterpolator);
            valueAnimatorOfFloat2.setDuration(180L);
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, -0.5f);
            valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$ieoHcB8J-df3E_dv85L9-lw5tgQ
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showReleaseState$2$ChatPullingDownDrawable(parent, valueAnimator);
                }
            });
            valueAnimatorOfFloat3.setInterpolator(cubicBezierInterpolator);
            valueAnimatorOfFloat3.setDuration(120L);
            ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(-0.5f, 0.0f);
            valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$PBBznI8MijM6dFzMOUlBpLm5_3U
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$showReleaseState$3$ChatPullingDownDrawable(parent, valueAnimator);
                }
            });
            valueAnimatorOfFloat4.setInterpolator(cubicBezierInterpolator);
            valueAnimatorOfFloat4.setDuration(100L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.showReleaseAnimator = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChatPullingDownDrawable.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ChatPullingDownDrawable chatPullingDownDrawable = ChatPullingDownDrawable.this;
                    chatPullingDownDrawable.bounceProgress = 0.0f;
                    chatPullingDownDrawable.swipeToReleaseProgress = 1.0f;
                    parent.invalidate();
                    ChatPullingDownDrawable.this.fragmentView.invalidate();
                    Runnable runnable = ChatPullingDownDrawable.this.onAnimationFinishRunnable;
                    if (runnable != null) {
                        runnable.run();
                        ChatPullingDownDrawable.this.onAnimationFinishRunnable = null;
                    }
                }
            });
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playSequentially(valueAnimatorOfFloat2, valueAnimatorOfFloat3, valueAnimatorOfFloat4);
            this.showReleaseAnimator.playTogether(valueAnimatorOfFloat, animatorSet3);
            this.showReleaseAnimator.start();
            return;
        }
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.swipeToReleaseProgress, 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$SDPvN6uqS-ClqyCBDBrTZPmbaIM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$showReleaseState$4$ChatPullingDownDrawable(parent, valueAnimator);
            }
        });
        valueAnimatorOfFloat5.setInterpolator(CubicBezierInterpolator.DEFAULT);
        valueAnimatorOfFloat5.setDuration(220L);
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.showReleaseAnimator = animatorSet4;
        animatorSet4.playTogether(valueAnimatorOfFloat5);
        this.showReleaseAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showReleaseState$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showReleaseState$0$ChatPullingDownDrawable(View view, ValueAnimator valueAnimator) {
        this.swipeToReleaseProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.invalidate();
        this.fragmentView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showReleaseState$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showReleaseState$1$ChatPullingDownDrawable(View view, ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showReleaseState$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showReleaseState$2$ChatPullingDownDrawable(View view, ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showReleaseState$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showReleaseState$3$ChatPullingDownDrawable(View view, ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showReleaseState$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showReleaseState$4$ChatPullingDownDrawable(View view, ValueAnimator valueAnimator) {
        this.swipeToReleaseProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.fragmentView.invalidate();
        view.invalidate();
    }

    private void drawArrow(Canvas canvas, float cx, float cy, float size) {
        canvas.save();
        float fDpf2 = size / AndroidUtilities.dpf2(24.0f);
        canvas.scale(fDpf2, fDpf2, cx, cy - AndroidUtilities.dp(20.0f));
        canvas.translate(cx - AndroidUtilities.dp2(12.0f), cy - AndroidUtilities.dp(12.0f));
        canvas.drawLine(AndroidUtilities.dpf2(12.5f), AndroidUtilities.dpf2(4.0f), AndroidUtilities.dpf2(12.5f), AndroidUtilities.dpf2(22.0f), this.arrowPaint);
        canvas.drawLine(AndroidUtilities.dpf2(3.5f), AndroidUtilities.dpf2(12.0f), AndroidUtilities.dpf2(12.5f), AndroidUtilities.dpf2(3.5f), this.arrowPaint);
        canvas.drawLine(AndroidUtilities.dpf2(21.5f), AndroidUtilities.dpf2(12.0f), AndroidUtilities.dpf2(12.5f), AndroidUtilities.dpf2(3.5f), this.arrowPaint);
        canvas.restore();
    }

    public void onAttach() {
        this.imageReceiver.onAttachedToWindow();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
    }

    public void onDetach() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        this.imageReceiver.onDetachedFromWindow();
        this.lastProgress = 0.0f;
        this.lastHapticTime = 0L;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        TLRPC$Dialog tLRPC$Dialog;
        if (this.nextDialogId == 0 || (tLRPC$Dialog = MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.nextDialogId)) == null) {
            return;
        }
        this.counterDrawable.setCount(tLRPC$Dialog.unread_count, true);
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
    }

    public static TLRPC$Dialog getNextUnreadDialog(long currentDialogId, int folderId, int filterId, boolean searchNext, int[] params) {
        ArrayList<TLRPC$Dialog> dialogs;
        TLRPC$Dialog nextUnreadDialog;
        TLRPC$Dialog nextUnreadDialog2;
        MessagesController messagesController = AccountInstance.getInstance(UserConfig.selectedAccount).getMessagesController();
        if (params != null) {
            params[0] = 0;
            params[1] = folderId;
            params[2] = filterId;
        }
        if (filterId != 0) {
            dialogs = messagesController.dialogFiltersById.get(filterId).dialogs;
        } else {
            dialogs = messagesController.getDialogs(folderId);
        }
        if (dialogs == null) {
            return null;
        }
        for (int i = 0; i < dialogs.size(); i++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i);
            TLRPC$Chat chat = messagesController.getChat(Long.valueOf(-tLRPC$Dialog.id));
            if (chat != null && tLRPC$Dialog.id != currentDialogId && tLRPC$Dialog.unread_count > 0 && DialogObject.isChannel(tLRPC$Dialog) && !chat.megagroup && !messagesController.isPromoDialog(tLRPC$Dialog.id, false)) {
                return tLRPC$Dialog;
            }
        }
        if (searchNext) {
            if (filterId != 0) {
                for (int i2 = 0; i2 < messagesController.dialogFilters.size(); i2++) {
                    int i3 = messagesController.dialogFilters.get(i2).id;
                    if (filterId != i3 && (nextUnreadDialog2 = getNextUnreadDialog(currentDialogId, folderId, i3, false, params)) != null) {
                        if (params != null) {
                            params[0] = 1;
                        }
                        return nextUnreadDialog2;
                    }
                }
            }
            for (int i4 = 0; i4 < messagesController.dialogsByFolder.size(); i4++) {
                int iKeyAt = messagesController.dialogsByFolder.keyAt(i4);
                if (folderId != iKeyAt && (nextUnreadDialog = getNextUnreadDialog(currentDialogId, iKeyAt, 0, false, params)) != null) {
                    if (params != null) {
                        params[0] = 1;
                    }
                    return nextUnreadDialog;
                }
            }
        }
        return null;
    }

    public long getChatId() {
        return this.nextChat.id;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawBottomPanel(android.graphics.Canvas r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatPullingDownDrawable.drawBottomPanel(android.graphics.Canvas, int, int, int):void");
    }

    public void showBottomPanel(boolean b) {
        this.showBottomPanel = b;
        this.fragmentView.invalidate();
    }

    public boolean needDrawBottomPanel() {
        return (this.showBottomPanel || this.progressToBottomPannel > 0.0f) && !this.emptyStub;
    }

    public boolean animationIsRunning() {
        return this.swipeToReleaseProgress != 1.0f;
    }

    public void runOnAnimationFinish(Runnable runnable) {
        AnimatorSet animatorSet = this.showReleaseAnimator;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.showReleaseAnimator.cancel();
        }
        this.onAnimationFinishRunnable = runnable;
        this.showReleaseAnimator = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.swipeToReleaseProgress, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$yTmsBWNi-Fomz2msqEdc4oJHAOU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$runOnAnimationFinish$5$ChatPullingDownDrawable(valueAnimator);
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.bounceProgress, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatPullingDownDrawable$ZYz1FAO_btGCoffAhu8xdt7MJP8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$runOnAnimationFinish$6$ChatPullingDownDrawable(valueAnimator);
            }
        });
        this.showReleaseAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChatPullingDownDrawable.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ChatPullingDownDrawable chatPullingDownDrawable = ChatPullingDownDrawable.this;
                chatPullingDownDrawable.bounceProgress = 0.0f;
                chatPullingDownDrawable.swipeToReleaseProgress = 1.0f;
                View view = chatPullingDownDrawable.parentView;
                if (view != null) {
                    view.invalidate();
                }
                ChatPullingDownDrawable.this.fragmentView.invalidate();
                Runnable runnable2 = ChatPullingDownDrawable.this.onAnimationFinishRunnable;
                if (runnable2 != null) {
                    runnable2.run();
                    ChatPullingDownDrawable.this.onAnimationFinishRunnable = null;
                }
            }
        });
        this.showReleaseAnimator.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.showReleaseAnimator.setDuration(120L);
        this.showReleaseAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.showReleaseAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runOnAnimationFinish$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runOnAnimationFinish$5$ChatPullingDownDrawable(ValueAnimator valueAnimator) {
        this.swipeToReleaseProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.fragmentView.invalidate();
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runOnAnimationFinish$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runOnAnimationFinish$6$ChatPullingDownDrawable(ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
    }

    public void reset() {
        this.checkProgress = 0.0f;
        this.animateCheck = false;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private Paint getThemedPaint(String paintKey) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Paint paint = resourcesProvider != null ? resourcesProvider.getPaint(paintKey) : null;
        return paint != null ? paint : Theme.getThemePaint(paintKey);
    }

    private boolean hasGradientService() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        return resourcesProvider != null ? resourcesProvider.hasGradientService() : Theme.hasGradientService();
    }
}
