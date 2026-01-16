package com.google.crypto.tink.internal;

import ir.nasim.AbstractC14981io3;
import ir.nasim.AbstractC20124rW4;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C19060pi6;
import ir.nasim.C8575Wo0;
import ir.nasim.InterfaceC20931sq6;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class c {
    private final Map a;
    private final Map b;
    private final Map c;
    private final Map d;

    /* renamed from: com.google.crypto.tink.internal.c$c, reason: collision with other inner class name */
    private static class C0194c {
        private final Class a;
        private final C8575Wo0 b;

        public boolean equals(Object obj) {
            if (!(obj instanceof C0194c)) {
                return false;
            }
            C0194c c0194c = (C0194c) obj;
            return c0194c.a.equals(this.a) && c0194c.b.equals(this.b);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }

        public String toString() {
            return this.a.getSimpleName() + ", object identifier: " + this.b;
        }

        private C0194c(Class cls, C8575Wo0 c8575Wo0) {
            this.a = cls;
            this.b = c8575Wo0;
        }
    }

    private static class d {
        private final Class a;
        private final Class b;

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return dVar.a.equals(this.a) && dVar.b.equals(this.b);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b);
        }

        public String toString() {
            return this.a.getSimpleName() + " with serialization type: " + this.b.getSimpleName();
        }

        private d(Class cls, Class cls2) {
            this.a = cls;
            this.b = cls2;
        }
    }

    public boolean e(InterfaceC20931sq6 interfaceC20931sq6) {
        return this.b.containsKey(new C0194c(interfaceC20931sq6.getClass(), interfaceC20931sq6.a()));
    }

    public boolean f(InterfaceC20931sq6 interfaceC20931sq6) {
        return this.d.containsKey(new C0194c(interfaceC20931sq6.getClass(), interfaceC20931sq6.a()));
    }

    public AbstractC14981io3 g(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) throws GeneralSecurityException {
        C0194c c0194c = new C0194c(interfaceC20931sq6.getClass(), interfaceC20931sq6.a());
        if (this.b.containsKey(c0194c)) {
            return ((AbstractC4789Go3) this.b.get(c0194c)).d(interfaceC20931sq6, c19060pi6);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + c0194c + " available");
    }

    public AbstractC20124rW4 h(InterfaceC20931sq6 interfaceC20931sq6) throws GeneralSecurityException {
        C0194c c0194c = new C0194c(interfaceC20931sq6.getClass(), interfaceC20931sq6.a());
        if (this.d.containsKey(c0194c)) {
            return ((AbstractC21353tW4) this.d.get(c0194c)).d(interfaceC20931sq6);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + c0194c + " available");
    }

    public InterfaceC20931sq6 i(AbstractC20124rW4 abstractC20124rW4, Class cls) throws GeneralSecurityException {
        d dVar = new d(abstractC20124rW4.getClass(), cls);
        if (this.c.containsKey(dVar)) {
            return ((AbstractC22010uW4) this.c.get(dVar)).d(abstractC20124rW4);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + dVar + " available");
    }

    private c(b bVar) {
        this.a = new HashMap(bVar.a);
        this.b = new HashMap(bVar.b);
        this.c = new HashMap(bVar.c);
        this.d = new HashMap(bVar.d);
    }

    public static final class b {
        private final Map a;
        private final Map b;
        private final Map c;
        private final Map d;

        public b() {
            this.a = new HashMap();
            this.b = new HashMap();
            this.c = new HashMap();
            this.d = new HashMap();
        }

        c e() {
            return new c(this);
        }

        public b f(AbstractC4789Go3 abstractC4789Go3) throws GeneralSecurityException {
            C0194c c0194c = new C0194c(abstractC4789Go3.c(), abstractC4789Go3.b());
            if (this.b.containsKey(c0194c)) {
                AbstractC4789Go3 abstractC4789Go32 = (AbstractC4789Go3) this.b.get(c0194c);
                if (!abstractC4789Go32.equals(abstractC4789Go3) || !abstractC4789Go3.equals(abstractC4789Go32)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + c0194c);
                }
            } else {
                this.b.put(c0194c, abstractC4789Go3);
            }
            return this;
        }

        public b g(com.google.crypto.tink.internal.a aVar) throws GeneralSecurityException {
            d dVar = new d(aVar.b(), aVar.c());
            if (this.a.containsKey(dVar)) {
                com.google.crypto.tink.internal.a aVar2 = (com.google.crypto.tink.internal.a) this.a.get(dVar);
                if (!aVar2.equals(aVar) || !aVar.equals(aVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + dVar);
                }
            } else {
                this.a.put(dVar, aVar);
            }
            return this;
        }

        public b h(AbstractC21353tW4 abstractC21353tW4) throws GeneralSecurityException {
            C0194c c0194c = new C0194c(abstractC21353tW4.c(), abstractC21353tW4.b());
            if (this.d.containsKey(c0194c)) {
                AbstractC21353tW4 abstractC21353tW42 = (AbstractC21353tW4) this.d.get(c0194c);
                if (!abstractC21353tW42.equals(abstractC21353tW4) || !abstractC21353tW4.equals(abstractC21353tW42)) {
                    throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + c0194c);
                }
            } else {
                this.d.put(c0194c, abstractC21353tW4);
            }
            return this;
        }

        public b i(AbstractC22010uW4 abstractC22010uW4) throws GeneralSecurityException {
            d dVar = new d(abstractC22010uW4.b(), abstractC22010uW4.c());
            if (this.c.containsKey(dVar)) {
                AbstractC22010uW4 abstractC22010uW42 = (AbstractC22010uW4) this.c.get(dVar);
                if (!abstractC22010uW42.equals(abstractC22010uW4) || !abstractC22010uW4.equals(abstractC22010uW42)) {
                    throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + dVar);
                }
            } else {
                this.c.put(dVar, abstractC22010uW4);
            }
            return this;
        }

        public b(c cVar) {
            this.a = new HashMap(cVar.a);
            this.b = new HashMap(cVar.b);
            this.c = new HashMap(cVar.c);
            this.d = new HashMap(cVar.d);
        }
    }
}
