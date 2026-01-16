package ir.nasim;

import android.content.res.Resources;
import ir.nasim.ZF6;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.dG6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11593dG6 {
    public static final String a(ZF6 zf6, Resources resources) throws Resources.NotFoundException {
        AbstractC13042fc3.i(zf6, "<this>");
        AbstractC13042fc3.i(resources, "resources");
        if (AbstractC13042fc3.d(zf6, ZF6.b.a)) {
            String string = resources.getString(QD5.error_time_out);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (AbstractC13042fc3.d(zf6, ZF6.c.a)) {
            String string2 = resources.getString(QD5.error_unknown);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        if (zf6 instanceof ZF6.a) {
            return ((ZF6.a) zf6).a();
        }
        throw new NoWhenBranchMatchedException();
    }
}
