package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.util.Log;
import ir.nasim.utils.images.common.ImageLoadException;
import java.io.File;
import java.io.IOException;

/* renamed from: ir.nasim.nm2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C17914nm2 extends AbstractC10702c33 {
    private final String b = "FileSource";
    private String c;

    public C17914nm2(String str) {
        this.c = str;
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
        if (this.c == null) {
            throw new ImageLoadException("File Name is null");
        }
        if (!new File(this.c).exists()) {
            throw new ImageLoadException("File not exists");
        }
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.c, options);
            if (bitmapDecodeFile != null) {
                return bitmapDecodeFile;
            }
            throw new ImageLoadException("BitmapFactory.decodeFile return null");
        } catch (Exception e) {
            Log.e("FileSource", e.getMessage());
            System.gc();
            try {
                Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(this.c, options);
                if (bitmapDecodeFile2 != null) {
                    return bitmapDecodeFile2;
                }
                throw new ImageLoadException("BitmapFactory.decodeFile return null");
            } catch (Exception e2) {
                Log.e("FileSource", e2.getMessage());
                throw new ImageLoadException(e2.getMessage());
            }
        }
    }

    @Override // ir.nasim.AbstractC10702c33
    protected D23 d() throws ImageLoadException, NumberFormatException {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inTempStorage = (byte[]) La8.a.get();
        BitmapFactory.decodeFile(this.c, options);
        int i2 = options.outWidth;
        if (i2 == 0 || (i = options.outHeight) == 0) {
            throw new ImageLoadException("BitmapFactory.decodeFile: unable to load file");
        }
        int i3 = 0;
        try {
            String attribute = new ExifInterface(this.c).getAttribute("Orientation");
            if (attribute != null) {
                if (attribute.equals("5") || attribute.equals("6") || attribute.equals("7") || attribute.equals("8")) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                i3 = Integer.parseInt(attribute);
            }
        } catch (IOException unused) {
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
        return new D23(i2, i, i3, r13);
    }
}
