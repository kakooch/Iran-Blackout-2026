package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import ir.nasim.AbstractC5747Kq7;
import ir.nasim.C20317ro3;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Uo3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8110Uo3 {
    private final Class a;
    private final Map b;
    private final Class c;

    /* renamed from: ir.nasim.Uo3$a */
    public static abstract class a {
        private final Class a;

        public a(Class cls) {
            this.a = cls;
        }

        public abstract com.google.crypto.tink.shaded.protobuf.I a(com.google.crypto.tink.shaded.protobuf.I i);

        public abstract com.google.crypto.tink.shaded.protobuf.I b(AbstractC2345g abstractC2345g);

        public abstract void c(com.google.crypto.tink.shaded.protobuf.I i);
    }

    protected AbstractC8110Uo3(Class cls, AbstractC24573yq5... abstractC24573yq5Arr) {
        this.a = cls;
        HashMap map = new HashMap();
        for (AbstractC24573yq5 abstractC24573yq5 : abstractC24573yq5Arr) {
            if (map.containsKey(abstractC24573yq5.b())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + abstractC24573yq5.b().getCanonicalName());
            }
            map.put(abstractC24573yq5.b(), abstractC24573yq5);
        }
        if (abstractC24573yq5Arr.length > 0) {
            this.c = abstractC24573yq5Arr[0].b();
        } else {
            this.c = Void.class;
        }
        this.b = Collections.unmodifiableMap(map);
    }

    public AbstractC5747Kq7.b a() {
        return AbstractC5747Kq7.b.a;
    }

    public final Class b() {
        return this.c;
    }

    public final Class c() {
        return this.a;
    }

    public abstract String d();

    public final Object e(com.google.crypto.tink.shaded.protobuf.I i, Class cls) {
        AbstractC24573yq5 abstractC24573yq5 = (AbstractC24573yq5) this.b.get(cls);
        if (abstractC24573yq5 != null) {
            return abstractC24573yq5.a(i);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract a f();

    public abstract C20317ro3.c g();

    public abstract com.google.crypto.tink.shaded.protobuf.I h(AbstractC2345g abstractC2345g);

    public final Set i() {
        return this.b.keySet();
    }

    public abstract void j(com.google.crypto.tink.shaded.protobuf.I i);
}
