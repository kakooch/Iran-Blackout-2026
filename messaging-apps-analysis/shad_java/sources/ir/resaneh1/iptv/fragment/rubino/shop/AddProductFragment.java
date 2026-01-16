package ir.resaneh1.iptv.fragment.rubino.shop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.rghapp.components.FrameLayoutLikeLinear;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductImageCell;
import ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator;
import ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetProductDetailInput;
import ir.resaneh1.iptv.model.GetProductDetailOutput;
import ir.resaneh1.iptv.model.GetStoreDetailInput;
import ir.resaneh1.iptv.model.GetStoreDetailOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Components.Switch;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class AddProductFragment extends BaseFragment {
    private ShopModels.AddProductInput addProductInput;
    AddProductStepsRow addProductStepsRow;
    private AttributeView attributeView;
    private Context context;
    private ShopModels.EditProductInput editProductInput;
    private FrameLayout frameLayoutNext;
    private FrameLayout frameLayoutPrev;
    private InfoView infoView;
    private boolean isLoadingStore;
    private boolean isRequestInProgress;
    private View[] pages;
    private AnimatorSet pagesAnimation;
    private PriceView priceView;
    private ShopModels.Product product;
    private String productID;
    private String storeID;
    TextView textViewNext;
    TextView textViewPrev;
    private boolean toEdit;
    private TypeView typeView;
    private int infoPageNumber = 0;
    private int attributePageNumber = 1;
    private int typePageNumber = 2;
    private int pricePageNumber = 3;
    private int pageCount = 4;
    private int currentStep = -1;

    public AddProductFragment(String str, String str2) {
        this.storeID = str;
        ShopModels.EditProductInput editProductInput = new ShopModels.EditProductInput();
        this.editProductInput = editProductInput;
        editProductInput.store_id = str;
        editProductInput.product_id = str2;
        this.productID = str2;
        ShopModels.AddProductInput addProductInput = new ShopModels.AddProductInput();
        this.addProductInput = addProductInput;
        addProductInput.store_id = str;
        this.toEdit = true;
    }

    public AddProductFragment(String str) {
        this.storeID = str;
        ShopModels.AddProductInput addProductInput = new ShopModels.AddProductInput();
        this.addProductInput = addProductInput;
        addProductInput.store_id = str;
        this.toEdit = false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.context = context;
        this.needLockOrientation = true;
        this.swipeBackEnabled = false;
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        int i = Theme.key_windowBackgroundWhite;
        frameLayout.setBackgroundColor(Theme.getColor(i));
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setTitle(LocaleController.getString(R.string.shop_add_product));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    AddProductFragment.this.finishFragment();
                }
            }
        });
        ScrollView scrollView = new ScrollView(context);
        scrollView.setFillViewport(true);
        frameLayout.addView(scrollView, LayoutHelper.createFrame(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Theme.getColor(i));
        scrollView.addView(linearLayout, LayoutHelper.createFrame(-1, -2));
        linearLayout.addView(new ShadowSectionCell(context), LayoutHelper.createFrame(-1, -2));
        AddProductStepsRow addProductStepsRow = new AddProductStepsRow(this, context);
        this.addProductStepsRow = addProductStepsRow;
        linearLayout.addView(addProductStepsRow, LayoutHelper.createFrame(-1, -2));
        linearLayout.addView(new ShadowSectionCell(context), LayoutHelper.createFrame(-1, -2));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setPadding(0, 0, 0, AndroidUtilities.dp(64.0f));
        linearLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, -2));
        this.pages = new View[this.pageCount];
        InfoView infoView = new InfoView(context);
        this.infoView = infoView;
        frameLayout2.addView(infoView, LayoutHelper.createFrame(-1, -2));
        this.pages[this.infoPageNumber] = this.infoView;
        AttributeView attributeView = new AttributeView(context);
        this.attributeView = attributeView;
        frameLayout2.addView(attributeView, LayoutHelper.createFrame(-1, -2));
        View[] viewArr = this.pages;
        int i2 = this.attributePageNumber;
        AttributeView attributeView2 = this.attributeView;
        viewArr[i2] = attributeView2;
        attributeView2.setVisibility(4);
        TypeView typeView = new TypeView(context);
        this.typeView = typeView;
        frameLayout2.addView(typeView, LayoutHelper.createFrame(-1, -2));
        View[] viewArr2 = this.pages;
        int i3 = this.typePageNumber;
        TypeView typeView2 = this.typeView;
        viewArr2[i3] = typeView2;
        typeView2.setVisibility(4);
        PriceView priceView = new PriceView(context);
        this.priceView = priceView;
        frameLayout2.addView(priceView, LayoutHelper.createFrame(-1, -2));
        View[] viewArr3 = this.pages;
        int i4 = this.pricePageNumber;
        PriceView priceView2 = this.priceView;
        viewArr3[i4] = priceView2;
        priceView2.setVisibility(4);
        new ShadowSectionCell(context);
        this.frameLayoutNext = new FrameLayout(context);
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 14, -1, false);
        this.textViewNext = textViewCreateTextView;
        textViewCreateTextView.setText(LocaleController.getString(R.string.shop_next));
        this.textViewNext.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_blue));
        this.textViewNext.setGravity(17);
        this.textViewNext.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.textViewNext.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddProductFragment.this.currentStep == AddProductFragment.this.infoPageNumber) {
                    if (!AddProductFragment.this.infoView.isValidData()) {
                        ToastiLikeSnack.showL(context, AddProductFragment.this.infoView.errorMessage);
                        return;
                    }
                    AddProductFragment.this.infoView.setAddProductValues(AddProductFragment.this.addProductInput);
                } else if (AddProductFragment.this.currentStep == AddProductFragment.this.attributePageNumber) {
                    AddProductFragment.this.attributeView.setAddProductValues(AddProductFragment.this.addProductInput);
                } else if (AddProductFragment.this.currentStep == AddProductFragment.this.typePageNumber) {
                    AddProductFragment.this.typeView.setAddProductValues(AddProductFragment.this.addProductInput);
                } else if (AddProductFragment.this.currentStep == AddProductFragment.this.pricePageNumber) {
                    if (!AddProductFragment.this.priceView.isValidData()) {
                        ToastiLikeSnack.showL(context, AddProductFragment.this.priceView.errorMessage);
                        return;
                    }
                    AddProductFragment.this.priceView.setAddProductValues(AddProductFragment.this.addProductInput);
                    if (AddProductFragment.this.toEdit) {
                        AddProductFragment.this.callEditProduct();
                    } else {
                        AddProductFragment.this.callAddProduct();
                    }
                }
                if (AddProductFragment.this.currentStep < AddProductFragment.this.pageCount - 1) {
                    AddProductFragment addProductFragment = AddProductFragment.this;
                    addProductFragment.setStep(addProductFragment.currentStep + 1);
                }
            }
        });
        this.frameLayoutNext.addView(this.textViewNext, LayoutHelper.createFrame(-1, -2, 17, 8.0f, 4.0f, 4.0f, 4.0f));
        this.frameLayoutPrev = new FrameLayout(context);
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, false);
        this.textViewPrev = textViewCreateTextViewBlack;
        textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.shop_previous));
        this.textViewPrev.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_black));
        this.textViewPrev.setGravity(17);
        this.textViewPrev.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.textViewPrev.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AddProductFragment.this.currentStep <= 0) {
                    if (AddProductFragment.this.currentStep == 0) {
                        AddProductFragment.this.finishFragment();
                    }
                } else {
                    AddProductFragment.this.setStep(r2.currentStep - 1);
                }
            }
        });
        this.frameLayoutPrev.addView(this.textViewPrev, LayoutHelper.createFrame(-1, -2, 17, 4.0f, 4.0f, 8.0f, 4.0f));
        FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(context);
        frameLayoutLikeLinear.addView(this.frameLayoutNext);
        frameLayoutLikeLinear.addView(this.frameLayoutPrev);
        frameLayoutLikeLinear.setBackgroundColor(Theme.getColor(i));
        frameLayout.addView(frameLayoutLikeLinear, LayoutHelper.createFrame(-1, -2, 80));
        this.currentStep = 0;
        updateButtons();
        setStep(this.currentStep);
        if (this.toEdit) {
            callGetProduct();
        } else {
            callGetStore();
        }
        return this.fragmentView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        this.infoView.imageUpdater.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAddProduct() {
        if (this.isRequestInProgress) {
            return;
        }
        this.isRequestInProgress = true;
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).addProduct(this.addProductInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.AddProductOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.AddProductOutput> messangerOutput) {
                MyLog.e("AddProductFragment", messangerOutput.data.product.id);
                if (MyLog.isDebugAble) {
                    ToastiLikeSnack.showL(AddProductFragment.this.context, "success");
                }
                AddProductFragment.this.finishFragment();
                AddProductFragment.this.isRequestInProgress = false;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ToastiLikeSnack.showL(AddProductFragment.this.context, LocaleController.getString(R.string.shop_retry));
                AddProductFragment.this.isRequestInProgress = false;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callEditProduct() {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.callEditProduct():void");
    }

    private void callGetProduct() {
        final LoadingDialog loadingDialog = new LoadingDialog(this.context);
        GetProductDetailInput getProductDetailInput = new GetProductDetailInput();
        getProductDetailInput.product_id = this.productID;
        getProductDetailInput.store_id = this.storeID;
        this.compositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProductDetail(getProductDetailInput).subscribeWith(new DisposableObserver<MessangerOutput<GetProductDetailOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.6
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetProductDetailOutput> messangerOutput) {
                loadingDialog.dismiss();
                GetProductDetailOutput getProductDetailOutput = messangerOutput.data;
                if (getProductDetailOutput != null) {
                    AddProductFragment.this.setProduct(getProductDetailOutput.product);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadingDialog.dismiss();
            }
        }));
        loadingDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProduct(ShopModels.Product product) {
        this.product = product;
        this.infoView.setData(product);
        this.typeView.setData(product);
        this.attributeView.setData(product);
        this.priceView.setData(product);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InfoView extends FrameLayout {
        private ArrayList<ShopModels.ProductCategory> categories;
        EditText editTextDescription;
        EditText editTextName;
        public String errorMessage;
        private ShopImageUpdater imageUpdater;
        private ArrayList<ShopModels.ShopImage> images;
        private FrameLayout imagesContainer;
        private boolean isLoading;
        private ImageListAdapter listAdapter;
        private RecyclerListView listView;
        private ShopModels.ProductCategory selectedCategory;
        TextView textViewCategory;

        public InfoView(Context context) {
            super(context);
            this.categories = new ArrayList<>();
            this.images = new ArrayList<>();
            LayoutInflater.from(context).inflate(R.layout.shop_layout_add_product_info, this);
            this.editTextName = (EditText) findViewById(R.id.editTextName);
            this.textViewCategory = (TextView) findViewById(R.id.textViewCategory);
            this.editTextDescription = (EditText) findViewById(R.id.editTextDescription);
            this.editTextName.setHint(LocaleController.getString(R.string.shop_enter));
            this.textViewCategory.setHint(LocaleController.getString(R.string.shop_select));
            this.editTextDescription.setHint(LocaleController.getString(R.string.shop_enter));
            this.imagesContainer = (FrameLayout) findViewById(R.id.frameLayoutImagesContainer);
            TextView textView = (TextView) findViewById(R.id.textViewNameTitle);
            int i = Theme.key_dialogTextBlack;
            textView.setTextColor(Theme.getColor(i));
            ((TextView) findViewById(R.id.textViewNameTitle)).setText(LocaleController.getString(R.string.product_name_star));
            ((TextView) findViewById(R.id.textViewCategoryTitle)).setTextColor(Theme.getColor(i));
            ((TextView) findViewById(R.id.textViewCategoryTitle)).setText(LocaleController.getString(R.string.product_category_star));
            ((TextView) findViewById(R.id.textViewImagesTitle)).setTextColor(Theme.getColor(i));
            ((TextView) findViewById(R.id.textViewImagesTitle)).setText(LocaleController.getString(R.string.product_images_star));
            ((TextView) findViewById(R.id.textViewDescriptionTitle)).setTextColor(Theme.getColor(i));
            ((TextView) findViewById(R.id.textViewDescriptionTitle)).setText(LocaleController.getString(R.string.product_description));
            this.textViewCategory.setTextColor(Theme.getColor(i));
            this.editTextName.setTextColor(Theme.getColor(i));
            EditText editText = this.editTextName;
            int i2 = Theme.key_dialogTextGray2;
            editText.setHintTextColor(Theme.getColor(i2));
            this.editTextDescription.setTextColor(Theme.getColor(i));
            this.editTextDescription.setHintTextColor(Theme.getColor(i2));
            this.editTextDescription.setFocusable(true);
            EditText editText2 = this.editTextDescription;
            editText2.setFilters(InputFilterHelper.getFilter(2200, 20, editText2));
            this.textViewCategory.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$InfoView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            RecyclerListView recyclerListView = new RecyclerListView(context);
            this.listView = recyclerListView;
            recyclerListView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            RecyclerListView recyclerListView2 = this.listView;
            ImageListAdapter imageListAdapter = new ImageListAdapter(context);
            this.listAdapter = imageListAdapter;
            recyclerListView2.setAdapter(imageListAdapter);
            this.imagesContainer.addView(this.listView);
            this.listAdapter.updateRows();
            this.imageUpdater = new ShopImageUpdater(UserConfig.selectedAccount, AddProductFragment.this.storeID);
            this.listView.setOnItemClickListener(new AnonymousClass1(AddProductFragment.this));
            this.imageUpdater.delegate = new ShopImageUpdater.ImageUpdaterDelegate(AddProductFragment.this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.InfoView.2
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.ImageUpdaterDelegate
                public void didUploadedPhoto(ShopModels.ShopImage shopImage) {
                    InfoView.this.listAdapter.notifyDataSetChanged();
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.ImageUpdaterDelegate
                public void didStartUploadPhoto(ShopModels.ShopImage shopImage) {
                    InfoView.this.images.add(0, shopImage);
                    InfoView.this.listAdapter.updateRows();
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.ImageUpdaterDelegate
                public void didFaildUploadPhoto(ShopModels.ShopImage shopImage) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.InfoView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InfoView.this.listAdapter.notifyDataSetChanged();
                        }
                    });
                }
            };
            this.imageUpdater.parentFragment = AddProductFragment.this;
            callGetCategories();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            if (this.isLoading) {
                return;
            }
            if (this.categories.size() == 0) {
                callGetCategories(true);
            } else {
                showCategoryDialog();
            }
        }

        /* renamed from: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$InfoView$1, reason: invalid class name */
        class AnonymousClass1 implements RecyclerListView.OnItemClickListener {
            AnonymousClass1(AddProductFragment addProductFragment) {
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (i == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddProductFragment.this.getParentActivity());
                    builder.setItems(new CharSequence[]{LocaleController.getString("FromCamera", R.string.FromCamera), LocaleController.getString("FromGalley", R.string.FromGalley)}, new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$InfoView$1$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onItemClick$0(dialogInterface, i2);
                        }
                    });
                    AddProductFragment.this.showDialog(builder.create());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onItemClick$0(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    InfoView.this.imageUpdater.openCamera();
                } else if (i == 1) {
                    InfoView.this.imageUpdater.openGallery();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showCategoryDialog() {
            AddProductFragment.this.showDialog(ShopAlertsCreator.createItemPickerDialog(AddProductFragment.this.context, LocaleController.getString(R.string.product_category), false, false, this.categories, new ShopAlertsCreator.ItemPickerDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.InfoView.3
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
                public void selectedItemChanged(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
                public void didSelectItems(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
                    InfoView infoView = InfoView.this;
                    infoView.textViewCategory.setText(AddProductFragment.this.getNameStringOfArray(arrayList));
                    if (arrayList.size() > 0) {
                        InfoView.this.selectedCategory = (ShopModels.ProductCategory) arrayList.get(0);
                    }
                }
            }).create());
        }

        public ShopModels.ProductCategory getSelectedCategory() {
            return this.selectedCategory;
        }

        public boolean isValidData() {
            this.errorMessage = LocaleController.getString(R.string.shop_add_product_error);
            if (this.editTextName.getText().toString().trim().isEmpty()) {
                this.errorMessage = LocaleController.getString(R.string.shop_add_product_error_name);
                return false;
            }
            if (this.selectedCategory == null) {
                this.errorMessage = LocaleController.getString(R.string.shop_add_product_error_category);
                return false;
            }
            if (this.images.size() == 0) {
                this.errorMessage = LocaleController.getString(R.string.shop_add_product_error_media);
                return false;
            }
            if (getMedia().size() != 0) {
                return true;
            }
            this.errorMessage = LocaleController.getString(R.string.shop_add_product_error_media);
            return false;
        }

        public ShopModels.AddProductInput setAddProductValues(ShopModels.AddProductInput addProductInput) {
            String strTrim = this.editTextName.getText().toString().trim();
            if (strTrim.isEmpty()) {
                strTrim = null;
            }
            addProductInput.product_name = strTrim;
            addProductInput.description = !this.editTextDescription.getText().toString().isEmpty() ? this.editTextDescription.getText().toString() : null;
            ShopModels.ProductCategory productCategory = this.selectedCategory;
            addProductInput.product_category_id = productCategory != null ? productCategory.id : null;
            ArrayList<ShopModels.InputFile> media = getMedia();
            if (media.size() > 0) {
                addProductInput.media = media;
            }
            return addProductInput;
        }

        private ArrayList<ShopModels.InputFile> getMedia() {
            ArrayList<ShopModels.InputFile> arrayList = new ArrayList<>();
            ArrayList<ShopModels.ShopImage> arrayList2 = this.images;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<ShopModels.ShopImage> it = this.images.iterator();
                while (it.hasNext()) {
                    ShopModels.ShopImage next = it.next();
                    ShopModels.InputFile inputFile = next.outputFile;
                    if (inputFile != null) {
                        arrayList.add(inputFile);
                    } else {
                        ShopModels.InputFile inputFile2 = next.inputFile;
                        if (inputFile2 != null) {
                            arrayList.add(inputFile2);
                        }
                    }
                }
            }
            return arrayList;
        }

        private void callGetCategories() {
            callGetCategories(false);
        }

        private void callGetCategories(final boolean z) {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            final LoadingDialog loadingDialog = null;
            if (z) {
                loadingDialog = new LoadingDialog(AddProductFragment.this.context);
                loadingDialog.show();
            }
            AddProductFragment addProductFragment = AddProductFragment.this;
            addProductFragment.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(((BaseFragment) addProductFragment).currentAccount).getProductCategories(new ShopModels.EmptyInput()).doOnNext(new Consumer<MessangerOutput<ShopModels.GetProductCategoriesOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.InfoView.5
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<ShopModels.GetProductCategoriesOutput> messangerOutput) throws Exception {
                    ShopModels.GetProductCategoriesOutput getProductCategoriesOutput;
                    if (messangerOutput == null || (getProductCategoriesOutput = messangerOutput.data) == null || getProductCategoriesOutput.product_categories == null) {
                        return;
                    }
                    InfoView.this.categories.clear();
                    InfoView.this.categories.addAll(messangerOutput.data.product_categories);
                }
            }).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.GetProductCategoriesOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.InfoView.4
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<ShopModels.GetProductCategoriesOutput> messangerOutput) {
                    InfoView.this.isLoading = false;
                    if (z) {
                        loadingDialog.dismiss();
                        InfoView.this.showCategoryDialog();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (z) {
                        loadingDialog.dismiss();
                    }
                    InfoView.this.isLoading = false;
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        class ImageListAdapter extends RecyclerListView.SelectionAdapter {
            private int addItemRow;
            private int itemEndRow;
            private int itemStartRow;
            private int rowCount;

            public void updateRows() {
                this.addItemRow = -1;
                this.itemStartRow = -1;
                this.itemEndRow = -1;
                this.rowCount = 0;
                if (hasAddItem()) {
                    int i = this.rowCount;
                    this.rowCount = i + 1;
                    this.addItemRow = i;
                }
                int i2 = this.rowCount;
                this.itemStartRow = i2;
                int size = i2 + InfoView.this.images.size();
                this.rowCount = size;
                this.itemEndRow = size;
                notifyDataSetChanged();
            }

            public ImageListAdapter(Context context) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.rowCount;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
                viewHolder.getItemViewType();
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
                return viewHolder.itemView instanceof AddImageCell;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                View addImageCell;
                if (i == 1) {
                    addImageCell = new AddImageCell(InfoView.this.getContext());
                } else {
                    addImageCell = new ProductImageCell(InfoView.this.getContext(), new ProductImageCell.DeleteListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$InfoView$ImageListAdapter$$ExternalSyntheticLambda0
                        @Override // ir.resaneh1.iptv.fragment.rubino.shop.ProductImageCell.DeleteListener
                        public final void onDeleteClick(ShopModels.ShopImage shopImage) {
                            this.f$0.lambda$onCreateViewHolder$0(shopImage);
                        }
                    });
                }
                return new RecyclerListView.Holder(addImageCell);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCreateViewHolder$0(ShopModels.ShopImage shopImage) {
                InfoView.this.images.remove(shopImage);
                InfoView.this.listAdapter.updateRows();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
                if (i < this.itemStartRow || i >= this.itemEndRow) {
                    return;
                }
                ((ProductImageCell) viewHolder.itemView).setImage((ShopModels.ShopImage) InfoView.this.images.get(i - this.itemStartRow));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return i == this.addItemRow ? 1 : 0;
            }

            private boolean hasAddItem() {
                return InfoView.this.images.size() < 10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ShopModels.Product product) {
            this.editTextName.setText(product.product_name);
            this.editTextDescription.setText(product.description);
            ShopModels.ProductCategory productCategory = product.product_category;
            this.selectedCategory = productCategory;
            this.textViewCategory.setText(productCategory.category_name);
            ArrayList<ShopModels.InputFile> arrayList = product.media;
            if (arrayList != null) {
                Iterator<ShopModels.InputFile> it = arrayList.iterator();
                while (it.hasNext()) {
                    ShopModels.InputFile next = it.next();
                    ShopModels.ShopImage shopImage = new ShopModels.ShopImage();
                    shopImage.outputFile = next;
                    this.images.add(shopImage);
                }
                this.listAdapter.updateRows();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSelectedCategory(ShopModels.ProductCategory productCategory) {
            if (productCategory == null) {
                return;
            }
            this.textViewCategory.setText(productCategory.getName());
            this.selectedCategory = productCategory;
            productCategory.isSelected = true;
        }
    }

    private class AttributeView extends FrameLayout {
        AttributeRow.OnChangeListener changeListener;
        private int count;
        private LinearLayout linearLayout;
        private int maxCount;

        static /* synthetic */ int access$2810(AttributeView attributeView) {
            int i = attributeView.count;
            attributeView.count = i - 1;
            return i;
        }

        public AttributeView(Context context) {
            super(context);
            this.maxCount = 5;
            this.count = 0;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            addView(linearLayout, LayoutHelper.createFrame(-1, -2));
            TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.product_attribute_title));
            textViewCreateTextViewBlack.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack2.setText(LocaleController.getString(R.string.product_amount));
            textViewCreateTextViewBlack2.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(context);
            frameLayoutLikeLinear.addView(textViewCreateTextViewBlack2);
            frameLayoutLikeLinear.addView(textViewCreateTextViewBlack);
            frameLayoutLikeLinear.setWeights(new float[]{0.6f, 0.4f});
            linearLayout.addView(frameLayoutLikeLinear);
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.linearLayout = linearLayout2;
            linearLayout2.setOrientation(1);
            linearLayout.addView(this.linearLayout, -1, -2);
            AttributeRow.OnChangeListener onChangeListener = new AttributeRow.OnChangeListener(AddProductFragment.this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.AttributeView.1
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.AttributeRow.OnChangeListener
                public void onDeleteClick(AttributeRow attributeRow) {
                    if (AttributeView.this.count > 1) {
                        AttributeView.this.linearLayout.removeView(attributeRow);
                        AttributeView.access$2810(AttributeView.this);
                    }
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.AttributeRow.OnChangeListener
                public void onTextChanged(AttributeRow attributeRow) {
                    if (AttributeView.this.count < AttributeView.this.maxCount) {
                        attributeRow.showDeleteView();
                        AttributeView.this.addNewRow();
                    }
                }
            };
            this.changeListener = onChangeListener;
            this.linearLayout.addView(new AttributeRow(context, onChangeListener));
            this.count++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNewRow() {
            LinearLayout linearLayout = this.linearLayout;
            if (((AttributeRow) linearLayout.getChildAt(linearLayout.getChildCount() - 1)).imageViewDelete.getVisibility() == 0) {
                this.count++;
                final AttributeRow attributeRow = new AttributeRow(AddProductFragment.this.context, this.changeListener);
                attributeRow.setAlpha(0.0f);
                this.linearLayout.addView(attributeRow);
                int height = attributeRow.getHeight();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.AttributeView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        attributeRow.setAlpha(1.0f);
                    }
                });
                animatorSet.playTogether(ObjectAnimator.ofFloat(attributeRow, (Property<AttributeRow, Float>) View.TRANSLATION_Y, -height, 0.0f), ObjectAnimator.ofFloat(attributeRow, (Property<AttributeRow, Float>) View.ALPHA, 0.0f, 1.0f));
                animatorSet.setDuration(250L);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.start();
            }
        }

        public ShopModels.AddProductInput setAddProductValues(ShopModels.AddProductInput addProductInput) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < this.linearLayout.getChildCount(); i++) {
                View childAt = this.linearLayout.getChildAt(i);
                if (childAt instanceof AttributeRow) {
                    AttributeRow attributeRow = (AttributeRow) childAt;
                    if (!attributeRow.getValue().isEmpty() && !attributeRow.getKey().isEmpty()) {
                        map.put(attributeRow.getKey(), attributeRow.getValue());
                    }
                }
            }
            if (map.size() > 0) {
                addProductInput.features = map;
            }
            return addProductInput;
        }

        public void setData(ShopModels.Product product) {
            HashMap<String, String> map = product.features;
            if (map != null) {
                for (String str : map.keySet()) {
                    AttributeRow attributeRow = new AttributeRow(AddProductFragment.this.context, null);
                    attributeRow.editTextKey.setText(str);
                    attributeRow.editTextValue.setText(product.features.get(str));
                    attributeRow.onChangedListener = this.changeListener;
                    this.linearLayout.addView(attributeRow, 0);
                    this.count++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class AttributeRow extends FrameLayout {
        EditText editTextKey;
        EditText editTextValue;
        ImageView imageViewDelete;
        OnChangeListener onChangedListener;

        public interface OnChangeListener {
            void onDeleteClick(AttributeRow attributeRow);

            void onTextChanged(AttributeRow attributeRow);
        }

        public AttributeRow(Context context, OnChangeListener onChangeListener) {
            super(context);
            this.onChangedListener = onChangeListener;
            setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            ImageView imageView = new ImageView(context);
            this.imageViewDelete = imageView;
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.msg_delete));
            this.imageViewDelete.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#E74B50"), PorterDuff.Mode.MULTIPLY));
            this.imageViewDelete.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
            this.imageViewDelete.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$AttributeRow$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            this.imageViewDelete.setVisibility(4);
            EditText editTextCreateEditTextBlack = ViewHelper.createEditTextBlack(context, 14, false);
            this.editTextKey = editTextCreateEditTextBlack;
            editTextCreateEditTextBlack.setHint(LocaleController.getString(R.string.product_attribute_title_hint));
            this.editTextKey.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_grey));
            this.editTextKey.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            EditText editText = this.editTextKey;
            editText.setFilters(InputFilterHelper.getFilter(100, 2, editText));
            EditText editTextCreateEditTextBlack2 = ViewHelper.createEditTextBlack(context, 14, false);
            this.editTextValue = editTextCreateEditTextBlack2;
            editTextCreateEditTextBlack2.setHint(LocaleController.getString(R.string.shop_enter));
            this.editTextValue.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_grey));
            this.editTextValue.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            EditText editText2 = this.editTextValue;
            editText2.setFilters(InputFilterHelper.getFilter(ImageReceiver.DEFAULT_CROSSFADE_DURATION, 2, editText2));
            FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(context);
            frameLayoutLikeLinear.addView(this.imageViewDelete, LayoutHelper.createFrame(32, 32, 16));
            frameLayoutLikeLinear.addView(this.editTextValue);
            frameLayoutLikeLinear.addView(new View(context));
            frameLayoutLikeLinear.addView(this.editTextKey);
            frameLayoutLikeLinear.setWeights(new float[]{0.2f, 0.395f, 0.01f, 0.395f});
            addView(frameLayoutLikeLinear);
            TextWatcher textWatcher = new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.AttributeRow.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    AttributeRow attributeRow;
                    OnChangeListener onChangeListener2;
                    if (AttributeRow.this.imageViewDelete.getVisibility() != 0) {
                        if ((AttributeRow.this.getKey().isEmpty() && AttributeRow.this.getValue().isEmpty()) || (onChangeListener2 = (attributeRow = AttributeRow.this).onChangedListener) == null) {
                            return;
                        }
                        onChangeListener2.onTextChanged(attributeRow);
                    }
                }
            };
            this.editTextKey.addTextChangedListener(textWatcher);
            this.editTextValue.addTextChangedListener(textWatcher);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            OnChangeListener onChangeListener = this.onChangedListener;
            if (onChangeListener != null) {
                onChangeListener.onDeleteClick(this);
            }
        }

        public void showDeleteView() {
            this.imageViewDelete.setVisibility(0);
        }

        public String getKey() {
            return this.editTextKey.getText().toString();
        }

        public String getValue() {
            return this.editTextValue.getText().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class TypeView extends FrameLayout {
        SizeRow.OnChangeListener changeListener;
        ArrayList<ShopModels.ColorObject> colors;
        private int count;
        private boolean isLoading;
        private LinearLayout linearLayout;
        private int maxCount;
        private ArrayList<String> selected;
        TextView textViewValue;

        static /* synthetic */ int access$3210(TypeView typeView) {
            int i = typeView.count;
            typeView.count = i - 1;
            return i;
        }

        public TypeView(Context context) {
            super(context);
            this.maxCount = 10;
            this.count = 0;
            this.colors = new ArrayList<>();
            this.selected = new ArrayList<>();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            addView(linearLayout, LayoutHelper.createFrame(-1, -2));
            TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.product_color));
            textViewCreateTextViewBlack.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(context, 14, false);
            this.textViewValue = textViewCreateTextViewBlack2;
            textViewCreateTextViewBlack2.setText(LocaleController.getString(R.string.shop_select));
            this.textViewValue.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_grey));
            this.textViewValue.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            this.textViewValue.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$TypeView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            TextView textViewCreateTextViewBlack3 = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack3.setText(LocaleController.getString(R.string.product_size));
            textViewCreateTextViewBlack3.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            linearLayout.addView(textViewCreateTextViewBlack);
            linearLayout.addView(this.textViewValue);
            linearLayout.addView(textViewCreateTextViewBlack3, LayoutHelper.createFrame(-1, -2, 5, 0.0f, 16.0f, 0.0f, 0.0f));
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.linearLayout = linearLayout2;
            linearLayout2.setOrientation(1);
            linearLayout.addView(this.linearLayout, -1, -2);
            SizeRow.OnChangeListener onChangeListener = new SizeRow.OnChangeListener(AddProductFragment.this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.TypeView.1
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.SizeRow.OnChangeListener
                public void onDeleteClick(SizeRow sizeRow) {
                    if (TypeView.this.count > 1) {
                        TypeView.this.linearLayout.removeView(sizeRow);
                        TypeView.access$3210(TypeView.this);
                    }
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.SizeRow.OnChangeListener
                public void onTextChanged(SizeRow sizeRow) {
                    if (TypeView.this.count < TypeView.this.maxCount) {
                        sizeRow.showDeleteView();
                        TypeView.this.addNewRow();
                    }
                }
            };
            this.changeListener = onChangeListener;
            this.linearLayout.addView(new SizeRow(context, onChangeListener));
            this.count++;
            callGetColors();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            if (this.isLoading) {
                return;
            }
            if (this.colors.size() == 0) {
                callGetColors(true);
            } else {
                showColorsDialog();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNewRow() {
            LinearLayout linearLayout = this.linearLayout;
            if (((SizeRow) linearLayout.getChildAt(linearLayout.getChildCount() - 1)).imageViewDelete.getVisibility() == 0) {
                this.count++;
                final SizeRow sizeRow = new SizeRow(AddProductFragment.this.context, this.changeListener);
                sizeRow.setAlpha(0.0f);
                this.linearLayout.addView(sizeRow);
                int height = sizeRow.getHeight();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.TypeView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        sizeRow.setAlpha(1.0f);
                    }
                });
                animatorSet.playTogether(ObjectAnimator.ofFloat(sizeRow, (Property<SizeRow, Float>) View.TRANSLATION_Y, -height, 0.0f), ObjectAnimator.ofFloat(sizeRow, (Property<SizeRow, Float>) View.ALPHA, 0.0f, 1.0f));
                animatorSet.setDuration(250L);
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.start();
            }
        }

        public void callGetColors() {
            callGetColors(false);
        }

        public void callGetColors(final boolean z) {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            final LoadingDialog loadingDialog = null;
            if (z) {
                loadingDialog = new LoadingDialog(AddProductFragment.this.context);
                loadingDialog.show();
            }
            AddProductFragment addProductFragment = AddProductFragment.this;
            addProductFragment.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(((BaseFragment) addProductFragment).currentAccount).getColorsShop(new ShopModels.EmptyInput()).doOnNext(new Consumer<MessangerOutput<ShopModels.GetColorsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.TypeView.4
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<ShopModels.GetColorsOutput> messangerOutput) throws Exception {
                    ShopModels.GetColorsOutput getColorsOutput;
                    if (messangerOutput == null || (getColorsOutput = messangerOutput.data) == null || getColorsOutput.colors == null) {
                        return;
                    }
                    TypeView.this.colors.clear();
                    TypeView.this.colors.addAll(messangerOutput.data.colors);
                }
            }).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.GetColorsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.TypeView.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<ShopModels.GetColorsOutput> messangerOutput) {
                    if (z) {
                        loadingDialog.dismiss();
                        TypeView.this.showColorsDialog();
                    }
                    TypeView.this.isLoading = false;
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (z) {
                        loadingDialog.dismiss();
                    }
                    TypeView.this.isLoading = false;
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showColorsDialog() {
            AlertDialog alertDialogCreate = ShopAlertsCreator.createItemPickerDialog(AddProductFragment.this.context, LocaleController.getString(R.string.product_color), true, true, this.colors, new ShopAlertsCreator.ItemPickerDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.TypeView.5
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
                public void selectedItemChanged(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
                }

                @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
                public void didSelectItems(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
                    TypeView.this.selected.clear();
                    TypeView.this.textViewValue.setText(BuildConfig.FLAVOR);
                    TypeView.this.textViewValue.setHint(LocaleController.getString(R.string.shop_select));
                    if (arrayList.size() > 0) {
                        TypeView typeView = TypeView.this;
                        typeView.textViewValue.setText(AddProductFragment.this.getNameStringOfArray(arrayList));
                        TypeView.this.selected.addAll(AddProductFragment.this.getIdArrayOfArray(arrayList));
                    }
                }
            }).create();
            alertDialogCreate.setCanCancel(false);
            AddProductFragment.this.showDialog(alertDialogCreate);
        }

        public ShopModels.AddProductInput setAddProductValues(ShopModels.AddProductInput addProductInput) {
            ArrayList<ShopModels.ProductVariety> arrayList = new ArrayList<>();
            ShopModels.ProductVariety colorValues = getColorValues();
            ShopModels.ProductVariety sizeValues = getSizeValues();
            if (colorValues != null) {
                arrayList.add(colorValues);
            }
            if (sizeValues != null) {
                arrayList.add(sizeValues);
            }
            if (arrayList.size() > 0) {
                addProductInput.product_variety = arrayList;
            }
            return addProductInput;
        }

        public ShopModels.ProductVariety getColorValues() {
            if (!(AddProductFragment.this.toEdit && AddProductFragment.this.product.colors.size() > 0 && this.selected.size() == 0) && this.selected.size() <= 0) {
                return null;
            }
            ShopModels.ProductVariety productVariety = new ShopModels.ProductVariety();
            productVariety.type = ShopModels.ProductVarietyTypeEnum.Color;
            productVariety.variety_values = this.selected;
            return productVariety;
        }

        public ShopModels.ProductVariety getSizeValues() {
            ShopModels.ProductVariety productVariety = new ShopModels.ProductVariety();
            productVariety.type = ShopModels.ProductVarietyTypeEnum.Size;
            productVariety.variety_values = new ArrayList<>();
            for (int i = 0; i < this.linearLayout.getChildCount(); i++) {
                View childAt = this.linearLayout.getChildAt(i);
                if (childAt instanceof SizeRow) {
                    SizeRow sizeRow = (SizeRow) childAt;
                    if (!sizeRow.getValue().isEmpty()) {
                        productVariety.variety_values.add(sizeRow.getValue());
                    }
                }
            }
            if (productVariety.variety_values.size() > 0) {
                return productVariety;
            }
            return null;
        }

        public void setData(ShopModels.Product product) {
            ArrayList<ShopModels.ProductVariety> arrayList = product.product_variety;
            if (arrayList != null) {
                Iterator<ShopModels.ProductVariety> it = arrayList.iterator();
                while (it.hasNext()) {
                    ShopModels.ProductVariety next = it.next();
                    ArrayList<String> arrayList2 = next.variety_values;
                    if (arrayList2 != null && next.type == ShopModels.ProductVarietyTypeEnum.Size) {
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            String str = next.variety_values.get(size);
                            SizeRow sizeRow = new SizeRow(AddProductFragment.this.context, null);
                            sizeRow.editTextValue.setText(str);
                            sizeRow.onChangedListener = this.changeListener;
                            this.linearLayout.addView(sizeRow, 0);
                            this.count++;
                        }
                    }
                }
            }
            ArrayList<ShopModels.ColorObject> arrayList3 = product.colors;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return;
            }
            Iterator<ShopModels.ColorObject> it2 = product.colors.iterator();
            while (it2.hasNext()) {
                ShopModels.ColorObject next2 = it2.next();
                this.selected.add(next2.id);
                Iterator<ShopModels.ColorObject> it3 = this.colors.iterator();
                while (it3.hasNext()) {
                    ShopModels.ColorObject next3 = it3.next();
                    if (next3.id.equals(next2.id)) {
                        next3.isSelected = true;
                    }
                }
            }
            this.textViewValue.setText(AddProductFragment.this.getNameStringOfArray(product.colors));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class SizeRow extends FrameLayout {
        EditText editTextValue;
        ImageView imageViewDelete;
        OnChangeListener onChangedListener;

        public interface OnChangeListener {
            void onDeleteClick(SizeRow sizeRow);

            void onTextChanged(SizeRow sizeRow);
        }

        public SizeRow(Context context, OnChangeListener onChangeListener) {
            super(context);
            this.onChangedListener = onChangeListener;
            setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            ImageView imageView = new ImageView(context);
            this.imageViewDelete = imageView;
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.msg_delete));
            this.imageViewDelete.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#E74B50"), PorterDuff.Mode.MULTIPLY));
            this.imageViewDelete.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
            this.imageViewDelete.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$SizeRow$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            this.imageViewDelete.setVisibility(4);
            EditText editTextCreateEditTextBlack = ViewHelper.createEditTextBlack(context, 14, false);
            this.editTextValue = editTextCreateEditTextBlack;
            editTextCreateEditTextBlack.setHint(LocaleController.getString(R.string.shop_enter));
            this.editTextValue.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_grey));
            this.editTextValue.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            EditText editText = this.editTextValue;
            editText.setFilters(InputFilterHelper.getFilter(ImageReceiver.DEFAULT_CROSSFADE_DURATION, 2, editText));
            FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(context);
            frameLayoutLikeLinear.addView(this.imageViewDelete, LayoutHelper.createFrame(32, 32, 16));
            frameLayoutLikeLinear.addView(this.editTextValue);
            frameLayoutLikeLinear.setWeights(new float[]{0.2f, 0.8f});
            addView(frameLayoutLikeLinear);
            this.editTextValue.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.SizeRow.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    SizeRow sizeRow;
                    OnChangeListener onChangeListener2;
                    if (SizeRow.this.imageViewDelete.getVisibility() == 0 || SizeRow.this.getValue().isEmpty() || (onChangeListener2 = (sizeRow = SizeRow.this).onChangedListener) == null) {
                        return;
                    }
                    onChangeListener2.onTextChanged(sizeRow);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            OnChangeListener onChangeListener = this.onChangedListener;
            if (onChangeListener != null) {
                onChangeListener.onDeleteClick(this);
            }
        }

        public void showDeleteView() {
            this.imageViewDelete.setVisibility(0);
        }

        public String getValue() {
            return this.editTextValue.getText().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PriceView extends FrameLayout {
        EditText editTextPrice;
        String errorMessage;
        LinearLayout linearLayout;
        Switch switchView;

        public PriceView(Context context) {
            super(context);
            LinearLayout linearLayout = new LinearLayout(context);
            this.linearLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.linearLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            addView(this.linearLayout, LayoutHelper.createFrame(-1, -2));
            TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack.setText(LocaleController.getString(R.string.product_price_and_unit_star));
            textViewCreateTextViewBlack.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            this.linearLayout.addView(textViewCreateTextViewBlack, LayoutHelper.createFrame(-1, -2, 5));
            EditText editTextCreateEditTextBlack = ViewHelper.createEditTextBlack(context, 14, false);
            this.editTextPrice = editTextCreateEditTextBlack;
            editTextCreateEditTextBlack.setHint(LocaleController.getString(R.string.shop_enter));
            this.editTextPrice.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_border_grey));
            this.editTextPrice.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            ViewHelper.addEditTextCostFormat(this.editTextPrice);
            this.linearLayout.addView(this.editTextPrice, LayoutHelper.createFrame(-1, -2, 5));
            FrameLayout frameLayout = new FrameLayout(context);
            TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(context, 14, false);
            textViewCreateTextViewBlack2.setText(LocaleController.getString(R.string.product_existence));
            textViewCreateTextViewBlack2.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            frameLayout.addView(textViewCreateTextViewBlack2, LayoutHelper.createFrame(-1, -2, 5, 56.0f, 0.0f, 0.0f, 0.0f));
            Switch r2 = new Switch(context);
            this.switchView = r2;
            frameLayout.addView(r2, LayoutHelper.createFrame(42, 36, 19));
            this.switchView.setChecked(true, false);
            this.switchView.setDuplicateParentStateEnabled(false);
            this.switchView.setFocusable(true);
            this.switchView.setFocusableInTouchMode(true);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment$PriceView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            this.linearLayout.addView(frameLayout, LayoutHelper.createFrame(-1, -2, 5, 0.0f, 8.0f, 0.0f, 0.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            this.switchView.setChecked(!r3.isChecked(), true);
        }

        public boolean isValidData() {
            this.errorMessage = LocaleController.getString(R.string.shop_add_product_error);
            if (getPrice() != 0) {
                return true;
            }
            this.errorMessage = LocaleController.getString(R.string.shop_add_product_error_price);
            return false;
        }

        public long getPrice() {
            try {
                return Long.parseLong(NumberUtils.toEnglish(this.editTextPrice.getText().toString().trim().replaceAll(",", BuildConfig.FLAVOR)));
            } catch (Exception unused) {
                return 0L;
            }
        }

        public ShopModels.AddProductInput setAddProductValues(ShopModels.AddProductInput addProductInput) {
            if (getPrice() != 0) {
                addProductInput.unit_price = getPrice();
            }
            addProductInput.is_visible = this.switchView.isChecked();
            return addProductInput;
        }

        public void setData(ShopModels.Product product) {
            this.switchView.setChecked(product.is_visible, false);
            this.editTextPrice.setText(NumberUtils.setCommaFormat(product.unit_price + BuildConfig.FLAVOR));
        }
    }

    public class AddProductStepsRow extends FrameLayoutLikeLinear {
        private AddProductStepsCell[] cells;
        public View[] tabs;

        public AddProductStepsRow(AddProductFragment addProductFragment, Context context) {
            super(context);
            this.cells = new AddProductStepsCell[4];
            this.tabs = new View[4];
            int i = 3;
            while (true) {
                int i2 = 0;
                if (i >= 0) {
                    this.cells[i] = new AddProductStepsCell(context);
                    addView(this.cells[i]);
                    View[] viewArr = this.tabs;
                    viewArr[i] = this.cells[i].line;
                    View view = viewArr[i];
                    if (i != 0) {
                        i2 = 4;
                    }
                    view.setVisibility(i2);
                    i--;
                } else {
                    this.cells[0].setItem(LocaleController.getString(R.string.product_info), R.drawable.shop_timer, R.drawable.shop_timer_selected, true, false);
                    this.cells[1].setItem(LocaleController.getString(R.string.product_attributes), R.drawable.shop_task_square, R.drawable.shop_task_square_selected, true, true);
                    this.cells[2].setItem(LocaleController.getString(R.string.product_types), R.drawable.shop_copy_success, R.drawable.shop_copy_success_selected, true, true);
                    this.cells[3].setItem(LocaleController.getString(R.string.product_price_and_visibility), R.drawable.shop_card, R.drawable.shop_card_selected, false, true);
                    return;
                }
            }
        }

        public int getItemWidth() {
            return this.cells[0].getWidth();
        }
    }

    public void setStep(int i) {
        if (i < 0) {
            return;
        }
        if (i > this.pageCount - 1) {
            return;
        }
        int i2 = 0;
        while (i2 < this.pageCount) {
            this.addProductStepsRow.cells[i2].setSelected(i2 <= i);
            i2++;
        }
        int i3 = this.currentStep;
        if (i3 != i) {
            setPageWithAnimation(i, i < i3);
        }
    }

    private void setPageWithAnimation(int i, boolean z) {
        View[] viewArr = this.addProductStepsRow.tabs;
        int i2 = this.currentStep;
        final View view = viewArr[i2];
        View view2 = viewArr[i];
        View[] viewArr2 = this.pages;
        final View view3 = viewArr2[i2];
        View view4 = viewArr2[i];
        this.currentStep = i;
        updateButtons();
        int itemWidth = this.addProductStepsRow.getItemWidth();
        view2.setX(z ? -itemWidth : itemWidth);
        view2.setVisibility(0);
        int i3 = -AndroidUtilities.displaySize.x;
        view4.setX(z ? -i3 : i3);
        view4.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        this.pagesAnimation = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                view.setX(0.0f);
                view3.setVisibility(8);
                view3.setX(0.0f);
            }
        });
        AnimatorSet animatorSet2 = this.pagesAnimation;
        Animator[] animatorArr = new Animator[4];
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            itemWidth = -itemWidth;
        }
        fArr[0] = itemWidth;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorArr[1] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
        Property property2 = View.TRANSLATION_X;
        float[] fArr2 = new float[1];
        fArr2[0] = z ? i3 : -i3;
        animatorArr[2] = ObjectAnimator.ofFloat(view3, (Property<View, Float>) property2, fArr2);
        animatorArr[3] = ObjectAnimator.ofFloat(view4, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
        animatorSet2.playTogether(animatorArr);
        this.pagesAnimation.setDuration(300L);
        this.pagesAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.pagesAnimation.start();
    }

    private void updateButtons() {
        if (this.currentStep == 0) {
            this.textViewPrev.setText(LocaleController.getString(R.string.shop_cancel));
        } else {
            this.textViewPrev.setText(LocaleController.getString(R.string.shop_previous));
        }
        if (this.currentStep == this.pageCount - 1) {
            if (this.toEdit) {
                this.textViewNext.setText(LocaleController.getString(R.string.shop_submit));
                return;
            } else {
                this.textViewNext.setText(LocaleController.getString(R.string.shop_add_product));
                return;
            }
        }
        this.textViewNext.setText(LocaleController.getString(R.string.shop_next));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNameStringOfArray(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends ShopModels.ShopSelectableItem> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            sb.append(", ");
        }
        return new StringBuilder(sb.substring(0, sb.length() - 2)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> getIdArrayOfArray(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<? extends ShopModels.ShopSelectableItem> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getId());
            }
        }
        return arrayList2;
    }

    private void callGetStore() {
        if (this.isLoadingStore || this.toEdit) {
            return;
        }
        GetStoreDetailInput getStoreDetailInput = new GetStoreDetailInput();
        getStoreDetailInput.store_id = this.storeID;
        this.isLoadingStore = true;
        this.compositeDisposable.add((DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getStoreDetail(getStoreDetailInput).subscribeWith(new DisposableObserver<MessangerOutput<GetStoreDetailOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.AddProductFragment.8
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetStoreDetailOutput> messangerOutput) {
                AddProductFragment.this.isLoadingStore = false;
                GetStoreDetailOutput getStoreDetailOutput = messangerOutput.data;
                if (getStoreDetailOutput == null || getStoreDetailOutput.store == null || getStoreDetailOutput.store.store_category == null || AddProductFragment.this.infoView == null || AddProductFragment.this.infoView.selectedCategory != null || AddProductFragment.this.infoView.categories.isEmpty() || AddProductFragment.this.infoView.getSelectedCategory() != null) {
                    return;
                }
                ShopModels.ProductCategory productCategory = null;
                Iterator it = AddProductFragment.this.infoView.categories.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ShopModels.ProductCategory productCategory2 = (ShopModels.ProductCategory) it.next();
                    if (productCategory2.category_name.equals(messangerOutput.data.store.store_category.category_name)) {
                        productCategory = productCategory2;
                        break;
                    }
                }
                if (productCategory != null) {
                    AddProductFragment.this.infoView.setSelectedCategory(productCategory);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                AddProductFragment.this.isLoadingStore = false;
            }
        }));
    }
}
