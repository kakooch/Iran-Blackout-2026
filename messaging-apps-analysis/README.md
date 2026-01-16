# Iranian Messaging Apps - Protocol & Infrastructure Analysis

**Investigation Date:** January 15-16, 2026
**Classification:** OSINT / Forensic Technical Analysis
**Subject:** Bale, Eitaa & Shad Messengers

---

## Executive Summary

This analysis documents the network architecture, video call protocols, and server infrastructure of Iran's three primary state-aligned messaging applications: **Bale**, **Eitaa**, and **Shad** (the educational platform with 34M users, primarily students).

### Key Findings

| Finding | Bale | Eitaa | Shad |
|---------|------|-------|------|
| **Video Call Protocol** | WebRTC (LiveKit SFU) | SIP (Linphone SDK) | WebRTC (Telegram) + SIP |
| **P2P Capability** | No - Centralized | No - Centralized | No - Centralized |
| **Hosting** | AS48159 (TIC) | AS202798 (Own ASN) | iranlms.ir (MCI) |
| **XMPP Usage** | None | None | None |
| **Telegram Fork** | Yes (v45) | Yes (v40) | Yes (v38) |
| **DNS Handling** | Custom (dnsjava) + **Telemetry** | OS default | OS default |
| **Device Fingerprinting** | Build.SERIAL + AppMetrica | IMEI via ACRA | Firebase Crashlytics |
| **MXB Connected** | Yes (gRPC) | Yes (TLRPC) | No (Standalone) |
| **Anti-Analysis** | Root detection | Emulator detection | Emulator detection |

**None of these applications use peer-to-peer connections.** All media traffic routes through centralized Iranian infrastructure, enabling potential state-level interception.

### Surveillance Indicators

All three apps contain code patterns indicating extensive user monitoring:

- **Eitaa:** Collects device IMEI with every crash report, persistent contact observer, emulator detection
- **Bale:** Device serial collection, Yandex AppMetrica analytics, Sentry behavioral monitoring, Firebase remote commands, **DNS query telemetry** (reports domains to `health.ble.ir`)
- **Shad:** Firebase Crashlytics for crash/behavior reporting, contact syncing enabled by default, emulator detection, usage tracking endpoint

> **Note on Bale DNS Telemetry:** Bale implements custom DNS resolution and reports connection domains to a Bale-controlled endpoint (`2.189.68.149`). This telemetry is **app-internal only** (not system-wide) and does not capture external links clicked in chat. See [Surveillance Analysis](docs/surveillance-analysis.md) for details.

---

## Documentation

| Document | Description |
|----------|-------------|
| [Bale Protocol Analysis](docs/bale-protocol.md) | LiveKit/WebRTC stack, server inventory, cert pinning |
| [Eitaa Protocol Analysis](docs/eitaa-protocol.md) | Linphone/SIP stack, ASN details, TLS configuration |
| [Shad Protocol Analysis](docs/shad-protocol.md) | Educational platform, student data, MCI infrastructure |
| [Infrastructure Mapping](docs/infrastructure.md) | Full AS topology, IP allocation, peering relationships |
| [Surveillance Analysis](docs/surveillance-analysis.md) | Device fingerprinting, data exfiltration, analytics |
| [MXB Protocol](docs/mxb-protocol.md) | Message Exchange Bus - cross-app interoperability protocol |
| [Reproduction Methodology](docs/methodology.md) | Step-by-step guide to reproduce this analysis |

---

## Reproduction

To reproduce this analysis, see the full [Methodology Guide](docs/methodology.md).

### Quick Start

```bash
# Install tools
brew install jadx apktool    # macOS
# apt install jadx apktool   # Linux

# Download APKs
curl -L -o bale.apk "https://bale.ai/apk/bale.apk"
curl -L -o eitaa.apk "https://storage.apk.live/ir.eitaa.messenger--24571.apk"
curl -L -o shad.apk "https://storage.apk.live/ir.medu.shad--355.apk"

# Verify checksums
echo "26786339f1844f0347f77954ecf1fc64ead6b50e2cd370471ad2a7960617a6c0  bale.apk" | shasum -a 256 -c
echo "f9dcd28ddb923d85e44c7f9ef7dec011763a7985e23e877da34feda7d27994c9  eitaa.apk" | shasum -a 256 -c
echo "ade8d0d4511caa63f0d62075e99e39126b5a907a01986ee5575c82dc5748a384  shad.apk" | shasum -a 256 -c

# Decompile
jadx -d bale_java bale.apk
jadx -d eitaa_java eitaa.apk
jadx -d shad_java shad.apk

# Search for protocols
grep -r "livekit\|LiveKit" bale_java/sources/       # Bale: LiveKit
grep -r "linphone\|Linphone" eitaa_java/sources/    # Eitaa: Linphone
grep -r "webrtc\|WebRTC" shad_java/sources/         # Shad: Telegram WebRTC
```

---

## Directory Structure

```
messaging-apps-analysis/
├── README.md                        # This file
├── docs/
│   ├── bale-protocol.md             # Bale technical analysis
│   ├── eitaa-protocol.md            # Eitaa technical analysis
│   ├── shad-protocol.md             # Shad educational platform analysis
│   ├── infrastructure.md            # Network infrastructure mapping
│   ├── surveillance-analysis.md     # Privacy/surveillance findings
│   ├── mxb-protocol.md              # MXB cross-app protocol
│   └── methodology.md               # Reproduction instructions
└── evidence/
    ├── bale.apk                     # Original APK (58MB)
    ├── eitaa.apk                    # Original APK (37MB)
    ├── shad.apk                     # Original APK (77MB)
    ├── checksums.txt                # SHA-256 verification hashes
    ├── native-libs.txt              # Extracted native library listing
    └── code-snippets.md             # Key code evidence
```

---

## Protocol Stack Comparison

```
┌─────────────────────────────────────────────────────────────┐
│                        BALE                                  │
├─────────────────────────────────────────────────────────────┤
│  Application    │  Bale Messenger (ir.nasim)                │
│  Signaling      │  LiveKit Protocol (Protobuf)              │
│  Media          │  WebRTC (DTLS-SRTP)                       │
│  Architecture   │  SFU (Selective Forwarding Unit)          │
│  Native Lib     │  liblkjingle_peerconnection_so.so (11.7MB)│
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                       EITAA                                  │
├─────────────────────────────────────────────────────────────┤
│  Application    │  Eitaa Messenger (ir.eitaa)               │
│  Signaling      │  SIP over TLS                             │
│  Media          │  RTP/SRTP                                 │
│  Architecture   │  Centralized SIP Proxy                    │
│  Native Lib     │  liblinphone.so (8.0MB)                   │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                        SHAD                                  │
├─────────────────────────────────────────────────────────────┤
│  Application    │  Shad Messenger (ir.medu.shad)            │
│  Signaling      │  Telegram Protocol + SIP CallOut          │
│  Media          │  WebRTC (bundled in libtmessages)         │
│  Architecture   │  Centralized Relay (P2P disabled)         │
│  Native Lib     │  libtmessages.38.so (Telegram v38)        │
│  Special        │  34M users (primarily students)           │
└─────────────────────────────────────────────────────────────┘
```

---

## Infrastructure Overview

```
┌─────────────────────────────────────────────────────────────┐
│                    AS48159 (TIC-AS)                          │
│            Telecommunication Infrastructure Co.              │
│                   (State Backbone)                           │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  BALE SERVERS (2.189.68.0/24)                       │    │
│  │  • api.bale.ai          → 2.189.68.126              │    │
│  │  • rpc-ssl*.bale.ai     → 2.189.68.117              │    │
│  │  • siloo.bale.ai        → 2.189.68.109              │    │
│  │  • video*-siloo.ble.ir  → 2.189.68.94-99            │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│                  AS202798 (EITAA-MESSENGER)                  │
│                     (Own Autonomous System)                  │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  EITAA SERVERS (2.189.58.0/24)                      │    │
│  │  • eitaa.com            → 2.189.58.6                │    │
│  │  • dev3.eitaa.com       → 2.189.58.5                │    │
│  │  • armita.eitaa.com     → 2.189.58.27               │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│               IRANLMS.IR (MCI/Ministry of Education)         │
│                  Operated by Hamrah-e-Aval                   │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  SHAD SERVERS (8 Load-Balanced)                     │    │
│  │  • shadmessenger3-10.iranlms.ir  → Messenger        │    │
│  │  • shservices.iranlms.ir         → Services API     │    │
│  │  • shusage.iranlms.ir            → Usage Tracking   │    │
│  │  • shad.ir                       → Public Website   │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

For complete infrastructure details, see [Infrastructure Mapping](docs/infrastructure.md).

---

## Implications

1. **No End-to-End Encryption Guarantee**: Centralized architecture allows server-side decryption
2. **Full State Visibility**: Traffic passes through government-controlled infrastructure
3. **No International Redundancy**: 100% domestic hosting with no CDN presence outside Iran
4. **Cross-App Surveillance**: MXB enables querying user presence across all 7 Iranian messengers
5. **Persistent Device Tracking**: IMEI/serial collection survives app reinstalls and account changes
6. **Anti-Analysis Features**: Emulator and root detection suggest awareness of security scrutiny

### MXB (Message Exchange Bus)

Both apps implement Iran's national cross-messenger protocol, connecting:

See [MXB Protocol](docs/mxb-protocol.md) for detailed code analysis.

---

## Evidence Integrity

All evidence files include SHA-256 checksums for verification.

```
SHA-256 Checksums:
26786339f1844f0347f77954ecf1fc64ead6b50e2cd370471ad2a7960617a6c0  bale.apk
f9dcd28ddb923d85e44c7f9ef7dec011763a7985e23e877da34feda7d27994c9  eitaa.apk
ade8d0d4511caa63f0d62075e99e39126b5a907a01986ee5575c82dc5748a384  shad.apk
```

See [evidence/checksums.txt](evidence/checksums.txt) for verification file.

---

## License

This research is provided for academic, journalistic, and human rights documentation purposes.
