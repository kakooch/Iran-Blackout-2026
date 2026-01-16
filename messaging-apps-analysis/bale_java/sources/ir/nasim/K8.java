package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import ir.nasim.G8;
import ir.nasim.K8;
import ir.nasim.core.modules.settings.SettingsModule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class K8 extends VW7 {
    private final Context b;
    private final AbstractC13778go1 c;
    private final C8054Ui1 d;
    private final SettingsModule e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC10258bL6 g;
    private final InterfaceC8327Vm4 h;
    private final InterfaceC10040ay6 i;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return K8.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004c -> B:6:0x001c). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.f
                r2 = 1
                if (r1 == 0) goto L2a
                if (r1 != r2) goto L22
                java.lang.Object r1 = r14.e
                ir.nasim.I8 r1 = (ir.nasim.I8) r1
                java.lang.Object r3 = r14.d
                java.lang.Object r4 = r14.c
                ir.nasim.K8 r4 = (ir.nasim.K8) r4
                java.lang.Object r5 = r14.b
                ir.nasim.Zm4 r5 = (ir.nasim.InterfaceC9336Zm4) r5
                ir.nasim.AbstractC10685c16.b(r15)
            L1c:
                r11 = r4
                r12 = r5
                r13 = r3
                r3 = r1
                r1 = r13
                goto L4f
            L22:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L2a:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.K8 r15 = ir.nasim.K8.this
                ir.nasim.Zm4 r15 = ir.nasim.K8.U0(r15)
                ir.nasim.K8 r1 = ir.nasim.K8.this
                r5 = r15
                r4 = r1
            L37:
                java.lang.Object r3 = r5.getValue()
                r1 = r3
                ir.nasim.I8 r1 = (ir.nasim.I8) r1
                r14.b = r5
                r14.c = r4
                r14.d = r3
                r14.e = r1
                r14.f = r2
                java.lang.Object r15 = ir.nasim.K8.S0(r4, r14)
                if (r15 != r0) goto L1c
                return r0
            L4f:
                r7 = r15
                java.util.List r7 = (java.util.List) r7
                r9 = 23
                r10 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r8 = 0
                ir.nasim.I8 r15 = ir.nasim.I8.b(r3, r4, r5, r6, r7, r8, r9, r10)
                boolean r15 = r12.f(r1, r15)
                if (r15 == 0) goto L66
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            L66:
                r4 = r11
                r5 = r12
                goto L37
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K8.a.invokeSuspend(java.lang.Object):java.lang.Object");
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(List list, String str) {
            List listN0 = AbstractC20762sZ6.N0(str, new String[]{Separators.SEMICOLON}, false, 0, 6, null);
            String str2 = (String) listN0.get(0);
            String str3 = (String) listN0.get(1);
            String str4 = (String) listN0.get(2);
            String str5 = (String) AbstractC15401jX0.t0(listN0, 3);
            C13197fp1 c13197fp1H = C12561ep1.a.b().h((String) listN0.get(1));
            list.add(new C13788gp1(str2, str4, str3, str5, c13197fp1H != null ? c13197fp1H.d() : null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return K8.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException, IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            final ArrayList arrayList = new ArrayList();
            InputStream inputStreamOpenRawResource = K8.this.b.getResources().openRawResource(AbstractC19954rD5.countries);
            AbstractC13042fc3.h(inputStreamOpenRawResource, "openRawResource(...)");
            Reader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, C12275eL0.b);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                AbstractC8839Xn7.c(bufferedReader, new UA2() { // from class: ir.nasim.L8
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return K8.b.y(arrayList, (String) obj2);
                    }
                });
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(bufferedReader, null);
                return arrayList;
            } finally {
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ Long d;
        final /* synthetic */ K8 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Long l, K8 k8, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = l;
            this.e = k8;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K8.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public K8(Context context, AbstractC13778go1 abstractC13778go1, C8054Ui1 c8054Ui1, SettingsModule settingsModule) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c8054Ui1, "contactModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = context;
        this.c = abstractC13778go1;
        this.d = c8054Ui1;
        this.e = settingsModule;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new I8(null, null, null, null, false, 31, null));
        this.f = interfaceC9336Zm4A;
        this.g = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.h = interfaceC8327Vm4B;
        this.i = AbstractC6459Nq2.b(interfaceC8327Vm4B);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    private final C13788gp1 Y0(String str) {
        Object next;
        Iterator it = ((I8) this.f.getValue()).e().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((C13788gp1) next).c(), str)) {
                break;
            }
        }
        return (C13788gp1) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z0(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new b(null), interfaceC20295rm1);
    }

    private final void a1(G8.a aVar) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, I8.b((I8) value, null, null, null, null, true, 15, null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.c, null, new c(AbstractC19562qZ6.q(((I8) this.f.getValue()).f().a() + ((I8) this.f.getValue()).d()), this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b1(ir.nasim.G8.c r11) {
        /*
            r10 = this;
            ir.nasim.Zm4 r0 = r10.f
        L2:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            ir.nasim.I8 r2 = (ir.nasim.I8) r2
            java.lang.String r3 = r11.a()
            ir.nasim.gp1 r3 = r10.Y0(r3)
            if (r3 != 0) goto L17
            ir.nasim.gp1 r3 = ir.nasim.J8.a()
        L17:
            r5 = r3
            java.lang.String r3 = r5.d()
            if (r3 == 0) goto L40
            java.lang.String r4 = r2.d()
            r6 = 0
            r7 = r6
        L24:
            int r8 = r3.length()
            if (r6 >= r8) goto L37
            char r8 = r3.charAt(r6)
            r9 = 88
            if (r8 != r9) goto L34
            int r7 = r7 + 1
        L34:
            int r6 = r6 + 1
            goto L24
        L37:
            java.lang.String r3 = ir.nasim.AbstractC14836iZ6.A1(r4, r7)
            if (r3 != 0) goto L3e
            goto L40
        L3e:
            r4 = r3
            goto L45
        L40:
            java.lang.String r3 = r2.d()
            goto L3e
        L45:
            r8 = 25
            r9 = 0
            r3 = 0
            r6 = 0
            r7 = 0
            ir.nasim.I8 r2 = ir.nasim.I8.b(r2, r3, r4, r5, r6, r7, r8, r9)
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K8.b1(ir.nasim.G8$c):void");
    }

    private final void c1(G8.d dVar) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, I8.b((I8) value, dVar.a(), null, null, null, false, 30, null)));
    }

    private final void d1(G8.e eVar) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, I8.b((I8) value, null, eVar.a(), null, null, false, 29, null)));
    }

    public final InterfaceC10040ay6 V0() {
        return this.i;
    }

    public final InterfaceC10258bL6 W0() {
        return this.g;
    }

    public final String X0() {
        return this.e.F0();
    }

    public final void e1(G8 g8) {
        AbstractC13042fc3.i(g8, "uiAction");
        if (g8 instanceof G8.d) {
            c1((G8.d) g8);
            return;
        }
        if (g8 instanceof G8.c) {
            b1((G8.c) g8);
            return;
        }
        if (g8 instanceof G8.e) {
            d1((G8.e) g8);
        } else if (g8 instanceof G8.a) {
            a1((G8.a) g8);
        } else if (!(g8 instanceof G8.b)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
