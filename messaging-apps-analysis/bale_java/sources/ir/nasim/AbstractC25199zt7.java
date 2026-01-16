package ir.nasim;

import ir.nasim.AbstractC21649tt7;

/* renamed from: ir.nasim.zt7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC25199zt7 extends AbstractC17794na2 {
    private final AbstractC21649tt7 a;

    /* renamed from: ir.nasim.zt7$a */
    public static final class a extends AbstractC25199zt7 {
        private final AbstractC21649tt7.h b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC21649tt7 abstractC21649tt7, AbstractC21649tt7.h hVar) {
            super(abstractC21649tt7, null);
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(hVar, "streamState");
            this.b = hVar;
        }

        public final AbstractC21649tt7.h getStreamState() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.zt7$b */
    public static final class b extends AbstractC25199zt7 {
        private final AbstractC21649tt7.e b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC21649tt7 abstractC21649tt7, AbstractC21649tt7.e eVar) {
            super(abstractC21649tt7, null);
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            AbstractC13042fc3.i(eVar, "newDimensions");
            this.b = eVar;
        }

        public final AbstractC21649tt7.e a() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.zt7$c */
    public static final class c extends AbstractC25199zt7 {
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC21649tt7 abstractC21649tt7, boolean z) {
            super(abstractC21649tt7, null);
            AbstractC13042fc3.i(abstractC21649tt7, "track");
            this.b = z;
        }

        public final boolean a() {
            return this.b;
        }
    }

    public /* synthetic */ AbstractC25199zt7(AbstractC21649tt7 abstractC21649tt7, ED1 ed1) {
        this(abstractC21649tt7);
    }

    public final AbstractC21649tt7 getTrack() {
        return this.a;
    }

    private AbstractC25199zt7(AbstractC21649tt7 abstractC21649tt7) {
        super(null);
        this.a = abstractC21649tt7;
    }
}
