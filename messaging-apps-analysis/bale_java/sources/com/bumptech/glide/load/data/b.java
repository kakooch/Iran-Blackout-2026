package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.a;
import ir.nasim.AbstractC3322Aj5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class b {
    private static final a.InterfaceC0146a b = new a();
    private final Map a = new HashMap();

    class a implements a.InterfaceC0146a {
        a() {
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0146a
        public com.bumptech.glide.load.data.a b(Object obj) {
            return new C0147b(obj);
        }
    }

    /* renamed from: com.bumptech.glide.load.data.b$b, reason: collision with other inner class name */
    private static final class C0147b implements com.bumptech.glide.load.data.a {
        private final Object a;

        C0147b(Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.data.a
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.a
        public Object c() {
            return this.a;
        }
    }

    public synchronized com.bumptech.glide.load.data.a a(Object obj) {
        a.InterfaceC0146a interfaceC0146a;
        try {
            AbstractC3322Aj5.d(obj);
            interfaceC0146a = (a.InterfaceC0146a) this.a.get(obj.getClass());
            if (interfaceC0146a == null) {
                Iterator it = this.a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.InterfaceC0146a interfaceC0146a2 = (a.InterfaceC0146a) it.next();
                    if (interfaceC0146a2.a().isAssignableFrom(obj.getClass())) {
                        interfaceC0146a = interfaceC0146a2;
                        break;
                    }
                }
            }
            if (interfaceC0146a == null) {
                interfaceC0146a = b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return interfaceC0146a.b(obj);
    }

    public synchronized void b(a.InterfaceC0146a interfaceC0146a) {
        this.a.put(interfaceC0146a.a(), interfaceC0146a);
    }
}
