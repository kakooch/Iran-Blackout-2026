package ir.eitaa.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.Intro;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$LangPackString;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_langPackString;
import ir.eitaa.tgnet.TLRPC$TL_langpack_getStrings;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BottomPagesView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;
import java.io.IOException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* loaded from: classes3.dex */
public class IntroActivity extends Activity implements NotificationCenter.NotificationCenterDelegate {
    private BottomPagesView bottomPages;
    private long currentDate;
    private int currentViewPagerPage;
    private boolean destroyed;
    private boolean dragging;
    private EGLThread eglThread;
    private FrameLayout frameLayout2;
    private boolean justEndDragging;
    private LocaleController.LocaleInfo localeInfo;
    private String[] messages;
    private int startDragX;
    private TextView startMessagingButton;
    private TextView textView;
    private String[] titles;
    private ViewPager viewPager;
    private int currentAccount = UserConfig.selectedAccount;
    private int lastPage = 0;
    private boolean justCreated = false;
    private boolean startPressed = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        setTheme(R.style.Theme_TMessages);
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        MessagesController.getGlobalMainSettings().edit().putLong("intro_crashed_time", System.currentTimeMillis()).commit();
        this.titles = new String[]{LocaleController.getString("Page1Title", R.string.Page1Title), LocaleController.getString("Page2Title", R.string.Page2Title), LocaleController.getString("Page3Title", R.string.Page3Title), LocaleController.getString("Page5Title", R.string.Page5Title), LocaleController.getString("Page4Title", R.string.Page4Title), LocaleController.getString("Page6Title", R.string.Page6Title)};
        this.messages = new String[]{LocaleController.getString("Page1Message", R.string.Page1Message), LocaleController.getString("Page2Message", R.string.Page2Message), LocaleController.getString("Page3Message", R.string.Page3Message), LocaleController.getString("Page5Message", R.string.Page5Message), LocaleController.getString("Page4Message", R.string.Page4Message), LocaleController.getString("Page6Message", R.string.Page6Message)};
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        FrameLayout frameLayout = new FrameLayout(this) { // from class: ir.eitaa.ui.IntroActivity.1
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                int i = (bottom - top) / 4;
                int i2 = i * 3;
                int iDp = (i2 - AndroidUtilities.dp(275.0f)) / 2;
                IntroActivity.this.frameLayout2.layout(0, iDp, IntroActivity.this.frameLayout2.getMeasuredWidth(), IntroActivity.this.frameLayout2.getMeasuredHeight() + iDp);
                int iDp2 = iDp + AndroidUtilities.dp(272.0f);
                int measuredWidth = (getMeasuredWidth() - IntroActivity.this.bottomPages.getMeasuredWidth()) / 2;
                IntroActivity.this.bottomPages.layout(measuredWidth, iDp2, IntroActivity.this.bottomPages.getMeasuredWidth() + measuredWidth, IntroActivity.this.bottomPages.getMeasuredHeight() + iDp2);
                IntroActivity.this.viewPager.layout(0, 0, IntroActivity.this.viewPager.getMeasuredWidth(), IntroActivity.this.viewPager.getMeasuredHeight());
                int measuredHeight = i2 + ((i - IntroActivity.this.startMessagingButton.getMeasuredHeight()) / 2);
                int measuredWidth2 = (getMeasuredWidth() - IntroActivity.this.startMessagingButton.getMeasuredWidth()) / 2;
                IntroActivity.this.startMessagingButton.layout(measuredWidth2, measuredHeight, IntroActivity.this.startMessagingButton.getMeasuredWidth() + measuredWidth2, IntroActivity.this.startMessagingButton.getMeasuredHeight() + measuredHeight);
                int iDp3 = measuredHeight - AndroidUtilities.dp(30.0f);
                int measuredWidth3 = (getMeasuredWidth() - IntroActivity.this.textView.getMeasuredWidth()) / 2;
                IntroActivity.this.textView.layout(measuredWidth3, iDp3 - IntroActivity.this.textView.getMeasuredHeight(), IntroActivity.this.textView.getMeasuredWidth() + measuredWidth3, iDp3);
            }
        };
        frameLayout.setBackgroundColor(-1);
        scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        FrameLayout frameLayout2 = new FrameLayout(this);
        this.frameLayout2 = frameLayout2;
        frameLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 78.0f, 0.0f, 0.0f));
        TextureView textureView = new TextureView(this);
        this.frameLayout2.addView(textureView, LayoutHelper.createFrame(200, ImageReceiver.DEFAULT_CROSSFADE_DURATION, 17));
        textureView.setSurfaceTextureListener(new AnonymousClass2());
        ViewPager viewPager = new ViewPager(this);
        this.viewPager = viewPager;
        viewPager.setAdapter(new IntroAdapter());
        this.viewPager.setPageMargin(0);
        this.viewPager.setOffscreenPageLimit(1);
        frameLayout.addView(this.viewPager, LayoutHelper.createFrame(-1, -1.0f));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.IntroActivity.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                IntroActivity.this.bottomPages.setPageOffset(position, positionOffset);
                float measuredWidth = IntroActivity.this.viewPager.getMeasuredWidth();
                if (measuredWidth == 0.0f) {
                    return;
                }
                Intro.setScrollOffset((((position * measuredWidth) + positionOffsetPixels) - (IntroActivity.this.currentViewPagerPage * measuredWidth)) / measuredWidth);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IntroActivity.this.currentViewPagerPage = i;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    IntroActivity.this.dragging = true;
                    IntroActivity introActivity = IntroActivity.this;
                    introActivity.startDragX = introActivity.viewPager.getCurrentItem() * IntroActivity.this.viewPager.getMeasuredWidth();
                } else if (i == 0 || i == 2) {
                    if (IntroActivity.this.dragging) {
                        IntroActivity.this.justEndDragging = true;
                        IntroActivity.this.dragging = false;
                    }
                    if (IntroActivity.this.lastPage != IntroActivity.this.viewPager.getCurrentItem()) {
                        IntroActivity introActivity2 = IntroActivity.this;
                        introActivity2.lastPage = introActivity2.viewPager.getCurrentItem();
                    }
                }
            }
        });
        TextView textView = new TextView(this) { // from class: ir.eitaa.ui.IntroActivity.4
            CellFlickerDrawable cellFlickerDrawable;

            @Override // android.widget.TextView, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (this.cellFlickerDrawable == null) {
                    CellFlickerDrawable cellFlickerDrawable = new CellFlickerDrawable();
                    this.cellFlickerDrawable = cellFlickerDrawable;
                    cellFlickerDrawable.drawFrame = false;
                    cellFlickerDrawable.repeatProgress = 2.0f;
                }
                this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                this.cellFlickerDrawable.draw(canvas, rectF, AndroidUtilities.dp(4.0f));
                invalidate();
            }

            @Override // android.widget.TextView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                if (View.MeasureSpec.getSize(widthMeasureSpec) > AndroidUtilities.dp(260.0f)) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(320.0f), 1073741824), heightMeasureSpec);
                } else {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }
        };
        this.startMessagingButton = textView;
        textView.setText(LocaleController.getString("StartMessaging", R.string.StartMessaging));
        this.startMessagingButton.setGravity(17);
        this.startMessagingButton.setTextColor(-1);
        this.startMessagingButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.startMessagingButton.setTextSize(1, 15.0f);
        this.startMessagingButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), -25564, -1674199));
        this.startMessagingButton.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        frameLayout.addView(this.startMessagingButton, LayoutHelper.createFrame(-1, 42.0f, 81, 36.0f, 0.0f, 36.0f, 76.0f));
        this.startMessagingButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$fgq0ZvkLvsfCEc68lPvh9y36_Jc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$IntroActivity(view);
            }
        });
        BottomPagesView bottomPagesView = new BottomPagesView(this, this.viewPager, 6);
        this.bottomPages = bottomPagesView;
        frameLayout.addView(bottomPagesView, LayoutHelper.createFrame(66, 5.0f, 49, 0.0f, 350.0f, 0.0f, 0.0f));
        TextView textView2 = new TextView(this);
        this.textView = textView2;
        textView2.setTextColor(-15494190);
        this.textView.setGravity(17);
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        frameLayout.addView(this.textView, LayoutHelper.createFrame(-2, 30.0f, 81, 0.0f, 0.0f, 0.0f, 20.0f));
        this.textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$qmO68UCGjQkf_xB1DCv6TOfqN2k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1$IntroActivity(view);
            }
        });
        if (AndroidUtilities.isTablet()) {
            FrameLayout frameLayout3 = new FrameLayout(this);
            setContentView(frameLayout3);
            SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(this) { // from class: ir.eitaa.ui.IntroActivity.5
                @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
                protected boolean isActionBarVisible() {
                    return false;
                }
            };
            sizeNotifierFrameLayout.setOccupyStatusBar(false);
            sizeNotifierFrameLayout.setBackgroundImage(Theme.getCachedWallpaper(), Theme.isWallpaperMotion());
            frameLayout3.addView(sizeNotifierFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
            FrameLayout frameLayout4 = new FrameLayout(this);
            frameLayout4.setBackgroundResource(R.drawable.btnshadow);
            frameLayout4.addView(scrollView, LayoutHelper.createFrame(-1, -1.0f));
            frameLayout3.addView(frameLayout4, LayoutHelper.createFrame(498, 528, 17));
        } else {
            setRequestedOrientation(1);
            setContentView(scrollView);
        }
        LocaleController.getInstance().loadRemoteLanguages(this.currentAccount);
        checkContinueText();
        this.justCreated = true;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.suggestedLangpack);
        AndroidUtilities.handleProxyIntent(this, getIntent());
        AndroidUtilities.startAppCenter(this);
    }

    /* renamed from: ir.eitaa.ui.IntroActivity$2, reason: invalid class name */
    class AnonymousClass2 implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            if (IntroActivity.this.eglThread != null || surface == null) {
                return;
            }
            IntroActivity.this.eglThread = IntroActivity.this.new EGLThread(surface);
            IntroActivity.this.eglThread.setSurfaceTextureSize(width, height);
            IntroActivity.this.eglThread.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$2$TLD1Ek4Q0rsG9qTpQrSAtOpSjpw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceTextureAvailable$0$IntroActivity$2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSurfaceTextureAvailable$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSurfaceTextureAvailable$0$IntroActivity$2() {
            IntroActivity.this.eglThread.drawRunnable.run();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, final int width, final int height) {
            if (IntroActivity.this.eglThread != null) {
                IntroActivity.this.eglThread.setSurfaceTextureSize(width, height);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (IntroActivity.this.eglThread == null) {
                return true;
            }
            IntroActivity.this.eglThread.shutdown();
            IntroActivity.this.eglThread = null;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$0$IntroActivity(View view) {
        if (this.startPressed) {
            return;
        }
        this.startPressed = true;
        Intent intent = new Intent(this, (Class<?>) LaunchActivity.class);
        intent.putExtra("fromIntro", true);
        startActivity(intent);
        this.destroyed = true;
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$1$IntroActivity(View view) {
        if (this.startPressed || this.localeInfo == null) {
            return;
        }
        LocaleController.getInstance().applyLanguage(this.localeInfo, true, false, this.currentAccount);
        this.startPressed = true;
        Intent intent = new Intent(this, (Class<?>) LaunchActivity.class);
        intent.putExtra("fromIntro", true);
        startActivity(intent);
        this.destroyed = true;
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() throws InterruptedException, Resources.NotFoundException, IOException {
        super.onResume();
        if (this.justCreated) {
            if (LocaleController.isRTL) {
                this.viewPager.setCurrentItem(6);
                this.lastPage = 6;
            } else {
                this.viewPager.setCurrentItem(0);
                this.lastPage = 0;
            }
            this.justCreated = false;
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
    }

    @Override // android.app.Activity
    protected void onPause() throws InterruptedException, IOException {
        super.onPause();
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.destroyed = true;
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.suggestedLangpack);
        MessagesController.getGlobalMainSettings().edit().putLong("intro_crashed_time", 0L).commit();
    }

    private void checkContinueText() {
        LocaleController.LocaleInfo currentLocaleInfo = LocaleController.getInstance().getCurrentLocaleInfo();
        final String str = MessagesController.getInstance(this.currentAccount).suggestedLangCode;
        String str2 = str.contains("-") ? str.split("-")[0] : str;
        String localeAlias = LocaleController.getLocaleAlias(str2);
        LocaleController.LocaleInfo localeInfo = null;
        LocaleController.LocaleInfo localeInfo2 = null;
        for (int i = 0; i < LocaleController.getInstance().languages.size(); i++) {
            LocaleController.LocaleInfo localeInfo3 = LocaleController.getInstance().languages.get(i);
            if (localeInfo3.shortName.equals("en")) {
                localeInfo = localeInfo3;
            }
            if (localeInfo3.shortName.replace("_", "-").equals(str) || localeInfo3.shortName.equals(str2) || localeInfo3.shortName.equals(localeAlias)) {
                localeInfo2 = localeInfo3;
            }
            if (localeInfo != null && localeInfo2 != null) {
                break;
            }
        }
        if (localeInfo == null || localeInfo2 == null || localeInfo == localeInfo2) {
            return;
        }
        TLRPC$TL_langpack_getStrings tLRPC$TL_langpack_getStrings = new TLRPC$TL_langpack_getStrings();
        if (localeInfo2 != currentLocaleInfo) {
            tLRPC$TL_langpack_getStrings.lang_code = localeInfo2.getLangCode();
            this.localeInfo = localeInfo2;
        } else {
            tLRPC$TL_langpack_getStrings.lang_code = localeInfo.getLangCode();
            this.localeInfo = localeInfo;
        }
        tLRPC$TL_langpack_getStrings.keys.add("ContinueOnThisLanguage");
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$KK-mU1eeTFdqjn2actBxyEV0w24
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkContinueText$3$IntroActivity(str, tLObject, tLRPC$TL_error);
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkContinueText$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkContinueText$3$IntroActivity(final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (tLRPC$Vector.objects.isEmpty()) {
                return;
            }
            final TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(0);
            if (tLRPC$LangPackString instanceof TLRPC$TL_langPackString) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$wuZaYp8WomM0TGk9jn7JB0o7tg4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkContinueText$2$IntroActivity(tLRPC$LangPackString, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkContinueText$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkContinueText$2$IntroActivity(TLRPC$LangPackString tLRPC$LangPackString, String str) {
        if (this.destroyed) {
            return;
        }
        this.textView.setText(tLRPC$LangPackString.value);
        MessagesController.getGlobalMainSettings().edit().putString("language_showed2", str.toLowerCase()).commit();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.suggestedLangpack) {
            checkContinueText();
        }
    }

    private class IntroAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Parcelable saveState() {
            return null;
        }

        private IntroAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return IntroActivity.this.titles.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            final TextView textView = new TextView(container.getContext());
            final TextView textView2 = new TextView(container.getContext());
            FrameLayout frameLayout = new FrameLayout(container.getContext()) { // from class: ir.eitaa.ui.IntroActivity.IntroAdapter.1
                @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                    int iDp = (((((bottom - top) / 4) * 3) - AndroidUtilities.dp(275.0f)) / 2) + AndroidUtilities.dp(166.0f);
                    int iDp2 = AndroidUtilities.dp(18.0f);
                    TextView textView3 = textView;
                    textView3.layout(iDp2, iDp, textView3.getMeasuredWidth() + iDp2, textView.getMeasuredHeight() + iDp);
                    int iDp3 = iDp + AndroidUtilities.dp(42.0f);
                    int iDp4 = AndroidUtilities.dp(16.0f);
                    TextView textView4 = textView2;
                    textView4.layout(iDp4, iDp3, textView4.getMeasuredWidth() + iDp4, textView2.getMeasuredHeight() + iDp3);
                }
            };
            textView.setTextColor(-14606047);
            textView.setTextSize(1, 26.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(false));
            textView.setGravity(17);
            frameLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 51, 18.0f, 244.0f, 18.0f, 0.0f));
            textView2.setTextColor(-8355712);
            textView2.setTextSize(1, 15.0f);
            textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            textView2.setGravity(17);
            frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 286.0f, 16.0f, 0.0f));
            container.addView(frameLayout, 0);
            textView.setText(IntroActivity.this.titles[position]);
            textView2.setText(AndroidUtilities.replaceTags(IntroActivity.this.messages[position]));
            return frameLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            IntroActivity.this.bottomPages.setCurrentPage(position);
            IntroActivity.this.currentViewPagerPage = position;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }

    public class EGLThread extends DispatchQueue {
        private Runnable drawRunnable;
        private EGL10 egl10;
        private EGLConfig eglConfig;
        private EGLContext eglContext;
        private EGLDisplay eglDisplay;
        private EGLSurface eglSurface;
        private GL gl;
        private boolean initied;
        private SurfaceTexture surfaceTexture;
        private int[] textures;

        public EGLThread(SurfaceTexture surface) {
            super("EGLThread");
            this.textures = new int[23];
            this.drawRunnable = new AnonymousClass1();
            this.surfaceTexture = surface;
        }

        private boolean initGL() throws Resources.NotFoundException {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.egl10 = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.eglDisplay = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            if (!this.egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglInitialize failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 24, 12326, 0, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, iArr)) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            if (iArr[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                this.eglConfig = eGLConfig;
                EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                this.eglContext = eGLContextEglCreateContext;
                if (eGLContextEglCreateContext == null) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglCreateContext failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    }
                    finish();
                    return false;
                }
                SurfaceTexture surfaceTexture = this.surfaceTexture;
                if (surfaceTexture instanceof SurfaceTexture) {
                    EGLSurface eGLSurfaceEglCreateWindowSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surfaceTexture, null);
                    this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                    if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("createWindowSurface failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                        }
                        finish();
                        return false;
                    }
                    if (!this.egl10.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                        }
                        finish();
                        return false;
                    }
                    this.gl = this.eglContext.getGL();
                    GLES20.glGenTextures(23, this.textures, 0);
                    loadTexture(R.drawable.intro_fast_arrow_shadow, 0);
                    loadTexture(R.drawable.intro_fast_arrow, 1);
                    loadTexture(R.drawable.intro_fast_body, 2);
                    loadTexture(R.drawable.intro_fast_spiral, 3);
                    loadTexture(R.drawable.intro_ic_bubble_dot, 4);
                    loadTexture(R.drawable.intro_ic_bubble, 5);
                    loadTexture(R.drawable.intro_ic_cam_lens, 6);
                    loadTexture(R.drawable.intro_ic_cam, 7);
                    loadTexture(R.drawable.intro_ic_pencil, 8);
                    loadTexture(R.drawable.intro_ic_pin, 9);
                    loadTexture(R.drawable.intro_ic_smile_eye, 10);
                    loadTexture(R.drawable.intro_ic_smile, 11);
                    loadTexture(R.drawable.intro_ic_videocam, 12);
                    loadTexture(R.drawable.intro_knot_down, 13);
                    loadTexture(R.drawable.intro_knot_up, 14);
                    loadTexture(R.drawable.intro_powerful_infinity_white, 15);
                    loadTexture(R.drawable.intro_powerful_infinity, 16);
                    loadTexture(R.drawable.intro_powerful_mask, 17);
                    loadTexture(R.drawable.intro_powerful_star, 18);
                    loadTexture(R.drawable.intro_private_door, 19);
                    loadTexture(R.drawable.intro_private_screw, 20);
                    loadTexture(R.drawable.intro_tg_plane, 21);
                    loadTexture(R.drawable.intro_tg_sphere, 22);
                    int[] iArr2 = this.textures;
                    Intro.setEitaaTextures(iArr2[22], iArr2[21]);
                    int[] iArr3 = this.textures;
                    Intro.setPowerfulTextures(iArr3[17], iArr3[18], iArr3[16], iArr3[15]);
                    int[] iArr4 = this.textures;
                    Intro.setPrivateTextures(iArr4[19], iArr4[20]);
                    int[] iArr5 = this.textures;
                    Intro.setFreeTextures(iArr5[14], iArr5[13]);
                    int[] iArr6 = this.textures;
                    Intro.setFastTextures(iArr6[2], iArr6[3], iArr6[1], iArr6[0]);
                    int[] iArr7 = this.textures;
                    Intro.setIcTextures(iArr7[4], iArr7[5], iArr7[6], iArr7[7], iArr7[8], iArr7[9], iArr7[10], iArr7[11], iArr7[12]);
                    Intro.onSurfaceCreated();
                    IntroActivity.this.currentDate = System.currentTimeMillis() - 1000;
                    return true;
                }
                finish();
                return false;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("eglConfig not initialized");
            }
            finish();
            return false;
        }

        public void finish() {
            if (this.eglSurface != null) {
                EGL10 egl10 = this.egl10;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                this.egl10.eglDestroySurface(this.eglDisplay, this.eglSurface);
                this.eglSurface = null;
            }
            EGLContext eGLContext = this.eglContext;
            if (eGLContext != null) {
                this.egl10.eglDestroyContext(this.eglDisplay, eGLContext);
                this.eglContext = null;
            }
            EGLDisplay eGLDisplay2 = this.eglDisplay;
            if (eGLDisplay2 != null) {
                this.egl10.eglTerminate(eGLDisplay2);
                this.eglDisplay = null;
            }
        }

        /* renamed from: ir.eitaa.ui.IntroActivity$EGLThread$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (EGLThread.this.initied) {
                    if ((EGLThread.this.eglContext.equals(EGLThread.this.egl10.eglGetCurrentContext()) && EGLThread.this.eglSurface.equals(EGLThread.this.egl10.eglGetCurrentSurface(12377))) || EGLThread.this.egl10.eglMakeCurrent(EGLThread.this.eglDisplay, EGLThread.this.eglSurface, EGLThread.this.eglSurface, EGLThread.this.eglContext)) {
                        Intro.setPage(IntroActivity.this.currentViewPagerPage);
                        Intro.setDate((System.currentTimeMillis() - IntroActivity.this.currentDate) / 1000.0f);
                        Intro.onDrawFrame();
                        EGLThread.this.egl10.eglSwapBuffers(EGLThread.this.eglDisplay, EGLThread.this.eglSurface);
                        EGLThread.this.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$EGLThread$1$iVxVvv1kAzgXuUmsjsxN2u-ccOY
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$0$IntroActivity$EGLThread$1();
                            }
                        }, 16L);
                        return;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(EGLThread.this.egl10.eglGetError()));
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$IntroActivity$EGLThread$1() {
                EGLThread.this.drawRunnable.run();
            }
        }

        private void loadTexture(int resId, int index) throws Resources.NotFoundException {
            Drawable drawable = IntroActivity.this.getResources().getDrawable(resId);
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                GLES20.glBindTexture(3553, this.textures[index]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            }
        }

        public void shutdown() {
            postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$IntroActivity$EGLThread$fRupOm1-eRfRcD5I4L0wILpX-1w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$shutdown$0$IntroActivity$EGLThread();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutdown$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutdown$0$IntroActivity$EGLThread() {
            finish();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                looperMyLooper.quit();
            }
        }

        public void setSurfaceTextureSize(int width, int height) {
            Intro.onSurfaceChanged(width, height, Math.min(width / 150.0f, height / 150.0f), 0);
        }

        @Override // ir.eitaa.messenger.DispatchQueue, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.initied = initGL();
            super.run();
        }
    }
}
