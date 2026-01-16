package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zj implements jy {
    private static final Pattern a = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern b = Pattern.compile("MPEGTS:(-?\\d+)");
    private final String c;
    private final aes d;
    private ka f;
    private int h;
    private final aee e = new aee();
    private byte[] g = new byte[1024];

    public zj(String str, aes aesVar) {
        this.c = str;
        this.d = aesVar;
    }

    private final kr a(long j) {
        kr krVarAk = this.f.ak(0, 3);
        cx cxVar = new cx();
        cxVar.ae("text/vtt");
        cxVar.V(this.c);
        cxVar.ai(j);
        krVarAk.a(cxVar.a());
        this.f.al();
        return krVarAk;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.f = kaVar;
        kaVar.am(new kn(-9223372036854775807L));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        jvVar.f(this.g, 0, 6, false);
        this.e.c(this.g, 6);
        if (aaf.b(this.e)) {
            return true;
        }
        jvVar.f(this.g, 6, 3, false);
        this.e.c(this.g, 9);
        return aaf.b(this.e);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException, NumberFormatException {
        int i;
        ary.t(this.f);
        int iM = (int) jvVar.m();
        int i2 = this.h;
        byte[] bArr = this.g;
        int length = bArr.length;
        if (i2 == length) {
            if (iM != -1) {
                i = iM;
            } else {
                iM = length;
                i = -1;
            }
            this.g = Arrays.copyOf(bArr, (iM * 3) / 2);
            iM = i;
        }
        byte[] bArr2 = this.g;
        int i3 = this.h;
        int iA = jvVar.a(bArr2, i3, bArr2.length - i3);
        if (iA != -1) {
            int i4 = this.h + iA;
            this.h = i4;
            if (iM == -1 || i4 != iM) {
                return 0;
            }
        }
        aee aeeVar = new aee(this.g);
        aaf.a(aeeVar);
        long jI = 0;
        long jC = 0;
        for (String strI = aeeVar.I(); !TextUtils.isEmpty(strI); strI = aeeVar.I()) {
            if (strI.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = a.matcher(strI);
                if (!matcher.find()) {
                    throw new dt(strI.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(strI) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                Matcher matcher2 = b.matcher(strI);
                if (!matcher2.find()) {
                    throw new dt(strI.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(strI) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                }
                String strGroup = matcher.group(1);
                ary.t(strGroup);
                jC = aaf.c(strGroup);
                String strGroup2 = matcher2.group(1);
                ary.t(strGroup2);
                jI = aes.i(Long.parseLong(strGroup2));
            }
        }
        Matcher matcherD = aaf.d(aeeVar);
        if (matcherD == null) {
            a(0L);
        } else {
            String strGroup3 = matcherD.group(1);
            ary.t(strGroup3);
            long jC2 = aaf.c(strGroup3);
            long jF = this.d.f(aes.j((jI + jC2) - jC) % 8589934592L);
            kr krVarA = a(jF - jC2);
            this.e.c(this.g, this.h);
            krVarA.d(this.e, this.h);
            krVarA.b(jF, 1, this.h, 0, null);
        }
        return -1;
    }
}
