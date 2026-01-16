package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import ir.nasim.IU3;
import ir.nasim.SharedPreferencesC15176j82;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.tu1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21653tu1 {
    private final Context a;
    private final IU3 b;
    private final Map c;

    public C21653tu1(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        IU3 iu3A = new IU3.b(context).b(IU3.c.AES256_GCM).a();
        AbstractC13042fc3.h(iu3A, "build(...)");
        this.b = iu3A;
        this.c = new LinkedHashMap();
    }

    public static /* synthetic */ SharedPreferences b(C21653tu1 c21653tu1, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = C13923h3.a.m();
        }
        return c21653tu1.a(i);
    }

    public final SharedPreferences a(int i) {
        Map map = this.c;
        Integer numValueOf = Integer.valueOf(i);
        Object objA = map.get(numValueOf);
        if (objA == null) {
            objA = SharedPreferencesC15176j82.a(this.a, EnumC18608ow5.v.p(i), this.b, SharedPreferencesC15176j82.d.AES256_SIV, SharedPreferencesC15176j82.e.AES256_GCM);
            AbstractC13042fc3.h(objA, "create(...)");
            map.put(numValueOf, objA);
        }
        return (SharedPreferences) objA;
    }
}
