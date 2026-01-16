package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: ir.nasim.Aq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3385Aq5 {
    private final Map a;
    private final Map b;

    /* renamed from: ir.nasim.Aq5$c */
    private static final class c {
        private final Class a;
        private final Class b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a.equals(this.a) && cVar.b.equals(this.b);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }

        public String toString() {
            return this.a.getSimpleName() + " with primitive type: " + this.b.getSimpleName();
        }

        private c(Class cls, Class cls2) {
            this.a = cls;
            this.b = cls2;
        }
    }

    public static b c() {
        return new b();
    }

    public static b d(C3385Aq5 c3385Aq5) {
        return new b();
    }

    public Class e(Class cls) throws GeneralSecurityException {
        if (this.b.containsKey(cls)) {
            return ((InterfaceC5277Iq5) this.b.get(cls)).a();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls + " available");
    }

    public Object f(AbstractC14981io3 abstractC14981io3, Class cls) throws GeneralSecurityException {
        c cVar = new c(abstractC14981io3.getClass(), cls);
        if (this.a.containsKey(cVar)) {
            return ((AbstractC23983xq5) this.a.get(cVar)).a(abstractC14981io3);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + cVar + " available");
    }

    public Object g(C4092Dq5 c4092Dq5, Class cls) throws GeneralSecurityException {
        if (!this.b.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for " + cls);
        }
        InterfaceC5277Iq5 interfaceC5277Iq5 = (InterfaceC5277Iq5) this.b.get(cls);
        if (c4092Dq5.h().equals(interfaceC5277Iq5.a()) && interfaceC5277Iq5.a().equals(c4092Dq5.h())) {
            return interfaceC5277Iq5.c(c4092Dq5);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }

    /* renamed from: ir.nasim.Aq5$b */
    public static final class b {
        private final Map a;
        private final Map b;

        public C3385Aq5 c() {
            return new C3385Aq5(this);
        }

        public b d(AbstractC23983xq5 abstractC23983xq5) throws GeneralSecurityException {
            if (abstractC23983xq5 == null) {
                throw new NullPointerException("primitive constructor must be non-null");
            }
            c cVar = new c(abstractC23983xq5.c(), abstractC23983xq5.d());
            if (this.a.containsKey(cVar)) {
                AbstractC23983xq5 abstractC23983xq52 = (AbstractC23983xq5) this.a.get(cVar);
                if (!abstractC23983xq52.equals(abstractC23983xq5) || !abstractC23983xq5.equals(abstractC23983xq52)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + cVar);
                }
            } else {
                this.a.put(cVar, abstractC23983xq5);
            }
            return this;
        }

        public b e(InterfaceC5277Iq5 interfaceC5277Iq5) throws GeneralSecurityException {
            if (interfaceC5277Iq5 == null) {
                throw new NullPointerException("wrapper must be non-null");
            }
            Class clsB = interfaceC5277Iq5.b();
            if (this.b.containsKey(clsB)) {
                InterfaceC5277Iq5 interfaceC5277Iq52 = (InterfaceC5277Iq5) this.b.get(clsB);
                if (!interfaceC5277Iq52.equals(interfaceC5277Iq5) || !interfaceC5277Iq5.equals(interfaceC5277Iq52)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + clsB);
                }
            } else {
                this.b.put(clsB, interfaceC5277Iq5);
            }
            return this;
        }

        private b() {
            this.a = new HashMap();
            this.b = new HashMap();
        }

        private b(C3385Aq5 c3385Aq5) {
            this.a = new HashMap(c3385Aq5.a);
            this.b = new HashMap(c3385Aq5.b);
        }
    }

    private C3385Aq5(b bVar) {
        this.a = new HashMap(bVar.a);
        this.b = new HashMap(bVar.b);
    }
}
