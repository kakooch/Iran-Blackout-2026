package ir.appp.wallet.cell.currency;

import android.content.Context;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.wallet.WalletItemObject;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: WalletCurrencyHeaderCell.kt */
/* loaded from: classes3.dex */
public final class WalletCurrencyHeaderCell extends LinearLayout {
    private final Lazy logoImageView$delegate;
    private final Context mContext;
    private final Lazy totalBalanceTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletCurrencyHeaderCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.totalBalanceTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyHeaderCell$totalBalanceTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextSize(24.0f);
                textViewCreateTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                return textViewCreateTextView;
            }
        });
        this.logoImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyHeaderCell$logoImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.getMContext());
            }
        });
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        setOrientation(1);
        setGravity(17);
        setPadding(0, 16, 0, 0);
        addView(getLogoImageView(), LayoutHelper.createFrame(100, 100, 17, 0.0f, 32.0f, 0.0f, 8.0f));
        addView(getTotalBalanceTextView(), LayoutHelper.createFrame(-2, -2, 17, 0.0f, 8.0f, 0.0f, 8.0f));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final TextView getTotalBalanceTextView() {
        return (TextView) this.totalBalanceTextView$delegate.getValue();
    }

    private final ImageView getLogoImageView() {
        return (ImageView) this.logoImageView$delegate.getValue();
    }

    public final void setData(WalletItemObject walletItemObject) {
        Intrinsics.checkNotNullParameter(walletItemObject, "walletItemObject");
        if (walletItemObject.currencyObject == null) {
            return;
        }
        GlideHelper.loadCircle(this.mContext, getLogoImageView(), walletItemObject.currencyObject.img_url, R.drawable.circle_grey);
        getTotalBalanceTextView().setText(NumberUtils.getPriceString(walletItemObject.amount) + " " + walletItemObject.amount_currency_title);
        getTotalBalanceTextView().setText(SpanHelper.makeBoldAndRelativeSize(SpannableString.valueOf(getTotalBalanceTextView().getText()), 0, NumberUtils.getPriceString(walletItemObject.amount.toString()).length(), 1.5f));
    }
}
