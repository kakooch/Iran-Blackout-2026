package ir.nasim;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class SJ extends AbstractC6277Mx7 {
    public static final InterfaceC6537Nx7 c = new a();
    private final Class a;
    private final AbstractC6277Mx7 b;

    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            Type typeD = typeToken.d();
            if (!(typeD instanceof GenericArrayType) && (!(typeD instanceof Class) || !((Class) typeD).isArray())) {
                return null;
            }
            Type typeG = AbstractC10051b.g(typeD);
            return new SJ(ks2, ks2.m(TypeToken.b(typeG)), AbstractC10051b.k(typeG));
        }
    }

    public SJ(KS2 ks2, AbstractC6277Mx7 abstractC6277Mx7, Class cls) {
        this.b = new C6776Ox7(ks2, abstractC6277Mx7, cls);
        this.a = cls;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public Object b(C12523el3 c12523el3) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (c12523el3.G() == EnumC16723ll3.NULL) {
            c12523el3.u();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        c12523el3.a();
        while (c12523el3.l()) {
            arrayList.add(this.b.b(c12523el3));
        }
        c12523el3.e();
        int size = arrayList.size();
        if (!this.a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.a, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public void d(C22155ul3 c22155ul3, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            c22155ul3.s();
            return;
        }
        c22155ul3.c();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.d(c22155ul3, Array.get(obj, i));
        }
        c22155ul3.g();
    }
}
