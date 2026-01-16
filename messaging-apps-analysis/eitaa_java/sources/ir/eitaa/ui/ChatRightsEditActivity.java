package ir.eitaa.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_channels_editCreator;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.DialogRadioCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.PollEditTextCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell2;
import ir.eitaa.ui.Cells.TextDetailCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Cells.UserCell2;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DatePicker.date.DatePickerDialog;
import ir.eitaa.ui.DatePicker.util.PersianCalendar;
import ir.eitaa.ui.TwoStepVerificationActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class ChatRightsEditActivity extends BaseFragment {
    private int addAdminsRow;
    private int addUsersRow;
    private TLRPC$TL_chatAdminRights adminRights;
    private int banUsersRow;
    private TLRPC$TL_chatBannedRights bannedRights;
    private boolean canEdit;
    private int cantEditInfoRow;
    private int changeInfoRow;
    private long chatId;
    private String currentBannedRights;
    private TLRPC$Chat currentChat;
    private String currentRank;
    private int currentType;
    private TLRPC$User currentUser;
    private TLRPC$TL_chatBannedRights defaultBannedRights;
    private ChatRightsEditActivityDelegate delegate;
    private int deleteMessagesRow;
    private int editMesagesRow;
    private int embedLinksRow;
    private boolean initialIsSet;
    private String initialRank;
    private boolean isAddingNew;
    private boolean isChannel;
    private boolean isMegagroup;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private TLRPC$TL_chatAdminRights myAdminRights;
    private int pinMessagesRow;
    private int postMessagesRow;
    private int removeAdminRow;
    private int removeAdminShadowRow;
    private int rightsShadowRow;
    private int rowCount;
    private int sendMediaRow;
    private int sendMessagesRow;
    private int sendPollsRow;
    private int sendStickersRow;
    private int startVoiceChatRow;
    private int transferOwnerRow;
    private int transferOwnerShadowRow;
    private int untilDateRow;
    private int untilSectionRow;
    private int anonymousRow = -1;
    private int rankHeaderRow = -1;
    private int rankRow = -1;
    private int rankInfoRow = -1;
    private int viewParticipantsRow = -1;
    private int postLiveRow = -1;
    private int sendForwardedMessagesRow = -1;

    public interface ChatRightsEditActivityDelegate {
        void didChangeOwner(TLRPC$User user);

        void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank);
    }

    static /* synthetic */ void lambda$createView$1(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$createView$3(DialogInterface dialogInterface, int i) {
    }

    public ChatRightsEditActivity(long userId, long channelId, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBannedDefault, TLRPC$TL_chatBannedRights rightsBanned, String rank, int type, boolean edit, boolean addingNew) {
        this.currentBannedRights = "";
        this.isAddingNew = addingNew;
        this.chatId = channelId;
        this.currentUser = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(userId));
        this.currentType = type;
        this.canEdit = edit;
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.chatId));
        this.currentChat = chat;
        rank = rank == null ? "" : rank;
        this.currentRank = rank;
        this.initialRank = rank;
        boolean z = true;
        if (chat != null) {
            this.isMegagroup = chat.megagroup;
            this.isChannel = ChatObject.isChannel(chat) && !this.currentChat.megagroup;
            this.myAdminRights = this.currentChat.admin_rights;
        }
        if (this.myAdminRights == null) {
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
            this.myAdminRights = tLRPC$TL_chatAdminRights;
            tLRPC$TL_chatAdminRights.post_live = true;
            tLRPC$TL_chatAdminRights.manage_call = true;
            tLRPC$TL_chatAdminRights.add_admins = true;
            tLRPC$TL_chatAdminRights.pin_messages = true;
            tLRPC$TL_chatAdminRights.invite_users = true;
            tLRPC$TL_chatAdminRights.ban_users = true;
            tLRPC$TL_chatAdminRights.delete_messages = true;
            tLRPC$TL_chatAdminRights.edit_messages = true;
            tLRPC$TL_chatAdminRights.post_messages = true;
            tLRPC$TL_chatAdminRights.change_info = true;
        }
        if (type == 0) {
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = new TLRPC$TL_chatAdminRights();
            this.adminRights = tLRPC$TL_chatAdminRights2;
            if (rightsAdmin == null) {
                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3 = this.myAdminRights;
                tLRPC$TL_chatAdminRights2.change_info = tLRPC$TL_chatAdminRights3.change_info;
                tLRPC$TL_chatAdminRights2.post_messages = tLRPC$TL_chatAdminRights3.post_messages;
                tLRPC$TL_chatAdminRights2.edit_messages = tLRPC$TL_chatAdminRights3.edit_messages;
                tLRPC$TL_chatAdminRights2.delete_messages = tLRPC$TL_chatAdminRights3.delete_messages;
                tLRPC$TL_chatAdminRights2.manage_call = tLRPC$TL_chatAdminRights3.manage_call;
                tLRPC$TL_chatAdminRights2.ban_users = tLRPC$TL_chatAdminRights3.ban_users;
                tLRPC$TL_chatAdminRights2.invite_users = tLRPC$TL_chatAdminRights3.invite_users;
                tLRPC$TL_chatAdminRights2.pin_messages = tLRPC$TL_chatAdminRights3.pin_messages;
                tLRPC$TL_chatAdminRights2.post_live = tLRPC$TL_chatAdminRights3.post_live;
                this.initialIsSet = false;
            } else {
                boolean z2 = rightsAdmin.change_info;
                tLRPC$TL_chatAdminRights2.change_info = z2;
                boolean z3 = rightsAdmin.post_messages;
                tLRPC$TL_chatAdminRights2.post_messages = z3;
                boolean z4 = rightsAdmin.edit_messages;
                tLRPC$TL_chatAdminRights2.edit_messages = z4;
                boolean z5 = rightsAdmin.delete_messages;
                tLRPC$TL_chatAdminRights2.delete_messages = z5;
                boolean z6 = rightsAdmin.manage_call;
                tLRPC$TL_chatAdminRights2.manage_call = z6;
                boolean z7 = rightsAdmin.ban_users;
                tLRPC$TL_chatAdminRights2.ban_users = z7;
                boolean z8 = rightsAdmin.invite_users;
                tLRPC$TL_chatAdminRights2.invite_users = z8;
                boolean z9 = rightsAdmin.pin_messages;
                tLRPC$TL_chatAdminRights2.pin_messages = z9;
                boolean z10 = rightsAdmin.add_admins;
                tLRPC$TL_chatAdminRights2.add_admins = z10;
                boolean z11 = rightsAdmin.post_live;
                tLRPC$TL_chatAdminRights2.post_live = z11;
                boolean z12 = rightsAdmin.anonymous;
                tLRPC$TL_chatAdminRights2.anonymous = z12;
                if (!z2 && !z3 && !z4 && !z5 && !z7 && !z8 && !z9 && !z10 && !z11 && !z6 && !z12) {
                    z = false;
                }
                this.initialIsSet = z;
            }
        } else {
            this.defaultBannedRights = rightsBannedDefault;
            if (rightsBannedDefault == null) {
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
                this.defaultBannedRights = tLRPC$TL_chatBannedRights;
                tLRPC$TL_chatBannedRights.view_participants = false;
                tLRPC$TL_chatBannedRights.pin_messages = false;
                tLRPC$TL_chatBannedRights.change_info = false;
                tLRPC$TL_chatBannedRights.invite_users = false;
                tLRPC$TL_chatBannedRights.send_polls = false;
                tLRPC$TL_chatBannedRights.send_inline = false;
                tLRPC$TL_chatBannedRights.send_games = false;
                tLRPC$TL_chatBannedRights.send_gifs = false;
                tLRPC$TL_chatBannedRights.send_stickers = false;
                tLRPC$TL_chatBannedRights.embed_links = false;
                tLRPC$TL_chatBannedRights.send_forwarded_messages = false;
                tLRPC$TL_chatBannedRights.send_messages = false;
                tLRPC$TL_chatBannedRights.send_media = false;
                tLRPC$TL_chatBannedRights.view_messages = false;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = new TLRPC$TL_chatBannedRights();
            this.bannedRights = tLRPC$TL_chatBannedRights2;
            if (rightsBanned == null) {
                tLRPC$TL_chatBannedRights2.view_participants = false;
                tLRPC$TL_chatBannedRights2.pin_messages = false;
                tLRPC$TL_chatBannedRights2.change_info = false;
                tLRPC$TL_chatBannedRights2.invite_users = false;
                tLRPC$TL_chatBannedRights2.send_polls = false;
                tLRPC$TL_chatBannedRights2.send_inline = false;
                tLRPC$TL_chatBannedRights2.send_games = false;
                tLRPC$TL_chatBannedRights2.send_gifs = false;
                tLRPC$TL_chatBannedRights2.send_stickers = false;
                tLRPC$TL_chatBannedRights2.embed_links = false;
                tLRPC$TL_chatBannedRights2.send_forwarded_messages = false;
                tLRPC$TL_chatBannedRights2.send_messages = false;
                tLRPC$TL_chatBannedRights2.send_media = false;
                tLRPC$TL_chatBannedRights2.view_messages = false;
            } else {
                tLRPC$TL_chatBannedRights2.view_messages = rightsBanned.view_messages;
                tLRPC$TL_chatBannedRights2.send_messages = rightsBanned.send_messages;
                tLRPC$TL_chatBannedRights2.send_forwarded_messages = rightsBanned.send_forwarded_messages;
                tLRPC$TL_chatBannedRights2.send_media = rightsBanned.send_media;
                tLRPC$TL_chatBannedRights2.send_stickers = rightsBanned.send_stickers;
                tLRPC$TL_chatBannedRights2.send_gifs = rightsBanned.send_gifs;
                tLRPC$TL_chatBannedRights2.send_games = rightsBanned.send_games;
                tLRPC$TL_chatBannedRights2.send_inline = rightsBanned.send_inline;
                tLRPC$TL_chatBannedRights2.embed_links = rightsBanned.embed_links;
                tLRPC$TL_chatBannedRights2.send_polls = rightsBanned.send_polls;
                tLRPC$TL_chatBannedRights2.view_participants = rightsBanned.view_participants;
                tLRPC$TL_chatBannedRights2.invite_users = rightsBanned.invite_users;
                tLRPC$TL_chatBannedRights2.change_info = rightsBanned.change_info;
                tLRPC$TL_chatBannedRights2.pin_messages = rightsBanned.pin_messages;
                tLRPC$TL_chatBannedRights2.until_date = rightsBanned.until_date;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = this.defaultBannedRights;
            if (tLRPC$TL_chatBannedRights3.view_messages) {
                tLRPC$TL_chatBannedRights2.view_messages = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_messages) {
                tLRPC$TL_chatBannedRights2.send_messages = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_forwarded_messages) {
                tLRPC$TL_chatBannedRights2.send_forwarded_messages = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_media) {
                tLRPC$TL_chatBannedRights2.send_media = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_stickers) {
                tLRPC$TL_chatBannedRights2.send_stickers = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_gifs) {
                tLRPC$TL_chatBannedRights2.send_gifs = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_games) {
                tLRPC$TL_chatBannedRights2.send_games = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_inline) {
                tLRPC$TL_chatBannedRights2.send_inline = true;
            }
            if (tLRPC$TL_chatBannedRights3.embed_links) {
                tLRPC$TL_chatBannedRights2.embed_links = true;
            }
            if (tLRPC$TL_chatBannedRights3.send_polls) {
                tLRPC$TL_chatBannedRights2.send_polls = true;
            }
            if (tLRPC$TL_chatBannedRights3.invite_users) {
                tLRPC$TL_chatBannedRights2.invite_users = true;
            }
            if (tLRPC$TL_chatBannedRights3.change_info) {
                tLRPC$TL_chatBannedRights2.change_info = true;
            }
            if (tLRPC$TL_chatBannedRights3.pin_messages) {
                tLRPC$TL_chatBannedRights2.pin_messages = true;
            }
            this.currentBannedRights = ChatObject.getBannedRightsString(tLRPC$TL_chatBannedRights2);
            if (rightsBanned != null && rightsBanned.view_messages) {
                z = false;
            }
            this.initialIsSet = z;
        }
        updateRows(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("EditAdmin", R.string.EditAdmin));
        } else {
            this.actionBar.setTitle(LocaleController.getString("UserRestrictions", R.string.UserRestrictions));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChatRightsEditActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (ChatRightsEditActivity.this.checkDiscard()) {
                        ChatRightsEditActivity.this.finishFragment();
                    }
                } else if (id == 1) {
                    ChatRightsEditActivity.this.onDonePressed();
                }
            }
        });
        if (this.canEdit || (!this.isChannel && this.currentChat.creator && UserObject.isUserSelf(this.currentUser))) {
            this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        View view = this.fragmentView;
        FrameLayout frameLayout2 = (FrameLayout) view;
        view.setFocusableInTouchMode(true);
        this.listView = new RecyclerListView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ChatRightsEditActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(ChatRightsEditActivity.this.getParentActivity().getCurrentFocus());
                }
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$iyDpREZOYnLecTEBj4TnpjBIk2k
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i) {
                this.f$0.lambda$createView$6$ChatRightsEditActivity(context, view2, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$ChatRightsEditActivity(Context context, View view, int i) {
        String string;
        if (i == 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", this.currentUser.id);
            presentFragment(new ProfileActivity(bundle));
            return;
        }
        if (this.canEdit || (this.currentChat.creator && this.currentType == 0 && i == this.anonymousRow)) {
            if (i == this.removeAdminRow) {
                int i2 = this.currentType;
                if (i2 == 0) {
                    MessagesController.getInstance(this.currentAccount).setUserAdminRole(this.chatId, this.currentUser, new TLRPC$TL_chatAdminRights(), this.currentRank, this.isChannel, getFragmentForAlert(0), this.isAddingNew);
                    ChatRightsEditActivityDelegate chatRightsEditActivityDelegate = this.delegate;
                    if (chatRightsEditActivityDelegate != null) {
                        chatRightsEditActivityDelegate.didSetRights(0, this.adminRights, this.bannedRights, this.currentRank);
                    }
                    finishFragment();
                    return;
                }
                if (i2 == 1) {
                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
                    this.bannedRights = tLRPC$TL_chatBannedRights;
                    tLRPC$TL_chatBannedRights.view_messages = true;
                    tLRPC$TL_chatBannedRights.send_media = true;
                    tLRPC$TL_chatBannedRights.send_messages = true;
                    tLRPC$TL_chatBannedRights.send_stickers = true;
                    tLRPC$TL_chatBannedRights.send_gifs = true;
                    tLRPC$TL_chatBannedRights.send_games = true;
                    tLRPC$TL_chatBannedRights.send_inline = true;
                    tLRPC$TL_chatBannedRights.embed_links = true;
                    tLRPC$TL_chatBannedRights.pin_messages = true;
                    tLRPC$TL_chatBannedRights.send_polls = true;
                    tLRPC$TL_chatBannedRights.invite_users = true;
                    tLRPC$TL_chatBannedRights.change_info = true;
                    tLRPC$TL_chatBannedRights.until_date = 0;
                    tLRPC$TL_chatBannedRights.send_forwarded_messages = true;
                    tLRPC$TL_chatBannedRights.view_participants = true;
                    onDonePressed();
                    return;
                }
                return;
            }
            if (i == this.transferOwnerRow) {
                lambda$initTransfer$8(null, null);
                return;
            }
            if (i == this.untilDateRow) {
                if (getParentActivity() == null) {
                    return;
                }
                final BottomSheet.Builder builder = new BottomSheet.Builder(context);
                builder.setApplyTopPadding(false);
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                HeaderCell headerCell = new HeaderCell(context, "dialogTextBlue2", 23, 15, false);
                headerCell.setHeight(47);
                headerCell.setText(LocaleController.getString("UserRestrictionsDuration", R.string.UserRestrictionsDuration));
                linearLayout.addView(headerCell);
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(1);
                linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2));
                BottomSheet.BottomSheetCell[] bottomSheetCellArr = new BottomSheet.BottomSheetCell[5];
                for (int i3 = 0; i3 < 5; i3++) {
                    bottomSheetCellArr[i3] = new BottomSheet.BottomSheetCell(context, 0);
                    bottomSheetCellArr[i3].setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
                    bottomSheetCellArr[i3].setTag(Integer.valueOf(i3));
                    bottomSheetCellArr[i3].setBackgroundDrawable(Theme.getSelectorDrawable(false));
                    if (i3 == 0) {
                        string = LocaleController.getString("UserRestrictionsUntilForever", R.string.UserRestrictionsUntilForever);
                    } else if (i3 == 1) {
                        string = LocaleController.formatPluralString("Days", 1);
                    } else if (i3 == 2) {
                        string = LocaleController.formatPluralString("Weeks", 1);
                    } else if (i3 == 3) {
                        string = LocaleController.formatPluralString("Months", 1);
                    } else {
                        string = LocaleController.getString("UserRestrictionsCustom", R.string.UserRestrictionsCustom);
                    }
                    bottomSheetCellArr[i3].setTextAndIcon(string, 0);
                    linearLayout2.addView(bottomSheetCellArr[i3], LayoutHelper.createLinear(-1, -2));
                    bottomSheetCellArr[i3].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$XHjDFoMlj6gOBqU-s6_I8nxJUc0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$5$ChatRightsEditActivity(builder, view2);
                        }
                    });
                }
                builder.setCustomView(linearLayout);
                showDialog(builder.create());
                return;
            }
            if (view instanceof TextCheckCell2) {
                TextCheckCell2 textCheckCell2 = (TextCheckCell2) view;
                if (textCheckCell2.hasIcon()) {
                    Toast.makeText(getParentActivity(), LocaleController.getString("UserRestrictionsDisabled", R.string.UserRestrictionsDisabled), 0).show();
                    return;
                }
                if (textCheckCell2.isEnabled()) {
                    textCheckCell2.setChecked(!textCheckCell2.isChecked());
                    if (i == this.changeInfoRow) {
                        if (this.currentType == 0) {
                            this.adminRights.change_info = !r12.change_info;
                        } else {
                            this.bannedRights.change_info = !r12.change_info;
                        }
                    } else if (i == this.postMessagesRow) {
                        this.adminRights.post_messages = !r12.post_messages;
                    } else if (i == this.editMesagesRow) {
                        this.adminRights.edit_messages = !r12.edit_messages;
                    } else if (i == this.deleteMessagesRow) {
                        this.adminRights.delete_messages = !r12.delete_messages;
                    } else if (i == this.addAdminsRow) {
                        this.adminRights.add_admins = !r12.add_admins;
                    } else if (i == this.anonymousRow) {
                        this.adminRights.anonymous = !r12.anonymous;
                    } else if (i == this.banUsersRow) {
                        this.adminRights.ban_users = !r12.ban_users;
                    } else if (i == this.startVoiceChatRow) {
                        this.adminRights.manage_call = !r12.manage_call;
                    } else if (i == this.addUsersRow) {
                        if (this.currentType == 0) {
                            this.adminRights.invite_users = !r12.invite_users;
                        } else {
                            this.bannedRights.invite_users = !r12.invite_users;
                        }
                    } else if (i == this.pinMessagesRow) {
                        if (this.currentType == 0) {
                            this.adminRights.pin_messages = !r12.pin_messages;
                        } else {
                            this.bannedRights.pin_messages = !r12.pin_messages;
                        }
                    } else if (i == this.postLiveRow) {
                        this.adminRights.post_live = !r12.post_live;
                    } else if (this.bannedRights != null) {
                        boolean z = !textCheckCell2.isChecked();
                        int i4 = this.sendMessagesRow;
                        if (i == i4) {
                            this.bannedRights.send_messages = !r14.send_messages;
                        } else if (i == this.sendMediaRow) {
                            this.bannedRights.send_media = !r14.send_media;
                        } else if (i == this.sendForwardedMessagesRow) {
                            this.bannedRights.send_forwarded_messages = !r14.send_forwarded_messages;
                        } else if (i == this.sendStickersRow) {
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = this.bannedRights;
                            boolean z2 = !tLRPC$TL_chatBannedRights2.send_stickers;
                            tLRPC$TL_chatBannedRights2.send_inline = z2;
                            tLRPC$TL_chatBannedRights2.send_gifs = z2;
                            tLRPC$TL_chatBannedRights2.send_games = z2;
                            tLRPC$TL_chatBannedRights2.send_stickers = z2;
                        } else if (i == this.embedLinksRow) {
                            this.bannedRights.embed_links = !r14.embed_links;
                        } else if (i == this.sendPollsRow) {
                            this.bannedRights.send_polls = !r14.send_polls;
                        } else if (i == this.viewParticipantsRow) {
                            this.bannedRights.view_participants = !r14.view_participants;
                        }
                        if (z) {
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = this.bannedRights;
                            if (tLRPC$TL_chatBannedRights3.view_messages && !tLRPC$TL_chatBannedRights3.send_messages) {
                                tLRPC$TL_chatBannedRights3.send_messages = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i4);
                                if (viewHolderFindViewHolderForAdapterPosition != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights4 = this.bannedRights;
                            if ((tLRPC$TL_chatBannedRights4.view_messages || tLRPC$TL_chatBannedRights4.send_messages) && !tLRPC$TL_chatBannedRights4.send_forwarded_messages) {
                                tLRPC$TL_chatBannedRights4.send_forwarded_messages = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.sendForwardedMessagesRow);
                                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition2.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights5 = this.bannedRights;
                            if ((tLRPC$TL_chatBannedRights5.view_messages || tLRPC$TL_chatBannedRights5.send_messages) && !tLRPC$TL_chatBannedRights5.send_media) {
                                tLRPC$TL_chatBannedRights5.send_media = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition3 = this.listView.findViewHolderForAdapterPosition(this.sendMediaRow);
                                if (viewHolderFindViewHolderForAdapterPosition3 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition3.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights6 = this.bannedRights;
                            if ((tLRPC$TL_chatBannedRights6.view_messages || tLRPC$TL_chatBannedRights6.send_messages) && !tLRPC$TL_chatBannedRights6.send_polls) {
                                tLRPC$TL_chatBannedRights6.send_polls = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition4 = this.listView.findViewHolderForAdapterPosition(this.sendPollsRow);
                                if (viewHolderFindViewHolderForAdapterPosition4 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition4.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights7 = this.bannedRights;
                            if ((tLRPC$TL_chatBannedRights7.view_messages || tLRPC$TL_chatBannedRights7.send_messages) && !tLRPC$TL_chatBannedRights7.send_stickers) {
                                tLRPC$TL_chatBannedRights7.send_inline = true;
                                tLRPC$TL_chatBannedRights7.send_gifs = true;
                                tLRPC$TL_chatBannedRights7.send_games = true;
                                tLRPC$TL_chatBannedRights7.send_stickers = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition5 = this.listView.findViewHolderForAdapterPosition(this.sendStickersRow);
                                if (viewHolderFindViewHolderForAdapterPosition5 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition5.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights8 = this.bannedRights;
                            if ((tLRPC$TL_chatBannedRights8.view_messages || tLRPC$TL_chatBannedRights8.send_messages) && !tLRPC$TL_chatBannedRights8.embed_links) {
                                tLRPC$TL_chatBannedRights8.embed_links = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition6 = this.listView.findViewHolderForAdapterPosition(this.embedLinksRow);
                                if (viewHolderFindViewHolderForAdapterPosition6 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition6.itemView).setChecked(false);
                                }
                            }
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights9 = this.bannedRights;
                            if (tLRPC$TL_chatBannedRights9.send_media && !tLRPC$TL_chatBannedRights9.send_stickers) {
                                tLRPC$TL_chatBannedRights9.send_stickers = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition7 = this.listView.findViewHolderForAdapterPosition(this.sendStickersRow);
                                if (viewHolderFindViewHolderForAdapterPosition7 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition7.itemView).setChecked(false);
                                }
                            }
                        } else {
                            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights10 = this.bannedRights;
                            boolean z3 = tLRPC$TL_chatBannedRights10.send_messages;
                            if ((!z3 || !tLRPC$TL_chatBannedRights10.embed_links || !tLRPC$TL_chatBannedRights10.send_inline || !tLRPC$TL_chatBannedRights10.send_media || !tLRPC$TL_chatBannedRights10.send_polls || !tLRPC$TL_chatBannedRights10.send_forwarded_messages) && tLRPC$TL_chatBannedRights10.view_messages) {
                                tLRPC$TL_chatBannedRights10.view_messages = false;
                            }
                            if ((!tLRPC$TL_chatBannedRights10.embed_links || !tLRPC$TL_chatBannedRights10.send_inline || !tLRPC$TL_chatBannedRights10.send_media || !tLRPC$TL_chatBannedRights10.send_polls || !tLRPC$TL_chatBannedRights10.send_forwarded_messages) && z3) {
                                tLRPC$TL_chatBannedRights10.send_messages = false;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition8 = this.listView.findViewHolderForAdapterPosition(i4);
                                if (viewHolderFindViewHolderForAdapterPosition8 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition8.itemView).setChecked(true);
                                }
                            }
                        }
                    }
                    updateRows(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ChatRightsEditActivity(BottomSheet.Builder builder, View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        if (iIntValue == 0) {
            this.bannedRights.until_date = 0;
            this.listViewAdapter.notifyItemChanged(this.untilDateRow);
        } else if (iIntValue == 1) {
            this.bannedRights.until_date = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 86400;
            this.listViewAdapter.notifyItemChanged(this.untilDateRow);
        } else if (iIntValue == 2) {
            this.bannedRights.until_date = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 604800;
            this.listViewAdapter.notifyItemChanged(this.untilDateRow);
        } else if (iIntValue == 3) {
            this.bannedRights.until_date = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 2592000;
            this.listViewAdapter.notifyItemChanged(this.untilDateRow);
        } else if (iIntValue == 4) {
            if (LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals("fa")) {
                PersianCalendar persianCalendar = new PersianCalendar();
                try {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getParentActivity(), new DatePickerDialog.OnDateSetListener() { // from class: ir.eitaa.ui.ChatRightsEditActivity.3
                        @Override // ir.eitaa.ui.DatePicker.date.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePickerDialog view2, int year, int monthOfYear, int dayOfMonth) {
                            PersianCalendar persianCalendar2 = new PersianCalendar();
                            persianCalendar2.clear();
                            persianCalendar2.setPersianDate(year, monthOfYear, dayOfMonth);
                            final int time = (int) (persianCalendar2.getTime().getTime() / 1000);
                            try {
                                TimePickerDialog timePickerDialog = new TimePickerDialog(ChatRightsEditActivity.this.getParentActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: ir.eitaa.ui.ChatRightsEditActivity.3.1
                                    @Override // android.app.TimePickerDialog.OnTimeSetListener
                                    public void onTimeSet(TimePicker view3, int hourOfDay, int minute) {
                                        ChatRightsEditActivity.this.bannedRights.until_date = time + (hourOfDay * 3600) + (minute * 60);
                                        ChatRightsEditActivity.this.listViewAdapter.notifyItemChanged(ChatRightsEditActivity.this.untilDateRow);
                                    }
                                }, 0, 0, true);
                                timePickerDialog.setButton(-1, LocaleController.getString("Set", R.string.Set), timePickerDialog);
                                timePickerDialog.setButton(-2, LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.ChatRightsEditActivity.3.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                ChatRightsEditActivity.this.showDialog(timePickerDialog);
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    }, persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay());
                    PersianCalendar persianCalendar2 = new PersianCalendar();
                    persianCalendar2.setTimeInMillis(System.currentTimeMillis() + 31536000000L);
                    datePickerDialog.setMaxDate(persianCalendar2);
                    PersianCalendar persianCalendar3 = new PersianCalendar();
                    persianCalendar3.setTimeInMillis(System.currentTimeMillis());
                    datePickerDialog.setMinDate(persianCalendar3);
                    datePickerDialog.goTo(persianCalendar);
                    showDialog(datePickerDialog);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else {
                Calendar calendar = Calendar.getInstance();
                try {
                    android.app.DatePickerDialog datePickerDialog2 = new android.app.DatePickerDialog(getParentActivity(), new DatePickerDialog.OnDateSetListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$fPXmUJHrbDuptkeCaY9ua_HH0Kc
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            this.f$0.lambda$createView$2$ChatRightsEditActivity(datePicker, i, i2, i3);
                        }
                    }, calendar.get(1), calendar.get(2), calendar.get(5));
                    final DatePicker datePicker = datePickerDialog2.getDatePicker();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTimeInMillis(System.currentTimeMillis());
                    calendar2.set(11, calendar2.getMinimum(11));
                    calendar2.set(12, calendar2.getMinimum(12));
                    calendar2.set(13, calendar2.getMinimum(13));
                    calendar2.set(14, calendar2.getMinimum(14));
                    datePicker.setMinDate(calendar2.getTimeInMillis());
                    calendar2.setTimeInMillis(System.currentTimeMillis() + 31536000000L);
                    calendar2.set(11, calendar2.getMaximum(11));
                    calendar2.set(12, calendar2.getMaximum(12));
                    calendar2.set(13, calendar2.getMaximum(13));
                    calendar2.set(14, calendar2.getMaximum(14));
                    datePicker.setMaxDate(calendar2.getTimeInMillis());
                    datePickerDialog2.setButton(-1, LocaleController.getString("Set", R.string.Set), datePickerDialog2);
                    datePickerDialog2.setButton(-2, LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$eygNG9KtvrJ0Bfw405AUi9Pxx3c
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ChatRightsEditActivity.lambda$createView$3(dialogInterface, i);
                        }
                    });
                    if (Build.VERSION.SDK_INT >= 21) {
                        datePickerDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$NGDAw3TJzCihAexmEh0gAHxjiUw
                            @Override // android.content.DialogInterface.OnShowListener
                            public final void onShow(DialogInterface dialogInterface) {
                                ChatRightsEditActivity.lambda$createView$4(datePicker, dialogInterface);
                            }
                        });
                    }
                    showDialog(datePickerDialog2);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        }
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ChatRightsEditActivity(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(i, i2, i3);
        final int time = (int) (calendar.getTime().getTime() / 1000);
        try {
            TimePickerDialog timePickerDialog = new TimePickerDialog(getParentActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$wJ0-7eEJLVxLWH5hyLQwqhVWu_c
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i4, int i5) {
                    this.f$0.lambda$createView$0$ChatRightsEditActivity(time, timePicker, i4, i5);
                }
            }, 0, 0, true);
            timePickerDialog.setButton(-1, LocaleController.getString("Set", R.string.Set), timePickerDialog);
            timePickerDialog.setButton(-2, LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$-v0gv1HKx969cxK8fgdLFqa4r0o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ChatRightsEditActivity.lambda$createView$1(dialogInterface, i4);
                }
            });
            showDialog(timePickerDialog);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ChatRightsEditActivity(int i, TimePicker timePicker, int i2, int i3) {
        this.bannedRights.until_date = i + (i2 * 3600) + (i3 * 60);
        this.listViewAdapter.notifyItemChanged(this.untilDateRow);
    }

    static /* synthetic */ void lambda$createView$4(DatePicker datePicker, DialogInterface dialogInterface) {
        int childCount = datePicker.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = datePicker.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = -1;
            childAt.setLayoutParams(layoutParams);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    private boolean isDefaultAdminRights() {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = this.adminRights;
        boolean z = tLRPC$TL_chatAdminRights.change_info;
        return (z && tLRPC$TL_chatAdminRights.delete_messages && tLRPC$TL_chatAdminRights.ban_users && tLRPC$TL_chatAdminRights.invite_users && tLRPC$TL_chatAdminRights.pin_messages && tLRPC$TL_chatAdminRights.manage_call && !tLRPC$TL_chatAdminRights.add_admins && !tLRPC$TL_chatAdminRights.anonymous) || !(z || tLRPC$TL_chatAdminRights.delete_messages || tLRPC$TL_chatAdminRights.ban_users || tLRPC$TL_chatAdminRights.invite_users || tLRPC$TL_chatAdminRights.pin_messages || tLRPC$TL_chatAdminRights.manage_call || tLRPC$TL_chatAdminRights.add_admins || tLRPC$TL_chatAdminRights.anonymous);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initTransfer, reason: merged with bridge method [inline-methods] */
    public void lambda$initTransfer$8$ChatRightsEditActivity(final TLRPC$InputCheckPasswordSRP srp, final TwoStepVerificationActivity passwordFragment) {
        if (getParentActivity() == null) {
            return;
        }
        if (srp != null && !ChatObject.isChannel(this.currentChat)) {
            MessagesController.getInstance(this.currentAccount).convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$O5Yw1beoBTCgw6AFXkUIRh7N5iE
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$initTransfer$7$ChatRightsEditActivity(srp, passwordFragment, j);
                }
            });
            return;
        }
        final TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator = new TLRPC$TL_channels_editCreator();
        if (ChatObject.isChannel(this.currentChat)) {
            TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
            tLRPC$TL_channels_editCreator.channel = tLRPC$TL_inputChannel;
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            tLRPC$TL_inputChannel.channel_id = tLRPC$Chat.id;
            tLRPC$TL_inputChannel.access_hash = tLRPC$Chat.access_hash;
        } else {
            tLRPC$TL_channels_editCreator.channel = new TLRPC$TL_inputChannelEmpty();
        }
        tLRPC$TL_channels_editCreator.password = srp != null ? srp : new TLRPC$TL_inputCheckPasswordEmpty();
        tLRPC$TL_channels_editCreator.user_id = getMessagesController().getInputUser(this.currentUser);
        getConnectionsManager().sendRequest(tLRPC$TL_channels_editCreator, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$h9L8UWNoyquc3CSxD72fdA1HEWQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$initTransfer$14$ChatRightsEditActivity(srp, passwordFragment, tLRPC$TL_channels_editCreator, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$7$ChatRightsEditActivity(TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, TwoStepVerificationActivity twoStepVerificationActivity, long j) {
        if (j != 0) {
            this.chatId = j;
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(j));
            lambda$initTransfer$8(tLRPC$InputCheckPasswordSRP, twoStepVerificationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$14$ChatRightsEditActivity(final TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, final TwoStepVerificationActivity twoStepVerificationActivity, final TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$SQ_YHZH38eswQCWMUPkg7R_In7o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initTransfer$13$ChatRightsEditActivity(tLRPC$TL_error, tLRPC$InputCheckPasswordSRP, twoStepVerificationActivity, tLRPC$TL_channels_editCreator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$13$ChatRightsEditActivity(TLRPC$TL_error tLRPC$TL_error, TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, final TwoStepVerificationActivity twoStepVerificationActivity, TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator) {
        int i;
        if (tLRPC$TL_error == null) {
            if (tLRPC$InputCheckPasswordSRP != null) {
                this.delegate.didChangeOwner(this.currentUser);
                removeSelfFromStack();
                twoStepVerificationActivity.needHideProgress();
                twoStepVerificationActivity.finishFragment();
                return;
            }
            return;
        }
        if (getParentActivity() == null) {
            return;
        }
        if ("PASSWORD_HASH_INVALID".equals(tLRPC$TL_error.text)) {
            if (tLRPC$InputCheckPasswordSRP == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                if (this.isChannel) {
                    builder.setTitle(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer));
                } else {
                    builder.setTitle(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer));
                }
                builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("EditAdminTransferReadyAlertText", R.string.EditAdminTransferReadyAlertText, this.currentChat.title, UserObject.getFirstName(this.currentUser))));
                builder.setPositiveButton(LocaleController.getString("EditAdminTransferChangeOwner", R.string.EditAdminTransferChangeOwner), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$l25xz7AXx44nWKkbQH3t1PE9mYc
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$initTransfer$9$ChatRightsEditActivity(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder.create());
                return;
            }
            return;
        }
        if ("PASSWORD_MISSING".equals(tLRPC$TL_error.text) || tLRPC$TL_error.text.startsWith("PASSWORD_TOO_FRESH_") || tLRPC$TL_error.text.startsWith("SESSION_TOO_FRESH_")) {
            if (twoStepVerificationActivity != null) {
                twoStepVerificationActivity.needHideProgress();
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setTitle(LocaleController.getString("EditAdminTransferAlertTitle", R.string.EditAdminTransferAlertTitle));
            LinearLayout linearLayout = new LinearLayout(getParentActivity());
            linearLayout.setPadding(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(24.0f), 0);
            linearLayout.setOrientation(1);
            builder2.setView(linearLayout);
            TextView textView = new TextView(getParentActivity());
            textView.setTextColor(Theme.getColor("dialogTextBlack"));
            textView.setTextSize(1, 16.0f);
            textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            if (this.isChannel) {
                textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("EditChannelAdminTransferAlertText", R.string.EditChannelAdminTransferAlertText, UserObject.getFirstName(this.currentUser))));
            } else {
                textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("EditAdminTransferAlertText", R.string.EditAdminTransferAlertText, UserObject.getFirstName(this.currentUser))));
            }
            linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2));
            LinearLayout linearLayout2 = new LinearLayout(getParentActivity());
            linearLayout2.setOrientation(0);
            linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 0.0f, 11.0f, 0.0f, 0.0f));
            ImageView imageView = new ImageView(getParentActivity());
            imageView.setImageResource(R.drawable.list_circle);
            imageView.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(11.0f) : 0, AndroidUtilities.dp(9.0f), LocaleController.isRTL ? 0 : AndroidUtilities.dp(11.0f), 0);
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogTextBlack"), PorterDuff.Mode.MULTIPLY));
            TextView textView2 = new TextView(getParentActivity());
            textView2.setTextColor(Theme.getColor("dialogTextBlack"));
            textView2.setTextSize(1, 16.0f);
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            textView2.setText(AndroidUtilities.replaceTags(LocaleController.getString("EditAdminTransferAlertText1", R.string.EditAdminTransferAlertText1)));
            if (LocaleController.isRTL) {
                linearLayout2.addView(textView2, LayoutHelper.createLinear(-1, -2));
                linearLayout2.addView(imageView, LayoutHelper.createLinear(-2, -2, 5));
            } else {
                linearLayout2.addView(imageView, LayoutHelper.createLinear(-2, -2));
                linearLayout2.addView(textView2, LayoutHelper.createLinear(-1, -2));
            }
            LinearLayout linearLayout3 = new LinearLayout(getParentActivity());
            linearLayout3.setOrientation(0);
            linearLayout.addView(linearLayout3, LayoutHelper.createLinear(-1, -2, 0.0f, 11.0f, 0.0f, 0.0f));
            ImageView imageView2 = new ImageView(getParentActivity());
            imageView2.setImageResource(R.drawable.list_circle);
            imageView2.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(11.0f) : 0, AndroidUtilities.dp(9.0f), LocaleController.isRTL ? 0 : AndroidUtilities.dp(11.0f), 0);
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogTextBlack"), PorterDuff.Mode.MULTIPLY));
            TextView textView3 = new TextView(getParentActivity());
            textView3.setTextColor(Theme.getColor("dialogTextBlack"));
            textView3.setTextSize(1, 16.0f);
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            textView3.setText(AndroidUtilities.replaceTags(LocaleController.getString("EditAdminTransferAlertText2", R.string.EditAdminTransferAlertText2)));
            if (LocaleController.isRTL) {
                linearLayout3.addView(textView3, LayoutHelper.createLinear(-1, -2));
                i = 5;
                linearLayout3.addView(imageView2, LayoutHelper.createLinear(-2, -2, 5));
            } else {
                i = 5;
                linearLayout3.addView(imageView2, LayoutHelper.createLinear(-2, -2));
                linearLayout3.addView(textView3, LayoutHelper.createLinear(-1, -2));
            }
            if ("PASSWORD_MISSING".equals(tLRPC$TL_error.text)) {
                builder2.setPositiveButton(LocaleController.getString("EditAdminTransferSetPassword", R.string.EditAdminTransferSetPassword), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$SumvgmWXT6odE72mQLgvNsb5ivQ
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$initTransfer$10$ChatRightsEditActivity(dialogInterface, i2);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            } else {
                TextView textView4 = new TextView(getParentActivity());
                textView4.setTextColor(Theme.getColor("dialogTextBlack"));
                textView4.setTextSize(1, 16.0f);
                if (!LocaleController.isRTL) {
                    i = 3;
                }
                textView4.setGravity(i | 48);
                textView4.setText(LocaleController.getString("EditAdminTransferAlertText3", R.string.EditAdminTransferAlertText3));
                linearLayout.addView(textView4, LayoutHelper.createLinear(-1, -2, 0.0f, 11.0f, 0.0f, 0.0f));
                builder2.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
            }
            showDialog(builder2.create());
            return;
        }
        if ("SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$l1NZWaUBVwyyVgktz3rTE6AXuns
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$initTransfer$12$ChatRightsEditActivity(twoStepVerificationActivity, tLObject, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        if (tLRPC$TL_error.text.equals("CHANNELS_TOO_MUCH")) {
            presentFragment(new TooManyCommunitiesActivity(1));
            return;
        }
        if (twoStepVerificationActivity != null) {
            twoStepVerificationActivity.needHideProgress();
            twoStepVerificationActivity.finishFragment();
        }
        AlertsCreator.showAddUserAlert(tLRPC$TL_error.text, this, this.isChannel, tLRPC$TL_channels_editCreator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$9$ChatRightsEditActivity(DialogInterface dialogInterface, int i) {
        final TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
        twoStepVerificationActivity.setDelegate(new TwoStepVerificationActivity.TwoStepVerificationActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$8d5_oMQbtCvgwhHMU4TMXPnIUVE
            @Override // ir.eitaa.ui.TwoStepVerificationActivity.TwoStepVerificationActivityDelegate
            public final void didEnterPassword(TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP) {
                this.f$0.lambda$initTransfer$8$ChatRightsEditActivity(twoStepVerificationActivity, tLRPC$InputCheckPasswordSRP);
            }
        });
        presentFragment(twoStepVerificationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$10$ChatRightsEditActivity(DialogInterface dialogInterface, int i) {
        presentFragment(new TwoStepVerificationSetupActivity(6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$12$ChatRightsEditActivity(final TwoStepVerificationActivity twoStepVerificationActivity, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$67ezZyFC3JcTkLsWkPlCcqHiFZU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initTransfer$11$ChatRightsEditActivity(tLRPC$TL_error, tLObject, twoStepVerificationActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initTransfer$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$initTransfer$11$ChatRightsEditActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TwoStepVerificationActivity twoStepVerificationActivity) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            twoStepVerificationActivity.setCurrentPasswordInfo(null, tLRPC$TL_account_password);
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            lambda$initTransfer$8(twoStepVerificationActivity.getNewSrpPassword(), twoStepVerificationActivity);
        }
    }

    private void updateRows(boolean update) {
        int i;
        int iMin = Math.min(this.transferOwnerShadowRow, this.transferOwnerRow);
        this.changeInfoRow = -1;
        this.postMessagesRow = -1;
        this.editMesagesRow = -1;
        this.deleteMessagesRow = -1;
        this.addAdminsRow = -1;
        this.anonymousRow = -1;
        this.banUsersRow = -1;
        this.addUsersRow = -1;
        this.pinMessagesRow = -1;
        this.rightsShadowRow = -1;
        this.removeAdminRow = -1;
        this.removeAdminShadowRow = -1;
        this.cantEditInfoRow = -1;
        this.transferOwnerShadowRow = -1;
        this.transferOwnerRow = -1;
        this.rankHeaderRow = -1;
        this.rankRow = -1;
        this.rankInfoRow = -1;
        this.sendMessagesRow = -1;
        this.sendMediaRow = -1;
        this.sendStickersRow = -1;
        this.sendPollsRow = -1;
        this.embedLinksRow = -1;
        this.startVoiceChatRow = -1;
        this.untilSectionRow = -1;
        this.untilDateRow = -1;
        this.rowCount = 3;
        int i2 = this.currentType;
        if (i2 == 0) {
            if (this.isChannel) {
                int i3 = 3 + 1;
                this.rowCount = i3;
                this.changeInfoRow = 3;
                int i4 = i3 + 1;
                this.rowCount = i4;
                this.postMessagesRow = i3;
                int i5 = i4 + 1;
                this.rowCount = i5;
                this.editMesagesRow = i4;
                int i6 = i5 + 1;
                this.rowCount = i6;
                this.deleteMessagesRow = i5;
                int i7 = i6 + 1;
                this.rowCount = i7;
                this.addUsersRow = i6;
                int i8 = i7 + 1;
                this.rowCount = i8;
                this.postLiveRow = i7;
                int i9 = i8 + 1;
                this.rowCount = i9;
                this.pinMessagesRow = i8;
                this.rowCount = i9 + 1;
                this.addAdminsRow = i9;
            } else {
                int i10 = 3 + 1;
                this.rowCount = i10;
                this.changeInfoRow = 3;
                int i11 = i10 + 1;
                this.rowCount = i11;
                this.deleteMessagesRow = i10;
                int i12 = i11 + 1;
                this.rowCount = i12;
                this.banUsersRow = i11;
                int i13 = i12 + 1;
                this.rowCount = i13;
                this.addUsersRow = i12;
                int i14 = i13 + 1;
                this.rowCount = i14;
                this.pinMessagesRow = i13;
                int i15 = i14 + 1;
                this.rowCount = i15;
                this.postLiveRow = i14;
                this.rowCount = i15 + 1;
                this.addAdminsRow = i15;
            }
        } else if (i2 == 1) {
            int i16 = 3 + 1;
            this.rowCount = i16;
            this.sendMessagesRow = 3;
            int i17 = i16 + 1;
            this.rowCount = i17;
            this.sendForwardedMessagesRow = i16;
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.sendMediaRow = i17;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.sendStickersRow = i18;
            int i20 = i19 + 1;
            this.rowCount = i20;
            this.embedLinksRow = i19;
            int i21 = i20 + 1;
            this.rowCount = i21;
            this.addUsersRow = i20;
            int i22 = i21 + 1;
            this.rowCount = i22;
            this.viewParticipantsRow = i21;
            int i23 = i22 + 1;
            this.rowCount = i23;
            this.untilSectionRow = i22;
            this.rowCount = i23 + 1;
            this.untilDateRow = i23;
        }
        if (this.canEdit) {
            if (!this.isChannel && i2 == 0) {
                int i24 = this.rowCount;
                this.rowCount = i24 + 1;
                this.rightsShadowRow = i24;
            }
            if (this.initialIsSet) {
                if (this.rightsShadowRow == -1) {
                    int i25 = this.rowCount;
                    this.rowCount = i25 + 1;
                    this.rightsShadowRow = i25;
                }
                int i26 = this.rowCount;
                int i27 = i26 + 1;
                this.rowCount = i27;
                this.removeAdminRow = i26;
                this.rowCount = i27 + 1;
                this.removeAdminShadowRow = i27;
            }
        } else if (i2 == 0) {
            if (!this.isChannel && i2 == 0 && (!this.currentRank.isEmpty() || (this.currentChat.creator && UserObject.isUserSelf(this.currentUser)))) {
                int i28 = this.rowCount;
                this.rowCount = i28 + 1;
                this.rightsShadowRow = i28;
                if (!this.currentChat.creator || !UserObject.isUserSelf(this.currentUser)) {
                    int i29 = this.rowCount;
                    this.rowCount = i29 + 1;
                    this.cantEditInfoRow = i29;
                }
            } else {
                int i30 = this.rowCount;
                this.rowCount = i30 + 1;
                this.cantEditInfoRow = i30;
            }
        } else {
            int i31 = this.rowCount;
            this.rowCount = i31 + 1;
            this.rightsShadowRow = i31;
        }
        if (update) {
            if (iMin == -1 && (i = this.transferOwnerShadowRow) != -1) {
                this.listViewAdapter.notifyItemRangeInserted(Math.min(i, this.transferOwnerRow), 2);
            } else {
                if (iMin == -1 || this.transferOwnerShadowRow != -1) {
                    return;
                }
                this.listViewAdapter.notifyItemRangeRemoved(iMin, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if (r0.codePointCount(0, r0.length()) > 16) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDonePressed() {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatRightsEditActivity.onDonePressed():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDonePressed$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDonePressed$15$ChatRightsEditActivity(long j) {
        if (j != 0) {
            this.chatId = j;
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(j));
            onDonePressed();
        }
    }

    public void setDelegate(ChatRightsEditActivityDelegate channelRightsEditActivityDelegate) {
        this.delegate = channelRightsEditActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        boolean zEquals;
        if (this.currentType == 1) {
            zEquals = this.currentBannedRights.equals(ChatObject.getBannedRightsString(this.bannedRights));
        } else {
            zEquals = this.initialRank.equals(this.currentRank);
        }
        if (!(!zEquals)) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("UserRestrictionsApplyChanges", R.string.UserRestrictionsApplyChanges));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("UserRestrictionsApplyChangesText", R.string.UserRestrictionsApplyChangesText, MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.chatId)).title)));
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$-4mm7xSGqiV9N2WSBPwWCsu8UDA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$16$ChatRightsEditActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$wvxRqh0aP2dYr5djEamJKWaTVVA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$17$ChatRightsEditActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$16$ChatRightsEditActivity(DialogInterface dialogInterface, int i) {
        onDonePressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$17$ChatRightsEditActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextLeft(View cell) {
        if (cell instanceof HeaderCell) {
            HeaderCell headerCell = (HeaderCell) cell;
            String str = this.currentRank;
            int iCodePointCount = 16 - (str != null ? str.codePointCount(0, str.length()) : 0);
            if (iCodePointCount <= 4.8f) {
                headerCell.setText2(String.format("%d", Integer.valueOf(iCodePointCount)));
                SimpleTextView textView2 = headerCell.getTextView2();
                String str2 = iCodePointCount < 0 ? "windowBackgroundWhiteRedText5" : "windowBackgroundWhiteGrayText3";
                textView2.setTextColor(Theme.getColor(str2));
                textView2.setTag(str2);
                return;
            }
            headerCell.setText2("");
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return checkDiscard();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private boolean ignoreTextChange;
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if ((ChatRightsEditActivity.this.currentChat.creator && ChatRightsEditActivity.this.currentType == 0 && itemViewType == 4 && holder.getAdapterPosition() == ChatRightsEditActivity.this.anonymousRow) || itemViewType == 0) {
                return true;
            }
            if (!ChatRightsEditActivity.this.canEdit) {
                return false;
            }
            if (ChatRightsEditActivity.this.currentType == 0 && itemViewType == 4) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition == ChatRightsEditActivity.this.changeInfoRow) {
                    return ChatRightsEditActivity.this.myAdminRights.change_info;
                }
                if (adapterPosition == ChatRightsEditActivity.this.postMessagesRow) {
                    return ChatRightsEditActivity.this.myAdminRights.post_messages;
                }
                if (adapterPosition == ChatRightsEditActivity.this.editMesagesRow) {
                    return ChatRightsEditActivity.this.myAdminRights.edit_messages;
                }
                if (adapterPosition == ChatRightsEditActivity.this.deleteMessagesRow) {
                    return ChatRightsEditActivity.this.myAdminRights.delete_messages;
                }
                if (adapterPosition == ChatRightsEditActivity.this.startVoiceChatRow) {
                    return ChatRightsEditActivity.this.myAdminRights.manage_call;
                }
                if (adapterPosition == ChatRightsEditActivity.this.addAdminsRow) {
                    return ChatRightsEditActivity.this.myAdminRights.add_admins;
                }
                if (adapterPosition == ChatRightsEditActivity.this.anonymousRow) {
                    return ChatRightsEditActivity.this.myAdminRights.anonymous;
                }
                if (adapterPosition == ChatRightsEditActivity.this.banUsersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.ban_users;
                }
                if (adapterPosition == ChatRightsEditActivity.this.addUsersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.invite_users;
                }
                if (adapterPosition == ChatRightsEditActivity.this.pinMessagesRow) {
                    return ChatRightsEditActivity.this.myAdminRights.pin_messages;
                }
                if (adapterPosition == ChatRightsEditActivity.this.postLiveRow) {
                    return ChatRightsEditActivity.this.myAdminRights.post_live;
                }
            }
            return (itemViewType == 3 || itemViewType == 1 || itemViewType == 5) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatRightsEditActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            switch (i) {
                case 0:
                    View userCell2 = new UserCell2(this.mContext, 4, 0);
                    userCell2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = userCell2;
                    break;
                case 1:
                    View textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    shadowSectionCell = textInfoPrivacyCell;
                    break;
                case 2:
                    View textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textSettingsCell;
                    break;
                case 3:
                    View headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 21, 15, true);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = headerCell;
                    break;
                case 4:
                    View textCheckCell2 = new TextCheckCell2(this.mContext);
                    textCheckCell2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textCheckCell2;
                    break;
                case 5:
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    break;
                case 6:
                    View textDetailCell = new TextDetailCell(this.mContext);
                    textDetailCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textDetailCell;
                    break;
                default:
                    PollEditTextCell pollEditTextCell = new PollEditTextCell(this.mContext, null);
                    pollEditTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: ir.eitaa.ui.ChatRightsEditActivity.ListAdapter.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            if (ListAdapter.this.ignoreTextChange) {
                                return;
                            }
                            ChatRightsEditActivity.this.currentRank = s.toString();
                            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChatRightsEditActivity.this.listView.findViewHolderForAdapterPosition(ChatRightsEditActivity.this.rankHeaderRow);
                            if (viewHolderFindViewHolderForAdapterPosition != null) {
                                ChatRightsEditActivity.this.setTextLeft(viewHolderFindViewHolderForAdapterPosition.itemView);
                            }
                        }
                    });
                    shadowSectionCell = pollEditTextCell;
                    break;
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws IOException {
            String string;
            String string2;
            String string3;
            boolean z = false;
            switch (holder.getItemViewType()) {
                case 0:
                    ((UserCell2) holder.itemView).setData(ChatRightsEditActivity.this.currentUser, null, null, 0);
                    break;
                case 1:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position != ChatRightsEditActivity.this.cantEditInfoRow) {
                        if (position == ChatRightsEditActivity.this.rankInfoRow) {
                            if (UserObject.isUserSelf(ChatRightsEditActivity.this.currentUser) && ChatRightsEditActivity.this.currentChat.creator) {
                                string = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                            } else {
                                string = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                            }
                            textInfoPrivacyCell.setText(LocaleController.formatString("EditAdminRankInfo", R.string.EditAdminRankInfo, string));
                            break;
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("EditAdminCantEdit", R.string.EditAdminCantEdit));
                        break;
                    }
                    break;
                case 2:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    if (position != ChatRightsEditActivity.this.removeAdminRow) {
                        if (position == ChatRightsEditActivity.this.transferOwnerRow) {
                            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                            textSettingsCell.setTag("windowBackgroundWhiteBlackText");
                            if (ChatRightsEditActivity.this.isChannel) {
                                textSettingsCell.setText(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer), false);
                                break;
                            } else {
                                textSettingsCell.setText(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer), false);
                                break;
                            }
                        }
                    } else {
                        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText5"));
                        textSettingsCell.setTag("windowBackgroundWhiteRedText5");
                        if (ChatRightsEditActivity.this.currentType != 0) {
                            if (ChatRightsEditActivity.this.currentType == 1) {
                                textSettingsCell.setText(LocaleController.getString("UserRestrictionsBlock", R.string.UserRestrictionsBlock), false);
                                break;
                            }
                        } else {
                            textSettingsCell.setText(LocaleController.getString("EditAdminRemoveAdmin", R.string.EditAdminRemoveAdmin), false);
                            break;
                        }
                    }
                    break;
                case 3:
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position == 2) {
                        if (ChatRightsEditActivity.this.currentType != 0) {
                            if (ChatRightsEditActivity.this.currentType == 1) {
                                headerCell.setText(LocaleController.getString("UserRestrictionsCanDo", R.string.UserRestrictionsCanDo));
                                break;
                            }
                        } else {
                            headerCell.setText(LocaleController.getString("EditAdminWhatCanDo", R.string.EditAdminWhatCanDo));
                            break;
                        }
                    } else if (position == ChatRightsEditActivity.this.rankHeaderRow) {
                        headerCell.setText(LocaleController.getString("EditAdminRank", R.string.EditAdminRank));
                        break;
                    }
                    break;
                case 4:
                    TextCheckCell2 textCheckCell2 = (TextCheckCell2) holder.itemView;
                    int i = ChatRightsEditActivity.this.changeInfoRow;
                    int i2 = R.drawable.permission_locked;
                    if (position == i) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            if (ChatRightsEditActivity.this.isChannel) {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminChangeChannelInfo", R.string.EditAdminChangeChannelInfo), ChatRightsEditActivity.this.adminRights.change_info, true);
                            } else {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminChangeGroupInfo", R.string.EditAdminChangeGroupInfo), ChatRightsEditActivity.this.adminRights.change_info, true);
                            }
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsChangeInfo", R.string.UserRestrictionsChangeInfo), (ChatRightsEditActivity.this.bannedRights.change_info || ChatRightsEditActivity.this.defaultBannedRights.change_info) ? false : true, false);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.change_info) {
                                i2 = 0;
                            }
                            textCheckCell2.setIcon(i2);
                        }
                    } else if (position == ChatRightsEditActivity.this.postMessagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminPostMessages", R.string.EditAdminPostMessages), ChatRightsEditActivity.this.adminRights.post_messages, true);
                    } else if (position == ChatRightsEditActivity.this.editMesagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminEditMessages", R.string.EditAdminEditMessages), ChatRightsEditActivity.this.adminRights.edit_messages, true);
                    } else if (position == ChatRightsEditActivity.this.deleteMessagesRow) {
                        if (ChatRightsEditActivity.this.isChannel) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminDeleteMessages", R.string.EditAdminDeleteMessages), ChatRightsEditActivity.this.adminRights.delete_messages, true);
                        } else {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminGroupDeleteMessages", R.string.EditAdminGroupDeleteMessages), ChatRightsEditActivity.this.adminRights.delete_messages, true);
                        }
                    } else if (position == ChatRightsEditActivity.this.addAdminsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddAdmins", R.string.EditAdminAddAdmins), ChatRightsEditActivity.this.adminRights.add_admins, ChatRightsEditActivity.this.anonymousRow != -1);
                    } else if (position == ChatRightsEditActivity.this.postLiveRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("LivePermission", R.string.LivePermission), ChatRightsEditActivity.this.adminRights.post_live, true);
                    } else if (position == ChatRightsEditActivity.this.anonymousRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminSendAnonymously", R.string.EditAdminSendAnonymously), ChatRightsEditActivity.this.adminRights.anonymous, false);
                    } else if (position == ChatRightsEditActivity.this.banUsersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminBanUsers", R.string.EditAdminBanUsers), ChatRightsEditActivity.this.adminRights.ban_users, true);
                    } else if (position == ChatRightsEditActivity.this.viewParticipantsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsViewParticipants", R.string.UserRestrictionsViewParticipants), (ChatRightsEditActivity.this.bannedRights.view_participants || ChatRightsEditActivity.this.defaultBannedRights.view_participants) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.view_participants) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.startVoiceChatRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("StartVoipChatPermission", R.string.StartVoipChatPermission), ChatRightsEditActivity.this.adminRights.manage_call, true);
                    } else if (position == ChatRightsEditActivity.this.addUsersRow) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            if (ChatRightsEditActivity.this.isMegagroup) {
                                if (ChatObject.isActionBannedByDefault(ChatRightsEditActivity.this.currentChat, 3)) {
                                    textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddUsers", R.string.EditAdminAddUsers), ChatRightsEditActivity.this.adminRights.invite_users, true);
                                } else {
                                    textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddUsersViaLink", R.string.EditAdminAddUsersViaLink), ChatRightsEditActivity.this.adminRights.invite_users, true);
                                }
                            } else {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddUsers", R.string.EditAdminAddRemoveUsers), ChatRightsEditActivity.this.adminRights.invite_users, true);
                            }
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsInviteUsers", R.string.UserRestrictionsInviteUsers), (ChatRightsEditActivity.this.bannedRights.invite_users || ChatRightsEditActivity.this.defaultBannedRights.invite_users) ? false : true, true);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.invite_users) {
                                i2 = 0;
                            }
                            textCheckCell2.setIcon(i2);
                        }
                    } else if (position == ChatRightsEditActivity.this.pinMessagesRow) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminPinMessages", R.string.EditAdminPinMessages), ChatRightsEditActivity.this.adminRights.pin_messages, true);
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsPinMessages", R.string.UserRestrictionsPinMessages), (ChatRightsEditActivity.this.bannedRights.pin_messages || ChatRightsEditActivity.this.defaultBannedRights.pin_messages) ? false : true, true);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.pin_messages) {
                                i2 = 0;
                            }
                            textCheckCell2.setIcon(i2);
                        }
                    } else if (position == ChatRightsEditActivity.this.sendMessagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSend", R.string.UserRestrictionsSend), (ChatRightsEditActivity.this.bannedRights.send_messages || ChatRightsEditActivity.this.defaultBannedRights.send_messages) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_messages) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.sendForwardedMessagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsForwarded", R.string.UserRestrictionsForwarded), (ChatRightsEditActivity.this.bannedRights.send_forwarded_messages || ChatRightsEditActivity.this.defaultBannedRights.send_forwarded_messages) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_forwarded_messages) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.sendMediaRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendMedia", R.string.UserRestrictionsSendMedia), (ChatRightsEditActivity.this.bannedRights.send_media || ChatRightsEditActivity.this.defaultBannedRights.send_media) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_media) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.sendStickersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendStickers", R.string.UserRestrictionsSendStickers), (ChatRightsEditActivity.this.bannedRights.send_stickers || ChatRightsEditActivity.this.defaultBannedRights.send_stickers) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_stickers) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.embedLinksRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsEmbedLinks", R.string.UserRestrictionsEmbedLinks), (ChatRightsEditActivity.this.bannedRights.embed_links || ChatRightsEditActivity.this.defaultBannedRights.embed_links) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.embed_links) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    } else if (position == ChatRightsEditActivity.this.sendPollsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendPolls", R.string.UserRestrictionsSendPolls), (ChatRightsEditActivity.this.bannedRights.send_polls || ChatRightsEditActivity.this.defaultBannedRights.send_polls) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_polls) {
                            i2 = 0;
                        }
                        textCheckCell2.setIcon(i2);
                    }
                    if (position == ChatRightsEditActivity.this.sendMediaRow || position == ChatRightsEditActivity.this.sendStickersRow || position == ChatRightsEditActivity.this.embedLinksRow || position == ChatRightsEditActivity.this.sendPollsRow || position == ChatRightsEditActivity.this.sendForwardedMessagesRow) {
                        if (!ChatRightsEditActivity.this.bannedRights.send_messages && !ChatRightsEditActivity.this.bannedRights.view_messages && !ChatRightsEditActivity.this.defaultBannedRights.send_messages && !ChatRightsEditActivity.this.defaultBannedRights.view_messages) {
                            z = true;
                        }
                        textCheckCell2.setEnabled(z);
                        break;
                    } else if (position == ChatRightsEditActivity.this.sendMessagesRow) {
                        if (!ChatRightsEditActivity.this.bannedRights.view_messages && !ChatRightsEditActivity.this.defaultBannedRights.view_messages) {
                            z = true;
                        }
                        textCheckCell2.setEnabled(z);
                        break;
                    }
                    break;
                case 5:
                    ShadowSectionCell shadowSectionCell = (ShadowSectionCell) holder.itemView;
                    int i3 = ChatRightsEditActivity.this.rightsShadowRow;
                    int i4 = R.drawable.greydivider;
                    if (position != i3) {
                        if (position != ChatRightsEditActivity.this.removeAdminShadowRow) {
                            if (position == ChatRightsEditActivity.this.rankInfoRow) {
                                Context context = this.mContext;
                                if (!ChatRightsEditActivity.this.canEdit) {
                                    i4 = R.drawable.greydivider_bottom;
                                }
                                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context, i4, "windowBackgroundGrayShadow"));
                                break;
                            } else {
                                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                break;
                            }
                        } else {
                            shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            break;
                        }
                    } else {
                        Context context2 = this.mContext;
                        if (ChatRightsEditActivity.this.removeAdminRow == -1 && ChatRightsEditActivity.this.rankRow == -1) {
                            i4 = R.drawable.greydivider_bottom;
                        }
                        shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context2, i4, "windowBackgroundGrayShadow"));
                        break;
                    }
                    break;
                case 6:
                    TextDetailCell textDetailCell = (TextDetailCell) holder.itemView;
                    if (position == ChatRightsEditActivity.this.untilDateRow) {
                        if (ChatRightsEditActivity.this.bannedRights.until_date != 0 && Math.abs(ChatRightsEditActivity.this.bannedRights.until_date - (System.currentTimeMillis() / 1000)) <= 315360000) {
                            string2 = LocaleController.formatDateForBan(ChatRightsEditActivity.this.bannedRights.until_date);
                        } else {
                            string2 = LocaleController.getString("UserRestrictionsUntilForever", R.string.UserRestrictionsUntilForever);
                        }
                        textDetailCell.setTextAndValue(LocaleController.getString("UserRestrictionsDuration", R.string.UserRestrictionsDuration), string2, false);
                        break;
                    }
                    break;
                case 7:
                    PollEditTextCell pollEditTextCell = (PollEditTextCell) holder.itemView;
                    if (UserObject.isUserSelf(ChatRightsEditActivity.this.currentUser) && ChatRightsEditActivity.this.currentChat.creator) {
                        string3 = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                    } else {
                        string3 = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                    }
                    this.ignoreTextChange = true;
                    pollEditTextCell.getTextView().setEnabled(ChatRightsEditActivity.this.canEdit || ChatRightsEditActivity.this.currentChat.creator);
                    pollEditTextCell.getTextView().setSingleLine(true);
                    pollEditTextCell.getTextView().setImeOptions(6);
                    pollEditTextCell.setTextAndHint(ChatRightsEditActivity.this.currentRank, string3, false);
                    this.ignoreTextChange = false;
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getAdapterPosition() == ChatRightsEditActivity.this.rankHeaderRow) {
                ChatRightsEditActivity.this.setTextLeft(holder.itemView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            if (holder.getAdapterPosition() != ChatRightsEditActivity.this.rankRow || ChatRightsEditActivity.this.getParentActivity() == null) {
                return;
            }
            AndroidUtilities.hideKeyboard(ChatRightsEditActivity.this.getParentActivity().getCurrentFocus());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 0;
            }
            if (position == 1 || position == ChatRightsEditActivity.this.rightsShadowRow || position == ChatRightsEditActivity.this.removeAdminShadowRow || position == ChatRightsEditActivity.this.untilSectionRow || position == ChatRightsEditActivity.this.transferOwnerShadowRow) {
                return 5;
            }
            if (position == 2 || position == ChatRightsEditActivity.this.rankHeaderRow) {
                return 3;
            }
            if (position == ChatRightsEditActivity.this.changeInfoRow || position == ChatRightsEditActivity.this.postMessagesRow || position == ChatRightsEditActivity.this.editMesagesRow || position == ChatRightsEditActivity.this.deleteMessagesRow || position == ChatRightsEditActivity.this.addAdminsRow || position == ChatRightsEditActivity.this.banUsersRow || position == ChatRightsEditActivity.this.addUsersRow || position == ChatRightsEditActivity.this.pinMessagesRow || position == ChatRightsEditActivity.this.sendMessagesRow || position == ChatRightsEditActivity.this.sendForwardedMessagesRow || position == ChatRightsEditActivity.this.sendMediaRow || position == ChatRightsEditActivity.this.sendStickersRow || position == ChatRightsEditActivity.this.embedLinksRow || position == ChatRightsEditActivity.this.sendPollsRow || position == ChatRightsEditActivity.this.anonymousRow || position == ChatRightsEditActivity.this.startVoiceChatRow || position == ChatRightsEditActivity.this.postLiveRow || position == ChatRightsEditActivity.this.viewParticipantsRow) {
                return 4;
            }
            if (position == ChatRightsEditActivity.this.cantEditInfoRow || position == ChatRightsEditActivity.this.rankInfoRow) {
                return 1;
            }
            if (position == ChatRightsEditActivity.this.untilDateRow) {
                return 6;
            }
            return position == ChatRightsEditActivity.this.rankRow ? 7 : 2;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatRightsEditActivity$uQ9MC-NwH3XllCVr8_8vVBE3qSo
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$18$ChatRightsEditActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{UserCell2.class, TextSettingsCell.class, TextCheckCell2.class, HeaderCell.class, TextDetailCell.class, PollEditTextCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switch2Track"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switch2TrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{DialogRadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{DialogRadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogTextGray2"));
        arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOX, new Class[]{DialogRadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogRadioBackground"));
        arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{DialogRadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogRadioBackgroundChecked"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$18$ChatRightsEditActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell2) {
                    ((UserCell2) childAt).update(0);
                }
            }
        }
    }
}
