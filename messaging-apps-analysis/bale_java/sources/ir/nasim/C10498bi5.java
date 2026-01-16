package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.bi5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10498bi5 extends VW7 {
    private final C3777Ch5 b;
    private final androidx.lifecycle.y c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;
    private final long f;
    private final long g;
    private final long h;

    /* renamed from: ir.nasim.bi5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ EnumC9058Yh5 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ List g;
        final /* synthetic */ String h;
        final /* synthetic */ ExPeerType i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, EnumC9058Yh5 enumC9058Yh5, boolean z, List list, String str, ExPeerType exPeerType, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = enumC9058Yh5;
            this.f = z;
            this.g = list;
            this.h = str;
            this.i = exPeerType;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10498bi5.this.new a(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C3777Ch5 c3777Ch5 = C10498bi5.this.b;
                C13121fh5 c13121fh5 = new C13121fh5(this.d, this.e, this.f, this.g, this.h, null, null, 96, null);
                C11458d25 c11458d25R = C11458d25.r(C10498bi5.this.Y0());
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                long jW0 = C10498bi5.this.W0();
                long jV0 = C10498bi5.this.V0();
                ExPeerType exPeerType = this.i;
                this.b = 1;
                objD = c3777Ch5.d(c13121fh5, c11458d25R, exPeerType, jW0, jV0, this);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = obj;
            }
            C10498bi5.this.d1(((Boolean) objD).booleanValue());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10498bi5(C3777Ch5 c3777Ch5, androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(c3777Ch5, "pollRepository");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = c3777Ch5;
        this.c = yVar;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C9878ai5(null, null, false, false, null, false, 63, null));
        this.d = interfaceC9336Zm4A;
        this.e = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        Object objC = yVar.c("unique_id");
        AbstractC13042fc3.f(objC);
        this.f = ((Number) objC).longValue();
        Object objC2 = yVar.c("thread_id");
        AbstractC13042fc3.f(objC2);
        this.g = ((Number) objC2).longValue();
        Object objC3 = yVar.c("thread_date");
        AbstractC13042fc3.f(objC3);
        this.h = ((Number) objC3).longValue();
    }

    public final void R0() {
        C9878ai5 c9878ai5 = (C9878ai5) this.d.getValue();
        List listP1 = AbstractC15401jX0.p1(c9878ai5.c());
        if (listP1.size() < 12) {
            listP1.add("");
            this.d.setValue(C9878ai5.b(c9878ai5, null, listP1, false, false, null, false, 61, null));
        }
    }

    public final void S0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C9878ai5.b((C9878ai5) value, null, null, false, false, null, false, 47, null)));
    }

    public final void T0(long j, EnumC9058Yh5 enumC9058Yh5, boolean z, List list, String str, ExPeerType exPeerType) {
        AbstractC13042fc3.i(enumC9058Yh5, "pollType");
        AbstractC13042fc3.i(list, "options");
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(j, enumC9058Yh5, z, list, str, exPeerType, null), 2, null);
    }

    public final void U0(int i) {
        C9878ai5 c9878ai5 = (C9878ai5) this.d.getValue();
        List listP1 = AbstractC15401jX0.p1(c9878ai5.c());
        if (i < 0 || i >= listP1.size()) {
            return;
        }
        listP1.remove(i);
        this.d.setValue(C9878ai5.b(c9878ai5, null, listP1, false, false, null, false, 61, null));
    }

    public final long V0() {
        return this.h;
    }

    public final long W0() {
        return this.g;
    }

    public final InterfaceC10258bL6 X0() {
        return this.e;
    }

    public final long Y0() {
        return this.f;
    }

    public final void Z0(int i, int i2) {
        Object value;
        C9878ai5 c9878ai5;
        List listP1;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            c9878ai5 = (C9878ai5) value;
            listP1 = AbstractC15401jX0.p1(c9878ai5.c());
            listP1.add(i2, (String) listP1.remove(i));
        } while (!interfaceC9336Zm4.f(value, C9878ai5.b(c9878ai5, null, listP1, false, false, null, false, 61, null)));
    }

    public final void a1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C9878ai5.b((C9878ai5) value, null, null, z, false, null, false, 59, null)));
    }

    public final void b1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C9878ai5.b((C9878ai5) value, null, null, false, z, null, false, 55, null)));
    }

    public final void c1(int i, String str) {
        AbstractC13042fc3.i(str, "newText");
        C9878ai5 c9878ai5 = (C9878ai5) this.d.getValue();
        List listP1 = AbstractC15401jX0.p1(c9878ai5.c());
        if (str.length() <= 256) {
            int length = ((String) listP1.get(i)).length();
            int length2 = str.length();
            listP1.set(i, str);
            if (i == 0 && length2 > length && (!AbstractC20762sZ6.n0(str)) && listP1.size() < 2) {
                listP1.add("");
            }
            if (i == 0 && AbstractC20762sZ6.n0(str)) {
                while (listP1.size() > 1) {
                    listP1.remove(AbstractC10360bX0.o(listP1));
                }
            }
            if (i == 1 && AbstractC20762sZ6.n0(str) && listP1.size() >= 3 && AbstractC20762sZ6.n0((CharSequence) listP1.get(2))) {
                listP1.remove(2);
            }
            this.d.setValue(C9878ai5.b(c9878ai5, null, listP1, false, false, null, false, 61, null));
        }
    }

    public final void d1(boolean z) {
        Object value;
        Object value2;
        if (z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, C9878ai5.b((C9878ai5) value2, null, null, false, false, null, z, 31, null)));
        } else {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.d;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, C9878ai5.b((C9878ai5) value, null, null, false, false, Integer.valueOf(DD5.error_unknown), false, 47, null)));
        }
    }

    public final void e1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "newQuestion");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C9878ai5.b((C9878ai5) value, str, null, false, false, null, false, 62, null)));
    }
}
