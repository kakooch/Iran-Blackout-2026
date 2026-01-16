package ir.eitaa.messenger.voip;

import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AudioRecordJNI {
    private AcousticEchoCanceler aec;
    private AutomaticGainControl agc;
    private AudioRecord audioRecord;
    private ByteBuffer buffer;
    private int bufferSize;
    private long nativeInst;
    private boolean needResampling = false;
    private NoiseSuppressor ns;
    private boolean running;
    private Thread thread;

    private native void nativeCallback(ByteBuffer buf);

    public AudioRecordJNI(long ptr) {
        this.nativeInst = ptr;
    }

    private int getBufferSize(int min, int sampleRate) {
        return Math.max(AudioRecord.getMinBufferSize(sampleRate, 16, 2), min);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004d -> B:60:0x0052). Please report as a decompilation issue!!! */
    public void init(int sampleRate, int bitsPerSample, int channels, int bufferSize) {
        if (this.audioRecord != null) {
            throw new IllegalStateException("already inited");
        }
        this.bufferSize = bufferSize;
        boolean zTryInit = tryInit(7, 48000);
        boolean z = true;
        if (!zTryInit) {
            zTryInit = tryInit(1, 48000);
        }
        if (!zTryInit) {
            zTryInit = tryInit(7, 44100);
        }
        if (!zTryInit) {
            zTryInit = tryInit(1, 44100);
        }
        if (zTryInit) {
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    if (AutomaticGainControl.isAvailable()) {
                        AutomaticGainControl automaticGainControlCreate = AutomaticGainControl.create(this.audioRecord.getAudioSessionId());
                        this.agc = automaticGainControlCreate;
                        if (automaticGainControlCreate != null) {
                            automaticGainControlCreate.setEnabled(false);
                        }
                    } else {
                        VLog.w("AutomaticGainControl is not available on this device :(");
                    }
                } catch (Throwable th) {
                    VLog.e("error creating AutomaticGainControl", th);
                }
                try {
                    if (NoiseSuppressor.isAvailable()) {
                        NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(this.audioRecord.getAudioSessionId());
                        this.ns = noiseSuppressorCreate;
                        if (noiseSuppressorCreate != null) {
                            noiseSuppressorCreate.setEnabled(Instance.getGlobalServerConfig().useSystemNs && isGoodAudioEffect(this.ns));
                        }
                    } else {
                        VLog.w("NoiseSuppressor is not available on this device :(");
                    }
                } catch (Throwable th2) {
                    VLog.e("error creating NoiseSuppressor", th2);
                }
                try {
                    if (AcousticEchoCanceler.isAvailable()) {
                        AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(this.audioRecord.getAudioSessionId());
                        this.aec = acousticEchoCancelerCreate;
                        if (acousticEchoCancelerCreate != null) {
                            if (!Instance.getGlobalServerConfig().useSystemAec || !isGoodAudioEffect(this.aec)) {
                                z = false;
                            }
                            acousticEchoCancelerCreate.setEnabled(z);
                        }
                    } else {
                        VLog.w("AcousticEchoCanceler is not available on this device");
                    }
                } catch (Throwable th3) {
                    VLog.e("error creating AcousticEchoCanceler", th3);
                }
            }
            this.buffer = ByteBuffer.allocateDirect(bufferSize);
        }
    }

    private boolean tryInit(int source, int sampleRate) {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            try {
                audioRecord.release();
            } catch (Exception unused) {
            }
        }
        VLog.i("Trying to initialize AudioRecord with source=" + source + " and sample rate=" + sampleRate);
        try {
            this.audioRecord = new AudioRecord(source, sampleRate, 16, 2, getBufferSize(this.bufferSize, 48000));
        } catch (Exception e) {
            VLog.e("AudioRecord init failed!", e);
        }
        this.needResampling = sampleRate != 48000;
        AudioRecord audioRecord2 = this.audioRecord;
        return audioRecord2 != null && audioRecord2.getState() == 1;
    }

    public void stop() throws IllegalStateException {
        try {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.stop();
            }
        } catch (Exception unused) {
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
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
        AutomaticGainControl automaticGainControl = this.agc;
        if (automaticGainControl != null) {
            automaticGainControl.release();
            this.agc = null;
        }
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.ns = null;
        }
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
    }

    public boolean start() throws IllegalStateException {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null && audioRecord.getState() == 1) {
            try {
                if (this.thread == null) {
                    AudioRecord audioRecord2 = this.audioRecord;
                    if (audioRecord2 == null) {
                        return false;
                    }
                    audioRecord2.startRecording();
                    startThread();
                } else {
                    this.audioRecord.startRecording();
                }
                return true;
            } catch (Exception e) {
                VLog.e("Error initializing AudioRecord", e);
            }
        }
        return false;
    }

    private void startThread() {
        if (this.thread != null) {
            throw new IllegalStateException("thread already started");
        }
        this.running = true;
        final ByteBuffer byteBufferAllocateDirect = this.needResampling ? ByteBuffer.allocateDirect(1764) : null;
        Thread thread = new Thread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$AudioRecordJNI$n12cWHhzBz15Jgs34YqV2nhxEHo
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f$0.lambda$startThread$0$AudioRecordJNI(byteBufferAllocateDirect);
            }
        });
        this.thread = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startThread$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startThread$0$AudioRecordJNI(ByteBuffer byteBuffer) throws IllegalStateException {
        while (this.running) {
            try {
                if (!this.needResampling) {
                    this.audioRecord.read(this.buffer, 1920);
                } else {
                    this.audioRecord.read(byteBuffer, 1764);
                    Resampler.convert44to48(byteBuffer, this.buffer);
                }
            } catch (Exception e) {
                VLog.e(e);
            }
            if (!this.running) {
                this.audioRecord.stop();
                break;
            }
            nativeCallback(this.buffer);
        }
        VLog.i("audiorecord thread exits");
    }

    public int getEnabledEffectsMask() {
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        int i = (acousticEchoCanceler == null || !acousticEchoCanceler.getEnabled()) ? 0 : 1;
        NoiseSuppressor noiseSuppressor = this.ns;
        return (noiseSuppressor == null || !noiseSuppressor.getEnabled()) ? i : i | 2;
    }

    private static Pattern makeNonEmptyRegex(String configKey) {
        String string = Instance.getGlobalServerConfig().getString(configKey);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Pattern.compile(string);
        } catch (Exception e) {
            VLog.e(e);
            return null;
        }
    }

    private static boolean isGoodAudioEffect(AudioEffect effect) throws IllegalStateException {
        Pattern patternMakeNonEmptyRegex = makeNonEmptyRegex("adsp_good_impls");
        Pattern patternMakeNonEmptyRegex2 = makeNonEmptyRegex("adsp_good_names");
        AudioEffect.Descriptor descriptor = effect.getDescriptor();
        VLog.d(effect.getClass().getSimpleName() + ": implementor=" + descriptor.implementor + ", name=" + descriptor.name);
        if (patternMakeNonEmptyRegex != null && patternMakeNonEmptyRegex.matcher(descriptor.implementor).find()) {
            return true;
        }
        if (patternMakeNonEmptyRegex2 != null && patternMakeNonEmptyRegex2.matcher(descriptor.name).find()) {
            return true;
        }
        if (effect instanceof AcousticEchoCanceler) {
            Pattern patternMakeNonEmptyRegex3 = makeNonEmptyRegex("aaec_good_impls");
            Pattern patternMakeNonEmptyRegex4 = makeNonEmptyRegex("aaec_good_names");
            if (patternMakeNonEmptyRegex3 != null && patternMakeNonEmptyRegex3.matcher(descriptor.implementor).find()) {
                return true;
            }
            if (patternMakeNonEmptyRegex4 != null && patternMakeNonEmptyRegex4.matcher(descriptor.name).find()) {
                return true;
            }
        }
        if (!(effect instanceof NoiseSuppressor)) {
            return false;
        }
        Pattern patternMakeNonEmptyRegex5 = makeNonEmptyRegex("ans_good_impls");
        Pattern patternMakeNonEmptyRegex6 = makeNonEmptyRegex("ans_good_names");
        if (patternMakeNonEmptyRegex5 == null || !patternMakeNonEmptyRegex5.matcher(descriptor.implementor).find()) {
            return patternMakeNonEmptyRegex6 != null && patternMakeNonEmptyRegex6.matcher(descriptor.name).find();
        }
        return true;
    }
}
