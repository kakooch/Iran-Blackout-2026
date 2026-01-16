package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.LoadListener;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UI_RowTextViewAndProgress;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.TextViewItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class SetUserNameFragment extends PresenterFragment {
    private static final Pattern sPattern = Pattern.compile("^[a-z0-9_]{7,32}$");
    private ButtonPresenter.MyViewHolder buttonPresenterHolder;
    private int checkingUserNameCall;
    public String rubinoPageUserName;
    private TextViewPresenter.MyViewHolder textViewHolder;
    private UI_RowTextViewAndProgress uiRowTextViewAndProgress;
    EditTextPresenter.MyViewHolder userNameViewHolder;
    String setUserNameRule = LocaleController.getString("UsernameHelp2", R.string.UsernameHelp2);
    String checkingUserName = BuildConfig.FLAVOR;
    boolean isCheckingUserNameValid = false;
    private Handler handler = new Handler();
    Runnable runnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.4
        @Override // java.lang.Runnable
        public void run() {
            SetUserNameFragment.this.requestCheckUserName(false);
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public SetUserNameFragment(String str) {
        this.rubinoPageUserName = BuildConfig.FLAVOR;
        this.rubinoPageUserName = str;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString("Username", R.string.Username));
        makeLayout(this.rubinoPageUserName);
    }

    void makeLayout(String str) {
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem(this.setUserNameRule));
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new EditTextPresenter(this.mContext).createViewHolderAndBind(new EditTextItem(str, LocaleController.getString("Username", R.string.Username)));
        this.userNameViewHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                SetUserNameFragment.this.uiRowTextViewAndProgress.textView.setText(BuildConfig.FLAVOR);
                if (SetUserNameFragment.this.checkingUserNameCall != 0) {
                    SetUserNameFragment.this.getCoreMainClass().cancelRequest(SetUserNameFragment.this.checkingUserNameCall);
                    SetUserNameFragment.this.checkingUserNameCall = 0;
                }
                SetUserNameFragment.this.cancelTimer();
                SetUserNameFragment.this.startTimer();
            }
        });
        this.userNameViewHolder.edittext.setLines(1);
        UI_RowTextViewAndProgress uI_RowTextViewAndProgress = new UI_RowTextViewAndProgress();
        this.uiRowTextViewAndProgress = uI_RowTextViewAndProgress;
        uI_RowTextViewAndProgress.createView((Activity) this.mContext);
        this.uiRowTextViewAndProgress.progressBar.setVisibility(4);
        this.uiRowTextViewAndProgress.textView.setVisibility(0);
        this.uiRowTextViewAndProgress.textView.setText(BuildConfig.FLAVOR);
        this.uiRowTextViewAndProgress.textView.setGravity(5);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.userNameViewHolder.itemView);
        this.linearLayout.addView(this.uiRowTextViewAndProgress.view);
        ButtonPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem(LocaleController.getString("Set", R.string.Set), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!SetUserNameFragment.this.isValid(NumberUtils.toEnglish(SetUserNameFragment.this.userNameViewHolder.edittext.getText().toString().replace(" ", BuildConfig.FLAVOR).trim()))) {
                    SetUserNameFragment setUserNameFragment = SetUserNameFragment.this;
                    ToastiLikeSnack.showL(setUserNameFragment.mContext, setUserNameFragment.setUserNameRule);
                    return;
                }
                SetUserNameFragment setUserNameFragment2 = SetUserNameFragment.this;
                if (setUserNameFragment2.isCheckingUserNameValid) {
                    if (ApplicationLoader.applicationActivity != null) {
                        if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof InstaAddPageFragment) {
                            ((InstaAddPageFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).onUserNameChanged(SetUserNameFragment.this.checkingUserName);
                            ApplicationLoader.applicationActivity.onBackPressed();
                        }
                        BaseFragment secondLastFragment = ApplicationLoader.applicationActivity.getSecondLastFragment();
                        if (secondLastFragment instanceof InstaEditProfileFragment) {
                            ((InstaEditProfileFragment) secondLastFragment).onUserNameChanged(SetUserNameFragment.this.checkingUserName);
                            ApplicationLoader.applicationActivity.onBackPressed();
                            return;
                        }
                        return;
                    }
                    return;
                }
                setUserNameFragment2.cancelTimer();
                SetUserNameFragment.this.requestCheckUserName(true);
            }
        }));
        this.buttonPresenterHolder = myViewHolderCreateViewHolderAndBind2;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind2.itemView);
        this.linearLayout.addView(this.textViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid(String str) {
        return sPattern.matcher(str.toLowerCase()).matches();
    }

    void requestCheckUserName(boolean z) {
        String english = NumberUtils.toEnglish(this.userNameViewHolder.edittext.getText().toString().trim());
        if (isValid(english)) {
            this.uiRowTextViewAndProgress.progressBar.setVisibility(0);
            this.uiRowTextViewAndProgress.textView.setText(LocaleController.getString("UsernameChecking", R.string.UsernameChecking));
            this.uiRowTextViewAndProgress.textView.setTextColor(getContext().getResources().getColor(R.color.grey_700));
            this.checkingUserName = english;
            this.isCheckingUserNameValid = false;
            this.checkingUserNameCall = getCoreMainClass().checkRubinoUsername(english, new LoadListener<CoreUtilities.UsernameCheckType>() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.3
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(final CoreUtilities.UsernameCheckType usernameCheckType) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SetUserNameFragment.this.checkingUserNameCall = 0;
                            SetUserNameFragment.this.uiRowTextViewAndProgress.progressBar.setVisibility(4);
                            if (usernameCheckType == CoreUtilities.UsernameCheckType.Exist) {
                                SetUserNameFragment.this.uiRowTextViewAndProgress.progressBar.setVisibility(4);
                                SetUserNameFragment.this.uiRowTextViewAndProgress.textView.setText(LocaleController.getString("UsernameInUse", R.string.UsernameInUse));
                                SetUserNameFragment.this.uiRowTextViewAndProgress.textView.setTextColor(SetUserNameFragment.this.getContext().getResources().getColor(R.color.red_700));
                            } else {
                                SetUserNameFragment.this.uiRowTextViewAndProgress.progressBar.setVisibility(4);
                                SetUserNameFragment.this.uiRowTextViewAndProgress.textView.setText(LocaleController.formatString("UsernameAvailable", R.string.UsernameAvailable, SetUserNameFragment.this.checkingUserName));
                                SetUserNameFragment.this.uiRowTextViewAndProgress.textView.setTextColor(SetUserNameFragment.this.getContext().getResources().getColor(R.color.green_700));
                                SetUserNameFragment.this.isCheckingUserNameValid = true;
                            }
                        }
                    });
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.SetUserNameFragment.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SetUserNameFragment.this.uiRowTextViewAndProgress.progressBar.setVisibility(4);
                            SetUserNameFragment.this.checkingUserNameCall = 0;
                        }
                    });
                }
            });
        }
    }

    public void startTimer() {
        this.handler.postDelayed(this.runnable, 900L);
    }

    public void cancelTimer() {
        this.handler.removeCallbacks(this.runnable);
        if (this.checkingUserNameCall != 0) {
            getCoreMainClass().cancelRequest(this.checkingUserNameCall);
            this.checkingUserNameCall = 0;
        }
    }
}
