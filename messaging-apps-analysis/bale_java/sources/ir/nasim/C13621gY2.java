package ir.nasim;

import ir.nasim.AbstractC20754sY7;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.gY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13621gY2 {
    private final b a = new b();

    /* renamed from: ir.nasim.gY2$a */
    private final class a {
        private AbstractC20754sY7 a;
        private final InterfaceC8327Vm4 b = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);

        public a() {
        }

        public final InterfaceC4557Fq2 a() {
            return this.b;
        }

        public final AbstractC20754sY7 b() {
            return this.a;
        }

        public final void c(AbstractC20754sY7 abstractC20754sY7) {
            this.a = abstractC20754sY7;
            if (abstractC20754sY7 != null) {
                this.b.c(abstractC20754sY7);
            }
        }
    }

    /* renamed from: ir.nasim.gY2$b */
    private final class b {
        private final a a;
        private final a b;
        private AbstractC20754sY7.a c;
        private final ReentrantLock d = new ReentrantLock();

        public b() {
            this.a = C13621gY2.this.new a();
            this.b = C13621gY2.this.new a();
        }

        public final InterfaceC4557Fq2 a() {
            return this.b.a();
        }

        public final AbstractC20754sY7.a b() {
            return this.c;
        }

        public final InterfaceC4557Fq2 c() {
            return this.a.a();
        }

        public final void d(AbstractC20754sY7.a aVar, InterfaceC14603iB2 interfaceC14603iB2) {
            AbstractC13042fc3.i(interfaceC14603iB2, "block");
            ReentrantLock reentrantLock = this.d;
            try {
                reentrantLock.lock();
                if (aVar != null) {
                    this.c = aVar;
                }
                interfaceC14603iB2.invoke(this.a, this.b);
                C19938rB7 c19938rB7 = C19938rB7.a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.gY2$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.gY2$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ EnumC16433lG3 e;
        final /* synthetic */ AbstractC20754sY7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(EnumC16433lG3 enumC16433lG3, AbstractC20754sY7 abstractC20754sY7) {
            super(2);
            this.e = enumC16433lG3;
            this.f = abstractC20754sY7;
        }

        public final void a(a aVar, a aVar2) {
            AbstractC13042fc3.i(aVar, "prependHint");
            AbstractC13042fc3.i(aVar2, "appendHint");
            if (this.e == EnumC16433lG3.PREPEND) {
                aVar.c(this.f);
            } else {
                aVar2.c(this.f);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((a) obj, (a) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gY2$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ AbstractC20754sY7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(AbstractC20754sY7 abstractC20754sY7) {
            super(2);
            this.e = abstractC20754sY7;
        }

        public final void a(a aVar, a aVar2) {
            AbstractC13042fc3.i(aVar, "prependHint");
            AbstractC13042fc3.i(aVar2, "appendHint");
            if (AbstractC14212hY2.a(this.e, aVar.b(), EnumC16433lG3.PREPEND)) {
                aVar.c(this.e);
            }
            if (AbstractC14212hY2.a(this.e, aVar2.b(), EnumC16433lG3.APPEND)) {
                aVar2.c(this.e);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((a) obj, (a) obj2);
            return C19938rB7.a;
        }
    }

    public final void a(EnumC16433lG3 enumC16433lG3, AbstractC20754sY7 abstractC20754sY7) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        AbstractC13042fc3.i(abstractC20754sY7, "viewportHint");
        if (enumC16433lG3 == EnumC16433lG3.PREPEND || enumC16433lG3 == EnumC16433lG3.APPEND) {
            this.a.d(null, new d(enumC16433lG3, abstractC20754sY7));
            return;
        }
        throw new IllegalArgumentException(("invalid load type for reset: " + enumC16433lG3).toString());
    }

    public final AbstractC20754sY7.a b() {
        return this.a.b();
    }

    public final InterfaceC4557Fq2 c(EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        int i = c.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            return this.a.c();
        }
        if (i == 2) {
            return this.a.a();
        }
        throw new IllegalArgumentException("invalid load type for hints");
    }

    public final void d(AbstractC20754sY7 abstractC20754sY7) {
        AbstractC13042fc3.i(abstractC20754sY7, "viewportHint");
        this.a.d(abstractC20754sY7 instanceof AbstractC20754sY7.a ? (AbstractC20754sY7.a) abstractC20754sY7 : null, new e(abstractC20754sY7));
    }
}
