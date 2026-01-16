package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import coil.memory.MemoryCache;
import ir.nasim.InterfaceC3955Db3;
import java.util.List;

/* loaded from: classes2.dex */
public final class Q82 implements InterfaceC3955Db3 {
    public static final a f = new a(null);
    private final InterfaceC18663p23 a;
    private final I47 b;
    private final C19525qV5 c;
    private final II3 d;
    private final coil.memory.c e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private final Drawable a;
        private final boolean b;
        private final EnumC21699tz1 c;
        private final String d;

        public b(Drawable drawable, boolean z, EnumC21699tz1 enumC21699tz1, String str) {
            this.a = drawable;
            this.b = z;
            this.c = enumC21699tz1;
            this.d = str;
        }

        public static /* synthetic */ b b(b bVar, Drawable drawable, boolean z, EnumC21699tz1 enumC21699tz1, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = bVar.a;
            }
            if ((i & 2) != 0) {
                z = bVar.b;
            }
            if ((i & 4) != 0) {
                enumC21699tz1 = bVar.c;
            }
            if ((i & 8) != 0) {
                str = bVar.d;
            }
            return bVar.a(drawable, z, enumC21699tz1, str);
        }

        public final b a(Drawable drawable, boolean z, EnumC21699tz1 enumC21699tz1, String str) {
            return new b(drawable, z, enumC21699tz1, str);
        }

        public final EnumC21699tz1 c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final Drawable e() {
            return this.a;
        }

        public final boolean f() {
            return this.b;
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        int i;
        /* synthetic */ Object j;
        int l;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= RecyclerView.UNDEFINED_DURATION;
            return Q82.this.i(null, null, null, null, null, null, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        /* synthetic */ Object i;
        int k;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= RecyclerView.UNDEFINED_DURATION;
            return Q82.this.j(null, null, null, null, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 d;
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ W23 f;
        final /* synthetic */ Object g;
        final /* synthetic */ C12889fL5 h;
        final /* synthetic */ InterfaceC8217Va2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C12889fL5 c12889fL5, C12889fL5 c12889fL52, W23 w23, Object obj, C12889fL5 c12889fL53, InterfaceC8217Va2 interfaceC8217Va2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12889fL5;
            this.e = c12889fL52;
            this.f = w23;
            this.g = obj;
            this.h = c12889fL53;
            this.i = interfaceC8217Va2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Q82.this.new e(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Q82 q82 = Q82.this;
                WH6 wh6 = (WH6) this.d.a;
                C12087e11 c12087e11 = (C12087e11) this.e.a;
                W23 w23 = this.f;
                Object obj2 = this.g;
                IL4 il4 = (IL4) this.h.a;
                InterfaceC8217Va2 interfaceC8217Va2 = this.i;
                this.b = 1;
                obj = q82.i(wh6, c12087e11, w23, obj2, il4, interfaceC8217Va2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        int h;
        /* synthetic */ Object i;
        int k;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= RecyclerView.UNDEFINED_DURATION;
            return Q82.this.k(null, null, null, null, null, this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return Q82.this.a(null, this);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ W23 d;
        final /* synthetic */ Object e;
        final /* synthetic */ IL4 f;
        final /* synthetic */ InterfaceC8217Va2 g;
        final /* synthetic */ MemoryCache.Key h;
        final /* synthetic */ InterfaceC3955Db3.a i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(W23 w23, Object obj, IL4 il4, InterfaceC8217Va2 interfaceC8217Va2, MemoryCache.Key key, InterfaceC3955Db3.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = w23;
            this.e = obj;
            this.f = il4;
            this.g = interfaceC8217Va2;
            this.h = key;
            this.i = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Q82.this.new h(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Q82 q82 = Q82.this;
                W23 w23 = this.d;
                Object obj2 = this.e;
                IL4 il4 = this.f;
                InterfaceC8217Va2 interfaceC8217Va2 = this.g;
                this.b = 1;
                obj = q82.j(w23, obj2, il4, interfaceC8217Va2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            b bVar = (b) obj;
            Q82.this.b.c();
            return new I07(bVar.e(), this.d, bVar.c(), Q82.this.e.h(this.h, this.d, bVar) ? this.h : null, bVar.d(), bVar.f(), AbstractC18638p.t(this.i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ b i;
        final /* synthetic */ IL4 j;
        final /* synthetic */ List k;
        final /* synthetic */ InterfaceC8217Va2 l;
        final /* synthetic */ W23 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(b bVar, IL4 il4, List list, InterfaceC8217Va2 interfaceC8217Va2, W23 w23, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = bVar;
            this.j = il4;
            this.k = list;
            this.l = interfaceC8217Va2;
            this.m = w23;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = Q82.this.new i(this.i, this.j, this.k, this.l, this.m, interfaceC20295rm1);
            iVar.g = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Bitmap bitmapH;
            List list;
            IL4 il4;
            int size;
            int i;
            AbstractC14862ic3.e();
            int i2 = this.f;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.g;
                bitmapH = Q82.this.h(this.i.e(), this.j, this.k);
                this.l.e(this.m, bitmapH);
                list = this.k;
                il4 = this.j;
                size = list.size();
                i = 0;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                size = this.e;
                int i3 = this.d;
                il4 = (IL4) this.c;
                list = (List) this.b;
                interfaceC20315ro1 = (InterfaceC20315ro1) this.g;
                AbstractC10685c16.b(obj);
                bitmapH = (Bitmap) obj;
                AbstractC20906so1.f(interfaceC20315ro1);
                i = i3 + 1;
            }
            if (i >= size) {
                this.l.h(this.m, bitmapH);
                return b.b(this.i, new BitmapDrawable(this.m.l().getResources(), bitmapH), false, null, null, 14, null);
            }
            AbstractC18350oW3.a(list.get(i));
            il4.o();
            this.g = interfaceC20315ro1;
            this.b = list;
            this.c = il4;
            this.d = i;
            this.e = size;
            this.f = 1;
            throw null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public Q82(InterfaceC18663p23 interfaceC18663p23, I47 i47, C19525qV5 c19525qV5, II3 ii3) {
        this.a = interfaceC18663p23;
        this.b = i47;
        this.c = c19525qV5;
        this.d = ii3;
        this.e = new coil.memory.c(interfaceC18663p23, c19525qV5, ii3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap h(Drawable drawable, IL4 il4, List list) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config configC = AbstractC10667c.c(bitmap);
            if (AbstractC10242bK.U(AbstractC18638p.o(), configC)) {
                return bitmap;
            }
            II3 ii3 = this.d;
            if (ii3 != null && ii3.a() <= 4) {
                ii3.b("EngineInterceptor", 4, "Converting bitmap with config " + configC + " to apply transformations: " + list + '.', null);
            }
        } else {
            II3 ii32 = this.d;
            if (ii32 != null && ii32.a() <= 4) {
                ii32.b("EngineInterceptor", 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + list + '.', null);
            }
        }
        return N02.a.a(drawable, il4.f(), il4.o(), il4.n(), il4.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ac -> B:21:0x00b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.WH6 r18, ir.nasim.C12087e11 r19, ir.nasim.W23 r20, java.lang.Object r21, ir.nasim.IL4 r22, ir.nasim.InterfaceC8217Va2 r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q82.i(ir.nasim.WH6, ir.nasim.e11, ir.nasim.W23, java.lang.Object, ir.nasim.IL4, ir.nasim.Va2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134 A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #2 {all -> 0x00bf, blocks: (B:46:0x0129, B:48:0x0134, B:54:0x0174, B:56:0x0178, B:77:0x01e4, B:78:0x01e9, B:28:0x00a6, B:30:0x00b8, B:42:0x00ec, B:35:0x00c3, B:37:0x00d2, B:38:0x00d9, B:40:0x00df, B:41:0x00e6), top: B:91:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #2 {all -> 0x00bf, blocks: (B:46:0x0129, B:48:0x0134, B:54:0x0174, B:56:0x0178, B:77:0x01e4, B:78:0x01e9, B:28:0x00a6, B:30:0x00b8, B:42:0x00ec, B:35:0x00c3, B:37:0x00d2, B:38:0x00d9, B:40:0x00df, B:41:0x00e6), top: B:91:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(ir.nasim.W23 r27, java.lang.Object r28, ir.nasim.IL4 r29, ir.nasim.InterfaceC8217Va2 r30, ir.nasim.InterfaceC20295rm1 r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q82.j(ir.nasim.W23, java.lang.Object, ir.nasim.IL4, ir.nasim.Va2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:21:0x0095). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.C12087e11 r10, ir.nasim.W23 r11, java.lang.Object r12, ir.nasim.IL4 r13, ir.nasim.InterfaceC8217Va2 r14, ir.nasim.InterfaceC20295rm1 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q82.k(ir.nasim.e11, ir.nasim.W23, java.lang.Object, ir.nasim.IL4, ir.nasim.Va2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC3955Db3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC3955Db3.a r14, ir.nasim.InterfaceC20295rm1 r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof ir.nasim.Q82.g
            if (r0 == 0) goto L13
            r0 = r15
            ir.nasim.Q82$g r0 = (ir.nasim.Q82.g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Q82$g r0 = new ir.nasim.Q82$g
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r14 = r0.b
            ir.nasim.Db3$a r14 = (ir.nasim.InterfaceC3955Db3.a) r14
            java.lang.Object r0 = r0.a
            ir.nasim.Q82 r0 = (ir.nasim.Q82) r0
            ir.nasim.AbstractC10685c16.b(r15)     // Catch: java.lang.Throwable -> L32
            goto L9f
        L32:
            r15 = move-exception
            goto La0
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L3c:
            ir.nasim.AbstractC10685c16.b(r15)
            ir.nasim.W23 r6 = r14.getRequest()     // Catch: java.lang.Throwable -> L78
            java.lang.Object r15 = r6.m()     // Catch: java.lang.Throwable -> L78
            ir.nasim.PD6 r2 = r14.f()     // Catch: java.lang.Throwable -> L78
            ir.nasim.Va2 r9 = ir.nasim.AbstractC18638p.h(r14)     // Catch: java.lang.Throwable -> L78
            ir.nasim.qV5 r4 = r13.c     // Catch: java.lang.Throwable -> L78
            ir.nasim.IL4 r8 = r4.f(r6, r2)     // Catch: java.lang.Throwable -> L78
            ir.nasim.hc6 r4 = r8.n()     // Catch: java.lang.Throwable -> L78
            r9.r(r6, r15)     // Catch: java.lang.Throwable -> L78
            ir.nasim.p23 r5 = r13.a     // Catch: java.lang.Throwable -> L78
            ir.nasim.e11 r5 = r5.getComponents()     // Catch: java.lang.Throwable -> L78
            java.lang.Object r7 = r5.g(r15, r8)     // Catch: java.lang.Throwable -> L78
            r9.i(r6, r7)     // Catch: java.lang.Throwable -> L78
            coil.memory.c r15 = r13.e     // Catch: java.lang.Throwable -> L78
            coil.memory.MemoryCache$Key r10 = r15.f(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L78
            if (r10 == 0) goto L7b
            coil.memory.c r15 = r13.e     // Catch: java.lang.Throwable -> L78
            coil.memory.MemoryCache$b r15 = r15.a(r6, r10, r2, r4)     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r15 = move-exception
            r0 = r13
            goto La0
        L7b:
            r15 = 0
        L7c:
            if (r15 == 0) goto L85
            coil.memory.c r0 = r13.e     // Catch: java.lang.Throwable -> L78
            ir.nasim.I07 r14 = r0.g(r14, r6, r10, r15)     // Catch: java.lang.Throwable -> L78
            return r14
        L85:
            ir.nasim.go1 r15 = r6.v()     // Catch: java.lang.Throwable -> L78
            ir.nasim.Q82$h r2 = new ir.nasim.Q82$h     // Catch: java.lang.Throwable -> L78
            r12 = 0
            r4 = r2
            r5 = r13
            r11 = r14
            r4.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L78
            r0.a = r13     // Catch: java.lang.Throwable -> L78
            r0.b = r14     // Catch: java.lang.Throwable -> L78
            r0.e = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r15 = ir.nasim.AbstractC9323Zl0.g(r15, r2, r0)     // Catch: java.lang.Throwable -> L78
            if (r15 != r1) goto L9f
            return r1
        L9f:
            return r15
        La0:
            boolean r1 = r15 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto Laf
            ir.nasim.qV5 r0 = r0.c
            ir.nasim.W23 r14 = r14.getRequest()
            ir.nasim.ea2 r14 = r0.a(r14, r15)
            return r14
        Laf:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q82.a(ir.nasim.Db3$a, ir.nasim.rm1):java.lang.Object");
    }

    public final Object l(b bVar, W23 w23, IL4 il4, InterfaceC8217Va2 interfaceC8217Va2, InterfaceC20295rm1 interfaceC20295rm1) {
        List listO = w23.O();
        if (listO.isEmpty()) {
            return bVar;
        }
        if ((bVar.e() instanceof BitmapDrawable) || w23.g()) {
            return AbstractC9323Zl0.g(w23.N(), new i(bVar, il4, listO, interfaceC8217Va2, w23, null), interfaceC20295rm1);
        }
        II3 ii3 = this.d;
        if (ii3 != null && ii3.a() <= 4) {
            ii3.b("EngineInterceptor", 4, "allowConversionToBitmap=false, skipping transformations for type " + bVar.e().getClass().getCanonicalName() + '.', null);
        }
        return bVar;
    }
}
