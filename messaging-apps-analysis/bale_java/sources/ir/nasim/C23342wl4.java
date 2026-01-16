package ir.nasim;

import com.bumptech.glide.load.engine.GlideException;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.wl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C23342wl4 implements InterfaceC13701gg4 {
    private final List a;
    private final InterfaceC20850si5 b;

    /* renamed from: ir.nasim.wl4$a */
    static class a implements InterfaceC8666Wy1, InterfaceC8666Wy1.a {
        private final List a;
        private final InterfaceC20850si5 b;
        private int c;
        private EnumC6212Mq5 d;
        private InterfaceC8666Wy1.a e;
        private List f;
        private boolean g;

        a(List list, InterfaceC20850si5 interfaceC20850si5) {
            this.b = interfaceC20850si5;
            AbstractC3322Aj5.c(list);
            this.a = list;
            this.c = 0;
        }

        private void g() {
            if (this.g) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                this.c++;
                e(this.d, this.e);
            } else {
                AbstractC3322Aj5.d(this.f);
                this.e.c(new GlideException("Fetch failed", new ArrayList(this.f)));
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return ((InterfaceC8666Wy1) this.a.get(0)).a();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
            List list = this.f;
            if (list != null) {
                this.b.a(list);
            }
            this.f = null;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((InterfaceC8666Wy1) it.next()).b();
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1.a
        public void c(Exception exc) {
            ((List) AbstractC3322Aj5.d(this.f)).add(exc);
            g();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
            this.g = true;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((InterfaceC8666Wy1) it.next()).cancel();
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return ((InterfaceC8666Wy1) this.a.get(0)).d();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            this.d = enumC6212Mq5;
            this.e = aVar;
            this.f = (List) this.b.b();
            ((InterfaceC8666Wy1) this.a.get(this.c)).e(enumC6212Mq5, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1.a
        public void f(Object obj) {
            if (obj != null) {
                this.e.f(obj);
            } else {
                g();
            }
        }
    }

    C23342wl4(List list, InterfaceC20850si5 interfaceC20850si5) {
        this.a = list;
        this.b = interfaceC20850si5;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public boolean a(Object obj) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((InterfaceC13701gg4) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC13701gg4
    public InterfaceC13701gg4.a b(Object obj, int i, int i2, HL4 hl4) {
        InterfaceC13701gg4.a aVarB;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        InterfaceC14373ho3 interfaceC14373ho3 = null;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC13701gg4 interfaceC13701gg4 = (InterfaceC13701gg4) this.a.get(i3);
            if (interfaceC13701gg4.a(obj) && (aVarB = interfaceC13701gg4.b(obj, i, i2, hl4)) != null) {
                interfaceC14373ho3 = aVarB.a;
                arrayList.add(aVarB.c);
            }
        }
        if (arrayList.isEmpty() || interfaceC14373ho3 == null) {
            return null;
        }
        return new InterfaceC13701gg4.a(interfaceC14373ho3, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}
