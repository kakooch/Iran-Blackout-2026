package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.BuildVars;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChildHelper {
    private static final boolean DEBUG = BuildVars.DEBUG_VERSION;
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    interface Callback {
        void addView(View child, int index);

        void attachViewToParent(View child, int index, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int offset);

        View getChildAt(int offset);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View child);

        void onLeftHiddenState(View child);

        void removeAllViews();

        void removeViewAt(int index);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    public void hideViewInternal(View child) {
        this.mHiddenViews.add(child);
        this.mCallback.onEnteredHiddenState(child);
    }

    public boolean unhideViewInternal(View child) {
        if (!this.mHiddenViews.remove(child)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(child);
        return true;
    }

    public int getHiddenChildCount() {
        return this.mHiddenViews.size();
    }

    public View getHiddenChildAt(int index) {
        if (index < 0 || index >= this.mHiddenViews.size()) {
            return null;
        }
        return this.mHiddenViews.get(index);
    }

    void addView(View child, boolean hidden) {
        addView(child, -1, hidden);
    }

    void addView(View child, int index, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.addView(child, offset);
        if (DEBUG) {
            Log.d("ChildrenHelper", "addViewAt " + index + ",h:" + hidden + ", " + this);
        }
    }

    private int getOffset(int index) {
        if (index < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i = index;
        while (i < childCount) {
            int iCountOnesBefore = index - (i - this.mBucket.countOnesBefore(i));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i)) {
                    i++;
                }
                return i;
            }
            i += iCountOnesBefore;
        }
        return -1;
    }

    void removeView(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(iIndexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(iIndexOfChild);
        if (DEBUG) {
            Log.d("ChildrenHelper", "remove View off:" + iIndexOfChild + "," + this);
        }
    }

    void removeViewAt(int index) {
        int offset = getOffset(index);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
        if (DEBUG) {
            Log.d("ChildrenHelper", "removeViewAt " + index + ", off:" + offset + ", " + this);
        }
    }

    View getChildAt(int index) {
        return this.mCallback.getChildAt(getOffset(index));
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
        if (DEBUG) {
            Log.d("ChildrenHelper", "removeAllViewsUnfiltered");
        }
    }

    View findHiddenNonRemovedView(int position) {
        int size = this.mHiddenViews.size();
        for (int i = 0; i < size; i++) {
            View view = this.mHiddenViews.get(i);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == position && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    void attachViewToParent(View child, int index, ViewGroup.LayoutParams layoutParams, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.attachViewToParent(child, offset, layoutParams);
        if (DEBUG) {
            Log.d("ChildrenHelper", "attach view to parent index:" + index + ",off:" + offset + ",h:" + hidden + ", " + this);
        }
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    View getUnfilteredChildAt(int index) {
        return this.mCallback.getChildAt(index);
    }

    void detachViewFromParent(int index) {
        int offset = getOffset(index);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    int indexOfChild(View child) {
        int iIndexOfChild = this.mCallback.indexOfChild(child);
        if (iIndexOfChild == -1) {
            return -1;
        }
        if (this.mBucket.get(iIndexOfChild)) {
            if (DEBUG) {
                throw new IllegalArgumentException("cannot get index of a hidden child");
            }
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        boolean z = DEBUG;
        if (z && this.mBucket.get(iIndexOfChild)) {
            throw new RuntimeException("trying to hide same view twice, how come ? " + view);
        }
        this.mBucket.set(iIndexOfChild);
        hideViewInternal(view);
        if (z) {
            Log.d("ChildrenHelper", "hiding child " + view + " at offset " + iIndexOfChild + ", " + this);
        }
    }

    void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.mBucket.get(iIndexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.mBucket.clear(iIndexOfChild);
        unhideViewInternal(view);
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    boolean removeViewIfHidden(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1) {
            if (unhideViewInternal(view) && DEBUG) {
                throw new IllegalStateException("view is in hidden list but not in view group");
            }
            return true;
        }
        if (!this.mBucket.get(iIndexOfChild)) {
            return false;
        }
        this.mBucket.remove(iIndexOfChild);
        if (!unhideViewInternal(view) && DEBUG) {
            throw new IllegalStateException("removed a hidden view but it is not in hidden views list");
        }
        this.mCallback.removeViewAt(iIndexOfChild);
        return true;
    }

    static class Bucket {
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        void set(int index) {
            if (index >= 64) {
                ensureNext();
                this.mNext.set(index - 64);
            } else {
                this.mData |= 1 << index;
            }
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int index) {
            if (index >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(index - 64);
                    return;
                }
                return;
            }
            this.mData &= (1 << index) ^ (-1);
        }

        boolean get(int index) {
            if (index < 64) {
                return (this.mData & (1 << index)) != 0;
            }
            ensureNext();
            return this.mNext.get(index - 64);
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void insert(int index, boolean value) {
            if (index >= 64) {
                ensureNext();
                this.mNext.insert(index - 64, value);
                return;
            }
            long j = this.mData;
            boolean z = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << index) - 1;
            this.mData = ((j & (j2 ^ (-1))) << 1) | (j & j2);
            if (value) {
                set(index);
            } else {
                clear(index);
            }
            if (z || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z);
            }
        }

        boolean remove(int index) {
            if (index >= 64) {
                ensureNext();
                return this.mNext.remove(index - 64);
            }
            long j = 1 << index;
            long j2 = this.mData;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (j ^ (-1));
            this.mData = j3;
            long j4 = j - 1;
            this.mData = (j3 & j4) | Long.rotateRight((j4 ^ (-1)) & j3, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        int countOnesBefore(int index) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (index >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << index) - 1));
            }
            if (index < 64) {
                return Long.bitCount(this.mData & ((1 << index) - 1));
            }
            return bucket.countOnesBefore(index - 64) + Long.bitCount(this.mData);
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }
}
