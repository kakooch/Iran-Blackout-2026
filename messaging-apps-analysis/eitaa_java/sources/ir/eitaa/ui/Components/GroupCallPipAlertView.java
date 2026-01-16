package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.voip.VoIPButtonsLayout;
import ir.eitaa.ui.Components.voip.VoIPToggleButton;
import ir.eitaa.ui.GroupCallActivity;
import ir.eitaa.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class GroupCallPipAlertView extends LinearLayout implements VoIPService.StateListener, NotificationCenter.NotificationCenterDelegate {
    BackupImageView avatarImageView;
    int currentAccount;
    float cx;
    float cy;
    FrameLayout groupInfoContainer;
    private boolean invalidateGradient;
    VoIPToggleButton leaveButton;
    LinearGradient linearGradient;
    VoIPToggleButton muteButton;
    float muteProgress;
    private boolean mutedByAdmin;
    float mutedByAdminProgress;
    Paint paint;
    private int position;
    RectF rectF;
    VoIPToggleButton soundButton;
    TextView subtitleView;
    TextView titleView;

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

    public GroupCallPipAlertView(final Context context, int account) {
        super(context);
        this.rectF = new RectF();
        this.paint = new Paint(1);
        this.invalidateGradient = true;
        setOrientation(1);
        this.currentAccount = account;
        this.paint.setAlpha(234);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.GroupCallPipAlertView.1
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                if (Build.VERSION.SDK_INT >= 21) {
                    VoIPService sharedInstance = VoIPService.getSharedInstance();
                    if (sharedInstance != null && ChatObject.isChannelOrGiga(sharedInstance.getChat())) {
                        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("VoipChannelOpenVoiceChat", R.string.VoipChannelOpenVoiceChat)));
                    } else {
                        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("VoipGroupOpenVoiceChat", R.string.VoipGroupOpenVoiceChat)));
                    }
                }
            }
        };
        this.groupInfoContainer = frameLayout;
        frameLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(22.0f));
        this.groupInfoContainer.addView(this.avatarImageView, LayoutHelper.createFrame(44, 44.0f));
        this.groupInfoContainer.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), 0, ColorUtils.setAlphaComponent(-1, 76)));
        this.groupInfoContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupCallPipAlertView$yj_4ZNTbjFXv0GZXF2E_X5axIWg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$GroupCallPipAlertView(view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setTextColor(-1);
        this.titleView.setTextSize(15.0f);
        this.titleView.setMaxLines(2);
        this.titleView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleView.setTypeface(AndroidUtilities.getFontFamily(true));
        linearLayout.addView(this.titleView, LayoutHelper.createLinear(-1, -2));
        TextView textView2 = new TextView(context);
        this.subtitleView = textView2;
        textView2.setTextSize(12.0f);
        this.subtitleView.setTextColor(ColorUtils.setAlphaComponent(-1, 153));
        linearLayout.addView(this.subtitleView, LayoutHelper.createLinear(-1, -2));
        this.groupInfoContainer.addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 16, 55.0f, 0.0f, 0.0f, 0.0f));
        addView(this.groupInfoContainer, LayoutHelper.createLinear(-1, -2, 0, 10, 10, 10, 10));
        VoIPToggleButton voIPToggleButton = new VoIPToggleButton(context, 44.0f);
        this.soundButton = voIPToggleButton;
        voIPToggleButton.setTextSize(12);
        this.soundButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupCallPipAlertView$fwcOs2ZKdL-Hq4smhb-legYKdmY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$GroupCallPipAlertView(context, view);
            }
        });
        this.soundButton.setCheckable(true);
        this.soundButton.setBackgroundColor(ColorUtils.setAlphaComponent(-1, 38), ColorUtils.setAlphaComponent(-1, 76));
        VoIPToggleButton voIPToggleButton2 = new VoIPToggleButton(context, 44.0f);
        this.muteButton = voIPToggleButton2;
        voIPToggleButton2.setTextSize(12);
        this.muteButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupCallPipAlertView$0S2mG4N7IHUJipgPA6b2rU9U8-o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$GroupCallPipAlertView(context, view);
            }
        });
        VoIPToggleButton voIPToggleButton3 = new VoIPToggleButton(context, 44.0f);
        this.leaveButton = voIPToggleButton3;
        voIPToggleButton3.setTextSize(12);
        this.leaveButton.setData(R.drawable.calls_decline, -1, -3257782, 0.3f, false, LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), false, false);
        this.leaveButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupCallPipAlertView$F3rbMdBmUtE-IjIMRcsKGjZ3ptE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException, InterruptedException {
                this.f$0.lambda$new$4$GroupCallPipAlertView(context, view);
            }
        });
        VoIPButtonsLayout voIPButtonsLayout = new VoIPButtonsLayout(context);
        voIPButtonsLayout.setChildSize(68);
        voIPButtonsLayout.setUseStartPadding(false);
        voIPButtonsLayout.addView(this.soundButton, LayoutHelper.createFrame(68, 63.0f));
        voIPButtonsLayout.addView(this.muteButton, LayoutHelper.createFrame(68, 63.0f));
        voIPButtonsLayout.addView(this.leaveButton, LayoutHelper.createFrame(68, 63.0f));
        setWillNotDraw(false);
        addView(voIPButtonsLayout, LayoutHelper.createLinear(-1, -2, 0, 6, 0, 6, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$GroupCallPipAlertView(View view) {
        if (VoIPService.getSharedInstance() != null) {
            Intent action = new Intent(getContext(), (Class<?>) LaunchActivity.class).setAction("voip_chat");
            action.putExtra("currentAccount", VoIPService.getSharedInstance().getAccount());
            getContext().startActivity(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$GroupCallPipAlertView(Context context, View view) {
        if (VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(getContext(), Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$GroupCallPipAlertView(Context context, View view) {
        if (VoIPService.getSharedInstance() != null) {
            if (VoIPService.getSharedInstance().mutedByAdmin()) {
                this.muteButton.shakeView();
                try {
                    Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(200L);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            VoIPService.getSharedInstance().setMicMute(!VoIPService.getSharedInstance().isMicMute(), false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$GroupCallPipAlertView(final Context context, View view) throws IllegalStateException, InterruptedException {
        GroupCallActivity.onLeaveClick(getContext(), new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupCallPipAlertView$Z69z6MiX_LT6pjVaP3p-zVuP1sw
            @Override // java.lang.Runnable
            public final void run() {
                GroupCallPip.updateVisibility(context);
            }
        }, Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    @Override // android.widget.LinearLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 719
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupCallPipAlertView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(230.0f), 1073741824), heightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        String strTrim;
        super.onAttachedToWindow();
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null && sharedInstance.groupCall != null) {
            int colorForId = AvatarDrawable.getColorForId(sharedInstance.getChat().id);
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setColor(colorForId);
            avatarDrawable.setInfo(sharedInstance.getChat());
            this.avatarImageView.setImage(ImageLocation.getForLocal(sharedInstance.getChat().photo.photo_small), "50_50", avatarDrawable, (Object) null);
            if (!TextUtils.isEmpty(sharedInstance.groupCall.call.title)) {
                strTrim = sharedInstance.groupCall.call.title;
            } else {
                strTrim = sharedInstance.getChat().title;
            }
            if (strTrim != null) {
                strTrim = strTrim.replace("\n", " ").replaceAll(" +", " ").trim();
            }
            this.titleView.setText(strTrim);
            updateMembersCount();
            sharedInstance.registerStateListener(this);
            if (VoIPService.getSharedInstance() != null) {
                this.mutedByAdmin = VoIPService.getSharedInstance().mutedByAdmin();
            }
            this.mutedByAdminProgress = this.mutedByAdmin ? 1.0f : 0.0f;
            this.muteProgress = VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute() || this.mutedByAdmin ? 1.0f : 0.0f;
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupCallUpdated);
        updateButtons(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.unregisterStateListener(this);
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
    }

    private void updateMembersCount() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null || sharedInstance.groupCall == null) {
            return;
        }
        int callState = sharedInstance.getCallState();
        if (!sharedInstance.isSwitchingStream() && (callState == 1 || callState == 2 || callState == 6 || callState == 5)) {
            this.subtitleView.setText(LocaleController.getString("VoipGroupConnecting", R.string.VoipGroupConnecting));
        } else {
            this.subtitleView.setText(LocaleController.formatPluralString("Participants", sharedInstance.groupCall.call.participants_count));
        }
    }

    private void updateButtons(boolean animated) {
        VoIPService sharedInstance;
        int i;
        String str;
        if (this.soundButton == null || this.muteButton == null || (sharedInstance = VoIPService.getSharedInstance()) == null) {
            return;
        }
        boolean zIsBluetoothOn = sharedInstance.isBluetoothOn();
        boolean z = !zIsBluetoothOn && sharedInstance.isSpeakerphoneOn();
        this.soundButton.setChecked(z, animated);
        if (zIsBluetoothOn) {
            this.soundButton.setData(R.drawable.calls_bluetooth, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth), false, animated);
        } else if (z) {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.3f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
        } else if (sharedInstance.isHeadsetPlugged()) {
            this.soundButton.setData(R.drawable.calls_headphones, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingHeadset", R.string.VoipAudioRoutingHeadset), false, animated);
        } else {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.1f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
        }
        if (sharedInstance.mutedByAdmin()) {
            this.muteButton.setData(R.drawable.calls_unmute, -1, ColorUtils.setAlphaComponent(-1, 76), 0.1f, true, LocaleController.getString("VoipMutedByAdminShort", R.string.VoipMutedByAdminShort), true, animated);
        } else {
            VoIPToggleButton voIPToggleButton = this.muteButton;
            int alphaComponent = ColorUtils.setAlphaComponent(-1, (int) ((sharedInstance.isMicMute() ? 0.3f : 0.15f) * 255.0f));
            if (sharedInstance.isMicMute()) {
                i = R.string.VoipUnmute;
                str = "VoipUnmute";
            } else {
                i = R.string.VoipMute;
                str = "VoipMute";
            }
            voIPToggleButton.setData(R.drawable.calls_unmute, -1, alphaComponent, 0.1f, true, LocaleController.getString(str, i), sharedInstance.isMicMute(), animated);
        }
        invalidate();
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() {
        updateButtons(true);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) {
        updateMembersCount();
    }

    public void setPosition(int position, float cx, float cy) {
        this.position = position;
        this.cx = cx;
        this.cy = cy;
        invalidate();
        this.invalidateGradient = true;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        boolean zMutedByAdmin;
        if (id == NotificationCenter.groupCallUpdated) {
            updateMembersCount();
            if (VoIPService.getSharedInstance() == null || (zMutedByAdmin = VoIPService.getSharedInstance().mutedByAdmin()) == this.mutedByAdmin) {
                return;
            }
            this.mutedByAdmin = zMutedByAdmin;
            invalidate();
        }
    }
}
