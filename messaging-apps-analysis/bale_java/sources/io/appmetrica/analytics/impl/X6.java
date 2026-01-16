package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import ir.nasim.AbstractC10360bX0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class X6 {
    public final F6 a;
    public final List b;
    public final boolean c;

    public X6(F6 f6, ArrayList arrayList, boolean z) {
        this.a = f6;
        this.b = arrayList;
        this.c = z;
    }

    public final String a(Context context, U6 u6) {
        File parentFile;
        try {
            File fileA = this.a.a(context, u6.b());
            if (!fileA.exists() && (parentFile = fileA.getParentFile()) != null && (parentFile.exists() || parentFile.mkdirs())) {
                a(context, u6.a(), fileA);
            }
            return fileA.getPath();
        } catch (Throwable unused) {
            return u6.b();
        }
    }

    public final void a(Context context, String str, File file) {
        List list = this.b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File fileA = ((F6) it.next()).a(context, str);
            if (fileA.exists()) {
                try {
                    if (this.c) {
                        FileUtils.copyToNullable(fileA, file);
                    } else {
                        FileUtils.move(fileA, file);
                    }
                    String path = fileA.getPath();
                    String path2 = file.getPath();
                    for (String str2 : AbstractC10360bX0.p("-journal", "-shm", "-wal")) {
                        File file2 = new File(path + str2);
                        File file3 = new File(path2 + str2);
                        if (this.c) {
                            FileUtils.copyToNullable(file2, file3);
                        } else {
                            FileUtils.move(file2, file3);
                        }
                    }
                    return;
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
    }
}
