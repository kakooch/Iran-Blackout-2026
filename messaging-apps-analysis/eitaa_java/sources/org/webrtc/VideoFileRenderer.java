package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* loaded from: classes3.dex */
public class VideoFileRenderer implements VideoSink {
    private static final String TAG = "VideoFileRenderer";
    private EglBase eglBase;
    private final HandlerThread fileThread;
    private final Handler fileThreadHandler;
    private int frameCount;
    private final int outputFileHeight;
    private final String outputFileName;
    private final int outputFileWidth;
    private final ByteBuffer outputFrameBuffer;
    private final int outputFrameSize;
    private final HandlerThread renderThread;
    private final Handler renderThreadHandler;
    private final FileOutputStream videoOutFile;
    private YuvConverter yuvConverter;

    @Override // org.webrtc.VideoSink
    public /* synthetic */ void setParentSink(VideoSink videoSink) {
        VideoSink.CC.$default$setParentSink(this, videoSink);
    }

    public VideoFileRenderer(String outputFile, int outputFileWidth, int outputFileHeight, final EglBase.Context sharedContext) throws IOException {
        if (outputFileWidth % 2 == 1 || outputFileHeight % 2 == 1) {
            throw new IllegalArgumentException("Does not support uneven width or height");
        }
        this.outputFileName = outputFile;
        this.outputFileWidth = outputFileWidth;
        this.outputFileHeight = outputFileHeight;
        int i = ((outputFileWidth * outputFileHeight) * 3) / 2;
        this.outputFrameSize = i;
        this.outputFrameBuffer = ByteBuffer.allocateDirect(i);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        this.videoOutFile = fileOutputStream;
        fileOutputStream.write(("YUV4MPEG2 C420 W" + outputFileWidth + " H" + outputFileHeight + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
        HandlerThread handlerThread = new HandlerThread("VideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.renderThreadHandler = handler;
        HandlerThread handlerThread2 = new HandlerThread("VideoFileRendererFileThread");
        this.fileThread = handlerThread2;
        handlerThread2.start();
        this.fileThreadHandler = new Handler(handlerThread2.getLooper());
        ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: org.webrtc.VideoFileRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                VideoFileRenderer.this.eglBase = EglBase.CC.create(sharedContext, EglBase.CONFIG_PIXEL_BUFFER);
                VideoFileRenderer.this.eglBase.createDummyPbufferSurface();
                VideoFileRenderer.this.eglBase.makeCurrent();
                VideoFileRenderer.this.yuvConverter = new YuvConverter();
            }
        });
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame frame) {
        frame.retain();
        this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$VideoFileRenderer$9BbzLsKIK_INBOQ-Uv2OTQkEjOM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFrame$0$VideoFileRenderer(frame);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderFrameOnRenderThread, reason: merged with bridge method [inline-methods] */
    public void lambda$onFrame$0$VideoFileRenderer(final VideoFrame frame) {
        VideoFrame.Buffer buffer = frame.getBuffer();
        int i = frame.getRotation() % 180 == 0 ? this.outputFileWidth : this.outputFileHeight;
        int i2 = frame.getRotation() % 180 == 0 ? this.outputFileHeight : this.outputFileWidth;
        float width = buffer.getWidth() / buffer.getHeight();
        float f = i / i2;
        int width2 = buffer.getWidth();
        int height = buffer.getHeight();
        if (f > width) {
            height = (int) (height * (width / f));
        } else {
            width2 = (int) (width2 * (f / width));
        }
        VideoFrame.Buffer bufferCropAndScale = buffer.cropAndScale((buffer.getWidth() - width2) / 2, (buffer.getHeight() - height) / 2, width2, height, i, i2);
        frame.release();
        final VideoFrame.I420Buffer i420 = bufferCropAndScale.toI420();
        bufferCropAndScale.release();
        this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$VideoFileRenderer$tM8kahxbhZORo_5UN5WPn3O5r68
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$renderFrameOnRenderThread$1$VideoFileRenderer(i420, frame);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$renderFrameOnRenderThread$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$renderFrameOnRenderThread$1$VideoFileRenderer(VideoFrame.I420Buffer i420Buffer, VideoFrame videoFrame) throws IOException {
        YuvHelper.I420Rotate(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), this.outputFrameBuffer, i420Buffer.getWidth(), i420Buffer.getHeight(), videoFrame.getRotation());
        i420Buffer.release();
        try {
            this.videoOutFile.write("FRAME\n".getBytes(Charset.forName("US-ASCII")));
            this.videoOutFile.write(this.outputFrameBuffer.array(), this.outputFrameBuffer.arrayOffset(), this.outputFrameSize);
            this.frameCount++;
        } catch (IOException e) {
            throw new RuntimeException("Error writing video to disk", e);
        }
    }

    public void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$VideoFileRenderer$pitDrQEXfSUWMSmh_6M-o4aYUr8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$release$2$VideoFileRenderer(countDownLatch);
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$VideoFileRenderer$2g3mWjbPHPiGl-Q-q6owOAVsK4c
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$release$3$VideoFileRenderer();
            }
        });
        try {
            this.fileThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Logging.e(TAG, "Interrupted while waiting for the write to disk to complete.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$release$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$release$2$VideoFileRenderer(CountDownLatch countDownLatch) {
        this.yuvConverter.release();
        this.eglBase.release();
        this.renderThread.quit();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$release$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$release$3$VideoFileRenderer() throws IOException {
        try {
            this.videoOutFile.close();
            Logging.d(TAG, "Video written to disk as " + this.outputFileName + ". The number of frames is " + this.frameCount + " and the dimensions of the frames are " + this.outputFileWidth + "x" + this.outputFileHeight + ".");
            this.fileThread.quit();
        } catch (IOException e) {
            throw new RuntimeException("Error closing output file", e);
        }
    }
}
