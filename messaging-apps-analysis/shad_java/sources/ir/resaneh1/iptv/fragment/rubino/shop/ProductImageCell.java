package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableString;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.ShopModels;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;

/* loaded from: classes3.dex */
public class ProductImageCell extends FrameLayout {
    private Context context;
    ImageView delete;
    ImageView icon;
    int imageSizeInDp;
    private ImageView imageView;
    private LoadingCell loadingView;
    private ShopModels.ShopImage shopImage;
    int sizeInDp;

    public interface DeleteListener {
        void onDeleteClick(ShopModels.ShopImage shopImage);
    }

    public ProductImageCell(Context context, final DeleteListener deleteListener) {
        super(context);
        this.sizeInDp = 140;
        this.imageSizeInDp = 120;
        this.context = context;
        FrameLayout frameLayout = new FrameLayout(context);
        int i = this.sizeInDp;
        addView(frameLayout, LayoutHelper.createFrame(i, i, 17, 4.0f, 4.0f, 4.0f, 4.0f));
        frameLayout.setBackground(context.getResources().getDrawable(R.drawable.shop_rectangle_grey));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        int i2 = this.imageSizeInDp;
        frameLayout.addView(imageView, LayoutHelper.createFrame(i2, i2, 17));
        ImageView imageView2 = new ImageView(context);
        this.icon = imageView2;
        imageView2.setImageResource(R.drawable.shop_camera);
        frameLayout.addView(this.icon, LayoutHelper.createFrame(16, 16, 17));
        LoadingCell loadingCell = new LoadingCell(context);
        this.loadingView = loadingCell;
        loadingCell.setProgressColor(-1);
        frameLayout.addView(this.loadingView, LayoutHelper.createFrame(-2, -2, 17));
        this.loadingView.setVisibility(8);
        ImageView imageView3 = new ImageView(context);
        this.delete = imageView3;
        imageView3.setImageResource(R.drawable.ic_close_circle);
        this.delete.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#E74B50"), PorterDuff.Mode.SRC_ATOP));
        this.delete.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        frameLayout.addView(this.delete, LayoutHelper.createFrame(32, 32, 51));
        this.delete.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductImageCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(deleteListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final DeleteListener deleteListener, View view) {
        if (deleteListener != null) {
            SpannableString spannableStringMakeWithColorAndRelativeSize = SpanHelper.makeWithColorAndRelativeSize(LocaleController.getString(R.string.shop_delete_product_alert), Theme.getColor(Theme.key_rubinoBlackColor), 1.5f);
            RubinoController.getInstance(UserConfig.selectedAccount);
            RubinoController.showRubinoCenterDialog(true, spannableStringMakeWithColorAndRelativeSize, LocaleController.getString(R.string.shop_delete), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductImageCell$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0(deleteListener, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DeleteListener deleteListener, View view) {
        deleteListener.onDeleteClick(this.shopImage);
    }

    public void setImage(ShopModels.ShopImage shopImage) {
        this.shopImage = shopImage;
        this.loadingView.setVisibility(8);
        this.icon.setVisibility(0);
        this.icon.setImageResource(R.drawable.shop_camera);
        this.imageView.setVisibility(4);
        if (shopImage.outputFile != null) {
            this.imageView.setVisibility(0);
            ShopModels.InputFile inputFile = shopImage.outputFile;
            ShopModels.EmbeddedInputFile embeddedInputFile = inputFile.thumbnail_file;
            if (embeddedInputFile != null) {
                GlideHelper.load(this.context, this.imageView, embeddedInputFile.file_url, R.drawable.shop_rectangle_grey);
                return;
            } else {
                GlideHelper.load(this.context, this.imageView, inputFile.main_file.file_url, R.drawable.shop_rectangle_grey);
                return;
            }
        }
        ShopModels.UploadingStateEnum uploadingStateEnum = shopImage.state;
        if (uploadingStateEnum == ShopModels.UploadingStateEnum.uploading) {
            this.loadingView.setVisibility(0);
            this.icon.setVisibility(4);
        } else if (uploadingStateEnum == ShopModels.UploadingStateEnum.error) {
            this.icon.setVisibility(0);
            this.icon.setImageResource(R.drawable.ic_fingerprint_error);
        }
        TLRPC$PhotoSize tLRPC$PhotoSize = shopImage.smallPhoto;
        if (tLRPC$PhotoSize != null) {
            String str = tLRPC$PhotoSize.filePath;
            this.imageView.setVisibility(0);
            try {
                this.imageView.setImageBitmap(ImageLoader.loadBitmap(str, null, 1000.0f, 1000.0f, true));
                return;
            } catch (Exception unused) {
                this.imageView.setVisibility(4);
                return;
            }
        }
        this.imageView.setVisibility(4);
    }
}
