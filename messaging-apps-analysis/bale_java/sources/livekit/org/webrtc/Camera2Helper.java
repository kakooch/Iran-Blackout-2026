package livekit.org.webrtc;

import android.hardware.camera2.CameraManager;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import livekit.org.webrtc.CameraEnumerationAndroid;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Llivekit/org/webrtc/Camera2Helper;", "", "()V", "Companion", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Camera2Helper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u000f"}, d2 = {"Llivekit/org/webrtc/Camera2Helper$Companion;", "", "()V", "findClosestCaptureFormat", "Llivekit/org/webrtc/Size;", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "cameraId", "", "width", "", "height", "getSupportedFormats", "", "Llivekit/org/webrtc/CameraEnumerationAndroid$CaptureFormat;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final Size findClosestCaptureFormat(CameraManager cameraManager, String cameraId, int width, int height) {
            List listM;
            AbstractC13042fc3.i(cameraManager, "cameraManager");
            List<CameraEnumerationAndroid.CaptureFormat> supportedFormats = getSupportedFormats(cameraManager, cameraId);
            if (supportedFormats != null) {
                List<CameraEnumerationAndroid.CaptureFormat> list = supportedFormats;
                listM = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (CameraEnumerationAndroid.CaptureFormat captureFormat : list) {
                    listM.add(new Size(captureFormat.width, captureFormat.height));
                }
            } else {
                listM = AbstractC10360bX0.m();
            }
            Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(listM, width, height);
            AbstractC13042fc3.h(closestSupportedSize, "getClosestSupportedSize(...)");
            return closestSupportedSize;
        }

        public final List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String cameraId) {
            AbstractC13042fc3.i(cameraManager, "cameraManager");
            return Camera2Enumerator.getSupportedFormats(cameraManager, cameraId);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }
}
