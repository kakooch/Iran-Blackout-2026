package ir.appp.vod.ui.recyclerview.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.vod.ui.recyclerview.EndlessRecyclerOnScrollListener2;
import ir.appp.vod.ui.recyclerview.LoadingNewPageView;
import ir.appp.vod.ui.recyclerview.baseAdapter.PagingItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePagingAdapter.kt */
/* loaded from: classes3.dex */
public class BasePagingAdapter<M> extends RecyclerView.Adapter<BaseViewHolder> {
    private AsyncListDiffer<PagingItem<M>> asyncListDiffer;
    private final BasePagingAdapter$endlessRecyclerOnScrollListener$1 endlessRecyclerOnScrollListener;
    private boolean isEndlessRecyclerOnScrollListenerRegistered;
    private boolean isLoadMoreRequested;
    private final BasePagingAdapter$mDiffCallback$1 mDiffCallback;
    private final Function3<M, Integer, View, Unit> onBindViewHolder;
    private final Function1<ViewGroup, View> onCreateLoadingHolder;
    private final Function2<ViewGroup, Integer, View> onCreateViewHolder;
    private final Function1<M, Integer> onGetViewType;
    private final Function1<PagingItem<M>, Integer> onInternalGetViewType;
    private final Function1<Integer, Boolean> onLoadMore;

    static {
        new Companion(null);
    }

    public /* synthetic */ BasePagingAdapter(Function2 function2, Function1 function1, Function3 function3, Function1 function12, Function1 function13, DiffUtil.ItemCallback itemCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? null : function1, function3, (i & 8) != 0 ? null : function12, (i & 16) != 0 ? null : function13, itemCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [ir.appp.vod.ui.recyclerview.baseAdapter.BasePagingAdapter$endlessRecyclerOnScrollListener$1] */
    public BasePagingAdapter(Function2<? super ViewGroup, ? super Integer, ? extends View> onCreateViewHolder, Function1<? super ViewGroup, ? extends View> function1, Function3<? super M, ? super Integer, ? super View, Unit> onBindViewHolder, Function1<? super M, Integer> function12, Function1<? super Integer, Boolean> function13, final DiffUtil.ItemCallback<M> diffCallback) {
        Intrinsics.checkNotNullParameter(onCreateViewHolder, "onCreateViewHolder");
        Intrinsics.checkNotNullParameter(onBindViewHolder, "onBindViewHolder");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.onCreateViewHolder = onCreateViewHolder;
        this.onCreateLoadingHolder = function1;
        this.onBindViewHolder = onBindViewHolder;
        this.onGetViewType = function12;
        this.onLoadMore = function13;
        this.onInternalGetViewType = new Function1<PagingItem<M>, Integer>(this) { // from class: ir.appp.vod.ui.recyclerview.baseAdapter.BasePagingAdapter$onInternalGetViewType$1
            final /* synthetic */ BasePagingAdapter<M> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(PagingItem<M> item) {
                Integer num;
                Intrinsics.checkNotNullParameter(item, "item");
                int iIntValue = 0;
                if (item instanceof PagingItem.Loading) {
                    iIntValue = -100;
                } else {
                    if (!(item instanceof PagingItem.Content)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Function1 function14 = ((BasePagingAdapter) this.this$0).onGetViewType;
                    if (function14 != null && (num = (Integer) function14.invoke(((PagingItem.Content) item).getData())) != null) {
                        iIntValue = num.intValue();
                    }
                }
                return Integer.valueOf(iIntValue);
            }
        };
        DiffUtil.ItemCallback<PagingItem<M>> itemCallback = new DiffUtil.ItemCallback<PagingItem<M>>() { // from class: ir.appp.vod.ui.recyclerview.baseAdapter.BasePagingAdapter$mDiffCallback$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(PagingItem<M> oldItem, PagingItem<M> newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if ((oldItem instanceof PagingItem.Content) && (newItem instanceof PagingItem.Content)) {
                    return diffCallback.areItemsTheSame(((PagingItem.Content) oldItem).getData(), ((PagingItem.Content) newItem).getData());
                }
                return (oldItem instanceof PagingItem.Loading) && (newItem instanceof PagingItem.Loading);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(PagingItem<M> oldItem, PagingItem<M> newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if ((oldItem instanceof PagingItem.Content) && (newItem instanceof PagingItem.Content)) {
                    return diffCallback.areContentsTheSame(((PagingItem.Content) oldItem).getData(), ((PagingItem.Content) newItem).getData());
                }
                return (oldItem instanceof PagingItem.Loading) && (newItem instanceof PagingItem.Loading);
            }
        };
        this.mDiffCallback = itemCallback;
        this.asyncListDiffer = new AsyncListDiffer<>(this, itemCallback);
        this.endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener2(this) { // from class: ir.appp.vod.ui.recyclerview.baseAdapter.BasePagingAdapter$endlessRecyclerOnScrollListener$1
            final /* synthetic */ BasePagingAdapter<M> this$0;

            {
                this.this$0 = this;
            }

            @Override // ir.appp.vod.ui.recyclerview.EndlessRecyclerOnScrollListener2
            public void onLoadMore(int i) {
                if (this.this$0.isLoadMoreRequested()) {
                    return;
                }
                ((BasePagingAdapter) this.this$0).isLoadMoreRequested = true;
                Function1 function14 = ((BasePagingAdapter) this.this$0).onLoadMore;
                if (function14 != null && ((Boolean) function14.invoke(Integer.valueOf(i))).booleanValue()) {
                    this.this$0.showNextPageLoading();
                }
            }
        };
    }

    public final boolean isLoadMoreRequested() {
        return this.isLoadMoreRequested;
    }

    public final void setTotalPages(long j) {
        setTotalPages(j);
    }

    public final void registerRecyclerOnEndlessScrollListener(RecyclerView recycler) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        if (this.isEndlessRecyclerOnScrollListenerRegistered) {
            return;
        }
        this.isEndlessRecyclerOnScrollListenerRegistered = true;
        recycler.addOnScrollListener(this.endlessRecyclerOnScrollListener);
    }

    public final void submitList(List<? extends M> list) {
        if (this.isLoadMoreRequested) {
            dismissNextPageLoading();
        }
        AsyncListDiffer<PagingItem<M>> asyncListDiffer = this.asyncListDiffer;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PagingItem.Content(it.next()));
        }
        asyncListDiffer.submitList(arrayList);
    }

    public final List<M> getCurrentList() {
        List<PagingItem<M>> currentList = this.asyncListDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "asyncListDiffer.currentList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentList) {
            if (obj instanceof PagingItem.Content) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((PagingItem.Content) it.next()).getData());
        }
        return arrayList2;
    }

    public final M getItem(int i) {
        List<PagingItem<M>> currentList = this.asyncListDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "asyncListDiffer.currentList");
        Object orNull = CollectionsKt.getOrNull(currentList, i);
        PagingItem.Content content = orNull instanceof PagingItem.Content ? (PagingItem.Content) orNull : null;
        if (content == null) {
            return null;
        }
        return (M) content.getData();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<PagingItem<M>> currentList = this.asyncListDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "asyncListDiffer.currentList");
        PagingItem<M> pagingItem = (PagingItem) CollectionsKt.getOrNull(currentList, i);
        if (pagingItem == null) {
            return 0;
        }
        return this.onInternalGetViewType.invoke(pagingItem).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == -100) {
            Function1<ViewGroup, View> function1 = this.onCreateLoadingHolder;
            View viewInvoke = function1 == null ? null : function1.invoke(parent);
            if (viewInvoke == null) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                viewInvoke = new LoadingNewPageView(context);
            }
            return new BaseViewHolder(viewInvoke);
        }
        return new BaseViewHolder(this.onCreateViewHolder.invoke(parent, Integer.valueOf(i)));
    }

    public final void showNextPageLoading() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.asyncListDiffer.getCurrentList());
        arrayList.add(new PagingItem.Loading());
        this.asyncListDiffer.submitList(arrayList);
    }

    public final void dismissNextPageLoading() {
        ArrayList arrayList = new ArrayList();
        List<PagingItem<M>> currentList = this.asyncListDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "asyncListDiffer.currentList");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : currentList) {
            if (obj instanceof PagingItem.Content) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        this.asyncListDiffer.submitList(arrayList);
        cancel();
        this.isLoadMoreRequested = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.itemView.setTag(Integer.valueOf(i));
        M item = getItem(i);
        if (item == null) {
            return;
        }
        Function3<M, Integer, View, Unit> function3 = this.onBindViewHolder;
        Integer numValueOf = Integer.valueOf(i);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        function3.invoke(item, numValueOf, view);
    }

    /* compiled from: BasePagingAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
