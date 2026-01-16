package ir.resaneh1.iptv.fragment.rubino.shop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductCell;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class ProductsBottomSheet extends BottomSheet {
    private final ListAdapter adapter;
    private final ArrayList<ShopModels.ProductSummaryObject> items;
    private final RecyclerListView listView;
    private Activity parentActivity;
    private int scrollOffsetY;
    private final Drawable shadowDrawable;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public ProductsBottomSheet(Context context, final ArrayList<ShopModels.ProductSummaryObject> arrayList) {
        super(context, false);
        ArrayList<ShopModels.ProductSummaryObject> arrayList2 = new ArrayList<>();
        this.items = arrayList2;
        if (context instanceof Activity) {
            this.parentActivity = (Activity) context;
        }
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setAdapter(listAdapter);
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsBottomSheet$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0(arrayList, view, i);
            }
        });
        recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerListView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
        recyclerListView.setClipToPadding(false);
        recyclerListView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        recyclerListView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
        recyclerListView.setHorizontalScrollBarEnabled(false);
        recyclerListView.setVerticalScrollBarEnabled(false);
        recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsBottomSheet.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ProductsBottomSheet.this.updateLayout();
            }
        });
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsBottomSheet.2
            private boolean ignoreLayout;

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && ProductsBottomSheet.this.scrollOffsetY != 0 && motionEvent.getY() < ProductsBottomSheet.this.scrollOffsetY) {
                    ProductsBottomSheet.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !ProductsBottomSheet.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                int iDp = AndroidUtilities.dp(103.0f) + AndroidUtilities.dp(48.0f) + (Math.max(2, (int) Math.ceil(ProductsBottomSheet.this.adapter.getItemCount() / 4.0f)) * AndroidUtilities.dp(103.0f)) + ((BottomSheet) ProductsBottomSheet.this).backgroundPaddingTop;
                int iDp2 = (iDp < size ? 0 : size - ((size / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (ProductsBottomSheet.this.listView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    ProductsBottomSheet.this.listView.setPadding(AndroidUtilities.dp(6.0f), iDp2, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
                    this.ignoreLayout = false;
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                ProductsBottomSheet.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                ProductsBottomSheet.this.shadowDrawable.setBounds(0, ProductsBottomSheet.this.scrollOffsetY - ((BottomSheet) ProductsBottomSheet.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                ProductsBottomSheet.this.shadowDrawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setClipChildren(false);
        this.containerView.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        this.containerView.addView(recyclerListView, LayoutHelper.createFrame(-1, -1, 8388659, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ArrayList arrayList, View view, int i) {
        Activity activity = this.parentActivity;
        if (activity == null || !(activity instanceof LaunchActivity)) {
            return;
        }
        ShopModels.ProductSummaryObject productSummaryObject = (ShopModels.ProductSummaryObject) arrayList.get(i);
        ((LaunchActivity) this.parentActivity).lambda$runLinkRequest$40(new ProductDetailFragment(productSummaryObject.store_id, productSummaryObject.id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView = this.listView;
            this.scrollOffsetY = i;
            recyclerListView.setTopGlowOffset(i);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ProductCell productCell = new ProductCell(this.mContext);
            productCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            productCell.setDelegate(new ProductCell.ProductDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsBottomSheet$ListAdapter$$ExternalSyntheticLambda0
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductCell.ProductDelegate
                public final void onViewProductClick(ShopModels.ProductSummaryObject productSummaryObject) {
                    this.f$0.lambda$onCreateViewHolder$0(productSummaryObject);
                }
            });
            return new RecyclerListView.Holder(productCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(ShopModels.ProductSummaryObject productSummaryObject) {
            if (ProductsBottomSheet.this.parentActivity == null || !(ProductsBottomSheet.this.parentActivity instanceof LaunchActivity)) {
                return;
            }
            ((LaunchActivity) ProductsBottomSheet.this.parentActivity).lambda$runLinkRequest$40(new ProductDetailFragment(productSummaryObject.store_id, productSummaryObject.id));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((ProductCell) viewHolder.itemView).setItem((ShopModels.ProductSummaryObject) ProductsBottomSheet.this.items.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProductsBottomSheet.this.items.size();
        }
    }
}
