package ir.nasim;

import ir.nasim.InterfaceC14190hV7;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.oG3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18206oG3 {
    private final InterfaceC12532em2 a;
    private final IT7 b;
    private final AbstractC13778go1 c;

    /* renamed from: ir.nasim.oG3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ FileReference e;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FileReference fileReference, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = fileReference;
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18206oG3.this.new a(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String descriptor;
            String str;
            String str2;
            InterfaceC3346Am2 interfaceC3346Am2A;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC12532em2 interfaceC12532em2 = C18206oG3.this.a;
                long fileId = this.e.getFileId();
                long accessHash = this.e.getAccessHash();
                this.c = 1;
                obj = interfaceC12532em2.l(fileId, accessHash, true, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) this.b;
                    AbstractC10685c16.b(obj);
                    str = (String) obj;
                    descriptor = str2;
                    return new InterfaceC14190hV7.a(descriptor, str);
                }
                AbstractC10685c16.b(obj);
            }
            RY1 ry1 = (RY1) obj;
            boolean z = ry1 instanceof RY1.a;
            RY1.a aVar = z ? (RY1.a) ry1 : null;
            descriptor = (aVar == null || (interfaceC3346Am2A = aVar.a()) == null) ? null : interfaceC3346Am2A.getDescriptor();
            if (descriptor == null || AbstractC20762sZ6.n0(descriptor)) {
                return new InterfaceC14190hV7.b(this.e.getFileId(), this.e.getFileSize(), this.e.getFileName(), this.e.getAccessHash(), z, C18206oG3.this.b.a(this.e.getFileId(), this.e.getAccessHash()), this.f);
            }
            str = this.f;
            if (str == null) {
                C18206oG3 c18206oG3 = C18206oG3.this;
                this.b = descriptor;
                this.c = 2;
                Object objE2 = c18206oG3.e(descriptor, this);
                if (objE2 == objE) {
                    return objE;
                }
                str2 = descriptor;
                obj = objE2;
                str = (String) obj;
                descriptor = str2;
            }
            return new InterfaceC14190hV7.a(descriptor, str);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oG3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String strO = C6906Pm2.o(this.c);
            return strO == null ? "" : strO;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18206oG3(InterfaceC12532em2 interfaceC12532em2, IT7 it7, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC12532em2;
        this.b = it7;
        this.c = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new b(str, null), interfaceC20295rm1);
    }

    public final Object d(FileReference fileReference, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new a(fileReference, str, null), interfaceC20295rm1);
    }
}
