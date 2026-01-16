package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AudioPlayerAlert;
import ir.eitaa.ui.Components.SharingLocationsAlert;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.GroupCallActivity;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.LocationActivity;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FragmentContextView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, VoIPService.StateListener {
    private final int account;
    private FragmentContextView additionalContextView;
    private int animationIndex;
    private AnimatorSet animatorSet;
    private View applyingView;
    private AvatarsImageView avatars;
    private boolean checkCallAfterAnimation;
    private boolean checkImportAfterAnimation;
    private Runnable checkLocationRunnable;
    private boolean checkPlayerAfterAnimation;
    private ImageView closeButton;
    float collapseProgress;
    boolean collapseTransition;
    private int currentProgress;
    private int currentStyle;
    private FragmentContextViewDelegate delegate;
    boolean drawOverlay;
    float extraHeight;
    private boolean firstLocationsLoaded;
    private BaseFragment fragment;
    private FrameLayout frameLayout;
    private Paint gradientPaint;
    private TextPaint gradientTextPaint;
    private int gradientWidth;
    private RLottieImageView importingImageView;
    private boolean isLocation;
    private boolean isMusic;
    private boolean isMuted;
    private TextView joinButton;
    private int lastLocationSharingCount;
    private MessageObject lastMessageObject;
    private String lastString;
    private LinearGradient linearGradient;
    private Matrix matrix;
    float micAmplitude;
    private RLottieImageView muteButton;
    private RLottieDrawable muteDrawable;
    private ImageView playButton;
    private PlayPauseDrawable playPauseDrawable;
    private ActionBarMenuItem playbackSpeedButton;
    private RectF rect;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean scheduleRunnableScheduled;
    private View selector;
    private View shadow;
    float speakerAmplitude;
    private ActionBarMenuSubItem[] speedItems;
    private AudioPlayerAlert.ClippingTextViewSwitcher subtitleTextView;
    private boolean supportsCalls;
    private StaticLayout timeLayout;
    private AudioPlayerAlert.ClippingTextViewSwitcher titleTextView;
    private float topPadding;
    private final Runnable updateScheduleTimeRunnable;
    private boolean visible;
    boolean wasDraw;

    public interface FragmentContextViewDelegate {
        void onAnimation(boolean start, boolean show);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraSwitch(boolean z) {
        VoIPService.StateListener.CC.$default$onCameraSwitch(this, z);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onMediaStateUpdated(int i, int i2) {
        VoIPService.StateListener.CC.$default$onMediaStateUpdated(this, i, i2);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onScreenOnChange(boolean z) {
        VoIPService.StateListener.CC.$default$onScreenOnChange(this, z);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onSignalBarsCountChanged(int i) {
        VoIPService.StateListener.CC.$default$onSignalBarsCountChanged(this, i);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onVideoAvailableChange(boolean z) {
        VoIPService.StateListener.CC.$default$onVideoAvailableChange(this, z);
    }

    protected void playbackSpeedChanged(float value) {
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() throws InterruptedException {
        boolean z = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().isMicMute();
        if (this.isMuted != z) {
            this.isMuted = z;
            this.muteDrawable.setCustomEndFrame(z ? 15 : 29);
            RLottieDrawable rLottieDrawable = this.muteDrawable;
            rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
            this.muteButton.invalidate();
            Theme.getFragmentContextViewWavesDrawable().updateState(this.visible);
        }
        if (this.isMuted) {
            this.micAmplitude = 0.0f;
            Theme.getFragmentContextViewWavesDrawable().setAmplitude(0.0f);
        }
    }

    public FragmentContextView(Context context, BaseFragment parentFragment, boolean location) {
        this(context, parentFragment, null, location, null);
    }

    public FragmentContextView(Context context, BaseFragment parentFragment, boolean location, Theme.ResourcesProvider resourcesProvider) {
        this(context, parentFragment, null, location, resourcesProvider);
    }

    public FragmentContextView(final Context context, final BaseFragment parentFragment, View paddingView, boolean location, final Theme.ResourcesProvider resourcesProvider) {
        int i;
        float f;
        super(context);
        this.speedItems = new ActionBarMenuSubItem[4];
        this.currentProgress = -1;
        this.currentStyle = -1;
        this.supportsCalls = true;
        this.rect = new RectF();
        this.updateScheduleTimeRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.FragmentContextView.1
            @Override // java.lang.Runnable
            public void run() {
                String fullDuration;
                if (FragmentContextView.this.gradientTextPaint == null || !(FragmentContextView.this.fragment instanceof ChatActivity)) {
                    FragmentContextView.this.scheduleRunnableScheduled = false;
                    return;
                }
                ChatObject.Call groupCall = ((ChatActivity) FragmentContextView.this.fragment).getGroupCall();
                if (groupCall == null || !groupCall.isScheduled()) {
                    FragmentContextView.this.timeLayout = null;
                    FragmentContextView.this.scheduleRunnableScheduled = false;
                    return;
                }
                int currentTime = FragmentContextView.this.fragment.getConnectionsManager().getCurrentTime();
                int i2 = groupCall.call.schedule_date;
                int i3 = i2 - currentTime;
                if (i3 >= 86400) {
                    fullDuration = LocaleController.formatPluralString("Days", Math.round(i3 / 86400.0f));
                } else {
                    fullDuration = AndroidUtilities.formatFullDuration(i2 - currentTime);
                }
                FragmentContextView.this.timeLayout = new StaticLayout(fullDuration, FragmentContextView.this.gradientTextPaint, (int) Math.ceil(FragmentContextView.this.gradientTextPaint.measureText(r2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                AndroidUtilities.runOnUIThread(FragmentContextView.this.updateScheduleTimeRunnable, 1000L);
                FragmentContextView.this.frameLayout.invalidate();
            }
        };
        this.account = UserConfig.selectedAccount;
        this.lastLocationSharingCount = -1;
        this.checkLocationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.FragmentContextView.2
            @Override // java.lang.Runnable
            public void run() {
                FragmentContextView.this.checkLocationString();
                AndroidUtilities.runOnUIThread(FragmentContextView.this.checkLocationRunnable, 1000L);
            }
        };
        this.animationIndex = -1;
        this.resourcesProvider = resourcesProvider;
        this.fragment = parentFragment;
        this.applyingView = paddingView;
        this.visible = true;
        this.isLocation = location;
        if (paddingView == null) {
            ((ViewGroup) parentFragment.getFragmentView()).setClipToPadding(false);
        }
        setTag(1);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.FragmentContextView.3
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                if (FragmentContextView.this.avatars == null || FragmentContextView.this.avatars.getVisibility() != 0) {
                    return;
                }
                FragmentContextView.this.avatars.invalidate();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f2;
                super.onDraw(canvas);
                if (FragmentContextView.this.currentStyle != 4 || FragmentContextView.this.timeLayout == null) {
                    return;
                }
                int iCeil = ((int) Math.ceil(FragmentContextView.this.timeLayout.getLineWidth(0))) + AndroidUtilities.dp(24.0f);
                if (iCeil != FragmentContextView.this.gradientWidth) {
                    FragmentContextView.this.linearGradient = new LinearGradient(0.0f, 0.0f, 1.7f * iCeil, 0.0f, new int[]{-10187532, -7575089, -2860679, -2860679}, new float[]{0.0f, 0.294f, 0.588f, 1.0f}, Shader.TileMode.CLAMP);
                    FragmentContextView.this.gradientPaint.setShader(FragmentContextView.this.linearGradient);
                    FragmentContextView.this.gradientWidth = iCeil;
                }
                ChatObject.Call groupCall = ((ChatActivity) FragmentContextView.this.fragment).getGroupCall();
                if (FragmentContextView.this.fragment == null || groupCall == null || !groupCall.isScheduled()) {
                    f2 = 0.0f;
                } else {
                    long currentTimeMillis = (groupCall.call.schedule_date * 1000) - FragmentContextView.this.fragment.getConnectionsManager().getCurrentTimeMillis();
                    f2 = currentTimeMillis >= 0 ? currentTimeMillis < 5000 ? 1.0f - (currentTimeMillis / 5000.0f) : 0.0f : 1.0f;
                    if (currentTimeMillis < 6000) {
                        invalidate();
                    }
                }
                FragmentContextView.this.matrix.reset();
                FragmentContextView.this.matrix.postTranslate((-FragmentContextView.this.gradientWidth) * 0.7f * f2, 0.0f);
                FragmentContextView.this.linearGradient.setLocalMatrix(FragmentContextView.this.matrix);
                int measuredWidth = (getMeasuredWidth() - iCeil) - AndroidUtilities.dp(10.0f);
                int iDp = AndroidUtilities.dp(12.0f);
                FragmentContextView.this.rect.set(0.0f, 0.0f, iCeil, AndroidUtilities.dp(24.0f));
                canvas.save();
                canvas.translate(measuredWidth, iDp);
                canvas.drawRoundRect(FragmentContextView.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), FragmentContextView.this.gradientPaint);
                canvas.translate(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f));
                FragmentContextView.this.timeLayout.draw(canvas);
                canvas.restore();
            }
        };
        this.frameLayout = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(-1, 36.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        View view = new View(context);
        this.selector = view;
        this.frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f));
        View view2 = new View(context);
        this.shadow = view2;
        view2.setBackgroundResource(R.drawable.blockpanel_shadow);
        addView(this.shadow, LayoutHelper.createFrame(-1, 2.0f, 51, 0.0f, 36.0f, 0.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.playButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.playButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("inappPlayerPlayPause"), PorterDuff.Mode.MULTIPLY));
        ImageView imageView2 = this.playButton;
        PlayPauseDrawable playPauseDrawable = new PlayPauseDrawable(14);
        this.playPauseDrawable = playPauseDrawable;
        imageView2.setImageDrawable(playPauseDrawable);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.playButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("inappPlayerPlayPause") & 436207615, 1, AndroidUtilities.dp(14.0f)));
        }
        addView(this.playButton, LayoutHelper.createFrame(36, 36, 51));
        this.playButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$MIFZOl2-t46pTGMc5yp9Y8DVlNY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) throws IOException {
                this.f$0.lambda$new$0$FragmentContextView(view3);
            }
        });
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.importingImageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.importingImageView.setAutoRepeat(true);
        this.importingImageView.setAnimation(R.raw.import_progress, 30, 30);
        this.importingImageView.setBackground(Theme.createCircleDrawable(AndroidUtilities.dp(22.0f), getThemedColor("inappPlayerPlayPause")));
        addView(this.importingImageView, LayoutHelper.createFrame(22, 22.0f, 51, 7.0f, 7.0f, 0.0f, 0.0f));
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = new AudioPlayerAlert.ClippingTextViewSwitcher(context) { // from class: ir.eitaa.ui.Components.FragmentContextView.4
            @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
            protected TextView createTextView() {
                TextView textView = new TextView(context);
                textView.setMaxLines(1);
                textView.setLines(1);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextSize(1, 15.0f);
                textView.setGravity(19);
                if (FragmentContextView.this.currentStyle != 0 && FragmentContextView.this.currentStyle != 2) {
                    if (FragmentContextView.this.currentStyle != 4) {
                        if (FragmentContextView.this.currentStyle == 1 || FragmentContextView.this.currentStyle == 3) {
                            textView.setGravity(19);
                            textView.setTextColor(FragmentContextView.this.getThemedColor("returnToCallText"));
                            textView.setTypeface(AndroidUtilities.getFontFamily(true));
                            textView.setTextSize(1, 14.0f);
                        }
                    } else {
                        textView.setGravity(51);
                        textView.setTextColor(FragmentContextView.this.getThemedColor("inappPlayerPerformer"));
                        textView.setTypeface(AndroidUtilities.getFontFamily(true));
                        textView.setTextSize(1, 15.0f);
                    }
                } else {
                    textView.setGravity(19);
                    textView.setTypeface(AndroidUtilities.getFontFamily(false));
                    textView.setTextSize(1, 15.0f);
                }
                return textView;
            }
        };
        this.titleTextView = clippingTextViewSwitcher;
        addView(clippingTextViewSwitcher, LayoutHelper.createFrame(-1, 36.0f, 51, 35.0f, 0.0f, 36.0f, 0.0f));
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher2 = new AudioPlayerAlert.ClippingTextViewSwitcher(context) { // from class: ir.eitaa.ui.Components.FragmentContextView.5
            @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
            protected TextView createTextView() {
                TextView textView = new TextView(context);
                textView.setMaxLines(1);
                textView.setLines(1);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setGravity(3);
                textView.setTextSize(1, 13.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(false));
                textView.setTextColor(FragmentContextView.this.getThemedColor("inappPlayerClose"));
                return textView;
            }
        };
        this.subtitleTextView = clippingTextViewSwitcher2;
        addView(clippingTextViewSwitcher2, LayoutHelper.createFrame(-1, 36.0f, 51, 35.0f, 10.0f, 36.0f, 0.0f));
        TextView textView = new TextView(context);
        this.joinButton = textView;
        textView.setText(LocaleController.getString("VoipChatJoin", R.string.VoipChatJoin));
        this.joinButton.setTextColor(getThemedColor("featuredStickers_buttonText"));
        this.joinButton.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), getThemedColor("featuredStickers_addButton"), getThemedColor("featuredStickers_addButtonPressed")));
        this.joinButton.setTextSize(1, 14.0f);
        this.joinButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.joinButton.setGravity(17);
        this.joinButton.setPadding(AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(14.0f), 0);
        addView(this.joinButton, LayoutHelper.createFrame(-2, 28.0f, 53, 0.0f, 10.0f, 14.0f, 0.0f));
        this.joinButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$PVl6paH1jxFQSGmncN2Pgq2GXAw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$1$FragmentContextView(view3);
            }
        });
        if (location) {
            i = 36;
            f = 14.0f;
        } else {
            i = 36;
            f = 14.0f;
            ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, (ActionBarMenu) null, 0, getThemedColor("dialogTextBlack"), resourcesProvider);
            this.playbackSpeedButton = actionBarMenuItem;
            actionBarMenuItem.setLongClickEnabled(false);
            this.playbackSpeedButton.setShowSubmenuByMove(false);
            this.playbackSpeedButton.setContentDescription(LocaleController.getString("AccDescrPlayerSpeed", R.string.AccDescrPlayerSpeed));
            this.playbackSpeedButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$7Wnw6O3QXrsA1aW5hzfwdYvNLtM
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
                public final void onItemClick(int i3) {
                    this.f$0.lambda$new$2$FragmentContextView(i3);
                }
            });
            this.speedItems[0] = this.playbackSpeedButton.addSubItem(1, R.drawable.msg_speed_0_5, LocaleController.getString("SpeedSlow", R.string.SpeedSlow));
            this.speedItems[1] = this.playbackSpeedButton.addSubItem(2, R.drawable.msg_speed_1, LocaleController.getString("SpeedNormal", R.string.SpeedNormal));
            this.speedItems[2] = this.playbackSpeedButton.addSubItem(3, R.drawable.msg_speed_1_5, LocaleController.getString("SpeedFast", R.string.SpeedFast));
            this.speedItems[3] = this.playbackSpeedButton.addSubItem(4, R.drawable.msg_speed_2, LocaleController.getString("SpeedVeryFast", R.string.SpeedVeryFast));
            if (AndroidUtilities.density >= 3.0f) {
                this.playbackSpeedButton.setPadding(0, 1, 0, 0);
            }
            this.playbackSpeedButton.setAdditionalXOffset(AndroidUtilities.dp(8.0f));
            addView(this.playbackSpeedButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, 0.0f, 36.0f, 0.0f));
            this.playbackSpeedButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$BVkMu9vCcPBbLsfFTiCFlzvCzac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$new$3$FragmentContextView(view3);
                }
            });
            this.playbackSpeedButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$nxh8opoMwM3tiWnvju7jh7ZltS8
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view3) {
                    return this.f$0.lambda$new$4$FragmentContextView(view3);
                }
            });
            updatePlaybackButton();
        }
        AvatarsImageView avatarsImageView = new AvatarsImageView(context, false);
        this.avatars = avatarsImageView;
        avatarsImageView.setDelegate(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$IN9oAxCVK_Xm7AF1hag5BLeYXo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$5$FragmentContextView();
            }
        });
        this.avatars.setVisibility(8);
        addView(this.avatars, LayoutHelper.createFrame(R.styleable.AppCompatTheme_tooltipForegroundColor, i, 51));
        this.muteDrawable = new RLottieDrawable(R.raw.voice_muted, "2131624056", AndroidUtilities.dp(16.0f), AndroidUtilities.dp(20.0f), true, (int[]) null);
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(context);
        this.muteButton = anonymousClass6;
        anonymousClass6.setColorFilter(new PorterDuffColorFilter(getThemedColor("returnToCallText"), PorterDuff.Mode.MULTIPLY));
        if (i2 >= 21) {
            this.muteButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("inappPlayerClose") & 436207615, 1, AndroidUtilities.dp(f)));
        }
        this.muteButton.setAnimation(this.muteDrawable);
        this.muteButton.setScaleType(ImageView.ScaleType.CENTER);
        this.muteButton.setVisibility(8);
        addView(this.muteButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, 0.0f, 2.0f, 0.0f));
        this.muteButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$u8UWGfxSL--pVmUQRX6DN6g7ah0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$6$FragmentContextView(view3);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.closeButton = imageView3;
        imageView3.setImageResource(R.drawable.miniplayer_close);
        this.closeButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("inappPlayerClose"), PorterDuff.Mode.MULTIPLY));
        if (i2 >= 21) {
            this.closeButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("inappPlayerClose") & 436207615, 1, AndroidUtilities.dp(f)));
        }
        this.closeButton.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.closeButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, 0.0f, 2.0f, 0.0f));
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$nQN2cjrjsODVnZIJ2AbRVtxwPpc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) throws InterruptedException, IOException {
                this.f$0.lambda$new$8$FragmentContextView(resourcesProvider, view3);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$ilQTcVs8QE-Gld8anB_u7reiCro
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) throws Resources.NotFoundException, NumberFormatException {
                this.f$0.lambda$new$10$FragmentContextView(resourcesProvider, parentFragment, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$FragmentContextView(View view) throws IOException {
        if (this.currentStyle == 0) {
            if (MediaController.getInstance().isMessagePaused()) {
                MediaController.getInstance().playMessage(MediaController.getInstance().getPlayingMessageObject());
            } else {
                MediaController.getInstance().lambda$startAudioAgain$7$MediaController(MediaController.getInstance().getPlayingMessageObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$FragmentContextView(View view) {
        callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$FragmentContextView(int i) {
        float playbackSpeed = MediaController.getInstance().getPlaybackSpeed(this.isMusic);
        if (i == 1) {
            MediaController.getInstance().setPlaybackSpeed(this.isMusic, 0.5f);
        } else if (i == 2) {
            MediaController.getInstance().setPlaybackSpeed(this.isMusic, 1.0f);
        } else if (i == 3) {
            MediaController.getInstance().setPlaybackSpeed(this.isMusic, 1.5f);
        } else {
            MediaController.getInstance().setPlaybackSpeed(this.isMusic, 1.8f);
        }
        float playbackSpeed2 = MediaController.getInstance().getPlaybackSpeed(this.isMusic);
        if (playbackSpeed != playbackSpeed2) {
            playbackSpeedChanged(playbackSpeed2);
        }
        updatePlaybackButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$FragmentContextView(View view) {
        float f = 1.0f;
        if (Math.abs(MediaController.getInstance().getPlaybackSpeed(this.isMusic) - 1.0f) > 0.001f) {
            MediaController.getInstance().setPlaybackSpeed(this.isMusic, 1.0f);
        } else {
            MediaController mediaController = MediaController.getInstance();
            boolean z = this.isMusic;
            float fastPlaybackSpeed = MediaController.getInstance().getFastPlaybackSpeed(this.isMusic);
            mediaController.setPlaybackSpeed(z, fastPlaybackSpeed);
            f = fastPlaybackSpeed;
        }
        playbackSpeedChanged(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$4$FragmentContextView(View view) {
        this.playbackSpeedButton.toggleSubMenu();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$FragmentContextView() {
        updateAvatars(true);
    }

    /* renamed from: ir.eitaa.ui.Components.FragmentContextView$6, reason: invalid class name */
    class AnonymousClass6 extends RLottieImageView {
        private final Runnable pressRunnable;
        boolean pressed;
        boolean scheduled;
        private final Runnable toggleMicRunnable;

        AnonymousClass6(Context context) {
            super(context);
            this.toggleMicRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$6$9tnOnc2ORmQiQjg6ikqyL5qAAeI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$$0$FragmentContextView$6();
                }
            };
            this.pressRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$6$zvkkw11RG6Jy4RKp8LVO1O4xufk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$$1$FragmentContextView$6();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$$0$FragmentContextView$6() {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            VoIPService.getSharedInstance().setMicMute(false, true, false);
            if (FragmentContextView.this.muteDrawable.setCustomEndFrame(FragmentContextView.this.isMuted ? 15 : 29)) {
                if (FragmentContextView.this.isMuted) {
                    FragmentContextView.this.muteDrawable.setCurrentFrame(0);
                } else {
                    FragmentContextView.this.muteDrawable.setCurrentFrame(14);
                }
            }
            FragmentContextView.this.muteButton.playAnimation();
            Theme.getFragmentContextViewWavesDrawable().updateState(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$$1$FragmentContextView$6() {
            if (!this.scheduled || VoIPService.getSharedInstance() == null) {
                return;
            }
            this.scheduled = false;
            this.pressed = true;
            FragmentContextView.this.isMuted = false;
            AndroidUtilities.runOnUIThread(this.toggleMicRunnable, 90L);
            FragmentContextView.this.muteButton.performHapticFeedback(3, 2);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (FragmentContextView.this.currentStyle == 3 || FragmentContextView.this.currentStyle == 1) {
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance == null) {
                    AndroidUtilities.cancelRunOnUIThread(this.pressRunnable);
                    AndroidUtilities.cancelRunOnUIThread(this.toggleMicRunnable);
                    this.scheduled = false;
                    this.pressed = false;
                    return true;
                }
                if (event.getAction() == 0 && sharedInstance.isMicMute()) {
                    AndroidUtilities.runOnUIThread(this.pressRunnable, 300L);
                    this.scheduled = true;
                } else if (event.getAction() == 1 || event.getAction() == 3) {
                    AndroidUtilities.cancelRunOnUIThread(this.toggleMicRunnable);
                    if (this.scheduled) {
                        AndroidUtilities.cancelRunOnUIThread(this.pressRunnable);
                        this.scheduled = false;
                    } else if (this.pressed) {
                        FragmentContextView.this.isMuted = true;
                        if (FragmentContextView.this.muteDrawable.setCustomEndFrame(15)) {
                            if (FragmentContextView.this.isMuted) {
                                FragmentContextView.this.muteDrawable.setCurrentFrame(0);
                            } else {
                                FragmentContextView.this.muteDrawable.setCurrentFrame(14);
                            }
                        }
                        FragmentContextView.this.muteButton.playAnimation();
                        if (VoIPService.getSharedInstance() != null) {
                            VoIPService.getSharedInstance().setMicMute(true, true, false);
                            FragmentContextView.this.muteButton.performHapticFeedback(3, 2);
                        }
                        this.pressed = false;
                        Theme.getFragmentContextViewWavesDrawable().updateState(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                        super.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        return true;
                    }
                }
                return super.onTouchEvent(event);
            }
            return super.onTouchEvent(event);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            int i;
            String str;
            super.onInitializeAccessibilityNodeInfo(info);
            info.setClassName(Button.class.getName());
            if (FragmentContextView.this.isMuted) {
                i = R.string.VoipUnmute;
                str = "VoipUnmute";
            } else {
                i = R.string.VoipMute;
                str = "VoipMute";
            }
            info.setText(LocaleController.getString(str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$FragmentContextView(View view) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (sharedInstance.groupCall != null) {
            AccountInstance.getInstance(sharedInstance.getAccount());
            ChatObject.Call call = sharedInstance.groupCall;
            TLRPC$Chat chat = sharedInstance.getChat();
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(sharedInstance.getSelfId());
            if (tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted && !ChatObject.canManageCalls(chat)) {
                return;
            }
        }
        boolean z = !sharedInstance.isMicMute();
        this.isMuted = z;
        sharedInstance.setMicMute(z, false, true);
        if (this.muteDrawable.setCustomEndFrame(this.isMuted ? 15 : 29)) {
            if (this.isMuted) {
                this.muteDrawable.setCurrentFrame(0);
            } else {
                this.muteDrawable.setCurrentFrame(14);
            }
        }
        this.muteButton.playAnimation();
        Theme.getFragmentContextViewWavesDrawable().updateState(true);
        this.muteButton.performHapticFeedback(3, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$8$FragmentContextView(Theme.ResourcesProvider resourcesProvider, View view) throws InterruptedException, IOException {
        if (this.currentStyle == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.fragment.getParentActivity(), resourcesProvider);
            builder.setTitle(LocaleController.getString("StopLiveLocationAlertToTitle", R.string.StopLiveLocationAlertToTitle));
            BaseFragment baseFragment = this.fragment;
            if (baseFragment instanceof DialogsActivity) {
                builder.setMessage(LocaleController.getString("StopLiveLocationAlertAllText", R.string.StopLiveLocationAlertAllText));
            } else {
                ChatActivity chatActivity = (ChatActivity) baseFragment;
                TLRPC$Chat currentChat = chatActivity.getCurrentChat();
                TLRPC$User currentUser = chatActivity.getCurrentUser();
                if (currentChat != null) {
                    builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("StopLiveLocationAlertToGroupText", R.string.StopLiveLocationAlertToGroupText, currentChat.title)));
                } else if (currentUser != null) {
                    builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("StopLiveLocationAlertToUserText", R.string.StopLiveLocationAlertToUserText, UserObject.getFirstName(currentUser))));
                } else {
                    builder.setMessage(LocaleController.getString("AreYouSure", R.string.AreYouSure));
                }
            }
            builder.setPositiveButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$iS_Ph80kQTQ1XdZm9BXvonT6MAQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$7$FragmentContextView(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            builder.show();
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(getThemedColor("dialogTextRed2"));
                return;
            }
            return;
        }
        MediaController.getInstance().cleanupPlayer(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$7$FragmentContextView(DialogInterface dialogInterface, int i) {
        BaseFragment baseFragment = this.fragment;
        if (!(baseFragment instanceof DialogsActivity)) {
            LocationController.getInstance(baseFragment.getCurrentAccount()).removeSharingLocation(((ChatActivity) this.fragment).getDialogId());
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            LocationController.getInstance(i2).removeAllLocationSharings();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$10$FragmentContextView(Theme.ResourcesProvider resourcesProvider, BaseFragment baseFragment, View view) throws Resources.NotFoundException, NumberFormatException {
        ChatActivity chatActivity;
        ChatObject.Call groupCall;
        int currentAccount;
        long dialogId;
        int i = this.currentStyle;
        if (i == 0) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (this.fragment == null || playingMessageObject == null) {
                return;
            }
            if (playingMessageObject.isMusic()) {
                this.fragment.showDialog(new AudioPlayerAlert(getContext(), resourcesProvider));
                return;
            }
            BaseFragment baseFragment2 = this.fragment;
            if (playingMessageObject.getDialogId() == (baseFragment2 instanceof ChatActivity ? ((ChatActivity) baseFragment2).getDialogId() : 0L)) {
                ((ChatActivity) this.fragment).scrollToMessageId(playingMessageObject.getId(), 0, false, 0, true, 0);
                return;
            }
            long dialogId2 = playingMessageObject.getDialogId();
            Bundle bundle = new Bundle();
            if (DialogObject.isEncryptedDialog(dialogId2)) {
                bundle.putInt("enc_id", DialogObject.getEncryptedChatId(dialogId2));
            } else if (DialogObject.isUserDialog(dialogId2)) {
                bundle.putLong("user_id", dialogId2);
            } else {
                bundle.putLong("chat_id", -dialogId2);
            }
            bundle.putInt("message_id", playingMessageObject.getId());
            this.fragment.presentFragment(new ChatActivity(bundle), this.fragment instanceof ChatActivity);
            return;
        }
        if (i == 1) {
            getContext().startActivity(new Intent(getContext(), (Class<?>) LaunchActivity.class).setAction("voip"));
            return;
        }
        if (i != 2) {
            if (i == 3) {
                if (VoIPService.getSharedInstance() == null || !(getContext() instanceof LaunchActivity)) {
                    return;
                }
                GroupCallActivity.create((LaunchActivity) getContext(), AccountInstance.getInstance(VoIPService.getSharedInstance().getAccount()), null, null, false, null);
                return;
            }
            if (i == 4) {
                if (this.fragment.getParentActivity() == null || (groupCall = (chatActivity = (ChatActivity) this.fragment).getGroupCall()) == null) {
                    return;
                }
                TLRPC$Chat chat = chatActivity.getMessagesController().getChat(Long.valueOf(groupCall.chatId));
                Activity parentActivity = this.fragment.getParentActivity();
                BaseFragment baseFragment3 = this.fragment;
                VoIPHelper.startCall(chat, null, null, false, parentActivity, baseFragment3, baseFragment3.getAccountInstance());
                return;
            }
            if (i != 5 || baseFragment.getSendMessagesHelper().getImportingHistory(((ChatActivity) baseFragment).getDialogId()) == null) {
                return;
            }
            ImportingAlert importingAlert = new ImportingAlert(getContext(), null, (ChatActivity) this.fragment, resourcesProvider);
            importingAlert.setOnHideListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$zSjcGZjN8wPFKhiwVvedmR-kVLI
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$9$FragmentContextView(dialogInterface);
                }
            });
            this.fragment.showDialog(importingAlert);
            checkImport(false);
            return;
        }
        int i2 = UserConfig.selectedAccount;
        BaseFragment baseFragment4 = this.fragment;
        if (baseFragment4 instanceof ChatActivity) {
            dialogId = ((ChatActivity) baseFragment4).getDialogId();
            currentAccount = this.fragment.getCurrentAccount();
        } else if (LocationController.getLocationsCount() == 1) {
            for (int i3 = 0; i3 < 3; i3++) {
                if (!LocationController.getInstance(i3).sharingLocationsUI.isEmpty()) {
                    LocationController.SharingLocationInfo sharingLocationInfo = LocationController.getInstance(i3).sharingLocationsUI.get(0);
                    long j = sharingLocationInfo.did;
                    currentAccount = sharingLocationInfo.messageObject.currentAccount;
                    dialogId = j;
                    break;
                }
            }
            currentAccount = i2;
            dialogId = 0;
        } else {
            currentAccount = i2;
            dialogId = 0;
        }
        if (dialogId != 0) {
            openSharingLocation(LocationController.getInstance(currentAccount).getSharingLocationInfo(dialogId));
        } else {
            this.fragment.showDialog(new SharingLocationsAlert(getContext(), new SharingLocationsAlert.SharingLocationsAlertDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$-CXXL1VSL5ZiDx4-1ynt1p7h1tg
                @Override // ir.eitaa.ui.Components.SharingLocationsAlert.SharingLocationsAlertDelegate
                public final void didSelectLocation(LocationController.SharingLocationInfo sharingLocationInfo2) {
                    this.f$0.openSharingLocation(sharingLocationInfo2);
                }
            }, resourcesProvider));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$9$FragmentContextView(DialogInterface dialogInterface) {
        checkImport(false);
    }

    public void setSupportsCalls(boolean value) {
        this.supportsCalls = value;
    }

    public void setDelegate(FragmentContextViewDelegate fragmentContextViewDelegate) {
        this.delegate = fragmentContextViewDelegate;
    }

    private void updatePlaybackButton() {
        if (this.playbackSpeedButton == null) {
            return;
        }
        float playbackSpeed = MediaController.getInstance().getPlaybackSpeed(this.isMusic);
        float fastPlaybackSpeed = MediaController.getInstance().getFastPlaybackSpeed(this.isMusic);
        if (Math.abs(fastPlaybackSpeed - 1.8f) < 0.001f) {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_2_0);
        } else if (Math.abs(fastPlaybackSpeed - 1.5f) < 0.001f) {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_1_5);
        } else {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_0_5);
        }
        updateColors();
        for (int i = 0; i < this.speedItems.length; i++) {
            if ((i == 0 && Math.abs(playbackSpeed - 0.5f) < 0.001f) || ((i == 1 && Math.abs(playbackSpeed - 1.0f) < 0.001f) || ((i == 2 && Math.abs(playbackSpeed - 1.5f) < 0.001f) || (i == 3 && Math.abs(playbackSpeed - 1.8f) < 0.001f)))) {
                this.speedItems[i].setColors(getThemedColor("inappPlayerPlayPause"), getThemedColor("inappPlayerPlayPause"));
            } else {
                this.speedItems[i].setColors(getThemedColor("actionBarDefaultSubmenuItem"), getThemedColor("actionBarDefaultSubmenuItemIcon"));
            }
        }
    }

    public void updateColors() {
        if (this.playbackSpeedButton != null) {
            String str = Math.abs(MediaController.getInstance().getPlaybackSpeed(this.isMusic) - 1.0f) > 0.001f ? "inappPlayerPlayPause" : "inappPlayerClose";
            this.playbackSpeedButton.setIconColor(getThemedColor(str));
            if (Build.VERSION.SDK_INT >= 21) {
                this.playbackSpeedButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str) & 436207615, 1, AndroidUtilities.dp(14.0f)));
            }
        }
    }

    public void setAdditionalContextView(FragmentContextView contextView) {
        this.additionalContextView = contextView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSharingLocation(final LocationController.SharingLocationInfo info) {
        if (info == null || !(this.fragment.getParentActivity() instanceof LaunchActivity)) {
            return;
        }
        LaunchActivity launchActivity = (LaunchActivity) this.fragment.getParentActivity();
        launchActivity.switchToAccount(info.messageObject.currentAccount, true);
        LocationActivity locationActivity = new LocationActivity(2);
        locationActivity.setMessageObject(info.messageObject);
        final long dialogId = info.messageObject.getDialogId();
        locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$FragmentContextView$FVzP3Zm5dAaNZ9_d-_kjflqo2Lg
        });
        launchActivity.lambda$runLinkRequest$39(locationActivity);
    }

    @Keep
    public float getTopPadding() {
        return this.topPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkVisibility() {
        /*
            r5 = this;
            boolean r0 = r5.isLocation
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L2a
            ir.eitaa.ui.ActionBar.BaseFragment r0 = r5.fragment
            boolean r3 = r0 instanceof ir.eitaa.ui.DialogsActivity
            if (r3 == 0) goto L14
            int r0 = ir.eitaa.messenger.LocationController.getLocationsCount()
            if (r0 == 0) goto La0
            goto La1
        L14:
            int r0 = r0.getCurrentAccount()
            ir.eitaa.messenger.LocationController r0 = ir.eitaa.messenger.LocationController.getInstance(r0)
            ir.eitaa.ui.ActionBar.BaseFragment r2 = r5.fragment
            ir.eitaa.ui.ChatActivity r2 = (ir.eitaa.ui.ChatActivity) r2
            long r2 = r2.getDialogId()
            boolean r2 = r0.isSharingLocation(r2)
            goto La1
        L2a:
            ir.eitaa.messenger.voip.VoIPService r0 = ir.eitaa.messenger.voip.VoIPService.getSharedInstance()
            if (r0 == 0) goto L47
            ir.eitaa.messenger.voip.VoIPService r0 = ir.eitaa.messenger.voip.VoIPService.getSharedInstance()
            boolean r0 = r0.isHangingUp()
            if (r0 != 0) goto L47
            ir.eitaa.messenger.voip.VoIPService r0 = ir.eitaa.messenger.voip.VoIPService.getSharedInstance()
            int r0 = r0.getCallState()
            r3 = 15
            if (r0 == r3) goto L47
            goto La1
        L47:
            ir.eitaa.ui.ActionBar.BaseFragment r0 = r5.fragment
            boolean r3 = r0 instanceof ir.eitaa.ui.ChatActivity
            if (r3 == 0) goto L66
            ir.eitaa.messenger.SendMessagesHelper r0 = r0.getSendMessagesHelper()
            ir.eitaa.ui.ActionBar.BaseFragment r3 = r5.fragment
            ir.eitaa.ui.ChatActivity r3 = (ir.eitaa.ui.ChatActivity) r3
            long r3 = r3.getDialogId()
            ir.eitaa.messenger.SendMessagesHelper$ImportingHistory r0 = r0.getImportingHistory(r3)
            if (r0 == 0) goto L66
            boolean r0 = r5.isPlayingVoice()
            if (r0 != 0) goto L66
            goto La1
        L66:
            ir.eitaa.ui.ActionBar.BaseFragment r0 = r5.fragment
            boolean r3 = r0 instanceof ir.eitaa.ui.ChatActivity
            if (r3 == 0) goto L8f
            ir.eitaa.ui.ChatActivity r0 = (ir.eitaa.ui.ChatActivity) r0
            ir.eitaa.messenger.ChatObject$Call r0 = r0.getGroupCall()
            if (r0 == 0) goto L8f
            ir.eitaa.ui.ActionBar.BaseFragment r0 = r5.fragment
            ir.eitaa.ui.ChatActivity r0 = (ir.eitaa.ui.ChatActivity) r0
            ir.eitaa.messenger.ChatObject$Call r0 = r0.getGroupCall()
            boolean r0 = r0.shouldShowPanel()
            if (r0 == 0) goto L8f
            boolean r0 = ir.eitaa.ui.Components.GroupCallPip.isShowing()
            if (r0 != 0) goto L8f
            boolean r0 = r5.isPlayingVoice()
            if (r0 != 0) goto L8f
            goto La1
        L8f:
            ir.eitaa.messenger.MediaController r0 = ir.eitaa.messenger.MediaController.getInstance()
            ir.eitaa.messenger.MessageObject r0 = r0.getPlayingMessageObject()
            if (r0 == 0) goto La0
            int r0 = r0.getId()
            if (r0 == 0) goto La0
            goto La1
        La0:
            r2 = 0
        La1:
            if (r2 == 0) goto La4
            goto La6
        La4:
            r1 = 8
        La6:
            r5.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FragmentContextView.checkVisibility():void");
    }

    @Keep
    public void setTopPadding(float value) {
        this.topPadding = value;
        if (this.fragment == null || getParent() == null) {
            return;
        }
        View fragmentView = this.applyingView;
        if (fragmentView == null) {
            fragmentView = this.fragment.getFragmentView();
        }
        FragmentContextView fragmentContextView = this.additionalContextView;
        int iDp = (fragmentContextView == null || fragmentContextView.getVisibility() != 0 || this.additionalContextView.getParent() == null) ? 0 : AndroidUtilities.dp(this.additionalContextView.getStyleHeight());
        if (fragmentView == null || getParent() == null) {
            return;
        }
        fragmentView.setPadding(0, ((int) (getVisibility() == 0 ? this.topPadding : 0.0f)) + iDp, 0, 0);
    }

    private void updateStyle(int style) throws InterruptedException {
        int i = this.currentStyle;
        if (i == style) {
            return;
        }
        if (i == 3 || i == 1) {
            Theme.getFragmentContextViewWavesDrawable().removeParent(this);
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().unregisterStateListener(this);
            }
        }
        this.currentStyle = style;
        this.frameLayout.setWillNotDraw(style != 4);
        if (style != 4) {
            this.timeLayout = null;
        }
        AvatarsImageView avatarsImageView = this.avatars;
        if (avatarsImageView != null) {
            avatarsImageView.setStyle(this.currentStyle);
            this.avatars.setLayoutParams(LayoutHelper.createFrame(R.styleable.AppCompatTheme_tooltipForegroundColor, getStyleHeight(), 51));
        }
        this.frameLayout.setLayoutParams(LayoutHelper.createFrame(-1, getStyleHeight(), 51, 0.0f, 0.0f, 0.0f, 0.0f));
        this.shadow.setLayoutParams(LayoutHelper.createFrame(-1, 2.0f, 51, 0.0f, getStyleHeight(), 0.0f, 0.0f));
        float f = this.topPadding;
        if (f > 0.0f && f != AndroidUtilities.dp2(getStyleHeight())) {
            updatePaddings();
            setTopPadding(AndroidUtilities.dp2(getStyleHeight()));
        }
        if (style == 5) {
            this.selector.setBackground(Theme.getSelectorDrawable(false));
            this.frameLayout.setBackgroundColor(getThemedColor("inappPlayerBackground"));
            this.frameLayout.setTag("inappPlayerBackground");
            int i2 = 0;
            while (i2 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
                TextView textView = i2 == 0 ? clippingTextViewSwitcher.getTextView() : clippingTextViewSwitcher.getNextTextView();
                if (textView != null) {
                    textView.setGravity(19);
                    textView.setTextColor(getThemedColor("inappPlayerTitle"));
                    textView.setTypeface(AndroidUtilities.getFontFamily(false));
                    textView.setTextSize(1, 15.0f);
                }
                i2++;
            }
            this.titleTextView.setTag("inappPlayerTitle");
            this.subtitleTextView.setVisibility(8);
            this.joinButton.setVisibility(8);
            this.closeButton.setVisibility(8);
            this.playButton.setVisibility(8);
            this.muteButton.setVisibility(8);
            this.avatars.setVisibility(8);
            this.importingImageView.setVisibility(0);
            this.importingImageView.playAnimation();
            this.closeButton.setContentDescription(LocaleController.getString("AccDescrClosePlayer", R.string.AccDescrClosePlayer));
            ActionBarMenuItem actionBarMenuItem = this.playbackSpeedButton;
            if (actionBarMenuItem != null) {
                actionBarMenuItem.setVisibility(8);
            }
            this.titleTextView.setLayoutParams(LayoutHelper.createFrame(-1, 36.0f, 51, 35.0f, 0.0f, 36.0f, 0.0f));
            return;
        }
        if (style == 0 || style == 2) {
            this.selector.setBackground(Theme.getSelectorDrawable(false));
            this.frameLayout.setBackgroundColor(getThemedColor("inappPlayerBackground"));
            this.frameLayout.setTag("inappPlayerBackground");
            this.subtitleTextView.setVisibility(8);
            this.joinButton.setVisibility(8);
            this.closeButton.setVisibility(0);
            this.playButton.setVisibility(0);
            this.muteButton.setVisibility(8);
            this.importingImageView.setVisibility(8);
            this.importingImageView.stopAnimation();
            this.avatars.setVisibility(8);
            int i3 = 0;
            while (i3 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher2 = this.titleTextView;
                TextView textView2 = i3 == 0 ? clippingTextViewSwitcher2.getTextView() : clippingTextViewSwitcher2.getNextTextView();
                if (textView2 != null) {
                    textView2.setGravity(19);
                    textView2.setTextColor(getThemedColor("inappPlayerTitle"));
                    textView2.setTypeface(AndroidUtilities.getFontFamily(false));
                    textView2.setTextSize(1, 15.0f);
                }
                i3++;
            }
            this.titleTextView.setTag("inappPlayerTitle");
            if (style == 0) {
                this.playButton.setLayoutParams(LayoutHelper.createFrame(36, 36.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                this.titleTextView.setLayoutParams(LayoutHelper.createFrame(-1, 36.0f, 51, 35.0f, 0.0f, 36.0f, 0.0f));
                ActionBarMenuItem actionBarMenuItem2 = this.playbackSpeedButton;
                if (actionBarMenuItem2 != null) {
                    actionBarMenuItem2.setVisibility(0);
                }
                this.closeButton.setContentDescription(LocaleController.getString("AccDescrClosePlayer", R.string.AccDescrClosePlayer));
                return;
            }
            this.playButton.setLayoutParams(LayoutHelper.createFrame(36, 36.0f, 51, 8.0f, 0.0f, 0.0f, 0.0f));
            this.titleTextView.setLayoutParams(LayoutHelper.createFrame(-1, 36.0f, 51, 51.0f, 0.0f, 36.0f, 0.0f));
            this.closeButton.setContentDescription(LocaleController.getString("AccDescrStopLiveLocation", R.string.AccDescrStopLiveLocation));
            return;
        }
        if (style == 4) {
            this.selector.setBackground(Theme.getSelectorDrawable(false));
            this.frameLayout.setBackgroundColor(getThemedColor("inappPlayerBackground"));
            this.frameLayout.setTag("inappPlayerBackground");
            this.muteButton.setVisibility(8);
            this.subtitleTextView.setVisibility(0);
            int i4 = 0;
            while (i4 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher3 = this.titleTextView;
                TextView textView3 = i4 == 0 ? clippingTextViewSwitcher3.getTextView() : clippingTextViewSwitcher3.getNextTextView();
                if (textView3 != null) {
                    textView3.setGravity(51);
                    textView3.setTextColor(getThemedColor("inappPlayerPerformer"));
                    textView3.setTypeface(AndroidUtilities.getFontFamily(true));
                    textView3.setTextSize(1, 15.0f);
                }
                i4++;
            }
            this.titleTextView.setTag("inappPlayerPerformer");
            this.titleTextView.setPadding(0, 0, 0, 0);
            this.importingImageView.setVisibility(8);
            this.importingImageView.stopAnimation();
            this.avatars.setVisibility(0);
            updateAvatars(false);
            this.closeButton.setVisibility(8);
            this.playButton.setVisibility(8);
            ActionBarMenuItem actionBarMenuItem3 = this.playbackSpeedButton;
            if (actionBarMenuItem3 != null) {
                actionBarMenuItem3.setVisibility(8);
                return;
            }
            return;
        }
        if (style == 1 || style == 3) {
            this.selector.setBackground(null);
            updateCallTitle();
            this.avatars.setVisibility(0);
            if (style == 3 && VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().registerStateListener(this);
            }
            updateAvatars(false);
            this.muteButton.setVisibility(0);
            boolean z = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().isMicMute();
            this.isMuted = z;
            this.muteDrawable.setCustomEndFrame(z ? 15 : 29);
            RLottieDrawable rLottieDrawable = this.muteDrawable;
            rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
            this.muteButton.invalidate();
            this.frameLayout.setBackground(null);
            this.importingImageView.setVisibility(8);
            this.importingImageView.stopAnimation();
            Theme.getFragmentContextViewWavesDrawable().addParent(this);
            invalidate();
            int i5 = 0;
            while (i5 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher4 = this.titleTextView;
                TextView textView4 = i5 == 0 ? clippingTextViewSwitcher4.getTextView() : clippingTextViewSwitcher4.getNextTextView();
                if (textView4 != null) {
                    textView4.setGravity(19);
                    textView4.setTextColor(getThemedColor("returnToCallText"));
                    textView4.setTypeface(AndroidUtilities.getFontFamily(true));
                    textView4.setTextSize(1, 14.0f);
                }
                i5++;
            }
            this.titleTextView.setTag("returnToCallText");
            this.closeButton.setVisibility(8);
            this.playButton.setVisibility(8);
            this.subtitleTextView.setVisibility(8);
            this.joinButton.setVisibility(8);
            this.titleTextView.setLayoutParams(LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 2.0f));
            this.titleTextView.setPadding(AndroidUtilities.dp(112.0f), 0, AndroidUtilities.dp(112.0f), 0);
            ActionBarMenuItem actionBarMenuItem4 = this.playbackSpeedButton;
            if (actionBarMenuItem4 != null) {
                actionBarMenuItem4.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        if (this.scheduleRunnableScheduled) {
            AndroidUtilities.cancelRunOnUIThread(this.updateScheduleTimeRunnable);
            this.scheduleRunnableScheduled = false;
        }
        this.visible = false;
        NotificationCenter.getInstance(this.account).onAnimationFinish(this.animationIndex);
        this.topPadding = 0.0f;
        if (this.isLocation) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.liveLocationsChanged);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.liveLocationsCacheChanged);
        } else {
            for (int i = 0; i < 3; i++) {
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingDidReset);
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingDidStart);
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.groupCallUpdated);
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.groupCallTypingsUpdated);
                NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.historyImportProgressChanged);
            }
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.messagePlayingSpeedChanged);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didStartedCall);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didEndCall);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.webRtcSpeakerAmplitudeEvent);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.groupCallVisibilityChanged);
        }
        int i2 = this.currentStyle;
        if (i2 == 3 || i2 == 1) {
            Theme.getFragmentContextViewWavesDrawable().removeParent(this);
        }
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().unregisterStateListener(this);
        }
        this.wasDraw = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        if (this.isLocation) {
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.liveLocationsChanged);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.liveLocationsCacheChanged);
            FragmentContextView fragmentContextView = this.additionalContextView;
            if (fragmentContextView != null) {
                fragmentContextView.checkVisibility();
            }
            checkLiveLocation(true);
        } else {
            for (int i = 0; i < 3; i++) {
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingDidReset);
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingDidStart);
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.groupCallUpdated);
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.groupCallTypingsUpdated);
                NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.historyImportProgressChanged);
            }
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.messagePlayingSpeedChanged);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didStartedCall);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didEndCall);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.webRtcSpeakerAmplitudeEvent);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.groupCallVisibilityChanged);
            FragmentContextView fragmentContextView2 = this.additionalContextView;
            if (fragmentContextView2 != null) {
                fragmentContextView2.checkVisibility();
            }
            if (VoIPService.getSharedInstance() != null && !VoIPService.getSharedInstance().isHangingUp() && VoIPService.getSharedInstance().getCallState() != 15 && !GroupCallPip.isShowing()) {
                checkCall(true);
            } else {
                BaseFragment baseFragment = this.fragment;
                if ((baseFragment instanceof ChatActivity) && baseFragment.getSendMessagesHelper().getImportingHistory(((ChatActivity) this.fragment).getDialogId()) != null && !isPlayingVoice()) {
                    checkImport(true);
                } else {
                    BaseFragment baseFragment2 = this.fragment;
                    if ((baseFragment2 instanceof ChatActivity) && ((ChatActivity) baseFragment2).getGroupCall() != null && ((ChatActivity) this.fragment).getGroupCall().shouldShowPanel() && !GroupCallPip.isShowing() && !isPlayingVoice()) {
                        checkCall(true);
                    } else {
                        checkPlayer(true);
                        updatePlaybackButton();
                    }
                }
            }
        }
        int i2 = this.currentStyle;
        if (i2 == 3 || i2 == 1) {
            Theme.getFragmentContextViewWavesDrawable().addParent(this);
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().registerStateListener(this);
            }
            boolean z = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().isMicMute();
            if (this.isMuted != z) {
                this.isMuted = z;
                this.muteDrawable.setCustomEndFrame(z ? 15 : 29);
                RLottieDrawable rLottieDrawable = this.muteDrawable;
                rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
                this.muteButton.invalidate();
            }
        } else if (i2 == 4 && !this.scheduleRunnableScheduled) {
            this.scheduleRunnableScheduled = true;
            this.updateScheduleTimeRunnable.run();
        }
        if (this.visible && this.topPadding == 0.0f) {
            updatePaddings();
            setTopPadding(AndroidUtilities.dp2(getStyleHeight()));
        }
        this.speakerAmplitude = 0.0f;
        this.micAmplitude = 0.0f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, AndroidUtilities.dp2(getStyleHeight() + 2));
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException {
        VoIPService sharedInstance;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        if (id == NotificationCenter.liveLocationsChanged) {
            checkLiveLocation(false);
            return;
        }
        if (id == NotificationCenter.liveLocationsCacheChanged) {
            if (this.fragment instanceof ChatActivity) {
                if (((ChatActivity) this.fragment).getDialogId() == ((Long) args[0]).longValue()) {
                    checkLocationString();
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidStart || id == NotificationCenter.messagePlayingPlayStateChanged || id == NotificationCenter.messagePlayingDidReset || id == NotificationCenter.didEndCall) {
            int i = this.currentStyle;
            if (i == 1 || i == 3 || i == 4) {
                checkCall(false);
            }
            checkPlayer(false);
            return;
        }
        int i2 = NotificationCenter.didStartedCall;
        if (id == i2 || id == NotificationCenter.groupCallUpdated || id == NotificationCenter.groupCallVisibilityChanged) {
            checkCall(false);
            if (this.currentStyle != 3 || (sharedInstance = VoIPService.getSharedInstance()) == null || sharedInstance.groupCall == null) {
                return;
            }
            if (id == i2) {
                sharedInstance.registerStateListener(this);
            }
            int callState = sharedInstance.getCallState();
            if (callState == 1 || callState == 2 || callState == 6 || callState == 5 || (tLRPC$TL_groupCallParticipant = sharedInstance.groupCall.participants.get(sharedInstance.getSelfId())) == null || tLRPC$TL_groupCallParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipant.muted || ChatObject.canManageCalls(sharedInstance.getChat())) {
                return;
            }
            sharedInstance.setMicMute(true, false, false);
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.muteButton.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            return;
        }
        if (id == NotificationCenter.groupCallTypingsUpdated) {
            if (this.visible && this.currentStyle == 4) {
                ChatObject.Call groupCall = ((ChatActivity) this.fragment).getGroupCall();
                if (groupCall != null) {
                    if (groupCall.isScheduled()) {
                        this.subtitleTextView.setText(LocaleController.formatStartsTime(groupCall.call.schedule_date, 4), false);
                    } else {
                        int i3 = groupCall.call.participants_count;
                        if (i3 == 0) {
                            this.subtitleTextView.setText(LocaleController.getString("MembersTalkingNobody", R.string.MembersTalkingNobody), false);
                        } else {
                            this.subtitleTextView.setText(LocaleController.formatPluralString("Participants", i3), false);
                        }
                    }
                }
                updateAvatars(true);
                return;
            }
            return;
        }
        if (id == NotificationCenter.historyImportProgressChanged) {
            int i4 = this.currentStyle;
            if (i4 == 1 || i4 == 3 || i4 == 4) {
                checkCall(false);
            }
            checkImport(false);
            return;
        }
        if (id == NotificationCenter.messagePlayingSpeedChanged) {
            updatePlaybackButton();
            return;
        }
        if (id == NotificationCenter.webRtcMicAmplitudeEvent) {
            if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute()) {
                this.micAmplitude = 0.0f;
            } else {
                this.micAmplitude = Math.min(8500.0f, ((Float) args[0]).floatValue() * 4000.0f) / 8500.0f;
            }
            if (VoIPService.getSharedInstance() != null) {
                Theme.getFragmentContextViewWavesDrawable().setAmplitude(Math.max(this.speakerAmplitude, this.micAmplitude));
                return;
            }
            return;
        }
        if (id == NotificationCenter.webRtcSpeakerAmplitudeEvent) {
            this.speakerAmplitude = Math.max(0.0f, Math.min((((Float) args[0]).floatValue() * 15.0f) / 80.0f, 1.0f));
            if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute()) {
                this.micAmplitude = 0.0f;
            }
            if (VoIPService.getSharedInstance() != null) {
                Theme.getFragmentContextViewWavesDrawable().setAmplitude(Math.max(this.speakerAmplitude, this.micAmplitude));
            }
            this.avatars.invalidate();
        }
    }

    public int getStyleHeight() {
        return this.currentStyle == 4 ? 48 : 36;
    }

    public boolean isCallTypeVisible() {
        int i = this.currentStyle;
        return (i == 1 || i == 3) && this.visible;
    }

    private void checkLiveLocation(boolean create) throws InterruptedException {
        boolean zIsSharingLocation;
        String pluralString;
        String string;
        View fragmentView = this.fragment.getFragmentView();
        if (!create && fragmentView != null && (fragmentView.getParent() == null || ((View) fragmentView.getParent()).getVisibility() != 0)) {
            create = true;
        }
        BaseFragment baseFragment = this.fragment;
        if (baseFragment instanceof DialogsActivity) {
            zIsSharingLocation = LocationController.getLocationsCount() != 0;
        } else {
            zIsSharingLocation = LocationController.getInstance(baseFragment.getCurrentAccount()).isSharingLocation(((ChatActivity) this.fragment).getDialogId());
        }
        if (!zIsSharingLocation) {
            this.lastLocationSharingCount = -1;
            AndroidUtilities.cancelRunOnUIThread(this.checkLocationRunnable);
            if (this.visible) {
                this.visible = false;
                if (create) {
                    if (getVisibility() != 8) {
                        setVisibility(8);
                    }
                    setTopPadding(0.0f);
                    return;
                }
                AnimatorSet animatorSet = this.animatorSet;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.animatorSet = null;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "topPadding", 0.0f));
                this.animatorSet.setDuration(200L);
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                            return;
                        }
                        FragmentContextView.this.setVisibility(8);
                        FragmentContextView.this.animatorSet = null;
                    }
                });
                this.animatorSet.start();
                return;
            }
            return;
        }
        updateStyle(2);
        this.playButton.setImageDrawable(new ShareLocationDrawable(getContext(), 1));
        if (create && this.topPadding == 0.0f) {
            setTopPadding(AndroidUtilities.dp2(getStyleHeight()));
        }
        if (!this.visible) {
            if (!create) {
                AnimatorSet animatorSet3 = this.animatorSet;
                if (animatorSet3 != null) {
                    animatorSet3.cancel();
                    this.animatorSet = null;
                }
                AnimatorSet animatorSet4 = new AnimatorSet();
                this.animatorSet = animatorSet4;
                animatorSet4.playTogether(ObjectAnimator.ofFloat(this, "topPadding", AndroidUtilities.dp2(getStyleHeight())));
                this.animatorSet.setDuration(200L);
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                            return;
                        }
                        FragmentContextView.this.animatorSet = null;
                    }
                });
                this.animatorSet.start();
            }
            this.visible = true;
            setVisibility(0);
        }
        if (this.fragment instanceof DialogsActivity) {
            String string2 = LocaleController.getString("LiveLocationContext", R.string.LiveLocationContext);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList.addAll(LocationController.getInstance(i).sharingLocationsUI);
            }
            if (arrayList.size() == 1) {
                LocationController.SharingLocationInfo sharingLocationInfo = (LocationController.SharingLocationInfo) arrayList.get(0);
                long dialogId = sharingLocationInfo.messageObject.getDialogId();
                if (DialogObject.isUserDialog(dialogId)) {
                    pluralString = UserObject.getFirstName(MessagesController.getInstance(sharingLocationInfo.messageObject.currentAccount).getUser(Long.valueOf(dialogId)));
                    string = LocaleController.getString("AttachLiveLocationIsSharing", R.string.AttachLiveLocationIsSharing);
                } else {
                    TLRPC$Chat chat = MessagesController.getInstance(sharingLocationInfo.messageObject.currentAccount).getChat(Long.valueOf(-dialogId));
                    pluralString = chat != null ? chat.title : "";
                    string = LocaleController.getString("AttachLiveLocationIsSharingChat", R.string.AttachLiveLocationIsSharingChat);
                }
            } else {
                pluralString = LocaleController.formatPluralString("Chats", arrayList.size());
                string = LocaleController.getString("AttachLiveLocationIsSharingChats", R.string.AttachLiveLocationIsSharingChats);
            }
            String str = String.format(string, string2, pluralString);
            int iIndexOf = str.indexOf(string2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int i2 = 0;
            while (i2 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
                TextView textView = i2 == 0 ? clippingTextViewSwitcher.getTextView() : clippingTextViewSwitcher.getNextTextView();
                if (textView != null) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                i2++;
            }
            spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true), 0, getThemedColor("inappPlayerPerformer")), iIndexOf, string2.length() + iIndexOf, 18);
            this.titleTextView.setText(spannableStringBuilder, false);
            return;
        }
        this.checkLocationRunnable.run();
        checkLocationString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLocationString() {
        int i;
        String str;
        BaseFragment baseFragment = this.fragment;
        if (!(baseFragment instanceof ChatActivity) || this.titleTextView == null) {
            return;
        }
        ChatActivity chatActivity = (ChatActivity) baseFragment;
        long dialogId = chatActivity.getDialogId();
        int currentAccount = chatActivity.getCurrentAccount();
        ArrayList<TLRPC$Message> arrayList = LocationController.getInstance(currentAccount).locationsCache.get(dialogId);
        if (!this.firstLocationsLoaded) {
            LocationController.getInstance(currentAccount).loadLiveLocations(dialogId);
            this.firstLocationsLoaded = true;
        }
        TLRPC$User user = null;
        if (arrayList != null) {
            long clientUserId = UserConfig.getInstance(currentAccount).getClientUserId();
            int currentTime = ConnectionsManager.getInstance(currentAccount).getCurrentTime();
            i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TLRPC$Message tLRPC$Message = arrayList.get(i2);
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
                if (tLRPC$MessageMedia != null && tLRPC$Message.date + tLRPC$MessageMedia.period > currentTime) {
                    long fromChatId = MessageObject.getFromChatId(tLRPC$Message);
                    if (user == null && fromChatId != clientUserId) {
                        user = MessagesController.getInstance(currentAccount).getUser(Long.valueOf(fromChatId));
                    }
                    i++;
                }
            }
        } else {
            i = 0;
        }
        if (this.lastLocationSharingCount == i) {
            return;
        }
        this.lastLocationSharingCount = i;
        String string = LocaleController.getString("LiveLocationContext", R.string.LiveLocationContext);
        if (i == 0) {
            str = string;
        } else {
            int i3 = i - 1;
            str = LocationController.getInstance(currentAccount).isSharingLocation(dialogId) ? i3 != 0 ? (i3 != 1 || user == null) ? String.format("%1$s - %2$s %3$s", string, LocaleController.getString("ChatYourSelfName", R.string.ChatYourSelfName), LocaleController.formatPluralString("AndOther", i3)) : String.format("%1$s - %2$s", string, LocaleController.formatString("SharingYouAndOtherName", R.string.SharingYouAndOtherName, UserObject.getFirstName(user))) : String.format("%1$s - %2$s", string, LocaleController.getString("ChatYourSelfName", R.string.ChatYourSelfName)) : i3 != 0 ? String.format("%1$s - %2$s %3$s", string, UserObject.getFirstName(user), LocaleController.formatPluralString("AndOther", i3)) : String.format("%1$s - %2$s", string, UserObject.getFirstName(user));
        }
        if (str.equals(this.lastString)) {
            return;
        }
        this.lastString = str;
        int iIndexOf = str.indexOf(string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int i4 = 0;
        while (i4 < 2) {
            AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
            TextView textView = i4 == 0 ? clippingTextViewSwitcher.getTextView() : clippingTextViewSwitcher.getNextTextView();
            if (textView != null) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
            i4++;
        }
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true), 0, getThemedColor("inappPlayerPerformer")), iIndexOf, string.length() + iIndexOf, 18);
        }
        this.titleTextView.setText(spannableStringBuilder, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPlayer(boolean create) throws InterruptedException {
        SpannableStringBuilder spannableStringBuilder;
        if (this.visible) {
            int i = this.currentStyle;
            if (i == 1 || i == 3) {
                return;
            }
            if ((i == 4 || i == 5) && !isPlayingVoice()) {
                return;
            }
        }
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        View fragmentView = this.fragment.getFragmentView();
        if (!create && fragmentView != null && (fragmentView.getParent() == null || ((View) fragmentView.getParent()).getVisibility() != 0)) {
            create = true;
        }
        boolean z = this.visible;
        if (playingMessageObject == null || playingMessageObject.getId() == 0 || playingMessageObject.isVideo()) {
            this.lastMessageObject = null;
            boolean z2 = (!this.supportsCalls || VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isHangingUp() || VoIPService.getSharedInstance().getCallState() == 15 || GroupCallPip.isShowing()) ? false : true;
            if (!isPlayingVoice() && !z2 && (this.fragment instanceof ChatActivity) && !GroupCallPip.isShowing()) {
                ChatObject.Call groupCall = ((ChatActivity) this.fragment).getGroupCall();
                z2 = groupCall != null && groupCall.shouldShowPanel();
            }
            if (z2) {
                checkCall(false);
                return;
            }
            if (this.visible) {
                ActionBarMenuItem actionBarMenuItem = this.playbackSpeedButton;
                if (actionBarMenuItem != null && actionBarMenuItem.isSubMenuShowing()) {
                    this.playbackSpeedButton.toggleSubMenu();
                }
                this.visible = false;
                if (create) {
                    if (getVisibility() != 8) {
                        setVisibility(8);
                    }
                    setTopPadding(0.0f);
                    return;
                }
                AnimatorSet animatorSet = this.animatorSet;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.animatorSet = null;
                }
                this.animationIndex = NotificationCenter.getInstance(this.account).setAnimationInProgress(this.animationIndex, null);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "topPadding", 0.0f));
                this.animatorSet.setDuration(200L);
                FragmentContextViewDelegate fragmentContextViewDelegate = this.delegate;
                if (fragmentContextViewDelegate != null) {
                    fragmentContextViewDelegate.onAnimation(true, false);
                }
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.9
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) throws InterruptedException {
                        NotificationCenter.getInstance(FragmentContextView.this.account).onAnimationFinish(FragmentContextView.this.animationIndex);
                        if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                            return;
                        }
                        FragmentContextView.this.setVisibility(8);
                        if (FragmentContextView.this.delegate != null) {
                            FragmentContextView.this.delegate.onAnimation(false, false);
                        }
                        FragmentContextView.this.animatorSet = null;
                        if (!FragmentContextView.this.checkCallAfterAnimation) {
                            if (FragmentContextView.this.checkPlayerAfterAnimation) {
                                FragmentContextView.this.checkPlayer(false);
                            } else if (FragmentContextView.this.checkImportAfterAnimation) {
                                FragmentContextView.this.checkImport(false);
                            }
                        } else {
                            FragmentContextView.this.checkCall(false);
                        }
                        FragmentContextView.this.checkCallAfterAnimation = false;
                        FragmentContextView.this.checkPlayerAfterAnimation = false;
                        FragmentContextView.this.checkImportAfterAnimation = false;
                    }
                });
                this.animatorSet.start();
                return;
            }
            setVisibility(8);
            return;
        }
        int i2 = this.currentStyle;
        if (i2 != 0 && this.animatorSet != null && !create) {
            this.checkPlayerAfterAnimation = true;
            return;
        }
        updateStyle(0);
        if (create && this.topPadding == 0.0f) {
            updatePaddings();
            setTopPadding(AndroidUtilities.dp2(getStyleHeight()));
            FragmentContextViewDelegate fragmentContextViewDelegate2 = this.delegate;
            if (fragmentContextViewDelegate2 != null) {
                fragmentContextViewDelegate2.onAnimation(true, true);
                this.delegate.onAnimation(false, true);
            }
        }
        if (!this.visible) {
            if (!create) {
                AnimatorSet animatorSet3 = this.animatorSet;
                if (animatorSet3 != null) {
                    animatorSet3.cancel();
                    this.animatorSet = null;
                }
                this.animationIndex = NotificationCenter.getInstance(this.account).setAnimationInProgress(this.animationIndex, null);
                this.animatorSet = new AnimatorSet();
                FragmentContextView fragmentContextView = this.additionalContextView;
                if (fragmentContextView != null && fragmentContextView.getVisibility() == 0) {
                    ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = -AndroidUtilities.dp(getStyleHeight() + this.additionalContextView.getStyleHeight());
                } else {
                    ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = -AndroidUtilities.dp(getStyleHeight());
                }
                FragmentContextViewDelegate fragmentContextViewDelegate3 = this.delegate;
                if (fragmentContextViewDelegate3 != null) {
                    fragmentContextViewDelegate3.onAnimation(true, true);
                }
                this.animatorSet.playTogether(ObjectAnimator.ofFloat(this, "topPadding", AndroidUtilities.dp2(getStyleHeight())));
                this.animatorSet.setDuration(200L);
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) throws InterruptedException {
                        NotificationCenter.getInstance(FragmentContextView.this.account).onAnimationFinish(FragmentContextView.this.animationIndex);
                        if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                            return;
                        }
                        if (FragmentContextView.this.delegate != null) {
                            FragmentContextView.this.delegate.onAnimation(false, true);
                        }
                        FragmentContextView.this.animatorSet = null;
                        if (!FragmentContextView.this.checkCallAfterAnimation) {
                            if (FragmentContextView.this.checkPlayerAfterAnimation) {
                                FragmentContextView.this.checkPlayer(false);
                            } else if (FragmentContextView.this.checkImportAfterAnimation) {
                                FragmentContextView.this.checkImport(false);
                            }
                        } else {
                            FragmentContextView.this.checkCall(false);
                        }
                        FragmentContextView.this.checkCallAfterAnimation = false;
                        FragmentContextView.this.checkPlayerAfterAnimation = false;
                        FragmentContextView.this.checkImportAfterAnimation = false;
                    }
                });
                this.animatorSet.start();
            }
            this.visible = true;
            setVisibility(0);
        }
        if (MediaController.getInstance().isMessagePaused()) {
            this.playPauseDrawable.setPause(false, !create);
            this.playButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        } else {
            this.playPauseDrawable.setPause(true, !create);
            this.playButton.setContentDescription(LocaleController.getString("AccActionPause", R.string.AccActionPause));
        }
        if (this.lastMessageObject == playingMessageObject && i2 == 0) {
            return;
        }
        this.lastMessageObject = playingMessageObject;
        if (playingMessageObject.isVoice() || this.lastMessageObject.isRoundVideo()) {
            this.isMusic = false;
            ActionBarMenuItem actionBarMenuItem2 = this.playbackSpeedButton;
            if (actionBarMenuItem2 != null) {
                actionBarMenuItem2.setAlpha(1.0f);
                this.playbackSpeedButton.setEnabled(true);
            }
            this.titleTextView.setPadding(0, 0, AndroidUtilities.dp(44.0f), 0);
            spannableStringBuilder = new SpannableStringBuilder(String.format("%s %s", playingMessageObject.getMusicAuthor(), playingMessageObject.getMusicTitle()));
            int i3 = 0;
            while (i3 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
                TextView textView = i3 == 0 ? clippingTextViewSwitcher.getTextView() : clippingTextViewSwitcher.getNextTextView();
                if (textView != null) {
                    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                }
                i3++;
            }
            updatePlaybackButton();
        } else {
            this.isMusic = true;
            ActionBarMenuItem actionBarMenuItem3 = this.playbackSpeedButton;
            if (actionBarMenuItem3 != null) {
                actionBarMenuItem3.setAlpha(1.0f);
                this.playbackSpeedButton.setEnabled(true);
                this.titleTextView.setPadding(0, 0, AndroidUtilities.dp(44.0f), 0);
                updatePlaybackButton();
            } else {
                this.titleTextView.setPadding(0, 0, 0, 0);
            }
            spannableStringBuilder = new SpannableStringBuilder(String.format("%s - %s", playingMessageObject.getMusicAuthor(), playingMessageObject.getMusicTitle()));
            int i4 = 0;
            while (i4 < 2) {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher2 = this.titleTextView;
                TextView textView2 = i4 == 0 ? clippingTextViewSwitcher2.getTextView() : clippingTextViewSwitcher2.getNextTextView();
                if (textView2 != null) {
                    textView2.setEllipsize(TextUtils.TruncateAt.END);
                }
                i4++;
            }
        }
        spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true), 0, getThemedColor("inappPlayerPerformer")), 0, playingMessageObject.getMusicAuthor().length(), 18);
        this.titleTextView.setText(spannableStringBuilder, !create && z && this.isMusic);
    }

    public void checkImport(boolean create) {
        int i;
        BaseFragment baseFragment = this.fragment;
        if (baseFragment instanceof ChatActivity) {
            if (this.visible && ((i = this.currentStyle) == 1 || i == 3)) {
                return;
            }
            ChatActivity chatActivity = (ChatActivity) baseFragment;
            SendMessagesHelper.ImportingHistory importingHistory = chatActivity.getSendMessagesHelper().getImportingHistory(chatActivity.getDialogId());
            View fragmentView = this.fragment.getFragmentView();
            if (!create && fragmentView != null && (fragmentView.getParent() == null || ((View) fragmentView.getParent()).getVisibility() != 0)) {
                create = true;
            }
            Dialog visibleDialog = chatActivity.getVisibleDialog();
            if ((isPlayingVoice() || chatActivity.shouldShowImport() || ((visibleDialog instanceof ImportingAlert) && !((ImportingAlert) visibleDialog).isDismissed())) && importingHistory != null) {
                importingHistory = null;
            }
            if (importingHistory == null) {
                if (this.visible && ((create && this.currentStyle == -1) || this.currentStyle == 5)) {
                    this.visible = false;
                    if (create) {
                        if (getVisibility() != 8) {
                            setVisibility(8);
                        }
                        setTopPadding(0.0f);
                        return;
                    }
                    AnimatorSet animatorSet = this.animatorSet;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                        this.animatorSet = null;
                    }
                    final int i2 = this.account;
                    this.animationIndex = NotificationCenter.getInstance(i2).setAnimationInProgress(this.animationIndex, null);
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.animatorSet = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "topPadding", 0.0f));
                    this.animatorSet.setDuration(220L);
                    this.animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.11
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) throws InterruptedException {
                            NotificationCenter.getInstance(i2).onAnimationFinish(FragmentContextView.this.animationIndex);
                            if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                                return;
                            }
                            FragmentContextView.this.setVisibility(8);
                            FragmentContextView.this.animatorSet = null;
                            if (!FragmentContextView.this.checkCallAfterAnimation) {
                                if (FragmentContextView.this.checkPlayerAfterAnimation) {
                                    FragmentContextView.this.checkPlayer(false);
                                } else if (FragmentContextView.this.checkImportAfterAnimation) {
                                    FragmentContextView.this.checkImport(false);
                                }
                            } else {
                                FragmentContextView.this.checkCall(false);
                            }
                            FragmentContextView.this.checkCallAfterAnimation = false;
                            FragmentContextView.this.checkPlayerAfterAnimation = false;
                            FragmentContextView.this.checkImportAfterAnimation = false;
                        }
                    });
                    this.animatorSet.start();
                    return;
                }
                int i3 = this.currentStyle;
                if (i3 == -1 || i3 == 5) {
                    this.visible = false;
                    setVisibility(8);
                    return;
                }
                return;
            }
            if (this.currentStyle != 5 && this.animatorSet != null && !create) {
                this.checkImportAfterAnimation = true;
                return;
            }
            updateStyle(5);
            if (create && this.topPadding == 0.0f) {
                updatePaddings();
                setTopPadding(AndroidUtilities.dp2(getStyleHeight()));
                FragmentContextViewDelegate fragmentContextViewDelegate = this.delegate;
                if (fragmentContextViewDelegate != null) {
                    fragmentContextViewDelegate.onAnimation(true, true);
                    this.delegate.onAnimation(false, true);
                }
            }
            if (!this.visible) {
                if (!create) {
                    AnimatorSet animatorSet3 = this.animatorSet;
                    if (animatorSet3 != null) {
                        animatorSet3.cancel();
                        this.animatorSet = null;
                    }
                    this.animationIndex = NotificationCenter.getInstance(this.account).setAnimationInProgress(this.animationIndex, null);
                    this.animatorSet = new AnimatorSet();
                    FragmentContextView fragmentContextView = this.additionalContextView;
                    if (fragmentContextView != null && fragmentContextView.getVisibility() == 0) {
                        ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = -AndroidUtilities.dp(getStyleHeight() + this.additionalContextView.getStyleHeight());
                    } else {
                        ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = -AndroidUtilities.dp(getStyleHeight());
                    }
                    FragmentContextViewDelegate fragmentContextViewDelegate2 = this.delegate;
                    if (fragmentContextViewDelegate2 != null) {
                        fragmentContextViewDelegate2.onAnimation(true, true);
                    }
                    this.animatorSet.playTogether(ObjectAnimator.ofFloat(this, "topPadding", AndroidUtilities.dp2(getStyleHeight())));
                    this.animatorSet.setDuration(200L);
                    this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FragmentContextView.12
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) throws InterruptedException {
                            NotificationCenter.getInstance(FragmentContextView.this.account).onAnimationFinish(FragmentContextView.this.animationIndex);
                            if (FragmentContextView.this.animatorSet == null || !FragmentContextView.this.animatorSet.equals(animation)) {
                                return;
                            }
                            if (FragmentContextView.this.delegate != null) {
                                FragmentContextView.this.delegate.onAnimation(false, true);
                            }
                            FragmentContextView.this.animatorSet = null;
                            if (!FragmentContextView.this.checkCallAfterAnimation) {
                                if (FragmentContextView.this.checkPlayerAfterAnimation) {
                                    FragmentContextView.this.checkPlayer(false);
                                } else if (FragmentContextView.this.checkImportAfterAnimation) {
                                    FragmentContextView.this.checkImport(false);
                                }
                            } else {
                                FragmentContextView.this.checkCall(false);
                            }
                            FragmentContextView.this.checkCallAfterAnimation = false;
                            FragmentContextView.this.checkPlayerAfterAnimation = false;
                            FragmentContextView.this.checkImportAfterAnimation = false;
                        }
                    });
                    this.animatorSet.start();
                }
                this.visible = true;
                setVisibility(0);
            }
            int i4 = this.currentProgress;
            int i5 = importingHistory.uploadProgress;
            if (i4 != i5) {
                this.currentProgress = i5;
                this.titleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ImportUploading", R.string.ImportUploading, Integer.valueOf(i5))), false);
            }
        }
    }

    private boolean isPlayingVoice() {
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        return playingMessageObject != null && playingMessageObject.isVoice();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkCall(boolean r17) {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FragmentContextView.checkCall(boolean):void");
    }

    private void updateAvatars(boolean animated) {
        ChatObject.Call groupCall;
        int account;
        TLRPC$User user;
        int currentAccount;
        ValueAnimator valueAnimator;
        if (!animated && (valueAnimator = this.avatars.transitionProgressAnimator) != null) {
            valueAnimator.cancel();
            this.avatars.transitionProgressAnimator = null;
        }
        AvatarsImageView avatarsImageView = this.avatars;
        if (avatarsImageView.transitionProgressAnimator == null) {
            if (this.currentStyle == 4) {
                BaseFragment baseFragment = this.fragment;
                if (baseFragment instanceof ChatActivity) {
                    ChatActivity chatActivity = (ChatActivity) baseFragment;
                    groupCall = chatActivity.getGroupCall();
                    currentAccount = chatActivity.getCurrentAccount();
                } else {
                    currentAccount = this.account;
                    groupCall = null;
                }
                account = currentAccount;
                user = null;
            } else if (VoIPService.getSharedInstance() != null) {
                groupCall = VoIPService.getSharedInstance().groupCall;
                user = this.fragment instanceof ChatActivity ? null : VoIPService.getSharedInstance().getUser();
                account = VoIPService.getSharedInstance().getAccount();
            } else {
                groupCall = null;
                account = this.account;
                user = null;
            }
            int i = 0;
            if (groupCall != null) {
                int size = groupCall.sortedParticipants.size();
                while (i < 3) {
                    if (i < size) {
                        this.avatars.setObject(i, account, groupCall.sortedParticipants.get(i));
                    } else {
                        this.avatars.setObject(i, account, null);
                    }
                    i++;
                }
            } else if (user != null) {
                this.avatars.setObject(0, account, user);
                for (int i2 = 1; i2 < 3; i2++) {
                    this.avatars.setObject(i2, account, null);
                }
            } else {
                while (i < 3) {
                    this.avatars.setObject(i, account, null);
                    i++;
                }
            }
            this.avatars.commitTransition(animated);
            if (this.currentStyle != 4 || groupCall == null) {
                return;
            }
            int iMin = Math.min(3, groupCall.sortedParticipants.size());
            int i3 = iMin != 0 ? 10 + ((iMin - 1) * 24) + 10 + 32 : 10;
            if (animated) {
                int i4 = ((FrameLayout.LayoutParams) this.titleTextView.getLayoutParams()).leftMargin;
                if (AndroidUtilities.dp(i3) != i4) {
                    float translationX = (this.titleTextView.getTranslationX() + i4) - AndroidUtilities.dp(r2);
                    this.titleTextView.setTranslationX(translationX);
                    this.subtitleTextView.setTranslationX(translationX);
                    ViewPropertyAnimator duration = this.titleTextView.animate().translationX(0.0f).setDuration(220L);
                    CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
                    duration.setInterpolator(cubicBezierInterpolator);
                    this.subtitleTextView.animate().translationX(0.0f).setDuration(220L).setInterpolator(cubicBezierInterpolator);
                }
            } else {
                this.titleTextView.animate().cancel();
                this.subtitleTextView.animate().cancel();
                this.titleTextView.setTranslationX(0.0f);
                this.subtitleTextView.setTranslationX(0.0f);
            }
            float f = i3;
            this.titleTextView.setLayoutParams(LayoutHelper.createFrame(-1, 20.0f, 51, f, 5.0f, groupCall.isScheduled() ? 90.0f : 36.0f, 0.0f));
            this.subtitleTextView.setLayoutParams(LayoutHelper.createFrame(-1, 20.0f, 51, f, 25.0f, groupCall.isScheduled() ? 90.0f : 36.0f, 0.0f));
            return;
        }
        avatarsImageView.updateAfterTransitionEnd();
    }

    public void setCollapseTransition(boolean show, float extraHeight, float progress) {
        this.collapseTransition = show;
        this.extraHeight = extraHeight;
        this.collapseProgress = progress;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.drawOverlay || getVisibility() == 0) {
            boolean z = false;
            int i = this.currentStyle;
            if ((i == 3 || i == 1) && this.drawOverlay) {
                if (GroupCallActivity.groupCallInstance == null) {
                    Theme.getFragmentContextViewWavesDrawable().getState();
                }
                Theme.getFragmentContextViewWavesDrawable().updateState(this.wasDraw);
                float fDp = this.topPadding / AndroidUtilities.dp(getStyleHeight());
                if (this.collapseTransition) {
                    Theme.getFragmentContextViewWavesDrawable().draw(0.0f, (AndroidUtilities.dp(getStyleHeight()) - this.topPadding) + this.extraHeight, getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(2.0f), canvas, null, Math.min(fDp, 1.0f - this.collapseProgress));
                } else {
                    Theme.getFragmentContextViewWavesDrawable().draw(0.0f, AndroidUtilities.dp(getStyleHeight()) - this.topPadding, getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(2.0f), canvas, this, fDp);
                }
                float fDp2 = AndroidUtilities.dp(getStyleHeight()) - this.topPadding;
                if (this.collapseTransition) {
                    fDp2 += this.extraHeight;
                }
                if (fDp2 > getMeasuredHeight()) {
                    return;
                }
                canvas.save();
                canvas.clipRect(0.0f, fDp2, getMeasuredWidth(), getMeasuredHeight());
                invalidate();
                z = true;
            }
            super.dispatchDraw(canvas);
            if (z) {
                canvas.restore();
            }
            this.wasDraw = true;
        }
    }

    public void setDrawOverlay(boolean drawOverlay) {
        this.drawOverlay = drawOverlay;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        int i = this.currentStyle;
        if ((i == 3 || i == 1) && getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isCallStyle() {
        int i = this.currentStyle;
        return i == 3 || i == 1;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        updatePaddings();
        setTopPadding(this.topPadding);
        if (visibility == 8) {
            this.wasDraw = false;
        }
    }

    private void updatePaddings() {
        int iDp = getVisibility() == 0 ? 0 - AndroidUtilities.dp(getStyleHeight()) : 0;
        FragmentContextView fragmentContextView = this.additionalContextView;
        if (fragmentContextView != null && fragmentContextView.getVisibility() == 0) {
            int iDp2 = iDp - AndroidUtilities.dp(this.additionalContextView.getStyleHeight());
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = iDp2;
            ((FrameLayout.LayoutParams) this.additionalContextView.getLayoutParams()).topMargin = iDp2;
            return;
        }
        ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = iDp;
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) {
        updateCallTitle();
    }

    private void updateCallTitle() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            int i = this.currentStyle;
            if (i == 1 || i == 3) {
                int callState = sharedInstance.getCallState();
                if (!sharedInstance.isSwitchingStream() && (callState == 1 || callState == 2 || callState == 6 || callState == 5)) {
                    this.titleTextView.setText(LocaleController.getString("VoipGroupConnecting", R.string.VoipGroupConnecting), false);
                    return;
                }
                if (sharedInstance.getChat() != null) {
                    if (!TextUtils.isEmpty(sharedInstance.groupCall.call.title)) {
                        this.titleTextView.setText(sharedInstance.groupCall.call.title, false);
                        return;
                    }
                    BaseFragment baseFragment = this.fragment;
                    if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).getCurrentChat() != null && ((ChatActivity) this.fragment).getCurrentChat().id == sharedInstance.getChat().id) {
                        if (ChatObject.isChannelOrGiga(((ChatActivity) this.fragment).getCurrentChat())) {
                            this.titleTextView.setText(LocaleController.getString("VoipChannelViewVoiceChat", R.string.VoipChannelViewVoiceChat), false);
                            return;
                        } else {
                            this.titleTextView.setText(LocaleController.getString("VoipGroupViewVoiceChat", R.string.VoipGroupViewVoiceChat), false);
                            return;
                        }
                    }
                    this.titleTextView.setText(sharedInstance.getChat().title, false);
                    return;
                }
                if (sharedInstance.getUser() != null) {
                    TLRPC$User user = sharedInstance.getUser();
                    BaseFragment baseFragment2 = this.fragment;
                    if ((baseFragment2 instanceof ChatActivity) && ((ChatActivity) baseFragment2).getCurrentUser() != null && ((ChatActivity) this.fragment).getCurrentUser().id == user.id) {
                        this.titleTextView.setText(LocaleController.getString("ReturnToCall", R.string.ReturnToCall));
                    } else {
                        this.titleTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
                    }
                }
            }
        }
    }

    private int getTitleTextColor() {
        int i = this.currentStyle;
        if (i == 4) {
            return getThemedColor("inappPlayerPerformer");
        }
        if (i == 1 || i == 3) {
            return getThemedColor("returnToCallText");
        }
        return getThemedColor("inappPlayerTitle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
