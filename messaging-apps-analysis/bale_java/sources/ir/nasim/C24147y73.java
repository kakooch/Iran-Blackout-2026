package ir.nasim;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C9475a16;
import ir.nasim.LP;
import ir.nasim.core.network.RpcException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.y73, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24147y73 extends VW7 {
    public static final a u = new a(null);
    public static final int v = 8;
    private final InterfaceC3570Bk5 b;
    private final InterfaceC3570Bk5 c;
    private final C15346jR d;
    private final C12328eR e;
    private final InterfaceC19567qa2 f;
    private final InterfaceC19567qa2 g;
    private final C15721k36 h;
    private final Context i;
    private final MQ j;
    private final AK6 k;
    private final AbstractC13778go1 l;
    private final InterfaceC9336Zm4 m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC9336Zm4 o;
    private final InterfaceC10258bL6 p;
    private final List q;
    private String r;
    private List s;
    private boolean t;

    /* renamed from: ir.nasim.y73$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.y73$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SQ.values().length];
            try {
                iArr[SQ.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SQ.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SQ.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SQ.j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SQ.m.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SQ.l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.y73$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C24147y73.this.new c(this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            String name;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            C24147y73 c24147y73 = C24147y73.this;
            String str = this.e;
            try {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(FileProvider.h(c24147y73.i, c24147y73.i.getPackageName() + ".provider", new File(str)));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            String str2 = this.e;
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                if (thE instanceof CancellationException) {
                    throw thE;
                }
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.a(name, "Failed to get uri of " + str2, thE);
            }
            if (C9475a16.g(objB)) {
                return null;
            }
            return objB;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            W75 w75;
            Object value;
            C14565i73 c14565i73;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String strE = C24147y73.this.b.e("PREF_KEY_COUNTRY_CODE");
            String string = C24147y73.this.b.getString("PREF_KEY_COUNTRY_NAME", "");
            String string2 = C24147y73.this.c.getString("PREF_KEY_PHONE_NUMBER", "");
            String string3 = C24147y73.this.b.getString("PREF_KEY_COUNTRY_EMOJI", "🇮🇷");
            String strE2 = C24147y73.this.b.e("PREF_KEY_TRANSACTION_HASH");
            if (strE != null) {
                String strB = AbstractC12152e76.b(strE);
                AbstractC13042fc3.f(string);
                AbstractC13042fc3.f(string2);
                w75 = new W75(strB, string, AbstractC12152e76.b(string2), string3);
            } else {
                w75 = new W75(null, null, null, null, 15, null);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.m;
            do {
                value = interfaceC9336Zm4.getValue();
                c14565i73 = (C14565i73) value;
            } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : null, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : strE2 == null ? "" : strE2, (255 & 512) != 0 ? c14565i73.j : w75)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C24316yP7 c24316yP7;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C24147y73.this.b.g("PREF_KEY_IS_IN_SING_UP", true);
            C24147y73.this.b.putString("PREF_KEY_TRANSACTION_HASH", this.d);
            InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.n;
            do {
                value = interfaceC9336Zm4.getValue();
                c24316yP7 = (C24316yP7) value;
            } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : true, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C7713Sw7 c7713Sw7;
            Object objL;
            Object value2;
            C7713Sw7 c7713Sw72;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24147y73.this.g.a("click_2fa_forget_password", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                C24147y73.this.g.a("email_validation_code", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.o;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c7713Sw7 = (C7713Sw7) value;
                } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : true, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
                MQ mq = C24147y73.this.j;
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                this.b = 1;
                Object objI = mq.i(strG, this);
                if (objI == objE) {
                    return objE;
                }
                objL = objI;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            SA2 sa2 = this.d;
            if (C9475a16.j(objL)) {
                String str = (String) objL;
                InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.o;
                while (true) {
                    Object value3 = interfaceC9336Zm42.getValue();
                    C7713Sw7 c7713Sw73 = (C7713Sw7) value3;
                    String str2 = str;
                    if (interfaceC9336Zm42.f(value3, c7713Sw73.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw73.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw73.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw73.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw73.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw73.e : str, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw73.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw73.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw73.h : 0))) {
                        break;
                    }
                    str = str2;
                }
                sa2.invoke();
            }
            C24147y73 c24147y732 = C24147y73.this;
            if (C9475a16.e(objL) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c24147y732.o;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                    c7713Sw72 = (C7713Sw7) value2;
                } while (!interfaceC9336Zm43.f(value2, c7713Sw72.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw72.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw72.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw72.c : c24147y732.i.getString(AbstractC12217eE5.auth_error_unknown), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw72.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw72.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw72.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw72.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw72.h : 0)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                File file = new File(this.c);
                if (!file.exists()) {
                    file = null;
                }
                if (file != null) {
                    AbstractC6392Nk0.a(file.delete());
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Exception unused) {
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new h(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L33
                if (r1 == r4) goto L29
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ir.nasim.AbstractC10685c16.b(r6)
                goto L71
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                java.lang.Object r1 = r5.d
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r3 = r5.c
                ir.nasim.y73 r3 = (ir.nasim.C24147y73) r3
                ir.nasim.AbstractC10685c16.b(r6)
                goto L5d
            L29:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L41
            L33:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Ml2 r6 = ir.nasim.C6164Ml2.a
                r5.e = r4
                java.lang.Object r6 = r6.s(r5)
                if (r6 != r0) goto L41
                return r0
            L41:
                ir.nasim.y73 r1 = ir.nasim.C24147y73.this
                boolean r4 = ir.nasim.C9475a16.j(r6)
                if (r4 == 0) goto La8
                r4 = r6
                java.lang.String r4 = (java.lang.String) r4
                r5.b = r6
                r5.c = r1
                r5.d = r4
                r5.e = r3
                java.lang.Object r6 = ir.nasim.C24147y73.e1(r1, r4, r5)
                if (r6 != r0) goto L5b
                return r0
            L5b:
                r3 = r1
                r1 = r4
            L5d:
                android.net.Uri r6 = (android.net.Uri) r6
                if (r6 != 0) goto L74
                r6 = 0
                r5.b = r6
                r5.c = r6
                r5.d = r6
                r5.e = r2
                java.lang.Object r6 = ir.nasim.C24147y73.p1(r3, r1, r5)
                if (r6 != r0) goto L71
                return r0
            L71:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L74:
                android.content.Intent r0 = new android.content.Intent
                java.lang.String r2 = "android.intent.action.SEND"
                r0.<init>(r2)
                java.lang.String r1 = ir.nasim.C24147y73.Y0(r3, r1)
                r0.setType(r1)
                r1 = 268435457(0x10000001, float:2.5243552E-29)
                r0.addFlags(r1)
                java.lang.String r1 = "android.intent.extra.STREAM"
                r0.putExtra(r1, r6)
                android.content.Context r6 = ir.nasim.C24147y73.V0(r3)
                android.content.Context r1 = ir.nasim.C24147y73.V0(r3)
                int r2 = ir.nasim.AbstractC12217eE5.menu_share
                java.lang.String r1 = r1.getString(r2)
                android.content.Intent r0 = android.content.Intent.createChooser(r0, r1)
                r1 = 268435456(0x10000000, float:2.524355E-29)
                android.content.Intent r0 = r0.setFlags(r1)
                r6.startActivity(r0)
            La8:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24147y73.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C7713Sw7 c7713Sw7;
            Object objM;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.o;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c7713Sw7 = (C7713Sw7) value;
                } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : true, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
                MQ mq = C24147y73.this.j;
                String str = this.d;
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                this.b = 1;
                objM = mq.m(str, strG, this);
                if (objM == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objM = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            String str2 = this.d;
            if (C9475a16.j(objM)) {
                c24147y73.g.a("set_2fa_password", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                c24147y73.s2(str2);
            }
            C24147y73 c24147y732 = C24147y73.this;
            if (C9475a16.e(objM) != null) {
                String string = c24147y732.i.getString(AbstractC12217eE5.auth_error_unknown);
                AbstractC13042fc3.h(string, "getString(...)");
                c24147y732.Z1(string);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ List e;
        final /* synthetic */ SQ f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j, List list, SQ sq, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = list;
            this.f = sq;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new j(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AK6 ak6 = C24147y73.this.k;
                long j = this.d;
                List list = this.e;
                SQ sq = this.f;
                this.b = 1;
                objA = ak6.a(j, list, sq, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            boolean z = this.g;
            if (C9475a16.j(objA)) {
                c24147y73.C1((TQ) objA, z);
            }
            C24147y73 c24147y732 = C24147y73.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                c24147y732.B1(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = C24147y73.this.new k(this.e, interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            InterfaceC20315ro1 interfaceC20315ro1;
            String name;
            Object value;
            C24316yP7 c24316yP7;
            Object value2;
            C24316yP7 c24316yP72;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                MQ mq = C24147y73.this.j;
                String str = this.e;
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                List listM = AbstractC10360bX0.m();
                boolean z = C24147y73.this.t;
                this.c = interfaceC20315ro12;
                this.b = 1;
                objG = mq.g(str, strG, listM, z, this);
                if (objG == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            if (C9475a16.j(objG)) {
                IP ip = (IP) objG;
                InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.n;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c24316yP7 = (C24316yP7) value;
                } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : LP.c.b, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
                if (ip.c()) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.n;
                    do {
                        value2 = interfaceC9336Zm42.getValue();
                        c24316yP72 = (C24316yP7) value2;
                    } while (!interfaceC9336Zm42.f(value2, c24316yP72.a((32735 & 1) != 0 ? c24316yP72.a : false, (32735 & 2) != 0 ? c24316yP72.b : null, (32735 & 4) != 0 ? c24316yP72.c : null, (32735 & 8) != 0 ? c24316yP72.d : false, (32735 & 16) != 0 ? c24316yP72.e : null, (32735 & 32) != 0 ? c24316yP72.f : false, (32735 & 64) != 0 ? c24316yP72.g : true, (32735 & 128) != 0 ? c24316yP72.h : null, (32735 & 256) != 0 ? c24316yP72.i : null, (32735 & 512) != 0 ? c24316yP72.j : 0L, (32735 & 1024) != 0 ? c24316yP72.k : null, (32735 & 2048) != 0 ? c24316yP72.l : 0L, (32735 & 4096) != 0 ? c24316yP72.m : null, (32735 & 8192) != 0 ? c24316yP72.n : null, (32735 & 16384) != 0 ? c24316yP72.o : null)));
                } else if (ip.b()) {
                    c24147y73.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(1))));
                    c24147y73.G1(((C14565i73) c24147y73.m.getValue()).g());
                } else {
                    c24147y73.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(2))));
                    PQ pqA = ip.a();
                    AbstractC13042fc3.h(pqA, "getResult(...)");
                    c24147y73.S1(pqA);
                }
            }
            C24147y73 c24147y732 = C24147y73.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, thE.getMessage());
                c24147y732.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(0))));
                c24147y732.E1(thE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = C24147y73.this.new l(interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            InterfaceC20315ro1 interfaceC20315ro1;
            String name;
            Object value;
            C14565i73 c14565i73;
            Object value2;
            C14565i73 c14565i732;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                MQ mq = C24147y73.this.j;
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                List listB = C24147y73.this.e.b();
                boolean z = C24147y73.this.t;
                this.c = interfaceC20315ro12;
                this.b = 1;
                objG = mq.g("", strG, listB, z, this);
                if (objG == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            if (C9475a16.j(objG)) {
                IP ip = (IP) objG;
                if (ip.c()) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.m;
                    do {
                        value2 = interfaceC9336Zm4.getValue();
                        c14565i732 = (C14565i73) value2;
                    } while (!interfaceC9336Zm4.f(value2, c14565i732.a((255 & 1) != 0 ? c14565i732.a : false, (255 & 2) != 0 ? c14565i732.b : false, (255 & 4) != 0 ? c14565i732.c : true, (255 & 8) != 0 ? c14565i732.d : null, (255 & 16) != 0 ? c14565i732.e : false, (255 & 32) != 0 ? c14565i732.f : LP.c.b, (255 & 64) != 0 ? c14565i732.g : null, (255 & 128) != 0 ? c14565i732.h : 0L, (255 & 256) != 0 ? c14565i732.i : null, (255 & 512) != 0 ? c14565i732.j : null)));
                } else if (ip.b()) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.m;
                    do {
                        value = interfaceC9336Zm42.getValue();
                        c14565i73 = (C14565i73) value;
                    } while (!interfaceC9336Zm42.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : new LP.a(null, null, null, true, EnumC10415ba2.b, null, 7, null), (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
                } else {
                    c24147y73.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(2))));
                    c24147y73.s1(ip);
                }
            }
            C24147y73 c24147y732 = C24147y73.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                c24147y732.D1(thE);
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, thE.getMessage());
                c24147y732.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(0))));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C7713Sw7 c7713Sw7;
            Object objL;
            Object value2;
            C7713Sw7 c7713Sw72;
            Object value3;
            C7713Sw7 c7713Sw73;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24147y73.this.g.a("click_2fa_enter_button", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.o;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c7713Sw7 = (C7713Sw7) value;
                } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : true, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
                MQ mq = C24147y73.this.j;
                String str = this.d;
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                boolean z = C24147y73.this.t;
                this.b = 1;
                Object objC = mq.c(str, strG, z, this);
                if (objC == objE) {
                    return objE;
                }
                objL = objC;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            if (C9475a16.j(objL)) {
                IP ip = (IP) objL;
                c24147y73.g.a("success_2fa_enter", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", AbstractC6392Nk0.d(1))));
                c24147y73.f.a("enter_otp", AbstractC19460qO3.g(AbstractC4616Fw7.a("result", AbstractC6392Nk0.d(2))));
                InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.o;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                    c7713Sw73 = (C7713Sw7) value3;
                } while (!interfaceC9336Zm42.f(value3, c7713Sw73.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw73.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw73.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw73.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw73.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw73.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw73.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw73.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw73.h : 0)));
                PQ pqA = ip.a();
                AbstractC13042fc3.h(pqA, "getResult(...)");
                c24147y73.S1(pqA);
            }
            C24147y73 c24147y732 = C24147y73.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c24147y732.o;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                    c7713Sw72 = (C7713Sw7) value2;
                } while (!interfaceC9336Zm43.f(value2, c7713Sw72.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw72.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw72.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw72.c : thE instanceof RpcException ? c24147y732.i.getString(AbstractC12217eE5.two_f_a_in_correct) : c24147y732.i.getString(AbstractC12217eE5.auth_error_unknown), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw72.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw72.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw72.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw72.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw72.h : 0)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.y73$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(String str, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24147y73.this.new n(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C7713Sw7 c7713Sw7;
            Object objJ;
            Object value2;
            C7713Sw7 c7713Sw72;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C24147y73.this.o;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c7713Sw7 = (C7713Sw7) value;
                } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : true, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
                MQ mq = C24147y73.this.j;
                String strB = GY6.b(this.d);
                String strG = ((C14565i73) C24147y73.this.m.getValue()).g();
                this.b = 1;
                objJ = mq.j(strB, strG, this);
                if (objJ == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objJ = ((C9475a16) obj).l();
            }
            C24147y73 c24147y73 = C24147y73.this;
            SA2 sa2 = this.e;
            if (C9475a16.j(objJ)) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.o;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    c7713Sw72 = (C7713Sw7) value2;
                } while (!interfaceC9336Zm42.f(value2, c7713Sw72.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw72.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw72.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw72.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw72.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw72.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw72.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw72.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw72.h : 0)));
                sa2.invoke();
            }
            C24147y73 c24147y732 = C24147y73.this;
            if (C9475a16.e(objJ) != null) {
                c24147y732.f2(c24147y732.i.getString(AbstractC12217eE5.two_f_a_code_email_invalid));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24147y73(InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC3570Bk5 interfaceC3570Bk52, C15346jR c15346jR, C12328eR c12328eR, InterfaceC19567qa2 interfaceC19567qa2, InterfaceC19567qa2 interfaceC19567qa22, C15721k36 c15721k36, Context context, MQ mq, AK6 ak6, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(interfaceC3570Bk52, "sharedPref");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(c12328eR, "encryptedSharedPreferences");
        AbstractC13042fc3.i(interfaceC19567qa2, "yandexMetric");
        AbstractC13042fc3.i(interfaceC19567qa22, "serajMetric");
        AbstractC13042fc3.i(c15721k36, "rootBeer");
        AbstractC13042fc3.i(context, "applicationContext");
        AbstractC13042fc3.i(mq, "authRepository");
        AbstractC13042fc3.i(ak6, "startPhoneAuthUseCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = interfaceC3570Bk5;
        this.c = interfaceC3570Bk52;
        this.d = c15346jR;
        this.e = c12328eR;
        this.f = interfaceC19567qa2;
        this.g = interfaceC19567qa22;
        this.h = c15721k36;
        this.i = context;
        this.j = mq;
        this.k = ak6;
        this.l = abstractC13778go1;
        this.m = AbstractC12281eL6.a(new C14565i73(false, false, false, null, false, null, null, 0L, null, null, 1023, null));
        this.n = AbstractC12281eL6.a(new C24316yP7(false, null, null, false, null, false, false, null, null, 0L, null, 0L, null, null, null, 32767, null));
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C7713Sw7(null, null, null, false, null, null, null, 0, 255, null));
        this.o = interfaceC9336Zm4A;
        this.p = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.q = new ArrayList();
        this.r = "";
        F1();
        this.s = new ArrayList();
        this.t = !C13923h3.a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(Throwable th) {
        Object value;
        C14565i73 c14565i73;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.a.a(th, EnumC10415ba2.b), (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(TQ tq, boolean z) {
        Object value;
        C24316yP7 c24316yP7;
        String string;
        Object value2;
        C24316yP7 c24316yP72;
        String string2;
        Object value3;
        C24316yP7 c24316yP73;
        String string3;
        Object value4;
        C24316yP7 c24316yP74;
        String string4;
        Object value5;
        C24316yP7 c24316yP75;
        String string5;
        Object value6;
        C14565i73 c14565i73;
        Object value7;
        C24316yP7 c24316yP76;
        Object value8;
        C24316yP7 c24316yP77;
        String string6;
        Object value9;
        C14565i73 c14565i732;
        Object value10;
        C24316yP7 c24316yP78;
        P1(this.b, tq);
        if (tq.a() == SP.d) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
            do {
                value9 = interfaceC9336Zm4.getValue();
                c14565i732 = (C14565i73) value9;
            } while (!interfaceC9336Zm4.f(value9, c14565i732.a((255 & 1) != 0 ? c14565i732.a : false, (255 & 2) != 0 ? c14565i732.b : false, (255 & 4) != 0 ? c14565i732.c : false, (255 & 8) != 0 ? c14565i732.d : null, (255 & 16) != 0 ? c14565i732.e : false, (255 & 32) != 0 ? c14565i732.f : null, (255 & 64) != 0 ? c14565i732.g : null, (255 & 128) != 0 ? c14565i732.h : 0L, (255 & 256) != 0 ? c14565i732.i : tq.h(), (255 & 512) != 0 ? c14565i732.j : null)));
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.n;
            do {
                value10 = interfaceC9336Zm42.getValue();
                c24316yP78 = (C24316yP7) value10;
            } while (!interfaceC9336Zm42.f(value10, c24316yP78.a((32735 & 1) != 0 ? c24316yP78.a : false, (32735 & 2) != 0 ? c24316yP78.b : null, (32735 & 4) != 0 ? c24316yP78.c : null, (32735 & 8) != 0 ? c24316yP78.d : false, (32735 & 16) != 0 ? c24316yP78.e : null, (32735 & 32) != 0 ? c24316yP78.f : false, (32735 & 64) != 0 ? c24316yP78.g : false, (32735 & 128) != 0 ? c24316yP78.h : null, (32735 & 256) != 0 ? c24316yP78.i : tq.g(), (32735 & 512) != 0 ? c24316yP78.j : tq.c(), (32735 & 1024) != 0 ? c24316yP78.k : tq.e(), (32735 & 2048) != 0 ? c24316yP78.l : tq.f(), (32735 & 4096) != 0 ? c24316yP78.m : tq.b(), (32735 & 8192) != 0 ? c24316yP78.n : tq.d(), (32735 & 16384) != 0 ? c24316yP78.o : null)));
            r2();
            return;
        }
        switch (b.a[tq.g().ordinal()]) {
            case 1:
                InterfaceC9336Zm4 interfaceC9336Zm43 = this.n;
                do {
                    value = interfaceC9336Zm43.getValue();
                    c24316yP7 = (C24316yP7) value;
                    string = this.i.getString(AbstractC12217eE5.bale_only_validation_text, w1());
                    AbstractC13042fc3.h(string, "getString(...)");
                } while (!interfaceC9336Zm43.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : AbstractC12152e76.b(string), (32735 & 4) != 0 ? c24316yP7.c : Integer.valueOf(KB5.login_other_device), (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
            case 2:
                InterfaceC9336Zm4 interfaceC9336Zm44 = this.n;
                do {
                    value2 = interfaceC9336Zm44.getValue();
                    c24316yP72 = (C24316yP7) value2;
                    string2 = this.i.getString(AbstractC12217eE5.sms_validation_text, w1());
                    AbstractC13042fc3.h(string2, "getString(...)");
                } while (!interfaceC9336Zm44.f(value2, c24316yP72.a((32735 & 1) != 0 ? c24316yP72.a : false, (32735 & 2) != 0 ? c24316yP72.b : AbstractC12152e76.b(string2), (32735 & 4) != 0 ? c24316yP72.c : Integer.valueOf(KB5.sms_login), (32735 & 8) != 0 ? c24316yP72.d : false, (32735 & 16) != 0 ? c24316yP72.e : null, (32735 & 32) != 0 ? c24316yP72.f : false, (32735 & 64) != 0 ? c24316yP72.g : false, (32735 & 128) != 0 ? c24316yP72.h : null, (32735 & 256) != 0 ? c24316yP72.i : null, (32735 & 512) != 0 ? c24316yP72.j : 0L, (32735 & 1024) != 0 ? c24316yP72.k : null, (32735 & 2048) != 0 ? c24316yP72.l : 0L, (32735 & 4096) != 0 ? c24316yP72.m : null, (32735 & 8192) != 0 ? c24316yP72.n : null, (32735 & 16384) != 0 ? c24316yP72.o : null)));
            case 3:
                InterfaceC9336Zm4 interfaceC9336Zm45 = this.n;
                do {
                    value3 = interfaceC9336Zm45.getValue();
                    c24316yP73 = (C24316yP7) value3;
                    string3 = this.i.getString(AbstractC12217eE5.call_validation_text, w1());
                    AbstractC13042fc3.h(string3, "getString(...)");
                } while (!interfaceC9336Zm45.f(value3, c24316yP73.a((32735 & 1) != 0 ? c24316yP73.a : false, (32735 & 2) != 0 ? c24316yP73.b : AbstractC12152e76.b(string3), (32735 & 4) != 0 ? c24316yP73.c : Integer.valueOf(KB5.calling_login), (32735 & 8) != 0 ? c24316yP73.d : false, (32735 & 16) != 0 ? c24316yP73.e : null, (32735 & 32) != 0 ? c24316yP73.f : false, (32735 & 64) != 0 ? c24316yP73.g : false, (32735 & 128) != 0 ? c24316yP73.h : null, (32735 & 256) != 0 ? c24316yP73.i : null, (32735 & 512) != 0 ? c24316yP73.j : 0L, (32735 & 1024) != 0 ? c24316yP73.k : null, (32735 & 2048) != 0 ? c24316yP73.l : 0L, (32735 & 4096) != 0 ? c24316yP73.m : null, (32735 & 8192) != 0 ? c24316yP73.n : null, (32735 & 16384) != 0 ? c24316yP73.o : null)));
            case 4:
            case 5:
                InterfaceC9336Zm4 interfaceC9336Zm46 = this.n;
                do {
                    value4 = interfaceC9336Zm46.getValue();
                    c24316yP74 = (C24316yP7) value4;
                    string4 = this.i.getString(AbstractC12217eE5.telegram_validation_text, w1());
                    AbstractC13042fc3.h(string4, "getString(...)");
                } while (!interfaceC9336Zm46.f(value4, c24316yP74.a((32735 & 1) != 0 ? c24316yP74.a : false, (32735 & 2) != 0 ? c24316yP74.b : AbstractC12152e76.b(string4), (32735 & 4) != 0 ? c24316yP74.c : Integer.valueOf(KB5.bot_login), (32735 & 8) != 0 ? c24316yP74.d : false, (32735 & 16) != 0 ? c24316yP74.e : null, (32735 & 32) != 0 ? c24316yP74.f : false, (32735 & 64) != 0 ? c24316yP74.g : false, (32735 & 128) != 0 ? c24316yP74.h : null, (32735 & 256) != 0 ? c24316yP74.i : null, (32735 & 512) != 0 ? c24316yP74.j : 0L, (32735 & 1024) != 0 ? c24316yP74.k : null, (32735 & 2048) != 0 ? c24316yP74.l : 0L, (32735 & 4096) != 0 ? c24316yP74.m : null, (32735 & 8192) != 0 ? c24316yP74.n : null, (32735 & 16384) != 0 ? c24316yP74.o : null)));
            case 6:
                InterfaceC9336Zm4 interfaceC9336Zm47 = this.n;
                do {
                    value5 = interfaceC9336Zm47.getValue();
                    c24316yP75 = (C24316yP7) value5;
                    string5 = this.i.getString(AbstractC12217eE5.ussd_validation_text, w1());
                    AbstractC13042fc3.h(string5, "getString(...)");
                } while (!interfaceC9336Zm47.f(value5, c24316yP75.a((32735 & 1) != 0 ? c24316yP75.a : false, (32735 & 2) != 0 ? c24316yP75.b : AbstractC12152e76.b(string5), (32735 & 4) != 0 ? c24316yP75.c : Integer.valueOf(KB5.sms_login), (32735 & 8) != 0 ? c24316yP75.d : false, (32735 & 16) != 0 ? c24316yP75.e : null, (32735 & 32) != 0 ? c24316yP75.f : false, (32735 & 64) != 0 ? c24316yP75.g : false, (32735 & 128) != 0 ? c24316yP75.h : null, (32735 & 256) != 0 ? c24316yP75.i : null, (32735 & 512) != 0 ? c24316yP75.j : 0L, (32735 & 1024) != 0 ? c24316yP75.k : null, (32735 & 2048) != 0 ? c24316yP75.l : 0L, (32735 & 4096) != 0 ? c24316yP75.m : null, (32735 & 8192) != 0 ? c24316yP75.n : null, (32735 & 16384) != 0 ? c24316yP75.o : null)));
            default:
                InterfaceC9336Zm4 interfaceC9336Zm48 = this.n;
                do {
                    value8 = interfaceC9336Zm48.getValue();
                    c24316yP77 = (C24316yP7) value8;
                    string6 = this.i.getString(AbstractC12217eE5.sms_validation_text, w1());
                    AbstractC13042fc3.h(string6, "getString(...)");
                } while (!interfaceC9336Zm48.f(value8, c24316yP77.a((32735 & 1) != 0 ? c24316yP77.a : false, (32735 & 2) != 0 ? c24316yP77.b : AbstractC12152e76.b(string6), (32735 & 4) != 0 ? c24316yP77.c : Integer.valueOf(KB5.sms_login), (32735 & 8) != 0 ? c24316yP77.d : false, (32735 & 16) != 0 ? c24316yP77.e : null, (32735 & 32) != 0 ? c24316yP77.f : false, (32735 & 64) != 0 ? c24316yP77.g : false, (32735 & 128) != 0 ? c24316yP77.h : null, (32735 & 256) != 0 ? c24316yP77.i : null, (32735 & 512) != 0 ? c24316yP77.j : 0L, (32735 & 1024) != 0 ? c24316yP77.k : null, (32735 & 2048) != 0 ? c24316yP77.l : 0L, (32735 & 4096) != 0 ? c24316yP77.m : null, (32735 & 8192) != 0 ? c24316yP77.n : null, (32735 & 16384) != 0 ? c24316yP77.o : null)));
        }
        InterfaceC9336Zm4 interfaceC9336Zm49 = this.m;
        do {
            value6 = interfaceC9336Zm49.getValue();
            c14565i73 = (C14565i73) value6;
        } while (!interfaceC9336Zm49.f(value6, c14565i73.a((255 & 1) != 0 ? c14565i73.a : z, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : tq.h(), (255 & 512) != 0 ? c14565i73.j : null)));
        InterfaceC9336Zm4 interfaceC9336Zm410 = this.n;
        do {
            value7 = interfaceC9336Zm410.getValue();
            c24316yP76 = (C24316yP7) value7;
        } while (!interfaceC9336Zm410.f(value7, c24316yP76.a((32735 & 1) != 0 ? c24316yP76.a : false, (32735 & 2) != 0 ? c24316yP76.b : null, (32735 & 4) != 0 ? c24316yP76.c : null, (32735 & 8) != 0 ? c24316yP76.d : false, (32735 & 16) != 0 ? c24316yP76.e : null, (32735 & 32) != 0 ? c24316yP76.f : false, (32735 & 64) != 0 ? c24316yP76.g : false, (32735 & 128) != 0 ? c24316yP76.h : null, (32735 & 256) != 0 ? c24316yP76.i : tq.g(), (32735 & 512) != 0 ? c24316yP76.j : tq.c(), (32735 & 1024) != 0 ? c24316yP76.k : tq.e(), (32735 & 2048) != 0 ? c24316yP76.l : tq.f(), (32735 & 4096) != 0 ? c24316yP76.m : tq.b(), (32735 & 8192) != 0 ? c24316yP76.n : tq.d(), (32735 & 16384) != 0 ? c24316yP76.o : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(Throwable th) {
        if ((th instanceof RpcException) && AbstractC13042fc3.d(((RpcException) th).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "FUTURE_TOKEN_INVALID")) {
            W1(this, ((C14565i73) this.m.getValue()).e(), this.b.getLong("PREF_KET_FULL_NUMBER", 0L), this.s, null, false, this.t, 24, null);
        } else {
            B1(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(Throwable th) {
        Object value;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : LP.a.a(th, EnumC10415ba2.a), (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    private final InterfaceC13730gj3 F1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(String str) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new e(str, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M1(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.l, new g(str, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final InterfaceC3570Bk5 O1(W75 w75, long j2) {
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.b;
        interfaceC3570Bk5.putString("PREF_KEY_COUNTRY_CODE", w75.c());
        interfaceC3570Bk5.putString("PREF_KEY_COUNTRY_NAME", w75.d());
        interfaceC3570Bk5.g("PREF_KEY_SYNC_CONTACT", this.t);
        this.c.putString("PREF_KEY_PHONE_NUMBER", w75.f());
        String strE = w75.e();
        if (strE != null) {
            interfaceC3570Bk5.putString("PREF_KEY_COUNTRY_EMOJI", strE);
        }
        interfaceC3570Bk5.putLong("PREF_KET_FULL_NUMBER", j2);
        return interfaceC3570Bk5;
    }

    private final void P1(InterfaceC3570Bk5 interfaceC3570Bk5, TQ tq) {
        interfaceC3570Bk5.putLong("PREF_KEY_SEND_CODE_TIME", tq.c());
        interfaceC3570Bk5.putLong("PREF_KEY_SEND_NEXT_CODE_TIME", tq.f());
        interfaceC3570Bk5.putString("PREF_KEY_TRANSACTION_HASH", tq.h());
        KS2 ks2 = new KS2();
        interfaceC3570Bk5.putString("PREF_KEY_SEND_CODE_TYPE", ks2.t(tq.g()));
        interfaceC3570Bk5.putString("PREF_KEY_SEND_NEXT_CODE_TYPE", ks2.t(tq.e()));
    }

    private final void Q1() {
        String name;
        try {
            String version = AbstractC20507s76.d.getVersion();
            if (version != null && version.length() != 0) {
                String strK = new C20644sM5("-").k(version, "");
                String strSubstring = strK.substring(AbstractC20762sZ6.l0(strK, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(strK, Separators.RPAREN, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                this.f.a("First_version_displayed", AbstractC19460qO3.g(AbstractC4616Fw7.a("First_version_displayed", strSubstring + " signIn")));
            }
        } catch (Exception e2) {
            if (C24147y73.class.isAnonymousClass()) {
                name = C24147y73.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C24147y73.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(PQ pq) {
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.d.f(pq).m0(new InterfaceC24449ye1() { // from class: ir.nasim.u73
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24147y73.T1(this.a, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.v73
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24147y73.U1(this.a, (Exception) obj);
                }
            });
            Q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(C24147y73 c24147y73, Boolean bool) {
        Object value;
        C24316yP7 c24316yP7;
        AbstractC13042fc3.i(c24147y73, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : true, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(C24147y73 c24147y73, Exception exc) {
        Object value;
        C7713Sw7 c7713Sw7;
        Object value2;
        C24316yP7 c24316yP7;
        LP.b bVar;
        AbstractC13042fc3.i(c24147y73, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : c24147y73.i.getString(AbstractC12217eE5.auth_error_unknown), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = c24147y73.n;
        do {
            value2 = interfaceC9336Zm42.getValue();
            c24316yP7 = (C24316yP7) value2;
            bVar = LP.a;
            AbstractC13042fc3.f(exc);
        } while (!interfaceC9336Zm42.f(value2, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : bVar.a(exc, EnumC10415ba2.c), (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public static /* synthetic */ void W1(C24147y73 c24147y73, W75 w75, long j2, List list, SQ sq, boolean z, boolean z2, int i2, Object obj) {
        c24147y73.V1(w75, j2, list, (i2 & 8) != 0 ? SQ.b : sq, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? true : z2);
    }

    private final void X1(long j2, List list, SQ sq, boolean z) {
        Object value;
        C14565i73 c14565i73;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : true, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : j2, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
        this.q.add(Long.valueOf(j2));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(j2, list, sq, z, null), 3, null);
    }

    public static /* synthetic */ void e2(C24147y73 c24147y73, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        c24147y73.d2(z);
    }

    private final InterfaceC13730gj3 r2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(IP ip) {
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.d.f(ip.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.w73
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24147y73.t1(this.a, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.x73
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C24147y73.u1(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(C24147y73 c24147y73, Boolean bool) {
        Object value;
        C14565i73 c14565i73;
        AbstractC13042fc3.i(c24147y73, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : true, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
        c24147y73.Q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(C24147y73 c24147y73, Exception exc) {
        Object value;
        C14565i73 c14565i73;
        LP.b bVar;
        String name;
        AbstractC13042fc3.i(c24147y73, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c24147y73.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
            bVar = LP.a;
            AbstractC13042fc3.f(exc);
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : bVar.a(exc, EnumC10415ba2.c), (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
        c24147y73.D1(exc);
        if (C24147y73.class.isAnonymousClass()) {
            name = C24147y73.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C24147y73.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.b(name, exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v1(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(AbstractC20762sZ6.d1(str, Separators.DOT, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z1(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.l, new c(str, null), interfaceC20295rm1);
    }

    public final InterfaceC10258bL6 A1() {
        return AbstractC6459Nq2.c(this.n);
    }

    public final InterfaceC13730gj3 H1(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onEmailSubmit");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(sa2, null), 3, null);
    }

    public final void I1() {
        Object value;
        C14565i73 c14565i73;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
    }

    public final void J1() {
        Object value;
        C14565i73 c14565i73;
        Object value2;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : null, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.n;
        do {
            value2 = interfaceC9336Zm42.getValue();
            c24316yP7 = (C24316yP7) value2;
        } while (!interfaceC9336Zm42.f(value2, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public final void K1() {
        Object value;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public final void L1() {
        Object value;
        C14565i73 c14565i73;
        Object value2;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : null, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.n;
        do {
            value2 = interfaceC9336Zm42.getValue();
            c24316yP7 = (C24316yP7) value2;
        } while (!interfaceC9336Zm42.f(value2, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public final InterfaceC13730gj3 N1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(null), 3, null);
    }

    public final InterfaceC13730gj3 R1(String str) {
        AbstractC13042fc3.i(str, "newPassword");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(str, null), 3, null);
    }

    public final void V1(W75 w75, long j2, List list, SQ sq, boolean z, boolean z2) {
        Object value;
        C24316yP7 c24316yP7;
        Object next;
        String str;
        Object value2;
        C14565i73 c14565i73;
        Object value3;
        C24316yP7 c24316yP72;
        SQ sq2 = sq;
        AbstractC13042fc3.i(w75, "phoneData");
        AbstractC13042fc3.i(sq2, "authType");
        this.t = z2;
        if (z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
            do {
                value3 = interfaceC9336Zm4.getValue();
                c24316yP72 = (C24316yP7) value3;
            } while (!interfaceC9336Zm4.f(value3, c24316yP72.a((32735 & 1) != 0 ? c24316yP72.a : false, (32735 & 2) != 0 ? c24316yP72.b : null, (32735 & 4) != 0 ? c24316yP72.c : null, (32735 & 8) != 0 ? c24316yP72.d : false, (32735 & 16) != 0 ? c24316yP72.e : null, (32735 & 32) != 0 ? c24316yP72.f : false, (32735 & 64) != 0 ? c24316yP72.g : false, (32735 & 128) != 0 ? c24316yP72.h : "", (32735 & 256) != 0 ? c24316yP72.i : null, (32735 & 512) != 0 ? c24316yP72.j : 0L, (32735 & 1024) != 0 ? c24316yP72.k : null, (32735 & 2048) != 0 ? c24316yP72.l : 0L, (32735 & 4096) != 0 ? c24316yP72.m : null, (32735 & 8192) != 0 ? c24316yP72.n : null, (32735 & 16384) != 0 ? c24316yP72.o : null)));
        }
        if (w75.f().length() == 0) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.m;
            do {
                value2 = interfaceC9336Zm42.getValue();
                c14565i73 = (C14565i73) value2;
            } while (!interfaceC9336Zm42.f(value2, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null)));
            return;
        }
        if (sq2 == SQ.l) {
            InterfaceC9336Zm4 interfaceC9336Zm43 = this.n;
            do {
                value = interfaceC9336Zm43.getValue();
                c24316yP7 = (C24316yP7) value;
                Iterator it = c24316yP7.f().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((XV4) next).e() == SQ.l) {
                            break;
                        }
                    }
                }
                XV4 xv4 = (XV4) next;
                if (xv4 == null || (str = (String) xv4.f()) == null) {
                    str = "";
                }
            } while (!interfaceC9336Zm43.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : str)));
        }
        if (!this.h.r() && (!this.e.b().isEmpty()) && !this.q.contains(Long.valueOf(j2)) && z) {
            sq2 = SQ.k;
        }
        SQ sq3 = sq2;
        this.s = list == null ? AbstractC10360bX0.m() : list;
        O1(w75, j2);
        X1(j2, list, sq3, z);
    }

    public final void Y1(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : c7713Sw7.d().a(str, null), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void Z1(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : B05.b(c7713Sw7.d(), null, str, 1, null), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void a2() {
        Object value;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : c24316yP7.j() - AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public final void c2(String str, String str2, String str3) {
        Object value;
        C14565i73 c14565i73;
        AbstractC13042fc3.i(str, "countryCode");
        AbstractC13042fc3.i(str2, "countryName");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : null, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : W75.b(c14565i73.e(), str, str2, null, str3, 4, null))));
    }

    public final void d2(boolean z) {
        Object value;
        C7713Sw7 c7713Sw7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, z ? c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 90) : c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : c7713Sw7.i() - 1)));
    }

    public final void f2(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : str, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void g2(C24316yP7 c24316yP7) {
        Object value;
        AbstractC13042fc3.i(c24316yP7, "value");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, c24316yP7));
    }

    public final void h2(String str) {
        Object value;
        C14565i73 c14565i73;
        AbstractC13042fc3.i(str, "phoneNumber");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            c14565i73 = (C14565i73) value;
        } while (!interfaceC9336Zm4.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : LP.c.b, (255 & 64) != 0 ? c14565i73.g : null, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : W75.b(c14565i73.e(), null, null, AbstractC12152e76.b(ZY6.a(str)), null, 11, null))));
    }

    public final void i2(String str) {
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            C14565i73 c14565i73 = (C14565i73) value;
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, c14565i73.a((255 & 1) != 0 ? c14565i73.a : false, (255 & 2) != 0 ? c14565i73.b : false, (255 & 4) != 0 ? c14565i73.c : false, (255 & 8) != 0 ? c14565i73.d : null, (255 & 16) != 0 ? c14565i73.e : false, (255 & 32) != 0 ? c14565i73.f : null, (255 & 64) != 0 ? c14565i73.g : str, (255 & 128) != 0 ? c14565i73.h : 0L, (255 & 256) != 0 ? c14565i73.i : null, (255 & 512) != 0 ? c14565i73.j : null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final void j2(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : c7713Sw7.f().a(str, null), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void k2(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, "error");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : B05.b(c7713Sw7.f(), null, str, 1, null), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void l2(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : str, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void m2(String str) {
        Object value;
        C7713Sw7 c7713Sw7;
        AbstractC13042fc3.i(str, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.o;
        do {
            value = interfaceC9336Zm4.getValue();
            c7713Sw7 = (C7713Sw7) value;
        } while (!interfaceC9336Zm4.f(value, c7713Sw7.a((SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 1) != 0 ? c7713Sw7.a : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 2) != 0 ? c7713Sw7.b : AbstractC12152e76.b(str), (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 4) != 0 ? c7713Sw7.c : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 8) != 0 ? c7713Sw7.d : false, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 16) != 0 ? c7713Sw7.e : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 32) != 0 ? c7713Sw7.f : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 64) != 0 ? c7713Sw7.g : null, (SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER & 128) != 0 ? c7713Sw7.h : 0)));
    }

    public final void n2(String str) {
        Object value;
        C24316yP7 c24316yP7;
        AbstractC13042fc3.i(str, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
            if (str.length() == 6 && !AbstractC13042fc3.d(GY6.b(this.r), GY6.b(str))) {
                p2(GY6.b(AbstractC20762sZ6.n1(str).toString()));
                this.r = str;
            }
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : AbstractC12152e76.b(ZY6.a(str)), (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
    }

    public final void o2() {
        Object value;
        C24316yP7 c24316yP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : false, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : "")));
    }

    public final void p2(String str) {
        Object value;
        C24316yP7 c24316yP7;
        AbstractC13042fc3.i(str, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            c24316yP7 = (C24316yP7) value;
        } while (!interfaceC9336Zm4.f(value, c24316yP7.a((32735 & 1) != 0 ? c24316yP7.a : false, (32735 & 2) != 0 ? c24316yP7.b : null, (32735 & 4) != 0 ? c24316yP7.c : null, (32735 & 8) != 0 ? c24316yP7.d : true, (32735 & 16) != 0 ? c24316yP7.e : null, (32735 & 32) != 0 ? c24316yP7.f : false, (32735 & 64) != 0 ? c24316yP7.g : false, (32735 & 128) != 0 ? c24316yP7.h : null, (32735 & 256) != 0 ? c24316yP7.i : null, (32735 & 512) != 0 ? c24316yP7.j : 0L, (32735 & 1024) != 0 ? c24316yP7.k : null, (32735 & 2048) != 0 ? c24316yP7.l : 0L, (32735 & 4096) != 0 ? c24316yP7.m : null, (32735 & 8192) != 0 ? c24316yP7.n : null, (32735 & 16384) != 0 ? c24316yP7.o : null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(str, null), 3, null);
    }

    public final InterfaceC13730gj3 s2(String str) {
        AbstractC13042fc3.i(str, ParameterNames.PASSWORD);
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(str, null), 3, null);
    }

    public final InterfaceC13730gj3 t2(String str, SA2 sa2) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(sa2, "codeValidated");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(str, sa2, null), 3, null);
    }

    public final String w1() {
        if (AbstractC13042fc3.d(AbstractC12152e76.b(((C14565i73) x1().getValue()).e().c()), AbstractC12152e76.b("98"))) {
            return AbstractC12152e76.b("0") + AbstractC20762sZ6.C0(((C14565i73) x1().getValue()).e().f(), AbstractC12152e76.b("0"));
        }
        return ((C14565i73) x1().getValue()).e().c() + AbstractC20762sZ6.C0(((C14565i73) x1().getValue()).e().f(), AbstractC12152e76.b("0"));
    }

    public final InterfaceC10258bL6 x1() {
        return AbstractC6459Nq2.c(this.m);
    }

    public final InterfaceC10258bL6 y1() {
        return this.p;
    }
}
