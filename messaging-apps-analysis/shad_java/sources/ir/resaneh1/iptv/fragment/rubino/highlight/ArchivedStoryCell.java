package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.appp.common.utils.AndroidUtilities;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.StoryObject;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;

/* loaded from: classes3.dex */
public class ArchivedStoryCell extends FrameLayout {
    private final CheckBox2 checkBox;
    private final Context context;
    private ArchivedStoryDelegate delegate;
    private final View hoverView;
    private final ImageView imageView;
    private StoryObject item;
    private final TextView textView;
    private final int width;

    public interface ArchivedStoryDelegate {
        void onItemClick(ArchivedStoryCell archivedStoryCell, StoryObject storyObject);
    }

    public ArchivedStoryCell(Context context, int i) {
        super(context);
        this.context = context;
        setWillNotDraw(false);
        this.width = i;
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        addView(imageView, LayoutHelper.createFrame(-1, -1));
        View view = new View(context);
        this.hoverView = view;
        view.setBackgroundColor(Color.parseColor("#2D000000"));
        view.setVisibility(8);
        addView(view, LayoutHelper.createFrame(-1, -1));
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTypeface(Theme.getRubinoTypeFaceBold());
        textView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f));
        textView.setGravity(17);
        textView.setTextColor(-16777216);
        textView.setTextSize(11.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setBackground(context.getResources().getDrawable(R.drawable.rubino_shape_white_rectangle));
        addView(textView, LayoutHelper.createFrame(48, 48, 51, 12.0f, 12.0f, 0.0f, 0.0f));
        CheckBox2 checkBox2 = new CheckBox2(context, 24);
        this.checkBox = checkBox2;
        checkBox2.setDrawBackgroundAsArc(7);
        checkBox2.setColor(Theme.key_rubino_add_postCheckBoxBackground, Theme.key_rubino_add_post_photoPlaceholder, Theme.key_rubino_add_post_CheckBoxCheck);
        addView(checkBox2, LayoutHelper.createFrame(26, 26, 85, 0.0f, 0.0f, 12.0f, 4.0f));
        checkBox2.setVisibility(0);
        setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f));
        setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchivedStoryCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        StoryObject storyObject;
        ArchivedStoryDelegate archivedStoryDelegate = this.delegate;
        if (archivedStoryDelegate == null || (storyObject = this.item) == null) {
            return;
        }
        archivedStoryDelegate.onItemClick(this, storyObject);
    }

    public void setDelegate(ArchivedStoryDelegate archivedStoryDelegate) {
        this.delegate = archivedStoryDelegate;
    }

    public void setData(StoryObject storyObject, boolean z) {
        if (storyObject == null) {
            return;
        }
        setChecked(z, false);
        this.item = storyObject;
        long j = storyObject.create_date * 1000;
        String monthKeyPersian = DateFormatUtils.getMonthKeyPersian(j);
        this.textView.setText(String.valueOf(DateFormatUtils.getPersianDayOfMonth(j)) + " \n" + monthKeyPersian);
        String str = storyObject.full_thumbnail_url;
        if (str == null) {
            str = storyObject.full_snapshot_url;
        }
        GlideHelper.load(this.context, this.imageView, str, R.drawable.rubino_shape_white_rectangle);
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    public void setChecked(boolean z, boolean z2) {
        this.checkBox.setChecked(z, z2);
        this.hoverView.setVisibility(isChecked() ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.width;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (i3 * 2.0f), 1073741824));
    }
}
