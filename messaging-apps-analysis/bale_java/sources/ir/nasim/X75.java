package ir.nasim;

import com.google.i18n.phonenumbers.NumberParseException;

/* loaded from: classes5.dex */
public final class X75 {
    public static final X75 a = new X75();

    private X75() {
    }

    public static /* synthetic */ Long b(X75 x75, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "IR";
        }
        return x75.a(str, str2);
    }

    public final Long a(String str, String str2) {
        String string;
        String strK;
        AbstractC13042fc3.i(str2, "defaultIsoCountry");
        try {
            com.google.i18n.phonenumbers.g gVarH = com.google.i18n.phonenumbers.f.o().H(str, str2);
            if (gVarH != null) {
                int iC = gVarH.c();
                long jF = gVarH.f();
                StringBuilder sb = new StringBuilder();
                sb.append(iC);
                sb.append(jF);
                string = sb.toString();
            } else {
                string = null;
            }
        } catch (NumberParseException unused) {
            string = "";
            if (str != null && (strK = new C20644sM5("[^\\d]").k(str, "")) != null) {
                string = strK;
            }
        } catch (Exception unused2) {
            string = str;
        }
        try {
            AbstractC13042fc3.f(string);
            return Long.valueOf(Long.parseLong(string));
        } catch (Exception e) {
            C19406qI3.a("PhoneNumberUtil", "Can't parse number " + str, e);
            return null;
        }
    }
}
