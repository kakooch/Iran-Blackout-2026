package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
final class AudioFocusManager {
    private AudioAttributes audioAttributes;
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private int focusGain;
    private final AudioFocusListener focusListener;
    private PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier = 1.0f;
    private int audioFocusState = 0;

    public interface PlayerControl {
        void executePlayerCommand(int playerCommand);

        void setVolumeMultiplier(float volumeMultiplier);
    }

    public AudioFocusManager(Context context, Handler eventHandler, PlayerControl playerControl) {
        this.audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.playerControl = playerControl;
        this.focusListener = new AudioFocusListener(eventHandler);
    }

    public float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (Util.areEqual(this.audioAttributes, audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        int iConvertAudioAttributesToFocusGain = convertAudioAttributesToFocusGain(audioAttributes);
        this.focusGain = iConvertAudioAttributesToFocusGain;
        boolean z = true;
        if (iConvertAudioAttributesToFocusGain != 1 && iConvertAudioAttributesToFocusGain != 0) {
            z = false;
        }
        Assertions.checkArgument(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int updateAudioFocus(boolean playWhenReady, int playbackState) {
        if (shouldAbandonAudioFocus(playbackState)) {
            abandonAudioFocus();
            return playWhenReady ? 1 : -1;
        }
        if (playWhenReady) {
            return requestAudioFocus();
        }
        return -1;
    }

    public void release() {
        this.playerControl = null;
        abandonAudioFocus();
    }

    private boolean shouldAbandonAudioFocus(int playbackState) {
        return playbackState == 1 || this.focusGain != 1;
    }

    private int requestAudioFocus() {
        if (this.audioFocusState == 1) {
            return 1;
        }
        if ((Util.SDK_INT >= 26 ? requestAudioFocusV26() : requestAudioFocusDefault()) == 1) {
            setAudioFocusState(1);
            return 1;
        }
        setAudioFocusState(0);
        return -1;
    }

    private void abandonAudioFocus() {
        if (this.audioFocusState == 0) {
            return;
        }
        if (Util.SDK_INT >= 26) {
            abandonAudioFocusV26();
        } else {
            abandonAudioFocusDefault();
        }
        setAudioFocusState(0);
    }

    private int requestAudioFocusDefault() {
        return this.audioManager.requestAudioFocus(this.focusListener, Util.getStreamTypeForAudioUsage(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).usage), this.focusGain);
    }

    private int requestAudioFocusV26() {
        AudioFocusRequest.Builder builder;
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest == null || this.rebuildAudioFocusRequest) {
            if (audioFocusRequest == null) {
                builder = new AudioFocusRequest.Builder(this.focusGain);
            } else {
                builder = new AudioFocusRequest.Builder(this.audioFocusRequest);
            }
            this.audioFocusRequest = builder.setAudioAttributes(((AudioAttributes) Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(willPauseWhenDucked()).setOnAudioFocusChangeListener(this.focusListener).build();
            this.rebuildAudioFocusRequest = false;
        }
        return this.audioManager.requestAudioFocus(this.audioFocusRequest);
    }

    private void abandonAudioFocusDefault() {
        this.audioManager.abandonAudioFocus(this.focusListener);
    }

    private void abandonAudioFocusV26() {
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private boolean willPauseWhenDucked() {
        AudioAttributes audioAttributes = this.audioAttributes;
        return audioAttributes != null && audioAttributes.contentType == 1;
    }

    private static int convertAudioAttributesToFocusGain(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.usage) {
            case 0:
                Log.w("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (audioAttributes.contentType == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                Log.w("AudioFocusManager", "Unidentified audio usage: " + audioAttributes.usage);
                return 0;
            case 16:
                return Util.SDK_INT >= 19 ? 4 : 2;
        }
    }

    private void setAudioFocusState(int audioFocusState) {
        if (this.audioFocusState == audioFocusState) {
            return;
        }
        this.audioFocusState = audioFocusState;
        float f = audioFocusState == 3 ? 0.2f : 1.0f;
        if (this.volumeMultiplier == f) {
            return;
        }
        this.volumeMultiplier = f;
        PlayerControl playerControl = this.playerControl;
        if (playerControl != null) {
            playerControl.setVolumeMultiplier(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlatformAudioFocusChange(int focusChange) {
        if (focusChange == -3 || focusChange == -2) {
            if (focusChange == -2 || willPauseWhenDucked()) {
                executePlayerCommand(0);
                setAudioFocusState(2);
                return;
            } else {
                setAudioFocusState(3);
                return;
            }
        }
        if (focusChange == -1) {
            executePlayerCommand(-1);
            abandonAudioFocus();
        } else if (focusChange == 1) {
            setAudioFocusState(1);
            executePlayerCommand(1);
        } else {
            Log.w("AudioFocusManager", "Unknown focus change type: " + focusChange);
        }
    }

    private void executePlayerCommand(int playerCommand) {
        PlayerControl playerControl = this.playerControl;
        if (playerControl != null) {
            playerControl.executePlayerCommand(playerCommand);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private final Handler eventHandler;

        public AudioFocusListener(Handler eventHandler) {
            this.eventHandler = eventHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAudioFocusChange$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAudioFocusChange$0$AudioFocusManager$AudioFocusListener(int i) {
            AudioFocusManager.this.handlePlatformAudioFocusChange(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int focusChange) {
            this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.-$$Lambda$AudioFocusManager$AudioFocusListener$hDsXdOav9vPHI2rafi8uE7GFL_o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioFocusChange$0$AudioFocusManager$AudioFocusListener(focusChange);
                }
            });
        }
    }
}
