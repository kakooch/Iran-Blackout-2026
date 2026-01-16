package ir.nasim;

import ir.nasim.C22007uW1;
import ir.nasim.LY1;
import ir.nasim.MW1;
import ir.nasim.MX1;
import ir.nasim.SS7;
import ir.nasim.SY1;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public class SS7 extends C22007uW1 {
    private boolean n;

    public static final class a implements InterfaceC8807Xk2 {
        final /* synthetic */ SS7 b;
        final /* synthetic */ FileReference c;
        final /* synthetic */ EnumC18310oS d;

        public a(SS7 ss7, FileReference fileReference, EnumC18310oS enumC18310oS) {
            this.b = ss7;
            this.c = fileReference;
            this.d = enumC18310oS;
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            SS7 ss7 = SS7.this;
            if (this.b.n) {
                return;
            }
            SS7 ss72 = this.b;
            C14970in2 c14970in2Y = ss72.y();
            FileReference fileReference = this.c;
            ss72.M(c14970in2Y.D(fileReference, this.b.Q(this.d, fileReference), this.b, (56 & 8) != 0 ? false : true, (56 & 16) != 0, (56 & 32) != 0 ? false : false));
            ss7.c(f);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            SS7 ss7 = SS7.this;
            if (this.b.n) {
                return;
            }
            ss7.d(interfaceC3346Am2);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void g(DX1 dx1) {
            SS7 ss7 = SS7.this;
            if (this.b.n) {
                return;
            }
            SS7 ss72 = this.b;
            C14970in2 c14970in2Y = ss72.y();
            FileReference fileReference = this.c;
            ss72.M(c14970in2Y.D(fileReference, this.b.Q(this.d, fileReference), this.b, (56 & 8) != 0 ? false : true, (56 & 16) != 0, (56 & 32) != 0 ? false : false));
            ss7.g(dx1);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22007uW1.a d;
        final /* synthetic */ FileReference e;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ SS7 a;
            final /* synthetic */ FileReference b;

            a(SS7 ss7, FileReference fileReference) {
                this.a = ss7;
                this.b = fileReference;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(SS7 ss7) {
                AbstractC13042fc3.i(ss7, "this$0");
                ss7.d(new C9115Yo(""));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 j(SS7 ss7, SY1 sy1) {
                AbstractC13042fc3.i(ss7, "this$0");
                AbstractC13042fc3.i(sy1, "$it");
                ss7.c(((SY1.b) sy1).a());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 l(SY1 sy1, SS7 ss7) {
                AbstractC13042fc3.i(sy1, "$it");
                AbstractC13042fc3.i(ss7, "this$0");
                EX1 ex1A = ((SY1.c) sy1).a();
                ss7.g(ex1A != null ? ss7.t().a(ex1A) : null);
                return C19938rB7.a;
            }

            private static final void m(SS7 ss7, SA2 sa2) {
                if (ss7.n) {
                    return;
                }
                sa2.invoke();
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object a(final SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                C22007uW1.F(this.a, -1, "(STREAM) collected state= " + sy1, this.b, null, 8, null);
                if (sy1 instanceof SY1.a) {
                    final SS7 ss7 = this.a;
                    m(ss7, new SA2() { // from class: ir.nasim.TS7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return SS7.b.a.i(ss7);
                        }
                    });
                } else if (sy1 instanceof SY1.b) {
                    final SS7 ss72 = this.a;
                    m(ss72, new SA2() { // from class: ir.nasim.US7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return SS7.b.a.j(ss72, sy1);
                        }
                    });
                } else {
                    if (!(sy1 instanceof SY1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    final SS7 ss73 = this.a;
                    m(ss73, new SA2() { // from class: ir.nasim.VS7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return SS7.b.a.l(sy1, ss73);
                        }
                    });
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C22007uW1.a aVar, FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
            this.e = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return SS7.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S = SS7.this.v().s((MX1.b) this.d.a());
                a aVar = new a(SS7.this, this.e);
                this.b = 1;
                if (interfaceC4557Fq2S.b(aVar, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SS7(C14970in2 c14970in2, AbstractC17757nW1 abstractC17757nW1) {
        super(c14970in2, abstractC17757nW1, null, 4, null);
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(abstractC17757nW1, "document");
    }

    @Override // ir.nasim.C22007uW1
    public void L() {
        MW1 mw1B = s().b();
        if (mw1B instanceof MW1.b) {
            C22007uW1.a aVarA = A();
            if (aVarA != null) {
                C22007uW1.F(this, 0, "(STREAM) resume", null, aVarA.a(), 4, null);
                v().u(aVarA.a(), new FY1(null, 1, null), LY1.b.a);
            } else {
                y().h0(((MW1.b) mw1B).a().b(), true);
            }
            Iterator it = r().iterator();
            while (it.hasNext()) {
                ((AbstractC22597vW1) it.next()).p();
            }
        }
    }

    @Override // ir.nasim.C22007uW1
    public void R() {
        C22007uW1.a aVarA = A();
        if (aVarA != null) {
            C22007uW1.F(this, -3, "(STEAM) unbind", null, aVarA.a(), 4, null);
            S(aVarA, false);
        }
        this.n = true;
        super.R();
    }

    protected void U(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        boolean zQ = Q(enumC18310oS, fileReference);
        if (!z().b()) {
            y().V(fileReference.getFileId(), fileReference.getAccessHash(), new a(this, fileReference, enumC18310oS), true);
        } else {
            C22007uW1.a aVarO = o(fileReference);
            O(aVarO);
            if (zQ) {
                C22007uW1.F(this, 0, "(STREAM) bind,start Immediate", fileReference, null, 8, null);
                v().u(aVarO.a(), new FY1(null, 1, null), new LY1.a(null, 1, null));
            }
        }
    }

    @Override // ir.nasim.C22007uW1
    protected void m(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        N(fileReference.getFileSize() / 1024.0f);
        Iterator it = r().iterator();
        while (it.hasNext()) {
            ((AbstractC22597vW1) it.next()).m(fileReference.getFileSize() / 1024.0f, false);
        }
        U(enumC18310oS, fileReference);
    }

    @Override // ir.nasim.C22007uW1
    protected C22007uW1.a o(FileReference fileReference) {
        InterfaceC20315ro1 interfaceC20315ro1B;
        AbstractC13042fc3.i(fileReference, "fileReference");
        C22007uW1.a aVarA = A();
        if (aVarA != null && (interfaceC20315ro1B = aVarA.b()) != null) {
            AbstractC20906so1.d(interfaceC20315ro1B, null, 1, null);
        }
        C22007uW1.a aVar = new C22007uW1.a(AbstractC20906so1.a(C12366eV1.c()), w().A0().a(fileReference));
        if (aVar.a() instanceof MX1.b) {
            AbstractC10533bm0.d(aVar.b(), null, null, new b(aVar, fileReference, null), 3, null);
        }
        return aVar;
    }
}
