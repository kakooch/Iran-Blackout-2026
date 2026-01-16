package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yF4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24223yF4 {
    private static final String[] a = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] b = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] c = {"صفر", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه", "ده", "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده"};
    private static final String[] d = {"", "", "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};
    private static final String[] e = {"", "یکصد", "دویست", "سیصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد"};

    public static String a(long j, boolean z) {
        return z ? c(j) : b(j);
    }

    private static String b(long j) {
        if (j < 20) {
            return a[(int) j];
        }
        String str = "";
        if (j < 100) {
            StringBuilder sb = new StringBuilder();
            sb.append(b[(int) (j / 10)]);
            long j2 = j % 10;
            if (j2 > 0) {
                str = Separators.SP + b(j2);
            }
            sb.append(str);
            return sb.toString();
        }
        if (j < 1000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a[(int) (j / 100)]);
            sb2.append(" Hundred");
            long j3 = j % 100;
            if (j3 > 0) {
                str = " and " + b(j3);
            }
            sb2.append(str);
            return sb2.toString();
        }
        if (j < 1000000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b(j / 1000));
            sb3.append(" Thousand");
            long j4 = j % 1000;
            if (j4 > 0) {
                str = Separators.SP + b(j4);
            }
            sb3.append(str);
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b(j / 1000000));
        sb4.append(" Million");
        long j5 = j % 1000000;
        if (j5 > 0) {
            str = Separators.SP + b(j5);
        }
        sb4.append(str);
        return sb4.toString();
    }

    private static String c(long j) {
        if (j < 20) {
            return c[(int) j];
        }
        String str = "";
        if (j < 100) {
            StringBuilder sb = new StringBuilder();
            sb.append(d[(int) (j / 10)]);
            long j2 = j % 10;
            if (j2 > 0) {
                str = " و " + c(j2);
            }
            sb.append(str);
            return sb.toString();
        }
        if (j < 1000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e[(int) (j / 100)]);
            long j3 = j % 100;
            if (j3 > 0) {
                str = " و " + c(j3);
            }
            sb2.append(str);
            return sb2.toString();
        }
        if (j < 1000000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c(j / 1000));
            sb3.append(" هزار");
            long j4 = j % 1000;
            if (j4 > 0) {
                str = " و " + c(j4);
            }
            sb3.append(str);
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(c(j / 1000000));
        sb4.append(" میلیون");
        long j5 = j % 1000000;
        if (j5 > 0) {
            str = " و " + c(j5);
        }
        sb4.append(str);
        return sb4.toString();
    }
}
