package ir.nasim;

import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import java.util.List;
import livekit.org.webrtc.WebrtcBuildVersion;

/* renamed from: ir.nasim.yH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24236yH extends VW7 {
    private final String b = "PREFS_SHOW_ARBAEEN_DIALOG_COUNT";
    private final SharedPreferences c;
    private final List d;
    private final List e;

    public C24236yH() {
        SharedPreferences sharedPreferences = C5721Ko.a.d().getSharedPreferences("status.ini", 0);
        AbstractC13042fc3.h(sharedPreferences, "getSharedPreferences(...)");
        this.c = sharedPreferences;
        this.d = AbstractC10360bX0.p("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "آ", "ا", "ب", "پ", "ت", "ث", "ج", "چ", "ح", "خ", "د", "ذ", "ر", "ز", "ژ", "س", "ش", "ص", "ض", "ط", "ظ", "ع", "غ", "ف", "ق", "ک", "گ", "ل", "م", "ن", "و", "ه", "ی", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", Separators.LPAREN, Separators.RPAREN, ":", Separators.DOT, "!", Separators.QUESTION, "؟", ",", "،", "»", "«", Separators.SP);
        this.e = AbstractC10360bX0.p("00", "01", "02", WebrtcBuildVersion.webrtc_commit, "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "99");
    }

    public final String P0(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (this.d.contains(String.valueOf(cCharAt))) {
                str2 = str2 + this.e.get(this.d.indexOf(String.valueOf(cCharAt)));
            }
        }
        return str2;
    }

    public final int R0() {
        return this.c.getInt(this.b, 1);
    }

    public final void S0(String str) {
        AbstractC13042fc3.i(str, "type");
        HashMap map = new HashMap();
        map.put("event_type", str);
        C3343Am.i("arbaeen_ussd_click", map);
    }

    public final String T0(String str, int i) {
        AbstractC13042fc3.i(str, "s");
        if (JF5.g()) {
            return XY6.e(str.length() + Separators.SLASH + i);
        }
        return XY6.h(str.length() + Separators.SLASH + i);
    }

    public final void U0(int i) {
        this.c.edit().putInt(this.b, i).apply();
    }
}
