package ir.nasim;

import com.google.gson.reflect.TypeToken;
import ir.nasim.C16489lM5;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: ir.nasim.Ox7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C6776Ox7 extends AbstractC6277Mx7 {
    private final KS2 a;
    private final AbstractC6277Mx7 b;
    private final Type c;

    C6776Ox7(KS2 ks2, AbstractC6277Mx7 abstractC6277Mx7, Type type) {
        this.a = ks2;
        this.b = abstractC6277Mx7;
        this.c = type;
    }

    private static Type e(Type type, Object obj) {
        return obj != null ? ((type instanceof Class) || (type instanceof TypeVariable)) ? obj.getClass() : type : type;
    }

    private static boolean f(AbstractC6277Mx7 abstractC6277Mx7) {
        AbstractC6277Mx7 abstractC6277Mx7E;
        while ((abstractC6277Mx7 instanceof AbstractC22208uq6) && (abstractC6277Mx7E = ((AbstractC22208uq6) abstractC6277Mx7).e()) != abstractC6277Mx7) {
            abstractC6277Mx7 = abstractC6277Mx7E;
        }
        return abstractC6277Mx7 instanceof C16489lM5.b;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public Object b(C12523el3 c12523el3) {
        return this.b.b(c12523el3);
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public void d(C22155ul3 c22155ul3, Object obj) {
        AbstractC6277Mx7 abstractC6277Mx7M = this.b;
        Type typeE = e(this.c, obj);
        if (typeE != this.c) {
            abstractC6277Mx7M = this.a.m(TypeToken.b(typeE));
            if ((abstractC6277Mx7M instanceof C16489lM5.b) && !f(this.b)) {
                abstractC6277Mx7M = this.b;
            }
        }
        abstractC6277Mx7M.d(c22155ul3, obj);
    }
}
