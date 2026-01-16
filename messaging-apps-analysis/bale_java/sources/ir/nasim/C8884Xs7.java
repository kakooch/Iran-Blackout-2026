package ir.nasim;

import android.content.Context;
import ir.nasim.features.search.repository.TopPeersRepositoryImpl;

/* renamed from: ir.nasim.Xs7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8884Xs7 {
    public static final C8884Xs7 a = new C8884Xs7();

    private C8884Xs7() {
    }

    public final InterfaceC21626tr4 a(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new C21845uE1(context);
    }

    public final C7916Ts7 b(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        return new C7916Ts7(c6287Mz);
    }

    public final C8618Ws7 c(InterfaceC8150Us7 interfaceC8150Us7) {
        AbstractC13042fc3.i(interfaceC8150Us7, "dao");
        return new C8618Ws7(interfaceC8150Us7);
    }

    public final C11994dt7 d(C7916Ts7 c7916Ts7) {
        AbstractC13042fc3.i(c7916Ts7, "api");
        return new C11994dt7(c7916Ts7);
    }

    public final InterfaceC12607et7 e(InterfaceC21626tr4 interfaceC21626tr4, C8618Ws7 c8618Ws7, InterfaceC3570Bk5 interfaceC3570Bk5, C11994dt7 c11994dt7, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC21626tr4, "networkStatusProvider");
        AbstractC13042fc3.i(c8618Ws7, "topPeersLocalDataSource");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(c11994dt7, "topPeersRemoteDataSource");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        return new TopPeersRepositoryImpl(interfaceC21626tr4, c8618Ws7, interfaceC3570Bk5, c11994dt7, abstractC13778go1, interfaceC20315ro1);
    }
}
