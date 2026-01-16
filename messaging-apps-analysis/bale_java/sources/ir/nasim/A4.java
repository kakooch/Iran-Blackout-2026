package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class A4 extends VW7 {
    private final C9057Yh4 b;
    private final DG2 c;
    private final C24824zG2 d;
    private final T9 e;
    private final HN5 f;
    private final TF3 g;
    private final SettingsModule h;
    private final InterfaceC9336Zm4 i;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return A4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                A4 a4 = A4.this;
                this.b = 1;
                if (a4.X0(this) == objE) {
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
            A4 a42 = A4.this;
            this.b = 2;
            if (a42.a1(this) == objE) {
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

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return A4.this.X0(this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return A4.this.a1(this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return A4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TF3 tf3 = A4.this.g;
                this.b = 1;
                if (tf3.a(this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return A4.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HN5 hn5 = A4.this.f;
                long j = this.d;
                this.b = 1;
                if (hn5.a(j, this) == objE) {
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
                ((C9475a16) obj).l();
            }
            A4 a4 = A4.this;
            this.b = 2;
            if (a4.a1(this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public A4(C9057Yh4 c9057Yh4, DG2 dg2, C24824zG2 c24824zG2, T9 t9, HN5 hn5, TF3 tf3, SettingsModule settingsModule) {
        AbstractC13042fc3.i(c9057Yh4, "modules");
        AbstractC13042fc3.i(dg2, "getUserVmUseCase");
        AbstractC13042fc3.i(c24824zG2, "getUserAvatarsUseCase");
        AbstractC13042fc3.i(t9, "addMyAvatarUseCase");
        AbstractC13042fc3.i(hn5, "removeMyAvatarUseCase");
        AbstractC13042fc3.i(tf3, "loadFulLUserUseCase");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = c9057Yh4;
        this.c = dg2;
        this.d = c24824zG2;
        this.e = t9;
        this.f = hn5;
        this.g = tf3;
        this.h = settingsModule;
        this.i = AbstractC12281eL6.a(C23523x4.i.a());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof ir.nasim.A4.b
            if (r2 == 0) goto L17
            r2 = r1
            ir.nasim.A4$b r2 = (ir.nasim.A4.b) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.d = r3
            goto L1c
        L17:
            ir.nasim.A4$b r2 = new ir.nasim.A4$b
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.b
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.d
            r5 = 1
            if (r4 == 0) goto L3f
            if (r4 != r5) goto L37
            java.lang.Object r2 = r2.a
            ir.nasim.A4 r2 = (ir.nasim.A4) r2
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            java.lang.Object r1 = r1.l()
            goto L82
        L37:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3f:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.Zm4 r1 = r0.i
        L44:
            java.lang.Object r4 = r1.getValue()
            r6 = r4
            ir.nasim.x4 r6 = (ir.nasim.C23523x4) r6
            ir.nasim.core.modules.settings.SettingsModule r7 = r0.h
            boolean r7 = r7.v3()
            if (r7 == 0) goto L5d
            ir.nasim.Vt0 r7 = ir.nasim.C8386Vt0.a
            boolean r7 = r7.X8()
            if (r7 == 0) goto L5d
            r14 = r5
            goto L5f
        L5d:
            r7 = 0
            r14 = r7
        L5f:
            r15 = 127(0x7f, float:1.78E-43)
            r16 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            ir.nasim.x4 r6 = ir.nasim.C23523x4.c(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r4 = r1.f(r4, r6)
            if (r4 == 0) goto L44
            ir.nasim.DG2 r1 = r0.c
            r2.a = r0
            r2.d = r5
            java.lang.Object r1 = r1.a(r2)
            if (r1 != r3) goto L81
            return r3
        L81:
            r2 = r0
        L82:
            boolean r3 = ir.nasim.C9475a16.j(r1)
            if (r3 == 0) goto Lbd
            ir.nasim.tK7 r1 = (ir.nasim.C21231tK7) r1
            if (r1 != 0) goto L8f
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        L8f:
            ir.nasim.sp4 r3 = new ir.nasim.sp4
            r3.<init>()
            ir.nasim.bZ6 r4 = r1.r()
            ir.nasim.bZ6 r5 = r1.s()
            ir.nasim.bZ6 r6 = r1.g()
            ir.nasim.qQ7 r7 = r1.h()
            ir.nasim.y4 r8 = new ir.nasim.y4
            r8.<init>()
            r3.v(r4, r5, r6, r7, r8)
            ir.nasim.sp4 r3 = new ir.nasim.sp4
            r3.<init>()
            ir.nasim.qQ7 r1 = r1.u()
            ir.nasim.z4 r4 = new ir.nasim.z4
            r4.<init>()
            r3.r(r1, r4)
        Lbd:
            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.A4.X0(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(A4 a4, String str, AbstractC13554gQ7 abstractC13554gQ7, String str2, AbstractC13554gQ7 abstractC13554gQ72, String str3, AbstractC13554gQ7 abstractC13554gQ73, Avatar avatar, AbstractC13554gQ7 abstractC13554gQ74) {
        Object value;
        C23523x4 c23523x4;
        String str4;
        String str5;
        List listE;
        Object value2;
        C23523x4 c23523x42;
        AbstractC13042fc3.i(a4, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = a4.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23523x4 = (C23523x4) value;
            AbstractC13042fc3.f(str);
            str4 = str2 == null ? "" : str2;
            str5 = str3 == null ? "" : str3;
            if (avatar == null || AbstractC13042fc3.d(AbstractC15401jX0.s0(((C23523x4) a4.b1().getValue()).e()), avatar)) {
                listE = c23523x4.e();
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm42 = a4.i;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    c23523x42 = (C23523x4) value2;
                } while (!interfaceC9336Zm42.f(value2, c23523x42.b((127 & 1) != 0 ? c23523x42.a : null, (127 & 2) != 0 ? c23523x42.b : null, (127 & 4) != 0 ? c23523x42.c : null, (127 & 8) != 0 ? c23523x42.d : null, (127 & 16) != 0 ? c23523x42.e : null, (127 & 32) != 0 ? c23523x42.f : false, (127 & 64) != 0 ? c23523x42.g : null, (127 & 128) != 0 ? c23523x42.h : false)));
                listE = new ArrayList();
                listE.add(avatar);
                listE.addAll(c23523x4.e());
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        } while (!interfaceC9336Zm4.f(value, c23523x4.b((127 & 1) != 0 ? c23523x4.a : str, (127 & 2) != 0 ? c23523x4.b : null, (127 & 4) != 0 ? c23523x4.c : str4, (127 & 8) != 0 ? c23523x4.d : str5, (127 & 16) != 0 ? c23523x4.e : listE, (127 & 32) != 0 ? c23523x4.f : false, (127 & 64) != 0 ? c23523x4.g : null, (127 & 128) != 0 ? c23523x4.h : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(A4 a4, ArrayList arrayList, AbstractC13554gQ7 abstractC13554gQ7) {
        Object value;
        C23523x4 c23523x4;
        AbstractC13042fc3.i(a4, "this$0");
        AbstractC13042fc3.f(arrayList);
        NI7 ni7 = (NI7) AbstractC15401jX0.s0(arrayList);
        if (ni7 != null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = a4.i;
            do {
                value = interfaceC9336Zm4.getValue();
                c23523x4 = (C23523x4) value;
            } while (!interfaceC9336Zm4.f(value, c23523x4.b((127 & 1) != 0 ? c23523x4.a : null, (127 & 2) != 0 ? c23523x4.b : String.valueOf(ni7.a()), (127 & 4) != 0 ? c23523x4.c : null, (127 & 8) != 0 ? c23523x4.d : null, (127 & 16) != 0 ? c23523x4.e : null, (127 & 32) != 0 ? c23523x4.f : false, (127 & 64) != 0 ? c23523x4.g : null, (127 & 128) != 0 ? c23523x4.h : false)));
        } else {
            ni7 = null;
        }
        if (ni7 == null) {
            a4.c1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a1(ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof ir.nasim.A4.c
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.A4$c r0 = (ir.nasim.A4.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.A4$c r0 = new ir.nasim.A4$c
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.a
            ir.nasim.A4 r0 = (ir.nasim.A4) r0
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r14 = r14.l()
            goto L4c
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3b:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.zG2 r14 = r13.d
            r0.a = r13
            r0.d = r3
            java.lang.Object r14 = r14.a(r0)
            if (r14 != r1) goto L4b
            return r1
        L4b:
            r0 = r13
        L4c:
            boolean r1 = ir.nasim.C9475a16.j(r14)
            if (r1 == 0) goto L72
            java.util.List r14 = (java.util.List) r14
            ir.nasim.Zm4 r0 = r0.i
        L56:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            ir.nasim.x4 r2 = (ir.nasim.C23523x4) r2
            r11 = 239(0xef, float:3.35E-43)
            r12 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r7 = r14
            ir.nasim.x4 r2 = ir.nasim.C23523x4.c(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L56
        L72:
            ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.A4.a1(ir.nasim.rm1):java.lang.Object");
    }

    private final void c1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    public final void W0(String str) {
        Object value;
        C23523x4 c23523x4;
        AbstractC13042fc3.i(str, "path");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23523x4 = (C23523x4) value;
        } while (!interfaceC9336Zm4.f(value, c23523x4.b((127 & 1) != 0 ? c23523x4.a : null, (127 & 2) != 0 ? c23523x4.b : null, (127 & 4) != 0 ? c23523x4.c : null, (127 & 8) != 0 ? c23523x4.d : null, (127 & 16) != 0 ? c23523x4.e : null, (127 & 32) != 0 ? c23523x4.f : true, (127 & 64) != 0 ? c23523x4.g : null, (127 & 128) != 0 ? c23523x4.h : false)));
        this.e.a(str);
    }

    public final InterfaceC10258bL6 b1() {
        return this.i;
    }

    public final void d1(long j) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(j, null), 3, null);
    }

    public final void e1() {
        Object value;
        C23523x4 c23523x4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23523x4 = (C23523x4) value;
        } while (!interfaceC9336Zm4.f(value, c23523x4.b((127 & 1) != 0 ? c23523x4.a : null, (127 & 2) != 0 ? c23523x4.b : null, (127 & 4) != 0 ? c23523x4.c : null, (127 & 8) != 0 ? c23523x4.d : null, (127 & 16) != 0 ? c23523x4.e : null, (127 & 32) != 0 ? c23523x4.f : false, (127 & 64) != 0 ? c23523x4.g : null, (127 & 128) != 0 ? c23523x4.h : false)));
    }

    public final void f1(Avatar avatar) throws IOException {
        FileReference fileReference;
        AbstractC13042fc3.i(avatar, "avatar");
        AvatarImage fullImage = avatar.getFullImage();
        if (fullImage == null || (fileReference = fullImage.getFileReference()) == null) {
            return;
        }
        C6906Pm2.A(this.b.H().G(fileReference.getFileId()), C5721Ko.a.d(), 0, null, null);
        C4053Dm2.h(true);
    }

    public final void g1(String str) {
        Object value;
        C23523x4 c23523x4;
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23523x4 = (C23523x4) value;
        } while (!interfaceC9336Zm4.f(value, c23523x4.b((127 & 1) != 0 ? c23523x4.a : null, (127 & 2) != 0 ? c23523x4.b : null, (127 & 4) != 0 ? c23523x4.c : null, (127 & 8) != 0 ? c23523x4.d : null, (127 & 16) != 0 ? c23523x4.e : null, (127 & 32) != 0 ? c23523x4.f : false, (127 & 64) != 0 ? c23523x4.g : str, (127 & 128) != 0 ? c23523x4.h : false)));
    }
}
