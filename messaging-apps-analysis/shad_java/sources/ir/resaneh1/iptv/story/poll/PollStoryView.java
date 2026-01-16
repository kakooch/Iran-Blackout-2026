package ir.resaneh1.iptv.story.poll;

import android.content.Context;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.story.poll.PollView;

/* loaded from: classes4.dex */
public class PollStoryView extends FrameLayout {
    private FrameLayout.LayoutParams pollLayoutParams;
    private PollView pollView;

    public PollStoryView(Context context, PollView.PollAddStoryMode pollAddStoryMode) {
        super(context);
        init(pollAddStoryMode);
    }

    private void init(PollView.PollAddStoryMode pollAddStoryMode) {
        this.pollView = new PollView(getContext(), pollAddStoryMode);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.pollLayoutParams = layoutParams;
        addView(this.pollView, layoutParams);
    }

    public void setLefPercentage(int i, boolean z, PollView.PollOption pollOption) {
        this.pollView.setLeftHolderPercentage(i, z, pollOption);
    }

    public String getOptionLeft() {
        return this.pollView.getOptionLeft();
    }

    public String getOptionRight() {
        return this.pollView.getOptionRight();
    }

    public void setOptionLeft(String str) {
        this.pollView.setOptionLeft(str);
    }

    public void setOptionRight(String str) {
        this.pollView.setOptionRight(str);
    }

    public void setClickListener(PollView.PollClickListener pollClickListener) {
        PollView pollView = this.pollView;
        if (pollView != null) {
            pollView.setClickListener(pollClickListener);
        }
    }

    public int getPollHeight() {
        return this.pollView.getHeight();
    }

    public int getPollWidth() {
        return this.pollView.getWidth();
    }

    public boolean onClick(float f, float f2) {
        return this.pollView.onClick(f, f2);
    }
}
