package com.pedro.encoder.input.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import android.util.Log;

/* loaded from: classes3.dex */
public class AudioPostProcessEffect {
    private int microphoneId;
    private AcousticEchoCanceler acousticEchoCanceler = null;
    private NoiseSuppressor noiseSuppressor = null;

    public AudioPostProcessEffect(int i) {
        this.microphoneId = i;
    }

    public void enableEchoCanceler() {
        if (AcousticEchoCanceler.isAvailable() && this.acousticEchoCanceler == null) {
            AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(this.microphoneId);
            this.acousticEchoCanceler = acousticEchoCancelerCreate;
            acousticEchoCancelerCreate.setEnabled(true);
            Log.i("AudioPostProcessEffect", "EchoCanceler enabled");
            return;
        }
        Log.e("AudioPostProcessEffect", "This device don't support EchoCanceler");
    }

    public void releaseEchoCanceler() {
        AcousticEchoCanceler acousticEchoCanceler = this.acousticEchoCanceler;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.setEnabled(false);
            this.acousticEchoCanceler.release();
            this.acousticEchoCanceler = null;
        }
    }

    public void enableNoiseSuppressor() {
        if (NoiseSuppressor.isAvailable() && this.noiseSuppressor == null) {
            NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(this.microphoneId);
            this.noiseSuppressor = noiseSuppressorCreate;
            noiseSuppressorCreate.setEnabled(true);
            Log.i("AudioPostProcessEffect", "NoiseSuppressor enabled");
            return;
        }
        Log.e("AudioPostProcessEffect", "This device don't support NoiseSuppressor");
    }

    public void releaseNoiseSuppressor() {
        NoiseSuppressor noiseSuppressor = this.noiseSuppressor;
        if (noiseSuppressor != null) {
            noiseSuppressor.setEnabled(false);
            this.noiseSuppressor.release();
            this.noiseSuppressor = null;
        }
    }
}
