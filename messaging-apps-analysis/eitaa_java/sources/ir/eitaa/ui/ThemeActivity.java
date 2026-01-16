package ir.eitaa.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.time.SunDate;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.BrightnessControlCell;
import ir.eitaa.ui.Cells.ChatListCell;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.NotificationsCheckCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Cells.ThemePreviewMessagesCell;
import ir.eitaa.ui.Cells.ThemeTypeCell;
import ir.eitaa.ui.Cells.ThemesHorizontalListCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.FontSettingView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBarView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.SwipeGestureSettingsView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ThemeActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int automaticBrightnessInfoRow;
    private int automaticBrightnessRow;
    private int automaticHeaderRow;
    private int backgroundRow;
    private int bubbleRadiusHeaderRow;
    private int bubbleRadiusInfoRow;
    private int bubbleRadiusRow;
    private int chatListHeaderRow;
    private int chatListInfoRow;
    private int chatListRow;
    private int contactsReimportRow;
    private int contactsSortRow;
    private int currentType;
    private int customTabsRow;
    private int directShareRow;
    private int distanceRow;
    private int emojiRow;
    private int enableAnimationsRow;
    private int fontHeaderRow;
    private int fontRow;
    private GpsLocationListener gpsLocationListener;
    boolean hasThemeAccents;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private ActionBarMenuItem menuItem;
    private GpsLocationListener networkLocationListener;
    private int newThemeInfoRow;
    private int nightAutomaticRow;
    private int nightDisabledRow;
    private int nightScheduledRow;
    private int nightSystemDefaultRow;
    private int nightThemeRow;
    private int nightTypeInfoRow;
    private int preferedHeaderRow;
    private boolean previousByLocation;
    private int previousUpdatedType;
    private int proximitySensorRow;
    private int raiseToSpeakRow;
    private int rowCount;
    private int saveToGalleryRow;
    private int scheduleFromRow;
    private int scheduleFromToInfoRow;
    private int scheduleHeaderRow;
    private int scheduleLocationInfoRow;
    private int scheduleLocationRow;
    private int scheduleToRow;
    private int scheduleUpdateLocationRow;
    private int sendByEnterRow;
    private int settings2Row;
    private int settingsRow;
    private Theme.ThemeAccent sharingAccent;
    private AlertDialog sharingProgressDialog;
    private Theme.ThemeInfo sharingTheme;
    private int stickersSection2Row;
    private int swipeGestureHeaderRow;
    private int swipeGestureInfoRow;
    private int swipeGestureRow;
    private int textSizeHeaderRow;
    private int textSizeRow;
    private int themeAccentListRow;
    private int themeHeaderRow;
    private int themeInfoRow;
    private int themeListRow;
    private ThemesHorizontalListCell themesHorizontalListCell;
    private boolean updatingLocation;
    private ArrayList<Theme.ThemeInfo> darkThemes = new ArrayList<>();
    private ArrayList<Theme.ThemeInfo> defaultThemes = new ArrayList<>();
    private int stickersRow = -1;
    private boolean isFontFamilyChanged = false;

    private class GpsLocationListener implements LocationListener {
        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        private GpsLocationListener() {
        }

        /* synthetic */ GpsLocationListener(ThemeActivity themeActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            ThemeActivity.this.stopLocationUpdate();
            ThemeActivity.this.updateSunTime(location, false);
        }
    }

    private class TextSizeCell extends FrameLayout {
        private int endFontSize;
        private int lastWidth;
        private ThemePreviewMessagesCell messagesCell;
        private SeekBarView sizeBar;
        private int startFontSize;
        private TextPaint textPaint;

        public TextSizeCell(Context context) {
            super(context);
            this.startFontSize = 12;
            this.endFontSize = 30;
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(16.0f));
            SeekBarView seekBarView = new SeekBarView(context);
            this.sizeBar = seekBarView;
            seekBarView.setReportChanges(true);
            this.sizeBar.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.ThemeActivity.TextSizeCell.1
                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarPressed(boolean pressed) {
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(boolean stop, float progress) {
                    ThemeActivity.this.setFontSize(Math.round(r4.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * progress)));
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public CharSequence getContentDescription() {
                    return String.valueOf(Math.round(TextSizeCell.this.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * TextSizeCell.this.sizeBar.getProgress())));
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public int getStepsCount() {
                    return TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize;
                }
            });
            this.sizeBar.setImportantForAccessibility(2);
            addView(this.sizeBar, LayoutHelper.createFrame(-1, 38.0f, 51, 5.0f, 5.0f, 39.0f, 0.0f));
            ThemePreviewMessagesCell themePreviewMessagesCell = new ThemePreviewMessagesCell(context, ((BaseFragment) ThemeActivity.this).parentLayout, 0);
            this.messagesCell = themePreviewMessagesCell;
            if (Build.VERSION.SDK_INT >= 19) {
                themePreviewMessagesCell.setImportantForAccessibility(4);
            }
            addView(this.messagesCell, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 53.0f, 0.0f, 0.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor("windowBackgroundWhiteValueText"));
            canvas.drawText("" + SharedConfig.fontSize, getMeasuredWidth() - AndroidUtilities.dp(39.0f), AndroidUtilities.dp(28.0f), this.textPaint);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            if (this.lastWidth != size) {
                SeekBarView seekBarView = this.sizeBar;
                int i = SharedConfig.fontSize;
                int i2 = this.startFontSize;
                seekBarView.setProgress((i - i2) / (this.endFontSize - i2));
                this.lastWidth = size;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.messagesCell.invalidate();
            this.sizeBar.invalidate();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            this.sizeBar.getSeekBarAccessibilityDelegate().onInitializeAccessibilityNodeInfoInternal(this, info);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int action, Bundle arguments) {
            return super.performAccessibilityAction(action, arguments) || this.sizeBar.getSeekBarAccessibilityDelegate().performAccessibilityActionInternal(this, action, arguments);
        }
    }

    private class BubbleRadiusCell extends FrameLayout {
        private int endRadius;
        private SeekBarView sizeBar;
        private int startRadius;
        private TextPaint textPaint;

        public BubbleRadiusCell(Context context) {
            super(context);
            this.startRadius = 0;
            this.endRadius = 17;
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(16.0f));
            SeekBarView seekBarView = new SeekBarView(context);
            this.sizeBar = seekBarView;
            seekBarView.setReportChanges(true);
            this.sizeBar.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.ThemeActivity.BubbleRadiusCell.1
                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarPressed(boolean pressed) {
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(boolean stop, float progress) {
                    ThemeActivity.this.setBubbleRadius(Math.round(r4.startRadius + ((BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius) * progress)), false);
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public CharSequence getContentDescription() {
                    return String.valueOf(Math.round(BubbleRadiusCell.this.startRadius + ((BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius) * BubbleRadiusCell.this.sizeBar.getProgress())));
                }

                @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
                public int getStepsCount() {
                    return BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius;
                }
            });
            this.sizeBar.setImportantForAccessibility(2);
            addView(this.sizeBar, LayoutHelper.createFrame(-1, 38.0f, 51, 5.0f, 5.0f, 39.0f, 0.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor("windowBackgroundWhiteValueText"));
            canvas.drawText("" + SharedConfig.bubbleRadius, getMeasuredWidth() - AndroidUtilities.dp(39.0f), AndroidUtilities.dp(28.0f), this.textPaint);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
            SeekBarView seekBarView = this.sizeBar;
            int i = SharedConfig.bubbleRadius;
            int i2 = this.startRadius;
            seekBarView.setProgress((i - i2) / (this.endRadius - i2));
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.sizeBar.invalidate();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            this.sizeBar.getSeekBarAccessibilityDelegate().onInitializeAccessibilityNodeInfoInternal(this, info);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int action, Bundle arguments) {
            return super.performAccessibilityAction(action, arguments) || this.sizeBar.getSeekBarAccessibilityDelegate().performAccessibilityActionInternal(this, action, arguments);
        }
    }

    public ThemeActivity(int type) {
        AnonymousClass1 anonymousClass1 = null;
        this.gpsLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.networkLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.currentType = type;
        updateRows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setBubbleRadius(int size, boolean layout) {
        if (size == SharedConfig.bubbleRadius) {
            return false;
        }
        SharedConfig.bubbleRadius = size;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("bubbleRadius", SharedConfig.bubbleRadius);
        editorEdit.commit();
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.textSizeRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
            if (view instanceof TextSizeCell) {
                TextSizeCell textSizeCell = (TextSizeCell) view;
                ChatMessageCell[] cells = textSizeCell.messagesCell.getCells();
                for (int i = 0; i < cells.length; i++) {
                    cells[i].getMessageObject().resetLayout();
                    cells[i].requestLayout();
                }
                textSizeCell.invalidate();
            }
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.bubbleRadiusRow);
        if (viewHolderFindViewHolderForAdapterPosition2 != null) {
            View view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
            if (view2 instanceof BubbleRadiusCell) {
                BubbleRadiusCell bubbleRadiusCell = (BubbleRadiusCell) view2;
                if (layout) {
                    bubbleRadiusCell.requestLayout();
                } else {
                    bubbleRadiusCell.invalidate();
                }
            }
        }
        updateMenuItem();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setFontSize(int size) {
        if (size == SharedConfig.fontSize) {
            return false;
        }
        SharedConfig.fontSize = size;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("fons_size", SharedConfig.fontSize);
        editorEdit.commit();
        Theme.chat_msgTextPaint.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize));
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.textSizeRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
            if (view instanceof TextSizeCell) {
                ChatMessageCell[] cells = ((TextSizeCell) view).messagesCell.getCells();
                for (int i = 0; i < cells.length; i++) {
                    cells[i].getMessageObject().resetLayout();
                    cells[i].requestLayout();
                }
            }
        }
        updateMenuItem();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFontFamily(int font) {
        if (font != SharedConfig.fontFamily) {
            SharedConfig.setFontFamily(font);
            this.isFontFamilyChanged = true;
            AndroidUtilities.recreateFontFamily();
            Theme.chat_msgTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            Theme.chat_replyTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            Theme.chat_timePaint.setTypeface(AndroidUtilities.getFontFamily(false));
            Theme.chat_replyNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.textSizeRow);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                if (view instanceof TextSizeCell) {
                    ChatMessageCell[] cells = ((TextSizeCell) view).messagesCell.getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].getMessageObject().resetLayout();
                        cells[i].requestLayout();
                    }
                }
            }
            updateMenuItem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean notify) {
        int i;
        int i2;
        int i3;
        TLRPC$TL_theme tLRPC$TL_theme;
        int i4 = this.rowCount;
        int i5 = this.themeAccentListRow;
        this.rowCount = 0;
        this.emojiRow = -1;
        this.contactsReimportRow = -1;
        this.contactsSortRow = -1;
        this.scheduleLocationRow = -1;
        this.scheduleUpdateLocationRow = -1;
        this.scheduleLocationInfoRow = -1;
        this.nightDisabledRow = -1;
        this.nightScheduledRow = -1;
        this.nightAutomaticRow = -1;
        this.nightSystemDefaultRow = -1;
        this.nightTypeInfoRow = -1;
        this.scheduleHeaderRow = -1;
        this.nightThemeRow = -1;
        this.newThemeInfoRow = -1;
        this.scheduleFromRow = -1;
        this.scheduleToRow = -1;
        this.scheduleFromToInfoRow = -1;
        this.themeListRow = -1;
        this.themeAccentListRow = -1;
        this.themeInfoRow = -1;
        this.preferedHeaderRow = -1;
        this.automaticHeaderRow = -1;
        this.automaticBrightnessRow = -1;
        this.automaticBrightnessInfoRow = -1;
        this.textSizeHeaderRow = -1;
        this.fontHeaderRow = -1;
        this.themeHeaderRow = -1;
        this.bubbleRadiusHeaderRow = -1;
        this.bubbleRadiusRow = -1;
        this.bubbleRadiusInfoRow = -1;
        this.chatListHeaderRow = -1;
        this.chatListRow = -1;
        this.chatListInfoRow = -1;
        this.textSizeRow = -1;
        this.fontRow = -1;
        this.backgroundRow = -1;
        this.settingsRow = -1;
        this.customTabsRow = -1;
        this.directShareRow = -1;
        this.enableAnimationsRow = -1;
        this.raiseToSpeakRow = -1;
        this.proximitySensorRow = -1;
        this.sendByEnterRow = -1;
        this.saveToGalleryRow = -1;
        this.distanceRow = -1;
        this.settings2Row = -1;
        this.stickersRow = -1;
        this.stickersSection2Row = -1;
        this.swipeGestureHeaderRow = -1;
        this.swipeGestureRow = -1;
        this.swipeGestureInfoRow = -1;
        this.defaultThemes.clear();
        this.darkThemes.clear();
        int size = Theme.themes.size();
        for (int i6 = 0; i6 < size; i6++) {
            Theme.ThemeInfo themeInfo = Theme.themes.get(i6);
            if (this.currentType == 0 || (!themeInfo.isLight() && ((tLRPC$TL_theme = themeInfo.info) == null || tLRPC$TL_theme.document != null))) {
                if (themeInfo.pathToFile != null) {
                    this.darkThemes.add(themeInfo);
                } else {
                    this.defaultThemes.add(themeInfo);
                }
            }
        }
        Collections.sort(this.defaultThemes, $$Lambda$ThemeActivity$wbigl_GxBYyrBXEeNKJ4uWURCUw.INSTANCE);
        if (this.currentType == 0) {
            int i7 = this.rowCount;
            int i8 = i7 + 1;
            this.rowCount = i8;
            this.fontHeaderRow = i7;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.fontRow = i8;
            int i10 = i9 + 1;
            this.rowCount = i10;
            this.textSizeHeaderRow = i9;
            int i11 = i10 + 1;
            this.rowCount = i11;
            this.textSizeRow = i10;
            int i12 = i11 + 1;
            this.rowCount = i12;
            this.backgroundRow = i11;
            int i13 = i12 + 1;
            this.rowCount = i13;
            this.newThemeInfoRow = i12;
            int i14 = i13 + 1;
            this.rowCount = i14;
            this.themeHeaderRow = i13;
            this.rowCount = i14 + 1;
            this.themeListRow = i14;
            boolean zHasAccentColors = Theme.getCurrentTheme().hasAccentColors();
            this.hasThemeAccents = zHasAccentColors;
            ThemesHorizontalListCell themesHorizontalListCell = this.themesHorizontalListCell;
            if (themesHorizontalListCell != null) {
                themesHorizontalListCell.setDrawDivider(zHasAccentColors);
            }
            if (this.hasThemeAccents) {
                int i15 = this.rowCount;
                this.rowCount = i15 + 1;
                this.themeAccentListRow = i15;
            }
            int i16 = this.rowCount;
            int i17 = i16 + 1;
            this.rowCount = i17;
            this.themeInfoRow = i16;
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.bubbleRadiusHeaderRow = i17;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.bubbleRadiusRow = i18;
            int i20 = i19 + 1;
            this.rowCount = i20;
            this.bubbleRadiusInfoRow = i19;
            int i21 = i20 + 1;
            this.rowCount = i21;
            this.chatListHeaderRow = i20;
            int i22 = i21 + 1;
            this.rowCount = i22;
            this.chatListRow = i21;
            int i23 = i22 + 1;
            this.rowCount = i23;
            this.chatListInfoRow = i22;
            int i24 = i23 + 1;
            this.rowCount = i24;
            this.swipeGestureHeaderRow = i23;
            int i25 = i24 + 1;
            this.rowCount = i25;
            this.swipeGestureRow = i24;
            int i26 = i25 + 1;
            this.rowCount = i26;
            this.swipeGestureInfoRow = i25;
            int i27 = i26 + 1;
            this.rowCount = i27;
            this.settingsRow = i26;
            int i28 = i27 + 1;
            this.rowCount = i28;
            this.nightThemeRow = i27;
            int i29 = i28 + 1;
            this.rowCount = i29;
            this.customTabsRow = i28;
            int i30 = i29 + 1;
            this.rowCount = i30;
            this.directShareRow = i29;
            int i31 = i30 + 1;
            this.rowCount = i31;
            this.enableAnimationsRow = i30;
            int i32 = i31 + 1;
            this.rowCount = i32;
            this.emojiRow = i31;
            int i33 = i32 + 1;
            this.rowCount = i33;
            this.raiseToSpeakRow = i32;
            int i34 = i33 + 1;
            this.rowCount = i34;
            this.proximitySensorRow = i33;
            int i35 = i34 + 1;
            this.rowCount = i35;
            this.sendByEnterRow = i34;
            int i36 = i35 + 1;
            this.rowCount = i36;
            this.saveToGalleryRow = i35;
            int i37 = i36 + 1;
            this.rowCount = i37;
            this.distanceRow = i36;
            int i38 = i37 + 1;
            this.rowCount = i38;
            this.settings2Row = i37;
            this.rowCount = i38 + 1;
            this.stickersSection2Row = i38;
        } else {
            int i39 = this.rowCount;
            int i40 = i39 + 1;
            this.rowCount = i40;
            this.nightDisabledRow = i39;
            int i41 = i40 + 1;
            this.rowCount = i41;
            this.nightScheduledRow = i40;
            int i42 = i41 + 1;
            this.rowCount = i42;
            this.nightAutomaticRow = i41;
            if (Build.VERSION.SDK_INT >= 29) {
                this.rowCount = i42 + 1;
                this.nightSystemDefaultRow = i42;
            }
            int i43 = this.rowCount;
            int i44 = i43 + 1;
            this.rowCount = i44;
            this.nightTypeInfoRow = i43;
            int i45 = Theme.selectedAutoNightType;
            if (i45 == 1) {
                int i46 = i44 + 1;
                this.rowCount = i46;
                this.scheduleHeaderRow = i44;
                int i47 = i46 + 1;
                this.rowCount = i47;
                this.scheduleLocationRow = i46;
                if (Theme.autoNightScheduleByLocation) {
                    int i48 = i47 + 1;
                    this.rowCount = i48;
                    this.scheduleUpdateLocationRow = i47;
                    this.rowCount = i48 + 1;
                    this.scheduleLocationInfoRow = i48;
                } else {
                    int i49 = i47 + 1;
                    this.rowCount = i49;
                    this.scheduleFromRow = i47;
                    int i50 = i49 + 1;
                    this.rowCount = i50;
                    this.scheduleToRow = i49;
                    this.rowCount = i50 + 1;
                    this.scheduleFromToInfoRow = i50;
                }
            } else if (i45 == 2) {
                int i51 = i44 + 1;
                this.rowCount = i51;
                this.automaticHeaderRow = i44;
                int i52 = i51 + 1;
                this.rowCount = i52;
                this.automaticBrightnessRow = i51;
                this.rowCount = i52 + 1;
                this.automaticBrightnessInfoRow = i52;
            }
            if (Theme.selectedAutoNightType != 0) {
                int i53 = this.rowCount;
                int i54 = i53 + 1;
                this.rowCount = i54;
                this.preferedHeaderRow = i53;
                this.rowCount = i54 + 1;
                this.themeListRow = i54;
                boolean zHasAccentColors2 = Theme.getCurrentNightTheme().hasAccentColors();
                this.hasThemeAccents = zHasAccentColors2;
                ThemesHorizontalListCell themesHorizontalListCell2 = this.themesHorizontalListCell;
                if (themesHorizontalListCell2 != null) {
                    themesHorizontalListCell2.setDrawDivider(zHasAccentColors2);
                }
                if (this.hasThemeAccents) {
                    int i55 = this.rowCount;
                    this.rowCount = i55 + 1;
                    this.themeAccentListRow = i55;
                }
                int i56 = this.rowCount;
                this.rowCount = i56 + 1;
                this.themeInfoRow = i56;
            }
        }
        ThemesHorizontalListCell themesHorizontalListCell3 = this.themesHorizontalListCell;
        if (themesHorizontalListCell3 != null) {
            themesHorizontalListCell3.notifyDataSetChanged(this.listView.getWidth());
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            if (this.currentType != 1 || (i2 = this.previousUpdatedType) == (i3 = Theme.selectedAutoNightType) || i2 == -1) {
                if (notify || this.previousUpdatedType == -1) {
                    listAdapter.notifyDataSetChanged();
                } else if (i5 == -1 && (i = this.themeAccentListRow) != -1) {
                    listAdapter.notifyItemInserted(i);
                } else if (i5 != -1 && this.themeAccentListRow == -1) {
                    listAdapter.notifyItemRemoved(i5);
                } else {
                    int i57 = this.themeAccentListRow;
                    if (i57 != -1) {
                        listAdapter.notifyItemChanged(i57);
                    }
                }
            } else {
                int i58 = this.nightTypeInfoRow + 1;
                if (i2 != i3) {
                    int i59 = 0;
                    while (true) {
                        if (i59 >= 4) {
                            break;
                        }
                        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(i59);
                        if (holder != null) {
                            View view = holder.itemView;
                            if (view instanceof ThemeTypeCell) {
                                ((ThemeTypeCell) view).setTypeChecked(i59 == Theme.selectedAutoNightType);
                            }
                        }
                        i59++;
                    }
                    int i60 = Theme.selectedAutoNightType;
                    if (i60 == 0) {
                        this.listAdapter.notifyItemRangeRemoved(i58, i4 - i58);
                    } else if (i60 == 1) {
                        int i61 = this.previousUpdatedType;
                        if (i61 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i58, this.rowCount - i58);
                        } else if (i61 == 2) {
                            this.listAdapter.notifyItemRangeRemoved(i58, 3);
                            this.listAdapter.notifyItemRangeInserted(i58, Theme.autoNightScheduleByLocation ? 4 : 5);
                        } else if (i61 == 3) {
                            this.listAdapter.notifyItemRangeInserted(i58, Theme.autoNightScheduleByLocation ? 4 : 5);
                        }
                    } else if (i60 == 2) {
                        int i62 = this.previousUpdatedType;
                        if (i62 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i58, this.rowCount - i58);
                        } else if (i62 == 1) {
                            this.listAdapter.notifyItemRangeRemoved(i58, Theme.autoNightScheduleByLocation ? 4 : 5);
                            this.listAdapter.notifyItemRangeInserted(i58, 3);
                        } else if (i62 == 3) {
                            this.listAdapter.notifyItemRangeInserted(i58, 3);
                        }
                    } else if (i60 == 3) {
                        int i63 = this.previousUpdatedType;
                        if (i63 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i58, this.rowCount - i58);
                        } else if (i63 == 2) {
                            this.listAdapter.notifyItemRangeRemoved(i58, 3);
                        } else if (i63 == 1) {
                            this.listAdapter.notifyItemRangeRemoved(i58, Theme.autoNightScheduleByLocation ? 4 : 5);
                        }
                    }
                } else {
                    boolean z = this.previousByLocation;
                    boolean z2 = Theme.autoNightScheduleByLocation;
                    if (z != z2) {
                        int i64 = i58 + 2;
                        listAdapter.notifyItemRangeRemoved(i64, z2 ? 3 : 2);
                        this.listAdapter.notifyItemRangeInserted(i64, Theme.autoNightScheduleByLocation ? 2 : 3);
                    }
                }
            }
        }
        if (this.currentType == 1) {
            this.previousByLocation = Theme.autoNightScheduleByLocation;
            this.previousUpdatedType = Theme.selectedAutoNightType;
        }
        updateMenuItem();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.themeListUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.themeAccentListUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.needShareTheme);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.needSetDayNightTheme);
        getNotificationCenter().addObserver(this, NotificationCenter.themeUploadedToServer);
        getNotificationCenter().addObserver(this, NotificationCenter.themeUploadError);
        if (this.currentType == 0) {
            Theme.loadRemoteThemes(this.currentAccount, true);
            Theme.checkCurrentRemoteTheme(true);
        }
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        stopLocationUpdate();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.themeListUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.themeAccentListUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needShareTheme);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needSetDayNightTheme);
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadedToServer);
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadError);
        Theme.saveAutoNightThemeConfig();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() throws Resources.NotFoundException {
        if (this.isFontFamilyChanged) {
            Theme.reloadAllResources(this.fragmentView.getContext());
            this.parentLayout.rebuildAllFragmentViews(false, false);
        }
        return super.onBackPressed();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        AlertDialog alertDialog;
        int i;
        if (id == NotificationCenter.locationPermissionGranted) {
            updateSunTime(null, true);
            return;
        }
        if (id == NotificationCenter.didSetNewWallpapper || id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView = this.listView;
            if (recyclerListView != null) {
                recyclerListView.invalidateViews();
            }
            updateMenuItem();
            return;
        }
        if (id == NotificationCenter.themeAccentListUpdated) {
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter == null || (i = this.themeAccentListRow) == -1) {
                return;
            }
            listAdapter.notifyItemChanged(i, new Object());
            return;
        }
        if (id == NotificationCenter.themeListUpdated) {
            updateRows(true);
            return;
        }
        if (id == NotificationCenter.themeUploadedToServer) {
            Theme.ThemeInfo themeInfo = (Theme.ThemeInfo) args[0];
            Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) args[1];
            if (themeInfo == this.sharingTheme && themeAccent == this.sharingAccent) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://");
                sb.append(getMessagesController().linkPrefix);
                sb.append("/addtheme/");
                sb.append((themeAccent != null ? themeAccent.info : themeInfo.info).slug);
                String string = sb.toString();
                showDialog(new ShareAlert(getParentActivity(), null, string, false, string, false));
                AlertDialog alertDialog2 = this.sharingProgressDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.themeUploadError) {
            Theme.ThemeInfo themeInfo2 = (Theme.ThemeInfo) args[0];
            Theme.ThemeAccent themeAccent2 = (Theme.ThemeAccent) args[1];
            if (themeInfo2 == this.sharingTheme && themeAccent2 == this.sharingAccent && (alertDialog = this.sharingProgressDialog) == null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        if (id == NotificationCenter.needShareTheme) {
            if (getParentActivity() == null || this.isPaused) {
                return;
            }
            this.sharingTheme = (Theme.ThemeInfo) args[0];
            this.sharingAccent = (Theme.ThemeAccent) args[1];
            AlertDialog alertDialog3 = new AlertDialog(getParentActivity(), 3);
            this.sharingProgressDialog = alertDialog3;
            alertDialog3.setCanCacnel(true);
            showDialog(this.sharingProgressDialog, new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$gO2vZhbmzHn8poKe4xVlDymO3YA
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$didReceivedNotification$1$ThemeActivity(dialogInterface);
                }
            });
            return;
        }
        if (id == NotificationCenter.needSetDayNightTheme) {
            updateMenuItem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$1$ThemeActivity(DialogInterface dialogInterface) {
        this.sharingProgressDialog = null;
        this.sharingTheme = null;
        this.sharingAccent = null;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("ChatSettings", R.string.ChatSettings));
            ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_other);
            this.menuItem = actionBarMenuItemAddItem;
            actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
            this.menuItem.addSubItem(3, R.drawable.msg_edit, LocaleController.getString("EditThemeColors", R.string.EditThemeColors));
            this.menuItem.addSubItem(1, R.drawable.menu_palette, LocaleController.getString("CreateNewThemeMenu", R.string.CreateNewThemeMenu));
            this.menuItem.addSubItem(4, R.drawable.msg_reset, LocaleController.getString("ThemeResetToDefaults", R.string.ThemeResetToDefaults));
        } else {
            this.actionBar.setTitle(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme));
        }
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1(context));
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView = frameLayout;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setAdapter(this.listAdapter);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$Jcg5BAh5g5gg-xKuqmsZhRUEPEI
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$5$ThemeActivity(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.ThemeActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        final /* synthetic */ Context val$context;

        AnonymousClass1(final Context val$context) {
            this.val$context = val$context;
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) throws Resources.NotFoundException {
            if (id == -1) {
                if (ThemeActivity.this.isFontFamilyChanged) {
                    Theme.reloadAllResources(this.val$context);
                    ((BaseFragment) ThemeActivity.this).parentLayout.rebuildAllFragmentViews(false, false);
                }
                ThemeActivity.this.finishFragment();
                return;
            }
            if (id == 1) {
                if (ThemeActivity.this.getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("NewTheme", R.string.NewTheme));
                builder.setMessage(LocaleController.getString("CreateNewThemeAlert", R.string.CreateNewThemeAlert));
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setPositiveButton(LocaleController.getString("CreateTheme", R.string.CreateTheme), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$1$MQssPdjthqVQ_DUVMFq-8CaioqI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onItemClick$0$ThemeActivity$1(dialogInterface, i);
                    }
                });
                ThemeActivity.this.showDialog(builder.create());
                return;
            }
            if (id == 2) {
                Theme.ThemeAccent accent = Theme.getCurrentTheme().getAccent(false);
                if (accent.info == null) {
                    ThemeActivity.this.getMessagesController().saveThemeToServer(accent.parentTheme, accent);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShareTheme, accent.parentTheme, accent);
                    return;
                }
                String str = "https://" + ThemeActivity.this.getMessagesController().linkPrefix + "/addtheme/" + accent.info.slug;
                ThemeActivity.this.showDialog(new ShareAlert(ThemeActivity.this.getParentActivity(), null, str, false, str, false));
                return;
            }
            if (id == 3) {
                Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
                Theme.ThemeAccent accent2 = currentTheme.getAccent(false);
                ThemeActivity themeActivity = ThemeActivity.this;
                themeActivity.presentFragment(new ThemePreviewActivity(currentTheme, false, 1, accent2.id >= 100, themeActivity.currentType == 1));
                return;
            }
            if (id != 4 || ThemeActivity.this.getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
            builder2.setTitle(LocaleController.getString("ThemeResetToDefaultsTitle", R.string.ThemeResetToDefaultsTitle));
            builder2.setMessage(LocaleController.getString("ThemeResetToDefaultsText", R.string.ThemeResetToDefaultsText));
            builder2.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$1$l_65OC5Xk5pAq76L-ism6X37_5Q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onItemClick$1$ThemeActivity$1(dialogInterface, i);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder2.create();
            ThemeActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ThemeActivity$1(DialogInterface dialogInterface, int i) {
            AlertsCreator.createThemeCreateDialog(ThemeActivity.this, 0, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$ThemeActivity$1(DialogInterface dialogInterface, int i) {
            boolean fontSize = ThemeActivity.this.setFontSize(AndroidUtilities.isTablet() ? 18 : 16);
            if (ThemeActivity.this.setBubbleRadius(10, true)) {
                fontSize = true;
            }
            if (fontSize) {
                ThemeActivity.this.listAdapter.notifyItemChanged(ThemeActivity.this.textSizeRow, new Object());
                ThemeActivity.this.listAdapter.notifyItemChanged(ThemeActivity.this.bubbleRadiusRow, new Object());
            }
            if (ThemeActivity.this.themesHorizontalListCell != null) {
                Theme.ThemeInfo theme = Theme.getTheme("Blue");
                Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
                Theme.ThemeAccent themeAccent = theme.themeAccentsMap.get(Theme.DEFALT_THEME_ACCENT_ID);
                if (themeAccent != null) {
                    Theme.OverrideWallpaperInfo overrideWallpaperInfo = new Theme.OverrideWallpaperInfo();
                    overrideWallpaperInfo.slug = "d";
                    overrideWallpaperInfo.fileName = "Blue_99_wp.jpg";
                    overrideWallpaperInfo.originalFileName = "Blue_99_wp.jpg";
                    themeAccent.overrideWallpaper = overrideWallpaperInfo;
                    theme.setOverrideWallpaper(overrideWallpaperInfo);
                }
                if (theme != currentTheme) {
                    theme.setCurrentAccentId(Theme.DEFALT_THEME_ACCENT_ID);
                    Theme.saveThemeAccents(theme, true, false, true, false);
                    ThemeActivity.this.themesHorizontalListCell.selectTheme(theme);
                    ThemeActivity.this.themesHorizontalListCell.smoothScrollToPosition(0);
                    return;
                }
                if (theme.currentAccentId != Theme.DEFALT_THEME_ACCENT_ID) {
                    NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                    int i2 = NotificationCenter.needSetDayNightTheme;
                    Object[] objArr = new Object[4];
                    objArr[0] = currentTheme;
                    objArr[1] = Boolean.valueOf(ThemeActivity.this.currentType == 1);
                    objArr[2] = null;
                    objArr[3] = Integer.valueOf(Theme.DEFALT_THEME_ACCENT_ID);
                    globalInstance.postNotificationName(i2, objArr);
                    ThemeActivity.this.listAdapter.notifyItemChanged(ThemeActivity.this.themeAccentListRow);
                    return;
                }
                Theme.reloadWallpaper();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ThemeActivity(View view, final int i, float f, float f2) {
        int i2;
        int i3;
        String string;
        if (i == this.enableAnimationsRow) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            boolean z = globalMainSettings.getBoolean("view_animations", true);
            SharedPreferences.Editor editorEdit = globalMainSettings.edit();
            editorEdit.putBoolean("view_animations", !z);
            editorEdit.commit();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(!z);
                return;
            }
            return;
        }
        if (i == this.backgroundRow) {
            presentFragment(new WallpapersListActivity(0));
            return;
        }
        if (i == this.sendByEnterRow) {
            SharedPreferences globalMainSettings2 = MessagesController.getGlobalMainSettings();
            boolean z2 = globalMainSettings2.getBoolean("send_by_enter", false);
            SharedPreferences.Editor editorEdit2 = globalMainSettings2.edit();
            editorEdit2.putBoolean("send_by_enter", !z2);
            editorEdit2.commit();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(!z2);
                return;
            }
            return;
        }
        if (i == this.raiseToSpeakRow) {
            SharedConfig.toogleRaiseToSpeak();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.raiseToSpeak);
                return;
            }
            return;
        }
        if (i == this.proximitySensorRow) {
            SharedConfig.toggleProximitySensor();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.proximitysensor);
                return;
            }
            return;
        }
        if (i == this.saveToGalleryRow) {
            SharedConfig.toggleSaveToGallery();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.saveToGallery);
                return;
            }
            return;
        }
        if (i == this.distanceRow) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("DistanceUnitsTitle", R.string.DistanceUnitsTitle));
            builder.setItems(new CharSequence[]{LocaleController.getString("DistanceUnitsAutomatic", R.string.DistanceUnitsAutomatic), LocaleController.getString("DistanceUnitsKilometers", R.string.DistanceUnitsKilometers), LocaleController.getString("DistanceUnitsMiles", R.string.DistanceUnitsMiles)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$1wF7bxuJ1eRudMRWrA8Q3gjzTtU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$2$ThemeActivity(dialogInterface, i4);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        if (i == this.customTabsRow) {
            SharedConfig.toggleCustomTabs();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.customTabs);
                return;
            }
            return;
        }
        if (i == this.directShareRow) {
            SharedConfig.toggleDirectShare();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.directShare);
                return;
            }
            return;
        }
        if (i == this.contactsReimportRow) {
            return;
        }
        if (i == this.contactsSortRow) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setTitle(LocaleController.getString("SortBy", R.string.SortBy));
            builder2.setItems(new CharSequence[]{LocaleController.getString("Default", R.string.Default), LocaleController.getString("SortFirstName", R.string.SortFirstName), LocaleController.getString("SortLastName", R.string.SortLastName)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$E-cGeSP8POyuVn1BEG-fa3S5XnE
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$3$ThemeActivity(i, dialogInterface, i4);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder2.create());
            return;
        }
        if (i == this.stickersRow) {
            presentFragment(new StickersActivity(0));
            return;
        }
        if (i == this.emojiRow) {
            SharedConfig.toggleBigEmoji();
            if (view instanceof TextCheckCell) {
                ((TextCheckCell) view).setChecked(SharedConfig.allowBigEmoji);
                return;
            }
            return;
        }
        if (i == this.nightThemeRow) {
            if ((LocaleController.isRTL && f <= AndroidUtilities.dp(76.0f)) || (!LocaleController.isRTL && f >= view.getMeasuredWidth() - AndroidUtilities.dp(76.0f))) {
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
                if (Theme.selectedAutoNightType == 0) {
                    Theme.selectedAutoNightType = 2;
                    notificationsCheckCell.setChecked(true);
                } else {
                    Theme.selectedAutoNightType = 0;
                    notificationsCheckCell.setChecked(false);
                }
                Theme.saveAutoNightThemeConfig();
                Theme.checkAutoNightThemeConditions(true);
                boolean z3 = Theme.selectedAutoNightType != 0;
                String currentNightThemeName = z3 ? Theme.getCurrentNightThemeName() : LocaleController.getString("AutoNightThemeOff", R.string.AutoNightThemeOff);
                if (z3) {
                    int i4 = Theme.selectedAutoNightType;
                    if (i4 == 1) {
                        string = LocaleController.getString("AutoNightScheduled", R.string.AutoNightScheduled);
                    } else if (i4 == 3) {
                        string = LocaleController.getString("AutoNightSystemDefault", R.string.AutoNightSystemDefault);
                    } else {
                        string = LocaleController.getString("AutoNightAdaptive", R.string.AutoNightAdaptive);
                    }
                    currentNightThemeName = string + " " + currentNightThemeName;
                }
                notificationsCheckCell.setTextAndValueAndCheck(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), currentNightThemeName, z3, true);
                return;
            }
            presentFragment(new ThemeActivity(1));
            return;
        }
        if (i == this.nightDisabledRow) {
            if (Theme.selectedAutoNightType == 0) {
                return;
            }
            Theme.selectedAutoNightType = 0;
            updateRows(true);
            Theme.checkAutoNightThemeConditions();
            return;
        }
        if (i == this.nightScheduledRow) {
            if (Theme.selectedAutoNightType == 1) {
                return;
            }
            Theme.selectedAutoNightType = 1;
            if (Theme.autoNightScheduleByLocation) {
                updateSunTime(null, true);
            }
            updateRows(true);
            Theme.checkAutoNightThemeConditions();
            return;
        }
        if (i == this.nightAutomaticRow) {
            if (Theme.selectedAutoNightType == 2) {
                return;
            }
            Theme.selectedAutoNightType = 2;
            updateRows(true);
            Theme.checkAutoNightThemeConditions();
            return;
        }
        if (i == this.nightSystemDefaultRow) {
            if (Theme.selectedAutoNightType == 3) {
                return;
            }
            Theme.selectedAutoNightType = 3;
            updateRows(true);
            Theme.checkAutoNightThemeConditions();
            return;
        }
        if (i == this.scheduleLocationRow) {
            boolean z4 = !Theme.autoNightScheduleByLocation;
            Theme.autoNightScheduleByLocation = z4;
            ((TextCheckCell) view).setChecked(z4);
            updateRows(true);
            if (Theme.autoNightScheduleByLocation) {
                updateSunTime(null, true);
            }
            Theme.checkAutoNightThemeConditions();
            return;
        }
        if (i == this.scheduleFromRow || i == this.scheduleToRow) {
            if (getParentActivity() == null) {
                return;
            }
            if (i == this.scheduleFromRow) {
                i2 = Theme.autoNightDayStartTime;
                i3 = i2 / 60;
            } else {
                i2 = Theme.autoNightDayEndTime;
                i3 = i2 / 60;
            }
            final TextSettingsCell textSettingsCell = (TextSettingsCell) view;
            showDialog(new TimePickerDialog(getParentActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$nWTgKRUqez7ked3AwK-GlP4iMD4
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i5, int i6) {
                    this.f$0.lambda$createView$4$ThemeActivity(i, textSettingsCell, timePicker, i5, i6);
                }
            }, i3, i2 - (i3 * 60), true));
            return;
        }
        if (i == this.scheduleUpdateLocationRow) {
            updateSunTime(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ThemeActivity(DialogInterface dialogInterface, int i) {
        SharedConfig.setDistanceSystemType(i);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.distanceRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.listAdapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, this.distanceRow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ThemeActivity(int i, DialogInterface dialogInterface, int i2) {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("sortContactsBy", i2);
        editorEdit.commit();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ThemeActivity(int i, TextSettingsCell textSettingsCell, TimePicker timePicker, int i2, int i3) {
        int i4 = (i2 * 60) + i3;
        if (i == this.scheduleFromRow) {
            Theme.autoNightDayStartTime = i4;
            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightFrom", R.string.AutoNightFrom), String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)), true);
        } else {
            Theme.autoNightDayEndTime = i4;
            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTo", R.string.AutoNightTo), String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)), true);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.listAdapter != null) {
            updateRows(true);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
            AndroidUtilities.setAdjustResizeToNothing(getParentActivity(), this.classGuid);
        }
    }

    private void updateMenuItem() {
        Theme.OverrideWallpaperInfo overrideWallpaperInfo;
        if (this.menuItem == null) {
            return;
        }
        Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
        Theme.ThemeAccent accent = currentTheme.getAccent(false);
        ArrayList<Theme.ThemeAccent> arrayList = currentTheme.themeAccents;
        if (arrayList != null && !arrayList.isEmpty() && accent != null && accent.id >= 100) {
            this.menuItem.showSubItem(2);
            this.menuItem.showSubItem(3);
        } else {
            this.menuItem.hideSubItem(2);
            this.menuItem.hideSubItem(3);
        }
        int i = AndroidUtilities.isTablet() ? 18 : 16;
        Theme.ThemeInfo currentTheme2 = Theme.getCurrentTheme();
        if (SharedConfig.fontSize != i || SharedConfig.bubbleRadius != 10 || !currentTheme2.firstAccentIsDefault || currentTheme2.currentAccentId != Theme.DEFALT_THEME_ACCENT_ID || (accent != null && (overrideWallpaperInfo = accent.overrideWallpaper) != null && !"d".equals(overrideWallpaperInfo.slug))) {
            this.menuItem.showSubItem(4);
        } else {
            this.menuItem.hideSubItem(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSunTime(Location lastKnownLocation, boolean forceUpdate) {
        Activity parentActivity;
        LocationManager locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
        if (Build.VERSION.SDK_INT >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            return;
        }
        if (getParentActivity() != null) {
            if (!getParentActivity().getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
                return;
            }
            try {
                if (!((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isProviderEnabled("gps")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                    builder.setTitle(LocaleController.getString("GpsDisabledAlertTitle", R.string.GpsDisabledAlertTitle));
                    builder.setMessage(LocaleController.getString("GpsDisabledAlertText", R.string.GpsDisabledAlertText));
                    builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$t8k_exeyErOgQg8G1PqFk51tXuw
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$updateSunTime$6$ThemeActivity(dialogInterface, i);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    showDialog(builder.create());
                    return;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        try {
            lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                lastKnownLocation = locationManager.getLastKnownLocation("network");
            }
            if (lastKnownLocation == null) {
                lastKnownLocation = locationManager.getLastKnownLocation("passive");
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        if (lastKnownLocation == null || forceUpdate) {
            startLocationUpdate();
            if (lastKnownLocation == null) {
                return;
            }
        }
        Theme.autoNightLocationLatitude = lastKnownLocation.getLatitude();
        Theme.autoNightLocationLongitude = lastKnownLocation.getLongitude();
        int[] iArrCalculateSunriseSunset = SunDate.calculateSunriseSunset(Theme.autoNightLocationLatitude, Theme.autoNightLocationLongitude);
        Theme.autoNightSunriseTime = iArrCalculateSunriseSunset[0];
        Theme.autoNightSunsetTime = iArrCalculateSunriseSunset[1];
        Theme.autoNightCityName = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Theme.autoNightLastSunCheckDay = calendar.get(5);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$eW109YLnng_8e0Cdj22mjPQK4gs
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$updateSunTime$8$ThemeActivity();
            }
        });
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(this.scheduleLocationInfoRow);
        if (holder != null) {
            View view = holder.itemView;
            if (view instanceof TextInfoPrivacyCell) {
                ((TextInfoPrivacyCell) view).setText(getLocationSunString());
            }
        }
        if (Theme.autoNightScheduleByLocation && Theme.selectedAutoNightType == 1) {
            Theme.checkAutoNightThemeConditions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSunTime$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSunTime$6$ThemeActivity(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSunTime$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSunTime$8$ThemeActivity() throws IOException {
        final String locality = null;
        try {
            List<Address> fromLocation = new Geocoder(ApplicationLoader.applicationContext, Locale.getDefault()).getFromLocation(Theme.autoNightLocationLatitude, Theme.autoNightLocationLongitude, 1);
            if (fromLocation.size() > 0) {
                locality = fromLocation.get(0).getLocality();
            }
        } catch (Exception unused) {
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$uqnThF6pBObAyrlyMoYNbIdCv6w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateSunTime$7$ThemeActivity(locality);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSunTime$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSunTime$7$ThemeActivity(String str) {
        RecyclerListView.Holder holder;
        Theme.autoNightCityName = str;
        if (str == null) {
            Theme.autoNightCityName = String.format("(%.06f, %.06f)", Double.valueOf(Theme.autoNightLocationLatitude), Double.valueOf(Theme.autoNightLocationLongitude));
        }
        Theme.saveAutoNightThemeConfig();
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null || (holder = (RecyclerListView.Holder) recyclerListView.findViewHolderForAdapterPosition(this.scheduleUpdateLocationRow)) == null) {
            return;
        }
        View view = holder.itemView;
        if (view instanceof TextSettingsCell) {
            ((TextSettingsCell) view).setTextAndValue(LocaleController.getString("AutoNightUpdateLocation", R.string.AutoNightUpdateLocation), Theme.autoNightCityName, false);
        }
    }

    private void startLocationUpdate() {
        if (this.updatingLocation) {
            return;
        }
        this.updatingLocation = true;
        LocationManager locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
        try {
            locationManager.requestLocationUpdates("gps", 1L, 0.0f, this.gpsLocationListener);
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            locationManager.requestLocationUpdates("network", 1L, 0.0f, this.networkLocationListener);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLocationUpdate() {
        this.updatingLocation = false;
        LocationManager locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
        locationManager.removeUpdates(this.gpsLocationListener);
        locationManager.removeUpdates(this.networkLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocationSunString() {
        int i = Theme.autoNightSunriseTime;
        int i2 = i / 60;
        String str = String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i - (i2 * 60)));
        int i3 = Theme.autoNightSunsetTime;
        int i4 = i3 / 60;
        return LocaleController.formatString("AutoNightUpdateLocationInfo", R.string.AutoNightUpdateLocationInfo, String.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3 - (i4 * 60))), str);
    }

    private static class InnerAccentView extends View {
        private ObjectAnimator checkAnimator;
        private boolean checked;
        private float checkedState;
        private Theme.ThemeAccent currentAccent;
        private Theme.ThemeInfo currentTheme;
        private final Paint paint;

        InnerAccentView(Context context) {
            super(context);
            this.paint = new Paint(1);
        }

        void setThemeAndColor(Theme.ThemeInfo themeInfo, Theme.ThemeAccent accent) {
            this.currentTheme = themeInfo;
            this.currentAccent = accent;
            updateCheckedState(false);
        }

        void updateCheckedState(boolean animate) {
            this.checked = this.currentTheme.currentAccentId == this.currentAccent.id;
            ObjectAnimator objectAnimator = this.checkAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (animate) {
                float[] fArr = new float[1];
                fArr[0] = this.checked ? 1.0f : 0.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "checkedState", fArr);
                this.checkAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                this.checkAnimator.start();
                return;
            }
            setCheckedState(this.checked ? 1.0f : 0.0f);
        }

        @Keep
        public void setCheckedState(float state) {
            this.checkedState = state;
            invalidate();
        }

        @Keep
        public float getCheckedState() {
            return this.checkedState;
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            updateCheckedState(false);
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(62.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(62.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float fDp = AndroidUtilities.dp(20.0f);
            float measuredWidth = getMeasuredWidth() * 0.5f;
            float measuredHeight = getMeasuredHeight() * 0.5f;
            this.paint.setColor(this.currentAccent.accentColor);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(3.0f));
            this.paint.setAlpha(Math.round(this.checkedState * 255.0f));
            canvas.drawCircle(measuredWidth, measuredHeight, fDp - (this.paint.getStrokeWidth() * 0.5f), this.paint);
            this.paint.setAlpha(255);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(measuredWidth, measuredHeight, fDp - (AndroidUtilities.dp(5.0f) * this.checkedState), this.paint);
            if (this.checkedState != 0.0f) {
                this.paint.setColor(-1);
                this.paint.setAlpha(Math.round(this.checkedState * 255.0f));
                canvas.drawCircle(measuredWidth, measuredHeight, AndroidUtilities.dp(2.0f), this.paint);
                canvas.drawCircle(measuredWidth - (AndroidUtilities.dp(7.0f) * this.checkedState), measuredHeight, AndroidUtilities.dp(2.0f), this.paint);
                canvas.drawCircle((AndroidUtilities.dp(7.0f) * this.checkedState) + measuredWidth, measuredHeight, AndroidUtilities.dp(2.0f), this.paint);
            }
            int i = this.currentAccent.myMessagesAccentColor;
            if (i == 0 || this.checkedState == 1.0f) {
                return;
            }
            this.paint.setColor(i);
            canvas.drawCircle(measuredWidth, measuredHeight, AndroidUtilities.dp(8.0f) * (1.0f - this.checkedState), this.paint);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            info.setClassName(Button.class.getName());
            info.setChecked(this.checked);
            info.setCheckable(true);
            info.setEnabled(true);
        }
    }

    private static class InnerCustomAccentView extends View {
        private int[] colors;
        private final Paint paint;

        InnerCustomAccentView(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.colors = new int[7];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTheme(Theme.ThemeInfo themeInfo) {
            if (themeInfo.defaultAccentCount >= 8) {
                this.colors = new int[]{themeInfo.getAccentColor(6), themeInfo.getAccentColor(4), themeInfo.getAccentColor(7), themeInfo.getAccentColor(2), themeInfo.getAccentColor(0), themeInfo.getAccentColor(5), themeInfo.getAccentColor(3)};
            } else {
                this.colors = new int[7];
            }
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(62.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(62.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float measuredWidth = getMeasuredWidth() * 0.5f;
            float measuredHeight = getMeasuredHeight() * 0.5f;
            float fDp = AndroidUtilities.dp(5.0f);
            float fDp2 = AndroidUtilities.dp(20.0f) - fDp;
            this.paint.setStyle(Paint.Style.FILL);
            int i = 0;
            this.paint.setColor(this.colors[0]);
            canvas.drawCircle(measuredWidth, measuredHeight, fDp, this.paint);
            double d = 0.0d;
            while (i < 6) {
                float fSin = (((float) Math.sin(d)) * fDp2) + measuredWidth;
                float fCos = measuredHeight - (((float) Math.cos(d)) * fDp2);
                i++;
                this.paint.setColor(this.colors[i]);
                canvas.drawCircle(fSin, fCos, fDp, this.paint);
                d += 1.0471975511965976d;
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            info.setClassName(Button.class.getName());
            info.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ThemeAccentsListAdapter extends RecyclerListView.SelectionAdapter {
        private Theme.ThemeInfo currentTheme;
        private Context mContext;
        private ArrayList<Theme.ThemeAccent> themeAccents;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        ThemeAccentsListAdapter(Context context) {
            this.mContext = context;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.currentTheme = ThemeActivity.this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme();
            this.themeAccents = new ArrayList<>(this.currentTheme.themeAccents);
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position == getItemCount() - 1 ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                return new RecyclerListView.Holder(new InnerAccentView(this.mContext));
            }
            return new RecyclerListView.Holder(new InnerCustomAccentView(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = getItemViewType(position);
            if (itemViewType == 0) {
                ((InnerAccentView) holder.itemView).setThemeAndColor(this.currentTheme, this.themeAccents.get(position));
            } else {
                if (itemViewType != 1) {
                    return;
                }
                ((InnerCustomAccentView) holder.itemView).setTheme(this.currentTheme);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.themeAccents.isEmpty()) {
                return 0;
            }
            return this.themeAccents.size() + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int findCurrentAccent() {
            return this.themeAccents.indexOf(this.currentTheme.getAccent(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private boolean first = true;
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ThemeActivity.this.rowCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 1 || itemViewType == 4 || itemViewType == 7 || itemViewType == 10 || itemViewType == 11 || itemViewType == 12 || itemViewType == 14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showOptionsForTheme(final Theme.ThemeInfo themeInfo) {
            int[] iArr;
            CharSequence[] charSequenceArr;
            if (ThemeActivity.this.getParentActivity() != null) {
                if ((themeInfo.info == null || themeInfo.themeLoaded) && ThemeActivity.this.currentType != 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                    boolean z = false;
                    if (themeInfo.pathToFile == null) {
                        charSequenceArr = new CharSequence[]{null, LocaleController.getString("ExportTheme", R.string.ExportTheme)};
                        iArr = new int[]{0, R.drawable.msg_shareout};
                    } else {
                        TLRPC$TL_theme tLRPC$TL_theme = themeInfo.info;
                        boolean z2 = tLRPC$TL_theme == null || !tLRPC$TL_theme.isDefault;
                        CharSequence[] charSequenceArr2 = new CharSequence[4];
                        charSequenceArr2[0] = LocaleController.getString("ExportTheme", R.string.ExportTheme);
                        TLRPC$TL_theme tLRPC$TL_theme2 = themeInfo.info;
                        charSequenceArr2[1] = (tLRPC$TL_theme2 == null || (!tLRPC$TL_theme2.isDefault && tLRPC$TL_theme2.creator)) ? LocaleController.getString("Edit", R.string.Edit) : null;
                        TLRPC$TL_theme tLRPC$TL_theme3 = themeInfo.info;
                        charSequenceArr2[2] = (tLRPC$TL_theme3 == null || !tLRPC$TL_theme3.creator) ? null : LocaleController.getString("ThemeSetUrl", R.string.ThemeSetUrl);
                        charSequenceArr2[3] = z2 ? LocaleController.getString("Delete", R.string.Delete) : null;
                        iArr = new int[]{R.drawable.msg_shareout, R.drawable.msg_edit, R.drawable.msg_link, R.drawable.msg_delete};
                        z = z2;
                        charSequenceArr = charSequenceArr2;
                    }
                    builder.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$ListAdapter$1OJ1btMgluChp3VBb4eAwGVrFss
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) throws Throwable {
                            this.f$0.lambda$showOptionsForTheme$1$ThemeActivity$ListAdapter(themeInfo, dialogInterface, i);
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    ThemeActivity.this.showDialog(alertDialogCreate);
                    if (z) {
                        alertDialogCreate.setItemColor(alertDialogCreate.getItemsCount() - 1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00cb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00cc A[Catch: Exception -> 0x0118, TRY_LEAVE, TryCatch #5 {Exception -> 0x0118, blocks: (B:48:0x00c5, B:51:0x00cc, B:58:0x0102, B:57:0x00fb, B:56:0x00f3, B:54:0x00e0), top: B:86:0x00c5, inners: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:76:0x009e). Please report as a decompilation issue!!! */
        /* renamed from: lambda$showOptionsForTheme$1, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$showOptionsForTheme$1$ThemeActivity$ListAdapter(final ir.eitaa.ui.ActionBar.Theme.ThemeInfo r5, android.content.DialogInterface r6, int r7) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 439
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemeActivity.ListAdapter.lambda$showOptionsForTheme$1$ThemeActivity$ListAdapter(ir.eitaa.ui.ActionBar.Theme$ThemeInfo, android.content.DialogInterface, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showOptionsForTheme$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showOptionsForTheme$0$ThemeActivity$ListAdapter(Theme.ThemeInfo themeInfo, DialogInterface dialogInterface, int i) {
            MessagesController.getInstance(themeInfo.account).saveTheme(themeInfo, null, themeInfo == Theme.getCurrentNightTheme(), true);
            if (Theme.deleteTheme(themeInfo)) {
                ((BaseFragment) ThemeActivity.this).parentLayout.rebuildAllFragmentViews(true, true);
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.themeListUpdated, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$2$ThemeActivity$ListAdapter(ThemeAccentsListAdapter themeAccentsListAdapter, RecyclerListView recyclerListView, View view, int i) {
            Theme.ThemeInfo theme = Theme.getTheme();
            if (i != themeAccentsListAdapter.getItemCount() - 1) {
                Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) themeAccentsListAdapter.themeAccents.get(i);
                if (!TextUtils.isEmpty(themeAccent.patternSlug) && themeAccent.id != Theme.DEFALT_THEME_ACCENT_ID) {
                    Theme.PatternsLoader.createLoader(false);
                }
                int i2 = theme.currentAccentId;
                int i3 = themeAccent.id;
                if (i2 != i3) {
                    NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                    int i4 = NotificationCenter.needSetDayNightTheme;
                    Object[] objArr = new Object[4];
                    objArr[0] = theme;
                    objArr[1] = Boolean.valueOf(ThemeActivity.this.currentType == 1);
                    objArr[2] = null;
                    objArr[3] = Integer.valueOf(themeAccent.id);
                    globalInstance.postNotificationName(i4, objArr);
                } else {
                    ThemeActivity themeActivity = ThemeActivity.this;
                    themeActivity.presentFragment(new ThemePreviewActivity(theme, false, 1, i3 >= 100, themeActivity.currentType == 1));
                }
            } else {
                ThemeActivity themeActivity2 = ThemeActivity.this;
                themeActivity2.presentFragment(new ThemePreviewActivity(theme, false, 1, false, themeActivity2.currentType == 1));
            }
            int left = view.getLeft();
            int right = view.getRight();
            int iDp = AndroidUtilities.dp(52.0f);
            int i5 = left - iDp;
            if (i5 < 0) {
                recyclerListView.smoothScrollBy(i5, 0);
            } else {
                int i6 = right + iDp;
                if (i6 > recyclerListView.getMeasuredWidth()) {
                    recyclerListView.smoothScrollBy(i6 - recyclerListView.getMeasuredWidth(), 0);
                }
            }
            int childCount = recyclerListView.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = recyclerListView.getChildAt(i7);
                if (childAt instanceof InnerAccentView) {
                    ((InnerAccentView) childAt).updateCheckedState(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$5$ThemeActivity$ListAdapter(final ThemeAccentsListAdapter themeAccentsListAdapter, View view, int i) {
            if (i >= 0 && i < themeAccentsListAdapter.themeAccents.size()) {
                final Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) themeAccentsListAdapter.themeAccents.get(i);
                if (themeAccent.id >= 100) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                    CharSequence[] charSequenceArr = new CharSequence[3];
                    charSequenceArr[0] = LocaleController.getString("OpenInEditor", R.string.OpenInEditor);
                    TLRPC$TL_theme tLRPC$TL_theme = themeAccent.info;
                    charSequenceArr[1] = (tLRPC$TL_theme == null || !tLRPC$TL_theme.creator) ? null : LocaleController.getString("ThemeSetUrl", R.string.ThemeSetUrl);
                    charSequenceArr[2] = LocaleController.getString("DeleteTheme", R.string.DeleteTheme);
                    builder.setItems(charSequenceArr, new int[]{R.drawable.msg_edit, R.drawable.msg_link, R.drawable.msg_delete}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$ListAdapter$0FR9mr4gMDpSNbEo3FI6ZXptNp0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onCreateViewHolder$4$ThemeActivity$ListAdapter(themeAccent, themeAccentsListAdapter, dialogInterface, i2);
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    ThemeActivity.this.showDialog(alertDialogCreate);
                    alertDialogCreate.setItemColor(alertDialogCreate.getItemsCount() - 1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$4$ThemeActivity$ListAdapter(final Theme.ThemeAccent themeAccent, final ThemeAccentsListAdapter themeAccentsListAdapter, DialogInterface dialogInterface, int i) {
            if (ThemeActivity.this.getParentActivity() == null) {
                return;
            }
            if (i == 0) {
                AlertsCreator.createThemeCreateDialog(ThemeActivity.this, i != 1 ? 1 : 2, themeAccent.parentTheme, themeAccent);
                return;
            }
            if (i == 1) {
                ThemeActivity.this.presentFragment(new ThemeSetUrlActivity(themeAccent.parentTheme, themeAccent, false));
                return;
            }
            if (i != 2 || ThemeActivity.this.getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("DeleteThemeTitle", R.string.DeleteThemeTitle));
            builder.setMessage(LocaleController.getString("DeleteThemeAlert", R.string.DeleteThemeAlert));
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$ListAdapter$BK2STOVOKCBF9ZYvHiWjlIqvvBw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$onCreateViewHolder$3$ThemeActivity$ListAdapter(themeAccentsListAdapter, themeAccent, dialogInterface2, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            ThemeActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$3$ThemeActivity$ListAdapter(ThemeAccentsListAdapter themeAccentsListAdapter, Theme.ThemeAccent themeAccent, DialogInterface dialogInterface, int i) {
            if (Theme.deleteThemeAccent(themeAccentsListAdapter.currentTheme, themeAccent, true)) {
                Theme.refreshThemeColors();
                NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                int i2 = NotificationCenter.needSetDayNightTheme;
                Object[] objArr = new Object[4];
                objArr[0] = Theme.getActiveTheme();
                objArr[1] = Boolean.valueOf(ThemeActivity.this.currentType == 1);
                objArr[2] = null;
                objArr[3] = -1;
                globalInstance.postNotificationName(i2, objArr);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textSettingsCell;
            final RecyclerListView recyclerListView;
            switch (viewType) {
                case 1:
                    textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 2:
                    textSettingsCell = new TextInfoPrivacyCell(this.mContext);
                    textSettingsCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    break;
                case 3:
                    textSettingsCell = new ShadowSectionCell(this.mContext);
                    break;
                case 4:
                    textSettingsCell = new ThemeTypeCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 5:
                    textSettingsCell = new HeaderCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 6:
                    textSettingsCell = new BrightnessControlCell(this.mContext) { // from class: ir.eitaa.ui.ThemeActivity.ListAdapter.1
                        @Override // ir.eitaa.ui.Cells.BrightnessControlCell
                        protected void didChangedValue(float value) {
                            int i = (int) (Theme.autoNightBrighnessThreshold * 100.0f);
                            int i2 = (int) (value * 100.0f);
                            Theme.autoNightBrighnessThreshold = value;
                            if (i != i2) {
                                RecyclerListView.Holder holder = (RecyclerListView.Holder) ThemeActivity.this.listView.findViewHolderForAdapterPosition(ThemeActivity.this.automaticBrightnessInfoRow);
                                if (holder != null) {
                                    ((TextInfoPrivacyCell) holder.itemView).setText(LocaleController.formatString("AutoNightBrightnessInfo", R.string.AutoNightBrightnessInfo, Integer.valueOf((int) (Theme.autoNightBrighnessThreshold * 100.0f))));
                                }
                                Theme.checkAutoNightThemeConditions(true);
                            }
                        }
                    };
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 7:
                    textSettingsCell = new TextCheckCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 8:
                    textSettingsCell = ThemeActivity.this.new TextSizeCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 9:
                    textSettingsCell = new ChatListCell(this.mContext) { // from class: ir.eitaa.ui.ThemeActivity.ListAdapter.2
                        @Override // ir.eitaa.ui.Cells.ChatListCell
                        protected void didSelectChatType(boolean threeLines) {
                            SharedConfig.setUseThreeLinesLayout(threeLines);
                        }
                    };
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 10:
                    textSettingsCell = new NotificationsCheckCell(this.mContext, 21, 64, false);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 11:
                    this.first = true;
                    ThemeActivity.this.themesHorizontalListCell = new ThemesHorizontalListCell(this.mContext, ThemeActivity.this.currentType, ThemeActivity.this.defaultThemes, ThemeActivity.this.darkThemes) { // from class: ir.eitaa.ui.ThemeActivity.ListAdapter.3
                        @Override // ir.eitaa.ui.Cells.ThemesHorizontalListCell
                        protected void showOptionsForTheme(Theme.ThemeInfo themeInfo) {
                            ThemeActivity.this.listAdapter.showOptionsForTheme(themeInfo);
                        }

                        @Override // ir.eitaa.ui.Cells.ThemesHorizontalListCell
                        protected void presentFragment(BaseFragment fragment) {
                            ThemeActivity.this.presentFragment(fragment);
                        }

                        @Override // ir.eitaa.ui.Cells.ThemesHorizontalListCell
                        protected void updateRows() {
                            ThemeActivity.this.updateRows(false);
                        }
                    };
                    ThemeActivity.this.themesHorizontalListCell.setDrawDivider(ThemeActivity.this.hasThemeAccents);
                    ThemeActivity.this.themesHorizontalListCell.setFocusable(false);
                    recyclerListView = ThemeActivity.this.themesHorizontalListCell;
                    recyclerListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(148.0f)));
                    textSettingsCell = recyclerListView;
                    break;
                case 12:
                    recyclerListView = new TintRecyclerListView(this.mContext) { // from class: ir.eitaa.ui.ThemeActivity.ListAdapter.4
                        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                        public boolean onInterceptTouchEvent(MotionEvent e) {
                            if (getParent() != null && getParent().getParent() != null) {
                                getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                            }
                            return super.onInterceptTouchEvent(e);
                        }
                    };
                    recyclerListView.setFocusable(false);
                    recyclerListView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    recyclerListView.setItemAnimator(null);
                    recyclerListView.setLayoutAnimation(null);
                    recyclerListView.setPadding(AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(11.0f), 0);
                    recyclerListView.setClipToPadding(false);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
                    linearLayoutManager.setOrientation(0);
                    recyclerListView.setLayoutManager(linearLayoutManager);
                    final ThemeAccentsListAdapter themeAccentsListAdapter = ThemeActivity.this.new ThemeAccentsListAdapter(this.mContext);
                    recyclerListView.setAdapter(themeAccentsListAdapter);
                    recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$ListAdapter$UTqoiPFSwXVPWcejfLMQY3YxUKY
                        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                        public final void onItemClick(View view, int i) {
                            this.f$0.lambda$onCreateViewHolder$2$ThemeActivity$ListAdapter(themeAccentsListAdapter, recyclerListView, view, i);
                        }
                    });
                    recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeActivity$ListAdapter$a09hz1a9W9Y_9o4u_YaKBajFpdA
                        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                        public final boolean onItemClick(View view, int i) {
                            return this.f$0.lambda$onCreateViewHolder$5$ThemeActivity$ListAdapter(themeAccentsListAdapter, view, i);
                        }
                    });
                    recyclerListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(62.0f)));
                    textSettingsCell = recyclerListView;
                    break;
                case 13:
                    textSettingsCell = ThemeActivity.this.new BubbleRadiusCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 14:
                default:
                    textSettingsCell = new TextCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    break;
                case 15:
                    textSettingsCell = new SwipeGestureSettingsView(this.mContext, ((BaseFragment) ThemeActivity.this).currentAccount);
                    break;
                case 16:
                    textSettingsCell = new FontSettingView(this.mContext, new FontSettingView.OnFontSelect() { // from class: ir.eitaa.ui.ThemeActivity.ListAdapter.5
                        @Override // ir.eitaa.ui.Components.FontSettingView.OnFontSelect
                        public void onFontSelect(int font) {
                            ThemeActivity.this.setFontFamily(font);
                        }
                    });
                    break;
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            String string2;
            String string3;
            switch (holder.getItemViewType()) {
                case 1:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    if (position != ThemeActivity.this.nightThemeRow) {
                        if (position != ThemeActivity.this.scheduleFromRow) {
                            if (position != ThemeActivity.this.scheduleToRow) {
                                if (position != ThemeActivity.this.scheduleUpdateLocationRow) {
                                    if (position != ThemeActivity.this.contactsSortRow) {
                                        if (position != ThemeActivity.this.contactsReimportRow) {
                                            if (position != ThemeActivity.this.stickersRow) {
                                                if (position == ThemeActivity.this.distanceRow) {
                                                    int i = SharedConfig.distanceSystemType;
                                                    if (i == 0) {
                                                        string = LocaleController.getString("DistanceUnitsAutomatic", R.string.DistanceUnitsAutomatic);
                                                    } else if (i == 1) {
                                                        string = LocaleController.getString("DistanceUnitsKilometers", R.string.DistanceUnitsKilometers);
                                                    } else {
                                                        string = LocaleController.getString("DistanceUnitsMiles", R.string.DistanceUnitsMiles);
                                                    }
                                                    textSettingsCell.setTextAndValue(LocaleController.getString("DistanceUnits", R.string.DistanceUnits), string, false);
                                                    break;
                                                }
                                            } else {
                                                textSettingsCell.setText(LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), false);
                                                break;
                                            }
                                        } else {
                                            textSettingsCell.setText(LocaleController.getString("ImportContacts", R.string.ImportContacts), true);
                                            break;
                                        }
                                    } else {
                                        int i2 = MessagesController.getGlobalMainSettings().getInt("sortContactsBy", 0);
                                        if (i2 == 0) {
                                            string2 = LocaleController.getString("Default", R.string.Default);
                                        } else if (i2 == 1) {
                                            string2 = LocaleController.getString("FirstName", R.string.SortFirstName);
                                        } else {
                                            string2 = LocaleController.getString("LastName", R.string.SortLastName);
                                        }
                                        textSettingsCell.setTextAndValue(LocaleController.getString("SortBy", R.string.SortBy), string2, true);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightUpdateLocation", R.string.AutoNightUpdateLocation), Theme.autoNightCityName, false);
                                    break;
                                }
                            } else {
                                int i3 = Theme.autoNightDayEndTime;
                                int i4 = i3 / 60;
                                textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTo", R.string.AutoNightTo), String.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3 - (i4 * 60))), false);
                                break;
                            }
                        } else {
                            int i5 = Theme.autoNightDayStartTime;
                            int i6 = i5 / 60;
                            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightFrom", R.string.AutoNightFrom), String.format("%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5 - (i6 * 60))), true);
                            break;
                        }
                    } else if (Theme.selectedAutoNightType == 0 || Theme.getCurrentNightTheme() == null) {
                        textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), LocaleController.getString("AutoNightThemeOff", R.string.AutoNightThemeOff), false);
                        break;
                    } else {
                        textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), Theme.getCurrentNightThemeName(), false);
                        break;
                    }
                    break;
                case 2:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position != ThemeActivity.this.automaticBrightnessInfoRow) {
                        if (position == ThemeActivity.this.scheduleLocationInfoRow) {
                            textInfoPrivacyCell.setText(ThemeActivity.this.getLocationSunString());
                            break;
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.formatString("AutoNightBrightnessInfo", R.string.AutoNightBrightnessInfo, Integer.valueOf((int) (Theme.autoNightBrighnessThreshold * 100.0f))));
                        break;
                    }
                    break;
                case 3:
                    if (position == ThemeActivity.this.stickersSection2Row || ((position == ThemeActivity.this.nightTypeInfoRow && ThemeActivity.this.themeInfoRow == -1) || (position == ThemeActivity.this.themeInfoRow && ThemeActivity.this.nightTypeInfoRow != -1))) {
                        holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        break;
                    } else {
                        holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        break;
                    }
                case 4:
                    ThemeTypeCell themeTypeCell = (ThemeTypeCell) holder.itemView;
                    if (position != ThemeActivity.this.nightDisabledRow) {
                        if (position != ThemeActivity.this.nightScheduledRow) {
                            if (position == ThemeActivity.this.nightAutomaticRow) {
                                themeTypeCell.setValue(LocaleController.getString("AutoNightAdaptive", R.string.AutoNightAdaptive), Theme.selectedAutoNightType == 2, ThemeActivity.this.nightSystemDefaultRow != -1);
                                break;
                            } else if (position == ThemeActivity.this.nightSystemDefaultRow) {
                                themeTypeCell.setValue(LocaleController.getString("AutoNightSystemDefault", R.string.AutoNightSystemDefault), Theme.selectedAutoNightType == 3, false);
                                break;
                            }
                        } else {
                            themeTypeCell.setValue(LocaleController.getString("AutoNightScheduled", R.string.AutoNightScheduled), Theme.selectedAutoNightType == 1, true);
                            break;
                        }
                    } else {
                        themeTypeCell.setValue(LocaleController.getString("AutoNightDisabled", R.string.AutoNightDisabled), Theme.selectedAutoNightType == 0, true);
                        break;
                    }
                    break;
                case 5:
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position != ThemeActivity.this.scheduleHeaderRow) {
                        if (position != ThemeActivity.this.automaticHeaderRow) {
                            if (position != ThemeActivity.this.preferedHeaderRow) {
                                if (position != ThemeActivity.this.settingsRow) {
                                    if (position != ThemeActivity.this.themeHeaderRow) {
                                        if (position != ThemeActivity.this.textSizeHeaderRow) {
                                            if (position != ThemeActivity.this.fontHeaderRow) {
                                                if (position != ThemeActivity.this.chatListHeaderRow) {
                                                    if (position != ThemeActivity.this.bubbleRadiusHeaderRow) {
                                                        if (position == ThemeActivity.this.swipeGestureHeaderRow) {
                                                            headerCell.setText(LocaleController.getString("ChatListSwipeGesture", R.string.ChatListSwipeGesture));
                                                            break;
                                                        }
                                                    } else {
                                                        headerCell.setText(LocaleController.getString("BubbleRadius", R.string.BubbleRadius));
                                                        break;
                                                    }
                                                } else {
                                                    headerCell.setText(LocaleController.getString("ChatList", R.string.ChatList));
                                                    break;
                                                }
                                            } else {
                                                headerCell.setText(LocaleController.getString("Font", R.string.Font));
                                                break;
                                            }
                                        } else {
                                            headerCell.setText(LocaleController.getString("TextSizeHeader", R.string.TextSizeHeader));
                                            break;
                                        }
                                    } else {
                                        headerCell.setText(LocaleController.getString("ColorTheme", R.string.ColorTheme));
                                        break;
                                    }
                                } else {
                                    headerCell.setText(LocaleController.getString("SETTINGS", R.string.SETTINGS));
                                    break;
                                }
                            } else {
                                headerCell.setText(LocaleController.getString("AutoNightPreferred", R.string.AutoNightPreferred));
                                break;
                            }
                        } else {
                            headerCell.setText(LocaleController.getString("AutoNightBrightness", R.string.AutoNightBrightness));
                            break;
                        }
                    } else {
                        headerCell.setText(LocaleController.getString("AutoNightSchedule", R.string.AutoNightSchedule));
                        break;
                    }
                    break;
                case 6:
                    ((BrightnessControlCell) holder.itemView).setProgress(Theme.autoNightBrighnessThreshold);
                    break;
                case 7:
                    TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                    if (position != ThemeActivity.this.scheduleLocationRow) {
                        if (position != ThemeActivity.this.enableAnimationsRow) {
                            if (position != ThemeActivity.this.sendByEnterRow) {
                                if (position != ThemeActivity.this.saveToGalleryRow) {
                                    if (position != ThemeActivity.this.raiseToSpeakRow) {
                                        if (position != ThemeActivity.this.proximitySensorRow) {
                                            if (position != ThemeActivity.this.customTabsRow) {
                                                if (position != ThemeActivity.this.directShareRow) {
                                                    if (position == ThemeActivity.this.emojiRow) {
                                                        textCheckCell.setTextAndCheck(LocaleController.getString("LargeEmoji", R.string.LargeEmoji), SharedConfig.allowBigEmoji, true);
                                                        break;
                                                    }
                                                } else {
                                                    textCheckCell.setTextAndValueAndCheck(LocaleController.getString("DirectShare", R.string.DirectShare), LocaleController.getString("DirectShareInfo", R.string.DirectShareInfo), SharedConfig.directShare, false, true);
                                                    break;
                                                }
                                            } else {
                                                textCheckCell.setTextAndValueAndCheck(LocaleController.getString("ChromeCustomTabs", R.string.ChromeCustomTabs), LocaleController.getString("ChromeCustomTabsInfo", R.string.ChromeCustomTabsInfo), SharedConfig.customTabs, false, true);
                                                break;
                                            }
                                        } else {
                                            textCheckCell.setTextAndValueAndCheck(LocaleController.getString("ProximitySensor", R.string.ProximitySensor), LocaleController.getString("ProximitySensorInfo", R.string.ProximitySensorInfo), SharedConfig.proximitysensor, false, true);
                                            break;
                                        }
                                    } else {
                                        textCheckCell.setTextAndCheck(LocaleController.getString("RaiseToSpeak", R.string.RaiseToSpeak), SharedConfig.raiseToSpeak, true);
                                        break;
                                    }
                                } else {
                                    textCheckCell.setTextAndCheck(LocaleController.getString("SaveToGallerySettings", R.string.SaveToGallerySettings), SharedConfig.saveToGallery, true);
                                    break;
                                }
                            } else {
                                textCheckCell.setTextAndCheck(LocaleController.getString("SendByEnter", R.string.SendByEnter), MessagesController.getGlobalMainSettings().getBoolean("send_by_enter", false), true);
                                break;
                            }
                        } else {
                            textCheckCell.setTextAndCheck(LocaleController.getString("EnableAnimations", R.string.EnableAnimations), MessagesController.getGlobalMainSettings().getBoolean("view_animations", true), true);
                            break;
                        }
                    } else {
                        textCheckCell.setTextAndCheck(LocaleController.getString("AutoNightLocation", R.string.AutoNightLocation), Theme.autoNightScheduleByLocation, true);
                        break;
                    }
                    break;
                case 10:
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) holder.itemView;
                    if (position == ThemeActivity.this.nightThemeRow) {
                        boolean z = Theme.selectedAutoNightType != 0;
                        String currentNightThemeName = z ? Theme.getCurrentNightThemeName() : LocaleController.getString("AutoNightThemeOff", R.string.AutoNightThemeOff);
                        if (z) {
                            int i7 = Theme.selectedAutoNightType;
                            if (i7 == 1) {
                                string3 = LocaleController.getString("AutoNightScheduled", R.string.AutoNightScheduled);
                            } else if (i7 == 3) {
                                string3 = LocaleController.getString("AutoNightSystemDefault", R.string.AutoNightSystemDefault);
                            } else {
                                string3 = LocaleController.getString("AutoNightAdaptive", R.string.AutoNightAdaptive);
                            }
                            currentNightThemeName = string3 + " " + currentNightThemeName;
                        }
                        notificationsCheckCell.setTextAndValueAndCheck(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), currentNightThemeName, z, true);
                        break;
                    }
                    break;
                case 11:
                    if (this.first) {
                        ThemeActivity.this.themesHorizontalListCell.scrollToCurrentTheme(ThemeActivity.this.listView.getMeasuredWidth(), false);
                        this.first = false;
                        break;
                    }
                    break;
                case 12:
                    RecyclerListView recyclerListView = (RecyclerListView) holder.itemView;
                    ThemeAccentsListAdapter themeAccentsListAdapter = (ThemeAccentsListAdapter) recyclerListView.getAdapter();
                    themeAccentsListAdapter.notifyDataSetChanged();
                    int iFindCurrentAccent = themeAccentsListAdapter.findCurrentAccent();
                    if (iFindCurrentAccent == -1) {
                        iFindCurrentAccent = themeAccentsListAdapter.getItemCount() - 1;
                    }
                    if (iFindCurrentAccent != -1) {
                        ((LinearLayoutManager) recyclerListView.getLayoutManager()).scrollToPositionWithOffset(iFindCurrentAccent, (ThemeActivity.this.listView.getMeasuredWidth() / 2) - AndroidUtilities.dp(42.0f));
                        break;
                    }
                    break;
                case 14:
                    TextCell textCell = (TextCell) holder.itemView;
                    if (position == ThemeActivity.this.backgroundRow) {
                        textCell.setTextAndIcon(LocaleController.getString("ChangeChatBackground", R.string.ChangeChatBackground), R.drawable.msg_background, false);
                        textCell.setColors("windowBackgroundWhiteBlueText4", "windowBackgroundWhiteBlueText4");
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 4) {
                ((ThemeTypeCell) holder.itemView).setTypeChecked(holder.getAdapterPosition() == Theme.selectedAutoNightType);
            }
            if (itemViewType == 2 || itemViewType == 3) {
                return;
            }
            holder.itemView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ThemeActivity.this.scheduleFromRow || position == ThemeActivity.this.distanceRow || position == ThemeActivity.this.scheduleToRow || position == ThemeActivity.this.scheduleUpdateLocationRow || position == ThemeActivity.this.contactsReimportRow || position == ThemeActivity.this.contactsSortRow || position == ThemeActivity.this.stickersRow) {
                return 1;
            }
            if (position == ThemeActivity.this.automaticBrightnessInfoRow || position == ThemeActivity.this.scheduleLocationInfoRow) {
                return 2;
            }
            if (position == ThemeActivity.this.themeInfoRow || position == ThemeActivity.this.nightTypeInfoRow || position == ThemeActivity.this.scheduleFromToInfoRow || position == ThemeActivity.this.stickersSection2Row || position == ThemeActivity.this.settings2Row || position == ThemeActivity.this.newThemeInfoRow || position == ThemeActivity.this.chatListInfoRow || position == ThemeActivity.this.bubbleRadiusInfoRow || position == ThemeActivity.this.swipeGestureInfoRow) {
                return 3;
            }
            if (position == ThemeActivity.this.nightDisabledRow || position == ThemeActivity.this.nightScheduledRow || position == ThemeActivity.this.nightAutomaticRow || position == ThemeActivity.this.nightSystemDefaultRow) {
                return 4;
            }
            if (position == ThemeActivity.this.scheduleHeaderRow || position == ThemeActivity.this.automaticHeaderRow || position == ThemeActivity.this.preferedHeaderRow || position == ThemeActivity.this.settingsRow || position == ThemeActivity.this.themeHeaderRow || position == ThemeActivity.this.textSizeHeaderRow || position == ThemeActivity.this.fontHeaderRow || position == ThemeActivity.this.chatListHeaderRow || position == ThemeActivity.this.bubbleRadiusHeaderRow || position == ThemeActivity.this.swipeGestureHeaderRow) {
                return 5;
            }
            if (position == ThemeActivity.this.automaticBrightnessRow) {
                return 6;
            }
            if (position == ThemeActivity.this.scheduleLocationRow || position == ThemeActivity.this.enableAnimationsRow || position == ThemeActivity.this.sendByEnterRow || position == ThemeActivity.this.saveToGalleryRow || position == ThemeActivity.this.raiseToSpeakRow || position == ThemeActivity.this.proximitySensorRow || position == ThemeActivity.this.customTabsRow || position == ThemeActivity.this.directShareRow || position == ThemeActivity.this.emojiRow) {
                return 7;
            }
            if (position == ThemeActivity.this.textSizeRow) {
                return 8;
            }
            if (position == ThemeActivity.this.chatListRow) {
                return 9;
            }
            if (position == ThemeActivity.this.nightThemeRow) {
                return 10;
            }
            if (position == ThemeActivity.this.themeListRow) {
                return 11;
            }
            if (position == ThemeActivity.this.themeAccentListRow) {
                return 12;
            }
            if (position == ThemeActivity.this.bubbleRadiusRow) {
                return 13;
            }
            if (position == ThemeActivity.this.backgroundRow) {
                return 14;
            }
            if (position == ThemeActivity.this.swipeGestureRow) {
                return 15;
            }
            return position == ThemeActivity.this.fontRow ? 16 : 1;
        }
    }

    private static abstract class TintRecyclerListView extends RecyclerListView {
        TintRecyclerListView(Context context) {
            super(context);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, BrightnessControlCell.class, ThemeTypeCell.class, TextSizeCell.class, BubbleRadiusCell.class, ChatListCell.class, NotificationsCheckCell.class, ThemesHorizontalListCell.class, TintRecyclerListView.class, TextCell.class, SwipeGestureSettingsView.class, FontSettingView.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{BrightnessControlCell.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{BrightnessControlCell.class}, new String[]{"rightImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BrightnessControlCell.class}, new String[]{"seekBarView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{BrightnessControlCell.class}, new String[]{"seekBarView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progress"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ThemeTypeCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ThemeTypeCell.class}, new String[]{"checkImage"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addedIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{TextSizeCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progress"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{BubbleRadiusCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progress"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleRadiusCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ChatListCell.class}, null, null, null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ChatListCell.class}, null, null, null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, "chat_inBubble"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInSelectedDrawable, Theme.chat_msgInMediaSelectedDrawable}, null, "chat_inBubbleSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, Theme.chat_msgInDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, Theme.chat_msgInMediaDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubble"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutSelectedDrawable, Theme.chat_msgOutMediaSelectedDrawable}, null, "chat_outBubbleSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_messageTextIn"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_messageTextOut"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckDrawable}, null, "chat_outSentCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckSelectedDrawable}, null, "chat_outSentCheckSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadDrawable, Theme.chat_msgOutHalfCheckDrawable}, null, "chat_outSentCheckRead"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadSelectedDrawable, Theme.chat_msgOutHalfCheckSelectedDrawable}, null, "chat_outSentCheckReadSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgMediaCheckDrawable, Theme.chat_msgMediaHalfCheckDrawable}, null, "chat_mediaSentCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inReplyLine"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outReplyLine"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inReplyNameText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outReplyNameText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inReplyMessageText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outReplyMessageText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inTimeText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outTimeText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_inTimeSelectedText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, "chat_outTimeSelectedText"));
        return arrayList;
    }
}
