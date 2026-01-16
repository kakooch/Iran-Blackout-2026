package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC24832zH1;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class AH1 {
    public static final XV4 a(AbstractC24832zH1 abstractC24832zH1, Resources resources) throws Resources.NotFoundException {
        String string;
        AbstractC13042fc3.i(abstractC24832zH1, "<this>");
        AbstractC13042fc3.i(resources, "resources");
        String string2 = resources.getString(abstractC24832zH1.b());
        AbstractC13042fc3.h(string2, "getString(...)");
        boolean z = abstractC24832zH1 instanceof AbstractC24832zH1.a;
        if (z) {
            string2 = resources.getString(abstractC24832zH1.b(), Integer.valueOf(((AbstractC24832zH1.a) abstractC24832zH1).c()));
        }
        if (z) {
            string = resources.getString(abstractC24832zH1.a(), Integer.valueOf(((AbstractC24832zH1.a) abstractC24832zH1).c()));
        } else if (abstractC24832zH1 instanceof AbstractC24832zH1.c) {
            string = resources.getString(abstractC24832zH1.a(), ((AbstractC24832zH1.c) abstractC24832zH1).c());
        } else if (abstractC24832zH1 instanceof AbstractC24832zH1.d) {
            string = resources.getString(abstractC24832zH1.a(), ((AbstractC24832zH1.d) abstractC24832zH1).c());
        } else if (abstractC24832zH1 instanceof AbstractC24832zH1.b) {
            string = resources.getString(abstractC24832zH1.a(), ((AbstractC24832zH1.b) abstractC24832zH1).d());
        } else {
            if (!(abstractC24832zH1 instanceof AbstractC24832zH1.e)) {
                throw new NoWhenBranchMatchedException();
            }
            string = resources.getString(abstractC24832zH1.a(), ((AbstractC24832zH1.e) abstractC24832zH1).c());
        }
        AbstractC13042fc3.f(string);
        return AbstractC4616Fw7.a(string2, string);
    }
}
