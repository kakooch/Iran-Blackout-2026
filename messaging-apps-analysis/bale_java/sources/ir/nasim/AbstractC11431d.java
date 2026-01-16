package ir.nasim;

import okhttp3.Call;

/* renamed from: ir.nasim.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11431d {
    public static final Object a(Call call, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        C21573tm1 c21573tm1 = new C21573tm1(call, ie0);
        call.enqueue(c21573tm1);
        ie0.J(c21573tm1);
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }
}
