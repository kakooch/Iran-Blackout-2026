package org.linphone.mediastream;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import java.io.File;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class MediastreamerAndroidContext {
    private static final int DEVICE_CHOICE = 0;
    private static MediastreamerAndroidContext instance = null;
    private static Context mContext = null;
    private static int mDeviceFavoriteBufferSize = 256;
    private static int mDeviceFavoriteSampleRate = 44100;
    private static boolean mDisableAudioRouteChanges = false;

    private native int enableFilterFromNameImpl(String str, boolean z);

    private native boolean filterFromNameEnabledImpl(String str);

    private static String getHumanReadableAudioDeviceType(int i) {
        return i == 19 ? "Auxiliary line" : i == 8 ? "Bluetooth A2DP" : i == 7 ? "Bluetooth SCO" : i == 1 ? "Built-in earpiece" : i == 15 ? "Built-in microphone" : i == 2 ? "Built-in speaker" : i == 24 ? "Built-in speaker (safe)" : i == 21 ? "Type agnostic bus" : i == 13 ? "Dock" : i == 14 ? "FM" : i == 16 ? "FM tuner" : i == 9 ? "HDMI" : i == 10 ? "HDMI Audio Return Channel" : i == 23 ? "Hearing aid" : i == 20 ? "IP" : i == 5 ? "Analog" : i == 6 ? "Digital" : i == 18 ? "Telephony" : i == 17 ? "TV tuner" : i == 0 ? "Unknown" : i == 12 ? "USB accessory" : i == 11 ? "USB" : i == 22 ? "USB headset" : i == 4 ? "Headphones" : i == 3 ? "Headset" : i == 25 ? "Remote Submix" : i == 26 ? "BLE Headset" : i == 27 ? "BLE Speaker" : i == 29 ? "HDMI Enhanced Audio Return Channel" : i == 30 ? "BLE Broadcast" : "UNEXPECTED";
    }

    private MediastreamerAndroidContext() {
    }

    private static MediastreamerAndroidContext getInstance() {
        if (instance == null) {
            instance = new MediastreamerAndroidContext();
        }
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    public static int getDeviceFavoriteSampleRate() {
        return mDeviceFavoriteSampleRate;
    }

    public static int getDeviceFavoriteBufferSize() {
        return mDeviceFavoriteBufferSize;
    }

    public static String getNativeLibrariesDirectory() {
        String str = getContext().getApplicationInfo().nativeLibraryDir;
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            return str;
        }
        Log.w("Native library directory is empty, using path to native libs for app bundle mode");
        String strSubstring = str.substring(0, str.indexOf("/lib"));
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        sb.append("/split_config.");
        String[] strArr = Build.SUPPORTED_ABIS;
        sb.append(strArr[0].replace("-", "_"));
        sb.append(".apk!/lib/");
        sb.append(strArr[0]);
        return sb.toString();
    }

    @TargetApi(19)
    public static void setContext(Object obj) {
        if (obj == null) {
            return;
        }
        Context context = (Context) obj;
        mContext = context;
        Log.i("[Device] hasLowLatencyFeature: " + context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency") + ", hasProFeature: " + mContext.getPackageManager().hasSystemFeature("android.hardware.audio.pro"));
        getInstance();
        if (Build.VERSION.SDK_INT >= 19) {
            AudioManager audioManager = (AudioManager) mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            int i = parseInt(audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"), Factory.DEVICE_HAS_CRAPPY_OPENSLES);
            int i2 = parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"), 44100);
            Log.i("[Device] Output frames per buffer: " + i + ", output sample rate: " + i2 + ".");
            mDeviceFavoriteSampleRate = i2;
            mDeviceFavoriteBufferSize = i;
            return;
        }
        Log.i("Android < 4.4 detected, android context not used.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.media.AudioDeviceInfo[] getAudioDevices(java.lang.String r10) {
        /*
            r10.hashCode()
            int r0 = r10.hashCode()
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            switch(r0) {
                case -1005512447: goto L26;
                case 96673: goto L1b;
                case 100358090: goto L10;
                default: goto Le;
            }
        Le:
            r0 = -1
            goto L30
        L10:
            java.lang.String r0 = "input"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L19
            goto Le
        L19:
            r0 = 2
            goto L30
        L1b:
            java.lang.String r0 = "all"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L24
            goto Le
        L24:
            r0 = 1
            goto L30
        L26:
            java.lang.String r0 = "output"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L2f
            goto Le
        L2f:
            r0 = 0
        L30:
            switch(r0) {
                case 0: goto L55;
                case 1: goto L54;
                case 2: goto L52;
                default: goto L33;
            }
        L33:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Unknown device direction - Provided is "
            r1.append(r5)
            r1.append(r10)
            java.lang.String r10 = " Valid values are output input all"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0[r3] = r10
            org.linphone.mediastream.Log.e(r0)
            r1 = -1
            goto L55
        L52:
            r1 = 1
            goto L55
        L54:
            r1 = 3
        L55:
            android.content.Context r10 = getContext()
            java.lang.String r0 = "audio"
            java.lang.Object r10 = r10.getSystemService(r0)
            android.media.AudioManager r10 = (android.media.AudioManager) r10
            android.media.AudioDeviceInfo[] r10 = r10.getDevices(r1)
            int r0 = r10.length
            r1 = 0
        L67:
            if (r1 >= r0) goto Lcb
            r2 = r10[r1]
            int r5 = r2.getType()
            java.lang.String r6 = getHumanReadableAudioDeviceType(r5)
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "[Audio Manager] Found device: name ["
            r8.append(r9)
            java.lang.CharSequence r9 = r2.getProductName()
            r8.append(r9)
            java.lang.String r9 = "], ID ["
            r8.append(r9)
            int r9 = r2.getId()
            r8.append(r9)
            java.lang.String r9 = "], type ["
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = " ("
            r8.append(r6)
            r8.append(r5)
            java.lang.String r5 = ")], isSource ["
            r8.append(r5)
            boolean r5 = r2.isSource()
            r8.append(r5)
            java.lang.String r5 = "], isSink ["
            r8.append(r5)
            boolean r2 = r2.isSink()
            r8.append(r2)
            java.lang.String r2 = "]"
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            r7[r3] = r2
            org.linphone.mediastream.Log.i(r7)
            int r1 = r1 + 1
            goto L67
        Lcb:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.linphone.mediastream.MediastreamerAndroidContext.getAudioDevices(java.lang.String):android.media.AudioDeviceInfo[]");
    }

    public static boolean getSpeakerphoneAlwaysOn(Factory factory) {
        return (factory.getDeviceFlags() & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0;
    }

    private static int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.e("Can't parse " + str + " to integer ; using default value " + i);
            return i;
        }
    }

    public static void enableFilterFromName(String str, boolean z) throws MediastreamException {
        if (getInstance().enableFilterFromNameImpl(str, z) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot ");
            sb.append(z ? "enable" : "disable");
            sb.append(" filter  name [");
            sb.append(str);
            sb.append("]");
            throw new MediastreamException(sb.toString());
        }
    }

    public static boolean filterFromNameEnabled(String str) {
        return getInstance().filterFromNameEnabledImpl(str);
    }

    public static synchronized boolean isAudioRouteChangesDisabled() {
        return mDisableAudioRouteChanges;
    }

    public static synchronized void disableAudioRouteChanges(boolean z) {
        if (z) {
            Log.i("[Audio Manager] Disabling audio route changes in sound cards");
        } else {
            Log.i("[Audio Manager] Enabling audio route changes in sound cards");
        }
        mDisableAudioRouteChanges = z;
    }

    public static synchronized void enableSpeaker() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager.isBluetoothScoOn()) {
            stopBluetooth();
        }
        Log.i("[Audio Manager] Turning on speakerphone");
        audioManager.setSpeakerphoneOn(true);
    }

    public static synchronized void enableEarpiece() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager.isBluetoothScoOn()) {
            stopBluetooth();
        }
        Log.i("[Audio Manager] Turning off speakerphone");
        audioManager.setSpeakerphoneOn(false);
    }

    public static synchronized void startBluetooth() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager.isBluetoothScoOn()) {
            Log.i("[Audio Manager] Bluetooth SCO is already started");
        } else {
            Log.i("[Audio Manager] Starting bluetooth SCO");
            audioManager.setBluetoothScoOn(true);
            audioManager.startBluetoothSco();
        }
    }

    public static synchronized void stopBluetooth() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (!audioManager.isBluetoothScoOn()) {
            Log.i("[Audio Manager] Bluetooth SCO is not started");
        } else {
            Log.i("[Audio Manager] Stopping bluetooth SCO");
            audioManager.stopBluetoothSco();
            audioManager.setBluetoothScoOn(false);
        }
    }

    public static synchronized void hackVolume() {
        Log.i("[Audio Manager] Lower & raise audio volume to workaround no sound issue until volume has changed...");
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager.isVolumeFixed()) {
            Log.w("[Audio Manager] Device's volume is fixed, workaround will probably fail!");
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(0);
        int streamVolume = audioManager.getStreamVolume(0);
        Log.i("[Audio Manager] Max volume for voice call stream is " + streamMaxVolume + ", current volume is " + streamVolume);
        if (streamMaxVolume == streamVolume) {
            try {
                audioManager.adjustSuggestedStreamVolume(-1, 0, 0);
                SystemClock.sleep(50);
                audioManager.adjustSuggestedStreamVolume(1, 0, 0);
            } catch (SecurityException e) {
                Log.e("[Audio Manager] Security exception during adjustSuggestedStreamVolume: ", e);
            }
            audioManager.adjustStreamVolume(0, -1, 0);
            SystemClock.sleep(50);
            audioManager.adjustStreamVolume(0, 1, 0);
        } else {
            try {
                audioManager.adjustSuggestedStreamVolume(1, 0, 0);
                SystemClock.sleep(50);
                audioManager.adjustSuggestedStreamVolume(-1, 0, 0);
            } catch (SecurityException e2) {
                Log.e("[Audio Manager] Security exception during adjustSuggestedStreamVolume: ", e2);
            }
            audioManager.adjustStreamVolume(0, 1, 0);
            SystemClock.sleep(50);
            audioManager.adjustStreamVolume(0, -1, 0);
        }
    }

    public static synchronized boolean isRecordAudioPermissionGranted() {
        boolean z;
        z = mContext.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
        if (!z) {
            Log.w("[Audio Manager] RECORD_AUDIO permission is not granted!");
        }
        return z;
    }

    @TargetApi(31)
    public static synchronized boolean setCommunicationDevice(int i) {
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        for (AudioDeviceInfo audioDeviceInfo : audioManager.getAvailableCommunicationDevices()) {
            if (audioDeviceInfo.getId() == i) {
                Log.i("[Audio Manager] Found available communication device matching ID [" + i + "]: " + audioDeviceInfo);
                return audioManager.setCommunicationDevice(audioDeviceInfo);
            }
        }
        return false;
    }

    @TargetApi(31)
    public static synchronized void clearCommunicationDevice() {
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).clearCommunicationDevice();
        Log.i("[Audio Manager] Cleared communication device");
    }
}
