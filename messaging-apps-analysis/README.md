# Iranian Messaging Apps - Protocol & Infrastructure Analysis

**Investigation Date:** January 15, 2026
**Classification:** OSINT / Forensic Technical Analysis
**Subject:** Bale Messenger & Eitaa Messenger

---

## Executive Summary

This analysis documents the network architecture, video call protocols, and server infrastructure of Iran's two primary state-aligned messaging applications: **Bale** and **Eitaa**.

### Key Findings

| Finding | Bale | Eitaa |
|---------|------|-------|
| **Video Call Protocol** | WebRTC (LiveKit SFU) | SIP (Linphone SDK) |
| **P2P Capability** | No - Centralized | No - Centralized |
| **Hosting ASN** | AS48159 (TIC - State Backbone) | AS202798 (Own ASN) |
| **XMPP Usage** | None | None |
| **Telegram Fork** | Yes | Yes |

**Neither application uses peer-to-peer connections.** All media traffic routes through centralized Iranian infrastructure, enabling potential state-level interception.

---

## Methodology

1. APK acquisition from official sources
2. Static analysis via jadx/apktool decompilation
3. Native library identification
4. Server endpoint extraction from certificate pinning configs
5. ASN/WHOIS infrastructure mapping

---

## Directory Structure

```
messaging-apps-analysis/
├── README.md                    # This file
├── docs/
│   ├── bale-protocol.md         # Bale technical analysis
│   ├── eitaa-protocol.md        # Eitaa technical analysis
│   └── infrastructure.md        # Network infrastructure mapping
└── evidence/
    ├── bale.apk                 # Original APK (58MB)
    ├── eitaa.apk                # Original APK (37MB)
    ├── checksums.txt            # SHA-256 verification hashes
    └── native-libs.txt          # Extracted native library listing
```

---

## Quick Reference

### Protocol Stack Comparison

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
```

### Infrastructure Overview

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
```

---

## Implications

1. **No End-to-End Encryption Guarantee**: Centralized architecture allows server-side decryption
2. **Full State Visibility**: Traffic passes through government-controlled infrastructure
3. **No International Redundancy**: 100% domestic hosting with no CDN presence outside Iran
4. **Interoperability**: Both apps connected via MXB (Message Exchange Bus) to other Iranian messengers

---

## Evidence Integrity

All evidence files include SHA-256 checksums for verification. See `evidence/checksums.txt`.

---

## License

This research is provided for academic, journalistic, and human rights documentation purposes.
