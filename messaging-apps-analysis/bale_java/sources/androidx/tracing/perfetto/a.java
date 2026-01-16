package androidx.tracing.perfetto;

import android.content.Context;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12275eL0;
import ir.nasim.C19938rB7;
import ir.nasim.RK6;
import ir.nasim.YV0;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

/* loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final File c(String str) {
        return new File("/sdcard/Android/media/" + str + "/libtracing_perfetto_startup.properties");
    }

    public final void a(Context context) {
        AbstractC13042fc3.i(context, "context");
        StartupTracingConfigStoreIsEnabledGate.INSTANCE.a(context);
        String packageName = context.getPackageName();
        AbstractC13042fc3.h(packageName, "context.packageName");
        c(packageName).delete();
    }

    public final RK6 b(Context context) throws IOException {
        AbstractC13042fc3.i(context, "context");
        if (!StartupTracingConfigStoreIsEnabledGate.INSTANCE.d(context)) {
            return null;
        }
        String packageName = context.getPackageName();
        AbstractC13042fc3.h(packageName, "context.packageName");
        File fileC = c(packageName);
        if (!fileC.exists()) {
            return null;
        }
        Properties properties = new Properties();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileC), C12275eL0.b);
        try {
            properties.load(inputStreamReader);
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(inputStreamReader, null);
            return new RK6(properties.getProperty("libtracingPerfettoFilePath"), Boolean.parseBoolean(properties.getProperty("isPersistent")));
        } finally {
        }
    }

    public final void d(RK6 rk6, Context context) throws IOException {
        AbstractC13042fc3.i(rk6, "<this>");
        AbstractC13042fc3.i(context, "context");
        String packageName = context.getPackageName();
        AbstractC13042fc3.h(packageName, "context.packageName");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(c(packageName)), C12275eL0.b);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        try {
            Properties properties = new Properties();
            properties.setProperty("libtracingPerfettoFilePath", rk6.a());
            properties.setProperty("isPersistent", String.valueOf(rk6.b()));
            properties.store(bufferedWriter, (String) null);
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(bufferedWriter, null);
            StartupTracingConfigStoreIsEnabledGate.INSTANCE.b(context);
        } finally {
        }
    }
}
