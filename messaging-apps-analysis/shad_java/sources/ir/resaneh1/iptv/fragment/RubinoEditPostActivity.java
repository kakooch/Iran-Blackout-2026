package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIInstaRowTextViewAndSwitch;
import ir.resaneh1.iptv.UIInstaTextViewRow;
import ir.resaneh1.iptv.UIInstaUserInfoRow;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarProgressBar;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class RubinoEditPostActivity extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    public boolean isFirstBack = true;
    RubinoPostObject postObject;
    ToolbarImageView toolbarImageViewCheck;
    private ToolbarImageView toolbarImageViewClose;
    private ToolbarProgressBar toolbarProgressbar;
    ToolbarTextView toolbarTextView;
    UIInstaTextViewRow uiAddType;
    UIInstaUserInfoRow uiCaption;
    UIInstaUserInfoRow uiCost;
    UIInstaRowTextViewAndSwitch uiSwitchIsAllowShowComment;
    UIInstaRowTextViewAndSwitch uiSwitchPay;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public RubinoEditPostActivity(RubinoPostObject rubinoPostObject) {
        this.postObject = rubinoPostObject;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoPostEdited);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoPostEditedFailed);
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoPostEdited);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoPostEditedFailed);
        super.onFragmentDestroy();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        setToolbar();
        makeLayout();
    }

    private void makeLayout() {
        UIInstaUserInfoRow uIInstaUserInfoRow = new UIInstaUserInfoRow();
        this.uiCaption = uIInstaUserInfoRow;
        Activity activity = (Activity) this.mContext;
        String string = LocaleController.getString(R.string.text);
        String str = this.postObject.post.caption;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        uIInstaUserInfoRow.createView(activity, string, str, false, null);
        UIInstaUserInfoRow uIInstaUserInfoRow2 = this.uiCaption;
        uIInstaUserInfoRow2.hasVerticalLine = true;
        uIInstaUserInfoRow2.editText.setSingleLine(false);
        this.uiCaption.editText.setImeOptions(1073741824);
        this.uiCaption.editText.setFilters(new InputFilter[]{InputFilterHelper.getFilter(2200, 50, this.uiCaption.view)[0], new InputFilter() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence == null || TextUtils.indexOf(charSequence, '#') == -1 || spanned.length() - spanned.toString().replace("#", BuildConfig.FLAVOR).length() < 15) {
                    return null;
                }
                View view = RubinoEditPostActivity.this.uiCaption.view;
                if (view != null) {
                    AndroidUtilities.shakeView(view, 2.0f, 0);
                }
                return BuildConfig.FLAVOR;
            }
        }});
        this.uiCaption.editText.setMaxLines(10);
        this.uiCaption.editText.requestFocus();
        this.linearLayout.addView(this.uiCaption.view);
        View viewInflate = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate2 = View.inflate(this.mContext, R.layout.row_space, null);
        this.linearLayout.addView(viewInflate);
        UIInstaRowTextViewAndSwitch uIInstaRowTextViewAndSwitch = new UIInstaRowTextViewAndSwitch();
        this.uiSwitchIsAllowShowComment = uIInstaRowTextViewAndSwitch;
        uIInstaRowTextViewAndSwitch.createView((Activity) this.mContext, LocaleController.getString(R.string.send_comment_privillage), true, this.postObject.post.allow_show_comment, false);
        this.uiSwitchIsAllowShowComment.textViewDescription.setVisibility(0);
        this.uiSwitchIsAllowShowComment.textViewDescription.setText(LocaleController.getString(R.string.prevent_comment_action));
        this.linearLayout.addView(this.uiSwitchIsAllowShowComment.view);
        UIInstaRowTextViewAndSwitch uIInstaRowTextViewAndSwitch2 = new UIInstaRowTextViewAndSwitch();
        this.uiSwitchPay = uIInstaRowTextViewAndSwitch2;
        uIInstaRowTextViewAndSwitch2.createView((Activity) this.mContext, LocaleController.getString(R.string.payment_ability), true, this.postObject.post.is_for_sale, false);
        this.uiSwitchPay.textViewDescription.setVisibility(0);
        this.uiSwitchPay.textViewDescription.setText(LocaleController.getString(R.string.users_payment_privillage));
        this.uiSwitchPay.mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RubinoEditPostActivity rubinoEditPostActivity = RubinoEditPostActivity.this;
                rubinoEditPostActivity.uiSwitchPay.isSwitchChange = true;
                if (z) {
                    rubinoEditPostActivity.uiCost.view.setVisibility(0);
                    RubinoEditPostActivity.this.uiAddType.view.setVisibility(0);
                    RubinoEditPostActivity.this.uiCost.editText.requestFocus();
                } else {
                    rubinoEditPostActivity.uiCost.view.setVisibility(8);
                    RubinoEditPostActivity.this.uiAddType.view.setVisibility(8);
                }
            }
        });
        this.uiCost = new UIInstaUserInfoRow();
        if (this.postObject.post.sale_price > 0) {
            str2 = this.postObject.post.sale_price + BuildConfig.FLAVOR;
        }
        this.uiCost.createView((Activity) this.mContext, LocaleController.getString(R.string.toman_price), str2, false, null);
        this.uiCost.editText.setSingleLine(true);
        this.uiCost.editText.setMaxLines(1);
        this.uiCost.editText.setInputType(3);
        this.uiCost.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MyLog.e("EditTextCardNoPresenter", "onTextChanged: " + i + " " + i2 + " " + i3);
                if (charSequence.toString().equals(RubinoEditPostActivity.this.uiCost.current)) {
                    return;
                }
                if (i2 == 0) {
                    RubinoEditPostActivity.this.uiCost.isDelete = false;
                    i++;
                } else {
                    RubinoEditPostActivity.this.uiCost.isDelete = true;
                }
                RubinoEditPostActivity.this.uiCost.editText.removeTextChangedListener(this);
                String format = EditTextCostPresenter.setFormat(charSequence.toString().replace(EditTextCostPresenter.space, BuildConfig.FLAVOR));
                UIInstaUserInfoRow uIInstaUserInfoRow3 = RubinoEditPostActivity.this.uiCost;
                uIInstaUserInfoRow3.current = format;
                uIInstaUserInfoRow3.editText.setText(format);
                int length = i + (format.length() - charSequence.length());
                int length2 = length >= 0 ? length : 0;
                if (length2 > format.length()) {
                    length2 = format.length();
                }
                RubinoEditPostActivity.this.uiCost.editText.setSelection(length2);
                RubinoEditPostActivity.this.uiCost.editText.addTextChangedListener(this);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string2 = RubinoEditPostActivity.this.uiCost.editText.getText().toString();
                UIInstaUserInfoRow uIInstaUserInfoRow3 = RubinoEditPostActivity.this.uiCost;
                uIInstaUserInfoRow3.isChanged = true;
                uIInstaUserInfoRow3.text = string2;
            }
        });
        UIInstaTextViewRow uIInstaTextViewRow = new UIInstaTextViewRow();
        this.uiAddType = uIInstaTextViewRow;
        uIInstaTextViewRow.createView((Activity) this.mContext, LocaleController.getString(R.string.add_new_features), true, null);
        this.uiAddType.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoAddPostTypeActivity rubinoAddPostTypeActivity = new RubinoAddPostTypeActivity(RubinoEditPostActivity.this.postObject);
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(rubinoAddPostTypeActivity);
                }
            }
        });
        if (AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().sale_permission) {
            this.linearLayout.addView(viewInflate2);
            this.linearLayout.addView(this.uiSwitchPay.view);
            if (this.postObject.post.is_for_sale) {
                this.uiCost.view.setVisibility(0);
                this.uiAddType.view.setVisibility(0);
            } else {
                this.uiCost.view.setVisibility(8);
                this.uiAddType.view.setVisibility(8);
            }
            this.linearLayout.addView(this.uiCost.view);
            this.linearLayout.addView(this.uiAddType.view);
        }
    }

    public boolean hasChange() {
        return this.uiSwitchIsAllowShowComment.isSwitchChange || this.uiCaption.isChanged || this.uiSwitchPay.isSwitchChange || this.uiCost.isChanged || this.postObject.isProductTypesChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditClick() {
        Boolean bool;
        String english;
        this.isFirstBack = false;
        if (hasChange()) {
            RubinoPostObject rubinoPostObject = this.postObject;
            String[] strArr = rubinoPostObject.post.product_types;
            String[] strArr2 = (strArr == null || !rubinoPostObject.isProductTypesChange) ? null : strArr;
            UIInstaRowTextViewAndSwitch uIInstaRowTextViewAndSwitch = this.uiSwitchIsAllowShowComment;
            Boolean boolValueOf = uIInstaRowTextViewAndSwitch.isSwitchChange ? Boolean.valueOf(uIInstaRowTextViewAndSwitch.mySwitch.isChecked()) : null;
            UIInstaRowTextViewAndSwitch uIInstaRowTextViewAndSwitch2 = this.uiSwitchPay;
            if (uIInstaRowTextViewAndSwitch2.isSwitchChange || this.uiCost.isChanged) {
                Boolean boolValueOf2 = Boolean.valueOf(uIInstaRowTextViewAndSwitch2.mySwitch.isChecked());
                if (!this.uiSwitchPay.mySwitch.isChecked()) {
                    bool = boolValueOf2;
                    english = null;
                } else {
                    if (!isValidCost(this.uiCost.editText.getText().toString())) {
                        if (this.uiCost.editText.getText().toString().isEmpty()) {
                            ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.enter_price));
                            return;
                        } else {
                            ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.enter_price_with_filter));
                            return;
                        }
                    }
                    bool = boolValueOf2;
                    english = NumberUtils.toEnglish(this.uiCost.editText.getText().toString().replace(EditTextCostPresenter.space, BuildConfig.FLAVOR));
                }
            } else {
                bool = null;
                english = null;
            }
            UIInstaUserInfoRow uIInstaUserInfoRow = this.uiCaption;
            String str = uIInstaUserInfoRow.isChanged ? uIInstaUserInfoRow.text : null;
            this.toolbarProgressbar.view.setVisibility(0);
            this.toolbarImageViewCheck.view.setVisibility(8);
            this.toolbarTextView.view.setVisibility(8);
            getRubinoController().editPost(((PresenterFragment) this).compositeDisposable, this.postObject.post.id, str, boolValueOf, bool, english, strArr2);
            return;
        }
        ApplicationLoader.applicationActivity.onBackPressed();
    }

    private boolean isValidCost(String str) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            Long lValueOf = Long.valueOf(Long.parseLong(NumberUtils.toEnglish(str.replace(EditTextCostPresenter.space, BuildConfig.FLAVOR))));
            if (lValueOf.longValue() >= 500) {
                return lValueOf.longValue() <= 10000000;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_100));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextView = toolbarTextView;
        toolbarTextView.createView((Activity) this.mContext, LocaleController.getString(R.string.save), R.color.grey_700);
        this.toolbarTextView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoEditPostActivity.this.onEditClick();
            }
        });
        ToolbarProgressBar toolbarProgressBar = new ToolbarProgressBar();
        this.toolbarProgressbar = toolbarProgressBar;
        toolbarProgressBar.createView((Activity) this.mContext);
        this.toolbarProgressbar.view.setVisibility(8);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_check_grey);
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoEditPostActivity.this.onEditClick();
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        this.toolbarImageViewClose = toolbarImageView2;
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_close_grey_700);
        this.toolbarImageViewClose.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.7
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
        this.toolbarMaker.addViewToLeftLayout(this.toolbarImageViewClose.view);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.isFirstBack && hasChange()) {
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, LocaleController.getString(R.string.apply_changes));
            threeButtonDialog.button2.setText(LocaleController.getString(R.string.no));
            threeButtonDialog.button1.setText(LocaleController.getString(R.string.confirm));
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                    if (ApplicationLoader.applicationActivity != null) {
                        RubinoEditPostActivity.this.isFirstBack = false;
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                }
            });
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoEditPostActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RubinoEditPostActivity.this.onEditClick();
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.rubinoPostEdited) {
            if (((String) objArr[0]).equals(this.postObject.post.id)) {
                this.progressBar.setVisibility(4);
                this.toolbarProgressbar.view.setVisibility(8);
                this.toolbarImageViewCheck.view.setVisibility(0);
                this.toolbarTextView.view.setVisibility(0);
                if (ApplicationLoader.applicationActivity != null) {
                    if (ApplicationLoader.applicationActivity.getLastFragment() == this) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                        return;
                    } else {
                        removeSelfFromStack();
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoPostEditedFailed && ((String) objArr[0]).equals(this.postObject.post.id)) {
            this.progressBar.setVisibility(4);
            this.toolbarProgressbar.view.setVisibility(8);
            this.toolbarImageViewCheck.view.setVisibility(0);
            this.toolbarTextView.view.setVisibility(0);
        }
    }
}
