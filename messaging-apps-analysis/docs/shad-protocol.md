# Shad Messenger - Protocol & Infrastructure Analysis

**App Version:** 3.5.5
**Package:** `ir.medu.shad`
**APK Size:** 77 MB
**Analysis Date:** January 16, 2026

---

## Executive Summary

Shad (شاد - "Happy") is Iran's official educational platform operated by the Ministry of Education and developed by MCI/Irancell (Hamrah-e-Aval). With **34 million users**, it is the largest Iranian messaging application, primarily used by K-12 students, teachers, and school administrators.

### Key Findings

| Category | Finding |
|----------|---------|
| **Video Call Protocol** | Hybrid WebRTC + SIP CallOut |
| **P2P Capability** | No - Disabled by default |
| **Telegram Fork** | Yes (`libtmessages.38.so`) |
| **MXB Connected** | No - Standalone since April 2020 |
| **Infrastructure** | iranlms.ir domain (MCI-operated) |
| **Target Users** | Students (minors), Teachers, Administrators |

---

## Video Call Protocol Stack

### Native Libraries

```
lib/arm64-v8a/
└── libtmessages.38.so    (Telegram-derived, includes WebRTC)
```

**Note:** Unlike Bale (LiveKit) and Eitaa (Linphone), Shad uses Telegram's built-in WebRTC implementation bundled in the messaging library.

### Call Protocol Types

**File:** `ir/aaap/messengercore/model/VoiceCallModels.java`

```java
public enum CallProtocolType {
    CallOut,    // SIP-based external calls
    WebRtc      // WebRTC for in-app calls
}

public enum ConnectionType {
    Tg,         // Telegram protocol
    WebRTC      // Standard WebRTC
}

public enum CallOutType {
    SIP         // SIP for external calls
}
```

### P2P Disabled by Default

```java
public static class PhoneCall {
    public boolean p2p_allowed = false;  // Centralized by default
}
```

### Call Configuration

```java
public static class CallConfig {
    public String p2p_to_relay_switch_threshold;
    public String relay_to_p2p_switch_threshold;
    public String relay_switch_threshold;
    // All calls route through relay servers
}
```

### TURN Server Configuration

```java
public static class PhoneConnection {
    public String ip;
    public String ipv6;
    public int port = 27000;
    public String turn_username;
    public String turn_password;
    public ConnectionType type;  // Tg or WebRTC
}
```

---

## Server Infrastructure

### Domain: iranlms.ir (Iran LMS)

All services hosted under MCI-operated `iranlms.ir` domain.

### Messenger Servers (8 Load-Balanced)

```
shadmessenger3.iranlms.ir
shadmessenger4.iranlms.ir
shadmessenger5.iranlms.ir
shadmessenger6.iranlms.ir
shadmessenger7.iranlms.ir
shadmessenger8.iranlms.ir
shadmessenger9.iranlms.ir
shadmessenger10.iranlms.ir
```

### Service Endpoints

| Service | URL | Purpose |
|---------|-----|---------|
| Gateway | shservicesbase.iranlms.ir | Main API gateway |
| Services | shservices.iranlms.ir | General services |
| Web Apps | shwebapp.iranlms.ir | Web application platform |
| Comments | shcomments.iranlms.ir | Comment system |
| Payment | shpaymentc.iranlms.ir | Payment processing |
| Barcode | shbarcode.iranlms.ir | QR code services |
| Usage | shusage.iranlms.ir | Usage tracking |
| Games | shqgame.iranlms.ir | Educational games |
| News | shkhabar.iranlms.ir | News feed |
| DC Manager | shgetdcmess.iranlms.ir | Data center routing |
| Panel | shpanel.iranlms.ir | Admin panel |
| Rubino | shrubino2.iranlms.ir | Social features |

### Public URLs

| URL | Purpose |
|-----|---------|
| shad.ir | Main website |
| shad.ir/rules | Terms and conditions |
| shad.ir/policy | Privacy policy |
| shad.ir/shadbin | Safe search (Shadbin) |

---

## Surveillance Indicators

### 1. Emulator Detection (Anti-Analysis)

**File:** `org/rbmain/messenger/EmuDetector.java`

Identical to Eitaa's emulator detection:

```java
private static final String[] GENY_FILES = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
private static final String[] PIPES = {"/dev/socket/qemud", "/dev/qemu_pipe"};
private static final String[] X86_FILES = {"ueventd.android_x86.rc", "x86.prop", ...};
private static final String[] NOX_FILES = {"fstab.nox", "init.nox.rc", ...};
private static final String[] BLUE_FILES = {"/Android/data/com.bluestacks.home", ...};

public boolean detect() {
    return checkBasic() || checkAdvanced() || checkPackageName() ||
           EmuInputDevicesDetector.detect();
}
```

Detection methods:
- Genymotion, Andy, Nox, BlueStacks files
- QEMU drivers and pipes
- Build property anomalies
- Known emulator device IDs
- Network IP check (10.0.2.15)

### 2. Firebase Crashlytics

**Files:** Multiple files in `ir/resaneh1/iptv/`

```java
import com.google.firebase.crashlytics.FirebaseCrashlytics;

FirebaseCrashlytics.getInstance().recordException(e);
FirebaseCrashlytics.getInstance().setCustomKey("MainTabOnTabSelected", tabName);
```

**Data Collected:**
- Exception stack traces
- Custom keys for user actions
- Tab selections and navigation
- Error conditions

### 3. Firebase Device Registration

**File:** `ir/aaap/messengercore/model/api/RegisterDeviceInput.java`

```java
public TokenTypeEnum token_type = TokenTypeEnum.Firebase;

public enum TokenTypeEnum {
    Firebase,
    ...
}
```

### 4. Contact Syncing (Default Enabled)

**File:** `org/rbmain/ui/LoginActivityAppp.java`

```java
private boolean syncContacts = true;  // Enabled by default

UserConfig.getInstance(this.currentAccount).syncContacts = this.syncContacts;
```

Contact import uses Telegram's TLRPC protocol:

```java
TLRPC$TL_contacts_importContacts tLRPC$TL_contacts_importContacts =
    new TLRPC$TL_contacts_importContacts();
tLRPC$TL_contacts_importContacts.contacts.add(tLRPC$TL_inputPhoneContact);
```

---

## MXB Status

**Shad is NOT connected to MXB.**

Historical context:
- April 4, 2020: Shad initially required one of Bale/Soroush/Gap/iGap/Rubika
- April 9, 2020: Released as standalone application
- No MXB helper classes found in current version

---

## Educational-Specific Features

### Live Streaming Classes

```java
public enum CallType {
    Voice,
    Video,
    CallOut    // External call-out capability
}
```

### Features for Education

From app description strings:
- Live streaming with interactive two-way communication
- Online exams and assignment management
- Attendance tracking
- Polls and surveys
- High-quality video/image sharing
- Shadbin (safe search engine for students)
- QR code reader for digital textbooks
- Personal cloud storage
- Accessibility tools for visually impaired

---

## Comparison with Bale/Eitaa

| Feature | Shad | Bale | Eitaa |
|---------|------|------|-------|
| **Call Stack** | Telegram WebRTC | LiveKit (SFU) | Linphone (SIP) |
| **Native Lib** | libtmessages.38.so | liblkjingle*.so | liblinphone.so |
| **P2P** | Disabled | Disabled | Disabled |
| **MXB** | No | Yes (gRPC) | Yes (TLRPC) |
| **Telegram Version** | 38 | 45 | 40 |
| **Operator** | MCI/Ministry of Ed | Bank Mellat | Private/IRIB |
| **Users** | 34M (students) | ~10M | ~15M |
| **Emulator Detection** | Yes | Yes (root) | Yes |

---

## Privacy Implications for Students

### Critical Concerns

1. **Minor Users**: Primary user base is K-12 students (ages 6-18)
2. **Contact Harvesting**: Syncs children's contact lists by default
3. **Behavioral Tracking**: Firebase Crashlytics logs user actions
4. **No P2P**: All communications route through government infrastructure
5. **Location Data**: App likely has location permissions for attendance
6. **Usage Metrics**: Dedicated usage tracking endpoint (shusage.iranlms.ir)

### Data Collection on Minors

The centralized architecture combined with:
- Contact syncing
- Firebase analytics
- Crash reporting with device info
- Usage tracking endpoint

...creates comprehensive behavioral profiles of Iranian students.

---

## Technical Notes

### Architecture Pattern

Shad follows the same Telegram-fork pattern as Bale and Eitaa, with customizations for:
- Educational workflows (exams, attendance, assignments)
- Live streaming for virtual classrooms
- Integration with Ministry of Education systems

### Version Comparison

| App | Telegram Base | Year |
|-----|---------------|------|
| Shad | 38 | ~2020 |
| Eitaa | 40 | ~2021 |
| Bale | 45 | ~2023 |

---

## Evidence Integrity

```
SHA-256 Checksum:
ade8d0d4511caa63f0d62075e99e39126b5a907a01986ee5575c82dc5748a384  shad.apk
```
