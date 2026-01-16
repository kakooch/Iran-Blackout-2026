package ir.appp.vod.ui.activity.videoDetail;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodMediaDetailActivity.kt */
/* loaded from: classes3.dex */
public final class VodMediaDetailActivity$initViews$6$1 extends DefaultItemAnimator {
    final /* synthetic */ VodMediaDetailActivity this$0;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getAddDuration() {
        return 220L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getMoveDuration() {
        return 220L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public long getRemoveDuration() {
        return 220L;
    }

    VodMediaDetailActivity$initViews$6$1(VodMediaDetailActivity vodMediaDetailActivity) {
        this.this$0 = vodMediaDetailActivity;
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        ArrayList<RecyclerView.ViewHolder> mPendingRemovals = this.mPendingRemovals;
        Intrinsics.checkNotNullExpressionValue(mPendingRemovals, "mPendingRemovals");
        boolean z = !mPendingRemovals.isEmpty();
        ArrayList<DefaultItemAnimator.MoveInfo> mPendingMoves = this.mPendingMoves;
        Intrinsics.checkNotNullExpressionValue(mPendingMoves, "mPendingMoves");
        boolean z2 = !mPendingMoves.isEmpty();
        ArrayList<DefaultItemAnimator.ChangeInfo> mPendingChanges = this.mPendingChanges;
        Intrinsics.checkNotNullExpressionValue(mPendingChanges, "mPendingChanges");
        boolean z3 = !mPendingChanges.isEmpty();
        ArrayList<RecyclerView.ViewHolder> mPendingAdditions = this.mPendingAdditions;
        Intrinsics.checkNotNullExpressionValue(mPendingAdditions, "mPendingAdditions");
        boolean z4 = !mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final VodMediaDetailActivity vodMediaDetailActivity = this.this$0;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity$initViews$6$1$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VodMediaDetailActivity$initViews$6$1.m349runPendingAnimations$lambda0(vodMediaDetailActivity, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(getMoveDuration());
            valueAnimatorOfFloat.start();
        }
        super.runPendingAnimations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: runPendingAnimations$lambda-0, reason: not valid java name */
    public static final void m349runPendingAnimations$lambda0(VodMediaDetailActivity this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerListView listView = this$0.getListView();
        if (listView == null) {
            return;
        }
        listView.invalidate();
    }
}
