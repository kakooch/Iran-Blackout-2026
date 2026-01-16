package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import java.io.File;

/* renamed from: io.appmetrica.analytics.impl.zj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3025zj implements ServiceStorageProvider {
    public final Context a;
    public final InterfaceC2882tk b;
    public final SQLiteOpenHelper c;

    public C3025zj(Context context, InterfaceC2882tk interfaceC2882tk, SQLiteOpenHelper sQLiteOpenHelper) {
        this.a = context;
        this.b = interfaceC2882tk;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C2789pm c2789pm;
        W6 w6A = W6.a(this.a);
        synchronized (w6A) {
            try {
                if (w6A.o == null) {
                    Context context = w6A.e;
                    Sl sl = Sl.SERVICE;
                    if (w6A.n == null) {
                        w6A.n = new C2765om(new C2787pk(w6A.h()), "temp_cache");
                    }
                    w6A.o = new C2789pm(context, sl, w6A.n);
                }
                c2789pm = w6A.o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2789pm;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new C2802qb(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new Ec(str, this.b);
    }
}
