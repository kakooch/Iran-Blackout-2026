package ir.nasim;

import ir.nasim.AbstractC15520jj2;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.fl, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13155fl {
    public static final String a(AbstractC15520jj2.b bVar) {
        AbstractC13042fc3.i(bVar, "<this>");
        for (AbstractC15520jj2.a aVar : bVar.c()) {
            if (!AbstractC20762sZ6.n0(aVar.b().c())) {
                return aVar.b().c();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
