package ir.appp.wallet.cell;

import android.content.Context;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.rghapp.components.FrameLayoutLikeLinear;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;

/* compiled from: WalletHeaderActionListCell.kt */
/* loaded from: classes3.dex */
public final class WalletHeaderActionListCell extends FrameLayoutLikeLinear {
    private final Lazy cashOutAction$delegate;
    private final Lazy chargeByTokenAction$delegate;
    private final Context mContext;
    private final Lazy shareAction$delegate;
    private final Lazy transferAction$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletHeaderActionListCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.transferAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.WalletHeaderActionListCell$transferAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        this.cashOutAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.WalletHeaderActionListCell$cashOutAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        this.chargeByTokenAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.WalletHeaderActionListCell$chargeByTokenAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        this.shareAction$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletHeaderActionCell>() { // from class: ir.appp.wallet.cell.WalletHeaderActionListCell$shareAction$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletHeaderActionCell invoke() {
                return new WalletHeaderActionCell(this.this$0.getMContext());
            }
        });
        setBackgroundResource(R.drawable.wallet_bg_test_2);
        addView(getTransferAction(), LayoutHelper.createFrame(-2, -2));
        addView(getCashOutAction(), LayoutHelper.createFrame(-2, -2));
        addView(getChargeByTokenAction(), LayoutHelper.createFrame(-2, -2));
        addView(getShareAction(), LayoutHelper.createFrame(-2, -2));
        setPadding(0, 16, 0, 16);
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

    public final WalletHeaderActionCell getChargeByTokenAction() {
        return (WalletHeaderActionCell) this.chargeByTokenAction$delegate.getValue();
    }

    public final WalletHeaderActionCell getShareAction() {
        return (WalletHeaderActionCell) this.shareAction$delegate.getValue();
    }

    public final void setData() {
        WalletHeaderActionCell transferAction = getTransferAction();
        String string = LocaleController.getString(R.string.wallet_transfer);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wallet_transfer)");
        transferAction.setData(string, R.drawable.wallet_transfer_ic);
        WalletHeaderActionCell cashOutAction = getCashOutAction();
        String string2 = LocaleController.getString(R.string.wallet_cash_out);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.wallet_cash_out)");
        cashOutAction.setData(string2, R.drawable.wallet_withdraw_ic);
        WalletHeaderActionCell chargeByTokenAction = getChargeByTokenAction();
        String string3 = LocaleController.getString(R.string.wallet_charge);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.wallet_charge)");
        chargeByTokenAction.setData(string3, R.drawable.wallet_credit_ic);
        WalletHeaderActionCell shareAction = getShareAction();
        String string4 = LocaleController.getString(R.string.wallet_link);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.wallet_link)");
        shareAction.setData(string4, R.drawable.wallet_action_share_ic);
    }
}
