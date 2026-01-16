package ir.eitaa.messenger;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputUser;
import ir.eitaa.tgnet.TLRPC$PrivacyRule;
import ir.eitaa.tgnet.TLRPC$TL_accountDaysTTL;
import ir.eitaa.tgnet.TLRPC$TL_account_getPrivacy;
import ir.eitaa.tgnet.TLRPC$TL_account_privacyRules;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$TL_contactStatus;
import ir.eitaa.tgnet.TLRPC$TL_contacts_addContact;
import ir.eitaa.tgnet.TLRPC$TL_contacts_contactsNotModified;
import ir.eitaa.tgnet.TLRPC$TL_contacts_deleteContacts;
import ir.eitaa.tgnet.TLRPC$TL_contacts_getContacts;
import ir.eitaa.tgnet.TLRPC$TL_contacts_importContacts;
import ir.eitaa.tgnet.TLRPC$TL_contacts_importedContacts;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_globalPrivacySettings;
import ir.eitaa.tgnet.TLRPC$TL_help_inviteText;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyAddedByPhone;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyForwards;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyPhoneNumber;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyPhoneP2P;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputPrivacyKeyStatusTimestamp;
import ir.eitaa.tgnet.TLRPC$TL_popularContact;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastMonth;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastWeek;
import ir.eitaa.tgnet.TLRPC$TL_userStatusRecently;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$contacts_Contacts;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class ContactsController extends BaseController {
    private static volatile ContactsController[] Instance = new ContactsController[3];
    public static final int PRIVACY_RULES_TYPE_ADDED_BY_PHONE = 7;
    public static final int PRIVACY_RULES_TYPE_CALLS = 2;
    public static final int PRIVACY_RULES_TYPE_COUNT = 8;
    public static final int PRIVACY_RULES_TYPE_FORWARDS = 5;
    public static final int PRIVACY_RULES_TYPE_INVITE = 1;
    public static final int PRIVACY_RULES_TYPE_LASTSEEN = 0;
    public static final int PRIVACY_RULES_TYPE_P2P = 3;
    public static final int PRIVACY_RULES_TYPE_PHONE = 6;
    public static final int PRIVACY_RULES_TYPE_PHOTO = 4;
    private ArrayList<TLRPC$PrivacyRule> addedByPhonePrivacyRules;
    private ArrayList<TLRPC$PrivacyRule> callPrivacyRules;
    private int completedRequestsCount;
    public ArrayList<TLRPC$TL_contact> contacts;
    public HashMap<String, Contact> contactsBook;
    private boolean contactsBookLoaded;
    public HashMap<String, Contact> contactsBookSPhones;
    public HashMap<String, TLRPC$TL_contact> contactsByPhone;
    public HashMap<String, TLRPC$TL_contact> contactsByShortPhone;
    public ConcurrentHashMap<Long, TLRPC$TL_contact> contactsDict;
    public boolean contactsLoaded;
    private boolean contactsSyncInProgress;
    private ArrayList<Long> delayedContactsUpdate;
    private int deleteAccountTTL;
    public boolean doneLoadingContacts;
    private ArrayList<TLRPC$PrivacyRule> forwardsPrivacyRules;
    private TLRPC$TL_globalPrivacySettings globalPrivacySettings;
    private ArrayList<TLRPC$PrivacyRule> groupPrivacyRules;
    private boolean ignoreChanges;
    private String inviteLink;
    private String lastContactsVersions;
    private ArrayList<TLRPC$PrivacyRule> lastseenPrivacyRules;
    private final Object loadContactsSync;
    private boolean loadingContacts;
    private int loadingDeleteInfo;
    private int loadingGlobalSettings;
    private int[] loadingPrivacyInfo;
    private boolean migratingContacts;
    private final Object observerLock;
    private ArrayList<TLRPC$PrivacyRule> p2pPrivacyRules;
    public ArrayList<Contact> phoneBookContacts;
    public ArrayList<String> phoneBookSectionsArray;
    public HashMap<String, ArrayList<Object>> phoneBookSectionsDict;
    private ArrayList<TLRPC$PrivacyRule> phonePrivacyRules;
    private ArrayList<TLRPC$PrivacyRule> profilePhotoPrivacyRules;
    private String[] projectionNames;
    private String[] projectionPhones;
    private HashMap<String, String> sectionsToReplace;
    public ArrayList<String> sortedUsersMutualSectionsArray;
    public ArrayList<String> sortedUsersSectionsArray;
    private Account systemAccount;
    private boolean updatingInviteLink;
    public HashMap<String, ArrayList<TLRPC$TL_contact>> usersMutualSectionsDict;
    public HashMap<String, ArrayList<TLRPC$TL_contact>> usersSectionsDict;

    static /* synthetic */ void lambda$resetImportedContacts$9(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MyContentObserver extends ContentObserver {
        private Runnable checkRunnable;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        static /* synthetic */ void lambda$new$0() {
            for (int i = 0; i < 3; i++) {
                if (UserConfig.getInstance(i).isClientActivated()) {
                    ConnectionsManager.getInstance(i).resumeNetworkMaybe();
                    ContactsController.getInstance(i).checkContacts();
                }
            }
        }

        public MyContentObserver() {
            super(null);
            this.checkRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$MyContentObserver$2-dP6rQcs0L1w6S-gK4bwjtDwVY
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsController.MyContentObserver.lambda$new$0();
                }
            };
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) throws InterruptedException {
            super.onChange(selfChange);
            synchronized (ContactsController.this.observerLock) {
                if (ContactsController.this.ignoreChanges) {
                    return;
                }
                Utilities.globalQueue.cancelRunnable(this.checkRunnable);
                Utilities.globalQueue.postRunnable(this.checkRunnable, 500L);
            }
        }
    }

    public static class Contact {
        public int contact_id;
        public String first_name;
        public int imported;
        public boolean isGoodProvider;
        public String key;
        public String last_name;
        public boolean namesFilled;
        public String provider;
        public TLRPC$User user;
        public ArrayList<String> phones = new ArrayList<>(4);
        public ArrayList<String> phoneTypes = new ArrayList<>(4);
        public ArrayList<String> shortPhones = new ArrayList<>(4);
        public ArrayList<Integer> phoneDeleted = new ArrayList<>(4);

        public String getLetter() {
            return getLetter(this.first_name, this.last_name);
        }

        public static String getLetter(String first_name, String last_name) {
            if (TextUtils.isEmpty(first_name)) {
                return !TextUtils.isEmpty(last_name) ? last_name.substring(0, 1) : "#";
            }
            return first_name.substring(0, 1);
        }
    }

    public static ContactsController getInstance(int num) {
        ContactsController contactsController = Instance[num];
        if (contactsController == null) {
            synchronized (ContactsController.class) {
                contactsController = Instance[num];
                if (contactsController == null) {
                    ContactsController[] contactsControllerArr = Instance;
                    ContactsController contactsController2 = new ContactsController(num);
                    contactsControllerArr[num] = contactsController2;
                    contactsController = contactsController2;
                }
            }
        }
        return contactsController;
    }

    public ContactsController(int instance) {
        super(instance);
        this.loadContactsSync = new Object();
        this.observerLock = new Object();
        this.lastContactsVersions = "";
        this.delayedContactsUpdate = new ArrayList<>();
        this.sectionsToReplace = new HashMap<>();
        this.loadingPrivacyInfo = new int[8];
        this.projectionPhones = new String[]{"lookup", "data1", "data2", "data3", "display_name", "account_type"};
        this.projectionNames = new String[]{"lookup", "data2", "data3", "data5"};
        this.contactsBook = new HashMap<>();
        this.contactsBookSPhones = new HashMap<>();
        this.phoneBookContacts = new ArrayList<>();
        this.phoneBookSectionsDict = new HashMap<>();
        this.phoneBookSectionsArray = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.contactsDict = new ConcurrentHashMap<>(20, 1.0f, 2);
        this.usersSectionsDict = new HashMap<>();
        this.sortedUsersSectionsArray = new ArrayList<>();
        this.usersMutualSectionsDict = new HashMap<>();
        this.sortedUsersMutualSectionsArray = new ArrayList<>();
        this.contactsByPhone = new HashMap<>();
        this.contactsByShortPhone = new HashMap<>();
        if (MessagesController.getMainSettings(this.currentAccount).getBoolean("needGetStatuses", false)) {
            reloadContactsStatuses();
        }
        this.sectionsToReplace.put("À", "A");
        this.sectionsToReplace.put("Á", "A");
        this.sectionsToReplace.put("Ä", "A");
        this.sectionsToReplace.put("Ù", "U");
        this.sectionsToReplace.put("Ú", "U");
        this.sectionsToReplace.put("Ü", "U");
        this.sectionsToReplace.put("Ì", "I");
        this.sectionsToReplace.put("Í", "I");
        this.sectionsToReplace.put("Ï", "I");
        this.sectionsToReplace.put("È", "E");
        this.sectionsToReplace.put("É", "E");
        this.sectionsToReplace.put("Ê", "E");
        this.sectionsToReplace.put("Ë", "E");
        this.sectionsToReplace.put("Ò", "O");
        this.sectionsToReplace.put("Ó", "O");
        this.sectionsToReplace.put("Ö", "O");
        this.sectionsToReplace.put("Ç", "C");
        this.sectionsToReplace.put("Ñ", "N");
        this.sectionsToReplace.put("Ÿ", "Y");
        this.sectionsToReplace.put("Ý", "Y");
        this.sectionsToReplace.put("Ţ", "Y");
        if (instance == 0) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$VpYSLmInWxf_q6wCnVx-RfW9UAw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$ContactsController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ContactsController() {
        try {
            if (hasContactsPermission()) {
                ApplicationLoader.applicationContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new MyContentObserver());
            }
        } catch (Throwable unused) {
        }
    }

    public void cleanup() {
        this.contactsBook.clear();
        this.contactsBookSPhones.clear();
        this.phoneBookContacts.clear();
        this.contacts.clear();
        this.contactsDict.clear();
        this.usersSectionsDict.clear();
        this.usersMutualSectionsDict.clear();
        this.sortedUsersSectionsArray.clear();
        this.sortedUsersMutualSectionsArray.clear();
        this.delayedContactsUpdate.clear();
        this.contactsByPhone.clear();
        this.contactsByShortPhone.clear();
        this.phoneBookSectionsDict.clear();
        this.phoneBookSectionsArray.clear();
        this.loadingContacts = false;
        this.contactsSyncInProgress = false;
        this.doneLoadingContacts = false;
        this.contactsLoaded = false;
        this.contactsBookLoaded = false;
        this.lastContactsVersions = "";
        this.loadingGlobalSettings = 0;
        this.loadingDeleteInfo = 0;
        this.deleteAccountTTL = 0;
        Arrays.fill(this.loadingPrivacyInfo, 0);
        this.lastseenPrivacyRules = null;
        this.groupPrivacyRules = null;
        this.callPrivacyRules = null;
        this.p2pPrivacyRules = null;
        this.profilePhotoPrivacyRules = null;
        this.forwardsPrivacyRules = null;
        this.phonePrivacyRules = null;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$OJ9_hPOHrAU7salkV9N8qzxcxWE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$1$ContactsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanup$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$1$ContactsController() {
        this.migratingContacts = false;
        this.completedRequestsCount = 0;
    }

    public void checkInviteText() {
        SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
        this.inviteLink = mainSettings.getString("invitelink", null);
        int i = mainSettings.getInt("invitelinktime", 0);
        if (this.updatingInviteLink) {
            return;
        }
        if (this.inviteLink == null || Math.abs((System.currentTimeMillis() / 1000) - i) >= 86400) {
            this.updatingInviteLink = true;
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_getInviteText
                public static int constructor = 1295590211;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_help_inviteText.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$OYql50Oiu6sM2ppdvL52koELdZE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$checkInviteText$3$ContactsController(tLObject, tLRPC$TL_error);
                }
            }, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkInviteText$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkInviteText$3$ContactsController(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_help_inviteText tLRPC$TL_help_inviteText = (TLRPC$TL_help_inviteText) tLObject;
            if (tLRPC$TL_help_inviteText.message.length() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$dgmGeB63GKrep8ZAPpBKBBnbYaY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkInviteText$2$ContactsController(tLRPC$TL_help_inviteText);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkInviteText$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkInviteText$2$ContactsController(TLRPC$TL_help_inviteText tLRPC$TL_help_inviteText) {
        this.updatingInviteLink = false;
        SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        String str = tLRPC$TL_help_inviteText.message;
        this.inviteLink = str;
        editorEdit.putString("invitelink", str);
        editorEdit.putInt("invitelinktime", (int) (System.currentTimeMillis() / 1000));
        editorEdit.commit();
    }

    public String getInviteText(int contacts) {
        String str = this.inviteLink;
        return str != null ? str : LocaleController.getString("InviteText", R.string.InviteText);
    }

    public void checkAppAccount() {
        boolean z;
        AccountManager accountManager = AccountManager.get(ApplicationLoader.applicationContext);
        try {
            Account[] accountsByType = accountManager.getAccountsByType(BuildConfig.APPLICATION_ID);
            this.systemAccount = null;
            for (int i = 0; i < accountsByType.length; i++) {
                Account account = accountsByType[i];
                int i2 = 0;
                while (true) {
                    if (i2 >= 3) {
                        z = false;
                        break;
                    }
                    TLRPC$User currentUser = UserConfig.getInstance(i2).getCurrentUser();
                    if (currentUser != null) {
                        if (account.name.equals("" + currentUser.id)) {
                            if (i2 == this.currentAccount) {
                                this.systemAccount = account;
                            }
                            z = true;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    try {
                        accountManager.removeAccount(accountsByType[i], null, null);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        if (getUserConfig().isClientActivated()) {
            readContacts();
            if (this.systemAccount == null) {
                try {
                    Account account2 = new Account("" + getUserConfig().getClientUserId(), BuildConfig.APPLICATION_ID);
                    this.systemAccount = account2;
                    accountManager.addAccountExplicitly(account2, "", null);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public void deleteUnknownAppAccounts() {
        boolean z;
        try {
            this.systemAccount = null;
            AccountManager accountManager = AccountManager.get(ApplicationLoader.applicationContext);
            Account[] accountsByType = accountManager.getAccountsByType(BuildConfig.APPLICATION_ID);
            for (int i = 0; i < accountsByType.length; i++) {
                Account account = accountsByType[i];
                int i2 = 0;
                while (true) {
                    if (i2 >= 3) {
                        z = false;
                        break;
                    }
                    TLRPC$User currentUser = UserConfig.getInstance(i2).getCurrentUser();
                    if (currentUser != null) {
                        if (account.name.equals("" + currentUser.id)) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    try {
                        accountManager.removeAccount(accountsByType[i], null, null);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkContacts() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$J4TP8FSh0DHgYBbqXY-z370WVD4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkContacts$4$ContactsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkContacts$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkContacts$4$ContactsController() {
        if (checkContactsInternal()) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("detected contacts change");
            }
            performSyncPhoneBook(getContactsCopy(this.contactsBook), true, false, true, false, true, false);
        }
    }

    public void forceImportContacts() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$MhwVCa_Pt3EkA9QaB19HTyXLpzc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceImportContacts$5$ContactsController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$forceImportContacts$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$forceImportContacts$5$ContactsController() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("force import contacts");
        }
        performSyncPhoneBook(new HashMap<>(), true, true, true, true, false, false);
    }

    public void syncPhoneBookByAlert(final HashMap<String, Contact> contacts, final boolean first, final boolean schedule, final boolean cancel) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$evzOgkO6OMorJFSPDf_Vp_ReBso
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$syncPhoneBookByAlert$6$ContactsController(contacts, first, schedule, cancel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$syncPhoneBookByAlert$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$syncPhoneBookByAlert$6$ContactsController(HashMap map, boolean z, boolean z2, boolean z3) {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("sync contacts by alert");
        }
        performSyncPhoneBook(map, true, z, z2, false, false, z3);
    }

    public void deleteAllContacts(final Runnable runnable) {
        resetImportedContacts();
        TLRPC$TL_contacts_deleteContacts tLRPC$TL_contacts_deleteContacts = new TLRPC$TL_contacts_deleteContacts();
        int size = this.contacts.size();
        for (int i = 0; i < size; i++) {
            tLRPC$TL_contacts_deleteContacts.id.add(getMessagesController().getInputUser(this.contacts.get(i).user_id));
        }
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_deleteContacts, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$7XvKBqnrs9Tk4xPVaz_gJnAONkI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteAllContacts$8$ContactsController(runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteAllContacts$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteAllContacts$8$ContactsController(final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.contactsBookSPhones.clear();
            this.contactsBook.clear();
            this.completedRequestsCount = 0;
            this.migratingContacts = false;
            this.contactsSyncInProgress = false;
            this.contactsLoaded = false;
            this.loadingContacts = false;
            this.contactsBookLoaded = false;
            this.lastContactsVersions = "";
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$PcarLqyd80QABGtSTzI-agpdEEI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteAllContacts$7$ContactsController(runnable);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteAllContacts$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteAllContacts$7$ContactsController(Runnable runnable) {
        AccountManager accountManager = AccountManager.get(ApplicationLoader.applicationContext);
        try {
            Account[] accountsByType = accountManager.getAccountsByType(BuildConfig.APPLICATION_ID);
            this.systemAccount = null;
            for (Account account : accountsByType) {
                int i = 0;
                while (true) {
                    if (i >= 3) {
                        break;
                    }
                    TLRPC$User currentUser = UserConfig.getInstance(i).getCurrentUser();
                    if (currentUser != null) {
                        if (account.name.equals("" + currentUser.id)) {
                            accountManager.removeAccount(account, null, null);
                            break;
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Account account2 = new Account("" + getUserConfig().getClientUserId(), BuildConfig.APPLICATION_ID);
            this.systemAccount = account2;
            accountManager.addAccountExplicitly(account2, "", null);
        } catch (Exception unused2) {
        }
        getMessagesStorage().putCachedPhoneBook(new HashMap<>(), false, true);
        getMessagesStorage().putContacts(new ArrayList<>(), true);
        this.phoneBookContacts.clear();
        this.contacts.clear();
        this.contactsDict.clear();
        this.usersSectionsDict.clear();
        this.usersMutualSectionsDict.clear();
        this.sortedUsersSectionsArray.clear();
        this.phoneBookSectionsDict.clear();
        this.phoneBookSectionsArray.clear();
        this.delayedContactsUpdate.clear();
        this.sortedUsersMutualSectionsArray.clear();
        this.contactsByPhone.clear();
        this.contactsByShortPhone.clear();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        loadContacts(false, 0L);
        runnable.run();
    }

    public void resetImportedContacts() {
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_resetSaved
            public static int constructor = -2020263951;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$V4_efuMnAC8HxEYzvCxcv6vzc34
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                ContactsController.lambda$resetImportedContacts$9(tLObject, tLRPC$TL_error);
            }
        });
    }

    private boolean checkContactsInternal() {
        boolean z = false;
        try {
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (!hasContactsPermission()) {
            return false;
        }
        try {
            Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"version"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (cursorQuery.moveToNext()) {
                        sb.append(cursorQuery.getString(cursorQuery.getColumnIndex("version")));
                    }
                    String string = sb.toString();
                    if (this.lastContactsVersions.length() != 0 && !this.lastContactsVersions.equals(string)) {
                        z = true;
                    }
                    this.lastContactsVersions = string;
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (cursorQuery != null) {
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return z;
    }

    public void readContacts() {
        synchronized (this.loadContactsSync) {
            if (this.loadingContacts) {
                return;
            }
            this.loadingContacts = true;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$PSAs1Pf1zsM8MC2elaODtCK9wOE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$readContacts$10$ContactsController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$readContacts$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$readContacts$10$ContactsController() {
        if (!this.contacts.isEmpty() || this.contactsLoaded) {
            synchronized (this.loadContactsSync) {
                this.loadingContacts = false;
            }
            return;
        }
        loadContacts(true, 0L);
    }

    private boolean isNotValidNameString(String src) {
        if (TextUtils.isEmpty(src)) {
            return true;
        }
        int length = src.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = src.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i++;
            }
        }
        return i > 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x032e A[Catch: all -> 0x0346, TRY_LEAVE, TryCatch #4 {all -> 0x0346, blocks: (B:178:0x0329, B:180:0x032e), top: B:211:0x0329 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0333 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.HashMap<java.lang.String, ir.eitaa.messenger.ContactsController.Contact> readContactsFromPhoneBook() {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ContactsController.readContactsFromPhoneBook():java.util.HashMap");
    }

    public HashMap<String, Contact> getContactsCopy(HashMap<String, Contact> original) {
        HashMap<String, Contact> map = new HashMap<>();
        for (Map.Entry<String, Contact> entry : original.entrySet()) {
            Contact contact = new Contact();
            Contact value = entry.getValue();
            contact.phoneDeleted.addAll(value.phoneDeleted);
            contact.phones.addAll(value.phones);
            contact.phoneTypes.addAll(value.phoneTypes);
            contact.shortPhones.addAll(value.shortPhones);
            contact.first_name = value.first_name;
            contact.last_name = value.last_name;
            contact.contact_id = value.contact_id;
            String str = value.key;
            contact.key = str;
            map.put(str, contact);
        }
        return map;
    }

    protected void migratePhoneBookToV7(final SparseArray<Contact> contactHashMap) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$RqioO8TnUi24P1OGWHJWjS6hziw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$migratePhoneBookToV7$11$ContactsController(contactHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$migratePhoneBookToV7$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$migratePhoneBookToV7$11$ContactsController(SparseArray sparseArray) {
        if (this.migratingContacts) {
            return;
        }
        this.migratingContacts = true;
        HashMap<String, Contact> map = new HashMap<>();
        HashMap<String, Contact> contactsFromPhoneBook = readContactsFromPhoneBook();
        HashMap map2 = new HashMap();
        Iterator<Map.Entry<String, Contact>> it = contactsFromPhoneBook.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Contact value = it.next().getValue();
            for (int i = 0; i < value.shortPhones.size(); i++) {
                map2.put(value.shortPhones.get(i), value.key);
            }
        }
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            Contact contact = (Contact) sparseArray.valueAt(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= contact.shortPhones.size()) {
                    break;
                }
                String str = (String) map2.get(contact.shortPhones.get(i3));
                if (str != null) {
                    contact.key = str;
                    map.put(str, contact);
                    break;
                }
                i3++;
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("migrated contacts " + map.size() + " of " + sparseArray.size());
        }
        getMessagesStorage().putCachedPhoneBook(map, true, false);
    }

    protected void performSyncPhoneBook(final HashMap<String, Contact> contactHashMap, final boolean request, final boolean first, final boolean schedule, final boolean force, final boolean checkCount, final boolean canceled) {
        if (first || this.contactsBookLoaded) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$u4c9085YyuNR6xnC1jLcWLzPJ6o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSyncPhoneBook$24$ContactsController(contactHashMap, schedule, request, first, force, checkCount, canceled);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0347 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cd A[PHI: r16
      0x01cd: PHI (r16v22 int) = (r16v14 int), (r16v24 int), (r16v24 int), (r16v24 int) binds: [B:65:0x01a5, B:67:0x01af, B:69:0x01b7, B:73:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f0  */
    /* renamed from: lambda$performSyncPhoneBook$24, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSyncPhoneBook$24$ContactsController(final java.util.HashMap r29, final boolean r30, boolean r31, final boolean r32, boolean r33, boolean r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 1556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ContactsController.lambda$performSyncPhoneBook$24$ContactsController(java.util.HashMap, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$13$ContactsController(int i, HashMap map, boolean z, boolean z2) {
        getNotificationCenter().postNotificationName(NotificationCenter.hasNewContactsToImport, Integer.valueOf(i), map, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$15$ContactsController(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
        this.contactsBookSPhones = map;
        this.contactsBook = map2;
        this.contactsSyncInProgress = false;
        this.contactsBookLoaded = true;
        if (z) {
            this.contactsLoaded = true;
        }
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        getMessagesStorage().putCachedPhoneBook(map2, false, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$2A7q-cXr1ijwLKvGMn7UHoYsGPE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$14$ContactsController(map3, arrayList, map4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$14$ContactsController(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$22(map, arrayList, map2);
        updateUnregisteredContacts();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$19$ContactsController(HashMap map, SparseArray sparseArray, final boolean[] zArr, final HashMap map2, TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts, int i, final HashMap map3, final boolean z, final HashMap map4, final ArrayList arrayList, final HashMap map5, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.completedRequestsCount++;
        if (tLRPC$TL_error == null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("contacts imported");
            }
            TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts = (TLRPC$TL_contacts_importedContacts) tLObject;
            if (!tLRPC$TL_contacts_importedContacts.retry_contacts.isEmpty()) {
                for (int i2 = 0; i2 < tLRPC$TL_contacts_importedContacts.retry_contacts.size(); i2++) {
                    map.remove(sparseArray.get((int) tLRPC$TL_contacts_importedContacts.retry_contacts.get(i2).longValue()));
                }
                zArr[0] = true;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("result has retry contacts");
                }
            }
            for (int i3 = 0; i3 < tLRPC$TL_contacts_importedContacts.popular_invites.size(); i3++) {
                TLRPC$TL_popularContact tLRPC$TL_popularContact = tLRPC$TL_contacts_importedContacts.popular_invites.get(i3);
                Contact contact = (Contact) map2.get(sparseArray.get((int) tLRPC$TL_popularContact.client_id));
                if (contact != null) {
                    contact.imported = tLRPC$TL_popularContact.importers;
                }
            }
            getMessagesStorage().putUsersAndChats(tLRPC$TL_contacts_importedContacts.users, null, true, true);
            ArrayList<TLRPC$TL_contact> arrayList2 = new ArrayList<>();
            for (int i4 = 0; i4 < tLRPC$TL_contacts_importedContacts.imported.size(); i4++) {
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = tLRPC$TL_contacts_importedContacts.imported.get(i4).user_id;
                arrayList2.add(tLRPC$TL_contact);
            }
            processLoadedContacts(arrayList2, tLRPC$TL_contacts_importedContacts.users, 2);
        } else {
            for (int i5 = 0; i5 < tLRPC$TL_contacts_importContacts.contacts.size(); i5++) {
                map.remove(sparseArray.get((int) tLRPC$TL_contacts_importContacts.contacts.get(i5).client_id));
            }
            zArr[0] = true;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("import contacts error " + tLRPC$TL_error.text);
            }
        }
        if (this.completedRequestsCount == i) {
            if (!map.isEmpty()) {
                getMessagesStorage().putCachedPhoneBook(map, false, false);
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$T7xDMg812-kSMd0mMZEaUuJORgY
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$performSyncPhoneBook$18$ContactsController(map3, map2, z, map4, arrayList, map5, zArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$18$ContactsController(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4, boolean[] zArr) throws InterruptedException {
        this.contactsBookSPhones = map;
        this.contactsBook = map2;
        this.contactsSyncInProgress = false;
        this.contactsBookLoaded = true;
        if (z) {
            this.contactsLoaded = true;
        }
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$TBf-GHSFyruSa4N-oEigqXG_wSA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$16$ContactsController(map3, arrayList, map4);
            }
        });
        if (zArr[0]) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$pu4eWhNOU82uMeg90LkX_C5iY8U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSyncPhoneBook$17$ContactsController();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$16$ContactsController(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$22(map, arrayList, map2);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$17$ContactsController() {
        getMessagesStorage().getCachedPhoneBook(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$21$ContactsController(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
        this.contactsBookSPhones = map;
        this.contactsBook = map2;
        this.contactsSyncInProgress = false;
        this.contactsBookLoaded = true;
        if (z) {
            this.contactsLoaded = true;
        }
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$TbnnkTBcyTLAGM-Ww_7FlhVIntY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$20$ContactsController(map3, arrayList, map4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$20$ContactsController(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$22(map, arrayList, map2);
        updateUnregisteredContacts();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSyncPhoneBook$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSyncPhoneBook$23$ContactsController(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
        this.contactsBookSPhones = map;
        this.contactsBook = map2;
        this.contactsSyncInProgress = false;
        this.contactsBookLoaded = true;
        if (z) {
            this.contactsLoaded = true;
        }
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$h9LZivl0oIWua6c0mGOAuMWVTfU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$22$ContactsController(map3, arrayList, map4);
            }
        });
    }

    public boolean isLoadingContacts() {
        boolean z;
        synchronized (this.loadContactsSync) {
            z = this.loadingContacts;
        }
        return z;
    }

    private long getContactsHash(ArrayList<TLRPC$TL_contact> contacts) {
        ArrayList arrayList = new ArrayList(contacts);
        Collections.sort(arrayList, $$Lambda$ContactsController$VL4qKg0CMqdTUaz47lLQJLHC8c.INSTANCE);
        int size = arrayList.size();
        long jCalcHash = 0;
        for (int i = -1; i < size; i++) {
            if (i == -1) {
                jCalcHash = MediaDataController.calcHash(jCalcHash, getUserConfig().contactsSavedCount);
            } else {
                jCalcHash = MediaDataController.calcHash(jCalcHash, ((TLRPC$TL_contact) arrayList.get(i)).user_id);
            }
        }
        return jCalcHash;
    }

    static /* synthetic */ int lambda$getContactsHash$25(TLRPC$TL_contact tLRPC$TL_contact, TLRPC$TL_contact tLRPC$TL_contact2) {
        long j = tLRPC$TL_contact.user_id;
        long j2 = tLRPC$TL_contact2.user_id;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public void loadContacts(boolean fromCache, final long hash) {
        synchronized (this.loadContactsSync) {
            this.loadingContacts = true;
        }
        if (fromCache) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("load contacts from cache");
            }
            getMessagesStorage().getContacts();
        } else {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("load contacts from server");
            }
            TLRPC$TL_contacts_getContacts tLRPC$TL_contacts_getContacts = new TLRPC$TL_contacts_getContacts();
            tLRPC$TL_contacts_getContacts.hash = hash;
            getConnectionsManager().sendRequest(tLRPC$TL_contacts_getContacts, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$kBJvP5AuckSGwUofTDZAzr7a3bM
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadContacts$27$ContactsController(hash, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadContacts$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadContacts$27$ContactsController(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$contacts_Contacts tLRPC$contacts_Contacts = (TLRPC$contacts_Contacts) tLObject;
            if (j != 0 && (tLRPC$contacts_Contacts instanceof TLRPC$TL_contacts_contactsNotModified)) {
                this.contactsLoaded = true;
                if (!this.delayedContactsUpdate.isEmpty() && this.contactsBookLoaded) {
                    applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
                    this.delayedContactsUpdate.clear();
                }
                getUserConfig().lastContactsSyncTime = (int) (System.currentTimeMillis() / 1000);
                getUserConfig().saveConfig(false);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$n6TQrBhnpXdk1bPoStjgKW2rO3k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadContacts$26$ContactsController();
                    }
                });
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("load contacts don't change");
                    return;
                }
                return;
            }
            getUserConfig().contactsSavedCount = tLRPC$contacts_Contacts.saved_count;
            getUserConfig().saveConfig(false);
            processLoadedContacts(tLRPC$contacts_Contacts.contacts, tLRPC$contacts_Contacts.users, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadContacts$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadContacts$26$ContactsController() {
        synchronized (this.loadContactsSync) {
            this.loadingContacts = false;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    public void processLoadedContacts(final ArrayList<TLRPC$TL_contact> contactsArr, final ArrayList<TLRPC$User> usersArr, final int from) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$8vq9hOC152nDOW0ZmQsOcPc3ejA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$37$ContactsController(usersArr, from, contactsArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$37$ContactsController(final ArrayList arrayList, final int i, final ArrayList arrayList2) {
        getMessagesController().putUsers(arrayList, i == 1);
        final LongSparseArray longSparseArray = new LongSparseArray();
        final boolean zIsEmpty = arrayList2.isEmpty();
        if (i == 2 && !this.contacts.isEmpty()) {
            int i2 = 0;
            while (i2 < arrayList2.size()) {
                if (this.contactsDict.get(Long.valueOf(((TLRPC$TL_contact) arrayList2.get(i2)).user_id)) != null) {
                    arrayList2.remove(i2);
                    i2--;
                }
                i2++;
            }
            arrayList2.addAll(this.contacts);
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(((TLRPC$TL_contact) arrayList2.get(i3)).user_id));
            if (user != null) {
                longSparseArray.put(user.id, user);
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$h_1sGL7t_4EvkB9cxseSQFcArCU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$36$ContactsController(i, arrayList2, longSparseArray, arrayList, zIsEmpty);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$36$ContactsController(final int i, final ArrayList arrayList, LongSparseArray longSparseArray, ArrayList arrayList2, final boolean z) {
        final HashMap map;
        final HashMap map2;
        int i2;
        ArrayList arrayList3 = arrayList;
        LongSparseArray longSparseArray2 = longSparseArray;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("done loading contacts");
        }
        if (i == 1 && (arrayList.isEmpty() || Math.abs((System.currentTimeMillis() / 1000) - getUserConfig().lastContactsSyncTime) >= 86400)) {
            loadContacts(false, getContactsHash(arrayList3));
            if (arrayList.isEmpty()) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$1fO4LXovQ1q_cv-moUGNni_C9zc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processLoadedContacts$28$ContactsController();
                    }
                });
                return;
            }
        }
        if (i == 0) {
            getUserConfig().lastContactsSyncTime = (int) (System.currentTimeMillis() / 1000);
            getUserConfig().saveConfig(false);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TLRPC$TL_contact tLRPC$TL_contact = arrayList3.get(i3);
            if (longSparseArray2.get(tLRPC$TL_contact.user_id) == null && tLRPC$TL_contact.user_id != getUserConfig().getClientUserId()) {
                loadContacts(false, 0L);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("contacts are broken, load from server");
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$Mp9YXdjOjmPcvjqF4y-qifsGTPs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processLoadedContacts$29$ContactsController();
                    }
                });
                return;
            }
        }
        if (i != 1) {
            getMessagesStorage().putUsersAndChats(arrayList2, null, true, true);
            getMessagesStorage().putContacts(arrayList3, i != 2);
        }
        Collections.sort(arrayList3, new $$Lambda$ContactsController$YOT_KzP6mVSw2rLytDPkEcvpbO4(longSparseArray2));
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(20, 1.0f, 2);
        final HashMap map3 = new HashMap();
        final HashMap map4 = new HashMap();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        if (this.contactsBookLoaded) {
            map = null;
            map2 = null;
        } else {
            HashMap map5 = new HashMap();
            map2 = new HashMap();
            map = map5;
        }
        int i4 = 0;
        while (i4 < arrayList.size()) {
            TLRPC$TL_contact tLRPC$TL_contact2 = arrayList3.get(i4);
            TLRPC$User tLRPC$User = (TLRPC$User) longSparseArray2.get(tLRPC$TL_contact2.user_id);
            if (tLRPC$User != null) {
                concurrentHashMap.put(Long.valueOf(tLRPC$TL_contact2.user_id), tLRPC$TL_contact2);
                if (map == null || TextUtils.isEmpty(tLRPC$User.phone)) {
                    i2 = 0;
                } else {
                    map.put(tLRPC$User.phone, tLRPC$TL_contact2);
                    i2 = 0;
                    map2.put(tLRPC$User.phone.substring(Math.max(0, r1.length() - 7)), tLRPC$TL_contact2);
                }
                String firstName = UserObject.getFirstName(tLRPC$User);
                if (firstName.length() > 1) {
                    firstName = firstName.substring(i2, 1);
                }
                String upperCase = firstName.length() == 0 ? "#" : firstName.toUpperCase();
                String str = this.sectionsToReplace.get(upperCase);
                if (str != null) {
                    upperCase = str;
                }
                ArrayList arrayList6 = (ArrayList) map3.get(upperCase);
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                    map3.put(upperCase, arrayList6);
                    arrayList4.add(upperCase);
                }
                arrayList6.add(tLRPC$TL_contact2);
                if (tLRPC$User.mutual_contact) {
                    ArrayList arrayList7 = (ArrayList) map4.get(upperCase);
                    if (arrayList7 == null) {
                        arrayList7 = new ArrayList();
                        map4.put(upperCase, arrayList7);
                        arrayList5.add(upperCase);
                    }
                    arrayList7.add(tLRPC$TL_contact2);
                }
            }
            i4++;
            arrayList3 = arrayList;
            longSparseArray2 = longSparseArray;
        }
        Collections.sort(arrayList4, $$Lambda$ContactsController$THFOxHAordnzy20F3RYGrFS8MZg.INSTANCE);
        Collections.sort(arrayList5, $$Lambda$ContactsController$g6TMaLtW9KMvU4CHKcKT3o08hGo.INSTANCE);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$zVG_iK9GJrm7afDHhH9ZFFo5XZU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$33$ContactsController(arrayList, concurrentHashMap, map3, map4, arrayList4, arrayList5, i, z);
            }
        });
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded && this.contactsBookLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        if (map != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$zeyXCS08W_GmNoSdS8JCYS4-yUw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedContacts$35$ContactsController(map, map2);
                }
            });
        } else {
            this.contactsLoaded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$28$ContactsController() {
        this.doneLoadingContacts = true;
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$29$ContactsController() {
        this.doneLoadingContacts = true;
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    static /* synthetic */ int lambda$processLoadedContacts$31(String str, String str2) {
        char cCharAt = str.charAt(0);
        char cCharAt2 = str2.charAt(0);
        if (cCharAt == '#') {
            return 1;
        }
        if (cCharAt2 == '#') {
            return -1;
        }
        return str.compareTo(str2);
    }

    static /* synthetic */ int lambda$processLoadedContacts$32(String str, String str2) {
        char cCharAt = str.charAt(0);
        char cCharAt2 = str2.charAt(0);
        if (cCharAt == '#') {
            return 1;
        }
        if (cCharAt2 == '#') {
            return -1;
        }
        return str.compareTo(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$33$ContactsController(ArrayList arrayList, ConcurrentHashMap concurrentHashMap, HashMap map, HashMap map2, ArrayList arrayList2, ArrayList arrayList3, int i, boolean z) {
        this.contacts = arrayList;
        this.contactsDict = concurrentHashMap;
        this.usersSectionsDict = map;
        this.usersMutualSectionsDict = map2;
        this.sortedUsersSectionsArray = arrayList2;
        this.sortedUsersMutualSectionsArray = arrayList3;
        this.doneLoadingContacts = true;
        if (i != 2) {
            synchronized (this.loadContactsSync) {
                this.loadingContacts = false;
            }
        }
        performWriteContactsToPhoneBook();
        updateUnregisteredContacts();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        if (i != 1 && !z) {
            saveContactsLoadTime();
        } else {
            reloadContactsStatusesMaybe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$35$ContactsController(final HashMap map, final HashMap map2) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$eEdVb7RjbmPJPHbuwyvfrTqAQ6w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$34$ContactsController(map, map2);
            }
        });
        if (this.contactsSyncInProgress) {
            return;
        }
        this.contactsSyncInProgress = true;
        getMessagesStorage().getCachedPhoneBook(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processLoadedContacts$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processLoadedContacts$34$ContactsController(HashMap map, HashMap map2) {
        this.contactsByPhone = map;
        this.contactsByShortPhone = map2;
    }

    public boolean isContact(long userId) {
        return this.contactsDict.get(Long.valueOf(userId)) != null;
    }

    public void reloadContactsStatusesMaybe() {
        try {
            if (MessagesController.getMainSettings(this.currentAccount).getLong("lastReloadStatusTime", 0L) < System.currentTimeMillis() - 10800000) {
                reloadContactsStatuses();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void saveContactsLoadTime() {
        try {
            MessagesController.getMainSettings(this.currentAccount).edit().putLong("lastReloadStatusTime", System.currentTimeMillis()).commit();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: mergePhonebookAndEitaaContacts, reason: merged with bridge method [inline-methods] */
    public void lambda$performSyncPhoneBook$22$ContactsController(final HashMap<String, ArrayList<Object>> phoneBookSectionsDictFinal, final ArrayList<String> phoneBookSectionsArrayFinal, final HashMap<String, Contact> phoneBookByShortPhonesFinal) {
        final ArrayList arrayList = new ArrayList(this.contacts);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$EtzSRMm12dhYw-ZtsiYgLYFHtS4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mergePhonebookAndEitaaContacts$41$ContactsController(arrayList, phoneBookByShortPhonesFinal, phoneBookSectionsDictFinal, phoneBookSectionsArrayFinal);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$mergePhonebookAndEitaaContacts$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$mergePhonebookAndEitaaContacts$41$ContactsController(ArrayList arrayList, HashMap map, final HashMap map2, final ArrayList arrayList2) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(((TLRPC$TL_contact) arrayList.get(i)).user_id));
            if (user != null && !TextUtils.isEmpty(user.phone)) {
                Contact contact = (Contact) map.get(user.phone.substring(Math.max(0, r4.length() - 7)));
                if (contact != null) {
                    if (contact.user == null) {
                        contact.user = user;
                    }
                } else {
                    String letter = Contact.getLetter(user.first_name, user.last_name);
                    ArrayList arrayList3 = (ArrayList) map2.get(letter);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        map2.put(letter, arrayList3);
                        arrayList2.add(letter);
                    }
                    arrayList3.add(user);
                }
            }
        }
        Iterator it = map2.values().iterator();
        while (it.hasNext()) {
            Collections.sort((ArrayList) it.next(), $$Lambda$ContactsController$v3zBzpmUuPHDBNEQrzv9h89wzw.INSTANCE);
        }
        Collections.sort(arrayList2, $$Lambda$ContactsController$eDdtLeZSeyrgOLeLKZiWQe4QqQ.INSTANCE);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$LW0aVIF-jMbnJaBqPCvmn7fNG00
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mergePhonebookAndEitaaContacts$40$ContactsController(arrayList2, map2);
            }
        });
    }

    static /* synthetic */ int lambda$mergePhonebookAndEitaaContacts$38(Object obj, Object obj2) {
        String name;
        String name2;
        String name3 = "";
        if (obj instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) obj;
            name = formatName(tLRPC$User.first_name, tLRPC$User.last_name);
        } else if (obj instanceof Contact) {
            Contact contact = (Contact) obj;
            TLRPC$User tLRPC$User2 = contact.user;
            if (tLRPC$User2 != null) {
                name = formatName(tLRPC$User2.first_name, tLRPC$User2.last_name);
            } else {
                name = formatName(contact.first_name, contact.last_name);
            }
        } else {
            name = "";
        }
        if (obj2 instanceof TLRPC$User) {
            TLRPC$User tLRPC$User3 = (TLRPC$User) obj2;
            name3 = formatName(tLRPC$User3.first_name, tLRPC$User3.last_name);
        } else if (obj2 instanceof Contact) {
            Contact contact2 = (Contact) obj2;
            TLRPC$User tLRPC$User4 = contact2.user;
            if (tLRPC$User4 != null) {
                name2 = formatName(tLRPC$User4.first_name, tLRPC$User4.last_name);
            } else {
                name2 = formatName(contact2.first_name, contact2.last_name);
            }
            name3 = name2;
        }
        return name.compareTo(name3);
    }

    static /* synthetic */ int lambda$mergePhonebookAndEitaaContacts$39(String str, String str2) {
        char cCharAt = str.charAt(0);
        char cCharAt2 = str2.charAt(0);
        if (cCharAt == '#') {
            return 1;
        }
        if (cCharAt2 == '#') {
            return -1;
        }
        return str.compareTo(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$mergePhonebookAndEitaaContacts$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$mergePhonebookAndEitaaContacts$40$ContactsController(ArrayList arrayList, HashMap map) {
        this.phoneBookSectionsArray = arrayList;
        this.phoneBookSectionsDict = map;
    }

    private void updateUnregisteredContacts() {
        boolean z;
        HashMap map = new HashMap();
        int size = this.contacts.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_contact tLRPC$TL_contact = this.contacts.get(i);
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact.user_id));
            if (user != null && !TextUtils.isEmpty(user.phone)) {
                map.put(user.phone, tLRPC$TL_contact);
            }
        }
        ArrayList<Contact> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, Contact>> it = this.contactsBook.entrySet().iterator();
        while (it.hasNext()) {
            Contact value = it.next().getValue();
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= value.phones.size()) {
                    z = false;
                    break;
                } else if (map.containsKey(value.shortPhones.get(i2)) || value.phoneDeleted.get(i2).intValue() == 1) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                arrayList.add(value);
            }
        }
        Collections.sort(arrayList, $$Lambda$ContactsController$SEYBORI8AL3boW_BuBqhB4VqZUA.INSTANCE);
        this.phoneBookContacts = arrayList;
    }

    static /* synthetic */ int lambda$updateUnregisteredContacts$42(Contact contact, Contact contact2) {
        String str = contact.first_name;
        if (str.length() == 0) {
            str = contact.last_name;
        }
        String str2 = contact2.first_name;
        if (str2.length() == 0) {
            str2 = contact2.last_name;
        }
        return str.compareTo(str2);
    }

    private void buildContactsSectionsArrays(boolean sort) {
        if (sort) {
            Collections.sort(this.contacts, new $$Lambda$ContactsController$cAil0ElGGlY13TuKNKBZRWXTnTk(this));
        }
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < this.contacts.size(); i++) {
            TLRPC$TL_contact tLRPC$TL_contact = this.contacts.get(i);
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact.user_id));
            if (user != null) {
                String firstName = UserObject.getFirstName(user);
                if (firstName.length() > 1) {
                    firstName = firstName.substring(0, 1);
                }
                String upperCase = firstName.length() == 0 ? "#" : firstName.toUpperCase();
                String str = this.sectionsToReplace.get(upperCase);
                if (str != null) {
                    upperCase = str;
                }
                ArrayList<TLRPC$TL_contact> arrayList2 = map.get(upperCase);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    map.put(upperCase, arrayList2);
                    arrayList.add(upperCase);
                }
                arrayList2.add(tLRPC$TL_contact);
            }
        }
        Collections.sort(arrayList, $$Lambda$ContactsController$OEwASvgul6sXCjNkGZc9zlD6CQ.INSTANCE);
        this.usersSectionsDict = map;
        this.sortedUsersSectionsArray = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$buildContactsSectionsArrays$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$buildContactsSectionsArrays$43$ContactsController(TLRPC$TL_contact tLRPC$TL_contact, TLRPC$TL_contact tLRPC$TL_contact2) {
        return UserObject.getFirstName(getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact.user_id))).compareTo(UserObject.getFirstName(getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact2.user_id))));
    }

    static /* synthetic */ int lambda$buildContactsSectionsArrays$44(String str, String str2) {
        char cCharAt = str.charAt(0);
        char cCharAt2 = str2.charAt(0);
        if (cCharAt == '#') {
            return 1;
        }
        if (cCharAt2 == '#') {
            return -1;
        }
        return str.compareTo(str2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x004a -> B:40:0x004d). Please report as a decompilation issue!!! */
    private boolean hasContactsPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            return ApplicationLoader.applicationContext.checkSelfPermission("android.permission.READ_CONTACTS") == 0;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, this.projectionPhones, null, null, null);
            } catch (Exception e) {
                FileLog.e(e);
            }
        } catch (Throwable th) {
            try {
                FileLog.e(th);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            }
        }
        if (cursorQuery != null) {
            if (cursorQuery.getCount() != 0) {
                cursorQuery.close();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performWriteContactsToPhoneBookInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$performWriteContactsToPhoneBook$45$ContactsController(ArrayList<TLRPC$TL_contact> contactsArray) throws Throwable {
        Cursor cursor = null;
        try {
            try {
            } catch (Exception e) {
                e = e;
            }
            if (hasContactsPermission()) {
                SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
                boolean z = !mainSettings.getBoolean("contacts_updated_v7", false);
                if (z) {
                    mainSettings.edit().putBoolean("contacts_updated_v7", true).commit();
                }
                Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.systemAccount.name).appendQueryParameter("account_type", this.systemAccount.type).build(), new String[]{"_id", "sync2"}, null, null, null);
                try {
                    LongSparseArray longSparseArray = new LongSparseArray();
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            longSparseArray.put(cursorQuery.getLong(1), Long.valueOf(cursorQuery.getLong(0)));
                        }
                        cursorQuery.close();
                        for (int i = 0; i < contactsArray.size(); i++) {
                            TLRPC$TL_contact tLRPC$TL_contact = contactsArray.get(i);
                            if (z || longSparseArray.indexOfKey(tLRPC$TL_contact.user_id) < 0) {
                                addContactToPhoneBook(getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact.user_id)), z);
                            }
                        }
                    } else {
                        cursor = cursorQuery;
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = cursorQuery;
                    FileLog.e(e);
                    if (cursor == null) {
                        return;
                    }
                    cursor.close();
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void performWriteContactsToPhoneBook() {
        final ArrayList arrayList = new ArrayList(this.contacts);
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$CCAHTYgBKFwLryYmhU9Uruhm3KY
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$performWriteContactsToPhoneBook$45$ContactsController(arrayList);
            }
        });
    }

    private void applyContactsUpdates(ArrayList<Long> ids, ConcurrentHashMap<Long, TLRPC$User> userDict, final ArrayList<TLRPC$TL_contact> newC, final ArrayList<Long> contactsTD) {
        int iIndexOf;
        int iIndexOf2;
        if (newC == null || contactsTD == null) {
            newC = new ArrayList<>();
            contactsTD = new ArrayList<>();
            for (int i = 0; i < ids.size(); i++) {
                Long l = ids.get(i);
                if (l.longValue() > 0) {
                    TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                    tLRPC$TL_contact.user_id = l.longValue();
                    newC.add(tLRPC$TL_contact);
                } else if (l.longValue() < 0) {
                    contactsTD.add(Long.valueOf(-l.longValue()));
                }
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("process update - contacts add = " + newC.size() + " delete = " + contactsTD.size());
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= newC.size()) {
                break;
            }
            TLRPC$TL_contact tLRPC$TL_contact2 = newC.get(i2);
            TLRPC$User user = userDict != null ? (TLRPC$User) userDict.get(Long.valueOf(tLRPC$TL_contact2.user_id)) : null;
            if (user == null) {
                user = getMessagesController().getUser(Long.valueOf(tLRPC$TL_contact2.user_id));
            } else {
                getMessagesController().putUser(user, true);
            }
            if (user == null || TextUtils.isEmpty(user.phone)) {
                z = true;
            } else {
                Contact contact = this.contactsBookSPhones.get(user.phone);
                if (contact != null && (iIndexOf2 = contact.shortPhones.indexOf(user.phone)) != -1) {
                    contact.phoneDeleted.set(iIndexOf2, 0);
                }
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(user.phone);
            }
            i2++;
        }
        for (int i3 = 0; i3 < contactsTD.size(); i3++) {
            final Long l2 = contactsTD.get(i3);
            Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$xXDzKPgHf35NOthBvd6jwXIY9ck
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$46$ContactsController(l2);
                }
            });
            TLRPC$User user2 = userDict != null ? (TLRPC$User) userDict.get(l2) : null;
            if (user2 == null) {
                user2 = getMessagesController().getUser(l2);
            } else {
                getMessagesController().putUser(user2, true);
            }
            if (user2 == null) {
                z = true;
            } else if (!TextUtils.isEmpty(user2.phone)) {
                Contact contact2 = this.contactsBookSPhones.get(user2.phone);
                if (contact2 != null && (iIndexOf = contact2.shortPhones.indexOf(user2.phone)) != -1) {
                    contact2.phoneDeleted.set(iIndexOf, 1);
                }
                if (sb2.length() != 0) {
                    sb2.append(",");
                }
                sb2.append(user2.phone);
            }
        }
        if (sb.length() != 0 || sb2.length() != 0) {
            getMessagesStorage().applyPhoneBookUpdates(sb.toString(), sb2.toString());
        }
        if (z) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$3izFJNZInpk7tT5HIBsguLDdtWc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$47$ContactsController();
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$c86Yxo2pu5nqsjTprPqw4c3qy9I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$48$ContactsController(newC, contactsTD);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyContactsUpdates$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyContactsUpdates$46$ContactsController(Long l) {
        deleteContactFromPhoneBook(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyContactsUpdates$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyContactsUpdates$47$ContactsController() {
        loadContacts(false, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyContactsUpdates$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyContactsUpdates$48$ContactsController(ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$TL_contact tLRPC$TL_contact = (TLRPC$TL_contact) arrayList.get(i);
            if (this.contactsDict.get(Long.valueOf(tLRPC$TL_contact.user_id)) == null) {
                this.contacts.add(tLRPC$TL_contact);
                this.contactsDict.put(Long.valueOf(tLRPC$TL_contact.user_id), tLRPC$TL_contact);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            Long l = (Long) arrayList2.get(i2);
            TLRPC$TL_contact tLRPC$TL_contact2 = (TLRPC$TL_contact) this.contactsDict.get(l);
            if (tLRPC$TL_contact2 != null) {
                this.contacts.remove(tLRPC$TL_contact2);
                this.contactsDict.remove(l);
            }
        }
        if (!arrayList.isEmpty()) {
            updateUnregisteredContacts();
            performWriteContactsToPhoneBook();
        }
        performSyncPhoneBook(getContactsCopy(this.contactsBook), false, false, false, false, true, false);
        buildContactsSectionsArrays(!arrayList.isEmpty());
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    public void processContactsUpdates(ArrayList<Long> ids, ConcurrentHashMap<Long, TLRPC$User> userDict) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        Iterator<Long> it = ids.iterator();
        while (it.hasNext()) {
            Long next = it.next();
            if (next.longValue() > 0) {
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = next.longValue();
                arrayList.add(tLRPC$TL_contact);
                if (!this.delayedContactsUpdate.isEmpty() && (iIndexOf = this.delayedContactsUpdate.indexOf(Long.valueOf(-next.longValue()))) != -1) {
                    this.delayedContactsUpdate.remove(iIndexOf);
                }
            } else if (next.longValue() < 0) {
                arrayList2.add(Long.valueOf(-next.longValue()));
                if (!this.delayedContactsUpdate.isEmpty() && (iIndexOf2 = this.delayedContactsUpdate.indexOf(Long.valueOf(-next.longValue()))) != -1) {
                    this.delayedContactsUpdate.remove(iIndexOf2);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            getMessagesStorage().deleteContacts(arrayList2);
        }
        if (!arrayList.isEmpty()) {
            getMessagesStorage().putContacts(arrayList, false);
        }
        if (!this.contactsLoaded || !this.contactsBookLoaded) {
            this.delayedContactsUpdate.addAll(ids);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("delay update - contacts add = " + arrayList.size() + " delete = " + arrayList2.size());
                return;
            }
            return;
        }
        applyContactsUpdates(ids, userDict, arrayList, arrayList2);
    }

    public long addContactToPhoneBook(TLRPC$User user, boolean check) {
        String name;
        long j = -1;
        if (this.systemAccount == null || user == null || !hasContactsPermission()) {
            return -1L;
        }
        synchronized (this.observerLock) {
            this.ignoreChanges = true;
        }
        ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
        if (check) {
            try {
                contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.systemAccount.name).appendQueryParameter("account_type", this.systemAccount.type).build(), "sync2 = " + user.id, null);
            } catch (Exception unused) {
            }
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        builderNewInsert.withValue("account_name", this.systemAccount.name);
        builderNewInsert.withValue("account_type", this.systemAccount.type);
        builderNewInsert.withValue("sync1", TextUtils.isEmpty(user.phone) ? "" : user.phone);
        builderNewInsert.withValue("sync2", Long.valueOf(user.id));
        arrayList.add(builderNewInsert.build());
        ContentProviderOperation.Builder builderNewInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        builderNewInsert2.withValueBackReference("raw_contact_id", 0);
        builderNewInsert2.withValue("mimetype", "vnd.android.cursor.item/name");
        builderNewInsert2.withValue("data2", user.first_name);
        builderNewInsert2.withValue("data3", user.last_name);
        arrayList.add(builderNewInsert2.build());
        if (TextUtils.isEmpty(user.phone)) {
            name = formatName(user.first_name, user.last_name);
        } else {
            name = "+" + user.phone;
        }
        ContentProviderOperation.Builder builderNewInsert3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        builderNewInsert3.withValueBackReference("raw_contact_id", 0);
        builderNewInsert3.withValue("mimetype", "vnd.android.cursor.item/vnd.ir.eitaa.messenger.android.profile");
        builderNewInsert3.withValue("data1", Long.valueOf(user.id));
        builderNewInsert3.withValue("data2", "Eitaa Profile");
        builderNewInsert3.withValue("data3", LocaleController.formatString("ContactShortcutMessage", R.string.ContactShortcutMessage, name));
        builderNewInsert3.withValue("data4", Long.valueOf(user.id));
        arrayList.add(builderNewInsert3.build());
        ContentProviderOperation.Builder builderNewInsert4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        builderNewInsert4.withValueBackReference("raw_contact_id", 0);
        builderNewInsert4.withValue("mimetype", "vnd.android.cursor.item/vnd.ir.eitaa.messenger.android.call");
        builderNewInsert4.withValue("data1", Long.valueOf(user.id));
        builderNewInsert4.withValue("data2", "Eitaa Voice Call");
        builderNewInsert4.withValue("data3", LocaleController.formatString("ContactShortcutVoiceCall", R.string.ContactShortcutVoiceCall, name));
        builderNewInsert4.withValue("data4", Long.valueOf(user.id));
        arrayList.add(builderNewInsert4.build());
        ContentProviderOperation.Builder builderNewInsert5 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        builderNewInsert5.withValueBackReference("raw_contact_id", 0);
        builderNewInsert5.withValue("mimetype", "vnd.android.cursor.item/vnd.ir.eitaa.messenger.android.call.video");
        builderNewInsert5.withValue("data1", Long.valueOf(user.id));
        builderNewInsert5.withValue("data2", "Eitaa Video Call");
        builderNewInsert5.withValue("data3", LocaleController.formatString("ContactShortcutVideoCall", R.string.ContactShortcutVideoCall, name));
        builderNewInsert5.withValue("data4", Long.valueOf(user.id));
        arrayList.add(builderNewInsert5.build());
        try {
            ContentProviderResult[] contentProviderResultArrApplyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (contentProviderResultArrApplyBatch != null && contentProviderResultArrApplyBatch.length > 0 && contentProviderResultArrApplyBatch[0].uri != null) {
                j = Long.parseLong(contentProviderResultArrApplyBatch[0].uri.getLastPathSegment());
            }
        } catch (Exception unused2) {
        }
        synchronized (this.observerLock) {
            this.ignoreChanges = false;
        }
        return j;
    }

    private void deleteContactFromPhoneBook(long uid) {
        if (hasContactsPermission()) {
            synchronized (this.observerLock) {
                this.ignoreChanges = true;
            }
            try {
                ApplicationLoader.applicationContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.systemAccount.name).appendQueryParameter("account_type", this.systemAccount.type).build(), "sync2 = " + uid, null);
            } catch (Exception e) {
                FileLog.e(e);
            }
            synchronized (this.observerLock) {
                this.ignoreChanges = false;
            }
        }
    }

    protected void markAsContacted(final String contactId) {
        if (contactId == null) {
            return;
        }
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$Qn4gq3GFJk8SLJ6pQ0hW-KmBszw
            @Override // java.lang.Runnable
            public final void run() {
                ContactsController.lambda$markAsContacted$49(contactId);
            }
        });
    }

    static /* synthetic */ void lambda$markAsContacted$49(String str) {
        Uri uri = Uri.parse(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_time_contacted", Long.valueOf(System.currentTimeMillis()));
        ApplicationLoader.applicationContext.getContentResolver().update(uri, contentValues, null, null);
    }

    public void addContact(final TLRPC$User user, boolean exception) {
        if (user == null) {
            return;
        }
        TLRPC$TL_contacts_addContact tLRPC$TL_contacts_addContact = new TLRPC$TL_contacts_addContact();
        tLRPC$TL_contacts_addContact.id = getMessagesController().getInputUser(user);
        tLRPC$TL_contacts_addContact.first_name = user.first_name;
        tLRPC$TL_contacts_addContact.last_name = user.last_name;
        String str = user.phone;
        tLRPC$TL_contacts_addContact.phone = str;
        tLRPC$TL_contacts_addContact.add_phone_privacy_exception = exception;
        if (str == null) {
            tLRPC$TL_contacts_addContact.phone = "";
        } else if (str.length() > 0 && !tLRPC$TL_contacts_addContact.phone.startsWith("+")) {
            tLRPC$TL_contacts_addContact.phone = "+" + tLRPC$TL_contacts_addContact.phone;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_addContact, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$6Dg0e_aG8Pq-4no-aNK_rOqWgyY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addContact$52$ContactsController(user, tLObject, tLRPC$TL_error);
            }
        }, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addContact$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addContact$52$ContactsController(TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int iIndexOf;
        if (tLRPC$TL_error != null) {
            return;
        }
        final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        getMessagesController().processUpdates(tLRPC$Updates, false);
        for (int i = 0; i < tLRPC$Updates.users.size(); i++) {
            final TLRPC$User tLRPC$User2 = tLRPC$Updates.users.get(i);
            if (tLRPC$User2.id == tLRPC$User.id) {
                Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$DobNn3NCx9_KgG-Wko4S2akIcgQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$addContact$50$ContactsController(tLRPC$User2);
                    }
                });
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = tLRPC$User2.id;
                ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>();
                arrayList.add(tLRPC$TL_contact);
                getMessagesStorage().putContacts(arrayList, false);
                if (!TextUtils.isEmpty(tLRPC$User2.phone)) {
                    formatName(tLRPC$User2.first_name, tLRPC$User2.last_name);
                    getMessagesStorage().applyPhoneBookUpdates(tLRPC$User2.phone, "");
                    Contact contact = this.contactsBookSPhones.get(tLRPC$User2.phone);
                    if (contact != null && (iIndexOf = contact.shortPhones.indexOf(tLRPC$User2.phone)) != -1) {
                        contact.phoneDeleted.set(iIndexOf, 0);
                    }
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$ax3cBLAUDnqEkeJIt_EG3L0EKT8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addContact$51$ContactsController(tLRPC$Updates);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addContact$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addContact$50$ContactsController(TLRPC$User tLRPC$User) {
        addContactToPhoneBook(tLRPC$User, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addContact$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addContact$51$ContactsController(TLRPC$Updates tLRPC$Updates) {
        for (int i = 0; i < tLRPC$Updates.users.size(); i++) {
            TLRPC$User tLRPC$User = tLRPC$Updates.users.get(i);
            if (tLRPC$User.contact && this.contactsDict.get(Long.valueOf(tLRPC$User.id)) == null) {
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = tLRPC$User.id;
                this.contacts.add(tLRPC$TL_contact);
                this.contactsDict.put(Long.valueOf(tLRPC$TL_contact.user_id), tLRPC$TL_contact);
            }
        }
        buildContactsSectionsArrays(true);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    public void deleteContact(final ArrayList<TLRPC$User> users, final boolean showBulletin) {
        if (users == null || users.isEmpty()) {
            return;
        }
        TLRPC$TL_contacts_deleteContacts tLRPC$TL_contacts_deleteContacts = new TLRPC$TL_contacts_deleteContacts();
        final ArrayList arrayList = new ArrayList();
        int size = users.size();
        for (int i = 0; i < size; i++) {
            TLRPC$User tLRPC$User = users.get(i);
            TLRPC$InputUser inputUser = getMessagesController().getInputUser(tLRPC$User);
            if (inputUser != null) {
                tLRPC$User.contact = false;
                arrayList.add(Long.valueOf(tLRPC$User.id));
                tLRPC$TL_contacts_deleteContacts.id.add(inputUser);
            }
        }
        final String str = users.get(0).first_name;
        getConnectionsManager().sendRequest(tLRPC$TL_contacts_deleteContacts, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$qVN_3jAIz22DggE6JShcFM7gmAs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteContact$55$ContactsController(arrayList, users, showBulletin, str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteContact$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteContact$55$ContactsController(ArrayList arrayList, final ArrayList arrayList2, final boolean z, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int iIndexOf;
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        getMessagesStorage().deleteContacts(arrayList);
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$emBfQcM8YXW5UXhX-UwD3i5-t9U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContact$53$ContactsController(arrayList2);
            }
        });
        for (int i = 0; i < arrayList2.size(); i++) {
            TLRPC$User tLRPC$User = (TLRPC$User) arrayList2.get(i);
            if (!TextUtils.isEmpty(tLRPC$User.phone)) {
                getMessagesStorage().applyPhoneBookUpdates(tLRPC$User.phone, "");
                Contact contact = this.contactsBookSPhones.get(tLRPC$User.phone);
                if (contact != null && (iIndexOf = contact.shortPhones.indexOf(tLRPC$User.phone)) != -1) {
                    contact.phoneDeleted.set(iIndexOf, 1);
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$tUIoL9-Z7KRvj0r8l4lks46b-zY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContact$54$ContactsController(arrayList2, z, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteContact$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteContact$53$ContactsController(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deleteContactFromPhoneBook(((TLRPC$User) it.next()).id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteContact$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteContact$54$ContactsController(ArrayList arrayList, boolean z, String str) {
        Iterator it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            TLRPC$User tLRPC$User = (TLRPC$User) it.next();
            TLRPC$TL_contact tLRPC$TL_contact = (TLRPC$TL_contact) this.contactsDict.get(Long.valueOf(tLRPC$User.id));
            if (tLRPC$TL_contact != null) {
                this.contacts.remove(tLRPC$TL_contact);
                this.contactsDict.remove(Long.valueOf(tLRPC$User.id));
                z2 = true;
            }
        }
        if (z2) {
            buildContactsSectionsArrays(false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_NAME));
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        if (z) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 1, LocaleController.formatString("DeletedFromYourContacts", R.string.DeletedFromYourContacts, str));
        }
    }

    private void reloadContactsStatuses() {
        saveContactsLoadTime();
        getMessagesController().clearFullUsers();
        final SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        editorEdit.putBoolean("needGetStatuses", true).commit();
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_getStatuses
            public static int constructor = -995929106;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = stream.readInt32(exception);
                for (int i = 0; i < int32; i++) {
                    TLRPC$TL_contactStatus tLRPC$TL_contactStatusTLdeserialize = TLRPC$TL_contactStatus.TLdeserialize(stream, stream.readInt32(exception), exception);
                    if (tLRPC$TL_contactStatusTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$TL_contactStatusTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$k_pf1kWH2NBDoK2k4HZhBeDsKBE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadContactsStatuses$57$ContactsController(editorEdit, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadContactsStatuses$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadContactsStatuses$57$ContactsController(final SharedPreferences.Editor editor, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$U9l8NLQFUC3ULkaVHNiJAqHk6SU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadContactsStatuses$56$ContactsController(editor, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadContactsStatuses$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadContactsStatuses$56$ContactsController(SharedPreferences.Editor editor, TLObject tLObject) {
        editor.remove("needGetStatuses").commit();
        TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
        if (!tLRPC$Vector.objects.isEmpty()) {
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            Iterator<Object> it = tLRPC$Vector.objects.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
                TLRPC$TL_contactStatus tLRPC$TL_contactStatus = (TLRPC$TL_contactStatus) next;
                if (tLRPC$TL_contactStatus != null) {
                    TLRPC$UserStatus tLRPC$UserStatus = tLRPC$TL_contactStatus.status;
                    if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusRecently) {
                        tLRPC$UserStatus.expires = -100;
                    } else if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusLastWeek) {
                        tLRPC$UserStatus.expires = -101;
                    } else if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusLastMonth) {
                        tLRPC$UserStatus.expires = -102;
                    }
                    TLRPC$User user = getMessagesController().getUser(Long.valueOf(tLRPC$TL_contactStatus.user_id));
                    if (user != null) {
                        user.status = tLRPC$TL_contactStatus.status;
                    }
                    tLRPC$TL_user.status = tLRPC$TL_contactStatus.status;
                    arrayList.add(tLRPC$TL_user);
                }
            }
            getMessagesStorage().updateUsers(arrayList, true, true, true);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_STATUS));
    }

    public void loadPrivacySettings() {
        if (this.loadingDeleteInfo == 0) {
            this.loadingDeleteInfo = 1;
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_getAccountTTL
                public static int constructor = 150761757;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_accountDaysTTL.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$vo-cBdUyqY1hkWxDZYnwEyiME_g
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadPrivacySettings$59$ContactsController(tLObject, tLRPC$TL_error);
                }
            });
        }
        if (this.loadingGlobalSettings == 0) {
            this.loadingGlobalSettings = 1;
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_getGlobalPrivacySettings
                public static int constructor = -349483786;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_globalPrivacySettings.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$eIHrQSVsRK2il5m2VtlsxGX-DSA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadPrivacySettings$61$ContactsController(tLObject, tLRPC$TL_error);
                }
            });
        }
        final int i = 0;
        while (true) {
            int[] iArr = this.loadingPrivacyInfo;
            if (i < iArr.length) {
                if (iArr[i] == 0) {
                    iArr[i] = 1;
                    TLRPC$TL_account_getPrivacy tLRPC$TL_account_getPrivacy = new TLRPC$TL_account_getPrivacy();
                    switch (i) {
                        case 0:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyStatusTimestamp();
                            break;
                        case 1:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyChatInvite();
                            break;
                        case 2:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyPhoneCall();
                            break;
                        case 3:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyPhoneP2P();
                            break;
                        case 4:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyProfilePhoto();
                            break;
                        case 5:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyForwards();
                            break;
                        case 6:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyPhoneNumber();
                            break;
                        default:
                            tLRPC$TL_account_getPrivacy.key = new TLRPC$TL_inputPrivacyKeyAddedByPhone();
                            break;
                    }
                    getConnectionsManager().sendRequest(tLRPC$TL_account_getPrivacy, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$U59MuMTXc0zrbZFCtt_A_ALWjFA
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$loadPrivacySettings$63$ContactsController(i, tLObject, tLRPC$TL_error);
                        }
                    });
                }
                i++;
            } else {
                getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$59$ContactsController(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$lztAnSPlixWWUjbuzQoD_vn6acg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$58$ContactsController(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$58$ContactsController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.deleteAccountTTL = ((TLRPC$TL_accountDaysTTL) tLObject).days;
            this.loadingDeleteInfo = 2;
        } else {
            this.loadingDeleteInfo = 0;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$61$ContactsController(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$AccRtIxbYGMXg2t8xod6cHF6l2o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$60$ContactsController(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$60$ContactsController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.globalPrivacySettings = (TLRPC$TL_globalPrivacySettings) tLObject;
            this.loadingGlobalSettings = 2;
        } else {
            this.loadingGlobalSettings = 0;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$63$ContactsController(final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ContactsController$rojuAhIoF87fiNnPekEBvcK9ppA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$62$ContactsController(tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPrivacySettings$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPrivacySettings$62$ContactsController(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_privacyRules tLRPC$TL_account_privacyRules = (TLRPC$TL_account_privacyRules) tLObject;
            getMessagesController().putUsers(tLRPC$TL_account_privacyRules.users, false);
            getMessagesController().putChats(tLRPC$TL_account_privacyRules.chats, false);
            switch (i) {
                case 0:
                    this.lastseenPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 1:
                    this.groupPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 2:
                    this.callPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 3:
                    this.p2pPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 4:
                    this.profilePhotoPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 5:
                    this.forwardsPrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                case 6:
                    this.phonePrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
                default:
                    this.addedByPhonePrivacyRules = tLRPC$TL_account_privacyRules.rules;
                    break;
            }
            this.loadingPrivacyInfo[i] = 2;
        } else {
            this.loadingPrivacyInfo[i] = 0;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
    }

    public void setDeleteAccountTTL(int ttl) {
        this.deleteAccountTTL = ttl;
    }

    public int getDeleteAccountTTL() {
        return this.deleteAccountTTL;
    }

    public boolean getLoadingDeleteInfo() {
        return this.loadingDeleteInfo != 2;
    }

    public boolean getLoadingGlobalSettings() {
        return this.loadingGlobalSettings != 2;
    }

    public boolean getLoadingPrivicyInfo(int type) {
        return this.loadingPrivacyInfo[type] != 2;
    }

    public TLRPC$TL_globalPrivacySettings getGlobalPrivacySettings() {
        return this.globalPrivacySettings;
    }

    public ArrayList<TLRPC$PrivacyRule> getPrivacyRules(int type) {
        switch (type) {
            case 0:
                return this.lastseenPrivacyRules;
            case 1:
                return this.groupPrivacyRules;
            case 2:
                return this.callPrivacyRules;
            case 3:
                return this.p2pPrivacyRules;
            case 4:
                return this.profilePhotoPrivacyRules;
            case 5:
                return this.forwardsPrivacyRules;
            case 6:
                return this.phonePrivacyRules;
            case 7:
                return this.addedByPhonePrivacyRules;
            default:
                return null;
        }
    }

    public void setPrivacyRules(ArrayList<TLRPC$PrivacyRule> rules, int type) {
        switch (type) {
            case 0:
                this.lastseenPrivacyRules = rules;
                break;
            case 1:
                this.groupPrivacyRules = rules;
                break;
            case 2:
                this.callPrivacyRules = rules;
                break;
            case 3:
                this.p2pPrivacyRules = rules;
                break;
            case 4:
                this.profilePhotoPrivacyRules = rules;
                break;
            case 5:
                this.forwardsPrivacyRules = rules;
                break;
            case 6:
                this.phonePrivacyRules = rules;
                break;
            case 7:
                this.addedByPhonePrivacyRules = rules;
                break;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
        reloadContactsStatuses();
    }

    public void createOrUpdateConnectionServiceContact(long id, String firstName, String lastName) throws RemoteException, NumberFormatException, OperationApplicationException {
        String str;
        String str2;
        int i;
        Cursor cursor;
        ArrayList<ContentProviderOperation> arrayList;
        if (hasContactsPermission()) {
            try {
                ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                Uri uriBuild = ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
                Uri uriBuild2 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
                Account account = this.systemAccount;
                Cursor cursorQuery = contentResolver.query(uriBuild, new String[]{"_id"}, "title=? AND account_type=? AND account_name=?", new String[]{"EitaaConnectionService", account.type, account.name}, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i = cursorQuery.getInt(0);
                    str = "account_type";
                    str2 = "account_name";
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_type", this.systemAccount.type);
                    contentValues.put("account_name", this.systemAccount.name);
                    str = "account_type";
                    contentValues.put("group_visible", (Integer) 0);
                    str2 = "account_name";
                    contentValues.put("group_is_read_only", (Integer) 1);
                    contentValues.put("title", "EitaaConnectionService");
                    i = Integer.parseInt(contentResolver.insert(uriBuild, contentValues).getLastPathSegment());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                String str3 = str;
                String str4 = str2;
                Cursor cursorQuery2 = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id"}, "mimetype=? AND data1=?", new String[]{"vnd.android.cursor.item/group_membership", i + ""}, null);
                int size = arrayList2.size();
                int i2 = i;
                if (cursorQuery2 != null && cursorQuery2.moveToFirst()) {
                    int i3 = cursorQuery2.getInt(0);
                    cursor = cursorQuery2;
                    arrayList = arrayList2;
                    arrayList.add(ContentProviderOperation.newUpdate(uriBuild2).withSelection("_id=?", new String[]{i3 + ""}).withValue("deleted", 0).build());
                    arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{i3 + "", "vnd.android.cursor.item/phone_v2"}).withValue("data1", "+99084" + id).build());
                    arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("raw_contact_id=? AND mimetype=?", new String[]{i3 + "", "vnd.android.cursor.item/name"}).withValue("data2", firstName).withValue("data3", lastName).build());
                } else {
                    cursor = cursorQuery2;
                    arrayList = arrayList2;
                    arrayList.add(ContentProviderOperation.newInsert(uriBuild2).withValue(str3, this.systemAccount.type).withValue(str4, this.systemAccount.name).withValue("raw_contact_is_read_only", 1).withValue("aggregation_mode", 3).build());
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", firstName).withValue("data3", lastName).build());
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", "+99084" + id).build());
                    arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/group_membership").withValue("data1", Integer.valueOf(i2)).build());
                }
                if (cursor != null) {
                    cursor.close();
                }
                contentResolver.applyBatch("com.android.contacts", arrayList);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void deleteConnectionServiceContact() {
        if (hasContactsPermission()) {
            try {
                ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
                Account account = this.systemAccount;
                Cursor cursorQuery = contentResolver.query(ContactsContract.Groups.CONTENT_URI, new String[]{"_id"}, "title=? AND account_type=? AND account_name=?", new String[]{"EitaaConnectionService", account.type, account.name}, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                }
                int i = cursorQuery.getInt(0);
                cursorQuery.close();
                Cursor cursorQuery2 = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id"}, "mimetype=? AND data1=?", new String[]{"vnd.android.cursor.item/group_membership", i + ""}, null);
                if (cursorQuery2 == null || !cursorQuery2.moveToFirst()) {
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                        return;
                    }
                    return;
                }
                int i2 = cursorQuery2.getInt(0);
                cursorQuery2.close();
                contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI, "_id=?", new String[]{i2 + ""});
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static String formatName(String firstName, String lastName) {
        return formatName(firstName, lastName, 0);
    }

    public static String formatName(String firstName, String lastName, int maxLength) {
        if (firstName != null) {
            firstName = firstName.trim();
        }
        if (lastName != null) {
            lastName = lastName.trim();
        }
        StringBuilder sb = new StringBuilder((firstName != null ? firstName.length() : 0) + (lastName != null ? lastName.length() : 0) + 1);
        if (LocaleController.nameDisplayOrder == 1) {
            if (firstName != null && firstName.length() > 0) {
                if (maxLength > 0 && firstName.length() > maxLength + 2) {
                    return firstName.substring(0, maxLength);
                }
                sb.append(firstName);
                if (lastName != null && lastName.length() > 0) {
                    sb.append(" ");
                    if (maxLength > 0 && sb.length() + lastName.length() > maxLength) {
                        sb.append(lastName.charAt(0));
                    } else {
                        sb.append(lastName);
                    }
                }
            } else if (lastName != null && lastName.length() > 0) {
                if (maxLength > 0 && lastName.length() > maxLength + 2) {
                    return lastName.substring(0, maxLength);
                }
                sb.append(lastName);
            }
        } else if (lastName != null && lastName.length() > 0) {
            if (maxLength > 0 && lastName.length() > maxLength + 2) {
                return lastName.substring(0, maxLength);
            }
            sb.append(lastName);
            if (firstName != null && firstName.length() > 0) {
                sb.append(" ");
                if (maxLength > 0 && sb.length() + firstName.length() > maxLength) {
                    sb.append(firstName.charAt(0));
                } else {
                    sb.append(firstName);
                }
            }
        } else if (firstName != null && firstName.length() > 0) {
            if (maxLength > 0 && firstName.length() > maxLength + 2) {
                return firstName.substring(0, maxLength);
            }
            sb.append(firstName);
        }
        return sb.toString();
    }
}
