package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.ShopModels;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class ProductCell extends FrameLayout {
    private CheckBox2 checkBox;
    private ProductDelegate delegate;
    int imageSizeInDp;
    ImageView imageView;
    private ShopModels.ProductSummaryObject productSummary;
    TextView textView1;
    TextView textView2;
    TextView textViewShowMore;

    public interface ProductDelegate {
        void onViewProductClick(ShopModels.ProductSummaryObject productSummaryObject);
    }

    public ProductCell(Context context) {
        this(context, false);
    }

    public ProductCell(Context context, boolean z) {
        super(context);
        this.imageSizeInDp = 56;
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        int i = this.imageSizeInDp;
        addView(imageView, LayoutHelper.createFrame(i, i, 21, 0.0f, 8.0f, 16.0f, 8.0f));
        if (z) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox, LayoutHelper.createFrame(24, 24, 21, 0.0f, (((this.imageSizeInDp - 24) - 4) / 2.0f) + 8.0f, 18.0f, 8.0f));
        }
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 14, true);
        this.textView1 = textViewCreateTextViewBlack;
        textViewCreateTextViewBlack.setText(BuildConfig.FLAVOR);
        this.textView1.setMaxLines(1);
        this.textView1.setEllipsize(TextUtils.TruncateAt.END);
        this.textView1.setGravity(5);
        addView(this.textView1, LayoutHelper.createFrame(-2, -2, 53, 60.0f, 8.0f, this.imageSizeInDp + 16 + 16, 4.0f));
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 14, Color.parseColor("#0295F7"), false);
        this.textViewShowMore = textViewCreateTextView;
        textViewCreateTextView.setText(LocaleController.getString(R.string.shop_show));
        this.textViewShowMore.setPadding(0, 0, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.textViewShowMore.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        addView(this.textViewShowMore, LayoutHelper.createFrame(-2, -2, 51, 16.0f, 8.0f, 4.0f, 4.0f));
        TextView textViewCreateTextViewBlack2 = ViewHelper.createTextViewBlack(context, 14, false);
        this.textView2 = textViewCreateTextViewBlack2;
        textViewCreateTextViewBlack2.setText(BuildConfig.FLAVOR);
        this.textView2.setMaxLines(2);
        this.textView2.setEllipsize(TextUtils.TruncateAt.END);
        this.textView2.setGravity(5);
        addView(this.textView2, LayoutHelper.createFrame(-2, -2, 53, 8.0f, 32.0f, this.imageSizeInDp + 16 + 16, 4.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        ShopModels.ProductSummaryObject productSummaryObject;
        ProductDelegate productDelegate = this.delegate;
        if (productDelegate == null || (productSummaryObject = this.productSummary) == null) {
            return;
        }
        productDelegate.onViewProductClick(productSummaryObject);
    }

    public void setDelegate(ProductDelegate productDelegate) {
        this.delegate = productDelegate;
    }

    public void setItem(ShopModels.ProductSummaryObject productSummaryObject) {
        setItem(productSummaryObject, false);
    }

    public void setItem(ShopModels.ProductSummaryObject productSummaryObject, boolean z) {
        ShopModels.EmbeddedInputFile embeddedInputFile;
        if (z) {
            this.textViewShowMore.setText(LocaleController.getString(R.string.shop_select2));
        } else {
            this.textViewShowMore.setText(LocaleController.getString(R.string.shop_show));
        }
        this.imageView.setImageResource(R.drawable.shop_rectangle_border_grey);
        this.textView1.setText(BuildConfig.FLAVOR);
        this.textView2.setText(BuildConfig.FLAVOR);
        if (productSummaryObject == null) {
            return;
        }
        this.productSummary = productSummaryObject;
        ShopModels.InputFile inputFile = productSummaryObject.media;
        if (inputFile != null && (embeddedInputFile = inputFile.main_file) != null && !embeddedInputFile.file_url.isEmpty()) {
            GlideHelper.loadRoundedCorner(getContext(), this.imageView, productSummaryObject.media.main_file.file_url, R.drawable.shop_rectangle_border_grey);
        }
        String str = productSummaryObject.product_name;
        if (str != null) {
            this.textView1.setText(str);
        }
        this.textView2.setText(NumberUtils.getPriceStringWithToman(productSummaryObject.unit_price, false));
    }

    public void setChecked(boolean z) {
        this.checkBox.setChecked(z, true);
        this.textViewShowMore.setVisibility(z ? 8 : 0);
    }

    public ShopModels.ProductSummaryObject getItem() {
        return this.productSummary;
    }
}
