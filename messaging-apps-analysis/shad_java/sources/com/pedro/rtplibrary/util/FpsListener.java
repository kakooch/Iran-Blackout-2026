package com.pedro.rtplibrary.util;

/* loaded from: classes3.dex */
public class FpsListener {
    private Callback callback;
    private int fpsCont = 0;
    private long ts = System.currentTimeMillis();

    public interface Callback {
        void onFps(int i);
    }

    public void calculateFps() {
        this.fpsCont++;
        if (System.currentTimeMillis() - this.ts >= 1000) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onFps(this.fpsCont);
            }
            this.fpsCont = 0;
            this.ts = System.currentTimeMillis();
        }
    }
}
