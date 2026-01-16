package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC12129e53;
import ir.nasim.C9475a16;
import ir.nasim.DX1;
import ir.nasim.InterfaceC13356g53;
import ir.nasim.RY1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.entity.ChangeLogData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.f53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12720f53 {
    public static final a o = new a(null);
    public static final int p = 8;
    private final SettingsModule a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;
    private final C10249bK6 d;
    private final C23620xE0 e;
    private final C14494i07 f;
    private final C14970in2 g;
    private final Context h;
    private final InterfaceC10722c53 i;
    private final String j;
    private FileReference k;
    private final ChangeLogData l;
    private final InterfaceC9336Zm4 m;
    private final InterfaceC9336Zm4 n;

    /* renamed from: ir.nasim.f53$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.f53$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC12129e53.c.a.values().length];
            try {
                iArr[AbstractC12129e53.c.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC12129e53.c.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC12129e53.c.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.f53$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12720f53.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10722c53 interfaceC10722c53 = C12720f53.this.i;
                this.b = 1;
                objA = interfaceC10722c53.a(this);
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
            C12720f53 c12720f53 = C12720f53.this;
            if (C9475a16.j(objA)) {
                c12720f53.k = (FileReference) objA;
                if (c12720f53.a.R7()) {
                    c12720f53.x();
                } else {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c12720f53.m;
                    do {
                        value2 = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value2, AbstractC12129e53.f.b));
                }
            }
            C12720f53 c12720f532 = C12720f53.this;
            if (C9475a16.e(objA) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c12720f532.m;
                do {
                    value = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value, AbstractC12129e53.b.b));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.f53$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.f53$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12720f53 a;

            a(C12720f53 c12720f53) {
                this.a = c12720f53;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                float fA;
                int fileSize;
                String versionName;
                ChangeLogData changeLogData;
                Object value2;
                Object value3;
                Object value4;
                AbstractC12129e53 abstractC12129e53;
                AbstractC12129e53.c cVarB;
                Object value5;
                AbstractC12129e53.c cVar;
                Object value6;
                float fA2;
                int fileSize2;
                String versionName2;
                ChangeLogData changeLogData2;
                Object value7;
                String versionName3;
                ChangeLogData changeLogData3;
                if (ry1 instanceof RY1.c) {
                    RY1.c cVar2 = (RY1.c) ry1;
                    DX1 dx1A = cVar2.a();
                    if (dx1A == null) {
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.m;
                        C12720f53 c12720f53 = this.a;
                        do {
                            value7 = interfaceC9336Zm4.getValue();
                            ChangeLogData changeLogData4 = c12720f53.l;
                            versionName3 = changeLogData4 != null ? changeLogData4.getVersionName() : null;
                            changeLogData3 = c12720f53.l;
                        } while (!interfaceC9336Zm4.f(value7, new AbstractC12129e53.a(versionName3, changeLogData3 != null ? changeLogData3.getChangeLog() : null)));
                    } else if (dx1A instanceof DX1.c) {
                        InterfaceC9336Zm4 interfaceC9336Zm42 = this.a.m;
                        C12720f53 c12720f532 = this.a;
                        do {
                            value6 = interfaceC9336Zm42.getValue();
                            fA2 = ((DX1.c) cVar2.a()).a();
                            FileReference fileReference = c12720f532.k;
                            AbstractC13042fc3.f(fileReference);
                            fileSize2 = fileReference.getFileSize();
                            ChangeLogData changeLogData5 = c12720f532.l;
                            versionName2 = changeLogData5 != null ? changeLogData5.getVersionName() : null;
                            changeLogData2 = c12720f532.l;
                        } while (!interfaceC9336Zm42.f(value6, new AbstractC12129e53.c(fA2, fileSize2, versionName2, changeLogData2 != null ? changeLogData2.getChangeLog() : null, AbstractC12129e53.c.a.c)));
                    } else if (dx1A instanceof DX1.a) {
                        InterfaceC9336Zm4 interfaceC9336Zm43 = this.a.m;
                        C12720f53 c12720f533 = this.a;
                        do {
                            value5 = interfaceC9336Zm43.getValue();
                            AbstractC12129e53 abstractC12129e532 = (AbstractC12129e53) value5;
                            if (abstractC12129e532 instanceof AbstractC12129e53.c) {
                                cVar = AbstractC12129e53.c.b((AbstractC12129e53.c) abstractC12129e532, 0.0f, 0, null, null, AbstractC12129e53.c.a.c, 15, null);
                            } else {
                                FileReference fileReference2 = c12720f533.k;
                                AbstractC13042fc3.f(fileReference2);
                                int fileSize3 = fileReference2.getFileSize();
                                ChangeLogData changeLogData6 = c12720f533.l;
                                String versionName4 = changeLogData6 != null ? changeLogData6.getVersionName() : null;
                                ChangeLogData changeLogData7 = c12720f533.l;
                                cVar = new AbstractC12129e53.c(0.0f, fileSize3, versionName4, changeLogData7 != null ? changeLogData7.getChangeLog() : null, AbstractC12129e53.c.a.c);
                            }
                        } while (!interfaceC9336Zm43.f(value5, cVar));
                    } else {
                        InterfaceC9336Zm4 interfaceC9336Zm44 = this.a.m;
                        do {
                            value4 = interfaceC9336Zm44.getValue();
                            abstractC12129e53 = (AbstractC12129e53) value4;
                            AbstractC12129e53.c cVar3 = abstractC12129e53 instanceof AbstractC12129e53.c ? (AbstractC12129e53.c) abstractC12129e53 : null;
                            if (cVar3 != null) {
                                AbstractC12129e53.c cVar4 = cVar3.e() == AbstractC12129e53.c.a.a ? cVar3 : null;
                                if (cVar4 != null && (cVarB = AbstractC12129e53.c.b(cVar4, 0.0f, 0, null, null, AbstractC12129e53.c.a.b, 15, null)) != null) {
                                    abstractC12129e53 = cVarB;
                                }
                            }
                        } while (!interfaceC9336Zm44.f(value4, abstractC12129e53));
                    }
                } else if (ry1 instanceof RY1.a) {
                    this.a.y(1);
                    InterfaceC9336Zm4 interfaceC9336Zm45 = this.a.m;
                    do {
                        value2 = interfaceC9336Zm45.getValue();
                    } while (!interfaceC9336Zm45.f(value2, new AbstractC12129e53.e(((RY1.a) ry1).a())));
                    InterfaceC9336Zm4 interfaceC9336Zm46 = this.a.n;
                    do {
                        value3 = interfaceC9336Zm46.getValue();
                        ((Boolean) value3).booleanValue();
                    } while (!interfaceC9336Zm46.f(value3, AbstractC6392Nk0.a(true)));
                } else {
                    if (!(ry1 instanceof RY1.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm47 = this.a.m;
                    C12720f53 c12720f534 = this.a;
                    do {
                        value = interfaceC9336Zm47.getValue();
                        fA = ((RY1.b) ry1).a();
                        FileReference fileReference3 = c12720f534.k;
                        AbstractC13042fc3.f(fileReference3);
                        fileSize = fileReference3.getFileSize();
                        ChangeLogData changeLogData8 = c12720f534.l;
                        versionName = changeLogData8 != null ? changeLogData8.getVersionName() : null;
                        changeLogData = c12720f534.l;
                    } while (!interfaceC9336Zm47.f(value, new AbstractC12129e53.c(fA, fileSize, versionName, changeLogData != null ? changeLogData.getChangeLog() : null, null, 16, null)));
                }
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12720f53.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FileReference fileReference = C12720f53.this.k;
                if (fileReference != null) {
                    C12720f53 c12720f53 = C12720f53.this;
                    InterfaceC4557Fq2 interfaceC4557Fq2Q = c12720f53.f.q(true, fileReference, false);
                    a aVar = new a(c12720f53);
                    this.b = 1;
                    if (interfaceC4557Fq2Q.b(aVar, this) == objE) {
                        return objE;
                    }
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

    public C12720f53(SettingsModule settingsModule, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, C10249bK6 c10249bK6, C23620xE0 c23620xE0, C14494i07 c14494i07, C14970in2 c14970in2, Context context, InterfaceC10722c53 interfaceC10722c53, String str) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(c10249bK6, "startDownloadFileUseCase");
        AbstractC13042fc3.i(c23620xE0, "cancelDownloadFileUseCase");
        AbstractC13042fc3.i(c14494i07, "subscribeDownloadFileStateUseCase");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC10722c53, "inAppUpdateRepository");
        AbstractC13042fc3.i(str, "flavor");
        this.a = settingsModule;
        this.b = abstractC13778go1;
        this.c = interfaceC20315ro1;
        this.d = c10249bK6;
        this.e = c23620xE0;
        this.f = c14494i07;
        this.g = c14970in2;
        this.h = context;
        this.i = interfaceC10722c53;
        this.j = str;
        this.l = settingsModule.f1();
        this.m = AbstractC12281eL6.a(AbstractC12129e53.d.b);
        this.n = AbstractC12281eL6.a(Boolean.FALSE);
    }

    private final void m() {
        y(6);
    }

    private final void n() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.FALSE));
        y(7);
    }

    private final void p() {
        Object value;
        if (v()) {
            u();
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC12129e53.b.b));
    }

    private final void q() {
        if (this.m.getValue() instanceof AbstractC12129e53.e) {
            Object value = this.m.getValue();
            AbstractC13042fc3.g(value, "null cannot be cast to non-null type ir.nasim.features.inappUpdate.ui.model.InAppUpdateState.ReadyToInstall");
            String descriptor = ((AbstractC12129e53.e) value).a().getDescriptor();
            if (!new File(descriptor).exists()) {
                FileReference fileReference = this.k;
                if (fileReference != null) {
                    this.g.Q(AbstractC9766aX0.e(Long.valueOf(fileReference.getFileId())));
                }
                n();
                x();
                return;
            }
            try {
                C18987pb3.a.C1(this.h, descriptor, descriptor);
                y(3);
            } catch (Exception e) {
                C19406qI3.c("InAppUpdateStateManager", "openFile: " + e, e);
            }
        }
    }

    private final C19938rB7 r() {
        FileReference fileReference = this.k;
        if (fileReference == null) {
            return null;
        }
        this.e.c(fileReference);
        y(5);
        return C19938rB7.a;
    }

    private final void s() {
        Object value;
        Object objB;
        t();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            objB = (AbstractC12129e53) value;
            if (objB instanceof AbstractC12129e53.c) {
                AbstractC12129e53.c cVar = (AbstractC12129e53.c) objB;
                int i = b.a[cVar.e().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        z("download_failed");
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        z("user_cancelled");
                    }
                }
                objB = AbstractC12129e53.c.b(cVar, 0.0f, 0, null, null, AbstractC12129e53.c.a.a, 15, null);
            }
        } while (!interfaceC9336Zm4.f(value, objB));
    }

    private final C19938rB7 t() {
        FileReference fileReference = this.k;
        if (fileReference == null) {
            return null;
        }
        C10249bK6.b(this.d, fileReference, null, false, 6, null);
        return C19938rB7.a;
    }

    private final void u() {
        AbstractC10533bm0.d(this.c, this.b, null, new c(null), 2, null);
    }

    private final boolean w() {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            C13149fk3 c13149fk3J = AbstractC9083Yk3.c(this.a.z2()).j();
            AbstractC13042fc3.h(c13149fk3J, "getAsJsonArray(...)");
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c13149fk3J, 10));
            Iterator it = c13149fk3J.iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC22735vk3) it.next()).v());
            }
            objB = C9475a16.b(Boolean.valueOf(arrayList.contains(this.j)));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (C9475a16.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        AbstractC10533bm0.d(this.c, this.b, null, new d(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i) {
        C3343Am.i("in_app_update", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("action_type", Integer.valueOf(i))));
    }

    private final void z(String str) {
        C3343Am.i("in_app_update", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("action_type", 4), AbstractC4616Fw7.a("error", str)));
    }

    public final InterfaceC10258bL6 k() {
        return AbstractC6459Nq2.c(this.m);
    }

    public final InterfaceC10258bL6 l() {
        return AbstractC6459Nq2.c(this.n);
    }

    public final void o(InterfaceC13356g53 interfaceC13356g53) {
        AbstractC13042fc3.i(interfaceC13356g53, "inAppUpdateUiAction");
        if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.a.a)) {
            m();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.d.a)) {
            q();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.e.a)) {
            r();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.f.a)) {
            s();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.g.a)) {
            y(2);
            t();
        } else if (AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.c.a)) {
            p();
        } else {
            if (!AbstractC13042fc3.d(interfaceC13356g53, InterfaceC13356g53.b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            n();
        }
    }

    public final boolean v() {
        return C8386Vt0.g7() && w();
    }
}
