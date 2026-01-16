package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.sessionprocessor.a;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC6595Oe2;
import ir.nasim.DV0;
import ir.nasim.JN4;
import ir.nasim.PI3;
import ir.nasim.SF0;
import ir.nasim.V23;
import ir.nasim.WR7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class StillCaptureProcessor {
    private static final String TAG = "StillCaptureProcessor";
    private static final long UNSPECIFIED_TIMESTAMP = -1;
    SF0 mCaptureOutputSurface;
    final CaptureProcessorImpl mCaptureProcessorImpl;
    private boolean mIsPostviewConfigured;
    final a mCaptureResultImageMatcher = new a();
    final Object mLock = new Object();
    HashMap<Integer, Pair<V23, TotalCaptureResult>> mCaptureResults = new HashMap<>();
    OnCaptureResultCallback mOnCaptureResultCallback = null;
    TotalCaptureResult mSourceCaptureResult = null;
    boolean mIsClosed = false;
    long mTimeStampForOutputImage = -1;

    interface OnCaptureResultCallback {
        void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list);

        void onCaptureProcessProgressed(int i);

        void onError(Exception exc);

        void onProcessCompleted();
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, JN4 jn4, boolean z) {
        this.mCaptureProcessorImpl = captureProcessorImpl;
        SF0 sf0 = new SF0(surface, size, z);
        this.mCaptureOutputSurface = sf0;
        captureProcessorImpl.onOutputSurface(sf0.c(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        this.mIsPostviewConfigured = false;
        captureProcessorImpl.onResolutionUpdate(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public /* synthetic */ void lambda$process$1(boolean z, HashMap map, final OnCaptureResultCallback onCaptureResultCallback) {
        synchronized (this.mLock) {
            try {
                try {
                    try {
                    } catch (Exception e) {
                        PI3.d(TAG, "mCaptureProcessorImpl.process exception ", e);
                        this.mOnCaptureResultCallback = null;
                        if (onCaptureResultCallback != null) {
                            onCaptureResultCallback.onError(e);
                        }
                        PI3.a(TAG, "CaptureProcessorImpl.process() finish");
                        OnCaptureResultCallback onCaptureResultCallback2 = this.mOnCaptureResultCallback;
                        if (onCaptureResultCallback2 != null) {
                            onCaptureResultCallback2.onProcessCompleted();
                            this.mOnCaptureResultCallback = null;
                        }
                    }
                    if (this.mIsClosed) {
                        PI3.a(TAG, "Ignore process() in closed state.");
                        PI3.a(TAG, "CaptureProcessorImpl.process() finish");
                        OnCaptureResultCallback onCaptureResultCallback3 = this.mOnCaptureResultCallback;
                        if (onCaptureResultCallback3 != null) {
                            onCaptureResultCallback3.onProcessCompleted();
                            this.mOnCaptureResultCallback = null;
                        }
                        clearCaptureResults();
                        return;
                    }
                    PI3.a(TAG, "CaptureProcessorImpl.process() begin");
                    WR7 wr7 = WR7.e;
                    if (AbstractC6595Oe2.d(wr7) && DV0.c(wr7) && z && this.mIsPostviewConfigured) {
                        this.mCaptureProcessorImpl.processWithPostview(map, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.1
                            public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                                onCaptureResultCallback.onCaptureCompleted(j, list);
                            }

                            public void onCaptureProcessProgressed(int i) {
                                onCaptureResultCallback.onCaptureProcessProgressed(i);
                            }
                        }, AbstractC20567sE0.a());
                    } else {
                        WR7 wr72 = WR7.d;
                        if (AbstractC6595Oe2.d(wr72) && DV0.c(wr72)) {
                            this.mCaptureProcessorImpl.process(map, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.2
                                public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                                    onCaptureResultCallback.onCaptureCompleted(j, list);
                                }

                                public void onCaptureProcessProgressed(int i) {
                                    onCaptureResultCallback.onCaptureProcessProgressed(i);
                                }
                            }, AbstractC20567sE0.a());
                        } else {
                            this.mCaptureProcessorImpl.process(map);
                        }
                    }
                    PI3.a(TAG, "CaptureProcessorImpl.process() finish");
                    OnCaptureResultCallback onCaptureResultCallback4 = this.mOnCaptureResultCallback;
                    if (onCaptureResultCallback4 != null) {
                        onCaptureResultCallback4.onProcessCompleted();
                        this.mOnCaptureResultCallback = null;
                    }
                    clearCaptureResults();
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable th2) {
                PI3.a(TAG, "CaptureProcessorImpl.process() finish");
                OnCaptureResultCallback onCaptureResultCallback5 = this.mOnCaptureResultCallback;
                if (onCaptureResultCallback5 != null) {
                    onCaptureResultCallback5.onProcessCompleted();
                    this.mOnCaptureResultCallback = null;
                }
                clearCaptureResults();
                throw th2;
            }
        }
    }

    private /* synthetic */ void lambda$startCapture$0(List list, OnCaptureResultCallback onCaptureResultCallback, boolean z, V23 v23, TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            try {
                if (this.mIsClosed) {
                    v23.a();
                    PI3.a(TAG, "Ignore image in closed state");
                    return;
                }
                PI3.a(TAG, "onImageReferenceIncoming  captureStageId=" + i);
                this.mCaptureResults.put(Integer.valueOf(i), new Pair<>(v23, totalCaptureResult));
                PI3.a(TAG, "mCaptureResult has capture stage Id: " + this.mCaptureResults.keySet());
                if (this.mCaptureResults.keySet().containsAll(list)) {
                    process(this.mCaptureResults, onCaptureResultCallback, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void clearCaptureResults() {
        synchronized (this.mLock) {
            try {
                Iterator<Pair<V23, TotalCaptureResult>> it = this.mCaptureResults.values().iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next().first);
                    throw null;
                }
                this.mCaptureResults.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void close() {
        synchronized (this.mLock) {
            PI3.a(TAG, "Close the StillCaptureProcessor");
            this.mIsClosed = true;
            clearCaptureResults();
            this.mCaptureResultImageMatcher.e();
            this.mCaptureResultImageMatcher.d();
            this.mCaptureOutputSurface.b();
        }
    }

    void notifyCaptureResult(TotalCaptureResult totalCaptureResult, int i) {
        Long l;
        this.mCaptureResultImageMatcher.c(totalCaptureResult, i);
        if (this.mTimeStampForOutputImage == -1 && (l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)) != null) {
            long jLongValue = l.longValue();
            this.mTimeStampForOutputImage = jLongValue;
            this.mCaptureOutputSurface.e(jLongValue);
        }
        synchronized (this.mLock) {
            try {
                if (this.mSourceCaptureResult == null) {
                    this.mSourceCaptureResult = totalCaptureResult;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void notifyImage(V23 v23) {
        this.mCaptureResultImageMatcher.g(v23);
    }

    void process(Map<Integer, Pair<V23, TotalCaptureResult>> map, final OnCaptureResultCallback onCaptureResultCallback, final boolean z) {
        final HashMap map2 = new HashMap();
        synchronized (this.mLock) {
            Iterator<Integer> it = map.keySet().iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(map.get(it.next()).first);
                throw null;
            }
        }
        AbstractC20567sE0.b().execute(new Runnable() { // from class: androidx.camera.extensions.internal.sessionprocessor.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$process$1(z, map2, onCaptureResultCallback);
            }
        });
    }

    void startCapture(final boolean z, final List<Integer> list, final OnCaptureResultCallback onCaptureResultCallback) {
        PI3.a(TAG, "Start the capture: enablePostview=" + z);
        this.mTimeStampForOutputImage = -1L;
        synchronized (this.mLock) {
            AbstractC4980Hj5.j(!this.mIsClosed, "StillCaptureProcessor is closed. Can't invoke startCapture()");
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.d();
        this.mCaptureResultImageMatcher.k(new a.InterfaceC0018a() { // from class: androidx.camera.extensions.internal.sessionprocessor.f
        });
    }
}
