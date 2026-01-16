package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.BlobDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupCallUserCell extends FrameLayout {
    private AccountInstance accountInstance;
    private AnimatorSet animatorSet;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private RadialProgressView avatarProgressView;
    private AvatarWavesDrawable avatarWavesDrawable;
    private Runnable checkRaiseRunnable;
    private ChatObject.Call currentCall;
    private TLRPC$Chat currentChat;
    private boolean currentIconGray;
    private int currentStatus;
    private TLRPC$User currentUser;
    private Paint dividerPaint;
    private SimpleTextView fullAboutTextView;
    private String grayIconColor;
    private boolean hasAvatar;
    private boolean isSpeaking;
    private int lastMuteColor;
    private boolean lastMuted;
    private boolean lastRaisedHand;
    private RLottieImageView muteButton;
    private RLottieDrawable muteDrawable;
    private SimpleTextView nameTextView;
    private boolean needDivider;
    private TLRPC$TL_groupCallParticipant participant;
    private float progressToAvatarPreview;
    private Runnable raiseHandCallback;
    private long selfId;
    private Runnable shakeHandCallback;
    private RLottieDrawable shakeHandDrawable;
    private Drawable speakingDrawable;
    private SimpleTextView[] statusTextView;
    private Runnable updateRunnable;
    private boolean updateRunnableScheduled;
    private Runnable updateVoiceRunnable;
    private boolean updateVoiceRunnableScheduled;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: onMuteClick, reason: merged with bridge method [inline-methods] */
    public void lambda$new$5$GroupCallUserCell(GroupCallUserCell cell) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$GroupCallUserCell() {
        this.shakeHandDrawable.setOnFinishCallback(null, 0);
        this.muteDrawable.setOnFinishCallback(null, 0);
        this.muteButton.setAnimation(this.muteDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$GroupCallUserCell() {
        int iNextInt = Utilities.random.nextInt(100);
        int i = 540;
        int i2 = 420;
        if (iNextInt < 32) {
            i = R.styleable.AppCompatTheme_windowNoTitle;
            i2 = 0;
        } else if (iNextInt < 64) {
            i = 240;
            i2 = R.styleable.AppCompatTheme_windowNoTitle;
        } else if (iNextInt < 97) {
            i = 420;
            i2 = 240;
        } else if (iNextInt != 98) {
            i = 720;
            i2 = 540;
        }
        this.shakeHandDrawable.setCustomEndFrame(i);
        this.shakeHandDrawable.setOnFinishCallback(this.shakeHandCallback, i - 1);
        this.muteButton.setAnimation(this.shakeHandDrawable);
        this.shakeHandDrawable.setCurrentFrame(i2);
        this.muteButton.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$GroupCallUserCell() throws InterruptedException {
        applyParticipantChanges(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$GroupCallUserCell() throws InterruptedException {
        this.isSpeaking = false;
        applyParticipantChanges(true, true);
        this.avatarWavesDrawable.setAmplitude(0.0d);
        this.updateRunnableScheduled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$GroupCallUserCell() throws InterruptedException {
        applyParticipantChanges(true, true);
        this.updateVoiceRunnableScheduled = false;
    }

    public void setProgressToAvatarPreview(float progressToAvatarPreview) {
        this.progressToAvatarPreview = progressToAvatarPreview;
        this.nameTextView.setTranslationX((LocaleController.isRTL ? AndroidUtilities.dp(53.0f) : -AndroidUtilities.dp(53.0f)) * progressToAvatarPreview);
        if (isSelfUser() && progressToAvatarPreview > 0.0f) {
            float f = 1.0f - progressToAvatarPreview;
            this.fullAboutTextView.setTranslationX((LocaleController.isRTL ? -AndroidUtilities.dp(53.0f) : AndroidUtilities.dp(53.0f)) * f);
            this.fullAboutTextView.setVisibility(0);
            this.fullAboutTextView.setAlpha(progressToAvatarPreview);
            this.statusTextView[4].setAlpha(f);
            SimpleTextView simpleTextView = this.statusTextView[4];
            boolean z = LocaleController.isRTL;
            int iDp = AndroidUtilities.dp(53.0f);
            if (!z) {
                iDp = -iDp;
            }
            simpleTextView.setTranslationX(iDp * progressToAvatarPreview);
        } else {
            this.fullAboutTextView.setVisibility(8);
            int i = 0;
            while (true) {
                SimpleTextView[] simpleTextViewArr = this.statusTextView;
                if (i >= simpleTextViewArr.length) {
                    break;
                }
                if (!TextUtils.isEmpty(simpleTextViewArr[4].getText()) && this.statusTextView[4].getLineCount() > 1) {
                    this.statusTextView[i].setFullLayoutAdditionalWidth(AndroidUtilities.dp(92.0f), LocaleController.isRTL ? AndroidUtilities.dp(48.0f) : AndroidUtilities.dp(53.0f));
                    this.statusTextView[i].setFullAlpha(progressToAvatarPreview);
                    this.statusTextView[i].setTranslationX(0.0f);
                    this.statusTextView[i].invalidate();
                } else {
                    this.statusTextView[i].setTranslationX((LocaleController.isRTL ? AndroidUtilities.dp(53.0f) : -AndroidUtilities.dp(53.0f)) * progressToAvatarPreview);
                    this.statusTextView[i].setFullLayoutAdditionalWidth(0, 0);
                }
                i++;
            }
        }
        this.avatarImageView.setAlpha(progressToAvatarPreview == 0.0f ? 1.0f : 0.0f);
        this.avatarWavesDrawable.setShowWaves(this.isSpeaking && progressToAvatarPreview == 0.0f, this);
        float f2 = 1.0f - progressToAvatarPreview;
        this.muteButton.setAlpha(f2);
        float f3 = (f2 * 0.4f) + 0.6f;
        this.muteButton.setScaleX(f3);
        this.muteButton.setScaleY(f3);
        invalidate();
    }

    public AvatarWavesDrawable getAvatarWavesDrawable() {
        return this.avatarWavesDrawable;
    }

    public void setUploadProgress(float progress, boolean animated) {
        this.avatarProgressView.setProgress(progress);
        if (progress < 1.0f) {
            AndroidUtilities.updateViewVisibilityAnimated(this.avatarProgressView, true, 1.0f, animated);
        } else {
            AndroidUtilities.updateViewVisibilityAnimated(this.avatarProgressView, false, 1.0f, animated);
        }
    }

    public void setDrawAvatar(boolean draw) {
        if (this.avatarImageView.getImageReceiver().getVisible() != draw) {
            this.avatarImageView.getImageReceiver().setVisible(draw, true);
        }
    }

    private static class VerifiedDrawable extends Drawable {
        private Drawable[] drawables;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public VerifiedDrawable(Context context) {
            Drawable[] drawableArr = new Drawable[2];
            this.drawables = drawableArr;
            drawableArr[0] = context.getResources().getDrawable(R.drawable.verified_area).mutate();
            this.drawables[0].setColorFilter(new PorterDuffColorFilter(-9063442, PorterDuff.Mode.MULTIPLY));
            this.drawables[1] = context.getResources().getDrawable(R.drawable.verified_check).mutate();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.drawables[0].getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.drawables[0].getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.drawables;
                if (i >= drawableArr.length) {
                    return;
                }
                drawableArr[i].setBounds(getBounds());
                this.drawables[i].draw(canvas);
                i++;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            int i = 0;
            while (true) {
                Drawable[] drawableArr = this.drawables;
                if (i >= drawableArr.length) {
                    return;
                }
                drawableArr[i].setAlpha(alpha);
                i++;
            }
        }
    }

    public GroupCallUserCell(Context context) throws Resources.NotFoundException {
        super(context);
        this.statusTextView = new SimpleTextView[5];
        this.shakeHandCallback = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$7iSZxrwTK6uw8zmOmru5GafeSNU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$GroupCallUserCell();
            }
        };
        this.raiseHandCallback = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$A4d8Bym1jmxGFSe2RqBuo3BemWY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1$GroupCallUserCell();
            }
        };
        this.grayIconColor = "voipgroup_mutedIcon";
        this.checkRaiseRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$w-siJcj8mSQaW_rCS5PdycbuiQs
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$2$GroupCallUserCell();
            }
        };
        this.updateRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$5rjxJKfOoSH5YsSmnMysX-97FGg
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$3$GroupCallUserCell();
            }
        };
        this.updateVoiceRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$jbTS5GCYyrTkPa6CXrvQI2gXxVc
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$4$GroupCallUserCell();
            }
        };
        Paint paint = new Paint();
        this.dividerPaint = paint;
        paint.setColor(Theme.getColor("voipgroup_actionBar"));
        this.avatarDrawable = new AvatarDrawable();
        setClipChildren(false);
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        BackupImageView backupImageView2 = this.avatarImageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(46, 46.0f, (z ? 5 : 3) | 48, z ? 0.0f : 11.0f, 6.0f, z ? 11.0f : 0.0f, 0.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context) { // from class: ir.eitaa.ui.Cells.GroupCallUserCell.1
            private Paint paint;

            {
                Paint paint2 = new Paint(1);
                this.paint = paint2;
                paint2.setColor(1426063360);
            }

            @Override // ir.eitaa.ui.Components.RadialProgressView, android.view.View
            protected void onDraw(Canvas canvas) {
                if (GroupCallUserCell.this.avatarImageView.getImageReceiver().hasNotThumb() && GroupCallUserCell.this.avatarImageView.getAlpha() > 0.0f) {
                    this.paint.setAlpha((int) (GroupCallUserCell.this.avatarImageView.getImageReceiver().getCurrentAlpha() * 85.0f * GroupCallUserCell.this.avatarImageView.getAlpha()));
                    canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2.0f, this.paint);
                }
                GroupCallUserCell.this.avatarProgressView.setProgressColor(ColorUtils.setAlphaComponent(-1, (int) (GroupCallUserCell.this.avatarImageView.getImageReceiver().getCurrentAlpha() * 255.0f * GroupCallUserCell.this.avatarImageView.getAlpha())));
                super.onDraw(canvas);
            }
        };
        this.avatarProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(26.0f));
        this.avatarProgressView.setProgressColor(-1);
        this.avatarProgressView.setNoProgress(false);
        RadialProgressView radialProgressView2 = this.avatarProgressView;
        boolean z2 = LocaleController.isRTL;
        addView(radialProgressView2, LayoutHelper.createFrame(46, 46.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 11.0f, 6.0f, z2 ? 11.0f : 0.0f, 0.0f));
        AndroidUtilities.updateViewVisibilityAnimated(this.avatarProgressView, false, 1.0f, false);
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("voipgroup_nameText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setTextSize(16);
        this.nameTextView.setDrawablePadding(AndroidUtilities.dp(6.0f));
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView2 = this.nameTextView;
        boolean z3 = LocaleController.isRTL;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? 54.0f : 67.0f, 10.0f, z3 ? 67.0f : 54.0f, 0.0f));
        Drawable drawable = context.getResources().getDrawable(R.drawable.voice_volume_mini);
        this.speakingDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("voipgroup_speakingText"), PorterDuff.Mode.MULTIPLY));
        final int i = 0;
        while (true) {
            SimpleTextView[] simpleTextViewArr = this.statusTextView;
            if (i >= simpleTextViewArr.length) {
                break;
            }
            simpleTextViewArr[i] = new SimpleTextView(context) { // from class: ir.eitaa.ui.Cells.GroupCallUserCell.2
                float originalAlpha;

                @Override // android.view.View
                public void setAlpha(float alpha) {
                    this.originalAlpha = alpha;
                    if (i == 4) {
                        float fullAlpha = GroupCallUserCell.this.statusTextView[4].getFullAlpha();
                        if (GroupCallUserCell.this.isSelfUser() && GroupCallUserCell.this.progressToAvatarPreview > 0.0f) {
                            super.setAlpha(1.0f - GroupCallUserCell.this.progressToAvatarPreview);
                            return;
                        } else if (fullAlpha > 0.0f) {
                            super.setAlpha(Math.max(alpha, fullAlpha));
                            return;
                        } else {
                            super.setAlpha(alpha);
                            return;
                        }
                    }
                    super.setAlpha(alpha * (1.0f - GroupCallUserCell.this.statusTextView[4].getFullAlpha()));
                }

                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    if (i == 4 && getFullAlpha() > 0.0f) {
                        translationY = 0.0f;
                    }
                    super.setTranslationY(translationY);
                }

                @Override // android.view.View
                public float getAlpha() {
                    return this.originalAlpha;
                }

                @Override // ir.eitaa.ui.ActionBar.SimpleTextView
                public void setFullAlpha(float value) {
                    super.setFullAlpha(value);
                    for (int i2 = 0; i2 < GroupCallUserCell.this.statusTextView.length; i2++) {
                        GroupCallUserCell.this.statusTextView[i2].setAlpha(GroupCallUserCell.this.statusTextView[i2].getAlpha());
                    }
                }
            };
            this.statusTextView[i].setTextSize(15);
            this.statusTextView[i].setTypeface(AndroidUtilities.getFontFamily(false));
            this.statusTextView[i].setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            if (i == 4) {
                this.statusTextView[i].setBuildFullLayout(true);
                this.statusTextView[i].setTextColor(Theme.getColor("voipgroup_mutedIcon"));
                SimpleTextView simpleTextView3 = this.statusTextView[i];
                boolean z4 = LocaleController.isRTL;
                addView(simpleTextView3, LayoutHelper.createFrame(-1, -2.0f, (z4 ? 5 : 3) | 48, z4 ? 54.0f : 67.0f, 32.0f, z4 ? 67.0f : 54.0f, 0.0f));
            } else {
                if (i == 0) {
                    this.statusTextView[i].setTextColor(Theme.getColor("voipgroup_listeningText"));
                    this.statusTextView[i].setText(LocaleController.getString("Listening", R.string.Listening));
                } else if (i == 1) {
                    this.statusTextView[i].setTextColor(Theme.getColor("voipgroup_speakingText"));
                    this.statusTextView[i].setText(LocaleController.getString("Speaking", R.string.Speaking));
                    this.statusTextView[i].setDrawablePadding(AndroidUtilities.dp(2.0f));
                } else if (i == 2) {
                    this.statusTextView[i].setTextColor(Theme.getColor("voipgroup_mutedByAdminIcon"));
                    this.statusTextView[i].setText(LocaleController.getString("VoipGroupMutedForMe", R.string.VoipGroupMutedForMe));
                } else if (i == 3) {
                    this.statusTextView[i].setTextColor(Theme.getColor("voipgroup_listeningText"));
                    this.statusTextView[i].setText(LocaleController.getString("WantsToSpeak", R.string.WantsToSpeak));
                }
                SimpleTextView simpleTextView4 = this.statusTextView[i];
                boolean z5 = LocaleController.isRTL;
                addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z5 ? 5 : 3) | 48, z5 ? 54.0f : 67.0f, 32.0f, z5 ? 67.0f : 54.0f, 0.0f));
            }
            i++;
        }
        SimpleTextView simpleTextView5 = new SimpleTextView(context);
        this.fullAboutTextView = simpleTextView5;
        simpleTextView5.setMaxLines(3);
        this.fullAboutTextView.setTextSize(15);
        this.fullAboutTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.fullAboutTextView.setTextColor(Theme.getColor("voipgroup_mutedIcon"));
        this.fullAboutTextView.setVisibility(8);
        addView(this.fullAboutTextView, LayoutHelper.createFrame(-1, 60.0f, (LocaleController.isRTL ? 5 : 3) | 48, 14.0f, 32.0f, 14.0f, 0.0f));
        this.muteDrawable = new RLottieDrawable(R.raw.voice_outlined2, "2131624058", AndroidUtilities.dp(34.0f), AndroidUtilities.dp(32.0f), true, (int[]) null);
        this.shakeHandDrawable = new RLottieDrawable(R.raw.hand_1, "2131623981", AndroidUtilities.dp(34.0f), AndroidUtilities.dp(32.0f), true, (int[]) null);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.muteButton = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.muteButton.setAnimation(this.muteDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            RippleDrawable rippleDrawable = (RippleDrawable) Theme.createSelectorDrawable(Theme.getColor(this.grayIconColor) & 620756991);
            Theme.setRippleDrawableForceSoftware(rippleDrawable);
            this.muteButton.setBackground(rippleDrawable);
        }
        this.muteButton.setImportantForAccessibility(2);
        addView(this.muteButton, LayoutHelper.createFrame(48, -1.0f, (LocaleController.isRTL ? 3 : 5) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
        this.muteButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$e-Ol3iVpS5tkprpVtf8bi-niQPI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$5$GroupCallUserCell(view);
            }
        });
        this.avatarWavesDrawable = new AvatarWavesDrawable(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(29.0f));
        setWillNotDraw(false);
        setFocusable(true);
    }

    public int getClipHeight() {
        SimpleTextView simpleTextView;
        if (!TextUtils.isEmpty(this.fullAboutTextView.getText()) && this.hasAvatar) {
            simpleTextView = this.fullAboutTextView;
        } else {
            simpleTextView = this.statusTextView[4];
        }
        if (simpleTextView.getLineCount() > 1) {
            return simpleTextView.getTop() + simpleTextView.getTextHeight() + AndroidUtilities.dp(8.0f);
        }
        return getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.updateRunnableScheduled) {
            AndroidUtilities.cancelRunOnUIThread(this.updateRunnable);
            this.updateRunnableScheduled = false;
        }
        if (this.updateVoiceRunnableScheduled) {
            AndroidUtilities.cancelRunOnUIThread(this.updateVoiceRunnable);
            this.updateVoiceRunnableScheduled = false;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public boolean isSelfUser() {
        long j = this.selfId;
        if (j > 0) {
            TLRPC$User tLRPC$User = this.currentUser;
            return tLRPC$User != null && tLRPC$User.id == j;
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        return tLRPC$Chat != null && tLRPC$Chat.id == (-j);
    }

    public boolean isHandRaised() {
        return this.lastRaisedHand;
    }

    public CharSequence getName() {
        return this.nameTextView.getText();
    }

    public boolean hasAvatarSet() {
        return this.avatarImageView.getImageReceiver().hasNotThumb();
    }

    public void setData(AccountInstance account, TLRPC$TL_groupCallParticipant groupCallParticipant, ChatObject.Call call, long self, TLRPC$FileLocation uploadingAvatar, boolean animated) {
        this.currentCall = call;
        this.accountInstance = account;
        this.selfId = self;
        this.participant = groupCallParticipant;
        long peerId = MessageObject.getPeerId(groupCallParticipant.peer);
        if (peerId > 0) {
            TLRPC$User user = this.accountInstance.getMessagesController().getUser(Long.valueOf(peerId));
            this.currentUser = user;
            this.currentChat = null;
            this.avatarDrawable.setInfo(user);
            this.nameTextView.setText(UserObject.getUserName(this.currentUser));
            SimpleTextView simpleTextView = this.nameTextView;
            TLRPC$User tLRPC$User = this.currentUser;
            simpleTextView.setRightDrawable((tLRPC$User == null || !tLRPC$User.verified) ? null : new VerifiedDrawable(getContext()));
            this.avatarImageView.getImageReceiver().setCurrentAccount(account.getCurrentAccount());
            if (uploadingAvatar != null) {
                this.hasAvatar = true;
                this.avatarImageView.setImage(ImageLocation.getForLocal(uploadingAvatar), "50_50", this.avatarDrawable, (Object) null);
            } else {
                ImageLocation forUser = ImageLocation.getForUser(this.currentUser, 1);
                this.hasAvatar = forUser != null;
                this.avatarImageView.setImage(forUser, "50_50", this.avatarDrawable, this.currentUser);
            }
        } else {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-peerId));
            this.currentChat = chat;
            this.currentUser = null;
            this.avatarDrawable.setInfo(chat);
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat != null) {
                this.nameTextView.setText(tLRPC$Chat.title);
                this.nameTextView.setRightDrawable(this.currentChat.verified ? new VerifiedDrawable(getContext()) : null);
                this.avatarImageView.getImageReceiver().setCurrentAccount(account.getCurrentAccount());
                if (uploadingAvatar != null) {
                    this.hasAvatar = true;
                    this.avatarImageView.setImage(ImageLocation.getForLocal(uploadingAvatar), "50_50", this.avatarDrawable, (Object) null);
                } else {
                    ImageLocation forChat = ImageLocation.getForChat(this.currentChat, 1);
                    this.hasAvatar = forChat != null;
                    this.avatarImageView.setImage(forChat, "50_50", this.avatarDrawable, this.currentChat);
                }
            }
        }
        applyParticipantChanges(animated);
    }

    public void setDrawDivider(boolean draw) {
        this.needDivider = draw;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyParticipantChanges(false);
    }

    public TLRPC$TL_groupCallParticipant getParticipant() {
        return this.participant;
    }

    public void setAmplitude(double value) {
        if (value > 1.5d) {
            if (this.updateRunnableScheduled) {
                AndroidUtilities.cancelRunOnUIThread(this.updateRunnable);
            }
            if (!this.isSpeaking) {
                this.isSpeaking = true;
                applyParticipantChanges(true);
            }
            this.avatarWavesDrawable.setAmplitude(value);
            AndroidUtilities.runOnUIThread(this.updateRunnable, 500L);
            this.updateRunnableScheduled = true;
            return;
        }
        this.avatarWavesDrawable.setAmplitude(0.0d);
    }

    public boolean clickMuteButton() {
        if (!this.muteButton.isEnabled()) {
            return false;
        }
        this.muteButton.callOnClick();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(58.0f), 1073741824));
    }

    public void applyParticipantChanges(boolean animated) {
        applyParticipantChanges(animated, false);
    }

    public void setGrayIconColor(String key, int value) {
        if (!this.grayIconColor.equals(key)) {
            if (this.currentIconGray) {
                this.lastMuteColor = Theme.getColor(key);
            }
            this.grayIconColor = key;
        }
        if (this.currentIconGray) {
            this.muteButton.setColorFilter(new PorterDuffColorFilter(value, PorterDuff.Mode.MULTIPLY));
            Theme.setSelectorDrawableColor(this.muteButton.getDrawable(), value & 620756991, true);
        }
    }

    public void setAboutVisibleProgress(int color, float progress) {
        if (TextUtils.isEmpty(this.statusTextView[4].getText())) {
            progress = 0.0f;
        }
        this.statusTextView[4].setFullAlpha(progress);
        this.statusTextView[4].setFullLayoutAdditionalWidth(0, 0);
        invalidate();
    }

    public void setAboutVisible(boolean visible) {
        if (visible) {
            this.statusTextView[4].setTranslationY(0.0f);
        } else {
            this.statusTextView[4].setFullAlpha(0.0f);
        }
        invalidate();
    }

    private void applyParticipantChanges(boolean animated, boolean internal) throws InterruptedException {
        boolean z;
        String str;
        final int color;
        final int i;
        boolean z2;
        ArrayList arrayList;
        float fDp;
        boolean customEndFrame;
        int i2;
        if (this.currentCall == null) {
            return;
        }
        boolean z3 = false;
        this.muteButton.setEnabled((isSelfUser() && this.participant.raise_hand_rating == 0) ? false : true);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participant;
        if (jElapsedRealtime - tLRPC$TL_groupCallParticipant.lastVoiceUpdateTime < 500) {
            z = tLRPC$TL_groupCallParticipant.hasVoiceDelayed;
        } else {
            z = tLRPC$TL_groupCallParticipant.hasVoice;
        }
        if (!internal) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.participant.lastSpeakTime;
            boolean z4 = jUptimeMillis < 500;
            if (!this.isSpeaking || !z4 || z) {
                this.isSpeaking = z4;
                if (this.updateRunnableScheduled) {
                    AndroidUtilities.cancelRunOnUIThread(this.updateRunnable);
                    this.updateRunnableScheduled = false;
                }
                if (this.isSpeaking) {
                    AndroidUtilities.runOnUIThread(this.updateRunnable, 500 - jUptimeMillis);
                    this.updateRunnableScheduled = true;
                }
            }
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.currentCall.participants.get(MessageObject.getPeerId(this.participant.peer));
        if (tLRPC$TL_groupCallParticipant2 != null) {
            this.participant = tLRPC$TL_groupCallParticipant2;
        }
        boolean z5 = this.participant.muted_by_you && !isSelfUser();
        boolean z6 = !isSelfUser() ? (!this.participant.muted || (this.isSpeaking && z)) && !z5 : VoIPService.getSharedInstance() == null || !VoIPService.getSharedInstance().isMicMute() || (this.isSpeaking && z);
        if (z6) {
            boolean z7 = this.participant.can_self_unmute;
        }
        boolean z8 = !TextUtils.isEmpty(this.participant.about);
        this.currentIconGray = false;
        AndroidUtilities.cancelRunOnUIThread(this.checkRaiseRunnable);
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant3 = this.participant;
        if ((tLRPC$TL_groupCallParticipant3.muted && !this.isSpeaking) || z5) {
            boolean z9 = tLRPC$TL_groupCallParticipant3.can_self_unmute;
            if (!z9 || z5) {
                boolean z10 = (z9 || tLRPC$TL_groupCallParticipant3.raise_hand_rating == 0) ? false : true;
                if (z10) {
                    int color2 = Theme.getColor("voipgroup_listeningText");
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    str = "voipgroup_listeningText";
                    long j = this.participant.lastRaiseHandDate;
                    long j2 = jElapsedRealtime2 - j;
                    if (j == 0 || j2 > 5000) {
                        i2 = z5 ? 2 : z8 ? 4 : 0;
                    } else {
                        AndroidUtilities.runOnUIThread(this.checkRaiseRunnable, 5000 - j2);
                        i2 = 3;
                    }
                    i = i2;
                    z2 = z10;
                    color = color2;
                } else {
                    str = "voipgroup_listeningText";
                    int color3 = Theme.getColor("voipgroup_mutedByAdminIcon");
                    int i3 = z5 ? 2 : z8 ? 4 : 0;
                    z2 = z10;
                    color = color3;
                    i = i3;
                }
            } else {
                color = Theme.getColor(this.grayIconColor);
                this.currentIconGray = true;
                i = z8 ? 4 : 0;
                str = "voipgroup_listeningText";
                z2 = false;
            }
        } else {
            str = "voipgroup_listeningText";
            if (this.isSpeaking && z) {
                color = Theme.getColor("voipgroup_speakingText");
                z2 = false;
                i = 1;
            } else {
                color = Theme.getColor(this.grayIconColor);
                int i4 = z8 ? 4 : 0;
                this.currentIconGray = true;
                i = i4;
                z2 = false;
            }
        }
        if (!isSelfUser()) {
            this.statusTextView[4].setTextColor(Theme.getColor(this.grayIconColor));
        }
        if (isSelfUser()) {
            if (!z8 && !this.hasAvatar) {
                if (this.currentUser != null) {
                    this.statusTextView[4].setText(LocaleController.getString("TapToAddPhotoOrBio", R.string.TapToAddPhotoOrBio));
                } else {
                    this.statusTextView[4].setText(LocaleController.getString("TapToAddPhotoOrDescription", R.string.TapToAddPhotoOrDescription));
                }
                this.statusTextView[4].setTextColor(Theme.getColor(this.grayIconColor));
            } else if (!z8) {
                if (this.currentUser != null) {
                    this.statusTextView[4].setText(LocaleController.getString("TapToAddBio", R.string.TapToAddBio));
                } else {
                    this.statusTextView[4].setText(LocaleController.getString("TapToAddDescription", R.string.TapToAddDescription));
                }
                this.statusTextView[4].setTextColor(Theme.getColor(this.grayIconColor));
            } else if (!this.hasAvatar) {
                this.statusTextView[4].setText(LocaleController.getString("TapToAddPhoto", R.string.TapToAddPhoto));
                this.statusTextView[4].setTextColor(Theme.getColor(this.grayIconColor));
            } else {
                this.statusTextView[4].setText(LocaleController.getString("ThisIsYou", R.string.ThisIsYou));
                this.statusTextView[4].setTextColor(Theme.getColor(str));
            }
            if (z8) {
                this.fullAboutTextView.setText(AndroidUtilities.replaceNewLines(this.participant.about));
                this.fullAboutTextView.setTextColor(Theme.getColor("voipgroup_mutedIcon"));
            } else {
                this.fullAboutTextView.setText(this.statusTextView[i].getText());
                this.fullAboutTextView.setTextColor(this.statusTextView[i].getTextColor());
            }
        } else if (z8) {
            this.statusTextView[4].setText(AndroidUtilities.replaceNewLines(this.participant.about));
            this.fullAboutTextView.setText("");
        } else {
            this.statusTextView[4].setText("");
            this.fullAboutTextView.setText("");
        }
        AnimatorSet animatorSet = this.animatorSet;
        boolean z11 = (animatorSet == null || (i == this.currentStatus && this.lastMuteColor == color)) ? false : true;
        if ((!animated || z11) && animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        if (animated && this.lastMuteColor == color && !z11) {
            arrayList = null;
        } else if (animated) {
            arrayList = new ArrayList();
            final int i5 = this.lastMuteColor;
            this.lastMuteColor = color;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$GroupCallUserCell$VEiPUhaA2qWGSZAWbOhC4rm-oG8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$applyParticipantChanges$6$GroupCallUserCell(i5, color, valueAnimator);
                }
            });
            arrayList.add(valueAnimatorOfFloat);
        } else {
            RLottieImageView rLottieImageView = this.muteButton;
            this.lastMuteColor = color;
            rLottieImageView.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            Theme.setSelectorDrawableColor(this.muteButton.getDrawable(), color & 620756991, true);
            arrayList = null;
        }
        if (i == 1) {
            int participantVolume = ChatObject.getParticipantVolume(this.participant);
            int i6 = participantVolume / 100;
            if (i6 != 100) {
                this.statusTextView[1].setLeftDrawable(this.speakingDrawable);
                SimpleTextView simpleTextView = this.statusTextView[1];
                Object[] objArr = new Object[1];
                if (participantVolume < 100) {
                    i6 = 1;
                }
                objArr[0] = Integer.valueOf(i6);
                simpleTextView.setText(LocaleController.formatString("SpeakingWithVolume", R.string.SpeakingWithVolume, objArr));
            } else {
                this.statusTextView[1].setLeftDrawable((Drawable) null);
                this.statusTextView[1].setText(LocaleController.getString("Speaking", R.string.Speaking));
            }
        }
        if (isSelfUser()) {
            applyStatus(4);
        } else if (!animated || i != this.currentStatus || z11) {
            if (animated) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (i != 0) {
                    int i7 = 0;
                    while (true) {
                        SimpleTextView[] simpleTextViewArr = this.statusTextView;
                        if (i7 >= simpleTextViewArr.length) {
                            break;
                        }
                        SimpleTextView simpleTextView2 = simpleTextViewArr[i7];
                        Property property = View.TRANSLATION_Y;
                        float[] fArr = new float[1];
                        if (i7 == i) {
                            fDp = 0.0f;
                        } else {
                            fDp = AndroidUtilities.dp(i7 == 0 ? 2.0f : -2.0f);
                        }
                        fArr[0] = fDp;
                        arrayList.add(ObjectAnimator.ofFloat(simpleTextView2, (Property<SimpleTextView, Float>) property, fArr));
                        SimpleTextView simpleTextView3 = this.statusTextView[i7];
                        Property property2 = View.ALPHA;
                        float[] fArr2 = new float[1];
                        fArr2[0] = i7 == i ? 1.0f : 0.0f;
                        arrayList.add(ObjectAnimator.ofFloat(simpleTextView3, (Property<SimpleTextView, Float>) property2, fArr2));
                        i7++;
                    }
                } else {
                    int i8 = 0;
                    while (true) {
                        SimpleTextView[] simpleTextViewArr2 = this.statusTextView;
                        if (i8 >= simpleTextViewArr2.length) {
                            break;
                        }
                        SimpleTextView simpleTextView4 = simpleTextViewArr2[i8];
                        Property property3 = View.TRANSLATION_Y;
                        float[] fArr3 = new float[1];
                        fArr3[0] = i8 == i ? 0.0f : AndroidUtilities.dp(-2.0f);
                        arrayList.add(ObjectAnimator.ofFloat(simpleTextView4, (Property<SimpleTextView, Float>) property3, fArr3));
                        SimpleTextView simpleTextView5 = this.statusTextView[i8];
                        Property property4 = View.ALPHA;
                        float[] fArr4 = new float[1];
                        fArr4[0] = i8 == i ? 1.0f : 0.0f;
                        arrayList.add(ObjectAnimator.ofFloat(simpleTextView5, (Property<SimpleTextView, Float>) property4, fArr4));
                        i8++;
                    }
                }
            } else {
                applyStatus(i);
            }
            this.currentStatus = i;
        }
        this.avatarWavesDrawable.setMuted(i, animated);
        if (arrayList != null) {
            AnimatorSet animatorSet2 = this.animatorSet;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                this.animatorSet = null;
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.animatorSet = animatorSet3;
            animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.GroupCallUserCell.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (!GroupCallUserCell.this.isSelfUser()) {
                        GroupCallUserCell.this.applyStatus(i);
                    }
                    GroupCallUserCell.this.animatorSet = null;
                }
            });
            this.animatorSet.playTogether(arrayList);
            this.animatorSet.setDuration(180L);
            this.animatorSet.start();
        }
        if (!animated || this.lastMuted != z6 || this.lastRaisedHand != z2) {
            if (z2) {
                customEndFrame = this.muteDrawable.setCustomEndFrame(84);
                if (animated) {
                    this.muteDrawable.setOnFinishCallback(this.raiseHandCallback, 83);
                } else {
                    this.muteDrawable.setOnFinishCallback(null, 0);
                }
            } else {
                this.muteButton.setAnimation(this.muteDrawable);
                this.muteDrawable.setOnFinishCallback(null, 0);
                if (z6 && this.lastRaisedHand) {
                    customEndFrame = this.muteDrawable.setCustomEndFrame(21);
                } else {
                    customEndFrame = this.muteDrawable.setCustomEndFrame(z6 ? 64 : 42);
                }
            }
            if (animated) {
                if (customEndFrame) {
                    if (i == 3) {
                        this.muteDrawable.setCurrentFrame(63);
                    } else if (z6 && this.lastRaisedHand && !z2) {
                        this.muteDrawable.setCurrentFrame(0);
                    } else if (z6) {
                        this.muteDrawable.setCurrentFrame(43);
                    } else {
                        this.muteDrawable.setCurrentFrame(21);
                    }
                }
                this.muteButton.playAnimation();
            } else {
                RLottieDrawable rLottieDrawable = this.muteDrawable;
                rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
                this.muteButton.invalidate();
            }
            this.lastMuted = z6;
            this.lastRaisedHand = z2;
        }
        if (!this.isSpeaking) {
            this.avatarWavesDrawable.setAmplitude(0.0d);
        }
        AvatarWavesDrawable avatarWavesDrawable = this.avatarWavesDrawable;
        if (this.isSpeaking && this.progressToAvatarPreview == 0.0f) {
            z3 = true;
        }
        avatarWavesDrawable.setShowWaves(z3, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyParticipantChanges$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyParticipantChanges$6$GroupCallUserCell(int i, int i2, ValueAnimator valueAnimator) {
        int offsetColor = AndroidUtilities.getOffsetColor(i, i2, valueAnimator.getAnimatedFraction(), 1.0f);
        this.muteButton.setColorFilter(new PorterDuffColorFilter(offsetColor, PorterDuff.Mode.MULTIPLY));
        Theme.setSelectorDrawableColor(this.muteButton.getDrawable(), offsetColor & 620756991, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyStatus(int newStatus) {
        float fDp;
        int i = 0;
        if (newStatus == 0) {
            while (true) {
                SimpleTextView[] simpleTextViewArr = this.statusTextView;
                if (i >= simpleTextViewArr.length) {
                    return;
                }
                simpleTextViewArr[i].setTranslationY(i == newStatus ? 0.0f : AndroidUtilities.dp(-2.0f));
                this.statusTextView[i].setAlpha(i == newStatus ? 1.0f : 0.0f);
                i++;
            }
        } else {
            while (true) {
                SimpleTextView[] simpleTextViewArr2 = this.statusTextView;
                if (i >= simpleTextViewArr2.length) {
                    return;
                }
                SimpleTextView simpleTextView = simpleTextViewArr2[i];
                if (i == newStatus) {
                    fDp = 0.0f;
                } else {
                    fDp = AndroidUtilities.dp(i == 0 ? 2.0f : -2.0f);
                }
                simpleTextView.setTranslationY(fDp);
                this.statusTextView[i].setAlpha(i == newStatus ? 1.0f : 0.0f);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.needDivider) {
            float f = this.progressToAvatarPreview;
            if (f != 0.0f) {
                this.dividerPaint.setAlpha((int) ((1.0f - f) * 255.0f));
            } else {
                this.dividerPaint.setAlpha((int) ((1.0f - this.statusTextView[4].getFullAlpha()) * 255.0f));
            }
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(68.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(68.0f) : 0), getMeasuredHeight() - 1, this.dividerPaint);
        }
        int left = this.avatarImageView.getLeft() + (this.avatarImageView.getMeasuredWidth() / 2);
        int top = this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2);
        this.avatarWavesDrawable.update();
        if (this.progressToAvatarPreview == 0.0f) {
            this.avatarWavesDrawable.draw(canvas, left, top, this);
        }
        this.avatarImageView.setScaleX(this.avatarWavesDrawable.getAvatarScale());
        this.avatarImageView.setScaleY(this.avatarWavesDrawable.getAvatarScale());
        this.avatarProgressView.setScaleX(this.avatarWavesDrawable.getAvatarScale());
        this.avatarProgressView.setScaleY(this.avatarWavesDrawable.getAvatarScale());
        super.dispatchDraw(canvas);
    }

    public static class AvatarWavesDrawable {
        float amplitude;
        float animateAmplitudeDiff;
        float animateToAmplitude;
        private BlobDrawable blobDrawable2;
        private boolean hasCustomColor;
        private int isMuted;
        boolean showWaves;
        float wavesEnter = 0.0f;
        private float progressToMuted = 0.0f;
        boolean invalidateColor = true;
        private BlobDrawable blobDrawable = new BlobDrawable(6);

        public AvatarWavesDrawable(int minRadius, int maxRadius) {
            BlobDrawable blobDrawable = new BlobDrawable(8);
            this.blobDrawable2 = blobDrawable;
            BlobDrawable blobDrawable2 = this.blobDrawable;
            float f = minRadius;
            blobDrawable2.minRadius = f;
            float f2 = maxRadius;
            blobDrawable2.maxRadius = f2;
            blobDrawable.minRadius = f;
            blobDrawable.maxRadius = f2;
            blobDrawable2.generateBlob();
            this.blobDrawable2.generateBlob();
            this.blobDrawable.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_speakingText"), 38));
            this.blobDrawable2.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_speakingText"), 38));
        }

        public void update() {
            float f = this.animateToAmplitude;
            float f2 = this.amplitude;
            if (f != f2) {
                float f3 = this.animateAmplitudeDiff;
                float f4 = f2 + (16.0f * f3);
                this.amplitude = f4;
                if (f3 > 0.0f) {
                    if (f4 > f) {
                        this.amplitude = f;
                    }
                } else if (f4 < f) {
                    this.amplitude = f;
                }
            }
            boolean z = this.showWaves;
            if (z) {
                float f5 = this.wavesEnter;
                if (f5 != 1.0f) {
                    float f6 = f5 + 0.045714285f;
                    this.wavesEnter = f6;
                    if (f6 > 1.0f) {
                        this.wavesEnter = 1.0f;
                        return;
                    }
                    return;
                }
            }
            if (z) {
                return;
            }
            float f7 = this.wavesEnter;
            if (f7 != 0.0f) {
                float f8 = f7 - 0.045714285f;
                this.wavesEnter = f8;
                if (f8 < 0.0f) {
                    this.wavesEnter = 0.0f;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void draw(android.graphics.Canvas r8, float r9, float r10, android.view.View r11) {
            /*
                r7 = this;
                float r0 = r7.amplitude
                r1 = 1053609165(0x3ecccccd, float:0.4)
                float r0 = r0 * r1
                r1 = 1061997773(0x3f4ccccd, float:0.8)
                float r0 = r0 + r1
                boolean r1 = r7.showWaves
                r2 = 0
                if (r1 != 0) goto L16
                float r1 = r7.wavesEnter
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 == 0) goto La5
            L16:
                r8.save()
                ir.eitaa.ui.Components.CubicBezierInterpolator r1 = ir.eitaa.ui.Components.CubicBezierInterpolator.DEFAULT
                float r3 = r7.wavesEnter
                float r1 = r1.getInterpolation(r3)
                float r0 = r0 * r1
                r8.scale(r0, r0, r9, r10)
                boolean r0 = r7.hasCustomColor
                r1 = 1065353216(0x3f800000, float:1.0)
                if (r0 != 0) goto L84
                int r0 = r7.isMuted
                r3 = 1037726734(0x3dda740e, float:0.10666667)
                r4 = 1
                if (r0 == r4) goto L46
                float r5 = r7.progressToMuted
                int r6 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r6 == 0) goto L46
                float r5 = r5 + r3
                r7.progressToMuted = r5
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 <= 0) goto L43
                r7.progressToMuted = r1
            L43:
                r7.invalidateColor = r4
                goto L59
            L46:
                if (r0 != r4) goto L59
                float r0 = r7.progressToMuted
                int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r5 == 0) goto L59
                float r0 = r0 - r3
                r7.progressToMuted = r0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 >= 0) goto L57
                r7.progressToMuted = r2
            L57:
                r7.invalidateColor = r4
            L59:
                boolean r0 = r7.invalidateColor
                if (r0 == 0) goto L84
                java.lang.String r0 = "voipgroup_speakingText"
                int r0 = ir.eitaa.ui.ActionBar.Theme.getColor(r0)
                int r3 = r7.isMuted
                r4 = 2
                if (r3 != r4) goto L6b
                java.lang.String r3 = "voipgroup_mutedByAdminIcon"
                goto L6d
            L6b:
                java.lang.String r3 = "voipgroup_listeningText"
            L6d:
                int r3 = ir.eitaa.ui.ActionBar.Theme.getColor(r3)
                float r4 = r7.progressToMuted
                int r0 = androidx.core.graphics.ColorUtils.blendARGB(r0, r3, r4)
                ir.eitaa.ui.Components.BlobDrawable r3 = r7.blobDrawable
                android.graphics.Paint r3 = r3.paint
                r4 = 38
                int r0 = androidx.core.graphics.ColorUtils.setAlphaComponent(r0, r4)
                r3.setColor(r0)
            L84:
                ir.eitaa.ui.Components.BlobDrawable r0 = r7.blobDrawable
                float r3 = r7.amplitude
                r0.update(r3, r1)
                ir.eitaa.ui.Components.BlobDrawable r0 = r7.blobDrawable
                android.graphics.Paint r3 = r0.paint
                r0.draw(r9, r10, r8, r3)
                ir.eitaa.ui.Components.BlobDrawable r0 = r7.blobDrawable2
                float r3 = r7.amplitude
                r0.update(r3, r1)
                ir.eitaa.ui.Components.BlobDrawable r0 = r7.blobDrawable2
                ir.eitaa.ui.Components.BlobDrawable r1 = r7.blobDrawable
                android.graphics.Paint r1 = r1.paint
                r0.draw(r9, r10, r8, r1)
                r8.restore()
            La5:
                float r8 = r7.wavesEnter
                int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r8 == 0) goto Lae
                r11.invalidate()
            Lae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.GroupCallUserCell.AvatarWavesDrawable.draw(android.graphics.Canvas, float, float, android.view.View):void");
        }

        public float getAvatarScale() {
            float f = (this.amplitude * 0.2f) + 0.9f;
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.wavesEnter);
            return (f * interpolation) + ((1.0f - interpolation) * 1.0f);
        }

        public void setShowWaves(boolean show, View parentView) {
            if (this.showWaves != show) {
                parentView.invalidate();
            }
            this.showWaves = show;
        }

        public void setAmplitude(double value) {
            float f = ((float) value) / 80.0f;
            float f2 = 0.0f;
            if (!this.showWaves) {
                f = 0.0f;
            }
            if (f > 1.0f) {
                f2 = 1.0f;
            } else if (f >= 0.0f) {
                f2 = f;
            }
            this.animateToAmplitude = f2;
            this.animateAmplitudeDiff = (f2 - this.amplitude) / 200.0f;
        }

        public void setColor(int color) {
            this.hasCustomColor = true;
            this.blobDrawable.paint.setColor(color);
        }

        public void setMuted(int status, boolean animated) {
            this.isMuted = status;
            if (!animated) {
                this.progressToMuted = status != 1 ? 1.0f : 0.0f;
            }
            this.invalidateColor = true;
        }
    }

    public BackupImageView getAvatarImageView() {
        return this.avatarImageView;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i;
        String str;
        super.onInitializeAccessibilityNodeInfo(info);
        if (!info.isEnabled() || Build.VERSION.SDK_INT < 21) {
            return;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participant;
        if (!tLRPC$TL_groupCallParticipant.muted || tLRPC$TL_groupCallParticipant.can_self_unmute) {
            i = R.string.VoipMute;
            str = "VoipMute";
        } else {
            i = R.string.VoipUnmute;
            str = "VoipUnmute";
        }
        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString(str, i)));
    }

    public long getPeerId() {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participant;
        if (tLRPC$TL_groupCallParticipant == null) {
            return 0L;
        }
        return MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
    }
}
