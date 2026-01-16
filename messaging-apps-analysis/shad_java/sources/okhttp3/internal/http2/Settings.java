package okhttp3.internal.http2;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class Settings {
    private int set;
    private final int[] values = new int[10];

    void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    Settings set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i < iArr.length) {
                this.set = (1 << i) | this.set;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    int get(int i) {
        return this.values[i];
    }

    int size() {
        return Integer.bitCount(this.set);
    }

    int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    int getMaxConcurrentStreams(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.get(i));
            }
        }
    }
}
