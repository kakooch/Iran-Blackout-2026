package ir.appp.vod.ui.activity.relatedMovieList;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder;
import ir.appp.vod.di.VodAppModule;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.repository.VodRepository;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodRelatedMediaViewModel.kt */
/* loaded from: classes3.dex */
public final class VodRelatedMediaViewModel extends ViewModel {
    private final PagingRepositoryBuilder<GetCastRelatedOutput> castMediaUseCase;
    private final String id;
    private final VodRepository repository;

    public VodRelatedMediaViewModel(VodRepository repository, String id) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(id, "id");
        this.repository = repository;
        this.id = id;
        this.castMediaUseCase = new PagingRepositoryBuilder<>(ViewModelKt.getViewModelScope(this), VodAppModule.INSTANCE.provideVodGeneralErrorHandler(), true, null, null, new VodRelatedMediaViewModel$castMediaUseCase$1(this, null), 16, null);
    }

    public final PagingRepositoryBuilder<GetCastRelatedOutput> getCastMediaUseCase() {
        return this.castMediaUseCase;
    }

    /* compiled from: VodRelatedMediaViewModel.kt */
    public static final class VodMediaDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
        private final String id;

        public VodMediaDetailViewModelFactory(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new VodRelatedMediaViewModel(VodAppModule.INSTANCE.getRepository(), this.id);
        }
    }
}
