package ir.nasim.features.call.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19123pp;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6535Nx5;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.B02;
import ir.nasim.C17660nL3;
import ir.nasim.C19938rB7;
import ir.nasim.EV4;
import ir.nasim.InterfaceC12532em2;
import ir.nasim.InterfaceC14415hs5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.RY1;
import ir.nasim.SA2;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* loaded from: classes5.dex */
public abstract class AvatarAsyncImagePainterKt {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(new SA2() { // from class: ir.nasim.CU
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AvatarAsyncImagePainterKt.b();
        }
    });

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AvatarAsyncImagePainterKt.e(null, null, false, this);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!(((RY1) this.c) instanceof RY1.b));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AvatarAsyncImagePainterKt.f(null, null, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!(((RY1) this.c) instanceof RY1.b));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String d;
        final /* synthetic */ AbstractC13778go1 e;
        final /* synthetic */ C17660nL3 f;
        final /* synthetic */ InterfaceC12532em2 g;
        final /* synthetic */ Avatar h;
        final /* synthetic */ boolean i;
        final /* synthetic */ int j;
        final /* synthetic */ Bitmap.Config k;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC12532em2 d;
            final /* synthetic */ Avatar e;
            final /* synthetic */ boolean f;
            final /* synthetic */ int g;
            final /* synthetic */ Bitmap.Config h;
            final /* synthetic */ String i;
            final /* synthetic */ InterfaceC14415hs5 j;
            final /* synthetic */ C17660nL3 k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC12532em2 interfaceC12532em2, Avatar avatar, boolean z, int i, Bitmap.Config config, String str, InterfaceC14415hs5 interfaceC14415hs5, C17660nL3 c17660nL3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC12532em2;
                this.e = avatar;
                this.f = z;
                this.g = i;
                this.h = config;
                this.i = str;
                this.j = interfaceC14415hs5;
                this.k = c17660nL3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                    InterfaceC12532em2 interfaceC12532em2 = this.d;
                    Avatar avatar = this.e;
                    boolean z = this.f;
                    this.c = interfaceC20315ro12;
                    this.b = 1;
                    Object objE2 = AvatarAsyncImagePainterKt.e(interfaceC12532em2, avatar, z, this);
                    if (objE2 == objE) {
                        return objE;
                    }
                    interfaceC20315ro1 = interfaceC20315ro12;
                    obj = objE2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10685c16.b(obj);
                }
                RY1.a aVar = (RY1.a) obj;
                if (aVar != null) {
                    boolean z2 = this.f;
                    int i2 = this.g;
                    Bitmap.Config config = this.h;
                    String str = this.i;
                    InterfaceC14415hs5 interfaceC14415hs5 = this.j;
                    C17660nL3 c17660nL3 = this.k;
                    Drawable drawableCreateFromPath = Drawable.createFromPath(aVar.a().getDescriptor());
                    if (drawableCreateFromPath != null) {
                        Bitmap bitmapDecodeFile = z2 ? BitmapFactory.decodeFile(aVar.a().getDescriptor()) : B02.a(drawableCreateFromPath, Math.min(drawableCreateFromPath.getIntrinsicWidth(), i2), Math.min(drawableCreateFromPath.getIntrinsicHeight(), i2), config);
                        if (str != null) {
                            AbstractC13042fc3.f(bitmapDecodeFile);
                        }
                        AbstractC13042fc3.f(bitmapDecodeFile);
                        interfaceC14415hs5.setValue(new BitmapPainter(AbstractC19123pp.c(bitmapDecodeFile), 0L, 0L, 6, null));
                    }
                }
                AbstractC20906so1.f(interfaceC20315ro1);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, AbstractC13778go1 abstractC13778go1, C17660nL3 c17660nL3, InterfaceC12532em2 interfaceC12532em2, Avatar avatar, boolean z, int i, Bitmap.Config config, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = abstractC13778go1;
            this.f = c17660nL3;
            this.g = interfaceC12532em2;
            this.h = avatar;
            this.i = z;
            this.j = i;
            this.k = config;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                String str = this.d;
                if (str != null && (bitmap = (Bitmap) this.f.d(str)) != null) {
                    interfaceC14415hs5.setValue(new BitmapPainter(AbstractC19123pp.c(bitmap), 0L, 0L, 6, null));
                    return C19938rB7.a;
                }
                AbstractC13778go1 abstractC13778go1 = this.e;
                a aVar = new a(this.g, this.h, this.i, this.j, this.k, this.d, interfaceC14415hs5, this.f, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17660nL3 b() {
        return new C17660nL3(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(ir.nasim.InterfaceC12532em2 r16, ir.nasim.core.modules.profile.entity.Avatar r17, boolean r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.ui.AvatarAsyncImagePainterKt.e(ir.nasim.em2, ir.nasim.core.modules.profile.entity.Avatar, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(ir.nasim.InterfaceC12532em2 r16, ir.nasim.core.modules.profile.entity.Avatar r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.ui.AvatarAsyncImagePainterKt.f(ir.nasim.em2, ir.nasim.core.modules.profile.entity.Avatar, ir.nasim.rm1):java.lang.Object");
    }

    public static final AbstractC6535Nx5 g() {
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.EV4 h(ir.nasim.core.modules.profile.entity.Avatar r25, ir.nasim.EV4 r26, boolean r27, int r28, ir.nasim.InterfaceC22053ub1 r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.ui.AvatarAsyncImagePainterKt.h(ir.nasim.core.modules.profile.entity.Avatar, ir.nasim.EV4, boolean, int, ir.nasim.ub1, int, int):ir.nasim.EV4");
    }

    private static final EV4 i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (EV4) interfaceC9664aL6.getValue();
    }
}
