package androidx.media;

import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static int requestAudioFocus(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (audioFocusRequestCompat == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.requestAudioFocus(audioFocusRequestCompat.getAudioFocusRequest());
        }
        return audioManager.requestAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener(), audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), audioFocusRequestCompat.getFocusGain());
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        }
        if (audioFocusRequestCompat == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.abandonAudioFocusRequest(audioFocusRequestCompat.getAudioFocusRequest());
        }
        return audioManager.abandonAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener());
    }

    private AudioManagerCompat() {
    }
}
