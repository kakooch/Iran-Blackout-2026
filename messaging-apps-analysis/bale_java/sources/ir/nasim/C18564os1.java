package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.core.modules.banking.BankingModule;

/* renamed from: ir.nasim.os1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18564os1 extends VW7 implements InterfaceC19746qs1 {
    private final BankingModule b;

    public C18564os1(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    private final void P0(C11458d25 c11458d25, String str, int i, int i2, C22694vg2 c22694vg2, String str2, String str3, AbstractC13130fi4 abstractC13130fi4, AbstractC20471s40 abstractC20471s40, String str4) {
        this.b.N2(c11458d25, str, i, i2, c22694vg2, str2, str3, abstractC13130fi4, abstractC20471s40, str4);
    }

    private final void R0(C11458d25 c11458d25, String str, String str2, String str3, AbstractC13130fi4 abstractC13130fi4, AbstractC20471s40 abstractC20471s40, String str4) {
        try {
            Bitmap bitmapDecodeResource = AbstractC13042fc3.d(str2, "empty.jpg") ? BitmapFactory.decodeResource(C5721Ko.a.d().getResources(), C5438Ji4.a.a().c().a()) : V13.e(str);
            if (bitmapDecodeResource == null) {
                return;
            }
            Bitmap bitmapO = V13.o(bitmapDecodeResource, 30, 30);
            String strM = C4053Dm2.m("jpg");
            if (strM == null) {
                return;
            }
            V13.f(bitmapDecodeResource, strM);
            C22694vg2 c22694vg2 = new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO));
            AbstractC13042fc3.f(c11458d25);
            int width = bitmapDecodeResource.getWidth();
            int height = bitmapDecodeResource.getHeight();
            AbstractC13042fc3.f(abstractC13130fi4);
            AbstractC13042fc3.f(abstractC20471s40);
            P0(c11458d25, str2, width, height, c22694vg2, strM, str3, abstractC13130fi4, abstractC20471s40, str4);
        } catch (Throwable th) {
            C19406qI3.c("CreateMoneyRequestViewModelImplNew", "sendPurchase", th);
        }
    }

    @Override // ir.nasim.InterfaceC19746qs1
    public void m0(long j, String str, String str2, String str3, long j2, String str4) {
        AbstractC13042fc3.i(str, "photoPath");
        AbstractC13042fc3.i(str2, "photoName");
        AbstractC13042fc3.i(str3, "caption");
        AbstractC13042fc3.i(str4, "cardNumber");
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        R0(c11458d25R, str, str2, str3, j2 > 0 ? new C17944np2(j2) : new JQ7(), ir.nasim.core.modules.banking.l.a(str4), null);
    }
}
