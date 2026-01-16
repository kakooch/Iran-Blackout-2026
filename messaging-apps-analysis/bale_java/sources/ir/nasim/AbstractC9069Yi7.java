package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.Yi7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9069Yi7 {
    private static final float a = C17784nZ1.q(90);
    private static final InterfaceC5766Kt b = AbstractC5999Lt.l(Type.TSIG, 0, T22.d(), 2, null);

    /* renamed from: ir.nasim.Yi7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(3);
            this.e = i;
        }

        public final void a(List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-553782708, i, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:141)");
            }
            C8294Vi7 c8294Vi7 = C8294Vi7.a;
            c8294Vi7.b(c8294Vi7.c(androidx.compose.ui.e.a, (C8060Ui7) list.get(this.e)), 0.0f, 0L, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((List) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yi7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ InterfaceC15796kB2 g;

        /* renamed from: ir.nasim.Yi7$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 e;
            final /* synthetic */ InterfaceC14603iB2 f;
            final /* synthetic */ InterfaceC15796kB2 g;

            /* renamed from: ir.nasim.Yi7$b$a$a, reason: collision with other inner class name */
            static final class C0795a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ List e;
                final /* synthetic */ UZ6 f;
                final /* synthetic */ InterfaceC14603iB2 g;
                final /* synthetic */ int h;
                final /* synthetic */ long i;
                final /* synthetic */ int j;
                final /* synthetic */ InterfaceC15796kB2 k;
                final /* synthetic */ List l;
                final /* synthetic */ int m;

                /* renamed from: ir.nasim.Yi7$b$a$a$a, reason: collision with other inner class name */
                static final class C0796a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
                    final /* synthetic */ InterfaceC15796kB2 e;
                    final /* synthetic */ List f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0796a(InterfaceC15796kB2 interfaceC15796kB2, List list) {
                        super(2);
                        this.e = interfaceC15796kB2;
                        this.f = list;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.Q(-641946361, i, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:176)");
                        }
                        this.e.q(this.f, interfaceC22053ub1, 0);
                        if (AbstractC5138Ib1.I()) {
                            AbstractC5138Ib1.P();
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0795a(List list, UZ6 uz6, InterfaceC14603iB2 interfaceC14603iB2, int i, long j, int i2, InterfaceC15796kB2 interfaceC15796kB2, List list2, int i3) {
                    super(1);
                    this.e = list;
                    this.f = uz6;
                    this.g = interfaceC14603iB2;
                    this.h = i;
                    this.i = j;
                    this.j = i2;
                    this.k = interfaceC15796kB2;
                    this.l = list2;
                    this.m = i3;
                }

                public final void a(AbstractC21430te5.a aVar) {
                    List list = this.e;
                    int i = this.h;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AbstractC21430te5.a.l(aVar, (AbstractC21430te5) list.get(i2), i2 * i, 0, 0.0f, 4, null);
                    }
                    List listL0 = this.f.L0(EnumC10510bj7.b, this.g);
                    long j = this.i;
                    int i3 = this.j;
                    int size2 = listL0.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbstractC21430te5 abstractC21430te5L0 = ((ZV3) listL0.get(i4)).l0(C17833ne1.d(j, 0, 0, 0, 0, 11, null));
                        AbstractC21430te5.a.l(aVar, abstractC21430te5L0, 0, i3 - abstractC21430te5L0.A0(), 0.0f, 4, null);
                    }
                    List listL02 = this.f.L0(EnumC10510bj7.c, AbstractC19242q11.c(-641946361, true, new C0796a(this.k, this.l)));
                    int i5 = this.m;
                    int i6 = this.j;
                    int size3 = listL02.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        AbstractC21430te5.a.l(aVar, ((ZV3) listL02.get(i7)).l0(C17833ne1.b.c(i5, i6)), 0, 0, 0.0f, 4, null);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((AbstractC21430te5.a) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2) {
                super(2);
                this.e = interfaceC14603iB2;
                this.f = interfaceC14603iB22;
                this.g = interfaceC15796kB2;
            }

            public final InterfaceC11734dW3 a(UZ6 uz6, long j) {
                Object obj;
                int iL = C17833ne1.l(j);
                List listL0 = uz6.L0(EnumC10510bj7.a, this.e);
                int size = listL0.size();
                int i = iL / size;
                ArrayList arrayList = new ArrayList(listL0.size());
                int size2 = listL0.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size2) {
                    arrayList.add(((ZV3) listL0.get(i3)).l0(C17833ne1.d(j, i, i, 0, 0, 12, null)));
                    i3++;
                    i2 = i2;
                    listL0 = listL0;
                }
                int i4 = i2;
                if (arrayList.isEmpty()) {
                    obj = null;
                } else {
                    obj = arrayList.get(i4);
                    int iA0 = ((AbstractC21430te5) obj).A0();
                    int iO = AbstractC10360bX0.o(arrayList);
                    int i5 = 1;
                    if (1 <= iO) {
                        while (true) {
                            Object obj2 = arrayList.get(i5);
                            int iA02 = ((AbstractC21430te5) obj2).A0();
                            if (iA0 < iA02) {
                                obj = obj2;
                                iA0 = iA02;
                            }
                            if (i5 == iO) {
                                break;
                            }
                            i5++;
                        }
                    }
                }
                AbstractC21430te5 abstractC21430te5 = (AbstractC21430te5) obj;
                int iA03 = abstractC21430te5 != null ? abstractC21430te5.A0() : i4;
                ArrayList arrayList2 = new ArrayList(size);
                while (i4 < size) {
                    arrayList2.add(new C8060Ui7(C17784nZ1.q(uz6.D(i) * i4), uz6.D(i), null));
                    i4++;
                }
                return InterfaceC12377eW3.Q1(uz6, iL, iA03, null, new C0795a(arrayList, uz6, this.f, i, j, iA03, this.g, arrayList2, iL), 4, null);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((UZ6) obj, ((C17833ne1) obj2).r());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = interfaceC14603iB22;
            this.g = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1961746365, i, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:151)");
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(this.g);
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            InterfaceC14603iB2 interfaceC14603iB22 = this.f;
            InterfaceC15796kB2 interfaceC15796kB2 = this.g;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC14603iB2, interfaceC14603iB22, interfaceC15796kB2);
                interfaceC22053ub1.s(objB);
            }
            SZ6.a(eVarH, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yi7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ InterfaceC15796kB2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, androidx.compose.ui.e eVar, long j, long j2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, int i2, int i3) {
            super(2);
            this.e = i;
            this.f = eVar;
            this.g = j;
            this.h = j2;
            this.i = interfaceC15796kB2;
            this.j = interfaceC14603iB2;
            this.k = interfaceC14603iB22;
            this.l = i2;
            this.m = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC9069Yi7.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(int r25, androidx.compose.ui.e r26, long r27, long r29, ir.nasim.InterfaceC15796kB2 r31, ir.nasim.InterfaceC14603iB2 r32, ir.nasim.InterfaceC14603iB2 r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9069Yi7.a(int, androidx.compose.ui.e, long, long, ir.nasim.kB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }
}
