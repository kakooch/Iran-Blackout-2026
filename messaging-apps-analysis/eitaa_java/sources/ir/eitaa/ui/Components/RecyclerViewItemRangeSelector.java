package ir.eitaa.ui.Components;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class RecyclerViewItemRangeSelector implements RecyclerView.OnItemTouchListener {
    private int autoScrollVelocity;
    private RecyclerViewItemRangeSelectorDelegate delegate;
    private boolean dragSelectActive;
    private int hotspotBottomBoundEnd;
    private int hotspotBottomBoundStart;
    private int hotspotOffsetBottom;
    private int hotspotOffsetTop;
    private int hotspotTopBoundEnd;
    private int hotspotTopBoundStart;
    private boolean inBottomHotspot;
    private boolean inTopHotspot;
    private int initialSelection;
    private RecyclerView recyclerView;
    private int lastDraggedIndex = -1;
    private int hotspotHeight = AndroidUtilities.dp(80.0f);
    private Runnable autoScrollRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RecyclerViewItemRangeSelector.1
        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerViewItemRangeSelector.this.recyclerView == null) {
                return;
            }
            if (RecyclerViewItemRangeSelector.this.inTopHotspot) {
                RecyclerViewItemRangeSelector.this.recyclerView.scrollBy(0, -RecyclerViewItemRangeSelector.this.autoScrollVelocity);
                AndroidUtilities.runOnUIThread(this);
            } else if (RecyclerViewItemRangeSelector.this.inBottomHotspot) {
                RecyclerViewItemRangeSelector.this.recyclerView.scrollBy(0, RecyclerViewItemRangeSelector.this.autoScrollVelocity);
                AndroidUtilities.runOnUIThread(this);
            }
        }
    };

    public interface RecyclerViewItemRangeSelectorDelegate {
        boolean isIndexSelectable(int index);

        boolean isSelected(int index);

        void onStartStopSelection(boolean start);

        void setSelected(View view, int index, boolean selected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public RecyclerViewItemRangeSelector(RecyclerViewItemRangeSelectorDelegate recyclerViewItemRangeSelectorDelegate) {
        this.delegate = recyclerViewItemRangeSelectorDelegate;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        boolean z = false;
        boolean z2 = rv.getAdapter() == null || rv.getAdapter().getItemCount() == 0;
        if (this.dragSelectActive && !z2) {
            z = true;
        }
        if (z) {
            this.recyclerView = rv;
            int i = this.hotspotHeight;
            if (i > -1) {
                int i2 = this.hotspotOffsetTop;
                this.hotspotTopBoundStart = i2;
                this.hotspotTopBoundEnd = i2 + i;
                this.hotspotBottomBoundStart = (rv.getMeasuredHeight() - this.hotspotHeight) - this.hotspotOffsetBottom;
                this.hotspotBottomBoundEnd = rv.getMeasuredHeight() - this.hotspotOffsetBottom;
            }
        }
        if (z && e.getAction() == 1) {
            onDragSelectionStop();
        }
        return z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        View viewFindChildViewUnder = rv.findChildViewUnder(e.getX(), e.getY());
        int childAdapterPosition = viewFindChildViewUnder != null ? rv.getChildAdapterPosition(viewFindChildViewUnder) : -1;
        float y = e.getY();
        int action = e.getAction();
        if (action == 1) {
            onDragSelectionStop();
            return;
        }
        if (action != 2) {
            return;
        }
        if (this.hotspotHeight > -1) {
            if (y >= this.hotspotTopBoundStart && y <= this.hotspotTopBoundEnd) {
                this.inBottomHotspot = false;
                if (!this.inTopHotspot) {
                    this.inTopHotspot = true;
                    AndroidUtilities.cancelRunOnUIThread(this.autoScrollRunnable);
                    AndroidUtilities.runOnUIThread(this.autoScrollRunnable);
                }
                int i = this.hotspotTopBoundEnd;
                this.autoScrollVelocity = ((int) ((i - r5) - (y - this.hotspotTopBoundStart))) / 2;
            } else if (y >= this.hotspotBottomBoundStart && y <= this.hotspotBottomBoundEnd) {
                this.inTopHotspot = false;
                if (!this.inBottomHotspot) {
                    this.inBottomHotspot = true;
                    AndroidUtilities.cancelRunOnUIThread(this.autoScrollRunnable);
                    AndroidUtilities.runOnUIThread(this.autoScrollRunnable);
                }
                this.autoScrollVelocity = ((int) ((y + this.hotspotBottomBoundEnd) - (this.hotspotBottomBoundStart + r8))) / 2;
            } else if (this.inTopHotspot || this.inBottomHotspot) {
                AndroidUtilities.cancelRunOnUIThread(this.autoScrollRunnable);
                this.inTopHotspot = false;
                this.inBottomHotspot = false;
            }
        }
        if (childAdapterPosition == -1 || this.lastDraggedIndex == childAdapterPosition) {
            return;
        }
        this.lastDraggedIndex = childAdapterPosition;
        this.delegate.setSelected(viewFindChildViewUnder, childAdapterPosition, !r8.isSelected(childAdapterPosition));
    }

    public boolean setIsActive(View view, boolean active, int selection, boolean select) {
        if (active && this.dragSelectActive) {
            return false;
        }
        this.lastDraggedIndex = -1;
        AndroidUtilities.cancelRunOnUIThread(this.autoScrollRunnable);
        this.inTopHotspot = false;
        this.inBottomHotspot = false;
        if (!active) {
            this.initialSelection = -1;
            return false;
        }
        if (!this.delegate.isIndexSelectable(selection)) {
            this.dragSelectActive = false;
            this.initialSelection = -1;
            return false;
        }
        this.delegate.onStartStopSelection(true);
        this.delegate.setSelected(view, this.initialSelection, select);
        this.dragSelectActive = active;
        this.initialSelection = selection;
        this.lastDraggedIndex = selection;
        return true;
    }

    private void onDragSelectionStop() {
        this.dragSelectActive = false;
        this.inTopHotspot = false;
        this.inBottomHotspot = false;
        AndroidUtilities.cancelRunOnUIThread(this.autoScrollRunnable);
        this.delegate.onStartStopSelection(false);
    }
}
