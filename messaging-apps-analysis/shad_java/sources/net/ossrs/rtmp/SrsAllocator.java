package net.ossrs.rtmp;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class SrsAllocator {
    private Allocation[] availableAllocations;
    private volatile int availableSentinel;
    private final int individualAllocationSize;

    public class Allocation {
        private byte[] data;
        private int size = 0;

        public Allocation(SrsAllocator srsAllocator, int i) {
            this.data = new byte[i];
        }

        public byte[] array() {
            return this.data;
        }

        public int size() {
            return this.size;
        }

        public void appendOffset(int i) {
            this.size += i;
        }

        public void clear() {
            this.size = 0;
        }

        public void put(byte b) {
            byte[] bArr = this.data;
            int i = this.size;
            this.size = i + 1;
            bArr[i] = b;
        }

        public void put(byte b, int i) {
            int i2 = i + 1;
            this.data[i] = b;
            int i3 = this.size;
            if (i2 <= i3) {
                i2 = i3;
            }
            this.size = i2;
        }
    }

    public SrsAllocator(int i) {
        this(i, 0);
    }

    public SrsAllocator(int i, int i2) {
        this.individualAllocationSize = i;
        this.availableSentinel = i2 + 10;
        this.availableAllocations = new Allocation[this.availableSentinel];
        for (int i3 = 0; i3 < this.availableSentinel; i3++) {
            this.availableAllocations[i3] = new Allocation(this, i);
        }
    }

    public synchronized Allocation allocate(int i) {
        for (int i2 = 0; i2 < this.availableSentinel; i2++) {
            if (this.availableAllocations[i2].size() >= i) {
                Allocation[] allocationArr = this.availableAllocations;
                Allocation allocation = allocationArr[i2];
                allocationArr[i2] = null;
                return allocation;
            }
        }
        int i3 = this.individualAllocationSize;
        if (i <= i3) {
            i = i3;
        }
        return new Allocation(this, i);
    }

    public synchronized void release(Allocation allocation) {
        allocation.clear();
        for (int i = 0; i < this.availableSentinel; i++) {
            if (this.availableAllocations[i].size() == 0) {
                this.availableAllocations[i] = allocation;
                return;
            }
        }
        int i2 = this.availableSentinel + 1;
        Allocation[] allocationArr = this.availableAllocations;
        if (i2 > allocationArr.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(allocationArr, allocationArr.length * 2);
        }
        Allocation[] allocationArr2 = this.availableAllocations;
        int i3 = this.availableSentinel;
        this.availableSentinel = i3 + 1;
        allocationArr2[i3] = allocation;
    }
}
