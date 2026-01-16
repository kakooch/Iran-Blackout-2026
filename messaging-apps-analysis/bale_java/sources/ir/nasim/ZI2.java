package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class ZI2 {
    public static final ZI2 a = new ZI2();

    private ZI2() {
    }

    public static final int b(String str) {
        AbstractC13042fc3.i(str, "versionName");
        try {
            String strSubstring = str.substring(AbstractC20762sZ6.l0(str, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(str, Separators.RPAREN, 0, false, 6, null));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return Integer.parseInt(strSubstring);
        } catch (Exception e) {
            C19406qI3.c("GlobalConfigUtils", "Error in parsing version number", e);
            return -1;
        }
    }

    public static final boolean c(String str, long j, int i) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            AbstractC22735vk3 abstractC22735vk3G = new C19231q00(str).g(ConstantDeviceInfo.APP_PLATFORM);
            if (abstractC22735vk3G == null) {
                return false;
            }
            C8542Wk3 c8542Wk3O = abstractC22735vk3G.o();
            AbstractC13042fc3.h(c8542Wk3O, "getAsJsonObject(...)");
            C19231q00 c19231q00 = new C19231q00(c8542Wk3O);
            long jM = c19231q00.m("minVersion", -1L);
            boolean z = j < jM || (c19231q00.m("excludeVersionFrom", -1L) <= j && j <= c19231q00.m("excludeVersionTo", -1L));
            int iK = c19231q00.k("forceUpdateAndroidVersionFrom", -1);
            int iK2 = c19231q00.k("forceUpdateAndroidVersionTo", -1);
            return (iK == -1 || iK2 == -1 || jM == -1 || !z || !(iK <= i && i <= iK2)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean d(String str, long j, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            String strR = AbstractC20507s76.r();
            AbstractC13042fc3.h(strR, "getVersion(...)");
            j = b(strR);
        }
        if ((i2 & 4) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return c(str, j, i);
    }

    public final void a(C8542Wk3 c8542Wk3) {
        AbstractC13042fc3.i(c8542Wk3, "config");
        AbstractC22735vk3 abstractC22735vk3L = c8542Wk3.L("general");
        if (abstractC22735vk3L != null) {
            C8542Wk3 c8542Wk3O = abstractC22735vk3L.o();
            AbstractC22735vk3 abstractC22735vk3L2 = c8542Wk3O.L("opsDisabled");
            if (abstractC22735vk3L2 != null && abstractC22735vk3L2.w()) {
                C13149fk3 c13149fk3J = abstractC22735vk3L2.j();
                AbstractC13042fc3.f(c13149fk3J);
                Iterator it = c13149fk3J.iterator();
                while (it.hasNext()) {
                    C7183Qq.q(EnumC18608ow5.h).g(((AbstractC22735vk3) it.next()).v(), true);
                }
            }
            AbstractC22735vk3 abstractC22735vk3L3 = c8542Wk3O.L("rpcDisabled");
            if (abstractC22735vk3L3 != null && abstractC22735vk3L3.w()) {
                C13149fk3 c13149fk3J2 = abstractC22735vk3L3.j();
                AbstractC13042fc3.f(c13149fk3J2);
                Iterator it2 = c13149fk3J2.iterator();
                while (it2.hasNext()) {
                    C7183Qq.q(EnumC18608ow5.h).g(((AbstractC22735vk3) it2.next()).v(), true);
                }
            }
            AbstractC22735vk3 abstractC22735vk3L4 = c8542Wk3O.L("rpcDisabledByHeader");
            if (abstractC22735vk3L4 == null || !abstractC22735vk3L4.w()) {
                return;
            }
            C13149fk3<AbstractC22735vk3> c13149fk3J3 = abstractC22735vk3L4.j();
            AbstractC13042fc3.f(c13149fk3J3);
            for (AbstractC22735vk3 abstractC22735vk3 : c13149fk3J3) {
                C7183Qq.q(EnumC18608ow5.h).g("rpc_header_" + abstractC22735vk3.v(), true);
            }
        }
    }
}
