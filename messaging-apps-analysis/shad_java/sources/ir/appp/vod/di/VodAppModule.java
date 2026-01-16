package ir.appp.vod.di;

import ir.appp.common.data.error.DefaultErrorHandlerImpl;
import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.vod.data.repository.VodRepositoryImpl;
import ir.appp.vod.data.source.VodDataSource;
import ir.appp.vod.data.source.mock.VodMockDataSource;
import ir.appp.vod.data.source.network.VodNetworkDataSource;
import ir.appp.vod.domain.repository.VodRepository;

/* compiled from: VodAppModule.kt */
/* loaded from: classes3.dex */
public final class VodAppModule {
    public static final VodAppModule INSTANCE;
    private static final VodRepository repository;
    private static final VodDataSource vodMockDataSource;
    private static final VodDataSource vodNetworkDataSource;

    private VodAppModule() {
    }

    public final VodRepository getRepository() {
        return repository;
    }

    static {
        VodAppModule vodAppModule = new VodAppModule();
        INSTANCE = vodAppModule;
        vodMockDataSource = vodAppModule.provideMockVodDataSource();
        vodNetworkDataSource = vodAppModule.provideNetworkVodDataSource();
        repository = vodAppModule.provideVodRepository();
    }

    public final synchronized ErrorHandler provideVodGeneralErrorHandler() {
        return new DefaultErrorHandlerImpl();
    }

    private final synchronized VodDataSource provideMockVodDataSource() {
        return new VodMockDataSource();
    }

    private final synchronized VodDataSource provideNetworkVodDataSource() {
        return new VodNetworkDataSource();
    }

    private final synchronized VodRepository provideVodRepository() {
        return new VodRepositoryImpl(vodNetworkDataSource, vodMockDataSource, provideVodGeneralErrorHandler());
    }
}
