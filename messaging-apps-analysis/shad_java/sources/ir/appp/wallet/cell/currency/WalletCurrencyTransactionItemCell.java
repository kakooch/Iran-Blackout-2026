package ir.appp.wallet.cell.currency;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.WalletController;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.wallet.CreditDetailObject;
import ir.resaneh1.iptv.model.wallet.WalletTransactionObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: WalletCurrencyTransactionItemCell.kt */
/* loaded from: classes3.dex */
public final class WalletCurrencyTransactionItemCell extends LinearLayout {
    private final Lazy amountTextView$delegate;
    private final BaseFragment baseFragment;
    private final Lazy descriptionTextView$delegate;
    private final Lazy imageView$delegate;
    private final Context mContext;
    private final Lazy optionImageView$delegate;
    private final Lazy shareImageView$delegate;
    private final Lazy transactionTimeTextView$delegate;
    private WalletTransactionObject walletTransactionObject;

    public final BaseFragment getBaseFragment() {
        return this.baseFragment;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletCurrencyTransactionItemCell(Context mContext, BaseFragment baseFragment) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(baseFragment, "baseFragment");
        new LinkedHashMap();
        this.mContext = mContext;
        this.baseFragment = baseFragment;
        this.transactionTimeTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$transactionTimeTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
                return textViewCreateTextView;
            }
        });
        this.amountTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$amountTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextSize(16.0f);
                return textViewCreateTextView;
            }
        });
        this.descriptionTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$descriptionTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setEllipsize(TextUtils.TruncateAt.END);
                textViewCreateTextView.setMaxLines(2);
                textViewCreateTextView.setTextSize(12.0f);
                textViewCreateTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray));
                textViewCreateTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
                return textViewCreateTextView;
            }
        });
        this.imageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$imageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.getMContext());
            }
        });
        this.shareImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$shareImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                WalletCurrencyTransactionItemCell walletCurrencyTransactionItemCell = this.this$0;
                imageView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
                imageView.setImageDrawable(walletCurrencyTransactionItemCell.getContext().getResources().getDrawable(R.drawable.wallet_share_ic));
                return imageView;
            }
        });
        this.optionImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$optionImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ImageView imageView = new ImageView(this.this$0.getContext());
                WalletCurrencyTransactionItemCell walletCurrencyTransactionItemCell = this.this$0;
                imageView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
                imageView.setImageDrawable(walletCurrencyTransactionItemCell.getContext().getResources().getDrawable(R.drawable.wallet_currency_option_ic));
                return imageView;
            }
        });
        setPadding(8, 16, 8, 16);
        setOrientation(1);
        setGravity(16);
        addView(initFirstLayout(), LayoutHelper.createLinear(-1, -2));
        addView(initDescriptionView(), LayoutHelper.createLinear(-1, -2));
        initClickListeners();
    }

    private final TextView getTransactionTimeTextView() {
        return (TextView) this.transactionTimeTextView$delegate.getValue();
    }

    private final TextView getAmountTextView() {
        return (TextView) this.amountTextView$delegate.getValue();
    }

    private final TextView getDescriptionTextView() {
        return (TextView) this.descriptionTextView$delegate.getValue();
    }

    private final ImageView getImageView() {
        return (ImageView) this.imageView$delegate.getValue();
    }

    private final ImageView getShareImageView() {
        return (ImageView) this.shareImageView$delegate.getValue();
    }

    private final ImageView getOptionImageView() {
        return (ImageView) this.optionImageView$delegate.getValue();
    }

    private final LinearLayout initFirstLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.addView(getOptionImageView(), LayoutHelper.createLinear(40, 40, 16, 4, 0, 4, 0));
        linearLayout.addView(getShareImageView(), LayoutHelper.createLinear(40, 40, 16, 4, 0, 4, 0));
        getTransactionTimeTextView().setGravity(5);
        linearLayout.addView(getTransactionTimeTextView(), LayoutHelper.createLinear(0, -2, 1.0f, 17, 4, 4, 4, 4));
        linearLayout.addView(getAmountTextView(), LayoutHelper.createLinear(-2, -2, 4.0f, 4.0f, 4.0f, 4.0f));
        linearLayout.addView(getImageView(), LayoutHelper.createLinear(40, 40, 4.0f, 2.0f, 4.0f, 2.0f));
        return linearLayout;
    }

    private final FrameLayout initDescriptionView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(getDescriptionTextView(), LayoutHelper.createFrame(-2, -2, 5, 0.0f, 0.0f, 50.0f, 0.0f));
        return frameLayout;
    }

    private final void initClickListeners() {
        getShareImageView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletCurrencyTransactionItemCell.m426initClickListeners$lambda2(this.f$0, view);
            }
        });
        getShareImageView().setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return WalletCurrencyTransactionItemCell.m427initClickListeners$lambda3(this.f$0, view);
            }
        });
        getOptionImageView().setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletCurrencyTransactionItemCell.m428initClickListeners$lambda5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickListeners$lambda-2, reason: not valid java name */
    public static final void m426initClickListeners$lambda2(WalletCurrencyTransactionItemCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WalletController.getInstance(UserConfig.selectedAccount).openShareDialogToSendWalletTransactionMessage(this$0.baseFragment, this$0.walletTransactionObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickListeners$lambda-3, reason: not valid java name */
    public static final boolean m427initClickListeners$lambda3(WalletCurrencyTransactionItemCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WalletController.getInstance(UserConfig.selectedAccount).openShareDialogToSendWalletTransactionMessage(this$0.baseFragment, this$0.walletTransactionObject);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initClickListeners$lambda-5, reason: not valid java name */
    public static final void m428initClickListeners$lambda5(WalletCurrencyTransactionItemCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WalletTransactionObject walletTransactionObject = this$0.walletTransactionObject;
        MainClickHandler mainClickHandler = MainClickHandler.getInstance();
        WalletTransactionObject walletTransactionObject2 = this$0.walletTransactionObject;
        mainClickHandler.onLinkClick(walletTransactionObject2 == null ? null : walletTransactionObject2.link);
    }

    public final void setData(WalletTransactionObject walletTransactionObject, String currencyCode) {
        Intrinsics.checkNotNullParameter(walletTransactionObject, "walletTransactionObject");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        this.walletTransactionObject = walletTransactionObject;
        resetData();
        String priceString = NumberUtils.getPriceString(findWalletItemAmount(walletTransactionObject, currencyCode));
        getAmountTextView().setText(priceString + " " + walletTransactionObject.currency_title);
        setContentColor(walletTransactionObject, NumberUtils.getPriceString(priceString).length());
        getDescriptionTextView().setText(walletTransactionObject.description);
        getTransactionTimeTextView().setText(DateFormatUtils.getClock(walletTransactionObject.time));
        setButtons();
    }

    private final String findWalletItemAmount(WalletTransactionObject walletTransactionObject, String str) {
        Object next;
        String string;
        ArrayList<CreditDetailObject> arrayList = walletTransactionObject.credit_details;
        if (arrayList == null) {
            return "0";
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((CreditDetailObject) next).currency_code.equals(str)) {
                break;
            }
        }
        CreditDetailObject creditDetailObject = (CreditDetailObject) next;
        return (creditDetailObject == null || (string = Long.valueOf(creditDetailObject.amount).toString()) == null) ? "0" : string;
    }

    private final void setButtons() {
        Unit unit;
        WalletTransactionObject walletTransactionObject = this.walletTransactionObject;
        if (walletTransactionObject == null || walletTransactionObject.link == null) {
            unit = null;
        } else {
            getOptionImageView().setAlpha(1.0f);
            getOptionImageView().setEnabled(true);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getOptionImageView().setAlpha(0.2f);
            getOptionImageView().setEnabled(false);
        }
        ImageView shareImageView = getShareImageView();
        WalletTransactionObject walletTransactionObject2 = this.walletTransactionObject;
        if (!TextUtils.isEmpty(walletTransactionObject2 == null ? null : walletTransactionObject2.access_transfer)) {
            WalletTransactionObject walletTransactionObject3 = this.walletTransactionObject;
            if (!TextUtils.isEmpty(walletTransactionObject3 != null ? walletTransactionObject3.transfer_id : null)) {
                shareImageView.setAlpha(1.0f);
                shareImageView.setEnabled(true);
                return;
            }
        }
        shareImageView.setAlpha(0.2f);
        shareImageView.setEnabled(false);
    }

    private final void setContentColor(WalletTransactionObject walletTransactionObject, int i) {
        WalletTransactionObject.TransactionTypeEnum transactionTypeEnum = walletTransactionObject.type;
        if (transactionTypeEnum == WalletTransactionObject.TransactionTypeEnum.Charge || transactionTypeEnum == WalletTransactionObject.TransactionTypeEnum.Receive) {
            GlideHelper.loadCircle(this.mContext, getImageView(), BuildConfig.FLAVOR, R.drawable.wallet_currency_positive_ic);
            getAmountTextView().setText(SpanHelper.makeLinkSpanWithColor(SpannableString.valueOf(getAmountTextView().getText()), null, 0, i, R.color.green_500));
        } else {
            GlideHelper.loadCircle(this.mContext, getImageView(), BuildConfig.FLAVOR, R.drawable.wallet_currency_negative_ic);
            getAmountTextView().setText(SpanHelper.makeLinkSpanWithColor(SpannableString.valueOf(getAmountTextView().getText()), null, 0, i, R.color.red_500));
        }
    }

    private final void resetData() {
        getAmountTextView().setText(BuildConfig.FLAVOR);
        getDescriptionTextView().setText(BuildConfig.FLAVOR);
        getTransactionTimeTextView().setText(BuildConfig.FLAVOR);
    }
}
