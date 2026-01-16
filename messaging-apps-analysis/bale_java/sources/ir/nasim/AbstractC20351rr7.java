package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC22884vz0;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.rr7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20351rr7 {
    public static final String a(AbstractC22884vz0 abstractC22884vz0, Resources resources) throws Resources.NotFoundException {
        AbstractC13042fc3.i(abstractC22884vz0, "<this>");
        AbstractC13042fc3.i(resources, "resources");
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.C1733a) {
            String string = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.a.C1733a) abstractC22884vz0).b());
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.d) {
            String string2 = resources.getString(abstractC22884vz0.a());
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.f) {
            String string3 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.a.f) abstractC22884vz0).b());
            AbstractC13042fc3.h(string3, "getString(...)");
            return string3;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.g) {
            String string4 = resources.getString(abstractC22884vz0.a(), Integer.valueOf(((AbstractC22884vz0.a.g) abstractC22884vz0).b()));
            AbstractC13042fc3.h(string4, "getString(...)");
            return string4;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.c) {
            String string5 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.a.c) abstractC22884vz0).b());
            AbstractC13042fc3.h(string5, "getString(...)");
            return string5;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.b) {
            String string6 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.a.b) abstractC22884vz0).b());
            AbstractC13042fc3.h(string6, "getString(...)");
            return string6;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.a.e) {
            String string7 = resources.getString(abstractC22884vz0.a());
            AbstractC13042fc3.h(string7, "getString(...)");
            return string7;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.c.b) {
            String string8 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.c.b) abstractC22884vz0).b());
            AbstractC13042fc3.h(string8, "getString(...)");
            return string8;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.c.a) {
            String string9 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.c.a) abstractC22884vz0).b());
            AbstractC13042fc3.h(string9, "getString(...)");
            return string9;
        }
        if (abstractC22884vz0 instanceof AbstractC22884vz0.b.C1734b) {
            String string10 = resources.getString(abstractC22884vz0.a(), ((AbstractC22884vz0.b.C1734b) abstractC22884vz0).c());
            AbstractC13042fc3.h(string10, "getString(...)");
            return string10;
        }
        if (!AbstractC13042fc3.d(abstractC22884vz0, AbstractC22884vz0.b.c.d) && !AbstractC13042fc3.d(abstractC22884vz0, AbstractC22884vz0.b.a.d) && !AbstractC13042fc3.d(abstractC22884vz0, AbstractC22884vz0.b.e.d) && !AbstractC13042fc3.d(abstractC22884vz0, AbstractC22884vz0.b.d.d)) {
            throw new NoWhenBranchMatchedException();
        }
        String string11 = resources.getString(abstractC22884vz0.a());
        AbstractC13042fc3.h(string11, "getString(...)");
        return string11;
    }
}
