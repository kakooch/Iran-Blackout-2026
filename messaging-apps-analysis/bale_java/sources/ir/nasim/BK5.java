package ir.nasim;

import android.os.Bundle;
import androidx.lifecycle.j;
import ir.nasim.C7289Rb6;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class BK5 implements androidx.lifecycle.n {
    public static final a b = new a(null);
    private final InterfaceC7760Tb6 a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements C7289Rb6.c {
        private final Set a;

        public b(C7289Rb6 c7289Rb6) {
            AbstractC13042fc3.i(c7289Rb6, "registry");
            this.a = new LinkedHashSet();
            c7289Rb6.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String str) {
            AbstractC13042fc3.i(str, "className");
            this.a.add(str);
        }

        @Override // ir.nasim.C7289Rb6.c
        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.a));
            return bundle;
        }
    }

    public BK5(InterfaceC7760Tb6 interfaceC7760Tb6) {
        AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
        this.a = interfaceC7760Tb6;
    }

    private final void a(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, BK5.class.getClassLoader()).asSubclass(C7289Rb6.a.class);
            AbstractC13042fc3.h(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    AbstractC13042fc3.h(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((C7289Rb6.a) objNewInstance).a(this.a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar != j.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC18633oz3.getLifecycle().d(this);
        Bundle bundleB = this.a.v1().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
