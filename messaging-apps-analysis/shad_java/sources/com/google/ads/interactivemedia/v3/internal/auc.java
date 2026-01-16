package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class auc extends atz {
    private final aub a = new aub();

    auc() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atz
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.a.a(th, true).add(th2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atz
    public final void b(Throwable th) {
        th.printStackTrace();
        List<Throwable> listA = this.a.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            for (Throwable th2 : listA) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
