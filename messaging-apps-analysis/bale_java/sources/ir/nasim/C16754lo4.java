package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.lo4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16754lo4 extends VW7 {
    public static final a v = new a(null);
    public static final int w = 8;
    private InterfaceC9102Ym4 b = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    private InterfaceC9336Zm4 c;
    private InterfaceC4557Fq2 d;
    private InterfaceC4557Fq2 e;
    private InterfaceC4557Fq2 f;
    private InterfaceC4557Fq2 g;
    private InterfaceC4557Fq2 h;
    private final InterfaceC4557Fq2 i;
    private final InterfaceC4557Fq2 j;
    private final InterfaceC4557Fq2 k;
    private final InterfaceC4557Fq2 l;
    private InterfaceC4557Fq2 m;
    private List n;
    private List o;
    private List p;
    private List q;
    private List r;
    private List s;
    private InterfaceC4557Fq2 t;
    private String u;

    /* renamed from: ir.nasim.lo4$a */
    public static final class a {
        private a() {
        }

        public final Bitmap a(InterfaceC3346Am2 interfaceC3346Am2) {
            if (interfaceC3346Am2 == null) {
                return null;
            }
            String descriptor = interfaceC3346Am2.getDescriptor();
            if (descriptor == null) {
                descriptor = "";
            }
            Drawable drawableCreateFromPath = Drawable.createFromPath(descriptor);
            if (drawableCreateFromPath != null) {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Bitmap bitmapB = B02.b(drawableCreateFromPath, aVar.f(44.0f), aVar.f(44.0f), null, 4, null);
                if (bitmapB != null) {
                    return bitmapB;
                }
            }
            return null;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.lo4$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C16754lo4 b;

        /* renamed from: ir.nasim.lo4$b$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C16754lo4 b;

            /* renamed from: ir.nasim.lo4$b$a$a, reason: collision with other inner class name */
            public static final class C1386a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1386a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C16754lo4 c16754lo4) {
                this.a = interfaceC4806Gq2;
                this.b = c16754lo4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C16754lo4.b.a.C1386a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.lo4$b$a$a r0 = (ir.nasim.C16754lo4.b.a.C1386a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.lo4$b$a$a r0 = new ir.nasim.lo4$b$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L72
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    ir.nasim.lo4 r2 = r7.b
                    java.util.List r2 = ir.nasim.C16754lo4.V0(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L49:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L64
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.jO2 r6 = (ir.nasim.C15322jO2) r6
                    java.lang.String r6 = r6.e()
                    boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r8, r3)
                    if (r6 == 0) goto L49
                    r4.add(r5)
                    goto L49
                L64:
                    ir.nasim.qT1$c r8 = new ir.nasim.qT1$c
                    r8.<init>(r4)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L72
                    return r1
                L72:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16754lo4.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2, C16754lo4 c16754lo4) {
            this.a = interfaceC4557Fq2;
            this.b = c16754lo4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lo4$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C16754lo4 b;

        /* renamed from: ir.nasim.lo4$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C16754lo4 b;

            /* renamed from: ir.nasim.lo4$c$a$a, reason: collision with other inner class name */
            public static final class C1387a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1387a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C16754lo4 c16754lo4) {
                this.a = interfaceC4806Gq2;
                this.b = c16754lo4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C16754lo4.c.a.C1387a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.lo4$c$a$a r0 = (ir.nasim.C16754lo4.c.a.C1387a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.lo4$c$a$a r0 = new ir.nasim.lo4$c$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L72
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    ir.nasim.lo4 r2 = r7.b
                    java.util.List r2 = ir.nasim.C16754lo4.X0(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L49:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L64
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.jO2 r6 = (ir.nasim.C15322jO2) r6
                    java.lang.String r6 = r6.e()
                    boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r8, r3)
                    if (r6 == 0) goto L49
                    r4.add(r5)
                    goto L49
                L64:
                    ir.nasim.qT1$c r8 = new ir.nasim.qT1$c
                    r8.<init>(r4)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L72
                    return r1
                L72:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16754lo4.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C16754lo4 c16754lo4) {
            this.a = interfaceC4557Fq2;
            this.b = c16754lo4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lo4$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C16754lo4 b;

        /* renamed from: ir.nasim.lo4$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C16754lo4 b;

            /* renamed from: ir.nasim.lo4$d$a$a, reason: collision with other inner class name */
            public static final class C1388a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1388a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C16754lo4 c16754lo4) {
                this.a = interfaceC4806Gq2;
                this.b = c16754lo4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C16754lo4.d.a.C1388a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.lo4$d$a$a r0 = (ir.nasim.C16754lo4.d.a.C1388a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.lo4$d$a$a r0 = new ir.nasim.lo4$d$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L72
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    ir.nasim.lo4 r2 = r7.b
                    java.util.List r2 = ir.nasim.C16754lo4.W0(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L49:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L64
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.jO2 r6 = (ir.nasim.C15322jO2) r6
                    java.lang.String r6 = r6.e()
                    boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r8, r3)
                    if (r6 == 0) goto L49
                    r4.add(r5)
                    goto L49
                L64:
                    ir.nasim.qT1$c r8 = new ir.nasim.qT1$c
                    r8.<init>(r4)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L72
                    return r1
                L72:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16754lo4.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2, C16754lo4 c16754lo4) {
            this.a = interfaceC4557Fq2;
            this.b = c16754lo4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lo4$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C16754lo4 b;

        /* renamed from: ir.nasim.lo4$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C16754lo4 b;

            /* renamed from: ir.nasim.lo4$e$a$a, reason: collision with other inner class name */
            public static final class C1389a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1389a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C16754lo4 c16754lo4) {
                this.a = interfaceC4806Gq2;
                this.b = c16754lo4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C16754lo4.e.a.C1389a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.lo4$e$a$a r0 = (ir.nasim.C16754lo4.e.a.C1389a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.lo4$e$a$a r0 = new ir.nasim.lo4$e$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L72
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    ir.nasim.lo4 r2 = r7.b
                    java.util.List r2 = ir.nasim.C16754lo4.Y0(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L49:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L64
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.jO2 r6 = (ir.nasim.C15322jO2) r6
                    java.lang.String r6 = r6.e()
                    boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r8, r3)
                    if (r6 == 0) goto L49
                    r4.add(r5)
                    goto L49
                L64:
                    ir.nasim.qT1$c r8 = new ir.nasim.qT1$c
                    r8.<init>(r4)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L72
                    return r1
                L72:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16754lo4.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2, C16754lo4 c16754lo4) {
            this.a = interfaceC4557Fq2;
            this.b = c16754lo4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lo4$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C16754lo4 b;

        /* renamed from: ir.nasim.lo4$f$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C16754lo4 b;

            /* renamed from: ir.nasim.lo4$f$a$a, reason: collision with other inner class name */
            public static final class C1390a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1390a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C16754lo4 c16754lo4) {
                this.a = interfaceC4806Gq2;
                this.b = c16754lo4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r11, ir.nasim.InterfaceC20295rm1 r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof ir.nasim.C16754lo4.f.a.C1390a
                    if (r0 == 0) goto L13
                    r0 = r12
                    ir.nasim.lo4$f$a$a r0 = (ir.nasim.C16754lo4.f.a.C1390a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.lo4$f$a$a r0 = new ir.nasim.lo4$f$a$a
                    r0.<init>(r12)
                L18:
                    java.lang.Object r12 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r12)
                    goto L8a
                L29:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L31:
                    ir.nasim.AbstractC10685c16.b(r12)
                    ir.nasim.Gq2 r12 = r10.a
                    java.lang.String r11 = (java.lang.String) r11
                    ir.nasim.lo4 r2 = r10.b
                    java.util.List r2 = ir.nasim.C16754lo4.Z0(r2)
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r2 = r2.iterator()
                L49:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L7c
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    ir.nasim.nI7 r6 = (ir.nasim.C17637nI7) r6
                    ir.nasim.tK7 r7 = new ir.nasim.tK7
                    r7.<init>(r6)
                    ir.nasim.core.modules.profile.entity.ExPeerType r8 = r7.n()
                    ir.nasim.core.modules.profile.entity.ExPeerType r9 = ir.nasim.core.modules.profile.entity.ExPeerType.BOT
                    if (r8 != r9) goto L49
                    boolean r7 = r7.y()
                    if (r7 == 0) goto L49
                    java.lang.String r6 = r6.getName()
                    java.lang.String r7 = "getName(...)"
                    ir.nasim.AbstractC13042fc3.h(r6, r7)
                    boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r11, r3)
                    if (r6 == 0) goto L49
                    r4.add(r5)
                    goto L49
                L7c:
                    ir.nasim.qT1$c r11 = new ir.nasim.qT1$c
                    r11.<init>(r4)
                    r0.b = r3
                    java.lang.Object r11 = r12.a(r11, r0)
                    if (r11 != r1) goto L8a
                    return r1
                L8a:
                    ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16754lo4.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, C16754lo4 c16754lo4) {
            this.a = interfaceC4557Fq2;
            this.b = c16754lo4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C16754lo4() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Separators.DOT);
        this.c = interfaceC9336Zm4A;
        this.d = new b(interfaceC9336Zm4A, this);
        this.e = new c(this.c, this);
        this.f = new d(this.c, this);
        this.g = new e(this.c, this);
        this.h = new f(this.c, this);
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
        AbstractC13042fc3.g(interfaceC4557Fq2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.features.bank.mybank.flow.DialogsState<*>>");
        this.i = interfaceC4557Fq2;
        InterfaceC4557Fq2 interfaceC4557Fq22 = this.e;
        AbstractC13042fc3.g(interfaceC4557Fq22, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.features.bank.mybank.flow.DialogsState<*>>");
        this.j = interfaceC4557Fq22;
        InterfaceC4557Fq2 interfaceC4557Fq23 = this.f;
        AbstractC13042fc3.g(interfaceC4557Fq23, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.features.bank.mybank.flow.DialogsState<*>>");
        this.k = interfaceC4557Fq23;
        InterfaceC4557Fq2 interfaceC4557Fq24 = this.g;
        AbstractC13042fc3.g(interfaceC4557Fq24, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.features.bank.mybank.flow.DialogsState<*>>");
        this.l = interfaceC4557Fq24;
        InterfaceC4557Fq2 interfaceC4557Fq25 = this.h;
        AbstractC13042fc3.g(interfaceC4557Fq25, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.features.bank.mybank.flow.DialogsState<*>>");
        this.m = interfaceC4557Fq25;
        this.n = AbstractC10360bX0.m();
        this.o = AbstractC10360bX0.m();
        this.p = AbstractC10360bX0.m();
        this.q = AbstractC10360bX0.m();
        this.r = AbstractC10360bX0.m();
        List listK = AbstractC5969Lp4.e().A().m0().k();
        AbstractC13042fc3.h(listK, "getAllValue(...)");
        this.s = AbstractC15401jX0.m1(listK);
        this.u = "";
        AbstractC5969Lp4.b().o().h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.io4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C16754lo4.T0(this.a, (List) obj);
            }
        });
        AbstractC5969Lp4.e().W().p0().h().m0(new InterfaceC24449ye1() { // from class: ir.nasim.jo4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C16754lo4.U0(this.a, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C16754lo4 c16754lo4, List list) {
        C19482qQ7 c19482qQ7Z;
        C19482qQ7 c19482qQ7S;
        C19482qQ7 c19482qQ7Z2;
        C19482qQ7 c19482qQ7S2;
        AbstractC13042fc3.i(c16754lo4, "this$0");
        AbstractC13042fc3.f(list);
        List list2 = list;
        ArrayList<C14697iL2> arrayList = new ArrayList();
        for (Object obj : list2) {
            C14697iL2 c14697iL2 = (C14697iL2) obj;
            if (c14697iL2.getExPeerType() == ExPeerType.CHANNEL && c14697iL2.D()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        for (C14697iL2 c14697iL22 : arrayList) {
            long jU = c14697iL22.I0().u();
            String strG0 = c14697iL22.G0();
            AbstractC13042fc3.h(strG0, "getTitle(...)");
            arrayList2.add(new C15322jO2(jU, strG0, c14697iL22.t0(), c14697iL22.h0(), c14697iL22.D()));
        }
        c16754lo4.p = arrayList2;
        ArrayList<C14697iL2> arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            C14697iL2 c14697iL23 = (C14697iL2) obj2;
            if (c14697iL23.getExPeerType() == ExPeerType.GROUP && c14697iL23.D()) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(arrayList3, 10));
        for (C14697iL2 c14697iL24 : arrayList3) {
            long jU2 = c14697iL24.I0().u();
            String strG02 = c14697iL24.G0();
            AbstractC13042fc3.h(strG02, "getTitle(...)");
            arrayList4.add(new C15322jO2(jU2, strG02, c14697iL24.t0(), c14697iL24.h0(), c14697iL24.D()));
        }
        c16754lo4.n = arrayList4;
        ArrayList<C14697iL2> arrayList5 = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            C24119y45 c24119y45 = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            C14697iL2 c14697iL25 = (C14697iL2) next;
            if (c14697iL25.getExPeerType() == ExPeerType.CHANNEL && c14697iL25.D() && c14697iL25.H0()) {
                C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c14697iL25.p0());
                if (c14733iO2 == null || c14733iO2.x() != AbstractC5969Lp4.f()) {
                    C23104wM2 c23104wM2 = (c14733iO2 == null || (c19482qQ7S2 = c14733iO2.s()) == null) ? null : (C23104wM2) c19482qQ7S2.b();
                    if (c14733iO2 != null && (c19482qQ7Z2 = c14733iO2.z()) != null) {
                        c24119y45 = (C24119y45) c19482qQ7Z2.b();
                    }
                    if (c23104wM2 != null && c23104wM2.j() && c24119y45 != null && c24119y45.i()) {
                        arrayList5.add(next);
                    }
                } else if (c14733iO2.x() == AbstractC5969Lp4.f()) {
                    arrayList5.add(next);
                }
            }
        }
        ArrayList arrayList6 = new ArrayList(AbstractC10976cX0.x(arrayList5, 10));
        for (C14697iL2 c14697iL26 : arrayList5) {
            long jU3 = c14697iL26.I0().u();
            String strG03 = c14697iL26.G0();
            AbstractC13042fc3.h(strG03, "getTitle(...)");
            arrayList6.add(new C15322jO2(jU3, strG03, c14697iL26.t0(), c14697iL26.h0(), c14697iL26.D()));
        }
        c16754lo4.q = arrayList6;
        ArrayList<C14697iL2> arrayList7 = new ArrayList();
        for (Object obj3 : list2) {
            C14697iL2 c14697iL27 = (C14697iL2) obj3;
            if (c14697iL27.getExPeerType() == ExPeerType.GROUP && c14697iL27.D() && c14697iL27.H0()) {
                C14733iO2 c14733iO22 = (C14733iO2) AbstractC5969Lp4.b().n(c14697iL27.p0());
                if (c14733iO22 == null || c14733iO22.x() != AbstractC5969Lp4.f()) {
                    C23104wM2 c23104wM22 = (c14733iO22 == null || (c19482qQ7S = c14733iO22.s()) == null) ? null : (C23104wM2) c19482qQ7S.b();
                    C24119y45 c24119y452 = (c14733iO22 == null || (c19482qQ7Z = c14733iO22.z()) == null) ? null : (C24119y45) c19482qQ7Z.b();
                    if (c23104wM22 != null && c23104wM22.j() && c24119y452 != null && c24119y452.i()) {
                        arrayList7.add(obj3);
                    }
                } else if (c14733iO22.x() == AbstractC5969Lp4.f()) {
                    arrayList7.add(obj3);
                }
            }
        }
        ArrayList arrayList8 = new ArrayList(AbstractC10976cX0.x(arrayList7, 10));
        for (C14697iL2 c14697iL28 : arrayList7) {
            long jU4 = c14697iL28.I0().u();
            String strG04 = c14697iL28.G0();
            AbstractC13042fc3.h(strG04, "getTitle(...)");
            arrayList8.add(new C15322jO2(jU4, strG04, c14697iL28.t0(), c14697iL28.h0(), c14697iL28.D()));
        }
        c16754lo4.o = arrayList8;
        c16754lo4.a1("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C16754lo4 c16754lo4, List list) {
        AbstractC13042fc3.i(c16754lo4, "this$0");
        AbstractC13042fc3.f(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            C17637nI7 c17637nI7 = (C17637nI7) obj;
            if (c17637nI7.getExPeerType() == ExPeerType.BOT && c17637nI7.p0()) {
                arrayList.add(obj);
            }
        }
        c16754lo4.r = arrayList;
        c16754lo4.a1("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 d1(String str, C16754lo4 c16754lo4) {
        AbstractC13042fc3.i(str, "$search");
        AbstractC13042fc3.i(c16754lo4, "this$0");
        return new C10504bj1(str, c16754lo4.s);
    }

    public final void a1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "value");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final InterfaceC4557Fq2 b1() {
        return this.i;
    }

    public final InterfaceC4557Fq2 c1(final String str) {
        AbstractC13042fc3.i(str, "search");
        if (this.t == null || !AbstractC13042fc3.d(str, this.u)) {
            this.u = str;
            this.t = AbstractC9395Zt0.a(new C12960fT4(new MT4(10, 0, false, 15, 0, 0, 50, null), null, new SA2() { // from class: ir.nasim.ko4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C16754lo4.d1(str, this);
                }
            }, 2, null).a(), AbstractC9773aX7.a(this));
        }
        InterfaceC4557Fq2 interfaceC4557Fq2 = this.t;
        AbstractC13042fc3.f(interfaceC4557Fq2);
        return interfaceC4557Fq2;
    }

    public final InterfaceC4557Fq2 e1() {
        return this.k;
    }

    public final InterfaceC9102Ym4 f1() {
        return this.b;
    }

    public final void g1(boolean z) {
        this.b.setValue(Boolean.valueOf(z));
    }
}
