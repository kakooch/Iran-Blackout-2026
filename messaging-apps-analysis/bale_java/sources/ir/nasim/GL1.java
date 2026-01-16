package ir.nasim;

import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.dialoglist.data.model.DialogDTO;

/* loaded from: classes5.dex */
public final class GL1 implements AL1, InterfaceC14756iQ7 {
    private final C11458d25 a;
    private final OK7 b;
    private final C10299bQ2 c;
    private UA2 d;
    private C19482qQ7 e;
    private boolean f;

    public static final class a {
        public static final int c = C10299bQ2.j | OK7.f;
        private final OK7 a;
        private final C10299bQ2 b;

        public a(OK7 ok7, C10299bQ2 c10299bQ2) {
            AbstractC13042fc3.i(ok7, "usersModule");
            AbstractC13042fc3.i(c10299bQ2, "groupsModule");
            this.a = ok7;
            this.b = c10299bQ2;
        }

        public AL1 a(DialogDTO dialogDTO, UA2 ua2) {
            AbstractC13042fc3.i(dialogDTO, "item");
            AbstractC13042fc3.i(ua2, "onAttributeChanged");
            OK7 ok7 = this.a;
            C10299bQ2 c10299bQ2 = this.b;
            C11458d25 c11458d25R = C11458d25.r(dialogDTO.getPeerUniqueId());
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            return new GL1(c11458d25R, ok7, c10299bQ2, ua2);
        }
    }

    public GL1(C11458d25 c11458d25, OK7 ok7, C10299bQ2 c10299bQ2, UA2 ua2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c11458d25;
        this.b = ok7;
        this.c = c10299bQ2;
        this.d = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GL1 gl1, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(gl1, "this$0");
        if (gl1.f) {
            return;
        }
        C19482qQ7 c19482qQ7H = c21231tK7 != null ? c21231tK7.h() : null;
        gl1.e = c19482qQ7H;
        if (c19482qQ7H != null) {
            c19482qQ7H.f(gl1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GL1 gl1, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(gl1, "this$0");
        if (gl1.f) {
            return;
        }
        C19482qQ7 c19482qQ7J = c14733iO2 != null ? c14733iO2.j() : null;
        gl1.e = c19482qQ7J;
        if (c19482qQ7J != null) {
            c19482qQ7J.f(gl1);
        }
    }

    @Override // ir.nasim.AL1
    public void a() {
        this.f = true;
        C19482qQ7 c19482qQ7 = this.e;
        if (c19482qQ7 != null) {
            c19482qQ7.h(this);
        }
        this.e = null;
        this.d = null;
    }

    @Override // ir.nasim.AL1
    public void c() {
        if (this.a.C()) {
            this.b.o0().k(this.a.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.EL1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    GL1.f(this.a, (C21231tK7) obj);
                }
            });
        } else {
            this.c.Y1().k(this.a.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.FL1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    GL1.g(this.a, (C14733iO2) obj);
                }
            });
        }
    }

    @Override // ir.nasim.InterfaceC14756iQ7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(Avatar avatar, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(abstractC13554gQ7, "valueModel");
        UA2 ua2 = this.d;
        if (ua2 != null) {
            ua2.invoke(avatar);
        }
    }
}
