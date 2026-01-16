package ir.appp.wallet.cell.currency;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.rghapp.components.FrameLayoutLikeLinear;
import ir.appp.wallet.cell.WalletHeaderActionCell;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: WalletCurrencyActionListCell.kt */
/* loaded from: classes3.dex */
public final class WalletCurrencyActionListCell extends LinearLayout {
    private final Lazy buyAction$delegate;
    private final Lazy cashOutAction$delegate;
    private final Context mContext;
    private final Lazy transferAction$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletCurrencyActionListCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.transferAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyActionListCell$transferAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        this.cashOutAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyActionListCell$cashOutAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        this.buyAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyActionListCell$buyAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        setOrientation(1);
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        addView(initHorizontalLl(), LayoutHelper.createLinear(-1, -2));
        addView(initLineView(), LayoutHelper.createLinear(-2, 1, 0.0f, 0.0f, 0.0f, 0.0f));
        setPadding(0, 16, 0, 0);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final WalletHeaderActionCell getTransferAction() {
        return (WalletHeaderActionCell) this.transferAction$delegate.getValue();
    }

    public final WalletHeaderActionCell getCashOutAction() {
        return (WalletHeaderActionCell) this.cashOutAction$delegate.getValue();
    }

    public final WalletHeaderActionCell getBuyAction() {
        return (WalletHeaderActionCell) this.buyAction$delegate.getValue();
    }

    private final View initLineView() {
        View view = new View(getContext());
        view.setBackgroundColor(Theme.getColor(Theme.key_dialogBackgroundGray));
        return view;
    }

    private final FrameLayoutLikeLinear initHorizontalLl() {
        FrameLayoutLikeLinear frameLayoutLikeLinear = new FrameLayoutLikeLinear(getContext());
        frameLayoutLikeLinear.addView(getTransferAction(), LayoutHelper.createFrame(-2, -2));
        frameLayoutLikeLinear.addView(getCashOutAction(), LayoutHelper.createFrame(-2, -2));
        frameLayoutLikeLinear.addView(getBuyAction(), LayoutHelper.createFrame(-2, -2));
        return frameLayoutLikeLinear;
    }

    public final void setData() {
        WalletHeaderActionCell transferAction = getTransferAction();
        String string = LocaleController.getString(R.string.wallet_transfer);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wallet_transfer)");
        transferAction.setData(string, R.drawable.wallet_currency_transfer_ic);
        WalletHeaderActionCell cashOutAction = getCashOutAction();
        String string2 = LocaleController.getString(R.string.wallet_cash_out);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wallet_cash_out)");
        cashOutAction.setData(string2, R.drawable.wallet_currency_withdraw_ic);
        WalletHeaderActionCell buyAction = getBuyAction();
        String string3 = LocaleController.getString(R.string.wallet_buy);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.wallet_buy)");
        buyAction.setData(string3, R.drawable.wallet_currency_buy_ic);
        TextView nameTextView = getTransferAction().getNameTextView();
        int i = Theme.key_dialogTextBlack;
        nameTextView.setTextColor(Theme.getColor(i));
        getCashOutAction().getNameTextView().setTextColor(Theme.getColor(i));
        getBuyAction().getNameTextView().setTextColor(Theme.getColor(i));
    }
}
