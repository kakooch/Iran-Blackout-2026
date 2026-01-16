package ir.nasim;

import android.os.Build;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.HashMap;

/* loaded from: classes8.dex */
public final class AK1 {
    public static final AK1 a = new AK1();

    private AK1() {
    }

    public static final String b() {
        String str = Build.MANUFACTURER;
        String strSubstring = Build.MODEL;
        AbstractC13042fc3.f(strSubstring);
        AbstractC13042fc3.f(str);
        if (AbstractC20153rZ6.S(strSubstring, str, false, 2, null)) {
            AbstractC13042fc3.f(strSubstring);
            strSubstring = strSubstring.substring(str.length());
            AbstractC13042fc3.h(strSubstring, "substring(...)");
        }
        C5721Ko c5721Ko = C5721Ko.a;
        String str2 = c5721Ko.d().getResources().getDisplayMetrics().heightPixels + "x" + c5721Ko.d().getResources().getDisplayMetrics().widthPixels;
        int i = (int) c5721Ko.d().getResources().getDisplayMetrics().xdpi;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String string = sb.toString();
        HashMap map = new HashMap();
        map.put(CommonUrlParts.MANUFACTURER, str);
        map.put(CommonUrlParts.MODEL, strSubstring);
        int i2 = Build.VERSION.SDK_INT;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i2);
        map.put("api", sb2.toString());
        map.put("rom", Build.DISPLAY);
        map.put("resolution", str2);
        map.put("dpi", string);
        map.put("serial", Build.SERIAL);
        map.put("appVersion", AbstractC20507s76.r());
        String strT = C19231q00.b.a().t(map);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }

    public final String a() {
        return Build.MANUFACTURER + " : " + Build.MODEL;
    }
}
