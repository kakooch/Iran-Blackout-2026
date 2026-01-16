package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: ir.nasim.Hm2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5004Hm2 {
    public static final C5004Hm2 a = new C5004Hm2();
    private static final HashMap b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put("mp3", -1);
        map.put("m4a", -1);
        map.put("ogg", -1);
        map.put("flac", -1);
        map.put("alac", -1);
        map.put("m3u", -1);
        map.put("wav", -1);
        map.put("wma", -1);
        map.put("aac", -1);
        map.put("doc", -3);
        map.put("docx", -3);
        map.put("docm", -3);
        map.put("dot", -3);
        map.put("dotx", -3);
        map.put("epub", -3);
        map.put("fb2", -3);
        map.put("xml", -3);
        map.put(ParameterNames.INFO, -3);
        map.put("tex", -3);
        map.put("stw", -3);
        map.put("sxw", -3);
        map.put("txt", -3);
        map.put("xlc", -3);
        map.put("odf", -3);
        map.put("odt", -3);
        map.put("ott", -3);
        map.put("rtf", -3);
        map.put("pages", -3);
        map.put("ini", -3);
        map.put("xls", -8);
        map.put("xlsx", -8);
        map.put("xlsm", -8);
        map.put("xlsb", -8);
        map.put("numbers", -8);
        map.put("jpg", -2);
        map.put("jpeg", -2);
        map.put("jp2", -2);
        map.put("jps", -2);
        map.put("gif", -2);
        map.put("tiff", -2);
        map.put("png", -2);
        map.put("psd", -2);
        map.put("webp", -2);
        map.put("ico", -2);
        map.put("pcx", -2);
        map.put("tga", -2);
        map.put("raw", -2);
        map.put("svg", -2);
        map.put("mp4", -5);
        map.put("3gp", -5);
        map.put("m4v", -5);
        map.put("webm", -5);
        map.put("mkv", -5);
        map.put("mov", -5);
        map.put("vob", -5);
        map.put("mts", -5);
        map.put("ppt", -9);
        map.put("key", -9);
        map.put("keynote", -9);
        map.put("pdf", -13);
        map.put("apk", -6);
        map.put("rar", -4);
        map.put("zip", -7);
        map.put("csv", -10);
        map.put("xhtm", -11);
        map.put("htm", -11);
        map.put("html", -12);
    }

    private C5004Hm2() {
    }

    public static final int a(String str) {
        AbstractC13042fc3.i(str, "extension");
        HashMap map = b;
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        Integer num = (Integer) map.get(lowerCase);
        if (num != null) {
            return num.intValue();
        }
        if (AbstractC20762sZ6.X(str, Separators.SLASH, false, 2, null)) {
            String strSubstring = str.substring(AbstractC20762sZ6.r0(str, Separators.SLASH, 0, false, 6, null) + 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Locale locale2 = Locale.getDefault();
            AbstractC13042fc3.h(locale2, "getDefault(...)");
            String lowerCase2 = strSubstring.toLowerCase(locale2);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            Integer num2 = (Integer) map.get(lowerCase2);
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }
}
