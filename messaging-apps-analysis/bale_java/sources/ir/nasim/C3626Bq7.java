package ir.nasim;

import java.util.EventObject;

/* renamed from: ir.nasim.Bq7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3626Bq7 extends EventObject {
    private C25169zq7 a;
    private boolean b;
    private InterfaceC5278Iq6 c;
    private CV0 d;

    public C3626Bq7(Object obj, InterfaceC5278Iq6 interfaceC5278Iq6, C25169zq7 c25169zq7) {
        super(obj);
        this.d = null;
        this.c = interfaceC5278Iq6;
        this.b = true;
        this.a = c25169zq7;
    }

    public C3626Bq7(Object obj, CV0 cv0, C25169zq7 c25169zq7) {
        super(obj);
        this.c = null;
        this.d = cv0;
        this.b = false;
        this.a = c25169zq7;
    }
}
