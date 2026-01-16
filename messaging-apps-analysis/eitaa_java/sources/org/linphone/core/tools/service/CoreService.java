package org.linphone.core.tools.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import org.linphone.core.Address;
import org.linphone.core.Call;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.mediastream.Version;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class CoreService extends Service {
    protected static final String SERVICE_NOTIFICATION_CHANNEL_DESC = "Used to keep the call(s) alive";
    protected static final String SERVICE_NOTIFICATION_CHANNEL_ID = "org_linphone_core_service_notification_channel";
    protected static final String SERVICE_NOTIFICATION_CHANNEL_NAME = "Linphone Core Service";
    protected static final String SERVICE_NOTIFICATION_CONTENT = "Used to keep the call(s) alive";
    protected static final String SERVICE_NOTIFICATION_TITLE = "Linphone Core Service";
    protected static final int SERVICE_NOTIF_ID = 1;
    private AudioManager mAudioManager;
    private boolean mIsVibrating;
    private CoreListenerStub mListener;
    private Vibrator mVibrator;
    protected boolean mIsInForegroundMode = false;
    protected Notification mServiceNotification = null;
    private boolean mIsListenerAdded = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
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
        this.mListener = new CoreListenerStub() { // from class: org.linphone.core.tools.service.CoreService.1
            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onFirstCallStarted(Core core) {
                Log.i("[Core Service] First call started");
                CoreService coreService = CoreService.this;
                if (!coreService.mIsInForegroundMode) {
                    coreService.startForeground();
                }
                Call currentCall = core.getCurrentCall();
                if (currentCall != null) {
                    if (currentCall.getDir() == Call.Dir.Incoming && core.isVibrationOnIncomingCallEnabled()) {
                        CoreService.this.vibrate(currentCall.getRemoteAddress());
                        return;
                    }
                    return;
                }
                Log.w("[Core Service] Couldn't find current call...");
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onCallStateChanged(Core core, Call call, Call.State state, String str) {
                if ((state == Call.State.End || state == Call.State.Error || state == Call.State.Connected) && CoreService.this.mIsVibrating) {
                    Log.i("[Core Service] Stopping vibrator");
                    CoreService.this.mVibrator.cancel();
                    CoreService.this.mIsVibrating = false;
                }
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onLastCallEnded(Core core) {
                Log.i("[Core Service] Last call ended");
                CoreService coreService = CoreService.this;
                if (coreService.mIsInForegroundMode) {
                    coreService.stopForeground();
                }
            }
        };
        addCoreListener();
        Log.i("[Core Service] Created");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Log.i("[Core Service] Started");
        if (!this.mIsListenerAdded) {
            addCoreListener();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        Log.i("[Core Service] Task removed");
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        Log.i("[Core Service] Stopping");
        if (CoreManager.isReady()) {
            Core core = CoreManager.instance().getCore();
            if (core != null) {
                Log.i("[Core Service] Core Manager found, removing our listener");
                core.removeListener(this.mListener);
            }
            CoreManager.instance().setServiceRunningAsForeground(false);
        }
        super.onDestroy();
    }

    private void addCoreListener() {
        Log.i("[Core Service] Trying to add the Service's CoreListener to the Core...");
        if (CoreManager.isReady()) {
            Core core = CoreManager.instance().getCore();
            if (core != null) {
                Log.i("[Core Service] Core Manager found, adding our listener");
                core.addListener(this.mListener);
                this.mIsListenerAdded = true;
                Log.i("[Core Service] CoreListener succesfully added to the Core");
                if (core.getCallsNb() > 0) {
                    Log.w("[Core Service] Core listener added while at least one call active !");
                    startForeground();
                    Call currentCall = core.getCurrentCall();
                    if (currentCall != null) {
                        if (currentCall.getDir() == Call.Dir.Incoming && currentCall.getState() == Call.State.IncomingReceived && core.isVibrationOnIncomingCallEnabled()) {
                            vibrate(currentCall.getRemoteAddress());
                            return;
                        }
                        return;
                    }
                    Log.w("[Core Service] Couldn't find current call...");
                    return;
                }
                return;
            }
            Log.e("[Core Service] CoreManager instance found but Core is null!");
            return;
        }
        Log.w("[Core Service] CoreManager isn't ready yet...");
    }

    public void createServiceNotificationChannel() {
        Log.i("[Core Service] Android >= 8.0 detected, creating notification channel");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        NotificationChannel notificationChannel = new NotificationChannel(SERVICE_NOTIFICATION_CHANNEL_ID, "Linphone Core Service", 2);
        notificationChannel.setDescription("Used to keep the call(s) alive");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationChannel.setShowBadge(false);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel);
    }

    public void createServiceNotification() {
        this.mServiceNotification = new NotificationCompat.Builder(this, SERVICE_NOTIFICATION_CHANNEL_ID).setContentTitle("Linphone Core Service").setContentText("Used to keep the call(s) alive").setSmallIcon(getApplicationInfo().icon).setAutoCancel(false).setCategory("service").setVisibility(-1).setWhen(System.currentTimeMillis()).setShowWhen(true).setOngoing(true).build();
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
        Log.i("[Core Service] Starting service as foreground");
        showForegroundServiceNotification();
        this.mIsInForegroundMode = true;
        if (CoreManager.isReady()) {
            CoreManager.instance().setServiceRunningAsForeground(this.mIsInForegroundMode);
        }
    }

    void stopForeground() {
        if (!this.mIsInForegroundMode) {
            Log.w("[Core Service] Service isn't in foreground mode, nothing to do");
            return;
        }
        Log.i("[Core Service] Stopping service as foreground");
        hideForegroundServiceNotification();
        this.mIsInForegroundMode = false;
        if (CoreManager.isReady()) {
            CoreManager.instance().setServiceRunningAsForeground(this.mIsInForegroundMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vibrate(Address address) {
        Vibrator vibrator = this.mVibrator;
        if (vibrator != null && vibrator.hasVibrator()) {
            if (this.mAudioManager.getRingerMode() == 0) {
                if (DeviceUtils.checkIfDoNotDisturbAllowsExceptionForFavoriteContacts(this)) {
                    if (DeviceUtils.checkIfIsFavoriteContact(this, address)) {
                        Log.i("[Core Service] Ringer mode is set to silent unless for favorite contact, which seems to be the case here, so starting vibrator");
                        DeviceUtils.vibrate(this.mVibrator);
                        this.mIsVibrating = true;
                        return;
                    }
                    Log.i("[Core Service] Do not vibrate as ringer mode is set to silent and calling username / SIP address isn't part of a favorite contact");
                    return;
                }
                Log.i("[Core Service] Do not vibrate as ringer mode is set to silent");
                return;
            }
            Log.i("[Core Service] Starting vibrator");
            DeviceUtils.vibrate(this.mVibrator);
            this.mIsVibrating = true;
            return;
        }
        Log.e("[Core Service] Device doesn't have a vibrator");
    }
}
