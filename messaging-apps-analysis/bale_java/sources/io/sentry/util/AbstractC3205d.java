package io.sentry.util;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import io.sentry.C3155n3;
import io.sentry.W2;
import io.sentry.Y2;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* renamed from: io.sentry.util.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3205d {
    public static String a = "sentry-debug-meta.properties";

    public static void a(C3155n3 c3155n3, List list) {
        if (list != null) {
            e(c3155n3, list);
            b(c3155n3, list);
        }
    }

    private static void b(C3155n3 c3155n3, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Properties properties = (Properties) it.next();
            String strF = f(properties);
            if (strF != null) {
                String strG = g(properties);
                if (strG == null) {
                    strG = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
                }
                c3155n3.getLogger().c(Y2.DEBUG, "Build tool found: %s, version %s", strF, strG);
                W2.d().b(strF, strG);
                return;
            }
        }
    }

    private static void c(C3155n3 c3155n3, List list) {
        if (c3155n3.getBundleIds().isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String property = ((Properties) it.next()).getProperty("io.sentry.bundle-ids");
                c3155n3.getLogger().c(Y2.DEBUG, "Bundle IDs found: %s", property);
                if (property != null) {
                    for (String str : property.split(",", -1)) {
                        c3155n3.addBundleId(str);
                    }
                }
            }
        }
    }

    private static void d(C3155n3 c3155n3, List list) {
        if (c3155n3.getProguardUuid() == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String strH = h((Properties) it.next());
                if (strH != null) {
                    c3155n3.getLogger().c(Y2.DEBUG, "Proguard UUID found: %s", strH);
                    c3155n3.setProguardUuid(strH);
                    return;
                }
            }
        }
    }

    public static void e(C3155n3 c3155n3, List list) {
        if (list != null) {
            c(c3155n3, list);
            d(c3155n3, list);
        }
    }

    public static String f(Properties properties) {
        return properties.getProperty("io.sentry.build-tool");
    }

    public static String g(Properties properties) {
        return properties.getProperty("io.sentry.build-tool-version");
    }

    public static String h(Properties properties) {
        return properties.getProperty("io.sentry.ProguardUuids");
    }
}
