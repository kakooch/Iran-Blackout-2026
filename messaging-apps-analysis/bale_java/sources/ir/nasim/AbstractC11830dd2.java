package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.dd2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11830dd2 extends AbstractC13778go1 implements Closeable {
    public static final a c = new a(null);

    /* renamed from: ir.nasim.dd2$a */
    public static final class a extends M0 {

        /* renamed from: ir.nasim.dd2$a$a, reason: collision with other inner class name */
        static final class C1017a extends AbstractC8614Ws3 implements UA2 {
            public static final C1017a e = new C1017a();

            C1017a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC11830dd2 invoke(InterfaceC11938do1.b bVar) {
                if (bVar instanceof AbstractC11830dd2) {
                    return (AbstractC11830dd2) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        private a() {
            super(AbstractC13778go1.b, C1017a.e);
        }
    }

    public abstract Executor C0();
}
