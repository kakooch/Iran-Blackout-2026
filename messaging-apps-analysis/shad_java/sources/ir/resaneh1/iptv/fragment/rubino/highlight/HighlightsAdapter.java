package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.ui.cells.HighlightCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.model.Rubino;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HighlightsAdapter.kt */
/* loaded from: classes3.dex */
public final class HighlightsAdapter extends RecyclerListView.SelectionAdapter {
    private final List<Rubino.StoryHighlight> highlights = new ArrayList();
    private Function2<? super Rubino.StoryHighlight, ? super HighlightCell.HighlightType, Unit> onItemClicked;

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return true;
    }

    public final void setOnItemClicked(Function2<? super Rubino.StoryHighlight, ? super HighlightCell.HighlightType, Unit> function2) {
        this.onItemClicked = function2;
    }

    public final void updateList(List<? extends Rubino.StoryHighlight> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.highlights.clear();
        this.highlights.addAll(items);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerListView.Holder onCreateViewHolder(ViewGroup parent, final int i) {
        HighlightCell highlightCell;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == 1) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            highlightCell = new HighlightCell(context, HighlightCell.HighlightType.HIGHLIGHT);
        } else {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            highlightCell = new HighlightCell(context2, HighlightCell.HighlightType.ADD_NEW);
        }
        RecyclerListView.Holder holder = new RecyclerListView.Holder(highlightCell);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HighlightsAdapter.m500onCreateViewHolder$lambda0(i, this, view);
            }
        });
        return holder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreateViewHolder$lambda-0, reason: not valid java name */
    public static final void m500onCreateViewHolder$lambda0(int i, HighlightsAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag();
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (i == 1) {
            Function2<? super Rubino.StoryHighlight, ? super HighlightCell.HighlightType, Unit> function2 = this$0.onItemClicked;
            if (function2 == null) {
                return;
            }
            function2.invoke(this$0.highlights.get(iIntValue), HighlightCell.HighlightType.HIGHLIGHT);
            return;
        }
        Function2<? super Rubino.StoryHighlight, ? super HighlightCell.HighlightType, Unit> function22 = this$0.onItemClicked;
        if (function22 == null) {
            return;
        }
        function22.invoke(null, HighlightCell.HighlightType.ADD_NEW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HighlightCell highlightCell = (HighlightCell) holder.itemView;
        highlightCell.setTag(Integer.valueOf(i));
        if (holder.getItemViewType() == 1) {
            highlightCell.setData(this.highlights.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.highlights.isEmpty()) {
            return this.highlights.size() + 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i < 0 || i >= getItemCount() - 1) ? 0 : 1;
    }
}
