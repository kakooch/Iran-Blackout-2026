package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import org.rbmain.messenger.LiteMode;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class nz implements jy {
    public static final /* synthetic */ int a = 0;
    private final oa b = new oa(null);
    private final aee c = new aee(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
    private boolean d;

    static {
        int i = ny.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.b.b(kaVar, new pq(0, 1));
        kaVar.al();
        kaVar.am(new kn(-9223372036854775807L));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.d = false;
        this.b.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
    
        r15.j();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if ((r4 - r3) < 8192) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
    
        return false;
     */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.ads.interactivemedia.v3.internal.jv r15) throws java.io.IOException {
        /*
            r14 = this;
            com.google.ads.interactivemedia.v3.internal.aee r0 = new com.google.ads.interactivemedia.v3.internal.aee
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.i()
            r15.g(r4, r2, r1)
            r0.h(r2)
            int r4 = r0.r()
            r5 = 4801587(0x494433, float:6.728456E-39)
            r6 = 3
            if (r4 == r5) goto L96
            r15.j()
            r15.i(r3)
            r4 = r3
        L24:
            r1 = 0
        L25:
            byte[] r5 = r0.i()
            r7 = 7
            r15.g(r5, r2, r7)
            r0.h(r2)
            int r5 = r0.o()
            r8 = 44096(0xac40, float:6.1792E-41)
            r9 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r8) goto L4e
            if (r5 == r9) goto L4e
            r15.j()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L4a
            return r2
        L4a:
            r15.i(r4)
            goto L24
        L4e:
            r8 = 1
            int r1 = r1 + r8
            r10 = 4
            if (r1 < r10) goto L54
            return r8
        L54:
            byte[] r8 = r0.i()
            int r11 = com.google.ads.interactivemedia.v3.internal.gr.a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r7) goto L60
            r11 = -1
            goto L8d
        L60:
            r11 = 2
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r13 = r8[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L87
            r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            r11 = 5
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r10 = r10 | r11
            r11 = 6
            r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r10 | r8
            goto L88
        L87:
            r7 = 4
        L88:
            if (r5 != r9) goto L8c
            int r7 = r7 + 2
        L8c:
            int r11 = r11 + r7
        L8d:
            if (r11 != r12) goto L90
            return r2
        L90:
            int r11 = r11 + (-7)
            r15.i(r11)
            goto L25
        L96:
            r0.k(r6)
            int r4 = r0.A()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r15.i(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.nz.g(com.google.ads.interactivemedia.v3.internal.jv):boolean");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        int iA = jvVar.a(this.c.i(), 0, LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
        if (iA == -1) {
            return -1;
        }
        this.c.h(0);
        this.c.f(iA);
        if (!this.d) {
            this.b.c(0L, 4);
            this.d = true;
        }
        this.b.d(this.c);
        return 0;
    }
}
