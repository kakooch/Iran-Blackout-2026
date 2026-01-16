package org.rbmain.messenger;

import android.text.TextUtils;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.tgnet.TLRPC$EmojiStatus;
import org.rbmain.tgnet.TLRPC$TL_emojiStatus;
import org.rbmain.tgnet.TLRPC$TL_emojiStatusUntil;
import org.rbmain.tgnet.TLRPC$TL_userContact_old2;
import org.rbmain.tgnet.TLRPC$TL_userDeleted_old2;
import org.rbmain.tgnet.TLRPC$TL_userEmpty;
import org.rbmain.tgnet.TLRPC$TL_userSelf_old3;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes4.dex */
public class UserObject {
    public static boolean isReplyUser(long j) {
        return false;
    }

    public static boolean isReplyUser(TLRPC$User tLRPC$User) {
        return false;
    }

    public static boolean isDeleted(TLRPC$User tLRPC$User) {
        return tLRPC$User == null || (tLRPC$User instanceof TLRPC$TL_userDeleted_old2) || (tLRPC$User instanceof TLRPC$TL_userEmpty) || tLRPC$User.deleted;
    }

    public static boolean isContact(TLRPC$User tLRPC$User) {
        return tLRPC$User != null && ((tLRPC$User instanceof TLRPC$TL_userContact_old2) || tLRPC$User.contact || tLRPC$User.mutual_contact);
    }

    public static boolean isUserSelf(TLRPC$User tLRPC$User) {
        return tLRPC$User != null && ((tLRPC$User instanceof TLRPC$TL_userSelf_old3) || tLRPC$User.self);
    }

    public static String getUserName(TLRPC$User tLRPC$User) {
        if (tLRPC$User == null || isDeleted(tLRPC$User)) {
            return LocaleController.getString("HiddenName", ir.medu.shad.R.string.HiddenName);
        }
        String name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
        if (name.length() != 0 || TextUtils.isEmpty(tLRPC$User.phone)) {
            return name;
        }
        return PhoneFormat.getInstance().format("+" + tLRPC$User.phone);
    }

    public static String getFirstName(TLRPC$User tLRPC$User) {
        return getFirstName(tLRPC$User, true);
    }

    public static String getFirstName(TLRPC$User tLRPC$User, boolean z) {
        if (tLRPC$User == null || isDeleted(tLRPC$User)) {
            return LocaleController.getString("HiddenName", ir.medu.shad.R.string.HiddenName);
        }
        String str = tLRPC$User.first_name;
        if (TextUtils.isEmpty(str)) {
            str = tLRPC$User.last_name;
        } else if (!z && str.length() <= 2) {
            return ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
        }
        return !TextUtils.isEmpty(str) ? str : LocaleController.getString("UnknownName", ir.medu.shad.R.string.UnknownName);
    }

    public static String getPublicUsername(TLRPC$User tLRPC$User, boolean z) {
        if (tLRPC$User == null || TextUtils.isEmpty(tLRPC$User.username)) {
            return null;
        }
        return tLRPC$User.username;
    }

    public static String getPublicUsername(TLRPC$User tLRPC$User) {
        return getPublicUsername(tLRPC$User, false);
    }

    public static boolean hasPublicUsername(TLRPC$User tLRPC$User, String str) {
        return (tLRPC$User == null || str == null || !str.equalsIgnoreCase(tLRPC$User.username)) ? false : true;
    }

    public static Long getEmojiStatusDocumentId(TLRPC$User tLRPC$User) {
        if (tLRPC$User == null) {
            return null;
        }
        return getEmojiStatusDocumentId(tLRPC$User.emoji_status);
    }

    public static Long getEmojiStatusDocumentId(TLRPC$EmojiStatus tLRPC$EmojiStatus) {
        if (tLRPC$EmojiStatus == null) {
            return null;
        }
        if (tLRPC$EmojiStatus instanceof TLRPC$TL_emojiStatus) {
            return Long.valueOf(((TLRPC$TL_emojiStatus) tLRPC$EmojiStatus).document_id);
        }
        if (tLRPC$EmojiStatus instanceof TLRPC$TL_emojiStatusUntil) {
            TLRPC$TL_emojiStatusUntil tLRPC$TL_emojiStatusUntil = (TLRPC$TL_emojiStatusUntil) tLRPC$EmojiStatus;
            if (tLRPC$TL_emojiStatusUntil.until > ((int) (System.currentTimeMillis() / 1000))) {
                return Long.valueOf(tLRPC$TL_emojiStatusUntil.document_id);
            }
        }
        return null;
    }
}
