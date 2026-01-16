package com.google.protobuf;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.protobuf.AbstractC2381e;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.B;
import com.google.protobuf.I;
import com.google.protobuf.r0;
import com.google.protobuf.s0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.EnumC4986Hk2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.WKSRecord;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class S implements e0 {
    private static final int[] r = new int[0];
    private static final Unsafe s = o0.H();
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final P e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final U m;
    private final F n;
    private final l0 o;
    private final AbstractC2395t p;
    private final K q;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.q.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.r.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.p.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.g.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.e.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r0.b.f.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r0.b.m.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r0.b.s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r0.b.t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r0.b.k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private S(int[] iArr, Object[] objArr, int i, int i2, P p, boolean z, boolean z2, int[] iArr2, int i3, int i4, U u, F f, l0 l0Var, AbstractC2395t abstractC2395t, K k) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = p instanceof GeneratedMessageLite;
        this.h = z;
        this.f = abstractC2395t != null && abstractC2395t.e(p);
        this.i = z2;
        this.j = iArr2;
        this.k = i3;
        this.l = i4;
        this.m = u;
        this.n = f;
        this.o = l0Var;
        this.p = abstractC2395t;
        this.e = p;
        this.q = k;
    }

    private int A(l0 l0Var, Object obj) {
        return l0Var.h(l0Var.g(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0(java.lang.Object r13, com.google.protobuf.s0 r14) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.A0(java.lang.Object, com.google.protobuf.s0):void");
    }

    private static int B(Object obj, long j) {
        return o0.C(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void B0(java.lang.Object r11, com.google.protobuf.s0 r12) {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.B0(java.lang.Object, com.google.protobuf.s0):void");
    }

    private static boolean C(int i) {
        return (i & 536870912) != 0;
    }

    private void C0(s0 s0Var, int i, Object obj, int i2) {
        if (obj != null) {
            s0Var.O(i, this.q.b(v(i2)), this.q.e(obj));
        }
    }

    private boolean D(Object obj, int i) {
        int iM0 = m0(i);
        long j = 1048575 & iM0;
        if (j != 1048575) {
            return (o0.C(obj, j) & (1 << (iM0 >>> 20))) != 0;
        }
        int iY0 = y0(i);
        long jZ = Z(iY0);
        switch (x0(iY0)) {
            case 0:
                return Double.doubleToRawLongBits(o0.A(obj, jZ)) != 0;
            case 1:
                return Float.floatToRawIntBits(o0.B(obj, jZ)) != 0;
            case 2:
                return o0.E(obj, jZ) != 0;
            case 3:
                return o0.E(obj, jZ) != 0;
            case 4:
                return o0.C(obj, jZ) != 0;
            case 5:
                return o0.E(obj, jZ) != 0;
            case 6:
                return o0.C(obj, jZ) != 0;
            case 7:
                return o0.t(obj, jZ);
            case 8:
                Object objG = o0.G(obj, jZ);
                if (objG instanceof String) {
                    return !((String) objG).isEmpty();
                }
                if (objG instanceof AbstractC2383g) {
                    return !AbstractC2383g.b.equals(objG);
                }
                throw new IllegalArgumentException();
            case 9:
                return o0.G(obj, jZ) != null;
            case 10:
                return !AbstractC2383g.b.equals(o0.G(obj, jZ));
            case 11:
                return o0.C(obj, jZ) != 0;
            case 12:
                return o0.C(obj, jZ) != 0;
            case 13:
                return o0.C(obj, jZ) != 0;
            case 14:
                return o0.E(obj, jZ) != 0;
            case 15:
                return o0.C(obj, jZ) != 0;
            case 16:
                return o0.E(obj, jZ) != 0;
            case 17:
                return o0.G(obj, jZ) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void D0(int i, Object obj, s0 s0Var) {
        if (obj instanceof String) {
            s0Var.e(i, (String) obj);
        } else {
            s0Var.L(i, (AbstractC2383g) obj);
        }
    }

    private boolean E(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? D(obj, i) : (i3 & i4) != 0;
    }

    private void E0(l0 l0Var, Object obj, s0 s0Var) {
        l0Var.t(l0Var.g(obj), s0Var);
    }

    private static boolean F(Object obj, int i, e0 e0Var) {
        return e0Var.f(o0.G(obj, Z(i)));
    }

    private boolean G(Object obj, int i, int i2) {
        List list = (List) o0.G(obj, Z(i));
        if (list.isEmpty()) {
            return true;
        }
        e0 e0VarW = w(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!e0VarW.f(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private boolean H(Object obj, int i, int i2) {
        Map mapE = this.q.e(o0.G(obj, Z(i)));
        if (mapE.isEmpty()) {
            return true;
        }
        if (this.q.b(v(i2)).c.a() != r0.c.MESSAGE) {
            return true;
        }
        e0 e0VarC = null;
        for (Object obj2 : mapE.values()) {
            if (e0VarC == null) {
                e0VarC = a0.a().c(obj2.getClass());
            }
            if (!e0VarC.f(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean I(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean J(Object obj, Object obj2, int i) {
        long jM0 = m0(i) & 1048575;
        return o0.C(obj, jM0) == o0.C(obj2, jM0);
    }

    private boolean K(Object obj, int i, int i2) {
        return o0.C(obj, (long) (m0(i2) & 1048575)) == i;
    }

    private static boolean L(int i) {
        return (i & 268435456) != 0;
    }

    private static List M(Object obj, long j) {
        return (List) o0.G(obj, j);
    }

    private static long N(Object obj, long j) {
        return o0.E(obj, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:244:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        r0 = r18.k;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        if (r0 >= r18.l) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r4 = r(r21, r18.j[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        if (r4 == null) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
    
        r7.o(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x064f A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #6 {all -> 0x0675, blocks: (B:170:0x0649, B:172:0x064f, B:184:0x0679, B:185:0x067e), top: B:214:0x0649 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06b5 A[LOOP:4: B:198:0x06b1->B:200:0x06b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O(com.google.protobuf.l0 r19, com.google.protobuf.AbstractC2395t r20, java.lang.Object r21, com.google.protobuf.d0 r22, com.google.protobuf.C2394s r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.O(com.google.protobuf.l0, com.google.protobuf.t, java.lang.Object, com.google.protobuf.d0, com.google.protobuf.s):void");
    }

    private final void P(Object obj, int i, Object obj2, C2394s c2394s, d0 d0Var) {
        long jZ = Z(y0(i));
        Object objG = o0.G(obj, jZ);
        if (objG == null) {
            objG = this.q.d(obj2);
            o0.V(obj, jZ, objG);
        } else if (this.q.h(objG)) {
            Object objD = this.q.d(obj2);
            this.q.a(objD, objG);
            o0.V(obj, jZ, objD);
            objG = objD;
        }
        d0Var.L(this.q.c(objG), this.q.b(obj2), c2394s);
    }

    private void Q(Object obj, Object obj2, int i) {
        if (D(obj2, i)) {
            long jZ = Z(y0(i));
            Unsafe unsafe = s;
            Object object = unsafe.getObject(obj2, jZ);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Y(i) + " is present but null: " + obj2);
            }
            e0 e0VarW = w(i);
            if (!D(obj, i)) {
                if (I(object)) {
                    Object objD = e0VarW.d();
                    e0VarW.a(objD, object);
                    unsafe.putObject(obj, jZ, objD);
                } else {
                    unsafe.putObject(obj, jZ, object);
                }
                s0(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZ);
            if (!I(object2)) {
                Object objD2 = e0VarW.d();
                e0VarW.a(objD2, object2);
                unsafe.putObject(obj, jZ, objD2);
                object2 = objD2;
            }
            e0VarW.a(object2, object);
        }
    }

    private void R(Object obj, Object obj2, int i) {
        int iY = Y(i);
        if (K(obj2, iY, i)) {
            long jZ = Z(y0(i));
            Unsafe unsafe = s;
            Object object = unsafe.getObject(obj2, jZ);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Y(i) + " is present but null: " + obj2);
            }
            e0 e0VarW = w(i);
            if (!K(obj, iY, i)) {
                if (I(object)) {
                    Object objD = e0VarW.d();
                    e0VarW.a(objD, object);
                    unsafe.putObject(obj, jZ, objD);
                } else {
                    unsafe.putObject(obj, jZ, object);
                }
                t0(obj, iY, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jZ);
            if (!I(object2)) {
                Object objD2 = e0VarW.d();
                e0VarW.a(objD2, object2);
                unsafe.putObject(obj, jZ, objD2);
                object2 = objD2;
            }
            e0VarW.a(object2, object);
        }
    }

    private void S(Object obj, Object obj2, int i) {
        int iY0 = y0(i);
        long jZ = Z(iY0);
        int iY = Y(i);
        switch (x0(iY0)) {
            case 0:
                if (D(obj2, i)) {
                    o0.R(obj, jZ, o0.A(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 1:
                if (D(obj2, i)) {
                    o0.S(obj, jZ, o0.B(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 2:
                if (D(obj2, i)) {
                    o0.U(obj, jZ, o0.E(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 3:
                if (D(obj2, i)) {
                    o0.U(obj, jZ, o0.E(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 4:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 5:
                if (D(obj2, i)) {
                    o0.U(obj, jZ, o0.E(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 6:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 7:
                if (D(obj2, i)) {
                    o0.L(obj, jZ, o0.t(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 8:
                if (D(obj2, i)) {
                    o0.V(obj, jZ, o0.G(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 9:
                Q(obj, obj2, i);
                break;
            case 10:
                if (D(obj2, i)) {
                    o0.V(obj, jZ, o0.G(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 11:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 12:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 13:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 14:
                if (D(obj2, i)) {
                    o0.U(obj, jZ, o0.E(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 15:
                if (D(obj2, i)) {
                    o0.T(obj, jZ, o0.C(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 16:
                if (D(obj2, i)) {
                    o0.U(obj, jZ, o0.E(obj2, jZ));
                    s0(obj, i);
                    break;
                }
                break;
            case 17:
                Q(obj, obj2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.n.d(obj, obj2, jZ);
                break;
            case 50:
                g0.F(this.q, obj, obj2, jZ);
                break;
            case 51:
            case org.xbill.DNS.Type.TLSA /* 52 */:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case org.xbill.DNS.Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
                if (K(obj2, iY, i)) {
                    o0.V(obj, jZ, o0.G(obj2, jZ));
                    t0(obj, iY, i);
                    break;
                }
                break;
            case 60:
                R(obj, obj2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case WKSRecord.Protocol.RVD /* 66 */:
            case 67:
                if (K(obj2, iY, i)) {
                    o0.V(obj, jZ, o0.G(obj2, jZ));
                    t0(obj, iY, i);
                    break;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                R(obj, obj2, i);
                break;
        }
    }

    private Object T(Object obj, int i) {
        e0 e0VarW = w(i);
        long jZ = Z(y0(i));
        if (!D(obj, i)) {
            return e0VarW.d();
        }
        Object object = s.getObject(obj, jZ);
        if (I(object)) {
            return object;
        }
        Object objD = e0VarW.d();
        if (object != null) {
            e0VarW.a(objD, object);
        }
        return objD;
    }

    private Object U(Object obj, int i, int i2) {
        e0 e0VarW = w(i2);
        if (!K(obj, i, i2)) {
            return e0VarW.d();
        }
        Object object = s.getObject(obj, Z(y0(i2)));
        if (I(object)) {
            return object;
        }
        Object objD = e0VarW.d();
        if (object != null) {
            e0VarW.a(objD, object);
        }
        return objD;
    }

    static S V(Class cls, N n, U u, F f, l0 l0Var, AbstractC2395t abstractC2395t, K k) {
        if (n instanceof c0) {
            return X((c0) n, u, f, l0Var, abstractC2395t, k);
        }
        AbstractC18350oW3.a(n);
        return W(null, u, f, l0Var, abstractC2395t, k);
    }

    static S W(i0 i0Var, U u, F f, l0 l0Var, AbstractC2395t abstractC2395t, K k) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.protobuf.S X(com.google.protobuf.c0 r33, com.google.protobuf.U r34, com.google.protobuf.F r35, com.google.protobuf.l0 r36, com.google.protobuf.AbstractC2395t r37, com.google.protobuf.K r38) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.X(com.google.protobuf.c0, com.google.protobuf.U, com.google.protobuf.F, com.google.protobuf.l0, com.google.protobuf.t, com.google.protobuf.K):com.google.protobuf.S");
    }

    private int Y(int i) {
        return this.a[i];
    }

    private static long Z(int i) {
        return i & 1048575;
    }

    private static boolean a0(Object obj, long j) {
        return ((Boolean) o0.G(obj, j)).booleanValue();
    }

    private static double b0(Object obj, long j) {
        return ((Double) o0.G(obj, j)).doubleValue();
    }

    private static float c0(Object obj, long j) {
        return ((Float) o0.G(obj, j)).floatValue();
    }

    private static int d0(Object obj, long j) {
        return ((Integer) o0.G(obj, j)).intValue();
    }

    private static long e0(Object obj, long j) {
        return ((Long) o0.G(obj, j)).longValue();
    }

    private int f0(Object obj, byte[] bArr, int i, int i2, int i3, long j, AbstractC2381e.b bVar) {
        Unsafe unsafe = s;
        Object objV = v(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.q.h(object)) {
            Object objD = this.q.d(objV);
            this.q.a(objD, object);
            unsafe.putObject(obj, j, objD);
            object = objD;
        }
        return n(bArr, i, i2, this.q.b(objV), this.q.c(object), bVar);
    }

    private int g0(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, AbstractC2381e.b bVar) throws InvalidProtocolBufferException {
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(AbstractC2381e.d(bArr, i)));
                    int i9 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i9;
                }
                break;
            case org.xbill.DNS.Type.TLSA /* 52 */:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(AbstractC2381e.l(bArr, i)));
                    int i10 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                if (i5 == 0) {
                    int iL = AbstractC2381e.L(bArr, i, bVar);
                    unsafe.putObject(obj, j, Long.valueOf(bVar.b));
                    unsafe.putInt(obj, j2, i4);
                    return iL;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int I = AbstractC2381e.I(bArr, i, bVar);
                    unsafe.putObject(obj, j, Integer.valueOf(bVar.a));
                    unsafe.putInt(obj, j2, i4);
                    return I;
                }
                break;
            case org.xbill.DNS.Type.NINFO /* 56 */:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(AbstractC2381e.j(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(AbstractC2381e.h(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iL2 = AbstractC2381e.L(bArr, i, bVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(bVar.b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return iL2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int I2 = AbstractC2381e.I(bArr, i, bVar);
                    int i13 = bVar.a;
                    if (i13 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !p0.t(bArr, I2, I2 + i13)) {
                            throw InvalidProtocolBufferException.d();
                        }
                        unsafe.putObject(obj, j, new String(bArr, I2, i13, B.b));
                        I2 += i13;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return I2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object objU = U(obj, i4, i8);
                    int iO = AbstractC2381e.O(objU, w(i8), bArr, i, i2, bVar);
                    w0(obj, i4, i8, objU);
                    return iO;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iB = AbstractC2381e.b(bArr, i, bVar);
                    unsafe.putObject(obj, j, bVar.c);
                    unsafe.putInt(obj, j2, i4);
                    return iB;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int I3 = AbstractC2381e.I(bArr, i, bVar);
                    int i14 = bVar.a;
                    B.e eVarU = u(i8);
                    if (eVarU == null || eVarU.a(i14)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i14));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        x(obj).r(i3, Long.valueOf(i14));
                    }
                    return I3;
                }
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                if (i5 == 0) {
                    int I4 = AbstractC2381e.I(bArr, i, bVar);
                    unsafe.putObject(obj, j, Integer.valueOf(AbstractC2384h.c(bVar.a)));
                    unsafe.putInt(obj, j2, i4);
                    return I4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iL3 = AbstractC2381e.L(bArr, i, bVar);
                    unsafe.putObject(obj, j, Long.valueOf(AbstractC2384h.d(bVar.b)));
                    unsafe.putInt(obj, j2, i4);
                    return iL3;
                }
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (i5 == 3) {
                    Object objU2 = U(obj, i4, i8);
                    int iN = AbstractC2381e.N(objU2, w(i8), bArr, i, i2, (i3 & (-8)) | 4, bVar);
                    w0(obj, i4, i8, objU2);
                    return iN;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b2, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02e8, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0307, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0298, code lost:
    
        if (r0 != r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029a, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r8 = r19;
        r7 = r22;
        r6 = r26;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0089. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i0(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.protobuf.AbstractC2381e.b r34) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.i0(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):int");
    }

    private int j0(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, AbstractC2381e.b bVar) throws InvalidProtocolBufferException {
        int iJ;
        Unsafe unsafe = s;
        B.j jVarB = (B.j) unsafe.getObject(obj, j2);
        if (!jVarB.u()) {
            int size = jVarB.size();
            jVarB = jVarB.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j2, jVarB);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return AbstractC2381e.s(bArr, i, jVarB, bVar);
                }
                if (i5 == 1) {
                    return AbstractC2381e.e(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return AbstractC2381e.v(bArr, i, jVarB, bVar);
                }
                if (i5 == 5) {
                    return AbstractC2381e.m(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return AbstractC2381e.z(bArr, i, jVarB, bVar);
                }
                if (i5 == 0) {
                    return AbstractC2381e.M(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return AbstractC2381e.y(bArr, i, jVarB, bVar);
                }
                if (i5 == 0) {
                    return AbstractC2381e.J(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return AbstractC2381e.u(bArr, i, jVarB, bVar);
                }
                if (i5 == 1) {
                    return AbstractC2381e.k(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return AbstractC2381e.t(bArr, i, jVarB, bVar);
                }
                if (i5 == 5) {
                    return AbstractC2381e.i(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return AbstractC2381e.r(bArr, i, jVarB, bVar);
                }
                if (i5 == 0) {
                    return AbstractC2381e.a(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? AbstractC2381e.D(i3, bArr, i, i2, jVarB, bVar) : AbstractC2381e.E(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return AbstractC2381e.q(w(i6), i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return AbstractC2381e.c(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iJ = AbstractC2381e.y(bArr, i, jVarB, bVar);
                } else if (i5 == 0) {
                    iJ = AbstractC2381e.J(i3, bArr, i, i2, jVarB, bVar);
                }
                g0.A(obj, i4, jVarB, u(i6), null, this.o);
                return iJ;
            case 33:
            case 47:
                if (i5 == 2) {
                    return AbstractC2381e.w(bArr, i, jVarB, bVar);
                }
                if (i5 == 0) {
                    return AbstractC2381e.A(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return AbstractC2381e.x(bArr, i, jVarB, bVar);
                }
                if (i5 == 0) {
                    return AbstractC2381e.B(i3, bArr, i, i2, jVarB, bVar);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return AbstractC2381e.o(w(i6), i3, bArr, i, i2, jVarB, bVar);
                }
                break;
        }
        return i;
    }

    private boolean k(Object obj, Object obj2, int i) {
        return D(obj, i) == D(obj2, i);
    }

    private int k0(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return u0(i, 0);
    }

    private static boolean l(Object obj, long j) {
        return o0.t(obj, j);
    }

    private int l0(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return u0(i, i2);
    }

    private static void m(Object obj) {
        if (I(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private int m0(int i) {
        return this.a[i + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private int n(byte[] bArr, int i, int i2, I.a aVar, Map map, AbstractC2381e.b bVar) throws InvalidProtocolBufferException {
        int iH;
        int I = AbstractC2381e.I(bArr, i, bVar);
        int i3 = bVar.a;
        if (i3 < 0 || i3 > i2 - I) {
            throw InvalidProtocolBufferException.p();
        }
        int i4 = I + i3;
        Object obj = aVar.b;
        Object obj2 = aVar.d;
        while (I < i4) {
            int i5 = I + 1;
            byte b = bArr[I];
            if (b < 0) {
                iH = AbstractC2381e.H(b, bArr, i5, bVar);
                b = bVar.a;
            } else {
                iH = i5;
            }
            int i6 = b >>> 3;
            int i7 = b & 7;
            if (i6 != 1) {
                if (i6 == 2 && i7 == aVar.c.j()) {
                    I = o(bArr, iH, i2, aVar.c, aVar.d.getClass(), bVar);
                    obj2 = bVar.c;
                } else {
                    I = AbstractC2381e.P(b, bArr, iH, i2, bVar);
                }
            } else if (i7 == aVar.a.j()) {
                I = o(bArr, iH, i2, aVar.a, null, bVar);
                obj = bVar.c;
            } else {
                I = AbstractC2381e.P(b, bArr, iH, i2, bVar);
            }
        }
        if (I != i4) {
            throw InvalidProtocolBufferException.j();
        }
        map.put(obj, obj2);
        return i4;
    }

    private void n0(Object obj, long j, d0 d0Var, e0 e0Var, C2394s c2394s) {
        d0Var.I(this.n.e(obj, j), e0Var, c2394s);
    }

    private int o(byte[] bArr, int i, int i2, r0.b bVar, Class cls, AbstractC2381e.b bVar2) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                int iL = AbstractC2381e.L(bArr, i, bVar2);
                bVar2.c = Boolean.valueOf(bVar2.b != 0);
                return iL;
            case 2:
                return AbstractC2381e.b(bArr, i, bVar2);
            case 3:
                bVar2.c = Double.valueOf(AbstractC2381e.d(bArr, i));
                return i + 8;
            case 4:
            case 5:
                bVar2.c = Integer.valueOf(AbstractC2381e.h(bArr, i));
                return i + 4;
            case 6:
            case 7:
                bVar2.c = Long.valueOf(AbstractC2381e.j(bArr, i));
                return i + 8;
            case 8:
                bVar2.c = Float.valueOf(AbstractC2381e.l(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int I = AbstractC2381e.I(bArr, i, bVar2);
                bVar2.c = Integer.valueOf(bVar2.a);
                return I;
            case 12:
            case 13:
                int iL2 = AbstractC2381e.L(bArr, i, bVar2);
                bVar2.c = Long.valueOf(bVar2.b);
                return iL2;
            case 14:
                return AbstractC2381e.p(a0.a().c(cls), bArr, i, i2, bVar2);
            case 15:
                int I2 = AbstractC2381e.I(bArr, i, bVar2);
                bVar2.c = Integer.valueOf(AbstractC2384h.c(bVar2.a));
                return I2;
            case 16:
                int iL3 = AbstractC2381e.L(bArr, i, bVar2);
                bVar2.c = Long.valueOf(AbstractC2384h.d(bVar2.b));
                return iL3;
            case 17:
                return AbstractC2381e.F(bArr, i, bVar2);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private void o0(Object obj, int i, d0 d0Var, e0 e0Var, C2394s c2394s) {
        d0Var.J(this.n.e(obj, Z(i)), e0Var, c2394s);
    }

    private static double p(Object obj, long j) {
        return o0.A(obj, j);
    }

    private void p0(Object obj, int i, d0 d0Var) {
        if (C(i)) {
            o0.V(obj, Z(i), d0Var.H());
        } else if (this.g) {
            o0.V(obj, Z(i), d0Var.y());
        } else {
            o0.V(obj, Z(i), d0Var.n());
        }
    }

    private boolean q(Object obj, Object obj2, int i) {
        int iY0 = y0(i);
        long jZ = Z(iY0);
        switch (x0(iY0)) {
            case 0:
                if (k(obj, obj2, i) && Double.doubleToLongBits(o0.A(obj, jZ)) == Double.doubleToLongBits(o0.A(obj2, jZ))) {
                    break;
                }
                break;
            case 1:
                if (k(obj, obj2, i) && Float.floatToIntBits(o0.B(obj, jZ)) == Float.floatToIntBits(o0.B(obj2, jZ))) {
                    break;
                }
                break;
            case 2:
                if (k(obj, obj2, i) && o0.E(obj, jZ) == o0.E(obj2, jZ)) {
                    break;
                }
                break;
            case 3:
                if (k(obj, obj2, i) && o0.E(obj, jZ) == o0.E(obj2, jZ)) {
                    break;
                }
                break;
            case 4:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 5:
                if (k(obj, obj2, i) && o0.E(obj, jZ) == o0.E(obj2, jZ)) {
                    break;
                }
                break;
            case 6:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 7:
                if (k(obj, obj2, i) && o0.t(obj, jZ) == o0.t(obj2, jZ)) {
                    break;
                }
                break;
            case 8:
                if (k(obj, obj2, i) && g0.K(o0.G(obj, jZ), o0.G(obj2, jZ))) {
                    break;
                }
                break;
            case 9:
                if (k(obj, obj2, i) && g0.K(o0.G(obj, jZ), o0.G(obj2, jZ))) {
                    break;
                }
                break;
            case 10:
                if (k(obj, obj2, i) && g0.K(o0.G(obj, jZ), o0.G(obj2, jZ))) {
                    break;
                }
                break;
            case 11:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 12:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 13:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 14:
                if (k(obj, obj2, i) && o0.E(obj, jZ) == o0.E(obj2, jZ)) {
                    break;
                }
                break;
            case 15:
                if (k(obj, obj2, i) && o0.C(obj, jZ) == o0.C(obj2, jZ)) {
                    break;
                }
                break;
            case 16:
                if (k(obj, obj2, i) && o0.E(obj, jZ) == o0.E(obj2, jZ)) {
                    break;
                }
                break;
            case 17:
                if (k(obj, obj2, i) && g0.K(o0.G(obj, jZ), o0.G(obj2, jZ))) {
                    break;
                }
                break;
            case 51:
            case org.xbill.DNS.Type.TLSA /* 52 */:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case org.xbill.DNS.Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case WKSRecord.Protocol.RVD /* 66 */:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
                if (J(obj, obj2, i) && g0.K(o0.G(obj, jZ), o0.G(obj2, jZ))) {
                    break;
                }
                break;
        }
        return true;
    }

    private void q0(Object obj, int i, d0 d0Var) {
        if (C(i)) {
            d0Var.m(this.n.e(obj, Z(i)));
        } else {
            d0Var.A(this.n.e(obj, Z(i)));
        }
    }

    private Object r(Object obj, int i, Object obj2, l0 l0Var, Object obj3) {
        B.e eVarU;
        int iY = Y(i);
        Object objG = o0.G(obj, Z(y0(i)));
        return (objG == null || (eVarU = u(i)) == null) ? obj2 : s(i, iY, this.q.c(objG), eVarU, obj2, l0Var, obj3);
    }

    private static java.lang.reflect.Field r0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private Object s(int i, int i2, Map map, B.e eVar, Object obj, l0 l0Var, Object obj2) {
        I.a aVarB = this.q.b(v(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!eVar.a(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = l0Var.f(obj2);
                }
                AbstractC2383g.h hVarS = AbstractC2383g.S(I.b(aVarB, entry.getKey(), entry.getValue()));
                try {
                    I.e(hVarS.b(), aVarB, entry.getKey(), entry.getValue());
                    l0Var.d(obj, i2, hVarS.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    private void s0(Object obj, int i) {
        int iM0 = m0(i);
        long j = 1048575 & iM0;
        if (j == 1048575) {
            return;
        }
        o0.T(obj, j, (1 << (iM0 >>> 20)) | o0.C(obj, j));
    }

    private static float t(Object obj, long j) {
        return o0.B(obj, j);
    }

    private void t0(Object obj, int i, int i2) {
        o0.T(obj, m0(i2) & 1048575, i);
    }

    private B.e u(int i) {
        return (B.e) this.b[((i / 3) * 2) + 1];
    }

    private int u0(int i, int i2) {
        int length = (this.a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iY = Y(i4);
            if (i == iY) {
                return i4;
            }
            if (i < iY) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private Object v(int i) {
        return this.b[(i / 3) * 2];
    }

    private void v0(Object obj, int i, Object obj2) {
        s.putObject(obj, Z(y0(i)), obj2);
        s0(obj, i);
    }

    private e0 w(int i) {
        int i2 = (i / 3) * 2;
        e0 e0Var = (e0) this.b[i2];
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0VarC = a0.a().c((Class) this.b[i2 + 1]);
        this.b[i2] = e0VarC;
        return e0VarC;
    }

    private void w0(Object obj, int i, int i2, Object obj2) {
        s.putObject(obj, Z(y0(i2)), obj2);
        t0(obj, i, i2);
    }

    static m0 x(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        m0 m0Var = generatedMessageLite.unknownFields;
        if (m0Var != m0.c()) {
            return m0Var;
        }
        m0 m0VarO = m0.o();
        generatedMessageLite.unknownFields = m0VarO;
        return m0VarO;
    }

    private static int x0(int i) {
        return (i & 267386880) >>> 20;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int y(Object obj) {
        int i;
        int i2;
        int iJ;
        int iE;
        int I;
        boolean z;
        int iF;
        int i3;
        int iS;
        int iU;
        Unsafe unsafe = s;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < this.a.length) {
            int iY0 = y0(i6);
            int iY = Y(i6);
            int iX0 = x0(iY0);
            if (iX0 <= 17) {
                i = this.a[i6 + 2];
                int i9 = i & i4;
                i2 = 1 << (i >>> 20);
                if (i9 != i5) {
                    i8 = unsafe.getInt(obj, i9);
                    i5 = i9;
                }
            } else {
                i = (!this.i || iX0 < EnumC4986Hk2.F0.a() || iX0 > EnumC4986Hk2.S0.a()) ? 0 : this.a[i6 + 2] & i4;
                i2 = 0;
            }
            long jZ = Z(iY0);
            switch (iX0) {
                case 0:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.j(iY, 0.0d);
                        i7 += iJ;
                        break;
                    }
                case 1:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.r(iY, 0.0f);
                        i7 += iJ;
                        break;
                    }
                case 2:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.y(iY, unsafe.getLong(obj, jZ));
                        i7 += iJ;
                        break;
                    }
                case 3:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.V(iY, unsafe.getLong(obj, jZ));
                        i7 += iJ;
                        break;
                    }
                case 4:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.w(iY, unsafe.getInt(obj, jZ));
                        i7 += iJ;
                        break;
                    }
                case 5:
                    if ((i8 & i2) == 0) {
                        break;
                    } else {
                        iJ = CodedOutputStream.p(iY, 0L);
                        i7 += iJ;
                        break;
                    }
                case 6:
                    if ((i8 & i2) != 0) {
                        iJ = CodedOutputStream.n(iY, 0);
                        i7 += iJ;
                        break;
                    }
                    break;
                case 7:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.e(iY, true);
                        i7 += iE;
                    }
                    break;
                case 8:
                    if ((i8 & i2) != 0) {
                        Object object = unsafe.getObject(obj, jZ);
                        iE = object instanceof AbstractC2383g ? CodedOutputStream.h(iY, (AbstractC2383g) object) : CodedOutputStream.Q(iY, (String) object);
                        i7 += iE;
                    }
                    break;
                case 9:
                    if ((i8 & i2) != 0) {
                        iE = g0.o(iY, unsafe.getObject(obj, jZ), w(i6));
                        i7 += iE;
                    }
                    break;
                case 10:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.h(iY, (AbstractC2383g) unsafe.getObject(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 11:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.T(iY, unsafe.getInt(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 12:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.l(iY, unsafe.getInt(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 13:
                    if ((i8 & i2) != 0) {
                        I = CodedOutputStream.I(iY, 0);
                        i7 += I;
                    }
                    break;
                case 14:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.K(iY, 0L);
                        i7 += iE;
                    }
                    break;
                case 15:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.M(iY, unsafe.getInt(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 16:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.O(iY, unsafe.getLong(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 17:
                    if ((i8 & i2) != 0) {
                        iE = CodedOutputStream.t(iY, (P) unsafe.getObject(obj, jZ), w(i6));
                        i7 += iE;
                    }
                    break;
                case 18:
                    iE = g0.h(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iE;
                    break;
                case 19:
                    z = false;
                    iF = g0.f(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 20:
                    z = false;
                    iF = g0.m(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 21:
                    z = false;
                    iF = g0.x(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 22:
                    z = false;
                    iF = g0.k(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 23:
                    z = false;
                    iF = g0.h(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 24:
                    z = false;
                    iF = g0.f(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 25:
                    z = false;
                    iF = g0.a(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 26:
                    iE = g0.u(iY, (List) unsafe.getObject(obj, jZ));
                    i7 += iE;
                    break;
                case 27:
                    iE = g0.p(iY, (List) unsafe.getObject(obj, jZ), w(i6));
                    i7 += iE;
                    break;
                case 28:
                    iE = g0.c(iY, (List) unsafe.getObject(obj, jZ));
                    i7 += iE;
                    break;
                case 29:
                    iE = g0.v(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iE;
                    break;
                case 30:
                    z = false;
                    iF = g0.d(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 31:
                    z = false;
                    iF = g0.f(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 32:
                    z = false;
                    iF = g0.h(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 33:
                    z = false;
                    iF = g0.q(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 34:
                    z = false;
                    iF = g0.s(iY, (List) unsafe.getObject(obj, jZ), false);
                    i7 += iF;
                    break;
                case 35:
                    i3 = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 36:
                    i3 = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 37:
                    i3 = g0.n((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 38:
                    i3 = g0.y((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 39:
                    i3 = g0.l((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 40:
                    i3 = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 41:
                    i3 = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 42:
                    i3 = g0.b((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 43:
                    i3 = g0.w((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 44:
                    i3 = g0.e((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 45:
                    i3 = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 46:
                    i3 = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 47:
                    i3 = g0.r((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 48:
                    i3 = g0.t((List) unsafe.getObject(obj, jZ));
                    if (i3 > 0) {
                        if (this.i) {
                            unsafe.putInt(obj, i, i3);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i3);
                        I = iS + iU + i3;
                        i7 += I;
                    }
                    break;
                case 49:
                    iE = g0.j(iY, (List) unsafe.getObject(obj, jZ), w(i6));
                    i7 += iE;
                    break;
                case 50:
                    iE = this.q.g(iY, unsafe.getObject(obj, jZ), v(i6));
                    i7 += iE;
                    break;
                case 51:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.j(iY, 0.0d);
                        i7 += iE;
                    }
                    break;
                case org.xbill.DNS.Type.TLSA /* 52 */:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.r(iY, 0.0f);
                        i7 += iE;
                    }
                    break;
                case 53:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.y(iY, e0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.V(iY, e0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 55:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.w(iY, d0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case org.xbill.DNS.Type.NINFO /* 56 */:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.p(iY, 0L);
                        i7 += iE;
                    }
                    break;
                case 57:
                    if (K(obj, iY, i6)) {
                        I = CodedOutputStream.n(iY, 0);
                        i7 += I;
                    }
                    break;
                case 58:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.e(iY, true);
                        i7 += iE;
                    }
                    break;
                case 59:
                    if (K(obj, iY, i6)) {
                        Object object2 = unsafe.getObject(obj, jZ);
                        iE = object2 instanceof AbstractC2383g ? CodedOutputStream.h(iY, (AbstractC2383g) object2) : CodedOutputStream.Q(iY, (String) object2);
                        i7 += iE;
                    }
                    break;
                case 60:
                    if (K(obj, iY, i6)) {
                        iE = g0.o(iY, unsafe.getObject(obj, jZ), w(i6));
                        i7 += iE;
                    }
                    break;
                case 61:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.h(iY, (AbstractC2383g) unsafe.getObject(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 62:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.T(iY, d0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 63:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.l(iY, d0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 64:
                    if (K(obj, iY, i6)) {
                        I = CodedOutputStream.I(iY, 0);
                        i7 += I;
                    }
                    break;
                case 65:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.K(iY, 0L);
                        i7 += iE;
                    }
                    break;
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.M(iY, d0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case 67:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.O(iY, e0(obj, jZ));
                        i7 += iE;
                    }
                    break;
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (K(obj, iY, i6)) {
                        iE = CodedOutputStream.t(iY, (P) unsafe.getObject(obj, jZ), w(i6));
                        i7 += iE;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int iA = i7 + A(this.o, obj);
        return this.f ? iA + this.p.c(obj).n() : iA;
    }

    private int y0(int i) {
        return this.a[i + 1];
    }

    private int z(Object obj) {
        int iJ;
        int i;
        int iS;
        int iU;
        Unsafe unsafe = s;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.length; i3 += 3) {
            int iY0 = y0(i3);
            int iX0 = x0(iY0);
            int iY = Y(i3);
            long jZ = Z(iY0);
            int i4 = (iX0 < EnumC4986Hk2.F0.a() || iX0 > EnumC4986Hk2.S0.a()) ? 0 : this.a[i3 + 2] & 1048575;
            switch (iX0) {
                case 0:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.j(iY, 0.0d);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.r(iY, 0.0f);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.y(iY, o0.E(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.V(iY, o0.E(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.w(iY, o0.C(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.p(iY, 0L);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.n(iY, 0);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.e(iY, true);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (D(obj, i3)) {
                        Object objG = o0.G(obj, jZ);
                        iJ = objG instanceof AbstractC2383g ? CodedOutputStream.h(iY, (AbstractC2383g) objG) : CodedOutputStream.Q(iY, (String) objG);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (D(obj, i3)) {
                        iJ = g0.o(iY, o0.G(obj, jZ), w(i3));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.h(iY, (AbstractC2383g) o0.G(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.T(iY, o0.C(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.l(iY, o0.C(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.I(iY, 0);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.K(iY, 0L);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.M(iY, o0.C(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.O(iY, o0.E(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (D(obj, i3)) {
                        iJ = CodedOutputStream.t(iY, (P) o0.G(obj, jZ), w(i3));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iJ = g0.h(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 19:
                    iJ = g0.f(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 20:
                    iJ = g0.m(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 21:
                    iJ = g0.x(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 22:
                    iJ = g0.k(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 23:
                    iJ = g0.h(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 24:
                    iJ = g0.f(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 25:
                    iJ = g0.a(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 26:
                    iJ = g0.u(iY, M(obj, jZ));
                    i2 += iJ;
                    break;
                case 27:
                    iJ = g0.p(iY, M(obj, jZ), w(i3));
                    i2 += iJ;
                    break;
                case 28:
                    iJ = g0.c(iY, M(obj, jZ));
                    i2 += iJ;
                    break;
                case 29:
                    iJ = g0.v(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 30:
                    iJ = g0.d(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 31:
                    iJ = g0.f(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 32:
                    iJ = g0.h(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 33:
                    iJ = g0.q(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 34:
                    iJ = g0.s(iY, M(obj, jZ), false);
                    i2 += iJ;
                    break;
                case 35:
                    i = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 36:
                    i = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 37:
                    i = g0.n((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 38:
                    i = g0.y((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 39:
                    i = g0.l((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 40:
                    i = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 41:
                    i = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 42:
                    i = g0.b((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 43:
                    i = g0.w((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 44:
                    i = g0.e((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 45:
                    i = g0.g((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 46:
                    i = g0.i((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 47:
                    i = g0.r((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 48:
                    i = g0.t((List) unsafe.getObject(obj, jZ));
                    if (i <= 0) {
                        break;
                    } else {
                        if (this.i) {
                            unsafe.putInt(obj, i4, i);
                        }
                        iS = CodedOutputStream.S(iY);
                        iU = CodedOutputStream.U(i);
                        iJ = iS + iU + i;
                        i2 += iJ;
                        break;
                    }
                case 49:
                    iJ = g0.j(iY, M(obj, jZ), w(i3));
                    i2 += iJ;
                    break;
                case 50:
                    iJ = this.q.g(iY, o0.G(obj, jZ), v(i3));
                    i2 += iJ;
                    break;
                case 51:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.j(iY, 0.0d);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case org.xbill.DNS.Type.TLSA /* 52 */:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.r(iY, 0.0f);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.y(iY, e0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.V(iY, e0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.w(iY, d0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case org.xbill.DNS.Type.NINFO /* 56 */:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.p(iY, 0L);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.n(iY, 0);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.e(iY, true);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (K(obj, iY, i3)) {
                        Object objG2 = o0.G(obj, jZ);
                        iJ = objG2 instanceof AbstractC2383g ? CodedOutputStream.h(iY, (AbstractC2383g) objG2) : CodedOutputStream.Q(iY, (String) objG2);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (K(obj, iY, i3)) {
                        iJ = g0.o(iY, o0.G(obj, jZ), w(i3));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.h(iY, (AbstractC2383g) o0.G(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.T(iY, d0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.l(iY, d0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.I(iY, 0);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.K(iY, 0L);
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.M(iY, d0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.O(iY, e0(obj, jZ));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (K(obj, iY, i3)) {
                        iJ = CodedOutputStream.t(iY, (P) o0.G(obj, jZ), w(i3));
                        i2 += iJ;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i2 + A(this.o, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z0(java.lang.Object r18, com.google.protobuf.s0 r19) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.z0(java.lang.Object, com.google.protobuf.s0):void");
    }

    @Override // com.google.protobuf.e0
    public void a(Object obj, Object obj2) {
        m(obj);
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 3) {
            S(obj, obj2, i);
        }
        g0.G(this.o, obj, obj2);
        if (this.f) {
            g0.E(this.p, obj, obj2);
        }
    }

    @Override // com.google.protobuf.e0
    public int b(Object obj) {
        int i;
        int iF;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iY0 = y0(i3);
            int iY = Y(i3);
            long jZ = Z(iY0);
            int iHashCode = 37;
            switch (x0(iY0)) {
                case 0:
                    i = i2 * 53;
                    iF = B.f(Double.doubleToLongBits(o0.A(obj, jZ)));
                    i2 = i + iF;
                    break;
                case 1:
                    i = i2 * 53;
                    iF = Float.floatToIntBits(o0.B(obj, jZ));
                    i2 = i + iF;
                    break;
                case 2:
                    i = i2 * 53;
                    iF = B.f(o0.E(obj, jZ));
                    i2 = i + iF;
                    break;
                case 3:
                    i = i2 * 53;
                    iF = B.f(o0.E(obj, jZ));
                    i2 = i + iF;
                    break;
                case 4:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 5:
                    i = i2 * 53;
                    iF = B.f(o0.E(obj, jZ));
                    i2 = i + iF;
                    break;
                case 6:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 7:
                    i = i2 * 53;
                    iF = B.c(o0.t(obj, jZ));
                    i2 = i + iF;
                    break;
                case 8:
                    i = i2 * 53;
                    iF = ((String) o0.G(obj, jZ)).hashCode();
                    i2 = i + iF;
                    break;
                case 9:
                    Object objG = o0.G(obj, jZ);
                    if (objG != null) {
                        iHashCode = objG.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iF = o0.G(obj, jZ).hashCode();
                    i2 = i + iF;
                    break;
                case 11:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 12:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 13:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 14:
                    i = i2 * 53;
                    iF = B.f(o0.E(obj, jZ));
                    i2 = i + iF;
                    break;
                case 15:
                    i = i2 * 53;
                    iF = o0.C(obj, jZ);
                    i2 = i + iF;
                    break;
                case 16:
                    i = i2 * 53;
                    iF = B.f(o0.E(obj, jZ));
                    i2 = i + iF;
                    break;
                case 17:
                    Object objG2 = o0.G(obj, jZ);
                    if (objG2 != null) {
                        iHashCode = objG2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iF = o0.G(obj, jZ).hashCode();
                    i2 = i + iF;
                    break;
                case 50:
                    i = i2 * 53;
                    iF = o0.G(obj, jZ).hashCode();
                    i2 = i + iF;
                    break;
                case 51:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(Double.doubleToLongBits(b0(obj, jZ)));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case org.xbill.DNS.Type.TLSA /* 52 */:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = Float.floatToIntBits(c0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(e0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(e0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case org.xbill.DNS.Type.NINFO /* 56 */:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(e0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.c(a0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = ((String) o0.G(obj, jZ)).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = o0.G(obj, jZ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = o0.G(obj, jZ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(e0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Protocol.RVD /* 66 */:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = d0(obj, jZ);
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = B.f(e0(obj, jZ));
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
                case WKSRecord.Service.BOOTPC /* 68 */:
                    if (K(obj, iY, i3)) {
                        i = i2 * 53;
                        iF = o0.G(obj, jZ).hashCode();
                        i2 = i + iF;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.o.g(obj).hashCode();
        return this.f ? (iHashCode2 * 53) + this.p.c(obj).hashCode() : iHashCode2;
    }

    @Override // com.google.protobuf.e0
    public boolean c(Object obj, Object obj2) {
        int length = this.a.length;
        for (int i = 0; i < length; i += 3) {
            if (!q(obj, obj2, i)) {
                return false;
            }
        }
        if (!this.o.g(obj).equals(this.o.g(obj2))) {
            return false;
        }
        if (this.f) {
            return this.p.c(obj).equals(this.p.c(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.e0
    public Object d() {
        return this.m.a(this.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // com.google.protobuf.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = I(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.protobuf.GeneratedMessageLite
            if (r0 == 0) goto L17
            r0 = r8
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            r0.clearMemoizedSerializedSize()
            r0.clearMemoizedHashCode()
            r0.markImmutable()
        L17:
            int[] r0 = r7.a
            int r0 = r0.length
            r1 = 0
        L1b:
            if (r1 >= r0) goto L5f
            int r2 = r7.y0(r1)
            long r3 = Z(r2)
            int r2 = x0(r2)
            r5 = 9
            if (r2 == r5) goto L49
            switch(r2) {
                case 17: goto L49;
                case 18: goto L43;
                case 19: goto L43;
                case 20: goto L43;
                case 21: goto L43;
                case 22: goto L43;
                case 23: goto L43;
                case 24: goto L43;
                case 25: goto L43;
                case 26: goto L43;
                case 27: goto L43;
                case 28: goto L43;
                case 29: goto L43;
                case 30: goto L43;
                case 31: goto L43;
                case 32: goto L43;
                case 33: goto L43;
                case 34: goto L43;
                case 35: goto L43;
                case 36: goto L43;
                case 37: goto L43;
                case 38: goto L43;
                case 39: goto L43;
                case 40: goto L43;
                case 41: goto L43;
                case 42: goto L43;
                case 43: goto L43;
                case 44: goto L43;
                case 45: goto L43;
                case 46: goto L43;
                case 47: goto L43;
                case 48: goto L43;
                case 49: goto L43;
                case 50: goto L31;
                default: goto L30;
            }
        L30:
            goto L5c
        L31:
            sun.misc.Unsafe r2 = com.google.protobuf.S.s
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L5c
            com.google.protobuf.K r6 = r7.q
            java.lang.Object r5 = r6.f(r5)
            r2.putObject(r8, r3, r5)
            goto L5c
        L43:
            com.google.protobuf.F r2 = r7.n
            r2.c(r8, r3)
            goto L5c
        L49:
            boolean r2 = r7.D(r8, r1)
            if (r2 == 0) goto L5c
            com.google.protobuf.e0 r2 = r7.w(r1)
            sun.misc.Unsafe r5 = com.google.protobuf.S.s
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.e(r3)
        L5c:
            int r1 = r1 + 3
            goto L1b
        L5f:
            com.google.protobuf.l0 r0 = r7.o
            r0.j(r8)
            boolean r0 = r7.f
            if (r0 == 0) goto L6d
            com.google.protobuf.t r0 = r7.p
            r0.f(r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.e(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // com.google.protobuf.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(java.lang.Object r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r0 = r8
            r1 = r9
            r10 = r1
        Lb:
            int r2 = r6.k
            r3 = 1
            if (r10 >= r2) goto Lb1
            int[] r2 = r6.j
            r11 = r2[r10]
            int r12 = r6.Y(r11)
            int r13 = r6.y0(r11)
            int[] r2 = r6.a
            int r4 = r11 + 2
            r2 = r2[r4]
            r4 = r2 & r8
            int r2 = r2 >>> 20
            int r14 = r3 << r2
            if (r4 == r0) goto L37
            if (r4 == r8) goto L33
            sun.misc.Unsafe r0 = com.google.protobuf.S.s
            long r1 = (long) r4
            int r1 = r0.getInt(r7, r1)
        L33:
            r16 = r1
            r15 = r4
            goto L3a
        L37:
            r15 = r0
            r16 = r1
        L3a:
            boolean r0 = L(r13)
            if (r0 == 0) goto L50
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.E(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L50
            return r9
        L50:
            int r0 = x0(r13)
            r1 = 9
            if (r0 == r1) goto L90
            r1 = 17
            if (r0 == r1) goto L90
            r1 = 27
            if (r0 == r1) goto L89
            r1 = 60
            if (r0 == r1) goto L78
            r1 = 68
            if (r0 == r1) goto L78
            r1 = 49
            if (r0 == r1) goto L89
            r1 = 50
            if (r0 == r1) goto L71
            goto Laa
        L71:
            boolean r0 = r6.H(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L78:
            boolean r0 = r6.K(r7, r12, r11)
            if (r0 == 0) goto Laa
            com.google.protobuf.e0 r0 = r6.w(r11)
            boolean r0 = F(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        L89:
            boolean r0 = r6.G(r7, r13, r11)
            if (r0 != 0) goto Laa
            return r9
        L90:
            r0 = r17
            r1 = r18
            r2 = r11
            r3 = r15
            r4 = r16
            r5 = r14
            boolean r0 = r0.E(r1, r2, r3, r4, r5)
            if (r0 == 0) goto Laa
            com.google.protobuf.e0 r0 = r6.w(r11)
            boolean r0 = F(r7, r13, r0)
            if (r0 != 0) goto Laa
            return r9
        Laa:
            int r10 = r10 + 1
            r0 = r15
            r1 = r16
            goto Lb
        Lb1:
            boolean r0 = r6.f
            if (r0 == 0) goto Lc2
            com.google.protobuf.t r0 = r6.p
            com.google.protobuf.x r0 = r0.c(r7)
            boolean r0 = r0.s()
            if (r0 != 0) goto Lc2
            return r9
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.S.f(java.lang.Object):boolean");
    }

    @Override // com.google.protobuf.e0
    public int g(Object obj) {
        return this.h ? z(obj) : y(obj);
    }

    @Override // com.google.protobuf.e0
    public void h(Object obj, s0 s0Var) {
        if (s0Var.t() == s0.a.DESCENDING) {
            B0(obj, s0Var);
        } else if (this.h) {
            A0(obj, s0Var);
        } else {
            z0(obj, s0Var);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0090. Please report as an issue. */
    int h0(Object obj, byte[] bArr, int i, int i2, int i3, AbstractC2381e.b bVar) {
        Unsafe unsafe;
        int i4;
        S s2;
        int i5;
        int i6;
        int i7;
        int i8;
        Object obj2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        byte[] bArr2;
        int iL;
        int i20;
        int i21;
        S s3 = this;
        Object obj3 = obj;
        byte[] bArr3 = bArr;
        int i22 = i2;
        int i23 = i3;
        AbstractC2381e.b bVar2 = bVar;
        m(obj);
        Unsafe unsafe2 = s;
        int iG = i;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 1048575;
        while (true) {
            if (iG < i22) {
                int i29 = iG + 1;
                byte b = bArr3[iG];
                if (b < 0) {
                    int iH = AbstractC2381e.H(b, bArr3, i29, bVar2);
                    i9 = bVar2.a;
                    i29 = iH;
                } else {
                    i9 = b;
                }
                int i30 = i9 >>> 3;
                int i31 = i9 & 7;
                int iL0 = i30 > i27 ? s3.l0(i30, i24 / 3) : s3.k0(i30);
                if (iL0 == -1) {
                    i10 = i30;
                    i11 = i29;
                    i6 = i9;
                    i12 = i26;
                    i13 = i28;
                    unsafe = unsafe2;
                    i4 = i23;
                    i14 = 0;
                } else {
                    int i32 = s3.a[iL0 + 1];
                    int iX0 = x0(i32);
                    long jZ = Z(i32);
                    int i33 = i9;
                    if (iX0 <= 17) {
                        int i34 = s3.a[iL0 + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i28) {
                            if (i28 != 1048575) {
                                unsafe2.putInt(obj3, i28, i26);
                            }
                            i16 = i36;
                            i15 = unsafe2.getInt(obj3, i36);
                        } else {
                            i15 = i26;
                            i16 = i28;
                        }
                        switch (iX0) {
                            case 0:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 1) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    o0.R(obj3, jZ, AbstractC2381e.d(bArr2, i29));
                                    iG = i29 + 8;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 1:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 5) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    o0.S(obj3, jZ, AbstractC2381e.l(bArr2, i29));
                                    iG = i29 + 4;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iL = AbstractC2381e.L(bArr2, i29, bVar2);
                                    unsafe2.putLong(obj, jZ, bVar2.b);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    iG = iL;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = AbstractC2381e.I(bArr2, i29, bVar2);
                                    unsafe2.putInt(obj3, jZ, bVar2.a);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 1) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    unsafe2.putLong(obj, jZ, AbstractC2381e.j(bArr2, i29));
                                    iG = i29 + 8;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 5) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    unsafe2.putInt(obj3, jZ, AbstractC2381e.h(bArr2, i29));
                                    iG = i29 + 4;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 7:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = AbstractC2381e.L(bArr2, i29, bVar2);
                                    o0.L(obj3, jZ, bVar2.b != 0);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 8:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = (536870912 & i32) == 0 ? AbstractC2381e.C(bArr2, i29, bVar2) : AbstractC2381e.F(bArr2, i29, bVar2);
                                    unsafe2.putObject(obj3, jZ, bVar2.c);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 9:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    Object objT = s3.T(obj3, i19);
                                    iG = AbstractC2381e.O(objT, s3.w(i19), bArr, i29, i2, bVar);
                                    s3.v0(obj3, i19, objT);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 10:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = AbstractC2381e.b(bArr2, i29, bVar2);
                                    unsafe2.putObject(obj3, jZ, bVar2.c);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 12:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = AbstractC2381e.I(bArr2, i29, bVar2);
                                    int i37 = bVar2.a;
                                    B.e eVarU = s3.u(i19);
                                    if (eVarU == null || eVarU.a(i37)) {
                                        unsafe2.putInt(obj3, jZ, i37);
                                        i26 = i15 | i35;
                                        i23 = i3;
                                        i24 = i19;
                                        i25 = i18;
                                        i27 = i10;
                                        i28 = i17;
                                        bArr3 = bArr2;
                                    } else {
                                        x(obj).r(i18, Long.valueOf(i37));
                                        i24 = i19;
                                        i26 = i15;
                                        i25 = i18;
                                        i27 = i10;
                                        i28 = i17;
                                        i23 = i3;
                                        bArr3 = bArr2;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iG = AbstractC2381e.I(bArr2, i29, bVar2);
                                    unsafe2.putInt(obj3, jZ, AbstractC2384h.c(bVar2.a));
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 16:
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                bArr2 = bArr;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iL = AbstractC2381e.L(bArr2, i29, bVar2);
                                    unsafe2.putLong(obj, jZ, AbstractC2384h.d(bVar2.b));
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    iG = iL;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 17:
                                if (i31 != 3) {
                                    i10 = i30;
                                    i17 = i16;
                                    i18 = i33;
                                    i19 = iL0;
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    Object objT2 = s3.T(obj3, iL0);
                                    iG = AbstractC2381e.N(objT2, s3.w(iL0), bArr, i29, i2, (i30 << 3) | 4, bVar);
                                    s3.v0(obj3, iL0, objT2);
                                    i26 = i15 | i35;
                                    i28 = i16;
                                    i23 = i3;
                                    i24 = iL0;
                                    i25 = i33;
                                    i27 = i30;
                                    bArr3 = bArr;
                                }
                            default:
                                i10 = i30;
                                i19 = iL0;
                                i17 = i16;
                                i18 = i33;
                                i13 = i17;
                                i4 = i3;
                                i11 = i29;
                                i14 = i19;
                                unsafe = unsafe2;
                                i12 = i15;
                                i6 = i18;
                                break;
                        }
                    } else {
                        i10 = i30;
                        i13 = i28;
                        i12 = i26;
                        if (iX0 == 27) {
                            if (i31 == 2) {
                                B.j jVarB = (B.j) unsafe2.getObject(obj3, jZ);
                                if (!jVarB.u()) {
                                    int size = jVarB.size();
                                    jVarB = jVarB.b(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(obj3, jZ, jVarB);
                                }
                                iG = AbstractC2381e.q(s3.w(iL0), i33, bArr, i29, i2, jVarB, bVar);
                                i24 = iL0;
                                i25 = i33;
                                i28 = i13;
                                i26 = i12;
                                i27 = i10;
                                bArr3 = bArr;
                                i23 = i3;
                            } else {
                                i20 = i29;
                                unsafe = unsafe2;
                                i14 = iL0;
                                i21 = i33;
                                i4 = i3;
                                i11 = i20;
                            }
                        } else if (iX0 <= 49) {
                            int i38 = i29;
                            unsafe = unsafe2;
                            i14 = iL0;
                            i21 = i33;
                            iG = j0(obj, bArr, i29, i2, i33, i10, i31, iL0, i32, iX0, jZ, bVar);
                            if (iG != i38) {
                                s3 = this;
                                obj3 = obj;
                                bArr3 = bArr;
                                i22 = i2;
                                i23 = i3;
                                bVar2 = bVar;
                                i28 = i13;
                                i26 = i12;
                                i24 = i14;
                                i25 = i21;
                                i27 = i10;
                                unsafe2 = unsafe;
                            } else {
                                i4 = i3;
                                i11 = iG;
                            }
                        } else {
                            i20 = i29;
                            unsafe = unsafe2;
                            i14 = iL0;
                            i21 = i33;
                            if (iX0 != 50) {
                                iG = g0(obj, bArr, i20, i2, i21, i10, i31, i32, iX0, jZ, i14, bVar);
                                if (iG != i20) {
                                    s3 = this;
                                    obj3 = obj;
                                    bArr3 = bArr;
                                    i22 = i2;
                                    i23 = i3;
                                    bVar2 = bVar;
                                    i28 = i13;
                                    i26 = i12;
                                    i24 = i14;
                                    i25 = i21;
                                    i27 = i10;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i11 = iG;
                                }
                            } else if (i31 == 2) {
                                iG = f0(obj, bArr, i20, i2, i14, jZ, bVar);
                                if (iG != i20) {
                                    s3 = this;
                                    obj3 = obj;
                                    bArr3 = bArr;
                                    i22 = i2;
                                    i23 = i3;
                                    bVar2 = bVar;
                                    i28 = i13;
                                    i26 = i12;
                                    i24 = i14;
                                    i25 = i21;
                                    i27 = i10;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i11 = iG;
                                }
                            } else {
                                i4 = i3;
                                i11 = i20;
                            }
                        }
                        i6 = i21;
                    }
                }
                if (i6 != i4 || i4 == 0) {
                    iG = (!this.f || bVar.d == C2394s.b()) ? AbstractC2381e.G(i6, bArr, i11, i2, x(obj), bVar) : AbstractC2381e.g(i6, bArr, i11, i2, obj, this.e, this.o, bVar);
                    obj3 = obj;
                    bArr3 = bArr;
                    i22 = i2;
                    i25 = i6;
                    s3 = this;
                    bVar2 = bVar;
                    i28 = i13;
                    i26 = i12;
                    i24 = i14;
                    i27 = i10;
                    unsafe2 = unsafe;
                    i23 = i4;
                } else {
                    i8 = 1048575;
                    s2 = this;
                    i5 = i11;
                    i7 = i13;
                    i26 = i12;
                }
            } else {
                int i39 = i28;
                unsafe = unsafe2;
                i4 = i23;
                s2 = s3;
                i5 = iG;
                i6 = i25;
                i7 = i39;
                i8 = 1048575;
            }
        }
        if (i7 != i8) {
            obj2 = obj;
            unsafe.putInt(obj2, i7, i26);
        } else {
            obj2 = obj;
        }
        m0 m0Var = null;
        for (int i40 = s2.k; i40 < s2.l; i40++) {
            m0Var = (m0) r(obj, s2.j[i40], m0Var, s2.o, obj);
        }
        if (m0Var != null) {
            s2.o.o(obj2, m0Var);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw InvalidProtocolBufferException.j();
            }
        } else if (i5 > i2 || i6 != i4) {
            throw InvalidProtocolBufferException.j();
        }
        return i5;
    }

    @Override // com.google.protobuf.e0
    public void i(Object obj, d0 d0Var, C2394s c2394s) throws Throwable {
        c2394s.getClass();
        m(obj);
        O(this.o, this.p, obj, d0Var, c2394s);
    }

    @Override // com.google.protobuf.e0
    public void j(Object obj, byte[] bArr, int i, int i2, AbstractC2381e.b bVar) throws InvalidProtocolBufferException {
        if (this.h) {
            i0(obj, bArr, i, i2, bVar);
        } else {
            h0(obj, bArr, i, i2, 0, bVar);
        }
    }
}
