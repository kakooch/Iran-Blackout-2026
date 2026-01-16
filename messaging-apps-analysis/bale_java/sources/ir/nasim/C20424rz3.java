package ir.nasim;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ir.nasim.C12361eU5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.rz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C20424rz3 {
    final Map a = new HashMap();
    private final C12361eU5.b b;

    /* renamed from: ir.nasim.rz3$b */
    private final class b implements InterfaceC12970fU5 {
        private final FragmentManager a;

        b(FragmentManager fragmentManager) {
            this.a = fragmentManager;
        }

        private void b(FragmentManager fragmentManager, Set set) {
            List listC0 = fragmentManager.C0();
            int size = listC0.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) listC0.get(i);
                b(fragment.F5(), set);
                com.bumptech.glide.h hVarA = C20424rz3.this.a(fragment.getLifecycle());
                if (hVarA != null) {
                    set.add(hVarA);
                }
            }
        }

        @Override // ir.nasim.InterfaceC12970fU5
        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.a, hashSet);
            return hashSet;
        }
    }

    C20424rz3(C12361eU5.b bVar) {
        this.b = bVar;
    }

    com.bumptech.glide.h a(androidx.lifecycle.j jVar) {
        YM7.b();
        return (com.bumptech.glide.h) this.a.get(jVar);
    }

    com.bumptech.glide.h b(Context context, com.bumptech.glide.b bVar, androidx.lifecycle.j jVar, FragmentManager fragmentManager, boolean z) {
        YM7.b();
        com.bumptech.glide.h hVarA = a(jVar);
        if (hVarA != null) {
            return hVarA;
        }
        C16860lz3 c16860lz3 = new C16860lz3(jVar);
        com.bumptech.glide.h hVarA2 = this.b.a(bVar, c16860lz3, new b(fragmentManager), context);
        this.a.put(jVar, hVarA2);
        c16860lz3.a(new a(jVar));
        if (z) {
            hVarA2.f();
        }
        return hVarA2;
    }

    /* renamed from: ir.nasim.rz3$a */
    class a implements InterfaceC17451mz3 {
        final /* synthetic */ androidx.lifecycle.j a;

        a(androidx.lifecycle.j jVar) {
            this.a = jVar;
        }

        @Override // ir.nasim.InterfaceC17451mz3
        public void onDestroy() {
            C20424rz3.this.a.remove(this.a);
        }

        @Override // ir.nasim.InterfaceC17451mz3
        public void f() {
        }

        @Override // ir.nasim.InterfaceC17451mz3
        public void i() {
        }
    }
}
