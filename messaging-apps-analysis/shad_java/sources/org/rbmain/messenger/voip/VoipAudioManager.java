package org.rbmain.messenger.voip;

import android.media.AudioManager;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Utilities;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes4.dex */
public class VoipAudioManager {
    private Boolean isSpeakerphoneOn;

    private VoipAudioManager() {
    }

    private static final class InstanceHolder {
        static final VoipAudioManager instance = new VoipAudioManager();

        private InstanceHolder() {
        }
    }

    public static VoipAudioManager get() {
        return InstanceHolder.instance;
    }

    public void setSpeakerphoneOn(final boolean z) {
        this.isSpeakerphoneOn = Boolean.valueOf(z);
        final AudioManager audioManager = getAudioManager();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.voip.VoipAudioManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                audioManager.setSpeakerphoneOn(z);
            }
        });
    }

    public boolean isSpeakerphoneOn() {
        Boolean bool = this.isSpeakerphoneOn;
        if (bool == null) {
            return getAudioManager().isSpeakerphoneOn();
        }
        return bool.booleanValue();
    }

    private AudioManager getAudioManager() {
        return (AudioManager) ApplicationLoader.applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }
}
