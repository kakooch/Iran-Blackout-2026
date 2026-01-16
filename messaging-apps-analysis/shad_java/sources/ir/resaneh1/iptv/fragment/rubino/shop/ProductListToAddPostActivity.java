package ir.resaneh1.iptv.fragment.rubino.shop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.GetProductsInput;
import ir.resaneh1.iptv.model.GetProductsOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.GroupCreateSectionCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.GroupCreateDividerItemDecoration;

/* loaded from: classes3.dex */
public class ProductListToAddPostActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, View.OnClickListener {
    private GroupCreateAdapter adapter;
    private int containerHeight;
    private ProductSpan currentDeletingSpan;
    private AnimatorSet currentDoneButtonAnimation;
    private ActionBarMenuItem doneButton;
    private boolean doneButtonVisible;
    private AnimatorSet doneItemAnimation;
    private EditTextBoldCursor editText;
    private EmptyTextProgressView emptyView;
    private int fieldY;
    private boolean hasContinue;
    private boolean hasContinueSearch;
    private boolean ignoreScrollEvent;
    private GroupCreateDividerItemDecoration itemDecoration;
    private RecyclerListView listView;
    private int maxCount;
    private String postId;
    private ArrayList<String> postProductIds;
    public ArrayList<ShopModels.ProductSummaryObject> products;
    private ContextProgressView progressView;
    private DisposableObserver requestDisposableAddChannel;
    private DisposableObserver requestDisposableGetItems;
    private ScrollView scrollView;
    private boolean searchWas;
    private boolean searching;
    private SpansContainer spansContainer;
    private String startId;
    private String startIdSearch;
    private String storeID;
    private HashMap<String, ProductSpan> selectedContacts = new HashMap<>();
    private ArrayList<ProductSpan> allSpans = new ArrayList<>();

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public ProductListToAddPostActivity(String str, String str2, ArrayList<String> arrayList) {
        this.maxCount = 10;
        this.maxCount = 10;
        this.storeID = str;
        this.postId = str2;
        this.postProductIds = arrayList;
    }

    private class SpansContainer extends ViewGroup {
        private View addingSpan;
        private boolean animationStarted;
        private ArrayList<Animator> animators;
        private AnimatorSet currentAnimation;
        private View removingSpan;

        public SpansContainer(Context context) {
            super(context);
            this.animators = new ArrayList<>();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int iMin;
            boolean z;
            float f;
            float f2;
            int i3;
            char c;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i);
            float f3 = 32.0f;
            int iDp = size - AndroidUtilities.dp(32.0f);
            int iDp2 = AndroidUtilities.dp(12.0f);
            int iDp3 = AndroidUtilities.dp(12.0f);
            int i4 = 0;
            int measuredWidth = 0;
            int measuredWidth2 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt instanceof ProductSpan) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(f3), 1073741824));
                    if (childAt == this.removingSpan || childAt.getMeasuredWidth() + measuredWidth <= iDp) {
                        f = 12.0f;
                    } else {
                        f = 12.0f;
                        iDp2 += childAt.getMeasuredHeight() + AndroidUtilities.dp(12.0f);
                        measuredWidth = 0;
                    }
                    if (childAt.getMeasuredWidth() + measuredWidth2 > iDp) {
                        iDp3 += childAt.getMeasuredHeight() + AndroidUtilities.dp(f);
                        f2 = 16.0f;
                        measuredWidth2 = 0;
                    } else {
                        f2 = 16.0f;
                    }
                    int iDp4 = AndroidUtilities.dp(f2) + measuredWidth;
                    if (!this.animationStarted) {
                        View view = this.removingSpan;
                        if (childAt == view) {
                            childAt.setTranslationX(AndroidUtilities.dp(f2) + measuredWidth2);
                            childAt.setTranslationY(iDp3);
                        } else if (view != null) {
                            float f4 = iDp4;
                            if (childAt.getTranslationX() != f4) {
                                i3 = 1;
                                c = 0;
                                this.animators.add(ObjectAnimator.ofFloat(childAt, "translationX", f4));
                            } else {
                                i3 = 1;
                                c = 0;
                            }
                            float f5 = iDp2;
                            if (childAt.getTranslationY() != f5) {
                                ArrayList<Animator> arrayList = this.animators;
                                float[] fArr = new float[i3];
                                fArr[c] = f5;
                                arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", fArr));
                            }
                        } else {
                            childAt.setTranslationX(iDp4);
                            childAt.setTranslationY(iDp2);
                        }
                    }
                    if (childAt != this.removingSpan) {
                        measuredWidth += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                    }
                    measuredWidth2 += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                }
                i4++;
                f3 = 32.0f;
            }
            if (AndroidUtilities.isTablet()) {
                iMin = AndroidUtilities.dp(366.0f) / 3;
            } else {
                Point point = AndroidUtilities.displaySize;
                iMin = (Math.min(point.x, point.y) - AndroidUtilities.dp(164.0f)) / 3;
            }
            if (iDp - measuredWidth < iMin) {
                iDp2 += AndroidUtilities.dp(44.0f);
                measuredWidth = 0;
            }
            if (iDp - measuredWidth2 < iMin) {
                iDp3 += AndroidUtilities.dp(44.0f);
            }
            ProductListToAddPostActivity.this.editText.measure(View.MeasureSpec.makeMeasureSpec(iDp - measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
            if (!this.animationStarted) {
                int iDp5 = iDp3 + AndroidUtilities.dp(44.0f);
                int iDp6 = measuredWidth + AndroidUtilities.dp(16.0f);
                ProductListToAddPostActivity.this.fieldY = iDp2;
                if (this.currentAnimation == null) {
                    ProductListToAddPostActivity.this.containerHeight = iDp5;
                    ProductListToAddPostActivity.this.editText.setTranslationX(iDp6);
                    ProductListToAddPostActivity.this.editText.setTranslationY(ProductListToAddPostActivity.this.fieldY);
                } else {
                    int iDp7 = iDp2 + AndroidUtilities.dp(44.0f);
                    if (ProductListToAddPostActivity.this.containerHeight != iDp7) {
                        this.animators.add(ObjectAnimator.ofInt(ProductListToAddPostActivity.this, "containerHeight", iDp7));
                    }
                    float f6 = iDp6;
                    if (ProductListToAddPostActivity.this.editText.getTranslationX() != f6) {
                        this.animators.add(ObjectAnimator.ofFloat(ProductListToAddPostActivity.this.editText, "translationX", f6));
                    }
                    if (ProductListToAddPostActivity.this.editText.getTranslationY() != ProductListToAddPostActivity.this.fieldY) {
                        z = false;
                        this.animators.add(ObjectAnimator.ofFloat(ProductListToAddPostActivity.this.editText, "translationY", ProductListToAddPostActivity.this.fieldY));
                    } else {
                        z = false;
                    }
                    ProductListToAddPostActivity.this.editText.setAllowDrawCursor(z);
                    this.currentAnimation.playTogether(this.animators);
                    this.currentAnimation.start();
                    this.animationStarted = true;
                }
            } else if (this.currentAnimation != null && !ProductListToAddPostActivity.this.ignoreScrollEvent && this.removingSpan == null) {
                ProductListToAddPostActivity.this.editText.bringPointIntoView(ProductListToAddPostActivity.this.editText.getSelectionStart());
            }
            setMeasuredDimension(size, ProductListToAddPostActivity.this.containerHeight);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        public void addSpan(ProductSpan productSpan) {
            ProductListToAddPostActivity.this.allSpans.add(productSpan);
            ProductListToAddPostActivity.this.selectedContacts.put(productSpan.getUid(), productSpan);
            ProductListToAddPostActivity.this.editText.setHint(BuildConfig.FLAVOR);
            ProductListToAddPostActivity.this.editText.setHintVisible(false);
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.setupEndValues();
                this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.SpansContainer.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.addingSpan = null;
                    SpansContainer.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                    ProductListToAddPostActivity.this.editText.setAllowDrawCursor(true);
                }
            });
            this.currentAnimation.setDuration(150L);
            this.addingSpan = productSpan;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "scaleX", 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "scaleY", 0.01f, 1.0f));
            this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, "alpha", 0.0f, 1.0f));
            addView(productSpan);
        }

        public void removeSpan(final ProductSpan productSpan) {
            ProductListToAddPostActivity.this.ignoreScrollEvent = true;
            ProductListToAddPostActivity.this.selectedContacts.remove(productSpan.getUid());
            ProductListToAddPostActivity.this.allSpans.remove(productSpan);
            productSpan.setOnClickListener(null);
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.setupEndValues();
                this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.SpansContainer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.removeView(productSpan);
                    SpansContainer.this.removingSpan = null;
                    SpansContainer.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                    ProductListToAddPostActivity.this.editText.setAllowDrawCursor(true);
                    if (ProductListToAddPostActivity.this.allSpans.isEmpty()) {
                        ProductListToAddPostActivity.this.editText.setHintVisible(true);
                        ProductListToAddPostActivity.this.editText.setHint(LocaleController.getString(R.string.add_products_to_post));
                    }
                }
            });
            this.currentAnimation.setDuration(150L);
            this.removingSpan = productSpan;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, "scaleX", 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, "scaleY", 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, "alpha", 1.0f, 0.0f));
            requestLayout();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProductSpan productSpan = (ProductSpan) view;
        if (productSpan.isDeleting()) {
            this.currentDeletingSpan = null;
            this.spansContainer.removeSpan(productSpan);
            updateHint();
            checkVisibleRows();
            return;
        }
        ProductSpan productSpan2 = this.currentDeletingSpan;
        if (productSpan2 != null) {
            productSpan2.cancelDeleteAnimation();
        }
        this.currentDeletingSpan = productSpan;
        productSpan.startDeleteAnimation();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.searching = false;
        this.searchWas = false;
        this.allSpans.clear();
        this.selectedContacts.clear();
        this.currentDeletingSpan = null;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString(R.string.shop_select_product));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ProductListToAddPostActivity.this.finishFragment();
                } else if (i == 1) {
                    ProductListToAddPostActivity.this.onDonePressed();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        this.doneButton.addView(contextProgressView, LayoutHelper.createFrame(-1, -1));
        this.progressView.setVisibility(4);
        this.doneButton.setScaleX(0.0f);
        this.doneButton.setScaleY(0.0f);
        this.doneButton.setAlpha(0.0f);
        ViewGroup viewGroup = new ViewGroup(context) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.2
            @Override // android.view.View
            protected void onMeasure(int i, int i2) {
                int iDp;
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                setMeasuredDimension(size, size2);
                if (AndroidUtilities.isTablet() || size2 > size) {
                    iDp = AndroidUtilities.dp(144.0f);
                } else {
                    iDp = AndroidUtilities.dp(56.0f);
                }
                ProductListToAddPostActivity.this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
                ProductListToAddPostActivity.this.listView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - ProductListToAddPostActivity.this.scrollView.getMeasuredHeight(), 1073741824));
                ProductListToAddPostActivity.this.emptyView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - ProductListToAddPostActivity.this.scrollView.getMeasuredHeight(), 1073741824));
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                ProductListToAddPostActivity.this.scrollView.layout(0, 0, ProductListToAddPostActivity.this.scrollView.getMeasuredWidth(), ProductListToAddPostActivity.this.scrollView.getMeasuredHeight());
                ProductListToAddPostActivity.this.listView.layout(0, ProductListToAddPostActivity.this.scrollView.getMeasuredHeight(), ProductListToAddPostActivity.this.listView.getMeasuredWidth(), ProductListToAddPostActivity.this.scrollView.getMeasuredHeight() + ProductListToAddPostActivity.this.listView.getMeasuredHeight());
                ProductListToAddPostActivity.this.emptyView.layout(0, ProductListToAddPostActivity.this.scrollView.getMeasuredHeight(), ProductListToAddPostActivity.this.emptyView.getMeasuredWidth(), ProductListToAddPostActivity.this.scrollView.getMeasuredHeight() + ProductListToAddPostActivity.this.emptyView.getMeasuredHeight());
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean zDrawChild = super.drawChild(canvas, view, j);
                if (view == ProductListToAddPostActivity.this.listView || view == ProductListToAddPostActivity.this.emptyView) {
                    ((BaseFragment) ProductListToAddPostActivity.this).parentLayout.drawHeaderShadow(canvas, ProductListToAddPostActivity.this.scrollView.getMeasuredHeight());
                }
                return zDrawChild;
            }
        };
        this.fragmentView = viewGroup;
        ViewGroup viewGroup2 = viewGroup;
        ScrollView scrollView = new ScrollView(context) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.3
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                if (ProductListToAddPostActivity.this.ignoreScrollEvent) {
                    ProductListToAddPostActivity.this.ignoreScrollEvent = false;
                    return false;
                }
                rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
                rect.top += ProductListToAddPostActivity.this.fieldY + AndroidUtilities.dp(20.0f);
                rect.bottom += ProductListToAddPostActivity.this.fieldY + AndroidUtilities.dp(50.0f);
                return super.requestChildRectangleOnScreen(view, rect, z);
            }
        };
        this.scrollView = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        viewGroup2.addView(this.scrollView);
        SpansContainer spansContainer = new SpansContainer(context);
        this.spansContainer = spansContainer;
        this.scrollView.addView(spansContainer, LayoutHelper.createFrame(-1, -2));
        this.spansContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ProductListToAddPostActivity.this.editText.requestFocus();
                AndroidUtilities.showKeyboard(ProductListToAddPostActivity.this.editText);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.5
            @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (ProductListToAddPostActivity.this.currentDeletingSpan != null) {
                    ProductListToAddPostActivity.this.currentDeletingSpan.cancelDeleteAnimation();
                    ProductListToAddPostActivity.this.currentDeletingSpan = null;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.editText.setHintColor(Theme.getColor(Theme.key_groupcreate_hintText));
        this.editText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.editText.setCursorColor(Theme.getColor(Theme.key_groupcreate_cursor));
        this.editText.setCursorWidth(1.5f);
        this.editText.setInputType(655536);
        this.editText.setSingleLine(true);
        this.editText.setBackgroundDrawable(null);
        this.editText.setVerticalScrollBarEnabled(false);
        this.editText.setHorizontalScrollBarEnabled(false);
        this.editText.setTextIsSelectable(false);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setImeOptions(268435462);
        this.editText.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.spansContainer.addView(this.editText);
        this.editText.setHint(LocaleController.getString(R.string.add_products_to_post));
        this.editText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.6
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return i == 6 && ProductListToAddPostActivity.this.onDonePressed();
            }
        });
        this.editText.setOnKeyListener(new View.OnKeyListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.8
            private boolean wasEmpty;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67) {
                    if (keyEvent.getAction() == 0) {
                        this.wasEmpty = ProductListToAddPostActivity.this.editText.length() == 0;
                    } else if (keyEvent.getAction() == 1 && this.wasEmpty && !ProductListToAddPostActivity.this.allSpans.isEmpty()) {
                        ProductListToAddPostActivity.this.spansContainer.removeSpan((ProductSpan) ProductListToAddPostActivity.this.allSpans.get(ProductListToAddPostActivity.this.allSpans.size() - 1));
                        ProductListToAddPostActivity.this.updateHint();
                        ProductListToAddPostActivity.this.checkVisibleRows();
                        return true;
                    }
                }
                return false;
            }
        });
        this.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ProductListToAddPostActivity.this.editText.length() != 0) {
                    ProductListToAddPostActivity.this.searching = true;
                    ProductListToAddPostActivity.this.searchWas = true;
                    ProductListToAddPostActivity.this.adapter.setSearching(true);
                    ProductListToAddPostActivity.this.itemDecoration.setSearching(true);
                    ProductListToAddPostActivity.this.adapter.searchDialogs(ProductListToAddPostActivity.this.editText.getText().toString());
                    ProductListToAddPostActivity.this.listView.setFastScrollVisible(false);
                    ProductListToAddPostActivity.this.listView.setVerticalScrollBarEnabled(true);
                    ProductListToAddPostActivity.this.emptyView.setText(LocaleController.getString(R.string.nothing_found_result));
                    return;
                }
                ProductListToAddPostActivity.this.closeSearch();
            }
        });
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showTextView();
        this.emptyView.setShowAtCenter(true);
        this.emptyView.setText(LocaleController.getString(R.string.no_product_exists));
        viewGroup2.addView(this.emptyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFastScrollEnabled();
        this.listView.setEmptyView(this.emptyView);
        ArrayList<ShopModels.ProductSummaryObject> arrayList = new ArrayList<>();
        this.products = arrayList;
        RecyclerListView recyclerListView2 = this.listView;
        GroupCreateAdapter groupCreateAdapter = new GroupCreateAdapter(context, arrayList);
        this.adapter = groupCreateAdapter;
        recyclerListView2.setAdapter(groupCreateAdapter);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        RecyclerListView recyclerListView3 = this.listView;
        GroupCreateDividerItemDecoration groupCreateDividerItemDecoration = new GroupCreateDividerItemDecoration();
        this.itemDecoration = groupCreateDividerItemDecoration;
        recyclerListView3.addItemDecoration(groupCreateDividerItemDecoration);
        viewGroup2.addView(this.listView);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.10
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(ProductListToAddPostActivity.this.editText);
                }
            }
        });
        updateHint();
        callGetItems();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        ProductCell productCell;
        ShopModels.ProductSummaryObject item;
        if ((view instanceof ProductCell) && (item = (productCell = (ProductCell) view).getItem()) != null) {
            boolean zContainsKey = this.selectedContacts.containsKey(item.id);
            if (zContainsKey) {
                this.spansContainer.removeSpan(this.selectedContacts.get(item.id));
            } else {
                addToSelected(item);
            }
            updateHint();
            if (this.searching || this.searchWas) {
                AndroidUtilities.showKeyboard(this.editText);
            } else {
                productCell.setChecked(!zContainsKey);
            }
            if (this.editText.length() > 0) {
                this.editText.setText((CharSequence) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToSelected(ShopModels.ProductSummaryObject productSummaryObject) {
        if (this.maxCount == 0 || this.selectedContacts.size() != this.maxCount) {
            ProductSpan productSpan = new ProductSpan(this.editText.getContext(), productSummaryObject);
            this.spansContainer.addSpan(productSpan);
            productSpan.startDeleteAnimation();
            productSpan.setOnClickListener(this);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        EditTextBoldCursor editTextBoldCursor = this.editText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
        }
    }

    @Keep
    public void setContainerHeight(int i) {
        this.containerHeight = i;
        SpansContainer spansContainer = this.spansContainer;
        if (spansContainer != null) {
            spansContainer.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVisibleRows() {
        ProductCell productCell;
        ShopModels.ProductSummaryObject item;
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if ((childAt instanceof ProductCell) && (item = (productCell = (ProductCell) childAt).getItem()) != null) {
                productCell.setChecked(this.selectedContacts.containsKey(item.id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDonePressed() {
        callSetPost();
        return true;
    }

    private void callSetPost() {
        showEditDoneProgress(true);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.selectedContacts.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.size() == 0) {
            return;
        }
        DisposableObserver disposableObserver = this.requestDisposableAddChannel;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = this.requestDisposableGetItems;
        if (disposableObserver2 != null) {
            disposableObserver2.dispose();
        }
        DisposableObserver disposableObserver3 = (DisposableObserver) getRubinoController().setPostProducts(this.postId, arrayList).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.SetPostProductsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.SetPostProductsOutput> messangerOutput) {
                ProductListToAddPostActivity.this.showEditDoneProgress(false);
                ProductListToAddPostActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoPostEdited, ProductListToAddPostActivity.this.postId);
                ProductListToAddPostActivity.this.finishFragment();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ProductListToAddPostActivity.this.showEditDoneProgress(false);
                ProductListToAddPostActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoPostEditedFailed, ProductListToAddPostActivity.this.postId);
            }
        });
        this.requestDisposableAddChannel = disposableObserver3;
        this.compositeDisposable.add(disposableObserver3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSearch() {
        this.searching = false;
        this.searchWas = false;
        this.itemDecoration.setSearching(false);
        this.adapter.setSearching(false);
        this.adapter.searchDialogs(null);
        this.listView.setFastScrollVisible(true);
        this.listView.setVerticalScrollBarEnabled(false);
        this.emptyView.setText(LocaleController.getString(R.string.no_contact_exists));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHint() {
        if (this.selectedContacts.size() > 0) {
            this.actionBar.setSubtitle(LocaleController.getString(R.string.products).replace("$arg1", NumberUtils.toPersian(this.selectedContacts.size())));
        } else {
            this.actionBar.setSubtitle(BuildConfig.FLAVOR);
        }
        if (this.doneButtonVisible && this.allSpans.isEmpty()) {
            AnimatorSet animatorSet = this.currentDoneButtonAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentDoneButtonAnimation = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.doneButton, "scaleX", 0.0f), ObjectAnimator.ofFloat(this.doneButton, "scaleY", 0.0f), ObjectAnimator.ofFloat(this.doneButton, "alpha", 0.0f));
            this.currentDoneButtonAnimation.setDuration(180L);
            this.currentDoneButtonAnimation.start();
            this.doneButtonVisible = false;
            return;
        }
        if (this.doneButtonVisible || this.allSpans.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet3 = this.currentDoneButtonAnimation;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.currentDoneButtonAnimation = animatorSet4;
        animatorSet4.playTogether(ObjectAnimator.ofFloat(this.doneButton, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneButton, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneButton, "alpha", 1.0f));
        this.currentDoneButtonAnimation.setDuration(180L);
        this.currentDoneButtonAnimation.start();
        this.doneButtonVisible = true;
    }

    public class GroupCreateAdapter extends RecyclerListView.FastScrollAdapter {
        private ArrayList<ShopModels.ProductSummaryObject> contacts;
        private Context context;
        private ArrayList<ShopModels.ProductSummaryObject> searchResult = new ArrayList<>();
        private Timer searchTimer;
        private boolean searching;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public GroupCreateAdapter(Context context, ArrayList<ShopModels.ProductSummaryObject> arrayList) {
            this.contacts = new ArrayList<>();
            this.context = context;
            this.contacts = arrayList;
        }

        public void setSearching(boolean z) {
            if (this.searching == z) {
                return;
            }
            this.searching = z;
            notifyDataSetChanged();
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            ShopModels.ProductSummaryObject productSummaryObject;
            if (i < 0 || i >= this.contacts.size() || (productSummaryObject = this.contacts.get(i)) == null) {
                return null;
            }
            return !TextUtils.isEmpty(productSummaryObject.product_name) ? productSummaryObject.product_name.substring(0, 1).toUpperCase() : BuildConfig.FLAVOR;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.searching) {
                return this.searchResult.size();
            }
            return this.contacts.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View groupCreateSectionCell;
            if (i == 0) {
                groupCreateSectionCell = new GroupCreateSectionCell(this.context);
            } else {
                groupCreateSectionCell = new ProductCell(this.context, true);
                groupCreateSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(groupCreateSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ShopModels.ProductSummaryObject productSummaryObject;
            if (viewHolder.getItemViewType() == 0) {
                GroupCreateSectionCell groupCreateSectionCell = (GroupCreateSectionCell) viewHolder.itemView;
                if (this.searching) {
                    groupCreateSectionCell.setText("جستجو");
                    return;
                }
                return;
            }
            ProductCell productCell = (ProductCell) viewHolder.itemView;
            if (this.searching) {
                int size = this.searchResult.size();
                if (i >= 0 && i < size) {
                    productSummaryObject = this.searchResult.get(i);
                } else {
                    productSummaryObject = (i <= size || i > size) ? null : this.searchResult.get((i - size) - 1);
                }
            } else {
                productSummaryObject = this.contacts.get(i);
            }
            productCell.setItem(productSummaryObject, true);
            productCell.setChecked(ProductListToAddPostActivity.this.selectedContacts.containsKey(productSummaryObject.id));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (this.searching && i == this.searchResult.size()) ? 0 : 1;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float f) {
            return (int) (getItemCount() * f);
        }

        public void searchDialogs(String str) {
            try {
                Timer timer = this.searchTimer;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (str == null) {
                this.searchResult.clear();
                notifyDataSetChanged();
            } else {
                Timer timer2 = new Timer();
                this.searchTimer = timer2;
                timer2.schedule(new AnonymousClass1(str), 200L, 300L);
            }
        }

        /* renamed from: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity$GroupCreateAdapter$1, reason: invalid class name */
        class AnonymousClass1 extends TimerTask {
            final /* synthetic */ String val$query;

            AnonymousClass1(String str) {
                this.val$query = str;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    GroupCreateAdapter.this.searchTimer.cancel();
                    GroupCreateAdapter.this.searchTimer = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
                final String str = this.val$query;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity$GroupCreateAdapter$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(String str) {
                ProductListToAddPostActivity.this.callGetItems(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSearchResults(final ArrayList<ShopModels.ProductSummaryObject> arrayList, final boolean z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity$GroupCreateAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$0(z, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$0(boolean z, ArrayList arrayList) {
            if (z) {
                this.searchResult.clear();
            }
            this.searchResult.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private void callGetItems() {
        callGetItems(false, BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetItems(String str) {
        callGetItems(true, str);
    }

    private void callGetItems(final boolean z, String str) {
        DisposableObserver disposableObserver = this.requestDisposableGetItems;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        GetProductsInput getProductsInput = new GetProductsInput();
        getProductsInput.store_id = this.storeID;
        getProductsInput.start_id = z ? this.startIdSearch : this.startId;
        if (z) {
            getProductsInput.search_text = str;
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getProducts(getProductsInput).subscribeWith(new DisposableObserver<MessangerOutput<GetProductsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.12
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetProductsOutput> messangerOutput) {
                GetProductsOutput getProductsOutput = messangerOutput.data;
                if (getProductsOutput != null) {
                    if (z) {
                        if (getProductsOutput.products != null) {
                            ProductListToAddPostActivity.this.adapter.updateSearchResults(messangerOutput.data.products, ProductListToAddPostActivity.this.startIdSearch == null || ProductListToAddPostActivity.this.startIdSearch.isEmpty());
                        }
                        ProductListToAddPostActivity.this.startIdSearch = messangerOutput.data.next_start_id;
                        ProductListToAddPostActivity.this.hasContinueSearch = messangerOutput.data.has_continue;
                    } else {
                        if (getProductsOutput.products != null) {
                            if (ProductListToAddPostActivity.this.startId == null || ProductListToAddPostActivity.this.startId.isEmpty()) {
                                ProductListToAddPostActivity.this.products.clear();
                            }
                            if (ProductListToAddPostActivity.this.postProductIds != null && ProductListToAddPostActivity.this.postProductIds.size() > 0) {
                                Iterator<ShopModels.ProductSummaryObject> it = messangerOutput.data.products.iterator();
                                while (it.hasNext()) {
                                    ShopModels.ProductSummaryObject next = it.next();
                                    if (ProductListToAddPostActivity.this.postProductIds.contains(next.id)) {
                                        ProductListToAddPostActivity.this.addToSelected(next);
                                    }
                                }
                            }
                            ProductListToAddPostActivity.this.products.addAll(messangerOutput.data.products);
                        }
                        ProductListToAddPostActivity.this.startId = messangerOutput.data.next_start_id;
                        ProductListToAddPostActivity.this.hasContinue = messangerOutput.data.has_continue;
                    }
                }
                ProductListToAddPostActivity.this.adapter.notifyDataSetChanged();
            }
        });
        this.requestDisposableGetItems = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean z) {
        if (this.doneButton == null) {
            return;
        }
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.doneItemAnimation = new AnimatorSet();
        if (z) {
            this.progressView.setVisibility(0);
            this.doneButton.setEnabled(false);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneButton.getImageView(), "scaleX", 0.1f), ObjectAnimator.ofFloat(this.doneButton.getImageView(), "scaleY", 0.1f), ObjectAnimator.ofFloat(this.doneButton.getImageView(), "alpha", 0.0f), ObjectAnimator.ofFloat(this.progressView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.progressView, "alpha", 1.0f));
        } else {
            this.doneButton.getImageView().setVisibility(0);
            this.doneButton.setEnabled(true);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.progressView, "alpha", 0.0f), ObjectAnimator.ofFloat(this.doneButton.getImageView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneButton.getImageView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneButton.getImageView(), "alpha", 1.0f));
        }
        this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ProductListToAddPostActivity.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ProductListToAddPostActivity.this.doneItemAnimation == null || !ProductListToAddPostActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    ProductListToAddPostActivity.this.progressView.setVisibility(4);
                } else {
                    ProductListToAddPostActivity.this.doneButton.getImageView().setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ProductListToAddPostActivity.this.doneItemAnimation == null || !ProductListToAddPostActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                ProductListToAddPostActivity.this.doneItemAnimation = null;
            }
        });
        this.doneItemAnimation.setDuration(150L);
        this.doneItemAnimation.start();
    }
}
