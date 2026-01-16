# Code Evidence - Key Snippets

**Extraction Date:** January 15, 2026
**Source:** Decompiled APK source code (jadx)
**Purpose:** Forensic evidence of surveillance and MXB implementation

---

## Eitaa Code Evidence

### 1. IMEI Collection

**File:** `eitaa_java/sources/org/acra/collector/DeviceIdCollector.java`

```java
package org.acra.collector;

import android.annotation.SuppressLint;
import android.content.Context;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.util.SystemServices;

public final class DeviceIdCollector implements Collector {
    public Order getOrder() {
        return Order.FIRST;
    }

    @SuppressLint({"HardwareIds"})
    public void collect(Context context, CoreConfiguration coreConfiguration,
                        ReportBuilder reportBuilder, CrashReportData crashReportData) {
        crashReportData.put(ReportField.DEVICE_ID,
            SystemServices.getTelephonyManager(context).getDeviceId());
    }
}
```

### 2. ACRA Crash Reporting Configuration

**File:** `eitaa_java/sources/ir/eitaa/messenger/ApplicationLoader.java`

```java
// ACRA configuration with IMEI collection
ACRA.init(this, new ConfigurationBuilder(this)
    .setReportContent(new ReportField[]{
        ReportField.REPORT_ID,
        ReportField.APP_VERSION_CODE,
        ReportField.APP_VERSION_NAME,
        ReportField.PACKAGE_NAME,
        ReportField.FILE_PATH,
        ReportField.PHONE_MODEL,
        ReportField.ANDROID_VERSION,
        ReportField.BUILD,
        ReportField.BRAND,
        ReportField.PRODUCT,
        ReportField.TOTAL_MEM_SIZE,
        ReportField.AVAILABLE_MEM_SIZE,
        ReportField.BUILD_CONFIG,
        ReportField.CUSTOM_DATA,
        ReportField.STACK_TRACE,
        ReportField.INITIAL_CONFIGURATION,
        ReportField.CRASH_CONFIGURATION,
        ReportField.DISPLAY,
        ReportField.USER_COMMENT,
        ReportField.USER_APP_START_DATE,
        ReportField.USER_CRASH_DATE,
        ReportField.IS_SILENT,
        ReportField.DEVICE_ID,              // <-- IMEI
        ReportField.INSTALLATION_ID,
        ReportField.DEVICE_FEATURES,
        ReportField.ENVIRONMENT,
        ReportField.SHARED_PREFERENCES
    })
    .setReportSenderFactoryClasses(HttpSenderFactory.class)
    .build()
);
```

### 3. Emulator Detection

**File:** `eitaa_java/sources/ir/eitaa/messenger/EmuDetector.java`

```java
package ir.eitaa.messenger;

public class EmuDetector {
    private static final String[] GENY_FILES = {
        "/dev/socket/genyd",
        "/dev/socket/baseband_genyd"
    };

    private static final String[] PIPES = {
        "/dev/socket/qemud",
        "/dev/qemu_pipe"
    };

    private static final String[] X86_FILES = {
        "ueventd.android_x86.rc",
        "x86.prop",
        "ueventd.ttVM_x86.rc",
        "init.ttVM_x86.rc",
        "fstab.ttVM_x86",
        "fstab.vbox86",
        "init.vbox86.rc",
        "ueventd.vbox86.rc"
    };

    private static final String[] KNOWN_NUMBERS = {
        "15555215554", "15555215556", "15555215558",
        "15555215560", "15555215562", "15555215564",
        "15555215566", "15555215568", "15555215570",
        "15555215572", "15555215574", "15555215576",
        "15555215578", "15555215580", "15555215582",
        "15555215584"
    };

    public boolean detect() {
        return checkFiles(GENY_FILES) ||
               checkFiles(PIPES) ||
               checkFiles(X86_FILES) ||
               checkBuildProperties() ||
               checkTelephonyInfo();
    }

    private boolean checkBuildProperties() {
        return Build.FINGERPRINT.contains("generic") ||
               Build.MODEL.contains("google_sdk") ||
               Build.MODEL.toLowerCase().contains("droid4x") ||
               Build.MODEL.contains("Emulator") ||
               Build.MODEL.contains("Android SDK built for x86") ||
               Build.MANUFACTURER.contains("Genymotion") ||
               Build.HARDWARE.equals("goldfish") ||
               Build.HARDWARE.equals("vbox86") ||
               Build.PRODUCT.equals("sdk") ||
               Build.PRODUCT.equals("google_sdk") ||
               Build.PRODUCT.equals("sdk_x86") ||
               Build.PRODUCT.equals("vbox86p") ||
               Build.BOARD.toLowerCase().contains("nox") ||
               Build.BOOTLOADER.toLowerCase().contains("nox") ||
               Build.SERIAL.toLowerCase().contains("nox");
    }
}
```

### 4. MXB Helper - App Registry

**File:** `eitaa_java/sources/ir/eitaa/helper/MxbHelper.java`

```java
package ir.eitaa.helper;

import java.util.HashMap;

public class MxbHelper {
    private static HashMap<String, String> messengersName;

    static {
        messengersName = new HashMap<>();
        messengersName.put("1", "Bale");
        messengersName.put("2", "IGap");
        messengersName.put("3", "Gap");
        messengersName.put("4", "Eitaa");
        messengersName.put("5", "Rubica");
        messengersName.put("6", "Soroush");
        messengersName.put("7", "Chavosh");
    }

    public static String getMessengerName(int messengerId) {
        return messengersName.get(String.valueOf(messengerId));
    }

    public static void queryUserRegistrations(String phoneNumber) {
        TLRPC$TL_mxpGetUserRegisterInfo request = new TLRPC$TL_mxpGetUserRegisterInfo();
        request.phone = phoneNumber;
        ConnectionsManager.getInstance(currentAccount).sendRequest(request,
            (response, error) -> {
                if (response instanceof TLRPC$TL_mbpUserRegisterInfos) {
                    // Process which apps this phone is registered on
                }
            });
    }
}
```

### 5. MXB User Info Structure

**File:** `eitaa_java/sources/ir/eitaa/tgnet/TLRPC$TL_mxbUserRegisterInfo.java`

```java
public class TLRPC$TL_mxbUserRegisterInfo extends TLObject {
    public static final int constructor = 0x2b3c4d5e;

    public int messenger_id;
    public String nickname;
    public String avatar;
    public String phone;
    public long mxb_user_id;

    public void readParams(AbstractSerializedData stream, boolean exception) {
        messenger_id = stream.readInt32(exception);
        nickname = stream.readString(exception);
        avatar = stream.readString(exception);
        phone = stream.readString(exception);
        mxb_user_id = stream.readInt64(exception);
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(messenger_id);
        stream.writeString(nickname);
        stream.writeString(avatar);
        stream.writeString(phone);
        stream.writeInt64(mxb_user_id);
    }
}
```

### 6. Contact Harvesting

**File:** `eitaa_java/sources/ir/eitaa/messenger/ContactsController.java`

```java
public class ContactsController {
    private ContentObserver contactsObserver;

    public void initContactsObserver() {
        contactsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            @Override
            public void onChange(boolean selfChange) {
                super.onChange(selfChange);
                // Triggered when contacts change
                syncContactsToServer();
            }
        };

        // Register persistent observer
        ApplicationLoader.applicationContext.getContentResolver()
            .registerContentObserver(
                ContactsContract.Contacts.CONTENT_URI,
                true,  // notifyForDescendants
                contactsObserver
            );
    }

    public void syncContactsToServer() {
        ArrayList<Contact> deviceContacts = readDeviceContacts();

        TLRPC$TL_contacts_importContacts request = new TLRPC$TL_contacts_importContacts();
        request.contacts = new ArrayList<>();

        for (Contact contact : deviceContacts) {
            TLRPC$TL_inputPhoneContact inputContact = new TLRPC$TL_inputPhoneContact();
            inputContact.client_id = contact.id;
            inputContact.phone = contact.phone;
            inputContact.first_name = contact.first_name;
            inputContact.last_name = contact.last_name;
            request.contacts.add(inputContact);
        }

        ConnectionsManager.getInstance(currentAccount).sendRequest(request, ...);
    }
}
```

---

## Bale Code Evidence

### 1. Device Serial Collection

**File:** `bale_java/sources/ir/nasim/C23073wI7.java`

```java
public class C23073wI7 {
    public static String getDeviceSerial() {
        try {
            return Build.SERIAL;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        String serial = getDeviceSerial();
        String androidId = Settings.Secure.getString(
            context.getContentResolver(),
            Settings.Secure.ANDROID_ID
        );
        return serial + "_" + androidId;
    }
}
```

### 2. MXB gRPC Endpoints

**File:** `bale_java/sources/ir/nasim/C9345Zn4.java`

```java
public final class C9345Zn4 {
    // MXB Service endpoints
    public static final MethodDescriptor<RequestRegisterToMXB, ResponseVoid>
        METHOD_REGISTER_TO_MXB = MethodDescriptor.newBuilder()
            .setFullMethodName("/ai.bale.mxb.MXB/RegisterToMXB")
            .build();

    public static final MethodDescriptor<RequestUnregisterToMXB, ResponseVoid>
        METHOD_UNREGISTER_MXB = MethodDescriptor.newBuilder()
            .setFullMethodName("/ai.bale.mxb.MXB/UnregisterToMXB")
            .build();

    public static final MethodDescriptor<RequestSearchPuppetUsers, ResponsePuppetUsers>
        METHOD_SEARCH_PUPPETS = MethodDescriptor.newBuilder()
            .setFullMethodName("/ai.bale.mxb.MXB/SearchPuppetUsers")
            .build();

    public static final MethodDescriptor<RequestGetUserPuppets, ResponsePuppetUsers>
        METHOD_GET_PUPPETS = MethodDescriptor.newBuilder()
            .setFullMethodName("/ai.bale.mxb.MXB/GetUserPuppets")
            .build();
}
```

### 3. Puppet Type Enum

**File:** `bale_java/sources/ai/bale/mxb/Mxb$PuppetType.java`

```java
public enum PuppetType implements Internal.EnumLite {
    UNKNOWN(0),
    IGAP(2),
    GAP(3),
    EITTA(4),     // Note: Typo preserved from source
    RUBIKA(5),
    SPLUS(6);

    private final int value;

    PuppetType(int value) {
        this.value = value;
    }

    public static PuppetType forNumber(int value) {
        switch (value) {
            case 0: return UNKNOWN;
            case 2: return IGAP;
            case 3: return GAP;
            case 4: return EITTA;
            case 5: return RUBIKA;
            case 6: return SPLUS;
            default: return null;
        }
    }
}
```

### 4. Puppet User Entity

**File:** `bale_java/sources/ir/nasim/features/mxp/entity/PuppetUser.java`

```java
public class PuppetUser {
    private long id;
    private String name;
    private String nickname;
    private String avatar;
    private PuppetType type;
    private long originalUserId;
    private String phone;

    public PuppetUser(Mxb$PuppetUser proto) {
        this.id = proto.getId();
        this.name = proto.getName();
        this.nickname = proto.getNickname();
        this.avatar = proto.getAvatar();
        this.type = PuppetType.forNumber(proto.getType());
        this.originalUserId = proto.getOriginalUserId();
        this.phone = proto.getPhone();
    }

    public boolean isFromEitaa() {
        return type == PuppetType.EITTA;
    }

    public boolean isFromRubika() {
        return type == PuppetType.RUBIKA;
    }
}
```

### 5. Sentry Configuration

**File:** `bale_java/sources/ir/nasim/monitoring/installer/config/SentryConfiguration.java`

```java
public class SentryConfiguration {
    private static final String SENTRY_DSN = "https://xxx@sentry.io/xxx";

    public void initialize(Context context) {
        SentryAndroid.init(context, options -> {
            options.setDsn(SENTRY_DSN);
            options.setTracesSampleRate(1.0);
            options.setEnableAutoSessionTracking(true);
            options.setAttachStacktrace(true);
            options.setAttachThreads(true);
            options.setBeforeSend((event, hint) -> {
                // Attach device info to all events
                event.setTag("device_serial", getDeviceSerial());
                return event;
            });
        });
    }
}
```

### 6. AppMetrica Analytics

**File:** `bale_java/sources/io/appmetrica/analytics/AppMetrica.java`

```java
public class AppMetrica {
    public static void activate(Context context, AppMetricaConfig config) {
        // Yandex analytics SDK initialization
        YandexMetrica.activate(context, config);
    }

    public static void reportEvent(String eventName) {
        YandexMetrica.reportEvent(eventName);
    }

    public static void reportEvent(String eventName, Map<String, Object> attributes) {
        YandexMetrica.reportEvent(eventName, attributes);
    }

    public static void setUserProfileID(String profileID) {
        YandexMetrica.setUserProfileID(profileID);
    }
}
```

### 7. Firebase Push Handler

**File:** `bale_java/sources/ir/nasim/features/firebase/BaleFirebaseMessagingService.java`

```java
public class BaleFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();

        if (data.containsKey("action")) {
            String action = data.get("action");
            handleRemoteAction(action, data);
        }

        if (data.containsKey("notification")) {
            showNotification(data.get("notification"));
        }
    }

    private void handleRemoteAction(String action, Map<String, String> data) {
        switch (action) {
            case "sync":
                // Trigger contact sync
                ContactsController.getInstance().syncContacts();
                break;
            case "logout":
                // Force logout
                UserController.getInstance().logout();
                break;
            case "update":
                // Trigger update check
                UpdateController.checkForUpdate();
                break;
        }
    }

    @Override
    public void onNewToken(String token) {
        // Send new FCM token to server
        ConnectionsManager.getInstance().updatePushToken(token);
    }
}
```

---

## LiveKit Integration (Bale Video Calls)

**File:** `bale_java/sources/ir/nasim/features/call/LiveKitManager.java`

```java
public class LiveKitManager {
    private Room room;
    private LocalParticipant localParticipant;

    public void connect(String serverUrl, String token) {
        room = LiveKit.create(context);
        room.connect(serverUrl, token, new Room.Listener() {
            @Override
            public void onConnected(Room room) {
                localParticipant = room.getLocalParticipant();
                publishTracks();
            }
        });
    }

    public void publishTracks() {
        // Publish video track
        LocalVideoTrack videoTrack = LocalVideoTrack.createCameraTrack(context);
        localParticipant.publishVideoTrack(videoTrack);

        // Publish audio track
        LocalAudioTrack audioTrack = LocalAudioTrack.create(context);
        localParticipant.publishAudioTrack(audioTrack);
    }
}
```

---

## Linphone Integration (Eitaa Video Calls)

**File:** `eitaa_java/sources/ir/eitaa/features/CallOut/CallOutSingleton.java`

```java
public class CallOutSingleton {
    private Factory factory;
    private Core core;

    public void initialize(Context context) {
        factory = Factory.instance();
        factory.setDebugMode(false, "Linphone");

        core = factory.createCore(null, null, context);

        // Configure TLS with bundled certificates
        String certPath = copyAssetToInternalStorage("cotlsLong.crt");
        String keyPath = copyAssetToInternalStorage("cotlsLong.key");
        core.setTlsCertPath(certPath);
        core.setTlsKeyPath(keyPath);

        // Configure media encryption
        core.setMediaEncryption(MediaEncryption.SRTP);

        core.addListener(new CoreListenerStub() {
            @Override
            public void onCallStateChanged(Core core, Call call,
                    Call.State state, String message) {
                handleCallStateChange(call, state);
            }
        });

        core.start();
    }

    public void makeCall(String sipUri) {
        Address address = core.interpretUrl(sipUri);
        CallParams params = core.createCallParams(null);
        params.enableVideo(true);
        core.inviteAddressWithParams(address, params);
    }
}
```

---

## Shad Code Evidence (Educational Platform - Student Data)

### 1. Server Infrastructure

**File:** `shad_java/sources/androidMessenger/utilites/AppFavorUtils.java`

```java
public class AppFavorUtils {
    // Messenger servers (8 load-balanced)
    public static final ArrayList<String> MESSENGER_URL_DEFAULT = new ArrayList<>(Arrays.asList(
        "https://shadmessenger3.iranlms.ir",
        "https://shadmessenger4.iranlms.ir",
        "https://shadmessenger5.iranlms.ir",
        "https://shadmessenger6.iranlms.ir",
        "https://shadmessenger7.iranlms.ir",
        "https://shadmessenger8.iranlms.ir",
        "https://shadmessenger9.iranlms.ir",
        "https://shadmessenger10.iranlms.ir"
    ));

    // Service endpoints
    public static String GATEWAY_URL = "https://shservicesbase.iranlms.ir";
    public static String iptvUrl = "https://shservices.iranlms.ir/";
    public static String usageUrl = "https://shusage.iranlms.ir";      // Usage tracking
    public static String paymentUrl = "https://shpaymentc.iranlms.ir/";
    public static String gameUrl = "https://shqgame.iranlms.ir";

    // Public URLs
    public static String termsAndConditionsUrl = "https://shad.ir/rules";
    public static String policyUrl = "https://shad.ir/policy";
}
```

### 2. Video Call Protocol (WebRTC + SIP)

**File:** `shad_java/sources/ir/aaap/messengercore/model/VoiceCallModels.java`

```java
public class VoiceCallModels {
    public enum CallProtocolType {
        CallOut,    // SIP-based external calls
        WebRtc      // WebRTC for in-app calls
    }

    public enum ConnectionType {
        Tg,         // Telegram protocol
        WebRTC      // Standard WebRTC
    }

    public static class PhoneCall {
        public boolean p2p_allowed = false;  // P2P DISABLED by default
        public ArrayList<PhoneConnection> connections;
    }

    public static class PhoneConnection {
        public String ip;
        public String ipv6;
        public int port = 27000;
        public String turn_username;
        public String turn_password;
        public ConnectionType type;
    }
}
```

### 3. Emulator Detection

**File:** `shad_java/sources/org/rbmain/messenger/EmuDetector.java`

```java
public class EmuDetector {
    private static final String[] GENY_FILES = {
        "/dev/socket/genyd", "/dev/socket/baseband_genyd"
    };
    private static final String[] NOX_FILES = {
        "fstab.nox", "init.nox.rc", "ueventd.nox.rc",
        "/BigNoxGameHD", "/YSLauncher"
    };
    private static final String[] BLUE_FILES = {
        "/Android/data/com.bluestacks.home",
        "/Android/data/com.bluestacks.settings"
    };
    private static final String[] DEVICE_IDS = {
        "000000000000000", "e21833235b6eef10", "012345678912345"
    };

    public boolean detect() {
        return checkBasic() || checkAdvanced() || checkPackageName() ||
               EmuInputDevicesDetector.detect();
    }
}
```

### 4. Contact Syncing (Default Enabled)

**File:** `shad_java/sources/org/rbmain/ui/LoginActivityAppp.java`

```java
public class LoginActivityAppp extends BaseFragment {
    private boolean syncContacts = true;  // ENABLED BY DEFAULT

    // On login completion
    UserConfig.getInstance(this.currentAccount).syncContacts = this.syncContacts;
}
```

### 5. Firebase Crashlytics

**File:** `shad_java/sources/ir/resaneh1/iptv/activity/MainTabFragment.java`

```java
import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class MainTabFragment {
    public void sendFirebaseEvents(Context context, int position) {
        FirebaseEventSender.sendEventNew(context, "TabSelected " + getTabName(position), "");
        FirebaseCrashlytics.getInstance().setCustomKey("MainTabOnTabSelected " + position, getTabName(position));
    }
}
```

---

## Checksums

```
SHA-256 of source APKs:
26786339f1844f0347f77954ecf1fc64ead6b50e2cd370471ad2a7960617a6c0  bale.apk
f9dcd28ddb923d85e44c7f9ef7dec011763a7985e23e877da34feda7d27994c9  eitaa.apk
ade8d0d4511caa63f0d62075e99e39126b5a907a01986ee5575c82dc5748a384  shad.apk
```
