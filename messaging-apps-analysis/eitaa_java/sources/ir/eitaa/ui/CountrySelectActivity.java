package ir.eitaa.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.util.ObjectsCompat$Api19Impl$$ExternalSynthetic0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.DividerCell;
import ir.eitaa.ui.Cells.LetterSectionCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class CountrySelectActivity extends BaseFragment {
    private CountrySelectActivityDelegate delegate;
    private EmptyTextProgressView emptyView;
    private ArrayList<Country> existingCountries;
    private RecyclerListView listView;
    private CountryAdapter listViewAdapter;
    private boolean needPhoneCode;
    private CountrySearchAdapter searchListViewAdapter;
    private boolean searchWas;
    private boolean searching;

    public interface CountrySelectActivityDelegate {
        void didSelectCountry(Country country);
    }

    public CountrySelectActivity(boolean phoneCode) {
        this(phoneCode, null);
    }

    public CountrySelectActivity(boolean phoneCode, ArrayList<Country> existingCountries) {
        if (existingCountries != null && !existingCountries.isEmpty()) {
            this.existingCountries = new ArrayList<>(existingCountries);
        }
        this.needPhoneCode = phoneCode;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.CountrySelectActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    CountrySelectActivity.this.finishFragment();
                }
            }
        });
        this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.CountrySelectActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                CountrySelectActivity.this.searching = true;
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                CountrySelectActivity.this.searchListViewAdapter.search(null);
                CountrySelectActivity.this.searching = false;
                CountrySelectActivity.this.searchWas = false;
                CountrySelectActivity.this.listView.setAdapter(CountrySelectActivity.this.listViewAdapter);
                CountrySelectActivity.this.listView.setFastScrollVisible(true);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                String string = editText.getText().toString();
                CountrySelectActivity.this.searchListViewAdapter.search(string);
                if (string.length() != 0) {
                    CountrySelectActivity.this.searchWas = true;
                }
            }
        }).setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searching = false;
        this.searchWas = false;
        CountryAdapter countryAdapter = new CountryAdapter(context, this.existingCountries);
        this.listViewAdapter = countryAdapter;
        this.searchListViewAdapter = new CountrySearchAdapter(context, countryAdapter.getCountries());
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showTextView();
        this.emptyView.setShowAtCenter(true);
        this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setSectionsType(1);
        this.listView.setEmptyView(this.emptyView);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setFastScrollEnabled();
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setAdapter(this.listViewAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CountrySelectActivity$cXhDZmJ57UAjwYhJJlYYLwUAf1s
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0$CountrySelectActivity(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.CountrySelectActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(CountrySelectActivity.this.getParentActivity().getCurrentFocus());
                }
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$CountrySelectActivity(View view, int i) {
        Country item;
        CountrySelectActivityDelegate countrySelectActivityDelegate;
        if (this.searching && this.searchWas) {
            item = this.searchListViewAdapter.getItem(i);
        } else {
            int sectionForPosition = this.listViewAdapter.getSectionForPosition(i);
            int positionInSectionForPosition = this.listViewAdapter.getPositionInSectionForPosition(i);
            if (positionInSectionForPosition < 0 || sectionForPosition < 0) {
                return;
            } else {
                item = this.listViewAdapter.getItem(sectionForPosition, positionInSectionForPosition);
            }
        }
        if (i < 0) {
            return;
        }
        finishFragment();
        if (item == null || (countrySelectActivityDelegate = this.delegate) == null) {
            return;
        }
        countrySelectActivityDelegate.didSelectCountry(item);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        CountryAdapter countryAdapter = this.listViewAdapter;
        if (countryAdapter != null) {
            countryAdapter.notifyDataSetChanged();
        }
    }

    public void setCountrySelectActivityDelegate(CountrySelectActivityDelegate delegate) {
        this.delegate = delegate;
    }

    public static class Country {
        public String code;
        public String name;
        public String shortname;

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || Country.class != o.getClass()) {
                return false;
            }
            Country country = (Country) o;
            return ObjectsCompat$Api19Impl$$ExternalSynthetic0.m0(this.name, country.name) && ObjectsCompat$Api19Impl$$ExternalSynthetic0.m0(this.code, country.code);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.name, this.code});
        }
    }

    public class CountryAdapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;
        private HashMap<String, ArrayList<Country>> countries = new HashMap<>();
        private ArrayList<String> sortedCountries = new ArrayList<>();

        public CountryAdapter(Context context, ArrayList<Country> exisitingCountries) throws IOException {
            this.mContext = context;
            if (exisitingCountries != null) {
                for (int i = 0; i < exisitingCountries.size(); i++) {
                    Country country = exisitingCountries.get(i);
                    String upperCase = country.name.substring(0, 1).toUpperCase();
                    ArrayList<Country> arrayList = this.countries.get(upperCase);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.countries.put(upperCase, arrayList);
                        this.sortedCountries.add(upperCase);
                    }
                    arrayList.add(country);
                }
            } else {
                try {
                    InputStream inputStreamOpen = ApplicationLoader.applicationContext.getResources().getAssets().open("countries.txt");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] strArrSplit = line.split(";");
                        Country country2 = new Country();
                        String str = strArrSplit[2];
                        country2.name = str;
                        country2.code = strArrSplit[0];
                        country2.shortname = strArrSplit[1];
                        String upperCase2 = str.substring(0, 1).toUpperCase();
                        ArrayList<Country> arrayList2 = this.countries.get(upperCase2);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                            this.countries.put(upperCase2, arrayList2);
                            this.sortedCountries.add(upperCase2);
                        }
                        arrayList2.add(country2);
                    }
                    bufferedReader.close();
                    inputStreamOpen.close();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            Collections.sort(this.sortedCountries, $$Lambda$Ds7dtVnGrflEw4LvNOxA0cDT4Y.INSTANCE);
            Iterator<ArrayList<Country>> it = this.countries.values().iterator();
            while (it.hasNext()) {
                Collections.sort(it.next(), $$Lambda$CountrySelectActivity$CountryAdapter$mHy50DGH3gcMasiLGDz6IhWoWY.INSTANCE);
            }
        }

        public HashMap<String, ArrayList<Country>> getCountries() {
            return this.countries;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Country getItem(int section, int position) {
            if (section >= 0 && section < this.sortedCountries.size()) {
                ArrayList<Country> arrayList = this.countries.get(this.sortedCountries.get(section));
                if (position >= 0 && position < arrayList.size()) {
                    return arrayList.get(position);
                }
            }
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return row < this.countries.get(this.sortedCountries.get(section)).size();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            return this.sortedCountries.size();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            int size = this.countries.get(this.sortedCountries.get(section)).size();
            return section != this.sortedCountries.size() + (-1) ? size + 1 : size;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            View view2 = view;
            if (view == null) {
                LetterSectionCell letterSectionCell = new LetterSectionCell(this.mContext);
                letterSectionCell.setCellHeight(AndroidUtilities.dp(48.0f));
                view2 = letterSectionCell;
            }
            ((LetterSectionCell) view2).setLetter(this.sortedCountries.get(i).toUpperCase());
            return view2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textSettingsCell;
            if (viewType == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 16.0f : 54.0f), 0, AndroidUtilities.dp(LocaleController.isRTL ? 54.0f : 16.0f), 0);
            } else {
                textSettingsCell = new DividerCell(this.mContext);
                textSettingsCell.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 24.0f : 72.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 24.0f), AndroidUtilities.dp(8.0f));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            String str;
            if (holder.getItemViewType() == 0) {
                Country country = this.countries.get(this.sortedCountries.get(section)).get(position);
                TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                String str2 = country.name;
                if (CountrySelectActivity.this.needPhoneCode) {
                    str = "+" + country.code;
                } else {
                    str = null;
                }
                textSettingsCell.setTextAndValue(str2, str, false);
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            return position < this.countries.get(this.sortedCountries.get(section)).size() ? 0 : 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            int sectionForPosition = getSectionForPosition(position);
            if (sectionForPosition == -1) {
                sectionForPosition = this.sortedCountries.size() - 1;
            }
            return this.sortedCountries.get(sectionForPosition);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return (int) (getItemCount() * progress);
        }
    }

    public class CountrySearchAdapter extends RecyclerListView.SelectionAdapter {
        private HashMap<String, ArrayList<Country>> countries;
        private Context mContext;
        private ArrayList<Country> searchResult;
        private Timer searchTimer;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public CountrySearchAdapter(Context context, HashMap<String, ArrayList<Country>> countries) {
            this.mContext = context;
            this.countries = countries;
        }

        public void search(final String query) {
            if (query == null) {
                this.searchResult = null;
                return;
            }
            try {
                Timer timer = this.searchTimer;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            Timer timer2 = new Timer();
            this.searchTimer = timer2;
            timer2.schedule(new TimerTask() { // from class: ir.eitaa.ui.CountrySelectActivity.CountrySearchAdapter.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        CountrySearchAdapter.this.searchTimer.cancel();
                        CountrySearchAdapter.this.searchTimer = null;
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    CountrySearchAdapter.this.processSearch(query);
                }
            }, 100L, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processSearch(final String query) {
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CountrySelectActivity$CountrySearchAdapter$pyG-YNDy-CCumB4eWit2MW0yL6A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$0$CountrySelectActivity$CountrySearchAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$0$CountrySelectActivity$CountrySearchAdapter(String str) {
            if (str.trim().toLowerCase().length() == 0) {
                updateSearchResults(new ArrayList<>());
                return;
            }
            ArrayList<Country> arrayList = new ArrayList<>();
            ArrayList<Country> arrayList2 = this.countries.get(str.substring(0, 1).toUpperCase());
            if (arrayList2 != null) {
                Iterator<Country> it = arrayList2.iterator();
                while (it.hasNext()) {
                    Country next = it.next();
                    if (next.name.toLowerCase().startsWith(str)) {
                        arrayList.add(next);
                    }
                }
            }
            updateSearchResults(arrayList);
        }

        private void updateSearchResults(final ArrayList<Country> arrCounties) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CountrySelectActivity$CountrySearchAdapter$HrSfSgpZPQgx9d55iHrvZC3ji10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$1$CountrySelectActivity$CountrySearchAdapter(arrCounties);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$1$CountrySelectActivity$CountrySearchAdapter(ArrayList arrayList) {
            if (CountrySelectActivity.this.searching) {
                this.searchResult = arrayList;
                if (CountrySelectActivity.this.searchWas && CountrySelectActivity.this.listView != null && CountrySelectActivity.this.listView.getAdapter() != CountrySelectActivity.this.searchListViewAdapter) {
                    CountrySelectActivity.this.listView.setAdapter(CountrySelectActivity.this.searchListViewAdapter);
                    CountrySelectActivity.this.listView.setFastScrollVisible(false);
                }
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<Country> arrayList = this.searchResult;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public Country getItem(int i) {
            if (i < 0 || i >= this.searchResult.size()) {
                return null;
            }
            return this.searchResult.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new TextSettingsCell(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String str;
            Country country = this.searchResult.get(position);
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            String str2 = country.name;
            if (CountrySelectActivity.this.needPhoneCode) {
                str = "+" + country.code;
            } else {
                str = null;
            }
            textSettingsCell.setTextAndValue(str2, str, position != this.searchResult.size() - 1);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollActive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollInactive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollText"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SECTIONS, new Class[]{LetterSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        return arrayList;
    }
}
