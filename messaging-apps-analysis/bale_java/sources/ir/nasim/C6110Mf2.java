package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.Mf2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6110Mf2 extends AbstractC24083y1 {
    private final a c = new a();

    /* renamed from: ir.nasim.Mf2$a */
    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // ir.nasim.AbstractC24083y1
    public Random n() {
        Object obj = this.c.get();
        AbstractC13042fc3.h(obj, "get(...)");
        return (Random) obj;
    }
}
