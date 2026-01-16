package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.e;
import ir.nasim.C17810nb8;
import ir.nasim.HI3;
import ir.nasim.Na8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class c {
    private static final String e = HI3.f("ConstraintsCmdHandler");
    private final Context a;
    private final int b;
    private final e c;
    private final Na8 d;

    c(Context context, int i, e eVar) {
        this.a = context;
        this.b = i;
        this.c = eVar;
        this.d = new Na8(context, eVar.f(), null);
    }

    void a() {
        List<C17810nb8> listD = this.c.g().o().Q().d();
        ConstraintProxy.a(this.a, listD);
        this.d.d(listD);
        ArrayList arrayList = new ArrayList(listD.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (C17810nb8 c17810nb8 : listD) {
            String str = c17810nb8.a;
            if (jCurrentTimeMillis >= c17810nb8.a() && (!c17810nb8.b() || this.d.c(str))) {
                arrayList.add(c17810nb8);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = ((C17810nb8) it.next()).a;
            Intent intentB = b.b(this.a, str2);
            HI3.c().a(e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            e eVar = this.c;
            eVar.k(new e.b(eVar, intentB, this.b));
        }
        this.d.e();
    }
}
