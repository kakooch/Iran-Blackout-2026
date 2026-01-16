package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.ui.cells.HighlightCell;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.RubinoRetryView;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;

/* loaded from: classes3.dex */
public class HighlightBottomSheet extends BottomSheet {
    private final TextView bottomButton;
    private final CompositeDisposable compositeDisposable;
    private final LinearLayout contentLayout;
    private final int currentAccount;
    private int currentState;
    private HighlightsDelegate delegate;
    private boolean isLoading;
    private final HighlightsAdapter listAdapter;
    private final RecyclerListView listView;
    private final LoadingCell loadingCell;
    private final HighlightCell newHighlightCell;
    private final RubinoRetryView retryView;
    private final TextView titleTextView;

    public interface HighlightsDelegate {
        void onCreateNewHighlight(StoryObject storyObject, String str);

        void onHighlightSelected(Rubino.StoryHighlight storyHighlight);
    }

    public HighlightBottomSheet(int i, Context context, final StoryObject storyObject) {
        super(context, true);
        this.compositeDisposable = new CompositeDisposable();
        this.currentState = 1;
        this.currentAccount = i;
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet.1
            private boolean ignoreLayout;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) HighlightBottomSheet.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) HighlightBottomSheet.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                super.onMeasure(i2, i3);
            }

            @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                if (this.ignoreLayout) {
                    return;
                }
                super.onLayout(z, i2, i3, i4, i5);
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                int iDp = (-((BottomSheet) HighlightBottomSheet.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f);
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(150.0f) + ((BottomSheet) HighlightBottomSheet.this).backgroundPaddingTop;
                if (Build.VERSION.SDK_INT >= 21) {
                    int i2 = AndroidUtilities.statusBarHeight;
                    iDp += i2;
                    measuredHeight -= i2;
                }
                ((BottomSheet) HighlightBottomSheet.this).shadowDrawable.setBounds(0, iDp, getMeasuredWidth(), measuredHeight);
                ((BottomSheet) HighlightBottomSheet.this).shadowDrawable.draw(canvas);
            }
        };
        linearLayout.setOrientation(1);
        linearLayout.setWillNotDraw(false);
        int i2 = this.backgroundPaddingLeft;
        linearLayout.setPadding(i2, 0, i2, 0);
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextSize(17.0f);
        textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setGravity(17);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2, 8388611, 8.0f, 8.0f, 8.0f, 8.0f));
        View view = new View(context);
        view.setBackgroundResource(R.drawable.rubino_round_rect_2dp_grey);
        linearLayout.addView(view, LayoutHelper.createFrame(-1, 1, 8388611, 8.0f, 8.0f, 8.0f, 8.0f));
        RubinoRetryView rubinoRetryView = new RubinoRetryView(context);
        this.retryView = rubinoRetryView;
        rubinoRetryView.setData(R.drawable.ic_retry_grey);
        rubinoRetryView.setVisibility(8);
        rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        linearLayout.addView(rubinoRetryView, LayoutHelper.createFrame(-1, -2));
        LoadingCell loadingCell = new LoadingCell(context);
        this.loadingCell = loadingCell;
        loadingCell.setVisibility(8);
        linearLayout.addView(loadingCell, LayoutHelper.createFrame(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.contentLayout = linearLayout2;
        linearLayout2.setOrientation(1);
        linearLayout2.setVisibility(8);
        linearLayout.addView(linearLayout2, LayoutHelper.createFrame(-1, -2));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVisibility(8);
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        HighlightsAdapter highlightsAdapter = new HighlightsAdapter();
        this.listAdapter = highlightsAdapter;
        highlightsAdapter.setOnItemClicked(new Function2() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.lambda$new$1((Rubino.StoryHighlight) obj, (HighlightCell.HighlightType) obj2);
            }
        });
        recyclerListView.setAdapter(highlightsAdapter);
        linearLayout2.addView(recyclerListView, LayoutHelper.createFrame(-1, -2));
        HighlightCell highlightCell = new HighlightCell(context, HighlightCell.HighlightType.EDITABLE);
        this.newHighlightCell = highlightCell;
        highlightCell.setData(storyObject.full_thumbnail_url);
        highlightCell.setVisibility(8);
        linearLayout2.addView(highlightCell, LayoutHelper.createFrame(-1, -2));
        TextView textView2 = new TextView(context);
        this.bottomButton = textView2;
        textView2.setBackgroundColor(ContextCompat.getColor(context, R.color.rubino_highlight_button));
        textView2.setTextSize(15.0f);
        textView2.setTypeface(Theme.getRubinoTypeFaceBold());
        textView2.setGravity(17);
        textView2.setTextColor(ContextCompat.getColor(context, R.color.rubino_highlight_add_text));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$2(storyObject, view2);
            }
        });
        linearLayout2.addView(textView2, LayoutHelper.createFrame(-1, 52, 8388611, 0.0f, 16.0f, 0.0f, 0.0f));
        this.containerView = linearLayout;
        setUpShadowDrawable();
        getHighlights();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        getHighlights();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$1(Rubino.StoryHighlight storyHighlight, HighlightCell.HighlightType highlightType) {
        if (highlightType == HighlightCell.HighlightType.HIGHLIGHT) {
            dismiss();
            HighlightsDelegate highlightsDelegate = this.delegate;
            if (highlightsDelegate == null) {
                return null;
            }
            highlightsDelegate.onHighlightSelected(storyHighlight);
            return null;
        }
        if (highlightType != HighlightCell.HighlightType.ADD_NEW) {
            return null;
        }
        updateLayout(3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(StoryObject storyObject, View view) {
        int i = this.currentState;
        if (i == 2) {
            dismiss();
            return;
        }
        if (i != 3 || this.delegate == null) {
            return;
        }
        if (TextUtils.isEmpty(this.newHighlightCell.getTitle())) {
            this.newHighlightCell.showEmptyError();
        } else {
            this.delegate.onCreateNewHighlight(storyObject, this.newHighlightCell.getTitle());
            dismiss();
        }
    }

    private void getHighlights() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        updateLayout(1);
        this.compositeDisposable.add((DisposableObserver) RubinoController.getInstance(this.currentAccount).getMyHighlightsObservable().subscribeWith(new DisposableObserver<Rubino.GetProfileHighlightsOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightBottomSheet.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Rubino.GetProfileHighlightsOutput getProfileHighlightsOutput) {
                HighlightBottomSheet.this.isLoading = false;
                HighlightBottomSheet.this.updateList(getProfileHighlightsOutput.highlights);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                HighlightBottomSheet.this.isLoading = false;
                HighlightBottomSheet.this.updateLayout(0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateList(ArrayList<Rubino.StoryHighlight> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            updateLayout(3);
        } else {
            updateLayout(2);
            this.listAdapter.updateList(arrayList);
        }
    }

    private void setUpShadowDrawable() {
        Rect rect = new Rect();
        Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        this.shadowDrawable.getPadding(rect);
        this.backgroundPaddingLeft = rect.left;
        this.backgroundPaddingTop = rect.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(int i) {
        if (i == this.currentState) {
            return;
        }
        this.currentState = i;
        this.titleTextView.setText(LocaleController.getString(R.string.rubinoHighLightName));
        if (i == 0) {
            this.retryView.setVisibility(0);
            this.loadingCell.setVisibility(8);
            this.contentLayout.setVisibility(8);
            this.listView.setVisibility(8);
            this.newHighlightCell.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.retryView.setVisibility(8);
            this.loadingCell.setVisibility(0);
            this.contentLayout.setVisibility(8);
            this.listView.setVisibility(8);
            this.newHighlightCell.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.retryView.setVisibility(8);
            this.loadingCell.setVisibility(8);
            this.contentLayout.setVisibility(0);
            this.listView.setVisibility(0);
            this.newHighlightCell.setVisibility(8);
            this.bottomButton.setText(LocaleController.getString(R.string.cancel2));
            return;
        }
        if (i == 3) {
            this.retryView.setVisibility(8);
            this.loadingCell.setVisibility(8);
            this.contentLayout.setVisibility(0);
            this.listView.setVisibility(8);
            this.newHighlightCell.setVisibility(0);
            this.titleTextView.setText(LocaleController.getString(R.string.rubinoNewHighLight));
            this.bottomButton.setText(LocaleController.getString(R.string.rubinoHighLightAdd));
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compositeDisposable.dispose();
    }

    public void setDelegate(HighlightsDelegate highlightsDelegate) {
        this.delegate = highlightsDelegate;
    }
}
