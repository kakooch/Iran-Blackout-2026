# Eitaa Messenger - Technical Protocol Analysis

**Package:** `ir.eitaa`
**Version:** 6.3.7
**APK Size:** 39,289,079 bytes
**Source:** https://storage.apk.live/ir.eitaa.messenger--24571.apk

---

## 1. Video/Voice Call Architecture

### 1.1 Protocol Stack

Eitaa implements video calling using **Linphone SDK**, a SIP-based VoIP stack.

| Layer | Technology |
|-------|------------|
| Signaling | SIP (Session Initiation Protocol) |
| Transport Security | TLS (bundled certificates) |
| Media Transport | RTP/SRTP |
| Architecture | Centralized SIP Proxy |

### 1.2 Native Libraries

```
lib/arm64-v8a/
├── libtmessages.40.so     20,481,436 bytes  Telegram-derived
├── liblinphone.so          8,058,844 bytes  Linphone SIP core
├── libmediastreamer.so     2,112,248 bytes  Media processing
├── libbctoolbox.so           617,968 bytes  BC toolkit
├── libc++_shared.so          610,016 bytes  C++ stdlib
├── libmswebrtc.so            270,052 bytes  WebRTC modules
├── libjsoncpp.so             160,948 bytes  JSON parsing
├── libortp.so                151,184 bytes  RTP transport
├── libsrtp2.so               151,076 bytes  SRTP encryption
├── librtmp-jni.so             63,004 bytes  RTMP support
└── libmsaaudio.so             23,880 bytes  Android audio
```

### 1.3 Code Evidence

Linphone initialization from `CallOutSingleton.java`:

```java
CallOutSingleton.this.factory = Factory.instance();
CallOutSingleton.this.factory.setDebugMode(false, "Linphone");
CallOutSingleton.this.core = factory.createCore(null, null, context);

// TLS certificate configuration
String cert = copyAssetToInternalStorage("cotlsLong.crt");
String key = copyAssetToInternalStorage("cotlsLong.key");
core.setTlsCertPath(cert);
core.setTlsKeyPath(key);
```

Call state handling from `CallOutCoreService.java`:

```java
@Override // org.linphone.core.CoreListenerStub
public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
    if (state == Call.State.End || state == Call.State.Error || state == Call.State.Connected) {
        // Handle call state change
    }
}
```

### 1.4 Architecture Diagram

```
┌─────────────┐         ┌─────────────────────┐         ┌─────────────┐
│   User A    │   SIP   │   SIP Proxy         │   SIP   │   User B    │
│   (Eitaa)   │◄───────►│   (Centralized)     │◄───────►│   (Eitaa)   │
│             │   TLS   │                     │   TLS   │             │
└─────────────┘         └─────────────────────┘         └─────────────┘
       │                         │                             │
       │                         ▼                             │
       │                ┌─────────────────────┐                │
       │                │   Media Relay       │                │
       └───────────────►│   (RTP/SRTP)        │◄───────────────┘
             Media      └─────────────────────┘      Media
```

---

## 2. Server Infrastructure

### 2.1 ASN Information

| Field | Value |
|-------|-------|
| ASN | AS202798 |
| Name | EITAA-MESSENGER |
| Organization | Eitaa Messenger |
| Country | IR |
| IP Range | 2.189.58.0/24 |
| Registration Date | April 17, 2023 |

**Note:** Eitaa operates its own Autonomous System - unusual for a messaging application.

### 2.2 Server Inventory

| Hostname | IP Address | Purpose |
|----------|------------|---------|
| eitaa.com | 2.189.58.6 | Main website/API |
| dev3.eitaa.com | 2.189.58.5 | Backend API / Crash reports |
| armita.eitaa.com | 2.189.58.27 | Alternate backend |
| search.eitaa.com | - | Search service |
| maps.eitaa.com | - | Map tiles (OSM-based) |
| pay.eitaa.com | - | Payment service |

### 2.3 Telemetry Endpoints

```
http://www.tsms.ir/eitaa/log.php           - Logging
https://dev3.eitaa.com/eitaa/Log/Crash_Reports.php  - Crash reports
```

### 2.4 API Endpoints

```java
public static String URL = "https://dev3.eitaa.com/eitaa/index.php";
// Fallback:
"https://armita.eitaa.com/eitaa/index.php"
```

---

## 3. TLS Certificates

Eitaa bundles TLS certificates for SIP transport:

| Asset | Purpose |
|-------|---------|
| `cotlsLong.crt` | TLS certificate for SIP |
| `cotlsLong.key` | TLS private key |

These are copied from APK assets to internal storage at runtime.

---

## 4. Telegram Derivation

Evidence of Telegram fork:
- Native library: `libtmessages.40.so` (20.4MB - largest library)
- TGLR (Telegram Layer) protocol structures
- ConnectionsManager class architecture
- MTProto-style data center handling

---

## 5. Message Exchange Bus (MXB)

Eitaa is part of Iran's **Message Exchange Bus**, enabling cross-platform communication with:
- Bale
- Soroush
- Rubika
- Gap
- iGap

Combined user base: ~100 million users

---

## 6. App Store Status

| Store | Status |
|-------|--------|
| Google Play | Removed |
| Apple App Store | Removed |
| Cafe Bazaar | Available |
| Myket | Available |
| Direct APK | Available |

Removal due to US sanctions compliance by Google/Apple.

---

## 7. PCAP Capture Considerations

| Traffic Type | Encryption | Visibility |
|--------------|------------|------------|
| SIP Signaling | TLS (bundled certs) | Metadata only |
| Media | SRTP | Encrypted |
| Registration | TLS | Metadata only |

To decrypt:
1. Extract bundled certificates from APK assets
2. Bypass certificate pinning via Frida
3. Extract SRTP master keys at runtime

---

## 8. Key Findings

1. **NOT P2P**: SIP architecture routes all calls through centralized proxy
2. **NOT XMPP**: Uses SIP protocol, not XMPP/Jingle
3. **Own ASN**: Operates AS202798 - significant infrastructure investment
4. **Telegram Fork**: Heavily based on Telegram source
5. **Bundled Certs**: TLS certificates embedded in APK
6. **MXB Connected**: Interoperates with all Iranian messaging platforms
