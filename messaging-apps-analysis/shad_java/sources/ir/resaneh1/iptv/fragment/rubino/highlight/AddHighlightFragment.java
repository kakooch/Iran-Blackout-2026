package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class AddHighlightFragment extends BaseFragment {
    private ListAdapter adapter;
    private AnimatorSet avatarAnimation;
    private AvatarDrawable avatarDrawable;
    private RadialProgressView avatarProgressView;
    private int bottomPaddingRow;
    private FrameLayout changeImageContainer;
    private int changeImageRow;
    public final CompositeDisposable compositeDisposable;
    private BackupImageView coverImageView;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private HighlightPostGridLayout gridLayout;
    private boolean gridLayoutAttached;
    private int gridRow;
    private int iconRow;
    private HighlightImageUpdater imageUpdater;
    public Rubino.InputHighlightCover inputHighlightCover;
    private boolean isInLandscapeMode;
    private int lastMeasuredContentHeight;
    private int lastMeasuredContentWidth;
    private LinearLayoutManager layoutManager;
    private int listContentHeight;
    private RecyclerListViewEdited listView;
    private ContextProgressView progressView;
    private int rowCount;
    private final Rubino.StoryHighlight storyHighlight;
    private final ArrayList<StoryObject> storyObjectArrayList;
    private EditTextBoldCursor titleEditText;
    private int titleRow;
    private final int type;

    static /* synthetic */ int access$512(AddHighlightFragment addHighlightFragment, int i) {
        int i2 = addHighlightFragment.listContentHeight + i;
        addHighlightFragment.listContentHeight = i2;
        return i2;
    }

    public AddHighlightFragment(Set<StoryObject> set) {
        this.rowCount = 0;
        this.iconRow = -1;
        this.changeImageRow = -1;
        this.titleRow = -1;
        this.gridRow = -1;
        this.bottomPaddingRow = -1;
        ArrayList<StoryObject> arrayList = new ArrayList<>();
        this.storyObjectArrayList = arrayList;
        this.compositeDisposable = new CompositeDisposable();
        this.type = 907;
        arrayList.addAll(set);
        this.storyHighlight = null;
        this.isSmallActionBar = true;
    }

    public AddHighlightFragment(Rubino.StoryHighlight storyHighlight) {
        this.rowCount = 0;
        this.iconRow = -1;
        this.changeImageRow = -1;
        this.titleRow = -1;
        this.gridRow = -1;
        this.bottomPaddingRow = -1;
        this.storyObjectArrayList = new ArrayList<>();
        this.compositeDisposable = new CompositeDisposable();
        this.type = 341;
        this.storyHighlight = storyHighlight;
        this.isSmallActionBar = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.inputHighlightCover = new Rubino.InputHighlightCover(Rubino.InputHighlightCoverType.File);
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString(this.type == 907 ? R.string.rubinoNewHighLight : R.string.rubinoEditHighLight));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    AddHighlightFragment.this.finishFragment();
                } else if (i == 10) {
                    AddHighlightFragment.this.onDone();
                }
            }
        });
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(10, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        this.doneItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1));
        this.progressView.setVisibility(4);
        NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.2
            private boolean firstLayout = true;
            private boolean ignoreLayout;

            @Override // android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                boolean z;
                int measuredWidth;
                int iMax;
                int top;
                int adapterPosition;
                boolean z2;
                int iDp = AndroidUtilities.dp(48.0f) + (((BaseFragment) AddHighlightFragment.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
                if (AddHighlightFragment.this.listView != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) AddHighlightFragment.this.listView.getLayoutParams();
                    if (layoutParams.topMargin != iDp) {
                        layoutParams.topMargin = iDp;
                    }
                }
                super.onMeasure(i, i2);
                View.MeasureSpec.getSize(i2);
                boolean z3 = true;
                if (AddHighlightFragment.this.lastMeasuredContentWidth == getMeasuredWidth() && AddHighlightFragment.this.lastMeasuredContentHeight == getMeasuredHeight()) {
                    z = false;
                } else {
                    z = (AddHighlightFragment.this.lastMeasuredContentWidth == 0 || AddHighlightFragment.this.lastMeasuredContentWidth == getMeasuredWidth()) ? false : true;
                    AddHighlightFragment.this.listContentHeight = 0;
                    int itemCount = AddHighlightFragment.this.adapter.getItemCount();
                    AddHighlightFragment.this.lastMeasuredContentWidth = getMeasuredWidth();
                    AddHighlightFragment.this.lastMeasuredContentHeight = getMeasuredHeight();
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(AddHighlightFragment.this.listView.getMeasuredHeight(), 0);
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        int itemViewType = AddHighlightFragment.this.adapter.getItemViewType(i3);
                        if (itemViewType != 4 && itemViewType != 3 && itemViewType != 1) {
                            RecyclerView.ViewHolder viewHolderCreateViewHolder = AddHighlightFragment.this.adapter.createViewHolder(null, itemViewType);
                            AddHighlightFragment.this.adapter.onBindViewHolder(viewHolderCreateViewHolder, i3);
                            viewHolderCreateViewHolder.itemView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            AddHighlightFragment.access$512(AddHighlightFragment.this, viewHolderCreateViewHolder.itemView.getMeasuredHeight());
                        } else if (itemViewType == 4) {
                            AddHighlightFragment addHighlightFragment = AddHighlightFragment.this;
                            AddHighlightFragment.access$512(addHighlightFragment, addHighlightFragment.listView.getMeasuredHeight());
                        } else if (itemViewType == 1) {
                            AddHighlightFragment addHighlightFragment2 = AddHighlightFragment.this;
                            AddHighlightFragment.access$512(addHighlightFragment2, addHighlightFragment2.changeImageContainer.getMeasuredHeight());
                        } else {
                            AddHighlightFragment addHighlightFragment3 = AddHighlightFragment.this;
                            AddHighlightFragment.access$512(addHighlightFragment3, addHighlightFragment3.titleEditText.getMeasuredHeight());
                        }
                    }
                }
                if (this.firstLayout) {
                    return;
                }
                this.ignoreLayout = true;
                if (!AddHighlightFragment.this.isInLandscapeMode) {
                    measuredWidth = AddHighlightFragment.this.listView.getMeasuredWidth();
                    iMax = Math.max(0, getMeasuredHeight() - ((AddHighlightFragment.this.listContentHeight + AndroidUtilities.dp(88.0f)) + iDp));
                } else {
                    measuredWidth = AndroidUtilities.dp(88.0f);
                    iMax = 0;
                }
                int paddingTop = AddHighlightFragment.this.listView.getPaddingTop();
                View childAt = AddHighlightFragment.this.listView.getChildAt(0);
                if (childAt != null) {
                    RecyclerView.ViewHolder viewHolderFindContainingViewHolder = AddHighlightFragment.this.listView.findContainingViewHolder(childAt);
                    adapterPosition = viewHolderFindContainingViewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        adapterPosition = viewHolderFindContainingViewHolder.getPosition();
                    }
                    top = childAt.getTop();
                } else {
                    top = 0;
                    adapterPosition = -1;
                }
                if (z || adapterPosition == -1) {
                    z2 = false;
                } else {
                    AddHighlightFragment.this.layoutManager.scrollToPositionWithOffset(adapterPosition, top);
                    z2 = true;
                }
                if (paddingTop == measuredWidth && AddHighlightFragment.this.listView.getPaddingBottom() == iMax) {
                    z3 = z2;
                } else {
                    AddHighlightFragment.this.listView.setPadding(0, 0, 0, iMax);
                }
                if (z3) {
                    measureChildWithMargins(AddHighlightFragment.this.listView, i, 0, i2, 0);
                    AddHighlightFragment.this.listView.layout(0, iDp, AddHighlightFragment.this.listView.getMeasuredWidth(), AddHighlightFragment.this.listView.getMeasuredHeight() + iDp);
                }
                this.ignoreLayout = false;
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                this.firstLayout = false;
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.fragmentView = nestedFrameLayout;
        NestedFrameLayout nestedFrameLayout2 = nestedFrameLayout;
        this.listView = new RecyclerListViewEdited(context);
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        this.listView.setAdapter(listAdapter);
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.layoutManager = linearLayoutManager;
        recyclerListViewEdited.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setClipToPadding(false);
        this.listView.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        nestedFrameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        needLayout();
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(AddHighlightFragment.this.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                AddHighlightFragment.this.checkListViewScroll();
            }
        });
        nestedFrameLayout2.addView(this.actionBar);
        this.changeImageContainer = new FrameLayout(context);
        BackupImageView backupImageView = new BackupImageView(context);
        this.coverImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(60.0f));
        this.coverImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.circle_grey));
        this.changeImageContainer.addView(this.coverImageView, LayoutHelper.createFrame(120, 120, 17));
        final Paint paint = new Paint(1);
        paint.setColor(1426063360);
        RadialProgressView radialProgressView = new RadialProgressView(context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.4
            @Override // org.rbmain.ui.Components.RadialProgressView, android.view.View
            protected void onDraw(Canvas canvas) {
                if (AddHighlightFragment.this.coverImageView != null && AddHighlightFragment.this.coverImageView.getImageReceiver().hasNotThumb()) {
                    paint.setAlpha((int) (AddHighlightFragment.this.coverImageView.getImageReceiver().getCurrentAlpha() * 85.0f));
                    canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, AndroidUtilities.dp(21.0f), paint);
                }
                super.onDraw(canvas);
            }
        };
        this.avatarProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(26.0f));
        this.avatarProgressView.setProgressColor(-1);
        this.changeImageContainer.addView(this.avatarProgressView, LayoutHelper.createFrame(42, 42, 17));
        showAvatarProgress(false, false);
        HighlightImageUpdater highlightImageUpdater = new HighlightImageUpdater(this.currentAccount, false);
        this.imageUpdater = highlightImageUpdater;
        highlightImageUpdater.delegate = new HighlightImageUpdater.ImageUpdaterDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.5
            @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.ImageUpdaterDelegate
            public void didUploadedPhoto(HighlightImageUpdater.UploadFileObject uploadFileObject) {
                AddHighlightFragment.this.coverImageView.setImageBitmap(BitmapFactory.decodeFile(uploadFileObject.bigPhoto.filePath));
                AddHighlightFragment addHighlightFragment = AddHighlightFragment.this;
                Rubino.InputHighlightCover inputHighlightCover = addHighlightFragment.inputHighlightCover;
                inputHighlightCover.highlight_file_id = uploadFileObject.mainFileId;
                inputHighlightCover.highlight_hash_file_receive = uploadFileObject.mainAccessHashRec;
                addHighlightFragment.showAvatarProgress(false, true);
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.ImageUpdaterDelegate
            public void didStartUploadPhoto(HighlightImageUpdater.UploadFileObject uploadFileObject) {
                AddHighlightFragment.this.showAvatarProgress(true, true);
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.ImageUpdaterDelegate
            public void didFailedUploadPhoto(HighlightImageUpdater.UploadFileObject uploadFileObject) {
                AddHighlightFragment.this.showAvatarProgress(false, true);
            }
        };
        this.imageUpdater.parentFragment = this;
        this.changeImageContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0(view);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.titleEditText = editTextBoldCursor;
        editTextBoldCursor.setHint(LocaleController.getString(R.string.rubinoHighLightName));
        this.titleEditText.setGravity(17);
        this.titleEditText.setTextSize(20.0f);
        this.titleEditText.setBackgroundDrawable(null);
        this.titleEditText.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
        this.titleEditText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        EditTextBoldCursor editTextBoldCursor2 = this.titleEditText;
        editTextBoldCursor2.setFilters(InputFilterHelper.getFilter(30, 1, editTextBoldCursor2));
        this.titleEditText.setImeOptions(268435456);
        this.titleEditText.setInputType(16385);
        this.titleEditText.setCursorColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.titleEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.titleEditText.setCursorWidth(1.5f);
        this.titleEditText.setTypeface(Theme.getRubinoTypeFaceMedium());
        if (this.type == 341 && this.storyHighlight != null) {
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            this.avatarDrawable = avatarDrawable;
            this.coverImageView.setImage(this.storyHighlight.avatar_url, "50_50", avatarDrawable);
            this.titleEditText.setText(this.storyHighlight.name);
            HighlightPostGridLayout highlightPostGridLayout = this.gridLayout;
            if (highlightPostGridLayout != null) {
                highlightPostGridLayout.onDestroy();
            }
            HighlightPostGridLayout highlightPostGridLayout2 = new HighlightPostGridLayout(this, context, this, 2, this.storyHighlight) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.6
                @Override // ir.resaneh1.iptv.fragment.rubino.highlight.HighlightPostGridLayout
                protected void onSelectedTabChanged() {
                    super.onSelectedTabChanged();
                    loadStories(getSelectedTab());
                }
            };
            this.gridLayout = highlightPostGridLayout2;
            highlightPostGridLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
            this.gridLayout.loadStories(0);
        }
        updateRowIds();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        changeImage();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.7
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }
        };
        actionBar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        this.actionBar = actionBar;
        actionBar.setOccupyStatusBar(false);
        return actionBar;
    }

    private void updateRowIds() {
        int currentActionBarHeight;
        int i;
        int i2 = this.rowCount;
        this.rowCount = 0;
        this.iconRow = -1;
        this.changeImageRow = -1;
        this.titleRow = -1;
        this.gridRow = -1;
        this.bottomPaddingRow = -1;
        int i3 = 0 + 1;
        this.rowCount = i3;
        this.iconRow = 0;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.changeImageRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.titleRow = i4;
        if (this.type == 341) {
            this.rowCount = i5 + 1;
            this.gridRow = i5;
        }
        if (this.gridRow == -1) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.bottomPaddingRow = i6;
        }
        if (this.actionBar != null) {
            currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
        } else {
            currentActionBarHeight = 0;
        }
        if (this.listView == null || i2 > this.rowCount || ((i = this.listContentHeight) != 0 && i + currentActionBarHeight + AndroidUtilities.dp(88.0f) < this.listView.getMeasuredHeight())) {
            this.lastMeasuredContentWidth = 0;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(configuration);
        HighlightPostGridLayout highlightPostGridLayout = this.gridLayout;
        if (highlightPostGridLayout != null) {
            highlightPostGridLayout.onConfigurationChanged(configuration);
        }
        if (this.isInLandscapeMode && (viewFindViewByPosition = this.layoutManager.findViewByPosition(0)) != null) {
            this.listView.scrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f));
        }
        fixLayout();
    }

    private void fixLayout() {
        View view = this.fragmentView;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.8
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                AddHighlightFragment addHighlightFragment = AddHighlightFragment.this;
                if (addHighlightFragment.fragmentView == null) {
                    return true;
                }
                addHighlightFragment.checkListViewScroll();
                AddHighlightFragment.this.needLayout();
                AddHighlightFragment.this.fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayout() {
        int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
        RecyclerListViewEdited recyclerListViewEdited = this.listView;
        if (recyclerListViewEdited != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) recyclerListViewEdited.getLayoutParams();
            if (layoutParams.topMargin != currentActionBarHeight) {
                layoutParams.topMargin = currentActionBarHeight;
                this.listView.setLayoutParams(layoutParams);
            }
        }
        this.listView.setOverScrollMode(2);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        HighlightPostGridLayout highlightPostGridLayout = this.gridLayout;
        if (highlightPostGridLayout != null) {
            highlightPostGridLayout.onResume();
        }
        invalidateIsInLandscapeMode();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        fixLayout();
    }

    private void invalidateIsInLandscapeMode() {
        Point point = new Point();
        getParentActivity().getWindowManager().getDefaultDisplay().getSize(point);
        this.isInLandscapeMode = point.x > point.y;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDone() {
        if (this.type == 907) {
            String strValueOf = String.valueOf(this.titleEditText.getText());
            if (TextUtils.isEmpty(strValueOf)) {
                AndroidUtilities.shakeView(this.titleEditText, 2.0f, 0);
                return;
            }
            Rubino.InputHighlightCover inputHighlightCover = this.inputHighlightCover;
            if (inputHighlightCover.type == Rubino.InputHighlightCoverType.File && TextUtils.isEmpty(inputHighlightCover.highlight_file_id)) {
                ToastiLikeSnack.showS(getContext(), LocaleController.getString(R.string.rubinoHighlightUploadForce));
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<StoryObject> it = this.storyObjectArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().id);
            }
            showDoneProgress(true);
            this.compositeDisposable.add((DisposableObserver) getRubinoController().addHighlight(arrayList, strValueOf, this.inputHighlightCover).subscribeWith(new DisposableObserver<Rubino.AddHighlightOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.9
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Rubino.AddHighlightOutput addHighlightOutput) {
                    AddHighlightFragment.this.showDoneProgress(false);
                    if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof ArchiveStoryListFragment) {
                        ApplicationLoader.applicationActivity.getSecondLastFragment().removeSelfFromStack();
                    }
                    AddHighlightFragment.this.finishFragment();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    AddHighlightFragment.this.showDoneProgress(false);
                }
            }));
            return;
        }
        String strValueOf2 = String.valueOf(this.titleEditText.getText());
        if (TextUtils.isEmpty(strValueOf2)) {
            AndroidUtilities.shakeView(this.titleEditText, 2.0f, 0);
            return;
        }
        ArrayList<String> selectedStories = this.gridLayout.getSelectedStories();
        if (selectedStories == null || selectedStories.isEmpty()) {
            ToastiLikeSnack.showS(getContext(), LocaleController.getString(R.string.rubinoHighlightSelectOneStory));
            return;
        }
        ArrayList<String> addedStories = this.gridLayout.getAddedStories();
        ArrayList<String> removedStories = this.gridLayout.getRemovedStories();
        String str = strValueOf2.equals(this.storyHighlight.name) ? null : strValueOf2;
        Rubino.InputHighlightCover inputHighlightCover2 = this.inputHighlightCover;
        Rubino.InputHighlightCover inputHighlightCover3 = inputHighlightCover2.highlight_file_id != null ? inputHighlightCover2 : null;
        showDoneProgress(true);
        this.compositeDisposable.add((DisposableObserver) getRubinoController().editHighlight(this.storyHighlight.highlight_id, addedStories, removedStories, str, inputHighlightCover3).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                AddHighlightFragment.this.showDoneProgress(false);
                AddHighlightFragment.this.finishFragment();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                AddHighlightFragment.this.showDoneProgress(false);
            }
        }));
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.compositeDisposable.dispose();
        HighlightPostGridLayout highlightPostGridLayout = this.gridLayout;
        if (highlightPostGridLayout != null) {
            highlightPostGridLayout.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneProgress(final boolean z) {
        if (this.doneItem == null) {
            return;
        }
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.doneItemAnimation = new AnimatorSet();
        if (z) {
            this.progressView.setVisibility(0);
            this.doneItem.setEnabled(false);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleX", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleY", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "alpha", 0.0f), ObjectAnimator.ofFloat(this.progressView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.progressView, "alpha", 1.0f));
        } else {
            this.doneItem.getImageView().setVisibility(0);
            this.doneItem.setEnabled(true);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.progressView, "alpha", 0.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "alpha", 1.0f));
        }
        this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AddHighlightFragment.this.doneItemAnimation == null || !AddHighlightFragment.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    AddHighlightFragment.this.progressView.setVisibility(4);
                } else {
                    AddHighlightFragment.this.doneItem.getImageView().setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (AddHighlightFragment.this.doneItemAnimation == null || !AddHighlightFragment.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                AddHighlightFragment.this.doneItemAnimation = null;
            }
        });
        this.doneItemAnimation.setDuration(150L);
        this.doneItemAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setItems(new CharSequence[]{LocaleController.getString("FromCamera", R.string.FromCamera), LocaleController.getString("FromGalley", R.string.FromGalley)}, new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$changeImage$1(dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeImage$1(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.imageUpdater.openCamera();
        } else if (i == 1) {
            this.imageUpdater.openGallery();
        }
    }

    void showAvatarProgress(final boolean z, boolean z2) {
        if (this.avatarProgressView == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.avatarAnimation = null;
        }
        if (!z2) {
            if (z) {
                this.avatarProgressView.setAlpha(1.0f);
                this.avatarProgressView.setVisibility(0);
                return;
            } else {
                this.avatarProgressView.setAlpha(0.0f);
                this.avatarProgressView.setVisibility(4);
                return;
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.avatarAnimation = animatorSet2;
        if (z) {
            this.avatarProgressView.setVisibility(0);
            this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
        } else {
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
        }
        this.avatarAnimation.setDuration(180L);
        this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (AddHighlightFragment.this.avatarAnimation == null || AddHighlightFragment.this.avatarProgressView == null) {
                    return;
                }
                if (!z) {
                    AddHighlightFragment.this.avatarProgressView.setVisibility(4);
                }
                AddHighlightFragment.this.avatarAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                AddHighlightFragment.this.avatarAnimation = null;
            }
        });
        this.avatarAnimation.start();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        this.imageUpdater.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        private final Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            if (viewHolder.itemView == AddHighlightFragment.this.gridLayout) {
                AddHighlightFragment.this.gridLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            if (viewHolder.itemView == AddHighlightFragment.this.gridLayout) {
                AddHighlightFragment.this.gridLayoutAttached = false;
            }
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return itemViewType == 1 || itemViewType == 2 || itemViewType == 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 1) {
                if (AddHighlightFragment.this.changeImageContainer.getParent() != null) {
                    ((ViewGroup) AddHighlightFragment.this.coverImageView.getParent()).removeView(AddHighlightFragment.this.coverImageView);
                }
                view = AddHighlightFragment.this.changeImageContainer;
            } else if (i == 2) {
                TextView textView = new TextView(this.context);
                textView.setTextColor(ContextCompat.getColor(this.context, R.color.rubino_blue));
                textView.setTypeface(Theme.getRubinoTypeFaceMedium());
                textView.setText(LocaleController.getString(R.string.rubinoHighLightChangePhoto));
                textView.setGravity(17);
                textView.setTextSize(16.0f);
                textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment$ListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.lambda$onCreateViewHolder$0(view2);
                    }
                });
                view = textView;
            } else if (i == 3) {
                if (AddHighlightFragment.this.titleEditText.getParent() != null) {
                    ((ViewGroup) AddHighlightFragment.this.titleEditText.getParent()).removeView(AddHighlightFragment.this.titleEditText);
                }
                view = AddHighlightFragment.this.titleEditText;
            } else if (i == 4) {
                if (AddHighlightFragment.this.gridLayout.getParent() != null) {
                    ((ViewGroup) AddHighlightFragment.this.gridLayout.getParent()).removeView(AddHighlightFragment.this.gridLayout);
                }
                view = AddHighlightFragment.this.gridLayout;
            } else {
                view = i == 10 ? new View(this.context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.AddHighlightFragment.ListAdapter.1
                    private int lastPaddingHeight = 0;
                    private int lastListViewHeight = 0;

                    @Override // android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (this.lastListViewHeight != AddHighlightFragment.this.listView.getMeasuredHeight()) {
                            this.lastPaddingHeight = 0;
                        }
                        this.lastListViewHeight = AddHighlightFragment.this.listView.getMeasuredHeight();
                        int childCount = AddHighlightFragment.this.listView.getChildCount();
                        if (childCount != AddHighlightFragment.this.adapter.getItemCount()) {
                            setMeasuredDimension(AddHighlightFragment.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                            return;
                        }
                        int measuredHeight = 0;
                        for (int i4 = 0; i4 < childCount; i4++) {
                            if (AddHighlightFragment.this.listView.getChildAdapterPosition(AddHighlightFragment.this.listView.getChildAt(i4)) != AddHighlightFragment.this.bottomPaddingRow) {
                                measuredHeight += AddHighlightFragment.this.listView.getChildAt(i4).getMeasuredHeight();
                            }
                        }
                        int measuredHeight2 = ((AddHighlightFragment.this.fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                        if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                            measuredHeight2 = 0;
                        }
                        int i5 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                        int measuredWidth = AddHighlightFragment.this.listView.getMeasuredWidth();
                        this.lastPaddingHeight = i5;
                        setMeasuredDimension(measuredWidth, i5);
                    }
                } : null;
            }
            if (i != 4 && view != null) {
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
                layoutParams.setMargins(0, AndroidUtilities.dp(8.0f), 0, 0);
                view.setLayoutParams(layoutParams);
            }
            return new RecyclerListViewEdited.Holder(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            AddHighlightFragment.this.changeImage();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == AddHighlightFragment.this.iconRow) {
                return 1;
            }
            if (i == AddHighlightFragment.this.changeImageRow) {
                return 2;
            }
            if (i == AddHighlightFragment.this.titleRow) {
                return 3;
            }
            if (i == AddHighlightFragment.this.gridRow) {
                return 4;
            }
            if (i == AddHighlightFragment.this.bottomPaddingRow) {
                return 10;
            }
            return super.getItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AddHighlightFragment.this.rowCount;
        }
    }

    public RecyclerListViewEdited getListView() {
        return this.listView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkListViewScroll() {
        if (this.gridLayoutAttached) {
            Log.d("forough", "checkListViewScroll: ${gridLayout.getTop()} " + this.gridLayout.getTop());
            this.gridLayout.setVisibleHeight(this.listView.getMeasuredHeight() - this.gridLayout.getTop());
        }
        this.listView.getChildCount();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled() {
        HighlightPostGridLayout highlightPostGridLayout = this.gridLayout;
        return highlightPostGridLayout == null || highlightPostGridLayout.isCurrentTabFirst();
    }

    private class NestedFrameLayout extends FrameLayout implements NestedScrollingParent3 {
        private final NestedScrollingParentHelper nestedScrollingParentHelper;

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View view) {
        }

        public NestedFrameLayout(Context context) {
            super(context);
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        }

        @Override // androidx.core.view.NestedScrollingParent3
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (view == AddHighlightFragment.this.listView && AddHighlightFragment.this.gridLayoutAttached) {
                RecyclerListViewEdited currentListView = AddHighlightFragment.this.gridLayout.getCurrentListView();
                if (AddHighlightFragment.this.gridLayout.getTop() == 0) {
                    iArr[1] = i4;
                    currentListView.scrollBy(0, i4);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View view, float f, float f2) {
            return super.onNestedPreFling(view, f, f2);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
            if (view == AddHighlightFragment.this.listView) {
                if (AddHighlightFragment.this.gridRow == -1 || !AddHighlightFragment.this.gridLayoutAttached) {
                    return;
                }
                boolean zIsSearchFieldVisible = ((BaseFragment) AddHighlightFragment.this).actionBar.isSearchFieldVisible();
                int top = AddHighlightFragment.this.gridLayout.getTop();
                boolean z = false;
                if (i2 >= 0) {
                    if (zIsSearchFieldVisible) {
                        RecyclerListViewEdited currentListView = AddHighlightFragment.this.gridLayout.getCurrentListView();
                        iArr[1] = i2;
                        if (top > 0) {
                            iArr[1] = iArr[1] - Math.min(iArr[1], i2);
                        }
                        if (iArr[1] > 0) {
                            currentListView.scrollBy(0, iArr[1]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (top <= 0) {
                    RecyclerListViewEdited currentListView2 = AddHighlightFragment.this.gridLayout.getCurrentListView();
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) currentListView2.getLayoutManager()).findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition != -1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = currentListView2.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        int top2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView.getTop() : -1;
                        int paddingTop = currentListView2.getPaddingTop();
                        if (top2 != paddingTop || iFindFirstVisibleItemPosition != 0) {
                            iArr[1] = iFindFirstVisibleItemPosition != 0 ? i2 : Math.max(i2, top2 - paddingTop);
                            currentListView2.scrollBy(0, i2);
                            z = true;
                        }
                    }
                }
                if (zIsSearchFieldVisible) {
                    if (!z && top < 0) {
                        iArr[1] = i2 - Math.max(top, i2);
                    } else {
                        iArr[1] = i2;
                    }
                }
            }
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
            return AddHighlightFragment.this.gridRow != -1 && i == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View view, int i) {
            this.nestedScrollingParentHelper.onStopNestedScroll(view);
        }
    }
}
