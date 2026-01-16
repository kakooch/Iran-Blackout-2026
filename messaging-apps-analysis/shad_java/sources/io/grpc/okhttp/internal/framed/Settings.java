package io.grpc.okhttp.internal.framed;

/* loaded from: classes3.dex */
public final class Settings {
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    public Settings set(int i, int i2, int i3) {
        int[] iArr = this.values;
        if (i >= iArr.length) {
            return this;
        }
        int i4 = 1 << i;
        this.set |= i4;
        if ((i2 & 1) != 0) {
            this.persistValue |= i4;
        } else {
            this.persistValue &= i4 ^ (-1);
        }
        if ((i2 & 2) != 0) {
            this.persisted |= i4;
        } else {
            this.persisted &= i4 ^ (-1);
        }
        iArr[i] = i3;
        return this;
    }

    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    public int get(int i) {
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

    int getMaxFrameSize(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }
}
