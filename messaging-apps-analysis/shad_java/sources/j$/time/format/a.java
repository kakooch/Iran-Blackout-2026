package j$.time.format;

import j$.time.ZoneOffset;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements j$.time.temporal.u {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // j$.time.temporal.u
    public final Object a(j$.time.temporal.k kVar) {
        int i = f.f;
        int i2 = j$.time.temporal.t.a;
        j$.time.l lVar = (j$.time.l) kVar.d(j$.time.temporal.m.a);
        if (lVar == null || (lVar instanceof ZoneOffset)) {
            return null;
        }
        return lVar;
    }
}
