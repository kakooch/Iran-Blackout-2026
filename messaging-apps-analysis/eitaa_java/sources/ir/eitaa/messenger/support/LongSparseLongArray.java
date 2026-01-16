package ir.eitaa.messenger.support;

/* loaded from: classes.dex */
public class LongSparseLongArray implements Cloneable {
    private long[] mKeys;
    private int mSize;
    private long[] mValues;

    public LongSparseLongArray() {
        this(10);
    }

    public LongSparseLongArray(int initialCapacity) {
        int iIdealLongArraySize = ArrayUtils.idealLongArraySize(initialCapacity);
        this.mKeys = new long[iIdealLongArraySize];
        this.mValues = new long[iIdealLongArraySize];
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseLongArray m17clone() {
        LongSparseLongArray longSparseLongArray = null;
        try {
            LongSparseLongArray longSparseLongArray2 = (LongSparseLongArray) super.clone();
            try {
                longSparseLongArray2.mKeys = (long[]) this.mKeys.clone();
                longSparseLongArray2.mValues = (long[]) this.mValues.clone();
                return longSparseLongArray2;
            } catch (CloneNotSupportedException unused) {
                longSparseLongArray = longSparseLongArray2;
                return longSparseLongArray;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public long get(long key) {
        return get(key, 0L);
    }

    public long get(long key, long valueIfKeyNotFound) {
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
        long[] jArr2 = this.mValues;
        System.arraycopy(jArr2, i, jArr2, index, this.mSize - i);
        this.mSize--;
    }

    public void put(long key, long value) {
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
            long[] jArr2 = this.mValues;
            System.arraycopy(jArr2, i, jArr2, i4, this.mSize - i);
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

    public long valueAt(int index) {
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

    public void append(long key, long value) {
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
        long[] jArr2 = new long[iIdealLongArraySize];
        long[] jArr3 = this.mKeys;
        System.arraycopy(jArr3, 0, jArr, 0, jArr3.length);
        long[] jArr4 = this.mValues;
        System.arraycopy(jArr4, 0, jArr2, 0, jArr4.length);
        this.mKeys = jArr;
        this.mValues = jArr2;
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
