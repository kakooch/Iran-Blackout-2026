package ir.resaneh1.iptv.story.poll;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.MovementMethod;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.stetho.websocket.CloseCodes;
import ir.resaneh1.iptv.story.poll.PollView;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class PollAddStoryView extends FrameLayout {
    public static int HINT_COLOR = -6447971;
    public static int WHITE = -1;
    private FrameLayout.LayoutParams editTextLayoutParams;
    private String hint;
    private KeyListener keyListener;
    private PollView.PollAddStoryMode mode;
    private MovementMethod movementMethod;
    private int paddingTVHeight;
    private int paddingTVWidth;
    private FrameLayout.LayoutParams pollLayoutParams;
    private EditText pollTitleEditText;
    private PollView pollView;
    private int textSize;
    private int titleWidth;

    public boolean onClick(float f, float f2) {
        return false;
    }

    public PollAddStoryView(Context context, PollView.PollAddStoryMode pollAddStoryMode) {
        super(context);
        this.hint = "Ask a question...";
        this.textSize = 25;
        this.titleWidth = AndroidUtilities.dp(380.0f);
        this.paddingTVWidth = AndroidUtilities.dp(8.0f);
        this.paddingTVHeight = AndroidUtilities.dp(4.0f);
        init(pollAddStoryMode);
    }

    private void init(PollView.PollAddStoryMode pollAddStoryMode) {
        setClipChildren(false);
        setClipToPadding(false);
        initPollTitleEditText();
        initPoll(pollAddStoryMode);
        addViews();
        setMode(pollAddStoryMode);
    }

    public void setMode(PollView.PollAddStoryMode pollAddStoryMode) {
        this.mode = pollAddStoryMode;
        this.pollTitleEditText.setVisibility(0);
        this.pollView.setMode(this.mode);
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode[this.mode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                enableTitleEditText();
                return;
            }
        } else if (this.pollTitleEditText.getText().toString().isEmpty()) {
            this.pollTitleEditText.setVisibility(4);
        }
        disableTitleEditText();
    }

    /* renamed from: ir.resaneh1.iptv.story.poll.PollAddStoryView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode;

        static {
            int[] iArr = new int[PollView.PollAddStoryMode.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode = iArr;
            try {
                iArr[PollView.PollAddStoryMode.LOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode[PollView.PollAddStoryMode.STORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$poll$PollView$PollAddStoryMode[PollView.PollAddStoryMode.EDIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void enableTitleEditText() {
        this.pollTitleEditText.setMaxLines(3);
        this.pollTitleEditText.setEnabled(true);
        this.pollTitleEditText.setFocusableInTouchMode(true);
        MovementMethod movementMethod = this.movementMethod;
        if (movementMethod != null) {
            this.pollTitleEditText.setMovementMethod(movementMethod);
        }
        KeyListener keyListener = this.keyListener;
        if (keyListener != null) {
            this.pollTitleEditText.setKeyListener(keyListener);
        }
    }

    private void disableTitleEditText() {
        this.pollTitleEditText.setMaxLines(CloseCodes.NORMAL_CLOSURE);
        this.pollTitleEditText.setEnabled(false);
        this.movementMethod = this.pollTitleEditText.getMovementMethod();
        this.keyListener = this.pollTitleEditText.getKeyListener();
        this.pollTitleEditText.setMovementMethod(null);
        this.pollTitleEditText.setKeyListener(null);
    }

    private void initPoll(PollView.PollAddStoryMode pollAddStoryMode) {
        this.pollView = new PollView(getContext(), pollAddStoryMode);
        this.pollLayoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
    }

    private void initPollTitleEditText() {
        EditText editText = new EditText(getContext());
        this.pollTitleEditText = editText;
        editText.setHint(this.hint);
        if (Build.VERSION.SDK_INT >= 17) {
            this.pollTitleEditText.setTextAlignment(4);
        }
        this.pollTitleEditText.setHintTextColor(HINT_COLOR);
        this.pollTitleEditText.setTextSize(1, this.textSize);
        this.pollTitleEditText.setTextColor(WHITE);
        this.pollTitleEditText.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        EditText editText2 = this.pollTitleEditText;
        int i = this.paddingTVWidth;
        int i2 = this.paddingTVHeight;
        editText2.setPadding(i, i2, i, i2);
        this.pollTitleEditText.setMaxLines(3);
        this.pollTitleEditText.setBackgroundColor(0);
        this.pollTitleEditText.setMaxWidth(this.titleWidth);
        this.pollTitleEditText.setInputType(655361);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
        this.editTextLayoutParams = layoutParams;
        layoutParams.bottomMargin = AndroidUtilities.dp(90.0f);
    }

    private void addViews() {
        addView(this.pollTitleEditText, this.editTextLayoutParams);
        addView(this.pollView, this.pollLayoutParams);
    }

    public String getPollTitle() {
        return this.pollTitleEditText.getText().toString();
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

    public void setPollTitle(String str) {
        this.pollTitleEditText.setText(str);
        if (str == null || str.isEmpty()) {
            return;
        }
        this.pollTitleEditText.setVisibility(0);
    }

    public PollView.PollAddStoryMode getMode() {
        return this.mode;
    }

    public EditText getPollTitleEditText() {
        return this.pollTitleEditText;
    }

    public int getPollViewOffsetY() {
        return getHeight() - PollView.getPollHeight();
    }

    public int getPollViewOffsetX() {
        return (getWidth() / 2) - (PollView.getPollWidth() / 2);
    }

    public int getPollHeight() {
        return PollView.getPollHeight();
    }

    public int getPollWidth() {
        return PollView.getPollWidth();
    }
}
