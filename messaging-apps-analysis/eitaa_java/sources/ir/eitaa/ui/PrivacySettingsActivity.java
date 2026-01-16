package ir.eitaa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.features.ChatLock.ChatLockSettingsActivity;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$PrivacyRule;
import ir.eitaa.tgnet.TLRPC$TL_accountDaysTTL;
import ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_password_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_setAccountTTL;
import ir.eitaa.tgnet.TLRPC$TL_boolFalse;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_globalPrivacySettings;
import ir.eitaa.tgnet.TLRPC$TL_mxbRegisterSelf;
import ir.eitaa.tgnet.TLRPC$TL_payments_clearSavedInfo;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueAllowAll;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueAllowChatParticipants;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueAllowUsers;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueDisallowAll;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueDisallowChatParticipants;
import ir.eitaa.tgnet.TLRPC$TL_privacyValueDisallowUsers;
import ir.eitaa.tgnet.TLRPC$account_Password;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.RadioColorCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.PrivacySettingsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PrivacySettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int advancedSectionRow;
    private boolean archiveChats;
    private int blockExternalAdsRow;
    private int blockedRow;
    private int botsDetailRow;
    private int botsSectionRow;
    private int callsRow;
    private int chatLockRow;
    private int contactsDeleteRow;
    private int contactsDetailRow;
    private int contactsSectionRow;
    private int contactsSuggestRow;
    private int contactsSyncRow;
    private TLRPC$TL_account_password currentPassword;
    private TLRPC$account_Password currentPassword_layer84;
    private boolean currentSuggest;
    private boolean currentSync;
    private int deleteAccountDetailRow;
    private int deleteAccountRow;
    private int groupsDetailRow;
    private int groupsRow;
    private int importContactRow;
    private int lastSeenRow;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int mxbRow;
    private int newChatsHeaderRow;
    private int newChatsRow;
    private int newChatsSectionRow;
    private boolean newSuggest;
    private boolean newSync;
    private int passcodeRow;
    private int passportRow;
    private int passwordRow;
    private int paymentsClearRow;
    private int privacySectionRow;
    private AlertDialog progressDialog;
    private int reloadContactRow;
    private int rowCount;
    private int secretDetailRow;
    private int secretMapRow;
    private int secretSectionRow;
    private int secretWebpageRow;
    private int securitySectionRow;
    private int sessionsDetailRow;
    private int sessionsRow;
    private int webSessionsRow;
    private boolean contactsImported = false;
    private boolean contactsReloaded = false;
    private int phoneNumberRow = -1;
    private int profilePhotoRow = -1;
    private int forwardsRow = -1;
    private boolean[] clear = new boolean[2];

    static /* synthetic */ void lambda$createView$12(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$onFragmentDestroy$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$onFragmentDestroy$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getContactsController().loadPrivacySettings();
        getMessagesController().getBlockedPeers(true);
        boolean z = getUserConfig().syncContacts;
        this.newSync = z;
        this.currentSync = z;
        boolean z2 = getUserConfig().suggestContacts;
        this.newSuggest = z2;
        this.currentSuggest = z2;
        TLRPC$TL_globalPrivacySettings globalPrivacySettings = getContactsController().getGlobalPrivacySettings();
        if (globalPrivacySettings != null) {
            this.archiveChats = globalPrivacySettings.archive_and_mute_new_noncontact_peers;
        }
        updateRows();
        loadPasswordSettings_layer84();
        getNotificationCenter().addObserver(this, NotificationCenter.privacyRulesUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.blockedUsersDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.didSetOrRemoveTwoStepPassword);
        getNotificationCenter().addObserver(this, NotificationCenter.mxbStatusNeedReload);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFragmentDestroy() throws java.lang.InterruptedException {
        /*
            r6 = this;
            super.onFragmentDestroy()
            ir.eitaa.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = ir.eitaa.messenger.NotificationCenter.privacyRulesUpdated
            r0.removeObserver(r6, r1)
            ir.eitaa.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = ir.eitaa.messenger.NotificationCenter.blockedUsersDidLoad
            r0.removeObserver(r6, r1)
            ir.eitaa.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = ir.eitaa.messenger.NotificationCenter.didSetOrRemoveTwoStepPassword
            r0.removeObserver(r6, r1)
            ir.eitaa.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = ir.eitaa.messenger.NotificationCenter.mxbStatusNeedReload
            r0.removeObserver(r6, r1)
            boolean r0 = r6.currentSync
            boolean r1 = r6.newSync
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L5c
            ir.eitaa.messenger.UserConfig r0 = r6.getUserConfig()
            boolean r1 = r6.newSync
            r0.syncContacts = r1
            if (r1 == 0) goto L5a
            ir.eitaa.messenger.ContactsController r0 = r6.getContactsController()
            r0.forceImportContacts()
            android.app.Activity r0 = r6.getParentActivity()
            if (r0 == 0) goto L5a
            android.app.Activity r0 = r6.getParentActivity()
            r1 = 2131694416(0x7f0f1350, float:1.9017988E38)
            java.lang.String r4 = "SyncContactsAdded"
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r4, r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
        L5a:
            r0 = 1
            goto L5d
        L5c:
            r0 = 0
        L5d:
            boolean r1 = r6.newSuggest
            boolean r4 = r6.currentSuggest
            if (r1 == r4) goto L87
            if (r1 != 0) goto L6c
            ir.eitaa.messenger.MediaDataController r0 = r6.getMediaDataController()
            r0.clearTopPeers()
        L6c:
            ir.eitaa.messenger.UserConfig r0 = r6.getUserConfig()
            boolean r1 = r6.newSuggest
            r0.suggestContacts = r1
            ir.eitaa.tgnet.TLRPC$TL_contacts_toggleTopPeers r0 = new ir.eitaa.tgnet.TLRPC$TL_contacts_toggleTopPeers
            r0.<init>()
            boolean r1 = r6.newSuggest
            r0.enabled = r1
            ir.eitaa.tgnet.ConnectionsManager r1 = r6.getConnectionsManager()
            ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4 r4 = new ir.eitaa.tgnet.RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4
                static {
                    /*
                        ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4 r0 = new ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4) ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4.INSTANCE ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4.<init>():void");
                }

                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(ir.eitaa.tgnet.TLObject r1, ir.eitaa.tgnet.TLRPC$TL_error r2) {
                    /*
                        r0 = this;
                        ir.eitaa.ui.PrivacySettingsActivity.lambda$onFragmentDestroy$0(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$7xWXZpx98idNhL28zJxon6p7Tl4.run(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
                }
            }
            r1.sendRequest(r0, r4)
            r0 = 1
        L87:
            ir.eitaa.messenger.ContactsController r1 = r6.getContactsController()
            ir.eitaa.tgnet.TLRPC$TL_globalPrivacySettings r1 = r1.getGlobalPrivacySettings()
            if (r1 == 0) goto Lb8
            boolean r4 = r1.archive_and_mute_new_noncontact_peers
            boolean r5 = r6.archiveChats
            if (r4 == r5) goto Lb8
            r1.archive_and_mute_new_noncontact_peers = r5
            ir.eitaa.tgnet.TLRPC$TL_account_setGlobalPrivacySettings r0 = new ir.eitaa.tgnet.TLRPC$TL_account_setGlobalPrivacySettings
            r0.<init>()
            ir.eitaa.tgnet.TLRPC$TL_globalPrivacySettings r1 = new ir.eitaa.tgnet.TLRPC$TL_globalPrivacySettings
            r1.<init>()
            r0.settings = r1
            int r4 = r1.flags
            r4 = r4 | r3
            r1.flags = r4
            boolean r4 = r6.archiveChats
            r1.archive_and_mute_new_noncontact_peers = r4
            ir.eitaa.tgnet.ConnectionsManager r1 = r6.getConnectionsManager()
            ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY r4 = new ir.eitaa.tgnet.RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY
                static {
                    /*
                        ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY r0 = new ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY) ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY.INSTANCE ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$Yk-5BA62wilYd_thIGZBvpd1vlY
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$Yk5BA62wilYd_thIGZBvpd1vlY.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$Yk5BA62wilYd_thIGZBvpd1vlY.<init>():void");
                }

                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(ir.eitaa.tgnet.TLObject r1, ir.eitaa.tgnet.TLRPC$TL_error r2) {
                    /*
                        r0 = this;
                        ir.eitaa.ui.PrivacySettingsActivity.lambda$onFragmentDestroy$1(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.$$Lambda$PrivacySettingsActivity$Yk5BA62wilYd_thIGZBvpd1vlY.run(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
                }
            }
            r1.sendRequest(r0, r4)
            goto Lb9
        Lb8:
            r3 = r0
        Lb9:
            if (r3 == 0) goto Lc2
            ir.eitaa.messenger.UserConfig r0 = r6.getUserConfig()
            r0.saveConfig(r2)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PrivacySettingsActivity.onFragmentDestroy():void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("PrivacySettings", R.string.PrivacySettings));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PrivacySettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    PrivacySettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false) { // from class: ir.eitaa.ui.PrivacySettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$CtmXVZPYaE4Et4yO17w2wCSDSX4
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$15$PrivacySettingsActivity(context, view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$15$PrivacySettingsActivity(Context context, View view, int i) {
        String string;
        int i2;
        String str;
        if (view.isEnabled()) {
            if (i == this.blockedRow) {
                presentFragment(new PrivacyUsersActivity());
                return;
            }
            if (i == this.sessionsRow) {
                presentFragment(new SessionsActivity(0));
                return;
            }
            if (i == this.webSessionsRow) {
                presentFragment(new SessionsActivity(1));
                return;
            }
            if (i == this.deleteAccountRow) {
                if (getParentActivity() == null) {
                    return;
                }
                int deleteAccountTTL = getContactsController().getDeleteAccountTTL();
                int i3 = deleteAccountTTL <= 31 ? 0 : deleteAccountTTL <= 93 ? 1 : deleteAccountTTL <= 182 ? 2 : 3;
                final AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("DeleteAccountTitle", R.string.DeleteAccountTitle));
                String[] strArr = {LocaleController.formatPluralString("Months", 1), LocaleController.formatPluralString("Months", 3), LocaleController.formatPluralString("Months", 6), LocaleController.formatPluralString("Years", 1)};
                LinearLayout linearLayout = new LinearLayout(getParentActivity());
                linearLayout.setOrientation(1);
                builder.setView(linearLayout);
                int i4 = 0;
                while (i4 < 4) {
                    RadioColorCell radioColorCell = new RadioColorCell(getParentActivity());
                    radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                    radioColorCell.setTag(Integer.valueOf(i4));
                    radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
                    radioColorCell.setTextAndValue(strArr[i4], i3 == i4);
                    linearLayout.addView(radioColorCell);
                    radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$814mk0mTXo11UE2V1w9uW4CwgIA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$4$PrivacySettingsActivity(builder, view2);
                        }
                    });
                    i4++;
                }
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder.create());
                return;
            }
            if (i == this.lastSeenRow) {
                presentFragment(new PrivacyControlActivity(0));
                return;
            }
            if (i == this.phoneNumberRow) {
                presentFragment(new PrivacyControlActivity(6));
                return;
            }
            if (i == this.groupsRow) {
                presentFragment(new PrivacyControlActivity(1));
                return;
            }
            if (i == this.blockExternalAdsRow) {
                SharedPreferences sharedPreferences = getParentActivity().getSharedPreferences("mainconfig", 0);
                boolean z = !sharedPreferences.getBoolean("block_ext_ads", false);
                sharedPreferences.edit().putBoolean("block_ext_ads", z).commit();
                sharedPreferences.edit().putBoolean("block_ext_ads_alert", true).commit();
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(z);
                    return;
                }
                return;
            }
            if (i == this.mxbRow) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
                builder2.setTitle(LocaleController.getString("MXB", R.string.MXB));
                if (UserConfig.mxbState && MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled) {
                    i2 = R.string.MembershipDisabledMXB;
                    str = "MembershipDisabledMXB";
                } else {
                    i2 = R.string.MembershipActivatedMXB;
                    str = "MembershipActivatedMXB";
                }
                builder2.setMessage(LocaleController.getString(str, i2));
                builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new AnonymousClass3(context, view));
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.PrivacySettingsActivity.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder2.create().show();
                return;
            }
            if (i == this.callsRow) {
                presentFragment(new PrivacyControlActivity(2));
                return;
            }
            if (i == this.profilePhotoRow) {
                presentFragment(new PrivacyControlActivity(4));
                return;
            }
            if (i == this.forwardsRow) {
                presentFragment(new PrivacyControlActivity(5));
                return;
            }
            if (i == this.passwordRow) {
                TLRPC$account_Password tLRPC$account_Password = this.currentPassword_layer84;
                if (tLRPC$account_Password == null) {
                    return;
                }
                if (tLRPC$account_Password instanceof TLRPC$TL_account_password_layer84) {
                    presentFragment(new TwoStepVerificationActivity84(0));
                    return;
                } else {
                    TextUtils.isEmpty(tLRPC$account_Password.email_unconfirmed_pattern);
                    presentFragment(new TwoStepVerificationActivity84(0));
                    return;
                }
            }
            if (i == this.passcodeRow) {
                if (SharedConfig.passcodeHash.length() > 0) {
                    presentFragment(new PasscodeActivity(2));
                    return;
                } else {
                    presentFragment(new PasscodeActivity(0));
                    return;
                }
            }
            if (i == this.chatLockRow) {
                if (SharedConfig.chatLockPasscodeHash.length() > 0) {
                    presentFragment(new ChatLockSettingsActivity(2));
                    return;
                } else {
                    presentFragment(new ChatLockSettingsActivity(0));
                    return;
                }
            }
            if (i == this.secretWebpageRow) {
                if (getMessagesController().secretWebpagePreview == 1) {
                    getMessagesController().secretWebpagePreview = 0;
                } else {
                    getMessagesController().secretWebpagePreview = 1;
                }
                MessagesController.getGlobalMainSettings().edit().putInt("secretWebpage2", getMessagesController().secretWebpagePreview).commit();
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(getMessagesController().secretWebpagePreview == 1);
                    return;
                }
                return;
            }
            if (i == this.contactsDeleteRow) {
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
                builder3.setTitle(LocaleController.getString("SyncContactsDeleteTitle", R.string.SyncContactsDeleteTitle));
                builder3.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("SyncContactsDeleteText", R.string.SyncContactsDeleteText)));
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder3.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$wWaSdbKTPpB8XEp2BFBQx7q7aBg
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$createView$6$PrivacySettingsActivity(dialogInterface, i5);
                    }
                });
                AlertDialog alertDialogCreate = builder3.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            if (i == this.importContactRow) {
                if (!this.contactsImported) {
                    this.contactsImported = true;
                    UserConfig.getInstance(this.currentAccount).syncContacts = true;
                    UserConfig.getInstance(this.currentAccount).saveConfig(false);
                    ContactsController.getInstance(this.currentAccount).forceImportContacts();
                }
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder4 = new AlertDialog.Builder(getParentActivity());
                builder4.setTitle(LocaleController.getString("Contacts", R.string.Contacts));
                builder4.setMessage(LocaleController.getString("OperationDone", R.string.OperationDone));
                builder4.setPositiveButton(LocaleController.getString("Done", R.string.Done), null);
                showDialog(builder4.create());
                return;
            }
            if (i == this.reloadContactRow) {
                if (!this.contactsReloaded) {
                    this.contactsReloaded = true;
                    ContactsController.getInstance(this.currentAccount).loadContacts(false, 0L);
                }
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder5 = new AlertDialog.Builder(getParentActivity());
                builder5.setTitle(LocaleController.getString("Contacts", R.string.Contacts));
                builder5.setMessage(LocaleController.getString("OperationDone", R.string.OperationDone));
                builder5.setPositiveButton(LocaleController.getString("Done", R.string.Done), null);
                showDialog(builder5.create());
                return;
            }
            if (i == this.contactsSuggestRow) {
                final TextCheckCell textCheckCell = (TextCheckCell) view;
                if (this.newSuggest) {
                    AlertDialog.Builder builder6 = new AlertDialog.Builder(getParentActivity());
                    builder6.setTitle(LocaleController.getString("SuggestContactsTitle", R.string.SuggestContactsTitle));
                    builder6.setMessage(LocaleController.getString("SuggestContactsAlert", R.string.SuggestContactsAlert));
                    builder6.setPositiveButton(LocaleController.getString("MuteDisable", R.string.MuteDisable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$CUknZpmp5klNXYk8WF-N1_3o9TU
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i5) {
                            this.f$0.lambda$createView$9$PrivacySettingsActivity(textCheckCell, dialogInterface, i5);
                        }
                    });
                    builder6.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate2 = builder6.create();
                    showDialog(alertDialogCreate2);
                    TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
                    if (textView2 != null) {
                        textView2.setTextColor(Theme.getColor("dialogTextRed2"));
                        return;
                    }
                    return;
                }
                this.newSuggest = true;
                textCheckCell.setChecked(true);
                return;
            }
            if (i == this.newChatsRow) {
                boolean z2 = !this.archiveChats;
                this.archiveChats = z2;
                ((TextCheckCell) view).setChecked(z2);
                return;
            }
            if (i == this.contactsSyncRow) {
                boolean z3 = !this.newSync;
                this.newSync = z3;
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(z3);
                    return;
                }
                return;
            }
            if (i == this.secretMapRow) {
                AlertsCreator.showSecretLocationAlert(getParentActivity(), this.currentAccount, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$XCYjbnPesQoTo4_A07FDg73pF08
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createView$10$PrivacySettingsActivity();
                    }
                }, false, null);
                return;
            }
            if (i == this.paymentsClearRow) {
                AlertDialog.Builder builder7 = new AlertDialog.Builder(getParentActivity());
                builder7.setTitle(LocaleController.getString("PrivacyPaymentsClearAlertTitle", R.string.PrivacyPaymentsClearAlertTitle));
                builder7.setMessage(LocaleController.getString("PrivacyPaymentsClearAlertText", R.string.PrivacyPaymentsClearAlertText));
                LinearLayout linearLayout2 = new LinearLayout(getParentActivity());
                linearLayout2.setOrientation(1);
                builder7.setView(linearLayout2);
                for (int i5 = 0; i5 < 2; i5++) {
                    if (i5 == 0) {
                        string = LocaleController.getString("PrivacyClearShipping", R.string.PrivacyClearShipping);
                    } else {
                        string = LocaleController.getString("PrivacyClearPayment", R.string.PrivacyClearPayment);
                    }
                    this.clear[i5] = true;
                    CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1, 21, null);
                    checkBoxCell.setTag(Integer.valueOf(i5));
                    checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                    checkBoxCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                    linearLayout2.addView(checkBoxCell, LayoutHelper.createLinear(-1, 50));
                    checkBoxCell.setText(string, null, true, false);
                    checkBoxCell.setTextColor(Theme.getColor("dialogTextBlack"));
                    checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$2TnBbYFaoMtWSGIZuNdV9gu476k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$11$PrivacySettingsActivity(view2);
                        }
                    });
                }
                builder7.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$m7iPdqMhlWaW_KRWpyhRqyfRHu0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        this.f$0.lambda$createView$14$PrivacySettingsActivity(dialogInterface, i6);
                    }
                });
                builder7.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder7.create());
                AlertDialog alertDialogCreate3 = builder7.create();
                showDialog(alertDialogCreate3);
                TextView textView3 = (TextView) alertDialogCreate3.getButton(-1);
                if (textView3 != null) {
                    textView3.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            if (i == this.passportRow) {
                presentFragment(new PassportActivity(5, 0L, "", "", (String) null, (String) null, (String) null, (TLRPC$TL_account_authorizationForm) null, (TLRPC$TL_account_password) null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$PrivacySettingsActivity(AlertDialog.Builder builder, View view) {
        int i;
        builder.getDismissRunnable().run();
        Integer num = (Integer) view.getTag();
        if (num.intValue() == 0) {
            i = 30;
        } else if (num.intValue() == 1) {
            i = 90;
        } else if (num.intValue() == 2) {
            i = 182;
        } else {
            i = num.intValue() == 3 ? 365 : 0;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        final TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL = new TLRPC$TL_account_setAccountTTL();
        TLRPC$TL_accountDaysTTL tLRPC$TL_accountDaysTTL = new TLRPC$TL_accountDaysTTL();
        tLRPC$TL_account_setAccountTTL.ttl = tLRPC$TL_accountDaysTTL;
        tLRPC$TL_accountDaysTTL.days = i;
        getConnectionsManager().sendRequest(tLRPC$TL_account_setAccountTTL, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$_yXv9rHJvqEiGQQsR9ObeIAyqtA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$3$PrivacySettingsActivity(alertDialog, tLRPC$TL_account_setAccountTTL, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$PrivacySettingsActivity(final AlertDialog alertDialog, final TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$SvW4Q3SbyimkdG6VakjxJH9UN1k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$2$PrivacySettingsActivity(alertDialog, tLObject, tLRPC$TL_account_setAccountTTL);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$PrivacySettingsActivity(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            getContactsController().setDeleteAccountTTL(tLRPC$TL_account_setAccountTTL.ttl.days);
            this.listAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: ir.eitaa.ui.PrivacySettingsActivity$3, reason: invalid class name */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ View val$view;

        AnonymousClass3(final Context val$context, final View val$view) {
            this.val$context = val$context;
            this.val$view = val$view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            final boolean z = (UserConfig.mxbState && MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled) ? false : true;
            TLRPC$TL_mxbRegisterSelf tLRPC$TL_mxbRegisterSelf = new TLRPC$TL_mxbRegisterSelf();
            tLRPC$TL_mxbRegisterSelf.flags = z ? TLRPC$TL_mxbRegisterSelf.REGISTER : TLRPC$TL_mxbRegisterSelf.UN_REGISTER;
            final AlertDialog alertDialog = new AlertDialog(this.val$context, 3);
            alertDialog.setCanCacnel(false);
            alertDialog.show();
            ConnectionsManager connectionsManager = PrivacySettingsActivity.this.getConnectionsManager();
            final View view = this.val$view;
            final Context context = this.val$context;
            connectionsManager.sendRequest(tLRPC$TL_mxbRegisterSelf, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$3$K-cH_Pwe-FqCAF83o3oHuy75Wdg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$3$OF7z9ASLp135pRAGf2ygQh-vvBc
                        @Override // java.lang.Runnable
                        public final void run() {
                            PrivacySettingsActivity.AnonymousClass3.lambda$onClick$0(alertDialog, tLObject, z, view, context);
                        }
                    });
                }
            });
        }

        static /* synthetic */ void lambda$onClick$0(AlertDialog alertDialog, TLObject tLObject, boolean z, View view, Context context) {
            alertDialog.dismiss();
            if (tLObject != null && (tLObject instanceof TLRPC$TL_boolTrue)) {
                UserConfig.getInstance(UserConfig.selectedAccount).setMxbState(z);
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(z);
                    return;
                }
                return;
            }
            if (tLObject != null && (tLObject instanceof TLRPC$TL_boolFalse)) {
                Toast.makeText(context, "خطا در تغیر وضعیت MXB", 0).show();
            } else {
                Toast.makeText(context, LocaleController.getString("ConnectionErrorMXB", R.string.ConnectionErrorMXB), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$PrivacySettingsActivity(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialogShow = new AlertDialog.Builder(getParentActivity(), 3, null).show();
        this.progressDialog = alertDialogShow;
        alertDialogShow.setCanCacnel(false);
        if (this.currentSync != this.newSync) {
            UserConfig userConfig = getUserConfig();
            boolean z = this.newSync;
            userConfig.syncContacts = z;
            this.currentSync = z;
            getUserConfig().saveConfig(false);
        }
        getContactsController().deleteAllContacts(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$6LqhHnuqdXX-oLCOoh8z2CMK25k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$5$PrivacySettingsActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$PrivacySettingsActivity() {
        this.progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$PrivacySettingsActivity(final TextCheckCell textCheckCell, DialogInterface dialogInterface, int i) {
        TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
        boolean[] zArr = this.clear;
        tLRPC$TL_payments_clearSavedInfo.credentials = zArr[1];
        tLRPC$TL_payments_clearSavedInfo.info = zArr[0];
        getUserConfig().tmpPassword = null;
        getUserConfig().saveConfig(false);
        getConnectionsManager().sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$ssIUuPZerIdxEcPQBPStv8j6W40
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$8$PrivacySettingsActivity(textCheckCell, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$PrivacySettingsActivity(final TextCheckCell textCheckCell, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$liXoXpiJTTlgUc_MSVDTmv_T2Q0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$7$PrivacySettingsActivity(textCheckCell);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$PrivacySettingsActivity(TextCheckCell textCheckCell) {
        boolean z = !this.newSuggest;
        this.newSuggest = z;
        textCheckCell.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$PrivacySettingsActivity() {
        this.listAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$PrivacySettingsActivity(View view) {
        CheckBoxCell checkBoxCell = (CheckBoxCell) view;
        int iIntValue = ((Integer) checkBoxCell.getTag()).intValue();
        boolean[] zArr = this.clear;
        zArr[iIntValue] = !zArr[iIntValue];
        checkBoxCell.setChecked(zArr[iIntValue], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$14$PrivacySettingsActivity(DialogInterface dialogInterface, int i) {
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PrivacyPaymentsClearAlertTitle", R.string.PrivacyPaymentsClearAlertTitle));
        builder.setMessage(LocaleController.getString("PrivacyPaymentsClearAlert", R.string.PrivacyPaymentsClearAlert));
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$-k3k7ih0plLlHASM_mPIdeR4rBQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                this.f$0.lambda$createView$13$PrivacySettingsActivity(dialogInterface2, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$PrivacySettingsActivity(DialogInterface dialogInterface, int i) {
        String string;
        TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
        boolean[] zArr = this.clear;
        tLRPC$TL_payments_clearSavedInfo.credentials = zArr[1];
        tLRPC$TL_payments_clearSavedInfo.info = zArr[0];
        getUserConfig().tmpPassword = null;
        getUserConfig().saveConfig(false);
        getConnectionsManager().sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PrivacySettingsActivity$5_K2IJlfUYi5WDOrxuBkpWUIeK4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                PrivacySettingsActivity.lambda$createView$12(tLObject, tLRPC$TL_error);
            }
        });
        boolean[] zArr2 = this.clear;
        if (zArr2[0] && zArr2[1]) {
            string = LocaleController.getString("PrivacyPaymentsPaymentShippingCleared", R.string.PrivacyPaymentsPaymentShippingCleared);
        } else if (zArr2[0]) {
            string = LocaleController.getString("PrivacyPaymentsShippingInfoCleared", R.string.PrivacyPaymentsShippingInfoCleared);
        } else if (!zArr2[1]) {
            return;
        } else {
            string = LocaleController.getString("PrivacyPaymentsPaymentInfoCleared", R.string.PrivacyPaymentsPaymentInfoCleared);
        }
        BulletinFactory.of(this).createSimpleBulletin(R.raw.chats_infotip, string).show();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.privacyRulesUpdated) {
            TLRPC$TL_globalPrivacySettings globalPrivacySettings = getContactsController().getGlobalPrivacySettings();
            if (globalPrivacySettings != null) {
                this.archiveChats = globalPrivacySettings.archive_and_mute_new_noncontact_peers;
            }
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (id == NotificationCenter.blockedUsersDidLoad) {
            this.listAdapter.notifyItemChanged(this.blockedRow);
            return;
        }
        if (id == NotificationCenter.didSetOrRemoveTwoStepPassword) {
            if (args.length > 0) {
                this.currentPassword = (TLRPC$TL_account_password) args[0];
                ListAdapter listAdapter2 = this.listAdapter;
                if (listAdapter2 != null) {
                    listAdapter2.notifyItemChanged(this.passwordRow);
                    return;
                }
                return;
            }
            this.currentPassword = null;
            loadPasswordSettings_layer84();
            updateRows();
            return;
        }
        if (id == NotificationCenter.mxbStatusNeedReload) {
            updateRows();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.privacySectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.blockedRow = i;
        this.rowCount = i2 + 1;
        this.lastSeenRow = i2;
        if (MessagesController.getInstance(this.currentAccount).callsEnabled) {
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            this.callsRow = i3;
        } else {
            this.callsRow = -1;
        }
        int i4 = this.rowCount;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.groupsRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.groupsDetailRow = i5;
        this.rowCount = i6 + 1;
        this.blockExternalAdsRow = i6;
        if (MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            this.mxbRow = i7;
        } else {
            this.mxbRow = -1;
        }
        int i8 = this.rowCount;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.securitySectionRow = i8;
        int i10 = i9 + 1;
        this.rowCount = i10;
        this.passcodeRow = i9;
        int i11 = i10 + 1;
        this.rowCount = i11;
        this.chatLockRow = i10;
        int i12 = i11 + 1;
        this.rowCount = i12;
        this.passwordRow = i11;
        int i13 = i12 + 1;
        this.rowCount = i13;
        this.sessionsRow = i12;
        this.rowCount = i13 + 1;
        this.sessionsDetailRow = i13;
        if (getMessagesController().autoarchiveAvailable) {
            int i14 = this.rowCount;
            int i15 = i14 + 1;
            this.rowCount = i15;
            this.newChatsHeaderRow = i14;
            int i16 = i15 + 1;
            this.rowCount = i16;
            this.newChatsRow = i15;
            this.rowCount = i16 + 1;
            this.newChatsSectionRow = i16;
        } else {
            this.newChatsHeaderRow = -1;
            this.newChatsRow = -1;
            this.newChatsSectionRow = -1;
        }
        this.advancedSectionRow = -1;
        this.deleteAccountRow = -1;
        this.deleteAccountDetailRow = -1;
        this.botsSectionRow = -1;
        if (getUserConfig().hasSecureData) {
            int i17 = this.rowCount;
            this.rowCount = i17 + 1;
            this.passportRow = i17;
        } else {
            this.passportRow = -1;
        }
        this.paymentsClearRow = -1;
        this.webSessionsRow = -1;
        this.botsDetailRow = -1;
        int i18 = this.rowCount;
        int i19 = i18 + 1;
        this.rowCount = i19;
        this.contactsSectionRow = i18;
        int i20 = i19 + 1;
        this.rowCount = i20;
        this.contactsDeleteRow = i19;
        int i21 = i20 + 1;
        this.rowCount = i21;
        this.contactsSyncRow = i20;
        int i22 = i21 + 1;
        this.rowCount = i22;
        this.contactsSuggestRow = i21;
        int i23 = i22 + 1;
        this.rowCount = i23;
        this.importContactRow = i22;
        int i24 = i23 + 1;
        this.rowCount = i24;
        this.reloadContactRow = i23;
        this.rowCount = i24 + 1;
        this.contactsDetailRow = i24;
        this.secretSectionRow = -1;
        this.secretMapRow = -1;
        this.secretWebpageRow = -1;
        this.secretDetailRow = -1;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private void loadPasswordSettings_layer84() {
        if (UserConfig.getInstance(this.currentAccount).hasSecureData) {
            return;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword_layer84(), new RequestDelegate() { // from class: ir.eitaa.ui.PrivacySettingsActivity.5
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                if (response != null) {
                    TLRPC$account_Password tLRPC$account_Password = (TLRPC$account_Password) response;
                    PrivacySettingsActivity.this.currentPassword_layer84 = tLRPC$account_Password;
                    if (tLRPC$account_Password.has_secure_values) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.PrivacySettingsActivity.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                UserConfig.getInstance(((BaseFragment) PrivacySettingsActivity.this).currentAccount).hasSecureData = true;
                                UserConfig.getInstance(((BaseFragment) PrivacySettingsActivity.this).currentAccount).saveConfig(false);
                                PrivacySettingsActivity.this.updateRows();
                            }
                        });
                    }
                }
            }
        }, 10);
    }

    public static String formatRulesString(AccountInstance accountInstance, int rulesType) {
        ArrayList<TLRPC$PrivacyRule> privacyRules = accountInstance.getContactsController().getPrivacyRules(rulesType);
        if (privacyRules.size() == 0) {
            if (rulesType == 3) {
                return LocaleController.getString("P2PNobody", R.string.P2PNobody);
            }
            return LocaleController.getString("LastSeenNobody", R.string.LastSeenNobody);
        }
        char c = 65535;
        int size = 0;
        int size2 = 0;
        for (int i = 0; i < privacyRules.size(); i++) {
            TLRPC$PrivacyRule tLRPC$PrivacyRule = privacyRules.get(i);
            if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueAllowChatParticipants) {
                TLRPC$TL_privacyValueAllowChatParticipants tLRPC$TL_privacyValueAllowChatParticipants = (TLRPC$TL_privacyValueAllowChatParticipants) tLRPC$PrivacyRule;
                int size3 = tLRPC$TL_privacyValueAllowChatParticipants.chats.size();
                for (int i2 = 0; i2 < size3; i2++) {
                    TLRPC$Chat chat = accountInstance.getMessagesController().getChat(tLRPC$TL_privacyValueAllowChatParticipants.chats.get(i2));
                    if (chat != null) {
                        size2 += chat.participants_count;
                    }
                }
            } else if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueDisallowChatParticipants) {
                TLRPC$TL_privacyValueDisallowChatParticipants tLRPC$TL_privacyValueDisallowChatParticipants = (TLRPC$TL_privacyValueDisallowChatParticipants) tLRPC$PrivacyRule;
                int size4 = tLRPC$TL_privacyValueDisallowChatParticipants.chats.size();
                for (int i3 = 0; i3 < size4; i3++) {
                    TLRPC$Chat chat2 = accountInstance.getMessagesController().getChat(tLRPC$TL_privacyValueDisallowChatParticipants.chats.get(i3));
                    if (chat2 != null) {
                        size += chat2.participants_count;
                    }
                }
            } else if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueAllowUsers) {
                size2 += ((TLRPC$TL_privacyValueAllowUsers) tLRPC$PrivacyRule).users.size();
            } else if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueDisallowUsers) {
                size += ((TLRPC$TL_privacyValueDisallowUsers) tLRPC$PrivacyRule).users.size();
            } else if (c == 65535) {
                if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueAllowAll) {
                    c = 0;
                } else {
                    c = tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueDisallowAll ? (char) 1 : (char) 2;
                }
            }
        }
        if (c == 0 || (c == 65535 && size > 0)) {
            return rulesType == 3 ? size == 0 ? LocaleController.getString("P2PEverybody", R.string.P2PEverybody) : LocaleController.formatString("P2PEverybodyMinus", R.string.P2PEverybodyMinus, Integer.valueOf(size)) : size == 0 ? LocaleController.getString("LastSeenEverybody", R.string.LastSeenEverybody) : LocaleController.formatString("LastSeenEverybodyMinus", R.string.LastSeenEverybodyMinus, Integer.valueOf(size));
        }
        if (c != 2 && (c != 65535 || size <= 0 || size2 <= 0)) {
            return (c == 1 || size2 > 0) ? rulesType == 3 ? size2 == 0 ? LocaleController.getString("P2PNobody", R.string.P2PNobody) : LocaleController.formatString("P2PNobodyPlus", R.string.P2PNobodyPlus, Integer.valueOf(size2)) : size2 == 0 ? LocaleController.getString("LastSeenNobody", R.string.LastSeenNobody) : LocaleController.formatString("LastSeenNobodyPlus", R.string.LastSeenNobodyPlus, Integer.valueOf(size2)) : "unknown";
        }
        if (rulesType == 3) {
            if (size2 == 0 && size == 0) {
                return LocaleController.getString("P2PContacts", R.string.P2PContacts);
            }
            return (size2 == 0 || size == 0) ? size != 0 ? LocaleController.formatString("P2PContactsMinus", R.string.P2PContactsMinus, Integer.valueOf(size)) : LocaleController.formatString("P2PContactsPlus", R.string.P2PContactsPlus, Integer.valueOf(size2)) : LocaleController.formatString("P2PContactsMinusPlus", R.string.P2PContactsMinusPlus, Integer.valueOf(size), Integer.valueOf(size2));
        }
        if (size2 == 0 && size == 0) {
            return LocaleController.getString("LastSeenContacts", R.string.LastSeenContacts);
        }
        return (size2 == 0 || size == 0) ? size != 0 ? LocaleController.formatString("LastSeenContactsMinus", R.string.LastSeenContactsMinus, Integer.valueOf(size)) : LocaleController.formatString("LastSeenContactsPlus", R.string.LastSeenContactsPlus, Integer.valueOf(size2)) : LocaleController.formatString("LastSeenContactsMinusPlus", R.string.LastSeenContactsMinusPlus, Integer.valueOf(size), Integer.valueOf(size2));
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == PrivacySettingsActivity.this.passcodeRow || adapterPosition == PrivacySettingsActivity.this.passwordRow || adapterPosition == PrivacySettingsActivity.this.blockedRow || adapterPosition == PrivacySettingsActivity.this.sessionsRow || adapterPosition == PrivacySettingsActivity.this.secretWebpageRow || adapterPosition == PrivacySettingsActivity.this.blockExternalAdsRow || adapterPosition == PrivacySettingsActivity.this.mxbRow || adapterPosition == PrivacySettingsActivity.this.webSessionsRow || adapterPosition == PrivacySettingsActivity.this.chatLockRow || (adapterPosition == PrivacySettingsActivity.this.groupsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(1)) || ((adapterPosition == PrivacySettingsActivity.this.lastSeenRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(0)) || ((adapterPosition == PrivacySettingsActivity.this.callsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(2)) || ((adapterPosition == PrivacySettingsActivity.this.profilePhotoRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(4)) || ((adapterPosition == PrivacySettingsActivity.this.forwardsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(5)) || ((adapterPosition == PrivacySettingsActivity.this.phoneNumberRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(6)) || ((adapterPosition == PrivacySettingsActivity.this.deleteAccountRow && !PrivacySettingsActivity.this.getContactsController().getLoadingDeleteInfo()) || ((adapterPosition == PrivacySettingsActivity.this.newChatsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingGlobalSettings()) || adapterPosition == PrivacySettingsActivity.this.paymentsClearRow || adapterPosition == PrivacySettingsActivity.this.secretMapRow || adapterPosition == PrivacySettingsActivity.this.contactsSyncRow || adapterPosition == PrivacySettingsActivity.this.passportRow || adapterPosition == PrivacySettingsActivity.this.contactsDeleteRow || adapterPosition == PrivacySettingsActivity.this.contactsSuggestRow || adapterPosition == PrivacySettingsActivity.this.importContactRow || adapterPosition == PrivacySettingsActivity.this.reloadContactRow)))))));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacySettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textSettingsCell;
            if (viewType == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (viewType == 2) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                textSettingsCell = new TextCheckCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            int itemViewType = holder.getItemViewType();
            boolean z = false;
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position != PrivacySettingsActivity.this.deleteAccountDetailRow) {
                        if (position != PrivacySettingsActivity.this.groupsDetailRow) {
                            if (position != PrivacySettingsActivity.this.sessionsDetailRow) {
                                if (position != PrivacySettingsActivity.this.secretDetailRow) {
                                    if (position != PrivacySettingsActivity.this.botsDetailRow) {
                                        if (position != PrivacySettingsActivity.this.contactsDetailRow) {
                                            if (position == PrivacySettingsActivity.this.newChatsSectionRow) {
                                                textInfoPrivacyCell.setText(LocaleController.getString("ArchiveAndMuteInfo", R.string.ArchiveAndMuteInfo));
                                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                                return;
                                            }
                                            return;
                                        }
                                        textInfoPrivacyCell.setText(LocaleController.getString("SuggestContactsInfo", R.string.SuggestContactsInfo));
                                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                        return;
                                    }
                                    textInfoPrivacyCell.setText(LocaleController.getString("PrivacyBotsInfo", R.string.PrivacyBotsInfo));
                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                    return;
                                }
                                textInfoPrivacyCell.setText(LocaleController.getString("SecretWebPageInfo", R.string.SecretWebPageInfo));
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                return;
                            }
                            textInfoPrivacyCell.setText(LocaleController.getString("SessionsInfo", R.string.SessionsInfo));
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                            return;
                        }
                        textInfoPrivacyCell.setText(LocaleController.getString("GroupsAndChannelsHelp", R.string.GroupsAndChannelsHelp));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        return;
                    }
                    textInfoPrivacyCell.setText(LocaleController.getString("DeleteAccountHelp", R.string.DeleteAccountHelp));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        return;
                    }
                    TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                    if (position != PrivacySettingsActivity.this.secretWebpageRow) {
                        if (position == PrivacySettingsActivity.this.contactsSyncRow) {
                            textCheckCell.setTextAndCheck(LocaleController.getString("SyncContacts", R.string.SyncContacts), PrivacySettingsActivity.this.newSync, true);
                            return;
                        }
                        if (position != PrivacySettingsActivity.this.blockExternalAdsRow) {
                            if (position != PrivacySettingsActivity.this.mxbRow) {
                                if (position == PrivacySettingsActivity.this.contactsSuggestRow) {
                                    textCheckCell.setTextAndCheck(LocaleController.getString("SuggestContacts", R.string.SuggestContacts), PrivacySettingsActivity.this.newSuggest, true);
                                    return;
                                } else {
                                    if (position == PrivacySettingsActivity.this.newChatsRow) {
                                        textCheckCell.setTextAndCheck(LocaleController.getString("ArchiveAndMute", R.string.ArchiveAndMute), PrivacySettingsActivity.this.archiveChats, false);
                                        return;
                                    }
                                    return;
                                }
                            }
                            textCheckCell.setTextAndValueAndCheck(LocaleController.getString("CommunicationWithOther", R.string.CommunicationWithOther), LocaleController.getString("ExchangeMessagesWithOtherMessengers", R.string.ExchangeMessagesWithOtherMessengers), UserConfig.mxbState && MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled, true, false);
                            return;
                        }
                        textCheckCell.setTextAndValueAndCheck(LocaleController.getString("BlockAds", R.string.BlockAds), LocaleController.getString("BlockAdsDetail", R.string.BlockAdsDetail), PrivacySettingsActivity.this.getParentActivity().getSharedPreferences("mainconfig", 0).getBoolean("block_ext_ads", false), true, false);
                        return;
                    }
                    textCheckCell.setTextAndCheck(LocaleController.getString("SecretWebPage", R.string.SecretWebPage), PrivacySettingsActivity.this.getMessagesController().secretWebpagePreview == 1, false);
                    return;
                }
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position != PrivacySettingsActivity.this.privacySectionRow) {
                    if (position != PrivacySettingsActivity.this.securitySectionRow) {
                        if (position != PrivacySettingsActivity.this.advancedSectionRow) {
                            if (position != PrivacySettingsActivity.this.secretSectionRow) {
                                if (position != PrivacySettingsActivity.this.botsSectionRow) {
                                    if (position != PrivacySettingsActivity.this.contactsSectionRow) {
                                        if (position == PrivacySettingsActivity.this.newChatsHeaderRow) {
                                            headerCell.setText(LocaleController.getString("NewChatsFromNonContacts", R.string.NewChatsFromNonContacts));
                                            return;
                                        }
                                        return;
                                    }
                                    headerCell.setText(LocaleController.getString("Contacts", R.string.Contacts));
                                    return;
                                }
                                headerCell.setText(LocaleController.getString("PrivacyBots", R.string.PrivacyBots));
                                return;
                            }
                            headerCell.setText(LocaleController.getString("SecretChat", R.string.SecretChat));
                            return;
                        }
                        headerCell.setText(LocaleController.getString("DeleteMyAccount", R.string.DeleteMyAccount));
                        return;
                    }
                    headerCell.setText(LocaleController.getString("SecurityTitle", R.string.SecurityTitle));
                    return;
                }
                headerCell.setText(LocaleController.getString("PrivacyTitle", R.string.PrivacyTitle));
                return;
            }
            String pluralString = null;
            int i = 16;
            boolean z2 = holder.itemView.getTag() != null && ((Integer) holder.itemView.getTag()).intValue() == position;
            holder.itemView.setTag(Integer.valueOf(position));
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            if (position != PrivacySettingsActivity.this.blockedRow) {
                if (position != PrivacySettingsActivity.this.sessionsRow) {
                    if (position != PrivacySettingsActivity.this.webSessionsRow) {
                        if (position == PrivacySettingsActivity.this.passwordRow) {
                            if (PrivacySettingsActivity.this.currentPassword_layer84 == null) {
                                z = true;
                            } else if (PrivacySettingsActivity.this.currentPassword_layer84 instanceof TLRPC$TL_account_password_layer84) {
                                pluralString = LocaleController.getString("PasswordOn", R.string.PasswordOn);
                            } else {
                                pluralString = LocaleController.getString("PasswordOff", R.string.PasswordOff);
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("TwoStepVerification", R.string.TwoStepVerification), pluralString, true);
                        } else if (position != PrivacySettingsActivity.this.passcodeRow) {
                            if (position != PrivacySettingsActivity.this.chatLockRow) {
                                if (position == PrivacySettingsActivity.this.phoneNumberRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(6)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 6);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyPhone", R.string.PrivacyPhone), pluralString, true);
                                } else if (position == PrivacySettingsActivity.this.lastSeenRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(0)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 0);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyLastSeen", R.string.PrivacyLastSeen), pluralString, true);
                                } else if (position == PrivacySettingsActivity.this.groupsRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(1)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 1);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("GroupsAndChannels", R.string.GroupsAndChannels), pluralString, true);
                                } else if (position == PrivacySettingsActivity.this.callsRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(2)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 2);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("Calls", R.string.Calls), pluralString, true);
                                } else if (position == PrivacySettingsActivity.this.profilePhotoRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(4)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 4);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyProfilePhoto", R.string.PrivacyProfilePhoto), pluralString, true);
                                } else if (position == PrivacySettingsActivity.this.forwardsRow) {
                                    if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(5)) {
                                        z = true;
                                        i = 30;
                                    } else {
                                        pluralString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 5);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyForwards", R.string.PrivacyForwards), pluralString, true);
                                } else if (position != PrivacySettingsActivity.this.passportRow) {
                                    if (position == PrivacySettingsActivity.this.deleteAccountRow) {
                                        if (!PrivacySettingsActivity.this.getContactsController().getLoadingDeleteInfo()) {
                                            int deleteAccountTTL = PrivacySettingsActivity.this.getContactsController().getDeleteAccountTTL();
                                            if (deleteAccountTTL <= 182) {
                                                pluralString = LocaleController.formatPluralString("Months", deleteAccountTTL / 30);
                                            } else if (deleteAccountTTL == 365) {
                                                pluralString = LocaleController.formatPluralString("Years", deleteAccountTTL / 365);
                                            } else {
                                                pluralString = LocaleController.formatPluralString("Days", deleteAccountTTL);
                                            }
                                            z = false;
                                        }
                                        textSettingsCell.setTextAndValue(LocaleController.getString("DeleteAccountIfAwayFor3", R.string.DeleteAccountIfAwayFor3), pluralString, false);
                                        z = z;
                                    } else if (position != PrivacySettingsActivity.this.paymentsClearRow) {
                                        if (position != PrivacySettingsActivity.this.secretMapRow) {
                                            if (position != PrivacySettingsActivity.this.contactsDeleteRow) {
                                                if (position != PrivacySettingsActivity.this.importContactRow) {
                                                    if (position == PrivacySettingsActivity.this.reloadContactRow) {
                                                        textSettingsCell.setText(LocaleController.getString("DebugMenuReloadContacts", R.string.DebugMenuReloadContacts), false);
                                                    }
                                                } else {
                                                    textSettingsCell.setText(LocaleController.getString("DebugMenuImportContacts", R.string.DebugMenuImportContacts), true);
                                                }
                                            } else {
                                                textSettingsCell.setText(LocaleController.getString("SyncContactsDelete", R.string.SyncContactsDelete), true);
                                            }
                                        } else {
                                            int i2 = SharedConfig.mapPreviewType;
                                            if (i2 == 0) {
                                                string = LocaleController.getString("MapPreviewProviderEitaa ", R.string.MapPreviewProviderEitaa);
                                            } else if (i2 == 1) {
                                                string = LocaleController.getString("MapPreviewProviderGoogle", R.string.MapPreviewProviderGoogle);
                                            } else if (i2 == 2) {
                                                string = LocaleController.getString("MapPreviewProviderNobody", R.string.MapPreviewProviderNobody);
                                            } else {
                                                string = LocaleController.getString("MapPreviewProviderYandex", R.string.MapPreviewProviderYandex);
                                            }
                                            textSettingsCell.setTextAndValue(LocaleController.getString("MapPreviewProvider", R.string.MapPreviewProvider), string, true);
                                        }
                                    } else {
                                        textSettingsCell.setText(LocaleController.getString("PrivacyPaymentsClear", R.string.PrivacyPaymentsClear), true);
                                    }
                                } else {
                                    textSettingsCell.setText(LocaleController.getString("EitaaPassport", R.string.EitaaPassport), true);
                                }
                            } else {
                                textSettingsCell.setText(LocaleController.getString("ChatLock", R.string.ChatLock), true);
                            }
                        } else {
                            textSettingsCell.setText(LocaleController.getString("Passcode", R.string.Passcode), true);
                        }
                    } else {
                        textSettingsCell.setText(LocaleController.getString("WebSessionsTitle", R.string.WebSessionsTitle), false);
                    }
                } else {
                    textSettingsCell.setText(LocaleController.getString("SessionsTitle", R.string.SessionsTitle), false);
                }
            } else {
                int i3 = PrivacySettingsActivity.this.getMessagesController().totalBlockedCount;
                if (i3 == 0) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), LocaleController.getString("BlockedEmpty", R.string.BlockedEmpty), true);
                } else if (i3 > 0) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), String.format("%d", Integer.valueOf(i3)), true);
                } else {
                    textSettingsCell.setText(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), true);
                    z = true;
                }
            }
            textSettingsCell.setDrawLoading(z, i, z2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == PrivacySettingsActivity.this.passportRow || position == PrivacySettingsActivity.this.lastSeenRow || position == PrivacySettingsActivity.this.phoneNumberRow || position == PrivacySettingsActivity.this.blockedRow || position == PrivacySettingsActivity.this.deleteAccountRow || position == PrivacySettingsActivity.this.sessionsRow || position == PrivacySettingsActivity.this.webSessionsRow || position == PrivacySettingsActivity.this.passwordRow || position == PrivacySettingsActivity.this.passcodeRow || position == PrivacySettingsActivity.this.groupsRow || position == PrivacySettingsActivity.this.paymentsClearRow || position == PrivacySettingsActivity.this.secretMapRow || position == PrivacySettingsActivity.this.contactsDeleteRow || position == PrivacySettingsActivity.this.importContactRow || position == PrivacySettingsActivity.this.reloadContactRow || position == PrivacySettingsActivity.this.chatLockRow) {
                return 0;
            }
            if (position == PrivacySettingsActivity.this.deleteAccountDetailRow || position == PrivacySettingsActivity.this.groupsDetailRow || position == PrivacySettingsActivity.this.sessionsDetailRow || position == PrivacySettingsActivity.this.secretDetailRow || position == PrivacySettingsActivity.this.botsDetailRow || position == PrivacySettingsActivity.this.contactsDetailRow || position == PrivacySettingsActivity.this.newChatsSectionRow) {
                return 1;
            }
            if (position == PrivacySettingsActivity.this.securitySectionRow || position == PrivacySettingsActivity.this.advancedSectionRow || position == PrivacySettingsActivity.this.privacySectionRow || position == PrivacySettingsActivity.this.secretSectionRow || position == PrivacySettingsActivity.this.botsSectionRow || position == PrivacySettingsActivity.this.contactsSectionRow || position == PrivacySettingsActivity.this.newChatsHeaderRow) {
                return 2;
            }
            return (position == PrivacySettingsActivity.this.blockExternalAdsRow || position == PrivacySettingsActivity.this.mxbRow || position == PrivacySettingsActivity.this.secretWebpageRow || position == PrivacySettingsActivity.this.contactsSyncRow || position == PrivacySettingsActivity.this.contactsSuggestRow || position == PrivacySettingsActivity.this.newChatsRow) ? 3 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, TextCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        return arrayList;
    }
}
