package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.gZ2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13630gZ2 {
    private static final Map a = b();
    private static final Pattern b = Pattern.compile("^&#[Xx]?");

    public static String a(String str) throws NumberFormatException {
        Matcher matcher = b.matcher(str);
        if (!matcher.find()) {
            String str2 = (String) a.get(str.substring(1, str.length() - 1));
            return str2 != null ? str2 : str;
        }
        try {
            int i = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
            return i == 0 ? "�" : new String(Character.toChars(i));
        } catch (IllegalArgumentException unused) {
            return "�";
        }
    }

    private static Map b() throws IOException {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AbstractC13630gZ2.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName("UTF-8")));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        map.put("NewLine", Separators.RETURN);
                        return map;
                    }
                    if (line.length() != 0) {
                        int iIndexOf = line.indexOf(Separators.EQUALS);
                        map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                    }
                } finally {
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }
}
