package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface ShuffleOrder {
    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int index);

    int getPreviousIndex(int index);

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int index) {
            int i = index - 1;
            if (i >= 0) {
                return i;
            }
            return -1;
        }

        public UnshuffledShuffleOrder(int length) {
            this.length = length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int index) {
            int i = index + 1;
            if (i < this.length) {
                return i;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int i = this.length;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.length > 0 ? 0 : -1;
        }
    }
}
