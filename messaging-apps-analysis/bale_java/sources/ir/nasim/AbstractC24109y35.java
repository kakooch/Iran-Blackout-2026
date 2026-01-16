package ir.nasim;

import com.google.android.gms.common.api.Status;

/* renamed from: ir.nasim.y35, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24109y35 {
    public static AbstractC22929w35 a(InterfaceC10069b16 interfaceC10069b16, com.google.android.gms.common.api.c cVar) {
        AbstractC3795Cj5.k(interfaceC10069b16, "Result must not be null");
        AbstractC3795Cj5.b(!interfaceC10069b16.j().x0(), "Status code must not be SUCCESS");
        Ef8 ef8 = new Ef8(cVar, interfaceC10069b16);
        ef8.setResult(interfaceC10069b16);
        return ef8;
    }

    public static AbstractC22929w35 b(Status status, com.google.android.gms.common.api.c cVar) {
        AbstractC3795Cj5.k(status, "Result must not be null");
        C21922uM6 c21922uM6 = new C21922uM6(cVar);
        c21922uM6.setResult(status);
        return c21922uM6;
    }
}
