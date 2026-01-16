package ir.eitaa.messenger;

import android.text.TextUtils;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.tgnet.TLRPC$TL_userContact_old2;
import ir.eitaa.tgnet.TLRPC$TL_userDeleted_old2;
import ir.eitaa.tgnet.TLRPC$TL_userEmpty;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_userSelf_old3;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;

/* loaded from: classes.dex */
public class UserObject {
    public static boolean isReplyUser(long did) {
        return did == 708513 || did == 1271266957;
    }

    public static boolean isDeleted(TLRPC$User user) {
        return user == null || (user instanceof TLRPC$TL_userDeleted_old2) || (user instanceof TLRPC$TL_userEmpty) || user.deleted;
    }

    public static boolean isContact(TLRPC$User user) {
        return user != null && ((user instanceof TLRPC$TL_userContact_old2) || user.contact || user.mutual_contact);
    }

    public static boolean isUserSelf(TLRPC$User user) {
        return user != null && ((user instanceof TLRPC$TL_userSelf_old3) || user.self);
    }

    public static boolean isReplyUser(TLRPC$User user) {
        if (user != null) {
            long j = user.id;
            if (j == 708513 || j == 1271266957) {
                return true;
            }
        }
        return false;
    }

    public static String getUserName(TLRPC$User user) {
        if (user == null || isDeleted(user)) {
            return LocaleController.getString("HiddenName", R.string.HiddenName);
        }
        String name = ContactsController.formatName(user.first_name, user.last_name);
        if (name.length() != 0 || TextUtils.isEmpty(user.phone)) {
            return name;
        }
        return PhoneFormat.getInstance().format("+" + user.phone);
    }

    public static String getFirstName(TLRPC$User user) {
        return getFirstName(user, true);
    }

    public static String getFirstName(TLRPC$User user, boolean allowShort) {
        if (user == null || isDeleted(user)) {
            return "DELETED";
        }
        String str = user.first_name;
        if (TextUtils.isEmpty(str)) {
            str = user.last_name;
        } else if (!allowShort && str.length() <= 2) {
            return ContactsController.formatName(user.first_name, user.last_name);
        }
        return !TextUtils.isEmpty(str) ? str : LocaleController.getString("HiddenName", R.string.HiddenName);
    }

    public static boolean hasPhoto(TLRPC$User user) {
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        return (user == null || (tLRPC$UserProfilePhoto = user.photo) == null || (tLRPC$UserProfilePhoto instanceof TLRPC$TL_userProfilePhotoEmpty)) ? false : true;
    }

    public static TLRPC$UserProfilePhoto getPhoto(TLRPC$User user) {
        if (hasPhoto(user)) {
            return user.photo;
        }
        return null;
    }
}
