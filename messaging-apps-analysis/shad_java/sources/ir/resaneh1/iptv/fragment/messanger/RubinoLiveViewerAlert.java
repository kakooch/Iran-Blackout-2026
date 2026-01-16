package ir.resaneh1.iptv.fragment.messanger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.model.StickerSetObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.ProfileOrHashtagCell;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PickerBottomLayout;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.URLSpanNoUnderline;

/* loaded from: classes3.dex */
public class RubinoLiveViewerAlert extends BottomSheet {
    private GridAdapter adapter;
    private ImageView closeButton;
    public CompositeDisposable compositeDisposable;
    int currentAccount;
    private FrameLayout emptyView;
    private RecyclerListView gridView;
    private boolean hasContinue;
    private boolean ignoreLayout;
    private int itemSize;
    private GridLayoutManager layoutManager;
    private OnItemClicked listener;
    private String liveId;
    private DisposableObserver loadItemObserver;
    private PickerBottomLayout pickerBottomLayout;
    private ImageView previewFavButton;
    private TextView previewSendButton;
    private View previewSendButtonShadow;
    private ArrayList<RubinoProfileObject> profileObjects;
    private int scrollOffsetY;
    private View[] shadow;
    private AnimatorSet[] shadowAnimation;
    private Drawable shadowDrawable;
    private String startId;
    private TextView stickerEmojiTextView;
    private BackupImageView stickerImageView;
    private FrameLayout stickerPreviewLayout;
    private StickerSetObject stickerSet;
    private TextView titleTextView;
    private Pattern urlPattern;

    public interface OnItemClicked {
        void onclick(RubinoProfileObject rubinoProfileObject);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Selection.removeSelection(spannable);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public RubinoLiveViewerAlert(Context context, String str, OnItemClicked onItemClicked) {
        super(context, false);
        this.startId = null;
        this.hasContinue = true;
        this.currentAccount = UserConfig.selectedAccount;
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.profileObjects = new ArrayList<>();
        this.compositeDisposable = new CompositeDisposable();
        this.liveId = str;
        this.listener = onItemClicked;
        init(context);
    }

    private void init(Context context) {
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow).mutate();
        this.shadowDrawable = drawableMutate;
        int i = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.1
            private int lastNotifyWidth;

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && RubinoLiveViewerAlert.this.scrollOffsetY != 0 && motionEvent.getY() < RubinoLiveViewerAlert.this.scrollOffsetY) {
                    RubinoLiveViewerAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !RubinoLiveViewerAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i3);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                getMeasuredWidth();
                RubinoLiveViewerAlert.this.itemSize = (View.MeasureSpec.getSize(i2) - AndroidUtilities.dp(36.0f)) / 5;
                int iDp = AndroidUtilities.dp(96.0f) + (Math.max(3, RubinoLiveViewerAlert.this.stickerSet != null ? (int) Math.ceil(RubinoLiveViewerAlert.this.stickerSet.top_stickers.size() / 5.0f) : 0) * AndroidUtilities.dp(82.0f)) + ((BottomSheet) RubinoLiveViewerAlert.this).backgroundPaddingTop;
                double d = iDp;
                int i4 = size / 5;
                double d2 = i4;
                Double.isNaN(d2);
                int i5 = d < d2 * 3.2d ? 0 : i4 * 2;
                if (i5 != 0 && iDp < size) {
                    i5 -= size - iDp;
                }
                if (i5 == 0) {
                    i5 = ((BottomSheet) RubinoLiveViewerAlert.this).backgroundPaddingTop;
                }
                if (RubinoLiveViewerAlert.this.gridView.getPaddingTop() != i5) {
                    RubinoLiveViewerAlert.this.ignoreLayout = true;
                    RubinoLiveViewerAlert.this.gridView.setPadding(AndroidUtilities.dp(10.0f), i5, AndroidUtilities.dp(10.0f), 0);
                    RubinoLiveViewerAlert.this.emptyView.setPadding(0, i5, 0, 0);
                    RubinoLiveViewerAlert.this.ignoreLayout = false;
                }
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                int i6 = i4 - i2;
                if (this.lastNotifyWidth != i6) {
                    this.lastNotifyWidth = i6;
                }
                super.onLayout(z, i2, i3, i4, i5);
                RubinoLiveViewerAlert.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (RubinoLiveViewerAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                RubinoLiveViewerAlert.this.shadowDrawable.setBounds(0, RubinoLiveViewerAlert.this.scrollOffsetY - ((BottomSheet) RubinoLiveViewerAlert.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                RubinoLiveViewerAlert.this.shadowDrawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i2 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i2, 0, i2, 0);
        this.shadow[0] = new View(context);
        this.shadow[0].setBackgroundResource(R.drawable.header_shadow);
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setVisibility(4);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], LayoutHelper.createFrame(-1, 3.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.2
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (RubinoLiveViewerAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.gridView = recyclerListView;
        recyclerListView.setTag(14);
        RecyclerListView recyclerListView2 = this.gridView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                return 1;
            }
        });
        RecyclerListView recyclerListView3 = this.gridView;
        GridAdapter gridAdapter = new GridAdapter(context);
        this.adapter = gridAdapter;
        recyclerListView3.setAdapter(gridAdapter);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.4
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
            }
        });
        this.gridView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        this.gridView.setClipToPadding(false);
        this.gridView.setEnabled(true);
        this.gridView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                RubinoLiveViewerAlert.this.updateLayout();
            }
        });
        new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.6
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i3) {
                try {
                    RubinoLiveViewerAlert.this.listener.onclick((RubinoProfileObject) RubinoLiveViewerAlert.this.profileObjects.get(i3));
                } catch (Exception unused) {
                }
            }
        };
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 0.0f));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.7
            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (RubinoLiveViewerAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.emptyView = frameLayout2;
        this.containerView.addView(frameLayout2, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.gridView.setEmptyView(this.emptyView);
        this.emptyView.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setMaxLines(1);
        this.titleTextView.setText(LocaleController.getString(R.string.viewers));
        this.titleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.titleTextView.setTextSize(1, 16.0f);
        this.titleTextView.setLinkTextColor(Theme.getColor(Theme.key_dialogTextLink));
        this.titleTextView.setHighlightColor(Theme.getColor(Theme.key_dialogLinkSelection));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(17);
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.containerView.addView(this.titleTextView, LayoutHelper.createLinear(-1, 48));
        this.emptyView.addView(new RadialProgressView(context), LayoutHelper.createFrame(-2, -2, 17));
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundResource(R.drawable.header_shadow_reverse);
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(context, false);
        this.pickerBottomLayout = pickerBottomLayout;
        pickerBottomLayout.setBackgroundColor(Theme.getColor(i));
        this.pickerBottomLayout.cancelButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        TextView textView2 = this.pickerBottomLayout.cancelButton;
        int i3 = Theme.key_dialogTextBlue2;
        textView2.setTextColor(Theme.getColor(i3));
        this.pickerBottomLayout.cancelButton.setText(LocaleController.getString("Close", R.string.Close).toUpperCase());
        this.pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoLiveViewerAlert.this.dismiss();
            }
        });
        this.pickerBottomLayout.doneButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.pickerBottomLayout.doneButtonBadgeTextView.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(12.5f), Color.parseColor("#ff3ec1f9")));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.stickerPreviewLayout = frameLayout3;
        frameLayout3.setBackgroundColor(Theme.getColor(i) & (-536870913));
        this.stickerPreviewLayout.setVisibility(8);
        this.stickerPreviewLayout.setSoundEffectsEnabled(false);
        this.containerView.addView(this.stickerPreviewLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.stickerPreviewLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoLiveViewerAlert.this.hidePreview();
            }
        });
        ImageView imageView = new ImageView(context);
        this.closeButton = imageView;
        imageView.setImageResource(R.drawable.msg_panel_clear);
        this.closeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogTextGray3), PorterDuff.Mode.MULTIPLY));
        this.closeButton.setScaleType(ImageView.ScaleType.CENTER);
        this.containerView.addView(this.closeButton, LayoutHelper.createFrame(48, 48, 53));
        this.closeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoLiveViewerAlert.this.dismiss();
            }
        });
        BackupImageView backupImageView = new BackupImageView(context);
        this.stickerImageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.stickerPreviewLayout.addView(this.stickerImageView);
        TextView textView3 = new TextView(context);
        this.stickerEmojiTextView = textView3;
        textView3.setTextSize(1, 30.0f);
        this.stickerEmojiTextView.setGravity(85);
        this.stickerPreviewLayout.addView(this.stickerEmojiTextView);
        TextView textView4 = new TextView(context);
        this.previewSendButton = textView4;
        textView4.setTextSize(1, 14.0f);
        this.previewSendButton.setTextColor(Theme.getColor(i3));
        this.previewSendButton.setGravity(17);
        this.previewSendButton.setBackgroundColor(Theme.getColor(i));
        this.previewSendButton.setPadding(AndroidUtilities.dp(29.0f), 0, AndroidUtilities.dp(29.0f), 0);
        this.previewSendButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.stickerPreviewLayout.addView(this.previewSendButton, LayoutHelper.createFrame(-1, 48, 83));
        ImageView imageView2 = new ImageView(context);
        this.previewFavButton = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.previewFavButton.setImageResource(R.drawable.stickers_favorite);
        this.stickerPreviewLayout.addView(this.previewFavButton, LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 4.0f, 0.0f));
        this.previewFavButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogIcon), PorterDuff.Mode.MULTIPLY));
        View view = new View(context);
        this.previewSendButtonShadow = view;
        view.setBackgroundResource(R.drawable.header_shadow_reverse);
        this.stickerPreviewLayout.addView(this.previewSendButtonShadow, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        updateFields();
        updateSendButton();
        callGetViewers();
        this.adapter.notifyDataSetChanged();
    }

    private void updateSendButton() {
        Point point = AndroidUtilities.displaySize;
        int iMin = Math.min(point.x, point.y) / 2;
        float f = AndroidUtilities.density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private void updateFields() {
        if (this.titleTextView == null) {
            return;
        }
        AnonymousClass1 anonymousClass1 = null;
        anonymousClass1 = null;
        if (this.stickerSet != null) {
            try {
                if (this.urlPattern == null) {
                    this.urlPattern = Pattern.compile("@[a-zA-Z\\d_]{1,32}");
                    this.titleTextView.setMovementMethod(new LinkMovementMethodMy());
                }
                Matcher matcher = this.urlPattern.matcher(this.stickerSet.title);
                while (true) {
                    ?? spannableStringBuilder = anonymousClass1;
                    if (!matcher.find()) {
                        break;
                    }
                    if (anonymousClass1 == null) {
                        spannableStringBuilder = new SpannableStringBuilder(this.stickerSet.title);
                    }
                    int iStart = matcher.start();
                    int iEnd = matcher.end();
                    if (this.stickerSet.title.charAt(iStart) != '@') {
                        iStart++;
                    }
                    spannableStringBuilder.setSpan(new URLSpanNoUnderline(this.stickerSet.title.subSequence(iStart + 1, iEnd).toString()) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.12
                        @Override // org.rbmain.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                        public void onClick(View view) {
                            new MainClickHandler().onMessengerUsernameClicked(getURL());
                            RubinoLiveViewerAlert.this.dismiss();
                        }
                    }, iStart, iEnd, 0);
                    anonymousClass1 = spannableStringBuilder;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            ?? r0 = this.titleTextView;
            ?? r2 = anonymousClass1;
            if (anonymousClass1 == null) {
                r2 = this.stickerSet.title;
            }
            r0.setText(r2);
            this.titleTextView.requestLayout();
            this.titleTextView.invalidate();
            this.containerView.requestLayout();
            this.containerView.invalidate();
            this.adapter.notifyDataSetChanged();
            return;
        }
        setRightButton(null, null, Theme.getColor(Theme.key_text_RedBold), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.gridView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.gridView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.titleTextView.setTranslationY(this.scrollOffsetY);
            this.closeButton.setTranslationY(this.scrollOffsetY);
            this.shadow[0].setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(0, false);
        } else {
            runShadowAnimation(0, true);
            top = 0;
        }
        if (this.scrollOffsetY != top) {
            RecyclerListView recyclerListView2 = this.gridView;
            this.scrollOffsetY = top;
            recyclerListView2.setTopGlowOffset(top);
            this.titleTextView.setTranslationY(this.scrollOffsetY);
            this.closeButton.setTranslationY(this.scrollOffsetY);
            this.shadow[0].setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hidePreview() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.stickerPreviewLayout, "alpha", 0.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RubinoLiveViewerAlert.this.stickerPreviewLayout.setVisibility(8);
            }
        });
        animatorSet.start();
    }

    private void runShadowAnimation(final int i, final boolean z) {
        if ((!z || this.shadow[i].getTag() == null) && (z || this.shadow[i].getTag() != null)) {
            return;
        }
        this.shadow[i].setTag(z ? null : 1);
        if (z) {
            this.shadow[i].setVisibility(0);
        }
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[i] != null) {
            animatorSetArr[i].cancel();
        }
        this.shadowAnimation[i] = new AnimatorSet();
        AnimatorSet animatorSet = this.shadowAnimation[i];
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow[i];
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, "alpha", fArr);
        animatorSet.playTogether(animatorArr);
        this.shadowAnimation[i].setDuration(150L);
        this.shadowAnimation[i].addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.14
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (RubinoLiveViewerAlert.this.shadowAnimation[i] == null || !RubinoLiveViewerAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                if (!z) {
                    RubinoLiveViewerAlert.this.shadow[i].setVisibility(4);
                }
                RubinoLiveViewerAlert.this.shadowAnimation[i] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (RubinoLiveViewerAlert.this.shadowAnimation[i] == null || !RubinoLiveViewerAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                RubinoLiveViewerAlert.this.shadowAnimation[i] = null;
            }
        });
        this.shadowAnimation[i].start();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.compositeDisposable.dispose();
    }

    private void setRightButton(View.OnClickListener onClickListener, String str, int i, boolean z) {
        if (str == null) {
            this.pickerBottomLayout.doneButton.setVisibility(8);
            return;
        }
        this.pickerBottomLayout.doneButton.setVisibility(0);
        if (z) {
            this.pickerBottomLayout.doneButtonBadgeTextView.setVisibility(0);
            this.pickerBottomLayout.doneButtonBadgeTextView.setText(NumberUtils.toPersian(this.stickerSet.count_stickers));
        } else {
            this.pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        }
        this.pickerBottomLayout.doneButtonTextView.setTextColor(i);
        this.pickerBottomLayout.doneButtonTextView.setText(str.toUpperCase());
        this.pickerBottomLayout.doneButton.setOnClickListener(onClickListener);
    }

    private class GridAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int totalItems;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public GridAdapter(Context context) {
            new SparseArray();
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalItems;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i >= RubinoLiveViewerAlert.this.profileObjects.size() ? 1 : 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LoadingCell loadingCell = null;
            if (i == 0) {
                ProfileOrHashtagCell profileOrHashtagCell = new ProfileOrHashtagCell(RubinoLiveViewerAlert.this.getContext(), false, false);
                if (Build.VERSION.SDK_INT >= 23) {
                    profileOrHashtagCell.container.setForeground(null);
                }
                profileOrHashtagCell.controllClick = false;
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                loadingCell = profileOrHashtagCell;
            } else if (i == 1) {
                loadingCell = new LoadingCell(this.context);
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i == getItemCount() - 1 && RubinoLiveViewerAlert.this.hasContinue) {
                RubinoLiveViewerAlert.this.callGetViewers();
            }
            if (viewHolder.getItemViewType() != 0) {
                return;
            }
            RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) RubinoLiveViewerAlert.this.profileObjects.get(i);
            if (rubinoProfileObject.usernameSpannableString == null) {
                rubinoProfileObject.createUsernameSpan();
            }
            ((ProfileOrHashtagCell) viewHolder.itemView).setProfile(rubinoProfileObject, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            int size = RubinoLiveViewerAlert.this.profileObjects != null ? RubinoLiveViewerAlert.this.profileObjects.size() : 0;
            this.totalItems = size;
            if (size > 0 && RubinoLiveViewerAlert.this.hasContinue) {
                this.totalItems++;
            }
            super.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetViewers() {
        if (this.hasContinue) {
            DisposableObserver disposableObserver = this.loadItemObserver;
            if (disposableObserver == null || disposableObserver.isDisposed()) {
                LiveModels.RubinoGetLiveViewersInput rubinoGetLiveViewersInput = new LiveModels.RubinoGetLiveViewersInput();
                rubinoGetLiveViewersInput.live_id = this.liveId;
                rubinoGetLiveViewersInput.start_id = this.startId;
                rubinoGetLiveViewersInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
                DisposableObserver disposableObserver2 = (DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).rubinoGetLiveViewers(rubinoGetLiveViewersInput).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoGetLiveViewersOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.15
                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<LiveModels.RubinoGetLiveViewersOutput> messangerOutput) {
                        RubinoLiveViewerAlert.this.profileObjects.addAll(messangerOutput.data.profiles);
                        RubinoLiveViewerAlert.this.startId = messangerOutput.data.next_start_id;
                        RubinoLiveViewerAlert.this.hasContinue = messangerOutput.data.has_continue;
                        RubinoLiveViewerAlert.this.adapter.notifyDataSetChanged();
                        RubinoLiveViewerAlert.this.emptyView.setVisibility(4);
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        if (RubinoLiveViewerAlert.this.loadItemObserver != null) {
                            RubinoLiveViewerAlert.this.loadItemObserver.dispose();
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onComplete() {
                        if (RubinoLiveViewerAlert.this.loadItemObserver != null) {
                            RubinoLiveViewerAlert.this.loadItemObserver.dispose();
                        }
                    }
                });
                this.loadItemObserver = disposableObserver2;
                this.compositeDisposable.add(disposableObserver2);
                this.adapter.notifyDataSetChanged();
            }
        }
    }
}
