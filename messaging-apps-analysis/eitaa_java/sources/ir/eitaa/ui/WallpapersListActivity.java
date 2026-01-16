package ir.eitaa.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_account_saveWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolveUsername;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaperNoFile;
import ir.eitaa.tgnet.TLRPC$TL_messages_getInlineBotResults;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$TL_wallPaperNoFile;
import ir.eitaa.tgnet.TLRPC$TL_wallPaperSettings;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$messages_BotResults;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.WallpaperCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberTextView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.WallpaperUpdater;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.ThemePreviewActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class WallpapersListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ColorWallpaper addedColorWallpaper;
    private FileWallpaper addedFileWallpaper;
    private ColorWallpaper catsWallpaper;
    private Paint colorFramePaint;
    private Paint colorPaint;
    private int currentType;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private AlertDialog progressDialog;
    private int rowCount;
    private boolean scrolling;
    private SearchAdapter searchAdapter;
    private EmptyTextProgressView searchEmptyView;
    private ActionBarMenuItem searchItem;
    private int sectionRow;
    private boolean selectedBackgroundBlurred;
    private boolean selectedBackgroundMotion;
    private int selectedColor;
    private int selectedGradientColor1;
    private int selectedGradientColor2;
    private int selectedGradientColor3;
    private int selectedGradientRotation;
    private float selectedIntensity;
    private NumberTextView selectedMessagesCountTextView;
    private int setColorRow;
    private FileWallpaper themeWallpaper;
    private int totalWallpaperRows;
    private WallpaperUpdater updater;
    private int uploadImageRow;
    private int wallPaperStartRow;
    private static final int[][] defaultColorsLight = {new int[]{-2368069, -9722489, -2762611, -7817084}, new int[]{-7487253, -4599318, -3755537, -1320977}, new int[]{-6832405, -5117462, -3755537, -1067044}, new int[]{-7676942, -7827988, -1859606, -9986835}, new int[]{-5190165, -6311702, -4461867, -5053475}, new int[]{-2430264, -6114049, -1258497, -4594945}, new int[]{-2298990, -7347754, -9985038, -8006011}, new int[]{-1399954, -990074, -876865, -1523602}, new int[]{-15438, -1916673, -6222, -471346}, new int[]{-2891798}, new int[]{-5913125}, new int[]{-9463352}, new int[]{-2956375}, new int[]{-5974898}, new int[]{-8537234}, new int[]{-1647186}, new int[]{-2769263}, new int[]{-3431303}, new int[]{-1326919}, new int[]{-2054243}, new int[]{-3573648}, new int[]{-1328696}, new int[]{-2056777}, new int[]{-2984557}, new int[]{-2440467}, new int[]{-2906649}, new int[]{-4880430}, new int[]{-4013331}, new int[]{-5921305}, new int[]{-8421424}, new int[]{-4005139}, new int[]{-5908761}, new int[]{-8406320}, new int[]{-2702663}, new int[]{-6518654}, new int[]{-16777216}};
    private static final int[][] defaultColorsDark = {new int[]{-14797481, -15394250, -14924974, -14006975}, new int[]{-14867905, -14870478, -14997181, -15460815}, new int[]{-14666695, -15720408, -14861254, -15260107}, new int[]{-14932175, -15066075, -14208965, -15000799}, new int[]{-12968902, -14411460, -13029826, -15067598}, new int[]{-13885157, -12307670, -14542561, -12899018}, new int[]{-14797481, -15196106, -14924974, -15325638}, new int[]{-15658442, -15449521, -16047308, -12897955}, new int[]{-13809610, -15258855, -13221071, -15715791}, new int[]{-14865092}, new int[]{-15656154}, new int[]{-16051170}, new int[]{-14731745}, new int[]{-15524075}, new int[]{-15853808}, new int[]{-13685209}, new int[]{-14014945}, new int[]{-15132649}, new int[]{-12374480}, new int[]{-13755362}, new int[]{-14740716}, new int[]{-12374468}, new int[]{-13755352}, new int[]{-14740709}, new int[]{-12833213}, new int[]{-14083026}, new int[]{-14872031}, new int[]{-13554109}, new int[]{-14803922}, new int[]{-15461855}, new int[]{-13680833}, new int[]{-14602960}, new int[]{-15458784}, new int[]{-14211804}, new int[]{-15132906}, new int[]{-16777216}};
    private static final int[] searchColors = {-16746753, -65536, -30208, -13824, -16718798, -14702165, -9240406, -409915, -9224159, -16777216, -10725281, -1};
    private static final String[] searchColorsNames = {"Blue", "Red", "Orange", "Yellow", "Green", "Teal", "Purple", "Pink", "Brown", "Black", "Gray", "White"};
    private static final int[] searchColorsNamesR = {R.string.Blue, R.string.Red, R.string.Orange, R.string.Yellow, R.string.Green, R.string.Teal, R.string.Purple, R.string.Pink, R.string.Brown, R.string.Black, R.string.Gray, R.string.White};
    private ArrayList<View> actionModeViews = new ArrayList<>();
    private int columnsCount = 3;
    private String selectedBackgroundSlug = "";
    private ArrayList<Object> allWallPapers = new ArrayList<>();
    private HashMap<String, Object> allWallPapersDict = new HashMap<>();
    private HashMap<String, Object> localDict = new HashMap<>();
    private ArrayList<Object> wallPapers = new ArrayList<>();
    private ArrayList<ColorWallpaper> localWallPapers = new ArrayList<>();
    private ArrayList<Object> patterns = new ArrayList<>();
    private HashMap<Long, Object> patternsDict = new HashMap<>();
    private LongSparseArray<Object> selectedWallPapers = new LongSparseArray<>();

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
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
                str = "";
            }
            sb.append(str);
            return Utilities.MD5(sb.toString());
        }

        public ColorWallpaper(String s, int c, int gc, int r) {
            this.slug = s;
            this.color = c | (-16777216);
            int i = gc == 0 ? 0 : (-16777216) | gc;
            this.gradientColor1 = i;
            this.gradientRotation = i == 0 ? 0 : r;
            this.intensity = 1.0f;
        }

        public ColorWallpaper(String s, int c, int gc1, int gc2, int gc3) {
            this.slug = s;
            this.color = c | (-16777216);
            this.gradientColor1 = gc1 == 0 ? 0 : gc1 | (-16777216);
            this.gradientColor2 = gc2 == 0 ? 0 : gc2 | (-16777216);
            this.gradientColor3 = gc3 != 0 ? gc3 | (-16777216) : 0;
            this.intensity = 1.0f;
            this.isGradient = true;
        }

        public ColorWallpaper(String s, int c, int gc1, int gc2, int gc3, int r, float in, boolean m, File ph) {
            this.slug = s;
            this.color = c | (-16777216);
            int i = gc1 == 0 ? 0 : gc1 | (-16777216);
            this.gradientColor1 = i;
            this.gradientColor2 = gc2 == 0 ? 0 : gc2 | (-16777216);
            this.gradientColor3 = gc3 != 0 ? gc3 | (-16777216) : 0;
            this.gradientRotation = i == 0 ? 45 : r;
            this.intensity = in;
            this.path = ph;
            this.motion = m;
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

        public FileWallpaper(String s, File f, File of) {
            this.slug = s;
            this.path = f;
            this.originalPath = of;
        }

        public FileWallpaper(String s, int r, int t) {
            this.slug = s;
            this.resId = r;
            this.thumbResId = t;
        }
    }

    public WallpapersListActivity(int type) {
        this.currentType = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        if (this.currentType == 0) {
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersDidLoad);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersNeedReload);
            getMessagesStorage().getWallpapers();
        } else {
            int[][] iArr = Theme.isCurrentThemeDark() ? defaultColorsDark : defaultColorsLight;
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i].length == 1) {
                    this.wallPapers.add(new ColorWallpaper("c", iArr[i][0], 0, 45));
                } else {
                    this.wallPapers.add(new ColorWallpaper("c", iArr[i][0], iArr[i][1], iArr[i][2], iArr[i][3]));
                }
            }
            if (this.currentType == 1 && this.patterns.isEmpty()) {
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersDidLoad);
                getMessagesStorage().getWallpapers();
            }
        }
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        int i = 1;
        this.colorPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.colorFramePaint = paint;
        paint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        this.colorFramePaint.setStyle(Paint.Style.STROKE);
        this.colorFramePaint.setColor(855638016);
        this.updater = new WallpaperUpdater(getParentActivity(), this, new WallpaperUpdater.WallpaperUpdaterDelegate() { // from class: ir.eitaa.ui.WallpapersListActivity.1
            @Override // ir.eitaa.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
            public void needOpenColorPicker() {
            }

            @Override // ir.eitaa.ui.Components.WallpaperUpdater.WallpaperUpdaterDelegate
            public void didSelectWallpaper(File file, Bitmap bitmap, boolean gallery) {
                WallpapersListActivity.this.presentFragment(new ThemePreviewActivity(new FileWallpaper("", file, file), bitmap), gallery);
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
            this.actionBar.createMenu();
            ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode(false, null);
            actionBarMenuCreateActionMode.setBackgroundColor(Theme.getColor("actionBarDefault"));
            this.actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), true);
            this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultSelector"), true);
            NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
            this.selectedMessagesCountTextView = numberTextView;
            numberTextView.setTextSize(18);
            this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.selectedMessagesCountTextView.setTextColor(Theme.getColor("actionBarDefaultIcon"));
            this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$YJIgSgcV_OVukWJnI047JlbxNnI
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
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.WallpapersListActivity.3
            private Paint paint = new Paint();

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
            public void onDraw(Canvas c) {
                int measuredHeight = getMeasuredHeight();
                this.paint.setColor(Theme.getColor("windowBackgroundWhite"));
                float f = measuredHeight;
                c.drawRect(0.0f, 0.0f, getMeasuredWidth(), f, this.paint);
                if (measuredHeight != measuredHeight) {
                    this.paint.setColor(Theme.getColor("windowBackgroundGray"));
                    c.drawRect(0.0f, f, getMeasuredWidth(), measuredHeight, this.paint);
                }
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, i, z) { // from class: ir.eitaa.ui.WallpapersListActivity.4
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
        this.listView.setGlowColor(Theme.getColor("avatar_backgroundActionBarBlue"));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$zhUsWNiBiyjtHIerDiyB-znkNSU
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$createView$1$WallpapersListActivity(view, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.WallpapersListActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(WallpapersListActivity.this.getParentActivity().getCurrentFocus());
                }
                WallpapersListActivity.this.scrolling = newState != 0;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
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
        this.searchEmptyView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.listView.setEmptyView(this.searchEmptyView);
        frameLayout2.addView(this.searchEmptyView, LayoutHelper.createFrame(-1, -1.0f));
        updateRows();
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.WallpapersListActivity$2, reason: invalid class name */
    class AnonymousClass2 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass2() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            if (id == -1) {
                if (((BaseFragment) WallpapersListActivity.this).actionBar.isActionModeShowed()) {
                    WallpapersListActivity.this.selectedWallPapers.clear();
                    ((BaseFragment) WallpapersListActivity.this).actionBar.hideActionMode();
                    WallpapersListActivity.this.updateRowsSelection();
                    return;
                }
                WallpapersListActivity.this.finishFragment();
                return;
            }
            if (id != 4) {
                if (id == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("onlySelect", true);
                    bundle.putInt("dialogsType", 3);
                    DialogsActivity dialogsActivity = new DialogsActivity(bundle);
                    dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$2$DqpFfYCJ7PTJ7Yrs4XuOvWt9JYQ
                        @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                        public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                            this.f$0.lambda$onItemClick$3$WallpapersListActivity$2(dialogsActivity2, arrayList, charSequence, z);
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
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$2$Wl9QpiQQ5We8tJ7i-pgB8ZB764U
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onItemClick$2$WallpapersListActivity$2(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            WallpapersListActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$WallpapersListActivity$2(DialogInterface dialogInterface, int i) {
            WallpapersListActivity.this.progressDialog = new AlertDialog(WallpapersListActivity.this.getParentActivity(), 3);
            WallpapersListActivity.this.progressDialog.setCanCacnel(false);
            WallpapersListActivity.this.progressDialog.show();
            new ArrayList();
            final int[] iArr = {0};
            for (int i2 = 0; i2 < WallpapersListActivity.this.selectedWallPapers.size(); i2++) {
                Object objValueAt = WallpapersListActivity.this.selectedWallPapers.valueAt(i2);
                if (objValueAt instanceof ColorWallpaper) {
                    ColorWallpaper colorWallpaper = (ColorWallpaper) objValueAt;
                    TLRPC$WallPaper tLRPC$WallPaper = colorWallpaper.parentWallpaper;
                    if (tLRPC$WallPaper == null || tLRPC$WallPaper.id >= 0) {
                        objValueAt = tLRPC$WallPaper;
                    } else {
                        WallpapersListActivity.this.getMessagesStorage().deleteWallpaper(colorWallpaper.parentWallpaper.id);
                        WallpapersListActivity.this.localWallPapers.remove(colorWallpaper);
                        WallpapersListActivity.this.localDict.remove(colorWallpaper.getHash());
                    }
                }
                if (objValueAt instanceof TLRPC$WallPaper) {
                    iArr[0] = iArr[0] + 1;
                    TLRPC$WallPaper tLRPC$WallPaper2 = (TLRPC$WallPaper) objValueAt;
                    TLRPC$TL_account_saveWallPaper tLRPC$TL_account_saveWallPaper = new TLRPC$TL_account_saveWallPaper();
                    tLRPC$TL_account_saveWallPaper.settings = new TLRPC$TL_wallPaperSettings();
                    tLRPC$TL_account_saveWallPaper.unsave = true;
                    if (objValueAt instanceof TLRPC$TL_wallPaperNoFile) {
                        TLRPC$TL_inputWallPaperNoFile tLRPC$TL_inputWallPaperNoFile = new TLRPC$TL_inputWallPaperNoFile();
                        tLRPC$TL_inputWallPaperNoFile.id = tLRPC$WallPaper2.id;
                        tLRPC$TL_account_saveWallPaper.wallpaper = tLRPC$TL_inputWallPaperNoFile;
                    } else {
                        TLRPC$TL_inputWallPaper tLRPC$TL_inputWallPaper = new TLRPC$TL_inputWallPaper();
                        tLRPC$TL_inputWallPaper.id = tLRPC$WallPaper2.id;
                        tLRPC$TL_inputWallPaper.access_hash = tLRPC$WallPaper2.access_hash;
                        tLRPC$TL_account_saveWallPaper.wallpaper = tLRPC$TL_inputWallPaper;
                    }
                    String str = tLRPC$WallPaper2.slug;
                    if (str != null && str.equals(WallpapersListActivity.this.selectedBackgroundSlug)) {
                        WallpapersListActivity.this.selectedBackgroundSlug = Theme.hasWallpaperFromTheme() ? "t" : "d";
                        Theme.getActiveTheme().setOverrideWallpaper(null);
                        Theme.reloadWallpaper();
                    }
                    ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_account_saveWallPaper, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$2$oWrhSO9d1fs_dJrwHiH9nP8zDvI
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$onItemClick$1$WallpapersListActivity$2(iArr, tLObject, tLRPC$TL_error);
                        }
                    });
                }
            }
            if (iArr[0] == 0) {
                WallpapersListActivity.this.loadWallpapers(true);
            }
            WallpapersListActivity.this.selectedWallPapers.clear();
            ((BaseFragment) WallpapersListActivity.this).actionBar.hideActionMode();
            ((BaseFragment) WallpapersListActivity.this).actionBar.closeSearchField();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$WallpapersListActivity$2(final int[] iArr, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$2$fRBI-6EdQ3ntxGruAWJj4r7ATjs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0$WallpapersListActivity$2(iArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$WallpapersListActivity$2(int[] iArr) {
            iArr[0] = iArr[0] - 1;
            if (iArr[0] == 0) {
                WallpapersListActivity.this.loadWallpapers(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$3$WallpapersListActivity$2(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
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
                        SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(charSequence.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                    }
                    if (!TextUtils.isEmpty(sb)) {
                        SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(sb.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                    }
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
                    bundle.putLong("user_id", jLongValue2);
                } else if (DialogObject.isChatDialog(jLongValue2)) {
                    bundle.putLong("chat_id", -jLongValue2);
                }
                if (!MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).checkCanOpenChat(bundle, dialogsActivity)) {
                    return;
                }
            }
            NotificationCenter.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            WallpapersListActivity.this.presentFragment(new ChatActivity(bundle), true);
            SendMessagesHelper.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendMessage(sb.toString(), jLongValue2, null, null, null, true, null, null, null, true, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$WallpapersListActivity(View view, int i) {
        if (getParentActivity() == null || this.listView.getAdapter() == this.searchAdapter) {
            return;
        }
        if (i == this.uploadImageRow) {
            this.updater.openGallery();
        } else if (i == this.setColorRow) {
            WallpapersListActivity wallpapersListActivity = new WallpapersListActivity(1);
            wallpapersListActivity.patterns = this.patterns;
            presentFragment(wallpapersListActivity);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        MessagesController.getGlobalMainSettings();
        Theme.OverrideWallpaperInfo overrideWallpaperInfo = Theme.getActiveTheme().overrideWallpaper;
        if (overrideWallpaperInfo != null) {
            this.selectedBackgroundSlug = overrideWallpaperInfo.slug;
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
        fillWallpapersWithCustom();
        fixLayout();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        fixLayout();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        this.updater.onActivityResult(requestCode, resultCode, data);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle args) {
        String currentPicturePath = this.updater.getCurrentPicturePath();
        if (currentPicturePath != null) {
            args.putString("path", currentPicturePath);
        }
    }

    public void restoreSelfArgs(Bundle args) {
        this.updater.setCurrentPicturePath(args.getString("path"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(WallpaperCell view, Object object, int index) {
        Object obj = object instanceof ColorWallpaper ? ((ColorWallpaper) object).parentWallpaper : object;
        if (this.actionBar.isActionModeShowed() || getParentActivity() == null || !(obj instanceof TLRPC$WallPaper)) {
            return false;
        }
        AndroidUtilities.hideKeyboard(getParentActivity().getCurrentFocus());
        this.selectedWallPapers.put(((TLRPC$WallPaper) obj).id, object);
        this.selectedMessagesCountTextView.setNumber(1, false);
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.actionModeViews.size(); i++) {
            View view2 = this.actionModeViews.get(i);
            AndroidUtilities.clearDrawableAnimation(view2);
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, 0.1f, 1.0f));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(250L);
        animatorSet.start();
        this.scrolling = false;
        this.actionBar.showActionMode();
        view.setChecked(index, true, true);
        return true;
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
        ThemePreviewActivity themePreviewActivity = new ThemePreviewActivity(obj4, null, true, false);
        if (this.currentType == 1) {
            themePreviewActivity.setDelegate(new ThemePreviewActivity.WallpaperActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$lM5ldKOjJE_LqaXv7vkoRR_p_io
                @Override // ir.eitaa.ui.ThemePreviewActivity.WallpaperActivityDelegate
                public final void didSetNewBackground() {
                    this.f$0.removeSelfFromStack();
                }
            });
        }
        if (this.selectedBackgroundSlug.equals(wallPaperSlug)) {
            themePreviewActivity.setInitialModes(this.selectedBackgroundBlurred, this.selectedBackgroundMotion);
        }
        themePreviewActivity.setPatterns(this.patterns);
        presentFragment(themePreviewActivity);
    }

    private String getWallPaperSlug(Object object) {
        if (object instanceof TLRPC$TL_wallPaper) {
            return ((TLRPC$TL_wallPaper) object).slug;
        }
        if (object instanceof ColorWallpaper) {
            return ((ColorWallpaper) object).slug;
        }
        if (object instanceof FileWallpaper) {
            return ((FileWallpaper) object).slug;
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0123  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.WallpapersListActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWallpapers(boolean force) {
        if (force) {
            return;
        }
        int size = this.allWallPapers.size();
        long jCalcHash = 0;
        for (int i = 0; i < size; i++) {
            Object obj = this.allWallPapers.get(i);
            if (obj instanceof TLRPC$WallPaper) {
                long j = ((TLRPC$WallPaper) obj).id;
                if (j >= 0) {
                    jCalcHash = MediaDataController.calcHash(jCalcHash, j);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [ir.eitaa.ui.WallpapersListActivity$ColorWallpaper] */
    /* JADX WARN: Type inference failed for: r4v9, types: [ir.eitaa.tgnet.TLRPC$TL_wallPaper, ir.eitaa.tgnet.TLRPC$WallPaper] */
    private void fillWallpapersWithCustom() {
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper;
        String str;
        Object obj;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper2;
        long j;
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
        ColorWallpaper colorWallpaper2 = this.catsWallpaper;
        if (colorWallpaper2 == null) {
            ColorWallpaper colorWallpaper3 = new ColorWallpaper("d", -2368069, -9722489, -2762611, -7817084);
            this.catsWallpaper = colorWallpaper3;
            colorWallpaper3.intensity = 0.34f;
        } else {
            this.wallPapers.remove(colorWallpaper2);
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
                str2 = "";
                tLRPC$TL_wallPaper3 = tLRPC$TL_wallPaper4;
                obj2 = null;
            } else {
                str2 = this.selectedBackgroundSlug;
                tLRPC$TL_wallPaper3 = null;
                obj2 = tLRPC$TL_wallPaper;
            }
            tLRPC$TL_wallPaper2 = tLRPC$TL_wallPaper3;
            obj = obj2;
            j = tLRPC$TL_wallPaper4.id;
            str = str2;
        } else {
            str = this.selectedBackgroundSlug;
            obj = tLRPC$TL_wallPaper;
            tLRPC$TL_wallPaper2 = null;
            j = (!(tLRPC$TL_wallPaper instanceof ColorWallpaper) || (tLRPC$WallPaper = tLRPC$TL_wallPaper.parentWallpaper) == null) ? 0L : tLRPC$WallPaper.id;
        }
        try {
            Collections.sort(this.wallPapers, new $$Lambda$WallpapersListActivity$SvRKeaJFIWMUuLpsmH09vjdb1I(this, j, str, Theme.getCurrentTheme().isDark()));
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
        if (TextUtils.isEmpty(this.selectedBackgroundSlug) || (!"d".equals(this.selectedBackgroundSlug) && obj == null)) {
            if (!"c".equals(this.selectedBackgroundSlug) && (i2 = this.selectedColor) != 0) {
                if (activeTheme.overrideWallpaper != null) {
                    ColorWallpaper colorWallpaper4 = new ColorWallpaper(this.selectedBackgroundSlug, i2, this.selectedGradientColor1, this.selectedGradientColor2, this.selectedGradientColor3, this.selectedGradientRotation, this.selectedIntensity, this.selectedBackgroundMotion, new File(ApplicationLoader.getFilesDirFixed(), activeTheme.overrideWallpaper.fileName));
                    this.addedColorWallpaper = colorWallpaper4;
                    colorWallpaper4.pattern = tLRPC$TL_wallPaper2;
                    this.wallPapers.add(0, colorWallpaper4);
                }
            } else {
                int i7 = this.selectedColor;
                if (i7 != 0) {
                    int i8 = this.selectedGradientColor1;
                    if (i8 != 0 && (i = this.selectedGradientColor2) != 0) {
                        ColorWallpaper colorWallpaper5 = new ColorWallpaper(this.selectedBackgroundSlug, i7, i8, i, this.selectedGradientColor3);
                        this.addedColorWallpaper = colorWallpaper5;
                        colorWallpaper5.gradientRotation = this.selectedGradientRotation;
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
                ColorWallpaper colorWallpaper6 = new ColorWallpaper(this.selectedBackgroundSlug, this.selectedColor, i9, i3, i4);
                this.addedColorWallpaper = colorWallpaper6;
                colorWallpaper6.gradientRotation = this.selectedGradientRotation;
            } else {
                this.addedColorWallpaper = new ColorWallpaper(this.selectedBackgroundSlug, this.selectedColor, i9, this.selectedGradientRotation);
            }
            this.wallPapers.add(0, this.addedColorWallpaper);
        }
        if ("d".equals(this.selectedBackgroundSlug) || this.wallPapers.isEmpty()) {
            this.wallPapers.add(0, this.catsWallpaper);
        } else {
            this.wallPapers.add(1, this.catsWallpaper);
        }
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fillWallpapersWithCustom$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$fillWallpapersWithCustom$2$WallpapersListActivity(long j, String str, boolean z, Object obj, Object obj2) {
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
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            this.scrolling = true;
            listAdapter.notifyDataSetChanged();
        }
    }

    private void fixLayout() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.WallpapersListActivity.6
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
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(AndroidUtilities.dp(50.0f), AndroidUtilities.dp(62.0f));
        }

        public void setColor(int value) {
            this.color = value;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            WallpapersListActivity.this.colorPaint.setColor(this.color);
            canvas.drawCircle(AndroidUtilities.dp(25.0f), AndroidUtilities.dp(31.0f), AndroidUtilities.dp(18.0f), WallpapersListActivity.this.colorPaint);
            if (this.color == Theme.getColor("windowBackgroundWhite")) {
                canvas.drawCircle(AndroidUtilities.dp(25.0f), AndroidUtilities.dp(31.0f), AndroidUtilities.dp(18.0f), WallpapersListActivity.this.colorFramePaint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int imageReqId;
        private RecyclerListView innerListView;
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
            @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder holder) {
                return true;
            }

            private CategoryAdapterRecycler() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                SearchAdapter searchAdapter = SearchAdapter.this;
                return new RecyclerListView.Holder(WallpapersListActivity.this.new ColorCell(searchAdapter.mContext));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((ColorCell) holder.itemView).setColor(WallpapersListActivity.searchColors[position]);
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

        private void processSearch(final String text, boolean now) {
            if (text != null && this.selectedColor != null) {
                text = "#color" + this.selectedColor + " " + text;
            }
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (!TextUtils.isEmpty(text)) {
                WallpapersListActivity.this.searchEmptyView.showProgress();
                if (now) {
                    doSearch(text);
                } else {
                    Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$R1OWeDQhX_RJbeBBpK5i-Ip6i9M
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$processSearch$0$WallpapersListActivity$SearchAdapter(text);
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
        /* renamed from: lambda$processSearch$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$0$WallpapersListActivity$SearchAdapter(String str) {
            doSearch(str);
            this.searchRunnable = null;
        }

        private void doSearch(String textFinal) {
            this.searchResult.clear();
            this.searchResultKeys.clear();
            this.bingSearchEndReached = true;
            searchImages(textFinal, "", true);
            this.lastSearchString = textFinal;
            notifyDataSetChanged();
        }

        private void searchBotUser() {
            if (this.searchingUser) {
                return;
            }
            this.searchingUser = true;
            TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
            tLRPC$TL_contacts_resolveUsername.username = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).imageSearchBot;
            ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$W5GKXPL3m3EbGRUQMUnXb3g-y8Q
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchBotUser$2$WallpapersListActivity$SearchAdapter(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchBotUser$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchBotUser$2$WallpapersListActivity$SearchAdapter(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$gPfq0qzhQaGglaR4-sO0FeMvvig
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchBotUser$1$WallpapersListActivity$SearchAdapter(tLObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchBotUser$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchBotUser$1$WallpapersListActivity$SearchAdapter(TLObject tLObject) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).putUsers(tLRPC$TL_contacts_resolvedPeer.users, false);
            MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).putChats(tLRPC$TL_contacts_resolvedPeer.chats, false);
            WallpapersListActivity.this.getMessagesStorage().putUsersAndChats(tLRPC$TL_contacts_resolvedPeer.users, tLRPC$TL_contacts_resolvedPeer.chats, true, true);
            String str = this.lastSearchImageString;
            this.lastSearchImageString = null;
            searchImages(str, "", false);
        }

        public void loadMoreResults() {
            if (this.bingSearchEndReached || this.imageReqId != 0) {
                return;
            }
            searchImages(this.lastSearchString, this.nextImagesSearchOffset, true);
        }

        private void searchImages(final String query, final String offset, boolean searchUser) {
            if (this.imageReqId != 0) {
                ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).cancelRequest(this.imageReqId, true);
                this.imageReqId = 0;
            }
            this.lastSearchImageString = query;
            TLObject userOrChat = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).getUserOrChat(MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).imageSearchBot);
            if (!(userOrChat instanceof TLRPC$User)) {
                if (searchUser) {
                    searchBotUser();
                    return;
                }
                return;
            }
            TLRPC$TL_messages_getInlineBotResults tLRPC$TL_messages_getInlineBotResults = new TLRPC$TL_messages_getInlineBotResults();
            tLRPC$TL_messages_getInlineBotResults.query = "#wallpaper " + query;
            tLRPC$TL_messages_getInlineBotResults.bot = MessagesController.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).getInputUser((TLRPC$User) userOrChat);
            tLRPC$TL_messages_getInlineBotResults.offset = offset;
            tLRPC$TL_messages_getInlineBotResults.peer = new TLRPC$TL_inputPeerEmpty();
            final int i = this.lastSearchToken + 1;
            this.lastSearchToken = i;
            this.imageReqId = ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).sendRequest(tLRPC$TL_messages_getInlineBotResults, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$2znS4jge5zaCMJ4kncxRzBFre24
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchImages$4$WallpapersListActivity$SearchAdapter(i, tLObject, tLRPC$TL_error);
                }
            });
            ConnectionsManager.getInstance(((BaseFragment) WallpapersListActivity.this).currentAccount).bindRequestToGuid(this.imageReqId, ((BaseFragment) WallpapersListActivity.this).classGuid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchImages$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchImages$4$WallpapersListActivity$SearchAdapter(final int i, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$_b7V7_juEg9MAYw0--Lp81LPBGw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchImages$3$WallpapersListActivity$SearchAdapter(i, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchImages$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchImages$3$WallpapersListActivity$SearchAdapter(int i, TLObject tLObject) {
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$5$WallpapersListActivity$SearchAdapter(View view, int i) {
            String string = LocaleController.getString("BackgroundSearchColor", R.string.BackgroundSearchColor);
            SpannableString spannableString = new SpannableString(string + " " + LocaleController.getString(WallpapersListActivity.searchColorsNames[i], WallpapersListActivity.searchColorsNamesR[i]));
            spannableString.setSpan(new ForegroundColorSpan(Theme.getColor("actionBarDefaultSubtitle")), string.length(), spannableString.length(), 33);
            WallpapersListActivity.this.searchItem.setSearchFieldCaption(spannableString);
            WallpapersListActivity.this.searchItem.setSearchFieldHint(null);
            WallpapersListActivity.this.searchItem.setSearchFieldText("", true);
            this.selectedColor = WallpapersListActivity.searchColorsNames[i];
            processSearch("", true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View graySectionCell = null;
            Object[] objArr = 0;
            if (i == 0) {
                graySectionCell = new WallpaperCell(this.mContext) { // from class: ir.eitaa.ui.WallpapersListActivity.SearchAdapter.1
                    @Override // ir.eitaa.ui.Cells.WallpaperCell
                    protected void onWallpaperClick(Object wallPaper, int index) {
                        WallpapersListActivity.this.presentFragment(new ThemePreviewActivity(wallPaper, null, true, false));
                    }
                };
            } else if (i == 1) {
                RecyclerListView recyclerListView = new RecyclerListView(this.mContext) { // from class: ir.eitaa.ui.WallpapersListActivity.SearchAdapter.2
                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent e) {
                        if (getParent() != null && getParent().getParent() != null) {
                            getParent().getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(-1));
                        }
                        return super.onInterceptTouchEvent(e);
                    }
                };
                recyclerListView.setItemAnimator(null);
                recyclerListView.setLayoutAnimation(null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext) { // from class: ir.eitaa.ui.WallpapersListActivity.SearchAdapter.3
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
                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$WallpapersListActivity$SearchAdapter$PdxDyt0IntoVhFiRSgBZ6a01q5I
                    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view, int i2) {
                        this.f$0.lambda$onCreateViewHolder$5$WallpapersListActivity$SearchAdapter(view, i2);
                    }
                });
                this.innerListView = recyclerListView;
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 2) {
                    return;
                }
                ((GraySectionCell) holder.itemView).setText(LocaleController.getString("SearchByColor", R.string.SearchByColor));
                return;
            }
            WallpaperCell wallpaperCell = (WallpaperCell) holder.itemView;
            int i = position * WallpapersListActivity.this.columnsCount;
            wallpaperCell.setParams(WallpapersListActivity.this.columnsCount, i == 0, i / WallpapersListActivity.this.columnsCount == ((int) Math.ceil((double) (((float) this.searchResult.size()) / ((float) WallpapersListActivity.this.columnsCount)))) - 1);
            for (int i2 = 0; i2 < WallpapersListActivity.this.columnsCount; i2++) {
                int i3 = i + i2;
                wallpaperCell.setWallpaper(WallpapersListActivity.this.currentType, i2, i3 < this.searchResult.size() ? this.searchResult.get(i3) : null, "", null, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (TextUtils.isEmpty(this.lastSearchString)) {
                return position == 0 ? 2 : 1;
            }
            return 0;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return WallpapersListActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textCell;
            View shadowSectionCell;
            if (viewType != 0) {
                int i = R.drawable.greydivider_bottom;
                if (viewType == 1) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    Context context = this.mContext;
                    if (WallpapersListActivity.this.wallPaperStartRow != -1) {
                        i = R.drawable.greydivider;
                    }
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(context, i, "windowBackgroundGrayShadow"));
                    combinedDrawable.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable);
                } else if (viewType == 3) {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                    CombinedDrawable combinedDrawable2 = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    combinedDrawable2.setFullsize(true);
                    shadowSectionCell.setBackgroundDrawable(combinedDrawable2);
                } else {
                    textCell = new WallpaperCell(this.mContext) { // from class: ir.eitaa.ui.WallpapersListActivity.ListAdapter.1
                        @Override // ir.eitaa.ui.Cells.WallpaperCell
                        protected void onWallpaperClick(Object wallPaper, int index) {
                            WallpapersListActivity.this.onItemClick(this, wallPaper, index);
                        }

                        @Override // ir.eitaa.ui.Cells.WallpaperCell
                        protected boolean onWallpaperLongClick(Object wallPaper, int index) {
                            return WallpapersListActivity.this.onItemLongClick(this, wallPaper, index);
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                TextCell textCell = (TextCell) holder.itemView;
                if (position != WallpapersListActivity.this.uploadImageRow) {
                    if (position == WallpapersListActivity.this.setColorRow) {
                        textCell.setTextAndIcon(LocaleController.getString("SetColor", R.string.SetColor), R.drawable.menu_palette, true);
                        return;
                    }
                    return;
                }
                textCell.setTextAndIcon(LocaleController.getString("SelectFromGallery", R.string.SelectFromGallery), R.drawable.profile_photos, true);
                return;
            }
            if (itemViewType != 2) {
                return;
            }
            WallpaperCell wallpaperCell = (WallpaperCell) holder.itemView;
            int i = (position - WallpapersListActivity.this.wallPaperStartRow) * WallpapersListActivity.this.columnsCount;
            wallpaperCell.setParams(WallpapersListActivity.this.columnsCount, i == 0, i / WallpapersListActivity.this.columnsCount == WallpapersListActivity.this.totalWallpaperRows - 1);
            for (int i2 = 0; i2 < WallpapersListActivity.this.columnsCount; i2++) {
                int i3 = i + i2;
                Object obj = null;
                Object obj2 = i3 < WallpapersListActivity.this.wallPapers.size() ? WallpapersListActivity.this.wallPapers.get(i3) : null;
                long j = 0;
                if (obj2 instanceof TLRPC$TL_wallPaper) {
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj2;
                    Theme.OverrideWallpaperInfo overrideWallpaperInfo = Theme.getActiveTheme().overrideWallpaper;
                    if (WallpapersListActivity.this.selectedBackgroundSlug.equals(tLRPC$TL_wallPaper.slug) && (!WallpapersListActivity.this.selectedBackgroundSlug.equals(tLRPC$TL_wallPaper.slug) || tLRPC$TL_wallPaper.settings == null || (WallpapersListActivity.this.selectedColor == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.background_color) && WallpapersListActivity.this.selectedGradientColor1 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.second_background_color) && WallpapersListActivity.this.selectedGradientColor2 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.third_background_color) && WallpapersListActivity.this.selectedGradientColor3 == Theme.getWallpaperColor(tLRPC$TL_wallPaper.settings.fourth_background_color) && (WallpapersListActivity.this.selectedGradientColor1 == 0 || WallpapersListActivity.this.selectedGradientColor2 != 0 || WallpapersListActivity.this.selectedGradientRotation == AndroidUtilities.getWallpaperRotation(tLRPC$TL_wallPaper.settings.rotation, false) || !tLRPC$TL_wallPaper.pattern || Math.abs(Theme.getThemeIntensity(tLRPC$TL_wallPaper.settings.intensity / 100.0f) - WallpapersListActivity.this.selectedIntensity) <= 0.001f)))) {
                        obj = tLRPC$TL_wallPaper;
                    }
                    j = tLRPC$TL_wallPaper.id;
                } else if (obj2 instanceof ColorWallpaper) {
                    ColorWallpaper colorWallpaper = (ColorWallpaper) obj2;
                    if (("d".equals(colorWallpaper.slug) && WallpapersListActivity.this.selectedBackgroundSlug.equals(colorWallpaper.slug)) || (colorWallpaper.color == WallpapersListActivity.this.selectedColor && colorWallpaper.gradientColor1 == WallpapersListActivity.this.selectedGradientColor1 && colorWallpaper.gradientColor2 == WallpapersListActivity.this.selectedGradientColor2 && colorWallpaper.gradientColor3 == WallpapersListActivity.this.selectedGradientColor3 && ((WallpapersListActivity.this.selectedGradientColor1 == 0 || colorWallpaper.gradientRotation == WallpapersListActivity.this.selectedGradientRotation) && ((!"c".equals(WallpapersListActivity.this.selectedBackgroundSlug) || colorWallpaper.slug == null) && ("c".equals(WallpapersListActivity.this.selectedBackgroundSlug) || (TextUtils.equals(WallpapersListActivity.this.selectedBackgroundSlug, colorWallpaper.slug) && ((int) (colorWallpaper.intensity * 100.0f)) == ((int) (WallpapersListActivity.this.selectedIntensity * 100.0f)))))))) {
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
                wallpaperCell.setWallpaper(WallpapersListActivity.this.currentType, i2, obj2, obj, null, false);
                if (((BaseFragment) WallpapersListActivity.this).actionBar.isActionModeShowed()) {
                    wallpaperCell.setChecked(i2, WallpapersListActivity.this.selectedWallPapers.indexOfKey(j2) >= 0, !WallpapersListActivity.this.scrolling);
                } else {
                    wallpaperCell.setChecked(i2, false, !WallpapersListActivity.this.scrolling);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == WallpapersListActivity.this.uploadImageRow || position == WallpapersListActivity.this.setColorRow) {
                return 0;
            }
            return position == WallpapersListActivity.this.sectionRow ? 1 : 2;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.searchEmptyView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        return arrayList;
    }
}
