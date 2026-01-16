package org.rbmain.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimationProperties;

/* loaded from: classes5.dex */
public class MessageSeenAlert extends BottomSheet {
    static /* synthetic */ Paint access$200(MessageSeenAlert messageSeenAlert) {
        throw null;
    }

    static /* synthetic */ RectF access$300(MessageSeenAlert messageSeenAlert) {
        throw null;
    }

    static {
        new AnimationProperties.FloatProperty<UserCell>("placeholderAlpha") { // from class: org.rbmain.ui.Components.MessageSeenAlert.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(UserCell userCell, float f) {
                userCell.setPlaceholderAlpha(f);
            }

            @Override // android.util.Property
            public Float get(UserCell userCell) {
                return Float.valueOf(userCell.getPlaceholderAlpha());
            }
        };
    }

    public class UserCell extends FrameLayout {
        private BackupImageView avatarImageView;
        private boolean drawPlaceholder;
        private boolean needDivider;
        private float placeholderAlpha;
        private int placeholderNum;
        final /* synthetic */ MessageSeenAlert this$0;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        @Keep
        public void setPlaceholderAlpha(float f) {
            this.placeholderAlpha = f;
            invalidate();
        }

        @Keep
        public float getPlaceholderAlpha() {
            return this.placeholderAlpha;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int iDp;
            int iDp2;
            int iDp3;
            int iDp4;
            if (this.drawPlaceholder || this.placeholderAlpha != 0.0f) {
                MessageSeenAlert.access$200(this.this$0).setAlpha((int) (this.placeholderAlpha * 255.0f));
                canvas.drawCircle(this.avatarImageView.getLeft() + (this.avatarImageView.getMeasuredWidth() / 2), this.avatarImageView.getTop() + (this.avatarImageView.getMeasuredHeight() / 2), this.avatarImageView.getMeasuredWidth() / 2, MessageSeenAlert.access$200(this.this$0));
                if (this.placeholderNum % 2 == 0) {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(48.0f);
                } else {
                    iDp = AndroidUtilities.dp(65.0f);
                    iDp2 = AndroidUtilities.dp(60.0f);
                }
                if (LocaleController.isRTL) {
                    iDp = (getMeasuredWidth() - iDp) - iDp2;
                }
                MessageSeenAlert.access$300(this.this$0).set(iDp, r2 - AndroidUtilities.dp(4.0f), iDp + iDp2, AndroidUtilities.dp(4.0f) + r2);
                canvas.drawRoundRect(MessageSeenAlert.access$300(this.this$0), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), MessageSeenAlert.access$200(this.this$0));
                if (this.placeholderNum % 2 == 0) {
                    iDp3 = AndroidUtilities.dp(119.0f);
                    iDp4 = AndroidUtilities.dp(60.0f);
                } else {
                    iDp3 = AndroidUtilities.dp(131.0f);
                    iDp4 = AndroidUtilities.dp(80.0f);
                }
                if (LocaleController.isRTL) {
                    iDp3 = (getMeasuredWidth() - iDp3) - iDp4;
                }
                MessageSeenAlert.access$300(this.this$0).set(iDp3, r2 - AndroidUtilities.dp(4.0f), iDp3 + iDp4, r2 + AndroidUtilities.dp(4.0f));
                canvas.drawRoundRect(MessageSeenAlert.access$300(this.this$0), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), MessageSeenAlert.access$200(this.this$0));
            }
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(64.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(64.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
    }
}
