package org.linphone.core.tools.audio;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import ir.eitaa.messenger.voip.VoIPService;
import java.io.FileInputStream;
import java.io.IOException;
import org.linphone.core.Address;
import org.linphone.core.AudioDevice;
import org.linphone.core.Core;
import org.linphone.core.tools.Log;
import org.linphone.core.tools.compatibility.DeviceUtils;
import org.linphone.core.tools.receiver.HeadsetReceiver;
import org.linphone.core.tools.service.CoreManager;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class AudioHelper implements AudioManager.OnAudioFocusChangeListener {
    private AudioManager mAudioManager;
    private MediaPlayer mPlayer;
    private AudioDevice mPreviousDefaultOutputAudioDevice;
    private Ringtone mRingtone;
    private int mVolumeBeforeEchoTest;
    private AudioFocusRequestCompat mRingingRequest = null;
    private AudioFocusRequestCompat mCallRequest = null;
    private HeadsetReceiver mHeadsetReceiver = new HeadsetReceiver();

    public AudioHelper(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        context.registerReceiver(this.mHeadsetReceiver, new IntentFilter(VoIPService.ACTION_HEADSET_PLUG));
        Log.i("[Audio Helper] Helper created");
    }

    public void destroy(Context context) {
        Log.i("[Audio Helper] Destroying");
        HeadsetReceiver headsetReceiver = this.mHeadsetReceiver;
        if (headsetReceiver != null) {
            context.unregisterReceiver(headsetReceiver);
            this.mHeadsetReceiver = null;
        }
        stopRinging();
        releaseRingingAudioFocus();
        releaseCallAudioFocus();
        Log.i("[Audio Helper] Destroyed");
    }

    public void startAudioForEchoTestOrCalibration() {
        requestCallAudioFocus(true);
        this.mVolumeBeforeEchoTest = this.mAudioManager.getStreamVolume(0);
        try {
            this.mAudioManager.setStreamVolume(0, this.mAudioManager.getStreamMaxVolume(0), 0);
        } catch (SecurityException e) {
            Log.e("[Audio Helper] Couldn't increase volume: ", e);
        }
    }

    public void stopAudioForEchoTestOrCalibration() {
        try {
            this.mAudioManager.setStreamVolume(0, this.mVolumeBeforeEchoTest, 0);
        } catch (SecurityException e) {
            Log.e("[Audio Helper] Couldn't restore volume: ", e);
        }
        releaseCallAudioFocus();
    }

    public void startRinging(Context context, String str, Address address) {
        if (this.mPlayer != null || this.mRingtone != null) {
            Log.w("[Audio Helper] Already ringing, skipping...");
            return;
        }
        int ringerMode = this.mAudioManager.getRingerMode();
        if (ringerMode == 0 || ringerMode == 1) {
            if (!DeviceUtils.checkIfDoNotDisturbAllowsExceptionForFavoriteContacts(context)) {
                Log.w("[Audio Helper] Do not play ringtone as ringer mode is set to silent or vibrate (", Integer.valueOf(ringerMode), ")");
                return;
            } else {
                if (!DeviceUtils.checkIfIsFavoriteContact(context, address)) {
                    Log.w("[Audio Helper] Do not play ringtone as ringer mode is set to silent or vibrate (", Integer.valueOf(ringerMode), ") and calling username / SIP address isn't part of a favorite contact");
                    return;
                }
                Log.w("[Audio Helper] Ringer mode is set to silent or vibrate (", Integer.valueOf(ringerMode), ") unless for favorite contact, which seems to be the case here, so ringing");
            }
        }
        requestRingingAudioFocus();
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(6).setContentType(2).build();
        if (str == null || str.isEmpty()) {
            Log.i("[Audio Helper] Core ringtone path is null, using device ringtone if possible");
            Uri defaultRingtoneUri = getDefaultRingtoneUri(context);
            if (defaultRingtoneUri == null) {
                Log.w("[Audio Helper] Couldn't get ringtone URI through RingtoneManager, trying with Settings.System.DEFAULT_RINGTONE_URI");
                playSoundUsingMediaPlayer(context, audioAttributesBuild, Settings.System.DEFAULT_RINGTONE_URI.toString());
                return;
            }
            try {
                Ringtone ringtone = RingtoneManager.getRingtone(context, defaultRingtoneUri);
                this.mRingtone = ringtone;
                if (ringtone != null) {
                    DeviceUtils.playRingtone(ringtone, audioAttributesBuild);
                } else {
                    Log.e("[Audio Helper] Couldn't retrieve Ringtone object from manager!");
                }
                return;
            } catch (Exception e) {
                Log.e("[Audio Helper] Failed to play ringtone [", defaultRingtoneUri, "] : ", e);
                return;
            }
        }
        playSoundUsingMediaPlayer(context, audioAttributesBuild, str);
    }

    public void stopRinging() {
        if (this.mRingtone != null) {
            releaseRingingAudioFocus();
            this.mRingtone.stop();
            this.mRingtone = null;
            Log.i("[Audio Helper] Ringtone ringing stopped");
        }
        if (this.mPlayer != null) {
            releaseRingingAudioFocus();
            this.mPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
            Log.i("[Audio Helper] Media player ringing stopped");
        }
    }

    public void requestRingingAudioFocus() {
        if (isAudioFocusDisabled()) {
            Log.i("[Audio Helper] We were asked not to require audio focus, skipping");
            return;
        }
        if (this.mRingingRequest != null) {
            Log.w("[Audio Helper] Ringing audio focus request still active, skipping");
            return;
        }
        AudioFocusRequestCompat audioFocusRequestCompatBuild = new AudioFocusRequestCompat.Builder(4).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(6).setContentType(2).build()).setOnAudioFocusChangeListener(this).build();
        this.mRingingRequest = audioFocusRequestCompatBuild;
        int iRequestAudioFocus = AudioManagerCompat.requestAudioFocus(this.mAudioManager, audioFocusRequestCompatBuild);
        if (iRequestAudioFocus == 1) {
            Log.i("[Audio Helper] Ringing audio focus request granted");
        } else if (iRequestAudioFocus == 0) {
            Log.w("[Audio Helper] Ringing audio focus request failed");
        } else if (iRequestAudioFocus == 2) {
            Log.w("[Audio Helper] Ringing audio focus request delayed");
        }
    }

    public void releaseRingingAudioFocus() {
        AudioFocusRequestCompat audioFocusRequestCompat = this.mRingingRequest;
        if (audioFocusRequestCompat != null) {
            if (AudioManagerCompat.abandonAudioFocusRequest(this.mAudioManager, audioFocusRequestCompat) == 1) {
                Log.i("[Audio Helper] Ringing audio focus request abandonned");
                this.mRingingRequest = null;
            } else {
                if (isAudioFocusDisabled()) {
                    return;
                }
                Log.e("[Audio Helper] Ringing audio focus abandon request failed");
            }
        }
    }

    public void requestCallAudioFocus(boolean z) {
        if (isAudioFocusDisabled() && !z) {
            Log.i("[Audio Helper] We were asked not to require audio focus, skipping");
            return;
        }
        if (this.mRingingRequest != null) {
            Log.w("[Audio Helper] Ringing audio focus request not abandonned, let's do it");
            releaseRingingAudioFocus();
        }
        if (this.mCallRequest != null) {
            Log.w("[Audio Helper] Call audio focus request still active, skipping");
            return;
        }
        AudioFocusRequestCompat audioFocusRequestCompatBuild = new AudioFocusRequestCompat.Builder(2).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(2).setContentType(1).build()).setOnAudioFocusChangeListener(this).build();
        this.mCallRequest = audioFocusRequestCompatBuild;
        int iRequestAudioFocus = AudioManagerCompat.requestAudioFocus(this.mAudioManager, audioFocusRequestCompatBuild);
        if (iRequestAudioFocus == 1) {
            Log.i("[Audio Helper] Call audio focus request granted");
            setAudioManagerInCommunicationMode();
            return;
        }
        if (iRequestAudioFocus == 0) {
            Log.w("[Audio Helper] Call audio focus request failed");
        } else if (iRequestAudioFocus == 2) {
            Log.w("[Audio Helper] Call audio focus request delayed");
        }
        releaseCallAudioFocus();
    }

    public void releaseCallAudioFocus() {
        AudioFocusRequestCompat audioFocusRequestCompat = this.mCallRequest;
        if (audioFocusRequestCompat != null) {
            if (AudioManagerCompat.abandonAudioFocusRequest(this.mAudioManager, audioFocusRequestCompat) == 1) {
                Log.i("[Audio Helper] Call audio focus request abandonned");
                this.mCallRequest = null;
            } else {
                Log.e("[Audio Helper] Call audio focus abandon request failed");
            }
            setAudioManagerInNormalMode();
            return;
        }
        if (isAudioFocusDisabled()) {
            return;
        }
        Log.i("[Audio Helper] Call audio focus request was already abandonned");
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i == -3) {
            Log.w("[Audio Helper] Focus lost (transient, can duck)");
            return;
        }
        if (i == -2) {
            Log.w("[Audio Helper] Focus lost (transient)");
            if (CoreManager.isReady()) {
                CoreManager.instance().onAudioFocusLost();
                return;
            }
            return;
        }
        if (i != -1) {
            if (i != 1) {
                return;
            }
            Log.i("[Audio Helper] Focus gained");
        } else {
            Log.w("[Audio Helper] Focus lost");
            if (CoreManager.isReady()) {
                CoreManager.instance().onAudioFocusLost();
            }
        }
    }

    public void setAudioManagerInCommunicationMode() {
        Log.i("[Audio Helper] Setting audio manager in communication mode");
        this.mAudioManager.setMode(3);
    }

    public void setAudioManagerInNormalMode() {
        Log.i("[Audio Helper] Setting audio manager in normal mode");
        this.mAudioManager.setMode(0);
    }

    public void restorePreviousAudioRoute() {
        if (!CoreManager.isReady()) {
            Log.e("[Audio Helper] CoreManager has been destroyed already!");
            return;
        }
        Core core = CoreManager.instance().getCore();
        if (core != null) {
            core.setDefaultOutputAudioDevice(this.mPreviousDefaultOutputAudioDevice);
            Log.i("[Audio Helper] Restored previous default output audio device: " + this.mPreviousDefaultOutputAudioDevice);
            this.mPreviousDefaultOutputAudioDevice = null;
            return;
        }
        Log.e("[Audio Helper] CoreManager instance found but Core is null!");
    }

    public void routeAudioToSpeaker() {
        if (!CoreManager.isReady()) {
            Log.e("[Audio Helper] CoreManager has been destroyed already!");
            return;
        }
        Core core = CoreManager.instance().getCore();
        if (core != null) {
            AudioDevice defaultOutputAudioDevice = core.getDefaultOutputAudioDevice();
            this.mPreviousDefaultOutputAudioDevice = defaultOutputAudioDevice;
            if (defaultOutputAudioDevice.getType() == AudioDevice.Type.Speaker) {
                Log.i("[Audio Helper] Current default output audio device is already the speaker: " + this.mPreviousDefaultOutputAudioDevice);
                return;
            }
            Log.i("[Audio Helper] Saved current default output audio device: " + this.mPreviousDefaultOutputAudioDevice);
            for (AudioDevice audioDevice : core.getAudioDevices()) {
                if (audioDevice.getType() == AudioDevice.Type.Speaker) {
                    Log.i("[Audio Helper] Found speaker device, replacing default output audio device with: " + audioDevice);
                    core.setDefaultOutputAudioDevice(audioDevice);
                    return;
                }
            }
            Log.e("[Audio Helper] Couldn't find speaker audio device");
            return;
        }
        Log.e("[Audio Helper] CoreManager instance found but Core is null!");
    }

    private void playSoundUsingMediaPlayer(Context context, AudioAttributes audioAttributes, String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Log.i("[Audio Helper] Trying to play ringtone [", str, "]");
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mPlayer = mediaPlayer;
        mediaPlayer.setAudioAttributes(audioAttributes);
        try {
            if (str.startsWith("content://")) {
                this.mPlayer.setDataSource(context, Uri.parse(str));
            } else {
                FileInputStream fileInputStream = new FileInputStream(str);
                this.mPlayer.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
            }
            this.mPlayer.prepare();
            this.mPlayer.setLooping(true);
            this.mPlayer.start();
            Log.i("[Audio Helper] Media player ringing started");
        } catch (IOException e) {
            Log.e("[Audio Helper] Cannot play ringtone [", str, "]: ", e);
        } catch (SecurityException e2) {
            Log.e("[Audio Helper] Cannot play ringtone [", str, "]: ", e2);
        }
    }

    private boolean isAudioFocusDisabled() {
        if (!CoreManager.isReady()) {
            Log.e("[Audio Helper] CoreManager has been destroyed already!");
            return false;
        }
        Core core = CoreManager.instance().getCore();
        if (core != null) {
            return core.getConfig().getBool(MediaStreamTrack.AUDIO_TRACK_KIND, "android_disable_audio_focus_requests", false);
        }
        Log.w("[Audio Helper] Core has been destroyed already");
        return false;
    }

    private Uri getDefaultRingtoneUri(Context context) {
        Uri validRingtoneUri;
        try {
            validRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(context, 1);
        } catch (SecurityException unused) {
            validRingtoneUri = null;
        }
        if (validRingtoneUri == null) {
            Log.w("[Audio Helper] Failed to get actual default ringtone URI, trying to get a valid one");
            validRingtoneUri = RingtoneManager.getValidRingtoneUri(context);
        }
        if (validRingtoneUri == null) {
            Log.w("[Audio Helper] Failed to get a valid ringtone URI, trying the first one avalaible");
            RingtoneManager ringtoneManager = new RingtoneManager(context);
            ringtoneManager.setType(1);
            Cursor cursor = ringtoneManager.getCursor();
            if (cursor.moveToFirst()) {
                String string = cursor.getString(0);
                validRingtoneUri = Uri.parse(cursor.getString(2) + '/' + string);
            }
            cursor.close();
        }
        return validRingtoneUri;
    }
}
