package ir.nasim;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

/* renamed from: ir.nasim.rf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20230rf8 {
    public static final a.g a;
    public static final a.g b;
    public static final a.AbstractC0169a c;
    static final a.AbstractC0169a d;
    public static final Scope e;
    public static final Scope f;
    public static final com.google.android.gms.common.api.a g;
    public static final com.google.android.gms.common.api.a h;

    static {
        a.g gVar = new a.g();
        a = gVar;
        a.g gVar2 = new a.g();
        b = gVar2;
        Me8 me8 = new Me8();
        c = me8;
        Te8 te8 = new Te8();
        d = te8;
        e = new Scope("profile");
        f = new Scope("email");
        g = new com.google.android.gms.common.api.a("SignIn.API", me8, gVar);
        h = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", te8, gVar2);
    }
}
