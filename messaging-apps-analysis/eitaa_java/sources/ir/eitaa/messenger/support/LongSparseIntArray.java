package ir.eitaa.messenger.support;

/* loaded from: classes.dex */
public class LongSparseIntArray implements Cloneable {
    private long[] mKeys;
    private int mSize;
    private int[] mValues;

    public LongSparseIntArray() {
        this(10);
    }

    public LongSparseIntArray(int initialCapacity) {
        int iIdealLongArraySize = ArrayUtils.idealLongArraySize(initialCapacity);
        this.mKeys = new long[iIdealLongArraySize];
        this.mValues = new int[iIdealLongArraySize];
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseIntArray m16clone() {
        LongSparseIntArray longSparseIntArray = null;
        try {
            LongSparseIntArray longSparseIntArray2 = (LongSparseIntArray) super.clone();
            try {
                longSparseIntArray2.mKeys = (long[]) this.mKeys.clone();
                longSparseIntArray2.mValues = (int[]) this.mValues.clone();
                return longSparseIntArray2;
            } catch (CloneNotSupportedException unused) {
                longSparseIntArray = longSparseIntArray2;
                return longSparseIntArray;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public int get(long key) {
        return get(key, 0);
    }

    public int get(long key, int valueIfKeyNotFound) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        return iBinarySearch < 0 ? valueIfKeyNotFound : this.mValues[iBinarySearch];
    }

    public void delete(long key) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            removeAt(iBinarySearch);
        }
    }

    public void removeAt(int index) {
        long[] jArr = this.mKeys;
        int i = index + 1;
        System.arraycopy(jArr, i, jArr, index, this.mSize - i);
        int[] iArr = this.mValues;
        System.arraycopy(iArr, i, iArr, index, this.mSize - i);
        this.mSize--;
    }

    public void put(long key, int value) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = value;
            return;
        }
        int i = iBinarySearch ^ (-1);
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            growKeyAndValueArrays(i2 + 1);
        }
        int i3 = this.mSize;
        if (i3 - i != 0) {
            long[] jArr = this.mKeys;
            int i4 = i + 1;
            System.arraycopy(jArr, i, jArr, i4, i3 - i);
            int[] iArr = this.mValues;
            System.arraycopy(iArr, i, iArr, i4, this.mSize - i);
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize++;
    }

    public int size() {
        return this.mSize;
    }

    public long keyAt(int index) {
        return this.mKeys[index];
    }

    public int valueAt(int index) {
        return this.mValues[index];
    }

    public int indexOfKey(long key) {
        return binarySearch(this.mKeys, 0, this.mSize, key);
    }

    public int indexOfValue(long value) {
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.mSize = 0;
    }

    public void append(long key, int value) {
        int i = this.mSize;
        if (i != 0 && key <= this.mKeys[i - 1]) {
            put(key, value);
            return;
        }
        if (i >= this.mKeys.length) {
            growKeyAndValueArrays(i + 1);
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize = i + 1;
    }

    private void growKeyAndValueArrays(int minNeededSize) {
        int iIdealLongArraySize = ArrayUtils.idealLongArraySize(minNeededSize);
        long[] jArr = new long[iIdealLongArraySize];
        int[] iArr = new int[iIdealLongArraySize];
        long[] jArr2 = this.mKeys;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        int[] iArr2 = this.mValues;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.mKeys = jArr;
        this.mValues = iArr;
    }

    private static int binarySearch(long[] a, int start, int len, long key) {
        int i = len + start;
        int i2 = start - 1;
        int i3 = i;
        while (i3 - i2 > 1) {
            int i4 = (i3 + i2) / 2;
            if (a[i4] < key) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        return i3 == i ? i ^ (-1) : a[i3] == key ? i3 : i3 ^ (-1);
    }
}
