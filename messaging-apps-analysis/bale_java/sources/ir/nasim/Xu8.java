package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Xu8 extends Vh8 {
    private final Au8 c;

    public Xu8(Au8 au8) {
        super("internal.logger");
        this.c = au8;
        this.b.put("log", new Ku8(this, false, true));
        this.b.put("silent", new Ot8(this, "silent"));
        ((Vh8) this.b.get("silent")).i("log", new Ku8(this, true, true));
        this.b.put("unmonitored", new C20973su8(this, "unmonitored"));
        ((Vh8) this.b.get("unmonitored")).i("log", new Ku8(this, false, false));
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        return InterfaceC22720vi8.r0;
    }
}
