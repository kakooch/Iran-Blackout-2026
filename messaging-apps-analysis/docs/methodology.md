# Reproduction Methodology

This document provides step-by-step instructions to reproduce the analysis.

---

## 1. Environment Setup

### 1.1 Required Tools

```bash
# macOS (Homebrew)
brew install jadx apktool

# Linux (Debian/Ubuntu)
sudo apt install jadx apktool

# Verify installation
jadx --version
apktool --version
```

### 1.2 Optional Tools

```bash
# For dynamic analysis
pip install frida-tools
pip install mitmproxy

# For network lookups
# (Usually pre-installed on Unix systems)
which dig whois
```

---

## 2. APK Acquisition

### 2.1 Bale Messenger

```bash
# Official source
curl -L -o bale.apk "https://bale.ai/apk/bale.apk"

# Verify download
shasum -a 256 bale.apk
# Expected (as of 2026-01-15):
# 26786339f1844f0347f77954ecf1fc64ead6b50e2cd370471ad2a7960617a6c0
```

### 2.2 Eitaa Messenger

```bash
# Third-party mirror (app removed from Play Store)
curl -L -o eitaa.apk "https://storage.apk.live/ir.eitaa.messenger--24571.apk"

# Verify download
shasum -a 256 eitaa.apk
# Expected (as of 2026-01-15):
# f9dcd28ddb923d85e44c7f9ef7dec011763a7985e23e877da34feda7d27994c9
```

**Note:** APK versions may change. Adjust download URLs accordingly.

---

## 3. Static Analysis

### 3.1 Decompile to Java Source

```bash
# Bale
jadx -d bale_java bale.apk

# Eitaa
jadx -d eitaa_java eitaa.apk
```

Expected output: Java source code in `sources/` subdirectory.

### 3.2 Extract Resources and Native Libraries

```bash
# Bale
apktool d bale.apk -o bale_unpacked

# Eitaa
apktool d eitaa.apk -o eitaa_unpacked
```

### 3.3 List Native Libraries

```bash
ls -la bale_unpacked/lib/arm64-v8a/
ls -la eitaa_unpacked/lib/arm64-v8a/
```

---

## 4. Protocol Identification

### 4.1 Search for WebRTC/LiveKit (Bale)

```bash
grep -r "webrtc\|WebRTC\|org\.webrtc" bale_java/sources/
grep -r "livekit\|LiveKit" bale_java/sources/
```

Expected findings:
- `livekit.org.webrtc.*` imports
- `LivekitModels$*` protobuf classes
- `liblkjingle_peerconnection_so.so` in native libs

### 4.2 Search for Linphone/SIP (Eitaa)

```bash
grep -r "linphone\|Linphone\|org\.linphone" eitaa_java/sources/
grep -r "sip:\|SIP\|CoreListener" eitaa_java/sources/
```

Expected findings:
- `org.linphone.core.*` imports
- `Factory.instance()` calls
- `liblinphone.so` in native libs

---

## 5. Server Infrastructure Discovery

### 5.1 Extract Hardcoded Endpoints

```bash
# Search for domains
grep -rE "https?://[a-zA-Z0-9.-]+\.(ir|com|ai)" bale_java/sources/ | head -50
grep -rE "https?://[a-zA-Z0-9.-]+\.(ir|com)" eitaa_java/sources/ | head -50

# Search for IP addresses
grep -rE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\b" bale_java/sources/ | grep -v "0\.0\.0\.0"
```

### 5.2 Certificate Pinning Configuration (Bale)

```bash
# The certificate pinning config contains full server inventory
grep -A 200 "known_ip" bale_java/sources/ir/nasim/C22580vU2.java
```

### 5.3 DNS Lookups

```bash
# Bale domains
for d in ble.ir bale.ai api.bale.ai; do
  echo "=== $d ==="
  dig +short $d A
done

# Eitaa domains
for d in eitaa.com dev3.eitaa.com armita.eitaa.com; do
  echo "=== $d ==="
  dig +short $d A
done
```

### 5.4 ASN Lookups

```bash
# Using Team Cymru's WHOIS service
whois -h whois.cymru.com " -v 2.189.68.126"
whois -h whois.cymru.com " -v 2.189.58.6"
```

---

## 6. Expected Results Summary

### 6.1 Bale

| Check | Expected Result |
|-------|-----------------|
| WebRTC library | `liblkjingle_peerconnection_so.so` present |
| LiveKit imports | `livekit.org.webrtc.*` in source |
| Server ASN | AS48159 (TIC-AS) |
| IP range | 2.189.68.0/24 |

### 6.2 Eitaa

| Check | Expected Result |
|-------|-----------------|
| Linphone library | `liblinphone.so` present |
| SIP imports | `org.linphone.core.*` in source |
| Server ASN | AS202798 (EITAA-MESSENGER) |
| IP range | 2.189.58.0/24 |

---

## 7. Troubleshooting

### 7.1 jadx Errors

Minor decompilation errors are normal for obfuscated code:
```
ERROR - finished with errors, count: XX
```

This does not affect analysis of successfully decompiled classes.

### 7.2 APK Download Issues

If official sources are blocked:
1. Use a VPN with Iranian exit node
2. Try alternative mirrors (Cafe Bazaar, Myket)
3. Extract from an Android device with `adb pull`

### 7.3 DNS Resolution from Outside Iran

Some Iranian domains may not resolve from international DNS:
```bash
# Try using Google DNS
dig @8.8.8.8 eitaa.com A
```

---

## 8. Additional Analysis (Optional)

### 8.1 Dynamic Analysis with Frida

```bash
# Install Frida on rooted Android device/emulator
adb shell "su -c 'frida-server &'"

# Hook SSL/TLS to bypass pinning
frida -U -l ssl_bypass.js -f ir.nasim

# Hook Linphone to capture SIP signaling
frida -U -l linphone_hook.js -f ir.eitaa
```

### 8.2 Traffic Capture

```bash
# Start mitmproxy
mitmproxy --mode regular@8080

# Configure Android emulator to use proxy
# Install mitmproxy CA certificate on device
```

---

## 9. Version Information

| Tool | Version Used |
|------|--------------|
| jadx | 1.5.3 |
| apktool | 2.12.1 |
| OpenJDK | 25.0.1 |
| macOS | Darwin 24.6.0 |

---

## 10. Data Preservation

For forensic integrity:

```bash
# Generate checksums immediately after download
shasum -a 256 *.apk > checksums.txt

# Preserve download timestamps
ls -la --time-style=full-iso *.apk

# Archive with metadata
tar -cvzf evidence_$(date +%Y%m%d).tar.gz *.apk checksums.txt
```
