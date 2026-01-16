package org.webrtc;

import java.nio.ByteBuffer;
import org.webrtc.VideoFrame;

/* loaded from: classes3.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final RefCountDelegate refCountDelegate;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    private static native void nativeCropAndScaleI420(ByteBuffer srcY, int srcStrideY, ByteBuffer srcU, int srcStrideU, ByteBuffer srcV, int srcStrideV, int cropX, int cropY, int cropWidth, int cropHeight, ByteBuffer dstY, int dstStrideY, ByteBuffer dstU, int dstStrideU, ByteBuffer dstV, int dstStrideV, int scaleWidth, int scaleHeight);

    private JavaI420Buffer(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, Runnable releaseCallback) {
        this.width = width;
        this.height = height;
        this.dataY = dataY;
        this.dataU = dataU;
        this.dataV = dataV;
        this.strideY = strideY;
        this.strideU = strideU;
        this.strideV = strideV;
        this.refCountDelegate = new RefCountDelegate(releaseCallback);
    }

    private static void checkCapacity(ByteBuffer data, int width, int height, int stride) {
        int i = (stride * (height - 1)) + width;
        if (data.capacity() >= i) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i + " bytes, but was " + data.capacity());
    }

    public static JavaI420Buffer wrap(int width, int height, ByteBuffer dataY, int strideY, ByteBuffer dataU, int strideU, ByteBuffer dataV, int strideV, Runnable releaseCallback) {
        if (dataY == null || dataU == null || dataV == null) {
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        if (!dataY.isDirect() || !dataU.isDirect() || !dataV.isDirect()) {
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        ByteBuffer byteBufferSlice = dataY.slice();
        ByteBuffer byteBufferSlice2 = dataU.slice();
        ByteBuffer byteBufferSlice3 = dataV.slice();
        int i = (width + 1) / 2;
        int i2 = (height + 1) / 2;
        checkCapacity(byteBufferSlice, width, height, strideY);
        checkCapacity(byteBufferSlice2, i, i2, strideU);
        checkCapacity(byteBufferSlice3, i, i2, strideV);
        return new JavaI420Buffer(width, height, byteBufferSlice, strideY, byteBufferSlice2, strideU, byteBufferSlice3, strideV, releaseCallback);
    }

    public static JavaI420Buffer allocate(int width, int height) {
        int i = (height + 1) / 2;
        int i2 = (width + 1) / 2;
        int i3 = width * height;
        int i4 = i3 + 0;
        int i5 = i2 * i;
        int i6 = i4 + i5;
        final ByteBuffer byteBufferNativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i3 + (i2 * 2 * i));
        byteBufferNativeAllocateByteBuffer.position(0);
        byteBufferNativeAllocateByteBuffer.limit(i4);
        ByteBuffer byteBufferSlice = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i4);
        byteBufferNativeAllocateByteBuffer.limit(i6);
        ByteBuffer byteBufferSlice2 = byteBufferNativeAllocateByteBuffer.slice();
        byteBufferNativeAllocateByteBuffer.position(i6);
        byteBufferNativeAllocateByteBuffer.limit(i6 + i5);
        return new JavaI420Buffer(width, height, byteBufferSlice, width, byteBufferSlice2, i2, byteBufferNativeAllocateByteBuffer.slice(), i2, new Runnable() { // from class: org.webrtc.-$$Lambda$JavaI420Buffer$tLdFcnEJPvUgP_4so0PE2olQFIo
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(byteBufferNativeAllocateByteBuffer);
            }
        });
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        return cropAndScaleI420(this, cropX, cropY, cropWidth, cropHeight, scaleWidth, scaleHeight);
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer buffer, int cropX, int cropY, int cropWidth, int cropHeight, int scaleWidth, int scaleHeight) {
        if (cropWidth == scaleWidth && cropHeight == scaleHeight) {
            ByteBuffer dataY = buffer.getDataY();
            ByteBuffer dataU = buffer.getDataU();
            ByteBuffer dataV = buffer.getDataV();
            dataY.position(cropX + (buffer.getStrideY() * cropY));
            int i = cropX / 2;
            int i2 = cropY / 2;
            dataU.position((buffer.getStrideU() * i2) + i);
            dataV.position(i + (i2 * buffer.getStrideV()));
            buffer.retain();
            return wrap(scaleWidth, scaleHeight, dataY.slice(), buffer.getStrideY(), dataU.slice(), buffer.getStrideU(), dataV.slice(), buffer.getStrideV(), new Runnable() { // from class: org.webrtc.-$$Lambda$FfxWPyMokL4ipT13gerwg4-i1dc
                @Override // java.lang.Runnable
                public final void run() {
                    buffer.release();
                }
            });
        }
        JavaI420Buffer javaI420BufferAllocate = allocate(scaleWidth, scaleHeight);
        nativeCropAndScaleI420(buffer.getDataY(), buffer.getStrideY(), buffer.getDataU(), buffer.getStrideU(), buffer.getDataV(), buffer.getStrideV(), cropX, cropY, cropWidth, cropHeight, javaI420BufferAllocate.getDataY(), javaI420BufferAllocate.getStrideY(), javaI420BufferAllocate.getDataU(), javaI420BufferAllocate.getStrideU(), javaI420BufferAllocate.getDataV(), javaI420BufferAllocate.getStrideV(), scaleWidth, scaleHeight);
        return javaI420BufferAllocate;
    }
}
