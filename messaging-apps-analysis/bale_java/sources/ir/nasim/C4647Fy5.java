package ir.nasim;

import androidx.core.content.FileProvider;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.File;

/* renamed from: ir.nasim.Fy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4647Fy5 {
    private final C9057Yh4 a;
    private final C10977cX1 b;
    private final String c;

    /* renamed from: ir.nasim.Fy5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4647Fy5.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10977cX1 c10977cX1B = C4647Fy5.this.b();
                C14970in2 c14970in2D = C4647Fy5.this.c().D();
                AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
                this.b = 1;
                objB = AbstractC9915am2.b(c10977cX1B, c14970in2D, this);
                if (objB == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objB = ((C9475a16) obj).l();
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4647Fy5(C9057Yh4 c9057Yh4, C10977cX1 c10977cX1, String str) {
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(c10977cX1, "fileReference");
        AbstractC13042fc3.i(str, "mimeType");
        this.a = c9057Yh4;
        this.b = c10977cX1;
        this.c = str;
    }

    public final void a(DD4 dd4) {
        AbstractC13042fc3.i(dd4, CommonUrlParts.MODEL);
        Object objL = ((C9475a16) AbstractC9913am0.b(null, new a(null), 1, null)).l();
        if (C9475a16.j(objL)) {
            C5721Ko c5721Ko = C5721Ko.a;
            dd4.e(FileProvider.h(c5721Ko.d(), c5721Ko.d().getPackageName() + ".provider", new File((String) objL)));
            dd4.d(this.c);
        }
    }

    public final C10977cX1 b() {
        return this.b;
    }

    public final C9057Yh4 c() {
        return this.a;
    }
}
