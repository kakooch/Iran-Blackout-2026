package org.rbmain.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.Chat;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.util.ArrayList;
import java.util.Calendar;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$InputCheckPasswordSRP;
import org.rbmain.tgnet.TLRPC$TL_channels_editCreator;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputChannel;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.DialogRadioCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.PollEditTextCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell2;
import org.rbmain.ui.Cells.TextDetailCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Cells.UserCell2;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class ChatRightsEditActivity extends BaseFragment {
    private int addAdminsRow;
    private int addUsersRow;
    private TLRPC$TL_chatAdminRights adminRights;
    private int anonymousRow;
    private int banUsersRow;
    private TLRPC$TL_chatBannedRights bannedRights;
    private boolean canEdit;
    private int cantEditInfoRow;
    private int changeAccessRow;
    private int changeInfoRow;
    private int chatId;
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
    private int inviteUsersRow;
    private boolean isAddingNew;
    private boolean isChannel;
    private boolean isEditAdmin;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private TLRPC$TL_chatAdminRights myAdminRights;
    private int pinMessagesRow;
    private int postMessagesRow;
    private int rankHeaderRow;
    private int rankInfoRow;
    private int rankRow;
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
    private int viewAdminsRow;
    private int viewMembersRow;

    public interface ChatRightsEditActivityDelegate {
        void didSetRights(int i, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$1(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$3(DialogInterface dialogInterface, int i) {
    }

    public ChatRightsEditActivity(int i, int i2, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str, int i3, boolean z, boolean z2) {
        this.currentBannedRights = BuildConfig.FLAVOR;
        this.isAddingNew = z2;
        this.chatId = i2;
        this.currentUser = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i));
        this.currentType = i3;
        this.canEdit = z;
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.chatId));
        this.currentChat = chat;
        str = str == null ? BuildConfig.FLAVOR : str;
        this.currentRank = str;
        this.initialRank = str;
        boolean z3 = true;
        if (chat != null) {
            this.isChannel = ChatObject.isChannel(chat) && !this.currentChat.megagroup;
            this.myAdminRights = this.currentChat.admin_rights;
        }
        if (this.myAdminRights == null) {
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = new TLRPC$TL_chatAdminRights();
            this.myAdminRights = tLRPC$TL_chatAdminRights2;
            tLRPC$TL_chatAdminRights2.view_admins = true;
            tLRPC$TL_chatAdminRights2.view_members = true;
            tLRPC$TL_chatAdminRights2.add_users = true;
            tLRPC$TL_chatAdminRights2.change_access = true;
            tLRPC$TL_chatAdminRights2.manage_call = true;
            tLRPC$TL_chatAdminRights2.add_admins = true;
            tLRPC$TL_chatAdminRights2.pin_messages = true;
            tLRPC$TL_chatAdminRights2.invite_users = true;
            tLRPC$TL_chatAdminRights2.ban_users = true;
            tLRPC$TL_chatAdminRights2.delete_messages = true;
            tLRPC$TL_chatAdminRights2.edit_messages = true;
            tLRPC$TL_chatAdminRights2.post_messages = true;
            tLRPC$TL_chatAdminRights2.change_info = true;
        }
        if (i3 == 0) {
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3 = new TLRPC$TL_chatAdminRights();
            this.adminRights = tLRPC$TL_chatAdminRights3;
            if (tLRPC$TL_chatAdminRights == null) {
                this.isEditAdmin = false;
                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights4 = this.myAdminRights;
                tLRPC$TL_chatAdminRights3.change_info = tLRPC$TL_chatAdminRights4.change_info;
                tLRPC$TL_chatAdminRights3.post_messages = tLRPC$TL_chatAdminRights4.post_messages;
                tLRPC$TL_chatAdminRights3.edit_messages = tLRPC$TL_chatAdminRights4.edit_messages;
                tLRPC$TL_chatAdminRights3.delete_messages = tLRPC$TL_chatAdminRights4.delete_messages;
                tLRPC$TL_chatAdminRights3.manage_call = tLRPC$TL_chatAdminRights4.manage_call;
                tLRPC$TL_chatAdminRights3.ban_users = tLRPC$TL_chatAdminRights4.ban_users;
                tLRPC$TL_chatAdminRights3.invite_users = tLRPC$TL_chatAdminRights4.invite_users;
                tLRPC$TL_chatAdminRights3.pin_messages = tLRPC$TL_chatAdminRights4.pin_messages;
                boolean z4 = tLRPC$TL_chatAdminRights4.pin_messages;
                tLRPC$TL_chatAdminRights3.add_users = z4;
                tLRPC$TL_chatAdminRights3.view_members = z4;
                tLRPC$TL_chatAdminRights3.view_admins = z4;
                this.initialIsSet = false;
            } else {
                this.isEditAdmin = true;
                boolean z5 = tLRPC$TL_chatAdminRights.change_info;
                tLRPC$TL_chatAdminRights3.change_info = z5;
                boolean z6 = tLRPC$TL_chatAdminRights.post_messages;
                tLRPC$TL_chatAdminRights3.post_messages = z6;
                boolean z7 = tLRPC$TL_chatAdminRights.edit_messages;
                tLRPC$TL_chatAdminRights3.edit_messages = z7;
                boolean z8 = tLRPC$TL_chatAdminRights.delete_messages;
                tLRPC$TL_chatAdminRights3.delete_messages = z8;
                boolean z9 = tLRPC$TL_chatAdminRights.manage_call;
                tLRPC$TL_chatAdminRights3.manage_call = z9;
                boolean z10 = tLRPC$TL_chatAdminRights.ban_users;
                tLRPC$TL_chatAdminRights3.ban_users = z10;
                boolean z11 = tLRPC$TL_chatAdminRights.invite_users;
                tLRPC$TL_chatAdminRights3.invite_users = z11;
                tLRPC$TL_chatAdminRights3.add_users = tLRPC$TL_chatAdminRights.add_users;
                tLRPC$TL_chatAdminRights3.view_members = tLRPC$TL_chatAdminRights.view_members;
                tLRPC$TL_chatAdminRights3.view_admins = tLRPC$TL_chatAdminRights.view_admins;
                boolean z12 = tLRPC$TL_chatAdminRights.pin_messages;
                tLRPC$TL_chatAdminRights3.pin_messages = z12;
                boolean z13 = tLRPC$TL_chatAdminRights.add_admins;
                tLRPC$TL_chatAdminRights3.add_admins = z13;
                boolean z14 = tLRPC$TL_chatAdminRights.anonymous;
                tLRPC$TL_chatAdminRights3.anonymous = z14;
                boolean z15 = tLRPC$TL_chatAdminRights.change_access;
                tLRPC$TL_chatAdminRights3.change_access = z15;
                if (!z5 && !z6 && !z7 && !z8 && !z10 && !z11 && !z12 && !z13 && !z9 && !z14 && !z15) {
                    z3 = false;
                }
                this.initialIsSet = z3;
            }
        } else {
            this.defaultBannedRights = tLRPC$TL_chatBannedRights;
            if (tLRPC$TL_chatBannedRights == null) {
                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = new TLRPC$TL_chatBannedRights();
                this.defaultBannedRights = tLRPC$TL_chatBannedRights3;
                tLRPC$TL_chatBannedRights3.pin_messages = false;
                tLRPC$TL_chatBannedRights3.change_info = false;
                tLRPC$TL_chatBannedRights3.invite_users = false;
                tLRPC$TL_chatBannedRights3.send_polls = false;
                tLRPC$TL_chatBannedRights3.send_inline = false;
                tLRPC$TL_chatBannedRights3.send_games = false;
                tLRPC$TL_chatBannedRights3.send_gifs = false;
                tLRPC$TL_chatBannedRights3.send_stickers = false;
                tLRPC$TL_chatBannedRights3.embed_links = false;
                tLRPC$TL_chatBannedRights3.send_messages = false;
                tLRPC$TL_chatBannedRights3.send_media = false;
                tLRPC$TL_chatBannedRights3.view_messages = false;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights4 = new TLRPC$TL_chatBannedRights();
            this.bannedRights = tLRPC$TL_chatBannedRights4;
            if (tLRPC$TL_chatBannedRights2 == null) {
                tLRPC$TL_chatBannedRights4.pin_messages = false;
                tLRPC$TL_chatBannedRights4.change_info = false;
                tLRPC$TL_chatBannedRights4.invite_users = false;
                tLRPC$TL_chatBannedRights4.send_polls = false;
                tLRPC$TL_chatBannedRights4.send_inline = false;
                tLRPC$TL_chatBannedRights4.send_games = false;
                tLRPC$TL_chatBannedRights4.send_gifs = false;
                tLRPC$TL_chatBannedRights4.send_stickers = false;
                tLRPC$TL_chatBannedRights4.embed_links = false;
                tLRPC$TL_chatBannedRights4.send_messages = false;
                tLRPC$TL_chatBannedRights4.send_media = false;
                tLRPC$TL_chatBannedRights4.view_messages = false;
            } else {
                tLRPC$TL_chatBannedRights4.view_messages = tLRPC$TL_chatBannedRights2.view_messages;
                tLRPC$TL_chatBannedRights4.send_messages = tLRPC$TL_chatBannedRights2.send_messages;
                tLRPC$TL_chatBannedRights4.send_media = tLRPC$TL_chatBannedRights2.send_media;
                tLRPC$TL_chatBannedRights4.send_stickers = tLRPC$TL_chatBannedRights2.send_stickers;
                tLRPC$TL_chatBannedRights4.send_gifs = tLRPC$TL_chatBannedRights2.send_gifs;
                tLRPC$TL_chatBannedRights4.send_games = tLRPC$TL_chatBannedRights2.send_games;
                tLRPC$TL_chatBannedRights4.send_inline = tLRPC$TL_chatBannedRights2.send_inline;
                tLRPC$TL_chatBannedRights4.embed_links = tLRPC$TL_chatBannedRights2.embed_links;
                tLRPC$TL_chatBannedRights4.send_polls = tLRPC$TL_chatBannedRights2.send_polls;
                tLRPC$TL_chatBannedRights4.invite_users = tLRPC$TL_chatBannedRights2.invite_users;
                tLRPC$TL_chatBannedRights4.change_info = tLRPC$TL_chatBannedRights2.change_info;
                tLRPC$TL_chatBannedRights4.pin_messages = tLRPC$TL_chatBannedRights2.pin_messages;
                tLRPC$TL_chatBannedRights4.until_date = tLRPC$TL_chatBannedRights2.until_date;
            }
            TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights5 = this.defaultBannedRights;
            if (tLRPC$TL_chatBannedRights5.view_messages) {
                tLRPC$TL_chatBannedRights4.view_messages = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_messages) {
                tLRPC$TL_chatBannedRights4.send_messages = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_media) {
                tLRPC$TL_chatBannedRights4.send_media = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_stickers) {
                tLRPC$TL_chatBannedRights4.send_stickers = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_gifs) {
                tLRPC$TL_chatBannedRights4.send_gifs = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_games) {
                tLRPC$TL_chatBannedRights4.send_games = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_inline) {
                tLRPC$TL_chatBannedRights4.send_inline = true;
            }
            if (tLRPC$TL_chatBannedRights5.embed_links) {
                tLRPC$TL_chatBannedRights4.embed_links = true;
            }
            if (tLRPC$TL_chatBannedRights5.send_polls) {
                tLRPC$TL_chatBannedRights4.send_polls = true;
            }
            if (tLRPC$TL_chatBannedRights5.invite_users) {
                tLRPC$TL_chatBannedRights4.invite_users = true;
            }
            if (tLRPC$TL_chatBannedRights5.change_info) {
                tLRPC$TL_chatBannedRights4.change_info = true;
            }
            if (tLRPC$TL_chatBannedRights5.pin_messages) {
                tLRPC$TL_chatBannedRights4.pin_messages = true;
            }
            this.currentBannedRights = ChatObject.getBannedRightsString(tLRPC$TL_chatBannedRights4);
            if (tLRPC$TL_chatBannedRights2 != null && tLRPC$TL_chatBannedRights2.view_messages) {
                z3 = false;
            }
            this.initialIsSet = z3;
        }
        updateRows(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("EditAdmin", R.string.EditAdmin));
        } else {
            this.actionBar.setTitle(LocaleController.getString("UserRestrictions", R.string.UserRestrictions));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChatRightsEditActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    if (ChatRightsEditActivity.this.checkDiscard()) {
                        ChatRightsEditActivity.this.finishFragment();
                    }
                } else if (i == 1) {
                    ChatRightsEditActivity.this.onDonePressed();
                }
            }
        });
        if (this.canEdit || (!this.isChannel && this.currentChat.creator && UserObject.isUserSelf(this.currentUser))) {
            this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
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
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ChatRightsEditActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(ChatRightsEditActivity.this.getParentActivity().getCurrentFocus());
                }
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda14
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i) {
                this.f$0.lambda$createView$6(context, view2, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(Context context, View view, int i) {
        String string;
        if (this.canEdit || (this.currentChat.creator && this.currentType == 0 && i == this.anonymousRow)) {
            if (i == 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("user_id", this.currentUser.id);
                presentFragment(new ProfileActivity(bundle));
                return;
            }
            if (i == this.removeAdminRow) {
                int i2 = this.currentType;
                if (i2 == 0) {
                    MessagesController.getInstance(this.currentAccount).setUserAdminRole(this.chatId, this.currentUser, new TLRPC$TL_chatAdminRights(), this.currentRank, this.isChannel, getFragmentForAlert(0), this.isAddingNew, true);
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
                    onDonePressed();
                    return;
                }
                return;
            }
            if (i == this.transferOwnerRow) {
                initTransfer(null, null);
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
                HeaderCell headerCell = new HeaderCell(context, Theme.key_dialogTextBlue2, 23, 15, false);
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
                    bottomSheetCellArr[i3].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$5(builder, view2);
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
                    } else {
                        int i4 = this.postMessagesRow;
                        if (i == i4) {
                            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = this.adminRights;
                            boolean z = !tLRPC$TL_chatAdminRights.post_messages;
                            tLRPC$TL_chatAdminRights.post_messages = z;
                            if (!z) {
                                tLRPC$TL_chatAdminRights.edit_messages = false;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.editMesagesRow);
                                if (viewHolderFindViewHolderForAdapterPosition != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition.itemView).setChecked(this.adminRights.edit_messages);
                                }
                            }
                        } else if (i == this.editMesagesRow) {
                            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = this.adminRights;
                            boolean z2 = !tLRPC$TL_chatAdminRights2.edit_messages;
                            tLRPC$TL_chatAdminRights2.edit_messages = z2;
                            if (z2) {
                                tLRPC$TL_chatAdminRights2.post_messages = true;
                                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(i4);
                                if (viewHolderFindViewHolderForAdapterPosition2 != null) {
                                    ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition2.itemView).setChecked(this.adminRights.post_messages);
                                }
                            }
                        } else if (i == this.deleteMessagesRow) {
                            this.adminRights.delete_messages = !r12.delete_messages;
                        } else {
                            int i5 = this.addAdminsRow;
                            if (i == i5) {
                                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3 = this.adminRights;
                                boolean z3 = !tLRPC$TL_chatAdminRights3.add_admins;
                                tLRPC$TL_chatAdminRights3.add_admins = z3;
                                if (z3) {
                                    tLRPC$TL_chatAdminRights3.view_members = true;
                                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition3 = this.listView.findViewHolderForAdapterPosition(this.viewMembersRow);
                                    if (viewHolderFindViewHolderForAdapterPosition3 != null) {
                                        ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition3.itemView).setChecked(this.adminRights.view_members);
                                    }
                                }
                            } else if (i == this.anonymousRow) {
                                this.adminRights.anonymous = !r12.anonymous;
                            } else if (i == this.changeAccessRow) {
                                this.adminRights.change_access = !r12.change_access;
                            } else if (i == this.banUsersRow) {
                                this.adminRights.ban_users = !r12.ban_users;
                            } else if (i == this.startVoiceChatRow) {
                                this.adminRights.manage_call = !r12.manage_call;
                            } else if (i == this.addUsersRow) {
                                this.adminRights.add_users = !r12.add_users;
                            } else if (i == this.viewMembersRow) {
                                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights4 = this.adminRights;
                                boolean z4 = !tLRPC$TL_chatAdminRights4.view_members;
                                tLRPC$TL_chatAdminRights4.view_members = z4;
                                if (!z4) {
                                    tLRPC$TL_chatAdminRights4.add_admins = false;
                                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition4 = this.listView.findViewHolderForAdapterPosition(i5);
                                    if (viewHolderFindViewHolderForAdapterPosition4 != null) {
                                        ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition4.itemView).setChecked(this.adminRights.add_admins);
                                    }
                                }
                            } else if (i == this.viewAdminsRow) {
                                this.adminRights.view_admins = !r12.view_admins;
                            } else if (i == this.inviteUsersRow) {
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
                            } else if (this.bannedRights != null) {
                                boolean z5 = !textCheckCell2.isChecked();
                                int i6 = this.sendMessagesRow;
                                if (i == i6) {
                                    this.bannedRights.send_messages = !r14.send_messages;
                                } else if (i == this.sendMediaRow) {
                                    this.bannedRights.send_media = !r14.send_media;
                                } else if (i == this.sendStickersRow) {
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = this.bannedRights;
                                    boolean z6 = !tLRPC$TL_chatBannedRights2.send_stickers;
                                    tLRPC$TL_chatBannedRights2.send_inline = z6;
                                    tLRPC$TL_chatBannedRights2.send_gifs = z6;
                                    tLRPC$TL_chatBannedRights2.send_games = z6;
                                    tLRPC$TL_chatBannedRights2.send_stickers = z6;
                                } else if (i == this.embedLinksRow) {
                                    this.bannedRights.embed_links = !r14.embed_links;
                                } else if (i == this.sendPollsRow) {
                                    this.bannedRights.send_polls = !r14.send_polls;
                                }
                                if (z5) {
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights3 = this.bannedRights;
                                    if (tLRPC$TL_chatBannedRights3.view_messages && !tLRPC$TL_chatBannedRights3.send_messages) {
                                        tLRPC$TL_chatBannedRights3.send_messages = true;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition5 = this.listView.findViewHolderForAdapterPosition(i6);
                                        if (viewHolderFindViewHolderForAdapterPosition5 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition5.itemView).setChecked(false);
                                        }
                                    }
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights4 = this.bannedRights;
                                    if ((tLRPC$TL_chatBannedRights4.view_messages || tLRPC$TL_chatBannedRights4.send_messages) && !tLRPC$TL_chatBannedRights4.send_media) {
                                        tLRPC$TL_chatBannedRights4.send_media = true;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition6 = this.listView.findViewHolderForAdapterPosition(this.sendMediaRow);
                                        if (viewHolderFindViewHolderForAdapterPosition6 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition6.itemView).setChecked(false);
                                        }
                                    }
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights5 = this.bannedRights;
                                    if ((tLRPC$TL_chatBannedRights5.view_messages || tLRPC$TL_chatBannedRights5.send_messages) && !tLRPC$TL_chatBannedRights5.send_polls) {
                                        tLRPC$TL_chatBannedRights5.send_polls = true;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition7 = this.listView.findViewHolderForAdapterPosition(this.sendPollsRow);
                                        if (viewHolderFindViewHolderForAdapterPosition7 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition7.itemView).setChecked(false);
                                        }
                                    }
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights6 = this.bannedRights;
                                    if ((tLRPC$TL_chatBannedRights6.view_messages || tLRPC$TL_chatBannedRights6.send_messages) && !tLRPC$TL_chatBannedRights6.send_stickers) {
                                        tLRPC$TL_chatBannedRights6.send_inline = true;
                                        tLRPC$TL_chatBannedRights6.send_gifs = true;
                                        tLRPC$TL_chatBannedRights6.send_games = true;
                                        tLRPC$TL_chatBannedRights6.send_stickers = true;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition8 = this.listView.findViewHolderForAdapterPosition(this.sendStickersRow);
                                        if (viewHolderFindViewHolderForAdapterPosition8 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition8.itemView).setChecked(false);
                                        }
                                    }
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights7 = this.bannedRights;
                                    if ((tLRPC$TL_chatBannedRights7.view_messages || tLRPC$TL_chatBannedRights7.send_messages) && !tLRPC$TL_chatBannedRights7.embed_links) {
                                        tLRPC$TL_chatBannedRights7.embed_links = true;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition9 = this.listView.findViewHolderForAdapterPosition(this.embedLinksRow);
                                        if (viewHolderFindViewHolderForAdapterPosition9 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition9.itemView).setChecked(false);
                                        }
                                    }
                                } else {
                                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights8 = this.bannedRights;
                                    boolean z7 = tLRPC$TL_chatBannedRights8.send_messages;
                                    if ((!z7 || !tLRPC$TL_chatBannedRights8.embed_links || !tLRPC$TL_chatBannedRights8.send_inline || !tLRPC$TL_chatBannedRights8.send_media || !tLRPC$TL_chatBannedRights8.send_polls) && tLRPC$TL_chatBannedRights8.view_messages) {
                                        tLRPC$TL_chatBannedRights8.view_messages = false;
                                    }
                                    if ((!tLRPC$TL_chatBannedRights8.embed_links || !tLRPC$TL_chatBannedRights8.send_inline || !tLRPC$TL_chatBannedRights8.send_media || !tLRPC$TL_chatBannedRights8.send_polls) && z7) {
                                        tLRPC$TL_chatBannedRights8.send_messages = false;
                                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition10 = this.listView.findViewHolderForAdapterPosition(i6);
                                        if (viewHolderFindViewHolderForAdapterPosition10 != null) {
                                            ((TextCheckCell2) viewHolderFindViewHolderForAdapterPosition10.itemView).setChecked(true);
                                        }
                                    }
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
    public /* synthetic */ void lambda$createView$5(BottomSheet.Builder builder, View view) {
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
            Calendar calendar = Calendar.getInstance();
            try {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getParentActivity(), new DatePickerDialog.OnDateSetListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda0
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        this.f$0.lambda$createView$2(datePicker, i, i2, i3);
                    }
                }, calendar.get(1), calendar.get(2), calendar.get(5));
                final DatePicker datePicker = datePickerDialog.getDatePicker();
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
                datePickerDialog.setButton(-1, LocaleController.getString("Set", R.string.Set), datePickerDialog);
                datePickerDialog.setButton(-2, LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChatRightsEditActivity.lambda$createView$3(dialogInterface, i);
                    }
                });
                if (Build.VERSION.SDK_INT >= 21) {
                    datePickerDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda8
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            ChatRightsEditActivity.lambda$createView$4(datePicker, dialogInterface);
                        }
                    });
                }
                showDialog(datePickerDialog);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(i, i2, i3);
        final int time = (int) (calendar.getTime().getTime() / 1000);
        try {
            TimePickerDialog timePickerDialog = new TimePickerDialog(getParentActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda1
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i4, int i5) {
                    this.f$0.lambda$createView$0(time, timePicker, i4, i5);
                }
            }, 0, 0, true);
            timePickerDialog.setButton(-1, LocaleController.getString("Set", R.string.Set), timePickerDialog);
            timePickerDialog.setButton(-2, LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda6
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
    public /* synthetic */ void lambda$createView$0(int i, TimePicker timePicker, int i2, int i3) {
        this.bannedRights.until_date = i + (i2 * 3600) + (i3 * 60);
        this.listViewAdapter.notifyItemChanged(this.untilDateRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$4(DatePicker datePicker, DialogInterface dialogInterface) {
        int childCount = datePicker.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = datePicker.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = -1;
            childAt.setLayoutParams(layoutParams);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    private void initTransfer(TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, TwoStepVerificationActivity twoStepVerificationActivity) {
        if (getParentActivity() == null) {
            return;
        }
        final TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator = new TLRPC$TL_channels_editCreator();
        TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        tLRPC$TL_channels_editCreator.channel = tLRPC$TL_inputChannel;
        tLRPC$TL_inputChannel.channel_id = this.currentChat.id;
        tLRPC$TL_channels_editCreator.user_id = getMessagesController().getInputUser(this.currentUser);
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().getPendingObjectOwner(tLRPC$TL_channels_editCreator, new RequestDelegate() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda12
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$initTransfer$9(tLRPC$TL_channels_editCreator, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTransfer$9(final TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initTransfer$8(tLRPC$TL_error, tLRPC$TL_channels_editCreator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTransfer$8(TLRPC$TL_error tLRPC$TL_error, final TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator) {
        if (tLRPC$TL_error != null) {
            if (getParentActivity() != null && "exist_pending_owner".equals(tLRPC$TL_error.text)) {
                showExistPendingOwnerDialog();
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (this.isChannel) {
            builder.setTitle(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer));
        } else {
            builder.setTitle(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer));
        }
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("EditAdminTransferReadyAlertText", R.string.EditAdminTransferReadyAlertText, this.currentChat.title, UserObject.getFirstName(this.currentUser))));
        builder.setPositiveButton(LocaleController.getString("EditAdminTransferChangeOwner", R.string.EditAdminTransferChangeOwner), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$initTransfer$7(tLRPC$TL_channels_editCreator, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTransfer$7(TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator, DialogInterface dialogInterface, int i) {
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 1);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().requestChangeObjectOwner(this.currentChat.id, tLRPC$TL_channels_editCreator.user_id.user_id, new RequestDelegate() { // from class: org.rbmain.ui.ChatRightsEditActivity.3
            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatRightsEditActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        alertDialog.dismiss();
                        if (tLRPC$TL_error == null) {
                            ChatRightsEditActivity.this.showRequestChangeOwnerDialog();
                        } else if (ChatRightsEditActivity.this.getParentActivity() != null && "exist_pending_owner".equals(tLRPC$TL_error.text)) {
                            ChatRightsEditActivity.this.showExistPendingOwnerDialog();
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showExistPendingOwnerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (this.isChannel) {
            builder.setTitle(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer));
        } else {
            builder.setTitle(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer));
        }
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("requestChangeCreatorExist", R.string.RequestChangeCreatorExist, new Object[0])));
        builder.setPositiveButton(LocaleController.getString("CancelChangeOwnerRequest", R.string.CancelChangeOwnerRequest), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showExistPendingOwnerDialog$10(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showExistPendingOwnerDialog$10(DialogInterface dialogInterface, int i) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().cancelChangeObjectOwner(-this.currentChat.id, new RequestDelegate(this) { // from class: org.rbmain.ui.ChatRightsEditActivity.4
            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRequestChangeOwnerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (this.isChannel) {
            builder.setTitle(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer));
        } else {
            builder.setTitle(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer));
        }
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("pendingRequestChangeCreator", R.string.PendingRequestChangeCreator, new Object[0])));
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), null);
        showDialog(builder.create());
    }

    private void updateRows(boolean z) {
        int i;
        TLRPC$Chat tLRPC$Chat;
        int iMin = Math.min(this.transferOwnerShadowRow, this.transferOwnerRow);
        this.changeInfoRow = -1;
        this.postMessagesRow = -1;
        this.editMesagesRow = -1;
        this.deleteMessagesRow = -1;
        this.addAdminsRow = -1;
        this.anonymousRow = -1;
        this.changeAccessRow = -1;
        this.banUsersRow = -1;
        this.inviteUsersRow = -1;
        this.addUsersRow = -1;
        this.viewMembersRow = -1;
        this.viewAdminsRow = -1;
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
                this.inviteUsersRow = i6;
                int i8 = i7 + 1;
                this.rowCount = i8;
                this.addUsersRow = i7;
                int i9 = i8 + 1;
                this.rowCount = i9;
                this.viewMembersRow = i8;
                int i10 = i9 + 1;
                this.rowCount = i10;
                this.viewAdminsRow = i9;
                int i11 = i10 + 1;
                this.rowCount = i11;
                this.pinMessagesRow = i10;
                this.rowCount = i11 + 1;
                this.addAdminsRow = i11;
            } else {
                int i12 = 3 + 1;
                this.rowCount = i12;
                this.changeInfoRow = 3;
                int i13 = i12 + 1;
                this.rowCount = i13;
                this.deleteMessagesRow = i12;
                int i14 = i13 + 1;
                this.rowCount = i14;
                this.banUsersRow = i13;
                int i15 = i14 + 1;
                this.rowCount = i15;
                this.inviteUsersRow = i14;
                int i16 = i15 + 1;
                this.rowCount = i16;
                this.pinMessagesRow = i15;
                int i17 = i16 + 1;
                this.rowCount = i17;
                this.addAdminsRow = i16;
                this.rowCount = i17 + 1;
                this.changeAccessRow = i17;
            }
        } else if (i2 == 1) {
            int i18 = 3 + 1;
            this.rowCount = i18;
            this.sendMessagesRow = 3;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.sendMediaRow = i18;
            int i20 = i19 + 1;
            this.rowCount = i20;
            this.sendStickersRow = i19;
            int i21 = i20 + 1;
            this.rowCount = i21;
            this.sendPollsRow = i20;
            int i22 = i21 + 1;
            this.rowCount = i22;
            this.embedLinksRow = i21;
            int i23 = i22 + 1;
            this.rowCount = i23;
            this.inviteUsersRow = i22;
            int i24 = i23 + 1;
            this.rowCount = i24;
            this.pinMessagesRow = i23;
            int i25 = i24 + 1;
            this.rowCount = i25;
            this.changeInfoRow = i24;
            int i26 = i25 + 1;
            this.rowCount = i26;
            this.untilSectionRow = i25;
            this.rowCount = i26 + 1;
            this.untilDateRow = i26;
        }
        if (this.canEdit) {
            if (!this.isChannel && i2 == 0) {
                int i27 = this.rowCount;
                int i28 = i27 + 1;
                this.rowCount = i28;
                this.rightsShadowRow = i27;
                int i29 = i28 + 1;
                this.rowCount = i29;
                this.rankHeaderRow = i28;
                int i30 = i29 + 1;
                this.rowCount = i30;
                this.rankRow = i29;
                this.rowCount = i30 + 1;
                this.rankInfoRow = i30;
            }
            if (this.isEditAdmin && (tLRPC$Chat = this.currentChat) != null && tLRPC$Chat.accessEnumHashSet.contains(Chat.ChatAccessEnum.RemoveObject) && this.currentType == 0 && !this.currentUser.bot) {
                int i31 = this.rightsShadowRow;
                if (i31 == -1) {
                    int i32 = this.rowCount;
                    this.rowCount = i32 + 1;
                    this.transferOwnerShadowRow = i32;
                }
                int i33 = this.rowCount;
                int i34 = i33 + 1;
                this.rowCount = i34;
                this.transferOwnerRow = i33;
                if (i31 != -1) {
                    this.rowCount = i34 + 1;
                    this.transferOwnerShadowRow = i34;
                }
            }
            if (this.initialIsSet || this.isEditAdmin) {
                if (this.rightsShadowRow == -1) {
                    int i35 = this.rowCount;
                    this.rowCount = i35 + 1;
                    this.rightsShadowRow = i35;
                }
                int i36 = this.rowCount;
                int i37 = i36 + 1;
                this.rowCount = i37;
                this.removeAdminRow = i36;
                this.rowCount = i37 + 1;
                this.removeAdminShadowRow = i37;
            }
        } else if (i2 == 0) {
            if (!this.isChannel && i2 == 0 && (!this.currentRank.isEmpty() || (this.currentChat.creator && UserObject.isUserSelf(this.currentUser)))) {
                int i38 = this.rowCount;
                int i39 = i38 + 1;
                this.rowCount = i39;
                this.rightsShadowRow = i38;
                int i40 = i39 + 1;
                this.rowCount = i40;
                this.rankHeaderRow = i39;
                this.rowCount = i40 + 1;
                this.rankRow = i40;
                if (this.currentChat.creator && UserObject.isUserSelf(this.currentUser)) {
                    int i41 = this.rowCount;
                    this.rowCount = i41 + 1;
                    this.rankInfoRow = i41;
                } else {
                    int i42 = this.rowCount;
                    this.rowCount = i42 + 1;
                    this.cantEditInfoRow = i42;
                }
            } else {
                int i43 = this.rowCount;
                this.rowCount = i43 + 1;
                this.cantEditInfoRow = i43;
            }
        } else {
            int i44 = this.rowCount;
            this.rowCount = i44 + 1;
            this.rightsShadowRow = i44;
        }
        if (z) {
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
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatRightsEditActivity.onDonePressed():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDonePressed$11(int i) {
        if (i != 0) {
            this.chatId = i;
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
            onDonePressed();
        }
    }

    public void setDelegate(ChatRightsEditActivityDelegate chatRightsEditActivityDelegate) {
        this.delegate = chatRightsEditActivityDelegate;
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
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("UserRestrictionsApplyChangesText", R.string.UserRestrictionsApplyChangesText, MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.chatId)).title)));
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$12(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$13(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$12(DialogInterface dialogInterface, int i) {
        onDonePressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$13(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextLeft(View view) {
        if (view instanceof HeaderCell) {
            HeaderCell headerCell = (HeaderCell) view;
            String str = this.currentRank;
            int iCodePointCount = 16 - (str != null ? str.codePointCount(0, str.length()) : 0);
            if (iCodePointCount <= 4.8f) {
                headerCell.setText2(String.format("%d", Integer.valueOf(iCodePointCount)));
                SimpleTextView textView2 = headerCell.getTextView2();
                int i = iCodePointCount < 0 ? Theme.key_text_RedRegular : Theme.key_windowBackgroundWhiteGrayText3;
                textView2.setTextColor(Theme.getColor(i));
                textView2.setTag(Integer.valueOf(i));
                return;
            }
            headerCell.setText2(BuildConfig.FLAVOR);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return checkDiscard();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private boolean ignoreTextChange;
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (ChatRightsEditActivity.this.currentChat.creator && ChatRightsEditActivity.this.currentType == 0 && itemViewType == 4 && viewHolder.getAdapterPosition() == ChatRightsEditActivity.this.anonymousRow) {
                return true;
            }
            if (!ChatRightsEditActivity.this.canEdit) {
                return false;
            }
            if (ChatRightsEditActivity.this.currentType == 0 && itemViewType == 4) {
                int adapterPosition = viewHolder.getAdapterPosition();
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
                if (adapterPosition == ChatRightsEditActivity.this.changeAccessRow) {
                    return ChatRightsEditActivity.this.myAdminRights.change_access;
                }
                if (adapterPosition == ChatRightsEditActivity.this.anonymousRow) {
                    return ChatRightsEditActivity.this.myAdminRights.anonymous;
                }
                if (adapterPosition == ChatRightsEditActivity.this.banUsersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.ban_users;
                }
                if (adapterPosition == ChatRightsEditActivity.this.inviteUsersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.invite_users;
                }
                if (adapterPosition == ChatRightsEditActivity.this.addUsersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.add_users;
                }
                if (adapterPosition == ChatRightsEditActivity.this.viewMembersRow) {
                    return ChatRightsEditActivity.this.myAdminRights.view_members;
                }
                if (adapterPosition == ChatRightsEditActivity.this.viewAdminsRow) {
                    return ChatRightsEditActivity.this.myAdminRights.view_admins;
                }
                if (adapterPosition == ChatRightsEditActivity.this.pinMessagesRow) {
                    return ChatRightsEditActivity.this.myAdminRights.pin_messages;
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
                    userCell2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = userCell2;
                    break;
                case 1:
                    View textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    shadowSectionCell = textInfoPrivacyCell;
                    break;
                case 2:
                    View textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = textSettingsCell;
                    break;
                case 3:
                    View headerCell = new HeaderCell(this.mContext, Theme.key_windowBackgroundWhiteBlueHeader, 21, 15, true);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = headerCell;
                    break;
                case 4:
                    View textCheckCell2 = new TextCheckCell2(this.mContext);
                    textCheckCell2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = textCheckCell2;
                    break;
                case 5:
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    break;
                case 6:
                    View textDetailCell = new TextDetailCell(this.mContext);
                    textDetailCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = textDetailCell;
                    break;
                default:
                    PollEditTextCell pollEditTextCell = new PollEditTextCell(this.mContext, null);
                    pollEditTextCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    pollEditTextCell.getTextView().setFilters(InputFilterHelper.getFilter(16, 1, pollEditTextCell.getTextView()));
                    pollEditTextCell.addTextWatcher(new TextWatcher() { // from class: org.rbmain.ui.ChatRightsEditActivity.ListAdapter.1
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            if (ListAdapter.this.ignoreTextChange) {
                                return;
                            }
                            ChatRightsEditActivity.this.currentRank = editable.toString();
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String string2;
            String string3;
            boolean z = false;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    ((UserCell2) viewHolder.itemView).setData(ChatRightsEditActivity.this.currentUser, null, null, 0);
                    break;
                case 1:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (i != ChatRightsEditActivity.this.cantEditInfoRow) {
                        if (i == ChatRightsEditActivity.this.rankInfoRow) {
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
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    if (i != ChatRightsEditActivity.this.removeAdminRow) {
                        if (i == ChatRightsEditActivity.this.transferOwnerRow) {
                            int i2 = Theme.key_windowBackgroundWhiteBlackText;
                            textSettingsCell.setTextColor(Theme.getColor(i2));
                            textSettingsCell.setTag(Integer.valueOf(i2));
                            if (ChatRightsEditActivity.this.isChannel) {
                                textSettingsCell.setText(LocaleController.getString("EditAdminChannelTransfer", R.string.EditAdminChannelTransfer), false);
                                break;
                            } else {
                                textSettingsCell.setText(LocaleController.getString("EditAdminGroupTransfer", R.string.EditAdminGroupTransfer), false);
                                break;
                            }
                        }
                    } else {
                        int i3 = Theme.key_text_RedRegular;
                        textSettingsCell.setTextColor(Theme.getColor(i3));
                        textSettingsCell.setTag(Integer.valueOf(i3));
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
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i == 2) {
                        if (ChatRightsEditActivity.this.currentType != 0) {
                            if (ChatRightsEditActivity.this.currentType == 1) {
                                headerCell.setText(LocaleController.getString("UserRestrictionsCanDo", R.string.UserRestrictionsCanDo));
                                break;
                            }
                        } else {
                            headerCell.setText(LocaleController.getString("EditAdminWhatCanDo", R.string.EditAdminWhatCanDo));
                            break;
                        }
                    } else if (i == ChatRightsEditActivity.this.rankHeaderRow) {
                        headerCell.setText(LocaleController.getString("EditAdminRank", R.string.EditAdminRank));
                        break;
                    }
                    break;
                case 4:
                    TextCheckCell2 textCheckCell2 = (TextCheckCell2) viewHolder.itemView;
                    int i4 = ChatRightsEditActivity.this.changeInfoRow;
                    int i5 = R.drawable.permission_locked;
                    if (i == i4) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            if (ChatRightsEditActivity.this.isChannel) {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminChangeChannelInfo", R.string.EditAdminChangeChannelInfo), ChatRightsEditActivity.this.adminRights.change_info, true);
                            } else {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminChangeGroupInfo", R.string.EditAdminChangeGroupInfo), ChatRightsEditActivity.this.adminRights.change_info, true);
                            }
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsChangeInfo", R.string.UserRestrictionsChangeInfo), (ChatRightsEditActivity.this.bannedRights.change_info || ChatRightsEditActivity.this.defaultBannedRights.change_info) ? false : true, false);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.change_info) {
                                i5 = 0;
                            }
                            textCheckCell2.setIcon(i5);
                        }
                    } else if (i == ChatRightsEditActivity.this.postMessagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminPostMessages", R.string.EditAdminPostMessages), ChatRightsEditActivity.this.adminRights.post_messages, true);
                    } else if (i == ChatRightsEditActivity.this.editMesagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminEditMessages", R.string.EditAdminEditMessages), ChatRightsEditActivity.this.adminRights.edit_messages, true);
                    } else if (i == ChatRightsEditActivity.this.deleteMessagesRow) {
                        if (ChatRightsEditActivity.this.isChannel) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminDeleteMessages", R.string.EditAdminDeleteMessages), ChatRightsEditActivity.this.adminRights.delete_messages, true);
                        } else {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminGroupDeleteMessages", R.string.EditAdminGroupDeleteMessages), ChatRightsEditActivity.this.adminRights.delete_messages, true);
                        }
                    } else if (i == ChatRightsEditActivity.this.addAdminsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddAdmins", R.string.EditAdminAddAdmins), ChatRightsEditActivity.this.adminRights.add_admins, ChatRightsEditActivity.this.changeAccessRow != -1);
                    } else if (i == ChatRightsEditActivity.this.changeAccessRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminChangeMemberAccess", R.string.EditAdminChangeMemberAccess), ChatRightsEditActivity.this.adminRights.change_access, ChatRightsEditActivity.this.anonymousRow != -1);
                    } else if (i == ChatRightsEditActivity.this.anonymousRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminSendAnonymously", R.string.EditAdminSendAnonymously), ChatRightsEditActivity.this.adminRights.anonymous, false);
                    } else if (i == ChatRightsEditActivity.this.banUsersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminBanUsers", R.string.EditAdminBanUsers), ChatRightsEditActivity.this.adminRights.ban_users, true);
                    } else if (i == ChatRightsEditActivity.this.startVoiceChatRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("StartVoipChatPermission", R.string.StartVoipChatPermission), ChatRightsEditActivity.this.adminRights.manage_call, true);
                    } else if (i == ChatRightsEditActivity.this.addUsersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsInviteUsers", R.string.UserRestrictionsInviteUsers), ChatRightsEditActivity.this.adminRights.add_users, true);
                    } else if (i == ChatRightsEditActivity.this.viewMembersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsViewUsers", R.string.UserRestrictionsViewUsers), ChatRightsEditActivity.this.adminRights.view_members, true);
                    } else if (i == ChatRightsEditActivity.this.viewAdminsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsViewAdmins", R.string.UserRestrictionsViewAdmins), ChatRightsEditActivity.this.adminRights.view_admins, true);
                    } else if (i == ChatRightsEditActivity.this.inviteUsersRow) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            if (ChatObject.isActionBannedByDefault(ChatRightsEditActivity.this.currentChat, 3)) {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddUsers", R.string.EditAdminAddUsers), ChatRightsEditActivity.this.adminRights.invite_users, true);
                            } else {
                                textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminAddUsersViaLink", R.string.EditAdminAddUsersViaLink), ChatRightsEditActivity.this.adminRights.invite_users, true);
                            }
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsInviteUsers", R.string.UserRestrictionsInviteUsers), (ChatRightsEditActivity.this.bannedRights.invite_users || ChatRightsEditActivity.this.defaultBannedRights.invite_users) ? false : true, true);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.invite_users) {
                                i5 = 0;
                            }
                            textCheckCell2.setIcon(i5);
                        }
                    } else if (i == ChatRightsEditActivity.this.pinMessagesRow) {
                        if (ChatRightsEditActivity.this.currentType == 0) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("EditAdminPinMessages", R.string.EditAdminPinMessages), ChatRightsEditActivity.this.adminRights.pin_messages, true);
                        } else if (ChatRightsEditActivity.this.currentType == 1) {
                            textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsPinMessages", R.string.UserRestrictionsPinMessages), (ChatRightsEditActivity.this.bannedRights.pin_messages || ChatRightsEditActivity.this.defaultBannedRights.pin_messages) ? false : true, true);
                            if (!ChatRightsEditActivity.this.defaultBannedRights.pin_messages) {
                                i5 = 0;
                            }
                            textCheckCell2.setIcon(i5);
                        }
                    } else if (i == ChatRightsEditActivity.this.sendMessagesRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSend", R.string.UserRestrictionsSend), (ChatRightsEditActivity.this.bannedRights.send_messages || ChatRightsEditActivity.this.defaultBannedRights.send_messages) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_messages) {
                            i5 = 0;
                        }
                        textCheckCell2.setIcon(i5);
                    } else if (i == ChatRightsEditActivity.this.sendMediaRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendMedia", R.string.UserRestrictionsSendMedia), (ChatRightsEditActivity.this.bannedRights.send_media || ChatRightsEditActivity.this.defaultBannedRights.send_media) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_media) {
                            i5 = 0;
                        }
                        textCheckCell2.setIcon(i5);
                    } else if (i == ChatRightsEditActivity.this.sendStickersRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendStickers", R.string.UserRestrictionsSendStickers), (ChatRightsEditActivity.this.bannedRights.send_stickers || ChatRightsEditActivity.this.defaultBannedRights.send_stickers) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_stickers) {
                            i5 = 0;
                        }
                        textCheckCell2.setIcon(i5);
                    } else if (i == ChatRightsEditActivity.this.embedLinksRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsEmbedLinks", R.string.UserRestrictionsEmbedLinks), (ChatRightsEditActivity.this.bannedRights.embed_links || ChatRightsEditActivity.this.defaultBannedRights.embed_links) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.embed_links) {
                            i5 = 0;
                        }
                        textCheckCell2.setIcon(i5);
                    } else if (i == ChatRightsEditActivity.this.sendPollsRow) {
                        textCheckCell2.setTextAndCheck(LocaleController.getString("UserRestrictionsSendPolls", R.string.UserRestrictionsSendPolls), (ChatRightsEditActivity.this.bannedRights.send_polls || ChatRightsEditActivity.this.defaultBannedRights.send_polls) ? false : true, true);
                        if (!ChatRightsEditActivity.this.defaultBannedRights.send_polls) {
                            i5 = 0;
                        }
                        textCheckCell2.setIcon(i5);
                    }
                    if (i == ChatRightsEditActivity.this.sendMediaRow || i == ChatRightsEditActivity.this.sendStickersRow || i == ChatRightsEditActivity.this.embedLinksRow || i == ChatRightsEditActivity.this.sendPollsRow) {
                        if (!ChatRightsEditActivity.this.bannedRights.send_messages && !ChatRightsEditActivity.this.bannedRights.view_messages && !ChatRightsEditActivity.this.defaultBannedRights.send_messages && !ChatRightsEditActivity.this.defaultBannedRights.view_messages) {
                            z = true;
                        }
                        textCheckCell2.setEnabled(z);
                        break;
                    } else if (i == ChatRightsEditActivity.this.sendMessagesRow) {
                        if (!ChatRightsEditActivity.this.bannedRights.view_messages && !ChatRightsEditActivity.this.defaultBannedRights.view_messages) {
                            z = true;
                        }
                        textCheckCell2.setEnabled(z);
                        break;
                    }
                    break;
                case 5:
                    ShadowSectionCell shadowSectionCell = (ShadowSectionCell) viewHolder.itemView;
                    int i6 = ChatRightsEditActivity.this.rightsShadowRow;
                    int i7 = R.drawable.greydivider;
                    if (i != i6) {
                        if (i != ChatRightsEditActivity.this.removeAdminShadowRow) {
                            if (i == ChatRightsEditActivity.this.rankInfoRow) {
                                Context context = this.mContext;
                                if (!ChatRightsEditActivity.this.canEdit) {
                                    i7 = R.drawable.greydivider_bottom;
                                }
                                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context, i7, Theme.key_windowBackgroundGrayShadow));
                                break;
                            } else {
                                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                break;
                            }
                        } else {
                            shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                            break;
                        }
                    } else {
                        Context context2 = this.mContext;
                        if (ChatRightsEditActivity.this.removeAdminRow == -1 && ChatRightsEditActivity.this.rankRow == -1) {
                            i7 = R.drawable.greydivider_bottom;
                        }
                        shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context2, i7, Theme.key_windowBackgroundGrayShadow));
                        break;
                    }
                    break;
                case 6:
                    TextDetailCell textDetailCell = (TextDetailCell) viewHolder.itemView;
                    if (i == ChatRightsEditActivity.this.untilDateRow) {
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
                    PollEditTextCell pollEditTextCell = (PollEditTextCell) viewHolder.itemView;
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
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getAdapterPosition() == ChatRightsEditActivity.this.rankHeaderRow) {
                ChatRightsEditActivity.this.setTextLeft(viewHolder.itemView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getAdapterPosition() != ChatRightsEditActivity.this.rankRow || ChatRightsEditActivity.this.getParentActivity() == null) {
                return;
            }
            AndroidUtilities.hideKeyboard(ChatRightsEditActivity.this.getParentActivity().getCurrentFocus());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 1 || i == ChatRightsEditActivity.this.rightsShadowRow || i == ChatRightsEditActivity.this.removeAdminShadowRow || i == ChatRightsEditActivity.this.untilSectionRow || i == ChatRightsEditActivity.this.transferOwnerShadowRow) {
                return 5;
            }
            if (i == 2 || i == ChatRightsEditActivity.this.rankHeaderRow) {
                return 3;
            }
            if (i == ChatRightsEditActivity.this.changeInfoRow || i == ChatRightsEditActivity.this.postMessagesRow || i == ChatRightsEditActivity.this.editMesagesRow || i == ChatRightsEditActivity.this.deleteMessagesRow || i == ChatRightsEditActivity.this.addAdminsRow || i == ChatRightsEditActivity.this.banUsersRow || i == ChatRightsEditActivity.this.addUsersRow || i == ChatRightsEditActivity.this.viewMembersRow || i == ChatRightsEditActivity.this.viewAdminsRow || i == ChatRightsEditActivity.this.inviteUsersRow || i == ChatRightsEditActivity.this.pinMessagesRow || i == ChatRightsEditActivity.this.sendMessagesRow || i == ChatRightsEditActivity.this.sendMediaRow || i == ChatRightsEditActivity.this.sendStickersRow || i == ChatRightsEditActivity.this.embedLinksRow || i == ChatRightsEditActivity.this.sendPollsRow || i == ChatRightsEditActivity.this.changeAccessRow || i == ChatRightsEditActivity.this.anonymousRow || i == ChatRightsEditActivity.this.startVoiceChatRow) {
                return 4;
            }
            if (i == ChatRightsEditActivity.this.cantEditInfoRow || i == ChatRightsEditActivity.this.rankInfoRow) {
                return 1;
            }
            if (i == ChatRightsEditActivity.this.untilDateRow) {
                return 6;
            }
            return i == ChatRightsEditActivity.this.rankRow ? 7 : 2;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChatRightsEditActivity$$ExternalSyntheticLambda13
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$14();
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{UserCell2.class, TextSettingsCell.class, TextCheckCell2.class, HeaderCell.class, TextDetailCell.class, PollEditTextCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        int i3 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        int i4 = Theme.key_text_RedRegular;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switch2Track));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell2.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switch2TrackChecked));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{HeaderCell.class}, new String[]{"textView2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{PollEditTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteHintText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{DialogRadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogTextBlack));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{DialogRadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogTextGray2));
        arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOX, new Class[]{DialogRadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogRadioBackground));
        arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{DialogRadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_dialogRadioBackgroundChecked));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$14() {
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
