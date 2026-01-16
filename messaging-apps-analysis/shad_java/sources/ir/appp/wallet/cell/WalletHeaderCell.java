package ir.appp.wallet.cell;

import android.content.Context;
import android.text.SpannableString;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.wallet.WalletObject;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletHeaderCell.kt */
/* loaded from: classes3.dex */
public final class WalletHeaderCell extends LinearLayout {
    private final Context mContext;
    private final Lazy totalBalanceTextView$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHeaderCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.totalBalanceTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.WalletHeaderCell$totalBalanceTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextSize(28.0f);
                textViewCreateTextView.setTextColor(-1);
                return textViewCreateTextView;
            }
        });
        setOrientation(1);
        setGravity(17);
        setBackgroundResource(R.drawable.wallet_bg_test_1);
        getTotalBalanceTextView().setText("  ");
        addView(getTotalBalanceTextView(), LayoutHelper.createLinear(-2, 75, 17, 0, 32, 0, 8));
        TextView textViewCreateTextView = ViewCreator.Companion.createTextView(mContext);
        textViewCreateTextView.setText(LocaleController.getString(R.string.wallet_rubika));
        textViewCreateTextView.setTextColor(-1);
        addView(textViewCreateTextView, LayoutHelper.createLinear(-2, -2, 0.0f, 8.0f, 0.0f, 32.0f));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final TextView getTotalBalanceTextView() {
        return (TextView) this.totalBalanceTextView$delegate.getValue();
    }

    public final void setData(WalletObject walletObject) {
        Unit unit;
        if (walletObject == null) {
            unit = null;
        } else {
            getTotalBalanceTextView().setText(NumberUtils.getPriceString(String.valueOf(walletObject.wallet_amount)) + " " + walletObject.currency_title);
            getTotalBalanceTextView().setText(SpanHelper.makeBoldAndRelativeSize(SpannableString.valueOf(getTotalBalanceTextView().getText()), 0, NumberUtils.getPriceString(String.valueOf(walletObject.wallet_amount)).length(), 1.5f));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getTotalBalanceTextView().setText(BuildConfig.FLAVOR);
        }
    }
}
