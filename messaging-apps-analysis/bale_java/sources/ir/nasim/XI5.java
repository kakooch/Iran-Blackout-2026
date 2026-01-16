package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class XI5 extends K6 {
    private C9528a7 f;
    private HL3 g;
    private ArrayList h = new ArrayList();

    public XI5(HL3 hl3) {
        this.g = hl3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 B(HL3 hl3) {
        return new XI5(hl3);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void C(ir.nasim.C20408rx5 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XI5.C(ir.nasim.rx5):void");
    }

    public static C9528a7 D(final HL3 hl3) {
        return C12736f7.n().f(hl3.c() + "/receiver", C4614Fw5.d(new V6() { // from class: ir.nasim.WI5
            @Override // ir.nasim.V6
            public final K6 create() {
                return XI5.B(hl3);
            }
        }));
    }

    @Override // ir.nasim.K6
    public void m(Object obj) throws Throwable {
        if (obj instanceof C20408rx5) {
            C((C20408rx5) obj);
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void n() {
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // ir.nasim.K6
    public void o() {
        this.f = C15680jz5.G(this.g);
    }
}
