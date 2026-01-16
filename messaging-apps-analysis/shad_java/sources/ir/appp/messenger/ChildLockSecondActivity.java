package ir.appp.messenger;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.proxy.IdStorage;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.messenger.ChildLockExceptionsActivity;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.ChildLockSettingObject;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.MessengerChildLockObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes3.dex */
public class ChildLockSecondActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int chatType;
    private ChildLockSettingObject currentChildLockSetting;
    private Set<String> currentMinus;
    private Set<String> currentPlus;
    private int currentType;
    private int detailRow;
    private ActionBarMenuItem doneItem;
    private boolean donePressed;
    private boolean enableAnimation;
    private int everybodyRow;
    private String exceptionString;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int myContactsRow;
    private int nobodyRow;
    private ContextProgressView progressView;
    private int rowCount;
    private int sectionRow;
    private Map<String, Object> settingInput;
    private int lastCheckedType = -1;
    private int shareSectionRow = -1;
    private int alwaysShareRow = -1;
    private int neverShareRow = -1;
    private int shareDetailRow = -1;

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public ChildLockSecondActivity(int i) {
        this.chatType = i;
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "ChildLockSecondActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        checkPrivacy();
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
        int i = this.chatType;
        if (i == 2) {
            this.actionBar.setTitle(LocaleController.getString(R.string.ChannelAccess));
        } else if (i == 1) {
            this.actionBar.setTitle(LocaleController.getString(R.string.GroupAccess));
        } else if (i == 0) {
            this.actionBar.setTitle(LocaleController.getString(R.string.ChatAccess));
        }
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.messenger.ChildLockSecondActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    ChildLockSecondActivity.this.finishFragment();
                    return;
                }
                if (i2 != 1 || ChildLockSecondActivity.this.getParentActivity() == null || ChildLockSecondActivity.this.donePressed) {
                    return;
                }
                if (ChildLockSecondActivity.this.settingInput != null) {
                    ChildLockSecondActivity.this.donePressed = true;
                } else {
                    ChildLockSecondActivity.this.finishFragment();
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        this.doneItem = actionBarMenuItemAddItemWithWidth;
        actionBarMenuItemAddItemWithWidth.setVisibility(4);
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        this.doneItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1.0f));
        this.progressView.setVisibility(4);
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.messenger.ChildLockSecondActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$2(view, i2);
            }
        });
        applyCurrentPrivacySettings();
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view, final int i) {
        int i2;
        Set<String> set;
        int i3 = this.nobodyRow;
        if (i == i3 || i == this.everybodyRow || i == this.myContactsRow) {
            this.exceptionString = BuildConfig.FLAVOR;
            int i4 = this.currentType;
            if (i == i3) {
                i2 = 1;
            } else if (i == this.everybodyRow) {
                i2 = 0;
            } else {
                i2 = i == this.myContactsRow ? 2 : i4;
            }
            if (i2 == i4) {
                return;
            }
            this.enableAnimation = true;
            this.lastCheckedType = i4;
            this.currentType = i2;
            ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
            this.currentChildLockSetting = childLockSettingObject;
            int i5 = this.chatType;
            if (i5 == 2) {
                int i6 = this.currentType;
                if (i6 == 0) {
                    childLockSettingObject.messengerSettingObject.channelSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Everybody;
                } else if (i6 == 1) {
                    childLockSettingObject.messengerSettingObject.channelSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Nobody;
                }
            } else if (i5 == 1) {
                int i7 = this.currentType;
                if (i7 == 0) {
                    childLockSettingObject.messengerSettingObject.groupSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Everybody;
                } else if (i7 == 1) {
                    childLockSettingObject.messengerSettingObject.groupSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Nobody;
                }
            } else if (i5 == 0) {
                int i8 = this.currentType;
                if (i8 == 0) {
                    childLockSettingObject.messengerSettingObject.chatSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Everybody;
                } else if (i8 == 1) {
                    childLockSettingObject.messengerSettingObject.chatSetting.accessLevel = MessengerChildLockObject.AccessLevelEnum.Nobody;
                }
            }
            AppPreferences.getInstance(0).setChildLockSettingObject(this.currentChildLockSetting);
            updateRows();
            return;
        }
        int i9 = this.neverShareRow;
        if (i == i9 || i == this.alwaysShareRow) {
            if (i == i9) {
                set = this.currentMinus;
            } else {
                set = this.currentPlus;
            }
            if (set.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("onlySelect", true);
                bundle.putBoolean("checkCanWrite", false);
                int i10 = this.chatType;
                if (i10 == 1) {
                    bundle.putInt("dialogsType", 6);
                } else if (i10 == 2) {
                    bundle.putInt("dialogsType", 5);
                } else {
                    bundle.putInt("dialogsType", 4);
                }
                DialogsActivity dialogsActivity = new DialogsActivity(bundle);
                dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.appp.messenger.ChildLockSecondActivity$$ExternalSyntheticLambda2
                    @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                    public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                        this.f$0.lambda$createView$0(i, dialogsActivity2, arrayList, charSequence, z);
                    }
                });
                presentFragment(dialogsActivity);
                return;
            }
            ChildLockExceptionsActivity childLockExceptionsActivity = new ChildLockExceptionsActivity(set, this.chatType, i == this.alwaysShareRow);
            childLockExceptionsActivity.setDelegate(new ChildLockExceptionsActivity.PrivacyActivityDelegate() { // from class: ir.appp.messenger.ChildLockSecondActivity$$ExternalSyntheticLambda0
                @Override // ir.appp.messenger.ChildLockExceptionsActivity.PrivacyActivityDelegate
                public final void didUpdateUserList(ArrayList arrayList, boolean z) {
                    this.f$0.lambda$createView$1(i, arrayList, z);
                }
            });
            presentFragment(childLockExceptionsActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(int i, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        dialogsActivity.finishFragment();
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (jLongValue != 0) {
                hashSet.add(IdStorage.getInstance().getDialogId(jLongValue));
            }
        }
        if (i == this.neverShareRow) {
            this.currentMinus.clear();
            this.currentMinus.addAll(hashSet);
            Iterator<String> it2 = this.currentMinus.iterator();
            while (it2.hasNext()) {
                this.currentPlus.remove(it2.next());
            }
        } else {
            this.currentPlus.clear();
            this.currentPlus.addAll(hashSet);
            Iterator<String> it3 = this.currentPlus.iterator();
            while (it3.hasNext()) {
                this.currentMinus.remove(it3.next());
            }
        }
        this.exceptionString = BuildConfig.FLAVOR;
        AppPreferences.getInstance(0).setChildLockSettingObject(this.currentChildLockSetting);
        this.listAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(int i, ArrayList arrayList, boolean z) {
        if (i == this.neverShareRow) {
            this.currentMinus.clear();
            this.currentMinus.addAll(arrayList);
            if (z) {
                Iterator<String> it = this.currentMinus.iterator();
                while (it.hasNext()) {
                    this.currentPlus.remove(it.next());
                }
            }
        } else {
            this.currentPlus.clear();
            this.currentPlus.addAll(arrayList);
            if (z) {
                Iterator<String> it2 = this.currentPlus.iterator();
                while (it2.hasNext()) {
                    this.currentMinus.remove(it2.next());
                }
            }
        }
        this.exceptionString = BuildConfig.FLAVOR;
        this.listAdapter.notifyDataSetChanged();
    }

    private void applyCurrentPrivacySettings() {
        ChildLockSettingObject childLockSettingObject = AppPreferences.getInstance(0).getChildLockSettingObject();
        this.currentChildLockSetting = childLockSettingObject;
        if (childLockSettingObject == null) {
            return;
        }
        this.exceptionString = BuildConfig.FLAVOR;
        int i = this.chatType;
        if (i == 2) {
            MessengerChildLockObject messengerChildLockObject = childLockSettingObject.messengerSettingObject.channelSetting;
            MessengerChildLockObject.AccessLevelEnum accessLevelEnum = messengerChildLockObject.accessLevel;
            if (accessLevelEnum == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                this.currentType = 0;
            } else if (accessLevelEnum == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                this.currentType = 1;
            }
            this.currentMinus = messengerChildLockObject.exceptionsMines;
            this.currentPlus = messengerChildLockObject.exceptionsPlus;
            return;
        }
        if (i == 1) {
            MessengerChildLockObject messengerChildLockObject2 = childLockSettingObject.messengerSettingObject.groupSetting;
            MessengerChildLockObject.AccessLevelEnum accessLevelEnum2 = messengerChildLockObject2.accessLevel;
            if (accessLevelEnum2 == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                this.currentType = 0;
            } else if (accessLevelEnum2 == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                this.currentType = 1;
            }
            this.currentMinus = messengerChildLockObject2.exceptionsMines;
            this.currentPlus = messengerChildLockObject2.exceptionsPlus;
            return;
        }
        if (i == 0) {
            MessengerChildLockObject messengerChildLockObject3 = childLockSettingObject.messengerSettingObject.chatSetting;
            MessengerChildLockObject.AccessLevelEnum accessLevelEnum3 = messengerChildLockObject3.accessLevel;
            if (accessLevelEnum3 == MessengerChildLockObject.AccessLevelEnum.Everybody) {
                this.currentType = 0;
            } else if (accessLevelEnum3 == MessengerChildLockObject.AccessLevelEnum.Nobody) {
                this.currentType = 1;
            }
            this.currentMinus = messengerChildLockObject3.exceptionsMines;
            this.currentPlus = messengerChildLockObject3.exceptionsPlus;
        }
    }

    private void checkPrivacy() {
        updateRows();
    }

    private void updateRows() {
        this.myContactsRow = -1;
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.sectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.everybodyRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.nobodyRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.detailRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.shareSectionRow = i4;
        int i6 = this.currentType;
        if (i6 == 1 || i6 == 2) {
            this.rowCount = i5 + 1;
            this.alwaysShareRow = i5;
        } else {
            this.alwaysShareRow = -1;
        }
        if (i6 == 0 || i6 == 2) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            this.neverShareRow = i7;
        } else {
            this.neverShareRow = -1;
        }
        int i8 = this.rowCount;
        this.rowCount = i8 + 1;
        this.shareDetailRow = i8;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.lastCheckedType = -1;
        this.enableAnimation = false;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == ChildLockSecondActivity.this.nobodyRow || adapterPosition == ChildLockSecondActivity.this.everybodyRow || adapterPosition == ChildLockSecondActivity.this.myContactsRow || adapterPosition == ChildLockSecondActivity.this.neverShareRow || adapterPosition == ChildLockSecondActivity.this.alwaysShareRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChildLockSecondActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            if (i == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                textSettingsCell = new RadioCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r7, int r8) {
            /*
                Method dump skipped, instructions count: 541
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.appp.messenger.ChildLockSecondActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ChildLockSecondActivity.this.alwaysShareRow || i == ChildLockSecondActivity.this.neverShareRow) {
                return 0;
            }
            if (i == ChildLockSecondActivity.this.shareDetailRow || i == ChildLockSecondActivity.this.detailRow) {
                return 1;
            }
            if (i == ChildLockSecondActivity.this.sectionRow || i == ChildLockSecondActivity.this.shareSectionRow) {
                return 2;
            }
            return (i == ChildLockSecondActivity.this.everybodyRow || i == ChildLockSecondActivity.this.myContactsRow || i == ChildLockSecondActivity.this.nobodyRow) ? 3 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String createExceptionString(Set<String> set) {
        if (set.size() < 1) {
            this.exceptionString = LocaleController.getString(R.string.AddExceptions);
        } else if (this.exceptionString.isEmpty()) {
            int i = this.chatType;
            if (i == 0) {
                this.exceptionString = LocaleController.formatPluralString("Users", set.size());
            } else if (i == 1) {
                this.exceptionString = LocaleController.formatPluralString("Groups", set.size());
            } else if (i == 2) {
                this.exceptionString = LocaleController.formatPluralString("Channels", set.size());
            }
        }
        return this.exceptionString;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, RadioCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackground));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackgroundChecked));
        return arrayList;
    }
}
