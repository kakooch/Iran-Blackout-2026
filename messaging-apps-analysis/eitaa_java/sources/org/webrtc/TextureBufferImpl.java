package org.webrtc;

import android.graphics.Matrix;
import android.os.Handler;
import ir.eitaa.messenger.FileLog;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import org.webrtc.VideoFrame;

/* loaded from: classes3.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private final int height;
    private final int id;
    private final RefCountDelegate refCountDelegate;
    private final RefCountMonitor refCountMonitor;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int unscaledHeight;
    private final int unscaledWidth;
    private final int width;
    private final YuvConverter yuvConverter;

    interface RefCountMonitor {
        void onDestroy(TextureBufferImpl textureBuffer);

        void onRelease(TextureBufferImpl textureBuffer);

        void onRetain(TextureBufferImpl textureBuffer);
    }

    public TextureBufferImpl(int width, int height, VideoFrame.TextureBuffer.Type type, int id, Matrix transformMatrix, Handler toI420Handler, YuvConverter yuvConverter, final Runnable releaseCallback) {
        this(width, height, width, height, type, id, transformMatrix, toI420Handler, yuvConverter, new RefCountMonitor() { // from class: org.webrtc.TextureBufferImpl.1
            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRelease(TextureBufferImpl textureBuffer) {
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRetain(TextureBufferImpl textureBuffer) {
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onDestroy(TextureBufferImpl textureBuffer) {
                Runnable runnable = releaseCallback;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    TextureBufferImpl(int width, int height, VideoFrame.TextureBuffer.Type type, int id, Matrix transformMatrix, Handler toI420Handler, YuvConverter yuvConverter, RefCountMonitor refCountMonitor) {
        this(width, height, width, height, type, id, transformMatrix, toI420Handler, yuvConverter, refCountMonitor);
    }

    private TextureBufferImpl(int unscaledWidth, int unscaledHeight, int width, int height, VideoFrame.TextureBuffer.Type type, int id, Matrix transformMatrix, Handler toI420Handler, YuvConverter yuvConverter, final RefCountMonitor refCountMonitor) {
        this.unscaledWidth = unscaledWidth;
        this.unscaledHeight = unscaledHeight;
        this.width = width;
        this.height = height;
        this.type = type;
        this.id = id;
        this.transformMatrix = transformMatrix;
        this.toI420Handler = toI420Handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(new Runnable() { // from class: org.webrtc.-$$Lambda$TextureBufferImpl$eszCFygPyHqeaYKkUKckb22Eudg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$TextureBufferImpl(refCountMonitor);
            }
        });
        this.refCountMonitor = refCountMonitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$TextureBufferImpl(RefCountMonitor refCountMonitor) {
        refCountMonitor.onDestroy(this);
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.id;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        try {
            return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: org.webrtc.-$$Lambda$TextureBufferImpl$hkykr63_Ils2AQhiWftKqkOZNTo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.lambda$toI420$1$TextureBufferImpl();
                }
            });
        } catch (Throwable th) {
            FileLog.e(th);
            int width = getWidth();
            int height = getHeight();
            int i = ((width + 7) / 8) * 8;
            int i2 = (height + 1) / 2;
            final ByteBuffer byteBufferNativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer((height + i2) * i);
            while (byteBufferNativeAllocateByteBuffer.hasRemaining()) {
                byteBufferNativeAllocateByteBuffer.put((byte) 0);
            }
            int i3 = i / 4;
            int i4 = (i * height) + 0;
            int i5 = i / 2;
            int i6 = i4 + i5;
            byteBufferNativeAllocateByteBuffer.position(0);
            byteBufferNativeAllocateByteBuffer.limit(i4);
            ByteBuffer byteBufferSlice = byteBufferNativeAllocateByteBuffer.slice();
            byteBufferNativeAllocateByteBuffer.position(i4);
            int i7 = ((i2 - 1) * i) + i5;
            byteBufferNativeAllocateByteBuffer.limit(i4 + i7);
            ByteBuffer byteBufferSlice2 = byteBufferNativeAllocateByteBuffer.slice();
            byteBufferNativeAllocateByteBuffer.position(i6);
            byteBufferNativeAllocateByteBuffer.limit(i6 + i7);
            return JavaI420Buffer.wrap(width, height, byteBufferSlice, i, byteBufferSlice2, i, byteBufferNativeAllocateByteBuffer.slice(), i, new Runnable() { // from class: org.webrtc.-$$Lambda$TextureBufferImpl$pqCC-baevM9RSiiSsD-eSPAc0G8
                @Override // java.lang.Runnable
                public final void run() {
                    JniCommon.nativeFreeByteBuffer(byteBufferNativeAllocateByteBuffer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toI420$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ VideoFrame.I420Buffer lambda$toI420$1$TextureBufferImpl() throws Exception {
        return this.yuvConverter.convert(this);
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountMonitor.onRetain(this);
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountMonitor.onRelease(this);
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(cropX / this.width, (r0 - (cropY + cropHeight)) / this.height);
        matrix.preScale(cropWidth / this.width, cropHeight / this.height);
        return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * cropWidth) / this.width), Math.round((this.unscaledHeight * cropHeight) / this.height), scaleWidth, scaleHeight);
    }

    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    public Handler getToI420Handler() {
        return this.toI420Handler;
    }

    public YuvConverter getYuvConverter() {
        return this.yuvConverter;
    }

    public TextureBufferImpl applyTransformMatrix(Matrix transformMatrix, int newWidth, int newHeight) {
        return applyTransformMatrix(transformMatrix, newWidth, newHeight, newWidth, newHeight);
    }

    private TextureBufferImpl applyTransformMatrix(Matrix transformMatrix, int unscaledWidth, int unscaledHeight, int scaledWidth, int scaledHeight) {
        Matrix matrix = new Matrix(this.transformMatrix);
        matrix.preConcat(transformMatrix);
        retain();
        return new TextureBufferImpl(unscaledWidth, unscaledHeight, scaledWidth, scaledHeight, this.type, this.id, matrix, this.toI420Handler, this.yuvConverter, new RefCountMonitor() { // from class: org.webrtc.TextureBufferImpl.2
            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRetain(TextureBufferImpl textureBuffer) {
                TextureBufferImpl.this.refCountMonitor.onRetain(TextureBufferImpl.this);
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRelease(TextureBufferImpl textureBuffer) {
                TextureBufferImpl.this.refCountMonitor.onRelease(TextureBufferImpl.this);
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onDestroy(TextureBufferImpl textureBuffer) {
                TextureBufferImpl.this.release();
            }
        });
    }
}
