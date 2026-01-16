package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.TextStyleSpan;
import java.util.List;

/* loaded from: classes3.dex */
public class EditTextCaption extends EditTextBoldCursor {
    private boolean allowTextEntitiesIntersection;
    private String caption;
    private StaticLayout captionLayout;
    private boolean copyPasteShowed;
    private EditTextCaptionDelegate delegate;
    private int hintColor;
    private boolean isInitLineCount;
    private int lineCount;
    private float offsetY;
    private final Theme.ResourcesProvider resourcesProvider;
    private int selectionEnd;
    private int selectionStart;
    private int triesCount;
    private int userNameLength;
    private int xOffset;
    private int yOffset;

    public interface EditTextCaptionDelegate {
        void onSpansChanged();
    }

    protected void onLineCountChanged(int oldLineCount, int newLineCount) {
    }

    public EditTextCaption(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.triesCount = 0;
        this.selectionStart = -1;
        this.selectionEnd = -1;
        this.resourcesProvider = resourcesProvider;
        addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.EditTextCaption.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (EditTextCaption.this.lineCount != EditTextCaption.this.getLineCount()) {
                    if (!EditTextCaption.this.isInitLineCount && EditTextCaption.this.getMeasuredWidth() > 0) {
                        EditTextCaption editTextCaption = EditTextCaption.this;
                        editTextCaption.onLineCountChanged(editTextCaption.lineCount, EditTextCaption.this.getLineCount());
                    }
                    EditTextCaption editTextCaption2 = EditTextCaption.this;
                    editTextCaption2.lineCount = editTextCaption2.getLineCount();
                }
            }
        });
        setTypeface(AndroidUtilities.getFontFamily(false));
    }

    public void setCaption(String value) {
        String str = this.caption;
        if ((str == null || str.length() == 0) && (value == null || value.length() == 0)) {
            return;
        }
        String str2 = this.caption;
        if (str2 == null || !str2.equals(value)) {
            this.caption = value;
            if (value != null) {
                this.caption = value.replace('\n', ' ');
            }
            requestLayout();
        }
    }

    public void setDelegate(EditTextCaptionDelegate editTextCaptionDelegate) {
        this.delegate = editTextCaptionDelegate;
    }

    public void setAllowTextEntitiesIntersection(boolean value) {
        this.allowTextEntitiesIntersection = value;
    }

    public void makeSelectedBold() {
        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
        textStyleRun.flags |= 1;
        applyTextStyleToSelection(new TextStyleSpan(textStyleRun));
    }

    public void makeSelectedItalic() {
        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
        textStyleRun.flags |= 2;
        applyTextStyleToSelection(new TextStyleSpan(textStyleRun));
    }

    public void makeSelectedMono() {
        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
        textStyleRun.flags |= 4;
        applyTextStyleToSelection(new TextStyleSpan(textStyleRun));
    }

    public void makeSelectedStrike() {
        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
        textStyleRun.flags |= 8;
        applyTextStyleToSelection(new TextStyleSpan(textStyleRun));
    }

    public void makeSelectedUnderline() {
        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
        textStyleRun.flags |= 16;
        applyTextStyleToSelection(new TextStyleSpan(textStyleRun));
    }

    public void makeSelectedUrl() {
        final int selectionEnd;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), this.resourcesProvider);
        builder.setTitle(LocaleController.getString("CreateLink", R.string.CreateLink));
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(getContext()) { // from class: ir.eitaa.ui.Components.EditTextCaption.2
            @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f), 1073741824));
            }
        };
        editTextBoldCursor.setTextSize(1, 18.0f);
        editTextBoldCursor.setTypeface(AndroidUtilities.getFontFamily(false));
        editTextBoldCursor.setText("http://");
        editTextBoldCursor.setTextColor(getThemedColor("dialogTextBlack"));
        editTextBoldCursor.setHintText(LocaleController.getString("URL", R.string.URL));
        editTextBoldCursor.setHeaderHintColor(getThemedColor("windowBackgroundWhiteBlueHeader"));
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setFocusable(true);
        editTextBoldCursor.setTransformHintToHeader(true);
        editTextBoldCursor.setLineColors(getThemedColor("windowBackgroundWhiteInputField"), getThemedColor("windowBackgroundWhiteInputFieldActivated"), getThemedColor("windowBackgroundWhiteRedText3"));
        editTextBoldCursor.setImeOptions(6);
        editTextBoldCursor.setBackgroundDrawable(null);
        editTextBoldCursor.requestFocus();
        editTextBoldCursor.setPadding(0, 0, 0, 0);
        builder.setView(editTextBoldCursor);
        final int selectionStart = this.selectionStart;
        if (selectionStart >= 0 && (selectionEnd = this.selectionEnd) >= 0) {
            this.selectionEnd = -1;
            this.selectionStart = -1;
        } else {
            selectionStart = getSelectionStart();
            selectionEnd = getSelectionEnd();
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextCaption$HwUOsmqudrQUBxBNvXi208d4YaE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$makeSelectedUrl$0$EditTextCaption(selectionStart, selectionEnd, editTextBoldCursor, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show().setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextCaption$uQyjVErYF_SIqb-4rifjtpeybUQ
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                EditTextCaption.lambda$makeSelectedUrl$1(editTextBoldCursor, dialogInterface);
            }
        });
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) editTextBoldCursor.getLayoutParams();
        if (marginLayoutParams != null) {
            if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) marginLayoutParams).gravity = 1;
            }
            int iDp = AndroidUtilities.dp(24.0f);
            marginLayoutParams.leftMargin = iDp;
            marginLayoutParams.rightMargin = iDp;
            marginLayoutParams.height = AndroidUtilities.dp(36.0f);
            editTextBoldCursor.setLayoutParams(marginLayoutParams);
        }
        editTextBoldCursor.setSelection(0, editTextBoldCursor.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$makeSelectedUrl$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$makeSelectedUrl$0$EditTextCaption(int i, int i2, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface, int i3) {
        Editable text = getText();
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) text.getSpans(i, i2, CharacterStyle.class);
        if (characterStyleArr != null && characterStyleArr.length > 0) {
            for (CharacterStyle characterStyle : characterStyleArr) {
                int spanStart = text.getSpanStart(characterStyle);
                int spanEnd = text.getSpanEnd(characterStyle);
                text.removeSpan(characterStyle);
                if (spanStart < i) {
                    text.setSpan(characterStyle, spanStart, i, 33);
                }
                if (spanEnd > i2) {
                    text.setSpan(characterStyle, i2, spanEnd, 33);
                }
            }
        }
        try {
            text.setSpan(new URLSpanReplacement(editTextBoldCursor.getText().toString()), i, i2, 33);
        } catch (Exception unused) {
        }
        EditTextCaptionDelegate editTextCaptionDelegate = this.delegate;
        if (editTextCaptionDelegate != null) {
            editTextCaptionDelegate.onSpansChanged();
        }
    }

    static /* synthetic */ void lambda$makeSelectedUrl$1(EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    public void makeSelectedRegular() {
        applyTextStyleToSelection(null);
    }

    public void setSelectionOverride(int start, int end) {
        this.selectionStart = start;
        this.selectionEnd = end;
    }

    private void applyTextStyleToSelection(TextStyleSpan span) {
        int selectionEnd;
        int selectionStart = this.selectionStart;
        if (selectionStart >= 0 && (selectionEnd = this.selectionEnd) >= 0) {
            this.selectionEnd = -1;
            this.selectionStart = -1;
        } else {
            selectionStart = getSelectionStart();
            selectionEnd = getSelectionEnd();
        }
        MediaDataController.addStyleToText(span, selectionStart, selectionEnd, getText(), this.allowTextEntitiesIntersection);
        EditTextCaptionDelegate editTextCaptionDelegate = this.delegate;
        if (editTextCaptionDelegate != null) {
            editTextCaptionDelegate.onSpansChanged();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (Build.VERSION.SDK_INT >= 23 || hasWindowFocus || !this.copyPasteShowed) {
            try {
                super.onWindowFocusChanged(hasWindowFocus);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
    }

    private ActionMode.Callback overrideCallback(final ActionMode.Callback callback) {
        final ActionMode.Callback callback2 = new ActionMode.Callback() { // from class: ir.eitaa.ui.Components.EditTextCaption.3
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                EditTextCaption.this.copyPasteShowed = true;
                return callback.onCreateActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return callback.onPrepareActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (EditTextCaption.this.performMenuAction(item.getItemId())) {
                    mode.finish();
                    return true;
                }
                try {
                    return callback.onActionItemClicked(mode, item);
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                EditTextCaption.this.copyPasteShowed = false;
                callback.onDestroyActionMode(mode);
            }
        };
        return Build.VERSION.SDK_INT >= 23 ? new ActionMode.Callback2() { // from class: ir.eitaa.ui.Components.EditTextCaption.4
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return callback2.onCreateActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return callback2.onPrepareActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return callback2.onActionItemClicked(mode, item);
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                callback2.onDestroyActionMode(mode);
            }

            @Override // android.view.ActionMode.Callback2
            public void onGetContentRect(ActionMode mode, View view, android.graphics.Rect outRect) {
                ActionMode.Callback callback3 = callback;
                if (callback3 instanceof ActionMode.Callback2) {
                    ((ActionMode.Callback2) callback3).onGetContentRect(mode, view, outRect);
                } else {
                    super.onGetContentRect(mode, view, outRect);
                }
            }
        } : callback2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performMenuAction(int itemId) {
        if (itemId == R.id.menu_regular) {
            makeSelectedRegular();
            return true;
        }
        if (itemId == R.id.menu_bold) {
            makeSelectedBold();
            return true;
        }
        if (itemId == R.id.menu_italic) {
            makeSelectedItalic();
            return true;
        }
        if (itemId == R.id.menu_mono) {
            makeSelectedMono();
            return true;
        }
        if (itemId == R.id.menu_link) {
            makeSelectedUrl();
            return true;
        }
        if (itemId == R.id.menu_strike) {
            makeSelectedStrike();
            return true;
        }
        if (itemId != R.id.menu_underline) {
            return false;
        }
        makeSelectedUnderline();
        return true;
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.view.View
    public ActionMode startActionMode(final ActionMode.Callback callback, int type) {
        return super.startActionMode(overrideCallback(callback), type);
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.view.View
    public ActionMode startActionMode(final ActionMode.Callback callback) {
        return super.startActionMode(overrideCallback(callback));
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iIndexOf;
        try {
            this.isInitLineCount = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.isInitLineCount) {
                this.lineCount = getLineCount();
            }
            this.isInitLineCount = false;
        } catch (Exception e) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(51.0f));
            FileLog.e(e);
        }
        this.captionLayout = null;
        String str = this.caption;
        if (str == null || str.length() <= 0) {
            return;
        }
        Editable text = getText();
        if (text.length() <= 1 || text.charAt(0) != '@' || (iIndexOf = TextUtils.indexOf((CharSequence) text, ' ')) == -1) {
            return;
        }
        TextPaint paint = getPaint();
        CharSequence charSequenceSubSequence = text.subSequence(0, iIndexOf + 1);
        int iCeil = (int) Math.ceil(paint.measureText(text, 0, r13));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.userNameLength = charSequenceSubSequence.length();
        int i = measuredWidth - iCeil;
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.caption, paint, i, TextUtils.TruncateAt.END);
        this.xOffset = iCeil;
        try {
            StaticLayout staticLayout = new StaticLayout(charSequenceEllipsize, getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.captionLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.xOffset = (int) (this.xOffset + (-this.captionLayout.getLineLeft(0)));
            }
            this.yOffset = ((getMeasuredHeight() - this.captionLayout.getLineBottom(0)) / 2) + AndroidUtilities.dp(0.5f);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    public String getCaption() {
        return this.caption;
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor
    public void setHintColor(int value) {
        super.setHintColor(value);
        this.hintColor = value;
        invalidate();
    }

    public void setOffsetY(float offset) {
        this.offsetY = offset;
        invalidate();
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException {
        canvas.save();
        canvas.translate(0.0f, this.offsetY);
        super.onDraw(canvas);
        try {
            if (this.captionLayout != null && this.userNameLength == length()) {
                TextPaint paint = getPaint();
                int color = getPaint().getColor();
                paint.setColor(this.hintColor);
                canvas.save();
                canvas.translate(this.xOffset, this.yOffset);
                this.captionLayout.draw(canvas);
                canvas.restore();
                paint.setColor(color);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        canvas.restore();
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(info);
        if (!TextUtils.isEmpty(this.caption)) {
            accessibilityNodeInfoCompatWrap.setHintText(this.caption);
        }
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = accessibilityNodeInfoCompatWrap.getActionList();
        int i = 0;
        int size = actionList.size();
        while (true) {
            if (i >= size) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i);
            if (accessibilityActionCompat.getId() == 268435456) {
                accessibilityNodeInfoCompatWrap.removeAction(accessibilityActionCompat);
                break;
            }
            i++;
        }
        if (hasSelection()) {
            accessibilityNodeInfoCompatWrap.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.menu_bold, LocaleController.getString("Bold", R.string.Bold)));
            accessibilityNodeInfoCompatWrap.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.menu_italic, LocaleController.getString("Italic", R.string.Italic)));
            accessibilityNodeInfoCompatWrap.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.menu_mono, LocaleController.getString("Mono", R.string.Mono)));
            accessibilityNodeInfoCompatWrap.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.menu_link, LocaleController.getString("CreateLink", R.string.CreateLink)));
            accessibilityNodeInfoCompatWrap.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.menu_regular, LocaleController.getString("Regular", R.string.Regular)));
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return performMenuAction(action) || super.performAccessibilityAction(action, arguments);
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
