package ir.nasim;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10449bd6 {
    private static final String a = HI3.f("Schedulers");

    static InterfaceC4435Fc6 a(Context context, Za8 za8) {
        X47 x47 = new X47(context, za8);
        FS4.a(context, SystemJobService.class, true);
        HI3.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
        return x47;
    }

    public static void b(androidx.work.a aVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        InterfaceC18401ob8 interfaceC18401ob8Q = workDatabase.Q();
        workDatabase.e();
        try {
            List listN = interfaceC18401ob8Q.n(aVar.h());
            List listJ = interfaceC18401ob8Q.j(200);
            if (listN != null && listN.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator it = listN.iterator();
                while (it.hasNext()) {
                    interfaceC18401ob8Q.l(((C17810nb8) it.next()).a, jCurrentTimeMillis);
                }
            }
            workDatabase.F();
            workDatabase.j();
            if (listN != null && listN.size() > 0) {
                C17810nb8[] c17810nb8Arr = (C17810nb8[]) listN.toArray(new C17810nb8[listN.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    InterfaceC4435Fc6 interfaceC4435Fc6 = (InterfaceC4435Fc6) it2.next();
                    if (interfaceC4435Fc6.c()) {
                        interfaceC4435Fc6.f(c17810nb8Arr);
                    }
                }
            }
            if (listJ == null || listJ.size() <= 0) {
                return;
            }
            C17810nb8[] c17810nb8Arr2 = (C17810nb8[]) listJ.toArray(new C17810nb8[listJ.size()]);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                InterfaceC4435Fc6 interfaceC4435Fc62 = (InterfaceC4435Fc6) it3.next();
                if (!interfaceC4435Fc62.c()) {
                    interfaceC4435Fc62.f(c17810nb8Arr2);
                }
            }
        } catch (Throwable th) {
            workDatabase.j();
            throw th;
        }
    }
}
