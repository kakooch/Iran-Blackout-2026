package j$.time.temporal;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class j {
    public static int a(k kVar, l lVar) {
        x xVarB = kVar.b(lVar);
        if (!xVarB.g()) {
            throw new w("Invalid field " + lVar + " for get() method, use getLong() instead");
        }
        long jC = kVar.c(lVar);
        if (xVarB.h(jC)) {
            return (int) jC;
        }
        throw new j$.time.c("Invalid value for " + lVar + " (valid values " + xVarB + "): " + jC);
    }

    public static Object b(k kVar, u uVar) {
        int i = t.a;
        if (uVar == m.a || uVar == n.a || uVar == o.a) {
            return null;
        }
        return uVar.a(kVar);
    }

    public static x c(k kVar, l lVar) {
        if (!(lVar instanceof a)) {
            if (lVar != null) {
                return lVar.e(kVar);
            }
            throw new NullPointerException("field");
        }
        if (kVar.e(lVar)) {
            return lVar.a();
        }
        throw new w("Unsupported field: " + lVar);
    }
}
