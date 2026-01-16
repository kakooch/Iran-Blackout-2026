package ir.appp.wallet.cell.currency;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletEmptyCurrencyTransactionCell.kt */
/* loaded from: classes3.dex */
public final class WalletEmptyCurrencyTransactionCell extends LinearLayout {
    private final Lazy emptyImageView$delegate;
    private final Lazy emptyTextView$delegate;
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletEmptyCurrencyTransactionCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.emptyTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.currency.WalletEmptyCurrencyTransactionCell$emptyTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return ViewCreator.Companion.createTextView(this.this$0.getMContext());
            }
        });
        this.emptyImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.currency.WalletEmptyCurrencyTransactionCell$emptyImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.getMContext());
            }
        });
        setOrientation(1);
        addView(getEmptyImageView(), LayoutHelper.createLinear(ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION, 17, 0, 32, 0, 16));
        addView(getEmptyTextView(), LayoutHelper.createLinear(-2, -2, 17, 16, 16, 16, 16));
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final TextView getEmptyTextView() {
        return (TextView) this.emptyTextView$delegate.getValue();
    }

    private final ImageView getEmptyImageView() {
        return (ImageView) this.emptyImageView$delegate.getValue();
    }

    public final void setData() {
        getEmptyTextView().setText(LocaleController.getString(R.string.wallet_no_transaction));
        GlideHelper.load(this.mContext, getEmptyImageView(), BuildConfig.FLAVOR, R.drawable.wallet_empty_transactions_ic);
    }
}
