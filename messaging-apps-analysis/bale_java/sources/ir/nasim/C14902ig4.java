package ir.nasim;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.ig4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14902ig4 {
    private final C23932xl4 a;
    private final a b;

    /* renamed from: ir.nasim.ig4$a */
    private static class a {
        private final Map a = new HashMap();

        /* renamed from: ir.nasim.ig4$a$a, reason: collision with other inner class name */
        private static class C1305a {
            final List a;

            public C1305a(List list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        public List b(Class cls) {
            C1305a c1305a = (C1305a) this.a.get(cls);
            if (c1305a == null) {
                return null;
            }
            return c1305a.a;
        }

        public void c(Class cls, List list) {
            if (((C1305a) this.a.put(cls, new C1305a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public C14902ig4(InterfaceC20850si5 interfaceC20850si5) {
        this(new C23932xl4(interfaceC20850si5));
    }

    private static Class b(Object obj) {
        return obj.getClass();
    }

    private synchronized List e(Class cls) {
        List listB;
        listB = this.b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, listB);
        }
        return listB;
    }

    public synchronized void a(Class cls, Class cls2, InterfaceC14292hg4 interfaceC14292hg4) {
        this.a.b(cls, cls2, interfaceC14292hg4);
        this.b.a();
    }

    public synchronized List c(Class cls) {
        return this.a.g(cls);
    }

    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj);
        }
        int size = listE.size();
        List listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            InterfaceC13701gg4 interfaceC13701gg4 = (InterfaceC13701gg4) listE.get(i);
            if (interfaceC13701gg4.a(obj)) {
                if (z) {
                    listEmptyList = new ArrayList(size - i);
                    z = false;
                }
                listEmptyList.add(interfaceC13701gg4);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj, listE);
        }
        return listEmptyList;
    }

    private C14902ig4(C23932xl4 c23932xl4) {
        this.b = new a();
        this.a = c23932xl4;
    }
}
