package ir.resaneh1.iptv.story.poll;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.story.poll.PollView;

/* loaded from: classes4.dex */
public class PollSticker extends FrameLayout {
    private PollAddStoryView pollAddStoryView;
    FrameLayout.LayoutParams pollParams;
    private PollPreview pollPreview;
    private final PollStickerMode pollStickerMode;
    private PollStoryView pollStoryView;

    public enum PollStickerMode {
        PREVIEW,
        ADD_STORY,
        STORY,
        VOTED,
        SHARE
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
    }

    public PollSticker(Context context, PollStickerMode pollStickerMode) {
        super(context);
        this.pollParams = new FrameLayout.LayoutParams(-2, -2, 17);
        this.pollStickerMode = pollStickerMode;
        init();
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
        addPollPreviewIfNeeded(this.pollStickerMode);
        addPollAddStoryViewIfNeeded(this.pollStickerMode);
        addPollStoryViewIfNeeded(this.pollStickerMode);
    }

    private void addPollStoryViewIfNeeded(PollStickerMode pollStickerMode) {
        if (pollStickerMode == PollStickerMode.STORY || pollStickerMode == PollStickerMode.VOTED || pollStickerMode == PollStickerMode.SHARE) {
            int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[pollStickerMode.ordinal()];
            if (i == 1) {
                this.pollStoryView = new PollStoryView(getContext(), PollView.PollAddStoryMode.STORY);
            } else if (i == 2) {
                this.pollStoryView = new PollStoryView(getContext(), PollView.PollAddStoryMode.VOTED);
            } else if (i == 3) {
                this.pollStoryView = new PollStoryView(getContext(), PollView.PollAddStoryMode.SHARE);
            }
            addView(this.pollStoryView, this.pollParams);
        }
    }

    /* renamed from: ir.resaneh1.iptv.story.poll.PollSticker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode;

        static {
            int[] iArr = new int[PollStickerMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode = iArr;
            try {
                iArr[PollStickerMode.STORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[PollStickerMode.VOTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[PollStickerMode.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[PollStickerMode.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[PollStickerMode.ADD_STORY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void addPollAddStoryViewIfNeeded(PollStickerMode pollStickerMode) {
        if (pollStickerMode == PollStickerMode.ADD_STORY) {
            PollAddStoryView pollAddStoryView = new PollAddStoryView(getContext(), PollView.PollAddStoryMode.EDIT);
            this.pollAddStoryView = pollAddStoryView;
            addView(pollAddStoryView, this.pollParams);
        }
    }

    private void addPollPreviewIfNeeded(PollStickerMode pollStickerMode) {
        if (pollStickerMode == PollStickerMode.PREVIEW) {
            PollPreview pollPreview = new PollPreview(getContext());
            this.pollPreview = pollPreview;
            addView(pollPreview, this.pollParams);
        }
    }

    public boolean onClick(float f, float f2) {
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[this.pollStickerMode.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                if (0.0f > f2 || f2 >= getPollHeight(PollStickerMode.PREVIEW)) {
                    return false;
                }
                return this.pollPreview.onClick(f, f2);
            }
            if (i == 5 && getPollViewOffsetX() <= f) {
                int pollViewOffsetX = getPollViewOffsetX();
                PollStickerMode pollStickerMode = PollStickerMode.ADD_STORY;
                if (f < pollViewOffsetX + getPollWidth(pollStickerMode) && getPollViewOffsetY() <= f2 && f2 < getPollViewOffsetY() + getPollHeight(pollStickerMode)) {
                    return this.pollAddStoryView.onClick(f, f2);
                }
            }
            return false;
        }
        if (0.0f <= f2 && f2 < getPollHeight(PollStickerMode.STORY)) {
            return this.pollStoryView.onClick(f, f2);
        }
        return false;
    }

    public void setPollClickListener(PollView.PollClickListener pollClickListener) {
        PollStoryView pollStoryView = this.pollStoryView;
        if (pollStoryView != null) {
            pollStoryView.setClickListener(pollClickListener);
        }
    }

    public void setPollLeftPercentage(int i, boolean z, PollView.PollOption pollOption) {
        PollStoryView pollStoryView = this.pollStoryView;
        if (pollStoryView != null) {
            pollStoryView.setLefPercentage(i, z, pollOption);
        }
    }

    public String getPollTitle() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getPollTitle();
        }
        return null;
    }

    public String getOptionLeft() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getOptionLeft();
        }
        return null;
    }

    public String getOptionRight() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getOptionRight();
        }
        return null;
    }

    public PollView.PollAddStoryMode getPollAddStoryMode() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getMode();
        }
        return null;
    }

    public void setPollAddStoryMode(PollView.PollAddStoryMode pollAddStoryMode) {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            pollAddStoryView.setMode(pollAddStoryMode);
        }
    }

    public static int getPollWidth(PollStickerMode pollStickerMode) {
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[pollStickerMode.ordinal()];
        if (i != 1) {
            if (i == 4) {
                return PollPreview.getWidthValue();
            }
            if (i != 5) {
                return 0;
            }
        }
        return PollView.getPollWidth();
    }

    public static int getPollHeight(PollStickerMode pollStickerMode) {
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$poll$PollSticker$PollStickerMode[pollStickerMode.ordinal()];
        if (i != 1) {
            if (i == 4) {
                return PollPreview.getHeightValue();
            }
            if (i != 5) {
                return 0;
            }
        }
        return PollView.getPollHeight();
    }

    public void setValues(String str, String str2, String str3) {
        PollStoryView pollStoryView;
        PollAddStoryView pollAddStoryView;
        PollStickerMode pollStickerMode = this.pollStickerMode;
        PollStickerMode pollStickerMode2 = PollStickerMode.ADD_STORY;
        if (pollStickerMode == pollStickerMode2 && (pollAddStoryView = this.pollAddStoryView) != null) {
            pollAddStoryView.setPollTitle(str);
            this.pollAddStoryView.setOptionLeft(str2);
            this.pollAddStoryView.setOptionRight(str3);
        } else {
            if (pollStickerMode == pollStickerMode2 || (pollStoryView = this.pollStoryView) == null) {
                return;
            }
            pollStoryView.setOptionLeft(str2);
            this.pollStoryView.setOptionRight(str3);
        }
    }

    public EditText getDefaultFocusEditText() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getPollTitleEditText();
        }
        return null;
    }

    public int getPollViewOffsetY() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getPollViewOffsetY();
        }
        return 0;
    }

    public int getPollViewOffsetX() {
        PollAddStoryView pollAddStoryView = this.pollAddStoryView;
        if (pollAddStoryView != null) {
            return pollAddStoryView.getPollViewOffsetX();
        }
        return 0;
    }
}
