package ir.nasim;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public final class XN3 implements InterfaceC6537Nx7 {
    private final C20806se1 a;
    final boolean b;

    private final class a extends AbstractC6277Mx7 {
        private final AbstractC6277Mx7 a;
        private final AbstractC6277Mx7 b;
        private final InterfaceC17616nG4 c;

        public a(KS2 ks2, Type type, AbstractC6277Mx7 abstractC6277Mx7, Type type2, AbstractC6277Mx7 abstractC6277Mx72, InterfaceC17616nG4 interfaceC17616nG4) {
            this.a = new C6776Ox7(ks2, abstractC6277Mx7, type);
            this.b = new C6776Ox7(ks2, abstractC6277Mx72, type2);
            this.c = interfaceC17616nG4;
        }

        private String e(AbstractC22735vk3 abstractC22735vk3) {
            if (!abstractC22735vk3.B()) {
                if (abstractC22735vk3.x()) {
                    return "null";
                }
                throw new AssertionError();
            }
            C9906al3 c9906al3R = abstractC22735vk3.r();
            if (c9906al3R.F()) {
                return String.valueOf(c9906al3R.C());
            }
            if (c9906al3R.D()) {
                return Boolean.toString(c9906al3R.f());
            }
            if (c9906al3R.I()) {
                return c9906al3R.v();
            }
            throw new AssertionError();
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map b(C12523el3 c12523el3) throws IOException {
            EnumC16723ll3 enumC16723ll3G = c12523el3.G();
            if (enumC16723ll3G == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            Map map = (Map) this.c.a();
            if (enumC16723ll3G == EnumC16723ll3.BEGIN_ARRAY) {
                c12523el3.a();
                while (c12523el3.l()) {
                    c12523el3.a();
                    Object objB = this.a.b(c12523el3);
                    if (map.put(objB, this.b.b(c12523el3)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objB);
                    }
                    c12523el3.e();
                }
                c12523el3.e();
            } else {
                c12523el3.B();
                while (c12523el3.l()) {
                    AbstractC13159fl3.a.a(c12523el3);
                    Object objB2 = this.a.b(c12523el3);
                    if (map.put(objB2, this.b.b(c12523el3)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + objB2);
                    }
                }
                c12523el3.F();
            }
            return map;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(C22155ul3 c22155ul3, Map map) throws IOException {
            if (map == null) {
                c22155ul3.s();
                return;
            }
            if (!XN3.this.b) {
                c22155ul3.d();
                for (Map.Entry entry : map.entrySet()) {
                    c22155ul3.p(String.valueOf(entry.getKey()));
                    this.b.d(c22155ul3, entry.getValue());
                }
                c22155ul3.j();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry entry2 : map.entrySet()) {
                AbstractC22735vk3 abstractC22735vk3C = this.a.c(entry2.getKey());
                arrayList.add(abstractC22735vk3C);
                arrayList2.add(entry2.getValue());
                z |= abstractC22735vk3C.w() || abstractC22735vk3C.A();
            }
            if (!z) {
                c22155ul3.d();
                int size = arrayList.size();
                while (i < size) {
                    c22155ul3.p(e((AbstractC22735vk3) arrayList.get(i)));
                    this.b.d(c22155ul3, arrayList2.get(i));
                    i++;
                }
                c22155ul3.j();
                return;
            }
            c22155ul3.c();
            int size2 = arrayList.size();
            while (i < size2) {
                c22155ul3.c();
                AbstractC19553qY6.b((AbstractC22735vk3) arrayList.get(i), c22155ul3);
                this.b.d(c22155ul3, arrayList2.get(i));
                c22155ul3.g();
                i++;
            }
            c22155ul3.g();
        }
    }

    public XN3(C20806se1 c20806se1, boolean z) {
        this.a = c20806se1;
        this.b = z;
    }

    private AbstractC6277Mx7 a(KS2 ks2, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? AbstractC7010Px7.f : ks2.m(TypeToken.b(type));
    }

    @Override // ir.nasim.InterfaceC6537Nx7
    public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) throws NoSuchMethodException, SecurityException {
        Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = AbstractC10051b.j(typeD, clsC);
        return new a(ks2, typeArrJ[0], a(ks2, typeArrJ[0]), typeArrJ[1], ks2.m(TypeToken.b(typeArrJ[1])), this.a.b(typeToken));
    }
}
