package io.sentry.android.core.internal.util;

import io.sentry.InterfaceC3102d0;
import io.sentry.util.AbstractC3209h;
import io.sentry.util.C3202a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class l {
    private static final l c = new l();
    private final C3202a a = new C3202a();
    private final List b = new ArrayList();

    private l() {
    }

    public static l a() {
        return c;
    }

    String b() {
        return "/sys/devices/system/cpu";
    }

    public List c() {
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            if (!this.b.isEmpty()) {
                List list = this.b;
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return list;
            }
            File[] fileArrListFiles = new File(b()).listFiles();
            if (fileArrListFiles == null) {
                ArrayList arrayList = new ArrayList();
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return arrayList;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().matches("cpu[0-9]+")) {
                    File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                    if (file2.exists() && file2.canRead()) {
                        try {
                            String strC = AbstractC3209h.c(file2);
                            if (strC != null) {
                                this.b.add(Integer.valueOf((int) (Long.parseLong(strC.trim()) / 1000)));
                            }
                        } catch (IOException | NumberFormatException unused) {
                        }
                    }
                }
            }
            List list2 = this.b;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return list2;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
