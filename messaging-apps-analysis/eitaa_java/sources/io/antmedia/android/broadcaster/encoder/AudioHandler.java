package io.antmedia.android.broadcaster.encoder;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import java.lang.Thread;

/* loaded from: classes.dex */
public class AudioHandler extends Handler {
    private AudioEncoder audioEncoder;

    public AudioHandler(Looper looper) {
        super(looper);
        this.audioEncoder = null;
    }

    public boolean startAudioEncoder(IMediaMuxer muxerHandler, int sampleRate, int bufferSize) {
        AudioEncoder audioEncoder = new AudioEncoder();
        this.audioEncoder = audioEncoder;
        try {
            return audioEncoder.startAudioEncoder(sampleRate, 1, 64000, bufferSize, muxerHandler);
        } catch (Exception e) {
            e.printStackTrace();
            this.audioEncoder = null;
            return false;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) throws MediaCodec.CryptoException, InterruptedException {
        AudioEncoder audioEncoder = this.audioEncoder;
        if (audioEncoder == null) {
            return;
        }
        int i = msg.what;
        if (i != 0) {
            if (i == 2 && audioEncoder.getState() == Thread.State.RUNNABLE) {
                Log.d("audio handler", "stop audio encoding...");
                this.audioEncoder.stopEncoding();
                removeMessages(0);
                return;
            }
            return;
        }
        audioEncoder.encodeAudio((byte[]) msg.obj, msg.arg1, msg.arg2 * 1000);
    }
}
