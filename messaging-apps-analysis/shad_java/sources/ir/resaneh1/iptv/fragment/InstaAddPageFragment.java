package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIInstaUserInfoRow;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarProgressBar;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class InstaAddPageFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    private DisposableObserver disposable;
    Rubino.CreateProfileInput input;
    public boolean isFirstBack = true;
    View.OnClickListener onUsernmaeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InstaAddPageFragment.this.presentFragment(new SetUserNameFragment(InstaAddPageFragment.this.uiUserNameRow.editText.getText().toString()));
        }
    };
    private ToolbarImageView toolbarImageViewCheck;
    private ToolbarProgressBar toolbarProgressbar;
    ToolbarTextView toolbarTextView;
    private UIInstaUserInfoRow uiBioRow;
    private UIInstaUserInfoRow uiEmailRow;
    private UIInstaUserInfoRow uiNameRow;
    private UIInstaUserInfoRow uiPhoneRow;
    private UIInstaUserInfoRow uiUserNameRow;
    private UIInstaUserInfoRow uiWebsiteRow;
    public String username;
    private static final Pattern telPattern = Pattern.compile("\\d+$");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_header_linear;
    }

    public InstaAddPageFragment() {
        this.fragmentName = "InstaAddPageFragment";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        super.findView();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setContentScrimResource(R.drawable.transparent);
        }
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        this.input = new Rubino.CreateProfileInput();
        setToolbar();
        setUserInfoView();
    }

    void onUserNameChanged(String str) {
        this.input.username = str;
        this.uiUserNameRow.textView.setText(str);
        this.uiUserNameRow.isChanged = true;
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_100));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextView = toolbarTextView;
        toolbarTextView.createView((Activity) this.mContext, LocaleController.getString(R.string.save), R.color.grey_700);
        this.toolbarTextView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaAddPageFragment.this.onEditClick();
            }
        });
        ToolbarProgressBar toolbarProgressBar = new ToolbarProgressBar();
        this.toolbarProgressbar = toolbarProgressBar;
        toolbarProgressBar.createView((Activity) this.mContext);
        this.toolbarProgressbar.view.setVisibility(8);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_check_grey);
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaAddPageFragment.this.onEditClick();
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_close_grey_700);
        toolbarImageView2.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }
        });
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewCheck.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarProgressbar.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarTextView.view);
        this.toolbarMaker.addViewToLeftLayout(toolbarImageView2.view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditClick() {
        this.isFirstBack = false;
        if (hasChange()) {
            String str = this.input.username;
            if (str == null || str.isEmpty()) {
                ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.create_username));
                return;
            }
            UIInstaUserInfoRow uIInstaUserInfoRow = this.uiEmailRow;
            if (uIInstaUserInfoRow.isChanged) {
                if (uIInstaUserInfoRow.text.equals(BuildConfig.FLAVOR) || isValidEmail(this.uiEmailRow.text)) {
                    this.input.email = this.uiEmailRow.editText.getText().toString();
                } else {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.incorrect_email));
                    return;
                }
            }
            UIInstaUserInfoRow uIInstaUserInfoRow2 = this.uiBioRow;
            if (uIInstaUserInfoRow2.isChanged) {
                this.input.bio = uIInstaUserInfoRow2.editText.getText().toString();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow3 = this.uiNameRow;
            if (uIInstaUserInfoRow3.isChanged) {
                this.input.name = uIInstaUserInfoRow3.editText.getText().toString().trim();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow4 = this.uiWebsiteRow;
            if (uIInstaUserInfoRow4.isChanged) {
                this.input.website = uIInstaUserInfoRow4.editText.getText().toString().trim();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow5 = this.uiPhoneRow;
            if (uIInstaUserInfoRow5.isChanged) {
                if (uIInstaUserInfoRow5.text.equals(BuildConfig.FLAVOR) || isValidPhone(this.uiPhoneRow.text)) {
                    this.input.phone = this.uiPhoneRow.editText.getText().toString().trim();
                } else {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.phoneError3));
                    return;
                }
            }
            DisposableObserver disposableObserver = this.disposable;
            if (disposableObserver == null || disposableObserver.isDisposed()) {
                this.toolbarProgressbar.view.setVisibility(0);
                this.toolbarImageViewCheck.view.setVisibility(8);
                DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().createPage(this.input).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetProfileInfoOutput>>() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.7
                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<Rubino.GetProfileInfoOutput> messangerOutput) {
                        ArrayList<RubinoProfileObject> arrayList;
                        InstaAddPageFragment.this.progressBar.setVisibility(4);
                        InstaAddPageFragment.this.toolbarProgressbar.view.setVisibility(8);
                        InstaAddPageFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                        Rubino.GetProfileInfoOutput getProfileInfoOutput = messangerOutput.data;
                        if (getProfileInfoOutput.profile != null) {
                            Rubino.GetProfileListOutput profilesOutput2 = AppRubinoPreferences.getInstance(((BaseFragment) InstaAddPageFragment.this).currentAccount).getProfilesOutput2();
                            if (profilesOutput2 != null && (arrayList = profilesOutput2.profiles) != null) {
                                arrayList.add(getProfileInfoOutput.profile);
                            }
                            AppRubinoPreferences.getInstance(((BaseFragment) InstaAddPageFragment.this).currentAccount).setRubinoProfilesOutput(profilesOutput2);
                            new MainClickHandler().changeRubinoProfile(getProfileInfoOutput.profile);
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        InstaAddPageFragment.this.toolbarProgressbar.view.setVisibility(8);
                        InstaAddPageFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                        InstaAddPageFragment.this.progressBar.setVisibility(4);
                        ToastiLikeSnack.showL(InstaAddPageFragment.this.mContext, LocaleController.getString(R.string.error_on_creating_new_page));
                        InstaAddPageFragment.this.disposable.dispose();
                    }

                    @Override // io.reactivex.Observer
                    public void onComplete() {
                        InstaAddPageFragment.this.disposable.dispose();
                    }
                });
                this.disposable = disposableObserver2;
                ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
                return;
            }
            return;
        }
        if (ApplicationLoader.applicationActivity != null) {
            this.isFirstBack = false;
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    }

    private void setUserInfoView() {
        if (this.linearLayout == null) {
            return;
        }
        UIInstaUserInfoRow uIInstaUserInfoRow = new UIInstaUserInfoRow();
        this.uiUserNameRow = uIInstaUserInfoRow;
        uIInstaUserInfoRow.isEditable = false;
        uIInstaUserInfoRow.createView((Activity) this.mContext, LocaleController.getString(R.string.username), BuildConfig.FLAVOR, true, this.onUsernmaeClickListener);
        this.uiUserNameRow.editText.setVisibility(4);
        this.uiUserNameRow.textView.setVisibility(0);
        this.uiUserNameRow.view.setOnClickListener(this.onUsernmaeClickListener);
        String str = this.username;
        if (str != null) {
            onUserNameChanged(str);
        }
        UIInstaUserInfoRow uIInstaUserInfoRow2 = new UIInstaUserInfoRow();
        this.uiNameRow = uIInstaUserInfoRow2;
        uIInstaUserInfoRow2.createView((Activity) this.mContext, LocaleController.getString(R.string.page_name), BuildConfig.FLAVOR, false, null);
        UIInstaUserInfoRow uIInstaUserInfoRow3 = this.uiNameRow;
        uIInstaUserInfoRow3.editText.setFilters(InputFilterHelper.getFilter(70, 1, uIInstaUserInfoRow3.view));
        UIInstaUserInfoRow uIInstaUserInfoRow4 = new UIInstaUserInfoRow();
        this.uiBioRow = uIInstaUserInfoRow4;
        uIInstaUserInfoRow4.createView((Activity) this.mContext, LocaleController.getString(R.string.biography), BuildConfig.FLAVOR, false, null);
        this.uiBioRow.editText.setMinLines(2);
        UIInstaUserInfoRow uIInstaUserInfoRow5 = this.uiBioRow;
        uIInstaUserInfoRow5.editText.setFilters(InputFilterHelper.getFilter(ImageReceiver.DEFAULT_CROSSFADE_DURATION, 10, uIInstaUserInfoRow5.view));
        this.uiBioRow.editText.setMaxLines(10);
        this.uiBioRow.editText.setSingleLine(false);
        this.uiBioRow.editText.setImeOptions(1073741824);
        UIInstaUserInfoRow uIInstaUserInfoRow6 = new UIInstaUserInfoRow();
        this.uiEmailRow = uIInstaUserInfoRow6;
        uIInstaUserInfoRow6.createView((Activity) this.mContext, LocaleController.getString(R.string.email_address), BuildConfig.FLAVOR, false, null);
        UIInstaUserInfoRow uIInstaUserInfoRow7 = new UIInstaUserInfoRow();
        this.uiPhoneRow = uIInstaUserInfoRow7;
        uIInstaUserInfoRow7.createView((Activity) this.mContext, LocaleController.getString(R.string.phone_number), BuildConfig.FLAVOR, false, null);
        UIInstaUserInfoRow uIInstaUserInfoRow8 = new UIInstaUserInfoRow();
        this.uiWebsiteRow = uIInstaUserInfoRow8;
        uIInstaUserInfoRow8.createView((Activity) this.mContext, LocaleController.getString(R.string.website), BuildConfig.FLAVOR, false, null);
        View viewInflate = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate2 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate3 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate4 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate5 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate6 = View.inflate(this.mContext, R.layout.row_space, null);
        this.linearLayout.addView(viewInflate);
        this.linearLayout.addView(this.uiUserNameRow.view);
        this.linearLayout.addView(viewInflate3);
        this.linearLayout.addView(this.uiNameRow.view);
        this.linearLayout.addView(viewInflate2);
        this.linearLayout.addView(this.uiBioRow.view);
        this.linearLayout.addView(viewInflate5);
        this.linearLayout.addView(this.uiEmailRow.view);
        this.linearLayout.addView(viewInflate4);
        this.linearLayout.addView(this.uiPhoneRow.view);
        this.linearLayout.addView(viewInflate6);
        this.linearLayout.addView(this.uiWebsiteRow.view);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i != 4 || iArr == null || iArr.length <= 0) {
            return;
        }
        int i2 = iArr[0];
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.isFirstBack && hasChange()) {
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, LocaleController.getString(R.string.save_changes));
            threeButtonDialog.button1.setText(LocaleController.getString(R.string.confirm));
            threeButtonDialog.button2.setText(LocaleController.getString(R.string.no));
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                    InstaAddPageFragment.this.onEditClick();
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaAddPageFragment.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ApplicationLoader.applicationActivity != null) {
                        InstaAddPageFragment.this.isFirstBack = false;
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return false;
        }
        return super.onBackPressed();
    }

    private boolean hasChange() {
        return this.uiUserNameRow.isChanged || this.uiNameRow.isChanged || this.uiBioRow.isChanged || this.uiEmailRow.isChanged || this.uiPhoneRow.isChanged || this.uiWebsiteRow.isChanged;
    }

    public static boolean isValidEmail(String str) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(str).find();
    }

    private boolean isValidPhone(String str) {
        String strReplace = NumberUtils.toEnglish(str).replace(" ", BuildConfig.FLAVOR).replace("-", BuildConfig.FLAVOR).replace("+", BuildConfig.FLAVOR);
        if (strReplace.length() >= 15 || strReplace.length() <= 2) {
            return false;
        }
        return telPattern.matcher(strReplace).matches();
    }
}
