#!/usr/bin/env python3
"""
RIPE Atlas measurement creation and retrieval for Iran Internet research.

Key findings from research:
- Iran has 0 active user probes as of 2026-01-15 (probe 25407 disconnected today)
- Iran has 12 active ANCHORS that can be targeted from external probes
- Anchors are in: Tehran, Mashhad, Shiraz, Isfahan, Kerman, Qom

Active Iranian Anchors (as targets):
- ir-thr-as12697.anchors.atlas.ripe.net (46.249.96.2) - Tehran, Parsun
- ir-thr-as44285.anchors.atlas.ripe.net (185.18.215.214) - Tehran, Sefroyek
- ir-thr-as59441.anchors.atlas.ripe.net (193.3.231.158) - Tehran, HostIran
- ir-mhd-as58224-client.anchors.atlas.ripe.net (85.185.93.118) - Mashhad, TCI
- ir-syz-as58224-client.anchors.atlas.ripe.net (151.232.60.39) - Shiraz, TCI

Usage:
    export RIPE_ATLAS_API_KEY="your-api-key"
    python ripe_atlas.py --action list-anchors
    python ripe_atlas.py --action create-ping --target 85.185.93.118
    python ripe_atlas.py --action get-results --msm-id 12345678
"""
import requests
import argparse
import json
import os
import sys
from datetime import datetime

class RIPEAtlas:
    """RIPE Atlas API wrapper for Iran internet research."""

    BASE_URL = "https://atlas.ripe.net/api/v2"

    # Active Iranian anchors (is_disabled=false) as of 2026-01-15
    IRAN_ANCHORS = {
        "ir-thr-as12697": {"ip": "46.249.96.2", "asn": 12697, "city": "Tehran", "company": "Parsun"},
        "ir-thr-as204203": {"ip": "185.229.133.6", "asn": 204203, "city": "Tehran", "company": "Sepehr-DC"},
        "ir-thr-as39650": {"ip": "185.229.28.6", "asn": 39650, "city": "Tehran", "company": "Atrin"},
        "ir-thr-as44285": {"ip": "185.18.215.214", "asn": 44285, "city": "Tehran", "company": "Sefroyek"},
        "ir-thr-as44531": {"ip": "185.150.109.32", "asn": 44531, "city": "Tehran", "company": "Rayanmehr"},
        "ir-thr-as47376": {"ip": "103.215.221.211", "asn": 47376, "city": "Tehran", "company": "Arianet"},
        "ir-thr-as59441": {"ip": "193.3.231.158", "asn": 59441, "city": "Tehran", "company": "HostIran"},
        "ir-mhd-as58224-client": {"ip": "85.185.93.118", "asn": 58224, "city": "Mashhad", "company": "TCI"},
        "ir-syz-as58224-client": {"ip": "151.232.60.39", "asn": 58224, "city": "Shiraz", "company": "TCI"},
        "ir-ifn-as49556": {"ip": "80.244.7.34", "asn": 49556, "city": "Isfahan", "company": "Webdade"},
        "ir-ker-as201150-client": {"ip": "46.249.122.98", "asn": 201150, "city": "Kerman", "company": "Didehban"},
        "ir-qum-as48147": {"ip": "185.142.156.40", "asn": 48147, "city": "Qom", "company": "Amin IDC"},
    }

    # ArvanCloud IP ranges
    ARVANCLOUD_IPS = ["185.220.0.1", "185.143.232.1", "193.176.240.1"]

    def __init__(self, api_key=None):
        self.api_key = api_key or os.environ.get('RIPE_ATLAS_API_KEY')
        if not self.api_key:
            print("[!] Warning: No API key set. Read-only operations only.")
        self.session = requests.Session()
        self.session.headers.update({
            'Content-Type': 'application/json',
            'User-Agent': 'IranInternetResearch/1.0'
        })
        if self.api_key:
            self.session.headers['Authorization'] = f'Key {self.api_key}'

    def create_measurement(self, measurement_def, probes_spec, description, oneoff=True):
        """Create a new measurement."""
        if not self.api_key:
            raise ValueError("API key required to create measurements")

        payload = {
            "definitions": [measurement_def],
            "probes": [probes_spec],
            "is_oneoff": oneoff
        }

        resp = self.session.post(f"{self.BASE_URL}/measurements/", json=payload)

        if resp.status_code in (200, 201):
            result = resp.json()
            msm_ids = result.get('measurements', [])
            print(f"[+] Created measurement(s): {msm_ids}")
            return msm_ids
        else:
            print(f"[!] Failed to create measurement: {resp.status_code}")
            print(f"    {resp.text[:500]}")
            return None

    def create_ping(self, target_ip, description, probe_count=50, area="WW"):
        """Create ping measurement to target from global probes."""
        measurement_def = {
            "target": target_ip,
            "af": 4,
            "packets": 3,
            "size": 48,
            "type": "ping",
            "description": description
        }
        probes_spec = {
            "requested": probe_count,
            "type": "area",
            "value": area
        }
        return self.create_measurement(measurement_def, probes_spec, description)

    def create_traceroute(self, target_ip, description, probe_count=50, area="WW"):
        """Create traceroute measurement to target from global probes."""
        measurement_def = {
            "target": target_ip,
            "af": 4,
            "type": "traceroute",
            "protocol": "ICMP",
            "packets": 3,
            "max_hops": 32,
            "description": description
        }
        probes_spec = {
            "requested": probe_count,
            "type": "area",
            "value": area
        }
        return self.create_measurement(measurement_def, probes_spec, description)

    def create_dns(self, target_resolver, query_domain, description, probe_count=50, area="WW"):
        """Create DNS measurement."""
        measurement_def = {
            "target": target_resolver,
            "af": 4,
            "type": "dns",
            "query_class": "IN",
            "query_type": "A",
            "query_argument": query_domain,
            "use_probe_resolver": False,
            "description": description
        }
        probes_spec = {
            "requested": probe_count,
            "type": "area",
            "value": area
        }
        return self.create_measurement(measurement_def, probes_spec, description)

    def create_sslcert(self, target_ip, sni_hostname, description, port=443, probe_count=50, area="WW"):
        """Create SSL certificate measurement."""
        measurement_def = {
            "target": target_ip,
            "af": 4,
            "type": "sslcert",
            "port": port,
            "hostname": sni_hostname,
            "description": description
        }
        probes_spec = {
            "requested": probe_count,
            "type": "area",
            "value": area
        }
        return self.create_measurement(measurement_def, probes_spec, description)

    def get_results(self, measurement_id, limit=100):
        """Fetch measurement results."""
        resp = self.session.get(
            f"{self.BASE_URL}/measurements/{measurement_id}/results/",
            params={"limit": limit}
        )
        if resp.status_code == 200:
            return resp.json()
        else:
            print(f"[!] Failed to get results: {resp.status_code}")
            return None

    def get_measurement_info(self, measurement_id):
        """Get measurement metadata."""
        resp = self.session.get(f"{self.BASE_URL}/measurements/{measurement_id}/")
        if resp.status_code == 200:
            return resp.json()
        return None

    def list_iran_probes(self, status=None):
        """List all probes in Iran."""
        params = {"country_code": "IR"}
        if status:
            params["status"] = status

        resp = self.session.get(f"{self.BASE_URL}/probes/", params=params)
        if resp.status_code == 200:
            return resp.json()
        return None

    def list_iran_anchors(self, only_active=True):
        """List anchors in Iran."""
        resp = self.session.get(f"{self.BASE_URL}/anchors/", params={"country": "IR"})
        if resp.status_code != 200:
            return None

        data = resp.json()
        anchors = data.get('results', [])

        if only_active:
            anchors = [a for a in anchors if not a.get('is_disabled', True)]

        return anchors

    def check_credits(self):
        """Check credit balance."""
        resp = self.session.get(f"{self.BASE_URL}/credits/")
        if resp.status_code == 200:
            return resp.json()
        return None


def save_results(data, filename, base_dir="investigation/data/atlas"):
    """Save results to JSON file."""
    os.makedirs(base_dir, exist_ok=True)
    filepath = os.path.join(base_dir, filename)
    with open(filepath, 'w') as f:
        json.dump(data, f, indent=2)
    print(f"[+] Saved results to {filepath}")


def main():
    parser = argparse.ArgumentParser(description="RIPE Atlas Iran Research Tool")
    parser.add_argument("--action", required=True,
                        choices=["list-anchors", "list-probes", "create-ping",
                                 "create-traceroute", "create-dns", "create-sslcert",
                                 "get-results", "check-credits", "ping-all-anchors"])
    parser.add_argument("--target", help="Target IP address")
    parser.add_argument("--msm-id", help="Measurement ID for get-results")
    parser.add_argument("--domain", help="Domain for DNS query")
    parser.add_argument("--sni", help="SNI hostname for SSL cert")
    parser.add_argument("--probes", type=int, default=50, help="Number of probes")

    args = parser.parse_args()

    atlas = RIPEAtlas()

    if args.action == "list-anchors":
        anchors = atlas.list_iran_anchors(only_active=True)
        if anchors:
            print(f"\n[+] Active Iranian Anchors ({len(anchors)}):\n")
            for a in anchors:
                print(f"  {a['hostname']:<30} | {a['ip_v4']:<18} | AS{a['as_v4']:<6} | {a['city']}")

    elif args.action == "list-probes":
        probes = atlas.list_iran_probes()
        if probes:
            active = [p for p in probes.get('results', []) if p.get('status', {}).get('id') == 1]
            print(f"[+] Total probes in Iran: {probes.get('count', 0)}")
            print(f"[+] Active probes: {len(active)}")
            for p in active[:10]:
                print(f"  Probe {p['id']}: AS{p.get('asn_v4', 'N/A')} - {p.get('description', 'No description')}")

    elif args.action == "create-ping":
        if not args.target:
            print("[!] --target required")
            sys.exit(1)
        atlas.create_ping(args.target, f"Ping to {args.target} from global", args.probes)

    elif args.action == "create-traceroute":
        if not args.target:
            print("[!] --target required")
            sys.exit(1)
        atlas.create_traceroute(args.target, f"Traceroute to {args.target}", args.probes)

    elif args.action == "create-dns":
        if not args.target or not args.domain:
            print("[!] --target (resolver) and --domain required")
            sys.exit(1)
        atlas.create_dns(args.target, args.domain, f"DNS {args.domain} via {args.target}", args.probes)

    elif args.action == "create-sslcert":
        if not args.target or not args.sni:
            print("[!] --target and --sni required")
            sys.exit(1)
        atlas.create_sslcert(args.target, args.sni, f"SSL to {args.target} with SNI {args.sni}", args.probes)

    elif args.action == "get-results":
        if not args.msm_id:
            print("[!] --msm-id required")
            sys.exit(1)
        results = atlas.get_results(args.msm_id)
        if results:
            timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
            save_results(results, f"msm_{args.msm_id}_{timestamp}.json")
            print(f"[+] Got {len(results)} results")

    elif args.action == "check-credits":
        credits = atlas.check_credits()
        if credits:
            print(f"[+] Credits: {json.dumps(credits, indent=2)}")

    elif args.action == "ping-all-anchors":
        print("[*] Creating ping measurements to all active Iranian anchors...")
        for name, info in atlas.IRAN_ANCHORS.items():
            desc = f"Ping {info['city']} ({info['company']}) AS{info['asn']}"
            result = atlas.create_ping(info['ip'], desc, probe_count=30)
            if result:
                print(f"  [+] {name}: measurement {result}")


if __name__ == "__main__":
    main()
