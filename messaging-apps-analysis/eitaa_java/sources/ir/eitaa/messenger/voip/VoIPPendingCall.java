package ir.eitaa.messenger.voip;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.ui.Components.voip.VoIPHelper;

/* loaded from: classes.dex */
public final class VoIPPendingCall {
    private AccountInstance accountInstance;
    private final Activity activity;
    private Handler handler;
    private NotificationCenter notificationCenter;
    private final NotificationCenter.NotificationCenterDelegate observer;
    private final Runnable releaseRunnable;
    private boolean released;
    private final long userId;
    private final boolean video;

    public static VoIPPendingCall startOrSchedule(Activity activity, long userId, boolean video, AccountInstance accountInstance) {
        return new VoIPPendingCall(activity, userId, video, 1000L, accountInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$VoIPPendingCall() {
        onConnectionStateUpdated(true);
    }

    private VoIPPendingCall(Activity activity, long userId, boolean video, long expirationTime, AccountInstance accountInstance) {
        NotificationCenter.NotificationCenterDelegate notificationCenterDelegate = new NotificationCenter.NotificationCenterDelegate() { // from class: ir.eitaa.messenger.voip.VoIPPendingCall.1
            @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
            public void didReceivedNotification(int id, int account, Object... args) {
                if (id == NotificationCenter.contactsDidLoad) {
                    VoIPPendingCall.this.onConnectionStateUpdated(false);
                }
            }
        };
        this.observer = notificationCenterDelegate;
        Runnable runnable = new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VoIPPendingCall$GgVDfaVe6Q6LELWN2SS1BnqOP7s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$VoIPPendingCall();
            }
        };
        this.releaseRunnable = runnable;
        this.activity = activity;
        this.userId = userId;
        this.video = video;
        this.accountInstance = accountInstance;
        if (onConnectionStateUpdated(false)) {
            return;
        }
        NotificationCenter notificationCenter = NotificationCenter.getInstance(UserConfig.selectedAccount);
        this.notificationCenter = notificationCenter;
        notificationCenter.addObserver(notificationCenterDelegate, NotificationCenter.didUpdateConnectionState);
        Handler handler = new Handler(Looper.myLooper());
        this.handler = handler;
        handler.postDelayed(runnable, expirationTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onConnectionStateUpdated(boolean force) {
        if (this.released || !(force || isConnected(this.accountInstance) || isAirplaneMode())) {
            return false;
        }
        MessagesController messagesController = this.accountInstance.getMessagesController();
        TLRPC$User user = messagesController.getUser(Long.valueOf(this.userId));
        if (user != null) {
            TLRPC$UserFull userFull = messagesController.getUserFull(user.id);
            VoIPHelper.startCall(user, this.video, userFull != null && userFull.video_calls_available, this.activity, userFull, this.accountInstance);
        } else if (isAirplaneMode()) {
            VoIPHelper.startCall(null, this.video, false, this.activity, null, this.accountInstance);
        }
        release();
        return true;
    }

    private boolean isConnected(AccountInstance accountInstance) {
        return accountInstance.getConnectionsManager().getConnectionState() == 3;
    }

    private boolean isAirplaneMode() {
        return Settings.System.getInt(this.activity.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public void release() {
        if (this.released) {
            return;
        }
        NotificationCenter notificationCenter = this.notificationCenter;
        if (notificationCenter != null) {
            notificationCenter.removeObserver(this.observer, NotificationCenter.didUpdateConnectionState);
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.releaseRunnable);
        }
        this.released = true;
    }
}
