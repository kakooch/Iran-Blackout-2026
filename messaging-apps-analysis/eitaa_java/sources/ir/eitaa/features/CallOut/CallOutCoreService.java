package ir.eitaa.features.CallOut;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.LaunchActivity;
import org.linphone.core.Address;
import org.linphone.core.Call;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.core.tools.service.CoreManager;
import org.linphone.mediastream.Version;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class CallOutCoreService extends Service {
    private AudioManager mAudioManager;
    private boolean mIsVibrating;
    private CoreListenerStub mListener;
    private Vibrator mVibrator;
    protected boolean mIsInForegroundMode = false;
    protected Notification mServiceNotification = null;
    private boolean mIsListenerAdded = false;
    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Factory.instance();
        if (Version.sdkAboveOrEqual(26)) {
            createServiceNotificationChannel();
        }
        this.mVibrator = (Vibrator) getSystemService("vibrator");
        this.mAudioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.mListener = new CoreListenerStub() { // from class: ir.eitaa.features.CallOut.CallOutCoreService.1
            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onFirstCallStarted(Core core) {
                CallOutCoreService callOutCoreService = CallOutCoreService.this;
                if (!callOutCoreService.mIsInForegroundMode) {
                    callOutCoreService.startForeground();
                }
                Call currentCall = core.getCurrentCall();
                if (currentCall != null && currentCall.getDir() == Call.Dir.Incoming && core.isVibrationOnIncomingCallEnabled()) {
                    CallOutCoreService.this.vibrate(currentCall.getRemoteAddress());
                }
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
                if ((state == Call.State.End || state == Call.State.Error || state == Call.State.Connected) && CallOutCoreService.this.mIsVibrating) {
                    CallOutCoreService.this.mVibrator.cancel();
                    CallOutCoreService.this.mIsVibrating = false;
                }
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onLastCallEnded(Core core) {
                CallOutCoreService callOutCoreService = CallOutCoreService.this;
                if (callOutCoreService.mIsInForegroundMode) {
                    callOutCoreService.stopForeground();
                }
            }
        };
        addCoreListener();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (this.mIsListenerAdded) {
            return 1;
        }
        addCoreListener();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        if (CoreManager.isReady()) {
            Core core = CoreManager.instance().getCore();
            if (core != null) {
                core.removeListener(this.mListener);
            }
            CoreManager.instance().setServiceRunningAsForeground(false);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    private void addCoreListener() {
        Core core;
        if (!CoreManager.isReady() || (core = CoreManager.instance().getCore()) == null) {
            return;
        }
        core.addListener(this.mListener);
        this.mIsListenerAdded = true;
        if (core.getCallsNb() > 0) {
            startForeground();
            Call currentCall = core.getCurrentCall();
            if (currentCall != null && currentCall.getDir() == Call.Dir.Incoming && currentCall.getState() == Call.State.IncomingReceived && core.isVibrationOnIncomingCallEnabled()) {
                vibrate(currentCall.getRemoteAddress());
            }
        }
    }

    public void createServiceNotificationChannel() {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        NotificationChannel notificationChannel = new NotificationChannel("ir_eitaa_callout_core_service_notification_channel", "eitaa_callout_core_channel_name", 2);
        notificationChannel.setDescription("eitaa_callout_core_channel");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationChannel.setShowBadge(false);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel);
    }

    public void createServiceNotification() {
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent.setAction("ir.eitaa.opencall");
        intent.addCategory("android.intent.category.LAUNCHER");
        this.mServiceNotification = new NotificationCompat.Builder(this, "ir_eitaa_callout_core_service_notification_channel").setContentTitle(LocaleController.getString("CallOutTitle", R.string.CallOutTitle)).setContentText(LocaleController.getString("CallInProgress", R.string.CallInProgress)).setSmallIcon(R.drawable.intro_tg_plane).setAutoCancel(false).setCategory("service").setVisibility(-1).setWhen(System.currentTimeMillis()).setColorized(true).setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(PendingIntent.getActivity(ApplicationLoader.applicationContext, 0, intent, 0)).setShowWhen(true).setOngoing(true).build();
    }

    public void showForegroundServiceNotification() {
        if (this.mServiceNotification == null) {
            createServiceNotification();
        }
        DeviceUtils.startCallForegroundService(this, 1, this.mServiceNotification);
    }

    public void hideForegroundServiceNotification() {
        stopForeground(true);
    }

    void startForeground() {
        showForegroundServiceNotification();
        this.mIsInForegroundMode = true;
        if (CoreManager.isReady()) {
            CoreManager.instance().setServiceRunningAsForeground(this.mIsInForegroundMode);
        }
    }

    void stopForeground() {
        if (this.mIsInForegroundMode) {
            hideForegroundServiceNotification();
            this.mIsInForegroundMode = false;
            if (CoreManager.isReady()) {
                CoreManager.instance().setServiceRunningAsForeground(this.mIsInForegroundMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vibrate(Address caller) {
        Vibrator vibrator = this.mVibrator;
        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }
        if (this.mAudioManager.getRingerMode() == 0) {
            if (DeviceUtils.checkIfDoNotDisturbAllowsExceptionForFavoriteContacts(this) && DeviceUtils.checkIfIsFavoriteContact(this, caller)) {
                DeviceUtils.vibrate(this.mVibrator);
                this.mIsVibrating = true;
                return;
            }
            return;
        }
        DeviceUtils.vibrate(this.mVibrator);
        this.mIsVibrating = true;
    }
}
