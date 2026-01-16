package livekit.org.webrtc;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import livekit.org.webrtc.VideoFrame;

/* loaded from: classes8.dex */
interface CameraSession {

    public interface CreateSessionCallback {
        void onDone(CameraSession cameraSession);

        void onFailure(FailureType failureType, String str);
    }

    public interface Events {
        void onCameraClosed(CameraSession cameraSession);

        void onCameraDisconnected(CameraSession cameraSession);

        void onCameraError(CameraSession cameraSession, String str);

        void onCameraOpening();

        void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame);
    }

    public enum FailureType {
        ERROR,
        DISCONNECTED
    }

    static VideoFrame.TextureBuffer createTextureBufferWithModifiedTransformMatrix(TextureBufferImpl textureBufferImpl, boolean z, int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    static int getDeviceOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            return rotation != 2 ? rotation != 3 ? 0 : 270 : SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        }
        return 90;
    }

    void stop();
}
