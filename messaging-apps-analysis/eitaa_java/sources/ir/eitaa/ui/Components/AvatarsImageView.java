package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GroupCallUserCell;
import java.util.Random;

/* loaded from: classes3.dex */
public class AvatarsImageView extends FrameLayout {
    DrawingState[] animatingStates;
    boolean centered;
    DrawingState[] currentStates;
    int currentStyle;
    private boolean isInCall;
    private Paint paint;
    Random random;
    float transitionProgress;
    ValueAnimator transitionProgressAnimator;
    boolean updateAfterTransition;
    Runnable updateDelegate;
    boolean wasDraw;
    private Paint xRefP;

    public void commitTransition(boolean animated) {
        boolean z;
        if (!this.wasDraw || !animated) {
            this.transitionProgress = 1.0f;
            swapStates();
            return;
        }
        DrawingState[] drawingStateArr = new DrawingState[3];
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            DrawingState[] drawingStateArr2 = this.currentStates;
            drawingStateArr[i] = drawingStateArr2[i];
            if (drawingStateArr2[i].id != this.animatingStates[i].id) {
                z2 = true;
            } else {
                this.currentStates[i].lastSpeakTime = this.animatingStates[i].lastSpeakTime;
            }
        }
        if (!z2) {
            this.transitionProgress = 1.0f;
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    z = false;
                    break;
                }
                if (this.currentStates[i3].id == this.animatingStates[i2].id) {
                    drawingStateArr[i3] = null;
                    if (i2 == i3) {
                        this.animatingStates[i2].animationType = -1;
                        GroupCallUserCell.AvatarWavesDrawable avatarWavesDrawable = this.animatingStates[i2].wavesDrawable;
                        this.animatingStates[i2].wavesDrawable = this.currentStates[i2].wavesDrawable;
                        this.currentStates[i2].wavesDrawable = avatarWavesDrawable;
                    } else {
                        this.animatingStates[i2].animationType = 2;
                        this.animatingStates[i2].moveFromIndex = i3;
                    }
                    z = true;
                } else {
                    i3++;
                }
            }
            if (!z) {
                this.animatingStates[i2].animationType = 0;
            }
        }
        for (int i4 = 0; i4 < 3; i4++) {
            if (drawingStateArr[i4] != null) {
                drawingStateArr[i4].animationType = 1;
            }
        }
        ValueAnimator valueAnimator = this.transitionProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.transitionProgress = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.transitionProgressAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AvatarsImageView$2vOXSySxv3I-7QawJi2Dqu6jrdk
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$commitTransition$0$AvatarsImageView(valueAnimator2);
            }
        });
        this.transitionProgressAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AvatarsImageView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AvatarsImageView avatarsImageView = AvatarsImageView.this;
                if (avatarsImageView.transitionProgressAnimator != null) {
                    avatarsImageView.transitionProgress = 1.0f;
                    avatarsImageView.swapStates();
                    AvatarsImageView avatarsImageView2 = AvatarsImageView.this;
                    if (avatarsImageView2.updateAfterTransition) {
                        avatarsImageView2.updateAfterTransition = false;
                        Runnable runnable = avatarsImageView2.updateDelegate;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    AvatarsImageView.this.invalidate();
                }
                AvatarsImageView.this.transitionProgressAnimator = null;
            }
        });
        this.transitionProgressAnimator.setDuration(220L);
        this.transitionProgressAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.transitionProgressAnimator.start();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$commitTransition$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$commitTransition$0$AvatarsImageView(ValueAnimator valueAnimator) {
        this.transitionProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swapStates() {
        for (int i = 0; i < 3; i++) {
            DrawingState[] drawingStateArr = this.currentStates;
            DrawingState drawingState = drawingStateArr[i];
            DrawingState[] drawingStateArr2 = this.animatingStates;
            drawingStateArr[i] = drawingStateArr2[i];
            drawingStateArr2[i] = drawingState;
        }
    }

    public void updateAfterTransitionEnd() {
        this.updateAfterTransition = true;
    }

    public void setDelegate(Runnable delegate) {
        this.updateDelegate = delegate;
    }

    public void setStyle(int currentStyle) {
        this.currentStyle = currentStyle;
        invalidate();
    }

    private static class DrawingState {
        private int animationType;
        private AvatarDrawable avatarDrawable;
        private long id;
        private ImageReceiver imageReceiver;
        private long lastSpeakTime;
        private long lastUpdateTime;
        private int moveFromIndex;
        TLRPC$TL_groupCallParticipant participant;
        private GroupCallUserCell.AvatarWavesDrawable wavesDrawable;

        private DrawingState() {
        }
    }

    public AvatarsImageView(Context context, boolean inCall) {
        super(context);
        this.currentStates = new DrawingState[3];
        this.animatingStates = new DrawingState[3];
        this.transitionProgress = 1.0f;
        this.paint = new Paint(1);
        this.xRefP = new Paint(1);
        this.random = new Random();
        for (int i = 0; i < 3; i++) {
            this.currentStates[i] = new DrawingState();
            this.currentStates[i].imageReceiver = new ImageReceiver(this);
            this.currentStates[i].imageReceiver.setRoundRadius(AndroidUtilities.dp(12.0f));
            this.currentStates[i].avatarDrawable = new AvatarDrawable();
            this.currentStates[i].avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
            this.animatingStates[i] = new DrawingState();
            this.animatingStates[i].imageReceiver = new ImageReceiver(this);
            this.animatingStates[i].imageReceiver.setRoundRadius(AndroidUtilities.dp(12.0f));
            this.animatingStates[i].avatarDrawable = new AvatarDrawable();
            this.animatingStates[i].avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        }
        this.isInCall = inCall;
        setWillNotDraw(false);
        this.xRefP.setColor(0);
        this.xRefP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public void setObject(int index, int account, TLObject object) {
        TLRPC$Chat tLRPC$Chat;
        TLRPC$Chat chat;
        this.animatingStates[index].id = 0L;
        DrawingState[] drawingStateArr = this.animatingStates;
        TLRPC$User tLRPC$User = null;
        drawingStateArr[index].participant = null;
        if (object == null) {
            drawingStateArr[index].imageReceiver.setImageBitmap((Drawable) null);
            invalidate();
            return;
        }
        drawingStateArr[index].lastSpeakTime = -1L;
        if (object instanceof TLRPC$TL_groupCallParticipant) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = (TLRPC$TL_groupCallParticipant) object;
            this.animatingStates[index].participant = tLRPC$TL_groupCallParticipant;
            long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
            if (DialogObject.isUserDialog(peerId)) {
                TLRPC$User user = MessagesController.getInstance(account).getUser(Long.valueOf(peerId));
                this.animatingStates[index].avatarDrawable.setInfo(user);
                tLRPC$User = user;
                chat = null;
            } else {
                chat = MessagesController.getInstance(account).getChat(Long.valueOf(-peerId));
                this.animatingStates[index].avatarDrawable.setInfo(chat);
            }
            if (this.currentStyle != 4) {
                this.animatingStates[index].lastSpeakTime = tLRPC$TL_groupCallParticipant.active_date;
            } else if (peerId == AccountInstance.getInstance(account).getUserConfig().getClientUserId()) {
                this.animatingStates[index].lastSpeakTime = 0L;
            } else if (this.isInCall) {
                this.animatingStates[index].lastSpeakTime = tLRPC$TL_groupCallParticipant.lastActiveDate;
            } else {
                this.animatingStates[index].lastSpeakTime = tLRPC$TL_groupCallParticipant.active_date;
            }
            this.animatingStates[index].id = peerId;
            tLRPC$Chat = chat;
        } else if (object instanceof TLRPC$User) {
            TLRPC$User tLRPC$User2 = (TLRPC$User) object;
            this.animatingStates[index].avatarDrawable.setInfo(tLRPC$User2);
            this.animatingStates[index].id = tLRPC$User2.id;
            tLRPC$User = tLRPC$User2;
            tLRPC$Chat = null;
        } else {
            tLRPC$Chat = (TLRPC$Chat) object;
            this.animatingStates[index].avatarDrawable.setInfo(tLRPC$Chat);
            this.animatingStates[index].id = -tLRPC$Chat.id;
        }
        if (tLRPC$User != null) {
            this.animatingStates[index].imageReceiver.setForUserOrChat(tLRPC$User, this.animatingStates[index].avatarDrawable);
        } else {
            this.animatingStates[index].imageReceiver.setForUserOrChat(tLRPC$Chat, this.animatingStates[index].avatarDrawable);
        }
        int i = this.currentStyle;
        boolean z = i == 4 || i == 10;
        this.animatingStates[index].imageReceiver.setRoundRadius(AndroidUtilities.dp(z ? 16.0f : 12.0f));
        float fDp = AndroidUtilities.dp(z ? 32.0f : 24.0f);
        this.animatingStates[index].imageReceiver.setImageCoords(0.0f, 0.0f, fDp, fDp);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012c  */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    @Override // android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r34) {
        /*
            Method dump skipped, instructions count: 1306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AvatarsImageView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wasDraw = false;
        for (int i = 0; i < 3; i++) {
            this.currentStates[i].imageReceiver.onDetachedFromWindow();
            this.animatingStates[i].imageReceiver.onDetachedFromWindow();
        }
        if (this.currentStyle == 3) {
            Theme.getFragmentContextViewWavesDrawable().setAmplitude(0.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < 3; i++) {
            this.currentStates[i].imageReceiver.onAttachedToWindow();
            this.animatingStates[i].imageReceiver.onAttachedToWindow();
        }
    }

    public void setCentered(boolean centered) {
        this.centered = centered;
    }
}
