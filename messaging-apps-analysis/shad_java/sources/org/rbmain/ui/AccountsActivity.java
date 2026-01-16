package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.ServiceLocator;
import androidMessenger.asemannotification.AsemanNotificationService;
import androidMessenger.model.GetBaseInfoOutput;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.FragmentType;
import java.util.ArrayList;
import java.util.Collections;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.DividerCell;
import org.rbmain.ui.Cells.DrawerAddCell;
import org.rbmain.ui.Cells.DrawerUserCell;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.SessionCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class AccountsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private LinearLayout emptyLayout;
    private EmptyTextProgressView emptyView;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int rowCount;
    private TextView textView1;
    private TextView textView2;
    private ArrayList<Integer> accountNumbers = new ArrayList<>();
    private int accountsStartRow = -1;
    private int accountsEndRow = -1;
    private int accoutAddRow = -1;

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public AccountsActivity() {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "AccountsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("AllAccounts", R.string.AllAccounts));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.AccountsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    AccountsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyLayout.setGravity(17);
        this.emptyLayout.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
        this.emptyLayout.setLayoutParams(new AbsListView.LayoutParams(-1, AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()));
        TextView textView = new TextView(context);
        this.textView1 = textView;
        int i = Theme.key_windowBackgroundWhiteGrayText2;
        textView.setTextColor(Theme.getColor(i));
        this.textView1.setGravity(17);
        this.textView1.setTextSize(1, 17.0f);
        this.textView1.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.emptyLayout.addView(this.textView1, LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 0));
        TextView textView2 = new TextView(context);
        this.textView2 = textView2;
        textView2.setTextColor(Theme.getColor(i));
        this.textView2.setGravity(17);
        this.textView2.setTextSize(1, 17.0f);
        this.textView2.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.emptyLayout.addView(this.textView2, LayoutHelper.createLinear(-2, -2, 17, 0, 14, 0, 0));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1, 17));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
        this.listView.setClipToPadding(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setEmptyView(this.emptyView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.AccountsActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$0(view, i2);
            }
        });
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(3, 0) { // from class: org.rbmain.ui.AccountsActivity.2
            private RecyclerView.ViewHolder selectedViewHolder;

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
                if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
                    return false;
                }
                AccountsActivity.this.listAdapter.swapElements(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
                clearSelectedViewHolder();
                if (i2 != 0) {
                    this.selectedViewHolder = viewHolder;
                    View view = viewHolder.itemView;
                    AccountsActivity.this.listView.cancelClickRunnables(false);
                    view.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
                    if (Build.VERSION.SDK_INT >= 21) {
                        ObjectAnimator.ofFloat(view, "elevation", AndroidUtilities.dp(1.0f)).setDuration(150L).start();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                clearSelectedViewHolder();
            }

            private void clearSelectedViewHolder() {
                RecyclerView.ViewHolder viewHolder = this.selectedViewHolder;
                if (viewHolder != null) {
                    final View view = viewHolder.itemView;
                    this.selectedViewHolder = null;
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    if (Build.VERSION.SDK_INT >= 21) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "elevation", 0.0f);
                        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.AccountsActivity.2.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                view.setBackground(null);
                            }
                        });
                        objectAnimatorOfFloat.setDuration(150L).start();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i2, boolean z) {
                View view;
                View view2;
                View view3 = viewHolder.itemView;
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(AccountsActivity.this.listAdapter.getFirstAccountPosition() - 1);
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = recyclerView.findViewHolderForAdapterPosition(AccountsActivity.this.listAdapter.getLastAccountPosition() + 1);
                if ((viewHolderFindViewHolderForAdapterPosition != null && (view2 = viewHolderFindViewHolderForAdapterPosition.itemView) != null && view2.getBottom() == view3.getTop() && f2 < 0.0f) || (viewHolderFindViewHolderForAdapterPosition2 != null && (view = viewHolderFindViewHolderForAdapterPosition2.itemView) != null && view.getTop() == view3.getBottom() && f2 > 0.0f)) {
                    f2 = 0.0f;
                }
                view3.setTranslationX(f);
                view3.setTranslationY(f2);
            }
        });
        itemTouchHelper.attachToRecyclerView(this.listView);
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.AccountsActivity.3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public boolean onItemClick(View view, int i2) {
                if (!(view instanceof DrawerUserCell)) {
                    return false;
                }
                final int accountNumber = ((DrawerUserCell) view).getAccountNumber();
                if (accountNumber == ((BaseFragment) AccountsActivity.this).currentAccount || AndroidUtilities.isTablet()) {
                    itemTouchHelper.startDrag(AccountsActivity.this.listView.getChildViewHolder(view));
                    return false;
                }
                final ActionBarLayout parentLayout = AccountsActivity.this.getParentLayout();
                if (parentLayout == null) {
                    return true;
                }
                MainTabFragment mainTabFragment = new MainTabFragment(AccountsActivity.this.getDefaultTab(accountNumber)) { // from class: org.rbmain.ui.AccountsActivity.3.1
                    @Override // org.rbmain.ui.ActionBar.BaseFragment
                    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
                        super.onTransitionAnimationEnd(z, z2);
                        if (z || !z2) {
                            return;
                        }
                        parentLayout.getFrameLayoutContainer().setDrawCurrentPreviewFragmentAbove(false);
                    }

                    @Override // org.rbmain.ui.ActionBar.BaseFragment
                    protected void onPreviewOpenAnimationEnd() {
                        super.onPreviewOpenAnimationEnd();
                        parentLayout.getFrameLayoutContainer().setDrawCurrentPreviewFragmentAbove(false);
                        AccountsActivity.this.switchToAccount(accountNumber);
                    }
                };
                mainTabFragment.setCurrentAccount(accountNumber);
                parentLayout.getFrameLayoutContainer().setDrawCurrentPreviewFragmentAbove(true);
                parentLayout.presentFragmentAsPreview(mainTabFragment);
                return true;
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        if (i == this.accoutAddRow) {
            addAccount();
        } else if (view instanceof DrawerUserCell) {
            switchToAccount(((DrawerUserCell) view).getAccountNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetBaseInfoOutput.DefaultTabEnum getDefaultTab(int i) {
        String string = AppPreferences.getInstance(i).getString(AppPreferences.Key.baseInfoObject);
        GetBaseInfoOutput.DefaultTabEnum defaultTabEnum = GetBaseInfoOutput.DefaultTabEnum.Messenger;
        if (string.isEmpty()) {
            return defaultTabEnum;
        }
        try {
            GetBaseInfoOutput.DefaultTabEnum defaultTabEnum2 = ((GetBaseInfoOutput) ApplicationLoader.getGson().fromJson(string, GetBaseInfoOutput.class)).default_tab;
            return defaultTabEnum2 != null ? defaultTabEnum2 : defaultTabEnum;
        } catch (Exception unused) {
            return defaultTabEnum;
        }
    }

    protected void switchToAccount(int i) {
        AsemanNotificationService asemanNotificationService = AsemanNotificationService.instance;
        if (asemanNotificationService != null) {
            asemanNotificationService.destroyService();
        }
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity != null) {
            launchActivity.switchToAccount(i, true);
        }
    }

    private void addAccount() {
        int i = 0;
        while (true) {
            if (i >= 3) {
                i = -1;
                break;
            } else if (!ServiceLocator.isAccountLoggedIn(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            ServiceLocator.getInstance(i).initOnActivateCore();
            presentFragment(new LoginActivityAppp(i));
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        this.accountsStartRow = -1;
        this.accountsEndRow = -1;
        this.accoutAddRow = -1;
        this.rowCount = 0;
        this.rowCount = 0 + 1;
        this.accountsStartRow = 0;
        this.accountsEndRow = 0 + this.accountNumbers.size();
        this.rowCount += this.accountNumbers.size();
        if (this.accountNumbers.size() < 3) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.accoutAddRow = i;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            resetItems();
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AccountsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View dividerCell;
            if (i == 2) {
                dividerCell = new DividerCell(this.mContext);
            } else if (i == 4) {
                dividerCell = new DrawerUserCell(this.mContext);
            } else if (i == 5) {
                dividerCell = new DrawerAddCell(this.mContext);
            } else {
                dividerCell = new EmptyCell(this.mContext, AndroidUtilities.dp(8.0f));
            }
            dividerCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(dividerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 4) {
                ((DrawerUserCell) viewHolder.itemView).setAccount(((Integer) AccountsActivity.this.accountNumbers.get(i - AccountsActivity.this.accountsStartRow)).intValue());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i < AccountsActivity.this.accountsStartRow || i >= AccountsActivity.this.accountsEndRow) {
                return i == AccountsActivity.this.accoutAddRow ? 5 : 1;
            }
            return 4;
        }

        public void resetItems() {
            AccountsActivity.this.accountNumbers.clear();
            for (int i = 0; i < 3; i++) {
                if (UserConfig.getInstance(i).isClientActivated()) {
                    AccountsActivity.this.accountNumbers.add(Integer.valueOf(i));
                }
            }
            AccountsActivity.this.updateRows();
        }

        public void swapElements(int i, int i2) {
            int i3 = i - AccountsActivity.this.accountsStartRow;
            int i4 = i2 - AccountsActivity.this.accountsStartRow;
            if (i3 < 0 || i4 < 0 || i3 >= AccountsActivity.this.accountNumbers.size() || i4 >= AccountsActivity.this.accountNumbers.size()) {
                return;
            }
            UserConfig userConfig = UserConfig.getInstance(((Integer) AccountsActivity.this.accountNumbers.get(i3)).intValue());
            UserConfig userConfig2 = UserConfig.getInstance(((Integer) AccountsActivity.this.accountNumbers.get(i4)).intValue());
            int i5 = userConfig.loginTime;
            userConfig.loginTime = userConfig2.loginTime;
            userConfig2.loginTime = i5;
            userConfig.saveConfig(false);
            userConfig2.saveConfig(false);
            Collections.swap(AccountsActivity.this.accountNumbers, i3, i4);
            notifyItemMoved(i, i2);
        }

        public int getFirstAccountPosition() {
            return AccountsActivity.this.accountsStartRow;
        }

        public int getLastAccountPosition() {
            return AccountsActivity.this.accountsEndRow - 1;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, SessionCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        TextView textView = this.textView1;
        int i3 = ThemeDescription.FLAG_TEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(textView, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.textView2, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i5 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        int i6 = Theme.key_windowBackgroundWhiteGrayText3;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{SessionCell.class}, new String[]{"onlineTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SessionCell.class}, new String[]{"detailExTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        return arrayList;
    }
}
