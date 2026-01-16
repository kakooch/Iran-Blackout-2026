package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.RendererCommon;
import org.webrtc.VideoFrame;

/* loaded from: classes3.dex */
public class VideoFrameDrawer {
    public static final String TAG = "VideoFrameDrawer";
    static final float[] srcPoints = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    private VideoFrame lastI420Frame;
    private int renderHeight;
    private int renderWidth;
    private final float[] dstPoints = new float[6];
    private final Point renderSize = new Point();
    private final YuvUploader yuvUploader = new YuvUploader(null);
    private final Matrix renderMatrix = new Matrix();
    private final Matrix renderRotateMatrix = new Matrix();

    public static void drawTexture(RendererCommon.GlDrawer drawer, VideoFrame.TextureBuffer buffer, Matrix renderMatrix, int rotatedWidth, int rotatedHeight, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, boolean blur) {
        Matrix matrix = new Matrix(buffer.getTransformMatrix());
        matrix.preConcat(renderMatrix);
        float[] fArrConvertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix);
        int i = AnonymousClass1.$SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[buffer.getType().ordinal()];
        if (i == 1) {
            drawer.drawOes(buffer.getTextureId(), buffer.getWidth(), buffer.getHeight(), rotatedWidth, rotatedHeight, fArrConvertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, blur);
        } else {
            if (i == 2) {
                drawer.drawRgb(buffer.getTextureId(), buffer.getWidth(), buffer.getHeight(), rotatedWidth, rotatedHeight, fArrConvertMatrixFromAndroidGraphicsMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, blur);
                return;
            }
            throw new RuntimeException("Unknown texture type.");
        }
    }

    /* renamed from: org.webrtc.VideoFrameDrawer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type;

        static {
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void getRenderBufferBitmap(RendererCommon.GlDrawer drawer, int rotation, GlGenericDrawer.TextureCallback callback) {
        if (drawer instanceof GlGenericDrawer) {
            ((GlGenericDrawer) drawer).getRenderBufferBitmap(rotation, callback);
        }
    }

    private static class YuvUploader {
        private ByteBuffer copyBuffer;
        private int[] yuvTextures;

        private YuvUploader() {
        }

        /* synthetic */ YuvUploader(AnonymousClass1 anonymousClass1) {
            this();
        }

        public int[] uploadYuvData(int width, int height, int[] strides, ByteBuffer[] planes) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            int i = width / 2;
            int[] iArr = {width, i, i};
            int i2 = height / 2;
            int[] iArr2 = {height, i2, i2};
            int iMax = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                if (strides[i3] > iArr[i3]) {
                    iMax = Math.max(iMax, iArr[i3] * iArr2[i3]);
                }
            }
            if (iMax > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < iMax)) {
                this.copyBuffer = ByteBuffer.allocateDirect(iMax);
            }
            if (this.yuvTextures == null) {
                this.yuvTextures = new int[3];
                for (int i4 = 0; i4 < 3; i4++) {
                    this.yuvTextures[i4] = GlUtil.generateTexture(3553);
                }
            }
            for (int i5 = 0; i5 < 3; i5++) {
                GLES20.glActiveTexture(33984 + i5);
                GLES20.glBindTexture(3553, this.yuvTextures[i5]);
                if (strides[i5] == iArr[i5]) {
                    byteBuffer = planes[i5];
                } else {
                    YuvHelper.copyPlane(planes[i5], strides[i5], this.copyBuffer, iArr[i5], iArr[i5], iArr2[i5]);
                    byteBuffer = this.copyBuffer;
                }
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i5], iArr2[i5], 0, 6409, 5121, byteBuffer);
            }
            return this.yuvTextures;
        }

        public int[] uploadFromBuffer(VideoFrame.I420Buffer buffer) {
            return uploadYuvData(buffer.getWidth(), buffer.getHeight(), new int[]{buffer.getStrideY(), buffer.getStrideU(), buffer.getStrideV()}, new ByteBuffer[]{buffer.getDataY(), buffer.getDataU(), buffer.getDataV()});
        }

        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public void release() {
            this.copyBuffer = null;
            int[] iArr = this.yuvTextures;
            if (iArr != null) {
                GLES20.glDeleteTextures(3, iArr, 0);
                this.yuvTextures = null;
            }
        }
    }

    private static int distance(float x0, float y0, float x1, float y1) {
        return (int) Math.round(Math.hypot(x1 - x0, y1 - y0));
    }

    private void calculateTransformedRenderSize(int frameWidth, int frameHeight, Matrix renderMatrix) {
        if (renderMatrix == null) {
            this.renderWidth = frameWidth;
            this.renderHeight = frameHeight;
            return;
        }
        renderMatrix.mapPoints(this.dstPoints, srcPoints);
        for (int i = 0; i < 3; i++) {
            float[] fArr = this.dstPoints;
            int i2 = i * 2;
            fArr[i2] = fArr[i2] * frameWidth;
            int i3 = i2 + 1;
            fArr[i3] = fArr[i3] * frameHeight;
        }
        float[] fArr2 = this.dstPoints;
        this.renderWidth = distance(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        float[] fArr3 = this.dstPoints;
        this.renderHeight = distance(fArr3[0], fArr3[1], fArr3[4], fArr3[5]);
    }

    public void drawFrame(VideoFrame frame, RendererCommon.GlDrawer drawer) {
        drawFrame(frame, drawer, null);
    }

    public void drawFrame(VideoFrame frame, RendererCommon.GlDrawer drawer, Matrix additionalRenderMatrix) {
        drawFrame(frame, drawer, additionalRenderMatrix, 0, 0, frame.getRotatedWidth(), frame.getRotatedHeight(), false, false);
    }

    public void drawFrame(VideoFrame frame, RendererCommon.GlDrawer drawer, Matrix additionalRenderMatrix, int viewportX, int viewportY, int viewportWidth, int viewportHeight, boolean rotate, boolean blur) {
        calculateTransformedRenderSize(rotate ? frame.getRotatedHeight() : frame.getRotatedWidth(), rotate ? frame.getRotatedWidth() : frame.getRotatedHeight(), additionalRenderMatrix);
        if (this.renderWidth <= 0 || this.renderHeight <= 0) {
            Logging.w(TAG, "Illegal frame size: " + this.renderWidth + "x" + this.renderHeight);
            return;
        }
        boolean z = frame.getBuffer() instanceof VideoFrame.TextureBuffer;
        this.renderMatrix.reset();
        this.renderMatrix.preTranslate(0.5f, 0.5f);
        if (!z) {
            this.renderMatrix.preScale(1.0f, -1.0f);
        }
        this.renderMatrix.preRotate(frame.getRotation());
        this.renderMatrix.preTranslate(-0.5f, -0.5f);
        this.renderRotateMatrix.set(this.renderMatrix);
        if (additionalRenderMatrix != null) {
            this.renderMatrix.preConcat(additionalRenderMatrix);
        }
        if (z) {
            this.lastI420Frame = null;
            drawTexture(drawer, (VideoFrame.TextureBuffer) frame.getBuffer(), this.renderMatrix, frame.getRotatedWidth(), frame.getRotatedHeight(), this.renderWidth, this.renderHeight, viewportX, viewportY, viewportWidth, viewportHeight, blur);
            return;
        }
        if (frame != this.lastI420Frame) {
            this.lastI420Frame = frame;
            VideoFrame.I420Buffer i420 = frame.getBuffer().toI420();
            this.yuvUploader.uploadFromBuffer(i420);
            i420.release();
        }
        drawer.drawYuv(this.yuvUploader.getYuvTextures(), frame.getBuffer().getWidth(), frame.getBuffer().getHeight(), frame.getRotatedWidth(), frame.getRotatedHeight(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, viewportX, viewportY, viewportWidth, viewportHeight, blur);
    }

    public VideoFrame.Buffer prepareBufferForViewportSize(VideoFrame.Buffer buffer, int width, int height) {
        buffer.retain();
        return buffer;
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }
}
