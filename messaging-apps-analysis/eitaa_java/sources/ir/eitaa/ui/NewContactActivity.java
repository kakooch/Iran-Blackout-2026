package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_contacts_importContacts;
import ir.eitaa.tgnet.TLRPC$TL_contacts_importedContacts;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoneContact;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.HintEditText;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.CountrySelectActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class NewContactActivity extends BaseFragment implements AdapterView.OnItemSelectedListener {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImage;
    private EditTextBoldCursor codeField;
    private LinearLayout contentLayout;
    private TextView countryButton;
    private int countryState;
    private boolean donePressed;
    private ActionBarMenuItem editDoneItem;
    private AnimatorSet editDoneItemAnimation;
    private ContextProgressView editDoneItemProgress;
    private EditTextBoldCursor firstNameField;
    private boolean ignoreOnPhoneChange;
    private boolean ignoreOnTextChange;
    private boolean ignoreSelection;
    private String initialFirstName;
    private String initialLastName;
    private String initialPhoneNumber;
    private boolean initialPhoneNumberWithCountryCode;
    private EditTextBoldCursor lastNameField;
    private View lineView;
    private HintEditText phoneField;
    private TextView textView;
    private ArrayList<String> countriesArray = new ArrayList<>();
    private HashMap<String, String> countriesMap = new HashMap<>();
    private HashMap<String, String> codesMap = new HashMap<>();
    private HashMap<String, String> phoneFormatMap = new HashMap<>();

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws IOException {
        boolean z;
        String str;
        TelephonyManager telephonyManager;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("AddContactTitle", R.string.AddContactTitle));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setInfo(5L, "", "");
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        this.editDoneItem = actionBarMenuItemAddItemWithWidth;
        actionBarMenuItemAddItemWithWidth.setContentDescription(LocaleController.getString("Done", R.string.Done));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.editDoneItemProgress = contextProgressView;
        this.editDoneItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1.0f));
        this.editDoneItemProgress.setVisibility(4);
        this.fragmentView = new ScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.contentLayout = linearLayout;
        linearLayout.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        this.contentLayout.setOrientation(1);
        ((ScrollView) this.fragmentView).addView(this.contentLayout, LayoutHelper.createScroll(-1, -2, 51));
        this.contentLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$KNTfF0qutTI61SWDTYazEFEOosw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NewContactActivity.lambda$createView$0(view, motionEvent);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.contentLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 24.0f, 0.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImage = backupImageView;
        backupImageView.setImageDrawable(this.avatarDrawable);
        frameLayout.addView(this.avatarImage, LayoutHelper.createFrame(60, 60.0f, 51, 0.0f, 9.0f, 0.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.firstNameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.firstNameField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.firstNameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.firstNameField.setMaxLines(1);
        this.firstNameField.setLines(1);
        this.firstNameField.setSingleLine(true);
        this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.firstNameField.setGravity(3);
        this.firstNameField.setInputType(49152);
        this.firstNameField.setImeOptions(5);
        this.firstNameField.setHint(LocaleController.getString("FirstName", R.string.FirstName));
        this.firstNameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.firstNameField.setCursorWidth(1.5f);
        String str2 = this.initialFirstName;
        if (str2 != null) {
            this.firstNameField.setText(str2);
            this.initialFirstName = null;
            z = true;
        } else {
            z = false;
        }
        frameLayout.addView(this.firstNameField, LayoutHelper.createFrame(-1, 34.0f, 51, 84.0f, 0.0f, 0.0f, 0.0f));
        this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$f6cWbtQ1ZNf2xyH2KklD7i7mLXo
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1$NewContactActivity(textView, i, keyEvent);
            }
        });
        this.firstNameField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.NewContactActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                NewContactActivity.this.invalidateAvatar();
            }
        });
        EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
        this.lastNameField = editTextBoldCursor2;
        editTextBoldCursor2.setTextSize(1, 18.0f);
        this.lastNameField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.lastNameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.lastNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.lastNameField.setMaxLines(1);
        this.lastNameField.setLines(1);
        this.lastNameField.setSingleLine(true);
        this.lastNameField.setGravity(3);
        this.lastNameField.setInputType(49152);
        this.lastNameField.setImeOptions(5);
        this.lastNameField.setHint(LocaleController.getString("LastName", R.string.LastName));
        this.lastNameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.lastNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.lastNameField.setCursorWidth(1.5f);
        String str3 = this.initialLastName;
        if (str3 != null) {
            this.lastNameField.setText(str3);
            this.initialLastName = null;
            z = true;
        }
        frameLayout.addView(this.lastNameField, LayoutHelper.createFrame(-1, 34.0f, 51, 84.0f, 44.0f, 0.0f, 0.0f));
        this.lastNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$j6RGGPuwbQUH5MaPOsLf2lUa17Y
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$2$NewContactActivity(textView, i, keyEvent);
            }
        });
        this.lastNameField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.NewContactActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                NewContactActivity.this.invalidateAvatar();
            }
        });
        if (z) {
            invalidateAvatar();
        }
        TextView textView = new TextView(context);
        this.countryButton = textView;
        textView.setTextSize(1, 18.0f);
        this.countryButton.setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
        this.countryButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.countryButton.setMaxLines(1);
        this.countryButton.setSingleLine(true);
        this.countryButton.setEllipsize(TextUtils.TruncateAt.END);
        this.countryButton.setGravity(3);
        this.countryButton.setBackground(Theme.getSelectorDrawable(true));
        this.contentLayout.addView(this.countryButton, LayoutHelper.createLinear(-1, 36, 0.0f, 24.0f, 0.0f, 14.0f));
        this.countryButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$4FZF1rbziKRZdvJ02BL5FA3dMfw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$4$NewContactActivity(view);
            }
        });
        View view = new View(context);
        this.lineView = view;
        view.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        this.lineView.setBackgroundColor(Theme.getColor("windowBackgroundWhiteGrayLine"));
        this.contentLayout.addView(this.lineView, LayoutHelper.createLinear(-1, 1, 0.0f, -17.5f, 0.0f, 0.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        this.contentLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setText("+");
        this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 18.0f);
        this.textView.setImportantForAccessibility(2);
        linearLayout2.addView(this.textView, LayoutHelper.createLinear(-2, -2));
        EditTextBoldCursor editTextBoldCursor3 = new EditTextBoldCursor(context);
        this.codeField = editTextBoldCursor3;
        editTextBoldCursor3.setInputType(3);
        this.codeField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.codeField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.codeField.setCursorWidth(1.5f);
        this.codeField.setPadding(AndroidUtilities.dp(10.0f), 0, 0, 0);
        this.codeField.setTextSize(1, 18.0f);
        this.codeField.setMaxLines(1);
        this.codeField.setGravity(19);
        this.codeField.setImeOptions(268435461);
        linearLayout2.addView(this.codeField, LayoutHelper.createLinear(55, 36, -9.0f, 0.0f, 16.0f, 0.0f));
        this.codeField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.NewContactActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String str4;
                boolean z2;
                int iIndexOf;
                if (NewContactActivity.this.ignoreOnTextChange) {
                    return;
                }
                NewContactActivity.this.ignoreOnTextChange = true;
                String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(NewContactActivity.this.codeField.getText().toString());
                NewContactActivity.this.codeField.setText(strStripExceptNumbers);
                if (strStripExceptNumbers.length() == 0) {
                    NewContactActivity.this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                    NewContactActivity.this.phoneField.setHintText((String) null);
                    NewContactActivity.this.countryState = 1;
                } else {
                    int i = 4;
                    if (strStripExceptNumbers.length() > 4) {
                        NewContactActivity.this.ignoreOnTextChange = true;
                        while (true) {
                            if (i < 1) {
                                str4 = null;
                                z2 = false;
                                break;
                            }
                            String strSubstring = strStripExceptNumbers.substring(0, i);
                            if (((String) NewContactActivity.this.codesMap.get(strSubstring)) != null) {
                                String str5 = strStripExceptNumbers.substring(i) + NewContactActivity.this.phoneField.getText().toString();
                                NewContactActivity.this.codeField.setText(strSubstring);
                                z2 = true;
                                str4 = str5;
                                strStripExceptNumbers = strSubstring;
                                break;
                            }
                            i--;
                        }
                        if (!z2) {
                            NewContactActivity.this.ignoreOnTextChange = true;
                            str4 = strStripExceptNumbers.substring(1) + NewContactActivity.this.phoneField.getText().toString();
                            EditTextBoldCursor editTextBoldCursor4 = NewContactActivity.this.codeField;
                            strStripExceptNumbers = strStripExceptNumbers.substring(0, 1);
                            editTextBoldCursor4.setText(strStripExceptNumbers);
                        }
                    } else {
                        str4 = null;
                        z2 = false;
                    }
                    String str6 = (String) NewContactActivity.this.codesMap.get(strStripExceptNumbers);
                    if (str6 == null || (iIndexOf = NewContactActivity.this.countriesArray.indexOf(str6)) == -1) {
                        NewContactActivity.this.countryButton.setText(LocaleController.getString("WrongCountry", R.string.WrongCountry));
                        NewContactActivity.this.phoneField.setHintText((String) null);
                        NewContactActivity.this.countryState = 2;
                    } else {
                        NewContactActivity.this.ignoreSelection = true;
                        NewContactActivity.this.countryButton.setText((CharSequence) NewContactActivity.this.countriesArray.get(iIndexOf));
                        String str7 = (String) NewContactActivity.this.phoneFormatMap.get(strStripExceptNumbers);
                        NewContactActivity.this.phoneField.setHintText(str7 != null ? str7.replace('X', (char) 8211) : null);
                        NewContactActivity.this.countryState = 0;
                    }
                    if (!z2) {
                        NewContactActivity.this.codeField.setSelection(NewContactActivity.this.codeField.getText().length());
                    }
                    if (str4 != null) {
                        if (NewContactActivity.this.initialPhoneNumber == null) {
                            NewContactActivity.this.phoneField.requestFocus();
                        }
                        NewContactActivity.this.phoneField.setText(str4);
                        NewContactActivity.this.phoneField.setSelection(NewContactActivity.this.phoneField.length());
                    }
                }
                NewContactActivity.this.ignoreOnTextChange = false;
            }
        });
        this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$OfIaqtYSBVJ1ZMEGbyWAsqs85yU
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$5$NewContactActivity(textView3, i, keyEvent);
            }
        });
        HintEditText hintEditText = new HintEditText(context);
        this.phoneField = hintEditText;
        hintEditText.setInputType(3);
        this.phoneField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.phoneField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.phoneField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.phoneField.setPadding(0, 0, 0, 0);
        this.phoneField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.phoneField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.phoneField.setCursorWidth(1.5f);
        this.phoneField.setTextSize(1, 18.0f);
        this.phoneField.setMaxLines(1);
        this.phoneField.setGravity(19);
        this.phoneField.setImeOptions(268435462);
        linearLayout2.addView(this.phoneField, LayoutHelper.createFrame(-1, 36.0f));
        this.phoneField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.NewContactActivity.5
            private int actionPosition;
            private int characterAction = -1;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (count == 0 && after == 1) {
                    this.characterAction = 1;
                    return;
                }
                if (count == 1 && after == 0) {
                    if (s.charAt(start) == ' ' && start > 0) {
                        this.characterAction = 3;
                        this.actionPosition = start - 1;
                        return;
                    } else {
                        this.characterAction = 2;
                        return;
                    }
                }
                this.characterAction = -1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int i;
                int i2;
                if (NewContactActivity.this.ignoreOnPhoneChange) {
                    return;
                }
                int selectionStart = NewContactActivity.this.phoneField.getSelectionStart();
                String string = NewContactActivity.this.phoneField.getText().toString();
                if (this.characterAction == 3) {
                    string = string.substring(0, this.actionPosition) + string.substring(this.actionPosition + 1);
                    selectionStart--;
                }
                StringBuilder sb = new StringBuilder(string.length());
                int i3 = 0;
                while (i3 < string.length()) {
                    int i4 = i3 + 1;
                    String strSubstring = string.substring(i3, i4);
                    if ("0123456789".contains(strSubstring)) {
                        sb.append(strSubstring);
                    }
                    i3 = i4;
                }
                NewContactActivity.this.ignoreOnPhoneChange = true;
                String hintText = NewContactActivity.this.phoneField.getHintText();
                if (hintText != null) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= sb.length()) {
                            break;
                        }
                        if (i5 < hintText.length()) {
                            if (hintText.charAt(i5) == ' ') {
                                sb.insert(i5, ' ');
                                i5++;
                                if (selectionStart == i5 && (i2 = this.characterAction) != 2 && i2 != 3) {
                                    selectionStart++;
                                }
                            }
                            i5++;
                        } else {
                            sb.insert(i5, ' ');
                            if (selectionStart == i5 + 1 && (i = this.characterAction) != 2 && i != 3) {
                                selectionStart++;
                            }
                        }
                    }
                }
                NewContactActivity.this.phoneField.setText(sb);
                if (selectionStart >= 0) {
                    NewContactActivity.this.phoneField.setSelection(Math.min(selectionStart, NewContactActivity.this.phoneField.length()));
                }
                NewContactActivity.this.phoneField.onTextChange();
                NewContactActivity.this.ignoreOnPhoneChange = false;
            }
        });
        this.phoneField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$Mshwsx0pANBmtEWgng8GmJE3M80
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$6$NewContactActivity(textView3, i, keyEvent);
            }
        });
        this.phoneField.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$wswOX5GafVIOgyQhV2mtD3hm-aY
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$7$NewContactActivity(view2, i, keyEvent);
            }
        });
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("countries.txt")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split(";");
                this.countriesArray.add(0, strArrSplit[2]);
                this.countriesMap.put(strArrSplit[2], strArrSplit[0]);
                this.codesMap.put(strArrSplit[0], strArrSplit[2]);
                if (strArrSplit.length > 3) {
                    this.phoneFormatMap.put(strArrSplit[0], strArrSplit[3]);
                }
                map.put(strArrSplit[1], strArrSplit[2]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        Collections.sort(this.countriesArray, $$Lambda$Ds7dtVnGrflEw4LvNOxA0cDT4Y.INSTANCE);
        if (!TextUtils.isEmpty(this.initialPhoneNumber)) {
            TLRPC$User currentUser = getUserConfig().getCurrentUser();
            if (this.initialPhoneNumber.startsWith("+")) {
                this.codeField.setText(this.initialPhoneNumber.substring(1));
            } else if (this.initialPhoneNumberWithCountryCode || currentUser == null || TextUtils.isEmpty(currentUser.phone)) {
                this.codeField.setText(this.initialPhoneNumber);
            } else {
                String str4 = currentUser.phone;
                int i = 4;
                while (true) {
                    if (i < 1) {
                        break;
                    }
                    String strSubstring = str4.substring(0, i);
                    if (this.codesMap.get(strSubstring) != null) {
                        this.codeField.setText(strSubstring);
                        break;
                    }
                    i--;
                }
                this.phoneField.setText(this.initialPhoneNumber);
            }
            this.initialPhoneNumber = null;
        } else {
            try {
                telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            String upperCase = telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase() : null;
            if (upperCase != null && (str = (String) map.get(upperCase)) != null && this.countriesArray.indexOf(str) != -1) {
                this.codeField.setText(this.countriesMap.get(str));
                this.countryState = 0;
            }
            if (this.codeField.length() == 0) {
                this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                this.phoneField.setHintText((String) null);
                this.countryState = 1;
            }
        }
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.NewContactActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            if (id != -1) {
                if (id != 1 || NewContactActivity.this.donePressed) {
                    return;
                }
                if (NewContactActivity.this.firstNameField.length() != 0) {
                    if (NewContactActivity.this.codeField.length() != 0) {
                        if (NewContactActivity.this.phoneField.length() != 0) {
                            NewContactActivity.this.donePressed = true;
                            NewContactActivity.this.showEditDoneProgress(true, true);
                            final TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts = new TLRPC$TL_contacts_importContacts();
                            final TLRPC$TL_inputPhoneContact tLRPC$TL_inputPhoneContact = new TLRPC$TL_inputPhoneContact();
                            tLRPC$TL_inputPhoneContact.first_name = NewContactActivity.this.firstNameField.getText().toString();
                            tLRPC$TL_inputPhoneContact.last_name = NewContactActivity.this.lastNameField.getText().toString();
                            tLRPC$TL_inputPhoneContact.phone = "+" + NewContactActivity.this.codeField.getText().toString() + NewContactActivity.this.phoneField.getText().toString();
                            tLRPC$TL_contacts_importContacts.contacts.add(tLRPC$TL_inputPhoneContact);
                            ConnectionsManager.getInstance(((BaseFragment) NewContactActivity.this).currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(((BaseFragment) NewContactActivity.this).currentAccount).sendRequest(tLRPC$TL_contacts_importContacts, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$1$_Q1Qen5BdEem_YHZ3KOkR8ki4b8
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$onItemClick$2$NewContactActivity$1(tLRPC$TL_inputPhoneContact, tLRPC$TL_contacts_importContacts, tLObject, tLRPC$TL_error);
                                }
                            }, 2), ((BaseFragment) NewContactActivity.this).classGuid);
                            return;
                        }
                        Vibrator vibrator = (Vibrator) NewContactActivity.this.getParentActivity().getSystemService("vibrator");
                        if (vibrator != null) {
                            vibrator.vibrate(200L);
                        }
                        AndroidUtilities.shakeView(NewContactActivity.this.phoneField, 2.0f, 0);
                        return;
                    }
                    Vibrator vibrator2 = (Vibrator) NewContactActivity.this.getParentActivity().getSystemService("vibrator");
                    if (vibrator2 != null) {
                        vibrator2.vibrate(200L);
                    }
                    AndroidUtilities.shakeView(NewContactActivity.this.codeField, 2.0f, 0);
                    return;
                }
                Vibrator vibrator3 = (Vibrator) NewContactActivity.this.getParentActivity().getSystemService("vibrator");
                if (vibrator3 != null) {
                    vibrator3.vibrate(200L);
                }
                AndroidUtilities.shakeView(NewContactActivity.this.firstNameField, 2.0f, 0);
                return;
            }
            NewContactActivity.this.finishFragment();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$NewContactActivity$1(final TLRPC$TL_inputPhoneContact tLRPC$TL_inputPhoneContact, final TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            final TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts = (TLRPC$TL_contacts_importedContacts) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$1$oqYaF31i6QisHZ31kU_s7MgcXU4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$1$NewContactActivity$1(tLRPC$TL_contacts_importedContacts, tLRPC$TL_inputPhoneContact, tLRPC$TL_error, tLRPC$TL_contacts_importContacts);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$NewContactActivity$1(TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts, final TLRPC$TL_inputPhoneContact tLRPC$TL_inputPhoneContact, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts) {
            NewContactActivity.this.donePressed = false;
            if (tLRPC$TL_contacts_importedContacts == null) {
                NewContactActivity.this.showEditDoneProgress(false, true);
                AlertsCreator.processError(((BaseFragment) NewContactActivity.this).currentAccount, tLRPC$TL_error, NewContactActivity.this, tLRPC$TL_contacts_importContacts, new Object[0]);
                return;
            }
            if (!tLRPC$TL_contacts_importedContacts.users.isEmpty()) {
                MessagesController.getInstance(((BaseFragment) NewContactActivity.this).currentAccount).putUsers(tLRPC$TL_contacts_importedContacts.users, false);
                MessagesController.openChatOrProfileWith(tLRPC$TL_contacts_importedContacts.users.get(0), null, NewContactActivity.this, 1, true);
            } else {
                if (NewContactActivity.this.getParentActivity() == null) {
                    return;
                }
                NewContactActivity.this.showEditDoneProgress(false, true);
                AlertDialog.Builder builder = new AlertDialog.Builder(NewContactActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("ContactNotRegisteredTitle", R.string.ContactNotRegisteredTitle));
                builder.setMessage(LocaleController.formatString("ContactNotRegistered", R.string.ContactNotRegistered, ContactsController.formatName(tLRPC$TL_inputPhoneContact.first_name, tLRPC$TL_inputPhoneContact.last_name)));
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setPositiveButton(LocaleController.getString("Invite", R.string.Invite), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$1$auEwJIuGaP9jC6yCkG-Yx7seB8s
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onItemClick$0$NewContactActivity$1(tLRPC$TL_inputPhoneContact, dialogInterface, i);
                    }
                });
                NewContactActivity.this.showDialog(builder.create());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$NewContactActivity$1(TLRPC$TL_inputPhoneContact tLRPC$TL_inputPhoneContact, DialogInterface dialogInterface, int i) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", tLRPC$TL_inputPhoneContact.phone, null));
                intent.putExtra("sms_body", ContactsController.getInstance(((BaseFragment) NewContactActivity.this).currentAccount).getInviteText(1));
                NewContactActivity.this.getParentActivity().startActivityForResult(intent, 500);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$NewContactActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.lastNameField.requestFocus();
        EditTextBoldCursor editTextBoldCursor = this.lastNameField;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$NewContactActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.phoneField.requestFocus();
        HintEditText hintEditText = this.phoneField;
        hintEditText.setSelection(hintEditText.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$NewContactActivity(View view) {
        CountrySelectActivity countrySelectActivity = new CountrySelectActivity(true);
        countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$JFb8u3uiLdMapN8iuCeMQr6vuAs
            @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
            public final void didSelectCountry(CountrySelectActivity.Country country) {
                this.f$0.lambda$createView$3$NewContactActivity(country);
            }
        });
        presentFragment(countrySelectActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$NewContactActivity(CountrySelectActivity.Country country) {
        selectCountry(country.name);
        this.phoneField.requestFocus();
        HintEditText hintEditText = this.phoneField;
        hintEditText.setSelection(hintEditText.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$5$NewContactActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.phoneField.requestFocus();
        HintEditText hintEditText = this.phoneField;
        hintEditText.setSelection(hintEditText.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$6$NewContactActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.editDoneItem.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$7$NewContactActivity(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || this.phoneField.length() != 0) {
            return false;
        }
        this.codeField.requestFocus();
        EditTextBoldCursor editTextBoldCursor = this.codeField;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        this.codeField.dispatchKeyEvent(keyEvent);
        return true;
    }

    public static String getPhoneNumber(Context context, TLRPC$User user, String number, boolean withCoutryCode) {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("countries.txt")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split(";");
                map.put(strArrSplit[0], strArrSplit[2]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (number.startsWith("+")) {
            return number;
        }
        if (withCoutryCode || user == null || TextUtils.isEmpty(user.phone)) {
            return "+" + number;
        }
        String str = user.phone;
        for (int i = 4; i >= 1; i--) {
            String strSubstring = str.substring(0, i);
            if (((String) map.get(strSubstring)) != null) {
                return "+" + strSubstring + number;
            }
        }
        return number;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateAvatar() {
        this.avatarDrawable.setInfo(5L, this.firstNameField.getText().toString(), this.lastNameField.getText().toString());
        this.avatarImage.invalidate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            View viewFindFocus = this.contentLayout.findFocus();
            if (viewFindFocus == null) {
                this.firstNameField.requestFocus();
                viewFindFocus = this.firstNameField;
            }
            AndroidUtilities.showKeyboard(viewFindFocus);
        }
    }

    public void setInitialPhoneNumber(String value, boolean withCoutryCode) {
        this.initialPhoneNumber = value;
        this.initialPhoneNumberWithCountryCode = withCoutryCode;
    }

    public void setInitialName(String firstName, String lastName) {
        this.initialFirstName = firstName;
        this.initialLastName = lastName;
    }

    public void selectCountry(String name) {
        if (this.countriesArray.indexOf(name) != -1) {
            this.ignoreOnTextChange = true;
            String str = this.countriesMap.get(name);
            this.codeField.setText(str);
            this.countryButton.setText(name);
            String str2 = this.phoneFormatMap.get(str);
            this.phoneField.setHintText(str2 != null ? str2.replace('X', (char) 8211) : null);
            this.countryState = 0;
            this.ignoreOnTextChange = false;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (this.ignoreSelection) {
            this.ignoreSelection = false;
            return;
        }
        this.ignoreOnTextChange = true;
        this.codeField.setText(this.countriesMap.get(this.countriesArray.get(i)));
        this.ignoreOnTextChange = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean show, boolean animated) {
        AnimatorSet animatorSet = this.editDoneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (animated) {
            this.editDoneItemAnimation = new AnimatorSet();
            if (show) {
                this.editDoneItemProgress.setVisibility(0);
                this.editDoneItem.setEnabled(false);
                this.editDoneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "scaleX", 0.1f), ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "scaleY", 0.1f), ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "alpha", 0.0f), ObjectAnimator.ofFloat(this.editDoneItemProgress, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.editDoneItemProgress, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.editDoneItemProgress, "alpha", 1.0f));
            } else {
                this.editDoneItem.getContentView().setVisibility(0);
                this.editDoneItem.setEnabled(true);
                this.editDoneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.editDoneItemProgress, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.editDoneItemProgress, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.editDoneItemProgress, "alpha", 0.0f), ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.editDoneItem.getContentView(), "alpha", 1.0f));
            }
            this.editDoneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.NewContactActivity.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (NewContactActivity.this.editDoneItemAnimation == null || !NewContactActivity.this.editDoneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        NewContactActivity.this.editDoneItemProgress.setVisibility(4);
                    } else {
                        NewContactActivity.this.editDoneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (NewContactActivity.this.editDoneItemAnimation == null || !NewContactActivity.this.editDoneItemAnimation.equals(animation)) {
                        return;
                    }
                    NewContactActivity.this.editDoneItemAnimation = null;
                }
            });
            this.editDoneItemAnimation.setDuration(150L);
            this.editDoneItemAnimation.start();
            return;
        }
        if (show) {
            this.editDoneItem.getContentView().setScaleX(0.1f);
            this.editDoneItem.getContentView().setScaleY(0.1f);
            this.editDoneItem.getContentView().setAlpha(0.0f);
            this.editDoneItemProgress.setScaleX(1.0f);
            this.editDoneItemProgress.setScaleY(1.0f);
            this.editDoneItemProgress.setAlpha(1.0f);
            this.editDoneItem.getContentView().setVisibility(4);
            this.editDoneItemProgress.setVisibility(0);
            this.editDoneItem.setEnabled(false);
            return;
        }
        this.editDoneItemProgress.setScaleX(0.1f);
        this.editDoneItemProgress.setScaleY(0.1f);
        this.editDoneItemProgress.setAlpha(0.0f);
        this.editDoneItem.getContentView().setScaleX(1.0f);
        this.editDoneItem.getContentView().setScaleY(1.0f);
        this.editDoneItem.getContentView().setAlpha(1.0f);
        this.editDoneItem.getContentView().setVisibility(0);
        this.editDoneItemProgress.setVisibility(4);
        this.editDoneItem.setEnabled(true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NewContactActivity$thX_YRm8mRvQpY5Ud-Hm8mkJJlk
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$8$NewContactActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.phoneField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.phoneField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.lineView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhiteGrayLine"));
        arrayList.add(new ThemeDescription(this.countryButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.countryButton, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.countryButton, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.editDoneItemProgress, 0, null, null, null, null, "contextProgressInner2"));
        arrayList.add(new ThemeDescription(this.editDoneItemProgress, 0, null, null, null, null, "contextProgressOuter2"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$8$NewContactActivity() {
        if (this.avatarImage != null) {
            invalidateAvatar();
        }
    }
}
