package ir.appp.rghapp.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Looper;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes3.dex */
public class SSHMediaPhotoConvertor extends Thread {
    private final Context context;
    public Bitmap currentBitmap;
    private final MediaController.SSHMediaConvertRequest mediaConvertRequest;
    private int orientation;

    public SSHMediaPhotoConvertor(Context context, MediaController.SSHMediaConvertRequest sSHMediaConvertRequest) {
        this.context = context;
        this.mediaConvertRequest = sSHMediaConvertRequest;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = sSHMediaConvertRequest.media;
        this.currentBitmap = rGHMediaHelper$PhotoEntry.bitmap;
        int i = rGHMediaHelper$PhotoEntry.orientation;
        this.orientation = i;
        if (i != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.orientation);
            Bitmap bitmap = this.currentBitmap;
            this.currentBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.currentBitmap.getHeight(), matrix, true);
            this.orientation = 0;
        }
    }

    private void drawFrame() {
        MediaController mediaController = MediaController.getInstance();
        Context context = this.context;
        MediaController.SSHMediaConvertRequest sSHMediaConvertRequest = this.mediaConvertRequest;
        mediaController.didWriteData(context, sSHMediaConvertRequest, sSHMediaConvertRequest.cacheFile, true, 0L, 0L, false, 1.0f);
        try {
            Bitmap texture = getTexture();
            MediaController.SSHMediaConvertRequest sSHMediaConvertRequest2 = this.mediaConvertRequest;
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = sSHMediaConvertRequest2.media;
            SSHCropView.SSHCropState sSHCropState = rGHMediaHelper$PhotoEntry.cropState;
            VideoEditedInfo videoEditedInfo = rGHMediaHelper$PhotoEntry.editedInfo;
            ImageLoader.saveFilteredBitmap(texture, sSHCropState, videoEditedInfo.resultWidth, videoEditedInfo.resultHeight, sSHMediaConvertRequest2.cacheFile, videoEditedInfo.quality);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaController.getInstance().cancelVideoConvert(this.mediaConvertRequest.postRnd);
        shutdown();
    }

    public void finish() {
        this.currentBitmap = null;
    }

    public Bitmap getTexture() {
        return this.currentBitmap;
    }

    public void shutdown() {
        finish();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        drawFrame();
    }
}
