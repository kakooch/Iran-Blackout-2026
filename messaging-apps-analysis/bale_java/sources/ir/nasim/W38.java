package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class W38 extends AbstractC14869id0 {
    private String a;
    private C19482qQ7 b;
    private C10410bZ6 c;
    private C8512Wh0 d;

    public W38(D18 d18) {
        this.a = d18.w();
        this.b = new C19482qQ7("wallet." + d18.w() + ".balances", new ArrayList(d18.u()));
        this.c = new C10410bZ6("wallet." + d18.w() + ".link", d18.y());
        this.d = new C8512Wh0("wallet." + d18.w() + ".isActive", d18.r());
    }

    public static InterfaceC20073rQ7 c() {
        return new InterfaceC20073rQ7() { // from class: ir.nasim.V38
            @Override // ir.nasim.InterfaceC20073rQ7
            public final AbstractC14869id0 a(Object obj) {
                return new W38((D18) obj);
            }
        };
    }

    public C19482qQ7 d() {
        return this.b;
    }

    public C10410bZ6 e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC14869id0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(D18 d18) {
        this.b.i(new ArrayList(d18.u()));
        this.c.i(d18.y());
    }
}
