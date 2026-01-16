package ir.nasim;

/* loaded from: classes2.dex */
public enum QN5 {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    public boolean j(int i, boolean z, int i2) {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal != 2) {
            return (z && i < 28) || i2 > 4 || i <= 25;
        }
        return true;
    }
}
