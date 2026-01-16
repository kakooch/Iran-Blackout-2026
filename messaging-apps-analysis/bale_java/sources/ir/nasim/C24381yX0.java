package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: ir.nasim.yX0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24381yX0 {
    public static final a b = new a(null);
    private static final long c = DX0.d(4278190080L);
    private static final long d = DX0.d(4282664004L);
    private static final long e = DX0.d(4287137928L);
    private static final long f = DX0.d(4291611852L);
    private static final long g = DX0.d(4294967295L);
    private static final long h = DX0.d(4294901760L);
    private static final long i = DX0.d(4278255360L);
    private static final long j = DX0.d(4278190335L);
    private static final long k = DX0.d(4294967040L);
    private static final long l = DX0.d(4278255615L);
    private static final long m = DX0.d(4294902015L);
    private static final long n = DX0.b(0);
    private static final long o = DX0.a(0.0f, 0.0f, 0.0f, 0.0f, LY0.a.I());
    private final long a;

    /* renamed from: ir.nasim.yX0$a */
    public static final class a {
        private a() {
        }

        public final long a() {
            return C24381yX0.c;
        }

        public final long b() {
            return C24381yX0.j;
        }

        public final long c() {
            return C24381yX0.d;
        }

        public final long d() {
            return C24381yX0.i;
        }

        public final long e() {
            return C24381yX0.f;
        }

        public final long f() {
            return C24381yX0.m;
        }

        public final long g() {
            return C24381yX0.h;
        }

        public final long h() {
            return C24381yX0.n;
        }

        public final long i() {
            return C24381yX0.o;
        }

        public final long j() {
            return C24381yX0.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C24381yX0(long j2) {
        this.a = j2;
    }

    public static final /* synthetic */ C24381yX0 k(long j2) {
        return new C24381yX0(j2);
    }

    public static final long m(long j2, AbstractC9775aY0 abstractC9775aY0) {
        return AbstractC10395bY0.i(t(j2), abstractC9775aY0, 0, 2, null).a(j2);
    }

    public static final long n(long j2, float f2, float f3, float f4, float f5) {
        return DX0.a(f3, f4, f5, f2, t(j2));
    }

    public static /* synthetic */ long o(long j2, float f2, float f3, float f4, float f5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = r(j2);
        }
        float f6 = f2;
        if ((i2 & 2) != 0) {
            f3 = v(j2);
        }
        float f7 = f3;
        if ((i2 & 4) != 0) {
            f4 = u(j2);
        }
        float f8 = f4;
        if ((i2 & 8) != 0) {
            f5 = s(j2);
        }
        return n(j2, f6, f7, f8, f5);
    }

    public static boolean p(long j2, Object obj) {
        return (obj instanceof C24381yX0) && j2 == ((C24381yX0) obj).y();
    }

    public static final boolean q(long j2, long j3) {
        return C14599iA7.j(j2, j3);
    }

    public static final float r(long j2) {
        float fC;
        float f2;
        if (C14599iA7.h(63 & j2) == 0) {
            fC = (float) YB7.c(C14599iA7.h(C14599iA7.h(j2 >>> 56) & 255));
            f2 = 255.0f;
        } else {
            fC = (float) YB7.c(C14599iA7.h(C14599iA7.h(j2 >>> 6) & 1023));
            f2 = 1023.0f;
        }
        return fC / f2;
    }

    public static final float s(long j2) {
        int i2;
        int i3;
        int i4;
        if (C14599iA7.h(63 & j2) == 0) {
            return ((float) YB7.c(C14599iA7.h(C14599iA7.h(j2 >>> 32) & 255))) / 255.0f;
        }
        short sH = (short) C14599iA7.h(C14599iA7.h(j2 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i5 = Short.MIN_VALUE & sH;
        int i6 = ((65535 & sH) >>> 10) & 31;
        int i7 = sH & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i2 = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i2 = i6 + SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            }
            int i9 = i2;
            i3 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - AbstractC8352Vp2.a;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i3);
    }

    public static final AbstractC9775aY0 t(long j2) {
        LY0 ly0 = LY0.a;
        return ly0.v()[(int) C14599iA7.h(j2 & 63)];
    }

    public static final float u(long j2) {
        int i2;
        int i3;
        int i4;
        if (C14599iA7.h(63 & j2) == 0) {
            return ((float) YB7.c(C14599iA7.h(C14599iA7.h(j2 >>> 40) & 255))) / 255.0f;
        }
        short sH = (short) C14599iA7.h(C14599iA7.h(j2 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i5 = Short.MIN_VALUE & sH;
        int i6 = ((65535 & sH) >>> 10) & 31;
        int i7 = sH & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i2 = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i2 = i6 + SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            }
            int i9 = i2;
            i3 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - AbstractC8352Vp2.a;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i3);
    }

    public static final float v(long j2) {
        int i2;
        int i3;
        int i4;
        if (C14599iA7.h(63 & j2) == 0) {
            return ((float) YB7.c(C14599iA7.h(C14599iA7.h(j2 >>> 48) & 255))) / 255.0f;
        }
        short sH = (short) C14599iA7.h(C14599iA7.h(j2 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i5 = Short.MIN_VALUE & sH;
        int i6 = ((65535 & sH) >>> 10) & 31;
        int i7 = sH & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i2 = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i2 = i6 + SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            }
            int i9 = i2;
            i3 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - AbstractC8352Vp2.a;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i3 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i3);
    }

    public static int w(long j2) {
        return C14599iA7.o(j2);
    }

    public static String x(long j2) {
        return "Color(" + v(j2) + ", " + u(j2) + ", " + s(j2) + ", " + r(j2) + ", " + t(j2).f() + ')';
    }

    public boolean equals(Object obj) {
        return p(this.a, obj);
    }

    public int hashCode() {
        return w(this.a);
    }

    public String toString() {
        return x(this.a);
    }

    public final /* synthetic */ long y() {
        return this.a;
    }

    public static long l(long j2) {
        return j2;
    }
}
