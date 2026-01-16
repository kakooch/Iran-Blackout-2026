package org.rbmain.messenger;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.SparseArray;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.ContactsController;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$PrivacyRule;
import org.rbmain.tgnet.TLRPC$TL_accountDaysTTL;
import org.rbmain.tgnet.TLRPC$TL_account_getPrivacy;
import org.rbmain.tgnet.TLRPC$TL_account_privacyRules;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_contactStatus;
import org.rbmain.tgnet.TLRPC$TL_contacts_addContact;
import org.rbmain.tgnet.TLRPC$TL_contacts_contactsNotModified;
import org.rbmain.tgnet.TLRPC$TL_contacts_deleteContacts;
import org.rbmain.tgnet.TLRPC$TL_contacts_getContacts;
import org.rbmain.tgnet.TLRPC$TL_contacts_importContacts;
import org.rbmain.tgnet.TLRPC$TL_contacts_importedContacts;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_globalPrivacySettings;
import org.rbmain.tgnet.TLRPC$TL_help_inviteText;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyAddedByPhone;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyChatInvite;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyForwards;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneNumber;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneP2P;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyStatusTimestamp;
import org.rbmain.tgnet.TLRPC$TL_popularContact;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastMonth;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastWeek;
import org.rbmain.tgnet.TLRPC$TL_userStatusRecently;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$contacts_Contacts;

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
    public ConcurrentHashMap<Integer, TLRPC$TL_contact> contactsDict;
    public boolean contactsLoaded;
    private boolean contactsSyncInProgress;
    private ArrayList<Integer> delayedContactsUpdate;
    private int deleteAccountTTL;
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
    private boolean updatingInviteLink;
    public HashMap<String, ArrayList<TLRPC$TL_contact>> usersMutualSectionsDict;
    public HashMap<String, ArrayList<TLRPC$TL_contact>> usersSectionsDict;

    private void deleteContactFromPhoneBook(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$resetImportedContacts$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performWriteContactsToPhoneBookInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$performWriteContactsToPhoneBook$41(ArrayList<TLRPC$TL_contact> arrayList) {
    }

    public long addContactToPhoneBook(TLRPC$User tLRPC$User, boolean z) {
        return -1L;
    }

    public void checkAppAccount() {
    }

    public void createOrUpdateConnectionServiceContact(int i, String str, String str2) {
    }

    public void deleteConnectionServiceContact() {
    }

    public void deleteUnknownAppAccounts() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    class MyContentObserver extends ContentObserver {
        private Runnable checkRunnable;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0() {
            for (int i = 0; i < 3; i++) {
                if (UserConfig.getInstance(i).isClientActivated()) {
                    ConnectionsManager.getInstance(i).resumeNetworkMaybe();
                    ContactsController.getInstance(i).checkContacts();
                }
            }
        }

        public MyContentObserver() {
            super(null);
            this.checkRunnable = new Runnable() { // from class: org.rbmain.messenger.ContactsController$MyContentObserver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsController.MyContentObserver.lambda$new$0();
                }
            };
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            synchronized (ContactsController.this.observerLock) {
                if (ContactsController.this.ignoreChanges) {
                    return;
                }
                Utilities.globalQueue.cancelRunnable(this.checkRunnable);
                Utilities.globalQueue.postRunnable(this.checkRunnable, 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        public static String getLetter(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return !TextUtils.isEmpty(str2) ? str2.substring(0, 1) : "#";
            }
            return str.substring(0, 1);
        }
    }

    public static ContactsController getInstance(int i) {
        ContactsController contactsController = Instance[i];
        if (contactsController == null) {
            synchronized (ContactsController.class) {
                contactsController = Instance[i];
                if (contactsController == null) {
                    ContactsController[] contactsControllerArr = Instance;
                    ContactsController contactsController2 = new ContactsController(i);
                    contactsControllerArr[i] = contactsController2;
                    contactsController = contactsController2;
                }
            }
        }
        return contactsController;
    }

    public ContactsController(int i) {
        super(i);
        this.loadContactsSync = new Object();
        this.observerLock = new Object();
        this.lastContactsVersions = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
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
        if (i == 0) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
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
        this.contactsLoaded = false;
        this.contactsBookLoaded = false;
        this.lastContactsVersions = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
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
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanup$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$1() {
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
            getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_help_getInviteText
                public static int constructor = 1295590211;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                    return TLRPC$TL_help_inviteText.TLdeserialize(abstractSerializedData, i2, z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda48
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$checkInviteText$3(tLObject, tLRPC$TL_error);
                }
            }, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkInviteText$3(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_help_inviteText tLRPC$TL_help_inviteText = (TLRPC$TL_help_inviteText) tLObject;
            if (tLRPC$TL_help_inviteText.message.length() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda37
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkInviteText$2(tLRPC$TL_help_inviteText);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkInviteText$2(TLRPC$TL_help_inviteText tLRPC$TL_help_inviteText) {
        this.updatingInviteLink = false;
        SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        String str = tLRPC$TL_help_inviteText.message;
        this.inviteLink = str;
        editorEdit.putString("invitelink", str);
        editorEdit.putInt("invitelinktime", (int) (System.currentTimeMillis() / 1000));
        editorEdit.apply();
    }

    public String getInviteText(int i) {
        String str = this.inviteLink;
        if (str == null) {
            str = "https://shad.ir/";
        }
        if (i <= 1) {
            return LocaleController.formatString("InviteText2", ir.medu.shad.R.string.InviteText2, str);
        }
        try {
            return String.format(LocaleController.getPluralString("InviteTextNum", i), Integer.valueOf(i), str);
        } catch (Exception unused) {
            return LocaleController.formatString("InviteText2", ir.medu.shad.R.string.InviteText2, str);
        }
    }

    public void checkContacts() {
        getAccountInstance().getContactsProxy().loadContactsIfNeeded();
    }

    public void forceImportContacts() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceImportContacts$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forceImportContacts$4() {
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("force import contacts");
        }
        performSyncPhoneBook(new HashMap<>(), true, true, true, true, false, false);
    }

    public void syncPhoneBookByAlert(final HashMap<String, Contact> map, final boolean z, final boolean z2, final boolean z3) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$syncPhoneBookByAlert$5(map, z, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$syncPhoneBookByAlert$5(HashMap map, boolean z, boolean z2, boolean z3) {
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
        getContactsProxy().deleteAllContacts(new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda55
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteAllContacts$7(runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAllContacts$7(final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.contactsBookSPhones.clear();
            this.contactsBook.clear();
            this.completedRequestsCount = 0;
            this.migratingContacts = false;
            this.contactsSyncInProgress = false;
            this.contactsLoaded = false;
            this.loadingContacts = false;
            this.contactsBookLoaded = false;
            this.lastContactsVersions = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteAllContacts$6(runnable);
                }
            });
            return;
        }
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAllContacts$6(Runnable runnable) {
        getMessagesStorage().putCachedPhoneBook(new HashMap<>(), false, true);
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
        loadContacts(false, 0);
        runnable.run();
    }

    public void resetImportedContacts() {
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_resetSaved
            public static int constructor = -2020263951;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda59
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                ContactsController.lambda$resetImportedContacts$8(tLObject, tLRPC$TL_error);
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
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$readContacts$9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readContacts$9() {
        if (!this.contacts.isEmpty() || this.contactsLoaded) {
            synchronized (this.loadContactsSync) {
                this.loadingContacts = false;
            }
            return;
        }
        loadContacts(true, 0);
    }

    private boolean isNotValidNameString(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                i++;
            }
        }
        return i > 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0329 A[Catch: all -> 0x0341, TRY_LEAVE, TryCatch #1 {all -> 0x0341, blocks: (B:175:0x0324, B:177:0x0329), top: B:202:0x0324 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x032e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.HashMap<java.lang.String, org.rbmain.messenger.ContactsController.Contact> readContactsFromPhoneBook() {
        /*
            Method dump skipped, instructions count: 849
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ContactsController.readContactsFromPhoneBook():java.util.HashMap");
    }

    public HashMap<String, Contact> getContactsCopy(HashMap<String, Contact> map) {
        HashMap<String, Contact> map2 = new HashMap<>();
        for (Map.Entry<String, Contact> entry : map.entrySet()) {
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
            map2.put(str, contact);
        }
        return map2;
    }

    protected void migratePhoneBookToV7(final SparseArray<Contact> sparseArray) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$migratePhoneBookToV7$10(sparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$migratePhoneBookToV7$10(SparseArray sparseArray) {
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

    public void performSyncPhoneBook(final HashMap<String, Contact> map, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final boolean z6) {
        if (z2 || this.contactsBookLoaded) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSyncPhoneBook$23(map, z3, z, z2, z4, z5, z6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:112:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0308 A[PHI: r16
      0x0308: PHI (r16v13 int) = (r16v10 int), (r16v11 int), (r16v10 int) binds: [B:129:0x02fa, B:133:0x0306, B:126:0x02f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0341 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c9 A[PHI: r16
      0x01c9: PHI (r16v23 int) = (r16v15 int), (r16v25 int), (r16v25 int), (r16v25 int) binds: [B:65:0x01a1, B:67:0x01ab, B:69:0x01b3, B:73:0x01c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSyncPhoneBook$23(final java.util.HashMap r27, final boolean r28, boolean r29, final boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 1542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.ContactsController.lambda$performSyncPhoneBook$23(java.util.HashMap, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    private /* synthetic */ void lambda$performSyncPhoneBook$11(HashMap map) {
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        if (map != null && !map.isEmpty()) {
            try {
                HashMap map2 = new HashMap();
                for (int i = 0; i < this.contacts.size(); i++) {
                    TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.contacts.get(i).user_id));
                    if (user != null && !TextUtils.isEmpty(user.phone)) {
                        map2.put(user.phone, user);
                    }
                }
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Contact contact = (Contact) ((Map.Entry) it.next()).getValue();
                    int i2 = 0;
                    boolean z = false;
                    while (i2 < contact.shortPhones.size()) {
                        TLRPC$User tLRPC$User = (TLRPC$User) map2.get(contact.shortPhones.get(i2));
                        if (tLRPC$User != null) {
                            arrayList.add(tLRPC$User);
                            contact.shortPhones.remove(i2);
                            i2--;
                            z = true;
                        }
                        i2++;
                    }
                    if (z) {
                        contact.shortPhones.size();
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        deleteContact(arrayList, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$12(int i, HashMap map, boolean z, boolean z2) {
        getNotificationCenter().postNotificationName(NotificationCenter.hasNewContactsToImport, Integer.valueOf(i), map, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$14(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$13(map3, arrayList, map4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$13(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$21(map, arrayList, map2);
        updateUnregisteredContacts();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$18(HashMap map, SparseArray sparseArray, final boolean[] zArr, final HashMap map2, TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts, int i, final HashMap map3, final boolean z, final HashMap map4, final ArrayList arrayList, final HashMap map5, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSyncPhoneBook$17(map3, map2, z, map4, arrayList, map5, zArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$17(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4, boolean[] zArr) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$15(map3, arrayList, map4);
            }
        });
        if (zArr[0]) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSyncPhoneBook$16();
                }
            }, 300000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$15(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$21(map, arrayList, map2);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$16() {
        getMessagesStorage().getCachedPhoneBook(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$20(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$19(map3, arrayList, map4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$19(HashMap map, ArrayList arrayList, HashMap map2) {
        lambda$performSyncPhoneBook$21(map, arrayList, map2);
        updateUnregisteredContacts();
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsImported, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSyncPhoneBook$22(HashMap map, HashMap map2, boolean z, final HashMap map3, final ArrayList arrayList, final HashMap map4) {
        this.contactsBookSPhones = map;
        this.contactsBook = map2;
        this.contactsSyncInProgress = false;
        this.contactsBookLoaded = true;
        if (z) {
            this.contactsLoaded = true;
        }
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded && this.contactsBookLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSyncPhoneBook$21(map3, arrayList, map4);
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

    private int getContactsHash(ArrayList<TLRPC$TL_contact> arrayList) {
        long j;
        int i;
        ArrayList arrayList2 = new ArrayList(arrayList);
        Collections.sort(arrayList2, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda46
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$getContactsHash$24((TLRPC$TL_contact) obj, (TLRPC$TL_contact) obj2);
            }
        });
        int size = arrayList2.size();
        long j2 = 0;
        for (int i2 = -1; i2 < size; i2++) {
            if (i2 == -1) {
                j = (j2 * 20261) + 2147483648L;
                i = getUserConfig().contactsSavedCount;
            } else {
                j = (j2 * 20261) + 2147483648L;
                i = ((TLRPC$TL_contact) arrayList2.get(i2)).user_id;
            }
            j2 = (j + i) % 2147483648L;
        }
        return (int) j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getContactsHash$24(TLRPC$TL_contact tLRPC$TL_contact, TLRPC$TL_contact tLRPC$TL_contact2) {
        int i = tLRPC$TL_contact.user_id;
        int i2 = tLRPC$TL_contact2.user_id;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public void loadContacts(boolean z, final int i) {
        synchronized (this.loadContactsSync) {
            this.loadingContacts = true;
        }
        if (z) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("load contacts from cache");
            }
        } else {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("load contacts from server");
            }
            TLRPC$TL_contacts_getContacts tLRPC$TL_contacts_getContacts = new TLRPC$TL_contacts_getContacts();
            tLRPC$TL_contacts_getContacts.hash = i;
            getConnectionsManager().sendRequest(tLRPC$TL_contacts_getContacts, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda52
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadContacts$26(i, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadContacts$26(int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$contacts_Contacts tLRPC$contacts_Contacts = (TLRPC$contacts_Contacts) tLObject;
            if (i != 0 && (tLRPC$contacts_Contacts instanceof TLRPC$TL_contacts_contactsNotModified)) {
                this.contactsLoaded = true;
                if (!this.delayedContactsUpdate.isEmpty() && this.contactsBookLoaded) {
                    applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
                    this.delayedContactsUpdate.clear();
                }
                getUserConfig().lastContactsSyncTime = (int) (System.currentTimeMillis() / 1000);
                getUserConfig().saveConfig(false);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadContacts$25();
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
    public /* synthetic */ void lambda$loadContacts$25() {
        synchronized (this.loadContactsSync) {
            this.loadingContacts = false;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    public void processLoadedContacts(final ArrayList<TLRPC$TL_contact> arrayList, final ArrayList<TLRPC$User> arrayList2, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$33(arrayList2, i, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedContacts$33(ArrayList arrayList, final int i, final ArrayList arrayList2) {
        getMessagesController().putUsers(arrayList, i == 1);
        final SparseArray sparseArray = new SparseArray();
        final boolean zIsEmpty = arrayList2.isEmpty();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(((TLRPC$TL_contact) arrayList2.get(i2)).user_id));
            if (user != null) {
                sparseArray.put(user.id, user);
            }
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$32(i, arrayList2, sparseArray, zIsEmpty);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedContacts$32(final int i, final ArrayList arrayList, SparseArray sparseArray, final boolean z) {
        final HashMap map;
        final HashMap map2;
        ArrayList arrayList2 = arrayList;
        SparseArray sparseArray2 = sparseArray;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("done loading contacts");
        }
        if (i == 1 && (arrayList.isEmpty() || Math.abs((System.currentTimeMillis() / 1000) - getUserConfig().lastContactsSyncTime) >= 86400)) {
            loadContacts(false, getContactsHash(arrayList2));
            if (arrayList.isEmpty()) {
                return;
            }
        }
        if (i == 0) {
            getUserConfig().lastContactsSyncTime = (int) (System.currentTimeMillis() / 1000);
            getUserConfig().saveConfig(false);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TLRPC$TL_contact tLRPC$TL_contact = arrayList2.get(i2);
            if (sparseArray2.get(tLRPC$TL_contact.user_id) == null && tLRPC$TL_contact.user_id != getUserConfig().getClientUserId()) {
                loadContacts(false, 0);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("contacts are broken, load from server");
                    return;
                }
                return;
            }
        }
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(20, 1.0f, 2);
        final HashMap map3 = new HashMap();
        final HashMap map4 = new HashMap();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        if (this.contactsBookLoaded) {
            map = null;
            map2 = null;
        } else {
            HashMap map5 = new HashMap();
            map2 = new HashMap();
            map = map5;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            TLRPC$TL_contact tLRPC$TL_contact2 = arrayList2.get(i3);
            TLRPC$User tLRPC$User = (TLRPC$User) sparseArray2.get(tLRPC$TL_contact2.user_id);
            if (tLRPC$User != null) {
                concurrentHashMap.put(Integer.valueOf(tLRPC$TL_contact2.user_id), tLRPC$TL_contact2);
                if (map != null && !TextUtils.isEmpty(tLRPC$User.phone)) {
                    map.put(tLRPC$User.phone, tLRPC$TL_contact2);
                    map2.put(tLRPC$User.phone.substring(Math.max(0, r11.length() - 7)), tLRPC$TL_contact2);
                }
                String firstName = UserObject.getFirstName(tLRPC$User);
                if (firstName.length() > 1) {
                    firstName = firstName.substring(0, 1);
                }
                String upperCase = firstName.length() == 0 ? "#" : firstName.toUpperCase();
                String str = this.sectionsToReplace.get(upperCase);
                if (str != null) {
                    upperCase = str;
                }
                ArrayList arrayList5 = (ArrayList) map3.get(upperCase);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    map3.put(upperCase, arrayList5);
                    arrayList3.add(upperCase);
                }
                arrayList5.add(tLRPC$TL_contact2);
                if (tLRPC$User.mutual_contact) {
                    ArrayList arrayList6 = (ArrayList) map4.get(upperCase);
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                        map4.put(upperCase, arrayList6);
                        arrayList4.add(upperCase);
                    }
                    arrayList6.add(tLRPC$TL_contact2);
                }
            }
            i3++;
            arrayList2 = arrayList;
            sparseArray2 = sparseArray;
        }
        Collections.sort(arrayList3, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda43
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$processLoadedContacts$27((String) obj, (String) obj2);
            }
        });
        Collections.sort(arrayList4, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda41
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$processLoadedContacts$28((String) obj, (String) obj2);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$29(arrayList, concurrentHashMap, map3, map4, arrayList3, arrayList4, i, z);
            }
        });
        if (!this.delayedContactsUpdate.isEmpty() && this.contactsLoaded && this.contactsBookLoaded) {
            applyContactsUpdates(this.delayedContactsUpdate, null, null, null);
            this.delayedContactsUpdate.clear();
        }
        if (map != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedContacts$31(map, map2);
                }
            });
        } else {
            this.contactsLoaded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processLoadedContacts$27(String str, String str2) {
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
    public static /* synthetic */ int lambda$processLoadedContacts$28(String str, String str2) {
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
    public /* synthetic */ void lambda$processLoadedContacts$29(ArrayList arrayList, ConcurrentHashMap concurrentHashMap, HashMap map, HashMap map2, ArrayList arrayList2, ArrayList arrayList3, int i, boolean z) {
        this.contacts = arrayList;
        this.contactsDict = concurrentHashMap;
        this.usersSectionsDict = map;
        this.usersMutualSectionsDict = map2;
        this.sortedUsersSectionsArray = arrayList2;
        this.sortedUsersMutualSectionsArray = arrayList3;
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
    public /* synthetic */ void lambda$processLoadedContacts$31(final HashMap map, final HashMap map2) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedContacts$30(map, map2);
            }
        });
        if (this.contactsSyncInProgress) {
            return;
        }
        this.contactsSyncInProgress = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedContacts$30(HashMap map, HashMap map2) {
        this.contactsByPhone = map;
        this.contactsByShortPhone = map2;
    }

    public boolean isContact(int i) {
        return this.contactsDict.get(Integer.valueOf(i)) != null;
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
            MessagesController.getMainSettings(this.currentAccount).edit().putLong("lastReloadStatusTime", System.currentTimeMillis()).apply();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* renamed from: mergePhonebookAndRubikaContacts, reason: merged with bridge method [inline-methods] */
    public void lambda$performSyncPhoneBook$21(final HashMap<String, ArrayList<Object>> map, final ArrayList<String> arrayList, final HashMap<String, Contact> map2) {
        final ArrayList arrayList2 = new ArrayList(this.contacts);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mergePhonebookAndRubikaContacts$37(arrayList2, map2, map, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mergePhonebookAndRubikaContacts$37(ArrayList arrayList, HashMap map, final HashMap map2, final ArrayList arrayList2) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(((TLRPC$TL_contact) arrayList.get(i)).user_id));
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
            Collections.sort((ArrayList) it.next(), new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda47
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ContactsController.lambda$mergePhonebookAndRubikaContacts$34(obj, obj2);
                }
            });
        }
        Collections.sort(arrayList2, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda42
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$mergePhonebookAndRubikaContacts$35((String) obj, (String) obj2);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$mergePhonebookAndRubikaContacts$36(arrayList2, map2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$mergePhonebookAndRubikaContacts$34(Object obj, Object obj2) {
        String name;
        String name2;
        boolean z = obj instanceof TLRPC$User;
        String name3 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        if (z) {
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
            name = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$mergePhonebookAndRubikaContacts$35(String str, String str2) {
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
    public /* synthetic */ void lambda$mergePhonebookAndRubikaContacts$36(ArrayList arrayList, HashMap map) {
        this.phoneBookSectionsArray = arrayList;
        this.phoneBookSectionsDict = map;
    }

    public void updateUnregisteredContacts() {
        boolean z;
        HashMap map = new HashMap();
        int size = this.contacts.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_contact tLRPC$TL_contact = this.contacts.get(i);
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contact.user_id));
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
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda45
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$updateUnregisteredContacts$38((ContactsController.Contact) obj, (ContactsController.Contact) obj2);
            }
        });
        this.phoneBookContacts = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$updateUnregisteredContacts$38(Contact contact, Contact contact2) {
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

    private void buildContactsSectionsArrays(boolean z) {
        if (z) {
            Collections.sort(this.contacts, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda40
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f$0.lambda$buildContactsSectionsArrays$39((TLRPC$TL_contact) obj, (TLRPC$TL_contact) obj2);
                }
            });
        }
        HashMap<String, ArrayList<TLRPC$TL_contact>> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < this.contacts.size(); i++) {
            TLRPC$TL_contact tLRPC$TL_contact = this.contacts.get(i);
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contact.user_id));
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
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda44
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ContactsController.lambda$buildContactsSectionsArrays$40((String) obj, (String) obj2);
            }
        });
        this.usersSectionsDict = map;
        this.sortedUsersSectionsArray = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$buildContactsSectionsArrays$39(TLRPC$TL_contact tLRPC$TL_contact, TLRPC$TL_contact tLRPC$TL_contact2) {
        return UserObject.getFirstName(getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contact.user_id))).compareTo(UserObject.getFirstName(getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contact2.user_id))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$buildContactsSectionsArrays$40(String str, String str2) {
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

    private void performWriteContactsToPhoneBook() {
        final ArrayList arrayList = new ArrayList(this.contacts);
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performWriteContactsToPhoneBook$41(arrayList);
            }
        });
    }

    private void applyContactsUpdates(ArrayList<Integer> arrayList, ConcurrentHashMap<Integer, TLRPC$User> concurrentHashMap, final ArrayList<TLRPC$TL_contact> arrayList2, final ArrayList<Integer> arrayList3) {
        int iIndexOf;
        int iIndexOf2;
        if (arrayList2 == null || arrayList3 == null) {
            arrayList2 = new ArrayList<>();
            arrayList3 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                Integer num = arrayList.get(i);
                if (num.intValue() > 0) {
                    TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                    tLRPC$TL_contact.user_id = num.intValue();
                    arrayList2.add(tLRPC$TL_contact);
                } else if (num.intValue() < 0) {
                    arrayList3.add(Integer.valueOf(-num.intValue()));
                }
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("process update - contacts add = " + arrayList2.size() + " delete = " + arrayList3.size());
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= arrayList2.size()) {
                break;
            }
            TLRPC$TL_contact tLRPC$TL_contact2 = arrayList2.get(i2);
            TLRPC$User user = concurrentHashMap != null ? concurrentHashMap.get(Integer.valueOf(tLRPC$TL_contact2.user_id)) : null;
            if (user == null) {
                user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contact2.user_id));
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
        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
            final Integer num2 = arrayList3.get(i3);
            Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$42(num2);
                }
            });
            TLRPC$User user2 = concurrentHashMap != null ? concurrentHashMap.get(num2) : null;
            if (user2 == null) {
                user2 = getMessagesController().getUser(num2);
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
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$43();
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$applyContactsUpdates$44(arrayList2, arrayList3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyContactsUpdates$42(Integer num) {
        deleteContactFromPhoneBook(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyContactsUpdates$43() {
        loadContacts(false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyContactsUpdates$44(ArrayList arrayList, ArrayList arrayList2) {
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$TL_contact tLRPC$TL_contact = (TLRPC$TL_contact) arrayList.get(i);
            if (this.contactsDict.get(Integer.valueOf(tLRPC$TL_contact.user_id)) == null) {
                this.contacts.add(tLRPC$TL_contact);
                this.contactsDict.put(Integer.valueOf(tLRPC$TL_contact.user_id), tLRPC$TL_contact);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            Integer num = (Integer) arrayList2.get(i2);
            TLRPC$TL_contact tLRPC$TL_contact2 = this.contactsDict.get(num);
            if (tLRPC$TL_contact2 != null) {
                this.contacts.remove(tLRPC$TL_contact2);
                this.contactsDict.remove(num);
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

    public void processContactsUpdates(ArrayList<Integer> arrayList, ConcurrentHashMap<Integer, TLRPC$User> concurrentHashMap) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<TLRPC$TL_contact> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() > 0) {
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = next.intValue();
                arrayList2.add(tLRPC$TL_contact);
                if (!this.delayedContactsUpdate.isEmpty() && (iIndexOf = this.delayedContactsUpdate.indexOf(Integer.valueOf(-next.intValue()))) != -1) {
                    this.delayedContactsUpdate.remove(iIndexOf);
                }
            } else if (next.intValue() < 0) {
                arrayList3.add(Integer.valueOf(-next.intValue()));
                if (!this.delayedContactsUpdate.isEmpty() && (iIndexOf2 = this.delayedContactsUpdate.indexOf(Integer.valueOf(-next.intValue()))) != -1) {
                    this.delayedContactsUpdate.remove(iIndexOf2);
                }
            }
        }
        if (!arrayList3.isEmpty()) {
            getMessagesStorage().deleteContacts(arrayList3);
        }
        arrayList2.isEmpty();
        if (!this.contactsLoaded || !this.contactsBookLoaded) {
            this.delayedContactsUpdate.addAll(arrayList);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("delay update - contacts add = " + arrayList2.size() + " delete = " + arrayList3.size());
                return;
            }
            return;
        }
        applyContactsUpdates(arrayList, concurrentHashMap, arrayList2, arrayList3);
    }

    protected void markAsContacted(final String str) {
        if (str == null) {
            return;
        }
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ContactsController.lambda$markAsContacted$45(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$markAsContacted$45(String str) {
        Uri uri = Uri.parse(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_time_contacted", Long.valueOf(System.currentTimeMillis()));
        ApplicationLoader.applicationContext.getContentResolver().update(uri, contentValues, null, null);
    }

    public void addContact(final TLRPC$User tLRPC$User, boolean z) {
        if (tLRPC$User == null) {
            return;
        }
        TLRPC$TL_contacts_addContact tLRPC$TL_contacts_addContact = new TLRPC$TL_contacts_addContact();
        tLRPC$TL_contacts_addContact.id = getMessagesController().getInputUser(tLRPC$User);
        tLRPC$TL_contacts_addContact.first_name = tLRPC$User.first_name;
        tLRPC$TL_contacts_addContact.last_name = tLRPC$User.last_name;
        String str = tLRPC$User.phone;
        tLRPC$TL_contacts_addContact.phone = str;
        tLRPC$TL_contacts_addContact.add_phone_privacy_exception = z;
        if (str == null) {
            tLRPC$TL_contacts_addContact.phone = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        } else if (str.length() > 0 && !tLRPC$TL_contacts_addContact.phone.startsWith("+")) {
            tLRPC$TL_contacts_addContact.phone = "+" + tLRPC$TL_contacts_addContact.phone;
        }
        getContactsProxy().addContact(tLRPC$TL_contacts_addContact, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda58
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$addContact$48(tLRPC$User, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContact$48(TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int iIndexOf;
        if (tLRPC$TL_error != null) {
            return;
        }
        final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
        getMessagesController().processUpdates(tLRPC$Updates, false);
        for (int i = 0; i < tLRPC$Updates.users.size(); i++) {
            final TLRPC$User tLRPC$User2 = tLRPC$Updates.users.get(i);
            if (tLRPC$User2.id == tLRPC$User.id) {
                Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda39
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$addContact$46(tLRPC$User2);
                    }
                });
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = tLRPC$User2.id;
                new ArrayList().add(tLRPC$TL_contact);
                if (!TextUtils.isEmpty(tLRPC$User2.phone)) {
                    formatName(tLRPC$User2.first_name, tLRPC$User2.last_name);
                    getMessagesStorage().applyPhoneBookUpdates(tLRPC$User2.phone, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    Contact contact = this.contactsBookSPhones.get(tLRPC$User2.phone);
                    if (contact != null && (iIndexOf = contact.shortPhones.indexOf(tLRPC$User2.phone)) != -1) {
                        contact.phoneDeleted.set(iIndexOf, 0);
                    }
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addContact$47(tLRPC$Updates);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContact$46(TLRPC$User tLRPC$User) {
        addContactToPhoneBook(tLRPC$User, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addContact$47(TLRPC$Updates tLRPC$Updates) {
        for (int i = 0; i < tLRPC$Updates.users.size(); i++) {
            TLRPC$User tLRPC$User = tLRPC$Updates.users.get(i);
            if (tLRPC$User.contact && this.contactsDict.get(Integer.valueOf(tLRPC$User.id)) == null) {
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = tLRPC$User.id;
                this.contacts.add(tLRPC$TL_contact);
                this.contactsDict.put(Integer.valueOf(tLRPC$TL_contact.user_id), tLRPC$TL_contact);
            }
        }
        buildContactsSectionsArrays(true);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
    }

    public void deleteContact(final ArrayList<TLRPC$User> arrayList, final boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        TLRPC$TL_contacts_deleteContacts tLRPC$TL_contacts_deleteContacts = new TLRPC$TL_contacts_deleteContacts();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<TLRPC$User> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$User next = it.next();
            TLRPC$InputUser inputUser = getMessagesController().getInputUser(next);
            if (inputUser != null) {
                next.contact = false;
                arrayList2.add(Integer.valueOf(next.id));
                tLRPC$TL_contacts_deleteContacts.id.add(inputUser);
            }
        }
        final String str = arrayList.get(0).first_name;
        getContactsProxy().deleteContact(tLRPC$TL_contacts_deleteContacts, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda56
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteContact$51(arrayList2, arrayList, z, str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteContact$51(ArrayList arrayList, final ArrayList arrayList2, final boolean z, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        int iIndexOf;
        if (tLRPC$TL_error != null) {
            return;
        }
        getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        getMessagesStorage().deleteContacts(arrayList);
        Utilities.phoneBookQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContact$49(arrayList2);
            }
        });
        for (int i = 0; i < arrayList2.size(); i++) {
            TLRPC$User tLRPC$User = (TLRPC$User) arrayList2.get(i);
            if (!TextUtils.isEmpty(tLRPC$User.phone)) {
                getMessagesStorage().applyPhoneBookUpdates(tLRPC$User.phone, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                Contact contact = this.contactsBookSPhones.get(tLRPC$User.phone);
                if (contact != null && (iIndexOf = contact.shortPhones.indexOf(tLRPC$User.phone)) != -1) {
                    contact.phoneDeleted.set(iIndexOf, 1);
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContact$50(arrayList2, z, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteContact$49(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deleteContactFromPhoneBook(((TLRPC$User) it.next()).id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteContact$50(ArrayList arrayList, boolean z, String str) {
        Iterator it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            TLRPC$User tLRPC$User = (TLRPC$User) it.next();
            TLRPC$TL_contact tLRPC$TL_contact = this.contactsDict.get(Integer.valueOf(tLRPC$User.id));
            if (tLRPC$TL_contact != null) {
                this.contacts.remove(tLRPC$TL_contact);
                this.contactsDict.remove(Integer.valueOf(tLRPC$User.id));
                z2 = true;
            }
        }
        if (z2) {
            buildContactsSectionsArrays(false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 1);
        getNotificationCenter().postNotificationName(NotificationCenter.contactsDidLoad, new Object[0]);
        if (z) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 1, LocaleController.formatString("DeletedFromYourContacts", ir.medu.shad.R.string.DeletedFromYourContacts, str));
        }
    }

    private void reloadContactsStatuses() {
        saveContactsLoadTime();
        getMessagesController().clearFullUsers();
        final SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        editorEdit.putBoolean("needGetStatuses", true).apply();
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_getStatuses
            public static int constructor = -995929106;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < int32; i2++) {
                    TLRPC$TL_contactStatus tLRPC$TL_contactStatusTLdeserialize = TLRPC$TL_contactStatus.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (tLRPC$TL_contactStatusTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$TL_contactStatusTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda54
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadContactsStatuses$53(editorEdit, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadContactsStatuses$53(final SharedPreferences.Editor editor, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadContactsStatuses$52(editor, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadContactsStatuses$52(SharedPreferences.Editor editor, TLObject tLObject) {
        editor.remove("needGetStatuses").apply();
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
                    TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_contactStatus.user_id));
                    if (user != null) {
                        user.status = tLRPC$TL_contactStatus.status;
                    }
                    tLRPC$TL_user.status = tLRPC$TL_contactStatus.status;
                    arrayList.add(tLRPC$TL_user);
                }
            }
            getMessagesStorage().updateUsers(arrayList, true, true, true);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 4);
    }

    public void loadPrivacySettings() {
        getContactsProxy().loadPrivacySetting(new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda51
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPrivacySettings$60(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$60(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (this.loadingDeleteInfo == 0) {
            this.loadingDeleteInfo = 1;
            getContactsProxy().getDeleteInfo(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getAccountTTL
                public static int constructor = 150761757;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                    return TLRPC$TL_accountDaysTTL.TLdeserialize(abstractSerializedData, i, z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda49
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$loadPrivacySettings$55(tLObject2, tLRPC$TL_error2);
                }
            });
        }
        if (this.loadingGlobalSettings == 0) {
            this.loadingGlobalSettings = 1;
            getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_getGlobalPrivacySettings
                public static int constructor = -349483786;

                @Override // org.rbmain.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
                    return TLRPC$TL_globalPrivacySettings.TLdeserialize(abstractSerializedData, i, z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda50
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$loadPrivacySettings$57(tLObject2, tLRPC$TL_error2);
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
                    getContactsProxy().getPrivacyRule(tLRPC$TL_account_getPrivacy, new RequestDelegate() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda53
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                            this.f$0.lambda$loadPrivacySettings$59(i, tLObject2, tLRPC$TL_error2);
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
    public /* synthetic */ void lambda$loadPrivacySettings$55(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$54(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$54(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.deleteAccountTTL = ((TLRPC$TL_accountDaysTTL) tLObject).days * 30;
            this.loadingDeleteInfo = 2;
        } else {
            this.loadingDeleteInfo = 0;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$57(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$56(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$56(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.globalPrivacySettings = (TLRPC$TL_globalPrivacySettings) tLObject;
            this.loadingGlobalSettings = 2;
        } else {
            this.loadingGlobalSettings = 0;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$59(final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ContactsController$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPrivacySettings$58(tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrivacySettings$58(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
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

    public void setDeleteAccountTTL(int i) {
        this.deleteAccountTTL = i;
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

    public boolean getLoadingPrivicyInfo(int i) {
        return this.loadingPrivacyInfo[i] != 2;
    }

    public TLRPC$TL_globalPrivacySettings getGlobalPrivacySettings() {
        return this.globalPrivacySettings;
    }

    public ArrayList<TLRPC$PrivacyRule> getPrivacyRules(int i) {
        switch (i) {
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

    public void setPrivacyRules(ArrayList<TLRPC$PrivacyRule> arrayList, int i) {
        switch (i) {
            case 0:
                this.lastseenPrivacyRules = arrayList;
                break;
            case 1:
                this.groupPrivacyRules = arrayList;
                break;
            case 2:
                this.callPrivacyRules = arrayList;
                break;
            case 3:
                this.p2pPrivacyRules = arrayList;
                break;
            case 4:
                this.profilePhotoPrivacyRules = arrayList;
                break;
            case 5:
                this.forwardsPrivacyRules = arrayList;
                break;
            case 6:
                this.phonePrivacyRules = arrayList;
                break;
            case 7:
                this.addedByPhonePrivacyRules = arrayList;
                break;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.privacyRulesUpdated, new Object[0]);
        reloadContactsStatuses();
    }

    public static String formatName(TLObject tLObject) {
        if (tLObject instanceof TLRPC$User) {
            return formatName((TLRPC$User) tLObject);
        }
        if (tLObject instanceof TLRPC$Chat) {
            return ((TLRPC$Chat) tLObject).title;
        }
        return LocaleController.getString(ir.medu.shad.R.string.HiddenName);
    }

    public static String formatName(TLRPC$User tLRPC$User) {
        return formatName(tLRPC$User.first_name, tLRPC$User.last_name, 0);
    }

    public static String formatName(String str, String str2) {
        return formatName(str, str2, 0);
    }

    public static String formatName(String str, String str2, int i) {
        if (str != null) {
            str = str.trim();
        }
        if (str2 != null) {
            str2 = str2.trim();
        }
        StringBuilder sb = new StringBuilder((str != null ? str.length() : 0) + (str2 != null ? str2.length() : 0) + 1);
        if (LocaleController.nameDisplayOrder == 1) {
            if (str != null && str.length() > 0) {
                if (i > 0 && str.length() > i + 2) {
                    return str.substring(0, i);
                }
                sb.append(str);
                if (str2 != null && str2.length() > 0) {
                    sb.append(" ");
                    if (i > 0 && sb.length() + str2.length() > i) {
                        sb.append(str2.charAt(0));
                    } else {
                        sb.append(str2);
                    }
                }
            } else if (str2 != null && str2.length() > 0) {
                if (i > 0 && str2.length() > i + 2) {
                    return str2.substring(0, i);
                }
                sb.append(str2);
            }
        } else if (str2 != null && str2.length() > 0) {
            if (i > 0 && str2.length() > i + 2) {
                return str2.substring(0, i);
            }
            sb.append(str2);
            if (str != null && str.length() > 0) {
                sb.append(" ");
                if (i > 0 && sb.length() + str.length() > i) {
                    sb.append(str.charAt(0));
                } else {
                    sb.append(str);
                }
            }
        } else if (str != null && str.length() > 0) {
            if (i > 0 && str.length() > i + 2) {
                return str.substring(0, i);
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
