package ir.appp.wallet.cell.bottomSheet;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletCreditBottomSheet.kt */
/* loaded from: classes3.dex */
public final class WalletCreditBottomSheet extends WalletBottomSheet {
    private final Lazy confirmButtonTextView$delegate;
    private final String currencyTitle;
    private final Lazy inputEditText$delegate;
    private final int type;

    static {
        new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletCreditBottomSheet(Context context, int i, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.type = i;
        this.currencyTitle = str;
        this.inputEditText$delegate = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletCreditBottomSheet$inputEditText$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                EditText editTextCreateEditText = ViewCreator.Companion.createEditText(this.this$0.getMContext(), this.this$0.type == 0, this.this$0.currencyTitle);
                editTextCreateEditText.setInputType(this.this$0.type == 0 ? 3 : 1);
                editTextCreateEditText.setFilters(InputFilterHelper.getFilterMaxLine(1, editTextCreateEditText));
                return editTextCreateEditText;
            }
        });
        this.confirmButtonTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletCreditBottomSheet$confirmButtonTextView$2
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
        addView(initTitleTextView(getTitleText()), LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 16));
        addView(initTopImage(getTopImage()), LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 16));
        TextView textViewCreateTextView = ViewCreator.Companion.createTextView(getMContext());
        textViewCreateTextView.setText(LocaleController.getString(i == 1 ? R.string.wallet_enter_credit_code : R.string.wallet_enter_amount));
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

    private final String getTitleText() {
        if (this.type == 1) {
            String string = LocaleController.getString(R.string.wallet_gift_credit);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wallet_gift_credit)");
            return string;
        }
        String str = this.currencyTitle;
        if (str != null) {
            getInputEditText().setHint(str);
        }
        String string2 = LocaleController.getString(R.string.wallet_payment);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wallet_payment)");
        return string2;
    }

    private final int getTopImage() {
        return this.type == 1 ? R.drawable.wallet_credit_bottom_sheet_ic : R.drawable.wallet_payment_ic;
    }

    /* compiled from: WalletCreditBottomSheet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
