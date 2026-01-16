package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class T88 {
    private static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final EW4 a = new EW4();
    private final StringBuilder b = new StringBuilder();

    private void a(U88 u88, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                u88.z((String) AbstractC20011rK.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrR0 = AbstractC9683aN7.R0(str, "\\.");
        String str2 = strArrR0[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            u88.y(str2.substring(0, iIndexOf2));
            u88.x(str2.substring(iIndexOf2 + 1));
        } else {
            u88.y(str2);
        }
        if (strArrR0.length > 1) {
            u88.w((String[]) AbstractC9683aN7.H0(strArrR0, 1, strArrR0.length));
        }
    }

    private static boolean b(EW4 ew4) {
        int iF = ew4.f();
        int iG = ew4.g();
        byte[] bArrE = ew4.e();
        if (iF + 2 > iG) {
            return false;
        }
        int i = iF + 1;
        if (bArrE[iF] != 47) {
            return false;
        }
        int i2 = iF + 2;
        if (bArrE[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iG) {
                ew4.T(iG - ew4.f());
                return true;
            }
            if (((char) bArrE[i2]) == '*' && ((char) bArrE[i3]) == '/') {
                i2 += 2;
                iG = i2;
            } else {
                i2 = i3;
            }
        }
    }

    private static boolean c(EW4 ew4) {
        char cK = k(ew4, ew4.f());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        ew4.T(1);
        return true;
    }

    private static void e(String str, U88 u88) {
        Matcher matcher = d.matcher(AbstractC14083hK.e(str));
        if (!matcher.matches()) {
            AbstractC18815pI3.k("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) AbstractC20011rK.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                u88.t(3);
                break;
            case "em":
                u88.t(2);
                break;
            case "px":
                u88.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        u88.s(Float.parseFloat((String) AbstractC20011rK.e(matcher.group(1))));
    }

    private static String f(EW4 ew4, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iF = ew4.f();
        int iG = ew4.g();
        while (iF < iG && !z) {
            char c2 = (char) ew4.e()[iF];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                iF++;
                sb.append(c2);
            }
        }
        ew4.T(iF - ew4.f());
        return sb.toString();
    }

    static String g(EW4 ew4, StringBuilder sb) {
        n(ew4);
        if (ew4.a() == 0) {
            return null;
        }
        String strF = f(ew4, sb);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) ew4.F());
    }

    private static String h(EW4 ew4, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iF = ew4.f();
            String strG = g(ew4, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || Separators.SEMICOLON.equals(strG)) {
                ew4.S(iF);
                z = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    private static String i(EW4 ew4, StringBuilder sb) {
        n(ew4);
        if (ew4.a() < 5 || !"::cue".equals(ew4.C(5))) {
            return null;
        }
        int iF = ew4.f();
        String strG = g(ew4, sb);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            ew4.S(iF);
            return "";
        }
        String strL = Separators.LPAREN.equals(strG) ? l(ew4) : null;
        if (Separators.RPAREN.equals(g(ew4, sb))) {
            return strL;
        }
        return null;
    }

    private static void j(EW4 ew4, U88 u88, StringBuilder sb) {
        n(ew4);
        String strF = f(ew4, sb);
        if (!"".equals(strF) && ":".equals(g(ew4, sb))) {
            n(ew4);
            String strH = h(ew4, sb);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iF = ew4.f();
            String strG = g(ew4, sb);
            if (!Separators.SEMICOLON.equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    ew4.S(iF);
                }
            }
            if ("color".equals(strF)) {
                u88.q(GX0.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                u88.n(GX0.b(strH));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    u88.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        u88.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z = false;
                }
                u88.p(z);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if ("underline".equals(strH)) {
                    u88.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                u88.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if ("bold".equals(strH)) {
                    u88.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if ("italic".equals(strH)) {
                    u88.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, u88);
            }
        }
    }

    private static char k(EW4 ew4, int i) {
        return (char) ew4.e()[i];
    }

    private static String l(EW4 ew4) {
        int iF = ew4.f();
        int iG = ew4.g();
        boolean z = false;
        while (iF < iG && !z) {
            int i = iF + 1;
            z = ((char) ew4.e()[iF]) == ')';
            iF = i;
        }
        return ew4.C((iF - 1) - ew4.f()).trim();
    }

    static void m(EW4 ew4) {
        while (!TextUtils.isEmpty(ew4.q())) {
        }
    }

    static void n(EW4 ew4) {
        while (true) {
            for (boolean z = true; ew4.a() > 0 && z; z = false) {
                if (c(ew4) || b(ew4)) {
                    break;
                }
            }
            return;
        }
    }

    public List d(EW4 ew4) {
        this.b.setLength(0);
        int iF = ew4.f();
        m(ew4);
        this.a.Q(ew4.e(), ew4.f());
        this.a.S(iF);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.a, this.b);
            if (strI == null) {
                return arrayList;
            }
            if (!"{".equals(g(this.a, this.b))) {
                return arrayList;
            }
            U88 u88 = new U88();
            a(u88, strI);
            String str = null;
            boolean z = false;
            while (!z) {
                int iF2 = this.a.f();
                String strG = g(this.a, this.b);
                boolean z2 = strG == null || "}".equals(strG);
                if (!z2) {
                    this.a.S(iF2);
                    j(this.a, u88, this.b);
                }
                str = strG;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(u88);
            }
        }
    }
}
