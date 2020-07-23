# This code will decode an obfuscated string inside the DJI GO 4 application
import sys
import base64

KEY = b"Y*IBg^Yd"

def keyed_xor(string, key):
	result = ""
	unpacked = base64.b64decode(string)
	for i in range(len(unpacked)):
		result += chr(unpacked[i] ^ key[i%len(key)])
	return result

key = KEY
if len(sys.argv) > 2:
	key = bytes([ord(x) for x in sys.argv[2]])

print(keyed_xor(sys.argv[1], key))
