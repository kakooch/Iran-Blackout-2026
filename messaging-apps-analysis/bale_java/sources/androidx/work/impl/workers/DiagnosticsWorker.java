package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import ir.nasim.C17810nb8;
import ir.nasim.HI3;
import ir.nasim.InterfaceC11816db8;
import ir.nasim.InterfaceC18401ob8;
import ir.nasim.InterfaceC20190rb8;
import ir.nasim.O47;
import ir.nasim.P47;
import ir.nasim.Za8;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DiagnosticsWorker extends Worker {
    private static final String g = HI3.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String s(C17810nb8 c17810nb8, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", c17810nb8.a, c17810nb8.c, num, c17810nb8.b.name(), str, str2);
    }

    private static String t(InterfaceC11816db8 interfaceC11816db8, InterfaceC20190rb8 interfaceC20190rb8, P47 p47, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17810nb8 c17810nb8 = (C17810nb8) it.next();
            O47 o47B = p47.b(c17810nb8.a);
            sb.append(s(c17810nb8, TextUtils.join(",", interfaceC11816db8.a(c17810nb8.a)), o47B != null ? Integer.valueOf(o47B.b) : null, TextUtils.join(",", interfaceC20190rb8.a(c17810nb8.a))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        WorkDatabase workDatabaseO = Za8.k(a()).o();
        InterfaceC18401ob8 interfaceC18401ob8Q = workDatabaseO.Q();
        InterfaceC11816db8 interfaceC11816db8O = workDatabaseO.O();
        InterfaceC20190rb8 interfaceC20190rb8R = workDatabaseO.R();
        P47 p47N = workDatabaseO.N();
        List listC = interfaceC18401ob8Q.c(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List listQ = interfaceC18401ob8Q.q();
        List listJ = interfaceC18401ob8Q.j(200);
        if (listC != null && !listC.isEmpty()) {
            HI3 hi3C = HI3.c();
            String str = g;
            hi3C.d(str, "Recently completed work:\n\n", new Throwable[0]);
            HI3.c().d(str, t(interfaceC11816db8O, interfaceC20190rb8R, p47N, listC), new Throwable[0]);
        }
        if (listQ != null && !listQ.isEmpty()) {
            HI3 hi3C2 = HI3.c();
            String str2 = g;
            hi3C2.d(str2, "Running work:\n\n", new Throwable[0]);
            HI3.c().d(str2, t(interfaceC11816db8O, interfaceC20190rb8R, p47N, listQ), new Throwable[0]);
        }
        if (listJ != null && !listJ.isEmpty()) {
            HI3 hi3C3 = HI3.c();
            String str3 = g;
            hi3C3.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            HI3.c().d(str3, t(interfaceC11816db8O, interfaceC20190rb8R, p47N, listJ), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
