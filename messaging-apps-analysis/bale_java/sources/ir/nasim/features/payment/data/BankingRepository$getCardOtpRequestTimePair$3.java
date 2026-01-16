package ir.nasim.features.payment.data;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.KS2;
import java.util.Map;

/* loaded from: classes6.dex */
final class BankingRepository$getCardOtpRequestTimePair$3 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    /* synthetic */ Object c;

    BankingRepository$getCardOtpRequestTimePair$3(InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        BankingRepository$getCardOtpRequestTimePair$3 bankingRepository$getCardOtpRequestTimePair$3 = new BankingRepository$getCardOtpRequestTimePair$3(interfaceC20295rm1);
        bankingRepository$getCardOtpRequestTimePair$3.c = obj;
        return bankingRepository$getCardOtpRequestTimePair$3;
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        AbstractC14862ic3.e();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC10685c16.b(obj);
        String str = (String) this.c;
        if (str == null || str.length() == 0) {
            return AbstractC20051rO3.k();
        }
        try {
            Object objL = new KS2().l(str, new TypeToken<Map<String, ? extends Long>>() { // from class: ir.nasim.features.payment.data.BankingRepository$getCardOtpRequestTimePair$3$type$1
            }.d());
            AbstractC13042fc3.h(objL, "fromJson(...)");
            return (Map) objL;
        } catch (JsonSyntaxException unused) {
            return AbstractC20051rO3.k();
        }
    }

    @Override // ir.nasim.InterfaceC14603iB2
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((BankingRepository$getCardOtpRequestTimePair$3) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
