package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C5045Hq7;
import ir.nasim.C8292Vi5;
import ir.nasim.EW4;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.Z88;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class WebvttExtractor implements InterfaceC9262Ze2 {
    private static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern h = Pattern.compile("MPEGTS:(-?\\d+)");
    private final String a;
    private final C5045Hq7 b;
    private InterfaceC10465bf2 d;
    private int f;
    private final EW4 c = new EW4();
    private byte[] e = new byte[1024];

    public WebvttExtractor(String str, C5045Hq7 c5045Hq7) {
        this.a = str;
        this.b = c5045Hq7;
    }

    private InterfaceC4589Ft7 c(long j) {
        InterfaceC4589Ft7 interfaceC4589Ft7B = this.d.b(0, 3);
        interfaceC4589Ft7B.c(new X.b().g0("text/vtt").X(this.a).k0(j).G());
        this.d.s();
        return interfaceC4589Ft7B;
    }

    private void f() throws ParserException {
        EW4 ew4 = new EW4(this.e);
        Z88.e(ew4);
        long jF = 0;
        long jD = 0;
        for (String strQ = ew4.q(); !TextUtils.isEmpty(strQ); strQ = ew4.q()) {
            if (strQ.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = g.matcher(strQ);
                if (!matcher.find()) {
                    throw ParserException.a("X-TIMESTAMP-MAP doesn't contain local timestamp: " + strQ, null);
                }
                Matcher matcher2 = h.matcher(strQ);
                if (!matcher2.find()) {
                    throw ParserException.a("X-TIMESTAMP-MAP doesn't contain media timestamp: " + strQ, null);
                }
                jD = Z88.d((String) AbstractC20011rK.e(matcher.group(1)));
                jF = C5045Hq7.f(Long.parseLong((String) AbstractC20011rK.e(matcher2.group(1))));
            }
        }
        Matcher matcherA = Z88.a(ew4);
        if (matcherA == null) {
            c(0L);
            return;
        }
        long jD2 = Z88.d((String) AbstractC20011rK.e(matcherA.group(1)));
        long jB = this.b.b(C5045Hq7.j((jF + jD2) - jD));
        InterfaceC4589Ft7 interfaceC4589Ft7C = c(jB - jD2);
        this.c.Q(this.e, this.f);
        interfaceC4589Ft7C.d(this.c, this.f);
        interfaceC4589Ft7C.b(jB, 1, this.f, 0, null);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.d = interfaceC10465bf2;
        interfaceC10465bf2.o(new InterfaceC22148uk6.b(-9223372036854775807L));
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.c(this.e, 0, 6, false);
        this.c.Q(this.e, 6);
        if (Z88.b(this.c)) {
            return true;
        }
        interfaceC9845af2.c(this.e, 6, 3, false);
        this.c.Q(this.e, 9);
        return Z88.b(this.c);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        AbstractC20011rK.e(this.d);
        int length = (int) interfaceC9845af2.getLength();
        int i = this.f;
        byte[] bArr = this.e;
        if (i == bArr.length) {
            this.e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i2 = this.f;
        int i3 = interfaceC9845af2.read(bArr2, i2, bArr2.length - i2);
        if (i3 != -1) {
            int i4 = this.f + i3;
            this.f = i4;
            if (length == -1 || i4 != length) {
                return 0;
            }
        }
        f();
        return -1;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
