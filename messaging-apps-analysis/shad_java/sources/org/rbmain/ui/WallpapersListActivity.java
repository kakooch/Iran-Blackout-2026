package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.LongSparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.utilites.ContactConverter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_account_getWallPapers;
import org.rbmain.tgnet.TLRPC$TL_account_saveWallPaper;
import org.rbmain.tgnet.TLRPC$TL_account_wallPapers;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputWallPaper;
import org.rbmain.tgnet.TLRPC$TL_messages_getInlineBotResults;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$TL_wallPaperSettings;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.tgnet.TLRPC$WallPaperSettings;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_BotResults;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.WallpaperCell;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberTextView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.WallpaperUpdater;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes4.dex */
public class WallpapersListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ArrayList<View> actionModeViews;
    private ColorWallpaper addedColorWallpaper;
    private FileWallpaper addedFileWallpaper;
    private ArrayList<Object> allWallPapers;
    private HashMap<String, Object> allWallPapersDict;
    private Paint colorFramePaint;
    private Paint colorPaint;
    private int columnsCount;
    private int currentType;
    private final long dialogId;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private HashMap<String, Object> localDict;
    private ArrayList<ColorWallpaper> localWallPapers;
    private ArrayList<Object> patterns;
    private HashMap<Long, Object> patternsDict;
    private AlertDialog progressDialog;
    private int resetInfoRow;
    private int resetRow;
    private int resetSectionRow;
    private int rowCount;
    private boolean scrolling;
    private SearchAdapter searchAdapter;
    private EmptyTextProgressView searchEmptyView;
    private ActionBarMenuItem searchItem;
    private int sectionRow;
    private boolean selectedBackgroundBlurred;
    private boolean selectedBackgroundMotion;
    private String selectedBackgroundSlug;
    private int selectedColor;
    private int selectedGradientColor1;
    private int selectedGradientColor2;
    private int selectedGradientColor3;
    private int selectedGradientRotation;
    private float selectedIntensity;
    private NumberTextView selectedMessagesCountTextView;
    private LongSparseArray<Object> selectedWallPapers;
    private int setColorRow;
    private FileWallpaper themeWallpaper;
    private int totalWallpaperRows;
    private WallpaperUpdater updater;
    private int uploadImageRow;
    private int wallPaperStartRow;
    private ArrayList<Object> wallPapers;
    private static final int[][] defaultColorsLight = new int[0][];
    private static final int[][] defaultColorsDark = new int[0][];
    private static final int[] searchColors = {-16746753, -65536, -30208, -13824, -16718798, -14702165, -9240406, -409915, -9224159, -16777216, -10725281, -1};
    private static final String[] searchColorsNames = {"Blue", "Red", "Orange", "Yellow", "Green", "Teal", "Purple", "Pink", "Brown", "Black", "Gray", "White"};
    private static final int[] searchColorsNamesR = {R.string.Blue, R.string.Red, R.string.Orange, R.string.Yellow, R.string.Green, R.string.Teal, R.string.Purple, R.string.Pink, R.string.Brown, R.string.Black, R.string.Gray, R.string.White};

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public static class ColorWallpaper {
        public int color;
        public Bitmap defaultCache;
        public int gradientColor1;
        public int gradientColor2;
        public int gradientColor3;
        public int gradientRotation;
        public float intensity;
        public boolean isGradient;
        public boolean motion;
        public TLRPC$WallPaper parentWallpaper;
        public File path;
        public TLRPC$TL_wallPaper pattern;
        public long patternId;
        public String slug;

        public String getHash() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.color));
            sb.append(this.gradientColor1);
            sb.append(this.gradientColor2);
            sb.append(this.gradientColor3);
            sb.append(this.gradientRotation);
            sb.append(this.intensity);
            String str = this.slug;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            sb.append(str);
            return Utilities.MD5(sb.toString());
        }

        public ColorWallpaper(String str, int i, int i2, int i3) {
            this.slug = str;
            this.color = i | (-16777216);
            int i4 = i2 == 0 ? 0 : (-16777216) | i2;
            this.gradientColor1 = i4;
            this.gradientRotation = i4 == 0 ? 0 : i3;
            this.intensity = 1.0f;
        }

        public ColorWallpaper(String str, int i, int i2, int i3, int i4) {
            this.slug = str;
            this.color = i | (-16777216);
            this.gradientColor1 = i2 == 0 ? 0 : i2 | (-16777216);
            this.gradientColor2 = i3 == 0 ? 0 : i3 | (-16777216);
            this.gradientColor3 = i4 != 0 ? i4 | (-16777216) : 0;
            this.intensity = 1.0f;
            this.isGradient = true;
        }

        public ColorWallpaper(String str, int i, int i2, int i3, int i4, int i5, float f, boolean z, File file) {
            this.slug = str;
            this.color = i | (-16777216);
            int i6 = i2 == 0 ? 0 : i2 | (-16777216);
            this.gradientColor1 = i6;
            this.gradientColor2 = i3 == 0 ? 0 : i3 | (-16777216);
            this.gradientColor3 = i4 != 0 ? i4 | (-16777216) : 0;
            this.gradientRotation = i6 == 0 ? 45 : i5;
            this.intensity = f;
            this.path = file;
            this.motion = z;
        }

        public String getUrl() {
            int i = this.gradientColor1;
            String lowerCase = i != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i >> 16)) & 255), Integer.valueOf(((byte) (this.gradientColor1 >> 8)) & 255), Byte.valueOf((byte) (this.gradientColor1 & 255))).toLowerCase() : null;
            String lowerCase2 = String.format("%02x%02x%02x", Integer.valueOf(((byte) (this.color >> 16)) & 255), Integer.valueOf(((byte) (this.color >> 8)) & 255), Byte.valueOf((byte) (this.color & 255))).toLowerCase();
            int i2 = this.gradientColor2;
            String lowerCase3 = i2 != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i2 >> 16)) & 255), Integer.valueOf(((byte) (this.gradientColor2 >> 8)) & 255), Byte.valueOf((byte) (this.gradientColor2 & 255))).toLowerCase() : null;
            int i3 = this.gradientColor3;
            String lowerCase4 = i3 != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i3 >> 16)) & 255), Integer.valueOf(((byte) (this.gradientColor3 >> 8)) & 255), Byte.valueOf((byte) (this.gradientColor3 & 255))).toLowerCase() : null;
            if (lowerCase == null || lowerCase3 == null) {
                if (lowerCase != null) {
                    String str = lowerCase2 + "-" + lowerCase;
                    if (this.pattern != null) {
                        lowerCase2 = str + "&rotation=" + AndroidUtilities.getWallpaperRotation(this.gradientRotation, true);
                    } else {
                        lowerCase2 = str + "?rotation=" + AndroidUtilities.getWallpaperRotation(this.gradientRotation, true);
                    }
                }
            } else if (lowerCase4 != null) {
                lowerCase2 = lowerCase2 + "~" + lowerCase + "~" + lowerCase3 + "~" + lowerCase4;
            } else {
                lowerCase2 = lowerCase2 + "~" + lowerCase + "~" + lowerCase3;
            }
            if (this.pattern != null) {
                String str2 = "https://" + MessagesController.getInstance(UserConfig.selectedAccount).linkPrefix + "/bg/" + this.pattern.slug + "?intensity=" + ((int) (this.intensity * 100.0f)) + "&bg_color=" + lowerCase2;
                if (!this.motion) {
                    return str2;
                }
                return str2 + "&mode=motion";
            }
            return "https://" + MessagesController.getInstance(UserConfig.selectedAccount).linkPrefix + "/bg/" + lowerCase2;
        }
    }

    public static class FileWallpaper {
        public File originalPath;
        public File path;
        public int resId;
        public String slug;
        public int thumbResId;

        public FileWallpaper(String str, File file, File file2) {
            this.slug = str;
            this.path = file;
            this.originalPath = file2;
        }

        public FileWallpaper(String str, int i, int i2) {
            this.slug = str;
            this.resId = i;
            this.thumbResId = i2;
        }
    }

    public WallpapersListActivity(int i) {
        this(i, 0L);
    }

    public WallpapersListActivity(int i, long j) {
        this.actionModeViews = new ArrayList<>();
        this.columnsCount = 3;
        this.selectedBackgroundSlug = BuildConfig.FLAVOR;
        this.allWallPapers = new ArrayList<>();
        this.allWallPapersDict = new HashMap<>();
        this.localDict = new HashMap<>();
        this.wallPapers = new ArrayList<>();
        this.localWallPapers = new ArrayList<>();
        this.patterns = new ArrayList<>();
        this.patternsDict = new HashMap<>();
        this.selectedWallPapers = new LongSparseArray<>();
        this.currentType = i;
        this.dialogId = j;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        if (this.currentType == 0) {
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersDidLoad);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersNeedReload);
        } else {
            fillDefaultColors(this.wallPapers, Theme.isCurrentThemeDark());
            if (this.currentType == 1 && this.patterns.isEmpty()) {
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersDidLoad);
            }
        }
        loadWallpapers(true);
        return super.onFragmentCreate();
    }

    public static void fillDefaultColors(ArrayList<Object> arrayList, boolean z) {
        int[][] iArr = z ? defaultColorsDark : defaultColorsLight;
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i].length == 1) {
                arrayList.add(new ColorWallpaper("c", iArr[i][0], 0, 45));
            } else {
                arrayList.add(new ColorWallpaper("c", iArr[i][0], iArr[i][1], iArr[i][2], iArr[i][3]));
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        int i = this.currentType;
        if (i == 0) {
            this.searchAdapter.onDestroy();
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.wallpapersDidLoad);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.wallpapersNeedReload);
        } else if (i == 1) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.wallpapersDidLoad);
        }
        this.updater.cleanup();
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i = 1;
        this.colorPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.colorFramePaint = paint;
        paint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        this.colorFramePaint.setStyle(Paint.Style.STROKE);
        this.colorFramePaint.setColor(855638016);
        this.updater = new WallpaperUpdater(getParentActivity(), this, new WallpaperUpdater.WallpaperUpdaterDelegate() { // from class: org.rbmain.ui.WallpapersListActivity.1
            @Override // org.rbmain.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
            public void needOpenColorPicker() {
            }

            @Override // org.rbmain.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
            public void didSelectWallpaper(File file, Bitmap bitmap, boolean z) {
                ThemePreviewActivity themePreviewActivity = new ThemePreviewActivity(new FileWallpaper(BuildConfig.FLAVOR, file, file), bitmap);
                themePreviewActivity.setDialogId(WallpapersListActivity.this.dialogId);
                if (WallpapersListActivity.this.dialogId != 0) {
                    themePreviewActivity.setDelegate(new WallpapersListActivity$$ExternalSyntheticLambda7(WallpapersListActivity.this));
                }
                WallpapersListActivity.this.presentFragment(themePreviewActivity, z);
            }
        });
        this.hasOwnBackground = true;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i2 = this.currentType;
        if (i2 == 0) {
            this.actionBar.setTitle(LocaleController.getString("ChatBackground", R.string.ChatBackground));
        } else if (i2 == 1) {
            this.actionBar.setTitle(LocaleController.getString("SelectColorTitle", R.string.SelectColorTitle));
        }
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass2());
        boolean z = false;
        if (this.currentType == 0) {
            ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.WallpapersListActivity.3
                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                    WallpapersListActivity.this.listView.setAdapter(WallpapersListActivity.this.searchAdapter);
                    WallpapersListActivity.this.listView.invalidate();
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchCollapse() {
                    WallpapersListActivity.this.listView.setAdapter(WallpapersListActivity.this.listAdapter);
                    WallpapersListActivity.this.listView.invalidate();
                    WallpapersListActivity.this.searchAdapter.processSearch(null, true);
                    WallpapersListActivity.this.searchItem.setSearchFieldCaption(null);
                    onCaptionCleared();
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) {
                    WallpapersListActivity.this.searchAdapter.processSearch(editText.getText().toString(), false);
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onCaptionCleared() {
                    WallpapersListActivity.this.searchAdapter.clearColor();
                    WallpapersListActivity.this.searchItem.setSearchFieldHint(LocaleController.getString("SearchBackgrounds", R.string.SearchBackgrounds));
                }
            });
            this.searchItem = actionBarMenuItemSearchListener;
            actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("SearchBackgrounds", R.string.SearchBackgrounds));
            this.searchItem.setVisibility(8);
            ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode(false, null);
            actionBarMenuCreateActionMode.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
            ActionBar actionBar = this.actionBar;
            int i3 = Theme.key_actionBarDefaultIcon;
            actionBar.setItemsColor(Theme.getColor(i3), true);
            this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSelector), true);
            NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
            this.selectedMessagesCountTextView = numberTextView;
            numberTextView.setTextSize(18);
            this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.selectedMessagesCountTextView.setTextColor(Theme.getColor(i3));
            this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return WallpapersListActivity.lambda$createView$0(view, motionEvent);
                }
            });
            actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 65, 0, 0, 0));
            this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(3, R.drawable.msg_forward, AndroidUtilities.dp(54.0f), LocaleController.getString("Forward", R.string.Forward)));
            this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(4, R.drawable.msg_delete, AndroidUtilities.dp(54.0f), LocaleController.getString("Delete", R.string.Delete)));
            this.selectedWallPapers.clear();
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.WallpapersListActivity.4
            private Paint paint = new Paint();

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onDraw(android.graphics.Canvas r15) {
                /*
                    r14 = this;
                    androidx.recyclerview.widget.RecyclerView$Adapter r0 = r14.getAdapter()
                    org.rbmain.ui.WallpapersListActivity r1 = org.rbmain.ui.WallpapersListActivity.this
                    org.rbmain.ui.WallpapersListActivity$ListAdapter r1 = org.rbmain.ui.WallpapersListActivity.access$2100(r1)
                    if (r0 != r1) goto L20
                    org.rbmain.ui.WallpapersListActivity r0 = org.rbmain.ui.WallpapersListActivity.this
                    int r0 = org.rbmain.ui.WallpapersListActivity.access$2400(r0)
                    r1 = -1
                    if (r0 == r1) goto L20
                    org.rbmain.ui.WallpapersListActivity r0 = org.rbmain.ui.WallpapersListActivity.this
                    int r0 = org.rbmain.ui.WallpapersListActivity.access$2400(r0)
                    androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r14.findViewHolderForAdapterPosition(r0)
                    goto L21
                L20:
                    r0 = 0
                L21:
                    int r1 = r14.getMeasuredHeight()
                    if (r0 == 0) goto L35
                    android.view.View r2 = r0.itemView
                    int r2 = r2.getBottom()
                    android.view.View r0 = r0.itemView
                    int r0 = r0.getBottom()
                    if (r0 < r1) goto L36
                L35:
                    r2 = r1
                L36:
                    android.graphics.Paint r0 = r14.paint
                    int r3 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundWhite
                    int r3 = org.rbmain.ui.ActionBar.Theme.getColor(r3)
                    r0.setColor(r3)
                    r5 = 0
                    r6 = 0
                    int r0 = r14.getMeasuredWidth()
                    float r7 = (float) r0
                    float r10 = (float) r2
                    android.graphics.Paint r9 = r14.paint
                    r4 = r15
                    r8 = r10
                    r4.drawRect(r5, r6, r7, r8, r9)
                    if (r2 == r1) goto L6a
                    android.graphics.Paint r0 = r14.paint
                    int r2 = org.rbmain.ui.ActionBar.Theme.key_windowBackgroundGray
                    int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
                    r0.setColor(r2)
                    r9 = 0
                    int r0 = r14.getMeasuredWidth()
                    float r11 = (float) r0
                    float r12 = (float) r1
                    android.graphics.Paint r13 = r14.paint
                    r8 = r15
                    r8.drawRect(r9, r10, r11, r12, r13)
                L6a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.WallpapersListActivity.AnonymousClass4.onDraw(android.graphics.Canvas):void");
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context, i, z) { // from class: org.rbmain.ui.WallpapersListActivity.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.searchAdapter = new SearchAdapter(context);
        this.listView.setGlowColor(Theme.getColor(Theme.key_avatar_backgroundActionBarBlue));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda6
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$createView$3(view, i4);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.WallpapersListActivity.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                if (i4 == 1) {
                    AndroidUtilities.hideKeyboard(WallpapersListActivity.this.getParentActivity().getCurrentFocus());
                }
                WallpapersListActivity.this.scrolling = i4 != 0;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                if (WallpapersListActivity.this.listView.getAdapter() == WallpapersListActivity.this.searchAdapter) {
                    int iFindFirstVisibleItemPosition = WallpapersListActivity.this.layoutManager.findFirstVisibleItemPosition();
                    int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(WallpapersListActivity.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                    if (iAbs > 0) {
                        int itemCount = WallpapersListActivity.this.layoutManager.getItemCount();
                        if (iAbs == 0 || iFindFirstVisibleItemPosition + iAbs <= itemCount - 2) {
                            return;
                        }
                        WallpapersListActivity.this.searchAdapter.loadMoreResults();
                    }
                }
            }
        });
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.searchEmptyView = emptyTextProgressView;
        emptyTextProgressView.setVisibility(8);
        this.searchEmptyView.setShowAtCenter(true);
        this.searchEmptyView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.listView.setEmptyView(this.searchEmptyView);
        frameLayout2.addView(this.searchEmptyView, LayoutHelper.createFrame(-1, -1.0f));
        updateRows();
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.WallpapersListActivity$2, reason: invalid class name */
    class AnonymousClass2 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass2() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == -1) {
                if (((BaseFragment) WallpapersListActivity.this).actionBar.isActionModeShowed()) {
                    WallpapersListActivity.this.selectedWallPapers.clear();
                    ((BaseFragment) WallpapersListActivity.this).actionBar.hideActionMode();
                    WallpapersListActivity.this.updateRowsSelection();
                    return;
                }
                WallpapersListActivity.this.finishFragment();
                return;
            }
            if (i != 4) {
                if (i == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("onlySelect", true);
                    bundle.putInt("dialogsType", 3);
                    DialogsActivity dialogsActivity = new DialogsActivity(bundle);
                    dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$2$$ExternalSyntheticLambda3
                        @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                        public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                            this.f$0.lambda$onItemClick$3(dialogsActivity2, arrayList, charSequence, z);
                        }
                    });
                    WallpapersListActivity.this.presentFragment(dialogsActivity);
                    return;
                }
                return;
            }
            if (WallpapersListActivity.this.getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(WallpapersListActivity.this.getParentActivity());
            builder.setTitle(LocaleController.formatPluralString("DeleteBackground", WallpapersListActivity.this.selectedWallPapers.size()));
            builder.setMessage(LocaleController.formatString("DeleteChatBackgroundsAlert", R.string.DeleteChatBackgroundsAlert, new Object[0]));
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.WallpapersListActivity$2$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) throws IOException {
                    this.f$0.lambda$onItemClick$2(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            WallpapersListActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2(DialogInterface dialogInterface, int i) throws IOException {
            WallpapersListActivity.this.progressDialog = new AlertDialog(WallpapersListActivity.this.getParentActivity(), 3);
            WallpapersListActivity.this.progressDialog.setCanCancel(false);
            WallpapersListActivity.this.progressDialog.show();
            new ArrayList();
            final int[] iArr = {0};
            for (int i2 = 0; i2 < WallpapersListActivity.this.selectedWallPapers.size(); i2++) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) WallpapersListActivity.this.selectedWallPapers.valueAt(i2);
                TLRPC$TL_account_saveWallPaper tLRPC$TL_account_saveWallPaper = new TLRPC$TL_account_saveWallPaper();
                tLRPC$TL_account_saveWallPaper.settings = new TLRPC$TL_wallPaperSettings();
                tLRPC$TL_account_saveWallPaper.unsave = true;
                TLRPC$TL_inputWallPaper tLRPC$TL_inputWallPaper = new TLRPC$TL_inputWallPaper();
                tLRPC$TL_inputWallPaper.id = tLRPC$TL_wallPaper.id;
                tLRPC$TL_inputWallPaper.access_hash = tLRPC$TL_wallPaper.access_hash;
                tLRPC$TL_account_saveWallPaper.wallpaper = tLRPC$TL_inputWallPaper;
                String str = tLRPC$TL_wallPaper.slug;
                if (str != null && str.equals(WallpapersListActivity.this.selectedBackgroundSlug)) {
                    WallpapersListActivity.this.selectedBackgroundSlug = Theme.hasWallpaperFromTheme() ? "t" : "d";
                    Theme.getActiveTheme().setOverrideWallpaper(null);
                    Theme.reloadWallpaper(true);
                }
                ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_account_saveWallPaper, new RequestDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$2$$ExternalSyntheticLambda2
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$1(iArr, tLObject, tLRPC$TL_error);
                    }
                });
            }
            if (iArr[0] == 0) {
                WallpapersListActivity.this.loadWallpapers(true);
            }
            WallpapersListActivity.this.selectedWallPapers.clear();
            ((BaseFragment) WallpapersListActivity.this).actionBar.hideActionMode();
            ((BaseFragment) WallpapersListActivity.this).actionBar.closeSearchField();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(final int[] iArr, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0(iArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(int[] iArr) {
            iArr[0] = iArr[0] - 1;
            if (iArr[0] == 0) {
                WallpapersListActivity.this.loadWallpapers(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$3(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
            String url;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < WallpapersListActivity.this.selectedWallPapers.size(); i++) {
                Object objValueAt = WallpapersListActivity.this.selectedWallPapers.valueAt(i);
                if (objValueAt instanceof TLRPC$TL_wallPaper) {
                    url = AndroidUtilities.getWallPaperUrl(objValueAt);
                } else if (objValueAt instanceof ColorWallpaper) {
                    url = ((ColorWallpaper) objValueAt).getUrl();
                }
                if (!TextUtils.isEmpty(url)) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(url);
                }
            }
            WallpapersListActivity.this.selectedWallPapers.clear();
            ((BaseFragment) WallpapersListActivity.this).actionBar.hideActionMode();
            ((BaseFragment) WallpapersListActivity.this).actionBar.closeSearchField();
            if (arrayList.size() > 1 || ((Long) arrayList.get(0)).longValue() == UserConfig.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).getClientUserId() || charSequence != null) {
                WallpapersListActivity.this.updateRowsSelection();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    long jLongValue = ((Long) arrayList.get(i2)).longValue();
                    if (charSequence != null) {
                        SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(charSequence.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                    }
                    SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(sb.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                }
                dialogsActivity.finishFragment();
                return;
            }
            long jLongValue2 = ((Long) arrayList.get(0)).longValue();
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            if (DialogObject.isEncryptedDialog(jLongValue2)) {
                bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue2));
            } else {
                if (DialogObject.isUserDialog(jLongValue2)) {
                    bundle.putInt("user_id", (int) jLongValue2);
                } else if (DialogObject.isChatDialog(jLongValue2)) {
                    bundle.putInt("chat_id", (int) (-jLongValue2));
                }
                if (!MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).checkCanOpenChat(bundle, dialogsActivity)) {
                    return;
                }
            }
            NotificationCenter.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            WallpapersListActivity.this.presentFragment(new ChatActivity(bundle), true);
            SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(sb.toString(), jLongValue2, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view, int i) {
        if (getParentActivity() == null || this.listView.getAdapter() == this.searchAdapter) {
            return;
        }
        if (i == this.uploadImageRow) {
            this.updater.openGallery();
            return;
        }
        if (i == this.setColorRow) {
            WallpapersListActivity wallpapersListActivity = new WallpapersListActivity(1);
            wallpapersListActivity.patterns = this.patterns;
            presentFragment(wallpapersListActivity);
        } else if (i == this.resetRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("ResetChatBackgroundsAlertTitle", R.string.ResetChatBackgroundsAlertTitle));
            builder.setMessage(LocaleController.getString("ResetChatBackgroundsAlert", R.string.ResetChatBackgroundsAlert));
            builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$2(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DialogInterface dialogInterface, int i) {
        if (this.actionBar.isActionModeShowed()) {
            this.selectedWallPapers.clear();
            this.actionBar.hideActionMode();
            updateRowsSelection();
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
        ContactsProxy.getInstance(this.currentAccount).resetWallpapers(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_resetWallPapers
            public static int constructor = -1153722364;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda5
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$1(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity.6
            @Override // java.lang.Runnable
            public void run() {
                WallpapersListActivity.this.progressDialog.dismiss();
                WallpapersListActivity.this.lambda$loadWallpapers$4(tLObject);
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() throws IOException {
        TLRPC$WallPaper tLRPC$WallPaper;
        super.onResume();
        MessagesController.getGlobalMainSettings();
        Theme.ThemeInfo activeTheme = Theme.getActiveTheme();
        if (this.dialogId != 0) {
            TLRPC$UserFull userFull = getMessagesController().getUserFull((int) this.dialogId);
            if (userFull != null && (tLRPC$WallPaper = userFull.wallpaper) != null) {
                String str = tLRPC$WallPaper.slug;
                this.selectedBackgroundSlug = str;
                if (str == null) {
                    this.selectedBackgroundSlug = BuildConfig.FLAVOR;
                }
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$WallPaper.settings;
                if (tLRPC$WallPaperSettings != null) {
                    this.selectedColor = tLRPC$WallPaperSettings.background_color;
                    this.selectedGradientColor1 = tLRPC$WallPaperSettings.second_background_color;
                    this.selectedGradientColor2 = tLRPC$WallPaperSettings.third_background_color;
                    this.selectedGradientColor3 = tLRPC$WallPaperSettings.fourth_background_color;
                    this.selectedGradientRotation = tLRPC$WallPaperSettings.rotation;
                    this.selectedIntensity = tLRPC$WallPaperSettings.intensity;
                    this.selectedBackgroundMotion = tLRPC$WallPaperSettings.motion;
                    this.selectedBackgroundBlurred = tLRPC$WallPaperSettings.blur;
                }
            }
        } else {
            Theme.OverrideWallpaperInfo overrideWallpaperInfo = activeTheme.overrideWallpaper;
            if (overrideWallpaperInfo != null) {
                String str2 = overrideWallpaperInfo.slug;
                this.selectedBackgroundSlug = str2;
                if (str2 == null) {
                    this.selectedBackgroundSlug = BuildConfig.FLAVOR;
                }
                this.selectedColor = overrideWallpaperInfo.color;
                this.selectedGradientColor1 = overrideWallpaperInfo.gradientColor1;
                this.selectedGradientColor2 = overrideWallpaperInfo.gradientColor2;
                this.selectedGradientColor3 = overrideWallpaperInfo.gradientColor3;
                this.selectedGradientRotation = overrideWallpaperInfo.rotation;
                this.selectedIntensity = overrideWallpaperInfo.intensity;
                this.selectedBackgroundMotion = overrideWallpaperInfo.isMotion;
                this.selectedBackgroundBlurred = overrideWallpaperInfo.isBlurred;
            } else {
                this.selectedBackgroundSlug = Theme.hasWallpaperFromTheme() ? "t" : "d";
                this.selectedColor = 0;
                this.selectedGradientColor1 = 0;
                this.selectedGradientColor2 = 0;
                this.selectedGradientColor3 = 0;
                this.selectedGradientRotation = 45;
                this.selectedIntensity = 1.0f;
                this.selectedBackgroundMotion = false;
                this.selectedBackgroundBlurred = false;
            }
        }
        fillWallpapersWithCustom();
        fixLayout();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fixLayout();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
        this.updater.onActivityResult(i, i2, intent);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle bundle) {
        String currentPicturePath = this.updater.getCurrentPicturePath();
        if (currentPicturePath != null) {
            bundle.putString("path", currentPicturePath);
        }
    }

    public void restoreSelfArgs(Bundle bundle) {
        this.updater.setCurrentPicturePath(bundle.getString("path"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(WallpaperCell wallpaperCell, Object obj, int i) {
        WallpaperCell wallpaperCell2;
        int i2;
        Object obj2 = obj;
        boolean z = false;
        if (this.actionBar.isActionModeShowed()) {
            Object obj3 = obj2 instanceof ColorWallpaper ? ((ColorWallpaper) obj2).parentWallpaper : obj2;
            if (obj3 instanceof TLRPC$WallPaper) {
                TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) obj3;
                if (this.selectedWallPapers.indexOfKey(tLRPC$WallPaper.id) >= 0) {
                    this.selectedWallPapers.remove(tLRPC$WallPaper.id);
                } else {
                    this.selectedWallPapers.put(tLRPC$WallPaper.id, obj2);
                }
                if (this.selectedWallPapers.size() == 0) {
                    this.actionBar.hideActionMode();
                } else {
                    this.selectedMessagesCountTextView.setNumber(this.selectedWallPapers.size(), true);
                }
                this.scrolling = false;
                if (this.selectedWallPapers.indexOfKey(tLRPC$WallPaper.id) >= 0) {
                    wallpaperCell2 = wallpaperCell;
                    i2 = i;
                    z = true;
                } else {
                    wallpaperCell2 = wallpaperCell;
                    i2 = i;
                }
                wallpaperCell2.setChecked(i2, z, true);
                return;
            }
            return;
        }
        String wallPaperSlug = getWallPaperSlug(obj2);
        boolean z2 = obj2 instanceof TLRPC$TL_wallPaper;
        Object obj4 = obj2;
        if (z2) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj2;
            obj4 = obj2;
            if (tLRPC$TL_wallPaper.pattern) {
                String str = tLRPC$TL_wallPaper.slug;
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_wallPaper.settings;
                ColorWallpaper colorWallpaper = new ColorWallpaper(str, tLRPC$WallPaperSettings.background_color, tLRPC$WallPaperSettings.second_background_color, tLRPC$WallPaperSettings.third_background_color, tLRPC$WallPaperSettings.fourth_background_color, AndroidUtilities.getWallpaperRotation(tLRPC$WallPaperSettings.rotation, false), r6.intensity / 100.0f, tLRPC$TL_wallPaper.settings.motion, null);
                colorWallpaper.pattern = tLRPC$TL_wallPaper;
                colorWallpaper.parentWallpaper = tLRPC$TL_wallPaper;
                obj4 = colorWallpaper;
            }
        }
        ContactConverter.addWallpaperThumbnail(obj4);
        ThemePreviewActivity themePreviewActivity = new ThemePreviewActivity(obj4, null, true, false);
        if (this.currentType == 1 || this.dialogId != 0) {
            themePreviewActivity.setDelegate(new WallpapersListActivity$$ExternalSyntheticLambda7(this));
        }
        String str2 = this.selectedBackgroundSlug;
        if (str2 != null && str2.equals(wallPaperSlug)) {
            themePreviewActivity.setInitialModes(this.selectedBackgroundBlurred, this.selectedBackgroundMotion, this.selectedIntensity);
        }
        themePreviewActivity.setPatterns(this.patterns);
        themePreviewActivity.setDialogId(this.dialogId);
        presentFragment(themePreviewActivity);
    }

    private String getWallPaperSlug(Object obj) {
        if (obj instanceof TLRPC$TL_wallPaper) {
            return ((TLRPC$TL_wallPaper) obj).slug;
        }
        if (obj instanceof ColorWallpaper) {
            return ((ColorWallpaper) obj).slug;
        }
        if (obj instanceof FileWallpaper) {
            return ((FileWallpaper) obj).slug;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsSelection() {
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof WallpaperCell) {
                WallpaperCell wallpaperCell = (WallpaperCell) childAt;
                for (int i2 = 0; i2 < 5; i2++) {
                    wallpaperCell.setChecked(i2, false, true);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r18, int r19, java.lang.Object... r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.WallpapersListActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWallpapers(boolean z) {
        if (!z) {
            int size = this.allWallPapers.size();
            for (int i = 0; i < size; i++) {
                Object obj = this.allWallPapers.get(i);
                if (obj instanceof TLRPC$WallPaper) {
                    long j = ((TLRPC$WallPaper) obj).id;
                }
            }
        }
        TLRPC$TL_account_getWallPapers tLRPC$TL_account_getWallPapers = new TLRPC$TL_account_getWallPapers();
        tLRPC$TL_account_getWallPapers.hash = (int) 0;
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().getWallpapers(tLRPC$TL_account_getWallPapers, new RequestDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadWallpapers$5(tLObject, tLRPC$TL_error);
            }
        });
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(0, this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWallpapers$5(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadWallpapers$4(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onWallpapersDidLoad, reason: merged with bridge method [inline-methods] */
    public void lambda$loadWallpapers$4(TLObject tLObject) {
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
        if (tLObject instanceof TLRPC$TL_account_wallPapers) {
            TLRPC$TL_account_wallPapers tLRPC$TL_account_wallPapers = (TLRPC$TL_account_wallPapers) tLObject;
            this.patterns.clear();
            this.wallPapers.clear();
            this.allWallPapersDict.clear();
            this.allWallPapers.clear();
            this.allWallPapers.addAll(tLRPC$TL_account_wallPapers.wallpapers);
            int size = tLRPC$TL_account_wallPapers.wallpapers.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) tLRPC$TL_account_wallPapers.wallpapers.get(i);
                this.allWallPapersDict.put(tLRPC$TL_wallPaper.slug, tLRPC$TL_wallPaper);
                if (tLRPC$TL_wallPaper.pattern) {
                    this.patterns.add(tLRPC$TL_wallPaper);
                }
                if (this.currentType != 1 && (!tLRPC$TL_wallPaper.pattern || ((tLRPC$WallPaperSettings = tLRPC$TL_wallPaper.settings) != null && tLRPC$WallPaperSettings.background_color != 0))) {
                    this.wallPapers.add(tLRPC$TL_wallPaper);
                }
            }
            if (this.currentType == 1) {
                int size2 = tLRPC$TL_account_wallPapers.colors.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ColorWallpaper colorWallpaper = tLRPC$TL_account_wallPapers.colors.get(i2);
                    this.allWallPapersDict.put(colorWallpaper.slug, colorWallpaper);
                    this.wallPapers.add(colorWallpaper);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity.8
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    WallpapersListActivity.this.fillWallpapersWithCustom();
                }
            });
        }
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.listView.smoothScrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [org.rbmain.tgnet.TLRPC$TL_wallPaper, org.rbmain.tgnet.TLRPC$WallPaper] */
    /* JADX WARN: Type inference failed for: r4v13, types: [org.rbmain.ui.WallpapersListActivity$ColorWallpaper] */
    public void fillWallpapersWithCustom() throws IOException {
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper;
        final String str;
        Object obj;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper2;
        final long j;
        TLRPC$WallPaper tLRPC$WallPaper;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper3;
        Object obj2;
        int i5;
        String str3;
        if (this.currentType != 0) {
            updateRows();
            return;
        }
        MessagesController.getGlobalMainSettings();
        ColorWallpaper colorWallpaper = this.addedColorWallpaper;
        if (colorWallpaper != null) {
            this.wallPapers.remove(colorWallpaper);
            this.addedColorWallpaper = null;
        }
        FileWallpaper fileWallpaper = this.addedFileWallpaper;
        if (fileWallpaper != null) {
            this.wallPapers.remove(fileWallpaper);
            this.addedFileWallpaper = null;
        }
        FileWallpaper fileWallpaper2 = this.themeWallpaper;
        if (fileWallpaper2 != null) {
            this.wallPapers.remove(fileWallpaper2);
        }
        int size = this.wallPapers.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                tLRPC$TL_wallPaper = 0;
                break;
            }
            Object obj3 = this.wallPapers.get(i6);
            if (obj3 instanceof ColorWallpaper) {
                tLRPC$TL_wallPaper = (ColorWallpaper) obj3;
                String str4 = tLRPC$TL_wallPaper.slug;
                if (str4 != null) {
                    tLRPC$TL_wallPaper.pattern = (TLRPC$TL_wallPaper) this.allWallPapersDict.get(str4);
                }
                if (("c".equals(tLRPC$TL_wallPaper.slug) || (str3 = tLRPC$TL_wallPaper.slug) == null || TextUtils.equals(this.selectedBackgroundSlug, str3)) && this.selectedColor == tLRPC$TL_wallPaper.color && (i5 = this.selectedGradientColor1) == tLRPC$TL_wallPaper.gradientColor1 && this.selectedGradientColor2 == tLRPC$TL_wallPaper.gradientColor2 && this.selectedGradientColor3 == tLRPC$TL_wallPaper.gradientColor3 && (i5 == 0 || this.selectedGradientRotation == tLRPC$TL_wallPaper.gradientRotation)) {
                    break;
                } else {
                    i6++;
                }
            } else {
                if (obj3 instanceof TLRPC$TL_wallPaper) {
                    tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj3;
                    if (tLRPC$TL_wallPaper.settings != null && TextUtils.equals(this.selectedBackgroundSlug, tLRPC$TL_wallPaper.slug) && this.selectedColor == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.background_color) && this.selectedGradientColor1 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.second_background_color) && this.selectedGradientColor2 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.third_background_color) && this.selectedGradientColor3 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.fourth_background_color) && ((this.selectedGradientColor1 == 0 || this.selectedGradientRotation == AndroidUtilities.getWallpaperRotation(tLRPC$TL_wallPaper.settings.rotation, false)) && Math.abs(Theme.getThemeIntensity(tLRPC$TL_wallPaper.settings.intensity / 100.0f) - this.selectedIntensity) <= 0.001f)) {
                        break;
                    }
                } else {
                    continue;
                }
                i6++;
            }
        }
        if (tLRPC$TL_wallPaper instanceof TLRPC$WallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper4 = tLRPC$TL_wallPaper;
            Theme.OverrideWallpaperInfo overrideWallpaperInfo = Theme.getActiveTheme().overrideWallpaper;
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_wallPaper4.settings;
            if (tLRPC$WallPaperSettings == null || !(tLRPC$WallPaperSettings == null || (this.selectedColor == Theme.getWallpaperColor(tLRPC$WallPaperSettings.background_color) && this.selectedGradientColor1 == Theme.getWallpaperColor(tLRPC$TL_wallPaper4.settings.second_background_color) && this.selectedGradientColor2 == Theme.getWallpaperColor(tLRPC$TL_wallPaper4.settings.third_background_color) && this.selectedGradientColor3 == Theme.getWallpaperColor(tLRPC$TL_wallPaper4.settings.fourth_background_color) && (this.selectedGradientColor1 == 0 || this.selectedGradientColor2 != 0 || this.selectedGradientRotation == AndroidUtilities.getWallpaperRotation(tLRPC$TL_wallPaper4.settings.rotation, false) || Math.abs(Theme.getThemeIntensity(tLRPC$TL_wallPaper4.settings.intensity / 100.0f) - this.selectedIntensity) <= 0.001f)))) {
                str2 = BuildConfig.FLAVOR;
                tLRPC$TL_wallPaper3 = tLRPC$TL_wallPaper4;
                obj2 = null;
            } else {
                str2 = this.selectedBackgroundSlug;
                tLRPC$TL_wallPaper3 = null;
                obj2 = tLRPC$TL_wallPaper;
            }
            str = str2;
            tLRPC$TL_wallPaper2 = tLRPC$TL_wallPaper3;
            obj = obj2;
            j = tLRPC$TL_wallPaper4.id;
        } else {
            str = this.selectedBackgroundSlug;
            obj = tLRPC$TL_wallPaper;
            tLRPC$TL_wallPaper2 = null;
            j = (!(tLRPC$TL_wallPaper instanceof ColorWallpaper) || (tLRPC$WallPaper = tLRPC$TL_wallPaper.parentWallpaper) == null) ? 0L : tLRPC$WallPaper.id;
        }
        final boolean zIsDark = Theme.getCurrentTheme().isDark();
        try {
            Collections.sort(this.wallPapers, new Comparator() { // from class: org.rbmain.ui.WallpapersListActivity$$ExternalSyntheticLambda3
                @Override // java.util.Comparator
                public final int compare(Object obj4, Object obj5) {
                    return this.f$0.lambda$fillWallpapersWithCustom$6(str, j, zIsDark, obj4, obj5);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (Theme.hasWallpaperFromTheme() && !Theme.isThemeWallpaperPublic()) {
            if (this.themeWallpaper == null) {
                this.themeWallpaper = new FileWallpaper("t", -2, -2);
            }
            this.wallPapers.add(0, this.themeWallpaper);
        } else {
            this.themeWallpaper = null;
        }
        Theme.ThemeInfo activeTheme = Theme.getActiveTheme();
        String str5 = this.selectedBackgroundSlug;
        if (str5 == null || TextUtils.isEmpty(str5) || (!"d".equals(this.selectedBackgroundSlug) && obj == null)) {
            if (!"c".equals(this.selectedBackgroundSlug) && (i2 = this.selectedColor) != 0) {
                if (activeTheme.overrideWallpaper != null) {
                    ColorWallpaper colorWallpaper2 = new ColorWallpaper(this.selectedBackgroundSlug, i2, this.selectedGradientColor1, this.selectedGradientColor2, this.selectedGradientColor3, this.selectedGradientRotation, this.selectedIntensity, this.selectedBackgroundMotion, new File(ApplicationLoader.getFilesDirFixed(), activeTheme.overrideWallpaper.fileName));
                    this.addedColorWallpaper = colorWallpaper2;
                    colorWallpaper2.pattern = tLRPC$TL_wallPaper2;
                    this.wallPapers.add(0, colorWallpaper2);
                }
            } else {
                int i7 = this.selectedColor;
                if (i7 != 0) {
                    int i8 = this.selectedGradientColor1;
                    if (i8 != 0 && (i = this.selectedGradientColor2) != 0) {
                        ColorWallpaper colorWallpaper3 = new ColorWallpaper(this.selectedBackgroundSlug, i7, i8, i, this.selectedGradientColor3);
                        this.addedColorWallpaper = colorWallpaper3;
                        colorWallpaper3.gradientRotation = this.selectedGradientRotation;
                    } else {
                        this.addedColorWallpaper = new ColorWallpaper(this.selectedBackgroundSlug, i7, i8, this.selectedGradientRotation);
                    }
                    this.wallPapers.add(0, this.addedColorWallpaper);
                } else if (activeTheme.overrideWallpaper != null && !this.allWallPapersDict.containsKey(this.selectedBackgroundSlug)) {
                    FileWallpaper fileWallpaper3 = new FileWallpaper(this.selectedBackgroundSlug, new File(ApplicationLoader.getFilesDirFixed(), activeTheme.overrideWallpaper.fileName), new File(ApplicationLoader.getFilesDirFixed(), activeTheme.overrideWallpaper.originalFileName));
                    this.addedFileWallpaper = fileWallpaper3;
                    this.wallPapers.add(this.themeWallpaper != null ? 1 : 0, fileWallpaper3);
                }
            }
        } else if (obj == null && this.selectedColor != 0 && "c".equals(this.selectedBackgroundSlug)) {
            int i9 = this.selectedGradientColor1;
            if (i9 != 0 && (i3 = this.selectedGradientColor2) != 0 && (i4 = this.selectedGradientColor3) != 0) {
                ColorWallpaper colorWallpaper4 = new ColorWallpaper(this.selectedBackgroundSlug, this.selectedColor, i9, i3, i4);
                this.addedColorWallpaper = colorWallpaper4;
                colorWallpaper4.gradientRotation = this.selectedGradientRotation;
            } else {
                this.addedColorWallpaper = new ColorWallpaper(this.selectedBackgroundSlug, this.selectedColor, i9, this.selectedGradientRotation);
            }
            this.wallPapers.add(0, this.addedColorWallpaper);
        }
        if (!"d".equals(this.selectedBackgroundSlug)) {
            this.wallPapers.isEmpty();
        }
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fillWallpapersWithCustom$6(String str, long j, boolean z, Object obj, Object obj2) {
        if (obj instanceof ColorWallpaper) {
            obj = ((ColorWallpaper) obj).parentWallpaper;
        }
        if (obj2 instanceof ColorWallpaper) {
            obj2 = ((ColorWallpaper) obj2).parentWallpaper;
        }
        if (!(obj instanceof TLRPC$WallPaper) || !(obj2 instanceof TLRPC$WallPaper)) {
            return 0;
        }
        TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) obj;
        TLRPC$WallPaper tLRPC$WallPaper2 = (TLRPC$WallPaper) obj2;
        if (str == null) {
            return 0;
        }
        if (j != 0) {
            if (tLRPC$WallPaper.id == j) {
                return -1;
            }
            if (tLRPC$WallPaper2.id == j) {
                return 1;
            }
        } else {
            if (str.equals(tLRPC$WallPaper.slug)) {
                return -1;
            }
            if (str.equals(tLRPC$WallPaper2.slug)) {
                return 1;
            }
        }
        if (!z) {
            if ("qeZWES8rGVIEAAAARfWlK1lnfiI".equals(tLRPC$WallPaper.slug)) {
                return -1;
            }
            if ("qeZWES8rGVIEAAAARfWlK1lnfiI".equals(tLRPC$WallPaper2.slug)) {
                return 1;
            }
        }
        int iIndexOf = this.allWallPapers.indexOf(tLRPC$WallPaper);
        int iIndexOf2 = this.allWallPapers.indexOf(tLRPC$WallPaper2);
        boolean z2 = tLRPC$WallPaper.dark;
        if (!(z2 && tLRPC$WallPaper2.dark) && (z2 || tLRPC$WallPaper2.dark)) {
            return (!z2 || tLRPC$WallPaper2.dark) ? z ? 1 : -1 : z ? -1 : 1;
        }
        if (iIndexOf > iIndexOf2) {
            return 1;
        }
        return iIndexOf < iIndexOf2 ? -1 : 0;
    }

    private void updateRows() {
        this.rowCount = 0;
        if (this.currentType == 0) {
            int i = 0 + 1;
            this.rowCount = i;
            this.uploadImageRow = 0;
            int i2 = i + 1;
            this.rowCount = i2;
            this.setColorRow = i;
            this.rowCount = i2 + 1;
            this.sectionRow = i2;
        } else {
            this.uploadImageRow = -1;
            this.setColorRow = -1;
            this.sectionRow = -1;
        }
        if (!this.wallPapers.isEmpty()) {
            int iCeil = (int) Math.ceil(this.wallPapers.size() / this.columnsCount);
            this.totalWallpaperRows = iCeil;
            int i3 = this.rowCount;
            this.wallPaperStartRow = i3;
            this.rowCount = i3 + iCeil;
        } else {
            this.wallPaperStartRow = -1;
        }
        if (this.currentType == 0) {
            int i4 = this.rowCount;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.resetSectionRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.resetRow = i5;
            this.rowCount = i6 + 1;
            this.resetInfoRow = i6;
        } else {
            this.resetSectionRow = -1;
            this.resetRow = -1;
            this.resetInfoRow = -1;
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            this.scrolling = true;
            listAdapter.notifyDataSetChanged();
        }
    }

    private void fixLayout() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.WallpapersListActivity.9
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    WallpapersListActivity.this.fixLayoutInternal();
                    if (WallpapersListActivity.this.listView == null) {
                        return true;
                    }
                    WallpapersListActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        if (getParentActivity() == null) {
            return;
        }
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (AndroidUtilities.isTablet()) {
            this.columnsCount = 3;
        } else if (rotation == 3 || rotation == 1) {
            this.columnsCount = 5;
        } else {
            this.columnsCount = 3;
        }
        updateRows();
    }

    private class ColorCell extends View {
        private int color;

        public ColorCell(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(AndroidUtilities.dp(50.0f), AndroidUtilities.dp(62.0f));
        }

        public void setColor(int i) {
            this.color = i;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            WallpapersListActivity.this.colorPaint.setColor(this.color);
            canvas.drawCircle(AndroidUtilities.dp(25.0f), AndroidUtilities.dp(31.0f), AndroidUtilities.dp(18.0f), WallpapersListActivity.this.colorPaint);
            if (this.color == Theme.getColor(Theme.key_windowBackgroundWhite)) {
                canvas.drawCircle(AndroidUtilities.dp(25.0f), AndroidUtilities.dp(31.0f), AndroidUtilities.dp(18.0f), WallpapersListActivity.this.colorFramePaint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int imageReqId;
        private String lastSearchImageString;
        private String lastSearchString;
        private int lastSearchToken;
        private Context mContext;
        private String nextImagesSearchOffset;
        private Runnable searchRunnable;
        private boolean searchingUser;
        private String selectedColor;
        private ArrayList<MediaController.SearchImage> searchResult = new ArrayList<>();
        private HashMap<String, MediaController.SearchImage> searchResultKeys = new HashMap<>();
        private boolean bingSearchEndReached = true;

        private class CategoryAdapterRecycler extends RecyclerListView.SelectionAdapter {
            @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
                return true;
            }

            private CategoryAdapterRecycler() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                SearchAdapter searchAdapter = SearchAdapter.this;
                return new RecyclerListView.Holder(WallpapersListActivity.this.new ColorCell(searchAdapter.mContext));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
                ((ColorCell) viewHolder.itemView).setColor(WallpapersListActivity.searchColors[i]);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return WallpapersListActivity.searchColors.length;
            }
        }

        public SearchAdapter(Context context) {
            this.mContext = context;
        }

        public void onDestroy() {
            if (this.imageReqId != 0) {
                ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).cancelRequest(this.imageReqId, true);
                this.imageReqId = 0;
            }
        }

        public void clearColor() {
            this.selectedColor = null;
            processSearch(null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processSearch(final String str, boolean z) {
            if (str != null && this.selectedColor != null) {
                str = "#color" + this.selectedColor + " " + str;
            }
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (!TextUtils.isEmpty(str)) {
                WallpapersListActivity.this.searchEmptyView.showProgress();
                if (z) {
                    doSearch(str);
                } else {
                    Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$processSearch$0(str);
                        }
                    };
                    this.searchRunnable = runnable2;
                    AndroidUtilities.runOnUIThread(runnable2, 500L);
                }
            } else {
                this.searchResult.clear();
                this.searchResultKeys.clear();
                this.bingSearchEndReached = true;
                this.lastSearchString = null;
                if (this.imageReqId != 0) {
                    ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).cancelRequest(this.imageReqId, true);
                    this.imageReqId = 0;
                }
                WallpapersListActivity.this.searchEmptyView.showTextView();
            }
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processSearch$0(String str) {
            doSearch(str);
            this.searchRunnable = null;
        }

        private void doSearch(String str) {
            this.searchResult.clear();
            this.searchResultKeys.clear();
            this.bingSearchEndReached = true;
            searchImages(str, BuildConfig.FLAVOR, true);
            this.lastSearchString = str;
            notifyDataSetChanged();
        }

        private void searchBotUser() {
            if (this.searchingUser) {
                return;
            }
            this.searchingUser = true;
            TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
            tLRPC$TL_contacts_resolveUsername.username = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).imageSearchBot;
            ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchBotUser$2(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchBotUser$2(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchBotUser$1(tLObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchBotUser$1(TLObject tLObject) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
            WallpapersListActivity.this.getMessagesStorage().putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
            String str = this.lastSearchImageString;
            this.lastSearchImageString = null;
            searchImages(str, BuildConfig.FLAVOR, false);
        }

        public void loadMoreResults() {
            if (this.bingSearchEndReached || this.imageReqId != 0) {
                return;
            }
            searchImages(this.lastSearchString, this.nextImagesSearchOffset, true);
        }

        private void searchImages(String str, String str2, boolean z) {
            if (this.imageReqId != 0) {
                ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).cancelRequest(this.imageReqId, true);
                this.imageReqId = 0;
            }
            this.lastSearchImageString = str;
            TLObject userOrChat = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).getUserOrChat(MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).imageSearchBot);
            if (!(userOrChat instanceof TLRPC$User)) {
                if (z) {
                    searchBotUser();
                    return;
                }
                return;
            }
            TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
            tLRPC$TL_messages_getInlineBotResults.query = "#wallpaper " + str;
            tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).getInputUser((TLRPC$User) userOrChat);
            tLRPC$TL_messages_getInlineBotResults.offset = str2;
            tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
            final int i = this.lastSearchToken + 1;
            this.lastSearchToken = i;
            this.imageReqId = ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, new RequestDelegate() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchImages$4(i, tLObject, tLRPC$TL_error);
                }
            });
            ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).bindRequestToGuid(this.imageReqId, ((BaseFragment) WallpapersListActivity.this).classGuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchImages$4(final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchImages$3(i, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchImages$3(int i, TLObject tLObject) {
            if (i != this.lastSearchToken) {
                return;
            }
            this.imageReqId = 0;
            int size = this.searchResult.size();
            if (tLObject != null) {
                TLRPC$messages_BotResults tLRPC$messages_BotResults = (TLRPC$messages_BotResults) tLObject;
                this.nextImagesSearchOffset = tLRPC$messages_BotResults.next_offset;
                int size2 = tLRPC$messages_BotResults.results.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = tLRPC$messages_BotResults.results.get(i2);
                    if ("photo".equals(tLRPC$BotInlineResult.type) && !this.searchResultKeys.containsKey(tLRPC$BotInlineResult.id)) {
                        MediaController.SearchImage searchImage = new MediaController.SearchImage();
                        TLRPC$Photo tLRPC$Photo = tLRPC$BotInlineResult.photo;
                        if (tLRPC$Photo != null) {
                            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, AndroidUtilities.getPhotoSize());
                            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$BotInlineResult.photo.sizes, 320);
                            if (closestPhotoSizeWithSize != null) {
                                searchImage.width = closestPhotoSizeWithSize.w;
                                searchImage.height = closestPhotoSizeWithSize.h;
                                searchImage.photoSize = closestPhotoSizeWithSize;
                                searchImage.photo = tLRPC$BotInlineResult.photo;
                                searchImage.size = closestPhotoSizeWithSize.size;
                                searchImage.thumbPhotoSize = closestPhotoSizeWithSize2;
                                searchImage.id = tLRPC$BotInlineResult.id;
                                searchImage.type = 0;
                                this.searchResult.add(searchImage);
                                this.searchResultKeys.put(searchImage.id, searchImage);
                            }
                        } else if (tLRPC$BotInlineResult.content != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= tLRPC$BotInlineResult.content.attributes.size()) {
                                    break;
                                }
                                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$BotInlineResult.content.attributes.get(i3);
                                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                                    searchImage.width = tLRPC$DocumentAttribute.w;
                                    searchImage.height = tLRPC$DocumentAttribute.h;
                                    break;
                                }
                                i3++;
                            }
                            TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.thumb;
                            if (tLRPC$WebDocument != null) {
                                searchImage.thumbUrl = tLRPC$WebDocument.url;
                            } else {
                                searchImage.thumbUrl = null;
                            }
                            TLRPC$WebDocument tLRPC$WebDocument2 = tLRPC$BotInlineResult.content;
                            searchImage.imageUrl = tLRPC$WebDocument2.url;
                            searchImage.size = tLRPC$WebDocument2.size;
                            searchImage.id = tLRPC$BotInlineResult.id;
                            searchImage.type = 0;
                            this.searchResult.add(searchImage);
                            this.searchResultKeys.put(searchImage.id, searchImage);
                        }
                    }
                }
                this.bingSearchEndReached = size == this.searchResult.size() || this.nextImagesSearchOffset == null;
            }
            if (size != this.searchResult.size()) {
                int i4 = size % WallpapersListActivity.this.columnsCount;
                float f = size;
                int iCeil = (int) Math.ceil(f / WallpapersListActivity.this.columnsCount);
                if (i4 != 0) {
                    notifyItemChanged(((int) Math.ceil(f / WallpapersListActivity.this.columnsCount)) - 1);
                }
                WallpapersListActivity.this.searchAdapter.notifyItemRangeInserted(iCeil, ((int) Math.ceil(this.searchResult.size() / WallpapersListActivity.this.columnsCount)) - iCeil);
            }
            WallpapersListActivity.this.searchEmptyView.showTextView();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (TextUtils.isEmpty(this.lastSearchString)) {
                return 2;
            }
            return (int) Math.ceil(this.searchResult.size() / WallpapersListActivity.this.columnsCount);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$5(View view, int i) {
            String string = LocaleController.getString("BackgroundSearchColor", R.string.BackgroundSearchColor);
            SpannableString spannableString = new SpannableString(string + " " + LocaleController.getString(WallpapersListActivity.searchColorsNames[i], WallpapersListActivity.searchColorsNamesR[i]));
            spannableString.setSpan(new ForegroundColorSpan(Theme.getColor(Theme.key_actionBarDefaultSubtitle)), string.length(), spannableString.length(), 33);
            WallpapersListActivity.this.searchItem.setSearchFieldCaption(spannableString);
            WallpapersListActivity.this.searchItem.setSearchFieldHint(null);
            WallpapersListActivity.this.searchItem.setSearchFieldText(BuildConfig.FLAVOR, true);
            this.selectedColor = WallpapersListActivity.searchColorsNames[i];
            processSearch(BuildConfig.FLAVOR, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View graySectionCell = null;
            Object[] objArr = 0;
            if (i == 0) {
                graySectionCell = new WallpaperCell(this.mContext) { // from class: org.rbmain.ui.WallpapersListActivity.SearchAdapter.1
                    @Override // org.rbmain.ui.Cells.WallpaperCell
                    protected void onWallpaperClick(Object obj, int i2) {
                        WallpapersListActivity.this.presentFragment(new ThemePreviewActivity(obj, null, true, false));
                    }
                };
            } else if (i == 1) {
                RecyclerListView recyclerListView = new RecyclerListView(this, this.mContext) { // from class: org.rbmain.ui.WallpapersListActivity.SearchAdapter.2
                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                        if (getParent() != null && getParent().getParent() != null) {
                            getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                        }
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                };
                recyclerListView.setItemAnimator(null);
                recyclerListView.setLayoutAnimation(null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, this.mContext) { // from class: org.rbmain.ui.WallpapersListActivity.SearchAdapter.3
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean supportsPredictiveItemAnimations() {
                        return false;
                    }
                };
                recyclerListView.setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
                recyclerListView.setClipToPadding(false);
                linearLayoutManager.setOrientation(0);
                recyclerListView.setLayoutManager(linearLayoutManager);
                recyclerListView.setAdapter(new CategoryAdapterRecycler());
                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.WallpapersListActivity$SearchAdapter$$ExternalSyntheticLambda5
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view, int i2) {
                        this.f$0.lambda$onCreateViewHolder$5(view, i2);
                    }
                });
                graySectionCell = recyclerListView;
            } else if (i == 2) {
                graySectionCell = new GraySectionCell(this.mContext);
            }
            if (i == 1) {
                graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(60.0f)));
            } else {
                graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 2) {
                    return;
                }
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.getString("SearchByColor", R.string.SearchByColor));
                return;
            }
            WallpaperCell wallpaperCell = (WallpaperCell) viewHolder.itemView;
            int i2 = i * WallpapersListActivity.this.columnsCount;
            wallpaperCell.setParams(WallpapersListActivity.this.columnsCount, i2 == 0, i2 / WallpapersListActivity.this.columnsCount == ((int) Math.ceil((double) (((float) this.searchResult.size()) / ((float) WallpapersListActivity.this.columnsCount)))) - 1);
            for (int i3 = 0; i3 < WallpapersListActivity.this.columnsCount; i3++) {
                int i4 = i2 + i3;
                wallpaperCell.setWallpaper(WallpapersListActivity.this.currentType, i3, i4 < this.searchResult.size() ? this.searchResult.get(i4) : null, BuildConfig.FLAVOR, null, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (TextUtils.isEmpty(this.lastSearchString)) {
                return i == 0 ? 2 : 1;
            }
            return 0;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return WallpapersListActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textCell;
            View shadowSectionCell;
            if (i != 0) {
                int i2 = R.drawable.greydivider_bottom;
                if (i == 1) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    Context context = this.mContext;
                    if (WallpapersListActivity.this.wallPaperStartRow != -1) {
                        i2 = R.drawable.greydivider;
                    }
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawableByKey(context, i2, Theme.key_windowBackgroundGrayShadow));
                    combinedDrawable.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                } else if (i == 3) {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                    CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawableByKey(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    combinedDrawable2.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable2);
                } else {
                    textCell = new WallpaperCell(this.mContext) { // from class: org.rbmain.ui.WallpapersListActivity.ListAdapter.1
                        @Override // org.rbmain.ui.Cells.WallpaperCell
                        protected boolean onWallpaperLongClick(Object obj, int i3) {
                            return true;
                        }

                        @Override // org.rbmain.ui.Cells.WallpaperCell
                        protected void onWallpaperClick(Object obj, int i3) {
                            WallpapersListActivity.this.onItemClick(this, obj, i3);
                        }
                    };
                }
                textCell = shadowSectionCell;
            } else {
                textCell = new TextCell(this.mContext);
            }
            return new RecyclerListView.Holder(textCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextCell textCell = (TextCell) viewHolder.itemView;
                if (i != WallpapersListActivity.this.uploadImageRow) {
                    if (i != WallpapersListActivity.this.setColorRow) {
                        if (i == WallpapersListActivity.this.resetRow) {
                            textCell.setText(LocaleController.getString("ResetChatBackgrounds", R.string.ResetChatBackgrounds), false);
                            return;
                        }
                        return;
                    }
                    textCell.setTextAndIcon(LocaleController.getString("SetColor", R.string.SetColor), R.drawable.msg_palette, true);
                    return;
                }
                textCell.setTextAndIcon(LocaleController.getString("SelectFromGallery", R.string.SelectFromGallery), R.drawable.msg_photos, true);
                return;
            }
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    return;
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == WallpapersListActivity.this.resetInfoRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("ResetChatBackgroundsInfo", R.string.ResetChatBackgroundsInfo));
                    return;
                }
                return;
            }
            WallpaperCell wallpaperCell = (WallpaperCell) viewHolder.itemView;
            int i2 = (i - WallpapersListActivity.this.wallPaperStartRow) * WallpapersListActivity.this.columnsCount;
            wallpaperCell.setParams(WallpapersListActivity.this.columnsCount, i2 == 0, i2 / WallpapersListActivity.this.columnsCount == WallpapersListActivity.this.totalWallpaperRows - 1);
            for (int i3 = 0; i3 < WallpapersListActivity.this.columnsCount; i3++) {
                int i4 = i2 + i3;
                Object obj = null;
                Object obj2 = i4 < WallpapersListActivity.this.wallPapers.size() ? WallpapersListActivity.this.wallPapers.get(i4) : null;
                long j = 0;
                if (obj2 instanceof TLRPC$TL_wallPaper) {
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj2;
                    Theme.OverrideWallpaperInfo overrideWallpaperInfo = Theme.getActiveTheme().overrideWallpaper;
                    if (WallpapersListActivity.this.selectedBackgroundSlug != null && WallpapersListActivity.this.selectedBackgroundSlug.equals(tLRPC$TL_wallPaper.slug) && (!WallpapersListActivity.this.selectedBackgroundSlug.equals(tLRPC$TL_wallPaper.slug) || tLRPC$TL_wallPaper.settings == null || (WallpapersListActivity.this.selectedColor == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.background_color) && WallpapersListActivity.this.selectedGradientColor1 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.second_background_color) && WallpapersListActivity.this.selectedGradientColor2 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.third_background_color) && WallpapersListActivity.this.selectedGradientColor3 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.fourth_background_color) && (WallpapersListActivity.this.selectedGradientColor1 == 0 || WallpapersListActivity.this.selectedGradientColor2 != 0 || WallpapersListActivity.this.selectedGradientRotation == AndroidUtilities.getWallpaperRotation(tLRPC$TL_wallPaper.settings.rotation, false) || !tLRPC$TL_wallPaper.pattern || Math.abs(Theme.getThemeIntensity(tLRPC$TL_wallPaper.settings.intensity / 100.0f) - WallpapersListActivity.this.selectedIntensity) <= 0.001f)))) {
                        obj = tLRPC$TL_wallPaper;
                    }
                    j = tLRPC$TL_wallPaper.id;
                } else if (obj2 instanceof ColorWallpaper) {
                    ColorWallpaper colorWallpaper = (ColorWallpaper) obj2;
                    if (("d".equals(colorWallpaper.slug) && WallpapersListActivity.this.selectedBackgroundSlug != null && WallpapersListActivity.this.selectedBackgroundSlug.equals(colorWallpaper.slug)) || (colorWallpaper.color == WallpapersListActivity.this.selectedColor && colorWallpaper.gradientColor1 == WallpapersListActivity.this.selectedGradientColor1 && colorWallpaper.gradientColor2 == WallpapersListActivity.this.selectedGradientColor2 && colorWallpaper.gradientColor3 == WallpapersListActivity.this.selectedGradientColor3 && ((WallpapersListActivity.this.selectedGradientColor1 == 0 || colorWallpaper.gradientRotation == WallpapersListActivity.this.selectedGradientRotation) && ((!"c".equals(WallpapersListActivity.this.selectedBackgroundSlug) || colorWallpaper.slug == null) && ("c".equals(WallpapersListActivity.this.selectedBackgroundSlug) || (TextUtils.equals(WallpapersListActivity.this.selectedBackgroundSlug, colorWallpaper.slug) && ((int) (colorWallpaper.intensity * 100.0f)) == ((int) (WallpapersListActivity.this.selectedIntensity * 100.0f)))))))) {
                        obj = obj2;
                    }
                    TLRPC$WallPaper tLRPC$WallPaper = colorWallpaper.parentWallpaper;
                    if (tLRPC$WallPaper != null) {
                        j = tLRPC$WallPaper.id;
                    }
                } else if ((obj2 instanceof FileWallpaper) && WallpapersListActivity.this.selectedBackgroundSlug.equals(((FileWallpaper) obj2).slug)) {
                    obj = obj2;
                }
                long j2 = j;
                wallpaperCell.setWallpaper(WallpapersListActivity.this.currentType, i3, obj2, obj, null, false);
                if (((BaseFragment) WallpapersListActivity.this).actionBar.isActionModeShowed()) {
                    wallpaperCell.setChecked(i3, WallpapersListActivity.this.selectedWallPapers.indexOfKey(j2) >= 0, !WallpapersListActivity.this.scrolling);
                } else {
                    wallpaperCell.setChecked(i3, false, !WallpapersListActivity.this.scrolling);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == WallpapersListActivity.this.uploadImageRow || i == WallpapersListActivity.this.setColorRow || i == WallpapersListActivity.this.resetRow) {
                return 0;
            }
            if (i == WallpapersListActivity.this.sectionRow || i == WallpapersListActivity.this.resetSectionRow) {
                return 1;
            }
            return i == WallpapersListActivity.this.resetInfoRow ? 3 : 2;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        View view = this.fragmentView;
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(view, 0, null, null, null, null, i));
        View view2 = this.fragmentView;
        int i2 = Theme.key_windowBackgroundGray;
        arrayList.add(new ThemeDescription(view2, 0, null, null, null, null, i2));
        ActionBar actionBar = this.actionBar;
        int i3 = ThemeDescription.FLAG_BACKGROUND;
        int i4 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        int i5 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_emptyListPlaceholder));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i));
        return arrayList;
    }
}
