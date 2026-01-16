package ir.nasim;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* loaded from: classes3.dex */
public final class HN {
    public final AudioFocusRequest a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2, int i3) {
        AbstractC13042fc3.i(onAudioFocusChangeListener, "audioFocusChangeListener");
        AudioFocusRequest audioFocusRequestBuild = BN.a(i).setAudioAttributes(new AudioAttributes.Builder().setUsage(i2).setContentType(i3).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(onAudioFocusChangeListener).build();
        AbstractC13042fc3.h(audioFocusRequestBuild, "AudioFocusRequest.Builde…ner)\n            .build()");
        return audioFocusRequestBuild;
    }
}
