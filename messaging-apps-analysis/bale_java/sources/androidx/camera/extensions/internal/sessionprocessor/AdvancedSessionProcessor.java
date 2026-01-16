package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.j;
import androidx.camera.extensions.impl.advanced.ImageProcessorImpl;
import androidx.camera.extensions.impl.advanced.ImageReferenceImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceConfigurationImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceImpl;
import androidx.camera.extensions.impl.advanced.RequestProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.C14935ij7;
import ir.nasim.C19516qU5;
import ir.nasim.C20298rm4;
import ir.nasim.InterfaceC12025du6;
import ir.nasim.InterfaceC24953zU5;
import ir.nasim.JN4;
import ir.nasim.KN4;
import ir.nasim.LB0;
import ir.nasim.QB0;
import ir.nasim.V23;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class AdvancedSessionProcessor extends d {

    private static class CallbackAdapter implements InterfaceC24953zU5.a {
        private final RequestProcessorImpl.Callback mCallback;

        CallbackAdapter(RequestProcessorImpl.Callback callback) {
            this.mCallback = callback;
        }

        private RequestProcessorImpl.Request getImplRequest(InterfaceC24953zU5.b bVar) {
            AbstractC4980Hj5.a(bVar instanceof RequestAdapter);
            return ((RequestAdapter) bVar).getImplRequest();
        }

        public void onCaptureBufferLost(InterfaceC24953zU5.b bVar, long j, int i) {
            this.mCallback.onCaptureBufferLost(getImplRequest(bVar), j, i);
        }

        public void onCaptureCompleted(InterfaceC24953zU5.b bVar, QB0 qb0) {
            CaptureResult captureResultD = qb0.d();
            AbstractC4980Hj5.b(captureResultD instanceof TotalCaptureResult, "CaptureResult in cameraCaptureResult is not a TotalCaptureResult");
            this.mCallback.onCaptureCompleted(getImplRequest(bVar), (TotalCaptureResult) captureResultD);
        }

        public void onCaptureFailed(InterfaceC24953zU5.b bVar, LB0 lb0) {
            Object objA = lb0.a();
            AbstractC4980Hj5.b(objA instanceof CaptureFailure, "CameraCaptureFailure does not contain CaptureFailure.");
            this.mCallback.onCaptureFailed(getImplRequest(bVar), (CaptureFailure) objA);
        }

        public void onCaptureProgressed(InterfaceC24953zU5.b bVar, QB0 qb0) {
            CaptureResult captureResultD = qb0.d();
            AbstractC4980Hj5.b(captureResultD != null, "Cannot get CaptureResult from the cameraCaptureResult ");
            this.mCallback.onCaptureProgressed(getImplRequest(bVar), captureResultD);
        }

        public void onCaptureSequenceAborted(int i) {
            this.mCallback.onCaptureSequenceAborted(i);
        }

        public void onCaptureSequenceCompleted(int i, long j) {
            this.mCallback.onCaptureSequenceCompleted(i, j);
        }

        public void onCaptureStarted(InterfaceC24953zU5.b bVar, long j, long j2) {
            this.mCallback.onCaptureStarted(getImplRequest(bVar), j, j2);
        }
    }

    private static class ExtensionMetadataMonitor {
        private final C20298rm4 mCurrentExtensionTypeLiveData;
        private final C20298rm4 mExtensionStrengthLiveData;

        ExtensionMetadataMonitor(C20298rm4 c20298rm4, C20298rm4 c20298rm42) {
            this.mCurrentExtensionTypeLiveData = c20298rm4;
            this.mExtensionStrengthLiveData = c20298rm42;
        }

        private int convertExtensionMode(int i) {
            if (i == 0) {
                return 5;
            }
            if (i == 1) {
                return 4;
            }
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                return i != 4 ? 0 : 3;
            }
            return 2;
        }

        void checkExtensionMetadata(Map<CaptureResult.Key, Object> map) {
            Object obj;
            Object obj2;
            if (Build.VERSION.SDK_INT >= 34) {
                if (this.mCurrentExtensionTypeLiveData != null && (obj2 = map.get(CaptureResult.EXTENSION_CURRENT_TYPE)) != null) {
                    Integer num = (Integer) obj2;
                    if (!Objects.equals(this.mCurrentExtensionTypeLiveData.f(), Integer.valueOf(convertExtensionMode(num.intValue())))) {
                        this.mCurrentExtensionTypeLiveData.n(Integer.valueOf(convertExtensionMode(num.intValue())));
                    }
                }
                if (this.mExtensionStrengthLiveData == null || (obj = map.get(CaptureResult.EXTENSION_STRENGTH)) == null || Objects.equals(this.mExtensionStrengthLiveData.f(), obj)) {
                    return;
                }
                this.mExtensionStrengthLiveData.n((Integer) obj);
            }
        }
    }

    private static class ImageProcessorAdapter {
        private final ImageProcessorImpl mImpl;

        ImageProcessorAdapter(ImageProcessorImpl imageProcessorImpl) {
            this.mImpl = imageProcessorImpl;
        }

        public void onNextImageAvailable(int i, long j, V23 v23, String str) {
            this.mImpl.onNextImageAvailable(i, j, new ImageReferenceImplAdapter(v23), str);
        }
    }

    private static class ImageReferenceImplAdapter implements ImageReferenceImpl {
        private final V23 mImageReference;

        ImageReferenceImplAdapter(V23 v23) {
        }

        public boolean decrement() {
            throw null;
        }

        public Image get() {
            throw null;
        }

        public boolean increment() {
            throw null;
        }
    }

    private static class OutputSurfaceConfigurationImplAdapter implements OutputSurfaceConfigurationImpl {
        private final OutputSurfaceImpl mAnalysisOutputSurface;
        private final OutputSurfaceImpl mCaptureOutputSurface;
        private final OutputSurfaceImpl mPostviewOutputSurface;
        private final OutputSurfaceImpl mPreviewOutputSurface;

        OutputSurfaceConfigurationImplAdapter(KN4 kn4) {
            this.mPreviewOutputSurface = new OutputSurfaceImplAdapter(kn4.d());
            this.mCaptureOutputSurface = new OutputSurfaceImplAdapter(kn4.b());
            kn4.a();
            this.mAnalysisOutputSurface = null;
            kn4.c();
            this.mPostviewOutputSurface = null;
        }

        public OutputSurfaceImpl getImageAnalysisOutputSurface() {
            return this.mAnalysisOutputSurface;
        }

        public OutputSurfaceImpl getImageCaptureOutputSurface() {
            return this.mCaptureOutputSurface;
        }

        public OutputSurfaceImpl getPostviewOutputSurface() {
            return this.mPostviewOutputSurface;
        }

        public OutputSurfaceImpl getPreviewOutputSurface() {
            return this.mPreviewOutputSurface;
        }
    }

    private static class OutputSurfaceImplAdapter implements OutputSurfaceImpl {
        private final JN4 mOutputSurface;

        OutputSurfaceImplAdapter(JN4 jn4) {
        }

        public int getImageFormat() {
            return this.mOutputSurface.a();
        }

        public Size getSize() {
            return this.mOutputSurface.b();
        }

        public Surface getSurface() {
            return this.mOutputSurface.c();
        }
    }

    private static class RequestAdapter implements InterfaceC24953zU5.b {
        private final RequestProcessorImpl.Request mImplRequest;
        private final j mParameters;
        private final List<Integer> mTargetOutputConfigIds;
        private final int mTemplateId;

        RequestAdapter(RequestProcessorImpl.Request request) {
            this.mImplRequest = request;
            ArrayList arrayList = new ArrayList();
            Iterator it = request.getTargetOutputConfigIds().iterator();
            while (it.hasNext()) {
                arrayList.add((Integer) it.next());
            }
            this.mTargetOutputConfigIds = arrayList;
            C19516qU5.b bVar = new C19516qU5.b();
            for (CaptureRequest.Key key : request.getParameters().keySet()) {
                bVar.b(key, request.getParameters().get(key));
            }
            this.mParameters = bVar.a();
            this.mTemplateId = request.getTemplateId().intValue();
        }

        public RequestProcessorImpl.Request getImplRequest() {
            return this.mImplRequest;
        }

        public j getParameters() {
            return this.mParameters;
        }

        public List<Integer> getTargetOutputConfigIds() {
            return this.mTargetOutputConfigIds;
        }

        public int getTemplateId() {
            return this.mTemplateId;
        }
    }

    private class RequestProcessorImplAdapter implements RequestProcessorImpl {
        private final InterfaceC24953zU5 mRequestProcessor;
        final /* synthetic */ AdvancedSessionProcessor this$0;

        RequestProcessorImplAdapter(AdvancedSessionProcessor advancedSessionProcessor, InterfaceC24953zU5 interfaceC24953zU5) {
        }

        public void abortCaptures() {
            this.mRequestProcessor.a();
        }

        public void setImageProcessor(int i, ImageProcessorImpl imageProcessorImpl) {
            new ImageProcessorAdapter(imageProcessorImpl);
            throw null;
        }

        public int setRepeating(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.f(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public void stopRepeating() {
            this.mRequestProcessor.d();
        }

        public int submit(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.e(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public int submit(List<RequestProcessorImpl.Request> list, RequestProcessorImpl.Callback callback) {
            ArrayList arrayList = new ArrayList();
            Iterator<RequestProcessorImpl.Request> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new RequestAdapter(it.next()));
            }
            return this.mRequestProcessor.g(arrayList, new CallbackAdapter(callback));
        }
    }

    private static class SessionProcessorImplCaptureCallbackAdapter implements SessionProcessorImpl.CaptureCallback {
        private final InterfaceC12025du6.a mCaptureCallback;
        private final ExtensionMetadataMonitor mExtensionMetadataMonitor;
        private long mOnCaptureStartedTimestamp;
        private final C14935ij7 mTagBundle;
        private boolean mWillReceiveOnCaptureCompleted;

        SessionProcessorImplCaptureCallbackAdapter(InterfaceC12025du6.a aVar, C14935ij7 c14935ij7, boolean z) {
            this(aVar, c14935ij7, null, z);
        }

        public void onCaptureCompleted(long j, int i, Map<CaptureResult.Key, Object> map) {
            ExtensionMetadataMonitor extensionMetadataMonitor = this.mExtensionMetadataMonitor;
            if (extensionMetadataMonitor != null) {
                extensionMetadataMonitor.checkExtensionMetadata(map);
            }
            if (this.mWillReceiveOnCaptureCompleted) {
                this.mCaptureCallback.d(j, i, new b(j, this.mTagBundle, map));
                this.mCaptureCallback.a(i);
            }
        }

        public void onCaptureFailed(int i) {
            this.mCaptureCallback.b(i);
        }

        public void onCaptureProcessProgressed(int i) {
            this.mCaptureCallback.onCaptureProcessProgressed(i);
        }

        public void onCaptureProcessStarted(int i) {
            this.mCaptureCallback.f(i);
        }

        public void onCaptureSequenceAborted(int i) {
            this.mCaptureCallback.e(i);
        }

        public void onCaptureSequenceCompleted(int i) {
            if (this.mWillReceiveOnCaptureCompleted) {
                return;
            }
            InterfaceC12025du6.a aVar = this.mCaptureCallback;
            long j = this.mOnCaptureStartedTimestamp;
            aVar.d(j, i, new b(j, this.mTagBundle, Collections.emptyMap()));
            this.mCaptureCallback.a(i);
        }

        public void onCaptureStarted(int i, long j) {
            this.mOnCaptureStartedTimestamp = j;
            this.mCaptureCallback.c(i, j);
        }

        SessionProcessorImplCaptureCallbackAdapter(InterfaceC12025du6.a aVar, C14935ij7 c14935ij7, ExtensionMetadataMonitor extensionMetadataMonitor, boolean z) {
            this.mOnCaptureStartedTimestamp = -1L;
            this.mTagBundle = c14935ij7;
            this.mExtensionMetadataMonitor = extensionMetadataMonitor;
            this.mWillReceiveOnCaptureCompleted = z;
        }
    }
}
