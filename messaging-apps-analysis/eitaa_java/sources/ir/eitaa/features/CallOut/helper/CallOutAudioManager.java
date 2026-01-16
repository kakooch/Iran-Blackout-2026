package ir.eitaa.features.CallOut.helper;

import android.util.Log;
import ir.eitaa.features.CallOut.CallOutSingleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.linphone.core.AudioDevice;
import org.linphone.core.Core;

/* loaded from: classes.dex */
public class CallOutAudioManager {
    static String TAG = "CallOut";

    public static void routeAudioToHeadset() {
        routeAudioTo(Arrays.asList(AudioDevice.Type.Headphones, AudioDevice.Type.Headset));
    }

    public static void routeAudioToBluetooth() {
        routeAudioTo(Collections.singletonList(AudioDevice.Type.Bluetooth));
    }

    private static void routeAudioTo(List<AudioDevice.Type> types) {
        if (CallOutManager.getCall() != null) {
            applyAudioRouteChange(types, true);
            changeCaptureDeviceToMatchAudioRoute(types);
        }
    }

    private static void applyAudioRouteChange(List<AudioDevice.Type> types, boolean output) {
        AudioDevice defaultInputAudioDevice;
        String driverName;
        if (CallOutSingleton.getInstance().core == null) {
            return;
        }
        AudioDevice.Capabilities capabilities = output ? AudioDevice.Capabilities.CapabilityPlay : AudioDevice.Capabilities.CapabilityRecord;
        AudioDevice audioDevice = null;
        Core core = CallOutSingleton.getInstance().core;
        if (output) {
            if (core.getDefaultOutputAudioDevice() != null) {
                defaultInputAudioDevice = CallOutSingleton.getInstance().core.getDefaultOutputAudioDevice();
                driverName = defaultInputAudioDevice.getDriverName();
            }
            driverName = null;
        } else {
            if (core.getDefaultInputAudioDevice() != null) {
                defaultInputAudioDevice = CallOutSingleton.getInstance().core.getDefaultInputAudioDevice();
                driverName = defaultInputAudioDevice.getDriverName();
            }
            driverName = null;
        }
        AudioDevice[] extendedAudioDevices = CallOutSingleton.getInstance().core.getExtendedAudioDevices();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Looking for an ");
        sb.append(output ? "output" : "input");
        sb.append(" audio device with capability [");
        sb.append(capabilities);
        sb.append("], driver name [");
        sb.append(driverName);
        sb.append("] and type [");
        sb.append(types);
        sb.append("] in extended audio devices list (size ");
        sb.append(extendedAudioDevices.length);
        sb.append(")");
        Log.i(str, sb.toString());
        int length = extendedAudioDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            AudioDevice audioDevice2 = extendedAudioDevices[i];
            if (audioDevice2.getDriverName().equals(driverName) && types.contains(audioDevice2.getType()) && audioDevice2.hasCapability(capabilities)) {
                audioDevice = audioDevice2;
                break;
            }
            i++;
        }
        if (audioDevice == null) {
            int length2 = extendedAudioDevices.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                AudioDevice audioDevice3 = extendedAudioDevices[i2];
                if (types.contains(audioDevice3.getType()) && audioDevice3.hasCapability(capabilities)) {
                    audioDevice = audioDevice3;
                    break;
                }
                i2++;
            }
        }
        if (audioDevice == null) {
            Log.e(TAG, "Couldn't find audio device with capability [" + capabilities + "] and type [" + types + "]");
            for (AudioDevice audioDevice4 : extendedAudioDevices) {
                Log.i("[Audio Route Helper]", "Extended audio device: [" + audioDevice4.getDeviceName() + " (" + audioDevice4.getDriverName() + ") " + audioDevice4.getType() + " / " + audioDevice4.getCapabilities() + "]");
            }
            return;
        }
        if (CallOutManager.getCall() != null) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found [");
            sb2.append(audioDevice.getType());
            sb2.append("] ");
            sb2.append(output ? "playback" : "recorder");
            sb2.append(" audio device [");
            sb2.append(audioDevice.getDeviceName());
            sb2.append(" (");
            sb2.append(audioDevice.getDriverName());
            sb2.append(")], routing call audio to it");
            Log.i(str2, sb2.toString());
            if (output) {
                CallOutManager.getCall().setOutputAudioDevice(audioDevice);
                return;
            } else {
                CallOutManager.getCall().setInputAudioDevice(audioDevice);
                return;
            }
        }
        String str3 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Found [");
        sb3.append(audioDevice.getType());
        sb3.append("] ");
        sb3.append(output ? "playback" : "recorder");
        sb3.append(" audio device [");
        sb3.append(audioDevice.getDeviceName());
        sb3.append(" (");
        sb3.append(audioDevice.getDriverName());
        sb3.append(")], changing core default audio device");
        Log.i(str3, sb3.toString());
        if (output) {
            CallOutSingleton.getInstance().core.setOutputAudioDevice(audioDevice);
        } else {
            CallOutSingleton.getInstance().core.setInputAudioDevice(audioDevice);
        }
    }

    private static void changeCaptureDeviceToMatchAudioRoute(List<AudioDevice.Type> types) {
        if (types.get(0).equals(AudioDevice.Type.Speaker)) {
            applyAudioRouteChange(Collections.singletonList(AudioDevice.Type.Microphone), false);
        }
    }

    public static boolean isHeadsetAudioRouteAvailable() {
        if (CallOutSingleton.getInstance().core == null) {
            return false;
        }
        for (AudioDevice audioDevice : CallOutSingleton.getInstance().core.getAudioDevices()) {
            if ((audioDevice.getType() == AudioDevice.Type.Headset || audioDevice.getType() == AudioDevice.Type.Headphones) && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityPlay)) {
                Log.i("Audio Route Helper", "Found headset/headphones audio device [" + audioDevice.getDeviceName() + " (" + audioDevice.getDriverName() + ")]");
                return true;
            }
        }
        return false;
    }

    public static boolean isBluetoothAudioRouteAvailable() {
        if (CallOutSingleton.getInstance().core == null) {
            return false;
        }
        for (AudioDevice audioDevice : CallOutSingleton.getInstance().core.getAudioDevices()) {
            if (audioDevice.getType() == AudioDevice.Type.Bluetooth && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityPlay)) {
                Log.i("[Audio Route Helper]", "Found bluetooth audio device [" + audioDevice.getDeviceName() + " (" + audioDevice.getDriverName() + ")]");
                return true;
            }
        }
        return false;
    }

    public static boolean isSpeakerActive() {
        AudioDevice outputAudioDevice;
        return (CallOutManager.getCall() == null || (outputAudioDevice = CallOutManager.getCall().getOutputAudioDevice()) == null || outputAudioDevice.getType() != AudioDevice.Type.Speaker) ? false : true;
    }

    public static void toggleMic(Boolean status) {
        if (CallOutManager.getCall() != null) {
            CallOutSingleton.getInstance().core.setMicEnabled(status.booleanValue());
        }
    }

    public static void toggleSpeaker() {
        if (CallOutSingleton.getInstance().core == null || CallOutSingleton.getInstance().core.getCurrentCall() == null) {
            return;
        }
        boolean zIsSpeakerActive = isSpeakerActive();
        for (int i = 0; i < CallOutSingleton.getInstance().core.getAudioDevices().length; i++) {
            AudioDevice audioDevice = CallOutSingleton.getInstance().core.getAudioDevices()[i];
            if (isHeadsetAudioRouteAvailable()) {
                if (zIsSpeakerActive && (audioDevice.getType() == AudioDevice.Type.Headset || audioDevice.getType() == AudioDevice.Type.Headphones)) {
                    CallOutSingleton.getInstance().core.getCurrentCall().setOutputAudioDevice(audioDevice);
                } else if (!zIsSpeakerActive && audioDevice.getType() == AudioDevice.Type.Speaker) {
                    CallOutSingleton.getInstance().core.getCurrentCall().setOutputAudioDevice(audioDevice);
                }
            } else if (zIsSpeakerActive && audioDevice.getType() == AudioDevice.Type.Earpiece) {
                CallOutSingleton.getInstance().core.getCurrentCall().setOutputAudioDevice(audioDevice);
            } else if (!zIsSpeakerActive && audioDevice.getType() == AudioDevice.Type.Speaker) {
                CallOutSingleton.getInstance().core.getCurrentCall().setOutputAudioDevice(audioDevice);
            }
        }
    }
}
