package ir.nasim;

import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.kL2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15886kL2 {
    private final Object a;
    private final String b;
    private final TH6 c;
    private final Object d;
    private final C25005za3 e;
    private final Collection f;
    private final Collection g;
    private final boolean h;

    public /* synthetic */ AbstractC15886kL2(Object obj, String str, TH6 th6, Object obj2, C25005za3 c25005za3, Collection collection, Collection collection2, boolean z, ED1 ed1) {
        this(obj, str, th6, obj2, c25005za3, collection, collection2, z);
    }

    public final C25005za3 a() {
        return this.e;
    }

    public final Collection b() {
        return this.g;
    }

    public final Collection c() {
        return this.f;
    }

    public final TH6 d() {
        return this.c;
    }

    public List e() {
        return AbstractC10360bX0.m();
    }

    public final String f() {
        return this.b;
    }

    private AbstractC15886kL2(Object obj, String str, TH6 th6, Object obj2, C25005za3 c25005za3, Collection collection, Collection collection2, boolean z) {
        this.a = obj;
        this.b = str;
        this.c = th6;
        this.d = obj2;
        this.e = c25005za3;
        this.f = collection;
        this.g = collection2;
        this.h = z;
    }
}
