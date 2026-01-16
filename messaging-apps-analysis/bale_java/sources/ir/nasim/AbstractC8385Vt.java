package ir.nasim;

/* renamed from: ir.nasim.Vt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8385Vt {
    public static final C7210Qt a(float f) {
        return new C7210Qt(f);
    }

    public static final C7444Rt b(float f, float f2) {
        return new C7444Rt(f, f2);
    }

    public static final C7678St c(float f, float f2, float f3) {
        return new C7678St(f, f2, f3);
    }

    public static final C7917Tt d(float f, float f2, float f3, float f4) {
        return new C7917Tt(f, f2, f3, f4);
    }

    public static final AbstractC8151Ut e(AbstractC8151Ut abstractC8151Ut) {
        AbstractC8151Ut abstractC8151UtG = g(abstractC8151Ut);
        int iB = abstractC8151UtG.b();
        for (int i = 0; i < iB; i++) {
            abstractC8151UtG.e(i, abstractC8151Ut.a(i));
        }
        return abstractC8151UtG;
    }

    public static final void f(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2) {
        int iB = abstractC8151Ut.b();
        for (int i = 0; i < iB; i++) {
            abstractC8151Ut.e(i, abstractC8151Ut2.a(i));
        }
    }

    public static final AbstractC8151Ut g(AbstractC8151Ut abstractC8151Ut) {
        AbstractC8151Ut abstractC8151UtC = abstractC8151Ut.c();
        AbstractC13042fc3.g(abstractC8151UtC, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return abstractC8151UtC;
    }
}
