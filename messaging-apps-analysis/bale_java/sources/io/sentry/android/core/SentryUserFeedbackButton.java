package io.sentry.android.core;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import io.sentry.android.core.V0;

/* loaded from: classes3.dex */
public class SentryUserFeedbackButton extends Button {
    private View.OnClickListener a;

    public SentryUserFeedbackButton(Context context) {
        super(context);
        b(context, null, 0, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I0.SentryUserFeedbackButton, i, i2);
        try {
            float f = context.getResources().getDisplayMetrics().density;
            float dimension = typedArrayObtainStyledAttributes.getDimension(I0.SentryUserFeedbackButton_android_drawablePadding, -1.0f);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(I0.SentryUserFeedbackButton_android_drawableStart, -1);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(I0.SentryUserFeedbackButton_android_textAllCaps, false);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(I0.SentryUserFeedbackButton_android_background, -1);
            float dimension2 = typedArrayObtainStyledAttributes.getDimension(I0.SentryUserFeedbackButton_android_padding, -1.0f);
            int color = typedArrayObtainStyledAttributes.getColor(I0.SentryUserFeedbackButton_android_textColor, -1);
            String string = typedArrayObtainStyledAttributes.getString(I0.SentryUserFeedbackButton_android_text);
            if (dimension == -1.0f) {
                setCompoundDrawablePadding((int) (4.0f * f));
            }
            if (resourceId == -1) {
                setCompoundDrawablesRelativeWithIntrinsicBounds(F0.sentry_user_feedback_button_logo_24, 0, 0, 0);
            }
            setAllCaps(z);
            if (resourceId2 == -1) {
                setBackgroundResource(F0.sentry_oval_button_ripple_background);
            }
            if (dimension2 == -1.0f) {
                int i3 = (int) (f * 12.0f);
                setPadding(i3, i3, i3, i3);
            }
            if (color == -1) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorForeground, typedValue, true);
                setTextColor(context.getResources().getColor(typedValue.resourceId, context.getTheme()));
            }
            if (string == null) {
                setText("Report a Bug");
            }
            typedArrayObtainStyledAttributes.recycle();
            setOnClickListener(this.a);
        } catch (Throwable th) {
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        new V0.a(getContext()).a().show();
        View.OnClickListener onClickListener = this.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a = onClickListener;
        super.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.R0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c(view);
            }
        });
    }

    public SentryUserFeedbackButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0, 0);
    }

    public SentryUserFeedbackButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i, 0);
    }
}
