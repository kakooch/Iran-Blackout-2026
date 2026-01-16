package com.pedro.encoder.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.pedro.encoder.BaseEncoder;
import com.pedro.encoder.Frame;
import com.pedro.encoder.input.video.FpsLimiter;
import com.pedro.encoder.input.video.GetCameraData;
import com.pedro.encoder.utils.CodecUtil;
import com.pedro.encoder.utils.yuv.YUVUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class VideoEncoder extends BaseEncoder implements GetCameraData {
    private MediaCodec.Callback callback;
    private GetVideoData getVideoData;
    private HandlerThread handlerThread;
    private Surface inputSurface;
    private boolean spsPpsSetted = false;
    private boolean hardwareRotation = false;
    private int width = 640;
    private int height = 480;
    private int fps = 30;
    private int bitRate = 1228800;
    private int rotation = 90;
    private int iFrameInterval = 2;
    private FpsLimiter fpsLimiter = new FpsLimiter();
    private String type = MediaController.VIDEO_MIME_TYPE;
    private FormatVideoEncoder formatVideoEncoder = FormatVideoEncoder.YUV420Dynamical;
    private int avcProfile = -1;
    private int avcProfileLevel = -1;
    private BlockingQueue<Frame> queue = new ArrayBlockingQueue(80);

    public VideoEncoder(GetVideoData getVideoData) {
        this.getVideoData = getVideoData;
    }

    public boolean prepareVideoEncoder(int i, int i2, int i3, int i4, int i5, boolean z, int i6, FormatVideoEncoder formatVideoEncoder, int i7, int i8) {
        String str;
        MediaFormat mediaFormatCreateVideoFormat;
        this.width = i;
        this.height = i2;
        this.fps = i3;
        this.bitRate = i4;
        this.rotation = i5;
        this.hardwareRotation = z;
        this.formatVideoEncoder = formatVideoEncoder;
        this.avcProfile = i7;
        this.avcProfileLevel = i8;
        this.isBufferMode = true;
        MediaCodecInfo mediaCodecInfoChooseEncoder = chooseEncoder(this.type);
        try {
            if (mediaCodecInfoChooseEncoder != null) {
                this.codec = MediaCodec.createByCodecName(mediaCodecInfoChooseEncoder.getName());
                if (this.formatVideoEncoder == FormatVideoEncoder.YUV420Dynamical) {
                    FormatVideoEncoder formatVideoEncoderChooseColorDynamically = chooseColorDynamically(mediaCodecInfoChooseEncoder);
                    this.formatVideoEncoder = formatVideoEncoderChooseColorDynamically;
                    if (formatVideoEncoderChooseColorDynamically == null) {
                        Log.e("VideoEncoder", "YUV420 dynamical choose failed");
                        return false;
                    }
                }
                if (!z && (i5 == 90 || i5 == 270)) {
                    str = i2 + "x" + i;
                    mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.type, i2, i);
                } else {
                    str = i + "x" + i2;
                    mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.type, i, i2);
                }
                Log.i("VideoEncoder", "Prepare video info: " + this.formatVideoEncoder.name() + ", " + str);
                mediaFormatCreateVideoFormat.setInteger("color-format", this.formatVideoEncoder.getFormatCodec());
                mediaFormatCreateVideoFormat.setInteger("max-input-size", 0);
                mediaFormatCreateVideoFormat.setInteger("bitrate", i4);
                mediaFormatCreateVideoFormat.setInteger("frame-rate", i3);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", i6);
                if (z) {
                    mediaFormatCreateVideoFormat.setInteger("rotation-degrees", i5);
                }
                int i9 = this.avcProfile;
                if (i9 > 0 && this.avcProfileLevel > 0) {
                    mediaFormatCreateVideoFormat.setInteger("profile", i9);
                    mediaFormatCreateVideoFormat.setInteger("level", this.avcProfileLevel);
                }
                this.codec.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.running = false;
                if (formatVideoEncoder == FormatVideoEncoder.SURFACE && Build.VERSION.SDK_INT >= 18) {
                    this.isBufferMode = false;
                    this.inputSurface = this.codec.createInputSurface();
                }
                Log.i("VideoEncoder", "prepared");
                return true;
            }
            Log.e("VideoEncoder", "Valid encoder not found");
            return false;
        } catch (Exception e) {
            Log.e("VideoEncoder", "Create VideoEncoder failed.", e);
            return false;
        }
    }

    @Override // com.pedro.encoder.BaseEncoder
    public void start(boolean z) {
        this.spsPpsSetted = false;
        if (z) {
            this.presentTimeUs = System.nanoTime() / 1000;
            this.fpsLimiter.setFPS(this.fps);
        }
        if (this.formatVideoEncoder != FormatVideoEncoder.SURFACE) {
            YUVUtil.preAllocateBuffers(((this.width * this.height) * 3) / 2);
        }
        HandlerThread handlerThread = new HandlerThread("VideoEncoder");
        this.handlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.handlerThread.getLooper());
        if (Build.VERSION.SDK_INT >= 23) {
            createAsyncCallback();
            this.codec.setCallback(this.callback, handler);
            this.codec.start();
        } else {
            this.codec.start();
            handler.post(new Runnable() { // from class: com.pedro.encoder.video.VideoEncoder.1
                @Override // java.lang.Runnable
                public void run() throws MediaCodec.CryptoException {
                    while (((BaseEncoder) VideoEncoder.this).running) {
                        try {
                            VideoEncoder.this.getDataFromEncoder(null);
                        } catch (IllegalStateException e) {
                            Log.i("VideoEncoder", "Encoding error", e);
                        }
                    }
                }
            });
        }
        this.running = true;
        Log.i("VideoEncoder", "started");
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected void stopImp() {
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
        }
        this.queue.clear();
        this.spsPpsSetted = false;
        this.inputSurface = null;
        Log.i("VideoEncoder", "stopped");
    }

    public void reset() {
        stop();
        prepareVideoEncoder(this.width, this.height, this.fps, this.bitRate, this.rotation, this.hardwareRotation, this.iFrameInterval, this.formatVideoEncoder, this.avcProfile, this.avcProfileLevel);
        start(false);
    }

    private FormatVideoEncoder chooseColorDynamically(MediaCodecInfo mediaCodecInfo) {
        for (int i : mediaCodecInfo.getCapabilitiesForType(this.type).colorFormats) {
            FormatVideoEncoder formatVideoEncoder = FormatVideoEncoder.YUV420PLANAR;
            if (i == formatVideoEncoder.getFormatCodec()) {
                return formatVideoEncoder;
            }
            FormatVideoEncoder formatVideoEncoder2 = FormatVideoEncoder.YUV420SEMIPLANAR;
            if (i == formatVideoEncoder2.getFormatCodec()) {
                return formatVideoEncoder2;
            }
        }
        return null;
    }

    public void setVideoBitrateOnFly(int i) {
        if (isRunning()) {
            this.bitRate = i;
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i);
            try {
                this.codec.setParameters(bundle);
            } catch (IllegalStateException e) {
                Log.e("VideoEncoder", "encoder need be running", e);
            }
        }
    }

    public Surface getInputSurface() {
        return this.inputSurface;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRotation() {
        return this.rotation;
    }

    public int getFps() {
        return this.fps;
    }

    public int getBitRate() {
        return this.bitRate;
    }

    @Override // com.pedro.encoder.input.video.GetCameraData
    public void inputYUVData(Frame frame) {
        if (!this.running || this.queue.offer(frame)) {
            return;
        }
        Log.i("VideoEncoder", "frame discarded");
    }

    private void sendSPSandPPS(MediaFormat mediaFormat) {
        if (this.type.equals("video/hevc")) {
            List<ByteBuffer> listExtractVpsSpsPpsFromH265 = extractVpsSpsPpsFromH265(mediaFormat.getByteBuffer("csd-0"));
            this.getVideoData.onSpsPpsVps(listExtractVpsSpsPpsFromH265.get(1), listExtractVpsSpsPpsFromH265.get(2), listExtractVpsSpsPpsFromH265.get(0));
        } else {
            this.getVideoData.onSpsPps(mediaFormat.getByteBuffer("csd-0"), mediaFormat.getByteBuffer("csd-1"));
        }
    }

    protected MediaCodecInfo chooseEncoder(String str) {
        List<MediaCodecInfo> allEncoders;
        CodecUtil.Force force = this.force;
        if (force == CodecUtil.Force.HARDWARE) {
            allEncoders = CodecUtil.getAllHardwareEncoders(str);
        } else if (force == CodecUtil.Force.SOFTWARE) {
            allEncoders = CodecUtil.getAllSoftwareEncoders(str);
        } else {
            allEncoders = CodecUtil.getAllEncoders(str);
        }
        for (MediaCodecInfo mediaCodecInfo : allEncoders) {
            Log.i("VideoEncoder", String.format("VideoEncoder %s", mediaCodecInfo.getName()));
            for (int i : mediaCodecInfo.getCapabilitiesForType(str).colorFormats) {
                Log.i("VideoEncoder", "Color supported: " + i);
                FormatVideoEncoder formatVideoEncoder = this.formatVideoEncoder;
                FormatVideoEncoder formatVideoEncoder2 = FormatVideoEncoder.SURFACE;
                if (formatVideoEncoder == formatVideoEncoder2) {
                    if (i == formatVideoEncoder2.getFormatCodec()) {
                        return mediaCodecInfo;
                    }
                } else if (i == FormatVideoEncoder.YUV420PLANAR.getFormatCodec() || i == FormatVideoEncoder.YUV420SEMIPLANAR.getFormatCodec()) {
                    return mediaCodecInfo;
                }
            }
        }
        return null;
    }

    private Pair<ByteBuffer, ByteBuffer> decodeSpsPpsFromBuffer(ByteBuffer byteBuffer, int i) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = new byte[i];
        byteBuffer.get(bArr3, 0, i);
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= i - 4) {
                i2 = -1;
                break;
            }
            if (bArr3[i2] == 0 && bArr3[i2 + 1] == 0 && bArr3[i2 + 2] == 0 && bArr3[i2 + 3] == 1) {
                if (i3 != -1) {
                    break;
                }
                i3 = i2;
            }
            i2++;
        }
        if (i3 == -1 || i2 == -1) {
            bArr = null;
            bArr2 = null;
        } else {
            bArr = new byte[i2];
            System.arraycopy(bArr3, i3, bArr, 0, i2);
            int i4 = i - i2;
            bArr2 = new byte[i4];
            System.arraycopy(bArr3, i2, bArr2, 0, i4);
        }
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return new Pair<>(ByteBuffer.wrap(bArr), ByteBuffer.wrap(bArr2));
    }

    private List<ByteBuffer> extractVpsSpsPpsFromH265(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        byte[] bArrArray = byteBuffer.array();
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        for (int i5 = 0; i5 < bArrArray.length; i5++) {
            if (i3 == 3 && bArrArray[i5] == 1) {
                if (i4 == -1) {
                    i4 = i5 - 3;
                } else if (i == -1) {
                    i = i5 - 3;
                } else {
                    i2 = i5 - 3;
                }
            }
            i3 = bArrArray[i5] == 0 ? i3 + 1 : 0;
        }
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i2 - i];
        byte[] bArr3 = new byte[bArrArray.length - i2];
        for (int i6 = 0; i6 < bArrArray.length; i6++) {
            if (i6 < i) {
                bArr[i6] = bArrArray[i6];
            } else if (i6 < i2) {
                bArr2[i6 - i] = bArrArray[i6];
            } else {
                bArr3[i6 - i2] = bArrArray[i6];
            }
        }
        arrayList.add(ByteBuffer.wrap(bArr));
        arrayList.add(ByteBuffer.wrap(bArr2));
        arrayList.add(ByteBuffer.wrap(bArr3));
        return arrayList;
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected Frame getInputFrame() throws InterruptedException {
        byte[] bArrNV21toYUV420byColor;
        Frame frameTake = this.queue.take();
        if (this.fpsLimiter.limitFPS()) {
            return getInputFrame();
        }
        byte[] buffer = frameTake.getBuffer();
        boolean z = frameTake.getFormat() == 842094169;
        if (!this.hardwareRotation) {
            int orientation = frameTake.isFlip() ? frameTake.getOrientation() + 180 : frameTake.getOrientation();
            if (orientation >= 360) {
                orientation -= 360;
            }
            if (z) {
                buffer = YUVUtil.rotateYV12(buffer, this.width, this.height, orientation);
            } else {
                buffer = YUVUtil.rotateNV21(buffer, this.width, this.height, orientation);
            }
        }
        if (z) {
            bArrNV21toYUV420byColor = YUVUtil.YV12toYUV420byColor(buffer, this.width, this.height, this.formatVideoEncoder);
        } else {
            bArrNV21toYUV420byColor = YUVUtil.NV21toYUV420byColor(buffer, this.width, this.height, this.formatVideoEncoder);
        }
        frameTake.setBuffer(bArrNV21toYUV420byColor);
        return frameTake;
    }

    @Override // com.pedro.encoder.EncoderCallback
    public void formatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.getVideoData.onVideoFormat(mediaFormat);
        sendSPSandPPS(mediaFormat);
        this.spsPpsSetted = true;
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected void checkBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Pair<ByteBuffer, ByteBuffer> pairDecodeSpsPpsFromBuffer;
        if ((bufferInfo.flags & 2) == 0 || this.spsPpsSetted || (pairDecodeSpsPpsFromBuffer = decodeSpsPpsFromBuffer(byteBuffer.duplicate(), bufferInfo.size)) == null) {
            return;
        }
        this.getVideoData.onSpsPps((ByteBuffer) pairDecodeSpsPpsFromBuffer.first, (ByteBuffer) pairDecodeSpsPpsFromBuffer.second);
        this.spsPpsSetted = true;
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected void sendBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        bufferInfo.presentationTimeUs = (System.nanoTime() / 1000) - this.presentTimeUs;
        this.getVideoData.getVideoData(byteBuffer, bufferInfo);
    }

    private void createAsyncCallback() {
        this.callback = new MediaCodec.Callback() { // from class: com.pedro.encoder.video.VideoEncoder.2
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec mediaCodec, int i) throws MediaCodec.CryptoException {
                try {
                    VideoEncoder.this.inputAvailable(mediaCodec, i, null);
                } catch (IllegalStateException e) {
                    Log.i("VideoEncoder", "Encoding error", e);
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
                try {
                    VideoEncoder.this.outputAvailable(mediaCodec, i, bufferInfo);
                } catch (IllegalStateException e) {
                    Log.i("VideoEncoder", "Encoding error", e);
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                Log.e("VideoEncoder", "Error", codecException);
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                VideoEncoder.this.formatChanged(mediaCodec, mediaFormat);
            }
        };
    }
}
