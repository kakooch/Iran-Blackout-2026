package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentTagUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentRequestCodeUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.SetTargetFragmentUsageViolation;
import androidx.fragment.app.strictmode.SetUserVisibleHintViolation;
import androidx.fragment.app.strictmode.Violation;
import androidx.fragment.app.strictmode.WrongFragmentContainerViolation;
import androidx.fragment.app.strictmode.WrongNestedHierarchyViolation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Ez2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4404Ez2 {
    public static final C4404Ez2 a = new C4404Ez2();
    private static c b = c.d;

    /* renamed from: ir.nasim.Ez2$a */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* renamed from: ir.nasim.Ez2$b */
    public interface b {
    }

    /* renamed from: ir.nasim.Ez2$c */
    public static final class c {
        public static final a c = new a(null);
        public static final c d = new c(AbstractC4597Fu6.d(), null, AbstractC20051rO3.k());
        private final Set a;
        private final Map b;

        /* renamed from: ir.nasim.Ez2$c$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public c(Set set, b bVar, Map map) {
            AbstractC13042fc3.i(set, "flags");
            AbstractC13042fc3.i(map, "allowedViolations");
            this.a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.b = linkedHashMap;
        }

        public final Set a() {
            return this.a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.b;
        }
    }

    private C4404Ez2() {
    }

    private final c b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.u6()) {
                FragmentManager fragmentManagerV5 = fragment.V5();
                AbstractC13042fc3.h(fragmentManagerV5, "declaringFragment.parentFragmentManager");
                if (fragmentManagerV5.J0() != null) {
                    c cVarJ0 = fragmentManagerV5.J0();
                    AbstractC13042fc3.f(cVarJ0);
                    return cVarJ0;
                }
            }
            fragment = fragment.U5();
        }
        return b;
    }

    private final void c(c cVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (cVar.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        cVar.b();
        if (cVar.a().contains(a.PENALTY_DEATH)) {
            o(fragment, new Runnable() { // from class: ir.nasim.Dz2
                @Override // java.lang.Runnable
                public final void run() {
                    C4404Ez2.d(name, violation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, Violation violation) {
        AbstractC13042fc3.i(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void e(Violation violation) {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public static final void f(Fragment fragment, String str) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(fragmentReuseViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_FRAGMENT_REUSE) && c4404Ez2.p(cVarB, fragment.getClass(), fragmentReuseViolation.getClass())) {
            c4404Ez2.c(cVarB, fragmentReuseViolation);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        AbstractC13042fc3.i(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(fragmentTagUsageViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && c4404Ez2.p(cVarB, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            c4404Ez2.c(cVarB, fragmentTagUsageViolation);
        }
    }

    public static final void h(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(getTargetFragmentRequestCodeUsageViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && c4404Ez2.p(cVarB, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            c4404Ez2.c(cVarB, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void i(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(getTargetFragmentUsageViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && c4404Ez2.p(cVarB, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            c4404Ez2.c(cVarB, getTargetFragmentUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(setRetainInstanceUsageViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && c4404Ez2.p(cVarB, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            c4404Ez2.c(cVarB, setRetainInstanceUsageViolation);
        }
    }

    public static final void k(Fragment fragment, Fragment fragment2, int i) {
        AbstractC13042fc3.i(fragment, "violatingFragment");
        AbstractC13042fc3.i(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(setTargetFragmentUsageViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && c4404Ez2.p(cVarB, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            c4404Ez2.c(cVarB, setTargetFragmentUsageViolation);
        }
    }

    public static final void l(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(setUserVisibleHintViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && c4404Ez2.p(cVarB, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            c4404Ez2.c(cVarB, setUserVisibleHintViolation);
        }
    }

    public static final void m(Fragment fragment, ViewGroup viewGroup) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(wrongFragmentContainerViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && c4404Ez2.p(cVarB, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            c4404Ez2.c(cVarB, wrongFragmentContainerViolation);
        }
    }

    public static final void n(Fragment fragment, Fragment fragment2, int i) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(fragment2, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, fragment2, i);
        C4404Ez2 c4404Ez2 = a;
        c4404Ez2.e(wrongNestedHierarchyViolation);
        c cVarB = c4404Ez2.b(fragment);
        if (cVarB.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && c4404Ez2.p(cVarB, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            c4404Ez2.c(cVarB, wrongNestedHierarchyViolation);
        }
    }

    private final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.u6()) {
            runnable.run();
            return;
        }
        Handler handlerN = fragment.V5().D0().n();
        if (AbstractC13042fc3.d(handlerN.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerN.post(runnable);
        }
    }

    private final boolean p(c cVar, Class cls, Class cls2) {
        Set set = (Set) cVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (AbstractC13042fc3.d(cls2.getSuperclass(), Violation.class) || !AbstractC15401jX0.i0(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
