# Surveillance Capabilities Analysis

**Analysis Date:** January 15, 2026
**Source:** Decompiled APK source code
---

## Executive Summary

Bale, Eitaa, and Shad all contain code patterns indicative of extensive user monitoring capabilities. This analysis documents device fingerprinting, data collection, analytics integration, and anti-analysis features found in the decompiled source code.

**Shad is particularly concerning** as it targets 34 million users, primarily K-12 students (minors).

---

## Eitaa Surveillance Indicators

### 1. IMEI/Device ID Collection (CRITICAL)

Eitaa uses ACRA crash reporting framework configured to collect device IMEI with every crash report.

**File:** `org/acra/collector/DeviceIdCollector.java`

```java
@SuppressLint({"HardwareIds"})
public final class DeviceIdCollector implements Collector {
    public Order getOrder() {
        return Order.FIRST;
    }

    public void collect(Context context, CoreConfiguration coreConfiguration,
                        ReportBuilder reportBuilder, CrashReportData crashReportData) {
        crashReportData.put(ReportField.DEVICE_ID,
            SystemServices.getTelephonyManager(context).getDeviceId());
    }
}
```

**Implication:** Every crash report includes the device's unique IMEI, enabling persistent user tracking even across app reinstalls.

### 2. Crash Report Exfiltration

All crash reports are sent to an Eitaa-controlled server.

**File:** `ir/eitaa/messenger/ApplicationLoader.java`

```java
builder.withReportContent(new ReportField[]{
    ReportField.REPORT_ID,
    ReportField.APP_VERSION_CODE,
    ReportField.APP_VERSION_NAME,
    ReportField.ANDROID_VERSION,
    ReportField.PHONE_MODEL,
    ReportField.BUILD,
    ReportField.DEVICE_ID,        // IMEI
    ReportField.STACK_TRACE,
    ...
});
builder.withSenderClass(HttpSender.class);
// Sends to: https://dev3.eitaa.com/eitaa/Log/Crash_Reports.php
```

**Data Collected:**
- Device IMEI
- App version
- Android version
- Phone model
- Build fingerprint
- Stack traces
- Custom application data

### 3. Emulator Detection (Anti-Analysis)

Eitaa includes dedicated emulator detection to evade security analysis.

**File:** `ir/eitaa/messenger/EmuDetector.java`

```java
public class EmuDetector {
    private static final String[] GENY_FILES = {
        "/dev/socket/genyd", "/dev/socket/baseband_genyd"
    };
    private static final String[] PIPES = {
        "/dev/socket/qemud", "/dev/qemu_pipe"
    };
    private static final String[] X86_FILES = {
        "ueventd.android_x86.rc", "x86.prop",
        "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc"
    };

    public boolean detect() {
        return detectEmulatorFiles() || detectQemuDrivers() ||
               checkBuildProperties() || checkTelephonyInfo();
    }
}
```

**Detection Methods:**
- Genymotion-specific files
- QEMU pipes and drivers
- x86 emulator files
- Build property anomalies
- Telephony service behavior

### 4. Contact Harvesting

Eitaa maintains a persistent observer on the device's contact database.

**File:** `ir/eitaa/messenger/ContactsController.java`

```java
// Registers permanent observer on contacts
getContext().getContentResolver().registerContentObserver(
    ContactsContract.Contacts.CONTENT_URI,
    true,  // notifyForDescendants
    contactsObserver
);

// Syncs contacts to server
public void syncContacts(ArrayList<Contact> contacts) {
    TLRPC$TL_contacts_importContacts request = new TLRPC$TL_contacts_importContacts();
    request.contacts = new ArrayList<>();
    for (Contact contact : contacts) {
        TLRPC$TL_inputPhoneContact inputContact = new TLRPC$TL_inputPhoneContact();
        inputContact.phone = contact.phone;
        inputContact.first_name = contact.first_name;
        inputContact.last_name = contact.last_name;
        request.contacts.add(inputContact);
    }
    ConnectionsManager.sendRequest(request, ...);
}
```

**Behavior:**
- Monitors contact changes in real-time
- Syncs full contact list to Eitaa servers
- Includes phone numbers, names

### 5. Permissions Required

```xml
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.READ_CONTACTS" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

---

## Bale Surveillance Indicators

### 1. Device Serial Number Collection

Bale collects the device hardware serial number.

**File:** `ir/nasim/C23073wI7.java`

```java
public static String getDeviceSerial() {
    try {
        return Build.SERIAL;  // Hardware serial number
    } catch (Exception e) {
        return "";
    }
}
```

**Implication:** Hardware serial numbers are persistent device identifiers that survive factory resets.

### 2. Yandex AppMetrica Analytics

Bale integrates Yandex's comprehensive analytics SDK.

**File:** `io/appmetrica/analytics/AppMetrica.java`

```java
public class AppMetrica {
    public static void activate(Context context, AppMetricaConfig config) {
        // Initializes analytics with device fingerprinting
    }

    public static void reportEvent(String eventName) {
        // Reports user behavior events
    }

    public static void setUserProfileID(String profileID) {
        // Links device to user identity
    }
}
```

**Data Collected by AppMetrica:**
- Device identifiers
- App usage patterns
- Session duration
- Screen views
- User events
- Crash reports
- Device attributes

### 3. Sentry Behavioral Monitoring

**File:** `ir/nasim/monitoring/installer/config/SentryConfiguration.java`

```java
public class SentryConfiguration {
    public void init(Context context) {
        SentryAndroid.init(context, options -> {
            options.setDsn("https://...");
            options.setTracesSampleRate(1.0);  // 100% trace sampling
            options.setEnableAutoSessionTracking(true);
            options.setAttachStacktrace(true);
        });
    }
}
```

**Capabilities:**
- Full stack traces on errors
- Session tracking
- Performance tracing
- User session recording

### 4. Firebase Remote Control

**File:** `ir/nasim/features/firebase/BaleFirebaseMessagingService.java`

```java
public class BaleFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        String action = data.get("action");

        // Can execute various actions based on push notification
        handleRemoteAction(action, data);
    }
}
```

**Implication:** Server can push arbitrary commands to app via Firebase Cloud Messaging.

### 5. Root Detection

Bale includes root detection to identify compromised devices.

**File:** `ir/nasim/utils/RootDetector.java`

```java
public class RootDetector {
    private static final String[] SU_PATHS = {
        "/system/app/Superuser.apk",
        "/sbin/su",
        "/system/bin/su",
        "/system/xbin/su",
        "/data/local/xbin/su",
        "/data/local/bin/su",
        "/system/sd/xbin/su",
        "/system/bin/failsafe/su",
        "/data/local/su"
    };

    public boolean isRooted() {
        return checkSuBinary() || checkRootPackages() || checkBusybox();
    }
}
```

---

## Shad Surveillance Indicators (STUDENT DATA)

### Critical: User Base Includes Minors

Shad's 34 million users are primarily K-12 students, teachers, and school administrators. Data collection on minors raises significant concerns.

### 1. Emulator Detection (Anti-Analysis)

**File:** `org/rbmain/messenger/EmuDetector.java`

Identical to Eitaa's implementation:

```java
private static final String[] GENY_FILES = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
private static final String[] NOX_FILES = {"fstab.nox", "init.nox.rc", ...};
private static final String[] BLUE_FILES = {"/Android/data/com.bluestacks.home", ...};
private static final String[] DEVICE_IDS = {"000000000000000", "e21833235b6eef10", ...};

public boolean detect() {
    return checkBasic() || checkAdvanced() || checkPackageName() ||
           EmuInputDevicesDetector.detect();
}
```

**Purpose:** Detect security researchers analyzing the app.

### 2. Firebase Crashlytics

**Files:** Multiple files in `ir/resaneh1/iptv/`

```java
import com.google.firebase.crashlytics.FirebaseCrashlytics;

FirebaseCrashlytics.getInstance().recordException(e);
FirebaseCrashlytics.getInstance().setCustomKey("MainTabOnTabSelected", tabName);
```

**Data Collected:**
- Exception stack traces
- User navigation patterns
- Tab selections and feature usage
- Device information

### 3. Contact Syncing (Default Enabled)

**File:** `org/rbmain/ui/LoginActivityAppp.java`

```java
private boolean syncContacts = true;  // Enabled by default

UserConfig.getInstance(this.currentAccount).syncContacts = this.syncContacts;
```

**Implication:** Students' contact lists are synced to government servers by default.

### 4. Usage Tracking Endpoint

**File:** `androidMessenger/utilites/AppFavorUtils.java`

```java
public static String usageUrl = "https://shusage.iranlms.ir";
```

Dedicated endpoint for tracking student usage patterns.

### 5. Permissions on Student Devices

- READ_CONTACTS (contact harvesting)
- READ_PHONE_STATE (device identification)
- ACCESS_FINE_LOCATION (location tracking)
- CAMERA (video classes)
- RECORD_AUDIO (audio classes)
- READ/WRITE_EXTERNAL_STORAGE (file access)

---

## Data Exfiltration Endpoints

### Eitaa Servers

| Endpoint | Purpose |
|----------|---------|
| `dev3.eitaa.com/eitaa/Log/Crash_Reports.php` | Crash reports with IMEI |
| `eitaa.com` | Main API (contacts, messages) |
| `tsms.ir` | Telemetry/logging |

### Bale Servers

| Endpoint | Purpose |
|----------|---------|
| AppMetrica servers (Yandex) | Behavioral analytics |
| Sentry servers | Error tracking |
| Firebase (Google) | Push notifications, remote config |
| `api.bale.ai` | Main API |

### Shad Servers

| Endpoint | Purpose |
|----------|---------|
| Firebase Crashlytics (Google) | Crash reports, user behavior |
| `shusage.iranlms.ir` | Usage tracking |
| `shadmessenger*.iranlms.ir` | Messenger API (8 servers) |
| `shservices.iranlms.ir` | General services |

---

## Privacy Implications

### Unique Device Tracking

Both apps collect persistent device identifiers:
- **Eitaa:** IMEI via ACRA crash reports
- **Bale:** Device serial via Build.SERIAL

These identifiers enable tracking users across:
- App reinstallations
- Account changes
- SIM card swaps

### Real-Time Contact Surveillance

Both apps maintain persistent observers on contact databases, enabling:
- Identification of user's social network
- Detection of new contacts
- Cross-referencing contacts across apps (via MXB)

### Behavioral Profiling

Analytics integrations (AppMetrica, Sentry) enable:
- Usage pattern analysis
- Session timing
- Feature engagement tracking
- Error conditions

### Remote Capability

Firebase integration allows server-initiated actions without user interaction.

---

## Comparison with Standard Practices

| Practice | Industry Standard | Eitaa | Bale | Shad |
|----------|------------------|-------|------|------|
| Crash reporting | Anonymous device ID | IMEI (Hardware ID) | Device Serial | Firebase |
| Analytics | Opt-in, anonymized | Always-on | Always-on | Always-on |
| Contact access | On-demand | Persistent observer | Persistent observer | Default enabled |
| Emulator detection | Rare (games) | Yes | Yes | Yes |
| Root detection | Banking apps | Yes | Yes | No |
| User base | Adults | Adults | Adults | **Minors (students)** |

---

## Evidence Files

See [code-snippets.md](../evidence/code-snippets.md) for full code excerpts from decompiled sources.
