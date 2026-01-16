package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import ir.nasim.utils.images.common.ImageLoadException;

/* loaded from: classes8.dex */
public class V34 extends AbstractC10702c33 {
    private final String b = "MemorySource";
    private byte[] c;

    public V34(byte[] bArr) {
        this.c = bArr;
    }

    @Override // ir.nasim.AbstractC10702c33
    public Bitmap b() {
        return c(1);
    }

    @Override // ir.nasim.AbstractC10702c33
    public Bitmap c(int i) throws ImageLoadException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inTempStorage = (byte[]) La8.a.get();
        options.inSampleSize = i;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPreferQualityOverSpeed = true;
        options.inMutable = true;
        try {
            byte[] bArr = this.c;
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null) {
                return bitmapDecodeByteArray;
            }
            throw new ImageLoadException("BitmapFactory.decodeFile return null");
        } catch (Exception e) {
            Log.e("MemorySource", e.getMessage());
            System.gc();
            try {
                byte[] bArr2 = this.c;
                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                if (bitmapDecodeByteArray2 != null) {
                    return bitmapDecodeByteArray2;
                }
                throw new ImageLoadException("BitmapFactory.decodeFile return null");
            } catch (Exception e2) {
                Log.e("MemorySource", e2.getMessage());
                throw new ImageLoadException(e2.getMessage());
            }
        }
    }

    @Override // ir.nasim.AbstractC10702c33
    protected D23 d() throws ImageLoadException {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inTempStorage = (byte[]) La8.a.get();
        byte[] bArr = this.c;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i2 = options.outWidth;
        if (i2 == 0 || (i = options.outHeight) == 0) {
            throw new ImageLoadException("BitmapFactory.decodeFile: unable to load file");
        }
        R13 r13 = R13.UNKNOWN;
        if ("image/jpeg".equals(options.outMimeType) || "image/jpg".equals(options.outMimeType)) {
            r13 = R13.JPEG;
        } else if ("image/gif".equals(options.outMimeType)) {
            r13 = R13.GIF;
        } else if ("image/bmp".equals(options.outMimeType)) {
            r13 = R13.BMP;
        } else if ("image/webp".equals(options.outMimeType)) {
            r13 = R13.WEBP;
        }
        return new D23(i2, i, 0, r13);
    }
}
