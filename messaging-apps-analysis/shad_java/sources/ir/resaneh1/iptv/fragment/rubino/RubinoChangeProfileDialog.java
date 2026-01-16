package ir.resaneh1.iptv.fragment.rubino;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.InstaAddPageFragment;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoChangeProfileDialog extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private static final int CELL_HEIGHT = AndroidUtilities.dp(72.0f);
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    private CompositeDisposable compositeDisposable;
    private Context context;
    int currentAccount;
    private float gradientWidth;
    public Adapter listAdapter;
    private RecyclerListView listView;
    private boolean loadingResults;
    private View.OnClickListener onProfileClick;
    private LinearGradient placeholderGradient;
    private Matrix placeholderMatrix;
    private Paint placeholderPaint;
    Comparator profileComparator;
    private ArrayList<RubinoProfileObject> profiles;
    private int scrollOffsetY;
    private Drawable shadowDrawable;
    private String title;
    private TextView titleTextView;
    private float totalTranslation;

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    static /* synthetic */ float access$2216(RubinoChangeProfileDialog rubinoChangeProfileDialog, float f) {
        float f2 = rubinoChangeProfileDialog.totalTranslation + f;
        rubinoChangeProfileDialog.totalTranslation = f2;
        return f2;
    }

    static /* synthetic */ float access$2224(RubinoChangeProfileDialog rubinoChangeProfileDialog, float f) {
        float f2 = rubinoChangeProfileDialog.totalTranslation - f;
        rubinoChangeProfileDialog.totalTranslation = f2;
        return f2;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.rubinoMyProfileListUpdated) {
            this.profiles.clear();
            this.profiles.addAll(AppRubinoPreferences.getInstance(this.currentAccount).getProfilesOutput2().profiles);
            Collections.sort(this.profiles, this.profileComparator);
            this.listAdapter.notifyDataSetChanged();
        }
    }

    public class ProfileCell extends FrameLayout {
        private ArrayList<Animator> animators;
        private RubinoProfileObject currentProfile;
        private ImageView imageView;
        private ImageView imageViewRadioButton;
        public boolean isAddProfile;
        private boolean needDivider;
        private String text;
        private TextView textView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public ProfileCell(Context context) {
            super(context);
            AndroidUtilities.dp(0.6f);
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_in_change_profile_row, (ViewGroup) null, false);
            setWillNotDraw(false);
            addView(viewInflate);
            this.textView = (TextView) viewInflate.findViewById(R.id.textView);
            this.imageView = (ImageView) viewInflate.findViewById(R.id.imageViewUser);
            ((GradientDrawable) viewInflate.findViewById(R.id.borderCircle).getBackground()).setStroke(AndroidUtilities.dp(0.6f), Theme.getColor(Theme.key_rubinoFollowingBorderColor));
            this.imageViewRadioButton = (ImageView) viewInflate.findViewById(R.id.imageViewRadioButton);
            this.textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            this.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        }

        public void setProfile(RubinoProfileObject rubinoProfileObject, boolean z) {
            this.currentProfile = rubinoProfileObject;
            this.isAddProfile = false;
            this.needDivider = z;
            this.imageViewRadioButton.setVisibility(0);
            this.imageView.setPadding(0, 0, 0, 0);
            if (rubinoProfileObject == null) {
                this.textView.setText(BuildConfig.FLAVOR);
                this.imageView.setVisibility(8);
                this.imageViewRadioButton.setVisibility(8);
            } else {
                update(0);
            }
            ArrayList<Animator> arrayList = this.animators;
            if (arrayList != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.imageView, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.textView, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.imageViewRadioButton, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
            }
        }

        public void setAddProfile(boolean z) throws Resources.NotFoundException {
            this.isAddProfile = true;
            this.needDivider = z;
            this.textView.setText(LocaleController.getString(R.string.rubinoAddProfile));
            Drawable drawable = RubinoChangeProfileDialog.this.context.getResources().getDrawable(R.drawable.rubino_add_outline_24);
            this.imageView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
            this.imageView.setImageDrawable(drawable);
            this.imageView.setColorFilter(Theme.getColor(Theme.key_rubinoBlackColor));
            this.imageViewRadioButton.setVisibility(8);
            ArrayList<Animator> arrayList = this.animators;
            if (arrayList != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.imageView, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.textView, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.imageViewRadioButton, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(RubinoChangeProfileDialog.CELL_HEIGHT + (this.needDivider ? 1 : 0), 1073741824));
        }

        public void update(int i) {
            RubinoProfileObject rubinoProfileObject = this.currentProfile;
            if (rubinoProfileObject != null) {
                this.text = rubinoProfileObject.getUsername();
                if (this.currentProfile.hasThumbnail()) {
                    GlideHelper.loadCircle(RubinoChangeProfileDialog.this.context, this.imageView, this.currentProfile.full_thumbnail_url, R.drawable.rubino_grey_avatar_placeholder);
                } else {
                    this.imageView.setImageDrawable(getResources().getDrawable(R.drawable.placeholder_avatar_man));
                }
                if (this.currentProfile.isMyCurrentProfile()) {
                    this.imageViewRadioButton.setImageDrawable(RubinoChangeProfileDialog.this.context.getResources().getDrawable(R.drawable.rubino_radio_button_blue));
                } else {
                    this.imageViewRadioButton.setImageDrawable(RubinoChangeProfileDialog.this.context.getResources().getDrawable(R.drawable.rubino_radio_button_gray));
                }
            } else {
                this.text = BuildConfig.FLAVOR;
                this.imageView.setVisibility(4);
            }
            this.textView.setText(this.text);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(5.0f, 1.0f, getMeasuredWidth() - 5, 1.0f, Theme.dividerPaint);
            }
        }
    }

    public static RubinoChangeProfileDialog createRubinoDialogItems(Activity activity, ArrayList<RubinoProfileObject> arrayList) {
        if (activity == null) {
            return null;
        }
        return new RubinoChangeProfileDialog(activity, arrayList);
    }

    public RubinoChangeProfileDialog(final Activity activity, ArrayList<RubinoProfileObject> arrayList) {
        super(activity, true);
        this.currentAccount = UserConfig.selectedAccount;
        new ArrayList();
        this.placeholderPaint = new Paint(1);
        this.loadingResults = true;
        new RectF();
        this.compositeDisposable = new CompositeDisposable();
        this.onProfileClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof ProfileCell) {
                    ProfileCell profileCell = (ProfileCell) view;
                    if (!profileCell.isAddProfile) {
                        if (profileCell.currentProfile != null) {
                            new MainClickHandler().changeRubinoProfile(profileCell.currentProfile);
                        }
                    } else if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new InstaAddPageFragment());
                    }
                    RubinoChangeProfileDialog.this.dismiss();
                }
            }
        };
        this.profileComparator = new Comparator<RubinoProfileObject>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.9
            @Override // java.util.Comparator
            public int compare(RubinoProfileObject rubinoProfileObject, RubinoProfileObject rubinoProfileObject2) {
                if (rubinoProfileObject.isDefault()) {
                    return -1;
                }
                return rubinoProfileObject2.isDefault() ? 1 : 0;
            }
        };
        this.title = LocaleController.getString(R.string.rubinoChangeProfileDialogTitle);
        ArrayList<RubinoProfileObject> arrayList2 = new ArrayList<>();
        this.profiles = arrayList2;
        arrayList2.addAll(arrayList);
        Collections.sort(this.profiles, this.profileComparator);
        this.context = activity;
        RubinoController.getInstance(this.currentAccount).syncMyProfileListWithServer();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.rubinoMyProfileListUpdated);
        updatePlaceholder();
        Drawable drawableMutate = activity.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        int i = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.1
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i3);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size - getPaddingTop();
                ((FrameLayout.LayoutParams) RubinoChangeProfileDialog.this.listView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                ((FrameLayout.LayoutParams) RubinoChangeProfileDialog.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                int iDp = ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop + AndroidUtilities.dp(15.0f) + AndroidUtilities.statusBarHeight + (RubinoChangeProfileDialog.CELL_HEIGHT * RubinoChangeProfileDialog.this.listAdapter.getItemCount()) + AndroidUtilities.dp(16.0f);
                if (iDp >= paddingTop) {
                    iDp = (paddingTop / 5) * 3;
                }
                int iDp2 = (paddingTop - iDp) + AndroidUtilities.dp(8.0f);
                if (RubinoChangeProfileDialog.this.listView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    RubinoChangeProfileDialog.this.listView.setPinnedSectionOffsetY(-iDp2);
                    RubinoChangeProfileDialog.this.listView.setPadding(0, iDp2, 0, AndroidUtilities.dp(16.0f));
                    this.ignoreLayout = false;
                }
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                RubinoChangeProfileDialog.this.updateLayout(false);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && RubinoChangeProfileDialog.this.scrollOffsetY != 0 && motionEvent.getY() < RubinoChangeProfileDialog.this.scrollOffsetY + AndroidUtilities.dp(12.0f) && RubinoChangeProfileDialog.this.actionBar.getAlpha() == 0.0f) {
                    RubinoChangeProfileDialog.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !RubinoChangeProfileDialog.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int iDp = AndroidUtilities.dp(13.0f);
                int translationY = (int) (((RubinoChangeProfileDialog.this.scrollOffsetY - ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop) - iDp) + RubinoChangeProfileDialog.this.listView.getTranslationY());
                int iDp2 = AndroidUtilities.dp(20.0f) + translationY;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop;
                if (((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop + translationY < ActionBar.getCurrentActionBarHeight()) {
                    float fDp = iDp + AndroidUtilities.dp(4.0f);
                    float fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - translationY) - ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop) / fDp);
                    int currentActionBarHeight = (int) ((ActionBar.getCurrentActionBarHeight() - fDp) * fMin);
                    translationY -= currentActionBarHeight;
                    iDp2 -= currentActionBarHeight;
                    measuredHeight += currentActionBarHeight;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    int i2 = AndroidUtilities.statusBarHeight;
                    translationY += i2;
                    iDp2 += i2;
                }
                RubinoChangeProfileDialog.this.shadowDrawable.setBounds(0, translationY, getMeasuredWidth(), measuredHeight);
                RubinoChangeProfileDialog.this.shadowDrawable.draw(canvas);
                if (f != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(Theme.getColor(Theme.key_dialogBackground));
                    this.rect.set(((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop + translationY, getMeasuredWidth() - ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop + translationY + AndroidUtilities.dp(24.0f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                }
                if (f != 0.0f) {
                    int iDp3 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp3) / 2, iDp2, (getMeasuredWidth() + iDp3) / 2, iDp2 + AndroidUtilities.dp(4.0f));
                    int color = Theme.getColor(Theme.key_sheet_scrollUp);
                    int iAlpha = Color.alpha(color);
                    Theme.dialogs_onlineCirclePaint.setColor(color);
                    Theme.dialogs_onlineCirclePaint.setAlpha((int) (iAlpha * 1.0f * f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
                int color2 = Theme.getColor(Theme.key_dialogBackground);
                Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (RubinoChangeProfileDialog.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(color2) * 0.8f), (int) (Color.green(color2) * 0.8f), (int) (Color.blue(color2) * 0.8f)));
                canvas.drawRect(((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, Theme.dialogs_onlineCirclePaint);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i2 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i2, 0, i2, 0);
        RecyclerListView recyclerListView = new RecyclerListView(activity) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.2
            long lastUpdateTime;

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return true;
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (RubinoChangeProfileDialog.this.loadingResults) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long jAbs = Math.abs(this.lastUpdateTime - jElapsedRealtime);
                    if (jAbs > 17) {
                        jAbs = 16;
                    }
                    this.lastUpdateTime = jElapsedRealtime;
                    RubinoChangeProfileDialog rubinoChangeProfileDialog = RubinoChangeProfileDialog.this;
                    RubinoChangeProfileDialog.access$2216(rubinoChangeProfileDialog, (jAbs * rubinoChangeProfileDialog.gradientWidth) / 1800.0f);
                    while (RubinoChangeProfileDialog.this.totalTranslation >= RubinoChangeProfileDialog.this.gradientWidth * 2.0f) {
                        RubinoChangeProfileDialog rubinoChangeProfileDialog2 = RubinoChangeProfileDialog.this;
                        RubinoChangeProfileDialog.access$2224(rubinoChangeProfileDialog2, rubinoChangeProfileDialog2.gradientWidth * 2.0f);
                    }
                    RubinoChangeProfileDialog.this.placeholderMatrix.setTranslate(RubinoChangeProfileDialog.this.totalTranslation, 0.0f);
                    RubinoChangeProfileDialog.this.placeholderGradient.setLocalMatrix(RubinoChangeProfileDialog.this.placeholderMatrix);
                    invalidateViews();
                    invalidate();
                }
                super.dispatchDraw(canvas);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setSectionsType(2);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        RecyclerListView recyclerListView2 = this.listView;
        Adapter adapter = new Adapter(activity);
        this.listAdapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.listView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$new$0(activity, view, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                if (RubinoChangeProfileDialog.this.listView.getChildCount() <= 0) {
                    return;
                }
                RubinoChangeProfileDialog.this.updateLayout(true);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                if (i3 == 0) {
                    if (((RubinoChangeProfileDialog.this.scrollOffsetY - ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f)) + ((BottomSheet) RubinoChangeProfileDialog.this).backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || !RubinoChangeProfileDialog.this.listView.canScrollVertically(1)) {
                        return;
                    }
                    RubinoChangeProfileDialog.this.listView.getChildAt(0);
                    RecyclerListView.Holder holder = (RecyclerListView.Holder) RubinoChangeProfileDialog.this.listView.findViewHolderForAdapterPosition(0);
                    if (holder == null || holder.itemView.getTop() <= AndroidUtilities.dp(7.0f)) {
                        return;
                    }
                    RubinoChangeProfileDialog.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(7.0f));
                }
            }
        });
        TextView textView = new TextView(activity);
        this.titleTextView = textView;
        textView.setTextSize(1, 18.0f);
        this.titleTextView.setTypeface(Theme.getRubinoTypeFaceRegular(), 1);
        this.titleTextView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(21.0f));
        TextView textView2 = this.titleTextView;
        int i3 = Theme.key_dialogTextBlack;
        textView2.setTextColor(Theme.getColor(i3));
        this.titleTextView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        TextView textView3 = this.titleTextView;
        textView3.setText(Emoji.replaceEmoji(this.title, textView3.getPaint().getFontMetricsInt(), AndroidUtilities.dp(18.0f), false));
        ActionBar actionBar = new ActionBar(activity) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.4
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                ((BottomSheet) RubinoChangeProfileDialog.this).containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(Theme.getColor(i));
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setItemsColor(Theme.getColor(i3), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_dialogButtonSelector), false);
        this.actionBar.setTitleColor(Theme.getColor(i3));
        this.actionBar.setSubtitleColor(Theme.getColor(Theme.key_player_actionBarSubtitle));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        this.actionBar.setTitle(this.title);
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceMedium());
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.5
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i4) {
                if (i4 == -1) {
                    RubinoChangeProfileDialog.this.dismiss();
                }
            }
        });
        View view = new View(activity);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Activity activity, View view, int i) {
        if (activity == null) {
            return;
        }
        this.onProfileClick.onClick(view);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        this.compositeDisposable.dispose();
        super.dismissInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean z) {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder == null || holder.getAdapterPosition() != 0) {
            top = iDp;
        }
        boolean z2 = top <= AndroidUtilities.dp(12.0f);
        if ((z2 && this.actionBar.getTag() == null) || (!z2 && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z2 ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[2];
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z2 ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr);
            View view = this.actionBarShadow;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z2 ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    RubinoChangeProfileDialog.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        int iDp2 = top + (layoutParams.topMargin - AndroidUtilities.dp(11.0f));
        if (this.scrollOffsetY != iDp2) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = iDp2;
            recyclerListView2.setTopGlowOffset(iDp2 - layoutParams.topMargin);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaceholder() {
        if (this.placeholderPaint == null) {
            return;
        }
        int color = Theme.getColor(Theme.key_dialogBackground);
        int color2 = Theme.getColor(Theme.key_dialogBackgroundGray);
        int averageColor = AndroidUtilities.getAverageColor(color2, color);
        this.placeholderPaint.setColor(color2);
        float fDp = AndroidUtilities.dp(500.0f);
        this.gradientWidth = fDp;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, fDp, 0.0f, new int[]{color2, averageColor, color2}, new float[]{0.0f, 0.18f, 0.36f}, Shader.TileMode.REPEAT);
        this.placeholderGradient = linearGradient;
        this.placeholderPaint.setShader(linearGradient);
        Matrix matrix = new Matrix();
        this.placeholderMatrix = matrix;
        this.placeholderGradient.setLocalMatrix(matrix);
    }

    public class Adapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public Adapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.Holder(RubinoChangeProfileDialog.this.new ProfileCell(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoChangeProfileDialog.this.profiles.size() + (RubinoController.getInstance(RubinoChangeProfileDialog.this.currentAccount).hasPermissionAddProfile() ? 1 : 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 1) {
                ((ProfileCell) viewHolder.itemView).setAddProfile(false);
            } else {
                if (itemViewType != 2) {
                    return;
                }
                ((ProfileCell) viewHolder.itemView).setProfile((RubinoProfileObject) RubinoChangeProfileDialog.this.profiles.get(i), false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == RubinoChangeProfileDialog.this.profiles.size() ? 1 : 2;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updatePlaceholder();
            }
        };
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        ViewGroup viewGroup = this.containerView;
        Drawable[] drawableArr = {this.shadowDrawable};
        int i = Theme.key_dialogBackground;
        arrayList.add(new ThemeDescription(viewGroup, 0, null, null, drawableArr, null, i));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_AB_ITEMSCOLOR;
        int i3 = Theme.key_dialogTextBlack;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, Theme.key_player_actionBarSubtitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBarShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_dialogShadowLine));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_dialogBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        return arrayList;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onCustomOpenAnimation() {
        if (Build.VERSION.SDK_INT >= 20 && this.useHardwareLayer) {
            this.container.setLayerType(2, null);
        }
        this.containerView.setTranslationY(r0.getMeasuredHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, "translationY", 0.0f), ObjectAnimator.ofInt(this.backDrawable, "alpha", 51));
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(20L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoChangeProfileDialog.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation == null || !((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation.equals(animator)) {
                    return;
                }
                ((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation = null;
                if (((BottomSheet) RubinoChangeProfileDialog.this).delegate != null) {
                    ((BottomSheet) RubinoChangeProfileDialog.this).delegate.onOpenAnimationEnd();
                }
                if (((BottomSheet) RubinoChangeProfileDialog.this).useHardwareLayer) {
                    ((BottomSheet) RubinoChangeProfileDialog.this).container.setLayerType(0, null);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation == null || !((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation.equals(animator)) {
                    return;
                }
                ((BottomSheet) RubinoChangeProfileDialog.this).currentSheetAnimation = null;
            }
        });
        animatorSet.start();
        this.currentSheetAnimation = animatorSet;
        return true;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.rubinoMyProfileListUpdated);
    }
}
