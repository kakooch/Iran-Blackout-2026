package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.EmojiSliderObject;
import ir.resaneh1.iptv.model.StoryObject;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoEmojiSliderResultCell extends FrameLayout {
    private View divider;
    public EmojiSliderObject emojiSliderObject;
    private ImageView imageView;
    public Context mContext;
    private View seeAnswersView;
    private FrameLayout seekbarContainer;
    private EmojiSliderSeekBarView seekbarView;
    public StoryObject storyObject;
    private TextView textView;
    private TextView textViewEmoji;
    private TextView textviewResult;
    private TextView textviewSeeAnswers;

    public RubinoEmojiSliderResultCell(Context context) {
        super(context);
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.emoji_slider_result_cell, (ViewGroup) null);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f, 5, 8.0f, 8.0f, 16.0f, 8.0f));
        this.seekbarContainer = (FrameLayout) viewInflate.findViewById(R.id.seekbarContainer);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textViewEmoji = (TextView) viewInflate.findViewById(R.id.textViewEmoji);
        this.textviewResult = (TextView) viewInflate.findViewById(R.id.textView1);
        this.textviewSeeAnswers = (TextView) viewInflate.findViewById(R.id.textView2);
        this.seeAnswersView = viewInflate.findViewById(R.id.seeAnswersView);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.divider = viewInflate.findViewById(R.id.divider);
        this.seekbarView = new EmojiSliderSeekBarView(this.mContext, 200, true);
        this.seekbarContainer.setClipChildren(false);
        this.seekbarContainer.setClipToPadding(false);
        this.seekbarContainer.addView(this.seekbarView, LayoutHelper.createFrame(200, 16, 3));
        View view = this.divider;
        int i = Theme.key_rubinoGrayColor;
        view.setBackgroundColor(Theme.getColor(i));
        this.divider.setAlpha(0.5f);
        this.textView.setTextColor(Theme.getColor(i));
        TextView textView = this.textviewResult;
        int i2 = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i2));
        this.textviewSeeAnswers.setTextColor(Theme.getColor(i2));
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textviewResult.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textviewSeeAnswers.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.seeAnswersView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoEmojiSliderResultCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new RubinoStoryWidgetResultListActivity(RubinoEmojiSliderResultCell.this.storyObject, RubinoStoryWidgetResultListActivity.type_emojiSlider));
                }
            }
        });
    }

    public void setData(StoryObject storyObject) {
        this.storyObject = storyObject;
        EmojiSliderObject emojiSliderIfExist = storyObject.getEmojiSliderIfExist();
        this.emojiSliderObject = emojiSliderIfExist;
        if (emojiSliderIfExist != null) {
            this.seekbarView.setProgress((int) (emojiSliderIfExist.average_float_answer * 100.0f));
            this.textViewEmoji.setText(this.emojiSliderObject.emoji_char);
            if (this.emojiSliderObject.answer_count > 0) {
                this.seeAnswersView.setVisibility(0);
                this.textView.setText(LocaleController.getString(R.string.rubinoEmojiSliderResultCount).replace("%1$s", NumberUtils.toPersian(this.emojiSliderObject.answer_count)).replace("%2$s", this.emojiSliderObject.answer_count > 1 ? "اند" : "است"));
            } else {
                this.seeAnswersView.setVisibility(8);
                this.textView.setText(LocaleController.getString(R.string.rubinoEmojiSliderResultCountZero));
            }
            ((LinearLayout.LayoutParams) this.textViewEmoji.getLayoutParams()).rightMargin = Math.max(0, (int) (((((this.seekbarContainer.getWidth() - this.seekbarView.seekBar.getPaddingRight()) - this.seekbarView.seekBar.getPaddingLeft()) * ((this.seekbarView.seekBar.getProgress() * 1.0f) / 100.0f)) - (this.textViewEmoji.getWidth() / 2)) + this.seekbarView.seekBar.getPaddingRight()));
            return;
        }
        this.seeAnswersView.setVisibility(8);
        this.seekbarView.setProgress(0);
        this.textView.setText(BuildConfig.FLAVOR);
        this.textViewEmoji.setText(BuildConfig.FLAVOR);
    }
}
