# This code will encode a string to match those inside the DJI GO 4 application
import sys
import base64

KEY = b"Y*IBg^Yd"

def keyed_xor(string, key):
	result = []
	unpacked = bytes([ord(x) for x in string])
	for i in range(len(unpacked)):
		result.append(unpacked[i] ^ key[i%len(key)])
	return bytes(result)

key = KEY
if len(sys.argv) > 2:
	key = bytes([ord(x) for x in sys.argv[2]])

print(''.join([chr(x) for x in base64.b64encode(keyed_xor(sys.argv[1], key))]))
