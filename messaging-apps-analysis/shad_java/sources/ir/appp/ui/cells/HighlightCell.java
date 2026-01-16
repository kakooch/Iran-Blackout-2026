package ir.appp.ui.cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Rubino;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: HighlightCell.kt */
/* loaded from: classes3.dex */
public final class HighlightCell extends ConstraintLayout {
    private EditText highlightNameTv;
    private final HighlightType highlightType;
    private final int imageMargin;
    private final int imagePadding;
    private final float imageSizeInDp;
    private ImageView insStoryAvatarView;
    private final int namePadding;
    private ImageView selectedImageView;
    private Rubino.StoryHighlight storyHighlight;
    private final HighlightCell$textWatcher$1 textWatcher;

    /* compiled from: HighlightCell.kt */
    public enum HighlightType {
        HIGHLIGHT,
        ADD_NEW,
        EDITABLE
    }

    public final HighlightType getHighlightType() {
        return this.highlightType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.text.TextWatcher, ir.appp.ui.cells.HighlightCell$textWatcher$1] */
    public HighlightCell(Context context, HighlightType highlightType) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(highlightType, "highlightType");
        new LinkedHashMap();
        this.highlightType = highlightType;
        int iDp = AndroidUtilities.dp(6.0f);
        this.imageMargin = iDp;
        int iDp2 = AndroidUtilities.dp(8.0f);
        this.namePadding = iDp2;
        int iDp3 = AndroidUtilities.dp(16.0f);
        this.imagePadding = iDp3;
        this.imageSizeInDp = 60.0f;
        ?? r4 = new TextWatcher() { // from class: ir.appp.ui.cells.HighlightCell$textWatcher$1
            private final int MAX_SIZE = 30;
            private String lastString;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text;
                EditText editText;
                EditText editText2;
                if (charSequence == null) {
                    return;
                }
                HighlightCell highlightCell = this.this$0;
                if (charSequence.length() > this.MAX_SIZE) {
                    EditText editText3 = highlightCell.highlightNameTv;
                    if (editText3 != null) {
                        editText3.removeTextChangedListener(this);
                    }
                    Unit unit = null;
                    if (this.lastString != null && (editText2 = highlightCell.highlightNameTv) != null) {
                        editText2.setText(this.lastString);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null && (editText = highlightCell.highlightNameTv) != null) {
                        editText.setText(BuildConfig.FLAVOR);
                    }
                    EditText editText4 = highlightCell.highlightNameTv;
                    if (editText4 != null && (text = editText4.getText()) != null) {
                        int length = text.length();
                        EditText editText5 = highlightCell.highlightNameTv;
                        if (editText5 != null) {
                            editText5.setSelection(length);
                        }
                    }
                    EditText editText6 = highlightCell.highlightNameTv;
                    if (editText6 == null) {
                        return;
                    }
                    editText6.addTextChangedListener(this);
                    return;
                }
                this.lastString = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Rubino.StoryHighlight storyHighlight = this.this$0.storyHighlight;
                if (storyHighlight == null) {
                    return;
                }
                storyHighlight.name = this.lastString;
            }
        };
        this.textWatcher = r4;
        ImageView imageView = new ImageView(context, null);
        imageView.setId(R.id.highlightCover);
        HighlightType highlightType2 = getHighlightType();
        HighlightType highlightType3 = HighlightType.ADD_NEW;
        if (highlightType2 == highlightType3) {
            imageView.setImageResource(R.drawable.plus);
            imageView.setPadding(iDp3, iDp3, iDp3, iDp3);
            imageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            imageView.setBackground(context.getResources().getDrawable(R.drawable.circle_border_black));
        }
        this.insStoryAvatarView = imageView;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f));
        layoutParams.topToTop = 0;
        layoutParams.rightToRight = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.setMargins(iDp, iDp, iDp, iDp);
        Unit unit = Unit.INSTANCE;
        addView(imageView, layoutParams);
        final EditText editText = new EditText(context);
        editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        editText.setId(R.id.highlightName);
        editText.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        editText.setHintTextColor(Theme.getColor(Theme.key_dialogTextGray));
        if (getHighlightType() == HighlightType.EDITABLE) {
            editText.setEnabled(true);
            editText.addTextChangedListener(r4);
            editText.requestFocus();
            editText.setHint(editText.getResources().getString(R.string.rubinoHighLightName));
            editText.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.ui.cells.HighlightCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HighlightCell.m335lambda3$lambda2(editText, view);
                }
            });
        } else {
            editText.setEnabled(false);
        }
        if (getHighlightType() == highlightType3) {
            editText.setText(R.string.rubinoHighLightNew);
        }
        editText.setBackground(null);
        editText.setTextSize(14.0f);
        editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        editText.setPadding(iDp2, iDp2, iDp2, iDp2 * 2);
        editText.setGravity(17);
        this.highlightNameTv = editText;
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.topToBottom = R.id.highlightCover;
        layoutParams2.rightToRight = 0;
        layoutParams2.leftToLeft = 0;
        addView(editText, layoutParams2);
        if (highlightType == HighlightType.HIGHLIGHT) {
            ImageView imageView2 = new ImageView(context);
            imageView2.setVisibility(4);
            imageView2.setImageResource(R.drawable.ic_check_circle_green);
            this.selectedImageView = imageView2;
            ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(AndroidUtilities.dp(64.0f), AndroidUtilities.dp(64.0f));
            layoutParams3.topToTop = R.id.highlightCover;
            layoutParams3.rightToRight = R.id.highlightCover;
            layoutParams3.leftToLeft = R.id.highlightCover;
            layoutParams3.bottomToBottom = R.id.highlightCover;
            addView(imageView2, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2, reason: not valid java name */
    public static final void m335lambda3$lambda2(EditText this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        AndroidUtilities.showKeyboard(this_apply);
    }

    public final void setData(Rubino.StoryHighlight storyHighlight) {
        EditText editText;
        EditText editText2;
        Intrinsics.checkNotNullParameter(storyHighlight, "storyHighlight");
        this.storyHighlight = storyHighlight;
        AndroidUtilities.showKeyboard(this);
        if (this.insStoryAvatarView != null) {
            GlideHelper.loadCircle(getContext(), this.insStoryAvatarView, storyHighlight.avatar_url, R.drawable.circle_grey);
        }
        if (this.highlightType != HighlightType.EDITABLE) {
            String str = storyHighlight.name;
            Unit unit = null;
            if (str != null && (editText2 = this.highlightNameTv) != null) {
                editText2.setText(str);
                unit = Unit.INSTANCE;
            }
            if (unit == null && (editText = this.highlightNameTv) != null) {
                editText.setText(getResources().getText(R.string.rubinoHighLightName));
            }
        }
        HighlightType highlightType = HighlightType.HIGHLIGHT;
    }

    public final void setData(String image_url) {
        Intrinsics.checkNotNullParameter(image_url, "image_url");
        if (this.insStoryAvatarView == null) {
            return;
        }
        GlideHelper.loadCircle(getContext(), this.insStoryAvatarView, image_url, R.drawable.circle_grey);
    }

    public final Rubino.StoryHighlight getData() {
        return this.storyHighlight;
    }

    public final String getTitle() {
        Editable text;
        EditText editText = this.highlightNameTv;
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    public final void showEmptyError() {
        AndroidUtilities.shakeView(this.highlightNameTv, 2.0f, 0);
    }
}
