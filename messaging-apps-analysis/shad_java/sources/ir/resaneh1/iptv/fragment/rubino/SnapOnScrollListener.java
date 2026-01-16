package ir.resaneh1.iptv.fragment.rubino;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvUtil.kt */
/* loaded from: classes3.dex */
public final class SnapOnScrollListener extends RecyclerView.OnScrollListener {
    private TagPeopleViewItem.ActionOnTagItemView onSnapPositionChangeListener;
    private final SnapHelper snapHelper;
    private int snapPosition;

    /* compiled from: RvUtil.kt */
    public enum Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public SnapOnScrollListener(SnapHelper snapHelper, Behavior behavior, TagPeopleViewItem.ActionOnTagItemView actionOnTagItemView) {
        Intrinsics.checkNotNullParameter(snapHelper, "snapHelper");
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        this.snapHelper = snapHelper;
        this.onSnapPositionChangeListener = actionOnTagItemView;
        this.snapPosition = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i == 0) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    private final void maybeNotifySnapPositionChange(RecyclerView recyclerView) {
        int snapPosition = RvUtilKt.getSnapPosition(this.snapHelper, recyclerView);
        if (this.snapPosition != snapPosition) {
            TagPeopleViewItem.ActionOnTagItemView actionOnTagItemView = this.onSnapPositionChangeListener;
            if (actionOnTagItemView != null) {
                actionOnTagItemView.onScroll(snapPosition);
            }
            this.snapPosition = snapPosition;
        }
    }
}
