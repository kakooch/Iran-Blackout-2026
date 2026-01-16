package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.StoryTextAttributeObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class UI_rubinoHashTagCell {
    public StoryTextAttributeObject attributeObject;
    public FrameLayout frameLayout;
    public TextView textView;
    public View view;

    public View createView(Activity activity) {
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        frameLayout.setTag(this);
        TextView textView = new TextView(activity);
        this.textView = textView;
        textView.setTextColor(-1);
        this.textView.setGravity(16);
        this.attributeObject = new StoryTextAttributeObject(StoryTextAttributeObject.BackGroundType.roundFrost, StoryTextAttributeObject.TextFontEnum.classic, StoryTextAttributeObject.TextAlignmentEnum.center, 18, -1, StoryTextAttributeObject.TextColorTypeEnum.simple);
        this.textView.setTextSize(1, r9.textSizeInDp);
        this.textView.setTypeface(this.attributeObject.getTypeFace());
        this.textView.setBackground(this.attributeObject.getHashtagBackground());
        this.textView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.frameLayout.addView(this.textView, LayoutHelper.createFrame(-2, 40, 17));
        return this.view;
    }

    public void setText(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        this.textView.setText(str);
        this.textView.requestLayout();
    }

    public String getText() {
        return this.textView.getText().toString();
    }
}
