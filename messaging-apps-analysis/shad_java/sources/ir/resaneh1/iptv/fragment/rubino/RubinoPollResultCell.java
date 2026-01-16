package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.messanger.PollResultProfileActivity;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryPollObject;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoPollResultCell extends FrameLayout {
    public FrameLayout divider;
    public FrameLayout divider2;
    private ImageView imageView;
    public StoryPollObject pollObject;
    private TextView pollResultText;
    private TextView seeVotersText;
    public FrameLayout seeVotersView;
    private OnShareClickListener shareClickListener;
    private TextView shareText;
    public StoryObject storyObject;
    private TextView textViewLeft;
    private TextView textViewLeftNum;
    private TextView textViewRight;
    private TextView textViewRightNum;

    public interface OnShareClickListener {
        void onShareClick(StoryObject storyObject);
    }

    public void setOnShareClick(OnShareClickListener onShareClickListener) {
        this.shareClickListener = onShareClickListener;
    }

    public RubinoPollResultCell(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.poll_result_cell, (ViewGroup) null);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f, 5, 8.0f, 8.0f, 16.0f, 8.0f));
        this.textViewLeft = (TextView) viewInflate.findViewById(R.id.textViewLeftText);
        this.textViewRight = (TextView) viewInflate.findViewById(R.id.textViewRightText);
        this.textViewLeftNum = (TextView) viewInflate.findViewById(R.id.textViewLeftNumber);
        this.textViewRightNum = (TextView) viewInflate.findViewById(R.id.textViewRightNumber);
        this.seeVotersView = (FrameLayout) viewInflate.findViewById(R.id.seeVotersView);
        this.pollResultText = (TextView) viewInflate.findViewById(R.id.textView1);
        this.seeVotersText = (TextView) viewInflate.findViewById(R.id.textView2);
        this.shareText = (TextView) viewInflate.findViewById(R.id.textViewShare);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.divider = (FrameLayout) viewInflate.findViewById(R.id.divider);
        this.divider2 = (FrameLayout) viewInflate.findViewById(R.id.divider2);
        this.seeVotersView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPollResultCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        TextView textView = this.textViewLeft;
        int i = Theme.key_rubinoGrayColor;
        textView.setTextColor(Theme.getColor(i));
        this.textViewRight.setTextColor(Theme.getColor(i));
        TextView textView2 = this.pollResultText;
        int i2 = Theme.key_rubinoBlackColor;
        textView2.setTextColor(Theme.getColor(i2));
        this.seeVotersText.setTextColor(Theme.getColor(i2));
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP));
        this.divider.setBackgroundColor(Theme.getColor(i));
        this.divider.setAlpha(0.5f);
        this.divider2.setBackgroundColor(Theme.getColor(i));
        this.divider2.setAlpha(0.5f);
        this.textViewLeft.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewRight.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewLeftNum.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewRightNum.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.pollResultText.setTypeface(Theme.getRubinoTypeFaceBold());
        this.seeVotersText.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.shareText.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.shareText.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoPollResultCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RubinoPollResultCell.this.shareClickListener != null) {
                    RubinoPollResultCell.this.shareClickListener.onShareClick(RubinoPollResultCell.this.storyObject);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.getLastFragment().presentFragment(new PollResultProfileActivity(this.storyObject, 0));
        }
    }

    public void setData(StoryObject storyObject) {
        String str;
        this.storyObject = storyObject;
        StoryPollObject pollIfExist = storyObject.getPollIfExist();
        this.pollObject = pollIfExist;
        String str2 = "0";
        if (pollIfExist != null) {
            TextView textView = this.textViewLeft;
            ArrayList<String> arrayList = pollIfExist.choices_list;
            textView.setText((arrayList == null || arrayList.size() <= 0) ? BuildConfig.FLAVOR : LocaleController.getString(R.string.rubinoVoteFor).replace("%1$s", this.pollObject.choices_list.get(0)));
            TextView textView2 = this.textViewRight;
            ArrayList<String> arrayList2 = this.pollObject.choices_list;
            textView2.setText((arrayList2 == null || arrayList2.size() <= 1) ? BuildConfig.FLAVOR : LocaleController.getString(R.string.rubinoVoteFor).replace("%1$s", this.pollObject.choices_list.get(1)));
            TextView textView3 = this.textViewLeftNum;
            ArrayList<Integer> arrayList3 = this.pollObject.choices_count_list;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                str = "0";
            } else {
                str = this.pollObject.choices_count_list.get(0) + BuildConfig.FLAVOR;
            }
            textView3.setText(str);
            TextView textView4 = this.textViewRightNum;
            ArrayList<Integer> arrayList4 = this.pollObject.choices_count_list;
            if (arrayList4 != null && arrayList4.size() > 1) {
                str2 = this.pollObject.choices_count_list.get(1) + BuildConfig.FLAVOR;
            }
            textView4.setText(str2);
            if (this.pollObject.answer_count > 0) {
                this.seeVotersView.setVisibility(0);
                return;
            } else {
                this.seeVotersView.setVisibility(8);
                return;
            }
        }
        this.seeVotersView.setVisibility(8);
        this.textViewLeft.setText(BuildConfig.FLAVOR);
        this.textViewRight.setText(BuildConfig.FLAVOR);
        this.textViewLeftNum.setText("0");
        this.textViewRightNum.setText("0");
    }
}
