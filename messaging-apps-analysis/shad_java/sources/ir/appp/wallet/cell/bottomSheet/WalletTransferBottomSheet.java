package ir.appp.wallet.cell.bottomSheet;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.cell.WalletChatAbsCell;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletTransferBottomSheet.kt */
/* loaded from: classes3.dex */
public final class WalletTransferBottomSheet extends WalletBottomSheet {
    private final ChatAbsObject absObject;
    private final Lazy confirmButtonTextView$delegate;
    private final String currencyTitle;
    private final Lazy descriptionInputEditText$delegate;
    private final Lazy transferAmountInputEditText$delegate;

    public final ChatAbsObject getAbsObject() {
        return this.absObject;
    }

    public final String getCurrencyTitle() {
        return this.currencyTitle;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletTransferBottomSheet(final Context context, ChatAbsObject absObject, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(absObject, "absObject");
        new LinkedHashMap();
        this.absObject = absObject;
        this.currencyTitle = str;
        this.transferAmountInputEditText$delegate = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletTransferBottomSheet$transferAmountInputEditText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return ViewCreator.Companion.createEditText(context, true, BuildConfig.FLAVOR);
            }
        });
        this.descriptionInputEditText$delegate = LazyKt__LazyJVMKt.lazy(new Function0<EditText>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletTransferBottomSheet$descriptionInputEditText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EditText invoke() {
                return ViewCreator.Companion.createEditText(context, false, null);
            }
        });
        this.confirmButtonTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.bottomSheet.WalletTransferBottomSheet$confirmButtonTextView$2
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
                textViewCreateTextView.setFilters(InputFilterHelper.getFilter(200, 1, textViewCreateTextView));
                return textViewCreateTextView;
            }
        });
        addView(initUserView(), LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        addView(initTransferAmountView(), LayoutHelper.createLinear(-1, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        addView(initDescriptionView(), LayoutHelper.createLinear(-1, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        addView(getConfirmButtonTextView(), LayoutHelper.createLinear(-1, 50, 8.0f, 16.0f, 8.0f, 8.0f));
    }

    public final EditText getTransferAmountInputEditText() {
        return (EditText) this.transferAmountInputEditText$delegate.getValue();
    }

    public final EditText getDescriptionInputEditText() {
        return (EditText) this.descriptionInputEditText$delegate.getValue();
    }

    public final TextView getConfirmButtonTextView() {
        return (TextView) this.confirmButtonTextView$delegate.getValue();
    }

    private final LinearLayout initDescriptionView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(5);
        TextView textViewCreateTextView = ViewCreator.Companion.createTextView(getMContext());
        textViewCreateTextView.setText(LocaleController.getString(R.string.wallet_description_optional));
        linearLayout.addView(textViewCreateTextView, LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        linearLayout.addView(initInputLayout(getDescriptionInputEditText()), LayoutHelper.createLinear(-1, -2, 0.0f, 8.0f, 0.0f, 8.0f));
        return linearLayout;
    }

    private final LinearLayout initTransferAmountView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(5);
        TextView textViewCreateTextView = ViewCreator.Companion.createTextView(getMContext());
        textViewCreateTextView.setText(LocaleController.getString(R.string.wallet_price));
        if (getCurrencyTitle() != null) {
            textViewCreateTextView.append(" (" + getCurrencyTitle() + ")");
        }
        linearLayout.addView(textViewCreateTextView, LayoutHelper.createLinear(-2, -2, 8.0f, 8.0f, 8.0f, 8.0f));
        linearLayout.addView(initInputLayout(getTransferAmountInputEditText()), LayoutHelper.createLinear(-1, -2, 0.0f, 8.0f, 0.0f, 8.0f));
        return linearLayout;
    }

    private final View initUserView() {
        WalletChatAbsCell walletChatAbsCell = new WalletChatAbsCell(getContext());
        walletChatAbsCell.setData(this.absObject);
        return walletChatAbsCell;
    }
}
