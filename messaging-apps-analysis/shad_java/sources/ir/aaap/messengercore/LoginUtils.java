package ir.aaap.messengercore;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.LogInException;
import ir.aaap.messengercore.model.UserInfoFromServer;
import ir.aaap.messengercore.model.api.AbortTwoStepSetupInput;
import ir.aaap.messengercore.model.api.AbortTwoStepSetupOutput;
import ir.aaap.messengercore.model.api.ChangePasswordInput;
import ir.aaap.messengercore.model.api.CheckTwoStepPasscodeOutput;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordInput;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordOutput;
import ir.aaap.messengercore.model.api.GetMySessionsInput;
import ir.aaap.messengercore.model.api.GetMySessionsOutput;
import ir.aaap.messengercore.model.api.GetTwoPasscodeStatusInput;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepInput;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepOutput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordInput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordOutput;
import ir.aaap.messengercore.model.api.LogoutInput;
import ir.aaap.messengercore.model.api.LogoutOutput;
import ir.aaap.messengercore.model.api.PasswordInput;
import ir.aaap.messengercore.model.api.RegisterDeviceInput;
import ir.aaap.messengercore.model.api.RegisterDeviceOutput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberInput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.RequestDeleteAccountInput;
import ir.aaap.messengercore.model.api.RequestDeleteAccountOutput;
import ir.aaap.messengercore.model.api.RequestForgetPasswordInput;
import ir.aaap.messengercore.model.api.RequestForgetPasswordOutput;
import ir.aaap.messengercore.model.api.RequestRecoveryEmailInput;
import ir.aaap.messengercore.model.api.ResendCodeRecoveryEmailOutput;
import ir.aaap.messengercore.model.api.SendCodeInput;
import ir.aaap.messengercore.model.api.SendCodeOutput;
import ir.aaap.messengercore.model.api.SetPublicKeyInput;
import ir.aaap.messengercore.model.api.SetPublicKeyOutput;
import ir.aaap.messengercore.model.api.SetupTwoStepVerificationInput;
import ir.aaap.messengercore.model.api.SignInInput;
import ir.aaap.messengercore.model.api.SignInOutput;
import ir.aaap.messengercore.model.api.TerminateOtherSessionInput;
import ir.aaap.messengercore.model.api.TerminateOtherSessionOutput;
import ir.aaap.messengercore.model.api.TerminateSessionInput;
import ir.aaap.messengercore.model.api.TerminateSessionOutput;
import ir.aaap.messengercore.model.api.TurnOffTwoStepInput;
import ir.aaap.messengercore.model.api.TurnOffTwoStepOutput;
import ir.aaap.messengercore.model.api.TwoPasscodeStatusOutput;
import ir.aaap.messengercore.model.api.TwoStepStatusObject;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberInput;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailInput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.utilites.CoreLog;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;

/* loaded from: classes3.dex */
public class LoginUtils {
    String SALTCHARS = "abcdefghigklmnopqrstuvwxyz1234567890";
    CoreLog coreLog;
    private boolean isLogoutLoading;
    private boolean isSendCodeLoading;
    private boolean isSignInLoading;
    private boolean isSwitchToV6InProgress;

    public LoginUtils(CoreLog coreLog) {
        this.coreLog = coreLog;
    }

    public void sendCode(String str, String str2, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, CoreLog coreLog, final LoadListener<SendCodeOutput> loadListener) {
        if (this.isSendCodeLoading) {
            return;
        }
        if (str == null) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.nullInputs, str));
                return;
            }
            return;
        }
        final String strProcessPhone = processPhone(str);
        if (!CoreUtilities.isValidPhoneNumber(strProcessPhone)) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.phoneIsNotCorrect, strProcessPhone));
                return;
            }
            return;
        }
        this.isSendCodeLoading = true;
        SendCodeInput sendCodeInput = new SendCodeInput();
        sendCodeInput.phone_number = strProcessPhone;
        sendCodeInput.pass_key = str2;
        try {
            networkHelper.sendCode(getTempSession(), sendCodeInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendCodeOutput>() { // from class: ir.aaap.messengercore.LoginUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendCodeOutput sendCodeOutput) {
                    LoginUtils.this.isSendCodeLoading = false;
                    if (sendCodeOutput != null) {
                        SendCodeOutput.Status status = sendCodeOutput.status;
                        if (status == SendCodeOutput.Status.OK) {
                            keyValueStorageHelper.setLoginInfo(sendCodeOutput.phone_code_hash, sendCodeOutput.code_digits_count, System.currentTimeMillis(), strProcessPhone);
                        } else if (status == SendCodeOutput.Status.SendPassKey) {
                            keyValueStorageHelper.setLoginInfo(BuildConfig.FLAVOR, 0L, 0L, strProcessPhone);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(sendCodeOutput);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoginUtils.this.isSendCodeLoading = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.isSendCodeLoading = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
            coreLog.handleException(e);
        }
    }

    private String processPhone(String str) {
        if (!CoreUtilities.checkPhoneNumber(str)) {
            return str;
        }
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        if (str.startsWith("0")) {
            str = str.substring(1);
        }
        if (str.startsWith("0")) {
            str = str.substring(1);
        }
        if (str.startsWith("98")) {
            return str;
        }
        return "98" + str;
    }

    public void signIn(NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, JsonHelper jsonHelper, final CoreEncryptionHelper coreEncryptionHelper, CoreLog coreLog, String str, String str2, String str3, final LoadListener<SignInOutput> loadListener) {
        if (this.isSignInLoading) {
            return;
        }
        if (str == null || str3 == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.nullInputs, str));
                return;
            }
            return;
        }
        this.isSignInLoading = true;
        String strProcessPhone = processPhone(str);
        SignInInput signInInput = new SignInInput();
        signInInput.phone_code = str3;
        signInInput.phone_code_hash = str2;
        signInInput.phone_number = strProcessPhone;
        generateKeyIfNeeded(keyValueStorageHelper, coreEncryptionHelper);
        try {
            signInInput.public_key = coreEncryptionHelper.encodeChars(coreEncryptionHelper.toPemString(getPublicKey(keyValueStorageHelper)));
        } catch (Exception unused) {
        }
        if (signInInput.public_key == null) {
            this.isSignInLoading = false;
            onSwitchToV6Failed(keyValueStorageHelper);
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.AuthNull));
                return;
            }
            return;
        }
        try {
            networkHelper.signIn(getTempSession(), signInInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SignInOutput>() { // from class: ir.aaap.messengercore.LoginUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SignInOutput signInOutput) {
                    LoginUtils.this.isSignInLoading = false;
                    if (signInOutput != null) {
                        SignInOutput.Status status = signInOutput.status;
                        if (status == SignInOutput.Status.OK && signInOutput.user != null) {
                            String strDecryptRSA = null;
                            CoreEncryptionHelper coreEncryptionHelper2 = coreEncryptionHelper;
                            if (coreEncryptionHelper2 != null) {
                                try {
                                    strDecryptRSA = coreEncryptionHelper2.decryptRSA(signInOutput.auth, LoginUtils.this.getPrivateKey(keyValueStorageHelper));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (GeneralSecurityException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (strDecryptRSA != null) {
                                keyValueStorageHelper.setAuth(strDecryptRSA);
                                LoginUtils.this.onSwitchToV6Success(keyValueStorageHelper);
                                UserInfoFromServer userInfoFromServer = signInOutput.user;
                                userInfoFromServer.timestamp = signInOutput.timeStamp;
                                keyValueStorageHelper.setMyUserObject(userInfoFromServer, System.currentTimeMillis());
                                String str4 = signInOutput.user.user_guid;
                                if (str4 != null && !str4.isEmpty()) {
                                    keyValueStorageHelper.setUserGuid(signInOutput.user.user_guid);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onDidLoad(signInOutput);
                                    return;
                                }
                                return;
                            }
                            LoginUtils.this.onSwitchToV6Failed(keyValueStorageHelper);
                            LoadListener loadListener3 = loadListener;
                            if (loadListener3 != null) {
                                loadListener3.onError(new LogInException(LogInException.ErrorEnum.AuthNull));
                                return;
                            }
                            return;
                        }
                        if (status == SignInOutput.Status.CodeIsUsed) {
                            LoadListener loadListener4 = loadListener;
                            if (loadListener4 != null) {
                                loadListener4.onError(new LogInException(LogInException.ErrorEnum.CodeIsUsed));
                                return;
                            }
                            return;
                        }
                        if (status == SignInOutput.Status.CodeIsExpired) {
                            LoadListener loadListener5 = loadListener;
                            if (loadListener5 != null) {
                                loadListener5.onError(new LogInException(LogInException.ErrorEnum.CodeIsExpired));
                                return;
                            }
                            return;
                        }
                        if (status == SignInOutput.Status.CodeIsInvalid) {
                            LoadListener loadListener6 = loadListener;
                            if (loadListener6 != null) {
                                loadListener6.onError(new LogInException(LogInException.ErrorEnum.CodeIsInvalid));
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener7 = loadListener;
                        if (loadListener7 != null) {
                            loadListener7.onError(new LogInException(LogInException.ErrorEnum.signInFailed));
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoginUtils.this.isSignInLoading = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.isSignInLoading = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
            coreLog.handleException(e);
        }
    }

    public int logout(String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (this.isLogoutLoading) {
            return 0;
        }
        this.isLogoutLoading = true;
        try {
            return networkHelper.logout(str, new LogoutInput(), RetryObject.getCountAndDelayRetryWithTime(5, 1, 2, 2), new NetworkHelper.ResponseListener<LogoutOutput>() { // from class: ir.aaap.messengercore.LoginUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LogoutOutput logoutOutput) {
                    LoginUtils.this.isLogoutLoading = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoginUtils.this.isLogoutLoading = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.isLogoutLoading = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void checkTwoStepPasscode(String str, String str2, NetworkHelper networkHelper, final LoadListener<Boolean> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onDidLoad(Boolean.FALSE);
                return;
            }
            return;
        }
        try {
            networkHelper.checkTwoStepPasscode(str2, new PasswordInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<CheckTwoStepPasscodeOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.4
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(CheckTwoStepPasscodeOutput checkTwoStepPasscodeOutput) {
                    if (checkTwoStepPasscodeOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(Boolean.valueOf(checkTwoStepPasscodeOutput.is_valid));
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setupTwoStepVerification(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<TwoStepStatusObject> loadListener) {
        if (str == null || str.isEmpty() || !CoreUtilities.checkPassword(str)) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        SetupTwoStepVerificationInput setupTwoStepVerificationInput = new SetupTwoStepVerificationInput();
        setupTwoStepVerificationInput.password = str;
        if (str2 == null || str2.isEmpty()) {
            str2 = null;
        }
        setupTwoStepVerificationInput.hint = str2;
        if (str3 == null || str3.isEmpty()) {
            str3 = null;
        }
        setupTwoStepVerificationInput.recovery_email = str3;
        try {
            networkHelper.setupTwoStepVerification(str4, setupTwoStepVerificationInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TwoPasscodeStatusOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                    if (twoPasscodeStatusOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(twoPasscodeStatusOutput.two_step_status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void turnOffTwoStep(String str, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            networkHelper.turnOffTwoStep(str2, new TurnOffTwoStepInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TurnOffTwoStepOutput>() { // from class: ir.aaap.messengercore.LoginUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TurnOffTwoStepOutput turnOffTwoStepOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                    LoginUtils.this.coreLog.handleException(exc);
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void verifyRecoveryEmail(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<VerifyRecoveryEmailOutput.StatusEnum> loadListener) {
        if (str2 == null || str2.isEmpty()) {
            if (loadListener != null) {
                loadListener.onDidLoad(null);
                return;
            }
            return;
        }
        VerifyRecoveryEmailInput verifyRecoveryEmailInput = new VerifyRecoveryEmailInput();
        verifyRecoveryEmailInput.code = str2;
        verifyRecoveryEmailInput.password = str;
        try {
            networkHelper.verifyRecoveryEmail(str3, verifyRecoveryEmailInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VerifyRecoveryEmailOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.7
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VerifyRecoveryEmailOutput verifyRecoveryEmailOutput) {
                    if (verifyRecoveryEmailOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(verifyRecoveryEmailOutput.status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void changePassword(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<TwoStepStatusObject> loadListener) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || !CoreUtilities.checkPassword(str2)) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        ChangePasswordInput changePasswordInput = new ChangePasswordInput();
        changePasswordInput.password = str;
        changePasswordInput.new_password = str2;
        if (str3 == null || str3.isEmpty()) {
            str3 = null;
        }
        changePasswordInput.new_hint = str3;
        try {
            networkHelper.changePassword(str4, changePasswordInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TwoPasscodeStatusOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                    if (twoPasscodeStatusOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(twoPasscodeStatusOutput.two_step_status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void resendCodeRecoveryEmail(String str, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.resendCodeRecoveryEmail(str2, new PasswordInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ResendCodeRecoveryEmailOutput>() { // from class: ir.aaap.messengercore.LoginUtils.9
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ResendCodeRecoveryEmailOutput resendCodeRecoveryEmailOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                    LoginUtils.this.coreLog.handleException(exc);
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void requestRecoveryEmail(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<TwoStepStatusObject> loadListener) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        RequestRecoveryEmailInput requestRecoveryEmailInput = new RequestRecoveryEmailInput();
        requestRecoveryEmailInput.password = str;
        requestRecoveryEmailInput.recovery_email = str2;
        try {
            networkHelper.requestRecoveryEmail(str3, requestRecoveryEmailInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TwoPasscodeStatusOutput>() { // from class: ir.aaap.messengercore.LoginUtils.10
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 == null || twoPasscodeStatusOutput == null) {
                        return;
                    }
                    loadListener2.onDidLoad(twoPasscodeStatusOutput.two_step_status);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                    LoginUtils.this.coreLog.handleException(exc);
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void getTwoPasscodeStatus(String str, NetworkHelper networkHelper, final LoadListener<TwoPasscodeStatusOutput> loadListener) {
        try {
            networkHelper.getTwoPasscodeStatus(str, new GetTwoPasscodeStatusInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TwoPasscodeStatusOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.11
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                    if (twoPasscodeStatusOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(twoPasscodeStatusOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void abortTwoStepSetup(String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.abortTwoStepSetup(str, new AbortTwoStepSetupInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AbortTwoStepSetupOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.12
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AbortTwoStepSetupOutput abortTwoStepSetupOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void abortSetRecoveryEmail(String str, String str2, NetworkHelper networkHelper, final LoadListener<TwoStepStatusObject> loadListener) {
        try {
            networkHelper.abortSetRecoveryEmail(str2, new PasswordInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TwoPasscodeStatusOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.13
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TwoPasscodeStatusOutput twoPasscodeStatusOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 == null || twoPasscodeStatusOutput == null) {
                        return;
                    }
                    loadListener2.onDidLoad(twoPasscodeStatusOutput.two_step_status);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void requestForgetPassword(String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.requestForgetPassword(str, new RequestForgetPasswordInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RequestForgetPasswordOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.14
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RequestForgetPasswordOutput requestForgetPasswordOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void disableTwoStepByForgetPassword(String str, String str2, NetworkHelper networkHelper, final LoadListener<DisableTwoStepByForgetPasswordOutput.StatusEnum> loadListener) {
        DisableTwoStepByForgetPasswordInput disableTwoStepByForgetPasswordInput = new DisableTwoStepByForgetPasswordInput();
        disableTwoStepByForgetPasswordInput.code = str;
        try {
            networkHelper.disableTwoStepByForgetPassword(str2, disableTwoStepByForgetPasswordInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DisableTwoStepByForgetPasswordOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.15
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DisableTwoStepByForgetPasswordOutput disableTwoStepByForgetPasswordOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 == null || disableTwoStepByForgetPasswordOutput == null) {
                        return;
                    }
                    loadListener2.onDidLoad(disableTwoStepByForgetPasswordOutput.status);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int getMySessions(String str, NetworkHelper networkHelper, final LoadListener<GetMySessionsOutput> loadListener) {
        try {
            return networkHelper.getMySessions(str, new GetMySessionsInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMySessionsOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.16
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMySessionsOutput getMySessionsOutput) {
                    LoadListener loadListener2;
                    if (getMySessionsOutput == null || (loadListener2 = loadListener) == null) {
                        return;
                    }
                    loadListener2.onDidLoad(getMySessionsOutput);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void terminateSession(String str, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty()) {
            return;
        }
        TerminateSessionInput terminateSessionInput = new TerminateSessionInput();
        terminateSessionInput.session_key = str;
        try {
            networkHelper.terminateSession(str2, terminateSessionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TerminateSessionOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.17
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TerminateSessionOutput terminateSessionOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void terminateOtherSessions(String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.terminateOtherSessions(str, new TerminateOtherSessionInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<TerminateOtherSessionOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.18
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(TerminateOtherSessionOutput terminateOtherSessionOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    String getTempSession() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (sb.length() < 32) {
            sb.append(this.SALTCHARS.charAt((int) (random.nextFloat() * this.SALTCHARS.length())));
        }
        return sb.toString();
    }

    public void registerDevice(boolean z, NetworkHelper networkHelper, CoreLog coreLog, final KeyValueStorageHelper keyValueStorageHelper, final DeviceUtils deviceUtils, final String str, RegisterDeviceInput.TokenTypeEnum tokenTypeEnum, RetryObject retryObject, final LoadListener<Integer> loadListener) {
        RetryObject defaultRetry = retryObject == null ? RetryObject.getDefaultRetry() : retryObject;
        RegisterDeviceInput registerDeviceInput = new RegisterDeviceInput();
        registerDeviceInput.app_version = "MA_" + deviceUtils.getAppVersion();
        registerDeviceInput.device_model = deviceUtils.getDeviceModel();
        registerDeviceInput.lang_code = deviceUtils.getSystemLangCode();
        registerDeviceInput.system_version = deviceUtils.getSystemVersion();
        registerDeviceInput.token = str == null ? BuildConfig.FLAVOR : str;
        registerDeviceInput.token_type = tokenTypeEnum;
        registerDeviceInput.device_hash = deviceUtils.generateDeviceIdentifier();
        registerDeviceInput.is_multi_account = z;
        try {
            networkHelper.registerDevice(keyValueStorageHelper.getAuth(), registerDeviceInput, defaultRetry, new NetworkHelper.ResponseListener<RegisterDeviceOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.19
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RegisterDeviceOutput registerDeviceOutput) {
                    String appVersion = deviceUtils.getAppVersion();
                    keyValueStorageHelper.setLastFireBaseTokenRegistered(str);
                    keyValueStorageHelper.setLastVersion(appVersion);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            coreLog.handleException(e);
        }
    }

    public void requestChangePhoneNumber(String str, String str2, NetworkHelper networkHelper, final LoadListener<RequestChangePhoneNumberOutput> loadListener) {
        if (str == null) {
            if (loadListener != null) {
                loadListener.onError(new Exception("Null Inputs"));
                return;
            }
            return;
        }
        String strProcessPhone = processPhone(str);
        if (!CoreUtilities.isValidPhoneNumber(strProcessPhone)) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.phoneIsNotCorrect, strProcessPhone));
                return;
            }
            return;
        }
        RequestChangePhoneNumberInput requestChangePhoneNumberInput = new RequestChangePhoneNumberInput();
        requestChangePhoneNumberInput.new_phone_number = strProcessPhone;
        try {
            networkHelper.requestChangePhoneNumber(str2, requestChangePhoneNumberInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RequestChangePhoneNumberOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.20
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RequestChangePhoneNumberOutput requestChangePhoneNumberOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(requestChangePhoneNumberOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int verifyChangePhoneNumber(String str, String str2, String str3, final KeyValueStorageHelper keyValueStorageHelper, NetworkHelper networkHelper, final LoadListener<VerifyChangePhoneNumberOutput> loadListener) {
        if (str == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new Exception("Null Inputs"));
            }
            return 0;
        }
        VerifyChangePhoneNumberInput verifyChangePhoneNumberInput = new VerifyChangePhoneNumberInput();
        verifyChangePhoneNumberInput.code = str2;
        verifyChangePhoneNumberInput.hash = str;
        try {
            return networkHelper.verifyChangePhoneNumber(str3, verifyChangePhoneNumberInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VerifyChangePhoneNumberOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.21
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VerifyChangePhoneNumberOutput verifyChangePhoneNumberOutput) {
                    UserInfoFromServer userInfoFromServer;
                    if (verifyChangePhoneNumberOutput != null) {
                        if (verifyChangePhoneNumberOutput.status == VerifyChangePhoneNumberOutput.Status.IsValid && (userInfoFromServer = verifyChangePhoneNumberOutput.user) != null) {
                            userInfoFromServer.timestamp = verifyChangePhoneNumberOutput.timestamp;
                            keyValueStorageHelper.setMyUserObject(userInfoFromServer, System.currentTimeMillis());
                            String str4 = verifyChangePhoneNumberOutput.user.user_guid;
                            if (str4 != null && !str4.isEmpty()) {
                                keyValueStorageHelper.setUserGuid(verifyChangePhoneNumberOutput.user.user_guid);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(verifyChangePhoneNumberOutput);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onError(new LogInException(LogInException.ErrorEnum.signInFailed));
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int loginTwoStepForgetPassword(String str, NetworkHelper networkHelper, final LoadListener<LoginTwoStepForgetPasswordOutput> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        if (!CoreUtilities.isValidPhoneNumber(str)) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.phoneIsNotCorrect, str));
            }
            return 0;
        }
        try {
            return networkHelper.loginTwoStepForgetPassword(getTempSession(), new LoginTwoStepForgetPasswordInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LoginTwoStepForgetPasswordOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.22
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LoginTwoStepForgetPasswordOutput loginTwoStepForgetPasswordOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(loginTwoStepForgetPasswordOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int loginDisableTwoStep(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<LoginDisableTwoStepOutput.StatusEnum> loadListener) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        if (!CoreUtilities.isValidPhoneNumber(str)) {
            if (loadListener != null) {
                loadListener.onError(new LogInException(LogInException.ErrorEnum.phoneIsNotCorrect, str));
            }
            return 0;
        }
        try {
            return networkHelper.loginDisableTwoStep(getTempSession(), new LoginDisableTwoStepInput(str, str2, str3), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LoginDisableTwoStepOutput>(this) { // from class: ir.aaap.messengercore.LoginUtils.23
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LoginDisableTwoStepOutput loginDisableTwoStepOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(loginDisableTwoStepOutput.status);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int requestDeleteAccount(String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            return networkHelper.requestDeleteAccount(str, new RequestDeleteAccountInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RequestDeleteAccountOutput>() { // from class: ir.aaap.messengercore.LoginUtils.24
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RequestDeleteAccountOutput requestDeleteAccountOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                    LoginUtils.this.coreLog.handleException(exc);
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void onSwitchToV6Success(KeyValueStorageHelper keyValueStorageHelper) {
        keyValueStorageHelper.setCurrentApiVersion(6);
        keyValueStorageHelper.setPublicKey(null);
    }

    public void onSwitchToV6Failed(KeyValueStorageHelper keyValueStorageHelper) {
        keyValueStorageHelper.setCurrentApiVersion(5);
        keyValueStorageHelper.setPublicKey(null);
        keyValueStorageHelper.setPrivateKey(null);
    }

    public PrivateKey getPrivateKey(KeyValueStorageHelper keyValueStorageHelper) {
        return keyValueStorageHelper.getPrivateKey();
    }

    public PublicKey getPublicKey(KeyValueStorageHelper keyValueStorageHelper) {
        return keyValueStorageHelper.getPublicKey();
    }

    public boolean isVersion6(KeyValueStorageHelper keyValueStorageHelper) {
        return keyValueStorageHelper.getCurrentApiVersion(5) == 6;
    }

    private void generateKeyIfNeeded(KeyValueStorageHelper keyValueStorageHelper, CoreEncryptionHelper coreEncryptionHelper) {
        if (getPrivateKey(keyValueStorageHelper) == null) {
            KeyPair keyPairGenerateKey = coreEncryptionHelper.generateKey();
            keyValueStorageHelper.setPublicKey(keyPairGenerateKey.getPublic());
            keyValueStorageHelper.setPrivateKey(keyPairGenerateKey.getPrivate());
        }
    }

    public void switchToV6(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, CoreEncryptionHelper coreEncryptionHelper) {
        if (isVersion6(keyValueStorageHelper) || coreEncryptionHelper == null || !coreEncryptionHelper.supportAlgorithm() || this.isSwitchToV6InProgress) {
            return;
        }
        this.isSwitchToV6InProgress = true;
        generateKeyIfNeeded(keyValueStorageHelper, coreEncryptionHelper);
        PublicKey publicKey = keyValueStorageHelper.getPublicKey();
        SetPublicKeyInput setPublicKeyInput = new SetPublicKeyInput();
        try {
            setPublicKeyInput.public_key = coreEncryptionHelper.encodeChars(coreEncryptionHelper.toPemString(publicKey));
        } catch (Exception unused) {
        }
        if (setPublicKeyInput.public_key == null) {
            this.isSwitchToV6InProgress = false;
            onSwitchToV6Failed(keyValueStorageHelper);
            return;
        }
        try {
            networkHelper.setPublicKey(str, setPublicKeyInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetPublicKeyOutput>() { // from class: ir.aaap.messengercore.LoginUtils.25
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetPublicKeyOutput setPublicKeyOutput) {
                    LoginUtils.this.isSwitchToV6InProgress = false;
                    LoginUtils.this.onSwitchToV6Success(keyValueStorageHelper);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoginUtils.this.isSwitchToV6InProgress = false;
                    LoginUtils.this.onSwitchToV6Failed(keyValueStorageHelper);
                }
            });
        } catch (Exception e) {
            this.isSwitchToV6InProgress = false;
            e.printStackTrace();
        }
    }
}
