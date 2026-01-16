package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class V13 {

    private static class a {
        private int a;
        private int b;

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        private a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        try {
            Matrix matrix = new Matrix();
            switch (i) {
                case 2:
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.postRotate(180.0f);
                    break;
                case 4:
                    matrix.postRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 5:
                    matrix.postRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 6:
                    matrix.postRotate(90.0f);
                    break;
                case 7:
                    matrix.postRotate(270.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 8:
                    matrix.postRotate(270.0f);
                    break;
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        r3 = r0.outHeight;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.V13.a b(java.lang.String r5) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            android.graphics.BitmapFactory.decodeFile(r5, r0)
            int r1 = r0.outWidth
            r2 = 0
            if (r1 == 0) goto L55
            int r3 = r0.outHeight
            if (r3 != 0) goto L15
            goto L55
        L15:
            android.media.ExifInterface r4 = new android.media.ExifInterface     // Catch: java.io.IOException -> L43
            r4.<init>(r5)     // Catch: java.io.IOException -> L43
            java.lang.String r5 = "Orientation"
            java.lang.String r5 = r4.getAttribute(r5)     // Catch: java.io.IOException -> L43
            if (r5 == 0) goto L4f
            java.lang.String r4 = "5"
            boolean r4 = r5.equals(r4)     // Catch: java.io.IOException -> L43
            if (r4 != 0) goto L45
            java.lang.String r4 = "6"
            boolean r4 = r5.equals(r4)     // Catch: java.io.IOException -> L43
            if (r4 != 0) goto L45
            java.lang.String r4 = "7"
            boolean r4 = r5.equals(r4)     // Catch: java.io.IOException -> L43
            if (r4 != 0) goto L45
            java.lang.String r4 = "8"
            boolean r5 = r5.equals(r4)     // Catch: java.io.IOException -> L43
            if (r5 == 0) goto L4f
            goto L45
        L43:
            r5 = move-exception
            goto L4a
        L45:
            int r1 = r0.outHeight     // Catch: java.io.IOException -> L43
            int r3 = r0.outWidth     // Catch: java.io.IOException -> L43
            goto L4f
        L4a:
            java.lang.String r0 = "ImageHelper"
            ir.nasim.C19406qI3.d(r0, r5)
        L4f:
            ir.nasim.V13$a r5 = new ir.nasim.V13$a
            r5.<init>(r1, r3)
            return r5
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V13.b(java.lang.String):ir.nasim.V13$a");
    }

    public static int c(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (Exception e) {
            C19406qI3.d("getPhotoOrientation", e);
            return 0;
        }
    }

    private static int d(a aVar, int i) {
        int i2 = 1;
        if (aVar != null) {
            int iA = aVar.a();
            for (int iB = aVar.b(); iB * iA > i; iB /= 2) {
                i2 *= 2;
                iA /= 2;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        r0 = android.graphics.BitmapFactory.decodeFile(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap e(java.lang.String r4) {
        /*
            ir.nasim.V13$a r0 = b(r4)
            r1 = 2250000(0x225510, float:3.152922E-39)
            int r0 = d(r0, r1)
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 0
            r1.inScaled = r2
            r1.inSampleSize = r0
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r1.inPreferredConfig = r0
            r0 = 1
            r1.inPreferQualityOverSpeed = r0
            r1.inMutable = r0
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r0 = r0.exists()
            r3 = 0
            if (r0 != 0) goto L2b
            return r3
        L2b:
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r4, r1)
            if (r0 != 0) goto L32
            return r3
        L32:
            android.media.ExifInterface r1 = new android.media.ExifInterface     // Catch: java.io.IOException -> L44
            r1.<init>(r4)     // Catch: java.io.IOException -> L44
            java.lang.String r4 = "Orientation"
            java.lang.String r4 = r1.getAttribute(r4)     // Catch: java.io.IOException -> L44
            if (r4 == 0) goto L46
            int r2 = java.lang.Integer.parseInt(r4)     // Catch: java.io.IOException -> L44
            goto L46
        L44:
            r4 = move-exception
            goto L4b
        L46:
            android.graphics.Bitmap r0 = a(r0, r2)     // Catch: java.io.IOException -> L44
            goto L50
        L4b:
            java.lang.String r1 = "ImageHelper"
            ir.nasim.C19406qI3.d(r1, r4)
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V13.e(java.lang.String):android.graphics.Bitmap");
    }

    public static void f(Bitmap bitmap, String str) throws Throwable {
        h(bitmap, str, Bitmap.CompressFormat.JPEG, 70);
    }

    public static void g(Bitmap bitmap, String str, int i) throws Throwable {
        h(bitmap, str, Bitmap.CompressFormat.JPEG, i);
    }

    private static void h(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                bitmap.compress(compressFormat, i, fileOutputStream2);
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    C19406qI3.d("ImageHelper", e);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        C19406qI3.d("ImageHelper", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] i(Bitmap bitmap) {
        return j(bitmap, Bitmap.CompressFormat.WEBP, 30);
    }

    private static byte[] j(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(compressFormat, i, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    C19406qI3.d("ImageHelper", e);
                }
                return byteArray;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        C19406qI3.d("ImageHelper", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Bitmap k(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateBitmap = Build.VERSION.SDK_INT >= 26 ? Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565, false) : Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        l(bitmap, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    private static void l(Bitmap bitmap, Bitmap bitmap2) {
        m(bitmap, bitmap2, 0);
    }

    private static void m(Bitmap bitmap, Bitmap bitmap2, int i) {
        n(bitmap, bitmap2, i, 0, 0, bitmap.getWidth(), bitmap.getHeight(), 0, 0, bitmap2.getWidth(), bitmap2.getHeight());
    }

    private static void n(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        bitmap2.eraseColor(i);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(i2 + 1, i3 + 1, i4 - 1, i5 - 1), new Rect(i6, i7, i8, i9), paint);
        canvas.setBitmap(null);
    }

    public static Bitmap o(Bitmap bitmap, int i, int i2) {
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        return k(bitmap, (int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin));
    }
}
