package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.e78, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12154e78 extends AbstractC12724f57 {
    public String b;
    public I57 c;
    public ArrayList d;
    public int e;
    public String f;

    public static C12154e78 d(AbstractC24495yi7 abstractC24495yi7) {
        if (!(abstractC24495yi7 instanceof C9294Zh7)) {
            return null;
        }
        C12154e78 c12154e78 = new C12154e78();
        C9294Zh7 c9294Zh7 = (C9294Zh7) abstractC24495yi7;
        T97 t97 = new T97();
        c12154e78.c = t97;
        String str = abstractC24495yi7.b;
        c12154e78.b = str;
        t97.b = str;
        t97.c = c9294Zh7.c;
        c12154e78.e = c9294Zh7.d;
        c12154e78.f = c9294Zh7.e;
        c12154e78.d = c9294Zh7.f;
        return c12154e78;
    }
}
