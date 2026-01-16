package j$.time.format;

/* loaded from: classes2.dex */
final class n implements g {
    private final j$.time.temporal.l a;
    private final u b;
    private final b c;
    private volatile j d;

    n(j$.time.temporal.l lVar, u uVar, b bVar) {
        this.a = lVar;
        this.b = uVar;
        this.c = bVar;
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        String strA;
        j$.time.chrono.h hVar;
        Long lE = qVar.e(this.a);
        if (lE == null) {
            return false;
        }
        j$.time.temporal.k kVarD = qVar.d();
        int i = j$.time.temporal.t.a;
        j$.time.chrono.g gVar = (j$.time.chrono.g) kVarD.d(j$.time.temporal.n.a);
        if (gVar == null || gVar == (hVar = j$.time.chrono.h.a)) {
            b bVar = this.c;
            long jLongValue = lE.longValue();
            u uVar = this.b;
            qVar.c();
            strA = bVar.a.a(jLongValue, uVar);
        } else {
            b bVar2 = this.c;
            j$.time.temporal.l lVar = this.a;
            long jLongValue2 = lE.longValue();
            u uVar2 = this.b;
            qVar.c();
            bVar2.getClass();
            strA = (gVar == hVar || !(lVar instanceof j$.time.temporal.a)) ? bVar2.a.a(jLongValue2, uVar2) : null;
        }
        if (strA != null) {
            sb.append(strA);
            return true;
        }
        if (this.d == null) {
            this.d = new j(this.a, 1, 19, t.NORMAL);
        }
        return this.d.a(qVar, sb);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        if (this.b == u.FULL) {
            sb = new StringBuilder();
            sb.append("Text(");
            obj = this.a;
        } else {
            sb = new StringBuilder();
            sb.append("Text(");
            sb.append(this.a);
            sb.append(",");
            obj = this.b;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
