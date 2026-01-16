package org.rbmain.messenger.camera;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Base64;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.SerializedData;

/* loaded from: classes4.dex */
public class CameraController implements MediaRecorder.OnInfoListener {
    private static final int CORE_POOL_SIZE = 1;
    private static volatile CameraController Instance = null;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 1;
    protected volatile ArrayList<CameraInfo> cameraInfos;
    private boolean cameraInitied;
    private boolean loadingCameras;
    private boolean mirrorRecorderVideo;
    private VideoTakeCallback onVideoTakeCallback;
    private String recordedFile;
    private MediaRecorder recorder;
    protected ArrayList<String> availableFlashModes = new ArrayList<>();
    private ArrayList<Runnable> onFinishCameraInitRunnables = new ArrayList<>();
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public interface OnImageCaptured {
        void onImageCaptured(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry);
    }

    public interface VideoTakeCallback {
        void onFinishVideoRecording(String str, long j);
    }

    public static CameraController getInstance() {
        CameraController cameraController = Instance;
        if (cameraController == null) {
            synchronized (CameraController.class) {
                cameraController = Instance;
                if (cameraController == null) {
                    cameraController = new CameraController();
                    Instance = cameraController;
                }
            }
        }
        return cameraController;
    }

    public void cancelOnInitRunnable(Runnable runnable) {
        this.onFinishCameraInitRunnables.remove(runnable);
    }

    public void initCamera(Runnable runnable) {
        initCamera(runnable, false);
    }

    private void initCamera(final Runnable runnable, final boolean z) {
        if (this.cameraInitied) {
            return;
        }
        if (runnable != null && !this.onFinishCameraInitRunnables.contains(runnable)) {
            this.onFinishCameraInitRunnables.add(runnable);
        }
        if (this.loadingCameras || this.cameraInitied) {
            return;
        }
        this.loadingCameras = true;
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initCamera$4(z, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$4(final boolean z, final Runnable runnable) {
        Camera.CameraInfo cameraInfo;
        int i;
        String str;
        final CameraController cameraController = this;
        String str2 = "cameraCache";
        try {
            if (cameraController.cameraInfos == null) {
                SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                String string = globalMainSettings.getString("cameraCache", null);
                CameraController$$ExternalSyntheticLambda15 cameraController$$ExternalSyntheticLambda15 = new Comparator() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda15
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return CameraController.lambda$initCamera$0((Size) obj, (Size) obj2);
                    }
                };
                ArrayList<CameraInfo> arrayList = new ArrayList<>();
                if (string != null) {
                    SerializedData serializedData = new SerializedData(Base64.decode(string, 0));
                    int int32 = serializedData.readInt32(false);
                    for (int i2 = 0; i2 < int32; i2++) {
                        CameraInfo cameraInfo2 = new CameraInfo(serializedData.readInt32(false), serializedData.readInt32(false));
                        int int322 = serializedData.readInt32(false);
                        for (int i3 = 0; i3 < int322; i3++) {
                            cameraInfo2.previewSizes.add(new Size(serializedData.readInt32(false), serializedData.readInt32(false)));
                        }
                        int int323 = serializedData.readInt32(false);
                        for (int i4 = 0; i4 < int323; i4++) {
                            cameraInfo2.pictureSizes.add(new Size(serializedData.readInt32(false), serializedData.readInt32(false)));
                        }
                        arrayList.add(cameraInfo2);
                        Collections.sort(cameraInfo2.previewSizes, cameraController$$ExternalSyntheticLambda15);
                        Collections.sort(cameraInfo2.pictureSizes, cameraController$$ExternalSyntheticLambda15);
                    }
                    serializedData.cleanup();
                } else {
                    int numberOfCameras = Camera.getNumberOfCameras();
                    Camera.CameraInfo cameraInfo3 = new Camera.CameraInfo();
                    int size = 4;
                    int i5 = 0;
                    while (i5 < numberOfCameras) {
                        try {
                            Camera.getCameraInfo(i5, cameraInfo3);
                            CameraInfo cameraInfo4 = new CameraInfo(i5, cameraInfo3.facing);
                            if (ApplicationLoader.mainInterfacePaused && ApplicationLoader.externalInterfacePaused) {
                                throw new RuntimeException("APP_PAUSED");
                            }
                            Camera cameraOpen = Camera.open(cameraInfo4.getCameraId());
                            Camera.Parameters parameters = cameraOpen.getParameters();
                            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                            int i6 = 0;
                            while (true) {
                                cameraInfo = cameraInfo3;
                                if (i6 >= supportedPreviewSizes.size()) {
                                    break;
                                }
                                Camera.Size size2 = supportedPreviewSizes.get(i6);
                                int i7 = size2.width;
                                List<Camera.Size> list = supportedPreviewSizes;
                                if ((i7 != 1280 || size2.height == 720) && (i = size2.height) < 2160 && i7 < 2160) {
                                    str = str2;
                                    cameraInfo4.previewSizes.add(new Size(i7, i));
                                    if (BuildVars.LOGS_ENABLED) {
                                        FileLog.d("preview size = " + size2.width + " " + size2.height);
                                    }
                                } else {
                                    str = str2;
                                }
                                i6++;
                                cameraInfo3 = cameraInfo;
                                supportedPreviewSizes = list;
                                str2 = str;
                            }
                            String str3 = str2;
                            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                            for (int i8 = 0; i8 < supportedPictureSizes.size(); i8++) {
                                Camera.Size size3 = supportedPictureSizes.get(i8);
                                if (size3.width != 1280 || size3.height == 720) {
                                    if (!"samsung".equals(Build.MANUFACTURER) || !"jflteuc".equals(Build.PRODUCT) || size3.width < 2048) {
                                        cameraInfo4.pictureSizes.add(new Size(size3.width, size3.height));
                                        if (BuildVars.LOGS_ENABLED) {
                                            FileLog.d("picture size = " + size3.width + " " + size3.height);
                                        }
                                    }
                                }
                            }
                            cameraOpen.release();
                            arrayList.add(cameraInfo4);
                            Collections.sort(cameraInfo4.previewSizes, cameraController$$ExternalSyntheticLambda15);
                            Collections.sort(cameraInfo4.pictureSizes, cameraController$$ExternalSyntheticLambda15);
                            size += ((cameraInfo4.previewSizes.size() + cameraInfo4.pictureSizes.size()) * 8) + 8;
                            i5++;
                            cameraInfo3 = cameraInfo;
                            str2 = str3;
                        } catch (Exception e) {
                            e = e;
                            cameraController = this;
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda10
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$initCamera$3(z, e, runnable);
                                }
                            });
                            return;
                        }
                    }
                    String str4 = str2;
                    SerializedData serializedData2 = new SerializedData(size);
                    serializedData2.writeInt32(arrayList.size());
                    for (int i9 = 0; i9 < numberOfCameras; i9++) {
                        CameraInfo cameraInfo5 = arrayList.get(i9);
                        serializedData2.writeInt32(cameraInfo5.cameraId);
                        serializedData2.writeInt32(cameraInfo5.frontCamera);
                        int size4 = cameraInfo5.previewSizes.size();
                        serializedData2.writeInt32(size4);
                        for (int i10 = 0; i10 < size4; i10++) {
                            Size size5 = cameraInfo5.previewSizes.get(i10);
                            serializedData2.writeInt32(size5.mWidth);
                            serializedData2.writeInt32(size5.mHeight);
                        }
                        int size6 = cameraInfo5.pictureSizes.size();
                        serializedData2.writeInt32(size6);
                        for (int i11 = 0; i11 < size6; i11++) {
                            Size size7 = cameraInfo5.pictureSizes.get(i11);
                            serializedData2.writeInt32(size7.mWidth);
                            serializedData2.writeInt32(size7.mHeight);
                        }
                    }
                    globalMainSettings.edit().putString(str4, Base64.encodeToString(serializedData2.toByteArray(), 0)).apply();
                    serializedData2.cleanup();
                    cameraController = this;
                }
                cameraController.cameraInfos = arrayList;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$initCamera$1();
                }
            });
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initCamera$0(Size size, Size size2) {
        int i = size.mWidth;
        int i2 = size2.mWidth;
        if (i < i2) {
            return 1;
        }
        if (i > i2) {
            return -1;
        }
        int i3 = size.mHeight;
        int i4 = size2.mHeight;
        if (i3 < i4) {
            return 1;
        }
        return i3 > i4 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$1() {
        this.loadingCameras = false;
        this.cameraInitied = true;
        if (!this.onFinishCameraInitRunnables.isEmpty()) {
            for (int i = 0; i < this.onFinishCameraInitRunnables.size(); i++) {
                this.onFinishCameraInitRunnables.get(i).run();
            }
            this.onFinishCameraInitRunnables.clear();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.cameraInitied, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$3(boolean z, Exception exc, final Runnable runnable) {
        this.onFinishCameraInitRunnables.clear();
        this.loadingCameras = false;
        this.cameraInitied = false;
        if (z || !"APP_PAUSED".equals(exc.getMessage())) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initCamera$2(runnable);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$2(Runnable runnable) {
        initCamera(runnable, true);
    }

    public boolean isCameraInitied() {
        return (!this.cameraInitied || this.cameraInfos == null || this.cameraInfos.isEmpty()) ? false : true;
    }

    public void runOnThreadPool(Runnable runnable) {
        this.threadPool.execute(runnable);
    }

    public void close(final CameraSession cameraSession, final CountDownLatch countDownLatch, final Runnable runnable) {
        cameraSession.destroy();
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CameraController.lambda$close$5(runnable, cameraSession, countDownLatch);
            }
        });
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$close$5(Runnable runnable, CameraSession cameraSession, CountDownLatch countDownLatch) {
        if (runnable != null) {
            runnable.run();
        }
        Camera camera = cameraSession.cameraInfo.camera;
        if (camera != null) {
            try {
                camera.stopPreview();
                cameraSession.cameraInfo.camera.setPreviewCallbackWithBuffer(null);
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                cameraSession.cameraInfo.camera.release();
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            cameraSession.cameraInfo.camera = null;
        }
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public ArrayList<CameraInfo> getCameras() {
        return this.cameraInfos;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int getOrientation(byte[] r10) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.camera.CameraController.getOrientation(byte[]):int");
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    public boolean takePicture(final File file, CameraSession cameraSession, final OnImageCaptured onImageCaptured) {
        if (cameraSession == null) {
            return false;
        }
        final CameraInfo cameraInfo = cameraSession.cameraInfo;
        final boolean zIsFlipFront = cameraSession.isFlipFront();
        try {
            cameraInfo.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda1
                @Override // android.hardware.Camera.PictureCallback
                public final void onPictureTaken(byte[] bArr, Camera camera) throws IOException {
                    CameraController.lambda$takePicture$6(file, cameraInfo, zIsFlipFront, onImageCaptured, bArr, camera);
                }
            });
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$takePicture$6(File file, CameraInfo cameraInfo, boolean z, OnImageCaptured onImageCaptured, byte[] bArr, Camera camera) throws IOException {
        Bitmap bitmapDecodeByteArray;
        int photoSize = (int) (AndroidUtilities.getPhotoSize() / AndroidUtilities.density);
        String str = String.format(Locale.US, "%s@%d_%d", Utilities.MD5(file.getAbsolutePath()), Integer.valueOf(photoSize), Integer.valueOf(photoSize));
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            float fMax = Math.max(options.outWidth / AndroidUtilities.getPhotoSize(), options.outHeight / AndroidUtilities.getPhotoSize());
            if (fMax < 1.0f) {
                fMax = 1.0f;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = (int) fMax;
            options.inPurgeable = true;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Throwable th) {
            FileLog.e(th);
            bitmapDecodeByteArray = null;
        }
        Bitmap bitmap = bitmapDecodeByteArray;
        try {
            if (cameraInfo.frontCamera != 0 && z) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(getOrientation(bArr));
                    matrix.postScale(-1.0f, 1.0f);
                    Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    if (bitmapCreateBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapCreateBitmap), str);
                    if (onImageCaptured != null) {
                        onImageCaptured.onImageCaptured(new RGHMediaHelper$PhotoEntry(0, 2222, 0L, file.getAbsolutePath(), 90, false, 0, 0, 0L));
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    FileLog.e(th2);
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            fileOutputStream2.write(bArr);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            fileOutputStream2.close();
            if (bitmap != null) {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), str);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (onImageCaptured != null) {
            onImageCaptured.onImageCaptured(new RGHMediaHelper$PhotoEntry(0, 2222, 0L, file.getAbsolutePath(), 90, false, 0, 0, 0L));
        }
    }

    public boolean takePicture(final File file, CameraSession cameraSession, final Runnable runnable) {
        if (cameraSession == null) {
            return false;
        }
        final CameraInfo cameraInfo = cameraSession.cameraInfo;
        final boolean zIsFlipFront = cameraSession.isFlipFront();
        try {
            cameraInfo.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda0
                @Override // android.hardware.Camera.PictureCallback
                public final void onPictureTaken(byte[] bArr, Camera camera) throws IOException {
                    CameraController.lambda$takePicture$7(file, cameraInfo, zIsFlipFront, runnable, bArr, camera);
                }
            });
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$takePicture$7(File file, CameraInfo cameraInfo, boolean z, Runnable runnable, byte[] bArr, Camera camera) throws IOException {
        Bitmap bitmapDecodeByteArray;
        int photoSize = (int) (AndroidUtilities.getPhotoSize() / AndroidUtilities.density);
        String str = String.format(Locale.US, "%s@%d_%d", Utilities.MD5(file.getAbsolutePath()), Integer.valueOf(photoSize), Integer.valueOf(photoSize));
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            float fMax = Math.max(options.outWidth / AndroidUtilities.getPhotoSize(), options.outHeight / AndroidUtilities.getPhotoSize());
            if (fMax < 1.0f) {
                fMax = 1.0f;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = (int) fMax;
            options.inPurgeable = true;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Throwable th) {
            FileLog.e(th);
            bitmapDecodeByteArray = null;
        }
        try {
            if (cameraInfo.frontCamera != 0 && z) {
                try {
                    Matrix matrix = new Matrix();
                    matrix.setRotate(getOrientation(bArr));
                    matrix.postScale(-1.0f, 1.0f);
                    Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
                    if (bitmapCreateBitmap != bitmapDecodeByteArray) {
                        bitmapDecodeByteArray.recycle();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapCreateBitmap), str);
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    FileLog.e(th2);
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            fileOutputStream2.write(bArr);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            fileOutputStream2.close();
            if (bitmapDecodeByteArray != null) {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapDecodeByteArray), str);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void startPreview(final CameraSession cameraSession) {
        if (cameraSession == null) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                CameraController.lambda$startPreview$8(cameraSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startPreview$8(CameraSession cameraSession) {
        CameraInfo cameraInfo = cameraSession.cameraInfo;
        Camera camera = cameraInfo.camera;
        if (camera == null) {
            try {
                Camera cameraOpen = Camera.open(cameraInfo.cameraId);
                cameraInfo.camera = cameraOpen;
                camera = cameraOpen;
            } catch (Exception e) {
                cameraSession.cameraInfo.camera = null;
                if (camera != null) {
                    camera.release();
                }
                FileLog.e(e);
                return;
            }
        }
        camera.startPreview();
    }

    public void stopPreview(final CameraSession cameraSession) {
        if (cameraSession == null) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                CameraController.lambda$stopPreview$9(cameraSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopPreview$9(CameraSession cameraSession) {
        CameraInfo cameraInfo = cameraSession.cameraInfo;
        Camera camera = cameraInfo.camera;
        if (camera == null) {
            try {
                Camera cameraOpen = Camera.open(cameraInfo.cameraId);
                cameraInfo.camera = cameraOpen;
                camera = cameraOpen;
            } catch (Exception e) {
                cameraSession.cameraInfo.camera = null;
                if (camera != null) {
                    camera.release();
                }
                FileLog.e(e);
                return;
            }
        }
        camera.stopPreview();
    }

    public void openRound(final CameraSession cameraSession, final SurfaceTexture surfaceTexture, final Runnable runnable, final Runnable runnable2) {
        if (cameraSession == null || surfaceTexture == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to open round " + cameraSession + " tex = " + surfaceTexture);
                return;
            }
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                CameraController.lambda$openRound$10(cameraSession, runnable2, surfaceTexture, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openRound$10(CameraSession cameraSession, Runnable runnable, SurfaceTexture surfaceTexture, Runnable runnable2) throws IOException {
        Camera camera = cameraSession.cameraInfo.camera;
        try {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("start creating round camera session");
            }
            if (camera == null) {
                CameraInfo cameraInfo = cameraSession.cameraInfo;
                Camera cameraOpen = Camera.open(cameraInfo.cameraId);
                cameraInfo.camera = cameraOpen;
                camera = cameraOpen;
            }
            camera.getParameters();
            cameraSession.configureRoundCamera();
            if (runnable != null) {
                runnable.run();
            }
            camera.setPreviewTexture(surfaceTexture);
            camera.startPreview();
            if (runnable2 != null) {
                AndroidUtilities.runOnUIThread(runnable2);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("round camera session created");
            }
        } catch (Exception e) {
            cameraSession.cameraInfo.camera = null;
            if (camera != null) {
                camera.release();
            }
            FileLog.e(e);
        }
    }

    public void open(final CameraSession cameraSession, final SurfaceTexture surfaceTexture, final Runnable runnable, final Runnable runnable2) {
        if (cameraSession == null || surfaceTexture == null) {
            return;
        }
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$open$11(cameraSession, runnable2, surfaceTexture, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open$11(CameraSession cameraSession, Runnable runnable, SurfaceTexture surfaceTexture, Runnable runnable2) throws IOException {
        CameraInfo cameraInfo = cameraSession.cameraInfo;
        Camera camera = cameraInfo.camera;
        if (camera == null) {
            try {
                Camera cameraOpen = Camera.open(cameraInfo.cameraId);
                cameraInfo.camera = cameraOpen;
                camera = cameraOpen;
            } catch (Exception e) {
                cameraSession.cameraInfo.camera = null;
                if (camera != null) {
                    camera.release();
                }
                FileLog.e(e);
                return;
            }
        }
        List<String> supportedFlashModes = camera.getParameters().getSupportedFlashModes();
        this.availableFlashModes.clear();
        if (supportedFlashModes != null) {
            for (int i = 0; i < supportedFlashModes.size(); i++) {
                String str = supportedFlashModes.get(i);
                if (str.equals("off") || str.equals("on") || str.equals("auto")) {
                    this.availableFlashModes.add(str);
                }
            }
            cameraSession.checkFlashMode(this.availableFlashModes.get(0));
        }
        if (runnable != null) {
            runnable.run();
        }
        cameraSession.configurePhotoCamera();
        camera.setPreviewTexture(surfaceTexture);
        camera.startPreview();
        if (runnable2 != null) {
            AndroidUtilities.runOnUIThread(runnable2);
        }
    }

    public void recordVideo(final CameraSession cameraSession, final File file, final boolean z, final VideoTakeCallback videoTakeCallback, final Runnable runnable) {
        if (cameraSession == null) {
            return;
        }
        final CameraInfo cameraInfo = cameraSession.cameraInfo;
        final Camera camera = cameraInfo.camera;
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IOException, IllegalArgumentException {
                this.f$0.lambda$recordVideo$12(camera, cameraSession, z, file, cameraInfo, videoTakeCallback, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$recordVideo$12(Camera camera, CameraSession cameraSession, boolean z, File file, CameraInfo cameraInfo, VideoTakeCallback videoTakeCallback, Runnable runnable) throws IllegalStateException, IOException, IllegalArgumentException {
        if (camera != null) {
            try {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(cameraSession.getCurrentFlashMode().equals("on") ? "torch" : "off");
                    camera.setParameters(parameters);
                } catch (Exception e) {
                    FileLog.e(e);
                }
                camera.unlock();
                try {
                    this.mirrorRecorderVideo = z;
                    MediaRecorder mediaRecorder = new MediaRecorder();
                    this.recorder = mediaRecorder;
                    mediaRecorder.setCamera(camera);
                    this.recorder.setVideoSource(1);
                    this.recorder.setAudioSource(5);
                    cameraSession.configureRecorder(1, this.recorder);
                    this.recorder.setOutputFile(file.getAbsolutePath());
                    this.recorder.setMaxFileSize(1073741824L);
                    this.recorder.setVideoFrameRate(30);
                    this.recorder.setMaxDuration(0);
                    Size sizeChooseOptimalSize = chooseOptimalSize(cameraInfo.getPictureSizes(), 720, 480, new Size(16, 9));
                    this.recorder.setVideoEncodingBitRate(Math.min(sizeChooseOptimalSize.mHeight, sizeChooseOptimalSize.mWidth) >= 720 ? 3500000 : 1800000);
                    this.recorder.setVideoSize(sizeChooseOptimalSize.getWidth(), sizeChooseOptimalSize.getHeight());
                    this.recorder.setOnInfoListener(this);
                    this.recorder.prepare();
                    this.recorder.start();
                    this.onVideoTakeCallback = videoTakeCallback;
                    this.recordedFile = file.getAbsolutePath();
                    if (runnable != null) {
                        AndroidUtilities.runOnUIThread(runnable);
                    }
                } catch (Exception e2) {
                    this.recorder.release();
                    this.recorder = null;
                    FileLog.e(e2);
                }
            } catch (Exception e3) {
                FileLog.e(e3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void finishRecordingVideo() throws java.lang.Throwable {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L31
            r3.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L31
            java.lang.String r4 = r10.recordedFile     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            r3.setDataSource(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            r4 = 9
            java.lang.String r4 = r3.extractMetadata(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            if (r4 == 0) goto L24
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            float r4 = (float) r4     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r4 = r4 / r5
            double r4 = (double) r4     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            double r1 = java.lang.Math.ceil(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> Lc1
            int r1 = (int) r1
            long r1 = (long) r1
        L24:
            r3.release()     // Catch: java.lang.Exception -> L28
            goto L40
        L28:
            r3 = move-exception
            goto L3d
        L2a:
            r4 = move-exception
            goto L33
        L2c:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto Lc2
        L31:
            r4 = move-exception
            r3 = r0
        L33:
            org.rbmain.messenger.FileLog.e(r4)     // Catch: java.lang.Throwable -> Lc1
            if (r3 == 0) goto L40
            r3.release()     // Catch: java.lang.Exception -> L3c
            goto L40
        L3c:
            r3 = move-exception
        L3d:
            org.rbmain.messenger.FileLog.e(r3)
        L40:
            r8 = r1
            java.lang.String r1 = r10.recordedFile
            r2 = 1
            android.graphics.Bitmap r1 = org.rbmain.messenger.SendMessagesHelper.createVideoThumbnail(r1, r2)
            boolean r2 = r10.mirrorRecorderVideo
            if (r2 == 0) goto L7d
            int r2 = r1.getWidth()
            int r3 = r1.getHeight()
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r4)
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r2)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = r2.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            int r7 = r2.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            r3.scale(r4, r5, r6, r7)
            r4 = 0
            r3.drawBitmap(r1, r4, r4, r0)
            r1.recycle()
            r7 = r2
            goto L7e
        L7d:
            r7 = r1
        L7e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-2147483648_"
            r0.append(r1)
            int r1 = org.rbmain.messenger.SharedConfig.getLastLocalId()
            r0.append(r1)
            java.lang.String r1 = ".jpg"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r6 = new java.io.File
            r1 = 4
            java.io.File r1 = org.rbmain.messenger.FileLoader.getDirectory(r1)
            r6.<init>(r1, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Laf
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Laf
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> Laf
            r2 = 87
            r7.compress(r1, r2, r0)     // Catch: java.lang.Throwable -> Laf
            goto Lb3
        Laf:
            r0 = move-exception
            org.rbmain.messenger.FileLog.e(r0)
        Lb3:
            org.rbmain.messenger.SharedConfig.saveConfig()
            org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda6 r0 = new org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda6
            r4 = r0
            r5 = r10
            r4.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        Lc1:
            r0 = move-exception
        Lc2:
            if (r3 == 0) goto Lcc
            r3.release()     // Catch: java.lang.Exception -> Lc8
            goto Lcc
        Lc8:
            r1 = move-exception
            org.rbmain.messenger.FileLog.e(r1)
        Lcc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.camera.CameraController.finishRecordingVideo():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishRecordingVideo$13(File file, Bitmap bitmap, long j) {
        if (this.onVideoTakeCallback != null) {
            String absolutePath = file.getAbsolutePath();
            if (bitmap != null) {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), Utilities.MD5(absolutePath));
            }
            this.onVideoTakeCallback.onFinishVideoRecording(absolutePath, j);
            this.onVideoTakeCallback = null;
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws Throwable {
        if (i == 800 || i == 801 || i == 1) {
            MediaRecorder mediaRecorder2 = this.recorder;
            this.recorder = null;
            if (mediaRecorder2 != null) {
                mediaRecorder2.stop();
                mediaRecorder2.release();
            }
            if (this.onVideoTakeCallback != null) {
                finishRecordingVideo();
            }
        }
    }

    public void stopVideoRecording(final CameraSession cameraSession, final boolean z) {
        this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$stopVideoRecording$15(cameraSession, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopVideoRecording$15(final CameraSession cameraSession, boolean z) throws Throwable {
        MediaRecorder mediaRecorder;
        try {
            final Camera camera = cameraSession.cameraInfo.camera;
            if (camera != null && (mediaRecorder = this.recorder) != null) {
                this.recorder = null;
                try {
                    mediaRecorder.stop();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                try {
                    mediaRecorder.release();
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
                try {
                    camera.reconnect();
                    camera.startPreview();
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
                try {
                    cameraSession.stopVideoRecording();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode("off");
                camera.setParameters(parameters);
            } catch (Exception e5) {
                FileLog.e(e5);
            }
            this.threadPool.execute(new Runnable() { // from class: org.rbmain.messenger.camera.CameraController$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CameraController.lambda$stopVideoRecording$14(camera, cameraSession);
                }
            });
            if (!z && this.onVideoTakeCallback != null) {
                finishRecordingVideo();
            } else {
                this.onVideoTakeCallback = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopVideoRecording$14(Camera camera, CameraSession cameraSession) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(cameraSession.getCurrentFlashMode());
            camera.setParameters(parameters);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static Size chooseOptimalSize(List<Size> list, int i, int i2, Size size) {
        ArrayList arrayList = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Size size2 = list.get(i3);
            if (size2.getHeight() == (size2.getWidth() * height) / width && size2.getWidth() >= i && size2.getHeight() >= i2) {
                arrayList.add(size2);
            }
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, new CompareSizesByArea());
        }
        return (Size) Collections.max(list, new CompareSizesByArea());
    }

    static class CompareSizesByArea implements Comparator<Size> {
        CompareSizesByArea() {
        }

        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    }
}
