package ir.resaneh1.iptv.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;

/* loaded from: classes3.dex */
public class CreateLinkFrameLayout extends FrameLayout {
    private final TextView doneButton;
    public final EditTextBoldCursor nameEditText;
    private OnDoneListener onDoneListener;
    public final EditTextBoldCursor urlEditText;

    public interface OnDoneListener {
        void onBackClick();

        void onDoneClick(String str, String str2);
    }

    public void setOnDoneListener(OnDoneListener onDoneListener) {
        this.onDoneListener = onDoneListener;
    }

    public CreateLinkFrameLayout(final Context context) {
        super(context);
        setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        BackDrawable backDrawable = new BackDrawable(false);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(backDrawable);
        backDrawable.setColor(-1);
        imageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        imageView.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
        linearLayout.addView(imageView, LayoutHelper.createLinear(44, 44, 17));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString(R.string.rubinoStoryAddLink));
        textView.setTextColor(-1);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setTextSize(17.0f);
        textView.setGravity(17);
        linearLayout.addView(textView, LayoutHelper.createLinear(0, -2, 1.0f, 17));
        TextView textView2 = new TextView(context);
        this.doneButton = textView2;
        textView2.setText(LocaleController.getString(R.string.rubinoActionDone));
        textView2.setTextColor(-1);
        textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView2.setTextSize(16.0f);
        textView2.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        textView2.setGravity(17);
        linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 17));
        addView(linearLayout, LayoutHelper.createFrame(-1, -2, 48));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        TextView textView3 = new TextView(context);
        textView3.setText(LocaleController.getString(R.string.rubinoStoryLinkAddress));
        textView3.setTextColor(-1);
        textView3.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView3.setTextSize(14.0f);
        textView3.setGravity(5);
        linearLayout2.addView(textView3, LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.urlEditText = editTextBoldCursor;
        editTextBoldCursor.setTypeface(Theme.getRubinoTypeFaceRegular());
        editTextBoldCursor.setTextColor(-1);
        int i = Theme.key_dialogTextGray2;
        editTextBoldCursor.setHintColor(Theme.getColor(i));
        editTextBoldCursor.setHint("http://example.com");
        editTextBoldCursor.setMaxLines(1);
        editTextBoldCursor.setImeOptions(268435456);
        editTextBoldCursor.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        editTextBoldCursor.setFilters(InputFilterHelper.getFilter(250, 1, editTextBoldCursor));
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor.setCursorColor(Theme.getColor(i2));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.requestFocus();
        editTextBoldCursor.setInputType(33);
        editTextBoldCursor.setGravity(3);
        linearLayout2.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, -2, 5, 0, 4, 0, 0));
        TextView textView4 = new TextView(context);
        textView4.setText(LocaleController.getString(R.string.rubinoStoryLinkDescription));
        textView4.setTextColor(-1);
        textView4.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView4.setTextSize(14.0f);
        textView4.setGravity(5);
        linearLayout2.addView(textView4, LayoutHelper.createLinear(-1, -2, 5, 0, 4, 0, 0));
        final TextView textView5 = new TextView(context);
        textView5.setText(LocaleController.getString(R.string.rubinoStoryAddLinkText));
        textView5.setTextColor(-1);
        textView5.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView5.setTextSize(16.0f);
        textView5.setGravity(5);
        linearLayout2.addView(textView5, LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        final LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        TextView textView6 = new TextView(context);
        textView6.setText(LocaleController.getString(R.string.rubinoStoryLinkText));
        textView6.setTextColor(-1);
        textView6.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView6.setTextSize(14.0f);
        textView6.setGravity(5);
        linearLayout3.addView(textView6, LayoutHelper.createLinear(-1, -2, 5, 0, 16, 0, 0));
        EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
        this.nameEditText = editTextBoldCursor2;
        editTextBoldCursor2.setTypeface(Theme.getRubinoTypeFaceRegular());
        editTextBoldCursor2.setTextColor(-1);
        editTextBoldCursor2.setHintColor(Theme.getColor(i));
        editTextBoldCursor2.setMaxLines(1);
        editTextBoldCursor2.setImeOptions(268435456);
        editTextBoldCursor2.setInputType(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
        editTextBoldCursor2.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
        editTextBoldCursor2.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        editTextBoldCursor2.setFilters(InputFilterHelper.getFilter(50, 1, editTextBoldCursor));
        editTextBoldCursor2.setCursorColor(Theme.getColor(i2));
        editTextBoldCursor2.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor2.setCursorWidth(1.5f);
        editTextBoldCursor2.setGravity(5);
        linearLayout3.addView(editTextBoldCursor2, LayoutHelper.createLinear(-1, -2, 5, 0, 4, 0, 0));
        TextView textView7 = new TextView(context);
        textView7.setText(LocaleController.getString(R.string.rubinoStoryLinkTextDescription));
        textView7.setTextColor(-1);
        textView7.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView7.setTextSize(14.0f);
        textView7.setGravity(5);
        linearLayout3.addView(textView7, LayoutHelper.createLinear(-1, -2, 5, 0, 4, 0, 0));
        linearLayout2.addView(linearLayout3, LayoutHelper.createFrame(-1, -2, 48));
        addView(linearLayout2, LayoutHelper.createFrame(-1, -2, 48, 0.0f, 48.0f, 0.0f, 0.0f));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.helper.CreateLinkFrameLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String string = CreateLinkFrameLayout.this.urlEditText.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    ToastiLikeSnack.showL(context, LocaleController.getString(R.string.rubinoStoryAddLinkError));
                    return;
                }
                if (!AndroidUtilities.isValidUrl(string)) {
                    ToastiLikeSnack.showL(context, LocaleController.getString(R.string.rubinoStoryAddLinkError2));
                    return;
                }
                AndroidUtilities.hideKeyboard(CreateLinkFrameLayout.this.urlEditText);
                if (CreateLinkFrameLayout.this.onDoneListener != null) {
                    CreateLinkFrameLayout.this.onDoneListener.onDoneClick(CreateLinkFrameLayout.this.nameEditText.getText().toString(), string);
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.helper.CreateLinkFrameLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CreateLinkFrameLayout.this.onDoneListener != null) {
                    CreateLinkFrameLayout.this.onDoneListener.onBackClick();
                }
            }
        });
        textView5.setAlpha(0.5f);
        editTextBoldCursor.addTextChangedListener(new TextWatcher(this) { // from class: ir.resaneh1.iptv.helper.CreateLinkFrameLayout.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    textView5.setAlpha(1.0f);
                }
            }
        });
        linearLayout3.setVisibility(8);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.helper.CreateLinkFrameLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(CreateLinkFrameLayout.this.urlEditText.getText().toString())) {
                    return;
                }
                linearLayout3.setVisibility(0);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(linearLayout3, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(textView5, "alpha", 1.0f, 0.0f));
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.helper.CreateLinkFrameLayout.4.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        AnimatorSet animatorSet2 = animatorSet;
                        if (animatorSet2 == null || !animatorSet2.equals(animator)) {
                            return;
                        }
                        textView5.setVisibility(4);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        textView5.setVisibility(4);
                    }
                });
                animatorSet.setDuration(150L);
                animatorSet.start();
            }
        });
    }
}
