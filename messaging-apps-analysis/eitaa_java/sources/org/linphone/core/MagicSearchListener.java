package org.linphone.core;

/* loaded from: classes3.dex */
public interface MagicSearchListener {
    void onLdapHaveMoreResults(MagicSearch magicSearch, Ldap ldap);

    void onSearchResultsReceived(MagicSearch magicSearch);
}
