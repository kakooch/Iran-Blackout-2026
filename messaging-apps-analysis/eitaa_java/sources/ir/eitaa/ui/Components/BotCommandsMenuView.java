package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$BotInfo;
import ir.eitaa.tgnet.TLRPC$TL_botCommand;
import ir.eitaa.ui.ActionBar.MenuDrawable;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BotCommandsMenuView extends View {
    final MenuDrawable backDrawable;
    Drawable backgroundDrawable;
    float expandProgress;
    boolean expanded;
    boolean isOpened;
    int lastSize;
    StaticLayout menuText;
    final Paint paint;
    final RectF rectTmp;
    final TextPaint textPaint;

    protected void onTranslationChanged(float translationX) {
    }

    public BotCommandsMenuView(Context context) {
        super(context);
        this.rectTmp = new RectF();
        this.paint = new Paint(1);
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        MenuDrawable menuDrawable = new MenuDrawable() { // from class: ir.eitaa.ui.Components.BotCommandsMenuView.1
            @Override // android.graphics.drawable.Drawable
            public void invalidateSelf() {
                super.invalidateSelf();
                BotCommandsMenuView.this.invalidate();
            }
        };
        this.backDrawable = menuDrawable;
        updateColors();
        menuDrawable.setMiniIcon(true);
        menuDrawable.setRotateToBack(false);
        menuDrawable.setRotation(0.0f, false);
        menuDrawable.setCallback(this);
        textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        menuDrawable.setRoundCap();
        Drawable drawableCreateSimpleSelectorRoundRectDrawable = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(16.0f), 0, Theme.getColor("windowBackgroundWhite"));
        this.backgroundDrawable = drawableCreateSimpleSelectorRoundRectDrawable;
        drawableCreateSimpleSelectorRoundRectDrawable.setCallback(this);
    }

    private void updateColors() {
        this.paint.setColor(Theme.getColor("chat_messagePanelVoiceBackground"));
        int color = Theme.getColor("chat_messagePanelVoicePressed");
        this.backDrawable.setBackColor(color);
        this.backDrawable.setIconColor(color);
        this.textPaint.setColor(color);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = (View.MeasureSpec.getSize(widthMeasureSpec) + View.MeasureSpec.getSize(heightMeasureSpec)) << 16;
        if (this.lastSize != size || this.menuText == null) {
            this.backDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.textPaint.setTextSize(AndroidUtilities.dp(15.0f));
            this.lastSize = size;
            String string = LocaleController.getString("BotsMenuTitle", R.string.BotsMenuTitle);
            int iMeasureText = (int) this.textPaint.measureText(string);
            this.menuText = StaticLayoutEx.createStaticLayout(string, this.textPaint, iMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, iMeasureText, 1);
        }
        onTranslationChanged((this.menuText.getWidth() + AndroidUtilities.dp(4.0f)) * this.expandProgress);
        int iDp = AndroidUtilities.dp(40.0f);
        if (this.expanded) {
            iDp += this.menuText.getWidth() + AndroidUtilities.dp(4.0f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iDp, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.BotCommandsMenuView.dispatchDraw(android.graphics.Canvas):void");
    }

    public void setExpanded(boolean expanded, boolean animated) {
        if (this.expanded != expanded) {
            this.expanded = expanded;
            if (!animated) {
                this.expandProgress = expanded ? 1.0f : 0.0f;
            }
            requestLayout();
            invalidate();
        }
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public static class BotCommandsAdapter extends RecyclerListView.SelectionAdapter {
        ArrayList<String> newResult = new ArrayList<>();
        ArrayList<String> newResultHelp = new ArrayList<>();

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            BotCommandView botCommandView = new BotCommandView(parent.getContext());
            botCommandView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(botCommandView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            BotCommandView botCommandView = (BotCommandView) holder.itemView;
            botCommandView.command.setText(this.newResult.get(position));
            botCommandView.description.setText(this.newResultHelp.get(position));
            botCommandView.commandStr = this.newResult.get(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.newResult.size();
        }

        public void setBotInfo(LongSparseArray<TLRPC$BotInfo> botInfo) {
            this.newResult.clear();
            this.newResultHelp.clear();
            for (int i = 0; i < botInfo.size(); i++) {
                TLRPC$BotInfo tLRPC$BotInfoValueAt = botInfo.valueAt(i);
                for (int i2 = 0; i2 < tLRPC$BotInfoValueAt.commands.size(); i2++) {
                    TLRPC$TL_botCommand tLRPC$TL_botCommand = tLRPC$BotInfoValueAt.commands.get(i2);
                    if (tLRPC$TL_botCommand != null && tLRPC$TL_botCommand.command != null) {
                        this.newResult.add("/" + tLRPC$TL_botCommand.command);
                        String str = tLRPC$TL_botCommand.description;
                        if (str != null && str.length() > 1) {
                            this.newResultHelp.add(tLRPC$TL_botCommand.description.substring(0, 1).toUpperCase() + tLRPC$TL_botCommand.description.substring(1).toLowerCase());
                        } else {
                            this.newResultHelp.add(tLRPC$TL_botCommand.description);
                        }
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setOpened(boolean opened) {
        if (this.isOpened != opened) {
            this.isOpened = opened;
        }
        this.backDrawable.setRotation(opened ? 1.0f : 0.0f, true);
    }

    public static class BotCommandView extends LinearLayout {
        TextView command;
        String commandStr;
        TextView description;

        public BotCommandView(Context context) {
            super(context);
            setOrientation(0);
            setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
            TextView textView = new TextView(context);
            this.description = textView;
            textView.setTextSize(1, 16.0f);
            this.description.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.description.setTag("windowBackgroundWhiteBlackText");
            this.description.setLines(1);
            this.description.setEllipsize(TextUtils.TruncateAt.END);
            addView(this.description, LayoutHelper.createLinear(-1, -2, 1.0f, 16, 0, 0, AndroidUtilities.dp(8.0f), 0));
            TextView textView2 = new TextView(context);
            this.command = textView2;
            textView2.setTextSize(1, 14.0f);
            this.command.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            this.command.setTag("windowBackgroundWhiteGrayText");
            addView(this.command, LayoutHelper.createLinear(-2, -2, 0.0f, 16));
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(36.0f), 1073741824));
        }

        public String getCommand() {
            return this.commandStr;
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || this.backgroundDrawable == who;
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.backgroundDrawable.setState(getDrawableState());
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.backgroundDrawable.jumpToCurrentState();
    }
}
