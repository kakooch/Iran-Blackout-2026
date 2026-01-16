package j$.time.format;

/* loaded from: classes2.dex */
class o implements g {
    o(j$.time.temporal.u uVar, String str) {
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        j$.time.l lVar = (j$.time.l) qVar.f(a.a);
        if (lVar == null) {
            return false;
        }
        sb.append(lVar.f());
        return true;
    }

    public String toString() {
        return "ZoneRegionId()";
    }
}
