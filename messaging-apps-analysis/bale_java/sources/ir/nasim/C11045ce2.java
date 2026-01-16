package ir.nasim;

import com.google.android.exoplayer2.InterfaceC2037k;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14190hV7;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ce2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11045ce2 {
    private final InterfaceC12532em2 a;
    private final PF2 b;
    private final IT7 c;
    private final InterfaceC20315ro1 d;
    private final AbstractC13778go1 e;
    private final AbstractC13778go1 f;
    private final C14801iV7 g;
    private final ConcurrentHashMap h;

    /* renamed from: ir.nasim.ce2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11045ce2.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC3346Am2 interfaceC3346Am2A;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC12532em2 interfaceC12532em2 = C11045ce2.this.a;
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                this.b = 1;
                obj = interfaceC12532em2.l(fileId, accessHash, true, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            RY1 ry1 = (RY1) obj;
            boolean z = ry1 instanceof RY1.a;
            RY1.a aVar = z ? (RY1.a) ry1 : null;
            String descriptor = (aVar == null || (interfaceC3346Am2A = aVar.a()) == null) ? null : interfaceC3346Am2A.getDescriptor();
            return (descriptor == null || AbstractC20762sZ6.n0(descriptor)) ? new InterfaceC14190hV7.b(this.d.getFileId(), this.d.getFileSize(), this.d.getFileName(), this.d.getAccessHash(), z, C11045ce2.this.c.a(this.d.getFileId(), this.d.getAccessHash()), null) : new InterfaceC14190hV7.a(descriptor, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ce2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC2037k c;
        final /* synthetic */ C11045ce2 d;
        final /* synthetic */ InterfaceC14190hV7 e;
        final /* synthetic */ String f;
        final /* synthetic */ EnumC8893Xt7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC2037k interfaceC2037k, C11045ce2 c11045ce2, InterfaceC14190hV7 interfaceC14190hV7, String str, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC2037k;
            this.d = c11045ce2;
            this.e = interfaceC14190hV7;
            this.f = str;
            this.g = enumC8893Xt7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.d(this.d.g.a(((InterfaceC14190hV7.a) this.e).a(), (InterfaceC14190hV7.a) this.e, this.f, this.g, new OT7()));
            this.c.r();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ce2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14190hV7 d;
        final /* synthetic */ InterfaceC2037k e;
        final /* synthetic */ String f;
        final /* synthetic */ EnumC8893Xt7 g;

        /* renamed from: ir.nasim.ce2$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC2037k c;
            final /* synthetic */ C11045ce2 d;
            final /* synthetic */ InterfaceC14190hV7 e;
            final /* synthetic */ String f;
            final /* synthetic */ EnumC8893Xt7 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC2037k interfaceC2037k, C11045ce2 c11045ce2, InterfaceC14190hV7 interfaceC14190hV7, String str, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC2037k;
                this.d = c11045ce2;
                this.e = interfaceC14190hV7;
                this.f = str;
                this.g = enumC8893Xt7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.d(this.d.g.a(null, (InterfaceC14190hV7.b) this.e, this.f, this.g, new OT7()));
                this.c.r();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ce2$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C11045ce2 d;
            final /* synthetic */ InterfaceC2037k e;
            final /* synthetic */ InterfaceC14190hV7 f;
            final /* synthetic */ String g;
            final /* synthetic */ EnumC8893Xt7 h;

            /* renamed from: ir.nasim.ce2$c$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC2037k c;
                final /* synthetic */ C11045ce2 d;
                final /* synthetic */ InterfaceC14190hV7 e;
                final /* synthetic */ String f;
                final /* synthetic */ String g;
                final /* synthetic */ EnumC8893Xt7 h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(InterfaceC2037k interfaceC2037k, C11045ce2 c11045ce2, InterfaceC14190hV7 interfaceC14190hV7, String str, String str2, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC2037k;
                    this.d = c11045ce2;
                    this.e = interfaceC14190hV7;
                    this.f = str;
                    this.g = str2;
                    this.h = enumC8893Xt7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.z0(this.d.g.a(this.f, (InterfaceC14190hV7.b) this.e, this.g, this.h, new OT7()), false);
                    this.c.r();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C11045ce2 c11045ce2, InterfaceC2037k interfaceC2037k, InterfaceC14190hV7 interfaceC14190hV7, String str, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c11045ce2;
                this.e = interfaceC2037k;
                this.f = interfaceC14190hV7;
                this.g = str;
                this.h = enumC8893Xt7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    String str = (String) this.c;
                    AbstractC13778go1 abstractC13778go1 = this.d.f;
                    a aVar = new a(this.e, this.d, this.f, str, this.g, this.h, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC14190hV7 interfaceC14190hV7, InterfaceC2037k interfaceC2037k, String str, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14190hV7;
            this.e = interfaceC2037k;
            this.f = str;
            this.g = enumC8893Xt7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11045ce2.this.new c(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }
            AbstractC10685c16.b(obj);
            C11045ce2.this.c.a(((InterfaceC14190hV7.b) this.d).c(), ((InterfaceC14190hV7.b) this.d).b());
            if (((InterfaceC14190hV7.b) this.d).e()) {
                AbstractC13778go1 abstractC13778go1 = C11045ce2.this.f;
                a aVar = new a(this.e, C11045ce2.this, this.d, this.f, this.g, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }
            InterfaceC4557Fq2 interfaceC4557Fq2I = C11045ce2.this.b.i(((InterfaceC14190hV7.b) this.d).c(), ((InterfaceC14190hV7.b) this.d).b());
            b bVar = new b(C11045ce2.this, this.e, this.d, this.f, this.g, null);
            this.b = 2;
            if (AbstractC6459Nq2.l(interfaceC4557Fq2I, bVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ce2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;
        final /* synthetic */ InterfaceC2037k e;
        final /* synthetic */ String f;
        final /* synthetic */ EnumC8893Xt7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(FileReference fileReference, InterfaceC2037k interfaceC2037k, String str, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
            this.e = interfaceC2037k;
            this.f = str;
            this.g = enumC8893Xt7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11045ce2.this.new d(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11045ce2 c11045ce2 = C11045ce2.this;
                FileReference fileReference = this.d;
                this.b = 1;
                obj = c11045ce2.j(fileReference, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            C11045ce2 c11045ce22 = C11045ce2.this;
            InterfaceC2037k interfaceC2037k = this.e;
            String str = this.f;
            EnumC8893Xt7 enumC8893Xt7 = this.g;
            this.b = 2;
            if (c11045ce22.k(interfaceC2037k, str, (InterfaceC14190hV7) obj, enumC8893Xt7, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11045ce2(InterfaceC12532em2 interfaceC12532em2, PF2 pf2, IT7 it7, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C14801iV7 c14801iV7) {
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(pf2, "getDownloadUrlUseCase");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(c14801iV7, "videoSourceToExoMediaSourceMapper");
        this.a = interfaceC12532em2;
        this.b = pf2;
        this.c = it7;
        this.d = interfaceC20315ro1;
        this.e = abstractC13778go1;
        this.f = abstractC13778go12;
        this.g = c14801iV7;
        this.h = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new a(fileReference, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(InterfaceC2037k interfaceC2037k, String str, InterfaceC14190hV7 interfaceC14190hV7, EnumC8893Xt7 enumC8893Xt7, InterfaceC20295rm1 interfaceC20295rm1) {
        if (interfaceC14190hV7 instanceof InterfaceC14190hV7.a) {
            Object objG = AbstractC9323Zl0.g(this.f, new b(interfaceC2037k, this, interfaceC14190hV7, str, enumC8893Xt7, null), interfaceC20295rm1);
            return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
        }
        if (!(interfaceC14190hV7 instanceof InterfaceC14190hV7.b)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objG2 = AbstractC9323Zl0.g(C12366eV1.b(), new c(interfaceC14190hV7, interfaceC2037k, str, enumC8893Xt7, null), interfaceC20295rm1);
        return objG2 == AbstractC14862ic3.e() ? objG2 : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(C11045ce2 c11045ce2, InterfaceC2037k interfaceC2037k, XV4 xv4, Throwable th) {
        AbstractC13042fc3.i(c11045ce2, "this$0");
        AbstractC13042fc3.i(interfaceC2037k, "$player");
        AbstractC13042fc3.i(xv4, "$pair");
        c11045ce2.h.remove(interfaceC2037k, xv4);
        return C19938rB7.a;
    }

    public final void i(InterfaceC2037k interfaceC2037k) {
        AbstractC13042fc3.i(interfaceC2037k, "player");
        XV4 xv4 = (XV4) this.h.remove(interfaceC2037k);
        if (xv4 != null) {
            InterfaceC13730gj3.a.a((InterfaceC13730gj3) xv4.b(), null, 1, null);
        }
    }

    public final void l(final InterfaceC2037k interfaceC2037k, String str, FileReference fileReference, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(interfaceC2037k, "player");
        AbstractC13042fc3.i(str, "mediaId");
        AbstractC13042fc3.i(fileReference, "fileReference");
        XV4 xv4 = (XV4) this.h.get(interfaceC2037k);
        if (xv4 != null) {
            FileReference fileReference2 = (FileReference) xv4.a();
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) xv4.b();
            if (n(fileReference, fileReference2)) {
                return;
            } else {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
        }
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.d, null, null, new d(fileReference, interfaceC2037k, str, enumC8893Xt7, null), 3, null);
        final XV4 xv4A = AbstractC4616Fw7.a(fileReference, interfaceC13730gj3D);
        this.h.put(interfaceC2037k, xv4A);
        interfaceC13730gj3D.s(new UA2() { // from class: ir.nasim.be2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11045ce2.m(this.a, interfaceC2037k, xv4A, (Throwable) obj);
            }
        });
    }

    public final boolean n(FileReference fileReference, FileReference fileReference2) {
        AbstractC13042fc3.i(fileReference, "<this>");
        AbstractC13042fc3.i(fileReference2, "other");
        return fileReference.getFileId() == fileReference2.getFileId() && fileReference.getFileSize() == fileReference2.getFileSize() && fileReference.getAccessHash() == fileReference2.getAccessHash();
    }
}
