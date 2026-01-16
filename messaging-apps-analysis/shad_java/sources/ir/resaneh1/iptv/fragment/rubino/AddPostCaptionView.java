package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostCaptionView extends FrameLayout {
    Context context;
    public EditTextBoldCursor editText;
    FrameLayout frameLayout;
    ImageView imageView;
    ImageView imageViewMulti;
    ImageView imageViewVideo;
    private final boolean needDivider;

    public AddPostCaptionView(Context context) {
        super(context);
        this.needDivider = true;
        setWillNotDraw(false);
        this.context = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(56, 56.0f, 21, 16.0f, 16.0f, 16.0f, 16.0f));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        this.frameLayout.addView(imageView, LayoutHelper.createFrame(56, 56, 17));
        ImageView imageView2 = new ImageView(context);
        this.imageViewVideo = imageView2;
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_video_filled_32));
        this.frameLayout.addView(this.imageViewVideo, LayoutHelper.createFrame(32, 32, 17));
        ImageView imageView3 = new ImageView(context);
        this.imageViewMulti = imageView3;
        imageView3.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_multi_grid_album_icon));
        this.frameLayout.addView(this.imageViewMulti, LayoutHelper.createFrame(32, 32.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(this.context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setHint(LocaleController.getString("ShareSendTo", R.string.rubinoAddCaption));
        this.editText.setSingleLine(false);
        this.editText.setTextSize(2, 15.0f);
        this.editText.setBackgroundDrawable(null);
        this.editText.setHintTextColor(Theme.getColor(Theme.key_dialogTextHint));
        this.editText.setImeOptions(268435456);
        this.editText.setInputType(147457);
        EditTextBoldCursor editTextBoldCursor2 = this.editText;
        int i = Theme.key_dialogTextBlack;
        editTextBoldCursor2.setCursorColor(Theme.getColor(i));
        this.editText.setCursorSize(AndroidUtilities.dp(12.0f));
        this.editText.setCursorWidth(1.5f);
        this.editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.editText.setTextColor(Theme.getColor(i));
        this.editText.setGravity(LocaleController.isRTL ? 5 : 3);
        addView(this.editText, LayoutHelper.createFrame(-1, -2.0f, 16, 8.0f, 8.0f, 80.0f, 8.0f));
        this.editText.setFilters(new InputFilter[]{InputFilterHelper.getFilter(2200, 64, this.editText)[0], new InputFilter() { // from class: ir.resaneh1.iptv.fragment.rubino.AddPostCaptionView.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                if (charSequence == null || TextUtils.indexOf(charSequence, '#') == -1 || spanned.length() - spanned.toString().replace("#", BuildConfig.FLAVOR).length() < 15) {
                    return null;
                }
                EditTextBoldCursor editTextBoldCursor3 = AddPostCaptionView.this.editText;
                if (editTextBoldCursor3 != null) {
                    AndroidUtilities.shakeView(editTextBoldCursor3, 2.0f, 0);
                }
                return BuildConfig.FLAVOR;
            }
        }});
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(getPaddingLeft(), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.getDividerPaint());
        }
    }

    public void setPost(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        this.imageView.setImageBitmap(rubinoSendingPost.entryList.get(0).thumbBitmap);
        this.imageViewMulti.setVisibility(4);
        this.imageViewVideo.setVisibility(4);
        if (rubinoSendingPost.isMulti()) {
            this.imageViewMulti.setVisibility(0);
            return;
        }
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList = rubinoSendingPost.entryList;
        if (arrayList == null || arrayList.size() <= 0 || !rubinoSendingPost.entryList.get(0).isVideo) {
            return;
        }
        this.imageViewVideo.setVisibility(0);
    }
}
