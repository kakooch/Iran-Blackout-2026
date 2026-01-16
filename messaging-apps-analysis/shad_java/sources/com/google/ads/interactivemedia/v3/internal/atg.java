package com.google.ads.interactivemedia.v3.internal;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import org.rbmain.messenger.ImageLoader;
import sun.misc.Unsafe;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class atg extends asv {
    static final Unsafe a;
    static final long b;
    static final long c;
    static final long d;
    static final long e;
    static final long f;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new atf());
        }
        try {
            c = unsafe.objectFieldOffset(ati.class.getDeclaredField(ImageLoader.AUTOPLAY_FILTER));
            b = unsafe.objectFieldOffset(ati.class.getDeclaredField("f"));
            d = unsafe.objectFieldOffset(ati.class.getDeclaredField("e"));
            e = unsafe.objectFieldOffset(ath.class.getDeclaredField("b"));
            f = unsafe.objectFieldOffset(ath.class.getDeclaredField("c"));
            a = unsafe;
        } catch (Exception e3) {
            aqf.a(e3);
            throw new RuntimeException(e3);
        }
    }

    private atg() {
    }

    /* synthetic */ atg(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void a(ath athVar, Thread thread) {
        a.putObject(athVar, e, thread);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void b(ath athVar, ath athVar2) {
        a.putObject(athVar, f, athVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean c(ati<?> atiVar, ath athVar, ath athVar2) {
        return a.compareAndSwapObject(atiVar, c, athVar, athVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean d(ati<?> atiVar, asz aszVar, asz aszVar2) {
        return a.compareAndSwapObject(atiVar, b, aszVar, aszVar2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean e(ati<?> atiVar, Object obj, Object obj2) {
        return a.compareAndSwapObject(atiVar, d, obj, obj2);
    }
}
