package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class ScrollbarHelper {
    static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientation, View startChild, View endChild, RecyclerView.LayoutManager lm, boolean smoothScrollbarEnabled, boolean reverseLayout) {
        int iMax;
        if (lm.getChildCount() == 0 || state.getItemCount() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        int iMin = Math.min(lm.getPosition(startChild), lm.getPosition(endChild));
        int iMax2 = Math.max(lm.getPosition(startChild), lm.getPosition(endChild));
        if (reverseLayout) {
            iMax = Math.max(0, (state.getItemCount() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (!smoothScrollbarEnabled) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(orientation.getDecoratedEnd(endChild) - orientation.getDecoratedStart(startChild)) / (Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1))) + (orientation.getStartAfterPadding() - orientation.getDecoratedStart(startChild)));
    }

    static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientation, View startChild, View endChild, RecyclerView.LayoutManager lm, boolean smoothScrollbarEnabled) {
        if (lm.getChildCount() == 0 || state.getItemCount() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1;
        }
        return Math.min(orientation.getTotalSpace(), orientation.getDecoratedEnd(endChild) - orientation.getDecoratedStart(startChild));
    }

    static int computeScrollRange(RecyclerView.State state, OrientationHelper orientation, View startChild, View endChild, RecyclerView.LayoutManager lm, boolean smoothScrollbarEnabled) {
        if (lm.getChildCount() == 0 || state.getItemCount() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return state.getItemCount();
        }
        return (int) (((orientation.getDecoratedEnd(endChild) - orientation.getDecoratedStart(startChild)) / (Math.abs(lm.getPosition(startChild) - lm.getPosition(endChild)) + 1)) * state.getItemCount());
    }
}
