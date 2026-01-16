package ir.resaneh1.iptv.fragment.rubino.shop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoRetryView;
import ir.resaneh1.iptv.fragment.rubino.shop.adapter.ProductColorAdapter;
import ir.resaneh1.iptv.fragment.rubino.shop.adapter.ProductPropertyAdapter;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.GetProductDetailInput;
import ir.resaneh1.iptv.model.GetProductDetailOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Iterator;
import me.relex.circleindicator.CircleIndicator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class ProductDetailFragment extends BaseFragment {
    private LinearLayout chooseColorLayout;
    private RecyclerListView colorRecyclerView;
    private ProductColorAdapter colorsAdapter;
    private TextView contactButton;
    private int containerHeight;
    private FrameLayout containerLayout;
    private LinearLayout descriptionLayout;
    private TextView descriptionTextView;
    private int fieldY;
    private CircleIndicator indicator;
    private boolean isLoadingProduct;
    LinearLayout linearLayout;
    private LoadingCell loadingCell;
    private TextView moreTextView;
    private TextView nameTextView;
    private TextView priceTextView;
    private final String productId;
    private ProductPropertyAdapter propertiesAdapter;
    private RubinoRetryView retryView;
    private TextView sendMessageButton;
    private LinearLayout sizeLayout;
    private SliderAdapter sliderAdapter;
    private FrameLayout sliderFrameLayout;
    private SpansContainer spansContainer;
    private final String storeId;
    private boolean isExpandDescription = false;
    private final CompositeDisposable mainCompositeDisposable = new CompositeDisposable();
    private boolean isLoading = false;

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        return false;
    }

    public ProductDetailFragment(String str, String str2) {
        this.storeId = str;
        this.productId = str2;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        this.needLockOrientation = true;
        FrameLayout frameLayout = new FrameLayout(context);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.containerLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        scrollView.addView(this.linearLayout, LayoutHelper.createFrame(-1, -1));
        this.containerLayout.addView(scrollView, LayoutHelper.createFrame(-1, -1));
        frameLayout.addView(this.containerLayout, LayoutHelper.createFrame(-1, -1));
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setTitle(LocaleController.getString(R.string.product_detaile));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ProductDetailFragment.this.finishFragment();
                }
            }
        });
        this.sliderFrameLayout = new FrameLayout(context);
        ViewPager viewPager = new ViewPager(context);
        SliderAdapter sliderAdapter = new SliderAdapter(context);
        this.sliderAdapter = sliderAdapter;
        viewPager.setAdapter(sliderAdapter);
        CircleIndicator circleIndicator = new CircleIndicator(context);
        this.indicator = circleIndicator;
        circleIndicator.setViewPager(viewPager);
        this.sliderAdapter.registerDataSetObserver(this.indicator.getDataSetObserver());
        this.indicator.setGravity(17);
        if (Build.VERSION.SDK_INT >= 17) {
            this.indicator.setLayoutDirection(0);
        }
        this.indicator.configureIndicator(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), -1, R.anim.indicator_anim, R.anim.indicator_anim, R.drawable.circle_indicator_selected_product, R.drawable.circle_grey_indicator_product);
        this.sliderFrameLayout.addView(viewPager, LayoutHelper.createFrame(-1, -1));
        this.sliderFrameLayout.addView(this.indicator, LayoutHelper.createFrame(-2, -2, 81, 0.0f, 0.0f, 0.0f, 16.0f));
        this.linearLayout.addView(this.sliderFrameLayout, LayoutHelper.createLinear(-1, 250));
        initProductDetailView(context);
        initSizeSelectionView(context);
        initColorSelectionView(context);
        initDescriptionView(context);
        initPropertiesView(context);
        initContactButton(context);
        RubinoRetryView rubinoRetryView = new RubinoRetryView(context);
        this.retryView = rubinoRetryView;
        rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
        this.retryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        frameLayout.addView(this.retryView, LayoutHelper.createFrame(-1, -1));
        LoadingCell loadingCell = new LoadingCell(context);
        this.loadingCell = loadingCell;
        frameLayout.addView(loadingCell, LayoutHelper.createFrame(-1, -2, 48));
        this.retryView.setVisibility(8);
        this.containerLayout.setVisibility(8);
        this.loadingCell.setVisibility(8);
        this.fragmentView = frameLayout;
        callGetProduct();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        callGetProduct();
    }

    private void initContactButton(final Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        TextView textViewCreateShopTextView = ViewHelper.createShopTextView(context, 14, -1, false);
        this.contactButton = textViewCreateShopTextView;
        textViewCreateShopTextView.setBackground(ContextCompat.getDrawable(context, R.drawable.shop_blue_rectangle_corner));
        this.contactButton.setText(LocaleController.getString(R.string.shopProductQuestion));
        this.contactButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initContactButton$1(context, view);
            }
        });
        this.contactButton.setGravity(17);
        this.contactButton.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
        linearLayout.addView(this.contactButton, LayoutHelper.createLinear(0, -2, 1.0f, 3, 4, 0, 4, 0));
        TextView textViewCreateShopTextView2 = ViewHelper.createShopTextView(context, 14, -1, false);
        this.sendMessageButton = textViewCreateShopTextView2;
        textViewCreateShopTextView2.setBackground(ContextCompat.getDrawable(context, R.drawable.shop_blue_rectangle_corner));
        this.sendMessageButton.setText(LocaleController.getString(R.string.shopRequestProduct));
        this.sendMessageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initContactButton$2(context, view);
            }
        });
        this.sendMessageButton.setGravity(17);
        this.sendMessageButton.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
        linearLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        linearLayout.addView(this.sendMessageButton, LayoutHelper.createLinear(0, -2, 1.0f, 4, 0, 4, 0));
        this.linearLayout.setPadding(0, 0, 0, AndroidUtilities.dp(64.0f));
        linearLayout.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f));
        this.containerLayout.addView(linearLayout, LayoutHelper.createFrame(-1, -2, 80));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initContactButton$1(Context context, View view) {
        callGetProductLink(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initContactButton$2(Context context, View view) {
        callGetProductLink(context, true);
    }

    private void callGetProductLink(final Context context, boolean z) {
        if (this.isLoading || TextUtils.isEmpty(this.storeId)) {
            return;
        }
        this.isLoading = true;
        final AlertDialog alertDialog = new AlertDialog(context, 3);
        showDialog(alertDialog);
        ShopModels.GetProductMessageLinkInput getProductMessageLinkInput = new ShopModels.GetProductMessageLinkInput();
        getProductMessageLinkInput.store_id = this.storeId;
        getProductMessageLinkInput.product_id = this.productId;
        getProductMessageLinkInput.product_varieties = getProductVarieties();
        getProductMessageLinkInput.get_address_info = z;
        final DisposableObserver disposableObserver = (DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProductMessageLink(getProductMessageLinkInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.GetProductMessageLinkOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.GetProductMessageLinkOutput> messangerOutput) {
                ProductDetailFragment.this.isLoading = false;
                alertDialog.dismiss();
                if (messangerOutput.data != null) {
                    new MainClickHandler().onLinkClick(messangerOutput.data.link);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ProductDetailFragment.this.isLoading = false;
                alertDialog.dismiss();
                ToastiLikeSnack.showS(context, LocaleController.getString(R.string.ErrorOccurred));
            }
        });
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$callGetProductLink$3(disposableObserver, dialogInterface);
            }
        });
        this.mainCompositeDisposable.add(disposableObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callGetProductLink$3(DisposableObserver disposableObserver, DialogInterface dialogInterface) {
        disposableObserver.dispose();
        this.isLoading = false;
    }

    private ArrayList<ProductMessageData.ProductMessageVariety> getProductVarieties() {
        ArrayList<ProductMessageData.ProductMessageVariety> arrayList = new ArrayList<>();
        ShopModels.ColorObject selectedColor = this.colorsAdapter.getSelectedColor();
        if (selectedColor != null) {
            ProductMessageData.ProductMessageVariety productMessageVariety = new ProductMessageData.ProductMessageVariety();
            productMessageVariety.type = ProductMessageData.ProductMessageVarietyType.Color;
            ProductMessageData.ProductMessageColor productMessageColor = new ProductMessageData.ProductMessageColor();
            productMessageVariety.color_data = productMessageColor;
            productMessageColor.color_code = selectedColor.color_code;
            productMessageColor.id = selectedColor.id;
            productMessageColor.name = selectedColor.name;
            arrayList.add(productMessageVariety);
        }
        SizeTextView sizeTextView = this.spansContainer.selectedItem;
        if (sizeTextView != null) {
            ProductMessageData.ProductMessageVariety productMessageVariety2 = new ProductMessageData.ProductMessageVariety();
            productMessageVariety2.type = ProductMessageData.ProductMessageVarietyType.Other;
            if (productMessageVariety2.other_data == null) {
                productMessageVariety2.other_data = new ProductMessageData.OtherVarietyData();
            }
            productMessageVariety2.other_data.variety_name = ShopModels.ProductVarietyTypeEnum.Size.name();
            productMessageVariety2.other_data.value = String.valueOf(sizeTextView.getValue());
            arrayList.add(productMessageVariety2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private void callGetProduct() {
        if (this.isLoadingProduct) {
            return;
        }
        update(1);
        GetProductDetailInput getProductDetailInput = new GetProductDetailInput();
        getProductDetailInput.product_id = this.productId;
        getProductDetailInput.store_id = this.storeId;
        this.isLoadingProduct = true;
        this.compositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProductDetail(getProductDetailInput).subscribeWith(new DisposableObserver<MessangerOutput<GetProductDetailOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetProductDetailOutput> messangerOutput) {
                ProductDetailFragment.this.isLoadingProduct = false;
                GetProductDetailOutput getProductDetailOutput = messangerOutput.data;
                if (getProductDetailOutput != null) {
                    ProductDetailFragment.this.setProduct(getProductDetailOutput.product);
                    ProductDetailFragment.this.update(0);
                } else {
                    ProductDetailFragment.this.update(2);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ProductDetailFragment.this.isLoadingProduct = false;
                ProductDetailFragment.this.update(2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update(int i) {
        if (i == 1) {
            this.containerLayout.setVisibility(8);
            this.retryView.setVisibility(8);
            this.loadingCell.setVisibility(0);
        } else if (i == 0) {
            this.containerLayout.setVisibility(0);
            this.retryView.setVisibility(8);
            this.loadingCell.setVisibility(8);
        } else if (i == 2) {
            this.containerLayout.setVisibility(8);
            this.retryView.setVisibility(0);
            this.loadingCell.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProduct(ShopModels.Product product) {
        boolean z;
        ArrayList<String> arrayList;
        if (product == null) {
            return;
        }
        ArrayList<ShopModels.InputFile> arrayList2 = product.media;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.sliderFrameLayout.setVisibility(0);
            this.sliderAdapter.setImages(product.media);
            CircleIndicator circleIndicator = this.indicator;
            ArrayList<ShopModels.InputFile> arrayList3 = product.media;
            circleIndicator.setVisibility((arrayList3 == null || arrayList3.size() <= 1) ? 8 : 0);
        } else {
            this.sliderFrameLayout.setVisibility(8);
        }
        this.nameTextView.setText(product.product_name);
        this.priceTextView.setText(NumberUtils.getPriceStringWithToman(product.unit_price, false));
        this.descriptionTextView.setText(product.description);
        this.descriptionTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ProductDetailFragment.this.descriptionTextView.getLayout().getLineCount() > 4) {
                    ProductDetailFragment.this.moreTextView.setVisibility(0);
                } else {
                    ProductDetailFragment.this.moreTextView.setVisibility(8);
                }
                ProductDetailFragment.this.descriptionTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.propertiesAdapter.setData(product.features);
        ArrayList<ShopModels.ColorObject> arrayList4 = product.colors;
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            this.chooseColorLayout.setVisibility(0);
            this.colorsAdapter.setData(product.colors);
            this.colorsAdapter.setSelected(0);
        } else {
            this.chooseColorLayout.setVisibility(8);
        }
        ArrayList<ShopModels.ProductVariety> arrayList5 = product.product_variety;
        if (arrayList5 == null || arrayList5.isEmpty()) {
            z = false;
        } else {
            Iterator<ShopModels.ProductVariety> it = product.product_variety.iterator();
            z = false;
            while (it.hasNext()) {
                ShopModels.ProductVariety next = it.next();
                if (next.type == ShopModels.ProductVarietyTypeEnum.Size && (arrayList = next.variety_values) != null && !arrayList.isEmpty()) {
                    Iterator<String> it2 = next.variety_values.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        SizeTextView sizeTextView = new SizeTextView(getContext());
                        sizeTextView.setText(String.valueOf(next2));
                        this.spansContainer.addSpan(sizeTextView);
                    }
                    if (this.spansContainer.getChildCount() > 0) {
                        this.spansContainer.setSelectedItem(0);
                    }
                    z = true;
                }
            }
        }
        this.sizeLayout.setVisibility(z ? 0 : 8);
        this.contactButton.setVisibility(product.is_visible ? 0 : 8);
        this.sendMessageButton.setVisibility(product.is_visible ? 0 : 8);
    }

    private void initProductDetailView(Context context) {
        int i = Theme.key_chats_name;
        this.nameTextView = ViewHelper.createShopTextView(context, 18, Theme.getColor(i), true);
        this.priceTextView = ViewHelper.createShopTextView(context, 16, Theme.getColor(i), true);
        this.linearLayout.addView(this.nameTextView, LayoutHelper.createLinear(-2, -2, 5, 0, 32, 16, 8));
        this.linearLayout.addView(this.priceTextView, LayoutHelper.createLinear(-2, -2, 5, 0, 0, 16, 8));
        this.linearLayout.addView(createLine(context), LayoutHelper.createLinear(-1, 1, 0, 16, 8, 16, 0));
    }

    private void initSizeSelectionView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.sizeLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.sizeLayout.addView(createTextView(context, LocaleController.getString(R.string.ChooseSize)), LayoutHelper.createLinear(-2, -2, 5, 0, 32, 16, 8));
        SpansContainer spansContainer = new SpansContainer(context);
        this.spansContainer = spansContainer;
        this.sizeLayout.addView(spansContainer, LayoutHelper.createLinear(-1, -2, 5, 16, 0, 16, 8));
        this.sizeLayout.addView(createLine(context), LayoutHelper.createLinear(-1, 1, 0, 16, 8, 16, 8));
        this.linearLayout.addView(this.sizeLayout, LayoutHelper.createLinear(-1, -2));
    }

    private void initColorSelectionView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.chooseColorLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.chooseColorLayout.addView(createTextView(context, LocaleController.getString(R.string.ChooseColor)), LayoutHelper.createLinear(-2, -2, 5, 0, 32, 16, 8));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.colorRecyclerView = recyclerListView;
        recyclerListView.setNestedScrollingEnabled(false);
        RecyclerListView recyclerListView2 = this.colorRecyclerView;
        ProductColorAdapter productColorAdapter = new ProductColorAdapter(context);
        this.colorsAdapter = productColorAdapter;
        recyclerListView2.setAdapter(productColorAdapter);
        this.colorRecyclerView.setLayoutManager(new GridLayoutManager(this, context, 5) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected boolean isLayoutRTL() {
                return true;
            }
        });
        this.chooseColorLayout.addView(this.colorRecyclerView, LayoutHelper.createLinear(-2, -2, 5, 16, 0, 16, 8));
        this.chooseColorLayout.addView(createLine(context), LayoutHelper.createLinear(-1, 1, 0, 16, 8, 16, 8));
        this.linearLayout.addView(this.chooseColorLayout, LayoutHelper.createLinear(-1, -2));
        this.chooseColorLayout.setVisibility(8);
    }

    private void initDescriptionView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.descriptionLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.descriptionLayout.addView(createTextView(context, LocaleController.getString(R.string.ProductDescription)), LayoutHelper.createLinear(-2, -2, 5, 0, 32, 16, 8));
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, false);
        this.descriptionTextView = textViewCreateTextViewBlack;
        textViewCreateTextViewBlack.setGravity(5);
        this.descriptionTextView.setMaxLines(4);
        this.descriptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.descriptionLayout.addView(this.descriptionTextView, LayoutHelper.createLinear(-1, -2, 5, 0, 32, 16, 8));
        TextView textViewCreateTextView = createTextView(context, LocaleController.getString(R.string.product_more));
        this.moreTextView = textViewCreateTextView;
        textViewCreateTextView.setTextColor(context.getResources().getColor(R.color.shop_blue));
        this.moreTextView.setVisibility(8);
        this.moreTextView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.moreTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initDescriptionView$4(view);
            }
        });
        this.descriptionLayout.addView(this.moreTextView, LayoutHelper.createLinear(-2, -2, 3, 16, 8, 16, 0));
        this.descriptionLayout.addView(createLine(context), LayoutHelper.createLinear(-1, 1, 0, 0, 8, 0, 8));
        this.linearLayout.addView(this.descriptionLayout, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDescriptionView$4(View view) {
        if (!this.isExpandDescription) {
            this.isExpandDescription = true;
            ObjectAnimator.ofInt(this.descriptionTextView, "maxLines", 40).setDuration(100L).start();
            this.moreTextView.setText(LocaleController.getString(R.string.product_less));
        } else {
            this.isExpandDescription = false;
            ObjectAnimator.ofInt(this.descriptionTextView, "maxLines", 4).setDuration(100L).start();
            this.moreTextView.setText(LocaleController.getString(R.string.product_more));
        }
    }

    private void initPropertiesView(Context context) {
        this.linearLayout.addView(createTextView(context, LocaleController.getString(R.string.ProductFeatures)), LayoutHelper.createLinear(-2, -2, 5, 16, 32, 16, 8));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        recyclerListView.setNestedScrollingEnabled(false);
        ProductPropertyAdapter productPropertyAdapter = new ProductPropertyAdapter(context);
        this.propertiesAdapter = productPropertyAdapter;
        recyclerListView.setAdapter(productPropertyAdapter);
        recyclerListView.setLayoutManager(new LinearLayoutManager(context));
        this.linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-1, -2, 5, 16, 8, 16, 8));
    }

    private TextView createTextView(Context context, String str) {
        TextView textViewCreateShopTextView = ViewHelper.createShopTextView(context, 16, Theme.getColor(Theme.key_chats_name), true);
        textViewCreateShopTextView.setText(str);
        return textViewCreateShopTextView;
    }

    private View createLine(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.shop_grey));
        return view;
    }

    private static class SliderAdapter extends PagerAdapter {
        private final ArrayList<ShopModels.InputFile> images = new ArrayList<>();
        private final Context mContext;

        public SliderAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.images.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            ShopModels.InputFile inputFile = this.images.get(i);
            if (inputFile == null || inputFile.main_file == null) {
                return super.instantiateItem(viewGroup, i);
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            GlideHelper.load(this.mContext, imageView, inputFile.main_file.file_url);
            viewGroup.addView(imageView, 0);
            return imageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        public void setImages(ArrayList<ShopModels.InputFile> arrayList) {
            if (arrayList == null) {
                return;
            }
            this.images.clear();
            this.images.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SpansContainer extends ViewGroup {
        private View addingSpan;
        private boolean animationStarted;
        private ArrayList<Animator> animators;
        private AnimatorSet currentAnimation;
        private SizeTextView selectedItem;

        public SpansContainer(Context context) {
            super(context);
            this.animators = new ArrayList<>();
            this.selectedItem = null;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int iMin;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i);
            int iDp = size - AndroidUtilities.dp(32.0f);
            int iDp2 = AndroidUtilities.dp(12.0f);
            int iDp3 = AndroidUtilities.dp(12.0f);
            int measuredWidth = 0;
            int measuredWidth2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof SizeTextView) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                    if (childAt.getMeasuredWidth() + measuredWidth > iDp) {
                        iDp2 += childAt.getMeasuredHeight() + AndroidUtilities.dp(12.0f);
                        measuredWidth = 0;
                    }
                    if (childAt.getMeasuredWidth() + measuredWidth2 > iDp) {
                        iDp3 += childAt.getMeasuredHeight() + AndroidUtilities.dp(12.0f);
                        measuredWidth2 = 0;
                    }
                    int iDp4 = AndroidUtilities.dp(16.0f) + measuredWidth;
                    if (!this.animationStarted) {
                        childAt.setTranslationX((size - iDp4) - childAt.getMeasuredWidth());
                        childAt.setTranslationY(iDp2);
                    }
                    measuredWidth += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                    measuredWidth2 += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                }
            }
            if (AndroidUtilities.isTablet()) {
                iMin = AndroidUtilities.dp(366.0f) / 3;
            } else {
                Point point = AndroidUtilities.displaySize;
                iMin = (Math.min(point.x, point.y) - AndroidUtilities.dp(164.0f)) / 3;
            }
            if (iDp - measuredWidth < iMin) {
                iDp2 += AndroidUtilities.dp(44.0f);
            }
            if (iDp - measuredWidth2 < iMin) {
                iDp3 += AndroidUtilities.dp(44.0f);
            }
            if (!this.animationStarted) {
                int iDp5 = iDp3 + AndroidUtilities.dp(44.0f);
                ProductDetailFragment.this.fieldY = iDp2;
                if (this.currentAnimation == null) {
                    ProductDetailFragment.this.containerHeight = iDp5;
                } else {
                    int iDp6 = iDp2 + AndroidUtilities.dp(44.0f);
                    if (ProductDetailFragment.this.containerHeight != iDp6) {
                        this.animators.add(ObjectAnimator.ofInt(ProductDetailFragment.this, "containerHeight", iDp6));
                    }
                    this.currentAnimation.playTogether(this.animators);
                    this.currentAnimation.start();
                    this.animationStarted = true;
                }
            }
            setMeasuredDimension(size, ProductDetailFragment.this.containerHeight);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        public void addSpan(final SizeTextView sizeTextView) {
            sizeTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment$SpansContainer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addSpan$0(sizeTextView, view);
                }
            });
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.setupEndValues();
                this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductDetailFragment.SpansContainer.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.addingSpan = null;
                    SpansContainer.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                }
            });
            this.currentAnimation.setDuration(150L);
            this.addingSpan = sizeTextView;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "scaleX", 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "scaleY", 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "alpha", 0.0f, 1.0f));
            addView(sizeTextView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addSpan$0(SizeTextView sizeTextView, View view) {
            setSelectedItem(sizeTextView);
        }

        private void setSelectedItem(SizeTextView sizeTextView) {
            if (sizeTextView != null) {
                SizeTextView sizeTextView2 = this.selectedItem;
                if (sizeTextView2 == null || sizeTextView2 != sizeTextView) {
                    if (sizeTextView2 != null) {
                        sizeTextView2.setSelected(false);
                    }
                    sizeTextView.setSelected(true);
                    this.selectedItem = sizeTextView;
                }
            }
        }

        public void setSelectedItem(int i) {
            if (i < 0 || i >= getChildCount()) {
                return;
            }
            setSelectedItem((SizeTextView) getChildAt(i));
        }
    }

    @Keep
    public void setContainerHeight(int i) {
        this.containerHeight = i;
        SpansContainer spansContainer = this.spansContainer;
        if (spansContainer != null) {
            spansContainer.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SizeTextView extends TextView {
        private final Drawable selectedDrawable;
        private final Drawable unselectedDrawable;
        private CharSequence value;

        public SizeTextView(Context context) {
            super(context);
            this.value = null;
            setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f));
            setGravity(17);
            this.selectedDrawable = context.getResources().getDrawable(R.drawable.shop_bg_circle_blue_rounded_border);
            this.unselectedDrawable = context.getResources().getDrawable(R.drawable.shop_bg_circle_gray_rounded_border);
            setMaxLines(1);
            setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
            setTextColor(Theme.getColor(Theme.key_chats_name));
            setSelected(false);
            setTextSize(1, 14.0f);
            setMinimumWidth(AndroidUtilities.dp(50.0f));
        }

        @Override // android.widget.TextView, android.view.View
        public void setSelected(boolean z) {
            if (z) {
                setBackground(this.selectedDrawable);
            } else {
                setBackground(this.unselectedDrawable);
            }
        }

        public CharSequence getValue() {
            return this.value;
        }

        @Override // android.widget.TextView
        public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
            super.setText(NumberUtils.toPersian(String.valueOf(charSequence)), bufferType);
            this.value = charSequence;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.mainCompositeDisposable.dispose();
    }
}
