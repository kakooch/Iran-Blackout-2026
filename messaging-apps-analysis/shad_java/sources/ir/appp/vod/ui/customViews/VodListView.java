package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.appp.vod.ui.customViews.VodListView;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: VodListView.kt */
/* loaded from: classes3.dex */
public final class VodListView extends ConstraintLayout {
    private FloatingActionButton btnClose;
    private List<String> list;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private Function0<Unit> onCloseButtonClicked;
    private Function2<? super Integer, ? super String, Unit> onItemClicked;
    private int selectedItemPosition;

    public final List<String> getList() {
        return this.list;
    }

    public final void setList(List<String> list) {
        this.list = list;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter == null) {
            return;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        listAdapter.setItems(list);
    }

    public final Function2<Integer, String, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    public final void setOnItemClicked(Function2<? super Integer, ? super String, Unit> function2) {
        this.onItemClicked = function2;
    }

    public final Function0<Unit> getOnCloseButtonClicked() {
        return this.onCloseButtonClicked;
    }

    public final void setOnCloseButtonClicked(Function0<Unit> function0) {
        this.onCloseButtonClicked = function0;
    }

    public final int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public final void setSelectedItemPosition(int i) {
        int i2 = this.selectedItemPosition;
        this.selectedItemPosition = i;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i2);
        }
        ListAdapter listAdapter2 = this.listAdapter;
        if (listAdapter2 == null) {
            return;
        }
        listAdapter2.notifyItemChanged(this.selectedItemPosition);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        setId(R.id.layout_list_view);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.vod_background_overlay));
        setOnClickListener(null);
        initList();
        initButtons();
    }

    private final void initList() {
        RecyclerListView recyclerListView = new RecyclerListView(getContext());
        recyclerListView.setItemAnimator(null);
        recyclerListView.setOverScrollMode(2);
        recyclerListView.setVerticalFadingEdgeEnabled(true);
        recyclerListView.addItemDecoration(new VodVerticalEndSpaceItemDecoration(AndroidUtilities.dp(80.0f)));
        double d = AndroidUtilities.displayMetrics.heightPixels;
        Double.isNaN(d);
        recyclerListView.setFadingEdgeLength((int) (d / 2.2d));
        final Context context = recyclerListView.getContext();
        recyclerListView.setLayoutManager(new LinearLayoutManager(context) { // from class: ir.appp.vod.ui.customViews.VodListView$initList$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
                if (layoutParams == null) {
                    return true;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).width = AndroidUtilities.displayMetrics.widthPixels;
                return true;
            }
        });
        Context context2 = recyclerListView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        List<String> list = getList();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ListAdapter listAdapter = new ListAdapter(this, context2, list);
        this.listAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        this.listView = recyclerListView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.matchConstraintMaxHeight = -2;
        Unit unit = Unit.INSTANCE;
        addView(recyclerListView, layoutParams);
    }

    private final void initButtons() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        floatingActionButton.setImageDrawable(ResourcesCompat.getDrawable(floatingActionButton.getContext().getResources(), R.drawable.close_white, null));
        floatingActionButton.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(-1));
        floatingActionButton.setRippleColor(ContextCompat.getColor(floatingActionButton.getContext(), R.color.grey_800));
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VodListView.m351initButtons$lambda3$lambda2(this.f$0, view);
            }
        });
        this.btnClose = floatingActionButton;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.bottomToBottom = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(16.0f);
        Unit unit = Unit.INSTANCE;
        addView(floatingActionButton, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initButtons$lambda-3$lambda-2, reason: not valid java name */
    public static final void m351initButtons$lambda3$lambda2(VodListView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCloseButtonClicked;
        if (function0 == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.displayMetrics.widthPixels, 1073741824), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemClicked(int i) {
        setSelectedItemPosition(i);
        Function2<? super Integer, ? super String, Unit> function2 = this.onItemClicked;
        if (function2 == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(this.selectedItemPosition);
        List<String> list = this.list;
        function2.invoke(numValueOf, list == null ? null : list.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VodListView.kt */
    final class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context context;
        private List<String> listItems;
        final /* synthetic */ VodListView this$0;

        public ListAdapter(VodListView this$0, Context context, List<String> listItems) {
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

        public final String getItem(int i) {
            return this.listItems.get(i);
        }

        public final void setItems(List<String> listItems) {
            Intrinsics.checkNotNullParameter(listItems, "listItems");
            this.listItems = listItems;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            RecyclerListView.Holder holder = new RecyclerListView.Holder(new ListItemCell(this.this$0, this.context));
            TextView textView = ((ListItemCell) holder.itemView).getTextView();
            final VodListView vodListView = this.this$0;
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodListView$ListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodListView.ListAdapter.m352onCreateViewHolder$lambda0(vodListView, view);
                }
            });
            return holder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-0, reason: not valid java name */
        public static final void m352onCreateViewHolder$lambda0(VodListView this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            this$0.onItemClicked(((Integer) tag).intValue());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            String item = getItem(i);
            ListItemCell listItemCell = (ListItemCell) holder.itemView;
            VodListView vodListView = this.this$0;
            listItemCell.setText(item);
            listItemCell.setSelected(i == vodListView.getSelectedItemPosition());
            listItemCell.getTextView().setTag(Integer.valueOf(i));
        }
    }

    /* compiled from: VodListView.kt */
    private final class ListItemCell extends FrameLayout {
        private final int activeColor;
        private final TextView textView;
        private final int unActiveColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListItemCell(VodListView this$0, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            new LinkedHashMap();
            this.activeColor = ContextCompat.getColor(getContext(), R.color.vod_primary_text_color);
            int color = ContextCompat.getColor(getContext(), R.color.vod_secondary_text_color);
            this.unActiveColor = color;
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTypeface(Theme.getRubinoTypeFaceMedium());
            textView.setTextColor(color);
            textView.setTextSize(1, 17.0f);
            this.textView = textView;
            addView(textView, LayoutHelper.createFrame(-1, -2, 17));
        }

        public final TextView getTextView() {
            return this.textView;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (z) {
                this.textView.setTextColor(this.activeColor);
                this.textView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iranyekanwebbold));
                this.textView.setTextSize(1, 24.0f);
            } else {
                this.textView.setTextColor(this.unActiveColor);
                this.textView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.iranyekanwebregular));
                this.textView.setTextSize(1, 17.0f);
            }
        }

        public final void setText(CharSequence charSequence) {
            this.textView.setText(charSequence);
        }
    }
}
