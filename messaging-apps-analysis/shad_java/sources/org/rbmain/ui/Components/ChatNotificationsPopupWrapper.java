package org.rbmain.ui.Components;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AlertsCreator;

/* loaded from: classes5.dex */
public class ChatNotificationsPopupWrapper {
    View backItem;
    Callback callback;
    private final View gap;
    ActionBarMenuSubItem muteForLastSelected;
    private int muteForLastSelected1Time;
    ActionBarMenuSubItem muteForLastSelected2;
    private int muteForLastSelected2Time;
    ActionBarMenuSubItem muteUnmuteButton;
    ActionBarPopupWindow popupWindow;
    ActionBarMenuSubItem soundToggle;
    private final TextView topicsExceptionsTextView;
    public ActionBarPopupWindow.ActionBarPopupWindowLayout windowLayout;

    public interface Callback {

        /* renamed from: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$openExceptions(Callback callback) {
            }
        }

        void dismiss();

        void muteFor(int i);

        void openExceptions();

        void showCustomize();

        void toggleMute();

        void toggleSound();
    }

    public ChatNotificationsPopupWrapper(final Context context, final int i, final PopupSwipeBackLayout popupSwipeBackLayout, boolean z, boolean z2, final Callback callback, final Theme.ResourcesProvider resourcesProvider) {
        this.callback = callback;
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(this, context, z ? R.drawable.popup_fixed_alert : 0, resourcesProvider) { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper.1
            Path path = new Path();

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                canvas.save();
                this.path.rewind();
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                this.path.addRoundRect(rectF, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), Path.Direction.CW);
                canvas.clipPath(this.path);
                boolean zDrawChild = super.drawChild(canvas, view, j);
                canvas.restore();
                return zDrawChild;
            }
        };
        this.windowLayout = actionBarPopupWindowLayout;
        actionBarPopupWindowLayout.setFitItems(true);
        if (popupSwipeBackLayout != null) {
            ActionBarMenuSubItem actionBarMenuSubItemAddItem = ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_arrow_back, LocaleController.getString("Back", R.string.Back), false, resourcesProvider);
            this.backItem = actionBarMenuSubItemAddItem;
            actionBarMenuSubItemAddItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    popupSwipeBackLayout.closeForeground();
                }
            });
        }
        ActionBarMenuSubItem actionBarMenuSubItemAddItem2 = ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_tone_on, LocaleController.getString("SoundOn", R.string.SoundOn), false, resourcesProvider);
        this.soundToggle = actionBarMenuSubItemAddItem2;
        actionBarMenuSubItemAddItem2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(callback, view);
            }
        });
        ActionBarMenuSubItem actionBarMenuSubItemAddItem3 = ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_mute_1h, LocaleController.getString("MuteFor1h", R.string.MuteFor1h), false, resourcesProvider);
        this.muteForLastSelected = actionBarMenuSubItemAddItem3;
        actionBarMenuSubItemAddItem3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(callback, view);
            }
        });
        ActionBarMenuSubItem actionBarMenuSubItemAddItem4 = ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_mute_1h, LocaleController.getString("MuteFor1h", R.string.MuteFor1h), false, resourcesProvider);
        this.muteForLastSelected2 = actionBarMenuSubItemAddItem4;
        actionBarMenuSubItemAddItem4.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3(callback, view);
            }
        });
        ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_mute_period, LocaleController.getString("MuteForPopup", R.string.MuteForPopup), false, resourcesProvider).setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$6(context, resourcesProvider, i, callback, view);
            }
        });
        ActionBarMenuItem.addItem(this.windowLayout, R.drawable.msg_customize, LocaleController.getString("NotificationsCustomize", R.string.NotificationsCustomize), false, resourcesProvider).setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$7(callback, view);
            }
        });
        ActionBarMenuSubItem actionBarMenuSubItemAddItem5 = ActionBarMenuItem.addItem(this.windowLayout, 0, BuildConfig.FLAVOR, false, resourcesProvider);
        this.muteUnmuteButton = actionBarMenuSubItemAddItem5;
        actionBarMenuSubItemAddItem5.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$9(callback, view);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.gap = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuSeparator, resourcesProvider));
        this.windowLayout.addView((View) frameLayout, LayoutHelper.createLinear(-1, 8));
        TextView textView = new TextView(context);
        this.topicsExceptionsTextView = textView;
        textView.setPadding(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(13.0f), AndroidUtilities.dp(8.0f));
        textView.setTextSize(1, 13.0f);
        textView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem, resourcesProvider));
        frameLayout.setTag(R.id.fit_width_tag, 1);
        textView.setTag(R.id.fit_width_tag, 1);
        this.windowLayout.addView((View) textView, LayoutHelper.createLinear(-2, -2));
        textView.setBackground(Theme.createRadSelectorDrawable(Theme.getColor(Theme.key_dialogButtonSelector, resourcesProvider), 0, 6));
        textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$10(callback, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Callback callback, View view) {
        dismiss();
        callback.toggleSound();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Callback callback, View view) {
        dismiss();
        callback.muteFor(this.muteForLastSelected1Time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(Callback callback, View view) {
        dismiss();
        callback.muteFor(this.muteForLastSelected2Time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(Context context, Theme.ResourcesProvider resourcesProvider, final int i, final Callback callback, View view) {
        dismiss();
        AlertsCreator.createMuteForPickerDialog(context, resourcesProvider, new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda10
            @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
            public final void didSelectDate(boolean z, int i2) {
                ChatNotificationsPopupWrapper.lambda$new$5(i, callback, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$5(final int i, final Callback callback, boolean z, final int i2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ChatNotificationsPopupWrapper.lambda$new$4(i2, i, callback);
            }
        }, 16L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$4(int i, int i2, Callback callback) {
        if (i != 0) {
            SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(i2);
            notificationsSettings.edit().putInt("last_selected_mute_until_time", i).putInt("last_selected_mute_until_time2", notificationsSettings.getInt("last_selected_mute_until_time", 0)).apply();
        }
        callback.muteFor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(Callback callback, View view) {
        dismiss();
        callback.showCustomize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(final Callback callback, View view) {
        dismiss();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatNotificationsPopupWrapper$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                callback.toggleMute();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$10(Callback callback, View view) {
        if (callback != null) {
            callback.openExceptions();
        }
        dismiss();
    }

    private void dismiss() {
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            this.popupWindow.dismiss();
        }
        this.callback.dismiss();
        System.currentTimeMillis();
    }
}
