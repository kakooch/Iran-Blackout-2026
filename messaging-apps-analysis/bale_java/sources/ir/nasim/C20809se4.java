package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.se4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C20809se4 implements XV {
    private final a a;
    private final C19175pu1 b;
    private final Map c;

    /* renamed from: ir.nasim.se4$a */
    static class a {
        private final Context a;
        private Map b = null;

        a(Context context) {
            this.a = context;
        }

        private Map a(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        private Map c() {
            if (this.b == null) {
                this.b = a(this.a);
            }
            return this.b;
        }

        private static Bundle d(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        WV b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (WV) Class.forName(str2).asSubclass(WV.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            }
        }
    }

    C20809se4(Context context, C19175pu1 c19175pu1) {
        this(new a(context), c19175pu1);
    }

    @Override // ir.nasim.XV
    public synchronized InterfaceC5558Jv7 get(String str) {
        if (this.c.containsKey(str)) {
            return (InterfaceC5558Jv7) this.c.get(str);
        }
        WV wvB = this.a.b(str);
        if (wvB == null) {
            return null;
        }
        InterfaceC5558Jv7 interfaceC5558Jv7Create = wvB.create(this.b.a(str));
        this.c.put(str, interfaceC5558Jv7Create);
        return interfaceC5558Jv7Create;
    }

    C20809se4(a aVar, C19175pu1 c19175pu1) {
        this.c = new HashMap();
        this.a = aVar;
        this.b = c19175pu1;
    }
}
