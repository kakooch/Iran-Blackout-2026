package ir.nasim;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2059c;
import java.util.Iterator;

/* renamed from: ir.nasim.og8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18451og8 {
    private static final LI3 a = new LI3("GoogleSignInCommon", new String[0]);

    public static AbstractC22929w35 a(com.google.android.gms.common.api.c cVar, Context context, boolean z) {
        a.a("Revoking access", new Object[0]);
        String strE = LN6.b(context).e();
        c(context);
        return z ? RunnableC9861ag8.a(strE) : cVar.a(new C16678lg8(cVar));
    }

    public static AbstractC22929w35 b(com.google.android.gms.common.api.c cVar, Context context, boolean z) {
        a.a("Signing out", new Object[0]);
        c(context);
        return z ? AbstractC24109y35.b(Status.f, cVar) : cVar.a(new C15496jg8(cVar));
    }

    private static void c(Context context) {
        C19042pg8.a(context).b();
        Iterator it = com.google.android.gms.common.api.c.b().iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.c) it.next()).e();
        }
        C2059c.a();
    }
}
