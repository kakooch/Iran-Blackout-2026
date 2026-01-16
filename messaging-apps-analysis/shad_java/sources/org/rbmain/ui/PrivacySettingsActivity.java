package org.rbmain.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.SettingModels;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$PrivacyRule;
import org.rbmain.tgnet.TLRPC$TL_accountDaysTTL;
import org.rbmain.tgnet.TLRPC$TL_account_authorizationForm;
import org.rbmain.tgnet.TLRPC$TL_account_getPassword;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_account_setAccountTTL;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_globalPrivacySettings;
import org.rbmain.tgnet.TLRPC$TL_payments_clearSavedInfo;
import org.rbmain.tgnet.TLRPC$TL_privacyValueAllowAll;
import org.rbmain.tgnet.TLRPC$TL_privacyValueAllowChatParticipants;
import org.rbmain.tgnet.TLRPC$TL_privacyValueAllowUsers;
import org.rbmain.tgnet.TLRPC$TL_privacyValueDisallowAll;
import org.rbmain.tgnet.TLRPC$TL_privacyValueDisallowChatParticipants;
import org.rbmain.tgnet.TLRPC$TL_privacyValueDisallowUsers;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioColorCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class PrivacySettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int advancedSectionRow;
    private boolean archiveChats;
    private int blockedRow;
    private int callsRow;
    private TLRPC$TL_account_password currentPassword;
    private boolean currentSuggest;
    private boolean currentSync;
    private int deleteAccountDetailRow;
    private int deleteAccountRow;
    private int deleteMyAccountRow;
    private int forwardsRow;
    private int groupsDetailRow;
    private int groupsRow;
    private int lastSeenRow;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int newChatsHeaderRow;
    private int newChatsRow;
    private int newChatsSectionRow;
    private boolean newSuggest;
    private boolean newSync;
    private int passcodeRow;
    private int passwordRow;
    private int phoneNumberRow;
    private int privacySectionRow;
    private int profilePhotoRow;
    private AlertDialog progressDialog;
    private int rowCount;
    private int securitySectionRow;
    private int sessionsDetailRow;
    private int sessionsRow;
    private int botsSectionRow = -1;
    private int passportRow = -1;
    private int paymentsClearRow = -1;
    private int webSessionsRow = -1;
    private int botsDetailRow = -1;
    private int contactsSectionRow = -1;
    private int contactsDeleteRow = -1;
    private int contactsSuggestRow = -1;
    private int contactsSyncRow = -1;
    private int contactsDetailRow = -1;
    private int secretSectionRow = -1;
    private int secretMapRow = -1;
    private int secretWebpageRow = -1;
    private int secretDetailRow = -1;
    int changeNumberSectionRow = -1;
    int changeNumberRow = -1;
    int changeNumberDetailRow = -1;
    private boolean[] clear = new boolean[2];

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$13(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onFragmentDestroy$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onFragmentDestroy$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getContactsController().loadPrivacySettings();
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
        loadPasswordSettings();
        getNotificationCenter().addObserver(this, NotificationCenter.privacyRulesUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.blockedUsersDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.didSetOrRemoveTwoStepPassword);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFragmentDestroy() {
        /*
            r6 = this;
            super.onFragmentDestroy()
            org.rbmain.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = org.rbmain.messenger.NotificationCenter.privacyRulesUpdated
            r0.removeObserver(r6, r1)
            org.rbmain.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = org.rbmain.messenger.NotificationCenter.blockedUsersDidLoad
            r0.removeObserver(r6, r1)
            org.rbmain.messenger.NotificationCenter r0 = r6.getNotificationCenter()
            int r1 = org.rbmain.messenger.NotificationCenter.didSetOrRemoveTwoStepPassword
            r0.removeObserver(r6, r1)
            boolean r0 = r6.currentSync
            boolean r1 = r6.newSync
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L53
            org.rbmain.messenger.UserConfig r0 = r6.getUserConfig()
            boolean r1 = r6.newSync
            r0.syncContacts = r1
            if (r1 == 0) goto L51
            org.rbmain.messenger.ContactsController r0 = r6.getContactsController()
            r0.forceImportContacts()
            android.app.Activity r0 = r6.getParentActivity()
            if (r0 == 0) goto L51
            android.app.Activity r0 = r6.getParentActivity()
            r1 = 2131891978(0x7f12170a, float:1.9418691E38)
            java.lang.String r4 = "SyncContactsAdded"
            java.lang.String r1 = org.rbmain.messenger.LocaleController.getString(r4, r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
        L51:
            r0 = 1
            goto L54
        L53:
            r0 = 0
        L54:
            boolean r1 = r6.newSuggest
            boolean r4 = r6.currentSuggest
            if (r1 == r4) goto L7e
            if (r1 != 0) goto L63
            org.rbmain.messenger.MediaDataController r0 = r6.getMediaDataController()
            r0.clearTopPeers()
        L63:
            org.rbmain.messenger.UserConfig r0 = r6.getUserConfig()
            boolean r1 = r6.newSuggest
            r0.suggestContacts = r1
            org.rbmain.tgnet.TLRPC$TL_contacts_toggleTopPeers r0 = new org.rbmain.tgnet.TLRPC$TL_contacts_toggleTopPeers
            r0.<init>()
            boolean r1 = r6.newSuggest
            r0.enabled = r1
            org.rbmain.tgnet.ConnectionsManager r1 = r6.getConnectionsManager()
            org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17 r4 = new org.rbmain.tgnet.RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17
                static {
                    /*
                        org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17 r0 = new org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17) org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17.INSTANCE org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17.<init>():void");
                }

                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(org.rbmain.tgnet.TLObject r1, org.rbmain.tgnet.TLRPC$TL_error r2) {
                    /*
                        r0 = this;
                        org.rbmain.ui.PrivacySettingsActivity.m1972$r8$lambda$pFTCq1pD0ds5ohgm2uA7fi2zxk(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda17.run(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
                }
            }
            r1.sendRequest(r0, r4)
            r0 = 1
        L7e:
            org.rbmain.messenger.ContactsController r1 = r6.getContactsController()
            org.rbmain.tgnet.TLRPC$TL_globalPrivacySettings r1 = r1.getGlobalPrivacySettings()
            if (r1 == 0) goto Laf
            boolean r4 = r1.archive_and_mute_new_noncontact_peers
            boolean r5 = r6.archiveChats
            if (r4 == r5) goto Laf
            r1.archive_and_mute_new_noncontact_peers = r5
            org.rbmain.tgnet.TLRPC$TL_account_setGlobalPrivacySettings r0 = new org.rbmain.tgnet.TLRPC$TL_account_setGlobalPrivacySettings
            r0.<init>()
            org.rbmain.tgnet.TLRPC$TL_globalPrivacySettings r1 = new org.rbmain.tgnet.TLRPC$TL_globalPrivacySettings
            r1.<init>()
            r0.settings = r1
            int r4 = r1.flags
            r4 = r4 | r3
            r1.flags = r4
            boolean r4 = r6.archiveChats
            r1.archive_and_mute_new_noncontact_peers = r4
            org.rbmain.tgnet.ConnectionsManager r1 = r6.getConnectionsManager()
            org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15 r4 = new org.rbmain.tgnet.RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15
                static {
                    /*
                        org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15 r0 = new org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15) org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15.INSTANCE org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15.<init>():void");
                }

                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(org.rbmain.tgnet.TLObject r1, org.rbmain.tgnet.TLRPC$TL_error r2) {
                    /*
                        r0 = this;
                        org.rbmain.ui.PrivacySettingsActivity.$r8$lambda$ANEft0I5iM_Dn1ID_WW_hQKxHLI(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda15.run(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
                }
            }
            r1.sendRequest(r0, r4)
            goto Lb0
        Laf:
            r3 = r0
        Lb0:
            if (r3 == 0) goto Lb9
            org.rbmain.messenger.UserConfig r0 = r6.getUserConfig()
            r0.saveConfig(r2)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PrivacySettingsActivity.onFragmentDestroy():void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("PrivacySettings", R.string.PrivacySettings));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.PrivacySettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    PrivacySettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: org.rbmain.ui.PrivacySettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda18
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$16(view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$16(View view, int i) {
        String string;
        if (view.isEnabled()) {
            if (i == this.changeNumberRow) {
                presentFragment(new ActionIntroActivity(3));
                return;
            }
            if (i == this.deleteMyAccountRow) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString(R.string.AppName));
                builder.setMessage(LocaleController.getString(R.string.AreYouSureDeleteAccount));
                builder.setPositiveButton(LocaleController.getString(R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$createView$2(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString(R.string.Cancel), null);
                showDialog(builder.create());
                return;
            }
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
                int i2 = deleteAccountTTL <= 93 ? 0 : deleteAccountTTL <= 182 ? 1 : deleteAccountTTL <= 368 ? 2 : 3;
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                builder2.setTitle(LocaleController.getString("DeleteAccountTitle", R.string.DeleteAccountTitle));
                String[] strArr = {LocaleController.formatPluralString("Months", 3), LocaleController.formatPluralString("Months", 6), LocaleController.formatPluralString("Years", 1), LocaleController.formatPluralString("Years", 2)};
                LinearLayout linearLayout = new LinearLayout(getParentActivity());
                linearLayout.setOrientation(1);
                builder2.setView(linearLayout);
                int i3 = 0;
                while (i3 < 4) {
                    RadioColorCell radioColorCell = new RadioColorCell(getParentActivity());
                    radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                    radioColorCell.setTag(Integer.valueOf(i3));
                    radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
                    radioColorCell.setTextAndValue(strArr[i3], i2 == i3);
                    linearLayout.addView(radioColorCell);
                    radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$5(builder2, view2);
                        }
                    });
                    i3++;
                }
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder2.create());
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
                TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
                if (tLRPC$TL_account_password == null) {
                    return;
                }
                if (!TwoStepVerificationActivity.canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                    AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                }
                TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
                if (tLRPC$TL_account_password2.has_password) {
                    TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
                    twoStepVerificationActivity.setPassword(this.currentPassword);
                    presentFragment(twoStepVerificationActivity);
                    return;
                }
                presentFragment(new TwoStepVerificationSetupActivity(TextUtils.isEmpty(tLRPC$TL_account_password2.email_unconfirmed_pattern) ? 6 : 5, this.currentPassword));
                return;
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
            if (i == this.secretWebpageRow) {
                if (getMessagesController().secretWebpagePreview == 1) {
                    getMessagesController().secretWebpagePreview = 0;
                } else {
                    getMessagesController().secretWebpagePreview = 1;
                }
                MessagesController.getGlobalMainSettings().edit().putInt("secretWebpage2", getMessagesController().secretWebpagePreview).apply();
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
                builder3.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$createView$7(dialogInterface, i4);
                    }
                });
                AlertDialog alertDialogCreate = builder3.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                    return;
                }
                return;
            }
            if (i == this.contactsSuggestRow) {
                final TextCheckCell textCheckCell = (TextCheckCell) view;
                boolean z = this.newSuggest;
                if (z) {
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(getParentActivity());
                    builder4.setTitle(LocaleController.getString("SuggestContactsTitle", R.string.SuggestContactsTitle));
                    builder4.setMessage(LocaleController.getString("SuggestContactsAlert", R.string.SuggestContactsAlert));
                    builder4.setPositiveButton(LocaleController.getString("MuteDisable", R.string.MuteDisable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            this.f$0.lambda$createView$10(textCheckCell, dialogInterface, i4);
                        }
                    });
                    builder4.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate2 = builder4.create();
                    showDialog(alertDialogCreate2);
                    TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
                    if (textView2 != null) {
                        textView2.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                        return;
                    }
                    return;
                }
                boolean z2 = !z;
                this.newSuggest = z2;
                textCheckCell.setChecked(z2);
                return;
            }
            if (i == this.newChatsRow) {
                boolean z3 = !this.archiveChats;
                this.archiveChats = z3;
                ((TextCheckCell) view).setChecked(z3);
                return;
            }
            if (i == this.contactsSyncRow) {
                boolean z4 = !this.newSync;
                this.newSync = z4;
                if (view instanceof TextCheckCell) {
                    ((TextCheckCell) view).setChecked(z4);
                    return;
                }
                return;
            }
            if (i == this.secretMapRow) {
                AlertsCreator.showSecretLocationAlert(getParentActivity(), this.currentAccount, new Runnable() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createView$11();
                    }
                }, false);
                return;
            }
            if (i == this.paymentsClearRow) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(getParentActivity());
                builder5.setTitle(LocaleController.getString("PrivacyPaymentsClearAlertTitle", R.string.PrivacyPaymentsClearAlertTitle));
                builder5.setMessage(LocaleController.getString("PrivacyPaymentsClearAlertText", R.string.PrivacyPaymentsClearAlertText));
                LinearLayout linearLayout2 = new LinearLayout(getParentActivity());
                linearLayout2.setOrientation(1);
                builder5.setView(linearLayout2);
                int i4 = 0;
                while (i4 < 2) {
                    if (i4 == 0) {
                        string = LocaleController.getString("PrivacyClearShipping", R.string.PrivacyClearShipping);
                    } else {
                        string = i4 == 1 ? LocaleController.getString("PrivacyClearPayment", R.string.PrivacyClearPayment) : null;
                    }
                    this.clear[i4] = true;
                    CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1, 21);
                    checkBoxCell.setTag(Integer.valueOf(i4));
                    checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                    checkBoxCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                    linearLayout2.addView(checkBoxCell, LayoutHelper.createLinear(-1, 50));
                    checkBoxCell.setText(string, null, true, false);
                    checkBoxCell.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                    checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$12(view2);
                        }
                    });
                    i4++;
                }
                builder5.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$createView$15(dialogInterface, i5);
                    }
                });
                builder5.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder5.create());
                AlertDialog alertDialogCreate3 = builder5.create();
                showDialog(alertDialogCreate3);
                TextView textView3 = (TextView) alertDialogCreate3.getButton(-1);
                if (textView3 != null) {
                    textView3.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                    return;
                }
                return;
            }
            if (i == this.passportRow) {
                presentFragment(new PassportActivity(5, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR, (String) null, (String) null, (String) null, (TLRPC$TL_account_authorizationForm) null, (TLRPC$TL_account_password) null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DialogInterface dialogInterface, int i) {
        getMessagesController().requestDeleteAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(AlertDialog.Builder builder, View view) {
        int i;
        builder.getDismissRunnable().run();
        Integer num = (Integer) view.getTag();
        if (num.intValue() == 0) {
            i = 90;
        } else if (num.intValue() == 1) {
            i = 182;
        } else if (num.intValue() == 2) {
            i = 365;
        } else {
            i = num.intValue() == 3 ? 720 : 0;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.show();
        final TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL = new TLRPC$TL_account_setAccountTTL();
        TLRPC$TL_accountDaysTTL tLRPC$TL_accountDaysTTL = new TLRPC$TL_accountDaysTTL();
        tLRPC$TL_account_setAccountTTL.ttl = tLRPC$TL_accountDaysTTL;
        tLRPC$TL_accountDaysTTL.days = i;
        getContactProxy().setSetting(SettingModels.ParameterNameEnum.delete_account_not_active_months, Integer.valueOf(i / 30), new RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda13
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$4(alertDialog, tLRPC$TL_account_setAccountTTL, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(final AlertDialog alertDialog, final TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$3(alertDialog, tLObject, tLRPC$TL_account_setAccountTTL);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_account_setAccountTTL tLRPC$TL_account_setAccountTTL) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialogShow = new AlertDialog.Builder(getParentActivity(), 3, null).show();
        this.progressDialog = alertDialogShow;
        alertDialogShow.setCanCancel(false);
        if (this.currentSync != this.newSync) {
            UserConfig userConfig = getUserConfig();
            boolean z = this.newSync;
            userConfig.syncContacts = z;
            this.currentSync = z;
            getUserConfig().saveConfig(false);
        }
        getContactsController().deleteAllContacts(new Runnable() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6() {
        this.progressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$10(final TextCheckCell textCheckCell, DialogInterface dialogInterface, int i) {
        TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
        boolean[] zArr = this.clear;
        tLRPC$TL_payments_clearSavedInfo.credentials = zArr[1];
        tLRPC$TL_payments_clearSavedInfo.info = zArr[0];
        getUserConfig().tmpPassword = null;
        getUserConfig().saveConfig(false);
        getConnectionsManager().sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda14
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$9(textCheckCell, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(final TextCheckCell textCheckCell, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$8(textCheckCell);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(TextCheckCell textCheckCell) {
        boolean z = !this.newSuggest;
        this.newSuggest = z;
        textCheckCell.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$11() {
        this.listAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(View view) {
        CheckBoxCell checkBoxCell = (CheckBoxCell) view;
        int iIntValue = ((Integer) checkBoxCell.getTag()).intValue();
        boolean[] zArr = this.clear;
        zArr[iIntValue] = !zArr[iIntValue];
        checkBoxCell.setChecked(zArr[iIntValue], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$15(DialogInterface dialogInterface, int i) {
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
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                this.f$0.lambda$createView$14(dialogInterface2, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$14(DialogInterface dialogInterface, int i) {
        String string;
        TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
        boolean[] zArr = this.clear;
        tLRPC$TL_payments_clearSavedInfo.credentials = zArr[1];
        tLRPC$TL_payments_clearSavedInfo.info = zArr[0];
        getUserConfig().tmpPassword = null;
        getUserConfig().saveConfig(false);
        getConnectionsManager().sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda16
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                PrivacySettingsActivity.lambda$createView$13(tLObject, tLRPC$TL_error);
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.privacyRulesUpdated) {
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
        if (i == NotificationCenter.blockedUsersDidLoad) {
            this.listAdapter.notifyItemChanged(this.blockedRow);
            return;
        }
        if (i == NotificationCenter.didSetOrRemoveTwoStepPassword) {
            if (objArr.length > 0) {
                this.currentPassword = (TLRPC$TL_account_password) objArr[0];
                ListAdapter listAdapter2 = this.listAdapter;
                if (listAdapter2 != null) {
                    listAdapter2.notifyItemChanged(this.passwordRow);
                    return;
                }
                return;
            }
            loadPasswordSettings();
        }
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.privacySectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.blockedRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.phoneNumberRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.lastSeenRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.profilePhotoRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.forwardsRow = i5;
        int i7 = i6 + 1;
        this.rowCount = i7;
        this.callsRow = i6;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.groupsRow = i7;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.groupsDetailRow = i8;
        int i10 = i9 + 1;
        this.rowCount = i10;
        this.securitySectionRow = i9;
        int i11 = i10 + 1;
        this.rowCount = i11;
        this.passcodeRow = i10;
        int i12 = i11 + 1;
        this.rowCount = i12;
        this.passwordRow = i11;
        int i13 = i12 + 1;
        this.rowCount = i13;
        this.sessionsRow = i12;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.sessionsDetailRow = i13;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.changeNumberSectionRow = i14;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.changeNumberRow = i15;
        this.rowCount = i16 + 1;
        this.changeNumberDetailRow = i16;
        if (getMessagesController().autoarchiveAvailable) {
            int i17 = this.rowCount;
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.newChatsHeaderRow = i17;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.newChatsRow = i18;
            this.rowCount = i19 + 1;
            this.newChatsSectionRow = i19;
        } else {
            this.newChatsHeaderRow = -1;
            this.newChatsRow = -1;
            this.newChatsSectionRow = -1;
        }
        int i20 = this.rowCount;
        int i21 = i20 + 1;
        this.rowCount = i21;
        this.advancedSectionRow = i20;
        int i22 = i21 + 1;
        this.rowCount = i22;
        this.deleteMyAccountRow = i21;
        int i23 = i22 + 1;
        this.rowCount = i23;
        this.deleteAccountRow = i22;
        int i24 = i23 + 1;
        this.rowCount = i24;
        this.deleteAccountDetailRow = i23;
        int i25 = i24 + 1;
        this.rowCount = i25;
        this.contactsSectionRow = i24;
        this.rowCount = i25 + 1;
        this.contactsDeleteRow = i25;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private void loadPasswordSettings() {
        getContactProxy().getPasswordSettings(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda12
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordSettings$18(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordSettings$18(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PrivacySettingsActivity$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadPasswordSettings$17(tLRPC$TL_account_password);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordSettings$17(TLRPC$TL_account_password tLRPC$TL_account_password) {
        this.currentPassword = tLRPC$TL_account_password;
        TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
        if (!getUserConfig().hasSecureData && tLRPC$TL_account_password.has_secure_values) {
            getUserConfig().hasSecureData = true;
            getUserConfig().saveConfig(false);
            updateRows();
        } else {
            this.listView.stopScroll();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyItemChanged(this.passwordRow);
            }
        }
    }

    public static String formatRulesString(AccountInstance accountInstance, int i) {
        ArrayList<TLRPC$PrivacyRule> privacyRules = accountInstance.getContactsController().getPrivacyRules(i);
        if (privacyRules == null || privacyRules.size() == 0) {
            if (i == 3) {
                return LocaleController.getString("P2PNobody", R.string.P2PNobody);
            }
            return LocaleController.getString("LastSeenNobody", R.string.LastSeenNobody);
        }
        char c = 65535;
        int size = 0;
        int size2 = 0;
        for (int i2 = 0; i2 < privacyRules.size(); i2++) {
            TLRPC$PrivacyRule tLRPC$PrivacyRule = privacyRules.get(i2);
            if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueAllowChatParticipants) {
                TLRPC$TL_privacyValueAllowChatParticipants tLRPC$TL_privacyValueAllowChatParticipants = (TLRPC$TL_privacyValueAllowChatParticipants) tLRPC$PrivacyRule;
                int size3 = tLRPC$TL_privacyValueAllowChatParticipants.chats.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    TLRPC$Chat chat = accountInstance.getMessagesController().getChat(tLRPC$TL_privacyValueAllowChatParticipants.chats.get(i3));
                    if (chat != null) {
                        size2 += chat.participants_count;
                    }
                }
            } else if (tLRPC$PrivacyRule instanceof TLRPC$TL_privacyValueDisallowChatParticipants) {
                TLRPC$TL_privacyValueDisallowChatParticipants tLRPC$TL_privacyValueDisallowChatParticipants = (TLRPC$TL_privacyValueDisallowChatParticipants) tLRPC$PrivacyRule;
                int size4 = tLRPC$TL_privacyValueDisallowChatParticipants.chats.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    TLRPC$Chat chat2 = accountInstance.getMessagesController().getChat(tLRPC$TL_privacyValueDisallowChatParticipants.chats.get(i4));
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
            return i == 3 ? size == 0 ? LocaleController.getString("P2PEverybody", R.string.P2PEverybody) : LocaleController.formatString("P2PEverybodyMinus", R.string.P2PEverybodyMinus, Integer.valueOf(size)) : size == 0 ? LocaleController.getString("LastSeenEverybody", R.string.LastSeenEverybody) : LocaleController.formatString("LastSeenEverybodyMinus", R.string.LastSeenEverybodyMinus, Integer.valueOf(size));
        }
        if (c != 2 && (c != 65535 || size <= 0 || size2 <= 0)) {
            return (c == 1 || size2 > 0) ? i == 3 ? size2 == 0 ? LocaleController.getString("P2PNobody", R.string.P2PNobody) : LocaleController.formatString("P2PNobodyPlus", R.string.P2PNobodyPlus, Integer.valueOf(size2)) : size2 == 0 ? LocaleController.getString("LastSeenNobody", R.string.LastSeenNobody) : LocaleController.formatString("LastSeenNobodyPlus", R.string.LastSeenNobodyPlus, Integer.valueOf(size2)) : "unknown";
        }
        if (i == 3) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == PrivacySettingsActivity.this.passcodeRow || adapterPosition == PrivacySettingsActivity.this.passwordRow || adapterPosition == PrivacySettingsActivity.this.blockedRow || adapterPosition == PrivacySettingsActivity.this.sessionsRow || adapterPosition == PrivacySettingsActivity.this.secretWebpageRow || adapterPosition == PrivacySettingsActivity.this.webSessionsRow || (adapterPosition == PrivacySettingsActivity.this.groupsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(1)) || ((adapterPosition == PrivacySettingsActivity.this.lastSeenRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(0)) || ((adapterPosition == PrivacySettingsActivity.this.callsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(2)) || ((adapterPosition == PrivacySettingsActivity.this.profilePhotoRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(4)) || ((adapterPosition == PrivacySettingsActivity.this.forwardsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(5)) || ((adapterPosition == PrivacySettingsActivity.this.phoneNumberRow && !PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(6)) || ((adapterPosition == PrivacySettingsActivity.this.deleteAccountRow && !PrivacySettingsActivity.this.getContactsController().getLoadingDeleteInfo()) || ((adapterPosition == PrivacySettingsActivity.this.newChatsRow && !PrivacySettingsActivity.this.getContactsController().getLoadingGlobalSettings()) || adapterPosition == PrivacySettingsActivity.this.paymentsClearRow || adapterPosition == PrivacySettingsActivity.this.secretMapRow || adapterPosition == PrivacySettingsActivity.this.contactsSyncRow || adapterPosition == PrivacySettingsActivity.this.passportRow || adapterPosition == PrivacySettingsActivity.this.contactsDeleteRow || adapterPosition == PrivacySettingsActivity.this.contactsSuggestRow || adapterPosition == PrivacySettingsActivity.this.deleteMyAccountRow || adapterPosition == PrivacySettingsActivity.this.changeNumberRow)))))));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PrivacySettingsActivity.this.rowCount;
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
                textSettingsCell = new TextCheckCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String pluralString;
            String rulesString;
            String rulesString2;
            String rulesString3;
            String rulesString4;
            String rulesString5;
            String rulesString6;
            String string2;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (i != PrivacySettingsActivity.this.deleteAccountDetailRow) {
                        if (i != PrivacySettingsActivity.this.groupsDetailRow) {
                            if (i != PrivacySettingsActivity.this.sessionsDetailRow) {
                                if (i != PrivacySettingsActivity.this.secretDetailRow) {
                                    if (i != PrivacySettingsActivity.this.botsDetailRow) {
                                        if (i != PrivacySettingsActivity.this.contactsDetailRow) {
                                            if (i == PrivacySettingsActivity.this.newChatsSectionRow) {
                                                textInfoPrivacyCell.setText(LocaleController.getString("ArchiveAndMuteInfo", R.string.ArchiveAndMuteInfo));
                                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                                return;
                                            } else {
                                                if (i == PrivacySettingsActivity.this.changeNumberDetailRow) {
                                                    textInfoPrivacyCell.setText(LocaleController.getString("ChangePhoneNumberInfo", R.string.ChangePhoneNumberInfo));
                                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        textInfoPrivacyCell.setText(LocaleController.getString("SuggestContactsInfo", R.string.SuggestContactsInfo));
                                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                        return;
                                    }
                                    textInfoPrivacyCell.setText(LocaleController.getString("PrivacyBotsInfo", R.string.PrivacyBotsInfo));
                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                    return;
                                }
                                textInfoPrivacyCell.setText(LocaleController.getString("SecretWebPageInfo", R.string.SecretWebPageInfo));
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                return;
                            }
                            textInfoPrivacyCell.setText(LocaleController.getString("SessionsInfo", R.string.SessionsInfo));
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                            return;
                        }
                        textInfoPrivacyCell.setText(LocaleController.getString("GroupsAndChannelsHelp", R.string.GroupsAndChannelsHelp));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        return;
                    }
                    textInfoPrivacyCell.setText(LocaleController.getString("DeleteAccountHelp", R.string.DeleteAccountHelp));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        return;
                    }
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    if (i != PrivacySettingsActivity.this.secretWebpageRow) {
                        if (i == PrivacySettingsActivity.this.contactsSyncRow) {
                            textCheckCell.setTextAndCheck(LocaleController.getString("SyncContacts", R.string.SyncContacts), PrivacySettingsActivity.this.newSync, true);
                            return;
                        } else if (i == PrivacySettingsActivity.this.contactsSuggestRow) {
                            textCheckCell.setTextAndCheck(LocaleController.getString("SuggestContacts", R.string.SuggestContacts), PrivacySettingsActivity.this.newSuggest, false);
                            return;
                        } else {
                            if (i == PrivacySettingsActivity.this.newChatsRow) {
                                textCheckCell.setTextAndCheck(LocaleController.getString("ArchiveAndMute", R.string.ArchiveAndMute), PrivacySettingsActivity.this.archiveChats, false);
                                return;
                            }
                            return;
                        }
                    }
                    textCheckCell.setTextAndCheck(LocaleController.getString("SecretWebPage", R.string.SecretWebPage), PrivacySettingsActivity.this.getMessagesController().secretWebpagePreview == 1, false);
                    return;
                }
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != PrivacySettingsActivity.this.privacySectionRow) {
                    if (i != PrivacySettingsActivity.this.securitySectionRow) {
                        if (i != PrivacySettingsActivity.this.advancedSectionRow) {
                            if (i != PrivacySettingsActivity.this.secretSectionRow) {
                                if (i != PrivacySettingsActivity.this.botsSectionRow) {
                                    if (i != PrivacySettingsActivity.this.contactsSectionRow) {
                                        if (i == PrivacySettingsActivity.this.newChatsHeaderRow) {
                                            headerCell.setText(LocaleController.getString("NewChatsFromNonContacts", R.string.NewChatsFromNonContacts));
                                            return;
                                        } else {
                                            if (i == PrivacySettingsActivity.this.changeNumberSectionRow) {
                                                headerCell.setText(LocaleController.getString("PhoneNumberSearch", R.string.PhoneNumberSearch));
                                                return;
                                            }
                                            return;
                                        }
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
            TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
            if (i == PrivacySettingsActivity.this.blockedRow) {
                int i2 = PrivacySettingsActivity.this.getMessagesController().totalBlockedCount;
                if (i2 == 0) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), LocaleController.getString("BlockedEmpty", R.string.BlockedEmpty), true);
                    return;
                } else if (i2 > 0) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), String.format("%d", Integer.valueOf(i2)), true);
                    return;
                } else {
                    textSettingsCell.setText(LocaleController.getString("BlockedUsers", R.string.BlockedUsers), true);
                    return;
                }
            }
            PrivacySettingsActivity privacySettingsActivity = PrivacySettingsActivity.this;
            if (i != privacySettingsActivity.changeNumberRow) {
                if (i != privacySettingsActivity.sessionsRow) {
                    if (i != PrivacySettingsActivity.this.webSessionsRow) {
                        if (i == PrivacySettingsActivity.this.passwordRow) {
                            if (PrivacySettingsActivity.this.currentPassword != null) {
                                if (PrivacySettingsActivity.this.currentPassword.has_password) {
                                    string2 = LocaleController.getString("PasswordOn", R.string.PasswordOn);
                                } else {
                                    string2 = LocaleController.getString("PasswordOff", R.string.PasswordOff);
                                }
                            } else {
                                string2 = LocaleController.getString("Loading", R.string.Loading);
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("TwoStepVerification", R.string.TwoStepVerification), string2, true);
                            return;
                        }
                        if (i != PrivacySettingsActivity.this.passcodeRow) {
                            if (i == PrivacySettingsActivity.this.phoneNumberRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(6)) {
                                    rulesString6 = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString6 = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 6);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyPhone", R.string.PrivacyPhone), rulesString6, true);
                                return;
                            }
                            if (i == PrivacySettingsActivity.this.lastSeenRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(0)) {
                                    rulesString5 = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString5 = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 0);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyLastSeen", R.string.PrivacyLastSeen), rulesString5, true);
                                return;
                            }
                            if (i == PrivacySettingsActivity.this.groupsRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(1)) {
                                    rulesString4 = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString4 = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 1);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("GroupsAndChannels", R.string.GroupsAndChannels), rulesString4, false);
                                return;
                            }
                            if (i == PrivacySettingsActivity.this.callsRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(2)) {
                                    rulesString3 = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString3 = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 2);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("Calls", R.string.Calls), rulesString3, true);
                                return;
                            }
                            if (i == PrivacySettingsActivity.this.profilePhotoRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(4)) {
                                    rulesString2 = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString2 = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 4);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyProfilePhoto", R.string.PrivacyProfilePhoto), rulesString2, true);
                                return;
                            }
                            if (i == PrivacySettingsActivity.this.forwardsRow) {
                                if (PrivacySettingsActivity.this.getContactsController().getLoadingPrivicyInfo(5)) {
                                    rulesString = LocaleController.getString("Loading", R.string.Loading);
                                } else {
                                    rulesString = PrivacySettingsActivity.formatRulesString(PrivacySettingsActivity.this.getAccountInstance(), 5);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("PrivacyForwards", R.string.PrivacyForwards), rulesString, true);
                                return;
                            }
                            if (i != PrivacySettingsActivity.this.passportRow) {
                                if (i == PrivacySettingsActivity.this.deleteAccountRow) {
                                    if (!PrivacySettingsActivity.this.getContactsController().getLoadingDeleteInfo()) {
                                        int deleteAccountTTL = PrivacySettingsActivity.this.getContactsController().getDeleteAccountTTL();
                                        if (deleteAccountTTL <= 182) {
                                            pluralString = LocaleController.formatPluralString("Months", deleteAccountTTL / 30);
                                        } else if (deleteAccountTTL == 365 || deleteAccountTTL == 720) {
                                            pluralString = LocaleController.formatPluralString("Years", deleteAccountTTL == 365 ? 1 : 2);
                                        } else {
                                            pluralString = LocaleController.formatPluralString("Days", deleteAccountTTL);
                                        }
                                    } else {
                                        pluralString = LocaleController.getString("Loading", R.string.Loading);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("DeleteAccountIfAwayFor3", R.string.DeleteAccountIfAwayFor3), pluralString, false);
                                    return;
                                }
                                if (i != PrivacySettingsActivity.this.paymentsClearRow) {
                                    if (i != PrivacySettingsActivity.this.secretMapRow) {
                                        if (i != PrivacySettingsActivity.this.contactsDeleteRow) {
                                            if (i == PrivacySettingsActivity.this.deleteMyAccountRow) {
                                                textSettingsCell.setTextAndValue(LocaleController.getString("DeleteMyAccount", R.string.DeleteMyAccount), BuildConfig.FLAVOR, true);
                                                return;
                                            }
                                            return;
                                        }
                                        textSettingsCell.setText(LocaleController.getString("SyncContactsDelete", R.string.SyncContactsDelete), true);
                                        return;
                                    }
                                    int i3 = SharedConfig.mapPreviewType;
                                    if (i3 == 0) {
                                        string = LocaleController.getString("MapPreviewProviderRubika", R.string.MapPreviewProviderRubika);
                                    } else if (i3 == 1) {
                                        string = LocaleController.getString("MapPreviewProviderGoogle", R.string.MapPreviewProviderGoogle);
                                    } else if (i3 == 2) {
                                        string = LocaleController.getString("MapPreviewProviderNobody", R.string.MapPreviewProviderNobody);
                                    } else {
                                        string = LocaleController.getString("MapPreviewProviderYandex", R.string.MapPreviewProviderYandex);
                                    }
                                    textSettingsCell.setTextAndValue(LocaleController.getString("MapPreviewProvider", R.string.MapPreviewProvider), string, true);
                                    return;
                                }
                                textSettingsCell.setText(LocaleController.getString("PrivacyPaymentsClear", R.string.PrivacyPaymentsClear), true);
                                return;
                            }
                            textSettingsCell.setText(LocaleController.getString("RubikaPassport", R.string.RubikaPassport), true);
                            return;
                        }
                        textSettingsCell.setText(LocaleController.getString("Passcode", R.string.Passcode), true);
                        return;
                    }
                    textSettingsCell.setText(LocaleController.getString("WebSessionsTitle", R.string.WebSessionsTitle), false);
                    return;
                }
                textSettingsCell.setText(LocaleController.getString("SessionsTitle", R.string.SessionsTitle), false);
                return;
            }
            textSettingsCell.setTextAndValue(LocaleController.getString("ChangePhoneNumber", R.string.ChangePhoneNumber), BuildConfig.FLAVOR, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i != PrivacySettingsActivity.this.deleteMyAccountRow && i != PrivacySettingsActivity.this.passportRow && i != PrivacySettingsActivity.this.lastSeenRow && i != PrivacySettingsActivity.this.phoneNumberRow && i != PrivacySettingsActivity.this.blockedRow && i != PrivacySettingsActivity.this.deleteAccountRow && i != PrivacySettingsActivity.this.sessionsRow && i != PrivacySettingsActivity.this.webSessionsRow) {
                PrivacySettingsActivity privacySettingsActivity = PrivacySettingsActivity.this;
                if (i != privacySettingsActivity.changeNumberRow && i != privacySettingsActivity.passwordRow && i != PrivacySettingsActivity.this.passcodeRow && i != PrivacySettingsActivity.this.groupsRow && i != PrivacySettingsActivity.this.paymentsClearRow && i != PrivacySettingsActivity.this.secretMapRow && i != PrivacySettingsActivity.this.contactsDeleteRow) {
                    if (i == PrivacySettingsActivity.this.deleteAccountDetailRow || i == PrivacySettingsActivity.this.groupsDetailRow || i == PrivacySettingsActivity.this.sessionsDetailRow || i == PrivacySettingsActivity.this.secretDetailRow || i == PrivacySettingsActivity.this.botsDetailRow || i == PrivacySettingsActivity.this.contactsDetailRow || i == PrivacySettingsActivity.this.newChatsSectionRow) {
                        return 1;
                    }
                    PrivacySettingsActivity privacySettingsActivity2 = PrivacySettingsActivity.this;
                    if (i == privacySettingsActivity2.changeNumberDetailRow) {
                        return 1;
                    }
                    if (i == privacySettingsActivity2.securitySectionRow || i == PrivacySettingsActivity.this.advancedSectionRow || i == PrivacySettingsActivity.this.privacySectionRow || i == PrivacySettingsActivity.this.secretSectionRow || i == PrivacySettingsActivity.this.botsSectionRow || i == PrivacySettingsActivity.this.contactsSectionRow || i == PrivacySettingsActivity.this.newChatsHeaderRow) {
                        return 2;
                    }
                    PrivacySettingsActivity privacySettingsActivity3 = PrivacySettingsActivity.this;
                    if (i == privacySettingsActivity3.changeNumberSectionRow) {
                        return 2;
                    }
                    return (i == privacySettingsActivity3.secretWebpageRow || i == PrivacySettingsActivity.this.contactsSyncRow || i == PrivacySettingsActivity.this.contactsSuggestRow || i == PrivacySettingsActivity.this.newChatsRow) ? 3 : 0;
                }
            }
            return 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, HeaderCell.class, TextCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        return arrayList;
    }
}
