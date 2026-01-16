package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC15808kC5;
import ir.nasim.AbstractC20985sw1;
import ir.nasim.AbstractC8375Vr7;
import ir.nasim.CD5;
import ir.nasim.HE5;
import ir.nasim.KW0;
import ir.nasim.PC5;
import ir.nasim.YA5;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements KW0 {
    static final o e1;
    private Rect A;
    private final Intent A0;
    private int[] B;
    private final Intent B0;
    private final CharSequence C0;
    private int[] D;
    private m D0;
    View.OnFocusChangeListener E0;
    private View.OnClickListener F0;
    private final ImageView G;
    private boolean G0;
    private final Drawable H;
    private boolean H0;
    AbstractC20985sw1 I0;
    private final int J;
    private boolean J0;
    private CharSequence K0;
    private boolean L0;
    private boolean M0;
    private int N0;
    private boolean O0;
    private CharSequence P0;
    private CharSequence Q0;
    private boolean R0;
    private int S0;
    SearchableInfo T0;
    private Bundle U0;
    private final Runnable V0;
    private Runnable W0;
    private final WeakHashMap X0;
    private final View.OnClickListener Y0;
    View.OnKeyListener Z0;
    private final TextView.OnEditorActionListener a1;
    private final AdapterView.OnItemClickListener b1;
    private final AdapterView.OnItemSelectedListener c1;
    private TextWatcher d1;
    final SearchAutoComplete p;
    private final View q;
    private final View r;
    private final View s;
    final ImageView t;
    final ImageView u;
    final ImageView v;
    final ImageView w;
    private final View x;
    private p y;
    private Rect z;
    private final int z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean c;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int e;
        private SearchView f;
        private boolean g;
        final Runnable h;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        void b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.e1.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void d() {
            if (this.g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                removeCallbacks(this.h);
                post(this.h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, i, rect);
            this.f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.f.hasFocus() && getVisibility() == 0) {
                this.g = true;
                if (SearchView.M(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.g = true;
                    return;
                }
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.e = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC15790kA5.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.h = new a();
            this.e = getThreshold();
        }
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.Y(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.e0();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC20985sw1 abstractC20985sw1 = SearchView.this.I0;
            if (abstractC20985sw1 instanceof x) {
                abstractC20985sw1.a(null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.E0;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.B();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SearchView searchView = SearchView.this;
            if (view == searchView.t) {
                searchView.V();
                return;
            }
            if (view == searchView.v) {
                searchView.R();
                return;
            }
            if (view == searchView.u) {
                searchView.W();
            } else if (view == searchView.w) {
                searchView.a0();
            } else if (view == searchView.p) {
                searchView.H();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.T0 == null) {
                return false;
            }
            if (searchView.p.isPopupShowing() && SearchView.this.p.getListSelection() != -1) {
                return SearchView.this.X(view, i, keyEvent);
            }
            if (SearchView.this.p.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.p.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.S(i, 0, null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            SearchView.this.T(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    public interface l {
    }

    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    public interface n {
    }

    private static class o {
        private Method a;
        private Method b;
        private Method c;

        o() throws NoSuchMethodException, SecurityException {
            this.a = null;
            this.b = null;
            this.c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            d();
            Method method = this.c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static class p extends TouchDelegate {
        private final View a;
        private final Rect b;
        private final Rect c;
        private final Rect d;
        private final int e;
        private boolean f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.b = new Rect();
            this.d = new Rect();
            this.c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.b.contains(x, y)) {
                this.f = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.c.contains(x, y)) {
                Rect rect = this.c;
                motionEvent.setLocation(x - rect.left, y - rect.top);
            } else {
                motionEvent.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
            }
            return this.a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        e1 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.Q0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.U0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.T0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i2, String str) {
        int position;
        String strO;
        try {
            String strO2 = x.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.T0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = x.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.T0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = x.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + Separators.SLASH + Uri.encode(strO);
            }
            return C(str2, strO3 == null ? null : Uri.parse(strO3), x.o(cursor, "suggest_intent_extra_data"), x.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.U0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.p.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.B);
        getLocationInWindow(this.D);
        int[] iArr = this.B;
        int i2 = iArr[1];
        int[] iArr2 = this.D;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.G0 || this.H == null) {
            return charSequence;
        }
        int textSize = (int) (this.p.getTextSize() * 1.25d);
        this.H.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.H), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.T0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.T0.getVoiceSearchLaunchWebSearch() ? this.A0 : this.T0.getVoiceSearchLaunchRecognizer() ? this.B0 : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.J0 || this.O0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private boolean Q(int i2, int i3, String str) {
        Cursor cursorD = this.I0.d();
        if (cursorD == null || !cursorD.moveToPosition(i2)) {
            return false;
        }
        O(D(cursorD, i3, str));
        return true;
    }

    private void b0() {
        post(this.V0);
    }

    private void c0(int i2) {
        Editable text = this.p.getText();
        Cursor cursorD = this.I0.d();
        if (cursorD == null) {
            return;
        }
        if (!cursorD.moveToPosition(i2)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceB = this.I0.b(cursorD);
        if (charSequenceB != null) {
            setQuery(charSequenceB);
        } else {
            setQuery(text);
        }
    }

    private void d0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.p.getText());
        if (!z2 && (!this.G0 || this.R0)) {
            z = false;
        }
        this.v.setVisibility(z ? 0 : 8);
        Drawable drawable = this.v.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void f0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private void g0() {
        this.p.setThreshold(this.T0.getSuggestThreshold());
        this.p.setImeOptions(this.T0.getImeOptions());
        int inputType = this.T0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.T0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.p.setInputType(inputType);
        AbstractC20985sw1 abstractC20985sw1 = this.I0;
        if (abstractC20985sw1 != null) {
            abstractC20985sw1.a(null);
        }
        if (this.T0.getSuggestAuthority() != null) {
            x xVar = new x(getContext(), this, this.T0, this.X0);
            this.I0 = xVar;
            this.p.setAdapter(xVar);
            ((x) this.I0).x(this.L0 ? 2 : 1);
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(YA5.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(YA5.abc_search_view_preferred_width);
    }

    private void h0() {
        this.s.setVisibility((N() && (this.u.getVisibility() == 0 || this.w.getVisibility() == 0)) ? 0 : 8);
    }

    private void i0(boolean z) {
        this.u.setVisibility((this.J0 && N() && hasFocus() && (z || !this.O0)) ? 0 : 8);
    }

    private void j0(boolean z) {
        this.H0 = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.p.getText());
        this.t.setVisibility(i3);
        i0(!zIsEmpty);
        this.q.setVisibility(z ? 8 : 0);
        if (this.G.getDrawable() != null && !this.G0) {
            i2 = 0;
        }
        this.G.setVisibility(i2);
        d0();
        k0(zIsEmpty);
        h0();
    }

    private void k0(boolean z) {
        int i2 = 8;
        if (this.O0 && !L() && z) {
            this.u.setVisibility(8);
            i2 = 0;
        }
        this.w.setVisibility(i2);
    }

    void B() {
        if (this.x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.r.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = F.b(this);
            int dimensionPixelSize = this.G0 ? resources.getDimensionPixelSize(YA5.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(YA5.abc_dropdownitem_text_padding_left) : 0;
            this.p.getDropDownBackground().getPadding(rect);
            this.p.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.p.setDropDownWidth((((this.x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.p);
            return;
        }
        o oVar = e1;
        oVar.b(this.p);
        oVar.a(this.p);
    }

    public boolean L() {
        return this.H0;
    }

    void P(int i2, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.p.getText())) {
            this.p.setText("");
            this.p.requestFocus();
            this.p.setImeVisibility(true);
        } else if (this.G0) {
            clearFocus();
            j0(true);
        }
    }

    boolean S(int i2, int i3, String str) {
        Q(i2, 0, null);
        this.p.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i2) {
        c0(i2);
        return true;
    }

    protected void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        j0(false);
        this.p.requestFocus();
        this.p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.F0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.p.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.D0;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.T0 != null) {
                P(0, null, text.toString());
            }
            this.p.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i2, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.T0 != null && this.I0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return S(this.p.getListSelection(), 0, null);
            }
            if (i2 == 21 || i2 == 22) {
                this.p.setSelection(i2 == 21 ? 0 : this.p.length());
                this.p.setListSelection(0);
                this.p.clearListSelection();
                this.p.b();
                return true;
            }
            if (i2 == 19) {
                this.p.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.p.getText();
        this.Q0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        i0(!zIsEmpty);
        k0(zIsEmpty);
        d0();
        h0();
        if (this.D0 != null && !TextUtils.equals(charSequence, this.P0)) {
            this.D0.a(charSequence.toString());
        }
        this.P0 = charSequence.toString();
    }

    void Z() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j0(L());
        b0();
        if (this.p.hasFocus()) {
            H();
        }
    }

    void a0() {
        SearchableInfo searchableInfo = this.T0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(F(this.A0, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(E(this.B0, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // ir.nasim.KW0
    public void b() {
        if (this.R0) {
            return;
        }
        this.R0 = true;
        int imeOptions = this.p.getImeOptions();
        this.S0 = imeOptions;
        this.p.setImeOptions(imeOptions | 33554432);
        this.p.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.M0 = true;
        super.clearFocus();
        this.p.clearFocus();
        this.p.setImeVisibility(false);
        this.M0 = false;
    }

    void e0() {
        int[] iArr = this.p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // ir.nasim.KW0
    public void f() {
        setQuery("", false);
        clearFocus();
        j0(true);
        this.p.setImeOptions(this.S0);
        this.R0 = false;
    }

    public int getImeOptions() {
        return this.p.getImeOptions();
    }

    public int getInputType() {
        return this.p.getInputType();
    }

    public int getMaxWidth() {
        return this.N0;
    }

    public CharSequence getQuery() {
        return this.p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.K0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.T0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.C0 : getContext().getText(this.T0.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.z0;
    }

    int getSuggestionRowLayout() {
        return this.J;
    }

    public AbstractC20985sw1 getSuggestionsAdapter() {
        return this.I0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.V0);
        post(this.W0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            I(this.p, this.z);
            Rect rect = this.A;
            Rect rect2 = this.z;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.y;
            if (pVar != null) {
                pVar.a(this.A, this.z);
                return;
            }
            p pVar2 = new p(this.A, this.z, this.p);
            this.y = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        if (L()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.N0;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.N0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.N0) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        j0(savedState.c);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = L();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (this.M0 || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i2, rect);
        }
        boolean zRequestFocus = this.p.requestFocus(i2, rect);
        if (zRequestFocus) {
            j0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.U0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.G0 == z) {
            return;
        }
        this.G0 = z;
        j0(z);
        f0();
    }

    public void setImeOptions(int i2) {
        this.p.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.p.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.N0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.E0 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.D0 = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.F0 = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.Q0 = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.K0 = charSequence;
        f0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.L0 = z;
        AbstractC20985sw1 abstractC20985sw1 = this.I0;
        if (abstractC20985sw1 instanceof x) {
            ((x) abstractC20985sw1).x(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.T0 = searchableInfo;
        if (searchableInfo != null) {
            g0();
            f0();
        }
        boolean zK = K();
        this.O0 = zK;
        if (zK) {
            this.p.setPrivateImeOptions("nm");
        }
        j0(L());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.J0 = z;
        j0(L());
    }

    public void setSuggestionsAdapter(AbstractC20985sw1 abstractC20985sw1) {
        this.I0 = abstractC20985sw1;
        this.p.setAdapter(abstractC20985sw1);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.D = new int[2];
        this.V0 = new b();
        this.W0 = new c();
        this.X0 = new WeakHashMap();
        f fVar = new f();
        this.Y0 = fVar;
        this.Z0 = new g();
        h hVar = new h();
        this.a1 = hVar;
        i iVar = new i();
        this.b1 = iVar;
        j jVar = new j();
        this.c1 = jVar;
        this.d1 = new a();
        C cV = C.v(context, attributeSet, HE5.SearchView, i2, 0);
        AbstractC12990fW7.n0(this, context, HE5.SearchView, attributeSet, cV.r(), i2, 0);
        LayoutInflater.from(context).inflate(cV.n(HE5.SearchView_layout, PC5.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(AbstractC15808kC5.search_src_text);
        this.p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.q = findViewById(AbstractC15808kC5.search_edit_frame);
        View viewFindViewById = findViewById(AbstractC15808kC5.search_plate);
        this.r = viewFindViewById;
        View viewFindViewById2 = findViewById(AbstractC15808kC5.submit_area);
        this.s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(AbstractC15808kC5.search_button);
        this.t = imageView;
        ImageView imageView2 = (ImageView) findViewById(AbstractC15808kC5.search_go_btn);
        this.u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(AbstractC15808kC5.search_close_btn);
        this.v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(AbstractC15808kC5.search_voice_btn);
        this.w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(AbstractC15808kC5.search_mag_icon);
        this.G = imageView5;
        AbstractC12990fW7.t0(viewFindViewById, cV.g(HE5.SearchView_queryBackground));
        AbstractC12990fW7.t0(viewFindViewById2, cV.g(HE5.SearchView_submitBackground));
        imageView.setImageDrawable(cV.g(HE5.SearchView_searchIcon));
        imageView2.setImageDrawable(cV.g(HE5.SearchView_goIcon));
        imageView3.setImageDrawable(cV.g(HE5.SearchView_closeIcon));
        imageView4.setImageDrawable(cV.g(HE5.SearchView_voiceIcon));
        imageView5.setImageDrawable(cV.g(HE5.SearchView_searchIcon));
        this.H = cV.g(HE5.SearchView_searchHintIcon);
        AbstractC8375Vr7.a(imageView, getResources().getString(CD5.abc_searchview_description_search));
        this.J = cV.n(HE5.SearchView_suggestionRowLayout, PC5.abc_search_dropdown_item_icons_2line);
        this.z0 = cV.n(HE5.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.d1);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.Z0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(cV.a(HE5.SearchView_iconifiedByDefault, true));
        int iF = cV.f(HE5.SearchView_android_maxWidth, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.C0 = cV.p(HE5.SearchView_defaultQueryHint);
        this.K0 = cV.p(HE5.SearchView_queryHint);
        int iK = cV.k(HE5.SearchView_android_imeOptions, -1);
        if (iK != -1) {
            setImeOptions(iK);
        }
        int iK2 = cV.k(HE5.SearchView_android_inputType, -1);
        if (iK2 != -1) {
            setInputType(iK2);
        }
        setFocusable(cV.a(HE5.SearchView_android_focusable, true));
        cV.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.A0 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.B0 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        j0(this.G0);
        f0();
    }

    private void setQuery(CharSequence charSequence) {
        this.p.setText(charSequence);
        this.p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }
}
