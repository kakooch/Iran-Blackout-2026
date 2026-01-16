package ir.nasim;

import okio.Utf8;

/* loaded from: classes8.dex */
public abstract class OW4 {
    public static int a = 4;

    public static int a(int i) {
        return 4 - (i % 4);
    }

    public static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\n' || cCharAt == '\r') {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int c(CharSequence charSequence, int i) {
        int length = charSequence.length();
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != ' ') {
                switch (cCharAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static boolean d(CharSequence charSequence) {
        int length = charSequence.length();
        return i(' ', charSequence, 0, length) != length;
    }

    public static boolean e(CharSequence charSequence) {
        return c(charSequence, 0) == -1;
    }

    public static boolean f(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i);
        switch (cCharAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (cCharAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (cCharAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (cCharAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean g(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static CharSequence h(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 0) {
                if (sb == null) {
                    sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                }
                sb.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static int i(char c, CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int j(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }
}
