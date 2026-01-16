package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import ir.eitaa.messenger.FileLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.webrtc.EglBase;
import org.webrtc.EncodedImage;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* loaded from: classes3.dex */
class AndroidVideoDecoder implements VideoDecoder, VideoSink {
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "AndroidVideoDecoder";
    private VideoDecoder.Callback callback;
    private MediaCodecWrapper codec;
    private final String codecName;
    private final VideoCodecMimeType codecType;
    private int colorFormat;
    private ThreadUtils.ThreadChecker decoderThreadChecker;
    private final BlockingDeque<FrameInfo> frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean keyFrameRequired;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private Thread outputThread;
    private ThreadUtils.ThreadChecker outputThreadChecker;
    private DecodedTextureMetadata renderedTextureMetadata;
    private volatile boolean running;
    private final EglBase.Context sharedContext;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;
    private Surface surface;
    private SurfaceTextureHelper surfaceTextureHelper;
    private int width;
    private final Object dimensionLock = new Object();
    private final Object renderedTextureMetadataLock = new Object();

    @Override // org.webrtc.VideoDecoder
    public /* synthetic */ long createNativeVideoDecoder() {
        return VideoDecoder.CC.$default$createNativeVideoDecoder(this);
    }

    @Override // org.webrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    @Override // org.webrtc.VideoSink
    public /* synthetic */ void setParentSink(VideoSink videoSink) {
        VideoSink.CC.$default$setParentSink(this, videoSink);
    }

    private static class FrameInfo {
        final long decodeStartTimeMs;
        final int rotation;

        FrameInfo(long decodeStartTimeMs, int rotation) {
            this.decodeStartTimeMs = decodeStartTimeMs;
            this.rotation = rotation;
        }
    }

    private static class DecodedTextureMetadata {
        final Integer decodeTimeMs;
        final long presentationTimestampUs;

        DecodedTextureMetadata(long presentationTimestampUs, Integer decodeTimeMs) {
            this.presentationTimestampUs = presentationTimestampUs;
            this.decodeTimeMs = decodeTimeMs;
        }
    }

    AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String codecName, VideoCodecMimeType codecType, int colorFormat, EglBase.Context sharedContext) {
        if (!isSupportedColorFormat(colorFormat)) {
            throw new IllegalArgumentException("Unsupported color format: " + colorFormat);
        }
        Logging.d(TAG, "ctor name: " + codecName + " type: " + codecType + " color format: " + colorFormat + " context: " + sharedContext);
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = codecName;
        this.codecType = codecType;
        this.colorFormat = colorFormat;
        this.sharedContext = sharedContext;
        this.frameInfos = new LinkedBlockingDeque();
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        this.decoderThreadChecker = new ThreadUtils.ThreadChecker();
        this.callback = callback;
        if (this.sharedContext != null) {
            this.surfaceTextureHelper = createSurfaceTextureHelper();
            this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
            this.surfaceTextureHelper.startListening(this);
        }
        return initDecodeInternal(settings.width, settings.height);
    }

    private VideoCodecStatus initDecodeInternal(int width, int height) {
        this.decoderThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + width + " height: " + height);
        if (this.outputThread != null) {
            Logging.e(TAG, "initDecodeInternal called while the codec is already running");
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = width;
        this.height = height;
        this.stride = width;
        this.sliceHeight = height;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), width, height);
                if (this.sharedContext == null) {
                    mediaFormatCreateVideoFormat.setInteger("color-format", this.colorFormat);
                }
                this.codec.configure(mediaFormatCreateVideoFormat, this.surface, null, 0);
                this.codec.start();
                this.running = true;
                Thread threadCreateOutputThread = createOutputThread();
                this.outputThread = threadCreateOutputThread;
                threadCreateOutputThread.start();
                Logging.d(TAG, "initDecodeInternal done");
                return VideoCodecStatus.OK;
            } catch (IllegalArgumentException | IllegalStateException e) {
                Logging.e(TAG, "initDecode failed", e);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (IOException | IllegalArgumentException | IllegalStateException unused) {
            Logging.e(TAG, "Cannot create media decoder " + this.codecName);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage frame, VideoDecoder.DecodeInfo info) {
        int i;
        int i2;
        VideoCodecStatus videoCodecStatusReinitDecode;
        this.decoderThreadChecker.checkIsOnValidThread();
        if (this.codec == null || this.callback == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("decode uninitalized, codec: ");
            sb.append(this.codec != null);
            sb.append(", callback: ");
            sb.append(this.callback);
            Logging.d(TAG, sb.toString());
            return VideoCodecStatus.UNINITIALIZED;
        }
        ByteBuffer byteBuffer = frame.buffer;
        if (byteBuffer == null) {
            Logging.e(TAG, "decode() - no input data");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            Logging.e(TAG, "decode() - input buffer empty");
            return VideoCodecStatus.ERR_PARAMETER;
        }
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
        }
        int i3 = frame.encodedWidth;
        int i4 = frame.encodedHeight;
        if (i3 * i4 > 0 && ((i3 != i || i4 != i2) && (videoCodecStatusReinitDecode = reinitDecode(i3, i4)) != VideoCodecStatus.OK)) {
            return videoCodecStatusReinitDecode;
        }
        if (this.keyFrameRequired && frame.frameType != EncodedImage.FrameType.VideoFrameKey) {
            Logging.e(TAG, "decode() - key frame required first");
            return VideoCodecStatus.NO_OUTPUT;
        }
        try {
            int iDequeueInputBuffer = this.codec.dequeueInputBuffer(500000L);
            if (iDequeueInputBuffer < 0) {
                Logging.e(TAG, "decode() - no HW buffers available; decoder falling behind");
                return VideoCodecStatus.ERROR;
            }
            try {
                ByteBuffer byteBuffer2 = this.codec.getInputBuffers()[iDequeueInputBuffer];
                if (byteBuffer2.capacity() < iRemaining) {
                    Logging.e(TAG, "decode() - HW buffer too small");
                    return VideoCodecStatus.ERROR;
                }
                byteBuffer2.put(frame.buffer);
                this.frameInfos.offer(new FrameInfo(SystemClock.elapsedRealtime(), frame.rotation));
                try {
                    this.codec.queueInputBuffer(iDequeueInputBuffer, 0, iRemaining, TimeUnit.NANOSECONDS.toMicros(frame.captureTimeNs), 0);
                    if (this.keyFrameRequired) {
                        this.keyFrameRequired = false;
                    }
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "queueInputBuffer failed", e);
                    this.frameInfos.pollLast();
                    return VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "getInputBuffers failed", e2);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e3) {
            Logging.e(TAG, "dequeueInputBuffer failed", e3);
            return VideoCodecStatus.ERROR;
        }
    }

    @Override // org.webrtc.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // org.webrtc.VideoDecoder
    public VideoCodecStatus release() {
        Logging.d(TAG, "release");
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        if (this.surface != null) {
            releaseSurface();
            this.surface = null;
            this.surfaceTextureHelper.stopListening();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        synchronized (this.renderedTextureMetadataLock) {
            this.renderedTextureMetadata = null;
        }
        this.callback = null;
        this.frameInfos.clear();
        return videoCodecStatusReleaseInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VideoCodecStatus releaseInternal() {
        if (!this.running) {
            Logging.d(TAG, "release: Decoder is not running.");
            return VideoCodecStatus.OK;
        }
        try {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 5000L)) {
                Logging.e(TAG, "Media decoder release timeout", new RuntimeException());
                return VideoCodecStatus.TIMEOUT;
            }
            if (this.shutdownException != null) {
                Logging.e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
                this.shutdownException = null;
                return VideoCodecStatus.ERROR;
            }
            this.codec = null;
            this.outputThread = null;
            return VideoCodecStatus.OK;
        } finally {
            this.codec = null;
            this.outputThread = null;
        }
    }

    private VideoCodecStatus reinitDecode(int newWidth, int newHeight) {
        this.decoderThreadChecker.checkIsOnValidThread();
        VideoCodecStatus videoCodecStatusReleaseInternal = releaseInternal();
        return videoCodecStatusReleaseInternal != VideoCodecStatus.OK ? videoCodecStatusReleaseInternal : initDecodeInternal(newWidth, newHeight);
    }

    private Thread createOutputThread() {
        return new Thread("AndroidVideoDecoder.outputThread") { // from class: org.webrtc.AndroidVideoDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                AndroidVideoDecoder.this.outputThreadChecker = new ThreadUtils.ThreadChecker();
                while (AndroidVideoDecoder.this.running) {
                    AndroidVideoDecoder.this.deliverDecodedFrame();
                }
                AndroidVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    protected void deliverDecodedFrame() {
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 100000L);
            if (iDequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
                return;
            }
            if (iDequeueOutputBuffer < 0) {
                Logging.v(TAG, "dequeueOutputBuffer returned " + iDequeueOutputBuffer);
                return;
            }
            FrameInfo frameInfoPoll = this.frameInfos.poll();
            Integer numValueOf = null;
            int i = 0;
            if (frameInfoPoll != null) {
                numValueOf = Integer.valueOf((int) (SystemClock.elapsedRealtime() - frameInfoPoll.decodeStartTimeMs));
                i = frameInfoPoll.rotation;
            }
            this.hasDecodedFirstFrame = true;
            if (this.surfaceTextureHelper != null) {
                deliverTextureFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            } else {
                deliverByteFrame(iDequeueOutputBuffer, bufferInfo, i, numValueOf);
            }
        } catch (IllegalStateException e) {
            Logging.e(TAG, "deliverDecodedFrame failed", e);
        }
    }

    private void deliverTextureFrame(final int index, final MediaCodec.BufferInfo info, final int rotation, final Integer decodeTimeMs) {
        int i;
        int i2;
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
        }
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata != null) {
                this.codec.releaseOutputBuffer(index, false);
                return;
            }
            this.surfaceTextureHelper.setTextureSize(i, i2);
            this.surfaceTextureHelper.setFrameRotation(rotation);
            this.renderedTextureMetadata = new DecodedTextureMetadata(info.presentationTimeUs, decodeTimeMs);
            this.codec.releaseOutputBuffer(index, true);
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame frame) {
        long j;
        Integer num;
        synchronized (this.renderedTextureMetadataLock) {
            DecodedTextureMetadata decodedTextureMetadata = this.renderedTextureMetadata;
            if (decodedTextureMetadata == null) {
                throw new IllegalStateException("Rendered texture metadata was null in onTextureFrameAvailable.");
            }
            j = decodedTextureMetadata.presentationTimestampUs * 1000;
            num = decodedTextureMetadata.decodeTimeMs;
            this.renderedTextureMetadata = null;
        }
        this.callback.onDecodedFrame(new VideoFrame(frame.getBuffer(), frame.getRotation(), j), num, null);
    }

    private void deliverByteFrame(int result, MediaCodec.BufferInfo info, int rotation, Integer decodeTimeMs) {
        int i;
        int i2;
        int i3;
        int i4;
        VideoFrame.Buffer bufferCopyNV12ToI420Buffer;
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
            i3 = this.stride;
            i4 = this.sliceHeight;
        }
        int i5 = info.size;
        if (i5 < ((i * i2) * 3) / 2) {
            Logging.e(TAG, "Insufficient output buffer size: " + info.size);
            return;
        }
        int i6 = (i5 >= ((i3 * i2) * 3) / 2 || i4 != i2 || i3 <= i) ? i3 : (i5 * 2) / (i2 * 3);
        ByteBuffer byteBuffer = this.codec.getOutputBuffers()[result];
        byteBuffer.position(info.offset);
        byteBuffer.limit(info.offset + info.size);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        if (this.colorFormat == 19) {
            bufferCopyNV12ToI420Buffer = copyI420Buffer(byteBufferSlice, i6, i4, i, i2);
        } else {
            bufferCopyNV12ToI420Buffer = copyNV12ToI420Buffer(byteBufferSlice, i6, i4, i, i2);
        }
        this.codec.releaseOutputBuffer(result, false);
        VideoFrame videoFrame = new VideoFrame(bufferCopyNV12ToI420Buffer, rotation, info.presentationTimeUs * 1000);
        this.callback.onDecodedFrame(videoFrame, decodeTimeMs, null);
        videoFrame.release();
    }

    private VideoFrame.Buffer copyNV12ToI420Buffer(ByteBuffer buffer, int stride, int sliceHeight, int width, int height) {
        return new NV12Buffer(width, height, stride, sliceHeight, buffer, null).toI420();
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer buffer, int stride, int sliceHeight, int width, int height) {
        if (stride % 2 != 0) {
            throw new AssertionError("Stride is not divisible by two: " + stride);
        }
        int i = (width + 1) / 2;
        int i2 = sliceHeight % 2 == 0 ? (height + 1) / 2 : height / 2;
        int i3 = stride / 2;
        int i4 = (stride * height) + 0;
        int i5 = (stride * sliceHeight) + 0;
        int i6 = i3 * i2;
        int i7 = i5 + i6;
        int i8 = i5 + ((i3 * sliceHeight) / 2);
        int i9 = i8 + i6;
        VideoFrame.I420Buffer i420BufferAllocateI420Buffer = allocateI420Buffer(width, height);
        try {
            buffer.limit(i4);
            buffer.position(0);
            copyPlane(buffer.slice(), stride, i420BufferAllocateI420Buffer.getDataY(), i420BufferAllocateI420Buffer.getStrideY(), width, height);
            buffer.limit(i7);
            buffer.position(i5);
            copyPlane(buffer.slice(), i3, i420BufferAllocateI420Buffer.getDataU(), i420BufferAllocateI420Buffer.getStrideU(), i, i2);
            if (sliceHeight % 2 == 1) {
                buffer.position(i5 + ((i2 - 1) * i3));
                ByteBuffer dataU = i420BufferAllocateI420Buffer.getDataU();
                dataU.position(i420BufferAllocateI420Buffer.getStrideU() * i2);
                dataU.put(buffer);
            }
            buffer.limit(i9);
            buffer.position(i8);
            copyPlane(buffer.slice(), i3, i420BufferAllocateI420Buffer.getDataV(), i420BufferAllocateI420Buffer.getStrideV(), i, i2);
            if (sliceHeight % 2 == 1) {
                buffer.position(i8 + (i3 * (i2 - 1)));
                ByteBuffer dataV = i420BufferAllocateI420Buffer.getDataV();
                dataV.position(i420BufferAllocateI420Buffer.getStrideV() * i2);
                dataV.put(buffer);
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
        return i420BufferAllocateI420Buffer;
    }

    private void reformat(MediaFormat format) {
        int integer;
        int integer2;
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Decoder format changed: " + format.toString());
        if (format.containsKey(MEDIA_FORMAT_KEY_CROP_LEFT) && format.containsKey(MEDIA_FORMAT_KEY_CROP_RIGHT) && format.containsKey(MEDIA_FORMAT_KEY_CROP_BOTTOM) && format.containsKey(MEDIA_FORMAT_KEY_CROP_TOP)) {
            integer = (format.getInteger(MEDIA_FORMAT_KEY_CROP_RIGHT) + 1) - format.getInteger(MEDIA_FORMAT_KEY_CROP_LEFT);
            integer2 = (format.getInteger(MEDIA_FORMAT_KEY_CROP_BOTTOM) + 1) - format.getInteger(MEDIA_FORMAT_KEY_CROP_TOP);
        } else {
            integer = format.getInteger("width");
            integer2 = format.getInteger("height");
        }
        synchronized (this.dimensionLock) {
            if (integer != this.width || integer2 != this.height) {
                if (this.hasDecodedFirstFrame) {
                    stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2));
                    return;
                }
                if (integer > 0 && integer2 > 0) {
                    this.width = integer;
                    this.height = integer2;
                }
                Logging.w(TAG, "Unexpected format dimensions. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2 + ". Skip it");
                return;
            }
            if (this.surfaceTextureHelper == null && format.containsKey("color-format")) {
                this.colorFormat = format.getInteger("color-format");
                Logging.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                if (!isSupportedColorFormat(this.colorFormat)) {
                    stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
                    return;
                }
            }
            synchronized (this.dimensionLock) {
                if (format.containsKey(MEDIA_FORMAT_KEY_STRIDE)) {
                    this.stride = format.getInteger(MEDIA_FORMAT_KEY_STRIDE);
                }
                if (format.containsKey(MEDIA_FORMAT_KEY_SLICE_HEIGHT)) {
                    this.sliceHeight = format.getInteger(MEDIA_FORMAT_KEY_SLICE_HEIGHT);
                }
                Logging.d(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                this.sliceHeight = Math.max(this.height, this.sliceHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        this.outputThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e) {
            Logging.e(TAG, "Media decoder stop failed", e);
        }
        try {
            this.codec.release();
        } catch (Exception e2) {
            Logging.e(TAG, "Media decoder release failed", e2);
            this.shutdownException = e2;
        }
        Logging.d(TAG, "Release on output thread done");
    }

    private void stopOnOutputThread(Exception e) {
        this.outputThreadChecker.checkIsOnValidThread();
        this.running = false;
        this.shutdownException = e;
    }

    private boolean isSupportedColorFormat(int colorFormat) {
        for (int i : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i == colorFormat) {
                return true;
            }
        }
        return false;
    }

    protected SurfaceTextureHelper createSurfaceTextureHelper() {
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    protected void releaseSurface() {
        this.surface.release();
    }

    protected VideoFrame.I420Buffer allocateI420Buffer(int width, int height) {
        return JavaI420Buffer.allocate(width, height);
    }

    protected void copyPlane(ByteBuffer src, int srcStride, ByteBuffer dst, int dstStride, int width, int height) {
        YuvHelper.copyPlane(src, srcStride, dst, dstStride, width, height);
    }
}
