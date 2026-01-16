package org.webrtc;

import android.graphics.Matrix;
import org.webrtc.VideoFrame;

/* loaded from: classes3.dex */
interface CameraSession {

    public interface CreateSessionCallback {
        void onDone(CameraSession session);

        void onFailure(FailureType failureType, String error);
    }

    public interface Events {
        void onCameraClosed(CameraSession session);

        void onCameraDisconnected(CameraSession session);

        void onCameraError(CameraSession session, String error);

        void onCameraOpening();

        void onFrameCaptured(CameraSession session, VideoFrame frame);
    }

    public enum FailureType {
        ERROR,
        DISCONNECTED
    }

    void stop();

    /* renamed from: org.webrtc.CameraSession$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static VideoFrame.TextureBuffer createTextureBufferWithModifiedTransformMatrix(TextureBufferImpl buffer, boolean mirror, int rotation) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(0.5f, 0.5f);
            if (mirror) {
                matrix.preScale(-1.0f, 1.0f);
            }
            matrix.preRotate(rotation);
            matrix.preTranslate(-0.5f, -0.5f);
            return buffer.applyTransformMatrix(matrix, buffer.getWidth(), buffer.getHeight());
        }
    }
}
