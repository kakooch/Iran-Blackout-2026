package ir.nasim;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.y6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24133y6 {
    private static final b h = new b(null);
    private final Map a = new LinkedHashMap();
    private final Map b = new LinkedHashMap();
    private final Map c = new LinkedHashMap();
    private final List d = new ArrayList();
    private final transient Map e = new LinkedHashMap();
    private final Map f = new LinkedHashMap();
    private final Bundle g = new Bundle();

    /* renamed from: ir.nasim.y6$a */
    private static final class a {
        private final InterfaceC17517n6 a;
        private final AbstractC18108o6 b;

        public a(InterfaceC17517n6 interfaceC17517n6, AbstractC18108o6 abstractC18108o6) {
            AbstractC13042fc3.i(interfaceC17517n6, "callback");
            AbstractC13042fc3.i(abstractC18108o6, "contract");
            this.a = interfaceC17517n6;
            this.b = abstractC18108o6;
        }

        public final InterfaceC17517n6 a() {
            return this.a;
        }

        public final AbstractC18108o6 b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.y6$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.y6$c */
    private static final class c {
        private final androidx.lifecycle.j a;
        private final List b;

        public c(androidx.lifecycle.j jVar) {
            AbstractC13042fc3.i(jVar, "lifecycle");
            this.a = jVar;
            this.b = new ArrayList();
        }

        public final void a(androidx.lifecycle.n nVar) {
            AbstractC13042fc3.i(nVar, "observer");
            this.a.a(nVar);
            this.b.add(nVar);
        }

        public final void b() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                this.a.d((androidx.lifecycle.n) it.next());
            }
            this.b.clear();
        }
    }

    /* renamed from: ir.nasim.y6$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        public static final d e = new d();

        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(AbstractC17026mG5.a.g(2147418112) + 65536);
        }
    }

    /* renamed from: ir.nasim.y6$e */
    public static final class e extends AbstractC22357v6 {
        final /* synthetic */ String b;
        final /* synthetic */ AbstractC18108o6 c;

        e(String str, AbstractC18108o6 abstractC18108o6) {
            this.b = str;
            this.c = abstractC18108o6;
        }

        @Override // ir.nasim.AbstractC22357v6
        public void b(Object obj, AbstractC15744k6 abstractC15744k6) throws Exception {
            Object obj2 = AbstractC24133y6.this.b.get(this.b);
            AbstractC18108o6 abstractC18108o6 = this.c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC24133y6.this.d.add(this.b);
                try {
                    AbstractC24133y6.this.i(iIntValue, this.c, obj, abstractC15744k6);
                    return;
                } catch (Exception e) {
                    AbstractC24133y6.this.d.remove(this.b);
                    throw e;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC18108o6 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // ir.nasim.AbstractC22357v6
        public void c() {
            AbstractC24133y6.this.p(this.b);
        }
    }

    /* renamed from: ir.nasim.y6$f */
    public static final class f extends AbstractC22357v6 {
        final /* synthetic */ String b;
        final /* synthetic */ AbstractC18108o6 c;

        f(String str, AbstractC18108o6 abstractC18108o6) {
            this.b = str;
            this.c = abstractC18108o6;
        }

        @Override // ir.nasim.AbstractC22357v6
        public void b(Object obj, AbstractC15744k6 abstractC15744k6) throws Exception {
            Object obj2 = AbstractC24133y6.this.b.get(this.b);
            AbstractC18108o6 abstractC18108o6 = this.c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                AbstractC24133y6.this.d.add(this.b);
                try {
                    AbstractC24133y6.this.i(iIntValue, this.c, obj, abstractC15744k6);
                    return;
                } catch (Exception e) {
                    AbstractC24133y6.this.d.remove(this.b);
                    throw e;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC18108o6 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // ir.nasim.AbstractC22357v6
        public void c() {
            AbstractC24133y6.this.p(this.b);
        }
    }

    private final void d(int i, String str) {
        this.a.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    private final void g(String str, int i, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.d.contains(str)) {
            this.f.remove(str);
            this.g.putParcelable(str, new ActivityResult(i, intent));
        } else {
            aVar.a().a(aVar.b().c(i, intent));
            this.d.remove(str);
        }
    }

    private final int h() {
        for (Number number : AbstractC9962aq6.h(d.e)) {
            if (!this.a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AbstractC24133y6 abstractC24133y6, String str, InterfaceC17517n6 interfaceC17517n6, AbstractC18108o6 abstractC18108o6, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(abstractC24133y6, "this$0");
        AbstractC13042fc3.i(str, "$key");
        AbstractC13042fc3.i(interfaceC17517n6, "$callback");
        AbstractC13042fc3.i(abstractC18108o6, "$contract");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        if (j.a.ON_START != aVar) {
            if (j.a.ON_STOP == aVar) {
                abstractC24133y6.e.remove(str);
                return;
            } else {
                if (j.a.ON_DESTROY == aVar) {
                    abstractC24133y6.p(str);
                    return;
                }
                return;
            }
        }
        abstractC24133y6.e.put(str, new a(interfaceC17517n6, abstractC18108o6));
        if (abstractC24133y6.f.containsKey(str)) {
            Object obj = abstractC24133y6.f.get(str);
            abstractC24133y6.f.remove(str);
            interfaceC17517n6.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) AbstractC22162um0.a(abstractC24133y6.g, str, ActivityResult.class);
        if (activityResult != null) {
            abstractC24133y6.g.remove(str);
            interfaceC17517n6.a(abstractC18108o6.c(activityResult.getResultCode(), activityResult.getData()));
        }
    }

    private final void o(String str) {
        if (((Integer) this.b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final boolean e(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        g(str, i2, intent, (a) this.e.get(str));
        return true;
    }

    public final boolean f(int i, Object obj) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.g.remove(str);
            this.f.put(str, obj);
            return true;
        }
        InterfaceC17517n6 interfaceC17517n6A = aVar.a();
        AbstractC13042fc3.g(interfaceC17517n6A, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.d.remove(str)) {
            return true;
        }
        interfaceC17517n6A.a(obj);
        return true;
    }

    public abstract void i(int i, AbstractC18108o6 abstractC18108o6, Object obj, AbstractC15744k6 abstractC15744k6);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            if (this.b.containsKey(str)) {
                Integer num = (Integer) this.b.remove(str);
                if (!this.g.containsKey(str)) {
                    AbstractC19810qy7.d(this.a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i);
            AbstractC13042fc3.h(num2, "rcs[i]");
            int iIntValue = num2.intValue();
            String str2 = stringArrayList.get(i);
            AbstractC13042fc3.h(str2, "keys[i]");
            d(iIntValue, str2);
        }
    }

    public final void k(Bundle bundle) {
        AbstractC13042fc3.i(bundle, "outState");
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.g));
    }

    public final AbstractC22357v6 l(String str, AbstractC18108o6 abstractC18108o6, InterfaceC17517n6 interfaceC17517n6) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(abstractC18108o6, "contract");
        AbstractC13042fc3.i(interfaceC17517n6, "callback");
        o(str);
        this.e.put(str, new a(interfaceC17517n6, abstractC18108o6));
        if (this.f.containsKey(str)) {
            Object obj = this.f.get(str);
            this.f.remove(str);
            interfaceC17517n6.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) AbstractC22162um0.a(this.g, str, ActivityResult.class);
        if (activityResult != null) {
            this.g.remove(str);
            interfaceC17517n6.a(abstractC18108o6.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new f(str, abstractC18108o6);
    }

    public final AbstractC22357v6 m(final String str, InterfaceC18633oz3 interfaceC18633oz3, final AbstractC18108o6 abstractC18108o6, final InterfaceC17517n6 interfaceC17517n6) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(abstractC18108o6, "contract");
        AbstractC13042fc3.i(interfaceC17517n6, "callback");
        androidx.lifecycle.j lifecycle = interfaceC18633oz3.getLifecycle();
        if (!lifecycle.b().j(j.b.STARTED)) {
            o(str);
            c cVar = (c) this.c.get(str);
            if (cVar == null) {
                cVar = new c(lifecycle);
            }
            cVar.a(new androidx.lifecycle.n() { // from class: ir.nasim.x6
                @Override // androidx.lifecycle.n
                public final void s(InterfaceC18633oz3 interfaceC18633oz32, j.a aVar) {
                    AbstractC24133y6.n(this.a, str, interfaceC17517n6, abstractC18108o6, interfaceC18633oz32, aVar);
                }
            });
            this.c.put(str, cVar);
            return new e(str, abstractC18108o6);
        }
        throw new IllegalStateException(("LifecycleOwner " + interfaceC18633oz3 + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    public final void p(String str) {
        Integer num;
        AbstractC13042fc3.i(str, "key");
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.get(str));
            this.f.remove(str);
        }
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) AbstractC22162um0.a(this.g, str, ActivityResult.class)));
            this.g.remove(str);
        }
        c cVar = (c) this.c.get(str);
        if (cVar != null) {
            cVar.b();
            this.c.remove(str);
        }
    }
}
