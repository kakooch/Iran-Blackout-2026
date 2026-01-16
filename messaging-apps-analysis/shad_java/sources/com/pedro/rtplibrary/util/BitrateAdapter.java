package com.pedro.rtplibrary.util;

/* loaded from: classes3.dex */
public class BitrateAdapter {
    private int averageBitrate;
    private int cont;
    private Listener listener;
    private int maxBitrate;
    private int oldBitrate;

    public interface Listener {
        void onBitrateAdapted(int i);
    }

    public BitrateAdapter(Listener listener) {
        this.listener = listener;
        reset();
    }

    public void setMaxBitrate(int i) {
        this.maxBitrate = i;
        this.oldBitrate = i;
        reset();
    }

    public void adaptBitrate(long j) {
        Listener listener;
        int i = (int) (this.averageBitrate + j);
        this.averageBitrate = i;
        int i2 = i / 2;
        this.averageBitrate = i2;
        int i3 = this.cont + 1;
        this.cont = i3;
        if (i3 < 5 || (listener = this.listener) == null || this.maxBitrate == 0) {
            return;
        }
        listener.onBitrateAdapted(getBitrateAdapted(i2));
        reset();
    }

    private int getBitrateAdapted(int i) {
        int i2 = this.maxBitrate;
        if (i >= i2) {
            this.oldBitrate = i2;
            return i2;
        }
        if (i <= this.oldBitrate * 0.9f) {
            double d = i;
            Double.isNaN(d);
            int i3 = (int) (d * 0.9d);
            this.oldBitrate = i3;
            return i3;
        }
        double d2 = i;
        Double.isNaN(d2);
        int i4 = (int) (d2 * 1.1d);
        this.oldBitrate = i4;
        if (i4 > i2) {
            this.oldBitrate = i2;
        }
        return this.oldBitrate;
    }

    public void reset() {
        this.averageBitrate = 0;
        this.cont = 0;
    }
}
