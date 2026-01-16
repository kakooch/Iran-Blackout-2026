package com.google.i18n.phonenumbers;

import android.gov.nist.core.Separators;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.g;
import ir.nasim.C10138b85;
import ir.nasim.C21247tM5;
import ir.nasim.C21921uM5;
import ir.nasim.InterfaceC3515Be4;
import ir.nasim.QU3;
import ir.nasim.Y75;
import ir.nasim.Z75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class f {
    static final String A;
    private static final Pattern B;
    private static final Pattern C;
    static final Pattern D;
    private static final Pattern E;
    private static final Pattern F;
    private static f G;
    private static final Logger h = Logger.getLogger(f.class.getName());
    private static final Map i;
    private static final Set j;
    private static final Set k;
    private static final Map l;
    private static final Map m;
    private static final Map n;
    private static final Map o;
    private static final Pattern p;
    private static final String q;
    static final Pattern r;
    private static final Pattern s;
    private static final Pattern t;
    private static final Pattern u;
    static final Pattern v;
    static final Pattern w;
    private static final Pattern x;
    private static final String y;
    private static final String z;
    private final com.google.i18n.phonenumbers.d a;
    private final Map b;
    private final QU3 c = C21247tM5.b();
    private final Set d = new HashSet(35);
    private final C21921uM5 e = new C21921uM5(100);
    private final Set f = new HashSet(320);
    private final Set g = new HashSet();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[c.values().length];
            c = iArr;
            try {
                iArr[c.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[c.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[c.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[c.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[c.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[c.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[c.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[c.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[c.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[c.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[c.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[b.values().length];
            b = iArr2;
            try {
                iArr2[b.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[b.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[b.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[b.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[g.a.values().length];
            a = iArr3;
            try {
                iArr3[g.a.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[g.a.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[g.a.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[g.a.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public enum b {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum c {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum d {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap map = new HashMap();
        map.put(54, "9");
        i = Collections.unmodifiableMap(map);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        j = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        k = Collections.unmodifiableSet(hashSet2);
        HashMap map2 = new HashMap();
        map2.put('0', '0');
        map2.put('1', '1');
        map2.put('2', '2');
        map2.put('3', '3');
        map2.put('4', '4');
        map2.put('5', '5');
        map2.put('6', '6');
        map2.put('7', '7');
        map2.put('8', '8');
        map2.put('9', '9');
        HashMap map3 = new HashMap(40);
        map3.put('A', '2');
        map3.put('B', '2');
        map3.put('C', '2');
        map3.put('D', '3');
        map3.put('E', '3');
        map3.put('F', '3');
        map3.put('G', '4');
        map3.put('H', '4');
        map3.put('I', '4');
        map3.put('J', '5');
        map3.put('K', '5');
        map3.put('L', '5');
        map3.put('M', '6');
        map3.put('N', '6');
        map3.put('O', '6');
        map3.put('P', '7');
        map3.put('Q', '7');
        map3.put('R', '7');
        map3.put('S', '7');
        map3.put('T', '8');
        map3.put('U', '8');
        map3.put('V', '8');
        map3.put('W', '9');
        map3.put('X', '9');
        map3.put('Y', '9');
        map3.put('Z', '9');
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map3);
        m = mapUnmodifiableMap;
        HashMap map4 = new HashMap(100);
        map4.putAll(mapUnmodifiableMap);
        map4.putAll(map2);
        n = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.putAll(map2);
        map5.put('+', '+');
        map5.put('*', '*');
        map5.put('#', '#');
        l = Collections.unmodifiableMap(map5);
        HashMap map6 = new HashMap();
        for (Character ch : mapUnmodifiableMap.keySet()) {
            map6.put(Character.valueOf(Character.toLowerCase(ch.charValue())), ch);
            map6.put(ch, ch);
        }
        map6.putAll(map2);
        map6.put('-', '-');
        map6.put((char) 65293, '-');
        map6.put((char) 8208, '-');
        map6.put((char) 8209, '-');
        map6.put((char) 8210, '-');
        map6.put((char) 8211, '-');
        map6.put((char) 8212, '-');
        map6.put((char) 8213, '-');
        map6.put((char) 8722, '-');
        map6.put('/', '/');
        map6.put((char) 65295, '/');
        map6.put(' ', ' ');
        map6.put((char) 12288, ' ');
        map6.put((char) 8288, ' ');
        map6.put('.', '.');
        map6.put((char) 65294, '.');
        o = Collections.unmodifiableMap(map6);
        p = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map map7 = m;
        sb.append(Arrays.toString(map7.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map7.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String string = sb.toString();
        q = string;
        r = Pattern.compile("[+＋]+");
        s = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        t = Pattern.compile("(\\p{Nd})");
        u = Pattern.compile("[+＋\\p{Nd}]");
        v = Pattern.compile("[\\\\/] *x");
        w = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        x = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + string + "\\p{Nd}]*";
        y = str;
        String strD = d(",;xｘ#＃~～");
        z = strD;
        A = d("xｘ#＃~～");
        B = Pattern.compile("(?:" + strD + ")$", 66);
        C = Pattern.compile(str + "(?:" + strD + ")?", 66);
        D = Pattern.compile("(\\D+)");
        E = Pattern.compile("(\\$\\d)");
        F = Pattern.compile("\\(?\\$1\\)?");
        G = null;
    }

    f(com.google.i18n.phonenumbers.d dVar, Map map) {
        this.a = dVar;
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.g.add(entry.getKey());
            } else {
                this.f.addAll(list);
            }
        }
        if (this.f.remove("001")) {
            h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.d.addAll((Collection) map.get(1));
    }

    static StringBuilder D(StringBuilder sb) {
        if (x.matcher(sb).matches()) {
            sb.replace(0, sb.length(), G(sb, n, true));
        } else {
            sb.replace(0, sb.length(), F(sb));
        }
        return sb;
    }

    static StringBuilder E(CharSequence charSequence, boolean z2) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            int iDigit = Character.digit(cCharAt, 10);
            if (iDigit != -1) {
                sb.append(iDigit);
            } else if (z2) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static String F(CharSequence charSequence) {
        return E(charSequence, false).toString();
    }

    private static String G(CharSequence charSequence, Map map, boolean z2) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(cCharAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z2) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private void J(CharSequence charSequence, String str, boolean z2, boolean z3, g gVar) throws NumberParseException, NumberFormatException {
        int iZ;
        if (charSequence == null) {
            throw new NumberParseException(NumberParseException.a.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (charSequence.length() > 250) {
            throw new NumberParseException(NumberParseException.a.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb = new StringBuilder();
        String string = charSequence.toString();
        a(string, sb);
        if (!x(sb)) {
            throw new NumberParseException(NumberParseException.a.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (z3 && !b(sb, str)) {
            throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (z2) {
            gVar.F(string);
        }
        String strA = A(sb);
        if (strA.length() > 0) {
            gVar.y(strA);
        }
        Z75 z75Q = q(str);
        StringBuilder sb2 = new StringBuilder();
        try {
            iZ = z(sb, z75Q, sb2, z2, gVar);
        } catch (NumberParseException e) {
            Matcher matcher = r.matcher(sb);
            if (e.a() != NumberParseException.a.INVALID_COUNTRY_CODE || !matcher.lookingAt()) {
                throw new NumberParseException(e.a(), e.getMessage());
            }
            iZ = z(sb.substring(matcher.end()), z75Q, sb2, z2, gVar);
            if (iZ == 0) {
                throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
            }
        }
        if (iZ != 0) {
            String strU = u(iZ);
            if (!strU.equals(str)) {
                z75Q = r(iZ, strU);
            }
        } else {
            sb2.append((CharSequence) D(sb));
            if (str != null) {
                gVar.u(z75Q.a());
            } else if (z2) {
                gVar.a();
            }
        }
        if (sb2.length() < 2) {
            throw new NumberParseException(NumberParseException.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (z75Q != null) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder(sb2);
            C(sb4, z75Q, sb3);
            d dVarO = O(sb4, z75Q);
            if (dVarO != d.TOO_SHORT && dVarO != d.IS_POSSIBLE_LOCAL_ONLY && dVarO != d.INVALID_LENGTH) {
                if (z2 && sb3.length() > 0) {
                    gVar.E(sb3.toString());
                }
                sb2 = sb4;
            }
        }
        int length = sb2.length();
        if (length < 2) {
            throw new NumberParseException(NumberParseException.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (length > 17) {
            throw new NumberParseException(NumberParseException.a.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        N(sb2, gVar);
        gVar.C(Long.parseLong(sb2.toString()));
    }

    private boolean K(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int iEnd = matcher.end();
        Matcher matcher2 = t.matcher(sb.substring(iEnd));
        if (matcher2.find() && F(matcher2.group(1)).equals("0")) {
            return false;
        }
        sb.delete(0, iEnd);
        return true;
    }

    private void L(int i2, b bVar, StringBuilder sb) {
        int i3 = a.b[bVar.ordinal()];
        if (i3 == 1) {
            sb.insert(0, i2).insert(0, '+');
        } else if (i3 == 2) {
            sb.insert(0, Separators.SP).insert(0, i2).insert(0, '+');
        } else {
            if (i3 != 3) {
                return;
            }
            sb.insert(0, "-").insert(0, i2).insert(0, '+').insert(0, "tel:");
        }
    }

    static synchronized void M(f fVar) {
        G = fVar;
    }

    static void N(CharSequence charSequence, g gVar) {
        if (charSequence.length() <= 1 || charSequence.charAt(0) != '0') {
            return;
        }
        gVar.z(true);
        int i2 = 1;
        while (i2 < charSequence.length() - 1 && charSequence.charAt(i2) == '0') {
            i2++;
        }
        if (i2 != 1) {
            gVar.D(i2);
        }
    }

    private d O(CharSequence charSequence, Z75 z75) {
        return P(charSequence, z75, c.UNKNOWN);
    }

    private d P(CharSequence charSequence, Z75 z75, c cVar) {
        C10138b85 c10138b85T = t(z75, cVar);
        List listD = c10138b85T.d().isEmpty() ? z75.c().d() : c10138b85T.d();
        List listF = c10138b85T.f();
        if (cVar == c.FIXED_LINE_OR_MOBILE) {
            if (!g(t(z75, c.FIXED_LINE))) {
                return P(charSequence, z75, c.MOBILE);
            }
            C10138b85 c10138b85T2 = t(z75, c.MOBILE);
            if (g(c10138b85T2)) {
                ArrayList arrayList = new ArrayList(listD);
                arrayList.addAll(c10138b85T2.c() == 0 ? z75.c().d() : c10138b85T2.d());
                Collections.sort(arrayList);
                if (listF.isEmpty()) {
                    listF = c10138b85T2.f();
                } else {
                    ArrayList arrayList2 = new ArrayList(listF);
                    arrayList2.addAll(c10138b85T2.f());
                    Collections.sort(arrayList2);
                    listF = arrayList2;
                }
                listD = arrayList;
            }
        }
        if (((Integer) listD.get(0)).intValue() == -1) {
            return d.INVALID_LENGTH;
        }
        int length = charSequence.length();
        if (listF.contains(Integer.valueOf(length))) {
            return d.IS_POSSIBLE_LOCAL_ONLY;
        }
        int iIntValue = ((Integer) listD.get(0)).intValue();
        return iIntValue == length ? d.IS_POSSIBLE : iIntValue > length ? d.TOO_SHORT : ((Integer) listD.get(listD.size() - 1)).intValue() < length ? d.TOO_LONG : listD.subList(1, listD.size()).contains(Integer.valueOf(length)) ? d.IS_POSSIBLE : d.INVALID_LENGTH;
    }

    private void a(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(";phone-context=");
        if (iIndexOf >= 0) {
            int i2 = iIndexOf + 15;
            if (i2 < str.length() - 1 && str.charAt(i2) == '+') {
                int iIndexOf2 = str.indexOf(59, i2);
                if (iIndexOf2 > 0) {
                    sb.append(str.substring(i2, iIndexOf2));
                } else {
                    sb.append(str.substring(i2));
                }
            }
            int iIndexOf3 = str.indexOf("tel:");
            sb.append(str.substring(iIndexOf3 >= 0 ? iIndexOf3 + 4 : 0, iIndexOf));
        } else {
            sb.append(i(str));
        }
        int iIndexOf4 = sb.indexOf(";isub=");
        if (iIndexOf4 > 0) {
            sb.delete(iIndexOf4, sb.length());
        }
    }

    private boolean b(CharSequence charSequence, String str) {
        if (w(str)) {
            return true;
        }
        return (charSequence == null || charSequence.length() == 0 || !r.matcher(charSequence).lookingAt()) ? false : true;
    }

    private static String d(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    private static f e(com.google.i18n.phonenumbers.d dVar) {
        if (dVar != null) {
            return new f(dVar, com.google.i18n.phonenumbers.b.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    public static f f(InterfaceC3515Be4 interfaceC3515Be4) {
        if (interfaceC3515Be4 != null) {
            return e(new e(interfaceC3515Be4));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static boolean g(C10138b85 c10138b85) {
        return (c10138b85.c() == 1 && c10138b85.b(0) == -1) ? false : true;
    }

    static CharSequence i(CharSequence charSequence) {
        Matcher matcher = u.matcher(charSequence);
        if (!matcher.find()) {
            return "";
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(matcher.start(), charSequence.length());
        Matcher matcher2 = w.matcher(charSequenceSubSequence);
        if (matcher2.find()) {
            charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher2.start());
        }
        Matcher matcher3 = v.matcher(charSequenceSubSequence);
        return matcher3.find() ? charSequenceSubSequence.subSequence(0, matcher3.start()) : charSequenceSubSequence;
    }

    private String l(String str, Z75 z75, b bVar) {
        return m(str, z75, bVar, null);
    }

    private String m(String str, Z75 z75, b bVar, CharSequence charSequence) {
        Y75 y75C = c((z75.f().size() == 0 || bVar == b.NATIONAL) ? z75.m() : z75.f(), str);
        return y75C == null ? str : n(str, y75C, bVar, charSequence);
    }

    private String n(String str, Y75 y75, b bVar, CharSequence charSequence) {
        String strReplaceAll;
        String strB = y75.b();
        Matcher matcher = this.e.a(y75.f()).matcher(str);
        b bVar2 = b.NATIONAL;
        if (bVar != bVar2 || charSequence == null || charSequence.length() <= 0 || y75.a().length() <= 0) {
            String strE = y75.e();
            strReplaceAll = (bVar != bVar2 || strE == null || strE.length() <= 0) ? matcher.replaceAll(strB) : matcher.replaceAll(E.matcher(strB).replaceFirst(strE));
        } else {
            strReplaceAll = matcher.replaceAll(E.matcher(strB).replaceFirst(y75.a().replace("$CC", charSequence)));
        }
        if (bVar != b.RFC3966) {
            return strReplaceAll;
        }
        Matcher matcher2 = s.matcher(strReplaceAll);
        if (matcher2.lookingAt()) {
            strReplaceAll = matcher2.replaceFirst("");
        }
        return matcher2.reset(strReplaceAll).replaceAll("-");
    }

    public static synchronized f o() {
        try {
            if (G == null) {
                M(f(com.google.i18n.phonenumbers.c.a));
            }
        } catch (Throwable th) {
            throw th;
        }
        return G;
    }

    private Z75 r(int i2, String str) {
        return "001".equals(str) ? p(i2) : q(str);
    }

    private boolean v(int i2) {
        return this.b.containsKey(Integer.valueOf(i2));
    }

    private boolean w(String str) {
        return str != null && this.f.contains(str);
    }

    static boolean x(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return C.matcher(charSequence).matches();
    }

    private void y(g gVar, Z75 z75, b bVar, StringBuilder sb) {
        if (!gVar.m() || gVar.e().length() <= 0) {
            return;
        }
        if (bVar == b.RFC3966) {
            sb.append(";ext=");
            sb.append(gVar.e());
        } else if (z75.C()) {
            sb.append(z75.q());
            sb.append(gVar.e());
        } else {
            sb.append(" ext. ");
            sb.append(gVar.e());
        }
    }

    String A(StringBuilder sb) {
        Matcher matcher = B.matcher(sb);
        if (!matcher.find() || !x(sb.substring(0, matcher.start()))) {
            return "";
        }
        int iGroupCount = matcher.groupCount();
        for (int i2 = 1; i2 <= iGroupCount; i2++) {
            if (matcher.group(i2) != null) {
                String strGroup = matcher.group(i2);
                sb.delete(matcher.start(), sb.length());
                return strGroup;
            }
        }
        return "";
    }

    g.a B(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return g.a.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = r.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            D(sb);
            return g.a.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternA = this.e.a(str);
        D(sb);
        return K(patternA, sb) ? g.a.FROM_NUMBER_WITH_IDD : g.a.FROM_DEFAULT_COUNTRY;
    }

    boolean C(StringBuilder sb, Z75 z75, StringBuilder sb2) {
        int length = sb.length();
        String strJ = z75.j();
        if (length != 0 && strJ.length() != 0) {
            Matcher matcher = this.e.a(strJ).matcher(sb);
            if (matcher.lookingAt()) {
                C10138b85 c10138b85C = z75.c();
                boolean zA = this.c.a(sb, c10138b85C, false);
                int iGroupCount = matcher.groupCount();
                String strK = z75.k();
                if (strK == null || strK.length() == 0 || matcher.group(iGroupCount) == null) {
                    if (zA && !this.c.a(sb.substring(matcher.end()), c10138b85C, false)) {
                        return false;
                    }
                    if (sb2 != null && iGroupCount > 0 && matcher.group(iGroupCount) != null) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
                StringBuilder sb3 = new StringBuilder(sb);
                sb3.replace(0, length, matcher.replaceFirst(strK));
                if (zA && !this.c.a(sb3.toString(), c10138b85C, false)) {
                    return false;
                }
                if (sb2 != null && iGroupCount > 1) {
                    sb2.append(matcher.group(1));
                }
                sb.replace(0, sb.length(), sb3.toString());
                return true;
            }
        }
        return false;
    }

    public g H(CharSequence charSequence, String str) throws NumberParseException, NumberFormatException {
        g gVar = new g();
        I(charSequence, str, gVar);
        return gVar;
    }

    public void I(CharSequence charSequence, String str, g gVar) throws NumberParseException, NumberFormatException {
        J(charSequence, str, false, true, gVar);
    }

    Y75 c(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Y75 y75 = (Y75) it.next();
            int iD = y75.d();
            if (iD == 0 || this.e.a(y75.c(iD - 1)).matcher(str).lookingAt()) {
                if (this.e.a(y75.f()).matcher(str).matches()) {
                    return y75;
                }
            }
        }
        return null;
    }

    int h(StringBuilder sb, StringBuilder sb2) throws NumberFormatException {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i2 = 1; i2 <= 3 && i2 <= length; i2++) {
                int i3 = Integer.parseInt(sb.substring(0, i2));
                if (this.b.containsKey(Integer.valueOf(i3))) {
                    sb2.append(sb.substring(i2));
                    return i3;
                }
            }
        }
        return 0;
    }

    public String j(g gVar, b bVar) {
        if (gVar.f() == 0 && gVar.r()) {
            String strK = gVar.k();
            if (strK.length() > 0) {
                return strK;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        k(gVar, bVar, sb);
        return sb.toString();
    }

    public void k(g gVar, b bVar, StringBuilder sb) {
        sb.setLength(0);
        int iC = gVar.c();
        String strS = s(gVar);
        b bVar2 = b.E164;
        if (bVar == bVar2) {
            sb.append(strS);
            L(iC, bVar2, sb);
        } else {
            if (!v(iC)) {
                sb.append(strS);
                return;
            }
            Z75 z75R = r(iC, u(iC));
            sb.append(l(strS, z75R, bVar));
            y(gVar, z75R, bVar, sb);
            L(iC, bVar, sb);
        }
    }

    Z75 p(int i2) {
        if (this.b.containsKey(Integer.valueOf(i2))) {
            return this.a.b(i2);
        }
        return null;
    }

    Z75 q(String str) {
        if (w(str)) {
            return this.a.a(str);
        }
        return null;
    }

    public String s(g gVar) {
        StringBuilder sb = new StringBuilder();
        if (gVar.s() && gVar.g() > 0) {
            char[] cArr = new char[gVar.g()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(gVar.f());
        return sb.toString();
    }

    C10138b85 t(Z75 z75, c cVar) {
        switch (a.c[cVar.ordinal()]) {
            case 1:
                return z75.r();
            case 2:
                return z75.u();
            case 3:
                return z75.g();
            case 4:
            case 5:
                return z75.b();
            case 6:
                return z75.s();
            case 7:
                return z75.z();
            case 8:
                return z75.p();
            case 9:
                return z75.n();
            case 10:
                return z75.w();
            case 11:
                return z75.y();
            default:
                return z75.c();
        }
    }

    public String u(int i2) {
        List list = (List) this.b.get(Integer.valueOf(i2));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    int z(CharSequence charSequence, Z75 z75, StringBuilder sb, boolean z2, g gVar) throws NumberParseException, NumberFormatException {
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        g.a aVarB = B(sb2, z75 != null ? z75.d() : "NonMatch");
        if (z2) {
            gVar.w(aVarB);
        }
        if (aVarB != g.a.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() <= 2) {
                throw new NumberParseException(NumberParseException.a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int iH = h(sb2, sb);
            if (iH == 0) {
                throw new NumberParseException(NumberParseException.a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            gVar.u(iH);
            return iH;
        }
        if (z75 != null) {
            int iA = z75.a();
            String strValueOf = String.valueOf(iA);
            String string = sb2.toString();
            if (string.startsWith(strValueOf)) {
                StringBuilder sb3 = new StringBuilder(string.substring(strValueOf.length()));
                C10138b85 c10138b85C = z75.c();
                C(sb3, z75, null);
                if ((!this.c.a(sb2, c10138b85C, false) && this.c.a(sb3, c10138b85C, false)) || O(sb2, z75) == d.TOO_LONG) {
                    sb.append((CharSequence) sb3);
                    if (z2) {
                        gVar.w(g.a.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    gVar.u(iA);
                    return iA;
                }
            }
        }
        gVar.u(0);
        return 0;
    }
}
