package ir.resaneh1.iptv.UIView;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UI_rubinoEmojiPickerCell extends FrameLayout {
    private CharSequence emojiChar;
    public TextView textView;

    public UI_rubinoEmojiPickerCell(Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(context.getResources().getColor(R.color.grey_900));
        this.textView.setTextSize(2, 22.0f);
        this.textView.setGravity(17);
        addView(this.textView);
    }

    public void setEmoji(CharSequence charSequence) {
        this.emojiChar = charSequence;
        this.textView.setText(charSequence);
    }

    public CharSequence getEmojiChar() {
        return this.emojiChar;
    }
}
