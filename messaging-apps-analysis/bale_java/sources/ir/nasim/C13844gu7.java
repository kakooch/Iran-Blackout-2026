package ir.nasim;

import java.util.EventObject;

/* renamed from: ir.nasim.gu7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C13844gu7 extends EventObject {
    private boolean a;
    private InterfaceC5278Iq6 b;
    private CV0 c;

    public C13844gu7(Object obj, InterfaceC5278Iq6 interfaceC5278Iq6) {
        super(obj);
        this.c = null;
        this.b = interfaceC5278Iq6;
        this.a = true;
    }

    public CV0 a() {
        return this.c;
    }

    public InterfaceC5278Iq6 b() {
        return this.b;
    }

    public C13844gu7(Object obj, CV0 cv0) {
        super(obj);
        this.b = null;
        this.c = cv0;
        this.a = false;
    }
}
