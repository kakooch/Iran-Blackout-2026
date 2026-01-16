package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_channels_checkUsername;
import ir.eitaa.tgnet.TLRPC$TL_channels_exportInvite;
import ir.eitaa.tgnet.TLRPC$TL_channels_getAdminedPublicChannels;
import ir.eitaa.tgnet.TLRPC$TL_channels_updateUsername;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_chats;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportChatInvite_layer84;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.AdminedChannelCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.RadioButtonCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LinkActionView;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChatEditTypeActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ShadowSectionCell adminedInfoCell;
    private LinearLayout adminnedChannelsLayout;
    private long chatId;
    private int checkReqId;
    private Runnable checkRunnable;
    private TextInfoPrivacyCell checkTextView;
    private FrameLayout container5;
    private boolean contentTypeIsMedia;
    private TLRPC$Chat currentChat;
    private ActionBarMenuItem doneButton;
    private EditTextBoldCursor editText;
    private HeaderCell headerCell;
    private HeaderCell headerCell2;
    private boolean ignoreTextChanges;
    private TLRPC$ChatFull info;
    private TextInfoPrivacyCell infoCell;
    private TLRPC$ExportedChatInvite invite;
    private boolean isChannel;
    private boolean isForcePublic;
    private boolean isPrivate;
    private String lastCheckName;
    private boolean lastNameAvailable;
    private LinearLayout linearLayout;
    private LinearLayout linearLayoutTypeContainer;
    private LinearLayout linkContainer;
    private LoadingCell loadingAdminedCell;
    private boolean loadingAdminedChannels;
    private boolean loadingInvite;
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
    HashMap<Long, TLRPC$User> usersMap = new HashMap<>();

    public ChatEditTypeActivity(long id, boolean forcePublic) {
        this.chatId = id;
        this.isForcePublic = forcePublic;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            r10 = this;
            ir.eitaa.messenger.MessagesController r0 = r10.getMessagesController()
            long r1 = r10.chatId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r10.currentChat = r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L4b
            ir.eitaa.messenger.MessagesStorage r0 = r10.getMessagesStorage()
            long r3 = r10.chatId
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChatSync(r3)
            r10.currentChat = r0
            if (r0 == 0) goto L4a
            ir.eitaa.messenger.MessagesController r0 = r10.getMessagesController()
            ir.eitaa.tgnet.TLRPC$Chat r3 = r10.currentChat
            r0.putChat(r3, r2)
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r10.info
            if (r0 != 0) goto L4b
            ir.eitaa.messenger.MessagesStorage r3 = r10.getMessagesStorage()
            long r4 = r10.chatId
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r6 = ir.eitaa.messenger.ChatObject.isChannel(r0)
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            r7.<init>(r2)
            r8 = 0
            r9 = 0
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r3.loadChatInfo(r4, r6, r7, r8, r9)
            r10.info = r0
            if (r0 != 0) goto L4b
        L4a:
            return r1
        L4b:
            boolean r0 = r10.isForcePublic
            if (r0 != 0) goto L5b
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            java.lang.String r0 = r0.username
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L5b
            r0 = 1
            goto L5c
        L5b:
            r0 = 0
        L5c:
            r10.isPrivate = r0
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = ir.eitaa.messenger.ChatObject.isChannel(r0)
            if (r0 == 0) goto L6d
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = r0.megagroup
            if (r0 != 0) goto L6d
            r1 = 1
        L6d:
            r10.isChannel = r1
            boolean r0 = r10.isForcePublic
            if (r0 == 0) goto L7d
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            java.lang.String r0 = r0.username
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L87
        L7d:
            boolean r0 = r10.isPrivate
            if (r0 == 0) goto La3
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = r0.creator
            if (r0 == 0) goto La3
        L87:
            ir.eitaa.tgnet.TLRPC$TL_channels_checkUsername r0 = new ir.eitaa.tgnet.TLRPC$TL_channels_checkUsername
            r0.<init>()
            java.lang.String r1 = "1"
            r0.username = r1
            ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty r1 = new ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty
            r1.<init>()
            r0.channel = r1
            ir.eitaa.tgnet.ConnectionsManager r1 = r10.getConnectionsManager()
            ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$wtz4AqitKKoUnZqBnQ5KqT8XORI r3 = new ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$wtz4AqitKKoUnZqBnQ5KqT8XORI
            r3.<init>()
            r1.sendRequest(r0, r3)
        La3:
            boolean r0 = r10.isPrivate
            if (r0 == 0) goto Lb6
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r10.info
            if (r0 == 0) goto Lb6
            ir.eitaa.messenger.MessagesController r0 = r10.getMessagesController()
            long r3 = r10.chatId
            int r1 = r10.classGuid
            r0.loadFullChat(r3, r1, r2)
        Lb6:
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = r0.isMediaContent
            r10.contentTypeIsMedia = r0
            ir.eitaa.messenger.NotificationCenter r0 = r10.getNotificationCenter()
            int r1 = ir.eitaa.messenger.NotificationCenter.chatInfoDidLoad
            r0.addObserver(r10, r1)
            boolean r0 = super.onFragmentCreate()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatEditTypeActivity.onFragmentCreate():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFragmentCreate$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFragmentCreate$1$ChatEditTypeActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$Rg4QiExs_VfkcfuBfrFoPSWOKNs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFragmentCreate$0$ChatEditTypeActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFragmentCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFragmentCreate$0$ChatEditTypeActivity(TLRPC$TL_error tLRPC$TL_error) {
        boolean z = tLRPC$TL_error == null || !tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH");
        this.canCreatePublic = z;
        if (z) {
            return;
        }
        loadAdminedChannels();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = tLRPC$ChatFull2.exported_invite;
            this.invite = tLRPC$ExportedChatInvite;
            this.permanentLinkView.setLink(tLRPC$ExportedChatInvite == null ? null : tLRPC$ExportedChatInvite.link);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyVisible() {
        EditTextBoldCursor editTextBoldCursor;
        super.onBecomeFullyVisible();
        if (!this.isForcePublic || (editTextBoldCursor = this.usernameTextView) == null) {
            return;
        }
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(this.usernameTextView);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChatEditTypeActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ChatEditTypeActivity.this.finishFragment();
                    return;
                }
                if (id == 1) {
                    if (ChatEditTypeActivity.this.contentTypeIsMedia != ChatEditTypeActivity.this.currentChat.isMediaContent) {
                        ChatEditTypeActivity.this.currentChat.isMediaContent = ChatEditTypeActivity.this.contentTypeIsMedia;
                        MessagesController.getInstance(((BaseFragment) ChatEditTypeActivity.this).currentAccount).toggleChannelContentType((int) ChatEditTypeActivity.this.chatId, ChatEditTypeActivity.this.contentTypeIsMedia);
                    }
                    ChatEditTypeActivity.this.processDone();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.ChatEditTypeActivity.2
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                rectangle.bottom += AndroidUtilities.dp(60.0f);
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }
        };
        this.fragmentView = scrollView;
        scrollView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
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
        this.linearLayoutTypeContainer.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.linearLayout.addView(this.linearLayoutTypeContainer, LayoutHelper.createLinear(-1, -2));
        FrameLayout frameLayout = new FrameLayout(context);
        this.container5 = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
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
        this.radioButtonCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$DbYe9PrblrZL8FVbOOMVuX-ZrbE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2$ChatEditTypeActivity(view);
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
        this.radioButtonCell1.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$Vxw7EVyr4akKyH8026njn3fjruA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3$ChatEditTypeActivity(view);
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
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.linkContainer = linearLayout3;
        linearLayout3.setOrientation(1);
        this.linkContainer.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.linearLayout.addView(this.linkContainer, LayoutHelper.createLinear(-1, -2));
        HeaderCell headerCell2 = new HeaderCell(context, 23);
        this.headerCell = headerCell2;
        this.linkContainer.addView(headerCell2);
        LinearLayout linearLayout4 = new LinearLayout(context);
        this.publicContainer = linearLayout4;
        linearLayout4.setOrientation(0);
        this.linkContainer.addView(this.publicContainer, LayoutHelper.createLinear(-1, 36, 23.0f, 7.0f, 23.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setText(getMessagesController().linkPrefix + "/");
        this.editText.setTextSize(1, 18.0f);
        this.editText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.editText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.editText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setEnabled(false);
        this.editText.setBackgroundDrawable(null);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setSingleLine(true);
        this.editText.setInputType(163840);
        this.editText.setImeOptions(6);
        this.publicContainer.addView(this.editText, LayoutHelper.createLinear(-2, 36));
        EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
        this.usernameTextView = editTextBoldCursor2;
        editTextBoldCursor2.setTextSize(1, 18.0f);
        this.usernameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.usernameTextView.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.usernameTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.usernameTextView.setMaxLines(1);
        this.usernameTextView.setLines(1);
        this.usernameTextView.setBackgroundDrawable(null);
        this.usernameTextView.setPadding(0, 0, 0, 0);
        this.usernameTextView.setSingleLine(true);
        this.usernameTextView.setInputType(163872);
        this.usernameTextView.setImeOptions(6);
        this.usernameTextView.setHint(LocaleController.getString("ChannelUsernamePlaceholder", R.string.ChannelUsernamePlaceholder));
        this.usernameTextView.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.usernameTextView.setCursorSize(AndroidUtilities.dp(20.0f));
        this.usernameTextView.setCursorWidth(1.5f);
        this.publicContainer.addView(this.usernameTextView, LayoutHelper.createLinear(-1, 36));
        this.usernameTextView.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ChatEditTypeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
        LinearLayout linearLayout5 = new LinearLayout(context);
        this.privateContainer = linearLayout5;
        linearLayout5.setOrientation(1);
        this.linkContainer.addView(this.privateContainer, LayoutHelper.createLinear(-1, -2));
        LinkActionView linkActionView = new LinkActionView(context, this, null, this.chatId, true, ChatObject.isChannel(this.currentChat));
        this.permanentLinkView = linkActionView;
        linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: ir.eitaa.ui.ChatEditTypeActivity.4
            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void editLink() {
                LinkActionView.Delegate.CC.$default$editLink(this);
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void removeLink() {
                LinkActionView.Delegate.CC.$default$removeLink(this);
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public void showUsersForPermanentLink() {
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public void revokeLink() {
                ChatEditTypeActivity.this.generateLink(true);
            }
        });
        this.permanentLinkView.setUsers(0, null);
        this.privateContainer.addView(this.permanentLinkView);
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.checkTextView = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.checkTextView.setBottomPadding(6);
        this.linearLayout.addView(this.checkTextView, LayoutHelper.createLinear(-2, -2));
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.typeInfoCell = textInfoPrivacyCell2;
        this.linearLayout.addView(textInfoPrivacyCell2, LayoutHelper.createLinear(-1, -2));
        LoadingCell loadingCell = new LoadingCell(context);
        this.loadingAdminedCell = loadingCell;
        this.linearLayout.addView(loadingCell, LayoutHelper.createLinear(-1, -2));
        LinearLayout linearLayout6 = new LinearLayout(context);
        this.adminnedChannelsLayout = linearLayout6;
        linearLayout6.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.adminnedChannelsLayout.setOrientation(1);
        this.linearLayout.addView(this.adminnedChannelsLayout, LayoutHelper.createLinear(-1, -2));
        ShadowSectionCell shadowSectionCell2 = new ShadowSectionCell(context);
        this.adminedInfoCell = shadowSectionCell2;
        this.linearLayout.addView(shadowSectionCell2, LayoutHelper.createLinear(-1, -2));
        TextCell textCell = new TextCell(context);
        this.manageLinksTextView = textCell;
        textCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        this.manageLinksTextView.setTextAndIcon(LocaleController.getString("ManageInviteLinks", R.string.ManageInviteLinks), R.drawable.actions_link, false);
        this.manageLinksTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$rq6TN_4w4kF40mNL2TomzSFmVW8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$4$ChatEditTypeActivity(view);
            }
        });
        this.manageLinksInfoCell = new TextInfoPrivacyCell(context);
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
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ChatEditTypeActivity(View view) {
        if (this.isPrivate) {
            return;
        }
        this.isPrivate = true;
        updatePrivatePublic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ChatEditTypeActivity(View view) {
        if (this.isPrivate) {
            this.isPrivate = false;
            updatePrivatePublic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ChatEditTypeActivity(View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.chatId, 0L, 0);
        manageLinksActivity.setInfo(this.info, this.invite);
        presentFragment(manageLinksActivity);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            if (tLRPC$ChatFull.id == this.chatId) {
                this.info = tLRPC$ChatFull;
                this.invite = tLRPC$ChatFull.exported_invite;
                updatePrivatePublic();
            }
        }
    }

    public void setInfo(TLRPC$ChatFull chatFull) {
        this.info = chatFull;
        if (chatFull != null) {
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = chatFull.exported_invite;
            if (tLRPC$ExportedChatInvite != null) {
                this.invite = tLRPC$ExportedChatInvite;
            } else {
                generateLink(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        if (trySetUsername()) {
            finishFragment();
        }
    }

    private boolean trySetUsername() {
        String str;
        if (getParentActivity() == null) {
            return false;
        }
        if (!this.isPrivate && (((this.currentChat.username == null && this.usernameTextView.length() != 0) || ((str = this.currentChat.username) != null && !str.equalsIgnoreCase(this.usernameTextView.getText().toString()))) && this.usernameTextView.length() != 0 && !this.lastNameAvailable)) {
            Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.checkTextView, 2.0f, 0);
            return false;
        }
        String str2 = this.currentChat.username;
        if (str2 == null) {
            str2 = "";
        }
        String string = this.isPrivate ? "" : this.usernameTextView.getText().toString();
        if (str2.equals(string)) {
            return true;
        }
        if (!ChatObject.isChannel(this.currentChat)) {
            getMessagesController().convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$4QUl79dET_a6hthOyR05xQYwqhw
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$trySetUsername$5$ChatEditTypeActivity(j);
                }
            });
            return false;
        }
        getMessagesController().updateChannelUserName(this.chatId, string);
        this.currentChat.username = string;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$trySetUsername$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$trySetUsername$5$ChatEditTypeActivity(long j) {
        if (j != 0) {
            this.chatId = j;
            this.currentChat = getMessagesController().getChat(Long.valueOf(j));
            processDone();
        }
    }

    private void loadAdminedChannels() {
        if (this.loadingAdminedChannels || this.adminnedChannelsLayout == null) {
            return;
        }
        this.loadingAdminedChannels = true;
        updatePrivatePublic();
        getConnectionsManager().sendRequest(new TLRPC$TL_channels_getAdminedPublicChannels(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$us7u57iLNSQsKk847HnItPTun6k
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$11$ChatEditTypeActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$11$ChatEditTypeActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$qKQzMyweqWi-wItb6t4737oSvXA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAdminedChannels$10$ChatEditTypeActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$10$ChatEditTypeActivity(TLObject tLObject) {
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
            AdminedChannelCell adminedChannelCell = new AdminedChannelCell(getParentActivity(), new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$cbkjGrfhDLY6OAQ_F_-lfxzUgQU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$loadAdminedChannels$9$ChatEditTypeActivity(view);
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
    /* renamed from: lambda$loadAdminedChannels$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$9$ChatEditTypeActivity(View view) {
        final TLRPC$Chat currentChannel = ((AdminedChannelCell) view.getParent()).getCurrentChannel();
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (this.isChannel) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlertChannel", R.string.RevokeLinkAlertChannel, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("RevokeLinkAlert", R.string.RevokeLinkAlert, getMessagesController().linkPrefix + "/" + currentChannel.username, currentChannel.title)));
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$fnUTVJQr-TT8eu5ISWxvtrc62Ec
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$loadAdminedChannels$8$ChatEditTypeActivity(currentChannel, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$8$ChatEditTypeActivity(TLRPC$Chat tLRPC$Chat, DialogInterface dialogInterface, int i) {
        TLRPC$TL_channels_updateUsername tLRPC$TL_channels_updateUsername = new TLRPC$TL_channels_updateUsername();
        tLRPC$TL_channels_updateUsername.channel = MessagesController.getInputChannel(tLRPC$Chat);
        tLRPC$TL_channels_updateUsername.username = "";
        getConnectionsManager().sendRequest(tLRPC$TL_channels_updateUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$4L_d0-1qhoxV0oAuhAy_RhBaUto
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdminedChannels$7$ChatEditTypeActivity(tLObject, tLRPC$TL_error);
            }
        }, 64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$7$ChatEditTypeActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$dlw9XxydYfzAxsHUTsDh5kHIdqc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadAdminedChannels$6$ChatEditTypeActivity();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdminedChannels$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdminedChannels$6$ChatEditTypeActivity() {
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
            this.typeInfoCell.setTag("windowBackgroundWhiteRedText4");
            this.typeInfoCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            this.linkContainer.setVisibility(8);
            this.checkTextView.setVisibility(8);
            this.sectionCell2.setVisibility(8);
            this.adminedInfoCell.setVisibility(0);
            if (this.loadingAdminedChannels) {
                this.loadingAdminedCell.setVisibility(0);
                this.adminnedChannelsLayout.setVisibility(8);
                this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() == 0 ? null : Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                this.adminedInfoCell.setBackgroundDrawable(null);
            } else {
                ShadowSectionCell shadowSectionCell = this.adminedInfoCell;
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(shadowSectionCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                TextInfoPrivacyCell textInfoPrivacyCell = this.typeInfoCell;
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell.getContext(), R.drawable.greydivider_top, "windowBackgroundGrayShadow"));
                this.loadingAdminedCell.setVisibility(8);
                this.adminnedChannelsLayout.setVisibility(0);
            }
        } else {
            this.typeInfoCell.setTag("windowBackgroundWhiteGrayText4");
            this.typeInfoCell.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
            if (this.isForcePublic) {
                this.sectionCell2.setVisibility(8);
            } else {
                this.sectionCell2.setVisibility(0);
            }
            this.adminedInfoCell.setVisibility(8);
            TextInfoPrivacyCell textInfoPrivacyCell2 = this.typeInfoCell;
            textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell2.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.adminnedChannelsLayout.setVisibility(8);
            this.linkContainer.setVisibility(0);
            this.loadingAdminedCell.setVisibility(8);
            if (this.isChannel) {
                TextInfoPrivacyCell textInfoPrivacyCell3 = this.typeInfoCell;
                if (this.isPrivate) {
                    i2 = R.string.ChannelPrivateLinkHelp;
                    str2 = "ChannelPrivateLinkHelp";
                } else {
                    i2 = R.string.ChannelUsernameHelp;
                    str2 = "ChannelUsernameHelp";
                }
                textInfoPrivacyCell3.setText(LocaleController.getString(str2, i2));
                this.headerCell.setText(this.isPrivate ? LocaleController.getString("ChannelInviteLinkTitle", R.string.ChannelInviteLinkTitle) : LocaleController.getString("ChannelLinkTitle", R.string.ChannelLinkTitle));
            } else {
                TextInfoPrivacyCell textInfoPrivacyCell4 = this.typeInfoCell;
                if (this.isPrivate) {
                    i = R.string.MegaPrivateLinkHelp;
                    str = "MegaPrivateLinkHelp";
                } else {
                    i = R.string.MegaUsernameHelp;
                    str = "MegaUsernameHelp";
                }
                textInfoPrivacyCell4.setText(LocaleController.getString(str, i));
                this.headerCell.setText(this.isPrivate ? LocaleController.getString("ChannelInviteLinkTitle", R.string.ChannelInviteLinkTitle) : LocaleController.getString("ChannelLinkTitle", R.string.ChannelLinkTitle));
            }
            this.publicContainer.setVisibility(this.isPrivate ? 8 : 0);
            this.privateContainer.setVisibility(this.isPrivate ? 0 : 8);
            this.manageLinksTextView.setVisibility(0);
            this.manageLinksInfoCell.setVisibility(0);
            this.linkContainer.setPadding(0, 0, 0, this.isPrivate ? 0 : AndroidUtilities.dp(7.0f));
            LinkActionView linkActionView = this.permanentLinkView;
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = this.invite;
            linkActionView.setLink(tLRPC$ExportedChatInvite != null ? tLRPC$ExportedChatInvite.link : null);
            TextInfoPrivacyCell textInfoPrivacyCell5 = this.checkTextView;
            if (!this.isPrivate && textInfoPrivacyCell5.length() != 0) {
                i3 = 0;
            }
            textInfoPrivacyCell5.setVisibility(i3);
            if (this.isPrivate) {
                TextInfoPrivacyCell textInfoPrivacyCell6 = this.typeInfoCell;
                textInfoPrivacyCell6.setBackgroundDrawable(Theme.getThemedDrawable(textInfoPrivacyCell6.getContext(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
                this.manageLinksInfoCell.setBackground(Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                this.manageLinksInfoCell.setText(LocaleController.getString("ManageLinksInfoHelp", R.string.ManageLinksInfoHelp));
            } else {
                this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() != 0 ? Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow") : null);
            }
        }
        this.radioButtonCell1.setChecked(!this.isPrivate, true);
        this.radioButtonCell2.setChecked(this.isPrivate, true);
        this.usernameTextView.clearFocus();
        checkDoneButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDoneButton() {
        if (this.isPrivate || this.usernameTextView.length() > 0) {
            this.doneButton.setEnabled(true);
            this.doneButton.setAlpha(1.0f);
        } else {
            this.doneButton.setEnabled(false);
            this.doneButton.setAlpha(0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserName(final String name) {
        if (name != null && name.length() > 0) {
            this.checkTextView.setVisibility(0);
        } else {
            this.checkTextView.setVisibility(8);
        }
        this.typeInfoCell.setBackgroundDrawable(this.checkTextView.getVisibility() == 0 ? null : Theme.getThemedDrawable(this.typeInfoCell.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
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
        if (name != null) {
            if (name.startsWith("_") || name.endsWith("_")) {
                this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
                return false;
            }
            for (int i = 0; i < name.length(); i++) {
                char cCharAt = name.charAt(i);
                if (i == 0 && cCharAt >= '0' && cCharAt <= '9') {
                    if (this.isChannel) {
                        this.checkTextView.setText(LocaleController.getString("LinkInvalidStartNumber", R.string.LinkInvalidStartNumber));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("LinkInvalidStartNumberMega", R.string.LinkInvalidStartNumberMega));
                    }
                    this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
                    return false;
                }
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    this.checkTextView.setText(LocaleController.getString("LinkInvalid", R.string.LinkInvalid));
                    this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
                    return false;
                }
            }
        }
        if (name == null || name.length() < 5) {
            if (this.isChannel) {
                this.checkTextView.setText(LocaleController.getString("LinkInvalidShort", R.string.LinkInvalidShort));
            } else {
                this.checkTextView.setText(LocaleController.getString("LinkInvalidShortMega", R.string.LinkInvalidShortMega));
            }
            this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
            return false;
        }
        if (name.length() > 32) {
            this.checkTextView.setText(LocaleController.getString("LinkInvalidLong", R.string.LinkInvalidLong));
            this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
            return false;
        }
        this.checkTextView.setText(LocaleController.getString("LinkChecking", R.string.LinkChecking));
        this.checkTextView.setTextColor("windowBackgroundWhiteGrayText8");
        this.lastCheckName = name;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$qZMfBntL3bNJfHnCf3Zrs17YyNI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$14$ChatEditTypeActivity(name);
            }
        };
        this.checkRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, 300L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$14$ChatEditTypeActivity(final String str) {
        TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = new TLRPC$TL_channels_checkUsername();
        tLRPC$TL_channels_checkUsername.username = str;
        tLRPC$TL_channels_checkUsername.channel = getMessagesController().getInputChannel(this.chatId);
        this.checkReqId = getConnectionsManager().sendRequest(tLRPC$TL_channels_checkUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$VhvgKDcWNyGTOeeqOzT31iBavVI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUserName$13$ChatEditTypeActivity(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$13$ChatEditTypeActivity(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$wSePTBXi7tc7Ni5G_qlE5c4T_sE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$12$ChatEditTypeActivity(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$12$ChatEditTypeActivity(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.checkTextView.setText(LocaleController.formatString("LinkAvailable", R.string.LinkAvailable, str));
            this.checkTextView.setTextColor("windowBackgroundWhiteGreenText");
            this.lastNameAvailable = true;
            return;
        }
        if (tLRPC$TL_error != null && tLRPC$TL_error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH")) {
            this.canCreatePublic = false;
            loadAdminedChannels();
        } else {
            this.checkTextView.setText(LocaleController.getString("LinkInUse", R.string.LinkInUse));
        }
        this.checkTextView.setTextColor("windowBackgroundWhiteRedText4");
        this.lastNameAvailable = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void generateLink(final boolean z) {
        TLRPC$TL_messages_exportChatInvite_layer84 tLRPC$TL_messages_exportChatInvite_layer84;
        this.loadingInvite = true;
        if (ChatObject.isChannel(this.chatId, this.currentAccount)) {
            TLRPC$TL_channels_exportInvite tLRPC$TL_channels_exportInvite = new TLRPC$TL_channels_exportInvite();
            tLRPC$TL_channels_exportInvite.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(this.chatId);
            tLRPC$TL_messages_exportChatInvite_layer84 = tLRPC$TL_channels_exportInvite;
        } else {
            TLRPC$TL_messages_exportChatInvite_layer84 tLRPC$TL_messages_exportChatInvite_layer842 = new TLRPC$TL_messages_exportChatInvite_layer84();
            tLRPC$TL_messages_exportChatInvite_layer842.chat_id = (int) this.chatId;
            tLRPC$TL_messages_exportChatInvite_layer84 = tLRPC$TL_messages_exportChatInvite_layer842;
        }
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_exportChatInvite_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$OX4Cp4JrdCVGUIQX_Y8px5W0rJk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$16$ChatEditTypeActivity(z, tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$16$ChatEditTypeActivity(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$7NY_NlKBvxi74TU8jjqXWzw7e98
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$15$ChatEditTypeActivity(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$15$ChatEditTypeActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            this.invite = (TLRPC$ExportedChatInvite) tLObject;
            if (z) {
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setMessage(LocaleController.getString("RevokeAlertNewLink", R.string.RevokeAlertNewLink));
                builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
                builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                showDialog(builder.create());
            }
        }
        this.loadingInvite = false;
        LinkActionView linkActionView = this.permanentLinkView;
        if (linkActionView != null) {
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = this.invite;
            linkActionView.setLink(tLRPC$ExportedChatInvite != null ? tLRPC$ExportedChatInvite.link : null);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditTypeActivity$uHKhJ6OmRhNvZyzC9FYJDWFy_fc
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$17$ChatEditTypeActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.sectionCell2, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.infoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.infoCell, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.textCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.textCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.textCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.textCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.usernameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.usernameTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.linearLayoutTypeContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linkContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.headerCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.headerCell2, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText8"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGreenText"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.typeInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.manageLinksInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.adminedInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.loadingAdminedCell, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.radioButtonCell1, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioButtonCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.radioButtonCell2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{RadioButtonCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_LINKCOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.adminnedChannelsLayout, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{AdminedChannelCell.class}, new String[]{"deleteButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.manageLinksTextView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$17$ChatEditTypeActivity() {
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
    }
}
