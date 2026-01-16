package com.pedro.encoder.input.video;

import com.facebook.stetho.websocket.CloseCodes;

/* loaded from: classes3.dex */
public class FpsLimiter {
    private long startTS = System.currentTimeMillis();
    private long ratioF = 33;
    private long ratio = 33;

    public void setFPS(int i) {
        this.startTS = System.currentTimeMillis();
        long j = CloseCodes.NORMAL_CLOSURE / i;
        this.ratioF = j;
        this.ratio = j;
    }

    public boolean limitFPS() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTS;
        long j = this.ratio;
        if (j >= jCurrentTimeMillis) {
            return true;
        }
        this.ratio = j + this.ratioF;
        return false;
    }
}
