package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.extensions.impl.PreviewImageProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.sessionprocessor.a;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.AbstractC6595Oe2;
import ir.nasim.DV0;
import ir.nasim.PI3;
import ir.nasim.V23;
import ir.nasim.WR7;
import java.util.List;

/* loaded from: classes.dex */
class PreviewProcessor {
    private static final String TAG = "PreviewProcessor";
    private final PreviewImageProcessorImpl mPreviewImageProcessor;
    private final a mCaptureResultImageMatcher = new a();
    private final Object mLock = new Object();
    private boolean mIsClosed = false;
    private boolean mIsPaused = false;

    interface OnCaptureResultCallback {
        void onCaptureResult(long j, List<Pair<CaptureResult.Key, Object>> list);
    }

    PreviewProcessor(PreviewImageProcessorImpl previewImageProcessorImpl, Surface surface, Size size) {
        this.mPreviewImageProcessor = previewImageProcessorImpl;
        previewImageProcessorImpl.onResolutionUpdate(size);
        previewImageProcessorImpl.onOutputSurface(surface, 1);
        previewImageProcessorImpl.onImageFormatUpdate(35);
    }

    private /* synthetic */ void lambda$start$0(final OnCaptureResultCallback onCaptureResultCallback, V23 v23, TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            try {
                if (this.mIsClosed || this.mIsPaused) {
                    v23.a();
                    PI3.a(TAG, "Ignore image in closed or paused state");
                    return;
                }
                try {
                    WR7 wr7 = WR7.d;
                    if (DV0.c(wr7) && AbstractC6595Oe2.d(wr7)) {
                        this.mPreviewImageProcessor.process(v23.get(), totalCaptureResult, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor.1
                            public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                                onCaptureResultCallback.onCaptureResult(j, list);
                            }

                            public void onCaptureProcessProgressed(int i2) {
                            }
                        }, AbstractC20567sE0.b());
                    } else {
                        this.mPreviewImageProcessor.process(v23.get(), totalCaptureResult);
                    }
                    v23.a();
                } catch (Throwable th) {
                    v23.a();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    void close() {
        synchronized (this.mLock) {
            this.mIsClosed = true;
            this.mCaptureResultImageMatcher.d();
            this.mCaptureResultImageMatcher.e();
        }
    }

    void notifyCaptureResult(TotalCaptureResult totalCaptureResult) {
        this.mCaptureResultImageMatcher.b(totalCaptureResult);
    }

    void notifyImage(V23 v23) {
        this.mCaptureResultImageMatcher.g(v23);
    }

    void pause() {
        synchronized (this.mLock) {
            this.mIsPaused = true;
        }
    }

    void resume() {
        synchronized (this.mLock) {
            this.mIsPaused = false;
        }
    }

    void start(final OnCaptureResultCallback onCaptureResultCallback) {
        this.mCaptureResultImageMatcher.k(new a.InterfaceC0018a() { // from class: androidx.camera.extensions.internal.sessionprocessor.c
        });
    }
}
