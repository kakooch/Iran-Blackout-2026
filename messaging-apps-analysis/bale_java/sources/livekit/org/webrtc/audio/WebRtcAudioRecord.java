package livekit.org.webrtc.audio;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import livekit.org.webrtc.CalledByNative;
import livekit.org.webrtc.Logging;
import livekit.org.webrtc.ThreadUtils;
import livekit.org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes8.dex */
class WebRtcAudioRecord {
    private static final int AUDIO_RECORD_START = 0;
    private static final int AUDIO_RECORD_STOP = 1;
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int CHECK_REC_STATUS_DELAY_MS = 100;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private static final AtomicInteger nextSchedulerId = new AtomicInteger(0);
    private final JavaAudioDeviceModule.AudioBufferCallback audioBufferCallback;
    private final int audioFormat;
    private final AudioManager audioManager;
    private volatile AudioRecord audioRecord;
    private final Object audioRecordStateLock;
    private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private final int audioSource;
    private final AtomicReference<Boolean> audioSourceMatchesRecordingSessionRef;
    private AudioRecordThread audioThread;
    private final Object audioThreadStateLock;
    private ByteBuffer byteBuffer;
    private int channelCount;
    private AtomicBoolean clientCalledStartRecording;
    private final Context context;
    private final WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    private final ScheduledExecutorService executor;
    private int expectedChannelCount;
    private int expectedSampleRate;
    private ScheduledFuture<String> future;
    private final boolean isAcousticEchoCancelerSupported;
    private final boolean isNoiseSuppressorSupported;
    private volatile boolean microphoneMute;
    private long nativeAudioRecord;
    private AtomicBoolean nativeCalledInitRecording;
    private AtomicBoolean nativeCalledStartRecording;
    private AudioDeviceInfo preferredDevice;
    private int sampleRate;
    private final JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;
    private boolean useAudioRecord;

    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            AudioRecord audioRecord;
            boolean z;
            int iCapacity;
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            if (WebRtcAudioRecord.this.audioRecord != null) {
                WebRtcAudioRecord.assertTrue(WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3);
            }
            WebRtcAudioRecord.this.doAudioRecordStateCallback(0);
            System.nanoTime();
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            while (this.keepAlive) {
                synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                    audioRecord = WebRtcAudioRecord.this.audioRecord;
                    z = WebRtcAudioRecord.this.nativeCalledInitRecording.get();
                }
                AudioRecord audioRecord2 = null;
                if (audioRecord == null && WebRtcAudioRecord.this.useAudioRecord) {
                    if (WebRtcAudioRecord.this.initAudioRecord()) {
                        synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                            audioRecord = WebRtcAudioRecord.this.audioRecord;
                        }
                        WebRtcAudioRecord.assertTrue(audioRecord != null);
                        try {
                            audioRecord.startRecording();
                        } catch (IllegalStateException e) {
                            WebRtcAudioRecord.this.reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
                            WebRtcAudioRecord.this.useAudioRecord = false;
                            audioRecord = null;
                        }
                        if (WebRtcAudioRecord.this.useAudioRecord && audioRecord.getRecordingState() != 3) {
                            WebRtcAudioRecord.this.reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state: " + audioRecord.getRecordingState());
                            WebRtcAudioRecord.this.useAudioRecord = false;
                            audioRecord = null;
                        }
                    } else {
                        WebRtcAudioRecord.this.useAudioRecord = false;
                    }
                }
                if (audioRecord == null || WebRtcAudioRecord.this.useAudioRecord) {
                    audioRecord2 = audioRecord;
                } else {
                    WebRtcAudioRecord.this.releaseAudioResources();
                }
                long j = 0;
                if (audioRecord2 != null) {
                    int i = audioRecord2.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                    if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                        if (WebRtcAudioRecord.this.microphoneMute) {
                            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                        }
                        if (this.keepAlive && audioRecord2.getTimestamp(audioTimestamp, 0) == 0) {
                            j = audioTimestamp.nanoTime;
                        }
                        iCapacity = i;
                    } else {
                        String str = "AudioRecord.read failed: " + i;
                        Logging.e(WebRtcAudioRecord.TAG, str);
                        if (i == -3) {
                            this.keepAlive = false;
                            WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                        }
                    }
                } else {
                    WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    iCapacity = 0;
                }
                long jOnBuffer = j;
                if (this.keepAlive && WebRtcAudioRecord.this.audioBufferCallback != null) {
                    jOnBuffer = WebRtcAudioRecord.this.audioBufferCallback.onBuffer(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.audioFormat, WebRtcAudioRecord.this.channelCount, WebRtcAudioRecord.this.sampleRate, iCapacity, jOnBuffer);
                    iCapacity = WebRtcAudioRecord.this.byteBuffer.capacity();
                }
                int i2 = iCapacity;
                long j2 = jOnBuffer;
                if (this.keepAlive && z) {
                    WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                    webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, i2, j2);
                }
                if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null) {
                    WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioFormat, WebRtcAudioRecord.this.channelCount, WebRtcAudioRecord.this.sampleRate, Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset())));
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (IllegalStateException e2) {
                Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e2.getMessage());
            }
            WebRtcAudioRecord.this.doAudioRecordStateCallback(1);
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    @CalledByNative
    WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, newDefaultScheduler(), audioManager, 7, 2, null, null, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported(), WebRtcAudioManager.getSampleRate(audioManager), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private static String audioStateToString(int i) {
        return i != 0 ? i != 1 ? "INVALID" : "STOP" : "START";
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    private static boolean checkDeviceMatch(AudioDeviceInfo audioDeviceInfo, AudioDeviceInfo audioDeviceInfo2) {
        return audioDeviceInfo.getId() == audioDeviceInfo2.getId() && audioDeviceInfo.getType() == audioDeviceInfo2.getType();
    }

    private static AudioRecord createAudioRecordOnLowerThanM(int i, int i2, int i3, int i4, int i5) {
        Logging.d(TAG, "createAudioRecordOnLowerThanM");
        return new AudioRecord(i, i2, i3, i4, i5);
    }

    private static AudioRecord createAudioRecordOnMOrHigher(int i, int i2, int i3, int i4, int i5) {
        Logging.d(TAG, "createAudioRecordOnMOrHigher");
        return new AudioRecord.Builder().setAudioSource(i).setAudioFormat(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i2).setChannelMask(i3).build()).setBufferSizeInBytes(i5).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAudioRecordStateCallback(int i) {
        Logging.d(TAG, "doAudioRecordStateCallback: " + audioStateToString(i));
        JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback = this.stateCallback;
        if (audioRecordStateCallback != null) {
            if (i == 0) {
                audioRecordStateCallback.onWebRtcAudioRecordStart();
            } else if (i == 1) {
                audioRecordStateCallback.onWebRtcAudioRecordStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    @CalledByNative
    private boolean enableBuiltInAEC(boolean z) {
        Logging.d(TAG, "enableBuiltInAEC(" + z + Separators.RPAREN);
        return this.effects.setAEC(z);
    }

    @CalledByNative
    private boolean enableBuiltInNS(boolean z) {
        Logging.d(TAG, "enableBuiltInNS(" + z + Separators.RPAREN);
        return this.effects.setNS(z);
    }

    private static int getBytesPerFrame(int i, int i2) {
        return i * getBytesPerSample(i2);
    }

    private static int getBytesPerSample(int i) {
        int i2 = 1;
        if (i != 1 && i != 2) {
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    if (i != 13) {
                        throw new IllegalArgumentException("Bad audio format " + i);
                    }
                }
            }
            return i2;
        }
        return 2;
    }

    private static int getFramesPerBuffer(int i) {
        return i / 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initAudioRecord() {
        if (this.sampleRate == 0 || this.channelCount == 0) {
            Logging.w(TAG, "initAudioRecord called before initRecord!");
            return false;
        }
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    reportWebRtcAudioRecordInitError("InitAudioRecord called twice without StopRecording.");
                    return false;
                }
                int iChannelCountToConfiguration = channelCountToConfiguration(this.channelCount);
                int minBufferSize = AudioRecord.getMinBufferSize(this.sampleRate, iChannelCountToConfiguration, this.audioFormat);
                if (minBufferSize != -1 && minBufferSize != -2) {
                    Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
                    int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
                    Logging.d(TAG, "bufferSizeInBytes: " + iMax);
                    try {
                        this.audioRecord = createAudioRecordOnMOrHigher(this.audioSource, this.sampleRate, iChannelCountToConfiguration, this.audioFormat, iMax);
                        this.audioSourceMatchesRecordingSessionRef.set(null);
                        AudioDeviceInfo audioDeviceInfo = this.preferredDevice;
                        if (audioDeviceInfo != null) {
                            setPreferredDevice(audioDeviceInfo);
                        }
                        if (this.audioRecord != null && this.audioRecord.getState() == 1) {
                            this.effects.enable(this.audioRecord.getAudioSessionId());
                            logMainParameters();
                            logMainParametersExtended();
                            return true;
                        }
                        reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
                        releaseAudioResources();
                        return false;
                    } catch (IllegalArgumentException | UnsupportedOperationException e) {
                        reportWebRtcAudioRecordInitError(e.getMessage());
                        releaseAudioResources();
                        return false;
                    }
                }
                reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @CalledByNative
    private int initRecording(int i, int i2) {
        Logging.d(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + Separators.RPAREN);
        synchronized (this.audioRecordStateLock) {
            try {
                if (!this.nativeCalledInitRecording.compareAndSet(false, true)) {
                    reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
                    return -1;
                }
                if (this.audioRecord == null) {
                    return initRecordingImpl(i, i2, true);
                }
                int framesPerBuffer = getFramesPerBuffer(i);
                ByteBuffer byteBuffer = this.byteBuffer;
                if (byteBuffer == null) {
                    throw new IllegalStateException("initRecording: byteBuffer is null!");
                }
                nativeCacheDirectBufferAddress(this.nativeAudioRecord, byteBuffer);
                return framesPerBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int initRecordingImpl(int i, int i2, boolean z) {
        Logging.d(TAG, "initRecordingImpl(sampleRate=" + i + ", channels=" + i2 + Separators.RPAREN);
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        this.sampleRate = i;
        this.channelCount = i2;
        int bytesPerFrame = getBytesPerFrame(i2, this.audioFormat);
        int framesPerBuffer = getFramesPerBuffer(i);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytesPerFrame * framesPerBuffer);
        this.byteBuffer = byteBufferAllocateDirect;
        if (!byteBufferAllocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        if (z) {
            nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        }
        if (this.useAudioRecord && !initAudioRecord()) {
            return -1;
        }
        int iLogRecordingConfigurations = logRecordingConfigurations(this.audioRecord, false);
        if (iLogRecordingConfigurations != 0) {
            Logging.w(TAG, "Potential microphone conflict. Active sessions: " + iLogRecordingConfigurations);
        }
        return framesPerBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$scheduleLogRecordingConfigurationsTask$0(AudioRecord audioRecord) {
        if (this.audioRecord == audioRecord) {
            logRecordingConfigurations(audioRecord, true);
            return "Scheduled task is done";
        }
        Logging.d(TAG, "audio record has changed");
        return "Scheduled task is done";
    }

    private static boolean logActiveRecordingConfigs(int i, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        Logging.d(TAG, "AudioRecordingConfigurations: ");
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            StringBuilder sb = new StringBuilder();
            int clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
            sb.append("  client audio source=");
            sb.append(WebRtcAudioUtils.audioSourceToString(clientAudioSource));
            sb.append(", client session id=");
            sb.append(audioRecordingConfiguration.getClientAudioSessionId());
            sb.append(" (");
            sb.append(i);
            sb.append(Separators.RPAREN);
            sb.append(Separators.RETURN);
            AudioFormat format = audioRecordingConfiguration.getFormat();
            sb.append("  Device AudioFormat: ");
            sb.append("channel count=");
            sb.append(format.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(format.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(format.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(format.getEncoding()));
            sb.append(", sample rate=");
            sb.append(format.getSampleRate());
            sb.append(Separators.RETURN);
            AudioFormat clientFormat = audioRecordingConfiguration.getClientFormat();
            sb.append("  Client AudioFormat: ");
            sb.append("channel count=");
            sb.append(clientFormat.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(clientFormat.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(clientFormat.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(clientFormat.getEncoding()));
            sb.append(", sample rate=");
            sb.append(clientFormat.getSampleRate());
            sb.append(Separators.RETURN);
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null) {
                assertTrue(audioDevice.isSource());
                sb.append("  AudioDevice: ");
                sb.append("type=");
                sb.append(WebRtcAudioUtils.deviceTypeToString(audioDevice.getType()));
                sb.append(", id=");
                sb.append(audioDevice.getId());
            }
            Logging.d(TAG, sb.toString());
        }
        return true;
    }

    private void logMainParameters() {
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void logMainParametersExtended() {
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int logRecordingConfigurations(AudioRecord audioRecord, boolean z) {
        if (audioRecord == null) {
            return 0;
        }
        List<AudioRecordingConfiguration> activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
        int size = activeRecordingConfigurations.size();
        Logging.d(TAG, "Number of active recording sessions: " + size);
        if (size > 0) {
            logActiveRecordingConfigs(audioRecord.getAudioSessionId(), activeRecordingConfigurations);
            if (z) {
                this.audioSourceMatchesRecordingSessionRef.set(Boolean.valueOf(verifyAudioConfig(audioRecord.getAudioSource(), audioRecord.getAudioSessionId(), audioRecord.getFormat(), audioRecord.getRoutedDevice(), activeRecordingConfigurations)));
            }
        }
        return size;
    }

    private native void nativeCacheDirectBufferAddress(long j, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j, int i, long j2);

    static ScheduledExecutorService newDefaultScheduler() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        return Executors.newScheduledThreadPool(0, new ThreadFactory() { // from class: livekit.org.webrtc.audio.WebRtcAudioRecord.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName(String.format("WebRtcAudioRecordScheduler-%s-%s", Integer.valueOf(WebRtcAudioRecord.nextSchedulerId.getAndIncrement()), Integer.valueOf(atomicInteger.getAndIncrement())));
                return threadNewThread;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        synchronized (this.audioRecordStateLock) {
            try {
                this.effects.release();
                if (this.audioRecord != null) {
                    this.audioRecord.release();
                    this.audioRecord = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.audioSourceMatchesRecordingSessionRef.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + String.valueOf(audioRecordStartErrorCode) + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    private void scheduleLogRecordingConfigurationsTask(final AudioRecord audioRecord) {
        Logging.d(TAG, "scheduleLogRecordingConfigurationsTask");
        Callable callable = new Callable() { // from class: livekit.org.webrtc.audio.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.lambda$scheduleLogRecordingConfigurationsTask$0(audioRecord);
            }
        };
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.future.cancel(true);
        }
        this.future = this.executor.schedule(callable, 100L, TimeUnit.MILLISECONDS);
    }

    @CalledByNative
    private boolean startRecording() {
        if (!this.nativeCalledStartRecording.compareAndSet(false, true)) {
            throw new IllegalStateException("startRecording called twice without stopRecording");
        }
        if (this.audioThread == null) {
            synchronized (this.audioRecordStateLock) {
                synchronized (this.audioThreadStateLock) {
                    if (this.audioThread == null) {
                        return startRecordingImpl();
                    }
                }
            }
        }
        return true;
    }

    private boolean startRecordingImpl() {
        Logging.d(TAG, "startRecording");
        synchronized (this.audioRecordStateLock) {
            synchronized (this.audioThreadStateLock) {
                assertTrue(this.audioThread == null);
                if (this.useAudioRecord) {
                    assertTrue(this.audioRecord != null);
                    try {
                        this.audioRecord.startRecording();
                        if (this.audioRecord.getRecordingState() != 3) {
                            reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state: " + this.audioRecord.getRecordingState());
                            return false;
                        }
                    } catch (IllegalStateException e) {
                        reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
                        return false;
                    }
                }
                AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                scheduleLogRecordingConfigurationsTask(this.audioRecord);
                return true;
            }
        }
    }

    @CalledByNative
    private boolean stopRecording() {
        boolean zStopRecordingIfNeededImpl;
        Logging.d(TAG, "stopRecording");
        synchronized (this.audioRecordStateLock) {
            this.nativeCalledStartRecording.set(false);
            this.nativeCalledInitRecording.set(false);
            zStopRecordingIfNeededImpl = stopRecordingIfNeededImpl();
        }
        return zStopRecordingIfNeededImpl;
    }

    private boolean stopRecordingIfNeededImpl() {
        synchronized (this.audioRecordStateLock) {
            try {
                if (!this.clientCalledStartRecording.get() && !this.nativeCalledStartRecording.get()) {
                    Logging.d(TAG, "stopping recording");
                    assertTrue(this.audioThread != null);
                    ScheduledFuture<String> scheduledFuture = this.future;
                    if (scheduledFuture != null) {
                        if (!scheduledFuture.isDone()) {
                            this.future.cancel(true);
                        }
                        this.future = null;
                    }
                    this.audioThread.stopThread();
                    if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
                        Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
                        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
                    }
                    this.audioThread = null;
                    releaseAudioResources();
                    return true;
                }
                return true;
            } finally {
            }
        }
    }

    private static boolean verifyAudioConfig(int i, int i2, AudioFormat audioFormat, AudioDeviceInfo audioDeviceInfo, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null && audioRecordingConfiguration.getClientAudioSource() == i && audioRecordingConfiguration.getClientAudioSessionId() == i2 && audioRecordingConfiguration.getClientFormat().getEncoding() == audioFormat.getEncoding() && audioRecordingConfiguration.getClientFormat().getSampleRate() == audioFormat.getSampleRate() && audioRecordingConfiguration.getClientFormat().getChannelMask() == audioFormat.getChannelMask() && audioRecordingConfiguration.getClientFormat().getChannelIndexMask() == audioFormat.getChannelIndexMask() && audioRecordingConfiguration.getFormat().getEncoding() != 0 && audioRecordingConfiguration.getFormat().getSampleRate() > 0 && (audioRecordingConfiguration.getFormat().getChannelMask() != 0 || audioRecordingConfiguration.getFormat().getChannelIndexMask() != 0)) {
                if (checkDeviceMatch(audioDevice, audioDeviceInfo)) {
                    Logging.d(TAG, "verifyAudioConfig: PASS");
                    return true;
                }
            }
        }
        Logging.e(TAG, "verifyAudioConfig: FAILED");
        return false;
    }

    public boolean initRecordingIfNeeded() {
        synchronized (this.audioRecordStateLock) {
            try {
                boolean z = true;
                if (this.audioRecord != null) {
                    return true;
                }
                if (initRecordingImpl(this.expectedSampleRate, this.expectedChannelCount, false) < 0) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }

    @CalledByNative
    boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    @CalledByNative
    boolean isAudioConfigVerified() {
        return this.audioSourceMatchesRecordingSessionRef.get() != null;
    }

    @CalledByNative
    boolean isAudioSourceMatchingRecordingSession() {
        Boolean bool = this.audioSourceMatchesRecordingSessionRef.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        Logging.w(TAG, "Audio configuration has not yet been verified");
        return false;
    }

    @CalledByNative
    boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    public boolean prewarmRecordingIfNeeded() {
        if (this.audioThread != null) {
            return true;
        }
        synchronized (this.audioRecordStateLock) {
            synchronized (this.audioThreadStateLock) {
                if (this.audioThread != null) {
                    return true;
                }
                return startRecordingImpl();
            }
        }
    }

    public void setMicrophoneMute(boolean z) {
        Logging.w(TAG, "setMicrophoneMute(" + z + Separators.RPAREN);
        this.microphoneMute = z;
    }

    @CalledByNative
    public void setNativeAudioRecord(long j) {
        this.nativeAudioRecord = j;
    }

    public boolean setNoiseSuppressorEnabled(boolean z) {
        if (!WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            Logging.e(TAG, "Noise suppressor is not supported.");
            return false;
        }
        Logging.w(TAG, "SetNoiseSuppressorEnabled(" + z + Separators.RPAREN);
        return this.effects.toggleNS(z);
    }

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        Logging.d(TAG, "setPreferredDevice " + (audioDeviceInfo != null ? Integer.valueOf(audioDeviceInfo.getId()) : null));
        this.preferredDevice = audioDeviceInfo;
        if (this.audioRecord == null || this.audioRecord.setPreferredDevice(audioDeviceInfo)) {
            return;
        }
        Logging.e(TAG, "setPreferredDevice failed");
    }

    public void setUseAudioRecord(boolean z) {
        Logging.d(TAG, "setUseAudioRecord(" + z + Separators.RPAREN);
        this.useAudioRecord = z;
    }

    public boolean startRecordingIfNeeded() {
        this.clientCalledStartRecording.set(true);
        if (this.audioThread == null) {
            synchronized (this.audioRecordStateLock) {
                synchronized (this.audioThreadStateLock) {
                    if (this.audioThread == null) {
                        return startRecordingImpl();
                    }
                }
            }
        }
        return true;
    }

    public boolean stopRecordingIfNeeded() {
        Logging.d(TAG, "stopRecordingIfNeeded");
        synchronized (this.audioRecordStateLock) {
            try {
                this.clientCalledStartRecording.set(false);
                if (this.audioThread == null) {
                    return true;
                }
                return stopRecordingIfNeededImpl();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public WebRtcAudioRecord(Context context, ScheduledExecutorService scheduledExecutorService, AudioManager audioManager, int i, int i2, JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, JavaAudioDeviceModule.AudioBufferCallback audioBufferCallback, boolean z, boolean z2, int i3, int i4) {
        this.effects = new WebRtcAudioEffects();
        this.audioRecordStateLock = new Object();
        this.useAudioRecord = true;
        this.audioThreadStateLock = new Object();
        this.audioSourceMatchesRecordingSessionRef = new AtomicReference<>();
        this.clientCalledStartRecording = new AtomicBoolean(false);
        this.nativeCalledInitRecording = new AtomicBoolean(false);
        this.nativeCalledStartRecording = new AtomicBoolean(false);
        if (z && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        }
        if (z2 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            throw new IllegalArgumentException("HW NS not supported");
        }
        this.context = context;
        this.executor = scheduledExecutorService;
        this.audioManager = audioManager;
        this.audioSource = i;
        this.audioFormat = i2;
        this.errorCallback = audioRecordErrorCallback;
        this.stateCallback = audioRecordStateCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.audioBufferCallback = audioBufferCallback;
        this.isAcousticEchoCancelerSupported = z;
        this.isNoiseSuppressorSupported = z2;
        this.expectedSampleRate = i3;
        this.expectedChannelCount = i4;
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }
}
