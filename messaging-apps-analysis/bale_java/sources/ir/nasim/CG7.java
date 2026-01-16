package ir.nasim;

import ai.bale.proto.WalletOuterClass$UpdateWalletUpdated;
import ai.bale.proto.WalletStruct$Balance;
import ai.bale.proto.WalletStruct$Wallet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class CG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BG7 a(WalletOuterClass$UpdateWalletUpdated walletOuterClass$UpdateWalletUpdated) {
        AbstractC13042fc3.i(walletOuterClass$UpdateWalletUpdated, "proto");
        WalletStruct$Wallet newWallet = walletOuterClass$UpdateWalletUpdated.getNewWallet();
        List<WalletStruct$Balance> balancesList = newWallet.getBalancesList();
        AbstractC13042fc3.h(balancesList, "getBalancesList(...)");
        List<WalletStruct$Balance> list = balancesList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (WalletStruct$Balance walletStruct$Balance : list) {
            arrayList.add(new SW(EnumC17422mw1.j(walletStruct$Balance.getCurrencyValue()), Long.valueOf(walletStruct$Balance.getAmount())));
        }
        return new BG7(new D18(newWallet.getId(), arrayList, newWallet.getWalletLink().getValue(), Boolean.valueOf(newWallet.getIsActive().getValue())));
    }
}
