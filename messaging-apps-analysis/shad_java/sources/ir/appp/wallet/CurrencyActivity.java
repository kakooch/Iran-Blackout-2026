package ir.appp.wallet;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidMessenger.proxy.IdStorage;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.wallet.CurrencyActivity;
import ir.appp.wallet.WalletController;
import ir.appp.wallet.cell.WalletHeaderActionCell;
import ir.appp.wallet.cell.currency.WalletCurrencyActionListCell;
import ir.appp.wallet.cell.currency.WalletCurrencyHeaderCell;
import ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell;
import ir.appp.wallet.cell.currency.WalletEmptyCurrencyTransactionCell;
import ir.appp.wallet.helper.ViewCreator;
import ir.appp.wallet.interfaces.WalletChargeListener;
import ir.appp.wallet.interfaces.WalletWithdrawListener;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.wallet.CashOutOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlOutput;
import ir.resaneh1.iptv.model.wallet.CurrencyObject;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsOutput;
import ir.resaneh1.iptv.model.wallet.WalletItemObject;
import ir.resaneh1.iptv.model.wallet.WalletObject;
import ir.resaneh1.iptv.model.wallet.WalletTransactionObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.ContactsActivity;

/* compiled from: CurrencyActivity.kt */
/* loaded from: classes3.dex */
public final class CurrencyActivity extends BaseFragment implements WalletChargeListener, WalletWithdrawListener {
    private final Lazy currencyAdapter$delegate;
    private boolean hasContinue;
    private final ArrayList<Object> items;
    private boolean loading;
    private final Lazy recyclerView$delegate;
    private String startId;
    private final ArrayList<WalletTransactionObject> transactions;
    private WalletItemObject walletItemObject;

    /* compiled from: CurrencyActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CashOutOutput.CashOutStatusEnum.values().length];
            iArr[CashOutOutput.CashOutStatusEnum.OK.ordinal()] = 1;
            iArr[CashOutOutput.CashOutStatusEnum.TooMuchAmount.ordinal()] = 2;
            iArr[CashOutOutput.CashOutStatusEnum.cashOutError.ordinal()] = 3;
            iArr[CashOutOutput.CashOutStatusEnum.DupLocalID.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CurrencyActivity(WalletItemObject walletItemObject) {
        Intrinsics.checkNotNullParameter(walletItemObject, "walletItemObject");
        this.walletItemObject = walletItemObject;
        this.hasContinue = true;
        this.recyclerView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerListView>() { // from class: ir.appp.wallet.CurrencyActivity$recyclerView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerListView invoke() {
                return new RecyclerListView(this.this$0.getContext());
            }
        });
        this.items = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.currencyAdapter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CurrencyAdapter>() { // from class: ir.appp.wallet.CurrencyActivity$currencyAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CurrencyActivity.CurrencyAdapter invoke() {
                CurrencyActivity currencyActivity = this.this$0;
                Context context = currencyActivity.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new CurrencyActivity.CurrencyAdapter(currencyActivity, context);
            }
        });
    }

    public final boolean getHasContinue() {
        return this.hasContinue;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    private final RecyclerListView getRecyclerView() {
        return (RecyclerListView) this.recyclerView$delegate.getValue();
    }

    private final CurrencyAdapter getCurrencyAdapter() {
        return (CurrencyAdapter) this.currencyAdapter$delegate.getValue();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(getRecyclerView(), LayoutHelper.createFrame(-1, -2));
        this.fragmentView = frameLayout;
        initUiDetails();
        this.startId = null;
        this.hasContinue = true;
        this.loading = false;
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    private final void initUiDetails() {
        RecyclerListView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(getCurrencyAdapter());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.wallet.CurrencyActivity$initUiDetails$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrollStateChanged(recyclerView2, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i, i2);
                if (this.this$0.getLoading() || recyclerView2.getChildCount() <= 0) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                if (iFindLastVisibleItemPosition == -1 || !this.this$0.getHasContinue() || recyclerView2.getAdapter() == null) {
                    return;
                }
                RecyclerView.Adapter adapter = recyclerView2.getAdapter();
                Intrinsics.checkNotNull(adapter);
                if (adapter.getItemCount() - iFindLastVisibleItemPosition < 10) {
                    this.this$0.callGetItems();
                }
            }
        });
        getCurrencyAdapter().updateRows();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        callGetItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callGetItems() {
        if (this.hasContinue && !this.loading) {
            this.loading = true;
            WalletController.getInstance(this.currentAccount).getWalletTransactions(this.walletItemObject.currencyObject.currency_code, this.startId, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda1
                @Override // ir.appp.wallet.WalletController.LoadListener
                public final void onComplete(Object obj, Exception exc) {
                    CurrencyActivity.m392callGetItems$lambda4(this.f$0, (GetWalletTransactionsOutput) obj, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callGetItems$lambda-4, reason: not valid java name */
    public static final void m392callGetItems$lambda4(CurrencyActivity this$0, GetWalletTransactionsOutput getWalletTransactionsOutput, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loading = false;
        if ((exc == null ? null : Unit.INSTANCE) == null) {
            if (getWalletTransactionsOutput != null) {
                this$0.updateListItems(getWalletTransactionsOutput);
            }
            this$0.getCurrencyAdapter().updateRows();
        }
    }

    private final void updateListItems(GetWalletTransactionsOutput getWalletTransactionsOutput) {
        this.transactions.addAll(getWalletTransactionsOutput.transactions);
        ArrayList<Object> arrayList = this.items;
        arrayList.clear();
        arrayList.addAll(groupItemsByDate(this.transactions));
        this.hasContinue = getWalletTransactionsOutput.has_continue;
        this.startId = getWalletTransactionsOutput.next_start_id;
    }

    /* compiled from: CurrencyActivity.kt */
    public final class CurrencyAdapter extends RecyclerListView.SelectionAdapter {
        private final int EMPTY_TYPE;
        private final int HEADER_ACTION_TYPE;
        private final int HEADER_TYPE;
        private final int LINE_TYPE;
        private final int LIST_TYPE;
        private final int LOADING_TYPE;
        private final int SECTION_TYPE;
        private final Context context;
        private int dividerRow;
        private int emptyRow;
        private int headerActionsRow;
        private int headerRow;
        private int itemEndRow;
        private int itemStartRow;
        private int loadingRow;
        private int rowCount;
        final /* synthetic */ CurrencyActivity this$0;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public CurrencyAdapter(CurrencyActivity this$0, Context context) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = this$0;
            this.context = context;
            this.headerRow = -1;
            this.headerActionsRow = -1;
            this.emptyRow = -1;
            this.itemStartRow = -1;
            this.itemEndRow = -1;
            this.loadingRow = -1;
            this.dividerRow = -1;
            this.HEADER_ACTION_TYPE = 1;
            this.LIST_TYPE = 2;
            this.EMPTY_TYPE = 3;
            this.LOADING_TYPE = 4;
            this.SECTION_TYPE = 5;
            this.LINE_TYPE = 6;
        }

        private final void resetRows() {
            this.rowCount = 0;
            this.headerRow = -1;
            this.headerActionsRow = -1;
            this.itemStartRow = -1;
            this.itemEndRow = -1;
            this.loadingRow = -1;
            this.dividerRow = -1;
            this.emptyRow = -1;
        }

        public final void updateRows() {
            resetRows();
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.headerRow = i;
            this.rowCount = i2 + 1;
            this.dividerRow = i2;
            if (this.this$0.items.size() > 0) {
                int i3 = this.rowCount;
                this.itemStartRow = i3;
                int size = i3 + this.this$0.items.size();
                this.rowCount = size;
                this.itemEndRow = size;
            } else if (!this.this$0.getHasContinue()) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.emptyRow = i4;
            }
            if (this.this$0.getHasContinue()) {
                int i5 = this.rowCount;
                this.rowCount = i5 + 1;
                this.loadingRow = i5;
            }
            notifyDataSetChanged();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v10, types: [android.widget.TextView] */
        /* JADX WARN: Type inference failed for: r8v11, types: [android.widget.FrameLayout, org.rbmain.ui.Cells.LoadingCell] */
        /* JADX WARN: Type inference failed for: r8v12, types: [android.widget.LinearLayout, ir.appp.wallet.cell.currency.WalletCurrencyTransactionItemCell] */
        /* JADX WARN: Type inference failed for: r8v13, types: [android.widget.LinearLayout, ir.appp.wallet.cell.currency.WalletEmptyCurrencyTransactionCell] */
        /* JADX WARN: Type inference failed for: r8v14, types: [android.widget.LinearLayout, ir.appp.wallet.cell.currency.WalletCurrencyActionListCell] */
        /* JADX WARN: Type inference failed for: r8v16, types: [android.widget.LinearLayout, ir.appp.wallet.cell.currency.WalletCurrencyHeaderCell] */
        /* JADX WARN: Type inference failed for: r8v9, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            ShadowSectionCell shadowSectionCell;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == this.HEADER_TYPE) {
                ?? walletCurrencyHeaderCell = new WalletCurrencyHeaderCell(this.context);
                walletCurrencyHeaderCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = walletCurrencyHeaderCell;
            } else if (i == this.HEADER_ACTION_TYPE) {
                ?? walletCurrencyActionListCell = new WalletCurrencyActionListCell(this.context);
                walletCurrencyActionListCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                WalletHeaderActionCell transferAction = walletCurrencyActionListCell.getTransferAction();
                final CurrencyActivity currencyActivity = this.this$0;
                transferAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.CurrencyActivity$CurrencyAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CurrencyActivity.CurrencyAdapter.m396onCreateViewHolder$lambda0(currencyActivity, view);
                    }
                });
                WalletHeaderActionCell cashOutAction = walletCurrencyActionListCell.getCashOutAction();
                final CurrencyActivity currencyActivity2 = this.this$0;
                cashOutAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.CurrencyActivity$CurrencyAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CurrencyActivity.CurrencyAdapter.m397onCreateViewHolder$lambda1(this.f$0, currencyActivity2, view);
                    }
                });
                WalletHeaderActionCell buyAction = walletCurrencyActionListCell.getBuyAction();
                final CurrencyActivity currencyActivity3 = this.this$0;
                buyAction.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.CurrencyActivity$CurrencyAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CurrencyActivity.CurrencyAdapter.m398onCreateViewHolder$lambda2(this.f$0, currencyActivity3, view);
                    }
                });
                shadowSectionCell = walletCurrencyActionListCell;
            } else if (i == this.EMPTY_TYPE) {
                ?? walletEmptyCurrencyTransactionCell = new WalletEmptyCurrencyTransactionCell(this.context);
                walletEmptyCurrencyTransactionCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = walletEmptyCurrencyTransactionCell;
            } else if (i == this.LIST_TYPE) {
                Context context = this.context;
                BaseFragment baseFragment = this.this$0.baseFragment;
                Intrinsics.checkNotNullExpressionValue(baseFragment, "baseFragment");
                ?? walletCurrencyTransactionItemCell = new WalletCurrencyTransactionItemCell(context, baseFragment);
                walletCurrencyTransactionItemCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = walletCurrencyTransactionItemCell;
            } else if (i == this.LOADING_TYPE) {
                ?? loadingCell = new LoadingCell(this.context);
                loadingCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                shadowSectionCell = loadingCell;
            } else if (i == this.SECTION_TYPE) {
                ?? textView = new TextView(this.context);
                textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f));
                textView.setTypeface(Theme.getWalletTypeFaceRegular());
                textView.setTextColor(Color.parseColor("#9E9E9E"));
                textView.setBackgroundColor(Color.parseColor("#F5F5F5"));
                textView.setTextSize(1, 16.0f);
                textView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                shadowSectionCell = textView;
            } else if (i == this.LINE_TYPE) {
                ?? view = new View(this.context);
                view.setBackgroundColor(Color.parseColor("#9E9E9E"));
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, AndroidUtilities.dp(1.0f)));
                shadowSectionCell = view;
            } else {
                shadowSectionCell = new ShadowSectionCell(this.context);
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-0, reason: not valid java name */
        public static final void m396onCreateViewHolder$lambda0(CurrencyActivity this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTransferClicked();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-1, reason: not valid java name */
        public static final void m397onCreateViewHolder$lambda1(CurrencyAdapter this$0, CurrencyActivity this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            ViewCreator.Companion.initCashOutBottomSheet(this$0.context, this$1, this$1.walletItemObject.title);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-2, reason: not valid java name */
        public static final void m398onCreateViewHolder$lambda2(CurrencyAdapter this$0, CurrencyActivity this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            ViewCreator.Companion.initChargeBottomSheet(this$0.context, 0, this$1, this$1.walletItemObject.title);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int itemViewType = getItemViewType(i);
            if (itemViewType == this.HEADER_TYPE) {
                ((WalletCurrencyHeaderCell) holder.itemView).setData(this.this$0.walletItemObject);
                return;
            }
            if (itemViewType == this.HEADER_ACTION_TYPE) {
                ((WalletCurrencyActionListCell) holder.itemView).setData();
                return;
            }
            if (itemViewType == this.EMPTY_TYPE) {
                ((WalletEmptyCurrencyTransactionCell) holder.itemView).setData();
                return;
            }
            if (itemViewType == this.LIST_TYPE) {
                WalletCurrencyTransactionItemCell walletCurrencyTransactionItemCell = (WalletCurrencyTransactionItemCell) holder.itemView;
                WalletTransactionObject walletTransactionObject = (WalletTransactionObject) this.this$0.items.get(i - this.itemStartRow);
                String str = this.this$0.walletItemObject.currency_code;
                Intrinsics.checkNotNullExpressionValue(str, "walletItemObject.currency_code");
                walletCurrencyTransactionItemCell.setData(walletTransactionObject, str);
                return;
            }
            if (itemViewType == this.SECTION_TYPE) {
                ((TextView) holder.itemView).setText((CharSequence) this.this$0.items.get(i - this.itemStartRow));
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
            if (i == this.emptyRow) {
                return this.EMPTY_TYPE;
            }
            if (i == this.dividerRow) {
                return this.LINE_TYPE;
            }
            int i2 = this.itemStartRow;
            boolean z = false;
            if (i < this.itemEndRow && i2 <= i) {
                z = true;
            }
            if (z) {
                return this.this$0.items.get(i - this.itemStartRow) instanceof WalletTransactionObject ? this.LIST_TYPE : this.SECTION_TYPE;
            }
            return -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTransferClicked() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("destroyAfterSelect", true);
        bundle.putBoolean("returnAsResult", true);
        bundle.putBoolean("onlyUsers", true);
        bundle.putBoolean("allowSelf", false);
        bundle.putBoolean("allowBots", false);
        ContactsActivity contactsActivity = new ContactsActivity(bundle);
        contactsActivity.setDelegate(new ContactsActivity.ContactsActivityDelegate() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda5
            @Override // org.rbmain.ui.ContactsActivity.ContactsActivityDelegate
            public final void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity2) {
                CurrencyActivity.m393onTransferClicked$lambda8(this.f$0, tLRPC$User, str, contactsActivity2);
            }
        });
        this.baseFragment.presentFragment(contactsActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTransferClicked$lambda-8, reason: not valid java name */
    public static final void m393onTransferClicked$lambda8(final CurrencyActivity this$0, TLRPC$User user, String str, ContactsActivity contactsActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(user, "user");
        String dialogId = IdStorage.getInstance().getDialogId(user.id);
        WalletController walletController = WalletController.getInstance(this$0.currentAccount);
        WalletItemObject walletItemObject = this$0.walletItemObject;
        String str2 = walletItemObject.currency_code;
        CurrencyObject currencyObject = walletItemObject.currencyObject;
        walletController.checkToTransfer(dialogId, str2, currencyObject == null ? null : currencyObject.name, this$0.compositeDisposable, this$0, new WalletController.LoadListener() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda2
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                CurrencyActivity.m394onTransferClicked$lambda8$lambda7(this.f$0, (WalletObject) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTransferClicked$lambda-8$lambda-7, reason: not valid java name */
    public static final void m394onTransferClicked$lambda8$lambda7(CurrencyActivity this$0, WalletObject wallet, Exception exc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (wallet == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(wallet, "wallet");
        this$0.updateWalletItemObject(wallet);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        this.actionBar = actionBarCreateActionBar;
        actionBarCreateActionBar.createCenterTitleTextView();
        actionBarCreateActionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBarCreateActionBar.setItemsColor(-1, false);
        actionBarCreateActionBar.centerTitleTextView1.setText(this.walletItemObject.currencyObject.name);
        actionBarCreateActionBar.centerTitleTextView1.setTypeface(Theme.getWalletTypeFaceRegular());
        actionBarCreateActionBar.centerTitleTextView1.setTextColor(-1);
        actionBarCreateActionBar.setBackgroundColor(context.getResources().getColor(R.color.wallet_purple));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.wallet.CurrencyActivity$createActionBar$1$1
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

    private final void callCashOutApi(final BottomSheetDialog bottomSheetDialog, String str) {
        if (TextUtils.isEmpty(str) || str == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getContext(), 3);
        alertDialog.show();
        WalletController.getInstance(this.currentAccount).cashOut(this.walletItemObject.currency_code, str, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda3
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                CurrencyActivity.m390callCashOutApi$lambda16(alertDialog, this, bottomSheetDialog, (CashOutOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callCashOutApi$lambda-16, reason: not valid java name */
    public static final void m390callCashOutApi$lambda16(AlertDialog loading, CurrencyActivity this$0, BottomSheetDialog bottomSheet, CashOutOutput cashOutOutput, Exception exc) {
        Intrinsics.checkNotNullParameter(loading, "$loading");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        Unit unit = null;
        if (exc != null) {
            loading.dismiss();
            showCashOutFailedDialog$default(this$0, null, 1, null);
            unit = Unit.INSTANCE;
        }
        if (unit != null || cashOutOutput == null) {
            return;
        }
        loading.dismiss();
        CashOutOutput.CashOutStatusEnum cashOutStatusEnum = cashOutOutput.status;
        if (cashOutStatusEnum == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[cashOutStatusEnum.ordinal()];
        if (i == 1) {
            this$0.showCashOutSuccessfulDialog();
            WalletObject walletObject = cashOutOutput.wallet;
            Intrinsics.checkNotNullExpressionValue(walletObject, "it.wallet");
            this$0.updateWalletItemObject(walletObject);
            bottomSheet.dismiss();
            return;
        }
        if (i == 2) {
            String string = LocaleController.getString("wallet_cash_out_too_much", R.string.wallet_cash_out_too_much);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …                        )");
            this$0.showCashOutFailedDialog(string);
        } else if (i == 3) {
            String string2 = LocaleController.getString("wallet_cash_out_error", R.string.wallet_cash_out_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …                        )");
            this$0.showCashOutFailedDialog(string2);
        } else {
            if (i != 4) {
                return;
            }
            String string3 = LocaleController.getString("wallet_cash_out_duplicat", R.string.wallet_cash_out_duplicat);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(\n             …                        )");
            this$0.showCashOutFailedDialog(string3);
        }
    }

    private final void updateWalletItemObject(WalletObject walletObject) {
        Object next;
        ArrayList<WalletItemObject> arrayList = walletObject.wallet_items;
        Intrinsics.checkNotNullExpressionValue(arrayList, "wallet.wallet_items");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((WalletItemObject) next).currency_code.equals(this.walletItemObject.currency_code)) {
                    break;
                }
            }
        }
        WalletItemObject walletItemObject = (WalletItemObject) next;
        if (walletItemObject == null) {
            return;
        }
        walletItemObject.currencyObject = this.walletItemObject.currencyObject;
        this.walletItemObject = walletItemObject;
        getCurrencyAdapter().updateRows();
    }

    private final void showCashOutSuccessfulDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(LocaleController.getString("wallet_cash_out_successful", R.string.wallet_cash_out_successful));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    static /* synthetic */ void showCashOutFailedDialog$default(CurrencyActivity currencyActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = LocaleController.getString("wallet_retry", R.string.wallet_retry);
            Intrinsics.checkNotNullExpressionValue(str, "getString(\n            \"…ng.wallet_retry\n        )");
        }
        currencyActivity.showCashOutFailedDialog(str);
    }

    private final void showCashOutFailedDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.baseFragment.showDialog(builder.create());
    }

    @Override // ir.appp.wallet.interfaces.WalletChargeListener
    public void charge(BottomSheetDialog bottomSheet, String value, int i) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics.checkNotNullParameter(value, "value");
        if (i == 0) {
            callChargeApiByUrl(bottomSheet, value);
        }
    }

    private final void callChargeApiByUrl(final BottomSheetDialog bottomSheetDialog, String str) {
        WalletController.getInstance(this.currentAccount).chargeWalletByUrl(this, str, this.walletItemObject.currency_code, this.compositeDisposable, new WalletController.LoadListener() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda0
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                CurrencyActivity.m391callChargeApiByUrl$lambda19(bottomSheetDialog, (ChargeWalletByUrlOutput.Status) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callChargeApiByUrl$lambda-19, reason: not valid java name */
    public static final void m391callChargeApiByUrl$lambda19(BottomSheetDialog bottomSheet, ChargeWalletByUrlOutput.Status status, Exception exc) {
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        if (exc == null && status == ChargeWalletByUrlOutput.Status.OK) {
            bottomSheet.dismiss();
        }
    }

    @Override // ir.appp.wallet.interfaces.WalletWithdrawListener
    public void withdraw(final BottomSheetDialog bottomSheet, final String amount) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics.checkNotNullParameter(amount, "amount");
        AlertsCreator.showAskAlert(getContext(), LocaleController.formatString(R.string.confirm_cash_out_question, amount).toString(), new AlertsCreator.AskAlertDelegate() { // from class: ir.appp.wallet.CurrencyActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
            public final void onAccepted() {
                CurrencyActivity.m395withdraw$lambda20(this.f$0, bottomSheet, amount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: withdraw$lambda-20, reason: not valid java name */
    public static final void m395withdraw$lambda20(CurrencyActivity this$0, BottomSheetDialog bottomSheet, String amount) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheet, "$bottomSheet");
        Intrinsics.checkNotNullParameter(amount, "$amount");
        this$0.callCashOutApi(bottomSheet, amount);
    }

    private final List<Object> groupItemsByDate(List<? extends WalletTransactionObject> list) {
        List listSortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: ir.appp.wallet.CurrencyActivity$groupItemsByDate$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((WalletTransactionObject) t2).time), Long.valueOf(((WalletTransactionObject) t).time));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listSortedWith) {
            String persian = NumberUtils.toPersian(LocaleController.formatDateChat(((WalletTransactionObject) obj).time));
            Object arrayList = linkedHashMap.get(persian);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(persian, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String date = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(date, "date");
            arrayList2.add(date);
            arrayList2.addAll(list2);
        }
        return arrayList2;
    }
}
