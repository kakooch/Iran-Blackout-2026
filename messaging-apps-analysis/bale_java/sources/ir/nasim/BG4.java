package ir.nasim;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class BG4 extends AbstractC6277Mx7 {
    private static final InterfaceC6537Nx7 c = f(EnumC19151pr7.a);
    private final KS2 a;
    private final InterfaceC19742qr7 b;

    class a implements InterfaceC6537Nx7 {
        final /* synthetic */ InterfaceC19742qr7 a;

        a(InterfaceC19742qr7 interfaceC19742qr7) {
            this.a = interfaceC19742qr7;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.c() == Object.class) {
                return new BG4(ks2, this.a, aVar);
            }
            return null;
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16723ll3.values().length];
            a = iArr;
            try {
                iArr[EnumC16723ll3.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC16723ll3.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC16723ll3.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC16723ll3.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC16723ll3.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC16723ll3.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* synthetic */ BG4(KS2 ks2, InterfaceC19742qr7 interfaceC19742qr7, a aVar) {
        this(ks2, interfaceC19742qr7);
    }

    public static InterfaceC6537Nx7 e(InterfaceC19742qr7 interfaceC19742qr7) {
        return interfaceC19742qr7 == EnumC19151pr7.a ? c : f(interfaceC19742qr7);
    }

    private static InterfaceC6537Nx7 f(InterfaceC19742qr7 interfaceC19742qr7) {
        return new a(interfaceC19742qr7);
    }

    private Object g(C12523el3 c12523el3, EnumC16723ll3 enumC16723ll3) throws IOException {
        int i = b.a[enumC16723ll3.ordinal()];
        if (i == 3) {
            return c12523el3.T0();
        }
        if (i == 4) {
            return this.b.a(c12523el3);
        }
        if (i == 5) {
            return Boolean.valueOf(c12523el3.q());
        }
        if (i == 6) {
            c12523el3.u();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + enumC16723ll3);
    }

    private Object h(C12523el3 c12523el3, EnumC16723ll3 enumC16723ll3) throws IOException {
        int i = b.a[enumC16723ll3.ordinal()];
        if (i == 1) {
            c12523el3.a();
            return new ArrayList();
        }
        if (i != 2) {
            return null;
        }
        c12523el3.B();
        return new C19343qB3();
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public Object b(C12523el3 c12523el3) throws IOException {
        EnumC16723ll3 enumC16723ll3G = c12523el3.G();
        Object objH = h(c12523el3, enumC16723ll3G);
        if (objH == null) {
            return g(c12523el3, enumC16723ll3G);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (c12523el3.l()) {
                String strN0 = objH instanceof Map ? c12523el3.n0() : null;
                EnumC16723ll3 enumC16723ll3G2 = c12523el3.G();
                Object objH2 = h(c12523el3, enumC16723ll3G2);
                boolean z = objH2 != null;
                if (objH2 == null) {
                    objH2 = g(c12523el3, enumC16723ll3G2);
                }
                if (objH instanceof List) {
                    ((List) objH).add(objH2);
                } else {
                    ((Map) objH).put(strN0, objH2);
                }
                if (z) {
                    arrayDeque.addLast(objH);
                    objH = objH2;
                }
            } else {
                if (objH instanceof List) {
                    c12523el3.e();
                } else {
                    c12523el3.F();
                }
                if (arrayDeque.isEmpty()) {
                    return objH;
                }
                objH = arrayDeque.removeLast();
            }
        }
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public void d(C22155ul3 c22155ul3, Object obj) throws IOException {
        if (obj == null) {
            c22155ul3.s();
            return;
        }
        AbstractC6277Mx7 abstractC6277Mx7N = this.a.n(obj.getClass());
        if (!(abstractC6277Mx7N instanceof BG4)) {
            abstractC6277Mx7N.d(c22155ul3, obj);
        } else {
            c22155ul3.d();
            c22155ul3.j();
        }
    }

    private BG4(KS2 ks2, InterfaceC19742qr7 interfaceC19742qr7) {
        this.a = ks2;
        this.b = interfaceC19742qr7;
    }
}
