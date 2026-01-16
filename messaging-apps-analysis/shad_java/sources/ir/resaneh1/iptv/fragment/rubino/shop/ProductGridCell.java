package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.ShopModels;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class ProductGridCell extends FrameLayout {
    private ProductCellDelegate delegate;
    private boolean ignoreLayout;
    private int[] indicies;
    private boolean isFirst;
    private int itemsCount;
    private ShopModels.ProductSummaryObject[] products;
    private ProductView[] views;

    public interface ProductCellDelegate {
        void didClickItem(ShopModels.ProductSummaryObject productSummaryObject, int i, int i2);
    }

    public ProductGridCell(Context context) {
        super(context);
        this.products = new ShopModels.ProductSummaryObject[2];
        this.views = new ProductView[6];
        this.indicies = new int[6];
        for (final int i = 0; i < 6; i++) {
            this.views[i] = new ProductView(context);
            this.views[i].setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductGridCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(i, view);
                }
            });
            this.views[i].setTag(Integer.valueOf(i));
            this.views[i].setVisibility(4);
            addView(this.views[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i, View view) {
        ProductCellDelegate productCellDelegate = this.delegate;
        if (productCellDelegate != null) {
            productCellDelegate.didClickItem(this.products[i], this.indicies[i], i);
        }
    }

    public void setItemsCount(int i) {
        int i2 = 0;
        while (true) {
            ProductView[] productViewArr = this.views;
            if (i2 < productViewArr.length) {
                productViewArr[i2].clearAnimation();
                this.views[i2].setVisibility(i2 < i ? 0 : 4);
                i2++;
            } else {
                this.itemsCount = i;
                return;
            }
        }
    }

    public void setIsFirst(boolean z) {
        this.isFirst = z;
    }

    public void setItem(int i, int i2, ShopModels.ProductSummaryObject productSummaryObject) {
        this.products[i] = productSummaryObject;
        this.indicies[i] = i2;
        if (productSummaryObject != null) {
            this.views[i].setVisibility(0);
            this.views[i].setData(productSummaryObject);
        } else {
            this.views[i].setVisibility(4);
            this.views[i].clearAnimation();
            this.products[i] = null;
        }
    }

    public void setDelegate(ProductCellDelegate productCellDelegate) {
        this.delegate = productCellDelegate;
    }

    private static class ProductView extends LinearLayout {
        private final ImageView imageView;
        private final TextView priceTextView;
        private final TextView titleTextView;

        public ProductView(Context context) {
            super(context);
            setOrientation(1);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView, LayoutHelper.createLinear(-1, 0, 1.0f, 48));
            TextView textViewCreateShopTextView = ViewHelper.createShopTextView(context, 14, Theme.getColor(Theme.key_chats_message), false);
            this.titleTextView = textViewCreateShopTextView;
            textViewCreateShopTextView.setSingleLine();
            textViewCreateShopTextView.setGravity(5);
            addView(textViewCreateShopTextView, LayoutHelper.createLinear(-1, -2, 5, 0, 2, 0, 0));
            TextView textViewCreateShopTextView2 = ViewHelper.createShopTextView(context, 14, Theme.getColor(Theme.key_chats_name), false);
            this.priceTextView = textViewCreateShopTextView2;
            textViewCreateShopTextView2.setSingleLine();
            textViewCreateShopTextView2.setGravity(5);
            addView(textViewCreateShopTextView2, LayoutHelper.createLinear(-1, -2));
        }

        public void setData(ShopModels.ProductSummaryObject productSummaryObject) {
            if (productSummaryObject == null) {
                return;
            }
            ShopModels.InputFile inputFile = productSummaryObject.media;
            if (inputFile != null && inputFile.main_file != null) {
                GlideHelper.loadRoundedCorner(getContext(), this.imageView, productSummaryObject.media.main_file.file_url);
            }
            this.titleTextView.setText(productSummaryObject.product_name);
            this.priceTextView.setText(NumberUtils.getPriceStringWithToman(productSummaryObject.unit_price, false));
        }
    }

    @Override // android.view.View
    public void invalidate() {
        for (int i = 0; i < 6; i++) {
            this.views[i].invalidate();
        }
        super.invalidate();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int itemSize = getItemSize(this.itemsCount, size);
        this.ignoreLayout = true;
        for (int i3 = 0; i3 < this.itemsCount; i3++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.views[i3].getLayoutParams();
            layoutParams.topMargin = this.isFirst ? 0 : AndroidUtilities.dp(2.0f);
            layoutParams.leftMargin = (AndroidUtilities.dp(2.0f) + itemSize) * i3;
            int i4 = this.itemsCount;
            if (i3 == i4 - 1) {
                layoutParams.width = size - ((i4 - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
            } else {
                layoutParams.width = itemSize;
            }
            layoutParams.height = itemSize;
            layoutParams.gravity = 51;
            this.views[i3].setLayoutParams(layoutParams);
        }
        this.ignoreLayout = false;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((this.isFirst ? 0 : AndroidUtilities.dp(2.0f)) + itemSize, 1073741824));
    }

    private static int getItemSize(int i, int i2) {
        return (i2 - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
    }
}
