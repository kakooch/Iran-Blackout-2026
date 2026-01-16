package ir.eitaa.messenger.voip;

import android.media.AudioTrack;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class AudioTrackJNI {
    private AudioTrack audioTrack;
    private byte[] buffer = new byte[1920];
    private long nativeInst;
    private boolean needResampling;
    private boolean running;
    private Thread thread;

    private native void nativeCallback(byte[] buf);

    public AudioTrackJNI(long ptr) {
        this.nativeInst = ptr;
    }

    private int getBufferSize(int min, int sampleRate) {
        return Math.max(AudioTrack.getMinBufferSize(sampleRate, 4, 2), min);
    }

    public void init(int sampleRate, int bitsPerSample, int channels, int bufferSize) {
        if (this.audioTrack != null) {
            throw new IllegalStateException("already inited");
        }
        AudioTrack audioTrack = new AudioTrack(0, 48000, channels == 1 ? 4 : 12, 2, getBufferSize(bufferSize, 48000), 1);
        this.audioTrack = audioTrack;
        if (audioTrack.getState() != 1) {
            VLog.w("Error initializing AudioTrack with 48k, trying 44.1k with resampling");
            try {
                this.audioTrack.release();
            } catch (Throwable unused) {
            }
            int bufferSize2 = getBufferSize(bufferSize * 6, 44100);
            VLog.d("buffer size: " + bufferSize2);
            this.audioTrack = new AudioTrack(0, 44100, channels == 1 ? 4 : 12, 2, bufferSize2, 1);
            this.needResampling = true;
        }
    }

    public void stop() throws IllegalStateException {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
            } catch (Exception unused) {
            }
        }
    }

    public void release() throws InterruptedException {
        this.running = false;
        Thread thread = this.thread;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                VLog.e(e);
            }
            this.thread = null;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    public void start() throws IllegalStateException {
        if (this.thread == null) {
            startThread();
        } else {
            this.audioTrack.play();
        }
    }

    private void startThread() {
        if (this.thread != null) {
            throw new IllegalStateException("thread already started");
        }
        this.running = true;
        Thread thread = new Thread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$AudioTrackJNI$DIf5XOM-O4z2utfzUbq3JGOMgp0
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$startThread$0$AudioTrackJNI();
            }
        });
        this.thread = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startThread$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startThread$0$AudioTrackJNI() throws IllegalStateException {
        try {
            this.audioTrack.play();
            ByteBuffer byteBufferAllocateDirect = this.needResampling ? ByteBuffer.allocateDirect(1920) : null;
            ByteBuffer byteBufferAllocateDirect2 = this.needResampling ? ByteBuffer.allocateDirect(1764) : null;
            while (this.running) {
                try {
                    if (this.needResampling) {
                        nativeCallback(this.buffer);
                        byteBufferAllocateDirect.rewind();
                        byteBufferAllocateDirect.put(this.buffer);
                        Resampler.convert48to44(byteBufferAllocateDirect, byteBufferAllocateDirect2);
                        byteBufferAllocateDirect2.rewind();
                        byteBufferAllocateDirect2.get(this.buffer, 0, 1764);
                        this.audioTrack.write(this.buffer, 0, 1764);
                    } else {
                        nativeCallback(this.buffer);
                        this.audioTrack.write(this.buffer, 0, 1920);
                    }
                } catch (Exception e) {
                    VLog.e(e);
                }
                if (!this.running) {
                    this.audioTrack.stop();
                    break;
                }
                continue;
            }
            VLog.i("audiotrack thread exits");
        } catch (Exception e2) {
            VLog.e("error starting AudioTrack", e2);
        }
    }
}
