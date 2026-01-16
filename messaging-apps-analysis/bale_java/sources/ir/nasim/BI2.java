package ir.nasim;

import ai.bale.proto.GiftpacketStruct$GiftReceiver;
import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17632nI2;
import ir.nasim.InterfaceC9566aA7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes5.dex */
public final class BI2 extends VW7 {
    private final int b;
    private final SettingsModule c;
    private final E84 d;
    private final UG7 e;
    private final OK7 f;
    private final Context g;
    private long h;
    private boolean i;
    private Long j;
    private int k;
    private long l;
    private int m;
    private long n;
    private int o;
    private ExPeerType p;
    private EnumC19802qy q;
    private boolean r;
    private boolean s;
    private boolean t;
    private final String u;
    private final InterfaceC3570Bk5 v;
    private final InterfaceC9336Zm4 w;
    private final InterfaceC10258bL6 x;
    private final InterfaceC9173Yu3 y;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return BI2.this.o1(this);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        int h;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BI2.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x01ec  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01f3  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x029c  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x029e  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x02a3  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02cb  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0300  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instructions count: 884
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BI2.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BI2.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = BI2.this.w;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, InterfaceC9566aA7.b.a));
                long jM = AbstractC17026mG5.a.m(500L, 1500L);
                this.b = 1;
                if (HG1.b(jM, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = BI2.this.w;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, new InterfaceC9566aA7.a(new AbstractC17632nI2.b(false))));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BI2.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0328  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01f4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01fb  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x02bb  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x02c0  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x02ea  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x02ec  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x02f1 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x02f9  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 946
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BI2.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public BI2(int i, SettingsModule settingsModule, C11461d28 c11461d28, E84 e84, UG7 ug7, OK7 ok7, Context context) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c11461d28, "walletModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(ug7, "updateModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(context, "context");
        this.b = i;
        this.c = settingsModule;
        this.d = e84;
        this.e = ug7;
        this.f = ok7;
        this.g = context;
        this.p = ExPeerType.CHANNEL;
        this.q = EnumC19802qy.SAME;
        this.u = (String) c11461d28.B().b();
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.c);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.v = interfaceC3570Bk5Q;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(InterfaceC9566aA7.b.a);
        this.w = interfaceC9336Zm4A;
        this.x = interfaceC9336Zm4A;
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.AI2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(BI2.w1(this.a));
            }
        });
    }

    private final int a1() {
        return this.v.getInt(this.m + Separators.SP + this.h, NewGiftPacketRecyclerResultBottomSheetContentView.b.a.ordinal());
    }

    private final InterfaceC13730gj3 p1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s1(List list, Integer num) {
        if (!list.isEmpty()) {
            if ((num != null && num.intValue() == 0) || this.q != EnumC19802qy.RANDOM) {
                if (((GiftpacketStruct$GiftReceiver) list.get(0)).getUserId() == AbstractC5969Lp4.f()) {
                    return true;
                }
            } else if (num != null && num.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    private final void u1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    private final void v1() {
        if (this.i) {
            p1();
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w1(BI2 bi2) {
        AbstractC13042fc3.i(bi2, "this$0");
        return NewGiftPacketRecyclerResultBottomSheetContentView.INSTANCE.a() - (Calendar.getInstance().getTime().getTime() - bi2.l);
    }

    private final void x1() {
        this.v.remove(this.m + Separators.SP + this.h);
    }

    private final void y1(int i) {
        this.v.putInt(this.m + Separators.SP + this.h, i);
    }

    public final ExPeerType b1() {
        return this.p;
    }

    public final EnumC19802qy c1() {
        return this.q;
    }

    public final Long d1() {
        return this.j;
    }

    public final boolean e1() {
        return this.s;
    }

    public final E84 f1() {
        return this.d;
    }

    public final int g1() {
        return this.k;
    }

    public final int h1() {
        return this.o;
    }

    public final long i1() {
        return ((Number) this.y.getValue()).longValue();
    }

    public final boolean j1() {
        return this.t;
    }

    public final long k1() {
        return this.n;
    }

    public final InterfaceC10258bL6 l1() {
        return this.x;
    }

    public final UG7 m1() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o1(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.BI2.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.BI2$a r0 = (ir.nasim.BI2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.BI2$a r0 = new ir.nasim.BI2$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L56
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.OK7 r8 = r7.f
            ir.nasim.VL3 r8 = r8.o0()
            int r2 = r7.k
            long r5 = (long) r2
            ir.nasim.Nv5 r8 = r8.k(r5)
            java.lang.String r2 = "get(...)"
            ir.nasim.AbstractC13042fc3.h(r8, r2)
            r0.c = r4
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r3, r0, r4, r3)
            if (r8 != r1) goto L56
            return r1
        L56:
            boolean r0 = ir.nasim.C9475a16.g(r8)
            if (r0 == 0) goto L5d
            goto L5e
        L5d:
            r3 = r8
        L5e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BI2.o1(ir.nasim.rm1):java.lang.Object");
    }

    public final void q1(long j, int i, int i2, long j2, ExPeerType exPeerType, boolean z, boolean z2, boolean z3, long j3, boolean z4, int i3, boolean z5, Long l) {
        AbstractC13042fc3.i(exPeerType, "expeerType");
        this.h = j;
        this.k = i2;
        this.l = j2;
        this.p = exPeerType;
        this.r = z;
        this.s = z2;
        this.m = i;
        if (z3) {
            this.q = EnumC19802qy.RANDOM;
        }
        this.n = j3;
        this.t = z4;
        this.o = i3;
        this.i = z5;
        this.j = l;
        if (System.currentTimeMillis() - j2 >= this.c.h2()) {
            v1();
            x1();
            return;
        }
        if (a1() != NewGiftPacketRecyclerResultBottomSheetContentView.b.a.ordinal()) {
            if (a1() == NewGiftPacketRecyclerResultBottomSheetContentView.b.b.ordinal()) {
                u1();
                return;
            } else {
                v1();
                return;
            }
        }
        if (z) {
            y1(NewGiftPacketRecyclerResultBottomSheetContentView.b.b.ordinal());
            u1();
        } else {
            v1();
            y1(NewGiftPacketRecyclerResultBottomSheetContentView.b.c.ordinal());
        }
    }

    public final boolean t1() {
        return this.i;
    }
}
