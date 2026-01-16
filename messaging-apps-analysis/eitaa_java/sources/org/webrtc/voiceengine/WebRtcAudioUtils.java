package org.webrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class WebRtcAudioUtils {
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz = 16000;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
    private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    private static final String[] BLACKLISTED_NS_MODELS = new String[0];

    private static String deviceTypeToString(int type) {
        switch (type) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    static String modeToString(int mode) {
        return mode != 0 ? mode != 1 ? mode != 2 ? mode != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    private static String streamTypeToString(int stream) {
        return stream != 0 ? stream != 1 ? stream != 2 ? stream != 3 ? stream != 4 ? stream != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean enable) {
        useWebRtcBasedAcousticEchoCanceler = enable;
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean enable) {
        useWebRtcBasedNoiseSuppressor = enable;
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean enable) {
        Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        if (useWebRtcBasedAcousticEchoCanceler) {
            Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
        }
        return useWebRtcBasedAcousticEchoCanceler;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        if (useWebRtcBasedNoiseSuppressor) {
            Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
        }
        return useWebRtcBasedNoiseSuppressor;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        return true;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    public static synchronized void setDefaultSampleRateHz(int sampleRateHz) {
        isDefaultSampleRateOverridden = true;
        defaultSampleRateHz = sampleRateHz;
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        return isDefaultSampleRateOverridden;
    }

    public static synchronized int getDefaultSampleRateHz() {
        return defaultSampleRateHz;
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    static void logDeviceInfo(String tag) {
        Logging.d(tag, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
    }

    static void logAudioState(String tag) {
        logDeviceInfo(tag);
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        logAudioStateBasic(tag, audioManager);
        logAudioStateVolume(tag, audioManager);
        logAudioDeviceInfo(tag, audioManager);
    }

    private static void logAudioStateBasic(String tag, AudioManager audioManager) {
        Logging.d(tag, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return audioManager.isVolumeFixed();
    }

    private static void logAudioStateVolume(String tag, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(tag, "Audio State: ");
        boolean zIsVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(tag, "  fixed volume=" + zIsVolumeFixed);
        if (zIsVolumeFixed) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            StringBuilder sb = new StringBuilder();
            sb.append("  " + streamTypeToString(i2) + ": ");
            sb.append("volume=");
            sb.append(audioManager.getStreamVolume(i2));
            sb.append(", max=");
            sb.append(audioManager.getStreamMaxVolume(i2));
            logIsStreamMute(tag, audioManager, i2, sb);
            Logging.d(tag, sb.toString());
        }
    }

    private static void logIsStreamMute(String tag, AudioManager audioManager, int stream, StringBuilder info) {
        if (Build.VERSION.SDK_INT >= 23) {
            info.append(", muted=");
            info.append(audioManager.isStreamMute(stream));
        }
    }

    private static void logAudioDeviceInfo(String tag, AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        Logging.d(tag, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sb = new StringBuilder();
            sb.append("  ");
            sb.append(deviceTypeToString(audioDeviceInfo.getType()));
            sb.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sb.append("channels=");
                sb.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sb.append(", ");
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sb.append("encodings=");
                sb.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sb.append(", ");
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sb.append("sample rates=");
                sb.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sb.append(", ");
            }
            sb.append("id=");
            sb.append(audioDeviceInfo.getId());
            Logging.d(tag, sb.toString());
        }
    }

    private static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }
}
