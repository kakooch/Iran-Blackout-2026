package ir.resaneh1.iptv.fragment.home.parallax;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ir.resaneh1.iptv.fragment.home.GridSpacingItemDecoration;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: ParallaxCell.kt */
/* loaded from: classes3.dex */
public final class ParallaxCell extends HomeCell {
    private GestureDetector gestureDetector;
    private final GridSpacingItemDecoration itemDecoration;
    private Integer itemSize;
    private ParallaxAdapter parallaxAdapter;
    private HomePageModels.ParallaxSectionObject parallaxSection;
    private AutoScrollRecyclerView recyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParallaxCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration();
        this.itemDecoration = gridSpacingItemDecoration;
        Theme.getRubinoTypeFaceRegular();
        setWillNotDraw(false);
        AutoScrollRecyclerView autoScrollRecyclerView = this.recyclerView;
        if (autoScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            autoScrollRecyclerView = null;
        }
        autoScrollRecyclerView.addItemDecoration(gridSpacingItemDecoration);
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: ir.resaneh1.iptv.fragment.home.parallax.ParallaxCell$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                AutoScrollRecyclerView autoScrollRecyclerView2 = this.this$0.recyclerView;
                AutoScrollRecyclerView autoScrollRecyclerView3 = null;
                if (autoScrollRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    autoScrollRecyclerView2 = null;
                }
                View viewFindChildViewUnder = autoScrollRecyclerView2.findChildViewUnder(e.getX(), e.getY());
                if (viewFindChildViewUnder != null) {
                    ParallaxAdapter parallaxAdapter = this.this$0.parallaxAdapter;
                    if (parallaxAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
                        parallaxAdapter = null;
                    }
                    AutoScrollRecyclerView autoScrollRecyclerView4 = this.this$0.recyclerView;
                    if (autoScrollRecyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        autoScrollRecyclerView3 = autoScrollRecyclerView4;
                    }
                    parallaxAdapter.click(autoScrollRecyclerView3.getChildAdapterPosition(viewFindChildViewUnder));
                }
                return super.onSingleTapUp(e);
            }
        });
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.parallaxAdapter = new ParallaxAdapter(context);
        this.recyclerView = new AutoScrollRecyclerView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        AutoScrollRecyclerView autoScrollRecyclerView = this.recyclerView;
        AutoScrollRecyclerView autoScrollRecyclerView2 = null;
        if (autoScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            autoScrollRecyclerView = null;
        }
        frameLayout.addView(autoScrollRecyclerView, LayoutHelper.createFrame(-1, -2, 17));
        AutoScrollRecyclerView autoScrollRecyclerView3 = this.recyclerView;
        if (autoScrollRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            autoScrollRecyclerView2 = autoScrollRecyclerView3;
        }
        autoScrollRecyclerView2.recyclerIsAddedProgrammatically();
        return frameLayout;
    }

    private final void resetRecyclerView(int i) {
        AutoScrollRecyclerView autoScrollRecyclerView = this.recyclerView;
        ParallaxAdapter parallaxAdapter = null;
        if (autoScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            autoScrollRecyclerView = null;
        }
        this.itemDecoration.setSpacing(i / 2);
        ParallaxAdapter parallaxAdapter2 = this.parallaxAdapter;
        if (parallaxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
            parallaxAdapter2 = null;
        }
        autoScrollRecyclerView.setAdapter(parallaxAdapter2);
        HomePageModels.ParallaxSectionObject parallaxSectionObject = this.parallaxSection;
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(parallaxSectionObject != null ? parallaxSectionObject.row : 2, 0);
        staggeredGridLayoutManager.setReverseLayout(true);
        autoScrollRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        autoScrollRecyclerView.setNestedScrollingEnabled(false);
        autoScrollRecyclerView.setLoopEnabled(true);
        autoScrollRecyclerView.setCanTouch(true);
        ParallaxAdapter parallaxAdapter3 = this.parallaxAdapter;
        if (parallaxAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
        } else {
            parallaxAdapter = parallaxAdapter3;
        }
        autoScrollRecyclerView.setParallaxClickListener(parallaxAdapter);
        autoScrollRecyclerView.startAutoScroll();
    }

    private final int calculateLayout(int i) {
        return DimensionHelper.getScreenMinDimension((Activity) getContext()) / i;
    }

    public final void setData(HomePageModels.HomePageSectionObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        resetData();
        if (dataIsValid(data)) {
            VisibilityHelper.showViews(this);
            HomePageModels.ParallaxSectionObject parallaxSectionObject = data.parallax_section;
            this.parallaxSection = parallaxSectionObject;
            this.itemSize = Integer.valueOf(calculateLayout(parallaxSectionObject.column));
            setSectionInfoData(data.common_section_data, data.type);
            Integer num = this.itemSize;
            if (num == null) {
                return;
            }
            int iIntValue = num.intValue();
            ParallaxAdapter parallaxAdapter = this.parallaxAdapter;
            if (parallaxAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
                parallaxAdapter = null;
            }
            ArrayList<HomePageModels.ParallaxItem> arrayList = data.parallax_section.parallax_items_list;
            Intrinsics.checkNotNullExpressionValue(arrayList, "data.parallax_section.parallax_items_list");
            parallaxAdapter.updateList(arrayList, iIntValue);
            resetRecyclerView(iIntValue);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void resetData() {
        this.itemSize = 0;
        ParallaxAdapter parallaxAdapter = this.parallaxAdapter;
        if (parallaxAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
            parallaxAdapter = null;
        }
        parallaxAdapter.clearData();
    }

    private final boolean dataIsValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.ParallaxSectionObject parallaxSectionObject;
        return (homePageSectionObject == null || (parallaxSectionObject = homePageSectionObject.parallax_section) == null || parallaxSectionObject.parallax_items_list.isEmpty()) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Integer num = this.itemSize;
        if (num != null) {
            resetRecyclerView(num.intValue());
        }
        AutoScrollRecyclerView autoScrollRecyclerView = null;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass2(null), 2, null);
        AutoScrollRecyclerView autoScrollRecyclerView2 = this.recyclerView;
        if (autoScrollRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            autoScrollRecyclerView = autoScrollRecyclerView2;
        }
        autoScrollRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.home.parallax.ParallaxCell.onAttachedToWindow.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ParallaxCell.this.getGestureDetector().onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    /* compiled from: ParallaxCell.kt */
    @DebugMetadata(c = "ir.resaneh1.iptv.fragment.home.parallax.ParallaxCell$onAttachedToWindow$2", f = "ParallaxCell.kt", l = {126}, m = "invokeSuspend")
    /* renamed from: ir.resaneh1.iptv.fragment.home.parallax.ParallaxCell$onAttachedToWindow$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ParallaxCell.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            AutoScrollRecyclerView autoScrollRecyclerView = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutoScrollRecyclerView autoScrollRecyclerView2 = ParallaxCell.this.recyclerView;
                if (autoScrollRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    autoScrollRecyclerView2 = null;
                }
                autoScrollRecyclerView2.pauseAutoScroll(false);
                this.label = 1;
                if (DelayKt.delay(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AutoScrollRecyclerView autoScrollRecyclerView3 = ParallaxCell.this.recyclerView;
            if (autoScrollRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                autoScrollRecyclerView = autoScrollRecyclerView3;
            }
            autoScrollRecyclerView.openAutoScroll(30, true);
            return Unit.INSTANCE;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Integer num = this.itemSize;
        if (num == null) {
            return;
        }
        resetRecyclerView(num.intValue());
    }

    public final GestureDetector getGestureDetector() {
        return this.gestureDetector;
    }

    public final void setGestureDetector(GestureDetector gestureDetector) {
        Intrinsics.checkNotNullParameter(gestureDetector, "<set-?>");
        this.gestureDetector = gestureDetector;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AutoScrollRecyclerView autoScrollRecyclerView = this.recyclerView;
        ParallaxAdapter parallaxAdapter = null;
        if (autoScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            autoScrollRecyclerView = null;
        }
        autoScrollRecyclerView.pauseAutoScroll(true);
        ParallaxAdapter parallaxAdapter2 = this.parallaxAdapter;
        if (parallaxAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parallaxAdapter");
        } else {
            parallaxAdapter = parallaxAdapter2;
        }
        parallaxAdapter.cancelClick();
    }
}
