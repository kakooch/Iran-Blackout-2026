package ir.appp.vod.ui.activity.relatedMovieList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.domain.model.BaseError;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.extentions.CallbackStack;
import ir.appp.common.utils.extentions.LiveDataExtKt;
import ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder;
import ir.appp.ui.ActionBar.LifecycleAwareBaseFragment;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.domain.model.VodCastReadEntity$CastRole;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMediaViewModel;
import ir.appp.vod.ui.activity.videoDetail.VodMediaDetailActivity;
import ir.appp.vod.ui.customViews.VodLoadingCell;
import ir.appp.vod.ui.customViews.VodRelatedVideoCell;
import ir.appp.vod.ui.recyclerview.LoadingNewPageView;
import ir.appp.vod.ui.recyclerview.baseAdapter.BasePagingAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: VodRelatedMovieListFragment.kt */
/* loaded from: classes3.dex */
public final class VodRelatedMovieListFragment extends LifecycleAwareBaseFragment {
    private final String category;
    private final String id;
    private VodLoadingCell loadingView;
    private MovieAdapter movieAdapter;
    private List<VodBriefMediaEntity> movieList;
    private RecyclerView movieListView;
    private final int padding;
    private VodRelatedMediaViewModel viewModel;
    private GetCastRelatedOutput vodRelatedMoviesResponse;

    public VodRelatedMovieListFragment(String id, String category) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(category, "category");
        this.id = id;
        this.category = category;
        this.padding = AndroidUtilities.dp(8.0f);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBarCreateActionBar = super.createActionBar(context);
        if (actionBarCreateActionBar == null) {
            return null;
        }
        actionBarCreateActionBar.setItemsColor(-1, false);
        actionBarCreateActionBar.setBackgroundColor(-16777216);
        actionBarCreateActionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBarCreateActionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment$createActionBar$1$1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    this.this$0.finishFragment();
                }
            }
        });
        return actionBarCreateActionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewModel = (VodRelatedMediaViewModel) new ViewModelProvider(this, new VodRelatedMediaViewModel.VodMediaDetailViewModelFactory(this.id)).get(VodRelatedMediaViewModel.class);
        this.fragmentView = new FrameLayout(context);
        this.movieAdapter = new MovieAdapter(this, 0, new Function1<Integer, Boolean>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.createView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Boolean invoke(int i) {
                GetCastRelatedOutput getCastRelatedOutput;
                String nextStartId;
                GetCastRelatedOutput getCastRelatedOutput2 = VodRelatedMovieListFragment.this.vodRelatedMoviesResponse;
                if ((getCastRelatedOutput2 == null ? false : Intrinsics.areEqual(getCastRelatedOutput2.getHasContinue(), Boolean.TRUE)) && (getCastRelatedOutput = VodRelatedMovieListFragment.this.vodRelatedMoviesResponse) != null && (nextStartId = getCastRelatedOutput.getNextStartId()) != null) {
                    VodRelatedMediaViewModel vodRelatedMediaViewModel = VodRelatedMovieListFragment.this.viewModel;
                    Intrinsics.checkNotNull(vodRelatedMediaViewModel);
                    PagingRepositoryBuilder.nextPage$default(vodRelatedMediaViewModel.getCastMediaUseCase(), nextStartId, null, 2, null);
                }
                GetCastRelatedOutput getCastRelatedOutput3 = VodRelatedMovieListFragment.this.vodRelatedMoviesResponse;
                return Boolean.valueOf(getCastRelatedOutput3 != null ? Intrinsics.areEqual(getCastRelatedOutput3.getHasContinue(), Boolean.TRUE) : false);
            }
        }, 1, null);
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setPadding(0, this.padding, 0, 0);
        recyclerView.setAdapter(this.movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(null);
        this.movieListView = recyclerView;
        MovieAdapter movieAdapter = this.movieAdapter;
        if (movieAdapter != null) {
            Intrinsics.checkNotNull(recyclerView);
            movieAdapter.registerRecyclerOnEndlessScrollListener(recyclerView);
        }
        View view = this.fragmentView;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(this.movieListView, LayoutHelper.createFrame(-1, -1, 17));
        final VodLoadingCell vodLoadingCell = new VodLoadingCell(context);
        vodLoadingCell.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VodRelatedMovieListFragment.m346createView$lambda3$lambda2(vodLoadingCell, this, view2);
            }
        });
        this.loadingView = vodLoadingCell;
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.addView(this.loadingView);
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createView$lambda-3$lambda-2, reason: not valid java name */
    public static final void m346createView$lambda3$lambda2(VodLoadingCell this_apply, VodRelatedMovieListFragment this$0, View view) {
        VodRelatedMediaViewModel vodRelatedMediaViewModel;
        PagingRepositoryBuilder<GetCastRelatedOutput> castMediaUseCase;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this_apply.getLoadingMode() != VodLoadingCell.LoadingMode.RETRY || (vodRelatedMediaViewModel = this$0.viewModel) == null || (castMediaUseCase = vodRelatedMediaViewModel.getCastMediaUseCase()) == null) {
            return;
        }
        castMediaUseCase.retry();
    }

    @Override // ir.appp.ui.ActionBar.LifecycleAwareBaseFragment
    public void onLifecycleCreate() {
        VodRelatedMediaViewModel vodRelatedMediaViewModel;
        PagingRepositoryBuilder<GetCastRelatedOutput> castMediaUseCase;
        LiveData<BaseResponse<GetCastRelatedOutput>> liveData;
        super.onLifecycleCreate();
        if ((!Intrinsics.areEqual(this.category, VodCastReadEntity$CastRole.Actor.name()) && !Intrinsics.areEqual(this.category, VodCastReadEntity$CastRole.Director.name())) || (vodRelatedMediaViewModel = this.viewModel) == null || (castMediaUseCase = vodRelatedMediaViewModel.getCastMediaUseCase()) == null || (liveData = castMediaUseCase.getLiveData()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        CallbackStack.ObserveStarter observeStarterWith = LiveDataExtKt.with(liveData, viewLifecycleOwner);
        if (observeStarterWith == null) {
            return;
        }
        observeStarterWith.callbacks(new Function1<CallbackStack<GetCastRelatedOutput>, Unit>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.onLifecycleCreate.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CallbackStack<GetCastRelatedOutput> callbackStack) {
                invoke2(callbackStack);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CallbackStack<GetCastRelatedOutput> callbacks) {
                Intrinsics.checkNotNullParameter(callbacks, "$this$callbacks");
                final VodRelatedMovieListFragment vodRelatedMovieListFragment = VodRelatedMovieListFragment.this;
                callbacks.onLoading(new Function0<Unit>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.onLifecycleCreate.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (vodRelatedMovieListFragment.vodRelatedMoviesResponse == null) {
                            vodRelatedMovieListFragment.showLoading(true);
                        }
                    }
                });
                final VodRelatedMovieListFragment vodRelatedMovieListFragment2 = VodRelatedMovieListFragment.this;
                callbacks.onFailed(new Function1<BaseError, Unit>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.onLifecycleCreate.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BaseError baseError) {
                        invoke2(baseError);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BaseError it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        vodRelatedMovieListFragment2.showRetry();
                    }
                });
                final VodRelatedMovieListFragment vodRelatedMovieListFragment3 = VodRelatedMovieListFragment.this;
                callbacks.onSuccess(new Function1<GetCastRelatedOutput, Unit>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.onLifecycleCreate.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GetCastRelatedOutput getCastRelatedOutput) {
                        invoke2(getCastRelatedOutput);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GetCastRelatedOutput it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        vodRelatedMovieListFragment3.showLoading(false);
                        vodRelatedMovieListFragment3.vodRelatedMoviesResponse = it;
                        MovieAdapter movieAdapter = vodRelatedMovieListFragment3.movieAdapter;
                        List<VodBriefMediaEntity> currentList = movieAdapter == null ? null : movieAdapter.getCurrentList();
                        if (currentList == null) {
                            currentList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        ArrayList arrayList = new ArrayList(CollectionsKt___CollectionsKt.toList(currentList));
                        GetCastRelatedOutput getCastRelatedOutput = vodRelatedMovieListFragment3.vodRelatedMoviesResponse;
                        List<VodBriefMediaEntity> relatedMedia = getCastRelatedOutput != null ? getCastRelatedOutput.getRelatedMedia() : null;
                        if (relatedMedia == null) {
                            relatedMedia = CollectionsKt__CollectionsKt.emptyList();
                        }
                        arrayList.addAll(relatedMedia);
                        vodRelatedMovieListFragment3.movieList = arrayList;
                        MovieAdapter movieAdapter2 = vodRelatedMovieListFragment3.movieAdapter;
                        if (movieAdapter2 != null) {
                            movieAdapter2.submitList(arrayList);
                        }
                        MovieAdapter movieAdapter3 = vodRelatedMovieListFragment3.movieAdapter;
                        if (movieAdapter3 == null) {
                            return;
                        }
                        movieAdapter3.setTotalPages(100L);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRetry() {
        VodLoadingCell vodLoadingCell = this.loadingView;
        if (vodLoadingCell != null) {
            vodLoadingCell.setMode(VodLoadingCell.LoadingMode.RETRY);
        }
        VodLoadingCell vodLoadingCell2 = this.loadingView;
        if (vodLoadingCell2 == null) {
            return;
        }
        vodLoadingCell2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean z) {
        VodLoadingCell vodLoadingCell = this.loadingView;
        if (vodLoadingCell != null) {
            vodLoadingCell.setMode(VodLoadingCell.LoadingMode.LOADING);
        }
        VodLoadingCell vodLoadingCell2 = this.loadingView;
        if (vodLoadingCell2 == null) {
            return;
        }
        vodLoadingCell2.setVisibility(z ? 0 : 8);
    }

    /* compiled from: VodRelatedMovieListFragment.kt */
    private final class MovieAdapter extends BasePagingAdapter<VodBriefMediaEntity> {
        private final int columnCounts;

        public /* synthetic */ MovieAdapter(VodRelatedMovieListFragment vodRelatedMovieListFragment, int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(vodRelatedMovieListFragment, (i2 & 1) != 0 ? 3 : i, function1);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MovieAdapter(final VodRelatedMovieListFragment this$0, final int i, Function1<? super Integer, Boolean> onLoadMore) {
            super(new Function2<ViewGroup, Integer, View>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.MovieAdapter.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ View invoke(ViewGroup viewGroup, Integer num) {
                    return invoke(viewGroup, num.intValue());
                }

                public final View invoke(ViewGroup parent, int i2) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    VodRelatedVideoCell vodRelatedVideoCell = new VodRelatedVideoCell(context);
                    vodRelatedVideoCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    return vodRelatedVideoCell;
                }
            }, new Function1<ViewGroup, View>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.MovieAdapter.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final View invoke(ViewGroup it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    return new LoadingNewPageView(context);
                }
            }, new Function3<VodBriefMediaEntity, Integer, View, Unit>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.MovieAdapter.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(VodBriefMediaEntity vodBriefMediaEntity, Integer num, View view) {
                    invoke(vodBriefMediaEntity, num.intValue(), view);
                    return Unit.INSTANCE;
                }

                public final void invoke(VodBriefMediaEntity item, int i2, View itemView) {
                    int i3;
                    Integer numValueOf;
                    Intrinsics.checkNotNullParameter(item, "item");
                    Intrinsics.checkNotNullParameter(itemView, "itemView");
                    VodRelatedVideoCell vodRelatedVideoCell = (VodRelatedVideoCell) itemView;
                    vodRelatedVideoCell.setItemsCount(i);
                    int i4 = 0;
                    do {
                        int i5 = i;
                        if (i4 >= i5) {
                            break;
                        }
                        List list = this$0.movieList;
                        final VodBriefMediaEntity vodBriefMediaEntity = list == null ? null : (VodBriefMediaEntity) list.get((i5 * i2) + i4);
                        vodRelatedVideoCell.setData(i4, vodBriefMediaEntity == null ? null : vodBriefMediaEntity.getImageUrl());
                        vodRelatedVideoCell.setListener(i4, new Function0<Boolean>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment$MovieAdapter$3$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                VodBriefMediaEntity vodBriefMediaEntity2 = vodBriefMediaEntity;
                                return Boolean.valueOf(vodBriefMediaEntity2 == null ? false : ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new VodMediaDetailActivity(vodBriefMediaEntity2)));
                            }
                        });
                        i4++;
                        i3 = (i * i2) + i4;
                        List list2 = this$0.movieList;
                        numValueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
                        Intrinsics.checkNotNull(numValueOf);
                    } while (i3 < numValueOf.intValue());
                    vodRelatedVideoCell.requestLayout();
                }
            }, null, onLoadMore, new DiffUtil.ItemCallback<VodBriefMediaEntity>() { // from class: ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMovieListFragment.MovieAdapter.4
                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                public boolean areItemsTheSame(VodBriefMediaEntity oldItem, VodBriefMediaEntity newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return Intrinsics.areEqual(oldItem.getMediaId(), newItem.getMediaId());
                }

                @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                public boolean areContentsTheSame(VodBriefMediaEntity oldItem, VodBriefMediaEntity newItem) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return Intrinsics.areEqual(oldItem, newItem);
                }
            }, 8, null);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
            this.columnCounts = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<VodBriefMediaEntity> currentList = getCurrentList();
            if (currentList == null || currentList.isEmpty()) {
                return 0;
            }
            return (int) Math.ceil(getCurrentList().size() / this.columnCounts);
        }
    }
}
