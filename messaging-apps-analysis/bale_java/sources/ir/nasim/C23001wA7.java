package ir.nasim;

import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import ir.nasim.AbstractC13406gA3;
import ir.nasim.C13245fu;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.wA7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23001wA7 {
    private final WeakHashMap a = new WeakHashMap();
    private final WeakHashMap b = new WeakHashMap();
    private final WeakHashMap c = new WeakHashMap();

    public final ClickableSpan a(C13245fu.d dVar) {
        WeakHashMap weakHashMap = this.c;
        Object c8450Wa1 = weakHashMap.get(dVar);
        if (c8450Wa1 == null) {
            c8450Wa1 = new C8450Wa1((AbstractC13406gA3) dVar.g());
            weakHashMap.put(dVar, c8450Wa1);
        }
        return (ClickableSpan) c8450Wa1;
    }

    public final URLSpan b(C13245fu.d dVar) {
        WeakHashMap weakHashMap = this.b;
        Object uRLSpan = weakHashMap.get(dVar);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(((AbstractC13406gA3.b) dVar.g()).c());
            weakHashMap.put(dVar, uRLSpan);
        }
        return (URLSpan) uRLSpan;
    }

    public final URLSpan c(C12255eI7 c12255eI7) {
        WeakHashMap weakHashMap = this.a;
        Object uRLSpan = weakHashMap.get(c12255eI7);
        if (uRLSpan == null) {
            uRLSpan = new URLSpan(c12255eI7.a());
            weakHashMap.put(c12255eI7, uRLSpan);
        }
        return (URLSpan) uRLSpan;
    }
}
