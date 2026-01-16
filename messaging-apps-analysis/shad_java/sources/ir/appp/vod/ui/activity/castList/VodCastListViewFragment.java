package ir.appp.vod.ui.activity.castList;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.appp.vod.domain.model.VodCastListViewEntity;
import ir.appp.vod.ui.activity.castList.VodCastListViewFragment;
import ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment;
import ir.medu.shad.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: VodCastListViewFragment.kt */
/* loaded from: classes3.dex */
public final class VodCastListViewFragment extends LifecycleAwareBaseFragment {
    private ImageView btnClose;
    private List<VodCastListViewEntity> list;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private String title;
    private final int titleTxvPadding;
    private TextView txvTitle;
    private final int widthPixels;

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return false;
    }

    public VodCastListViewFragment(List<VodCastListViewEntity> list, String str) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.title = str;
        DisplayMetrics displayMetrics = AndroidUtilities.displayMetrics;
        int i = displayMetrics.heightPixels;
        this.widthPixels = displayMetrics.widthPixels;
        this.titleTxvPadding = AndroidUtilities.dp(8.0f);
        this.fragmentAnimationDuration = 500.0f;
        this.presentAnimationType = ActionBarAnimationType.ZTU;
        this.dismissAnimationType = ActionBarAnimationType.UTZ;
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.scrollToPosition(0);
        }
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.actionBar.setAddToContainer(false);
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        this.fragmentView = constraintLayout;
        ConstraintLayout constraintLayout2 = constraintLayout;
        constraintLayout2.setId(R.id.layout_list_view);
        constraintLayout2.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        constraintLayout2.setBackgroundColor(ContextCompat.getColor(context, R.color.vod_cast_list_view_background_color));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        recyclerListView.setId(R.id.cast_list_view);
        recyclerListView.setItemAnimator(null);
        recyclerListView.setOverScrollMode(2);
        recyclerListView.setLayoutManager(new LinearLayoutManager(context) { // from class: ir.appp.vod.ui.activity.castList.VodCastListViewFragment$createView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
                if (layoutParams == null) {
                    return true;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).width = this.widthPixels;
                return true;
            }
        });
        ListAdapter listAdapter = new ListAdapter(this, context, this.list);
        this.listAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        this.listView = recyclerListView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, AndroidUtilities.dp(0.0f));
        layoutParams.topToBottom = R.id.cast_view_title;
        layoutParams.bottomToBottom = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        Unit unit = Unit.INSTANCE;
        constraintLayout2.addView(recyclerListView, layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.close_cast_view);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.close_white, null));
        imageView.setBackground(imageView.getResources().getDrawable(R.drawable.vod_close_cast_list_background));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.activity.castList.VodCastListViewFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodCastListViewFragment.m344createView$lambda4$lambda3(this.f$0, view);
            }
        });
        this.btnClose = imageView;
        TextView textView = new TextView(context);
        textView.setId(R.id.cast_view_title);
        textView.setText(this.title);
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(4);
        }
        textView.setTypeface(ResourcesCompat.getFont(context, R.font.iranyekanwebbold));
        int i = this.titleTxvPadding;
        textView.setPadding(i, 0, i, 0);
        textView.setTextSize(21.0f);
        textView.setTextColor(textView.getResources().getColor(R.color.vod_cast_list_primary_text_color));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.txvTitle = textView;
        View view = this.btnClose;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(AndroidUtilities.dp(0.0f), AndroidUtilities.dp(0.0f));
        layoutParams2.topToTop = 0;
        layoutParams2.startToStart = 0;
        layoutParams2.dimensionRatio = "1:1";
        layoutParams2.matchConstraintPercentWidth = 0.07f;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = AndroidUtilities.dp(16.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = AndroidUtilities.dp(12.0f);
        constraintLayout2.addView(view, layoutParams2);
        View view2 = this.txvTitle;
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(AndroidUtilities.dp(0.0f), -2);
        layoutParams3.topToTop = R.id.close_cast_view;
        layoutParams3.startToEnd = R.id.close_cast_view;
        layoutParams3.matchConstraintPercentWidth = 0.8f;
        constraintLayout2.addView(view2, layoutParams3);
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createView$lambda-4$lambda-3, reason: not valid java name */
    public static final void m344createView$lambda4$lambda3(VodCastListViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VodCastListViewFragment.kt */
    final class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context context;
        private List<VodCastListViewEntity> listItems;
        final /* synthetic */ VodCastListViewFragment this$0;

        public ListAdapter(VodCastListViewFragment this$0, Context context, List<VodCastListViewEntity> listItems) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(listItems, "listItems");
            this.this$0 = this$0;
            this.context = context;
            this.listItems = listItems;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return holder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.listItems.size();
        }

        public final VodCastListViewEntity getItem(int i) {
            return this.listItems.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-4$lambda-3, reason: not valid java name */
        public static final void m345onCreateViewHolder$lambda4$lambda3(VodCastListViewFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            List list = this$0.list;
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            VodCastListViewEntity vodCastListViewEntity = (VodCastListViewEntity) list.get(((Integer) tag).intValue());
            ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new VodRelatedMovieListFragment(vodCastListViewEntity.getId(), vodCastListViewEntity.getCategory()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i != 0 && i != 1) {
                if (i == 2) {
                    TextView textView = new TextView(this.context);
                    textView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
                    return new RecyclerListView.Holder(textView);
                }
                return new RecyclerListView.Holder(new View(this.context));
            }
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            TextView textView2 = new TextView(this.context);
            textView2.setGravity(17);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            if (i == 0) {
                textView2.setPadding(0, AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(8.0f));
                textView2.setLayoutParams(layoutParams);
                textView2.setTypeface(ResourcesCompat.getFont(textView2.getContext(), R.font.iranyekanwebbold));
                textView2.setTextSize(18.0f);
                textView2.setTextColor(textView2.getResources().getColor(R.color.vod_cast_list_primary_text_color));
            } else {
                textView2.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
                textView2.setLayoutParams(layoutParams);
                textView2.setTypeface(ResourcesCompat.getFont(textView2.getContext(), R.font.iranyekanwebregular));
                textView2.setTextSize(17.0f);
                textView2.setTextColor(textView2.getResources().getColor(R.color.vod_cast_list_secondary_text_color));
            }
            RecyclerListView.Holder holder = new RecyclerListView.Holder(textView2);
            final VodCastListViewFragment vodCastListViewFragment = this.this$0;
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.activity.castList.VodCastListViewFragment$ListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodCastListViewFragment.ListAdapter.m345onCreateViewHolder$lambda4$lambda3(vodCastListViewFragment, view);
                }
            });
            return holder;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder.getItemViewType() == 0 || holder.getItemViewType() == 1) {
                VodCastListViewEntity item = getItem(i);
                TextView textView = (TextView) holder.itemView;
                textView.setText(item.getData());
                textView.setTag(Integer.valueOf(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (getItem(i).getType() == VodCastListViewEntity.Type.HEADER) {
                return 0;
            }
            if (getItem(i).getType() == VodCastListViewEntity.Type.TEXT) {
                return 1;
            }
            return getItem(i).getType() == VodCastListViewEntity.Type.EMPTY ? 2 : 3;
        }
    }
}
