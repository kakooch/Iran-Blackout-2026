package ir.nasim.designsystem.photoviewer;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.r;
import androidx.lifecycle.y;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC24061xy6;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC7941Tv5;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9773aX7;
import ir.nasim.C10410bZ6;
import ir.nasim.C11458d25;
import ir.nasim.C11920dm2;
import ir.nasim.C12366eV1;
import ir.nasim.C14505i18;
import ir.nasim.C14593iA1;
import ir.nasim.C14733iO2;
import ir.nasim.C18823pJ2;
import ir.nasim.C19406qI3;
import ir.nasim.C19482qQ7;
import ir.nasim.C19938rB7;
import ir.nasim.C20298rm4;
import ir.nasim.C21231tK7;
import ir.nasim.C22078ud6;
import ir.nasim.C22372v74;
import ir.nasim.C22694vg2;
import ir.nasim.C23345wl7;
import ir.nasim.C24967zW1;
import ir.nasim.C4044Dl2;
import ir.nasim.C4382Ew7;
import ir.nasim.C4471Fg6;
import ir.nasim.C5721Ko;
import ir.nasim.C6517Nv5;
import ir.nasim.C6906Pm2;
import ir.nasim.C7781Te0;
import ir.nasim.ED1;
import ir.nasim.EnumC19631qg6;
import ir.nasim.EnumC19739qr4;
import ir.nasim.EnumC23558x74;
import ir.nasim.EnumC7325Rf6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18505om2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC7850Tl4;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.J44;
import ir.nasim.RY1;
import ir.nasim.VW7;
import ir.nasim.WM3;
import ir.nasim.X25;
import ir.nasim.XV4;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.photoviewer.data.Photo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class c extends VW7 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C4471Fg6 b;
    private final long c;
    private final C11458d25 d;
    private final List e;
    private final InterfaceC14603iB2 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(Photo photo);

        void b(Photo photo);
    }

    /* renamed from: ir.nasim.designsystem.photoviewer.c$c, reason: collision with other inner class name */
    private final class C1023c implements InterfaceC8091Um2 {
        private final J44 a;
        private final Photo b;
        private final b c;
        final /* synthetic */ c d;

        /* renamed from: ir.nasim.designsystem.photoviewer.c$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC3346Am2 d;

            /* renamed from: ir.nasim.designsystem.photoviewer.c$c$a$a, reason: collision with other inner class name */
            static final class C1024a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C1023c c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1024a(C1023c c1023c, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c1023c;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1024a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.a().b(this.c.f());
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1024a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC3346Am2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return C1023c.this.new a(this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    String strQ = C4044Dl2.q(AbstractC24061xy6.c(C1023c.this.b(), true));
                    File file = strQ != null ? new File(strQ) : new File("");
                    C1023c.this.f().t(Uri.fromFile(new File(this.d.getDescriptor())).toString());
                    C1023c.this.f().s(file.toString());
                    C1023c.this.f().r(0);
                    C1023c.this.f().q(false);
                    WM3 wm3C = C12366eV1.c();
                    C1024a c1024a = new C1024a(C1023c.this, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(wm3C, c1024a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public C1023c(c cVar, J44 j44, Photo photo, b bVar) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(photo, "photo");
            AbstractC13042fc3.i(bVar, "listener");
            this.d = cVar;
            this.a = j44;
            this.b = photo;
            this.c = bVar;
        }

        public final b a() {
            return this.c;
        }

        public final J44 b() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            this.b.r((int) (100 * f));
            this.b.q(true);
            this.c.a(this.b);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), C12366eV1.b(), null, new a(interfaceC3346Am2, null), 2, null);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }

        public final Photo f() {
            return this.b;
        }
    }

    public static final class d implements InterfaceC8091Um2 {
        final /* synthetic */ Photo a;

        d(Photo photo) {
            this.a = photo;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.p(Uri.fromFile(new File(interfaceC3346Am2.getDescriptor())).toString());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    public static final class e implements InterfaceC8091Um2 {
        final /* synthetic */ Photo a;

        e(Photo photo) {
            this.a = photo;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            this.a.p(Uri.fromFile(new File(interfaceC3346Am2.getDescriptor())).toString());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21231tK7 c;
        final /* synthetic */ c d;
        final /* synthetic */ C20298rm4 e;

        public static final class a implements InterfaceC8091Um2 {
            final /* synthetic */ C20298rm4 a;

            a(C20298rm4 c20298rm4) {
                this.a = c20298rm4;
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void c(float f) {
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                this.a.n(Uri.fromFile(new File(interfaceC3346Am2.getDescriptor())));
            }

            @Override // ir.nasim.InterfaceC8091Um2
            public void e() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C21231tK7 c21231tK7, c cVar, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c21231tK7;
            this.d = cVar;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C19482qQ7 c19482qQ7H;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C21231tK7 c21231tK7 = this.c;
            if (((c21231tK7 == null || (c19482qQ7H = c21231tK7.h()) == null) ? null : (Avatar) c19482qQ7H.b()) != null) {
                c cVar = this.d;
                Object objB = this.c.h().b();
                AbstractC13042fc3.h(objB, "get(...)");
                AvatarImage avatarImageC1 = cVar.c1((Avatar) objB);
                FileReference fileReference = avatarImageC1 != null ? avatarImageC1.getFileReference() : null;
                if (fileReference == null) {
                    this.e.n(null);
                } else {
                    AbstractC5969Lp4.d().q(fileReference, true, new a(this.e));
                }
            } else {
                this.e.n(null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20298rm4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c20298rm4;
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
            this.c.n(AbstractC6392Nk0.a(AbstractC5969Lp4.d().o0(AbstractC5969Lp4.d().Y().v().E().h().b() == EnumC19739qr4.MOBILE)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Photo c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Photo photo, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = photo;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C6906Pm2.A(C4044Dl2.r(J44.v.a(this.c.getMessage())), C5721Ko.a.d(), 0, null, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ XV4 d;
        final /* synthetic */ C20298rm4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(XV4 xv4, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = xv4;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new i(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            c.s1(c.this, (List) this.d.e(), (List) this.d.f(), this.e, 0, 0, 24, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ XV4 d;
        final /* synthetic */ C20298rm4 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(XV4 xv4, C20298rm4 c20298rm4, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = xv4;
            this.e = c20298rm4;
            this.f = i;
            this.g = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return c.this.new j(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            c.this.q1((List) this.d.e(), (List) this.d.f(), this.e, this.f, this.g);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class k implements InterfaceC7850Tl4 {
        final /* synthetic */ List b;
        final /* synthetic */ C20298rm4 c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ List c;
            final /* synthetic */ C20298rm4 d;
            final /* synthetic */ int e;
            final /* synthetic */ int f;
            final /* synthetic */ List g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, C20298rm4 c20298rm4, int i, int i2, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = list;
                this.d = c20298rm4;
                this.e = i;
                this.f = i2;
                this.g = list2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C22694vg2 c22694vg2V;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = this.c;
                List list2 = this.g;
                int i = 0;
                for (Object obj2 : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        AbstractC10360bX0.w();
                    }
                    Photo photo = (Photo) obj2;
                    J44 j44A = J44.v.a(photo.getMessage());
                    String strR = C4044Dl2.r(j44A);
                    File file = strR != null ? new File(strR) : new File("");
                    RY1 ry1 = (RY1) list2.get(i);
                    if (ry1 instanceof RY1.a) {
                        photo.t(Uri.fromFile(new File(((RY1.a) ry1).a().getDescriptor())).toString());
                        photo.s(file.toString());
                    } else if (ry1 instanceof RY1.b) {
                        continue;
                    } else {
                        if (!(ry1 instanceof RY1.c)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C24967zW1 c24967zW1H = j44A.H();
                        if (c24967zW1H != null && (c22694vg2V = c24967zW1H.v()) != null) {
                            photo.u(c22694vg2V.c());
                        }
                    }
                    i = i2;
                }
                this.d.n(new C7781Te0(this.c, false, this.e, this.f, 2, null));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(List list, C20298rm4 c20298rm4, int i, int i2) {
            this.b = list;
            this.c = c20298rm4;
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.InterfaceC7850Tl4
        public void a(List list) {
            AbstractC13042fc3.i(list, "downloadStates");
            AbstractC10533bm0.d(AbstractC9773aX7.a(c.this), C12366eV1.b(), null, new a(this.b, this.c, this.d, this.e, list, null), 2, null);
        }
    }

    public c(C4471Fg6 c4471Fg6, y yVar) {
        AbstractC13042fc3.i(c4471Fg6, "searchModule");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = c4471Fg6;
        Object objC = yVar.c("PEER_UNIQUE_ID_PARAM");
        AbstractC13042fc3.f(objC);
        long jLongValue = ((Number) objC).longValue();
        this.c = jLongValue;
        C11458d25 c11458d25R = C11458d25.r(jLongValue);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        this.d = c11458d25R;
        this.e = new ArrayList();
        this.f = new InterfaceC14603iB2() { // from class: ir.nasim.wc5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ir.nasim.designsystem.photoviewer.c.p1(this.a, ((Long) obj).longValue(), (EnumC19631qg6) obj2);
            }
        };
    }

    private final XV4 a1(List list) {
        Photo photo;
        FileReference fileReference;
        C19482qQ7 c19482qQ7H;
        C10410bZ6 c10410bZ6R;
        String str;
        C19482qQ7 c19482qQ7J;
        C10410bZ6 c10410bZ6V;
        String str2;
        FileReference fileReferenceB;
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C18823pJ2 c18823pJ2 = (C18823pJ2) it.next();
                long jI = c18823pJ2.i();
                long jU = c18823pJ2.u();
                Long lR = c18823pJ2.r();
                AbstractC13042fc3.h(lR, "getDate(...)");
                long jLongValue = lR.longValue();
                int iS = c18823pJ2.s();
                EnumC23558x74 enumC23558x74 = EnumC23558x74.SENT;
                AbstractC17457n0 abstractC17457n0Q = c18823pJ2.q();
                Iterator it2 = it;
                AbstractC13042fc3.h(abstractC17457n0Q, "getContent(...)");
                J44 j44 = new J44(jI, jU, jLongValue, iS, enumC23558x74, abstractC17457n0Q, new ArrayList(), 0, null, null, 0L, null, null, false, null, null, false, null, null, 523776, null);
                C24967zW1 c24967zW1H = j44.H();
                InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H != null ? c24967zW1H.z() : null;
                C11920dm2 c11920dm2 = interfaceC18505om2Z instanceof C11920dm2 ? (C11920dm2) interfaceC18505om2Z : null;
                if (c11920dm2 != null && (fileReferenceB = c11920dm2.b()) != null) {
                    arrayList2.add(new XV4(Long.valueOf(fileReferenceB.getFileId()), Long.valueOf(fileReferenceB.getAccessHash())));
                }
                if (X25.a(this.d) == ExPeerType.CHANNEL) {
                    C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(this.d.getPeerId());
                    if (c14733iO2 == null) {
                        C19406qI3.b("PhotoViewerViewModelNew", "GroupVM is null in extractPhotoFromGlobalSearchEntities");
                    }
                    int iS2 = c18823pJ2.s();
                    String str3 = (c14733iO2 == null || (c10410bZ6V = c14733iO2.v()) == null || (str2 = (String) c10410bZ6V.b()) == null) ? "" : str2;
                    C23345wl7 c23345wl7L = c18823pJ2.q().l();
                    String strV = c23345wl7L != null ? c23345wl7L.v() : null;
                    Long lR2 = c18823pJ2.r();
                    AbstractC13042fc3.h(lR2, "getDate(...)");
                    String strB1 = b1(lR2.longValue());
                    Long lR3 = c18823pJ2.r();
                    AbstractC13042fc3.h(lR3, "getDate(...)");
                    photo = new Photo(iS2, null, str3, null, null, null, strV, strB1, lR3.longValue(), j44.toByteArray(), null, null, false, 7168, null);
                    if (((c14733iO2 == null || (c19482qQ7J = c14733iO2.j()) == null) ? null : (Avatar) c19482qQ7J.b()) != null) {
                        Object objB = c14733iO2.j().b();
                        AbstractC13042fc3.h(objB, "get(...)");
                        AvatarImage avatarImageC1 = c1((Avatar) objB);
                        fileReference = avatarImageC1 != null ? avatarImageC1.getFileReference() : null;
                        if (fileReference != null) {
                            AbstractC5969Lp4.d().q(fileReference, true, new d(photo));
                        }
                    }
                } else {
                    C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c18823pJ2.s());
                    if (c21231tK7 == null) {
                        C19406qI3.b("PhotoViewerViewModelNew", "UserVM is null in extractPhotoFromGlobalSearchEntities");
                    }
                    int iS3 = c18823pJ2.s();
                    String str4 = (c21231tK7 == null || (c10410bZ6R = c21231tK7.r()) == null || (str = (String) c10410bZ6R.b()) == null) ? "" : str;
                    C23345wl7 c23345wl7L2 = c18823pJ2.q().l();
                    String strV2 = c23345wl7L2 != null ? c23345wl7L2.v() : null;
                    Long lR4 = c18823pJ2.r();
                    AbstractC13042fc3.h(lR4, "getDate(...)");
                    String strB12 = b1(lR4.longValue());
                    Long lR5 = c18823pJ2.r();
                    AbstractC13042fc3.h(lR5, "getDate(...)");
                    photo = new Photo(iS3, null, str4, null, null, null, strV2, strB12, lR5.longValue(), j44.toByteArray(), null, null, false, 7168, null);
                    if (((c21231tK7 == null || (c19482qQ7H = c21231tK7.h()) == null) ? null : (Avatar) c19482qQ7H.b()) != null) {
                        Object objB2 = c21231tK7.h().b();
                        AbstractC13042fc3.h(objB2, "get(...)");
                        AvatarImage avatarImageC12 = c1((Avatar) objB2);
                        fileReference = avatarImageC12 != null ? avatarImageC12.getFileReference() : null;
                        if (fileReference != null) {
                            AbstractC5969Lp4.d().q(fileReference, true, new e(photo));
                        }
                    }
                }
                arrayList.add(photo);
                it = it2;
            }
            return new XV4(arrayList, arrayList2);
        } catch (Exception e2) {
            C19406qI3.a("PhotoViewerViewModelNew", "error : " + e2.getMessage(), new Object[0]);
            return new XV4(new ArrayList(), AbstractC10360bX0.m());
        }
    }

    private final String b1(long j2) {
        Context contextD = C5721Ko.a.d();
        String string = contextD.getString(AbstractC12217eE5.formatDateAtTime, C14593iA1.h(contextD, j2, false, 4, null), C14593iA1.A(j2));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AvatarImage c1(Avatar avatar) {
        return C22078ud6.a(80.0f) >= 100 ? avatar.getLargeImage() : avatar.getSmallImage();
    }

    private final void d1(J44 j44, C20298rm4 c20298rm4) {
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j44.U());
        if (c21231tK7 == null) {
            C19406qI3.b("PhotoViewerViewModelNew", "UserVM is null in getOrBindAvatar");
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new f(c21231tK7, this, c20298rm4, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(c cVar, J44 j44, C20298rm4 c20298rm4, C14505i18 c14505i18, Exception exc) {
        AbstractC13042fc3.i(cVar, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        cVar.d1(j44, c20298rm4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(EnumC19631qg6 enumC19631qg6, c cVar, C20298rm4 c20298rm4, C22372v74 c22372v74) {
        AbstractC13042fc3.i(enumC19631qg6, "$loadMode");
        AbstractC13042fc3.i(cVar, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        List listA = c22372v74.a();
        if (enumC19631qg6 == EnumC19631qg6.a || enumC19631qg6 == EnumC19631qg6.b) {
            listA.remove(0);
        }
        AbstractC13042fc3.f(listA);
        AbstractC10533bm0.d(AbstractC9773aX7.a(cVar), C12366eV1.b(), null, cVar.new i(cVar.a1(listA), c20298rm4, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C7781Te0(null, false, 0, 0, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(c cVar, C20298rm4 c20298rm4, C4382Ew7 c4382Ew7) {
        AbstractC13042fc3.i(cVar, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        ArrayList arrayList = new ArrayList();
        List listA = ((C22372v74) c4382Ew7.a()).a();
        AbstractC13042fc3.f(listA);
        arrayList.addAll(AbstractC15401jX0.T0(listA));
        List listA2 = ((C22372v74) c4382Ew7.b()).a();
        List list = listA2;
        if (list != null && !list.isEmpty()) {
            listA2.remove(0);
            arrayList.addAll(listA2);
        }
        AbstractC10533bm0.d(AbstractC9773aX7.a(cVar), C12366eV1.b(), null, cVar.new j(cVar.a1(arrayList), c20298rm4, (((C22372v74) c4382Ew7.a()).b() + ((C22372v74) c4382Ew7.b()).b()) - 1, ((C22372v74) c4382Ew7.b()).b(), null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C7781Te0(null, false, 0, 0, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 p1(c cVar, long j2, EnumC19631qg6 enumC19631qg6) {
        AbstractC13042fc3.i(cVar, "this$0");
        AbstractC13042fc3.i(enumC19631qg6, "loadMode");
        return cVar.b.T(cVar.d, j2, enumC19631qg6, EnumC7325Rf6.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(List list, List list2, C20298rm4 c20298rm4, int i2, int i3) {
        AbstractC5969Lp4.d().q1(list2, new k(list, c20298rm4, i2, i3));
    }

    static /* synthetic */ void s1(c cVar, List list, List list2, C20298rm4 c20298rm4, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i2 = 1;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        cVar.q1(list, list2, c20298rm4, i5, i3);
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        super.L0();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((InterfaceC7857Tm2) it.next()).b();
        }
    }

    public final Photo Y0(Photo photo) {
        AbstractC13042fc3.i(photo, "photo");
        C24967zW1 c24967zW1H = J44.v.a(photo.getMessage()).H();
        if ((c24967zW1H != null ? c24967zW1H.z() : null) instanceof C11920dm2) {
            InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
            AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
            AbstractC5969Lp4.d().s(((C11920dm2) interfaceC18505om2Z).b().getFileId());
        }
        photo.q(false);
        photo.r(0);
        return photo;
    }

    public final void Z0(Photo photo, b bVar) {
        AbstractC13042fc3.i(photo, "photo");
        AbstractC13042fc3.i(bVar, "listener");
        J44 j44A = J44.v.a(photo.getMessage());
        C24967zW1 c24967zW1H = j44A.H();
        if ((c24967zW1H != null ? c24967zW1H.z() : null) instanceof C11920dm2) {
            InterfaceC18505om2 interfaceC18505om2Z = c24967zW1H.z();
            AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
            C11920dm2 c11920dm2 = (C11920dm2) interfaceC18505om2Z;
            FileReference fileReferenceB = c11920dm2.b();
            InterfaceC7857Tm2 interfaceC7857Tm2Q = AbstractC5969Lp4.d().q(c11920dm2.b(), false, new C1023c(this, j44A, photo, bVar));
            AbstractC13042fc3.h(interfaceC7857Tm2Q, "bindFile(...)");
            this.e.add(interfaceC7857Tm2Q);
            AbstractC5969Lp4.d().F1(fileReferenceB);
        }
    }

    public final r e1() {
        C20298rm4 c20298rm4 = new C20298rm4();
        if (AbstractC5969Lp4.d() != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new g(c20298rm4, null), 2, null);
        } else {
            c20298rm4.n(Boolean.FALSE);
        }
        return c20298rm4;
    }

    public final r f1(Photo photo) {
        AbstractC13042fc3.i(photo, "starterPhoto");
        final C20298rm4 c20298rm4 = new C20298rm4();
        final J44 j44A = J44.v.a(photo.getMessage());
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(j44A.U()));
        AbstractC5969Lp4.d().V0(arrayList).z(new InterfaceC3273Ae1() { // from class: ir.nasim.vc5
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                ir.nasim.designsystem.photoviewer.c.g1(this.a, j44A, c20298rm4, (C14505i18) obj, (Exception) obj2);
            }
        });
        return c20298rm4;
    }

    public final void h1(Photo photo) {
        AbstractC13042fc3.i(photo, "selectedItem");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new h(photo, null), 2, null);
    }

    public final C20298rm4 i1(long j2) {
        final C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC7941Tv5.f((C6517Nv5) this.f.invoke(Long.valueOf(j2), EnumC19631qg6.b), (C6517Nv5) this.f.invoke(Long.valueOf(j2), EnumC19631qg6.a)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.xc5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.designsystem.photoviewer.c.m1(this.a, c20298rm4, (C4382Ew7) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.yc5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.designsystem.photoviewer.c.o1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public final C20298rm4 j1(long j2, final EnumC19631qg6 enumC19631qg6) {
        AbstractC13042fc3.i(enumC19631qg6, "loadMode");
        final C20298rm4 c20298rm4 = new C20298rm4();
        ((C6517Nv5) this.f.invoke(Long.valueOf(j2), enumC19631qg6)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.tc5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.designsystem.photoviewer.c.k1(enumC19631qg6, this, c20298rm4, (C22372v74) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.uc5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.designsystem.photoviewer.c.l1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
