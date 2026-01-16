package ir.resaneh1.iptv.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;

/* loaded from: classes3.dex */
public class NewImageHelper {
    public static Bitmap loadImage(String str, float f, float f2, boolean z) {
        int i;
        int i2;
        Matrix matrix;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmapCreateBitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (str != null) {
            BitmapFactory.decodeFile(str, options);
        }
        float f3 = options.outWidth / f;
        float f4 = options.outHeight / f2;
        float fMax = Math.max(f3, f4);
        if (z) {
            fMax = Math.min(f3, f4);
        }
        if (fMax < 1.0f) {
            fMax = 1.0f;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = (int) Math.ceil(fMax);
        int i3 = 1;
        while (true) {
            i = i3 * 2;
            i2 = options.inSampleSize;
            if (i > i2) {
                break;
            }
            i3 = i;
        }
        if (i - i2 < i2 - i3) {
            options.inSampleSize = i;
        } else {
            options.inSampleSize = i3;
        }
        Bitmap bitmapDecodeFile = null;
        String str2 = str != null ? str : null;
        if (str2 != null) {
            try {
                int attributeInt = new ExifInterface(str2).getAttributeInt("Orientation", 1);
                matrix = new Matrix();
                try {
                    if (attributeInt == 3) {
                        matrix.postRotate(180.0f);
                    } else if (attributeInt == 6) {
                        matrix.postRotate(90.0f);
                    } else if (attributeInt == 8) {
                        matrix.postRotate(270.0f);
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
        } else {
            matrix = null;
        }
        if (str == null) {
            return null;
        }
        try {
            Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(str, options);
            if (bitmapDecodeFile2 == null) {
                return bitmapDecodeFile2;
            }
            if (!z) {
                bitmapCreateBitmap2 = Bitmaps.createBitmap(bitmapDecodeFile2, 0, 0, bitmapDecodeFile2.getWidth(), bitmapDecodeFile2.getHeight(), matrix, true);
                if (bitmapCreateBitmap2 == bitmapDecodeFile2) {
                    return bitmapDecodeFile2;
                }
                bitmapDecodeFile2.recycle();
            } else {
                if (bitmapDecodeFile2.getWidth() >= bitmapDecodeFile2.getHeight()) {
                    bitmapCreateBitmap2 = Bitmaps.createBitmap(bitmapDecodeFile2, (bitmapDecodeFile2.getWidth() / 2) - (bitmapDecodeFile2.getHeight() / 2), 0, bitmapDecodeFile2.getHeight(), bitmapDecodeFile2.getHeight(), matrix, true);
                } else {
                    bitmapCreateBitmap2 = Bitmaps.createBitmap(bitmapDecodeFile2, 0, (bitmapDecodeFile2.getHeight() / 2) - (bitmapDecodeFile2.getWidth() / 2), bitmapDecodeFile2.getWidth(), bitmapDecodeFile2.getWidth(), matrix, true);
                }
                if (bitmapCreateBitmap2 == bitmapDecodeFile2) {
                    return bitmapDecodeFile2;
                }
                bitmapDecodeFile2.recycle();
            }
            return bitmapCreateBitmap2;
        } catch (Throwable unused3) {
            if (0 == 0) {
                try {
                    bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return bitmapDecodeFile;
                }
            }
            if (bitmapDecodeFile != null) {
                Bitmap bitmapCreateBitmap3 = Bitmaps.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                if (bitmapCreateBitmap3 != bitmapDecodeFile) {
                    bitmapDecodeFile.recycle();
                    bitmapDecodeFile = bitmapCreateBitmap3;
                }
            }
            if (!z) {
                return bitmapDecodeFile;
            }
            if (bitmapDecodeFile.getWidth() >= bitmapDecodeFile.getHeight()) {
                bitmapCreateBitmap = Bitmaps.createBitmap(bitmapDecodeFile, (bitmapDecodeFile.getWidth() / 2) - (bitmapDecodeFile.getHeight() / 2), 0, bitmapDecodeFile.getHeight(), bitmapDecodeFile.getHeight(), matrix, true);
            } else {
                bitmapCreateBitmap = Bitmaps.createBitmap(bitmapDecodeFile, 0, (bitmapDecodeFile.getHeight() / 2) - (bitmapDecodeFile.getWidth() / 2), bitmapDecodeFile.getWidth(), bitmapDecodeFile.getWidth(), matrix, true);
            }
            if (bitmapCreateBitmap == bitmapDecodeFile) {
                return bitmapDecodeFile;
            }
            bitmapDecodeFile.recycle();
            return bitmapCreateBitmap;
        }
    }

    public static String compressImageAndSave(Bitmap bitmap, int i) throws IOException {
        if (i > 100) {
            i = 100;
        }
        if (i < 0) {
            i = 0;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        StorageHelper.makeDownloadDirs();
        File file = new File(StorageHelper.getImageTempFilePath(ApplicationLoader.applicationContext));
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            bitmap.recycle();
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
