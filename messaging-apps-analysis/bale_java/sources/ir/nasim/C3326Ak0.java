package ir.nasim;

import com.google.zxing.NotFoundException;

/* renamed from: ir.nasim.Ak0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3326Ak0 {
    private final C4705Gf0 a;
    private final C12092e16 b;
    private final C12092e16 c;
    private final C12092e16 d;
    private final C12092e16 e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    C3326Ak0(C4705Gf0 c4705Gf0, C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164) throws NotFoundException {
        boolean z = c12092e16 == null || c12092e162 == null;
        boolean z2 = c12092e163 == null || c12092e164 == null;
        if (z && z2) {
            throw NotFoundException.a();
        }
        if (z) {
            c12092e16 = new C12092e16(0.0f, c12092e163.d());
            c12092e162 = new C12092e16(0.0f, c12092e164.d());
        } else if (z2) {
            c12092e163 = new C12092e16(c4705Gf0.m() - 1, c12092e16.d());
            c12092e164 = new C12092e16(c4705Gf0.m() - 1, c12092e162.d());
        }
        this.a = c4705Gf0;
        this.b = c12092e16;
        this.c = c12092e162;
        this.d = c12092e163;
        this.e = c12092e164;
        this.f = (int) Math.min(c12092e16.c(), c12092e162.c());
        this.g = (int) Math.max(c12092e163.c(), c12092e164.c());
        this.h = (int) Math.min(c12092e16.d(), c12092e163.d());
        this.i = (int) Math.max(c12092e162.d(), c12092e164.d());
    }

    static C3326Ak0 j(C3326Ak0 c3326Ak0, C3326Ak0 c3326Ak02) {
        return c3326Ak0 == null ? c3326Ak02 : c3326Ak02 == null ? c3326Ak0 : new C3326Ak0(c3326Ak0.a, c3326Ak0.b, c3326Ak0.c, c3326Ak02.d, c3326Ak02.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    ir.nasim.C3326Ak0 a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            ir.nasim.e16 r0 = r12.b
            ir.nasim.e16 r1 = r12.c
            ir.nasim.e16 r2 = r12.d
            ir.nasim.e16 r3 = r12.e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            ir.nasim.e16 r13 = new ir.nasim.e16
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            ir.nasim.e16 r13 = r12.c
            goto L35
        L33:
            ir.nasim.e16 r13 = r12.e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            ir.nasim.Gf0 r14 = r12.a
            int r14 = r14.i()
            if (r0 < r14) goto L4b
            ir.nasim.Gf0 r14 = r12.a
            int r14 = r14.i()
            int r0 = r14 + (-1)
        L4b:
            ir.nasim.e16 r14 = new ir.nasim.e16
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            ir.nasim.Ak0 r13 = new ir.nasim.Ak0
            ir.nasim.Gf0 r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3326Ak0.a(int, int, boolean):ir.nasim.Ak0");
    }

    C12092e16 b() {
        return this.c;
    }

    C12092e16 c() {
        return this.e;
    }

    int d() {
        return this.g;
    }

    int e() {
        return this.i;
    }

    int f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    C12092e16 h() {
        return this.b;
    }

    C12092e16 i() {
        return this.d;
    }

    C3326Ak0(C3326Ak0 c3326Ak0) {
        this.a = c3326Ak0.a;
        this.b = c3326Ak0.h();
        this.c = c3326Ak0.b();
        this.d = c3326Ak0.i();
        this.e = c3326Ak0.c();
        this.f = c3326Ak0.f();
        this.g = c3326Ak0.d();
        this.h = c3326Ak0.g();
        this.i = c3326Ak0.e();
    }
}
