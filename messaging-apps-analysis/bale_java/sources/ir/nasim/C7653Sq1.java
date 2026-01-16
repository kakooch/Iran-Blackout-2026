package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.C24366yV3;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;

/* renamed from: ir.nasim.Sq1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7653Sq1 extends VW7 implements InterfaceC8360Vq1 {
    private final BankingModule b;

    /* renamed from: ir.nasim.Sq1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ C20298rm4 d;

        /* renamed from: ir.nasim.Sq1$a$a, reason: collision with other inner class name */
        static final class C0628a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ long c;
            final /* synthetic */ C20298rm4 d;

            /* renamed from: ir.nasim.Sq1$a$a$a, reason: collision with other inner class name */
            public static final class C0629a implements C24366yV3.a {
                final /* synthetic */ C20298rm4 a;

                C0629a(C20298rm4 c20298rm4) {
                    this.a = c20298rm4;
                }

                @Override // ir.nasim.C24366yV3.a
                public void a(ArrayList arrayList) {
                    AbstractC13042fc3.i(arrayList, "factorsList");
                    this.a.n(arrayList);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0628a(long j, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
                this.d = c20298rm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0628a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C24366yV3.a.b(this.c, new C0629a(this.d));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0628a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = c20298rm4;
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
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                C0628a c0628a = new C0628a(this.c, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, c0628a, this) == objE) {
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

    public C7653Sq1(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    public final boolean P0(String str) {
        AbstractC13042fc3.i(str, "currentClipboard");
        String strE = C7183Qq.p().e("last_cp");
        return strE == null || !strE.equals(str);
    }

    public final void R0(String str) {
        AbstractC13042fc3.i(str, "clipboard");
        C7183Qq.p().putString("last_cp", str);
    }

    public void a(long j, long j2, long j3, C16247kx c16247kx) {
        AbstractC13042fc3.i(c16247kx, DialogEntity.COLUMN_MESSAGE);
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.o1(c11458d25R, j2, j3, c16247kx);
    }

    public androidx.lifecycle.r a0(long j) {
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(j, c20298rm4, null), 3, null);
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC8360Vq1
    public void p(Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5) throws Throwable {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "photoPath");
        AbstractC13042fc3.i(str2, "photoName");
        AbstractC13042fc3.i(str3, "title");
        AbstractC13042fc3.i(str4, "description");
        AbstractC13042fc3.i(str5, "cardNumber");
        Bitmap bitmapDecodeResource = AbstractC13042fc3.d(str2, "empty.jpg") ? BitmapFactory.decodeResource(context.getResources(), KB5.img_crowdfunding_empty) : V13.e(str);
        if (bitmapDecodeResource == null) {
            return;
        }
        Bitmap bitmapO = V13.o(bitmapDecodeResource, 90, 90);
        String strM = C4053Dm2.m("jpg");
        if (strM == null) {
            return;
        }
        V13.f(bitmapDecodeResource, strM);
        C9625aH3 c9625aH3 = new C9625aH3(str2, strM, str3, KN6.r(strM).f(), "image/jpeg", new RG3(new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO))), bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight());
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.M2(c11458d25R, c9625aH3, str3, str4, j4, j2, j3, str5);
    }
}
