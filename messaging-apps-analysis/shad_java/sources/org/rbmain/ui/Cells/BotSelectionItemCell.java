package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.helper.GlideHelper;
import androidx.core.content.ContextCompat;
import ir.aaap.messengercore.model.BotButtonObject;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class BotSelectionItemCell extends FrameLayout {
    private BotSelectionItemCellDelegate delegate;
    private boolean ignoreLayout;
    private int[] indeces;
    private boolean isFirst;
    private int itemsCount;
    private BotButtonObject.BotButtonSimpleObject[] objects;
    private TextAndImageView[] photoVideoViews;

    public interface BotSelectionItemCellDelegate {
        void didClickItem(BotSelectionItemCell botSelectionItemCell, int i, BotButtonObject.BotButtonSimpleObject botButtonSimpleObject, int i2);

        boolean didLongClickItem(BotSelectionItemCell botSelectionItemCell, int i, BotButtonObject.BotButtonSimpleObject botButtonSimpleObject, int i2);
    }

    private class TextAndImageView extends FrameLayout {
        Context context;
        private BotButtonObject.BotButtonSimpleObject currentItem;
        int currentType;
        public ImageView imageView;
        private TextView textView;

        public TextAndImageView(Context context) {
            super(context);
            this.context = context;
            setBackgroundDrawable(Theme.getSelectorDrawable(false));
            setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrame(48, 48, (LocaleController.isRTL ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(17);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            this.textView.setTextSize(1, 16.0f);
            addView(this.textView, LayoutHelper.createFrame(-2, -2, 21));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.currentType == 2 ? 120 : 48), 1073741824));
        }

        public void setItem(BotButtonObject.BotButtonSimpleObject botButtonSimpleObject) {
            this.currentItem = botButtonSimpleObject;
            this.textView.setText(botButtonSimpleObject.text);
            ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).gravity = 5;
            BotButtonObject.BotButtonSimpleObject.BotButtonViewType botButtonViewType = botButtonSimpleObject.type;
            if (botButtonViewType == BotButtonObject.BotButtonSimpleObject.BotButtonViewType.TextImgBig) {
                this.currentType = 2;
                this.imageView.setVisibility(0);
                int iMin = Math.min(AndroidUtilities.dp(84.0f), BotSelectionItemCell.getItemSize(BotSelectionItemCell.this.itemsCount));
                this.imageView.getLayoutParams().width = iMin;
                this.imageView.getLayoutParams().height = iMin;
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(12.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).leftMargin = AndroidUtilities.dp(0.0f);
                ((ViewGroup) this.imageView.getParent()).getLayoutParams().height = iMin + AndroidUtilities.dp(4.0f);
                GlideHelper.load(this.context, this.imageView, this.currentItem.image_url, R.drawable.shape_white_background);
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).gravity = 81;
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(4.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).gravity = 17;
            } else if (botButtonViewType == BotButtonObject.BotButtonSimpleObject.BotButtonViewType.TextImgThu) {
                this.currentType = 1;
                this.imageView.setVisibility(0);
                this.imageView.getLayoutParams().width = AndroidUtilities.dp(32.0f);
                this.imageView.getLayoutParams().height = AndroidUtilities.dp(32.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(0.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).leftMargin = AndroidUtilities.dp(56.0f);
                GlideHelper.load(this.context, this.imageView, this.currentItem.image_url, R.drawable.shape_white_background);
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).gravity = 17;
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(0.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).gravity = 17;
            } else {
                this.currentType = 0;
                this.imageView.setVisibility(8);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(0.0f);
                ((FrameLayout.LayoutParams) this.imageView.getLayoutParams()).leftMargin = AndroidUtilities.dp(0.0f);
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).gravity = 17;
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).bottomMargin = AndroidUtilities.dp(0.0f);
            }
            if (this.currentItem.isSelected) {
                setBackgroundDrawable(ContextCompat.getDrawable(this.context, R.drawable.shape_gray_alpha_round));
            } else {
                setBackground(ContextCompat.getDrawable(this.context, R.drawable.shape_white_round));
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(this.currentItem.text);
            if (this.currentItem.isSelected) {
                accessibilityNodeInfo.setCheckable(true);
                accessibilityNodeInfo.setChecked(true);
            }
        }
    }

    public BotSelectionItemCell(Context context) {
        this(context, 0);
    }

    public BotSelectionItemCell(Context context, int i) {
        super(context);
        new Paint();
        int i2 = UserConfig.selectedAccount;
        setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        this.objects = new BotButtonObject.BotButtonSimpleObject[6];
        this.photoVideoViews = new TextAndImageView[6];
        this.indeces = new int[6];
        for (int i3 = 0; i3 < 6; i3++) {
            this.photoVideoViews[i3] = new TextAndImageView(context);
            addView(this.photoVideoViews[i3]);
            this.photoVideoViews[i3].setVisibility(4);
            this.photoVideoViews[i3].setTag(Integer.valueOf(i3));
            this.photoVideoViews[i3].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Cells.BotSelectionItemCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            this.photoVideoViews[i3].setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.Cells.BotSelectionItemCell$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$new$1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.delegate != null) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            BotButtonObject.BotButtonSimpleObject[] botButtonSimpleObjectArr = this.objects;
            botButtonSimpleObjectArr[iIntValue].isSelected = !botButtonSimpleObjectArr[iIntValue].isSelected;
            this.delegate.didClickItem(this, this.indeces[iIntValue], botButtonSimpleObjectArr[iIntValue], iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view) {
        if (this.delegate == null) {
            return false;
        }
        int iIntValue = ((Integer) view.getTag()).intValue();
        return this.delegate.didLongClickItem(this, this.indeces[iIntValue], this.objects[iIntValue], iIntValue);
    }

    @Override // android.view.View
    public void invalidate() {
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i].invalidate();
        }
        super.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setDelegate(BotSelectionItemCellDelegate botSelectionItemCellDelegate) {
        this.delegate = botSelectionItemCellDelegate;
    }

    public void setItemsCount(int i) {
        int i2 = 0;
        while (true) {
            TextAndImageView[] textAndImageViewArr = this.photoVideoViews;
            if (i2 < textAndImageViewArr.length) {
                textAndImageViewArr[i2].clearAnimation();
                this.photoVideoViews[i2].setVisibility(i2 < i ? 0 : 4);
                i2++;
            } else {
                this.itemsCount = i;
                return;
            }
        }
    }

    public void setIsFirst(boolean z) {
        this.isFirst = z;
    }

    public void setItem(int i, int i2, BotButtonObject.BotButtonSimpleObject botButtonSimpleObject) {
        this.objects[i] = botButtonSimpleObject;
        this.indeces[i] = i2;
        if (botButtonSimpleObject != null) {
            this.photoVideoViews[i].setVisibility(0);
            this.photoVideoViews[i].setItem(botButtonSimpleObject);
        } else {
            this.photoVideoViews[i].clearAnimation();
            this.photoVideoViews[i].setVisibility(4);
            this.objects[i] = null;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int itemSize = getItemSize(this.itemsCount);
        this.ignoreLayout = true;
        for (int i3 = 0; i3 < this.itemsCount; i3++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.photoVideoViews[i3].getLayoutParams();
            layoutParams.topMargin = this.isFirst ? 0 : AndroidUtilities.dp(2.0f);
            layoutParams.rightMargin = (AndroidUtilities.dp(2.0f) + itemSize) * i3;
            if (i3 == this.itemsCount - 1) {
                if (AndroidUtilities.isTablet()) {
                    layoutParams.width = AndroidUtilities.dp(490.0f) - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                } else {
                    layoutParams.width = (AndroidUtilities.displaySize.x - AndroidUtilities.dp(56.0f)) - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                }
            } else {
                layoutParams.width = itemSize;
            }
            layoutParams.gravity = 53;
            this.photoVideoViews[i3].setLayoutParams(layoutParams);
        }
        this.ignoreLayout = false;
        super.onMeasure(i, i2);
    }

    public static int getItemSize(int i) {
        if (AndroidUtilities.isTablet()) {
            return (AndroidUtilities.dp(490.0f) - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
        }
        return ((AndroidUtilities.displaySize.x - AndroidUtilities.dp(56.0f)) - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
    }
}
