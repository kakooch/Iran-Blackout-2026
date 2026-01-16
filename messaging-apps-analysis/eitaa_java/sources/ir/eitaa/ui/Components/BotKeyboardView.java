package ir.eitaa.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRow;
import ir.eitaa.tgnet.TLRPC$TL_replyKeyboardMarkup;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BotKeyboardView extends LinearLayout {
    private TLRPC$TL_replyKeyboardMarkup botButtons;
    private int buttonHeight;
    private ArrayList<TextView> buttonViews;
    private LinearLayout container;
    private BotKeyboardViewDelegate delegate;
    private boolean isFullSize;
    private int panelHeight;
    private final Theme.ResourcesProvider resourcesProvider;
    private ScrollView scrollView;

    public interface BotKeyboardViewDelegate {
        void didPressedButton(TLRPC$KeyboardButton button);
    }

    public BotKeyboardView(Context context, Theme.ResourcesProvider resourcesProvider) throws NoSuchFieldException {
        super(context);
        this.buttonViews = new ArrayList<>();
        this.resourcesProvider = resourcesProvider;
        setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        addView(scrollView);
        LinearLayout linearLayout = new LinearLayout(context);
        this.container = linearLayout;
        linearLayout.setOrientation(1);
        this.scrollView.addView(this.container);
        updateColors();
    }

    public void updateColors() throws NoSuchFieldException {
        AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, getThemedColor("chat_emojiPanelBackground"));
        setBackgroundColor(getThemedColor("chat_emojiPanelBackground"));
        for (int i = 0; i < this.buttonViews.size(); i++) {
            this.buttonViews.get(i).setTextColor(getThemedColor("chat_botKeyboardButtonText"));
            this.buttonViews.get(i).setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), getThemedColor("chat_botKeyboardButtonBackground"), getThemedColor("chat_botKeyboardButtonBackgroundPressed")));
        }
        invalidate();
    }

    public void setDelegate(BotKeyboardViewDelegate botKeyboardViewDelegate) {
        this.delegate = botKeyboardViewDelegate;
    }

    public void setPanelHeight(int height) {
        TLRPC$TL_replyKeyboardMarkup tLRPC$TL_replyKeyboardMarkup;
        this.panelHeight = height;
        if (!this.isFullSize || (tLRPC$TL_replyKeyboardMarkup = this.botButtons) == null || tLRPC$TL_replyKeyboardMarkup.rows.size() == 0) {
            return;
        }
        this.buttonHeight = !this.isFullSize ? 42 : (int) Math.max(42.0f, (((this.panelHeight - AndroidUtilities.dp(30.0f)) - ((this.botButtons.rows.size() - 1) * AndroidUtilities.dp(10.0f))) / this.botButtons.rows.size()) / AndroidUtilities.density);
        int childCount = this.container.getChildCount();
        int iDp = AndroidUtilities.dp(this.buttonHeight);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.container.getChildAt(i);
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
                textView.setTextColor(getThemedColor("chat_botKeyboardButtonText"));
                textView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), getThemedColor("chat_botKeyboardButtonBackground"), getThemedColor("chat_botKeyboardButtonBackgroundPressed")));
                textView.setTextSize(1, 16.0f);
                textView.setGravity(17);
                textView.setPadding(AndroidUtilities.dp(4.0f), r3, AndroidUtilities.dp(4.0f), r3);
                textView.setText(Emoji.replaceEmoji(tLRPC$KeyboardButton.text, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), r3));
                linearLayout.addView(textView, LayoutHelper.createLinear(0, -1, size, 0, 0, i2 != tLRPC$TL_keyboardButtonRow.buttons.size() - 1 ? 10 : 0, 0));
                textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$BotKeyboardView$ECTWeWHubcEEEzQIwjuVbbfqF2M
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setButtons$0$BotKeyboardView(view);
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
    /* renamed from: lambda$setButtons$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setButtons$0$BotKeyboardView(View view) {
        this.delegate.didPressedButton((TLRPC$KeyboardButton) view.getTag());
    }

    public int getKeyboardHeight() {
        TLRPC$TL_replyKeyboardMarkup tLRPC$TL_replyKeyboardMarkup = this.botButtons;
        if (tLRPC$TL_replyKeyboardMarkup == null) {
            return 0;
        }
        return this.isFullSize ? this.panelHeight : (tLRPC$TL_replyKeyboardMarkup.rows.size() * AndroidUtilities.dp(this.buttonHeight)) + AndroidUtilities.dp(30.0f) + ((this.botButtons.rows.size() - 1) * AndroidUtilities.dp(10.0f));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
