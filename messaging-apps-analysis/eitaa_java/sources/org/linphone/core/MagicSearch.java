package org.linphone.core;

/* loaded from: classes3.dex */
public interface MagicSearch {
    void addListener(MagicSearchListener magicSearchListener);

    @Deprecated
    SearchResult[] getContactListFromFilter(String str, String str2);

    @Deprecated
    void getContactListFromFilterAsync(String str, String str2);

    @Deprecated
    SearchResult[] getContacts(String str, String str2, int i);

    @Deprecated
    void getContactsAsync(String str, String str2, int i);

    SearchResult[] getContactsList(String str, String str2, int i, MagicSearchAggregation magicSearchAggregation);

    void getContactsListAsync(String str, String str2, int i, MagicSearchAggregation magicSearchAggregation);

    String getDelimiter();

    SearchResult[] getLastSearch();

    boolean getLimitedSearch();

    int getMaxWeight();

    int getMinWeight();

    long getNativePointer();

    int getSearchLimit();

    boolean getUseDelimiter();

    Object getUserData();

    void removeListener(MagicSearchListener magicSearchListener);

    void resetSearchCache();

    void setDelimiter(String str);

    void setLimitedSearch(boolean z);

    void setMaxWeight(int i);

    void setMinWeight(int i);

    void setSearchLimit(int i);

    void setUseDelimiter(boolean z);

    void setUserData(Object obj);

    String toString();
}
