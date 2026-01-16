package org.linphone.mediastream.video.capture.hwconf;

import android.hardware.Camera;
import java.util.ArrayList;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;

/* loaded from: classes3.dex */
class AndroidCameraConfigurationReader9 {
    AndroidCameraConfigurationReader9() {
    }

    public static AndroidCameraConfiguration.AndroidCamera[] probeCameras() {
        ArrayList arrayList = new ArrayList(Camera.getNumberOfCameras());
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            Camera cameraOpen = Camera.open(i);
            boolean z = true;
            if (cameraInfo.facing != 1) {
                z = false;
            }
            arrayList.add(new AndroidCameraConfiguration.AndroidCamera(i, z, cameraInfo.orientation, cameraOpen.getParameters().getSupportedPreviewSizes()));
            cameraOpen.release();
        }
        return (AndroidCameraConfiguration.AndroidCamera[]) arrayList.toArray(new AndroidCameraConfiguration.AndroidCamera[arrayList.size()]);
    }
}
