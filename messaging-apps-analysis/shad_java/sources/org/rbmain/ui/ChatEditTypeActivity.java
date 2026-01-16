package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.Chat;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_channels_checkUsername;
import org.rbmain.tgnet.TLRPC$TL_channels_getAdminedPublicChannels;
import org.rbmain.tgnet.TLRPC$TL_channels_updateUsername;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputChannelEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_chats;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.AdminedChannelCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.RadioButtonCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.InviteLinkBottomSheet;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LinkActionView;

/* loaded from: classes4.dex */
public class ChatEditTypeActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ShadowSectionCell adminedInfoCell;
    private LinearLayout adminnedChannelsLayout;
    private boolean alreadyCheckedChannels;
    private int chatId;
    private int checkReqId;
    private Runnable checkRunnable;
    private TextInfoPrivacyCell checkTextView;
    private TLRPC$Chat currentChat;
    private ActionBarMenuItem doneButton;
    private EditTextBoldCursor editText;
    private HeaderCell headerCell;
    private HeaderCell headerCell2;
    private boolean ignoreTextChanges;
    private TLRPC$ChatFull info;
    private TextInfoPrivacyCell infoCell;
    private TLRPC$TL_chatInviteExported invite;
    private InviteLinkBottomSheet inviteLinkBottomSheet;
    private boolean isChannel;
    private boolean isCheckingChannels;
    private boolean isForcePrivate;
    private boolean isForcePublic;
    private boolean isPrivate;
    private String lastCheckName;
    private boolean lastNameAvailable;
    private LinearLayout linearLayout;
    private LinearLayout linearLayoutTypeContainer;
    private LinearLayout linkContainer;
    private LoadingCell loadingAdminedCell;
    private boolean loadingAdminedChannels;
    private TextInfoPrivacyCell manageLinksInfoCell;
    private TextCell manageLinksTextView;
    private LinkActionView permanentLinkView;
    private LinearLayout privateContainer;
    private LinearLayout publicContainer;
    private RadioButtonCell radioButtonCell1;
    private RadioButtonCell radioButtonCell2;
    private ShadowSectionCell sectionCell2;
    private TextSettingsCell textCell;
    private TextSettingsCell textCell2;
    private TextInfoPrivacyCell typeInfoCell;
    private EditTextBoldCursor usernameTextView;
    private boolean canCreatePublic = true;
    private ArrayList<AdminedChannelCell> adminedChannelCells = new ArrayList<>();
    HashMap<Integer, TLRPC$User> usersMap = new HashMap<>();
    private AlertDialog progressDialog = null;
    private boolean unset = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
    }

    public ChatEditTypeActivity(int i, boolean z, boolean z2) {
        this.chatId = i;
        this.isForcePublic = z;
        this.isForcePrivate = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            r9 = this;
            org.rbmain.messenger.MessagesController r0 = r9.getMessagesController()
            int r1 = r9.chatId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r9.currentChat = r0
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L4b
            org.rbmain.messenger.MessagesStorage r0 = r9.getMessagesStorage()
            int r3 = r9.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChatSync(r3)
            r9.currentChat = r0
            if (r0 == 0) goto L4a
            org.rbmain.messenger.MessagesController r0 = r9.getMessagesController()
            org.rbmain.tgnet.TLRPC$Chat r3 = r9.currentChat
            r0.putChat(r3, r1)
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r9.info
            if (r0 != 0) goto L4b
            org.rbmain.messenger.MessagesStorage r3 = r9.getMessagesStorage()
            int r4 = r9.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r5 = org.rbmain.messenger.ChatObject.isChannel(r0)
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
            r6.<init>(r1)
            r7 = 0
            r8 = 0
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r3.loadChatInfo(r4, r5, r6, r7, r8)
            r9.info = r0
            if (r0 != 0) goto L4b
        L4a:
            return r2
        L4b:
            boolean r0 = r9.isForcePrivate
            if (r0 != 0) goto L6e
            boolean r0 = r9.isForcePublic
            if (r0 != 0) goto L6c
            ir.aaap.messengercore.CoreMainClass r0 = r9.getCoreMainClass()
            androidMessenger.proxy.IdStorage r3 = androidMessenger.proxy.IdStorage.getInstance()
            org.rbmain.tgnet.TLRPC$Chat r4 = r9.currentChat
            int r4 = r4.id
            int r4 = -r4
            long r4 = (long) r4
            java.lang.String r3 = r3.getDialogId(r4)
            boolean r0 = r0.isChannelPrivate(r3)
            if (r0 == 0) goto L6c
            goto L6e
        L6c:
            r0 = 0
            goto L6f
        L6e:
            r0 = 1
        L6f:
            r9.isPrivate = r0
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r0 = org.rbmain.messenger.ChatObject.isChannel(r0)
            if (r0 == 0) goto L80
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r0 = r0.megagroup
            if (r0 != 0) goto L80
            goto L81
        L80:
            r1 = 0
        L81:
            r9.isChannel = r1
            r9.checkChannelsWithUsername()
            boolean r0 = r9.isPrivate
            if (r0 == 0) goto L99
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r9.info
            if (r0 == 0) goto L99
            org.rbmain.messenger.MessagesController r0 = r9.getMessagesController()
            int r1 = r9.chatId
            int r3 = r9.classGuid
            r0.loadFullChat(r1, r3, r2)
        L99:
            org.rbmain.messenger.NotificationCenter r0 = r9.getNotificationCenter()
            int r1 = org.rbmain.messenger.NotificationCenter.chatInfoDidLoad
            r0.addObserver(r9, r1)
            boolean r0 = super.onFragmentCreate()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatEditTypeActivity.onFragmentCreate():boolean");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        TLRPC$ChatFull tLRPC$ChatFull;
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        TextSettingsCell textSettingsCell = this.textCell2;
        if (textSettingsCell != null && (tLRPC$ChatFull = this.info) != null) {
            if (tLRPC$ChatFull.stickerset != null) {
                textSettingsCell.setTextAndValue(LocaleController.getString("GroupStickers", R.string.GroupStickers), this.info.stickerset.title, false);
            } else {
                textSettingsCell.setText(LocaleController.getString("GroupStickers", R.string.GroupStickers), false);
            }
        }
        TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
        if (tLRPC$ChatFull2 != null) {
            this.invite = tLRPC$ChatFull2.exported_invite;
            this.permanentLinkView.setUnSetLink(this.unset);
            LinkActionView linkActionView = this.permanentLinkView;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
            linkActionView.setLink(tLRPC$TL_chatInviteExported == null ? null : tLRPC$TL_chatInviteExported.link);
            this.permanentLinkView.loadUsers(this.invite, this.chatId);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyVisible() {
        EditTextBoldCursor editTextBoldCursor;
        super.onBecomeFullyVisible();
        if (!this.isForcePublic || (editTextBoldCursor = this.usernameTextView) == null) {
            return;
        }
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(this.usernameTextView);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChatEditTypeActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ChatEditTypeActivity.this.finishFragment();
                } else if (i == 1) {
                    ChatEditTypeActivity.this.processDone();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        ScrollView scrollView = new ScrollView(this, context) { // from class: org.rbmain.ui.ChatEditTypeActivity.2
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                rect.bottom += AndroidUtilities.dp(60.0f);
                return super.requestChildRectangleOnScreen(view, rect, z);
            }
        };
        this.fragmentView = scrollView;
        scrollView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        ScrollView scrollView2 = (ScrollView) this.fragmentView;
        scrollView2.setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        scrollView2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        this.linearLayout.setOrientation(1);
        if (this.isForcePublic) {
            this.actionBar.setTitle(LocaleController.getString("TypeLocationGroup", R.string.TypeLocationGroup));
        } else if (this.isChannel) {
            this.actionBar.setTitle(LocaleController.getString("ChannelSettingsTitle", R.string.ChannelSettingsTitle));
        } else {
            this.actionBar.setTitle(LocaleController.getString("GroupSettingsTitle", R.string.GroupSettingsTitle));
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.linearLayoutTypeContainer = linearLayout2;
        linearLayout2.setOrientation(1);
        LinearLayout linearLayout3 = this.linearLayoutTypeContainer;
        int i = Theme.key_windowBackgroundWhite;
        linearLayout3.setBackgroundColor(Theme.getColor(i));
        this.linearLayout.addView(this.linearLayoutTypeContainer, LayoutHelper.createLinear(-1, -2));
        HeaderCell headerCell = new HeaderCell(context, 23);
        this.headerCell2 = headerCell;
        headerCell.setHeight(46);
        if (this.isChannel) {
            this.headerCell2.setText(LocaleController.getString("ChannelTypeHeader", R.string.ChannelTypeHeader));
        } else {
            this.headerCell2.setText(LocaleController.getString("GroupTypeHeader", R.string.GroupTypeHeader));
        }
        this.linearLayoutTypeContainer.addView(this.headerCell2);
        RadioButtonCell radioButtonCell = new RadioButtonCell(context);
        this.radioButtonCell2 = radioButtonCell;
        radioButtonCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        if (this.isChannel) {
            this.radioButtonCell2.setTextAndValue(LocaleController.getString("ChannelPrivate", R.string.ChannelPrivate), LocaleController.getString("ChannelPrivateInfo", R.string.ChannelPrivateInfo), false, this.isPrivate);
        } else {
            this.radioButtonCell2.setTextAndValue(LocaleController.getString("MegaPrivate", R.string.MegaPrivate), LocaleController.getString("MegaPrivateInfo", R.string.MegaPrivateInfo), false, this.isPrivate);
        }
        this.linearLayoutTypeContainer.addView(this.radioButtonCell2, LayoutHelper.createLinear(-1, -2));
        this.radioButtonCell2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        RadioButtonCell radioButtonCell2 = new RadioButtonCell(context);
        this.radioButtonCell1 = radioButtonCell2;
        radioButtonCell2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        if (this.isChannel) {
            this.radioButtonCell1.setTextAndValue(LocaleController.getString("ChannelPublic", R.string.ChannelPublic), LocaleController.getString("ChannelPublicInfo", R.string.ChannelPublicInfo), false, !this.isPrivate);
        } else {
            this.radioButtonCell1.setTextAndValue(LocaleController.getString("MegaPublic", R.string.MegaPublic), LocaleController.getString("MegaPublicInfo", R.string.MegaPublicInfo), false, !this.isPrivate);
        }
        this.linearLayoutTypeContainer.addView(this.radioButtonCell1, LayoutHelper.createLinear(-1, -2));
        this.radioButtonCell1.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1(view);
            }
        });
        ShadowSectionCell shadowSectionCell = new ShadowSectionCell(context);
        this.sectionCell2 = shadowSectionCell;
        this.linearLayout.addView(shadowSectionCell, LayoutHelper.createLinear(-1, -2));
        if (this.isForcePublic) {
            this.radioButtonCell2.setVisibility(8);
            this.radioButtonCell1.setVisibility(8);
            this.sectionCell2.setVisibility(8);
            this.headerCell2.setVisibility(8);
        }
        if (this.isForcePrivate) {
            this.radioButtonCell2.setVisibility(8);
            this.radioButtonCell1.setVisibility(8);
            this.headerCell2.setVisibility(8);
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        this.linkContainer = linearLayout4;
        linearLayout4.setOrientation(1);
        this.linkContainer.setBackgroundColor(Theme.getColor(i));
        this.linearLayout.addView(this.linkContainer, LayoutHelper.createLinear(-1, -2));
        HeaderCell headerCell2 = new HeaderCell(context, 23);
        this.headerCell = headerCell2;
        this.linkContainer.addView(headerCell2);
        LinearLayout linearLayout5 = new LinearLayout(context);
        this.publicContainer = linearLayout5;
        linearLayout5.setOrientation(0);
        this.linkContainer.addView(this.publicContainer, LayoutHelper.createLinear(-1, 36, 23.0f, 7.0f, 23.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setText(getMessagesController().linkPrefix + "/");
        this.editText.setTextSize(1, 18.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.editText;
        int i2 = Theme.key_windowBackgroundWhiteHintText;
        editTextBoldCursor2.setHintTextColor(Theme.getColor(i2));
        EditTextBoldCursor editTextBoldCursor3 = this.editText;
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor3.setTextColor(Theme.getColor(i3));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setEnabled(false);
        this.editText.setBackgroundDrawable(null);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setSingleLine(true);
        this.editText.setInputType(163840);
        this.editText.setImeOptions(6);
        this.publicContainer.addView(this.editText, LayoutHelper.createLinear(-2, 36));
        EditTextBoldCursor editTextBoldCursor4 = new EditTextBoldCursor(context);
        this.usernameTextView = editTextBoldCursor4;
        editTextBoldCursor4.setTextSize(1, 18.0f);
        this.usernameTextView.setHintTextColor(Theme.getColor(i2));
        this.usernameTextView.setTextColor(Theme.getColor(i3));
        this.usernameTextView.setMaxLines(1);
        this.usernameTextView.setLines(1);
        this.usernameTextView.setBackgroundDrawable(null);
        this.usernameTextView.setPadding(0, 0, 0, 0);
        this.usernameTextView.setSingleLine(true);
        this.usernameTextView.setInputType(163872);
        this.usernameTextView.setImeOptions(6);
        this.usernameTextView.setHint(LocaleController.getString("ChannelUsernamePlaceholder", R.string.ChannelUsernamePlaceholder));
        this.usernameTextView.setCursorColor(Theme.getColor(i3));
        this.usernameTextView.setCursorSize(AndroidUtilities.dp(20.0f));
        this.usernameTextView.setCursorWidth(1.5f);
        this.publicContainer.addView(this.usernameTextView, LayoutHelper.createLinear(-1, 36));
        this.usernameTextView.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.ChatEditTypeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                if (ChatEditTypeActivity.this.ignoreTextChanges) {
                    return;
                }
                ChatEditTypeActivity chatEditTypeActivity = ChatEditTypeActivity.this;
                chatEditTypeActivity.checkUserName(chatEditTypeActivity.usernameTextView.getText().toString());
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ChatEditTypeActivity.this.checkDoneButton();
            }
        });
        LinearLayout linearLayout6 = new LinearLayout(context);
        this.privateContainer = linearLayout6;
        linearLayout6.setOrientation(1);
        this.linkContainer.addView(this.privateContainer, LayoutHelper.createLinear(-1, -2));
        LinkActionView linkActionView = new LinkActionView(context, this, null, this.chatId, true, ChatObject.isChannel(this.currentChat));
        this.permanentLinkView = linkActionView;
        linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: org.rbmain.ui.ChatEditTypeActivity.4
            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void editLink() {
                LinkActionView.Delegate.CC.$default$editLink(this);
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void removeLink() {
                LinkActionView.Delegate.CC.$default$removeLink(this);
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public void revokeLink() {
                ChatEditTypeActivity.this.generateLink(true);
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public void showUsersForPermanentLink() {
                ChatEditTypeActivity chatEditTypeActivity = ChatEditTypeActivity.this;
                Context context2 = context;
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = ChatEditTypeActivity.this.invite;
                TLRPC$ChatFull tLRPC$ChatFull = ChatEditTypeActivity.this.info;
                ChatEditTypeActivity chatEditTypeActivity2 = ChatEditTypeActivity.this;
                chatEditTypeActivity.inviteLinkBottomSheet = new InviteLinkBottomSheet(context2, tLRPC$TL_chatInviteExported, tLRPC$ChatFull, chatEditTypeActivity2.usersMap, chatEditTypeActivity2, chatEditTypeActivity2.chatId, true, ChatObject.isChannel(ChatEditTypeActivity.this.currentChat));
                ChatEditTypeActivity.this.inviteLinkBottomSheet.show();
            }
        });
        this.permanentLinkView.setUsers(0, null);
        this.privateContainer.addView(this.permanentLinkView);
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.checkTextView = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
        this.checkTextView.setBottomPadding(6);
        this.linearLayout.addView(this.checkTextView, LayoutHelper.createLinear(-2, -2));
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.typeInfoCell = textInfoPrivacyCell2;
        this.linearLayout.addView(textInfoPrivacyCell2, LayoutHelper.createLinear(-1, -2));
        LoadingCell loadingCell = new LoadingCell(context);
        this.loadingAdminedCell = loadingCell;
        this.linearLayout.addView(loadingCell, LayoutHelper.createLinear(-1, -2));
        LinearLayout linearLayout7 = new LinearLayout(context);
        this.adminnedChannelsLayout = linearLayout7;
        linearLayout7.setBackgroundColor(Theme.getColor(i));
        this.adminnedChannelsLayout.setOrientation(1);
        this.linearLayout.addView(this.adminnedChannelsLayout, LayoutHelper.createLinear(-1, -2));
        ShadowSectionCell shadowSectionCell2 = new ShadowSectionCell(context);
        this.adminedInfoCell = shadowSectionCell2;
        this.linearLayout.addView(shadowSectionCell2, LayoutHelper.createLinear(-1, -2));
        TextCell textCell = new TextCell(context);
        this.manageLinksTextView = textCell;
        textCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        this.manageLinksTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2(view);
            }
        });
        this.manageLinksTextView.setTextAndIcon(LocaleController.getString("ManageInviteLinks", R.string.ManageInviteLinks), R.drawable.actions_link, false);
        this.manageLinksTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3(view);
            }
        });
        this.linearLayout.addView(this.manageLinksTextView, LayoutHelper.createLinear(-1, -2));
        TextInfoPrivacyCell textInfoPrivacyCell3 = new TextInfoPrivacyCell(context);
        this.manageLinksInfoCell = textInfoPrivacyCell3;
        this.linearLayout.addView(textInfoPrivacyCell3, LayoutHelper.createLinear(-1, -2));
        if (!this.isPrivate && (str = this.currentChat.username) != null) {
            this.ignoreTextChanges = true;
            this.usernameTextView.setText(str);
            this.usernameTextView.setSelection(this.currentChat.username.length());
            this.ignoreTextChanges = false;
        }
        updatePrivatePublic();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        if (this.isPrivate) {
            return;
        }
        this.isPrivate = true;
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view) {
        if (this.isPrivate) {
            this.isPrivate = false;
            updatePrivatePublic();
            checkChannelsWithUsername();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.chatId, 0, 0);
        manageLinksActivity.setInfo(this.info, this.invite);
        presentFragment(manageLinksActivity);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull.id == this.chatId) {
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
                if (tLRPC$TL_chatInviteExported != null) {
                    tLRPC$ChatFull.exported_invite = tLRPC$TL_chatInviteExported;
                }
                this.info = tLRPC$ChatFull;
                this.invite = tLRPC$ChatFull.exported_invite;
                updatePrivatePublic();
            }
        }
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull != null) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = tLRPC$ChatFull.exported_invite;
            if (tLRPC$TL_chatInviteExported != null) {
                this.invite = tLRPC$TL_chatInviteExported;
            } else {
                generateLink(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        if (this.currentChat == null || this.isForcePrivate) {
            finishFragment();
            return;
        }
        if (this.progressDialog == null) {
            this.progressDialog = new AlertDialog(getParentActivity(), 3);
        }
        getDialogsProxy().updatePrivatePublicChannel(-this.chatId, this.isPrivate, new AnonymousClass5());
        this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$processDone$4(dialogInterface);
            }
        });
        this.progressDialog.show();
    }

    /* renamed from: org.rbmain.ui.ChatEditTypeActivity$5, reason: invalid class name */
    class AnonymousClass5 implements RequestDelegate {
        AnonymousClass5() {
        }

        @Override // org.rbmain.tgnet.RequestDelegate
        public void run(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$5$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(TLRPC$TL_error tLRPC$TL_error) {
            ChatEditTypeActivity.this.progressDialog.dismiss();
            if (tLRPC$TL_error == null && ChatEditTypeActivity.this.trySetUsername()) {
                ChatEditTypeActivity.this.finishFragment();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$4(DialogInterface dialogInterface) {
        this.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySetUsername() {
        String str;
        if (getParentActivity() == null) {
            return false;
        }
        boolean z = this.isPrivate;
        if (z) {
            return true;
        }
        if (!z && (((this.currentChat.username == null && this.usernameTextView.length() != 0) || ((str = this.currentChat.username) != null && !str.equalsIgnoreCase(this.usernameTextView.getText().toString()))) && this.usernameTextView.length() != 0 && !this.lastNameAvailable)) {
            Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.checkTextView, 2.0f, 0);
            return false;
        }
        String str2 = this.currentChat.username;
        String string = BuildConfig.FLAVOR;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        if (!this.isPrivate) {
            string = this.usernameTextView.getText().toString();
        }
        if (!str2.equals(string)) {
            if (!ChatObject.isChannel(this.currentChat)) {
                getMessagesController().convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda16
                    @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                    public final void run(int i) {
                        this.f$0.lambda$trySetUsername$5(i);
                    }
                });
                return false;
            }
            getMessagesController().updateChannelUserName(this.chatId, string);
            this.currentChat.username = string;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$trySetUsername$5(int i) {
        if (i != 0) {
            this.chatId = i;
            this.currentChat = getMessagesController().getChat(Integer.valueOf(i));
            processDone();
        }
    }

    private void loadAdminedChannels() {
        if (this.loadingAdminedChannels || this.adminnedChannelsLayout == null) {
            return;
        }
        this.loadingAdminedChannels = true;
        updatePrivatePublic();
        getConnectionsManager().sendRequest(new TLRPC$TL_channels_getAdminedPublicChannels(), new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda19
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$11(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$11(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAdminedChannels$10(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$10(TLObject tLObject) {
        this.loadingAdminedChannels = false;
        if (tLObject == null || getParentActivity() == null) {
            return;
        }
        for (int i = 0; i < this.adminedChannelCells.size(); i++) {
            this.linearLayout.removeView(this.adminedChannelCells.get(i));
        }
        this.adminedChannelCells.clear();
        TLRPC$TL_messages_chats tLRPC$TL_messages_chats = (TLRPC$TL_messages_chats) tLObject;
        for (int i2 = 0; i2 < tLRPC$TL_messages_chats.chats.size(); i2++) {
            AdminedChannelCell adminedChannelCell = new AdminedChannelCell(getParentActivity(), new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$loadAdminedChannels$9(view);
                }
            });
            TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_chats.chats.get(i2);
            boolean z = true;
            if (i2 != tLRPC$TL_messages_chats.chats.size() - 1) {
                z = false;
            }
            adminedChannelCell.setChannel(tLRPC$Chat, z);
            this.adminedChannelCells.add(adminedChannelCell);
            this.adminnedChannelsLayout.addView(adminedChannelCell, LayoutHelper.createLinear(-1, 72));
        }
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$9(View view) {
        final TLRPC$Chat currentChannel = ((AdminedChannelCell) view.getParent()).getCurrentChannel();
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (this.isChannel) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlertChannel", R.string.RevokeLinkAlertChannel, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlert", R.string.RevokeLinkAlert, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$loadAdminedChannels$8(currentChannel, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$8(TLRPC$Chat tLRPC$Chat, DialogInterface dialogInterface, int i) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = MessagesController.getInputChannel(tLRPC$Chat);
        tLRPC$TL_channels_updateUsername.username = BuildConfig.FLAVOR;
        getDialogsProxy().updateChannelUserName(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda20
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$7(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$7(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadAdminedChannels$6();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$6() {
        this.canCreatePublic = true;
        if (this.usernameTextView.length() > 0) {
            checkUserName(this.usernameTextView.getText().toString());
        }
        updatePrivatePublic();
    }

    private void loadAdminedChannels(TLRPC$TL_messages_chats tLRPC$TL_messages_chats) {
        if (this.loadingAdminedChannels || this.adminnedChannelsLayout == null) {
            return;
        }
        updatePrivatePublic();
        this.loadingAdminedChannels = false;
        if (tLRPC$TL_messages_chats == null || getParentActivity() == null) {
            return;
        }
        for (int i = 0; i < this.adminedChannelCells.size(); i++) {
            this.linearLayout.removeView(this.adminedChannelCells.get(i));
        }
        this.adminedChannelCells.clear();
        for (int i2 = 0; i2 < tLRPC$TL_messages_chats.chats.size(); i2++) {
            AdminedChannelCell adminedChannelCell = new AdminedChannelCell(getParentActivity(), new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$loadAdminedChannels$15(view);
                }
            });
            TLRPC$Chat tLRPC$Chat = tLRPC$TL_messages_chats.chats.get(i2);
            boolean z = true;
            if (i2 != tLRPC$TL_messages_chats.chats.size() - 1) {
                z = false;
            }
            adminedChannelCell.setChannel(tLRPC$Chat, z);
            this.adminedChannelCells.add(adminedChannelCell);
            this.adminnedChannelsLayout.addView(adminedChannelCell, LayoutHelper.createLinear(-1, 72));
        }
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$15(View view) {
        final TLRPC$Chat currentChannel = ((AdminedChannelCell) view.getParent()).getCurrentChannel();
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (this.isChannel) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlertChannel", R.string.RevokeLinkAlertChannel, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlert", R.string.RevokeLinkAlert, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$loadAdminedChannels$14(currentChannel, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$14(TLRPC$Chat tLRPC$Chat, DialogInterface dialogInterface, int i) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = MessagesController.getInputChannel(tLRPC$Chat);
        tLRPC$TL_channels_updateUsername.username = BuildConfig.FLAVOR;
        getDialogsProxy().updateChannelUserName(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda18
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$13(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$13(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadAdminedChannels$12();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminedChannels$12() {
        this.canCreatePublic = true;
        if (this.usernameTextView.length() > 0) {
            checkUserName(this.usernameTextView.getText().toString());
        }
        updatePrivatePublic();
    }

    private void updatePrivatePublic() {
        int i;
        String str;
        int i2;
        String str2;
        if (this.sectionCell2 == null) {
            return;
        }
        int i3 = 8;
        if (!this.isPrivate && !this.canCreatePublic) {
            this.typeInfoCell.setText(LocaleController.getString("ChangePublicLimitReached", R.string.ChangePublicLimitReached));
            TextInfoPrivacyCell textInfoPrivacyCell = this.typeInfoCell;
            int i4 = Theme.key_text_RedRegular;
            textInfoPrivacyCell.setTag(Integer.valueOf(i4));
            this.typeInfoCell.setTextColor(Theme.getColor(i4));
            this.linkContainer.setVisibility(8);
            this.checkTextView.setVisibility(8);
            this.sectionCell2.setVisibility(8);
            this.adminedInfoCell.setVisibility(0);
            if (this.loadingAdminedChannels) {
                this.loadingAdminedCell.setVisibility(0);
                this.adminnedChannelsLayout.setVisibility(8);
                this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() == 0 ? null : Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                this.adminedInfoCell.setBackgroundDrawable(null);
            } else {
                ShadowSectionCell shadowSectionCell = this.adminedInfoCell;
                Context context = shadowSectionCell.getContext();
                int i5 = Theme.key_windowBackgroundGrayShadow;
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, i5));
                TextInfoPrivacyCell textInfoPrivacyCell2 = this.typeInfoCell;
                textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell2.getContext(), R.drawable.greydivider_top, i5));
                this.loadingAdminedCell.setVisibility(8);
                this.adminnedChannelsLayout.setVisibility(0);
            }
        } else {
            TextInfoPrivacyCell textInfoPrivacyCell3 = this.typeInfoCell;
            int i6 = Theme.key_windowBackgroundWhiteGrayText4;
            textInfoPrivacyCell3.setTag(Integer.valueOf(i6));
            this.typeInfoCell.setTextColor(Theme.getColor(i6));
            if (this.isForcePublic) {
                this.sectionCell2.setVisibility(8);
            } else {
                this.sectionCell2.setVisibility(0);
            }
            this.adminedInfoCell.setVisibility(8);
            TextInfoPrivacyCell textInfoPrivacyCell4 = this.typeInfoCell;
            Context context2 = textInfoPrivacyCell4.getContext();
            int i7 = Theme.key_windowBackgroundGrayShadow;
            textInfoPrivacyCell4.setBackgroundDrawable(Theme.getThemedDrawable(context2, R.drawable.greydivider_bottom, i7));
            this.adminnedChannelsLayout.setVisibility(8);
            this.linkContainer.setVisibility(0);
            this.loadingAdminedCell.setVisibility(8);
            if (this.isChannel) {
                TextInfoPrivacyCell textInfoPrivacyCell5 = this.typeInfoCell;
                if (this.isPrivate) {
                    i2 = R.string.ChannelPrivateLinkHelp;
                    str2 = "ChannelPrivateLinkHelp";
                } else {
                    i2 = R.string.ChannelUsernameHelp;
                    str2 = "ChannelUsernameHelp";
                }
                textInfoPrivacyCell5.setText(LocaleController.getString(str2, i2));
                this.headerCell.setText(this.isPrivate ? LocaleController.getString("ChannelInviteLinkTitle", R.string.ChannelInviteLinkTitle) : LocaleController.getString("ChannelLinkTitle", R.string.ChannelLinkTitle));
            } else {
                TextInfoPrivacyCell textInfoPrivacyCell6 = this.typeInfoCell;
                if (this.isPrivate) {
                    i = R.string.MegaPrivateLinkHelp;
                    str = "MegaPrivateLinkHelp";
                } else {
                    i = R.string.MegaUsernameHelp;
                    str = "MegaUsernameHelp";
                }
                textInfoPrivacyCell6.setText(LocaleController.getString(str, i));
                this.headerCell.setText(this.isPrivate ? LocaleController.getString("ChannelInviteLinkTitle", R.string.ChannelInviteLinkTitle) : LocaleController.getString("ChannelLinkTitle", R.string.ChannelLinkTitle));
            }
            this.publicContainer.setVisibility(this.isPrivate ? 8 : 0);
            this.privateContainer.setVisibility(this.isPrivate ? 0 : 8);
            this.manageLinksTextView.setVisibility(8);
            this.manageLinksInfoCell.setVisibility(0);
            this.linkContainer.setPadding(0, 0, 0, this.isPrivate ? 0 : AndroidUtilities.dp(7.0f));
            this.permanentLinkView.setUnSetLink(this.unset);
            LinkActionView linkActionView = this.permanentLinkView;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
            linkActionView.setLink(tLRPC$TL_chatInviteExported != null ? tLRPC$TL_chatInviteExported.link : null);
            this.permanentLinkView.loadUsers(this.invite, this.chatId);
            TextInfoPrivacyCell textInfoPrivacyCell7 = this.checkTextView;
            if (!this.isPrivate && textInfoPrivacyCell7.length() != 0) {
                i3 = 0;
            }
            textInfoPrivacyCell7.setVisibility(i3);
            this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() != 0 ? Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, i7) : null);
        }
        this.radioButtonCell1.setChecked(!this.isPrivate, true);
        this.radioButtonCell2.setChecked(this.isPrivate, true);
        this.usernameTextView.clearFocus();
        checkDoneButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDoneButton() {
        if (this.isPrivate || this.usernameTextView.length() >= 0) {
            this.doneButton.setEnabled(true);
            this.doneButton.setAlpha(1.0f);
        } else {
            this.doneButton.setEnabled(false);
            this.doneButton.setAlpha(0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserName(final String str) {
        if (str != null && str.length() > 0) {
            this.checkTextView.setVisibility(0);
        } else {
            this.checkTextView.setVisibility(8);
        }
        this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() == 0 ? null : Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
        Runnable runnable = this.checkRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkRunnable = null;
            this.lastCheckName = null;
            if (this.checkReqId != 0) {
                getConnectionsManager().cancelRequest(this.checkReqId, true);
            }
        }
        this.lastNameAvailable = false;
        if (str != null) {
            if (str.startsWith("_") || str.endsWith("_")) {
                this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (i == 0 && cCharAt >= '0' && cCharAt <= '9') {
                    if (this.isChannel) {
                        this.checkTextView.setText(LocaleController.getString("LinkInvalidStartNumber", R.string.LinkInvalidStartNumber));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("LinkInvalidStartNumberMega", R.string.LinkInvalidStartNumberMega));
                    }
                    this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                    return false;
                }
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                    this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                    return false;
                }
            }
        }
        if (str == null || str.length() < 5) {
            if (this.isChannel) {
                this.checkTextView.setText(LocaleController.getString("LinkInvalidShort", R.string.LinkInvalidShort));
            } else {
                this.checkTextView.setText(LocaleController.getString("LinkInvalidShortMega", R.string.LinkInvalidShortMega));
            }
            this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            return false;
        }
        if (str.length() > 32) {
            this.checkTextView.setText(LocaleController.getString("LinkInvalidLong", R.string.LinkInvalidLong));
            this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            return false;
        }
        this.checkTextView.setText(LocaleController.getString("LinkChecking", R.string.LinkChecking));
        this.checkTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText8));
        this.lastCheckName = str;
        Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$18(str);
            }
        };
        this.checkRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 600L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$18(final String str) {
        TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = new TLRPC$TL_channels_checkUsername();
        tLRPC$TL_channels_checkUsername.username = str;
        tLRPC$TL_channels_checkUsername.channel = getMessagesController().getInputChannel(this.chatId);
        this.checkReqId = getDialogsProxy().checkChannelUsername(tLRPC$TL_channels_checkUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda21
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUserName$17(str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$17(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$16(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$16(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.checkTextView.setText(LocaleController.formatString("LinkAvailable", R.string.LinkAvailable, str));
            this.checkTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGreenText));
            this.lastNameAvailable = true;
            return;
        }
        if (tLRPC$TL_error != null && tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH")) {
            this.canCreatePublic = false;
            loadAdminedChannels();
        } else {
            this.checkTextView.setText(LocaleController.getString("LinkInUse", R.string.LinkInUse));
        }
        this.checkTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
        this.lastNameAvailable = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateLink(final boolean z) {
        TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
        tLRPC$TL_messages_exportChatInvite.legacy_revoke_permanent = true;
        tLRPC$TL_messages_exportChatInvite.peer = getMessagesController().getInputPeer(-this.chatId);
        tLRPC$TL_messages_exportChatInvite.newRequest = z;
        getDialogsProxy().setGroupOrChannelLinks(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda22
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$20(z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$20(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$19(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$19(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            this.unset = false;
            boolean z2 = this.invite != null;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = (TLRPC$TL_chatInviteExported) tLObject;
            this.invite = tLRPC$TL_chatInviteExported;
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull != null) {
                tLRPC$ChatFull.exported_invite = tLRPC$TL_chatInviteExported;
            }
            if (z && z2) {
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setMessage(LocaleController.getString("RevokeAlertNewLink", R.string.RevokeAlertNewLink));
                builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
                builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                showDialog(builder.create());
            }
        } else if (tLRPC$TL_error.code == 100) {
            this.unset = true;
        }
        LinkActionView linkActionView = this.permanentLinkView;
        if (linkActionView != null) {
            linkActionView.setUnSetLink(this.unset);
            LinkActionView linkActionView2 = this.permanentLinkView;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = this.invite;
            linkActionView2.setLink(tLRPC$TL_chatInviteExported2 != null ? tLRPC$TL_chatInviteExported2.link : null);
            this.permanentLinkView.loadUsers(this.invite, this.chatId);
        }
    }

    private void checkChannelsWithUsername() {
        if (this.isCheckingChannels || !this.canCreatePublic || this.alreadyCheckedChannels || this.isPrivate || !TextUtils.isEmpty(this.currentChat.username) || !this.currentChat.accessEnumHashSet.contains(Chat.ChatAccessEnum.SuperAdmin)) {
            return;
        }
        this.isCheckingChannels = true;
        TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = new TLRPC$TL_channels_checkUsername();
        tLRPC$TL_channels_checkUsername.username = "1";
        tLRPC$TL_channels_checkUsername.channel = new TLRPC$TL_inputChannelEmpty();
        getDialogsProxy().checkChannelUsername(tLRPC$TL_channels_checkUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda17
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkChannelsWithUsername$22(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChannelsWithUsername$22(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkChannelsWithUsername$21(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChannelsWithUsername$21(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.isCheckingChannels = false;
        boolean z = tLRPC$TL_error == null || !tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH");
        this.canCreatePublic = z;
        if (!z) {
            loadAdminedChannels((TLRPC$TL_messages_chats) tLObject);
        } else {
            this.alreadyCheckedChannels = true;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChatEditTypeActivity$$ExternalSyntheticLambda23
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$23();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        int i = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.sectionCell2, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.infoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i));
        int i2 = Theme.key_windowBackgroundWhiteGrayText4;
        arrayList.add(new ThemeDescription(this.infoCell, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        TextSettingsCell textSettingsCell = this.textCell;
        int i3 = ThemeDescription.FLAG_SELECTOR;
        int i4 = Theme.key_listSelector;
        arrayList.add(new ThemeDescription(textSettingsCell, i3, null, null, null, null, i4));
        int i5 = Theme.key_text_RedRegular;
        arrayList.add(new ThemeDescription(this.textCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.textCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i4));
        int i6 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.textCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.usernameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i6));
        EditTextBoldCursor editTextBoldCursor = this.usernameTextView;
        int i7 = ThemeDescription.FLAG_HINTTEXTCOLOR;
        int i8 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i7, null, null, null, null, i8));
        LinearLayout linearLayout = this.linearLayoutTypeContainer;
        int i9 = ThemeDescription.FLAG_BACKGROUND;
        int i10 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(linearLayout, i9, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.linkContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i10));
        int i11 = Theme.key_windowBackgroundWhiteBlueHeader;
        arrayList.add(new ThemeDescription(this.headerCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i11));
        arrayList.add(new ThemeDescription(this.headerCell2, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i11));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText8));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGreenText));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.adminedInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.loadingAdminedCell, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i4));
        int i12 = Theme.key_radioBackground;
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        int i13 = Theme.key_radioBackgroundChecked;
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        int i14 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i14));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        int i15 = Theme.key_windowBackgroundWhiteGrayText;
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i15));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_LINKCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"deleteButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i15));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$23() {
        LinearLayout linearLayout = this.adminnedChannelsLayout;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.adminnedChannelsLayout.getChildAt(i);
                if (childAt instanceof AdminedChannelCell) {
                    ((AdminedChannelCell) childAt).update();
                }
            }
        }
        this.permanentLinkView.updateColors();
        this.manageLinksTextView.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        InviteLinkBottomSheet inviteLinkBottomSheet = this.inviteLinkBottomSheet;
        if (inviteLinkBottomSheet != null) {
            inviteLinkBottomSheet.updateColors();
        }
    }
}
