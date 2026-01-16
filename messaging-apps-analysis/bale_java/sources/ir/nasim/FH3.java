package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Xml;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class FH3 {
    public static boolean D = false;
    public static int E = 1;
    public static boolean F = false;
    private static HashMap G = new HashMap();
    private static volatile FH3 H = null;
    private static Boolean I;
    public C17263mg2 a;
    public C17263mg2 b;
    public C17263mg2 c;
    public C17263mg2 d;
    public C17263mg2 e;
    public C17263mg2 f;
    public C17263mg2 g;
    public C17263mg2 h;
    public C17263mg2 i;
    public C17263mg2 j;
    public C17263mg2 k;
    public C17263mg2 l;
    public C17263mg2 m;
    public C17263mg2 n;
    private Locale q;
    private Locale r;
    private b s;
    private a t;
    private String v;
    private boolean x;
    private String y;
    public C17263mg2[] o = new C17263mg2[15];
    private HashMap p = new HashMap();
    private HashMap u = new HashMap();
    private boolean w = false;
    public ArrayList z = new ArrayList();
    public ArrayList A = new ArrayList();
    public HashMap B = new HashMap();
    private ArrayList C = new ArrayList();

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public int h;
        public int i;
        public int j;

        public static a a(String str) {
            a aVar = null;
            if (str != null && str.length() != 0) {
                String[] strArrSplit = str.split("\\|");
                if (strArrSplit.length >= 4) {
                    aVar = new a();
                    aVar.a = strArrSplit[0];
                    aVar.b = strArrSplit[1];
                    aVar.c = strArrSplit[2].toLowerCase();
                    aVar.d = strArrSplit[3];
                    if (strArrSplit.length >= 5) {
                        aVar.h = Utilities.h(strArrSplit[4]).intValue();
                    }
                    aVar.e = strArrSplit.length >= 6 ? strArrSplit[5] : "";
                    aVar.f = strArrSplit.length >= 7 ? strArrSplit[6] : aVar.c;
                    if (strArrSplit.length >= 8) {
                        aVar.g = Utilities.h(strArrSplit[7]).intValue() == 1;
                    }
                    if (strArrSplit.length >= 9) {
                        aVar.i = Utilities.h(strArrSplit[8]).intValue();
                    }
                    if (strArrSplit.length >= 10) {
                        aVar.j = Utilities.h(strArrSplit[9]).intValue();
                    } else {
                        aVar.j = Integer.MAX_VALUE;
                    }
                    if (!TextUtils.isEmpty(aVar.e)) {
                        aVar.e = aVar.e.replace("-", "_");
                    }
                }
            }
            return aVar;
        }

        public String b() {
            if (this.d != null && !g() && !h()) {
                return "local_" + this.c;
            }
            if (!h()) {
                return this.c;
            }
            return "unofficial_" + this.c;
        }

        public File c() {
            return null;
        }

        public File d() {
            return null;
        }

        public String e() {
            String str = this.e;
            if (str == null) {
                str = "";
            }
            TextUtils.isEmpty(this.f);
            return this.a + "|" + this.b + "|" + this.c + "|" + this.d + "|" + this.h + "|" + str + "|" + this.f + "|" + (this.g ? 1 : 0) + "|" + this.i + "|" + this.j;
        }

        public boolean f() {
            return (!h() || TextUtils.isEmpty(this.e) || this.e.equals(this.c)) ? false : true;
        }

        public boolean g() {
            return "remote".equals(this.d);
        }

        public boolean h() {
            return "unofficial".equals(this.d);
        }
    }

    public static abstract class b {
        abstract int a(int i);
    }

    public static class c extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 4;
            }
            if (i2 < 3 || i2 > 10) {
                return (i2 < 11 || i2 > 99) ? 0 : 16;
            }
            return 8;
        }
    }

    public static class d extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            int i3 = i % 10;
            if (i3 == 1 && i2 != 11) {
                return 2;
            }
            if (i3 >= 2 && i3 <= 4 && (i2 < 12 || i2 > 14)) {
                return 8;
            }
            if (i3 == 0) {
                return 16;
            }
            if (i3 < 5 || i3 > 9) {
                return (i2 < 11 || i2 > 14) ? 0 : 16;
            }
            return 16;
        }
    }

    public static class e extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 4;
            }
            if (i == 3) {
                return 8;
            }
            return i == 6 ? 16 : 0;
        }
    }

    public static class f extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 1) {
                return 2;
            }
            return (i < 2 || i > 4) ? 0 : 8;
        }
    }

    public static class g extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            return (i < 0 || i >= 2) ? 0 : 2;
        }
    }

    public static class h extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 0) {
                return 1;
            }
            return i == 1 ? 2 : 0;
        }
    }

    public static class i extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 0) {
                return 1;
            }
            return (i % 10 != 1 || i % 100 == 11) ? 0 : 2;
        }
    }

    public static class j extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            int i3 = i % 10;
            if (i3 == 1 && (i2 < 11 || i2 > 19)) {
                return 2;
            }
            if (i3 < 2 || i3 > 9) {
                return 0;
            }
            return (i2 < 11 || i2 > 19) ? 8 : 0;
        }
    }

    public static class k extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            return (i % 10 != 1 || i == 11) ? 0 : 2;
        }
    }

    public static class l extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            if (i == 1) {
                return 2;
            }
            if (i == 0) {
                return 8;
            }
            if (i2 < 2 || i2 > 10) {
                return (i2 < 11 || i2 > 19) ? 0 : 16;
            }
            return 8;
        }
    }

    public static class m extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            return 0;
        }
    }

    public static class n extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            return i == 1 ? 2 : 0;
        }
    }

    public static class o extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            int i3 = i % 10;
            if (i == 1) {
                return 2;
            }
            if (i3 >= 2 && i3 <= 4 && (i2 < 12 || i2 > 14)) {
                return 8;
            }
            if (i3 >= 0 && i3 <= 1) {
                return 16;
            }
            if (i3 < 5 || i3 > 9) {
                return (i2 < 12 || i2 > 14) ? 0 : 16;
            }
            return 16;
        }
    }

    public static class p extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            if (i == 1) {
                return 2;
            }
            if (i != 0) {
                return (i2 < 1 || i2 > 19) ? 0 : 8;
            }
            return 8;
        }
    }

    public static class q extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            int i3 = i % 10;
            if (i3 == 1 && i2 != 11) {
                return 2;
            }
            if (i3 < 2 || i3 > 4) {
                return 0;
            }
            return (i2 < 12 || i2 > 14) ? 8 : 0;
        }
    }

    public static class r extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            int i2 = i % 100;
            if (i2 == 1) {
                return 2;
            }
            if (i2 == 2) {
                return 4;
            }
            return (i2 < 3 || i2 > 4) ? 0 : 8;
        }
    }

    public static class s extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i < 0 || i > 1) {
                return (i < 2 || i > 10) ? 0 : 8;
            }
            return 2;
        }
    }

    public static class t extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 1) {
                return 2;
            }
            return i == 2 ? 4 : 0;
        }
    }

    public static class u extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 4;
            }
            if (i == 3) {
                return 8;
            }
            return i == 6 ? 16 : 0;
        }
    }

    public static class v extends b {
        @Override // ir.nasim.FH3.b
        public int a(int i) {
            return (i == 0 || i == 1) ? 2 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class w extends BroadcastReceiver {
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (FH3.this.d.e().equals(TimeZone.getDefault())) {
                return;
            }
            FH3.w().M();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC14047hG.b.post(new Runnable() { // from class: ir.nasim.GH3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }

        private w() {
        }
    }

    public FH3() {
        a aVarX;
        boolean z = false;
        c(new String[]{"bem", "brx", "da", "de", "el", "en", "eo", "es", "et", "fi", "fo", "gl", "he", "iw", "it", "nb", "nl", "nn", AuthorizationHeaderIms.NO, "sv", "af", "bg", "bn", "ca", "eu", "fur", "fy", "gu", "ha", "is", "ku", "lb", "ml", "mr", "nah", "ne", "om", "or", "pa", "pap", "ps", "so", "sq", "sw", "ta", "te", "tk", "ur", "zu", "mn", "gsw", "chr", "rm", "pt", "an", "ast"}, new n());
        c(new String[]{"cs", "sk"}, new f());
        c(new String[]{"ff", "fr", "kab"}, new g());
        c(new String[]{"ru", "uk", "be"}, new d());
        c(new String[]{"sr", "hr", "bs", "sh"}, new q());
        c(new String[]{"lv"}, new i());
        c(new String[]{"lt"}, new j());
        c(new String[]{"pl"}, new o());
        c(new String[]{"ro", "mo"}, new p());
        c(new String[]{"sl"}, new r());
        c(new String[]{"ar"}, new c());
        c(new String[]{"mk"}, new k());
        c(new String[]{"cy"}, new u());
        c(new String[]{"br"}, new e());
        c(new String[]{"lag"}, new h());
        c(new String[]{"shi"}, new s());
        c(new String[]{"mt"}, new l());
        c(new String[]{"ga", "se", "sma", "smi", "smj", "smn", "sms"}, new t());
        c(new String[]{"ak", "am", "bh", "fil", "tl", "guw", "hi", "ln", "mg", "nso", "ti", "wa"}, new v());
        c(new String[]{"az", "bm", "fa", "ig", "hu", "ja", "kde", "kea", "ko", "my", "ses", "sg", "to", "tr", "vi", "wo", "yo", "zh", "bo", "dz", "id", "jv", "jw", "ka", "km", "kn", "ms", "th", "in"}, new m());
        a aVar = new a();
        aVar.a = "English";
        aVar.b = "English";
        aVar.f = "en";
        aVar.c = "en";
        aVar.d = null;
        this.z.add(aVar);
        this.B.put(aVar.c, aVar);
        a aVar2 = new a();
        aVar2.a = "Italiano";
        aVar2.b = "Italian";
        aVar2.f = "it";
        aVar2.c = "it";
        aVar2.d = null;
        this.z.add(aVar2);
        this.B.put(aVar2.c, aVar2);
        a aVar3 = new a();
        aVar3.a = "Español";
        aVar3.b = "Spanish";
        aVar3.f = "es";
        aVar3.c = "es";
        this.z.add(aVar3);
        this.B.put(aVar3.c, aVar3);
        a aVar4 = new a();
        aVar4.a = "Deutsch";
        aVar4.b = "German";
        aVar4.f = "de";
        aVar4.c = "de";
        aVar4.d = null;
        this.z.add(aVar4);
        this.B.put(aVar4.c, aVar4);
        a aVar5 = new a();
        aVar5.a = "Nederlands";
        aVar5.b = "Dutch";
        aVar5.f = "nl";
        aVar5.c = "nl";
        aVar5.d = null;
        this.z.add(aVar5);
        this.B.put(aVar5.c, aVar5);
        a aVar6 = new a();
        aVar6.a = "العربية";
        aVar6.b = "Arabic";
        aVar6.f = "ar";
        aVar6.c = "ar";
        aVar6.d = null;
        aVar6.g = true;
        this.z.add(aVar6);
        this.B.put(aVar6.c, aVar6);
        a aVar7 = new a();
        aVar7.a = "Português (Brasil)";
        aVar7.b = "Portuguese (Brazil)";
        aVar7.f = "pt_br";
        aVar7.c = "pt_br";
        aVar7.d = null;
        this.z.add(aVar7);
        this.B.put(aVar7.c, aVar7);
        a aVar8 = new a();
        aVar8.a = "한국어";
        aVar8.b = "Korean";
        aVar8.f = "ko";
        aVar8.c = "ko";
        aVar8.d = null;
        this.z.add(aVar8);
        this.B.put(aVar8.c, aVar8);
        a aVar9 = new a();
        aVar9.a = "فارسی";
        aVar9.b = "Persian";
        aVar9.f = "fa";
        aVar9.c = "fa";
        aVar9.d = null;
        this.z.add(aVar9);
        this.B.put(aVar9.c, aVar9);
        L();
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            a aVar10 = (a) this.C.get(i2);
            this.z.add(aVar10);
            this.B.put(aVar10.b(), aVar10);
        }
        for (int i3 = 0; i3 < this.A.size(); i3++) {
            a aVar11 = (a) this.A.get(i3);
            a aVarX2 = x(aVar11.b());
            if (aVarX2 != null) {
                aVarX2.d = aVar11.d;
                aVarX2.h = aVar11.h;
                aVarX2.i = aVar11.i;
                aVarX2.j = aVar11.j;
                this.A.set(i3, aVarX2);
            } else {
                this.B.put(aVar11.b(), aVar11);
            }
        }
        this.r = Locale.getDefault();
        F = DateFormat.is24HourFormat(AbstractC14047hG.a);
        try {
            String string = ir.nasim.tgwidgets.editor.messenger.C.m().getString("language", null);
            if (string != null) {
                aVarX = x(string);
                if (aVarX != null) {
                    z = true;
                }
            } else {
                aVarX = null;
            }
            if (aVarX == null && this.r.getLanguage() != null) {
                aVarX = x(this.r.getLanguage());
            }
            if (aVarX == null && (aVarX = x(A(this.r))) == null) {
                aVarX = x("en");
            }
            d(aVarX, z, true, C22477vI7.f);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        try {
            AbstractC14047hG.a.registerReceiver(new w(), new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.DH3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.K();
            }
        });
    }

    private String A(Locale locale) {
        if (locale == null) {
            return "en";
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (language.length() == 0 && country.length() == 0) {
            return "en";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(language);
        if (country.length() > 0 || variant.length() > 0) {
            sb.append('_');
        }
        sb.append(country);
        if (variant.length() > 0) {
            sb.append('_');
        }
        sb.append(variant);
        return sb.toString();
    }

    public static String B(String str) {
        String str2 = (String) w().u.get(str);
        if (str2 != null) {
            return str2;
        }
        int identifier = AbstractC14047hG.a.getResources().getIdentifier("tgwidget_" + str, "string", AbstractC14047hG.a.getPackageName());
        return identifier != 0 ? AbstractC14047hG.a.getString(identifier) : str2;
    }

    public static String C(int i2) {
        String str = (String) G.get(Integer.valueOf(i2));
        if (str == null) {
            HashMap map = G;
            Integer numValueOf = Integer.valueOf(i2);
            String resourceEntryName = AbstractC14047hG.a.getResources().getResourceEntryName(i2);
            map.put(numValueOf, resourceEntryName);
            str = resourceEntryName;
        }
        return E(str, i2);
    }

    public static String D(String str) {
        if (!TextUtils.isEmpty(str)) {
            int identifier = AbstractC14047hG.a.getResources().getIdentifier(str, "string", AbstractC14047hG.a.getPackageName());
            return identifier != 0 ? E(str, identifier) : B(str);
        }
        return "LOC_ERR:" + str;
    }

    public static String E(String str, int i2) {
        return w().F(str, i2);
    }

    private String F(String str, int i2) {
        return G(str, null, i2);
    }

    private String G(String str, String str2, int i2) {
        String string = AbstractC8814Xl0.d ? (String) this.u.get(str) : null;
        if (string == null) {
            if (AbstractC8814Xl0.d && str2 != null) {
                string = (String) this.u.get(str2);
            }
            if (string == null) {
                try {
                    string = AbstractC14047hG.a.getString(i2);
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
        }
        if (string != null) {
            return string;
        }
        return "LOC_ERR:" + str;
    }

    public static String I() {
        Locale localeH = w().H();
        if (localeH == null) {
            return "en";
        }
        String language = localeH.getLanguage();
        String country = localeH.getCountry();
        String variant = localeH.getVariant();
        if (language.length() == 0 && country.length() == 0) {
            return "en";
        }
        StringBuilder sb = new StringBuilder(11);
        sb.append(language);
        if (country.length() > 0 || variant.length() > 0) {
            sb.append('-');
        }
        sb.append(country);
        if (variant.length() > 0) {
            sb.append('_');
        }
        sb.append(variant);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J() {
        ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.Z2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.y = I();
    }

    private void L() {
        SharedPreferences sharedPreferences = AbstractC14047hG.a.getSharedPreferences("langconfig", 0);
        String string = sharedPreferences.getString("locales", null);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split(Separators.AND)) {
                a aVarA = a.a(str);
                if (aVarA != null) {
                    this.C.add(aVarA);
                }
            }
        }
        String string2 = sharedPreferences.getString("remote", null);
        if (!TextUtils.isEmpty(string2)) {
            for (String str2 : string2.split(Separators.AND)) {
                a aVarA2 = a.a(str2);
                aVarA2.c = aVarA2.c.replace("-", "_");
            }
        }
        String string3 = sharedPreferences.getString("unofficial", null);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        for (String str3 : string3.split(Separators.AND)) {
            a aVarA3 = a.a(str3);
            if (aVarA3 != null) {
                aVarA3.c = aVarA3.c.replace("-", "_");
                this.A.add(aVarA3);
            }
        }
    }

    private void N() {
        SharedPreferences.Editor editorEdit = AbstractC14047hG.a.getSharedPreferences("langconfig", 0).edit();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            String strE = ((a) this.C.get(i2)).e();
            if (strE != null) {
                if (sb.length() != 0) {
                    sb.append(Separators.AND);
                }
                sb.append(strE);
            }
        }
        editorEdit.putString("locales", sb.toString());
        sb.setLength(0);
        for (int i3 = 0; i3 < this.A.size(); i3++) {
            String strE2 = ((a) this.A.get(i3)).e();
            if (strE2 != null) {
                if (sb.length() != 0) {
                    sb.append(Separators.AND);
                }
                sb.append(strE2);
            }
        }
        editorEdit.putString("unofficial", sb.toString());
        editorEdit.commit();
    }

    private String O(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? "other" : "many" : "few" : "two" : "one" : "zero";
    }

    private void c(String[] strArr, b bVar) {
        for (String str : strArr) {
            this.p.put(str, bVar);
        }
    }

    private C17263mg2 f(Locale locale, String str, String str2) {
        if (str == null || str.length() == 0) {
            str = str2;
        }
        try {
            return C17263mg2.d(str, locale);
        } catch (Exception unused) {
            return C17263mg2.d(str2, locale);
        }
    }

    public static void g() {
        if (I != null) {
            return;
        }
        int i2 = AbstractC8662Wx6.J0;
        if (i2 != 0) {
            I = Boolean.valueOf(i2 == 2);
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) AbstractC14047hG.a.getSystemService("phone");
            if (telephonyManager != null) {
                String upperCase = telephonyManager.getSimCountryIso().toUpperCase();
                if (!"US".equals(upperCase) && !"GB".equals(upperCase) && !"MM".equals(upperCase) && !"LR".equals(upperCase)) {
                    z = false;
                }
                I = Boolean.valueOf(z);
            }
        } catch (Exception e2) {
            I = Boolean.FALSE;
            AbstractC6403Nl2.d(e2);
        }
    }

    public static String h(int i2) {
        if (i2 <= 3600) {
            return i2 > 60 ? o("Minutes", i2 / 60, new Object[0]) : o("Seconds", i2, new Object[0]);
        }
        String strO = o("Hours", i2 / 3600, new Object[0]);
        int i3 = (i2 % 3600) / 60;
        if (i3 <= 0) {
            return strO;
        }
        return strO + ", " + o("Minutes", i3, new Object[0]);
    }

    public static String k(long j2, boolean z) {
        long j3 = j2 * 1000;
        try {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(6);
            int i3 = calendar.get(1);
            calendar.setTimeInMillis(j3);
            int i4 = calendar.get(6);
            int i5 = calendar.get(1);
            return (i4 == i2 && i3 == i5) ? z ? r("TodayAtFormatted", TD5.tgwidget_TodayAtFormatted, w().a.c(new Date(j3))) : r("TodayAtFormattedWithToday", TD5.tgwidget_TodayAtFormattedWithToday, w().a.c(new Date(j3))) : (i4 + 1 == i2 && i3 == i5) ? r("YesterdayAtFormatted", TD5.tgwidget_YesterdayAtFormatted, w().a.c(new Date(j3))) : Math.abs(System.currentTimeMillis() - j3) < 31536000000L ? r("formatDateAtTime", TD5.tgwidget_formatDateAtTime, w().d.c(new Date(j3)), w().a.c(new Date(j3))) : r("formatDateAtTime", TD5.tgwidget_formatDateAtTime, w().e.c(new Date(j3)), w().a.c(new Date(j3)));
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return "LOC_ERR";
        }
    }

    public static String l(float f2, int i2) {
        return m(f2, i2, null);
    }

    public static String m(float f2, int i2, Boolean bool) {
        g();
        if ((bool == null || !bool.booleanValue()) && !(bool == null && I.booleanValue())) {
            if (f2 < 1000.0f) {
                return i2 != 0 ? i2 != 1 ? r("MetersShort", TD5.tgwidget_MetersShort, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f2)))) : r("MetersFromYou2", TD5.tgwidget_MetersFromYou2, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f2)))) : r("MetersAway2", TD5.tgwidget_MetersAway2, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f2))));
            }
            String str = f2 % 1000.0f == 0.0f ? String.format("%d", Integer.valueOf((int) (f2 / 1000.0f))) : String.format("%.2f", Float.valueOf(f2 / 1000.0f));
            return i2 != 0 ? i2 != 1 ? r("KMetersShort", TD5.tgwidget_KMetersShort, str) : r("KMetersFromYou2", TD5.tgwidget_KMetersFromYou2, str) : r("KMetersAway2", TD5.tgwidget_KMetersAway2, str);
        }
        float f3 = f2 * 3.28084f;
        if (f3 < 1000.0f) {
            return i2 != 0 ? i2 != 1 ? r("FootsShort", TD5.tgwidget_FootsShort, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f3)))) : r("FootsFromYou", TD5.tgwidget_FootsFromYou, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f3)))) : r("FootsAway", TD5.tgwidget_FootsAway, String.format("%d", Integer.valueOf((int) Math.max(1.0f, f3))));
        }
        String str2 = f3 % 5280.0f == 0.0f ? String.format("%d", Integer.valueOf((int) (f3 / 5280.0f))) : String.format("%.2f", Float.valueOf(f3 / 5280.0f));
        return i2 != 0 ? i2 != 1 ? r("MilesShort", TD5.tgwidget_MilesShort, str2) : r("MilesFromYou", TD5.tgwidget_MilesFromYou, str2) : r("MilesAway", TD5.tgwidget_MilesAway, str2);
    }

    public static String n(int i2) {
        if (i2 <= 0) {
            return o("Seconds", 0, new Object[0]);
        }
        int i3 = i2 / 3600;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 % 60;
        StringBuilder sb = new StringBuilder();
        if (i3 > 0) {
            sb.append(o("Hours", i3, new Object[0]));
        }
        if (i4 > 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(o("Minutes", i4, new Object[0]));
        }
        if (i5 > 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(o("Seconds", i5, new Object[0]));
        }
        return sb.toString();
    }

    public static String o(String str, int i2, Object... objArr) {
        if (str == null || str.length() == 0 || w().s == null) {
            return "LOC_ERR:" + str;
        }
        String str2 = str + "_" + w().O(w().s.a(i2));
        int identifier = AbstractC14047hG.a.getResources().getIdentifier("tgwidget_" + str2, "string", AbstractC14047hG.a.getPackageName());
        int identifier2 = AbstractC14047hG.a.getResources().getIdentifier("tgwidget_" + str + "_other", "string", AbstractC14047hG.a.getPackageName());
        Object[] objArr2 = new Object[objArr.length + 1];
        objArr2[0] = Integer.valueOf(i2);
        System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        return s(str2, str + "_other", identifier, identifier2, objArr2);
    }

    public static String p(long j2, int i2, boolean z) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i3 = calendar.get(1);
        int i4 = calendar.get(6);
        calendar.setTimeInMillis(j2 * 1000);
        int i5 = i3 == calendar.get(1) ? (z && calendar.get(6) == i4) ? 0 : 1 : 2;
        if (i2 == 1) {
            i5 += 3;
        } else if (i2 == 2) {
            i5 += 6;
        } else if (i2 == 3) {
            i5 += 9;
        } else if (i2 == 4) {
            i5 += 12;
        }
        return w().o[i5].b(calendar.getTimeInMillis());
    }

    public static String q(int i2, Object... objArr) throws Resources.NotFoundException {
        String str = (String) G.get(Integer.valueOf(i2));
        if (str == null) {
            HashMap map = G;
            Integer numValueOf = Integer.valueOf(i2);
            String resourceEntryName = AbstractC14047hG.a.getResources().getResourceEntryName(i2);
            map.put(numValueOf, resourceEntryName);
            str = resourceEntryName;
        }
        return r(str, i2, objArr);
    }

    public static String r(String str, int i2, Object... objArr) {
        return s(str, null, i2, 0, objArr);
    }

    public static String s(String str, String str2, int i2, int i3, Object... objArr) {
        try {
            String string = AbstractC8814Xl0.d ? (String) w().u.get(str) : null;
            if (string == null) {
                if (AbstractC8814Xl0.d && str2 != null) {
                    string = (String) w().u.get(str2);
                }
                if (string == null) {
                    try {
                        string = AbstractC14047hG.a.getString(i2);
                    } catch (Exception unused) {
                        if (i3 != 0) {
                            try {
                                string = AbstractC14047hG.a.getString(i3);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            return w().q != null ? String.format(w().q, string, objArr) : String.format(string, objArr);
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return "LOC_ERR: " + str;
        }
    }

    public static String t(int i2) {
        if (i2 < 60) {
            return o("Seconds", i2, new Object[0]);
        }
        if (i2 < 3600) {
            return o("Minutes", i2 / 60, new Object[0]);
        }
        if (i2 < 86400) {
            return o("Hours", (i2 / 60) / 60, new Object[0]);
        }
        if (i2 < 604800) {
            return o("Days", ((i2 / 60) / 60) / 24, new Object[0]);
        }
        if (i2 >= 2678400) {
            return o("Months", (((i2 / 60) / 60) / 24) / 30, new Object[0]);
        }
        int i3 = ((i2 / 60) / 60) / 24;
        return i2 % 7 == 0 ? o("Weeks", i3 / 7, new Object[0]) : String.format("%s %s", o("Weeks", i3 / 7, new Object[0]), o("Days", i3 % 7, new Object[0]));
    }

    public static String u(long j2, boolean z) {
        long j3 = 1000 * j2;
        try {
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(1);
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(1);
            int i4 = calendar.get(2);
            String[] strArr = {E("January", TD5.tgwidget_January), E("February", TD5.tgwidget_February), E("March", TD5.tgwidget_March), E("April", TD5.tgwidget_April), E("May", TD5.tgwidget_May), E("June", TD5.tgwidget_June), E("July", TD5.tgwidget_July), E("August", TD5.tgwidget_August), E("September", TD5.tgwidget_September), E("October", TD5.tgwidget_October), E("November", TD5.tgwidget_November), E("December", TD5.tgwidget_December)};
            if (i2 == i3 && !z) {
                return strArr[i4];
            }
            return strArr[i4] + Separators.SP + i3;
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            return "LOC_ERR";
        }
    }

    public static FH3 w() {
        FH3 fh3 = H;
        if (fh3 == null) {
            synchronized (FH3.class) {
                try {
                    fh3 = H;
                    if (fh3 == null) {
                        fh3 = new FH3();
                        H = fh3;
                    }
                } finally {
                }
            }
        }
        return fh3;
    }

    private HashMap y(File file) {
        return z(file, false);
    }

    private HashMap z(File file, boolean z) throws Throwable {
        this.x = false;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return new HashMap();
                }
                HashMap map = new HashMap();
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    xmlPullParserNewPullParser.setInput(fileInputStream2, "UTF-8");
                    String attributeValue = null;
                    String name = null;
                    String text = null;
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 2) {
                            name = xmlPullParserNewPullParser.getName();
                            if (xmlPullParserNewPullParser.getAttributeCount() > 0) {
                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(0);
                            }
                        } else if (eventType == 4) {
                            if (attributeValue != null && (text = xmlPullParserNewPullParser.getText()) != null) {
                                String strTrim = text.trim();
                                if (z) {
                                    text = strTrim.replace(Separators.LESS_THAN, "&lt;").replace(Separators.GREATER_THAN, "&gt;").replace(Separators.QUOTE, "\\'").replace("& ", "&amp; ");
                                } else {
                                    String strReplace = strTrim.replace("\\n", Separators.RETURN).replace("\\", "");
                                    text = strReplace.replace("&lt;", Separators.LESS_THAN);
                                    if (!this.x && !text.equals(strReplace)) {
                                        this.x = true;
                                    }
                                }
                            }
                        } else if (eventType == 3) {
                            attributeValue = null;
                            name = null;
                            text = null;
                        }
                        if (name != null && name.equals("string") && text != null && attributeValue != null && text.length() != 0 && attributeValue.length() != 0) {
                            map.put(attributeValue, text);
                            attributeValue = null;
                            name = null;
                            text = null;
                        }
                    }
                    try {
                        fileInputStream2.close();
                    } catch (Exception e2) {
                        AbstractC6403Nl2.d(e2);
                    }
                    return map;
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    AbstractC6403Nl2.d(e);
                    this.x = true;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            AbstractC6403Nl2.d(e4);
                        }
                    }
                    return new HashMap();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            AbstractC6403Nl2.d(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public Locale H() {
        return this.r;
    }

    public void M() {
        a aVar;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        int i4;
        String str4;
        int i5;
        Locale locale = this.q;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String language = locale.getLanguage();
        if (language == null) {
            language = "en";
        }
        String lowerCase = language.toLowerCase();
        D = (lowerCase.length() == 2 && (lowerCase.equals("ar") || lowerCase.equals("fa") || lowerCase.equals("he") || lowerCase.equals("iw"))) || lowerCase.startsWith("ar_") || lowerCase.startsWith("fa_") || lowerCase.startsWith("he_") || lowerCase.startsWith("iw_") || ((aVar = this.t) != null && aVar.g);
        E = lowerCase.equals("ko") ? 2 : 1;
        this.n = f(locale, F("formatterMonthYear", TD5.tgwidget_formatterMonthYear), "MMM yyyy");
        this.d = f(locale, F("formatterMonth", TD5.tgwidget_formatterMonth), "dd MMM");
        this.e = f(locale, F("formatterYear", TD5.tgwidget_formatterYear), "dd.MM.yy");
        this.f = f(locale, F("formatterYearMax", TD5.tgwidget_formatterYearMax), "dd.MM.yyyy");
        this.j = f(locale, F("chatDate", TD5.tgwidget_chatDate), "d MMMM");
        this.k = f(locale, F("chatFullDate", TD5.tgwidget_chatFullDate), "d MMMM yyyy");
        this.b = f(locale, F("formatterWeek", TD5.tgwidget_formatterWeek), "EEE");
        this.c = f(locale, F("formatterWeekLong", TD5.tgwidget_formatterWeekLong), "EEEE");
        this.l = f(locale, F("formatDateSchedule", TD5.tgwidget_formatDateSchedule), "MMM d");
        this.m = f(locale, F("formatDateScheduleYear", TD5.tgwidget_formatDateScheduleYear), "MMM d yyyy");
        Locale locale2 = (lowerCase.toLowerCase().equals("ar") || lowerCase.toLowerCase().equals("ko")) ? locale : Locale.US;
        if (F) {
            str = "formatterDay24H";
            i2 = TD5.tgwidget_formatterDay24H;
        } else {
            str = "formatterDay12H";
            i2 = TD5.tgwidget_formatterDay12H;
        }
        this.a = f(locale2, F(str, i2), F ? "HH:mm" : "h:mm a");
        if (F) {
            str2 = "formatterStats24H";
            i3 = TD5.tgwidget_formatterStats24H;
        } else {
            str2 = "formatterStats12H";
            i3 = TD5.tgwidget_formatterStats12H;
        }
        this.g = f(locale, F(str2, i3), F ? "MMM dd yyyy, HH:mm" : "MMM dd yyyy, h:mm a");
        if (F) {
            str3 = "formatterBannedUntil24H";
            i4 = TD5.tgwidget_formatterBannedUntil24H;
        } else {
            str3 = "formatterBannedUntil12H";
            i4 = TD5.tgwidget_formatterBannedUntil12H;
        }
        this.h = f(locale, F(str3, i4), F ? "MMM dd yyyy, HH:mm" : "MMM dd yyyy, h:mm a");
        if (F) {
            str4 = "formatterBannedUntilThisYear24H";
            i5 = TD5.tgwidget_formatterBannedUntilThisYear24H;
        } else {
            str4 = "formatterBannedUntilThisYear12H";
            i5 = TD5.tgwidget_formatterBannedUntilThisYear12H;
        }
        this.i = f(locale, F(str4, i5), F ? "MMM dd, HH:mm" : "MMM dd, h:mm a");
        this.o[0] = f(locale, F("SendTodayAt", TD5.tgwidget_SendTodayAt), "'Send today at' HH:mm");
        this.o[1] = f(locale, F("SendDayAt", TD5.tgwidget_SendDayAt), "'Send on' MMM d 'at' HH:mm");
        this.o[2] = f(locale, F("SendDayYearAt", TD5.tgwidget_SendDayYearAt), "'Send on' MMM d yyyy 'at' HH:mm");
        this.o[3] = f(locale, F("RemindTodayAt", TD5.tgwidget_RemindTodayAt), "'Remind today at' HH:mm");
        this.o[4] = f(locale, F("RemindDayAt", TD5.tgwidget_RemindDayAt), "'Remind on' MMM d 'at' HH:mm");
        this.o[5] = f(locale, F("RemindDayYearAt", TD5.tgwidget_RemindDayYearAt), "'Remind on' MMM d yyyy 'at' HH:mm");
        this.o[6] = f(locale, F("StartTodayAt", TD5.tgwidget_StartTodayAt), "'Start today at' HH:mm");
        this.o[7] = f(locale, F("StartDayAt", TD5.tgwidget_StartDayAt), "'Start on' MMM d 'at' HH:mm");
        this.o[8] = f(locale, F("StartDayYearAt", TD5.tgwidget_StartDayYearAt), "'Start on' MMM d yyyy 'at' HH:mm");
        this.o[9] = f(locale, F("StartShortTodayAt", TD5.tgwidget_StartShortTodayAt), "'Today,' HH:mm");
        this.o[10] = f(locale, F("StartShortDayAt", TD5.tgwidget_StartShortDayAt), "MMM d',' HH:mm");
        this.o[11] = f(locale, F("StartShortDayYearAt", TD5.tgwidget_StartShortDayYearAt), "MMM d yyyy, HH:mm");
        this.o[12] = f(locale, F("StartsTodayAt", TD5.tgwidget_StartsTodayAt), "'Starts today at' HH:mm");
        this.o[13] = f(locale, F("StartsDayAt", TD5.tgwidget_StartsDayAt), "'Starts on' MMM d 'at' HH:mm");
        this.o[14] = f(locale, F("StartsDayYearAt", TD5.tgwidget_StartsDayYearAt), "'Starts on' MMM d yyyy 'at' HH:mm");
    }

    public boolean P(String str) {
        try {
            a aVarX = x(str);
            if (aVarX == null) {
                return false;
            }
            d(aVarX, true, false, C22477vI7.f);
            return true;
        } catch (Throwable th) {
            Log.e("LocalController", "Failed to updateLanguage", th);
            return false;
        }
    }

    public int d(a aVar, boolean z, boolean z2, int i2) {
        return e(aVar, z, z2, false, false, i2, null);
    }

    public int e(a aVar, boolean z, boolean z2, boolean z3, boolean z4, int i2, Runnable runnable) {
        boolean z5;
        if (aVar == null) {
            return 0;
        }
        boolean zF = aVar.f();
        File fileD = aVar.d();
        File fileC = aVar.c();
        if (x(aVar.b()) == null && aVar.h()) {
            this.A.add(aVar);
            this.B.put(aVar.b(), aVar);
            N();
        }
        if ((aVar.g() || aVar.h()) && (z4 || !fileD.exists() || (zF && !fileC.exists()))) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("reload locale because one of file doesn't exist " + fileD + Separators.SP + fileC);
            }
            z5 = true;
        } else {
            z5 = false;
        }
        try {
            String[] strArrSplit = !TextUtils.isEmpty(aVar.f) ? aVar.f.split("_") : !TextUtils.isEmpty(aVar.e) ? aVar.e.split("_") : aVar.c.split("_");
            Locale locale = strArrSplit.length == 1 ? new Locale(strArrSplit[0]) : new Locale(strArrSplit[0], strArrSplit[1]);
            if (z) {
                this.v = aVar.c;
                SharedPreferences.Editor editorEdit = ir.nasim.tgwidgets.editor.messenger.C.m().edit();
                editorEdit.putString("language", aVar.b());
                editorEdit.commit();
            }
            if (fileD == null) {
                this.u.clear();
            } else if (!z3) {
                HashMap mapY = y(zF ? aVar.c() : aVar.d());
                this.u = mapY;
                if (zF) {
                    mapY.putAll(y(aVar.d()));
                }
            }
            this.q = locale;
            this.t = aVar;
            AbstractC6403Nl2.a("applyLanguage: currentLocaleInfo is set");
            if (!TextUtils.isEmpty(this.t.f)) {
                this.s = (b) this.p.get(this.t.f);
            }
            if (this.s == null) {
                this.s = (b) this.p.get(strArrSplit[0]);
            }
            if (this.s == null) {
                this.s = (b) this.p.get(this.q.getLanguage());
            }
            if (this.s == null) {
                this.s = new m();
            }
            this.w = true;
            Locale.setDefault(this.q);
            Configuration configuration = new Configuration();
            configuration.locale = this.q;
            AbstractC14047hG.a.getResources().updateConfiguration(configuration, AbstractC14047hG.a.getResources().getDisplayMetrics());
            this.w = false;
            if (this.x || (!z5 && !z4)) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("reload locale because one of file is corrupted " + fileD + Separators.SP + fileC);
                }
                this.x = false;
            }
            if (!z5) {
                if (z2) {
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.EH3
                        @Override // java.lang.Runnable
                        public final void run() {
                            FH3.J();
                        }
                    });
                } else {
                    ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.Z2, new Object[0]);
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
            this.w = false;
        }
        M();
        return 0;
    }

    public String i(long j2, String str) {
        return j(j2, true, true, false, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String j(long r18, boolean r20, boolean r21, boolean r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FH3.j(long, boolean, boolean, boolean, java.lang.String):java.lang.String");
    }

    public a v() {
        return this.t;
    }

    public a x(String str) {
        if (str == null) {
            return null;
        }
        return (a) this.B.get(str.toLowerCase().replace("-", "_"));
    }
}
