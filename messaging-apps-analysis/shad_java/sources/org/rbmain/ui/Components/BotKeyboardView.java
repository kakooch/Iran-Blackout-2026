package org.rbmain.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRow;
import org.rbmain.tgnet.TLRPC$TL_replyKeyboardMarkup;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class BotKeyboardView extends LinearLayout {
    private TLRPC$TL_replyKeyboardMarkup botButtons;
    private int buttonHeight;
    private ArrayList<TextView> buttonViews;
    private LinearLayout container;
    private BotKeyboardViewDelegate delegate;
    private boolean isFullSize;
    private int panelHeight;
    private ScrollView scrollView;

    public interface BotKeyboardViewDelegate {
        void didPressedButton(TLRPC$KeyboardButton tLRPC$KeyboardButton);
    }

    public BotKeyboardView(Context context) throws NoSuchFieldException {
        super(context);
        this.buttonViews = new ArrayList<>();
        setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        addView(scrollView);
        LinearLayout linearLayout = new LinearLayout(context);
        this.container = linearLayout;
        linearLayout.setOrientation(1);
        this.scrollView.addView(this.container);
        ScrollView scrollView2 = this.scrollView;
        int i = Theme.key_chat_emojiPanelBackground;
        AndroidUtilities.setScrollViewEdgeEffectColor(scrollView2, Theme.getColor(i));
        setBackgroundColor(Theme.getColor(i));
    }

    public void setDelegate(BotKeyboardViewDelegate botKeyboardViewDelegate) {
        this.delegate = botKeyboardViewDelegate;
    }

    public void setPanelHeight(int i) {
        TLRPC$TL_replyKeyboardMarkup tLRPC$TL_replyKeyboardMarkup;
        this.panelHeight = i;
        if (!this.isFullSize || (tLRPC$TL_replyKeyboardMarkup = this.botButtons) == null || tLRPC$TL_replyKeyboardMarkup.rows.size() == 0) {
            return;
        }
        this.buttonHeight = !this.isFullSize ? 42 : (int) Math.max(42.0f, (((this.panelHeight - AndroidUtilities.dp(30.0f)) - ((this.botButtons.rows.size() - 1) * AndroidUtilities.dp(10.0f))) / this.botButtons.rows.size()) / AndroidUtilities.density);
        int childCount = this.container.getChildCount();
        int iDp = AndroidUtilities.dp(this.buttonHeight);
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.container.getChildAt(i2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (layoutParams.height != iDp) {
                layoutParams.height = iDp;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void invalidateViews() {
        for (int i = 0; i < this.buttonViews.size(); i++) {
            this.buttonViews.get(i).invalidate();
        }
    }

    public boolean isFullSize() {
        return this.isFullSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public void setButtons(TLRPC$TL_replyKeyboardMarkup tLRPC$TL_replyKeyboardMarkup) {
        this.botButtons = tLRPC$TL_replyKeyboardMarkup;
        this.container.removeAllViews();
        this.buttonViews.clear();
        boolean z = false;
        this.scrollView.scrollTo(0, 0);
        if (tLRPC$TL_replyKeyboardMarkup == null || this.botButtons.rows.size() == 0) {
            return;
        }
        boolean z2 = !tLRPC$TL_replyKeyboardMarkup.resize;
        this.isFullSize = z2;
        this.buttonHeight = !z2 ? 42 : (int) Math.max(42.0f, (((this.panelHeight - AndroidUtilities.dp(30.0f)) - ((this.botButtons.rows.size() - 1) * AndroidUtilities.dp(10.0f))) / this.botButtons.rows.size()) / AndroidUtilities.density);
        int i = 0;
        while (i < tLRPC$TL_replyKeyboardMarkup.rows.size()) {
            TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = tLRPC$TL_replyKeyboardMarkup.rows.get(i);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(z ? 1 : 0);
            this.container.addView(linearLayout, LayoutHelper.createLinear(-1, this.buttonHeight, 15.0f, i == 0 ? 15.0f : 10.0f, 15.0f, i == tLRPC$TL_replyKeyboardMarkup.rows.size() - 1 ? 15.0f : 0.0f));
            float size = 1.0f / tLRPC$TL_keyboardButtonRow.buttons.size();
            int i2 = 0;
            ?? r3 = z;
            while (i2 < tLRPC$TL_keyboardButtonRow.buttons.size()) {
                TLRPC$KeyboardButton tLRPC$KeyboardButton = tLRPC$TL_keyboardButtonRow.buttons.get(i2);
                TextView textView = new TextView(getContext());
                textView.setTag(tLRPC$KeyboardButton);
                textView.setTextColor(Theme.getColor(Theme.key_chat_botKeyboardButtonText));
                textView.setTextSize(1, 16.0f);
                textView.setGravity(17);
                textView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_chat_botKeyboardButtonBackground), Theme.getColor(Theme.key_chat_botKeyboardButtonBackgroundPressed)));
                textView.setPadding(AndroidUtilities.dp(4.0f), r3, AndroidUtilities.dp(4.0f), r3);
                textView.setText(Emoji.replaceEmoji(tLRPC$KeyboardButton.text, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), r3));
                linearLayout.addView(textView, LayoutHelper.createLinear(0, -1, size, 0, 0, i2 != tLRPC$TL_keyboardButtonRow.buttons.size() - 1 ? 10 : 0, 0));
                textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.BotKeyboardView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setButtons$0(view);
                    }
                });
                this.buttonViews.add(textView);
                i2++;
                r3 = 0;
            }
            i++;
            z = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setButtons$0(View view) {
        this.delegate.didPressedButton((TLRPC$KeyboardButton) view.getTag());
    }

    public int getKeyboardHeight() {
        TLRPC$TL_replyKeyboardMarkup tLRPC$TL_replyKeyboardMarkup = this.botButtons;
        if (tLRPC$TL_replyKeyboardMarkup == null) {
            return 0;
        }
        return this.isFullSize ? this.panelHeight : (tLRPC$TL_replyKeyboardMarkup.rows.size() * AndroidUtilities.dp(this.buttonHeight)) + AndroidUtilities.dp(30.0f) + ((this.botButtons.rows.size() - 1) * AndroidUtilities.dp(10.0f));
    }
}
