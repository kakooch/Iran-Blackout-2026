package io.appmetrica.analytics.impl;

import android.os.FileObserver;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.io.File;

/* renamed from: io.appmetrica.analytics.impl.f6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class FileObserverC2534f6 extends FileObserver {
    public final Consumer a;
    public final File b;
    public final U9 c;

    public FileObserverC2534f6(File file, A1 a1, U9 u9) {
        super(file.getAbsolutePath(), 4095);
        this.a = a1;
        this.b = file;
        this.c = u9;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (i != 8 || TextUtils.isEmpty(str)) {
            return;
        }
        Consumer consumer = this.a;
        U9 u9 = this.c;
        File file = this.b;
        u9.getClass();
        consumer.consume(new File(file, str));
    }
}
