package ir.nasim;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ir.nasim.vl3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C22745vl3 extends MI3 {
    Logger a;

    public C22745vl3(String str) {
        this.a = Logger.getLogger(str);
    }

    @Override // ir.nasim.MI3
    public void b(String str) {
        this.a.log(Level.FINE, str);
    }
}
