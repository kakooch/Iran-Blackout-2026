package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.impl.C2589hd;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrash;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.UA2;
import java.io.File;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.hd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2589hd implements NativeCrashHandler {
    public final C2687lg a;
    public final UA2 b;

    public C2589hd(C2687lg c2687lg, UA2 ua2) {
        this.a = c2687lg;
        this.b = ua2;
    }

    public static final void a(C2589hd c2589hd, NativeCrash nativeCrash, File file) {
        c2589hd.b.invoke(nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String());
    }

    public static final void b(C2589hd c2589hd, NativeCrash nativeCrash, File file) {
        c2589hd.b.invoke(nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String());
    }

    @Override // io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashHandler
    public final void newCrash(final NativeCrash nativeCrash) {
        C2934w0 c2934w0;
        try {
            NativeCrashSource source = nativeCrash.getSource();
            String handlerVersion = nativeCrash.getHandlerVersion();
            String str = nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String();
            String dumpFile = nativeCrash.getDumpFile();
            long creationTime = nativeCrash.getCreationTime();
            C2958x0 c2958x0A = C2982y0.a(nativeCrash.getMetadata());
            AbstractC13042fc3.f(c2958x0A);
            c2934w0 = new C2934w0(source, handlerVersion, str, dumpFile, creationTime, c2958x0A);
        } catch (Throwable unused) {
            c2934w0 = null;
        }
        if (c2934w0 == null) {
            this.b.invoke(nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String());
            return;
        }
        C2687lg c2687lg = this.a;
        Consumer consumer = new Consumer() { // from class: ir.nasim.ge8
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C2589hd.a(this.a, nativeCrash, (File) obj);
            }
        };
        c2687lg.getClass();
        c2687lg.a(c2934w0, consumer, new C2615ig(c2934w0));
    }

    public final void a(List<NativeCrash> list) {
        C2934w0 c2934w0;
        for (final NativeCrash nativeCrash : list) {
            try {
                NativeCrashSource source = nativeCrash.getSource();
                String handlerVersion = nativeCrash.getHandlerVersion();
                String str = nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String();
                String dumpFile = nativeCrash.getDumpFile();
                long creationTime = nativeCrash.getCreationTime();
                C2958x0 c2958x0A = C2982y0.a(nativeCrash.getMetadata());
                AbstractC13042fc3.f(c2958x0A);
                c2934w0 = new C2934w0(source, handlerVersion, str, dumpFile, creationTime, c2958x0A);
            } catch (Throwable unused) {
                c2934w0 = null;
            }
            if (c2934w0 != null) {
                C2687lg c2687lg = this.a;
                Consumer consumer = new Consumer() { // from class: ir.nasim.fe8
                    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
                    public final void consume(Object obj) {
                        C2589hd.b(this.a, nativeCrash, (File) obj);
                    }
                };
                c2687lg.getClass();
                c2687lg.a(c2934w0, consumer, new C2639jg(c2934w0));
            } else {
                this.b.invoke(nativeCrash.getIo.appmetrica.analytics.networktasks.internal.CommonUrlParts.UUID java.lang.String());
            }
        }
    }
}
