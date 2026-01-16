package com.pedro.encoder.input.audio;

import android.media.AudioRecord;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.pedro.encoder.Frame;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MicrophoneManager {
    private AudioPostProcessEffect audioPostProcessEffect;
    protected AudioRecord audioRecord;
    private GetMicrophoneData getMicrophoneData;
    HandlerThread handlerThread;
    private ByteBuffer pcmBuffer = ByteBuffer.allocateDirect(4096);
    private byte[] pcmBufferMuted = new byte[4096];
    protected boolean running = false;
    private int sampleRate = 32000;
    private int audioFormat = 2;
    private int channel = 12;
    private boolean muted = false;
    private CustomAudioEffect customAudioEffect = new NoAudioEffect();

    public int getMaxInputSize() {
        return 4096;
    }

    public MicrophoneManager(GetMicrophoneData getMicrophoneData) {
        this.getMicrophoneData = getMicrophoneData;
    }

    public void createMicrophone(int i, boolean z, boolean z2, boolean z3) {
        createMicrophone(0, i, z, z2, z3);
    }

    public void createMicrophone(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.sampleRate = i2;
        if (!z) {
            this.channel = 16;
        }
        AudioRecord audioRecord = new AudioRecord(i, i2, this.channel, this.audioFormat, getPcmBufferSize());
        this.audioRecord = audioRecord;
        AudioPostProcessEffect audioPostProcessEffect = new AudioPostProcessEffect(audioRecord.getAudioSessionId());
        this.audioPostProcessEffect = audioPostProcessEffect;
        if (z2) {
            audioPostProcessEffect.enableEchoCanceler();
        }
        if (z3) {
            this.audioPostProcessEffect.enableNoiseSuppressor();
        }
        Log.i("MicrophoneManager", "Microphone created, " + i2 + "hz, " + (z ? "Stereo" : "Mono"));
    }

    public synchronized void start() {
        init();
        HandlerThread handlerThread = new HandlerThread("MicrophoneManager");
        this.handlerThread = handlerThread;
        handlerThread.start();
        new Handler(this.handlerThread.getLooper()).post(new Runnable() { // from class: com.pedro.encoder.input.audio.MicrophoneManager.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    MicrophoneManager microphoneManager = MicrophoneManager.this;
                    if (!microphoneManager.running) {
                        return;
                    }
                    Frame frame = microphoneManager.read();
                    if (frame != null) {
                        MicrophoneManager.this.getMicrophoneData.inputPCMData(frame);
                    } else {
                        MicrophoneManager.this.running = false;
                    }
                }
            }
        });
    }

    private void init() throws IllegalStateException {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.startRecording();
            this.running = true;
            Log.i("MicrophoneManager", "Microphone started");
            return;
        }
        Log.e("MicrophoneManager", "Error starting, microphone was stopped or not created, use createMicrophone() before start()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Frame read() {
        this.pcmBuffer.rewind();
        AudioRecord audioRecord = this.audioRecord;
        ByteBuffer byteBuffer = this.pcmBuffer;
        int i = audioRecord.read(byteBuffer, byteBuffer.remaining());
        if (i <= 0) {
            return null;
        }
        return new Frame(this.muted ? this.pcmBufferMuted : this.customAudioEffect.process(this.pcmBuffer.array()), this.muted ? 0 : this.pcmBuffer.arrayOffset(), i);
    }

    public synchronized void stop() {
        this.running = false;
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
        }
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.setRecordPositionUpdateListener(null);
            this.audioRecord.stop();
            this.audioRecord.release();
            this.audioRecord = null;
        }
        AudioPostProcessEffect audioPostProcessEffect = this.audioPostProcessEffect;
        if (audioPostProcessEffect != null) {
            audioPostProcessEffect.releaseEchoCanceler();
            this.audioPostProcessEffect.releaseNoiseSuppressor();
        }
        Log.i("MicrophoneManager", "Microphone stopped");
    }

    private int getPcmBufferSize() {
        return AudioRecord.getMinBufferSize(this.sampleRate, this.channel, 2) * 5;
    }
}
