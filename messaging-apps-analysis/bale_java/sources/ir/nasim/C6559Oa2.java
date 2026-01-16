package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ir.nasim.Oa2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6559Oa2 {
    private HashMap a = new HashMap();
    private HashMap b = new HashMap();

    /* renamed from: ir.nasim.Oa2$a */
    private class a {
        private ArrayList a;

        public a(String str) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(str);
        }

        public ArrayList a() {
            return this.a;
        }
    }

    private synchronized void c(AbstractC18385oa2 abstractC18385oa2, boolean z) {
        try {
            String strA = abstractC18385oa2.a();
            if (z) {
                this.a.put(strA, abstractC18385oa2);
            }
            for (InterfaceC3817Cm0 interfaceC3817Cm0 : this.b.keySet()) {
                a aVar = (a) this.b.get(interfaceC3817Cm0);
                if (aVar.a().contains(null) || aVar.a().contains(strA)) {
                    interfaceC3817Cm0.T(abstractC18385oa2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(AbstractC18385oa2 abstractC18385oa2) {
        c(abstractC18385oa2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(AbstractC18385oa2 abstractC18385oa2) {
        c(abstractC18385oa2, true);
    }

    public void f(final AbstractC18385oa2 abstractC18385oa2) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.La2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(abstractC18385oa2);
            }
        });
    }

    public void g(final AbstractC18385oa2 abstractC18385oa2) {
        AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.Na2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(abstractC18385oa2);
            }
        });
    }

    public synchronized void h(InterfaceC3817Cm0 interfaceC3817Cm0, String str) {
        try {
            a aVar = (a) this.b.get(interfaceC3817Cm0);
            if (aVar == null) {
                a aVar2 = new a(str);
                aVar2.a().add(str);
                this.b.put(interfaceC3817Cm0, aVar2);
            } else if (!aVar.a().contains(str)) {
                aVar.a().add(str);
            }
            if (str != null && this.a.containsKey(str)) {
                interfaceC3817Cm0.T((AbstractC18385oa2) this.a.get(str));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i(InterfaceC3817Cm0 interfaceC3817Cm0) {
        this.b.remove(interfaceC3817Cm0);
    }
}
