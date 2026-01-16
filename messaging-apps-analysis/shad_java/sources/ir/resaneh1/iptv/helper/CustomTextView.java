package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class CustomTextView {
    private static final int defaultTextColor = Theme.getColor(Theme.key_dialogTextBlack);
    private static final int defaultBackgroundColor = Theme.getColor(Theme.key_windowBackgroundWhite);

    public static class Builder {
        protected Context context;
        protected int paddingLeft;
        protected int paddingRight;
        protected int paddingTop;
        protected TextView textView;
        protected int textColor = CustomTextView.defaultTextColor;
        protected int backgroundResource = 0;
        protected int backgroundColor = CustomTextView.defaultBackgroundColor;
        protected Drawable background = null;
        protected int gravity = 0;
        protected int paddingBottom = 0;
        protected int textSize = 14;
        protected boolean isBold = false;
        protected View.OnClickListener onClickListener = null;
        protected String text = BuildConfig.FLAVOR;
        protected Typeface boldTypeFace = Theme.getHomePageTypeFaceBold();
        protected Typeface typeFace = Theme.getHomePageTypeFaceRegular();

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder isBold(boolean z) {
            this.isBold = z;
            return this;
        }

        public Builder setTextColor(int i) {
            this.textColor = i;
            return this;
        }

        public Builder setTextSize(int i) {
            this.textSize = i;
            return this;
        }

        public Builder setBackgroundResource(int i) {
            this.backgroundResource = i;
            return this;
        }

        public Builder setBackgroundResource(Drawable drawable) {
            this.background = drawable;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder removeBackgroundColor() {
            this.backgroundColor = 0;
            return this;
        }

        public Builder removeBackgrounds() {
            this.backgroundColor = 0;
            this.background = null;
            return this;
        }

        public Builder setGravity(int i) {
            this.gravity = i;
            return this;
        }

        public Builder setPadding(int i, int i2, int i3, int i4) {
            this.paddingTop = i2;
            this.paddingRight = i3;
            this.paddingLeft = i;
            this.paddingBottom = i4;
            return this;
        }

        public TextView build() {
            TextView textView = new TextView(this.context);
            this.textView = textView;
            textView.setTextColor(this.textColor);
            int i = this.backgroundColor;
            if (i != 0 && this.backgroundResource == 0) {
                this.textView.setBackgroundColor(i);
            }
            int i2 = this.backgroundResource;
            if (i2 != 0) {
                this.textView.setBackgroundResource(i2);
            }
            Drawable drawable = this.background;
            if (drawable != null) {
                this.textView.setBackground(drawable);
            }
            this.textView.setText(this.text);
            this.textView.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
            this.textView.setTextSize(2, this.textSize);
            this.textView.setGravity(this.gravity);
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null) {
                this.textView.setOnClickListener(onClickListener);
            }
            if (this.isBold) {
                this.textView.setTypeface(this.boldTypeFace);
            } else {
                this.textView.setTypeface(this.typeFace);
            }
            return this.textView;
        }
    }
}
