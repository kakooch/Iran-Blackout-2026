package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter;
import ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.GetProductsInput;
import ir.resaneh1.iptv.model.GetProductsOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Switch;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class ProductListFragment extends BaseFragment implements ProductsAdapter.ProductListener {
    public Context context;
    private FrameLayout frameLayoutAdd;
    boolean isDeleteRequestInProgress;
    boolean isEditPriceRequestInprogress;
    boolean isEditVisibilityRequestInProgress;
    private boolean isLoadingProducts;
    public RecyclerListView mainRecyclerView;
    public ProductsAdapter productsAdapter;
    private final String storeId;
    TextView textViewAdd;
    private boolean hasContinue = true;
    private String nextStartId = null;
    public CompositeDisposable mainCompositeDisposable = new CompositeDisposable();

    public ProductListFragment(String str) {
        this.storeId = str;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        refreshData();
    }

    private void refreshData() {
        this.nextStartId = null;
        this.hasContinue = true;
        this.isLoadingProducts = false;
        callGetProducts(true);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.context = context;
        this.needLockOrientation = true;
        this.swipeBackEnabled = false;
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setTitle(LocaleController.getString(R.string.shop_product));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ProductListFragment.this.finishFragment();
                }
            }
        });
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.mainRecyclerView = recyclerListView;
        frameLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, -2, 48, 14.0f, 0.0f, 14.0f, 0.0f));
        initMainRecyclerView();
        callGetProducts(true);
        this.frameLayoutAdd = new FrameLayout(context);
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 14, -1, false);
        this.textViewAdd = textViewCreateTextView;
        textViewCreateTextView.setText(LocaleController.getString(R.string.shop_add_product));
        this.textViewAdd.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_blue));
        this.textViewAdd.setGravity(17);
        this.textViewAdd.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.textViewAdd.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        this.frameLayoutAdd.addView(this.textViewAdd, LayoutHelper.createFrame(-1, -2, 17, 8.0f, 4.0f, 4.0f, 4.0f));
        frameLayout.addView(this.frameLayoutAdd, LayoutHelper.createFrame(-1, -2, 80));
        this.mainRecyclerView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(56.0f));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        presentFragment(new AddProductFragment(this.storeId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetProducts(final boolean z) {
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
            this.mainCompositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProducts(getProductsInput).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GetProductsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.2
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetProductsOutput> messangerOutput) {
                    ProductListFragment.this.isLoadingProducts = false;
                    GetProductsOutput getProductsOutput = messangerOutput.data;
                    if (getProductsOutput != null) {
                        ProductListFragment.this.hasContinue = getProductsOutput.has_continue;
                        ProductListFragment.this.nextStartId = messangerOutput.data.next_start_id;
                        ProductListFragment.this.updateProducts(messangerOutput.data.products, z);
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    ProductListFragment.this.isLoadingProducts = false;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProducts(ArrayList<ShopModels.ProductSummaryObject> arrayList, boolean z) {
        this.productsAdapter.setLoading(this.hasContinue);
        if (arrayList != null) {
            this.productsAdapter.setList(arrayList, z);
        }
        this.productsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteProductFromArray(ShopModels.ProductSummaryObject productSummaryObject) {
        Iterator<ShopModels.ProductSummaryObject> it = this.productsAdapter.productsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ShopModels.ProductSummaryObject next = it.next();
            if (next.id.equals(productSummaryObject.id)) {
                this.productsAdapter.productsList.remove(next);
                break;
            }
        }
        this.productsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProductInArray(ShopModels.ProductSummaryObject productSummaryObject, long j) {
        Iterator<ShopModels.ProductSummaryObject> it = this.productsAdapter.productsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ShopModels.ProductSummaryObject next = it.next();
            if (next.id.equals(productSummaryObject.id)) {
                next.unit_price = j;
                break;
            }
        }
        this.productsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProductInArray(ShopModels.ProductSummaryObject productSummaryObject, boolean z) {
        Iterator<ShopModels.ProductSummaryObject> it = this.productsAdapter.productsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ShopModels.ProductSummaryObject next = it.next();
            if (next.id.equals(productSummaryObject.id)) {
                next.is_visible = z;
                break;
            }
        }
        this.productsAdapter.notifyDataSetChanged();
    }

    private void initMainRecyclerView() {
        ProductsAdapter productsAdapter = new ProductsAdapter(this.context, this);
        this.productsAdapter = productsAdapter;
        productsAdapter.setLoading(this.hasContinue);
        this.mainRecyclerView.setAdapter(this.productsAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        new AnonymousClass3(this.context, this.mainRecyclerView);
        this.mainRecyclerView.setLayoutManager(linearLayoutManager);
        this.mainRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (ProductListFragment.this.productsAdapter.getItemCount() <= 0 || !ProductListFragment.this.hasContinue || iFindLastCompletelyVisibleItemPosition < ProductListFragment.this.productsAdapter.getItemCount() - 5) {
                    return;
                }
                ProductListFragment.this.callGetProducts(false);
            }
        });
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$3, reason: invalid class name */
    class AnonymousClass3 extends SwipeHelper {
        AnonymousClass3(Context context, RecyclerListView recyclerListView) {
            super(context, recyclerListView);
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper
        public void instantiateUnderlayButton(final RecyclerView.ViewHolder viewHolder, List<SwipeHelper.UnderlayButton> list) {
            if (viewHolder instanceof ProductsAdapter.ProductViewHolder) {
                list.add(new SwipeHelper.UnderlayButton(LocaleController.getString(R.string.delete_product), 0, Color.parseColor("#FF3C30"), new SwipeHelper.ButtonSwipeListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$3$$ExternalSyntheticLambda1
                    @Override // ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper.ButtonSwipeListener
                    public final void onSwiped() {
                        this.f$0.lambda$instantiateUnderlayButton$0(viewHolder);
                    }
                }, true, this.context.getResources().getDrawable(R.drawable.shop_ic_trash)));
                list.add(new SwipeHelper.UnderlayButton(LocaleController.getString(R.string.edit_product), 0, Color.parseColor("#0295F7"), new SwipeHelper.ButtonSwipeListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$3$$ExternalSyntheticLambda0
                    @Override // ir.resaneh1.iptv.fragment.rubino.shop.SwipeHelper.ButtonSwipeListener
                    public final void onSwiped() {
                        this.f$0.lambda$instantiateUnderlayButton$1(viewHolder);
                    }
                }, false, this.context.getResources().getDrawable(R.drawable.shop_ic_edit_2)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateUnderlayButton$0(RecyclerView.ViewHolder viewHolder) {
            ProductListFragment.this.showDeleteProductBottomSheet(((ProductsAdapter.ProductViewHolder) viewHolder).productSummaryObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateUnderlayButton$1(RecyclerView.ViewHolder viewHolder) {
            ProductListFragment.this.onEditClick(((ProductsAdapter.ProductViewHolder) viewHolder).productSummaryObject);
        }
    }

    private void showVisibilityBottomSheet(final ShopModels.ProductSummaryObject productSummaryObject) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(this.context, 14, false);
        textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.shop_edit_existance));
        TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(this.context, 12, false);
        textViewCreateTextViewBlack2.setText(LocaleController.getString(R.string.product_existence));
        final Switch r7 = new Switch(this.context);
        FrameLayout frameLayout = new FrameLayout(this.context);
        float f = 16;
        frameLayout.addView(textViewCreateTextViewBlack2, LayoutHelper.createFrame(-2, -2, 5, 0.0f, 0.0f, f, 0.0f));
        frameLayout.addView(r7, LayoutHelper.createFrame(42, -2, 3, f, 0.0f, 0.0f, 0.0f));
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProductListFragment.lambda$showVisibilityBottomSheet$1(r7, view);
            }
        });
        r7.setChecked(productSummaryObject.is_visible, false);
        final TextView textViewCreateTextView = ViewHelper.createTextView(this.context, 14, -1, false);
        textViewCreateTextView.setText(LocaleController.getString(R.string.shop_submit));
        textViewCreateTextView.setGravity(17);
        textViewCreateTextView.setBackgroundResource(R.drawable.shop_rectangle_blue);
        linearLayout.addView(textViewCreateTextViewBlack, LayoutHelper.createLinear(-1, -2, 5, 16, 20, 16, 10));
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, 48, 17, 16, 20, 16, 10));
        linearLayout.addView(textViewCreateTextView, LayoutHelper.createLinear(-1, 48, 80, 16, 20, 16, 10));
        final BottomSheet bottomSheet = new BottomSheet(getContext(), true);
        bottomSheet.setCustomView(linearLayout);
        textViewCreateTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showVisibilityBottomSheet$2(textViewCreateTextView, productSummaryObject, r7, bottomSheet, view);
            }
        });
        bottomSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showVisibilityBottomSheet$3(dialogInterface);
            }
        });
        showDialog(bottomSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showVisibilityBottomSheet$1(Switch r1, View view) {
        r1.setChecked(!r1.isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVisibilityBottomSheet$2(final TextView textView, final ShopModels.ProductSummaryObject productSummaryObject, Switch r10, final BottomSheet bottomSheet, View view) {
        if (this.isEditVisibilityRequestInProgress) {
            return;
        }
        textView.setAlpha(0.2f);
        textView.setText(LocaleController.getString(R.string.sendingRequest));
        this.isEditVisibilityRequestInProgress = true;
        final ShopModels.EditProductInput editProductInput = new ShopModels.EditProductInput();
        editProductInput.store_id = this.storeId;
        editProductInput.product_id = productSummaryObject.id;
        editProductInput.updated_parameters = new ArrayList<>();
        editProductInput.is_visible = Boolean.valueOf(r10.isChecked());
        editProductInput.updated_parameters.add(ShopModels.UpdateParametersEnum.is_visible.name());
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).editProduct(editProductInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.AddProductOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.AddProductOutput> messangerOutput) {
                textView.setText(LocaleController.getString(R.string.shop_submit));
                ProductListFragment.this.isEditVisibilityRequestInProgress = false;
                textView.setAlpha(1.0f);
                bottomSheet.dismiss();
                productSummaryObject.is_visible = editProductInput.is_visible.booleanValue();
                ProductListFragment.this.updateProductInArray(productSummaryObject, editProductInput.is_visible.booleanValue());
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                textView.setText(LocaleController.getString(R.string.shop_submit));
                ProductListFragment.this.isEditVisibilityRequestInProgress = false;
                textView.setAlpha(1.0f);
                bottomSheet.dismiss();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVisibilityBottomSheet$3(DialogInterface dialogInterface) {
        this.isEditVisibilityRequestInProgress = false;
    }

    private void showSingleEditPriceBottomSheet(final ShopModels.ProductSummaryObject productSummaryObject) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(this.context, 14, true);
        textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.shop_new_price));
        final EditText editTextCreateEditTextBlack = ViewHelper.createEditTextBlack(this.context, 14, false);
        ViewHelper.addEditTextCostFormat(editTextCreateEditTextBlack);
        editTextCreateEditTextBlack.setGravity(5);
        ViewHelper.addEditTextCostFormat(editTextCreateEditTextBlack);
        editTextCreateEditTextBlack.setText(NumberUtils.setCommaFormat(productSummaryObject.unit_price + BuildConfig.FLAVOR));
        TextView textViewCreateTextViewGray = ViewHelper.createTextViewGray(this.context, 13, true);
        textViewCreateTextViewGray.setText(LocaleController.getString(R.string.product_nuit));
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setBackground(this.context.getResources().getDrawable(R.drawable.bg_rectangle_gray_rounded_border));
        float f = 16;
        frameLayout.addView(editTextCreateEditTextBlack, LayoutHelper.createFrame(-1, -2, 17, f, 5.0f, f, 5.0f));
        frameLayout.addView(textViewCreateTextViewGray, LayoutHelper.createFrame(-2, -2, 19, f, 5.0f, 0.0f, 5.0f));
        final TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(this.context, 14, false);
        textViewCreateTextViewBlack2.setText(LocaleController.getString(R.string.shop_submit));
        textViewCreateTextViewBlack2.setGravity(17);
        textViewCreateTextViewBlack2.setTextColor(-1);
        textViewCreateTextViewBlack2.setBackgroundResource(R.drawable.shop_rectangle_blue);
        linearLayout.addView(textViewCreateTextViewBlack, LayoutHelper.createLinear(-1, -2, 48, 16, 20, 16, 10));
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, 50, 17, 16, 20, 16, 10));
        linearLayout.addView(textViewCreateTextViewBlack2, LayoutHelper.createLinear(-1, 48, 80, 16, 20, 16, 10));
        final BottomSheet bottomSheet = new BottomSheet(getContext(), true);
        bottomSheet.setCustomView(linearLayout);
        textViewCreateTextViewBlack2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showSingleEditPriceBottomSheet$4(productSummaryObject, editTextCreateEditTextBlack, textViewCreateTextViewBlack2, bottomSheet, view);
            }
        });
        bottomSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showSingleEditPriceBottomSheet$5(dialogInterface);
            }
        });
        showDialog(bottomSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSingleEditPriceBottomSheet$4(final ShopModels.ProductSummaryObject productSummaryObject, EditText editText, final TextView textView, final BottomSheet bottomSheet, View view) {
        if (this.isEditPriceRequestInprogress) {
            return;
        }
        ShopModels.EditProductInput editProductInput = new ShopModels.EditProductInput();
        editProductInput.store_id = this.storeId;
        editProductInput.product_id = productSummaryObject.id;
        editProductInput.updated_parameters = new ArrayList<>();
        try {
            editProductInput.unit_price = Long.valueOf(Long.parseLong(NumberUtils.toEnglish(editText.getText().toString().replaceAll(",", BuildConfig.FLAVOR))));
        } catch (Exception unused) {
            editProductInput.unit_price = 0L;
        }
        if (editProductInput.unit_price.longValue() <= 0) {
            ToastiLikeSnack.showL(this.context, LocaleController.getString(R.string.shop_add_product_error_price));
            return;
        }
        textView.setAlpha(0.2f);
        textView.setText(LocaleController.getString(R.string.sendingRequest));
        this.isEditPriceRequestInprogress = true;
        editProductInput.updated_parameters.add(ShopModels.UpdateParametersEnum.unit_price.name());
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).editProduct(editProductInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.AddProductOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.6
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.AddProductOutput> messangerOutput) {
                textView.setText(LocaleController.getString(R.string.shop_submit));
                ProductListFragment.this.isEditPriceRequestInprogress = false;
                textView.setAlpha(1.0f);
                bottomSheet.dismiss();
                ShopModels.ProductSummaryObject productSummaryObject2 = productSummaryObject;
                ShopModels.AddProductOutput addProductOutput = messangerOutput.data;
                productSummaryObject2.unit_price = addProductOutput.product.unit_price;
                ProductListFragment.this.updateProductInArray(productSummaryObject2, addProductOutput.product.unit_price);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                textView.setText(LocaleController.getString(R.string.shop_submit));
                ProductListFragment.this.isEditPriceRequestInprogress = false;
                textView.setAlpha(1.0f);
                bottomSheet.dismiss();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSingleEditPriceBottomSheet$5(DialogInterface dialogInterface) {
        this.isEditPriceRequestInprogress = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteProductBottomSheet(final ShopModels.ProductSummaryObject productSummaryObject) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.item_shop_delete_product_bottom_sheet, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.delete_product_bottom_sheet_delete_text_view);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.delete_product_bottom_sheet_cancel_text_view);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.delete_product_bottom_sheet_body_text_view);
        textView.setText(LocaleController.getString(R.string.delete_product));
        textView2.setText(LocaleController.getString(R.string.cancel_product));
        textView3.setText(LocaleController.getString(R.string.product_delete_body));
        final BottomSheet bottomSheet = new BottomSheet(getContext(), true);
        bottomSheet.setCustomView(viewInflate);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheet.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showDeleteProductBottomSheet$7(productSummaryObject, bottomSheet, view);
            }
        });
        bottomSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showDeleteProductBottomSheet$8(dialogInterface);
            }
        });
        showDialog(bottomSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteProductBottomSheet$7(final ShopModels.ProductSummaryObject productSummaryObject, final BottomSheet bottomSheet, View view) {
        if (this.isDeleteRequestInProgress) {
            return;
        }
        this.isDeleteRequestInProgress = true;
        ShopModels.DeleteProductInput deleteProductInput = new ShopModels.DeleteProductInput();
        deleteProductInput.store_id = this.storeId;
        deleteProductInput.product_id = productSummaryObject.id;
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).deleteProduct(deleteProductInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.DeleteProductOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListFragment.7
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.DeleteProductOutput> messangerOutput) {
                bottomSheet.dismiss();
                ProductListFragment.this.deleteProductFromArray(productSummaryObject);
                ProductListFragment.this.isDeleteRequestInProgress = false;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                bottomSheet.dismiss();
                ProductListFragment.this.isDeleteRequestInProgress = false;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDeleteProductBottomSheet$8(DialogInterface dialogInterface) {
        this.isDeleteRequestInProgress = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditClick(ShopModels.ProductSummaryObject productSummaryObject) {
        presentFragment(new AddProductFragment(this.storeId, productSummaryObject.id));
    }

    @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter.ProductListener
    public void onEditPriceClick(ShopModels.ProductSummaryObject productSummaryObject) {
        showSingleEditPriceBottomSheet(productSummaryObject);
    }

    @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter.ProductListener
    public void onEditInventoryClick(ShopModels.ProductSummaryObject productSummaryObject) {
        showVisibilityBottomSheet(productSummaryObject);
    }

    @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter.ProductListener
    public void onProductClick(ShopModels.ProductSummaryObject productSummaryObject) {
        presentFragment(new ProductDetailFragment(productSummaryObject.store_id, productSummaryObject.id));
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.mainCompositeDisposable.dispose();
    }
}
