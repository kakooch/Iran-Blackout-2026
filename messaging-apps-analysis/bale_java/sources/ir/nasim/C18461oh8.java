package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.oh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18461oh8 {
    private C16097kh8 a;
    private C16097kh8 b;
    private final List c;

    public C18461oh8() {
        this.a = new C16097kh8("", 0L, null);
        this.b = new C16097kh8("", 0L, null);
        this.c = new ArrayList();
    }

    public final C16097kh8 a() {
        return this.a;
    }

    public final C16097kh8 b() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        C18461oh8 c18461oh8 = new C18461oh8(this.a.clone());
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c18461oh8.c.add(((C16097kh8) it.next()).clone());
        }
        return c18461oh8;
    }

    public final void d(C16097kh8 c16097kh8) {
        this.a = c16097kh8;
        this.b = c16097kh8.clone();
        this.c.clear();
    }

    public final void e(String str, long j, Map map) {
        this.c.add(new C16097kh8(str, j, map));
    }

    public final void f(C16097kh8 c16097kh8) {
        this.b = c16097kh8;
    }

    public C18461oh8(C16097kh8 c16097kh8) {
        this.a = c16097kh8;
        this.b = c16097kh8.clone();
        this.c = new ArrayList();
    }
}
