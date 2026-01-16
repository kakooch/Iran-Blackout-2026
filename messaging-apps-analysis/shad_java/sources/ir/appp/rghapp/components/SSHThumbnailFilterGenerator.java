package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import ir.appp.rghapp.components.SSHThumbnailFilterGLThread;
import java.lang.Thread;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SSHThumbnailFilterGenerator implements SSHThumbnailFilterGLThread.ThumbnailGLThreadListener {
    private SSHThumbnailFilterGLThread eglThread;
    FilteredThumbnailGeneratorListener filteredThumbnailGeneratorListener;
    private Bitmap imageBitmap;
    Runnable generateFilteredImageRunnable = new Runnable() { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGenerator.1
        @Override // java.lang.Runnable
        public void run() {
            SSHThumbnailFilterGenerator sSHThumbnailFilterGenerator = SSHThumbnailFilterGenerator.this;
            FilteredThumbnailGeneratorListener filteredThumbnailGeneratorListener = sSHThumbnailFilterGenerator.filteredThumbnailGeneratorListener;
            if (filteredThumbnailGeneratorListener != null) {
                filteredThumbnailGeneratorListener.onFilteredBitmapReady(sSHThumbnailFilterGenerator.eglThread.getTexture(), SSHThumbnailFilterGenerator.this.currentFilter);
            }
            if (SSHThumbnailFilterGenerator.this.generatedBitmapsCount <= 17) {
                SSHThumbnailFilterGenerator sSHThumbnailFilterGenerator2 = SSHThumbnailFilterGenerator.this;
                sSHThumbnailFilterGenerator2.currentFilter = sSHThumbnailFilterGenerator2.generatedBitmapsCount;
                SSHThumbnailFilterGenerator.this.eglThread.getThumbnailFilterShader().setFilterType(SSHThumbnailFilterGenerator.this.currentFilter, 1.0f);
                SSHThumbnailFilterGenerator.this.eglThread.requestRender(true, false);
            } else {
                AndroidUtilities.cancelRunOnUIThread(SSHThumbnailFilterGenerator.this.generateFilteredImageRunnable);
                SSHThumbnailFilterGenerator.this.destroyProcess();
            }
            SSHThumbnailFilterGenerator.access$212(SSHThumbnailFilterGenerator.this, 1);
        }
    };
    private int generatedBitmapsCount = 0;
    private int currentFilter = 0;

    public interface FilteredThumbnailGeneratorListener {
        void onFilteredBitmapReady(Bitmap bitmap, int i);
    }

    static /* synthetic */ int access$212(SSHThumbnailFilterGenerator sSHThumbnailFilterGenerator, int i) {
        int i2 = sSHThumbnailFilterGenerator.generatedBitmapsCount + i;
        sSHThumbnailFilterGenerator.generatedBitmapsCount = i2;
        return i2;
    }

    public SSHThumbnailFilterGenerator(Context context, SurfaceTexture surfaceTexture, Bitmap bitmap, boolean z, FilteredThumbnailGeneratorListener filteredThumbnailGeneratorListener) {
        this.filteredThumbnailGeneratorListener = filteredThumbnailGeneratorListener;
        this.imageBitmap = bitmap;
        SSHThumbnailFilterGLThread sSHThumbnailFilterGLThread = new SSHThumbnailFilterGLThread(0, context, surfaceTexture, this.imageBitmap, z, 0, this);
        this.eglThread = sSHThumbnailFilterGLThread;
        sSHThumbnailFilterGLThread.getThumbnailFilterShader().setFilterType(this.currentFilter, 1.0f);
        this.eglThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(this) { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGenerator.2
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                th.printStackTrace();
            }
        });
    }

    public void startProcess() {
        this.eglThread.requestRender(true, true);
    }

    public void destroyProcess() {
        SSHThumbnailFilterGLThread sSHThumbnailFilterGLThread = this.eglThread;
        if (sSHThumbnailFilterGLThread != null) {
            sSHThumbnailFilterGLThread.shutdown();
            this.eglThread = null;
        }
        Bitmap bitmap = this.imageBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.imageBitmap.recycle();
        }
        this.currentFilter = 0;
        this.imageBitmap = null;
    }

    @Override // ir.appp.rghapp.components.SSHThumbnailFilterGLThread.ThumbnailGLThreadListener
    public void onRenderDataAvailable(int i) {
        AndroidUtilities.runOnUIThread(this.generateFilteredImageRunnable, 10L);
    }
}
