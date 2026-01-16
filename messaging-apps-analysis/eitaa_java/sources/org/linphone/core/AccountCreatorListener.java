package org.linphone.core;

import org.linphone.core.AccountCreator;

/* loaded from: classes3.dex */
public interface AccountCreatorListener {
    void onAccountCreationRequestToken(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onAccountCreationTokenUsingRequestToken(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onActivateAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onActivateAlias(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onCreateAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onIsAccountActivated(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onIsAccountExist(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onIsAccountLinked(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onIsAliasUsed(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onLinkAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onLoginLinphoneAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onRecoverAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onSendToken(AccountCreator accountCreator, AccountCreator.Status status, String str);

    void onUpdateAccount(AccountCreator accountCreator, AccountCreator.Status status, String str);
}
