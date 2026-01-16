package ir.nasim;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.f07, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12674f07 extends WC6 {
    private static final Pattern q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern r = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder o;
    private final ArrayList p;

    public C12674f07() {
        super("SubripDecoder");
        this.o = new StringBuilder();
        this.p = new ArrayList();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.C14451hw1 B(android.text.Spanned r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12674f07.B(android.text.Spanned, java.lang.String):ir.nasim.hw1");
    }

    private Charset C(EW4 ew4) {
        Charset charsetN = ew4.N();
        return charsetN != null ? charsetN : AbstractC12884fL0.c;
    }

    static float D(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long E(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) AbstractC20011rK.e(matcher.group(i + 2))) * 60000) + (Long.parseLong((String) AbstractC20011rK.e(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    private String F(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = r.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) throws NumberFormatException {
        String str;
        ArrayList arrayList = new ArrayList();
        YI3 yi3 = new YI3();
        EW4 ew4 = new EW4(bArr, i);
        Charset charsetC = C(ew4);
        while (true) {
            String strR = ew4.r(charsetC);
            int i2 = 0;
            if (strR == null) {
                break;
            }
            if (strR.length() != 0) {
                try {
                    Integer.parseInt(strR);
                    String strR2 = ew4.r(charsetC);
                    if (strR2 == null) {
                        AbstractC18815pI3.k("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = q.matcher(strR2);
                    if (matcher.matches()) {
                        yi3.a(E(matcher, 1));
                        yi3.a(E(matcher, 6));
                        this.o.setLength(0);
                        this.p.clear();
                        for (String strR3 = ew4.r(charsetC); !TextUtils.isEmpty(strR3); strR3 = ew4.r(charsetC)) {
                            if (this.o.length() > 0) {
                                this.o.append("<br>");
                            }
                            this.o.append(F(strR3, this.p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.o.toString());
                        while (true) {
                            if (i2 >= this.p.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.p.get(i2);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(B(spannedFromHtml, str));
                        arrayList.add(C14451hw1.r);
                    } else {
                        AbstractC18815pI3.k("SubripDecoder", "Skipping invalid timing: " + strR2);
                    }
                } catch (NumberFormatException unused) {
                    AbstractC18815pI3.k("SubripDecoder", "Skipping invalid index: " + strR);
                }
            }
        }
        return new C13310g07((C14451hw1[]) arrayList.toArray(new C14451hw1[0]), yi3.d());
    }
}
