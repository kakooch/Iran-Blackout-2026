package androidMessenger.proxy;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidMessenger.ServiceLocator;
import androidMessenger.model.GetSettingsOutput2;
import androidMessenger.model.SettingPartPerLanguageObject;
import androidMessenger.network.ApiRequestRx;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.ContactConverter;
import androidMessenger.utilites.MyLog;
import com.facebook.stetho.common.Utf8Charset;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.LogInException;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ColorObject;
import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.SettingItem2;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.SettingPartObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordOutput;
import ir.aaap.messengercore.model.api.GetMySessionsOutput;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepOutput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordOutput;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.TwoPasscodeStatusOutput;
import ir.aaap.messengercore.model.api.TwoStepStatusObject;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailOutput;
import ir.aaap.messengercore.utilites.Objects;
import ir.resaneh1.iptv.helper.FlavorHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$InputPrivacyKey;
import org.rbmain.tgnet.TLRPC$InputPrivacyRule;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$PrivacyRule;
import org.rbmain.tgnet.TLRPC$TL_accountDaysTTL;
import org.rbmain.tgnet.TLRPC$TL_account_authorizations;
import org.rbmain.tgnet.TLRPC$TL_account_cancelPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_changePhone;
import org.rbmain.tgnet.TLRPC$TL_account_confirmPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_getAccountTTL;
import org.rbmain.tgnet.TLRPC$TL_account_getAuthorizations;
import org.rbmain.tgnet.TLRPC$TL_account_getPassword;
import org.rbmain.tgnet.TLRPC$TL_account_getPasswordSettings;
import org.rbmain.tgnet.TLRPC$TL_account_getPrivacy;
import org.rbmain.tgnet.TLRPC$TL_account_getWallPapers;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_account_passwordInputSettings;
import org.rbmain.tgnet.TLRPC$TL_account_privacyRules;
import org.rbmain.tgnet.TLRPC$TL_account_resendPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_resetAuthorization;
import org.rbmain.tgnet.TLRPC$TL_account_resetWallPapers;
import org.rbmain.tgnet.TLRPC$TL_account_sendChangePhoneCode;
import org.rbmain.tgnet.TLRPC$TL_account_setPrivacy;
import org.rbmain.tgnet.TLRPC$TL_account_updatePasswordSettings;
import org.rbmain.tgnet.TLRPC$TL_account_uploadWallPaper;
import org.rbmain.tgnet.TLRPC$TL_auth_authorization;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_auth_passwordRecovery;
import org.rbmain.tgnet.TLRPC$TL_auth_recoverPassword;
import org.rbmain.tgnet.TLRPC$TL_auth_requestPasswordRecovery;
import org.rbmain.tgnet.TLRPC$TL_auth_resetAuthorizations;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_contacts_addContact;
import org.rbmain.tgnet.TLRPC$TL_contacts_deleteContacts;
import org.rbmain.tgnet.TLRPC$TL_contacts_importContacts;
import org.rbmain.tgnet.TLRPC$TL_contacts_importedContacts;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputPhoneContact;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyChatInvite;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyForwards;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneNumber;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyStatusTimestamp;
import org.rbmain.tgnet.TLRPC$TL_messages_getAvailableReactions;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$Tl_settings_parts;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.WallpapersListActivity;

/* loaded from: classes.dex */
public class ContactsProxy extends BaseController {
    private static volatile ContactsProxy[] Instance = new ContactsProxy[3];

    public ContactsProxy(int i) {
        super(i);
        this.currentAccount = i;
    }

    public static ContactsProxy getInstance(int i) {
        ContactsProxy contactsProxy = Instance[i];
        if (contactsProxy == null) {
            synchronized (MessageProxy.class) {
                contactsProxy = Instance[i];
                if (contactsProxy == null) {
                    ContactsProxy[] contactsProxyArr = Instance;
                    ContactsProxy contactsProxy2 = new ContactsProxy(i);
                    contactsProxyArr[i] = contactsProxy2;
                    contactsProxy = contactsProxy2;
                }
            }
        }
        return contactsProxy;
    }

    public void loadContactsIfNeeded() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadContactsIfNeeded$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadContactsIfNeeded$0() {
        if (ServiceLocator.isAccountLoggedIn(this.currentAccount)) {
            getAccountInstance().getCoreMainClass().getContactAndImportPhoneBookIfNeeded(false, false);
        }
    }

    public void updateContactsLastOnline() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateContactsLastOnline$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateContactsLastOnline$1() {
        if (ServiceLocator.isAccountLoggedIn(this.currentAccount)) {
            getAccountInstance().getCoreMainClass().getContactAndImportPhoneBookIfNeeded(false, true);
        }
    }

    public void proxyContactsResult(final ArrayList<String> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyContactsResult$4(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyContactsResult$4(ArrayList arrayList) {
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        CoreMainClass coreMainClass = getAccountInstance().getCoreMainClass();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ChatAbsObject absInstant = coreMainClass.getAbsInstant(str);
            if (absInstant != null) {
                arrayList2.add(ChatConverter.convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(str), absInstant, (UserInfo) null, (Chat) null));
            }
        }
        getContactsController().processLoadedContacts(ContactConverter.convertToContacts(arrayList), arrayList2, 0);
        final HashMap<String, ContactsController.Contact> contactsFromPhoneBook = getContactsController().readContactsFromPhoneBook();
        HashMap<String, ArrayList<Object>> map = new HashMap<>();
        final HashMap<String, ContactsController.Contact> map2 = new HashMap<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        Iterator<Map.Entry<String, ContactsController.Contact>> it2 = contactsFromPhoneBook.entrySet().iterator();
        while (it2.hasNext()) {
            ContactsController.Contact value = it2.next().getValue();
            int size = value.shortPhones.size();
            for (int i = 0; i < size; i++) {
                map2.put(value.shortPhones.get(i).substring(Math.max(0, r8.length() - 7)), value);
            }
            String letter = value.getLetter();
            ArrayList<Object> arrayList4 = map.get(letter);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList<>();
                map.put(letter, arrayList4);
                arrayList3.add(letter);
            }
            arrayList4.add(value);
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyContactsResult$3(contactsFromPhoneBook, map2);
            }
        });
        getContactsController().lambda$performSyncPhoneBook$21(map, arrayList3, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyContactsResult$3(HashMap map, HashMap map2) {
        getContactsController().contactsBook = map;
        getContactsController().contactsBookSPhones = map2;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyContactsResult$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyContactsResult$2() {
        getContactsController().updateUnregisteredContacts();
    }

    public void setWallpaper(Object obj) {
        Map<SettingModels.ParameterNameEnum, Object> map = new HashMap<>();
        if (obj instanceof TLRPC$TL_wallPaper) {
            SettingModels.ThemeBackgroundInput themeBackgroundInput = new SettingModels.ThemeBackgroundInput();
            themeBackgroundInput.theme_id = Theme.getCurrentTheme().themeId;
            themeBackgroundInput.type = Theme.getCurrentTheme().themeType;
            themeBackgroundInput.chat_background_wallpaper = new SettingModels.WallpaperIdObject(IdStorage.getInstance().getWallpaperId(((TLRPC$TL_wallPaper) obj).id));
            themeBackgroundInput.chat_background_type = SettingModels.BackGroundTypeEnum.Wallpaper;
            map.put(SettingModels.ParameterNameEnum.theme_background, themeBackgroundInput);
        } else if (obj instanceof WallpapersListActivity.ColorWallpaper) {
            SettingModels.ThemeBackgroundInput themeBackgroundInput2 = new SettingModels.ThemeBackgroundInput();
            themeBackgroundInput2.theme_id = Theme.getCurrentTheme().themeId;
            themeBackgroundInput2.type = Theme.getCurrentTheme().themeType;
            themeBackgroundInput2.chat_background_color = ColorObject.getColorObject(((WallpapersListActivity.ColorWallpaper) obj).color);
            themeBackgroundInput2.chat_background_type = SettingModels.BackGroundTypeEnum.Color;
            map.put(SettingModels.ParameterNameEnum.theme_background, themeBackgroundInput2);
        }
        if (map.size() > 0) {
            setDeviceSettings(map, null);
        }
    }

    public void setDeviceSettings(final Map<SettingModels.ParameterNameEnum, Object> map, final LoadListener<Integer> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                ContactsProxy.lambda$setDeviceSettings$5(map, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDeviceSettings$5(Map map, LoadListener loadListener) {
        for (int i = 0; i < 3; i++) {
            if (ServiceLocator.isAccountLoggedIn(i)) {
                CoreMainClass coreMainClass = ServiceLocator.getInstance(i).getCoreMainClass();
                if (coreMainClass.isCoreInitiated()) {
                    coreMainClass.setSettings(FlavorHelper.isRubino(), map, loadListener);
                }
            }
        }
    }

    /* renamed from: androidMessenger.proxy.ContactsProxy$1, reason: invalid class name */
    class AnonymousClass1 implements LoadListener<PrivacySettings> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass1(ContactsProxy contactsProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(PrivacySettings privacySettings) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, null);
                }
            });
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsProxy.AnonymousClass1.lambda$onError$1(requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(RequestDelegate requestDelegate) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Get Privacy Settings";
            requestDelegate.run(null, tLRPC$TL_error);
        }
    }

    public void loadPrivacySetting(final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySetting$6(requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySetting$6(RequestDelegate requestDelegate) {
        getCoreMainClass().getPrivacySettingFromServer(new AnonymousClass1(this, requestDelegate));
    }

    public void addWallpaper(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addWallpaper$7(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addWallpaper$7(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_uploadWallPaper) {
            TLRPC$TL_account_uploadWallPaper tLRPC$TL_account_uploadWallPaper = (TLRPC$TL_account_uploadWallPaper) tLObject;
            TLRPC$InputFile tLRPC$InputFile = tLRPC$TL_account_uploadWallPaper.file;
            long j = tLRPC$InputFile.id;
            String str = tLRPC$InputFile.access_hash_rec;
            TLRPC$InputFile tLRPC$InputFile2 = tLRPC$TL_account_uploadWallPaper.thumb;
            getCoreMainClass().addWallpaperSetThemeBackground(j, str, tLRPC$InputFile2 != null ? tLRPC$InputFile2.id : 0L, tLRPC$InputFile2 != null ? tLRPC$InputFile2.access_hash_rec : null, Theme.getCurrentTheme().themeId, new LoadListener<SettingModels.AddWallpaperSetThemeBackgroundOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.2
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(SettingModels.AddWallpaperSetThemeBackgroundOutput addWallpaperSetThemeBackgroundOutput) {
                    requestDelegate.run(ContactConverter.convertWallpaperToTlObject(addWallpaperSetThemeBackgroundOutput.wallpaper), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
    }

    public void getWallpapers(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_getWallPapers) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getWallpapers$8(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getWallpapers$8(final RequestDelegate requestDelegate) {
        getCoreMainClass().getWallpapers(new LoadListener<SettingModels.WallpapersOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.3
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SettingModels.WallpapersOutput wallpapersOutput) {
                requestDelegate.run(ContactConverter.convertWallpapers(wallpapersOutput), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Wallpapers";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void resetWallpapers(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_resetWallPapers) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resetWallpapers$9(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetWallpapers$9(final RequestDelegate requestDelegate) {
        getCoreMainClass().resetWallpapers(new LoadListener<SettingModels.WallpapersOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SettingModels.WallpapersOutput wallpapersOutput) {
                requestDelegate.run(ContactConverter.convertWallpapers(wallpapersOutput), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Wallpapers";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void getPrivacyRule(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_getPrivacy) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getPrivacyRule$10(requestDelegate, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPrivacyRule$10(RequestDelegate requestDelegate, TLObject tLObject) {
        PrivacySettings privacySettingInstant = getCoreMainClass().getPrivacySettingInstant();
        if (privacySettingInstant == null) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Get Privacy Rule";
            requestDelegate.run(null, tLRPC$TL_error);
            return;
        }
        TLRPC$TL_account_privacyRules tLRPC$TL_account_privacyRules = new TLRPC$TL_account_privacyRules();
        tLRPC$TL_account_privacyRules.rules = ContactConverter.convertPrivacyRule(((TLRPC$TL_account_getPrivacy) tLObject).key, privacySettingInstant);
        getMessagesController().totalBlockedCount = privacySettingInstant.count_blocked_user;
        ArrayList<TLRPC$PrivacyRule> arrayList = tLRPC$TL_account_privacyRules.rules;
        if (arrayList != null && !arrayList.isEmpty()) {
            requestDelegate.run(tLRPC$TL_account_privacyRules, null);
            return;
        }
        TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
        tLRPC$TL_error2.text = "Failed To Get Privacy Rule";
        requestDelegate.run(null, tLRPC$TL_error2);
    }

    public void getDeleteInfo(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_getAccountTTL) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDeleteInfo$11(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDeleteInfo$11(RequestDelegate requestDelegate) {
        PrivacySettings privacySettingInstant = getCoreMainClass().getPrivacySettingInstant();
        if (privacySettingInstant != null) {
            TLRPC$TL_accountDaysTTL tLRPC$TL_accountDaysTTL = new TLRPC$TL_accountDaysTTL();
            tLRPC$TL_accountDaysTTL.days = privacySettingInstant.delete_account_not_active_months;
            requestDelegate.run(tLRPC$TL_accountDaysTTL, null);
        } else {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Get Privacy Rule";
            requestDelegate.run(null, tLRPC$TL_error);
        }
    }

    public void getPasswordSettings(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_getPassword) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getPasswordSettings$12(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPasswordSettings$12(final RequestDelegate requestDelegate) {
        getCoreMainClass().getTwoPasscodeStatus(new LoadListener<TwoPasscodeStatusOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.5
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                TLRPC$TL_account_password tLRPC$TL_account_passwordConvertTwoStepStatus = twoPasscodeStatusOutput != null ? ContactConverter.convertTwoStepStatus(twoPasscodeStatusOutput.two_step_status, twoPasscodeStatusOutput.no_recovery_alert) : null;
                if (tLRPC$TL_account_passwordConvertTwoStepStatus != null) {
                    requestDelegate.run(tLRPC$TL_account_passwordConvertTwoStepStatus, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Two Step Password Status";
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Two Step Password Status";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void setTwoStepPassword(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_updatePasswordSettings) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setTwoStepPassword$13(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTwoStepPassword$13(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = (TLRPC$TL_account_updatePasswordSettings) tLObject;
        if (tLRPC$TL_account_updatePasswordSettings.clear) {
            try {
                getCoreMainClass().turnOffTwoStepPassword(new String(tLRPC$TL_account_updatePasswordSettings.oldPass, Utf8Charset.NAME), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.6
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "Failed To Deactive Password";
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                });
                return;
            } catch (UnsupportedEncodingException e) {
                MyLog.handleExceptionThrowOnDebug(e);
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Password";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
        }
        if (tLRPC$TL_account_updatePasswordSettings.abort) {
            getCoreMainClass().abortTwoStepSetup(new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.7
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                    tLRPC$TL_error2.text = "Failed To Abort Setup";
                    requestDelegate.run(null, tLRPC$TL_error2);
                }
            });
            return;
        }
        TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = tLRPC$TL_account_updatePasswordSettings.new_settings;
        String str = tLRPC$TL_account_passwordInputSettings.email;
        String str2 = tLRPC$TL_account_passwordInputSettings.hint;
        String str3 = tLRPC$TL_account_updatePasswordSettings.newPass;
        byte[] bArr = tLRPC$TL_account_updatePasswordSettings.oldPass;
        LoadListener<TwoStepStatusObject> loadListener = new LoadListener<TwoStepStatusObject>(this) { // from class: androidMessenger.proxy.ContactsProxy.8
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(TwoStepStatusObject twoStepStatusObject) {
                if (twoStepStatusObject != null && twoStepStatusObject.has_pending_recovery_email) {
                    TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                    tLRPC$TL_error2.text = "EMAIL_UNCONFIRMED";
                    requestDelegate.run(null, tLRPC$TL_error2);
                    return;
                }
                requestDelegate.run(new TLRPC$TL_boolTrue(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                tLRPC$TL_error2.text = "Failed To Update Password";
                requestDelegate.run(null, tLRPC$TL_error2);
            }
        };
        if (bArr == null) {
            getCoreMainClass().setupTwoStepVerification(str3, str2, str, loadListener);
            return;
        }
        try {
            String str4 = new String(bArr, Utf8Charset.NAME);
            if (str == null) {
                getCoreMainClass().changePassword(str4, str3, str2, loadListener);
            } else {
                getCoreMainClass().requestRecoveryEmail(str4, str, loadListener);
            }
        } catch (UnsupportedEncodingException e2) {
            MyLog.handleExceptionThrowOnDebug(e2);
            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
            tLRPC$TL_error2.text = "Failed To Password";
            requestDelegate.run(null, tLRPC$TL_error2);
        }
    }

    public void abortSetRecoveryEmail(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_cancelPasswordEmail) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$abortSetRecoveryEmail$14(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$abortSetRecoveryEmail$14(TLObject tLObject, final RequestDelegate requestDelegate) {
        try {
            getCoreMainClass().abortSetRecoveryEmail(new String(((TLRPC$TL_account_cancelPasswordEmail) tLObject).password, Utf8Charset.NAME), new LoadListener<TwoStepStatusObject>(this) { // from class: androidMessenger.proxy.ContactsProxy.9
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(TwoStepStatusObject twoStepStatusObject) {
                    requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Abort Setup";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        } catch (Exception e) {
            MyLog.handleExceptionThrowOnDebug(e);
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed Abort";
            requestDelegate.run(null, tLRPC$TL_error);
        }
    }

    public void confirmPasswordEmail(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_confirmPasswordEmail) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$confirmPasswordEmail$15(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$confirmPasswordEmail$15(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_account_confirmPasswordEmail tLRPC$TL_account_confirmPasswordEmail = (TLRPC$TL_account_confirmPasswordEmail) tLObject;
        String str = tLRPC$TL_account_confirmPasswordEmail.code;
        byte[] bArr = tLRPC$TL_account_confirmPasswordEmail.password;
        String str2 = null;
        if (bArr != null) {
            try {
                str2 = new String(bArr, Utf8Charset.NAME);
            } catch (UnsupportedEncodingException e) {
                MyLog.handleExceptionThrowOnDebug(e);
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Password";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
        }
        getCoreMainClass().verifyRecoveryEmail(str2, str, new LoadListener<VerifyRecoveryEmailOutput.StatusEnum>(this) { // from class: androidMessenger.proxy.ContactsProxy.10
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VerifyRecoveryEmailOutput.StatusEnum statusEnum) {
                TLRPC$TL_error tLRPC$TL_error2;
                if (statusEnum != null) {
                    if (statusEnum == VerifyRecoveryEmailOutput.StatusEnum.Expired) {
                        tLRPC$TL_error2 = new TLRPC$TL_error();
                        tLRPC$TL_error2.text = "FLOOD_WAIT";
                    } else if (statusEnum == VerifyRecoveryEmailOutput.StatusEnum.NotValid) {
                        tLRPC$TL_error2 = new TLRPC$TL_error();
                        tLRPC$TL_error2.text = "CODE_INVALID";
                    } else {
                        tLRPC$TL_error2 = null;
                    }
                } else {
                    tLRPC$TL_error2 = new TLRPC$TL_error();
                    tLRPC$TL_error2.text = "Failed To Confirm Two Step Password";
                }
                requestDelegate.run(null, tLRPC$TL_error2);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                tLRPC$TL_error2.text = "Failed To Confirm Two Step Password";
                requestDelegate.run(null, tLRPC$TL_error2);
            }
        });
    }

    public int getActiveSessions(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_getAuthorizations)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getActiveSessions$16(requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getActiveSessions$16(final RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().getMySessions(new LoadListener<GetMySessionsOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.11
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GetMySessionsOutput getMySessionsOutput) {
                TLRPC$TL_account_authorizations tLRPC$TL_account_authorizations = new TLRPC$TL_account_authorizations();
                tLRPC$TL_account_authorizations.authorizations = ContactConverter.convertAllSessions(getMySessionsOutput.other_sessions, getMySessionsOutput.active_session);
                tLRPC$TL_account_authorizations.canRemoveAll = getMySessionsOutput.can_remove_all;
                requestDelegate.run(tLRPC$TL_account_authorizations, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Active Sessions";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public void terminateSession(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_resetAuthorization) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$terminateSession$17(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$terminateSession$17(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().terminateSession(IdStorage.getInstance().getSessionId(((TLRPC$TL_account_resetAuthorization) tLObject).hash), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.12
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Terminate Session";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void terminateOtherSessions(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_resetAuthorizations) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$terminateOtherSessions$18(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$terminateOtherSessions$18(final RequestDelegate requestDelegate) {
        getCoreMainClass().terminateOtherSessions(new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.13
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(new TLRPC$TL_boolTrue(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Terminate Session";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void proxyThemes() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyThemes$20();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyThemes$20() {
        SettingModels.GetThemesOutput themesInstant = getCoreMainClass().getThemesInstant();
        Theme.makeThemesList(themesInstant != null ? themesInstant.themes : null, false);
    }

    private void initThemeIfNeeded() throws IOException {
        Theme.ThemeInfo theme;
        Theme.ThemeInfo theme2;
        final Theme.ThemeInfo theme3;
        SettingModels.AppearanceSettingObject appearanceSettingInstant = getCoreMainClass().getAppearanceSettingInstant();
        if (appearanceSettingInstant == null) {
            return;
        }
        String str = appearanceSettingInstant.manual_selected_theme_id;
        if (str != null && (theme3 = Theme.getTheme(str)) != null) {
            SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
            if (theme3 == Theme.getCurrentTheme()) {
                return;
            }
            if (!TextUtils.isEmpty(theme3.assetName)) {
                Theme.PatternsLoader.createLoader(false);
            }
            if (theme3.isDark()) {
                editorEdit.putString("nighttheme", theme3.getKey());
                editorEdit.remove("theme");
            } else {
                editorEdit.putString("theme", theme3.getKey());
                editorEdit.remove("nighttheme");
            }
            editorEdit.apply();
            Theme.applyTheme(theme3, theme3.isDark());
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsProxy.lambda$initThemeIfNeeded$21(theme3);
                }
            });
        }
        String str2 = appearanceSettingInstant.auto_dark_theme_id;
        if (str2 != null && (theme2 = Theme.getTheme(str2)) != null) {
            if (!TextUtils.isEmpty(theme2.assetName)) {
                Theme.PatternsLoader.createLoader(false);
            }
            SharedPreferences.Editor editorEdit2 = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
            editorEdit2.putString("lastDarkTheme", theme2.getKey());
            editorEdit2.apply();
            if (theme2 == Theme.getCurrentNightTheme()) {
                return;
            } else {
                Theme.setCurrentNightTheme(theme2);
            }
        }
        String str3 = appearanceSettingInstant.auto_day_theme_id;
        if (str3 == null || (theme = Theme.getTheme(str3)) == null) {
            return;
        }
        if (!TextUtils.isEmpty(theme.assetName)) {
            Theme.PatternsLoader.createLoader(false);
        }
        SharedPreferences.Editor editorEdit3 = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
        editorEdit3.putString("lastDayTheme", theme.getKey());
        editorEdit3.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initThemeIfNeeded$21(Theme.ThemeInfo themeInfo) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, themeInfo, Boolean.FALSE, null, -1);
    }

    public void proxySettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxySettings$22();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxySettings$22() {
        proxyNotificationSettings();
        proxyStickerSettings();
    }

    private void proxyStickerSettings() {
        SettingModels.StickerSettingObject stickerSettingInstant = getCoreMainClass().getStickerSettingInstant();
        if (stickerSettingInstant == null) {
            return;
        }
        SharedConfig.setSuggestStickers(ContactConverter.getStickerSuggestTypeValue(stickerSettingInstant.suggest_stickers_by_emoji));
    }

    public void proxyAppearanceSettings() throws IOException {
        SettingModels.TimeObject timeObject;
        SettingModels.TimeObject timeObject2;
        SettingModels.AppearanceSettingObject appearanceSettingInstant = getCoreMainClass().getAppearanceSettingInstant();
        if (appearanceSettingInstant == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        int i = appearanceSettingInstant.android_font_size;
        SharedConfig.fontSize = i;
        editorEdit.putInt("fons_size", i);
        boolean z = appearanceSettingInstant.large_emoji;
        SharedConfig.allowBigEmoji = z;
        editorEdit.putBoolean("allowBigEmoji", z);
        editorEdit.putBoolean("view_animations", appearanceSettingInstant.enable_animation);
        editorEdit.putBoolean("send_by_enter", appearanceSettingInstant.send_by_enter);
        boolean z2 = appearanceSettingInstant.save_to_gallery;
        SharedConfig.saveToGallery = z2;
        editorEdit.putBoolean("save_gallery", z2);
        boolean z3 = appearanceSettingInstant.direct_share;
        SharedConfig.directShare = z3;
        editorEdit.putBoolean("direct_share", z3);
        int i2 = appearanceSettingInstant.message_corner;
        SharedConfig.bubbleRadius = i2;
        editorEdit.putInt("bubbleRadius", i2);
        boolean z4 = appearanceSettingInstant.chat_list_view == SettingModels.ChatListViewType.ThreeLines;
        SharedConfig.useThreeLinesLayout = z4;
        editorEdit.putBoolean("useThreeLinesLayout", z4);
        int swipeGestureValue = ContactConverter.getSwipeGestureValue(appearanceSettingInstant.chat_list_swipe_gesture);
        SharedConfig.chatSwipeAction = swipeGestureValue;
        editorEdit.putInt("ChatSwipeAction", swipeGestureValue);
        Theme.selectedAutoNightType = ContactConverter.getAutoNightModeValue(appearanceSettingInstant.auto_night_mode_type);
        Theme.autoNightScheduleByLocation = appearanceSettingInstant.scheduled_use_local_sunset;
        if (appearanceSettingInstant.auto_night_mode_type == SettingModels.AutoNightModeType.Scheduled && (timeObject = appearanceSettingInstant.scheduled_from_time) != null && (timeObject2 = appearanceSettingInstant.scheduled_to_time) != null) {
            Theme.autoNightDayStartTime = (timeObject.hour * 60) + timeObject.minute;
            Theme.autoNightDayEndTime = (timeObject2.hour * 60) + timeObject2.minute;
        }
        if (appearanceSettingInstant.preferred_night_theme_id != null) {
            SharedPreferences.Editor editorEdit2 = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
            editorEdit2.putString("lastDarkTheme", appearanceSettingInstant.preferred_night_theme_id);
            editorEdit2.apply();
        }
        if (appearanceSettingInstant.auto_night_mode_type == SettingModels.AutoNightModeType.Adaptive) {
            Theme.autoNightBrighnessThreshold = appearanceSettingInstant.adaptive_brightness_threshold;
        }
        Theme.saveAutoNightThemeConfig();
        Theme.checkAutoNightThemeConditions();
        if (appearanceSettingInstant.quick_reaction != null) {
            getMediaDataController().setDoubleTapReaction(appearanceSettingInstant.quick_reaction.emoji_char);
        }
        editorEdit.apply();
        initThemeIfNeeded();
        initWallpaper();
    }

    private void initWallpaper() {
        ColorObject colorObject;
        Iterator<Theme.ThemeInfo> it = Theme.themes.iterator();
        while (it.hasNext()) {
            Theme.ThemeInfo next = it.next();
            boolean z = next.isBlured;
            String strGenerateWallpaperName = next.generateWallpaperName(null, z);
            String strGenerateWallpaperName2 = z ? next.generateWallpaperName(null, false) : strGenerateWallpaperName;
            Theme.OverrideWallpaperInfo overrideWallpaperInfo = new Theme.OverrideWallpaperInfo();
            overrideWallpaperInfo.fileName = strGenerateWallpaperName2;
            overrideWallpaperInfo.originalFileName = strGenerateWallpaperName;
            overrideWallpaperInfo.slug = next.slug;
            overrideWallpaperInfo.isBlurred = z;
            overrideWallpaperInfo.isMotion = next.isMotion;
            SettingModels.ChatBackGroundObject chatBackGroundObject = next.chatBackground;
            overrideWallpaperInfo.color = (chatBackGroundObject == null || (colorObject = chatBackGroundObject.chat_background_color) == null) ? 0 : colorObject.getColor();
            overrideWallpaperInfo.gradientColor = 0;
            overrideWallpaperInfo.rotation = 0;
            overrideWallpaperInfo.intensity = 0.0f;
            next.setOverrideWallpaper(overrideWallpaperInfo);
        }
    }

    public void proxyNotificationSettings() {
        SettingModels.NotificationSettingObject notificationSettingInstant = getCoreMainClass().getNotificationSettingInstant(FlavorHelper.isRubino());
        if (notificationSettingInstant == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = getAccountInstance().getNotificationsSettings().edit();
        NotificationsController notificationsController = getNotificationsController();
        boolean z = notificationSettingInstant.user_notification;
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        notificationsController.setGlobalNotificationsEnabled(1, z ? 0 : ConnectionsManager.DEFAULT_DATACENTER_ID);
        editorEdit.putBoolean("EnablePreviewAll", notificationSettingInstant.user_message_preview);
        editorEdit.putInt("vibrate_messages", ContactConverter.getVibrateValue(notificationSettingInstant.user_notification_vibrate));
        editorEdit.putInt("popupAll", ContactConverter.getPopupValue(notificationSettingInstant.user_notification_popup));
        editorEdit.putInt("priority_messages", ContactConverter.getImportanceValue(notificationSettingInstant.user_notification_importance));
        getNotificationsController().setGlobalNotificationsEnabled(0, notificationSettingInstant.group_notification ? 0 : ConnectionsManager.DEFAULT_DATACENTER_ID);
        editorEdit.putBoolean("EnablePreviewGroup", notificationSettingInstant.group_message_preview);
        editorEdit.putInt("vibrate_group", ContactConverter.getVibrateValue(notificationSettingInstant.group_notification_vibrate));
        editorEdit.putInt("popupGroup", ContactConverter.getPopupValue(notificationSettingInstant.group_notification_popup));
        editorEdit.putInt("priority_group", ContactConverter.getImportanceValue(notificationSettingInstant.group_notification_importance));
        NotificationsController notificationsController2 = getNotificationsController();
        if (notificationSettingInstant.channel_notification) {
            i = 0;
        }
        notificationsController2.setGlobalNotificationsEnabled(2, i);
        editorEdit.putBoolean("EnablePreviewChannel", notificationSettingInstant.channel_message_preview);
        editorEdit.putInt("vibrate_channel", ContactConverter.getVibrateValue(notificationSettingInstant.channel_notification_vibrate));
        editorEdit.putInt("popupChannel", ContactConverter.getPopupValue(notificationSettingInstant.channel_notification_popup));
        editorEdit.putInt("priority_channel", ContactConverter.getImportanceValue(notificationSettingInstant.channel_notification_importance));
        editorEdit.putInt("vibrate_calls", ContactConverter.getVibrateValue(notificationSettingInstant.vibrate_voice_calls));
        getNotificationsController().showBadgeNumber = notificationSettingInstant.badge_counter_enable;
        getNotificationsController().showBadgeMuted = notificationSettingInstant.badge_include_mute_chats;
        getNotificationsController().showBadgeMessages = notificationSettingInstant.badge_count_unread_messages;
        editorEdit.putBoolean("badgeNumber", getNotificationsController().showBadgeNumber);
        editorEdit.putBoolean("badgeNumberMuted", getNotificationsController().showBadgeMuted);
        editorEdit.putBoolean("badgeNumberMessages", getNotificationsController().showBadgeMessages);
        editorEdit.putBoolean("EnableInAppSounds", notificationSettingInstant.in_app_sound);
        editorEdit.putBoolean("EnableInAppVibrate", notificationSettingInstant.in_app_vibrate);
        editorEdit.putBoolean("EnableInAppPreview", notificationSettingInstant.in_app_preview);
        editorEdit.putBoolean("EnableInChatSound", notificationSettingInstant.in_chat_sounds);
        editorEdit.putBoolean("EnableInAppPriority", notificationSettingInstant.importance);
        MessagesController messagesController = getMessagesController();
        boolean z2 = notificationSettingInstant.event_contact_joined;
        messagesController.enableJoined = z2;
        editorEdit.putBoolean("EnableContactJoined", z2);
        editorEdit.putBoolean("PinnedMessages", notificationSettingInstant.event_pinned_messages);
        editorEdit.apply();
        getNotificationsController().deleteNotificationChannelGlobal(2);
        getNotificationsController().deleteNotificationChannelGlobal(0);
        getNotificationsController().deleteNotificationChannelGlobal(1);
        getNotificationsController().updateBadge();
    }

    public void proxyDataSettings() {
        SettingModels.DataSettingObject dataSettingInstant = getCoreMainClass().getDataSettingInstant();
        if (dataSettingInstant == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        DownloadController.Preset preset = DownloadController.getInstance(this.currentAccount).mobilePreset;
        preset.enabled = dataSettingInstant.cellular_auto_download;
        ContactConverter.setPresetMask(preset, dataSettingInstant.cellular_photo_auto_download, 1);
        ContactConverter.setPresetMask(preset, dataSettingInstant.cellular_video_auto_download, 4);
        ContactConverter.setPresetMask(preset, dataSettingInstant.cellular_file_auto_download, 8);
        ContactConverter.setPresetMask(preset, dataSettingInstant.cellular_music_auto_download, 2);
        editorEdit.putString("mobilePreset", preset.toString());
        DownloadController.Preset preset2 = DownloadController.getInstance(this.currentAccount).wifiPreset;
        preset2.enabled = dataSettingInstant.wifi_auto_download;
        ContactConverter.setPresetMask(preset2, dataSettingInstant.wifi_photo_auto_download, 1);
        ContactConverter.setPresetMask(preset2, dataSettingInstant.wifi_video_auto_download, 4);
        ContactConverter.setPresetMask(preset2, dataSettingInstant.wifi_file_auto_download, 8);
        ContactConverter.setPresetMask(preset2, dataSettingInstant.wifi_music_auto_download, 2);
        editorEdit.putString("wifiPreset", preset2.toString());
        boolean z = dataSettingInstant.gif_auto_play;
        SharedConfig.autoplayGifs = z;
        editorEdit.putBoolean("autoplay_gif", z);
        boolean z2 = dataSettingInstant.video_auto_play;
        SharedConfig.autoplayVideo = z2;
        editorEdit.putBoolean("autoplay_video", z2);
        boolean z3 = dataSettingInstant.stream_videos_and_audio_files;
        SharedConfig.streamMedia = z3;
        editorEdit.putBoolean("streamMedia", z3);
        int keepMediaValue = ContactConverter.getKeepMediaValue(dataSettingInstant.keep_media);
        SharedConfig.keepMedia = keepMediaValue;
        editorEdit.putInt("keep_media", keepMediaValue);
        editorEdit.apply();
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
    }

    public int addContact(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_contacts_importContacts) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addContact$23(tLObject, requestDelegate);
                }
            });
            return 0;
        }
        if (!(tLObject instanceof TLRPC$TL_contacts_addContact)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addContact$24(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContact$23(TLObject tLObject, final RequestDelegate requestDelegate) {
        Iterator<TLRPC$TL_inputPhoneContact> it = ((TLRPC$TL_contacts_importContacts) tLObject).contacts.iterator();
        while (it.hasNext()) {
            TLRPC$TL_inputPhoneContact next = it.next();
            getCoreMainClass().addContact(next.first_name, next.last_name, PhoneFormat.stripExceptNumbers(next.phone), new LoadListener<String>() { // from class: androidMessenger.proxy.ContactsProxy.15
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(String str) {
                    TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts = new TLRPC$TL_contacts_importedContacts();
                    if (str != null) {
                        ChatAbsObject absInstant = ContactsProxy.this.getCoreMainClass().getAbsInstant(str);
                        if (absInstant == null) {
                            requestDelegate.run(tLRPC$TL_contacts_importedContacts, null);
                            return;
                        } else {
                            tLRPC$TL_contacts_importedContacts.users.add(ChatConverter.convertUser(ContactsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), absInstant, (UserInfo) null, (Chat) null));
                        }
                    }
                    requestDelegate.run(tLRPC$TL_contacts_importedContacts, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    if (exc instanceof InputException) {
                        tLRPC$TL_error.text = "INVALID_PHONE_NUMBER";
                    } else {
                        tLRPC$TL_error.text = "Failed To Add Contact";
                    }
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContact$24(TLObject tLObject, final RequestDelegate requestDelegate) {
        final TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
        TLRPC$TL_contacts_addContact tLRPC$TL_contacts_addContact = (TLRPC$TL_contacts_addContact) tLObject;
        getCoreMainClass().addContact(tLRPC$TL_contacts_addContact.first_name, tLRPC$TL_contacts_addContact.last_name, PhoneFormat.stripExceptNumbers(tLRPC$TL_contacts_addContact.phone), new LoadListener<String>() { // from class: androidMessenger.proxy.ContactsProxy.16
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                ChatAbsObject absInstant;
                if (str != null && (absInstant = ContactsProxy.this.getCoreMainClass().getAbsInstant(str)) != null) {
                    tLRPC$TL_updates.users.add(ChatConverter.convertUser(ContactsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), absInstant, (UserInfo) null, (Chat) null));
                }
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Add Contact";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int deleteContact(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_contacts_deleteContacts)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContact$25(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteContact$25(TLObject tLObject, final RequestDelegate requestDelegate) {
        Iterator<TLRPC$InputUser> it = ((TLRPC$TL_contacts_deleteContacts) tLObject).id.iterator();
        while (it.hasNext()) {
            getCoreMainClass().deleteContact(IdStorage.getInstance().getDialogId(it.next().user_id), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.17
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    requestDelegate.run(new TLRPC$TL_updates(), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Delete Contact";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    public int deleteAllContacts(final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteAllContacts$26(requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAllContacts$26(final RequestDelegate requestDelegate) {
        getCoreMainClass().resetContacts(new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.18
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Reset Contacts";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void checkPassword(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_getPasswordSettings) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkPassword$27(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$27(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().checkTwoStepPasscode(((TLRPC$TL_account_getPasswordSettings) tLObject).oldPassword, new LoadListener<Boolean>(this) { // from class: androidMessenger.proxy.ContactsProxy.19
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Boolean bool) {
                TLRPC$TL_error tLRPC$TL_error;
                if (bool.booleanValue()) {
                    tLRPC$TL_error = null;
                } else {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "PASSWORD_HASH_INVALID";
                }
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "INVALID PASSWORD";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void resendCodeRecoveryEmail(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_resendPasswordEmail) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resendCodeRecoveryEmail$28(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resendCodeRecoveryEmail$28(TLObject tLObject, final RequestDelegate requestDelegate) {
        String str = null;
        if (((TLRPC$TL_account_resendPasswordEmail) tLObject).password != null) {
            try {
                str = new String(((TLRPC$TL_account_resendPasswordEmail) tLObject).password, Utf8Charset.NAME);
            } catch (UnsupportedEncodingException e) {
                MyLog.handleExceptionThrowOnDebug(e);
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed Resend Recovery Email";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
        }
        getCoreMainClass().resendCodeRecoveryEmail(str, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.20
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                tLRPC$TL_error2.text = "Failed To Resend Code";
                requestDelegate.run(null, tLRPC$TL_error2);
            }
        });
    }

    public void requestForgetPassword(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_requestPasswordRecovery) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestForgetPassword$29(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestForgetPassword$29(final RequestDelegate requestDelegate) {
        getCoreMainClass().requestForgetPassword(new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.21
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(new TLRPC$TL_auth_passwordRecovery(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Request Forget Password";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void disableTwoStepByForgetPassword(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_recoverPassword) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$disableTwoStepByForgetPassword$30(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disableTwoStepByForgetPassword$30(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().disableTwoStepByForgetPassword(((TLRPC$TL_auth_recoverPassword) tLObject).code, new LoadListener<DisableTwoStepByForgetPasswordOutput.StatusEnum>(this) { // from class: androidMessenger.proxy.ContactsProxy.22
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(DisableTwoStepByForgetPasswordOutput.StatusEnum statusEnum) {
                TLRPC$TL_error tLRPC$TL_error;
                if (statusEnum == DisableTwoStepByForgetPasswordOutput.StatusEnum.NotValid) {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "CODE_INVALID";
                } else if (statusEnum == DisableTwoStepByForgetPasswordOutput.StatusEnum.Expired) {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "FLOOD_WAIT";
                } else {
                    tLRPC$TL_error = null;
                }
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Request Forget Password";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void changePhoneNumber(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_account_sendChangePhoneCode) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$changePhoneNumber$31(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changePhoneNumber$31(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().requestChangePhoneNumber(((TLRPC$TL_account_sendChangePhoneCode) tLObject).phone_number, new LoadListener<RequestChangePhoneNumberOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.23
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(RequestChangePhoneNumberOutput requestChangePhoneNumberOutput) {
                TLRPC$TL_error tLRPC$TL_error;
                RequestChangePhoneNumberOutput.Status status = requestChangePhoneNumberOutput.status;
                TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = null;
                if (status == RequestChangePhoneNumberOutput.Status.OK) {
                    TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode2 = new TLRPC$TL_auth_sentCode();
                    tLRPC$TL_auth_sentCode2.next_type = new TLRPC$TL_auth_codeTypeSms();
                    tLRPC$TL_auth_sentCode2.phone_code_hash = requestChangePhoneNumberOutput.hash;
                    TLRPC$TL_auth_sentCodeTypeSms tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$TL_auth_sentCodeTypeSms();
                    tLRPC$TL_auth_sentCode2.type = tLRPC$TL_auth_sentCodeTypeSms;
                    tLRPC$TL_auth_sentCodeTypeSms.length = requestChangePhoneNumberOutput.code_digits_count;
                    tLRPC$TL_error = null;
                    tLRPC$TL_auth_sentCode = tLRPC$TL_auth_sentCode2;
                } else if (status == RequestChangePhoneNumberOutput.Status.Same || status == RequestChangePhoneNumberOutput.Status.Exist) {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "PHONE_NUMBER_OCCUPIED";
                } else {
                    tLRPC$TL_error = null;
                }
                requestDelegate.run(tLRPC$TL_auth_sentCode, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : BuildConfig.FLAVOR;
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int verifyChangePhoneNumber(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_changePhone)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$verifyChangePhoneNumber$32(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$verifyChangePhoneNumber$32(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_account_changePhone tLRPC$TL_account_changePhone = (TLRPC$TL_account_changePhone) tLObject;
        getCoreMainClass().verifyChangePhoneNumber(tLRPC$TL_account_changePhone.phone_code_hash, tLRPC$TL_account_changePhone.phone_code, new LoadListener<VerifyChangePhoneNumberOutput.Status>() { // from class: androidMessenger.proxy.ContactsProxy.24
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VerifyChangePhoneNumberOutput.Status status) {
                TLRPC$TL_error tLRPC$TL_error;
                TLRPC$User tLRPC$UserConvertUser;
                TLRPC$User tLRPC$User = null;
                if (status == VerifyChangePhoneNumberOutput.Status.IsValid) {
                    UserInfo myUserInfo = ContactsProxy.this.getCoreMainClass().getMyUserInfo();
                    if (myUserInfo != null) {
                        tLRPC$UserConvertUser = ChatConverter.convertUser(ContactsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(myUserInfo.user_guid), ContactsProxy.this.getCoreMainClass().getAbsInstant(myUserInfo.user_guid), myUserInfo, (Chat) null);
                    } else {
                        TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
                        tLRPC$TL_error2.text = "user info is null";
                        tLRPC$User = tLRPC$TL_error2;
                        tLRPC$UserConvertUser = null;
                    }
                    TLRPC$User tLRPC$User2 = tLRPC$User;
                    tLRPC$User = tLRPC$UserConvertUser;
                    tLRPC$TL_error = tLRPC$User2;
                } else if (status == VerifyChangePhoneNumberOutput.Status.NotValid) {
                    TLRPC$TL_error tLRPC$TL_error3 = new TLRPC$TL_error();
                    tLRPC$TL_error3.text = "PHONE_CODE_INVALID";
                    tLRPC$TL_error = tLRPC$TL_error3;
                } else if (status == VerifyChangePhoneNumberOutput.Status.Expired) {
                    TLRPC$TL_error tLRPC$TL_error4 = new TLRPC$TL_error();
                    tLRPC$TL_error4.text = "PHONE_CODE_EXPIRED";
                    tLRPC$TL_error = tLRPC$TL_error4;
                } else if (status == VerifyChangePhoneNumberOutput.Status.Used) {
                    TLRPC$TL_error tLRPC$TL_error5 = new TLRPC$TL_error();
                    tLRPC$TL_error5.text = "There is an account with this phone number";
                    tLRPC$TL_error = tLRPC$TL_error5;
                } else {
                    tLRPC$TL_error = 0;
                }
                requestDelegate.run(tLRPC$User, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "PHONE_CODE_INVALID";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void requestLoginForgetPassword(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_requestPasswordRecovery) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestLoginForgetPassword$33(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestLoginForgetPassword$33(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().loginTwoStepForgetPassword(((TLRPC$TL_auth_requestPasswordRecovery) tLObject).phoneNumber, new LoadListener<LoginTwoStepForgetPasswordOutput>(this) { // from class: androidMessenger.proxy.ContactsProxy.25
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LoginTwoStepForgetPasswordOutput loginTwoStepForgetPasswordOutput) {
                if (loginTwoStepForgetPasswordOutput != null) {
                    TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = new TLRPC$TL_auth_passwordRecovery();
                    tLRPC$TL_auth_passwordRecovery.email_pattern = loginTwoStepForgetPasswordOutput.confirmed_recovery_email;
                    tLRPC$TL_auth_passwordRecovery.forget_password_code_hash = loginTwoStepForgetPasswordOutput.forget_password_code_hash;
                    requestDelegate.run(tLRPC$TL_auth_passwordRecovery, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Request Forget Password";
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : BuildConfig.FLAVOR;
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void requestDisableTwoStep(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_recoverPassword) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestDisableTwoStep$34(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDisableTwoStep$34(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = (TLRPC$TL_auth_recoverPassword) tLObject;
        getCoreMainClass().loginDisableTwoStep(tLRPC$TL_auth_recoverPassword.phoneNumber, tLRPC$TL_auth_recoverPassword.hashCode, tLRPC$TL_auth_recoverPassword.code, new LoadListener<LoginDisableTwoStepOutput.StatusEnum>(this) { // from class: androidMessenger.proxy.ContactsProxy.26
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LoginDisableTwoStepOutput.StatusEnum statusEnum) {
                TLRPC$TL_error tLRPC$TL_error;
                TLRPC$TL_auth_authorization tLRPC$TL_auth_authorization = null;
                if (statusEnum != null) {
                    if (statusEnum == LoginDisableTwoStepOutput.StatusEnum.OK) {
                        tLRPC$TL_auth_authorization = new TLRPC$TL_auth_authorization();
                        tLRPC$TL_error = null;
                    } else if (statusEnum == LoginDisableTwoStepOutput.StatusEnum.CodeIsUsed) {
                        tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = LogInException.ErrorEnum.CodeIsUsed.name();
                    } else if (statusEnum == LoginDisableTwoStepOutput.StatusEnum.CodeIsExpired) {
                        tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = LogInException.ErrorEnum.CodeIsExpired.name();
                    } else if (statusEnum == LoginDisableTwoStepOutput.StatusEnum.CodeIsInvalid) {
                        tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "CODE_INVALID";
                    } else {
                        tLRPC$TL_error = null;
                    }
                } else {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Disable Forget Password";
                }
                requestDelegate.run(tLRPC$TL_auth_authorization, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : BuildConfig.FLAVOR;
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSettings$35() {
        getCoreMainClass().initSettingIfNeeded();
    }

    public void initSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initSettings$35();
            }
        });
    }

    public void saveStickerSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveStickerSettings$36();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveStickerSettings$36() {
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        HashMap map = new HashMap();
        map.put(SettingModels.ParameterNameEnum.suggest_stickers_by_emoji, ContactConverter.getStickerSuggestTypeValueCore(globalMainSettings.getInt("suggestStickers", 0)));
        getCoreMainClass().setSettings(FlavorHelper.isRubino(), map, null);
    }

    public void saveDataSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDataSettings$37();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDataSettings$37() {
        DownloadController.Preset preset = DownloadController.getInstance(this.currentAccount).mobilePreset;
        HashMap map = new HashMap();
        map.put(SettingModels.ParameterNameEnum.cellular_auto_download, Boolean.valueOf(preset.enabled));
        map.put(SettingModels.ParameterNameEnum.cellular_photo_auto_download, ContactConverter.getAutoDownloadObject(preset, 1, 0));
        map.put(SettingModels.ParameterNameEnum.cellular_file_auto_download, ContactConverter.getAutoDownloadObject(preset, 8, 2));
        map.put(SettingModels.ParameterNameEnum.cellular_video_auto_download, ContactConverter.getAutoDownloadObject(preset, 4, 1));
        DownloadController.Preset preset2 = DownloadController.getInstance(this.currentAccount).wifiPreset;
        map.put(SettingModels.ParameterNameEnum.wifi_auto_download, Boolean.valueOf(preset2.enabled));
        map.put(SettingModels.ParameterNameEnum.wifi_photo_auto_download, ContactConverter.getAutoDownloadObject(preset2, 1, 0));
        map.put(SettingModels.ParameterNameEnum.wifi_file_auto_download, ContactConverter.getAutoDownloadObject(preset2, 8, 2));
        map.put(SettingModels.ParameterNameEnum.wifi_video_auto_download, ContactConverter.getAutoDownloadObject(preset2, 4, 1));
        map.put(SettingModels.ParameterNameEnum.gif_auto_play, Boolean.valueOf(SharedConfig.autoplayGifs));
        map.put(SettingModels.ParameterNameEnum.video_auto_play, Boolean.valueOf(SharedConfig.autoplayVideo));
        map.put(SettingModels.ParameterNameEnum.stream_videos_and_audio_files, Boolean.valueOf(SharedConfig.streamMedia));
        map.put(SettingModels.ParameterNameEnum.keep_media, ContactConverter.getKeepMediaCoreValue(SharedConfig.keepMedia));
        setDeviceSettings(map, null);
    }

    public void saveAppearanceSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveAppearanceSettings$38();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveAppearanceSettings$38() {
        HashMap map = new HashMap();
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        map.put(SettingModels.ParameterNameEnum.android_font_size, Integer.valueOf(SharedConfig.fontSize));
        map.put(SettingModels.ParameterNameEnum.large_emoji, Boolean.valueOf(SharedConfig.allowBigEmoji));
        map.put(SettingModels.ParameterNameEnum.enable_animation, Boolean.valueOf(globalMainSettings.getBoolean("view_animations", true)));
        map.put(SettingModels.ParameterNameEnum.send_by_enter, Boolean.valueOf(globalMainSettings.getBoolean("send_by_enter", true)));
        map.put(SettingModels.ParameterNameEnum.save_to_gallery, Boolean.valueOf(SharedConfig.saveToGallery));
        map.put(SettingModels.ParameterNameEnum.direct_share, Boolean.valueOf(SharedConfig.directShare));
        map.put(SettingModels.ParameterNameEnum.message_corner, Integer.valueOf(SharedConfig.bubbleRadius));
        map.put(SettingModels.ParameterNameEnum.chat_list_view, SharedConfig.useThreeLinesLayout ? SettingModels.ChatListViewType.ThreeLines : SettingModels.ChatListViewType.TwoLines);
        map.put(SettingModels.ParameterNameEnum.chat_list_swipe_gesture, ContactConverter.getSwipeGestureCoreValue(SharedConfig.chatSwipeAction));
        map.put(SettingModels.ParameterNameEnum.auto_night_mode_type, ContactConverter.getAutoNightModeCoreValue(Theme.selectedAutoNightType));
        map.put(SettingModels.ParameterNameEnum.scheduled_use_local_sunset, Boolean.valueOf(Theme.autoNightScheduleByLocation));
        if (Theme.selectedAutoNightType == 1) {
            if (Theme.autoNightDayStartTime > 0) {
                SettingModels.TimeObject timeObject = new SettingModels.TimeObject();
                int i = Theme.autoNightDayStartTime;
                int i2 = i / 60;
                timeObject.hour = i2;
                timeObject.minute = i - (i2 * 60);
                map.put(SettingModels.ParameterNameEnum.scheduled_from_time, timeObject);
            }
            if (Theme.autoNightDayEndTime > 0) {
                new SettingModels.TimeObject();
                SettingModels.TimeObject timeObject2 = new SettingModels.TimeObject();
                int i3 = Theme.autoNightDayEndTime;
                int i4 = i3 / 60;
                timeObject2.hour = i4;
                timeObject2.minute = i3 - (i4 * 60);
                map.put(SettingModels.ParameterNameEnum.scheduled_to_time, timeObject2);
            }
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0);
        if (sharedPreferences.contains("lastDarkTheme")) {
            map.put(SettingModels.ParameterNameEnum.preferred_night_theme_id, sharedPreferences.getString("lastDarkTheme", null));
        }
        if (Theme.selectedAutoNightType == 2) {
            map.put(SettingModels.ParameterNameEnum.adaptive_brightness_threshold, Float.valueOf(Theme.autoNightBrighnessThreshold));
        }
        map.put(SettingModels.ParameterNameEnum.manual_selected_theme_id, globalMainSettings.getString("theme", null));
        setDeviceSettings(map, null);
    }

    public void saveNotificationSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveNotificationSettings$39();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveNotificationSettings$39() {
        HashMap map = new HashMap();
        SharedPreferences notificationsSettings = getAccountInstance().getNotificationsSettings();
        map.put(SettingModels.ParameterNameEnum.user_notification, Boolean.valueOf(getNotificationsController().isGlobalNotificationsEnabled(1)));
        map.put(SettingModels.ParameterNameEnum.user_message_preview, Boolean.valueOf(notificationsSettings.getBoolean("EnablePreviewAll", true)));
        map.put(SettingModels.ParameterNameEnum.user_notification_vibrate, ContactConverter.getVibrateCoreValue(notificationsSettings.getInt("vibrate_messages", 0)));
        map.put(SettingModels.ParameterNameEnum.user_notification_popup, ContactConverter.getPopupCoreValue(notificationsSettings.getInt("popupAll", 0)));
        map.put(SettingModels.ParameterNameEnum.user_notification_importance, ContactConverter.getImportanceCoreValue(notificationsSettings.getInt("priority_messages", 0)));
        map.put(SettingModels.ParameterNameEnum.group_notification, Boolean.valueOf(getNotificationsController().isGlobalNotificationsEnabled(0)));
        map.put(SettingModels.ParameterNameEnum.group_message_preview, Boolean.valueOf(notificationsSettings.getBoolean("EnablePreviewGroup", true)));
        map.put(SettingModels.ParameterNameEnum.group_notification_vibrate, ContactConverter.getVibrateCoreValue(notificationsSettings.getInt("vibrate_group", 0)));
        map.put(SettingModels.ParameterNameEnum.group_notification_popup, ContactConverter.getPopupCoreValue(notificationsSettings.getInt("popupGroup", 0)));
        map.put(SettingModels.ParameterNameEnum.group_notification_importance, ContactConverter.getImportanceCoreValue(notificationsSettings.getInt("priority_group", 0)));
        map.put(SettingModels.ParameterNameEnum.channel_notification, Boolean.valueOf(getNotificationsController().isGlobalNotificationsEnabled(2)));
        map.put(SettingModels.ParameterNameEnum.channel_message_preview, Boolean.valueOf(notificationsSettings.getBoolean("EnablePreviewChannel", true)));
        map.put(SettingModels.ParameterNameEnum.channel_notification_vibrate, ContactConverter.getVibrateCoreValue(notificationsSettings.getInt("vibrate_channel", 0)));
        map.put(SettingModels.ParameterNameEnum.channel_notification_popup, ContactConverter.getPopupCoreValue(notificationsSettings.getInt("popupChannel", 0)));
        map.put(SettingModels.ParameterNameEnum.channel_notification_importance, ContactConverter.getImportanceCoreValue(notificationsSettings.getInt("priority_channel", 0)));
        map.put(SettingModels.ParameterNameEnum.vibrate_voice_calls, ContactConverter.getVibrateCoreValue(notificationsSettings.getInt("vibrate_calls", 0)));
        map.put(SettingModels.ParameterNameEnum.badge_counter_enable, Boolean.valueOf(getNotificationsController().showBadgeNumber));
        map.put(SettingModels.ParameterNameEnum.badge_include_mute_chats, Boolean.valueOf(getNotificationsController().showBadgeMuted));
        map.put(SettingModels.ParameterNameEnum.badge_count_unread_messages, Boolean.valueOf(getNotificationsController().showBadgeMessages));
        map.put(SettingModels.ParameterNameEnum.in_app_sound, Boolean.valueOf(notificationsSettings.getBoolean("EnableInAppSounds", true)));
        map.put(SettingModels.ParameterNameEnum.in_app_vibrate, Boolean.valueOf(notificationsSettings.getBoolean("EnableInAppVibrate", true)));
        map.put(SettingModels.ParameterNameEnum.in_app_preview, Boolean.valueOf(notificationsSettings.getBoolean("EnableInAppPreview", true)));
        map.put(SettingModels.ParameterNameEnum.in_chat_sounds, Boolean.valueOf(notificationsSettings.getBoolean("EnableInChatSound", true)));
        map.put(SettingModels.ParameterNameEnum.importance, Boolean.valueOf(notificationsSettings.getBoolean("EnableInAppPriority", true)));
        map.put(SettingModels.ParameterNameEnum.event_contact_joined, Boolean.valueOf(getMessagesController().enableJoined));
        map.put(SettingModels.ParameterNameEnum.event_pinned_messages, Boolean.valueOf(notificationsSettings.getBoolean("PinnedMessages", true)));
        setDeviceSettings(map, new LoadListener<Integer>() { // from class: androidMessenger.proxy.ContactsProxy.27
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                ContactsProxy.this.proxyNotificationSettings();
            }
        });
    }

    public void getSettings(final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getSettings$40(requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSettings$40(final RequestDelegate requestDelegate) {
        getAppRequestRx().getSettings(new ApiRequestRx.ResponseListener<GetSettingsOutput2>() { // from class: androidMessenger.proxy.ContactsProxy.28
            @Override // androidMessenger.network.ApiRequestRx.ResponseListener
            public void onResponse(GetSettingsOutput2 getSettingsOutput2) {
                TLRPC$Tl_settings_parts tLRPC$Tl_settings_parts = new TLRPC$Tl_settings_parts();
                ArrayList<SettingItem2> arrayList = new ArrayList<>();
                Iterator it = ContactsProxy.this.getSettingPartsOfCurrentLanguage(getSettingsOutput2.setting_parts).iterator();
                while (it.hasNext()) {
                    SettingPartObject settingPartObject = (SettingPartObject) it.next();
                    boolean z = false;
                    int size = -1;
                    if (settingPartObject.title != null) {
                        size = arrayList.size();
                        arrayList.add(new SettingItem2(settingPartObject.title));
                    }
                    ArrayList<SettingItem2> arrayList2 = settingPartObject.setting_items;
                    if (arrayList2 != null) {
                        Iterator<SettingItem2> it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            SettingItem2 next = it2.next();
                            if (next.type == SettingItem2.TypeEnum.Simple) {
                                z = true;
                                arrayList.add(next);
                            }
                        }
                    }
                    if (z) {
                        arrayList.add(new SettingItem2(SettingItem2.TypeEnum.Empty));
                    } else if (size >= 0 && size < arrayList.size()) {
                        arrayList.remove(size);
                    }
                }
                tLRPC$Tl_settings_parts.parts = arrayList;
                requestDelegate.run(tLRPC$Tl_settings_parts, null);
            }

            @Override // androidMessenger.network.ApiRequestRx.ResponseListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<SettingPartObject> getSettingPartsOfCurrentLanguage(SettingPartPerLanguageObject settingPartPerLanguageObject) {
        if (settingPartPerLanguageObject == null) {
            return null;
        }
        String language = LocaleController.getInstance().getCurrentLocale().getLanguage();
        if (language.equals("fa") || language.startsWith("fa_")) {
            return settingPartPerLanguageObject.fa;
        }
        if (language.equals("ar") || language.startsWith("ar_")) {
            return settingPartPerLanguageObject.ar;
        }
        return settingPartPerLanguageObject.en;
    }

    public void getStickerSettings() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getStickerSettings$41();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getStickerSettings$41() {
        getCoreMainClass().loadStickerSetting(null);
    }

    public void setSetting(final SettingModels.ParameterNameEnum parameterNameEnum, final Object obj, final RequestDelegate requestDelegate) {
        if (parameterNameEnum == null || obj == null) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setSetting$42(parameterNameEnum, obj, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSetting$42(SettingModels.ParameterNameEnum parameterNameEnum, Object obj, final RequestDelegate requestDelegate) {
        HashMap map = new HashMap();
        map.put(parameterNameEnum, obj);
        getCoreMainClass().setSettings(FlavorHelper.isRubino(), map, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.29
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(new TLRPC$TL_boolTrue(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void setSetting(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_setPrivacy)) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda42
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setSetting$43(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSetting$43(TLObject tLObject, final RequestDelegate requestDelegate) {
        HashMap map = new HashMap();
        TLRPC$TL_account_setPrivacy tLRPC$TL_account_setPrivacy = (TLRPC$TL_account_setPrivacy) tLObject;
        final TLRPC$InputPrivacyKey tLRPC$InputPrivacyKey = tLRPC$TL_account_setPrivacy.key;
        ArrayList<TLRPC$InputPrivacyRule> arrayList = tLRPC$TL_account_setPrivacy.rules;
        TLRPC$InputPrivacyRule tLRPC$InputPrivacyRule = (arrayList == null || arrayList.isEmpty()) ? null : tLRPC$TL_account_setPrivacy.rules.get(0);
        if (tLRPC$InputPrivacyRule == null) {
            requestDelegate.run(null, new TLRPC$TL_error());
            return;
        }
        PrivacySettings.AccessLevelEnum privacyRuleValue = ContactConverter.getPrivacyRuleValue(tLRPC$InputPrivacyRule);
        if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyPhoneNumber) {
            map.put(SettingModels.ParameterNameEnum.show_my_phone_number, privacyRuleValue);
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyForwards) {
            map.put(SettingModels.ParameterNameEnum.link_forward_message, privacyRuleValue);
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyPhoneCall) {
            map.put(SettingModels.ParameterNameEnum.can_called_by, privacyRuleValue);
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyProfilePhoto) {
            map.put(SettingModels.ParameterNameEnum.show_my_profile_photo, privacyRuleValue);
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyChatInvite) {
            map.put(SettingModels.ParameterNameEnum.can_join_chat_by, privacyRuleValue);
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyStatusTimestamp) {
            map.put(SettingModels.ParameterNameEnum.show_my_last_online, privacyRuleValue);
        }
        getCoreMainClass().setSettings(FlavorHelper.isRubino(), map, new LoadListener<Integer>() { // from class: androidMessenger.proxy.ContactsProxy.30
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                TLRPC$TL_account_privacyRules tLRPC$TL_account_privacyRules = new TLRPC$TL_account_privacyRules();
                tLRPC$TL_account_privacyRules.rules = ContactConverter.convertPrivacyRule(tLRPC$InputPrivacyKey, ContactsProxy.this.getCoreMainClass().getPrivacySettingInstant());
                requestDelegate.run(tLRPC$TL_account_privacyRules, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void getAvailableReactions(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_getAvailableReactions)) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getAvailableReactions$44(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAvailableReactions$44(final RequestDelegate requestDelegate) {
        getCoreMainClass().loadAvailableReactions(new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.ContactsProxy.31
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void proxyLoadedAvailableReactions() {
        final ArrayList<ReactionObject> availableReactions = getCoreMainClass().getAvailableReactions();
        if (availableReactions == null || availableReactions.isEmpty()) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyLoadedAvailableReactions$46(availableReactions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyLoadedAvailableReactions$46(ArrayList arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ContactConverter.convertToAvailableReaction((ReactionObject) it.next()));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyLoadedAvailableReactions$45(arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyLoadedAvailableReactions$45(ArrayList arrayList) {
        getMediaDataController().processLoadedReactions(arrayList, 0, (int) (System.currentTimeMillis() / 1000), false);
    }

    public void setDoubleTapReaction(final TLRPC$TL_availableReaction tLRPC$TL_availableReaction) {
        if (tLRPC$TL_availableReaction == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.ContactsProxy$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDoubleTapReaction$47(tLRPC$TL_availableReaction);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDoubleTapReaction$47(TLRPC$TL_availableReaction tLRPC$TL_availableReaction) {
        ReactionObject next;
        Iterator<ReactionObject> it = getCoreMainClass().getAvailableReactions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Objects.equals(next.reaction_id, tLRPC$TL_availableReaction.reaction_id)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        map.put(SettingModels.ParameterNameEnum.quick_reaction, next);
        getCoreMainClass().setSettings(FlavorHelper.isRubino(), map, null);
    }
}
