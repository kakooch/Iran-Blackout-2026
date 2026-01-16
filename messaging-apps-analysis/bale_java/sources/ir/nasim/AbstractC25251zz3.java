package ir.nasim;

import android.database.Cursor;
import ir.nasim.YT4;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.zz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25251zz3 extends YT4 {
    private final O26 b;
    private final D26 c;
    private final AtomicInteger d;
    private final C13203fp7 e;

    /* renamed from: ir.nasim.zz3$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ YT4.a d;

        /* renamed from: ir.nasim.zz3$a$a, reason: collision with other inner class name */
        /* synthetic */ class C1827a extends EB2 implements UA2 {
            C1827a(Object obj) {
                super(1, obj, AbstractC25251zz3.class, "convertRows", "convertRows(Landroid/database/Cursor;)Ljava/util/List;", 0);
            }

            @Override // ir.nasim.UA2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final List invoke(Cursor cursor) {
                AbstractC13042fc3.i(cursor, "p0");
                return ((AbstractC25251zz3) this.receiver).n(cursor);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC25251zz3.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            int iG = L26.g(AbstractC25251zz3.this.b, AbstractC25251zz3.this.c);
            AbstractC25251zz3.this.o().set(iG);
            return L26.f(this.d, AbstractC25251zz3.this.b, AbstractC25251zz3.this.c, iG, null, new C1827a(AbstractC25251zz3.this), 16, null);
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zz3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ YT4.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC25251zz3.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i != 0) {
                    if (i == 1) {
                        AbstractC10685c16.b(obj);
                        return (YT4.b) obj;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (YT4.b) obj;
                }
                AbstractC10685c16.b(obj);
                AbstractC25251zz3.this.e.d(AbstractC25251zz3.this.c);
                int i2 = AbstractC25251zz3.this.o().get();
                if (i2 == -1) {
                    AbstractC25251zz3 abstractC25251zz3 = AbstractC25251zz3.this;
                    YT4.a aVar = this.d;
                    this.b = 1;
                    obj = abstractC25251zz3.q(aVar, this);
                    if (obj == objE) {
                        return objE;
                    }
                    return (YT4.b) obj;
                }
                AbstractC25251zz3 abstractC25251zz32 = AbstractC25251zz3.this;
                YT4.a aVar2 = this.d;
                this.b = 2;
                obj = abstractC25251zz32.s(aVar2, i2, this);
                if (obj == objE) {
                    return objE;
                }
                return (YT4.b) obj;
            } catch (Exception e) {
                return new YT4.b.a(e);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zz3$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, AbstractC25251zz3.class, "convertRows", "convertRows(Landroid/database/Cursor;)Ljava/util/List;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final List invoke(Cursor cursor) {
            AbstractC13042fc3.i(cursor, "p0");
            return ((AbstractC25251zz3) this.receiver).n(cursor);
        }
    }

    /* renamed from: ir.nasim.zz3$d */
    /* synthetic */ class d extends EB2 implements SA2 {
        d(Object obj) {
            super(0, obj, AbstractC25251zz3.class, "invalidate", "invalidate()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((AbstractC25251zz3) this.receiver).e();
        }
    }

    public AbstractC25251zz3(O26 o26, D26 d26, String... strArr) {
        AbstractC13042fc3.i(o26, "sourceQuery");
        AbstractC13042fc3.i(d26, "db");
        AbstractC13042fc3.i(strArr, "tables");
        this.b = o26;
        this.c = d26;
        this.d = new AtomicInteger(-1);
        this.e = new C13203fp7(strArr, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.f.d(this.c, new a(aVar, null), interfaceC20295rm1);
    }

    static /* synthetic */ Object r(AbstractC25251zz3 abstractC25251zz3, YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(AbstractC5957Lo1.a(abstractC25251zz3.c), abstractC25251zz3.new b(aVar, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(YT4.a aVar, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        YT4.b bVarF = L26.f(aVar, this.b, this.c, i, null, new c(this), 16, null);
        this.c.n().o();
        if (!a()) {
            return bVarF;
        }
        YT4.b.C0792b c0792bB = L26.b();
        AbstractC13042fc3.g(c0792bB, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Invalid<kotlin.Int, Value of androidx.room.paging.LimitOffsetPagingSource>");
        return c0792bB;
    }

    @Override // ir.nasim.YT4
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.YT4
    public Object f(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return r(this, aVar, interfaceC20295rm1);
    }

    protected abstract List n(Cursor cursor);

    public final AtomicInteger o() {
        return this.d;
    }

    @Override // ir.nasim.YT4
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return L26.a(zt4);
    }
}
