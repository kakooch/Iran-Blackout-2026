package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Ht7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5072Ht7 extends AbstractC17794na2 {
    private final AbstractC4838Gt7 a;

    /* renamed from: ir.nasim.Ht7$a */
    public static final class a extends AbstractC5072Ht7 {
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC4838Gt7 abstractC4838Gt7, List list) {
            super(abstractC4838Gt7, null);
            AbstractC13042fc3.i(abstractC4838Gt7, "publication");
            AbstractC13042fc3.i(list, "transcriptions");
            this.b = list;
        }
    }

    public /* synthetic */ AbstractC5072Ht7(AbstractC4838Gt7 abstractC4838Gt7, ED1 ed1) {
        this(abstractC4838Gt7);
    }

    private AbstractC5072Ht7(AbstractC4838Gt7 abstractC4838Gt7) {
        super(null);
        this.a = abstractC4838Gt7;
    }
}
