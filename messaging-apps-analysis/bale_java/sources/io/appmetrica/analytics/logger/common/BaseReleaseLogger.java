package io.appmetrica.analytics.logger.common;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.util.Log;
import io.appmetrica.analytics.logger.common.impl.a;
import io.appmetrica.analytics.logger.common.impl.b;
import io.appmetrica.analytics.logger.common.impl.c;
import io.appmetrica.analytics.logger.common.impl.d;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class BaseReleaseLogger {
    private static volatile String d = "";
    private final String a;
    private volatile boolean b = false;
    private final c c;

    public BaseReleaseLogger(String str, String str2) {
        this.c = new c(new d(str), new a(), new b());
        this.a = str2;
    }

    public static void init(Context context) {
        d = "[" + context.getPackageName() + "] : ";
    }

    public void error(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            Iterator it = cVar.c.a(a.a(prefix, str, objArr)).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = cVar.a.a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(6, str3, str2);
            }
        }
    }

    public String getPrefix() {
        return d + this.a;
    }

    public void info(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            Iterator it = cVar.c.a(a.a(prefix, str, objArr)).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = cVar.a.a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(4, str3, str2);
            }
        }
    }

    public void setEnabled(boolean z) {
        this.b = z;
    }

    public void warning(String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            Iterator it = cVar.c.a(a.a(prefix, str, objArr)).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = cVar.a.a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(5, str3, str2);
            }
        }
    }

    public void error(Throwable th, String str, Object... objArr) {
        if (this.b) {
            c cVar = this.c;
            String prefix = getPrefix();
            cVar.b.getClass();
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(Separators.RETURN);
            sb.append(Log.getStackTraceString(th));
            Iterator it = cVar.c.a(a.a(prefix, sb.toString(), objArr)).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = cVar.a.a;
                if (str2 == null) {
                    str2 = "";
                }
                Log.println(6, str3, str2);
            }
        }
    }
}
