package ir.nasim;

import ai.bale.proto.PremiumOuterClass$UpdatePremiumPurchaseStatus;
import com.google.protobuf.BoolValue;

/* renamed from: ir.nasim.nF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17610nF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C17019mF7 a(PremiumOuterClass$UpdatePremiumPurchaseStatus premiumOuterClass$UpdatePremiumPurchaseStatus) {
        AbstractC13042fc3.i(premiumOuterClass$UpdatePremiumPurchaseStatus, "input");
        BoolValue successful = premiumOuterClass$UpdatePremiumPurchaseStatus.getSuccessful();
        boolean value = successful != null ? successful.getValue() : false;
        BoolValue unknown = premiumOuterClass$UpdatePremiumPurchaseStatus.getUnknown();
        boolean value2 = unknown != null ? unknown.getValue() : false;
        BoolValue failed = premiumOuterClass$UpdatePremiumPurchaseStatus.getFailed();
        return new C17019mF7(value, value2, failed != null ? failed.getValue() : false);
    }
}
