package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import ir.medu.shad.R;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoSearchView extends FrameLayout {
    public static int type_in_actionbar = 0;
    public static int type_in_profile_list = 1;
    private CompositeDisposable compositeDisposable;
    private Paint dividerPaint;
    public EditTextBoldCursor editText;
    private ImageView imageViewClose;
    public Context mContext;
    private boolean needDivider;
    private SearchListener searchListener;

    public interface SearchListener {
        void search(String str);
    }

    public RubinoSearchView(Context context, CompositeDisposable compositeDisposable, int i, SearchListener searchListener) {
        super(context);
        this.mContext = context;
        setWillNotDraw(false);
        this.searchListener = searchListener;
        this.compositeDisposable = compositeDisposable;
        boolean z = i == type_in_profile_list;
        this.needDivider = z;
        if (z) {
            Paint paint = new Paint();
            this.dividerPaint = paint;
            paint.setStrokeWidth(1.0f);
            this.dividerPaint.setColor(this.mContext.getResources().getColor(R.color.rubino_blue));
            this.dividerPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        }
        int i2 = 8;
        if (i == type_in_profile_list) {
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_explore_search_icon));
            imageView.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.grey_500), PorterDuff.Mode.SRC_ATOP));
            imageView.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
            addView(imageView, LayoutHelper.createFrame(44, 44, 21));
            i2 = 52;
        }
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.editText;
        int i3 = Theme.key_rubinoGrayColor;
        editTextBoldCursor2.setHintTextColor(Theme.getColor(i3));
        EditTextBoldCursor editTextBoldCursor3 = this.editText;
        int i4 = Theme.key_rubinoBlackColor;
        editTextBoldCursor3.setTextColor(Theme.getColor(i4));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setBackgroundDrawable(null);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setSingleLine(true);
        this.editText.setImeOptions(6);
        this.editText.setFocusable(true);
        this.editText.requestFocus();
        this.editText.setHint(LocaleController.getString(R.string.rubinoSearch));
        this.editText.setCursorColor(Theme.getColor(i4));
        this.editText.setCursorSize(AndroidUtilities.dp(17.0f));
        this.editText.setCursorWidth(1.0f);
        setupRxListener(this.editText, 250);
        addView(this.editText, LayoutHelper.createFrame(-1, -2.0f, 16, 44.0f, 0.0f, i2, 0.0f));
        this.editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        ImageView imageView2 = new ImageView(context);
        this.imageViewClose = imageView2;
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_canvas_close));
        this.imageViewClose.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.SRC_ATOP));
        this.imageViewClose.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        addView(this.imageViewClose, LayoutHelper.createFrame(44, 44, 19));
        this.imageViewClose.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoSearchView.this.initText();
            }
        });
        initText();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needDivider) {
            canvas.drawLine(getPaddingLeft(), getHeight() - AndroidUtilities.dp(1.0f), getWidth() - getPaddingRight(), getHeight() - AndroidUtilities.dp(1.0f), this.dividerPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initText() {
        this.imageViewClose.setVisibility(4);
        this.editText.setText(BuildConfig.FLAVOR);
    }

    private void setupRxListener(EditText editText, int i) {
        if (this.compositeDisposable == null) {
            return;
        }
        this.compositeDisposable.add(RxTextView.textChanges(editText).doOnNext(new Consumer<CharSequence>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchView.3
            @Override // io.reactivex.functions.Consumer
            public void accept(CharSequence charSequence) throws Exception {
                if (charSequence == null || RubinoSearchView.this.imageViewClose == null) {
                    return;
                }
                if (charSequence.toString().isEmpty()) {
                    RubinoSearchView.this.imageViewClose.setVisibility(4);
                } else {
                    RubinoSearchView.this.imageViewClose.setVisibility(0);
                }
            }
        }).skip(1L).map(new Function<CharSequence, CharSequence>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchView.2
            @Override // io.reactivex.functions.Function
            public CharSequence apply(CharSequence charSequence) throws Exception {
                return charSequence.toString().toLowerCase();
            }
        }).debounce(i, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoSearchView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$setupRxListener$0((CharSequence) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupRxListener$0(CharSequence charSequence) throws Exception {
        String string = charSequence.toString();
        SearchListener searchListener = this.searchListener;
        if (searchListener != null) {
            searchListener.search(string.trim());
        }
    }

    public String getText() {
        return this.editText.getText().toString();
    }
}
