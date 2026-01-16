package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PostCommentInSharePostCell extends FrameLayout {
    private EditTextBoldCursor commentTextView;
    public ImageView imageViewPost;
    public Context mContext;

    public PostCommentInSharePostCell(Context context) {
        super(context);
        this.mContext = context;
        ImageView imageView = new ImageView(context);
        this.imageViewPost = imageView;
        addView(imageView, LayoutHelper.createFrame(44, 44.0f, 21, 0.0f, 4.0f, 2.0f, 4.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.commentTextView = editTextBoldCursor;
        editTextBoldCursor.setHint(LocaleController.getString("ShareComment", R.string.ShareComment));
        this.commentTextView.setMaxLines(1);
        this.commentTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.commentTextView.setSingleLine(true);
        this.commentTextView.setGravity(21);
        this.commentTextView.setTextSize(2, 15.0f);
        this.commentTextView.setBackgroundDrawable(null);
        this.commentTextView.setHintTextColor(Theme.getColor(Theme.key_dialogTextHint));
        this.commentTextView.setImeOptions(268435456);
        this.commentTextView.setInputType(16385);
        EditTextBoldCursor editTextBoldCursor2 = this.commentTextView;
        int i = Theme.key_dialogTextBlack;
        editTextBoldCursor2.setCursorColor(Theme.getColor(i));
        this.commentTextView.setCursorSize(AndroidUtilities.dp(20.0f));
        this.commentTextView.setCursorWidth(1.5f);
        this.commentTextView.setTextColor(Theme.getColor(i));
        addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 21, 8.0f, 1.0f, 54.0f, 0.0f));
        setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
    }

    public void setData(String str, String str2) {
        EditTextBoldCursor editTextBoldCursor = this.commentTextView;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        editTextBoldCursor.setText(str2);
        GlideHelper.loadRoundedCorner(this.mContext, this.imageViewPost, str, R.drawable.shape_grey_rectangle);
    }

    public String getText() {
        return this.commentTextView.getText().toString();
    }
}
