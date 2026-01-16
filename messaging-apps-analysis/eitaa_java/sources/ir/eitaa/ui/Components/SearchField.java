package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchField extends FrameLayout {
    private ImageView clearSearchImageView;
    private CloseProgressDrawable2 progressDrawable;
    private final Theme.ResourcesProvider resourcesProvider;
    private View searchBackground;
    private EditTextBoldCursor searchEditText;
    private ImageView searchIconImageView;

    protected void onFieldTouchUp(EditTextBoldCursor editText) {
    }

    public void onTextChange(String text) {
    }

    public void processTouchEvent(MotionEvent event) {
    }

    public SearchField(Context context, boolean supportRtl, Theme.ResourcesProvider resourcesProvider) {
        FrameLayout.LayoutParams layoutParamsCreateFrame;
        FrameLayout.LayoutParams layoutParamsCreateFrame2;
        FrameLayout.LayoutParams layoutParamsCreateFrame3;
        FrameLayout.LayoutParams layoutParamsCreateFrame4;
        super(context);
        this.resourcesProvider = resourcesProvider;
        View view = new View(context);
        this.searchBackground = view;
        view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), getThemedColor("dialogSearchBackground")));
        if (supportRtl) {
            layoutParamsCreateFrame = LayoutHelper.createFrameRelatively(-1.0f, 36.0f, 8388659, 14.0f, 11.0f, 14.0f, 0.0f);
        } else {
            layoutParamsCreateFrame = LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f);
        }
        addView(this.searchBackground, layoutParamsCreateFrame);
        ImageView imageView = new ImageView(context);
        this.searchIconImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
        this.searchIconImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogSearchIcon"), PorterDuff.Mode.MULTIPLY));
        if (supportRtl) {
            layoutParamsCreateFrame2 = LayoutHelper.createFrameRelatively(36.0f, 36.0f, 8388659, 16.0f, 11.0f, 0.0f, 0.0f);
        } else {
            layoutParamsCreateFrame2 = LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f);
        }
        addView(this.searchIconImageView, layoutParamsCreateFrame2);
        ImageView imageView2 = new ImageView(context);
        this.clearSearchImageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView3 = this.clearSearchImageView;
        CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
        this.progressDrawable = closeProgressDrawable2;
        imageView3.setImageDrawable(closeProgressDrawable2);
        this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
        this.clearSearchImageView.setScaleX(0.1f);
        this.clearSearchImageView.setScaleY(0.1f);
        this.clearSearchImageView.setAlpha(0.0f);
        this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogSearchIcon"), PorterDuff.Mode.MULTIPLY));
        if (supportRtl) {
            layoutParamsCreateFrame3 = LayoutHelper.createFrameRelatively(36.0f, 36.0f, 8388661, 14.0f, 11.0f, 14.0f, 0.0f);
        } else {
            layoutParamsCreateFrame3 = LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f);
        }
        addView(this.clearSearchImageView, layoutParamsCreateFrame3);
        this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SearchField$CqEhl-9bX9kRwPLdSwoehUkjLts
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0$SearchField(view2);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.SearchField.1
            @Override // android.view.View
            public boolean dispatchTouchEvent(MotionEvent event) {
                SearchField.this.processTouchEvent(event);
                return super.dispatchTouchEvent(event);
            }

            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (!isEnabled()) {
                    return false;
                }
                if (event.getAction() == 1) {
                    SearchField.this.onFieldTouchUp(this);
                }
                return super.onTouchEvent(event);
            }
        };
        this.searchEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 16.0f);
        this.searchEditText.setHintTextColor(getThemedColor("dialogSearchHint"));
        this.searchEditText.setTextColor(getThemedColor("dialogSearchText"));
        this.searchEditText.setBackgroundDrawable(null);
        this.searchEditText.setPadding(0, 0, 0, 0);
        this.searchEditText.setMaxLines(1);
        this.searchEditText.setLines(1);
        this.searchEditText.setSingleLine(true);
        this.searchEditText.setGravity((supportRtl ? LayoutHelper.getAbsoluteGravityStart() : 3) | 16);
        this.searchEditText.setImeOptions(268435459);
        this.searchEditText.setCursorColor(getThemedColor("featuredStickers_addedIcon"));
        this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.searchEditText.setCursorWidth(1.5f);
        if (supportRtl) {
            layoutParamsCreateFrame4 = LayoutHelper.createFrameRelatively(-1.0f, 40.0f, 8388659, 54.0f, 9.0f, 46.0f, 0.0f);
        } else {
            layoutParamsCreateFrame4 = LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f);
        }
        addView(this.searchEditText, layoutParamsCreateFrame4);
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.SearchField.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                boolean z = SearchField.this.searchEditText.length() > 0;
                if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                    SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                }
                SearchField searchField = SearchField.this;
                searchField.onTextChange(searchField.searchEditText.getText().toString());
            }
        });
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SearchField$NFxl6xfgLB4B6M2CgVmsvvkzH28
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$new$1$SearchField(textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SearchField(View view) {
        this.searchEditText.setText("");
        AndroidUtilities.showKeyboard(this.searchEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$SearchField(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        this.searchEditText.hideActionMode();
        AndroidUtilities.hideKeyboard(this.searchEditText);
        return false;
    }

    public void setHint(String text) {
        this.searchEditText.setHint(text);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public View getSearchBackground() {
        return this.searchBackground;
    }

    public EditTextBoldCursor getSearchEditText() {
        return this.searchEditText;
    }

    public CloseProgressDrawable2 getProgressDrawable() {
        return this.progressDrawable;
    }

    public void getThemeDescriptions(List<ThemeDescription> descriptions) {
        descriptions.add(new ThemeDescription(this.searchBackground, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogSearchBackground"));
        descriptions.add(new ThemeDescription(this.searchIconImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogSearchIcon"));
        descriptions.add(new ThemeDescription(this.clearSearchImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogSearchIcon"));
        descriptions.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogSearchText"));
        descriptions.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "dialogSearchHint"));
        descriptions.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "featuredStickers_addedIcon"));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
