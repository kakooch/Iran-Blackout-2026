package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.Cells.LoadingCell;

/* loaded from: classes3.dex */
public class ProductsAdapter extends RecyclerListView.SelectionAdapter {
    public Context context;
    public ProductListener listener;
    public List<ShopModels.ProductSummaryObject> productsList = new ArrayList();
    private boolean loading = false;

    public interface ProductListener {
        void onEditInventoryClick(ShopModels.ProductSummaryObject productSummaryObject);

        void onEditPriceClick(ShopModels.ProductSummaryObject productSummaryObject);

        void onProductClick(ShopModels.ProductSummaryObject productSummaryObject);
    }

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    public ProductsAdapter(Context context, ProductListener productListener) {
        this.context = context;
        this.listener = productListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (this.loading && i == this.productsList.size()) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new RecyclerListView.Holder(new LoadingCell(this.context));
        }
        if (i == 1) {
            return new ProductViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_shop_product, viewGroup, false));
        }
        return new ProductViewHolder(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ShopModels.EmbeddedInputFile embeddedInputFile;
        if (viewHolder.getItemViewType() != 0 && (viewHolder instanceof ProductViewHolder)) {
            ShopModels.ProductSummaryObject productSummaryObject = this.productsList.get(i);
            ProductViewHolder productViewHolder = (ProductViewHolder) viewHolder;
            productViewHolder.productSummaryObject = productSummaryObject;
            productViewHolder.productNameTv.setText(this.productsList.get(i).product_name);
            productViewHolder.editPriceLl.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(i, view);
                }
            });
            productViewHolder.editInventoryLl.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$1(i, view);
                }
            });
            productViewHolder.container.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductsAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$2(i, view);
                }
            });
            ShopModels.InputFile inputFile = productSummaryObject.media;
            if (inputFile == null || (embeddedInputFile = inputFile.main_file) == null) {
                return;
            }
            GlideHelper.loadRoundedCorner(this.context, productViewHolder.productIv, embeddedInputFile.file_url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
        this.listener.onEditPriceClick(this.productsList.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(int i, View view) {
        this.listener.onEditInventoryClick(this.productsList.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2(int i, View view) {
        this.listener.onProductClick(this.productsList.get(i));
    }

    public void setLoading(boolean z) {
        this.loading = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.productsList.size();
        return this.loading ? size + 1 : size;
    }

    public void setList(ArrayList<ShopModels.ProductSummaryObject> arrayList, boolean z) {
        if (arrayList == null) {
            return;
        }
        if (z) {
            this.productsList.clear();
        }
        this.productsList.addAll(arrayList);
    }

    public static class ProductViewHolder extends RecyclerListView.Holder {
        protected FrameLayout container;
        protected LinearLayout editInventoryLl;
        protected LinearLayout editPriceLl;
        protected ImageView productIv;
        protected TextView productNameTv;
        protected ShopModels.ProductSummaryObject productSummaryObject;

        public ProductViewHolder(View view) {
            super(view);
            this.container = (FrameLayout) view.findViewById(R.id.container);
            this.productIv = (ImageView) view.findViewById(R.id.product_image_image_view);
            this.productNameTv = (TextView) view.findViewById(R.id.product_name_text_view);
            this.editPriceLl = (LinearLayout) view.findViewById(R.id.shop_item_product_edit_price_ll);
            this.editInventoryLl = (LinearLayout) view.findViewById(R.id.shop_item_product_edit_inventory_ll);
            ((TextView) view.findViewById(R.id.shop_item_product_edit_inventory_text_view)).setText(LocaleController.getString(R.string.edit_product_view));
            ((TextView) view.findViewById(R.id.shop_item_product_edit_price_text_view)).setText(LocaleController.getString(R.string.edit_price));
        }
    }
}
