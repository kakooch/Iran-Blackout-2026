package ir.appp.wallet.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.helper.ViewCreator;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.wallet.CurrencyObject;
import ir.resaneh1.iptv.model.wallet.WalletItemObject;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: WalletItemCell.kt */
/* loaded from: classes3.dex */
public final class WalletItemCell extends FrameLayout {
    private final Lazy amountTextView$delegate;
    private final Lazy currencyImageView$delegate;
    private final Lazy currencyNameTv$delegate;
    private OnWalletClickListener listener;
    private final Context mContext;
    private final Lazy titleTextView$delegate;
    private WalletItemObject walletItemObject;

    /* compiled from: WalletItemCell.kt */
    public interface OnWalletClickListener {
        void onClick(WalletItemObject walletItemObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletItemCell(Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        new LinkedHashMap();
        this.mContext = mContext;
        this.titleTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.WalletItemCell$titleTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return ViewCreator.Companion.createTextView(this.this$0.getMContext());
            }
        });
        this.amountTextView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.WalletItemCell$amountTextView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextColor(this.this$0.getContext().getResources().getColor(R.color.wallet_purple));
                return textViewCreateTextView;
            }
        });
        this.currencyImageView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.appp.wallet.cell.WalletItemCell$currencyImageView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return new ImageView(this.this$0.getMContext());
            }
        });
        this.currencyNameTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.appp.wallet.cell.WalletItemCell$currencyNameTv$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textViewCreateTextView = ViewCreator.Companion.createTextView(this.this$0.getMContext());
                textViewCreateTextView.setTextSize(16.0f);
                textViewCreateTextView.setTypeface(Theme.getWalletTypeFaceBold());
                return textViewCreateTextView;
            }
        });
        initDetails();
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundResource(R.drawable.wallet_bg_rectangle_grey_rounded);
        frameLayout.setPadding(8, 8, 8, 8);
        frameLayout.addView(initRightVerticalLl(), LayoutHelper.createFrame(-2, -2, 21, 0.0f, 0.0f, 66.0f, 0.0f));
        frameLayout.addView(initLeftVerticalLl(), LayoutHelper.createFrame(-2, -2, 19, 8.0f, 4.0f, 0.0f, 4.0f));
        frameLayout.addView(getCurrencyImageView(), LayoutHelper.createFrame(50, 50, 21, 8.0f, 8.0f, 8.0f, 8.0f));
        addView(frameLayout, LayoutHelper.createFrame(-1, -1, 17, 8.0f, 4.0f, 8.0f, 2.0f));
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.cell.WalletItemCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletItemCell.m421_init_$lambda1(this.f$0, view);
            }
        });
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final TextView getTitleTextView() {
        return (TextView) this.titleTextView$delegate.getValue();
    }

    private final TextView getAmountTextView() {
        return (TextView) this.amountTextView$delegate.getValue();
    }

    private final ImageView getCurrencyImageView() {
        return (ImageView) this.currencyImageView$delegate.getValue();
    }

    private final TextView getCurrencyNameTv() {
        return (TextView) this.currencyNameTv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1, reason: not valid java name */
    public static final void m421_init_$lambda1(WalletItemCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.listener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
        }
        OnWalletClickListener onWalletClickListener = this$0.listener;
        WalletItemObject walletItemObject = null;
        if (onWalletClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listener");
            onWalletClickListener = null;
        }
        WalletItemObject walletItemObject2 = this$0.walletItemObject;
        if (walletItemObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletItemObject");
        } else {
            walletItemObject = walletItemObject2;
        }
        onWalletClickListener.onClick(walletItemObject);
    }

    public final void setOnWalletClickListener(OnWalletClickListener onWalletClickListener) {
        Intrinsics.checkNotNullParameter(onWalletClickListener, "onWalletClickListener");
        this.listener = onWalletClickListener;
    }

    private final void initDetails() {
        getTitleTextView().setTextColor(getResources().getColor(R.color.grey_800));
        getAmountTextView().setTextColor(getResources().getColor(R.color.grey_800));
        getCurrencyNameTv().setTextColor(getResources().getColor(R.color.grey_800));
    }

    private final LinearLayout initLeftVerticalLl() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(3);
        linearLayout.addView(getAmountTextView(), LayoutHelper.createLinear(-2, -2, 0.0f, 4.0f, 0.0f, 4.0f));
        linearLayout.addView(getTitleTextView(), LayoutHelper.createLinear(-2, -2, 0.0f, 4.0f, 0.0f, 4.0f));
        return linearLayout;
    }

    private final LinearLayout initRightVerticalLl() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(21);
        linearLayout.addView(getCurrencyNameTv(), LayoutHelper.createLinear(-2, -2, 16));
        return linearLayout;
    }

    public final void setData(WalletItemObject walletItemObject) {
        Unit unit;
        Intrinsics.checkNotNullParameter(walletItemObject, "walletItemObject");
        this.walletItemObject = walletItemObject;
        resetData();
        getAmountTextView().setText(NumberUtils.getPriceString(walletItemObject.amount));
        if (walletItemObject.amount_currency_title != null) {
            getAmountTextView().append(" " + walletItemObject.amount_currency_title);
        }
        String str = walletItemObject.amount_desc;
        Unit unit2 = null;
        if (str == null) {
            unit = null;
        } else {
            if (str.length() > 0) {
                getTitleTextView().setVisibility(0);
                getTitleTextView().setText(NumberUtils.toPersian(walletItemObject.amount_desc));
            } else {
                getTitleTextView().setVisibility(8);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            getTitleTextView().setVisibility(8);
        }
        CurrencyObject currencyObject = walletItemObject.currencyObject;
        if (currencyObject != null) {
            getCurrencyImageView().setVisibility(0);
            GlideHelper.loadCircle(getContext(), getCurrencyImageView(), currencyObject.img_url);
            getCurrencyNameTv().setText(currencyObject.name);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            getCurrencyNameTv().setText(BuildConfig.FLAVOR);
            getCurrencyImageView().setVisibility(8);
        }
    }

    private final void resetData() {
        getTitleTextView().setText(BuildConfig.FLAVOR);
        getAmountTextView().setText(BuildConfig.FLAVOR);
        getCurrencyNameTv().setText(BuildConfig.FLAVOR);
    }
}
