package ir.nasim;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;

/* renamed from: ir.nasim.zF4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24817zF4 extends AbstractC6277Mx7 {
    private static final InterfaceC6537Nx7 b = f(EnumC19151pr7.b);
    private final InterfaceC19742qr7 a;

    /* renamed from: ir.nasim.zF4$a */
    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            if (typeToken.c() == Number.class) {
                return C24817zF4.this;
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.zF4$b */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16723ll3.values().length];
            a = iArr;
            try {
                iArr[EnumC16723ll3.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC16723ll3.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC16723ll3.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private C24817zF4(InterfaceC19742qr7 interfaceC19742qr7) {
        this.a = interfaceC19742qr7;
    }

    public static InterfaceC6537Nx7 e(InterfaceC19742qr7 interfaceC19742qr7) {
        return interfaceC19742qr7 == EnumC19151pr7.b ? b : f(interfaceC19742qr7);
    }

    private static InterfaceC6537Nx7 f(InterfaceC19742qr7 interfaceC19742qr7) {
        return new C24817zF4(interfaceC19742qr7).new a();
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(C12523el3 c12523el3) throws IOException {
        EnumC16723ll3 enumC16723ll3G = c12523el3.G();
        int i = b.a[enumC16723ll3G.ordinal()];
        if (i == 1) {
            c12523el3.u();
            return null;
        }
        if (i == 2 || i == 3) {
            return this.a.a(c12523el3);
        }
        throw new JsonSyntaxException("Expecting number, got: " + enumC16723ll3G + "; at path " + c12523el3.A());
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Number number) throws IOException {
        c22155ul3.U(number);
    }
}
