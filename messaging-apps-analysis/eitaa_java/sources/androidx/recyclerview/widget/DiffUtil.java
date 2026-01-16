package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new AnonymousClass1();

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int oldItemPosition, int newItemPosition);

        public abstract boolean areItemsTheSame(int oldItemPosition, int newItemPosition);

        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* renamed from: androidx.recyclerview.widget.DiffUtil$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Snake>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass1() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Snake o1, Snake o2) {
            int i = o1.x - o2.x;
            return i == 0 ? o1.y - o2.y : i;
        }
    }

    public static DiffResult calculateDiff(Callback cb) {
        return calculateDiff(cb, true);
    }

    public static DiffResult calculateDiff(Callback cb, boolean detectMoves) {
        int oldListSize = cb.getOldListSize();
        int newListSize = cb.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int iAbs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i = iAbs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeDiffPartial = diffPartial(cb, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, iAbs);
            if (snakeDiffPartial != null) {
                if (snakeDiffPartial.size > 0) {
                    arrayList.add(snakeDiffPartial);
                }
                snakeDiffPartial.x += range.oldListStart;
                snakeDiffPartial.y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (snakeDiffPartial.reverse) {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y;
                } else if (snakeDiffPartial.removal) {
                    range2.oldListEnd = snakeDiffPartial.x - 1;
                    range2.newListEnd = snakeDiffPartial.y;
                } else {
                    range2.oldListEnd = snakeDiffPartial.x;
                    range2.newListEnd = snakeDiffPartial.y - 1;
                }
                arrayList2.add(range2);
                if (snakeDiffPartial.reverse) {
                    if (snakeDiffPartial.removal) {
                        int i2 = snakeDiffPartial.x;
                        int i3 = snakeDiffPartial.size;
                        range.oldListStart = i2 + i3 + 1;
                        range.newListStart = snakeDiffPartial.y + i3;
                    } else {
                        int i4 = snakeDiffPartial.x;
                        int i5 = snakeDiffPartial.size;
                        range.oldListStart = i4 + i5;
                        range.newListStart = snakeDiffPartial.y + i5 + 1;
                    }
                } else {
                    int i6 = snakeDiffPartial.x;
                    int i7 = snakeDiffPartial.size;
                    range.oldListStart = i6 + i7;
                    range.newListStart = snakeDiffPartial.y + i7;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(cb, arrayList, iArr, iArr2, detectMoves);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00cd
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.recyclerview.widget.DiffUtil.Snake diffPartial(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.diffPartial(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        Snake() {
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int oldListStart, int oldListEnd, int newListStart, int newListEnd) {
            this.oldListStart = oldListStart;
            this.oldListEnd = oldListEnd;
            this.newListStart = newListStart;
            this.newListEnd = newListEnd;
        }
    }

    public static class DiffResult {
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> snakes, int[] oldItemStatuses, int[] newItemStatuses, boolean detectMoves) {
            this.mSnakes = snakes;
            this.mOldItemStatuses = oldItemStatuses;
            this.mNewItemStatuses = newItemStatuses;
            Arrays.fill(oldItemStatuses, 0);
            Arrays.fill(newItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = detectMoves;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.x == 0 && snake.y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.x = 0;
            snake2.y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.x;
                int i4 = snake.size;
                int i5 = i3 + i4;
                int i6 = snake.y + i4;
                if (this.mDetectMoves) {
                    while (i > i5) {
                        findAddition(i, i2, size);
                        i--;
                    }
                    while (i2 > i6) {
                        findRemoval(i, i2, size);
                        i2--;
                    }
                }
                for (int i7 = 0; i7 < snake.size; i7++) {
                    int i8 = snake.x + i7;
                    int i9 = snake.y + i7;
                    int i10 = this.mCallback.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.mOldItemStatuses[i8] = (i9 << 5) | i10;
                    this.mNewItemStatuses[i9] = (i8 << 5) | i10;
                }
                i = snake.x;
                i2 = snake.y;
            }
        }

        private void findAddition(int x, int y, int snakeIndex) {
            if (this.mOldItemStatuses[x - 1] != 0) {
                return;
            }
            findMatchingItem(x, y, snakeIndex, false);
        }

        private void findRemoval(int x, int y, int snakeIndex) {
            if (this.mNewItemStatuses[y - 1] != 0) {
                return;
            }
            findMatchingItem(x, y, snakeIndex, true);
        }

        private boolean findMatchingItem(final int x, final int y, final int snakeIndex, final boolean removal) {
            int i;
            int i2;
            int i3;
            if (removal) {
                y--;
                i2 = x;
                i = y;
            } else {
                i = x - 1;
                i2 = i;
            }
            while (snakeIndex >= 0) {
                Snake snake = this.mSnakes.get(snakeIndex);
                int i4 = snake.x;
                int i5 = snake.size;
                int i6 = i4 + i5;
                int i7 = snake.y + i5;
                if (removal) {
                    for (int i8 = i2 - 1; i8 >= i6; i8--) {
                        if (this.mCallback.areItemsTheSame(i8, i)) {
                            i3 = this.mCallback.areContentsTheSame(i8, i) ? 8 : 4;
                            this.mNewItemStatuses[i] = (i8 << 5) | 16;
                            this.mOldItemStatuses[i8] = (i << 5) | i3;
                            return true;
                        }
                    }
                } else {
                    for (int i9 = y - 1; i9 >= i7; i9--) {
                        if (this.mCallback.areItemsTheSame(i, i9)) {
                            i3 = this.mCallback.areContentsTheSame(i, i9) ? 8 : 4;
                            int i10 = x - 1;
                            this.mOldItemStatuses[i10] = (i9 << 5) | 16;
                            this.mNewItemStatuses[i9] = (i10 << 5) | i3;
                            return true;
                        }
                    }
                }
                i2 = snake.x;
                y = snake.y;
                snakeIndex--;
            }
            return false;
        }

        public void dispatchUpdatesTo(final RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(ListUpdateCallback updateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (updateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) updateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(updateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.size;
                int i4 = snake.x + i3;
                int i5 = snake.y + i3;
                if (i4 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i7 = snake.x;
                    if ((iArr[i7 + i6] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i7 + i6, 1, this.mCallback.getChangePayload(i7 + i6, snake.y + i6));
                    }
                }
                i = snake.x;
                i2 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> updates, int pos, boolean removal) {
            int size = updates.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = updates.get(size);
                if (postponedUpdate.posInOwnerList == pos && postponedUpdate.removal == removal) {
                    updates.remove(size);
                    while (size < updates.size()) {
                        updates.get(size).currentPos += removal ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        private void dispatchAdditions(List<PostponedUpdate> postponedUpdates, ListUpdateCallback updateCallback, int start, int count, int globalIndex) {
            if (!this.mDetectMoves) {
                updateCallback.onInserted(start, count);
                return;
            }
            for (int i = count - 1; i >= 0; i--) {
                int[] iArr = this.mNewItemStatuses;
                int i2 = globalIndex + i;
                int i3 = iArr[i2] & 31;
                if (i3 == 0) {
                    updateCallback.onInserted(start, 1);
                    Iterator<PostponedUpdate> it = postponedUpdates.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                } else if (i3 == 4 || i3 == 8) {
                    int i4 = iArr[i2] >> 5;
                    updateCallback.onMoved(removePostponedUpdate(postponedUpdates, i4, true).currentPos, start);
                    if (i3 == 4) {
                        updateCallback.onChanged(start, 1, this.mCallback.getChangePayload(i4, i2));
                    }
                } else if (i3 == 16) {
                    postponedUpdates.add(new PostponedUpdate(i2, start, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i2 + " " + Long.toBinaryString(i3));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> postponedUpdates, ListUpdateCallback updateCallback, int start, int count, int globalIndex) {
            if (!this.mDetectMoves) {
                updateCallback.onRemoved(start, count);
                return;
            }
            for (int i = count - 1; i >= 0; i--) {
                int[] iArr = this.mOldItemStatuses;
                int i2 = globalIndex + i;
                int i3 = iArr[i2] & 31;
                if (i3 == 0) {
                    updateCallback.onRemoved(start + i, 1);
                    Iterator<PostponedUpdate> it = postponedUpdates.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                } else if (i3 == 4 || i3 == 8) {
                    int i4 = iArr[i2] >> 5;
                    PostponedUpdate postponedUpdateRemovePostponedUpdate = removePostponedUpdate(postponedUpdates, i4, false);
                    updateCallback.onMoved(start + i, postponedUpdateRemovePostponedUpdate.currentPos - 1);
                    if (i3 == 4) {
                        updateCallback.onChanged(postponedUpdateRemovePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i2, i4));
                    }
                } else if (i3 == 16) {
                    postponedUpdates.add(new PostponedUpdate(i2, start + i, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i2 + " " + Long.toBinaryString(i3));
                }
            }
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int posInOwnerList, int currentPos, boolean removal) {
            this.posInOwnerList = posInOwnerList;
            this.currentPos = currentPos;
            this.removal = removal;
        }
    }
}
