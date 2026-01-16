package ir.appp.messenger;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.ChatConverter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatType;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.FragmentType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ManageChatTextCell;
import org.rbmain.ui.Cells.ManageChatUserCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.ContactsActivity;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes3.dex */
public class ChildLockExceptionsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, ContactsActivity.ContactsActivityDelegate {
    private int blockUserDetailRow;
    private int blockUserRow;
    private boolean blockedUsersActivity;
    private int chatType;
    private PrivacyActivityDelegate delegate;
    private EmptyTextProgressView emptyView;
    Set<String> initData;
    private boolean isAlwaysShare;
    private boolean isGroup;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private int rowCount;
    private int usersDetailRow;
    private int usersEndRow;
    private int usersHeaderRow;
    private int usersStartRow;
    private ArrayList<String> uidArray = new ArrayList<>();
    private ArrayList<TLRPC$User> usersArray = new ArrayList<>();
    private ArrayList<TLObject> infoArray = new ArrayList<>();

    public interface PrivacyActivityDelegate {
        void didUpdateUserList(ArrayList<String> arrayList, boolean z);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    @Override // org.rbmain.ui.ContactsActivity.ContactsActivityDelegate
    public void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity) {
    }

    public ChildLockExceptionsActivity(Set<String> set, int i, boolean z) {
        this.initData = set;
        this.chatType = i;
        this.isAlwaysShare = z;
        boolean z2 = true;
        if (i != 1 && i != 2) {
            z2 = false;
        }
        this.isGroup = z2;
        this.blockedUsersActivity = false;
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "ChildLockExceptionsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
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
        if (!this.blockedUsersActivity) {
            if (this.isGroup) {
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
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.messenger.ChildLockExceptionsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ChildLockExceptionsActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        if (!this.blockedUsersActivity) {
            emptyTextProgressView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
        }
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$$ExternalSyntheticLambda2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$1(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$2(view, i);
            }
        });
        updateRows();
        loadData(this.initData, false);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view, int i) {
        if (i == this.blockUserRow) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putBoolean("checkCanWrite", false);
            int i2 = this.chatType;
            if (i2 == 1) {
                bundle.putInt("dialogsType", 6);
            } else if (i2 == 2) {
                bundle.putInt("dialogsType", 5);
            } else {
                bundle.putInt("dialogsType", 4);
            }
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$createView$0(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            presentFragment(dialogsActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        boolean z2 = false;
        String dialogId = IdStorage.getInstance().getDialogId(((Long) arrayList.get(0)).longValue());
        Iterator<String> it = this.uidArray.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(dialogId)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            loadData(dialogId, true);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$2(View view, int i) {
        int i2 = this.usersStartRow;
        if (i < i2 || i >= this.usersEndRow) {
            return false;
        }
        showUnblockAlert(this.uidArray.get(i - i2));
        return true;
    }

    private void loadData(String str, boolean z) {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        loadData(hashSet, z);
    }

    private void loadData(Set<String> set, final boolean z) {
        PrivacyActivityDelegate privacyActivityDelegate;
        ChatType chatType;
        if (!z) {
            this.uidArray.clear();
            this.usersArray.clear();
            this.infoArray.clear();
        }
        for (final String str : set) {
            int i = this.chatType;
            if (i == 0) {
                int iGenerateDialogId = (int) IdStorage.getInstance().generateDialogId(str);
                TLRPC$User user = getMessagesController().getUser(Integer.valueOf(iGenerateDialogId));
                if (user == null) {
                    user = new TLRPC$TL_user();
                    user.id = iGenerateDialogId;
                    user.first_name = "بدون نام";
                }
                this.usersArray.add(user);
                this.uidArray.add(str);
                updateRows();
                if (z && (privacyActivityDelegate = this.delegate) != null) {
                    privacyActivityDelegate.didUpdateUserList(this.uidArray, true);
                }
            } else if (i == 1 || i == 2) {
                if (i == 1) {
                    chatType = ChatType.Group;
                } else if (i == 2) {
                    chatType = ChatType.Channel;
                } else {
                    chatType = ChatType.Bot;
                }
                final int dialogId = (int) ChatConverter.getDialogId(str, chatType);
                getDialogsProxy().loadObjectInfo(str, chatType, false, new RequestDelegate() { // from class: ir.appp.messenger.ChildLockExceptionsActivity.2
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        if (dialogId > 0) {
                            ChildLockExceptionsActivity.this.getMessagesController().getUser(Integer.valueOf(dialogId));
                        } else {
                            ChildLockExceptionsActivity.this.getMessagesController().getUser(Integer.valueOf(-dialogId));
                        }
                        ChildLockExceptionsActivity.this.infoArray.add(null);
                        ChildLockExceptionsActivity.this.uidArray.add(str);
                        ChildLockExceptionsActivity.this.updateRows();
                        if (!z || ChildLockExceptionsActivity.this.delegate == null) {
                            return;
                        }
                        ChildLockExceptionsActivity.this.delegate.didUpdateUserList(ChildLockExceptionsActivity.this.uidArray, true);
                    }
                });
            }
        }
    }

    public void setDelegate(PrivacyActivityDelegate privacyActivityDelegate) {
        this.delegate = privacyActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnblockAlert(final String str) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        CharSequence[] charSequenceArr = new CharSequence[0];
        if (!this.blockedUsersActivity) {
            charSequenceArr = new CharSequence[]{LocaleController.getString("Delete", R.string.Delete)};
        }
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showUnblockAlert$3(str, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUnblockAlert$3(String str, DialogInterface dialogInterface, int i) {
        if (i != 0 || this.blockedUsersActivity) {
            return;
        }
        int iIndexOf = this.uidArray.indexOf(str);
        int i2 = this.chatType;
        if (i2 == 0) {
            this.usersArray.remove(iIndexOf);
        } else if (i2 == 1 || i2 == 2) {
            this.infoArray.remove(iIndexOf);
        }
        this.uidArray.remove(iIndexOf);
        updateRows();
        PrivacyActivityDelegate privacyActivityDelegate = this.delegate;
        if (privacyActivityDelegate != null) {
            privacyActivityDelegate.didUpdateUserList(this.uidArray, false);
        }
        if (this.uidArray.isEmpty()) {
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        int size = 0;
        this.rowCount = 0;
        boolean z = this.blockedUsersActivity;
        if (!z) {
            int i = 0 + 1;
            this.rowCount = i;
            this.blockUserRow = 0;
            this.rowCount = i + 1;
            this.blockUserDetailRow = i;
            if (!z) {
                int i2 = this.chatType;
                if (i2 == 0) {
                    size = this.usersArray.size();
                } else if (i2 == 1 || i2 == 2) {
                    size = this.infoArray.size();
                }
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChildLockExceptionsActivity.this.rowCount;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0(ManageChatUserCell manageChatUserCell, boolean z) {
            if (!z) {
                return true;
            }
            ChildLockExceptionsActivity.this.showUnblockAlert((String) manageChatUserCell.getTag());
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout textInfoPrivacyCell;
            if (i == 0) {
                ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 7, 6, true);
                manageChatUserCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                manageChatUserCell.setDelegate(new ManageChatUserCell.ManageChatUserCellDelegate() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$ListAdapter$$ExternalSyntheticLambda0
                    @Override // org.rbmain.ui.Cells.ManageChatUserCell.ManageChatUserCellDelegate
                    public final boolean onOptionsButtonCheck(ManageChatUserCell manageChatUserCell2, boolean z) {
                        return this.f$0.lambda$onCreateViewHolder$0(manageChatUserCell2, z);
                    }
                });
                textInfoPrivacyCell = manageChatUserCell;
            } else if (i == 1) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                FrameLayout manageChatTextCell = new ManageChatTextCell(this.mContext);
                manageChatTextCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                textInfoPrivacyCell = manageChatTextCell;
            } else {
                HeaderCell headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                headerCell.setHeight(43);
                textInfoPrivacyCell = headerCell;
            }
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            String string = BuildConfig.FLAVOR;
            if (itemViewType == 0) {
                ManageChatUserCell manageChatUserCell = (ManageChatUserCell) viewHolder.itemView;
                String str = ChildLockExceptionsActivity.this.blockedUsersActivity ? BuildConfig.FLAVOR : (String) ChildLockExceptionsActivity.this.uidArray.get(i - ChildLockExceptionsActivity.this.usersStartRow);
                manageChatUserCell.setTag(str);
                if (str != null) {
                    if (ChildLockExceptionsActivity.this.chatType == 0) {
                        TLRPC$User tLRPC$User = (TLRPC$User) ChildLockExceptionsActivity.this.usersArray.get(i - ChildLockExceptionsActivity.this.usersStartRow);
                        if (tLRPC$User != null) {
                            String str2 = tLRPC$User.phone;
                            if (str2 != null && str2.length() != 0) {
                                string = tLRPC$User.phone;
                            }
                            manageChatUserCell.setData(tLRPC$User, null, string, i != ChildLockExceptionsActivity.this.usersEndRow - 1);
                            return;
                        }
                        return;
                    }
                    if (ChildLockExceptionsActivity.this.chatType == 1 || ChildLockExceptionsActivity.this.chatType == 2) {
                        TLObject tLObject = (TLObject) ChildLockExceptionsActivity.this.infoArray.get(i - ChildLockExceptionsActivity.this.usersStartRow);
                        if (tLObject instanceof TLRPC$TL_channel) {
                            int i2 = ((TLRPC$TL_channel) tLObject).participants_count;
                            manageChatUserCell.setData(tLObject, null, i2 != 0 ? LocaleController.formatPluralString("Members", i2) : null, i != ChildLockExceptionsActivity.this.usersEndRow - 1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == ChildLockExceptionsActivity.this.blockUserDetailRow) {
                    if (!ChildLockExceptionsActivity.this.blockedUsersActivity) {
                        textInfoPrivacyCell.setText(null);
                    }
                    if (ChildLockExceptionsActivity.this.usersStartRow == -1) {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        return;
                    } else {
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        return;
                    }
                }
                if (i == ChildLockExceptionsActivity.this.usersDetailRow) {
                    textInfoPrivacyCell.setText(BuildConfig.FLAVOR);
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                return;
            }
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    return;
                }
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != ChildLockExceptionsActivity.this.usersHeaderRow || ChildLockExceptionsActivity.this.blockedUsersActivity) {
                    return;
                }
                headerCell.setText(LocaleController.getString("PrivacyExceptions", R.string.PrivacyExceptions));
                return;
            }
            ManageChatTextCell manageChatTextCell = (ManageChatTextCell) viewHolder.itemView;
            manageChatTextCell.setColors(Theme.key_windowBackgroundWhiteBlueIcon, Theme.key_windowBackgroundWhiteBlueButton);
            if (ChildLockExceptionsActivity.this.blockedUsersActivity) {
                return;
            }
            if (ChildLockExceptionsActivity.this.chatType != 0) {
                if (ChildLockExceptionsActivity.this.chatType != 1) {
                    if (ChildLockExceptionsActivity.this.chatType == 2) {
                        string = LocaleController.getString(R.string.ChildLockAddChannelException).toString();
                    }
                } else {
                    string = LocaleController.getString(R.string.ChildLockAddGroupException).toString();
                }
            } else {
                string = LocaleController.getString(R.string.ChildLockAddUserException).toString();
            }
            manageChatTextCell.setText(string, null, R.drawable.actions_addmember2, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ChildLockExceptionsActivity.this.usersHeaderRow) {
                return 3;
            }
            if (i == ChildLockExceptionsActivity.this.blockUserRow) {
                return 2;
            }
            return (i == ChildLockExceptionsActivity.this.blockUserDetailRow || i == ChildLockExceptionsActivity.this.usersDetailRow) ? 1 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.appp.messenger.ChildLockExceptionsActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$4();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ManageChatUserCell.class, ManageChatTextCell.class, HeaderCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, new Drawable[]{Theme.avatar_savedDrawable}, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$4() {
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
