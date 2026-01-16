package ir.resaneh1.iptv.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.utilites.AppFavorUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UI_TabView;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.InlineWebviewFragment;
import ir.resaneh1.iptv.fragment.ServiceFragment;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostGridActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.CardPageLinkData;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.model.ExploreDataInLink;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.CallLogActivity;
import org.rbmain.ui.ChangeUsernameActivity;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.ContactsActivity;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes3.dex */
public class MainTabFragment extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private CallLogActivity callFragment;
    private ContactsActivity contactFragment;
    private final GetBaseInfoOutput.DefaultTabEnum defaultTabEnum;
    private DialogsActivity dialogActivity;
    private RubinoPostGridActivity exploreTabFragment;
    private FrameLayout fragmentContrainer;
    private HomeFragment homeFragmentTab;
    private HomePageActivityNew homeServiceFragmentNew;
    private int lastTabSelected;
    private long lastTabStartTime;
    private ServiceFragment paymentFragment;
    private Dialog permissionDialog;
    public RubinoPostListActivity rubinoFragment;
    private ServiceFragment schoolFragment;
    private ServiceFragment serviceFragment;
    private ProfileActivity settingFragment;
    private InlineWebviewFragment shadbinFragment;
    private ServiceFragment shadboumFragment;
    int tabCount;
    public TabLayout tabLayout;
    private long[] totalTabTime;
    public ExploreDataInLink exploreDataInLink = null;
    private boolean askAboutContacts = true;

    public int getTabIcon(int i, boolean z) {
        if (z) {
            if (i == -1 || i == 4) {
                return R.drawable.ic_services_fill;
            }
            if (i == 3) {
                return R.drawable.ic_chat_fill;
            }
            if (i == -1) {
                return R.drawable.ic_rubino_fill;
            }
            if (i == 1) {
                return R.drawable.ic_shadino_fill;
            }
            if (i == -1) {
                return R.drawable.ic_setting_fill;
            }
            if (i == -1) {
                return R.drawable.ic_contact_fill;
            }
            if (i == -1) {
                return R.drawable.ic_call_fill;
            }
            if (i == -1) {
                return R.drawable.ic_shad_shadboum_fill;
            }
            if (i == 2) {
                return R.drawable.ic_school_fill;
            }
            if (i == 0) {
                return R.drawable.ic_shadbin_selected;
            }
        } else {
            if (i == -1) {
                return R.drawable.ic_services_outline;
            }
            if (i == 3) {
                return R.drawable.ic_chat_outline;
            }
            if (i == -1) {
                return R.drawable.ic_rubino_outline;
            }
            if (i == 1) {
                return R.drawable.ic_shadino_outline;
            }
            if (i == -1) {
                return R.drawable.ic_setting_outline;
            }
            if (i == -1) {
                return R.drawable.ic_contact_outline;
            }
            if (i == -1) {
                return R.drawable.ic_call_outline;
            }
            if (i == -1) {
                return R.drawable.ic_shad_shadboum_outline;
            }
            if (i == 2) {
                return R.drawable.ic_school_outline;
            }
            if (i == 0) {
                return R.drawable.ic_shadbin;
            }
        }
        return R.drawable.ic_services_outline;
    }

    public void selectSettings() {
    }

    public MainTabFragment(GetBaseInfoOutput.DefaultTabEnum defaultTabEnum) {
        this.tabCount = 0;
        this.swipeBackEnabled = false;
        this.defaultTabEnum = defaultTabEnum;
        this.fragmentName = "MainTabFragment";
        int i = 0 + 1;
        this.tabCount = i;
        int i2 = i + 1;
        this.tabCount = i2;
        int i3 = i2 + 1;
        this.tabCount = i3;
        int i4 = i3 + 1;
        this.tabCount = i4;
        int i5 = i4 + 1;
        this.tabCount = i5;
        this.totalTabTime = new long[i5];
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        try {
            LocaleController.getInstance().checkLanguage();
        } catch (Exception unused) {
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.main_tab_fragment, (ViewGroup) null, false);
        this.fragmentView = viewInflate;
        viewInflate.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.activity.MainTabFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        findView();
        init();
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setAddToContainer(false);
            this.actionBar.setVisibility(8);
        }
        return this.fragmentView;
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.fragmentView.findViewById(i);
    }

    protected void findView() {
        this.fragmentContrainer = (FrameLayout) findViewById(R.id.fragmentContrainer);
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    protected void init() throws Resources.NotFoundException {
        clearAllTabs();
        this.lastTabSelected = -1;
        this.lastTabStartTime = System.currentTimeMillis();
        HomePageActivityNew serviceFragmentNew = getServiceFragmentNew();
        View fragmentView = serviceFragmentNew.getFragmentView();
        if (fragmentView == null) {
            serviceFragmentNew.createView(getContext());
        }
        this.fragmentContrainer.addView(fragmentView);
        serviceFragmentNew.setForMainTab();
        setupViewPager();
        GetBaseInfoOutput.DefaultTabEnum defaultTabEnum = this.defaultTabEnum;
        if (defaultTabEnum == GetBaseInfoOutput.DefaultTabEnum.Messenger) {
            selectChatTab();
            return;
        }
        if (defaultTabEnum == GetBaseInfoOutput.DefaultTabEnum.Rubino) {
            selectRubino();
            return;
        }
        if (defaultTabEnum == GetBaseInfoOutput.DefaultTabEnum.Explore) {
            selectExploreTab(null);
        } else if (defaultTabEnum == GetBaseInfoOutput.DefaultTabEnum.Setting) {
            selectSettings();
        } else {
            selectServiceTab(false);
        }
    }

    public void destroyServiceFragment() {
        ServiceFragment serviceFragment = this.serviceFragment;
        if (serviceFragment != null) {
            serviceFragment.onPause();
            this.serviceFragment.onFragmentDestroy();
            this.serviceFragment = null;
        }
    }

    public void destroyNewServiceFragment() {
        HomePageActivityNew homePageActivityNew = this.homeServiceFragmentNew;
        if (homePageActivityNew != null) {
            homePageActivityNew.onPause();
            this.homeServiceFragmentNew.onFragmentDestroy();
            this.homeServiceFragmentNew = null;
        }
    }

    public void destroyRubinoFragment() {
        RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
        if (rubinoPostListActivity != null) {
            rubinoPostListActivity.onPause();
            this.rubinoFragment.onFragmentDestroy();
            this.rubinoFragment = null;
        }
    }

    public void destroyCallFragment() {
        CallLogActivity callLogActivity = this.callFragment;
        if (callLogActivity != null) {
            callLogActivity.onPause();
            this.callFragment.onFragmentDestroy();
            this.callFragment = null;
        }
    }

    public void destroySettingFragment() {
        ProfileActivity profileActivity = this.settingFragment;
        if (profileActivity != null) {
            profileActivity.onPause();
            this.settingFragment.onFragmentDestroy();
            this.settingFragment = null;
        }
    }

    public void destroyShadbinFragment() {
        InlineWebviewFragment inlineWebviewFragment = this.shadbinFragment;
        if (inlineWebviewFragment != null) {
            inlineWebviewFragment.onPause();
            this.shadbinFragment.onFragmentDestroy();
            this.shadbinFragment = null;
        }
    }

    public void destroySchoolFragment() {
        ServiceFragment serviceFragment = this.schoolFragment;
        if (serviceFragment != null) {
            serviceFragment.onPause();
            this.schoolFragment.onFragmentDestroy();
            this.schoolFragment = null;
        }
    }

    public void destroyShadboumFragment() {
        ServiceFragment serviceFragment = this.shadboumFragment;
        if (serviceFragment != null) {
            serviceFragment.onPause();
            this.shadboumFragment.onFragmentDestroy();
            this.shadboumFragment = null;
        }
    }

    public void destroyChatFragment() {
        DialogsActivity dialogsActivity = this.dialogActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onPause();
            this.dialogActivity.onFragmentDestroy();
            this.dialogActivity = null;
        }
    }

    public void destroyExploreFragment() {
        RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
        if (rubinoPostGridActivity != null) {
            rubinoPostGridActivity.onPause();
            this.exploreTabFragment.onFragmentDestroy();
            this.exploreTabFragment = null;
        }
    }

    public void destroyContactFragment() {
        ContactsActivity contactsActivity = this.contactFragment;
        if (contactsActivity != null) {
            contactsActivity.onPause();
            this.contactFragment.onFragmentDestroy();
            this.contactFragment = null;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.myNewChatUser);
        getNotificationCenter().addObserver(this, NotificationCenter.myUpdateUserChat);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.myNewChatUser);
        getNotificationCenter().removeObserver(this, NotificationCenter.myUpdateUserChat);
        super.onFragmentDestroy();
    }

    public DialogsActivity getDialogsActivityIfSelected() {
        if (this.tabLayout.getSelectedTabPosition() == 3) {
            return this.dialogActivity;
        }
        return null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        resumeSelectedTab();
    }

    void resumeSelectedTab() {
        InlineWebviewFragment inlineWebviewFragment;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            return;
        }
        int selectedTabPosition = tabLayout.getSelectedTabPosition();
        if (selectedTabPosition == -1) {
            ServiceFragment serviceFragment = this.serviceFragment;
            if (serviceFragment != null) {
                serviceFragment.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == 4) {
            HomePageActivityNew homePageActivityNew = this.homeServiceFragmentNew;
            if (homePageActivityNew != null) {
                homePageActivityNew.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == 3) {
            DialogsActivity dialogsActivity = this.dialogActivity;
            if (dialogsActivity != null) {
                dialogsActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == -1) {
            RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
            if (rubinoPostListActivity != null) {
                rubinoPostListActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == 1) {
            RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
            if (rubinoPostGridActivity != null) {
                rubinoPostGridActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == -1) {
            ProfileActivity profileActivity = this.settingFragment;
            if (profileActivity != null) {
                profileActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == -1) {
            ContactsActivity contactsActivity = this.contactFragment;
            if (contactsActivity != null) {
                contactsActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == -1) {
            CallLogActivity callLogActivity = this.callFragment;
            if (callLogActivity != null) {
                callLogActivity.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == -1) {
            ServiceFragment serviceFragment2 = this.shadboumFragment;
            if (serviceFragment2 != null) {
                serviceFragment2.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition == 2) {
            ServiceFragment serviceFragment3 = this.schoolFragment;
            if (serviceFragment3 != null) {
                serviceFragment3.onResume();
                return;
            }
            return;
        }
        if (selectedTabPosition != 0 || (inlineWebviewFragment = this.shadbinFragment) == null) {
            return;
        }
        inlineWebviewFragment.onResume();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        HomePageActivityNew homePageActivityNew;
        ServiceFragment serviceFragment;
        DialogsActivity dialogsActivity;
        RubinoPostListActivity rubinoPostListActivity;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            if (tabLayout.getSelectedTabPosition() == -1 && (rubinoPostListActivity = this.rubinoFragment) != null && !rubinoPostListActivity.onBackPressed()) {
                return false;
            }
            if (this.tabLayout.getSelectedTabPosition() == 3 && (dialogsActivity = this.dialogActivity) != null && !dialogsActivity.onBackPressed()) {
                return false;
            }
            if (this.tabLayout.getSelectedTabPosition() == -1 && (serviceFragment = this.serviceFragment) != null && !serviceFragment.onBackPressed()) {
                return false;
            }
            if (this.tabLayout.getSelectedTabPosition() == 4 && (homePageActivityNew = this.homeServiceFragmentNew) != null && !homePageActivityNew.onBackPressed()) {
                return false;
            }
            if (this.tabLayout.getSelectedTabPosition() != 4 && this.tabLayout.getTabAt(4) != null) {
                this.tabLayout.getTabAt(4).select();
                return false;
            }
            return super.onBackPressed();
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            pauseTab(tabLayout.getSelectedTabPosition());
        }
    }

    void pauseTab(int i) {
        InlineWebviewFragment inlineWebviewFragment;
        if (i == -1) {
            ServiceFragment serviceFragment = this.serviceFragment;
            if (serviceFragment != null) {
                serviceFragment.onPause();
                return;
            }
            return;
        }
        if (i == 4) {
            HomePageActivityNew homePageActivityNew = this.homeServiceFragmentNew;
            if (homePageActivityNew != null) {
                homePageActivityNew.onPause();
                return;
            }
            return;
        }
        if (i == 3) {
            DialogsActivity dialogsActivity = this.dialogActivity;
            if (dialogsActivity != null) {
                dialogsActivity.onPause();
                return;
            }
            return;
        }
        if (i == -1) {
            RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
            if (rubinoPostListActivity != null) {
                rubinoPostListActivity.onPause();
                return;
            }
            return;
        }
        if (i == 1) {
            RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
            if (rubinoPostGridActivity != null) {
                rubinoPostGridActivity.onPause();
                return;
            }
            return;
        }
        if (i == -1) {
            ProfileActivity profileActivity = this.settingFragment;
            if (profileActivity != null) {
                profileActivity.onPause();
                return;
            }
            return;
        }
        if (i == -1) {
            ContactsActivity contactsActivity = this.contactFragment;
            if (contactsActivity != null) {
                contactsActivity.onPause();
                return;
            }
            return;
        }
        if (i == -1) {
            CallLogActivity callLogActivity = this.callFragment;
            if (callLogActivity != null) {
                callLogActivity.onPause();
                return;
            }
            return;
        }
        if (i == -1) {
            ServiceFragment serviceFragment2 = this.shadboumFragment;
            if (serviceFragment2 != null) {
                serviceFragment2.onPause();
                return;
            }
            return;
        }
        if (i == 2) {
            ServiceFragment serviceFragment3 = this.schoolFragment;
            if (serviceFragment3 != null) {
                serviceFragment3.onPause();
                return;
            }
            return;
        }
        if (i != 0 || (inlineWebviewFragment = this.shadbinFragment) == null) {
            return;
        }
        inlineWebviewFragment.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        super.onActivityResultFragment(i, i2, intent);
        DialogsActivity dialogsActivity = this.dialogActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onActivityResultFragment(i, i2, intent);
        }
        ProfileActivity profileActivity = this.settingFragment;
        if (profileActivity != null) {
            profileActivity.onActivityResultFragment(i, i2, intent);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        DialogsActivity dialogsActivity = this.dialogActivity;
        if (dialogsActivity != null) {
            dialogsActivity.didReceivedNotification(i, i2, objArr);
        }
    }

    public void selectChatTab() {
        if (!ChildLockCheck.canOpenMessengerWithAlert()) {
            selectServiceTab(false);
        } else {
            this.tabLayout.getTabAt(3).select();
        }
    }

    public void selectServiceTab(boolean z) throws Resources.NotFoundException {
        selectServiceTabNew(z);
    }

    public void selectServiceTabNew(boolean z) throws Resources.NotFoundException {
        if (this.tabLayout.getSelectedTabPosition() == 4 && z) {
            try {
                this.fragmentContrainer.removeAllViews();
            } catch (Exception unused) {
            }
            HomePageActivityNew serviceFragmentNew = getServiceFragmentNew();
            this.fragmentContrainer.addView(serviceFragmentNew.getFragmentView());
            serviceFragmentNew.setForMainTab();
            return;
        }
        this.tabLayout.getTabAt(4).select();
    }

    public void selectRubino() {
        if (ChildLockCheck.canOpenRubinoWithAlert()) {
            replaceRubinoFragmentFull();
        }
    }

    public void selectExploreTab(ExploreDataInLink exploreDataInLink) {
        if (ChildLockCheck.canOpenExploreWithAlert()) {
            this.exploreDataInLink = exploreDataInLink;
            if (this.exploreTabFragment != null && exploreDataInLink != null && this.tabLayout.getSelectedTabPosition() != 1) {
                destroyExploreFragment();
            }
            this.tabLayout.getTabAt(1).select();
        }
    }

    private void setupViewPager() {
        MyLog.e("ViewpagerPresenter", "setupViewPager: ");
        final Context context = getContext();
        this.tabLayout.setBackgroundColor(Theme.getColor(Theme.key_mainTabBackground));
        for (int i = 0; i < this.tabCount; i++) {
            this.totalTabTime[i] = 0;
            if (i == 4) {
                TabLayout tabLayout = this.tabLayout;
                tabLayout.addTab(tabLayout.newTab().setCustomView(getTabView(i, true)));
                this.tabLayout.getTabAt(i).select();
            } else {
                TabLayout tabLayout2 = this.tabLayout;
                tabLayout2.addTab(tabLayout2.newTab().setCustomView(getTabView(i, false)));
            }
        }
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: ir.resaneh1.iptv.activity.MainTabFragment.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) throws InterruptedException, Resources.NotFoundException {
                try {
                    MainTabFragment.this.fragmentContrainer.removeAllViews();
                } catch (Exception e) {
                    MyLog.e("MainTabFragment", "onTabSelected " + e);
                    MyLog.handleException(e);
                }
                int position = tab.getPosition();
                MainTabFragment.this.sendFirebaseEvents(context, position);
                MainTabFragment.this.setTabView(tab.getCustomView(), position, true);
                PlayerPresenter.destroyPlayer(context);
                MainTabFragment.this.setChatTabNumber();
                if (!((BaseFragment) MainTabFragment.this).inPreviewMode && ((position == -1 || position == 1) && (MainTabFragment.this.getAppPreferences().getMyUsername() == null || MainTabFragment.this.getAppPreferences().getMyUsername().isEmpty()))) {
                    final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(MainTabFragment.this.getContext(), LocaleController.formatString(R.string.RubinoUsernameEmpty, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString());
                    threeButtonDialog.button1.setText(LocaleController.getString(R.string.OK));
                    threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.activity.MainTabFragment.2.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MainTabFragment.this.presentFragment(new ChangeUsernameActivity());
                            threeButtonDialog.dismiss();
                        }
                    });
                    threeButtonDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.activity.MainTabFragment.2.2
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            MainTabFragment.this.tabLayout.getTabAt(4).select();
                        }
                    });
                    threeButtonDialog.button2.setVisibility(4);
                    threeButtonDialog.button3.setVisibility(4);
                    threeButtonDialog.show();
                    return;
                }
                if (position == -1) {
                    MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getServiceFragment().getFragmentView());
                }
                if (position == 4) {
                    MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getServiceFragmentNew().getFragmentView());
                    return;
                }
                if (position == 3) {
                    if (ChildLockCheck.canOpenMessengerWithAlert()) {
                        MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getDialogActivity().getFragmentView());
                        return;
                    } else {
                        MainTabFragment.this.selectServiceTab(false);
                        return;
                    }
                }
                if (position == -1) {
                    if (ChildLockCheck.canOpenRubinoWithAlert()) {
                        MainTabFragment.this.replaceRubinoFragment();
                        return;
                    } else {
                        MainTabFragment.this.selectServiceTab(false);
                        return;
                    }
                }
                if (position == 1) {
                    if (ChildLockCheck.canOpenExploreWithAlert()) {
                        FrameLayout frameLayout = MainTabFragment.this.fragmentContrainer;
                        MainTabFragment mainTabFragment = MainTabFragment.this;
                        frameLayout.addView(mainTabFragment.getExploreFragment(mainTabFragment.exploreDataInLink).getFragmentView());
                        return;
                    }
                    MainTabFragment.this.selectServiceTab(false);
                    return;
                }
                if (position == -1) {
                    MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getShadboumFragment().getFragmentView());
                    return;
                }
                if (position == 2) {
                    MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getSchoolFragment().getFragmentView());
                    MainTabFragment.this.openSchoolDialog();
                    return;
                }
                if (position == 0) {
                    MainTabFragment.this.fragmentContrainer.addView(MainTabFragment.this.getShadbinFragment().getFragmentView());
                    return;
                }
                if (position == -1) {
                    ProfileActivity settingFragment = MainTabFragment.this.getSettingFragment();
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.getActionBarLayout().callOnTransitionAnimationEnd(settingFragment, true, false);
                    }
                    MainTabFragment.this.fragmentContrainer.addView(settingFragment.getFragmentView());
                    return;
                }
                if (position == -1) {
                    ContactsActivity contactFragment = MainTabFragment.this.getContactFragment();
                    MainTabFragment.this.fragmentContrainer.addView(contactFragment.getFragmentView());
                    ((FrameLayout.LayoutParams) contactFragment.getFragmentView().getLayoutParams()).topMargin = AndroidUtilities.dp(56.0f);
                    MainTabFragment.this.fragmentContrainer.addView(contactFragment.getActionBar(), LayoutHelper.createFrame(-1, 56.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    View view = new View(context);
                    view.setBackgroundResource(R.drawable.header_shadow);
                    MainTabFragment.this.fragmentContrainer.addView(view, LayoutHelper.createFrame(-1, 3.0f, 51, 0.0f, 56.0f, 0.0f, 0.0f));
                    return;
                }
                if (position == -1) {
                    CallLogActivity callFragment = MainTabFragment.this.getCallFragment();
                    MainTabFragment.this.fragmentContrainer.addView(callFragment.getFragmentView());
                    ((FrameLayout.LayoutParams) callFragment.getFragmentView().getLayoutParams()).topMargin = AndroidUtilities.dp(56.0f);
                    MainTabFragment.this.fragmentContrainer.addView(callFragment.getActionBar(), LayoutHelper.createFrame(-1, 56.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    View view2 = new View(context);
                    view2.setBackgroundResource(R.drawable.header_shadow);
                    MainTabFragment.this.fragmentContrainer.addView(view2, LayoutHelper.createFrame(-1, 3.0f, 51, 0.0f, 56.0f, 0.0f, 0.0f));
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                MainTabFragment.this.setTabView(tab.getCustomView(), tab.getPosition(), false);
                MainTabFragment.this.pauseTab(tab.getPosition());
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == -1) {
                    MainTabFragment.this.getRubinoFragment().scrollToTop();
                    return;
                }
                if (position != 1) {
                    if (position != 3 || MainTabFragment.this.dialogActivity == null) {
                        return;
                    }
                    MainTabFragment.this.dialogActivity.scrollToTop();
                    return;
                }
                MainTabFragment mainTabFragment = MainTabFragment.this;
                mainTabFragment.getExploreFragment(mainTabFragment.exploreDataInLink).scrollToTop();
            }
        });
        setChatTabNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirebaseEvents(Context context, int i) {
        StringBuilder sb;
        StringBuilder sb2;
        FirebaseEventSender.sendEventNew(context, "TabSelected " + getTabName(i), BuildConfig.FLAVOR);
        FirebaseCrashlytics.getInstance().setCustomKey("MainTabOnTabSelected " + i, getTabName(i));
        int i2 = this.lastTabSelected;
        if (i2 != i) {
            if (i2 > 0 && i2 < this.totalTabTime.length) {
                long jCurrentTimeMillis = (System.currentTimeMillis() - this.lastTabStartTime) / 1000;
                FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                String str = "MainTabTime " + this.lastTabSelected;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(getTabName(this.lastTabSelected));
                sb3.append(" ");
                if (jCurrentTimeMillis < 120) {
                    sb = new StringBuilder();
                    sb.append(jCurrentTimeMillis);
                    sb.append(" s");
                } else {
                    sb = new StringBuilder();
                    sb.append(jCurrentTimeMillis / 60);
                    sb.append(" m");
                }
                sb3.append(sb.toString());
                firebaseCrashlytics.setCustomKey(str, sb3.toString());
                long[] jArr = this.totalTabTime;
                int i3 = this.lastTabSelected;
                jArr[i3] = jArr[i3] + jCurrentTimeMillis;
                long j = jArr[i3];
                FirebaseCrashlytics firebaseCrashlytics2 = FirebaseCrashlytics.getInstance();
                String str2 = "MainTabTime total" + this.lastTabSelected;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(getTabName(this.lastTabSelected));
                sb4.append(" ");
                if (j < 120) {
                    sb2 = new StringBuilder();
                    sb2.append(j);
                    sb2.append(" s");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(j / 60);
                    sb2.append(" m");
                }
                sb4.append(sb2.toString());
                firebaseCrashlytics2.setCustomKey(str2, sb4.toString());
            } else {
                FirebaseCrashlytics.getInstance().setCustomKey("MainTabTime " + i, getTabName(i) + " 0");
            }
            this.lastTabStartTime = System.currentTimeMillis();
            this.lastTabSelected = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSchoolDialog() {
        Link link = new Link();
        link.type = Link.LinkTypeEnum.barcodescan;
        Link.BarcodescanData barcodescanData = new Link.BarcodescanData();
        link.barcodescan_data = barcodescanData;
        link.content_description = "ورود به مدرسه ی من";
        barcodescanData.type = org.rbmain.messenger.BuildConfig.FLAVOR;
        barcodescanData.barcode = "getroles_v1";
        new MainClickHandler().onLinkClick(link);
    }

    public void setChatTabNumber() {
        try {
            this.tabLayout.getTabAt(3);
        } catch (Exception unused) {
        }
    }

    public View getTabView(int i, boolean z) {
        int color;
        UI_TabView uI_TabView = new UI_TabView();
        Context context = getContext();
        if (z) {
            color = Color.parseColor("#17DAB6");
        } else {
            color = Theme.getColor(Theme.key_actionBarDefaultIcon);
        }
        uI_TabView.createView((Activity) context, getTabText(i), color, getTabIcon(i, z));
        return uI_TabView.view;
    }

    public View setTabView(View view, int i, boolean z) {
        int color;
        try {
            LocaleController.getInstance().checkLanguage();
        } catch (Exception unused) {
        }
        UI_TabView uI_TabView = new UI_TabView();
        MyLog.e("ViewpagerPresenter", "getTabView: " + i + z);
        getContext();
        if (z) {
            color = Color.parseColor("#17DAB6");
        } else {
            color = Theme.getColor(Theme.key_actionBarDefaultIcon);
        }
        MyLog.e("ViewpagerPresenter", "getTabView: " + color + " " + getTabIcon(i, z));
        return uI_TabView.refreshView(view, getTabText(i), color, getTabIcon(i, z));
    }

    public String getTabText(int i) {
        String string = i == -1 ? LocaleController.getString(R.string.shad_service) : BuildConfig.FLAVOR;
        if (i == 4) {
            return LocaleController.getString(R.string.services_tab);
        }
        if (i == 3) {
            return LocaleController.getString("messenger_tab", R.string.messenger_tab);
        }
        if (i == -1) {
            return LocaleController.getString("RubinoName", R.string.RubinoName);
        }
        if (i == 1) {
            return LocaleController.getString("explore_tab_shad", R.string.explore_tab_shad);
        }
        if (i == -1) {
            return LocaleController.getString("settings_tab", R.string.settings_tab);
        }
        if (i == -1) {
            return LocaleController.getString(R.string.shadboum_tab);
        }
        if (i == 2) {
            return LocaleController.getString(R.string.school_tab);
        }
        return i == 0 ? LocaleController.getString("shadbin_tab", R.string.shadbin_tab) : string;
    }

    public String getTabName(int i) {
        return (i == -1 || i == 4) ? "Services" : i == 3 ? "Messenger" : i == -1 ? "Rubino" : i == 1 ? "Explore" : i == -1 ? "Setting" : i == -1 ? "contact" : i == -1 ? "call" : i == -1 ? "shadBoum" : i == 2 ? "shadSchool" : i == 0 ? "shadbinTab" : i + BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogsActivity getDialogActivity() throws Resources.NotFoundException {
        DialogsActivity dialogsActivity = this.dialogActivity;
        if (dialogsActivity == null) {
            DialogsActivity dialogsActivity2 = new DialogsActivity(null);
            this.dialogActivity = dialogsActivity2;
            dialogsActivity2.setCurrentAccount(this.currentAccount);
            this.dialogActivity.setParentLayout(this.parentLayout);
            this.dialogActivity.onFragmentCreate();
            this.dialogActivity.createView(getContext());
            this.dialogActivity.onResume();
        } else {
            dialogsActivity.onResume();
        }
        return this.dialogActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RubinoPostGridActivity getExploreFragment(ExploreDataInLink exploreDataInLink) {
        RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
        if (rubinoPostGridActivity == null) {
            RubinoPostGridActivity rubinoPostGridActivity2 = new RubinoPostGridActivity(null, true);
            this.exploreTabFragment = rubinoPostGridActivity2;
            rubinoPostGridActivity2.setCurrentAccount(this.currentAccount);
            this.exploreTabFragment.setParentLayout(this.parentLayout);
            this.exploreTabFragment.onFragmentCreate();
            this.exploreTabFragment.createView(getContext());
            this.exploreTabFragment.onResume();
        } else {
            rubinoPostGridActivity.onResume();
        }
        return this.exploreTabFragment;
    }

    public RubinoPostListActivity getRubinoFragment() {
        RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
        if (rubinoPostListActivity == null) {
            RubinoPostListActivity rubinoPostListActivity2 = new RubinoPostListActivity(RubinoPostListActivity.homeRecentFollowingType);
            this.rubinoFragment = rubinoPostListActivity2;
            rubinoPostListActivity2.setCurrentAccount(this.currentAccount);
            this.rubinoFragment.setParentLayout(this.parentLayout);
            this.rubinoFragment.onFragmentCreate();
            this.rubinoFragment.createView(getContext());
            this.rubinoFragment.onResume();
        } else {
            rubinoPostListActivity.onResume();
        }
        return this.rubinoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceFragment getServiceFragment() {
        FirebaseEventSender.sendEvent(ApplicationLoader.applicationContext, "tab_service", BuildConfig.FLAVOR);
        ServiceFragment serviceFragment = this.serviceFragment;
        if (serviceFragment == null) {
            ServiceFragment serviceFragment2 = new ServiceFragment("main");
            this.serviceFragment = serviceFragment2;
            serviceFragment2.setCurrentAccount(this.currentAccount);
            ServiceFragment serviceFragment3 = this.serviceFragment;
            serviceFragment3.isHasBackButton = false;
            serviceFragment3.isFirstPage = true;
            serviceFragment3.createView(getContext());
            this.serviceFragment.parentBaseFragmet = this.baseFragment;
        } else {
            serviceFragment.onResume();
        }
        return this.serviceFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceFragment getShadboumFragment() {
        ServiceFragment serviceFragment = this.shadboumFragment;
        if (serviceFragment == null) {
            ServiceFragment serviceFragment2 = new ServiceFragment("shadboom", LocaleController.getString(R.string.shadboum_tab));
            this.shadboumFragment = serviceFragment2;
            serviceFragment2.isHasBackButton = false;
            serviceFragment2.isFirstPage = true;
            serviceFragment2.createView(getContext());
            this.shadboumFragment.parentBaseFragmet = this.baseFragment;
        } else {
            serviceFragment.onResume();
        }
        return this.shadboumFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceFragment getSchoolFragment() {
        ServiceFragment serviceFragment = this.schoolFragment;
        if (serviceFragment == null) {
            ServiceFragment serviceFragment2 = new ServiceFragment("AuthHandler", "انتخاب نقش");
            this.schoolFragment = serviceFragment2;
            serviceFragment2.isHasBackButton = false;
            serviceFragment2.isFirstPage = true;
            serviceFragment2.createView(getContext());
            this.schoolFragment.parentBaseFragmet = this.baseFragment;
        } else {
            serviceFragment.onResume();
        }
        return this.schoolFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InlineWebviewFragment getShadbinFragment() {
        InlineWebviewFragment inlineWebviewFragment = this.shadbinFragment;
        if (inlineWebviewFragment == null) {
            Link.InlineOpenUrlObject inlineOpenUrlObject = new Link.InlineOpenUrlObject();
            inlineOpenUrlObject.url = "https://shad.ir/shadbin";
            inlineOpenUrlObject.title = LocaleController.getString(R.string.shadbin_tab);
            inlineOpenUrlObject.allow_access_camera = true;
            inlineOpenUrlObject.allow_access_file = true;
            inlineOpenUrlObject.allow_access_microphone = true;
            inlineOpenUrlObject.internal_back_enable = true;
            InlineWebviewFragment inlineWebviewFragment2 = new InlineWebviewFragment(inlineOpenUrlObject, true);
            this.shadbinFragment = inlineWebviewFragment2;
            inlineWebviewFragment2.isFirstPage = true;
            inlineWebviewFragment2.createView(getContext());
            this.shadbinFragment.parentBaseFragmet = this.baseFragment;
        } else {
            inlineWebviewFragment.onResume();
        }
        return this.shadbinFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HomePageActivityNew getServiceFragmentNew() throws Resources.NotFoundException {
        HomePageActivityNew homePageActivityNew = this.homeServiceFragmentNew;
        if (homePageActivityNew == null) {
            CardPageLinkData cardPageLinkData = new CardPageLinkData();
            cardPageLinkData.tag = "Main";
            HomePageActivityNew homePageActivityNew2 = new HomePageActivityNew(cardPageLinkData, true);
            this.homeServiceFragmentNew = homePageActivityNew2;
            homePageActivityNew2.setCurrentAccount(this.currentAccount);
            this.homeServiceFragmentNew.setParentLayout(this.parentLayout);
            this.homeServiceFragmentNew.onFragmentCreate();
            this.homeServiceFragmentNew.createView(getContext());
        } else {
            homePageActivityNew.onResume();
        }
        return this.homeServiceFragmentNew;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProfileActivity getSettingFragment() throws InterruptedException {
        ProfileActivity profileActivity = this.settingFragment;
        if (profileActivity == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("user_id", UserConfig.getInstance(this.currentAccount).clientUserId);
            ProfileActivity profileActivity2 = new ProfileActivity(bundle);
            this.settingFragment = profileActivity2;
            profileActivity2.setCurrentAccount(this.currentAccount);
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            ActionBarLayout actionBarLayout = this.parentLayout;
            firebaseCrashlytics.setCustomKey("MainTabGetSetting", actionBarLayout != null ? actionBarLayout.toString() : "null");
            this.settingFragment.setParentLayout(this.parentLayout);
            this.settingFragment.onFragmentCreate();
            this.settingFragment.createView(getContext());
        } else {
            profileActivity.onResume();
        }
        return this.settingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContactsActivity getContactFragment() {
        ContactsActivity contactsActivity = this.contactFragment;
        if (contactsActivity == null) {
            ContactsActivity contactsActivity2 = new ContactsActivity(null);
            this.contactFragment = contactsActivity2;
            contactsActivity2.setCurrentAccount(this.currentAccount);
            this.contactFragment.setParentLayout(this.parentLayout);
            this.contactFragment.onFragmentCreate();
            this.contactFragment.createView(getContext());
        } else {
            contactsActivity.onResume();
        }
        return this.contactFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CallLogActivity getCallFragment() {
        CallLogActivity callLogActivity = this.callFragment;
        if (callLogActivity == null) {
            CallLogActivity callLogActivity2 = new CallLogActivity();
            this.callFragment = callLogActivity2;
            callLogActivity2.setCurrentAccount(this.currentAccount);
            this.callFragment.setParentLayout(this.parentLayout);
            this.callFragment.onFragmentCreate();
            this.callFragment.createView(getContext());
        } else {
            callLogActivity.onResume();
        }
        return this.callFragment;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ServiceFragment serviceFragment = this.serviceFragment;
        if (serviceFragment != null) {
            serviceFragment.onConfigurationChanged(configuration);
        }
        HomePageActivityNew homePageActivityNew = this.homeServiceFragmentNew;
        if (homePageActivityNew != null) {
            homePageActivityNew.onConfigurationChanged(configuration);
        }
        HomeFragment homeFragment = this.homeFragmentTab;
        if (homeFragment != null) {
            homeFragment.onConfigurationChanged(configuration);
        }
        ProfileActivity profileActivity = this.settingFragment;
        if (profileActivity != null) {
            profileActivity.onConfigurationChanged(configuration);
        }
        DialogsActivity dialogsActivity = this.dialogActivity;
        if (dialogsActivity != null) {
            dialogsActivity.onConfigurationChanged(configuration);
        }
        ServiceFragment serviceFragment2 = this.paymentFragment;
        if (serviceFragment2 != null) {
            serviceFragment2.onConfigurationChanged(configuration);
        }
        RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
        if (rubinoPostListActivity != null) {
            rubinoPostListActivity.onConfigurationChanged(configuration);
        }
        RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
        if (rubinoPostGridActivity != null) {
            rubinoPostGridActivity.onConfigurationChanged(configuration);
        }
        ContactsActivity contactsActivity = this.contactFragment;
        if (contactsActivity != null) {
            contactsActivity.onConfigurationChanged(configuration);
        }
        CallLogActivity callLogActivity = this.callFragment;
        if (callLogActivity != null) {
            callLogActivity.onConfigurationChanged(configuration);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        super.onDialogDismiss(dialog);
        Dialog dialog2 = this.permissionDialog;
        if (dialog2 == null || dialog != dialog2) {
            return;
        }
        getParentActivity();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyVisible() {
        super.onBecomeFullyVisible();
    }

    public void reCreateRubinoTab() {
        RubinoPostListActivity rubinoPostListActivity = this.rubinoFragment;
        if (rubinoPostListActivity != null) {
            rubinoPostListActivity.onPause();
            this.rubinoFragment.onFragmentDestroy();
            this.rubinoFragment = null;
            try {
                this.fragmentContrainer.removeAllViews();
            } catch (Exception unused) {
            }
            replaceRubinoFragment();
        }
    }

    public void reCreateExploreTab() {
        RubinoPostGridActivity rubinoPostGridActivity = this.exploreTabFragment;
        if (rubinoPostGridActivity != null) {
            rubinoPostGridActivity.onPause();
            this.exploreTabFragment.onFragmentDestroy();
            this.exploreTabFragment = null;
            try {
                this.fragmentContrainer.removeAllViews();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceRubinoFragment() {
        RubinoPostListActivity rubinoFragment = getRubinoFragment();
        this.fragmentContrainer.addView(rubinoFragment.getFragmentView());
        ((FrameLayout.LayoutParams) rubinoFragment.getFragmentView().getLayoutParams()).topMargin = AndroidUtilities.dp(48.0f);
        ActionBar actionBar = rubinoFragment.getActionBar();
        actionBar.setClipChildren(true);
        actionBar.setClipToPadding(true);
        this.fragmentContrainer.addView(actionBar, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    private void replaceRubinoFragmentFull() {
        presentFragment(getRubinoFragment());
    }

    protected void clearAllTabs() {
        this.fragmentContrainer.removeAllViews();
        destroyServiceFragment();
        destroyNewServiceFragment();
        destroyChatFragment();
        destroyRubinoFragment();
        destroyExploreFragment();
        destroySettingFragment();
        destroyContactFragment();
        destroyCallFragment();
        destroyShadbinFragment();
        destroySchoolFragment();
        destroyShadboumFragment();
    }
}
