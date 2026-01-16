package ir.appp.wallet.cell.bottomSheet;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletCashOutBottomSheet.kt */
/* loaded from: classes3.dex */
public final class WalletCashOutBottomSheet extends WalletBottomSheet {
    private final Lazy confirmButtonTextView$delegate;
    private final String currencyTitle;
    private final Lazy inputEditText$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletCashOutBottomSheet(Context context, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.currencyTitle = str;
        this.inputEditText$delegate = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletCashOutBottomSheet$inputEditText$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                EditText editTextCreateEditText = ViewCreator.Companion.createEditText(this.this$0.getMContext(), true, BuildConfig.FLAVOR);
                editTextCreateEditText.setFilters(InputFilterHelper.getFilterMaxLine(1, editTextCreateEditText));
                return editTextCreateEditText;
            }
        });
        this.confirmButtonTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletCashOutBottomSheet$confirmButtonTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setText(LocaleController.getString(R.string.wallet_confirm));
                textViewCreateTextView.setBackgroundResource(R.drawable.bg_wallet_test);
                textViewCreateTextView.setTextColor(-1);
                textViewCreateTextView.setGravity(17);
                textViewCreateTextView.setPadding(0, 16, 0, 16);
                return textViewCreateTextView;
            }
        });
        String string = LocaleController.getString(R.string.wallet_withdraw);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wallet_withdraw)");
        addView(initTitleTextView(string), LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 16));
        addView(initTopImage(R.drawable.wallet_withdraw_bs_ic), LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 16));
        TextView textViewCreateTextView = ViewCreator.Companion.createTextView(getMContext());
        String string2 = LocaleController.getString(R.string.wallet_enter_amount);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wallet_enter_amount)");
        if (str != null) {
            string2 = ((Object) string2) + " (" + str + ")";
        }
        textViewCreateTextView.setText(string2);
        addView(textViewCreateTextView, LayoutHelper.createLinear(-2, -2, 8.0f, 32.0f, 8.0f, 8.0f));
        addView(initInputLayout(getInputEditText()), LayoutHelper.createLinear(-1, 50, 8.0f, 8.0f, 8.0f, 8.0f));
        addView(getConfirmButtonTextView(), LayoutHelper.createLinear(-1, 50, 8.0f, 16.0f, 8.0f, 8.0f));
    }

    public final EditText getInputEditText() {
        return (EditText) this.inputEditText$delegate.getValue();
    }

    public final TextView getConfirmButtonTextView() {
        return (TextView) this.confirmButtonTextView$delegate.getValue();
    }
}
