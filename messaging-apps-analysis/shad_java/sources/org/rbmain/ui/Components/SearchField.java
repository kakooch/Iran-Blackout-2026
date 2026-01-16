package org.rbmain.ui.Components;

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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;

/* loaded from: classes5.dex */
public class SearchField extends FrameLayout {
    private ImageView clearSearchImageView;
    private CloseProgressDrawable2 progressDrawable;
    private View searchBackground;
    private EditTextBoldCursor searchEditText;
    private ImageView searchIconImageView;

    protected void onFieldTouchUp(EditTextBoldCursor editTextBoldCursor) {
    }

    public void onTextChange(String str) {
    }

    public void processTouchEvent(MotionEvent motionEvent) {
    }

    public SearchField(Context context) {
        this(context, false);
    }

    public SearchField(Context context, boolean z) {
        FrameLayout.LayoutParams layoutParamsCreateFrame;
        FrameLayout.LayoutParams layoutParamsCreateFrame2;
        FrameLayout.LayoutParams layoutParamsCreateFrame3;
        FrameLayout.LayoutParams layoutParamsCreateFrame4;
        super(context);
        View view = new View(context);
        this.searchBackground = view;
        view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(Theme.key_dialogSearchBackground)));
        if (z) {
            layoutParamsCreateFrame = LayoutHelper.createFrameRelatively(-1.0f, 36.0f, 8388659, 14.0f, 11.0f, 14.0f, 0.0f);
        } else {
            layoutParamsCreateFrame = LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f);
        }
        addView(this.searchBackground, layoutParamsCreateFrame);
        ImageView imageView = new ImageView(context);
        this.searchIconImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
        ImageView imageView2 = this.searchIconImageView;
        int i = Theme.key_dialogSearchIcon;
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        if (z) {
            layoutParamsCreateFrame2 = LayoutHelper.createFrameRelatively(36.0f, 36.0f, 8388659, 16.0f, 11.0f, 0.0f, 0.0f);
        } else {
            layoutParamsCreateFrame2 = LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f);
        }
        addView(this.searchIconImageView, layoutParamsCreateFrame2);
        ImageView imageView3 = new ImageView(context);
        this.clearSearchImageView = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView4 = this.clearSearchImageView;
        CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
        this.progressDrawable = closeProgressDrawable2;
        imageView4.setImageDrawable(closeProgressDrawable2);
        this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
        this.clearSearchImageView.setScaleX(0.1f);
        this.clearSearchImageView.setScaleY(0.1f);
        this.clearSearchImageView.setAlpha(0.0f);
        this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        if (z) {
            layoutParamsCreateFrame3 = LayoutHelper.createFrameRelatively(36.0f, 36.0f, 8388661, 14.0f, 11.0f, 14.0f, 0.0f);
        } else {
            layoutParamsCreateFrame3 = LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f);
        }
        addView(this.clearSearchImageView, layoutParamsCreateFrame3);
        this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.SearchField$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: org.rbmain.ui.Components.SearchField.1
            @Override // org.rbmain.ui.Components.EditTextEffects, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                SearchField.this.processTouchEvent(motionEvent);
                return super.dispatchTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (!isEnabled()) {
                    return false;
                }
                if (motionEvent.getAction() == 1) {
                    SearchField.this.onFieldTouchUp(this);
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.searchEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 16.0f);
        this.searchEditText.setHintTextColor(Theme.getColor(Theme.key_dialogSearchHint));
        this.searchEditText.setTextColor(Theme.getColor(Theme.key_dialogSearchText));
        this.searchEditText.setBackgroundDrawable(null);
        this.searchEditText.setPadding(0, 0, 0, 0);
        this.searchEditText.setMaxLines(1);
        this.searchEditText.setLines(1);
        this.searchEditText.setSingleLine(true);
        this.searchEditText.setGravity((z ? LayoutHelper.getAbsoluteGravityStart() : 3) | 16);
        this.searchEditText.setImeOptions(268435459);
        this.searchEditText.setCursorColor(Theme.getColor(Theme.key_featuredStickers_addedIcon));
        this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.searchEditText.setCursorWidth(1.5f);
        if (z) {
            layoutParamsCreateFrame4 = LayoutHelper.createFrameRelatively(-1.0f, 40.0f, 8388659, 54.0f, 9.0f, 46.0f, 0.0f);
        } else {
            layoutParamsCreateFrame4 = LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f);
        }
        addView(this.searchEditText, layoutParamsCreateFrame4);
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.SearchField.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z2 = SearchField.this.searchEditText.length() > 0;
                if (z2 != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                    SearchField.this.clearSearchImageView.animate().alpha(z2 ? 1.0f : 0.0f).setDuration(150L).scaleX(z2 ? 1.0f : 0.1f).scaleY(z2 ? 1.0f : 0.1f).start();
                }
                SearchField searchField = SearchField.this;
                searchField.onTextChange(searchField.searchEditText.getText().toString());
            }
        });
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.SearchField$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return this.f$0.lambda$new$1(textView, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.searchEditText.setText(BuildConfig.FLAVOR);
        AndroidUtilities.showKeyboard(this.searchEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(TextView textView, int i, KeyEvent keyEvent) {
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

    public void setHint(String str) {
        this.searchEditText.setHint(str);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
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

    public void getThemeDescriptions(List<ThemeDescription> list) {
        list.add(new ThemeDescription(this.searchBackground, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_dialogSearchBackground));
        ImageView imageView = this.searchIconImageView;
        int i = ThemeDescription.FLAG_IMAGECOLOR;
        int i2 = Theme.key_dialogSearchIcon;
        list.add(new ThemeDescription(imageView, i, null, null, null, null, i2));
        list.add(new ThemeDescription(this.clearSearchImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, i2));
        list.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_dialogSearchText));
        list.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_dialogSearchHint));
        list.add(new ThemeDescription(this.searchEditText, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, Theme.key_featuredStickers_addedIcon));
    }
}
