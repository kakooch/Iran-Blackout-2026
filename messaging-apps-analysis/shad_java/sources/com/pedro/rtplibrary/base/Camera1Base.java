package com.pedro.rtplibrary.base;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceView;
import com.pedro.encoder.Frame;
import com.pedro.encoder.audio.AudioEncoder;
import com.pedro.encoder.audio.GetAacData;
import com.pedro.encoder.input.audio.GetMicrophoneData;
import com.pedro.encoder.input.audio.MicrophoneManager;
import com.pedro.encoder.input.video.Camera1ApiManager;
import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.encoder.input.video.CameraOpenException;
import com.pedro.encoder.input.video.GetCameraData;
import com.pedro.encoder.video.GetVideoData;
import com.pedro.encoder.video.VideoEncoder;
import com.pedro.rtplibrary.util.FpsListener;
import com.pedro.rtplibrary.util.RecordController;
import com.pedro.rtplibrary.view.GlInterface;
import com.pedro.rtplibrary.view.OffScreenGlThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes3.dex */
public abstract class Camera1Base implements GetAacData, GetCameraData, GetVideoData, GetMicrophoneData {
    private AudioEncoder audioEncoder;
    private Camera1ApiManager cameraManager;
    private Context context;
    private GlInterface glInterface;
    private MicrophoneManager microphoneManager;
    private int previewHeight;
    private int previewWidth;
    private RecordController recordController;
    protected VideoEncoder videoEncoder;
    private boolean streaming = false;
    private boolean onPreview = false;
    private FpsListener fpsListener = new FpsListener();

    protected abstract void getAacDataRtp(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    protected abstract void getH264DataRtp(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    protected abstract void onSpsPpsVpsRtp(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3);

    protected abstract void prepareAudioRtp(boolean z, int i);

    protected abstract void reConnect(long j);

    @Deprecated
    public abstract boolean shouldRetry(String str);

    protected abstract void startStreamRtp(String str);

    protected abstract void stopStreamRtp();

    public Camera1Base(SurfaceView surfaceView) {
        this.context = surfaceView.getContext();
        this.cameraManager = new Camera1ApiManager(surfaceView, this);
        init();
    }

    private void init() {
        this.videoEncoder = new VideoEncoder(this);
        this.microphoneManager = new MicrophoneManager(this);
        this.audioEncoder = new AudioEncoder(this);
        this.recordController = new RecordController();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean prepareVideo(int r14, int r15, int r16, int r17, boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r13 = this;
            r0 = r13
            boolean r1 = r0.onPreview
            if (r1 == 0) goto Ld
            int r1 = r0.previewWidth
            r3 = r14
            if (r3 != r1) goto Lb
            goto Le
        Lb:
            r4 = r15
            goto L13
        Ld:
            r3 = r14
        Le:
            int r1 = r0.previewHeight
            r4 = r15
            if (r4 == r1) goto L19
        L13:
            r13.stopPreview()
            r1 = 1
            r0.onPreview = r1
        L19:
            com.pedro.rtplibrary.view.GlInterface r1 = r0.glInterface
            if (r1 != 0) goto L20
            com.pedro.encoder.video.FormatVideoEncoder r1 = com.pedro.encoder.video.FormatVideoEncoder.YUV420Dynamical
            goto L22
        L20:
            com.pedro.encoder.video.FormatVideoEncoder r1 = com.pedro.encoder.video.FormatVideoEncoder.SURFACE
        L22:
            r10 = r1
            com.pedro.encoder.video.VideoEncoder r2 = r0.videoEncoder
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r20
            r8 = r18
            r9 = r19
            r11 = r21
            r12 = r22
            boolean r1 = r2.prepareVideoEncoder(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pedro.rtplibrary.base.Camera1Base.prepareVideo(int, int, int, int, boolean, int, int, int, int):boolean");
    }

    public boolean prepareVideo(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        return prepareVideo(i, i2, i3, i4, z, i5, i6, -1, -1);
    }

    public boolean prepareVideo(int i, int i2, int i3, int i4, boolean z, int i5) {
        return prepareVideo(i, i2, i3, i4, z, 2, i5);
    }

    public boolean prepareAudio(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.microphoneManager.createMicrophone(i2, z, z2, z3);
        prepareAudioRtp(z, i2);
        return this.audioEncoder.prepareAudioEncoder(i, i2, z, this.microphoneManager.getMaxInputSize());
    }

    public boolean prepareAudio() {
        return prepareAudio(MessagesController.UPDATE_MASK_CHECK, 32000, true, false, false);
    }

    public void startPreview(CameraHelper.Facing facing, int i, int i2, int i3) throws IOException {
        if (!isStreaming() && !this.onPreview) {
            GlInterface glInterface = this.glInterface;
            if (!(glInterface instanceof OffScreenGlThread)) {
                this.previewWidth = i;
                this.previewHeight = i2;
                if (glInterface != null && Build.VERSION.SDK_INT >= 18) {
                    if (CameraHelper.isPortrait(this.context)) {
                        this.glInterface.setEncoderSize(i2, i);
                    } else {
                        this.glInterface.setEncoderSize(i, i2);
                    }
                    this.glInterface.setRotation(0);
                    this.glInterface.start();
                    this.cameraManager.setSurfaceTexture(this.glInterface.getSurfaceTexture());
                }
                this.cameraManager.setRotation(i3);
                this.cameraManager.start(facing, i, i2, this.videoEncoder.getFps());
                this.onPreview = true;
                return;
            }
        }
        Log.e("Camera1Base", "Streaming or preview started, ignored");
    }

    public void stopPreview() {
        if (!isStreaming() && !isRecording() && this.onPreview) {
            GlInterface glInterface = this.glInterface;
            if (!(glInterface instanceof OffScreenGlThread)) {
                if (glInterface != null && Build.VERSION.SDK_INT >= 18) {
                    glInterface.stop();
                }
                this.cameraManager.stop();
                this.onPreview = false;
                this.previewWidth = 0;
                this.previewHeight = 0;
                return;
            }
        }
        Log.e("Camera1Base", "Streaming or preview stopped, ignored");
    }

    public void startStream(String str) throws IOException {
        this.streaming = true;
        if (!this.recordController.isRunning()) {
            startEncoders();
        } else {
            resetVideoEncoder();
        }
        startStreamRtp(str);
        this.onPreview = true;
    }

    private void startEncoders() throws IOException {
        this.videoEncoder.start();
        this.audioEncoder.start();
        prepareGlView();
        this.microphoneManager.start();
        this.cameraManager.setRotation(this.videoEncoder.getRotation());
        if ((!this.cameraManager.isRunning() && this.videoEncoder.getWidth() != this.previewWidth) || this.videoEncoder.getHeight() != this.previewHeight) {
            this.cameraManager.start(this.videoEncoder.getWidth(), this.videoEncoder.getHeight(), this.videoEncoder.getFps());
        }
        this.onPreview = true;
    }

    private void resetVideoEncoder() {
        GlInterface glInterface = this.glInterface;
        if (glInterface != null && Build.VERSION.SDK_INT >= 18) {
            glInterface.removeMediaCodecSurface();
        }
        this.videoEncoder.reset();
        GlInterface glInterface2 = this.glInterface;
        if (glInterface2 == null || Build.VERSION.SDK_INT < 18) {
            return;
        }
        glInterface2.addMediaCodecSurface(this.videoEncoder.getInputSurface());
    }

    private void prepareGlView() {
        GlInterface glInterface = this.glInterface;
        if (glInterface == null || Build.VERSION.SDK_INT < 18) {
            return;
        }
        if (glInterface instanceof OffScreenGlThread) {
            OffScreenGlThread offScreenGlThread = new OffScreenGlThread(this.context);
            this.glInterface = offScreenGlThread;
            offScreenGlThread.init();
        }
        this.glInterface.setFps(this.videoEncoder.getFps());
        if (this.videoEncoder.getRotation() == 90 || this.videoEncoder.getRotation() == 270) {
            this.glInterface.setEncoderSize(this.videoEncoder.getHeight(), this.videoEncoder.getWidth());
        } else {
            this.glInterface.setEncoderSize(this.videoEncoder.getWidth(), this.videoEncoder.getHeight());
        }
        this.glInterface.setRotation(0);
        if ((!this.cameraManager.isRunning() && this.videoEncoder.getWidth() != this.previewWidth) || this.videoEncoder.getHeight() != this.previewHeight) {
            this.glInterface.start();
        }
        if (this.videoEncoder.getInputSurface() != null) {
            this.glInterface.addMediaCodecSurface(this.videoEncoder.getInputSurface());
        }
        this.cameraManager.setSurfaceTexture(this.glInterface.getSurfaceTexture());
    }

    public void stopStream() {
        if (this.streaming) {
            this.streaming = false;
            stopStreamRtp();
        }
        if (this.recordController.isRecording()) {
            return;
        }
        this.microphoneManager.stop();
        GlInterface glInterface = this.glInterface;
        if (glInterface != null && Build.VERSION.SDK_INT >= 18) {
            glInterface.removeMediaCodecSurface();
            GlInterface glInterface2 = this.glInterface;
            if (glInterface2 instanceof OffScreenGlThread) {
                glInterface2.stop();
                this.cameraManager.stop();
            }
        }
        this.videoEncoder.stop();
        this.audioEncoder.stop();
        this.recordController.resetFormats();
    }

    public boolean reTry(long j, String str) {
        boolean zShouldRetry = shouldRetry(str);
        if (zShouldRetry) {
            reTry(j);
        }
        return zShouldRetry;
    }

    @Deprecated
    public void reTry(long j) {
        resetVideoEncoder();
        reConnect(j);
    }

    public List<Camera.Size> getResolutionsFront() {
        return this.cameraManager.getPreviewSizeFront();
    }

    public int getBitrate() {
        return this.videoEncoder.getBitRate();
    }

    public void switchCamera() throws IOException, CameraOpenException {
        if (isStreaming() || this.onPreview) {
            this.cameraManager.switchCamera();
        }
    }

    public void setVideoBitrateOnFly(int i) {
        this.videoEncoder.setVideoBitrateOnFly(i);
    }

    public boolean isStreaming() {
        return this.streaming;
    }

    public boolean isRecording() {
        return this.recordController.isRunning();
    }

    @Override // com.pedro.encoder.audio.GetAacData
    public void getAacData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.recordController.recordAudio(byteBuffer, bufferInfo);
        }
        if (this.streaming) {
            getAacDataRtp(byteBuffer, bufferInfo);
        }
    }

    @Override // com.pedro.encoder.video.GetVideoData
    public void onSpsPps(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (this.streaming) {
            onSpsPpsVpsRtp(byteBuffer, byteBuffer2, null);
        }
    }

    @Override // com.pedro.encoder.video.GetVideoData
    public void onSpsPpsVps(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        if (this.streaming) {
            onSpsPpsVpsRtp(byteBuffer, byteBuffer2, byteBuffer3);
        }
    }

    @Override // com.pedro.encoder.video.GetVideoData
    public void getVideoData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.fpsListener.calculateFps();
        if (Build.VERSION.SDK_INT >= 18) {
            this.recordController.recordVideo(byteBuffer, bufferInfo);
        }
        if (this.streaming) {
            getH264DataRtp(byteBuffer, bufferInfo);
        }
    }

    @Override // com.pedro.encoder.input.audio.GetMicrophoneData
    public void inputPCMData(Frame frame) throws MediaCodec.CryptoException {
        this.audioEncoder.inputPCMData(frame);
    }

    @Override // com.pedro.encoder.input.video.GetCameraData
    public void inputYUVData(Frame frame) {
        this.videoEncoder.inputYUVData(frame);
    }

    @Override // com.pedro.encoder.video.GetVideoData
    public void onVideoFormat(MediaFormat mediaFormat) {
        this.recordController.setVideoFormat(mediaFormat);
    }

    @Override // com.pedro.encoder.audio.GetAacData
    public void onAudioFormat(MediaFormat mediaFormat) {
        this.recordController.setAudioFormat(mediaFormat);
    }

    public Camera getCamera() {
        return this.cameraManager.getCamera();
    }
}
