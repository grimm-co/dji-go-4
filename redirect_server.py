# This code hosts a server that can be used to serve an APK file
# for the Weibo SDK application installer
from http.server import SimpleHTTPRequestHandler, HTTPServer

PORT = 8888
IP_ADDRESS = '192.168.1.129'

class RedirectHandler(SimpleHTTPRequestHandler):
	def do_GET(self):
		filename = self.path.split("?")[0]
		if filename == "/":
			self.send_response(301)
			self.send_header('Location', 'http://{}:{}/haven.apk'.format(IP_ADDRESS, PORT))
			self.end_headers()
		else:
			return SimpleHTTPRequestHandler.do_GET(self)

server = HTTPServer((IP_ADDRESS, PORT), RedirectHandler)
server.serve_forever()
