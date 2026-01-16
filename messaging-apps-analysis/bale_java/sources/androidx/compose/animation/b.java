package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC18386oa3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C24411ya3;
import ir.nasim.C4414Fa3;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.UA2;
import ir.nasim.ZV3;
import java.util.List;

/* loaded from: classes.dex */
final class b implements InterfaceC10970cW3 {
    private final AnimatedContentTransitionScopeImpl a;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5[] e;
        final /* synthetic */ b f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5[] abstractC21430te5Arr, b bVar, int i, int i2) {
            super(1);
            this.e = abstractC21430te5Arr;
            this.f = bVar;
            this.g = i;
            this.h = i2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5[] abstractC21430te5Arr;
            AbstractC21430te5[] abstractC21430te5Arr2 = this.e;
            b bVar = this.f;
            int i = this.g;
            int i2 = this.h;
            int length = abstractC21430te5Arr2.length;
            int i3 = 0;
            while (i3 < length) {
                AbstractC21430te5 abstractC21430te5 = abstractC21430te5Arr2[i3];
                if (abstractC21430te5 != null) {
                    abstractC21430te5Arr = abstractC21430te5Arr2;
                    long jA = bVar.c().g().a(C4414Fa3.c((abstractC21430te5.P0() << 32) | (abstractC21430te5.A0() & 4294967295L)), C4414Fa3.c((i2 & 4294967295L) | (i << 32)), EnumC12613eu3.a);
                    AbstractC21430te5.a.h(aVar, abstractC21430te5, C22045ua3.k(jA), C22045ua3.l(jA), 0.0f, 4, null);
                } else {
                    abstractC21430te5Arr = abstractC21430te5Arr2;
                }
                i3++;
                abstractC21430te5Arr2 = abstractC21430te5Arr;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public b(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.a = animatedContentTransitionScopeImpl;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((InterfaceC9236Zb3) list.get(0)).Z(i));
            int iO = AbstractC10360bX0.o(list);
            int i2 = 1;
            if (1 <= iO) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((InterfaceC9236Zb3) list.get(i2)).Z(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == iO) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        AbstractC21430te5 abstractC21430te5;
        AbstractC21430te5 abstractC21430te52;
        int iP0;
        int i;
        int iA0;
        int i2;
        boolean z = true;
        int size = list.size();
        AbstractC21430te5[] abstractC21430te5Arr = new AbstractC21430te5[size];
        long jA = C4414Fa3.b.a();
        List list2 = list;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            abstractC21430te5 = null;
            if (i3 >= size2) {
                break;
            }
            ZV3 zv3 = (ZV3) list.get(i3);
            Object objH = zv3.h();
            AnimatedContentTransitionScopeImpl.a aVar = objH instanceof AnimatedContentTransitionScopeImpl.a ? (AnimatedContentTransitionScopeImpl.a) objH : null;
            if (aVar == null || aVar.f() != z) {
                i2 = size;
            } else {
                AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
                i2 = size;
                long jC = C4414Fa3.c((abstractC21430te5L0.A0() & 4294967295L) | (abstractC21430te5L0.P0() << 32));
                C19938rB7 c19938rB7 = C19938rB7.a;
                abstractC21430te5Arr[i3] = abstractC21430te5L0;
                jA = jC;
            }
            z = true;
            i3++;
            size = i2;
        }
        int i4 = size;
        int size3 = list2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            ZV3 zv32 = (ZV3) list.get(i5);
            if (abstractC21430te5Arr[i5] == null) {
                abstractC21430te5Arr[i5] = zv32.l0(j);
            }
        }
        if (interfaceC12377eW3.s0()) {
            iP0 = (int) (jA >> 32);
        } else {
            if (i4 == 0) {
                abstractC21430te52 = null;
            } else {
                abstractC21430te52 = abstractC21430te5Arr[0];
                int iL0 = AbstractC10242bK.l0(abstractC21430te5Arr);
                if (iL0 != 0) {
                    int iP02 = abstractC21430te52 != null ? abstractC21430te52.P0() : 0;
                    AbstractC18386oa3 it = new C24411ya3(1, iL0).iterator();
                    while (it.hasNext()) {
                        AbstractC21430te5 abstractC21430te53 = abstractC21430te5Arr[it.b()];
                        int iP03 = abstractC21430te53 != null ? abstractC21430te53.P0() : 0;
                        if (iP02 < iP03) {
                            abstractC21430te52 = abstractC21430te53;
                            iP02 = iP03;
                        }
                    }
                }
            }
            iP0 = abstractC21430te52 != null ? abstractC21430te52.P0() : 0;
        }
        if (interfaceC12377eW3.s0()) {
            iA0 = (int) (jA & 4294967295L);
        } else {
            if (i4 == 0) {
                i = 0;
            } else {
                i = 0;
                abstractC21430te5 = abstractC21430te5Arr[0];
                int iL02 = AbstractC10242bK.l0(abstractC21430te5Arr);
                if (iL02 != 0) {
                    int iA02 = abstractC21430te5 != null ? abstractC21430te5.A0() : 0;
                    AbstractC18386oa3 it2 = new C24411ya3(1, iL02).iterator();
                    while (it2.hasNext()) {
                        AbstractC21430te5 abstractC21430te54 = abstractC21430te5Arr[it2.b()];
                        int iA03 = abstractC21430te54 != null ? abstractC21430te54.A0() : 0;
                        if (iA02 < iA03) {
                            abstractC21430te5 = abstractC21430te54;
                            iA02 = iA03;
                        }
                    }
                }
            }
            iA0 = abstractC21430te5 != null ? abstractC21430te5.A0() : i;
        }
        if (!interfaceC12377eW3.s0()) {
            this.a.l(C4414Fa3.c((iP0 << 32) | (iA0 & 4294967295L)));
        }
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iP0, iA0, null, new a(abstractC21430te5Arr, this, iP0, iA0), 4, null);
    }

    public final AnimatedContentTransitionScopeImpl c() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((InterfaceC9236Zb3) list.get(0)).k0(i));
            int iO = AbstractC10360bX0.o(list);
            int i2 = 1;
            if (1 <= iO) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((InterfaceC9236Zb3) list.get(i2)).k0(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == iO) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((InterfaceC9236Zb3) list.get(0)).i0(i));
            int iO = AbstractC10360bX0.o(list);
            int i2 = 1;
            if (1 <= iO) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((InterfaceC9236Zb3) list.get(i2)).i0(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == iO) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((InterfaceC9236Zb3) list.get(0)).z(i));
            int iO = AbstractC10360bX0.o(list);
            int i2 = 1;
            if (1 <= iO) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((InterfaceC9236Zb3) list.get(i2)).z(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == iO) {
                        break;
                    }
                    i2++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
