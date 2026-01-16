package io.antmedia.android.broadcaster;

import android.media.AudioRecord;
import android.os.Message;
import android.util.Log;
import io.antmedia.android.broadcaster.encoder.AudioHandler;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
class AudioRecorderThread extends Thread {
    private static final String TAG = AudioRecorderThread.class.getSimpleName();
    private AudioHandler audioHandler;
    private AudioRecord audioRecord;
    private final int mSampleRate;
    private final long startTime;
    private volatile boolean stopThread = false;
    private boolean isMute = false;

    public AudioRecorderThread(int sampleRate, long recordStartTime, AudioHandler audioHandler) {
        this.mSampleRate = sampleRate;
        this.startTime = recordStartTime;
        this.audioHandler = audioHandler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IllegalStateException {
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, 16, 2);
        this.audioRecord = new AudioRecord(1, this.mSampleRate, 16, 2, minBufferSize);
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, 1000, minBufferSize);
        this.audioRecord.startRecording();
        int i = 0;
        do {
            int i2 = this.audioRecord.read(bArr[i], 0, bArr[i].length);
            if (i2 <= 0) {
                break;
            }
            byte[] bArr2 = bArr[i];
            if (this.isMute) {
                bArr2 = new byte[bArr2.length];
            }
            Message messageObtain = Message.obtain(this.audioHandler, 0, bArr2);
            messageObtain.arg1 = i2;
            messageObtain.arg2 = (int) (System.currentTimeMillis() - this.startTime);
            this.audioHandler.sendMessage(messageObtain);
            i++;
            if (i == 1000) {
                i = 0;
            }
        } while (!this.stopThread);
        Log.d(TAG, "AudioThread Finished, release audioRecord");
    }

    public void setAudioEnable(boolean isEnable) {
        this.isMute = !isEnable;
    }

    public void stopAudioRecording() throws IllegalStateException {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null || audioRecord.getRecordingState() != 3) {
            return;
        }
        this.stopThread = true;
        this.audioRecord.stop();
        this.audioRecord.release();
        this.audioRecord = null;
    }
}
