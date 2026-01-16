package ir.nasim;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import ir.nasim.C7289Rb6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class RV1 {
    private static final Class[] a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ C7289Rb6 f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, C7289Rb6 c7289Rb6, String str) {
            super(0);
            this.e = z;
            this.f = c7289Rb6;
            this.g = str;
        }

        public final void a() {
            if (this.e) {
                this.f.j(this.g);
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(RV1.f(obj));
        }
    }

    public static final PV1 b(View view, InterfaceC7760Tb6 interfaceC7760Tb6) {
        Object parent = view.getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) parent;
        Object tag = view2.getTag(AbstractC22421vC5.compose_view_saveable_id_tag);
        String strValueOf = tag instanceof String ? (String) tag : null;
        if (strValueOf == null) {
            strValueOf = String.valueOf(view2.getId());
        }
        return c(strValueOf, interfaceC7760Tb6);
    }

    public static final PV1 c(String str, InterfaceC7760Tb6 interfaceC7760Tb6) {
        boolean z;
        String str2 = InterfaceC11814db6.class.getSimpleName() + ':' + str;
        C7289Rb6 c7289Rb6V1 = interfaceC7760Tb6.v1();
        Bundle bundleB = c7289Rb6V1.b(str2);
        final InterfaceC11814db6 interfaceC11814db6A = AbstractC13035fb6.a(bundleB != null ? h(bundleB) : null, b.e);
        try {
            c7289Rb6V1.h(str2, new C7289Rb6.c() { // from class: ir.nasim.QV1
                @Override // ir.nasim.C7289Rb6.c
                public final Bundle b() {
                    return RV1.d(interfaceC11814db6A);
                }
            });
            z = true;
        } catch (IllegalArgumentException unused) {
            z = false;
        }
        return new PV1(interfaceC11814db6A, new a(z, c7289Rb6V1, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(InterfaceC11814db6 interfaceC11814db6) {
        return g(interfaceC11814db6.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Object obj) {
        if (obj instanceof YG6) {
            YG6 yg6 = (YG6) obj;
            if (yg6.c() != AbstractC10222bH6.j() && yg6.c() != AbstractC10222bH6.s() && yg6.c() != AbstractC10222bH6.p()) {
                return false;
            }
            Object value = yg6.getValue();
            if (value == null) {
                return true;
            }
            return f(value);
        }
        if ((obj instanceof InterfaceC18751pB2) && (obj instanceof Serializable)) {
            return false;
        }
        for (Class cls : a) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    private static final Bundle g(Map map) {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
        }
        return bundle;
    }

    private static final Map h(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(str);
            AbstractC13042fc3.g(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            linkedHashMap.put(str, parcelableArrayList);
        }
        return linkedHashMap;
    }
}
