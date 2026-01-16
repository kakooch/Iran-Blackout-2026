package ir.nasim;

import ai.bale.proto.WalletOuterClass$UpdateWalletBalanceUpdated;
import ai.bale.proto.WalletStruct$Balance;

/* loaded from: classes5.dex */
public final class AG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C24829zG7 a(WalletOuterClass$UpdateWalletBalanceUpdated walletOuterClass$UpdateWalletBalanceUpdated) {
        AbstractC13042fc3.i(walletOuterClass$UpdateWalletBalanceUpdated, "proto");
        WalletStruct$Balance newBalance = walletOuterClass$UpdateWalletBalanceUpdated.getNewBalance();
        SW sw = new SW(EnumC17422mw1.j(newBalance.getCurrencyValue()), Long.valueOf(newBalance.getAmount()));
        String walletId = walletOuterClass$UpdateWalletBalanceUpdated.getWalletId();
        AbstractC13042fc3.h(walletId, "getWalletId(...)");
        return new C24829zG7(walletId, sw);
    }
}
