package ir.nasim;

import androidx.work.OverwritingInputMerger;
import ir.nasim.AbstractC16037kb8;

/* loaded from: classes2.dex */
public final class PK4 extends AbstractC16037kb8 {
    PK4(a aVar) {
        super(aVar.b, aVar.c, aVar.d);
    }

    public static PK4 d(Class cls) {
        return (PK4) new a(cls).b();
    }

    public static final class a extends AbstractC16037kb8.a {
        public a(Class cls) {
            super(cls);
            this.c.d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC16037kb8.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public PK4 c() {
            if (this.a && this.c.j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new PK4(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC16037kb8.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }
}
