package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ContactsActivity;
import ir.eitaa.ui.GroupCreateActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class PrivacyUsersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, ContactsActivity.ContactsActivityDelegate {
    private int blockUserDetailRow;
    private int blockUserRow;
    private boolean blockedUsersActivity;
    private int currentType;
    private PrivacyActivityDelegate delegate;
    private EmptyTextProgressView emptyView;
    private boolean isAlwaysShare;
    private boolean isGroup;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private int rowCount;
    private ArrayList<Long> uidArray;
    private int usersDetailRow;
    private int usersEndRow;
    private int usersHeaderRow;
    private int usersStartRow;

    public interface PrivacyActivityDelegate {
        void didUpdateUserList(ArrayList<Long> ids, boolean added);
    }

    public PrivacyUsersActivity() {
        this.currentType = 1;
        this.blockedUsersActivity = true;
    }

    public PrivacyUsersActivity(int type, ArrayList<Long> users, boolean group, boolean always) {
        this.uidArray = users;
        this.isAlwaysShare = always;
        this.isGroup = group;
        this.blockedUsersActivity = false;
        this.currentType = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
        if (this.currentType == 1) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.blockedUsersDidLoad);
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        if (this.currentType == 1) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.blockedUsersDidLoad);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i = this.currentType;
        if (i == 1) {
            this.actionBar.setTitle(LocaleController.getString("BlockedUsers", R.string.BlockedUsers));
        } else if (i == 2) {
            if (this.isAlwaysShare) {
                this.actionBar.setTitle(LocaleController.getString("FilterAlwaysShow", R.string.FilterAlwaysShow));
            } else {
                this.actionBar.setTitle(LocaleController.getString("FilterNeverShow", R.string.FilterNeverShow));
            }
        } else if (this.isGroup) {
            if (this.isAlwaysShare) {
                this.actionBar.setTitle(LocaleController.getString("AlwaysAllow", R.string.AlwaysAllow));
            } else {
                this.actionBar.setTitle(LocaleController.getString("NeverAllow", R.string.NeverAllow));
            }
        } else if (this.isAlwaysShare) {
            this.actionBar.setTitle(LocaleController.getString("AlwaysShareWithTitle", R.string.AlwaysShareWithTitle));
        } else {
            this.actionBar.setTitle(LocaleController.getString("NeverShareWithTitle", R.string.NeverShareWithTitle));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PrivacyUsersActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    PrivacyUsersActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        if (this.currentType == 1) {
            emptyTextProgressView.setText(LocaleController.getString("NoBlocked", R.string.NoBlocked));
        } else {
            emptyTextProgressView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
        }
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$7BbbvJ0bGi2uqqRDEgfytIas36g
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$1$PrivacyUsersActivity(view, i2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$9LyeyKAg2kGtB470OcBMa05x_7I
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$createView$2$PrivacyUsersActivity(view, i2);
            }
        });
        if (this.currentType == 1) {
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.PrivacyUsersActivity.2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    if (PrivacyUsersActivity.this.getMessagesController().blockedEndReached) {
                        return;
                    }
                    int iAbs = Math.abs(PrivacyUsersActivity.this.layoutManager.findLastVisibleItemPosition() - PrivacyUsersActivity.this.layoutManager.findFirstVisibleItemPosition()) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    if (iAbs <= 0 || PrivacyUsersActivity.this.layoutManager.findLastVisibleItemPosition() < itemCount - 10) {
                        return;
                    }
                    PrivacyUsersActivity.this.getMessagesController().getBlockedPeers(false);
                }
            });
            if (getMessagesController().totalBlockedCount < 0) {
                this.emptyView.showProgress();
            } else {
                this.emptyView.showTextView();
            }
        }
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$PrivacyUsersActivity(View view, int i) {
        if (i == this.blockUserRow) {
            if (this.currentType == 1) {
                presentFragment(new DialogOrContactPickerActivity());
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean(this.isAlwaysShare ? "isAlwaysShare" : "isNeverShare", true);
            if (this.isGroup) {
                bundle.putInt("chatAddType", 1);
            } else if (this.currentType == 2) {
                bundle.putInt("chatAddType", 2);
            }
            GroupCreateActivity groupCreateActivity = new GroupCreateActivity(bundle);
            groupCreateActivity.setDelegate(new GroupCreateActivity.GroupCreateActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$ykuOdxFHNJ3D2Ok9dp0szmwspRQ
                @Override // ir.eitaa.ui.GroupCreateActivity.GroupCreateActivityDelegate
                public final void didSelectUsers(ArrayList arrayList) {
                    this.f$0.lambda$createView$0$PrivacyUsersActivity(arrayList);
                }
            });
            presentFragment(groupCreateActivity);
            return;
        }
        if (i < this.usersStartRow || i >= this.usersEndRow) {
            return;
        }
        if (this.currentType == 1) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("user_id", getMessagesController().blockePeers.keyAt(i - this.usersStartRow));
            presentFragment(new ProfileActivity(bundle2));
        } else {
            Bundle bundle3 = new Bundle();
            long jLongValue = this.uidArray.get(i - this.usersStartRow).longValue();
            if (DialogObject.isUserDialog(jLongValue)) {
                bundle3.putLong("user_id", jLongValue);
            } else {
                bundle3.putLong("chat_id", -jLongValue);
            }
            presentFragment(new ProfileActivity(bundle3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$PrivacyUsersActivity(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (!this.uidArray.contains(l)) {
                this.uidArray.add(l);
            }
        }
        updateRows();
        PrivacyActivityDelegate privacyActivityDelegate = this.delegate;
        if (privacyActivityDelegate != null) {
            privacyActivityDelegate.didUpdateUserList(this.uidArray, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$PrivacyUsersActivity(View view, int i) {
        int i2 = this.usersStartRow;
        if (i < i2 || i >= this.usersEndRow) {
            return false;
        }
        if (this.currentType == 1) {
            showUnblockAlert(Long.valueOf(getMessagesController().blockePeers.keyAt(i - this.usersStartRow)));
        } else {
            showUnblockAlert(this.uidArray.get(i - i2));
        }
        return true;
    }

    public void setDelegate(PrivacyActivityDelegate privacyActivityDelegate) {
        this.delegate = privacyActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnblockAlert(final Long uid) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setItems(this.currentType == 1 ? new CharSequence[]{LocaleController.getString("Unblock", R.string.Unblock)} : new CharSequence[]{LocaleController.getString("Delete", R.string.Delete)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$DxuzlGJECsfxj9tCff_SX5-q7Ws
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showUnblockAlert$3$PrivacyUsersActivity(uid, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showUnblockAlert$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showUnblockAlert$3$PrivacyUsersActivity(Long l, DialogInterface dialogInterface, int i) {
        if (i == 0) {
            if (this.currentType == 1) {
                getMessagesController().unblockPeer(l.longValue());
                return;
            }
            this.uidArray.remove(l);
            updateRows();
            PrivacyActivityDelegate privacyActivityDelegate = this.delegate;
            if (privacyActivityDelegate != null) {
                privacyActivityDelegate.didUpdateUserList(this.uidArray, false);
            }
            if (this.uidArray.isEmpty()) {
                finishFragment();
            }
        }
    }

    private void updateRows() {
        int size;
        this.rowCount = 0;
        if (!this.blockedUsersActivity || getMessagesController().totalBlockedCount >= 0) {
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.blockUserRow = i;
            this.rowCount = i2 + 1;
            this.blockUserDetailRow = i2;
            if (this.currentType == 1) {
                size = getMessagesController().blockePeers.size();
            } else {
                size = this.uidArray.size();
            }
            if (size != 0) {
                int i3 = this.rowCount;
                int i4 = i3 + 1;
                this.rowCount = i4;
                this.usersHeaderRow = i3;
                this.usersStartRow = i4;
                int i5 = i4 + size;
                this.rowCount = i5;
                this.usersEndRow = i5;
                this.rowCount = i5 + 1;
                this.usersDetailRow = i5;
            } else {
                this.usersHeaderRow = -1;
                this.usersStartRow = -1;
                this.usersEndRow = -1;
                this.usersDetailRow = -1;
            }
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) args[0]).intValue();
            if ((MessagesController.UPDATE_MASK_AVATAR & iIntValue) == 0 && (MessagesController.UPDATE_MASK_NAME & iIntValue) == 0) {
                return;
            }
            updateVisibleRows(iIntValue);
            return;
        }
        if (id == NotificationCenter.blockedUsersDidLoad) {
            this.emptyView.showTextView();
            updateRows();
        }
    }

    private void updateVisibleRows(int mask) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof ManageChatUserCell) {
                ((ManageChatUserCell) childAt).update(mask);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ContactsActivity.ContactsActivityDelegate
    public void didSelectContact(final TLRPC$User user, String param, ContactsActivity activity) {
        if (user == null) {
            return;
        }
        getMessagesController().blockPeer(user.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacyUsersActivity.this.rowCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0$PrivacyUsersActivity$ListAdapter(ManageChatUserCell manageChatUserCell, boolean z) {
            if (!z) {
                return true;
            }
            PrivacyUsersActivity.this.showUnblockAlert((Long) manageChatUserCell.getTag());
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout textInfoPrivacyCell;
            if (i == 0) {
                ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 7, 6, true);
                manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$ListAdapter$qAklS-KVaWj31kj2GXZg7FfabkQ
                    @Override // ir.eitaa.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                    public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                        return this.f$0.lambda$onCreateViewHolder$0$PrivacyUsersActivity$ListAdapter(manageChatUserCell2, z);
                    }
                });
                textInfoPrivacyCell = manageChatUserCell;
            } else if (i == 1) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                FrameLayout manageChatTextCell = new ManageChatTextCell(this.mContext);
                manageChatTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                textInfoPrivacyCell = manageChatTextCell;
            } else {
                HeaderCell headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 21, 11, false);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                headerCell.setHeight(43);
                textInfoPrivacyCell = headerCell;
            }
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            String string2;
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position == PrivacyUsersActivity.this.blockUserDetailRow) {
                        if (PrivacyUsersActivity.this.currentType == 1) {
                            textInfoPrivacyCell.setText(LocaleController.getString("BlockedUsersInfo", R.string.BlockedUsersInfo));
                        } else {
                            textInfoPrivacyCell.setText(null);
                        }
                        if (PrivacyUsersActivity.this.usersStartRow == -1) {
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            return;
                        } else {
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                            return;
                        }
                    }
                    if (position == PrivacyUsersActivity.this.usersDetailRow) {
                        textInfoPrivacyCell.setText("");
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        return;
                    }
                    return;
                }
                if (itemViewType == 2) {
                    ManageChatTextCell manageChatTextCell = (ManageChatTextCell) holder.itemView;
                    manageChatTextCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
                    if (PrivacyUsersActivity.this.currentType == 1) {
                        manageChatTextCell.setText(LocaleController.getString("BlockUser", R.string.BlockUser), null, R.drawable.actions_addmember2, false);
                        return;
                    } else {
                        manageChatTextCell.setText(LocaleController.getString("UserRestrictionsInviteUsers", R.string.UserRestrictionsInviteUsers), null, R.drawable.actions_addmember2, false);
                        return;
                    }
                }
                if (itemViewType != 3) {
                    return;
                }
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position == PrivacyUsersActivity.this.usersHeaderRow) {
                    if (PrivacyUsersActivity.this.currentType == 1) {
                        headerCell.setText(LocaleController.formatPluralString("BlockedUsersCount", PrivacyUsersActivity.this.getMessagesController().totalBlockedCount));
                        return;
                    } else {
                        headerCell.setText(LocaleController.getString("PrivacyExceptions", R.string.PrivacyExceptions));
                        return;
                    }
                }
                return;
            }
            ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
            long jKeyAt = PrivacyUsersActivity.this.currentType == 1 ? PrivacyUsersActivity.this.getMessagesController().blockePeers.keyAt(position - PrivacyUsersActivity.this.usersStartRow) : ((Long) PrivacyUsersActivity.this.uidArray.get(position - PrivacyUsersActivity.this.usersStartRow)).longValue();
            manageChatUserCell.setTag(Long.valueOf(jKeyAt));
            if (jKeyAt > 0) {
                TLRPC$User user = PrivacyUsersActivity.this.getMessagesController().getUser(Long.valueOf(jKeyAt));
                if (user != null) {
                    if (user.bot) {
                        string2 = LocaleController.getString("Bot", R.string.Bot).substring(0, 1).toUpperCase() + LocaleController.getString("Bot", R.string.Bot).substring(1);
                    } else {
                        String str = user.phone;
                        if (str != null && str.length() != 0) {
                            string2 = PhoneFormat.getInstance().format("+" + user.phone);
                        } else {
                            string2 = LocaleController.getString("NumberUnknown", R.string.NumberUnknown);
                        }
                    }
                    manageChatUserCell.setData(user, null, string2, position != PrivacyUsersActivity.this.usersEndRow - 1);
                    return;
                }
                return;
            }
            TLRPC$Chat chat = PrivacyUsersActivity.this.getMessagesController().getChat(Long.valueOf(-jKeyAt));
            if (chat != null) {
                int i = chat.participants_count;
                if (i != 0) {
                    string = LocaleController.formatPluralString("Members", i);
                } else if (chat.has_geo) {
                    string = LocaleController.getString("MegaLocation", R.string.MegaLocation);
                } else if (TextUtils.isEmpty(chat.username)) {
                    string = LocaleController.getString("MegaPrivate", R.string.MegaPrivate);
                } else {
                    string = LocaleController.getString("MegaPublic", R.string.MegaPublic);
                }
                manageChatUserCell.setData(chat, null, string, position != PrivacyUsersActivity.this.usersEndRow - 1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == PrivacyUsersActivity.this.usersHeaderRow) {
                return 3;
            }
            if (position == PrivacyUsersActivity.this.blockUserRow) {
                return 2;
            }
            return (position == PrivacyUsersActivity.this.blockUserDetailRow || position == PrivacyUsersActivity.this.usersDetailRow) ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacyUsersActivity$0UozhpFReHO9O1ADBM3Fx8rouNo
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$4$PrivacyUsersActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ManageChatUserCell.class, ManageChatTextCell.class, HeaderCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$4$PrivacyUsersActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ManageChatUserCell) {
                    ((ManageChatUserCell) childAt).update(0);
                }
            }
        }
    }
}
