package ir.eitaa.features.CallOut;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.features.CallOut.cells.ContactInfoCell;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class StartCallOutActivity extends BaseFragment {
    private FrameLayout callButton;
    private FrameLayout contentView;
    private ImageView eraseButton;
    private ArrayList<TextView> lettersTextViews;
    private ArrayList<FrameLayout> numberFrameLayouts;
    private ArrayList<TextView> numberTextViews;
    private FrameLayout numbersFrameLayout;
    private ArrayList<ContactsController.Contact> phoneBookContacts;
    private AnimatingPhoneNumberTextView phoneNumberEditText;
    private FrameLayout phoneNumberFrameLayout;
    private int prevOrientation;
    private SearchAdapter searchAdapter;
    private ActionBarMenuItem searchItem;
    private RecyclerListView searchListView;
    private SuggestAdapter suggestAdapter;
    private RecyclerListView suggestListView;
    private long startCallLastClickTime = 0;
    private long lastSearchTime = 0;

    private static class AnimatingPhoneNumberTextView extends FrameLayout {
        private ArrayList<TextView> characterTextViews;
        private OnTextChangedListener onTextChangedListener;
        private StringBuilder stringBuilder;

        interface OnTextChangedListener {
            void onCharacterAppend(String text);
        }

        public AnimatingPhoneNumberTextView(Context context) {
            super(context);
            this.characterTextViews = new ArrayList<>(20);
            this.stringBuilder = new StringBuilder(20);
            for (int i = 0; i < 20; i++) {
                TextView textView = new TextView(context);
                textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                textView.setTextSize(1, 36.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(false));
                textView.setGravity(17);
                textView.setAlpha(0.0f);
                textView.setPivotX(AndroidUtilities.dp(20.0f));
                textView.setPivotY(AndroidUtilities.dp(20.0f));
                addView(textView, LayoutHelper.createFrame(50, 50, 51));
                this.characterTextViews.add(textView);
            }
        }

        private int getXForTextView(int pos) {
            return (((getMeasuredWidth() - (this.stringBuilder.length() * AndroidUtilities.dp(20.0f))) / 2) + (pos * AndroidUtilities.dp(20.0f))) - AndroidUtilities.dp(10.0f);
        }

        public void appendCharacter(String c, boolean callOnAppend) {
            if (this.stringBuilder.length() == 20) {
                return;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                FileLog.e(e);
            }
            ArrayList arrayList = new ArrayList();
            int length = this.stringBuilder.length();
            this.stringBuilder.append(c);
            TextView textView = this.characterTextViews.get(length);
            textView.setText(c);
            textView.setTranslationX(getXForTextView(length));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f), 0.0f));
            for (int i = 0; i < length; i++) {
                arrayList.add(ObjectAnimator.ofFloat(this.characterTextViews.get(i), (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i)));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            OnTextChangedListener onTextChangedListener = this.onTextChangedListener;
            if (onTextChangedListener == null || !callOnAppend) {
                return;
            }
            onTextChangedListener.onCharacterAppend(getString());
        }

        public String getString() {
            return this.stringBuilder.toString();
        }

        public boolean eraseLastCharacter() {
            if (this.stringBuilder.length() == 0) {
                return false;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                FileLog.e(e);
            }
            ArrayList arrayList = new ArrayList();
            int length = this.stringBuilder.length() - 1;
            if (length != 0) {
                this.stringBuilder.deleteCharAt(length);
            }
            for (int i = length; i < 20; i++) {
                TextView textView = this.characterTextViews.get(i);
                if (textView.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i)));
                }
            }
            if (length == 0) {
                this.stringBuilder.deleteCharAt(length);
            }
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(ObjectAnimator.ofFloat(this.characterTextViews.get(i2), (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i2)));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            OnTextChangedListener onTextChangedListener = this.onTextChangedListener;
            if (onTextChangedListener != null) {
                onTextChangedListener.onCharacterAppend(getString());
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eraseAllCharacters(final boolean animated, boolean callOnAppend) {
            if (this.stringBuilder.length() == 0) {
                return;
            }
            StringBuilder sb = this.stringBuilder;
            sb.delete(0, sb.length());
            if (animated) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 20; i++) {
                    TextView textView = this.characterTextViews.get(i);
                    if (textView.getAlpha() != 0.0f) {
                        arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                        arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                        arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f));
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playTogether(arrayList);
                animatorSet.start();
            } else {
                for (int i2 = 0; i2 < 20; i2++) {
                    this.characterTextViews.get(i2).setAlpha(0.0f);
                }
            }
            OnTextChangedListener onTextChangedListener = this.onTextChangedListener;
            if (onTextChangedListener == null || !callOnAppend) {
                return;
            }
            onTextChangedListener.onCharacterAppend(getString());
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            for (int i = 0; i < 20; i++) {
                if (i < this.stringBuilder.length()) {
                    TextView textView = this.characterTextViews.get(i);
                    textView.setAlpha(0.0f);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setTranslationY(0.0f);
                } else {
                    this.characterTextViews.get(i).setAlpha(0.0f);
                }
            }
            super.onLayout(changed, left, top, right, bottom);
        }

        public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
            this.onTextChangedListener = onTextChangedListener;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getParentActivity().setRequestedOrientation(this.prevOrientation);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.prevOrientation = getParentActivity().getRequestedOrientation();
        getParentActivity().setRequestedOrientation(1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setTitle(LocaleController.getString("CallOutTitle", R.string.CallOutTitle));
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        AndroidUtilities.requestAdjustNothing(getParentActivity(), getClassGuid());
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    StartCallOutActivity.this.finishFragment();
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(1, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                StartCallOutActivity.this.searchAdapter.performSearchByName(editText.getText().toString());
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                StartCallOutActivity.this.updateViewsVisibility(true);
                ((BaseFragment) StartCallOutActivity.this).actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                StartCallOutActivity.this.updateViewsVisibility(false);
                StartCallOutActivity.this.searchAdapter.clearSearchResult();
                ((BaseFragment) StartCallOutActivity.this).actionBar.setBackButtonContentDescription(LocaleController.getString("AccDescrOpenMenu", R.string.AccDescrOpenMenu));
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("CallOurSearchInContactHint", R.string.CallOurSearchInContactHint));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.3
            private Paint paint = new Paint();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }

            @Override // android.view.View
            public void setBackgroundColor(int color) {
                this.paint.setColor(color);
            }
        };
        this.contentView = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.searchAdapter = new SearchAdapter(context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.searchListView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.searchListView.setAdapter(this.searchAdapter);
        this.searchListView.setVisibility(4);
        this.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.4
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int position) {
                String str;
                Object item = StartCallOutActivity.this.searchAdapter.getItem(position);
                if (item == null) {
                    return;
                }
                ((BaseFragment) StartCallOutActivity.this).actionBar.closeSearchField();
                StartCallOutActivity.this.phoneNumberEditText.eraseAllCharacters(false, false);
                if (item instanceof TLRPC$User) {
                    str = ((TLRPC$User) item).phone;
                } else {
                    str = ((ContactsController.Contact) item).phones.get(0);
                }
                if (str.equals(StartCallOutActivity.this.phoneNumberEditText.getString())) {
                    return;
                }
                for (int i = 0; i < str.length(); i++) {
                    StartCallOutActivity.this.phoneNumberEditText.appendCharacter(String.valueOf(str.charAt(i)), false);
                }
                StartCallOutActivity.this.suggestAdapter.showSelectedContact(item, AndroidUtilities.generateSearchName(str, "", str));
            }
        });
        this.contentView.addView(this.searchListView, LayoutHelper.createFrame(-1, -1, 51));
        this.suggestAdapter = new SuggestAdapter(context);
        RecyclerListView recyclerListView2 = new RecyclerListView(context);
        this.suggestListView = recyclerListView2;
        recyclerListView2.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.suggestListView.setAdapter(this.suggestAdapter);
        this.suggestListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.5
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int position) {
                String str;
                Object item = StartCallOutActivity.this.suggestAdapter.getItem(position);
                if (item == null) {
                    return;
                }
                if (item instanceof TLRPC$User) {
                    str = ((TLRPC$User) item).phone;
                } else {
                    str = ((ContactsController.Contact) item).phones.get(0);
                }
                if (str.equals(StartCallOutActivity.this.phoneNumberEditText.getString())) {
                    return;
                }
                StartCallOutActivity.this.phoneNumberEditText.eraseAllCharacters(false, true);
                for (int i = 0; i < str.length(); i++) {
                    StartCallOutActivity.this.phoneNumberEditText.appendCharacter(String.valueOf(str.charAt(i)), false);
                }
                StartCallOutActivity.this.suggestAdapter.showSelectedContact(item, AndroidUtilities.generateSearchName(str, "", str));
            }
        });
        this.contentView.addView(this.suggestListView, LayoutHelper.createFrame(-1, -1, 51));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.6
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                StartCallOutActivity.this.suggestListView.setLayoutParams(LayoutHelper.createFrame(-1, -1.0f, 1, 25.0f, 12.0f, 25.0f, AndroidUtilities.pxToDp(StartCallOutActivity.this.contentView.getMeasuredHeight() - top)));
            }
        };
        this.phoneNumberFrameLayout = frameLayout2;
        this.contentView.addView(frameLayout2, LayoutHelper.createFrame(-1, -1.0f));
        AnimatingPhoneNumberTextView animatingPhoneNumberTextView = new AnimatingPhoneNumberTextView(context);
        this.phoneNumberEditText = animatingPhoneNumberTextView;
        animatingPhoneNumberTextView.setOnTextChangedListener(new AnimatingPhoneNumberTextView.OnTextChangedListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.7
            @Override // ir.eitaa.features.CallOut.StartCallOutActivity.AnimatingPhoneNumberTextView.OnTextChangedListener
            public void onCharacterAppend(String text) {
                if (!text.isEmpty()) {
                    StartCallOutActivity.this.suggestAdapter.performSearchByPhone(text);
                } else {
                    StartCallOutActivity.this.suggestAdapter.clearSearchResult();
                }
            }
        });
        this.phoneNumberFrameLayout.addView(this.phoneNumberEditText, LayoutHelper.createFrame(-1, -2.0f, 49, 25.0f, 0.0f, 25.0f, 6.0f));
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.8
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int iDp = (size - (AndroidUtilities.dp(50.0f) * 3)) / 4;
                int iDp2 = (size - (AndroidUtilities.dp(50.0f) * 4)) / 5;
                int i = 0;
                while (i < 12) {
                    int i2 = 11;
                    if (i == 0) {
                        i2 = 10;
                    } else if (i != 10) {
                        i2 = i == 11 ? 9 : i - 1;
                    }
                    TextView textView = (TextView) StartCallOutActivity.this.numberTextViews.get(i);
                    TextView textView2 = (TextView) StartCallOutActivity.this.lettersTextViews.get(i);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                    int iDp3 = ((AndroidUtilities.dp(50.0f) + iDp2) * (i2 / 3)) + iDp2;
                    layoutParams.topMargin = iDp3;
                    layoutParams2.topMargin = iDp3;
                    int iDp4 = ((AndroidUtilities.dp(50.0f) + iDp) * (i2 % 3)) + iDp;
                    layoutParams.leftMargin = iDp4;
                    layoutParams2.leftMargin = iDp4;
                    layoutParams2.topMargin += AndroidUtilities.dp(40.0f);
                    textView.setLayoutParams(layoutParams);
                    textView2.setLayoutParams(layoutParams2);
                    FrameLayout frameLayout4 = (FrameLayout) StartCallOutActivity.this.numberFrameLayouts.get(i);
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) frameLayout4.getLayoutParams();
                    layoutParams3.topMargin = iDp3 - AndroidUtilities.dp(17.0f);
                    layoutParams3.leftMargin = layoutParams.leftMargin - AndroidUtilities.dp(25.0f);
                    frameLayout4.setLayoutParams(layoutParams3);
                    i++;
                }
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                StartCallOutActivity.this.phoneNumberFrameLayout.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, 1, 0.0f, AndroidUtilities.pxToDp(top) - 25.0f, 0.0f, 0.0f));
            }
        };
        this.numbersFrameLayout = frameLayout3;
        this.contentView.addView(frameLayout3, LayoutHelper.createFrame(-1, -2.0f, 81, 0.0f, 0.0f, 0.0f, 116.0f));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("StartCallOut", R.string.StartCallOut));
        textView.setTextColor(-1);
        textView.setTextSize(1, 16.0f);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.calls_menu_phone, 0, 0, 0);
        textView.setCompoundDrawablePadding(32);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setGravity(1);
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.callButton = frameLayout4;
        frameLayout4.addView(textView, LayoutHelper.createFrame(-2, -2, 17));
        this.callButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(50, Theme.getColor("chats_actionBackground"), ColorUtils.setAlphaComponent(-1, 100)));
        this.callButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - StartCallOutActivity.this.startCallLastClickTime < 1000) {
                    return;
                }
                StartCallOutActivity.this.startCallLastClickTime = SystemClock.elapsedRealtime();
                String string = StartCallOutActivity.this.phoneNumberEditText.getString();
                if (string.isEmpty()) {
                    return;
                }
                ContactsController.Contact contact = new ContactsController.Contact();
                if (StartCallOutActivity.this.suggestAdapter.getItemCount() == 1) {
                    Object item = StartCallOutActivity.this.suggestAdapter.getItem(0);
                    if ((item instanceof TLRPC$User) && ((TLRPC$User) item).phone.equals(string)) {
                        contact = CallOutManager.makeContactFromUser((TLRPC$User) StartCallOutActivity.this.suggestAdapter.getItem(0));
                    } else if ((item instanceof ContactsController.Contact) && ((ContactsController.Contact) item).phones.get(0).equals(string)) {
                        contact = (ContactsController.Contact) StartCallOutActivity.this.suggestAdapter.getItem(0);
                    }
                }
                if (contact.phones.isEmpty()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    contact.phones = arrayList;
                    contact.last_name = "";
                    contact.first_name = "";
                    arrayList.add(string);
                }
                CallOutManager.makeCall(StartCallOutActivity.this, contact);
            }
        });
        this.contentView.addView(this.callButton, LayoutHelper.createFrame(-1, 50.0f, 83, 50.0f, 0.0f, 132.0f, 50.0f));
        ImageView imageView = new ImageView(context);
        this.eraseButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.eraseButton.setImageResource(R.drawable.passcode_delete);
        this.eraseButton.setBackgroundDrawable(Theme.createCircleSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 100), 0, 0));
        this.eraseButton.setColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.eraseButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StartCallOutActivity.this.phoneNumberEditText.eraseLastCharacter();
            }
        });
        this.eraseButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                StartCallOutActivity.this.phoneNumberEditText.eraseAllCharacters(true, true);
                return false;
            }
        });
        this.contentView.addView(this.eraseButton, LayoutHelper.createFrame(50, 50.0f, 85, 0.0f, 0.0f, 50.0f, 50.0f));
        this.lettersTextViews = new ArrayList<>(12);
        this.numberTextViews = new ArrayList<>(12);
        this.numberFrameLayouts = new ArrayList<>(12);
        int i = 0;
        while (true) {
            if (i < 12) {
                TextView textView2 = new TextView(context);
                textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                textView2.setTextSize(1, 36.0f);
                textView2.setTypeface(AndroidUtilities.getFontFamily(false));
                textView2.setGravity(17);
                if (i == 10) {
                    textView2.setText("#");
                } else if (i == 11) {
                    textView2.setText("*");
                } else {
                    textView2.setText(String.format(Locale.US, "%d", Integer.valueOf(i)));
                }
                this.numbersFrameLayout.addView(textView2, LayoutHelper.createFrame(50, 50, 51));
                textView2.setImportantForAccessibility(2);
                this.numberTextViews.add(textView2);
                TextView textView3 = new TextView(context);
                textView3.setTextSize(12.0f);
                textView3.setTypeface(AndroidUtilities.getFontFamily(false));
                textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
                textView3.setGravity(17);
                this.numbersFrameLayout.addView(textView3, LayoutHelper.createFrame(50, 50, 51));
                textView3.setImportantForAccessibility(2);
                if (i == 0) {
                    textView3.setText("+");
                } else {
                    switch (i) {
                        case 2:
                            textView3.setText("ABC");
                            break;
                        case 3:
                            textView3.setText("DEF");
                            break;
                        case 4:
                            textView3.setText("GHI");
                            break;
                        case 5:
                            textView3.setText("JKL");
                            break;
                        case 6:
                            textView3.setText("MNO");
                            break;
                        case 7:
                            textView3.setText("PQRS");
                            break;
                        case 8:
                            textView3.setText("TUV");
                            break;
                        case 9:
                            textView3.setText("WXYZ");
                            break;
                    }
                }
                this.lettersTextViews.add(textView3);
                i++;
            } else {
                for (int i2 = 0; i2 < 12; i2++) {
                    FrameLayout frameLayout5 = new FrameLayout(context) { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.12
                        @Override // android.view.View
                        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                            super.onInitializeAccessibilityNodeInfo(info);
                            info.setClassName("android.widget.Button");
                        }
                    };
                    frameLayout5.setBackgroundDrawable(Theme.createCircleSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 100), 0, 0));
                    frameLayout5.setTag(Integer.valueOf(i2));
                    if (i2 == 11) {
                        frameLayout5.setContentDescription(LocaleController.getString("AccDescrFingerprint", R.string.AccDescrFingerprint));
                    } else if (i2 == 10) {
                        frameLayout5.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
                    } else {
                        frameLayout5.setContentDescription(i2 + "");
                    }
                    frameLayout5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.CallOut.-$$Lambda$StartCallOutActivity$I-zV4UfSJjgE2Z--sD-uPEFR7cg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$createView$0$StartCallOutActivity(view);
                        }
                    });
                    this.numberFrameLayouts.add(frameLayout5);
                }
                for (int i3 = 11; i3 >= 0; i3--) {
                    this.numbersFrameLayout.addView(this.numberFrameLayouts.get(i3), LayoutHelper.createFrame(100, 100, 51));
                }
                fetchContacts();
                FrameLayout frameLayout6 = this.contentView;
                this.fragmentView = frameLayout6;
                return frameLayout6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$StartCallOutActivity(View view) {
        switch (((Integer) view.getTag()).intValue()) {
            case 0:
                this.phoneNumberEditText.appendCharacter("0", true);
                break;
            case 1:
                this.phoneNumberEditText.appendCharacter("1", true);
                break;
            case 2:
                this.phoneNumberEditText.appendCharacter("2", true);
                break;
            case 3:
                this.phoneNumberEditText.appendCharacter("3", true);
                break;
            case 4:
                this.phoneNumberEditText.appendCharacter("4", true);
                break;
            case 5:
                this.phoneNumberEditText.appendCharacter("5", true);
                break;
            case 6:
                this.phoneNumberEditText.appendCharacter("6", true);
                break;
            case 7:
                this.phoneNumberEditText.appendCharacter("7", true);
                break;
            case 8:
                this.phoneNumberEditText.appendCharacter("8", true);
                break;
            case 9:
                this.phoneNumberEditText.appendCharacter("9", true);
                break;
            case 10:
                this.phoneNumberEditText.appendCharacter("#", true);
                break;
            case 11:
                this.phoneNumberEditText.appendCharacter("*", true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewsVisibility(boolean isSearch) {
        int i = isSearch ? 0 : 4;
        int i2 = isSearch ? 4 : 0;
        this.searchListView.setVisibility(i);
        this.phoneNumberFrameLayout.setVisibility(i2);
        this.suggestListView.setVisibility(i2);
        this.numbersFrameLayout.setVisibility(i2);
        this.eraseButton.setVisibility(i2);
        this.callButton.setVisibility(i2);
    }

    public void fetchContacts() {
        ArrayList<ContactsController.Contact> arrayList = new ArrayList<>(ContactsController.getInstance(this.currentAccount).phoneBookContacts);
        this.phoneBookContacts = arrayList;
        if (arrayList.isEmpty()) {
            ContactsController.getInstance(this.currentAccount).checkContacts();
            return;
        }
        HashMap map = new HashMap(ContactsController.getInstance(UserConfig.selectedAccount).contactsByPhone);
        Collections.sort(this.phoneBookContacts, $$Lambda$StartCallOutActivity$b2xlzk3VTBj7CCesNQRgVnHbzUk.INSTANCE);
        for (int i = 0; i < this.phoneBookContacts.size(); i++) {
            ContactsController.Contact contact = this.phoneBookContacts.get(i);
            map.put(contact.phones.get(0), contact);
        }
    }

    static /* synthetic */ int lambda$fetchContacts$1(ContactsController.Contact contact, ContactsController.Contact contact2) {
        int i = contact.imported;
        int i2 = contact2.imported;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private final Context context;
        private ArrayList<Object> searchResultArray = new ArrayList<>();
        private ArrayList<CharSequence> searchResultArrayNames = new ArrayList<>();

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public SearchAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new ContactInfoCell(this.context, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ContactsController.Contact contact;
            ContactInfoCell contactInfoCell = (ContactInfoCell) holder.itemView;
            if (this.searchResultArray.get(position) instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) this.searchResultArray.get(position);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(tLRPC$User.phone);
                contact = new ContactsController.Contact();
                contact.user = tLRPC$User;
                contact.last_name = tLRPC$User.last_name;
                contact.first_name = tLRPC$User.first_name;
                contact.phones = arrayList;
            } else {
                contact = (ContactsController.Contact) this.searchResultArray.get(position);
            }
            if (contact != null) {
                contactInfoCell.setUser(contact, this.searchResultArrayNames.get(position));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.searchResultArray.size();
        }

        public void performSearchByName(final String query) {
            if (SystemClock.elapsedRealtime() - StartCallOutActivity.this.lastSearchTime < 500) {
                return;
            }
            StartCallOutActivity.this.lastSearchTime = SystemClock.elapsedRealtime();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.CallOut.-$$Lambda$StartCallOutActivity$SearchAdapter$XHpHrpcuRjclDub8630GVd9ViEM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearchByName$1$StartCallOutActivity$SearchAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$performSearchByName$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$performSearchByName$1$StartCallOutActivity$SearchAdapter(final String str) {
            ArrayList<Object> arrayList = this.searchResultArray;
            if (arrayList != null) {
                arrayList.clear();
            }
            final int i = UserConfig.selectedAccount;
            final ArrayList arrayList2 = new ArrayList(ContactsController.getInstance(i).contacts);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.features.CallOut.-$$Lambda$StartCallOutActivity$SearchAdapter$1R6DNkafqvmd4xO_oI-LEvgnRcM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearchByName$0$StartCallOutActivity$SearchAdapter(str, arrayList2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01b8  */
        /* renamed from: lambda$performSearchByName$0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$performSearchByName$0$StartCallOutActivity$SearchAdapter(java.lang.String r19, java.util.ArrayList r20, int r21) {
            /*
                Method dump skipped, instructions count: 473
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.features.CallOut.StartCallOutActivity.SearchAdapter.lambda$performSearchByName$0$StartCallOutActivity$SearchAdapter(java.lang.String, java.util.ArrayList, int):void");
        }

        public Object getItem(int position) {
            return this.searchResultArray.get(position);
        }

        public void clearSearchResult() {
            this.searchResultArray.clear();
            this.searchResultArrayNames.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SuggestAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private ArrayList<Object> searchResultArray = new ArrayList<>();
        private ArrayList<CharSequence> searchResultArrayNames = new ArrayList<>();

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public SuggestAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new ContactInfoCell(this.context, true));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ContactsController.Contact contact;
            ContactInfoCell contactInfoCell = (ContactInfoCell) holder.itemView;
            if (this.searchResultArray.get(position) instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) this.searchResultArray.get(position);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(tLRPC$User.phone);
                contact = new ContactsController.Contact();
                contact.user = tLRPC$User;
                contact.last_name = tLRPC$User.last_name;
                contact.first_name = tLRPC$User.first_name;
                contact.phones = arrayList;
            } else {
                contact = (ContactsController.Contact) this.searchResultArray.get(position);
            }
            if (contact != null) {
                contactInfoCell.setUser(contact, this.searchResultArrayNames.get(position));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.searchResultArray.size();
        }

        public void performSearchByPhone(final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.CallOut.-$$Lambda$StartCallOutActivity$SuggestAdapter$xJqoj5ddyuFZ4UeTjMkg8wgk2Qk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearchByPhone$1$StartCallOutActivity$SuggestAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$performSearchByPhone$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$performSearchByPhone$1$StartCallOutActivity$SuggestAdapter(final String str) {
            ArrayList<Object> arrayList = this.searchResultArray;
            if (arrayList != null) {
                arrayList.clear();
            }
            final int i = UserConfig.selectedAccount;
            final ArrayList arrayList2 = new ArrayList(ContactsController.getInstance(i).contacts);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.features.CallOut.-$$Lambda$StartCallOutActivity$SuggestAdapter$EXOs-YlZm0Ph-aezFeTjt10mYRY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSearchByPhone$0$StartCallOutActivity$SuggestAdapter(str, arrayList2, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$performSearchByPhone$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$performSearchByPhone$0$StartCallOutActivity$SuggestAdapter(String str, ArrayList arrayList, int i) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            boolean z;
            boolean z2;
            Iterator<Object> it;
            int i2;
            String[] strArr;
            String str7;
            String str8;
            String[] strArr2;
            boolean z3;
            String string;
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            char c = 0;
            int i3 = (translitString != null ? 1 : 0) + 1;
            String[] strArr3 = new String[i3];
            strArr3[0] = lowerCase;
            if (translitString != null) {
                strArr3[1] = translitString;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            ArrayList<CharSequence> arrayList3 = new ArrayList<>();
            int i4 = 0;
            while (true) {
                int i5 = 3;
                if (i4 >= arrayList.size()) {
                    break;
                }
                String str9 = "+98";
                TLRPC$User user = MessagesController.getInstance(i).getUser(Long.valueOf(((TLRPC$TL_contact) arrayList.get(i4)).user_id));
                if (user.self || (str7 = user.phone) == null) {
                    i2 = i3;
                    strArr = strArr3;
                } else {
                    String[] strArr4 = new String[3];
                    strArr4[c] = str7;
                    int i6 = 0;
                    boolean z4 = false;
                    while (i6 < i3) {
                        String str10 = strArr3[i6];
                        int i7 = 0;
                        while (i7 < i5) {
                            String str11 = strArr4[i7];
                            if (str11 != null && str11.startsWith("98")) {
                                z3 = z4;
                                StringBuilder sb = new StringBuilder();
                                sb.append("0");
                                strArr = strArr3;
                                i2 = i3;
                                sb.append(strArr4[i7].substring(2));
                                string = sb.toString();
                                str8 = str9;
                                strArr2 = strArr4;
                            } else {
                                i2 = i3;
                                strArr = strArr3;
                                z3 = z4;
                                str8 = str9;
                                if (str11 == null || !str11.startsWith(str8)) {
                                    strArr2 = strArr4;
                                    string = null;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("0");
                                    strArr2 = strArr4;
                                    sb2.append(strArr4[i7].substring(3));
                                    string = sb2.toString();
                                }
                            }
                            if (str11 != null && string != null && (str11.startsWith(str10) || str11.contains(str10) || string.startsWith(str10) || string.contains(str10))) {
                                z4 = true;
                                break;
                            }
                            i7++;
                            strArr4 = strArr2;
                            z4 = z3;
                            strArr3 = strArr;
                            i5 = 3;
                            str9 = str8;
                            i3 = i2;
                        }
                        i2 = i3;
                        strArr = strArr3;
                        str8 = str9;
                        strArr2 = strArr4;
                        if (z4) {
                            arrayList3.add(AndroidUtilities.generateSearchName(user.phone, "", str10));
                            arrayList2.add(user);
                            break;
                        }
                        i6++;
                        strArr4 = strArr2;
                        strArr3 = strArr;
                        i5 = 3;
                        str9 = str8;
                        i3 = i2;
                    }
                    i2 = i3;
                    strArr = strArr3;
                }
                i4++;
                strArr3 = strArr;
                i3 = i2;
                c = 0;
            }
            int i8 = i3;
            String[] strArr5 = strArr3;
            String str12 = "+98";
            int i9 = 0;
            while (i9 < StartCallOutActivity.this.phoneBookContacts.size()) {
                ContactsController.Contact contact = (ContactsController.Contact) StartCallOutActivity.this.phoneBookContacts.get(i9);
                String str13 = contact.phones.get(0);
                if (str13 != null && str13.startsWith("98")) {
                    str2 = "0" + contact.phones.get(0).substring(2);
                } else if (str13 == null || !str13.startsWith(str12)) {
                    str2 = null;
                } else {
                    str2 = "0" + contact.phones.get(0).substring(3);
                }
                int i10 = i8;
                int i11 = 0;
                boolean z5 = false;
                while (i11 < i10) {
                    String str14 = strArr5[i11];
                    if ((str13 != null && (str13.startsWith(str14) || str13.contains(str14))) || (str2 != null && (str2.startsWith(str14) || str2.contains(str14)))) {
                        z5 = true;
                    }
                    if (!z5) {
                        str4 = str13;
                        str5 = str12;
                        str6 = str2;
                        z = z5;
                    } else if (contact.user != null && arrayList2.size() > 0) {
                        Iterator<Object> it2 = arrayList2.iterator();
                        while (true) {
                            str4 = str13;
                            if (!it2.hasNext()) {
                                str5 = str12;
                                str6 = str2;
                                z = z5;
                                z2 = false;
                                break;
                            }
                            Object next = it2.next();
                            str5 = str12;
                            if (next instanceof TLRPC$User) {
                                str6 = str2;
                                it = it2;
                                z = z5;
                                if (((TLRPC$User) next).id == contact.user.id) {
                                    z2 = true;
                                    break;
                                }
                            } else {
                                str6 = str2;
                                it = it2;
                                z = z5;
                            }
                            str13 = str4;
                            str2 = str6;
                            str12 = str5;
                            z5 = z;
                            it2 = it;
                        }
                        if (!z2) {
                            arrayList3.add(AndroidUtilities.generateSearchName(contact.phones.get(0), "", str14));
                            arrayList2.add(contact);
                        }
                        i11++;
                        str13 = str4;
                        str2 = str6;
                        str12 = str5;
                        z5 = z;
                    } else {
                        str3 = str12;
                        arrayList3.add(AndroidUtilities.generateSearchName(contact.phones.get(0), "", str14));
                        arrayList2.add(contact);
                        break;
                    }
                    i11++;
                    str13 = str4;
                    str2 = str6;
                    str12 = str5;
                    z5 = z;
                }
                str3 = str12;
                i9++;
                i8 = i10;
                str12 = str3;
            }
            this.searchResultArray = arrayList2;
            this.searchResultArrayNames = arrayList3;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.CallOut.StartCallOutActivity.SuggestAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    StartCallOutActivity.this.suggestAdapter.notifyDataSetChanged();
                }
            });
        }

        public Object getItem(int position) {
            return this.searchResultArray.get(position);
        }

        public void clearSearchResult() {
            this.searchResultArray.clear();
            this.searchResultArrayNames.clear();
            notifyDataSetChanged();
        }

        public void showSelectedContact(Object contact, CharSequence searchLable) {
            this.searchResultArray.clear();
            this.searchResultArrayNames.clear();
            this.searchResultArray.add(contact);
            this.searchResultArrayNames.add(searchLable);
            notifyDataSetChanged();
        }
    }
}
