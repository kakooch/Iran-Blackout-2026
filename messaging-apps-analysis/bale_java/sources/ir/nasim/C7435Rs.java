package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Rs, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C7435Rs implements InterfaceC10970cW3 {
    private final C23417wt a;
    private boolean b;

    /* renamed from: ir.nasim.Rs$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list) {
            super(1);
            this.e = list;
        }

        public final void a(AbstractC21430te5.a aVar) {
            List list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AbstractC21430te5.a.h(aVar, (AbstractC21430te5) list.get(i), 0, 0, 0.0f, 4, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C7435Rs(C23417wt c23417wt) {
        this.a = c23417wt;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iZ = ((InterfaceC9236Zb3) list.get(0)).Z(i);
        int iO = AbstractC10360bX0.o(list);
        int i2 = 1;
        if (1 <= iO) {
            while (true) {
                int iZ2 = ((InterfaceC9236Zb3) list.get(i2)).Z(i);
                if (iZ2 > iZ) {
                    iZ = iZ2;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        }
        return iZ;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size; i++) {
            AbstractC21430te5 abstractC21430te5L0 = ((ZV3) list.get(i)).l0(j);
            iMax = Math.max(iMax, abstractC21430te5L0.P0());
            iMax2 = Math.max(iMax2, abstractC21430te5L0.A0());
            arrayList.add(abstractC21430te5L0);
        }
        if (interfaceC12377eW3.s0()) {
            this.b = true;
            this.a.a().setValue(C4414Fa3.b(C4414Fa3.c((4294967295L & iMax2) | (iMax << 32))));
        } else if (!this.b) {
            this.a.a().setValue(C4414Fa3.b(C4414Fa3.c((4294967295L & iMax2) | (iMax << 32))));
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMax, iMax2, null, new a(arrayList), 4, null);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iK0 = ((InterfaceC9236Zb3) list.get(0)).k0(i);
        int iO = AbstractC10360bX0.o(list);
        int i2 = 1;
        if (1 <= iO) {
            while (true) {
                int iK02 = ((InterfaceC9236Zb3) list.get(i2)).k0(i);
                if (iK02 > iK0) {
                    iK0 = iK02;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        }
        return iK0;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iI0 = ((InterfaceC9236Zb3) list.get(0)).i0(i);
        int iO = AbstractC10360bX0.o(list);
        int i2 = 1;
        if (1 <= iO) {
            while (true) {
                int iI02 = ((InterfaceC9236Zb3) list.get(i2)).i0(i);
                if (iI02 > iI0) {
                    iI0 = iI02;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        }
        return iI0;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iZ = ((InterfaceC9236Zb3) list.get(0)).z(i);
        int iO = AbstractC10360bX0.o(list);
        int i2 = 1;
        if (1 <= iO) {
            while (true) {
                int iZ2 = ((InterfaceC9236Zb3) list.get(i2)).z(i);
                if (iZ2 > iZ) {
                    iZ = iZ2;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        }
        return iZ;
    }
}
