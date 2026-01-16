package ir.nasim;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.j;
import ir.nasim.InterfaceC16863lz6;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public abstract class Ga8 {
    private static final Map a = new LinkedHashMap();

    public static final class b implements androidx.lifecycle.n {
        final /* synthetic */ InterfaceC20315ro1 a;
        final /* synthetic */ J15 b;
        final /* synthetic */ SJ5 c;
        final /* synthetic */ C12889fL5 d;
        final /* synthetic */ View e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[j.a.values().length];
                try {
                    iArr[j.a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[j.a.ON_START.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[j.a.ON_STOP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[j.a.ON_DESTROY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[j.a.ON_PAUSE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[j.a.ON_RESUME.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[j.a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.Ga8$b$b, reason: collision with other inner class name */
        static final class C0391b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ SJ5 e;
            final /* synthetic */ InterfaceC18633oz3 f;
            final /* synthetic */ b g;
            final /* synthetic */ View h;

            /* renamed from: ir.nasim.Ga8$b$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC10258bL6 c;
                final /* synthetic */ C9897ak4 d;

                /* renamed from: ir.nasim.Ga8$b$b$a$a, reason: collision with other inner class name */
                static final class C0392a implements InterfaceC4806Gq2 {
                    final /* synthetic */ C9897ak4 a;

                    C0392a(C9897ak4 c9897ak4) {
                        this.a = c9897ak4;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return b(((Number) obj).floatValue(), interfaceC20295rm1);
                    }

                    public final Object b(float f, InterfaceC20295rm1 interfaceC20295rm1) {
                        this.a.f(f);
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(InterfaceC10258bL6 interfaceC10258bL6, C9897ak4 c9897ak4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC10258bL6;
                    this.d = c9897ak4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                        C0392a c0392a = new C0392a(this.d);
                        this.b = 1;
                        if (interfaceC10258bL6.b(c0392a, this) == objE) {
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
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0391b(C12889fL5 c12889fL5, SJ5 sj5, InterfaceC18633oz3 interfaceC18633oz3, b bVar, View view, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12889fL5;
                this.e = sj5;
                this.f = interfaceC18633oz3;
                this.g = bVar;
                this.h = view;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0391b c0391b = new C0391b(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
                c0391b.c = obj;
                return c0391b;
            }

            /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                /*
                    r11 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r11.b
                    r2 = 1
                    r3 = 0
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r0 = r11.c
                    ir.nasim.gj3 r0 = (ir.nasim.InterfaceC13730gj3) r0
                    ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.lang.Throwable -> L14
                    goto L6a
                L14:
                    r12 = move-exception
                    goto L81
                L17:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L1f:
                    ir.nasim.AbstractC10685c16.b(r12)
                    java.lang.Object r12 = r11.c
                    r4 = r12
                    ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                    ir.nasim.fL5 r12 = r11.d     // Catch: java.lang.Throwable -> L58
                    java.lang.Object r12 = r12.a     // Catch: java.lang.Throwable -> L58
                    ir.nasim.ak4 r12 = (ir.nasim.C9897ak4) r12     // Catch: java.lang.Throwable -> L58
                    if (r12 == 0) goto L5b
                    android.view.View r1 = r11.h     // Catch: java.lang.Throwable -> L58
                    android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L58
                    android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Throwable -> L58
                    ir.nasim.bL6 r1 = ir.nasim.Ga8.a(r1)     // Catch: java.lang.Throwable -> L58
                    java.lang.Object r5 = r1.getValue()     // Catch: java.lang.Throwable -> L58
                    java.lang.Number r5 = (java.lang.Number) r5     // Catch: java.lang.Throwable -> L58
                    float r5 = r5.floatValue()     // Catch: java.lang.Throwable -> L58
                    r12.f(r5)     // Catch: java.lang.Throwable -> L58
                    ir.nasim.Ga8$b$b$a r7 = new ir.nasim.Ga8$b$b$a     // Catch: java.lang.Throwable -> L58
                    r7.<init>(r1, r12, r3)     // Catch: java.lang.Throwable -> L58
                    r8 = 3
                    r9 = 0
                    r5 = 0
                    r6 = 0
                    ir.nasim.gj3 r12 = ir.nasim.AbstractC9323Zl0.d(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L58
                    goto L5c
                L58:
                    r12 = move-exception
                    r0 = r3
                    goto L81
                L5b:
                    r12 = r3
                L5c:
                    ir.nasim.SJ5 r1 = r11.e     // Catch: java.lang.Throwable -> L7d
                    r11.c = r12     // Catch: java.lang.Throwable -> L7d
                    r11.b = r2     // Catch: java.lang.Throwable -> L7d
                    java.lang.Object r1 = r1.z0(r11)     // Catch: java.lang.Throwable -> L7d
                    if (r1 != r0) goto L69
                    return r0
                L69:
                    r0 = r12
                L6a:
                    if (r0 == 0) goto L6f
                    ir.nasim.InterfaceC13730gj3.a.a(r0, r3, r2, r3)
                L6f:
                    ir.nasim.oz3 r12 = r11.f
                    androidx.lifecycle.j r12 = r12.getLifecycle()
                    ir.nasim.Ga8$b r0 = r11.g
                    r12.d(r0)
                    ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                    return r12
                L7d:
                    r0 = move-exception
                    r10 = r0
                    r0 = r12
                    r12 = r10
                L81:
                    if (r0 == 0) goto L86
                    ir.nasim.InterfaceC13730gj3.a.a(r0, r3, r2, r3)
                L86:
                    ir.nasim.oz3 r0 = r11.f
                    androidx.lifecycle.j r0 = r0.getLifecycle()
                    ir.nasim.Ga8$b r1 = r11.g
                    r0.d(r1)
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Ga8.b.C0391b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0391b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20315ro1 interfaceC20315ro1, J15 j15, SJ5 sj5, C12889fL5 c12889fL5, View view) {
            this.a = interfaceC20315ro1;
            this.b = j15;
            this.c = sj5;
            this.d = c12889fL5;
            this.e = view;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            int i = a.a[aVar.ordinal()];
            if (i == 1) {
                AbstractC10533bm0.d(this.a, null, EnumC23959xo1.UNDISPATCHED, new C0391b(this.d, this.c, interfaceC18633oz3, this, this.e, null), 1, null);
                return;
            }
            if (i == 2) {
                J15 j15 = this.b;
                if (j15 != null) {
                    j15.h();
                }
                this.c.y0();
                return;
            }
            if (i == 3) {
                this.c.l0();
            } else {
                if (i != 4) {
                    return;
                }
                this.c.Y();
            }
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ ContentResolver e;
        final /* synthetic */ Uri f;
        final /* synthetic */ d g;
        final /* synthetic */ InterfaceC17639nJ0 h;
        final /* synthetic */ Context i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ContentResolver contentResolver, Uri uri, d dVar, InterfaceC17639nJ0 interfaceC17639nJ0, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = contentResolver;
            this.f = uri;
            this.g = dVar;
            this.h = interfaceC17639nJ0;
            this.i = context;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
            cVar.d = obj;
            return cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:7:0x0016, B:18:0x0048, B:22:0x0058, B:24:0x0060, B:14:0x002d, B:17:0x0042), top: B:31:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:8:0x0019). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L31
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                java.lang.Object r1 = r8.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r4 = r8.d
                ir.nasim.Gq2 r4 = (ir.nasim.InterfaceC4806Gq2) r4
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L1b
            L19:
                r9 = r4
                goto L48
            L1b:
                r9 = move-exception
                goto L8c
            L1d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L25:
                java.lang.Object r1 = r8.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r4 = r8.d
                ir.nasim.Gq2 r4 = (ir.nasim.InterfaceC4806Gq2) r4
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L1b
                goto L58
            L31:
                ir.nasim.AbstractC10685c16.b(r9)
                java.lang.Object r9 = r8.d
                ir.nasim.Gq2 r9 = (ir.nasim.InterfaceC4806Gq2) r9
                android.content.ContentResolver r1 = r8.e
                android.net.Uri r4 = r8.f
                r5 = 0
                ir.nasim.Ga8$d r6 = r8.g
                r1.registerContentObserver(r4, r5, r6)
                ir.nasim.nJ0 r1 = r8.h     // Catch: java.lang.Throwable -> L1b
                ir.nasim.CJ0 r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1b
            L48:
                r8.d = r9     // Catch: java.lang.Throwable -> L1b
                r8.b = r1     // Catch: java.lang.Throwable -> L1b
                r8.c = r3     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r4 = r1.a(r8)     // Catch: java.lang.Throwable -> L1b
                if (r4 != r0) goto L55
                return r0
            L55:
                r7 = r4
                r4 = r9
                r9 = r7
            L58:
                java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L1b
                boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L1b
                if (r9 == 0) goto L82
                r1.next()     // Catch: java.lang.Throwable -> L1b
                android.content.Context r9 = r8.i     // Catch: java.lang.Throwable -> L1b
                android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L1b
                java.lang.String r5 = "animator_duration_scale"
                r6 = 1065353216(0x3f800000, float:1.0)
                float r9 = android.provider.Settings.Global.getFloat(r9, r5, r6)     // Catch: java.lang.Throwable -> L1b
                java.lang.Float r9 = ir.nasim.AbstractC6392Nk0.c(r9)     // Catch: java.lang.Throwable -> L1b
                r8.d = r4     // Catch: java.lang.Throwable -> L1b
                r8.b = r1     // Catch: java.lang.Throwable -> L1b
                r8.c = r2     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r9 = r4.a(r9, r8)     // Catch: java.lang.Throwable -> L1b
                if (r9 != r0) goto L19
                return r0
            L82:
                android.content.ContentResolver r9 = r8.e
                ir.nasim.Ga8$d r0 = r8.g
                r9.unregisterContentObserver(r0)
                ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                return r9
            L8c:
                android.content.ContentResolver r0 = r8.e
                ir.nasim.Ga8$d r1 = r8.g
                r0.unregisterContentObserver(r1)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Ga8.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d extends ContentObserver {
        final /* synthetic */ InterfaceC17639nJ0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC17639nJ0 interfaceC17639nJ0, Handler handler) {
            super(handler);
            this.a = interfaceC17639nJ0;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            this.a.h(C19938rB7.a);
        }
    }

    public static final SJ5 b(View view, InterfaceC11938do1 interfaceC11938do1, androidx.lifecycle.j jVar) {
        J15 j15;
        if (interfaceC11938do1.a(InterfaceC22753vm1.g0) == null || interfaceC11938do1.a(InterfaceC15522jj4.o0) == null) {
            interfaceC11938do1 = C20343rr.m.a().X(interfaceC11938do1);
        }
        InterfaceC15522jj4 interfaceC15522jj4 = (InterfaceC15522jj4) interfaceC11938do1.a(InterfaceC15522jj4.o0);
        if (interfaceC15522jj4 != null) {
            J15 j152 = new J15(interfaceC15522jj4);
            j152.f();
            j15 = j152;
        } else {
            j15 = null;
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        InterfaceC11938do1 c9897ak4 = (InterfaceC9309Zj4) interfaceC11938do1.a(InterfaceC9309Zj4.p0);
        if (c9897ak4 == null) {
            c9897ak4 = new C9897ak4();
            c12889fL5.a = c9897ak4;
        }
        InterfaceC11938do1 interfaceC11938do1X = interfaceC11938do1.X(j15 != null ? j15 : C18712p72.a).X(c9897ak4);
        SJ5 sj5 = new SJ5(interfaceC11938do1X);
        sj5.l0();
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(interfaceC11938do1X);
        if (jVar == null) {
            InterfaceC18633oz3 interfaceC18633oz3A = VX7.a(view);
            jVar = interfaceC18633oz3A != null ? interfaceC18633oz3A.getLifecycle() : null;
        }
        if (jVar != null) {
            view.addOnAttachStateChangeListener(new a(view, sj5));
            jVar.a(new b(interfaceC20315ro1A, j15, sj5, c12889fL5, view));
            return sj5;
        }
        M73.c("ViewTreeLifecycleOwner not found from " + view);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ SJ5 c(View view, InterfaceC11938do1 interfaceC11938do1, androidx.lifecycle.j jVar, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i & 2) != 0) {
            jVar = null;
        }
        return b(view, interfaceC11938do1, jVar);
    }

    public static final AbstractC7050Qb1 d(View view) {
        AbstractC7050Qb1 abstractC7050Qb1F = f(view);
        if (abstractC7050Qb1F != null) {
            return abstractC7050Qb1F;
        }
        for (ViewParent parent = view.getParent(); abstractC7050Qb1F == null && (parent instanceof View); parent = parent.getParent()) {
            abstractC7050Qb1F = f((View) parent);
        }
        return abstractC7050Qb1F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 e(Context context) {
        InterfaceC10258bL6 interfaceC10258bL6;
        Map map = a;
        synchronized (map) {
            try {
                Object objO0 = map.get(context);
                if (objO0 == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    InterfaceC17639nJ0 interfaceC17639nJ0B = DJ0.b(-1, null, null, 6, null);
                    objO0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.R(new c(contentResolver, uriFor, new d(interfaceC17639nJ0B, AbstractC18913pT2.a(Looper.getMainLooper())), interfaceC17639nJ0B, context, null)), AbstractC20906so1.b(), InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    map.put(context, objO0);
                }
                interfaceC10258bL6 = (InterfaceC10258bL6) objO0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC10258bL6;
    }

    public static final AbstractC7050Qb1 f(View view) {
        Object tag = view.getTag(AbstractC22421vC5.androidx_compose_ui_view_composition_context);
        if (tag instanceof AbstractC7050Qb1) {
            return (AbstractC7050Qb1) tag;
        }
        return null;
    }

    private static final View g(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    public static final SJ5 h(View view) {
        if (!view.isAttachedToWindow()) {
            M73.b("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        View viewG = g(view);
        AbstractC7050Qb1 abstractC7050Qb1F = f(viewG);
        if (abstractC7050Qb1F == null) {
            return Fa8.a.a(viewG);
        }
        if (abstractC7050Qb1F instanceof SJ5) {
            return (SJ5) abstractC7050Qb1F;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static final void i(View view, AbstractC7050Qb1 abstractC7050Qb1) {
        view.setTag(AbstractC22421vC5.androidx_compose_ui_view_composition_context, abstractC7050Qb1);
    }

    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ SJ5 b;

        a(View view, SJ5 sj5) {
            this.a = view;
            this.b = sj5;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.Y();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
