package ir.eitaa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LogoutActivity extends BaseFragment {
    private int addAccountRow;
    private int alternativeHeaderRow;
    private int alternativeSectionRow;
    private int cacheRow;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int logoutRow;
    private int logoutSectionRow = -1;
    private int passcodeRow;
    private int rowCount;
    private int supportRow;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        this.rowCount = 0;
        this.rowCount = 0 + 1;
        this.alternativeHeaderRow = 0;
        if (UserConfig.getActivatedAccountsCount() < 3) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.addAccountRow = i;
        } else {
            this.addAccountRow = -1;
        }
        if (SharedConfig.passcodeHash.length() <= 0) {
            int i2 = this.rowCount;
            this.rowCount = i2 + 1;
            this.passcodeRow = i2;
        } else {
            this.passcodeRow = -1;
        }
        int i3 = this.rowCount;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.cacheRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.supportRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.alternativeSectionRow = i5;
        this.rowCount = i6 + 1;
        this.logoutRow = i6;
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("LogOutTitle", R.string.LogOutTitle));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.LogoutActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    LogoutActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$LogoutActivity$ZTBp69Qgi8qqwIkC1mUT1cPPguk
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$1$LogoutActivity(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$LogoutActivity(View view, int i, float f, float f2) {
        int i2 = 0;
        int i3 = -1;
        if (i == this.addAccountRow) {
            while (true) {
                if (i2 >= 3) {
                    break;
                }
                if (!UserConfig.getInstance(i2).isClientActivated()) {
                    i3 = i2;
                    break;
                }
                i2++;
            }
            if (i3 >= 0) {
                presentFragment(new LoginActivity(i3));
                return;
            }
            return;
        }
        if (i == this.passcodeRow) {
            presentFragment(new PasscodeActivity(0));
            return;
        }
        if (i == this.cacheRow) {
            presentFragment(new CacheControlActivity());
            return;
        }
        if (i == this.supportRow) {
            Browser.openUrl(getParentActivity(), "https://eitaa.com/Eitaa_FAQ/3");
            return;
        }
        if (i != this.logoutRow || getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        getUserConfig();
        builder.setMessage(LocaleController.getString("AreYouSureLogout", R.string.AreYouSureLogout));
        builder.setTitle(LocaleController.getString("LogOut", R.string.LogOut));
        builder.setPositiveButton(LocaleController.getString("LogOut", R.string.LogOut), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LogoutActivity$tiBCVh_emsCuaLADz5BGFD2TVB8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) throws InterruptedException {
                this.f$0.lambda$createView$0$LogoutActivity(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$LogoutActivity(DialogInterface dialogInterface, int i) throws InterruptedException {
        MessagesController.getInstance(this.currentAccount).performLogout(1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LogoutActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position == LogoutActivity.this.alternativeHeaderRow) {
                    headerCell.setText(LocaleController.getString("AlternativeOptions", R.string.AlternativeOptions));
                    return;
                }
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType == 3) {
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    if (position == LogoutActivity.this.logoutRow) {
                        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText5"));
                        textSettingsCell.setText(LocaleController.getString("LogOutTitle", R.string.LogOutTitle), false);
                        return;
                    }
                    return;
                }
                if (itemViewType != 4) {
                    return;
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == LogoutActivity.this.logoutSectionRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("LogOutInfo", R.string.LogOutInfo));
                    return;
                }
                return;
            }
            TextDetailSettingsCell textDetailSettingsCell = (TextDetailSettingsCell) holder.itemView;
            if (position != LogoutActivity.this.addAccountRow) {
                if (position != LogoutActivity.this.passcodeRow) {
                    if (position != LogoutActivity.this.cacheRow) {
                        if (position == LogoutActivity.this.supportRow) {
                            textDetailSettingsCell.setTextAndValueAndIcon(LocaleController.getString("ContactSupport", R.string.ContactSupport), LocaleController.getString("ContactSupportInfo", R.string.ContactSupportInfo), R.drawable.menu_support, false);
                            return;
                        }
                        return;
                    }
                    textDetailSettingsCell.setTextAndValueAndIcon(LocaleController.getString("ClearCache", R.string.ClearCache), LocaleController.getString("ClearCacheInfo", R.string.ClearCacheInfo), R.drawable.menu_clearcache, true);
                    return;
                }
                textDetailSettingsCell.setTextAndValueAndIcon(LocaleController.getString("SetPasscode", R.string.SetPasscode), LocaleController.getString("SetPasscodeInfo", R.string.SetPasscodeInfo), R.drawable.menu_passcode, true);
                return;
            }
            textDetailSettingsCell.setTextAndValueAndIcon(LocaleController.getString("AddAnotherAccount", R.string.AddAnotherAccount), LocaleController.getString("AddAnotherAccountInfo", R.string.AddAnotherAccountInfo), R.drawable.actions_addmember2, true);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == LogoutActivity.this.addAccountRow || adapterPosition == LogoutActivity.this.passcodeRow || adapterPosition == LogoutActivity.this.cacheRow || adapterPosition == LogoutActivity.this.supportRow || adapterPosition == LogoutActivity.this.logoutRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            View shadowSectionCell;
            if (i == 0) {
                FrameLayout headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = headerCell;
            } else if (i == 1) {
                TextDetailSettingsCell textDetailSettingsCell = new TextDetailSettingsCell(this.mContext);
                textDetailSettingsCell.setMultilineDetail(true);
                textDetailSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = textDetailSettingsCell;
            } else {
                if (i == 2) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                } else if (i == 3) {
                    FrameLayout textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    frameLayout = textSettingsCell;
                } else {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                    shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                }
                shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return new RecyclerListView.Holder(shadowSectionCell);
            }
            shadowSectionCell = frameLayout;
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == LogoutActivity.this.alternativeHeaderRow) {
                return 0;
            }
            if (position == LogoutActivity.this.addAccountRow || position == LogoutActivity.this.passcodeRow || position == LogoutActivity.this.cacheRow || position == LogoutActivity.this.supportRow) {
                return 1;
            }
            if (position == LogoutActivity.this.alternativeSectionRow) {
                return 2;
            }
            return position == LogoutActivity.this.logoutRow ? 3 : 4;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, TextDetailSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        return arrayList;
    }
}
