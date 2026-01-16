package androidMessenger.utilites;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.appp.rghapp.RGHMediaHelper$AudioEntry;
import ir.medu.shad.R;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes.dex */
public class AudioCell extends FrameLayout {
    private RGHMediaHelper$AudioEntry audioEntry;
    private TextView authorTextView;
    private CheckBox checkBox;
    private TextView genreTextView;
    private boolean needDivider;
    private ImageView playButton;
    private TextView timeTextView;
    private TextView titleTextView;

    public interface AudioCellDelegate {
    }

    public void setDelegate(AudioCellDelegate audioCellDelegate) {
    }

    public AudioCell(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.playButton = imageView;
        boolean z = LocaleController.isRTL;
        addView(imageView, LayoutHelper.createFrame(46, 46.0f, (z ? 5 : 3) | 48, z ? 0.0f : 13.0f, 13.0f, z ? 13.0f : 0.0f, 0.0f));
        this.playButton.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.AudioCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f$0.lambda$new$0(view);
            }
        });
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.titleTextView.setTextSize(1, 16.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.titleTextView.setLines(1);
        this.titleTextView.setMaxLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view = this.titleTextView;
        boolean z2 = LocaleController.isRTL;
        addView(view, LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 50.0f : 72.0f, 7.0f, z2 ? 72.0f : 50.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.genreTextView = textView2;
        textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.genreTextView.setTextSize(1, 14.0f);
        this.genreTextView.setLines(1);
        this.genreTextView.setMaxLines(1);
        this.genreTextView.setSingleLine(true);
        this.genreTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.genreTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view2 = this.genreTextView;
        boolean z3 = LocaleController.isRTL;
        addView(view2, LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 50.0f : 72.0f, 28.0f, z3 ? 72.0f : 50.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.authorTextView = textView3;
        textView3.setTextColor(-7697782);
        this.authorTextView.setTextSize(1, 14.0f);
        this.authorTextView.setLines(1);
        this.authorTextView.setMaxLines(1);
        this.authorTextView.setSingleLine(true);
        this.authorTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.authorTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        View view3 = this.authorTextView;
        boolean z4 = LocaleController.isRTL;
        addView(view3, LayoutHelper.createFrame(-1, -2.0f, (z4 ? 5 : 3) | 48, z4 ? 50.0f : 72.0f, 44.0f, z4 ? 72.0f : 50.0f, 0.0f));
        TextView textView4 = new TextView(context);
        this.timeTextView = textView4;
        textView4.setTextColor(-6710887);
        this.timeTextView.setTextSize(1, 13.0f);
        this.timeTextView.setLines(1);
        this.timeTextView.setMaxLines(1);
        this.timeTextView.setSingleLine(true);
        this.timeTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.timeTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 48);
        View view4 = this.timeTextView;
        boolean z5 = LocaleController.isRTL;
        addView(view4, LayoutHelper.createFrame(-2, -2.0f, (z5 ? 3 : 5) | 48, z5 ? 18.0f : 0.0f, 11.0f, z5 ? 0.0f : 18.0f, 0.0f));
        CheckBox checkBox = new CheckBox(context, R.drawable.round_check2);
        this.checkBox = checkBox;
        checkBox.setVisibility(0);
        this.checkBox.setColor(-14043401, -1);
        View view5 = this.checkBox;
        boolean z6 = LocaleController.isRTL;
        addView(view5, LayoutHelper.createFrame(22, 22.0f, (z6 ? 3 : 5) | 48, z6 ? 18.0f : 0.0f, 39.0f, z6 ? 0.0f : 18.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) throws Resources.NotFoundException {
        if (this.audioEntry != null) {
            setPlayDrawable(false);
        }
    }

    private void setPlayDrawable(boolean z) throws Resources.NotFoundException {
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(46.0f), -10702870, -10702870);
        Drawable drawable = getResources().getDrawable(z ? R.drawable.audiosend_pause : R.drawable.audiosend_play);
        drawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable = new CombinedDrawable(drawableCreateSimpleSelectorCircleDrawable, drawable);
        combinedDrawable.setCustomSize(AndroidUtilities.dp(46.0f), AndroidUtilities.dp(46.0f));
        this.playButton.setBackgroundDrawable(combinedDrawable);
    }

    public ImageView getPlayButton() {
        return this.playButton;
    }

    public TextView getTitleTextView() {
        return this.titleTextView;
    }

    public TextView getGenreTextView() {
        return this.genreTextView;
    }

    public TextView getTimeTextView() {
        return this.timeTextView;
    }

    public TextView getAuthorTextView() {
        return this.authorTextView;
    }

    public CheckBox getCheckBox() {
        return this.checkBox;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(72.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setAudio(RGHMediaHelper$AudioEntry rGHMediaHelper$AudioEntry, boolean z, boolean z2) throws Resources.NotFoundException {
        this.audioEntry = rGHMediaHelper$AudioEntry;
        this.titleTextView.setText(rGHMediaHelper$AudioEntry.title);
        this.genreTextView.setText(this.audioEntry.genre);
        this.authorTextView.setText(this.audioEntry.author);
        this.timeTextView.setText(String.format(Locale.US, "%d:%02d", Integer.valueOf(this.audioEntry.duration / 60), Integer.valueOf(this.audioEntry.duration % 60)));
        setPlayDrawable(false);
        this.needDivider = z;
        setWillNotDraw(!z);
        this.checkBox.setChecked(z2, false);
    }

    public void setChecked(boolean z) {
        this.checkBox.setChecked(z, true);
    }

    public RGHMediaHelper$AudioEntry getAudioEntry() {
        return this.audioEntry;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(AndroidUtilities.dp(72.0f), getHeight() - 1, getWidth(), getHeight() - 1, Theme.dividerPaint);
        }
    }
}
