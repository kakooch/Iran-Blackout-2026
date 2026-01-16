package androidx.camera.core;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.e;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.O23;
import ir.nasim.PI3;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class ImageProcessingUtil {
    private static int a;

    enum a {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static f b(O23 o23, byte[] bArr) {
        AbstractC4980Hj5.a(o23.c() == 256);
        AbstractC4980Hj5.g(bArr);
        Surface surface = o23.getSurface();
        AbstractC4980Hj5.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            PI3.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        f fVarB = o23.b();
        if (fVarB == null) {
            PI3.c("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return fVarB;
    }

    public static Bitmap c(f fVar) {
        if (fVar.C() != 35) {
            throw new IllegalArgumentException("Input image format must be YUV_420_888");
        }
        int width = fVar.getWidth();
        int height = fVar.getHeight();
        int iA = fVar.P0()[0].a();
        int iA2 = fVar.P0()[1].a();
        int iA3 = fVar.P0()[2].a();
        int iB = fVar.P0()[0].b();
        int iB2 = fVar.P0()[1].b();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(fVar.getWidth(), fVar.getHeight(), Bitmap.Config.ARGB_8888);
        if (nativeConvertAndroid420ToBitmap(fVar.P0()[0].getBuffer(), iA, fVar.P0()[1].getBuffer(), iA2, fVar.P0()[2].getBuffer(), iA3, iB, iB2, bitmapCreateBitmap, bitmapCreateBitmap.getRowBytes(), width, height) == 0) {
            return bitmapCreateBitmap;
        }
        throw new UnsupportedOperationException("YUV to RGB conversion failed");
    }

    public static f d(final f fVar, O23 o23, ByteBuffer byteBuffer, int i, boolean z) {
        if (!i(fVar)) {
            PI3.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!h(i)) {
            PI3.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        }
        if (e(fVar, o23.getSurface(), byteBuffer, i, z) == a.ERROR_CONVERSION) {
            PI3.c("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        }
        if (Log.isLoggable("MH", 3)) {
            PI3.a("ImageProcessingUtil", String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), Integer.valueOf(a)));
            a++;
        }
        final f fVarB = o23.b();
        if (fVarB == null) {
            PI3.c("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
            return null;
        }
        k kVar = new k(fVarB);
        kVar.a(new e.a() { // from class: ir.nasim.I23
            @Override // androidx.camera.core.e.a
            public final void a(androidx.camera.core.f fVar2) {
                ImageProcessingUtil.j(fVarB, fVar, fVar2);
            }
        });
        return kVar;
    }

    private static a e(f fVar, Surface surface, ByteBuffer byteBuffer, int i, boolean z) {
        int width = fVar.getWidth();
        int height = fVar.getHeight();
        int iA = fVar.P0()[0].a();
        int iA2 = fVar.P0()[1].a();
        int iA3 = fVar.P0()[2].a();
        int iB = fVar.P0()[0].b();
        int iB2 = fVar.P0()[1].b();
        return nativeConvertAndroid420ToABGR(fVar.P0()[0].getBuffer(), iA, fVar.P0()[1].getBuffer(), iA2, fVar.P0()[2].getBuffer(), iA3, iB, iB2, surface, byteBuffer, width, height, z ? iB : 0, z ? iB2 : 0, z ? iB2 : 0, i) != 0 ? a.ERROR_CONVERSION : a.SUCCESS;
    }

    public static void f(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, bitmap.getRowBytes(), i, bitmap.getWidth(), bitmap.getHeight(), false);
    }

    public static void g(Bitmap bitmap, ByteBuffer byteBuffer, int i) {
        nativeCopyBetweenByteBufferAndBitmap(bitmap, byteBuffer, i, bitmap.getRowBytes(), bitmap.getWidth(), bitmap.getHeight(), true);
    }

    private static boolean h(int i) {
        return i == 0 || i == 90 || i == 180 || i == 270;
    }

    private static boolean i(f fVar) {
        return fVar.C() == 35 && fVar.P0().length == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(f fVar, f fVar2, f fVar3) {
        if (fVar == null || fVar2 == null) {
            return;
        }
        fVar2.close();
    }

    public static boolean k(Surface surface, byte[] bArr) {
        AbstractC4980Hj5.g(bArr);
        AbstractC4980Hj5.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) == 0) {
            return true;
        }
        PI3.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
        return false;
    }

    private static native int nativeConvertAndroid420ToABGR(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Surface surface, ByteBuffer byteBuffer4, int i6, int i7, int i8, int i9, int i10, int i11);

    private static native int nativeConvertAndroid420ToBitmap(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, Bitmap bitmap, int i6, int i7, int i8);

    private static native int nativeCopyBetweenByteBufferAndBitmap(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z);

    private static native int nativeRotateYUV(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, ByteBuffer byteBuffer4, int i5, int i6, ByteBuffer byteBuffer5, int i7, int i8, ByteBuffer byteBuffer6, int i9, int i10, ByteBuffer byteBuffer7, ByteBuffer byteBuffer8, ByteBuffer byteBuffer9, int i11, int i12, int i13);

    private static native int nativeShiftPixel(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2, ByteBuffer byteBuffer3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private static native int nativeWriteJpegToSurface(byte[] bArr, Surface surface);
}
