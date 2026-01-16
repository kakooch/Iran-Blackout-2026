package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.settings.SettingsModule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class GH4 extends VW7 {
    private final Context b;
    private final C8054Ui1 c;
    private final SettingsModule d;
    private final InterfaceC9336Zm4 e;
    private C13788gp1 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GH4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC9336Zm4 = GH4.this.e;
                GH4 gh4 = GH4.this;
                this.b = interfaceC9336Zm4;
                this.c = 1;
                obj = gh4.Y0(this);
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
                interfaceC9336Zm4 = (InterfaceC9336Zm4) this.b;
                AbstractC10685c16.b(obj);
            }
            this.b = null;
            this.c = 2;
            if (interfaceC9336Zm4.a(obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ GH4 e;
        final /* synthetic */ String f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, GH4 gh4, String str, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = gh4;
            this.f = str;
            this.g = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UA2 ua22 = this.d;
                C6517Nv5 c6517Nv5O0 = this.e.c.o0(this.f, this.g);
                this.b = ua22;
                this.c = 1;
                Object objD = AbstractC6756Ov5.d(c6517Nv5O0, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
                ua2 = ua22;
                objL = objD;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ua2 = (UA2) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            ua2.invoke(C9475a16.a(objL));
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

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GH4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException, IOException {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            HashMap map = new HashMap(200);
            GH4.this.V0(map);
            return map;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public GH4(Context context, C8054Ui1 c8054Ui1, SettingsModule settingsModule) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8054Ui1, "contactModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = context;
        this.c = c8054Ui1;
        this.d = settingsModule;
        this.e = AbstractC12281eL6.a(b1());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(final HashMap map) throws Resources.NotFoundException, IOException {
        InputStream inputStreamOpenRawResource = this.b.getResources().openRawResource(AbstractC19954rD5.countries);
        AbstractC13042fc3.h(inputStreamOpenRawResource, "openRawResource(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource, C12275eL0.b);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            AbstractC8839Xn7.c(bufferedReader, new UA2() { // from class: ir.nasim.FH4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return GH4.W0(map, (String) obj);
                }
            });
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(bufferedReader, null);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(HashMap map, String str) {
        AbstractC13042fc3.i(map, "$countries");
        AbstractC13042fc3.i(str, "it");
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{Separators.SEMICOLON}, false, 0, 6, null);
        map.put(listN0.get(0), new C13788gp1((String) listN0.get(0), (String) listN0.get(2), (String) listN0.get(1), (String) AbstractC15401jX0.t0(listN0, 3), null, 16, null));
        return C19938rB7.a;
    }

    public final InterfaceC13730gj3 U0(String str, long j, UA2 ua2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(ua2, "onDone");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(ua2, this, str, j, null), 3, null);
    }

    public final String X0() {
        return this.d.F0();
    }

    public final Object Y0(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new c(null), interfaceC20295rm1);
    }

    public final C13788gp1 Z0(String str) {
        AbstractC13042fc3.i(str, "countryCode");
        return (C13788gp1) ((HashMap) this.e.getValue()).get(str);
    }

    public final C13788gp1 a1() {
        return this.f;
    }

    public final HashMap b1() {
        C13788gp1 c13788gp1 = new C13788gp1("98", "Iran", "IR", "XXX XXX XXXX", null, 16, null);
        return AbstractC20051rO3.m(AbstractC4616Fw7.a(c13788gp1.a(), c13788gp1));
    }

    public final void c1(C13788gp1 c13788gp1) {
        this.f = c13788gp1;
    }
}
