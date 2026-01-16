package org.webrtc;

/* loaded from: classes3.dex */
interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    int getCodecConfigFramerate();

    void reportEncodedFrame(int size);

    void setTargets(int targetBitrateBps, int targetFps);
}
