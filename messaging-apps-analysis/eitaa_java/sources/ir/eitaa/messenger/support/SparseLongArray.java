package ir.eitaa.messenger.support;

/* loaded from: classes.dex */
public class SparseLongArray implements Cloneable {
    private int[] mKeys;
    private int mSize;
    private long[] mValues;

    public SparseLongArray() {
        this(10);
    }

    public SparseLongArray(int initialCapacity) {
        int iIdealLongArraySize = ArrayUtils.idealLongArraySize(initialCapacity);
        this.mKeys = new int[iIdealLongArraySize];
        this.mValues = new long[iIdealLongArraySize];
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseLongArray m18clone() {
        SparseLongArray sparseLongArray = null;
        try {
            SparseLongArray sparseLongArray2 = (SparseLongArray) super.clone();
            try {
                sparseLongArray2.mKeys = (int[]) this.mKeys.clone();
                sparseLongArray2.mValues = (long[]) this.mValues.clone();
                return sparseLongArray2;
            } catch (CloneNotSupportedException unused) {
                sparseLongArray = sparseLongArray2;
                return sparseLongArray;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public long get(int key) {
        return get(key, 0L);
    }

    public long get(int key, long valueIfKeyNotFound) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        return iBinarySearch < 0 ? valueIfKeyNotFound : this.mValues[iBinarySearch];
    }

    public void delete(int key) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            removeAt(iBinarySearch);
        }
    }

    public void removeAt(int index) {
        int[] iArr = this.mKeys;
        int i = index + 1;
        System.arraycopy(iArr, i, iArr, index, this.mSize - i);
        long[] jArr = this.mValues;
        System.arraycopy(jArr, i, jArr, index, this.mSize - i);
        this.mSize--;
    }

    public void put(int key, long value) {
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
            int[] iArr = this.mKeys;
            int i4 = i + 1;
            System.arraycopy(iArr, i, iArr, i4, i3 - i);
            long[] jArr = this.mValues;
            System.arraycopy(jArr, i, jArr, i4, this.mSize - i);
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize++;
    }

    public int size() {
        return this.mSize;
    }

    public int keyAt(int index) {
        return this.mKeys[index];
    }

    public long valueAt(int index) {
        return this.mValues[index];
    }

    public int indexOfKey(int key) {
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

    public void append(int key, long value) {
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
        int[] iArr = new int[iIdealLongArraySize];
        long[] jArr = new long[iIdealLongArraySize];
        int[] iArr2 = this.mKeys;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        long[] jArr2 = this.mValues;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        this.mKeys = iArr;
        this.mValues = jArr;
    }

    private static int binarySearch(int[] a, int start, int len, long key) {
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
        return i3 == i ? i ^ (-1) : ((long) a[i3]) == key ? i3 : i3 ^ (-1);
    }
}
