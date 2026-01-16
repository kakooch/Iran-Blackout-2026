package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Process;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

/* loaded from: classes.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int DEFAULT_AUDIO_SOURCE;
    public static WebRtcAudioRecord Instance = null;
    private static final String TAG = "WebRtcAudioRecord";
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int audioSource;
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private int captureType;
    private AudioRecord deviceAudioRecord;
    private ByteBuffer deviceByteBuffer;
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;
    private int requestedSampleRate = 48000;
    private int requestedChannels = 1;

    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String errorMessage);

        void onWebRtcAudioRecordInitError(String errorMessage);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode errorCode, String errorMessage);
    }

    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples samples);
    }

    private int channelCountToConfiguration(int channels) {
        return channels == 1 ? 16 : 12;
    }

    private static int getDefaultAudioSource() {
        return 7;
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long nativeAudioRecord);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int bytes, long nativeAudioRecord);

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback errorCallback2) {
        Logging.d(TAG, "Set error callback");
        errorCallback = errorCallback2;
    }

    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        private AudioSamples(AudioRecord audioRecord, byte[] data) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = data;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback callback) {
        audioSamplesReadyCallback = callback;
    }

    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String name) {
            super(name);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            System.nanoTime();
            while (this.keepAlive) {
                int i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                int i2 = WebRtcAudioRecord.this.deviceAudioRecord != null ? WebRtcAudioRecord.this.deviceAudioRecord.read(WebRtcAudioRecord.this.deviceByteBuffer, WebRtcAudioRecord.this.deviceByteBuffer.capacity()) : 0;
                if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    if (i == i2) {
                        WebRtcAudioRecord.this.deviceByteBuffer.position(0);
                        WebRtcAudioRecord.this.byteBuffer.position(0);
                        for (int i3 = 0; i3 < i / 2; i3++) {
                            int i4 = i3 * 2;
                            int i5 = WebRtcAudioRecord.this.byteBuffer.getShort(i4) + (WebRtcAudioRecord.this.deviceByteBuffer.getShort(i4) / 10);
                            if (i5 > 32767) {
                                i5 = 32767;
                            }
                            if (i5 < -32768) {
                                i5 = -32768;
                            }
                            WebRtcAudioRecord.this.byteBuffer.putShort(i4, (short) i5);
                        }
                    }
                    if (this.keepAlive) {
                        WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                        webRtcAudioRecord.nativeDataIsRecorded(i, webRtcAudioRecord.nativeAudioRecord);
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity())));
                    }
                } else {
                    String str = "AudioRecord.read failed: " + i;
                    Logging.e(WebRtcAudioRecord.TAG, str);
                    if (i == -3) {
                        this.keepAlive = false;
                        WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                    }
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (IllegalStateException e) {
                Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e.getMessage());
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    WebRtcAudioRecord(long nativeAudioRecord, int type) {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = nativeAudioRecord;
        this.effects = WebRtcAudioEffects.create();
        this.captureType = type;
        if (type == 2 && Instance == null) {
            Instance = this;
        }
    }

    private void onDestroy() {
        stopDeviceAudioRecord();
        if (Instance == this) {
            Instance = null;
        }
    }

    private boolean enableBuiltInAEC(boolean enable) {
        Logging.d(TAG, "enableBuiltInAEC(" + enable + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            Logging.e(TAG, "Built-in AEC is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setAEC(enable);
    }

    private boolean enableBuiltInNS(boolean enable) {
        Logging.d(TAG, "enableBuiltInNS(" + enable + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            Logging.e(TAG, "Built-in NS is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setNS(enable);
    }

    private int initRecording(int sampleRate, int channels) {
        WebRtcAudioEffects webRtcAudioEffects;
        if (this.captureType == 1 && Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        this.requestedSampleRate = sampleRate;
        this.requestedChannels = channels;
        Logging.d(TAG, "initRecording(sampleRate=" + sampleRate + ", channels=" + channels + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i = sampleRate / 100;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(channels * 2 * i);
        this.byteBuffer = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int iChannelCountToConfiguration = channelCountToConfiguration(channels);
        int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, iChannelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.d(TAG, "bufferSizeInBytes: " + iMax);
        if (this.captureType == 1) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    MediaProjection mediaProjection = VideoCapturerDevice.getMediaProjection();
                    if (mediaProjection == null) {
                        return -1;
                    }
                    AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
                    builder.addMatchingUsage(1);
                    builder.addMatchingUsage(14);
                    builder.addMatchingUsage(0);
                    AudioRecord.Builder builder2 = new AudioRecord.Builder();
                    builder2.setAudioPlaybackCaptureConfig(builder.build());
                    builder2.setAudioFormat(new AudioFormat.Builder().setChannelMask(iChannelCountToConfiguration).setSampleRate(sampleRate).setEncoding(2).build());
                    builder2.setBufferSizeInBytes(iMax);
                    this.audioRecord = builder2.build();
                } catch (Throwable th) {
                    reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + th.getMessage());
                    releaseAudioResources(false);
                    return -1;
                }
            }
        } else {
            try {
                this.audioRecord = new AudioRecord(audioSource, sampleRate, iChannelCountToConfiguration, 2, iMax);
            } catch (IllegalArgumentException e) {
                reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e.getMessage());
                releaseAudioResources(false);
                return -1;
            }
        }
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null || audioRecord.getState() != 1) {
            reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
            releaseAudioResources(false);
            return -1;
        }
        if (this.captureType == 0 && (webRtcAudioEffects = this.effects) != null) {
            webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
        }
        logMainParameters();
        logMainParametersExtended();
        return i;
    }

    @TargetApi(29)
    public void initDeviceAudioRecord(MediaProjection mediaProjection) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.requestedChannels * 2 * (this.requestedSampleRate / 100));
        this.deviceByteBuffer = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        int iChannelCountToConfiguration = channelCountToConfiguration(this.requestedChannels);
        int minBufferSize = AudioRecord.getMinBufferSize(this.requestedSampleRate, iChannelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            return;
        }
        int iMax = Math.max(minBufferSize * 2, this.deviceByteBuffer.capacity());
        try {
            AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
            builder.addMatchingUsage(1);
            builder.addMatchingUsage(14);
            AudioRecord.Builder builder2 = new AudioRecord.Builder();
            builder2.setAudioPlaybackCaptureConfig(builder.build());
            builder2.setAudioFormat(new AudioFormat.Builder().setChannelMask(iChannelCountToConfiguration).setSampleRate(this.requestedSampleRate).setEncoding(2).build());
            builder2.setBufferSizeInBytes(iMax);
            AudioRecord audioRecordBuild = builder2.build();
            this.deviceAudioRecord = audioRecordBuild;
            if (audioRecordBuild == null || audioRecordBuild.getState() != 1) {
                reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                releaseAudioResources(true);
                return;
            }
            try {
                this.deviceAudioRecord.startRecording();
                if (this.deviceAudioRecord.getRecordingState() != 3) {
                    reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.deviceAudioRecord.getRecordingState());
                }
            } catch (IllegalStateException e) {
                reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
            }
        } catch (Throwable th) {
            reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + th.getMessage());
            releaseAudioResources(true);
        }
    }

    @TargetApi(29)
    public void stopDeviceAudioRecord() {
        AudioRecord audioRecord = this.deviceAudioRecord;
        if (audioRecord == null) {
            return;
        }
        try {
            audioRecord.stop();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        releaseAudioResources(true);
    }

    private boolean startRecording() throws IllegalStateException {
        Logging.d(TAG, "startRecording");
        assertTrue(this.audioRecord != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() != 3) {
                reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                return false;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            return true;
        } catch (IllegalStateException e) {
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
            return false;
        }
    }

    private boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        this.audioThread = null;
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        try {
            this.audioRecord.stop();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        releaseAudioResources(false);
        return true;
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
    }

    private void logMainParametersExtended() {
        if (Build.VERSION.SDK_INT >= 23) {
            Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static synchronized void setAudioSource(int source) {
        Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + source);
        audioSource = source;
    }

    public static void setMicrophoneMute(boolean mute) {
        Logging.w(TAG, "setMicrophoneMute(" + mute + ")");
        microphoneMute = mute;
    }

    private void releaseAudioResources(boolean device) {
        Logging.d(TAG, "releaseAudioResources " + device);
        if (device) {
            AudioRecord audioRecord = this.deviceAudioRecord;
            if (audioRecord != null) {
                audioRecord.release();
                this.deviceAudioRecord = null;
                return;
            }
            return;
        }
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
    }

    private void reportWebRtcAudioRecordInitError(String errorMessage) {
        Logging.e(TAG, "Init recording error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(errorMessage);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode errorCode, String errorMessage) {
        Logging.e(TAG, "Start recording error: " + errorCode + ". " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(errorCode, errorMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String errorMessage) {
        Logging.e(TAG, "Run-time recording error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(errorMessage);
        }
    }
}
