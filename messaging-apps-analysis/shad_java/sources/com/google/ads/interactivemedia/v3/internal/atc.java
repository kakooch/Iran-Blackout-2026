package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class atc extends asv {
    private atc() {
    }

    /* synthetic */ atc(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void a(ath athVar, Thread thread) {
        athVar.b = thread;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final void b(ath athVar, ath athVar2) {
        athVar.c = athVar2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean c(ati<?> atiVar, ath athVar, ath athVar2) {
        synchronized (atiVar) {
            if (((ati) atiVar).g != athVar) {
                return false;
            }
            ((ati) atiVar).g = athVar2;
            return true;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean d(ati<?> atiVar, asz aszVar, asz aszVar2) {
        synchronized (atiVar) {
            if (((ati) atiVar).f != aszVar) {
                return false;
            }
            ((ati) atiVar).f = aszVar2;
            return true;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asv
    final boolean e(ati<?> atiVar, Object obj, Object obj2) {
        synchronized (atiVar) {
            if (((ati) atiVar).e != obj) {
                return false;
            }
            ((ati) atiVar).e = obj2;
            return true;
        }
    }
}
