package org.rbmain.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.time.SunDate;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.BrightnessControlCell;
import org.rbmain.ui.Cells.ChatListCell;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.NotificationsCheckCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Cells.ThemePreviewMessagesCell;
import org.rbmain.ui.Cells.ThemeTypeCell;
import org.rbmain.ui.Cells.ThemesHorizontalListCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SeekBarView;
import org.rbmain.ui.Components.ShareAlert;

/* loaded from: classes4.dex */
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
    private ArrayList<Theme.ThemeInfo> darkThemes = new ArrayList<>();
    private ArrayList<Theme.ThemeInfo> defaultThemes = new ArrayList<>();
    private int directShareRow;
    private int distanceRow;
    private int emojiRow;
    private int enableAnimationsRow;
    private GpsLocationListener gpsLocationListener;
    boolean hasThemeAccents;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int liteModeRow;
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
    private int stickersRow;
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

    private class GpsLocationListener implements LocationListener {
        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        private GpsLocationListener() {
        }

        /* synthetic */ GpsLocationListener(ThemeActivity themeActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) throws IOException {
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
            this.sizeBar.setDelegate(new SeekBarView.SeekBarViewDelegate(ThemeActivity.this) { // from class: org.rbmain.ui.ThemeActivity.TextSizeCell.1
                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarPressed(boolean z) {
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(boolean z, float f) {
                    ThemeActivity.this.setFontSize(Math.round(r4.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * f)));
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public CharSequence getContentDescription() {
                    return String.valueOf(Math.round(TextSizeCell.this.startFontSize + ((TextSizeCell.this.endFontSize - TextSizeCell.this.startFontSize) * TextSizeCell.this.sizeBar.getProgress())));
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
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
            this.textPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteValueText));
            canvas.drawText(BuildConfig.FLAVOR + SharedConfig.fontSize, getMeasuredWidth() - AndroidUtilities.dp(39.0f), AndroidUtilities.dp(28.0f), this.textPaint);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            if (this.lastWidth != size) {
                SeekBarView seekBarView = this.sizeBar;
                int i3 = SharedConfig.fontSize;
                int i4 = this.startFontSize;
                seekBarView.setProgress((i3 - i4) / (this.endFontSize - i4));
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
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.sizeBar.getSeekBarAccessibilityDelegate().onInitializeAccessibilityNodeInfoInternal(this, accessibilityNodeInfo);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return super.performAccessibilityAction(i, bundle) || this.sizeBar.getSeekBarAccessibilityDelegate().performAccessibilityActionInternal(this, i, bundle);
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
            this.sizeBar.setDelegate(new SeekBarView.SeekBarViewDelegate(ThemeActivity.this) { // from class: org.rbmain.ui.ThemeActivity.BubbleRadiusCell.1
                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarPressed(boolean z) {
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(boolean z, float f) {
                    ThemeActivity.this.setBubbleRadius(Math.round(r4.startRadius + ((BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius) * f)), false);
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public CharSequence getContentDescription() {
                    return String.valueOf(Math.round(BubbleRadiusCell.this.startRadius + ((BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius) * BubbleRadiusCell.this.sizeBar.getProgress())));
                }

                @Override // org.rbmain.ui.Components.SeekBarView.SeekBarViewDelegate
                public int getStepsCount() {
                    return BubbleRadiusCell.this.endRadius - BubbleRadiusCell.this.startRadius;
                }
            });
            this.sizeBar.setImportantForAccessibility(2);
            addView(this.sizeBar, LayoutHelper.createFrame(-1, 38.0f, 51, 5.0f, 5.0f, 39.0f, 0.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.textPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteValueText));
            canvas.drawText(BuildConfig.FLAVOR + SharedConfig.bubbleRadius, getMeasuredWidth() - AndroidUtilities.dp(39.0f), AndroidUtilities.dp(28.0f), this.textPaint);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), i2);
            SeekBarView seekBarView = this.sizeBar;
            int i3 = SharedConfig.bubbleRadius;
            int i4 = this.startRadius;
            seekBarView.setProgress((i3 - i4) / (this.endRadius - i4));
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.sizeBar.invalidate();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            this.sizeBar.getSeekBarAccessibilityDelegate().onInitializeAccessibilityNodeInfoInternal(this, accessibilityNodeInfo);
        }

        @Override // android.view.View
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return super.performAccessibilityAction(i, bundle) || this.sizeBar.getSeekBarAccessibilityDelegate().performAccessibilityActionInternal(this, i, bundle);
        }
    }

    public ThemeActivity(int i) {
        AnonymousClass1 anonymousClass1 = null;
        this.gpsLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.networkLocationListener = new GpsLocationListener(this, anonymousClass1);
        this.fragmentName = "ThemeActivity";
        this.currentType = i;
        updateRows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setBubbleRadius(int i, boolean z) {
        if (i == SharedConfig.bubbleRadius) {
            return false;
        }
        SharedConfig.bubbleRadius = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("bubbleRadius", SharedConfig.bubbleRadius);
        editorEdit.apply();
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.textSizeRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
            if (view instanceof TextSizeCell) {
                TextSizeCell textSizeCell = (TextSizeCell) view;
                ChatMessageCell[] cells = textSizeCell.messagesCell.getCells();
                for (int i2 = 0; i2 < cells.length; i2++) {
                    cells[i2].getMessageObject().resetLayout();
                    cells[i2].requestLayout();
                }
                textSizeCell.invalidate();
            }
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.listView.findViewHolderForAdapterPosition(this.bubbleRadiusRow);
        if (viewHolderFindViewHolderForAdapterPosition2 != null) {
            View view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
            if (view2 instanceof BubbleRadiusCell) {
                BubbleRadiusCell bubbleRadiusCell = (BubbleRadiusCell) view2;
                if (z) {
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
    public boolean setFontSize(int i) {
        if (i == SharedConfig.fontSize) {
            return false;
        }
        SharedConfig.fontSize = i;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("fons_size", SharedConfig.fontSize);
        editorEdit.apply();
        Theme.chat_msgTextPaint.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize));
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.textSizeRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
            if (view instanceof TextSizeCell) {
                ChatMessageCell[] cells = ((TextSizeCell) view).messagesCell.getCells();
                for (int i2 = 0; i2 < cells.length; i2++) {
                    cells[i2].getMessageObject().resetLayout();
                    cells[i2].requestLayout();
                }
            }
        }
        updateMenuItem();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean z) {
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
        this.themeHeaderRow = -1;
        this.bubbleRadiusHeaderRow = -1;
        this.bubbleRadiusRow = -1;
        this.bubbleRadiusInfoRow = -1;
        this.chatListHeaderRow = -1;
        this.chatListRow = -1;
        this.chatListInfoRow = -1;
        this.liteModeRow = -1;
        this.textSizeRow = -1;
        this.backgroundRow = -1;
        this.settingsRow = -1;
        this.customTabsRow = -1;
        this.directShareRow = -1;
        this.enableAnimationsRow = -1;
        this.raiseToSpeakRow = -1;
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
        Collections.sort(this.defaultThemes, new Comparator() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ThemeActivity.lambda$updateRows$0((Theme.ThemeInfo) obj, (Theme.ThemeInfo) obj2);
            }
        });
        if (this.currentType == 0) {
            int i7 = this.rowCount;
            int i8 = i7 + 1;
            this.rowCount = i8;
            this.textSizeHeaderRow = i7;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.textSizeRow = i8;
            int i10 = i9 + 1;
            this.rowCount = i10;
            this.backgroundRow = i9;
            int i11 = i10 + 1;
            this.rowCount = i11;
            this.newThemeInfoRow = i10;
            int i12 = i11 + 1;
            this.rowCount = i12;
            this.themeHeaderRow = i11;
            this.rowCount = i12 + 1;
            this.themeListRow = i12;
            boolean zHasAccentColors = Theme.getCurrentTheme().hasAccentColors();
            this.hasThemeAccents = zHasAccentColors;
            ThemesHorizontalListCell themesHorizontalListCell = this.themesHorizontalListCell;
            if (themesHorizontalListCell != null) {
                themesHorizontalListCell.setDrawDivider(zHasAccentColors);
            }
            if (this.hasThemeAccents) {
                int i13 = this.rowCount;
                this.rowCount = i13 + 1;
                this.themeAccentListRow = i13;
            }
            int i14 = this.rowCount;
            int i15 = i14 + 1;
            this.rowCount = i15;
            this.themeInfoRow = i14;
            int i16 = i15 + 1;
            this.rowCount = i16;
            this.bubbleRadiusHeaderRow = i15;
            int i17 = i16 + 1;
            this.rowCount = i17;
            this.bubbleRadiusRow = i16;
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.bubbleRadiusInfoRow = i17;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.chatListHeaderRow = i18;
            int i20 = i19 + 1;
            this.rowCount = i20;
            this.chatListRow = i19;
            int i21 = i20 + 1;
            this.rowCount = i21;
            this.chatListInfoRow = i20;
            int i22 = i21 + 1;
            this.rowCount = i22;
            this.swipeGestureHeaderRow = i21;
            int i23 = i22 + 1;
            this.rowCount = i23;
            this.swipeGestureRow = i22;
            int i24 = i23 + 1;
            this.rowCount = i24;
            this.swipeGestureInfoRow = i23;
            int i25 = i24 + 1;
            this.rowCount = i25;
            this.settingsRow = i24;
            int i26 = i25 + 1;
            this.rowCount = i26;
            this.nightThemeRow = i25;
            int i27 = i26 + 1;
            this.rowCount = i27;
            this.customTabsRow = i26;
            int i28 = i27 + 1;
            this.rowCount = i28;
            this.directShareRow = i27;
            int i29 = i28 + 1;
            this.rowCount = i29;
            this.enableAnimationsRow = i28;
            int i30 = i29 + 1;
            this.rowCount = i30;
            this.emojiRow = i29;
            int i31 = i30 + 1;
            this.rowCount = i31;
            this.raiseToSpeakRow = i30;
            int i32 = i31 + 1;
            this.rowCount = i32;
            this.sendByEnterRow = i31;
            int i33 = i32 + 1;
            this.rowCount = i33;
            this.saveToGalleryRow = i32;
            int i34 = i33 + 1;
            this.rowCount = i34;
            this.distanceRow = i33;
            int i35 = i34 + 1;
            this.rowCount = i35;
            this.liteModeRow = i34;
            int i36 = i35 + 1;
            this.rowCount = i36;
            this.settings2Row = i35;
            int i37 = i36 + 1;
            this.rowCount = i37;
            this.stickersRow = i36;
            this.rowCount = i37 + 1;
            this.stickersSection2Row = i37;
        } else {
            int i38 = this.rowCount;
            int i39 = i38 + 1;
            this.rowCount = i39;
            this.nightDisabledRow = i38;
            int i40 = i39 + 1;
            this.rowCount = i40;
            this.nightScheduledRow = i39;
            int i41 = i40 + 1;
            this.rowCount = i41;
            this.nightAutomaticRow = i40;
            if (Build.VERSION.SDK_INT >= 29) {
                this.rowCount = i41 + 1;
                this.nightSystemDefaultRow = i41;
            }
            int i42 = this.rowCount;
            int i43 = i42 + 1;
            this.rowCount = i43;
            this.nightTypeInfoRow = i42;
            int i44 = Theme.selectedAutoNightType;
            if (i44 == 1) {
                int i45 = i43 + 1;
                this.rowCount = i45;
                this.scheduleHeaderRow = i43;
                int i46 = i45 + 1;
                this.rowCount = i46;
                this.scheduleLocationRow = i45;
                if (Theme.autoNightScheduleByLocation) {
                    int i47 = i46 + 1;
                    this.rowCount = i47;
                    this.scheduleUpdateLocationRow = i46;
                    this.rowCount = i47 + 1;
                    this.scheduleLocationInfoRow = i47;
                } else {
                    int i48 = i46 + 1;
                    this.rowCount = i48;
                    this.scheduleFromRow = i46;
                    int i49 = i48 + 1;
                    this.rowCount = i49;
                    this.scheduleToRow = i48;
                    this.rowCount = i49 + 1;
                    this.scheduleFromToInfoRow = i49;
                }
            } else if (i44 == 2) {
                int i50 = i43 + 1;
                this.rowCount = i50;
                this.automaticHeaderRow = i43;
                int i51 = i50 + 1;
                this.rowCount = i51;
                this.automaticBrightnessRow = i50;
                this.rowCount = i51 + 1;
                this.automaticBrightnessInfoRow = i51;
            }
            if (Theme.selectedAutoNightType != 0) {
                int i52 = this.rowCount;
                int i53 = i52 + 1;
                this.rowCount = i53;
                this.preferedHeaderRow = i52;
                this.rowCount = i53 + 1;
                this.themeListRow = i53;
                boolean zHasAccentColors2 = Theme.getCurrentNightTheme().hasAccentColors();
                this.hasThemeAccents = zHasAccentColors2;
                ThemesHorizontalListCell themesHorizontalListCell2 = this.themesHorizontalListCell;
                if (themesHorizontalListCell2 != null) {
                    themesHorizontalListCell2.setDrawDivider(zHasAccentColors2);
                }
                if (this.hasThemeAccents) {
                    int i54 = this.rowCount;
                    this.rowCount = i54 + 1;
                    this.themeAccentListRow = i54;
                }
                int i55 = this.rowCount;
                this.rowCount = i55 + 1;
                this.themeInfoRow = i55;
            }
        }
        ThemesHorizontalListCell themesHorizontalListCell3 = this.themesHorizontalListCell;
        if (themesHorizontalListCell3 != null) {
            themesHorizontalListCell3.notifyDataSetChanged(this.listView.getWidth());
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            if (this.currentType != 1 || (i2 = this.previousUpdatedType) == (i3 = Theme.selectedAutoNightType) || i2 == -1) {
                if (z || this.previousUpdatedType == -1) {
                    listAdapter.notifyDataSetChanged();
                } else if (i5 == -1 && (i = this.themeAccentListRow) != -1) {
                    listAdapter.notifyItemInserted(i);
                } else if (i5 != -1 && this.themeAccentListRow == -1) {
                    listAdapter.notifyItemRemoved(i5);
                } else {
                    int i56 = this.themeAccentListRow;
                    if (i56 != -1) {
                        listAdapter.notifyItemChanged(i56);
                    }
                }
            } else {
                int i57 = this.nightTypeInfoRow + 1;
                if (i2 != i3) {
                    int i58 = 0;
                    while (true) {
                        if (i58 >= 4) {
                            break;
                        }
                        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(i58);
                        if (holder != null) {
                            View view = holder.itemView;
                            if (view instanceof ThemeTypeCell) {
                                ((ThemeTypeCell) view).setTypeChecked(i58 == Theme.selectedAutoNightType);
                            }
                        }
                        i58++;
                    }
                    int i59 = Theme.selectedAutoNightType;
                    if (i59 == 0) {
                        this.listAdapter.notifyItemRangeRemoved(i57, i4 - i57);
                    } else if (i59 == 1) {
                        int i60 = this.previousUpdatedType;
                        if (i60 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i57, this.rowCount - i57);
                        } else if (i60 == 2) {
                            this.listAdapter.notifyItemRangeRemoved(i57, 3);
                            this.listAdapter.notifyItemRangeInserted(i57, Theme.autoNightScheduleByLocation ? 4 : 5);
                        } else if (i60 == 3) {
                            this.listAdapter.notifyItemRangeInserted(i57, Theme.autoNightScheduleByLocation ? 4 : 5);
                        }
                    } else if (i59 == 2) {
                        int i61 = this.previousUpdatedType;
                        if (i61 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i57, this.rowCount - i57);
                        } else if (i61 == 1) {
                            this.listAdapter.notifyItemRangeRemoved(i57, Theme.autoNightScheduleByLocation ? 4 : 5);
                            this.listAdapter.notifyItemRangeInserted(i57, 3);
                        } else if (i61 == 3) {
                            this.listAdapter.notifyItemRangeInserted(i57, 3);
                        }
                    } else if (i59 == 3) {
                        int i62 = this.previousUpdatedType;
                        if (i62 == 0) {
                            this.listAdapter.notifyItemRangeInserted(i57, this.rowCount - i57);
                        } else if (i62 == 2) {
                            this.listAdapter.notifyItemRangeRemoved(i57, 3);
                        } else if (i62 == 1) {
                            this.listAdapter.notifyItemRangeRemoved(i57, Theme.autoNightScheduleByLocation ? 4 : 5);
                        }
                    }
                } else {
                    boolean z2 = this.previousByLocation;
                    boolean z3 = Theme.autoNightScheduleByLocation;
                    if (z2 != z3) {
                        int i63 = i57 + 2;
                        listAdapter.notifyItemRangeRemoved(i63, z3 ? 3 : 2);
                        this.listAdapter.notifyItemRangeInserted(i63, Theme.autoNightScheduleByLocation ? 2 : 3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$updateRows$0(Theme.ThemeInfo themeInfo, Theme.ThemeInfo themeInfo2) {
        return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(themeInfo.sortIndex, themeInfo2.sortIndex);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.themeListUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.themeAccentListUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        stopLocationUpdate();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.locationPermissionGranted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.themeListUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.themeAccentListUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needShareTheme);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needSetDayNightTheme);
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadedToServer);
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadError);
        Theme.saveAutoNightThemeConfig();
        getContactProxy().saveAppearanceSettings();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) throws IOException {
        AlertDialog alertDialog;
        int i3;
        if (i == NotificationCenter.locationPermissionGranted) {
            updateSunTime(null, true);
            return;
        }
        if (i == NotificationCenter.didSetNewWallpapper || i == NotificationCenter.emojiDidLoad) {
            RecyclerListView recyclerListView = this.listView;
            if (recyclerListView != null) {
                recyclerListView.invalidateViews();
                return;
            }
            return;
        }
        if (i == NotificationCenter.themeAccentListUpdated) {
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter == null || (i3 = this.themeAccentListRow) == -1) {
                return;
            }
            listAdapter.notifyItemChanged(i3, new Object());
            return;
        }
        if (i == NotificationCenter.themeListUpdated) {
            updateRows(true);
            return;
        }
        if (i == NotificationCenter.themeUploadedToServer) {
            Theme.ThemeInfo themeInfo = (Theme.ThemeInfo) objArr[0];
            Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) objArr[1];
            if (themeInfo == this.sharingTheme && themeAccent == this.sharingAccent) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://");
                sb.append(MessagesController.getInstance(this.currentAccount).linkPrefix);
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
        if (i == NotificationCenter.themeUploadError) {
            Theme.ThemeInfo themeInfo2 = (Theme.ThemeInfo) objArr[0];
            Theme.ThemeAccent themeAccent2 = (Theme.ThemeAccent) objArr[1];
            if (themeInfo2 == this.sharingTheme && themeAccent2 == this.sharingAccent && (alertDialog = this.sharingProgressDialog) == null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        if (i == NotificationCenter.needShareTheme) {
            if (getParentActivity() == null || this.isPaused) {
                return;
            }
            this.sharingTheme = (Theme.ThemeInfo) objArr[0];
            this.sharingAccent = (Theme.ThemeAccent) objArr[1];
            AlertDialog alertDialog3 = new AlertDialog(getParentActivity(), 3);
            this.sharingProgressDialog = alertDialog3;
            alertDialog3.setCanCancel(true);
            showDialog(this.sharingProgressDialog, new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$didReceivedNotification$1(dialogInterface);
                }
            });
            return;
        }
        if (i == NotificationCenter.needSetDayNightTheme) {
            updateMenuItem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$1(DialogInterface dialogInterface) {
        this.sharingProgressDialog = null;
        this.sharingTheme = null;
        this.sharingAccent = null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
            this.menuItem.addSubItem(2, R.drawable.msg_share, LocaleController.getString("ShareTheme", R.string.ShareTheme));
            this.menuItem.addSubItem(3, R.drawable.msg_edit, LocaleController.getString("EditThemeColors", R.string.EditThemeColors));
            this.menuItem.addSubItem(1, R.drawable.menu_palette, LocaleController.getString("CreateNewThemeMenu", R.string.CreateNewThemeMenu));
            this.menuItem.addSubItem(4, R.drawable.msg_reset, LocaleController.getString("ThemeResetToDefaults", R.string.ThemeResetToDefaults));
            this.menuItem.setVisibility(8);
        } else {
            this.actionBar.setTitle(LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme));
        }
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        this.fragmentView = frameLayout;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setAdapter(this.listAdapter);
        ((DefaultItemAnimator) this.listView.getItemAnimator()).setDelayAnimations(false);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f, float f2) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f, f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) throws IOException {
                this.f$0.lambda$createView$5(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.ThemeActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == -1) {
                ThemeActivity.this.finishFragment();
                return;
            }
            if (i == 1) {
                if (ThemeActivity.this.getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("NewTheme", R.string.NewTheme));
                builder.setMessage(LocaleController.getString("CreateNewThemeAlert", R.string.CreateNewThemeAlert));
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setPositiveButton(LocaleController.getString("CreateTheme", R.string.CreateTheme), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onItemClick$0(dialogInterface, i2);
                    }
                });
                ThemeActivity.this.showDialog(builder.create());
                return;
            }
            if (i == 2) {
                Theme.ThemeAccent accent = Theme.getCurrentTheme().getAccent(false);
                if (accent.info == null) {
                    MessagesController.getInstance(((BaseFragment) ThemeActivity.this).currentAccount).saveThemeToServer(accent.parentTheme, accent);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShareTheme, accent.parentTheme, accent);
                    return;
                }
                String str = "https://" + MessagesController.getInstance(((BaseFragment) ThemeActivity.this).currentAccount).linkPrefix + "/addtheme/" + accent.info.slug;
                ThemeActivity.this.showDialog(new ShareAlert(ThemeActivity.this.getParentActivity(), null, str, false, str, false));
                return;
            }
            if (i == 3) {
                Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
                ThemeActivity.this.presentFragment(new ThemePreviewActivity(currentTheme, false, 1, currentTheme.getAccent(false).id >= 100, ThemeActivity.this.currentType == 1));
            } else {
                if (i != 4 || ThemeActivity.this.getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                builder2.setTitle(LocaleController.getString("ThemeResetToDefaultsTitle", R.string.ThemeResetToDefaultsTitle));
                builder2.setMessage(LocaleController.getString("ThemeResetToDefaultsText", R.string.ThemeResetToDefaultsText));
                builder2.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) throws IOException {
                        this.f$0.lambda$onItemClick$1(dialogInterface, i2);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder2.create();
                ThemeActivity.this.showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(DialogInterface dialogInterface, int i) {
            AlertsCreator.createThemeCreateDialog(ThemeActivity.this, 0, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(DialogInterface dialogInterface, int i) throws IOException {
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
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(View view, final int i, float f, float f2) throws IOException {
        int i2;
        int i3;
        String string;
        if (i == this.enableAnimationsRow) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            boolean z = globalMainSettings.getBoolean("view_animations", true);
            SharedPreferences.Editor editorEdit = globalMainSettings.edit();
            editorEdit.putBoolean("view_animations", !z);
            editorEdit.apply();
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
            editorEdit2.apply();
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
            builder.setItems(new CharSequence[]{LocaleController.getString("DistanceUnitsAutomatic", R.string.DistanceUnitsAutomatic), LocaleController.getString("DistanceUnitsKilometers", R.string.DistanceUnitsKilometers), LocaleController.getString("DistanceUnitsMiles", R.string.DistanceUnitsMiles)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$2(dialogInterface, i4);
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
            builder2.setItems(new CharSequence[]{LocaleController.getString("Default", R.string.Default), LocaleController.getString("SortFirstName", R.string.SortFirstName), LocaleController.getString("SortLastName", R.string.SortLastName)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$3(i, dialogInterface, i4);
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
        if (i == this.liteModeRow) {
            presentFragment(new LiteModeSettingsActivity());
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
            showDialog(new TimePickerDialog(getParentActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda0
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i5, int i6) {
                    this.f$0.lambda$createView$4(i, textSettingsCell, timePicker, i5, i6);
                }
            }, i3, i2 - (i3 * 60), true));
            return;
        }
        if (i == this.scheduleUpdateLocationRow) {
            updateSunTime(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DialogInterface dialogInterface, int i) {
        SharedConfig.setDistanceSystemType(i);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.distanceRow);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.listAdapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, this.distanceRow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(int i, DialogInterface dialogInterface, int i2) {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("sortContactsBy", i2);
        editorEdit.apply();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(int i, TextSettingsCell textSettingsCell, TimePicker timePicker, int i2, int i3) {
        int i4 = (i2 * 60) + i3;
        if (i == this.scheduleFromRow) {
            Theme.autoNightDayStartTime = i4;
            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightFrom", R.string.AutoNightFrom), String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)), true);
        } else {
            Theme.autoNightDayEndTime = i4;
            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTo", R.string.AutoNightTo), String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)), true);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.listAdapter != null) {
            updateRows(true);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
            AndroidUtilities.setAdjustResizeToNothing(getParentActivity(), this.classGuid);
        }
    }

    private void updateMenuItem() {
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
        if (SharedConfig.fontSize != i || SharedConfig.bubbleRadius != 10 || !currentTheme2.firstAccentIsDefault || currentTheme2.currentAccentId != Theme.DEFALT_THEME_ACCENT_ID) {
            this.menuItem.showSubItem(4);
        } else {
            this.menuItem.hideSubItem(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSunTime(Location location, boolean z) throws IOException {
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
                    builder.setPositiveButton(LocaleController.getString("ConnectingToProxyEnable", R.string.ConnectingToProxyEnable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$updateSunTime$6(dialogInterface, i);
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
            location = locationManager.getLastKnownLocation("gps");
            if (location == null) {
                location = locationManager.getLastKnownLocation("network");
            }
            if (location == null) {
                location = locationManager.getLastKnownLocation("passive");
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        if (location == null || z) {
            startLocationUpdate();
            if (location == null) {
                return;
            }
        }
        Theme.autoNightLocationLatitude = location.getLatitude();
        Theme.autoNightLocationLongitude = location.getLongitude();
        int[] iArrCalculateSunriseSunset = SunDate.calculateSunriseSunset(Theme.autoNightLocationLatitude, Theme.autoNightLocationLongitude);
        Theme.autoNightSunriseTime = iArrCalculateSunriseSunset[0];
        Theme.autoNightSunsetTime = iArrCalculateSunriseSunset[1];
        Theme.autoNightCityName = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Theme.autoNightLastSunCheckDay = calendar.get(5);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$updateSunTime$8();
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
    public /* synthetic */ void lambda$updateSunTime$6(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        try {
            getParentActivity().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSunTime$8() throws IOException {
        final String locality = null;
        try {
            List<Address> fromLocation = new Geocoder(ApplicationLoader.applicationContext, Locale.getDefault()).getFromLocation(Theme.autoNightLocationLatitude, Theme.autoNightLocationLongitude, 1);
            if (fromLocation.size() > 0) {
                locality = fromLocation.get(0).getLocality();
            }
        } catch (Exception unused) {
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ThemeActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateSunTime$7(locality);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSunTime$7(String str) {
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

        void setThemeAndColor(Theme.ThemeInfo themeInfo, Theme.ThemeAccent themeAccent) {
            this.currentTheme = themeInfo;
            this.currentAccent = themeAccent;
            updateCheckedState(false);
        }

        void updateCheckedState(boolean z) {
            this.checked = this.currentTheme.currentAccentId == this.currentAccent.id;
            ObjectAnimator objectAnimator = this.checkAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (z) {
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
        public void setCheckedState(float f) {
            this.checkedState = f;
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
        protected void onMeasure(int i, int i2) {
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
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            accessibilityNodeInfo.setClassName(Button.class.getName());
            accessibilityNodeInfo.setChecked(this.checked);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setEnabled(true);
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
        protected void onMeasure(int i, int i2) {
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
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            accessibilityNodeInfo.setClassName(Button.class.getName());
            accessibilityNodeInfo.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ThemeAccentsListAdapter extends RecyclerListView.SelectionAdapter {
        private Theme.ThemeInfo currentTheme;
        private Context mContext;
        private ArrayList<Theme.ThemeAccent> themeAccents;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
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
        public int getItemViewType(int i) {
            return i == getItemCount() - 1 ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new RecyclerListView.Holder(new InnerAccentView(this.mContext));
            }
            return new RecyclerListView.Holder(new InnerCustomAccentView(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                ((InnerAccentView) viewHolder.itemView).setThemeAndColor(this.currentTheme, this.themeAccents.get(i));
            } else {
                if (itemViewType != 1) {
                    return;
                }
                ((InnerCustomAccentView) viewHolder.itemView).setTheme(this.currentTheme);
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
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
                        CharSequence[] charSequenceArr2 = new CharSequence[5];
                        charSequenceArr2[0] = LocaleController.getString("ShareFile", R.string.ShareFile);
                        charSequenceArr2[1] = LocaleController.getString("ExportTheme", R.string.ExportTheme);
                        TLRPC$TL_theme tLRPC$TL_theme2 = themeInfo.info;
                        charSequenceArr2[2] = (tLRPC$TL_theme2 == null || (!tLRPC$TL_theme2.isDefault && tLRPC$TL_theme2.creator)) ? LocaleController.getString("Edit", R.string.Edit) : null;
                        TLRPC$TL_theme tLRPC$TL_theme3 = themeInfo.info;
                        charSequenceArr2[3] = (tLRPC$TL_theme3 == null || !tLRPC$TL_theme3.creator) ? null : LocaleController.getString("ThemeSetUrl", R.string.ThemeSetUrl);
                        charSequenceArr2[4] = z2 ? LocaleController.getString("Delete", R.string.Delete) : null;
                        iArr = new int[]{R.drawable.msg_share, R.drawable.msg_shareout, R.drawable.msg_edit, R.drawable.msg_link, R.drawable.msg_delete};
                        z = z2;
                        charSequenceArr = charSequenceArr2;
                    }
                    builder.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$ListAdapter$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) throws Throwable {
                            this.f$0.lambda$showOptionsForTheme$1(themeInfo, dialogInterface, i);
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    ThemeActivity.this.showDialog(alertDialogCreate);
                    if (z) {
                        alertDialogCreate.setItemColor(alertDialogCreate.getItemsCount() - 1, Theme.getColor(Theme.key_text_RedBold), Theme.getColor(Theme.key_text_RedRegular));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x011a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x011b A[Catch: Exception -> 0x0168, TRY_LEAVE, TryCatch #4 {Exception -> 0x0168, blocks: (B:52:0x0114, B:55:0x011b, B:62:0x0152, B:61:0x014b, B:60:0x0143, B:58:0x0130), top: B:88:0x0114, inners: #6 }] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$showOptionsForTheme$1(final org.rbmain.ui.ActionBar.Theme.ThemeInfo r8, android.content.DialogInterface r9, int r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 518
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ThemeActivity.ListAdapter.lambda$showOptionsForTheme$1(org.rbmain.ui.ActionBar.Theme$ThemeInfo, android.content.DialogInterface, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showOptionsForTheme$0(Theme.ThemeInfo themeInfo, DialogInterface dialogInterface, int i) {
            MessagesController.getInstance(themeInfo.account).saveTheme(themeInfo, null, themeInfo == Theme.getCurrentNightTheme(), true);
            if (Theme.deleteTheme(themeInfo)) {
                ((BaseFragment) ThemeActivity.this).parentLayout.rebuildAllFragmentViews(true, true);
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.themeListUpdated, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$2(ThemeAccentsListAdapter themeAccentsListAdapter, RecyclerListView recyclerListView, View view, int i) {
            Theme.ThemeInfo currentNightTheme = ThemeActivity.this.currentType == 1 ? Theme.getCurrentNightTheme() : Theme.getCurrentTheme();
            if (i != themeAccentsListAdapter.getItemCount() - 1) {
                Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) themeAccentsListAdapter.themeAccents.get(i);
                if (!TextUtils.isEmpty(themeAccent.patternSlug) && themeAccent.id != Theme.DEFALT_THEME_ACCENT_ID) {
                    Theme.PatternsLoader.createLoader(false);
                }
                if (currentNightTheme.currentAccentId != themeAccent.id) {
                    NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                    int i2 = NotificationCenter.needSetDayNightTheme;
                    Object[] objArr = new Object[4];
                    objArr[0] = currentNightTheme;
                    objArr[1] = Boolean.valueOf(ThemeActivity.this.currentType == 1);
                    objArr[2] = null;
                    objArr[3] = Integer.valueOf(themeAccent.id);
                    globalInstance.postNotificationName(i2, objArr);
                } else {
                    ThemeActivity.this.presentFragment(new ThemePreviewActivity(currentNightTheme, false, 1, themeAccent.id >= 100, ThemeActivity.this.currentType == 1));
                }
            } else {
                ThemeActivity.this.presentFragment(new ThemePreviewActivity(currentNightTheme, false, 1, false, ThemeActivity.this.currentType == 1));
            }
            int left = view.getLeft();
            int right = view.getRight();
            int iDp = AndroidUtilities.dp(52.0f);
            int i3 = left - iDp;
            if (i3 < 0) {
                recyclerListView.smoothScrollBy(i3, 0);
            } else {
                int i4 = right + iDp;
                if (i4 > recyclerListView.getMeasuredWidth()) {
                    recyclerListView.smoothScrollBy(i4 - recyclerListView.getMeasuredWidth(), 0);
                }
            }
            int childCount = recyclerListView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = recyclerListView.getChildAt(i5);
                if (childAt instanceof InnerAccentView) {
                    ((InnerAccentView) childAt).updateCheckedState(true);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$5(final ThemeAccentsListAdapter themeAccentsListAdapter, View view, int i) {
            if (i >= 0 && i < themeAccentsListAdapter.themeAccents.size()) {
                final Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) themeAccentsListAdapter.themeAccents.get(i);
                if (themeAccent.id >= 100) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
                    CharSequence[] charSequenceArr = new CharSequence[4];
                    charSequenceArr[0] = LocaleController.getString("OpenInEditor", R.string.OpenInEditor);
                    charSequenceArr[1] = LocaleController.getString("ShareTheme", R.string.ShareTheme);
                    TLRPC$TL_theme tLRPC$TL_theme = themeAccent.info;
                    charSequenceArr[2] = (tLRPC$TL_theme == null || !tLRPC$TL_theme.creator) ? null : LocaleController.getString("ThemeSetUrl", R.string.ThemeSetUrl);
                    charSequenceArr[3] = LocaleController.getString("DeleteTheme", R.string.DeleteTheme);
                    builder.setItems(charSequenceArr, new int[]{R.drawable.msg_edit, R.drawable.msg_share, R.drawable.msg_link, R.drawable.msg_delete}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$ListAdapter$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.f$0.lambda$onCreateViewHolder$4(themeAccent, themeAccentsListAdapter, dialogInterface, i2);
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    ThemeActivity.this.showDialog(alertDialogCreate);
                    alertDialogCreate.setItemColor(alertDialogCreate.getItemsCount() - 1, Theme.getColor(Theme.key_text_RedBold), Theme.getColor(Theme.key_text_RedRegular));
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$4(final Theme.ThemeAccent themeAccent, final ThemeAccentsListAdapter themeAccentsListAdapter, DialogInterface dialogInterface, int i) {
            if (ThemeActivity.this.getParentActivity() == null) {
                return;
            }
            if (i == 0) {
                AlertsCreator.createThemeCreateDialog(ThemeActivity.this, i != 1 ? 1 : 2, themeAccent.parentTheme, themeAccent);
                return;
            }
            if (i == 1) {
                if (themeAccent.info == null) {
                    MessagesController.getInstance(((BaseFragment) ThemeActivity.this).currentAccount).saveThemeToServer(themeAccent.parentTheme, themeAccent);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShareTheme, themeAccent.parentTheme, themeAccent);
                    return;
                }
                String str = "https://" + MessagesController.getInstance(((BaseFragment) ThemeActivity.this).currentAccount).linkPrefix + "/addtheme/" + themeAccent.info.slug;
                ThemeActivity.this.showDialog(new ShareAlert(ThemeActivity.this.getParentActivity(), null, str, false, str, false));
                return;
            }
            if (i == 2) {
                ThemeActivity.this.presentFragment(new ThemeSetUrlActivity(themeAccent.parentTheme, themeAccent, false));
                return;
            }
            if (i != 3 || ThemeActivity.this.getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("DeleteThemeTitle", R.string.DeleteThemeTitle));
            builder.setMessage(LocaleController.getString("DeleteThemeAlert", R.string.DeleteThemeAlert));
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ThemeActivity$ListAdapter$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) throws IOException {
                    this.f$0.lambda$onCreateViewHolder$3(themeAccentsListAdapter, themeAccent, dialogInterface2, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            ThemeActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$3(ThemeAccentsListAdapter themeAccentsListAdapter, Theme.ThemeAccent themeAccent, DialogInterface dialogInterface, int i) throws IOException {
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
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            final RecyclerListView recyclerListView;
            int i2 = 0;
            switch (i) {
                case 1:
                    textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 2:
                    textSettingsCell = new TextInfoPrivacyCell(this.mContext);
                    textSettingsCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    break;
                case 3:
                    textSettingsCell = new ShadowSectionCell(this.mContext);
                    break;
                case 4:
                    textSettingsCell = new ThemeTypeCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 5:
                    textSettingsCell = new HeaderCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 6:
                    textSettingsCell = new BrightnessControlCell(this.mContext, i2) { // from class: org.rbmain.ui.ThemeActivity.ListAdapter.1
                        @Override // org.rbmain.ui.Cells.BrightnessControlCell
                        protected void didChangedValue(float f) throws IOException {
                            int i3 = (int) (Theme.autoNightBrighnessThreshold * 100.0f);
                            int i4 = (int) (f * 100.0f);
                            Theme.autoNightBrighnessThreshold = f;
                            if (i3 != i4) {
                                RecyclerListView.Holder holder = (RecyclerListView.Holder) ThemeActivity.this.listView.findViewHolderForAdapterPosition(ThemeActivity.this.automaticBrightnessInfoRow);
                                if (holder != null) {
                                    ((TextInfoPrivacyCell) holder.itemView).setText(LocaleController.formatString("AutoNightBrightnessInfo", R.string.AutoNightBrightnessInfo, Integer.valueOf((int) (Theme.autoNightBrighnessThreshold * 100.0f))));
                                }
                                Theme.checkAutoNightThemeConditions(true);
                            }
                        }
                    };
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 7:
                    textSettingsCell = new TextCheckCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 8:
                    textSettingsCell = ThemeActivity.this.new TextSizeCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 9:
                    textSettingsCell = new ChatListCell(this, this.mContext) { // from class: org.rbmain.ui.ThemeActivity.ListAdapter.2
                        @Override // org.rbmain.ui.Cells.ChatListCell
                        protected void didSelectChatType(boolean z) {
                            SharedConfig.setUseThreeLinesLayout(z);
                        }
                    };
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 10:
                    textSettingsCell = new NotificationsCheckCell(this.mContext, 21, 64, false);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 11:
                    this.first = true;
                    ThemeActivity themeActivity = ThemeActivity.this;
                    Context context = this.mContext;
                    ThemeActivity themeActivity2 = ThemeActivity.this;
                    themeActivity.themesHorizontalListCell = new ThemesHorizontalListCell(context, themeActivity2, themeActivity2.currentType, ThemeActivity.this.defaultThemes, ThemeActivity.this.darkThemes) { // from class: org.rbmain.ui.ThemeActivity.ListAdapter.3
                        @Override // org.rbmain.ui.Cells.ThemesHorizontalListCell
                        protected void showOptionsForTheme(Theme.ThemeInfo themeInfo) {
                            ThemeActivity.this.listAdapter.showOptionsForTheme(themeInfo);
                        }

                        @Override // org.rbmain.ui.Cells.ThemesHorizontalListCell
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
                    recyclerListView = new TintRecyclerListView(this, this.mContext) { // from class: org.rbmain.ui.ThemeActivity.ListAdapter.4
                        @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                            if (getParent() != null && getParent().getParent() != null) {
                                getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                            }
                            return super.onInterceptTouchEvent(motionEvent);
                        }
                    };
                    recyclerListView.setFocusable(false);
                    recyclerListView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    recyclerListView.setItemAnimator(null);
                    recyclerListView.setLayoutAnimation(null);
                    recyclerListView.setPadding(AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(11.0f), 0);
                    recyclerListView.setClipToPadding(false);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
                    linearLayoutManager.setOrientation(0);
                    recyclerListView.setLayoutManager(linearLayoutManager);
                    final ThemeAccentsListAdapter themeAccentsListAdapter = ThemeActivity.this.new ThemeAccentsListAdapter(this.mContext);
                    recyclerListView.setAdapter(themeAccentsListAdapter);
                    recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ThemeActivity$ListAdapter$$ExternalSyntheticLambda4
                        @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                        public final void onItemClick(View view, int i3) {
                            this.f$0.lambda$onCreateViewHolder$2(themeAccentsListAdapter, recyclerListView, view, i3);
                        }
                    });
                    recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ThemeActivity$ListAdapter$$ExternalSyntheticLambda5
                        @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
                        public final boolean onItemClick(View view, int i3) {
                            return this.f$0.lambda$onCreateViewHolder$5(themeAccentsListAdapter, view, i3);
                        }
                    });
                    recyclerListView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(62.0f)));
                    textSettingsCell = recyclerListView;
                    break;
                case 13:
                    textSettingsCell = ThemeActivity.this.new BubbleRadiusCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 14:
                default:
                    textSettingsCell = new TextCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 15:
                    textSettingsCell = new SwipeGestureSettingsView(this.mContext, ((BaseFragment) ThemeActivity.this).currentAccount);
                    break;
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String string2;
            String string3;
            switch (viewHolder.getItemViewType()) {
                case 1:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    if (i != ThemeActivity.this.nightThemeRow) {
                        if (i != ThemeActivity.this.scheduleFromRow) {
                            if (i != ThemeActivity.this.scheduleToRow) {
                                if (i != ThemeActivity.this.scheduleUpdateLocationRow) {
                                    if (i != ThemeActivity.this.contactsSortRow) {
                                        if (i != ThemeActivity.this.contactsReimportRow) {
                                            if (i != ThemeActivity.this.stickersRow) {
                                                if (i != ThemeActivity.this.liteModeRow) {
                                                    if (i == ThemeActivity.this.distanceRow) {
                                                        int i2 = SharedConfig.distanceSystemType;
                                                        if (i2 == 0) {
                                                            string = LocaleController.getString("DistanceUnitsAutomatic", R.string.DistanceUnitsAutomatic);
                                                        } else if (i2 == 1) {
                                                            string = LocaleController.getString("DistanceUnitsKilometers", R.string.DistanceUnitsKilometers);
                                                        } else {
                                                            string = LocaleController.getString("DistanceUnitsMiles", R.string.DistanceUnitsMiles);
                                                        }
                                                        textSettingsCell.setTextAndValue(LocaleController.getString("DistanceUnits", R.string.DistanceUnits), string, true);
                                                        break;
                                                    }
                                                } else {
                                                    textSettingsCell.setText(LocaleController.getString("LiteMode", R.string.LiteMode), true);
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
                                        int i3 = MessagesController.getGlobalMainSettings().getInt("sortContactsBy", 0);
                                        if (i3 == 0) {
                                            string2 = LocaleController.getString("Default", R.string.Default);
                                        } else if (i3 == 1) {
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
                                int i4 = Theme.autoNightDayEndTime;
                                int i5 = i4 / 60;
                                textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightTo", R.string.AutoNightTo), String.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4 - (i5 * 60))), false);
                                break;
                            }
                        } else {
                            int i6 = Theme.autoNightDayStartTime;
                            int i7 = i6 / 60;
                            textSettingsCell.setTextAndValue(LocaleController.getString("AutoNightFrom", R.string.AutoNightFrom), String.format("%02d:%02d", Integer.valueOf(i7), Integer.valueOf(i6 - (i7 * 60))), true);
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
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (i != ThemeActivity.this.automaticBrightnessInfoRow) {
                        if (i == ThemeActivity.this.scheduleLocationInfoRow) {
                            textInfoPrivacyCell.setText(ThemeActivity.this.getLocationSunString());
                            break;
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.formatString("AutoNightBrightnessInfo", R.string.AutoNightBrightnessInfo, Integer.valueOf((int) (Theme.autoNightBrighnessThreshold * 100.0f))));
                        break;
                    }
                    break;
                case 3:
                    if (i == ThemeActivity.this.stickersSection2Row || ((i == ThemeActivity.this.nightTypeInfoRow && ThemeActivity.this.themeInfoRow == -1) || (i == ThemeActivity.this.themeInfoRow && ThemeActivity.this.nightTypeInfoRow != -1))) {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        break;
                    } else {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        break;
                    }
                    break;
                case 4:
                    ThemeTypeCell themeTypeCell = (ThemeTypeCell) viewHolder.itemView;
                    if (i != ThemeActivity.this.nightDisabledRow) {
                        if (i != ThemeActivity.this.nightScheduledRow) {
                            if (i == ThemeActivity.this.nightAutomaticRow) {
                                themeTypeCell.setValue(LocaleController.getString("AutoNightAdaptive", R.string.AutoNightAdaptive), Theme.selectedAutoNightType == 2, ThemeActivity.this.nightSystemDefaultRow != -1);
                                break;
                            } else if (i == ThemeActivity.this.nightSystemDefaultRow) {
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
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i != ThemeActivity.this.scheduleHeaderRow) {
                        if (i != ThemeActivity.this.automaticHeaderRow) {
                            if (i != ThemeActivity.this.preferedHeaderRow) {
                                if (i != ThemeActivity.this.settingsRow) {
                                    if (i != ThemeActivity.this.themeHeaderRow) {
                                        if (i != ThemeActivity.this.textSizeHeaderRow) {
                                            if (i != ThemeActivity.this.chatListHeaderRow) {
                                                if (i != ThemeActivity.this.bubbleRadiusHeaderRow) {
                                                    if (i == ThemeActivity.this.swipeGestureHeaderRow) {
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
                    ((BrightnessControlCell) viewHolder.itemView).setProgress(Theme.autoNightBrighnessThreshold);
                    break;
                case 7:
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    if (i != ThemeActivity.this.scheduleLocationRow) {
                        if (i != ThemeActivity.this.enableAnimationsRow) {
                            if (i != ThemeActivity.this.sendByEnterRow) {
                                if (i != ThemeActivity.this.saveToGalleryRow) {
                                    if (i != ThemeActivity.this.raiseToSpeakRow) {
                                        if (i != ThemeActivity.this.customTabsRow) {
                                            if (i != ThemeActivity.this.directShareRow) {
                                                if (i == ThemeActivity.this.emojiRow) {
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
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                    if (i == ThemeActivity.this.nightThemeRow) {
                        boolean z = Theme.selectedAutoNightType != 0;
                        String currentNightThemeName = z ? Theme.getCurrentNightThemeName() : LocaleController.getString("AutoNightThemeOff", R.string.AutoNightThemeOff);
                        if (z) {
                            int i8 = Theme.selectedAutoNightType;
                            if (i8 == 1) {
                                string3 = LocaleController.getString("AutoNightScheduled", R.string.AutoNightScheduled);
                            } else if (i8 == 3) {
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
                    RecyclerListView recyclerListView = (RecyclerListView) viewHolder.itemView;
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
                    TextCell textCell = (TextCell) viewHolder.itemView;
                    if (i == ThemeActivity.this.backgroundRow) {
                        textCell.setTextAndIcon(LocaleController.getString("ChangeChatBackground", R.string.ChangeChatBackground), R.drawable.msg_background, false);
                        int i9 = Theme.key_windowBackgroundWhiteBlueText4;
                        textCell.setColors(i9, i9);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 4) {
                ((ThemeTypeCell) viewHolder.itemView).setTypeChecked(viewHolder.getAdapterPosition() == Theme.selectedAutoNightType);
            }
            if (itemViewType == 2 || itemViewType == 3) {
                return;
            }
            viewHolder.itemView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ThemeActivity.this.scheduleFromRow || i == ThemeActivity.this.distanceRow || i == ThemeActivity.this.scheduleToRow || i == ThemeActivity.this.scheduleUpdateLocationRow || i == ThemeActivity.this.contactsReimportRow || i == ThemeActivity.this.contactsSortRow || i == ThemeActivity.this.stickersRow || i == ThemeActivity.this.liteModeRow) {
                return 1;
            }
            if (i == ThemeActivity.this.automaticBrightnessInfoRow || i == ThemeActivity.this.scheduleLocationInfoRow) {
                return 2;
            }
            if (i == ThemeActivity.this.themeInfoRow || i == ThemeActivity.this.nightTypeInfoRow || i == ThemeActivity.this.scheduleFromToInfoRow || i == ThemeActivity.this.stickersSection2Row || i == ThemeActivity.this.settings2Row || i == ThemeActivity.this.newThemeInfoRow || i == ThemeActivity.this.chatListInfoRow || i == ThemeActivity.this.bubbleRadiusInfoRow || i == ThemeActivity.this.swipeGestureInfoRow) {
                return 3;
            }
            if (i == ThemeActivity.this.nightDisabledRow || i == ThemeActivity.this.nightScheduledRow || i == ThemeActivity.this.nightAutomaticRow || i == ThemeActivity.this.nightSystemDefaultRow) {
                return 4;
            }
            if (i == ThemeActivity.this.scheduleHeaderRow || i == ThemeActivity.this.automaticHeaderRow || i == ThemeActivity.this.preferedHeaderRow || i == ThemeActivity.this.settingsRow || i == ThemeActivity.this.themeHeaderRow || i == ThemeActivity.this.textSizeHeaderRow || i == ThemeActivity.this.chatListHeaderRow || i == ThemeActivity.this.bubbleRadiusHeaderRow || i == ThemeActivity.this.swipeGestureHeaderRow) {
                return 5;
            }
            if (i == ThemeActivity.this.automaticBrightnessRow) {
                return 6;
            }
            if (i == ThemeActivity.this.scheduleLocationRow || i == ThemeActivity.this.enableAnimationsRow || i == ThemeActivity.this.sendByEnterRow || i == ThemeActivity.this.saveToGalleryRow || i == ThemeActivity.this.raiseToSpeakRow || i == ThemeActivity.this.customTabsRow || i == ThemeActivity.this.directShareRow || i == ThemeActivity.this.emojiRow) {
                return 7;
            }
            if (i == ThemeActivity.this.textSizeRow) {
                return 8;
            }
            if (i == ThemeActivity.this.chatListRow) {
                return 9;
            }
            if (i == ThemeActivity.this.nightThemeRow) {
                return 10;
            }
            if (i == ThemeActivity.this.themeListRow) {
                return 11;
            }
            if (i == ThemeActivity.this.themeAccentListRow) {
                return 12;
            }
            if (i == ThemeActivity.this.bubbleRadiusRow) {
                return 13;
            }
            if (i == ThemeActivity.this.backgroundRow) {
                return 14;
            }
            return i == ThemeActivity.this.swipeGestureRow ? 15 : 1;
        }
    }

    private static abstract class TintRecyclerListView extends RecyclerListView {
        TintRecyclerListView(Context context) {
            super(context);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, BrightnessControlCell.class, ThemeTypeCell.class, TextSizeCell.class, BubbleRadiusCell.class, ChatListCell.class, NotificationsCheckCell.class, ThemesHorizontalListCell.class, TintRecyclerListView.class, TextCell.class, SwipeGestureSettingsView.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, Theme.key_actionBarDefaultSubmenuBackground));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        int i3 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i5 = Theme.key_windowBackgroundWhiteBlueText4;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i6 = Theme.key_switchTrack;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        int i7 = Theme.key_switchTrackChecked;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        int i8 = Theme.key_windowBackgroundWhiteGrayIcon;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{BrightnessControlCell.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{BrightnessControlCell.class}, new String[]{"rightImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        int i9 = Theme.key_player_progressBackground;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BrightnessControlCell.class}, new String[]{"seekBarView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        int i10 = Theme.key_player_progress;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{BrightnessControlCell.class}, new String[]{"seekBarView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ThemeTypeCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ThemeTypeCell.class}, new String[]{"checkImage"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_featuredStickers_addedIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{TextSizeCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{BubbleRadiusCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleRadiusCell.class}, new String[]{"sizeBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ChatListCell.class}, null, null, null, Theme.key_radioBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ChatListCell.class}, null, null, null, Theme.key_radioBackgroundChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, Theme.key_chat_inBubble));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInSelectedDrawable, Theme.chat_msgInMediaSelectedDrawable}, null, Theme.key_chat_inBubbleSelected));
        Drawable[] shadowDrawables = Theme.chat_msgInDrawable.getShadowDrawables();
        int i11 = Theme.key_chat_inBubbleShadow;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, shadowDrawables, null, i11));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, Theme.chat_msgInMediaDrawable.getShadowDrawables(), null, i11));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, Theme.key_chat_outBubble));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, Theme.key_chat_outBubbleGradient1));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, Theme.key_chat_outBubbleGradient2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, Theme.key_chat_outBubbleGradient3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutSelectedDrawable, Theme.chat_msgOutMediaSelectedDrawable}, null, Theme.key_chat_outBubbleSelected));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, Theme.key_chat_outBubbleShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, i11));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_messageTextIn));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_messageTextOut));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckDrawable}, null, Theme.key_chat_outSentCheck));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckSelectedDrawable}, null, Theme.key_chat_outSentCheckSelected));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadDrawable, Theme.chat_msgOutHalfCheckDrawable}, null, Theme.key_chat_outSentCheckRead));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadSelectedDrawable, Theme.chat_msgOutHalfCheckSelectedDrawable}, null, Theme.key_chat_outSentCheckReadSelected));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, new Drawable[]{Theme.chat_msgMediaCheckDrawable, Theme.chat_msgMediaHalfCheckDrawable}, null, Theme.key_chat_mediaSentCheck));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inReplyLine));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outReplyLine));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inReplyNameText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outReplyNameText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inReplyMessageText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outReplyMessageText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inReplyMediaMessageSelectedText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outReplyMediaMessageSelectedText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inTimeText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outTimeText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_inTimeSelectedText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSizeCell.class}, null, null, null, Theme.key_chat_outTimeSelectedText));
        return arrayList;
    }
}
