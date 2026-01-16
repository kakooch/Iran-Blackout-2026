package org.rbmain.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidMessenger.utilites.AppFavorUtils;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.messanger.browser.Browser;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.Intro;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$LangPackString;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_langPackString;
import org.rbmain.tgnet.TLRPC$TL_langpack_getStrings;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BottomPagesView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class IntroActivity extends Activity implements NotificationCenter.NotificationCenterDelegate {
    private BottomPagesView bottomPages;
    private int currentViewPagerPage;
    private boolean destroyed;
    private boolean dragging;
    private FrameLayout frameLayout2;
    private boolean justEndDragging;
    private LocaleController.LocaleInfo localeInfo;
    private Context mContext;
    private String[] messages;
    private int[] resIds;
    private int startDragX;
    private TextView startMessagingButton;
    private TextView textView;
    private TextView textViewTermsAndConditions;
    private String[] titles;
    private ViewPager viewPager;
    private int currentAccount = UserConfig.selectedAccount;
    private int lastPage = 0;
    private boolean justCreated = false;
    private boolean startPressed = false;
    ArrayList<Integer> colorArray = new ArrayList<>();
    private int pageCount = 3;

    private void createTermsAndConds(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        if (this.textViewTermsAndConditions == null) {
            TextView textView = new TextView(this.mContext);
            this.textViewTermsAndConditions = textView;
            textView.setGravity(5);
            this.textViewTermsAndConditions.setTextColor(-16777216);
            this.textViewTermsAndConditions.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.textViewTermsAndConditions.setTextSize(1, 15.0f);
            frameLayout.addView(this.textViewTermsAndConditions, LayoutHelper.createFrame(-1, -2, 5));
        }
        String string = LocaleController.getString(R.string.termsAndConditions);
        String string2 = LocaleController.getString(R.string.termsAndConditionsPart1);
        String string3 = LocaleController.getString(R.string.termsAndConditionsPart2);
        SpannableString spannableString = new SpannableString(string);
        SpanHelper.makeLinkSpanWithColor(spannableString, new View.OnClickListener() { // from class: org.rbmain.ui.IntroActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntroActivity.this.openUrl(AppFavorUtils.termsAndConditionsUrl);
            }
        }, string.indexOf(string2), string.indexOf(string2) + string2.length(), R.color.colorPrimary);
        SpanHelper.makeLinkSpanWithColor(spannableString, new View.OnClickListener() { // from class: org.rbmain.ui.IntroActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntroActivity.this.openUrl(AppFavorUtils.policyUrl);
            }
        }, string.indexOf(string3), string.indexOf(string3) + string3.length(), R.color.colorPrimary);
        this.textViewTermsAndConditions.setText(spannableString);
        this.textViewTermsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        if (Browser.openUrl(this.mContext, Uri.parse(str))) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, LocaleController.getString(R.string.OpenInBrowser)));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        setTheme(2131952293);
        super.onCreate(bundle);
        this.mContext = this;
        requestWindowFeature(1);
        MessagesController.getGlobalMainSettings().edit().putLong("intro_crashed_time", System.currentTimeMillis()).apply();
        this.titles = AppFavorUtils.getIntroTitleArray();
        this.messages = AppFavorUtils.getIntroDescriptionArray();
        this.resIds = AppFavorUtils.getIntroImageResArray();
        this.pageCount = AppFavorUtils.introCount;
        this.colorArray = AppFavorUtils.getColorArray();
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        FrameLayout frameLayout = new FrameLayout(this) { // from class: org.rbmain.ui.IntroActivity.3
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                int i5 = (i4 - i2) / 4;
                int i6 = i5 * 3;
                int iDp = (i6 - AndroidUtilities.dp(275.0f)) / 2;
                IntroActivity.this.frameLayout2.layout(0, iDp, IntroActivity.this.frameLayout2.getMeasuredWidth(), IntroActivity.this.frameLayout2.getMeasuredHeight() + iDp);
                int iDp2 = iDp + AndroidUtilities.dp(272.0f) + AndroidUtilities.dp(16.0f);
                int measuredWidth = (getMeasuredWidth() - IntroActivity.this.bottomPages.getMeasuredWidth()) / 2;
                IntroActivity.this.bottomPages.layout(measuredWidth, iDp2, IntroActivity.this.bottomPages.getMeasuredWidth() + measuredWidth, IntroActivity.this.bottomPages.getMeasuredHeight() + iDp2);
                IntroActivity.this.viewPager.layout(0, 0, IntroActivity.this.viewPager.getMeasuredWidth(), IntroActivity.this.viewPager.getMeasuredHeight());
                int measuredHeight = i6 + ((i5 - IntroActivity.this.startMessagingButton.getMeasuredHeight()) / 2);
                int measuredWidth2 = (getMeasuredWidth() - IntroActivity.this.startMessagingButton.getMeasuredWidth()) / 2;
                IntroActivity.this.startMessagingButton.layout(measuredWidth2, measuredHeight, IntroActivity.this.startMessagingButton.getMeasuredWidth() + measuredWidth2, IntroActivity.this.startMessagingButton.getMeasuredHeight() + measuredHeight);
                int iDp3 = measuredHeight - AndroidUtilities.dp(30.0f);
                int measuredWidth3 = (getMeasuredWidth() - IntroActivity.this.textView.getMeasuredWidth()) / 2;
                IntroActivity.this.textView.layout(measuredWidth3, iDp3 - IntroActivity.this.textView.getMeasuredHeight(), IntroActivity.this.textView.getMeasuredWidth() + measuredWidth3, iDp3);
                int iDp4 = iDp3 - AndroidUtilities.dp(30.0f);
                int measuredWidth4 = (getMeasuredWidth() - IntroActivity.this.textViewTermsAndConditions.getMeasuredWidth()) - AndroidUtilities.dp(16.0f);
                IntroActivity.this.textViewTermsAndConditions.layout(measuredWidth4, iDp4 - IntroActivity.this.textViewTermsAndConditions.getMeasuredHeight(), IntroActivity.this.textViewTermsAndConditions.getMeasuredWidth() + measuredWidth4, iDp4);
            }
        };
        frameLayout.setBackgroundColor(-1);
        scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        FrameLayout frameLayout2 = new FrameLayout(this);
        this.frameLayout2 = frameLayout2;
        frameLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 78.0f, 0.0f, 0.0f));
        ViewPager viewPager = new ViewPager(this);
        this.viewPager = viewPager;
        viewPager.setAdapter(new IntroAdapter());
        this.viewPager.setPageMargin(0);
        this.viewPager.setOffscreenPageLimit(1);
        frameLayout.addView(this.viewPager, LayoutHelper.createFrame(-1, -1.0f));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: org.rbmain.ui.IntroActivity.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IntroActivity.this.bottomPages.setPageOffset(i, f);
                float measuredWidth = IntroActivity.this.viewPager.getMeasuredWidth();
                if (measuredWidth == 0.0f) {
                    return;
                }
                Intro.setScrollOffset((((i * measuredWidth) + i2) - (IntroActivity.this.currentViewPagerPage * measuredWidth)) / measuredWidth);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IntroActivity.this.currentViewPagerPage = i;
                if (FlavorHelper.isShad()) {
                    IntroActivity.this.bottomPages.setColor(IntroActivity.this.colorArray.get(i).intValue());
                }
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
        TextView textView = new TextView(this);
        this.startMessagingButton = textView;
        textView.setText(LocaleController.getString("loginAndAcceptTerms", R.string.loginAndAcceptTerms));
        this.startMessagingButton.setGravity(17);
        this.startMessagingButton.setTextColor(-1);
        this.startMessagingButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.startMessagingButton.setTextSize(1, 14.0f);
        this.startMessagingButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), FlavorHelper.isShad() ? -13639804 : -11491093, FlavorHelper.isShad() ? -13639804 : -12346402));
        this.startMessagingButton.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        frameLayout.addView(this.startMessagingButton, LayoutHelper.createFrame(-2, 42.0f, 81, 10.0f, 0.0f, 10.0f, 76.0f));
        this.startMessagingButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.IntroActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        if (BuildVars.DEBUG_PRIVATE_VERSION) {
            this.startMessagingButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.IntroActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$onCreate$1(view);
                }
            });
        }
        BottomPagesView bottomPagesView = new BottomPagesView(this, this.viewPager, this.pageCount);
        this.bottomPages = bottomPagesView;
        frameLayout.addView(bottomPagesView, LayoutHelper.createFrame(this.pageCount * 11, 5.0f, 49, 0.0f, 350.0f, 0.0f, 0.0f));
        if (FlavorHelper.isShad()) {
            this.bottomPages.setColor(this.colorArray.get(0).intValue());
        }
        TextView textView2 = new TextView(this);
        this.textView = textView2;
        textView2.setTextColor(-15494190);
        this.textView.setGravity(17);
        this.textView.setTextSize(1, 16.0f);
        frameLayout.addView(this.textView, LayoutHelper.createFrame(-2, 30.0f, 81, 0.0f, 0.0f, 0.0f, 20.0f));
        this.textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.IntroActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        if (AndroidUtilities.isTablet()) {
            FrameLayout frameLayout3 = new FrameLayout(this);
            setContentView(frameLayout3);
            View imageView = new ImageView(this);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.catstile);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            imageView.setBackgroundDrawable(bitmapDrawable);
            frameLayout3.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
            FrameLayout frameLayout4 = new FrameLayout(this);
            frameLayout4.setBackgroundResource(R.drawable.btnshadow);
            frameLayout4.addView(scrollView, LayoutHelper.createFrame(-1, -1.0f));
            frameLayout3.addView(frameLayout4, LayoutHelper.createFrame(498, 528, 17));
        } else {
            setRequestedOrientation(1);
            setContentView(scrollView);
        }
        LocaleController.getInstance().loadRemoteLanguages(this.currentAccount);
        this.justCreated = true;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.suggestedLangpack);
        AndroidUtilities.handleProxyIntent(this, getIntent());
        AndroidUtilities.startAppCenter(this);
        createTermsAndConds(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
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
    public /* synthetic */ boolean lambda$onCreate$1(View view) {
        ConnectionsManager.getInstance(this.currentAccount).switchBackend();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
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
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (this.justCreated) {
            if (LocaleController.isRTL) {
                this.viewPager.setCurrentItem(this.pageCount);
                this.lastPage = this.pageCount;
            } else {
                this.viewPager.setCurrentItem(0);
                this.lastPage = 0;
            }
            this.justCreated = false;
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.destroyed = true;
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.suggestedLangpack);
        MessagesController.getGlobalMainSettings().edit().putLong("intro_crashed_time", 0L).apply();
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
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings, new RequestDelegate() { // from class: org.rbmain.ui.IntroActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkContinueText$4(str, tLObject, tLRPC$TL_error);
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContinueText$4(final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (tLRPC$Vector.objects.isEmpty()) {
                return;
            }
            final TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(0);
            if (tLRPC$LangPackString instanceof TLRPC$TL_langPackString) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.IntroActivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkContinueText$3(tLRPC$LangPackString, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContinueText$3(TLRPC$LangPackString tLRPC$LangPackString, String str) {
        if (this.destroyed) {
            return;
        }
        this.textView.setText(tLRPC$LangPackString.value);
        MessagesController.getGlobalMainSettings().edit().putString("language_showed2", str.toLowerCase()).apply();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.suggestedLangpack) {
            checkContinueText();
        }
    }

    private class IntroAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
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
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            final TextView textView = new TextView(viewGroup.getContext());
            final TextView textView2 = new TextView(viewGroup.getContext());
            final ImageView imageView = new ImageView(viewGroup.getContext());
            FrameLayout frameLayout = new FrameLayout(this, viewGroup.getContext()) { // from class: org.rbmain.ui.IntroActivity.IntroAdapter.1
                @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                    int iDp = ((((i5 - i3) / 4) * 3) - AndroidUtilities.dp(275.0f)) / 2;
                    int iDp2 = AndroidUtilities.dp(18.0f);
                    if (FlavorHelper.isShad()) {
                        ImageView imageView2 = imageView;
                        imageView2.layout(0, 0, imageView2.getMeasuredWidth(), imageView.getMeasuredHeight());
                    } else {
                        ImageView imageView3 = imageView;
                        imageView3.layout(0, iDp, imageView3.getMeasuredWidth(), imageView.getMeasuredHeight() + iDp);
                    }
                    int iDp3 = iDp + AndroidUtilities.dp(166.0f);
                    TextView textView3 = textView;
                    textView3.layout(iDp2, iDp3, textView3.getMeasuredWidth() + iDp2, textView.getMeasuredHeight() + iDp3);
                    int measuredHeight = iDp3 + textView.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                    int iDp4 = AndroidUtilities.dp(16.0f);
                    TextView textView4 = textView2;
                    textView4.layout(iDp4, measuredHeight, textView4.getMeasuredWidth() + iDp4, textView2.getMeasuredHeight() + measuredHeight);
                }
            };
            frameLayout.addView(imageView, LayoutHelper.createFrame(-1, FlavorHelper.isShad() ? 220 : ImageReceiver.DEFAULT_CROSSFADE_DURATION, 17));
            textView.setTextColor(-14606047);
            textView.setTextSize(1, 20.0f);
            textView.setGravity(17);
            frameLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 51, 18.0f, 244.0f, 18.0f, 0.0f));
            textView2.setTextColor(-8355712);
            textView2.setTextSize(1, 15.0f);
            textView2.setGravity(17);
            frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 286.0f, 16.0f, 0.0f));
            viewGroup.addView(frameLayout, 0);
            textView.setText(IntroActivity.this.titles[i]);
            textView2.setText(AndroidUtilities.replaceTags(IntroActivity.this.messages[i]));
            if (FlavorHelper.isShad()) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            imageView.setImageResource(IntroActivity.this.resIds[i]);
            return frameLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            IntroActivity.this.bottomPages.setCurrentPage(i);
            IntroActivity.this.currentViewPagerPage = i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (dataSetObserver != null) {
                super.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }
}
