package ir.nasim;

import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC15251jG3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.QA7;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Bs4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3641Bs4 extends VW7 {
    private AH0 b = AH0.a;
    private InterfaceC8327Vm4 c;
    private InterfaceC8327Vm4 d;
    private InterfaceC14371ho1 e;
    private InterfaceC14371ho1 f;
    private InterfaceC14371ho1 g;
    private InterfaceC14371ho1 h;
    private final InterfaceC8327Vm4 i;
    private final InterfaceC8327Vm4 j;
    private InterfaceC10040ay6 k;
    private InterfaceC9336Zm4 l;
    private final InterfaceC10040ay6 m;
    private final InterfaceC10258bL6 n;
    private final InterfaceC8327Vm4 o;
    private final InterfaceC8327Vm4 p;

    /* renamed from: ir.nasim.Bs4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                this.b = 1;
                if (ah0.t(this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                this.b = 1;
                if (ah0.r(this) == objE) {
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

    /* renamed from: ir.nasim.Bs4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ KS2 c;
        final /* synthetic */ String d;
        final /* synthetic */ C3641Bs4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(KS2 ks2, String str, C3641Bs4 c3641Bs4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ks2;
            this.d = str;
            this.e = c3641Bs4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CardToCardConfig cardToCardConfig = (CardToCardConfig) this.c.k(this.d.toString(), CardToCardConfig.class);
                if (cardToCardConfig == null) {
                    return C19938rB7.a;
                }
                InterfaceC8327Vm4 interfaceC8327Vm4 = this.e.o;
                AbstractC15251jG3.b bVar = new AbstractC15251jG3.b(cardToCardConfig);
                this.b = 1;
                if (interfaceC8327Vm4.a(bVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Bs4$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C3641Bs4 a;

            a(C3641Bs4 c3641Bs4) {
                this.a = c3641Bs4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objA = this.a.d.a(new AbstractC15251jG3.b(arrayList), interfaceC20295rm1);
                return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4P = C3641Bs4.this.b.p();
                a aVar = new a(C3641Bs4.this);
                this.b = 1;
                if (interfaceC8327Vm4P.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Bs4$e$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C3641Bs4 a;

            a(C3641Bs4 c3641Bs4) {
                this.a = c3641Bs4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objA = this.a.c.a(new AbstractC15251jG3.b(arrayList), interfaceC20295rm1);
                return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4M = C3641Bs4.this.b.m();
                a aVar = new a(C3641Bs4.this);
                this.b = 1;
                if (interfaceC8327Vm4M.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = th;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C3641Bs4.this.l;
                String message = this.d.getMessage();
                if (message == null) {
                    message = "";
                }
                QA7.a aVar = new QA7.a(new Exception(message));
                this.b = 1;
                if (interfaceC9336Zm4.a(aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bankCreditCard;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new g(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                BankCreditCard bankCreditCard = this.d;
                this.b = 1;
                obj = ah0.f(bankCreditCard, this);
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
            InterfaceC9336Zm4 interfaceC9336Zm4 = C3641Bs4.this.l;
            QA7.d dVar = new QA7.d((BankCreditCard) obj);
            this.b = 2;
            if (interfaceC9336Zm4.a(dVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ BankCreditCard e;
        final /* synthetic */ InterfaceC20295rm1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1, InterfaceC20295rm1 interfaceC20295rm12) {
            super(2, interfaceC20295rm12);
            this.e = bankCreditCard;
            this.f = interfaceC20295rm1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new h(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            BankCreditCard bankCreditCard;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                BankCreditCard bankCreditCard2 = this.e;
                this.c = 1;
                obj = ah0.f(bankCreditCard2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bankCreditCard = (BankCreditCard) this.b;
                    AbstractC10685c16.b(obj);
                    this.f.resumeWith(C9475a16.b(bankCreditCard));
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            BankCreditCard bankCreditCard3 = (BankCreditCard) obj;
            InterfaceC9336Zm4 interfaceC9336Zm4 = C3641Bs4.this.l;
            QA7.d dVar = new QA7.d(bankCreditCard3);
            this.b = bankCreditCard3;
            this.c = 2;
            if (interfaceC9336Zm4.a(dVar, this) == objE) {
                return objE;
            }
            bankCreditCard = bankCreditCard3;
            this.f.resumeWith(C9475a16.b(bankCreditCard));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = th;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.o;
                String message = this.d.getMessage();
                if (message == null) {
                    message = "";
                }
                AbstractC15251jG3.a aVar = new AbstractC15251jG3.a(message);
                this.b = 1;
                if (interfaceC8327Vm4.a(aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bankCreditCard;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.c;
                AbstractC15251jG3.c cVar = AbstractC15251jG3.c.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(cVar, this) == objE) {
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
            AH0 ah0 = C3641Bs4.this.b;
            BankCreditCard bankCreditCard = this.d;
            this.b = 2;
            if (ah0.g(bankCreditCard, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bankCreditCard;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.d;
                AbstractC15251jG3.c cVar = AbstractC15251jG3.c.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(cVar, this) == objE) {
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
            AH0 ah0 = C3641Bs4.this.b;
            BankCreditCard bankCreditCard = this.d;
            this.b = 2;
            if (ah0.h(bankCreditCard, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = th;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.c;
                String message = this.d.getMessage();
                if (message == null) {
                    message = "";
                }
                AbstractC15251jG3.a aVar = new AbstractC15251jG3.a(message);
                this.b = 1;
                if (interfaceC8327Vm4.a(aVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(BankCreditCard bankCreditCard, int i, int i2, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bankCreditCard;
            this.e = i;
            this.f = i2;
            this.g = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new m(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                BankCreditCard bankCreditCard = this.d;
                int i2 = this.e;
                int i3 = this.f;
                String str = this.g;
                this.b = 1;
                obj = ah0.i(bankCreditCard, i2, i3, str, this);
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
            InterfaceC9336Zm4 interfaceC9336Zm4 = C3641Bs4.this.l;
            QA7.d dVar = new QA7.d((BankCreditCard) obj);
            this.b = 2;
            if (interfaceC9336Zm4.a(dVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                this.b = 1;
                if (ah0.s(this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C3641Bs4.this.l;
                QA7.b bVar = QA7.b.a;
                this.b = 1;
                if (interfaceC9336Zm4.a(bVar, this) == objE) {
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
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bankCreditCard;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new p(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.d;
                AbstractC15251jG3.c cVar = AbstractC15251jG3.c.a;
                this.b = 1;
                if (interfaceC8327Vm4.a(cVar, this) == objE) {
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
            AH0 ah0 = C3641Bs4.this.b;
            BankCreditCard bankCreditCard = this.d;
            this.b = 2;
            if (ah0.u(bankCreditCard, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new q(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AH0 ah0 = C3641Bs4.this.b;
                String str = this.d;
                this.b = 1;
                if (ah0.w(str, this) == objE) {
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
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Bs4$r */
    public static final class r extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C3641Bs4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(InterfaceC14371ho1.a aVar, C3641Bs4 c3641Bs4) {
            super(aVar);
            this.b = c3641Bs4;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), null, null, this.b.new w(th, null), 3, null);
        }
    }

    /* renamed from: ir.nasim.Bs4$s */
    public static final class s extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C3641Bs4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(InterfaceC14371ho1.a aVar, C3641Bs4 c3641Bs4) {
            super(aVar);
            this.b = c3641Bs4;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), null, null, this.b.new f(th, null), 3, null);
        }
    }

    /* renamed from: ir.nasim.Bs4$t */
    public static final class t extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C3641Bs4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(InterfaceC14371ho1.a aVar, C3641Bs4 c3641Bs4) {
            super(aVar);
            this.b = c3641Bs4;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), null, null, this.b.new l(th, null), 3, null);
        }
    }

    /* renamed from: ir.nasim.Bs4$u */
    public static final class u extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C3641Bs4 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(InterfaceC14371ho1.a aVar, C3641Bs4 c3641Bs4) {
            super(aVar);
            this.b = c3641Bs4;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), null, null, this.b.new i(th, null), 3, null);
        }
    }

    /* renamed from: ir.nasim.Bs4$v */
    public static final class v implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Bs4$v$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Bs4$v$a$a, reason: collision with other inner class name */
            public static final class C0301a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0301a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C3641Bs4.v.a.C0301a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Bs4$v$a$a r0 = (ir.nasim.C3641Bs4.v.a.C0301a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Bs4$v$a$a r0 = new ir.nasim.Bs4$v$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L85
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.jG3 r6 = (ir.nasim.AbstractC15251jG3) r6
                    boolean r2 = r6 instanceof ir.nasim.AbstractC15251jG3.b
                    if (r2 == 0) goto L59
                    ir.nasim.jG3$b r6 = (ir.nasim.AbstractC15251jG3.b) r6
                    java.lang.Object r6 = r6.a()
                    java.lang.String r2 = "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>"
                    ir.nasim.AbstractC13042fc3.g(r6, r2)
                    java.util.ArrayList r6 = (java.util.ArrayList) r6
                    boolean r2 = r6.isEmpty()
                    if (r2 == 0) goto L52
                    ir.nasim.QA7$b r6 = ir.nasim.QA7.b.a
                    goto L7c
                L52:
                    ir.nasim.QA7$d r2 = new ir.nasim.QA7$d
                    r2.<init>(r6)
                L57:
                    r6 = r2
                    goto L7c
                L59:
                    boolean r2 = r6 instanceof ir.nasim.AbstractC15251jG3.c
                    if (r2 == 0) goto L60
                    ir.nasim.QA7$c r6 = ir.nasim.QA7.c.a
                    goto L7c
                L60:
                    boolean r2 = r6 instanceof ir.nasim.AbstractC15251jG3.d
                    if (r2 == 0) goto L67
                    ir.nasim.QA7$b r6 = ir.nasim.QA7.b.a
                    goto L7c
                L67:
                    boolean r2 = r6 instanceof ir.nasim.AbstractC15251jG3.a
                    if (r2 == 0) goto L88
                    ir.nasim.QA7$a r2 = new ir.nasim.QA7$a
                    java.lang.Exception r4 = new java.lang.Exception
                    ir.nasim.jG3$a r6 = (ir.nasim.AbstractC15251jG3.a) r6
                    java.lang.String r6 = r6.a()
                    r4.<init>(r6)
                    r2.<init>(r4)
                    goto L57
                L7c:
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L85
                    return r1
                L85:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                L88:
                    kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                    r6.<init>()
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3641Bs4.v.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public v(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Bs4$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = th;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3641Bs4.this.new w(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C3641Bs4.this.d;
                String message = this.d.getMessage();
                if (message == null) {
                    message = "";
                }
                AbstractC15251jG3.a aVar = new AbstractC15251jG3.a(message);
                this.b = 1;
                if (interfaceC8327Vm4.a(aVar, this) == objE) {
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
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C3641Bs4() {
        EnumC6162Ml0 enumC6162Ml0 = EnumC6162Ml0.DROP_OLDEST;
        this.c = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        this.d = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        InterfaceC14371ho1.a aVar = InterfaceC14371ho1.h0;
        this.e = new r(aVar, this);
        this.f = new s(aVar, this);
        this.g = new t(aVar, this);
        this.h = new u(aVar, this);
        this.i = this.c;
        InterfaceC8327Vm4 interfaceC8327Vm4 = this.d;
        this.j = interfaceC8327Vm4;
        this.k = AbstractC6459Nq2.m0(new v(interfaceC8327Vm4), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), 1);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(QA7.b.a);
        this.l = interfaceC9336Zm4A;
        this.m = this.k;
        this.n = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        this.o = interfaceC8327Vm4B;
        this.p = interfaceC8327Vm4B;
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new a(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new b(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.h, null, new c(new KS2(), AbstractC5969Lp4.d().o2().S().b1(), this, null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new d(null), 2, null);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.g, null, new e(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(BankCreditCard bankCreditCard, SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        AbstractC13042fc3.i(bankCreditCard, "$card");
        C7183Qq.p().putString("last_request_for_shaparak_migration_id", bankCreditCard.getId());
        C7183Qq.p().putString("last_request_for_shaparak_migration_transactionid", sapOuterClass$ResponseEnrollNewCard.getTransactionId());
    }

    public final void W0(BankCreditCard bankCreditCard) {
        Object value;
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, QA7.c.a));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new g(bankCreditCard, null), 2, null);
    }

    public final Object X0(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, QA7.c.a));
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new h(bankCreditCard, c16963m96, null), 2, null);
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    public final String Y() {
        return C7183Qq.p().e("last_request_for_shaparak_migration_id");
    }

    public final boolean Y0(String str) {
        AbstractC13042fc3.i(str, "currentClipboard");
        String strE = C7183Qq.p().e("last_cp");
        return strE == null || !AbstractC13042fc3.d(strE, str);
    }

    public final void Z0(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "bankCard");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.g, null, new j(bankCreditCard, null), 2, null);
    }

    public final void a1(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "bankCard");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new k(bankCreditCard, null), 2, null);
    }

    public final void b1(BankCreditCard bankCreditCard, int i2, int i3, String str) {
        Object value;
        AbstractC13042fc3.i(bankCreditCard, "bankCard");
        AbstractC13042fc3.i(str, "cvv2");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, QA7.c.a));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new m(bankCreditCard, i2, i3, str, null), 2, null);
    }

    public final InterfaceC10258bL6 d1() {
        return this.n;
    }

    public final InterfaceC10040ay6 e1() {
        return this.m;
    }

    public final InterfaceC8327Vm4 f1() {
        return this.p;
    }

    public final BankCreditCard g1() {
        return this.b.l();
    }

    public final ArrayList h1() {
        return this.b.n();
    }

    public final InterfaceC8327Vm4 i1() {
        return this.i;
    }

    public final String j1() {
        return C7183Qq.p().e("last_request_for_shaparak_migration_id");
    }

    public final ArrayList k1() {
        return this.b.q();
    }

    public final InterfaceC8327Vm4 l1() {
        return this.j;
    }

    public final void m1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new n(null), 2, null);
    }

    public final boolean o1() {
        if (AbstractC19902r80.a().booleanValue()) {
            return false;
        }
        Iterator it = k1().iterator();
        while (it.hasNext()) {
            if (((BankCreditCard) it.next()).isEnrolled()) {
                return true;
            }
        }
        return false;
    }

    public final void p1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new o(null), 3, null);
    }

    public final void q1(String str) {
        AbstractC13042fc3.i(str, "clipboard");
        C7183Qq.p().putString("last_cp", str);
    }

    public final void s1(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "bankCard");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new p(bankCreditCard, null), 2, null);
    }

    public final void t1(String str) {
        if (str != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.e, null, new q(str, null), 2, null);
        }
    }

    public final C6517Nv5 z0(final BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        C6517Nv5 c6517Nv5M0 = AbstractC5969Lp4.d().o2().y().r1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.As4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C3641Bs4.c1(bankCreditCard, (SapOuterClass$ResponseEnrollNewCard) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }
}
