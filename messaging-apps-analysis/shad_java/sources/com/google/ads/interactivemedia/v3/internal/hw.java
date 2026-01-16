package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;
import android.media.AudioTrack;
import org.rbmain.messenger.OneUIUtilities;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hw {
    public final cy a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final gx[] j;

    private final int e(long j) {
        int i;
        int i2 = this.g;
        switch (i2) {
            case 5:
                i = 80000;
                break;
            case 6:
            case 18:
                i = 768000;
                break;
            case 7:
                i = 192000;
                break;
            case 8:
                i = 2250000;
                break;
            case 9:
                i = OneUIUtilities.ONE_UI_4_0;
                break;
            case 10:
                i = 100000;
                break;
            case 11:
                i = 16000;
                break;
            case 12:
                i = 7000;
                break;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                i = 3062500;
                break;
            case 15:
                i = 8000;
                break;
            case 16:
                i = 256000;
                break;
            case 17:
                i = 336000;
                break;
        }
        if (i2 == 5) {
            i += i;
        }
        return (int) ((j * i) / 1000000);
    }

    private static AudioAttributes f(gs gsVar, boolean z) {
        return z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : gsVar.a();
    }

    public final long a(long j) {
        return (j * 1000000) / this.e;
    }

    public final long b(long j) {
        return (j * this.e) / 1000000;
    }

    public final AudioTrack c(boolean z, gs gsVar, int i) throws hk {
        AudioTrack audioTrack;
        try {
            int i2 = aeu.a;
            if (i2 >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(f(gsVar, z)).setAudioFormat(ie.X(this.e, this.f, this.g)).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
            } else if (i2 >= 21) {
                audioTrack = new AudioTrack(f(gsVar, z), ie.X(this.e, this.f, this.g), this.h, 1, i);
            } else {
                int i3 = gsVar.c;
                audioTrack = i == 0 ? new AudioTrack(3, this.e, this.f, this.g, this.h, 1) : new AudioTrack(3, this.e, this.f, this.g, this.h, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new hk(state, this.e, this.f, this.h, d(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new hk(0, this.e, this.f, this.h, d(), e);
        }
    }

    public final boolean d() {
        return this.c == 1;
    }

    public hw(cy cyVar, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, gx[] gxVarArr) {
        int iH;
        this.a = cyVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.i = z2;
        this.j = gxVarArr;
        if (i2 != 0) {
            iH = i2 != 1 ? e(250000L) : e(50000000L);
        } else {
            int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
            ary.q(minBufferSize != -2);
            iH = aeu.H(minBufferSize * 4, ((int) b(250000L)) * i3, Math.max(minBufferSize, ((int) b(750000L)) * i3));
        }
        this.h = iH;
    }
}
