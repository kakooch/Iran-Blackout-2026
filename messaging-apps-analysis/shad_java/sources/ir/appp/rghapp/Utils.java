package ir.appp.rghapp;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import androidx.exifinterface.media.ExifInterface;
import androidx.palette.graphics.Palette;
import com.google.gson.Gson;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.rubinoPostSlider.BackgroundGenerationListener2;
import ir.resaneh1.iptv.helper.StorageHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class Utils {
    private static final Gson gson = new Gson();

    public static boolean useNewStoryCreationSystem() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static String getGradientBackgroundFilePath(Context context, String str) {
        return new File(StorageHelper.getTempDirectoryFile(context), "gl_gr_bg_" + removeExtension(new File(str).getName()) + ".jpeg").getAbsolutePath();
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOfExtension = indexOfExtension(str);
        return iIndexOfExtension == -1 ? str : str.substring(0, iIndexOfExtension);
    }

    public static int indexOfExtension(String str) {
        int iLastIndexOf;
        if (str != null && str.lastIndexOf(47) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String getVideoOutputFilePath() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationActivity), "output_" + getTimeString() + ".mp4").getPath();
    }

    public static String getImageOutputFilePath2() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationActivity), BuildConfig.FLAVOR + getTimeString() + ".jpg").getPath();
    }

    public static String getImageTempFilePathPNG() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationActivity), BuildConfig.FLAVOR + getTimeString() + ".png").getPath();
    }

    public static String getImageOutputFilePath() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationActivity), "out_" + getTimeString() + ".jpg").getPath();
    }

    public static String getCameraImageOutputFilePath() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationActivity), "im_" + getTimeString() + ".jpg").getPath();
    }

    private static Bitmap adjustOutputBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(180.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        Matrix matrix2 = new Matrix();
        matrix2.setScale(-1.0f, 1.0f);
        matrix2.postTranslate(bitmap.getWidth(), 0.0f);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix2, false);
        bitmap.recycle();
        bitmapCreateBitmap.recycle();
        return bitmapCreateBitmap2;
    }

    public static Bitmap loadBitmapForOpenGL(Context context, String str, boolean z, int i, boolean z2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f = options.outHeight;
        float f2 = options.outWidth;
        if (f > 2048.0f || f2 > 2048.0f) {
            if (z2) {
                float f3 = f / f2;
                f2 = i;
                f = f3 * f2;
            } else {
                f = 2048.0f;
                f2 = 2048.0f;
            }
        }
        if (z && (i3 < RGHFilter.OUTPUT_WIDTH || i2 < RGHFilter.OUTPUT_HEIGHT)) {
            if (z2) {
                f2 = i3;
                f = i2;
            } else {
                f = 512.0f;
                f2 = 512.0f;
            }
        }
        options.inJustDecodeBounds = false;
        options.inScaled = false;
        options.inDither = true;
        options.inPurgeable = true;
        options.inSampleSize = calculateInSampleSize(options, (int) f2, (int) f);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int getImageRotation(String str) {
        try {
            int attributeInt = new ExifInterface(new File(str)).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getTimeString() {
        return new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
    }

    public static String saveBitmapToPath(Bitmap bitmap, String str) throws IOException {
        File file = new File(str);
        String absolutePath = file.getAbsolutePath();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return absolutePath;
    }

    public static String saveBitmap(Bitmap bitmap) throws IOException {
        File file = new File(getImageOutputFilePath());
        String absolutePath = file.getAbsolutePath();
        Bitmap bitmapAdjustOutputBitmap = adjustOutputBitmap(bitmap);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapAdjustOutputBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmapAdjustOutputBitmap.recycle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return absolutePath;
    }

    public static void putOverlayOnBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(2);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public static void createGradientBackground(String str, boolean z, final BackgroundGenerationListener2 backgroundGenerationListener2) {
        Bitmap bitmapDecodeFile;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        if (!z) {
            bitmapDecodeFile = ThumbnailUtils.createVideoThumbnail(str, 1);
        } else {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        }
        final int color = Color.parseColor("#626262");
        final int color2 = Color.parseColor("#adadad");
        if (bitmapDecodeFile != null) {
            final Bitmap bitmapCreatePartialBitmap = createPartialBitmap(bitmapDecodeFile, true);
            final Bitmap bitmapCreatePartialBitmap2 = createPartialBitmap(bitmapDecodeFile, false);
            bitmapDecodeFile.recycle();
            final int[] iArr = new int[2];
            Palette.from(bitmapCreatePartialBitmap).generate(new Palette.PaletteAsyncListener() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda1
                @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                public final void onGenerated(Palette palette) {
                    Utils.lambda$createGradientBackground$1(iArr, color, bitmapCreatePartialBitmap, bitmapCreatePartialBitmap2, color2, backgroundGenerationListener2, palette);
                }
            });
            return;
        }
        int[] iArr2 = {color, color2};
        backgroundGenerationListener2.onGradientBackgroundGenerated(iArr2[0], iArr2[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGradientBackground$1(final int[] iArr, int i, Bitmap bitmap, final Bitmap bitmap2, final int i2, final BackgroundGenerationListener2 backgroundGenerationListener2, Palette palette) {
        iArr[0] = getColorsFromPalette(palette, i);
        bitmap.recycle();
        Palette.from(bitmap2).generate(new Palette.PaletteAsyncListener() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda2
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public final void onGenerated(Palette palette2) {
                Utils.lambda$createGradientBackground$0(iArr, i2, bitmap2, backgroundGenerationListener2, palette2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGradientBackground$0(int[] iArr, int i, Bitmap bitmap, BackgroundGenerationListener2 backgroundGenerationListener2, Palette palette) {
        iArr[1] = getColorsFromPalette(palette, i);
        bitmap.recycle();
        backgroundGenerationListener2.onGradientBackgroundGenerated(iArr[0], iArr[1]);
    }

    public static void createGradientBackground(Context context, String str, boolean z, final BackgroundGenerationListener backgroundGenerationListener) throws IOException {
        final Bitmap bitmapDecodeFile;
        final String gradientBackgroundFilePath = getGradientBackgroundFilePath(context, str);
        File file = new File(gradientBackgroundFilePath);
        if (file.exists()) {
            backgroundGenerationListener.onGradientBackgroundGenerated(file.getAbsolutePath());
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        if (!z) {
            bitmapDecodeFile = ThumbnailUtils.createVideoThumbnail(str, 1);
        } else {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        }
        if (bitmapDecodeFile != null) {
            Palette.from(bitmapDecodeFile).generate(new Palette.PaletteAsyncListener() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda0
                @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                public final void onGenerated(Palette palette) throws IOException {
                    Utils.lambda$createGradientBackground$2(backgroundGenerationListener, gradientBackgroundFilePath, bitmapDecodeFile, palette);
                }
            });
        } else {
            internalGenerateBackground(new int[]{Color.parseColor("#626262"), Color.parseColor("#adadad")}, backgroundGenerationListener, gradientBackgroundFilePath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createGradientBackground$2(BackgroundGenerationListener backgroundGenerationListener, String str, Bitmap bitmap, Palette palette) throws IOException {
        internalGenerateBackground(getColorsFromPalette(palette), backgroundGenerationListener, str);
        bitmap.recycle();
    }

    private static Bitmap createPartialBitmap(Bitmap bitmap, boolean z) {
        int iDp = AndroidUtilities.dp(z ? 5.0f : 20.0f);
        int width = (int) (bitmap.getWidth() * 0.1f);
        if (z) {
            return Bitmap.createBitmap(bitmap, width, 0, bitmap.getWidth() - (width * 2), iDp);
        }
        return Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() - iDp, bitmap.getWidth(), iDp);
    }

    private static int calculateColorDiff(int i, int i2) {
        int iRed = Color.red(i);
        int iBlue = Color.blue(i);
        int iGreen = Color.green(i);
        return Math.abs(iRed - Color.red(i2)) + 0 + Math.abs(iBlue - Color.blue(i2)) + Math.abs(iGreen - Color.green(i2));
    }

    @Deprecated
    private static int[] getColorsFromPalette(Palette palette) {
        boolean z;
        int[] iArr = {-1, -1};
        if (palette != null) {
            try {
                if (!palette.getSwatches().isEmpty()) {
                    ArrayList arrayList = new ArrayList(palette.getSwatches());
                    Collections.sort(arrayList, new Comparator() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda4
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return Utils.lambda$getColorsFromPalette$3((Palette.Swatch) obj, (Palette.Swatch) obj2);
                        }
                    });
                    Palette.Swatch swatch = (Palette.Swatch) arrayList.get(0);
                    arrayList.remove(0);
                    iArr[0] = swatch.getRgb();
                    int iRed = Color.red(swatch.getRgb());
                    int iBlue = Color.blue(swatch.getRgb());
                    int iGreen = Color.green(swatch.getRgb());
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        Palette.Swatch swatch2 = (Palette.Swatch) it.next();
                        if (Math.abs(iRed - Color.red(swatch2.getRgb())) + 0 + Math.abs(iBlue - Color.blue(swatch2.getRgb())) + Math.abs(iGreen - Color.green(swatch2.getRgb())) > 256) {
                            iArr[1] = swatch2.getRgb();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(new BackgroundColorCandidate(((Palette.Swatch) it2.next()).getRgb(), ((((Math.abs(iRed - Color.red(r8.getRgb())) + 0) + Math.abs(iBlue - Color.blue(r8.getRgb()))) + Math.abs(iGreen - Color.green(r8.getRgb()))) / 256.0f) * 3.0f, r8.getPopulation() / swatch.getPopulation()));
                        }
                        Collections.sort(arrayList2, new Comparator() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda5
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return Utils.lambda$getColorsFromPalette$4((BackgroundColorCandidate) obj, (BackgroundColorCandidate) obj2);
                            }
                        });
                        iArr[1] = ((BackgroundColorCandidate) arrayList2.get(0)).getColorRGB();
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (iArr[0] == -1 && iArr[1] == -1) {
            iArr[0] = Color.parseColor("#626262");
            iArr[1] = Color.parseColor("#adadad");
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getColorsFromPalette$3(Palette.Swatch swatch, Palette.Swatch swatch2) {
        return swatch2.getPopulation() - swatch.getPopulation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getColorsFromPalette$4(BackgroundColorCandidate backgroundColorCandidate, BackgroundColorCandidate backgroundColorCandidate2) {
        return (int) (backgroundColorCandidate2.getColorWeight() - backgroundColorCandidate.getColorWeight());
    }

    private static int getColorsFromPalette(Palette palette, int i) {
        if (palette == null) {
            return i;
        }
        try {
            if (palette.getSwatches().isEmpty()) {
                return i;
            }
            ArrayList arrayList = new ArrayList(palette.getSwatches());
            Collections.sort(arrayList, new Comparator() { // from class: ir.appp.rghapp.Utils$$ExternalSyntheticLambda3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Utils.lambda$getColorsFromPalette$5((Palette.Swatch) obj, (Palette.Swatch) obj2);
                }
            });
            int i2 = -1;
            int size = arrayList.size() / 4;
            ArrayList arrayList2 = new ArrayList();
            int i3 = Integer.MIN_VALUE;
            int i4 = 0;
            int population = Integer.MIN_VALUE;
            for (int i5 = 0; i5 < size; i5++) {
                Palette.Swatch swatch = (Palette.Swatch) arrayList.get(0);
                if (swatch.getPopulation() > population / 8) {
                    arrayList2.add(swatch);
                    arrayList.remove(0);
                }
                population = swatch.getPopulation();
            }
            if (arrayList2.isEmpty()) {
                return !arrayList.isEmpty() ? ((Palette.Swatch) arrayList.get(0)).getRgb() : i;
            }
            if (arrayList2.size() > 1) {
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    int population2 = ((Palette.Swatch) arrayList2.get(i6)).getPopulation();
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        if (calculateColorDiff(((Palette.Swatch) arrayList2.get(i6)).getRgb(), ((Palette.Swatch) arrayList.get(i7)).getRgb()) < 128) {
                            population2 += ((Palette.Swatch) arrayList.get(i7)).getPopulation();
                        }
                    }
                    if (population2 > i3) {
                        i2 = i6;
                        i3 = population2;
                    }
                }
                i4 = i2;
            }
            return ((Palette.Swatch) arrayList2.get(i4)).getRgb();
        } catch (Exception unused) {
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getColorsFromPalette$5(Palette.Swatch swatch, Palette.Swatch swatch2) {
        return swatch2.getPopulation() - swatch.getPopulation();
    }

    private static void internalGenerateBackground(int[] iArr, BackgroundGenerationListener backgroundGenerationListener, String str) throws IOException {
        int i = RGHFilter.OUTPUT_HEIGHT;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i, iArr, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(linearGradient);
        int i2 = RGHFilter.OUTPUT_WIDTH;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawRect(new RectF(0.0f, 0.0f, i2, i), paint);
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArray);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmapCreateBitmap.recycle();
            }
            if (backgroundGenerationListener != null) {
                backgroundGenerationListener.onGradientBackgroundGenerated(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2;
        try {
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), null, null);
                    }
                    if (isMediaDocument(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        char c = 65535;
                        int iHashCode = str.hashCode();
                        if (iHashCode != 93166550) {
                            if (iHashCode != 100313435) {
                                if (iHashCode == 112202875 && str.equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                                    c = 1;
                                }
                            } else if (str.equals("image")) {
                                c = 0;
                            }
                        } else if (str.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                            c = 2;
                        }
                        if (c == 0) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (c == 1) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = c != 2 ? null : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return getDataColumn(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r9.startsWith("file://") == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058 A[PHI: r8
      0x0058: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v4 android.database.Cursor) binds: [B:28:0x0056, B:21:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r7 = "_data"
            r3[r0] = r7
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L55
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L55
            if (r8 == 0) goto L4b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            if (r9 == 0) goto L4b
            int r9 = r8.getColumnIndexOrThrow(r7)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            java.lang.String r10 = "content://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            if (r10 != 0) goto L42
            java.lang.String r10 = "/"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            if (r10 != 0) goto L3e
            java.lang.String r10 = "file://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            if (r10 != 0) goto L3e
            goto L42
        L3e:
            r8.close()
            return r9
        L42:
            r8.close()
            return r0
        L46:
            r9 = move-exception
            r0 = r8
            goto L4f
        L49:
            goto L56
        L4b:
            if (r8 == 0) goto L5b
            goto L58
        L4e:
            r9 = move-exception
        L4f:
            if (r0 == 0) goto L54
            r0.close()
        L54:
            throw r9
        L55:
            r8 = r0
        L56:
            if (r8 == 0) goto L5b
        L58:
            r8.close()
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.Utils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static <T> T convertMapToObject(LinkedHashMap linkedHashMap, Class<T> cls) {
        if (linkedHashMap == null) {
            return null;
        }
        try {
            return (T) new Gson().fromJson(new JSONObject(linkedHashMap).toString(), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T convertObjectToMap(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) gson.fromJson(ApplicationLoader.getGson().toJson(obj), (Class) cls);
        } catch (Exception unused) {
            return null;
        }
    }
}
