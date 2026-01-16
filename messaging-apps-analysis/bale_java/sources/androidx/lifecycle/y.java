package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C20298rm4;
import ir.nasim.C7289Rb6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9336Zm4;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class y {
    public static final a f = new a(null);
    private static final Class[] g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    private final Map a;
    private final Map b;
    private final Map c;
    private final Map d;
    private final C7289Rb6.c e;

    public static final class a {
        private a() {
        }

        public final y a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new y();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    AbstractC13042fc3.h(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new y(map);
            }
            ClassLoader classLoader = y.class.getClassLoader();
            AbstractC13042fc3.f(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = parcelableArrayList.get(i);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
            }
            return new y(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : y.g) {
                AbstractC13042fc3.f(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public y(Map map) {
        AbstractC13042fc3.i(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new C7289Rb6.c() { // from class: ir.nasim.Mb6
            @Override // ir.nasim.C7289Rb6.c
            public final Bundle b() {
                return androidx.lifecycle.y.f(this.a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle f(y yVar) {
        AbstractC13042fc3.i(yVar, "this$0");
        for (Map.Entry entry : AbstractC20051rO3.y(yVar.b).entrySet()) {
            yVar.g((String) entry.getKey(), ((C7289Rb6.c) entry.getValue()).b());
        }
        Set<String> setKeySet = yVar.a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(yVar.a.get(str));
        }
        return AbstractC23348wm0.b(AbstractC4616Fw7.a("keys", arrayList), AbstractC4616Fw7.a("values", arrayList2));
    }

    public final Object c(String str) {
        AbstractC13042fc3.i(str, "key");
        try {
            return this.a.get(str);
        } catch (ClassCastException unused) {
            d(str);
            return null;
        }
    }

    public final Object d(String str) {
        AbstractC13042fc3.i(str, "key");
        Object objRemove = this.a.remove(str);
        AbstractC18350oW3.a(this.c.remove(str));
        this.d.remove(str);
        return objRemove;
    }

    public final C7289Rb6.c e() {
        return this.e;
    }

    public final void g(String str, Object obj) {
        AbstractC13042fc3.i(str, "key");
        if (!f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            AbstractC13042fc3.f(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.c.get(str);
        C20298rm4 c20298rm4 = obj2 instanceof C20298rm4 ? (C20298rm4) obj2 : null;
        if (c20298rm4 != null) {
            c20298rm4.p(obj);
        } else {
            this.a.put(str, obj);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = (InterfaceC9336Zm4) this.d.get(str);
        if (interfaceC9336Zm4 == null) {
            return;
        }
        interfaceC9336Zm4.setValue(obj);
    }

    public y() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new C7289Rb6.c() { // from class: ir.nasim.Mb6
            @Override // ir.nasim.C7289Rb6.c
            public final Bundle b() {
                return androidx.lifecycle.y.f(this.a);
            }
        };
    }
}
