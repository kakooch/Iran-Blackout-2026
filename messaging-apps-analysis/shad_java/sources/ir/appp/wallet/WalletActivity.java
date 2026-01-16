package ir.appp.wallet;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.proxy.IdStorage;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.WalletActivity;
import ir.appp.wallet.WalletController;
import ir.appp.wallet.cell.WalletHeaderActionCell;
import ir.appp.wallet.cell.WalletHeaderActionListCell;
import ir.appp.wallet.cell.WalletHeaderCell;
import ir.appp.wallet.cell.WalletItemCell;
import ir.appp.wallet.helper.ViewCreator;
import ir.appp.wallet.interfaces.WalletChargeListener;
import ir.appp.wallet.interfaces.WalletWithdrawListener;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.wallet.CashOutOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlOutput;
import ir.resaneh1.iptv.model.wallet.WalletItemObject;
import ir.resaneh1.iptv.model.wallet.WalletObject;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.ContactsActivity;

/* compiled from: WalletActivity.kt */
/* loaded from: classes3.dex */
public final class WalletActivity extends BaseFragment implements WalletChargeListener, WalletWithdrawListener {
    private boolean hasContinue;
    private final ArrayList<WalletItemObject> items;
    private final Lazy recyclerView$delegate;
    private final Lazy walletAdapter$delegate;
    private WalletObject walletObject;

    /* compiled from: WalletActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ChargeWalletByTokenOutput.ChargeWalletStatusEnum.values().length];
            iArr[ChargeWalletByTokenOutput.ChargeWalletStatusEnum.NotValidToken.ordinal()] = 1;
            iArr[ChargeWalletByTokenOutput.ChargeWalletStatusEnum.UsedToken.ordinal()] = 2;
            iArr[ChargeWalletByTokenOutput.ChargeWalletStatusEnum.ExpiredToken.ordinal()] = 3;
            iArr[ChargeWalletByTokenOutput.ChargeWalletStatusEnum.ChargeError.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CashOutOutput.CashOutStatusEnum.values().length];
            iArr2[CashOutOutput.CashOutStatusEnum.OK.ordinal()] = 1;
            iArr2[CashOutOutput.CashOutStatusEnum.TooMuchAmount.ordinal()] = 2;
            iArr2[CashOutOutput.CashOutStatusEnum.DupLocalID.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public WalletActivity() {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "WalletActivity";
        this.recyclerView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerListView>() { // from class: ir.appp.wallet.WalletActivity$recyclerView$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final RecyclerListView invoke() {
                return new RecyclerListView(this.this$0.getContext());
            }
        });
        this.walletAdapter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<WalletAdapter>() { // from class: ir.appp.wallet.WalletActivity$walletAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WalletActivity.WalletAdapter invoke() {
                WalletActivity walletActivity = this.this$0;
                Context context = walletActivity.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new WalletActivity.WalletAdapter(walletActivity, context);
            }
        });
        this.items = new ArrayList<>();
        this.hasContinue = true;
    }

    private final RecyclerListView getRecyclerView() {
        return (RecyclerListView) this.recyclerView$delegate.getValue();
    }

    private final WalletAdapter getWalletAdapter() {
        return (WalletAdapter) this.walletAdapter$delegate.getValue();
    }

    public final ArrayList<WalletItemObject> getItems() {
        return this.items;
    }

    public final boolean getHasContinue() {
        return this.hasContinue;
    }

    public final WalletObject getWalletObject() {
        return this.walletObject;
    }

    public final void setWalletObject(WalletObject walletObject) {
        this.walletObject = walletObject;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(getRecyclerView(), LayoutHelper.createFrame(-1, -1, 48));
        this.fragmentView = frameLayout;
        initRecyclerView();
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        refresh();
    }

    public final void refresh() {
        callGetWallet();
    }

    private final void callChargeApi(final BottomSheetDialog bottomSheetDialog, String str) {
        final AlertDialog alertDialog = new AlertDialog(getContext(), 3);
        alertDialog.show();
        WalletController.getInstance(this.currentAccount).chargeWalletByToken(str, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda5
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m404callChargeApi$lambda4(alertDialog, bottomSheetDialog, this, (ChargeWalletByTokenOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callChargeApi$lambda-4, reason: not valid java name */
    public static final void m404callChargeApi$lambda4(AlertDialog loading, BottomSheetDialog bottomSheet, WalletActivity this$0, ChargeWalletByTokenOutput chargeWalletByTokenOutput, Exception exc) {
        Unit unit;
        Intrinsics.checkNotNullParameter(loading, "$loading");
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = null;
        if (exc == null) {
            unit = null;
        } else {
            loading.dismiss();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            loading.dismiss();
            ChargeWalletByTokenOutput.ChargeWalletStatusEnum chargeWalletStatusEnum = chargeWalletByTokenOutput.status;
            if (chargeWalletStatusEnum == ChargeWalletByTokenOutput.ChargeWalletStatusEnum.OK) {
                bottomSheet.dismiss();
                this$0.showChargeSuccessfulDialog();
                this$0.updateWalletObject(chargeWalletByTokenOutput.wallet);
                return;
            }
            int i = chargeWalletStatusEnum == null ? -1 : WhenMappings.$EnumSwitchMapping$0[chargeWalletStatusEnum.ordinal()];
            if (i == 1) {
                string = LocaleController.getString(R.string.wallet_charge_not_valid_token);
            } else if (i == 2) {
                string = LocaleController.getString(R.string.wallet_charge_used_token);
            } else if (i == 3) {
                string = LocaleController.getString(R.string.wallet_charge_expired_token);
            }
            this$0.showCashOutFailedDialog(string);
        }
    }

    private final void showCashOutSuccessfulDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(LocaleController.getString("wallet_cash_out_successful", R.string.wallet_cash_out_successful));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    private final void showChargeSuccessfulDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(LocaleController.getString("wallet_charge_successful", R.string.wallet_charge_successful));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    static /* synthetic */ void showCashOutFailedDialog$default(WalletActivity walletActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = LocaleController.getString("wallet_retry", R.string.wallet_retry);
        }
        walletActivity.showCashOutFailedDialog(str);
    }

    private final void showCashOutFailedDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    private final void showDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    private final void callGetWallet() {
        WalletController.getInstance(this.currentAccount).getWalletStatus(this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda4
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m406callGetWallet$lambda7(this.f$0, (WalletObject) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callGetWallet$lambda-7, reason: not valid java name */
    public static final void m406callGetWallet$lambda7(WalletActivity this$0, WalletObject walletObject, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((exc == null ? null : Unit.INSTANCE) == null) {
            this$0.updateWalletObject(walletObject);
        }
    }

    private final void initRecyclerView() {
        RecyclerListView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(getWalletAdapter());
        recyclerView.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
        updateRows();
    }

    public final void updateRows() {
        getWalletAdapter().updateRows();
        getWalletAdapter().notifyDataSetChanged();
    }

    /* compiled from: WalletActivity.kt */
    public final class WalletAdapter extends RecyclerListView.SelectionAdapter {
        private final int HEADER_ACTION_TYPE;
        private final int HEADER_TYPE;
        private final int LIST_TYPE;
        private final int LOADING_TYPE;
        private final Context context;
        private int headerActionsRow;
        private int headerRow;
        private int itemEndRow;
        private int itemStartRow;
        private int loadingRow;
        private int rowCount;
        final /* synthetic */ WalletActivity this$0;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public WalletAdapter(WalletActivity this$0, Context context) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = this$0;
            this.context = context;
            this.headerRow = -1;
            this.headerActionsRow = -1;
            this.itemStartRow = -1;
            this.itemEndRow = -1;
            this.loadingRow = -1;
            this.HEADER_ACTION_TYPE = 1;
            this.LIST_TYPE = 2;
            this.LOADING_TYPE = 3;
        }

        public final void updateRows() {
            resetRows();
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.headerRow = i;
            this.rowCount = i2 + 1;
            this.headerActionsRow = i2;
            if (this.this$0.getItems().size() > 0) {
                int i3 = this.rowCount;
                this.itemStartRow = i3;
                int size = i3 + this.this$0.getItems().size();
                this.rowCount = size;
                this.itemEndRow = size;
            }
            if (this.this$0.getHasContinue()) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.loadingRow = i4;
            }
        }

        private final void resetRows() {
            this.rowCount = 0;
            this.headerRow = -1;
            this.headerActionsRow = -1;
            this.itemStartRow = -1;
            this.itemEndRow = -1;
            this.loadingRow = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v10, types: [android.widget.LinearLayout, ir.appp.wallet.cell.WalletHeaderCell] */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.FrameLayout, ir.appp.wallet.cell.WalletItemCell] */
        /* JADX WARN: Type inference failed for: r5v7, types: [android.widget.FrameLayout, org.rbmain.ui.Cells.LoadingCell] */
        /* JADX WARN: Type inference failed for: r5v8, types: [android.widget.FrameLayout, ir.appp.wallet.cell.WalletHeaderActionListCell] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            ShadowSectionCell shadowSectionCell;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == this.HEADER_TYPE) {
                ?? walletHeaderCell = new WalletHeaderCell(this.context);
                walletHeaderCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = walletHeaderCell;
            } else if (i == this.HEADER_ACTION_TYPE) {
                ?? walletHeaderActionListCell = new WalletHeaderActionListCell(this.context);
                WalletHeaderActionCell transferAction = walletHeaderActionListCell.getTransferAction();
                final WalletActivity walletActivity = this.this$0;
                transferAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.WalletActivity$WalletAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WalletActivity.WalletAdapter.m414onCreateViewHolder$lambda0(walletActivity, view);
                    }
                });
                WalletHeaderActionCell chargeByTokenAction = walletHeaderActionListCell.getChargeByTokenAction();
                final WalletActivity walletActivity2 = this.this$0;
                chargeByTokenAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.WalletActivity$WalletAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WalletActivity.WalletAdapter.m415onCreateViewHolder$lambda1(walletActivity2, view);
                    }
                });
                WalletHeaderActionCell cashOutAction = walletHeaderActionListCell.getCashOutAction();
                final WalletActivity walletActivity3 = this.this$0;
                cashOutAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.WalletActivity$WalletAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WalletActivity.WalletAdapter.m416onCreateViewHolder$lambda2(walletActivity3, view);
                    }
                });
                WalletHeaderActionCell shareAction = walletHeaderActionListCell.getShareAction();
                final WalletActivity walletActivity4 = this.this$0;
                shareAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.WalletActivity$WalletAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WalletActivity.WalletAdapter.m417onCreateViewHolder$lambda3(walletActivity4, view);
                    }
                });
                walletHeaderActionListCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = walletHeaderActionListCell;
            } else if (i == this.LOADING_TYPE) {
                ?? loadingCell = new LoadingCell(this.context);
                loadingCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = loadingCell;
            } else if (i == this.LIST_TYPE) {
                ?? walletItemCell = new WalletItemCell(this.context);
                walletItemCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                final WalletActivity walletActivity5 = this.this$0;
                walletItemCell.setOnWalletClickListener(new WalletItemCell.OnWalletClickListener() { // from class: ir.appp.wallet.WalletActivity$WalletAdapter$onCreateViewHolder$5
                    @Override // ir.appp.wallet.cell.WalletItemCell.OnWalletClickListener
                    public void onClick(WalletItemObject walletItemObject) {
                        Intrinsics.checkNotNullParameter(walletItemObject, "walletItemObject");
                        walletActivity5.presentFragment(new CurrencyActivity(walletItemObject));
                    }
                });
                shadowSectionCell = walletItemCell;
            } else {
                shadowSectionCell = new ShadowSectionCell(this.context);
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-0, reason: not valid java name */
        public static final void m414onCreateViewHolder$lambda0(WalletActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTransferClicked();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-1, reason: not valid java name */
        public static final void m415onCreateViewHolder$lambda1(WalletActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.chargeToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-2, reason: not valid java name */
        public static final void m416onCreateViewHolder$lambda2(WalletActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.cashOut();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-3, reason: not valid java name */
        public static final void m417onCreateViewHolder$lambda3(WalletActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WalletController.getInstance(((BaseFragment) this$0).currentAccount).shareWalletLink();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int itemViewType = getItemViewType(i);
            if (itemViewType == this.HEADER_TYPE) {
                ((WalletHeaderCell) holder.itemView).setData(this.this$0.getWalletObject());
                return;
            }
            if (itemViewType == this.HEADER_ACTION_TYPE) {
                ((WalletHeaderActionListCell) holder.itemView).setData();
            } else if (itemViewType == this.LIST_TYPE) {
                WalletItemCell walletItemCell = (WalletItemCell) holder.itemView;
                WalletItemObject walletItemObject = this.this$0.getItems().get(i - this.itemStartRow);
                Intrinsics.checkNotNullExpressionValue(walletItemObject, "items[position - itemStartRow]");
                walletItemCell.setData(walletItemObject);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.headerRow) {
                return this.HEADER_TYPE;
            }
            if (i == this.headerActionsRow) {
                return this.HEADER_ACTION_TYPE;
            }
            if (i == this.loadingRow) {
                return this.LOADING_TYPE;
            }
            int i2 = this.itemStartRow;
            boolean z = false;
            if (i < this.itemEndRow && i2 <= i) {
                z = true;
            }
            if (z) {
                return this.LIST_TYPE;
            }
            return -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cashOut() {
        WalletObject walletObject = this.walletObject;
        boolean z = false;
        if (walletObject != null && walletObject.allow_cash_out) {
            z = true;
        }
        if (z) {
            ViewCreator.Companion companion = ViewCreator.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            WalletObject walletObject2 = this.walletObject;
            companion.initCashOutBottomSheet(context, this, walletObject2 == null ? null : walletObject2.currency_title);
            return;
        }
        String string = LocaleController.getString("wallet_cashout_not_allowed", R.string.wallet_cashout_not_allowed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …allowed\n                )");
        showDialog(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void chargeToken() {
        WalletObject walletObject = this.walletObject;
        if (walletObject != null && walletObject.allow_charge) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            String string = LocaleController.getString("wallet_charge_by_payment", R.string.wallet_charge_by_payment);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …payment\n                )");
            String string2 = LocaleController.getString("wallet_charge_by_token", R.string.wallet_charge_by_token);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …y_token\n                )");
            builder.setItems(new CharSequence[]{string, string2}, new DialogInterface.OnClickListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletActivity.m407chargeToken$lambda9(this.f$0, dialogInterface, i);
                }
            });
            showDialog(builder.create());
            return;
        }
        String string3 = LocaleController.getString("wallet_charge_not_allowed", R.string.wallet_charge_not_allowed);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(\n             …allowed\n                )");
        showDialog(string3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: chargeToken$lambda-9, reason: not valid java name */
    public static final void m407chargeToken$lambda9(WalletActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewCreator.Companion companion = ViewCreator.Companion;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WalletObject walletObject = this$0.walletObject;
        companion.initChargeBottomSheet(context, i, this$0, walletObject == null ? null : walletObject.currency_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTransferClicked() {
        WalletObject walletObject = this.walletObject;
        if (walletObject != null && walletObject.allow_send) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("destroyAfterSelect", true);
            bundle.putBoolean("returnAsResult", true);
            bundle.putBoolean("onlyUsers", true);
            bundle.putBoolean("allowSelf", false);
            bundle.putBoolean("allowBots", false);
            ContactsActivity contactsActivity = new ContactsActivity(bundle);
            contactsActivity.setDelegate(new ContactsActivity.ContactsActivityDelegate() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda8
                @Override // org.rbmain.ui.ContactsActivity.ContactsActivityDelegate
                public final void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity2) {
                    WalletActivity.m408onTransferClicked$lambda12(this.f$0, tLRPC$User, str, contactsActivity2);
                }
            });
            this.baseFragment.presentFragment(contactsActivity);
            return;
        }
        String string = LocaleController.getString("wallet_transfer_not_allowed", R.string.wallet_transfer_not_allowed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …allowed\n                )");
        showDialog(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTransferClicked$lambda-12, reason: not valid java name */
    public static final void m408onTransferClicked$lambda12(final WalletActivity this$0, TLRPC$User user, String str, ContactsActivity contactsActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(user, "user");
        String dialogId = IdStorage.getInstance().getDialogId(user.id);
        WalletController walletController = WalletController.getInstance(this$0.currentAccount);
        WalletObject walletObject = this$0.walletObject;
        walletController.checkToTransfer(dialogId, null, walletObject == null ? null : walletObject.currency_title, this$0.compositeDisposable, this$0, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda2
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m409onTransferClicked$lambda12$lambda11(this.f$0, (WalletObject) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTransferClicked$lambda-12$lambda-11, reason: not valid java name */
    public static final void m409onTransferClicked$lambda12$lambda11(WalletActivity this$0, WalletObject walletObject, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (walletObject == null) {
            return;
        }
        this$0.updateWalletObject(walletObject);
    }

    private final void updateWalletObject(WalletObject walletObject) {
        if (walletObject == null) {
            return;
        }
        setWalletObject(walletObject);
        updateWalletItems();
        updateRows();
    }

    private final void updateWalletItems() {
        WalletController.getInstance(this.currentAccount).updateCurrencies(this.walletObject, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda3
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m410updateWalletItems$lambda14(this.f$0, (WalletObject) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateWalletItems$lambda-14, reason: not valid java name */
    public static final void m410updateWalletItems$lambda14(WalletActivity this$0, WalletObject walletObject, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (exc != null || walletObject == null) {
            return;
        }
        this$0.walletObject = walletObject;
        this$0.items.clear();
        this$0.items.addAll(walletObject.wallet_items);
        this$0.hasContinue = false;
        this$0.updateRows();
    }

    @Override // ir.appp.wallet.interfaces.WalletChargeListener
    public void charge(BottomSheetDialog bottomSheet, String value, int i) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics.checkNotNullParameter(value, "value");
        WalletObject walletObject = this.walletObject;
        boolean z = false;
        if (walletObject != null && walletObject.allow_charge) {
            z = true;
        }
        if (!z) {
            String string = LocaleController.getString("wallet_charge_not_allowed", R.string.wallet_charge_not_allowed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …allowed\n                )");
            showDialog(string);
        } else if (i == 0) {
            callChargeApiByUrl(bottomSheet, value);
        } else {
            if (i != 1) {
                return;
            }
            callChargeApi(bottomSheet, value);
        }
    }

    private final void callChargeApiByUrl(final BottomSheetDialog bottomSheetDialog, String str) {
        WalletController.getInstance(this.currentAccount).chargeWalletByUrl(this, str, null, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda1
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m405callChargeApiByUrl$lambda15(bottomSheetDialog, (ChargeWalletByUrlOutput.Status) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callChargeApiByUrl$lambda-15, reason: not valid java name */
    public static final void m405callChargeApiByUrl$lambda15(BottomSheetDialog bottomSheet, ChargeWalletByUrlOutput.Status status, Exception exc) {
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        if (exc == null && status == ChargeWalletByUrlOutput.Status.OK) {
            bottomSheet.dismiss();
        }
    }

    @Override // ir.appp.wallet.interfaces.WalletWithdrawListener
    public void withdraw(final BottomSheetDialog bottomSheet, final String amount) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics.checkNotNullParameter(amount, "amount");
        AlertsCreator.showAskAlert(getContext(), LocaleController.formatString(R.string.confirm_cash_out_question, amount).toString(), new AlertsCreator.AskAlertDelegate() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda7
            @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
            public final void onAccepted() {
                WalletActivity.m411withdraw$lambda16(this.f$0, bottomSheet, amount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: withdraw$lambda-16, reason: not valid java name */
    public static final void m411withdraw$lambda16(WalletActivity this$0, BottomSheetDialog bottomSheet, String amount) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        Intrinsics.checkNotNullParameter(amount, "$amount");
        this$0.callCashOutApi(bottomSheet, amount);
    }

    private final void callCashOutApi(final BottomSheetDialog bottomSheetDialog, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getContext(), 3);
        alertDialog.show();
        WalletController.getInstance(this.currentAccount).cashOut(null, str, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.WalletActivity$$ExternalSyntheticLambda6
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                WalletActivity.m403callCashOutApi$lambda20(alertDialog, this, bottomSheetDialog, (CashOutOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callCashOutApi$lambda-20, reason: not valid java name */
    public static final void m403callCashOutApi$lambda20(AlertDialog loading, WalletActivity this$0, BottomSheetDialog bottomSheet, CashOutOutput cashOutOutput, Exception exc) {
        Intrinsics.checkNotNullParameter(loading, "$loading");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        Unit unit = null;
        if (exc != null) {
            loading.dismiss();
            showCashOutFailedDialog$default(this$0, null, 1, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            loading.dismiss();
            CashOutOutput.CashOutStatusEnum cashOutStatusEnum = cashOutOutput.status;
            if (cashOutStatusEnum == null) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[cashOutStatusEnum.ordinal()];
            if (i == 1) {
                this$0.showCashOutSuccessfulDialog();
                this$0.updateWalletObject(cashOutOutput.wallet);
                bottomSheet.dismiss();
            } else if (i == 2) {
                this$0.showCashOutFailedDialog(LocaleController.getString("wallet_cash_out_too_much", R.string.wallet_cash_out_too_much));
            } else {
                if (i != 3) {
                    return;
                }
                this$0.showCashOutFailedDialog(LocaleController.getString("wallet_cash_out_duplicat", R.string.wallet_cash_out_duplicat));
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        this.actionBar = actionBarCreateActionBar;
        actionBarCreateActionBar.createCenterTitleTextView();
        actionBarCreateActionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.wallet.WalletActivity$createActionBar$1$1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    this.this$0.finishFragment();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(actionBarCreateActionBar, "actionBar.apply {\n      …\n            })\n        }");
        return actionBarCreateActionBar;
    }
}
