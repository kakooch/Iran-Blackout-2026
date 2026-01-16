package ir.nasim;

/* loaded from: classes8.dex */
public abstract class CF4 {
    public static final AF4 a(String str) {
        AbstractC13042fc3.i(str, "value");
        if (AbstractC20153rZ6.S(str, "0x", false, 2, null) || AbstractC20153rZ6.S(str, "0X", false, 2, null)) {
            String strSubstring = str.substring(2);
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return new AF4(strSubstring, 16);
        }
        if (!AbstractC20153rZ6.S(str, "0b", false, 2, null) && !AbstractC20153rZ6.S(str, "0B", false, 2, null)) {
            return new AF4(str, 10);
        }
        String strSubstring2 = str.substring(2);
        AbstractC13042fc3.h(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return new AF4(strSubstring2, 2);
    }
}
