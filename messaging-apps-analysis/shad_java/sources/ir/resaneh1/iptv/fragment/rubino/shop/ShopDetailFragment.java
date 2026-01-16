package ir.resaneh1.iptv.fragment.rubino.shop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductGridCell;
import ir.resaneh1.iptv.model.GetProductsInput;
import ir.resaneh1.iptv.model.GetProductsOutput;
import ir.resaneh1.iptv.model.GetStoreDetailInput;
import ir.resaneh1.iptv.model.GetStoreDetailOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Components.ViewHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class ShopDetailFragment extends BaseFragment {
    private ListAdapter adapter;
    private final int currentAccount;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private Activity parentActivity;
    private final String storeId;
    private ShopModels.Store store = null;
    private final ArrayList<ShopModels.ProductSummaryObject> products = new ArrayList<>();
    private int rowCount = 0;
    private int iconRow = -1;
    private int contactRow = -1;
    private int productsTitleRow = -1;
    private int productsStartRow = -1;
    private int productsEndRow = -1;
    private int loadingRow = -1;
    private boolean isLoadingStore = false;
    private boolean isLoadingProducts = false;
    private boolean hasContinue = true;
    private String nextStartId = null;
    public CompositeDisposable mainCompositeDisposable = new CompositeDisposable();

    public ShopDetailFragment(Activity activity, int i, String str) {
        this.currentAccount = i;
        this.parentActivity = activity;
        this.storeId = str;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.needLockOrientation = true;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setTitle(LocaleController.getString(R.string.shop_information));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ShopDetailFragment.this.finishFragment();
                }
            }
        });
        this.adapter = new ListAdapter(context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setAdapter(this.adapter);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                return super.checkLayoutParams(layoutParams);
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.listView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
        this.listView.setClipToPadding(false);
        this.listView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(8.0f));
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int iFindLastCompletelyVisibleItemPosition = ShopDetailFragment.this.layoutManager.findLastCompletelyVisibleItemPosition();
                if (ShopDetailFragment.this.products.size() <= 0 || !ShopDetailFragment.this.hasContinue || iFindLastCompletelyVisibleItemPosition - ShopDetailFragment.this.productsStartRow < (ShopDetailFragment.this.products.size() / 2.0f) - 5.0f) {
                    return;
                }
                ShopDetailFragment.this.callGetProducts(false);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(16.0f));
        this.fragmentView = frameLayout;
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 8388659, 0.0f, 0.0f, 0.0f, 0.0f));
        callGetStore();
        callGetProducts(true);
        updateRowIds();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetProducts(boolean z) {
        if (this.isLoadingProducts) {
            return;
        }
        if (this.hasContinue || z) {
            GetProductsInput getProductsInput = new GetProductsInput();
            getProductsInput.store_id = this.storeId;
            if (z) {
                this.nextStartId = null;
                getProductsInput.start_id = null;
                this.hasContinue = true;
            } else {
                getProductsInput.start_id = this.nextStartId;
            }
            this.isLoadingProducts = true;
            this.mainCompositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProducts(getProductsInput).subscribeWith(new DisposableObserver<MessangerOutput<GetProductsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment.4
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetProductsOutput> messangerOutput) {
                    ShopDetailFragment.this.isLoadingProducts = false;
                    GetProductsOutput getProductsOutput = messangerOutput.data;
                    if (getProductsOutput != null) {
                        ShopDetailFragment.this.hasContinue = getProductsOutput.has_continue;
                        ShopDetailFragment.this.nextStartId = messangerOutput.data.next_start_id;
                        ShopDetailFragment.this.updateProducts(messangerOutput.data.products);
                        ShopDetailFragment.this.updateRowIds();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    ShopDetailFragment.this.isLoadingProducts = false;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProducts(ArrayList<ShopModels.ProductSummaryObject> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.products.addAll(arrayList);
    }

    private void callGetStore() {
        if (this.isLoadingStore) {
            return;
        }
        GetStoreDetailInput getStoreDetailInput = new GetStoreDetailInput();
        getStoreDetailInput.store_id = this.storeId;
        this.isLoadingStore = true;
        this.mainCompositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getStoreDetail(getStoreDetailInput).subscribeWith(new DisposableObserver<MessangerOutput<GetStoreDetailOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetStoreDetailOutput> messangerOutput) {
                ShopDetailFragment.this.isLoadingStore = false;
                GetStoreDetailOutput getStoreDetailOutput = messangerOutput.data;
                if (getStoreDetailOutput != null) {
                    ShopDetailFragment.this.store = getStoreDetailOutput.store;
                    ShopDetailFragment.this.updateRowIds();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ShopDetailFragment.this.isLoadingStore = false;
            }
        }));
    }

    public void updateRowIds() {
        this.rowCount = 0;
        this.iconRow = -1;
        this.contactRow = -1;
        this.productsTitleRow = -1;
        this.productsStartRow = -1;
        this.productsEndRow = -1;
        this.loadingRow = -1;
        if (this.isLoadingStore) {
            this.rowCount = 0 + 1;
            this.loadingRow = 0;
        }
        if (this.store != null) {
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.iconRow = i;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.contactRow = i2;
            this.rowCount = i3 + 1;
            this.productsTitleRow = i3;
        }
        ArrayList<ShopModels.ProductSummaryObject> arrayList = this.products;
        if (arrayList != null && arrayList.size() > 0) {
            int i4 = this.rowCount;
            this.productsStartRow = i4;
            double d = i4;
            double dCeil = Math.ceil(this.products.size() / 2.0f);
            Double.isNaN(d);
            int i5 = (int) (d + dCeil);
            this.rowCount = i5;
            this.productsEndRow = i5;
        }
        if (this.isLoadingProducts && !this.isLoadingStore) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.loadingRow = i6;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            if (ShopDetailFragment.this.store == null || ShopDetailFragment.this.store.chat_link == null) {
                return;
            }
            new MainClickHandler().onLinkClick(ShopDetailFragment.this.store.chat_link);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(ShopModels.ProductSummaryObject productSummaryObject, int i, int i2) {
            if (ShopDetailFragment.this.parentActivity != null) {
                ((LaunchActivity) ShopDetailFragment.this.parentActivity).getLastFragment().presentFragment(new ProductDetailFragment(ShopDetailFragment.this.storeId, ((ShopModels.ProductSummaryObject) ShopDetailFragment.this.products.get(i)).id));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View loadingCell;
            if (i == 0) {
                loadingCell = new StoreIconCell(this.mContext);
            } else if (i == 1) {
                FrameLayout frameLayout = new FrameLayout(this.mContext);
                TextView textViewCreateShopTextView = ViewHelper.createShopTextView(this.mContext, 14, -1, false);
                frameLayout.addView(textViewCreateShopTextView, LayoutHelper.createFrame(-1, -2));
                textViewCreateShopTextView.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.shop_blue_rectangle_corner));
                textViewCreateShopTextView.setText(LocaleController.getString(R.string.ContactShop));
                textViewCreateShopTextView.setGravity(17);
                textViewCreateShopTextView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
                textViewCreateShopTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment$ListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                loadingCell = frameLayout;
            } else if (i == 2) {
                TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(this.mContext, 16, true);
                textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.Products));
                textViewCreateTextViewBlack.setGravity(5);
                textViewCreateTextViewBlack.setPadding(0, AndroidUtilities.dp(8.0f), 0, 0);
                textViewCreateTextViewBlack.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_shop_products, 0);
                textViewCreateTextViewBlack.setCompoundDrawablePadding(AndroidUtilities.dp(12.0f));
                loadingCell = textViewCreateTextViewBlack;
            } else if (i == 3) {
                ProductGridCell productGridCell = new ProductGridCell(this.mContext);
                productGridCell.setDelegate(new ProductGridCell.ProductCellDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopDetailFragment$ListAdapter$$ExternalSyntheticLambda1
                    @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductGridCell.ProductCellDelegate
                    public final void didClickItem(ShopModels.ProductSummaryObject productSummaryObject, int i2, int i3) {
                        this.f$0.lambda$onCreateViewHolder$1(productSummaryObject, i2, i3);
                    }
                });
                loadingCell = productGridCell;
            } else {
                loadingCell = i != 7 ? null : new LoadingCell(this.mContext);
            }
            if (loadingCell != null) {
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(16.0f);
                loadingCell.setLayoutParams(layoutParams);
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ShopDetailFragment.this.iconRow) {
                return 0;
            }
            if (i == ShopDetailFragment.this.contactRow) {
                return 1;
            }
            if (i == ShopDetailFragment.this.productsTitleRow) {
                return 2;
            }
            if (i < ShopDetailFragment.this.productsStartRow || i >= ShopDetailFragment.this.productsEndRow) {
                return i == ShopDetailFragment.this.loadingRow ? 7 : -1;
            }
            return 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((StoreIconCell) viewHolder.itemView).setImageAndTitle(ShopDetailFragment.this.store.image_url != null ? ShopDetailFragment.this.store.image_url : BuildConfig.FLAVOR, ShopDetailFragment.this.store.store_name);
                return;
            }
            if (itemViewType == 3) {
                ProductGridCell productGridCell = (ProductGridCell) viewHolder.itemView;
                productGridCell.setIsFirst(i == 0);
                productGridCell.setItemsCount(2);
                for (int i2 = 0; i2 < 2; i2++) {
                    int i3 = ((2 - i2) - 1) + ((i - ShopDetailFragment.this.productsStartRow) * 2);
                    if (i3 < ShopDetailFragment.this.products.size()) {
                        productGridCell.setItem(i2, i3, (ShopModels.ProductSummaryObject) ShopDetailFragment.this.products.get(i3));
                    } else {
                        productGridCell.setItem(i2, i3, null);
                    }
                }
                productGridCell.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ShopDetailFragment.this.rowCount;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.mainCompositeDisposable.dispose();
    }
}
