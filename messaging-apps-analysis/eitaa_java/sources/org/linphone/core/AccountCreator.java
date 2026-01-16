package org.linphone.core;

/* loaded from: classes3.dex */
public interface AccountCreator {
    Status activateAccount();

    Status activateAlias();

    void addListener(AccountCreatorListener accountCreatorListener);

    AccountCreator create(Core core);

    Status createAccount();

    Account createAccountInCore();

    @Deprecated
    ProxyConfig createProxyConfig();

    String getAccountCreationRequestToken();

    String getActivationCode();

    String getAlgorithm();

    String getDisplayName();

    String getDomain();

    String getEmail();

    String getHa1();

    String getLanguage();

    long getNativePointer();

    String getPassword();

    String getPhoneCountryCode();

    String getPhoneNumber();

    String getPnParam();

    String getPnPrid();

    String getPnProvider();

    String getRoute();

    boolean getSetAsDefault();

    String getToken();

    TransportType getTransport();

    Object getUserData();

    String getUsername();

    Status isAccountActivated();

    Status isAccountExist();

    Status isAccountLinked();

    Status isAliasUsed();

    Status linkAccount();

    Status loginLinphoneAccount();

    Status recoverAccount();

    void removeListener(AccountCreatorListener accountCreatorListener);

    Status requestAccountCreationRequestToken();

    Status requestAccountCreationTokenUsingRequestToken();

    Status requestAuthToken();

    void reset();

    void setAccountCreationRequestToken(String str);

    ActivationCodeStatus setActivationCode(String str);

    AccountCreatorAlgoStatus setAlgorithm(String str);

    Status setAsDefault(boolean z);

    UsernameStatus setDisplayName(String str);

    DomainStatus setDomain(String str);

    EmailStatus setEmail(String str);

    PasswordStatus setHa1(String str);

    LanguageStatus setLanguage(String str);

    PasswordStatus setPassword(String str);

    int setPhoneNumber(String str, String str2);

    void setPnParam(String str);

    void setPnPrid(String str);

    void setPnProvider(String str);

    void setProxyConfig(ProxyConfig proxyConfig);

    Status setRoute(String str);

    void setToken(String str);

    TransportStatus setTransport(TransportType transportType);

    void setUserData(Object obj);

    UsernameStatus setUsername(String str);

    String toString();

    Status updateAccount();

    void useTestAdminAccount();

    public enum TransportStatus {
        Ok(0),
        Unsupported(1);

        protected final int mValue;

        TransportStatus(int i) {
            this.mValue = i;
        }

        public static TransportStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return Unsupported;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for TransportStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum DomainStatus {
        Ok(0),
        Invalid(1);

        protected final int mValue;

        DomainStatus(int i) {
            this.mValue = i;
        }

        public static DomainStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return Invalid;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for DomainStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum ActivationCodeStatus {
        Ok(0),
        TooShort(1),
        TooLong(2),
        InvalidCharacters(3);

        protected final int mValue;

        ActivationCodeStatus(int i) {
            this.mValue = i;
        }

        public static ActivationCodeStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return TooShort;
            }
            if (i == 2) {
                return TooLong;
            }
            if (i == 3) {
                return InvalidCharacters;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for ActivationCodeStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum LanguageStatus {
        Ok(0);

        protected final int mValue;

        LanguageStatus(int i) {
            this.mValue = i;
        }

        public static LanguageStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for LanguageStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum PasswordStatus {
        Ok(0),
        TooShort(1),
        TooLong(2),
        InvalidCharacters(3),
        MissingCharacters(4);

        protected final int mValue;

        PasswordStatus(int i) {
            this.mValue = i;
        }

        public static PasswordStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return TooShort;
            }
            if (i == 2) {
                return TooLong;
            }
            if (i == 3) {
                return InvalidCharacters;
            }
            if (i == 4) {
                return MissingCharacters;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for PasswordStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum EmailStatus {
        Ok(0),
        Malformed(1),
        InvalidCharacters(2);

        protected final int mValue;

        EmailStatus(int i) {
            this.mValue = i;
        }

        public static EmailStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return Malformed;
            }
            if (i == 2) {
                return InvalidCharacters;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for EmailStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum UsernameStatus {
        Ok(0),
        TooShort(1),
        TooLong(2),
        InvalidCharacters(3),
        Invalid(4);

        protected final int mValue;

        UsernameStatus(int i) {
            this.mValue = i;
        }

        public static UsernameStatus fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Ok;
            }
            if (i == 1) {
                return TooShort;
            }
            if (i == 2) {
                return TooLong;
            }
            if (i == 3) {
                return InvalidCharacters;
            }
            if (i == 4) {
                return Invalid;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for UsernameStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum PhoneNumberStatus {
        Ok(1),
        TooShort(2),
        TooLong(4),
        InvalidCountryCode(8),
        Invalid(16);

        protected final int mValue;

        PhoneNumberStatus(int i) {
            this.mValue = i;
        }

        public static PhoneNumberStatus fromInt(int i) throws RuntimeException {
            if (i == 1) {
                return Ok;
            }
            if (i == 2) {
                return TooShort;
            }
            if (i == 4) {
                return TooLong;
            }
            if (i == 8) {
                return InvalidCountryCode;
            }
            if (i == 16) {
                return Invalid;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for PhoneNumberStatus");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum Status {
        RequestOk(0),
        RequestFailed(1),
        MissingArguments(2),
        MissingCallbacks(3),
        AccountCreated(4),
        AccountNotCreated(5),
        AccountExist(6),
        AccountExistWithAlias(7),
        AccountNotExist(8),
        AliasIsAccount(9),
        AliasExist(10),
        AliasNotExist(11),
        AccountActivated(12),
        AccountAlreadyActivated(13),
        AccountNotActivated(14),
        AccountLinked(15),
        AccountNotLinked(16),
        ServerError(17),
        PhoneNumberInvalid(18),
        WrongActivationCode(19),
        PhoneNumberOverused(20),
        AlgoNotSupported(21),
        UnexpectedError(22),
        NotImplementedError(23),
        RequestNotAuthorized(24);

        protected final int mValue;

        Status(int i) {
            this.mValue = i;
        }

        public static Status fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return RequestOk;
                case 1:
                    return RequestFailed;
                case 2:
                    return MissingArguments;
                case 3:
                    return MissingCallbacks;
                case 4:
                    return AccountCreated;
                case 5:
                    return AccountNotCreated;
                case 6:
                    return AccountExist;
                case 7:
                    return AccountExistWithAlias;
                case 8:
                    return AccountNotExist;
                case 9:
                    return AliasIsAccount;
                case 10:
                    return AliasExist;
                case 11:
                    return AliasNotExist;
                case 12:
                    return AccountActivated;
                case 13:
                    return AccountAlreadyActivated;
                case 14:
                    return AccountNotActivated;
                case 15:
                    return AccountLinked;
                case 16:
                    return AccountNotLinked;
                case 17:
                    return ServerError;
                case 18:
                    return PhoneNumberInvalid;
                case 19:
                    return WrongActivationCode;
                case 20:
                    return PhoneNumberOverused;
                case 21:
                    return AlgoNotSupported;
                case 22:
                    return UnexpectedError;
                case 23:
                    return NotImplementedError;
                case 24:
                    return RequestNotAuthorized;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for Status");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
