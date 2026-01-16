package org.linphone.core.tools.service;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ServiceInfo;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import ir.eitaa.tgnet.ConnectionsManager;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.linphone.core.BuildConfig;
import org.linphone.core.Call;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.GlobalState;
import org.linphone.core.R$string;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.PushNotificationUtils;
import org.linphone.core.tools.audio.AudioHelper;
import org.linphone.core.tools.audio.BluetoothHelper;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.core.tools.receiver.ShutdownReceiver;
import org.linphone.mediastream.Version;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class CoreManager {
    private static final int AUTO_ITERATE_TIMER_CORE_START_OR_PUSH_RECEIVED = 20;
    private static final int AUTO_ITERATE_TIMER_RESET_AFTER = 20000;
    private static CoreManager sInstance;
    private Application.ActivityLifecycleCallbacks mActivityCallbacks;
    private AudioHelper mAudioHelper;
    private BluetoothHelper mBluetoothHelper;
    protected Context mContext;
    protected Core mCore;
    private DisplayManager.DisplayListener mDisplayListener;
    private DisplayManager mDisplayManager;
    private Timer mForcedIterateTimer;
    private Handler mHandler;
    private Runnable mIterateRunnable;
    private int mIterateSchedule;
    private CoreListenerStub mListener;
    private Class mServiceClass;
    private boolean mServiceRunningInForeground;
    private ShutdownReceiver mShutdownReceiver;
    private Timer mTimer;

    private native void enterBackground(long j);

    private native void enterForeground(long j);

    private native void healNetworkConnections(long j);

    private native void leaveConference(long j);

    private native void pauseAllCalls(long j);

    private native void processPushNotification(long j, String str, String str2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void reloadSoundDevices(long j);

    private native void stopCore(long j);

    private native void updatePushNotificationInformation(long j, String str, String str2);

    public static boolean isReady() {
        return sInstance != null;
    }

    public static CoreManager instance() {
        if (isReady()) {
            return sInstance;
        }
        Log.e("[Core Manager] Trying to access instance that doesn't exists!");
        throw new RuntimeException("CoreManager not instantiated yet");
    }

    public CoreManager(Object obj, Core core) throws ClassNotFoundException {
        this.mContext = ((Context) obj).getApplicationContext();
        this.mCore = core;
        sInstance = this;
        this.mServiceRunningInForeground = false;
        this.mTimer = null;
        this.mForcedIterateTimer = null;
        dumpDeviceInformation();
        dumpLinphoneInformation();
        DeviceUtils.logPreviousCrashesIfAny(this.mContext);
        ActivityMonitor activityMonitor = new ActivityMonitor();
        this.mActivityCallbacks = activityMonitor;
        ((Application) this.mContext).registerActivityLifecycleCallbacks(activityMonitor);
        PushNotificationUtils.init(this.mContext);
        if (!PushNotificationUtils.isAvailable(this.mContext)) {
            Log.w("[Core Manager] Push notifications aren't available (see push utils log)");
        }
        if (isAndroidXMediaAvailable()) {
            this.mAudioHelper = new AudioHelper(this.mContext);
        } else {
            Log.w("[Core Manager] Do you have a dependency on androidx.media:media:1.2.0 or newer?");
        }
        this.mBluetoothHelper = new BluetoothHelper(this.mContext);
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: org.linphone.core.tools.service.CoreManager.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
                Log.d("[Core Manager] Display added: ", Integer.valueOf(i));
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                Log.d("[Core Manager] Display changed: ", Integer.valueOf(i));
                CoreManager.this.updateOrientation(i);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
                Log.d("[Core Manager] Display removed: ", Integer.valueOf(i));
            }
        };
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService("display");
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mDisplayManager.registerDisplayListener(this.mDisplayListener, handler);
        updateOrientation(0);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.setPriority(999);
        this.mShutdownReceiver = new ShutdownReceiver();
        Log.i("[Core Manager] Registering shutdown receiver");
        this.mContext.registerReceiver(this.mShutdownReceiver, intentFilter);
        Class serviceClass = getServiceClass();
        this.mServiceClass = serviceClass;
        if (serviceClass == null) {
            this.mServiceClass = CoreService.class;
        }
        Log.i("[Core Manager] Ready");
    }

    public void destroy() {
        DisplayManager.DisplayListener displayListener;
        Log.i("[Core Manager] Destroying");
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityCallbacks;
        if (activityLifecycleCallbacks != null) {
            ((Application) this.mContext).unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.mActivityCallbacks = null;
        }
        BluetoothHelper bluetoothHelper = this.mBluetoothHelper;
        if (bluetoothHelper != null) {
            bluetoothHelper.destroy(this.mContext);
            this.mBluetoothHelper = null;
        }
        if (this.mShutdownReceiver != null) {
            Log.i("[Core Manager] Unregistering shutdown receiver");
            this.mContext.unregisterReceiver(this.mShutdownReceiver);
            this.mShutdownReceiver = null;
        }
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper != null) {
            audioHelper.destroy(this.mContext);
            this.mAudioHelper = null;
        }
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null && (displayListener = this.mDisplayListener) != null) {
            displayManager.unregisterDisplayListener(displayListener);
            this.mDisplayListener = null;
            this.mDisplayManager = null;
        }
        this.mServiceClass = null;
        this.mContext = null;
        sInstance = null;
        Log.i("[Core Manager] Destroyed");
    }

    public Core getCore() {
        return this.mCore;
    }

    public void processPushNotification(String str, String str2, boolean z) {
        if (this.mCore.isAutoIterateEnabled() && this.mCore.isInBackground()) {
            Log.i("[Core Manager] Push notification received, scheduling core.iterate() every 20ms");
            startAutoIterate(20);
            createTimerToResetAutoIterateSchedule();
        }
        Log.i("[Core Manager] Notifying Core a push with Call-ID [" + str + "] has been received");
        processPushNotification(this.mCore.getNativePointer(), str, str2, z);
    }

    public void healNetwork() {
        Core core = this.mCore;
        if (core != null) {
            healNetworkConnections(core.getNativePointer());
        }
    }

    public void onLinphoneCoreStart() {
        Log.i("[Core Manager] Starting");
        if (!isAndroidXMediaAvailable() && this.mCore.isNativeRingingEnabled()) {
            Log.e("[Core Manager] Native ringing was enabled but condition isn't met (androidx.media:media dependency), disabling it.");
            this.mCore.setNativeRingingEnabled(false);
        }
        if (this.mCore.isAutoIterateEnabled()) {
            Log.i("[Core Manager] Core is starting, scheduling core.iterate() every 20ms");
            startAutoIterate(20);
            createTimerToResetAutoIterateSchedule();
        } else {
            Log.w("[Core Manager] Auto core.iterate() isn't enabled, ensure you do it in your application!");
        }
        CoreListenerStub coreListenerStub = new CoreListenerStub() { // from class: org.linphone.core.tools.service.CoreManager.2
            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onFirstCallStarted(Core core) {
                Log.i("[Core Manager] First call started");
                if (!CoreManager.this.isServiceRunning()) {
                    Log.w("[Core Manager] Service isn't running, let's start it");
                    try {
                        CoreManager.this.startService();
                        return;
                    } catch (IllegalStateException e) {
                        Log.w("[Core Manager] Failed to start service: ", e);
                        return;
                    }
                }
                Log.i("[Core Manager] Service appears to be running, everything is fine");
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onLastCallEnded(Core core) {
                Log.i("[Core Manager] Last call ended");
                if (CoreManager.this.mAudioHelper == null) {
                    return;
                }
                if (core.isNativeRingingEnabled()) {
                    CoreManager.this.mAudioHelper.stopRinging();
                } else {
                    CoreManager.this.mAudioHelper.releaseRingingAudioFocus();
                }
                CoreManager.this.mAudioHelper.releaseCallAudioFocus();
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onCallStateChanged(Core core, Call call, Call.State state, String str) {
                if (CoreManager.this.mAudioHelper == null) {
                    return;
                }
                if (call.getState() != state) {
                    if (state == Call.State.IncomingReceived && call.getState() == Call.State.IncomingEarlyMedia) {
                        Log.w("[Core Manager] It seems call was accepted with early-media during the incoming received call state changed, continuing anyway");
                    } else {
                        Log.w("[Core Manager] Call state changed callback state variable doesn't match current call state, skipping");
                        return;
                    }
                }
                if (state == Call.State.IncomingReceived && core.getCallsNb() == 1) {
                    if (core.isNativeRingingEnabled()) {
                        Log.i("[Core Manager] Incoming call received, no other call, start ringing");
                        CoreManager.this.mAudioHelper.startRinging(CoreManager.this.mContext, core.getRing(), call.getRemoteAddress());
                        return;
                    } else {
                        Log.i("[Core Manager] Incoming call received, no other call, acquire ringing audio focus");
                        CoreManager.this.mAudioHelper.requestRingingAudioFocus();
                        return;
                    }
                }
                if (state == Call.State.IncomingEarlyMedia && core.getCallsNb() == 1) {
                    if (core.getRingDuringIncomingEarlyMedia()) {
                        Log.i("[Core Manager] Incoming call is early media and ringing is allowed");
                        return;
                    } else if (core.isNativeRingingEnabled()) {
                        Log.w("[Core Manager] Incoming call is early media and ringing is disabled, stop ringing");
                        CoreManager.this.mAudioHelper.stopRinging();
                        return;
                    } else {
                        Log.i("[Core Manager] Incoming call is early media and ringing is disabled, keep ringing audio focus as sound card will be using RING stream");
                        return;
                    }
                }
                if (state == Call.State.Connected) {
                    if (call.getDir() == Call.Dir.Incoming && core.isNativeRingingEnabled()) {
                        Log.i("[Core Manager] Stop incoming call ringing");
                        CoreManager.this.mAudioHelper.stopRinging();
                        return;
                    } else {
                        Log.i("[Core Manager] Stop incoming call ringing audio focus");
                        CoreManager.this.mAudioHelper.releaseRingingAudioFocus();
                        return;
                    }
                }
                if (state == Call.State.OutgoingInit && core.getCallsNb() == 1) {
                    Log.i("[Core Manager] Outgoing call in progress, no other call, acquire ringing audio focus for ringback");
                    CoreManager.this.mAudioHelper.requestRingingAudioFocus();
                } else if (state == Call.State.StreamsRunning) {
                    Log.i("[Core Manager] Call active, ensure audio focus granted");
                    CoreManager.this.mAudioHelper.requestCallAudioFocus(false);
                } else if (state == Call.State.Resuming) {
                    Log.i("[Core Manager] Call resuming, ensure audio focus granted");
                    CoreManager.this.mAudioHelper.requestCallAudioFocus(false);
                }
            }
        };
        this.mListener = coreListenerStub;
        this.mCore.addListener(coreListenerStub);
        Log.i("[Core Manager] Started");
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("push_notification_storage", 0);
        String string = sharedPreferences.getString("call-id", "");
        String string2 = sharedPreferences.getString("payload", "");
        if (string.isEmpty()) {
            return;
        }
        Log.i("[Core Manager] Push notification information retrieved from storage, Call-ID is [" + string + "]");
        processPushNotification(string, string2, true);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("call-id", "");
        editorEdit.putString("payload", "");
        editorEdit.apply();
        Log.i("[Core Manager] Push information cleared from storage");
    }

    public void stop() {
        Log.i("[Core Manager] Stopping");
        stopCore(this.mCore.getNativePointer());
    }

    public void onLinphoneCoreStop() {
        Log.i("[Core Manager] Core stopped");
        if (isServiceRunning()) {
            Log.i("[Core Manager] Stopping service ", this.mServiceClass.getName());
            this.mContext.stopService(new Intent().setClass(this.mContext, this.mServiceClass));
        }
        this.mCore.removeListener(this.mListener);
        stopAutoIterate();
        stopTimerToResetAutoIterateSchedule();
        this.mCore = null;
    }

    public void startAutoIterate() {
        Core core = this.mCore;
        if (core != null && core.isAutoIterateEnabled()) {
            if (this.mTimer != null) {
                Log.w("[Core Manager] core.iterate() scheduling is already active");
            } else if (this.mCore.isInBackground()) {
                Log.i("[Core Manager] Start core.iterate() scheduling with background timer");
                startAutoIterate(this.mCore.getAutoIterateBackgroundSchedule());
            } else {
                Log.i("[Core Manager] Start core.iterate() scheduling with foreground timer");
                startAutoIterate(this.mCore.getAutoIterateForegroundSchedule());
            }
        }
    }

    private void stopTimerToResetAutoIterateSchedule() {
        Timer timer = this.mForcedIterateTimer;
        if (timer != null) {
            timer.cancel();
            this.mForcedIterateTimer.purge();
            this.mForcedIterateTimer = null;
        }
    }

    private void createTimerToResetAutoIterateSchedule() {
        stopTimerToResetAutoIterateSchedule();
        TimerTask timerTask = new TimerTask() { // from class: org.linphone.core.tools.service.CoreManager.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidDispatcher.dispatchOnUIThread(new Runnable() { // from class: org.linphone.core.tools.service.CoreManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Log.i("[Core Manager] Resetting core.iterate() schedule depending on background/foreground state");
                        CoreManager.this.stopAutoIterate();
                        CoreManager.this.startAutoIterate();
                    }
                });
            }
        };
        Timer timer = new Timer("Linphone core.iterate() reset scheduler");
        this.mForcedIterateTimer = timer;
        timer.schedule(timerTask, 20000L);
        Log.i("[Core Manager] Iterate scheduler will be reset in 20 seconds");
    }

    private void startAutoIterate(int i) {
        if (this.mTimer != null && i == this.mIterateSchedule) {
            Log.i("[Core Manager] core.iterate() is already scheduled every " + i + " ms");
            return;
        }
        stopAutoIterate();
        this.mIterateSchedule = i;
        this.mIterateRunnable = new Runnable() { // from class: org.linphone.core.tools.service.CoreManager.4
            @Override // java.lang.Runnable
            public void run() {
                Core core = CoreManager.this.mCore;
                if (core != null) {
                    core.iterate();
                }
            }
        };
        TimerTask timerTask = new TimerTask() { // from class: org.linphone.core.tools.service.CoreManager.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidDispatcher.dispatchOnUIThread(CoreManager.this.mIterateRunnable);
            }
        };
        Timer timer = new Timer("Linphone core.iterate() scheduler");
        this.mTimer = timer;
        timer.schedule(timerTask, 0L, this.mIterateSchedule);
        Log.i("[Core Manager] Call to core.iterate() scheduled every " + this.mIterateSchedule + " ms");
    }

    public void stopAutoIterate() {
        if (this.mTimer != null) {
            Log.i("[Core Manager] Stopping scheduling of core.iterate() every " + this.mIterateSchedule + " ms");
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
            Log.i("[Core Manager] core.iterate() scheduler stopped");
            return;
        }
        Log.w("[Core Manager] core.iterate() scheduling wasn't started or already stopped");
    }

    public void startAudioForEchoTestOrCalibration() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper == null) {
            return;
        }
        audioHelper.startAudioForEchoTestOrCalibration();
    }

    public void stopAudioForEchoTestOrCalibration() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper == null) {
            return;
        }
        audioHelper.stopAudioForEchoTestOrCalibration();
    }

    public void routeAudioToSpeaker() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper == null) {
            return;
        }
        audioHelper.routeAudioToSpeaker();
    }

    public void restorePreviousAudioRoute() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper == null) {
            return;
        }
        audioHelper.restorePreviousAudioRoute();
    }

    public void onAudioFocusLost() {
        Core core = this.mCore;
        if (core != null) {
            if (core.getConfig().getBool(MediaStreamTrack.AUDIO_TRACK_KIND, "android_pause_calls_when_audio_focus_lost", true)) {
                if (this.mCore.isInConference()) {
                    Log.i("[Core Manager] App has lost audio focus, leaving conference");
                    leaveConference(this.mCore.getNativePointer());
                } else {
                    Log.i("[Core Manager] App has lost audio focus, pausing all calls");
                    pauseAllCalls(this.mCore.getNativePointer());
                }
                this.mAudioHelper.releaseCallAudioFocus();
                return;
            }
            Log.w("[Core Manager] Audio focus lost but keeping calls running");
        }
    }

    public void onBluetoothAdapterTurnedOn() {
        if (DeviceUtils.isBluetoothConnectPermissionGranted(this.mContext)) {
            onBluetoothHeadsetStateChanged();
        } else {
            Log.w("[Core Manager] Bluetooth Connect permission isn't granted, waiting longer before reloading sound devices to increase chances to get bluetooth device");
            onBluetoothHeadsetStateChanged(5000);
        }
    }

    public void onBluetoothHeadsetStateChanged() {
        onBluetoothHeadsetStateChanged(500);
    }

    private void onBluetoothHeadsetStateChanged(int i) {
        GlobalState globalState = this.mCore.getGlobalState();
        if (globalState != GlobalState.On && globalState != GlobalState.Ready) {
            Log.w("[Core Manager] Bluetooth headset state changed but current global state is ", globalState.name(), ", skipping...");
            return;
        }
        Log.i("[Core Manager] Bluetooth headset state changed, waiting for " + i + " ms before reloading sound devices");
        this.mHandler.postDelayed(new Runnable() { // from class: org.linphone.core.tools.service.CoreManager.6
            @Override // java.lang.Runnable
            public void run() {
                Log.i("[Core Manager] Reloading sound devices");
                CoreManager coreManager = CoreManager.this;
                Core core = coreManager.mCore;
                if (core != null) {
                    coreManager.reloadSoundDevices(core.getNativePointer());
                }
            }
        }, (long) i);
    }

    public void onHeadsetStateChanged() {
        GlobalState globalState = this.mCore.getGlobalState();
        if (globalState != GlobalState.On && globalState != GlobalState.Ready) {
            Log.w("[Core Manager] Headset state changed but current global state is ", globalState.name(), ", skipping...");
        } else {
            Log.i("[Core Manager] Headset state changed, waiting for 500ms before reloading sound devices");
            this.mHandler.postDelayed(new Runnable() { // from class: org.linphone.core.tools.service.CoreManager.7
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Core Manager] Reloading sound devices");
                    CoreManager coreManager = CoreManager.this;
                    Core core = coreManager.mCore;
                    if (core != null) {
                        coreManager.reloadSoundDevices(core.getNativePointer());
                    }
                }
            }, 500L);
        }
    }

    public void onBackgroundMode() {
        Log.i("[Core Manager] App has entered background mode");
        Core core = this.mCore;
        if (core != null) {
            enterBackground(core.getNativePointer());
            if (this.mCore.isAutoIterateEnabled()) {
                stopTimerToResetAutoIterateSchedule();
                Log.i("[Core Manager] Restarting core.iterate() schedule with background timer");
                startAutoIterate(this.mCore.getAutoIterateBackgroundSchedule());
            }
        }
    }

    public void onForegroundMode() {
        Log.i("[Core Manager] App has left background mode");
        Core core = this.mCore;
        if (core != null) {
            enterForeground(core.getNativePointer());
            if (this.mCore.isAutoIterateEnabled()) {
                stopTimerToResetAutoIterateSchedule();
                Log.i("[Core Manager] Restarting core.iterate() schedule with foreground timer");
                startAutoIterate(this.mCore.getAutoIterateForegroundSchedule());
            }
        }
    }

    public void setPushToken(String str) {
        String string = this.mContext.getString(this.mContext.getResources().getIdentifier("gcm_defaultSenderId", "string", this.mContext.getPackageName()));
        Log.i("[Core Manager] Push notification app id is [", string, "] and token is [", str, "]");
        Core core = this.mCore;
        if (core != null) {
            updatePushNotificationInformation(core.getNativePointer(), string, str);
        }
    }

    public void setAudioManagerInCommunicationMode() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper != null) {
            audioHelper.setAudioManagerInCommunicationMode();
        }
    }

    public void setAudioManagerInNormalMode() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper != null) {
            audioHelper.setAudioManagerInNormalMode();
        }
    }

    public void stopRinging() {
        AudioHelper audioHelper = this.mAudioHelper;
        if (audioHelper != null) {
            audioHelper.stopRinging();
        }
    }

    private Class getServiceClass() throws ClassNotFoundException {
        Class<?> cls;
        try {
            for (ServiceInfo serviceInfo : this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 4).services) {
                String str = serviceInfo.name;
                try {
                    cls = Class.forName(str);
                } catch (Error e) {
                    Log.e("[Core Manager] Error trying to get Class from name [", str, "]: ", e);
                } catch (Exception e2) {
                    Log.e("[Core Manager] Exception trying to get Class from name [", str, "]: ", e2);
                }
                if (CoreService.class.isAssignableFrom(cls)) {
                    Log.i("[Core Manager] Found a service that herits from org.linphone.core.tools.service.CoreService: ", str);
                    return cls;
                }
                continue;
            }
            Log.w("[Core Manager] Failed to find a valid Service, continuing without it...");
            return null;
        } catch (Exception e3) {
            Log.e("[Core Manager] Exception thrown while trying to find available Services: ", e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startService() {
        Log.i("[Core Manager] Starting service ", this.mServiceClass.getName());
        this.mContext.startService(new Intent().setClass(this.mContext, this.mServiceClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isServiceRunning() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningServices(ConnectionsManager.DEFAULT_DATACENTER_ID).iterator();
        while (it.hasNext()) {
            if (this.mServiceClass.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void setServiceRunningAsForeground(boolean z) {
        this.mServiceRunningInForeground = z;
        if (z) {
            Log.i("[Core Manager] CoreService is now running in foreground");
        } else {
            Log.i("[Core Manager] CoreService is no longer running in foreground");
        }
    }

    public boolean isServiceRunningAsForeground() {
        return this.mServiceRunningInForeground;
    }

    private boolean isAndroidXMediaAvailable() throws ClassNotFoundException {
        try {
            Class.forName("androidx.media.AudioAttributesCompat");
            Class.forName("androidx.media.AudioFocusRequestCompat");
            Class.forName("androidx.media.AudioManagerCompat");
            return true;
        } catch (ClassNotFoundException e) {
            Log.w("[Core Manager] Couldn't find class: ", e);
            return false;
        } catch (Exception e2) {
            Log.w("[Core Manager] Exception: " + e2);
            return false;
        }
    }

    private void dumpDeviceInformation() {
        Log.i("==== Phone information dump ====");
        Log.i("DEVICE=" + Build.DEVICE);
        Log.i("MODEL=" + Build.MODEL);
        Log.i("MANUFACTURER=" + Build.MANUFACTURER);
        Log.i("ANDROID SDK=" + Build.VERSION.SDK_INT);
        Log.i("PERFORMANCE CLASS=" + DeviceUtils.getPerformanceClass());
        StringBuilder sb = new StringBuilder();
        sb.append("ABIs=");
        Iterator<String> it = Version.getCpuAbis().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        Log.i(sb.substring(0, sb.length() - 2));
        Log.i("=========================================");
    }

    private void dumpLinphoneInformation() {
        Log.i("==== Linphone SDK information dump ====");
        Log.i("VERSION=", this.mContext.getString(R$string.linphone_sdk_version));
        Log.i("BRANCH=", this.mContext.getString(R$string.linphone_sdk_branch));
        StringBuilder sb = new StringBuilder();
        sb.append("PLUGINS=");
        for (String str : BuildConfig.PLUGINS_ARRAY) {
            sb.append(str);
            sb.append(", ");
        }
        Log.i(sb.substring(0, sb.length() - 2));
        Log.i("PACKAGE=", BuildConfig.LIBRARY_PACKAGE_NAME);
        Log.i("BUILD TYPE=", "release");
        Log.i("=========================================");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOrientation(int i) {
        if (this.mCore == null) {
            Log.e("[Core Manager] Core is null, don't notify device rotation");
            return;
        }
        Display display = this.mDisplayManager.getDisplay(i);
        if (display == null) {
            Log.e("[Core Manager] Failed to get display from id: ", Integer.valueOf(i));
            return;
        }
        int rotation = display.getRotation();
        int i2 = 270;
        if (rotation == 0) {
            i2 = 0;
        } else if (rotation != 1) {
            if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 90;
            }
        }
        Log.i("[Core Manager] Device orientation is ", Integer.valueOf(i2), " (raw value is ", Integer.valueOf(rotation), ")");
        this.mCore.setDeviceRotation((360 - i2) % 360);
    }
}
