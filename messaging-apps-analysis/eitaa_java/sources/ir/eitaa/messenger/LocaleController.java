package ir.eitaa.messenger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Xml;
import ir.eitaa.messenger.time.FastDateFormat;
import ir.eitaa.messenger.time.JalaliCalendar;
import ir.eitaa.messenger.time.PersianDateFormatter;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$LangPackString;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_langPackDifference;
import ir.eitaa.tgnet.TLRPC$TL_langPackLanguage;
import ir.eitaa.tgnet.TLRPC$TL_langPackString;
import ir.eitaa.tgnet.TLRPC$TL_langPackStringDeleted;
import ir.eitaa.tgnet.TLRPC$TL_langPackStringPluralized;
import ir.eitaa.tgnet.TLRPC$TL_langpack_getDifference;
import ir.eitaa.tgnet.TLRPC$TL_langpack_getLangPack;
import ir.eitaa.tgnet.TLRPC$TL_userEmpty;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastMonth;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastWeek;
import ir.eitaa.tgnet.TLRPC$TL_userStatusRecently;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.tgnet.TLRPC$Vector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class LocaleController {
    private static volatile LocaleController Instance = null;
    static final int QUANTITY_FEW = 8;
    static final int QUANTITY_MANY = 16;
    static final int QUANTITY_ONE = 2;
    static final int QUANTITY_OTHER = 0;
    static final int QUANTITY_TWO = 4;
    static final int QUANTITY_ZERO = 1;
    public static boolean is24HourFormat = false;
    public static boolean isRTL = false;
    public static int nameDisplayOrder = 1;
    private static Boolean useImperialSystemType;
    public FastDateFormat chatDate;
    public FastDateFormat chatFullDate;
    private HashMap<String, String> currencyValues;
    private Locale currentLocale;
    private LocaleInfo currentLocaleInfo;
    private PluralRules currentPluralRules;
    private String currentSystemLocale;
    public FastDateFormat formatterBannedUntil;
    public FastDateFormat formatterBannedUntilThisYear;
    public FastDateFormat formatterDay;
    public FastDateFormat formatterDayMonth;
    public FastDateFormat formatterMonthYear;
    public FastDateFormat formatterScheduleDay;
    public FastDateFormat formatterScheduleYear;
    public FastDateFormat formatterStats;
    public FastDateFormat formatterWeek;
    public FastDateFormat formatterWeekLong;
    public FastDateFormat formatterYear;
    public FastDateFormat formatterYearMax;
    private String languageOverride;
    private boolean loadingRemoteLanguages;
    private boolean reloadLastFile;
    private HashMap<String, String> ruTranslitChars;
    private Locale systemDefaultLocale;
    private HashMap<String, String> translitChars;
    private static char[] defaultNumbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[][] otherNumbers = {new char[]{1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641}, new char[]{1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785}, new char[]{2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415}, new char[]{2790, 2791, 2792, 2793, 2794, 2795, 2796, 2797, 2798, 2799}, new char[]{2662, 2663, 2664, 2665, 2666, 2667, 2668, 2669, 2670, 2671}, new char[]{2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2542, 2543}, new char[]{3302, 3303, 3304, 3305, 3306, 3307, 3308, 3309, 3310, 3311}, new char[]{2918, 2919, 2920, 2921, 2922, 2923, 2924, 2925, 2926, 2927}, new char[]{3430, 3431, 3432, 3433, 3434, 3435, 3436, 3437, 3438, 3439}, new char[]{3046, 3047, 3048, 3049, 3050, 3051, 3052, 3053, 3054, 3055}, new char[]{3174, 3175, 3176, 3177, 3178, 3179, 3180, 3181, 3182, 3183}, new char[]{4160, 4161, 4162, 4163, 4164, 4165, 4166, 4167, 4168, 4169}, new char[]{3872, 3873, 3874, 3875, 3876, 3877, 3878, 3879, 3880, 3881}, new char[]{6160, 6161, 6162, 6163, 6164, 6165, 6166, 6167, 6168, 6169}, new char[]{6112, 6113, 6114, 6115, 6116, 6117, 6118, 6119, 6120, 6121}, new char[]{3664, 3665, 3666, 3667, 3668, 3669, 3670, 3671, 3672, 3673}, new char[]{3792, 3793, 3794, 3795, 3796, 3797, 3798, 3799, 3800, 3801}, new char[]{43472, 43473, 43474, 43475, 43476, 43477, 43478, 43479, 43480, 43481}};
    public FastDateFormat[] formatterScheduleSend = new FastDateFormat[15];
    private HashMap<String, PluralRules> allRules = new HashMap<>();
    private HashMap<String, String> localeValues = new HashMap<>();
    private boolean changingConfiguration = false;
    public ArrayList<LocaleInfo> languages = new ArrayList<>();
    public ArrayList<LocaleInfo> unofficialLanguages = new ArrayList<>();
    public ArrayList<LocaleInfo> remoteLanguages = new ArrayList<>();
    public HashMap<String, LocaleInfo> remoteLanguagesDict = new HashMap<>();
    public HashMap<String, LocaleInfo> languagesDict = new HashMap<>();
    private ArrayList<LocaleInfo> otherLanguages = new ArrayList<>();

    public static abstract class PluralRules {
        abstract int quantityForNumber(int n);
    }

    public static class PluralRules_Breton extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 0) {
                return 1;
            }
            if (count == 1) {
                return 2;
            }
            if (count == 2) {
                return 4;
            }
            if (count == 3) {
                return 8;
            }
            return count == 6 ? 16 : 0;
        }
    }

    public static class PluralRules_Czech extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 1) {
                return 2;
            }
            return (count < 2 || count > 4) ? 0 : 8;
        }
    }

    public static class PluralRules_French extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            return (count < 0 || count >= 2) ? 0 : 2;
        }
    }

    public static class PluralRules_Langi extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 0) {
                return 1;
            }
            return count == 1 ? 2 : 0;
        }
    }

    public static class PluralRules_None extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            return 0;
        }
    }

    public static class PluralRules_One extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            return count == 1 ? 2 : 0;
        }
    }

    public static class PluralRules_Tachelhit extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count < 0 || count > 1) {
                return (count < 2 || count > 10) ? 0 : 8;
            }
            return 2;
        }
    }

    public static class PluralRules_Two extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 1) {
                return 2;
            }
            return count == 2 ? 4 : 0;
        }
    }

    public static class PluralRules_Welsh extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 0) {
                return 1;
            }
            if (count == 1) {
                return 2;
            }
            if (count == 2) {
                return 4;
            }
            if (count == 3) {
                return 8;
            }
            return count == 6 ? 16 : 0;
        }
    }

    public static class PluralRules_Zero extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            return (count == 0 || count == 1) ? 2 : 0;
        }
    }

    private String stringForQuantity(int quantity) {
        return quantity != 1 ? quantity != 2 ? quantity != 4 ? quantity != 8 ? quantity != 16 ? "other" : "many" : "few" : "two" : "one" : "zero";
    }

    /* JADX INFO: Access modifiers changed from: private */
    class TimeZoneChangedReceiver extends BroadcastReceiver {
        private TimeZoneChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ApplicationLoader.applicationHandler.post(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$TimeZoneChangedReceiver$s7qq448FhfkKeX86gV7pBCESNko
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onReceive$0$LocaleController$TimeZoneChangedReceiver();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onReceive$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onReceive$0$LocaleController$TimeZoneChangedReceiver() {
            if (LocaleController.this.formatterDayMonth.getTimeZone().equals(TimeZone.getDefault())) {
                return;
            }
            LocaleController.getInstance().recreateFormatters();
        }
    }

    public static class LocaleInfo {
        public String baseLangCode;
        public int baseVersion;
        public boolean builtIn;
        public boolean isRtl;
        public String name;
        public String nameEnglish;
        public String pathToFile;
        public String pluralLangCode;
        public int serverIndex;
        public String shortName = "en";
        public int version;

        public String getSaveString() {
            String str = this.baseLangCode;
            if (str == null) {
                str = "";
            }
            TextUtils.isEmpty(this.pluralLangCode);
            return this.name + "|" + this.nameEnglish + "|" + this.shortName + "|" + this.pathToFile + "|" + this.version + "|" + str + "|" + this.pluralLangCode + "|" + (this.isRtl ? 1 : 0) + "|" + this.baseVersion + "|" + this.serverIndex;
        }

        public static LocaleInfo createWithString(String string) {
            LocaleInfo localeInfo = null;
            if (string != null && string.length() != 0) {
                String[] strArrSplit = string.split("\\|");
                if (strArrSplit.length >= 4) {
                    localeInfo = new LocaleInfo();
                    localeInfo.name = strArrSplit[0];
                    localeInfo.nameEnglish = strArrSplit[1];
                    localeInfo.shortName = strArrSplit[2].toLowerCase();
                    localeInfo.pathToFile = strArrSplit[3];
                    if (strArrSplit.length >= 5) {
                        localeInfo.version = Utilities.parseInt(strArrSplit[4]).intValue();
                    }
                    localeInfo.baseLangCode = strArrSplit.length >= 6 ? strArrSplit[5] : "";
                    localeInfo.pluralLangCode = strArrSplit.length >= 7 ? strArrSplit[6] : localeInfo.shortName;
                    if (strArrSplit.length >= 8) {
                        localeInfo.isRtl = Utilities.parseInt(strArrSplit[7]).intValue() == 1;
                    }
                    if (strArrSplit.length >= 9) {
                        localeInfo.baseVersion = Utilities.parseInt(strArrSplit[8]).intValue();
                    }
                    if (strArrSplit.length >= 10) {
                        localeInfo.serverIndex = Utilities.parseInt(strArrSplit[9]).intValue();
                    } else {
                        localeInfo.serverIndex = ConnectionsManager.DEFAULT_DATACENTER_ID;
                    }
                    if (!TextUtils.isEmpty(localeInfo.baseLangCode)) {
                        localeInfo.baseLangCode = localeInfo.baseLangCode.replace("-", "_");
                    }
                }
            }
            return localeInfo;
        }

        public File getPathToFile() {
            if (isRemote()) {
                return new File(ApplicationLoader.getFilesDirFixed(), "remote_" + this.shortName + ".xml");
            }
            if (isUnofficial()) {
                return new File(ApplicationLoader.getFilesDirFixed(), "unofficial_" + this.shortName + ".xml");
            }
            if (TextUtils.isEmpty(this.pathToFile)) {
                return null;
            }
            return new File(this.pathToFile);
        }

        public File getPathToBaseFile() {
            if (!isUnofficial()) {
                return null;
            }
            return new File(ApplicationLoader.getFilesDirFixed(), "unofficial_base_" + this.shortName + ".xml");
        }

        public String getKey() {
            if (this.pathToFile != null && !isRemote() && !isUnofficial()) {
                return "local_" + this.shortName;
            }
            if (isUnofficial()) {
                return "unofficial_" + this.shortName;
            }
            return this.shortName;
        }

        public boolean hasBaseLang() {
            return (!isUnofficial() || TextUtils.isEmpty(this.baseLangCode) || this.baseLangCode.equals(this.shortName)) ? false : true;
        }

        public boolean isRemote() {
            return "remote".equals(this.pathToFile);
        }

        public boolean isUnofficial() {
            return "unofficial".equals(this.pathToFile);
        }

        public boolean isLocal() {
            return (TextUtils.isEmpty(this.pathToFile) || isRemote() || isUnofficial()) ? false : true;
        }

        public boolean isBuiltIn() {
            return this.builtIn;
        }

        public String getLangCode() {
            return this.shortName.replace("_", "-");
        }

        public String getBaseLangCode() {
            String str = this.baseLangCode;
            return str == null ? "" : str.replace("_", "-");
        }
    }

    public static LocaleController getInstance() {
        LocaleController localeController = Instance;
        if (localeController == null) {
            synchronized (LocaleController.class) {
                localeController = Instance;
                if (localeController == null) {
                    localeController = new LocaleController();
                    Instance = localeController;
                }
            }
        }
        return localeController;
    }

    public LocaleController() {
        LocaleInfo languageFromDict;
        boolean z = false;
        addRules(new String[]{"bem", "brx", "da", "de", "el", "en", "eo", "es", "et", "fi", "fo", "gl", "he", "iw", "it", "nb", "nl", "nn", "no", "sv", "af", "bg", "bn", "ca", "eu", "fur", "fy", "gu", "ha", "is", "ku", "lb", "ml", "mr", "nah", "ne", "om", "or", "pa", "pap", "ps", "so", "sq", "sw", "ta", "te", "tk", "ur", "zu", "mn", "gsw", "chr", "rm", "pt", "an", "ast"}, new PluralRules_One());
        addRules(new String[]{"cs", "sk"}, new PluralRules_Czech());
        addRules(new String[]{"ff", "fr", "kab"}, new PluralRules_French());
        addRules(new String[]{"ru", "uk", "be"}, new PluralRules_Balkan());
        addRules(new String[]{"sr", "hr", "bs", "sh"}, new PluralRules_Serbian());
        addRules(new String[]{"lv"}, new PluralRules_Latvian());
        addRules(new String[]{"lt"}, new PluralRules_Lithuanian());
        addRules(new String[]{"pl"}, new PluralRules_Polish());
        addRules(new String[]{"ro", "mo"}, new PluralRules_Romanian());
        addRules(new String[]{"sl"}, new PluralRules_Slovenian());
        addRules(new String[]{"ar"}, new PluralRules_Arabic());
        addRules(new String[]{"mk"}, new PluralRules_Macedonian());
        addRules(new String[]{"cy"}, new PluralRules_Welsh());
        addRules(new String[]{"br"}, new PluralRules_Breton());
        addRules(new String[]{"lag"}, new PluralRules_Langi());
        addRules(new String[]{"shi"}, new PluralRules_Tachelhit());
        addRules(new String[]{"mt"}, new PluralRules_Maltese());
        addRules(new String[]{"ga", "se", "sma", "smi", "smj", "smn", "sms"}, new PluralRules_Two());
        addRules(new String[]{"ak", "am", "bh", "fil", "tl", "guw", "hi", "ln", "mg", "nso", "ti", "wa"}, new PluralRules_Zero());
        addRules(new String[]{"az", "bm", "fa", "ig", "hu", "ja", "kde", "kea", "ko", "my", "ses", "sg", "to", "tr", "vi", "wo", "yo", "zh", "bo", "dz", "id", "jv", "jw", "ka", "km", "kn", "ms", "th", "in"}, new PluralRules_None());
        LocaleInfo localeInfo = new LocaleInfo();
        localeInfo.name = "English";
        localeInfo.nameEnglish = "English";
        localeInfo.pluralLangCode = "en";
        localeInfo.shortName = "en";
        localeInfo.pathToFile = null;
        localeInfo.builtIn = true;
        this.languages.add(localeInfo);
        this.languagesDict.put(localeInfo.shortName, localeInfo);
        LocaleInfo localeInfo2 = new LocaleInfo();
        localeInfo2.name = "فارسی";
        localeInfo2.nameEnglish = "Farsi";
        localeInfo2.pluralLangCode = "fa";
        localeInfo2.shortName = "fa";
        localeInfo2.pathToFile = null;
        localeInfo2.builtIn = true;
        this.languages.add(localeInfo2);
        this.languagesDict.put(localeInfo2.shortName, localeInfo2);
        LocaleInfo localeInfo3 = new LocaleInfo();
        localeInfo3.name = "العربية";
        localeInfo3.nameEnglish = "Arabic";
        localeInfo3.pluralLangCode = "ar";
        localeInfo3.shortName = "ar";
        localeInfo3.pathToFile = null;
        localeInfo3.builtIn = true;
        localeInfo3.isRtl = true;
        this.languages.add(localeInfo3);
        this.languagesDict.put(localeInfo3.shortName, localeInfo3);
        loadOtherLanguages();
        if (this.remoteLanguages.isEmpty()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$ihFjK9eASak5QM3M_BK2_dg1lUo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$LocaleController();
                }
            });
        }
        for (int i = 0; i < this.otherLanguages.size(); i++) {
            LocaleInfo localeInfo4 = this.otherLanguages.get(i);
            this.languages.add(localeInfo4);
            this.languagesDict.put(localeInfo4.getKey(), localeInfo4);
        }
        for (int i2 = 0; i2 < this.remoteLanguages.size(); i2++) {
            LocaleInfo localeInfo5 = this.remoteLanguages.get(i2);
            LocaleInfo languageFromDict2 = getLanguageFromDict(localeInfo5.getKey());
            if (languageFromDict2 != null) {
                languageFromDict2.pathToFile = localeInfo5.pathToFile;
                languageFromDict2.version = localeInfo5.version;
                languageFromDict2.baseVersion = localeInfo5.baseVersion;
                languageFromDict2.serverIndex = localeInfo5.serverIndex;
                this.remoteLanguages.set(i2, languageFromDict2);
            } else {
                this.languages.add(localeInfo5);
                this.languagesDict.put(localeInfo5.getKey(), localeInfo5);
            }
        }
        for (int i3 = 0; i3 < this.unofficialLanguages.size(); i3++) {
            LocaleInfo localeInfo6 = this.unofficialLanguages.get(i3);
            LocaleInfo languageFromDict3 = getLanguageFromDict(localeInfo6.getKey());
            if (languageFromDict3 != null) {
                languageFromDict3.pathToFile = localeInfo6.pathToFile;
                languageFromDict3.version = localeInfo6.version;
                languageFromDict3.baseVersion = localeInfo6.baseVersion;
                languageFromDict3.serverIndex = localeInfo6.serverIndex;
                this.unofficialLanguages.set(i3, languageFromDict3);
            } else {
                this.languagesDict.put(localeInfo6.getKey(), localeInfo6);
            }
        }
        this.systemDefaultLocale = Locale.getDefault();
        is24HourFormat = DateFormat.is24HourFormat(ApplicationLoader.applicationContext);
        try {
            String string = MessagesController.getGlobalMainSettings().getString("language", null);
            if (string != null) {
                languageFromDict = getLanguageFromDict(string);
                if (languageFromDict != null) {
                    z = true;
                }
            } else {
                languageFromDict = null;
            }
            if (languageFromDict == null && this.systemDefaultLocale.getLanguage() != null) {
                languageFromDict = getLanguageFromDict(this.systemDefaultLocale.getLanguage());
            }
            if (languageFromDict == null && (languageFromDict = getLanguageFromDict(getLocaleString(this.systemDefaultLocale))) == null) {
                languageFromDict = getLanguageFromDict("en");
            }
            applyLanguage(languageFromDict, z, true, UserConfig.selectedAccount);
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            ApplicationLoader.applicationContext.registerReceiver(new TimeZoneChangedReceiver(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$OAL3gJx-aGJ4mThbCWmwEh-JiLg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1$LocaleController();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$LocaleController() {
        loadRemoteLanguages(UserConfig.selectedAccount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$LocaleController() {
        this.currentSystemLocale = getSystemLocaleStringIso639();
    }

    public LocaleInfo getLanguageFromDict(String key) {
        if (key == null) {
            return null;
        }
        return this.languagesDict.get(key.toLowerCase().replace("-", "_"));
    }

    private void addRules(String[] languages, PluralRules rules) {
        for (String str : languages) {
            this.allRules.put(str, rules);
        }
    }

    public Locale getSystemDefaultLocale() {
        return this.systemDefaultLocale;
    }

    public boolean isCurrentLocalLocale() {
        return this.currentLocaleInfo.isLocal();
    }

    public void reloadCurrentRemoteLocale(int currentAccount, String langCode, boolean force) {
        if (langCode != null) {
            langCode = langCode.replace("-", "_");
        }
        if (langCode != null) {
            LocaleInfo localeInfo = this.currentLocaleInfo;
            if (localeInfo == null) {
                return;
            }
            if (!langCode.equals(localeInfo.shortName) && !langCode.equals(this.currentLocaleInfo.baseLangCode)) {
                return;
            }
        }
        applyRemoteLanguage(this.currentLocaleInfo, langCode, force, currentAccount);
    }

    public void checkUpdateForCurrentRemoteLocale(int currentAccount, int version, int baseVersion) {
        LocaleInfo localeInfo = this.currentLocaleInfo;
        if (localeInfo != null) {
            if (localeInfo.isRemote() || this.currentLocaleInfo.isUnofficial()) {
                if (this.currentLocaleInfo.hasBaseLang()) {
                    LocaleInfo localeInfo2 = this.currentLocaleInfo;
                    if (localeInfo2.baseVersion < baseVersion) {
                        applyRemoteLanguage(localeInfo2, localeInfo2.baseLangCode, false, currentAccount);
                    }
                }
                LocaleInfo localeInfo3 = this.currentLocaleInfo;
                if (localeInfo3.version < version) {
                    applyRemoteLanguage(localeInfo3, localeInfo3.shortName, false, currentAccount);
                }
            }
        }
    }

    public String getLocaleString(Locale locale) {
        if (locale == null) {
            return "en";
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (language.length() == 0 && country.length() == 0) {
            return "en";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(language);
        if (country.length() > 0 || variant.length() > 0) {
            sb.append('_');
        }
        sb.append(country);
        if (variant.length() > 0) {
            sb.append('_');
        }
        sb.append(variant);
        return sb.toString();
    }

    public static String getSystemLocaleStringIso639() {
        Locale systemDefaultLocale = getInstance().getSystemDefaultLocale();
        if (systemDefaultLocale == null) {
            return "en";
        }
        String language = systemDefaultLocale.getLanguage();
        String country = systemDefaultLocale.getCountry();
        String variant = systemDefaultLocale.getVariant();
        if (language.length() == 0 && country.length() == 0) {
            return "en";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(language);
        if (country.length() > 0 || variant.length() > 0) {
            sb.append('-');
        }
        sb.append(country);
        if (variant.length() > 0) {
            sb.append('_');
        }
        sb.append(variant);
        return sb.toString();
    }

    public static String getLocaleStringIso639() {
        LocaleInfo localeInfo = getInstance().currentLocaleInfo;
        if (localeInfo != null) {
            return localeInfo.getLangCode();
        }
        Locale locale = getInstance().currentLocale;
        if (locale == null) {
            return "en";
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (language.length() == 0 && country.length() == 0) {
            return "en";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(language);
        if (country.length() > 0 || variant.length() > 0) {
            sb.append('-');
        }
        sb.append(country);
        if (variant.length() > 0) {
            sb.append('_');
        }
        sb.append(variant);
        return sb.toString();
    }

    public static String getLocaleAlias(String code) {
        if (code == null) {
            return null;
        }
        switch (code) {
        }
        return null;
    }

    public boolean applyLanguageFile(File file, int currentAccount) {
        try {
            HashMap<String, String> localeFileStrings = getLocaleFileStrings(file);
            String str = localeFileStrings.get("LanguageName");
            String str2 = localeFileStrings.get("LanguageNameInEnglish");
            String str3 = localeFileStrings.get("LanguageCode");
            if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && str3 != null && str3.length() > 0 && !str.contains("&") && !str.contains("|") && !str2.contains("&") && !str2.contains("|") && !str3.contains("&") && !str3.contains("|") && !str3.contains("/") && !str3.contains("\\")) {
                File file2 = new File(ApplicationLoader.getFilesDirFixed(), str3 + ".xml");
                if (!AndroidUtilities.copyFile(file, file2)) {
                    return false;
                }
                LocaleInfo languageFromDict = getLanguageFromDict("local_" + str3.toLowerCase());
                if (languageFromDict == null) {
                    languageFromDict = new LocaleInfo();
                    languageFromDict.name = str;
                    languageFromDict.nameEnglish = str2;
                    String lowerCase = str3.toLowerCase();
                    languageFromDict.shortName = lowerCase;
                    languageFromDict.pluralLangCode = lowerCase;
                    languageFromDict.pathToFile = file2.getAbsolutePath();
                    this.languages.add(languageFromDict);
                    this.languagesDict.put(languageFromDict.getKey(), languageFromDict);
                    this.otherLanguages.add(languageFromDict);
                    saveOtherLanguages();
                }
                this.localeValues = localeFileStrings;
                applyLanguage(languageFromDict, true, false, true, false, currentAccount);
                return true;
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
        }
        return false;
    }

    private void saveOtherLanguages() {
        SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("langconfig", 0).edit();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.otherLanguages.size(); i++) {
            String saveString = this.otherLanguages.get(i).getSaveString();
            if (saveString != null) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append(saveString);
            }
        }
        editorEdit.putString("locales", sb.toString());
        sb.setLength(0);
        for (int i2 = 0; i2 < this.remoteLanguages.size(); i2++) {
            String saveString2 = this.remoteLanguages.get(i2).getSaveString();
            if (saveString2 != null) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append(saveString2);
            }
        }
        editorEdit.putString("remote", sb.toString());
        sb.setLength(0);
        for (int i3 = 0; i3 < this.unofficialLanguages.size(); i3++) {
            String saveString3 = this.unofficialLanguages.get(i3).getSaveString();
            if (saveString3 != null) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append(saveString3);
            }
        }
        editorEdit.putString("unofficial", sb.toString());
        editorEdit.commit();
    }

    public boolean deleteLanguage(LocaleInfo localeInfo, int currentAccount) {
        if (localeInfo.pathToFile == null || (localeInfo.isRemote() && localeInfo.serverIndex != Integer.MAX_VALUE)) {
            return false;
        }
        if (this.currentLocaleInfo == localeInfo) {
            LocaleInfo languageFromDict = this.systemDefaultLocale.getLanguage() != null ? getLanguageFromDict(this.systemDefaultLocale.getLanguage()) : null;
            if (languageFromDict == null) {
                languageFromDict = getLanguageFromDict(getLocaleString(this.systemDefaultLocale));
            }
            if (languageFromDict == null) {
                languageFromDict = getLanguageFromDict("en");
            }
            applyLanguage(languageFromDict, true, false, currentAccount);
        }
        this.unofficialLanguages.remove(localeInfo);
        this.remoteLanguages.remove(localeInfo);
        this.remoteLanguagesDict.remove(localeInfo.getKey());
        this.otherLanguages.remove(localeInfo);
        this.languages.remove(localeInfo);
        this.languagesDict.remove(localeInfo.getKey());
        new File(localeInfo.pathToFile).delete();
        saveOtherLanguages();
        return true;
    }

    private void loadOtherLanguages() {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("langconfig", 0);
        String string = sharedPreferences.getString("locales", null);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("&")) {
                LocaleInfo localeInfoCreateWithString = LocaleInfo.createWithString(str);
                if (localeInfoCreateWithString != null) {
                    this.otherLanguages.add(localeInfoCreateWithString);
                }
            }
        }
        String string2 = sharedPreferences.getString("remote", null);
        if (!TextUtils.isEmpty(string2)) {
            for (String str2 : string2.split("&")) {
                LocaleInfo localeInfoCreateWithString2 = LocaleInfo.createWithString(str2);
                localeInfoCreateWithString2.shortName = localeInfoCreateWithString2.shortName.replace("-", "_");
                if (!this.remoteLanguagesDict.containsKey(localeInfoCreateWithString2.getKey())) {
                    this.remoteLanguages.add(localeInfoCreateWithString2);
                    this.remoteLanguagesDict.put(localeInfoCreateWithString2.getKey(), localeInfoCreateWithString2);
                }
            }
        }
        String string3 = sharedPreferences.getString("unofficial", null);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        for (String str3 : string3.split("&")) {
            LocaleInfo localeInfoCreateWithString3 = LocaleInfo.createWithString(str3);
            if (localeInfoCreateWithString3 != null) {
                localeInfoCreateWithString3.shortName = localeInfoCreateWithString3.shortName.replace("-", "_");
                this.unofficialLanguages.add(localeInfoCreateWithString3);
            }
        }
    }

    private HashMap<String, String> getLocaleFileStrings(File file) {
        return getLocaleFileStrings(file, false);
    }

    private HashMap<String, String> getLocaleFileStrings(File file, boolean preserveEscapes) throws Throwable {
        this.reloadLastFile = false;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return new HashMap<>();
                }
                HashMap<String, String> map = new HashMap<>();
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    xmlPullParserNewPullParser.setInput(fileInputStream2, "UTF-8");
                    String attributeValue = null;
                    String name = null;
                    String text = null;
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 2) {
                            name = xmlPullParserNewPullParser.getName();
                            if (xmlPullParserNewPullParser.getAttributeCount() > 0) {
                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(0);
                            }
                        } else if (eventType == 4) {
                            if (attributeValue != null && (text = xmlPullParserNewPullParser.getText()) != null) {
                                String strTrim = text.trim();
                                if (preserveEscapes) {
                                    text = strTrim.replace("<", "&lt;").replace(">", "&gt;").replace("'", "\\'").replace("& ", "&amp; ");
                                } else {
                                    String strReplace = strTrim.replace("\\n", "\n").replace("\\", "");
                                    text = strReplace.replace("&lt;", "<");
                                    if (!this.reloadLastFile && !text.equals(strReplace)) {
                                        this.reloadLastFile = true;
                                    }
                                }
                            }
                        } else if (eventType == 3) {
                            attributeValue = null;
                            name = null;
                            text = null;
                        }
                        if (name != null && name.equals("string") && text != null && attributeValue != null && text.length() != 0 && attributeValue.length() != 0) {
                            map.put(attributeValue, text);
                            attributeValue = null;
                            name = null;
                            text = null;
                        }
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    return map;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    FileLog.e(e);
                    this.reloadLastFile = true;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            FileLog.e(e3);
                        }
                    }
                    return new HashMap<>();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            FileLog.e(e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void applyLanguage(LocaleInfo localeInfo, boolean override, boolean init, final int currentAccount) {
        applyLanguage(localeInfo, override, init, false, false, currentAccount);
    }

    public void applyLanguage(final LocaleInfo localeInfo, boolean override, boolean init, boolean fromFile, final boolean force, final int currentAccount) {
        String[] strArrSplit;
        Locale locale;
        if (localeInfo == null) {
            return;
        }
        boolean zHasBaseLang = localeInfo.hasBaseLang();
        File pathToFile = localeInfo.getPathToFile();
        File pathToBaseFile = localeInfo.getPathToBaseFile();
        if (!init) {
            ConnectionsManager.setLangCode(localeInfo.getLangCode());
        }
        if (getLanguageFromDict(localeInfo.getKey()) == null) {
            if (localeInfo.isRemote()) {
                this.remoteLanguages.add(localeInfo);
                this.remoteLanguagesDict.put(localeInfo.getKey(), localeInfo);
                this.languages.add(localeInfo);
                this.languagesDict.put(localeInfo.getKey(), localeInfo);
                saveOtherLanguages();
            } else if (localeInfo.isUnofficial()) {
                this.unofficialLanguages.add(localeInfo);
                this.languagesDict.put(localeInfo.getKey(), localeInfo);
                saveOtherLanguages();
            }
        }
        if ((localeInfo.isRemote() || localeInfo.isUnofficial()) && (force || !pathToFile.exists() || (zHasBaseLang && !pathToBaseFile.exists()))) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reload locale because one of file doesn't exist" + pathToFile + " " + pathToBaseFile);
            }
            if (init) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$hejjNnj9IPAkSQ7JIcPjkPdszWA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$applyLanguage$2$LocaleController(localeInfo, currentAccount);
                    }
                });
            } else {
                applyRemoteLanguage(localeInfo, null, true, currentAccount);
            }
        }
        try {
            if (!TextUtils.isEmpty(localeInfo.pluralLangCode)) {
                strArrSplit = localeInfo.pluralLangCode.split("_");
            } else if (!TextUtils.isEmpty(localeInfo.baseLangCode)) {
                strArrSplit = localeInfo.baseLangCode.split("_");
            } else {
                strArrSplit = localeInfo.shortName.split("_");
            }
            if (strArrSplit.length == 1) {
                locale = new Locale(strArrSplit[0]);
            } else {
                locale = new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (override) {
                this.languageOverride = localeInfo.shortName;
                SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
                editorEdit.putString("language", localeInfo.getKey());
                editorEdit.commit();
            }
            if (pathToFile == null) {
                this.localeValues.clear();
            } else if (!fromFile) {
                HashMap<String, String> localeFileStrings = getLocaleFileStrings(zHasBaseLang ? localeInfo.getPathToBaseFile() : localeInfo.getPathToFile());
                this.localeValues = localeFileStrings;
                if (zHasBaseLang) {
                    localeFileStrings.putAll(getLocaleFileStrings(localeInfo.getPathToFile()));
                }
            }
            this.currentLocale = locale;
            this.currentLocaleInfo = localeInfo;
            if (!TextUtils.isEmpty(localeInfo.pluralLangCode)) {
                this.currentPluralRules = this.allRules.get(this.currentLocaleInfo.pluralLangCode);
            }
            if (this.currentPluralRules == null) {
                PluralRules pluralRules = this.allRules.get(strArrSplit[0]);
                this.currentPluralRules = pluralRules;
                if (pluralRules == null) {
                    PluralRules pluralRules2 = this.allRules.get(this.currentLocale.getLanguage());
                    this.currentPluralRules = pluralRules2;
                    if (pluralRules2 == null) {
                        this.currentPluralRules = new PluralRules_None();
                    }
                }
            }
            this.changingConfiguration = true;
            Locale.setDefault(this.currentLocale);
            Configuration configuration = new Configuration();
            configuration.locale = this.currentLocale;
            ApplicationLoader.applicationContext.getResources().updateConfiguration(configuration, ApplicationLoader.applicationContext.getResources().getDisplayMetrics());
            this.changingConfiguration = false;
            if (this.reloadLastFile) {
                if (init) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$_QuMN8MWMtQBzGHfBnluWdJiIZQ
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$applyLanguage$3$LocaleController(currentAccount, force);
                        }
                    });
                } else {
                    reloadCurrentRemoteLocale(currentAccount, null, force);
                }
                this.reloadLastFile = false;
            }
        } catch (Exception e) {
            FileLog.e(e);
            this.changingConfiguration = false;
        }
        recreateFormatters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyLanguage$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyLanguage$2$LocaleController(LocaleInfo localeInfo, int i) {
        applyRemoteLanguage(localeInfo, null, true, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyLanguage$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyLanguage$3$LocaleController(int i, boolean z) {
        reloadCurrentRemoteLocale(i, null, z);
    }

    public LocaleInfo getCurrentLocaleInfo() {
        return this.currentLocaleInfo;
    }

    public Locale getCurrentLocale() {
        return this.currentLocale;
    }

    public static String getCurrentLanguageName() {
        LocaleInfo localeInfo = getInstance().currentLocaleInfo;
        return (localeInfo == null || TextUtils.isEmpty(localeInfo.name)) ? getString("LanguageName", R.string.LanguageName) : localeInfo.name;
    }

    private String getStringInternal(String key, int res) {
        return getStringInternal(key, null, res);
    }

    private String getStringInternal(String key, String fallback, int res) {
        String string = BuildVars.USE_CLOUD_STRINGS ? this.localeValues.get(key) : null;
        if (string == null) {
            if (BuildVars.USE_CLOUD_STRINGS && fallback != null) {
                string = this.localeValues.get(fallback);
            }
            if (string == null) {
                try {
                    string = ApplicationLoader.applicationContext.getString(res);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
        if (string != null) {
            return string;
        }
        return "LOC_ERR:" + key;
    }

    public static String getServerString(String key) {
        int identifier;
        String str = getInstance().localeValues.get(key);
        return (str != null || (identifier = ApplicationLoader.applicationContext.getResources().getIdentifier(key, "string", ApplicationLoader.applicationContext.getPackageName())) == 0) ? str : ApplicationLoader.applicationContext.getString(identifier);
    }

    public static String getString(String key, int res) {
        return getInstance().getStringInternal(key, res);
    }

    public static String getString(String key, String fallback, int res) {
        return getInstance().getStringInternal(key, fallback, res);
    }

    public static String getString(String key) {
        if (TextUtils.isEmpty(key)) {
            return "LOC_ERR:" + key;
        }
        int identifier = ApplicationLoader.applicationContext.getResources().getIdentifier(key, "string", ApplicationLoader.applicationContext.getPackageName());
        if (identifier != 0) {
            return getString(key, identifier);
        }
        return getServerString(key);
    }

    public static String getPluralString(String key, int plural) {
        if (key == null || key.length() == 0 || getInstance().currentPluralRules == null) {
            return "LOC_ERR:" + key;
        }
        String str = key + "_" + getInstance().stringForQuantity(getInstance().currentPluralRules.quantityForNumber(plural));
        return getString(str, key + "_other", ApplicationLoader.applicationContext.getResources().getIdentifier(str, "string", ApplicationLoader.applicationContext.getPackageName()));
    }

    public static String formatPluralString(String key, int plural) {
        if (key == null || key.length() == 0 || getInstance().currentPluralRules == null) {
            return "LOC_ERR:" + key;
        }
        String str = key + "_" + getInstance().stringForQuantity(getInstance().currentPluralRules.quantityForNumber(plural));
        return AndroidUtilities.fixNumbers(formatString(str, key + "_other", ApplicationLoader.applicationContext.getResources().getIdentifier(str, "string", ApplicationLoader.applicationContext.getPackageName()), Integer.valueOf(plural)));
    }

    public static String formatPluralStringComma(String key, int plural) {
        if (key != null) {
            try {
                if (key.length() != 0 && getInstance().currentPluralRules != null) {
                    String str = key + "_" + getInstance().stringForQuantity(getInstance().currentPluralRules.quantityForNumber(plural));
                    StringBuilder sb = new StringBuilder(String.format(Locale.US, "%d", Integer.valueOf(plural)));
                    for (int length = sb.length() - 3; length > 0; length -= 3) {
                        sb.insert(length, ',');
                    }
                    String string = BuildVars.USE_CLOUD_STRINGS ? getInstance().localeValues.get(str) : null;
                    if (string == null) {
                        string = BuildVars.USE_CLOUD_STRINGS ? getInstance().localeValues.get(key + "_other") : null;
                    }
                    if (string == null) {
                        string = ApplicationLoader.applicationContext.getString(ApplicationLoader.applicationContext.getResources().getIdentifier(str, "string", ApplicationLoader.applicationContext.getPackageName()));
                    }
                    String strReplace = string.replace("%1$d", "%1$s");
                    return getInstance().currentLocale != null ? String.format(getInstance().currentLocale, strReplace, sb) : String.format(strReplace, sb);
                }
            } catch (Exception e) {
                FileLog.e(e);
                return "LOC_ERR: " + key;
            }
        }
        return "LOC_ERR:" + key;
    }

    public static String formatString(String key, int res, Object... args) {
        return formatString(key, null, res, args);
    }

    public static String formatString(String key, String fallback, int res, Object... args) {
        String str;
        try {
            String string = BuildVars.USE_CLOUD_STRINGS ? getInstance().localeValues.get(key) : null;
            if (string == null) {
                if (BuildVars.USE_CLOUD_STRINGS && fallback != null) {
                    string = getInstance().localeValues.get(fallback);
                }
                if (string == null) {
                    string = ApplicationLoader.applicationContext.getString(res);
                }
            }
            if (getInstance().currentLocale != null) {
                str = String.format(getInstance().currentLocale, string, args);
            } else {
                str = String.format(string, args);
            }
            return isRTL ? AndroidUtilities.fixNumbers(str) : str;
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR: " + key;
        }
    }

    public static String formatTTLString(int ttl) {
        if (ttl < 60) {
            return formatPluralString("Seconds", ttl);
        }
        if (ttl < 3600) {
            return formatPluralString("Minutes", ttl / 60);
        }
        if (ttl < 86400) {
            return formatPluralString("Hours", (ttl / 60) / 60);
        }
        if (ttl < 604800) {
            return formatPluralString("Days", ((ttl / 60) / 60) / 24);
        }
        if (ttl >= 2592000 && ttl <= 2678400) {
            return formatPluralString("Months", (((ttl / 60) / 60) / 24) / 30);
        }
        int i = ((ttl / 60) / 60) / 24;
        return ttl % 7 == 0 ? formatPluralString("Weeks", i / 7) : String.format("%s %s", formatPluralString("Weeks", i / 7), formatPluralString("Days", i % 7));
    }

    public static String fixNumbers(CharSequence numbers) {
        StringBuilder sb = new StringBuilder(numbers);
        int length = sb.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = sb.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '.' && cCharAt != ',') {
                int length2 = 0;
                while (length2 < otherNumbers.length) {
                    int i2 = 0;
                    while (true) {
                        char[][] cArr = otherNumbers;
                        if (i2 >= cArr[length2].length) {
                            break;
                        }
                        if (cCharAt == cArr[length2][i2]) {
                            sb.setCharAt(i, defaultNumbers[i2]);
                            length2 = otherNumbers.length;
                            break;
                        }
                        i2++;
                    }
                    length2++;
                }
            }
        }
        return sb.toString();
    }

    public String formatCurrencyString(long amount, String type) {
        return formatCurrencyString(amount, true, true, false, type);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String formatCurrencyString(long amount, boolean fixAnything, boolean withExp, boolean editText, String type) {
        double d;
        int length;
        String upperCase = type.toUpperCase();
        boolean z = amount < 0;
        long jAbs = Math.abs(amount);
        Currency currency = Currency.getInstance(upperCase);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case 65726:
                if (upperCase.equals("BHD")) {
                    c = 0;
                    break;
                }
                break;
            case 65759:
                if (upperCase.equals("BIF")) {
                    c = 1;
                    break;
                }
                break;
            case 66267:
                if (upperCase.equals("BYR")) {
                    c = 2;
                    break;
                }
                break;
            case 66813:
                if (upperCase.equals("CLF")) {
                    c = 3;
                    break;
                }
                break;
            case 66823:
                if (upperCase.equals("CLP")) {
                    c = 4;
                    break;
                }
                break;
            case 67122:
                if (upperCase.equals("CVE")) {
                    c = 5;
                    break;
                }
                break;
            case 67712:
                if (upperCase.equals("DJF")) {
                    c = 6;
                    break;
                }
                break;
            case 70719:
                if (upperCase.equals("GNF")) {
                    c = 7;
                    break;
                }
                break;
            case 72732:
                if (upperCase.equals("IQD")) {
                    c = '\b';
                    break;
                }
                break;
            case 72777:
                if (upperCase.equals("IRR")) {
                    c = '\t';
                    break;
                }
                break;
            case 72801:
                if (upperCase.equals("ISK")) {
                    c = '\n';
                    break;
                }
                break;
            case 73631:
                if (upperCase.equals("JOD")) {
                    c = 11;
                    break;
                }
                break;
            case 73683:
                if (upperCase.equals("JPY")) {
                    c = '\f';
                    break;
                }
                break;
            case 74532:
                if (upperCase.equals("KMF")) {
                    c = '\r';
                    break;
                }
                break;
            case 74704:
                if (upperCase.equals("KRW")) {
                    c = 14;
                    break;
                }
                break;
            case 74840:
                if (upperCase.equals("KWD")) {
                    c = 15;
                    break;
                }
                break;
            case 75863:
                if (upperCase.equals("LYD")) {
                    c = 16;
                    break;
                }
                break;
            case 76263:
                if (upperCase.equals("MGA")) {
                    c = 17;
                    break;
                }
                break;
            case 76618:
                if (upperCase.equals("MRO")) {
                    c = 18;
                    break;
                }
                break;
            case 78388:
                if (upperCase.equals("OMR")) {
                    c = 19;
                    break;
                }
                break;
            case 79710:
                if (upperCase.equals("PYG")) {
                    c = 20;
                    break;
                }
                break;
            case 81569:
                if (upperCase.equals("RWF")) {
                    c = 21;
                    break;
                }
                break;
            case 83210:
                if (upperCase.equals("TND")) {
                    c = 22;
                    break;
                }
                break;
            case 83974:
                if (upperCase.equals("UGX")) {
                    c = 23;
                    break;
                }
                break;
            case 84517:
                if (upperCase.equals("UYI")) {
                    c = 24;
                    break;
                }
                break;
            case 85132:
                if (upperCase.equals("VND")) {
                    c = 25;
                    break;
                }
                break;
            case 85367:
                if (upperCase.equals("VUV")) {
                    c = 26;
                    break;
                }
                break;
            case 86653:
                if (upperCase.equals("XAF")) {
                    c = 27;
                    break;
                }
                break;
            case 87087:
                if (upperCase.equals("XOF")) {
                    c = 28;
                    break;
                }
                break;
            case 87118:
                if (upperCase.equals("XPF")) {
                    c = 29;
                    break;
                }
                break;
        }
        String str = " %.2f";
        switch (c) {
            case 0:
            case '\b':
            case 11:
            case 15:
            case 16:
            case 19:
            case 22:
                double d2 = jAbs;
                Double.isNaN(d2);
                d = d2 / 1000.0d;
                str = " %.3f";
                break;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\n':
            case '\f':
            case '\r':
            case 14:
            case 17:
            case 20:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                d = jAbs;
                str = " %.0f";
                break;
            case 3:
                double d3 = jAbs;
                Double.isNaN(d3);
                d = d3 / 10000.0d;
                str = " %.4f";
                break;
            case '\t':
                double d4 = jAbs / 100.0f;
                if (fixAnything && jAbs % 100 == 0) {
                    str = " %.0f";
                }
                d = d4;
                break;
            case 18:
                double d5 = jAbs;
                Double.isNaN(d5);
                d = d5 / 10.0d;
                str = " %.1f";
                break;
            default:
                double d6 = jAbs;
                Double.isNaN(d6);
                d = d6 / 100.0d;
                break;
        }
        String str2 = withExp ? str : " %.0f";
        if (currency != null) {
            Locale locale = this.currentLocale;
            if (locale == null) {
                locale = this.systemDefaultLocale;
            }
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(currency);
            if (editText) {
                currencyInstance.setGroupingUsed(false);
            }
            if (!withExp || (fixAnything && upperCase.equals("IRR"))) {
                currencyInstance.setMaximumFractionDigits(0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "-" : "");
            sb.append(currencyInstance.format(d));
            String string = sb.toString();
            int iIndexOf = string.indexOf(upperCase);
            if (iIndexOf < 0 || (length = iIndexOf + upperCase.length()) >= string.length() || string.charAt(length) == ' ') {
                return string;
            }
            return string.substring(0, length) + " " + string.substring(length);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "-" : "");
        sb2.append(String.format(Locale.US, upperCase + str2, Double.valueOf(d)));
        return sb2.toString();
    }

    public static int getCurrencyExpDivider(String type) {
        type.hashCode();
        switch (type) {
            case "BHD":
            case "IQD":
            case "JOD":
            case "KWD":
            case "LYD":
            case "OMR":
            case "TND":
                return 1000;
            case "BIF":
            case "BYR":
            case "CLP":
            case "CVE":
            case "DJF":
            case "GNF":
            case "ISK":
            case "JPY":
            case "KMF":
            case "KRW":
            case "MGA":
            case "PYG":
            case "RWF":
            case "UGX":
            case "UYI":
            case "VND":
            case "VUV":
            case "XAF":
            case "XOF":
            case "XPF":
                return 1;
            case "CLF":
                return 10000;
            case "MRO":
                return 10;
            default:
                return 100;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String formatCurrencyDecimalString(long amount, String type, boolean inludeType) {
        String str;
        double d;
        String upperCase = type.toUpperCase();
        long jAbs = Math.abs(amount);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case 65726:
                if (upperCase.equals("BHD")) {
                    c = 0;
                    break;
                }
                break;
            case 65759:
                if (upperCase.equals("BIF")) {
                    c = 1;
                    break;
                }
                break;
            case 66267:
                if (upperCase.equals("BYR")) {
                    c = 2;
                    break;
                }
                break;
            case 66813:
                if (upperCase.equals("CLF")) {
                    c = 3;
                    break;
                }
                break;
            case 66823:
                if (upperCase.equals("CLP")) {
                    c = 4;
                    break;
                }
                break;
            case 67122:
                if (upperCase.equals("CVE")) {
                    c = 5;
                    break;
                }
                break;
            case 67712:
                if (upperCase.equals("DJF")) {
                    c = 6;
                    break;
                }
                break;
            case 70719:
                if (upperCase.equals("GNF")) {
                    c = 7;
                    break;
                }
                break;
            case 72732:
                if (upperCase.equals("IQD")) {
                    c = '\b';
                    break;
                }
                break;
            case 72777:
                if (upperCase.equals("IRR")) {
                    c = '\t';
                    break;
                }
                break;
            case 72801:
                if (upperCase.equals("ISK")) {
                    c = '\n';
                    break;
                }
                break;
            case 73631:
                if (upperCase.equals("JOD")) {
                    c = 11;
                    break;
                }
                break;
            case 73683:
                if (upperCase.equals("JPY")) {
                    c = '\f';
                    break;
                }
                break;
            case 74532:
                if (upperCase.equals("KMF")) {
                    c = '\r';
                    break;
                }
                break;
            case 74704:
                if (upperCase.equals("KRW")) {
                    c = 14;
                    break;
                }
                break;
            case 74840:
                if (upperCase.equals("KWD")) {
                    c = 15;
                    break;
                }
                break;
            case 75863:
                if (upperCase.equals("LYD")) {
                    c = 16;
                    break;
                }
                break;
            case 76263:
                if (upperCase.equals("MGA")) {
                    c = 17;
                    break;
                }
                break;
            case 76618:
                if (upperCase.equals("MRO")) {
                    c = 18;
                    break;
                }
                break;
            case 78388:
                if (upperCase.equals("OMR")) {
                    c = 19;
                    break;
                }
                break;
            case 79710:
                if (upperCase.equals("PYG")) {
                    c = 20;
                    break;
                }
                break;
            case 81569:
                if (upperCase.equals("RWF")) {
                    c = 21;
                    break;
                }
                break;
            case 83210:
                if (upperCase.equals("TND")) {
                    c = 22;
                    break;
                }
                break;
            case 83974:
                if (upperCase.equals("UGX")) {
                    c = 23;
                    break;
                }
                break;
            case 84517:
                if (upperCase.equals("UYI")) {
                    c = 24;
                    break;
                }
                break;
            case 85132:
                if (upperCase.equals("VND")) {
                    c = 25;
                    break;
                }
                break;
            case 85367:
                if (upperCase.equals("VUV")) {
                    c = 26;
                    break;
                }
                break;
            case 86653:
                if (upperCase.equals("XAF")) {
                    c = 27;
                    break;
                }
                break;
            case 87087:
                if (upperCase.equals("XOF")) {
                    c = 28;
                    break;
                }
                break;
            case 87118:
                if (upperCase.equals("XPF")) {
                    c = 29;
                    break;
                }
                break;
        }
        str = " %.2f";
        switch (c) {
            case 0:
            case '\b':
            case 11:
            case 15:
            case 16:
            case 19:
            case 22:
                double d2 = jAbs;
                Double.isNaN(d2);
                d = d2 / 1000.0d;
                str = " %.3f";
                break;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\n':
            case '\f':
            case '\r':
            case 14:
            case 17:
            case 20:
            case 21:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                d = jAbs;
                str = " %.0f";
                break;
            case 3:
                double d3 = jAbs;
                Double.isNaN(d3);
                d = d3 / 10000.0d;
                str = " %.4f";
                break;
            case '\t':
                double d4 = jAbs / 100.0f;
                str = jAbs % 100 == 0 ? " %.0f" : " %.2f";
                d = d4;
                break;
            case 18:
                double d5 = jAbs;
                Double.isNaN(d5);
                d = d5 / 10.0d;
                str = " %.1f";
                break;
            default:
                double d6 = jAbs;
                Double.isNaN(d6);
                d = d6 / 100.0d;
                break;
        }
        Locale locale = Locale.US;
        if (!inludeType) {
            upperCase = "" + str;
        }
        return String.format(locale, upperCase, Double.valueOf(d)).trim();
    }

    public static String formatStringSimple(String string, Object... args) {
        try {
            if (getInstance().currentLocale != null) {
                return String.format(getInstance().currentLocale, string, args);
            }
            return String.format(string, args);
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR: " + string;
        }
    }

    public static String formatDuration(int duration) {
        if (duration <= 0) {
            return formatPluralString("Seconds", 0);
        }
        int i = duration / 3600;
        int i2 = (duration / 60) % 60;
        int i3 = duration % 60;
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            sb.append(formatPluralString("Hours", i));
        }
        if (i2 > 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(formatPluralString("Minutes", i2));
        }
        if (i3 > 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(formatPluralString("Seconds", i3));
        }
        return sb.toString();
    }

    public static String formatCallDuration(int duration) {
        if (duration <= 3600) {
            if (duration > 60) {
                return formatPluralString("Minutes", duration / 60);
            }
            return formatPluralString("Seconds", duration);
        }
        String pluralString = formatPluralString("Hours", duration / 3600);
        int i = (duration % 3600) / 60;
        if (i <= 0) {
            return pluralString;
        }
        return pluralString + ", " + formatPluralString("Minutes", i);
    }

    public void onDeviceConfigurationChange(Configuration newConfig) {
        if (this.changingConfiguration) {
            return;
        }
        is24HourFormat = DateFormat.is24HourFormat(ApplicationLoader.applicationContext);
        Locale locale = newConfig.locale;
        this.systemDefaultLocale = locale;
        if (this.languageOverride != null) {
            LocaleInfo localeInfo = this.currentLocaleInfo;
            this.currentLocaleInfo = null;
            applyLanguage(localeInfo, false, false, UserConfig.selectedAccount);
        } else if (locale != null) {
            String displayName = locale.getDisplayName();
            String displayName2 = this.currentLocale.getDisplayName();
            if (displayName != null && displayName2 != null && !displayName.equals(displayName2)) {
                recreateFormatters();
            }
            this.currentLocale = locale;
            LocaleInfo localeInfo2 = this.currentLocaleInfo;
            if (localeInfo2 != null && !TextUtils.isEmpty(localeInfo2.pluralLangCode)) {
                this.currentPluralRules = this.allRules.get(this.currentLocaleInfo.pluralLangCode);
            }
            if (this.currentPluralRules == null) {
                PluralRules pluralRules = this.allRules.get(this.currentLocale.getLanguage());
                this.currentPluralRules = pluralRules;
                if (pluralRules == null) {
                    this.currentPluralRules = this.allRules.get("en");
                }
            }
        }
        String systemLocaleStringIso639 = getSystemLocaleStringIso639();
        String str = this.currentSystemLocale;
        if (str == null || systemLocaleStringIso639.equals(str)) {
            return;
        }
        this.currentSystemLocale = systemLocaleStringIso639;
        ConnectionsManager.setSystemLangCode(systemLocaleStringIso639);
    }

    public static String formatDateChat(long date) {
        return formatDateChat(date, false);
    }

    public static String formatDateChat(long date, boolean checkYear) throws IOException {
        if (getInstance().currentLocale.getLanguage().toLowerCase().equals("fa")) {
            try {
                int i = new JalaliCalendar(System.currentTimeMillis()).year;
                JalaliCalendar jalaliCalendar = new JalaliCalendar(date * 1000);
                int i2 = jalaliCalendar.year;
                if (i == i2) {
                    return PersianDateFormatter.getChatPersianDate(jalaliCalendar.weekDay, jalaliCalendar.day, jalaliCalendar.month);
                }
                return PersianDateFormatter.getChatPersianFullDate(jalaliCalendar.day, jalaliCalendar.month, i2);
            } catch (Exception e) {
                FileLog.e("TSMS", e);
                return "LOC_ERR: formatDateChat";
            }
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i3 = calendar.get(1);
            long j = date * 1000;
            calendar.setTimeInMillis(j);
            if ((checkYear && i3 == calendar.get(1)) || (!checkYear && Math.abs(System.currentTimeMillis() - j) < 31536000000L)) {
                return getInstance().chatDate.format(j);
            }
            return getInstance().chatFullDate.format(j);
        } catch (Exception e2) {
            FileLog.e(e2);
            return "LOC_ERR: formatDateChat";
        }
    }

    public static String formatTrendsDate(long date) throws IOException {
        if (getInstance().currentLocale.getLanguage().toLowerCase().equals("fa")) {
            try {
                long j = date * 1000;
                JalaliCalendar jalaliCalendar = new JalaliCalendar(j);
                return PersianDateFormatter.getPersianFullDate(jalaliCalendar.weekDay, jalaliCalendar.day, jalaliCalendar.month, jalaliCalendar.year, getInstance().formatterDay.format(new Date(j)));
            } catch (Exception e) {
                FileLog.e("TSMS", e);
                return "LOC_ERR: formatTrendsDate";
            }
        }
        try {
            long j2 = date * 1000;
            return formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterDayMonth.format(new Date(j2)), getInstance().formatterDay.format(new Date(j2)));
        } catch (Exception e2) {
            FileLog.e("TSMS", e2);
            return "LOC_ERR: formatTrendsDate";
        }
    }

    public static String formatMediaDate(long date) throws IOException {
        if (getInstance().currentLocale.getLanguage().toLowerCase().equals("fa")) {
            try {
                JalaliCalendar jalaliCalendar = new JalaliCalendar(date * 1000);
                return PersianDateFormatter.getPersianFormatterMonthYear(jalaliCalendar.year, jalaliCalendar.month);
            } catch (Exception e) {
                FileLog.e("TSMS", e);
                return "LOC_ERR: formatMediaDate";
            }
        }
        try {
            return getInstance().formatterMonthYear.format(date * 1000);
        } catch (Exception e2) {
            FileLog.e("TSMS", e2);
            return "LOC_ERR: formatMediaDate";
        }
    }

    public static String formatDate(long date) {
        long j = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(6);
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j);
            int i3 = calendar.get(6);
            int i4 = calendar.get(1);
            if (i3 == i && i2 == i4) {
                return getInstance().formatterDay.format(new Date(j));
            }
            if (i3 + 1 == i && i2 == i4) {
                return getString("Yesterday", R.string.Yesterday);
            }
            if (Math.abs(System.currentTimeMillis() - j) < 31536000000L) {
                return getInstance().formatterDayMonth.format(new Date(j));
            }
            return getInstance().formatterYear.format(new Date(j));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR: formatDate";
        }
    }

    public static String formatDateAudio(long date, boolean shortFormat) {
        long j = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(6);
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j);
            int i3 = calendar.get(6);
            int i4 = calendar.get(1);
            return (i3 == i && i2 == i4) ? shortFormat ? formatString("TodayAtFormatted", R.string.TodayAtFormatted, getInstance().formatterDay.format(new Date(j))) : formatString("TodayAtFormattedWithToday", R.string.TodayAtFormattedWithToday, getInstance().formatterDay.format(new Date(j))) : (i3 + 1 == i && i2 == i4) ? formatString("YesterdayAtFormatted", R.string.YesterdayAtFormatted, getInstance().formatterDay.format(new Date(j))) : Math.abs(System.currentTimeMillis() - j) < 31536000000L ? formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterDayMonth.format(new Date(j)), getInstance().formatterDay.format(new Date(j))) : formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterYear.format(new Date(j)), getInstance().formatterDay.format(new Date(j)));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatDateCallLog(long date) {
        long j = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(6);
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j);
            int i3 = calendar.get(6);
            int i4 = calendar.get(1);
            if (i3 == i && i2 == i4) {
                return getInstance().formatterDay.format(new Date(j));
            }
            return (i3 + 1 == i && i2 == i4) ? formatString("YesterdayAtFormatted", R.string.YesterdayAtFormatted, getInstance().formatterDay.format(new Date(j))) : Math.abs(System.currentTimeMillis() - j) < 31536000000L ? formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().chatDate.format(new Date(j)), getInstance().formatterDay.format(new Date(j))) : formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().chatFullDate.format(new Date(j)), getInstance().formatterDay.format(new Date(j)));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatLocationUpdateDate(long date) {
        long j = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(6);
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j);
            int i3 = calendar.get(6);
            int i4 = calendar.get(1);
            if (i3 == i && i2 == i4) {
                int currentTime = ((int) (ConnectionsManager.getInstance(UserConfig.selectedAccount).getCurrentTime() - (j / 1000))) / 60;
                if (currentTime < 1) {
                    return getString("LocationUpdatedJustNow", R.string.LocationUpdatedJustNow);
                }
                return currentTime < 60 ? formatPluralString("UpdatedMinutes", currentTime) : formatString("LocationUpdatedFormatted", R.string.LocationUpdatedFormatted, formatString("TodayAtFormatted", R.string.TodayAtFormatted, getInstance().formatterDay.format(new Date(j))));
            }
            if (i3 + 1 == i && i2 == i4) {
                return formatString("LocationUpdatedFormatted", R.string.LocationUpdatedFormatted, formatString("YesterdayAtFormatted", R.string.YesterdayAtFormatted, getInstance().formatterDay.format(new Date(j))));
            }
            if (Math.abs(System.currentTimeMillis() - j) < 31536000000L) {
                return formatString("LocationUpdatedFormatted", R.string.LocationUpdatedFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterDayMonth.format(new Date(j)), getInstance().formatterDay.format(new Date(j))));
            }
            return formatString("LocationUpdatedFormatted", R.string.LocationUpdatedFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterYear.format(new Date(j)), getInstance().formatterDay.format(new Date(j))));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatLocationLeftTime(int time) {
        int i = (time / 60) / 60;
        int i2 = time - ((i * 60) * 60);
        int i3 = i2 / 60;
        int i4 = i2 - (i3 * 60);
        if (i != 0) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(i + (i3 <= 30 ? 0 : 1));
            return String.format("%dh", objArr);
        }
        if (i3 == 0) {
            return String.format("%d", Integer.valueOf(i4));
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(i3 + (i4 <= 30 ? 0 : 1));
        return String.format("%d", objArr2);
    }

    public static String formatDateOnline(long date) {
        try {
            if (getInstance().isFarsi()) {
                long j = 1000 * date;
                JalaliCalendar jalaliCalendar = new JalaliCalendar(System.currentTimeMillis());
                int i = jalaliCalendar.dayInYear;
                int i2 = jalaliCalendar.year;
                JalaliCalendar jalaliCalendar2 = new JalaliCalendar(j);
                int i3 = jalaliCalendar2.dayInYear;
                int i4 = jalaliCalendar2.year;
                if (i3 == i && i2 == i4) {
                    return formatString("LastSeenFormatted", R.string.LastSeenFormatted, formatString("TodayAtFormatted", R.string.TodayAtFormatted, getInstance().formatterDay.format(new Date(j))));
                }
                if (i3 + 1 == i && i2 == i4) {
                    return formatString("LastSeenFormatted", R.string.LastSeenFormatted, formatString("YesterdayAtFormatted", R.string.YesterdayAtFormatted, getInstance().formatterDay.format(new Date(j))));
                }
                if (Math.abs(System.currentTimeMillis() - j) < 31536000000L) {
                    return formatString("LastSeenDateFormatted", R.string.LastSeenDateFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, PersianDateFormatter.getPersianFormatterMonth(jalaliCalendar2.day, jalaliCalendar2.month), getInstance().formatterDay.format(new Date(j))));
                }
                return formatString("LastSeenDateFormatted", R.string.LastSeenDateFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, PersianDateFormatter.getPersianFormatterYear(jalaliCalendar2.day, jalaliCalendar2.month, jalaliCalendar2.year), getInstance().formatterDay.format(new Date(j))));
            }
            long j2 = date * 1000;
            Calendar calendar = Calendar.getInstance();
            int i5 = calendar.get(6);
            int i6 = calendar.get(1);
            calendar.setTimeInMillis(j2);
            int i7 = calendar.get(6);
            int i8 = calendar.get(1);
            if (i7 == i5 && i6 == i8) {
                return formatString("LastSeenFormatted", R.string.LastSeenFormatted, formatString("TodayAtFormatted", R.string.TodayAtFormatted, getInstance().formatterDay.format(new Date(j2))));
            }
            if (i7 + 1 == i5 && i6 == i8) {
                return formatString("LastSeenFormatted", R.string.LastSeenFormatted, formatString("YesterdayAtFormatted", R.string.YesterdayAtFormatted, getInstance().formatterDay.format(new Date(j2))));
            }
            if (Math.abs(System.currentTimeMillis() - j2) < 31536000000L) {
                return formatString("LastSeenDateFormatted", R.string.LastSeenDateFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterDayMonth.format(new Date(j2)), getInstance().formatterDay.format(new Date(j2))));
            }
            return formatString("LastSeenDateFormatted", R.string.LastSeenDateFormatted, formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterYear.format(new Date(j2)), getInstance().formatterDay.format(new Date(j2))));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    private FastDateFormat createFormatter(Locale locale, String format, String defaultFormat) {
        if (format == null || format.length() == 0) {
            format = defaultFormat;
        }
        try {
            return FastDateFormat.getInstance(format, locale);
        } catch (Exception unused) {
            return FastDateFormat.getInstance(defaultFormat, locale);
        }
    }

    public void recreateFormatters() {
        LocaleInfo localeInfo;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        int i4;
        String str4;
        Locale locale = this.currentLocale;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String language = locale.getLanguage();
        if (language == null) {
            language = "en";
        }
        String lowerCase = language.toLowerCase();
        isRTL = (lowerCase.length() == 2 && (lowerCase.equals("ar") || lowerCase.equals("fa") || lowerCase.startsWith("ar_") || lowerCase.startsWith("fa_"))) || ((localeInfo = this.currentLocaleInfo) != null && localeInfo.isRtl);
        nameDisplayOrder = lowerCase.equals("ko") ? 2 : 1;
        this.formatterMonthYear = createFormatter(locale, getStringInternal("formatterMonthYear", R.string.formatterMonthYear), "MMM yyyy");
        this.formatterDayMonth = createFormatter(locale, getStringInternal("formatterMonth", R.string.formatterMonth), "dd MMM");
        this.formatterYear = createFormatter(locale, getStringInternal("formatterYear", R.string.formatterYear), "dd.MM.yy");
        this.formatterYearMax = createFormatter(locale, getStringInternal("formatterYearMax", R.string.formatterYearMax), "dd.MM.yyyy");
        this.chatDate = createFormatter(locale, getStringInternal("chatDate", R.string.chatDate), "d MMMM");
        this.chatFullDate = createFormatter(locale, getStringInternal("chatFullDate", R.string.chatFullDate), "d MMMM yyyy");
        this.formatterWeek = createFormatter(locale, getStringInternal("formatterWeek", R.string.formatterWeek), "EEE");
        this.formatterWeekLong = createFormatter(locale, getStringInternal("formatterWeekLong", R.string.formatterWeekLong), "EEEE");
        this.formatterScheduleDay = createFormatter(locale, getStringInternal("formatDateSchedule", R.string.formatDateSchedule), "MMM d");
        this.formatterScheduleYear = createFormatter(locale, getStringInternal("formatDateScheduleYear", R.string.formatDateScheduleYear), "MMM d yyyy");
        Locale locale2 = (lowerCase.toLowerCase().equals("fa") || lowerCase.toLowerCase().equals("ar") || lowerCase.toLowerCase().equals("ko")) ? locale : Locale.US;
        if (is24HourFormat) {
            i = R.string.formatterDay24H;
            str = "formatterDay24H";
        } else {
            i = R.string.formatterDay12H;
            str = "formatterDay12H";
        }
        this.formatterDay = createFormatter(locale2, getStringInternal(str, i), is24HourFormat ? "HH:mm" : "h:mm a");
        if (is24HourFormat) {
            i2 = R.string.formatterStats24H;
            str2 = "formatterStats24H";
        } else {
            i2 = R.string.formatterStats12H;
            str2 = "formatterStats12H";
        }
        this.formatterStats = createFormatter(locale, getStringInternal(str2, i2), is24HourFormat ? "MMM dd yyyy, HH:mm" : "MMM dd yyyy, h:mm a");
        if (is24HourFormat) {
            i3 = R.string.formatterBannedUntil24H;
            str3 = "formatterBannedUntil24H";
        } else {
            i3 = R.string.formatterBannedUntil12H;
            str3 = "formatterBannedUntil12H";
        }
        this.formatterBannedUntil = createFormatter(locale, getStringInternal(str3, i3), is24HourFormat ? "MMM dd yyyy, HH:mm" : "MMM dd yyyy, h:mm a");
        if (is24HourFormat) {
            i4 = R.string.formatterBannedUntilThisYear24H;
            str4 = "formatterBannedUntilThisYear24H";
        } else {
            i4 = R.string.formatterBannedUntilThisYear12H;
            str4 = "formatterBannedUntilThisYear12H";
        }
        this.formatterBannedUntilThisYear = createFormatter(locale, getStringInternal(str4, i4), is24HourFormat ? "MMM dd, HH:mm" : "MMM dd, h:mm a");
        this.formatterScheduleSend[0] = createFormatter(locale, getStringInternal("SendTodayAt", R.string.SendTodayAt), "'Send today at' HH:mm");
        this.formatterScheduleSend[1] = createFormatter(locale, getStringInternal("SendDayAt", R.string.SendDayAt), "'Send on' MMM d 'at' HH:mm");
        this.formatterScheduleSend[2] = createFormatter(locale, getStringInternal("SendDayYearAt", R.string.SendDayYearAt), "'Send on' MMM d yyyy 'at' HH:mm");
        this.formatterScheduleSend[3] = createFormatter(locale, getStringInternal("RemindTodayAt", R.string.RemindTodayAt), "'Remind today at' HH:mm");
        this.formatterScheduleSend[4] = createFormatter(locale, getStringInternal("RemindDayAt", R.string.RemindDayAt), "'Remind on' MMM d 'at' HH:mm");
        this.formatterScheduleSend[5] = createFormatter(locale, getStringInternal("RemindDayYearAt", R.string.RemindDayYearAt), "'Remind on' MMM d yyyy 'at' HH:mm");
        this.formatterScheduleSend[6] = createFormatter(locale, getStringInternal("StartTodayAt", R.string.StartTodayAt), "'Start today at' HH:mm");
        this.formatterScheduleSend[7] = createFormatter(locale, getStringInternal("StartDayAt", R.string.StartDayAt), "'Start on' MMM d 'at' HH:mm");
        this.formatterScheduleSend[8] = createFormatter(locale, getStringInternal("StartDayYearAt", R.string.StartDayYearAt), "'Start on' MMM d yyyy 'at' HH:mm");
        this.formatterScheduleSend[9] = createFormatter(locale, getStringInternal("StartShortTodayAt", R.string.StartShortTodayAt), "'Today,' HH:mm");
        this.formatterScheduleSend[10] = createFormatter(locale, getStringInternal("StartShortDayAt", R.string.StartShortDayAt), "MMM d',' HH:mm");
        this.formatterScheduleSend[11] = createFormatter(locale, getStringInternal("StartShortDayYearAt", R.string.StartShortDayYearAt), "MMM d yyyy, HH:mm");
        this.formatterScheduleSend[12] = createFormatter(locale, getStringInternal("StartsTodayAt", R.string.StartsTodayAt), "'Starts today at' HH:mm");
        this.formatterScheduleSend[13] = createFormatter(locale, getStringInternal("StartsDayAt", R.string.StartsDayAt), "'Starts on' MMM d 'at' HH:mm");
        this.formatterScheduleSend[14] = createFormatter(locale, getStringInternal("StartsDayYearAt", R.string.StartsDayYearAt), "'Starts on' MMM d yyyy 'at' HH:mm");
    }

    public static boolean isRTLCharacter(char ch) {
        return Character.getDirectionality(ch) == 1 || Character.getDirectionality(ch) == 2 || Character.getDirectionality(ch) == 16 || Character.getDirectionality(ch) == 17;
    }

    public static String formatStartsTime(long date, int type) {
        return formatStartsTime(date, type, true);
    }

    public static String formatStartsTime(long date, int type, boolean needToday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(6);
        calendar.setTimeInMillis(date * 1000);
        int i3 = i == calendar.get(1) ? (needToday && calendar.get(6) == i2) ? 0 : 1 : 2;
        if (type == 1) {
            i3 += 3;
        } else if (type == 2) {
            i3 += 6;
        } else if (type == 3) {
            i3 += 9;
        } else if (type == 4) {
            i3 += 12;
        }
        return getInstance().formatterScheduleSend[i3].format(calendar.getTimeInMillis());
    }

    public static String formatSectionDate(long date) {
        int i;
        int i2;
        int i3;
        long j = 1000 * date;
        try {
            if (getInstance().isFarsi()) {
                i3 = new JalaliCalendar(System.currentTimeMillis()).year;
                JalaliCalendar jalaliCalendar = new JalaliCalendar(j);
                i = jalaliCalendar.year;
                i2 = jalaliCalendar.month - 1;
            } else {
                Calendar calendar = Calendar.getInstance();
                int i4 = calendar.get(1);
                calendar.setTimeInMillis(j);
                i = calendar.get(1);
                i2 = calendar.get(2);
                i3 = i4;
            }
            String[] strArr = new String[12];
            if (getInstance().isFarsi()) {
                strArr[0] = getString("Farvardin", R.string.Farvardin);
                strArr[1] = getString("Ordibehesht", R.string.Ordibehesht);
                strArr[2] = getString("Khordad", R.string.Khordad);
                strArr[3] = getString("Tir", R.string.Tir);
                strArr[4] = getString("Mordad", R.string.Mordad);
                strArr[5] = getString("Shahrivar", R.string.Shahrivar);
                strArr[6] = getString("Mehr", R.string.Mehr);
                strArr[7] = getString("Aban", R.string.Aban);
                strArr[8] = getString("Azar", R.string.Azar);
                strArr[9] = getString("Dey", R.string.Dey);
                strArr[10] = getString("Bahman", R.string.Bahman);
                strArr[11] = getString("Esfand", R.string.Esfand);
            } else {
                strArr[0] = getString("January", R.string.January);
                strArr[1] = getString("February", R.string.February);
                strArr[2] = getString("March", R.string.March);
                strArr[3] = getString("April", R.string.April);
                strArr[4] = getString("May", R.string.May);
                strArr[5] = getString("June", R.string.June);
                strArr[6] = getString("July", R.string.July);
                strArr[7] = getString("August", R.string.August);
                strArr[8] = getString("September", R.string.September);
                strArr[9] = getString("October", R.string.October);
                strArr[10] = getString("November", R.string.November);
                strArr[11] = getString("December", R.string.December);
            }
            if (i3 == i) {
                return strArr[i2];
            }
            return strArr[i2] + " " + i;
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatDateForBan(long date) throws IOException {
        if (getInstance().isFarsi()) {
            try {
                int i = new JalaliCalendar(System.currentTimeMillis()).year;
                long j = date * 1000;
                JalaliCalendar jalaliCalendar = new JalaliCalendar(j);
                if (i == jalaliCalendar.year) {
                    return String.format(Locale.getDefault(), "%s، %s", PersianDateFormatter.getPersianFormatterMonth(jalaliCalendar.day, jalaliCalendar.month), getInstance().formatterDay.format(new Date(j)));
                }
                return PersianDateFormatter.getPersianFormatterYear(jalaliCalendar.day, jalaliCalendar.month, jalaliCalendar.year) + " " + getInstance().formatterDay.format(new Date(j));
            } catch (Exception e) {
                FileLog.e("TSMS", e);
                return "LOC_ERR";
            }
        }
        long j2 = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j2);
            if (i2 == calendar.get(1)) {
                return getInstance().formatterBannedUntilThisYear.format(new Date(j2));
            }
            return getInstance().formatterBannedUntil.format(new Date(j2));
        } catch (Exception e2) {
            FileLog.e(e2);
            return "LOC_ERR";
        }
    }

    public static String stringForMessageListDate(long date) {
        if (getInstance().isFarsi()) {
            try {
                JalaliCalendar jalaliCalendar = new JalaliCalendar(System.currentTimeMillis());
                int i = jalaliCalendar.dayInYear;
                int i2 = jalaliCalendar.year;
                long j = date * 1000;
                JalaliCalendar jalaliCalendar2 = new JalaliCalendar(j);
                int i3 = jalaliCalendar2.dayInYear;
                int i4 = jalaliCalendar2.year;
                if (i2 != i4) {
                    return PersianDateFormatter.getPersianFormatterYear(jalaliCalendar2.day, jalaliCalendar2.month, i4);
                }
                int i5 = i3 - i;
                if (i5 != 0 && (i5 != -1 || ((int) (System.currentTimeMillis() / 1000)) - date >= 28800)) {
                    if (i5 > -7 && i5 <= -1) {
                        return PersianDateFormatter.getDayName(jalaliCalendar2.weekDay);
                    }
                    return PersianDateFormatter.getPersianFormatterMonth(jalaliCalendar2.day, jalaliCalendar2.month);
                }
                return getInstance().formatterDay.format(new Date(j));
            } catch (Exception e) {
                FileLog.e("TSMS", e);
                return "LOC_ERR";
            }
        }
        long j2 = date * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i6 = calendar.get(6);
            calendar.setTimeInMillis(j2);
            int i7 = calendar.get(6);
            if (Math.abs(System.currentTimeMillis() - j2) >= 31536000000L) {
                return getInstance().formatterYear.format(new Date(j2));
            }
            int i8 = i7 - i6;
            if (i8 != 0 && (i8 != -1 || System.currentTimeMillis() - j2 >= 28800000)) {
                if (i8 > -7 && i8 <= -1) {
                    return getInstance().formatterWeek.format(new Date(j2));
                }
                return getInstance().formatterDayMonth.format(new Date(j2));
            }
            return getInstance().formatterDay.format(new Date(j2));
        } catch (Exception e2) {
            FileLog.e(e2);
            return "LOC_ERR";
        }
    }

    public static String formatShortNumber(int number, int[] rounded) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = number / 1000;
            if (i2 <= 0) {
                break;
            }
            sb.append("K");
            i = (number % 1000) / 100;
            number = i2;
        }
        if (rounded != null) {
            double d = number;
            double d2 = i;
            Double.isNaN(d2);
            Double.isNaN(d);
            double d3 = d + (d2 / 10.0d);
            for (int i3 = 0; i3 < sb.length(); i3++) {
                d3 *= 1000.0d;
            }
            rounded[0] = (int) d3;
        }
        if (i != 0 && sb.length() > 0) {
            if (sb.length() == 2) {
                str2 = String.format(Locale.US, "%d.%dM", Integer.valueOf(number), Integer.valueOf(i));
            } else {
                str2 = String.format(Locale.US, "%d.%d%s", Integer.valueOf(number), Integer.valueOf(i), sb.toString());
            }
            return AndroidUtilities.fixNumbers(str2);
        }
        if (sb.length() == 2) {
            str = String.format(Locale.US, "%dM", Integer.valueOf(number));
        } else {
            str = String.format(Locale.US, "%d%s", Integer.valueOf(number), sb.toString());
        }
        return AndroidUtilities.fixNumbers(str);
    }

    public static String formatUserStatus(int currentAccount, TLRPC$User user) {
        return formatUserStatus(currentAccount, user, null);
    }

    public static String formatJoined(long date) {
        String string;
        long j = date * 1000;
        try {
            if (Math.abs(System.currentTimeMillis() - j) < 31536000000L) {
                getInstance();
                if (isRTL) {
                    JalaliCalendar jalaliCalendar = new JalaliCalendar(j);
                    string = formatString("formatDateAtTime", R.string.formatDateAtTime, jalaliCalendar.day + " " + jalaliCalendar.getMonthName(jalaliCalendar.month), getInstance().formatterDay.format(new Date(j)));
                } else {
                    string = formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterDayMonth.format(new Date(j)), getInstance().formatterDay.format(new Date(j)));
                }
            } else {
                getInstance();
                if (isRTL) {
                    JalaliCalendar jalaliCalendar2 = new JalaliCalendar(j);
                    string = formatString("formatDateAtTime", R.string.formatDateAtTime, jalaliCalendar2.getMonthName(jalaliCalendar2.month) + " " + jalaliCalendar2.year, getInstance().formatterDay.format(new Date(j)));
                } else {
                    string = formatString("formatDateAtTime", R.string.formatDateAtTime, getInstance().formatterYear.format(new Date(j)), getInstance().formatterDay.format(new Date(j)));
                }
            }
            return formatString("ChannelOtherSubscriberJoined", R.string.ChannelOtherSubscriberJoined, string);
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatImportedDate(long date) {
        try {
            Date date2 = new Date(date * 1000);
            return String.format("%1$s, %2$s", getInstance().formatterYear.format(date2), getInstance().formatterDay.format(date2));
        } catch (Exception e) {
            FileLog.e(e);
            return "LOC_ERR";
        }
    }

    public static String formatUserStatus(int currentAccount, TLRPC$User user, boolean[] isOnline) {
        TLRPC$UserStatus tLRPC$UserStatus;
        TLRPC$UserStatus tLRPC$UserStatus2;
        TLRPC$UserStatus tLRPC$UserStatus3;
        if (user != null && (tLRPC$UserStatus3 = user.status) != null && tLRPC$UserStatus3.expires == 0) {
            if (tLRPC$UserStatus3 instanceof TLRPC$TL_userStatusRecently) {
                tLRPC$UserStatus3.expires = -100;
            } else if (tLRPC$UserStatus3 instanceof TLRPC$TL_userStatusLastWeek) {
                tLRPC$UserStatus3.expires = -101;
            } else if (tLRPC$UserStatus3 instanceof TLRPC$TL_userStatusLastMonth) {
                tLRPC$UserStatus3.expires = -102;
            }
        }
        if (user != null && (tLRPC$UserStatus2 = user.status) != null && tLRPC$UserStatus2.expires <= 0 && MessagesController.getInstance(currentAccount).onlinePrivacy.containsKey(Long.valueOf(user.id))) {
            if (isOnline != null) {
                isOnline[0] = true;
            }
            return getString("Online", R.string.Online);
        }
        if (user == null || (tLRPC$UserStatus = user.status) == null || tLRPC$UserStatus.expires == 0 || UserObject.isDeleted(user) || (user instanceof TLRPC$TL_userEmpty)) {
            return getString("ALongTimeAgo", R.string.ALongTimeAgo);
        }
        int currentTime = ConnectionsManager.getInstance(currentAccount).getCurrentTime();
        int i = user.status.expires;
        if (i > currentTime) {
            if (isOnline != null) {
                isOnline[0] = true;
            }
            return getString("Online", R.string.Online);
        }
        if (i == -1) {
            return getString("Invisible", R.string.Invisible);
        }
        if (i == -100) {
            return getString("Lately", R.string.Lately);
        }
        if (i == -101) {
            return getString("WithinAWeek", R.string.WithinAWeek);
        }
        if (i == -102) {
            return getString("WithinAMonth", R.string.WithinAMonth);
        }
        return formatDateOnline(i);
    }

    private String escapeString(String str) {
        return str.contains("[CDATA") ? str : str.replace("<", "&lt;").replace(">", "&gt;").replace("& ", "&amp; ");
    }

    public void saveRemoteLocaleStringsForCurrentLocale(final TLRPC$TL_langPackDifference difference, int currentAccount) {
        if (this.currentLocaleInfo == null) {
            return;
        }
        String lowerCase = difference.lang_code.replace('-', '_').toLowerCase();
        if (lowerCase.equals(this.currentLocaleInfo.shortName) || lowerCase.equals(this.currentLocaleInfo.baseLangCode)) {
            lambda$applyRemoteLanguage$9(this.currentLocaleInfo, difference, currentAccount);
        }
    }

    /* renamed from: saveRemoteLocaleStrings, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$applyRemoteLanguage$9$LocaleController(final LocaleInfo localeInfo, final TLRPC$TL_langPackDifference difference, int currentAccount) throws Throwable {
        final int i;
        File pathToBaseFile;
        HashMap<String, String> localeFileStrings;
        if (difference == null || difference.strings.isEmpty() || localeInfo == null || localeInfo.isLocal()) {
            return;
        }
        String lowerCase = difference.lang_code.replace('-', '_').toLowerCase();
        if (lowerCase.equals(localeInfo.shortName)) {
            i = 0;
        } else {
            i = lowerCase.equals(localeInfo.baseLangCode) ? 1 : -1;
        }
        if (i == -1) {
            return;
        }
        if (i == 0) {
            pathToBaseFile = localeInfo.getPathToFile();
        } else {
            pathToBaseFile = localeInfo.getPathToBaseFile();
        }
        try {
            if (difference.from_version == 0) {
                localeFileStrings = new HashMap<>();
            } else {
                localeFileStrings = getLocaleFileStrings(pathToBaseFile, true);
            }
            for (int i2 = 0; i2 < difference.strings.size(); i2++) {
                TLRPC$LangPackString tLRPC$LangPackString = difference.strings.get(i2);
                if (tLRPC$LangPackString instanceof TLRPC$TL_langPackString) {
                    localeFileStrings.put(tLRPC$LangPackString.key, escapeString(tLRPC$LangPackString.value));
                } else if (tLRPC$LangPackString instanceof TLRPC$TL_langPackStringPluralized) {
                    String str = tLRPC$LangPackString.key + "_zero";
                    String str2 = tLRPC$LangPackString.zero_value;
                    localeFileStrings.put(str, str2 != null ? escapeString(str2) : "");
                    String str3 = tLRPC$LangPackString.key + "_one";
                    String str4 = tLRPC$LangPackString.one_value;
                    localeFileStrings.put(str3, str4 != null ? escapeString(str4) : "");
                    String str5 = tLRPC$LangPackString.key + "_two";
                    String str6 = tLRPC$LangPackString.two_value;
                    localeFileStrings.put(str5, str6 != null ? escapeString(str6) : "");
                    String str7 = tLRPC$LangPackString.key + "_few";
                    String str8 = tLRPC$LangPackString.few_value;
                    localeFileStrings.put(str7, str8 != null ? escapeString(str8) : "");
                    String str9 = tLRPC$LangPackString.key + "_many";
                    String str10 = tLRPC$LangPackString.many_value;
                    localeFileStrings.put(str9, str10 != null ? escapeString(str10) : "");
                    String str11 = tLRPC$LangPackString.key + "_other";
                    String str12 = tLRPC$LangPackString.other_value;
                    localeFileStrings.put(str11, str12 != null ? escapeString(str12) : "");
                } else if (tLRPC$LangPackString instanceof TLRPC$TL_langPackStringDeleted) {
                    localeFileStrings.remove(tLRPC$LangPackString.key);
                }
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("save locale file to " + pathToBaseFile);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToBaseFile));
            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
            bufferedWriter.write("<resources>\n");
            for (Map.Entry<String, String> entry : localeFileStrings.entrySet()) {
                bufferedWriter.write(String.format("<string name=\"%1$s\">%2$s</string>\n", entry.getKey(), entry.getValue()));
            }
            bufferedWriter.write("</resources>");
            bufferedWriter.close();
            boolean zHasBaseLang = localeInfo.hasBaseLang();
            final HashMap<String, String> localeFileStrings2 = getLocaleFileStrings(zHasBaseLang ? localeInfo.getPathToBaseFile() : localeInfo.getPathToFile());
            if (zHasBaseLang) {
                localeFileStrings2.putAll(getLocaleFileStrings(localeInfo.getPathToFile()));
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$Up2Glyw6UN5tJqDRz2PAUC2UfPI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveRemoteLocaleStrings$4$LocaleController(i, localeInfo, difference, localeFileStrings2);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveRemoteLocaleStrings$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveRemoteLocaleStrings$4$LocaleController(int i, LocaleInfo localeInfo, TLRPC$TL_langPackDifference tLRPC$TL_langPackDifference, HashMap map) {
        String[] strArrSplit;
        Locale locale;
        if (i == 0) {
            localeInfo.version = tLRPC$TL_langPackDifference.version;
        } else {
            localeInfo.baseVersion = tLRPC$TL_langPackDifference.version;
        }
        saveOtherLanguages();
        try {
            if (this.currentLocaleInfo == localeInfo) {
                if (!TextUtils.isEmpty(localeInfo.pluralLangCode)) {
                    strArrSplit = localeInfo.pluralLangCode.split("_");
                } else if (!TextUtils.isEmpty(localeInfo.baseLangCode)) {
                    strArrSplit = localeInfo.baseLangCode.split("_");
                } else {
                    strArrSplit = localeInfo.shortName.split("_");
                }
                if (strArrSplit.length == 1) {
                    locale = new Locale(strArrSplit[0]);
                } else {
                    locale = new Locale(strArrSplit[0], strArrSplit[1]);
                }
                this.languageOverride = localeInfo.shortName;
                SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
                editorEdit.putString("language", localeInfo.getKey());
                editorEdit.commit();
                this.localeValues = map;
                this.currentLocale = locale;
                this.currentLocaleInfo = localeInfo;
                if (!TextUtils.isEmpty(localeInfo.pluralLangCode)) {
                    this.currentPluralRules = this.allRules.get(this.currentLocaleInfo.pluralLangCode);
                }
                if (this.currentPluralRules == null) {
                    PluralRules pluralRules = this.allRules.get(this.currentLocale.getLanguage());
                    this.currentPluralRules = pluralRules;
                    if (pluralRules == null) {
                        this.currentPluralRules = this.allRules.get("en");
                    }
                }
                this.changingConfiguration = true;
                Locale.setDefault(this.currentLocale);
                Configuration configuration = new Configuration();
                configuration.locale = this.currentLocale;
                ApplicationLoader.applicationContext.getResources().updateConfiguration(configuration, ApplicationLoader.applicationContext.getResources().getDisplayMetrics());
                this.changingConfiguration = false;
            }
        } catch (Exception e) {
            FileLog.e(e);
            this.changingConfiguration = false;
        }
        recreateFormatters();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.reloadInterface, new Object[0]);
    }

    public void loadRemoteLanguages(final int currentAccount) {
        if (this.loadingRemoteLanguages) {
            return;
        }
        this.loadingRemoteLanguages = true;
        ConnectionsManager.getInstance(currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_langpack_getLanguages
            public static int constructor = -2146445955;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                int int32 = stream.readInt32(exception);
                for (int i = 0; i < int32; i++) {
                    TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguageTLdeserialize = TLRPC$TL_langPackLanguage.TLdeserialize(stream, stream.readInt32(exception), exception);
                    if (tLRPC$TL_langPackLanguageTLdeserialize == null) {
                        return tLRPC$Vector;
                    }
                    tLRPC$Vector.objects.add(tLRPC$TL_langPackLanguageTLdeserialize);
                }
                return tLRPC$Vector;
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$R9LX7NZKdXiJSjaVbnZQqKUW6_4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadRemoteLanguages$6$LocaleController(currentAccount, tLObject, tLRPC$TL_error);
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRemoteLanguages$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRemoteLanguages$6$LocaleController(final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$bGpNl9SR2bXe1i8MWxja0TJKyvk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRemoteLanguages$5$LocaleController(tLObject, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRemoteLanguages$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRemoteLanguages$5$LocaleController(TLObject tLObject, int i) {
        this.loadingRemoteLanguages = false;
        TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
        int size = this.remoteLanguages.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.remoteLanguages.get(i2).serverIndex = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        int size2 = tLRPC$Vector.objects.size();
        for (int i3 = 0; i3 < size2; i3++) {
            TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguage = (TLRPC$TL_langPackLanguage) tLRPC$Vector.objects.get(i3);
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("loaded lang " + tLRPC$TL_langPackLanguage.name);
            }
            LocaleInfo localeInfo = new LocaleInfo();
            localeInfo.nameEnglish = tLRPC$TL_langPackLanguage.name;
            localeInfo.name = tLRPC$TL_langPackLanguage.native_name;
            localeInfo.shortName = tLRPC$TL_langPackLanguage.lang_code.replace('-', '_').toLowerCase();
            String str = tLRPC$TL_langPackLanguage.base_lang_code;
            if (str != null) {
                localeInfo.baseLangCode = str.replace('-', '_').toLowerCase();
            } else {
                localeInfo.baseLangCode = "";
            }
            localeInfo.pluralLangCode = tLRPC$TL_langPackLanguage.plural_code.replace('-', '_').toLowerCase();
            localeInfo.isRtl = tLRPC$TL_langPackLanguage.rtl;
            localeInfo.pathToFile = "remote";
            localeInfo.serverIndex = i3;
            LocaleInfo languageFromDict = getLanguageFromDict(localeInfo.getKey());
            if (languageFromDict == null) {
                this.languages.add(localeInfo);
                this.languagesDict.put(localeInfo.getKey(), localeInfo);
            } else {
                languageFromDict.nameEnglish = localeInfo.nameEnglish;
                languageFromDict.name = localeInfo.name;
                languageFromDict.baseLangCode = localeInfo.baseLangCode;
                languageFromDict.pluralLangCode = localeInfo.pluralLangCode;
                languageFromDict.pathToFile = localeInfo.pathToFile;
                languageFromDict.serverIndex = localeInfo.serverIndex;
                localeInfo = languageFromDict;
            }
            if (!this.remoteLanguagesDict.containsKey(localeInfo.getKey())) {
                this.remoteLanguages.add(localeInfo);
                this.remoteLanguagesDict.put(localeInfo.getKey(), localeInfo);
            }
        }
        int i4 = 0;
        while (i4 < this.remoteLanguages.size()) {
            LocaleInfo localeInfo2 = this.remoteLanguages.get(i4);
            if (localeInfo2.serverIndex == Integer.MAX_VALUE && localeInfo2 != this.currentLocaleInfo) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("remove lang " + localeInfo2.getKey());
                }
                this.remoteLanguages.remove(i4);
                this.remoteLanguagesDict.remove(localeInfo2.getKey());
                this.languages.remove(localeInfo2);
                this.languagesDict.remove(localeInfo2.getKey());
                i4--;
            }
            i4++;
        }
        saveOtherLanguages();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.suggestedLangpack, new Object[0]);
        applyLanguage(this.currentLocaleInfo, true, false, i);
    }

    private void applyRemoteLanguage(final LocaleInfo localeInfo, String langCode, boolean force, final int currentAccount) {
        if (localeInfo != null) {
            if (localeInfo.isRemote() || localeInfo.isUnofficial()) {
                if (localeInfo.hasBaseLang() && (langCode == null || langCode.equals(localeInfo.baseLangCode))) {
                    if (localeInfo.baseVersion != 0 && !force) {
                        if (localeInfo.hasBaseLang()) {
                            TLRPC$TL_langpack_getDifference tLRPC$TL_langpack_getDifference = new TLRPC$TL_langpack_getDifference();
                            tLRPC$TL_langpack_getDifference.from_version = localeInfo.baseVersion;
                            tLRPC$TL_langpack_getDifference.lang_code = localeInfo.getBaseLangCode();
                            tLRPC$TL_langpack_getDifference.lang_pack = "";
                            ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_langpack_getDifference, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$fonH1pby3SK_T4YTzoeiMikp2gI
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$applyRemoteLanguage$8$LocaleController(localeInfo, currentAccount, tLObject, tLRPC$TL_error);
                                }
                            }, 8);
                        }
                    } else {
                        TLRPC$TL_langpack_getLangPack tLRPC$TL_langpack_getLangPack = new TLRPC$TL_langpack_getLangPack();
                        tLRPC$TL_langpack_getLangPack.lang_code = localeInfo.getBaseLangCode();
                        ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_langpack_getLangPack, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$OWsPR5BLb2pmWMZgAjR6w48aUsw
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$applyRemoteLanguage$10$LocaleController(localeInfo, currentAccount, tLObject, tLRPC$TL_error);
                            }
                        }, 8);
                    }
                }
                if (langCode == null || langCode.equals(localeInfo.shortName)) {
                    if (localeInfo.version != 0 && !force) {
                        TLRPC$TL_langpack_getDifference tLRPC$TL_langpack_getDifference2 = new TLRPC$TL_langpack_getDifference();
                        tLRPC$TL_langpack_getDifference2.from_version = localeInfo.version;
                        tLRPC$TL_langpack_getDifference2.lang_code = localeInfo.getLangCode();
                        tLRPC$TL_langpack_getDifference2.lang_pack = "";
                        ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_langpack_getDifference2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$lCWZzpCs7jpmjAKou2uGQb7eed0
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$applyRemoteLanguage$12$LocaleController(localeInfo, currentAccount, tLObject, tLRPC$TL_error);
                            }
                        }, 8);
                        return;
                    }
                    for (int i = 0; i < 3; i++) {
                        ConnectionsManager.setLangCode(localeInfo.getLangCode());
                    }
                    TLRPC$TL_langpack_getLangPack tLRPC$TL_langpack_getLangPack2 = new TLRPC$TL_langpack_getLangPack();
                    tLRPC$TL_langpack_getLangPack2.lang_code = localeInfo.getLangCode();
                    ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_langpack_getLangPack2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$RIsHTT2e_xRm5OXcccvu-waX0ds
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$applyRemoteLanguage$14$LocaleController(localeInfo, currentAccount, tLObject, tLRPC$TL_error);
                        }
                    }, 8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyRemoteLanguage$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyRemoteLanguage$8$LocaleController(final LocaleInfo localeInfo, final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$p1j3UHXuiPzkDq3MX3chOI7QaKs
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$applyRemoteLanguage$7$LocaleController(localeInfo, tLObject, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyRemoteLanguage$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyRemoteLanguage$10$LocaleController(final LocaleInfo localeInfo, final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$EyMLuzdJRKo_yi52wbYAohLF24s
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$applyRemoteLanguage$9$LocaleController(localeInfo, tLObject, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyRemoteLanguage$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyRemoteLanguage$12$LocaleController(final LocaleInfo localeInfo, final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$lndwExbThqRtuhlkkC_V1XgKv6I
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$applyRemoteLanguage$11$LocaleController(localeInfo, tLObject, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyRemoteLanguage$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyRemoteLanguage$14$LocaleController(final LocaleInfo localeInfo, final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$LocaleController$kDaX8Y-Vw-Sz5SiQeKoakVwSvOU
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$applyRemoteLanguage$13$LocaleController(localeInfo, tLObject, i);
                }
            });
        }
    }

    public String getTranslitString(String src) {
        return getTranslitString(src, true, false);
    }

    public String getTranslitString(String src, boolean onlyEnglish) {
        return getTranslitString(src, true, onlyEnglish);
    }

    public String getTranslitString(String src, boolean ru, boolean onlyEnglish) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (src == null) {
            return null;
        }
        if (this.ruTranslitChars == null) {
            HashMap<String, String> map = new HashMap<>(33);
            this.ruTranslitChars = map;
            map.put("а", "a");
            this.ruTranslitChars.put("б", "b");
            this.ruTranslitChars.put("в", "v");
            this.ruTranslitChars.put("г", ImageLoader.AUTOPLAY_FILTER);
            this.ruTranslitChars.put("д", "d");
            this.ruTranslitChars.put("е", "e");
            HashMap<String, String> map2 = this.ruTranslitChars;
            str2 = ImageLoader.AUTOPLAY_FILTER;
            map2.put("ё", "yo");
            this.ruTranslitChars.put("ж", "zh");
            this.ruTranslitChars.put("з", "z");
            this.ruTranslitChars.put("и", "i");
            this.ruTranslitChars.put("й", "i");
            this.ruTranslitChars.put("к", "k");
            this.ruTranslitChars.put("л", "l");
            this.ruTranslitChars.put("м", "m");
            this.ruTranslitChars.put("н", "n");
            this.ruTranslitChars.put("о", "o");
            this.ruTranslitChars.put("п", "p");
            str = "m";
            str3 = "r";
            this.ruTranslitChars.put("р", str3);
            str4 = "z";
            this.ruTranslitChars.put("с", "s");
            str7 = "v";
            this.ruTranslitChars.put("т", "t");
            str8 = "u";
            this.ruTranslitChars.put("у", str8);
            str9 = "s";
            this.ruTranslitChars.put("ф", "f");
            str5 = "h";
            this.ruTranslitChars.put("х", str5);
            str6 = "p";
            this.ruTranslitChars.put("ц", "ts");
            this.ruTranslitChars.put("ч", "ch");
            this.ruTranslitChars.put("ш", "sh");
            this.ruTranslitChars.put("щ", "sch");
            this.ruTranslitChars.put("ы", "i");
            this.ruTranslitChars.put("ь", "");
            this.ruTranslitChars.put("ъ", "");
            this.ruTranslitChars.put("э", "e");
            this.ruTranslitChars.put("ю", "yu");
            this.ruTranslitChars.put("я", "ya");
        } else {
            str = "m";
            str2 = ImageLoader.AUTOPLAY_FILTER;
            str3 = "r";
            str4 = "z";
            str5 = "h";
            str6 = "p";
            str7 = "v";
            str8 = "u";
            str9 = "s";
        }
        if (this.translitChars == null) {
            HashMap<String, String> map3 = new HashMap<>(487);
            this.translitChars = map3;
            map3.put("ȼ", "c");
            this.translitChars.put("ᶇ", "n");
            this.translitChars.put("ɖ", "d");
            this.translitChars.put("ỿ", "y");
            this.translitChars.put("ᴓ", "o");
            this.translitChars.put("ø", "o");
            this.translitChars.put("ḁ", "a");
            this.translitChars.put("ʯ", str5);
            this.translitChars.put("ŷ", "y");
            this.translitChars.put("ʞ", "k");
            this.translitChars.put("ừ", str8);
            String str10 = str8;
            this.translitChars.put("ꜳ", "aa");
            this.translitChars.put("ĳ", "ij");
            this.translitChars.put("ḽ", "l");
            this.translitChars.put("ɪ", "i");
            this.translitChars.put("ḇ", "b");
            this.translitChars.put("ʀ", str3);
            this.translitChars.put("ě", "e");
            this.translitChars.put("ﬃ", "ffi");
            this.translitChars.put("ơ", "o");
            this.translitChars.put("ⱹ", str3);
            this.translitChars.put("ồ", "o");
            this.translitChars.put("ǐ", "i");
            String str11 = str6;
            this.translitChars.put("ꝕ", str11);
            this.translitChars.put("ý", "y");
            this.translitChars.put("ḝ", "e");
            this.translitChars.put("ₒ", "o");
            this.translitChars.put("ⱥ", "a");
            this.translitChars.put("ʙ", "b");
            this.translitChars.put("ḛ", "e");
            this.translitChars.put("ƈ", "c");
            this.translitChars.put("ɦ", str5);
            this.translitChars.put("ᵬ", "b");
            String str12 = str5;
            String str13 = str9;
            this.translitChars.put("ṣ", str13);
            this.translitChars.put("đ", "d");
            this.translitChars.put("ỗ", "o");
            this.translitChars.put("ɟ", "j");
            this.translitChars.put("ẚ", "a");
            this.translitChars.put("ɏ", "y");
            this.translitChars.put("ʌ", str7);
            this.translitChars.put("ꝓ", str11);
            this.translitChars.put("ﬁ", "fi");
            this.translitChars.put("ᶄ", "k");
            this.translitChars.put("ḏ", "d");
            this.translitChars.put("ᴌ", "l");
            this.translitChars.put("ė", "e");
            this.translitChars.put("ᴋ", "k");
            this.translitChars.put("ċ", "c");
            this.translitChars.put("ʁ", str3);
            this.translitChars.put("ƕ", "hv");
            this.translitChars.put("ƀ", "b");
            this.translitChars.put("ṍ", "o");
            this.translitChars.put("ȣ", "ou");
            this.translitChars.put("ǰ", "j");
            String str14 = str2;
            this.translitChars.put("ᶃ", str14);
            this.translitChars.put("ṋ", "n");
            this.translitChars.put("ɉ", "j");
            this.translitChars.put("ǧ", str14);
            this.translitChars.put("ǳ", "dz");
            String str15 = str4;
            this.translitChars.put("ź", str15);
            this.translitChars.put("ꜷ", "au");
            this.translitChars.put("ǖ", str10);
            this.translitChars.put("ᵹ", str14);
            this.translitChars.put("ȯ", "o");
            this.translitChars.put("ɐ", "a");
            this.translitChars.put("ą", "a");
            this.translitChars.put("õ", "o");
            this.translitChars.put("ɻ", str3);
            this.translitChars.put("ꝍ", "o");
            this.translitChars.put("ǟ", "a");
            this.translitChars.put("ȴ", "l");
            this.translitChars.put("ʂ", str13);
            this.translitChars.put("ﬂ", "fl");
            this.translitChars.put("ȉ", "i");
            this.translitChars.put("ⱻ", "e");
            this.translitChars.put("ṉ", "n");
            this.translitChars.put("ï", "i");
            this.translitChars.put("ñ", "n");
            this.translitChars.put("ᴉ", "i");
            this.translitChars.put("ʇ", "t");
            this.translitChars.put("ẓ", str15);
            this.translitChars.put("ỷ", "y");
            this.translitChars.put("ȳ", "y");
            this.translitChars.put("ṩ", str13);
            this.translitChars.put("ɽ", str3);
            this.translitChars.put("ĝ", str14);
            this.translitChars.put("ᴝ", str10);
            this.translitChars.put("ḳ", "k");
            this.translitChars.put("ꝫ", "et");
            this.translitChars.put("ī", "i");
            this.translitChars.put("ť", "t");
            this.translitChars.put("ꜿ", "c");
            this.translitChars.put("ʟ", "l");
            this.translitChars.put("ꜹ", "av");
            this.translitChars.put("û", str10);
            this.translitChars.put("æ", "ae");
            this.translitChars.put("ă", "a");
            this.translitChars.put("ǘ", str10);
            this.translitChars.put("ꞅ", str13);
            this.translitChars.put("ᵣ", str3);
            this.translitChars.put("ᴀ", "a");
            this.translitChars.put("ƃ", "b");
            this.translitChars.put("ḩ", str12);
            this.translitChars.put("ṧ", str13);
            this.translitChars.put("ₑ", "e");
            this.translitChars.put("ʜ", str12);
            this.translitChars.put("ẋ", "x");
            this.translitChars.put("ꝅ", "k");
            this.translitChars.put("ḋ", "d");
            this.translitChars.put("ƣ", "oi");
            this.translitChars.put("ꝑ", str11);
            this.translitChars.put("ħ", str12);
            String str16 = str7;
            this.translitChars.put("ⱴ", str16);
            this.translitChars.put("ẇ", "w");
            this.translitChars.put("ǹ", "n");
            String str17 = str;
            this.translitChars.put("ɯ", str17);
            this.translitChars.put("ɡ", str14);
            this.translitChars.put("ɴ", "n");
            this.translitChars.put("ᴘ", str11);
            this.translitChars.put("ᵥ", str16);
            this.translitChars.put("ū", str10);
            this.translitChars.put("ḃ", "b");
            this.translitChars.put("ṗ", str11);
            this.translitChars.put("å", "a");
            this.translitChars.put("ɕ", "c");
            this.translitChars.put("ọ", "o");
            this.translitChars.put("ắ", "a");
            this.translitChars.put("ƒ", "f");
            this.translitChars.put("ǣ", "ae");
            this.translitChars.put("ꝡ", "vy");
            this.translitChars.put("ﬀ", "ff");
            this.translitChars.put("ᶉ", str3);
            this.translitChars.put("ô", "o");
            this.translitChars.put("ǿ", "o");
            this.translitChars.put("ṳ", str10);
            this.translitChars.put("ȥ", str15);
            this.translitChars.put("ḟ", "f");
            this.translitChars.put("ḓ", "d");
            this.translitChars.put("ȇ", "e");
            this.translitChars.put("ȕ", str10);
            this.translitChars.put("ȵ", "n");
            this.translitChars.put("ʠ", "q");
            this.translitChars.put("ấ", "a");
            this.translitChars.put("ǩ", "k");
            this.translitChars.put("ĩ", "i");
            this.translitChars.put("ṵ", str10);
            this.translitChars.put("ŧ", "t");
            this.translitChars.put("ɾ", str3);
            this.translitChars.put("ƙ", "k");
            this.translitChars.put("ṫ", "t");
            this.translitChars.put("ꝗ", "q");
            this.translitChars.put("ậ", "a");
            this.translitChars.put("ʄ", "j");
            this.translitChars.put("ƚ", "l");
            this.translitChars.put("ᶂ", "f");
            this.translitChars.put("ᵴ", str13);
            this.translitChars.put("ꞃ", str3);
            this.translitChars.put("ᶌ", str16);
            this.translitChars.put("ɵ", "o");
            this.translitChars.put("ḉ", "c");
            this.translitChars.put("ᵤ", str10);
            this.translitChars.put("ẑ", str15);
            this.translitChars.put("ṹ", str10);
            this.translitChars.put("ň", "n");
            this.translitChars.put("ʍ", "w");
            this.translitChars.put("ầ", "a");
            this.translitChars.put("ǉ", "lj");
            this.translitChars.put("ɓ", "b");
            this.translitChars.put("ɼ", str3);
            this.translitChars.put("ò", "o");
            this.translitChars.put("ẘ", "w");
            this.translitChars.put("ɗ", "d");
            this.translitChars.put("ꜽ", "ay");
            this.translitChars.put("ư", str10);
            this.translitChars.put("ᶀ", "b");
            this.translitChars.put("ǜ", str10);
            this.translitChars.put("ẹ", "e");
            this.translitChars.put("ǡ", "a");
            this.translitChars.put("ɥ", str12);
            this.translitChars.put("ṏ", "o");
            this.translitChars.put("ǔ", str10);
            this.translitChars.put("ʎ", "y");
            this.translitChars.put("ȱ", "o");
            this.translitChars.put("ệ", "e");
            this.translitChars.put("ế", "e");
            this.translitChars.put("ĭ", "i");
            this.translitChars.put("ⱸ", "e");
            this.translitChars.put("ṯ", "t");
            this.translitChars.put("ᶑ", "d");
            this.translitChars.put("ḧ", str12);
            this.translitChars.put("ṥ", str13);
            this.translitChars.put("ë", "e");
            this.translitChars.put("ᴍ", str17);
            this.translitChars.put("ö", "o");
            this.translitChars.put("é", "e");
            this.translitChars.put("ı", "i");
            this.translitChars.put("ď", "d");
            this.translitChars.put("ᵯ", str17);
            this.translitChars.put("ỵ", "y");
            this.translitChars.put("ŵ", "w");
            this.translitChars.put("ề", "e");
            this.translitChars.put("ứ", str10);
            this.translitChars.put("ƶ", str15);
            this.translitChars.put("ĵ", "j");
            this.translitChars.put("ḍ", "d");
            this.translitChars.put("ŭ", str10);
            this.translitChars.put("ʝ", "j");
            this.translitChars.put("ê", "e");
            this.translitChars.put("ǚ", str10);
            this.translitChars.put("ġ", str14);
            this.translitChars.put("ṙ", str3);
            this.translitChars.put("ƞ", "n");
            this.translitChars.put("ḗ", "e");
            this.translitChars.put("ẝ", str13);
            this.translitChars.put("ᶁ", "d");
            this.translitChars.put("ķ", "k");
            this.translitChars.put("ᴂ", "ae");
            this.translitChars.put("ɘ", "e");
            this.translitChars.put("ợ", "o");
            this.translitChars.put("ḿ", str17);
            this.translitChars.put("ꜰ", "f");
            this.translitChars.put("ẵ", "a");
            this.translitChars.put("ꝏ", "oo");
            this.translitChars.put("ᶆ", str17);
            this.translitChars.put("ᵽ", str11);
            this.translitChars.put("ữ", str10);
            this.translitChars.put("ⱪ", "k");
            this.translitChars.put("ḥ", str12);
            this.translitChars.put("ţ", "t");
            this.translitChars.put("ᵱ", str11);
            this.translitChars.put("ṁ", str17);
            this.translitChars.put("á", "a");
            this.translitChars.put("ᴎ", "n");
            this.translitChars.put("ꝟ", str16);
            this.translitChars.put("è", "e");
            this.translitChars.put("ᶎ", str15);
            this.translitChars.put("ꝺ", "d");
            this.translitChars.put("ᶈ", str11);
            this.translitChars.put("ɫ", "l");
            this.translitChars.put("ᴢ", str15);
            this.translitChars.put("ɱ", str17);
            this.translitChars.put("ṝ", str3);
            this.translitChars.put("ṽ", str16);
            this.translitChars.put("ũ", str10);
            this.translitChars.put("ß", "ss");
            this.translitChars.put("ĥ", str12);
            this.translitChars.put("ᵵ", "t");
            this.translitChars.put("ʐ", str15);
            this.translitChars.put("ṟ", str3);
            this.translitChars.put("ɲ", "n");
            this.translitChars.put("à", "a");
            this.translitChars.put("ẙ", "y");
            this.translitChars.put("ỳ", "y");
            this.translitChars.put("ᴔ", "oe");
            this.translitChars.put("ₓ", "x");
            this.translitChars.put("ȗ", str10);
            this.translitChars.put("ⱼ", "j");
            this.translitChars.put("ẫ", "a");
            this.translitChars.put("ʑ", str15);
            this.translitChars.put("ẛ", str13);
            this.translitChars.put("ḭ", "i");
            this.translitChars.put("ꜵ", "ao");
            this.translitChars.put("ɀ", str15);
            this.translitChars.put("ÿ", "y");
            this.translitChars.put("ǝ", "e");
            this.translitChars.put("ǭ", "o");
            this.translitChars.put("ᴅ", "d");
            this.translitChars.put("ᶅ", "l");
            this.translitChars.put("ù", str10);
            this.translitChars.put("ạ", "a");
            this.translitChars.put("ḅ", "b");
            this.translitChars.put("ụ", str10);
            this.translitChars.put("ằ", "a");
            this.translitChars.put("ᴛ", "t");
            this.translitChars.put("ƴ", "y");
            this.translitChars.put("ⱦ", "t");
            this.translitChars.put("ⱡ", "l");
            this.translitChars.put("ȷ", "j");
            this.translitChars.put("ᵶ", str15);
            this.translitChars.put("ḫ", str12);
            this.translitChars.put("ⱳ", "w");
            this.translitChars.put("ḵ", "k");
            this.translitChars.put("ờ", "o");
            this.translitChars.put("î", "i");
            this.translitChars.put("ģ", str14);
            this.translitChars.put("ȅ", "e");
            this.translitChars.put("ȧ", "a");
            this.translitChars.put("ẳ", "a");
            this.translitChars.put("ɋ", "q");
            this.translitChars.put("ṭ", "t");
            this.translitChars.put("ꝸ", "um");
            this.translitChars.put("ᴄ", "c");
            this.translitChars.put("ẍ", "x");
            this.translitChars.put("ủ", str10);
            this.translitChars.put("ỉ", "i");
            this.translitChars.put("ᴚ", str3);
            this.translitChars.put("ś", str13);
            this.translitChars.put("ꝋ", "o");
            this.translitChars.put("ỹ", "y");
            this.translitChars.put("ṡ", str13);
            this.translitChars.put("ǌ", "nj");
            this.translitChars.put("ȁ", "a");
            this.translitChars.put("ẗ", "t");
            this.translitChars.put("ĺ", "l");
            this.translitChars.put("ž", str15);
            this.translitChars.put("ᵺ", "th");
            this.translitChars.put("ƌ", "d");
            this.translitChars.put("ș", str13);
            this.translitChars.put("š", str13);
            this.translitChars.put("ᶙ", str10);
            this.translitChars.put("ẽ", "e");
            this.translitChars.put("ẜ", str13);
            this.translitChars.put("ɇ", "e");
            this.translitChars.put("ṷ", str10);
            this.translitChars.put("ố", "o");
            this.translitChars.put("ȿ", str13);
            this.translitChars.put("ᴠ", str16);
            this.translitChars.put("ꝭ", "is");
            this.translitChars.put("ᴏ", "o");
            this.translitChars.put("ɛ", "e");
            this.translitChars.put("ǻ", "a");
            this.translitChars.put("ﬄ", "ffl");
            this.translitChars.put("ⱺ", "o");
            this.translitChars.put("ȋ", "i");
            this.translitChars.put("ᵫ", "ue");
            this.translitChars.put("ȡ", "d");
            this.translitChars.put("ⱬ", str15);
            this.translitChars.put("ẁ", "w");
            this.translitChars.put("ᶏ", "a");
            this.translitChars.put("ꞇ", "t");
            this.translitChars.put("ğ", str14);
            this.translitChars.put("ɳ", "n");
            this.translitChars.put("ʛ", str14);
            this.translitChars.put("ᴜ", str10);
            this.translitChars.put("ẩ", "a");
            this.translitChars.put("ṅ", "n");
            this.translitChars.put("ɨ", "i");
            this.translitChars.put("ᴙ", str3);
            this.translitChars.put("ǎ", "a");
            this.translitChars.put("ſ", str13);
            this.translitChars.put("ȫ", "o");
            this.translitChars.put("ɿ", str3);
            this.translitChars.put("ƭ", "t");
            this.translitChars.put("ḯ", "i");
            this.translitChars.put("ǽ", "ae");
            this.translitChars.put("ⱱ", str16);
            this.translitChars.put("ɶ", "oe");
            this.translitChars.put("ṃ", str17);
            this.translitChars.put("ż", str15);
            this.translitChars.put("ĕ", "e");
            this.translitChars.put("ꜻ", "av");
            this.translitChars.put("ở", "o");
            this.translitChars.put("ễ", "e");
            this.translitChars.put("ɬ", "l");
            this.translitChars.put("ị", "i");
            this.translitChars.put("ᵭ", "d");
            this.translitChars.put("ﬆ", "st");
            this.translitChars.put("ḷ", "l");
            this.translitChars.put("ŕ", str3);
            this.translitChars.put("ᴕ", "ou");
            this.translitChars.put("ʈ", "t");
            this.translitChars.put("ā", "a");
            this.translitChars.put("ḙ", "e");
            this.translitChars.put("ᴑ", "o");
            this.translitChars.put("ç", "c");
            this.translitChars.put("ᶊ", str13);
            this.translitChars.put("ặ", "a");
            this.translitChars.put("ų", str10);
            this.translitChars.put("ả", "a");
            this.translitChars.put("ǥ", str14);
            this.translitChars.put("ꝁ", "k");
            this.translitChars.put("ẕ", str15);
            this.translitChars.put("ŝ", str13);
            this.translitChars.put("ḕ", "e");
            this.translitChars.put("ɠ", str14);
            this.translitChars.put("ꝉ", "l");
            this.translitChars.put("ꝼ", "f");
            this.translitChars.put("ᶍ", "x");
            this.translitChars.put("ǒ", "o");
            this.translitChars.put("ę", "e");
            this.translitChars.put("ổ", "o");
            this.translitChars.put("ƫ", "t");
            this.translitChars.put("ǫ", "o");
            this.translitChars.put("i̇", "i");
            this.translitChars.put("ṇ", "n");
            this.translitChars.put("ć", "c");
            this.translitChars.put("ᵷ", str14);
            this.translitChars.put("ẅ", "w");
            this.translitChars.put("ḑ", "d");
            this.translitChars.put("ḹ", "l");
            this.translitChars.put("œ", "oe");
            this.translitChars.put("ᵳ", str3);
            this.translitChars.put("ļ", "l");
            this.translitChars.put("ȑ", str3);
            this.translitChars.put("ȭ", "o");
            this.translitChars.put("ᵰ", "n");
            this.translitChars.put("ᴁ", "ae");
            this.translitChars.put("ŀ", "l");
            this.translitChars.put("ä", "a");
            this.translitChars.put("ƥ", str11);
            this.translitChars.put("ỏ", "o");
            this.translitChars.put("į", "i");
            this.translitChars.put("ȓ", str3);
            this.translitChars.put("ǆ", "dz");
            this.translitChars.put("ḡ", str14);
            this.translitChars.put("ṻ", str10);
            this.translitChars.put("ō", "o");
            this.translitChars.put("ľ", "l");
            this.translitChars.put("ẃ", "w");
            this.translitChars.put("ț", "t");
            this.translitChars.put("ń", "n");
            this.translitChars.put("ɍ", str3);
            this.translitChars.put("ȃ", "a");
            this.translitChars.put("ü", str10);
            this.translitChars.put("ꞁ", "l");
            this.translitChars.put("ᴐ", "o");
            this.translitChars.put("ớ", "o");
            this.translitChars.put("ᴃ", "b");
            this.translitChars.put("ɹ", str3);
            this.translitChars.put("ᵲ", str3);
            this.translitChars.put("ʏ", "y");
            this.translitChars.put("ᵮ", "f");
            this.translitChars.put("ⱨ", str12);
            this.translitChars.put("ŏ", "o");
            this.translitChars.put("ú", str10);
            this.translitChars.put("ṛ", str3);
            this.translitChars.put("ʮ", str12);
            this.translitChars.put("ó", "o");
            this.translitChars.put("ů", str10);
            this.translitChars.put("ỡ", "o");
            this.translitChars.put("ṕ", str11);
            this.translitChars.put("ᶖ", "i");
            this.translitChars.put("ự", str10);
            this.translitChars.put("ã", "a");
            this.translitChars.put("ᵢ", "i");
            this.translitChars.put("ṱ", "t");
            this.translitChars.put("ể", "e");
            this.translitChars.put("ử", str10);
            this.translitChars.put("í", "i");
            this.translitChars.put("ɔ", "o");
            this.translitChars.put("ɺ", str3);
            this.translitChars.put("ɢ", str14);
            this.translitChars.put("ř", str3);
            this.translitChars.put("ẖ", str12);
            this.translitChars.put("ű", str10);
            this.translitChars.put("ȍ", "o");
            this.translitChars.put("ḻ", "l");
            this.translitChars.put("ḣ", str12);
            this.translitChars.put("ȶ", "t");
            this.translitChars.put("ņ", "n");
            this.translitChars.put("ᶒ", "e");
            this.translitChars.put("ì", "i");
            this.translitChars.put("ẉ", "w");
            this.translitChars.put("ē", "e");
            this.translitChars.put("ᴇ", "e");
            this.translitChars.put("ł", "l");
            this.translitChars.put("ộ", "o");
            this.translitChars.put("ɭ", "l");
            this.translitChars.put("ẏ", "y");
            this.translitChars.put("ᴊ", "j");
            this.translitChars.put("ḱ", "k");
            this.translitChars.put("ṿ", str16);
            this.translitChars.put("ȩ", "e");
            this.translitChars.put("â", "a");
            this.translitChars.put("ş", str13);
            this.translitChars.put("ŗ", str3);
            this.translitChars.put("ʋ", str16);
            this.translitChars.put("ₐ", "a");
            this.translitChars.put("ↄ", "c");
            this.translitChars.put("ᶓ", "e");
            this.translitChars.put("ɰ", str17);
            this.translitChars.put("ᴡ", "w");
            this.translitChars.put("ȏ", "o");
            this.translitChars.put("č", "c");
            this.translitChars.put("ǵ", str14);
            this.translitChars.put("ĉ", "c");
            this.translitChars.put("ᶗ", "o");
            this.translitChars.put("ꝃ", "k");
            this.translitChars.put("ꝙ", "q");
            this.translitChars.put("ṑ", "o");
            this.translitChars.put("ꜱ", str13);
            this.translitChars.put("ṓ", "o");
            this.translitChars.put("ȟ", str12);
            this.translitChars.put("ő", "o");
            this.translitChars.put("ꜩ", "tz");
            this.translitChars.put("ẻ", "e");
        }
        StringBuilder sb = new StringBuilder(src.length());
        int length = src.length();
        boolean z = false;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String strSubstring = src.substring(i, i2);
            if (onlyEnglish) {
                String lowerCase = strSubstring.toLowerCase();
                boolean z2 = !strSubstring.equals(lowerCase);
                strSubstring = lowerCase;
                z = z2;
            }
            String upperCase = this.translitChars.get(strSubstring);
            if (upperCase == null && ru) {
                upperCase = this.ruTranslitChars.get(strSubstring);
            }
            if (upperCase != null) {
                if (onlyEnglish && z) {
                    if (upperCase.length() > 1) {
                        upperCase = upperCase.substring(0, 1).toUpperCase() + upperCase.substring(1);
                    } else {
                        upperCase = upperCase.toUpperCase();
                    }
                }
                sb.append(upperCase);
            } else {
                if (onlyEnglish) {
                    char cCharAt = strSubstring.charAt(0);
                    if ((cCharAt < 'a' || cCharAt > 'z' || cCharAt < '0' || cCharAt > '9') && cCharAt != ' ' && cCharAt != '\'' && cCharAt != ',' && cCharAt != '.' && cCharAt != '&' && cCharAt != '-' && cCharAt != '/') {
                        return null;
                    }
                    if (z) {
                        strSubstring = strSubstring.toUpperCase();
                    }
                }
                sb.append(strSubstring);
            }
            i = i2;
        }
        return sb.toString();
    }

    public static class PluralRules_Slovenian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 4;
            }
            return (i < 3 || i > 4) ? 0 : 8;
        }
    }

    public static class PluralRules_Romanian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            if (count == 1) {
                return 2;
            }
            if (count != 0) {
                return (i < 1 || i > 19) ? 0 : 8;
            }
            return 8;
        }
    }

    public static class PluralRules_Polish extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            int i2 = count % 10;
            if (count == 1) {
                return 2;
            }
            if (i2 >= 2 && i2 <= 4 && (i < 12 || i > 14)) {
                return 8;
            }
            if (i2 >= 0 && i2 <= 1) {
                return 16;
            }
            if (i2 < 5 || i2 > 9) {
                return (i < 12 || i > 14) ? 0 : 16;
            }
            return 16;
        }
    }

    public static class PluralRules_Maltese extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            if (count == 1) {
                return 2;
            }
            if (count == 0) {
                return 8;
            }
            if (i < 2 || i > 10) {
                return (i < 11 || i > 19) ? 0 : 16;
            }
            return 8;
        }
    }

    public static class PluralRules_Macedonian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            return (count % 10 != 1 || count == 11) ? 0 : 2;
        }
    }

    public static class PluralRules_Lithuanian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            int i2 = count % 10;
            if (i2 == 1 && (i < 11 || i > 19)) {
                return 2;
            }
            if (i2 < 2 || i2 > 9) {
                return 0;
            }
            return (i < 11 || i > 19) ? 8 : 0;
        }
    }

    public static class PluralRules_Latvian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            if (count == 0) {
                return 1;
            }
            return (count % 10 != 1 || count % 100 == 11) ? 0 : 2;
        }
    }

    public static class PluralRules_Balkan extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            int i2 = count % 10;
            if (i2 == 1 && i != 11) {
                return 2;
            }
            if (i2 >= 2 && i2 <= 4 && (i < 12 || i > 14)) {
                return 8;
            }
            if (i2 == 0) {
                return 16;
            }
            if (i2 < 5 || i2 > 9) {
                return (i < 11 || i > 14) ? 0 : 16;
            }
            return 16;
        }
    }

    public static class PluralRules_Serbian extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            int i2 = count % 10;
            if (i2 == 1 && i != 11) {
                return 2;
            }
            if (i2 < 2 || i2 > 4) {
                return 0;
            }
            return (i < 12 || i > 14) ? 8 : 0;
        }
    }

    public static class PluralRules_Arabic extends PluralRules {
        @Override // ir.eitaa.messenger.LocaleController.PluralRules
        public int quantityForNumber(int count) {
            int i = count % 100;
            if (count == 0) {
                return 1;
            }
            if (count == 1) {
                return 2;
            }
            if (count == 2) {
                return 4;
            }
            if (i < 3 || i > 10) {
                return (i < 11 || i > 99) ? 0 : 16;
            }
            return 8;
        }
    }

    public static String addNbsp(String src) {
        return src.replace(' ', (char) 160);
    }

    public static void resetImperialSystemType() {
        useImperialSystemType = null;
    }

    public static boolean getUseImperialSystemType() {
        ensureImperialSystemInit();
        return useImperialSystemType.booleanValue();
    }

    public static void ensureImperialSystemInit() {
        if (useImperialSystemType != null) {
            return;
        }
        int i = SharedConfig.distanceSystemType;
        if (i == 0) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
                if (telephonyManager != null) {
                    String upperCase = telephonyManager.getSimCountryIso().toUpperCase();
                    if (!"US".equals(upperCase) && !"GB".equals(upperCase) && !"MM".equals(upperCase) && !"LR".equals(upperCase)) {
                        z = false;
                    }
                    useImperialSystemType = Boolean.valueOf(z);
                    return;
                }
                return;
            } catch (Exception e) {
                useImperialSystemType = Boolean.FALSE;
                FileLog.e(e);
                return;
            }
        }
        useImperialSystemType = Boolean.valueOf(i == 2);
    }

    public static String formatDistance(float distance, int type) {
        return formatDistance(distance, type, null);
    }

    public static String formatDistance(float distance, int type, Boolean useImperial) {
        ensureImperialSystemInit();
        if (!((useImperial != null && useImperial.booleanValue()) || (useImperial == null && useImperialSystemType.booleanValue()))) {
            if (distance < 1000.0f) {
                return type != 0 ? type != 1 ? formatString("MetersShort", R.string.MetersShort, String.format("%d", Integer.valueOf((int) Math.max(1.0f, distance)))) : formatString("MetersFromYou2", R.string.MetersFromYou2, String.format("%d", Integer.valueOf((int) Math.max(1.0f, distance)))) : formatString("MetersAway2", R.string.MetersAway2, String.format("%d", Integer.valueOf((int) Math.max(1.0f, distance))));
            }
            String str = distance % 1000.0f == 0.0f ? String.format("%d", Integer.valueOf((int) (distance / 1000.0f))) : String.format("%.2f", Float.valueOf(distance / 1000.0f));
            if (type == 0) {
                return formatString("KMetersAway2", R.string.KMetersAway2, str);
            }
            if (type == 1) {
                return formatString("KMetersFromYou2", R.string.KMetersFromYou2, str);
            }
            return formatString("KMetersShort", R.string.KMetersShort, str);
        }
        float f = distance * 3.28084f;
        if (f < 1000.0f) {
            return type != 0 ? type != 1 ? formatString("FootsShort", R.string.FootsShort, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f)))) : formatString("FootsFromYou", R.string.FootsFromYou, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f)))) : formatString("FootsAway", R.string.FootsAway, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f))));
        }
        String str2 = f % 5280.0f == 0.0f ? String.format("%d", Integer.valueOf((int) (f / 5280.0f))) : String.format("%.2f", Float.valueOf(f / 5280.0f));
        if (type == 0) {
            return formatString("MilesAway", R.string.MilesAway, str2);
        }
        if (type == 1) {
            return formatString("MilesFromYou", R.string.MilesFromYou, str2);
        }
        return formatString("MilesShort", R.string.MilesShort, str2);
    }

    public boolean isFarsi() {
        return getInstance().currentLocale.getLanguage().toLowerCase().equals("fa");
    }
}
