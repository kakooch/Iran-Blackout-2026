package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.StoryProgressBar;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.R;

/* loaded from: classes3.dex */
public class StoriesProgressView extends LinearLayout {
    private final LinearLayout.LayoutParams PROGRESS_BAR_LAYOUT_PARAM;
    private final LinearLayout.LayoutParams SPACE_LAYOUT_PARAM;
    private int current;
    boolean isComplete;
    private boolean isReverseStart;
    private boolean isSkipStart;
    public boolean isStarted;
    private final ArrayList<StoryProgressBar> progressBars;
    public int storiesCount;
    private StoriesListener storiesListener;

    public interface StoriesListener {
        void onComplete(boolean z);

        void onNext(boolean z);

        void onPrev();
    }

    public StoriesProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PROGRESS_BAR_LAYOUT_PARAM = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.SPACE_LAYOUT_PARAM = new LinearLayout.LayoutParams(5, -2);
        this.progressBars = new ArrayList<>();
        this.storiesCount = -1;
        this.current = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoriesProgressView);
        this.storiesCount = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        bindViews();
    }

    private void bindViews() {
        destroy();
        int i = 0;
        while (i < this.storiesCount) {
            StoryProgressBar storyProgressBarCreateProgressBar = createProgressBar();
            MyLog.e("StoryProgressBar", "create " + storyProgressBarCreateProgressBar);
            this.progressBars.add(storyProgressBarCreateProgressBar);
            storyProgressBarCreateProgressBar.setScaleX(-1.0f);
            addView(storyProgressBarCreateProgressBar);
            i++;
            if (i < this.storiesCount) {
                addView(createSpace());
            }
        }
    }

    private StoryProgressBar createProgressBar() {
        StoryProgressBar storyProgressBar = new StoryProgressBar(getContext());
        storyProgressBar.setLayoutParams(this.PROGRESS_BAR_LAYOUT_PARAM);
        return storyProgressBar;
    }

    private View createSpace() {
        View view = new View(getContext());
        view.setLayoutParams(this.SPACE_LAYOUT_PARAM);
        return view;
    }

    public void setStoriesListener(StoriesListener storiesListener) {
        this.storiesListener = storiesListener;
    }

    public void skip() {
        StoryProgressBar.PausableScaleAnimation pausableScaleAnimation;
        if (this.isSkipStart || this.isReverseStart || this.isComplete) {
            return;
        }
        int i = this.current;
        if (i < 0) {
            i = 0;
        }
        this.isSkipStart = true;
        if (i < this.progressBars.size() && (pausableScaleAnimation = this.progressBars.get(i).animation) != null) {
            pausableScaleAnimation.setAnimationListener(null);
            pausableScaleAnimation.cancel();
        }
        callback(i).onFinishProgress(true);
    }

    public void reverse() {
        if (this.isSkipStart || this.isReverseStart || this.isComplete) {
            return;
        }
        int i = this.current;
        if (i < 0) {
            i = 0;
        }
        this.isReverseStart = true;
        callback(i).onFinishProgress(false);
    }

    public void setStoryDuration(long j) {
        for (int i = 0; i < this.progressBars.size(); i++) {
            this.progressBars.get(i).setDuration(j);
            this.progressBars.get(i).setCallback(callback(i));
        }
    }

    public void setStoriesCountWithDurations(StoryListOfAProfileObject storyListOfAProfileObject) {
        ArrayList<StoryController.StoryIdObject> arrayList;
        destroy();
        StoryController.ProfileStoryInfo profileStoryInfo = storyListOfAProfileObject.info;
        if (profileStoryInfo != null && (arrayList = profileStoryInfo.storyIdsObject) != null) {
            this.storiesCount = arrayList.size();
            bindViews();
            for (int i = 0; i < this.progressBars.size(); i++) {
                this.progressBars.get(i).setDuration(storyListOfAProfileObject.getCurrentStoryObject() != null ? storyListOfAProfileObject.getCurrentStoryObject().getDuration() : 5000L);
                this.progressBars.get(i).setCallback(callback(i));
            }
            return;
        }
        this.storiesCount = 0;
        bindViews();
    }

    private StoryProgressBar.Callback callback(final int i) {
        return new StoryProgressBar.Callback() { // from class: ir.resaneh1.iptv.helper.StoriesProgressView.1
            @Override // ir.resaneh1.iptv.helper.StoryProgressBar.Callback
            public void onStartProgress() {
                StoriesProgressView.this.current = i;
            }

            @Override // ir.resaneh1.iptv.helper.StoryProgressBar.Callback
            public void onFinishProgress(boolean z) {
                if (StoriesProgressView.this.isReverseStart) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onPrev();
                    }
                    int unused = StoriesProgressView.this.current;
                    StoriesProgressView.this.isReverseStart = false;
                    return;
                }
                if (StoriesProgressView.this.current + 1 <= StoriesProgressView.this.progressBars.size() - 1) {
                    if (StoriesProgressView.this.storiesListener != null) {
                        StoriesProgressView.this.storiesListener.onNext(z);
                    }
                } else if (StoriesProgressView.this.storiesListener != null) {
                    StoriesProgressView.this.storiesListener.onComplete(z);
                }
                StoriesProgressView.this.isSkipStart = false;
            }
        };
    }

    public void startStories(int i) {
        startStories(i, 0.0f);
    }

    public void startStories(int i, float f) {
        initProgress(i);
        this.isStarted = true;
        if (i < this.progressBars.size()) {
            this.progressBars.get(i).startProgress(f);
        }
    }

    public void initProgress(int i) {
        this.isComplete = false;
        this.isReverseStart = false;
        this.isSkipStart = false;
        this.isStarted = false;
        for (int i2 = 0; i2 < this.storiesCount; i2++) {
            if (i2 < i) {
                this.progressBars.get(i2).setMaxWithoutCallback();
            } else {
                this.progressBars.get(i2).setMinWithoutCallback();
            }
        }
    }

    public void destroy() {
        Iterator<StoryProgressBar> it = this.progressBars.iterator();
        while (it.hasNext()) {
            StoryProgressBar next = it.next();
            MyLog.e("StoryProgressBar", "destroy " + next);
            next.clear();
        }
        this.progressBars.clear();
        removeAllViews();
    }

    public void pause() {
        int i = this.current;
        if (i < 0 || i >= this.progressBars.size()) {
            return;
        }
        this.progressBars.get(this.current).pauseProgress();
    }

    public void resume() {
        int i = this.current;
        if (i < 0 || i >= this.progressBars.size()) {
            return;
        }
        if (this.isStarted) {
            this.progressBars.get(this.current).resumeProgress();
        } else {
            startStories(this.current);
        }
    }
}
