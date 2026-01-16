package ir.nasim;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class VW0 implements InterfaceC6537Nx7 {
    private final C20806se1 a;

    private static final class a extends AbstractC6277Mx7 {
        private final AbstractC6277Mx7 a;
        private final InterfaceC17616nG4 b;

        public a(KS2 ks2, Type type, AbstractC6277Mx7 abstractC6277Mx7, InterfaceC17616nG4 interfaceC17616nG4) {
            this.a = new C6776Ox7(ks2, abstractC6277Mx7, type);
            this.b = interfaceC17616nG4;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            Collection collection = (Collection) this.b.a();
            c12523el3.a();
            while (c12523el3.l()) {
                collection.add(this.a.b(c12523el3));
            }
            c12523el3.e();
            return collection;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Collection collection) throws IOException {
            if (collection == null) {
                c22155ul3.s();
                return;
            }
            c22155ul3.c();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.a.d(c22155ul3, it.next());
            }
            c22155ul3.g();
        }
    }

    public VW0(C20806se1 c20806se1) {
        this.a = c20806se1;
    }

    @Override // ir.nasim.InterfaceC6537Nx7
    public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
        Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        if (!Collection.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type typeH = AbstractC10051b.h(typeD, clsC);
        return new a(ks2, typeH, ks2.m(TypeToken.b(typeH)), this.a.b(typeToken));
    }
}
