package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.protobuf.StringValue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes6.dex */
public abstract class GY6 {
    public static final String a(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return XY6.e(str);
    }

    public static final String b(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return XY6.h(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String c(java.lang.String r8, android.content.Context r9) {
        /*
            java.lang.String r0 = "toLowerCase(...)"
            java.lang.String r1 = "<this>"
            ir.nasim.AbstractC13042fc3.i(r8, r1)
            java.lang.String r1 = "context"
            ir.nasim.AbstractC13042fc3.i(r9, r1)
            ir.nasim.cq r1 = ir.nasim.AbstractC5969Lp4.d()     // Catch: java.lang.Exception -> L69
            ir.nasim.Gg2 r2 = ir.nasim.EnumC4716Gg2.Z3     // Catch: java.lang.Exception -> L69
            boolean r1 = r1.w0(r2)     // Catch: java.lang.Exception -> L69
            java.util.Locale r2 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> L69
            java.lang.String r3 = r8.toLowerCase(r2)     // Catch: java.lang.Exception -> L69
            ir.nasim.AbstractC13042fc3.h(r3, r0)     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "errorcode"
            r5 = 0
            r6 = 2
            r7 = 0
            boolean r3 = ir.nasim.AbstractC14836iZ6.X(r3, r4, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r3 != 0) goto L6b
            java.lang.String r3 = r8.toLowerCase(r2)     // Catch: java.lang.Exception -> L69
            ir.nasim.AbstractC13042fc3.h(r3, r0)     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "header"
            boolean r3 = ir.nasim.AbstractC14836iZ6.X(r3, r4, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r3 != 0) goto L6b
            java.lang.String r3 = r8.toLowerCase(r2)     // Catch: java.lang.Exception -> L69
            ir.nasim.AbstractC13042fc3.h(r3, r0)     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "500"
            boolean r3 = ir.nasim.AbstractC14836iZ6.X(r3, r4, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r3 != 0) goto L6b
            java.lang.String r3 = r8.toLowerCase(r2)     // Catch: java.lang.Exception -> L69
            ir.nasim.AbstractC13042fc3.h(r3, r0)     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "upstream"
            boolean r3 = ir.nasim.AbstractC14836iZ6.X(r3, r4, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r3 != 0) goto L6b
            java.lang.String r2 = r8.toLowerCase(r2)     // Catch: java.lang.Exception -> L69
            ir.nasim.AbstractC13042fc3.h(r2, r0)     // Catch: java.lang.Exception -> L69
            java.lang.String r0 = "401"
            boolean r0 = ir.nasim.AbstractC14836iZ6.X(r2, r0, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L67
            goto L6b
        L67:
            r0 = r7
            goto L6c
        L69:
            r9 = move-exception
            goto L88
        L6b:
            r0 = 1
        L6c:
            if (r1 == 0) goto L77
            if (r0 == 0) goto L77
            int r0 = ir.nasim.AbstractC12217eE5.card_payment_unowkn_server_error     // Catch: java.lang.Exception -> L69
            java.lang.String r8 = r9.getString(r0)     // Catch: java.lang.Exception -> L69
            goto L8d
        L77:
            java.lang.String r9 = "desc"
            boolean r9 = ir.nasim.AbstractC14836iZ6.X(r8, r9, r7, r6, r5)     // Catch: java.lang.Exception -> L69
            if (r9 == 0) goto L8d
            java.lang.String r9 = d(r8)     // Catch: java.lang.Exception -> L69
            if (r9 != 0) goto L86
            goto L8d
        L86:
            r8 = r9
            goto L8d
        L88:
            java.lang.String r0 = "NON_FATAL_EXCEPTION"
            ir.nasim.C19406qI3.d(r0, r9)
        L8d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GY6.c(java.lang.String, android.content.Context):java.lang.String");
    }

    private static final String d(String str) {
        NU3 nu3D;
        MU3 mu3;
        String strA;
        OU3 ou3C = C20644sM5.c(new C20644sM5("desc = (.+)"), str, 0, 2, null);
        if (ou3C == null || (nu3D = ou3C.d()) == null || (mu3 = nu3D.get(1)) == null || (strA = mu3.a()) == null) {
            return null;
        }
        return AbstractC20762sZ6.n1(strA).toString();
    }

    public static final String e(String str) {
        AbstractC13042fc3.i(str, "<this>");
        String strSubstring = str.substring(AbstractC20762sZ6.r0(str, Separators.SLASH, 0, false, 6, null) + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean f(Exception exc) {
        AbstractC13042fc3.i(exc, "<this>");
        String localizedMessage = exc.getLocalizedMessage();
        if (localizedMessage != null) {
            String lowerCase = localizedMessage.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && AbstractC20762sZ6.X(lowerCase, "errorcode", false, 2, null)) {
                return true;
            }
        }
        String localizedMessage2 = exc.getLocalizedMessage();
        if (localizedMessage2 != null) {
            String lowerCase2 = localizedMessage2.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            if (lowerCase2 != null && AbstractC20762sZ6.X(lowerCase2, "header", false, 2, null)) {
                return true;
            }
        }
        String localizedMessage3 = exc.getLocalizedMessage();
        if (localizedMessage3 != null) {
            String lowerCase3 = localizedMessage3.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
            if (lowerCase3 != null && AbstractC20762sZ6.X(lowerCase3, "500", false, 2, null)) {
                return true;
            }
        }
        String localizedMessage4 = exc.getLocalizedMessage();
        if (localizedMessage4 != null) {
            String lowerCase4 = localizedMessage4.toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase4, "toLowerCase(...)");
            if (lowerCase4 != null && AbstractC20762sZ6.X(lowerCase4, "upstream", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final String g(String str) {
        AbstractC13042fc3.i(str, "<this>");
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        AbstractC13042fc3.g(numberFormat, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.applyPattern("#,###");
        String str2 = decimalFormat.format(Double.parseDouble(b(str)));
        AbstractC13042fc3.h(str2, "format(...)");
        return str2;
    }

    public static final StringValue h(String str) {
        AbstractC13042fc3.i(str, "<this>");
        StringValue stringValueOf = StringValue.of(str);
        AbstractC13042fc3.h(stringValueOf, "of(...)");
        return stringValueOf;
    }
}
