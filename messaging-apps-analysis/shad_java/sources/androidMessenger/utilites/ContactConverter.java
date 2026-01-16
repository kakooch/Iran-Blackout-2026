package androidMessenger.utilites;

import androidMessenger.proxy.IdStorage;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ColorObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.PhoneBookObject;
import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.SessionObject;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.api.PrivacySettings;
import ir.aaap.messengercore.model.api.TwoStepStatusObject;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$InputPrivacyKey;
import org.rbmain.tgnet.TLRPC$InputPrivacyRule;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$PrivacyRule;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_account_wallPapers;
import org.rbmain.tgnet.TLRPC$TL_authorization;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyChatInvite;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyForwards;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyPhoneNumber;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyKeyStatusTimestamp;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyValueAllowAll;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyValueAllowContacts;
import org.rbmain.tgnet.TLRPC$TL_inputPrivacyValueDisallowAll;
import org.rbmain.tgnet.TLRPC$TL_photoSize;
import org.rbmain.tgnet.TLRPC$TL_photoSizeProgressive;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$TL_privacyValueAllowAll;
import org.rbmain.tgnet.TLRPC$TL_privacyValueAllowContacts;
import org.rbmain.tgnet.TLRPC$TL_privacyValueDisallowAll;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.ui.WallpapersListActivity;

/* loaded from: classes.dex */
public class ContactConverter {
    public static long getMaxDownloadSize_in_B(long j) {
        return j * 1024;
    }

    public static ArrayList<PhoneBookObject> convertToPhoneObjects(List<ContactsController.Contact> list) {
        ArrayList<PhoneBookObject> arrayList = new ArrayList<>();
        for (ContactsController.Contact contact : list) {
            ArrayList<String> arrayList2 = contact.phones;
            if (arrayList2 != null) {
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    PhoneBookObject phoneBookObject = new PhoneBookObject();
                    phoneBookObject.first_name = contact.first_name;
                    phoneBookObject.last_name = contact.last_name;
                    phoneBookObject.phone = next;
                    arrayList.add(phoneBookObject);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<TLRPC$TL_contact> convertToContacts(List<String> list) {
        ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            long jGenerateDialogId = IdStorage.getInstance().generateDialogId(it.next());
            TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
            tLRPC$TL_contact.user_id = (int) jGenerateDialogId;
            arrayList.add(tLRPC$TL_contact);
        }
        return arrayList;
    }

    public static ArrayList<TLRPC$PrivacyRule> convertPrivacyRule(TLRPC$InputPrivacyKey tLRPC$InputPrivacyKey, PrivacySettings privacySettings) {
        if (tLRPC$InputPrivacyKey == null || privacySettings == null) {
            return null;
        }
        ArrayList<TLRPC$PrivacyRule> arrayList = new ArrayList<>();
        if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyStatusTimestamp) {
            arrayList.add(getPrivacyRule(privacySettings.show_my_last_online));
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyChatInvite) {
            arrayList.add(getPrivacyRule(privacySettings.can_join_chat_by));
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyPhoneCall) {
            arrayList.add(getPrivacyRule(privacySettings.can_called_by));
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyProfilePhoto) {
            arrayList.add(getPrivacyRule(privacySettings.show_my_profile_photo));
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyPhoneNumber) {
            arrayList.add(getPrivacyRule(privacySettings.show_my_phone_number));
        } else if (tLRPC$InputPrivacyKey instanceof TLRPC$TL_inputPrivacyKeyForwards) {
            arrayList.add(getPrivacyRule(privacySettings.link_forward_message));
        }
        return arrayList;
    }

    private static TLRPC$PrivacyRule getPrivacyRule(PrivacySettings.AccessLevelEnum accessLevelEnum) {
        if (accessLevelEnum == PrivacySettings.AccessLevelEnum.Everybody) {
            return new TLRPC$TL_privacyValueAllowAll();
        }
        if (accessLevelEnum == PrivacySettings.AccessLevelEnum.MyContacts) {
            return new TLRPC$TL_privacyValueAllowContacts();
        }
        if (accessLevelEnum == PrivacySettings.AccessLevelEnum.Nobody) {
            return new TLRPC$TL_privacyValueDisallowAll();
        }
        return null;
    }

    public static PrivacySettings.AccessLevelEnum getPrivacyRuleValue(TLRPC$InputPrivacyRule tLRPC$InputPrivacyRule) {
        if (tLRPC$InputPrivacyRule instanceof TLRPC$TL_inputPrivacyValueAllowAll) {
            return PrivacySettings.AccessLevelEnum.Everybody;
        }
        if (tLRPC$InputPrivacyRule instanceof TLRPC$TL_inputPrivacyValueAllowContacts) {
            return PrivacySettings.AccessLevelEnum.MyContacts;
        }
        if (tLRPC$InputPrivacyRule instanceof TLRPC$TL_inputPrivacyValueDisallowAll) {
            return PrivacySettings.AccessLevelEnum.Nobody;
        }
        return null;
    }

    public static TLRPC$TL_account_password convertTwoStepStatus(TwoStepStatusObject twoStepStatusObject, String str) {
        if (twoStepStatusObject == null) {
            return null;
        }
        TLRPC$TL_account_password tLRPC$TL_account_password = new TLRPC$TL_account_password();
        tLRPC$TL_account_password.has_password = twoStepStatusObject.sign_in_type == PrivacySettings.SignInTypeEnum.TwoStep;
        tLRPC$TL_account_password.has_recovery = twoStepStatusObject.has_confirmed_recovery_email;
        tLRPC$TL_account_password.email_unconfirmed_pattern = twoStepStatusObject.pending_recovery_email;
        tLRPC$TL_account_password.hint = twoStepStatusObject.hint;
        tLRPC$TL_account_password.no_recovery_alert = str;
        return tLRPC$TL_account_password;
    }

    public static ArrayList<TLRPC$TL_authorization> convertAllSessions(ArrayList<SessionObject> arrayList, SessionObject sessionObject) {
        ArrayList<TLRPC$TL_authorization> arrayList2 = new ArrayList<>();
        if (arrayList == null) {
            return arrayList2;
        }
        if (sessionObject != null) {
            arrayList2.add(convertSession(sessionObject, true));
        }
        Iterator<SessionObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(convertSession(it.next(), false));
        }
        return arrayList2;
    }

    public static TLRPC$TL_authorization convertSession(SessionObject sessionObject, boolean z) {
        TLRPC$TL_authorization tLRPC$TL_authorization = new TLRPC$TL_authorization();
        tLRPC$TL_authorization.hash = IdStorage.getInstance().generateSessionId(sessionObject.key);
        tLRPC$TL_authorization.ip = sessionObject.ip;
        tLRPC$TL_authorization.device_model = sessionObject.device;
        tLRPC$TL_authorization.app_version = sessionObject.app_version;
        String str = sessionObject.location;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        tLRPC$TL_authorization.country = str;
        tLRPC$TL_authorization.date_created = (int) sessionObject.login_time;
        tLRPC$TL_authorization.date_active = (int) sessionObject.last_access;
        tLRPC$TL_authorization.app_name = sessionObject.app_brand + " " + sessionObject.app_type;
        tLRPC$TL_authorization.platform = BuildConfig.FLAVOR;
        tLRPC$TL_authorization.system_version = BuildConfig.FLAVOR;
        tLRPC$TL_authorization.region = BuildConfig.FLAVOR;
        tLRPC$TL_authorization.official_app = true;
        tLRPC$TL_authorization.current = z;
        tLRPC$TL_authorization.flags = z ? tLRPC$TL_authorization.flags | 1 : 0;
        tLRPC$TL_authorization.canTerminate = sessionObject.terminatable;
        return tLRPC$TL_authorization;
    }

    public static TLRPC$TL_account_wallPapers convertWallpapers(SettingModels.WallpapersOutput wallpapersOutput) {
        TLRPC$TL_account_wallPapers tLRPC$TL_account_wallPapers = new TLRPC$TL_account_wallPapers();
        tLRPC$TL_account_wallPapers.wallpapers = new ArrayList<>();
        tLRPC$TL_account_wallPapers.colors = new ArrayList<>();
        ArrayList<SettingModels.WallpaperObject> arrayList = wallpapersOutput.chat_background_wallpapers;
        if (arrayList != null) {
            Iterator<SettingModels.WallpaperObject> it = arrayList.iterator();
            while (it.hasNext()) {
                tLRPC$TL_account_wallPapers.wallpapers.add(convertWallpaperToTlObject(it.next()));
            }
            Iterator<ColorObject> it2 = wallpapersOutput.chat_background_colors.iterator();
            while (it2.hasNext()) {
                tLRPC$TL_account_wallPapers.colors.add(new WallpapersListActivity.ColorWallpaper("c", it2.next().getColor(), 0, 45));
            }
        }
        return tLRPC$TL_account_wallPapers;
    }

    public static TLRPC$WallPaper convertWallpaperToTlObject(SettingModels.WallpaperObject wallpaperObject) {
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper = new TLRPC$TL_wallPaper();
        tLRPC$TL_wallPaper.id = IdStorage.getInstance().generateWallpaperId(wallpaperObject.wallpaper_id);
        tLRPC$TL_wallPaper.document = convertWallpaperToDocument(wallpaperObject.thumbnail);
        tLRPC$TL_wallPaper.documentMain = convertWallpaperToDocument(wallpaperObject.main);
        tLRPC$TL_wallPaper.slug = wallpaperObject.wallpaper_id;
        return tLRPC$TL_wallPaper;
    }

    private static TLRPC$Document convertWallpaperToDocument(FileInlineObject fileInlineObject) {
        TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        tLRPC$TL_document.id = fileInlineObject.file_id;
        ArrayList<TLRPC$DocumentAttribute> arrayList = new ArrayList<>();
        if (fileInlineObject.dc_id != null) {
            tLRPC$TL_document.dc_id = IdStorage.getInstance().generateDcId(fileInlineObject.dc_id);
        }
        if (fileInlineObject.access_hash_rec != null) {
            tLRPC$TL_document.access_hash = IdStorage.getInstance().generateAccessHash(fileInlineObject.access_hash_rec);
        }
        tLRPC$TL_document.size = (int) fileInlineObject.size;
        TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = new TLRPC$TL_documentAttributeImageSize();
        tLRPC$TL_documentAttributeImageSize.h = 90;
        tLRPC$TL_documentAttributeImageSize.w = (int) (90 * 1.2f);
        arrayList.add(tLRPC$TL_documentAttributeImageSize);
        tLRPC$TL_document.mime_type = "image/webp";
        tLRPC$TL_document.thumbs.add(getPhotoSize(fileInlineObject, false, 0));
        tLRPC$TL_document.attributes = arrayList;
        return tLRPC$TL_document;
    }

    private static TLRPC$PhotoSize getPhotoSize(FileInlineObject fileInlineObject, boolean z, int i) {
        TLRPC$PhotoSize tLRPC$TL_photoSize;
        if (fileInlineObject == null) {
            return null;
        }
        int i2 = fileInlineObject.height;
        if (i2 == 0) {
            i2 = 90;
        }
        String str = i2 <= 100 ? "s" : i2 <= 320 ? "m" : i2 <= 800 ? "x" : i2 <= 1280 ? "y" : i2 <= 2560 ? "w" : BuildConfig.FLAVOR;
        if (z) {
            tLRPC$TL_photoSize = new TLRPC$TL_photoSizeProgressive();
        } else {
            tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
        }
        tLRPC$TL_photoSize.h = fileInlineObject.height;
        tLRPC$TL_photoSize.w = fileInlineObject.width;
        tLRPC$TL_photoSize.type = str;
        tLRPC$TL_photoSize.size = (int) fileInlineObject.size;
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        tLRPC$TL_photoSize.location = tLRPC$TL_fileLocationToBeDeprecated;
        if (i == 0) {
            i = 2;
        }
        tLRPC$TL_fileLocationToBeDeprecated.local_id = i;
        long j = fileInlineObject.file_id;
        if (j == 0) {
            j = -2147483648L;
        }
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = j;
        return tLRPC$TL_photoSize;
    }

    public static void addWallpaperThumbnail(Object obj) {
        if (obj instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj;
            TLRPC$Document tLRPC$Document = tLRPC$TL_wallPaper.documentMain;
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$TL_wallPaper.document, true);
            if (pathToAttach.exists()) {
                byte[] bArr = null;
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(pathToAttach, "r");
                    bArr = new byte[(int) randomAccessFile.length()];
                    randomAccessFile.readFully(bArr);
                } catch (Exception unused) {
                }
                if (bArr != null) {
                    tLRPC$Document.file_reference = bArr;
                    ArrayList<TLRPC$PhotoSize> arrayList = new ArrayList<>();
                    tLRPC$Document.thumbs = arrayList;
                    arrayList.add(getStrippedPhotoSize(bArr));
                }
            }
        }
    }

    public static TLRPC$PhotoSize getStrippedPhotoSize(byte[] bArr) {
        TLRPC$TL_photoStrippedSize tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoStrippedSize();
        tLRPC$TL_photoStrippedSize.h = 50;
        tLRPC$TL_photoStrippedSize.w = 50;
        tLRPC$TL_photoStrippedSize.type = "i";
        tLRPC$TL_photoStrippedSize.bytes = bArr;
        tLRPC$TL_photoStrippedSize.size = bArr.length;
        return tLRPC$TL_photoStrippedSize;
    }

    public static int getVibrateValue(SettingModels.VibrateObject vibrateObject) {
        if (vibrateObject == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject[vibrateObject.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 3) {
            return 1;
        }
        if (i != 4) {
            return i != 5 ? 0 : 4;
        }
        return 3;
    }

    public static SettingModels.VibrateObject getVibrateCoreValue(int i) {
        if (i == 0) {
            return SettingModels.VibrateObject.Default;
        }
        if (i == 1) {
            return SettingModels.VibrateObject.Short;
        }
        if (i == 2) {
            return SettingModels.VibrateObject.Disabled;
        }
        if (i == 3) {
            return SettingModels.VibrateObject.Long;
        }
        if (i == 4) {
            return SettingModels.VibrateObject.OnlySilent;
        }
        return SettingModels.VibrateObject.Default;
    }

    public static int getPopupValue(SettingModels.PopupObject popupObject) {
        if (popupObject == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject[popupObject.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static SettingModels.PopupObject getPopupCoreValue(int i) {
        if (i == 1) {
            return SettingModels.PopupObject.OnlyScreenOn;
        }
        if (i == 2) {
            return SettingModels.PopupObject.OnlyScreenOff;
        }
        if (i != 3) {
            return SettingModels.PopupObject.NoPopup;
        }
        return SettingModels.PopupObject.Always;
    }

    public static int getImportanceValue(SettingModels.ImportanceObject importanceObject) {
        if (importanceObject == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject[importanceObject.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return i != 4 ? 0 : 1;
        }
        return 5;
    }

    public static SettingModels.ImportanceObject getImportanceCoreValue(int i) {
        if (i == 1) {
            return SettingModels.ImportanceObject.Urgent;
        }
        if (i == 4) {
            return SettingModels.ImportanceObject.Low;
        }
        if (i == 5) {
            return SettingModels.ImportanceObject.Medium;
        }
        return SettingModels.ImportanceObject.High;
    }

    public static void setPresetMask(DownloadController.Preset preset, SettingModels.AutoDownloadSettingObject autoDownloadSettingObject, int i) {
        if (autoDownloadSettingObject == null) {
            return;
        }
        if (autoDownloadSettingObject.contacts) {
            int[] iArr = preset.mask;
            iArr[0] = iArr[0] | i;
        } else {
            int[] iArr2 = preset.mask;
            iArr2[0] = iArr2[0] & (i ^ (-1));
        }
        if (autoDownloadSettingObject.other_users) {
            int[] iArr3 = preset.mask;
            iArr3[1] = iArr3[1] | i;
        } else {
            int[] iArr4 = preset.mask;
            iArr4[1] = iArr4[1] & (i ^ (-1));
        }
        if (autoDownloadSettingObject.groups) {
            int[] iArr5 = preset.mask;
            iArr5[2] = iArr5[2] | i;
        } else {
            int[] iArr6 = preset.mask;
            iArr6[2] = iArr6[2] & (i ^ (-1));
        }
        if (autoDownloadSettingObject.channels) {
            int[] iArr7 = preset.mask;
            iArr7[3] = iArr7[3] | i;
        } else {
            int[] iArr8 = preset.mask;
            iArr8[3] = iArr8[3] & (i ^ (-1));
        }
        preset.sizes[DownloadController.typeToIndex(i)] = (int) getMaxDownloadSize_in_B(autoDownloadSettingObject.max_download_size);
    }

    public static int getMaxDownloadSize_ink_KB(long j) {
        return (int) (j / 1024);
    }

    public static SettingModels.AutoDownloadSettingObject getAutoDownloadObject(DownloadController.Preset preset, int i, int i2) {
        SettingModels.AutoDownloadSettingObject autoDownloadSettingObject = new SettingModels.AutoDownloadSettingObject();
        int[] iArr = preset.mask;
        autoDownloadSettingObject.contacts = (iArr[0] & i) != 0;
        autoDownloadSettingObject.other_users = (iArr[1] & i) != 0;
        autoDownloadSettingObject.groups = (iArr[2] & i) != 0;
        autoDownloadSettingObject.channels = (i & iArr[3]) != 0;
        autoDownloadSettingObject.max_download_size = getMaxDownloadSize_ink_KB(preset.sizes[i2]);
        return autoDownloadSettingObject;
    }

    public static int getSwipeGestureValue(SettingModels.ChatListSwipeGestureType chatListSwipeGestureType) {
        if (chatListSwipeGestureType == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType[chatListSwipeGestureType.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return i != 5 ? 0 : 4;
        }
        return 3;
    }

    public static SettingModels.ChatListSwipeGestureType getSwipeGestureCoreValue(int i) {
        if (i == 0) {
            return SettingModels.ChatListSwipeGestureType.Pin;
        }
        if (i == 1) {
            return SettingModels.ChatListSwipeGestureType.Read;
        }
        if (i == 2) {
            return SettingModels.ChatListSwipeGestureType.Mute;
        }
        if (i == 3) {
            return SettingModels.ChatListSwipeGestureType.Delete;
        }
        if (i != 4) {
            return null;
        }
        return SettingModels.ChatListSwipeGestureType.ChangeFolder;
    }

    public static int getAutoNightModeValue(SettingModels.AutoNightModeType autoNightModeType) {
        if (autoNightModeType == SettingModels.AutoNightModeType.Disable) {
            return 0;
        }
        if (autoNightModeType == SettingModels.AutoNightModeType.Adaptive) {
            return 2;
        }
        return autoNightModeType == SettingModels.AutoNightModeType.Scheduled ? 1 : 3;
    }

    public static SettingModels.AutoNightModeType getAutoNightModeCoreValue(int i) {
        if (i == 0) {
            return SettingModels.AutoNightModeType.Disable;
        }
        if (i == 1) {
            return SettingModels.AutoNightModeType.Scheduled;
        }
        if (i != 2) {
            return null;
        }
        return SettingModels.AutoNightModeType.Adaptive;
    }

    public static int getKeepMediaValue(SettingModels.KeepMediaPeriod keepMediaPeriod) {
        if (keepMediaPeriod == null) {
            return 2;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod[keepMediaPeriod.ordinal()];
        if (i == 1) {
            return 3;
        }
        if (i != 2) {
            return i != 3 ? 2 : 1;
        }
        return 0;
    }

    public static SettingModels.KeepMediaPeriod getKeepMediaCoreValue(int i) {
        if (i == 0) {
            return SettingModels.KeepMediaPeriod.OneWeek;
        }
        if (i == 1) {
            return SettingModels.KeepMediaPeriod.OneMonth;
        }
        if (i == 2) {
            return SettingModels.KeepMediaPeriod.Forever;
        }
        if (i == 3) {
            return SettingModels.KeepMediaPeriod.ThreeDays;
        }
        return SettingModels.KeepMediaPeriod.Forever;
    }

    /* renamed from: androidMessenger.utilites.ContactConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$StickerSettingObject$SuggestTypeEnum;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject;

        static {
            int[] iArr = new int[SettingModels.StickerSettingObject.SuggestTypeEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$StickerSettingObject$SuggestTypeEnum = iArr;
            try {
                iArr[SettingModels.StickerSettingObject.SuggestTypeEnum.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$StickerSettingObject$SuggestTypeEnum[SettingModels.StickerSettingObject.SuggestTypeEnum.MyStickers.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$StickerSettingObject$SuggestTypeEnum[SettingModels.StickerSettingObject.SuggestTypeEnum.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SettingModels.KeepMediaPeriod.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod = iArr2;
            try {
                iArr2[SettingModels.KeepMediaPeriod.ThreeDays.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod[SettingModels.KeepMediaPeriod.OneWeek.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod[SettingModels.KeepMediaPeriod.OneMonth.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$KeepMediaPeriod[SettingModels.KeepMediaPeriod.Forever.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[SettingModels.ChatListSwipeGestureType.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType = iArr3;
            try {
                iArr3[SettingModels.ChatListSwipeGestureType.Pin.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType[SettingModels.ChatListSwipeGestureType.Read.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType[SettingModels.ChatListSwipeGestureType.Mute.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType[SettingModels.ChatListSwipeGestureType.Delete.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ChatListSwipeGestureType[SettingModels.ChatListSwipeGestureType.ChangeFolder.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[SettingModels.ImportanceObject.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject = iArr4;
            try {
                iArr4[SettingModels.ImportanceObject.Low.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject[SettingModels.ImportanceObject.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject[SettingModels.ImportanceObject.High.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$ImportanceObject[SettingModels.ImportanceObject.Urgent.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr5 = new int[SettingModels.PopupObject.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject = iArr5;
            try {
                iArr5[SettingModels.PopupObject.NoPopup.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject[SettingModels.PopupObject.OnlyScreenOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject[SettingModels.PopupObject.OnlyScreenOff.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$PopupObject[SettingModels.PopupObject.Always.ordinal()] = 4;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr6 = new int[SettingModels.VibrateObject.values().length];
            $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject = iArr6;
            try {
                iArr6[SettingModels.VibrateObject.Disabled.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject[SettingModels.VibrateObject.Default.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject[SettingModels.VibrateObject.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject[SettingModels.VibrateObject.Long.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$SettingModels$VibrateObject[SettingModels.VibrateObject.OnlySilent.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }

    public static int getStickerSuggestTypeValue(SettingModels.StickerSettingObject.SuggestTypeEnum suggestTypeEnum) {
        if (suggestTypeEnum == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$SettingModels$StickerSettingObject$SuggestTypeEnum[suggestTypeEnum.ordinal()];
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public static SettingModels.StickerSettingObject.SuggestTypeEnum getStickerSuggestTypeValueCore(int i) {
        if (i == 1) {
            return SettingModels.StickerSettingObject.SuggestTypeEnum.MyStickers;
        }
        if (i != 2) {
            return SettingModels.StickerSettingObject.SuggestTypeEnum.All;
        }
        return SettingModels.StickerSettingObject.SuggestTypeEnum.None;
    }

    public static TLRPC$TL_availableReaction convertToAvailableReaction(ReactionObject reactionObject) {
        TLRPC$TL_availableReaction tLRPC$TL_availableReaction = new TLRPC$TL_availableReaction();
        tLRPC$TL_availableReaction.title = reactionObject.name;
        tLRPC$TL_availableReaction.reaction = reactionObject.emoji_char;
        tLRPC$TL_availableReaction.reaction_id = reactionObject.reaction_id;
        return tLRPC$TL_availableReaction;
    }

    public static TLRPC$Reaction convertReaction(ReactionObject reactionObject) {
        TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
        tLRPC$TL_reactionEmoji.emoticon = reactionObject.emoji_char;
        tLRPC$TL_reactionEmoji.reactionId = reactionObject.reaction_id;
        return tLRPC$TL_reactionEmoji;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.aaap.messengercore.model.ChatReactionSetting convertReactionSetting(org.rbmain.tgnet.TLRPC$ChatReactions r3) {
        /*
            ir.aaap.messengercore.model.ChatReactionSetting r0 = new ir.aaap.messengercore.model.ChatReactionSetting
            r0.<init>()
            boolean r1 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_chatReactionsAll
            if (r1 == 0) goto Le
            ir.aaap.messengercore.model.ChatReactionSetting$ReactionType r3 = ir.aaap.messengercore.model.ChatReactionSetting.ReactionType.All
            r0.reaction_type = r3
            goto L41
        Le:
            boolean r1 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_chatReactionsSome
            if (r1 == 0) goto L3d
            org.rbmain.tgnet.TLRPC$TL_chatReactionsSome r3 = (org.rbmain.tgnet.TLRPC$TL_chatReactionsSome) r3
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Reaction> r1 = r3.reactions
            if (r1 == 0) goto L3d
            ir.aaap.messengercore.model.ChatReactionSetting$ReactionType r1 = ir.aaap.messengercore.model.ChatReactionSetting.ReactionType.Selected
            r0.reaction_type = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.selected_reactions = r1
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Reaction> r3 = r3.reactions
            java.util.Iterator r3 = r3.iterator()
        L29:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L41
            java.lang.Object r1 = r3.next()
            org.rbmain.tgnet.TLRPC$Reaction r1 = (org.rbmain.tgnet.TLRPC$Reaction) r1
            java.util.ArrayList<java.lang.String> r2 = r0.selected_reactions
            java.lang.String r1 = r1.reactionId
            r2.add(r1)
            goto L29
        L3d:
            ir.aaap.messengercore.model.ChatReactionSetting$ReactionType r3 = ir.aaap.messengercore.model.ChatReactionSetting.ReactionType.Disabled
            r0.reaction_type = r3
        L41:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.ContactConverter.convertReactionSetting(org.rbmain.tgnet.TLRPC$ChatReactions):ir.aaap.messengercore.model.ChatReactionSetting");
    }
}
