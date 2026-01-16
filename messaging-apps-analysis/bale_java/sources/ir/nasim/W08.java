package ir.nasim;

import ir.nasim.tgwidgets.editor.messenger.MediaController;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class W08 implements U08 {
    private final AbstractC13778go1 a;
    private final InterfaceC9173Yu3 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return W08.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            MediaController.Y().startRecord(this.d, this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return W08.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            MediaController.Y().stopRecord();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int d;
        final /* synthetic */ byte[] e;
        final /* synthetic */ W08 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, byte[] bArr, W08 w08, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = bArr;
            this.f = w08;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            int iLimit;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.d);
            byteBufferAllocateDirect.put(this.e, 0, this.d);
            byteBufferAllocateDirect.rewind();
            while (AbstractC20906so1.g(interfaceC20315ro1) && byteBufferAllocateDirect.hasRemaining()) {
                if (byteBufferAllocateDirect.remaining() > this.f.g().remaining()) {
                    iLimit = byteBufferAllocateDirect.limit();
                    byteBufferAllocateDirect.limit(this.f.g().remaining() + byteBufferAllocateDirect.position());
                } else {
                    iLimit = -1;
                }
                this.f.g().put(byteBufferAllocateDirect);
                if (this.f.g().position() == this.f.g().limit()) {
                    if (MediaController.Y().writeFrame(this.f.g(), this.f.g().limit()) != 0) {
                        this.f.g().rewind();
                    }
                }
                if (iLimit != -1) {
                    byteBufferAllocateDirect.limit(iLimit);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public W08(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = abstractC13778go1;
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.V08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return W08.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteBuffer f() {
        return ByteBuffer.allocateDirect(1920);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ByteBuffer g() {
        return (ByteBuffer) this.b.getValue();
    }

    @Override // ir.nasim.U08
    public Object a(byte[] bArr, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new c(i, bArr, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.U08
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new b(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.U08
    public Object c(String str, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new a(str, i, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
