package org.webrtc;

import android.view.OrientationEventListener;
import ir.eitaa.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class OrientationHelper {
    private static final int ORIENTATION_HYSTERESIS = 5;
    public static volatile int cameraOrientation;
    public static volatile int cameraRotation;
    private OrientationEventListener orientationEventListener = new OrientationEventListener(ApplicationLoader.applicationContext) { // from class: org.webrtc.OrientationHelper.1
        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            if (OrientationHelper.this.orientationEventListener == null || orientation == -1) {
                return;
            }
            OrientationHelper orientationHelper = OrientationHelper.this;
            int iRoundOrientation = orientationHelper.roundOrientation(orientation, orientationHelper.rotation);
            if (iRoundOrientation != OrientationHelper.this.rotation) {
                OrientationHelper orientationHelper2 = OrientationHelper.this;
                orientationHelper2.onOrientationUpdate(orientationHelper2.rotation = iRoundOrientation);
            }
        }
    };
    private int rotation;

    protected void onOrientationUpdate(int orientation) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int roundOrientation(int orientation, int orientationHistory) {
        boolean z = true;
        if (orientationHistory != -1) {
            int iAbs = Math.abs(orientation - orientationHistory);
            if (Math.min(iAbs, 360 - iAbs) < 50) {
                z = false;
            }
        }
        return z ? (((orientation + 45) / 90) * 90) % 360 : orientationHistory;
    }

    public void start() {
        if (this.orientationEventListener.canDetectOrientation()) {
            this.orientationEventListener.enable();
        } else {
            this.orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    public void stop() {
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    public int getOrientation() {
        return this.rotation;
    }
}
