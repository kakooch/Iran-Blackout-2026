package ir.nasim;

import android.app.Application;
import android.content.Context;
import io.livekit.android.room.Room;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.VC3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class UC3 {
    public static final UC3 a = new UC3();
    private static boolean b;

    private UC3() {
    }

    public static final boolean c() {
        return b;
    }

    public static final void d(UI3 ui3) {
        AbstractC13042fc3.i(ui3, "value");
        AbstractC6718Or3.Companion.b(ui3);
        if (ui3 != UI3.g) {
            List listF = AbstractC5270Ip7.f();
            AbstractC13042fc3.h(listF, "forest(...)");
            List list = listF;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((AbstractC5270Ip7.c) it.next()) instanceof AbstractC5270Ip7.a) {
                        return;
                    }
                }
            }
            AbstractC5270Ip7.i(new AbstractC5270Ip7.a());
        }
    }

    public final Room a(Context context, K26 k26, XC3 xc3) {
        AbstractC13042fc3.i(context, "appContext");
        AbstractC13042fc3.i(k26, "options");
        AbstractC13042fc3.i(xc3, "overrides");
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.l(null, "Application context was not found, this may cause memory leaks.", new Object[0]);
            }
        }
        VC3.a aVarA = AbstractC18622oy1.a();
        AbstractC13042fc3.h(aVarA, "factory(...)");
        AbstractC13042fc3.f(applicationContext);
        Room roomA = WC3.a(aVarA, applicationContext, xc3).a().a(applicationContext);
        roomA.m1(k26);
        return roomA;
    }
}
