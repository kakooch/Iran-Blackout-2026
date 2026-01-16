package ir.appp.rghapp.rubinoPostSlider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.rghapp.RGHMediaHelper$AlbumEntry;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.rubinoPostSlider.AddPostPhotoCell;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostGridLayout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private final AddPostPhotoAdapter adapter;
    public ArrayList<RGHMediaHelper$AlbumEntry> allMediaAlbums;
    private Runnable broadcastPhotosRunnable;
    private final String[] conditionArguments;
    private boolean firstLoadOnList;
    private RGHMediaHelper$AlbumEntry galleryAlbumEntry;
    private int gridExtraSpace;
    GalleryObserverExternal imageExternalObserver;
    GalleryObserverInternal imageInternalObserver;
    private int imageItemSize;
    private boolean isListViewReachedBottomThresholdZone;
    private boolean isSelectingMode;
    private int lastItemSize;
    private AddPostGridLayoutDelegate layoutDelegate;
    private GridLayoutManager layoutManager;
    private final FrameLayout listContainer;
    private int listHeightReduction;
    private RecyclerListView listView;
    private boolean loadingPhotos;
    private final RGHAddPostActivity parentActivity;
    private final int parentHeaderHeight;
    private final Drawable pinnedHeaderShadowDrawable;
    private final View progressBar;
    private final LinearLayout progressView;
    private final String[] projectionPhotos;
    private final String[] projectionVideo;
    private int reachBottomThresholdIndex;
    private Runnable refreshGalleryRunnable;
    private RGHMediaHelper$AlbumEntry selectedAlbumEntry;
    private int selectedItemImageId;
    private final HashMap<Object, Object> selectedPhotos;
    private final ArrayList<Object> selectedPhotosOrder;
    private final View shadowLine;
    private final RGHSmoothScroller smoothScroller;
    GalleryObserverExternal videoExternalObserver;
    GalleryObserverInternal videoInternalObserver;

    public interface AddPostGridLayoutDelegate {
        void onItemSelected(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, boolean z);

        void onScrolled(boolean z, boolean z2, boolean z3);

        void onScrolledToLastRow(boolean z);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public AddPostGridLayout(Context context, RGHAddPostActivity rGHAddPostActivity, int i) throws Resources.NotFoundException {
        int iFindFirstVisibleItemPosition;
        int top;
        RecyclerListView.Holder holder;
        super(context);
        int i2 = UserConfig.selectedAccount;
        this.selectedPhotos = new HashMap<>();
        this.selectedPhotosOrder = new ArrayList<>();
        this.conditionArguments = new String[]{"250", "250"};
        String[] strArr = new String[9];
        strArr[0] = "_id";
        strArr[1] = "bucket_id";
        strArr[2] = "bucket_display_name";
        strArr[3] = "_data";
        int i3 = Build.VERSION.SDK_INT;
        strArr[4] = i3 > 28 ? "date_modified" : "datetaken";
        strArr[5] = "orientation";
        strArr[6] = "width";
        strArr[7] = "height";
        strArr[8] = "_size";
        this.projectionPhotos = strArr;
        String[] strArr2 = new String[9];
        strArr2[0] = "_id";
        strArr2[1] = "bucket_id";
        strArr2[2] = "bucket_display_name";
        strArr2[3] = "_data";
        strArr2[4] = i3 <= 28 ? "datetaken" : "date_modified";
        strArr2[5] = "duration";
        strArr2[6] = "width";
        strArr2[7] = "height";
        strArr2[8] = "_size";
        this.projectionVideo = strArr2;
        this.allMediaAlbums = new ArrayList<>();
        int iDp = AndroidUtilities.dp(80.0f);
        this.imageItemSize = iDp;
        this.lastItemSize = iDp;
        this.loadingPhotos = true;
        this.isListViewReachedBottomThresholdZone = false;
        this.isSelectingMode = false;
        this.firstLoadOnList = true;
        this.selectedItemImageId = -1;
        this.parentActivity = rGHAddPostActivity;
        rGHAddPostActivity.getActionBar();
        this.listHeightReduction = i;
        this.parentHeaderHeight = i;
        Drawable drawable = context.getResources().getDrawable(R.drawable.photos_header_shadow);
        this.pinnedHeaderShadowDrawable = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundGrayShadow), PorterDuff.Mode.MULTIPLY));
        AddPostPhotoAdapter addPostPhotoAdapter = new AddPostPhotoAdapter(context);
        this.adapter = addPostPhotoAdapter;
        addPostPhotoAdapter.createCache();
        setWillNotDraw(false);
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null || (iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition()) == this.layoutManager.getItemCount() - 1 || (holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) == null) {
            iFindFirstVisibleItemPosition = -1;
            top = 0;
        } else {
            top = holder.itemView.getTop();
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.listContainer = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(-1, -2.0f, 51, 4.0f, 1.0f, 0.0f, 0.0f));
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, context, this.imageItemSize) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.1
            @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = gridLayoutManager2;
        gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i4) {
                return AddPostGridLayout.this.imageItemSize;
            }
        });
        RecyclerListView recyclerListView = new RecyclerListView(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.3
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i4, int i5, int i6, int i7) {
                super.onLayout(z, i4, i5, i6, i7);
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setScrollingTouchSlop(1);
        this.listView.setItemAnimator(null);
        this.listView.setClipToPadding(false);
        this.listView.setSectionsType(2);
        this.listView.setLayoutManager(this.layoutManager);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 17));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                if (AddPostGridLayout.this.layoutDelegate != null) {
                    boolean z = AddPostGridLayout.this.layoutManager.findFirstCompletelyVisibleItemPosition() == 0;
                    boolean z2 = AddPostGridLayout.this.layoutManager.findLastVisibleItemPosition() == AddPostGridLayout.this.layoutManager.getItemCount() - 1;
                    if (!z2) {
                        z2 = AddPostGridLayout.this.layoutManager.findLastVisibleItemPosition() >= (AddPostGridLayout.this.layoutManager.getItemCount() - 1) - AddPostGridLayout.this.reachBottomThresholdIndex;
                    }
                    if (z2) {
                        AddPostGridLayout.this.layoutDelegate.onScrolledToLastRow(AddPostGridLayout.this.layoutManager.findLastCompletelyVisibleItemPosition() >= AddPostGridLayout.this.layoutManager.getItemCount() + (-5));
                    }
                    AddPostGridLayout.this.isListViewReachedBottomThresholdZone = z2;
                    AddPostGridLayout.this.layoutDelegate.onScrolled(z, z2, i5 < 0);
                }
            }
        });
        if (iFindFirstVisibleItemPosition != -1) {
            this.layoutManager.scrollToPositionWithOffset(iFindFirstVisibleItemPosition, top);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.progressView = linearLayout;
        linearLayout.setWillNotDraw(false);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        frameLayout.addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f));
        RubinoLoadingCell rubinoLoadingCell = new RubinoLoadingCell(context, false);
        this.progressBar = rubinoLoadingCell;
        linearLayout.addView(rubinoLoadingCell, LayoutHelper.createLinear(-2, -2));
        View view = new View(context);
        this.shadowLine = view;
        view.setBackgroundColor(-2500135);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.topMargin = 0;
        addView(view, layoutParams);
        this.listView.stopScroll();
        this.listView.setAdapter(addPostPhotoAdapter);
        this.listView.setPinnedHeaderShadowDrawable(drawable);
        if (this.loadingPhotos) {
            linearLayout.setVisibility(0);
            this.listView.setEmptyView(null);
        } else {
            linearLayout.setVisibility(8);
        }
        this.listView.setVisibility(0);
        this.smoothScroller = new RGHSmoothScroller(context);
        ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
        this.imageExternalObserver = new GalleryObserverExternal();
        this.videoExternalObserver = new GalleryObserverExternal();
        this.imageInternalObserver = new GalleryObserverInternal();
        this.videoInternalObserver = new GalleryObserverInternal();
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.imageExternalObserver);
        } catch (Exception unused) {
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.imageInternalObserver);
        } catch (Exception unused2) {
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, this.videoExternalObserver);
        } catch (Exception unused3) {
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Video.Media.INTERNAL_CONTENT_URI, true, this.videoInternalObserver);
        } catch (Exception unused4) {
        }
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view2, int i4) {
                return this.f$0.lambda$new$0(view2, i4);
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i4) {
                this.f$0.lambda$new$1(view2, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(View view, int i) {
        if (view instanceof AddPostPhotoCell) {
            AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) view;
            if (isLongClickEnabled()) {
                clearSelectedPhotos();
                internalToggleSelectionMode(true);
                onItemClicked(addPostPhotoCell, true, false);
            } else if (isClickingEnabled() || addPostPhotoCell.isChecked()) {
                addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                onItemClicked(addPostPhotoCell, true, this.isSelectingMode);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view, int i) {
        if (view instanceof AddPostPhotoCell) {
            AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) view;
            if (isClickingEnabled() || addPostPhotoCell.isChecked()) {
                addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                onItemClicked(addPostPhotoCell, true, this.isSelectingMode);
            }
        }
    }

    public void setLayoutDelegate(AddPostGridLayoutDelegate addPostGridLayoutDelegate) {
        this.layoutDelegate = addPostGridLayoutDelegate;
    }

    public void setListViewHeightReduction(int i) {
        this.listHeightReduction = i;
        requestLayout();
    }

    public boolean isSelectingMode() {
        return this.isSelectingMode;
    }

    public boolean isListFullyVisible() {
        if (this.adapter.getItemCount() < 4) {
            return true;
        }
        return this.layoutManager.findFirstCompletelyVisibleItemPosition() == 0 && this.layoutManager.findLastCompletelyVisibleItemPosition() == this.adapter.getItemCount() - 1;
    }

    @Override // android.view.View
    public void forceHasOverlappingRendering(boolean z) {
        super.forceHasOverlappingRendering(z);
    }

    public void onPreMeasure(int i, int i2) {
        this.imageItemSize = (i - AndroidUtilities.dp(12.0f)) / 4;
        calculateReachBottomThreshold();
        int i3 = this.lastItemSize;
        int i4 = this.imageItemSize;
        if (i3 != i4) {
            this.lastItemSize = i4;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreMeasure$2();
                }
            });
        }
        this.layoutManager.setSpanCount(Math.max(1, (this.imageItemSize * 4) + (AndroidUtilities.dp(1.0f) * 3)));
        int iCeil = (int) Math.ceil((this.adapter.getItemCount() - 1) / 4.0f);
        int iMax = Math.max(0, ((i2 - ((this.imageItemSize * iCeil) + ((iCeil - 1) * AndroidUtilities.dp(1.0f)))) - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(12.0f));
        if (this.gridExtraSpace != iMax) {
            this.gridExtraSpace = iMax;
            this.adapter.notifyDataSetChanged();
        }
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreMeasure$2() {
        this.adapter.notifyDataSetChanged();
    }

    private void calculateReachBottomThreshold() {
        this.reachBottomThresholdIndex = -1;
        int i = 0;
        while (true) {
            int i2 = this.parentHeaderHeight;
            if (i >= i2) {
                return;
            }
            int iAbs = Math.abs(i2 - i);
            int i3 = this.imageItemSize;
            if (iAbs <= i3) {
                return;
            }
            this.reachBottomThresholdIndex += 4;
            i += i3;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int height = this.parentActivity.getListView().getHeight();
        if (height == 0) {
            height = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(size, height);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (childAt == this.listContainer) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(height - this.listHeightReduction, 1073741824), 0);
                } else {
                    measureChildWithMargins(childAt, i, 0, i2, 0);
                }
            }
        }
    }

    public RecyclerListView getCurrentListView() {
        return this.listView;
    }

    public HashMap<Object, Object> getSelectedPhotos() {
        return this.selectedPhotos;
    }

    public ArrayList<Object> getSelectedPhotosOrder() {
        return this.selectedPhotosOrder;
    }

    public void setVisibleHeight(int i) {
        this.progressView.setTranslationY((-(getMeasuredHeight() - Math.max(i, AndroidUtilities.dp(120.0f)))) / 2.0f);
    }

    public void onDestroy() {
        ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
        try {
            contentResolver.unregisterContentObserver(this.imageExternalObserver);
        } catch (Exception unused) {
        }
        try {
            contentResolver.unregisterContentObserver(this.imageInternalObserver);
        } catch (Exception unused2) {
        }
        try {
            contentResolver.unregisterContentObserver(this.videoExternalObserver);
        } catch (Exception unused3) {
        }
        try {
            contentResolver.unregisterContentObserver(this.videoInternalObserver);
        } catch (Exception unused4) {
        }
    }

    public void onResume() {
        fixLayoutInternal();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    AddPostGridLayout.this.listContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                    AddPostGridLayout.this.fixLayoutInternal();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        AddPostPhotoAdapter addPostPhotoAdapter = this.adapter;
        if (addPostPhotoAdapter != null) {
            addPostPhotoAdapter.notifyDataSetChanged();
        }
    }

    public void loadGalleryPhotosAlbums(final int i) {
        Thread thread = new Thread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadGalleryPhotosAlbums$4(i);
            }
        });
        thread.setPriority(1);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(3:286|3|4)|(3:290|5|6)|12|(5:300|246|13|14|(10:23|24|296|25|26|(1:28)(1:29)|274|30|(22:284|32|33|272|34|35|(1:37)(1:38)|266|39|40|262|41|42|256|43|44|252|45|46|(7:49|294|50|(3:319|52|322)(15:318|53|(3:55|244|56)(1:57)|(3:59|302|60)(1:66)|280|67|68|276|69|(3:71|(1:82)(4:75|306|76|(3:78|270|79))|83)(1:84)|85|(2:87|(1:94)(1:93))|95|96|321)|320|308|47)|317|108)(1:126)|(1:128))(3:(4:260|17|(0)|(0))|22|(0)))|268|144|(4:151|(1:153)(1:154)|155|(5:157|(1:159)(1:160)|161|(4:164|(3:313|166|316)(12:312|167|(3:169|298|170)(1:172)|258|173|(4:175|(1:177)(1:178)|288|179)(1:185)|250|186|(2:188|(1:195)(3:193|248|194))(1:196)|197|198|315)|314|162)|311))|150|(2:254|207)|220|(2:223|221)|310|224|225|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x047b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b8 A[Catch: Exception -> 0x02bc, TRY_ENTER, TRY_LEAVE, TryCatch #28 {Exception -> 0x02bc, blocks: (B:128:0x02b8, B:143:0x0301), top: B:300:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0301 A[Catch: Exception -> 0x02bc, TRY_ENTER, TRY_LEAVE, TryCatch #28 {Exception -> 0x02bc, blocks: (B:128:0x02b8, B:143:0x0301), top: B:300:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x030a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x031a A[Catch: all -> 0x047b, TryCatch #12 {all -> 0x047b, blocks: (B:144:0x0304, B:147:0x030c, B:151:0x031a, B:155:0x0338, B:157:0x034c, B:161:0x036b, B:162:0x0387, B:164:0x038d, B:167:0x039a, B:169:0x03cf), top: B:268:0x0304 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x034c A[Catch: all -> 0x047b, TryCatch #12 {all -> 0x047b, blocks: (B:144:0x0304, B:147:0x030c, B:151:0x031a, B:155:0x0338, B:157:0x034c, B:161:0x036b, B:162:0x0387, B:164:0x038d, B:167:0x039a, B:169:0x03cf), top: B:268:0x0304 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0498 A[LOOP:0: B:221:0x0492->B:223:0x0498, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[Catch: all -> 0x02e2, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02e2, blocks: (B:13:0x005f, B:23:0x00a7), top: B:246:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0474 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0482 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:131:0x02bd -> B:268:0x0304). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadGalleryPhotosAlbums$4(int r56) {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.lambda$loadGalleryPhotosAlbums$4(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$loadGalleryPhotosAlbums$3(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2) {
        long j = rGHMediaHelper$PhotoEntry.dateTaken;
        long j2 = rGHMediaHelper$PhotoEntry2.dateTaken;
        if (j < j2) {
            return 1;
        }
        return j > j2 ? -1 : 0;
    }

    private void broadcastNewPhotos(int i, final ArrayList<RGHMediaHelper$AlbumEntry> arrayList, ArrayList<RGHMediaHelper$AlbumEntry> arrayList2, Integer num, final RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry, RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry2, RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry3, int i2) {
        Runnable runnable = this.broadcastPhotosRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$broadcastNewPhotos$5(arrayList, rGHMediaHelper$AlbumEntry);
            }
        };
        this.broadcastPhotosRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastNewPhotos$5(ArrayList arrayList, RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry) {
        this.broadcastPhotosRunnable = null;
        this.allMediaAlbums = arrayList;
        this.galleryAlbumEntry = rGHMediaHelper$AlbumEntry;
        if (this.selectedAlbumEntry != null) {
            int i = 0;
            while (true) {
                if (i >= this.allMediaAlbums.size()) {
                    break;
                }
                RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry2 = this.allMediaAlbums.get(i);
                if (rGHMediaHelper$AlbumEntry2.bucketId == this.selectedAlbumEntry.bucketId) {
                    this.selectedAlbumEntry = rGHMediaHelper$AlbumEntry2;
                    break;
                }
                i++;
            }
        } else {
            this.selectedAlbumEntry = rGHMediaHelper$AlbumEntry;
        }
        this.loadingPhotos = false;
        this.firstLoadOnList = true;
        this.adapter.notifyDataSetChanged();
        if (!this.selectedPhotosOrder.isEmpty() && this.galleryAlbumEntry != null) {
            int size = this.selectedPhotosOrder.size();
            for (int i2 = 0; i2 < size; i2++) {
                int iIntValue = ((Integer) this.selectedPhotosOrder.get(i2)).intValue();
                RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.galleryAlbumEntry.photosByIds.get(iIntValue);
                if (rGHMediaHelper$PhotoEntry != null) {
                    this.selectedPhotos.put(Integer.valueOf(iIntValue), rGHMediaHelper$PhotoEntry);
                }
            }
        }
        this.parentActivity.updateAlbumsDropDown();
    }

    public void updateSelectedPhotoBucket(int i) {
        RGHMediaHelper$AlbumEntry rGHMediaHelper$AlbumEntry = this.parentActivity.dropDownAlbums.get(i - 10);
        this.selectedAlbumEntry = rGHMediaHelper$AlbumEntry;
        if (rGHMediaHelper$AlbumEntry == this.galleryAlbumEntry) {
            this.parentActivity.dropDown.setText(LocaleController.getString("ChatGallery", R.string.ChatGallery));
        } else {
            this.parentActivity.dropDown.setText(rGHMediaHelper$AlbumEntry.bucketName);
        }
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int addToSelectedPhotos(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, int i) {
        Integer numValueOf = Integer.valueOf(rGHMediaHelper$PhotoEntry.imageId);
        if (this.selectedPhotos.containsKey(numValueOf)) {
            this.selectedPhotos.remove(numValueOf);
            int iIndexOf = this.selectedPhotosOrder.indexOf(numValueOf);
            if (iIndexOf >= 0) {
                this.selectedPhotosOrder.remove(iIndexOf);
            }
            updateCheckedPhotoIndices();
            if (this.selectedPhotos.size() != 0 && i >= 0) {
                rGHMediaHelper$PhotoEntry.resetForAddPost();
            }
            return iIndexOf;
        }
        this.selectedPhotos.put(numValueOf, rGHMediaHelper$PhotoEntry);
        this.selectedPhotosOrder.add(numValueOf);
        return -1;
    }

    private void updateCheckedPhotoIndices() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof AddPostPhotoCell) {
                AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) childAt;
                RGHMediaHelper$PhotoEntry photoEntryAtPosition = addPostPhotoCell.getTag() != null ? getPhotoEntryAtPosition(((Integer) addPostPhotoCell.getTag()).intValue()) : null;
                if (photoEntryAtPosition != null) {
                    addPostPhotoCell.setNum(this.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition.imageId)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RGHMediaHelper$PhotoEntry getPhotoEntryAtPosition(int i) {
        if (i >= 0 && i < this.selectedAlbumEntry.photos.size()) {
            return this.selectedAlbumEntry.photos.get(i);
        }
        return null;
    }

    private AddPostPhotoCell getMediaCellWithImageId(int i) {
        int childCount = this.listView.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                return null;
            }
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof AddPostPhotoCell) {
                AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) childAt;
                RGHMediaHelper$PhotoEntry photoEntryAtPosition = addPostPhotoCell.getTag() != null ? getPhotoEntryAtPosition(((Integer) addPostPhotoCell.getTag()).intValue()) : null;
                if (photoEntryAtPosition != null && photoEntryAtPosition.imageId == i) {
                    return addPostPhotoCell;
                }
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClicked(AddPostPhotoCell addPostPhotoCell, boolean z, boolean z2) {
        if (addPostPhotoCell == null || addPostPhotoCell.getTag() == null) {
            return;
        }
        int iIntValue = ((Integer) addPostPhotoCell.getTag()).intValue();
        RGHMediaHelper$PhotoEntry photoEntry = addPostPhotoCell.getPhotoEntry();
        int i = this.selectedItemImageId;
        int i2 = photoEntry.imageId;
        this.selectedItemImageId = i2;
        boolean zSelectLastSelectedMedia = false;
        boolean z3 = i == i2;
        boolean z4 = !this.selectedPhotos.containsKey(Integer.valueOf(i2));
        int iIntValue2 = -1;
        if (this.isSelectingMode) {
            if (z4 && this.parentActivity.maxSelectedPhotos >= 0 && this.selectedPhotos.size() >= this.parentActivity.maxSelectedPhotos) {
                return;
            }
            if (z || z4) {
                if (z4 && this.selectedPhotos.size() > 0) {
                    photoEntry.resetForAddPost();
                }
                if (!z2 || z3 || z4) {
                    addPostPhotoCell.setChecked(z4 ? this.selectedPhotosOrder.size() : -1, z4, true);
                    addToSelectedPhotos(photoEntry, iIntValue);
                }
            }
            if (this.selectedPhotos.size() != 0) {
                if (!z4 && z && (!z2 || z3)) {
                    addPostPhotoCell.getWhiteCurtain().setAlpha(0.0f);
                    zSelectLastSelectedMedia = selectLastSelectedMedia();
                }
                this.adapter.notifyItemChanged(iIntValue);
            }
        } else {
            if (z4) {
                Iterator<Object> it = this.selectedPhotos.values().iterator();
                while (it.hasNext()) {
                    ((RGHMediaHelper$PhotoEntry) it.next()).resetForAddPost();
                }
                this.selectedPhotos.clear();
                this.selectedPhotosOrder.clear();
            }
            if (!z3 && z4) {
                photoEntry.resetForAddPost();
            }
            addPostPhotoCell.setChecked(z4 ? this.selectedPhotosOrder.size() : -1, z4, true);
            if (z4 && z) {
                addToSelectedPhotos(photoEntry, iIntValue);
            }
        }
        if (zSelectLastSelectedMedia) {
            return;
        }
        if (i != -1 && !z3) {
            AddPostPhotoCell mediaCellWithImageId = getMediaCellWithImageId(i);
            if (mediaCellWithImageId != null && mediaCellWithImageId.getTag() != null) {
                iIntValue2 = ((Integer) mediaCellWithImageId.getTag()).intValue();
            }
            this.adapter.notifyItemChanged(iIntValue2);
        }
        if (z) {
            scrollToIndex(iIntValue, photoEntry, z4);
        }
    }

    private boolean selectLastSelectedMedia() {
        ArrayList<Object> arrayList = this.selectedPhotosOrder;
        int iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
        int childCount = this.listView.getChildCount();
        boolean z = true;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof AddPostPhotoCell) {
                AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) childAt;
                RGHMediaHelper$PhotoEntry photoEntryAtPosition = addPostPhotoCell.getTag() != null ? getPhotoEntryAtPosition(((Integer) addPostPhotoCell.getTag()).intValue()) : null;
                if (photoEntryAtPosition != null && photoEntryAtPosition.imageId == iIntValue) {
                    int iIntValue2 = ((Integer) addPostPhotoCell.getTag()).intValue();
                    this.selectedItemImageId = photoEntryAtPosition.imageId;
                    addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                    this.adapter.notifyItemChanged(iIntValue2);
                    z = false;
                }
            }
        }
        if (z) {
            this.selectedItemImageId = -1;
        }
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = (RGHMediaHelper$PhotoEntry) this.selectedPhotos.get(Integer.valueOf(iIntValue));
        AddPostGridLayoutDelegate addPostGridLayoutDelegate = this.layoutDelegate;
        if (addPostGridLayoutDelegate == null || rGHMediaHelper$PhotoEntry == null) {
            return false;
        }
        addPostGridLayoutDelegate.onItemSelected(rGHMediaHelper$PhotoEntry, false);
        return true;
    }

    private void scrollToIndex(final int i, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, boolean z) {
        if (this.isListViewReachedBottomThresholdZone) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scrollToIndex$6(i);
                }
            }, this.smoothScroller.estimateAnimationDuration());
        } else if (z) {
            this.smoothScroller.setTargetPosition(i);
            this.layoutManager.startSmoothScroll(this.smoothScroller);
        }
        this.layoutDelegate.onItemSelected(rGHMediaHelper$PhotoEntry, this.selectedPhotos.size() == this.parentActivity.maxSelectedPhotos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollToIndex$6(int i) {
        this.smoothScroller.setTargetPosition(i);
        this.layoutManager.startSmoothScroll(this.smoothScroller);
    }

    public void onSelectionButtonClicked() {
        if (this.isSelectingMode) {
            clearSelectionMode();
        } else {
            startSelectionMode();
        }
    }

    private void clearSelectedPhotos() {
        this.selectedPhotos.clear();
        this.selectedPhotosOrder.clear();
        AddPostPhotoCell mediaCellWithImageId = getMediaCellWithImageId(this.selectedItemImageId);
        this.selectedItemImageId = -1;
        onItemClicked(mediaCellWithImageId, false, false);
    }

    private void clearSelectionMode() {
        clearSelectedPhotos();
        internalToggleSelectionMode(false);
    }

    private void startSelectionMode() {
        internalToggleSelectionMode(true);
        onItemClicked(getMediaCellWithImageId(this.selectedItemImageId), false, false);
    }

    private void internalToggleSelectionMode(boolean z) {
        if (this.isSelectingMode == z) {
            return;
        }
        this.parentActivity.updateUIAccordingToSelectionMode();
        this.isSelectingMode = z;
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof AddPostPhotoCell) {
                AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) childAt;
                int iIntValue = addPostPhotoCell.getTag() != null ? ((Integer) addPostPhotoCell.getTag()).intValue() : -1;
                if (!z) {
                    addPostPhotoCell.setChecked(-1, false, false);
                }
                RGHMediaHelper$PhotoEntry photoEntryAtPosition = iIntValue != -1 ? getPhotoEntryAtPosition(iIntValue) : null;
                addPostPhotoCell.setInSelectMode(z, (photoEntryAtPosition == null || photoEntryAtPosition.imageId == this.selectedItemImageId) ? false : true);
                this.adapter.notifyItemChanged(iIntValue);
            }
        }
    }

    public boolean isLongClickEnabled() {
        return this.selectedPhotos.size() < this.parentActivity.maxSelectedPhotos && !this.isSelectingMode;
    }

    public boolean isClickingEnabled() {
        return this.selectedPhotos.size() < this.parentActivity.maxSelectedPhotos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GalleryObserverInternal extends ContentObserver {
        public GalleryObserverInternal() {
            super(null);
        }

        private void scheduleReloadRunnable() {
            AndroidUtilities.runOnUIThread(AddPostGridLayout.this.refreshGalleryRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$GalleryObserverInternal$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleReloadRunnable$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$scheduleReloadRunnable$0() {
            AddPostGridLayout.this.refreshGalleryRunnable = null;
            AddPostGridLayout.this.loadGalleryPhotosAlbums(0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (AddPostGridLayout.this.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(AddPostGridLayout.this.refreshGalleryRunnable);
            }
            scheduleReloadRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GalleryObserverExternal extends ContentObserver {
        public GalleryObserverExternal() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (AddPostGridLayout.this.refreshGalleryRunnable != null) {
                AndroidUtilities.cancelRunOnUIThread(AddPostGridLayout.this.refreshGalleryRunnable);
            }
            AndroidUtilities.runOnUIThread(AddPostGridLayout.this.refreshGalleryRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$GalleryObserverExternal$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onChange$0();
                }
            }, 2000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChange$0() {
            AddPostGridLayout.this.refreshGalleryRunnable = null;
            AddPostGridLayout.this.loadGalleryPhotosAlbums(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AddPostPhotoAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;
        private final ArrayList<RecyclerListView.Holder> viewsCache = new ArrayList<>(8);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public AddPostPhotoAdapter(Context context) {
            this.mContext = context;
        }

        public void createCache() {
            for (int i = 0; i < 8; i++) {
                this.viewsCache.add(createHolder());
            }
        }

        public RecyclerListView.Holder createHolder() {
            AddPostPhotoCell addPostPhotoCell = new AddPostPhotoCell(this.mContext) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout.AddPostPhotoAdapter.1
                @Override // ir.appp.rghapp.rubinoPostSlider.AddPostPhotoCell
                public boolean isInSelectionMode() {
                    return AddPostGridLayout.this.isSelectingMode;
                }
            };
            addPostPhotoCell.setDelegate(new AddPostPhotoCell.AddPostPhotoCellDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostGridLayout$AddPostPhotoAdapter$$ExternalSyntheticLambda0
                @Override // ir.appp.rghapp.rubinoPostSlider.AddPostPhotoCell.AddPostPhotoCellDelegate
                public final void didClickCheckBox(AddPostPhotoCell addPostPhotoCell2) {
                    this.f$0.lambda$createHolder$0(addPostPhotoCell2);
                }
            });
            return new RecyclerListView.Holder(addPostPhotoCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createHolder$0(AddPostPhotoCell addPostPhotoCell) {
            AddPostGridLayout.this.onItemClicked(addPostPhotoCell, true, false);
        }

        private void handleUIUpdateOnCells(AddPostPhotoCell addPostPhotoCell, int i) {
            if (AddPostGridLayout.this.isSelectingMode) {
                addPostPhotoCell.getCheckBox().setAlpha(1.0f);
            } else {
                addPostPhotoCell.getCheckBox().setAlpha(0.0f);
            }
            RGHMediaHelper$PhotoEntry photoEntryAtPosition = AddPostGridLayout.this.getPhotoEntryAtPosition(i);
            if (AddPostGridLayout.this.selectedItemImageId != -1) {
                if (photoEntryAtPosition != null && photoEntryAtPosition.imageId == AddPostGridLayout.this.selectedItemImageId) {
                    addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                    return;
                }
                addPostPhotoCell.getWhiteCurtain().setAlpha(0.0f);
                if (photoEntryAtPosition == null || AddPostGridLayout.this.selectedPhotos.containsKey(Integer.valueOf(photoEntryAtPosition.imageId))) {
                    return;
                }
                addPostPhotoCell.setChecked(-1, false, false);
                return;
            }
            if (AddPostGridLayout.this.firstLoadOnList || AddPostGridLayout.this.selectedPhotosOrder.size() == 0) {
                return;
            }
            int iIntValue = ((Integer) AddPostGridLayout.this.selectedPhotosOrder.get(AddPostGridLayout.this.selectedPhotosOrder.size() - 1)).intValue();
            if (photoEntryAtPosition != null) {
                int i2 = photoEntryAtPosition.imageId;
                if (i2 == iIntValue) {
                    AddPostGridLayout.this.selectedItemImageId = i2;
                    addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                } else {
                    addPostPhotoCell.getWhiteCurtain().setAlpha(0.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            AddPostPhotoCell addPostPhotoCell = (AddPostPhotoCell) viewHolder.itemView;
            addPostPhotoCell.setItemSize(AddPostGridLayout.this.imageItemSize);
            RGHMediaHelper$PhotoEntry photoEntryAtPosition = AddPostGridLayout.this.getPhotoEntryAtPosition(i);
            addPostPhotoCell.setPhotoEntry(photoEntryAtPosition, false, i == getItemCount() - 1);
            addPostPhotoCell.setChecked(AddPostGridLayout.this.selectedPhotosOrder.indexOf(Integer.valueOf(photoEntryAtPosition.imageId)), AddPostGridLayout.this.selectedPhotos.containsKey(Integer.valueOf(photoEntryAtPosition.imageId)), false);
            addPostPhotoCell.getImageView().setTag(Integer.valueOf(i));
            addPostPhotoCell.setTag(Integer.valueOf(i));
            handleUIUpdateOnCells(addPostPhotoCell, i);
            if (AddPostGridLayout.this.firstLoadOnList && i == 0) {
                AddPostGridLayout.this.firstLoadOnList = false;
                AddPostGridLayout.this.selectedItemImageId = photoEntryAtPosition.imageId;
                addPostPhotoCell.getWhiteCurtain().setAlpha(1.0f);
                AddPostGridLayout.this.selectedPhotos.clear();
                AddPostGridLayout.this.selectedPhotosOrder.clear();
                addPostPhotoCell.setChecked(1, true, true);
                AddPostGridLayout.this.addToSelectedPhotos(photoEntryAtPosition, i);
                if (AddPostGridLayout.this.layoutDelegate != null) {
                    AddPostGridLayout.this.layoutDelegate.onItemSelected(photoEntryAtPosition, false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (!this.viewsCache.isEmpty()) {
                RecyclerListView.Holder holder = this.viewsCache.get(0);
                this.viewsCache.remove(0);
                return holder;
            }
            return createHolder();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (AddPostGridLayout.this.selectedAlbumEntry != null) {
                return 0 + AddPostGridLayout.this.selectedAlbumEntry.photos.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            handleUIUpdateOnCells((AddPostPhotoCell) viewHolder.itemView, viewHolder.getAdapterPosition());
            super.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            if (this == AddPostGridLayout.this.adapter) {
                AddPostGridLayout.this.progressView.setVisibility((getItemCount() == 1 && AddPostGridLayout.this.selectedAlbumEntry == null) ? 0 : 4);
            }
        }
    }
}
