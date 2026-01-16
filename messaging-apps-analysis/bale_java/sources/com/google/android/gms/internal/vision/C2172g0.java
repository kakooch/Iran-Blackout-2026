package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC16207ks8;
import ir.nasim.InterfaceC18561or8;
import ir.nasim.InterfaceC22210uq8;
import ir.nasim.Mq8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.vision.g0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2172g0 {
    private static final C2172g0 d = new C2172g0(true);
    final T0 a;
    private boolean b;
    private boolean c;

    private C2172g0() {
        this.a = T0.c(16);
    }

    static int a(EnumC16207ks8 enumC16207ks8, int i, Object obj) {
        int iC0 = zzii.c0(i);
        if (enumC16207ks8 == EnumC16207ks8.l) {
            AbstractC2184m0.g((InterfaceC18561or8) obj);
            iC0 <<= 1;
        }
        return iC0 + b(enumC16207ks8, obj);
    }

    private static int b(EnumC16207ks8 enumC16207ks8, Object obj) {
        switch (AbstractC2170f0.b[enumC16207ks8.ordinal()]) {
            case 1:
                return zzii.x(((Double) obj).doubleValue());
            case 2:
                return zzii.y(((Float) obj).floatValue());
            case 3:
                return zzii.Z(((Long) obj).longValue());
            case 4:
                return zzii.e0(((Long) obj).longValue());
            case 5:
                return zzii.g0(((Integer) obj).intValue());
            case 6:
                return zzii.n0(((Long) obj).longValue());
            case 7:
                return zzii.s0(((Integer) obj).intValue());
            case 8:
                return zzii.H(((Boolean) obj).booleanValue());
            case 9:
                return zzii.R((InterfaceC18561or8) obj);
            case 10:
                return zzii.F((InterfaceC18561or8) obj);
            case 11:
                return obj instanceof K ? zzii.E((K) obj) : zzii.G((String) obj);
            case 12:
                return obj instanceof K ? zzii.E((K) obj) : zzii.I((byte[]) obj);
            case 13:
                return zzii.k0(((Integer) obj).intValue());
            case 14:
                return zzii.v0(((Integer) obj).intValue());
            case 15:
                return zzii.r0(((Long) obj).longValue());
            case 16:
                return zzii.o0(((Integer) obj).intValue());
            case 17:
                return zzii.j0(((Long) obj).longValue());
            case 18:
                return obj instanceof Mq8 ? zzii.x0(((Mq8) obj).zza()) : zzii.x0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean e(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        throw null;
    }

    private final void g(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public static int h(InterfaceC22210uq8 interfaceC22210uq8, Object obj) {
        EnumC16207ks8 enumC16207ks8C = interfaceC22210uq8.c();
        int iZza = interfaceC22210uq8.zza();
        if (!interfaceC22210uq8.d()) {
            return a(enumC16207ks8C, iZza, obj);
        }
        int iA = 0;
        if (interfaceC22210uq8.g()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iA += b(enumC16207ks8C, it.next());
            }
            return zzii.c0(iZza) + iA + zzii.z0(iA);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iA += a(enumC16207ks8C, iZza, it2.next());
        }
        return iA;
    }

    private static int i(Map.Entry entry) {
        AbstractC18350oW3.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void k(ir.nasim.InterfaceC22210uq8 r3, java.lang.Object r4) {
        /*
            ir.nasim.ks8 r0 = r3.c()
            com.google.android.gms.internal.vision.AbstractC2184m0.d(r4)
            int[] r1 = com.google.android.gms.internal.vision.AbstractC2170f0.a
            ir.nasim.ns8 r0 = r0.a()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r1 = r2
            goto L42
        L1a:
            boolean r0 = r4 instanceof ir.nasim.InterfaceC18561or8
            if (r0 != 0) goto L42
            goto L18
        L1f:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof ir.nasim.Mq8
            if (r0 == 0) goto L18
            goto L42
        L28:
            boolean r0 = r4 instanceof com.google.android.gms.internal.vision.K
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L18
            goto L42
        L31:
            boolean r1 = r4 instanceof java.lang.String
            goto L42
        L34:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r1 = r4 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r1 = r4 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r1 = r4 instanceof java.lang.Long
            goto L42
        L40:
            boolean r1 = r4 instanceof java.lang.Integer
        L42:
            if (r1 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            ir.nasim.ks8 r3 = r3.c()
            ir.nasim.ns8 r3 = r3.a()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.C2172g0.k(ir.nasim.uq8, java.lang.Object):void");
    }

    public final void c(C2172g0 c2172g0) {
        for (int i = 0; i < c2172g0.a.k(); i++) {
            g(c2172g0.a.i(i));
        }
        Iterator it = c2172g0.a.o().iterator();
        while (it.hasNext()) {
            g((Map.Entry) it.next());
        }
    }

    public final /* synthetic */ Object clone() {
        C2172g0 c2172g0 = new C2172g0();
        for (int i = 0; i < this.a.k(); i++) {
            Map.Entry entryI = this.a.i(i);
            AbstractC18350oW3.a(entryI.getKey());
            c2172g0.d(null, entryI.getValue());
        }
        for (Map.Entry entry : this.a.o()) {
            AbstractC18350oW3.a(entry.getKey());
            c2172g0.d(null, entry.getValue());
        }
        c2172g0.c = this.c;
        return c2172g0;
    }

    public final void d(InterfaceC22210uq8 interfaceC22210uq8, Object obj) {
        if (!interfaceC22210uq8.d()) {
            k(interfaceC22210uq8, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                k(interfaceC22210uq8, obj2);
            }
            obj = arrayList;
        }
        this.a.put(interfaceC22210uq8, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2172g0) {
            return this.a.equals(((C2172g0) obj).a);
        }
        return false;
    }

    public final void f() {
        if (this.b) {
            return;
        }
        this.a.f();
        this.b = true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator j() {
        return this.c ? new C2186n0(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    final Iterator l() {
        return this.c ? new C2186n0(this.a.q().iterator()) : this.a.q().iterator();
    }

    public final boolean m() {
        for (int i = 0; i < this.a.k(); i++) {
            if (!e(this.a.i(i))) {
                return false;
            }
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            if (!e((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int n() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.k(); i2++) {
            i += i(this.a.i(i2));
        }
        Iterator it = this.a.o().iterator();
        while (it.hasNext()) {
            i += i((Map.Entry) it.next());
        }
        return i;
    }

    private C2172g0(boolean z) {
        this(T0.c(0));
        f();
    }

    private C2172g0(T0 t0) {
        this.a = t0;
        f();
    }
}
