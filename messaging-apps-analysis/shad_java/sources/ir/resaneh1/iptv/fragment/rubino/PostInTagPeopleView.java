package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.resaneh1.iptv.fragment.rubino.SnapOnScrollListener;
import ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PostInTagPeopleView extends RecyclerView {
    private final ListAdapter adapter;
    private final TagPeopleViewItem.ActionOnTagItemView clickListener;
    private ArrayList<RGHMediaHelper$PhotoEntry> photoEntries;

    private void attachSnapHelperWithListener(SnapHelper snapHelper, TagPeopleViewItem.ActionOnTagItemView actionOnTagItemView) throws IllegalStateException {
        snapHelper.attachToRecyclerView(this);
        addOnScrollListener(new SnapOnScrollListener(snapHelper, SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL, actionOnTagItemView));
    }

    public PostInTagPeopleView(Context context, TagPeopleViewItem.ActionOnTagItemView actionOnTagItemView) throws IllegalStateException {
        super(context);
        this.clickListener = actionOnTagItemView;
        setLayoutManager(new LinearLayoutManager(context, 0, true));
        ListAdapter listAdapter = new ListAdapter();
        this.adapter = listAdapter;
        setAdapter(listAdapter);
        attachSnapHelperWithListener(new PagerSnapHelper(), actionOnTagItemView);
    }

    public void clearEmptyTags() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TagPeopleViewItem) {
                ((TagPeopleViewItem) childAt).removeEmptyMentionedView();
            }
        }
    }

    private class ListAdapter extends RecyclerView.Adapter {
        private ListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            TagPeopleViewItem tagPeopleViewItem = new TagPeopleViewItem(viewGroup.getContext());
            tagPeopleViewItem.setActionListener(PostInTagPeopleView.this.clickListener);
            tagPeopleViewItem.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return new Holder(tagPeopleViewItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((TagPeopleViewItem) viewHolder.itemView).setData((RGHMediaHelper$PhotoEntry) PostInTagPeopleView.this.photoEntries.get(i), i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (PostInTagPeopleView.this.photoEntries == null) {
                return 0;
            }
            return PostInTagPeopleView.this.photoEntries.size();
        }
    }

    public void setPost(RubinoDraftManager.RubinoSendingPost rubinoSendingPost, int i) {
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList = rubinoSendingPost.entryList;
        this.photoEntries = arrayList;
        this.adapter.notifyItemRangeInserted(0, arrayList.size());
        scrollToPosition(i);
    }

    private static class Holder extends RecyclerView.ViewHolder {
        public Holder(View view) {
            super(view);
        }
    }
}
