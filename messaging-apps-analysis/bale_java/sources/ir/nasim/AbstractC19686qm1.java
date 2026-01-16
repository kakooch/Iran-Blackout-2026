package ir.nasim;

import java.util.List;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.qm1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19686qm1 {

    /* renamed from: ir.nasim.qm1$a */
    public static final class a extends AbstractC19686qm1 {
        private final KSerializer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KSerializer kSerializer) {
            super(null);
            AbstractC13042fc3.i(kSerializer, "serializer");
            this.a = kSerializer;
        }

        @Override // ir.nasim.AbstractC19686qm1
        public KSerializer a(List list) {
            AbstractC13042fc3.i(list, "typeArgumentsSerializers");
            return this.a;
        }

        public final KSerializer b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC13042fc3.d(((a) obj).a, this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.qm1$b */
    public static final class b extends AbstractC19686qm1 {
        private final UA2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UA2 ua2) {
            super(null);
            AbstractC13042fc3.i(ua2, "provider");
            this.a = ua2;
        }

        @Override // ir.nasim.AbstractC19686qm1
        public KSerializer a(List list) {
            AbstractC13042fc3.i(list, "typeArgumentsSerializers");
            return (KSerializer) this.a.invoke(list);
        }

        public final UA2 b() {
            return this.a;
        }
    }

    private AbstractC19686qm1() {
    }

    public abstract KSerializer a(List list);

    public /* synthetic */ AbstractC19686qm1(ED1 ed1) {
        this();
    }
}
