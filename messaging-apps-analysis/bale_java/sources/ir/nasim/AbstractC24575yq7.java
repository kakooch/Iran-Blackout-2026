package ir.nasim;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.exoplayer2.J0;
import ir.nasim.XY3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.yq7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24575yq7 implements XY3.k {
    private final MediaSessionCompat a;
    private final J0.d b;
    private final int c;
    private long d;

    public AbstractC24575yq7(MediaSessionCompat mediaSessionCompat) {
        this(mediaSessionCompat, 10);
    }

    private void o(com.google.android.exoplayer2.z0 z0Var) {
        com.google.android.exoplayer2.J0 j0N = z0Var.N();
        if (j0N.v()) {
            this.a.l(Collections.emptyList());
            this.d = -1L;
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int iMin = Math.min(this.c, j0N.u());
        int iR0 = z0Var.r0();
        long j = iR0;
        arrayDeque.add(new MediaSessionCompat.QueueItem(n(z0Var, iR0), j));
        boolean zV0 = z0Var.v0();
        int iJ = iR0;
        while (true) {
            if ((iR0 == -1 && iJ == -1) || arrayDeque.size() >= iMin) {
                break;
            }
            if (iJ != -1 && (iJ = j0N.j(iJ, 0, zV0)) != -1) {
                arrayDeque.add(new MediaSessionCompat.QueueItem(n(z0Var, iJ), iJ));
            }
            if (iR0 != -1 && arrayDeque.size() < iMin && (iR0 = j0N.q(iR0, 0, zV0)) != -1) {
                arrayDeque.addFirst(new MediaSessionCompat.QueueItem(n(z0Var, iR0), iR0));
            }
        }
        this.a.l(new ArrayList(arrayDeque));
        this.d = j;
    }

    @Override // ir.nasim.XY3.k
    public void b(com.google.android.exoplayer2.z0 z0Var) {
        z0Var.Q();
    }

    @Override // ir.nasim.XY3.k
    public final long c(com.google.android.exoplayer2.z0 z0Var) {
        return this.d;
    }

    @Override // ir.nasim.XY3.k
    public void d(com.google.android.exoplayer2.z0 z0Var, long j) {
        int i;
        com.google.android.exoplayer2.J0 j0N = z0Var.N();
        if (j0N.v() || z0Var.k() || (i = (int) j) < 0 || i >= j0N.u()) {
            return;
        }
        z0Var.j0(i);
    }

    @Override // ir.nasim.XY3.c
    public boolean h(com.google.android.exoplayer2.z0 z0Var, String str, Bundle bundle, ResultReceiver resultReceiver) {
        return false;
    }

    @Override // ir.nasim.XY3.k
    public final void i(com.google.android.exoplayer2.z0 z0Var) {
        o(z0Var);
    }

    @Override // ir.nasim.XY3.k
    public long j(com.google.android.exoplayer2.z0 z0Var) {
        boolean z;
        boolean z2;
        com.google.android.exoplayer2.J0 j0N = z0Var.N();
        if (j0N.v() || z0Var.k()) {
            z = false;
            z2 = false;
        } else {
            j0N.s(z0Var.r0(), this.b);
            boolean z3 = j0N.u() > 1;
            z2 = z0Var.K(5) || !this.b.i() || z0Var.K(6);
            z = (this.b.i() && this.b.i) || z0Var.K(8);
            z = z3;
        }
        long j = z ? 4096L : 0L;
        if (z2) {
            j |= 16;
        }
        return z ? j | 32 : j;
    }

    @Override // ir.nasim.XY3.k
    public void k(com.google.android.exoplayer2.z0 z0Var) {
        z0Var.C();
    }

    @Override // ir.nasim.XY3.k
    public final void l(com.google.android.exoplayer2.z0 z0Var) {
        if (this.d == -1 || z0Var.N().u() > this.c) {
            o(z0Var);
        } else {
            if (z0Var.N().v()) {
                return;
            }
            this.d = z0Var.r0();
        }
    }

    public abstract MediaDescriptionCompat n(com.google.android.exoplayer2.z0 z0Var, int i);

    public AbstractC24575yq7(MediaSessionCompat mediaSessionCompat, int i) {
        AbstractC20011rK.g(i > 0);
        this.a = mediaSessionCompat;
        this.c = i;
        this.d = -1L;
        this.b = new J0.d();
    }
}
