package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.aA0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9559aA0 {
    public static final C8942Xx0 a(int i) {
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(i);
        if (c14733iO2 == null) {
            return new C8942Xx0(0, "", null, true);
        }
        int iR = c14733iO2.r();
        Object objB = c14733iO2.v().b();
        AbstractC13042fc3.h(objB, "get(...)");
        return new C8942Xx0(iR, (String) objB, (Avatar) c14733iO2.j().b(), true);
    }
}
