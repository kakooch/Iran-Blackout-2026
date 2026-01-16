package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import ir.medu.shad.R;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class EmojiSliderSeekBarView extends FrameLayout {
    public SeekBar seekBar;
    private View seekbarView;

    public EmojiSliderSeekBarView(Context context, int i, boolean z) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.story_emoji_slider_result_seekbar, (ViewGroup) null, false);
        this.seekbarView = viewGroup;
        addView(viewGroup, LayoutHelper.createFrame(i, 12.0f));
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        this.seekBar = seekBar;
        seekBar.setEnabled(!z);
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.seekBar.setProgress(i);
    }
}
