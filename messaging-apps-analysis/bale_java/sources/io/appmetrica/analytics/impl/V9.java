package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import ir.nasim.AbstractC11308cn2;
import java.io.File;

/* loaded from: classes3.dex */
public final class V9 implements xn {
    public final Context a;
    public final String b;

    public V9(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final String a() {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.a, this.b);
            if (fileFromSdkStorage == null) {
                return null;
            }
            fileFromSdkStorage.exists();
            File fileFromAppStorage = FileUtils.getFileFromAppStorage(this.a, this.b);
            if (fileFromAppStorage != null) {
                FileUtils.copyToNullable(fileFromAppStorage, fileFromSdkStorage);
            }
            return AbstractC11308cn2.h(fileFromSdkStorage, null, 1, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.appmetrica.analytics.impl.xn
    public final void a(String str) {
        try {
            File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(this.a, this.b);
            if (fileFromSdkStorage != null) {
                AbstractC11308cn2.j(fileFromSdkStorage, str, null, 2, null);
            }
        } catch (Throwable unused) {
        }
    }
}
