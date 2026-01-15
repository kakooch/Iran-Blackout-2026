# Bale Messenger - Technical Protocol Analysis

**Package:** `ir.nasim` (obfuscated)
**Version:** January 2026 build
**APK Size:** 58,064,688 bytes
**Source:** https://bale.ai/apk/bale.apk

---

## 1. Video/Voice Call Architecture

### 1.1 Protocol Stack

Bale implements video calling using **LiveKit**, a WebRTC-based Selective Forwarding Unit (SFU) platform.

| Layer | Technology |
|-------|------------|
| Signaling | LiveKit Protocol (Protobuf-based) |
| Media Transport | WebRTC |
| Encryption | DTLS-SRTP |
| Architecture | Centralized SFU |

### 1.2 Native Libraries

```
lib/arm64-v8a/
├── liblkjingle_peerconnection_so.so  11,764,784 bytes  LiveKit WebRTC
├── libtmessages.45.so                 5,808,320 bytes  Telegram-derived
├── libsentry.so                         704,344 bytes  Error tracking
├── libsentry-android.so                  16,832 bytes  Sentry Android
├── libimage_processing_util_jni.so       29,008 bytes  Camera utils
├── libsurface_util_jni.so                 4,832 bytes  Surface utils
└── libandroidx.graphics.path.so          10,096 bytes  Graphics
```

### 1.3 Code Evidence

LiveKit integration identified via import statements:

```java
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoTrack;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.ScreenCapturerAndroid;
```

Call management logging:

```java
C19406qI3.a("LiveKitCall2", "Reconnected", ...);
C19406qI3.a("LiveKitCall2", "participant " + sid + " connection quality is " + quality);
```

### 1.4 Architecture Diagram

```
┌─────────────┐         ┌─────────────────────┐         ┌─────────────┐
│   User A    │         │   LiveKit SFU       │         │   User B    │
│   (Bale)    │◄───────►│   Media Server      │◄───────►│   (Bale)    │
│             │  WebRTC │   (Centralized)     │  WebRTC │             │
└─────────────┘         └─────────────────────┘         └─────────────┘
                               ▲
                               │ LiveKit Protocol
                               │ (Signaling)
                               ▼
                        ┌─────────────────────┐
                        │   Bale Backend      │
                        │   (ble.ir)          │
                        └─────────────────────┘
```

---

## 2. Server Infrastructure

### 2.1 ASN Information

| Field | Value |
|-------|-------|
| ASN | AS48159 |
| Name | TIC-AS |
| Organization | Telecommunication Infrastructure Company of Iran |
| Country | IR |
| IP Range | 2.189.68.0/24 |

### 2.2 Server Inventory

Extracted from certificate pinning configuration in `C22580vU2.java`:

| Hostname | IP Address | Purpose |
|----------|------------|---------|
| bale.ai | 2.189.68.126 | Main website |
| api.bale.ai | 2.189.68.126 | API gateway |
| rpc-ssl.bale.ai | 2.189.68.126 | RPC over TLS |
| rpc-ssl-c001.bale.ai | 2.189.68.117 | RPC cluster node 1 |
| rpc-ssl-c002.bale.ai | 2.189.68.117 | RPC cluster node 2 |
| ep.bale.ai | 2.189.68.126 | Endpoint service |
| web.bale.ai | 2.189.68.126 | Web interface |
| hash.bale.ai | 2.189.68.126 | Hash/verification |
| assets.bale.ai | 2.189.68.126 | Static assets |
| tooshle.bale.ai | 2.189.68.126 | Business services |
| siloo.bale.ai | 2.189.68.109 | File storage |
| download-siloo.ble.ir | 2.189.68.94 | File downloads |
| download2-siloo.ble.ir | 2.189.68.98 | Download node 2 |
| download3-siloo.ble.ir | 2.189.68.99 | Download node 3 |
| video-siloo.ble.ir | 2.189.68.94 | Video streaming |
| video2-siloo.ble.ir | 2.189.68.98 | Video node 2 |
| video3-siloo.ble.ir | 2.189.68.99 | Video node 3 |
| arbaeen.ble.ir | 2.189.68.122 | Arbaeen pilgrimage |

### 2.3 DNS Check Endpoint

Internal DNS verification:
```
https://2.189.68.149:443/dnscheck
```

### 2.4 Fallback DNS Resolvers

```
185.136.96.111  - ClouDNS (Bulgaria)
185.136.98.111  - ClouDNS (Bulgaria)
1.1.1.1         - Cloudflare
8.8.8.8         - Google
9.9.9.9         - Quad9
```

### 2.5 Payment Integration

| Service | IP | ASN |
|---------|-----|-----|
| nasim-bam.sadad.co.ir | 89.235.65.214 | AS39571 (SADAD-AS) |
| sadad.shaparak.ir | 185.203.160.31 | AS205837 (SADADPSP-AS) |

---

## 3. Certificate Pinning

Bale implements certificate pinning with SHA-256 hashes for all critical endpoints.

Example pinned hashes:
```
6d9ba5c5c665b0a7066682a05329f2a9c4c11aa08c9c548ebd33b9d06bf6e444
edcc33d96085ef35b168f2412af949c8bd1fe41d808013a68b1b93b0978f67e3
d9c1b36333f01c913a734a2df19b1947f826ce298874f0a2efced2e7f228159b
```

---

## 4. Telegram Derivation

Evidence of Telegram fork:
- Native library: `libtmessages.45.so` (5.8MB)
- MTProto-style connection handling
- Similar message/update structures

---

## 5. PCAP Capture Considerations

| Traffic Type | Encryption | Visibility |
|--------------|------------|------------|
| Signaling | TLS 1.3 | Metadata only |
| Media | DTLS-SRTP | Encrypted |
| Key Exchange | DTLS | Encrypted |

To decrypt: Requires SRTP master key extraction via runtime hooking (Frida).

---

## 6. Key Findings

1. **NOT P2P**: All media routes through LiveKit SFU servers
2. **NOT XMPP**: No XMPP/Jingle evidence found
3. **State Infrastructure**: Hosted on TIC (government backbone)
4. **Telegram Fork**: Based on Telegram source code
5. **Full Pinning**: Certificate pinning prevents simple MITM
