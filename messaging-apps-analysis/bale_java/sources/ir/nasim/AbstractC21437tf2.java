package ir.nasim;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.tf2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21437tf2 {
    private static final g a = new a();

    /* renamed from: ir.nasim.tf2$b */
    class b implements d {
        b() {
        }

        @Override // ir.nasim.AbstractC21437tf2.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List create() {
            return new ArrayList();
        }
    }

    /* renamed from: ir.nasim.tf2$c */
    class c implements g {
        c() {
        }

        @Override // ir.nasim.AbstractC21437tf2.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            list.clear();
        }
    }

    /* renamed from: ir.nasim.tf2$d */
    public interface d {
        Object create();
    }

    /* renamed from: ir.nasim.tf2$e */
    private static final class e implements InterfaceC20850si5 {
        private final d a;
        private final g b;
        private final InterfaceC20850si5 c;

        e(InterfaceC20850si5 interfaceC20850si5, d dVar, g gVar) {
            this.c = interfaceC20850si5;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // ir.nasim.InterfaceC20850si5
        public boolean a(Object obj) {
            if (obj instanceof f) {
                ((f) obj).h().b(true);
            }
            this.b.a(obj);
            return this.c.a(obj);
        }

        @Override // ir.nasim.InterfaceC20850si5
        public Object b() {
            Object objB = this.c.b();
            if (objB == null) {
                objB = this.a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objB.getClass());
                }
            }
            if (objB instanceof f) {
                ((f) objB).h().b(false);
            }
            return objB;
        }
    }

    /* renamed from: ir.nasim.tf2$f */
    public interface f {
        AbstractC18254oL6 h();
    }

    /* renamed from: ir.nasim.tf2$g */
    public interface g {
        void a(Object obj);
    }

    private static InterfaceC20850si5 a(InterfaceC20850si5 interfaceC20850si5, d dVar) {
        return b(interfaceC20850si5, dVar, c());
    }

    private static InterfaceC20850si5 b(InterfaceC20850si5 interfaceC20850si5, d dVar, g gVar) {
        return new e(interfaceC20850si5, dVar, gVar);
    }

    private static g c() {
        return a;
    }

    public static InterfaceC20850si5 d(int i, d dVar) {
        return a(new C23313wi5(i), dVar);
    }

    public static InterfaceC20850si5 e() {
        return f(20);
    }

    public static InterfaceC20850si5 f(int i) {
        return b(new C23313wi5(i), new b(), new c());
    }

    /* renamed from: ir.nasim.tf2$a */
    class a implements g {
        a() {
        }

        @Override // ir.nasim.AbstractC21437tf2.g
        public void a(Object obj) {
        }
    }
}
