package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.i2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14506i2 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 d = new InterfaceC12462ef2() { // from class: ir.nasim.h2
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C14506i2.f();
        }
    };
    private final C15113j2 a = new C15113j2();
    private final EW4 b = new EW4(SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER);
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] f() {
        return new InterfaceC9262Ze2[]{new C14506i2()};
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.c = false;
        this.a.b();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.a.c(interfaceC10465bf2, new InterfaceC22268uw7.d(0, 1));
        interfaceC10465bf2.s();
        interfaceC10465bf2.o(new InterfaceC22148uk6.b(-9223372036854775807L));
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        EW4 ew4 = new EW4(10);
        int i = 0;
        while (true) {
            interfaceC9845af2.m(ew4.e(), 0, 10);
            ew4.S(0);
            if (ew4.I() != 4801587) {
                break;
            }
            ew4.T(3);
            int iE = ew4.E();
            i += iE + 10;
            interfaceC9845af2.h(iE);
        }
        interfaceC9845af2.e();
        interfaceC9845af2.h(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            interfaceC9845af2.m(ew4.e(), 0, 6);
            ew4.S(0);
            if (ew4.L() != 2935) {
                interfaceC9845af2.e();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                interfaceC9845af2.h(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iG = AbstractC15704k2.g(ew4.e());
                if (iG == -1) {
                    return false;
                }
                interfaceC9845af2.h(iG - 6);
            }
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        int i = interfaceC9845af2.read(this.b.e(), 0, SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER);
        if (i == -1) {
            return -1;
        }
        this.b.S(0);
        this.b.R(i);
        if (!this.c) {
            this.a.e(0L, 4);
            this.c = true;
        }
        this.a.a(this.b);
        return 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
