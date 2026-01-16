package org.linphone.mediastream.video.capture.hwconf;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import java.util.ArrayList;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;

/* loaded from: classes3.dex */
public class AndroidCameraConfigurationReader21 {
    @TargetApi(21)
    public static AndroidCameraConfiguration.AndroidCamera[] probeCameras() throws CameraAccessException {
        Context context = MediastreamerAndroidContext.getContext();
        if (context != null) {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            try {
                String[] cameraIdList = cameraManager.getCameraIdList();
                ArrayList arrayList = new ArrayList(cameraIdList.length);
                int length = 2;
                if (cameraIdList.length <= 2) {
                    length = cameraIdList.length;
                }
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i2]);
                    boolean z = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
                    int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                    Size[] outputSizes = ((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class);
                    ArrayList arrayList2 = new ArrayList(outputSizes.length);
                    for (Size size : outputSizes) {
                        arrayList2.add(new AndroidCameraConfiguration.AndroidCamera.Size(size.getWidth(), size.getHeight()));
                    }
                    arrayList.add(new AndroidCameraConfiguration.AndroidCamera(i2, z, arrayList2, iIntValue));
                    i++;
                }
                return (AndroidCameraConfiguration.AndroidCamera[]) arrayList.toArray(new AndroidCameraConfiguration.AndroidCamera[i]);
            } catch (CameraAccessException e) {
                Log.e(e);
            }
        }
        return new AndroidCameraConfiguration.AndroidCamera[0];
    }
}
