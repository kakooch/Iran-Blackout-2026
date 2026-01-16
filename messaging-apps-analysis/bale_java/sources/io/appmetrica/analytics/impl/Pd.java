package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import ir.nasim.AbstractC20153rZ6;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class Pd {
    public final Context a;
    public final kn b;
    public final ln c;

    public Pd(Context context) {
        this(context, new kn(), new ln());
    }

    public final String a(String str) {
        try {
            this.c.getClass();
            if (!ln.a(str)) {
                this.b.getClass();
                str = AbstractC20153rZ6.M(UUID.randomUUID().toString(), "-", "", false, 4, null).toLowerCase(Locale.US);
            }
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.a, "uuid.dat");
            if (fileFromSdkStorage != null && str != null) {
                Da.a(str, new FileOutputStream(fileFromSdkStorage));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Pd(Context context, kn knVar, ln lnVar) {
        this.a = context;
        this.b = knVar;
        this.c = lnVar;
    }

    public final void a() {
        File fileFromAppStorage;
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.a, "uuid.dat");
        if (fileFromSdkStorage == null || fileFromSdkStorage.exists() || (fileFromAppStorage = FileUtils.getFileFromAppStorage(this.a, "uuid.dat")) == null || !fileFromAppStorage.exists()) {
            return;
        }
        FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
    }
}
