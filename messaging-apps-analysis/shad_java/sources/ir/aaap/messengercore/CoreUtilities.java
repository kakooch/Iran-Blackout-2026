package ir.aaap.messengercore;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class CoreUtilities {
    private static final Pattern sPattern = Pattern.compile("^989\\d{9}$");

    /* loaded from: classes3.dex */
    public enum UsernameCheckType {
        Ok,
        IsEmpty,
        ShorterThan5,
        LongerThan32,
        InvalidChar,
        StartWithNumber,
        StartOrEndWithUnderLine,
        Exist
    }

    public static boolean isNotEmpty(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isValidPhoneNumber(String str) {
        if (checkPhoneNumber(str)) {
            return sPattern.matcher(str).matches();
        }
        return true;
    }

    public static boolean checkPhoneNumber(String str) {
        return isEmpty(str) || str.startsWith("98") || str.startsWith("+98");
    }

    public static boolean checkPassword(String str) {
        return str.length() >= 5 && str.length() <= 64;
    }

    public static UsernameCheckType checkUserNameWithLengthCheck(String str) {
        if (str == null) {
            return UsernameCheckType.IsEmpty;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return UsernameCheckType.IsEmpty;
        }
        if (strTrim.length() < 5) {
            return UsernameCheckType.ShorterThan5;
        }
        if (strTrim.length() > 32) {
            return UsernameCheckType.LongerThan32;
        }
        if (str.startsWith("_") || str.endsWith("_")) {
            return UsernameCheckType.StartOrEndWithUnderLine;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= '0' && cCharAt <= '9') {
            return UsernameCheckType.StartWithNumber;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt2 = str.charAt(i);
            if ((cCharAt2 < '0' || cCharAt2 > '9') && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && cCharAt2 != '_'))) {
                return UsernameCheckType.InvalidChar;
            }
        }
        return UsernameCheckType.Ok;
    }

    public static UsernameCheckType checkUserName(String str) {
        if (str == null) {
            return UsernameCheckType.IsEmpty;
        }
        if (str.trim().length() == 0) {
            return UsernameCheckType.IsEmpty;
        }
        if (str.startsWith("_") || str.endsWith("_")) {
            return UsernameCheckType.StartOrEndWithUnderLine;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= '0' && cCharAt <= '9') {
            return UsernameCheckType.StartWithNumber;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt2 = str.charAt(i);
            if ((cCharAt2 < '0' || cCharAt2 > '9') && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && cCharAt2 != '_'))) {
                return UsernameCheckType.InvalidChar;
            }
        }
        return UsernameCheckType.Ok;
    }
}
