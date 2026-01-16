package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.f;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C16051kd2;
import ir.nasim.C20797sd2;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class ImageUtil {

    public static final class CodecFailedException extends Exception {
        private final a a;

        public enum a {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(String str, a aVar) {
            super(str);
            this.a = aVar;
        }
    }

    public static Bitmap a(f fVar) {
        int iC = fVar.C();
        if (iC == 1) {
            return c(fVar);
        }
        if (iC == 35) {
            return ImageProcessingUtil.c(fVar);
        }
        if (iC == 256 || iC == 4101) {
            return b(fVar);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + fVar.C() + ", only ImageFormat.YUV_420_888 and PixelFormat.RGBA_8888 are supported");
    }

    private static Bitmap b(f fVar) {
        byte[] bArrH = h(fVar);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrH, 0, bArrH.length, null);
        if (bitmapDecodeByteArray != null) {
            return bitmapDecodeByteArray;
        }
        throw new UnsupportedOperationException("Decode jpeg byte array failed");
    }

    private static Bitmap c(f fVar) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(fVar.getWidth(), fVar.getHeight(), Bitmap.Config.ARGB_8888);
        fVar.P0()[0].getBuffer().rewind();
        ImageProcessingUtil.g(bitmapCreateBitmap, fVar.P0()[0].getBuffer(), fVar.P0()[0].a());
        return bitmapCreateBitmap;
    }

    public static ByteBuffer d(Bitmap bitmap) {
        AbstractC4980Hj5.b(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Only accept Bitmap with ARGB_8888 format for now.");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getAllocationByteCount());
        ImageProcessingUtil.f(bitmap, byteBufferAllocateDirect, bitmap.getRowBytes());
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }

    public static Rational e(int i, Rational rational) {
        return (i == 90 || i == 270) ? f(rational) : new Rational(rational.getNumerator(), rational.getDenominator());
    }

    private static Rational f(Rational rational) {
        return rational == null ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean g(int i) {
        return i == 256 || i == 4101;
    }

    public static byte[] h(f fVar) {
        if (!g(fVar.C())) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + fVar.C());
        }
        ByteBuffer buffer = fVar.P0()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }

    public static Bitmap i(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static byte[] j(f fVar, Rect rect, int i, int i2) throws CodecFailedException {
        if (fVar.C() != 35) {
            throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + fVar.C());
        }
        YuvImage yuvImage = new YuvImage(k(fVar), 17, fVar.getWidth(), fVar.getHeight(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C20797sd2 c20797sd2 = new C20797sd2(byteArrayOutputStream, C16051kd2.b(fVar, i2));
        if (rect == null) {
            rect = new Rect(0, 0, fVar.getWidth(), fVar.getHeight());
        }
        if (yuvImage.compressToJpeg(rect, i, c20797sd2)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.a.ENCODE_FAILED);
    }

    public static byte[] k(f fVar) {
        f.a aVar = fVar.P0()[0];
        f.a aVar2 = fVar.P0()[1];
        f.a aVar3 = fVar.P0()[2];
        ByteBuffer buffer = aVar.getBuffer();
        ByteBuffer buffer2 = aVar2.getBuffer();
        ByteBuffer buffer3 = aVar3.getBuffer();
        buffer.rewind();
        buffer2.rewind();
        buffer3.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[((fVar.getWidth() * fVar.getHeight()) / 2) + iRemaining];
        int width = 0;
        for (int i = 0; i < fVar.getHeight(); i++) {
            buffer.get(bArr, width, fVar.getWidth());
            width += fVar.getWidth();
            buffer.position(Math.min(iRemaining, (buffer.position() - fVar.getWidth()) + aVar.a()));
        }
        int height = fVar.getHeight() / 2;
        int width2 = fVar.getWidth() / 2;
        int iA = aVar3.a();
        int iA2 = aVar2.a();
        int iB = aVar3.b();
        int iB2 = aVar2.b();
        byte[] bArr2 = new byte[iA];
        byte[] bArr3 = new byte[iA2];
        for (int i2 = 0; i2 < height; i2++) {
            buffer3.get(bArr2, 0, Math.min(iA, buffer3.remaining()));
            buffer2.get(bArr3, 0, Math.min(iA2, buffer2.remaining()));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < width2; i5++) {
                int i6 = width + 1;
                bArr[width] = bArr2[i3];
                width += 2;
                bArr[i6] = bArr3[i4];
                i3 += iB;
                i4 += iB2;
            }
        }
        return bArr;
    }
}
